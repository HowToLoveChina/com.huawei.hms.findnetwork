package p252e9;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.huawei.cloud.pay.model.GetFreePackageResp;
import com.huawei.hicloud.notification.manager.NotificationBIReportUtil;
import com.huawei.hicloud.notification.manager.NotificationReportUtil;
import fj.C9713b;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import p336he.C10155f;
import p514o9.C11839m;
import p709vj.C13452e;

/* renamed from: e9.n */
/* loaded from: classes3.dex */
public class C9437n {

    /* renamed from: a */
    public boolean f47137a;

    /* renamed from: b */
    public boolean f47138b;

    /* renamed from: c */
    public boolean f47139c;

    /* renamed from: e9.n$a */
    public class a extends Handler {

        /* renamed from: a */
        public final /* synthetic */ long f47140a;

        /* renamed from: b */
        public final /* synthetic */ CountDownLatch f47141b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Looper looper, long j10, CountDownLatch countDownLatch) {
            super(looper);
            this.f47140a = j10;
            this.f47141b = countDownLatch;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            C11839m.m70688i("SpaceExperienceGiftManager", "interval time: " + (System.currentTimeMillis() - this.f47140a));
            if (message.what != 7048) {
                this.f47141b.countDown();
                C9437n.this.m59195h(message);
            } else {
                C9437n.this.m59196i(message);
                this.f47141b.countDown();
            }
        }
    }

    /* renamed from: e9.n$b */
    public static class b {

        /* renamed from: a */
        public static final C9437n f47143a = new C9437n(null);
    }

    public /* synthetic */ C9437n(a aVar) {
        this();
    }

    /* renamed from: e */
    public static C9437n m59190e() {
        return b.f47143a;
    }

    /* renamed from: c */
    public void m59191c() {
        boolean zM63256I = C10155f.m63256I();
        C11839m.m70688i("SpaceExperienceGiftManager", "checkAndGetFreePackage, mGetFreePackageFlag = " + this.f47137a + ", featureSwitch = " + zM63256I);
        if (C13452e.m80781L().m80803F0().booleanValue()) {
            if (!this.f47137a || !zM63256I) {
                C11839m.m70687e("SpaceExperienceGiftManager", "checkAndGetFreePackage, condition not fit");
                return;
            }
            this.f47137a = false;
        } else if (!zM63256I) {
            C11839m.m70688i("SpaceExperienceGiftManager", "checkAndGetFreePackage, featureSwitch close");
            return;
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        C9713b.m60566c().m60568b(new a(Looper.getMainLooper(), System.currentTimeMillis(), countDownLatch), true);
        try {
            if (countDownLatch.await(30L, TimeUnit.SECONDS)) {
                return;
            }
            C11839m.m70686d("SpaceExperienceGiftManager", "wait not finish");
        } catch (InterruptedException unused) {
            C11839m.m70689w("SpaceExperienceGiftManager", "checkAndGetFreePackage catch InterruptedException.");
        }
    }

    /* renamed from: d */
    public boolean m59192d() {
        return C13452e.m80781L().m80786B();
    }

    /* renamed from: f */
    public boolean m59193f() {
        return C13452e.m80781L().m80782A();
    }

    /* renamed from: g */
    public boolean m59194g() {
        return this.f47139c;
    }

    /* renamed from: h */
    public final void m59195h(Message message) {
        int i10 = message.arg1;
        Object obj = message.obj;
        m59197j(String.valueOf(i10), obj instanceof String ? (String) obj : "");
    }

    /* renamed from: i */
    public final void m59196i(Message message) {
        Object obj = message.obj;
        if (!(obj instanceof GetFreePackageResp)) {
            C11839m.m70687e("SpaceExperienceGiftManager", "checkAndGetFreePackage, getFreepackageresp is null");
            return;
        }
        GetFreePackageResp getFreePackageResp = (GetFreePackageResp) obj;
        int resultCode = getFreePackageResp.getResultCode();
        boolean zM63289m = C10155f.m63289m();
        C11839m.m70688i("SpaceExperienceGiftManager", "isExperienceGiftValid: " + zM63289m);
        if (resultCode == 0) {
            C11839m.m70688i("SpaceExperienceGiftManager", "checkAndGetFreePackage, success");
            if (C13452e.m80781L().m80803F0().booleanValue() && zM63289m) {
                m59201n(true);
            } else {
                m59200m(true);
            }
            m59198k();
            return;
        }
        String resultDesc = getFreePackageResp.getResultDesc();
        C11839m.m70687e("SpaceExperienceGiftManager", "checkAndGetFreePackage, error code: " + resultCode + "desc: " + resultDesc);
        m59197j(String.valueOf(resultCode), resultDesc);
    }

    /* renamed from: j */
    public final void m59197j(String str, String str2) {
        NotificationBIReportUtil.reportGetFreePackageFail(str, str2);
        NotificationReportUtil.reportGetFreePackageFail(str, str2);
    }

    /* renamed from: k */
    public final void m59198k() {
        NotificationBIReportUtil.reportGetFreePackageSuccess();
        NotificationReportUtil.reportGetFreePackageSuccess();
    }

    /* renamed from: l */
    public void m59199l(boolean z10) {
        this.f47137a = z10;
    }

    /* renamed from: m */
    public void m59200m(boolean z10) {
        C13452e.m80781L().m80875X1(z10);
    }

    /* renamed from: n */
    public void m59201n(boolean z10) {
        C13452e.m80781L().m80879Y1(z10);
    }

    /* renamed from: o */
    public void m59202o(boolean z10) {
        this.f47139c = z10;
    }

    public C9437n() {
        this.f47137a = false;
        this.f47138b = false;
        this.f47139c = false;
    }
}
