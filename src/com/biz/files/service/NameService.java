package com.biz.files.service;

import java.util.List;

public interface NameService {
	public void read(String fNameFile, String lNameFile, int length) throws Exception;
	public void makeNameFile(String fullNameFile) throws Exception;
	public void sort();
	public List<String> getfNameList();
	public void setfNameList(List<String> fNameList);
}
