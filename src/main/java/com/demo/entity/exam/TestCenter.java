package com.demo.entity.exam;

import java.util.Date;
/**
 * table name:  test_center_information
 * author name:  
 * create time: 2020-07-30 15:36:32
 */ 
public class TestCenter extends EntityHelper{

	private int testCenterId;
	private String testCenterName;
	private String testCenterAddress;
	private int testCenterNumber;
	private int numberStart;
	private int numberEnd;

	public TestCenter() {
		super();
	}

	public TestCenter(int testCenterId, String testCenterName, String testCenterAddress, int testCenterNumber, int numberStart, int numberEnd) {
		this.testCenterId = testCenterId;
		this.testCenterName = testCenterName;
		this.testCenterAddress = testCenterAddress;
		this.testCenterNumber = testCenterNumber;
		this.numberStart = numberStart;
		this.numberEnd = numberEnd;
	}

	public int getTestCenterId() {
		return testCenterId;
	}

	public void setTestCenterId(int testCenterId) {
		this.testCenterId = testCenterId;
	}

	public String getTestCenterName() {
		return testCenterName;
	}

	public void setTestCenterName(String testCenterName) {
		this.testCenterName = testCenterName;
	}

	public String getTestCenterAddress() {
		return testCenterAddress;
	}

	public void setTestCenterAddress(String testCenterAddress) {
		this.testCenterAddress = testCenterAddress;
	}

	public int getTestCenterNumber() {
		return testCenterNumber;
	}

	public void setTestCenterNumber(int testCenterNumber) {
		this.testCenterNumber = testCenterNumber;
	}

	public int getNumberStart() {
		return numberStart;
	}

	public void setNumberStart(int numberStart) {
		this.numberStart = numberStart;
	}

	public int getNumberEnd() {
		return numberEnd;
	}

	public void setNumberEnd(int numberEnd) {
		this.numberEnd = numberEnd;
	}

	@Override
	public String toString() {
		return "TestCenter{" +
				"testCenterId=" + testCenterId +
				", testCenterName='" + testCenterName + '\'' +
				", testCenterAddress='" + testCenterAddress + '\'' +
				", testCenterNumber=" + testCenterNumber +
				", numberStart=" + numberStart +
				", numberEnd=" + numberEnd +
				'}';
	}

	@Override
	public String getPrimaryKey() {
		return "roomId";
	}
}

