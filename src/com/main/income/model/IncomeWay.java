package com.main.income.model;


public class IncomeWay {
	    
	    private String  id;  
	    private String  name;  //收款方式
	    private String  status; //使用标识 0-使用中 1-停用
	    private Integer	showSequence; //显示顺序
		
	    public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public Integer getShowSequence() {
			return showSequence;
		}
		public void setShowSequence(Integer showSequence) {
			this.showSequence = showSequence;
		}
	
	
	
}
