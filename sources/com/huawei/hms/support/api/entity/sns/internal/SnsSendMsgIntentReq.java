package com.huawei.hms.support.api.entity.sns.internal;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.api.entity.sns.SnsMsg;
import com.huawei.hms.utils.JsonUtil;

/* loaded from: classes8.dex */
public class SnsSendMsgIntentReq implements IMessageEntity {

    @Packed
    private String callerPackageName;

    @Packed
    private boolean needResult;

    @Packed
    private SnsMsg snsMsg;

    public String getCallerPackageName() {
        return this.callerPackageName;
    }

    public SnsMsg getSnsMsg() {
        return this.snsMsg;
    }

    public boolean isNeedResult() {
        return this.needResult;
    }

    public void setCallerPackageName(String str) {
        this.callerPackageName = str;
    }

    public void setNeedResult(boolean z10) {
        this.needResult = z10;
    }

    public void setSnsMsg(SnsMsg snsMsg) {
        this.snsMsg = snsMsg;
    }

    public String toJsonString() {
        return JsonUtil.createJsonString(this);
    }
}
