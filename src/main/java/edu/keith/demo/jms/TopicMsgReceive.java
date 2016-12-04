package edu.keith.demo.jms;

import javax.jms.BytesMessage;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.StreamMessage;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.NamingException;

import edu.keith.mvc.entity.UserInfo;


public class TopicMsgReceive implements MessageListener {
	private TopicConnectionFactory tConFactory;
	private TopicConnection tCon;
	private TopicSession tSession;
	private TopicSubscriber tSubscriber;
	private Topic topic;

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
		tConFactory = (TopicConnectionFactory) StaticInfo.getContext().lookup(
				StaticInfo.JMS_FACTORY);
		tCon = tConFactory.createTopicConnection();
		tCon.setClientID("abcde");
		tSession = tCon.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
		topic = (Topic) StaticInfo.getContext().lookup(StaticInfo.TOPIC);
		tSubscriber = tSession.createDurableSubscriber(topic, StaticInfo.DURABLE_SUB);
		tSubscriber.setMessageListener(this);
		tCon.start();
	}

	public void close() throws JMSException {
		if (tSubscriber != null) {
			tSubscriber.close();
		}
		if (tSession != null) {
			tSession.unsubscribe(StaticInfo.DURABLE_SUB);
			tSession.close();
		}
		if (tCon != null) {
			tCon.close();
		}
		System.out.println("Release Resource");
	}
}
