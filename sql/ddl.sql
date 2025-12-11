-- ds_0.idempotent_record definition

CREATE TABLE `idempotent_record` (
  `msg_key` varchar(128) NOT NULL COMMENT 'Kafka message key or unique business ID',
  `order_id` bigint NOT NULL COMMENT '对应订单ID',
  `processed` tinyint NOT NULL DEFAULT '1' COMMENT '1 = 已处理',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`msg_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- ds_0.outbound_message definition

CREATE TABLE `outbound_message` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `biz_key` varchar(200) NOT NULL,
  `version` bigint NOT NULL,
  `topic` varchar(100) NOT NULL,
  `status` tinyint NOT NULL DEFAULT '0',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `user_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- ds_0.region definition

CREATE TABLE `region` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- ds_0.t_order_0 definition

CREATE TABLE `t_order_0` (
  `order_id` bigint NOT NULL COMMENT '订单ID',
  `user_id` varchar(64) NOT NULL COMMENT '用户ID',
  `region_code` varchar(32) DEFAULT NULL COMMENT '地区编码',
  `total_amount` decimal(10,2) DEFAULT NULL COMMENT '总金额',
  `status` int DEFAULT '0' COMMENT '订单状态',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `version` bigint DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- ds_0.t_order_1 definition

CREATE TABLE `t_order_1` (
  `order_id` bigint NOT NULL COMMENT '订单ID',
  `user_id` varchar(64) NOT NULL COMMENT '用户ID',
  `region_code` varchar(32) DEFAULT NULL COMMENT '地区编码',
  `total_amount` decimal(10,2) DEFAULT NULL COMMENT '总金额',
  `status` int DEFAULT '0' COMMENT '订单状态',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `version` bigint DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- ds_0.t_order_2 definition

CREATE TABLE `t_order_2` (
  `order_id` bigint NOT NULL COMMENT '订单ID',
  `user_id` varchar(64) NOT NULL COMMENT '用户ID',
  `region_code` varchar(32) DEFAULT NULL COMMENT '地区编码',
  `total_amount` decimal(10,2) DEFAULT NULL COMMENT '总金额',
  `status` int DEFAULT '0' COMMENT '订单状态',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `version` bigint DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- ds_0.t_order_3 definition

CREATE TABLE `t_order_3` (
  `order_id` bigint NOT NULL COMMENT '订单ID',
  `user_id` varchar(64) NOT NULL COMMENT '用户ID',
  `region_code` varchar(32) DEFAULT NULL COMMENT '地区编码',
  `total_amount` decimal(10,2) DEFAULT NULL COMMENT '总金额',
  `status` int DEFAULT '0' COMMENT '订单状态',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `version` bigint DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- ds_0.t_order_4 definition

CREATE TABLE `t_order_4` (
  `order_id` bigint NOT NULL COMMENT '订单ID',
  `user_id` varchar(64) NOT NULL COMMENT '用户ID',
  `region_code` varchar(32) DEFAULT NULL COMMENT '地区编码',
  `total_amount` decimal(10,2) DEFAULT NULL COMMENT '总金额',
  `status` int DEFAULT '0' COMMENT '订单状态',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `version` bigint DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- ds_0.t_order_5 definition

CREATE TABLE `t_order_5` (
  `order_id` bigint NOT NULL COMMENT '订单ID',
  `user_id` varchar(64) NOT NULL COMMENT '用户ID',
  `region_code` varchar(32) DEFAULT NULL COMMENT '地区编码',
  `total_amount` decimal(10,2) DEFAULT NULL COMMENT '总金额',
  `status` int DEFAULT '0' COMMENT '订单状态',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `version` bigint DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- ds_0.t_order_6 definition

CREATE TABLE `t_order_6` (
  `order_id` bigint NOT NULL COMMENT '订单ID',
  `user_id` varchar(64) NOT NULL COMMENT '用户ID',
  `region_code` varchar(32) DEFAULT NULL COMMENT '地区编码',
  `total_amount` decimal(10,2) DEFAULT NULL COMMENT '总金额',
  `status` int DEFAULT '0' COMMENT '订单状态',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `version` bigint DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- ds_0.t_order_7 definition

CREATE TABLE `t_order_7` (
  `order_id` bigint NOT NULL COMMENT '订单ID',
  `user_id` varchar(64) NOT NULL COMMENT '用户ID',
  `region_code` varchar(32) DEFAULT NULL COMMENT '地区编码',
  `total_amount` decimal(10,2) DEFAULT NULL COMMENT '总金额',
  `status` int DEFAULT '0' COMMENT '订单状态',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `version` bigint DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- ds_0.t_order_item_0 definition

CREATE TABLE `t_order_item_0` (
  `item_id` varchar(64) NOT NULL,
  `order_id` bigint NOT NULL COMMENT '订单ID',
  `user_id` varchar(64) NOT NULL COMMENT '用户ID',
  `good_id` bigint NOT NULL COMMENT '商品ID',
  `good_name_snapshot` varchar(255) DEFAULT NULL COMMENT '商品名快照',
  `good_price_snapshot` decimal(10,2) DEFAULT NULL COMMENT '商品价格快照',
  `good_image_snapshot` varchar(255) DEFAULT NULL COMMENT '商品图片快照',
  `attributes_snapshot_json` text COMMENT '商品属性快照(JSON)',
  `quantity` int NOT NULL COMMENT '数量',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `item_index` int DEFAULT NULL,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `version` bigint DEFAULT NULL,
  PRIMARY KEY (`item_id`),
  KEY `idx_order_id` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- ds_0.t_order_item_1 definition

CREATE TABLE `t_order_item_1` (
  `item_id` varchar(64) NOT NULL,
  `order_id` bigint NOT NULL COMMENT '订单ID',
  `user_id` varchar(64) NOT NULL COMMENT '用户ID',
  `good_id` bigint NOT NULL COMMENT '商品ID',
  `good_name_snapshot` varchar(255) DEFAULT NULL COMMENT '商品名快照',
  `good_price_snapshot` decimal(10,2) DEFAULT NULL COMMENT '商品价格快照',
  `good_image_snapshot` varchar(255) DEFAULT NULL COMMENT '商品图片快照',
  `attributes_snapshot_json` text COMMENT '商品属性快照(JSON)',
  `quantity` int NOT NULL COMMENT '数量',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `item_index` int DEFAULT NULL,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `version` bigint DEFAULT NULL,
  PRIMARY KEY (`item_id`),
  KEY `idx_order_id` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- ds_0.t_order_item_2 definition

CREATE TABLE `t_order_item_2` (
  `item_id` varchar(64) NOT NULL,
  `order_id` bigint NOT NULL COMMENT '订单ID',
  `user_id` varchar(64) NOT NULL COMMENT '用户ID',
  `good_id` bigint NOT NULL COMMENT '商品ID',
  `good_name_snapshot` varchar(255) DEFAULT NULL COMMENT '商品名快照',
  `good_price_snapshot` decimal(10,2) DEFAULT NULL COMMENT '商品价格快照',
  `good_image_snapshot` varchar(255) DEFAULT NULL COMMENT '商品图片快照',
  `attributes_snapshot_json` text COMMENT '商品属性快照(JSON)',
  `quantity` int NOT NULL COMMENT '数量',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `item_index` int DEFAULT NULL,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `version` bigint DEFAULT NULL,
  PRIMARY KEY (`item_id`),
  KEY `idx_order_id` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- ds_0.t_order_item_3 definition

CREATE TABLE `t_order_item_3` (
  `item_id` varchar(64) NOT NULL,
  `order_id` bigint NOT NULL COMMENT '订单ID',
  `user_id` varchar(64) NOT NULL COMMENT '用户ID',
  `good_id` bigint NOT NULL COMMENT '商品ID',
  `good_name_snapshot` varchar(255) DEFAULT NULL COMMENT '商品名快照',
  `good_price_snapshot` decimal(10,2) DEFAULT NULL COMMENT '商品价格快照',
  `good_image_snapshot` varchar(255) DEFAULT NULL COMMENT '商品图片快照',
  `attributes_snapshot_json` text COMMENT '商品属性快照(JSON)',
  `quantity` int NOT NULL COMMENT '数量',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `item_index` int DEFAULT NULL,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `version` bigint DEFAULT NULL,
  PRIMARY KEY (`item_id`),
  KEY `idx_order_id` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- ds_0.t_order_item_4 definition

CREATE TABLE `t_order_item_4` (
  `item_id` varchar(64) NOT NULL,
  `order_id` bigint NOT NULL COMMENT '订单ID',
  `user_id` varchar(64) NOT NULL COMMENT '用户ID',
  `good_id` bigint NOT NULL COMMENT '商品ID',
  `good_name_snapshot` varchar(255) DEFAULT NULL COMMENT '商品名快照',
  `good_price_snapshot` decimal(10,2) DEFAULT NULL COMMENT '商品价格快照',
  `good_image_snapshot` varchar(255) DEFAULT NULL COMMENT '商品图片快照',
  `attributes_snapshot_json` text COMMENT '商品属性快照(JSON)',
  `quantity` int NOT NULL COMMENT '数量',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `item_index` int DEFAULT NULL,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `version` bigint DEFAULT NULL,
  PRIMARY KEY (`item_id`),
  KEY `idx_order_id` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- ds_0.t_order_item_5 definition

CREATE TABLE `t_order_item_5` (
  `item_id` varchar(64) NOT NULL,
  `order_id` bigint NOT NULL COMMENT '订单ID',
  `user_id` varchar(64) NOT NULL COMMENT '用户ID',
  `good_id` bigint NOT NULL COMMENT '商品ID',
  `good_name_snapshot` varchar(255) DEFAULT NULL COMMENT '商品名快照',
  `good_price_snapshot` decimal(10,2) DEFAULT NULL COMMENT '商品价格快照',
  `good_image_snapshot` varchar(255) DEFAULT NULL COMMENT '商品图片快照',
  `attributes_snapshot_json` text COMMENT '商品属性快照(JSON)',
  `quantity` int NOT NULL COMMENT '数量',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `item_index` int DEFAULT NULL,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `version` bigint DEFAULT NULL,
  PRIMARY KEY (`item_id`),
  KEY `idx_order_id` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- ds_0.t_order_item_6 definition

CREATE TABLE `t_order_item_6` (
  `item_id` varchar(64) NOT NULL,
  `order_id` bigint NOT NULL COMMENT '订单ID',
  `user_id` varchar(64) NOT NULL COMMENT '用户ID',
  `good_id` bigint NOT NULL COMMENT '商品ID',
  `good_name_snapshot` varchar(255) DEFAULT NULL COMMENT '商品名快照',
  `good_price_snapshot` decimal(10,2) DEFAULT NULL COMMENT '商品价格快照',
  `good_image_snapshot` varchar(255) DEFAULT NULL COMMENT '商品图片快照',
  `attributes_snapshot_json` text COMMENT '商品属性快照(JSON)',
  `quantity` int NOT NULL COMMENT '数量',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `item_index` int DEFAULT NULL,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `version` bigint DEFAULT NULL,
  PRIMARY KEY (`item_id`),
  KEY `idx_order_id` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- ds_0.t_order_item_7 definition

CREATE TABLE `t_order_item_7` (
  `item_id` varchar(64) NOT NULL,
  `order_id` bigint NOT NULL COMMENT '订单ID',
  `user_id` varchar(64) NOT NULL COMMENT '用户ID',
  `good_id` bigint NOT NULL COMMENT '商品ID',
  `good_name_snapshot` varchar(255) DEFAULT NULL COMMENT '商品名快照',
  `good_price_snapshot` decimal(10,2) DEFAULT NULL COMMENT '商品价格快照',
  `good_image_snapshot` varchar(255) DEFAULT NULL COMMENT '商品图片快照',
  `attributes_snapshot_json` text COMMENT '商品属性快照(JSON)',
  `quantity` int NOT NULL COMMENT '数量',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `item_index` int DEFAULT NULL,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `version` bigint DEFAULT NULL,
  PRIMARY KEY (`item_id`),
  KEY `idx_order_id` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- ds_0.t_user_0 definition

CREATE TABLE `t_user_0` (
  `user_id` varchar(64) NOT NULL,
  `name` varchar(64) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(128) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `sex` varchar(16) DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `version` bigint DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- ds_0.t_user_1 definition

CREATE TABLE `t_user_1` (
  `user_id` varchar(64) NOT NULL,
  `name` varchar(64) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(128) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `sex` varchar(16) DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `version` bigint DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- ds_0.t_user_2 definition

CREATE TABLE `t_user_2` (
  `user_id` varchar(64) NOT NULL,
  `name` varchar(64) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(128) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `sex` varchar(16) DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `version` bigint DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- ds_0.t_user_3 definition

CREATE TABLE `t_user_3` (
  `user_id` varchar(64) NOT NULL,
  `name` varchar(64) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(128) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `sex` varchar(16) DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `version` bigint DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- ds_0.t_user_4 definition

CREATE TABLE `t_user_4` (
  `user_id` varchar(64) NOT NULL,
  `name` varchar(64) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(128) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `sex` varchar(16) DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `version` bigint DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- ds_0.t_user_5 definition

CREATE TABLE `t_user_5` (
  `user_id` varchar(64) NOT NULL,
  `name` varchar(64) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(128) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `sex` varchar(16) DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `version` bigint DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- ds_0.t_user_6 definition

CREATE TABLE `t_user_6` (
  `user_id` varchar(64) NOT NULL,
  `name` varchar(64) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(128) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `sex` varchar(16) DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `version` bigint DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- ds_0.t_user_7 definition

CREATE TABLE `t_user_7` (
  `user_id` varchar(64) NOT NULL,
  `name` varchar(64) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(128) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `sex` varchar(16) DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `version` bigint DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;