package com.main.income.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class IncomeInfo{
   
	    private Long    id;  
	    private String  incomeCode;  //收款单号
	    private String  incomeWayId;  //收款方式
	    private String  inputMan;  //录单人
	    private Date    inputDate;  //录单日期
	    private BigDecimal incomeAmount;  //收款金额
	    private BigDecimal handFee;  //手续费
	    private BigDecimal realAmount;  //实际到账金额
	    private BigDecimal balanceAmount;  //可用余额，初始金额等于收款金额
	    private String  remitter;  //汇款人
	    private Long    studentId;  //学    员
	    private Long    copartnerId;  //客    户
	    private String  accountNo;  //账    号
	    private String  accountType;  //账号类型,S-学员，C-客户
	    private String  status;  //单据状态，0-录入，1—作废
	    private String  distributeStatus;  //分配状态，0—未分配，1—部分分配，2—分配完
	    private String  confirmStatus;  //确认状态，0—未确认，1—已到账确认
	    private Long    onlineId;  //网银ID
	    private Date	onlineTime; //网银交易时间
	    private Date	confirmDate; //确认时间
	    private String	confirmMan;  //确认人
	    private String  remark;  //备注
	    private Integer    version;  //版本信息	
	    private List distributes;
	    private List logs;
	    private IncomeWay incomeWay;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getIncomeCode() {
			return incomeCode;
		}
		public void setIncomeCode(String incomeCode) {
			this.incomeCode = incomeCode;
		}
		public String getIncomeWayId() {
			return incomeWayId;
		}
		public void setIncomeWayId(String incomeWayId) {
			this.incomeWayId = incomeWayId;
		}
		public String getInputMan() {
			return inputMan;
		}
		public void setInputMan(String inputMan) {
			this.inputMan = inputMan;
		}
		public Date getInputDate() {
			return inputDate;
		}
		public void setInputDate(Date inputDate) {
			this.inputDate = inputDate;
		}
		public BigDecimal getIncomeAmount() {
			return incomeAmount;
		}
		public void setIncomeAmount(BigDecimal incomeAmount) {
			this.incomeAmount = incomeAmount;
		}
		public BigDecimal getHandFee() {
			return handFee;
		}
		public void setHandFee(BigDecimal handFee) {
			this.handFee = handFee;
		}
		public BigDecimal getRealAmount() {
			return realAmount;
		}
		public void setRealAmount(BigDecimal realAmount) {
			this.realAmount = realAmount;
		}
		public BigDecimal getBalanceAmount() {
			return balanceAmount;
		}
		public void setBalanceAmount(BigDecimal balanceAmount) {
			this.balanceAmount = balanceAmount;
		}
		public String getRemitter() {
			return remitter;
		}
		public void setRemitter(String remitter) {
			this.remitter = remitter;
		}
		public Long getStudentId() {
			return studentId;
		}
		public void setStudentId(Long studentId) {
			this.studentId = studentId;
		}
		public Long getCopartnerId() {
			return copartnerId;
		}
		public void setCopartnerId(Long copartnerId) {
			this.copartnerId = copartnerId;
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
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getDistributeStatus() {
			return distributeStatus;
		}
		public void setDistributeStatus(String distributeStatus) {
			this.distributeStatus = distributeStatus;
		}
		public String getConfirmStatus() {
			return confirmStatus;
		}
		public void setConfirmStatus(String confirmStatus) {
			this.confirmStatus = confirmStatus;
		}
		public Long getOnlineId() {
			return onlineId;
		}
		public void setOnlineId(Long onlineId) {
			this.onlineId = onlineId;
		}
		public Date getOnlineTime() {
			return onlineTime;
		}
		public void setOnlineTime(Date onlineTime) {
			this.onlineTime = onlineTime;
		}
		public Date getConfirmDate() {
			return confirmDate;
		}
		public void setConfirmDate(Date confirmDate) {
			this.confirmDate = confirmDate;
		}
		public String getConfirmMan() {
			return confirmMan;
		}
		public void setConfirmMan(String confirmMan) {
			this.confirmMan = confirmMan;
		}
		public String getRemark() {
			return remark;
		}
		public void setRemark(String remark) {
			this.remark = remark;
		}
		public Integer getVersion() {
			return version;
		}
		public void setVersion(Integer version) {
			this.version = version;
		}
		public List getDistributes() {
			return distributes;
		}
		public void setDistributes(List distributes) {
			this.distributes = distributes;
		}
		public List getLogs() {
			return logs;
		}
		public void setLogs(List logs) {
			this.logs = logs;
		}
		public IncomeWay getIncomeWay() {
			return incomeWay;
		}
		public void setIncomeWay(IncomeWay incomeWay) {
			this.incomeWay = incomeWay;
		}   
	
	   
}
