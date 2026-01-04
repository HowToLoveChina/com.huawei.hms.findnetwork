package com.huawei.android.remotecontrol.track;

import android.content.Context;
import android.os.Handler;
import com.huawei.android.remotecontrol.config.RequestModeConfig;
import com.huawei.android.remotecontrol.http.C4346d;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import eg.AbstractC9478g;
import org.json.JSONException;
import org.json.JSONObject;
import p521og.C11870c;
import p616rk.C12515a;
import p809yg.C13981a;
import pg.AbstractC12139d;

/* renamed from: com.huawei.android.remotecontrol.track.k */
/* loaded from: classes4.dex */
public class C4449k {

    /* renamed from: a */
    public String f20398a;

    /* renamed from: b */
    public String f20399b;

    /* renamed from: c */
    public String f20400c;

    /* renamed from: d */
    public String f20401d;

    /* renamed from: e */
    public String f20402e;

    /* renamed from: f */
    public Context f20403f;

    /* renamed from: g */
    public Handler.Callback f20404g;

    /* renamed from: com.huawei.android.remotecontrol.track.k$a */
    public class a extends AbstractC9478g {
        public a() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws JSONException {
            C13981a.m83989i("QueryTrackPeriod", "doQuery task start");
            String strM27004e = C4449k.this.m27004e();
            RequestModeConfig.getInstance().setMode(3071, false);
            C4346d.m26225d(3071, strM27004e, C4449k.this.f20404g, C4449k.this.f20403f);
        }
    }

    public C4449k(String str, String str2, String str3, String str4, Handler.Callback callback, Context context) {
        this.f20399b = str;
        this.f20398a = str2;
        this.f20400c = str3;
        this.f20401d = str4;
        this.f20404g = callback;
        this.f20403f = context;
        this.f20402e = AbstractC12139d.m72766e(context).getDeviceTicket();
    }

    /* renamed from: d */
    public void m27003d() {
        C12515a.m75110o().m75172d(new a());
        C13981a.m83989i("QueryTrackPeriod", "doQuery task add");
    }

    /* renamed from: e */
    public final String m27004e() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("operation", "openLostPattern");
            jSONObject.put("sessionID", this.f20399b);
            jSONObject.put("deviceID", this.f20398a);
            jSONObject.put(JsbMapKeyNames.H5_DEVICE_TYPE, this.f20400c);
            jSONObject.put("serviceToken", C11870c.m71155c(this.f20401d));
            jSONObject.put("deviceTicket", C11870c.m71153a(this.f20402e));
            Context context = this.f20403f;
            if (context == null || "com.huawei.hidisk".equals(context.getPackageName())) {
                jSONObject.put("appType", 2);
            } else if ("com.huawei.android.ds".equals(this.f20403f.getPackageName())) {
                jSONObject.put("appType", 0);
            } else {
                jSONObject.put("appType", 1);
            }
            return jSONObject.toString();
        } catch (JSONException unused) {
            C13981a.m83988e("QueryTrackPeriod", "encaseReportInfo failed! JSONException");
            return null;
        }
    }
}
