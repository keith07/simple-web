package edu.keith.mvc.chart.bean;

import java.util.List;

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

	public BaseonBean getOrderBean() {
		return orderBean;
	}

	public void setOrderBean(BaseonBean orderBean) {
		this.orderBean = orderBean;
	}
}
