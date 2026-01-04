package p520of;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.android.remotecontrol.config.ParamConfig;
import com.huawei.android.remotecontrol.http.C4347e;
import com.huawei.hicloud.notification.log.NotifyLogger;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0213f;
import p015ak.C0241z;
import p521og.C11877j;
import p611rf.C12505m;
import p809yg.C13981a;

/* renamed from: of.b */
/* loaded from: classes4.dex */
public class C11852b {

    /* renamed from: a */
    public volatile boolean f54874a;

    /* renamed from: of.b$b */
    public static class b {

        /* renamed from: a */
        public static final C11852b f54875a = new C11852b();
    }

    /* renamed from: b */
    public static C11852b m70957b() {
        return b.f54875a;
    }

    /* renamed from: c */
    public synchronized boolean m70958c(Context context) {
        try {
            C13981a.m83989i("ClientPublicKeyManager", "checkClientTaKey");
            if (m70960e(context)) {
                m70963h(true);
            } else {
                m70963h(false);
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                C11866p.m71111j(new Handler.Callback() { // from class: of.a
                    @Override // android.os.Handler.Callback
                    public final boolean handleMessage(Message message) {
                        return this.f54872a.m70961f(countDownLatch, message);
                    }
                });
                try {
                    C13981a.m83987d("ClientPublicKeyManager", "countDownLatch await: " + countDownLatch.await(50L, TimeUnit.SECONDS));
                } catch (InterruptedException unused) {
                    C13981a.m83988e("ClientPublicKeyManager", "countDownLatch exception");
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.f54874a;
    }

    /* renamed from: d */
    public boolean m70959d(Context context) throws InterruptedException {
        C13981a.m83989i("ClientPublicKeyManager", "getPushSignPKAndRetry");
        boolean zM70958c = false;
        for (int i10 = 0; i10 < 3 && !(zM70958c = m70957b().m70958c(context)); i10++) {
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e10) {
                NotifyLogger.m29914e("ClientPublicKeyManager", "getPushSignPKAndRetry err:" + e10.getMessage());
            }
        }
        return zM70958c;
    }

    /* renamed from: e */
    public boolean m70960e(Context context) {
        String strM71305t = C11877j.m71305t(context);
        String strM71308u = C11877j.m71308u(context);
        if (!TextUtils.isEmpty(strM71305t) && !TextUtils.isEmpty(strM71308u)) {
            return true;
        }
        C13981a.m83990w("ClientPublicKeyManager", "pk is empty");
        return false;
    }

    /* renamed from: f */
    public final /* synthetic */ boolean m70961f(CountDownLatch countDownLatch, Message message) {
        m70962g(message);
        countDownLatch.countDown();
        return false;
    }

    /* renamed from: g */
    public final void m70962g(Message message) {
        C13981a.m83989i("ClientPublicKeyManager", "onUpdateQueryParams");
        int iM1685c = C0241z.m1685c(message.getData().getString("result"));
        if (iM1685c != 200) {
            C13981a.m83988e("ClientPublicKeyManager", "onUpdateQueryParams error, result: " + iM1685c);
            return;
        }
        String string = message.getData().getString("response_info");
        int iM26233d = C4347e.m26233d(string);
        C13981a.m83989i("ClientPublicKeyManager", "onUpdateQueryParams, resultCode: " + iM26233d);
        if (iM26233d != 0) {
            if (iM26233d == 401) {
                C13981a.m83989i("ClientPublicKeyManager", "onUpdateQueryParams: getParameter");
                new C12505m().m75087f();
                return;
            }
            return;
        }
        try {
            ParamConfig.getInstance().upDateParam((JSONObject) new JSONObject(string).get("params"));
            if (m70960e(C0213f.m1377a())) {
                m70963h(true);
            }
        } catch (JSONException e10) {
            C13981a.m83988e("ClientPublicKeyManager", "onUpdateQueryParams:JSONException=" + e10.getMessage());
        }
    }

    /* renamed from: h */
    public final void m70963h(boolean z10) {
        C13981a.m83987d("ClientPublicKeyManager", "setPushSignPKStatus: " + z10);
        this.f54874a = z10;
    }

    public C11852b() {
        this.f54874a = false;
    }
}
