drop table if exists SYS_LOGIN_USER;

create table SYS_LOGIN_USER
(
  USER_ID       NUMBER(10) not null,
  USER_NAME     VARCHAR2(20) not null,
  USER_ALIAS    VARCHAR2(20),
  USER_CODE     VARCHAR2(20),
  SEX           VARCHAR2(1),
  LOGIN_ACCOUNT VARCHAR2(30),
  LOGIN_PWD     VARCHAR2(40) not null,
  USER_EMAIL    VARCHAR2(30),
  USER_STATE    CHAR(1) default 'U',
  USER_TYPE     CHAR(1) default '0',
  USER_THEME    VARCHAR2(50) default 'Default',
  MEMO          VARCHAR2(500),
  ORDER_BY      NUMBER(10) default 0,
  primary key (USER_ID)
);