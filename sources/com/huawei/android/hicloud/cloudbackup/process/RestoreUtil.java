package com.huawei.android.hicloud.cloudbackup.process;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.BatteryManager;
import android.os.Bundle;
import android.os.SystemClock;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.huawei.android.hicloud.cloudbackup.bean.RestoreRetry;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.jobscheduler.CloudBackupJobManager;
import com.huawei.android.hicloud.cloudbackup.p076db.bean.Settings;
import com.huawei.android.hicloud.cloudbackup.p076db.operator.SettingOperator;
import com.huawei.android.hicloud.cloudbackup.process.util.SplitAppSettingSingleInstance;
import com.huawei.android.hicloud.cloudbackup.progress.RestoreProgress;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackup3rdIconUtil;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.android.hicloud.p088ui.notification.BackupNotification;
import com.huawei.android.hicloud.p088ui.notification.RestoreNotification;
import com.huawei.android.p073ds.R$string;
import com.huawei.cloud.base.util.C4644l;
import com.huawei.fastengine.fastview.NavigationUtils;
import com.huawei.hicloud.base.bean.Md5AndHash;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.bean.FirstTimeOverview;
import com.huawei.hicloud.cloudbackup.model.C4869c;
import com.huawei.hicloud.cloudbackup.model.C4870d;
import com.huawei.hicloud.cloudbackup.model.CloudRecoveryItem;
import com.huawei.hicloud.cloudbackup.model.CloudRestoreItem;
import com.huawei.hicloud.cloudbackup.model.RestoreStatus;
import com.huawei.hicloud.cloudbackup.p104v3.core.C4880b;
import com.huawei.hicloud.cloudbackup.p104v3.core.module.nextrestore.nextmodule.NextRestoreConstants;
import com.huawei.hicloud.cloudbackup.p104v3.omconfig.model.SyncSwitchRestoreResult;
import com.huawei.hicloud.cloudbackup.p104v3.omconfig.model.SyncSwitchStatus;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Device;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudRestoreStatusV3;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.request.cbs.bean.CBSBackupRecord;
import com.huawei.hicloud.request.notify.constant.NotifyErr;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.secure.android.common.intent.SafeIntent;
import fk.C9721b;
import gp.C10028c;
import hk.C10278a;
import hk.C10279b;
import hu.C10343b;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import mk.C11476b;
import ni.C11707b;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0214f0;
import p015ak.C0221j;
import p015ak.C0240y;
import p015ak.C0241z;
import p020ap.C1009d;
import p229di.C9151p;
import p229di.C9152q;
import p292fn.C9733f;
import p316gk.C9951a;
import p371ik.C10527a;
import p429kk.C11058a;
import p458lo.C11322a;
import p459lp.C11326d;
import p514o9.C11835i;
import p514o9.C11839m;
import p523oi.C11903a;
import p617rl.C12526j;
import p618rm.C12568l;
import p618rm.C12571m;
import p618rm.C12583q;
import p618rm.C12590s0;
import p618rm.C12597u1;
import p684un.C13225d;
import p709vj.C13452e;
import p711vl.C13462b;
import p711vl.C13466f;
import p766x8.C13731j;
import p783xp.C13843a;
import p814yl.C13998b0;
import p815ym.AbstractC14026a;
import p848zl.C14333b;
import p848zl.C14340i;
import sl.C12816g;
import tl.C13029h;
import tl.C13030i;
import tl.C13032k;
import tl.C13033l;
import tl.C13035n;

/* loaded from: classes2.dex */
public class RestoreUtil {
    private static final long MAX_QUERY_APPTWIN_CREATE_PATH_TIME = 20000;
    private static final Object PREPARE_CLONEUID_LOCK = new Object();
    private static final List<Integer> RESTORE_AUTO_RETRY_ERROR_CODE = new ArrayList<Integer>() { // from class: com.huawei.android.hicloud.cloudbackup.process.RestoreUtil.1
        public C25061() {
            add(1002);
            add(1104);
            add(1105);
            add(1106);
            add(Integer.valueOf(NotifyErr.NET_DISABLE_HMS_ERROR));
            add(3900);
            add(1004);
        }
    };
    private static final String TAG = "RestoreUtil";
    public static final long WIFI_CONNECT_AUTO_RESTORE_DURATION = 10000;

    /* renamed from: com.huawei.android.hicloud.cloudbackup.process.RestoreUtil$1 */
    public class C25061 extends ArrayList<Integer> {
        public C25061() {
            add(1002);
            add(1104);
            add(1105);
            add(1106);
            add(Integer.valueOf(NotifyErr.NET_DISABLE_HMS_ERROR));
            add(3900);
            add(1004);
        }
    }

    public static final class ScannerClient implements MediaScannerConnection.MediaScannerConnectionClient {
        ArrayList<String> mPathList = new ArrayList<>();
        MediaScannerConnection mScannerConnection;

        public ScannerClient(Context context) {
            this.mScannerConnection = new MediaScannerConnection(context, this);
        }

        @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
        public void onMediaScannerConnected() {
            if (this.mPathList.isEmpty()) {
                return;
            }
            Iterator<String> it = this.mPathList.iterator();
            while (it.hasNext()) {
                this.mScannerConnection.scanFile(it.next(), null);
            }
            this.mPathList.clear();
        }

        @Override // android.media.MediaScannerConnection.OnScanCompletedListener
        public void onScanCompleted(String str, Uri uri) {
        }

        public void scanPath(String str) {
            this.mPathList.add(str);
            this.mScannerConnection.connect();
        }

        public void scanPathList(List<String> list) {
            if (list == null || list.isEmpty()) {
                return;
            }
            this.mPathList.addAll(list);
            this.mScannerConnection.connect();
        }
    }

    public static boolean checkAutoRestoreCondition(RestoreRetry restoreRetry, Context context) {
        try {
            int intExtra = new SafeIntent(context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"))).getIntExtra(FaqConstants.FAQ_LEVEL, 0);
            int restartBattery = restoreRetry.getRestartBattery();
            if (intExtra < restartBattery) {
                C11839m.m70688i(TAG, "battery level lower than " + restartBattery + "%");
                return false;
            }
        } catch (RuntimeException unused) {
            C11839m.m70688i(TAG, "intent Serializable error.");
        }
        if (!C0209d.m1254f2(context)) {
            C11839m.m70688i(TAG, "wifi is not active.");
            return false;
        }
        if (C1009d.m6109e().m6115g() != 0) {
            C11839m.m70688i(TAG, "restore clear not finish.");
            return false;
        }
        if (!CBAccess.inBackup() && !CBAccess.inRestoreTask()) {
            return true;
        }
        C11839m.m70688i(TAG, "already in cloud backup process.");
        return false;
    }

    public static boolean checkIsRegisterAutoRestore(C13029h c13029h, RestoreRetry restoreRetry) {
        if (c13029h == null) {
            C11839m.m70688i(TAG, "checkIsRegisterAutoRestore backupTags is null");
            return false;
        }
        if (CBAccess.isShowRestorePause()) {
            C11839m.m70688i(TAG, "checkIsRegisterAutoRestore isShowRestorePause");
            return false;
        }
        String strM78474q = c13029h.m78474q();
        C11839m.m70688i(TAG, "checkIsRegisterAutoRestore code: " + strM78474q);
        if (strM78474q.contains(String.valueOf(1007))) {
            return false;
        }
        if (!isAutoRestoreRetryCode(strM78474q)) {
            C11839m.m70688i(TAG, "checkIsRegisterAutoRestore no need auto restore.");
            return false;
        }
        boolean zIsRestoreRetryTimeExpires = ICBUtil.isRestoreRetryTimeExpires(c13029h.m78440F());
        C11839m.m70688i(TAG, "checkIsRegisterAutoRestore isRestoreRetryTimeExpires: " + zIsRestoreRetryTimeExpires);
        return !zIsRestoreRetryTimeExpires;
    }

    public static String getBakCategory(boolean z10, boolean z11) {
        return z11 ? "3" : z10 ? "2" : "1";
    }

    public static boolean getBatteryChargeStatus(Context context) {
        int intExtra = new SafeIntent(context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"))).getIntExtra("status", -1);
        return intExtra == 2 || intExtra == 5;
    }

    public static int getBatteryIntProperty(Context context) {
        BatteryManager batteryManager = (BatteryManager) context.getSystemService("batterymanager");
        if (batteryManager == null) {
            return -1;
        }
        return batteryManager.getIntProperty(4);
    }

    private static String getClonePathByUserId(StorageManager storageManager, int i10) {
        StorageVolume[] storageVolumeArrM57491a = C9151p.m57491a(storageManager, i10);
        if (storageVolumeArrM57491a != null && storageVolumeArrM57491a.length != 0) {
            return C9152q.m57492a(storageVolumeArrM57491a[0]);
        }
        C11839m.m70687e(TAG, "getVolumeListByUserId null");
        return null;
    }

    public static int getFailCount(int i10, List<CloudRestoreItem> list) {
        if (list != null && !list.isEmpty()) {
            for (CloudRestoreItem cloudRestoreItem : list) {
                List<CloudRestoreItem> listM29202r = cloudRestoreItem.m29202r();
                if (listM29202r == null || listM29202r.isEmpty()) {
                    if (isOneModuleFailed(cloudRestoreItem)) {
                        i10++;
                    }
                } else if (cloudRestoreItem.isShowChildList() && "sysdata".equals(cloudRestoreItem.getAppId())) {
                    i10 = getFailCount(i10, listM29202r);
                } else if (cloudRestoreItem.isShowChildList() && "thirdApp".equals(cloudRestoreItem.getAppId())) {
                    if (getFailCount(0, listM29202r) > 0) {
                        i10++;
                    }
                } else if (cloudRestoreItem.isShowChildList()) {
                    i10 = getFailCount(i10, listM29202r);
                } else if (isOneModuleFailed(cloudRestoreItem)) {
                    i10++;
                }
            }
        }
        return i10;
    }

    public static List<CloudRestoreItem> getItemList() {
        ArrayList arrayList = new ArrayList();
        if (isV3()) {
            C11839m.m70686d(TAG, "initRestoreItemsV3");
            arrayList.addAll(RestoreProgress.buildV3RecoveryItem(new C12816g().m76946j(), isNewBmRecord()));
        } else {
            C11839m.m70686d(TAG, "initRestoreItems");
            arrayList.addAll(RestoreProgress.buildRestoreItems(new ArrayList(new C13035n().m78553e()), isNewBmRecord()));
        }
        return arrayList;
    }

    private static long getNewBmItemSize(CloudRestoreItem cloudRestoreItem, boolean z10, int i10) {
        return TextUtils.equals(cloudRestoreItem.getAppId(), "bmBaseData") ? getSizeFromListData(cloudRestoreItem.m29202r(), z10) : (i10 == 2 && cloudRestoreItem.m29187M()) ? cloudRestoreItem.getSize() : cloudRestoreItem.getSize() + cloudRestoreItem.getAsize();
    }

    private static long getOldBmItemSize(CloudRestoreItem cloudRestoreItem) {
        return (!cloudRestoreItem.m29187M() || cloudRestoreItem.isHarmonyNext()) ? cloudRestoreItem.getSize() + cloudRestoreItem.getAsize() : cloudRestoreItem.getSize();
    }

    public static String getPauseBattery() {
        return new C12526j().m75325A0().getPauseBattery() + "%";
    }

    public static int getPauseCount(int i10, List<CloudRestoreItem> list) {
        if (list != null && !list.isEmpty()) {
            for (CloudRestoreItem cloudRestoreItem : list) {
                List<CloudRestoreItem> listM29202r = cloudRestoreItem.m29202r();
                if (listM29202r == null || listM29202r.isEmpty()) {
                    if (isOneModulePause(cloudRestoreItem)) {
                        i10++;
                    }
                } else if (cloudRestoreItem.isShowChildList()) {
                    i10 = getPauseCount(i10, listM29202r);
                } else if (isOneModulePause(cloudRestoreItem)) {
                    i10++;
                }
            }
        }
        return i10;
    }

    public static List<Integer> getRestoreAutoRetryErrorCodes() {
        return RESTORE_AUTO_RETRY_ERROR_CODE;
    }

    public static int getRestoreBattery() {
        return new C12526j().m75325A0().getRestartBattery();
    }

    public static long getRestoreDelayTime() {
        return 10000L;
    }

    public static Integer getRestoreErrCode() {
        C13029h c13029hM78495f;
        C13032k c13032kM78546d = new C13033l().m78546d(2);
        if (c13032kM78546d != null) {
            return Integer.valueOf(c13032kM78546d.m78530n());
        }
        try {
            c13029hM78495f = new C13030i().m78495f(3);
        } catch (C9721b unused) {
            C11839m.m70689w(TAG, "getRestoreErrCode queryTag is null");
            c13029hM78495f = null;
        }
        if (c13029hM78495f != null) {
            return Integer.valueOf(C0241z.m1685c(c13029hM78495f.m78474q().replace("001_", "")));
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:188:0x00e0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:190:0x00ff A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String getRestoreItemBase64Icon(com.huawei.hicloud.cloudbackup.model.CloudRestoreItem r8, boolean r9) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 284
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.cloudbackup.process.RestoreUtil.getRestoreItemBase64Icon(com.huawei.hicloud.cloudbackup.model.CloudRestoreItem, boolean):java.lang.String");
    }

    public static Drawable getRestoreItemDrawable(CloudRestoreItem cloudRestoreItem, String str) {
        if (cloudRestoreItem == null || str == null) {
            return null;
        }
        return (!cloudRestoreItem.isVirtual() || "virtual.hmos.sync.switch.status".equals(str)) ? C14333b.m85483r().containsKey(str) ? CloudBackup3rdIconUtil.getDrawable(str) : CloudBackup3rdIconUtil.get3rdDrawable(str) : CloudBackup3rdIconUtil.getDrawable(str, null);
    }

    public static String getRestoreItemName(CloudRestoreItem cloudRestoreItem) {
        if (cloudRestoreItem == null) {
            return "";
        }
        String appName = cloudRestoreItem.getAppName();
        Context contextM1377a = C0213f.m1377a();
        return contextM1377a == null ? appName : cloudRestoreItem.getAppId().equals(NextRestoreConstants.BUNDLE_NAME_GALLERY) ? contextM1377a.getString(R$string.gallery_item_title) : cloudRestoreItem.getAppId().equals("com.ohos.telephonydataability") ? contextM1377a.getString(R$string.cloudbackup_back_item_sms) : cloudRestoreItem.getAppId().equals("com.huawei.hmos.calendardata") ? contextM1377a.getString(R$string.calendar_sync_item) : cloudRestoreItem.getAppId().equals("com.huawei.hmos.callrecorder") ? contextM1377a.getString(R$string.cloudbackup_back_item_record) : cloudRestoreItem.getAppId().equals("com.huawei.hmos.meetimeservice") ? contextM1377a.getString(R$string.cloudbackup_back_item_meetime) : appName;
    }

    public static boolean getRestoreStatus(Context context) {
        return C0214f0.m1382b(context, NotifyConstants.InterfaceC4909SP.USERINFO_SPFILE, 0).getBoolean("restoreStatus", true);
    }

    public static long getSizeFromAppData(List<CloudRestoreItem> list, boolean z10, int i10) {
        long newBmItemSize = 0;
        if (list == null) {
            C11839m.m70689w(TAG, "getSizeFromListData listData null");
            return 0L;
        }
        for (CloudRestoreItem cloudRestoreItem : list) {
            if (cloudRestoreItem != null && cloudRestoreItem.getAction() != 2) {
                newBmItemSize += z10 ? getNewBmItemSize(cloudRestoreItem, z10, i10) : getOldBmItemSize(cloudRestoreItem);
            }
        }
        return newBmItemSize;
    }

    public static long getSizeFromListData(List<CloudRestoreItem> list, boolean z10) {
        long oldBmItemSize;
        long size = 0;
        if (list == null) {
            C11839m.m70689w(TAG, "getSizeFromListData listData null");
            return 0L;
        }
        for (CloudRestoreItem cloudRestoreItem : list) {
            if (cloudRestoreItem != null && cloudRestoreItem.getAction() != 2) {
                if (!z10) {
                    oldBmItemSize = getOldBmItemSize(cloudRestoreItem);
                } else if (TextUtils.equals(cloudRestoreItem.getAppId(), "bmBaseData")) {
                    oldBmItemSize = getSizeFromListData(cloudRestoreItem.m29202r(), z10);
                } else {
                    size += cloudRestoreItem.getSize() + cloudRestoreItem.getAsize();
                }
                size += oldBmItemSize;
            }
        }
        return size;
    }

    private static int getSortPriority(CloudRestoreItem cloudRestoreItem) {
        if (cloudRestoreItem != null) {
            return (TextUtils.equals("bmBaseData", cloudRestoreItem.getAppId()) || TextUtils.equals("sysdata", cloudRestoreItem.getAppId())) ? 1 : 0;
        }
        return 0;
    }

    public static FirstTimeOverview getSubscribeNotifyOm(String str, String str2) {
        if (!C9733f.m60705z().m60720O(str)) {
            C11839m.m70689w(TAG, str + " is closed");
            return null;
        }
        FirstTimeOverview firstTimeOverviewM68043e = C11326d.m68043e(str2);
        if (firstTimeOverviewM68043e == null) {
            C11839m.m70689w(TAG, "firstTimeOverview is null");
            return null;
        }
        ArrayList<String> reachChannels = firstTimeOverviewM68043e.getReachChannels();
        if (reachChannels == null || !reachChannels.contains("notificationBar")) {
            C11839m.m70689w(TAG, "channels not support");
            return null;
        }
        String trigger = firstTimeOverviewM68043e.getTrigger();
        if (!TextUtils.isEmpty(trigger)) {
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
            ArrayList arrayList = new ArrayList();
            if (!C1009d.m6109e().m6119k(arrayList, arrayList, trigger, 1, linkedHashMap)) {
                C11839m.m70689w(TAG, "trigger not support," + trigger);
                if (TextUtils.equals("firstBackup", str2)) {
                    C13462b.m81015c().m81020f("hasSentBackupNotify", true);
                }
                return null;
            }
        }
        return firstTimeOverviewM68043e;
    }

    public static int getSucceedCount(int i10, List<CloudRestoreItem> list) {
        if (list != null && !list.isEmpty()) {
            for (CloudRestoreItem cloudRestoreItem : list) {
                List<CloudRestoreItem> listM29202r = cloudRestoreItem.m29202r();
                if (listM29202r == null || listM29202r.isEmpty()) {
                    if (isOneModuleSucceed(cloudRestoreItem)) {
                        i10++;
                    }
                } else if (cloudRestoreItem.isShowChildList()) {
                    i10 = getSucceedCount(i10, listM29202r);
                } else if (isOneModuleSucceed(cloudRestoreItem)) {
                    i10++;
                }
            }
        }
        return i10;
    }

    private static long getV2LastSuccessTime() throws C9721b {
        try {
            String strM80950o = C13452e.m80781L().m80950o();
            long endTime = 0;
            if (!TextUtils.isEmpty(strM80950o)) {
                for (CBSBackupRecord cBSBackupRecord : new C11322a().m67997D(false, false)) {
                    if (cBSBackupRecord.getStatus() == 0) {
                        if (cBSBackupRecord.isRefurbishment()) {
                            C11839m.m70688i(TAG, "record is refurbishment record.");
                        } else if (TextUtils.equals(String.valueOf(cBSBackupRecord.getBakCategory()), "3")) {
                            C11839m.m70688i(TAG, "record is temp backup.");
                        } else if (strM80950o.equals(cBSBackupRecord.getDevice().getDeviceId()) && endTime < cBSBackupRecord.getEndTime()) {
                            endTime = cBSBackupRecord.getEndTime();
                        }
                    }
                }
            }
            return endTime;
        } catch (C9721b e10) {
            throw new C9721b(3107, "query v3 last record failed IOException: " + e10.getMessage());
        }
    }

    public static <T extends RestoreStatus> boolean isAllModulesRestoreFailed(List<T> list) {
        if (list.isEmpty()) {
            return true;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().isSuccess()) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAppMarketSupportedReport(Context context) {
        return context != null && C0241z.m1685c(C0240y.m1680b(context, C13843a.m83090l())) >= 110301004;
    }

    private static boolean isAutoRestoreRetryCode(String str) {
        if (TextUtils.isEmpty(str)) {
            C11839m.m70688i(TAG, "isAutoRestoreRetryCode the code is empty.");
            return false;
        }
        Iterator<Integer> it = getRestoreAutoRetryErrorCodes().iterator();
        while (it.hasNext()) {
            if (str.contains(String.valueOf(it.next().intValue()))) {
                return true;
            }
        }
        return false;
    }

    public static boolean isHiCreatePromptNotSupportRestore(RestoreStatus restoreStatus) {
        if (restoreStatus != null) {
            return "HiCreate".equals(restoreStatus.getAppId()) && !C0209d.m1170F1();
        }
        C11839m.m70689w(TAG, "isHiCreateNotSupportRestore restoreStatus null.");
        return false;
    }

    public static boolean isHiCreateSupportClone() {
        try {
            Bundle bundleM63684f = new C10343b(CloneService.getInstance().getBackupModuleInfo("HiCreate", false)).m63684f("HiCreate");
            if (bundleM63684f != null && bundleM63684f.getBoolean("isSupportClone")) {
                C11839m.m70688i(TAG, "isHiCreateSupportClone support clone.");
                return true;
            }
        } catch (Exception e10) {
            C11839m.m70689w(TAG, "isHiCreateSupportClone：getBackupModuleInfo exception: " + e10.getMessage());
        }
        C11839m.m70688i(TAG, "isHiCreateSupportClone not support clone.");
        return false;
    }

    public static boolean isIgnoreRetryErr(C9721b c9721b) {
        if (c9721b == null) {
            C11839m.m70689w(TAG, "isServerError exception == null");
            return false;
        }
        int iM60659c = c9721b.m60659c();
        int iM60663g = c9721b.m60663g();
        if ((iM60659c != 3911 || iM60663g != 404) && !String.valueOf(iM60663g).endsWith(String.valueOf(4041)) && iM60659c != 404) {
            return C14340i.m85519a().contains(Integer.valueOf(iM60659c)) || iM60659c > 3000;
        }
        C11839m.m70688i(TAG, "isIgnoreRetryErr false: " + iM60659c + " status: " + iM60663g);
        return false;
    }

    public static boolean isModuleSuccess(RestoreStatus restoreStatus) {
        return restoreStatus != null && restoreStatus.getStatus() == 8 && restoreStatus.getType() == 1;
    }

    public static boolean isNewBmRecord() {
        C13029h c13029hM78495f;
        boolean zM81075b = C13466f.m81073d().m81075b("restore_is_new_bm_record", false);
        if (!zM81075b) {
            try {
                c13029hM78495f = new C13030i().m78495f(3);
            } catch (C9721b e10) {
                C11839m.m70687e(TAG, "tags is null " + e10.getMessage());
                c13029hM78495f = null;
            }
            zM81075b = c13029hM78495f != null ? "1".equals(c13029hM78495f.m78486w()) : false;
        }
        C11839m.m70686d(TAG, "The result of the query new business models is:" + zM81075b);
        return zM81075b;
    }

    public static boolean isNewBmRecordByRecordLabel(int i10) {
        return i10 == 1 || i10 == 2;
    }

    private static boolean isOneModuleFailed(RestoreStatus restoreStatus) {
        return !(restoreStatus.getStatus() == 8 && restoreStatus.getType() == 1);
    }

    private static boolean isOneModulePause(RestoreStatus restoreStatus) {
        return restoreStatus.getStatus() == 2;
    }

    private static boolean isOneModuleSucceed(RestoreStatus restoreStatus) {
        return restoreStatus.getStatus() == 8 && restoreStatus.getType() == 1;
    }

    public static boolean isOnlySourceNotExistFailed(List<CloudRestoreStatusV3> list) {
        boolean z10 = false;
        if (list.isEmpty()) {
            C11839m.m70688i(TAG, "isOnlySourceNotExistFailed: the statusList is empty.");
            return false;
        }
        Iterator<CloudRestoreStatusV3> it = list.iterator();
        boolean z11 = false;
        while (true) {
            if (!it.hasNext()) {
                z10 = z11;
                break;
            }
            CloudRestoreStatusV3 next = it.next();
            if (next.getType() == 2) {
                if (!String.valueOf(4041).equals(next.m29474O())) {
                    break;
                }
                z11 = true;
            }
        }
        C11839m.m70688i(TAG, "isOnlySourceNotExistFailed: " + z10);
        return z10;
    }

    public static boolean isRestoreNeedAutoRetry(int i10) {
        C11839m.m70688i(TAG, "isRestoreNeedAutoRetry errorCode is: " + i10);
        return getRestoreAutoRetryErrorCodes().contains(Integer.valueOf(i10));
    }

    public static boolean isRestoring() {
        int iM80916g0 = C13452e.m80781L().m80916g0();
        return iM80916g0 == 0 || iM80916g0 == 1;
    }

    public static boolean isSameFile(File file, String str, String str2) {
        Md5AndHash md5AndHashM68622d;
        try {
            md5AndHashM68622d = C11476b.m68622d(file);
        } catch (C9721b e10) {
            C11839m.m70688i(TAG, "isSameFile error: " + e10.toString());
        }
        if (TextUtils.isEmpty(md5AndHashM68622d.getHash())) {
            return false;
        }
        if (md5AndHashM68622d.getHash().equals(str)) {
            return true;
        }
        return md5AndHashM68622d.getHash().equals(str2);
    }

    public static boolean isShowRestoreFailedDialog(C9721b c9721b) {
        if (c9721b == null) {
            return false;
        }
        int iM60659c = c9721b.m60659c();
        if (iM60659c == 1004 || iM60659c == 1007 || iM60659c == 1102 || iM60659c == 3107 || iM60659c == 3109 || iM60659c == 3307) {
            return true;
        }
        switch (iM60659c) {
            case 3103:
            case 3104:
            case 3105:
                break;
            default:
                switch (iM60659c) {
                    case 3203:
                    case 3204:
                    case 3205:
                        break;
                    default:
                        switch (iM60659c) {
                        }
                }
        }
        return false;
    }

    public static boolean isSms(String str) {
        return NavigationUtils.SMS_SCHEMA_PREF.equals(str) || "chatSms".equals(str);
    }

    public static boolean isSounderNotNeedCloneRestore(String str) {
        return "soundrecorder".equals(str) && !C14333b.m85491z().contains(str);
    }

    public static boolean isSounds(String str) {
        return "soundrecorder".equals(str) || "callRecorder".equals(str);
    }

    public static boolean isSupportSplitRestore(CloudRecoveryItem cloudRecoveryItem, String str) {
        return SplitAppSettingSingleInstance.getInstance().isSupportSplitRestore(str, (cloudRecoveryItem == null || !cloudRecoveryItem.isTempBackup()) ? (cloudRecoveryItem == null || !cloudRecoveryItem.isRefurbishment()) ? "1" : "2" : "3");
    }

    public static boolean isV3() {
        C13029h c13029hM78495f;
        try {
            c13029hM78495f = new C13030i().m78495f(3);
        } catch (C9721b e10) {
            C11839m.m70689w(TAG, "restore3rdPause tags is null, exception: " + e10.getMessage());
            c13029hM78495f = null;
        }
        if (c13029hM78495f == null) {
            C11839m.m70688i(TAG, "restore3rdPause tags is null");
            return false;
        }
        if (TextUtils.isEmpty(C12590s0.m75924y0(c13029hM78495f))) {
            C11839m.m70688i(TAG, "current is v2 restore");
            return false;
        }
        C11839m.m70688i(TAG, "current is v3 restore");
        return true;
    }

    public static /* synthetic */ int lambda$setRestoreInfoList$0(CloudRestoreItem cloudRestoreItem, CloudRestoreItem cloudRestoreItem2) {
        long size = cloudRestoreItem.getSize() + cloudRestoreItem.getAsize();
        long size2 = cloudRestoreItem2.getSize() + cloudRestoreItem2.getAsize();
        int sortPriority = getSortPriority(cloudRestoreItem);
        int sortPriority2 = getSortPriority(cloudRestoreItem2);
        if (sortPriority2 != sortPriority) {
            return sortPriority2 - sortPriority;
        }
        if (size != size2) {
            return Long.compare(size2, size);
        }
        return 0;
    }

    public static boolean needSaveRestoreInfo(int i10) {
        if (i10 != 2 && i10 != 3) {
            C11839m.m70689w(TAG, "status is " + i10 + " ; no need save");
            return false;
        }
        List<CloudRestoreItem> itemList = RestoreProgress.getItemList();
        int failCount = getFailCount(0, itemList);
        if (failCount > 0) {
            C11839m.m70689w(TAG, "failedCount is " + failCount + " ; no need save");
            return false;
        }
        C11839m.m70688i(TAG, "completedNotification failedCount = " + failCount);
        int succeedCount = getSucceedCount(0, itemList);
        if (succeedCount <= 0) {
            C11839m.m70689w(TAG, "succeedCount is " + succeedCount + " ; no need save");
            return false;
        }
        FirstTimeOverview subscribeNotifyOm = getSubscribeNotifyOm("showRestoreSuccessReport", "restoreSuccess");
        if (subscribeNotifyOm == null) {
            C11839m.m70689w(TAG, "restoreOverView is empty; no need save");
            return false;
        }
        if (!TextUtils.isEmpty(subscribeNotifyOm.getUrl())) {
            return true;
        }
        C11839m.m70689w(TAG, "The OM configuration parameter is invalid.; no need save");
        return false;
    }

    public static void pmsMoveCheckBeforeDownload(String str, int i10) {
        String strM75685u = C12583q.m75685u(str, i10);
        File fileM63442h = C10278a.m63442h(strM75685u);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(C12583q.m75680p(1));
        String str2 = File.separator;
        sb2.append(str2);
        sb2.append(str);
        sb2.append(str2);
        sb2.append(str);
        String string = sb2.toString();
        File fileM63442h2 = C10278a.m63442h(string);
        if (fileM63442h2.exists() && !C9951a.m61736a(fileM63442h2.list())) {
            C12571m.m75542d(strM75685u);
            C11839m.m70688i(TAG, "pmsMoveCheckBeforeDownload moduleDataDir has data, delete tempPmsMovePath");
        } else {
            if (!fileM63442h.exists() || C9951a.m61736a(fileM63442h.list())) {
                return;
            }
            C11839m.m70688i(TAG, "pmsMoveCheckBeforeDownload tempPmsMoveDir rename: " + (C11835i.m70643g(string) && fileM63442h.renameTo(fileM63442h2)));
        }
    }

    public static int prepare(CloudRestoreStatusV3 cloudRestoreStatusV3, C4880b c4880b) throws C9721b {
        String strM29470M = cloudRestoreStatusV3.m29470M();
        List<Integer> listPrepareCloneUid = prepareCloneUid(cloudRestoreStatusV3);
        if (listPrepareCloneUid != null && !listPrepareCloneUid.isEmpty()) {
            Iterator<Integer> it = listPrepareCloneUid.iterator();
            if (it.hasNext()) {
                Integer next = it.next();
                if (!C12568l.m75537f(strM29470M, 0)) {
                    C11839m.m70687e(TAG, "apk not installed, can not restore clone data.");
                    throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "apk not installed, can not restore clone data.");
                }
                if (!C12568l.m75537f(strM29470M, next.intValue())) {
                    C11839m.m70687e(TAG, "cloned app not installed, install cloned app.");
                    if (!C12568l.m75536e(strM29470M, next.intValue())) {
                        C11839m.m70687e(TAG, "cloned app installed failed.");
                        cloudRestoreStatusV3.setStatus(-1);
                        cloudRestoreStatusV3.setType(2);
                        new C12816g().m76957u(cloudRestoreStatusV3);
                        throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "cloned app installed failed.");
                    }
                    Context contextM1377a = C0213f.m1377a();
                    StorageManager storageManager = contextM1377a != null ? (StorageManager) contextM1377a.getSystemService("storage") : null;
                    if (storageManager == null) {
                        C11839m.m70687e(TAG, "cloned app installed failed. storageManager is null");
                        throw new C9721b(1009, "cloned app installed failed. storageManager is null");
                    }
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    C11839m.m70686d(TAG, "cloned app wait start");
                    while (true) {
                        if (Math.abs(System.currentTimeMillis() - jCurrentTimeMillis) >= MAX_QUERY_APPTWIN_CREATE_PATH_TIME) {
                            break;
                        }
                        c4880b.isRelease();
                        String clonePathByUserId = getClonePathByUserId(storageManager, next.intValue());
                        if (TextUtils.isEmpty(C0221j.m1501k())) {
                            throw new C9721b(1009, "prepare app clone path is empty");
                        }
                        if (TextUtils.equals(clonePathByUserId, C0221j.m1501k())) {
                            C11839m.m70688i(TAG, "appclonepath exist");
                            break;
                        }
                        SystemClock.sleep(400L);
                    }
                    C11839m.m70686d(TAG, "cloned app wait end");
                }
                return next.intValue();
            }
        }
        return 0;
    }

    public static List<Integer> prepareCloneUid(CloudRestoreStatusV3 cloudRestoreStatusV3) throws C9721b {
        synchronized (PREPARE_CLONEUID_LOCK) {
            try {
                if (!cloudRestoreStatusV3.isTwinApp()) {
                    return null;
                }
                List<Integer> listM75535d = C12568l.m75535d();
                C11839m.m70688i(TAG, "prepareCloneUid clonedUserIds: " + listM75535d);
                if (listM75535d.isEmpty()) {
                    C12568l.m75532a();
                    listM75535d = C12568l.m75535d();
                    C0221j.m1487O(listM75535d);
                }
                if (TextUtils.isEmpty(C0221j.m1501k())) {
                    C0221j.m1509s(C0213f.m1377a());
                }
                if (TextUtils.isEmpty(C0221j.m1501k())) {
                    throw new C9721b(1009, "app clone path is empty");
                }
                return listM75535d;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private static long queryV3LastBackupTime() throws C9721b {
        C13998b0 c13998b0 = new C13998b0();
        try {
            Long lM84109K0 = c13998b0.m84109K0();
            if (lM84109K0 != null) {
                return lM84109K0.longValue();
            }
            Iterator<Device> it = c13998b0.m84132c0("nextCursor,devices", C11058a.m66627b("02017"), true, true, true, false, null, false, false).iterator();
            while (it.hasNext()) {
                for (Bak bak : it.next().getBaks()) {
                    String device = bak.getDevice();
                    if (!TextUtils.isEmpty(device) && bak.getBackupStatus().intValue() == 0) {
                        if (bak.isRefurbishment()) {
                            C11839m.m70688i(TAG, "record is refurbishment record.");
                        } else if (bak.isTempBackup()) {
                            C11839m.m70688i(TAG, "record is tempbackup record.");
                        } else {
                            C11707b c11707b = (C11707b) C11903a.m71435l().mo69832e(device).m69886u(C11707b.class);
                            Iterator<String> it2 = c11707b.keySet().iterator();
                            while (it2.hasNext()) {
                                Object obj = c11707b.get(it2.next());
                                if (obj != null) {
                                    device = obj.toString();
                                }
                            }
                            if (!TextUtils.isEmpty(device) && device.equals(C13452e.m80781L().m80950o())) {
                                C4644l endTime = bak.getEndTime();
                                if (endTime != null && (lM84109K0 == null || lM84109K0.longValue() < endTime.m28458c())) {
                                    lM84109K0 = Long.valueOf(endTime.m28458c());
                                }
                            }
                        }
                    }
                }
            }
            if (lM84109K0 == null) {
                return 0L;
            }
            return lM84109K0.longValue();
        } catch (C9721b e10) {
            throw new C9721b(3107, "query v3 last record failed: " + e10.getMessage());
        } catch (IOException e11) {
            throw new C9721b(3107, "query v3 last record failed IOException: " + e11.getMessage());
        }
    }

    public static void registerAutoRestore(boolean z10, boolean z11, C13029h c13029h) {
        if (c13029h == null) {
            C11839m.m70688i(TAG, "registerAutoRestore tags is null");
            return;
        }
        RestoreRetry restoreRetryM75325A0 = new C12526j().m75325A0();
        long restoreDelayTime = getRestoreDelayTime();
        if (!z11 && !checkIsRegisterAutoRestore(c13029h, restoreRetryM75325A0)) {
            C11839m.m70688i(TAG, "registerAutoRestore not enough condition unRegister");
            if (z10) {
                CloudBackupJobManager.getInstance().unRegisterDsRestoreScheduler();
                return;
            } else {
                CloudBackupJobManager.getInstance().unRegisterRestoreScheduler();
                return;
            }
        }
        if (z10) {
            CloudBackupJobManager.getInstance().unRegisterDsRestoreScheduler();
            CloudBackupJobManager.getInstance().registerDsRestoreScheduler(restoreDelayTime);
            return;
        }
        CloudBackupJobManager.getInstance().unRegisterRestoreScheduler();
        if (!z11 && c13029h.m78474q().contains(String.valueOf(1002))) {
            restoreDelayTime = 10000;
        }
        CloudBackupJobManager.getInstance().registerRestoreScheduler(Long.valueOf(restoreDelayTime));
    }

    public static void reportBackupSubscribeNotify(String str, String str2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        boolean zM82513c = C13731j.m82513c(C0213f.m1377a());
        linkedHashMap.put(NotifyConstants.Keys.NOTIFY_TYPE, str2);
        linkedHashMap.put("notificationEnabled", String.valueOf(zM82513c));
        C13225d.m79490f1().m79591l0(str, linkedHashMap);
        UBAAnalyze.m29958S("PVC", str, "4", "78", linkedHashMap);
    }

    public static void reportSourceFromNotification(Intent intent, String str) {
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(intent);
        if ("entry_backup_notify".equals(hiCloudSafeIntent.m29113i("entry_source", "entry_undefined"))) {
            String strM29113i = hiCloudSafeIntent.m29113i("notify_type", "");
            if (TextUtils.isEmpty(strM29113i)) {
                return;
            }
            C13225d.m79490f1().m79585f0(strM29113i, C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", strM29113i, "4", str);
        }
    }

    public static int restoreSyncSwitchData(CloudRestoreStatusV3 cloudRestoreStatusV3, List<SyncSwitchStatus> list) {
        if (cloudRestoreStatusV3 == null || AbstractC14026a.m84159a(list)) {
            C11839m.m70687e(TAG, "restoreSyncSwitch error,input invalid.");
            return -1;
        }
        try {
            ArrayList<SyncSwitchRestoreResult> arrayList = new ArrayList();
            Map<String, Integer> mapM76030f = C12597u1.m76030f();
            for (SyncSwitchStatus syncSwitchStatus : list) {
                SyncSwitchRestoreResult syncSwitchRestoreResult = new SyncSwitchRestoreResult();
                if (HNConstants.DataType.MEDIA.equals(syncSwitchStatus.getSyncType())) {
                    boolean z10 = true;
                    if (syncSwitchStatus.getStatus() != 1) {
                        z10 = false;
                    }
                    if (!C13452e.m80781L().m80791C0() || (C13452e.m80781L().m80791C0() && !z10)) {
                        C12597u1.m76031g(z10);
                        C11839m.m70688i(TAG, "set sync switch switchStatus: " + syncSwitchStatus.toString());
                    } else {
                        C11839m.m70688i(TAG, "not allow to set sync switch switchStatus: " + syncSwitchStatus.toString() + ", gradeCode: " + C13452e.m80781L().m80790C() + ", status: " + syncSwitchStatus.getStatus());
                    }
                    syncSwitchRestoreResult.setSyncType(HNConstants.DataType.MEDIA);
                    syncSwitchRestoreResult.setStatusBefore(mapM76030f.getOrDefault(HNConstants.DataType.MEDIA, -1).intValue());
                    syncSwitchRestoreResult.setCode(0);
                    arrayList.add(syncSwitchRestoreResult);
                } else {
                    int iM76032h = C12597u1.m76032h(syncSwitchStatus.getSyncType(), syncSwitchStatus.getStatus());
                    syncSwitchRestoreResult.setSyncType(syncSwitchStatus.getSyncType());
                    syncSwitchRestoreResult.setStatusBefore(mapM76030f.getOrDefault(syncSwitchStatus.getSyncType(), -1).intValue());
                    syncSwitchRestoreResult.setCode(iM76032h);
                    arrayList.add(syncSwitchRestoreResult);
                    C11839m.m70688i(TAG, "set sync switch switchStatus: " + syncSwitchStatus.toString() + ", result: " + iM76032h);
                }
            }
            Map<String, Integer> mapM76030f2 = C12597u1.m76030f();
            for (SyncSwitchRestoreResult syncSwitchRestoreResult2 : arrayList) {
                String syncType = syncSwitchRestoreResult2.getSyncType();
                syncSwitchRestoreResult2.setStatusAfterRestore(mapM76030f2.getOrDefault(syncType, -1).intValue());
                C11839m.m70688i(TAG, "after set, sync switch syncType: " + syncType + ", switchStatus: " + syncSwitchRestoreResult2.getStatusAfterRestore());
            }
            cloudRestoreStatusV3.m29467K0(new Gson().toJson(arrayList));
            return 0;
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "restoreSyncSwitch error:" + e10.getMessage());
            return -1;
        }
    }

    public static void saveRestoreInfoToSp(int i10, boolean z10) {
        if (needSaveRestoreInfo(i10)) {
            C11839m.m70688i(TAG, "saveRestoreInfoToSp start: " + i10 + " ; isFromOOBE :" + z10);
            ArrayList arrayList = new ArrayList();
            String str = setRestoreInfoList(arrayList) ? CloudBackupConstant.RestoreDataDictionaryType.BASIC : CloudBackupConstant.RestoreDataDictionaryType.FULL;
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            long j10 = 0;
            long j11 = 0;
            while (it.hasNext()) {
                CloudRestoreItem cloudRestoreItem = (CloudRestoreItem) it.next();
                if (!TextUtils.equals("bmBaseData", cloudRestoreItem.getAppId())) {
                    if (j11 >= 30) {
                        break;
                    }
                    long size = cloudRestoreItem.getSize() + cloudRestoreItem.getAsize();
                    j11++;
                    arrayList2.add(new C4870d(getRestoreItemName(cloudRestoreItem), RestoreProgress.formatData(C0213f.m1377a(), size), getRestoreItemBase64Icon(cloudRestoreItem, true)));
                    C11839m.m70686d("saveRestoreInfoToSp", "appId : " + cloudRestoreItem.getAppId() + " ; appName :" + cloudRestoreItem.getAppName() + " ; action :" + cloudRestoreItem.getAction() + " ; size :" + cloudRestoreItem.getSize() + " ; aSize :" + cloudRestoreItem.getAsize() + " ; AppShowType:" + cloudRestoreItem.getAppShowType() + " ; BmAppDataType:" + cloudRestoreItem.getBmAppDataType());
                    it = it;
                    j10 += size;
                }
            }
            C11839m.m70688i("saveRestoreInfoToSp", "totalSize : " + j10 + " ; totalCount :" + j11);
            C13462b.m81015c().m81021g("restoreDataDictionary", C10527a.m64633k(new C4869c(arrayList2, RestoreProgress.formatData(C0213f.m1377a(), j10), j11, str)));
            BackupNotification.getInstance().cancelBackupNotificationById(788);
            C13462b.m81015c().m81020f("isOObeRestoreNotify", z10);
            C13462b.m81015c().m81020f("needSendRestoreNotify", true);
            C11839m.m70688i(TAG, "saveRestoreInfoToSp end: " + i10 + " ; isFromOOBE :" + z10);
        }
    }

    public static void scanFileList(List<String> list, Context context) {
        if (list == null) {
            return;
        }
        new ScannerClient(context).scanPathList(list);
    }

    public static void scanFolder(String str, Context context) {
        if (str == null) {
            return;
        }
        File fileM63442h = C10278a.m63442h(str);
        if (!fileM63442h.isDirectory()) {
            new ScannerClient(context).scanPath(C10279b.m63452a(fileM63442h));
            return;
        }
        File[] fileArrM63440f = C10278a.m63440f(fileM63442h);
        if (fileArrM63440f == null) {
            return;
        }
        for (File file : fileArrM63440f) {
            if (file != null) {
                new ScannerClient(context).scanPath(C10279b.m63452a(file));
                if (file.isDirectory()) {
                    scanFolder(C10279b.m63452a(file), context);
                }
            }
        }
    }

    public static synchronized boolean sendSubscribeRestoreSuccessNotify() {
        if (!C13462b.m81015c().m81017b("needSendRestoreNotify", false)) {
            C11839m.m70689w(TAG, "sendSubscribeRestoreSuccessNotify : needSend  = false");
            return false;
        }
        FirstTimeOverview firstTimeOverviewM68043e = C11326d.m68043e("restoreSuccess");
        if (firstTimeOverviewM68043e == null) {
            C13462b.m81015c().m81020f("needSendRestoreNotify", false);
            C11839m.m70689w(TAG, "restoreOverView is null");
            return false;
        }
        return RestoreNotification.getInstance().sendSubscribeRestoreSuccessNotification(firstTimeOverviewM68043e, C13462b.m81015c().m81017b("isOObeRestoreNotify", false));
    }

    public static long setLastSuccessTime() {
        SettingOperator settingOperator = new SettingOperator();
        long jQuerylastsuccesstime = settingOperator.querylastsuccesstime();
        if (jQuerylastsuccesstime == 0) {
            String strQueryBakSourceStrategy = settingOperator.queryBakSourceStrategy();
            C11839m.m70688i(TAG, "setLastSuccessTime bakSourceStrategy " + strQueryBakSourceStrategy);
            try {
                jQuerylastsuccesstime = "2".equals(strQueryBakSourceStrategy) ? queryV3LastBackupTime() : getV2LastSuccessTime();
                settingOperator.replace(new Settings[]{new Settings("lastsuccesstime", String.valueOf(jQuerylastsuccesstime), "2")});
                C10028c.m62182c0().m62217G2(false);
                C11839m.m70688i(TAG, "setLastSuccessTime lastsuccesstime = " + jQuerylastsuccesstime);
            } catch (C9721b e10) {
                C11839m.m70688i(TAG, "setLastSuccessTime failed: " + e10.getMessage());
            }
        }
        return jQuerylastsuccesstime;
    }

    public static boolean setRestoreInfoList(List<CloudRestoreItem> list) {
        List arrayList = list;
        if (list == null) {
            arrayList = new ArrayList();
        }
        List<CloudRestoreItem> itemList = RestoreProgress.getItemList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        boolean z10 = true;
        for (CloudRestoreItem cloudRestoreItem : itemList) {
            if (TextUtils.equals("bmBaseData", cloudRestoreItem.getAppId())) {
                arrayList2.addAll(cloudRestoreItem.m29202r());
            } else if (TextUtils.equals("thirdAppData", cloudRestoreItem.getAppId())) {
                arrayList3.addAll(cloudRestoreItem.m29202r());
            } else {
                z10 = false;
            }
            arrayList4.add(cloudRestoreItem);
        }
        if (z10) {
            arrayList.addAll(arrayList2);
        } else {
            arrayList.addAll(arrayList4);
            if (!arrayList3.isEmpty()) {
                arrayList.addAll(arrayList3);
            }
        }
        arrayList.sort(new Comparator() { // from class: com.huawei.android.hicloud.cloudbackup.process.s0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return RestoreUtil.lambda$setRestoreInfoList$0((CloudRestoreItem) obj, (CloudRestoreItem) obj2);
            }
        });
        return z10;
    }

    public static void setRestoreStatus(Context context, boolean z10) {
        C0214f0.m1382b(context, NotifyConstants.InterfaceC4909SP.USERINFO_SPFILE, 0).edit().putBoolean("restoreStatus", z10).apply();
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0072 A[PHI: r6 r8
  0x0072: PHI (r6v3 boolean) = (r6v0 boolean), (r6v1 boolean), (r6v0 boolean) binds: [B:40:0x0077, B:42:0x007d, B:36:0x006f] A[DONT_GENERATE, DONT_INLINE]
  0x0072: PHI (r8v4 boolean) = (r8v2 boolean), (r8v2 boolean), (r8v6 boolean) binds: [B:40:0x0077, B:42:0x007d, B:36:0x006f] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String srcPathCheckBeforePmsMoveExecute(boolean r8, java.lang.String r9, int r10) {
        /*
            r0 = 1
            java.lang.String r0 = p618rm.C12583q.m75680p(r0)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = java.io.File.separator
            r1.append(r0)
            r1.append(r9)
            java.lang.String r1 = r1.toString()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            r2.append(r0)
            r2.append(r9)
            java.lang.String r0 = r2.toString()
            java.io.File r1 = hk.C10278a.m63442h(r0)
            java.lang.String r10 = p618rm.C12583q.m75685u(r9, r10)
            java.io.File r2 = hk.C10278a.m63442h(r10)
            boolean r3 = r2.exists()
            boolean r4 = r1.exists()
            java.lang.String r5 = "RestoreUtil"
            r6 = 0
            if (r8 != 0) goto L69
            if (r4 != 0) goto L69
            if (r3 == 0) goto L69
            java.lang.String[] r8 = r2.list()
            boolean r8 = p316gk.C9951a.m61736a(r8)
            if (r8 != 0) goto L69
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "srcPathCheckBeforePmsMoveExecute retry use old path: "
            r8.append(r0)
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            p514o9.C11839m.m70688i(r5, r8)
            r0 = r10
            r8 = r6
            goto Laa
        L69:
            if (r3 == 0) goto L76
            boolean r8 = p514o9.C11835i.m70643g(r10)
            if (r8 == 0) goto L72
            goto L77
        L72:
            r7 = r6
            r6 = r8
            r8 = r7
            goto L98
        L76:
            r8 = r6
        L77:
            if (r4 == 0) goto L72
            boolean r6 = r1.renameTo(r2)
            if (r6 == 0) goto L72
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "srcPathCheckBeforePmsMoveExecute check success"
            r0.append(r1)
            r0.append(r9)
            java.lang.String r9 = r0.toString()
            p514o9.C11839m.m70688i(r5, r9)
            r0 = r10
            r7 = r6
            r6 = r8
            r8 = r7
            goto Laa
        L98:
            if (r4 == 0) goto La4
            java.lang.String[] r9 = r1.list()
            boolean r9 = p316gk.C9951a.m61736a(r9)
            if (r9 == 0) goto Laa
        La4:
            java.lang.String r9 = "srcPathCheckBeforePmsMoveExecute originSrcDir is empty"
            p514o9.C11839m.m70689w(r5, r9)
            r0 = 0
        Laa:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "tempMoveDirDeleteResult: "
            r9.append(r10)
            r9.append(r6)
            java.lang.String r10 = " ,originSrcDirRenameResult: "
            r9.append(r10)
            r9.append(r8)
            java.lang.String r8 = " ,originSrcExist: "
            r9.append(r8)
            r9.append(r4)
            java.lang.String r8 = " ,tempMoveDirExist: "
            r9.append(r8)
            r9.append(r3)
            java.lang.String r8 = r9.toString()
            p514o9.C11839m.m70688i(r5, r8)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.cloudbackup.process.RestoreUtil.srcPathCheckBeforePmsMoveExecute(boolean, java.lang.String, int):java.lang.String");
    }
}
