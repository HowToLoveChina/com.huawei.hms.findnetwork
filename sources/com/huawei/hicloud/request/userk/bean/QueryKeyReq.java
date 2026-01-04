package com.huawei.hicloud.request.userk.bean;

import com.huawei.hicloud.request.basic.bean.BasicBaseReq;

/* loaded from: classes6.dex */
public class QueryKeyReq extends BasicBaseReq {
    private int cmd;
    private int dataType;
    private int encryptVersion;
    private int keyType;
    private String publicKey;

    public QueryKeyReq(int i10, String str, int i11, int i12, String str2) {
        super(str);
        this.encryptVersion = 1;
        this.cmd = i10;
        this.dataType = i11;
        this.keyType = i12;
        this.publicKey = str2;
    }

    public int getCmd() {
        return this.cmd;
    }

    public int getDataType() {
        return this.dataType;
    }

    public int getKeyType() {
        return this.keyType;
    }

    public String getPublicKey() {
        return this.publicKey;
    }

    public void setCmd(int i10) {
        this.cmd = i10;
    }

    public void setDataType(int i10) {
        this.dataType = i10;
    }

    public void setKeyType(int i10) {
        this.keyType = i10;
    }

    public void setPublicKey(String str) {
        this.publicKey = str;
    }
}
