package com.huawei.hms.support.api.entity.sns.internal;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.api.entity.sns.UserData;

/* loaded from: classes8.dex */
public class UserDataResp implements IMessageEntity {

    @Packed
    UserData userData;

    public UserData getUserData() {
        return this.userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }
}
