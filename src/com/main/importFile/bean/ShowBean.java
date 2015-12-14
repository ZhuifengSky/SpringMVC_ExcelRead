package com.main.importFile.bean;

import org.springframework.web.multipart.MultipartFile;

public class ShowBean {

	private String reportType;
	private MultipartFile file;
	public String getReportType() {
		return reportType;
	}
	public void setReportType(String reportType) {
		this.reportType = reportType;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
	
}
