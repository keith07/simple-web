package edu.keith.demo.jms;


public class JMSSendTest  {
//	private static final Log log = LogFactory.getLog(JMSSendTest.class);
	
	private static JMSSendTest instance=null;
	
	private JMSSendTest(){
		
	}

	public static JMSSendTest getInstance(){
		if(instance==null){
		    instance=new JMSSendTest();
		}
		return instance;
	}
	
	@SuppressWarnings("unused")
	private void queueMsgTest() throws Exception{
		QueueSend qs = new QueueSend();
		qs.init();
		qs.send();
		qs.close();
	}

	@SuppressWarnings("unused")
	private void topicMsgTest() throws Exception{
		TopicMsgSend ts = new TopicMsgSend();
		ts.init();
		ts.send();
		ts.close();
	}
}
