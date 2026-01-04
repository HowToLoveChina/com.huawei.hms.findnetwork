package com.huawei.hicloud.request.opengw.bean;

/* loaded from: classes6.dex */
public class ObjectAttribute {
    private long length;
    private String name;

    public ObjectAttribute() {
    }

    public long getLength() {
        return this.length;
    }

    public String getName() {
        return this.name;
    }

    public void setLength(long j10) {
        this.length = j10;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String toString() {
        return "ObjectAttribute{name='" + this.name + "', length=" + this.length + '}';
    }

    public ObjectAttribute(String str, long j10) {
        this.name = str;
        this.length = j10;
    }
}
