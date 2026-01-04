package com.huawei.hms.support.api.entity.account;

import com.huawei.hms.core.aidl.IMessageEntity;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class AccountSignOutReq implements IMessageEntity {
    public String toJson() {
        return new JSONObject().toString();
    }
}
