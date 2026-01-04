package com.huawei.openalliance.p169ad.download;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.beans.inner.DownloadBlockInfo;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.download.C7064g;
import com.huawei.openalliance.p169ad.download.DownloadTask;
import com.huawei.openalliance.p169ad.exception.C7112d;
import com.huawei.openalliance.p169ad.utils.AbstractC7731ae;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7805cy;
import com.huawei.openalliance.p169ad.utils.AbstractC7819dl;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import com.huawei.openalliance.p169ad.utils.C7775bv;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.huawei.openalliance.ad.download.h */
/* loaded from: classes2.dex */
public class RunnableC7065h implements Runnable {

    /* renamed from: a */
    private Context f32532a;

    /* renamed from: b */
    private C7059b f32533b;

    /* renamed from: c */
    private DownloadTask f32534c;

    /* renamed from: d */
    private WeakReference<AbstractC7060c> f32535d;

    /* renamed from: h */
    private int f32539h;

    /* renamed from: e */
    private boolean f32536e = false;

    /* renamed from: f */
    private boolean f32537f = false;

    /* renamed from: g */
    private final byte[] f32538g = new byte[0];

    /* renamed from: i */
    private boolean f32540i = true;

    /* renamed from: com.huawei.openalliance.ad.download.h$1 */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC7805cy.m48142a(RunnableC7065h.this.m42617c());
        }
    }

    public RunnableC7065h(C7059b c7059b) {
        this.f32533b = c7059b;
        this.f32532a = c7059b.f32505a;
    }

    /* renamed from: a */
    private AbstractC7060c m42604a(DownloadTask downloadTask, File file) throws NoSuchAlgorithmException, IOException, KeyStoreException, C7112d {
        String strM42045a;
        AbstractC7060c abstractC7060cM42575a = null;
        try {
            if (!TextUtils.isEmpty(downloadTask.m42087s()) && downloadTask.m42088t() < this.f32533b.m42566e()) {
                AbstractC7185ho.m43820b("DownloadWorker", "create connection with redirected url");
                strM42045a = downloadTask.m42087s();
            } else if (!downloadTask.m42086r() || TextUtils.isEmpty(downloadTask.m42058b())) {
                AbstractC7185ho.m43820b("DownloadWorker", "create connection with normal url");
                strM42045a = downloadTask.m42045a();
            } else {
                AbstractC7185ho.m43820b("DownloadWorker", "create connection with safe url");
                strM42045a = downloadTask.m42058b();
                downloadTask.m42074f(null);
                downloadTask.m42064c(0);
            }
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43818a("DownloadWorker", "url: %s", AbstractC7819dl.m48375a(strM42045a));
            }
            abstractC7060cM42575a = AbstractC7060c.m42575a(this.f32532a, strM42045a, downloadTask.m42075g());
            return m42605a(abstractC7060cM42575a, downloadTask, file);
        } catch (C7112d e10) {
            AbstractC7805cy.m48142a(abstractC7060cM42575a);
            throw e10;
        } catch (IOException e11) {
            downloadTask.m42052a(DownloadTask.EnumC7030b.CONN_FAILED);
            AbstractC7805cy.m48142a(abstractC7060cM42575a);
            throw e11;
        } catch (KeyStoreException e12) {
            AbstractC7805cy.m48142a(abstractC7060cM42575a);
            throw e12;
        } catch (NoSuchAlgorithmException e13) {
            AbstractC7805cy.m48142a(abstractC7060cM42575a);
            throw e13;
        }
    }

    /* renamed from: b */
    private AbstractC7060c m42612b(AbstractC7060c abstractC7060c, DownloadTask downloadTask, File file) {
        AbstractC7185ho.m43820b("DownloadWorker", "checkConn - try Safe Url");
        if (downloadTask.m42086r() || TextUtils.isEmpty(downloadTask.m42058b()) || !AbstractC7731ae.m47467f(file)) {
            AbstractC7185ho.m43820b("DownloadWorker", "checkConn - fail to switch to safe url, stop downloading");
            downloadTask.m42052a(DownloadTask.EnumC7030b.FILE_SIZE_ERROR);
            if (file.length() <= 0) {
                AbstractC7731ae.m47466e(file);
            }
            AbstractC7805cy.m48142a(abstractC7060c);
            return null;
        }
        AbstractC7185ho.m43820b("DownloadWorker", "checkConn - switch to safe url ok");
        AbstractC7805cy.m48142a(abstractC7060c);
        downloadTask.m42060b(0L);
        downloadTask.m42065c(0L);
        downloadTask.m42067c(true);
        downloadTask.m42074f(null);
        downloadTask.m42064c(0);
        return m42604a(downloadTask, file);
    }

    /* renamed from: c */
    public synchronized AbstractC7060c m42617c() {
        WeakReference<AbstractC7060c> weakReference;
        weakReference = this.f32535d;
        return weakReference != null ? weakReference.get() : null;
    }

    /* renamed from: d */
    private boolean m42620d() {
        boolean z10;
        synchronized (this.f32538g) {
            z10 = this.f32537f;
        }
        return z10;
    }

    /* renamed from: e */
    private File m42622e(DownloadTask downloadTask) throws IOException {
        long length;
        File file = new File(downloadTask.m42071e());
        if (file.exists()) {
            length = file.length();
        } else {
            File parentFile = file.getParentFile();
            if ((!parentFile.exists() || !parentFile.isDirectory()) && !AbstractC7731ae.m47468g(parentFile)) {
                AbstractC7185ho.m43823c("DownloadWorker", "failed to create dirs");
                throw new IOException("fail to create dirs");
            }
            if (!file.createNewFile()) {
                AbstractC7185ho.m43823c("DownloadWorker", "failed to create new temp file");
                throw new IOException("fail to create new temp file");
            }
            length = 0;
        }
        downloadTask.m42060b(length);
        return file;
    }

    @Override // java.lang.Runnable
    public void run() {
        DownloadTask downloadTask;
        int i10;
        AbstractC7185ho.m43821b("DownloadWorker", "[%s] running...", this);
        this.f32534c = null;
        boolean zM42615b = false;
        while (!m42620d()) {
            try {
                synchronized (this) {
                    while (this.f32533b.m42561c() > 0 && !C7775bv.m47831e(this.f32533b.f32505a)) {
                        try {
                            wait(1000L);
                        } finally {
                        }
                    }
                }
                this.f32539h = 0;
                this.f32540i = true;
                DownloadTask downloadTaskM42558b = this.f32533b.m42558b();
                this.f32534c = downloadTaskM42558b;
                if (downloadTaskM42558b != null) {
                    zM42615b = false;
                    do {
                        synchronized (this) {
                            if (zM42615b) {
                                try {
                                    long jPow = (long) (Math.pow(2.0d, this.f32539h - 1) * 500.0d);
                                    AbstractC7185ho.m43826d("DownloadWorker", "retry, interval:" + jPow + ", count:" + this.f32539h);
                                    wait(jPow);
                                } finally {
                                }
                            }
                        }
                        zM42615b = m42615b(this.f32534c);
                        if (!zM42615b) {
                            break;
                        }
                        i10 = this.f32539h;
                        this.f32539h = i10 + 1;
                    } while (i10 < 3);
                }
            } finally {
                try {
                    if (downloadTask != null) {
                        m42609a(zM42615b);
                    }
                } catch (Throwable th2) {
                }
            }
            if (this.f32534c != null) {
                m42609a(zM42615b);
            }
        }
    }

    public String toString() {
        return "DownloadWorker";
    }

    /* renamed from: a */
    private AbstractC7060c m42605a(AbstractC7060c abstractC7060c, DownloadTask downloadTask, File file) {
        AbstractC7185ho.m43820b("DownloadWorker", "checkConn start");
        try {
            long jM42597a = C7064g.m42597a(abstractC7060c);
            if (downloadTask.m42073f() > 0 && jM42597a > 0 && downloadTask.m42073f() != jM42597a) {
                AbstractC7185ho.m43818a("DownloadWorker", "task size:%d, header size:%d", Long.valueOf(downloadTask.m42073f()), Long.valueOf(jM42597a));
                AbstractC7185ho.m43820b("DownloadWorker", "checkConn - may be hijacked, switch to safe url");
                abstractC7060c = m42612b(abstractC7060c, downloadTask, file);
            }
            AbstractC7185ho.m43820b("DownloadWorker", "checkConn end");
            return abstractC7060c;
        } catch (C7064g.a e10) {
            downloadTask.m42064c(downloadTask.m42088t() + 1);
            downloadTask.m42074f(e10.m42603a());
            int iM42566e = this.f32533b.m42566e();
            AbstractC7185ho.m43824c("DownloadWorker", "checkConn - url is redirected [count: %d, max: %d]", Integer.valueOf(downloadTask.m42088t()), Integer.valueOf(iM42566e));
            if (TextUtils.isEmpty(downloadTask.m42087s()) || downloadTask.m42088t() > iM42566e) {
                return m42612b(abstractC7060c, downloadTask, file);
            }
            AbstractC7185ho.m43820b("DownloadWorker", "checkConn - connect with redirected url");
            AbstractC7805cy.m48142a(abstractC7060c);
            return m42604a(downloadTask, file);
        }
    }

    /* renamed from: b */
    private synchronized void m42613b(boolean z10) {
        this.f32536e = z10;
    }

    /* renamed from: c */
    private boolean m42618c(DownloadTask downloadTask) {
        DownloadTask.EnumC7030b enumC7030b;
        if (!C7775bv.m47831e(this.f32533b.f32505a)) {
            enumC7030b = DownloadTask.EnumC7030b.NO_NETWORK;
        } else {
            if (downloadTask.m42083o() || C7775bv.m47829c(this.f32533b.f32505a)) {
                return true;
            }
            enumC7030b = DownloadTask.EnumC7030b.MOBILE_NETWORK;
        }
        downloadTask.m42052a(enumC7030b);
        this.f32533b.m42574j(downloadTask);
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:249:0x0147, code lost:
    
        com.huawei.openalliance.p169ad.AbstractC7185ho.m43820b("DownloadWorker", "download canceled");
     */
    /* JADX WARN: Code restructure failed: missing block: B:273:0x01b3, code lost:
    
        com.huawei.openalliance.p169ad.AbstractC7185ho.m43823c("DownloadWorker", "downloading, check file size failed");
     */
    /* JADX WARN: Code restructure failed: missing block: B:274:0x01b8, code lost:
    
        r1 = r37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:275:0x01ba, code lost:
    
        r0 = r1.m42619c(r38, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:276:0x01be, code lost:
    
        if (r0 != false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:277:0x01c0, code lost:
    
        com.huawei.openalliance.p169ad.utils.AbstractC7731ae.m47466e(r10);
        r38.m42052a(com.huawei.openalliance.p169ad.download.DownloadTask.EnumC7030b.FILE_SIZE_ERROR);
        r1.f32533b.m42574j(r38);
     */
    /* JADX WARN: Code restructure failed: missing block: B:279:0x01ce, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:280:0x01cf, code lost:
    
        r18 = r6;
        r5 = r7;
        r14 = r32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:281:0x01d6, code lost:
    
        com.huawei.openalliance.p169ad.utils.AbstractC7805cy.m48142a((java.io.Closeable) r32);
        com.huawei.openalliance.p169ad.utils.AbstractC7805cy.m48142a(r6);
        com.huawei.openalliance.p169ad.utils.AbstractC7805cy.m48142a(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:282:0x01df, code lost:
    
        return r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:352:0x02f2  */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean m42621d(com.huawei.openalliance.p169ad.download.DownloadTask r38) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 758
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.download.RunnableC7065h.m42621d(com.huawei.openalliance.ad.download.DownloadTask):boolean");
    }

    /* renamed from: b */
    private synchronized boolean m42614b() {
        return this.f32536e;
    }

    /* renamed from: c */
    private boolean m42619c(DownloadTask downloadTask, File file) {
        if (downloadTask.m42086r() || TextUtils.isEmpty(downloadTask.m42058b()) || !C7775bv.m47829c(this.f32532a)) {
            return false;
        }
        downloadTask.m42067c(true);
        downloadTask.m42060b(0L);
        downloadTask.m42065c(0L);
        downloadTask.m42074f(null);
        downloadTask.m42064c(0);
        AbstractC7731ae.m47466e(file);
        this.f32533b.m42573i(downloadTask);
        return true;
    }

    /* renamed from: b */
    private boolean m42615b(DownloadTask downloadTask) {
        try {
            AbstractC7185ho.m43818a("DownloadWorker", "takeTask, taskId:%s, priority:%d, seqNum:%d", downloadTask.mo42082n(), Integer.valueOf(downloadTask.m42079k()), Long.valueOf(downloadTask.m42081m()));
            downloadTask.m42048a((DownloadBlockInfo) null);
            if (!m42618c(downloadTask)) {
                AbstractC7185ho.m43818a("DownloadWorker", "executeTask, network error, taskId:%s", downloadTask.mo42082n());
                return false;
            }
            downloadTask.m42055a(this);
            downloadTask.m42046a(2);
            if (!m42621d(downloadTask)) {
                return false;
            }
            m42621d(downloadTask);
            return false;
        } catch (Throwable th2) {
            AbstractC7185ho.m43826d("DownloadWorker", "executeTask Exception, taskId:" + AbstractC7819dl.m48375a(downloadTask.mo42082n()));
            AbstractC7185ho.m43815a(5, th2);
            return m42610a();
        }
    }

    /* renamed from: a */
    public void m42623a(DownloadTask downloadTask) {
        if (downloadTask == null || !downloadTask.equals(this.f32534c) || m42614b()) {
            return;
        }
        m42613b(true);
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("DownloadWorker", "cancelCurrentTask, taskId:%s", downloadTask.mo42082n());
        }
        AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.download.h.1
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                AbstractC7805cy.m48142a(RunnableC7065h.this.m42617c());
            }
        });
    }

    /* renamed from: a */
    private void m42607a(DownloadTask downloadTask, long j10, long j11, DownloadBlockInfo downloadBlockInfo) {
        if (j10 == 0) {
            AbstractC7185ho.m43823c("DownloadWorker", "speed log - no start time");
            return;
        }
        long jM47566c = AbstractC7741ao.m47566c();
        long j12 = jM47566c - j10;
        if (j12 <= 0) {
            AbstractC7185ho.m43823c("DownloadWorker", "speed log - duration <= 0");
            return;
        }
        if (!downloadTask.m42085q()) {
            if (downloadBlockInfo == null) {
                downloadBlockInfo = new DownloadBlockInfo();
            }
            downloadBlockInfo.m39394a(j10);
            downloadBlockInfo.m39397b(jM47566c);
            downloadBlockInfo.m39398c(j11);
            downloadTask.m42048a(downloadBlockInfo);
            downloadTask.m42093y();
        }
        AbstractC7185ho.m43821b("DownloadWorker", "download complete - total time: %d(ms) total download size: %d(bytes) avg. speed: %d(bytes/s)", Long.valueOf(j12), Long.valueOf(j11), Long.valueOf(((100000 * j11) / j12) / 100));
    }

    /* renamed from: b */
    private boolean m42616b(DownloadTask downloadTask, File file) {
        AbstractC7185ho.m43820b("DownloadWorker", "download complete");
        if (m42614b()) {
            if (!downloadTask.m42085q()) {
                return false;
            }
            AbstractC7185ho.m43820b("DownloadWorker", "onDownloadCompleted - task is cancelled");
            AbstractC7731ae.m47466e(file);
            downloadTask.m42060b(0L);
            return false;
        }
        if (!downloadTask.m42094z() || AbstractC7731ae.m47452a(downloadTask.m42063c(), file)) {
            if (!AbstractC7731ae.m47447a(this.f32532a, file, downloadTask.m42068d(), downloadTask.m42043A(), Constants.NORMAL_CACHE)) {
                this.f32533b.m42574j(downloadTask);
                return false;
            }
            AbstractC7185ho.m43820b("DownloadWorker", "download success");
            this.f32533b.m42553a((C7059b) downloadTask, 100);
            this.f32533b.m42572h(downloadTask);
            return false;
        }
        AbstractC7185ho.m43823c("DownloadWorker", "onDownloadCompleted, check file sha256 failed");
        boolean zM42619c = m42619c(downloadTask, file);
        if (!zM42619c) {
            AbstractC7731ae.m47466e(file);
            downloadTask.m42052a(DownloadTask.EnumC7030b.FILE_SHA256_ERROR);
            this.f32533b.m42574j(downloadTask);
        }
        return zM42619c;
    }

    /* renamed from: a */
    private synchronized void m42608a(AbstractC7060c abstractC7060c) {
        this.f32535d = new WeakReference<>(abstractC7060c);
    }

    /* renamed from: a */
    private void m42609a(boolean z10) {
        if (z10) {
            try {
                this.f32533b.m42574j(this.f32534c);
            } catch (Throwable unused) {
                AbstractC7185ho.m43826d("DownloadWorker", "call manager.onDownloadFail Exception");
            }
        }
        try {
            if (m42614b() && this.f32534c.m42084p() == DownloadTask.EnumC7031c.USER_CLICK) {
                this.f32534c.m42046a(0);
            }
            this.f32534c.m42055a((RunnableC7065h) null);
            this.f32533b.m42552a((C7059b) this.f32534c);
            this.f32534c = null;
        } catch (Throwable unused2) {
            AbstractC7185ho.m43826d("DownloadWorker", "run Exception");
        }
    }

    /* renamed from: a */
    private boolean m42610a() throws InterruptedException {
        if (!m42614b()) {
            try {
                Thread.sleep(100L);
            } catch (InterruptedException unused) {
                AbstractC7185ho.m43826d("DownloadWorker", "exception occur when wait for sync cancel");
            }
        }
        return !m42614b();
    }

    /* renamed from: a */
    private static boolean m42611a(AbstractC7060c abstractC7060c, DownloadTask downloadTask) {
        return downloadTask.m42075g() <= 0 || abstractC7060c.mo42578b() == 206;
    }
}
