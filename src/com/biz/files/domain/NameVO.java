package com.biz.files.domain;

public class NameVO {
	private String Name;

	public NameVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NameVO(String name) {
		super();
		Name = name;
	}

	public String getName() {
		return Name;
	}

	public void setName(String fName, String lName) {
		Name = lName+fName;
	}
	
}
