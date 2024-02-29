-- 用户表
CREATE TABLE IF NOT EXISTS `t_user` (
    `id` bigint NOT NULL COMMENT '主键',
    `username` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '用户名',
    `password` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '密码',
    `nicknam` varchar(255) DEFAULT NULL COMMENT '昵称',
    `gender` varchar(255) DEFAULT NULL COMMENT '性别',
    `address` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '地址',
    `age` int DEFAULT NULL COMMENT '年龄',
    `email` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '邮件地址',
    `phone` varchar(255) DEFAULT NULL COMMENT '电话',
    `birthday` date DEFAULT NULL COMMENT '生日',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
    `created_by` bigint DEFAULT NULL COMMENT '创建人',
    `updated_by` bigint DEFAULT NULL COMMENT '更新人',
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- 产品表
CREATE TABLE IF NOT EXISTS `t_product` (
    `id` bigint NOT NULL COMMENT '主键ID',
    `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '产品名称',
    `description` varchar(255) DEFAULT NULL COMMENT '产品描述',
    `price` decimal(10,2) DEFAULT NULL COMMENT '产品价格',
    `stock` int DEFAULT NULL COMMENT '产品库存',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
    `created_by` bigint DEFAULT NULL COMMENT '创建人',
    `updated_by` bigint DEFAULT NULL COMMENT '更新人',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- 订单表
CREATE TABLE IF NOT EXISTS `t_order` (
    `id` bigint NOT NULL COMMENT '主键ID',
    `user_id` bigint NOT NULL COMMENT '订单中用户ID',
    `total_amount` decimal(10,2) NOT NULL COMMENT '订单总金额',
    `order_date` datetime NOT NULL COMMENT '订单日期',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
    `created_by` bigint DEFAULT NULL COMMENT '创建人',
    `updated_by` bigint DEFAULT NULL COMMENT '更新人',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- 订单明细表
CREATE TABLE IF NOT EXISTS `t_order_item` (
    `id` bigint NOT NULL,
    `order_id` bigint DEFAULT NULL COMMENT '订单ID',
    `product_id` bigint DEFAULT NULL COMMENT '产品ID',
    `product_quantity` int DEFAULT NULL COMMENT '产品数量',
    `product_price` decimal(10,2) DEFAULT NULL COMMENT '产品价格',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
    `created_by` bigint DEFAULT NULL COMMENT '创建人',
    `updated_by` bigint DEFAULT NULL COMMENT '更新人',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
