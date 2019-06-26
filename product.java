package com.bagicode.www.bagilogindesign;

public class product {
    private int rid;
    private String fullname;
    private String branch;
    private String semester;
    private String section;
    private String usnno;
    private String dob;
    private String email;
    private String gender;
    private String phonenumber;
    private String password;
    private String confirmpassword;

    public product( int rid ,String fullname,String branch,String semester,String section, String usnno, String dob, String email, String gender, String phonenumber) {
        this.rid = rid;
        this.fullname = fullname;
        this.branch=branch;
        this.semester=semester;
        this.section=section;
        this.usnno = usnno;
        this.dob = dob;
        this.email = email;
        this.gender = gender;
        this.phonenumber = phonenumber;
        this.password = password;
        this.confirmpassword = confirmpassword;

    }

    public int getRid() {
        return rid;
    }

    public String getFullname() {
        return fullname;
    }
    public  String getBranch(){
        return branch;
    }
    public  String getSemester(){
        return semester;
    }
    public  String getSection(){
        return section;
    }

    public String getUsnno() {
        return usnno;
    }

    public String getDob() {
        return dob;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }
    public String getPhonenumber() {
        return phonenumber;
    }
    public String getPassword() {
        return password;
    }
    public String getConfirmpassword() {
        return confirmpassword;
    }


}