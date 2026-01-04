package com.huawei.android.hicloud.task.simple;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.huawei.android.backup.filelogic.utils.PmsCheckUtil;
import com.huawei.android.backup.service.utils.C2157a;
import com.huawei.android.hicloud.cloudbackup.process.CBAccess;
import com.huawei.android.hicloud.cloudbackup.process.CloneService;
import com.huawei.android.hicloud.cloudbackup.process.task.QueryOmAppBackupScopeTask;
import com.huawei.android.hicloud.cloudbackup.process.util.CloudBackupAppDataUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.SplitAppUtil;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackupLanguageUtil;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.android.hicloud.cloudbackup.util.TransferedUtil;
import com.huawei.fastengine.fastview.NavigationUtils;
import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.openalliance.p169ad.constant.VastAttribute;
import fk.C9721b;
import hu.C10343b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0214f0;
import p015ak.C0221j;
import p429kk.C11058a;
import p510o5.C11818a;
import p514o9.C11829c;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p617rl.C12519c;
import p617rl.C12526j;
import p617rl.C12534r;
import p618rm.C12565k;
import p618rm.C12586r;
import p618rm.C12590s0;
import p682ul.C13219m;
import p684un.C13225d;
import p709vj.C13452e;
import p848zl.C14333b;
import pm.C12176c;
import tl.C13026e;

/* renamed from: com.huawei.android.hicloud.task.simple.e0 */
/* loaded from: classes3.dex */
public class C3026e0 extends AbstractC12367d {

    /* renamed from: h */
    public C12534r f13230h;

    /* renamed from: a */
    public List<String> f13223a = new ArrayList();

    /* renamed from: b */
    public List<String> f13224b = new ArrayList();

    /* renamed from: e */
    public CloneService f13227e = CloneService.getInstance();

    /* renamed from: f */
    public long f13228f = 0;

    /* renamed from: g */
    public long f13229g = 0;

    /* renamed from: c */
    public String f13225c = C11058a.m66627b("02013");

    /* renamed from: d */
    public C13026e f13226d = new C13026e();

    /* renamed from: f */
    public static void m18291f() {
        boolean zM75158X0 = C12515a.m75110o().m75158X0(C3026e0.class.getName());
        C11839m.m70688i("GetOptionsInfoStageOneTask", "checkTaskRunning isOptionTaskRunning:" + zM75158X0);
        if (!zM75158X0) {
            C12515a.m75110o().m75172d(new C3026e0());
        }
        m18293m();
        C11839m.m70686d("GetOptionsInfoStageOneTask", "checkTaskRunning end");
    }

    private Context getContext() {
        return C0213f.m1377a();
    }

    private void initConfig() {
        this.f13230h = C12534r.m75443g();
    }

    public static void initSupportPmsMove() {
        C11839m.m70688i("GetOptionsInfoStageOneTask", "GetOptionsInfoStageOneTask initPmsMoveOrderSupported start.");
        try {
            C12565k.m75529o();
        } catch (Exception e10) {
            C11839m.m70687e("GetOptionsInfoStageOneTask", "GetOptionsInfoStageOneTask initPmsMoveOrderSupported error: " + e10.toString());
        }
        C11839m.m70688i("GetOptionsInfoStageOneTask", "GetOptionsInfoStageOneTask initPmsMoveOrderSupported end.");
    }

    /* renamed from: l */
    public static /* synthetic */ boolean m18292l(List list, BackupOptionItem backupOptionItem) {
        return list.contains(backupOptionItem.getAppId());
    }

    /* renamed from: m */
    public static boolean m18293m() {
        boolean zM75158X0 = C12515a.m75110o().m75158X0(C3026e0.class.getName());
        while (zM75158X0) {
            SystemClock.sleep(400L);
            zM75158X0 = C12515a.m75110o().m75158X0(C3026e0.class.getName());
        }
        return zM75158X0;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        try {
            try {
                initConfig();
                C11839m.m70688i("GetOptionsInfoStageOneTask", "GetOptionsInfoStageOneTask start");
                initSupportPmsMove();
                C0221j.m1509s(getContext());
                this.f13224b = new C12526j().m75386e();
                C11839m.m70688i("GetOptionsInfoStageOneTask", "appBackupBlackList: " + this.f13224b);
                this.f13223a.addAll(C2157a.m13200h());
                this.f13223a.addAll(C14333b.m85454J());
                this.f13223a.addAll(this.f13224b);
                this.f13226d.m78387h(this.f13224b);
                getBackupModuleInfo();
                this.f13226d.m78387h(C12590s0.m75727B0());
            } catch (C9721b e10) {
                C11839m.m70687e("GetOptionsInfoStageOneTask", "GetOptionsInfoStageOneTask run  error : " + e10.getMessage());
                reportCloneTaskException(e10);
            } catch (Exception e11) {
                reportCloneTaskException(e11);
            }
        } finally {
            C11839m.m70688i("GetOptionsInfoStageOneTask", "GetOptionsInfoStageOneTask end, option task complete");
        }
    }

    /* renamed from: g */
    public final void m18294g() throws C9721b {
        if (!ICBUtil.isSupportGallery(getContext())) {
            C11839m.m70688i("GetOptionsInfoStageOneTask", "unsupport gallery backup.");
        } else {
            C11839m.m70688i("GetOptionsInfoStageOneTask", "get GalleryModule");
            generateSysItem(HNConstants.DataType.MEDIA, HNConstants.DataType.MEDIA);
        }
    }

    public final BackupOptionItem generateAppItem(String str, boolean z10) throws C9721b {
        BackupOptionItem backupOptionItemQueryItem = TransferedUtil.queryItem(str, false);
        if (backupOptionItemQueryItem == null) {
            BackupOptionItem backupOptionItem = new BackupOptionItem(str, "thirdAppData");
            backupOptionItem.setBackupSwitch(z10);
            this.f13226d.m78370E(backupOptionItem);
            return backupOptionItem;
        }
        if (backupOptionItemQueryItem.getOperateType() == 1) {
            return backupOptionItemQueryItem;
        }
        backupOptionItemQueryItem.setBackupSwitch(z10);
        return backupOptionItemQueryItem;
    }

    public final BackupOptionItem generateSysItem(String str, String str2) throws C9721b {
        BackupOptionItem backupOptionItemQueryItem = TransferedUtil.queryItem(str2, false);
        if (backupOptionItemQueryItem == null) {
            backupOptionItemQueryItem = new BackupOptionItem(str2, str);
            BackupOptionItem backupOptionItemQueryItem2 = TransferedUtil.queryItem(str, false);
            if (backupOptionItemQueryItem2 != null) {
                backupOptionItemQueryItem.setBackupSwitch(backupOptionItemQueryItem2.getBackupSwitch());
                backupOptionItemQueryItem.setOperateType(backupOptionItemQueryItem2.getOperateType());
            } else {
                backupOptionItemQueryItem.setBackupSwitch(true);
            }
            this.f13226d.m78370E(backupOptionItemQueryItem);
        }
        return backupOptionItemQueryItem;
    }

    public final void getBackupModuleInfo() throws C9721b, PackageManager.NameNotFoundException {
        C11839m.m70688i("GetOptionsInfoStageOneTask", "begin getBackupModuleInfo");
        this.f13228f = System.currentTimeMillis();
        List<String> listM73271n = C13452e.m80781L().m80887a1() ? C12176c.m73271n(null) : null;
        for (String str : C14333b.m85478m()) {
            List<String> childModuleList = getChildModuleList(str);
            if (!childModuleList.isEmpty()) {
                getSysItemFromModuleInfo(str, childModuleList, listM73271n);
            }
        }
        this.f13229g = System.currentTimeMillis();
        C11839m.m70688i("GetOptionsInfoStageOneTask", "get backup module info from clone time: " + (this.f13229g - this.f13228f));
        m18295h();
        m18294g();
        initVirtualAppData();
        C11839m.m70688i("GetOptionsInfoStageOneTask", "GetOptionsInfoStageOneTask end.");
    }

    public final List<String> getChildModuleList(String str) throws C9721b, PackageManager.NameNotFoundException {
        ArrayList arrayList = new ArrayList();
        if (HNConstants.DataType.CONTACT.equals(str)) {
            if (C11829c.m70546T0(getContext())) {
                arrayList.add(str);
            }
            getThirdAppDataModule();
        } else if ("HuaweiHiAi".equals(str)) {
            if (!C11818a.m70390h0(getContext())) {
                arrayList.add(str);
            }
        } else if ("HiCreate".equals(str)) {
            if (C0209d.m1184K0(getContext(), "com.huawei.hicreate")) {
                arrayList.add(str);
            }
        } else if (NavigationUtils.SMS_SCHEMA_PREF.equals(str)) {
            if (C11829c.m70523I0(getContext())) {
                arrayList.add(NavigationUtils.SMS_SCHEMA_PREF);
                arrayList.add("chatSms");
            }
        } else if ("calllog".equals(str)) {
            if (C11829c.m70546T0(getContext())) {
                arrayList.add(str);
            }
        } else if ("soundrecorder".equals(str)) {
            arrayList.add("soundrecorder");
            if (C11829c.m70546T0(getContext())) {
                arrayList.add("callRecorder");
            }
        } else if ("baseData".equals(str)) {
            ArrayList arrayList2 = new ArrayList(C14333b.m85482q());
            if (!C11829c.m70546T0(getContext())) {
                arrayList2.remove("harassment");
            }
            arrayList.addAll((Collection) arrayList2.parallelStream().filter(new Predicate() { // from class: com.huawei.android.hicloud.task.simple.b0
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return this.f13148a.m18296j((String) obj);
                }
            }).collect(Collectors.toList()));
        } else {
            arrayList.add(str);
        }
        C11839m.m70686d("GetOptionsInfoStageOneTask", " clone  getChildModuleList: " + arrayList.toString());
        return arrayList;
    }

    public final void getSysItemFromModuleInfo(String str, List<String> list, List<String> list2) throws C9721b {
        C11839m.m70688i("GetOptionsInfoStageOneTask", "get system item list: " + list);
        for (String str2 : list) {
            if (CBAccess.hasTaskWorking()) {
                C11839m.m70688i("GetOptionsInfoStageOneTask", "generate system module in backup or restore, return. appId: " + str);
                return;
            }
            Bundle backupModuleInfo = this.f13227e.getBackupModuleInfo(str2, false);
            if (backupModuleInfo == null) {
                C11839m.m70688i("GetOptionsInfoStageOneTask", "get backup module info from clone is time out, appId: " + str2);
                backupModuleInfo = new Bundle();
            }
            getSystemOptionsInfo(str, str2, new C10343b(backupModuleInfo).m63684f(str2));
            C11839m.m70688i("GetOptionsInfoStageOneTask", "appId: " + str2 + ", get system item from module info");
        }
    }

    public final BackupOptionItem getSystemOptionsInfo(String str, String str2, Bundle bundle) throws C9721b {
        BackupOptionItem backupOptionItemGenerateSysItem = generateSysItem(str, str2);
        if (bundle != null || str2.equals(HNConstants.DataType.CONTACT)) {
            C11839m.m70688i("GetOptionsInfoStageOneTask", "getSystemOptionsInfo" + new Gson().toJson(backupOptionItemGenerateSysItem));
            return backupOptionItemGenerateSysItem;
        }
        C11839m.m70688i("GetOptionsInfoStageOneTask", "bundle is null, not support clone, appId: " + str2);
        if ("chatSms".equals(str2)) {
            backupOptionItemGenerateSysItem.setItemTotal(0);
            backupOptionItemGenerateSysItem.setDataBytes(0L);
        }
        backupOptionItemGenerateSysItem.setIsDataEnable(-1);
        return backupOptionItemGenerateSysItem;
    }

    public final void getThirdAppDataModule() throws C9721b, PackageManager.NameNotFoundException {
        if (CBAccess.hasTaskWorking()) {
            C11839m.m70688i("GetOptionsInfoStageOneTask", "generate third app in backup or restore, return.");
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        Bundle backupModuleInfo = this.f13227e.getBackupModuleInfo("app", false);
        if (backupModuleInfo == null) {
            C11839m.m70688i("GetOptionsInfoStageOneTask", "third app return;");
            return;
        }
        Bundle bundle = (Bundle) new C10343b(backupModuleInfo).m63680b("app");
        if (bundle == null) {
            C11839m.m70688i("GetOptionsInfoStageOneTask", "value is null");
            return;
        }
        ArrayList<String> arrayListM63696r = new C10343b(bundle).m63696r("AppPackageList");
        if (arrayListM63696r == null) {
            arrayListM63696r = new ArrayList<>();
        }
        HashSet hashSet = new HashSet(arrayListM63696r);
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(getContext(), "backup_clone_app_sp", 0);
        sharedPreferencesM1382b.edit().clear().commit();
        sharedPreferencesM1382b.edit().putStringSet("backup_clone_third_app_list", hashSet).commit();
        arrayListM63696r.removeAll(this.f13223a);
        final String str = "1";
        Map<String, C13219m<String, Integer, Integer>> mapInit3rdAppTwinsList = SplitAppUtil.init3rdAppTwinsList(hashSet, new Function() { // from class: com.huawei.android.hicloud.task.simple.c0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f13159a.m18297k(str, (String) obj);
            }
        });
        arrayListM63696r.addAll(mapInit3rdAppTwinsList.keySet());
        arrayListM63696r.removeAll(this.f13223a);
        arrayListM63696r.removeAll(C12590s0.m75727B0());
        List<String> listM78398v = this.f13226d.m78398v("thirdAppData");
        for (String str2 : listM78398v) {
            if (!arrayListM63696r.contains(str2)) {
                this.f13226d.m78386g(str2);
            }
        }
        listM78398v.removeAll(arrayListM63696r);
        C11839m.m70688i("GetOptionsInfoStageOneTask", "waitDeleteAppids = " + listM78398v);
        if (listM78398v.size() > 0) {
            this.f13226d.m78387h(listM78398v);
        }
        C11839m.m70688i("GetOptionsInfoStageOneTask", "get thirdAppDataModule time: " + (System.currentTimeMillis() - jCurrentTimeMillis));
        getThirdAppOptionsInfo(arrayListM63696r, mapInit3rdAppTwinsList);
    }

    public final void getThirdAppOptionsInfo(List<String> list, Map<String, C13219m<String, Integer, Integer>> map) throws C9721b, PackageManager.NameNotFoundException {
        String strValueOf;
        int iIntValue;
        String strM79449b;
        C11839m.m70688i("GetOptionsInfoStageOneTask", "begin getThirdAppOptionsInfo");
        if (list.isEmpty()) {
            C11839m.m70688i("GetOptionsInfoStageOneTask", "app modules from clone is empty.");
            return;
        }
        C11839m.m70688i("GetOptionsInfoStageOneTask", "third app module list from clone: " + new Gson().toJson(list));
        PackageManager packageManager = getContext().getPackageManager();
        for (String str : list) {
            C13219m<String, Integer, Integer> c13219m = map.get(str);
            if (c13219m != null) {
                strM79449b = c13219m.m79449b();
                strValueOf = String.valueOf(c13219m.m79450c());
                iIntValue = c13219m.m79451d().intValue();
            } else {
                strValueOf = "0";
                iIntValue = 0;
                strM79449b = str;
            }
            boolean zM75158X0 = C12515a.m75110o().m75158X0(QueryOmAppBackupScopeTask.class.getName());
            while (zM75158X0) {
                SystemClock.sleep(500L);
                zM75158X0 = C12515a.m75110o().m75158X0(QueryOmAppBackupScopeTask.class.getName());
                C11839m.m70688i("GetOptionsInfoStageOneTask", "wait QueryOmAppBackupScopeTask appId " + str);
            }
            long versionCode = ICBUtil.getVersionCode(packageManager, strM79449b);
            String appName = ICBUtil.getAppName(packageManager, strM79449b, strValueOf);
            CloudBackupAppDataUtil cloudBackupAppDataUtil = new CloudBackupAppDataUtil(strM79449b, C12586r.m75711b(), versionCode, false, false);
            if (cloudBackupAppDataUtil.isAppDataAble() && PmsCheckUtil.m12611e()) {
                refreshThirdAppData("thirdAppData", str, iIntValue, strValueOf, strM79449b, appName, cloudBackupAppDataUtil.getDefaultSwitch(str, SplitAppUtil.isSplitApp(strValueOf), "GetOptionsInfoStageOneTask"));
            } else {
                refreshThirdAppData("thirdApp", str, iIntValue, strValueOf, strM79449b, appName, false);
            }
        }
        List<BackupOptionItem> listM78399w = this.f13226d.m78399w("thirdAppData");
        if (C13452e.m80781L().m80887a1()) {
            final List<String> listM73271n = C12176c.m73271n(null);
            listM78399w.removeIf(new Predicate() { // from class: com.huawei.android.hicloud.task.simple.d0
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return C3026e0.m18292l(listM73271n, (BackupOptionItem) obj);
                }
            });
        }
        C11839m.m70688i("GetOptionsInfoStageOneTask", "app data module load end.");
    }

    /* renamed from: h */
    public final void m18295h() throws C9721b {
        C11839m.m70688i("GetOptionsInfoStageOneTask", "initMusicModule");
        generateSysItem("music", "music");
    }

    public final void initVirtualAppData() {
        C11839m.m70688i("GetOptionsInfoStageOneTask", "<initVirtualAppData> start.");
        try {
            List<String> listM75297h = new C12519c().m75297h(1);
            List<String> listM78398v = this.f13226d.m78398v("virtualApp");
            listM78398v.removeAll(listM75297h);
            this.f13226d.m78387h(listM78398v);
            listM75297h.removeAll(C14333b.m85476k());
            C11839m.m70688i("GetOptionsInfoStageOneTask", "<initVirtualAppData> virtuals: " + listM75297h);
            for (String str : listM75297h) {
                CloudBackupAppDataUtil cloudBackupAppDataUtil = new CloudBackupAppDataUtil(str, C12586r.m75711b(), 0L, false, false);
                C11839m.m70688i("GetOptionsInfoStageOneTask", "<initVirtualAppData> isAppDataAble: " + cloudBackupAppDataUtil.isAppDataAble() + ", appId: " + str);
                if (cloudBackupAppDataUtil.isAppDataAble()) {
                    String virtualName = CloudBackupLanguageUtil.getVirtualName(str);
                    BackupOptionItem backupOptionItemM78401y = this.f13226d.m78401y(str);
                    if (backupOptionItemM78401y == null) {
                        backupOptionItemM78401y = new BackupOptionItem(str, "virtualApp");
                        backupOptionItemM78401y.setBackupSwitch(true);
                        backupOptionItemM78401y.setBackupData(true);
                        this.f13226d.m78370E(backupOptionItemM78401y);
                    }
                    backupOptionItemM78401y.setParent("virtualApp");
                    backupOptionItemM78401y.setAppName(virtualName);
                    this.f13226d.m78382Q(backupOptionItemM78401y);
                }
            }
            C11839m.m70688i("GetOptionsInfoStageOneTask", "<initVirtualAppData> end.");
        } catch (C9721b e10) {
            C11839m.m70687e("GetOptionsInfoStageOneTask", "query virtual app list error: " + e10.getMessage());
        }
    }

    /* renamed from: j */
    public final /* synthetic */ boolean m18296j(String str) {
        return !this.f13224b.contains(str);
    }

    /* renamed from: k */
    public final /* synthetic */ Boolean m18297k(String str, String str2) {
        return Boolean.valueOf(this.f13230h.m75451m(str2, str));
    }

    public final void refreshThirdAppData(String str, String str2, int i10, String str3, String str4, String str5, boolean z10) throws C9721b {
        if (SplitAppUtil.isSplitApp(str3)) {
            this.f13226d.m78369D(str, str2, i10, str3, str4, str5, z10);
            return;
        }
        String str6 = str2;
        BackupOptionItem backupOptionItemGenerateAppItem = generateAppItem(str2, z10);
        backupOptionItemGenerateAppItem.setParent(str);
        backupOptionItemGenerateAppItem.setBackupData(true);
        if (!TextUtils.isEmpty(str5)) {
            str6 = str5;
        }
        backupOptionItemGenerateAppItem.setAppName(str6);
        this.f13226d.m78382Q(backupOptionItemGenerateAppItem);
        C11839m.m70688i("GetOptionsInfoStageOneTask", "appId: " + backupOptionItemGenerateAppItem.getAppId() + " match om config, backup app data. ");
    }

    public final void reportCloneTaskException(Exception exc) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("traceID", this.f13225c);
        linkedHashMap.put(VastAttribute.ERROR, exc.getMessage());
        linkedHashMap.put("stack", C12590s0.m75731C0(exc));
        linkedHashMap.put("isRefurbish", String.valueOf(false));
        C13225d.m79490f1().m79567R("cloudbackup_option_module_status_exception", linkedHashMap);
        UBAAnalyze.m29947H("CKC", "cloudbackup_option_module_status_exception", linkedHashMap);
    }
}
