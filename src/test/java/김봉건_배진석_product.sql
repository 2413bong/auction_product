
select * from Product


CREATE TABLE Product
(
	-- 力前锅龋
	ProductNumber number(10,0) NOT NULL,
	-- 力前捞抚
	ProductName varchar2(100) NOT NULL,
	ProductCategory varchar2(50) NOT NULL,
	ProductCode varchar2(20) NOT NULL,
	ProductQuantity number(10,0) NOT NULL,
	ProductDate char(10) NOT NULL,
	ProductLowestPrice number(10,0) NOT NULL,
	ProductHopefulPrice  number(10,0) NOT NULL,
	ProductImage varchar2(1000) NOT NULL,
	ProductDesc varchar2(1000) NOT NULL,
	ProductBrand varchar2(100) NOT NULL,
	ProductCondition varchar2(100),
	PRIMARY KEY (ProductNumber)
);


DROP TABLE Product ;

/* Create Sequences */

CREATE SEQUENCE SEQ_Product_ProductNumber INCREMENT BY 1 START WITH 1;

