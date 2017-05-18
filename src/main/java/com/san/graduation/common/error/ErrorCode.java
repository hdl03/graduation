package com.san.graduation.common.error;

/**
 * Created by huangdongliang on 2017/4/12. 放置错误码的全局变量
 *
 * 用户相关异常以1xxxxx 开头
 *
 */
public interface ErrorCode {

	public String SUUCCESS = "000000";// 表示成功
	public String DO_EXCEPTION = "000001";//操作异常
	public String EXIST_USER = "100001";// 用户已经存在
	public String WRANG_USER_OR_PASS = "100002";// 错误的用户名或密码
	public String OUT_TIME_TOKEN = "100003"; // token 超时
	public String NOT_EXIST_TOKEN = "100004"; // token  不存在
	public String NOT_EXIST_USER = "100005"; // 用户不存在



}
