package com.huawei.android.hicloud.cloudbackup.report;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.huawei.android.backup.service.logic.C2126b;
import com.huawei.android.hicloud.cloudbackup.bean.BackupAppSwitchStatusBean;
import com.huawei.android.hicloud.cloudbackup.bean.RestoreModuleReportInfo;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.model.RestoreCache;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.bean.PmsMeta;
import com.huawei.android.hicloud.cloudbackup.process.util.ListUtils;
import com.huawei.android.hicloud.cloudbackup.report.CloudBackupReport;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.android.hicloud.task.simple.C3017c;
import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import com.huawei.hicloud.notification.util.GeneralRedirectUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import gp.C10028c;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToLongFunction;
import java.util.stream.Collectors;
import je.C10790h;
import org.json.JSONObject;
import p015ak.C0213f;
import p015ak.C0240y;
import p015ak.C0241z;
import p292fn.C9733f;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11839m;
import p616rk.C12515a;
import p618rm.C12590s0;
import p684un.C13222a;
import p684un.C13223b;
import p684un.C13225d;
import p684un.C13230i;
import p709vj.C13452e;
import p746wn.C13622a;
import p783xp.C13843a;
import p815ym.AbstractC14026a;
import tl.C13029h;

/* loaded from: classes2.dex */
public class CloudBackupReport {
    private static final String CLONE_BACKUP_RESTORE_MSG = "clone_Backup_Restore_Msg";
    private static final String DELETE_TASK_RESET_MODULE = "deleteTaskResetModule";
    private static final String GALLERY_RETRY_COPY_FILE_UPLOAD = "gallery_retry_copy_file_upload";
    private static final String IS_DO_LOSTFILE_FIX = "is_do_lostfile_fix";
    private static final int MAX_REPORT_FILE_COUNT = 10;
    private static final int MAX_REPORT_MODULE_COUNT = 30;
    private static final String PMS_MOVE_TXTLINE_METACOUNT = "pms_move_txtline_metacount";
    private static final String RESTORE_COPY_FILE_ERROR = "restore_copy_file_error";
    private static final String RESTORE_ONE_MODULE_WITH_FILE_STATUS = "restoreOneModuleFileStatusAbnormal";
    private static final String RESTORE_UNTAR_ERROR = "restore_untar_error";
    private static final String SAFEBOX_RESTORE_ERROR = "safebox_restore_error";
    private static final String TAG = "CloudBackupReport";
    private static final String TEMP_DEVICE_DELETE = "temp_device_delete";
    private static String appMarketVersionCode = "";

    private static void addReportFilesInfo(final List<PmsMeta> list, List<PmsMeta> list2) {
        if (list.size() < 10) {
            int size = 10 - list.size();
            if (AbstractC14026a.m84159a(list2)) {
                return;
            }
            list.addAll((List) list2.stream().filter(new Predicate() { // from class: l8.a
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return CloudBackupReport.lambda$addReportFilesInfo$0(list, (PmsMeta) obj);
                }
            }).sorted(Comparator.comparingLong(new ToLongFunction() { // from class: l8.b
                @Override // java.util.function.ToLongFunction
                public final long applyAsLong(Object obj) {
                    return ((PmsMeta) obj).getSize();
                }
            }).reversed()).limit(size).collect(Collectors.toList()));
        }
    }

    public static void collectModuleInfo(List<BackupAppSwitchStatusBean> list, String str, BackupOptionItem backupOptionItem, long j10) {
        if (list == null) {
            return;
        }
        try {
            BackupAppSwitchStatusBean backupAppSwitchStatusBean = new BackupAppSwitchStatusBean();
            backupAppSwitchStatusBean.setAppId(str);
            backupAppSwitchStatusBean.setSwitchStatus(String.valueOf(backupOptionItem.getBackupSwitch()));
            backupAppSwitchStatusBean.setDataSize(String.valueOf(backupOptionItem.getDataBytes()));
            backupAppSwitchStatusBean.setTotalIncrease(String.valueOf(backupOptionItem.getTotalIncrease()));
            backupAppSwitchStatusBean.setCurrentIncrease(String.valueOf(backupOptionItem.getCurrentIncrease()));
            backupAppSwitchStatusBean.setIsBackupData(String.valueOf(backupOptionItem.isBackupData()));
            backupAppSwitchStatusBean.setBeginTime(String.valueOf(j10));
            backupAppSwitchStatusBean.setEndTime(String.valueOf(System.currentTimeMillis()));
            backupAppSwitchStatusBean.setTs(String.valueOf(backupOptionItem.getOperateTime()));
            list.add(backupAppSwitchStatusBean);
        } catch (Throwable th2) {
            C11839m.m70687e(TAG, "collectModuleInfo error: " + th2.getMessage());
        }
    }

    private static Context getContext() {
        return C0213f.m1377a();
    }

    public static void initAppMarketVersionCode() {
        appMarketVersionCode = C0240y.m1680b(getContext(), C13843a.m83090l());
    }

    public static /* synthetic */ boolean lambda$addReportFilesInfo$0(List list, PmsMeta pmsMeta) {
        return !list.contains(pmsMeta);
    }

    public static void reportAppModuleReset(boolean z10, String str, String str2, String str3, String str4, String str5, String str6) {
        String str7 = z10 ? "resetModule" : "deleteModule";
        C11060c c11060cM66626a = C11058a.m66626a(str2, str7, C13452e.m80781L().m80971t0());
        c11060cM66626a.m66663s(str);
        c11060cM66626a.m66665u("010_200");
        c11060cM66626a.m66635A(str5);
        c11060cM66626a.m66668x("1");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("appId", String.valueOf(str));
        linkedHashMap.put("resetOrDelete", str7);
        linkedHashMap.put(C2126b.ERROR_MESSAGE_INFO, str5);
        linkedHashMap.put(RemoteMessageConst.FROM, str6);
        linkedHashMap.put(GeneralRedirectUtil.BAK_ID, str3);
        linkedHashMap.put("backupAction", str4);
        C13622a.m81971q(c11060cM66626a, linkedHashMap, false, true);
        UBAAnalyze.m29947H("CKC", str7, linkedHashMap);
    }

    public static void reportAppRefreshBloomFilterErr(String str, String str2, String str3) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        C11060c c11060cM66626a = C11058a.m66626a(str3, "appRefreshBloomFilterErr", C13452e.m80781L().m80971t0());
        linkedHashMap.put("appId", str);
        c11060cM66626a.m66665u("010_200");
        c11060cM66626a.m66635A(str2);
        C13622a.m81969o(getContext(), c11060cM66626a, linkedHashMap);
    }

    public static void reportBackupDataAcptErrInfo(List<PmsMeta> list, List<PmsMeta> list2, List<PmsMeta> list3, String str, String str2) {
        ArrayList arrayList = new ArrayList(10);
        addReportFilesInfo(arrayList, list);
        addReportFilesInfo(arrayList, list2);
        addReportFilesInfo(arrayList, list3);
        List list4 = (List) arrayList.stream().map(new Function() { // from class: l8.c
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((PmsMeta) obj).getFilePath();
            }
        }).collect(Collectors.toList());
        C11060c c11060cM66626a = C11058a.m66626a(str2, "reportBackupDataAcptErrInfo", C13452e.m80781L().m80971t0());
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        c11060cM66626a.m66665u("010_200");
        linkedHashMap.put("path", list4.toString());
        linkedHashMap.put(C2126b.ERROR_MESSAGE_INFO, String.valueOf(str));
        c11060cM66626a.m66635A(str);
        c11060cM66626a.m66668x("1");
        C13622a.m81971q(c11060cM66626a, linkedHashMap, false, true);
        UBAAnalyze.m29947H("CKC", "reportBackupDataAcptErrInfo", linkedHashMap);
    }

    public static void reportBackupStart(String str, String str2, Integer num, String str3, Integer num2, Integer num3) {
        C11060c c11060cM66626a = C11058a.m66626a(str, "reportBackupStart", C13452e.m80781L().m80971t0());
        boolean zM62388s = C10028c.m62182c0().m62388s("backup_key");
        boolean zM62303a1 = C10028c.m62182c0().m62303a1();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        c11060cM66626a.m66665u("010_200");
        linkedHashMap.put("backupSwitch", String.valueOf(zM62388s));
        linkedHashMap.put("baseSwitch", String.valueOf(zM62303a1));
        linkedHashMap.put(FaqConstants.FAQ_CHANNEL, String.valueOf(num3));
        linkedHashMap.put("days", String.valueOf(num2));
        linkedHashMap.put("backupAction", String.valueOf(str2));
        linkedHashMap.put("occupySpaceType", String.valueOf(num));
        linkedHashMap.put("bakCategory", String.valueOf(str3));
        c11060cM66626a.m66668x("1");
        C13622a.m81971q(c11060cM66626a, linkedHashMap, false, true);
        UBAAnalyze.m29947H("CKC", "reportBackupStart", linkedHashMap);
    }

    public static void reportCloneFinishInfo(Message message) {
        if (!C9733f.m60705z().m60720O("cloudBackupModuleInfoReport")) {
            C11839m.m70688i(TAG, "report clone finish info failed, gray switch is closed.");
            return;
        }
        if (message == null) {
            return;
        }
        Bundle bundle = (Bundle) message.obj;
        String string = bundle.getString("app_id");
        String string2 = bundle.getString(C2126b.MODULE_INFO_LIST);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("appId", string);
        linkedHashMap.put("moduleInfoList", string2);
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("02011"), CLONE_BACKUP_RESTORE_MSG, C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("010_" + message.what);
        C13622a.m81969o(C0213f.m1377a(), c11060cM66626a, linkedHashMap);
        UBAAnalyze.m29947H("CKC", CLONE_BACKUP_RESTORE_MSG, linkedHashMap);
        C11839m.m70688i(TAG, "report clone finish info success. appId: " + string + ", moduleInfoList: " + string2);
    }

    public static void reportCloneInfo(Message message, Bundle bundle) {
        if (bundle == null || message == null) {
            return;
        }
        String string = bundle.getString(C2126b.ERROR_MESSAGE_INFO);
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("02011"), CLONE_BACKUP_RESTORE_MSG, C13452e.m80781L().m80971t0());
        String str = "010_" + message.what;
        c11060cM66626a.m66665u(str);
        c11060cM66626a.m66635A(string);
        C13622a.m81968n(C0213f.m1377a(), c11060cM66626a);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("errorReason", string);
        linkedHashMap.put("code", str);
        UBAAnalyze.m29947H("CKC", CLONE_BACKUP_RESTORE_MSG, linkedHashMap);
        C11839m.m70688i(TAG, "clone service error， report errorMsg = " + string);
    }

    public static void reportCloseAllFullModule(List<String> list) {
        List list2 = (List) list.stream().limit(30L).collect(Collectors.toList());
        C11060c c11060cM66626a = C11058a.m66626a(null, "reportCloseAllFullModule", C13452e.m80781L().m80971t0());
        boolean zM62388s = C10028c.m62182c0().m62388s("backup_key");
        boolean zM62303a1 = C10028c.m62182c0().m62303a1();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        c11060cM66626a.m66665u("010_200");
        linkedHashMap.put("backupSwitch", String.valueOf(zM62388s));
        linkedHashMap.put("baseSwitch", String.valueOf(zM62303a1));
        linkedHashMap.put("closeAppIds", list2.toString());
        c11060cM66626a.m66668x("1");
        C13622a.m81971q(c11060cM66626a, linkedHashMap, false, true);
        UBAAnalyze.m29947H("CKC", "reportCloseAllFullModule", linkedHashMap);
        C12515a.m75110o().m75172d(new C3017c((ArrayList<String>) new ArrayList(list), true));
    }

    public static void reportCloseSuccess(Boolean bool, Activity activity) {
        if (bool == null || bool.booleanValue()) {
            reportOld("mecloud_backupmain_click_base_switch", false);
            reportNew("CLOUDBACKUP_CLOSE_BASE_CLOUDBACKUP_SUCCEED", activity, activity);
        }
        if (bool == null || !bool.booleanValue()) {
            reportOld("mecloud_backupmain_click_full_switch", false);
            reportNew("CLOUDBACKUP_CLOSE_FULL_CLOUDBACKUP_SUCCEED", activity, activity);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("backup_key");
        C12515a.m75110o().m75172d(new C3017c((ArrayList<String>) arrayList));
    }

    public static void reportCloseSwitch(Boolean bool, Context context, Activity activity) {
        if (bool == null || bool.booleanValue()) {
            reportNew("CLOUDBACKUP_CLOSE_BASE_CLOUDBACKUP", context, activity);
        }
        if (bool == null || !bool.booleanValue()) {
            reportNew("CLOUDBACKUP_CLOSE_FULL_CLOUDBACKUP", context, activity);
        }
    }

    public static void reportDeleteBaseAppModule(String str, int i10, String str2) {
        C11060c c11060cM66626a = C11058a.m66626a(str2, "baseAppsDelete", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("010_200");
        c11060cM66626a.m66635A(i10 + "_" + str);
        c11060cM66626a.m66668x("1");
        C13622a.m81968n(C0213f.m1377a(), c11060cM66626a);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("result", str);
        linkedHashMap.put("deleteReportEntry", String.valueOf(i10));
        if (!TextUtils.isEmpty(str2)) {
            linkedHashMap.put("traceId", str2);
        }
        UBAAnalyze.m29947H("CKC", "baseAppsDelete", linkedHashMap);
    }

    public static void reportDeleteInvalidDmFilesErr(String str, String str2, String str3) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        C11060c c11060cM66626a = C11058a.m66626a(str3, "deleteInvalidDmFilesErr", C13452e.m80781L().m80971t0());
        linkedHashMap.put("appId", str);
        c11060cM66626a.m66665u("010_200");
        c11060cM66626a.m66635A(str2);
        C13622a.m81969o(getContext(), c11060cM66626a, linkedHashMap);
    }

    public static void reportDeleteSingle(String str, String str2, String str3, String str4, boolean z10, String str5) {
        C11060c c11060cM66626a = C11058a.m66626a(str, "reportDeleteSingle", C13452e.m80781L().m80971t0());
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        c11060cM66626a.m66665u("010_200");
        linkedHashMap.put("version", String.valueOf(str3));
        linkedHashMap.put(RemoteMessageConst.FROM, str4);
        linkedHashMap.put(GeneralRedirectUtil.BAK_ID, String.valueOf(str2));
        linkedHashMap.put("result", String.valueOf(z10));
        linkedHashMap.put(C2126b.ERROR_MESSAGE_INFO, String.valueOf(str5));
        c11060cM66626a.m66635A(str5);
        c11060cM66626a.m66668x("1");
        C13622a.m81971q(c11060cM66626a, linkedHashMap, false, true);
        UBAAnalyze.m29947H("CKC", "reportDeleteSingle", linkedHashMap);
    }

    public static void reportDeleteTaskResetModule(String str, String str2, String str3, int i10) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("traceID", str);
        linkedHashMap.put("appId", str2);
        linkedHashMap.put("backupId", str3);
        linkedHashMap.put("status", String.valueOf(i10));
        C11060c c11060cM66626a = C11058a.m66626a(str, DELETE_TASK_RESET_MODULE, C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("010_200");
        c11060cM66626a.m66663s(str2);
        c11060cM66626a.m66668x("1");
        C13622a.m81969o(C0213f.m1377a(), c11060cM66626a, linkedHashMap);
        C13225d.m79490f1().m79567R(DELETE_TASK_RESET_MODULE, linkedHashMap);
        UBAAnalyze.m29947H("CKC", DELETE_TASK_RESET_MODULE, linkedHashMap);
    }

    public static void reportGalleryRetryCopyFileUpload(String str, String str2) {
        C11060c c11060cM66626a = C11058a.m66626a(str, GALLERY_RETRY_COPY_FILE_UPLOAD, C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("010_200");
        c11060cM66626a.m66635A(str2);
        c11060cM66626a.m66668x("1");
        C13622a.m81968n(C0213f.m1377a(), c11060cM66626a);
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("traceID", str);
        linkedHashMap.put("errorReason", str2);
        C13225d.m79490f1().m79567R(GALLERY_RETRY_COPY_FILE_UPLOAD, linkedHashMap);
        UBAAnalyze.m29947H("CKC", GALLERY_RETRY_COPY_FILE_UPLOAD, linkedHashMap);
    }

    public static void reportGradeCodeChangeSwitchChange(String str, boolean z10) {
        C11060c c11060cM66626a = C11058a.m66626a(null, "gradeCodeChange", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("010_200");
        c11060cM66626a.m66635A(str + "_" + z10);
        c11060cM66626a.m66668x("1");
        C13622a.m81968n(C0213f.m1377a(), c11060cM66626a);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("gradeCode", str);
        linkedHashMap.put("switchStatus", String.valueOf(z10));
        UBAAnalyze.m29947H("CKC", "gradeCodeChange", linkedHashMap);
    }

    public static void reportIsSkip(String str, String str2, String str3, int i10) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String strM66627b = C11058a.m66627b("02014");
        linkedHashMap.put("backupTransID", str3);
        linkedHashMap.put("appId", str);
        linkedHashMap.put("status", str2);
        linkedHashMap.put("importance", String.valueOf(i10));
        C11060c c11060cM66626a = C11058a.m66626a(strM66627b, str2, C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("010_200");
        linkedHashMap.put("userType", C13452e.m80781L().m80987x0());
        linkedHashMap.put("gradeCode", C12590s0.m75747G0());
        C13622a.m81971q(c11060cM66626a, linkedHashMap, false, true);
    }

    public static void reportLostAppRequestErr(String str, String str2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("traceID", str);
        linkedHashMap.put("lostAppRequestErrorMsg", String.valueOf(str2));
        C11060c c11060cM66626a = C11058a.m66626a(str, "lostAppRequestErrorMsg", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("010_200");
        c11060cM66626a.m66668x("1");
        C13622a.m81969o(C0213f.m1377a(), c11060cM66626a, linkedHashMap);
    }

    public static void reportLostFileFix(String str, boolean z10) {
        if (z10) {
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
            linkedHashMap.put("traceID", str);
            linkedHashMap.put("isDoLostFileFix", String.valueOf(z10));
            C11060c c11060cM66626a = C11058a.m66626a(str, "lostFileFix", C13452e.m80781L().m80971t0());
            c11060cM66626a.m66665u("010_200");
            c11060cM66626a.m66668x("1");
            C13622a.m81969o(C0213f.m1377a(), c11060cM66626a, linkedHashMap);
            C13225d.m79490f1().m79567R(IS_DO_LOSTFILE_FIX, linkedHashMap);
            UBAAnalyze.m29947H("CKC", IS_DO_LOSTFILE_FIX, linkedHashMap);
        }
    }

    public static void reportLostFileRequestErr(String str, String str2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("traceID", str);
        linkedHashMap.put("lostFileRequestErrorMsg", String.valueOf(str2));
        C11060c c11060cM66626a = C11058a.m66626a(str, "lostFileRequestError", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("010_200");
        c11060cM66626a.m66668x("1");
        C13622a.m81969o(C0213f.m1377a(), c11060cM66626a, linkedHashMap);
    }

    private static void reportNew(String str, Context context, Activity activity) {
        JSONObject jSONObjectM79482j = C13223b.m79482j(context, str, "1", C13452e.m80781L().m80971t0(), C13222a.m79465g(activity));
        C13222a.m79461c(context, jSONObjectM79482j);
        UBAAnalyze.m29952M("CKC", str, jSONObjectM79482j);
    }

    private static void reportOld(String str, boolean z10) {
        String str2 = z10 ? "1" : "2";
        C13225d.m79490f1().m79587h0(str, str2, str2, C13452e.m80781L().m80971t0());
        UBAAnalyze.m29971c0("PVC", str, "1", "16", str2, str2);
    }

    public static void reportOmError(String str) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("errorReason", str);
        C13225d.m79490f1().m79591l0("backup_om_error", linkedHashMap);
        C13225d.m79490f1().m79573U("backup_om_error", linkedHashMap);
        UBAAnalyze.m29947H("CKC", "backup_om_error", linkedHashMap);
    }

    private static void reportOmSingleMoudleRestore(String str, LinkedHashMap<String, String> linkedHashMap) {
        C11060c c11060cM66626a = C11058a.m66626a(str, "restoreOneMoudle", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("010_200");
        C13622a.m81971q(c11060cM66626a, linkedHashMap, false, true);
    }

    public static void reportOpenCloudBackup(String str, int i10, String str2) {
        C11839m.m70686d(TAG, "reportOpenCloudBackup：" + str);
        C13225d c13225dM79490f1 = C13225d.m79490f1();
        Integer numValueOf = Integer.valueOf(i10);
        Boolean bool = Boolean.TRUE;
        c13225dM79490f1.m79559K0(str, numValueOf, str2, bool, bool);
    }

    public static void reportOpenSwitch(String str, Boolean bool, Context context, Activity activity) {
        if (bool == null || bool.booleanValue()) {
            reportNew("CLOUDBACKUP_OPEN_BASE_CLOUDBACKUP", context, activity);
            C13225d.m79490f1().m79557I0(str);
            reportOld("mecloud_backupmain_click_base_switch", true);
        }
        if (bool == null || !bool.booleanValue()) {
            reportNew("CLOUDBACKUP_OPEN_FULL_CLOUDBACKUP", context, activity);
            C13225d.m79490f1().m79563M0(str);
            reportOld("mecloud_backupmain_click_full_switch", true);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("backup_key");
        C12515a.m75110o().m75172d(new C3017c((ArrayList<String>) arrayList));
    }

    public static void reportPmsMoveTxtlineMetacount(String str, String str2, int i10, long j10, long j11) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("traceID", str);
        linkedHashMap.put("txtLine", String.valueOf(j10));
        linkedHashMap.put("metaCount", String.valueOf(j11));
        linkedHashMap.put("appId", str2);
        linkedHashMap.put(JsbMapKeyNames.H5_USER_ID, String.valueOf(i10));
        C11060c c11060cM66626a = C11058a.m66626a(str, "pmsMoveTxtlineMetacount", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("010_200");
        c11060cM66626a.m66668x("1");
        C13622a.m81969o(C0213f.m1377a(), c11060cM66626a, linkedHashMap);
        C13225d.m79490f1().m79567R(PMS_MOVE_TXTLINE_METACOUNT, linkedHashMap);
        UBAAnalyze.m29947H("CKC", PMS_MOVE_TXTLINE_METACOUNT, linkedHashMap);
    }

    public static void reportRecordsIsExist(long j10, int i10, String str) {
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("02009"), "restoreFileExits", C13452e.m80781L().m80971t0());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("entryType=");
        sb2.append(i10);
        sb2.append("entranceOfRestore=");
        sb2.append(str);
        sb2.append(" vfs not exits, count: " + j10);
        c11060cM66626a.m66666v("isSuccess", "0", "1", sb2.toString());
        C13622a.m81968n(getContext(), c11060cM66626a);
    }

    public static void reportRestoreCopyErrorInfo(String str) {
        if (str == null) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("errorInfo", str);
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("02003"), RESTORE_COPY_FILE_ERROR, C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("010_200");
        C13622a.m81969o(C0213f.m1377a(), c11060cM66626a, linkedHashMap);
        UBAAnalyze.m29947H("CKC", RESTORE_COPY_FILE_ERROR, linkedHashMap);
        C11839m.m70688i(TAG, "reportRestoreCopyErrorInfo.");
    }

    public static void reportRestoreFileStatusAbnormalNum(String str, String str2, boolean z10, long j10) {
        if (j10 <= 0) {
            C11839m.m70686d(TAG, "reportRestoreFileUploadStatusNum fileStatusAbnormalNum<=0");
            return;
        }
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("traceID", str);
        linkedHashMap.put("appId", str2);
        linkedHashMap.put("isOOBERestore", String.valueOf(z10));
        linkedHashMap.put("fileStatusAbnormalNum", String.valueOf(j10));
        C11060c c11060cM66626a = C11058a.m66626a(str, RESTORE_ONE_MODULE_WITH_FILE_STATUS, C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("010_200");
        c11060cM66626a.m66663s(str2);
        c11060cM66626a.m66668x("1");
        C13622a.m81969o(C0213f.m1377a(), c11060cM66626a, linkedHashMap);
        C13225d.m79490f1().m79567R(RESTORE_ONE_MODULE_WITH_FILE_STATUS, linkedHashMap);
        UBAAnalyze.m29947H("CKC", RESTORE_ONE_MODULE_WITH_FILE_STATUS, linkedHashMap);
    }

    public static void reportRestoreLocalRecord(C13029h c13029h, boolean z10, int i10, String str, String str2) {
        if (c13029h == null) {
            return;
        }
        String strM78465h = c13029h.m78465h();
        String strM78444J = c13029h.m78444J();
        String strM80950o = C13452e.m80781L().m80950o();
        String str3 = (strM80950o == null || !strM80950o.equals(str2)) ? "1" : "0";
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("is_local_record", str3);
        linkedHashMap.put("deviceID", str2);
        linkedHashMap.put("backupId", strM78465h);
        linkedHashMap.put("traceID", strM78444J);
        linkedHashMap.put("isAllchecked", String.valueOf(z10));
        linkedHashMap.put("entryType", String.valueOf(i10));
        linkedHashMap.put("index", String.valueOf(RestoreCache.getInstance().getIndex()));
        linkedHashMap.put("recordCount", String.valueOf(RestoreCache.getInstance().getRecordCount()));
        C13230i.m79544u(i10, str, linkedHashMap);
        C13225d.m79490f1().m79603z0("restore_local_record", linkedHashMap);
    }

    public static void reportRestoreStart(String str, String str2, String str3, boolean z10, boolean z11, boolean z12, boolean z13) {
        C11060c c11060cM66626a = C11058a.m66626a(str, "reportRestoreStart", C13452e.m80781L().m80971t0());
        boolean zM62388s = C10028c.m62182c0().m62388s("backup_key");
        boolean zM62303a1 = C10028c.m62182c0().m62303a1();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        c11060cM66626a.m66665u("010_200");
        linkedHashMap.put("backupSwitch", String.valueOf(zM62388s));
        linkedHashMap.put("baseSwitch", String.valueOf(zM62303a1));
        linkedHashMap.put("bakCategory", String.valueOf(str2));
        linkedHashMap.put("backupId", String.valueOf(str3));
        linkedHashMap.put("isRetry", String.valueOf(z10));
        linkedHashMap.put("isResumeRetry", String.valueOf(z11));
        linkedHashMap.put("fromOOBE", String.valueOf(z12));
        linkedHashMap.put("isAuto", String.valueOf(z13));
        c11060cM66626a.m66668x("1");
        C13622a.m81971q(c11060cM66626a, linkedHashMap, false, true);
        UBAAnalyze.m29947H("CKC", "reportRestoreStart", linkedHashMap);
    }

    public static void reportSafeBoxRestoreErrorMsg(LinkedHashMap<String, String> linkedHashMap, String str) {
        linkedHashMap.put("traceID", str);
        C11060c c11060cM66626a = C11058a.m66626a(str, SAFEBOX_RESTORE_ERROR, C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("010_200");
        c11060cM66626a.m66668x("1");
        C13622a.m81969o(C0213f.m1377a(), c11060cM66626a, linkedHashMap);
        C13225d.m79490f1().m79567R(SAFEBOX_RESTORE_ERROR, linkedHashMap);
        UBAAnalyze.m29947H("CKC", SAFEBOX_RESTORE_ERROR, linkedHashMap);
    }

    public static void reportSingleModuleRestore(RestoreModuleReportInfo restoreModuleReportInfo, String str, boolean z10, int i10, String str2, boolean z11, String str3) {
        String str4;
        C11839m.m70686d(TAG, "reportSingleModuleRestore");
        if (restoreModuleReportInfo == null) {
            return;
        }
        long reportEndTime = restoreModuleReportInfo.getReportEndTime();
        long startTime = restoreModuleReportInfo.getStartTime();
        int uid = restoreModuleReportInfo.getUid();
        String appId = restoreModuleReportInfo.getAppId();
        long size = restoreModuleReportInfo.getSize() + restoreModuleReportInfo.getAsize();
        int status = restoreModuleReportInfo.getStatus();
        int type = restoreModuleReportInfo.getType();
        String versionName = restoreModuleReportInfo.getVersionName();
        String errorReason = restoreModuleReportInfo.getErrorReason();
        String strValueOf = String.valueOf(restoreModuleReportInfo.getVersionCode());
        String strValueOf2 = String.valueOf(restoreModuleReportInfo.getVersion());
        String str5 = C0241z.m1685c(appMarketVersionCode) >= 110301004 ? "1" : "0";
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("entryType", String.valueOf(i10));
        linkedHashMap.put("moduleSize", String.valueOf(size));
        linkedHashMap.put("appId", appId);
        linkedHashMap.put("uId", String.valueOf(uid));
        linkedHashMap.put("startTime", String.valueOf(startTime));
        linkedHashMap.put("endTime", String.valueOf(reportEndTime));
        linkedHashMap.put("status", String.valueOf(status));
        linkedHashMap.put("type", String.valueOf(type));
        linkedHashMap.put("versionName", versionName);
        linkedHashMap.put("errorReason", errorReason);
        linkedHashMap.put("versionCode", strValueOf);
        linkedHashMap.put("version", strValueOf2);
        linkedHashMap.put("appMarketVersionCode", appMarketVersionCode);
        linkedHashMap.put("isSupportInstallEvent", str5);
        linkedHashMap.put("bakCategory", str3);
        C13230i.m79544u(i10, str2, linkedHashMap);
        if (z10) {
            str4 = "1";
            linkedHashMap.put("restoreType", str4);
            linkedHashMap.put("isDownloadApk", z11 ? "1" : "0");
            C10790h.m65662j(linkedHashMap, restoreModuleReportInfo);
        } else {
            linkedHashMap.put("restoreType", "2");
            linkedHashMap.put("isRestoreApk", z11 ? "1" : "0");
            if (("safebox".equalsIgnoreCase(appId) || "safebox1".equalsIgnoreCase(appId)) && !TextUtils.isEmpty(restoreModuleReportInfo.getData1())) {
                linkedHashMap.put("safeBoxDataIntegrity", restoreModuleReportInfo.getData1());
            }
            if ("virtual.sync.switch.status".equalsIgnoreCase(appId)) {
                linkedHashMap.put("message", restoreModuleReportInfo.getMessage());
            }
            Map<String, String> subSourceInfo = ICBUtil.getSubSourceInfo(restoreModuleReportInfo.getSubSourceInfo());
            if (subSourceInfo != null) {
                linkedHashMap.put(CloudBackupConstant.ReportAppMarket.KEY_SUB_SOURCE, subSourceInfo.get(CloudBackupConstant.ReportAppMarket.KEY_SUB_SOURCE));
                linkedHashMap.put(CloudBackupConstant.ReportAppMarket.KEY_PKG_CHANNEL_ID, subSourceInfo.get(CloudBackupConstant.ReportAppMarket.KEY_PKG_CHANNEL_ID));
            }
            if (!TextUtils.isEmpty(restoreModuleReportInfo.getData1()) && !"safebox".equalsIgnoreCase(appId) && !"safebox1".equalsIgnoreCase(appId) && !"Memo".equalsIgnoreCase(appId)) {
                linkedHashMap.put("isModuleDiff", restoreModuleReportInfo.getData1());
            }
            linkedHashMap.put("signCheckResult", restoreModuleReportInfo.getSignCheckResult());
            if ("fail".equals(restoreModuleReportInfo.getSignCheckResult())) {
                linkedHashMap.put("localSignatures", restoreModuleReportInfo.getLocalSignatures());
                linkedHashMap.put("backupSignatures", restoreModuleReportInfo.getBackupSignatures());
            }
        }
        if (restoreModuleReportInfo.isCitOpt()) {
            linkedHashMap.put("isCitOpt", Boolean.TRUE.toString());
        }
        reportOmSingleMoudleRestore(str, linkedHashMap);
        linkedHashMap.put("traceID", str);
        C13225d.m79490f1().m79567R("single_moudle_restore", linkedHashMap);
        UBAAnalyze.m29947H("CKC", "single_moudle_restore", linkedHashMap);
    }

    public static void reportSwitchBeans(List<BackupAppSwitchStatusBean> list, String str, boolean z10, boolean z11) {
        if (AbstractC14026a.m84159a(list)) {
            C11839m.m70688i(TAG, "reportSwitchBeans is empty");
            return;
        }
        try {
            List listPartition = ListUtils.partition(list, 10);
            for (int i10 = 0; i10 < listPartition.size(); i10++) {
                List list2 = (List) listPartition.get(i10);
                LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
                String json = new Gson().toJson(list2);
                linkedHashMap.put("traceID", str);
                linkedHashMap.put("moduleInfo", json);
                linkedHashMap.put("isRefurbish", String.valueOf(z10));
                linkedHashMap.put("isTemp", String.valueOf(z11));
                C13225d.m79490f1().m79567R("cloudbackup_option_module_status_ex", linkedHashMap);
                UBAAnalyze.m29947H("CKC", "cloudbackup_option_module_status_ex", linkedHashMap);
            }
        } catch (Throwable th2) {
            C11839m.m70687e(TAG, "reportSwitchBeans error: " + th2.getMessage());
        }
    }

    public static void reportTempDeviceDelete(String str, String str2, String str3) {
        C11060c c11060cM66626a = C11058a.m66626a(str, TEMP_DEVICE_DELETE, C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("010_" + str3);
        c11060cM66626a.m66635A(str2);
        c11060cM66626a.m66668x("1");
        C13622a.m81968n(C0213f.m1377a(), c11060cM66626a);
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("traceID", str);
        linkedHashMap.put("code", str3);
        linkedHashMap.put("errorReason", str2);
        C13225d.m79490f1().m79567R(TEMP_DEVICE_DELETE, linkedHashMap);
        UBAAnalyze.m29947H("CKC", TEMP_DEVICE_DELETE, linkedHashMap);
    }

    public static void reportTempInvalidClear(boolean z10) {
        C11060c c11060cM66626a = C11058a.m66626a(null, "reportTempInvalidClear", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("010_200");
        c11060cM66626a.m66635A("backupSwitch: " + z10);
        c11060cM66626a.m66668x("1");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("backupSwitch", String.valueOf(z10));
        C13622a.m81971q(c11060cM66626a, linkedHashMap, false, true);
        UBAAnalyze.m29947H("CKC", "reportTempInvalidClear", linkedHashMap);
    }

    public static void reportUnTarError(String str, String str2) {
        C11060c c11060cM66626a = C11058a.m66626a(str, "unTarAll", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("010_404");
        c11060cM66626a.m66635A(str2);
        c11060cM66626a.m66668x("1");
        C13622a.m81968n(C0213f.m1377a(), c11060cM66626a);
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("traceID", str);
        linkedHashMap.put("errorReason", str2);
        C13225d.m79490f1().m79567R(RESTORE_UNTAR_ERROR, linkedHashMap);
        UBAAnalyze.m29947H("CKC", RESTORE_UNTAR_ERROR, linkedHashMap);
    }
}
