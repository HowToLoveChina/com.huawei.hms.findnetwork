package p036bl;

import cl.InterfaceC1446a;
import cl.InterfaceC1447b;
import cl.InterfaceC1454i;
import com.huawei.android.hicloud.cloudbackup.process.task.CloudRestoreAgdApiInterface;
import com.huawei.hicloud.cloudbackup.server.model.RestoreApkAgdDownloadState;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.phoneservice.feedbackcommon.utils.AsCache;
import fk.C9721b;
import gl.C9968i;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import je.C10790h;
import p015ak.C0217h;
import p261el.C9500a;
import p291fl.C9725c;
import p514o9.C11839m;

/* renamed from: bl.b */
/* loaded from: classes6.dex */
public class C1251b implements InterfaceC1446a {

    /* renamed from: a */
    public final boolean f5677a;

    /* renamed from: bl.b$a */
    public static class a implements CloudRestoreAgdApiInterface.CloudRestoreAgdApiClientCallback {

        /* renamed from: a */
        public final String f5678a;

        /* renamed from: b */
        public final InterfaceC1447b f5679b;

        /* renamed from: c */
        public final InterfaceC1454i f5680c;

        /* renamed from: d */
        public final C0217h<Boolean> f5681d;

        /* renamed from: h */
        public C9721b f5685h;

        /* renamed from: e */
        public int f5682e = 0;

        /* renamed from: g */
        public final AtomicBoolean f5684g = new AtomicBoolean(false);

        /* renamed from: i */
        public final C9725c.a f5686i = new C14412a();

        /* renamed from: f */
        public final int f5683f = C9500a.m59437a("agdPingTimeout", AsCache.TIME_HOUR);

        /* renamed from: bl.b$a$a, reason: collision with other inner class name */
        public class C14412a implements C9725c.a {
            public C14412a() {
            }

            @Override // p291fl.C9725c.a
            /* renamed from: a */
            public void mo7500a() {
                if (a.this.f5681d.getCount() <= 0) {
                    return;
                }
                a.this.downloadFail(a.this.m7497e());
                a.this.m7499g();
            }

            @Override // p291fl.C9725c.a
            /* renamed from: b */
            public long mo7501b() {
                return a.this.f5683f * 1000;
            }
        }

        public a(String str, InterfaceC1447b interfaceC1447b, InterfaceC1454i interfaceC1454i, C0217h<Boolean> c0217h) {
            this.f5678a = str;
            this.f5679b = interfaceC1447b;
            this.f5680c = interfaceC1454i;
            this.f5681d = c0217h;
        }

        /* renamed from: d */
        public final int m7496d() {
            return (this.f5678a + 0).hashCode();
        }

        @Override // com.huawei.android.hicloud.cloudbackup.process.task.CloudRestoreAgdApiInterface.CloudRestoreAgdApiClientCallback
        public synchronized void downloadFail(int i10) {
            if (this.f5684g.get()) {
                C11839m.m70686d("AGAppProcessor", "downloadFail has terminate ");
                return;
            }
            C11839m.m70689w("AGAppProcessor", "downloadFail errCode: " + i10);
            this.f5679b.onStatusChange(0, 1, this.f5682e);
            m7498f(i10);
        }

        /* renamed from: e */
        public final int m7497e() {
            return this.f5682e < 100 ? 1 : 7;
        }

        /* renamed from: f */
        public final void m7498f(int i10) {
            C9968i.e.m61846A().m61871D(this.f5678a);
            if (this.f5680c.isPause() || i10 == 1002 || i10 == 0) {
                C9968i.e.m61846A().pauseTask(this.f5678a);
            } else {
                C9968i.e.m61846A().cancelTask(this.f5678a);
            }
            this.f5681d.m1450a(Boolean.FALSE);
            C9725c.m60672a().m60675d(m7496d());
        }

        /* renamed from: g */
        public void m7499g() {
            this.f5684g.compareAndSet(false, true);
        }

        @Override // com.huawei.android.hicloud.cloudbackup.process.task.CloudRestoreAgdApiInterface.CloudRestoreAgdApiClientCallback
        public void onAddTaskSuccess() {
            if (this.f5684g.get()) {
                C11839m.m70686d("AGAppProcessor", "onAddTaskSuccess ");
                C9721b c9721b = this.f5685h;
                m7498f(c9721b != null ? c9721b.m60659c() : m7497e());
            }
        }

        @Override // com.huawei.android.hicloud.cloudbackup.process.task.CloudRestoreAgdApiInterface.CloudRestoreAgdApiClientCallback
        public synchronized void progressChanged(RestoreApkAgdDownloadState restoreApkAgdDownloadState) {
            C11839m.m70686d("AGAppProcessor", "progressChanged " + restoreApkAgdDownloadState);
            if (this.f5684g.get()) {
                C11839m.m70686d("AGAppProcessor", "progressChanged has terminate ");
                return;
            }
            try {
                this.f5680c.isAbort();
                if (restoreApkAgdDownloadState.getAppStatusType() == 2) {
                    int iM7507c = C1259j.m7507c(restoreApkAgdDownloadState.getAppStatus());
                    int progress = restoreApkAgdDownloadState.getProgress();
                    this.f5682e = progress;
                    this.f5679b.onStatusChange(0, iM7507c, progress);
                    if (this.f5682e > 0) {
                        C9725c.m60672a().m60674c(m7496d(), this.f5686i);
                    }
                    if (iM7507c != 0 && iM7507c != 1) {
                        this.f5679b.onStatusChange(0, iM7507c, this.f5682e);
                    }
                    downloadFail(iM7507c);
                    return;
                }
                if (restoreApkAgdDownloadState.getAppStatusType() == 1) {
                    C9725c.m60672a().m60674c(m7496d(), this.f5686i);
                    int iM7508d = C1259j.m7508d(restoreApkAgdDownloadState.getAppStatus());
                    if (iM7508d == 6) {
                        if (!this.f5680c.checkAppVersion(0)) {
                            downloadFail(-3);
                            return;
                        }
                        C9725c.m60672a().m60675d(m7496d());
                        C9968i.e.m61846A().m61871D(this.f5678a);
                        this.f5679b.onStatusChange(0, iM7508d, this.f5682e);
                        this.f5681d.m1450a(Boolean.TRUE);
                    } else if (iM7508d == 7) {
                        this.f5679b.onStatusChange(0, iM7508d, this.f5682e);
                        m7498f(iM7508d);
                    } else {
                        this.f5679b.onStatusChange(0, iM7508d, this.f5682e);
                    }
                }
            } catch (C9721b e10) {
                C11839m.m70689w("AGAppProcessor", "agd v2 or v3 abort exception " + e10.getMessage());
                downloadFail(e10.m60659c());
                C9725c.m60672a().m60675d(m7496d());
            }
        }

        @Override // com.huawei.android.hicloud.cloudbackup.process.task.CloudRestoreAgdApiInterface.CloudRestoreAgdApiClientCallback
        public synchronized void startFail(int i10) {
            if (this.f5684g.get()) {
                C11839m.m70686d("AGAppProcessor", "progressChanged has terminate ");
                return;
            }
            C11839m.m70689w("AGAppProcessor", "startFail errCode" + i10);
            this.f5679b.onStatusChange(0, 1, this.f5682e);
            this.f5681d.m1450a(Boolean.FALSE);
            C9725c.m60672a().m60675d(m7496d());
        }
    }

    public C1251b(boolean z10) {
        this.f5677a = z10;
    }

    @Override // cl.InterfaceC1446a
    /* renamed from: a */
    public boolean mo7489a(final String str, InterfaceC1447b interfaceC1447b, InterfaceC1454i interfaceC1454i) {
        Boolean boolM1451b = Boolean.FALSE;
        try {
        } catch (Exception e10) {
            C11839m.m70687e("AGAppProcessor", "process end appId: " + str + " Exception:" + e10.getClass().getName());
        }
        if (!C10790h.m65664l(str)) {
            C11839m.m70689w("AGAppProcessor", "report Click event fail!");
            return false;
        }
        C11839m.m70688i("AGAppProcessor", "process appId: " + str);
        final C0217h<Boolean> c0217h = new C0217h<>();
        final a aVar = new a(str, interfaceC1447b, interfaceC1454i, c0217h);
        C9968i.e.m61846A().queryTask(str, c0217h, new Consumer() { // from class: bl.a
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f5673a.m7491d(str, c0217h, aVar, (Boolean) obj);
            }
        });
        m7492e(c0217h, interfaceC1454i, aVar);
        boolM1451b = c0217h.m1451b();
        C11839m.m70688i("AGAppProcessor", "process end appId: " + str + " result:" + boolM1451b);
        return Boolean.TRUE.equals(boolM1451b);
    }

    @Override // cl.InterfaceC1446a
    /* renamed from: b */
    public boolean mo7490b(String str, long j10, boolean z10, boolean z11) throws NumberFormatException {
        if (!C10790h.m65658f(z10, z11, str)) {
            C11839m.m70689w("AGAppProcessor", "isAllow conditionResult false");
            return false;
        }
        boolean zM65659g = C10790h.m65659g(str, j10);
        C11839m.m70688i("AGAppProcessor", "isAllow appResult:" + zM65659g);
        return zM65659g;
    }

    /* renamed from: d */
    public final /* synthetic */ void m7491d(String str, C0217h c0217h, a aVar, Boolean bool) {
        if (bool.booleanValue()) {
            C9968i.e.m61846A().resumeTask(str, c0217h, aVar, this.f5677a);
        } else {
            C9968i.e.m61846A().startTask(str, C10790h.m65657e(str), c0217h, aVar, this.f5677a);
        }
    }

    /* renamed from: e */
    public final void m7492e(CountDownLatch countDownLatch, InterfaceC1454i interfaceC1454i, a aVar) throws C9721b {
        C11839m.m70688i("AGAppProcessor", "syncLock start lock");
        while (countDownLatch.getCount() > 0) {
            try {
                interfaceC1454i.isAbort();
                try {
                    if (countDownLatch.await(400L, TimeUnit.MILLISECONDS)) {
                        break;
                    }
                } catch (InterruptedException e10) {
                    C11839m.m70689w("AGAppProcessor", "lock wait error." + e10);
                    throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "AGAppProcessor lock wait error.");
                }
            } catch (C9721b e11) {
                C11839m.m70689w("AGAppProcessor", "AGAppProcessor syncLock error." + e11);
                aVar.downloadFail(e11.m60659c());
                aVar.m7499g();
            }
        }
        C11839m.m70688i("AGAppProcessor", "syncLock end lock");
    }

    @Override // cl.InterfaceC1446a
    public int getChannel() {
        return 0;
    }
}
