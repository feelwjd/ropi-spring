package com.ropi.ropispring.config.ssh;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.stereotype.Component;

@Component
public class MyContextListener implements ServletContextListener{
	private Ropi1SSH ssh1Connection;
//	private Ropi6SSH ssh6Connection;
//	private Ropi7SSH ssh7Connection;
	
	public MyContextListener() {
		super();
	}
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("context initialzed");
		try {
			ssh1Connection = new Ropi1SSH();
//			ssh6Connection = new Ropi6SSH();
//			ssh7Connection = new Ropi7SSH();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("init destory!");
		ssh1Connection.closeSSH();
//		ssh6Connection.closeSSH();
//		ssh7Connection.closeSSH();
	}
}
