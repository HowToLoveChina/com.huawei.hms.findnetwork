package p576qf;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
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

/* renamed from: qf.c */
/* loaded from: classes4.dex */
public class C12350c {

    /* renamed from: a */
    public int f57145a;

    /* renamed from: b */
    public Context f57146b;

    /* renamed from: c */
    public Handler.Callback f57147c;

    /* renamed from: qf.c$a */
    public class a extends AbstractC9478g {
        public a() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws JSONException {
            C13981a.m83989i("AsyncQueryPushInfo", "AsyncQueryPushInfo doQuery task start");
            String strM74324e = C12350c.this.m74324e();
            RequestModeConfig.getInstance().setMode(3073, false);
            C4346d.m26225d(3073, strM74324e, C12350c.this.f57147c, C12350c.this.f57146b);
            C13981a.m83989i("AsyncQueryPushInfo", "AsyncQueryPushInfo doQuery task end");
        }
    }

    public C12350c(int i10, Handler.Callback callback, Context context) {
        this.f57145a = i10;
        this.f57147c = callback;
        this.f57146b = context;
    }

    /* renamed from: d */
    public void m74323d() {
        C13981a.m83989i("AsyncQueryPushInfo", "AsyncQueryPushInfo doQuery task pre-start");
        C12515a.m75110o().m75172d(new a());
    }

    /* renamed from: e */
    public final String m74324e() throws JSONException {
        String deviceID = AbstractC12139d.m72766e(this.f57146b).getDeviceID();
        if (TextUtils.isEmpty(deviceID)) {
            C13981a.m83988e("AsyncQueryPushInfo", "encaseReportInfo->deviceID is null");
            return "";
        }
        String deviceType = AbstractC12139d.m72766e(this.f57146b).getDeviceType();
        if (TextUtils.isEmpty(deviceType)) {
            C13981a.m83988e("AsyncQueryPushInfo", "encaseReportInfo->deviceType is null");
            return "";
        }
        String serviceToken = AbstractC12139d.m72766e(this.f57146b).getServiceToken();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("deviceID", deviceID);
            jSONObject.put(JsbMapKeyNames.H5_DEVICE_TYPE, deviceType);
            Context context = this.f57146b;
            if (context == null || "com.huawei.hidisk".equals(context.getPackageName())) {
                jSONObject.put("appType", 2);
            } else if ("com.huawei.android.ds".equals(this.f57146b.getPackageName())) {
                jSONObject.put("appType", 0);
            } else {
                jSONObject.put("appType", 1);
            }
            jSONObject.put("serviceToken", C11870c.m71155c(serviceToken));
            String deviceTicket = AbstractC12139d.m72766e(this.f57146b).getDeviceTicket();
            if (TextUtils.isEmpty(deviceTicket)) {
                C13981a.m83988e("AsyncQueryPushInfo", "encaseReportInfo->deviceTicket is null");
            } else {
                jSONObject.put("deviceTicket", C11870c.m71153a(deviceTicket));
            }
            jSONObject.put("queryType", this.f57145a);
            return jSONObject.toString();
        } catch (JSONException unused) {
            C13981a.m83988e("AsyncQueryPushInfo", "encaseReportInfo failed! JSONException");
            return null;
        }
    }
}
