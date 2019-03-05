
create table t_channel_payment_config
(
   id                   int not null auto_increment comment '����ID',
   channel_type         varchar(32) not null comment '��������',
   channel_name         varchar(64) comment '��������',
   channel_server_bean  varchar(128) not null comment '��������bean',
   priority             int default 0 comment '���ȼ�',
   loan_quota           decimal(11,2) default 0 comment '�ſ���',
   eff_time             datetime not null comment '��Чʱ��',
   exp_time             datetime not null comment 'ʧЧʱ��',
   create_account       varchar(64) comment '������',
   create_time          datetime comment '����ʱ��',
   update_account       varchar(64) comment '�޸���',
   tm_smp               timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment 'ʱ���',
   primary key (id)
);

alter table t_channel_payment_config comment '�����������ñ�';

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
   id                   int not null auto_increment comment '����ID',
   cut_date             date comment 'ͳ������',
   channel_type         varchar(32) comment '��������',
   payment_amt          decimal(11,2) default 0 comment '�ſ���',
   tm_xmp               timestamp comment 'ʱ���',
   primary key (id)
);

alter table t_channel_payment_quota_count comment '�������ͳ�Ʊ�';

/*==============================================================*/
/* Table: t_channel_withhold_config                             */
/*==============================================================*/
create table t_channel_withhold_config
(
   id                   int not null auto_increment comment '����ID',
   channel_type         varchar(32) not null comment '��������',
   channel_name         varchar(64) comment '��������',
   channel_server_bean  varchar(128) not null comment '��������bean',
   priority             int default 0 comment '���ȼ�',
   eff_time             datetime not null comment '��Чʱ��',
   exp_time             datetime not null comment 'ʧЧʱ��',
   create_account       varchar(64) comment '������',
   create_time          datetime comment '����ʱ��',
   update_account       varchar(64) comment '�޸���',
   tm_smp               timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment 'ʱ���',
   primary key (id)
);

alter table t_channel_withhold_config comment '�����������ñ�';

/*==============================================================*/
/* Table: t_channel_withhold_count                              */
/*==============================================================*/
create table t_channel_withhold_count
(
   id                   int not null auto_increment comment '����ID',
   cut_date             date comment 'ͳ������',
   channel_type         varchar(32) comment '��������',
   withhold_amt         decimal(11,2) default 0 comment '���۽��',
   tm_xmp               timestamp comment 'ʱ���',
   primary key (id)
);

alter table t_channel_withhold_count comment '����ͳ�Ʊ�';

/*==============================================================*/
/* Table: t_message_conf                                        */
/*==============================================================*/
create table t_message_conf
(
   id                   int not null auto_increment comment '����ID',
   msg_no               varchar(32) not null comment 'ģ����',
   msg_title            varchar(64) comment '��������',
   msg_template         varchar(1024) comment '����ģ��',
   create_time          datetime comment '����ʱ��',
   tm_smp               timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment 'ʱ���',
   primary key (id)
);

alter table t_message_conf comment '����ģ���';

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
   id                   int not null auto_increment comment '����ID',
   rec_name             varchar(64) comment '����������',
   rec_phone            varchar(11) not null comment '�������ֻ���',
   rec_user_type        int(2) comment '���������ͣ�1-ϵͳ����Ա��2-��ͨ����Ա��3-�û�',
   msg_title            varchar(64) comment '���ű���',
   msg_content          varchar(1024) comment '��������',
   msg_send_time        datetime comment '���ŷ���ʱ��',
   tm_smp               timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment 'ʱ���',
   primary key (id)
);

alter table t_message_record comment '���ż�¼��';

/*==============================================================*/
/* Table: t_pay_borrow_ord                                      */
/*==============================================================*/
create table t_pay_borrow_ord
(
   id                   int not null auto_increment comment '����ID',
   borrow_ord_no        varchar(32) not null comment '������',
   user_no              varchar(32) not null comment '�û����',
   user_name            varchar(64) comment '�û�����',
   user_phone           varchar(11) comment '�û��ֻ���',
   user_id_no           varchar(64) comment '���֤��',
   is_old_loan          int(1) default 0 comment '�Ƿ����û���0-��1-��',
   bank_card_no         varchar(32) comment '�տ����п���',
   bank_code            varchar(64) comment '�տ����б���',
   bank_name            varchar(256) comment '�տ���������',
   create_time          datetime comment '����ʱ��',
   borrow_amt           decimal(11,2) default 0 comment '������λ��Ԫ��',
   auth_fee             decimal(11,2) default 0 comment '��֤�ѣ���λ��Ԫ��',
   serve_fee            decimal(11,2) default 0 comment '����ѣ���λ��Ԫ��',
   interest_fee         decimal(11,2) default 0 comment '��Ϣ����λ��Ԫ��',
   repayment_period     int(2) comment '��������',
   repayment_cycle      int(1) comment '�������ڣ�1-�ܣ�2-��',
   installment_rate     decimal(4,2) default 0 comment '���ڷ��ʣ���λ%/�ڣ�',
   installment_fee      decimal(11,2) default 0 comment '������ڷѣ���λ��Ԫ/�ڣ�',
   overdue_rate         decimal(4,2) default 0 comment '���ڷ��ʣ���λ%��',
   overdue_fee          decimal(11,2) default 0 comment '�������ڷѣ���λ��Ԫ/�죩',
   order_sts            int(2) comment '����״̬��1-���ύ��2-�������У�3-������ͨ����4-�����˾ܾ���5-�˹����ͨ����6-�˹���˾ܾ���7-�ſ��У�8-�ſ�ɹ���9-�ſ�ʧ�ܣ�10-�ѽ���',
   machine_audit_time   datetime comment '�������ʱ��',
   manual_audit_time    datetime comment '�˹����ʱ��',
   audit_manage_name    varchar(32) comment '��˹���Ա',
   loan_channel         varchar(32) comment '�ſ�����',
   loan_time            datetime comment '�ſ�ʱ��',
   device_type          varchar(32) comment '�豸����',
   device_id_code       varchar(256) comment '�豸ʶ����',
   device_model         varchar(256) comment '�豸�ͺ�',
   reserve_field1       varchar(256) comment 'Ԥ���ֶ�һ',
   reserve_field2       varchar(256) comment 'Ԥ���ֶζ�',
   reserve_field3       varchar(256) comment 'Ԥ���ֶ���',
   update_manage_name   varchar(32) comment '���¹���Ա',
   tm_smp               timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment 'ʱ���',
   primary key (id)
);

alter table t_pay_borrow_ord comment '������';

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
   id                   int not null comment '����ID',
   borrow_ord_no        varchar(32) not null comment '������',
   loan_jnl_no          varchar(32) not null comment '�ſ���ˮ��',
   user_no              varchar(32) comment '�û����',
   user_name            varchar(64) comment '�û�����',
   user_phone           varchar(11) comment '�û��ֻ���',
   user_id_no           varchar(64) comment '���֤��',
   bank_card_no         varchar(32) comment '�տ����п���',
   bank_code            varchar(64) comment '�տ����б���',
   bank_name            varchar(256) comment '�տ���������',
   out_merc_id          varchar(64) comment '�����������̻���',
   out_term_id          varchar(64) comment '�����������ն˺�',
   merc_order_no        varchar(64) comment '�̻�������',
   req_time             datetime comment '����ʱ��',
   loan_amt             decimal(11,2) comment '�ſ���',
   loan_sts             int(2) comment '�ſ�״̬��1-��ʼ����2-�����У�3-�����ɹ���4-����ʧ��',
   loan_channel         varchar(32) comment '�ſ�����',
   rsp_sts              varchar(64) comment '����״̬',
   rsp_code             varchar(256) comment '������',
   rsp_smg              varchar(512) comment '������Ϣ',
   out_order_no         varchar(128) comment '�ⲿ������',
   acc_sts              int(2) default 1 comment '����״̬��1-δ���ˣ�2-���˳ɹ���3-����ʧ�ܣ�4-�ҷ��жԷ��ޣ�5-�Է����ҷ��ޣ�6-�����',
   loan_time            datetime comment '�ſ�ʱ��',
   reserve_field1       varchar(256) comment 'Ԥ���ֶ�һ',
   reserve_field2       varchar(256) comment 'Ԥ���ֶζ�',
   reserve_field3       varchar(256) comment 'Ԥ���ֶ���',
   tm_smp               timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment 'ʱ���',
   primary key (id)
);

alter table t_pay_loan_jnl comment '�ſ���ˮ��';

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
   id                   int not null comment '����ID',
   borrow_ord_no        varchar(32) not null comment '������',
   repayment_ord_no     varchar(32) not null comment '�������',
   repayment_jnl_no     varchar(32) not null comment '������ˮ��',
   user_no              varchar(32) not null comment '�û����',
   user_name            varchar(64) comment '�û�����',
   user_phone           varchar(11) comment '�û��ֻ���',
   user_id_no           varchar(64) comment '���֤��',
   req_time             datetime comment '����ʱ��',
   repayment_amt        decimal(11,2) comment '������',
   repayment_type       int(2) comment '���ʽ��1-�������2-���ۣ�3-��̨����',
   out_merc_id          varchar(64) comment '�����������̻���',
   out_term_id          varchar(64) comment '�����������ն˺�',
   merc_order_no        varchar(64) comment '�̻�������',
   repayment_sts        int(2) default 1 comment '����״̬��1-��ʼ����2-�����У�3-����ɹ���4-����ʧ��',
   repayment_channel    varchar(32) comment '��������',
   bank_card_no         varchar(32) comment '�������п���',
   bank_code            varchar(64) comment '�������б���',
   bank_name            varchar(256) comment '������������',
   repayment_end_time   datetime comment '�������ʱ��',
   rsp_sts              varchar(64) comment '����״̬',
   rsp_code             varchar(256) comment '������',
   rsp_msg              varchar(512) comment '������Ϣ',
   out_order_no         varchar(128) comment '�ⲿ������',
   acc_sts              int(2) default 1 comment '����״̬��1-δ���ˣ�2-���˳ɹ���3-����ʧ�ܣ�4-�ҷ��жԷ��ޣ�5-�Է����ҷ��ޣ�6-�����',
   device_type          varchar(32) comment '�豸����',
   device_id_code       varchar(256) comment '�豸ʶ����',
   device_model         varchar(256) comment '�豸�ͺ�',
   reserve_field1       varchar(256) comment 'Ԥ���ֶ�һ',
   reserve_field2       varchar(256) comment 'Ԥ���ֶζ�',
   reserve_field3       varchar(256) comment 'Ԥ���ֶ���',
   tm_smp               timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment 'ʱ���',
   primary key (id)
);

alter table t_pay_repayment_jnl comment '������ˮ��';

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
   id                   int not null comment '����ID',
   borrow_ord_no        varchar(32) not null comment '������',
   repayment_ord_no     varchar(32) not null comment '�������',
   user_no              varchar(32) not null comment '�û����',
   user_name            varchar(64) comment '�û�����',
   user_phone           varchar(11) comment '�û��ֻ���',
   user_id_no           varchar(64) comment '���֤��',
   repayment_period     int(2) comment '��������',
   installment_num      int(2) not null comment '��ǰ��������',
   repayment_amt        decimal(11,2) default 0 comment 'Ӧ������',
   repayment_fee        decimal(11,2) default 0 comment 'Ӧ����Ϣ',
   repayment_end_date   date comment '��󻹿���',
   repayment_cycle      int(1) comment '�������ڣ�1-�ܣ�2-��',
   repayment_sts        int(2) default 1 comment '����״̬��1-�����2-�����ڣ�3-�ѻ���',
   is_renewal           int(1) default 0 comment '�Ƿ����ڣ�0-��1-��',
   is_overdue           int(1) default 0 comment '�Ƿ����ڣ�0-��1-��',
   repaymented_amt      decimal(11,2) default 0 comment '�ѻ�����',
   waiver_amount        decimal(11,2) default 0 comment '������',
   overdue_day          int(5) default 0 comment '��������',
   overdue_rate         decimal(4,2) default 0 comment '���ڷ��ʣ�%��',
   overdue_fee          decimal(11,2) default 0 comment '�������ڷѣ�Ԫ/�죩',
   overdue_amt          decimal(11,2) default 0 comment '���ڽ��',
   repaymented_time     datetime comment '�������ʱ��',
   repayment_channel    varchar(32) comment '��������',
   bank_card_no         varchar(32) comment '�������п���',
   bank_code            varchar(64) comment '�������б���',
   bank_name            varchar(256) comment '������������',
   reserve_field1       varchar(256) comment 'Ԥ���ֶ�һ',
   reserve_field2       varchar(256) comment 'Ԥ���ֶζ�',
   reserve_field3       varchar(256) comment 'Ԥ���ֶ���',
   update_manage_name   varchar(32) comment '���²���Ա',
   tm_smp               timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment 'ʱ���',
   primary key (id)
);

alter table t_pay_repayment_ord comment '�������';

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
   id                   int not null auto_increment comment '����ID',
   feedback_source      int(1) comment '������Դ��1-ios��2-android',
   user_no              varchar(32) comment '�û����',
   user_name            varchar(64) comment '�û�����',
   user_phone           varchar(11) comment '�û��ֻ���',
   feedback_info        varchar(1024) comment '������Ϣ',
   tm_smp               timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment 'ʱ���',
   primary key (id)
);

alter table t_sys_feedback comment 'ϵͳ���������';

/*==============================================================*/
/* Table: t_sys_module                                          */
/*==============================================================*/
create table t_sys_module
(
   id                   int not null auto_increment comment '����ID',
   module_id            varchar(32) comment 'ģ��ID',
   super_module_id      varchar(32) comment '�ϼ�ģ��ID',
   module_url           varchar(256) comment 'ģ��URL',
   module_type          int(2) comment 'ģ�����ͣ�1-�˵���2-ҳ�棬3-��ť',
   module_rank          int(2) comment 'ģ������',
   enable               int(1) comment '�Ƿ���Ч��0-��Ч��1-��Ч',
   remark               varchar(256) comment '��ע',
   create_account       varchar(16) comment '������',
   create_time          datetime comment '����ʱ��',
   update_account       varchar(16) comment '������',
   tm_smp               timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment 'ʱ���',
   primary key (id)
);

alter table t_sys_module comment 'ϵͳģ���';

/*==============================================================*/
/* Table: t_sys_notice_config                                   */
/*==============================================================*/
create table t_sys_notice_config
(
   id                   int not null auto_increment comment '����ID',
   notice_title         varchar(32) comment '��������',
   notice_desc          varchar(256) comment '�������',
   notice_url           varchar(256) comment '����URL',
   eff_time             datetime comment '��Чʱ��',
   exp_time             datetime comment 'ʧЧʱ��',
   create_account       varchar(16) comment '������',
   create_time          datetime comment '����ʱ��',
   update_account       varchar(16) comment 'update_account',
   tm_smp               timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment 'ʱ���',
   primary key (id)
);

alter table t_sys_notice_config comment 'ϵͳ�������ñ�';

/*==============================================================*/
/* Table: t_sys_param                                           */
/*==============================================================*/
create table t_sys_param
(
   id                   int not null auto_increment comment '����ID',
   param_type           varchar(64) not null comment '��������',
   param_key            varchar(64) not null comment '������',
   param_name           varchar(256) not null comment '��������',
   param_val            varchar(256) not null comment '����ֵ',
   remark               varchar(256) comment '��ע',
   create_time          datetime comment '����ʱ��',
   tm_smp               timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment 'ʱ���',
   primary key (id)
);

alter table t_sys_param comment 'ϵͳ������';

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
   id                   int not null comment '������',
   name                 varchar(40) comment '��������',
   parent_id            int comment '�ϼ�ID',
   short_name           varchar(40) comment '���',
   level_type           int(2) comment '���ͣ�0-���ң�1-ʡ��2-�У�3-����',
   city_code            varchar(20) comment '��������',
   zip_code             varchar(20) comment '��������',
   merge_name           varchar(128) comment 'ȫ��',
   lng                  float comment '����',
   lat                  float comment 'ά��',
   pin_yin              varchar(128) comment 'ƴ��',
   tm_smp               timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment 'ʱ���',
   primary key (id)
);

alter table t_sys_region comment 'ϵͳ�������';

/*==============================================================*/
/* Table: t_sys_return_code                                     */
/*==============================================================*/
create table t_sys_return_code
(
   id                   int not null auto_increment comment '����ID',
   return_code          varchar(16) not null comment '������',
   return_type          int(2) comment '���������ͣ�1-�ɹ���2-ʧ�ܣ�3-�����У�4-δ��¼',
   return_info          varchar(256) comment '������Ϣ',
   create_time          datetime comment '����ʱ��',
   tm_smp               timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment 'ʱ���',
   primary key (id)
);

alter table t_sys_return_code comment 'ϵͳ�������';

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
   id                   int not null auto_increment comment '����ID',
   role_id              varchar(32) not null comment '��ɫID',
   super_role_id        varchar(32) comment '�ϼ���ɫID',
   role_name            varchar(32) not null comment '��ɫ����',
   enable               int(1) comment '�Ƿ���Ч��0-��Ч��1-��Ч',
   create_account       varchar(16) comment '������',
   create_time          datetime comment '����ʱ��',
   update_account       varchar(16) comment '������',
   tm_smp               timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment 'ʱ���',
   primary key (id)
);

alter table t_sys_role comment 'ϵͳ��ɫ��';

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
   id                   int not null auto_increment comment '����ID',
   module_id            varchar(32) comment 'ģ��ID',
   role_id              varchar(32) comment '��ɫID',
   create_time          datetime comment '����ʱ��',
   tm_smp               timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment 'ʱ���',
   primary key (id)
);

alter table t_sys_role_module comment 'ϵͳ��ɫģ���Ӧ��';

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
   id                   int not null auto_increment comment '����ID',
   user_id              varchar(32) not null comment '�û�ID',
   role_id              varchar(32) not null comment '��ɫID',
   user_account         varchar(16) not null comment '�˺�',
   user_passwd          varchar(32) not null comment '����',
   user_sts             int(1) not null default 1 comment '״̬��0-��Ч��1-��Ч',
   user_type            int(2) comment '�û����ͣ�1-����Ա��2-��ͨ�û�',
   user_name            varchar(32) comment '����',
   user_phone           varchar(11) comment '�ֻ���',
   user_email           varchar(128) comment '����',
   remark               varchar(256) comment '��ע',
   login_time           datetime comment '����¼ʱ��',
   create_time          datetime comment '����ʱ��',
   tm_smp               timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment 'ʱ���',
   primary key (id)
);

alter table t_sys_user comment 'ϵͳ�û���';

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
   id                   int not null comment '����ID',
   user_no              varchar(32) not null comment '�û����',
   bank_card_no         varchar(32) comment '���п���',
   bank_code            varchar(64) comment '���б���',
   bank_name            varchar(256) comment '��������',
   bind_id              varchar(128) comment '�󿨱��',
   bind_sts             int(2) comment '��״̬��1-��ʼ����2-�󿨳ɹ���3-��ʧ��',
   bind_type            int(2) comment '������',
   bind_time            datetime comment '��ʱ��',
   tm_smp               timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment 'ʱ���',
   primary key (id)
);

alter table t_user_card comment '�û��󿨱�';

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
   id                   int not null comment '����ID',
   user_no              varchar(32) comment '�û����',
   contacts_type        int(2) comment '��ϵ�����ͣ�1-��һ��ϵ�ˣ�2-�ڶ���ϵ��',
   contacts_relation    int(2) comment '��ϵ�˹�ϵ',
   contacts_name        varchar(64) comment '��ϵ������',
   contacts_phone       varchar(11) comment '��ϵ���ֻ���',
   tm_smp               timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment 'ʱ���',
   primary key (id)
);

alter table t_user_contacts comment '�û�������ϵ�˱�';

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
   id                   int not null auto_increment comment '����ID',
   user_no              varchar(32) not null comment '�û����',
   user_name            varchar(64) comment '�û�����',
   user_phone           varchar(11) not null comment '�ֻ���',
   sex                  int(2) comment '�Ա�',
   race                 varchar(32) comment '����',
   user_id_no           varchar(64) comment '���֤��',
   login_password       varchar(256) comment '��¼����',
   pay_password         varchar(256) comment '֧������',
   province             int comment '����ʡ',
   city                 int comment '������',
   area                 int comment '��������',
   address              varchar(256) comment '��ϸ��ַ',
   live_time            int(2) comment '��סʱ��',
   house_type           int(2) comment '��������',
   industry             int comment '��ҵ���',
   position             int comment 'ְλ',
   income               decimal(10,2) comment '����',
   work_unit_name       varchar(128) comment '��λ����',
   work_unit_addr       varchar(128) comment '��λ��ַ',
   work_unit_tel        varchar(32) comment '��λ�绰',
   marriage_sts         int(2) comment '����״̬',
   education            int(2) comment 'ѧ��',
   create_time          datetime not null comment 'ע��ʱ��',
   user_sts             int(2) not null default 1 comment '�û�״̬��1-������2-ע����3-��������4-������',
   is_old               int(1) default 0 comment '�Ƿ����û���0-��1-��',
   share_code           varchar(64) comment '������',
   invite_rate          decimal(4,2) default 0 comment '���뷵����',
   invite_user_no       varchar(32) comment '�����˱��',
   is_identity_info     int(1) default 0 comment '�Ƿ��ύ�����Ϣ��0-��1-��',
   is_real_name         int(1) default 0 comment '�Ƿ���ʵ����֤��0-��1-�ǣ�2-��֤��',
   is_bind_card         int(1) default 0 comment '�Ƿ��Ѱ󿨣�0-��1-��',
   is_linkman           int(1) default 0 comment '�Ƿ��ύ������ϵ�ˣ�0-��1-��',
   is_operator          int(1) default 0 comment '�Ƿ���Ӫ����֤��0-��1-�ǣ�2-��֤��',
   is_ec_auth           int(1) comment '�Ƿ��ύ������֤��0-��1-�ǣ�2-��֤��',
   reserve_field1       varchar(256) comment 'Ԥ���ֶ�һ',
   reserve_field2       varchar(256) comment 'Ԥ���ֶζ�',
   reserve_field3       varchar(256) comment 'Ԥ���ֶ���',
   tm_smp               timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment 'ʱ���',
   primary key (id)
);

alter table t_user_info comment '�û���Ϣ��';

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
   id                   int not null comment '����ID',
   user_no              varchar(32) not null comment '�û����',
   auth_sts             int(2) comment '��֤״̬��0-δ��֤��1-����֤��2-�ѹ���',
   auth_time            datetime comment '��֤ʱ��',
   tm_smp               timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment 'ʱ���',
   primary key (id)
);

alter table t_user_operator_auth comment '�û���Ӫ����֤�������ƣ�';

/*==============================================================*/
/* Table: t_user_phone_list                                     */
/*==============================================================*/
create table t_user_phone_list
(
   id                   int not null auto_increment comment '����ID',
   user_no              varchar(32) not null comment '�û����',
   phone_name           varchar(64) comment 'ͨѶ¼����',
   phone_no             varchar(64) comment '�ֻ�����',
   tm_smp               timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment 'ʱ���',
   primary key (id)
);

alter table t_user_phone_list comment '�û�ͨѶ¼��';

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
   id                   int not null comment '����ID',
   user_no              varchar(32) not null comment '�û����',
   face_picture_url     varchar(512) comment '����ͼƬ��ַ',
   face_picture_pub_url varchar(512) comment '����ͼƬ���ʵ�ַ',
   id_positive_picture_url varchar(512) comment '���֤����ͼƬ��ַ',
   id_positive_picture_pub_url varchar(512) comment '���֤����ͼƬ���ʵ�ַ',
   id_anti_picture_url  varchar(512) comment '���֤����ͼƬ��ַ',
   id_anti_picture_pub_url varchar(512) comment '���֤����ͼƬ���ʵ�ַ',
   update_time          datetime comment '����ʱ��',
   tm_smp               timestamp not null default CURRENT_TIMESTAMP comment 'ʱ���',
   primary key (id)
);

alter table t_user_realname comment '�û�ʵ����';

/*==============================================================*/
/* Index: t_realname_auth_UI1                                   */
/*==============================================================*/
create unique index t_realname_auth_UI1 on t_user_realname
(
   user_no
);


