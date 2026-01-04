package com.huawei.cloud.pay.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: classes5.dex */
public class DlTask implements Serializable {
    private static final long serialVersionUID = -3224500083173199915L;

    @SerializedName("enabled")
    private int enabled;

    @SerializedName("quota")
    private int quota;

    @SerializedName("tid")
    private String tid;

    public int getEnabled() {
        return this.enabled;
    }

    public int getQuota() {
        return this.quota;
    }

    public String getTid() {
        return this.tid;
    }

    public void setEnabled(int i10) {
        this.enabled = i10;
    }

    public void setQuota(int i10) {
        this.quota = i10;
    }

    public void setTid(String str) {
        this.tid = str;
    }
}
