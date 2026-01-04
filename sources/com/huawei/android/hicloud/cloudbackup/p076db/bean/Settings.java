package com.huawei.android.hicloud.cloudbackup.p076db.bean;

/* loaded from: classes2.dex */
public class Settings {
    public static final String TYPE_CBSTATE = "2";
    public static final String TYPE_CYCLE = "1";
    public static final String TYPE_LIST = "3";
    private String name;
    private String type;
    private String value;

    public Settings() {
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public String getValue() {
        return this.value;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[name=");
        stringBuffer.append(this.name);
        stringBuffer.append(" , value=");
        stringBuffer.append(this.value);
        stringBuffer.append(" , type = ");
        stringBuffer.append(this.type);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public Settings(String str, String str2, String str3) {
        this.name = str;
        this.value = str2;
        this.type = str3;
    }
}
