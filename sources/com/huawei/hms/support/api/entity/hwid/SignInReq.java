package com.huawei.hms.support.api.entity.hwid;

import android.text.TextUtils;
import com.huawei.hms.common.internal.constant.AuthInternalPickerConstant;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.hwid.C5602as;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class SignInReq implements IMessageEntity {
    private static final String KEY_DYNAMIC_PERMISSIONS = "dynamicpermissions";
    private static final String KEY_SCOPES = "scopes";
    private static final String KEY_SDK_VERSION = "sdkVersion";
    protected static final String TAG = "[SignInReq]SignInReq";

    @Packed
    public String mLocalJsonObject;

    public SignInReq() {
    }

    private JSONObject getJsonObj() {
        if (this.mLocalJsonObject == null) {
            return null;
        }
        try {
            return new JSONObject(this.mLocalJsonObject);
        } catch (JSONException unused) {
            return null;
        }
    }

    public List<String> getPermissionInfos() throws JSONException {
        JSONObject jsonObj = getJsonObj();
        if (jsonObj == null) {
            return new ArrayList(0);
        }
        try {
            JSONArray jSONArray = jsonObj.getJSONArray(KEY_DYNAMIC_PERMISSIONS);
            if (jSONArray == null || jSONArray.length() <= 0) {
                return new ArrayList(0);
            }
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                arrayList.add(jSONArray.getString(i10));
            }
            return arrayList;
        } catch (JSONException unused) {
            return new ArrayList(0);
        }
    }

    public List<String> getScopes() throws JSONException {
        JSONObject jsonObj = getJsonObj();
        if (jsonObj == null) {
            return new ArrayList(0);
        }
        try {
            JSONArray jSONArray = jsonObj.getJSONArray(KEY_SCOPES);
            if (jSONArray == null || jSONArray.length() <= 0) {
                return new ArrayList(0);
            }
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                arrayList.add(jSONArray.getString(i10));
            }
            return arrayList;
        } catch (JSONException unused) {
            return new ArrayList(0);
        }
    }

    public String getSignInParams() {
        JSONObject jsonObj = getJsonObj();
        return jsonObj == null ? "" : jsonObj.optString("signInParams");
    }

    public SignInReq(Set<String> set, Set<String> set2) {
        this(set, set2, "");
    }

    public SignInReq(Set<String> set, Set<String> set2, String str) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        JSONArray jSONArray2 = new JSONArray();
        Iterator<String> it2 = set2.iterator();
        while (it2.hasNext()) {
            jSONArray2.put(it2.next());
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(KEY_SCOPES, jSONArray);
            jSONObject.put(KEY_DYNAMIC_PERMISSIONS, jSONArray2);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("signInParams", str);
            }
            jSONObject.put("sdkVersion", AuthInternalPickerConstant.HMS_SDK_VERSION);
            this.mLocalJsonObject = jSONObject.toString();
        } catch (JSONException unused) {
            C5602as.m32912d(TAG, "SignInReq JSONException", true);
            this.mLocalJsonObject = new JSONObject().toString();
        }
    }
}
