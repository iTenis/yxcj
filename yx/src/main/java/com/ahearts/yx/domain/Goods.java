package com.ahearts.yx.domain;

import java.math.BigDecimal;

public class Goods {
	private int id;
	private String goodsid;
	private String goodsname;
	private String goodssize;
	private String goodscover;
	private int goodsnum;
	private BigDecimal goodsprice;
	private String goodsdesc;
	private String goodspreview;
	private int goodsistop;
	private int goodscateid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}
	public String getGoodsname() {
		return goodsname;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
	public String getGoodssize() {
		return goodssize;
	}
	public void setGoodssize(String goodssize) {
		this.goodssize = goodssize;
	}
	public String getGoodscover() {
		return goodscover;
	}
	public void setGoodscover(String goodscover) {
		this.goodscover = goodscover;
	}
	public int getGoodsnum() {
		return goodsnum;
	}
	public void setGoodsnum(int goodsnum) {
		this.goodsnum = goodsnum;
	}
	public BigDecimal getGoodsprice() {
		return goodsprice;
	}
	public void setGoodsprice(BigDecimal goodsprice) {
		this.goodsprice = goodsprice;
	}
	public String getGoodsdesc() {
		return goodsdesc;
	}
	public void setGoodsdesc(String goodsdesc) {
		this.goodsdesc = goodsdesc;
	}
	public String getGoodspreview() {
		return goodspreview;
	}
	public void setGoodspreview(String goodspreview) {
		this.goodspreview = goodspreview;
	}
	public int getGoodsistop() {
		return goodsistop;
	}
	public void setGoodsistop(int goodsistop) {
		this.goodsistop = goodsistop;
	}
	public int getGoodscateid() {
		return goodscateid;
	}
	public void setGoodscateid(int goodscateid) {
		this.goodscateid = goodscateid;
	}
	public Goods(int id, String goodsid, String goodsname, String goodssize, String goodscover, int goodsnum,
			BigDecimal goodsprice, String goodsdesc, String goodspreview, int goodsistop, int goodscateid) {
		super();
		this.id = id;
		this.goodsid = goodsid;
		this.goodsname = goodsname;
		this.goodssize = goodssize;
		this.goodscover = goodscover;
		this.goodsnum = goodsnum;
		this.goodsprice = goodsprice;
		this.goodsdesc = goodsdesc;
		this.goodspreview = goodspreview;
		this.goodsistop = goodsistop;
		this.goodscateid = goodscateid;
	}
	
	
}
