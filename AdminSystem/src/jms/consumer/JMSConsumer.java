package jms.consumer;

import javax.jms.JMSException;

public interface JMSConsumer {

	public String receiveMsg() throws JMSException;
}
