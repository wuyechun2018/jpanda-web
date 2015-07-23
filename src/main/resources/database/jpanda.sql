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

create table SYS_MENU
(
  MENU_ID       NUMBER(10) not null,
  MENU_PID      NUMBER(10) not null,
  MENU_NAME     VARCHAR2(20) not null,
  MENU_ADDR     VARCHAR2(100) not null,
  MENU_ICON_URL VARCHAR2(20),
  MENU_TYPE     VARCHAR2(1),
  IS_USE        VARCHAR2(1),
  MEMO          VARCHAR2(500),
  ORDER_NO      NUMBER(10) default 0,
  MENU_PATH     VARCHAR2(100),
  primary key (MENU_ID)
);

create table APP_DISP_DATA
(
  APP_DISP_DATA_ID NUMBER(10) not null,
  DATA_TYPE        VARCHAR2(50),
  DATA_KEY         VARCHAR2(20),
  DATA_VALUE       NUMBER(20,4),
  DATA_DATE        DATE,
  primary key (APP_DISP_DATA_ID)
);