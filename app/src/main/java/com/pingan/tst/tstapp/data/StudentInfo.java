package com.pingan.tst.tstapp.data;

import java.io.Serializable;

public class StudentInfo implements Serializable{
    int math;
    public int getMath() {
        return math;
    }
    public void setMath(int math) {
        this.math = math;
    }
    public StudentInfo(int math) {
        Object object = new Object();
        this.math = math;
    }
    @Override
    public String toString() {
        return super.toString() +" math = "+math;
    }
}
