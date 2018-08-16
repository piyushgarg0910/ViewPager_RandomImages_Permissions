package com.example.android.testproject;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class myViewPager extends FragmentPagerAdapter{

    private Context context;

    public myViewPager(Context con, FragmentManager fm) {
        super(fm);
        context = con;
    }

    // This determines the fragment for each tab
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new TabOne();
        } else {
            return new TabTwo();
        }
    }

    // This determines the number of tabs
    @Override
    public int getCount() {
        return 2;
    }

    // This determines the title for each tab
    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        switch (position) {
            case 0:
                return context.getString(R.string.Tab_One);
            case 1:
                return context.getString(R.string.Tab_Two);
            default:
                return null;
        }
    }
}