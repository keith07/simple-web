package edu.keith.mvc.chart.bean;

/**
 * @author keith
 * 对应表信息
 */
public class TableBean {

	/**
	 * 数据库的表名
	 */
	private String dbName;
	/**
	 * sql别名
	 */
	private String aliasName;
	
	public String getDbName() {
		return dbName;
	}
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	public String getAliasName() {
		return aliasName;
	}
	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}
}
