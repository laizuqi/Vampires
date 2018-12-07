create table TBL_BROWSER_ROUTE(
    ID DECIMAL(20,0) not null,
    BR_ID DECIMAL(20,0) ,
    BR_NAME VARCHAR(20),
    BR_ST CHARACTER(2),
    ADAPTER_K VARCHAR(128),
    ADAPTER_V VARCHAR(128),
    TC_ID DECIMAL(20.0),
    MISC1 VARCHAR(128),
    MISC2 VARCHAR(128),
    MISC3 VARCHAR(128),
    MISC4 VARCHAR(128),
    CONSTRAINT TBL_BROWSER_ROUTE_PK PRIMARY KEY (ID)
);
insert into TBL_BROWSER_ROUTE values(1,1001,'微信浏览器','0','User-Agent','MicroMessenger',1001,'','','','');
insert into TBL_BROWSER_ROUTE values(2,1002,'支付宝浏览器','0','User-Agent','AlipayClient',1002,'','','','');
insert into TBL_BROWSER_ROUTE values(3,1003,'本行支付','0','User-Agent','UCBrowser',1003,'','','','');
insert into TBL_BROWSER_ROUTE values(4,1004,'宣传页','0','','advert',1004,'','','','');
insert into TBL_BROWSER_ROUTE values(5,1005,'错误提示页','0','','error',1005,'','','','');
insert into TBL_BROWSER_ROUTE values(6,1006,'支付成功页面','0','User-Agent','success',1006,'','','','');

create table TBL_TRADE_CHANNEL(
    ID DECIMAL(20,0) NOT NULL,
    TC_ID DECIMAL(20,0),
    TC_NAME VARCHAR(20),
    TC_ST CHARACTER(2),
    PAY_URL VARCHAR(128),
    CRT_DATE VARCHAR(14),
    UPD_DATE VARCHAR(14),
    DEL_DATE VARCHAR(14),
    MISC1 VARCHAR(128),
    MISC2 VARCHAR(128),
    MISC3 VARCHAR(128),
    MISC4 VARCHAR(128),
    CONSTRAINT TBL_TRADE_CHANNEL_PK PRIMARY KEY (ID)
);


insert into TBL_TRADE_CHANNEL values(1,1001,'微信','0','http://47.107.145.108/H5WeiXinPay.html','2018-11-26','2018-11-26','','','','','');
insert into TBL_TRADE_CHANNEL values(2,1002,'支付宝','0','http://47.107.145.108/H5AliPay.html','2018-11-26','2018-11-26','','','','','');
insert into TBL_TRADE_CHANNEL values(3,1003,'本行','0','http://47.107.145.108/default.html','2018-11-26','2018-11-26','','','','','');
insert into TBL_TRADE_CHANNEL values(4,1004,'宣传页','0','http://47.107.145.108/H5MchtPay.html','2018-11-26','2018-11-26','','','','','');
insert into TBL_TRADE_CHANNEL values(5,1005,'错误提示页','0','http://47.107.145.108/payErr.html','2018-11-26','2018-11-26','','','','','');
insert into TBL_TRADE_CHANNEL values(6,1006,'成功页面','0','http://47.107.145.108/success.html','2018-11-26','2018-11-26','','','','','');
