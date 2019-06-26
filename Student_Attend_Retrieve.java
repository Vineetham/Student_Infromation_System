package com.bagicode.www.bagilogindesign;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bagicode.www.bagilogindesign.fragments.Student_Info;
import com.bagicode.www.bagilogindesign.fragments.View_Attendence;
import com.bagicode.www.bagilogindesign.fragments.View_My_Results;


import static android.graphics.drawable.ClipDrawable.VERTICAL;
import static com.bagicode.www.bagilogindesign.fragments.Student_Login_Activity.mStudentProduct;

public  class Student_Attend_Retrieve extends AppCompatActivity implements Fragment_Drawer.OnDrawerListener{
    Fragment_Drawer drawerFragment;
    //this is the JSON Data URL
    //make sure you are using the correct ip else it will not work
   // private static final String URL_PRODUCTS="http://192.168.1.105/merit/attendretrieve.php";

    //a list to store all the products
    //public  ArrayList<Student_Attend_Product>  mStudentAttendProductList ;
    int cid;
    //List<Student_Attend_Product> productList;

    //the recyclerview
    RecyclerView recyclerView;
    private ListView rtr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        setContentView(R.layout.student_attend_retrieve);
        // mStudentAttendProductList = new ArrayList<>();

        //getting the recyclerview from xml
        recyclerView = findViewById(R.id.list1);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //     rtr = findViewById(R.id.list1);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));
        recyclerView.setLayoutManager(linearLayoutManager);


        String URL_PRODUCTS="http://192.168.1.107/integrate/studentreport.php";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_PRODUCTS,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject JObject= null;
                        try {
                            JObject=new JSONObject(response);
                            Toast.makeText(Student_Attend_Retrieve.this, response, Toast.LENGTH_SHORT).show();
                            //JsonArray array = new JSONArray(response);
                            JSONArray subcode = JObject.getJSONArray("subcode");
                            ArrayList<String> subcodeList = new ArrayList();
                            for (int i = 0; i < subcode.length(); i++) {
                                subcodeList.add(subcode.getString(i));

                            }
                            JSONArray class_held = JObject.getJSONArray("class_held");
                            ArrayList<Integer> classheldList = new ArrayList();
                            for (int i = 0; i < class_held.length(); i++) {
                                classheldList.add(class_held.getInt(i));

                            }
                            JSONArray class_attended = JObject.getJSONArray("class_attended");
                            ArrayList<Integer> classattendList = new ArrayList();
                            for (int i = 0; i < class_attended.length(); i++) {
                                classattendList.add(class_attended.getInt(i));

                            }
                            JSONArray perc = JObject.getJSONArray("perc");
                            ArrayList<Integer> classperc = new ArrayList();
                            for (int i = 0; i < perc.length(); i++) {
                                classperc.add(perc.getInt(i));

                            }

                            ArrayList<Attendance_Info> attendance_infoArrayList = new ArrayList<>();
                            for(int i = 0;i<perc.length();i++){
                                attendance_infoArrayList.add(new Attendance_Info(subcodeList.get(i),classattendList.get(i),classheldList.get(i),classperc.get(i)));
                            }
                            Student_Report_Adapter adapter = new Student_Report_Adapter(Student_Attend_Retrieve.this, attendance_infoArrayList);
                            recyclerView.setAdapter(adapter);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.print("error");
                    }
                }) {
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
            //    params.put("branch",mStudentProduct.getBranch() );
                params.put("semester1",mStudentProduct.getSemester());
                params.put("section1",mStudentProduct.getSection());
                return params;
            }
        };

        Volley.newRequestQueue(Student_Attend_Retrieve.this).
                add(stringRequest);
        //initializing the productlist`11
       // productList = new ArrayList<>();


        //this method will fetch and parse json
        //to display it in recyclerview

        Toolbar mToolbar = findViewById(R.id.toolbar);
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
            default:
                fragment = View_My_Results.newInstance();
                break;
        }
        switchFragment(fragment);
    }




}