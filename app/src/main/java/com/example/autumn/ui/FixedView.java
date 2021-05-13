package com.example.autumn.ui;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

public class FixedView extends ViewPager {
    public FixedView(@Nullable Context context)
    {
        super(context);
    }
    public FixedView(@Nullable Context context, @Nullable AttributeSet attrs)
    {
        super(context,attrs);
    }
    public void setCurrentItem(int item)
    {
        super.setCurrentItem(item,false);//false没有滑动效果
    }
}
