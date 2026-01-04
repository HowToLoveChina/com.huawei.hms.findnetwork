package com.huawei.hms.support.api.sns;

import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.entity.sns.UserData;

/* loaded from: classes8.dex */
public class UserDataResult extends Result {
    private UserData userData;

    public UserData getUserData() {
        return this.userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }
}
