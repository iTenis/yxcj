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
	private Cates cates;
	private float goodsdiscount;
	private int goodsisnew;
	
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
	public Cates getCates() {
		return cates;
	}
	public void setCates(Cates cates) {
		this.cates = cates;
	}
	public float getGoodsdiscount() {
		return goodsdiscount;
	}
	public void setGoodsdiscount(float goodsdiscount) {
		this.goodsdiscount = goodsdiscount;
	}
	public int getGoodsisnew() {
		return goodsisnew;
	}
	public void setGoodsisnew(int goodsisnew) {
		this.goodsisnew = goodsisnew;
	}

}
