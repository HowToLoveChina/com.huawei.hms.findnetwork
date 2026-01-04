package com.huawei.android.hicloud.drive.clouddisk.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import ni.C11707b;

/* loaded from: classes3.dex */
public class User extends C11707b {

    @InterfaceC4648p
    private Integer realName;

    @InterfaceC4648p
    private Integer realNameLevel;

    @InterfaceC4648p
    private String userId;

    public Integer getRealName() {
        return this.realName;
    }

    public Integer getRealNameLevel() {
        return this.realNameLevel;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setRealName(Integer num) {
        this.realName = num;
    }

    public User setRealNameLevel(Integer num) {
        this.realNameLevel = num;
        return this;
    }

    public User setUserId(String str) {
        this.userId = str;
        return this;
    }
}
