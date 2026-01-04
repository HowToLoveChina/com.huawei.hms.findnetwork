package com.huawei.android.remotecontrol.controller.cmd;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.huawei.cloud.base.util.C4633d0;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import p013ah.AbstractC0200e;
import p709vj.C13452e;
import p809yg.C13981a;
import pg.AbstractC12139d;
import pk.C12158a;

/* loaded from: classes4.dex */
public class PushCmdParser {
    private static final String TAG = "PushCmdParser";
    private String accountName;
    private JSONObject json;
    private Context mContext;
    private String name;
    private String operation;
    private String param;
    private Map<String, String> paramMap;
    private String serverTime;
    private String sessionId;
    private String sign;
    private String tagOperation;
    private String traceId;
    private String version;

    public static class MyTypeToken extends TypeToken<Map<String, String>> {
        private MyTypeToken() {
        }

        public /* synthetic */ MyTypeToken(C43401 c43401) {
            this();
        }
    }

    public PushCmdParser(Intent intent, Context context) {
        this.version = "";
        String stringExtra = new HiCloudSafeIntent(intent).getStringExtra("msg_data");
        this.mContext = context;
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(stringExtra);
            this.json = jSONObject;
            this.operation = jSONObject.getString("cmd");
            if (this.json.has("sessionID")) {
                this.sessionId = this.json.getString("sessionID");
            }
            if (this.json.has(HwPayConstant.KEY_SIGN)) {
                this.sign = this.json.getString(HwPayConstant.KEY_SIGN);
            }
            if (this.json.has("serverTime")) {
                this.serverTime = this.json.getString("serverTime");
            }
            if (this.json.has("x-hw-trace-id")) {
                this.traceId = this.json.getString("x-hw-trace-id");
            }
            if (this.json.has("version")) {
                this.version = this.json.getString("version");
            }
            if (this.json.has(RemoteMessageConst.MessageBody.PARAM)) {
                this.param = this.json.getString(RemoteMessageConst.MessageBody.PARAM);
                if (("v11".equals(this.version) || "v8".equals(this.version) || "v7".equals(this.version)) && !TextUtils.isEmpty(this.param)) {
                    this.param = paramsSortAndTransfer(this.param);
                }
            }
            String strOptString = this.json.optString("shareInfo");
            if (C4633d0.m28404a(strOptString)) {
                return;
            }
            JSONObject jSONObject2 = new JSONObject(strOptString);
            this.accountName = jSONObject2.optString("accountName");
            this.name = jSONObject2.optString("aliasOrAddressBookName");
        } catch (JSONException unused) {
            C13981a.m83988e(TAG, "PushCmdParser JSONException");
        }
    }

    private String paramsSortAndTransfer(String str) {
        try {
            Map<String, String> map = (Map) new Gson().fromJson(str, new MyTypeToken().getType());
            this.paramMap = map;
            if (map == null) {
                return null;
            }
            StringBuffer stringBuffer = new StringBuffer();
            ArrayList arrayList = new ArrayList(this.paramMap.keySet());
            Collections.sort(arrayList);
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                String str2 = (String) arrayList.get(i10);
                String str3 = this.paramMap.get(str2);
                if (str3 != null) {
                    if (i10 > 0) {
                        stringBuffer.append("&");
                    }
                    stringBuffer.append(str2);
                    stringBuffer.append("=");
                    stringBuffer.append(str3);
                }
            }
            return stringBuffer.toString();
        } catch (JsonSyntaxException unused) {
            C13981a.m83988e(TAG, "sortJson2Map JsonSyntaxException");
            return null;
        }
    }

    private void parmsDecodeEncap() throws JSONException {
        if (TextUtils.isEmpty(this.param)) {
            return;
        }
        if ("v7".equals(this.version) || "v8".equals(this.version) || "v11".equals(this.version)) {
            try {
                JSONObject jSONObject = this.json.getJSONObject(RemoteMessageConst.MessageBody.PARAM);
                String string = jSONObject.getString("message");
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                jSONObject.put("message", C12158a.m72864a(string, Constants.UTF_8));
                this.json.remove(RemoteMessageConst.MessageBody.PARAM);
                this.json.put(RemoteMessageConst.MessageBody.PARAM, jSONObject);
            } catch (JSONException unused) {
                C13981a.m83988e(TAG, "parmsDecodeEncap JSONException");
            } catch (Exception e10) {
                C13981a.m83988e(TAG, "parmsDecodeEncap error:" + e10.getMessage());
            }
        }
    }

    public boolean checkCmdFormat() {
        if (!TextUtils.isEmpty(this.operation) && !TextUtils.isEmpty(this.sessionId) && !TextUtils.isEmpty(this.sign) && !TextUtils.isEmpty(this.serverTime)) {
            return true;
        }
        C13981a.m83988e(TAG, "checkCmdFormat error");
        return false;
    }

    public boolean checkSign() throws JSONException {
        if (AbstractC0200e.m1106e(this.mContext, this.operation, this.version, this.serverTime, this.sign, this.param)) {
            parmsDecodeEncap();
            return true;
        }
        C13981a.m83988e(TAG, "checkSign error");
        return false;
    }

    public boolean checkUserId(Context context) {
        String stringVal = getStringVal(JsbMapKeyNames.H5_USER_ID);
        String strM80971t0 = C13452e.m80781L().m80971t0();
        if (!TextUtils.isEmpty(strM80971t0)) {
            if (strM80971t0.equals(stringVal)) {
                return true;
            }
            C13981a.m83988e(TAG, "check cloudUserId error");
            return false;
        }
        String userID = AbstractC12139d.m72766e(context).getUserID();
        C13981a.m83989i(TAG, "taUserId is empty:" + TextUtils.isEmpty(userID));
        if (!TextUtils.isEmpty(userID) && userID.equals(stringVal)) {
            return true;
        }
        C13981a.m83988e(TAG, "check taUserId error");
        return false;
    }

    public String getAccountName() {
        return this.accountName;
    }

    public boolean getBooleanVal(String str) {
        JSONObject jSONObject;
        if (str == null || (jSONObject = this.json) == null) {
            return false;
        }
        try {
            return jSONObject.getBoolean(str);
        } catch (JSONException unused) {
            C13981a.m83990w(TAG, "Mapping does not exists with key");
            return false;
        }
    }

    public String getCmdParamValue(String str) {
        Map<String, String> map;
        if (str == null || (map = this.paramMap) == null || map.isEmpty()) {
            return null;
        }
        String str2 = this.paramMap.containsKey(str) ? this.paramMap.get(str) : null;
        if (!"cptList".equals(str) || TextUtils.isEmpty(str2)) {
            return str2;
        }
        try {
            return URLDecoder.decode(str2, Constants.UTF_8);
        } catch (Exception unused) {
            C13981a.m83988e(TAG, "UnsupportedEncodingException");
            return str2;
        }
    }

    public JSONObject getJsonObj(String str) {
        JSONObject jSONObject;
        if (str == null || (jSONObject = this.json) == null) {
            return null;
        }
        try {
            return jSONObject.getJSONObject(str);
        } catch (JSONException unused) {
            C13981a.m83988e(TAG, "getJsonObj JSONException");
            return null;
        }
    }

    public String getName() {
        return this.name;
    }

    public String getOperation() {
        return this.operation;
    }

    public String getPushCmd() {
        JSONObject jSONObject = this.json;
        return jSONObject == null ? "" : jSONObject.toString();
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public String getStringVal(String str) {
        JSONObject jSONObject;
        if (str == null || (jSONObject = this.json) == null) {
            return null;
        }
        try {
            return jSONObject.getString(str);
        } catch (JSONException unused) {
            C13981a.m83988e(TAG, "getStringVal JSONException");
            return null;
        }
    }

    public String getTagOperation() {
        return this.tagOperation;
    }

    public String getTraceID() {
        return this.traceId;
    }

    public boolean isVersionV8() {
        return "v8".equals(this.version) || "v11".equals(this.version);
    }

    public void setTagOperation(String str) {
        this.tagOperation = str;
    }

    public boolean updateParam(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = this.json;
        if (jSONObject2 == null || jSONObject == null) {
            C13981a.m83988e(TAG, "updateParam error");
            return false;
        }
        try {
            jSONObject2.remove(RemoteMessageConst.MessageBody.PARAM);
            this.json.put(RemoteMessageConst.MessageBody.PARAM, jSONObject);
            return true;
        } catch (JSONException unused) {
            C13981a.m83988e(TAG, "updateParam JSONException");
            return false;
        }
    }

    public PushCmdParser(String str, String str2) {
        this.version = "";
        HashMap map = new HashMap();
        this.paramMap = map;
        map.put("perDeviceId", str);
        this.paramMap.put("cptList", "0");
        this.paramMap.put("perDeviceType", "3");
        this.tagOperation = str2;
        if (!"tagLocate".equals(str2) && !"tagListLocate".equals(str2)) {
            if ("startTagSound".equals(str2)) {
                this.operation = "perDevicebell";
                return;
            } else {
                if ("stopTagSound".equals(str2)) {
                    this.operation = "cancelPerDevicebell";
                    return;
                }
                return;
            }
        }
        this.operation = "perDevicelocate";
    }
}
