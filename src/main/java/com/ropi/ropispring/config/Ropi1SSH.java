package com.ropi.ropispring.config;

import java.util.Properties;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class Ropi1SSH {
	private final static String HOST = "192.168.0.201";
	private final static int PORT = 22; //기본포트는 22
	private final static String SSH_USER = "htone"; //ex) root
	private final static String SSH_PW = "htone123"; //ex) 1234
	
	private Session session;
	
	public void closeSSH() {
		session.disconnect();
	}
	
	public Ropi1SSH() {
		System.out.println("ssh start");
		try {
			Properties config = new Properties();
			config.put("StrictHostKeyChecking", "no");
			JSch jsch = new JSch();
			session = jsch.getSession(SSH_USER, HOST, PORT);
			session.setPassword(SSH_PW);
			session.setConfig(config);
			session.connect();
			
			session.setPortForwardingL(13579, "127.0.0.1", 3306); //127.0.0.1/3316으로 접근한 포트를 연결HOST/3306으로 포트포워딩
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}