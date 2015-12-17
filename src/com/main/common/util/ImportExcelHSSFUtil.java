package com.main.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/**
 * 
 * AutoConfirmUtil Description: ���ݵ��������˵������Զ����� Company: www.edu24ol.com
 * 
 * @author pc-zw
 * @date 2015��12��3������5:37:38
 * @version 1.0
 */
public class ImportExcelHSSFUtil {

	private static Logger log;
	/** ���� */
	private static int rowsNum = 0;

	/** ���� */
	private static int columnNum = 0;

	// ���ݱ������ͽ���Excel�ļ���ȡ
	public static List<String> getExcelStringList(InputStream is) {				
		try {
			List<String> results = new ArrayList<String>(); 
			//�������������
			POIFSFileSystem fs = new POIFSFileSystem(is);
			// �õ�Excel����������
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			// �õ���һ��Sheet
			HSSFSheet sheet = wb.getSheetAt(0);
			// ��ȡSheet��������
			rowsNum = sheet.getLastRowNum();;
			// ��ȡ����
			//HSSFRow row = sheet.getRow(0);
			//columnNum = row.getPhysicalNumberOfCells();	
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
	 * �������н���Excel
	 * 
	 * @param sheet
	 * @param startRow
	 * @param startColumn
	 * @param totalRows
	 * @param columnNum
	 * @return
	 */
	private static List<String> readExcel(HSSFSheet sheet, int startRow,
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
				HSSFRow row = sheet.getRow(i);
				if (row == null) {// ����ʱ����ѭ��
					break;
				}
				// ��ʼѭ����
				for (int j = startColumn; j < columnNum; j++) {
					HSSFCell cell = row.getCell(j);
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
	 * ��ȡָ��Sheet����
	 * 
	 * @param sheet
	 * @param startRow
	 * @param startColumn
	 * @return
	 */
	private static int getColumnNum(HSSFSheet sheet, int startRow,
			int startColumn) {
		int columnNum = 0;
		HSSFRow row = null;
		if (startRow == 0) {
			row = sheet.getRow(0);
		} else {
			row = sheet.getRow(startRow - 1);
		}
		for (int i = startColumn;; i++) {
			HSSFCell cell = row.getCell(i);
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
	 * ������ȡ��Ԫ�������
	 * 
	 * @param cell
	 * @return
	 */
	private static String getCellValue(HSSFCell cell) {
		String ret;
		switch (cell.getCellType()) {
		// �հ�
		case HSSFCell.CELL_TYPE_BLANK:
			ret = "";
			break;
		// ����
		case HSSFCell.CELL_TYPE_BOOLEAN:
			ret = String.valueOf(cell.getBooleanCellValue());
			break;
		// ����
		case HSSFCell.CELL_TYPE_ERROR:
			ret = null;
			break;
		// ��ֵ
		case HSSFCell.CELL_TYPE_NUMERIC:
	        //�ж��Ƿ��Ǳ�׼���ڸ�ʽ�������Զ������ڸ�ʽ
			if (HSSFDateUtil.isCellDateFormatted(cell) || cell.getCellStyle().getDataFormat()==179) {
            		SimpleDateFormat sdf = new SimpleDateFormat(
            				DateUtil.BOTH);            		
					ret = sdf.format(cell.getDateCellValue()); 
			}else{
					ret = cell.getNumericCellValue() + "";
			}            	             
            break;  
		// �ַ���
		case HSSFCell.CELL_TYPE_STRING:
			ret = cell.getStringCellValue();
			break;
		// Ĭ��
		default:
			ret = null;
		}
		return ret;
	}
}
