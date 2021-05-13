package com.example.autumn.Adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class BottomBarAdapter extends FragmentPagerAdapter
{
    private String[] mTitles;
    private ArrayList<Fragment> mFragments;
    public BottomBarAdapter(FragmentManager fm, String myTitle[], ArrayList<Fragment>fragments)
    {
        super(fm);
        this.mTitles=myTitle;
        this.mFragments=fragments;
    }
    public int getCount()
    {
        return mFragments.size();
    }
    public CharSequence getPageTitle(int position)
    {
        return mTitles[position];
    }
    public Fragment getItem(int position)
    {
        return mFragments.get(position);
    }
}