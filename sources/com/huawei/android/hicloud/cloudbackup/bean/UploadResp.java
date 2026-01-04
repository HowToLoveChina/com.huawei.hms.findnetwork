package com.huawei.android.hicloud.cloudbackup.bean;

import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes2.dex */
public class UploadResp {
    private String fid;
    private String fsize;
    private Map<String, Object> params = new TreeMap();
    private String path;
    private String server;
    private String sig;

    /* renamed from: ts */
    private String f11661ts;

    private <T> T commonSetFunction(T t10) {
        if (t10 == null) {
            return null;
        }
        return t10;
    }

    public String getFid() {
        return (String) commonSetFunction(this.fid);
    }

    public String getFsize() {
        return (String) commonSetFunction(this.fsize);
    }

    public Map<String, Object> getParams() {
        return (Map) commonSetFunction(this.params);
    }

    public String getPath() {
        return (String) commonSetFunction(this.path);
    }

    public String getServer() {
        return (String) commonSetFunction(this.server);
    }

    public String getSig() {
        return (String) commonSetFunction(this.sig);
    }

    public String getTs() {
        return (String) commonSetFunction(this.f11661ts);
    }

    public void setFid(String str) {
        this.fid = (String) commonSetFunction(str);
    }

    public void setFsize(String str) {
        this.fsize = (String) commonSetFunction(str);
    }

    public void setParams(Map<String, Object> map) {
        this.params = (Map) commonSetFunction(map);
    }

    public void setPath(String str) {
        this.path = (String) commonSetFunction(str);
    }

    public void setServer(String str) {
        this.server = (String) commonSetFunction(str);
    }

    public void setSig(String str) {
        this.sig = (String) commonSetFunction(str);
    }

    public void setTs(String str) {
        this.f11661ts = (String) commonSetFunction(str);
    }
}
