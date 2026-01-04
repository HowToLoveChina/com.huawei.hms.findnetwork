package p456lm;

import ck.C1444b;
import com.huawei.android.hicloud.cloudbackup.manager.CloudBackupBaseTask;
import com.huawei.android.hicloud.cloudbackup.manager.PriorityThreadPoolExecutor;
import im.AbstractC10548b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import p015ak.C0224k0;
import p514o9.C11839m;
import p617rl.C12526j;
import p618rm.C12590s0;

/* renamed from: lm.b */
/* loaded from: classes6.dex */
public class C11315b {

    /* renamed from: c */
    public static C11315b f53005c = new C11315b();

    /* renamed from: d */
    public static final Object f53006d = new Object();

    /* renamed from: e */
    public static final Object f53007e = new Object();

    /* renamed from: a */
    public PriorityThreadPoolExecutor f53008a = null;

    /* renamed from: b */
    public ConcurrentHashMap<String, List<CloudBackupBaseTask>> f53009b = new ConcurrentHashMap<>();

    /* renamed from: c */
    public static C11315b m67979c() {
        return f53005c;
    }

    /* renamed from: a */
    public void m67980a(String str, CloudBackupBaseTask cloudBackupBaseTask) {
        m67982d();
        synchronized (f53007e) {
            try {
                cloudBackupBaseTask.setFuture(this.f53008a.submit(cloudBackupBaseTask));
                List<CloudBackupBaseTask> arrayList = this.f53009b.get(str);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(cloudBackupBaseTask);
                this.f53009b.put(str, arrayList);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: b */
    public void m67981b(AbstractC10548b abstractC10548b, boolean z10) {
        while (!abstractC10548b.m64716k()) {
            synchronized (f53007e) {
                int iM8313s = z10 ? 1 : C1444b.m8313s();
                Iterator<Map.Entry<String, List<CloudBackupBaseTask>>> it = this.f53009b.entrySet().iterator();
                int size = 0;
                while (it.hasNext()) {
                    try {
                        size += it.next().getValue().size();
                    } finally {
                    }
                }
                C11839m.m70686d("CloudBackupV3TaskManager", "initSliceExecutors, slice executor size = " + size);
                if (size < iM8313s * 2) {
                    return;
                }
                try {
                    f53007e.wait(300L);
                } catch (InterruptedException unused) {
                    C11839m.m70689w("CloudBackupV3TaskManager", "task slice interrupted.");
                }
            }
        }
    }

    /* renamed from: d */
    public final void m67982d() {
        synchronized (f53006d) {
            try {
                PriorityThreadPoolExecutor priorityThreadPoolExecutor = this.f53008a;
                if (priorityThreadPoolExecutor == null || priorityThreadPoolExecutor.isShutdown()) {
                    int iM75419t = m67983e() ? new C12526j().m75419t() : C1444b.m8313s();
                    C11839m.m70688i("CloudBackupV3TaskManager", "sliceExecutor poolSize:" + iM75419t);
                    this.f53008a = new PriorityThreadPoolExecutor(iM75419t, iM75419t, 1L, TimeUnit.MILLISECONDS);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: e */
    public final boolean m67983e() {
        return C12590s0.m75823Z0() || C0224k0.a.m1574c("ro.build.hw_emui_lite.enable", false);
    }

    /* renamed from: f */
    public void m67984f(String str) {
        ArrayList arrayList;
        Object obj = f53007e;
        synchronized (obj) {
            try {
                arrayList = new ArrayList();
                synchronized (obj) {
                    try {
                        List<CloudBackupBaseTask> list = this.f53009b.get(str);
                        if (list != null && !list.isEmpty()) {
                            Iterator<CloudBackupBaseTask> it = list.iterator();
                            while (it.hasNext()) {
                                arrayList.add(it.next());
                            }
                            list.clear();
                            this.f53009b.remove(str);
                        }
                    } finally {
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((CloudBackupBaseTask) it2.next()).cancel(false);
        }
        f53007e.notifyAll();
    }

    /* renamed from: g */
    public void m67985g(String str, CloudBackupBaseTask cloudBackupBaseTask) {
        Object obj = f53007e;
        synchronized (obj) {
            try {
                List<CloudBackupBaseTask> list = this.f53009b.get(str);
                if (list != null) {
                    list.remove(cloudBackupBaseTask);
                }
                obj.notifyAll();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: h */
    public void m67986h() {
        ArrayList arrayList = new ArrayList();
        synchronized (f53007e) {
            try {
                Iterator<Map.Entry<String, List<CloudBackupBaseTask>>> it = this.f53009b.entrySet().iterator();
                while (it.hasNext()) {
                    Iterator<CloudBackupBaseTask> it2 = it.next().getValue().iterator();
                    while (it2.hasNext()) {
                        arrayList.add(it2.next());
                    }
                }
                this.f53009b.clear();
            } finally {
            }
        }
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            ((CloudBackupBaseTask) it3.next()).cancel(false);
        }
        synchronized (f53006d) {
            try {
                PriorityThreadPoolExecutor priorityThreadPoolExecutor = this.f53008a;
                if (priorityThreadPoolExecutor != null && !priorityThreadPoolExecutor.isShutdown()) {
                    this.f53008a.shutdownNow();
                }
            } finally {
            }
        }
    }
}
