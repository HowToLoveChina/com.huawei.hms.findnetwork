package p765x7;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.android.hicloud.album.service.hihttp.request.response.BaseResponse;
import com.huawei.android.hicloud.album.service.hihttp.request.response.CommonResponse;
import com.huawei.android.hicloud.album.service.logic.manager.SyncSessionManager;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0213f;
import p031b7.C1120a;
import p031b7.C1136q;

/* renamed from: x7.c */
/* loaded from: classes2.dex */
public class C13721c {
    /* renamed from: a */
    public static Bundle m82485a(String str) {
        if (TextUtils.isEmpty(str)) {
            C1120a.m6676e("RequestHelper", "getBaseResponseBundle body is empty!");
            return m82487c(101, "body is empty!");
        }
        try {
            BaseResponse baseResponse = (BaseResponse) new Gson().fromJson(str, BaseResponse.class);
            if (baseResponse != null) {
                return m82487c(baseResponse.getCode(), baseResponse.getInfo());
            }
            C1120a.m6676e("RequestHelper", "getBaseResponseBundle response is null!");
            return m82487c(130, "json syntax error!");
        } catch (JsonSyntaxException e10) {
            C1120a.m6676e("RequestHelper", "getResponseBundle json syntax exception: " + e10.toString());
            return m82487c(130, "json syntax error!");
        }
    }

    /* renamed from: b */
    public static Bundle m82486b(String str) {
        if (TextUtils.isEmpty(str)) {
            C1120a.m6676e("RequestHelper", "getCommonResponseBundle body is empty!");
            return m82487c(101, "body is empty!");
        }
        try {
            CommonResponse commonResponse = (CommonResponse) new Gson().fromJson(str, CommonResponse.class);
            if (commonResponse == null) {
                C1120a.m6676e("RequestHelper", "getCommonResponseBundle response is null!");
                return m82487c(130, "json syntax error!");
            }
            Bundle bundleM82487c = m82487c(commonResponse.getCode(), commonResponse.getInfo());
            int expire = commonResponse.getExpire();
            if (expire > 0) {
                bundleM82487c.putInt("Expire", expire);
            }
            long serverTime = commonResponse.getServerTime();
            if (serverTime > 0) {
                bundleM82487c.putLong("ServerTime", serverTime);
            }
            int status = commonResponse.getStatus();
            if (status >= 0) {
                bundleM82487c.putInt("Status", status);
            }
            int interval = commonResponse.getInterval();
            if (interval != -1) {
                bundleM82487c.putInt("Interval", interval);
                C1136q.b.m7010K0(C0213f.m1377a(), commonResponse.getInterval());
                SyncSessionManager.m15153t().m15176W();
            }
            return bundleM82487c;
        } catch (JsonSyntaxException e10) {
            C1120a.m6676e("RequestHelper", "getResponseBundle json syntax exception: " + e10.toString());
            return m82487c(130, "json syntax error!");
        }
    }

    /* renamed from: c */
    public static Bundle m82487c(int i10, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("code", i10);
        bundle.putString("info", str);
        return bundle;
    }

    /* renamed from: d */
    public static JSONObject m82488d(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cmd", str);
        } catch (JSONException unused) {
            C1120a.m6676e("RequestHelper", "jsonObjectWithCmd error");
        }
        return jSONObject;
    }

    /* renamed from: e */
    public static String m82489e(String str) {
        return m82488d(str).toString();
    }
}
