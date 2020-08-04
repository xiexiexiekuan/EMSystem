package com.demo.entity.exam;

/**
 * table name:  application_information
 * author name:  
 * create time: 2020-07-30 15:36:31
 */ 
public class ApplicationInformation extends EntityHelper{

	private int enterId;
	private int userId;
	private String examineeNumber;
	private int publishId;
	private String examineePhoto;
	private String curSchool;
	private String stuType;
	private String wantSchool;
	private int previewStatus;//审核状态  -1未审核  0审核不通过   1审核通过
	private int applyStatus;
	private int payStatus;
	private int examStatus;
	private String grades;

	public ApplicationInformation() {
		super();
	}
	public ApplicationInformation(int enterId,int userId,String examineeNumber,int publishId,String examineePhoto,String curSchool,String stuType,String wantSchool,int previewStatus,int applyStatus,int payStatus,int examStatus,String grades) {
		this.enterId=enterId;
		this.userId=userId;
		this.examineeNumber=examineeNumber;
		this.publishId=publishId;
		this.examineePhoto =examineePhoto;
		this.curSchool=curSchool;
		this.stuType=stuType;
		this.wantSchool=wantSchool;
		this.previewStatus=previewStatus;
		this.applyStatus=applyStatus;
		this.payStatus=payStatus;
		this.examStatus=examStatus;
		this.grades=grades;
	}
	public void setEnterId(int enterId){
		this.enterId=enterId;
	}
	public int getEnterId(){
		return enterId;
	}
	public void setUserId(int userId){
		this.userId=userId;
	}
	public int getUserId(){
		return userId;
	}
	public void setExamineeNumber(String examineeNumber){
		this.examineeNumber=examineeNumber;
	}
	public String getExamineeNumber(){
		return examineeNumber;
	}
	public void setPublishId(int publishId){
		this.publishId=publishId;
	}
	public int getPublishId(){
		return publishId;
	}
	public void setExamineePhoto(String examineePhoto){
		this.examineePhoto = examineePhoto;
	}
	public String getExamineePhoto(){
		return examineePhoto;
	}
	public void setCurSchool(String curSchool){
		this.curSchool=curSchool;
	}
	public String getCurSchool(){
		return curSchool;
	}
	public void setStuType(String stuType){
		this.stuType=stuType;
	}
	public String getStuType(){
		return stuType;
	}
	public void setWantSchool(String wantSchool){
		this.wantSchool=wantSchool;
	}
	public String getWantSchool(){
		return wantSchool;
	}
	public void setPreviewStatus(int previewStatus){
		this.previewStatus=previewStatus;
	}
	public int getPreviewStatus(){
		return previewStatus;
	}
	public void setApplyStatus(int applyStatus){
		this.applyStatus=applyStatus;
	}
	public int getApplyStatus(){
		return applyStatus;
	}
	public void setPayStatus(int payStatus){
		this.payStatus=payStatus;
	}
	public int getPayStatus(){
		return payStatus;
	}
	public void setExamStatus(int examStatus){
		this.examStatus=examStatus;
	}
	public int getExamStatus(){
		return examStatus;
	}
	public void setGrades(String grades){
		this.grades=grades;
	}
	public String getGrades(){
		return grades;
	}
	@Override
	public String toString() {
		return "application_information[" + 
			"enterId=" + enterId + 
			", userId=" + userId + 
			", examineeNumber=" + examineeNumber +
			", publishId=" + publishId + 
			", photo=" + examineePhoto +
			", curSchool=" + curSchool +
			", stuType=" + stuType + 
			", wantSchool=" + wantSchool + 
			", previewStatus=" + previewStatus + 
			", applyStatus=" + applyStatus + 
			", payStatus=" + payStatus + 
			", examStatus=" + examStatus + 
			", grades=" + grades + 
			"]";
	}
	@Override
	public String getPrimaryKey() {
		return "enterId";
	}
}

