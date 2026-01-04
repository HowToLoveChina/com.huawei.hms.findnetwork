package com.huawei.hicloud.notification.data;

import android.content.Context;
import android.content.p017pm.IPackageStatsObserver;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageStats;
import android.os.RemoteException;
import android.os.SystemClock;
import com.huawei.android.backup.service.logic.RequestPackageSize;
import com.huawei.android.backup.service.utils.BackupConstant;
import com.huawei.android.backup.service.utils.C2157a;
import com.huawei.hicloud.notification.log.NotifyLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import p015ak.C0209d;
import p015ak.C0213f;
import p699v4.C13334c;

/* loaded from: classes6.dex */
public class AppDataCollector extends BaseDataCollector {
    private static final String TAG = "AppDataCollector";
    private ConcurrentHashMap<String, Long> packageSizeMap;
    private RequestPackageSize requestPackageSize;

    /* renamed from: com.huawei.hicloud.notification.data.AppDataCollector$1 */
    public class BinderC49111 extends IPackageStatsObserver.Stub {
        final /* synthetic */ String val$packageName;

        public BinderC49111(String str) {
            this.val$packageName = str;
        }

        @Override // android.content.p017pm.IPackageStatsObserver
        public void onGetStatsCompleted(PackageStats packageStats, boolean z10) throws RemoteException {
            long j10;
            if (z10) {
                j10 = BackupConstant.m13146t().containsValue(packageStats.packageName) ? packageStats.dataSize : packageStats.cacheSize + packageStats.dataSize;
            } else {
                NotifyLogger.m29914e(AppDataCollector.TAG, "getPackageSize fail: " + this.val$packageName);
                j10 = 0;
            }
            AppDataCollector.this.pushPackageSizeToMap(packageStats.packageName, j10);
        }
    }

    private void getAppInfo() {
        NotifyLogger.m29915i(TAG, "getAppInfo");
        Context contextM1377a = C0213f.m1377a();
        List<PackageInfo> installedPackages = contextM1377a.getPackageManager().getInstalledPackages(64);
        ArrayList arrayList = new ArrayList();
        Set<String> setM13200h = C2157a.m13200h();
        int i10 = 0;
        for (PackageInfo packageInfo : installedPackages) {
            if (!setM13200h.contains(packageInfo.packageName) && C13334c.m79959C(packageInfo.applicationInfo.sourceDir)) {
                arrayList.add(packageInfo.packageName);
                i10++;
            }
        }
        this.mAmount = i10;
        this.mSize = getPackageVolmueInfo(contextM1377a, arrayList);
        NotifyLogger.m29915i(TAG, "mAmount=" + this.mAmount + ",mSize=" + this.mSize);
    }

    private void getPackageSize(Context context, PackageManager packageManager, String str) {
        NotifyLogger.m29915i(TAG, "O Version getPackageSize ");
        if (this.requestPackageSize == null) {
            this.requestPackageSize = new RequestPackageSize(context);
        }
        long jM12746b = this.requestPackageSize.m12746b(str, C0209d.m1222X());
        NotifyLogger.m29915i(TAG, "getPackageSize packageName = " + str + ", dataSize = " + jM12746b);
        pushPackageSizeToMap(str, jM12746b);
    }

    public void pushPackageSizeToMap(String str, long j10) {
        if (this.packageSizeMap == null) {
            this.packageSizeMap = new ConcurrentHashMap<>();
        }
        this.packageSizeMap.put(str, Long.valueOf(j10));
    }

    private boolean waitGetPackageSize(String str) {
        if (this.packageSizeMap == null) {
            NotifyLogger.m29914e(TAG, "packageSizeMap null");
            return false;
        }
        int i10 = 0;
        while (true) {
            if (this.packageSizeMap.size() != 0 && this.packageSizeMap.containsKey(str)) {
                return true;
            }
            if (i10 >= 20000) {
                NotifyLogger.m29915i(TAG, "get package size timeout: " + str);
                return false;
            }
            SystemClock.sleep(20L);
            i10++;
        }
    }

    @Override // com.huawei.hicloud.notification.data.BaseDataCollector
    public void execute() {
        getAppInfo();
    }

    public long getPackageVolmueInfo(Context context, List<String> list) {
        NotifyLogger.m29915i(TAG, "getPackageVolmueInfo");
        this.packageSizeMap = new ConcurrentHashMap<>();
        PackageManager packageManager = context.getPackageManager();
        if (list != null) {
            for (String str : list) {
                getPackageSize(context, packageManager, str);
                waitGetPackageSize(str);
            }
        }
        Iterator<Map.Entry<String, Long>> it = this.packageSizeMap.entrySet().iterator();
        long jLongValue = 0;
        while (it.hasNext()) {
            jLongValue += it.next().getValue().longValue();
        }
        return jLongValue;
    }
}
