package com.z.sharding.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@MapperScan("com.z.sharding.mapper") // 扫描你的 Mapper 接口
public class MyBatisConfig {

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        // 如果你有 XML mapper 文件
        factoryBean.setMapperLocations(
                new org.springframework.core.io.support.PathMatchingResourcePatternResolver()
                        .getResources("classpath:mapper/*Mapper.xml")
        );
        return factoryBean.getObject();
    }
}
