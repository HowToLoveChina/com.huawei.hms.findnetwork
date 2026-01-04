package pm;

import ck.C1444b;
import com.huawei.android.hicloud.cloudbackup.manager.CloudBackupModuleTask;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudBackupStatus;
import dm.C9276z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import p262em.AbstractC9526z;
import p514o9.C11839m;

/* renamed from: pm.i */
/* loaded from: classes6.dex */
public class C12182i {

    /* renamed from: k */
    public static C12182i f56527k = new C12182i();

    /* renamed from: l */
    public static final Object f56528l = new Object();

    /* renamed from: a */
    public ThreadPoolExecutor f56529a = null;

    /* renamed from: b */
    public ThreadPoolExecutor f56530b = (ThreadPoolExecutor) Executors.newFixedThreadPool(1);

    /* renamed from: c */
    public ThreadPoolExecutor f56531c = (ThreadPoolExecutor) Executors.newFixedThreadPool(1);

    /* renamed from: d */
    public ThreadPoolExecutor f56532d = (ThreadPoolExecutor) Executors.newFixedThreadPool(1);

    /* renamed from: e */
    public Vector<String> f56533e = new Vector<>();

    /* renamed from: f */
    public List<CloudBackupStatus> f56534f = new ArrayList();

    /* renamed from: g */
    public Map<CloudBackupStatus, Future<?>> f56535g = new ConcurrentHashMap();

    /* renamed from: h */
    public Map<CloudBackupStatus, Future<?>> f56536h = new ConcurrentHashMap();

    /* renamed from: i */
    public Map<CloudBackupStatus, Future<?>> f56537i = new ConcurrentHashMap();

    /* renamed from: j */
    public Map<CloudBackupStatus, Future<?>> f56538j = new ConcurrentHashMap();

    /* renamed from: j */
    public static C12182i m73283j() {
        return f56527k;
    }

    /* renamed from: c */
    public Future<?> m73284c(CloudBackupStatus cloudBackupStatus, C9276z c9276z) {
        Future<?> futureSubmit;
        synchronized (f56528l) {
            try {
                ThreadPoolExecutor threadPoolExecutor = this.f56532d;
                if (threadPoolExecutor == null || threadPoolExecutor.isShutdown()) {
                    this.f56532d = (ThreadPoolExecutor) Executors.newFixedThreadPool(1);
                }
                futureSubmit = this.f56532d.submit(c9276z);
                this.f56538j.put(cloudBackupStatus, futureSubmit);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return futureSubmit;
    }

    /* renamed from: d */
    public void m73285d(final AbstractC9526z abstractC9526z, final List<CloudBackupStatus> list) {
        synchronized (f56528l) {
            try {
                ThreadPoolExecutor threadPoolExecutor = this.f56529a;
                if (threadPoolExecutor == null || threadPoolExecutor.isShutdown()) {
                    this.f56529a = (ThreadPoolExecutor) Executors.newFixedThreadPool(C1444b.m8297c());
                }
                this.f56534f.addAll(list);
                this.f56535g.put(list.get(0), this.f56529a.submit(new Runnable() { // from class: pm.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f56521a.m73297q(abstractC9526z, list);
                    }
                }));
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: e */
    public Future<?> m73286e(final AbstractC9526z abstractC9526z, final CloudBackupStatus cloudBackupStatus) {
        Future<?> futureSubmit;
        synchronized (f56528l) {
            try {
                this.f56533e.add(cloudBackupStatus.m29870d() + cloudBackupStatus.m29861N());
                ThreadPoolExecutor threadPoolExecutor = this.f56530b;
                if (threadPoolExecutor == null || threadPoolExecutor.isShutdown()) {
                    this.f56530b = (ThreadPoolExecutor) Executors.newFixedThreadPool(1);
                }
                futureSubmit = this.f56530b.submit(new Runnable() { // from class: pm.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f56524a.m73298r(abstractC9526z, cloudBackupStatus);
                    }
                });
                this.f56536h.put(cloudBackupStatus, futureSubmit);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return futureSubmit;
    }

    /* renamed from: f */
    public void m73287f(AbstractC9526z abstractC9526z, CloudBackupStatus cloudBackupStatus) {
        synchronized (f56528l) {
            this.f56533e.add(cloudBackupStatus.m29870d() + cloudBackupStatus.m29861N());
        }
        m73298r(abstractC9526z, cloudBackupStatus);
    }

    /* renamed from: g */
    public Future<?> m73288g(CloudBackupStatus cloudBackupStatus, CloudBackupModuleTask cloudBackupModuleTask) {
        Future<?> futureSubmit;
        synchronized (f56528l) {
            try {
                ThreadPoolExecutor threadPoolExecutor = this.f56531c;
                if (threadPoolExecutor == null || threadPoolExecutor.isShutdown()) {
                    this.f56531c = (ThreadPoolExecutor) Executors.newFixedThreadPool(1);
                }
                futureSubmit = this.f56531c.submit(cloudBackupModuleTask);
                this.f56537i.put(cloudBackupStatus, futureSubmit);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return futureSubmit;
    }

    /* renamed from: h */
    public final void m73289h(AbstractC9526z abstractC9526z, CloudBackupStatus cloudBackupStatus) {
        try {
            abstractC9526z.mo57883f();
        } finally {
            m73300t(cloudBackupStatus);
        }
    }

    /* renamed from: i */
    public final void m73298r(AbstractC9526z abstractC9526z, CloudBackupStatus cloudBackupStatus) {
        try {
            abstractC9526z.mo57881e(cloudBackupStatus);
        } finally {
            m73301u(cloudBackupStatus);
        }
    }

    /* renamed from: k */
    public int m73291k() {
        int size;
        synchronized (f56528l) {
            size = this.f56534f.size();
        }
        return size;
    }

    /* renamed from: l */
    public CloudBackupStatus m73292l(int i10) {
        CloudBackupStatus cloudBackupStatus;
        synchronized (f56528l) {
            cloudBackupStatus = this.f56534f.get(i10);
        }
        return cloudBackupStatus;
    }

    /* renamed from: m */
    public boolean m73293m() {
        boolean z10;
        synchronized (f56528l) {
            z10 = this.f56534f.size() > 0;
        }
        return z10;
    }

    /* renamed from: n */
    public boolean m73294n() {
        synchronized (f56528l) {
            try {
                if (this.f56532d.getActiveCount() > 0) {
                    return true;
                }
                return this.f56532d.getQueue().size() > 0;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: o */
    public boolean m73295o() {
        synchronized (f56528l) {
            try {
                if (this.f56531c.getActiveCount() > 0) {
                    return true;
                }
                return this.f56531c.getQueue().size() > 0;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: p */
    public boolean m73296p() {
        boolean z10;
        synchronized (f56528l) {
            z10 = !this.f56533e.isEmpty();
        }
        return z10;
    }

    /* renamed from: q */
    public final /* synthetic */ void m73297q(AbstractC9526z abstractC9526z, List list) {
        m73289h(abstractC9526z, (CloudBackupStatus) list.get(0));
    }

    /* renamed from: s */
    public void m73299s(CloudBackupStatus cloudBackupStatus) {
        synchronized (f56528l) {
            this.f56538j.remove(cloudBackupStatus);
        }
    }

    /* renamed from: t */
    public void m73300t(CloudBackupStatus cloudBackupStatus) {
        synchronized (f56528l) {
            this.f56534f.remove(cloudBackupStatus);
            this.f56535g.remove(cloudBackupStatus);
            C11839m.m70688i("CloudBackupV3ModuleTaskManager", "remove module, appId = " + cloudBackupStatus.m29870d() + ", uid = " + cloudBackupStatus.m29861N());
        }
    }

    /* renamed from: u */
    public final void m73301u(CloudBackupStatus cloudBackupStatus) {
        synchronized (f56528l) {
            this.f56533e.remove(cloudBackupStatus.m29870d() + cloudBackupStatus.m29861N());
            this.f56536h.remove(cloudBackupStatus);
        }
    }

    /* renamed from: v */
    public void m73302v(CloudBackupStatus cloudBackupStatus) {
        synchronized (f56528l) {
            this.f56537i.remove(cloudBackupStatus);
        }
    }

    /* renamed from: w */
    public void m73303w() {
        synchronized (f56528l) {
            try {
                try {
                    Iterator<Map.Entry<CloudBackupStatus, Future<?>>> it = this.f56536h.entrySet().iterator();
                    while (it.hasNext()) {
                        it.next().getValue().cancel(true);
                    }
                    this.f56536h.clear();
                    Iterator<Map.Entry<CloudBackupStatus, Future<?>>> it2 = this.f56537i.entrySet().iterator();
                    while (it2.hasNext()) {
                        it2.next().getValue().cancel(true);
                    }
                    this.f56537i.clear();
                    Iterator<Map.Entry<CloudBackupStatus, Future<?>>> it3 = this.f56538j.entrySet().iterator();
                    while (it3.hasNext()) {
                        it3.next().getValue().cancel(true);
                    }
                    this.f56538j.clear();
                    Iterator<Map.Entry<CloudBackupStatus, Future<?>>> it4 = this.f56535g.entrySet().iterator();
                    while (it4.hasNext()) {
                        it4.next().getValue().cancel(true);
                    }
                    this.f56535g.clear();
                } catch (Exception unused) {
                    C11839m.m70688i("CloudBackupV3ModuleTaskManager", "shutdownExecutors cancel error");
                }
                ThreadPoolExecutor threadPoolExecutor = this.f56530b;
                if (threadPoolExecutor != null && !threadPoolExecutor.isShutdown()) {
                    this.f56530b.shutdownNow();
                }
                ThreadPoolExecutor threadPoolExecutor2 = this.f56531c;
                if (threadPoolExecutor2 != null && !threadPoolExecutor2.isShutdown()) {
                    this.f56531c.shutdownNow();
                }
                ThreadPoolExecutor threadPoolExecutor3 = this.f56532d;
                if (threadPoolExecutor3 != null && threadPoolExecutor3.isShutdown()) {
                    this.f56532d.shutdownNow();
                }
                this.f56533e.clear();
                this.f56534f.clear();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
