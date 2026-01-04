package com.huawei.android.hicloud.task.simple;

import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.huawei.android.hicloud.cloudbackup.bean.AppCohortsInfo;
import com.huawei.android.hicloud.cloudbackup.process.util.ListUtils;
import com.huawei.fastengine.fastview.NavigationUtils;
import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import gp.C10028c;
import io.C10582a;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import p015ak.C0213f;
import p015ak.C0214f0;
import p015ak.C0241z;
import p020ap.C1006a;
import p336he.C10155f;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p618rm.C12590s0;
import p684un.C13225d;
import p709vj.C13452e;
import p746wn.C13622a;
import p815ym.AbstractC14026a;
import p848zl.C14333b;
import tl.C13026e;

/* renamed from: com.huawei.android.hicloud.task.simple.c */
/* loaded from: classes3.dex */
public class C3017c extends AbstractC12367d {

    /* renamed from: h */
    public static SharedPreferences f13151h;

    /* renamed from: a */
    public int f13152a;

    /* renamed from: b */
    public ArrayList<String> f13153b;

    /* renamed from: c */
    public ArrayList<String> f13154c;

    /* renamed from: d */
    public boolean f13155d;

    /* renamed from: e */
    public Map<String, Boolean> f13156e;

    /* renamed from: f */
    public C13026e f13157f;

    /* renamed from: g */
    public boolean f13158g;

    /* renamed from: com.huawei.android.hicloud.task.simple.c$a */
    public static class a implements C10582a.c {
        @Override // io.C10582a.c
        public void onResult(int i10) {
            C11839m.m70688i("BackupModuleSwitchReportTask", "BackupModuleSwitchReportTask,onResult: " + i10);
            if (C3017c.f13151h != null) {
                if (i10 == 0) {
                    C3017c.f13151h.edit().putBoolean("registerswitch", true).commit();
                } else {
                    C3017c.f13151h.edit().putBoolean("registerswitch", false).commit();
                }
            }
        }
    }

    public C3017c(ArrayList<String> arrayList) {
        this.f13152a = 0;
        this.f13155d = false;
        this.f13156e = new HashMap();
        this.f13153b = arrayList;
        this.f13157f = new C13026e();
    }

    private static Context getContext() {
        return C0213f.m1377a();
    }

    /* renamed from: j */
    private Map<String, String> m18196j() {
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        HashMap map = new HashMap();
        if (C10155f.m63286j(getContext())) {
            map.put("sync.type", "AUTO");
        } else {
            map.put("sync.type", "DISABLED");
        }
        if (this.f13153b == null) {
            C11839m.m70689w("BackupModuleSwitchReportTask", "moduleList is null");
            return map;
        }
        if (C13452e.m80781L().m80887a1() && this.f13153b.contains("backup_key")) {
            this.f13153b.add("base_backup_new_key");
            this.f13153b.add("full_backup_key");
        }
        Iterator<String> it = this.f13153b.iterator();
        while (it.hasNext()) {
            String next = it.next();
            boolean zM62388s = c10028cM62182c0.m62388s(next);
            String str = zM62388s ? "AUTO" : "DISABLED";
            if ("backup_key".equals(next)) {
                f13151h = C0214f0.m1382b(getContext(), "backup_report_status_sp", 0);
                if (zM62388s) {
                    m18198e(map, new HashSet<>());
                }
                map.put("backup.cloudbak", str);
            } else if ("base_backup_new_key".equals(next)) {
                map.put("backup.cloudbakbase", str);
            } else if ("full_backup_key".equals(next)) {
                map.put("backup.cloudbakfull", str);
            } else if ("autorecordingkey".equals(next)) {
                map.put("backup.recording", str);
            } else if ("autosmslistkey".equals(next)) {
                map.put("backup.sms", str);
            } else if ("autocallloglistkey".equals(next)) {
                map.put("backup.callog", str);
            } else if ("autophonemanagerkey".equals(next)) {
                map.put("backup.harassment", str);
            }
        }
        return map;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        Map<String, String> mapM18201h;
        if (getContext() == null) {
            return;
        }
        String strM81958d = C13622a.m81958d("03003");
        if (this.f13152a == 2) {
            mapM18201h = new HashMap<>();
        } else if (this.f13155d) {
            mapM18201h = m18197d(m18199f());
        } else if (this.f13158g) {
            Map<String, Boolean> map = this.f13156e;
            if (map == null || map.isEmpty()) {
                return;
            } else {
                mapM18201h = m18201h();
            }
        } else {
            ArrayList<String> arrayList = this.f13153b;
            if (arrayList == null || arrayList.isEmpty()) {
                return;
            } else {
                mapM18201h = m18196j();
            }
        }
        if (mapM18201h == null || mapM18201h.isEmpty()) {
            return;
        }
        new C10582a(strM81958d).m64930c0(mapM18201h, "1", new a(), this.f13158g);
    }

    /* renamed from: d */
    public final Map<String, String> m18197d(HashSet<String> hashSet) {
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        HashMap map = new HashMap();
        boolean zM62388s = c10028cM62182c0.m62388s("backup_key");
        f13151h = C0214f0.m1382b(getContext(), "backup_report_status_sp", 0);
        if (zM62388s) {
            m18198e(map, hashSet);
        }
        return map;
    }

    /* renamed from: e */
    public void m18198e(Map<String, String> map, HashSet<String> hashSet) {
        if (this.f13157f == null) {
            this.f13157f = new C13026e();
        }
        List<BackupOptionItem> listM78397u = this.f13157f.m78397u();
        List<BackupOptionItem> listM78399w = this.f13157f.m78399w("thirdAppData");
        if (listM78397u == null || listM78399w == null) {
            return;
        }
        listM78397u.removeAll(listM78399w);
        m18203l(m18200g(listM78397u, hashSet), map);
        m18204m(m18200g(listM78399w, hashSet), map);
    }

    /* renamed from: f */
    public final HashSet<String> m18199f() {
        HashSet<String> hashSet = new HashSet<>();
        if (AbstractC14026a.m84159a(this.f13154c)) {
            return hashSet;
        }
        Iterator<String> it = this.f13154c.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next());
        }
        return hashSet;
    }

    /* renamed from: g */
    public List<BackupOptionItem> m18200g(List<BackupOptionItem> list, HashSet<String> hashSet) {
        if (AbstractC14026a.m84159a(list) || AbstractC14026a.m84159a(hashSet)) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (BackupOptionItem backupOptionItem : list) {
            if (hashSet.contains(backupOptionItem.getAppId())) {
                arrayList.add(backupOptionItem);
            }
        }
        return arrayList;
    }

    /* renamed from: h */
    public final Map<String, String> m18201h() {
        HashMap map = new HashMap();
        for (Map.Entry<String, Boolean> entry : this.f13156e.entrySet()) {
            String key = entry.getKey();
            map.put((C14333b.m85476k().contains(key) || "safebox1".equals(key) || "doc1".equals(key)) ? m18202k(key) : "b3." + key, entry.getValue().booleanValue() ? "AUTO" : "DISABLED");
        }
        return map;
    }

    /* renamed from: k */
    public final String m18202k(String str) {
        if (C14333b.m85456L().containsKey(str)) {
            return C14333b.m85456L().get(str);
        }
        return "bs." + str;
    }

    /* renamed from: l */
    public final void m18203l(List<BackupOptionItem> list, Map<String, String> map) {
        if (getContext() == null) {
            return;
        }
        for (BackupOptionItem backupOptionItem : list) {
            String parent = backupOptionItem.getParent();
            if (!"baseData".equals(parent) && !"thirdAppData".equals(parent)) {
                String appId = backupOptionItem.getAppId();
                boolean backupSwitch = backupOptionItem.getBackupSwitch();
                String str = backupSwitch ? "AUTO" : "DISABLED";
                if ("virtualApp".equals(parent)) {
                    map.put("bs." + appId, str);
                } else {
                    if (NavigationUtils.SMS_SCHEMA_PREF.equals(appId)) {
                        map.put("bs.sms", str);
                    }
                    if ("calllog".equals(appId)) {
                        map.put("bs.calllog", str);
                    }
                    if ("harassment".equals(appId)) {
                        map.put("bs.harassment", str);
                    }
                    if ("soundrecorder".equals(appId)) {
                        map.put("bs.recording", str);
                    }
                    if ("music".equals(appId)) {
                        map.put("bs.music", str);
                    }
                    if (HNConstants.DataType.CONTACT.equals(appId)) {
                        map.put("bs.contact", str);
                    }
                    if ("calendar".equals(appId)) {
                        map.put("bs.calendar", str);
                    }
                    if ("Memo".equals(appId)) {
                        map.put("bs.memo", str);
                    }
                    if (HNConstants.DataType.MEDIA.equals(appId)) {
                        m18206o(backupSwitch, map);
                    }
                }
            }
        }
    }

    /* renamed from: m */
    public final void m18204m(List<BackupOptionItem> list, Map<String, String> map) {
        for (BackupOptionItem backupOptionItem : list) {
            map.put("b3." + backupOptionItem.getAppId(), backupOptionItem.getBackupSwitch() ? "AUTO" : "DISABLED");
        }
    }

    /* renamed from: n */
    public long m18205n() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(12, 59);
        calendar.set(13, 59);
        calendar.set(14, 0);
        calendar.add(5, -1);
        calendar.set(11, 23);
        return calendar.getTime().getTime();
    }

    /* renamed from: o */
    public final void m18206o(boolean z10, Map<String, String> map) {
        boolean zM5975v = C1006a.m5936k().m5975v(getContext());
        C11839m.m70686d("BackupModuleSwitchReportTask", "generalAlbumOnBySp  " + zM5975v);
        if (zM5975v) {
            return;
        }
        map.put("bs.gallery", z10 ? "AUTO" : "DISABLED");
    }

    /* renamed from: p */
    public final void m18207p(UsageStats usageStats, HashMap<String, ArrayList<AppCohortsInfo>> map, long[] jArr) {
        String packageName = usageStats.getPackageName();
        long totalTimeInForeground = usageStats.getTotalTimeInForeground() / 1000;
        try {
            int iIntValue = ((Integer) usageStats.getClass().getDeclaredMethod("getAppLaunchCount", new Class[0]).invoke(usageStats, new Object[0])).intValue();
            ArrayList<AppCohortsInfo> arrayList = map.get(packageName);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                map.put(packageName, arrayList);
            }
            AppCohortsInfo appCohortsInfo = new AppCohortsInfo();
            appCohortsInfo.setBeginTime(String.valueOf(jArr[0]));
            appCohortsInfo.setEndTime(String.valueOf(jArr[1]));
            appCohortsInfo.setForegroundTime(String.valueOf(totalTimeInForeground));
            appCohortsInfo.setLaunchCount(String.valueOf(iIntValue));
            arrayList.add(appCohortsInfo);
        } catch (Exception e10) {
            C11839m.m70687e("BackupModuleSwitchReportTask", "getDeclaredMethod error: " + e10.toString());
        }
    }

    /* renamed from: q */
    public void m18208q(long[] jArr, HashMap<String, ArrayList<AppCohortsInfo>> map) {
        Map<String, UsageStats> mapQueryAndAggregateUsageStats;
        UsageStatsManager usageStatsManager = (UsageStatsManager) getContext().getSystemService("usagestats");
        if (usageStatsManager == null || (mapQueryAndAggregateUsageStats = usageStatsManager.queryAndAggregateUsageStats(jArr[0], jArr[1])) == null) {
            return;
        }
        Iterator<Map.Entry<String, UsageStats>> it = mapQueryAndAggregateUsageStats.entrySet().iterator();
        while (it.hasNext()) {
            m18207p(it.next().getValue(), map, jArr);
        }
    }

    /* renamed from: r */
    public void m18209r() {
        int iM1685c;
        if (C12590s0.m75837c1()) {
            m18211t();
            C11839m.m70688i("BackupModuleSwitchReportTask", "isJustBoot");
            return;
        }
        long jM18205n = m18205n();
        HashMap<String, ArrayList<AppCohortsInfo>> map = new HashMap<>();
        for (int i10 = 0; i10 < 7; i10++) {
            long[] jArr = new long[2];
            if (i10 != 0) {
                jM18205n -= 1000;
            }
            jArr[1] = jM18205n;
            jM18205n -= 86399000;
            jArr[0] = jM18205n;
            m18208q(jArr, map);
        }
        ArrayList<AppCohortsInfo> arrayList = new ArrayList<>();
        for (Map.Entry<String, ArrayList<AppCohortsInfo>> entry : map.entrySet()) {
            String key = entry.getKey();
            ArrayList<AppCohortsInfo> value = entry.getValue();
            new LinkedHashMap().put("packageName", key);
            StringBuilder sb2 = new StringBuilder();
            AppCohortsInfo appCohortsInfo = new AppCohortsInfo();
            long jM1688f = 0;
            if (value == null || value.isEmpty()) {
                iM1685c = 0;
            } else {
                iM1685c = 0;
                for (int i11 = 0; i11 < value.size(); i11++) {
                    AppCohortsInfo appCohortsInfo2 = value.get(i11);
                    sb2.append(appCohortsInfo2.getBeginTime());
                    sb2.append("|");
                    sb2.append(appCohortsInfo2.getEndTime());
                    sb2.append("|");
                    String launchCount = appCohortsInfo2.getLaunchCount();
                    sb2.append(launchCount);
                    sb2.append("|");
                    String foregroundTime = appCohortsInfo2.getForegroundTime();
                    sb2.append(foregroundTime);
                    if (i11 != value.size() - 1) {
                        sb2.append(",");
                    }
                    iM1685c += C0241z.m1685c(launchCount);
                    jM1688f += C0241z.m1688f(foregroundTime);
                }
            }
            appCohortsInfo.setAppCohortsInfo(sb2.toString());
            appCohortsInfo.setForegroundTime(String.valueOf(jM1688f));
            appCohortsInfo.setLaunchCount(String.valueOf(iM1685c));
            appCohortsInfo.setPackageName(key);
            arrayList.add(appCohortsInfo);
        }
        m18210s(arrayList);
    }

    /* renamed from: s */
    public final void m18210s(ArrayList<AppCohortsInfo> arrayList) {
        if (arrayList.isEmpty()) {
            return;
        }
        List listPartition = ListUtils.partition(arrayList, 10);
        if (listPartition.isEmpty()) {
            return;
        }
        for (int i10 = 0; i10 < listPartition.size(); i10++) {
            String json = new Gson().toJson((List) listPartition.get(i10));
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("appUsage", json);
            C13225d.m79490f1().m79591l0("cloud_app_usage", linkedHashMap);
            UBAAnalyze.m29958S("PVC", "cloud_app_usage", "4", "100", linkedHashMap);
        }
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public boolean syncLock() {
        return false;
    }

    /* renamed from: t */
    public final void m18211t() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("app_usage_no_report", "reportAppUsageJustBoot");
        C13225d.m79490f1().m79591l0("cloud_app_usage", linkedHashMap);
        UBAAnalyze.m29958S("PVC", "cloud_app_usage", "4", "100", linkedHashMap);
    }

    public C3017c(ArrayList<String> arrayList, boolean z10) {
        this.f13152a = 0;
        this.f13155d = false;
        this.f13156e = new HashMap();
        this.f13154c = arrayList;
        this.f13157f = new C13026e();
        this.f13155d = z10;
    }

    public C3017c(boolean z10, Map<String, Boolean> map) {
        this.f13152a = 0;
        this.f13155d = false;
        HashMap map2 = new HashMap();
        this.f13156e = map2;
        map2.clear();
        this.f13156e.putAll(map);
        this.f13157f = new C13026e();
        this.f13158g = z10;
    }

    public C3017c(int i10) {
        this.f13152a = 0;
        this.f13155d = false;
        this.f13156e = new HashMap();
        this.f13152a = i10;
        this.f13157f = new C13026e();
    }
}
