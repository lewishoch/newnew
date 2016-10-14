package jms.producer;

import javax.jms.JMSException;

public interface JMSProducer {

	public void sendMsg(String msg) throws JMSException;

}
