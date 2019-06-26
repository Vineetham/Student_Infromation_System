package com.bagicode.www.bagilogindesign;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.bagicode.www.bagilogindesign.fragments.Student_Info;
import com.bagicode.www.bagilogindesign.fragments.Student_Logout;
import com.bagicode.www.bagilogindesign.fragments.View_Attendence;
import com.bagicode.www.bagilogindesign.fragments.View_My_Announcements;
import com.bagicode.www.bagilogindesign.fragments.View_My_Results;

import java.util.List;

import static com.bagicode.www.bagilogindesign.fragments.Student_Login_Activity.mStudentProduct;

public class Landing_Page_Activity extends AppCompatActivity implements Fragment_Drawer.OnDrawerListener{

    Fragment_Drawer drawerFragment;
    TextView tx0,tx2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        Intent intent = getIntent();
        //intent.getStringExtra("test");
        setContentView(R.layout.ac_landing_page);
        setTitle("");
        tx0 = (TextView) findViewById(R.id.text2);
        tx0.setText(mStudentProduct.getFullname());
        tx2 = (TextView) findViewById(R.id.text3);
        tx2.setText(mStudentProduct.getUsnno());

        // assert getSupportActionBar() != null;   //null check
       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        drawerFragment = (Fragment_Drawer) getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        drawerFragment.setOnDrawerListener(this);

    }

    public void switchFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment, fragment.getClass().getSimpleName());
        fragmentTransaction.commit();
    }

    @Override
    public void onDrawerItemClick(String menu, int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = Student_Info.newInstance();
                break;
            case 1:
                fragment = View_Attendence.getInstance("Attendance");
                break;
            case 2:
                fragment = View_My_Results.newInstance();
                break;
            case 3:
                fragment=View_My_Announcements.newInstance();
                break;
            default:
                fragment =Student_Logout.newInstance();
                break;
        }
        switchFragment(fragment);
    }
}
