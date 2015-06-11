package edu.keith.mvc.chart.conf;

import java.util.HashMap;
import java.util.Map;

import edu.keith.mvc.chart.bean.TableBean;

public class TableBeanConf {

	public static Map<String,TableBean> allTables;
	
	/**
	 * 表名常量
	 */
	public static String TABLE_BEAN_NAME_ACTOR_LOG = "ACTOR_LOG_NAME";
	
	static{
		allTables = new HashMap<String,TableBean>();
		TableBean table = new TableBean();
		table.setDbName("ACTOR_LOG");
		table.setAliasName("log");
		allTables.put(TABLE_BEAN_NAME_ACTOR_LOG, table);
	}
}
