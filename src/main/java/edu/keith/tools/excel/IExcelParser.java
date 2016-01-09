package edu.keith.tools.excel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import edu.keith.tools.exception.DataErrorException;

public interface IExcelParser<T> {

	/**
	 * 加载excel文件
	 * @param f
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws DataErrorException 
	 */
	public void load(File f) throws FileNotFoundException, IOException, DataErrorException;
	/**
	 * 解析成指定格式
	 * 返回值为map，k为sheet页名称，v为各页解析结果
	 * @return
	 */
	public Map<String,T> parseAll();
	/**
	 * 解析指定页成指定格式
	 * @return
	 */
	public List<Map<String, Object>> parse(int sheetIndex);
	/**
	 * 解析指定页成指定格式
	 * @return
	 */
	public List<Map<String, Object>> parse(String sheetName);
}
