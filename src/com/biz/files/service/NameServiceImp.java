package com.biz.files.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.biz.files.domain.NameVO;

public class NameServiceImp implements NameService {
	private List<String> fNameList;
	private List<String> lNameList;
	private List<NameVO> nameVOList;
	
	public NameServiceImp(){
		fNameList=new ArrayList<String>();
		lNameList=new ArrayList<String>();
		nameVOList=new ArrayList<NameVO>();
	}
	
	public List<String> getfNameList() {
		return fNameList;
	}

	public void setfNameList(List<String> fNameList) {
		this.fNameList = fNameList;
	}

	public List<String> getlNameList() {
		return lNameList;
	}

	public void setlNameList(List<String> lNameList) {
		this.lNameList = lNameList;
	}

	@Override
	public void read(String fNameFile, String lNameFile, int length) throws Exception {
		// TODO Auto-generated method stub
		FileReader fileReader;
		BufferedReader bufferReader;
		String strLNameSet="",strLName="";
		String strFName="";
		
		fileReader=new FileReader(lNameFile);
		bufferReader=new BufferedReader(fileReader);
		for(int i=0;i<length;i++) {
			strLNameSet=bufferReader.readLine();
			if(strLNameSet==null) break;
			String[] _strLName=strLNameSet.split(":");
			strLName=_strLName[1];
			strLName=strLName.substring(0, 1);
			
			lNameList.add(strLName);
		}
		Collections.shuffle(lNameList);
		
		
		bufferReader.close();
		fileReader.close();
		
		fileReader=new FileReader(fNameFile);
		bufferReader=new BufferedReader(fileReader);
		
		for(int i=0;i<length;i++) {
			strFName=bufferReader.readLine();
			if(strFName==null) break;
			fNameList.add(strFName);
		}
		bufferReader.close();
		fileReader.close();
		int listSize=lNameList.size();
		for(int i=0;i<listSize;i++) {
			NameVO vo=new NameVO();
			//vo.setlName(lNameList.get(i));
			//vo.setfName(fNameList.get(i));
			vo.setName(fNameList.get(i), lNameList.get(i));
			nameVOList.add(vo);
		}
		
		/*for(NameVO vo:nameVOList) { // test 출력용
			System.out.println(vo.getlName()+vo.getfName());
		}*/
		sort();
	}//end

	@Override
	public void makeNameFile(String fullNameFile) throws Exception{
		FileWriter fw;
		PrintWriter printWriter;
		fw=new FileWriter(fullNameFile);
		printWriter=new PrintWriter(fw);
		int listSize=nameVOList.size();
		
		for(int i=0;i<listSize;i++) {
			printWriter.printf("%s\n",nameVOList.get(i).getName());
			printWriter.flush();
		}
		printWriter.close();
	}//end
	
	public void sort() {
		Collections.sort(nameVOList, new Comparator<NameVO>() {

			@Override
			public int compare(NameVO o1, NameVO o2) {
				// TODO Auto-generated method stub
				return o1.getName().compareTo(o2.getName());
			}
		});
		
	}

}
