package com.huawei.hicloud.notification.p106db.bean;

/* loaded from: classes6.dex */
public class MainMenuItem {
    private boolean isEnabled = true;
    private boolean isShowRedDot = false;
    private String itemName;
    private int menuType;

    public MainMenuItem(String str, int i10) {
        this.itemName = str;
        this.menuType = i10;
    }

    public String getItemName() {
        return this.itemName;
    }

    public int getMenuType() {
        return this.menuType;
    }

    public boolean isEnabled() {
        return this.isEnabled;
    }

    public boolean isShowRedDot() {
        return this.isShowRedDot;
    }

    public void setEnabled(boolean z10) {
        this.isEnabled = z10;
    }

    public void setItemName(String str) {
        this.itemName = str;
    }

    public void setMenuType(int i10) {
        this.menuType = i10;
    }

    public void setShowRedDot(boolean z10) {
        this.isShowRedDot = z10;
    }
}
