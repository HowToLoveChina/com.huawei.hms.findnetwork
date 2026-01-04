package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* loaded from: classes6.dex */
public class NotifyBlackList {

    /* renamed from: id */
    @SerializedName("id")
    private String f22655id;

    @SerializedName("msgTypes")
    private List<String> msgTypes;

    @SerializedName("userGroupIds")
    private List<String> userGroupIds;

    public String getId() {
        return this.f22655id;
    }

    public List<String> getMsgTypes() {
        return this.msgTypes;
    }

    public List<String> getUserGroupIds() {
        return this.userGroupIds;
    }

    public void setId(String str) {
        this.f22655id = str;
    }

    public void setMsgTypes(List<String> list) {
        this.msgTypes = list;
    }

    public void setUserGroupIds(List<String> list) {
        this.userGroupIds = list;
    }
}
