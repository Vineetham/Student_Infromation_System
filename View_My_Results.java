package com.bagicode.www.bagilogindesign.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bagicode.www.bagilogindesign.R;
import com.bagicode.www.bagilogindesign.Student_Attend_Retrieve;
import com.bagicode.www.bagilogindesign.Student_Result_Retrieve;


public class View_My_Results extends Fragment {

    public static View_My_Results newInstance() {
        View_My_Results Fragment = new View_My_Results();
        Bundle bundle = new Bundle();
        Fragment.setArguments(bundle);
        return Fragment;
    }

    @Nullable
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(getActivity(), Student_Result_Retrieve.class);
        // mStudentAttendProduct.clear();
        startActivity(intent);
    }
}