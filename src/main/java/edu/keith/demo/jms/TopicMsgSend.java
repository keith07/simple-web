package edu.keith.demo.jms;

import javax.jms.BytesMessage;
import javax.jms.MapMessage;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.StreamMessage;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;

import edu.keith.mvc.entity.UserInfo;

public class TopicMsgSend {

	private TopicConnectionFactory tConFactory;
	private TopicConnection tCon;
	private TopicSession tSession;
	private TopicPublisher tPublisher;
	private Topic topic;

	private TextMessage msg;
	private StreamMessage sm;
	private BytesMessage bm;
	private MapMessage mm;
	private ObjectMessage om;
	
	public void init() throws Exception {
		initPublisher();
		initMsg();
	}

	public void initPublisher() throws Exception {
		
		tConFactory = (TopicConnectionFactory) StaticInfo.getContext().lookup(
				StaticInfo.JMS_FACTORY);
		tCon = tConFactory.createTopicConnection();
		tSession = tCon.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
		topic = (Topic) StaticInfo.getContext().lookup(StaticInfo.TOPIC);
		tPublisher = tSession.createPublisher(topic);
		tCon.start();
	}

	public void initMsg() throws Exception {

		msg = tSession.createTextMessage();
		sm = tSession.createStreamMessage();
		bm = tSession.createBytesMessage();
		mm = tSession.createMapMessage();
		om = tSession.createObjectMessage();

		msg.setText("TextMessage");

		sm.writeString("StreamMessage");
		sm.writeDouble(23.33);

		String name = "BytesMessage";
		byte[] block = name.getBytes();
		bm.writeBytes(block);

		mm.setString("name", "xmddl369");

		UserInfo ui = new UserInfo();
		ui.setUserName("xmddl369");
		ui.setSid(100);
		om.setObject(ui);
	}

	public void send() throws Exception {

		tPublisher.publish(msg);
		tPublisher.publish(sm);
		tPublisher.publish(bm);
		tPublisher.publish(mm);
		tPublisher.publish(om);
	}

	// 释放资源
	public void close() throws Exception {
		if (tPublisher != null) {
			tPublisher.close();
		}

		if (tSession != null) {
			tSession.close();
		}
		if (tCon != null) {
			tCon.close();
		}
		System.out.println("Release Resource");
	}
}
