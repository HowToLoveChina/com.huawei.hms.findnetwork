package com.huawei.hicloud.request.opengw.bean;

/* loaded from: classes6.dex */
public class QuRequest {
    private String cursor;
    private String[] fields;
    private String[] paths;
    private int type;

    public String getCursor() {
        return this.cursor;
    }

    public String[] getFields() {
        return this.fields;
    }

    public String[] getPaths() {
        return this.paths;
    }

    public int getType() {
        return this.type;
    }

    public void setCursor(String str) {
        this.cursor = str;
    }

    public void setFields(String[] strArr) {
        this.fields = strArr;
    }

    public void setPaths(String[] strArr) {
        this.paths = strArr;
    }

    public void setType(int i10) {
        this.type = i10;
    }
}
