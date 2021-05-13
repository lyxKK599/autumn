package com.example.autumn.Entity;

import com.flyco.tablayout.listener.CustomTabEntity;

public class BottomBarEntity implements CustomTabEntity {
    private int selected_id;
    private int unselected_id;
    private String title;

    @Override
    public String getTabTitle() {
        return title;
    }

    public BottomBarEntity(int selected_id, int unselected_id, String title)
    {
        this.selected_id=selected_id;
        this.title=title;
        this.unselected_id=unselected_id;
    }
    @Override
    public int getTabSelectedIcon() {
        return selected_id;
    }

    @Override
    public int getTabUnselectedIcon() {
        return unselected_id;
    }
}
