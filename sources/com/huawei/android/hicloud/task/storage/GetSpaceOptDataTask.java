package com.huawei.android.hicloud.task.storage;

import android.text.TextUtils;
import com.huawei.android.backup.service.logic.C2126b;
import com.huawei.android.hicloud.drive.clouddisk.expand.DriveExpand;
import com.huawei.android.hicloud.drive.clouddisk.expand.SyncDriveRequest;
import com.huawei.cloud.services.drive.model.About;
import fk.C9721b;
import gp.C10028c;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import je.C10810x;
import p015ak.C0209d;
import p252e9.C9428e;
import p363ia.C10463a;
import p429kk.C11058a;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p681uj.C13195l;
import sa.C12766a;

/* loaded from: classes3.dex */
public class GetSpaceOptDataTask extends AbstractC12367d {

    /* renamed from: b */
    public WeakReference<Callback> f13421b;

    /* renamed from: a */
    public long f13420a = 0;

    /* renamed from: c */
    public volatile boolean f13422c = false;

    public interface Callback {
        /* renamed from: a */
        void mo18457a();

        /* renamed from: b */
        void mo18458b(int i10);
    }

    /* renamed from: c */
    public final int m18446c(boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15) {
        if (!z10) {
            z11 = true;
        }
        if (!z12) {
            z13 = true;
        }
        if (!z14) {
            z15 = true;
        }
        C11839m.m70688i("GetSpaceOptDataTask", "query result Unusual: " + z11 + ", BigFile: " + z13 + ", Duplicate: " + z15);
        return (z11 && z13 && z15) ? 1 : 0;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        C11839m.m70688i("GetSpaceOptDataTask", "begin call");
        m18456n();
        if (!C0209d.m1269j1() && C10810x.m65815k(this.f13420a, C10028c.m62182c0().m62302a0())) {
            m18448e();
        }
        boolean zM65810f = C10810x.m65810f(this.f13420a);
        boolean zM65808d = C10810x.m65808d(this.f13420a);
        boolean zM65809e = C10810x.m65809e(this.f13420a);
        CountDownLatch countDownLatch = new CountDownLatch(m18450g(zM65810f, zM65808d, zM65809e));
        if (zM65810f) {
            C11839m.m70688i("GetSpaceOptDataTask", "queryUnusualDeviceTask start,isQueryUnusualDeviceRunning=" + C3104a.m18459f().m18468j());
            if (C3104a.m18459f().m18468j()) {
                C11839m.m70688i("GetSpaceOptDataTask", "queryUnusualDeviceTask isQueryUnusualDeviceRunning");
                C3104a.m18459f().m18475q(countDownLatch);
            } else {
                C3104a.m18459f().m18464e(countDownLatch, this.f13420a);
            }
        }
        if (zM65808d) {
            C11839m.m70688i("GetSpaceOptDataTask", "queryBigFileTask start,isQueryBigFileRunning=" + C3104a.m18459f().m18466h());
            if (C3104a.m18459f().m18466h()) {
                C11839m.m70688i("GetSpaceOptDataTask", "queryBigFileTask isQueryBigFileRunning");
                C3104a.m18459f().m18473o(countDownLatch);
            } else {
                C3104a.m18459f().m18462c(countDownLatch, this.f13420a);
            }
        }
        if (zM65809e) {
            C11839m.m70688i("GetSpaceOptDataTask", "queryDuplicateFileTask start,isQueryDuplicateFileRunning=" + C3104a.m18459f().m18467i());
            if (C3104a.m18459f().m18467i()) {
                C11839m.m70688i("GetSpaceOptDataTask", "queryDuplicateFileTask isQueryDuplicateFileRunning");
                C3104a.m18459f().m18474p(countDownLatch);
            } else {
                C3104a.m18459f().m18463d(countDownLatch, this.f13420a);
            }
        }
        int iM18446c = 0;
        try {
            try {
                if (countDownLatch.await(10000L, TimeUnit.MILLISECONDS)) {
                    iM18446c = m18446c(zM65810f, C3104a.m18459f().m18471m(), zM65808d, C3104a.m18459f().m18469k(), zM65809e, C3104a.m18459f().m18470l());
                    C11839m.m70688i("GetSpaceOptDataTask", "query clean space threads is finish, resultFlag = " + iM18446c);
                }
            } catch (InterruptedException e10) {
                C11839m.m70687e("GetSpaceOptDataTask", "exception: " + e10.getMessage());
            }
        } finally {
            this.f13422c = true;
            C11839m.m70688i("GetSpaceOptDataTask", "end call");
            m18447d(iM18446c);
        }
    }

    @Override // p616rk.AbstractRunnableC12516b
    public boolean cancel() {
        C11839m.m70688i("GetSpaceOptDataTask", "task cancel.");
        this.f13422c = true;
        return super.cancel();
    }

    /* renamed from: d */
    public final void m18447d(int i10) {
        WeakReference<Callback> weakReference = this.f13421b;
        if (weakReference == null) {
            C11839m.m70688i("GetSpaceOptDataTask", "getSpaceDataTaskEnd mCallback is null.");
            return;
        }
        Callback callback = weakReference.get();
        if (callback == null) {
            C11839m.m70688i("GetSpaceOptDataTask", "getSpaceDataTaskEnd callback is null.");
            return;
        }
        C11839m.m70688i("GetSpaceOptDataTask", "getSpaceDataTaskEnd result = " + i10);
        callback.mo18458b(i10);
    }

    /* renamed from: e */
    public final void m18448e() {
        C11839m.m70688i("GetSpaceOptDataTask", "begin get about");
        try {
            m18449f();
        } catch (Exception e10) {
            C11839m.m70688i("GetSpaceOptDataTask", "disk about exception: " + e10.getMessage());
            String strM66627b = C11058a.m66627b("07039");
            m18452j(strM66627b, "about error: " + e10.getMessage());
            C10028c c10028cM62182c0 = C10028c.m62182c0();
            boolean zM62324f0 = c10028cM62182c0.m62324f0("has_clear_authcode");
            C11839m.m70688i("GetSpaceOptDataTask", "has clear authcode flag: " + zM62324f0);
            if (!C12766a.m76616e(403, "4035", e10) || zM62324f0) {
                return;
            }
            C11839m.m70688i("GetSpaceOptDataTask", "clear at and retry get about");
            C13195l.m79272J().m79334t();
            C10463a.m64279e().m64286i();
            c10028cM62182c0.m62281U2("has_clear_authcode", true);
            m18453k(strM66627b);
        }
    }

    /* renamed from: f */
    public final void m18449f() throws Exception {
        DriveExpand driveExpandM64282d = C10463a.m64279e().m64282d();
        if (driveExpandM64282d == null) {
            C11839m.m70687e("GetSpaceOptDataTask", "init driveExpand null");
            return;
        }
        String strValueOf = String.valueOf(((About) new SyncDriveRequest(driveExpandM64282d.about().get().setFields2("dataVersion,status")).execute()).get("dataVersion"));
        if (TextUtils.isEmpty(strValueOf)) {
            return;
        }
        C11839m.m70688i("GetSpaceOptDataTask", "getAbout: " + strValueOf);
        C10028c.m62182c0().m62265Q2(System.currentTimeMillis());
        C10028c.m62182c0().m62256O3(strValueOf);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: g */
    public final int m18450g(boolean z10, boolean z11, boolean z12) {
        int i10 = z10;
        if (z11) {
            i10 = z10 + 1;
        }
        if (z12) {
            i10++;
        }
        C11839m.m70688i("GetSpaceOptDataTask", "time: device=" + C10028c.m62182c0().m62294Y() + ", bigFile=" + C10028c.m62182c0().m62290X() + ", duplicateFile=" + C10028c.m62182c0().m62298Z() + ", task_count=" + i10);
        return i10;
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.GET_SPACE_OPT_DATA;
    }

    /* renamed from: h */
    public boolean m18451h() {
        return this.f13422c;
    }

    /* renamed from: j */
    public final void m18452j(String str, String str2) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(C2126b.ERROR_MESSAGE_INFO, str2);
        C9428e.m59118h().m59135r("query_about", str, linkedHashMap);
    }

    /* renamed from: k */
    public final void m18453k(String str) {
        try {
            m18449f();
        } catch (Exception e10) {
            C11839m.m70688i("GetSpaceOptDataTask", "retry disk about exception: " + e10.getMessage());
            m18452j(str, "retry error: " + e10.getMessage());
        }
    }

    /* renamed from: l */
    public void m18454l(Callback callback) {
        this.f13421b = new WeakReference<>(callback);
    }

    /* renamed from: m */
    public void m18455m(long j10) {
        this.f13420a = j10;
    }

    /* renamed from: n */
    public final void m18456n() {
        WeakReference<Callback> weakReference = this.f13421b;
        if (weakReference == null) {
            C11839m.m70688i("GetSpaceOptDataTask", "getSpaceDataTaskStart mCallback is null.");
            return;
        }
        Callback callback = weakReference.get();
        if (callback == null) {
            C11839m.m70688i("GetSpaceOptDataTask", "getSpaceDataTaskStart callback is null.");
        } else {
            callback.mo18457a();
        }
    }
}
