

            SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
                            `id` bigint(20) NOT NULL COMMENT 'primary key',
                            `name` varchar(64) COLLATE utf8_bin NOT NULL COMMENT 'category name',
                            `sort` int(11) NOT NULL DEFAULT '0' COMMENT 'order of category',
                            `create_time` datetime NOT NULL COMMENT 'create time',
                            `update_time` datetime NOT NULL COMMENT 'modified time',
                            PRIMARY KEY (`id`) USING BTREE,
                            UNIQUE KEY `idx_category_name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='each product belongs to a category';

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1',  'Coffee', '1', '2021-05-27 09:16:58', '2021-07-15 20:25:23');
INSERT INTO `category` VALUES ('2',  'Tea', '2', '2021-05-27 09:17:07', '2021-06-02 14:27:22');
INSERT INTO `category` VALUES ('3',  'Cold Drinks', '3', '2021-05-27 09:17:28', '2021-07-09 14:37:13');
INSERT INTO `category` VALUES ('4',  'Sweets', '11', '2021-07-09 11:36:15', '2021-07-09 14:39:15');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
                           `id` bigint(20) NOT NULL COMMENT 'primary key',
                           `name` varchar(64) COLLATE utf8_bin NOT NULL COMMENT 'product name',
                           `category_id` bigint(20) NOT NULL COMMENT 'category id',
                           `price` decimal(10,2) DEFAULT NULL COMMENT 'price',
                           `calorie` int(11) NOT NULL DEFAULT '0' COMMENT 'calorie',
                           `image` varchar(200) COLLATE utf8_bin NOT NULL COMMENT 'file path of the image',
                           `description` varchar(400) COLLATE utf8_bin DEFAULT NULL COMMENT 'description of product',
                           `status` int(11) NOT NULL DEFAULT '1' COMMENT '0 not available 1 available',
                           `sort` int(11) NOT NULL DEFAULT '0' COMMENT 'order',
                           `create_time` datetime NOT NULL COMMENT 'create time',
                           `update_time` datetime NOT NULL COMMENT 'modified time',
                           PRIMARY KEY (`id`) USING BTREE,
                           UNIQUE KEY `idx_dish_name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='selling product';

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', 'Americano', '1', '2.50','300', '1.jpg', '', '1', '0', '2021-05-27 09:38:43', '2021-05-27 09:38:43');
INSERT INTO `product` VALUES ('2', 'Cappuccino', '1', '2.50','300', '1.jpg', '', '1', '0', '2021-05-27 09:38:43', '2021-05-27 09:38:43');
INSERT INTO `product` VALUES ('3', 'Espresso', '1', '2.50','300', '1.jpg', '', '1', '0', '2021-05-27 09:38:43', '2021-05-27 09:38:43');
INSERT INTO `product` VALUES ('4', 'Macchiato', '1', '2.80','300', '1.jpg', '', '1', '0', '2021-05-27 09:38:43', '2021-05-27 09:38:43');
INSERT INTO `product` VALUES ('5', 'Latte', '1', '2.80','300', '1.jpg', '', '1', '0', '2021-05-27 09:38:43', '2021-05-27 09:38:43');
INSERT INTO `product` VALUES ('6', 'Mocha', '1', '2.80','300', '1.jpg', '', '1', '0', '2021-05-27 09:38:43', '2021-05-27 09:38:43');
INSERT INTO `product` VALUES ('7', 'Jasmine Tea', '2', '2.80','200', '1.jpg', '', '1', '0', '2021-05-27 09:38:43', '2021-05-27 09:38:43');
INSERT INTO `product` VALUES ('8', 'Green Tea', '2', '2.80','200', '1.jpg', '', '1', '0', '2021-05-27 09:38:43', '2021-05-27 09:38:43');
INSERT INTO `product` VALUES ('9', 'Ginger Tea', '2', '2.80','200', '1.jpg', '', '1', '0', '2021-05-27 09:38:43', '2021-05-27 09:38:43');
INSERT INTO `product` VALUES ('10', 'Black Tea', '2', '2.80','200', '1.jpg', '', '1', '0', '2021-05-27 09:38:43', '2021-05-27 09:38:43');
INSERT INTO `product` VALUES ('11', 'Mango Passionfruit', '3', '3.00','450', '1.jpg', '', '1', '0', '2021-05-27 09:38:43', '2021-05-27 09:38:43');
INSERT INTO `product` VALUES ('12', 'Raspberry Blackcurrant', '3', '3.00','450', '1.jpg', '', '1', '0', '2021-05-27 09:38:43', '2021-05-27 09:38:43');
INSERT INTO `product` VALUES ('13', 'Donut Cookie', '4', '2.80','500', '1.jpg', '', '1', '0', '2021-05-27 09:38:43', '2021-05-27 09:38:43');
INSERT INTO `product` VALUES ('14', 'Caramel Slice', '4', '2.80','500', '1.jpg', '', '1', '0', '2021-05-27 09:38:43', '2021-05-27 09:38:43');

-- ----------------------------
-- Table structure for staff
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff` (
                         `id` bigint(20) NOT NULL COMMENT 'primary key',
                         `name` varchar(32) COLLATE utf8_bin NOT NULL COMMENT 'staff name',
                         `username` varchar(32) COLLATE utf8_bin NOT NULL COMMENT 'user name',
                         `password` varchar(64) COLLATE utf8_bin NOT NULL COMMENT 'password',
                         `phone` varchar(11) COLLATE utf8_bin NOT NULL COMMENT 'mobile number',
                         `gender` varchar(2) COLLATE utf8_bin NOT NULL COMMENT 'gender',
                         `create_time` datetime NOT NULL COMMENT 'create time',
                         `update_time` datetime NOT NULL COMMENT 'modified time',
                         PRIMARY KEY (`id`) USING BTREE,
                         UNIQUE KEY `idx_username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='staff information';

-- ----------------------------
-- Records of staff
-- ----------------------------
INSERT INTO `staff` VALUES ('1', 'admin', 'admin', 'e10adc3949ba59abbe56e057f20f883e', '13812312312', '1', '2021-05-06 17:20:07', '2021-05-10 02:24:09');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
                            `id` bigint(20) NOT NULL COMMENT 'primary key',
                            `username` varchar(32) COLLATE utf8_bin NOT NULL COMMENT 'username',
                            `firstname` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT 'customer name',
                            `lastname` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT 'customer name',
                            `credit` int(11) NOT NULL DEFAULT '0' COMMENT 'accumulated points',
                            `password` varchar(64) COLLATE utf8_bin NOT NULL COMMENT 'password',
                            `phone` varchar(100) COLLATE utf8_bin NOT NULL COMMENT 'mobile number',
                            `email` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT 'email address',
                            `gender` varchar(2) COLLATE utf8_bin DEFAULT NULL COMMENT 'gender',
                            `avatar` varchar(500) COLLATE utf8_bin DEFAULT NULL COMMENT 'file path of the image',
                            `expire_date` datetime COMMENT 'expire time',
                            `create_time` datetime NOT NULL COMMENT 'create time',
                            `update_time` datetime NOT NULL COMMENT 'modified time',
                            PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='customer information';

INSERT INTO `customer` VALUES ('1', 'amber', 'Amber','Fan', '0','e10adc3949ba59abbe56e057f20f883e', '13812312312','amber@soulcafe.com', '1', '','2021-05-10 02:24:09','2021-05-06 17:20:07','2021-05-06 17:20:07');
-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
                          `id` bigint(20) NOT NULL COMMENT 'primary key',
                          `number` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT 'order number',
                          `status` int(11) NOT NULL DEFAULT '1' COMMENT 'order status 1 In progress, 2 Completed, 3 Cancelled',
                          `customer_id` bigint(20) NOT NULL COMMENT 'customer id of the order',
                          `order_time` datetime NOT NULL COMMENT 'order time',
                          `pay_method` int(11) NOT NULL DEFAULT '1' COMMENT 'payment method 1 Debit Card,2 Credit Card,3 Cash',
                          `total` decimal(10,2) NOT NULL COMMENT 'total amount of all products',
                          `remark` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT 'comments',
                          `phone` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                          `customer_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                          `create_time` datetime NOT NULL COMMENT 'create time',
                          `update_time` datetime NOT NULL COMMENT 'modified time',
                          PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='order table';

-- ----------------------------
-- Records of orders
-- ----------------------------

-- ----------------------------
-- Table structure for order_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail` (
                                `id` bigint(20) NOT NULL COMMENT 'primary key',
                                `product_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT 'product name',
                                `image` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT 'product image',
                                `order_id` bigint(20) NOT NULL COMMENT 'order id',
                                `product_id` bigint(20) DEFAULT NULL COMMENT 'product id',
                                `size` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT 'size of product',
                                `extra` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT 'add extra to coffee or flavor',
                                `quantity` int(11) NOT NULL DEFAULT '1' COMMENT 'quantity of one product',
                                `amount` decimal(10,2) NOT NULL COMMENT 'total amount',
                                `create_time` datetime NOT NULL COMMENT 'create time',
                                `update_time` datetime NOT NULL COMMENT 'modified time',
                                PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='product details for one order';

-- ----------------------------
-- Records of order_detail
-- ----------------------------


-- ----------------------------
-- Table structure for shopping_cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
                        `id` bigint(20) NOT NULL COMMENT 'primary key',
                        `product_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT 'product name',
                        `image` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT 'product image',
                        `customer_id` bigint(20) NOT NULL COMMENT 'customer id',
                        `product_id` bigint(20) DEFAULT NULL COMMENT 'product id',
                        `size` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT 'size of product',
                        `extra` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT 'add extra to coffee or flavor',
                        `quantity` int(11) NOT NULL DEFAULT '1' COMMENT 'quantity of one product',
                        `amount` decimal(10,2) NOT NULL COMMENT 'total amount',
                        `create_time` datetime NOT NULL COMMENT 'create time',
                        `update_time` datetime NOT NULL COMMENT 'modified time',
                        PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='shopping cart';

-- ----------------------------
-- Records of shopping_cart
-- ----------------------------
