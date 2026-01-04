package com.huawei.android.hicloud.cloudbackup.process.util;

import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.bean.AppInfoList;
import com.huawei.android.hicloud.cloudbackup.bean.AppVer;
import com.huawei.android.hicloud.cloudbackup.bean.BlackModuleItem;
import com.huawei.android.hicloud.cloudbackup.bean.CloudBackup;
import com.huawei.android.hicloud.cloudbackup.bean.CloudBackupPathInfo;
import com.huawei.android.hicloud.cloudbackup.p076db.operator.SettingOperator;
import com.huawei.android.hicloud.cloudbackup.process.task.ReadOmConfigFileTask;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.cloud.base.util.C4633d0;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import fk.C9721b;
import hk.C10279b;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import nl.C11719a;
import p015ak.C0213f;
import p015ak.C0221j;
import p292fn.C9733f;
import p514o9.C11839m;
import p616rk.C12515a;
import p617rl.C12519c;
import p617rl.C12526j;
import p618rm.C12568l;
import p618rm.C12583q;
import p618rm.C12585q1;
import p618rm.C12590s0;
import p684un.C13225d;
import p684un.C13230i;
import p709vj.C13452e;
import p711vl.C13466f;
import p711vl.C13467g;
import p742wj.C13612b;
import p815ym.AbstractC14026a;

/* loaded from: classes2.dex */
public class CloudBackupAppDataUtil {
    public static final int CLASSIC_BACKUP = 1;
    private static final ArrayList<Integer> DEFAULT_MIMETYPE_LIST = new ArrayList<Integer>() { // from class: com.huawei.android.hicloud.cloudbackup.process.util.CloudBackupAppDataUtil.1
        public C26191() {
            add(2);
            add(4);
            add(1);
            add(3);
            add(5);
            add(6);
            add(7);
        }
    };
    public static final int REFURBISHMENT_BACKUP = 2;
    private static final String TAG = "CloudBackupAppDataUtil";
    public static final int TEMP_BACKUP = 3;
    private AppInfoList appFileInfoList;
    private long curVersionCode;
    private AppInfoList defaultFileInfoList;
    private String mAppId;
    private boolean mIsRefurbish;
    private boolean mIsTempBackup;
    private String mLocation;
    private boolean switch3rdApp;
    private boolean switch3rdDefault;
    private boolean isInit = false;
    private boolean isChangedSplitSetting = false;
    private List<String> appDataBackupBlackList = new ArrayList();
    private List<CloudBackupPathInfo> mCloudBackupInclude = new ArrayList();
    private List<CloudBackupPathInfo> mCloudBackupExclude = new ArrayList();
    private boolean isDefaultAppInfo = false;
    private Pattern fixedFilter = Pattern.compile("^/storage/emulated/\\d+/Android/data/.*\\.dbhashfile$");

    /* renamed from: com.huawei.android.hicloud.cloudbackup.process.util.CloudBackupAppDataUtil$1 */
    public class C26191 extends ArrayList<Integer> {
        public C26191() {
            add(2);
            add(4);
            add(1);
            add(3);
            add(5);
            add(6);
            add(7);
        }
    }

    public CloudBackupAppDataUtil(String str, String str2, long j10, boolean z10, boolean z11) throws C9721b {
        this.mIsRefurbish = false;
        this.mIsTempBackup = false;
        this.mAppId = str;
        this.mLocation = str2;
        this.curVersionCode = j10;
        this.mIsRefurbish = z10;
        this.mIsTempBackup = z11;
        if (str == null || str2 == null) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "query app OM info error, appId is null or location is null.");
        }
        C0221j.m1509s(C0213f.m1377a());
    }

    private void checkIncludeAndroidData(List<CloudBackupPathInfo> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (CloudBackupPathInfo cloudBackupPathInfo : list) {
            List<String> paths = cloudBackupPathInfo.getPaths();
            for (String str : paths) {
                if (str.startsWith(ICBUtil.getTheAndroidDataCachePath(this.mAppId) + "/")) {
                    arrayList.add(str);
                }
            }
            paths.removeAll(arrayList);
            if (paths.isEmpty()) {
                arrayList2.add(cloudBackupPathInfo);
            }
        }
        list.removeAll(arrayList2);
        this.mCloudBackupInclude.add(getDefaultAndroidSetting());
    }

    private void convertInfoPath(List<CloudBackupPathInfo> list) {
        if (list == null || list.isEmpty()) {
            C11839m.m70688i(TAG, "convertInfoPath pathInfoList is error.");
            return;
        }
        for (CloudBackupPathInfo cloudBackupPathInfo : list) {
            cloudBackupPathInfo.setPaths(C12585q1.m75694d(cloudBackupPathInfo.getPaths(), this.mAppId, this.mLocation));
        }
    }

    private void getCloudBackupPathInfo(AppInfoList appInfoList) {
        if (appInfoList == null) {
            C11839m.m70688i(TAG, "getCloudBackupPathInfo appFileInfo error, appId = " + this.mAppId);
            return;
        }
        CloudBackup cloudBackup = appInfoList.getCloudBackup();
        if (cloudBackup != null) {
            List<CloudBackupPathInfo> include = cloudBackup.getInclude();
            if (!include.isEmpty()) {
                this.mCloudBackupInclude.addAll(include);
            }
            checkIncludeAndroidData(this.mCloudBackupInclude);
            convertInfoPath(this.mCloudBackupInclude);
            List<CloudBackupPathInfo> exclude = cloudBackup.getExclude();
            if (exclude.isEmpty()) {
                return;
            }
            this.mCloudBackupExclude.addAll(exclude);
            convertInfoPath(this.mCloudBackupExclude);
        }
    }

    private Integer getCurrentBakCategory() {
        if (this.mIsRefurbish) {
            return 2;
        }
        return this.mIsTempBackup ? 3 : 1;
    }

    private CloudBackupPathInfo getDefaultAndroidSetting() {
        CloudBackupPathInfo cloudBackupPathInfo = new CloudBackupPathInfo();
        ArrayList arrayList = new ArrayList();
        arrayList.add(ICBUtil.getTheAndroidDataCachePath(this.mAppId) + "/");
        cloudBackupPathInfo.setPaths(arrayList);
        cloudBackupPathInfo.setFileSuffix(new ArrayList());
        cloudBackupPathInfo.setMimeTypes(DEFAULT_MIMETYPE_LIST);
        return cloudBackupPathInfo;
    }

    public static int getRefurbishVersion(boolean z10) {
        C11839m.m70688i(TAG, "get refurbish version start.");
        int iM81077e = C13466f.m81073d().m81077e("backup_read_om_config_state", -2);
        int i10 = 1;
        if (!z10 && (!C13612b.m81829B().isLogin() || iM81077e == -2)) {
            C11839m.m70688i(TAG, "get refurbish version return default.");
            return 1;
        }
        boolean zM60720O = C9733f.m60705z().m60720O("backupRefurbish");
        String str = "get refurbish version backupRefurbish = " + zM60720O;
        C11839m.m70688i(TAG, str);
        if (!zM60720O) {
            reportRefurbishVersion(0, str);
            return 0;
        }
        List<AppInfoList> listM75303n = new C12519c().m75303n();
        String str2 = "get refurbish version, refurbishInfoList size = " + listM75303n.size();
        C11839m.m70688i(TAG, str2);
        if (listM75303n.size() <= 0) {
            C12515a.m75110o().m75172d(new ReadOmConfigFileTask());
        }
        Iterator<AppInfoList> it = listM75303n.iterator();
        while (true) {
            if (!it.hasNext()) {
                i10 = 0;
                break;
            }
            AppInfoList next = it.next();
            if (next != null) {
                String osVersRegex = next.getCloudBackup().getOsVersRegex();
                int minClientVersion = next.getMinClientVersion();
                List<String> effectDevice = next.getCloudBackup().getEffectDevice();
                List<String> effectPackage = next.getCloudBackup().getEffectPackage();
                C11839m.m70688i(TAG, "get refurbish version, effectDevice = " + effectDevice + ", effectPackage = " + effectPackage);
                boolean zM75705o = C12585q1.m75705o(osVersRegex);
                boolean zM75700j = C12585q1.m75700j(minClientVersion);
                boolean zM75701k = C12585q1.m75701k(effectDevice);
                boolean zM75702l = C12585q1.m75702l(effectPackage);
                C11839m.m70688i(TAG, "get refurbish version, matchOsVerRegex = " + zM75705o + ", matchClientVersion = " + zM75700j + ", matchEffectDevice = " + zM75701k + ", matchUserGrade = " + zM75702l);
                if (zM75705o && zM75700j && zM75701k && zM75702l) {
                    break;
                }
            } else {
                C11839m.m70688i(TAG, "get refurbish version, refurbishInfo is null");
            }
        }
        if (i10 == 0) {
            reportRefurbishVersion(i10, str2);
        }
        C11839m.m70688i(TAG, "get refurbish version end, version: " + i10);
        return i10;
    }

    private void initAppFileInfo() {
        C11839m.m70688i(TAG, "initAppFileInfo");
        List<AppInfoList> listM75300k = new C12519c().m75300k(this.mAppId);
        ArrayList arrayList = new ArrayList();
        for (AppInfoList appInfoList : listM75300k) {
            if (appInfoList.getCloudBackup().getOsVersRegex() != null) {
                arrayList.add(appInfoList);
            }
        }
        if (arrayList.isEmpty()) {
            this.appFileInfoList = matchAppInfoByEmui(listM75300k);
        } else {
            this.appFileInfoList = matchAppInfoByOs(arrayList);
        }
    }

    private void initDefaultFileInfoList() {
        C11839m.m70688i(TAG, "initDefaultFileInfoList");
        C12519c c12519c = new C12519c();
        for (AppInfoList appInfoList : this.mIsRefurbish ? c12519c.m75303n() : this.mIsTempBackup ? c12519c.m75304o() : c12519c.m75302m()) {
            if (appInfoList != null) {
                String osVersRegex = appInfoList.getCloudBackup().getOsVersRegex();
                int minClientVersion = appInfoList.getMinClientVersion();
                List<String> effectDevice = appInfoList.getCloudBackup().getEffectDevice();
                List<String> effectPackage = appInfoList.getCloudBackup().getEffectPackage();
                if (C12585q1.m75705o(osVersRegex) && C12585q1.m75700j(minClientVersion) && C12585q1.m75701k(effectDevice) && C12585q1.m75702l(effectPackage)) {
                    this.defaultFileInfoList = appInfoList;
                    return;
                }
            }
        }
    }

    private boolean isBlackModule() {
        List<BlackModuleItem> listM69920e = new C11719a().m69920e(this.mAppId);
        if (listM69920e.size() <= 0) {
            C11839m.m70686d(TAG, "item list is empty: " + this.mAppId);
            return false;
        }
        int i10 = (this.mIsRefurbish || this.mIsTempBackup) ? 0 : 1;
        for (BlackModuleItem blackModuleItem : listM69920e) {
            if (blackModuleItem.getType() == i10 && blackModuleItem.getFlag() == 0) {
                C11839m.m70686d(TAG, "item is black module: " + this.mAppId);
                return true;
            }
        }
        C11839m.m70686d(TAG, "item is not black module: " + this.mAppId);
        return false;
    }

    private boolean isFilter(String str) {
        if (!C4633d0.m28404a(str) && this.fixedFilter.matcher(str).matches()) {
            C11839m.m70688i(TAG, "isFilter canonicalPath match.");
            return true;
        }
        if (isMatchPathInfo(str, this.mCloudBackupExclude, true)) {
            C11839m.m70688i(TAG, "file match mCloudBackupExclude.");
            return true;
        }
        if (this.mCloudBackupInclude.isEmpty()) {
            C11839m.m70688i(TAG, "mCloudBackupInclude is empty.");
            return false;
        }
        if (isMatchPathInfo(str, this.mCloudBackupInclude, false)) {
            return false;
        }
        C11839m.m70688i(TAG, "file does not match mCloudBackupInclude.");
        return true;
    }

    private boolean isMatchVersionCode(long j10, AppInfoList appInfoList) {
        List<AppVer> appVer = appInfoList.getCloudBackup().getAppVer();
        if (appVer.isEmpty()) {
            return true;
        }
        for (AppVer appVer2 : appVer) {
            if (appVer2 == null) {
                C11839m.m70689w(TAG, "appVer is null");
            } else if (C12585q1.m75699i(j10, appVer2.getMin(), appVer2.getMax(), appInfoList.getCloudBackup().getAppVersRegex())) {
                return true;
            }
        }
        return false;
    }

    private static boolean isWithinBackupTime(List<String> list) throws ParseException {
        if (list != null && list.size() >= 2) {
            String str = list.get(0);
            String str2 = list.get(1);
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
                try {
                    Date date = simpleDateFormat.parse(simpleDateFormat.format(new Date()));
                    Date date2 = simpleDateFormat.parse(str);
                    Date date3 = simpleDateFormat.parse(str2);
                    if (date != null && date2 != null && date3 != null) {
                        if (date2.after(date3)) {
                            if (date.after(date3)) {
                                if (!date.before(date2)) {
                                }
                            }
                            return true;
                        }
                        if (date2.before(date3)) {
                            if (date.after(date2) && date.before(date3)) {
                                return true;
                            }
                        } else if (date.equals(date2) || date.equals(date3)) {
                            return true;
                        }
                    }
                    return false;
                } catch (ParseException e10) {
                    C11839m.m70687e(TAG, "isWithinBackupTime error: " + e10.toString());
                }
            }
        }
        return false;
    }

    private AppInfoList matchAppInfoByEmui(List<AppInfoList> list) {
        C11839m.m70688i(TAG, "match appInfo by emui");
        for (AppInfoList appInfoList : list) {
            if (appInfoList != null) {
                List<String> emuiVersRegex = appInfoList.getCloudBackup().getEmuiVersRegex();
                int minClientVersion = appInfoList.getMinClientVersion();
                List<String> effectDevice = appInfoList.getCloudBackup().getEffectDevice();
                List<String> effectPackage = appInfoList.getCloudBackup().getEffectPackage();
                if (C12585q1.m75703m(emuiVersRegex) && isMatchVersionCode(this.curVersionCode, appInfoList) && C12585q1.m75700j(minClientVersion) && C12585q1.m75701k(effectDevice) && C12585q1.m75702l(effectPackage)) {
                    return appInfoList;
                }
            }
        }
        return null;
    }

    private AppInfoList matchAppInfoByOs(List<AppInfoList> list) {
        C11839m.m70688i(TAG, "match appInfo by osRegex");
        for (AppInfoList appInfoList : list) {
            if (appInfoList != null) {
                String osVersRegex = appInfoList.getCloudBackup().getOsVersRegex();
                int minClientVersion = appInfoList.getMinClientVersion();
                List<String> effectDevice = appInfoList.getCloudBackup().getEffectDevice();
                List<String> effectPackage = appInfoList.getCloudBackup().getEffectPackage();
                if (C12585q1.m75705o(osVersRegex) && isMatchVersionCode(this.curVersionCode, appInfoList) && C12585q1.m75700j(minClientVersion) && C12585q1.m75701k(effectDevice) && C12585q1.m75702l(effectPackage)) {
                    return appInfoList;
                }
            }
        }
        return null;
    }

    private boolean matchBackupBlackList(String str) {
        if (this.mIsRefurbish || this.mIsTempBackup) {
            return false;
        }
        return this.appDataBackupBlackList.contains(str);
    }

    private boolean matchBakCategory() {
        AppInfoList appInfoList = this.appFileInfoList;
        if (appInfoList == null) {
            C11839m.m70688i(TAG, "matchBakCategory appFileInfoList is null.");
            return true;
        }
        if (appInfoList.getCloudBackup() == null) {
            C11839m.m70689w(TAG, "matchBakCategory CloudBackup is null.");
            return true;
        }
        List<Integer> bakCategory = this.appFileInfoList.getCloudBackup().getBakCategory();
        if (AbstractC14026a.m84159a(bakCategory)) {
            C11839m.m70686d(TAG, "bakCategory is empty:" + this.mAppId);
            return true;
        }
        Integer currentBakCategory = getCurrentBakCategory();
        C11839m.m70686d(TAG, "bakCategory is:" + bakCategory + ",currentBakCategory:" + currentBakCategory + ",appId:" + this.mAppId);
        return bakCategory.contains(currentBakCategory);
    }

    private void refreshAppFileInfo() {
        if (this.appFileInfoList == null) {
            C12519c c12519c = new C12519c();
            boolean zEqualsIgnoreCase = "2".equalsIgnoreCase(new SettingOperator().queryUploadTargetStrategy());
            if (c12519c.m75292b(this.mAppId) && zEqualsIgnoreCase) {
                initDefaultFileInfoList();
                AppInfoList appInfoList = this.defaultFileInfoList;
                if (appInfoList != null) {
                    this.appFileInfoList = appInfoList;
                    this.isDefaultAppInfo = true;
                }
            }
        }
        AppInfoList appInfoList2 = this.appFileInfoList;
        if (appInfoList2 != null) {
            getCloudBackupPathInfo(appInfoList2);
        }
    }

    private static void reportRefurbishVersion(int i10, String str) {
        try {
            LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
            linkedHashMapM79497A.put("deviceId", C13452e.m80781L().m80954p());
            linkedHashMapM79497A.put("refurbishVersion", String.valueOf(i10));
            linkedHashMapM79497A.put("errReason", str);
            C13225d.m79490f1().m79567R("get_refurbish_version_result", linkedHashMapM79497A);
            UBAAnalyze.m29947H("CKC", "get_refurbish_version_result", linkedHashMapM79497A);
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "reportRefurbishVersion exception: " + e10.getMessage());
        }
    }

    public void changeToSeparaSetting(int i10) {
        if (this.isChangedSplitSetting) {
            return;
        }
        init();
        String strM75533b = C12568l.m75533b(i10);
        for (CloudBackupPathInfo cloudBackupPathInfo : this.mCloudBackupExclude) {
            List<String> paths = cloudBackupPathInfo.getPaths();
            ArrayList arrayList = new ArrayList();
            Iterator<String> it = paths.iterator();
            while (it.hasNext()) {
                arrayList.add(C12583q.m75655I(it.next(), strM75533b));
            }
            cloudBackupPathInfo.setPaths(arrayList);
        }
        for (CloudBackupPathInfo cloudBackupPathInfo2 : this.mCloudBackupInclude) {
            List<String> paths2 = cloudBackupPathInfo2.getPaths();
            ArrayList arrayList2 = new ArrayList();
            Iterator<String> it2 = paths2.iterator();
            while (it2.hasNext()) {
                arrayList2.add(C12583q.m75655I(it2.next(), strM75533b));
            }
            cloudBackupPathInfo2.setPaths(arrayList2);
        }
        this.isChangedSplitSetting = true;
    }

    public boolean filterPath(Path path) {
        return Files.isRegularFile(path, new LinkOption[0]) && !isFilterFile(path.toFile());
    }

    public AppInfoList getAppFileInfoList() {
        init();
        return this.appFileInfoList;
    }

    public boolean getDefaultSwitch(String str, boolean z10, String str2) {
        return getDefaultSwitch(str, z10, true, str2);
    }

    public List<CloudBackupPathInfo> getmCloudBackupExclude() {
        init();
        return this.mCloudBackupExclude;
    }

    public List<CloudBackupPathInfo> getmCloudBackupInclude() {
        init();
        return this.mCloudBackupInclude;
    }

    public void init() {
        if (this.isInit) {
            return;
        }
        C11839m.m70688i(TAG, "begin init appDataUtil appId = " + this.mAppId);
        C12526j c12526j = new C12526j();
        this.switch3rdApp = c12526j.m75353O0();
        this.switch3rdDefault = c12526j.m75369W0();
        this.appDataBackupBlackList = c12526j.m75396i();
        if (this.switch3rdApp && !matchBackupBlackList(this.mAppId) && !isBlackModule()) {
            initAppFileInfo();
            if (matchBakCategory()) {
                refreshAppFileInfo();
            } else {
                C11839m.m70688i(TAG, "not match bakCategory:" + this.mAppId);
                this.appFileInfoList = null;
            }
        }
        this.isInit = true;
        C11839m.m70688i(TAG, "end init appDataUtil");
    }

    public boolean isAppDataAble() {
        init();
        if (!this.switch3rdApp) {
            C11839m.m70688i(TAG, "appDataAble switch is false");
            return false;
        }
        boolean z10 = this.appFileInfoList != null;
        C11839m.m70688i(TAG, "appId: " + this.mAppId + ", isAppDataAble: " + z10);
        return z10;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean isBackupForegroundApp() {
        /*
            r4 = this;
            r4.init()
            com.huawei.android.hicloud.cloudbackup.bean.AppInfoList r4 = r4.appFileInfoList
            java.lang.String r0 = "CloudBackupAppDataUtil"
            if (r4 == 0) goto L42
            com.huawei.android.hicloud.cloudbackup.bean.CloudBackup r4 = r4.getCloudBackup()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "isBackupForegroundApp: cloudBackup="
            r1.append(r2)
            java.lang.String r2 = r4.toString()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            p514o9.C11839m.m70686d(r0, r1)
            int r1 = r4.getForegroundBackup()
            r2 = 1
            if (r1 != r2) goto L35
            java.util.List r4 = r4.getForegroundBackupTime()
            boolean r4 = isWithinBackupTime(r4)
            goto L43
        L35:
            r3 = 2
            if (r1 != r3) goto L42
            java.lang.String r4 = r4.getWakeUpService()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            r4 = r4 ^ r2
            goto L43
        L42:
            r4 = 0
        L43:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "isBackupForegroundApp: "
            r1.append(r2)
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            p514o9.C11839m.m70688i(r0, r1)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.cloudbackup.process.util.CloudBackupAppDataUtil.isBackupForegroundApp():boolean");
    }

    public boolean isDirectlyBackupForegroundApp() {
        init();
        AppInfoList appInfoList = this.appFileInfoList;
        return appInfoList != null && appInfoList.getCloudBackup().getForegroundBackup() == 1;
    }

    public boolean isFilterFile(File file) {
        return isFilterFile(C10279b.m63452a(file));
    }

    public boolean isKillBackgroundApp() {
        init();
        AppInfoList appInfoList = this.appFileInfoList;
        if (appInfoList == null) {
            return true;
        }
        int backgroundBackup = appInfoList.getCloudBackup().getBackgroundBackup();
        C11839m.m70686d(TAG, "isKillBackgroundApp: backgroundBackup=" + backgroundBackup);
        return backgroundBackup != 1;
    }

    public boolean isKillForegroundApp() {
        init();
        AppInfoList appInfoList = this.appFileInfoList;
        return appInfoList != null && appInfoList.getCloudBackup().getForegroundBackup() == 2;
    }

    public boolean isMatchPathInfo(String str, List<CloudBackupPathInfo> list, boolean z10) {
        init();
        if (str == null) {
            C11839m.m70688i(TAG, "file canonical path is null");
            return true;
        }
        boolean zM75707q = false;
        for (CloudBackupPathInfo cloudBackupPathInfo : list) {
            List<String> paths = cloudBackupPathInfo.getPaths();
            List<Integer> mimeTypes = cloudBackupPathInfo.getMimeTypes();
            zM75707q = (str.startsWith(BackupRestoreConstans.DATA_PATH) || mimeTypes.isEmpty()) ? C12585q1.m75707q(str, paths, z10) : paths.isEmpty() ? C12585q1.m75704n(str, mimeTypes) : C12585q1.m75707q(str, paths, z10) && C12585q1.m75704n(str, mimeTypes);
            if (zM75707q) {
                break;
            }
        }
        return zM75707q;
    }

    public boolean isSupportTwinAppBackup() {
        AppInfoList appInfoList;
        if (!C12585q1.m75708r()) {
            return false;
        }
        init();
        return (this.isDefaultAppInfo || (appInfoList = this.appFileInfoList) == null || appInfoList.getCloudBackup().isSupportTwinApp() != 1) ? false : true;
    }

    public boolean needFilterData() {
        init();
        Iterator<CloudBackupPathInfo> it = this.mCloudBackupExclude.iterator();
        while (it.hasNext()) {
            Iterator<String> it2 = it.next().getPaths().iterator();
            while (it2.hasNext()) {
                if (C12585q1.m75697g(it2.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean getDefaultSwitch(String str, boolean z10, boolean z11, String str2) {
        if (z10) {
            return false;
        }
        C12526j c12526j = new C12526j();
        if (!c12526j.m75390f1(1) || (z11 && !CloudBackupUserPackageHelper.getInstance(str2).isQueryUserPackageSuccess())) {
            if (this.isDefaultAppInfo) {
                return false;
            }
            return this.switch3rdDefault && !(C13467g.m81086c().m81089d("isFirstQueryTrans", -1) == 0);
        }
        if (C12590s0.m75823Z0()) {
            C11839m.m70688i(TAG, "5g cloud package user");
            return false;
        }
        if (!C12590s0.m75795S0()) {
            C11839m.m70688i(TAG, "large cloud package user");
            return true;
        }
        C11839m.m70688i(TAG, "50g cloud package user");
        c12526j.m75417s();
        return c12526j.m75382c1(str, 1);
    }

    public boolean isFilterFile(String str) {
        init();
        if (str == null) {
            C11839m.m70689w(TAG, "filter canonicalPath is empty");
            return true;
        }
        if (str.startsWith(this.mLocation)) {
            return false;
        }
        return isFilter(str);
    }
}
