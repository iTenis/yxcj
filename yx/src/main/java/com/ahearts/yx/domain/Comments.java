package com.ahearts.yx.domain;

import java.sql.Timestamp;

public class Comments {
	private int id;
	private int commentuserid;
	private Timestamp commenttime;
	private String commentcontent;
	private int commentlevel;
	private int commentgoodsid;
	private int commentisdelete;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCommentuserid() {
		return commentuserid;
	}
	public void setCommentuserid(int commentuserid) {
		this.commentuserid = commentuserid;
	}
	public Timestamp getCommenttime() {
		return commenttime;
	}
	public void setCommenttime(Timestamp commenttime) {
		this.commenttime = commenttime;
	}
	public String getCommentcontent() {
		return commentcontent;
	}
	public void setCommentcontent(String commentcontent) {
		this.commentcontent = commentcontent;
	}
	public int getCommentlevel() {
		return commentlevel;
	}
	public void setCommentlevel(int commentlevel) {
		this.commentlevel = commentlevel;
	}
	public int getCommentgoodsid() {
		return commentgoodsid;
	}
	public void setCommentgoodsid(int commentgoodsid) {
		this.commentgoodsid = commentgoodsid;
	}
	public int getCommentisdelete() {
		return commentisdelete;
	}
	public void setCommentisdelete(int commentisdelete) {
		this.commentisdelete = commentisdelete;
	}		
}
