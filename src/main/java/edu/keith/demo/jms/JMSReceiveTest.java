package edu.keith.demo.jms;


//JMS消息接收测试类
public class JMSReceiveTest  {
//	private static final Log log = LogFactory.getLog(JMSReceiveTest.class);
	private static boolean isReceiving = false;;
	private static QueueReceive qr;
	private static TopicMsgReceive tr;
	private static JMSReceiveTest instance=null;
	
	private JMSReceiveTest(){
		
	}

	public static JMSReceiveTest getInstance(){
		if(instance==null){
		    instance=new JMSReceiveTest();
		}
		return instance;
	}
	public void queueMsgTest() throws Exception {
		if (isReceiving) {
			qr.close();
			qr = null;
			System.out.println("Message  receiver closed");
			isReceiving = false;
		} else {
			System.out.println("Message start to receive");
			qr = new QueueReceive();
			qr.init();
			isReceiving = true;
		}
	}

	public void topicMsgTest() throws Exception {
		if (isReceiving) {
			tr.close();
			tr = null;
			System.out.println("Message  receiver closed");
			isReceiving = false;
		} else {
			System.out.println("Message start to receive");
			tr = new TopicMsgReceive();
			tr.init();
			isReceiving = true;
		}
	}
}
