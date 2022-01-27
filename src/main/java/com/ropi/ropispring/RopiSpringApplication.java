package com.ropi.ropispring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ropi.ropispring.config.SSHConnection;

@SpringBootApplication
public class RopiSpringApplication {
	private static SSHConnection ssh;
	public RopiSpringApplication() {
		System.out.println("ropiSpringApplication check");
		
		ssh = new SSHConnection();
		
	}

    public static void main(String[] args) {
    	System.out.println("main start");
        SpringApplication.run(RopiSpringApplication.class, args);
    }

}
