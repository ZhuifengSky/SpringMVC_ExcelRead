package com.main.income.model;

import java.math.BigDecimal;
import java.util.Date;

public class IncomeConfirm {
    
	    private Long    id;  
	    private Long    incomeId;  //收款单ID
	    private String  incomeCode;  //收款单号
	    private String 	accountNo;
	    private String 	accountType;
	    private BigDecimal    confirmAmount;  //确认金额
	    private BigDecimal    handFee;  //手续费
	    private String incomeWayId; //收款方式
	    private Long operatorId;
	    private String operatorName; //确认人或取消确认人
	    private Date operationDate; //确认时间或取消确认时间
	    private String  status;  //确认状态,0—录入，1—作废
	    private IncomeWay incomeWay;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public Long getIncomeId() {
			return incomeId;
		}
		public void setIncomeId(Long incomeId) {
			this.incomeId = incomeId;
		}
		public String getIncomeCode() {
			return incomeCode;
		}
		public void setIncomeCode(String incomeCode) {
			this.incomeCode = incomeCode;
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
		public BigDecimal getConfirmAmount() {
			return confirmAmount;
		}
		public void setConfirmAmount(BigDecimal confirmAmount) {
			this.confirmAmount = confirmAmount;
		}
		public BigDecimal getHandFee() {
			return handFee;
		}
		public void setHandFee(BigDecimal handFee) {
			this.handFee = handFee;
		}
		public String getIncomeWayId() {
			return incomeWayId;
		}
		public void setIncomeWayId(String incomeWayId) {
			this.incomeWayId = incomeWayId;
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
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public IncomeWay getIncomeWay() {
			return incomeWay;
		}
		public void setIncomeWay(IncomeWay incomeWay) {
			this.incomeWay = incomeWay;
		}   
      
	    
	
}
