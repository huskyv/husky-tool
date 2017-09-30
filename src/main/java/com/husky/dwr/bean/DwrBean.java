package com.husky.dwr.bean;

import java.io.Serializable;
import java.util.List;

/**
 * dwr封装类<br>
 *
 * @author husky
 */
public class DwrBean<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<String> funNameList;

	public List<String> getFunNameList() {
		return funNameList;
	}

	public void setFunNameList(List<String> funNameList) {
		this.funNameList = funNameList;
	}

	/** 传给前台的值 **/
	private T tvalue;

	public T getTvalue() {
		return tvalue;
	}

	public void setTvalue(T tvalue) {
		this.tvalue = tvalue;
	}
	/** 调用前台的函数名 **/

}
