
create table t_channel_payment_config
(
   id                   int not null auto_increment comment '主键ID',
   channel_type         varchar(32) not null comment '渠道类型',
   channel_name         varchar(64) comment '渠道名称',
   channel_server_bean  varchar(128) not null comment '渠道服务bean',
   priority             int default 0 comment '优先级',
   loan_quota           decimal(11,2) default 0 comment '放款额度',
   eff_time             datetime not null comment '生效时间',
   exp_time             datetime not null comment '失效时间',
   create_account       varchar(64) comment '创建人',
   create_time          datetime comment '创建时间',
   update_account       varchar(64) comment '修改人',
   tm_smp               timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '时间戳',
   primary key (id)
);

alter table t_channel_payment_config comment '代付渠道配置表';

/*==============================================================*/
/* Index: t_channel_loan_config_UI1                             */
/*==============================================================*/
create unique index t_channel_loan_config_UI1 on t_channel_payment_config
(
   channel_type
);

/*==============================================================*/
/* Index: t_channel_loan_config_UI2                             */
/*==============================================================*/
create unique index t_channel_loan_config_UI2 on t_channel_payment_config
(
   channel_server_bean
);

/*==============================================================*/
/* Index: t_channel_loan_config_I2                              */
/*==============================================================*/
create index t_channel_loan_config_I3 on t_channel_payment_config
(
   eff_time,
   exp_time
);

/*==============================================================*/
/* Table: t_channel_payment_quota_count                         */
/*==============================================================*/
create table t_channel_payment_quota_count
(
   id                   int not null auto_increment comment '主键ID',
   cut_date             date comment '统计日期',
   channel_type         varchar(32) comment '渠道类型',
   payment_amt          decimal(11,2) default 0 comment '放款金额',
   tm_xmp               timestamp comment '时间戳',
   primary key (id)
);

alter table t_channel_payment_quota_count comment '代付额度统计表';

/*==============================================================*/
/* Table: t_channel_withhold_config                             */
/*==============================================================*/
create table t_channel_withhold_config
(
   id                   int not null auto_increment comment '主键ID',
   channel_type         varchar(32) not null comment '渠道类型',
   channel_name         varchar(64) comment '渠道名称',
   channel_server_bean  varchar(128) not null comment '渠道服务bean',
   priority             int default 0 comment '优先级',
   eff_time             datetime not null comment '生效时间',
   exp_time             datetime not null comment '失效时间',
   create_account       varchar(64) comment '创建人',
   create_time          datetime comment '创建时间',
   update_account       varchar(64) comment '修改人',
   tm_smp               timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '时间戳',
   primary key (id)
);

alter table t_channel_withhold_config comment '代扣渠道配置表';

/*==============================================================*/
/* Table: t_channel_withhold_count                              */
/*==============================================================*/
create table t_channel_withhold_count
(
   id                   int not null auto_increment comment '主键ID',
   cut_date             date comment '统计日期',
   channel_type         varchar(32) comment '渠道类型',
   withhold_amt         decimal(11,2) default 0 comment '代扣金额',
   tm_xmp               timestamp comment '时间戳',
   primary key (id)
);

alter table t_channel_withhold_count comment '代扣统计表';

/*==============================================================*/
/* Table: t_message_conf                                        */
/*==============================================================*/
create table t_message_conf
(
   id                   int not null auto_increment comment '主键ID',
   msg_no               varchar(32) not null comment '模板编号',
   msg_title            varchar(64) comment '短信主题',
   msg_template         varchar(1024) comment '短信模板',
   create_time          datetime comment '创建时间',
   tm_smp               timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '时间戳',
   primary key (id)
);

alter table t_message_conf comment '短信模板表';

/*==============================================================*/
/* Index: t_message_conf_UI1                                    */
/*==============================================================*/
create unique index t_message_conf_UI1 on t_message_conf
(
   msg_no
);

/*==============================================================*/
/* Table: t_message_record                                      */
/*==============================================================*/
create table t_message_record
(
   id                   int not null auto_increment comment '主键ID',
   rec_name             varchar(64) comment '收信人姓名',
   rec_phone            varchar(11) not null comment '收信人手机号',
   rec_user_type        int(2) comment '收信人类型：1-系统管理员，2-普通管理员，3-用户',
   msg_title            varchar(64) comment '短信标题',
   msg_content          varchar(1024) comment '短信内容',
   msg_send_time        datetime comment '短信发送时间',
   tm_smp               timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '时间戳',
   primary key (id)
);

alter table t_message_record comment '短信记录表';

/*==============================================================*/
/* Table: t_pay_borrow_ord                                      */
/*==============================================================*/
create table t_pay_borrow_ord
(
   id                   int not null auto_increment comment '主键ID',
   borrow_ord_no        varchar(32) not null comment '借款订单号',
   user_no              varchar(32) not null comment '用户编号',
   user_name            varchar(64) comment '用户姓名',
   user_phone           varchar(11) comment '用户手机号',
   user_id_no           varchar(64) comment '身份证号',
   is_old_loan          int(1) default 0 comment '是否老用户借款：0-否，1-是',
   bank_card_no         varchar(32) comment '收款银行卡号',
   bank_code            varchar(64) comment '收款银行编码',
   bank_name            varchar(256) comment '收款银行名称',
   create_time          datetime comment '申请时间',
   borrow_amt           decimal(11,2) default 0 comment '借款金额（单位：元）',
   auth_fee             decimal(11,2) default 0 comment '认证费（单位：元）',
   serve_fee            decimal(11,2) default 0 comment '服务费（单位：元）',
   interest_fee         decimal(11,2) default 0 comment '利息（单位：元）',
   repayment_period     int(2) comment '还款期数',
   repayment_cycle      int(1) comment '还款周期：1-周，2-月',
   installment_rate     decimal(4,2) default 0 comment '分期费率（单位%/期）',
   installment_fee      decimal(11,2) default 0 comment '定额分期费（单位：元/期）',
   overdue_rate         decimal(4,2) default 0 comment '逾期费率（单位%）',
   overdue_fee          decimal(11,2) default 0 comment '定额逾期费（单位：元/天）',
   order_sts            int(2) comment '订单状态：1-已提交，2-风控审核中，3-风控审核通过，4-风控审核拒绝，5-人工审核通过，6-人工审核拒绝，7-放款中，8-放款成功，9-放款失败，10-已结清',
   machine_audit_time   datetime comment '机器审核时间',
   manual_audit_time    datetime comment '人工审核时间',
   audit_manage_name    varchar(32) comment '审核管理员',
   loan_channel         varchar(32) comment '放款渠道',
   loan_time            datetime comment '放款时间',
   device_type          varchar(32) comment '设备类型',
   device_id_code       varchar(256) comment '设备识别码',
   device_model         varchar(256) comment '设备型号',
   reserve_field1       varchar(256) comment '预留字段一',
   reserve_field2       varchar(256) comment '预留字段二',
   reserve_field3       varchar(256) comment '预留字段三',
   update_manage_name   varchar(32) comment '更新管理员',
   tm_smp               timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '时间戳',
   primary key (id)
);

alter table t_pay_borrow_ord comment '借款订单表';

/*==============================================================*/
/* Index: t_pay_borrow_ord_UI1                                  */
/*==============================================================*/
create unique index t_pay_borrow_ord_UI1 on t_pay_borrow_ord
(
   borrow_ord_no
);

/*==============================================================*/
/* Index: t_pay_borrow_ord_I2                                   */
/*==============================================================*/
create index t_pay_borrow_ord_I2 on t_pay_borrow_ord
(
   order_sts
);

/*==============================================================*/
/* Index: t_pay_borrow_ord_I3                                   */
/*==============================================================*/
create index t_pay_borrow_ord_I3 on t_pay_borrow_ord
(
   user_no,
   borrow_ord_no,
   order_sts
);

/*==============================================================*/
/* Table: t_pay_loan_jnl                                        */
/*==============================================================*/
create table t_pay_loan_jnl
(
   id                   int not null comment '主键ID',
   borrow_ord_no        varchar(32) not null comment '借款订单号',
   loan_jnl_no          varchar(32) not null comment '放款流水号',
   user_no              varchar(32) comment '用户编号',
   user_name            varchar(64) comment '用户姓名',
   user_phone           varchar(11) comment '用户手机号',
   user_id_no           varchar(64) comment '身份证号',
   bank_card_no         varchar(32) comment '收款银行卡号',
   bank_code            varchar(64) comment '收款银行编码',
   bank_name            varchar(256) comment '收款银行名称',
   out_merc_id          varchar(64) comment '第三方渠道商户号',
   out_term_id          varchar(64) comment '第三方渠道终端号',
   merc_order_no        varchar(64) comment '商户订单号',
   req_time             datetime comment '请求时间',
   loan_amt             decimal(11,2) comment '放款金额',
   loan_sts             int(2) comment '放款状态：1-初始化，2-处理中，3-代付成功，4-代付失败',
   loan_channel         varchar(32) comment '放款渠道',
   rsp_sts              varchar(64) comment '返回状态',
   rsp_code             varchar(256) comment '返回码',
   rsp_smg              varchar(512) comment '返回信息',
   out_order_no         varchar(128) comment '外部订单号',
   acc_sts              int(2) default 1 comment '对账状态：1-未对账，2-对账成功，3-对账失败，4-我方有对方无，5-对方有我方无，6-金额差错',
   loan_time            datetime comment '放款时间',
   reserve_field1       varchar(256) comment '预留字段一',
   reserve_field2       varchar(256) comment '预留字段二',
   reserve_field3       varchar(256) comment '预留字段三',
   tm_smp               timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '时间戳',
   primary key (id)
);

alter table t_pay_loan_jnl comment '放款流水表';

/*==============================================================*/
/* Index: t_pay_loan_jnl_UI1                                    */
/*==============================================================*/
create unique index t_pay_loan_jnl_UI1 on t_pay_loan_jnl
(
   loan_jnl_no
);

/*==============================================================*/
/* Index: t_pay_loan_jnl_I2                                     */
/*==============================================================*/
create index t_pay_loan_jnl_I2 on t_pay_loan_jnl
(
   loan_sts
);

/*==============================================================*/
/* Index: t_pay_loan_jnl_I3                                     */
/*==============================================================*/
create index t_pay_loan_jnl_I3 on t_pay_loan_jnl
(
   user_no
);

/*==============================================================*/
/* Table: t_pay_repayment_jnl                                   */
/*==============================================================*/
create table t_pay_repayment_jnl
(
   id                   int not null comment '主键ID',
   borrow_ord_no        varchar(32) not null comment '借款订单号',
   repayment_ord_no     varchar(32) not null comment '还款订单号',
   repayment_jnl_no     varchar(32) not null comment '还款流水号',
   user_no              varchar(32) not null comment '用户编号',
   user_name            varchar(64) comment '用户姓名',
   user_phone           varchar(11) comment '用户手机号',
   user_id_no           varchar(64) comment '身份证号',
   req_time             datetime comment '请求时间',
   repayment_amt        decimal(11,2) comment '还款金额',
   repayment_type       int(2) comment '还款方式：1-主动还款，2-代扣，3-后台还款',
   out_merc_id          varchar(64) comment '第三方渠道商户号',
   out_term_id          varchar(64) comment '第三方渠道终端号',
   merc_order_no        varchar(64) comment '商户订单号',
   repayment_sts        int(2) default 1 comment '还款状态：1-初始化，2-处理中，3-还款成功，4-还款失败',
   repayment_channel    varchar(32) comment '还款渠道',
   bank_card_no         varchar(32) comment '还款银行卡号',
   bank_code            varchar(64) comment '还款银行编码',
   bank_name            varchar(256) comment '还款银行名称',
   repayment_end_time   datetime comment '还款完成时间',
   rsp_sts              varchar(64) comment '返回状态',
   rsp_code             varchar(256) comment '返回码',
   rsp_msg              varchar(512) comment '返回信息',
   out_order_no         varchar(128) comment '外部订单号',
   acc_sts              int(2) default 1 comment '对账状态：1-未对账，2-对账成功，3-对账失败，4-我方有对方无，5-对方有我方无，6-金额差错',
   device_type          varchar(32) comment '设备类型',
   device_id_code       varchar(256) comment '设备识别码',
   device_model         varchar(256) comment '设备型号',
   reserve_field1       varchar(256) comment '预留字段一',
   reserve_field2       varchar(256) comment '预留字段二',
   reserve_field3       varchar(256) comment '预留字段三',
   tm_smp               timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '时间戳',
   primary key (id)
);

alter table t_pay_repayment_jnl comment '还款流水表';

/*==============================================================*/
/* Index: t_pay_repayment_jnl_IU1                               */
/*==============================================================*/
create unique index t_pay_repayment_jnl_IU1 on t_pay_repayment_jnl
(
   repayment_jnl_no
);

/*==============================================================*/
/* Index: t_pay_repayment_jnl_IU2                               */
/*==============================================================*/
create index t_pay_repayment_jnl_IU2 on t_pay_repayment_jnl
(
   repayment_sts
);

/*==============================================================*/
/* Index: t_pay_repayment_jnl_IU3                               */
/*==============================================================*/
create index t_pay_repayment_jnl_IU3 on t_pay_repayment_jnl
(
   user_no
);

/*==============================================================*/
/* Index: t_pay_repayment_jnl_IU4                               */
/*==============================================================*/
create index t_pay_repayment_jnl_IU4 on t_pay_repayment_jnl
(
   borrow_ord_no,
   user_no,
   repayment_sts
);

/*==============================================================*/
/* Index: t_pay_repayment_jnl_IU5                               */
/*==============================================================*/
create index t_pay_repayment_jnl_IU5 on t_pay_repayment_jnl
(
   repayment_ord_no,
   user_no,
   repayment_sts
);

/*==============================================================*/
/* Table: t_pay_repayment_ord                                   */
/*==============================================================*/
create table t_pay_repayment_ord
(
   id                   int not null comment '主键ID',
   borrow_ord_no        varchar(32) not null comment '借款订单号',
   repayment_ord_no     varchar(32) not null comment '还款订单号',
   user_no              varchar(32) not null comment '用户编号',
   user_name            varchar(64) comment '用户姓名',
   user_phone           varchar(11) comment '用户手机号',
   user_id_no           varchar(64) comment '身份证号',
   repayment_period     int(2) comment '还款期数',
   installment_num      int(2) not null comment '当前分期期数',
   repayment_amt        decimal(11,2) default 0 comment '应还本金',
   repayment_fee        decimal(11,2) default 0 comment '应还利息',
   repayment_end_date   date comment '最后还款日',
   repayment_cycle      int(1) comment '还款周期：1-周，2-月',
   repayment_sts        int(2) default 1 comment '还款状态：1-待还款，2-已逾期，3-已还款',
   is_renewal           int(1) default 0 comment '是否续期：0-否，1-是',
   is_overdue           int(1) default 0 comment '是否逾期：0-否，1-是',
   repaymented_amt      decimal(11,2) default 0 comment '已还款金额',
   waiver_amount        decimal(11,2) default 0 comment '减免金额',
   overdue_day          int(5) default 0 comment '逾期天数',
   overdue_rate         decimal(4,2) default 0 comment '逾期费率（%）',
   overdue_fee          decimal(11,2) default 0 comment '定额逾期费（元/天）',
   overdue_amt          decimal(11,2) default 0 comment '逾期金额',
   repaymented_time     datetime comment '还款完成时间',
   repayment_channel    varchar(32) comment '还款渠道',
   bank_card_no         varchar(32) comment '还款银行卡号',
   bank_code            varchar(64) comment '还款银行编码',
   bank_name            varchar(256) comment '还款银行名称',
   reserve_field1       varchar(256) comment '预留字段一',
   reserve_field2       varchar(256) comment '预留字段二',
   reserve_field3       varchar(256) comment '预留字段三',
   update_manage_name   varchar(32) comment '更新操作员',
   tm_smp               timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '时间戳',
   primary key (id)
);

alter table t_pay_repayment_ord comment '还款订单表';

/*==============================================================*/
/* Index: t_pay_repayment_ord_UI1                               */
/*==============================================================*/
create unique index t_pay_repayment_ord_UI1 on t_pay_repayment_ord
(
   repayment_ord_no
);

/*==============================================================*/
/* Index: t_pay_repayment_ord_I2                                */
/*==============================================================*/
create index t_pay_repayment_ord_I2 on t_pay_repayment_ord
(
   repayment_sts
);

/*==============================================================*/
/* Index: t_pay_repayment_ord_I3                                */
/*==============================================================*/
create index t_pay_repayment_ord_I3 on t_pay_repayment_ord
(
   user_no
);

/*==============================================================*/
/* Index: t_pay_repayment_ord_I4                                */
/*==============================================================*/
create index t_pay_repayment_ord_I4 on t_pay_repayment_ord
(
   repayment_ord_no,
   user_no,
   repayment_sts
);

/*==============================================================*/
/* Index: t_pay_repayment_ord_I5                                */
/*==============================================================*/
create index t_pay_repayment_ord_I5 on t_pay_repayment_ord
(
   borrow_ord_no,
   user_no,
   repayment_sts
);

/*==============================================================*/
/* Table: t_sys_feedback                                        */
/*==============================================================*/
create table t_sys_feedback
(
   id                   int not null auto_increment comment '主键ID',
   feedback_source      int(1) comment '反馈来源：1-ios，2-android',
   user_no              varchar(32) comment '用户编号',
   user_name            varchar(64) comment '用户名称',
   user_phone           varchar(11) comment '用户手机号',
   feedback_info        varchar(1024) comment '反馈信息',
   tm_smp               timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '时间戳',
   primary key (id)
);

alter table t_sys_feedback comment '系统意见反馈表';

/*==============================================================*/
/* Table: t_sys_module                                          */
/*==============================================================*/
create table t_sys_module
(
   id                   int not null auto_increment comment '主键ID',
   module_id            varchar(32) comment '模块ID',
   super_module_id      varchar(32) comment '上级模块ID',
   module_url           varchar(256) comment '模块URL',
   module_type          int(2) comment '模块类型：1-菜单，2-页面，3-按钮',
   module_rank          int(2) comment '模块排序',
   enable               int(1) comment '是否生效：0-无效，1-有效',
   remark               varchar(256) comment '备注',
   create_account       varchar(16) comment '创建人',
   create_time          datetime comment '创建时间',
   update_account       varchar(16) comment '更新人',
   tm_smp               timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '时间戳',
   primary key (id)
);

alter table t_sys_module comment '系统模块表';

/*==============================================================*/
/* Table: t_sys_notice_config                                   */
/*==============================================================*/
create table t_sys_notice_config
(
   id                   int not null auto_increment comment '主键ID',
   notice_title         varchar(32) comment '公告主题',
   notice_desc          varchar(256) comment '公告概述',
   notice_url           varchar(256) comment '公告URL',
   eff_time             datetime comment '生效时间',
   exp_time             datetime comment '失效时间',
   create_account       varchar(16) comment '创建人',
   create_time          datetime comment '创建时间',
   update_account       varchar(16) comment 'update_account',
   tm_smp               timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '时间戳',
   primary key (id)
);

alter table t_sys_notice_config comment '系统公告配置表';

/*==============================================================*/
/* Table: t_sys_param                                           */
/*==============================================================*/
create table t_sys_param
(
   id                   int not null auto_increment comment '主键ID',
   param_type           varchar(64) not null comment '参数类型',
   param_key            varchar(64) not null comment '参数键',
   param_name           varchar(256) not null comment '参数名称',
   param_val            varchar(256) not null comment '参数值',
   remark               varchar(256) comment '备注',
   create_time          datetime comment '创建时间',
   tm_smp               timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '时间戳',
   primary key (id)
);

alter table t_sys_param comment '系统参数表';

/*==============================================================*/
/* Index: t_sys_param_UI1                                       */
/*==============================================================*/
create unique index t_sys_param_UI1 on t_sys_param
(
   param_type,
   param_key,
   param_val
);

/*==============================================================*/
/* Table: t_sys_region                                          */
/*==============================================================*/
create table t_sys_region
(
   id                   int not null comment '地区码',
   name                 varchar(40) comment '地区名称',
   parent_id            int comment '上级ID',
   short_name           varchar(40) comment '简称',
   level_type           int(2) comment '类型：0-国家，1-省，2-市，3-区县',
   city_code            varchar(20) comment '城市区号',
   zip_code             varchar(20) comment '邮政编码',
   merge_name           varchar(128) comment '全称',
   lng                  float comment '经度',
   lat                  float comment '维度',
   pin_yin              varchar(128) comment '拼音',
   tm_smp               timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '时间戳',
   primary key (id)
);

alter table t_sys_region comment '系统地区码表';

/*==============================================================*/
/* Table: t_sys_return_code                                     */
/*==============================================================*/
create table t_sys_return_code
(
   id                   int not null auto_increment comment '主键ID',
   return_code          varchar(16) not null comment '返回码',
   return_type          int(2) comment '返回码类型：1-成功，2-失败，3-处理中，4-未登录',
   return_info          varchar(256) comment '返回信息',
   create_time          datetime comment '创建时间',
   tm_smp               timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '时间戳',
   primary key (id)
);

alter table t_sys_return_code comment '系统返回码表';

/*==============================================================*/
/* Index: t_message_conf_UI1                                    */
/*==============================================================*/
create unique index t_message_conf_UI1 on t_sys_return_code
(
   return_code
);

/*==============================================================*/
/* Table: t_sys_role                                            */
/*==============================================================*/
create table t_sys_role
(
   id                   int not null auto_increment comment '主键ID',
   role_id              varchar(32) not null comment '角色ID',
   super_role_id        varchar(32) comment '上级角色ID',
   role_name            varchar(32) not null comment '角色名称',
   enable               int(1) comment '是否生效：0-无效，1-有效',
   create_account       varchar(16) comment '创建人',
   create_time          datetime comment '创建时间',
   update_account       varchar(16) comment '更新人',
   tm_smp               timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '时间戳',
   primary key (id)
);

alter table t_sys_role comment '系统角色表';

/*==============================================================*/
/* Index: t_sys_role_UI1                                        */
/*==============================================================*/
create unique index t_sys_role_UI1 on t_sys_role
(
   role_id
);

/*==============================================================*/
/* Index: t_sys_role_I2                                         */
/*==============================================================*/
create index t_sys_role_I2 on t_sys_role
(
   super_role_id
);

/*==============================================================*/
/* Table: t_sys_role_module                                     */
/*==============================================================*/
create table t_sys_role_module
(
   id                   int not null auto_increment comment '主键ID',
   module_id            varchar(32) comment '模块ID',
   role_id              varchar(32) comment '角色ID',
   create_time          datetime comment '创建时间',
   tm_smp               timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '时间戳',
   primary key (id)
);

alter table t_sys_role_module comment '系统角色模块对应表';

/*==============================================================*/
/* Index: t_sys_role_module_UI1                                 */
/*==============================================================*/
create index t_sys_role_module_UI1 on t_sys_role_module
(
   role_id,
   module_id
);

/*==============================================================*/
/* Table: t_sys_user                                            */
/*==============================================================*/
create table t_sys_user
(
   id                   int not null auto_increment comment '主键ID',
   user_id              varchar(32) not null comment '用户ID',
   role_id              varchar(32) not null comment '角色ID',
   user_account         varchar(16) not null comment '账号',
   user_passwd          varchar(32) not null comment '密码',
   user_sts             int(1) not null default 1 comment '状态：0-无效，1-有效',
   user_type            int(2) comment '用户类型：1-管理员，2-普通用户',
   user_name            varchar(32) comment '姓名',
   user_phone           varchar(11) comment '手机号',
   user_email           varchar(128) comment '邮箱',
   remark               varchar(256) comment '备注',
   login_time           datetime comment '最后登录时间',
   create_time          datetime comment '创建时间',
   tm_smp               timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '时间戳',
   primary key (id)
);

alter table t_sys_user comment '系统用户表';

/*==============================================================*/
/* Index: t_sys_user_UI1                                        */
/*==============================================================*/
create unique index t_sys_user_UI1 on t_sys_user
(
   user_id
);

/*==============================================================*/
/* Index: t_sys_user_UI2                                        */
/*==============================================================*/
create unique index t_sys_user_UI2 on t_sys_user
(
   user_account
);

/*==============================================================*/
/* Index: t_sys_user_I3                                         */
/*==============================================================*/
create index t_sys_user_I3 on t_sys_user
(
   role_id
);

/*==============================================================*/
/* Table: t_user_card                                           */
/*==============================================================*/
create table t_user_card
(
   id                   int not null comment '主键ID',
   user_no              varchar(32) not null comment '用户编号',
   bank_card_no         varchar(32) comment '银行卡号',
   bank_code            varchar(64) comment '银行编码',
   bank_name            varchar(256) comment '银行名称',
   bind_id              varchar(128) comment '绑卡编号',
   bind_sts             int(2) comment '绑卡状态：1-初始化，2-绑卡成功，3-绑卡失败',
   bind_type            int(2) comment '绑卡渠道',
   bind_time            datetime comment '绑卡时间',
   tm_smp               timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '时间戳',
   primary key (id)
);

alter table t_user_card comment '用户绑卡表';

/*==============================================================*/
/* Index: t_user_card_UI1                                       */
/*==============================================================*/
create unique index t_user_card_UI1 on t_user_card
(
   user_no,
   bank_card_no
);

/*==============================================================*/
/* Table: t_user_contacts                                       */
/*==============================================================*/
create table t_user_contacts
(
   id                   int not null comment '主键ID',
   user_no              varchar(32) comment '用户编号',
   contacts_type        int(2) comment '联系人类型：1-第一联系人，2-第二联系人',
   contacts_relation    int(2) comment '联系人关系',
   contacts_name        varchar(64) comment '联系人姓名',
   contacts_phone       varchar(11) comment '联系人手机号',
   tm_smp               timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '时间戳',
   primary key (id)
);

alter table t_user_contacts comment '用户紧急联系人表';

/*==============================================================*/
/* Index: t_user_contacts_UI1                                   */
/*==============================================================*/
create unique index t_user_contacts_UI1 on t_user_contacts
(
   user_no,
   contacts_type
);

/*==============================================================*/
/* Index: t_user_contacts_UI2                                   */
/*==============================================================*/
create unique index t_user_contacts_UI2 on t_user_contacts
(
   user_no,
   contacts_phone
);

/*==============================================================*/
/* Table: t_user_info                                           */
/*==============================================================*/
create table t_user_info
(
   id                   int not null auto_increment comment '主键ID',
   user_no              varchar(32) not null comment '用户编号',
   user_name            varchar(64) comment '用户姓名',
   user_phone           varchar(11) not null comment '手机号',
   sex                  int(2) comment '性别',
   race                 varchar(32) comment '名族',
   user_id_no           varchar(64) comment '身份证号',
   login_password       varchar(256) comment '登录密码',
   pay_password         varchar(256) comment '支付密码',
   province             int comment '所在省',
   city                 int comment '所在市',
   area                 int comment '所在区县',
   address              varchar(256) comment '详细地址',
   live_time            int(2) comment '居住时长',
   house_type           int(2) comment '房屋类型',
   industry             int comment '行业类别',
   position             int comment '职位',
   income               decimal(10,2) comment '收入',
   work_unit_name       varchar(128) comment '单位名称',
   work_unit_addr       varchar(128) comment '单位地址',
   work_unit_tel        varchar(32) comment '单位电话',
   marriage_sts         int(2) comment '婚姻状态',
   education            int(2) comment '学历',
   create_time          datetime not null comment '注册时间',
   user_sts             int(2) not null default 1 comment '用户状态：1-正常，2-注销，3-灰名单，4-黑名单',
   is_old               int(1) default 0 comment '是否老用户：0-否，1-是',
   share_code           varchar(64) comment '邀请码',
   invite_rate          decimal(4,2) default 0 comment '邀请返利率',
   invite_user_no       varchar(32) comment '邀请人编号',
   is_identity_info     int(1) default 0 comment '是否提交身份信息：0-否，1-是',
   is_real_name         int(1) default 0 comment '是否已实名认证：0-否，1-是，2-认证中',
   is_bind_card         int(1) default 0 comment '是否已绑卡：0-否，1-是',
   is_linkman           int(1) default 0 comment '是否提交紧急联系人：0-否，1-是',
   is_operator          int(1) default 0 comment '是否运营商认证：0-否，1-是，2-认证中',
   is_ec_auth           int(1) comment '是否提交电商认证：0-否，1-是，2-认证中',
   reserve_field1       varchar(256) comment '预留字段一',
   reserve_field2       varchar(256) comment '预留字段二',
   reserve_field3       varchar(256) comment '预留字段三',
   tm_smp               timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '时间戳',
   primary key (id)
);

alter table t_user_info comment '用户信息表';

/*==============================================================*/
/* Index: t_user_info_UI1                                       */
/*==============================================================*/
create unique index t_user_info_UI1 on t_user_info
(
   user_no
);

/*==============================================================*/
/* Index: t_user_info_UI2                                       */
/*==============================================================*/
create unique index t_user_info_UI2 on t_user_info
(
   user_id_no
);

/*==============================================================*/
/* Index: t_user_info_UI3                                       */
/*==============================================================*/
create unique index t_user_info_UI3 on t_user_info
(
   user_phone
);

/*==============================================================*/
/* Table: t_user_operator_auth                                  */
/*==============================================================*/
create table t_user_operator_auth
(
   id                   int not null comment '主键ID',
   user_no              varchar(32) not null comment '用户编号',
   auth_sts             int(2) comment '认证状态：0-未认证，1-已认证，2-已过期',
   auth_time            datetime comment '认证时间',
   tm_smp               timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '时间戳',
   primary key (id)
);

alter table t_user_operator_auth comment '用户运营商认证表（待完善）';

/*==============================================================*/
/* Table: t_user_phone_list                                     */
/*==============================================================*/
create table t_user_phone_list
(
   id                   int not null auto_increment comment '主键ID',
   user_no              varchar(32) not null comment '用户编号',
   phone_name           varchar(64) comment '通讯录名称',
   phone_no             varchar(64) comment '手机号码',
   tm_smp               timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '时间戳',
   primary key (id)
);

alter table t_user_phone_list comment '用户通讯录表';

/*==============================================================*/
/* Index: t_user_phone_list_UI1                                 */
/*==============================================================*/
create unique index t_user_phone_list_UI1 on t_user_phone_list
(
   user_no,
   phone_no,
   phone_name
);

/*==============================================================*/
/* Table: t_user_realname                                       */
/*==============================================================*/
create table t_user_realname
(
   id                   int not null comment '主键ID',
   user_no              varchar(32) not null comment '用户编号',
   face_picture_url     varchar(512) comment '人脸图片地址',
   face_picture_pub_url varchar(512) comment '人脸图片访问地址',
   id_positive_picture_url varchar(512) comment '身份证正面图片地址',
   id_positive_picture_pub_url varchar(512) comment '身份证正面图片访问地址',
   id_anti_picture_url  varchar(512) comment '身份证反面图片地址',
   id_anti_picture_pub_url varchar(512) comment '身份证反面图片访问地址',
   update_time          datetime comment '更新时间',
   tm_smp               timestamp not null default CURRENT_TIMESTAMP comment '时间戳',
   primary key (id)
);

alter table t_user_realname comment '用户实名表';

/*==============================================================*/
/* Index: t_realname_auth_UI1                                   */
/*==============================================================*/
create unique index t_realname_auth_UI1 on t_user_realname
(
   user_no
);


