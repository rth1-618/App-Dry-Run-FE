package com.example.studentdryrunappphase;

public class Student {

    private String sName;

    private String sID;

    public Student( String sID, String sName) {
        this.sID = sID;
        this.sName = sName;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsID() {
        return sID;
    }

    public void setsID(String sID) {
        this.sID = sID;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sName='" + sName + '\'' +
                ", sID='" + sID + '\'' +
                '}';
    }
}
