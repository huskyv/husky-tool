package com.husky.serverTimeout.bean;

/**
 * 超时异常类
 * @author husky
 */
public class TimeOutException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public TimeOutException() {
		super();
	}
	public TimeOutException(String string) {
		super(string);
	}
	
}
