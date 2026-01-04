package p604r7;

import com.huawei.android.hicloud.album.client.sync.SyncTaskObserver;
import com.huawei.android.p069cg.configure.CloudAlbumSettings;
import gp.C10028c;
import p031b7.C1120a;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;
import p709vj.C13452e;

/* renamed from: r7.f */
/* loaded from: classes2.dex */
public class C12473f implements SyncTaskObserver {

    /* renamed from: a */
    public C12472e f57434a;

    /* renamed from: b */
    public boolean f57435b;

    /* renamed from: c */
    public int f57436c;

    /* renamed from: r7.f$b */
    public static class b {

        /* renamed from: a */
        public static C12473f f57437a = new C12473f();
    }

    /* renamed from: r7.f$c */
    public static class c extends AbstractC12367d {
        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            C1120a.m6677i("AlbumClientSyncManager", "StartAutoSyncTask");
            C12473f.m74865c().m74869f(1);
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.ALBUM_FIX;
        }
    }

    /* renamed from: c */
    public static C12473f m74865c() {
        return b.f57437a;
    }

    @Override // com.huawei.android.hicloud.album.client.sync.SyncTaskObserver
    /* renamed from: a */
    public synchronized void mo15028a() {
        if (this.f57435b) {
            m74869f(this.f57436c);
            this.f57435b = false;
        }
    }

    /* renamed from: b */
    public synchronized void m74866b(int i10) {
        if (i10 == 1 || i10 == 2) {
            try {
                C1120a.m6677i("AlbumClientSyncManager", "cancel pending sync task");
                this.f57435b = false;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (this.f57434a.m74849f0()) {
            C1120a.m6677i("AlbumClientSyncManager", "end sync, code: " + i10);
            this.f57434a.m74830M();
        } else {
            C1120a.m6676e("AlbumClientSyncManager", "sync task is not running");
        }
    }

    /* renamed from: d */
    public boolean m74867d() {
        return this.f57434a.m74848e0();
    }

    /* renamed from: e */
    public void m74868e() {
        C12515a.m75110o().m75175e(new c(), true);
    }

    /* renamed from: f */
    public synchronized int m74869f(int i10) {
        boolean zM62221H1 = C10028c.m62182c0().m62221H1();
        if (!C13452e.m80781L().m80842P0() || !zM62221H1) {
            C1120a.m6676e("AlbumClientSyncManager", "condition not support");
            return -1;
        }
        if (!CloudAlbumSettings.m14363h().m14383s() && !CloudAlbumSettings.m14363h().m14382r()) {
            C1120a.m6676e("AlbumClientSyncManager", "version not support");
            return -1;
        }
        if (this.f57434a.m74849f0()) {
            if (i10 == 1 || i10 == 4) {
                C1120a.m6676e("AlbumClientSyncManager", "sync task is running");
                return -1;
            }
            C1120a.m6677i("AlbumClientSyncManager", "add pending sync task, type: " + i10);
            this.f57435b = true;
            this.f57436c = i10;
            return 1;
        }
        C1120a.m6677i("AlbumClientSyncManager", "start sync, type: " + i10);
        if (i10 == 1) {
            long jM74774e = C12470c.m74770d().m74774e();
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j10 = jCurrentTimeMillis - jM74774e;
            C1120a.m6677i("AlbumClientSyncManager", "startSync: syncInterval = " + j10);
            if (j10 > 0 && j10 < 15000) {
                C1120a.m6678w("AlbumClientSyncManager", "ignore auto sync type within 15s");
                return -1;
            }
            C12470c.m74770d().m74786q(jCurrentTimeMillis);
        }
        this.f57434a.m74855l0(i10);
        return 0;
    }

    public C12473f() {
        this.f57434a = new C12472e(this);
    }
}
