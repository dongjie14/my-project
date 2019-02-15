package com.easyget.view.result;

import com.easyget.enums.ApiErrorCodeEnum;

import java.io.Serializable;

/**
 * 前后通讯数据格式
 *
 * @version 2016-07-26
 */
public class ResponseData implements Serializable {
	/**
	 * 状态码 200：成功 300：失败
	 */
	private int code;
	/**
	 * 消息提示 默认操作成功
	 */
	private String msg;
	/**
	 * 业务数据
	 */
	private Object data;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public ResponseData(ApiErrorCodeEnum errorCode, Object data) {
		setCode(errorCode.getCode());
		setMsg(errorCode.getMsg());
		setData(data);
	}

	public ResponseData(ApiErrorCodeEnum errorCode, Object data, String msg) {
		setCode(errorCode.getCode());
		setMsg(msg);
		setData(data);
	}

	public ResponseData() {
	}
}
