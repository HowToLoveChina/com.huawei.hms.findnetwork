package com.huawei.hicloud.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: classes6.dex */
public class DataTypeNum implements Serializable {
    private static final long serialVersionUID = 8080518179846408021L;

    @SerializedName("status")
    private int status;

    @SerializedName("sumNum")
    private long sumNum;

    public int getStatus() {
        return this.status;
    }

    public long getSumNum() {
        return this.sumNum;
    }

    public void setStatus(int i10) {
        this.status = i10;
    }

    public void setSumNum(long j10) {
        this.sumNum = j10;
    }
}
