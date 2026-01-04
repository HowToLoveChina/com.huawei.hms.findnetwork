package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* loaded from: classes6.dex */
public class NotifyBlackListConfig {

    @SerializedName("notifyBlackList")
    private List<NotifyBlackList> notifyBlackList;

    public List<NotifyBlackList> getNotifyBlackList() {
        return this.notifyBlackList;
    }

    public void setNotifyBlackList(List<NotifyBlackList> list) {
        this.notifyBlackList = list;
    }
}
