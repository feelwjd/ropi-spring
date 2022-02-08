package com.ropi.ropispring.config.ssh;

import java.util.Properties;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class Ropi6SSH {
	private final static String HOST = "128.134.37.244";
	private final static int PORT = 22022; //기본포트는 22
	private final static String SSH_USER = "ropi"; //ex) root
	private final static String SSH_PW = "ropi123"; //ex) 1234
	
	private Session session;
	
	public void closeSSH() {
		session.disconnect();
	}
	
	public Ropi6SSH() {
		System.out.println("ssh6 start");
		try {
			Properties config = new Properties();
			config.put("StrictHostKeyChecking", "no");
			JSch jsch = new JSch();
			session = jsch.getSession(SSH_USER, HOST, PORT);
			session.setPassword(SSH_PW);
			session.setConfig(config);
			session.connect();
			
			session.setPortForwardingL(13580, "127.0.0.1", 3306); //127.0.0.1/3316으로 접근한 포트를 연결HOST/3306으로 포트포워딩
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}