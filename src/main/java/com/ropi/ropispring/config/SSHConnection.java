package com.ropi.ropispring.config;
import java.util.Properties;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class SSHConnection {
	private final static String HOST = "192.168.0.201";
	private final static Integer PORT = 22;
	private final static String SSH_USER = "htone";
	private final static String SSH_PW = "htone123";

	private Session session;
	
	public void closeSSH() {
		session.disconnect();
	}
	
	public SSHConnection() {
		try {
			System.out.println("check");
			Properties config = new Properties();
			config.put("StrictHostKeyChecking", "no");
			JSch jsch = new JSch();
			session = jsch.getSession(SSH_USER, HOST, PORT);
			session.setPassword(SSH_PW);
			session.setConfig(config);
			session.connect();
			session.setPortForwardingL(3306, "127.0.0.1", 3306);
		} catch (JSchException e) {
			e.printStackTrace();
		}
		
	}
}