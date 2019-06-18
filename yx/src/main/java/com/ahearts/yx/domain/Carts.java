package com.ahearts.yx.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;

import lombok.Data;


public class Carts {
	private int id;
	private int cartuserid;
	private int cartgoodsid;
	private Timestamp carttime;
	private int cartnum;
	private Goods goods;
	
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCartuserid() {
		return cartuserid;
	}
	public void setCartuserid(int cartuserid) {
		this.cartuserid = cartuserid;
	}
	public int getCartgoodsid() {
		return cartgoodsid;
	}
	public void setCartgoodsid(int cartgoodsid) {
		this.cartgoodsid = cartgoodsid;
	}
	public Timestamp getCarttime() {
		return carttime;
	}
	public void setCarttime(Timestamp carttime) {
		this.carttime = carttime;
	}
	public int getCartnum() {
		return cartnum;
	}
	public void setCartnum(int cartnum) {
		this.cartnum = cartnum;
	}
	
}
