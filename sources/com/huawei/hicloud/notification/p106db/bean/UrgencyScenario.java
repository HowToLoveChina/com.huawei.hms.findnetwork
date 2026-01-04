package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* loaded from: classes6.dex */
public class UrgencyScenario {
    private String errorScenarioIdSingle;

    @SerializedName("errorScenarioIds")
    private List<String> errorScenarioIds;

    /* renamed from: id */
    @SerializedName("id")
    private String f22664id;
    private String policyId;

    @SerializedName("userStatus")
    private List<String> userStatus;
    private String userStatusSingle;

    public String getErrorScenarioIdSingle() {
        return this.errorScenarioIdSingle;
    }

    public List<String> getErrorScenarioIds() {
        return this.errorScenarioIds;
    }

    public String getId() {
        return this.f22664id;
    }

    public String getPolicyId() {
        return this.policyId;
    }

    public List<String> getUserStatus() {
        return this.userStatus;
    }

    public String getUserStatusSingle() {
        return this.userStatusSingle;
    }

    public void setErrorScenarioIdSingle(String str) {
        this.errorScenarioIdSingle = str;
    }

    public void setErrorScenarioIds(List<String> list) {
        this.errorScenarioIds = list;
    }

    public void setId(String str) {
        this.f22664id = str;
    }

    public void setPolicyId(String str) {
        this.policyId = str;
    }

    public void setUserStatus(List<String> list) {
        this.userStatus = list;
    }

    public void setUserStatusSingle(String str) {
        this.userStatusSingle = str;
    }
}
