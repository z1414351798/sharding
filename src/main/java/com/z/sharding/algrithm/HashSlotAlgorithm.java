package com.z.sharding.algrithm;

import com.z.sharding.util.CRC32Util;
import com.z.sharding.util.SnowflakeIdUtil;
import org.apache.shardingsphere.sharding.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.sharding.api.sharding.complex.ComplexKeysShardingValue;
import org.apache.shardingsphere.infra.config.algorithm.ShardingSphereAlgorithm;

import java.util.*;

public class HashSlotAlgorithm implements ComplexKeysShardingAlgorithm<Comparable<?>>, ShardingSphereAlgorithm {

    private Properties props = new Properties();

    // 主键列名（Snowflake ID）
    private static final String PRIMARY_KEY = "order_id";

    // 分片键 user_id
    private static final String USER_ID_KEY = "user_id";

    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames,
                                         ComplexKeysShardingValue<Comparable<?>> shardingValue) {

        int count = availableTargetNames.size();
        Object[] targets = availableTargetNames.toArray();

        // ① 优先用主键 order_id 精准路由
        List<Comparable<?>> idValues = getShardingValues(shardingValue, PRIMARY_KEY);
        if (!idValues.isEmpty()) {
            List<String> result = new ArrayList<>();
            for (Comparable<?> idValue : idValues) {
                long id = toLong(idValue);
                int workerId = SnowflakeIdUtil.getWorkerId(id);
                int index = workerId % count;
                result.add((String) targets[index]);
            }
            return result;
        }

        // ② 如果带 user_id，也能精准路由
        List<Comparable<?>> userIds = getShardingValues(shardingValue, USER_ID_KEY);
        if (!userIds.isEmpty()) {
            List<String> result = new ArrayList<>();
            for (Comparable<?> uidValue : userIds) {
                String uid = uidValue.toString();  // 保持 String
                int slot = Math.floorMod(CRC32Util.hash(uid), 1024);
                int index = slot % count;
                result.add((String) targets[index]);
            }
            return result;
        }

        // ③ fallback：无法路由 → 全部分片
        return availableTargetNames;
    }

    /** 将 Comparable<?> 转为 long，仅用于 id */
    private long toLong(Comparable<?> value) {
        if (value instanceof Long) {
            return (Long) value;
        } else if (value instanceof String) {
            return Long.parseLong((String) value);
        } else if (value instanceof Integer) {
            return ((Integer) value).longValue();
        } else {
            throw new IllegalArgumentException("Unsupported sharding value type: " + value.getClass());
        }
    }

    /** 获取字段所有值 */
    private List<Comparable<?>> getShardingValues(ComplexKeysShardingValue<Comparable<?>> shardingValue, String key) {
        List<Comparable<?>> result = new ArrayList<>();
        Map<String, Collection<Comparable<?>>> columnValues = shardingValue.getColumnNameAndShardingValuesMap();
        System.out.println("All sharding columns: " + columnValues);
        if (columnValues.containsKey(key)) {
            result.addAll(columnValues.get(key));
        }
        System.out.println("Sharding values for " + key + ": " + result);
        return result;
    }

    // ================= ShardingSphereAlgorithm 接口方法 =================
    @Override
    public void init(Properties props) {
        this.props = props;
    }

    @Override
    public Properties getProps() {
        return this.props;
    }

    @Override
    public String getType() {
        return "CLASS_BASED";
    }

}
