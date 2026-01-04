package com.huawei.android.remotecontrol.track;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0241z;
import p809yg.C13981a;

/* renamed from: com.huawei.android.remotecontrol.track.j */
/* loaded from: classes4.dex */
public class C4448j implements Handler.Callback {

    /* renamed from: a */
    public Context f20396a;

    /* renamed from: b */
    public String f20397b;

    public C4448j(Context context, String str) {
        this.f20396a = context;
        this.f20397b = str;
    }

    /* renamed from: a */
    public final int m26995a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.has("subCmd") ? jSONObject.getString("subCmd") : null;
            if (string == null) {
                C13981a.m83988e("QueryCmdInfoCallBack", "subInfo is null");
                return -1;
            }
            JSONObject jSONObject2 = new JSONObject(string);
            if (jSONObject2.has("minDistance")) {
                return jSONObject2.getInt("minDistance");
            }
            C13981a.m83989i("QueryCmdInfoCallBack", "getMinDistance->json has no resultCode");
            return -1;
        } catch (JSONException unused) {
            C13981a.m83988e("QueryCmdInfoCallBack", "getMinDistance JSONException");
            return -1;
        }
    }

    /* renamed from: b */
    public final int m26996b(String str) throws JSONException {
        int i10 = 1;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(MapKeyNames.RESULT_CODE)) {
                i10 = jSONObject.getInt(MapKeyNames.RESULT_CODE);
            } else {
                C13981a.m83987d("QueryCmdInfoCallBack", "getResultCode->json has no resultCode");
            }
        } catch (JSONException unused) {
            C13981a.m83988e("QueryCmdInfoCallBack", "getResultCode JSONException");
        }
        C13981a.m83987d("QueryCmdInfoCallBack", "resultCode:" + i10);
        return i10;
    }

    /* renamed from: c */
    public final long m26997c(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.has("subCmd") ? jSONObject.getString("subCmd") : null;
            if (string == null) {
                C13981a.m83988e("QueryCmdInfoCallBack", "getServerTimestamp->subInfo is null");
                return -1L;
            }
            JSONObject jSONObject2 = new JSONObject(string);
            if (jSONObject2.has("currentTimestamp")) {
                return jSONObject2.getLong("currentTimestamp");
            }
            C13981a.m83988e("QueryCmdInfoCallBack", "getServerTimestamp->json has no trackperiod");
            return -1L;
        } catch (JSONException unused) {
            C13981a.m83988e("QueryCmdInfoCallBack", "getServerTimestamp JSONException");
            return -1L;
        }
    }

    /* renamed from: d */
    public final long m26998d(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.has("subCmd") ? jSONObject.getString("subCmd") : null;
            if (string == null) {
                C13981a.m83988e("QueryCmdInfoCallBack", "getTrackperiod->subInfo is null");
                return -1L;
            }
            JSONObject jSONObject2 = new JSONObject(string);
            if (jSONObject2.has("trackPeriod")) {
                return jSONObject2.getLong("trackPeriod");
            }
            C13981a.m83988e("QueryCmdInfoCallBack", "getTrackperiod->json has no trackperiod");
            return -1L;
        } catch (JSONException unused) {
            C13981a.m83988e("QueryCmdInfoCallBack", "getTrackperiod JSONException");
            return -1L;
        }
    }

    /* renamed from: e */
    public final void m26999e(Message message) throws JSONException {
        int iM1685c = C0241z.m1685c(message.getData().getString("result"));
        C13981a.m83989i("QueryCmdInfoCallBack", "handleQueryCmdInfoCallback result:" + iM1685c);
        if (200 != iM1685c) {
            C13981a.m83988e("QueryCmdInfoCallBack", "handleQueryCmdInfoCallback->report error, result:" + iM1685c);
            return;
        }
        String string = message.getData().getString("response_info");
        int iM26996b = m26996b(string);
        C13981a.m83989i("QueryCmdInfoCallBack", "handleQueryCmdInfoCallback->resultCode =" + iM26996b);
        if (iM26996b == 0) {
            C4452n.m27034n(this.f20396a, m26998d(string), m26995a(string), m26997c(string), this.f20397b);
            C4443e.m26983g(this.f20396a);
        } else {
            C13981a.m83988e("QueryCmdInfoCallBack", "handleQueryCmdInfoCallback->resultCode =" + iM26996b);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) throws JSONException {
        C13981a.m83989i("QueryCmdInfoCallBack", "QueryCmdInfoCallBack->handleMessage");
        m26999e(message);
        return true;
    }
}
