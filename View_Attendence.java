package com.bagicode.www.bagilogindesign.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bagicode.www.bagilogindesign.Student_Attend_Product;
import com.bagicode.www.bagilogindesign.Student_Attend_Retrieve;
import com.bagicode.www.bagilogindesign.Student_Report;
import com.bagicode.www.bagilogindesign.Student_Retrieve;

//import static com.bagicode.www.bagilogindesign.Student_Login_Activity.mStudentAttendProductList;


public class View_Attendence extends Fragment {
    public static View_Attendence getInstance(String title) {
        View_Attendence fragment = new View_Attendence();

        Bundle args = new Bundle();
        args.putString("Attendance",title);
        fragment.setArguments(args);
        return fragment;
    }
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(getActivity(),Student_Report.class);
        startActivity(intent);
        return null;
    }
}
