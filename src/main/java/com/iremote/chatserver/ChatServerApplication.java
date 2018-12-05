package com.iremote.chatserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@EnableJpaRepositories(basePackages = "com.iremote.chatserver.dao")
//@EntityScan(basePackages = "com.iremote.chatserver.po")
@SpringBootApplication
//@ComponentScan
public class ChatServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(ChatServerApplication.class, args);
	}
}
