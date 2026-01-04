package p611rf;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import bf.C1175a;
import com.huawei.android.remotecontrol.config.RequestModeConfig;
import com.huawei.android.remotecontrol.http.C4346d;
import com.huawei.android.remotecontrol.http.C4347e;
import com.huawei.android.remotecontrol.phonefinder.C4382c;
import eg.AbstractC9478g;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0241z;
import p520of.C11860j;
import p521og.C11877j;
import p577qg.C12354d;
import p616rk.C12515a;
import p709vj.C13452e;
import p809yg.C13981a;
import pg.AbstractC12139d;
import sg.C12797b;

/* renamed from: rf.k */
/* loaded from: classes4.dex */
public class C12503k implements Handler.Callback {

    /* renamed from: a */
    public final String f57592a;

    /* renamed from: b */
    public final Context f57593b;

    /* renamed from: c */
    public final String f57594c;

    /* renamed from: d */
    public boolean f57595d = false;

    /* renamed from: rf.k$a */
    public class a extends AbstractC9478g {
        public a() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws JSONException {
            if (!C12503k.this.m75068f()) {
                C13981a.m83989i("UpdateActivationInfo", "update activationInfo break");
                return;
            }
            C13981a.m83989i("UpdateActivationInfo", "update activationInfo");
            String strM75067e = C12503k.this.m75067e();
            String strM76774a = C12797b.m76774a("01018");
            RequestModeConfig.getInstance().setMode(3074, false);
            C12503k c12503k = C12503k.this;
            C4346d.m26226e(3074, strM75067e, c12503k, c12503k.f57593b, strM76774a);
        }
    }

    public C12503k(String str, Context context, String str2) {
        this.f57592a = str;
        this.f57593b = context;
        this.f57594c = str2;
    }

    /* renamed from: d */
    public void m75066d() {
        C12515a.m75110o().m75172d(new a());
    }

    /* renamed from: e */
    public final String m75067e() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            String str = this.f57592a;
            if (str != null) {
                jSONObject.put("pushToken", str);
            } else {
                C13981a.m83989i("UpdateActivationInfo", "encaseUpdateInfo: deviceToken is null");
            }
            jSONObject.put("version", this.f57594c);
            jSONObject.put("accountType", AbstractC12139d.m72766e(this.f57593b).getAccountType());
            if (C1175a.m7385g(true)) {
                C13981a.m83989i("UpdateActivationInfo", "has auth flag, not report soc id");
                return jSONObject.toString();
            }
            JSONArray jSONArrayM7393o = C1175a.m7393o();
            if (jSONArrayM7393o != null && jSONArrayM7393o.length() != 0) {
                this.f57595d = true;
                jSONObject.put("socID", jSONArrayM7393o);
                jSONObject.put("accountName", AbstractC12139d.m72766e(this.f57593b).getAccountName());
            }
            return jSONObject.toString();
        } catch (JSONException unused) {
            C13981a.m83988e("UpdateActivationInfo", "encaseUpdateInfo failed! JSONException");
            return null;
        }
    }

    /* renamed from: f */
    public final boolean m75068f() {
        if (!C1175a.m7389k(this.f57593b)) {
            return false;
        }
        boolean z10 = !TextUtils.equals(C11877j.m71252b0(this.f57593b), this.f57592a);
        boolean zM71276j0 = C11877j.m71276j0(this.f57593b);
        C13981a.m83989i("UpdateActivationInfo", "isNeedReport, socIdHasReport:" + zM71276j0 + ",hasSocIdInfo:" + this.f57595d);
        return z10 || (!zM71276j0 && this.f57595d);
    }

    /* renamed from: g */
    public final void m75069g(String str) {
        if (!C13452e.m80781L().m80842P0()) {
            C13981a.m83989i("UpdateActivationInfo", "saveAC cloud not login");
            return;
        }
        String strM80971t0 = C13452e.m80781L().m80971t0();
        if (strM80971t0 != null && !strM80971t0.equals(AbstractC12139d.m72766e(C0213f.m1377a()).getUserID())) {
            C13981a.m83989i("UpdateActivationInfo", "saveAC not same account");
            return;
        }
        if (!C0209d.m1203Q1(C0213f.m1377a())) {
            C13981a.m83989i("UpdateActivationInfo", "saveAC startup not finish");
            return;
        }
        if (!AbstractC12139d.m72769h(C0213f.m1377a())) {
            C12354d.m74326B(str);
            return;
        }
        int iM71003K = C11860j.m71003K();
        C13981a.m83989i("UpdateActivationInfo", "saveAC antiRollbackFlag = " + iM71003K);
        if (iM71003K != 1) {
            C12354d.m74326B(str);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        C13981a.m83987d("UpdateActivationInfo", "HttpCallback->handleMessage->handleInfoUpdateRsp");
        int iM1685c = C0241z.m1685c(message.getData().getString("result"));
        C13981a.m83989i("UpdateActivationInfo", "update activation info result:" + iM1685c);
        C12797b c12797b = new C12797b();
        if (200 != iM1685c) {
            C13981a.m83988e("UpdateActivationInfo", "handleMsg update activation info error=" + iM1685c);
            c12797b.m76784j(this.f57593b, "UpdateActivationInfo", "001_3003", "handleMsg update activation info fail,result" + iM1685c, null, "01018", null, "updateActiveInfo", true);
            C4382c.m26442d().m26439b(this.f57593b.getApplicationContext());
            C4382c.m26442d().m26443e(this.f57592a);
            return true;
        }
        String string = message.getData().getString("response_info");
        int iM26233d = C4347e.m26233d(string);
        C13981a.m83989i("UpdateActivationInfo", "handleMsg update activation info resultCode=" + iM26233d);
        if (iM26233d == 0) {
            if (this.f57595d) {
                C11877j.m71301r1(this.f57593b, true);
            }
            C11877j.m71277j1(this.f57593b, this.f57592a);
            m75069g(string);
            c12797b.m76784j(this.f57593b, "UpdateActivationInfo", "0", "handleActivationInfoUpdate is success", null, "01018", null, "updateActiveInfo", true);
        } else if (401 == iM26233d) {
            c12797b.m76782h(this.f57593b, "UpdateActivationInfo", "001_3004", iM26233d, "handleMsg update activation info fail,resultCode" + iM26233d, null, "01018", null, "updateActiveInfo", true);
        } else {
            C13981a.m83988e("UpdateActivationInfo", "handleMsg update activation info fail");
            c12797b.m76782h(this.f57593b, "UpdateActivationInfo", "001_3004", iM26233d, "handleMsg update activation info fail,resultCode" + iM26233d, null, "01018", null, "updateActiveInfo", true);
        }
        return true;
    }
}
