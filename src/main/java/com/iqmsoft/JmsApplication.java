package com.iqmsoft;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

import com.iqmsoft.domain.MyJMSBean;

@SpringBootApplication
@EnableJms
public class JmsApplication implements CommandLineRunner {
	
	@Autowired
	private Logger log;
	
	@Autowired
	private JmsTemplate jmsTemplate;


	public static void main(String[] args) {
		SpringApplication.run(JmsApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		
		log.info("sending three topic messages, 9 listener should receive the messages");
		jmsTemplate.convertAndSend("topic", new MyJMSBean("info", "topic message1"));
		jmsTemplate.convertAndSend("topic", new MyJMSBean("info", "topic message2"));
		jmsTemplate.convertAndSend("topic", new MyJMSBean("info", "topic message3"));
		
		log.info("sending 4 queue messages, 4 (different) listener should receive the messages");
		jmsTemplate.convertAndSend("queue", new MyJMSBean("info", "queue message"));
		jmsTemplate.convertAndSend("queue", new MyJMSBean("info", "queue message"));
		jmsTemplate.convertAndSend("queue", new MyJMSBean("info", "queue message"));
		jmsTemplate.convertAndSend("queue", new MyJMSBean("info", "queue message"));
	}
}
