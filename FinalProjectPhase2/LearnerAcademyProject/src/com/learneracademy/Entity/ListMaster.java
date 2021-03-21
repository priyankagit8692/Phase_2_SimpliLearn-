package com.learneracademy.Entity;

import java.util.ArrayList;
import java.util.List;

public class ListMaster {
	 public static List<String> getMasterCLass() {
	        List<String> classList = new ArrayList<>();
	        classList.add("I");
	        classList.add("II");
	        classList.add("III");
	        classList.add("IV");
	        classList.add("V");
	        classList.add("VI");
	        classList.add("VII");
	        classList.add("VIII");
	        classList.add("IX");
	        classList.add("X");
	        classList.add("XI");
	        classList.add("XII");

	        return classList;
	    }

	    public static List<String> getMasterTeacher() {
	        List<String> teacherList = new ArrayList<>();
	        teacherList.add("Mr.Mahesh Pathak");
	        teacherList.add("Ms.Divya Rai");
	        teacherList.add("Mrs.Sayali Kulkarni");
	        teacherList.add("Ms.Priyanka Gupta");
	        teacherList.add("Mr.Devesh Rathore");
	        teacherList.add("Mrs.Diksha Tanwar");
	        teacherList.add("Mr.Rahul Singh");
	        teacherList.add("Mrs.Dhruv Tanwar");
	        teacherList.add("Mr.Ramesh Singh");

	        return teacherList;
	    }

	    public static List<String> getMasterSubject() {
	        List<String> subjectList = new ArrayList<>();
	        subjectList.add("English");
	        subjectList.add("Hindi");
	        subjectList.add("Mathematics");
	        subjectList.add("Physics");
	        subjectList.add("Chemistry");
	        subjectList.add("Biology");
	        subjectList.add("History");
	        subjectList.add("Civics");
	        subjectList.add("Geography");

	        return subjectList;
	    }



}
