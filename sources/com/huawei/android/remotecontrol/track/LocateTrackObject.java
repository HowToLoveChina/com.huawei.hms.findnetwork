package com.huawei.android.remotecontrol.track;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.huawei.android.remotecontrol.config.RequestModeConfig;
import com.huawei.android.remotecontrol.http.C4346d;
import com.huawei.android.remotecontrol.util.account.bean.AccountInfo;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import eg.AbstractC9478g;
import org.json.JSONException;
import org.json.JSONObject;
import p521og.C11870c;
import p616rk.C12515a;
import p809yg.C13981a;
import pg.AbstractC12139d;

/* loaded from: classes4.dex */
public abstract class LocateTrackObject {

    /* renamed from: a */
    public int f20346a = 0;

    /* renamed from: b */
    public Object f20347b = null;

    /* renamed from: c */
    public Context f20348c;

    /* renamed from: com.huawei.android.remotecontrol.track.LocateTrackObject$a */
    public class C4437a extends AbstractC9478g {

        /* renamed from: a */
        public final /* synthetic */ int f20349a;

        /* renamed from: b */
        public final /* synthetic */ Object f20350b;

        /* renamed from: c */
        public final /* synthetic */ Context f20351c;

        /* renamed from: d */
        public final /* synthetic */ Handler.Callback f20352d;

        public C4437a(int i10, Object obj, Context context, Handler.Callback callback) {
            this.f20349a = i10;
            this.f20350b = obj;
            this.f20351c = context;
            this.f20352d = callback;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws JSONException {
            C13981a.m83989i("LocateTrackObject", "handleControlResult task  start");
            JSONObject jSONObjectM26917c = LocateTrackObject.this.m26917c(this.f20349a, this.f20350b, this.f20351c);
            if (jSONObjectM26917c != null) {
                String string = jSONObjectM26917c.toString();
                RequestModeConfig.getInstance().setMode(3, false);
                C4346d.m26225d(3, string, this.f20352d, this.f20351c);
            }
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.track.LocateTrackObject$b */
    public static class C4438b implements Handler.Callback {

        /* renamed from: a */
        public Handler.Callback f20354a;

        /* renamed from: b */
        public int f20355b;

        /* renamed from: c */
        public Context f20356c;

        public C4438b(Handler.Callback callback, int i10, Context context) {
            this.f20354a = callback;
            this.f20355b = i10;
            this.f20356c = context;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            Handler.Callback callback = this.f20354a;
            if (callback != null) {
                callback.handleMessage(message);
            }
            C13981a.m83990w("LocateTrackObject", "locate track report errCode :" + this.f20355b);
            return false;
        }
    }

    public LocateTrackObject(Context context) {
        this.f20348c = context;
    }

    /* renamed from: b */
    public void m26916b(LocateTrackEvent locateTrackEvent) {
        C4443e.m26978b(this.f20348c, locateTrackEvent, null);
    }

    /* renamed from: c */
    public final JSONObject m26917c(int i10, Object obj, Context context) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            AccountInfo accountInfoM72766e = AbstractC12139d.m72766e(context);
            jSONObject.put("operation", "Trackreport");
            jSONObject.put("sessionID", C4450l.m27008d(this.f20348c));
            jSONObject.put("result", i10);
            jSONObject.put("deviceID", accountInfoM72766e.getDeviceID());
            jSONObject.put(JsbMapKeyNames.H5_DEVICE_TYPE, accountInfoM72766e.getDeviceType());
            jSONObject.put("deviceTicket", C11870c.m71153a(accountInfoM72766e.getDeviceTicket()));
            jSONObject.put("result", i10);
            if (context != null && "com.huawei.hidisk".equals(context.getPackageName())) {
                jSONObject.put("appType", 2);
            } else if (context == null || !"com.huawei.android.ds".equals(context.getPackageName())) {
                jSONObject.put("appType", 1);
            } else {
                jSONObject.put("appType", 0);
            }
            jSONObject.put("serviceToken", C11870c.m71155c(accountInfoM72766e.getServiceToken()));
            if (obj != null) {
                jSONObject.put("tracks", obj);
            }
            jSONObject.put("version", "v11");
            return jSONObject;
        } catch (JSONException unused) {
            C13981a.m83988e("LocateTrackObject", "encaseControlResult JSONException");
            return null;
        }
    }

    /* renamed from: d */
    public void m26918d(Handler.Callback callback) {
        m26919e(new C4438b(callback, this.f20346a, this.f20348c), this.f20346a, this.f20347b, this.f20348c);
    }

    /* renamed from: e */
    public final void m26919e(Handler.Callback callback, int i10, Object obj, Context context) {
        C12515a.m75110o().m75175e(new C4437a(i10, obj, context, callback), false);
        C13981a.m83989i("LocateTrackObject", "handleControlResult task  add");
    }

    /* renamed from: f */
    public abstract void mo26868f();

    /* renamed from: g */
    public void m26920g() {
        m26921h(this.f20348c);
    }

    /* renamed from: h */
    public void m26921h(Context context) {
        m26919e(new C4438b(null, 4, context), 4, null, context);
    }

    /* renamed from: i */
    public abstract void mo26869i();
}
