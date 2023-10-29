/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2023/10/29 15:23:50                          */
/*==============================================================*/


/*==============================================================*/
/* Table: admin                                                 */
/*==============================================================*/
create table admin
(
   a_username           varchar(1024) not null,
   a_password           varchar(1024) not null,
   a_id                 int not null,
   primary key (a_id)
);

/*==============================================================*/
/* Table: cart                                                  */
/*==============================================================*/
create table cart
(
   ct_id                bigint not null,
   g_id                 bigint,
   ct_addTime           datetime not null,
   primary key (ct_id)
);

/*==============================================================*/
/* Table: category                                              */
/*==============================================================*/
create table category
(
   c_id                 bigint not null,
   c_name               varchar(1024) not null,
   primary key (c_id)
);

/*==============================================================*/
/* Table: good                                                  */
/*==============================================================*/
create table good
(
   g_name               varchar(256) not null,
   g_id                 bigint not null,
   u_id                 int,
   c_id                 bigint,
   g_price              float not null,
   g_description        varchar(1024),
   g_purchaseDate       date not null,
   g_postTime           datetime not null,
   g_state              varchar(1024) not null,
   g_old                varchar(1024) not null,
   primary key (g_id)
);

/*==============================================================*/
/* Index: good_name                                             */
/*==============================================================*/
create index good_name on good
(
   g_name
);

/*==============================================================*/
/* Table: `like`                                                */
/*==============================================================*/
create table `like`
(
   lk_id                bigint not null,
   g_id                 bigint,
   lk_addTime           datetime,
   primary key (lk_id)
);

/*==============================================================*/
/* Table: location                                              */
/*==============================================================*/
create table location
(
   l_id                 bigint not null,
   l_city               varchar(1024) not null,
   l_address            varchar(1024),
   primary key (l_id)
);

/*==============================================================*/
/* Table: msg                                                   */
/*==============================================================*/
create table msg
(
   m_id                 bigint not null,
   u_id                 int,
   o_id                 bigint,
   m_content            varchar(1024),
   m_category           varchar(1024),
   m_reply              varchar(1024),
   primary key (m_id)
);

/*==============================================================*/
/* Table: `order`                                               */
/*==============================================================*/
create table `order`
(
   o_id                 bigint not null,
   g_id                 bigint,
   u_id                 int,
   o_dealPrice          float not null,
   o_state              varchar(1024) not null,
   o_lastUpdate         datetime not null,
   o_startTime          datetime not null,
   primary key (o_id)
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   u_username           varchar(1024),
   u_password           varchar(1024),
   u_id                 int not null,
   l_id                 bigint,
   banned               bool,
   primary key (u_id)
);

/*==============================================================*/
/* View: user_goods                                             */
/*==============================================================*/
create VIEW  user_goods
 as
select u_username,g_id,g_name,g_price,g_description,g_purchaseDate,g_postTime,g_state,g_old
from good,user
where user.u_id = good.u_id;

alter table cart add constraint FK_CART_GOOD_CART_GOOD foreign key (g_id)
      references good (g_id) on delete restrict on update restrict;

alter table good add constraint FK_GOOD_GOOD_CATE_CATEGORY foreign key (c_id)
      references category (c_id) on delete restrict on update restrict;

alter table good add constraint FK_GOOD_USER_GOOD_USER foreign key (u_id)
      references user (u_id) on delete restrict on update restrict;

alter table `like` add constraint FK_LIKE_GOOD_LIKE_GOOD foreign key (g_id)
      references good (g_id) on delete restrict on update restrict;

alter table msg add constraint FK_MSG_MSG_ORDER_ORDER foreign key (o_id)
      references `order` (o_id) on delete restrict on update restrict;

alter table msg add constraint FK_MSG_USER_MSG_USER foreign key (u_id)
      references user (u_id) on delete restrict on update restrict;

alter table `order` add constraint FK_ORDER_GOOD_ORDE_GOOD foreign key (g_id)
      references good (g_id) on delete restrict on update restrict;

alter table `order` add constraint FK_ORDER_USER_ORDE_USER foreign key (u_id)
      references user (u_id) on delete restrict on update restrict;

alter table user add constraint FK_USER_USER_LOCA_LOCATION foreign key (l_id)
      references location (l_id) on delete restrict on update restrict;


-- create procedure user_good(in user_id INT,out goods_number INT)
-- begin
--     select count(*) into goods_number
--     from good
--     where good.u_id = user_id;
-- end;


-- create trigger order_BEFORE_INSERT before insert
-- on `order` for each row
-- begin
-- 	update good set g_state = 'TRADING'
-- 	where good.g_id = new.g_id;
-- end;

