package com.study.teamspkt.worldnews;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.study.teamspkt.worldnews.Activity_Fragment.BottomSheetDialogFragment;
import com.study.teamspkt.worldnews.Activity_Fragment.Hot_Fragment;
import com.study.teamspkt.worldnews.Activity_Fragment.New_Fragment;
import com.study.teamspkt.worldnews.Adapters.MyFragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, ViewPager.OnPageChangeListener,TabHost.OnTabChangeListener {

    private String itemsdreawer[]={"Điện ảnh","Xã hội","Fashion","Thế Giới","Đời Sống","Music","Sport","Sức khỏe","Giáo dục","Khám phá"
    ,"Điện ảnh","Xã hội","Fashion","Thế Giới","Đời Sống","Music","Sport","Sức khỏe","Giáo dục","Khám phá"
    ,"Điện ảnh","Xã hội","Fashion","Thế Giới","Đời Sống","Music","Sport","Sức khỏe","Giáo dục","Khám phá"
    ,"Điện ảnh","Xã hội","Fashion","Thế Giới","Đời Sống","Music","Sport","Sức khỏe","Giáo dục","Khám phá"
    ,"Điện ảnh","Xã hội","Fashion","Thế Giới","Đời Sống","Music","Sport","Sức khỏe","Giáo dục","Khám phá"
    ,"Điện ảnh","Xã hội","Fashion","Thế Giới","Đời Sống","Music","Sport","Sức khỏe","Giáo dục","Khám phá"
    ,"Điện ảnh","Xã hội","Fashion","Thế Giới","Đời Sống","Music","Sport","Sức khỏe","Giáo dục","Khám phá"
    ,"Điện ảnh","Xã hội","Fashion","Thế Giới","Đời Sống","Music","Sport","Sức khỏe","Giáo dục","Khám phá"
    ,"Điện ảnh","Xã hội","Fashion","Thế Giới","Đời Sống","Music","Sport","Sức khỏe","Giáo dục","Khám phá"};
    private ListView listViewDrawer;
    private ListView listViewTest;



    Fragment hot_fragment = new Hot_Fragment();
    Fragment new_fragment= new New_Fragment();
    List<Fragment> fragmentList;
    MyFragmentPagerAdapter myFragmentPagerAdapter;

    TabHost tabHost;
    ViewPager viewPager;

    ImageButton imageButtonPlus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        /*NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);*/

        listViewDrawer=(ListView)findViewById(R.id.listViewDrawer);
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,itemsdreawer);

        //header
        View headerDrawer = LayoutInflater.from(this).inflate(R.layout.nav_header_main,null);

        //listViewDrawer.addHeaderView(headerDrawer);
        listViewDrawer.setAdapter(stringArrayAdapter);
        listViewDrawer.setOnItemClickListener(this);

        /*listViewTest=(ListView)findViewById(R.id.listViewTest);
        listViewTest.setAdapter(stringArrayAdapter);*/
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        ///tạo list pager
        fragmentList = new ArrayList<>();
        fragmentList.add(hot_fragment);
        fragmentList.add(new_fragment);
        myFragmentPagerAdapter = new MyFragmentPagerAdapter(
                getSupportFragmentManager(),fragmentList);
        //tạo viewpager
        initViewPager();
        //tạo tabhot
        inittabhot();
        //show Dialog khi nhấp ic dấu "+"
        initBottomSheetDialog();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }*/


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return;
    }
/*
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }*/


    //tạo viewpager
    private void initViewPager()
    {
        viewPager = (ViewPager) findViewById(R.id.home_view_pager);

        //đưa list payger vào viewpayger
        viewPager.setAdapter(myFragmentPagerAdapter);
        //băt sự kiện trượt viewpager
        viewPager.addOnPageChangeListener(this);

    }
    //tạo tabhost
    private void inittabhot()
    {
        tabHost = (TabHost)findViewById(R.id.tabhost);
        tabHost.setup();
        //tạo số lượng và tên tabhot
        String[] tabnames = {"",""};
        for(String t:tabnames){
            TabHost.TabSpec tabSpec;
            tabSpec = tabHost.newTabSpec(t);
            // tabSpec.setIndicator(tabnames[i]);
            tabSpec.setContent(new FakeContent(this));
            TextView tv = new TextView(this);
            tv.setWidth(200);
            tv.setHeight(200);
            tv.setTextSize(11);
            tabSpec.setIndicator(tv);
            tabHost.addTab(tabSpec);
        }
        //bắt sự kiện click thay đổi tab
        tabHost.setOnTabChangedListener(this);
    }
    //thiết lập tab của viewpager để trượt qua
    public class FakeContent implements TabHost.TabContentFactory{
        Context context;
        public FakeContent(Context mcontext){
            context=mcontext;
        }

        @Override
        public View createTabContent(String tag) {
            View fakeview = new View(context);
            fakeview.setMinimumHeight(0);
            fakeview.setMinimumWidth(0);
            return fakeview;
        }
    }
    /*
        Viewpager listener
     */

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }
    //khi trượt thay đổi trang hiện tại của viewpager thì tab hiện tại của tabhot cũng thay đổi theo
    @Override
    public void onPageSelected(int position) {
        tabHost.setCurrentTab(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
    /*
            Tabhost listener
            bắt sự kiện thay đổi tab
         */
    @Override
    public void onTabChanged(String tabId) {
        TextView textViewNew = (TextView) findViewById(R.id.textViewNew);
        TextView textViewHot = (TextView)findViewById(R.id.textViewHot);

        int selectedPage = tabHost.getCurrentTab();
        //sét các màu của tab widget
        if(selectedPage==0) {
            textViewHot.setBackgroundResource(R.drawable.tabs_pressed_left);
            textViewHot.setTextColor(getResources().getColor(R.color.textcolor_selected));

            textViewNew.setBackgroundResource(R.drawable.tabs_normal_right);
            textViewNew.setTextColor(getResources().getColor(R.color.white));
        }else{
            textViewHot.setBackgroundResource(R.drawable.tabs_normal_left);
            textViewHot.setTextColor(getResources().getColor(R.color.white));

            textViewNew.setBackgroundResource(R.drawable.tabs_pressed_right);
            textViewNew.setTextColor(getResources().getColor(R.color.textcolor_selected));
        }
        viewPager.setCurrentItem(selectedPage);
    }

    //tạo Diaglog ic dấu "+"
    public void initBottomSheetDialog(){
        imageButtonPlus = (ImageButton)findViewById(R.id.imageButtonPlus);
        final BottomSheetDialogFragment bottomSheetDialogFragment = new BottomSheetDialogFragment();
        imageButtonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetDialogFragment.show(getSupportFragmentManager(),bottomSheetDialogFragment.getTag());
            }
        });
        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View v = layoutInflater.inflate(R.layout.plus_menu,null);
        LinearLayout linearLayout = (LinearLayout) v.findViewById(R.id.linearLayout_FilterbyDate);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "clicked", Toast.LENGTH_SHORT).show();
                bottomSheetDialogFragment.dismiss();
            }
        });
    }
}
