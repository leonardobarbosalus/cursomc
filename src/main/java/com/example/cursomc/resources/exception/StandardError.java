package com.example.cursomc.resources.exception;

import java.io.Serializable;

public class StandardError implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer status ;
	private String msg;
	private long timeStemp;
	
	public StandardError(Integer status, String msg, long timeStemp) {
		super();
		this.status = status;
		this.msg = msg;
		this.timeStemp = timeStemp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public long getTimeStemp() {
		return timeStemp;
	}

	public void setTimeStemp(long timeStemp) {
		this.timeStemp = timeStemp;
	}
	
	 

}
