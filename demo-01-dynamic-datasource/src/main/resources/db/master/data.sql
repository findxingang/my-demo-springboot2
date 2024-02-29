
-- 用户表数据
INSERT INTO `wangdb`.`t_user`(`id`, `username`, `password`, `nicknam`, `gender`, `address`, `age`, `email`, `phone`, `birthday`, `create_time`, `update_time`, `created_by`, `updated_by`) VALUES (1, 'wangxingang', '123456', '维修工', '男', '青岛', 25, 'findxingang@163.com', '15888888888', '1999-03-02', '2024-02-29 13:46:38', '2024-02-29 13:46:43', NULL, NULL);
INSERT INTO `wangdb`.`t_user`(`id`, `username`, `password`, `nicknam`, `gender`, `address`, `age`, `email`, `phone`, `birthday`, `create_time`, `update_time`, `created_by`, `updated_by`) VALUES (2, 'lizhi', '123456', '荔枝', '女', '滨州', 24, 'lizhi@163.com', '18333333333', '2000-01-15', '2024-02-29 13:46:38', '2024-02-29 13:46:43', NULL, NULL);

-- 产品表数据
INSERT INTO `wangdb`.`t_product`(`id`, `name`, `description`, `price`, `stock`, `create_time`, `update_time`, `created_by`, `updated_by`) VALUES (1, '华为 Mate 60', '遥遥领先', 6000.00, 10000, '2024-02-29 13:47:49', '2024-02-29 13:47:52', NULL, NULL);
INSERT INTO `wangdb`.`t_product`(`id`, `name`, `description`, `price`, `stock`, `create_time`, `update_time`, `created_by`, `updated_by`) VALUES (2, 'iPhone 15 pro', '爱国果', 8000.00, 10000, '2024-02-29 13:47:49', '2024-02-29 13:47:52', NULL, NULL);
INSERT INTO `wangdb`.`t_product`(`id`, `name`, `description`, `price`, `stock`, `create_time`, `update_time`, `created_by`, `updated_by`) VALUES (3, '三星 S24 ', '韩国之光', 7000.00, 10000, '2024-02-29 13:47:49', '2024-02-29 13:47:52', NULL, NULL);

-- 订单表
INSERT INTO `wangdb`.`t_order`(`id`, `user_id`, `total_amount`, `order_date`, `create_time`, `update_time`, `created_by`, `updated_by`) VALUES (1, 1, 21000.00, '2024-02-29 13:56:55', NULL, NULL, NULL, NULL);

-- 订单明细表
INSERT INTO `wangdb`.`t_order_item`(`id`, `order_id`, `product_id`, `product_quantity`, `product_price`, `create_time`, `update_time`, `created_by`, `updated_by`) VALUES (1, 1, 1, 1, 6000.00, NULL, NULL, NULL, NULL);
INSERT INTO `wangdb`.`t_order_item`(`id`, `order_id`, `product_id`, `product_quantity`, `product_price`, `create_time`, `update_time`, `created_by`, `updated_by`) VALUES (2, 1, 2, 1, 8000.00, NULL, NULL, NULL, NULL);
INSERT INTO `wangdb`.`t_order_item`(`id`, `order_id`, `product_id`, `product_quantity`, `product_price`, `create_time`, `update_time`, `created_by`, `updated_by`) VALUES (3, 1, 3, 1, 7000.00, NULL, NULL, NULL, NULL);
