package com.huawei.android.hicloud.task.storage;

import com.huawei.android.hicloud.task.storage.GetSpaceOptDataTask;
import java.util.concurrent.CountDownLatch;
import p514o9.C11839m;
import p610rd.C12489b;
import p610rd.C12490c;
import p610rd.C12491d;
import p616rk.C12515a;

/* renamed from: com.huawei.android.hicloud.task.storage.a */
/* loaded from: classes3.dex */
public class C3104a {

    /* renamed from: a */
    public GetSpaceOptDataTask f13423a;

    /* renamed from: b */
    public C12491d f13424b;

    /* renamed from: c */
    public C12489b f13425c;

    /* renamed from: d */
    public C12490c f13426d;

    /* renamed from: com.huawei.android.hicloud.task.storage.a$a */
    public static class a {

        /* renamed from: a */
        public static final C3104a f13427a = new C3104a();
    }

    /* renamed from: f */
    public static C3104a m18459f() {
        return a.f13427a;
    }

    /* renamed from: a */
    public void m18460a() {
        if (this.f13423a == null) {
            C11839m.m70686d("CloudDiskGetSpaceDataManager", "cancelGetSpaceOptDataTask task is null.");
        } else {
            C12515a.m75110o().m75166b(this.f13423a.getClass().getName());
        }
    }

    /* renamed from: b */
    public void m18461b(GetSpaceOptDataTask.Callback callback, long j10) {
        GetSpaceOptDataTask getSpaceOptDataTask = new GetSpaceOptDataTask();
        this.f13423a = getSpaceOptDataTask;
        getSpaceOptDataTask.m18454l(callback);
        this.f13423a.m18455m(j10);
        C12515a.m75110o().m75172d(this.f13423a);
    }

    /* renamed from: c */
    public void m18462c(CountDownLatch countDownLatch, long j10) {
        C12489b c12489b = new C12489b(j10);
        this.f13425c = c12489b;
        c12489b.setCount(countDownLatch);
        C12515a.m75110o().m75172d(this.f13425c);
    }

    /* renamed from: d */
    public void m18463d(CountDownLatch countDownLatch, long j10) {
        C12490c c12490c = new C12490c(j10);
        this.f13426d = c12490c;
        c12490c.setCount(countDownLatch);
        C12515a.m75110o().m75172d(this.f13426d);
    }

    /* renamed from: e */
    public void m18464e(CountDownLatch countDownLatch, long j10) {
        C12491d c12491d = new C12491d(j10);
        this.f13424b = c12491d;
        c12491d.setCount(countDownLatch);
        C12515a.m75110o().m75172d(this.f13424b);
    }

    /* renamed from: g */
    public boolean m18465g() {
        return (this.f13423a == null || !C12515a.m75110o().m75158X0(this.f13423a.getClass().getName()) || this.f13423a.m18451h()) ? false : true;
    }

    /* renamed from: h */
    public boolean m18466h() {
        return (this.f13425c == null || !C12515a.m75110o().m75158X0(this.f13425c.getClass().getName()) || this.f13425c.m74969e()) ? false : true;
    }

    /* renamed from: i */
    public boolean m18467i() {
        return (this.f13426d == null || !C12515a.m75110o().m75158X0(this.f13426d.getClass().getName()) || this.f13426d.m74976e()) ? false : true;
    }

    /* renamed from: j */
    public boolean m18468j() {
        return (this.f13424b == null || !C12515a.m75110o().m75158X0(this.f13424b.getClass().getName()) || this.f13424b.m74979d()) ? false : true;
    }

    /* renamed from: k */
    public boolean m18469k() {
        C12489b c12489b = this.f13425c;
        if (c12489b == null) {
            return false;
        }
        return c12489b.m74967c();
    }

    /* renamed from: l */
    public boolean m18470l() {
        C12490c c12490c = this.f13426d;
        if (c12490c == null) {
            return false;
        }
        return c12490c.m74975c();
    }

    /* renamed from: m */
    public boolean m18471m() {
        C12491d c12491d = this.f13424b;
        if (c12491d == null) {
            return false;
        }
        return c12491d.m74978c();
    }

    /* renamed from: n */
    public void m18472n(GetSpaceOptDataTask.Callback callback) {
        GetSpaceOptDataTask getSpaceOptDataTask = this.f13423a;
        if (getSpaceOptDataTask == null) {
            C11839m.m70686d("CloudDiskGetSpaceDataManager", "refreshGetSpaceOptDataTaskCallBack task is null.");
        } else {
            getSpaceOptDataTask.m18454l(callback);
        }
    }

    /* renamed from: o */
    public void m18473o(CountDownLatch countDownLatch) {
        C12489b c12489b = this.f13425c;
        if (c12489b == null) {
            C11839m.m70686d("CloudDiskGetSpaceDataManager", "refreshQueryBigFileTask task is null.");
        } else {
            c12489b.setCount(countDownLatch);
        }
    }

    /* renamed from: p */
    public void m18474p(CountDownLatch countDownLatch) {
        C12490c c12490c = this.f13426d;
        if (c12490c == null) {
            C11839m.m70686d("CloudDiskGetSpaceDataManager", "refreshQueryDuplicateFileTask task is null.");
        } else {
            c12490c.setCount(countDownLatch);
        }
    }

    /* renamed from: q */
    public void m18475q(CountDownLatch countDownLatch) {
        C12491d c12491d = this.f13424b;
        if (c12491d == null) {
            C11839m.m70686d("CloudDiskGetSpaceDataManager", "refreshQueryUnusualDeviceTask task is null.");
        } else {
            c12491d.setCount(countDownLatch);
        }
    }
}
