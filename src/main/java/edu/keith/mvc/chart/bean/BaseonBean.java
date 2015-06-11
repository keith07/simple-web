package edu.keith.mvc.chart.bean;

/**
 * @author keith
 * 对应查询字段
 */
public class BaseonBean {

	/**
	 * 对应数据库的字段名
	 */
	private String dbName;
	/**
	 * sql别名
	 */
	private String aliasName;
	/**
	 * 在sql中select片段
	 */
	private String fieldName;
	
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
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	
}
