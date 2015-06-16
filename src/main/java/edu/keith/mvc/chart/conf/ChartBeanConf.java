package edu.keith.mvc.chart.conf;

import java.util.HashMap;
import java.util.Map;

import edu.keith.mvc.chart.bean.ChartBean;

public class ChartBeanConf {

	public static Map<String,ChartBean> allCharts;
	
	public static String CHART_BEAN_NAME_ACTION_ACTOR_COUNTS;
	static{
		allCharts = new HashMap<String,ChartBean>();
		ChartBean chart = new ChartBean()
			.withBaseonKey(BaseonBeanConf.BASE_ON_BEAN_NAME_COUNT)
			.withExpandKey(DimensionBeanConf.DIMENSION_BEAN_NAME_ACTION)
			.withSeriesKey(SeriesBeanConf.SERIES_BEAN_KEY_ACTION_COUNTS);
		allCharts.put(CHART_BEAN_NAME_ACTION_ACTOR_COUNTS, chart);
	}
}
