package edu.keith.demo.jms;

import javax.jms.BytesMessage;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.StreamMessage;
import javax.jms.TextMessage;
import javax.naming.NamingException;

import edu.keith.mvc.entity.UserInfo;

public class QueueReceive implements MessageListener {

	private QueueConnectionFactory qconFactory;
	private QueueConnection qcon;
	private QueueSession qsession;
	private QueueReceiver qreceiver;
	private Queue queue;

	public void onMessage(Message msg) {
		try {
			if (msg instanceof TextMessage) {
				System.out.println("This is a TextMsg:"
						+ ((TextMessage) msg).getText());
			} else if (msg instanceof StreamMessage) {
				System.out.println("This is a StreamMsg:"
						+ ((StreamMessage) msg).readString() + "\t"
						+ ((StreamMessage) msg).readDouble());
			} else if (msg instanceof BytesMessage) {
				byte[] block = new byte[1024];
				System.out.println("This is a BytesMsg:"
						+ ((BytesMessage) msg).readBytes(block));
			} else if (msg instanceof MapMessage) {
				System.out.println("This is a MapMsg:"
						+ ((MapMessage) msg).getString("name"));
			} else if (msg instanceof ObjectMessage) {
				UserInfo ui = (UserInfo) ((ObjectMessage) msg).getObject();
				System.out.println("This is a ObjectMsg:" + ui.getUserName() + "\t"
						+ ui.getSid());
			}
		} catch (JMSException jmse) {
			jmse.printStackTrace();
		}
	}

	public void init() throws NamingException, JMSException {
		qconFactory = (QueueConnectionFactory) StaticInfo.getContext().lookup(
				StaticInfo.JMS_FACTORY);
		qcon = qconFactory.createQueueConnection();
		qsession = qcon.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
		queue = (Queue) StaticInfo.getContext().lookup(StaticInfo.QUEUE);
		qreceiver = qsession.createReceiver(queue);
		qreceiver.setMessageListener(this);
		qcon.start();
	}

	public void close() throws JMSException {
		qreceiver.close();
		qsession.close();
		qcon.close();
	}
}
