package com.iqmsoft.domain;

public class MyJMSBean {

	private String type;
	private String text;
	
	public MyJMSBean() {
	}

	public MyJMSBean(String type, String text) {
		this.type = type;
		this.text = text;
	}

	public String getType() {
		return type;
	}

	public String getText() {
		return text;
	}

	@Override
	public String toString() {
		return "MyJMSBean [type=" + type + ", text=" + text + "]";
	}
}
