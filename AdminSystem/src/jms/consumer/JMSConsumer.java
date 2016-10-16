package jms.consumer;

import javax.jms.JMSException;

public interface JMSConsumer {
	public void sendMsg() throws JMSException;
	public String receiveMsg() throws JMSException;
}
