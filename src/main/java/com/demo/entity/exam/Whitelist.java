package com.demo.entity.exam;

/**
 * table name:  whitelist
 * author name:  
 * create time: 2020-07-30 15:36:32
 */ 
public class Whitelist extends EntityHelper{

	private int listId;
	private int userId;
	private String certificateId;//身份证号码

	public Whitelist() {
		super();
	}
	public Whitelist(int listId,int userId,String certificateId) {
		this.listId=listId;
		this.userId=userId;
		this.certificateId =certificateId;
	}
	public void setListId(int listId){
		this.listId=listId;
	}
	public int getListId(){
		return listId;
	}
	public void setUserId(int userId){
		this.userId=userId;
	}
	public int getUserId(){
		return userId;
	}
	public void setCertificateId(String certificateId){
		this.certificateId =certificateId;
	}
	public String getCertificateId(){
		return certificateId;
	}
	@Override
	public String toString() {
		return "whitelist[" + 
			"listId=" + listId + 
			", userId=" + userId + 
			", adminNumber=" + certificateId +
			"]";
	}
	@Override
	public String getPrimaryKey() {
		return "listId";
	}
}

