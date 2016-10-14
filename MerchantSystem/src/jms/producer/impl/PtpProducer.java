package jms.producer.impl;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

import jms.producer.JMSProducer;

public class PtpProducer implements JMSProducer{
	private String queueName;
	private String destination;
	private static PtpProducer instance = new PtpProducer();
	
	private PtpProducer(){
		// read properties
		queueName = "Merchant_Q001";
		destination = "failover://tcp://localhost:61616";
	}
	
	public static PtpProducer getInstance(){
		return instance;
	}
	
	public void sendMsg(String msg) throws JMSException{
		ConnectionFactory factory = new ActiveMQConnectionFactory(destination);
		Destination queue = new ActiveMQQueue(queueName);
		
		Connection con = null;
		Session sen = null;
		MessageProducer producer = null;		

		con = factory.createConnection();
		sen = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
		producer = sen.createProducer(queue);
		TextMessage textMsg = sen.createTextMessage(msg);
		
		con.start();
		producer.send(textMsg);

		try {
			producer.close();
			sen.close();
			con.close();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
}
