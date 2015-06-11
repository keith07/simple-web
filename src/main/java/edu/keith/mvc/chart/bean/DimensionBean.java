package edu.keith.mvc.chart.bean;

/**
 * @author keith
 * 对应sql中的group by字段
 */
public class DimensionBean {

	/**
	 * 数据库字段名
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
