package p681uj;

import android.os.Looper;
import android.text.TextUtils;
import com.huawei.feedback.log.BaseLogger;
import com.huawei.hicloud.account.util.ATTrafficController;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.support.hwid.result.AuthHuaweiId;
import com.huawei.hms.support.hwid.service.HuaweiIdAuthService;
import com.huawei.hms.videokit.player.common.PlayerConstants;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0213f;
import p015ak.C0214f0;
import p208cq.InterfaceC8938f;
import p208cq.InterfaceC8939g;
import p399jk.AbstractC10896a;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p712vm.C13468a;

/* renamed from: uj.m */
/* loaded from: classes5.dex */
public class C13196m {

    /* renamed from: n */
    public static C13196m f59792n = new C13196m();

    /* renamed from: c */
    public String f59795c;

    /* renamed from: d */
    public String f59796d;

    /* renamed from: g */
    public long f59799g;

    /* renamed from: l */
    public HuaweiIdAuthService f59804l;

    /* renamed from: m */
    public ExecutorService f59805m;

    /* renamed from: a */
    public final ReentrantLock f59793a = new ReentrantLock();

    /* renamed from: b */
    public ReadWriteLock f59794b = new ReentrantReadWriteLock();

    /* renamed from: e */
    public boolean f59797e = false;

    /* renamed from: f */
    public int f59798f = 1;

    /* renamed from: h */
    public CountDownLatch f59800h = null;

    /* renamed from: i */
    public CountDownLatch f59801i = null;

    /* renamed from: j */
    public long f59802j = 0;

    /* renamed from: k */
    public long f59803k = 0;

    /* renamed from: uj.m$a */
    public class a implements InterfaceC8938f {

        /* renamed from: a */
        public final /* synthetic */ String f59806a;

        public a(String str) {
            this.f59806a = str;
        }

        @Override // p208cq.InterfaceC8938f
        public void onFailure(Exception exc) {
            BaseLogger.m28733i("HmsHwIdByWebView", " [AT OPERATION] [" + this.f59806a + "] silentSignIn fail: " + exc.toString());
            C13196m.this.f59801i.countDown();
        }
    }

    /* renamed from: uj.m$b */
    public class b implements InterfaceC8939g<AuthHuaweiId> {
        public b() {
        }

        @Override // p208cq.InterfaceC8939g
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(AuthHuaweiId authHuaweiId) {
            BaseLogger.m28733i("HmsHwIdByWebView", " [AT OPERATION] silentSignIn success");
            C13196m.this.f59801i.countDown();
        }
    }

    /* renamed from: uj.m$c */
    public class c extends AbstractC12367d {

        /* renamed from: uj.m$c$a */
        public class a implements InterfaceC8938f {
            public a() {
            }

            @Override // p208cq.InterfaceC8938f
            public void onFailure(Exception exc) {
                BaseLogger.m28733i("HmsHwIdByWebView", " [AT OPERATION] sign out fail: " + exc.toString());
                if (C13196m.this.f59800h != null) {
                    C13196m.this.f59800h.countDown();
                }
            }
        }

        /* renamed from: uj.m$c$b */
        public class b implements InterfaceC8939g<Void> {
            public b() {
            }

            @Override // p208cq.InterfaceC8939g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(Void r22) {
                BaseLogger.m28733i("HmsHwIdByWebView", " [AT OPERATION] sign out success");
                if (C13196m.this.f59800h != null) {
                    C13196m.this.f59800h.countDown();
                }
            }
        }

        public c() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            BaseLogger.m28733i("HmsHwIdByWebView", " [AT OPERATION]  signOut");
            C13196m.this.f59793a.lock();
            try {
                if (C13196m.this.f59800h == null || C13196m.this.f59800h.getCount() != 1) {
                    C13196m.this.f59800h = new CountDownLatch(1);
                }
                if (C13196m.this.f59804l != null) {
                    C13196m.this.f59804l.signOut().addOnSuccessListener(C13196m.this.f59805m, new b()).addOnFailureListener(C13196m.this.f59805m, new a());
                    C13196m.this.f59793a.unlock();
                } else {
                    AbstractC10896a.m65886e("HmsHwIdByWebView", " [AT OPERATION] signOut failed: IdAuthService null, clear invalid AT.");
                    C13196m.this.f59796d = null;
                    C13196m.this.f59800h.countDown();
                    C13196m.this.f59793a.unlock();
                }
            } catch (Throwable th2) {
                C13196m.this.f59793a.unlock();
                throw th2;
            }
        }
    }

    public C13196m() {
        HuaweiIdAuthService huaweiIdAuthServiceM79392a = C13201r.m79392a();
        this.f59804l = huaweiIdAuthServiceM79392a;
        try {
            huaweiIdAuthServiceM79392a.setSubAppId("104281059");
        } catch (ApiException e10) {
            BaseLogger.m28735w("HmsHwIdByWebView", "HuaweiIdAuthServiceBuilderByWebView ApiException:" + e10.toString());
        }
        this.f59805m = Executors.newSingleThreadExecutor();
    }

    /* renamed from: o */
    public static C13196m m79363o() {
        return f59792n;
    }

    /* renamed from: h */
    public final void m79364h() {
        if (this.f59803k == 0) {
            this.f59803k = C0214f0.m1382b(C0213f.m1377a(), "account_info", 0).getLong("get_at_time_web", 0L);
        }
        BaseLogger.m28729d("HmsHwIdByWebView", "System.currentTimeMillis() - starTimerTime: " + ((System.currentTimeMillis() - this.f59803k) / 1000));
        long jCurrentTimeMillis = System.currentTimeMillis() - this.f59802j;
        if (System.currentTimeMillis() - this.f59803k < 3300000 || jCurrentTimeMillis <= 60000) {
            return;
        }
        this.f59802j = System.currentTimeMillis();
        m79363o().m79375t(this.f59795c);
    }

    /* renamed from: i */
    public final void m79365i() throws C13194k {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.f59799g;
        if (jCurrentTimeMillis <= 0 || jCurrentTimeMillis >= 60000) {
            return;
        }
        throw new C13194k(4001, " [AT OPERATION] getAt Failed. Last network error time: " + this.f59799g);
    }

    /* renamed from: j */
    public void m79366j() {
        BaseLogger.m28733i("HmsHwIdByWebView", "clear AT");
        m79376u(false);
        this.f59795c = null;
        this.f59796d = null;
        m79377v();
    }

    /* renamed from: k */
    public String m79367k() throws C13199p, C13194k {
        return m79368l("");
    }

    /* renamed from: l */
    public String m79368l(String str) throws C13199p, C13194k {
        m79364h();
        if (m79372q()) {
            BaseLogger.m28729d("HmsHwIdByWebView", "getAT return old");
        } else {
            this.f59793a.lock();
            try {
                if (m79372q()) {
                    ATTrafficController.m29104b().m29105a(str);
                } else {
                    BaseLogger.m28729d("HmsHwIdByWebView", "start get AT");
                    m79369m(str);
                }
                this.f59793a.unlock();
                BaseLogger.m28729d("HmsHwIdByWebView", "getAT return new");
            } catch (Throwable th2) {
                this.f59793a.unlock();
                throw th2;
            }
        }
        String str2 = this.f59795c;
        if (str2 == null || str2.isEmpty()) {
            throw new C13194k(4001, "getAT is null.");
        }
        return this.f59795c;
    }

    /* renamed from: m */
    public final void m79369m(String str) throws C13199p, C13194k {
        m79365i();
        for (int i10 = 0; i10 < 3; i10++) {
            BaseLogger.m28733i("HmsHwIdByWebView", " [AT OPERATION] silentSignIn retry times: " + i10);
            try {
            } catch (C13194k e10) {
                C13468a c13468aM81100c = C13468a.m81100c();
                boolean zM81101b = c13468aM81100c.m81101b();
                String str2 = c13468aM81100c.toString() + e10.toString();
                if (!zM81101b) {
                    throw new C13194k(PlayerConstants.ErrorCode.DEFAULT_ERROR, str2);
                }
                if (this.f59798f > 5) {
                    this.f59798f = 1;
                    this.f59799g = System.currentTimeMillis();
                    BaseLogger.m28731e("HmsHwIdByWebView", " [AT OPERATION] MAX_NETWORK_ERROR_RETRY_TIMES, lastNetworkErrorTime = " + System.currentTimeMillis());
                    throw new C13194k(e10.m79269b(), str2);
                }
                if (e10.m79269b() == 2001 || i10 >= 2) {
                    BaseLogger.m28731e("HmsHwIdByWebView", " [AT OPERATION] getAT failed, code = " + e10.m79269b() + ", msg= " + e10.getMessage());
                    throw new C13194k(e10.m79269b(), str2);
                }
                if (e10.m79269b() == 2030) {
                    throw new C13194k(e10.m79269b(), str2);
                }
            }
            if (m79378w(str)) {
                ATTrafficController.m29104b().m29105a(str);
                return;
            }
            continue;
        }
    }

    /* renamed from: n */
    public final void m79370n(AuthHuaweiId authHuaweiId) throws C13194k {
        String accessToken = authHuaweiId.getAccessToken();
        if (accessToken == null || accessToken.isEmpty()) {
            throw new C13194k(4001, " [AT OPERATION] get AT from HMS is empty!");
        }
        if (accessToken.equals(this.f59796d)) {
            BaseLogger.m28735w("HmsHwIdByWebView", " [AT OPERATION] silentSignIn new AT equals old invalid at");
            return;
        }
        BaseLogger.m28733i("HmsHwIdByWebView", " [AT OPERATION] silentSignIn get new AT successfully");
        this.f59795c = accessToken;
        m79374s();
        m79376u(true);
    }

    /* renamed from: p */
    public final String m79371p(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        String strM29107d = ATTrafficController.m29104b().m29107d(str);
        try {
            if (TextUtils.isEmpty(strM29107d)) {
                jSONObject.putOpt("subSrcPackageName", "com.huawei.hidisk.common");
            } else {
                jSONObject.putOpt("subSrcPackageName", strM29107d);
            }
        } catch (JSONException e10) {
            BaseLogger.m28731e("HmsHwIdByWebView", "get param json exception:" + e10.toString());
        }
        return jSONObject.toString();
    }

    /* renamed from: q */
    public final boolean m79372q() {
        this.f59794b.readLock().lock();
        try {
            return this.f59797e;
        } finally {
            this.f59794b.readLock().unlock();
        }
    }

    /* renamed from: r */
    public final void m79373r(Exception exc, String str) throws C13199p, C13194k {
        if (!(exc instanceof ApiException)) {
            BaseLogger.m28731e("HmsHwIdByWebView", " [AT OPERATION] onSignResultError status is null");
            throw new C13194k(4001, "onSignResultError status is null");
        }
        ApiException apiException = (ApiException) exc;
        int statusCode = apiException.getStatusCode();
        BaseLogger.m28731e("HmsHwIdByWebView", " [AT OPERATION] status: " + statusCode + ", networkErrorRetryTimes: " + this.f59798f);
        if (statusCode == 2004 || statusCode == 2002) {
            throw new C13199p(statusCode, " [AT OPERATION] silentSignIn fail, statusCode: " + statusCode + ", MSG: " + apiException.getStatusMessage());
        }
        if (statusCode == 2005) {
            int i10 = this.f59798f + 1;
            this.f59798f = i10;
            if (i10 > 5) {
                this.f59799g = System.currentTimeMillis();
                throw new C13194k(statusCode, " [AT OPERATION] silentSignIn fail, network error is more than 5 times, statusCode: " + statusCode + ", msg: " + apiException.getStatusMessage());
            }
        }
        if (statusCode != 2030) {
            throw new C13194k(statusCode, " [AT OPERATION] silentSignIn fail, statusCode: " + statusCode + ", msg: " + apiException.getStatusMessage());
        }
        BaseLogger.m28733i("HmsHwIdByWebView", "status code in traffic control");
        ATTrafficController.m29104b().m29108e(str);
        throw new C13194k(statusCode, " [AT OPERATION] silentSignIn fail, AT traffic control, statusCode: " + statusCode + ", msg: " + apiException.getStatusMessage());
    }

    /* renamed from: s */
    public final void m79374s() {
        this.f59803k = System.currentTimeMillis();
        C0214f0.m1382b(C0213f.m1377a(), "account_info", 0).edit().putLong("get_at_time_web", this.f59803k).commit();
    }

    /* renamed from: t */
    public void m79375t(String str) {
        this.f59794b.writeLock().lock();
        try {
            if (TextUtils.isEmpty(str)) {
                BaseLogger.m28733i("HmsHwIdByWebView", "oldAccessToken is empty!");
            } else {
                if (!str.equals(this.f59796d)) {
                    BaseLogger.m28733i("HmsHwIdByWebView", "setAtInValid");
                    this.f59796d = str;
                    this.f59797e = false;
                    this.f59794b.writeLock().unlock();
                    m79377v();
                    return;
                }
                BaseLogger.m28733i("HmsHwIdByWebView", "token is already invalid!");
            }
        } finally {
            this.f59794b.writeLock().unlock();
        }
    }

    /* renamed from: u */
    public final void m79376u(boolean z10) {
        BaseLogger.m28729d("HmsHwIdByWebView", "setIsAtValid=" + z10);
        this.f59794b.writeLock().lock();
        try {
            this.f59797e = z10;
        } finally {
            this.f59794b.writeLock().unlock();
        }
    }

    /* renamed from: v */
    public final void m79377v() {
        c cVar = new c();
        if (Looper.myLooper() == Looper.getMainLooper()) {
            C12515a.m75110o().m75172d(cVar);
        } else {
            cVar.run();
        }
    }

    /* renamed from: w */
    public final boolean m79378w(String str) throws C13199p, JSONException, C13194k, InterruptedException {
        BaseLogger.m28733i("HmsHwIdByWebView", " [AT OPERATION] silentSignIn");
        try {
            CountDownLatch countDownLatch = this.f59800h;
            if (countDownLatch != null) {
                BaseLogger.m28729d("HmsHwIdByWebView", " [AT OPERATION] signOutLatch.await: " + countDownLatch.await(3L, TimeUnit.SECONDS));
            }
        } catch (InterruptedException unused) {
            BaseLogger.m28735w("HmsHwIdByWebView", " [AT OPERATION] signOutLatch InterruptedException");
        }
        this.f59800h = null;
        this.f59795c = null;
        if (this.f59804l == null) {
            BaseLogger.m28731e("HmsHwIdByWebView", " [AT OPERATION] silentSignIn failed, IdAuthService null, code = 4002");
            throw new C13194k(4002, "silentSignIn failed, IdAuthService null");
        }
        this.f59801i = new CountDownLatch(1);
        String strM79371p = m79371p(str);
        BaseLogger.m28733i("HmsHwIdByWebView", "params=" + strM79371p);
        try {
            Task<AuthHuaweiId> taskAddOnFailureListener = this.f59804l.silentSignIn(strM79371p).addOnSuccessListener(this.f59805m, new b()).addOnFailureListener(this.f59805m, new a(strM79371p));
            BaseLogger.m28733i("HmsHwIdByWebView", " [AT OPERATION] silentSignInLatch await: " + this.f59801i.await(35L, TimeUnit.SECONDS));
            if (taskAddOnFailureListener.isComplete() && taskAddOnFailureListener.isSuccessful()) {
                m79370n(taskAddOnFailureListener.getResult());
                return true;
            }
            m79373r(taskAddOnFailureListener.getException(), str);
            return false;
        } catch (InterruptedException unused2) {
            BaseLogger.m28735w("HmsHwIdByWebView", " [AT OPERATION] silentSignInLatch report InterruptedException");
            return false;
        }
    }
}
