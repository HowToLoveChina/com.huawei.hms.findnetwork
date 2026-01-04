package com.huawei.hms.support.api.hwid;

import android.text.TextUtils;
import com.huawei.android.backup.service.logic.C2126b;
import com.huawei.hms.identity.AddressConstants;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.feature.result.AccountPickerCommonConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class RevokeAccessResult extends Result {
    private static final String TAG = "[HUAWEIIDSDK]RevokeAccessResult";

    private void jsonToSuper(JSONObject jSONObject) {
        if (jSONObject.has(AddressConstants.Extras.EXTRA_NAME_ERR_CODE)) {
            setStatus(new Status(jSONObject.optInt(AddressConstants.Extras.EXTRA_NAME_ERR_CODE), jSONObject.has(C2126b.ERROR_MESSAGE_INFO) ? jSONObject.optString(C2126b.ERROR_MESSAGE_INFO) : ""));
            return;
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("status");
        if (jSONObjectOptJSONObject != null) {
            setStatus(new Status(jSONObjectOptJSONObject.optInt("statusCode"), jSONObjectOptJSONObject.optString(AccountPickerCommonConstant.KEY_STATUS_MESSAGE, null)));
        }
    }

    public RevokeAccessResult fromJson(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return this;
        }
        jsonToSuper(new JSONObject(str));
        return this;
    }

    public boolean isSuccess() {
        return getStatus().isSuccess();
    }
}
