package com.bagicode.www.bagilogindesign.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.bagicode.www.bagilogindesign.Student_Event_Retrieve;
import com.bagicode.www.bagilogindesign.Student_Result_Retrieve;


public class View_My_Announcements extends Fragment {

    public static  View_My_Announcements newInstance() {
        View_My_Announcements Fragment = new  View_My_Announcements();
        Bundle bundle = new Bundle();
        Fragment.setArguments(bundle);
        return Fragment;
    }

    @Nullable
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(getActivity(), Student_Event_Retrieve.class);
        // mStudentAttendProduct.clear();
        startActivity(intent);
    }
}