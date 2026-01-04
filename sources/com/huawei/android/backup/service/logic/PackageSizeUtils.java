package com.huawei.android.backup.service.logic;

import android.content.Context;
import android.content.p017pm.IPackageStatsObserver;
import android.content.pm.PackageManager;
import android.content.pm.PackageStats;
import android.os.RemoteException;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.service.utils.BackupConstant;
import com.huawei.android.backup.service.utils.C2157a;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import p229di.C9153r;
import p699v4.C13348q;

/* loaded from: classes.dex */
public class PackageSizeUtils {

    /* renamed from: a */
    public ConcurrentHashMap<String, Long> f9583a;

    /* renamed from: b */
    public RequestPackageSize f9584b;

    /* renamed from: com.huawei.android.backup.service.logic.PackageSizeUtils$1 */
    public class BinderC21231 extends IPackageStatsObserver.Stub {
        public BinderC21231() {
        }

        @Override // android.content.p017pm.IPackageStatsObserver
        public void onGetStatsCompleted(PackageStats packageStats, boolean z10) throws RemoteException {
            PackageSizeUtils.this.m12743h(packageStats.packageName, PackageSizeUtils.this.m12739d(packageStats, z10));
        }
    }

    public PackageSizeUtils(Context context) {
        if (context == null) {
            return;
        }
        this.f9584b = new RequestPackageSize(context);
    }

    /* renamed from: c */
    public long m12738c(Context context, String str, int i10) {
        Long l10;
        this.f9583a = new ConcurrentHashMap<>();
        if (context == null) {
            return 0L;
        }
        m12740e(context, context.getPackageManager(), str, i10);
        if (!m12744i(str) || (l10 = this.f9583a.get(str)) == null) {
            return 0L;
        }
        return l10.longValue();
    }

    /* renamed from: d */
    public final long m12739d(PackageStats packageStats, boolean z10) {
        if (!z10) {
            C2111d.m12654j("PackageSizeUtils", "getPackageSize fail, packageName: ", packageStats.packageName);
            return 0L;
        }
        if (BackupConstant.m13146t().containsValue(packageStats.packageName)) {
            return packageStats.dataSize;
        }
        return packageStats.dataSize + packageStats.cacheSize;
    }

    /* renamed from: e */
    public final void m12740e(Context context, PackageManager packageManager, String str, int i10) {
        if (!C2157a.m13177L(context)) {
            m12743h(str, 0L);
            return;
        }
        if (this.f9584b == null) {
            this.f9584b = new RequestPackageSize(context);
        }
        long jM12746b = this.f9584b.m12746b(str, i10);
        m12743h(str, jM12746b);
        C2111d.m12653i("PackageSizeUtils", "get package size, packageName: " + str + ", size: " + jM12746b);
    }

    /* renamed from: f */
    public ConcurrentHashMap<String, Long> m12741f(Context context, Set<String> set) {
        this.f9583a = new ConcurrentHashMap<>();
        if (context == null || C13348q.m80082b(set)) {
            return this.f9583a;
        }
        PackageManager packageManager = context.getPackageManager();
        for (String str : set) {
            if (BackupConstant.m13146t().containsKey(str)) {
                str = BackupConstant.m13146t().get(str);
            }
            m12740e(context, packageManager, str, C9153r.m57494b());
            m12744i(str);
        }
        return this.f9583a;
    }

    /* renamed from: g */
    public ConcurrentHashMap<String, Long> m12742g(Context context, String[] strArr) {
        ConcurrentHashMap<String, Long> concurrentHashMap = new ConcurrentHashMap<>();
        this.f9583a = concurrentHashMap;
        if (context == null) {
            return concurrentHashMap;
        }
        PackageManager packageManager = context.getPackageManager();
        if (strArr == null || strArr.length == 0) {
            for (Map.Entry<String, String> entry : BackupConstant.m13146t().entrySet()) {
                m12740e(context, packageManager, entry.getValue(), C9153r.m57494b());
                m12744i(entry.getValue());
            }
        } else {
            for (String str : strArr) {
                C2111d.m12653i("PackageSizeUtils", "get packageVolumeInfo: " + str);
                if (BackupConstant.m13146t().containsKey(str)) {
                    String str2 = BackupConstant.m13146t().get(str);
                    m12740e(context, packageManager, str2, C9153r.m57494b());
                    m12744i(str2);
                }
            }
        }
        return this.f9583a;
    }

    /* renamed from: h */
    public final void m12743h(String str, long j10) {
        if (this.f9583a == null) {
            this.f9583a = new ConcurrentHashMap<>();
        }
        this.f9583a.put(str, Long.valueOf(j10));
    }

    /* renamed from: i */
    public final boolean m12744i(String str) {
        C2111d.m12653i("PackageSizeUtils", "wait get package size return true, sdk version is more than android O.");
        return true;
    }
}
