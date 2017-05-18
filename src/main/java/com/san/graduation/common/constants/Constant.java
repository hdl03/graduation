package com.san.graduation.common.constants;

/**
 *一些常量数据放在这里
 *
 *
 */

public interface Constant {
	
	/** 正常。 */
	public static final Boolean DELETE_SIGN_NORMAL = false;
	/** 已删除。 */
	public static final Boolean DELETE_SIGN_DELETE = true;

	public static final Integer VERSION  = 0; // 用于乐观锁
	public static final String OPTIONS_METHOD = "OPTIONS"; // options 方法

	public static final String CREATE_UPDATE_BY = "000000";
	
}
