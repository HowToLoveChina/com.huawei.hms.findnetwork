package com.huawei.feedback.mail.bean;

/* loaded from: classes5.dex */
public class AppLog {
    private String level;
    private String msg;
    private String tag;

    public AppLog(String str, String str2, String str3) {
        this.level = str;
        this.tag = str2;
        this.msg = str3;
    }

    public String getLevel() {
        return this.level;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getTag() {
        return this.tag;
    }

    public void setLevel(String str) {
        this.level = str;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setTag(String str) {
        this.tag = str;
    }

    public AppLog() {
    }
}
