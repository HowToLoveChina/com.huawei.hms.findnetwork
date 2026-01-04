package com.huawei.android.hicloud.cloudbackup.process.task;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.huawei.android.backup.filelogic.utils.PmsCheckUtil;
import com.huawei.android.backup.service.logic.installedapps.C2150h;
import com.huawei.android.backup.service.utils.C2157a;
import com.huawei.android.hicloud.cloudbackup.bean.CloudBackupOptionInfo;
import com.huawei.android.hicloud.cloudbackup.process.CBAccess;
import com.huawei.android.hicloud.cloudbackup.process.CloneService;
import com.huawei.android.hicloud.cloudbackup.process.util.CloudBackupAppDataUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.SplitAppUtil;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.android.hicloud.cloudbackup.util.TransferedUtil;
import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import fk.C9721b;
import gp.C10028c;
import hu.C10343b;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import p015ak.C0213f;
import p015ak.C0241z;
import p514o9.C11839m;
import p616rk.C12515a;
import p617rl.C12519c;
import p617rl.C12534r;
import p618rm.C12541c;
import p618rm.C12586r;
import p618rm.C12590s0;
import p682ul.C13219m;
import p840zd.C14229k2;
import p848zl.C14333b;
import tl.C13026e;

/* loaded from: classes2.dex */
public class BackupModuleInfoQueryLogic {
    private static final String TAG = "BackupModuleInfoQueryLogic";
    private CloudBackupOptionInfo appOptionInfo;
    private final BackupType backupType;
    private final Context context;
    private final String from;
    private final boolean isCheckGallery;
    private final boolean isQueryAllModules;
    private final boolean needQueryUserPackage;
    private C12534r settingHelper;
    private final List<String> virtual;

    /* renamed from: com.huawei.android.hicloud.cloudbackup.process.task.BackupModuleInfoQueryLogic$1 */
    public static /* synthetic */ class C25621 {

        /* renamed from: $SwitchMap$com$huawei$android$hicloud$cloudbackup$process$task$BackupModuleInfoQueryLogic$BackupType */
        static final /* synthetic */ int[] f11709xc357a110;

        static {
            int[] iArr = new int[BackupType.values().length];
            f11709xc357a110 = iArr;
            try {
                iArr[BackupType.REFURBISH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11709xc357a110[BackupType.TEMPORARY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public enum BackupType {
        STANDARD,
        REFURBISH,
        TEMPORARY;

        public int getAppType() {
            int i10 = C25621.f11709xc357a110[ordinal()];
            return (i10 == 1 || i10 == 2) ? 2 : 1;
        }

        public C13026e getBackupOperator() {
            int i10 = C25621.f11709xc357a110[ordinal()];
            return i10 != 1 ? i10 != 2 ? new C13026e(false) : new C14229k2() : new C13026e(true);
        }
    }

    public BackupModuleInfoQueryLogic(boolean z10, BackupType backupType, String str) {
        this(C0213f.m1377a(), z10, backupType, str);
    }

    public static void addNewBmBaseDataItem(List<BackupOptionItem> list) {
        BackupOptionItem backupOptionItem = new BackupOptionItem();
        backupOptionItem.setAppId("newBmBaseItem");
        backupOptionItem.setParent("newBmBaseItem");
        backupOptionItem.setBackupSwitch(C10028c.m62182c0().m62303a1());
        backupOptionItem.setDataEnable(-1);
        backupOptionItem.setDataBytes(-1L);
        list.add(backupOptionItem);
    }

    private BackupOptionItem generateAppItem(String str, int i10, String str2, String str3, boolean z10) {
        BackupOptionItem backupOptionItemQueryItem = TransferedUtil.queryItem(str, i10, this.backupType.getBackupOperator());
        if (backupOptionItemQueryItem != null) {
            if (backupOptionItemQueryItem.getOperateType() == 1) {
                return backupOptionItemQueryItem;
            }
            backupOptionItemQueryItem.setBackupSwitch(z10);
            return backupOptionItemQueryItem;
        }
        BackupOptionItem backupOptionItem = new BackupOptionItem(str, "thirdAppData");
        backupOptionItem.setBackupSwitch(z10);
        backupOptionItem.setSplitApkType(str2);
        backupOptionItem.setOriBackupAppName(str3);
        backupOptionItem.setUid(i10);
        return backupOptionItem;
    }

    private boolean get3rdAppList(List<String> list) throws C9721b {
        if (this.isQueryAllModules) {
            List<PackageInfo> installedPackages = this.context.getPackageManager().getInstalledPackages(64);
            final List<String> listM75299j = new C12519c().m75299j();
            final Set<String> setM13200h = C2157a.m13200h();
            list.addAll((List) installedPackages.stream().filter(new Predicate() { // from class: com.huawei.android.hicloud.cloudbackup.process.task.b
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return BackupModuleInfoQueryLogic.lambda$get3rdAppList$1(setM13200h, (PackageInfo) obj);
                }
            }).map(new Function() { // from class: com.huawei.android.hicloud.cloudbackup.process.task.c
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return ((PackageInfo) obj).packageName;
                }
            }).filter(new Predicate() { // from class: com.huawei.android.hicloud.cloudbackup.process.task.d
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return BackupModuleInfoQueryLogic.lambda$get3rdAppList$3(listM75299j, (String) obj);
                }
            }).collect(Collectors.toList()));
            return false;
        }
        Bundle backupModuleInfo = CloneService.getInstance().getBackupModuleInfo("app", false);
        if (backupModuleInfo == null) {
            C11839m.m70688i(TAG, "init3rdAppDataItemsList third app return;");
            return true;
        }
        Bundle bundle = (Bundle) new C10343b(backupModuleInfo).m63680b("app");
        if (bundle == null) {
            C11839m.m70688i(TAG, "value is null");
            return true;
        }
        ArrayList<String> arrayListM63696r = new C10343b(bundle).m63696r("AppPackageList");
        if (arrayListM63696r != null) {
            list.addAll(arrayListM63696r);
        }
        return false;
    }

    private List<BackupOptionItem> init3rdAppDataItemsList() throws C9721b, PackageManager.NameNotFoundException {
        String strValueOf;
        String strM79449b;
        int iIntValue;
        ArrayList arrayList = new ArrayList();
        if (!this.isQueryAllModules && CBAccess.hasTaskWorking()) {
            C11839m.m70688i(TAG, "init third app in backup or restore, return.");
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (get3rdAppList(arrayList2)) {
            return arrayList;
        }
        List<String> listM75486a = C12541c.m75486a(this.isQueryAllModules);
        arrayList2.removeAll(listM75486a);
        final C12534r c12534rM75443g = C12534r.m75443g();
        BackupType backupType = this.backupType;
        final String str = backupType == BackupType.REFURBISH ? "2" : backupType == BackupType.TEMPORARY ? "3" : "1";
        Map<String, C13219m<String, Integer, Integer>> mapInit3rdAppTwinsList = SplitAppUtil.init3rdAppTwinsList(arrayList2, new Function() { // from class: com.huawei.android.hicloud.cloudbackup.process.task.a
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return BackupModuleInfoQueryLogic.lambda$init3rdAppDataItemsList$0(c12534rM75443g, str, (String) obj);
            }
        });
        arrayList2.addAll(mapInit3rdAppTwinsList.keySet());
        arrayList2.removeAll(listM75486a);
        arrayList2.removeAll(C12590s0.m75727B0());
        C11839m.m70688i(TAG, "init thirdAppDataModule time: " + (System.currentTimeMillis() - jCurrentTimeMillis));
        if (!arrayList2.isEmpty()) {
            C11839m.m70688i(TAG, "third app module list from clone: " + new Gson().toJson(arrayList2));
            PackageManager packageManager = C0213f.m1377a().getPackageManager();
            for (String str2 : arrayList2) {
                boolean zM75158X0 = C12515a.m75110o().m75158X0(QueryOmAppBackupScopeTask.class.getName());
                while (zM75158X0) {
                    SystemClock.sleep(500L);
                    zM75158X0 = C12515a.m75110o().m75158X0(QueryOmAppBackupScopeTask.class.getName());
                    C11839m.m70688i(TAG, "wait QueryOmAppBackupScopeTask appId " + str2);
                }
                C13219m<String, Integer, Integer> c13219m = mapInit3rdAppTwinsList.get(str2);
                if (c13219m != null) {
                    strValueOf = String.valueOf(c13219m.m79451d());
                    strM79449b = c13219m.m79449b();
                    iIntValue = c13219m.m79450c().intValue();
                } else {
                    strValueOf = "";
                    strM79449b = str2;
                    iIntValue = 0;
                }
                long versionCode = ICBUtil.getVersionCode(packageManager, strM79449b);
                String appName = ICBUtil.getAppName(packageManager, strM79449b, strValueOf);
                String strM75711b = C12586r.m75711b();
                BackupType backupType2 = this.backupType;
                CloudBackupAppDataUtil cloudBackupAppDataUtil = new CloudBackupAppDataUtil(strM79449b, strM75711b, versionCode, backupType2 == BackupType.REFURBISH, backupType2 == BackupType.TEMPORARY);
                if (cloudBackupAppDataUtil.isAppDataAble() && PmsCheckUtil.m12611e()) {
                    BackupOptionItem backupOptionItemGenerateAppItem = generateAppItem(str2, iIntValue, strValueOf, strM79449b, cloudBackupAppDataUtil.getDefaultSwitch(str2, SplitAppUtil.isSplitApp(strValueOf), this.needQueryUserPackage, "BackupModuleInfoQueryLogic_" + this.from));
                    backupOptionItemGenerateAppItem.setParent("thirdAppData");
                    backupOptionItemGenerateAppItem.setBackupData(true);
                    backupOptionItemGenerateAppItem.setOriBackupAppName(strM79449b);
                    backupOptionItemGenerateAppItem.setSplitApkType(strValueOf);
                    String str3 = appName + strValueOf;
                    if (!TextUtils.isEmpty(str3)) {
                        str2 = str3;
                    }
                    backupOptionItemGenerateAppItem.setAppName(str2);
                    arrayList.add(backupOptionItemGenerateAppItem);
                }
            }
        }
        return arrayList;
    }

    private void initBackupModuleInfo() throws PackageManager.NameNotFoundException {
        initConfig();
        C11839m.m70688i(TAG, "initBackupModuleInfo start");
        List<BackupOptionItem> listInitVirtualOptionItemList = initVirtualOptionItemList();
        List<BackupOptionItem> listInitSystemOptionItemsList = initSystemOptionItemsList();
        List<BackupOptionItem> arrayList = new ArrayList<>();
        try {
            arrayList = init3rdAppDataItemsList();
        } catch (C9721b e10) {
            C11839m.m70688i(TAG, "init third app data error, " + e10.getMessage());
        }
        CloudBackupOptionInfo cloudBackupOptionInfo = new CloudBackupOptionInfo();
        this.appOptionInfo = cloudBackupOptionInfo;
        cloudBackupOptionInfo.setSystemItemList(listInitSystemOptionItemsList);
        this.appOptionInfo.setVirtualItemList(listInitVirtualOptionItemList);
        this.appOptionInfo.setThirdAppItemList(arrayList);
        this.appOptionInfo.setVirtuals(this.virtual);
        C11839m.m70688i(TAG, "initBackupModuleInfo end");
    }

    private void initConfig() {
        this.settingHelper = C12534r.m75443g();
    }

    private List<BackupOptionItem> initSystemOptionItemsList() {
        ArrayList arrayList = new ArrayList();
        for (String str : C12541c.m75487b(this.isQueryAllModules, this.virtual, this.isCheckGallery, C14333b.m85449E())) {
            BackupOptionItem backupOptionItem = new BackupOptionItem(str);
            BackupOptionItem backupOptionItemQueryItemByAppId = TransferedUtil.queryItemByAppId(str, this.backupType.getBackupOperator());
            backupOptionItem.setBackupSwitch(backupOptionItemQueryItemByAppId == null || backupOptionItemQueryItemByAppId.getBackupSwitch());
            if (backupOptionItem.getAppId().equals("music") && this.virtual.contains("music")) {
                backupOptionItem.setParent("virtualApp");
            }
            arrayList.add(backupOptionItem);
        }
        C11839m.m70688i(TAG, "init system items: " + new Gson().toJson(arrayList));
        return arrayList;
    }

    private List<BackupOptionItem> initVirtualOptionItemList() {
        ArrayList arrayList = new ArrayList();
        try {
            C12519c c12519c = new C12519c();
            this.virtual.addAll(c12519c.m75297h(this.backupType.getAppType()));
            boolean zContains = this.virtual.contains("music");
            this.virtual.removeAll(C14333b.m85476k());
            String str = this.context.getFilesDir() + "/cloudbackup";
            for (String str2 : this.virtual) {
                int iM1685c = C0241z.m1685c(c12519c.m75305p(str2));
                BackupType backupType = this.backupType;
                C12519c c12519c2 = c12519c;
                if (new CloudBackupAppDataUtil(str2, str, 0L, backupType == BackupType.REFURBISH, backupType == BackupType.TEMPORARY).isAppDataAble()) {
                    BackupOptionItem backupOptionItem = new BackupOptionItem(str2, "virtualApp");
                    BackupOptionItem backupOptionItemQueryItem = TransferedUtil.queryItem(str2, this.backupType.getBackupOperator());
                    backupOptionItem.setBackupSwitch(backupOptionItemQueryItem == null || backupOptionItemQueryItem.getBackupSwitch());
                    backupOptionItem.setBackupData(true);
                    backupOptionItem.setShowType(iM1685c);
                    arrayList.add(backupOptionItem);
                }
                c12519c = c12519c2;
            }
            if (zContains) {
                this.virtual.add("music");
            }
        } catch (C9721b e10) {
            C11839m.m70687e(TAG, "query virtual app list error: " + e10.getMessage());
        }
        return arrayList;
    }

    public static /* synthetic */ boolean lambda$get3rdAppList$1(Set set, PackageInfo packageInfo) {
        return C2150h.m12968b(packageInfo, set, null, 0, true);
    }

    public static /* synthetic */ boolean lambda$get3rdAppList$3(List list, String str) {
        return list.isEmpty() || list.contains(str);
    }

    public static /* synthetic */ Boolean lambda$init3rdAppDataItemsList$0(C12534r c12534r, String str, String str2) {
        return Boolean.valueOf(c12534r.m75451m(str2, str));
    }

    public List<BackupOptionItem> getAllBackupItems() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.appOptionInfo.getSystemItemList());
        arrayList.addAll(this.appOptionInfo.getThirdAppItemList());
        arrayList.addAll(this.appOptionInfo.getVirtualItemList());
        return arrayList;
    }

    public CloudBackupOptionInfo getAppOptionInfo() {
        return this.appOptionInfo;
    }

    public boolean isSupportSplitApp(String str) {
        C12534r c12534r = this.settingHelper;
        if (c12534r == null) {
            return false;
        }
        return c12534r.m75451m(str, this.backupType == BackupType.STANDARD ? "1" : "2");
    }

    public BackupModuleInfoQueryLogic(boolean z10, BackupType backupType, boolean z11, String str) {
        this(C0213f.m1377a(), z10, backupType, z11, str);
    }

    public BackupModuleInfoQueryLogic(Context context, boolean z10, BackupType backupType, String str) {
        this(context, z10, backupType, true, str);
    }

    public BackupModuleInfoQueryLogic(Context context, boolean z10, BackupType backupType, boolean z11, String str) throws PackageManager.NameNotFoundException {
        this.virtual = new ArrayList();
        this.context = context;
        this.isQueryAllModules = z10;
        this.backupType = backupType;
        this.isCheckGallery = BackupType.STANDARD.equals(backupType);
        this.needQueryUserPackage = z11;
        this.from = str;
        initBackupModuleInfo();
    }
}
