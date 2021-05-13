package com.example.autumn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import android.content.SharedPreferences;
import android.os.Bundle;
import java.util.ArrayList;
import com.example.autumn.Adapter.BottomBarAdapter;
import com.example.autumn.Entity.BottomBarEntity;
import com.example.autumn.Fragment.MineFragment;
import com.example.autumn.Fragment.HomeFragment;
import com.example.autumn.Fragment.BusFragment;
import com.example.autumn.Fragment.QiuYuFragment;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
public class MainActivity extends AppCompatActivity {
    private String mTitles[]={"首页","秋语","购物车","我的"};
    private ArrayList<Fragment> fragments = new ArrayList<>();
    //底部导航栏的布局
    private CommonTabLayout commonTabLayout;
    private ViewPager viewPager;
    //底部导航栏没被选中时的图标
    private int pic_unselected[]={R.mipmap.home_noselected,R.mipmap.qiuyu_noselected,R.mipmap.bus_noselected,
            R.mipmap.mine_noselected};
    //底部导航栏被选中时的图标
    private  int pic_selected[]={R.mipmap.home_selected,R.mipmap.qiuyu_selected,R.mipmap.bus_selected,
            R.mipmap.mine_selected};
    private ArrayList<CustomTabEntity> customTabEntities=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        for(int i=0 ; i<mTitles.length ; i++)
        {
            customTabEntities.add(new BottomBarEntity(pic_selected[i],pic_unselected[i],mTitles[i]));
        }
        fragments.add(HomeFragment.newInstance());
        fragments.add(QiuYuFragment.newInstance());
        fragments.add(BusFragment.newInstance());
        fragments.add(MineFragment.newInstance());

        commonTabLayout.setTabData(customTabEntities);/*设置底部导航栏数据*/
        /**
         * 给底部设置选中监听
         */
        commonTabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                SharedPreferences.Editor editor = getSharedPreferences("home_tab_id",MODE_PRIVATE).edit();
                editor.putInt("now_pos",position);
                editor.commit();
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });
        viewPager.setOffscreenPageLimit(fragments.size());
        //添加界面改变监听器
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            @Override
            public void onPageSelected(int position) {
                commonTabLayout.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewPager.setAdapter(new BottomBarAdapter(getSupportFragmentManager(),mTitles,fragments));

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    public void initView()
    {
        commonTabLayout=(CommonTabLayout) findViewById(R.id.bottom_bar);
        viewPager=(ViewPager) findViewById(R.id.viewpager);
    }

    public void onResume()
    {
        super.onResume();
        SharedPreferences sharedPreferences = getSharedPreferences("home_tab_id",MODE_PRIVATE);
        int position = sharedPreferences.getInt("now_pos",0);
        viewPager.setCurrentItem(position);
        commonTabLayout.setCurrentTab(position);
    }
}