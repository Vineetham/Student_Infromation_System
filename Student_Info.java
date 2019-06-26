package com.bagicode.www.bagilogindesign.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bagicode.www.bagilogindesign.R;
import com.bagicode.www.bagilogindesign.Student_Retrieve;


public class Student_Info extends Fragment {

    public static Student_Info newInstance() {
        Student_Info fragment = new Student_Info();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(getActivity(),Student_Retrieve.class);
        startActivity(intent);
    }

}
