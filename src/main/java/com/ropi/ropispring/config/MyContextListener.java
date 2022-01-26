package com.ropi.ropispring.config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyContextListener implements ServletContextListener{
	private SSHConnection sshConnection;

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		try {
			sshConnection = new SSHConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		sshConnection.closeSSH();
	}
}
