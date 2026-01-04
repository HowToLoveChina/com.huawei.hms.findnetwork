package pm;

import ck.C1444b;
import com.huawei.android.hicloud.cloudbackup.manager.CloudBackupBaseTask;
import com.huawei.android.hicloud.cloudbackup.manager.CloudBackupModuleTask;
import com.huawei.hicloud.cloudbackup.model.RestoreStatus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import p514o9.C11839m;

/* renamed from: pm.o */
/* loaded from: classes6.dex */
public class C12188o {

    /* renamed from: d */
    public static final Object f56551d = new Object();

    /* renamed from: e */
    public static C12188o f56552e = new C12188o();

    /* renamed from: b */
    public ThreadPoolExecutor f56554b;

    /* renamed from: a */
    public Map<String, CloudBackupModuleTask> f56553a = new ConcurrentHashMap();

    /* renamed from: c */
    public final int f56555c = C1444b.m8297c();

    /* renamed from: c */
    public static C12188o m73320c() {
        return f56552e;
    }

    /* renamed from: a */
    public Future<?> m73321a(CloudBackupModuleTask cloudBackupModuleTask, RestoreStatus restoreStatus) {
        Future<?> futureSubmit;
        synchronized (f56551d) {
            try {
                m73322b(cloudBackupModuleTask, restoreStatus);
                ThreadPoolExecutor threadPoolExecutor = this.f56554b;
                if (threadPoolExecutor == null || threadPoolExecutor.isShutdown()) {
                    this.f56554b = (ThreadPoolExecutor) Executors.newFixedThreadPool(this.f56555c);
                }
                futureSubmit = this.f56554b.submit(cloudBackupModuleTask);
                cloudBackupModuleTask.setFuture(futureSubmit);
                String str = restoreStatus.getAppId() + restoreStatus.getUid();
                this.f56553a.put(str, cloudBackupModuleTask);
                C11839m.m70686d("CloudRestoreV3ModuleTaskManager", "addDownloadTask key = " + str + ", downloadTasks size = " + this.f56553a.size() + " workQueue: " + this.f56554b.getQueue().size());
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return futureSubmit;
    }

    /* renamed from: b */
    public void m73322b(CloudBackupModuleTask cloudBackupModuleTask, RestoreStatus restoreStatus) throws InterruptedException {
        while (!cloudBackupModuleTask.isAbort()) {
            if (this.f56553a.size() < this.f56555c) {
                return;
            }
            try {
                f56551d.wait(300L);
            } catch (InterruptedException unused) {
                C11839m.m70689w("CloudRestoreV3ModuleTaskManager", "task file interrupted.");
            }
        }
        C11839m.m70686d("CloudRestoreV3ModuleTaskManager", "task await abortappId = " + restoreStatus.getAppId() + ", uid = " + restoreStatus.getUid());
    }

    /* renamed from: d */
    public void m73323d(RestoreStatus restoreStatus) {
        Object obj = f56551d;
        synchronized (obj) {
            String str = restoreStatus.getAppId() + restoreStatus.getUid();
            this.f56553a.remove(str);
            obj.notifyAll();
            C11839m.m70686d("CloudRestoreV3ModuleTaskManager", "removeDownLoadTask key = " + str + ", downloadTasks size = " + this.f56553a.size());
        }
    }

    /* renamed from: e */
    public void m73324e() {
        ArrayList arrayList;
        synchronized (f56551d) {
            arrayList = new ArrayList(this.f56553a.values());
            this.f56553a.clear();
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((CloudBackupBaseTask) it.next()).cancel(false);
        }
        synchronized (f56551d) {
            try {
                ThreadPoolExecutor threadPoolExecutor = this.f56554b;
                if (threadPoolExecutor != null && !threadPoolExecutor.isShutdown()) {
                    this.f56554b.shutdownNow();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
