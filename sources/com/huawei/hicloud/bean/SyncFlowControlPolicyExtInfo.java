package com.huawei.hicloud.bean;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* loaded from: classes6.dex */
public class SyncFlowControlPolicyExtInfo {

    @SerializedName("randomFactor")
    private float randomFactor = 0.0f;

    @SerializedName("syncType")
    private String syncType;

    @SerializedName("3rdAppVers")
    private String thirdAppVers;

    @SerializedName("timePeriodList")
    private List<SyncFlowControlTime> timePeriodList;

    public float getRandomFactor() {
        return this.randomFactor;
    }

    public String getSyncType() {
        return this.syncType;
    }

    public String getThirdAppVers() {
        return this.thirdAppVers;
    }

    public List<SyncFlowControlTime> getTimePeriodList() {
        return this.timePeriodList;
    }

    public void setRandomFactor(float f10) {
        this.randomFactor = f10;
    }

    public void setSyncType(String str) {
        this.syncType = str;
    }

    public void setThirdAppVers(String str) {
        this.thirdAppVers = str;
    }

    public void setTimePeriodList(List<SyncFlowControlTime> list) {
        this.timePeriodList = list;
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}
