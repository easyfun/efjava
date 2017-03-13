create database if not exists test;

use test;

create table user (
	id int(20) not null auto_increment,
	name char(50) not null,
	primary key (id),
	unique (name)
) engine=innodb default charset=utf-8 comment='用户表';

insert into user (name) values ('simayi'),('caocao');

