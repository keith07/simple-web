package edu.keith.mvc.chart.bean;

import java.util.ArrayList;
import java.util.List;

import edu.keith.mvc.chart.conf.BaseonBeanConf;
import edu.keith.mvc.chart.conf.DimensionBeanConf;
import edu.keith.mvc.chart.conf.SeriesBeanConf;

public class ChartBean {

	/**
	 * 标示
	 */
	private String id;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 子标题
	 */
	private String subTitle;
	/**
	 * 类型
	 */
	private String type;
	/**
	 * series
	 */
	private List<SeriesBean> series;
	/**
	 * x轴展开字段
	 * 可能为指标字段，也可能为维度字段
	 */
	private IFieldBean expandBean;
	/**
	 * y轴显示字段
	 */
	private BaseonBean baseonBean;

	/**
	 * 排序bean
	 */
	private BaseonBean orderBean;

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<SeriesBean> getSeries() {
		return series;
	}

	public void setSeries(List<SeriesBean> series) {
		this.series = series;
	}

	public IFieldBean getExpandBean() {
		return expandBean;
	}

	public void setExpandBean(IFieldBean expandBean) {
		this.expandBean = expandBean;
	}
	
	public BaseonBean getBaseonBean() {
		return baseonBean;
	}

	public void setBaseonBean(BaseonBean baseonBean) {
		this.baseonBean = baseonBean;
	}

	public BaseonBean getOrderBean() {
		return orderBean;
	}

	public void setOrderBean(BaseonBean orderBean) {
		this.orderBean = orderBean;
	}
	
	public ChartBean withBaseonKey(String key){
		setBaseonBean(BaseonBeanConf.allBeans.get(key));
		return this;
	}
	public ChartBean withExpandKey(String key){
		expandBean = BaseonBeanConf.allBeans.get(key);
		expandBean = expandBean == null ? DimensionBeanConf.beans.get(key) : expandBean;
		return this;
	}
	public ChartBean withSeriesKey(String key){
		series = series == null ? new ArrayList<SeriesBean>() : series;
		series.add(SeriesBeanConf.allBeans.get(key));
		return this;
	}
}
