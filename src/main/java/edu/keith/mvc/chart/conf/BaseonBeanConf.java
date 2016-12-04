package edu.keith.mvc.chart.conf;

import java.util.HashMap;
import java.util.Map;

import edu.keith.mvc.chart.bean.BaseonBean;

public class BaseonBeanConf {

	public static Map<String,BaseonBean> allBeans;
	
	public static String BASE_ON_BEAN_NAME_COUNT = "COUNT";
	
	static{
		allBeans = new HashMap<String,BaseonBean>();
		BaseonBean bean = new BaseonBean();
		bean.setAliasName("counts");
		bean.setDbName("sid");
		bean.setFieldName("count(sid)");
		allBeans.put(BASE_ON_BEAN_NAME_COUNT, bean);
	}
}
