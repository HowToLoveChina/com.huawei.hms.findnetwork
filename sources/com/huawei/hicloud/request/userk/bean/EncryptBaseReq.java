package com.huawei.hicloud.request.userk.bean;

import com.google.gson.Gson;

/* loaded from: classes6.dex */
public class EncryptBaseReq {
    public static final int CMD_QUERY_PUBLIC_KEY = 1;
    public static final int CMD_QUERY_TRUST_CIRCLE_USER_KEY = 3;
    public static final int CMD_QUERY_USER_KEY = 2;
    public static final String INFO_QUERY_PUBLIC_KEY = "QueryPublicKeyReq";
    public static final String INFO_QUERY_TRUST_CIRCLE_USER_KEY = "QueryTrustCircleUserKeyReq";
    public static final String INFO_QUERY_USER_KEY = "QueryUserKeyReq";
    public static final String TYPE_ECDH = "ECDH";
    public static final String TYPE_EC_256 = "EC_256";
    protected int cmd;
    protected String info;
    protected String type;

    public EncryptBaseReq() {
    }

    public int getCmd() {
        return this.cmd;
    }

    public String getInfo() {
        return this.info;
    }

    public String getType() {
        return this.type;
    }

    public void setCmd(int i10) {
        this.cmd = i10;
    }

    public void setInfo(String str) {
        this.info = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String toString() {
        return new Gson().toJson(this);
    }

    public EncryptBaseReq(int i10, String str, String str2) {
        this.cmd = i10;
        this.info = str;
        this.type = str2;
    }

    public EncryptBaseReq(int i10, String str) {
        this.cmd = i10;
        this.info = str;
    }
}
