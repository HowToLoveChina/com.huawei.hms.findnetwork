package p611rf;

import android.content.Context;
import android.os.Handler;
import com.huawei.android.remotecontrol.config.RequestModeConfig;
import com.huawei.android.remotecontrol.http.C4346d;
import com.huawei.android.remotecontrol.http.C4348f;
import eg.AbstractC9478g;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p520of.C11866p;
import p575qe.C12347f;
import p616rk.C12515a;
import p809yg.C13981a;
import sg.C12797b;

/* renamed from: rf.a */
/* loaded from: classes4.dex */
public class C12493a {

    /* renamed from: a */
    public final String f57522a;

    /* renamed from: b */
    public final Handler.Callback f57523b;

    /* renamed from: rf.a$a */
    public class a extends AbstractC9478g {
        public a() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws JSONException {
            Context contextM74301m = C12347f.m74285n().m74301m();
            String strM74990d = C12493a.this.m74990d();
            if (strM74990d == null || strM74990d.isEmpty()) {
                C13981a.m83988e("ActivationLockCheck", "ActivationLockCheck doCheck data is null");
                return;
            }
            C13981a.m83989i("ActivationLockCheck", "ActivationLockCheck call");
            String strM76774a = C12797b.m76774a(String.valueOf(3112));
            C4348f c4348f = new C4348f(contextM74301m, "", strM76774a, strM74990d, 3112);
            RequestModeConfig.getInstance().setMode(3112, true);
            C4346d.m26227f(3112, strM74990d, C12493a.this.f57523b, contextM74301m, strM76774a, c4348f);
        }
    }

    public C12493a(String str, Handler.Callback callback) {
        this.f57522a = str;
        this.f57523b = callback;
    }

    /* renamed from: c */
    public void m74989c() {
        C12515a.m75110o().m75172d(new a());
    }

    /* renamed from: d */
    public final String m74990d() throws JSONException {
        JSONArray jSONArrayM71116o;
        C13981a.m83989i("ActivationLockCheck", "encaseBodyData");
        if (this.f57522a == null) {
            C13981a.m83988e("ActivationLockCheck", "encaseBodyData, vt is null");
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONArrayM71116o = C11866p.m71116o();
        } catch (Exception e10) {
            C13981a.m83988e("ActivationLockCheck", "encaseBodyData, Exception: " + e10.getMessage());
        }
        if (jSONArrayM71116o == null) {
            C13981a.m83988e("ActivationLockCheck", "encaseBodyData, socIdCert is null");
            return null;
        }
        jSONObject.put("socIdCert", jSONArrayM71116o);
        jSONObject.put("verifyToken", this.f57522a);
        return jSONObject.toString();
    }
}
