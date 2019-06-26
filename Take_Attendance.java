package com.bagicode.www.bagilogindesign.fragments;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bagicode.www.bagilogindesign.Faculty_Retrieve;
import com.bagicode.www.bagilogindesign.Facultyactivity;
import com.bagicode.www.bagilogindesign.R;
public class Take_Attendance extends Fragment {
    public static Take_Attendance newInstance() {
        Take_Attendance fragment = new Take_Attendance();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(getActivity(),Facultyactivity.class);
        startActivity(intent);
    }
}
