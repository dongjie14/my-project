/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : qianyide_dev

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2019-03-05 16:29:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_channel_payment_config`
-- ----------------------------
DROP TABLE IF EXISTS `t_channel_payment_config`;
CREATE TABLE `t_channel_payment_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `channel_type` varchar(32) NOT NULL COMMENT '渠道类型',
  `channel_name` varchar(64) DEFAULT NULL COMMENT '渠道名称',
  `channel_server_bean` varchar(128) NOT NULL COMMENT '渠道服务bean',
  `priority` int(11) DEFAULT '0' COMMENT '优先级',
  `loan_quota` decimal(11,2) DEFAULT '0.00' COMMENT '放款额度',
  `eff_time` datetime NOT NULL COMMENT '生效时间',
  `exp_time` datetime NOT NULL COMMENT '失效时间',
  `create_account` varchar(64) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_account` varchar(64) DEFAULT NULL COMMENT '修改人',
  `tm_smp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`),
  UNIQUE KEY `t_channel_loan_config_UI1` (`channel_type`),
  UNIQUE KEY `t_channel_loan_config_UI2` (`channel_server_bean`),
  KEY `t_channel_loan_config_I3` (`eff_time`,`exp_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='代付渠道配置表';

-- ----------------------------
-- Records of t_channel_payment_config
-- ----------------------------

-- ----------------------------
-- Table structure for `t_channel_payment_quota_count`
-- ----------------------------
DROP TABLE IF EXISTS `t_channel_payment_quota_count`;
CREATE TABLE `t_channel_payment_quota_count` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `cut_date` date DEFAULT NULL COMMENT '统计日期',
  `channel_type` varchar(32) DEFAULT NULL COMMENT '渠道类型',
  `payment_amt` decimal(11,2) DEFAULT '0.00' COMMENT '放款金额',
  `tm_xmp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='代付额度统计表';

-- ----------------------------
-- Records of t_channel_payment_quota_count
-- ----------------------------

-- ----------------------------
-- Table structure for `t_channel_withhold_config`
-- ----------------------------
DROP TABLE IF EXISTS `t_channel_withhold_config`;
CREATE TABLE `t_channel_withhold_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `channel_type` varchar(32) NOT NULL COMMENT '渠道类型',
  `channel_name` varchar(64) DEFAULT NULL COMMENT '渠道名称',
  `channel_server_bean` varchar(128) NOT NULL COMMENT '渠道服务bean',
  `priority` int(11) DEFAULT '0' COMMENT '优先级',
  `eff_time` datetime NOT NULL COMMENT '生效时间',
  `exp_time` datetime NOT NULL COMMENT '失效时间',
  `create_account` varchar(64) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_account` varchar(64) DEFAULT NULL COMMENT '修改人',
  `tm_smp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='代扣渠道配置表';

-- ----------------------------
-- Records of t_channel_withhold_config
-- ----------------------------

-- ----------------------------
-- Table structure for `t_channel_withhold_count`
-- ----------------------------
DROP TABLE IF EXISTS `t_channel_withhold_count`;
CREATE TABLE `t_channel_withhold_count` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `cut_date` date DEFAULT NULL COMMENT '统计日期',
  `channel_type` varchar(32) DEFAULT NULL COMMENT '渠道类型',
  `withhold_amt` decimal(11,2) DEFAULT '0.00' COMMENT '代扣金额',
  `tm_xmp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='代扣统计表';

-- ----------------------------
-- Records of t_channel_withhold_count
-- ----------------------------

-- ----------------------------
-- Table structure for `t_message_conf`
-- ----------------------------
DROP TABLE IF EXISTS `t_message_conf`;
CREATE TABLE `t_message_conf` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `msg_no` varchar(32) NOT NULL COMMENT '模板编号',
  `msg_title` varchar(64) DEFAULT NULL COMMENT '短信主题',
  `msg_template` varchar(1024) DEFAULT NULL COMMENT '短信模板',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `tm_smp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`),
  UNIQUE KEY `t_message_conf_UI1` (`msg_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='短信模板表';

-- ----------------------------
-- Records of t_message_conf
-- ----------------------------

-- ----------------------------
-- Table structure for `t_message_record`
-- ----------------------------
DROP TABLE IF EXISTS `t_message_record`;
CREATE TABLE `t_message_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `rec_name` varchar(64) DEFAULT NULL COMMENT '收信人姓名',
  `rec_phone` varchar(11) NOT NULL COMMENT '收信人手机号',
  `rec_user_type` int(2) DEFAULT NULL COMMENT '收信人类型：1-系统管理员，2-普通管理员，3-用户',
  `msg_title` varchar(64) DEFAULT NULL COMMENT '短信标题',
  `msg_content` varchar(1024) DEFAULT NULL COMMENT '短信内容',
  `msg_send_time` datetime DEFAULT NULL COMMENT '短信发送时间',
  `tm_smp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='短信记录表';

-- ----------------------------
-- Records of t_message_record
-- ----------------------------

-- ----------------------------
-- Table structure for `t_pay_borrow_ord`
-- ----------------------------
DROP TABLE IF EXISTS `t_pay_borrow_ord`;
CREATE TABLE `t_pay_borrow_ord` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `borrow_ord_no` varchar(32) NOT NULL COMMENT '借款订单号',
  `user_no` varchar(32) NOT NULL COMMENT '用户编号',
  `user_name` varchar(64) DEFAULT NULL COMMENT '用户姓名',
  `user_phone` varchar(11) DEFAULT NULL COMMENT '用户手机号',
  `user_id_no` varchar(64) DEFAULT NULL COMMENT '身份证号',
  `is_old_loan` int(1) DEFAULT '0' COMMENT '是否老用户借款：0-否，1-是',
  `bank_card_no` varchar(32) DEFAULT NULL COMMENT '收款银行卡号',
  `bank_code` varchar(64) DEFAULT NULL COMMENT '收款银行编码',
  `bank_name` varchar(256) DEFAULT NULL COMMENT '收款银行名称',
  `create_time` datetime DEFAULT NULL COMMENT '申请时间',
  `borrow_amt` decimal(11,2) DEFAULT '0.00' COMMENT '借款金额（单位：元）',
  `auth_fee` decimal(11,2) DEFAULT '0.00' COMMENT '认证费（单位：元）',
  `serve_fee` decimal(11,2) DEFAULT '0.00' COMMENT '服务费（单位：元）',
  `interest_fee` decimal(11,2) DEFAULT '0.00' COMMENT '利息（单位：元）',
  `repayment_period` int(2) DEFAULT NULL COMMENT '还款期数',
  `repayment_cycle` int(1) DEFAULT NULL COMMENT '还款周期：1-周，2-月',
  `installment_rate` decimal(4,2) DEFAULT '0.00' COMMENT '分期费率（单位%/期）',
  `installment_fee` decimal(11,2) DEFAULT '0.00' COMMENT '定额分期费（单位：元/期）',
  `overdue_rate` decimal(4,2) DEFAULT '0.00' COMMENT '逾期费率（单位%）',
  `overdue_fee` decimal(11,2) DEFAULT '0.00' COMMENT '定额逾期费（单位：元/天）',
  `order_sts` int(2) DEFAULT NULL COMMENT '订单状态：1-已提交，2-风控审核中，3-风控审核通过，4-风控审核拒绝，5-人工审核通过，6-人工审核拒绝，7-放款中，8-放款成功，9-放款失败，10-已结清',
  `machine_audit_time` datetime DEFAULT NULL COMMENT '机器审核时间',
  `manual_audit_time` datetime DEFAULT NULL COMMENT '人工审核时间',
  `audit_manage_name` varchar(32) DEFAULT NULL COMMENT '审核管理员',
  `loan_channel` varchar(32) DEFAULT NULL COMMENT '放款渠道',
  `loan_time` datetime DEFAULT NULL COMMENT '放款时间',
  `device_type` varchar(32) DEFAULT NULL COMMENT '设备类型',
  `device_id_code` varchar(256) DEFAULT NULL COMMENT '设备识别码',
  `device_model` varchar(256) DEFAULT NULL COMMENT '设备型号',
  `reserve_field1` varchar(256) DEFAULT NULL COMMENT '预留字段一',
  `reserve_field2` varchar(256) DEFAULT NULL COMMENT '预留字段二',
  `reserve_field3` varchar(256) DEFAULT NULL COMMENT '预留字段三',
  `update_manage_name` varchar(32) DEFAULT NULL COMMENT '更新管理员',
  `tm_smp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`),
  UNIQUE KEY `t_pay_borrow_ord_UI1` (`borrow_ord_no`),
  KEY `t_pay_borrow_ord_I2` (`order_sts`),
  KEY `t_pay_borrow_ord_I3` (`user_no`,`borrow_ord_no`,`order_sts`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='借款订单表';

-- ----------------------------
-- Records of t_pay_borrow_ord
-- ----------------------------

-- ----------------------------
-- Table structure for `t_pay_loan_jnl`
-- ----------------------------
DROP TABLE IF EXISTS `t_pay_loan_jnl`;
CREATE TABLE `t_pay_loan_jnl` (
  `id` int(11) NOT NULL COMMENT '主键ID',
  `borrow_ord_no` varchar(32) NOT NULL COMMENT '借款订单号',
  `loan_jnl_no` varchar(32) NOT NULL COMMENT '放款流水号',
  `user_no` varchar(32) DEFAULT NULL COMMENT '用户编号',
  `user_name` varchar(64) DEFAULT NULL COMMENT '用户姓名',
  `user_phone` varchar(11) DEFAULT NULL COMMENT '用户手机号',
  `user_id_no` varchar(64) DEFAULT NULL COMMENT '身份证号',
  `bank_card_no` varchar(32) DEFAULT NULL COMMENT '收款银行卡号',
  `bank_code` varchar(64) DEFAULT NULL COMMENT '收款银行编码',
  `bank_name` varchar(256) DEFAULT NULL COMMENT '收款银行名称',
  `out_merc_id` varchar(64) DEFAULT NULL COMMENT '第三方渠道商户号',
  `out_term_id` varchar(64) DEFAULT NULL COMMENT '第三方渠道终端号',
  `merc_order_no` varchar(64) DEFAULT NULL COMMENT '商户订单号',
  `req_time` datetime DEFAULT NULL COMMENT '请求时间',
  `loan_amt` decimal(11,2) DEFAULT NULL COMMENT '放款金额',
  `loan_sts` int(2) DEFAULT NULL COMMENT '放款状态：1-初始化，2-处理中，3-代付成功，4-代付失败',
  `loan_channel` varchar(32) DEFAULT NULL COMMENT '放款渠道',
  `rsp_sts` varchar(64) DEFAULT NULL COMMENT '返回状态',
  `rsp_code` varchar(256) DEFAULT NULL COMMENT '返回码',
  `rsp_smg` varchar(512) DEFAULT NULL COMMENT '返回信息',
  `out_order_no` varchar(128) DEFAULT NULL COMMENT '外部订单号',
  `acc_sts` int(2) DEFAULT '1' COMMENT '对账状态：1-未对账，2-对账成功，3-对账失败，4-我方有对方无，5-对方有我方无，6-金额差错',
  `loan_time` datetime DEFAULT NULL COMMENT '放款时间',
  `reserve_field1` varchar(256) DEFAULT NULL COMMENT '预留字段一',
  `reserve_field2` varchar(256) DEFAULT NULL COMMENT '预留字段二',
  `reserve_field3` varchar(256) DEFAULT NULL COMMENT '预留字段三',
  `tm_smp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`),
  UNIQUE KEY `t_pay_loan_jnl_UI1` (`loan_jnl_no`),
  KEY `t_pay_loan_jnl_I2` (`loan_sts`),
  KEY `t_pay_loan_jnl_I3` (`user_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='放款流水表';

-- ----------------------------
-- Records of t_pay_loan_jnl
-- ----------------------------

-- ----------------------------
-- Table structure for `t_pay_repayment_jnl`
-- ----------------------------
DROP TABLE IF EXISTS `t_pay_repayment_jnl`;
CREATE TABLE `t_pay_repayment_jnl` (
  `id` int(11) NOT NULL COMMENT '主键ID',
  `borrow_ord_no` varchar(32) NOT NULL COMMENT '借款订单号',
  `repayment_ord_no` varchar(32) NOT NULL COMMENT '还款订单号',
  `repayment_jnl_no` varchar(32) NOT NULL COMMENT '还款流水号',
  `user_no` varchar(32) NOT NULL COMMENT '用户编号',
  `user_name` varchar(64) DEFAULT NULL COMMENT '用户姓名',
  `user_phone` varchar(11) DEFAULT NULL COMMENT '用户手机号',
  `user_id_no` varchar(64) DEFAULT NULL COMMENT '身份证号',
  `req_time` datetime DEFAULT NULL COMMENT '请求时间',
  `repayment_amt` decimal(11,2) DEFAULT NULL COMMENT '还款金额',
  `repayment_type` int(2) DEFAULT NULL COMMENT '还款方式：1-主动还款，2-代扣，3-后台还款',
  `out_merc_id` varchar(64) DEFAULT NULL COMMENT '第三方渠道商户号',
  `out_term_id` varchar(64) DEFAULT NULL COMMENT '第三方渠道终端号',
  `merc_order_no` varchar(64) DEFAULT NULL COMMENT '商户订单号',
  `repayment_sts` int(2) DEFAULT '1' COMMENT '还款状态：1-初始化，2-处理中，3-还款成功，4-还款失败',
  `repayment_channel` varchar(32) DEFAULT NULL COMMENT '还款渠道',
  `bank_card_no` varchar(32) DEFAULT NULL COMMENT '还款银行卡号',
  `bank_code` varchar(64) DEFAULT NULL COMMENT '还款银行编码',
  `bank_name` varchar(256) DEFAULT NULL COMMENT '还款银行名称',
  `repayment_end_time` datetime DEFAULT NULL COMMENT '还款完成时间',
  `rsp_sts` varchar(64) DEFAULT NULL COMMENT '返回状态',
  `rsp_code` varchar(256) DEFAULT NULL COMMENT '返回码',
  `rsp_msg` varchar(512) DEFAULT NULL COMMENT '返回信息',
  `out_order_no` varchar(128) DEFAULT NULL COMMENT '外部订单号',
  `acc_sts` int(2) DEFAULT '1' COMMENT '对账状态：1-未对账，2-对账成功，3-对账失败，4-我方有对方无，5-对方有我方无，6-金额差错',
  `device_type` varchar(32) DEFAULT NULL COMMENT '设备类型',
  `device_id_code` varchar(256) DEFAULT NULL COMMENT '设备识别码',
  `device_model` varchar(256) DEFAULT NULL COMMENT '设备型号',
  `reserve_field1` varchar(256) DEFAULT NULL COMMENT '预留字段一',
  `reserve_field2` varchar(256) DEFAULT NULL COMMENT '预留字段二',
  `reserve_field3` varchar(256) DEFAULT NULL COMMENT '预留字段三',
  `tm_smp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`),
  UNIQUE KEY `t_pay_repayment_jnl_IU1` (`repayment_jnl_no`),
  KEY `t_pay_repayment_jnl_IU2` (`repayment_sts`),
  KEY `t_pay_repayment_jnl_IU3` (`user_no`),
  KEY `t_pay_repayment_jnl_IU4` (`borrow_ord_no`,`user_no`,`repayment_sts`),
  KEY `t_pay_repayment_jnl_IU5` (`repayment_ord_no`,`user_no`,`repayment_sts`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='还款流水表';

-- ----------------------------
-- Records of t_pay_repayment_jnl
-- ----------------------------

-- ----------------------------
-- Table structure for `t_pay_repayment_ord`
-- ----------------------------
DROP TABLE IF EXISTS `t_pay_repayment_ord`;
CREATE TABLE `t_pay_repayment_ord` (
  `id` int(11) NOT NULL COMMENT '主键ID',
  `borrow_ord_no` varchar(32) NOT NULL COMMENT '借款订单号',
  `repayment_ord_no` varchar(32) NOT NULL COMMENT '还款订单号',
  `user_no` varchar(32) NOT NULL COMMENT '用户编号',
  `user_name` varchar(64) DEFAULT NULL COMMENT '用户姓名',
  `user_phone` varchar(11) DEFAULT NULL COMMENT '用户手机号',
  `user_id_no` varchar(64) DEFAULT NULL COMMENT '身份证号',
  `repayment_period` int(2) DEFAULT NULL COMMENT '还款期数',
  `installment_num` int(2) NOT NULL COMMENT '当前分期期数',
  `repayment_amt` decimal(11,2) DEFAULT '0.00' COMMENT '应还本金',
  `repayment_fee` decimal(11,2) DEFAULT '0.00' COMMENT '应还利息',
  `repayment_end_date` date DEFAULT NULL COMMENT '最后还款日',
  `repayment_cycle` int(1) DEFAULT NULL COMMENT '还款周期：1-周，2-月',
  `repayment_sts` int(2) DEFAULT '1' COMMENT '还款状态：1-待还款，2-已逾期，3-已还款',
  `is_renewal` int(1) DEFAULT '0' COMMENT '是否续期：0-否，1-是',
  `is_overdue` int(1) DEFAULT '0' COMMENT '是否逾期：0-否，1-是',
  `repaymented_amt` decimal(11,2) DEFAULT '0.00' COMMENT '已还款金额',
  `waiver_amount` decimal(11,2) DEFAULT '0.00' COMMENT '减免金额',
  `overdue_day` int(5) DEFAULT '0' COMMENT '逾期天数',
  `overdue_rate` decimal(4,2) DEFAULT '0.00' COMMENT '逾期费率（%）',
  `overdue_fee` decimal(11,2) DEFAULT '0.00' COMMENT '定额逾期费（元/天）',
  `overdue_amt` decimal(11,2) DEFAULT '0.00' COMMENT '逾期金额',
  `repaymented_time` datetime DEFAULT NULL COMMENT '还款完成时间',
  `repayment_channel` varchar(32) DEFAULT NULL COMMENT '还款渠道',
  `bank_card_no` varchar(32) DEFAULT NULL COMMENT '还款银行卡号',
  `bank_code` varchar(64) DEFAULT NULL COMMENT '还款银行编码',
  `bank_name` varchar(256) DEFAULT NULL COMMENT '还款银行名称',
  `reserve_field1` varchar(256) DEFAULT NULL COMMENT '预留字段一',
  `reserve_field2` varchar(256) DEFAULT NULL COMMENT '预留字段二',
  `reserve_field3` varchar(256) DEFAULT NULL COMMENT '预留字段三',
  `update_manage_name` varchar(32) DEFAULT NULL COMMENT '更新操作员',
  `tm_smp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`),
  UNIQUE KEY `t_pay_repayment_ord_UI1` (`repayment_ord_no`),
  KEY `t_pay_repayment_ord_I2` (`repayment_sts`),
  KEY `t_pay_repayment_ord_I3` (`user_no`),
  KEY `t_pay_repayment_ord_I4` (`repayment_ord_no`,`user_no`,`repayment_sts`),
  KEY `t_pay_repayment_ord_I5` (`borrow_ord_no`,`user_no`,`repayment_sts`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='还款订单表';

-- ----------------------------
-- Records of t_pay_repayment_ord
-- ----------------------------

-- ----------------------------
-- Table structure for `t_sys_feedback`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_feedback`;
CREATE TABLE `t_sys_feedback` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `feedback_source` int(1) DEFAULT NULL COMMENT '反馈来源：1-ios，2-android',
  `user_no` varchar(32) DEFAULT NULL COMMENT '用户编号',
  `user_name` varchar(64) DEFAULT NULL COMMENT '用户名称',
  `user_phone` varchar(11) DEFAULT NULL COMMENT '用户手机号',
  `feedback_info` varchar(1024) DEFAULT NULL COMMENT '反馈信息',
  `tm_smp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统意见反馈表';

-- ----------------------------
-- Records of t_sys_feedback
-- ----------------------------

-- ----------------------------
-- Table structure for `t_sys_module`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_module`;
CREATE TABLE `t_sys_module` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `module_id` varchar(32) DEFAULT NULL COMMENT '模块ID',
  `super_module_id` varchar(32) DEFAULT '0' COMMENT '上级模块ID',
  `module_name` varchar(64) DEFAULT NULL COMMENT '模块名称',
  `module_url` varchar(256) DEFAULT NULL COMMENT '模块URL',
  `module_type` int(2) DEFAULT NULL COMMENT '模块类型：1-菜单，2-按钮',
  `module_rank` int(2) DEFAULT NULL COMMENT '模块排序',
  `enable` int(1) DEFAULT NULL COMMENT '是否生效：0-无效，1-有效',
  `remark` varchar(256) DEFAULT NULL COMMENT '备注',
  `create_account` varchar(16) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_account` varchar(16) DEFAULT NULL COMMENT '更新人',
  `tm_smp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`),
  UNIQUE KEY `t_sys_module_UI1` (`module_id`),
  KEY `t_sys_module_I2` (`super_module_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='系统模块表';

-- ----------------------------
-- Records of t_sys_module
-- ----------------------------
INSERT INTO `t_sys_module` VALUES ('1', '2d4af4321c9e21b56386aa4fac6aeb5f', '0', '系统管理', 'javascipr:void(0);', '1', '99', '1', null, 'admin', '2019-02-28 10:19:16', 'admin', '2019-03-05 14:46:56');
INSERT INTO `t_sys_module` VALUES ('2', '2d4af4321c9e4ed56386aa4fac6aeb5f', '2d4af4321c9e21b56386aa4fac6aeb5f', '系统角色', '/sysRole/roleList', '1', '99', '1', null, 'admin', '2019-02-28 10:19:16', null, '2019-03-05 14:47:00');
INSERT INTO `t_sys_module` VALUES ('3', '2d4af4321c9e4edc9686aa4fac6aeb5f', '2d4af4321c9e21b56386aa4fac6aeb5f', '系统模块', '/sysModule/moduleList', '1', '99', '1', null, 'admin', '2019-02-28 10:19:16', null, '2019-03-05 14:47:01');
INSERT INTO `t_sys_module` VALUES ('5', '2d4af4115c944edc9686aa4eac6aeb5f', '2d4af4321c9e21b56386aa4fac6aeb5f', '系统用户', '/user/userList?userSts=1', '1', '99', '1', '', 'admin', '2019-03-02 17:38:32', 'admin', '2019-03-05 14:47:02');
INSERT INTO `t_sys_module` VALUES ('7', 'faeb00d075644d10a94c1f2339f8304c', '0', '系统用户2122', '/sysUser/userList', '1', '11', '0', '', 'admin', '2019-03-05 15:44:03', 'admin', '2019-03-05 15:46:42');

-- ----------------------------
-- Table structure for `t_sys_notice_config`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_notice_config`;
CREATE TABLE `t_sys_notice_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `notice_title` varchar(32) DEFAULT NULL COMMENT '公告主题',
  `notice_desc` varchar(256) DEFAULT NULL COMMENT '公告概述',
  `notice_url` varchar(256) DEFAULT NULL COMMENT '公告URL',
  `eff_time` datetime DEFAULT NULL COMMENT '生效时间',
  `exp_time` datetime DEFAULT NULL COMMENT '失效时间',
  `create_account` varchar(16) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_account` varchar(16) DEFAULT NULL COMMENT 'update_account',
  `tm_smp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统公告配置表';

-- ----------------------------
-- Records of t_sys_notice_config
-- ----------------------------

-- ----------------------------
-- Table structure for `t_sys_param`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_param`;
CREATE TABLE `t_sys_param` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `param_type` varchar(64) NOT NULL COMMENT '参数类型',
  `param_key` varchar(64) NOT NULL COMMENT '参数键',
  `param_name` varchar(256) NOT NULL COMMENT '参数名称',
  `param_val` varchar(256) NOT NULL COMMENT '参数值',
  `remark` varchar(256) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `tm_smp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`),
  UNIQUE KEY `t_sys_param_UI1` (`param_type`,`param_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统参数表';

-- ----------------------------
-- Records of t_sys_param
-- ----------------------------

-- ----------------------------
-- Table structure for `t_sys_region`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_region`;
CREATE TABLE `t_sys_region` (
  `id` int(11) NOT NULL COMMENT '地区码',
  `name` varchar(40) DEFAULT NULL COMMENT '地区名称',
  `parent_id` int(11) DEFAULT NULL COMMENT '上级ID',
  `short_name` varchar(40) DEFAULT NULL COMMENT '简称',
  `level_type` int(2) DEFAULT NULL COMMENT '类型：0-国家，1-省，2-市，3-区县',
  `city_code` varchar(20) DEFAULT NULL COMMENT '城市区号',
  `zip_code` varchar(20) DEFAULT NULL COMMENT '邮政编码',
  `merge_name` varchar(128) DEFAULT NULL COMMENT '全称',
  `lng` float DEFAULT NULL COMMENT '经度',
  `lat` float DEFAULT NULL COMMENT '维度',
  `pin_yin` varchar(128) DEFAULT NULL COMMENT '拼音',
  `tm_smp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统地区码表';

-- ----------------------------
-- Records of t_sys_region
-- ----------------------------

-- ----------------------------
-- Table structure for `t_sys_return_code`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_return_code`;
CREATE TABLE `t_sys_return_code` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `return_code` varchar(16) NOT NULL COMMENT '返回码',
  `return_type` int(2) DEFAULT NULL COMMENT '返回码类型：1-成功，2-失败，3-处理中，4-未登录，5-异常',
  `return_info` varchar(256) DEFAULT NULL COMMENT '返回信息',
  `desc` varchar(256) DEFAULT NULL COMMENT '描述',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `tm_smp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`),
  UNIQUE KEY `t_message_conf_UI1` (`return_code`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='系统返回码表';

-- ----------------------------
-- Records of t_sys_return_code
-- ----------------------------
INSERT INTO `t_sys_return_code` VALUES ('1', 'BCK20001', '2', '用户不存在', '用户不存在', '2019-02-27 11:43:29', '2019-02-27 11:43:31');
INSERT INTO `t_sys_return_code` VALUES ('3', 'BCK20002', '2', '密码错误', '密码错误', '2019-02-27 12:06:57', '2019-02-27 12:07:03');

-- ----------------------------
-- Table structure for `t_sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_role`;
CREATE TABLE `t_sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `role_id` varchar(32) NOT NULL COMMENT '角色ID',
  `super_role_id` varchar(32) DEFAULT '0' COMMENT '上级角色ID',
  `role_name` varchar(32) NOT NULL COMMENT '角色名称',
  `enable` int(1) DEFAULT NULL COMMENT '是否生效：0-无效，1-有效',
  `create_account` varchar(16) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_account` varchar(16) DEFAULT NULL COMMENT '更新人',
  `tm_smp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`),
  UNIQUE KEY `t_sys_role_UI1` (`role_id`),
  KEY `t_sys_role_I2` (`super_role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='系统角色表';

-- ----------------------------
-- Records of t_sys_role
-- ----------------------------
INSERT INTO `t_sys_role` VALUES ('1', 'r4rwgtw45y6uy57u467u64uik5636r4w', '0', '超级管理员', '1', 'admin', '2019-02-28 14:10:02', 'admin', '2019-03-05 15:35:30');

-- ----------------------------
-- Table structure for `t_sys_role_module`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_role_module`;
CREATE TABLE `t_sys_role_module` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `module_id` varchar(32) DEFAULT NULL COMMENT '模块ID',
  `role_id` varchar(32) DEFAULT NULL COMMENT '角色ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `tm_smp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`),
  KEY `t_sys_role_module_UI1` (`role_id`,`module_id`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8 COMMENT='系统角色模块对应表';

-- ----------------------------
-- Records of t_sys_role_module
-- ----------------------------
INSERT INTO `t_sys_role_module` VALUES ('61', '0', 'r4rwgtw45y6uy57u467u64uik5636r4w', '2019-03-05 15:35:45', '2019-03-05 15:35:45');
INSERT INTO `t_sys_role_module` VALUES ('62', '2d4af4321c9e21b56386aa4fac6aeb5f', 'r4rwgtw45y6uy57u467u64uik5636r4w', '2019-03-05 15:35:45', '2019-03-05 15:35:45');
INSERT INTO `t_sys_role_module` VALUES ('63', '2d4af4321c9e4ed56386aa4fac6aeb5f', 'r4rwgtw45y6uy57u467u64uik5636r4w', '2019-03-05 15:35:45', '2019-03-05 15:35:45');
INSERT INTO `t_sys_role_module` VALUES ('64', '2d4af4321c9e4edc9686aa4fac6aeb5f', 'r4rwgtw45y6uy57u467u64uik5636r4w', '2019-03-05 15:35:45', '2019-03-05 15:35:45');
INSERT INTO `t_sys_role_module` VALUES ('65', '2d4af4115c944edc9686aa4eac6aeb5f', 'r4rwgtw45y6uy57u467u64uik5636r4w', '2019-03-05 15:35:45', '2019-03-05 15:35:45');

-- ----------------------------
-- Table structure for `t_sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_user`;
CREATE TABLE `t_sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_id` varchar(32) NOT NULL COMMENT '用户ID',
  `role_id` varchar(32) NOT NULL COMMENT '角色ID',
  `user_account` varchar(16) NOT NULL COMMENT '账号',
  `user_passwd` varchar(32) NOT NULL COMMENT '密码',
  `user_sts` int(1) NOT NULL DEFAULT '1' COMMENT '状态：0-无效，1-有效',
  `user_type` int(2) DEFAULT NULL COMMENT '用户类型：1-管理员，2-普通用户',
  `user_name` varchar(32) DEFAULT NULL COMMENT '姓名',
  `user_phone` varchar(11) DEFAULT NULL COMMENT '手机号',
  `user_email` varchar(128) DEFAULT NULL COMMENT '邮箱',
  `remark` varchar(256) DEFAULT NULL COMMENT '备注',
  `login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `tm_smp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`),
  UNIQUE KEY `t_sys_user_UI1` (`user_id`),
  UNIQUE KEY `t_sys_user_UI2` (`user_account`),
  KEY `t_sys_user_I3` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='系统用户表';

-- ----------------------------
-- Records of t_sys_user
-- ----------------------------
INSERT INTO `t_sys_user` VALUES ('1', '102001001', 'r4rwgtw45y6uy57u467u64uik5636r4w', 'admin', '962012D09B8170D912F0669F6D7D9D07', '1', '1', '超级管理员', '18676361434', '18676361434@163.com', null, '2019-03-05 16:11:18', '2019-02-27 15:52:36', '2019-03-05 16:11:18');

-- ----------------------------
-- Table structure for `t_sys_user_login_record`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_user_login_record`;
CREATE TABLE `t_sys_user_login_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_id` varchar(32) NOT NULL COMMENT '用户ID',
  `login_ip` varchar(25) NOT NULL DEFAULT '' COMMENT '登录IP',
  `tm_smp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8 COMMENT='系统用户登录记录表';

-- ----------------------------
-- Records of t_sys_user_login_record
-- ----------------------------
INSERT INTO `t_sys_user_login_record` VALUES ('1', '1102001001', '0:0:0:0:0:0:0:1', '2019-02-27 15:56:40');
INSERT INTO `t_sys_user_login_record` VALUES ('2', '1102001001', '0:0:0:0:0:0:0:1', '2019-02-27 15:58:33');
INSERT INTO `t_sys_user_login_record` VALUES ('3', '1102001001', '0:0:0:0:0:0:0:1', '2019-02-27 16:01:09');
INSERT INTO `t_sys_user_login_record` VALUES ('4', '1102001001', '0:0:0:0:0:0:0:1', '2019-02-27 16:02:01');
INSERT INTO `t_sys_user_login_record` VALUES ('5', '1102001001', '0:0:0:0:0:0:0:1', '2019-02-27 16:05:05');
INSERT INTO `t_sys_user_login_record` VALUES ('6', '1102001001', '0:0:0:0:0:0:0:1', '2019-02-27 16:06:14');
INSERT INTO `t_sys_user_login_record` VALUES ('7', '1102001001', '0:0:0:0:0:0:0:1', '2019-02-27 16:09:42');
INSERT INTO `t_sys_user_login_record` VALUES ('8', '1102001001', '0:0:0:0:0:0:0:1', '2019-02-27 16:13:35');
INSERT INTO `t_sys_user_login_record` VALUES ('9', '1102001001', '0:0:0:0:0:0:0:1', '2019-02-28 10:17:31');
INSERT INTO `t_sys_user_login_record` VALUES ('10', '1102001001', '0:0:0:0:0:0:0:1', '2019-02-28 10:19:39');
INSERT INTO `t_sys_user_login_record` VALUES ('11', '1102001001', '0:0:0:0:0:0:0:1', '2019-02-28 10:20:22');
INSERT INTO `t_sys_user_login_record` VALUES ('12', '1102001001', '0:0:0:0:0:0:0:1', '2019-02-28 10:21:52');
INSERT INTO `t_sys_user_login_record` VALUES ('13', '1102001001', '0:0:0:0:0:0:0:1', '2019-02-28 10:25:39');
INSERT INTO `t_sys_user_login_record` VALUES ('14', '1102001001', '0:0:0:0:0:0:0:1', '2019-02-28 10:26:54');
INSERT INTO `t_sys_user_login_record` VALUES ('15', '1102001001', '0:0:0:0:0:0:0:1', '2019-02-28 10:33:44');
INSERT INTO `t_sys_user_login_record` VALUES ('16', '1102001001', '0:0:0:0:0:0:0:1', '2019-02-28 10:51:10');
INSERT INTO `t_sys_user_login_record` VALUES ('17', '1102001001', '0:0:0:0:0:0:0:1', '2019-02-28 11:18:03');
INSERT INTO `t_sys_user_login_record` VALUES ('18', '1102001001', '0:0:0:0:0:0:0:1', '2019-02-28 11:19:42');
INSERT INTO `t_sys_user_login_record` VALUES ('19', '1102001001', '0:0:0:0:0:0:0:1', '2019-02-28 11:37:27');
INSERT INTO `t_sys_user_login_record` VALUES ('20', '1102001001', '0:0:0:0:0:0:0:1', '2019-02-28 11:54:06');
INSERT INTO `t_sys_user_login_record` VALUES ('21', '1102001001', '0:0:0:0:0:0:0:1', '2019-02-28 12:01:19');
INSERT INTO `t_sys_user_login_record` VALUES ('22', '1102001001', '0:0:0:0:0:0:0:1', '2019-02-28 12:02:52');
INSERT INTO `t_sys_user_login_record` VALUES ('23', '1102001001', '0:0:0:0:0:0:0:1', '2019-02-28 12:03:33');
INSERT INTO `t_sys_user_login_record` VALUES ('24', '1102001001', '0:0:0:0:0:0:0:1', '2019-02-28 12:07:20');
INSERT INTO `t_sys_user_login_record` VALUES ('25', '1102001001', '0:0:0:0:0:0:0:1', '2019-02-28 12:10:00');
INSERT INTO `t_sys_user_login_record` VALUES ('26', '1102001001', '0:0:0:0:0:0:0:1', '2019-02-28 12:18:15');
INSERT INTO `t_sys_user_login_record` VALUES ('27', '1102001001', '0:0:0:0:0:0:0:1', '2019-02-28 12:21:35');
INSERT INTO `t_sys_user_login_record` VALUES ('28', '1102001001', '0:0:0:0:0:0:0:1', '2019-02-28 12:24:08');
INSERT INTO `t_sys_user_login_record` VALUES ('29', '1102001001', '0:0:0:0:0:0:0:1', '2019-02-28 12:24:30');
INSERT INTO `t_sys_user_login_record` VALUES ('30', '1102001001', '0:0:0:0:0:0:0:1', '2019-02-28 12:25:21');
INSERT INTO `t_sys_user_login_record` VALUES ('31', '1102001001', '0:0:0:0:0:0:0:1', '2019-02-28 14:05:50');
INSERT INTO `t_sys_user_login_record` VALUES ('32', '1102001001', '0:0:0:0:0:0:0:1', '2019-02-28 14:12:44');
INSERT INTO `t_sys_user_login_record` VALUES ('33', '1102001001', '0:0:0:0:0:0:0:1', '2019-02-28 14:14:12');
INSERT INTO `t_sys_user_login_record` VALUES ('34', '1102001001', '0:0:0:0:0:0:0:1', '2019-02-28 14:43:40');
INSERT INTO `t_sys_user_login_record` VALUES ('35', '1102001001', '0:0:0:0:0:0:0:1', '2019-02-28 14:45:40');
INSERT INTO `t_sys_user_login_record` VALUES ('36', '1102001001', '0:0:0:0:0:0:0:1', '2019-02-28 14:50:36');
INSERT INTO `t_sys_user_login_record` VALUES ('37', '1102001001', '0:0:0:0:0:0:0:1', '2019-02-28 15:03:17');
INSERT INTO `t_sys_user_login_record` VALUES ('38', '1102001001', '0:0:0:0:0:0:0:1', '2019-02-28 15:07:59');
INSERT INTO `t_sys_user_login_record` VALUES ('39', '1102001001', '0:0:0:0:0:0:0:1', '2019-02-28 15:13:49');
INSERT INTO `t_sys_user_login_record` VALUES ('40', '1102001001', '0:0:0:0:0:0:0:1', '2019-02-28 15:18:39');
INSERT INTO `t_sys_user_login_record` VALUES ('41', '1102001001', '0:0:0:0:0:0:0:1', '2019-02-28 15:54:11');
INSERT INTO `t_sys_user_login_record` VALUES ('42', '1102001001', '0:0:0:0:0:0:0:1', '2019-02-28 15:56:00');
INSERT INTO `t_sys_user_login_record` VALUES ('43', '1102001001', '0:0:0:0:0:0:0:1', '2019-02-28 16:15:26');
INSERT INTO `t_sys_user_login_record` VALUES ('44', '1102001001', '0:0:0:0:0:0:0:1', '2019-02-28 16:17:24');
INSERT INTO `t_sys_user_login_record` VALUES ('45', '1102001001', '0:0:0:0:0:0:0:1', '2019-02-28 16:19:34');
INSERT INTO `t_sys_user_login_record` VALUES ('46', '1102001001', '0:0:0:0:0:0:0:1', '2019-02-28 16:59:09');
INSERT INTO `t_sys_user_login_record` VALUES ('47', '1102001001', '0:0:0:0:0:0:0:1', '2019-02-28 17:00:53');
INSERT INTO `t_sys_user_login_record` VALUES ('48', '1102001001', '0:0:0:0:0:0:0:1', '2019-02-28 17:01:57');
INSERT INTO `t_sys_user_login_record` VALUES ('49', '1102001001', '0:0:0:0:0:0:0:1', '2019-02-28 17:03:00');
INSERT INTO `t_sys_user_login_record` VALUES ('50', '1102001001', '0:0:0:0:0:0:0:1', '2019-02-28 17:14:08');
INSERT INTO `t_sys_user_login_record` VALUES ('51', '1102001001', '0:0:0:0:0:0:0:1', '2019-02-28 17:15:30');
INSERT INTO `t_sys_user_login_record` VALUES ('52', '1102001001', '0:0:0:0:0:0:0:1', '2019-02-28 17:16:16');
INSERT INTO `t_sys_user_login_record` VALUES ('53', '1102001001', '0:0:0:0:0:0:0:1', '2019-02-28 17:23:36');
INSERT INTO `t_sys_user_login_record` VALUES ('54', '1102001001', '0:0:0:0:0:0:0:1', '2019-02-28 17:50:26');
INSERT INTO `t_sys_user_login_record` VALUES ('55', '1102001001', '0:0:0:0:0:0:0:1', '2019-02-28 18:01:00');
INSERT INTO `t_sys_user_login_record` VALUES ('56', '1102001001', '0:0:0:0:0:0:0:1', '2019-03-01 09:47:56');
INSERT INTO `t_sys_user_login_record` VALUES ('57', '1102001001', '0:0:0:0:0:0:0:1', '2019-03-01 14:53:04');
INSERT INTO `t_sys_user_login_record` VALUES ('58', '1102001001', '0:0:0:0:0:0:0:1', '2019-03-01 15:16:29');
INSERT INTO `t_sys_user_login_record` VALUES ('59', '1102001001', '0:0:0:0:0:0:0:1', '2019-03-01 15:17:46');
INSERT INTO `t_sys_user_login_record` VALUES ('60', '1102001001', '0:0:0:0:0:0:0:1', '2019-03-01 15:45:59');
INSERT INTO `t_sys_user_login_record` VALUES ('61', '1102001001', '0:0:0:0:0:0:0:1', '2019-03-01 15:55:24');
INSERT INTO `t_sys_user_login_record` VALUES ('62', '1102001001', '0:0:0:0:0:0:0:1', '2019-03-01 15:57:24');
INSERT INTO `t_sys_user_login_record` VALUES ('63', '1102001001', '0:0:0:0:0:0:0:1', '2019-03-01 16:22:39');
INSERT INTO `t_sys_user_login_record` VALUES ('64', '1102001001', '0:0:0:0:0:0:0:1', '2019-03-01 17:06:49');
INSERT INTO `t_sys_user_login_record` VALUES ('65', '1102001001', '0:0:0:0:0:0:0:1', '2019-03-01 17:09:46');
INSERT INTO `t_sys_user_login_record` VALUES ('66', '1102001001', '0:0:0:0:0:0:0:1', '2019-03-01 17:12:41');
INSERT INTO `t_sys_user_login_record` VALUES ('67', '1102001001', '0:0:0:0:0:0:0:1', '2019-03-01 17:13:41');
INSERT INTO `t_sys_user_login_record` VALUES ('68', '1102001001', '0:0:0:0:0:0:0:1', '2019-03-02 17:20:41');
INSERT INTO `t_sys_user_login_record` VALUES ('69', '1102001001', '0:0:0:0:0:0:0:1', '2019-03-02 17:26:44');
INSERT INTO `t_sys_user_login_record` VALUES ('70', '1102001001', '0:0:0:0:0:0:0:1', '2019-03-02 17:27:40');
INSERT INTO `t_sys_user_login_record` VALUES ('71', '1102001001', '0:0:0:0:0:0:0:1', '2019-03-02 17:36:12');
INSERT INTO `t_sys_user_login_record` VALUES ('72', '1102001001', '0:0:0:0:0:0:0:1', '2019-03-02 17:56:25');
INSERT INTO `t_sys_user_login_record` VALUES ('73', '1102001001', '0:0:0:0:0:0:0:1', '2019-03-02 18:05:56');
INSERT INTO `t_sys_user_login_record` VALUES ('74', '1102001001', '0:0:0:0:0:0:0:1', '2019-03-04 14:58:05');
INSERT INTO `t_sys_user_login_record` VALUES ('75', '1102001001', '0:0:0:0:0:0:0:1', '2019-03-05 10:29:55');
INSERT INTO `t_sys_user_login_record` VALUES ('76', '1102001001', '0:0:0:0:0:0:0:1', '2019-03-05 10:31:35');
INSERT INTO `t_sys_user_login_record` VALUES ('77', '1102001001', '0:0:0:0:0:0:0:1', '2019-03-05 10:33:10');
INSERT INTO `t_sys_user_login_record` VALUES ('78', '1102001001', '0:0:0:0:0:0:0:1', '2019-03-05 10:38:28');
INSERT INTO `t_sys_user_login_record` VALUES ('79', '1102001001', '0:0:0:0:0:0:0:1', '2019-03-05 10:40:43');
INSERT INTO `t_sys_user_login_record` VALUES ('80', '1102001001', '0:0:0:0:0:0:0:1', '2019-03-05 10:44:59');
INSERT INTO `t_sys_user_login_record` VALUES ('81', '1102001001', '0:0:0:0:0:0:0:1', '2019-03-05 10:47:20');
INSERT INTO `t_sys_user_login_record` VALUES ('82', '1102001001', '0:0:0:0:0:0:0:1', '2019-03-05 10:50:35');
INSERT INTO `t_sys_user_login_record` VALUES ('83', '1102001001', '0:0:0:0:0:0:0:1', '2019-03-05 10:51:56');
INSERT INTO `t_sys_user_login_record` VALUES ('84', '1102001001', '0:0:0:0:0:0:0:1', '2019-03-05 11:10:53');
INSERT INTO `t_sys_user_login_record` VALUES ('85', '1102001001', '0:0:0:0:0:0:0:1', '2019-03-05 11:14:19');
INSERT INTO `t_sys_user_login_record` VALUES ('86', '1102001001', '0:0:0:0:0:0:0:1', '2019-03-05 11:17:25');
INSERT INTO `t_sys_user_login_record` VALUES ('87', '1102001001', '0:0:0:0:0:0:0:1', '2019-03-05 12:34:08');
INSERT INTO `t_sys_user_login_record` VALUES ('88', '1102001001', '0:0:0:0:0:0:0:1', '2019-03-05 12:36:57');
INSERT INTO `t_sys_user_login_record` VALUES ('89', '1102001001', '0:0:0:0:0:0:0:1', '2019-03-05 14:18:16');
INSERT INTO `t_sys_user_login_record` VALUES ('90', '1102001001', '0:0:0:0:0:0:0:1', '2019-03-05 14:26:55');
INSERT INTO `t_sys_user_login_record` VALUES ('91', '1102001001', '0:0:0:0:0:0:0:1', '2019-03-05 14:39:26');
INSERT INTO `t_sys_user_login_record` VALUES ('92', 'T102001001', '0:0:0:0:0:0:0:1', '2019-03-05 14:48:30');
INSERT INTO `t_sys_user_login_record` VALUES ('93', 'T102001001', '0:0:0:0:0:0:0:1', '2019-03-05 15:04:46');
INSERT INTO `t_sys_user_login_record` VALUES ('94', 'T102001001', '0:0:0:0:0:0:0:1', '2019-03-05 15:07:03');
INSERT INTO `t_sys_user_login_record` VALUES ('95', 'T102001001', '0:0:0:0:0:0:0:1', '2019-03-05 15:16:12');
INSERT INTO `t_sys_user_login_record` VALUES ('96', 'T102001001', '0:0:0:0:0:0:0:1', '2019-03-05 15:24:10');
INSERT INTO `t_sys_user_login_record` VALUES ('97', 'T102001001', '0:0:0:0:0:0:0:1', '2019-03-05 15:46:35');
INSERT INTO `t_sys_user_login_record` VALUES ('98', '102001001', '0:0:0:0:0:0:0:1', '2019-03-05 16:07:14');
INSERT INTO `t_sys_user_login_record` VALUES ('99', '102001001', '0:0:0:0:0:0:0:1', '2019-03-05 16:11:18');

-- ----------------------------
-- Table structure for `t_sys_user_module`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_user_module`;
CREATE TABLE `t_sys_user_module` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(32) NOT NULL,
  `module_id` varchar(32) NOT NULL,
  `remarks` varchar(255) DEFAULT '',
  `tm_smp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `user_id` (`user_id`) USING BTREE,
  KEY `module_id` (`module_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='系统用户模块表';

-- ----------------------------
-- Records of t_sys_user_module
-- ----------------------------
INSERT INTO `t_sys_user_module` VALUES ('1', '102001001', '2d4af4321c9e21b56386aa4fac6aeb5f', '', '2019-03-05 15:47:18');
INSERT INTO `t_sys_user_module` VALUES ('2', '102001001', '2d4af4321c9e4ed56386aa4fac6aeb5f', '', '2019-03-05 15:47:20');
INSERT INTO `t_sys_user_module` VALUES ('3', '102001001', '2d4af4321c9e4edc9686aa4fac6aeb5f', '', '2019-03-05 15:47:24');

-- ----------------------------
-- Table structure for `t_user_card`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_card`;
CREATE TABLE `t_user_card` (
  `id` int(11) NOT NULL COMMENT '主键ID',
  `user_no` varchar(32) NOT NULL COMMENT '用户编号',
  `bank_card_no` varchar(32) DEFAULT NULL COMMENT '银行卡号',
  `bank_code` varchar(64) DEFAULT NULL COMMENT '银行编码',
  `bank_name` varchar(256) DEFAULT NULL COMMENT '银行名称',
  `bind_id` varchar(128) DEFAULT NULL COMMENT '绑卡编号',
  `bind_sts` int(2) DEFAULT NULL COMMENT '绑卡状态：1-初始化，2-绑卡成功，3-绑卡失败',
  `bind_type` int(2) DEFAULT NULL COMMENT '绑卡渠道',
  `bind_time` datetime DEFAULT NULL COMMENT '绑卡时间',
  `tm_smp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`),
  UNIQUE KEY `t_user_card_UI1` (`user_no`,`bank_card_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户绑卡表';

-- ----------------------------
-- Records of t_user_card
-- ----------------------------

-- ----------------------------
-- Table structure for `t_user_contacts`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_contacts`;
CREATE TABLE `t_user_contacts` (
  `id` int(11) NOT NULL COMMENT '主键ID',
  `user_no` varchar(32) DEFAULT NULL COMMENT '用户编号',
  `contacts_type` int(2) DEFAULT NULL COMMENT '联系人类型：1-第一联系人，2-第二联系人',
  `contacts_relation` int(2) DEFAULT NULL COMMENT '联系人关系',
  `contacts_name` varchar(64) DEFAULT NULL COMMENT '联系人姓名',
  `contacts_phone` varchar(11) DEFAULT NULL COMMENT '联系人手机号',
  `tm_smp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`),
  UNIQUE KEY `t_user_contacts_UI1` (`user_no`,`contacts_type`),
  UNIQUE KEY `t_user_contacts_UI2` (`user_no`,`contacts_phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户紧急联系人表';

-- ----------------------------
-- Records of t_user_contacts
-- ----------------------------

-- ----------------------------
-- Table structure for `t_user_info`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_info`;
CREATE TABLE `t_user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_no` varchar(32) NOT NULL COMMENT '用户编号',
  `user_name` varchar(64) DEFAULT NULL COMMENT '用户姓名',
  `user_phone` varchar(11) NOT NULL COMMENT '手机号',
  `sex` int(2) DEFAULT NULL COMMENT '性别',
  `race` varchar(32) DEFAULT NULL COMMENT '名族',
  `user_id_no` varchar(64) DEFAULT NULL COMMENT '身份证号',
  `login_password` varchar(256) DEFAULT NULL COMMENT '登录密码',
  `pay_password` varchar(256) DEFAULT NULL COMMENT '支付密码',
  `province` int(11) DEFAULT NULL COMMENT '所在省',
  `city` int(11) DEFAULT NULL COMMENT '所在市',
  `area` int(11) DEFAULT NULL COMMENT '所在区县',
  `address` varchar(256) DEFAULT NULL COMMENT '详细地址',
  `live_time` int(2) DEFAULT NULL COMMENT '居住时长',
  `house_type` int(2) DEFAULT NULL COMMENT '房屋类型',
  `industry` int(11) DEFAULT NULL COMMENT '行业类别',
  `position` int(11) DEFAULT NULL COMMENT '职位',
  `income` decimal(10,2) DEFAULT NULL COMMENT '收入',
  `work_unit_name` varchar(128) DEFAULT NULL COMMENT '单位名称',
  `work_unit_addr` varchar(128) DEFAULT NULL COMMENT '单位地址',
  `work_unit_tel` varchar(32) DEFAULT NULL COMMENT '单位电话',
  `marriage_sts` int(2) DEFAULT NULL COMMENT '婚姻状态',
  `education` int(2) DEFAULT NULL COMMENT '学历',
  `create_time` datetime NOT NULL COMMENT '注册时间',
  `user_sts` int(2) NOT NULL DEFAULT '1' COMMENT '用户状态：1-正常，2-注销，3-灰名单，4-黑名单',
  `is_old` int(1) DEFAULT '0' COMMENT '是否老用户：0-否，1-是',
  `share_code` varchar(64) DEFAULT NULL COMMENT '邀请码',
  `invite_rate` decimal(4,2) DEFAULT '0.00' COMMENT '邀请返利率',
  `invite_user_no` varchar(32) DEFAULT NULL COMMENT '邀请人编号',
  `is_identity_info` int(1) DEFAULT '0' COMMENT '是否提交身份信息：0-否，1-是',
  `is_real_name` int(1) DEFAULT '0' COMMENT '是否已实名认证：0-否，1-是，2-认证中',
  `is_bind_card` int(1) DEFAULT '0' COMMENT '是否已绑卡：0-否，1-是',
  `is_linkman` int(1) DEFAULT '0' COMMENT '是否提交紧急联系人：0-否，1-是',
  `is_operator` int(1) DEFAULT '0' COMMENT '是否运营商认证：0-否，1-是，2-认证中',
  `is_ec_auth` int(1) DEFAULT NULL COMMENT '是否提交电商认证：0-否，1-是，2-认证中',
  `reserve_field1` varchar(256) DEFAULT NULL COMMENT '预留字段一',
  `reserve_field2` varchar(256) DEFAULT NULL COMMENT '预留字段二',
  `reserve_field3` varchar(256) DEFAULT NULL COMMENT '预留字段三',
  `tm_smp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`),
  UNIQUE KEY `t_user_info_UI1` (`user_no`),
  UNIQUE KEY `t_user_info_UI3` (`user_phone`),
  UNIQUE KEY `t_user_info_UI2` (`user_id_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- ----------------------------
-- Records of t_user_info
-- ----------------------------

-- ----------------------------
-- Table structure for `t_user_phone_list`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_phone_list`;
CREATE TABLE `t_user_phone_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_no` varchar(32) NOT NULL COMMENT '用户编号',
  `phone_name` varchar(64) DEFAULT NULL COMMENT '通讯录名称',
  `phone_no` varchar(64) DEFAULT NULL COMMENT '手机号码',
  `tm_smp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`),
  UNIQUE KEY `t_user_phone_list_UI1` (`user_no`,`phone_no`,`phone_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户通讯录表';

-- ----------------------------
-- Records of t_user_phone_list
-- ----------------------------

-- ----------------------------
-- Table structure for `t_user_realname`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_realname`;
CREATE TABLE `t_user_realname` (
  `id` int(11) NOT NULL COMMENT '主键ID',
  `user_no` varchar(32) NOT NULL COMMENT '用户编号',
  `face_picture_url` varchar(512) DEFAULT NULL COMMENT '人脸图片地址',
  `face_picture_pub_url` varchar(512) DEFAULT NULL COMMENT '人脸图片访问地址',
  `id_positive_picture_url` varchar(512) DEFAULT NULL COMMENT '身份证正面图片地址',
  `id_positive_picture_pub_url` varchar(512) DEFAULT NULL COMMENT '身份证正面图片访问地址',
  `id_anti_picture_url` varchar(512) DEFAULT NULL COMMENT '身份证反面图片地址',
  `id_anti_picture_pub_url` varchar(512) DEFAULT NULL COMMENT '身份证反面图片访问地址',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `tm_smp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`),
  UNIQUE KEY `t_realname_auth_UI1` (`user_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户实名表';

-- ----------------------------
-- Records of t_user_realname
-- ----------------------------
