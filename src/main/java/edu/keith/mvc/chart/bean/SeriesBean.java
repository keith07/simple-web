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
}
