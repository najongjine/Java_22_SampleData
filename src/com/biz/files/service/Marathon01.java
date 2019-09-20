package com.biz.files.service;

public class Marathon01 {
	
	public Marathon01() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String solution(String[] participant, String[] completion) {
        String answer = "";
       for(int i=0; i<participant.length;i++){
           for(int j=0;j<completion.length;j++){
               if(participant[i].compareToIgnoreCase(completion[j])==0){
                   participant[i]="";
               }
           }
       }
       for(String s:participant){
           if(s.compareToIgnoreCase("")!=0){
               answer+=s;
           }
       }

       return answer;
   }
}

