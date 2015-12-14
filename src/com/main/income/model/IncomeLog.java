package com.main.income.model;

import java.math.BigDecimal;
import java.util.Date;

public class IncomeLog{
	
	private Long    id;  //ID
    private Long    inputId;  //充值单ID
    private Long    distributeId;  //分配单ID
    private String  accountNo;  //账号
    private String  accountType;  //账号类型
    private BigDecimal curFaceAmount;  //当前可用金额
    private BigDecimal curRealAmount;  //当前真实余额
    private Long    operatorId;  //操作人ID
    private String  operatorName;  //操作人全称
    private Date    operationDate;  //操作日期
    private String  operationDesc;  //操作描述
	
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getInputId() {
		return inputId;
	}
	public void setInputId(Long inputId) {
		this.inputId = inputId;
	}
	public Long getDistributeId() {
		return distributeId;
	}
	public void setDistributeId(Long distributeId) {
		this.distributeId = distributeId;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public BigDecimal getCurFaceAmount() {
		return curFaceAmount;
	}
	public void setCurFaceAmount(BigDecimal curFaceAmount) {
		this.curFaceAmount = curFaceAmount;
	}
	public BigDecimal getCurRealAmount() {
		return curRealAmount;
	}
	public void setCurRealAmount(BigDecimal curRealAmount) {
		this.curRealAmount = curRealAmount;
	}
	public Long getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}
	public String getOperatorName() {
		return operatorName;
	}
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	public Date getOperationDate() {
		return operationDate;
	}
	public void setOperationDate(Date operationDate) {
		this.operationDate = operationDate;
	}
	public String getOperationDesc() {
		return operationDesc;
	}
	public void setOperationDesc(String operationDesc) {
		this.operationDesc = operationDesc;
	}
	
	
	
}
