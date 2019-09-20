package com.biz.files;

import com.biz.files.service.Marathon01;

public class Test01 {
	public static void main(String[] args) {
		Marathon01 marathon=new Marathon01();
		String[] participant= {
				"leo", "kiki", "eden"
		};
		String[] completion= {
				"eden", "kiki"
		};
		//System.out.println(participant[2].compareToIgnoreCase(completion[0]));
		System.out.println(marathon.solution(participant, completion));
	}
}
