package com.bagicode.www.bagilogindesign.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.bagicode.www.bagilogindesign.Faculty_Add_Events;
import com.bagicode.www.bagilogindesign.Student_Details;
import com.bagicode.www.bagilogindesign.Student_Event_Retrieve;
import com.bagicode.www.bagilogindesign.Student_Register_Activity;


public class Send_Announcements extends Fragment {

    public static Send_Announcements newInstance() {
        Send_Announcements fragment = new Send_Announcements();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(getActivity(),Faculty_Add_Events.class);
        startActivity(intent);
    }
}
