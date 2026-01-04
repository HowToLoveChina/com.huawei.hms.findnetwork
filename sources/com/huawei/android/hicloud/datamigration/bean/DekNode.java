package com.huawei.android.hicloud.datamigration.bean;

import com.google.gson.Gson;
import java.util.Map;

/* loaded from: classes3.dex */
public class DekNode {
    private String dek;

    /* renamed from: iv */
    private String f12146iv;
    private String location;

    /* renamed from: pk */
    private Map<String, Object> f12147pk;

    public String getDek() {
        return this.dek;
    }

    public String getIv() {
        return this.f12146iv;
    }

    public String getLocation() {
        return this.location;
    }

    public Map<String, Object> getPk() {
        return this.f12147pk;
    }

    public void setDek(String str) {
        this.dek = str;
    }

    public void setIv(String str) {
        this.f12146iv = str;
    }

    public void setLocation(String str) {
        this.location = str;
    }

    public void setPk(Map<String, Object> map) {
        this.f12147pk = map;
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}
