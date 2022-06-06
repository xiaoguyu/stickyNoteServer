-- 访问日志
drop table if exists user_visit_log;
create table user_visit_log
(
    id                   int(11) not null auto_increment,
    guid                 varchar(63),
    ip                   varchar(63),
    version              varchar(31),
    create_time          datetime,
    primary key (id)
);
-- 版本信息
drop table if exists version_info;
create table version_info
(
    id                   int(11) not null auto_increment,
    download_url         varchar(127),
    version              varchar(31),
    create_time          datetime,
    primary key (id)
);