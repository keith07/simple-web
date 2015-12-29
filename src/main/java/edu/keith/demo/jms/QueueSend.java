package edu.keith.demo.jms;

import javax.jms.BytesMessage;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.StreamMessage;
import javax.jms.TextMessage;

import edu.keith.mvc.entity.UserInfo;

public class QueueSend {

	private QueueConnectionFactory qconFactory;
	private QueueConnection qcon;
	private QueueSession qsession;
	private QueueSender qsender;
	private Queue queue;
	
	private TextMessage msg;
	private StreamMessage sm;
	private BytesMessage bm;
	private MapMessage mm;
	private ObjectMessage om;

	
	public void init()throws Exception{
		initSender();
		initMsg();
	}

	public void initSender() throws Exception {
		qconFactory = (QueueConnectionFactory) StaticInfo.getContext().lookup(
				StaticInfo.JMS_FACTORY);
		qcon = qconFactory.createQueueConnection();
		qsession = qcon.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
		queue = (Queue) StaticInfo.getContext().lookup(StaticInfo.QUEUE);
		qsender = qsession.createSender(queue);

		qcon.start();
	}

	public void initMsg() throws Exception {
		msg = qsession.createTextMessage();
		sm = qsession.createStreamMessage();
		bm = qsession.createBytesMessage();
		mm = qsession.createMapMessage();
		om = qsession.createObjectMessage();
		
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
		qsender.send(msg);
		qsender.send(sm);
		qsender.send(bm);
		qsender.send(mm);
		qsender.send(om);
	}

	public void close() throws JMSException {
		qsender.close();
		qsession.close();
		qcon.close();
	}
}
