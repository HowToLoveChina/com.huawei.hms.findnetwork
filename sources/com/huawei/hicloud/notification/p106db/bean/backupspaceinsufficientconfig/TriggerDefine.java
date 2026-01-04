package com.huawei.hicloud.notification.p106db.bean.backupspaceinsufficientconfig;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* loaded from: classes6.dex */
public class TriggerDefine {

    @SerializedName("params")
    private List<String> params;

    @SerializedName("realtimeParams")
    private List<String> realtimeParams;

    @SerializedName("trigger")
    private String trigger;

    public List<String> getParams() {
        return this.params;
    }

    public List<String> getRealtimeParams() {
        return this.realtimeParams;
    }

    public String getTrigger() {
        return this.trigger;
    }

    public void setParams(List<String> list) {
        this.params = list;
    }

    public void setRealtimeParams(List<String> list) {
        this.realtimeParams = list;
    }

    public void setTrigger(String str) {
        this.trigger = str;
    }
}
