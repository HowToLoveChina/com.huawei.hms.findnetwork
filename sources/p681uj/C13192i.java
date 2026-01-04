package p681uj;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import com.huawei.cloud.services.drive.DriveScopes;
import com.huawei.feedback.log.BaseLogger;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.api.HuaweiApiClient;
import com.huawei.hms.identity.AddressConstants;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.api.pay.HuaweiPay;
import com.huawei.hms.support.api.sns.HuaweiSns;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import p015ak.C0209d;
import p015ak.C0213f;
import p399jk.AbstractC10896a;
import p581qk.AbstractC12368e;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;
import p846zj.C14306d;
import tj.C13019a;

/* renamed from: uj.i */
/* loaded from: classes5.dex */
public class C13192i implements HuaweiApiClient.ConnectionCallbacks, HuaweiApiClient.OnConnectionFailedListener {

    /* renamed from: g */
    public static final ReentrantLock f59723g = new ReentrantLock();

    /* renamed from: h */
    public static final ReentrantLock f59724h;

    /* renamed from: i */
    public static final Condition f59725i;

    /* renamed from: j */
    public static C13192i f59726j;

    /* renamed from: a */
    public HuaweiApiClient f59727a;

    /* renamed from: b */
    public int f59728b;

    /* renamed from: c */
    public boolean f59729c = false;

    /* renamed from: d */
    public boolean f59730d = false;

    /* renamed from: e */
    public int f59731e = -1;

    /* renamed from: f */
    public AbstractC12368e f59732f = new b();

    /* renamed from: uj.i$b */
    public class b extends AbstractC12368e {
        public b() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            C13192i.f59724h.lock();
            try {
                if (C13192i.this.f59727a != null && !C13192i.this.f59727a.isConnecting()) {
                    C13192i.f59725i.signalAll();
                    return;
                }
                BaseLogger.m28735w("HmsApiConnector", "lockNotify client can not notify");
            } finally {
                C13192i.f59724h.unlock();
            }
        }

        @Override // p581qk.AbstractC12368e, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.HMS_CONNECT_LOCK_NOTIFY_SINGLE;
        }
    }

    /* renamed from: uj.i$c */
    public static class c implements Runnable {

        /* renamed from: a */
        public WeakReference<Activity> f59734a;

        /* renamed from: b */
        public int f59735b;

        /* renamed from: c */
        public Intent f59736c;

        public c(Activity activity, int i10, Intent intent) {
            this.f59734a = new WeakReference<>(activity);
            this.f59735b = i10;
            this.f59736c = intent;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Activity activity = this.f59734a.get();
                if (activity != null) {
                    activity.startActivityForResult(this.f59736c, this.f59735b);
                } else {
                    BaseLogger.m28731e("HmsApiConnector", "weakReference is recovered");
                }
            } catch (Exception unused) {
                BaseLogger.m28735w("HmsApiConnector", "resolveHmsErrorByUser error");
            }
        }
    }

    static {
        ReentrantLock reentrantLock = new ReentrantLock();
        f59724h = reentrantLock;
        f59725i = reentrantLock.newCondition();
        f59726j = new C13192i();
    }

    /* renamed from: g */
    public static C13192i m79258g() {
        return f59726j;
    }

    /* renamed from: d */
    public int m79259d() {
        AbstractC10896a.m65887i("HmsApiConnector", "checkHmsUsable, isResolvingError=" + this.f59729c);
        m79267m(true);
        if (m79260e() == null) {
            return this.f59731e == 2 ? 2 : -1;
        }
        m79261f();
        return 0;
    }

    /* renamed from: e */
    public HuaweiApiClient m79260e() {
        ReentrantLock reentrantLock = f59723g;
        reentrantLock.lock();
        try {
            if (this.f59727a == null) {
                m79262h();
            }
            if (this.f59727a.isConnected()) {
                this.f59728b++;
                HuaweiApiClient huaweiApiClient = this.f59727a;
                reentrantLock.unlock();
                return huaweiApiClient;
            }
            if (!this.f59727a.isConnected()) {
                if (!this.f59727a.isConnecting()) {
                    AbstractC10896a.m65887i("HmsApiConnector", "Connect to Huawei Api Client");
                    this.f59731e = -1;
                    this.f59727a.connect((Activity) null);
                }
                m79268n();
            }
            if (!this.f59727a.isConnected()) {
                this.f59727a = null;
                reentrantLock.unlock();
                return null;
            }
            this.f59728b++;
            HuaweiApiClient huaweiApiClient2 = this.f59727a;
            reentrantLock.unlock();
            return huaweiApiClient2;
        } catch (Throwable th2) {
            f59723g.unlock();
            throw th2;
        }
    }

    /* renamed from: f */
    public void m79261f() {
        ReentrantLock reentrantLock = f59723g;
        reentrantLock.lock();
        try {
            int i10 = this.f59728b;
            if (i10 > 0) {
                this.f59728b = i10 - 1;
            }
            if (this.f59727a == null) {
                BaseLogger.m28735w("HmsApiConnector", "disconnectFromHms client is null");
                reentrantLock.unlock();
                return;
            }
            if (this.f59728b <= 0) {
                AbstractC10896a.m65887i("HmsApiConnector", "disconnectFromHms");
                this.f59728b = 0;
                if (this.f59727a.isConnected() || this.f59727a.isConnecting()) {
                    this.f59727a.disconnect();
                    this.f59727a = null;
                }
            }
            reentrantLock.unlock();
        } catch (Throwable th2) {
            f59723g.unlock();
            throw th2;
        }
    }

    /* renamed from: h */
    public final void m79262h() {
        this.f59727a = new HuaweiApiClient.Builder(C0213f.m1377a()).addApi(HuaweiSns.API).addScope(HuaweiSns.SCOPE_SNS_READ).addScope(HuaweiSns.SCOPE_SNS_WRITE).addScope(C13193j.f59737a).addScope(HuaweiSns.SCOPE_SNS_FRIENDS_ACCOUNT).addScope(new Scope(C13193j.f59738b)).addScope(new Scope(DriveScopes.SCOPE_DRIVE)).addScope(new Scope(DriveScopes.SCOPE_DRIVE_APPDATA)).addApi(HuaweiPay.PAY_API).addConnectionCallbacks(this).addOnConnectionFailedListener(this).build();
    }

    /* renamed from: i */
    public boolean m79263i() {
        return this.f59729c;
    }

    /* renamed from: j */
    public final boolean m79264j(Activity activity, int i10) {
        if (activity == null || activity.isDestroyed()) {
            AbstractC10896a.m65887i("HmsApiConnector", "activity is invalid " + activity);
            return false;
        }
        if (this.f59730d) {
            AbstractC10896a.m65887i("HmsApiConnector", "hicloud guide  running");
            return false;
        }
        if (!C14306d.m85206g(activity)) {
            AbstractC10896a.m65887i("HmsApiConnector", "hw account is not login");
            return false;
        }
        if (!HuaweiApiAvailability.getInstance().isUserResolvableError(i10)) {
            AbstractC10896a.m65887i("HmsApiConnector", "user can not resolve the error");
            return false;
        }
        if (!this.f59729c && C0209d.m1181J0(activity)) {
            return true;
        }
        AbstractC10896a.m65887i("HmsApiConnector", "onConnectionFailed, isresolving or noRunningForground.");
        return false;
    }

    /* renamed from: k */
    public void m79265k(Activity activity, int i10, int i11, int i12) {
        if (activity == null) {
            AbstractC10896a.m65887i("HmsApiConnector", "resolveHmsErrorByUser activity is null.");
            return;
        }
        AbstractC10896a.m65887i("HmsApiConnector", "resolveHmsErrorByUser = ,requestCode=" + i10 + ",errorCode=" + i11 + ",entryType=" + i12);
        Intent intent = new Intent();
        intent.setClassName("com.huawei.hidisk", "com.huawei.android.hicloud.commonlib.hms.ui.HmsUpdateActivity");
        intent.putExtra(AddressConstants.Extras.EXTRA_NAME_ERR_CODE, i11);
        intent.putExtra("enterType", i12);
        if (i12 == 0) {
            this.f59729c = true;
        } else {
            m79267m(true);
        }
        activity.runOnUiThread(new c(activity, i10, intent));
    }

    /* renamed from: l */
    public void m79266l(boolean z10) {
        this.f59729c = z10;
    }

    /* renamed from: m */
    public void m79267m(boolean z10) {
        AbstractC10896a.m65887i("HmsApiConnector", "setQueryingModuleInfo, isQueryingModuleInfo=" + z10);
        this.f59730d = z10;
    }

    /* renamed from: n */
    public final void m79268n() {
        ReentrantLock reentrantLock = f59724h;
        reentrantLock.lock();
        try {
            try {
                if (this.f59727a.isConnecting()) {
                    BaseLogger.m28729d("HmsApiConnector", "waitForResult CONDITION.await is  " + f59725i.await(20L, TimeUnit.SECONDS));
                }
                reentrantLock.unlock();
            } catch (InterruptedException e10) {
                BaseLogger.m28731e("HmsApiConnector", "waitForResult error is " + e10.toString());
                f59724h.unlock();
            }
        } catch (Throwable th2) {
            f59724h.unlock();
            throw th2;
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient.ConnectionCallbacks
    public void onConnected() {
        AbstractC10896a.m65887i("HmsApiConnector", "onConnected");
        C12515a.m75110o().m75172d(this.f59732f);
    }

    @Override // com.huawei.hms.api.HuaweiApiClient.OnConnectionFailedListener
    @SuppressLint({"NewApi"})
    public void onConnectionFailed(ConnectionResult connectionResult) {
        int errorCode = connectionResult.getErrorCode();
        this.f59731e = errorCode;
        AbstractC10896a.m65887i("HmsApiConnector", "onConnectionFailed, ErrorCode=" + errorCode + ",isResolvingError=" + this.f59729c);
        Activity activityM78351m = C13019a.m78347n().m78351m();
        if (m79264j(activityM78351m, errorCode)) {
            m79265k(activityM78351m, 10019, errorCode, 0);
            C13019a.m78347n().m78357t(activityM78351m);
        }
        C12515a.m75110o().m75172d(this.f59732f);
    }

    @Override // com.huawei.hms.api.HuaweiApiClient.ConnectionCallbacks
    public void onConnectionSuspended(int i10) {
        AbstractC10896a.m65887i("HmsApiConnector", "onConnectionSuspended");
    }
}
