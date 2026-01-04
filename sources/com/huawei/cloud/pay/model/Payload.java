package com.huawei.cloud.pay.model;

import java.io.Serializable;

/* loaded from: classes5.dex */
public class Payload implements Serializable {
    private static final long serialVersionUID = 3868041839370167074L;
    private String digest;
    private String preorderId;
    private Integer scheme;
    private String userId;

    public String getDigest() {
        return this.digest;
    }

    public String getPreorderId() {
        return this.preorderId;
    }

    public Integer getScheme() {
        return this.scheme;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setDigest(String str) {
        this.digest = str;
    }

    public void setPreorderId(String str) {
        this.preorderId = str;
    }

    public void setScheme(int i10) {
        this.scheme = Integer.valueOf(i10);
    }

    public void setUserId(String str) {
        this.userId = str;
    }
}
