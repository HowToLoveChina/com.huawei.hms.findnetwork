package p394jf;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.huawei.android.remotecontrol.config.RequestModeConfig;
import com.huawei.android.remotecontrol.http.C4346d;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import eg.AbstractC9478g;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0241z;
import p521og.C11870c;
import p616rk.C12515a;
import p809yg.C13981a;
import pg.AbstractC12139d;

/* renamed from: jf.a */
/* loaded from: classes4.dex */
public class C10813a {

    /* renamed from: a */
    public String f51602a;

    /* renamed from: b */
    public String f51603b;

    /* renamed from: c */
    public Context f51604c;

    /* renamed from: d */
    public String f51605d;

    /* renamed from: e */
    public String f51606e;

    /* renamed from: f */
    public Handler.Callback f51607f;

    /* renamed from: jf.a$a */
    public class a extends AbstractC9478g {
        public a() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws JSONException {
            String strM65857e = C10813a.this.m65857e();
            RequestModeConfig.getInstance().setMode(3020, false);
            C4346d.m26225d(3020, strM65857e, C10813a.this.f51607f, C10813a.this.f51604c);
        }
    }

    public C10813a(Context context, Handler.Callback callback) {
        this.f51604c = context;
        this.f51602a = AbstractC12139d.m72766e(context).getDeviceID();
        this.f51603b = AbstractC12139d.m72766e(context).getServiceToken();
        this.f51605d = AbstractC12139d.m72766e(context).getDeviceType();
        this.f51606e = AbstractC12139d.m72766e(context).getDeviceTicket();
        this.f51607f = callback;
    }

    /* renamed from: f */
    public static int m65854f(String str) throws JSONException {
        int i10 = 1;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(MapKeyNames.RESULT_CODE)) {
                i10 = jSONObject.getInt(MapKeyNames.RESULT_CODE);
            } else {
                C13981a.m83990w("ClearLossModeReport", "getResultCode->json has no resultCode");
            }
        } catch (JSONException unused) {
            C13981a.m83988e("ClearLossModeReport", "getResultCode JSONException");
        }
        return i10;
    }

    /* renamed from: g */
    public static void m65855g(Message message, Context context) throws JSONException {
        C13981a.m83987d("ClearLossModeReport", "HttpCallback->handleMessage->ClearLossModeReport");
        if (200 != C0241z.m1685c(message.getData().getString("result"))) {
            C10818f.m65874a().m65880g(true);
            C10818f.m65874a().m65879f(context, true);
            C13981a.m83987d("ClearLossModeReport", "ClearLossModeReport handleResponse->report error");
            return;
        }
        int iM65854f = m65854f(message.getData().getString("response_info"));
        C13981a.m83987d("ClearLossModeReport", "ClearLossModeReport resultCode: " + iM65854f);
        if (iM65854f != 0) {
            C10818f.m65874a().m65879f(context, true);
            C10818f.m65874a().m65880g(true);
        } else {
            C10818f.m65874a().m65880g(false);
            C10818f.m65874a().m65879f(context, false);
        }
    }

    /* renamed from: d */
    public void m65856d() {
        if (C10818f.m65874a().m65876c()) {
            C12515a.m75110o().m75172d(new a());
        }
    }

    /* renamed from: e */
    public final String m65857e() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            Context context = this.f51604c;
            if (context == null || !"com.huawei.hidisk".equals(context.getPackageName())) {
                Context context2 = this.f51604c;
                if (context2 == null || !"com.huawei.android.ds".equals(context2.getPackageName())) {
                    jSONObject.put("appType", 1);
                } else {
                    jSONObject.put("appType", 0);
                }
            } else {
                jSONObject.put("appType", 2);
            }
            jSONObject.put("deviceID", this.f51602a);
            jSONObject.put(JsbMapKeyNames.H5_DEVICE_TYPE, this.f51605d);
            jSONObject.put("serviceToken", C11870c.m71155c(this.f51603b));
            jSONObject.put("deviceTicket", C11870c.m71153a(this.f51606e));
            return jSONObject.toString();
        } catch (JSONException unused) {
            C13981a.m83988e("ClearLossModeReport", "encaseLossModeReReport failed! JSONException");
            return null;
        }
    }
}
