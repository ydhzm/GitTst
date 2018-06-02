package com.pingan.tst.tstapp.data;

import java.io.Serializable;

public class Student implements Serializable {

    String name;
    int  age;
    StudentInfo studentInfo;
    public Student(String name,int age,StudentInfo o) {
        this.age =age;
        this.name =name;
        this.studentInfo = o;
    }
    public String Student(int a) {
        return "jack";
    }
    public void setName(String v) {
        name = v;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setMath(int math) {
        if(studentInfo!=null) {
            studentInfo.setMath(math);
        }
    }
    @Override
    public String toString() {
        String value = super.toString();
        value+=" "+studentInfo.toString();
        value += "::"+ " name= "+name+" age = "+age;
        return value;
    }
//    @Override
//    public Object clone() throws CloneNotSupportedException {
//        Object object = super.clone();
//        StudentInfo anStudentInfo =(StudentInfo) studentInfo.clone();
//        ((Student)object).studentInfo = anStudentInfo;
//        return object;
//    }

//	public Object clone() throws CloneNotSupportedException{
//		super.clone();
//		return null;
//	}
}
