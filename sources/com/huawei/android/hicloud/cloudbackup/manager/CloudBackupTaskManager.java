package com.huawei.android.hicloud.cloudbackup.manager;

import android.os.Build;
import ck.C1444b;
import com.huawei.android.hicloud.cloudbackup.process.ICBBaseTask;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import p514o9.C11839m;
import p617rl.C12526j;
import p618rm.C12590s0;

/* loaded from: classes2.dex */
public class CloudBackupTaskManager {
    public static final int PMS_POOL_SIZE = 3;
    private static final String TAG = "CloudBackupTaskManager";
    private static CloudBackupTaskManager instance = new CloudBackupTaskManager();
    private static final Object MODULE_LOCK = new Object();
    private static final Object FILE_LOCK = new Object();
    private static final Object CREATE_LOCK = new Object();
    private static final Object PMS_LOCK = new Object();
    private static final Object MODULE = new Object();
    private static final Object FILE = new Object();
    private static final Object CREATE = new Object();
    private static final Object PMS = new Object();
    private ExecutorService moduleExecutor = null;
    private PriorityThreadPoolExecutor fileExecutor = null;
    private ExecutorService createExecutor = null;
    private ExecutorService pmsExecutor = null;
    private ConcurrentHashMap<String, CloudBackupBaseTask> moduleTaskMap = new ConcurrentHashMap<>();
    private List<CloudBackupBaseTask> moduleTasks = new ArrayList();
    private ConcurrentHashMap<String, List<CloudBackupBaseTask>> fileTaskMap = new ConcurrentHashMap<>();
    private List<CloudBackupBaseTask> createTasks = new ArrayList();
    private List<CloudBackupBaseTask> pmsTasks = new ArrayList();
    private int createPoolSize = 1;
    private int maxFileTaskSize = 0;

    public interface Await {
        boolean isAbort();
    }

    private int getCreateThreadSize() {
        C12526j c12526j = new C12526j();
        List<String> listM75371X0 = c12526j.m75371X0();
        if (listM75371X0 != null && !listM75371X0.isEmpty()) {
            String str = Build.MODEL;
            Iterator<String> it = listM75371X0.iterator();
            while (it.hasNext()) {
                if (str.startsWith(it.next())) {
                    return c12526j.m75400j0();
                }
            }
        }
        return c12526j.m75397i0();
    }

    public static CloudBackupTaskManager getInstance() {
        return instance;
    }

    private void initCreateExecutors() {
        synchronized (CREATE_LOCK) {
            try {
                ExecutorService executorService = this.createExecutor;
                if (executorService == null || executorService.isShutdown()) {
                    int createThreadSize = getCreateThreadSize();
                    this.createPoolSize = createThreadSize;
                    this.createExecutor = Executors.newFixedThreadPool(createThreadSize);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private void initFileExecutors() {
        int iM8308n = C1444b.m8308n();
        synchronized (FILE_LOCK) {
            try {
                PriorityThreadPoolExecutor priorityThreadPoolExecutor = this.fileExecutor;
                if (priorityThreadPoolExecutor == null || priorityThreadPoolExecutor.isShutdown()) {
                    this.fileExecutor = new PriorityThreadPoolExecutor(iM8308n, iM8308n, 1L, TimeUnit.MILLISECONDS);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private void initModuleExecutors() {
        int iM8297c = C1444b.m8297c();
        synchronized (MODULE_LOCK) {
            try {
                ExecutorService executorService = this.moduleExecutor;
                if (executorService == null || executorService.isShutdown()) {
                    this.moduleExecutor = Executors.newFixedThreadPool(iM8297c);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private void initPMSExecutors() {
        synchronized (PMS_LOCK) {
            try {
                ExecutorService executorService = this.pmsExecutor;
                if (executorService == null || executorService.isShutdown()) {
                    this.pmsExecutor = Executors.newFixedThreadPool(3);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void addCreateTask(String str, CloudBackupBaseTask cloudBackupBaseTask) {
        initCreateExecutors();
        synchronized (CREATE) {
            cloudBackupBaseTask.setFuture(this.createExecutor.submit(cloudBackupBaseTask));
            this.createTasks.add(cloudBackupBaseTask);
        }
    }

    public void addFileTask(String str, CloudBackupBaseTask cloudBackupBaseTask) {
        initFileExecutors();
        synchronized (FILE) {
            try {
                cloudBackupBaseTask.setFuture(this.fileExecutor.submit(cloudBackupBaseTask));
                List<CloudBackupBaseTask> arrayList = this.fileTaskMap.get(str);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(cloudBackupBaseTask);
                this.fileTaskMap.put(str, arrayList);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void addModuleTask(String str, CloudBackupBaseTask cloudBackupBaseTask) {
        initModuleExecutors();
        synchronized (MODULE) {
            try {
                CloudBackupBaseTask cloudBackupBaseTask2 = this.moduleTaskMap.get(str);
                if (cloudBackupBaseTask2 != null) {
                    cloudBackupBaseTask2.cancel(true);
                    this.moduleTaskMap.remove(str);
                }
                cloudBackupBaseTask.setFuture(this.moduleExecutor.submit(cloudBackupBaseTask));
                this.moduleTasks.add(cloudBackupBaseTask);
                this.moduleTaskMap.put(str, cloudBackupBaseTask);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void addPMSTask(CloudBackupBaseTask cloudBackupBaseTask) {
        initPMSExecutors();
        synchronized (PMS) {
            cloudBackupBaseTask.setFuture(this.pmsExecutor.submit(cloudBackupBaseTask));
            this.pmsTasks.add(cloudBackupBaseTask);
        }
    }

    public void await(Await await) {
        Long localLeftSpace = ICBUtil.getLocalLeftSpace();
        boolean z10 = localLeftSpace == null || localLeftSpace.longValue() < C12590s0.m75856h0() + 629145600;
        while (!await.isAbort()) {
            synchronized (FILE) {
                try {
                    int i10 = 2;
                    int iM8308n = C1444b.m8308n() * 2;
                    if (!z10 && (i10 = this.maxFileTaskSize) <= 0) {
                        i10 = iM8308n;
                    }
                    Iterator<Map.Entry<String, List<CloudBackupBaseTask>>> it = this.fileTaskMap.entrySet().iterator();
                    int size = 0;
                    while (it.hasNext()) {
                        size += it.next().getValue().size();
                    }
                    C11839m.m70686d(TAG, "initFileExecutors, file executor size = " + size + " ,maxTaskSize: " + i10);
                    if (size < i10) {
                        return;
                    }
                    try {
                        FILE.wait(300L);
                    } catch (InterruptedException unused) {
                        C11839m.m70689w(TAG, "task file interrupted.");
                    }
                } finally {
                }
            }
        }
    }

    public void awaitTask(ICBBaseTask iCBBaseTask) {
        while (!iCBBaseTask.isAbort()) {
            Object obj = CREATE;
            synchronized (obj) {
                int size = this.createTasks.size();
                C11839m.m70686d(TAG, "initCreateExecutors, create executor size = " + size);
                if (size < this.createPoolSize * 2) {
                    return;
                }
                try {
                    obj.wait(300L);
                } catch (InterruptedException unused) {
                    C11839m.m70689w(TAG, "task file interrupted.");
                }
            }
        }
    }

    public CloudBackupBaseTask getModuleTask(String str) {
        CloudBackupBaseTask cloudBackupBaseTask;
        synchronized (MODULE) {
            cloudBackupBaseTask = this.moduleTaskMap.get(str);
        }
        return cloudBackupBaseTask;
    }

    public void removeCreateTask(String str, CloudBackupBaseTask cloudBackupBaseTask) {
        Object obj = CREATE;
        synchronized (obj) {
            this.createTasks.remove(cloudBackupBaseTask);
            C11839m.m70686d(TAG, "removeCreateTask, appId = " + str + ", create executor size = " + this.createTasks.size());
            obj.notifyAll();
        }
    }

    public void removeFileTask(String str, CloudBackupBaseTask cloudBackupBaseTask) {
        Object obj = FILE;
        synchronized (obj) {
            try {
                List<CloudBackupBaseTask> list = this.fileTaskMap.get(str);
                if (list != null) {
                    list.remove(cloudBackupBaseTask);
                }
                obj.notifyAll();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void removeModuleTask(String str, CloudBackupBaseTask cloudBackupBaseTask) {
        Object obj = MODULE;
        synchronized (obj) {
            this.moduleTasks.remove(cloudBackupBaseTask);
            this.moduleTaskMap.remove(str);
            C11839m.m70686d(TAG, "removeModuleTask, appId = " + str + ", module executor size = " + this.moduleTasks.size());
            obj.notifyAll();
        }
    }

    public void setMaxFileTaskSize(int i10) {
        synchronized (FILE) {
            this.maxFileTaskSize = i10;
        }
    }

    public void shutDown() {
        shutdownModuleExecutor();
        shutdownFileExecutor();
    }

    public void shutdownCreateExecutor() {
        ArrayList arrayList = new ArrayList();
        synchronized (CREATE) {
            try {
                Iterator<CloudBackupBaseTask> it = this.createTasks.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next());
                }
                this.createTasks.clear();
            } finally {
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((CloudBackupBaseTask) it2.next()).cancel(false);
        }
        synchronized (CREATE_LOCK) {
            try {
                ExecutorService executorService = this.createExecutor;
                if (executorService != null && !executorService.isShutdown()) {
                    this.createExecutor.shutdownNow();
                }
            } finally {
            }
        }
    }

    public void shutdownFileExecutor() {
        ArrayList arrayList = new ArrayList();
        synchronized (FILE) {
            try {
                Iterator<Map.Entry<String, List<CloudBackupBaseTask>>> it = this.fileTaskMap.entrySet().iterator();
                while (it.hasNext()) {
                    Iterator<CloudBackupBaseTask> it2 = it.next().getValue().iterator();
                    while (it2.hasNext()) {
                        arrayList.add(it2.next());
                    }
                }
                this.fileTaskMap.clear();
                this.maxFileTaskSize = 0;
            } finally {
            }
        }
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            ((CloudBackupBaseTask) it3.next()).cancel(false);
        }
        synchronized (FILE_LOCK) {
            try {
                PriorityThreadPoolExecutor priorityThreadPoolExecutor = this.fileExecutor;
                if (priorityThreadPoolExecutor != null && !priorityThreadPoolExecutor.isShutdown()) {
                    this.fileExecutor.shutdownNow();
                }
            } finally {
            }
        }
    }

    public void shutdownModuleExecutor() {
        ArrayList arrayList = new ArrayList();
        synchronized (MODULE) {
            try {
                Iterator<CloudBackupBaseTask> it = this.moduleTasks.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next());
                }
                this.moduleTasks.clear();
            } finally {
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((CloudBackupBaseTask) it2.next()).cancel(false);
        }
        synchronized (MODULE_LOCK) {
            try {
                ExecutorService executorService = this.moduleExecutor;
                if (executorService != null && !executorService.isShutdown()) {
                    this.moduleExecutor.shutdownNow();
                }
            } finally {
            }
        }
    }

    public void shutdownPmsExecutor() {
        ArrayList arrayList = new ArrayList();
        synchronized (PMS) {
            try {
                Iterator<CloudBackupBaseTask> it = this.pmsTasks.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next());
                }
                this.pmsTasks.clear();
            } finally {
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((CloudBackupBaseTask) it2.next()).cancel(false);
        }
        synchronized (PMS_LOCK) {
            try {
                ExecutorService executorService = this.pmsExecutor;
                if (executorService != null && !executorService.isShutdown()) {
                    this.pmsExecutor.shutdownNow();
                }
            } finally {
            }
        }
    }

    public void removeFileTask(String str) {
        ArrayList arrayList;
        Object obj = FILE;
        synchronized (obj) {
            try {
                arrayList = new ArrayList();
                synchronized (obj) {
                    try {
                        List<CloudBackupBaseTask> list = this.fileTaskMap.get(str);
                        if (list != null && !list.isEmpty()) {
                            Iterator<CloudBackupBaseTask> it = list.iterator();
                            while (it.hasNext()) {
                                arrayList.add(it.next());
                            }
                            list.clear();
                            this.fileTaskMap.remove(str);
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
        FILE.notifyAll();
    }
}
