package com.bagicode.www.bagilogindesign.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.bagicode.www.bagilogindesign.LoginHome;

//import static com.bagicode.www.bagilogindesign.Student_Login_Activity.mStudentAttendProductList;


public class Student_Logout extends Fragment {

    public static Student_Logout newInstance() {
        Student_Logout fragment = new Student_Logout();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(getActivity(), LoginHome.class);
        //mStudentAttendProductList.clear();
        startActivity(intent);

    }
}
