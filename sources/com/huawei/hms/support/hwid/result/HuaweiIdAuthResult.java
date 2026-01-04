package com.huawei.hms.support.hwid.result;

import android.text.TextUtils;
import com.huawei.hms.support.api.entity.common.CommonPickerConstant;
import com.huawei.hms.support.feature.result.AbstractAuthResult;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class HuaweiIdAuthResult extends AbstractAuthResult {
    private AuthHuaweiId authHuaweiId;

    public HuaweiIdAuthResult fromJson(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return this;
        }
        JSONObject jSONObject = new JSONObject(str);
        jsonToSuper(jSONObject);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(CommonPickerConstant.RequestParams.KEY_SIGN_IN_HUAWEI_ID);
        if (jSONObjectOptJSONObject != null) {
            this.authHuaweiId = AuthHuaweiId.fromJson(jSONObjectOptJSONObject);
        }
        return this;
    }

    public AuthHuaweiId getHuaweiId() {
        return this.authHuaweiId;
    }

    public void setAuthHuaweiId(AuthHuaweiId authHuaweiId) {
        this.authHuaweiId = authHuaweiId;
    }

    public String toJson() throws JSONException {
        return toJsonObject().toString();
    }

    public JSONObject toJsonObject() throws JSONException {
        JSONObject jSONObjectSuperToJson = superToJson();
        AuthHuaweiId authHuaweiId = this.authHuaweiId;
        if (authHuaweiId != null) {
            jSONObjectSuperToJson.put(CommonPickerConstant.RequestParams.KEY_SIGN_IN_HUAWEI_ID, authHuaweiId.toJsonObject());
        }
        return jSONObjectSuperToJson;
    }
}
