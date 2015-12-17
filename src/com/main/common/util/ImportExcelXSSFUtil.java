package com.main.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


/**
 * 
 * AutoConfirmUtil Description: ���ݵ��������˵������Զ����� Company: www.edu24ol.com
 * 
 * @author pc-zw
 * @date 2015��12��3������5:37:38
 * @version 1.0
 */
public class ImportExcelXSSFUtil {

	private static Logger log;
	/** ���� */
	private static int rowsNum = 0;

	/** ���� */
	private static int columnNum = 0;

	// ���ݱ������ͽ���Excel�ļ���ȡ
	public static List<String> getExcelStringList(InputStream is) throws EncryptedDocumentException, InvalidFormatException {				
		try {
			List<String> results = new ArrayList<String>(); 
			//�õ�����������
			Workbook workbook = WorkbookFactory.create(is);
			//�õ���һ��Sheet  
	        Sheet sheet = workbook.getSheetAt(0);   
	        // ��ȡSheet��������
	     	rowsNum = sheet.getLastRowNum();;
	     	// ��ȡ����
	     	columnNum = getColumnNum(sheet, 4, 1);
	     	Row row = sheet.getRow(0);
			
	     	columnNum = getColumnNum(sheet, 4, 1);
			//��ʼ��ȡ
			results = readExcel(sheet, 0, 0, rowsNum, columnNum);
				
			return results;
		} catch (IOException e) {
			log.error("read Excel Throws Exception!");
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				log.error("fileinputStream close Throws Exception!");
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * ��ȡָ��Sheet����
	 * 
	 * @param sheet
	 * @param startRow
	 * @param startColumn
	 * @return
	 */
	private static int getColumnNum(Sheet sheet, int startRow,
			int startColumn) {
		int columnNum = 0;
		Row row = null;
		if (startRow == 0) {
			row = sheet.getRow(0);
		} else {
			row = sheet.getRow(startRow - 1);
		}
		for (int i = startColumn;; i++) {
			Cell cell = row.getCell(i);
			if (cell == null) {
				columnNum = i;
				break;
			} else {
				if (("").equals(cell.toString())) {
					columnNum = i;
					break;
				}
			}
		}
		return columnNum;
	}

	/**
	 * �������н���Excel
	 * 
	 * @param sheet
	 * @param startRow
	 * @param startColumn
	 * @param totalRows
	 * @param columnNum
	 * @return
	 */
	private static List<String> readExcel(Sheet sheet, int startRow,
			int startColumn, int totalRows, int columnNum) {
		List<String> results = new ArrayList<String>();
		try {
			// �Ƿ�����������
			boolean flag = true;
			// ��ʼѭ����
			for (int i = startRow; i <= totalRows; i++) {
				StringBuffer sb = new StringBuffer();
				if (!flag) {
					break;
				}
				Row row = sheet.getRow(i);
				if (row == null) {// ����ʱ����ѭ��
					break;
				}
				// ��ʼѭ����
				for (int j = startColumn; j < columnNum; j++) {
					Cell cell = row.getCell(j);
					if (cell == null) {
						continue;
					} else {
						sb.append("\t"+getCellValue(cell)) ;
					}
				}
				results.add(sb.toString()+"\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return results;
	}

	
	/**
	 * ������ȡ��Ԫ�������
	 * 
	 * @param cell
	 * @return
	 */
	private static String getCellValue(Cell cell) {
		String ret;
		switch (cell.getCellType()) {
		// �հ�
		case Cell.CELL_TYPE_BLANK:
			ret = "";
			break;
		// ����
		case Cell.CELL_TYPE_BOOLEAN:
			ret = String.valueOf(cell.getBooleanCellValue());
			break;
		// ����
		case Cell.CELL_TYPE_ERROR:
			ret = null;
			break;
		// ��ֵ
		case Cell.CELL_TYPE_NUMERIC:
			 double cellvalue = cell.getNumericCellValue(); 
	        //�ж��Ƿ��Ǳ�׼���ڸ�ʽ�������Զ������ڸ�ʽ
			if (org.apache.poi.ss.usermodel.DateUtil.isValidExcelDate(cellvalue) || cell.getCellStyle().getDataFormat()==179) {
            		SimpleDateFormat sdf = new SimpleDateFormat(
            				DateUtil.BOTH);            		
					ret = sdf.format(cell.getDateCellValue()); 
			}else{
					ret = cellvalue + "";
			}            	             
            break;  
		// �ַ���
		case Cell.CELL_TYPE_STRING:
			ret = cell.getStringCellValue();
			break;
		// Ĭ��
		default:
			ret = null;
		}
		return ret;
	}
}
