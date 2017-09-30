package com.husky.excel.bean;

import java.io.Serializable;

import org.apache.poi.ss.usermodel.Sheet;

/**
 * 概况 ：接口参数<br>
 * 
 * @version 1.00 （2011.12.02）
 * @author SHNKCS husky
 */
public interface ExcelI extends Serializable {
	/**
	 * 过虑行
	 * 
	 * @param sheet
	 *            sheet对象
	 * @param rowIndex
	 *            从0开始
	 * @return true:过虑,false:不过虑
	 */
	public boolean filterRow(final Sheet sheet, final int rowIndex);

	/**
	 * 开始行,从0开始
	 * 
	 * @return 开始行索引
	 */
	public int getStartRowIndex();

	/**
	 * 开始列,从0开始
	 * 
	 * @return 开始列索引
	 */
	public int getStartColumnIndex();

	/**
	 * 结束行,从0开始,-1表示无限制
	 * 
	 * @return 结束行索引
	 */
	public int getEndRowIndex();

	/**
	 * 结束列,从0开始,-1表示无限制
	 * 
	 * @return 结束列索引
	 */
	public int getEndColumnIndex();

	/**
	 * 开始行
	 */
	public static final int START_ROW_INDEX = 0;
	/**
	 * 开始列
	 */
	public static final int START_COLUMN_INDEX = 0;

	/**
	 * 结束行
	 */
	public static final int END_ROW_INDEX = -1;
	/**
	 * 结束列
	 */
	public static final int END_COLUMN_INDEX = -1;
}
