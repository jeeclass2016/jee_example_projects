DROP TABLE "STUDY"."STOCK";
CREATE TABLE "STUDY"."STOCK" 
(	"STOCK_ID" NUMBER(10,0), 
	"STOCK_CODE" VARCHAR2(10 BYTE) NOT NULL, 
	"STOCK_NAME" VARCHAR2(20 BYTE)  NOT NULL,
  	PRIMARY KEY (STOCK_ID),
  	CONSTRAINT UNI_STOCK_CODE UNIQUE (STOCK_CODE),
  	CONSTRAINT UNI_STOCK_NAME UNIQUE (STOCK_NAME) 
);

CREATE SEQUENCE  "STUDY"."STOCK_SEQ" 
MINVALUE 1 MAXVALUE 9999999999999999999999999999 
INCREMENT BY 1 START WITH 101 CACHE 100 NOORDER  NOCYCLE ;

DROP table "STUDY"."STOCK_DETAIL";
CREATE TABLE "STUDY"."STOCK_DETAIL" 
(
 	"STOCK_ID" NUMBER(10,0)  NOT NULL ,
 	"COMP_NAME" varchar(100) NOT NULL,
 	"COMP_DESC" varchar(255) NOT NULL,
 	"REMARK" varchar(255) NOT NULL,
 	"LISTED_DATE" date NOT NULL,
 	PRIMARY KEY (STOCK_ID) ,
 	CONSTRAINT FK_STOCK_ID FOREIGN KEY (STOCK_ID) REFERENCES stock (STOCK_ID)
);