package p611rf;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import bf.C1175a;
import com.huawei.android.remotecontrol.config.RequestModeConfig;
import com.huawei.android.remotecontrol.http.C4346d;
import com.huawei.android.remotecontrol.http.C4347e;
import com.huawei.android.remotecontrol.phonefinder.AbstractC4380a;
import com.huawei.android.remotecontrol.util.account.bean.AccountInfo;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import eg.AbstractC9478g;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0209d;
import p015ak.C0241z;
import p520of.C11860j;
import p521og.C11870c;
import p577qg.C12354d;
import p616rk.C12515a;
import p664u0.C13108a;
import p709vj.C13452e;
import p783xp.AbstractC13844b;
import p809yg.C13981a;
import pg.AbstractC12139d;
import sg.C12797b;

/* renamed from: rf.l */
/* loaded from: classes4.dex */
public class C12504l implements Handler.Callback {

    /* renamed from: g */
    public static String f57597g = "";

    /* renamed from: a */
    public String f57598a;

    /* renamed from: b */
    public final String f57599b;

    /* renamed from: c */
    public JSONArray f57600c;

    /* renamed from: d */
    public final Context f57601d;

    /* renamed from: e */
    public final int f57602e;

    /* renamed from: f */
    public AbstractC4380a f57603f;

    /* renamed from: rf.l$a */
    public class a extends AbstractC4380a {
        public a() {
        }

        @Override // com.huawei.android.remotecontrol.phonefinder.AbstractC4380a
        /* renamed from: c */
        public void mo26440c(Context context) {
            C13981a.m83989i("UpdateActivationPublicKey", "NetworkChangeReceiver release, retry UpdateActivationPublicKey " + C12504l.this.f57602e);
            C11860j.m71061i1(C12504l.this.f57602e, C12504l.this.f57598a, C12504l.this.f57599b);
        }
    }

    /* renamed from: rf.l$b */
    public class b extends AbstractC9478g {
        public b() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws JSONException {
            C13981a.m83989i("UpdateActivationPublicKey", "update activationInfo");
            String strM75077g = C12504l.this.m75077g();
            String strM76774a = C12797b.m76774a("01018");
            RequestModeConfig.getInstance().setMode(3107, true);
            C12504l c12504l = C12504l.this;
            C4346d.m26226e(3107, strM75077g, c12504l, c12504l.f57601d, strM76774a);
        }
    }

    public C12504l(Context context, int i10, String str, String str2) {
        this.f57601d = context;
        this.f57602e = i10;
        this.f57598a = str;
        this.f57599b = str2;
    }

    /* renamed from: h */
    public static boolean m75075h(String str) {
        C13981a.m83989i("UpdateActivationPublicKey", "hasActiveCredentialInfo");
        try {
            JSONObject jSONObject = (JSONObject) new JSONObject(str).opt("activationLockCredential");
            if (jSONObject == null) {
                C13981a.m83990w("UpdateActivationPublicKey", "hasActiveCredentialInfo, credentialInfo is null");
                return false;
            }
            String strOptString = jSONObject.optString("status");
            String strOptString2 = jSONObject.optString("signature");
            if (strOptString.isEmpty() || strOptString2.isEmpty()) {
                C13981a.m83990w("UpdateActivationPublicKey", "hasActiveCredentialInfo, credentialInfo is empty");
                return false;
            }
            C13981a.m83990w("UpdateActivationPublicKey", "hasActiveCredentialInfo, has credentialInfo");
            return true;
        } catch (Exception e10) {
            C13981a.m83988e("UpdateActivationPublicKey", "hasActiveCredentialInfo, JSONException: " + e10.getMessage());
            return false;
        }
    }

    /* renamed from: f */
    public void m75076f() {
        C13981a.m83989i("UpdateActivationPublicKey", "doUpdateInfo");
        if (m75078i()) {
            this.f57603f = new a();
            C12515a.m75110o().m75175e(new b(), false);
        } else {
            C13981a.m83988e("UpdateActivationPublicKey", "doUpdateInfo, update Pk fail");
            C11860j.m71002J0("updatePk", "UpdateActivationPublicKey", f57597g, "");
            m75079j(-11);
        }
    }

    /* renamed from: g */
    public final String m75077g() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            AccountInfo accountInfoM72766e = AbstractC12139d.m72766e(this.f57601d);
            jSONObject.put("version", "v11");
            jSONObject.put("deviceID", accountInfoM72766e.getDeviceID());
            jSONObject.put("deviceTicket", C11870c.m71153a(accountInfoM72766e.getDeviceTicket()));
            jSONObject.put("socID", this.f57600c);
            jSONObject.put("antiRollBackFlag", C11860j.m71003K());
            if (this.f57602e == 1) {
                jSONObject.put("pk", this.f57598a);
                if (!TextUtils.isEmpty(this.f57599b)) {
                    jSONObject.put("verifyToken", this.f57599b);
                }
            } else {
                jSONObject.put("pk", "clear");
            }
            return jSONObject.toString();
        } catch (JSONException unused) {
            C13981a.m83988e("UpdateActivationPublicKey", "encaseUpdateInfo failed! JSONException");
            return null;
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        C13981a.m83987d("UpdateActivationPublicKey", "HttpCallback->handleMessage->handleInfoUpdateRsp");
        Bundle data = message.getData();
        if (data == null) {
            C13981a.m83988e("UpdateActivationPublicKey", "update activation response bundle null");
            return true;
        }
        int iM1685c = C0241z.m1685c(data.getString("result"));
        C13981a.m83989i("UpdateActivationPublicKey", "update activation info result:" + iM1685c);
        C12797b c12797b = new C12797b();
        if (200 != iM1685c) {
            C13981a.m83988e("UpdateActivationPublicKey", "handleMsg update activation publicKey error=" + iM1685c);
            c12797b.m76784j(this.f57601d, "UpdateActivationPublicKey", "001_3003", "handleMsg update activation publicKey fail,result" + iM1685c, null, "01018", null, "updateActiveInfo", true);
            this.f57603f.m26439b(this.f57601d.getApplicationContext());
            return true;
        }
        String string = data.getString("response_info");
        if (TextUtils.isEmpty(string)) {
            C13981a.m83988e("UpdateActivationPublicKey", "update activation responseInfo empty");
            return true;
        }
        int iM26233d = C4347e.m26233d(string);
        C13981a.m83990w("UpdateActivationPublicKey", "handleMsg update activation publicKey resultCode=" + iM26233d);
        if (iM26233d == 0) {
            if (m75075h(string)) {
                C12354d.m74326B(string);
            }
            c12797b.m76784j(this.f57601d, "UpdateActivationPublicKey", "0", "handleActivationUpdatePublicKey is success", null, "01018", null, "updateActiveInfo", true);
        } else {
            C13981a.m83988e("UpdateActivationPublicKey", "handleMsg update activation info fail " + iM26233d);
            c12797b.m76782h(this.f57601d, "UpdateActivationPublicKey", "001_3004", iM26233d, "handleMsg update activation info fail,resultCode" + iM26233d, null, "01018", null, "updateActiveInfo", true);
        }
        if (this.f57602e == 1) {
            m75079j(iM26233d);
        }
        return true;
    }

    /* renamed from: i */
    public final boolean m75078i() {
        C13981a.m83989i("UpdateActivationPublicKey", "isSatisfyUpdatePk");
        if (!C0209d.m1166E1()) {
            C13981a.m83990w("UpdateActivationPublicKey", "stop updatePublicKey: not owner user");
            f57597g = "stop updatePublicKey: not owner user";
            return false;
        }
        String strM80971t0 = C13452e.m80781L().m80971t0();
        if (TextUtils.isEmpty(strM80971t0)) {
            C13981a.m83990w("UpdateActivationPublicKey", "userIdFromHiCloud empty");
            f57597g = "userIdFromHiCloud empty";
            return false;
        }
        String userID4RC = AbstractC12139d.m72766e(this.f57601d).getUserID4RC();
        if (TextUtils.isEmpty(userID4RC)) {
            C13981a.m83990w("UpdateActivationPublicKey", "userIdFromPhoneFinder empty");
            f57597g = "userIdFromPhoneFinder empty";
            return false;
        }
        if (!strM80971t0.equals(userID4RC)) {
            C13981a.m83990w("UpdateActivationPublicKey", "uid not match");
            f57597g = "uid not match";
            return false;
        }
        if (!C1175a.m7389k(this.f57601d)) {
            C13981a.m83990w("UpdateActivationPublicKey", "phone finder switch off");
            f57597g = "phone finder switch off";
            return false;
        }
        if (C1175a.m7385g(true)) {
            C13981a.m83990w("UpdateActivationPublicKey", "authFlag is true");
            f57597g = "authFlag is true";
            return false;
        }
        if (!C11860j.m71031Y()) {
            C13981a.m83990w("UpdateActivationPublicKey", "rom version not supported");
            f57597g = "rom version not supported";
            return false;
        }
        JSONArray jSONArrayM7393o = C1175a.m7393o();
        this.f57600c = jSONArrayM7393o;
        if (jSONArrayM7393o == null || jSONArrayM7393o.length() == 0 || TextUtils.isEmpty(this.f57600c.toString())) {
            C13981a.m83990w("UpdateActivationPublicKey", "socId null");
            f57597g = "socId null";
            return false;
        }
        if (this.f57602e == 1) {
            byte[] bArrM7391m = C1175a.m7391m();
            if (bArrM7391m == null || bArrM7391m.length == 0) {
                C13981a.m83990w("UpdateActivationPublicKey", "get pk fail, pk is empty");
                if (TextUtils.isEmpty(this.f57598a)) {
                    f57597g = "get pk fail, pk is empty";
                    C13981a.m83990w("UpdateActivationPublicKey", "local pk is empty");
                    return false;
                }
            } else {
                C13981a.m83989i("UpdateActivationPublicKey", "get pk success");
                this.f57598a = AbstractC13844b.m83105a(bArrM7391m);
            }
        }
        return true;
    }

    /* renamed from: j */
    public void m75079j(int i10) {
        Intent intent = new Intent();
        if (i10 == 0) {
            intent.setAction("pkUpdateSucceed");
        } else {
            intent.setAction("pkUpdateFailed");
        }
        intent.putExtra(MapKeyNames.RESULT_CODE, i10);
        intent.putExtra("publicKeyStr", this.f57598a);
        C13108a.m78878b(this.f57601d).m78881d(intent);
    }
}
