package com.ropi.ropispring.config;
import java.util.Properties;
import java.util.function.Consumer;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class SSHConnection {
	private static JSch jsch = new JSch();

    private String url = "128.134.37.244";
    private String username = "ropi";
    private String password = "ropi123";
    private int port = 22022;  //ssh포트
    private int lport = 26016;  //원격 접속 후 가상으로 포워딩할 포트
    private int rport = 3306;  //실제 사용할 데이터베이스 포트

    private Session session;

    public SSHConnection init(Consumer<Boolean> arg) {  
        try {
            session = jsch.getSession(username, url, port);
            session.setPassword(password);
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.connect();
            session.setPortForwardingL(lport, "127.0.0.1", rport);		
            arg.accept(true);
        } catch (Exception e) {
            arg.accept(false);	
        }
        return this;
    }

    public void shutdown() throws Exception {
        if (session != null && session.isConnected()) {
            session.disconnect();
        }
    }
}