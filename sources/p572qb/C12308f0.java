package p572qb;

import android.text.TextUtils;
import com.huawei.android.hicloud.sync.bean.DownloadResult;
import com.huawei.android.hicloud.sync.protocol.C2931j;
import com.huawei.android.hicloud.sync.service.aidl.UnstructData;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import p514o9.C11839m;

/* renamed from: qb.f0 */
/* loaded from: classes3.dex */
public class C12308f0 {

    /* renamed from: c */
    public static final C12308f0 f57015c = new C12308f0();

    /* renamed from: d */
    public static final Object f57016d = new Object();

    /* renamed from: a */
    public final ConcurrentHashMap<String, ExecutorService> f57017a = new ConcurrentHashMap<>();

    /* renamed from: b */
    public final ConcurrentHashMap<String, ConcurrentHashMap<String, C2931j>> f57018b = new ConcurrentHashMap<>();

    /* renamed from: d */
    public static C12308f0 m74000d() {
        return f57015c;
    }

    /* renamed from: a */
    public Future<DownloadResult> m74001a(C2931j c2931j) {
        Future<DownloadResult> futureSubmit;
        synchronized (f57016d) {
            try {
                String strM17776j = c2931j.m17776j();
                String strM17775i = c2931j.m17775i();
                ExecutorService executorServiceNewFixedThreadPool = this.f57017a.get(strM17775i);
                if (executorServiceNewFixedThreadPool == null || executorServiceNewFixedThreadPool.isShutdown()) {
                    C11839m.m70689w("RequireDownTaskManager", "ExecutorService is null, create it");
                    executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(2);
                    this.f57017a.put(strM17775i, executorServiceNewFixedThreadPool);
                }
                ConcurrentHashMap<String, C2931j> concurrentHashMap = this.f57018b.get(strM17775i);
                if (concurrentHashMap == null) {
                    concurrentHashMap = new ConcurrentHashMap<>();
                    this.f57018b.put(strM17775i, concurrentHashMap);
                }
                futureSubmit = executorServiceNewFixedThreadPool.submit(c2931j);
                c2931j.m17740f(futureSubmit);
                concurrentHashMap.put(strM17776j, c2931j);
                this.f57018b.put(strM17775i, concurrentHashMap);
                C11839m.m70686d("RequireDownTaskManager", "addTask success, taskKey = " + strM17776j);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return futureSubmit;
    }

    /* renamed from: b */
    public void m74002b(String str, String str2) {
        synchronized (f57016d) {
            try {
                try {
                    ConcurrentHashMap<String, C2931j> concurrentHashMap = this.f57018b.get(str);
                    if (concurrentHashMap != null) {
                        Iterator<String> it = concurrentHashMap.keySet().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            if (TextUtils.equals(it.next(), str2)) {
                                C2931j c2931j = concurrentHashMap.get(str2);
                                if (c2931j != null) {
                                    c2931j.m17736b(true);
                                }
                            }
                        }
                    }
                    C11839m.m70686d("RequireDownTaskManager", "cancelTask success, taskKey = " + str2);
                } catch (Exception e10) {
                    C11839m.m70687e("RequireDownTaskManager", "cancelTask error " + e10.getMessage());
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: c */
    public String m74003c(String str, String str2, UnstructData unstructData) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || unstructData == null) {
            return "";
        }
        String name = unstructData.getName();
        return str + "_" + str2 + "_" + unstructData.getId() + "_" + unstructData.getHash() + "_" + name;
    }

    /* renamed from: e */
    public boolean m74004e(String str, String str2) {
        synchronized (f57016d) {
            try {
                if (this.f57018b.isEmpty()) {
                    return false;
                }
                ConcurrentHashMap<String, C2931j> concurrentHashMap = this.f57018b.get(str);
                if (concurrentHashMap == null) {
                    return false;
                }
                Iterator<String> it = concurrentHashMap.keySet().iterator();
                while (it.hasNext()) {
                    if (TextUtils.equals(str2, it.next())) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: f */
    public void m74005f(C2931j c2931j) {
        synchronized (f57016d) {
            if (c2931j == null) {
                return;
            }
            try {
                String strM17775i = c2931j.m17775i();
                String strM17776j = c2931j.m17776j();
                ConcurrentHashMap<String, C2931j> concurrentHashMap = this.f57018b.get(strM17775i);
                if (concurrentHashMap != null) {
                    concurrentHashMap.remove(strM17776j);
                }
                C11839m.m70686d("RequireDownTaskManager", "removeTask success, taskKey = " + strM17776j);
            } catch (Exception e10) {
                C11839m.m70688i("RequireDownTaskManager", "removeTask error " + e10.getMessage());
            }
        }
    }

    /* renamed from: g */
    public void m74006g() {
        synchronized (f57016d) {
            try {
                C11839m.m70688i("RequireDownTaskManager", "shutdownAllExecutors");
            } catch (Exception e10) {
                C11839m.m70687e("RequireDownTaskManager", "cancel all future error " + e10.getMessage());
            }
            if (this.f57018b.isEmpty()) {
                return;
            }
            Iterator<Map.Entry<String, ConcurrentHashMap<String, C2931j>>> it = this.f57018b.entrySet().iterator();
            while (it.hasNext()) {
                ConcurrentHashMap<String, C2931j> concurrentHashMap = this.f57018b.get(it.next().getKey());
                if (concurrentHashMap != null && !concurrentHashMap.isEmpty()) {
                    Iterator<String> it2 = concurrentHashMap.keySet().iterator();
                    while (it2.hasNext()) {
                        C2931j c2931j = concurrentHashMap.get(it2.next());
                        if (c2931j != null) {
                            c2931j.m17736b(true);
                        }
                        it2.remove();
                    }
                    concurrentHashMap.clear();
                }
            }
            this.f57018b.clear();
            try {
                Iterator<String> it3 = this.f57017a.keySet().iterator();
                while (it3.hasNext()) {
                    ExecutorService executorService = this.f57017a.get(it3.next());
                    if (executorService != null) {
                        executorService.shutdownNow();
                    }
                }
                this.f57017a.clear();
            } catch (Exception e11) {
                C11839m.m70687e("RequireDownTaskManager", "shutdown error " + e11.getMessage());
            }
        }
    }
}
