package edu.keith.mvc.chart.bean;

import java.util.ArrayList;
import java.util.List;

import edu.keith.mvc.chart.conf.BaseonBeanConf;
import edu.keith.mvc.chart.conf.DimensionBeanConf;

/**
 * @author keith
 * 一个查询语句，一类series
 * 
 * 应该包含一组维度类，一组指标类
 * 不需要包含排序字段，排序字段应该是x轴展开只用，series应该共享同一个排序字段
 */
public class SeriesBean {
	
	/**
	 * 属于哪个charbean
	 */
	private ChartBean chartBean;
	/**
	 * 标示
	 */
	private String id;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * chart类型
	 */
	private String type;
	/**
	 * 数据，待定
	 */
	private List<Object> data;
	/**
	 * 维度bean
	 */
	private List<DimensionBean> dimensionBeans;
	/**
	 * 指标bean
	 */
	private List<BaseonBean> baseonBeans;
	/**
	 * 区分bean，将一个series分成多条
	 */
	private DimensionBean separateBean;
	
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
	public List<DimensionBean> getDimensionBeans() {
		return dimensionBeans;
	}
	public void setDimensionBeans(List<DimensionBean> dimensionBeans) {
		this.dimensionBeans = dimensionBeans;
	}
	public List<BaseonBean> getBaseonBeans() {
		return baseonBeans;
	}
	public void setBaseonBeans(List<BaseonBean> baseonBeans) {
		this.baseonBeans = baseonBeans;
	}
	public DimensionBean getSeparateBean() {
		return separateBean;
	}
	public void setSeparateBean(DimensionBean separateBean) {
		this.separateBean = separateBean;
	}
	
	public SeriesBean withSeparateBeanKey(String key){
		setSeparateBean(DimensionBeanConf.beans.get(key));
		return this;
	}
	public SeriesBean withBaseonBeanKey(String key){
		BaseonBean bean = BaseonBeanConf.allBeans.get(key);
		baseonBeans = baseonBeans == null ? new ArrayList<BaseonBean>() : baseonBeans;
		baseonBeans.add(bean);
		return this;
	}
}
