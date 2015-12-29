package edu.keith.demo.jms;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class StaticInfo {

	// Defines the JNDI context factory.
	public final static String JNDI_FACTORY = "weblogic.jndi.WLInitialContextFactory";
	// Defines the JNDI provider url.
	public final static String PROVIDER_URL = "t3://localhost:7001";
	// Defines the JMS connection factory for the queue.
	public final static String JMS_FACTORY = "javax.jms.QueueConnectionFactory";
	// Defines the queue 用的是对应 QUEUE的JNDI名子
	public final static String QUEUE = "testqueue";
	// 定义主题发布者(JNDI名称)
	public final static String TOPIC = "testtopic";
	public final static String DURABLE_SUB = "MySub";
	private static Context context = null;

	// 返回应用服务器上下文
	public static Context getContext() throws NamingException {
		if (context == null) {
			try {
				Hashtable<String, String> env = new Hashtable<String, String>();
				env.put(Context.INITIAL_CONTEXT_FACTORY, JNDI_FACTORY);
				env.put(Context.PROVIDER_URL, PROVIDER_URL);
				context = new InitialContext(env);
			} catch (NamingException ex) {
				ex.printStackTrace();
				throw ex;
			}
		}
		return context;
	}
}
