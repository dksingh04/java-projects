package com.nuance.file.info.beans;

public class GenericResponseBean {

	private String message;
	private int respStatusCode;
	private String errorCode;
	private String errorDesc;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getRespStatusCode() {
		return respStatusCode;
	}

	public void setRespStatusCode(int respStatusCode) {
		this.respStatusCode = respStatusCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorDesc() {
		return errorDesc;
	}

	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}
	
	

}
