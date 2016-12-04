package edu.keith.mvc.chart;

import edu.keith.mvc.chart.bean.ChartBean;
import edu.keith.mvc.chart.conf.ChartBeanConf;

/**
 * 用来将配置好的chart转成用于展示的json
 * @author Administrator
 *
 */
public abstract class ChartProducer {

	/**
	 * 根据配置，查询数据，然后产生chart
	 * @param chartId
	 */
	public void produce(String chartId){
		ChartBean chart = ChartBeanConf.getChart(chartId);
		
	}
	/**
	 * 将填满数据的chart转换成json格式
	 * @param chart
	 * @return
	 */
	public static String parseToJson(ChartBean chart){
		String json = "";
		//TODO
		return json;
	}
}
