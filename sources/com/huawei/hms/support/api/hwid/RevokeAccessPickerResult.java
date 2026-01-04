package com.huawei.hms.support.api.hwid;

import android.text.TextUtils;
import com.huawei.android.backup.service.logic.C2126b;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.identity.AddressConstants;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.feature.result.AccountPickerCommonConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class RevokeAccessPickerResult extends Result {

    @Packed
    private Integer mErrorCode;

    @Packed
    private String mErrorMsg;

    public RevokeAccessPickerResult() {
    }

    private void jsonToSuper(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("status");
        if (jSONObjectOptJSONObject != null) {
            setStatus(new Status(jSONObjectOptJSONObject.optInt("statusCode"), jSONObjectOptJSONObject.optString(AccountPickerCommonConstant.KEY_STATUS_MESSAGE, null)));
        }
    }

    public RevokeAccessPickerResult fromJson(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return this;
        }
        jsonToSuper(new JSONObject(str));
        return this;
    }

    public RevokeAccessPickerResult getBeanFromJsonStr(String str) {
        if (TextUtils.isEmpty(str)) {
            return new RevokeAccessPickerResult();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new RevokeAccessPickerResult(jSONObject.has(AddressConstants.Extras.EXTRA_NAME_ERR_CODE) ? Integer.valueOf(jSONObject.getInt(AddressConstants.Extras.EXTRA_NAME_ERR_CODE)) : null, jSONObject.getString(C2126b.ERROR_MESSAGE_INFO));
        } catch (JSONException unused) {
            return new RevokeAccessPickerResult();
        }
    }

    public Integer getErrorCode() {
        return this.mErrorCode;
    }

    public String getErrorMsg() {
        return this.mErrorMsg;
    }

    public boolean isSuccess() {
        return getStatus().isSuccess();
    }

    public void setErrorCode(Integer num) {
        this.mErrorCode = num;
    }

    public void setErrorMsg(String str) {
        this.mErrorMsg = str;
    }

    public RevokeAccessPickerResult(Integer num, String str) {
        this.mErrorCode = num;
        this.mErrorMsg = str;
    }

    public RevokeAccessPickerResult(Status status) {
        setStatus(status);
    }
}
