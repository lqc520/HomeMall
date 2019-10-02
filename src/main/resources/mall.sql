-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: 2019-10-02 10:21:38
-- 服务器版本： 5.7.24-log
-- PHP Version: 7.2.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mall`
--

-- --------------------------------------------------------

--
-- 表的结构 `mall_address`
--

CREATE TABLE `mall_address` (
  `id` int(11) NOT NULL,
  `member_id` int(11) NOT NULL COMMENT '用户id',
  `receiver` varchar(255) NOT NULL COMMENT '收件人',
  `mobile` varchar(255) NOT NULL COMMENT '收件人手机',
  `address` varchar(255) NOT NULL COMMENT '收件地址',
  `is_default` int(1) NOT NULL DEFAULT '0' COMMENT '是否默认地址 0默认   1不是默认',
  `is_delete` int(1) DEFAULT '0' COMMENT '是否删除 0正常 1删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `mall_banner`
--

CREATE TABLE `mall_banner` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL COMMENT 'banner名称',
  `img` varchar(255) NOT NULL COMMENT '图片地址',
  `sort` int(11) NOT NULL DEFAULT '0' COMMENT '展示顺序',
  `goods_id` int(11) NOT NULL COMMENT '商品id',
  `is_delete` int(1) NOT NULL DEFAULT '0' COMMENT '是否删除 0正常  1删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `mall_card`
--

CREATE TABLE `mall_card` (
  `id` int(11) NOT NULL,
  `member_id` int(11) DEFAULT NULL,
  `goods_id` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL COMMENT '商品名称',
  `color` varchar(255) DEFAULT NULL COMMENT '颜色',
  `avatar` varchar(255) DEFAULT NULL COMMENT '图片',
  `number` varchar(255) DEFAULT NULL COMMENT '数量',
  `price` varchar(10) DEFAULT NULL COMMENT '价格',
  `original` decimal(10,2) DEFAULT NULL COMMENT '原价',
  `stock` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `mall_category`
--

CREATE TABLE `mall_category` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL COMMENT '类目名称',
  `img` varchar(255) NOT NULL COMMENT '类目在楼层展示中的图片',
  `sort` int(11) NOT NULL DEFAULT '0' COMMENT '展示顺序',
  `wid` varchar(11) DEFAULT NULL,
  `is_delete` int(1) NOT NULL DEFAULT '0' COMMENT '是否删除 0正常  1删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `mall_collection`
--

CREATE TABLE `mall_collection` (
  `id` int(11) NOT NULL,
  `member_id` int(11) DEFAULT NULL,
  `goods_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `mall_comment`
--

CREATE TABLE `mall_comment` (
  `id` int(11) NOT NULL,
  `member_id` int(11) DEFAULT NULL,
  `goods_id` int(11) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `star` varchar(255) DEFAULT NULL,
  `create_time` timestamp NOT NULL,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `mall_goods`
--

CREATE TABLE `mall_goods` (
  `id` int(11) NOT NULL,
  `category_id` int(11) NOT NULL DEFAULT '0' COMMENT '商品分类id',
  `sort_id` int(11) DEFAULT NULL,
  `season_id` int(11) DEFAULT '0' COMMENT '季节id 不是所有产品都有季节 1 2 3 4',
  `name` varchar(255) DEFAULT NULL COMMENT '商品名称',
  `introduce` varchar(255) DEFAULT NULL COMMENT '商品简介',
  `price` decimal(10,2) DEFAULT NULL COMMENT '商品价格',
  `stock` int(11) DEFAULT NULL COMMENT '库存',
  `freight` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '运费',
  `img` varchar(255) DEFAULT NULL COMMENT '商品主图片 网站商品列表展示使用',
  `detail_img` text COMMENT '商品详情的图片 可以是多张图片',
  `detail` text COMMENT '商品详情',
  `status` int(1) NOT NULL DEFAULT '0' COMMENT '商品状态 0上架   1下架',
  `is_delete` int(1) NOT NULL DEFAULT '0' COMMENT '是否删除 0正常  1删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `mall_member`
--

CREATE TABLE `mall_member` (
  `id` int(11) NOT NULL,
  `nickname` varchar(255) DEFAULT NULL COMMENT '昵称',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像',
  `mobile` varchar(255) DEFAULT NULL,
  `is_activate` int(255) DEFAULT '1' COMMENT '是否激活  0激活  1未激活',
  `is_delete` int(1) NOT NULL DEFAULT '0' COMMENT '是否删除 0正常   1删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `mall_order`
--

CREATE TABLE `mall_order` (
  `order_number` varchar(255) NOT NULL COMMENT '订单编号',
  `member_id` int(11) NOT NULL COMMENT '下单用户',
  `address_id` int(11) NOT NULL COMMENT '收货地址',
  `payment_amount` decimal(10,2) DEFAULT NULL COMMENT '应付金额',
  `payment_time` timestamp NULL DEFAULT NULL COMMENT '支付时间',
  `freight` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '商品运费',
  `send_time` timestamp NULL DEFAULT NULL COMMENT '发货时间',
  `finish_time` timestamp NULL DEFAULT NULL COMMENT '交易完成时间',
  `cancel_time` timestamp NULL DEFAULT NULL COMMENT '交易关闭时间',
  `order_status` int(1) NOT NULL DEFAULT '0' COMMENT '订单状态 \r\n0 待支付 \r\n1 待发货 \r\n2 待收货 \r\n3 待评价 \r\n4 已完成\r\n5 交易关闭',
  `is_delete` int(1) NOT NULL DEFAULT '0' COMMENT '是否删除 0正常 1删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `mall_order_item`
--

CREATE TABLE `mall_order_item` (
  `id` int(11) NOT NULL,
  `order_number` varchar(255) NOT NULL COMMENT '订单id',
  `goods_id` int(11) NOT NULL COMMENT '商品id',
  `goods_name` varchar(255) NOT NULL COMMENT '商品名称',
  `goods_img` varchar(255) NOT NULL COMMENT '商品图片',
  `goods_color` varchar(255) NOT NULL COMMENT '商品颜色',
  `goods_price` decimal(10,2) NOT NULL COMMENT '生成订单时的商品单价',
  `quantity` int(11) NOT NULL COMMENT '商品数量',
  `is_delete` int(1) NOT NULL DEFAULT '0' COMMENT '是否删除 0正常  1删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `mall_payment`
--

CREATE TABLE `mall_payment` (
  `id` int(11) NOT NULL,
  `member_id` int(11) NOT NULL COMMENT '买家ID',
  `order_number` varchar(255) DEFAULT NULL COMMENT '订单编号',
  `payment_type` int(11) NOT NULL DEFAULT '1' COMMENT '付款方式 1支付宝 2微信支付 ',
  `payment_number` varchar(255) DEFAULT NULL COMMENT '交易流水号',
  `payment_amount` decimal(10,2) DEFAULT NULL COMMENT '交易金额',
  `payment_status` int(1) DEFAULT NULL COMMENT '支付状态\r\n0待支付 \r\n1已支付 \r\n2待退款 \r\n3已退款 \r\n4交易关闭',
  `is_delete` int(1) NOT NULL DEFAULT '0' COMMENT '是否删除 0正常 1删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `mall_promotion`
--

CREATE TABLE `mall_promotion` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL COMMENT '活动名称',
  `img` varchar(255) NOT NULL COMMENT '活动图片',
  `url` varchar(255) NOT NULL COMMENT '活动链接地址',
  `sort` int(11) NOT NULL DEFAULT '0' COMMENT '展示顺序',
  `is_delete` int(1) NOT NULL DEFAULT '0' COMMENT '是否删除 0正常 1删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `mall_sort`
--

CREATE TABLE `mall_sort` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL COMMENT '小分类名称',
  `img` varchar(255) DEFAULT NULL,
  `category_id` int(11) NOT NULL COMMENT '大分类id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `sys_resource`
--

CREATE TABLE `sys_resource` (
  `id` int(20) NOT NULL COMMENT '菜单/按钮ID',
  `parent_id` int(20) NOT NULL COMMENT '上级菜单ID',
  `name` varchar(50) NOT NULL COMMENT '菜单/按钮名称',
  `url` varchar(100) DEFAULT NULL COMMENT '菜单URL',
  `perms` varchar(255) DEFAULT NULL COMMENT '权限标识',
  `icon` varchar(50) DEFAULT NULL COMMENT '图标',
  `type` char(2) NOT NULL COMMENT '类型 0菜单 1按钮 2根节点',
  `sort` bigint(20) DEFAULT NULL COMMENT '排序',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `sys_role`
--

CREATE TABLE `sys_role` (
  `id` int(20) NOT NULL COMMENT '角色ID',
  `name` varchar(100) NOT NULL COMMENT '角色名称',
  `authority` varchar(255) NOT NULL COMMENT '权限',
  `remark` varchar(100) DEFAULT NULL COMMENT '角色描述',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `sys_role_resource`
--

CREATE TABLE `sys_role_resource` (
  `role_id` int(20) NOT NULL COMMENT '角色ID',
  `resource_id` int(20) NOT NULL COMMENT '菜单/按钮ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `sys_user`
--

CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL,
  `mobile` varchar(255) NOT NULL COMMENT '用户名',
  `password` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `state` int(255) DEFAULT '1' COMMENT '0 激活 1 未激活',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像',
  `nickname` varchar(255) NOT NULL,
  `is_delete` int(1) NOT NULL DEFAULT '0' COMMENT '0 正常   1删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `sys_user_role`
--

CREATE TABLE `sys_user_role` (
  `user_id` int(20) NOT NULL COMMENT '用户ID',
  `role_id` int(20) NOT NULL COMMENT '角色ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `mall_address`
--
ALTER TABLE `mall_address`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `mall_banner`
--
ALTER TABLE `mall_banner`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `mall_card`
--
ALTER TABLE `mall_card`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `mall_category`
--
ALTER TABLE `mall_category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `mall_collection`
--
ALTER TABLE `mall_collection`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `mall_comment`
--
ALTER TABLE `mall_comment`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `mall_goods`
--
ALTER TABLE `mall_goods`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `mall_member`
--
ALTER TABLE `mall_member`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `mall_order`
--
ALTER TABLE `mall_order`
  ADD PRIMARY KEY (`order_number`);

--
-- Indexes for table `mall_order_item`
--
ALTER TABLE `mall_order_item`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `mall_payment`
--
ALTER TABLE `mall_payment`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `mall_promotion`
--
ALTER TABLE `mall_promotion`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `mall_sort`
--
ALTER TABLE `mall_sort`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sys_resource`
--
ALTER TABLE `sys_resource`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sys_role`
--
ALTER TABLE `sys_role`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sys_user`
--
ALTER TABLE `sys_user`
  ADD PRIMARY KEY (`id`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `mall_address`
--
ALTER TABLE `mall_address`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- 使用表AUTO_INCREMENT `mall_banner`
--
ALTER TABLE `mall_banner`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- 使用表AUTO_INCREMENT `mall_card`
--
ALTER TABLE `mall_card`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- 使用表AUTO_INCREMENT `mall_category`
--
ALTER TABLE `mall_category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- 使用表AUTO_INCREMENT `mall_collection`
--
ALTER TABLE `mall_collection`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- 使用表AUTO_INCREMENT `mall_comment`
--
ALTER TABLE `mall_comment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- 使用表AUTO_INCREMENT `mall_goods`
--
ALTER TABLE `mall_goods`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=48;

--
-- 使用表AUTO_INCREMENT `mall_member`
--
ALTER TABLE `mall_member`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- 使用表AUTO_INCREMENT `mall_order_item`
--
ALTER TABLE `mall_order_item`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=478;

--
-- 使用表AUTO_INCREMENT `mall_payment`
--
ALTER TABLE `mall_payment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=169;

--
-- 使用表AUTO_INCREMENT `mall_promotion`
--
ALTER TABLE `mall_promotion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- 使用表AUTO_INCREMENT `mall_sort`
--
ALTER TABLE `mall_sort`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- 使用表AUTO_INCREMENT `sys_resource`
--
ALTER TABLE `sys_resource`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '菜单/按钮ID', AUTO_INCREMENT=164;

--
-- 使用表AUTO_INCREMENT `sys_role`
--
ALTER TABLE `sys_role`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '角色ID', AUTO_INCREMENT=4;

--
-- 使用表AUTO_INCREMENT `sys_user`
--
ALTER TABLE `sys_user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
