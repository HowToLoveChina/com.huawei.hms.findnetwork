package re;

import android.content.Context;
import android.os.Handler;
import com.huawei.android.remotecontrol.config.RequestModeConfig;
import com.huawei.android.remotecontrol.http.C4346d;
import com.huawei.hms.support.api.entity.sns.SNSCode;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import eg.AbstractC9478g;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p521og.C11870c;
import p616rk.C12515a;
import p809yg.C13981a;
import pg.AbstractC12139d;
import tg.C13011a;
import ug.C13172b;

/* renamed from: re.a */
/* loaded from: classes4.dex */
public class C12492a {

    /* renamed from: a */
    public String f57513a;

    /* renamed from: b */
    public int f57514b;

    /* renamed from: c */
    public String f57515c;

    /* renamed from: d */
    public String f57516d;

    /* renamed from: e */
    public Context f57517e;

    /* renamed from: f */
    public String f57518f;

    /* renamed from: g */
    public Handler.Callback f57519g;

    /* renamed from: h */
    public int f57520h;

    /* renamed from: re.a$a */
    public class a extends AbstractC9478g {
        public a() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws JSONException {
            String strM74986f = C12492a.this.m74986f();
            RequestModeConfig.getInstance().setMode(Integer.valueOf(SNSCode.Status.ADD_FRIEND_FAILED), false);
            C4346d.m26226e(SNSCode.Status.ADD_FRIEND_FAILED, strM74986f, C12492a.this.f57519g, C12492a.this.f57517e, C12492a.this.f57518f);
        }
    }

    public C12492a(String str, int i10, String str2, Handler.Callback callback, Context context, int i11, String str3) {
        this.f57513a = str;
        this.f57514b = i10;
        this.f57515c = str2;
        this.f57519g = callback;
        this.f57517e = context;
        this.f57520h = i11;
        this.f57516d = AbstractC12139d.m72766e(context).getDeviceTicket();
        this.f57518f = str3;
    }

    /* renamed from: e */
    public void m74985e() {
        C12515a.m75110o().m75175e(new a(), false);
    }

    /* renamed from: f */
    public final String m74986f() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("deviceID", this.f57513a);
            jSONObject.put(JsbMapKeyNames.H5_DEVICE_TYPE, this.f57514b);
            jSONObject.put("serviceToken", C11870c.m71155c(this.f57515c));
            jSONObject.put("deviceTicket", C11870c.m71153a(this.f57516d));
            jSONObject.put("version", "v11");
            jSONObject.put("appType", 2);
            JSONArray jSONArray = new JSONArray();
            if (C13172b.m79212h(1, this.f57520h)) {
                jSONArray.put("alarm");
            }
            if (C13172b.m79212h(0, this.f57520h)) {
                jSONArray.put("locate");
            }
            if (C13172b.m79212h(2, this.f57520h)) {
                jSONArray.put("clear");
            }
            if (C13172b.m79212h(3, this.f57520h)) {
                jSONArray.put("lockScreen");
            }
            if (C13172b.m79212h(5, this.f57520h)) {
                jSONArray.put("lockSdcard");
            }
            if (C13172b.m79212h(6, this.f57520h)) {
                jSONArray.put("lostPattern");
            }
            if (C13172b.m79212h(8, this.f57520h)) {
                jSONArray.put("endpointCrypted");
            }
            if (C13011a.m78314a() && C13172b.m79212h(7, this.f57520h)) {
                jSONArray.put("trackreport");
            }
            jSONObject.put("params", jSONArray);
            return jSONObject.toString();
        } catch (JSONException unused) {
            C13981a.m83988e("ClientCapabilityReport", "encaseReportInfo failed! JSONException");
            return null;
        }
    }
}
