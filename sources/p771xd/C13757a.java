package p771xd;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.huawei.updatesdk.service.appmgr.bean.ApkUpgradeInfo;
import ge.C9908c;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import p015ak.C0213f;
import p514o9.C11829c;
import p514o9.C11839m;
import p616rk.C12515a;
import p783xp.C13843a;

/* renamed from: xd.a */
/* loaded from: classes3.dex */
public class C13757a {

    /* renamed from: c */
    public static boolean f61857c;

    /* renamed from: a */
    public CountDownLatch f61858a;

    /* renamed from: b */
    public Handler f61859b = new a(Looper.getMainLooper());

    /* renamed from: xd.a$a */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            C11839m.m70688i("AppMarketUpdateManager", "mOnlineUpdateHandler msg:" + message.what);
            int i10 = message.what;
            if (i10 == 1) {
                C13757a.this.m82649f(message.obj);
            } else if (i10 != 2) {
                C13757a.this.m82650g(message);
            } else {
                C13757a.this.m82648e();
            }
        }
    }

    /* renamed from: h */
    public static boolean m82645h() {
        return f61857c;
    }

    /* renamed from: i */
    public static void m82646i(boolean z10) {
        f61857c = z10;
    }

    /* renamed from: d */
    public void m82647d() {
        C11839m.m70688i("AppMarketUpdateManager", "checkAppMarketVersion");
        if (m82645h()) {
            C11839m.m70688i("AppMarketUpdateManager", "is updateing");
            return;
        }
        if (!C11829c.m70574f(C0213f.m1377a())) {
            C11839m.m70688i("AppMarketUpdateManager", "no need update");
            return;
        }
        m82646i(true);
        boolean zAwait = false;
        C12515a.m75110o().m75175e(new C13758b(this.f61859b), false);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.f61858a = countDownLatch;
        try {
            zAwait = countDownLatch.await(180L, TimeUnit.SECONDS);
        } catch (InterruptedException e10) {
            C11839m.m70688i("AppMarketUpdateManager", "await exception: " + e10.getMessage());
        }
        C11839m.m70688i("AppMarketUpdateManager", "await result: " + zAwait);
    }

    /* renamed from: e */
    public final void m82648e() {
        CountDownLatch countDownLatch = this.f61858a;
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
        m82646i(false);
    }

    /* renamed from: f */
    public final void m82649f(Object obj) {
        ApkUpgradeInfo apkUpgradeInfo = (ApkUpgradeInfo) obj;
        C11839m.m70688i("AppMarketUpdateManager", "has new vertion: " + apkUpgradeInfo.getVersion_());
        if (C0213f.m1377a() == null) {
            m82648e();
        } else {
            C9908c.m61499D().m61524J(C0213f.m1377a(), this.f61859b, apkUpgradeInfo, C13843a.m83090l());
            C9908c.m61499D().m61542b0();
        }
    }

    /* renamed from: g */
    public final void m82650g(Message message) {
        int i10 = message.what;
        if (i10 == 12) {
            m82648e();
        }
        switch (i10) {
            case 4:
                C11839m.m70688i("AppMarketUpdateManager", "showDownloadProgress: " + message.arg1);
                break;
            case 5:
                C11839m.m70688i("AppMarketUpdateManager", "download finish");
                break;
            case 6:
                m82648e();
                break;
            case 7:
                C11839m.m70688i("AppMarketUpdateManager", "start slient install");
                break;
            case 8:
                C11839m.m70688i("AppMarketUpdateManager", "slient install finish");
                m82648e();
                break;
        }
    }
}
