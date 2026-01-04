package com.huawei.android.hicloud.album.service.p075vo;

import java.util.HashMap;

/* loaded from: classes2.dex */
public class GetUploadUrlPlv3 {
    private String clientIp;
    private String cmd;
    private String host;
    private HashMap<String, String> mapUrlHeaders;
    private HashMap<String, String> mapUrlParams;
    private String method;
    private String objectId;

    public String getClientIp() {
        return this.clientIp;
    }

    public String getCmd() {
        return this.cmd;
    }

    public String getHost() {
        return this.host;
    }

    public HashMap<String, String> getMapUrlHeaders() {
        return this.mapUrlHeaders;
    }

    public HashMap<String, String> getMapUrlParams() {
        return this.mapUrlParams;
    }

    public String getMethod() {
        return this.method;
    }

    public String getObjectId() {
        return this.objectId;
    }

    public void setClientIp(String str) {
        this.clientIp = str;
    }

    public void setCmd(String str) {
        this.cmd = str;
    }

    public void setHost(String str) {
        this.host = str;
    }

    public void setMapUrlHeaders(HashMap<String, String> map) {
        this.mapUrlHeaders = map;
    }

    public void setMapUrlParams(HashMap<String, String> map) {
        this.mapUrlParams = map;
    }

    public void setMethod(String str) {
        this.method = str;
    }

    public void setObjectId(String str) {
        this.objectId = str;
    }
}
