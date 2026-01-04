package com.huawei.hicloud.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.hms.support.api.entity.common.CommonConstant;

/* loaded from: classes6.dex */
public class EntryQuestBean {

    /* renamed from: id */
    @SerializedName("id")
    private String f22230id;

    @SerializedName(CommonConstant.ReqAccessTokenParam.STATE_LABEL)
    private int state;

    public String getId() {
        return this.f22230id;
    }

    public int getState() {
        return this.state;
    }

    public void setId(String str) {
        this.f22230id = str;
    }

    public void setState(int i10) {
        this.state = i10;
    }
}
