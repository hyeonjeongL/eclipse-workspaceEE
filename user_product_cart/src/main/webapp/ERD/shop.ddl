/**********************************/
/* Table Name: product */
/**********************************/
CREATE TABLE product(
		p_no                          		NUMBER(10)		 NULL ,
		p_name                        		VARCHAR2(50)		 NOT NULL,
		p_price                       		NUMBER(10)		 DEFAULT 0		 NOT NULL,
		p_image                       		VARCHAR2(100)		 DEFAULT 'images/no_image.jpg'		 NOT NULL,
		p_desc                        		VARCHAR2(200)		 NULL ,
		p_click_count                 		VARCHAR2(10)		 DEFAULT 0		 NOT NULL
);

CREATE SEQUENCE product_p_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

COMMENT ON TABLE product is 'product';
COMMENT ON COLUMN product.p_no is 'p_no';
COMMENT ON COLUMN product.p_name is 'p_name';
COMMENT ON COLUMN product.p_price is 'p_price';
COMMENT ON COLUMN product.p_image is 'p_image';
COMMENT ON COLUMN product.p_desc is 'p_desc';
COMMENT ON COLUMN product.p_click_count is 'p_click_count';


/**********************************/
/* Table Name: userinfo */
/**********************************/
CREATE TABLE userinfo(
		userId                        		VARCHAR2(100)		 NULL ,
		password                      		VARCHAR2(100)		 NULL ,
		name                          		VARCHAR2(100)		 NULL ,
		email                         		VARCHAR2(100)		 NULL 
);

COMMENT ON TABLE userinfo is 'userinfo';
COMMENT ON COLUMN userinfo.userId is 'userId';
COMMENT ON COLUMN userinfo.password is 'password';
COMMENT ON COLUMN userinfo.name is 'name';
COMMENT ON COLUMN userinfo.email is 'email';


/**********************************/
/* Table Name: cart */
/**********************************/
CREATE TABLE cart(
		cart_no                       		NUMBER(10)		 NULL ,
		userId                        		VARCHAR2(100)		 NULL ,
		p_no                          		NUMBER(10)		 NULL ,
		cart_qty                      		NUMBER(10)		 DEFAULT 0		 NULL 
);

CREATE SEQUENCE cart_cart_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;


COMMENT ON TABLE cart is 'cart';
COMMENT ON COLUMN cart.cart_no is 'cart_no';
COMMENT ON COLUMN cart.userId is 'userId';
COMMENT ON COLUMN cart.p_no is 'p_no';
COMMENT ON COLUMN cart.cart_qty is 'cart_qty';



ALTER TABLE product ADD CONSTRAINT IDX_product_PK PRIMARY KEY (p_no);

ALTER TABLE userinfo ADD CONSTRAINT IDX_userinfo_PK PRIMARY KEY (userId);

ALTER TABLE cart ADD CONSTRAINT IDX_cart_PK PRIMARY KEY (cart_no);
ALTER TABLE cart ADD CONSTRAINT IDX_cart_FK0 FOREIGN KEY (userId) REFERENCES userinfo (userId);
ALTER TABLE cart ADD CONSTRAINT IDX_cart_FK1 FOREIGN KEY (p_no) REFERENCES product (p_no);

