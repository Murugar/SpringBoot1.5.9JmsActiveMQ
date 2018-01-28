package com.iqmsoft.jmsreceiver;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.iqmsoft.domain.MyJMSBean;

@Component
public class QueueReceiver {

	@Autowired
	private Logger log;
	
	@JmsListener(destination = "queue", containerFactory = "myFactory")
	public void method1(MyJMSBean myJMSBean) {
		log.info("Method1: " + myJMSBean.toString());
	}

	@JmsListener(destination = "queue", containerFactory = "myFactory")
	public void method2(MyJMSBean myJMSBean) {
		log.info("Method2: " + myJMSBean.toString());
	}

	@JmsListener(destination = "queue", containerFactory = "myFactory")
	public void method3(MyJMSBean myJMSBean) {
		log.info("Method3: " + myJMSBean.toString());
	}
}
