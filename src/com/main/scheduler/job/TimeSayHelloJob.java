package com.main.scheduler.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class TimeSayHelloJob{

	int i;
	
	public void execute(){
		
		System.out.println("定时问好！");
		i++;
	}

}
