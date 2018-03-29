package com.lst.utils;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

public class Result<E> implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = -8872966587737849450L;

	public String result;

	public String msg;

	public E data;

	public Result() {
		this.result = ResultsFactory.ErrorCodeConstant.CODE_SUCCESS;
		this.msg = "";
	}

	public Result(E e) {
		this.result = ResultsFactory.ErrorCodeConstant.CODE_SUCCESS;
		this.msg = "";
		this.data = e;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Result<E> error(String result, String errorMsg) {
		this.result = result;
		this.msg = errorMsg;
		return this;
	}

	public Result<E> success(String msg) {
		this.result = ResultsFactory.ErrorCodeConstant.CODE_SUCCESS;
		this.msg = msg;
		return this;
	}


	@Override
	public String toString() {
		return toJSON();
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public String toJSON() {
		return JSON.toJSONString(this);
	}

}
