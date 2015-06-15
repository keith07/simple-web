package edu.keith.mvc.chart.bean;

import java.util.List;

/**
 * @author keith
 * 一个查询语句，一类series
 */
public class SeriesBean {
	
	private ChartBean chartBean;
	private String id;
	private String name;
	private String type;
	private List<Object> data;
	private List<BaseonBean> baseonBeans;
	private List<SeriesBean> seriesBeans;
	public ChartBean getChartBean() {
		return chartBean;
	}
	public void setChartBean(ChartBean chartBean) {
		this.chartBean = chartBean;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<Object> getData() {
		return data;
	}
	public void setData(List<Object> data) {
		this.data = data;
	}
	public List<BaseonBean> getBaseonBeans() {
		return baseonBeans;
	}
	public void setBaseonBeans(List<BaseonBean> baseonBeans) {
		this.baseonBeans = baseonBeans;
	}
	public List<SeriesBean> getSeriesBeans() {
		return seriesBeans;
	}
	public void setSeriesBeans(List<SeriesBean> seriesBeans) {
		this.seriesBeans = seriesBeans;
	}
}
