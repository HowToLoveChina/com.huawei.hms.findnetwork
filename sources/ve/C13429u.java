package ve;

import android.content.Context;
import android.os.Handler;
import bf.C1175a;
import com.huawei.android.remotecontrol.config.RequestModeConfig;
import com.huawei.android.remotecontrol.http.C4346d;
import com.huawei.android.remotecontrol.phonefinder.AbstractC4380a;
import eg.AbstractC9478g;
import org.json.JSONException;
import org.json.JSONObject;
import p616rk.C12515a;
import p809yg.C13981a;
import sg.C12797b;

/* renamed from: ve.u */
/* loaded from: classes4.dex */
public class C13429u extends AbstractC4380a {

    /* renamed from: c */
    public String f60519c;

    /* renamed from: d */
    public Context f60520d;

    /* renamed from: e */
    public Handler.Callback f60521e;

    /* renamed from: ve.u$a */
    public class a extends AbstractC9478g {
        public a() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws JSONException {
            C13981a.m83989i("QueryAncillaryDevice", "do Query Ancillary Device");
            String strM80721h = C13429u.this.m80721h();
            String strM76774a = C12797b.m76774a("01020");
            RequestModeConfig.getInstance().setMode(3080, false);
            C4346d.m26226e(3080, strM80721h, C13429u.this.f60521e, C13429u.this.f60520d, strM76774a);
        }
    }

    public C13429u(Context context, String str, Handler.Callback callback) {
        this.f60520d = context;
        this.f60519c = str;
        this.f60521e = callback;
    }

    @Override // com.huawei.android.remotecontrol.phonefinder.AbstractC4380a
    /* renamed from: c */
    public void mo26440c(Context context) {
        C13981a.m83989i("QueryAncillaryDevice", "NetworkChangeReceiver release, retry active ancillary device info");
        if (C1175a.m7389k(context)) {
            m80720g();
        }
    }

    /* renamed from: g */
    public void m80720g() {
        C12515a.m75110o().m75175e(new a(), false);
    }

    /* renamed from: h */
    public final String m80721h() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("perDeviceType", this.f60519c);
            return jSONObject.toString();
        } catch (JSONException unused) {
            C13981a.m83988e("QueryAncillaryDevice", "encaseDeviceInfo failed! JSONException");
            return null;
        }
    }
}
