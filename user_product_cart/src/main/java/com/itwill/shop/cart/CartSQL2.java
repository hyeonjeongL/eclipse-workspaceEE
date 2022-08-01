package com.itwill.shop.cart;

public class CartSQL2 {
	public static final String CART_INSERT
	= "insert * from cart where p_no=?";
	public static final String CART_UPDATE_QTY
	= "update * from cart where p_no=?";
	public static final String CART_DELETEBYNO
	= "delete * from cart where p_no=?";
	public static final String CART_DELETEALL
	= "delete * from cart";
	public static final String CART_SELECTALL
	= "select * from cart";
	public static final String CART_SELECTBYNO
	= "select * from cart where p_no=?";
	

}
