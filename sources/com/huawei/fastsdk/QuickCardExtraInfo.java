package com.huawei.fastsdk;

import android.view.ContextMenu;
import android.view.View;

/* loaded from: classes5.dex */
public class QuickCardExtraInfo {
    private MenuInfo menuInfo;

    public static class MenuInfo {
        public View hostView;
        public ContextMenu menu;
        public ContextMenu.ContextMenuInfo menuInfo;
    }

    public static QuickCardExtraInfo getNewInstance() {
        return new QuickCardExtraInfo();
    }

    public MenuInfo getMenuInfo() {
        return this.menuInfo;
    }

    public void setMenuInfo(MenuInfo menuInfo) {
        this.menuInfo = menuInfo;
    }
}
