package com.ropi.ropispring.config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.stereotype.Component;

@Component
public class MyContextListener implements ServletContextListener{
	private SSHConnection sshConnection;
	
	public MyContextListener() {
		super();
	}
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("context initialzed");
		try {
			sshConnection = new SSHConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("init destory!");
		sshConnection.closeSSH();
	}
}
