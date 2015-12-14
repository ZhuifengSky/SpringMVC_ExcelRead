package com.main.scheduler.job;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TimeSayHelloJobAnnoation {
	// 每5秒执行一次
	@Scheduled(cron = "* 0/59 * * * ? ")
	public void myTest() {
		System.out.println("注解方式定时器进入测试"+new Date().toString());
	}
}
