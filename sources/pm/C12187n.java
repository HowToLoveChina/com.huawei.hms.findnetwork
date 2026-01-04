package pm;

import com.huawei.android.hicloud.cloudbackup.process.CloudRestoreTask;
import com.huawei.hicloud.cloudbackup.p104v3.core.C4880b;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudRestoreStatusV3;
import com.huawei.hicloud.cloudbackup.store.database.tags.CloudRestoreStatus;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: pm.n */
/* loaded from: classes6.dex */
public class C12187n {

    /* renamed from: a */
    public static final Object f56547a = new Object();

    /* renamed from: b */
    public static ExecutorService f56548b = Executors.newFixedThreadPool(1);

    /* renamed from: c */
    public static ExecutorService f56549c = Executors.newFixedThreadPool(2);

    /* renamed from: d */
    public static Vector<String> f56550d = new Vector<>();

    /* renamed from: e */
    public static void m73308e(final CloudRestoreTask cloudRestoreTask, final CloudRestoreStatus cloudRestoreStatus) {
        synchronized (f56547a) {
            try {
                f56550d.add(cloudRestoreStatus.getAppId());
                ExecutorService executorService = f56549c;
                if (executorService == null || executorService.isShutdown()) {
                    f56549c = Executors.newFixedThreadPool(2);
                }
                f56549c.execute(new Runnable() { // from class: pm.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        C12187n.m73310g(cloudRestoreTask, cloudRestoreStatus);
                    }
                });
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: f */
    public static void m73309f(final C4880b c4880b, final CloudRestoreStatusV3 cloudRestoreStatusV3) {
        synchronized (f56547a) {
            try {
                f56550d.add(cloudRestoreStatusV3.m29468L());
                ExecutorService executorService = f56549c;
                if (executorService == null || executorService.isShutdown()) {
                    f56549c = Executors.newFixedThreadPool(2);
                }
                f56549c.execute(new Runnable() { // from class: pm.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        C12187n.m73311h(c4880b, cloudRestoreStatusV3);
                    }
                });
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: g */
    public static void m73310g(CloudRestoreTask cloudRestoreTask, CloudRestoreStatus cloudRestoreStatus) {
        try {
            cloudRestoreTask.restoreOneModule(cloudRestoreStatus);
        } finally {
            m73317n(cloudRestoreStatus.getAppId());
            cloudRestoreTask.removeModule(cloudRestoreStatus.getAppId());
        }
    }

    /* renamed from: h */
    public static void m73311h(C4880b c4880b, CloudRestoreStatusV3 cloudRestoreStatusV3) {
        try {
            c4880b.m29801j0(cloudRestoreStatusV3);
        } finally {
            m73317n(cloudRestoreStatusV3.m29468L());
            c4880b.removeModule(cloudRestoreStatusV3.m29468L());
        }
    }

    /* renamed from: i */
    public static boolean m73312i() {
        boolean z10;
        synchronized (f56547a) {
            z10 = !f56550d.isEmpty();
        }
        return z10;
    }

    /* renamed from: n */
    public static void m73317n(String str) {
        synchronized (f56547a) {
            f56550d.remove(str);
        }
    }

    /* renamed from: o */
    public static void m73318o(final CloudRestoreTask cloudRestoreTask, final CloudRestoreStatus cloudRestoreStatus) {
        synchronized (f56547a) {
            try {
                f56550d.add(cloudRestoreStatus.getAppId());
                ExecutorService executorService = f56548b;
                if (executorService == null || executorService.isShutdown()) {
                    f56548b = Executors.newFixedThreadPool(1);
                }
                f56548b.execute(new Runnable() { // from class: pm.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        C12187n.m73310g(cloudRestoreTask, cloudRestoreStatus);
                    }
                });
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: p */
    public static void m73319p(final C4880b c4880b, final CloudRestoreStatusV3 cloudRestoreStatusV3) {
        synchronized (f56547a) {
            try {
                f56550d.add(cloudRestoreStatusV3.m29468L());
                ExecutorService executorService = f56548b;
                if (executorService == null || executorService.isShutdown()) {
                    f56548b = Executors.newFixedThreadPool(1);
                }
                f56548b.execute(new Runnable() { // from class: pm.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        C12187n.m73311h(c4880b, cloudRestoreStatusV3);
                    }
                });
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
