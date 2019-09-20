package com.biz.files;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.biz.files.service.NameService;
import com.biz.files.service.NameServiceImp;

public class NameEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileFName="src/com/biz/files/이름리스트.txt";
		String fileLName="src/com/biz/files/성씨리스트.txt";
		String fileFullName="src/com/biz/files/이름리스트2.txt";
		int length=30;
		NameService ns=new NameServiceImp();
		try {
			ns.read(fileFName, fileLName, length);
			ns.makeNameFile(fileFullName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
