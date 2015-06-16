package edu.keith.mvc.chart.conf;

import java.util.HashMap;
import java.util.Map;

import edu.keith.mvc.chart.bean.SeriesBean;

public class SeriesBeanConf {

	public static Map<String,SeriesBean> allBeans;
	public static String SERIES_BEAN_KEY_ACTION_COUNTS = "ACTION_COUNTS";
	
	static{
		allBeans = new HashMap<String,SeriesBean>();
		SeriesBean series = new SeriesBean()
			.withSeparateBeanKey(DimensionBeanConf.DIMENSION_BEAN_NAME_ACTION)
			.withBaseonBeanKey(BaseonBeanConf.BASE_ON_BEAN_NAME_COUNT);
		allBeans.put(SERIES_BEAN_KEY_ACTION_COUNTS, series);
	}
}
