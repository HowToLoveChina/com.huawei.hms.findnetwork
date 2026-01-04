package p701v6;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.huawei.android.hicloud.album.service.C2414a;
import com.huawei.android.p069cg.configure.CloudAlbumSettings;
import com.huawei.android.p069cg.logic.manager.CloudAlbumManager;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.videokit.player.common.PlayerConstants;
import com.huawei.hwcloudjs.C6618c;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import fk.C9721b;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0209d;
import p015ak.C0241z;
import p031b7.C1120a;
import p031b7.C1122c;
import p527on.C11976a;
import p664u0.C13108a;
import p681uj.C13194k;
import p681uj.C13195l;
import p681uj.C13199p;
import p709vj.C13452e;
import p730w6.C13533a;
import p764x6.AbstractC13709a;
import p837z9.C14163d;

/* renamed from: v6.b */
/* loaded from: classes2.dex */
public abstract class AbstractC13355b<T> extends AbstractC13709a<T> {

    /* renamed from: l */
    public static final HashMap<Integer, String> f60196l = new a();

    /* renamed from: a */
    public Context f60197a;

    /* renamed from: b */
    public String f60198b;

    /* renamed from: c */
    public String f60199c;

    /* renamed from: d */
    public String f60200d;

    /* renamed from: f */
    public Map<String, String> f60202f;

    /* renamed from: j */
    public int f60206j;

    /* renamed from: e */
    public String f60201e = "0";

    /* renamed from: g */
    public boolean f60203g = false;

    /* renamed from: h */
    public boolean f60204h = true;

    /* renamed from: i */
    public int f60205i = 200;

    /* renamed from: k */
    public C13533a f60207k = null;

    /* renamed from: v6.b$a */
    public class a extends HashMap<Integer, String> {
        public a() {
            put(Integer.valueOf(PlayerConstants.ErrorCode.DEFAULT_ERROR), "1013");
            put(Integer.valueOf(ConnectionResult.RESOLUTION_REQUIRED), "1002");
            put(Integer.valueOf(ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED), "1006");
            put(9003, "1003");
            put(Integer.valueOf(ConnectionResult.SERVICE_UPDATING), "1009");
            put(Integer.valueOf(ConnectionResult.SIGN_IN_FAILED), FaqConstants.CHANNEL_HICARE);
            put(Integer.valueOf(C6618c.f30770o), "1008");
            put(9007, "1005");
            put(9100, "1000");
        }
    }

    public AbstractC13355b(Context context, Map<String, String> map, String str) {
        this.f60197a = context;
        this.f60202f = map;
        this.f60200d = str;
    }

    @Override // p764x6.AbstractC13709a
    /* renamed from: a */
    public void mo80117a() {
        C13533a c13533a = this.f60207k;
        if (c13533a != null) {
            c13533a.cancel();
        }
    }

    @Override // p764x6.AbstractC13709a
    /* renamed from: b */
    public String mo80118b() throws C13199p {
        try {
            this.f60201e = C13195l.m79272J().m79290C("com.huawei.hidisk.cloudAlbum", "CommonHttpGet", "");
        } catch (C13194k e10) {
            C1120a.m6676e("CommonHttpClientExecutor", "HmsException: " + e10.getMessage());
            this.f60201e = null;
        }
        return this.f60201e;
    }

    @Override // p764x6.AbstractC13709a
    /* renamed from: c */
    public int mo80119c() {
        return this.f60205i;
    }

    @Override // p764x6.AbstractC13709a
    /* renamed from: d */
    public T mo77941d(Class<T> cls) throws Exception {
        return (T) new Gson().fromJson(mo80120e(), (Class) cls);
    }

    @Override // p764x6.AbstractC13709a
    /* renamed from: e */
    public String mo80120e() throws Exception {
        if (this.f60197a == null) {
            C1120a.m6677i("CommonHttpClientExecutor", "context is null");
            return null;
        }
        if (TextUtils.isEmpty(this.f60200d)) {
            C1120a.m6678w("CommonHttpClientExecutor", "no traceID, create a default sync traceID");
            this.f60200d = C1122c.m6755Z0("04001");
        }
        if (m80124j()) {
            return null;
        }
        mo80116g();
        while (true) {
            try {
                C1120a.m6675d("CommonHttpClientExecutor", "request: " + this.f60198b);
                C1120a.m6675d("CommonHttpClientExecutor", "request: " + this.f60199c);
                C13533a c13533a = new C13533a(this.f60202f, this.f60201e, this.f60199c, this.f60200d);
                this.f60207k = c13533a;
                String str = this.f60203g ? (String) C11976a.m72084e(this.f60198b, c13533a, 10, 1, null) : (String) C11976a.m72086g(this.f60198b, c13533a, null);
                m80123i(str);
                C1120a.m6675d("CommonHttpClientExecutor", "response: " + str);
                return str;
            } catch (C9721b e10) {
                int iM60659c = e10.m60659c();
                C1120a.m6676e("CommonHttpClientExecutor", "runTask CException, code:" + iM60659c + ", retryCount: " + this.f60206j + "status" + e10.m60663g() + " message:" + e10.getMessage());
                if (!m80126l(iM60659c)) {
                    throw m80125k(e10);
                }
                C1120a.m6676e("CommonHttpClientExecutor", "network disable retry");
                this.f60206j++;
            }
        }
    }

    @Override // p764x6.AbstractC13709a
    /* renamed from: f */
    public void mo80121f(boolean z10) {
        this.f60204h = z10;
    }

    /* renamed from: g */
    public abstract void mo80116g() throws Exception;

    /* renamed from: h */
    public boolean m80122h() {
        try {
            this.f60201e = C13195l.m79272J().m79290C("com.huawei.hidisk.cloudAlbum", "CommonHttpCheck", "");
            return true;
        } catch (C13194k e10) {
            C1120a.m6676e("CommonHttpClientExecutor", "getAccessToken failed e: " + e10.getMessage());
            return false;
        } catch (C13199p e11) {
            if (!C13452e.m80781L().m80842P0()) {
                C1120a.m6678w("CommonHttpClientExecutor", "not login, ignore auth fail.");
                return false;
            }
            C1120a.m6676e("CommonHttpClientExecutor", "setHeader ST auth failed e: " + e11.getMessage());
            CloudAlbumManager.m14456v().m14496m(this.f60197a);
            C1120a.m6677i("CommonHttpClientExecutor", "auth fail, sendBroadCast");
            C13108a.m78878b(this.f60197a).m78881d(new Intent("com.huawei.hicloud.intent.action.CLOUDALBUM_AUTHFAILED"));
            return false;
        }
    }

    /* renamed from: i */
    public void m80123i(String str) throws JSONException {
        String string;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i10 = jSONObject.getInt("code");
            if (803 == i10) {
                try {
                    string = jSONObject.getString("RetryAfterInHeader");
                } catch (JSONException unused) {
                    C1120a.m6676e("CommonHttpClientExecutor", "checkCommonErrorCode getRetryAfterTime json error");
                    string = "";
                }
                C1120a.m6677i("CommonHttpClientExecutor", "retryAfterTime:" + string);
                CloudAlbumManager.m14456v().m14465J(C0241z.m1689g(string, 0L));
            }
            if (800 == i10 || 801 == i10) {
                C14163d.m84990g().m85019y(i10);
            }
            if (4031 == i10) {
                C1120a.m6677i("CommonHttpClientExecutor", "the owner has been migrated");
                Bundle bundle = new Bundle();
                bundle.putInt("Code", 138);
                C2414a.m15051l().sendMessage(9091, bundle);
                C2414a.m15051l().sendMessage(9093, bundle);
            }
        } catch (JSONException unused2) {
            C1120a.m6676e("CommonHttpClientExecutor", "checkCommonErrorCode get code json error");
        }
    }

    /* renamed from: j */
    public final boolean m80124j() {
        if (m80122h()) {
            return false;
        }
        C1120a.m6678w("CommonHttpClientExecutor", "check AT return null");
        return true;
    }

    /* renamed from: k */
    public final C13359f m80125k(C9721b c9721b) {
        int iM60659c = c9721b.m60659c();
        if (iM60659c == 9000) {
            this.f60205i = c9721b.m60663g();
            return new C13359f(String.valueOf(this.f60205i), c9721b.getMessage());
        }
        this.f60205i = iM60659c;
        HashMap<Integer, String> map = f60196l;
        return map.containsKey(Integer.valueOf(iM60659c)) ? new C13359f(map.get(Integer.valueOf(iM60659c)), c9721b.getMessage()) : new C13359f("1007", c9721b.getMessage());
    }

    /* renamed from: l */
    public final boolean m80126l(int i10) {
        if (!this.f60204h || this.f60203g || i10 != 1199 || this.f60206j >= 1) {
            return false;
        }
        SystemClock.sleep(10000L);
        return CloudAlbumSettings.m14363h().m14380p() ? C0209d.m1333z1(this.f60197a) : C0209d.m1254f2(this.f60197a);
    }
}
