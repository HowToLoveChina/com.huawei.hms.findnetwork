package com.huawei.hicloud.request.opengw.bean;

/* loaded from: classes6.dex */
public class LsRequest {
    private String[] fields;
    private int recursive;
    private String serverPath;
    private String[] serverPaths;
    private int type;

    public String[] getFields() {
        String[] strArr = this.fields;
        return strArr == null ? new String[0] : (String[]) strArr.clone();
    }

    public int getRecursive() {
        return this.recursive;
    }

    public String getServerPath() {
        return this.serverPath;
    }

    public String[] getServerPaths() {
        String[] strArr = this.serverPaths;
        return strArr == null ? new String[0] : (String[]) strArr.clone();
    }

    public int getType() {
        return this.type;
    }

    public void setFields(String[] strArr) {
        if (strArr != null) {
            this.fields = (String[]) strArr.clone();
        } else {
            this.fields = null;
        }
    }

    public void setRecursive(int i10) {
        this.recursive = i10;
    }

    public void setServerPath(String str) {
        this.serverPath = str;
    }

    public void setServerPaths(String[] strArr) {
        if (strArr != null) {
            this.serverPaths = (String[]) strArr.clone();
        } else {
            this.serverPaths = null;
        }
    }

    public void setType(int i10) {
        this.type = i10;
    }
}
