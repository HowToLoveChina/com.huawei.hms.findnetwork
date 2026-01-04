package com.huawei.android.hicloud.sync.syncutil;

import android.content.Context;
import android.os.SystemClock;
import com.huawei.android.hicloud.complexutil.CloudSyncUtil;
import com.huawei.android.hicloud.sync.service.aidl.SyncObserverServiceInvoker;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import p015ak.C0213f;
import p514o9.C11839m;
import p675uc.C13153a;
import p709vj.C13452e;

/* renamed from: com.huawei.android.hicloud.sync.syncutil.k */
/* loaded from: classes3.dex */
public class C2982k {

    /* renamed from: b */
    public static final C2982k f13021b = new C2982k();

    /* renamed from: a */
    public Context f13022a;

    /* renamed from: com.huawei.android.hicloud.sync.syncutil.k$b */
    public static class b implements Callable<Boolean> {

        /* renamed from: a */
        public Context f13023a;

        /* renamed from: b */
        public String f13024b;

        /* renamed from: c */
        public String f13025c;

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean call() throws Exception {
            boolean zM17898c;
            if (this.f13023a == null || this.f13024b == null) {
                zM17898c = true;
            } else {
                SystemClock.sleep(5000L);
                C11839m.m70688i("ResetSyncDataUtil", "DeleteSyncData start: syncType = " + this.f13024b);
                zM17898c = C2982k.m17898c(this.f13024b, this.f13023a);
                C13153a.m79132r(this.f13023a, this.f13024b, 2, this.f13025c);
            }
            C11839m.m70688i("ResetSyncDataUtil", "DeleteSyncData end: syncType = " + this.f13024b + ", deleteState = " + zM17898c);
            return Boolean.valueOf(zM17898c);
        }

        public b(Context context, String str, String str2) {
            this.f13023a = context;
            this.f13024b = str;
            this.f13025c = str2;
        }
    }

    /* renamed from: c */
    public static boolean m17898c(String str, Context context) {
        try {
            return C13153a.m79133s(str, context) == 0;
        } catch (SQLException unused) {
            C11839m.m70687e("ResetSyncDataUtil", "deleteTag SQLException");
            return false;
        } catch (Exception e10) {
            C11839m.m70687e("ResetSyncDataUtil", "deleteTag Exception = " + e10.toString());
            return false;
        }
    }

    /* renamed from: d */
    public static C2982k m17899d() {
        return f13021b;
    }

    /* renamed from: b */
    public final void m17900b() {
        C11839m.m70688i("ResetSyncDataUtil", "clearRiskInfo");
        String[] strArrSplit = C13452e.m80781L().m80967s0().split("_");
        if (strArrSplit.length > 0) {
            String str = strArrSplit[0];
            C11839m.m70688i("ResetSyncDataUtil", "clearRiskInfo: syncType = " + str);
            C2974c.m17829e(this.f13022a, str, "", 0);
        }
    }

    /* renamed from: e */
    public boolean m17901e(String str) {
        this.f13022a = C0213f.m1377a();
        C11839m.m70688i("ResetSyncDataUtil", "resetSyncData start");
        m17900b();
        boolean zM17902f = m17902f(CloudSyncUtil.m15985X(this.f13022a), str);
        C11839m.m70688i("ResetSyncDataUtil", "resetSyncData end: resetState = " + zM17902f);
        return zM17902f;
    }

    /* renamed from: f */
    public final boolean m17902f(ArrayList<String> arrayList, String str) {
        boolean z10 = true;
        if (arrayList.size() > 0) {
            ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(arrayList.size());
            ArrayList arrayList2 = new ArrayList();
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                C11839m.m70688i("ResetSyncDataUtil", "stopSyncTask: syncType = " + next);
                SyncObserverServiceInvoker.getInstance().stopSyncTask(next, 2029);
                arrayList2.add(executorServiceNewFixedThreadPool.submit(new b(this.f13022a, next, str)));
            }
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                try {
                    if (!((Boolean) ((Future) it2.next()).get()).booleanValue()) {
                        z10 = false;
                    }
                } catch (InterruptedException | ExecutionException e10) {
                    C11839m.m70687e("ResetSyncDataUtil", "deleteSyncData: " + e10.toString());
                }
            }
            executorServiceNewFixedThreadPool.shutdown();
        }
        return z10;
    }
}
