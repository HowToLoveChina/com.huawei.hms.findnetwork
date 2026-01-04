package com.huawei.hms.support.picker.result;

import android.text.TextUtils;
import com.huawei.hms.support.api.entity.common.CommonPickerConstant;
import com.huawei.hms.support.feature.result.AbstractPickerAuthResult;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class AccountPickerResult extends AbstractPickerAuthResult {
    private static Map<Integer, Integer> errorCodeMap;
    private AuthAccountPicker authHuaweiId;

    static {
        HashMap map = new HashMap();
        errorCodeMap = map;
        map.put(6, 2012);
        errorCodeMap.put(404, 2015);
    }

    public AccountPickerResult fromJson(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return this;
        }
        JSONObject jSONObject = new JSONObject(str);
        jsonToSuper(errorCodeMap, jSONObject);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(CommonPickerConstant.RequestParams.KEY_SIGN_IN_HUAWEI_ID);
        if (jSONObjectOptJSONObject != null) {
            this.authHuaweiId = AuthAccountPicker.fromJson(jSONObjectOptJSONObject);
        }
        return this;
    }

    public AuthAccountPicker getAuthAccountPicker() {
        return this.authHuaweiId;
    }

    public void setAuthAccountPicker(AuthAccountPicker authAccountPicker) {
        this.authHuaweiId = authAccountPicker;
    }

    public String toJson() throws JSONException {
        JSONObject jSONObjectSuperToJson = superToJson();
        AuthAccountPicker authAccountPicker = this.authHuaweiId;
        if (authAccountPicker != null) {
            jSONObjectSuperToJson.put(CommonPickerConstant.RequestParams.KEY_SIGN_IN_HUAWEI_ID, authAccountPicker.toJsonObject());
        }
        return jSONObjectSuperToJson.toString();
    }
}
