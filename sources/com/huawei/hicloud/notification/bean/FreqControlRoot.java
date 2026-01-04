package com.huawei.hicloud.notification.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.android.hicloud.clouddisk.logic.calllogs.CallLogCons;

/* loaded from: classes6.dex */
public class FreqControlRoot {

    @SerializedName(CallLogCons.DATE)
    private String date;

    @SerializedName("frequencyControl")
    private FrequencyControl frequencyControl;

    /* renamed from: id */
    @SerializedName("id")
    private String f22624id;

    @SerializedName("version")
    private String version;

    public String getDate() {
        return this.date;
    }

    public FrequencyControl getFrequencyControl() {
        return this.frequencyControl;
    }

    public String getId() {
        return this.f22624id;
    }

    public String getVersion() {
        return this.version;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public void setFrequencyControl(FrequencyControl frequencyControl) {
        this.frequencyControl = frequencyControl;
    }

    public void setId(String str) {
        this.f22624id = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
