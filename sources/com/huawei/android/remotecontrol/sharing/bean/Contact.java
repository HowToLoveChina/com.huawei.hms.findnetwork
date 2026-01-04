package com.huawei.android.remotecontrol.sharing.bean;

/* loaded from: classes4.dex */
public class Contact {
    private String mId;
    private String mName;
    private String mNumber;

    public Contact() {
        this.mId = "";
        this.mName = "";
        this.mNumber = "";
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public String getNumber() {
        return this.mNumber;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setNumber(String str) {
        this.mNumber = str;
    }

    public Contact(String str, String str2, String str3) {
        this.mId = str;
        this.mName = str2;
        this.mNumber = str3;
    }
}
