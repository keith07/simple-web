package edu.keith.tools.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import edu.keith.tools.exception.DataErrorException;

public class SimpleExcelParser implements IExcelParser<Map<String,Object>> {
	private HSSFWorkbook workbook;
	private Map<HSSFSheet,Map<String,Object>> sheetInfos;

	@Override
	public void load(File f) throws FileNotFoundException, IOException, DataErrorException {
		workbook = new HSSFWorkbook(new FileInputStream(f));
		init();
	}

	@Override
	public Map<String, Map<String, Object>> parseAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> parse(int sheetIndex) {
		return this._parse(workbook.getSheetAt(sheetIndex));
	}

	@Override
	public List<Map<String, Object>> parse(String sheetName) {
		return this._parse(workbook.getSheet(sheetName));
	}

	private List<Map<String,Object>> _parse(HSSFSheet sheet){
		if(sheet == null)
			return null;
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		Map<String,Object> sheetInfo = sheetInfos.get(sheet);
		int dataRowStartIndex = (int) sheetInfo.get("dataRowStartIndex");
		int dataRowEndIndex = (int) sheetInfo.get("dataRowEndIndex");
		List<String> fields = (List<String>) sheetInfo.get("description");
		for(int ri= dataRowStartIndex; ri <= dataRowEndIndex; ri++){
			HSSFRow row = sheet.getRow(ri);
			list.add(ri,_parseRow(row,fields));
		}
		//TODO make it
		return null;
	}
	
	private Map<String,Object> _parseRow(HSSFRow row,List<String> fields){
		Map<String,Object> map = new HashMap<String,Object>();
		for(String fieldName : fields){
			int cellnum = fields.indexOf(fieldName);
			Object value = row.getCell(cellnum);
			map.put(fieldName, value);
		}
		return map;
	}
	
	/**
	 * 解析字段描述
	 * @param sheet
	 * @return
	 * @throws DataErrorException 
	 */
	protected List<String> getFieldDescription(HSSFRow row) throws DataErrorException{
		if(row == null)
			throw new DataErrorException("Invalid data:no field description found");
		List<String> fields = new ArrayList<String>();
		short firstCellNum = row.getFirstCellNum(); // 该行的第一个单元格
		short lastCellNum = row.getLastCellNum(); // 该行的最后一个单元格
		for(int cellIndex = firstCellNum; cellIndex <= lastCellNum; cellIndex ++){
			fields.add(cellIndex, row.getCell(cellIndex).getStringCellValue());
		}
		return fields;
	}
	
	private void init() throws DataErrorException{
		if(this.workbook == null)
			throw new DataErrorException("Unknown exception workbook is null");
		sheetInfos = new HashMap<HSSFSheet,Map<String,Object>>();
		for (int sheetIndex = 0; sheetIndex < workbook.getNumberOfSheets(); sheetIndex++) {
			HSSFSheet sheet = workbook.getSheetAt(sheetIndex);
			sheetInfos.put(sheet, analyzeSheet(sheet));
		}
	}
	
	protected Map<String,Object> analyzeSheet(HSSFSheet sheet) throws DataErrorException{
		Map<String,Object> sheetInfo = new HashMap<String,Object>();
		int firstRowNum = sheet.getFirstRowNum(); // 第一行
		int lastRowNum = sheet.getLastRowNum(); // 最后一行
		HSSFRow descriptionRow = sheet.getRow(firstRowNum);
		sheetInfo.put("descriptionRow", descriptionRow);
		sheetInfo.put("description", getFieldDescription(descriptionRow));
		sheetInfo.put("dataRowStartIndex",firstRowNum+1);
		sheetInfo.put("dataRowEndIndex",lastRowNum);
		sheetInfo.put("dataCellStartIndex",descriptionRow.getFirstCellNum());
		sheetInfo.put("dataCellEndIndex",descriptionRow.getLastCellNum());
		return sheetInfo;
	}
}
