package edu.keith.mvc.chart.conf;

import java.util.HashMap;
import java.util.Map;

import edu.keith.mvc.chart.bean.DimensionBean;

public class DimensionBeanConf {

	public static Map<String,DimensionBean> beans;
	
	public static String DIMENSION_BEAN_NAME_ACTOR = "ACTOR";
	public static String DIMENSION_BEAN_NAME_ACTION = "ACTION";
	
	static{
		beans = new HashMap<String,DimensionBean>();
		DimensionBean actorBean = new DimensionBean();
		actorBean.setDbName("actor");
		actorBean.setAliasName("actor");
		beans.put(DIMENSION_BEAN_NAME_ACTOR, actorBean);
		DimensionBean actionBean = new DimensionBean();
		actionBean.setDbName("action");
		actionBean.setAliasName("action");
		beans.put(DIMENSION_BEAN_NAME_ACTION, actionBean);
	}
}
