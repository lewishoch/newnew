package jms.consumer.impl;

import java.util.Date;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

import jms.consumer.JMSConsumer;

public class PtpConsumer implements JMSConsumer {
	private String queueName;
	private String destination;
	private static PtpConsumer instance = new PtpConsumer();
	
	private PtpConsumer(){
		// read properties
		queueName = "Merchant_Q001";
		destination = "failover://tcp://10.222.57.12:61616";
	}
	
	public static PtpConsumer getInstance(){
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
	
	public void sendMsg() throws JMSException{
		sendMsg(new Date().toString());
	}

	public String receiveMsg() throws JMSException {
		ConnectionFactory factory = new ActiveMQConnectionFactory(destination);
		Destination queue = new ActiveMQQueue(queueName);

		Connection con = null;
		Session sen = null;
		MessageConsumer consumer = null;
		
		con=factory.createConnection();
		con.start();
		
		return "";
		
	}
}
