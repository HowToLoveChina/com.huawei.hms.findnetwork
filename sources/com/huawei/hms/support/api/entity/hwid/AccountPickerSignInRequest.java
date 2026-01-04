package com.huawei.hms.support.api.entity.hwid;

import com.huawei.hms.support.picker.request.AccountPickerParams;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class AccountPickerSignInRequest {
    private AccountPickerParams accountPickerParams;

    public static AccountPickerSignInRequest fromJson(String str) throws JSONException {
        if (str == null) {
            return null;
        }
        return new AccountPickerSignInRequest().objectFromJson(new JSONObject(str));
    }

    public AccountPickerParams getAccountPickerParams() {
        return this.accountPickerParams;
    }

    public AccountPickerSignInRequest objectFromJson(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = jSONObject.getJSONObject("accountPickerSignInOptions");
        if (jSONObject2 != null) {
            this.accountPickerParams = AccountPickerParams.fromJsonObject(jSONObject2);
        }
        return this;
    }

    public void setAccountPickerParams(AccountPickerParams accountPickerParams) {
        this.accountPickerParams = accountPickerParams;
    }

    public String toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        AccountPickerParams accountPickerParams = this.accountPickerParams;
        if (accountPickerParams != null) {
            jSONObject.put("accountPickerSignInOptions", accountPickerParams.toJsonObject());
        }
        return jSONObject.toString();
    }
}
