package com.demo.entity.exam;

import java.util.Date;
/**
 * table name:  whitelist
 * author name:  
 * create time: 2020-07-30 15:36:32
 */ 
public class Whitelist extends EntityHelper{

	private int listId;
	private int userId;
	private String examineeNum;

	public Whitelist() {
		super();
	}
	public Whitelist(int listId,int userId,String examineeNum) {
		this.listId=listId;
		this.userId=userId;
		this.examineeNum=examineeNum;
	}

	public int getListId() {
		return listId;
	}

	public void setListId(int listId) {
		this.listId = listId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getExamineeNum() {
		return examineeNum;
	}

	public void setExamineeNum(String examineeNum) {
		this.examineeNum = examineeNum;
	}

	@Override
	public String getPrimaryKey() {
		return "listId";
	}
}

