package p344hp;

import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.huawei.android.content.pm.ApplicationInfoEx;
import com.huawei.android.hicloud.cloudbackup.process.util.AppDataSizeUtil;
import com.huawei.hicloud.cloudbackup.p104v3.core.module.nextrestore.nextmodule.NextRestoreConstants;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import p015ak.C0213f;
import p514o9.C11839m;

/* renamed from: hp.b */
/* loaded from: classes.dex */
public class C10333b {

    /* renamed from: a */
    public static final long f50015a = TimeUnit.DAYS.toMillis(1);

    /* renamed from: b */
    public static final Set<String> f50016b = new a();

    /* renamed from: hp.b$a */
    public class a extends HashSet<String> {
        public a() {
            add(NotifyConstants.InterfaceC4908FA.PACKAGE_NAME);
            add("com.huawei.hidisk");
            add(NextRestoreConstants.PKG_NAME_FILE_MANAGER);
        }
    }

    /* renamed from: hp.b$b */
    public static class b {

        /* renamed from: a */
        public static C10333b f50017a = new C10333b(null);
    }

    public /* synthetic */ C10333b(a aVar) {
        this();
    }

    /* renamed from: c */
    public static C10333b m63630c() {
        return b.f50017a;
    }

    /* renamed from: a */
    public final ArrayList<C10332a> m63631a(Context context, Map<String, UsageStats> map, List<PackageInfo> list, PackageManager packageManager, long j10, long j11) {
        ApplicationInfo applicationInfo;
        ArrayList<C10332a> arrayList = new ArrayList<>();
        for (PackageInfo packageInfo : list) {
            if (packageInfo != null && (applicationInfo = packageInfo.applicationInfo) != null && !TextUtils.isEmpty(applicationInfo.packageName) && !m63639j(applicationInfo)) {
                long jM63633d = m63633d(applicationInfo.packageName, packageInfo.lastUpdateTime, map, j10);
                int i10 = (int) ((j11 - jM63633d) / f50015a);
                String installerPackageName = packageManager.getInstallerPackageName(applicationInfo.packageName);
                boolean zM63636g = m63636g(installerPackageName);
                if (i10 >= 3) {
                    C10332a c10332a = new C10332a();
                    c10332a.m63624u(applicationInfo.packageName);
                    c10332a.m63623t(m63632b(applicationInfo, packageManager));
                    c10332a.m63622s(packageManager.getApplicationIcon(applicationInfo));
                    c10332a.m63625v(AppDataSizeUtil.getAppTotalSize(context, applicationInfo.packageName));
                    c10332a.m63629z(false);
                    c10332a.m63611A(installerPackageName);
                    c10332a.m63628y(jM63633d);
                    c10332a.m63627x(i10);
                    arrayList.add(c10332a);
                    m63638i(c10332a);
                } else if (zM63636g) {
                    C10332a c10332a2 = new C10332a();
                    c10332a2.m63624u(applicationInfo.packageName);
                    c10332a2.m63623t(m63632b(applicationInfo, packageManager));
                    c10332a2.m63622s(packageManager.getApplicationIcon(applicationInfo));
                    c10332a2.m63625v(AppDataSizeUtil.getAppTotalSize(context, applicationInfo.packageName));
                    c10332a2.m63629z(true);
                    c10332a2.m63611A(installerPackageName);
                    c10332a2.m63628y(jM63633d);
                    c10332a2.m63627x(i10);
                    arrayList.add(c10332a2);
                    m63638i(c10332a2);
                } else {
                    C11839m.m70686d("SmartClearAppManager", "needFilterApp for exclude appName: " + applicationInfo.packageName + ", dayNotUsed: " + i10 + ", subSource: " + installerPackageName + ", lastTimeUsed: " + jM63633d);
                }
            }
        }
        C11839m.m70688i("SmartClearAppManager", "smart clean app list: " + arrayList.size());
        return arrayList;
    }

    /* renamed from: b */
    public final String m63632b(ApplicationInfo applicationInfo, PackageManager packageManager) {
        String string = packageManager.getApplicationLabel(applicationInfo).toString();
        return string.length() > 128 ? string.substring(0, 128) : string;
    }

    /* renamed from: d */
    public final long m63633d(String str, long j10, Map<String, UsageStats> map, long j11) {
        UsageStats usageStats = map.get(str);
        if (usageStats == null) {
            C11839m.m70686d("SmartClearAppManager", "usageStats null, getLastTimeUsed=" + j10);
            return j10;
        }
        long lastTimeUsed = usageStats.getLastTimeUsed();
        if (lastTimeUsed < j11) {
            C11839m.m70686d("SmartClearAppManager", "lastTimeUsed invalid, getLastTimeUsed=" + j10);
            return j10;
        }
        C11839m.m70686d("SmartClearAppManager", "getLastTimeUsed=" + lastTimeUsed);
        return lastTimeUsed;
    }

    /* renamed from: e */
    public final boolean m63634e(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return f50016b.contains(str);
    }

    /* renamed from: f */
    public final boolean m63635f(ApplicationInfo applicationInfo) {
        int hwFlags = new ApplicationInfoEx(applicationInfo).getHwFlags();
        return ((33554432 & hwFlags) == 0 && (hwFlags & HwRecyclerView.ITEM_TYPE_NO_SCALE_CARD_MASK) == 0) ? false : true;
    }

    /* renamed from: g */
    public final boolean m63636g(String str) {
        return ("com.huawei.appmarket".equals(str) || "com.huawei.hidisk".equals(str) || "com.huawei.ohos.famanager".equals(str)) ? false : true;
    }

    /* renamed from: h */
    public final boolean m63637h(ApplicationInfo applicationInfo) {
        int i10 = applicationInfo.flags;
        return (i10 & 1) == 1 || (i10 & 128) != 0;
    }

    /* renamed from: i */
    public final void m63638i(C10332a c10332a) {
        C11839m.m70686d("SmartClearAppManager", "include appName: " + c10332a.m63615f() + ", appLabel: " + c10332a.m63614e() + ", appSize: " + c10332a.m63616h() + ", sourceInvalid: " + c10332a.m63621r() + ", subSource: " + c10332a.m63619p() + ", dayNotUsed: " + c10332a.m63617i() + ", lastTime: " + c10332a.m63618k());
    }

    /* renamed from: j */
    public final boolean m63639j(ApplicationInfo applicationInfo) {
        if (m63634e(applicationInfo.packageName)) {
            C11839m.m70686d("SmartClearAppManager", "needFilterApp for whiteList: " + applicationInfo.packageName);
            return true;
        }
        if (m63637h(applicationInfo)) {
            C11839m.m70686d("SmartClearAppManager", "needFilterApp for system: " + applicationInfo.packageName);
            return true;
        }
        if (!m63635f(applicationInfo)) {
            return false;
        }
        C11839m.m70686d("SmartClearAppManager", "needFilterApp for preInstall: " + applicationInfo.packageName);
        return true;
    }

    /* renamed from: k */
    public List<C10332a> m63640k() {
        Map<String, UsageStats> arrayMap;
        C11839m.m70688i("SmartClearAppManager", "queryAppInfoList");
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70689w("SmartClearAppManager", "context is null");
            return new ArrayList();
        }
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.add(1, -5);
            long timeInMillis = calendar.getTimeInMillis();
            long jCurrentTimeMillis = System.currentTimeMillis();
            UsageStatsManager usageStatsManager = (UsageStatsManager) contextM1377a.getSystemService("usagestats");
            if (usageStatsManager != null) {
                arrayMap = usageStatsManager.queryAndAggregateUsageStats(timeInMillis, jCurrentTimeMillis);
            } else {
                C11839m.m70689w("SmartClearAppManager", "usageStatsManager is null");
                arrayMap = new ArrayMap<>();
            }
            Map<String, UsageStats> map = arrayMap;
            C11839m.m70688i("SmartClearAppManager", "usageStatsMap: " + map.size());
            PackageManager packageManager = contextM1377a.getPackageManager();
            List<PackageInfo> installedPackages = packageManager.getInstalledPackages(0);
            C11839m.m70688i("SmartClearAppManager", "packageInfoList: " + installedPackages.size());
            return m63631a(contextM1377a, map, installedPackages, packageManager, timeInMillis, jCurrentTimeMillis);
        } catch (Exception e10) {
            C11839m.m70689w("SmartClearAppManager", "queryAppInfoList error: " + e10.toString());
            return new ArrayList();
        }
    }

    public C10333b() {
    }
}
