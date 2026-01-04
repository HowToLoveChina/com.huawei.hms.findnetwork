package com.huawei.android.hicloud.cloudbackup.process.task;

import android.os.Build;
import com.huawei.android.hicloud.cloudbackup.manager.CloudBackupBaseTask;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import p514o9.C11839m;
import p617rl.C12526j;

/* loaded from: classes2.dex */
public class CloudBackupCreateManager {
    private static final String TAG = "CloudBackupCreateManager";
    private static CloudBackupCreateManager instance = new CloudBackupCreateManager();
    private static final Object CREATE_LOCK = new Object();
    private static final Object CREATE = new Object();
    private ExecutorService service = null;
    private ConcurrentHashMap<String, List<CloudBackupBaseTask>> tasksMap = new ConcurrentHashMap<>();
    private int createPoolSize = 1;

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

    public static CloudBackupCreateManager getInstance() {
        return instance;
    }

    private void initExecutors() {
        synchronized (CREATE_LOCK) {
            try {
                ExecutorService executorService = this.service;
                if (executorService == null || executorService.isShutdown()) {
                    int createThreadSize = getCreateThreadSize();
                    this.createPoolSize = createThreadSize;
                    this.service = Executors.newFixedThreadPool(createThreadSize);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void addTask(String str, CloudBackupBaseTask cloudBackupBaseTask) {
        initExecutors();
        synchronized (CREATE) {
            try {
                cloudBackupBaseTask.setFuture(this.service.submit(cloudBackupBaseTask));
                List<CloudBackupBaseTask> arrayList = this.tasksMap.get(str);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(cloudBackupBaseTask);
                this.tasksMap.put(str, arrayList);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void await(CloudBackupBaseTask cloudBackupBaseTask) {
        while (!cloudBackupBaseTask.isAbort()) {
            synchronized (CREATE) {
                try {
                    Iterator<Map.Entry<String, List<CloudBackupBaseTask>>> it = this.tasksMap.entrySet().iterator();
                    int size = 0;
                    while (it.hasNext()) {
                        size += it.next().getValue().size();
                    }
                    C11839m.m70686d(TAG, "initCreateExecutors, create executor size = " + size);
                    if (size < this.createPoolSize * 2) {
                        return;
                    }
                    try {
                        CREATE.wait(300L);
                    } catch (InterruptedException unused) {
                        C11839m.m70689w(TAG, "task file interrupted.");
                    }
                } finally {
                }
            }
        }
    }

    public void removeTask(String str, CloudBackupBaseTask cloudBackupBaseTask) {
        Object obj = CREATE;
        synchronized (obj) {
            try {
                List<CloudBackupBaseTask> list = this.tasksMap.get(str);
                if (list != null) {
                    list.remove(cloudBackupBaseTask);
                }
                obj.notifyAll();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void shutdownExecutor() {
        ArrayList arrayList = new ArrayList();
        synchronized (CREATE) {
            try {
                Iterator<Map.Entry<String, List<CloudBackupBaseTask>>> it = this.tasksMap.entrySet().iterator();
                while (it.hasNext()) {
                    arrayList.addAll(it.next().getValue());
                }
                this.tasksMap.clear();
            } finally {
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((CloudBackupBaseTask) it2.next()).cancel(false);
        }
        synchronized (CREATE_LOCK) {
            try {
                ExecutorService executorService = this.service;
                if (executorService != null && !executorService.isShutdown()) {
                    this.service.shutdownNow();
                }
            } finally {
            }
        }
    }

    public void syncLock(String str, CloudBackupBaseTask cloudBackupBaseTask) {
        while (!cloudBackupBaseTask.isAbort()) {
            Object obj = CREATE;
            synchronized (obj) {
                try {
                    List<CloudBackupBaseTask> arrayList = this.tasksMap.get(str);
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                    }
                    if (arrayList.isEmpty()) {
                        return;
                    }
                    try {
                        obj.wait(300L);
                    } catch (InterruptedException unused) {
                        C11839m.m70689w(TAG, "task file interrupted.");
                    }
                } finally {
                }
            }
        }
    }

    public void removeTask(String str) {
        ArrayList arrayList;
        Object obj = CREATE;
        synchronized (obj) {
            try {
                arrayList = new ArrayList();
                synchronized (obj) {
                    try {
                        List<CloudBackupBaseTask> list = this.tasksMap.get(str);
                        if (list != null && !list.isEmpty()) {
                            arrayList.addAll(list);
                            list.clear();
                            this.tasksMap.remove(str);
                        }
                    } finally {
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((CloudBackupBaseTask) it.next()).cancel(false);
        }
        CREATE.notifyAll();
    }
}
