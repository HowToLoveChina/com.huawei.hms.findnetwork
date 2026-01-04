package com.huawei.hms.support.api.entity.tss.base;

import android.os.Bundle;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public abstract class BaseResp implements IMessageEntity {
    public static final String ERROR_REASON = "errorReason";
    public static final String RTN_CODE = "rtnCode";

    @Packed
    private String errorReason;

    @Packed
    private int rtnCode;

    public BaseResp() {
        this.rtnCode = 0;
    }

    public String getErrorReason() {
        return this.errorReason;
    }

    public int getRtnCode() {
        return this.rtnCode;
    }

    public void saveToBundle(Bundle bundle) {
        bundle.putInt(RTN_CODE, getRtnCode());
        bundle.putString("errorReason", getErrorReason());
    }

    public void setErrorReason(String str) {
        this.errorReason = str;
    }

    public void setFromBundle(Bundle bundle) {
        setRtnCode(bundle.getInt(RTN_CODE));
        setErrorReason(bundle.getString("errorReason"));
    }

    public void setRtnCode(int i10) {
        this.rtnCode = i10;
    }

    public String toJsonString() {
        return new JSONObject().toString();
    }

    public BaseResp(int i10, String str) {
        this.rtnCode = i10;
        this.errorReason = str;
    }
}
