package com.huawei.hms.support.api.hwid;

import android.text.TextUtils;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.feature.result.AccountPickerCommonConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class AccountPickerSignOutResult extends Result {
    public AccountPickerSignOutResult fromJson(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return this;
        }
        jsonToSuper(new JSONObject(str));
        return this;
    }

    public boolean isSuccess() {
        return getStatus().isSuccess();
    }

    public void jsonToSuper(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("status");
        if (jSONObjectOptJSONObject != null) {
            setStatus(new Status(jSONObjectOptJSONObject.optInt("statusCode"), jSONObjectOptJSONObject.optString(AccountPickerCommonConstant.KEY_STATUS_MESSAGE, null)));
        }
    }
}
