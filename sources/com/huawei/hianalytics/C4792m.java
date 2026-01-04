package com.huawei.hianalytics;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hianalytics.core.common.EnvUtils;
import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.core.storage.DaoManager;
import com.huawei.hianalytics.util.HwSfpPolicyUtils;
import com.huawei.hms.network.embedded.C5863b6;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: com.huawei.hianalytics.m */
/* loaded from: classes5.dex */
public final class C4792m {

    /* renamed from: a */
    public static C4792m f21873a;

    /* renamed from: a */
    public long f21874a;

    /* renamed from: a */
    public String f21875a = null;

    /* renamed from: a */
    public final ConcurrentHashMap<String, AtomicLong> f21876a = new ConcurrentHashMap<>();

    /* renamed from: b */
    public final ConcurrentHashMap<String, AtomicLong> f21877b = new ConcurrentHashMap<>();

    public C4792m(Context context, String str, int i10) {
        if (context == null || TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("context is null, or dbName is empty");
        }
        try {
            DaoManager.getInstance().init(C4796o.m28972a(context, str, null, i10).getWritableDatabase());
            String str2 = context.isDeviceProtectedStorage() ? "S1" : "S2";
            HiLog.m28807d("DBController", "db label value: " + str2);
            HwSfpPolicyUtils.m29040a(context, str, str2, 0);
            this.f21874a = System.currentTimeMillis();
        } catch (Exception unused) {
            HiLog.m28812w("DBController", "Exception");
            throw new IllegalStateException("database init error");
        }
    }

    /* renamed from: a */
    public final void m28965a(String str, String str2) {
        ConcurrentHashMap<String, AtomicLong> concurrentHashMap;
        if (TextUtils.isEmpty(str)) {
            this.f21876a.clear();
            this.f21877b.clear();
        } else {
            if (TextUtils.isEmpty(str2)) {
                this.f21876a.remove(str);
                this.f21877b.remove(str);
                return;
            }
            if ("oper".equals(str2)) {
                concurrentHashMap = this.f21876a;
            } else if (!"maint".equals(str2)) {
                return;
            } else {
                concurrentHashMap = this.f21877b;
            }
            concurrentHashMap.remove(str);
        }
    }

    /* renamed from: b */
    public final AtomicLong m28966b(String str, String str2) {
        ConcurrentHashMap<String, AtomicLong> concurrentHashMap;
        if (System.currentTimeMillis() - this.f21874a > C5863b6.g.f26453g) {
            this.f21876a.clear();
            this.f21877b.clear();
            this.f21874a = System.currentTimeMillis();
        }
        if ("oper".equals(str2)) {
            concurrentHashMap = this.f21876a;
        } else {
            if (!"maint".equals(str2)) {
                HiLog.m28812w("DBController", "unknown event type: " + str2);
                return null;
            }
            concurrentHashMap = this.f21877b;
        }
        return concurrentHashMap.get(str);
    }

    /* renamed from: a */
    public final AtomicLong m28964a(String str, String str2) {
        ConcurrentHashMap<String, AtomicLong> concurrentHashMap;
        if (this.f21875a == null) {
            this.f21875a = C4785j.m28930b(EnvUtils.getAppContext());
        }
        AtomicLong atomicLong = new AtomicLong(DaoManager.getInstance().countBySubCount(str, str2, this.f21875a));
        if (!"oper".equals(str2)) {
            if ("maint".equals(str2)) {
                concurrentHashMap = this.f21877b;
            }
            return atomicLong;
        }
        concurrentHashMap = this.f21876a;
        concurrentHashMap.put(str, atomicLong);
        return atomicLong;
    }

    /* renamed from: a */
    public static C4792m m28963a(Context context) {
        if (f21873a == null) {
            synchronized (C4792m.class) {
                if (f21873a == null) {
                    f21873a = new C4792m(context, "haformal_event.db", 6);
                }
            }
        }
        return f21873a;
    }
}
