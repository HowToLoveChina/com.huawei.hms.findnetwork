package p618rm;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.StatFs;
import android.os.SystemClock;
import android.os.UserHandle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Pair;
import com.google.gson.Gson;
import com.huawei.android.backup.filelogic.utils.PmsCheckUtil;
import com.huawei.android.backup.service.logic.C2126b;
import com.huawei.android.hicloud.cloudbackup.bean.AppInfoList;
import com.huawei.android.hicloud.cloudbackup.bean.BackupDataAcptErrPolicy;
import com.huawei.android.hicloud.cloudbackup.bean.CloudBackup;
import com.huawei.android.hicloud.cloudbackup.bean.RefurbishRestoreFailInfo;
import com.huawei.android.hicloud.cloudbackup.bean.RefurbishRestoreInfo;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.model.HiddenAlbumFileData;
import com.huawei.android.hicloud.cloudbackup.p076db.bean.Settings;
import com.huawei.android.hicloud.cloudbackup.p076db.operator.SettingOperator;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.bean.PmsMeta;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.bean.PmsMetaStatus;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.bean.PmsMetaV3;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator.PmsFullBriefFilesInfoOperatorV3;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator.PmsMetaStatusOperator;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator.PmsMetaStatusOperatorV3;
import com.huawei.android.hicloud.cloudbackup.process.UserSpaceUtil;
import com.huawei.android.hicloud.cloudbackup.process.task.BackupModuleInfoQueryLogic;
import com.huawei.android.hicloud.cloudbackup.process.task.C2575c0;
import com.huawei.android.hicloud.cloudbackup.process.util.AppDataSizeUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.BackupRestoreUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.CloudBackupAppDataUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.CloudBackupConditionsUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.ICycleChecker;
import com.huawei.android.hicloud.cloudbackup.process.util.PmsUtils;
import com.huawei.android.hicloud.cloudbackup.process.util.ScanAppDataUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.SplitAppUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.TarFileUtil;
import com.huawei.android.hicloud.cloudbackup.progress.RestoreProgress;
import com.huawei.android.hicloud.cloudbackup.snapshottree.SnapshotTreeManagementService;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.bean.BackupRecordMeta;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.bean.SnapshotBackupMeta;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.operator.SnapshotBackupMetaOperator;
import com.huawei.android.hicloud.cloudbackup.util.BackupNewBmTypeUtil;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackupLanguageUtil;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.android.hicloud.cloudbackup.util.TransferedUtil;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.constant.backup.Constant;
import com.huawei.android.hicloud.p088ui.activity.C3765j1;
import com.huawei.android.hicloud.p088ui.uiutil.NewHiSyncUtil;
import com.huawei.android.p073ds.R$string;
import com.huawei.cloud.base.util.C4633d0;
import com.huawei.fastengine.fastview.NavigationUtils;
import com.huawei.feedback.log.BaseLogger;
import com.huawei.hicloud.base.bean.CloudSpace;
import com.huawei.hicloud.base.bean.Md5AndHash;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.cloudbackup.model.CloudRecoveryItem;
import com.huawei.hicloud.cloudbackup.model.CloudRestoreItem;
import com.huawei.hicloud.cloudbackup.p104v3.core.C4879a;
import com.huawei.hicloud.cloudbackup.p104v3.omconfig.model.SyncAppBackupPolicy;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.About;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak;
import com.huawei.hicloud.cloudbackup.store.database.report.CloudBackupReport;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudBackupStatus;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudRestoreStatusV3;
import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.data.BackupSpaceNotEnoughNeedData;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.request.cbs.bean.CBSBaseReq;
import com.huawei.hicloud.router.data.UserBackupInfo;
import com.huawei.hms.support.api.entity.sns.SNSCode;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.tencent.p204mm.opensdk.constants.ConstantsAPI;
import dm.C9195d0;
import dm.C9215i0;
import fk.C9721b;
import gp.C10028c;
import gt.C10046b;
import hk.C10278a;
import hk.C10279b;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import mk.C11476b;
import mk.C11477c;
import ne.C11667a;
import p015ak.C0209d;
import p015ak.C0212e0;
import p015ak.C0213f;
import p015ak.C0221j;
import p015ak.C0234s;
import p015ak.C0237v;
import p015ak.C0240y;
import p015ak.C0241z;
import p020ap.C1006a;
import p052cb.C1413j;
import p292fn.C9731d;
import p292fn.C9733f;
import p429kk.C11058a;
import p429kk.C11060c;
import p494nk.C11718b;
import p495nm.C11723d;
import p495nm.C11724e;
import p495nm.C11725f;
import p495nm.C11726g;
import p514o9.C11835i;
import p514o9.C11839m;
import p514o9.C11843q;
import p581qk.AbstractC12367d;
import p582ql.C12372c;
import p616rk.C12515a;
import p617rl.C12519c;
import p617rl.C12526j;
import p684un.C13225d;
import p684un.C13230i;
import p709vj.C13452e;
import p711vl.C13464d;
import p711vl.C13466f;
import p711vl.C13467g;
import p744wl.C13617a;
import p744wl.C13619c;
import p746wn.C13622a;
import p783xp.C13843a;
import p814yl.C13998b0;
import p815ym.AbstractC14026a;
import p848zl.C14333b;
import p848zl.C14337f;
import p848zl.C14339h;
import pl.C12161c;
import pl.C12164f;
import pm.C12176c;
import sl.C12813d;
import sl.C12814e;
import sl.C12815f;
import tl.C13026e;
import tl.C13029h;
import tl.C13030i;
import tl.C13032k;
import tl.C13033l;
import tl.C13036o;

/* renamed from: rm.s0 */
/* loaded from: classes6.dex */
public class C12590s0 {

    /* renamed from: a */
    public static final Object f57968a = new Object();

    /* renamed from: b */
    public static final Object f57969b = new Object();

    /* renamed from: c */
    public static long f57970c;

    /* renamed from: d */
    public static long f57971d;

    /* renamed from: rm.s0$a */
    public static class a extends AbstractC12367d {

        /* renamed from: a */
        public final CountDownLatch f57972a;

        /* renamed from: b */
        public final Bundle f57973b;

        public a(CountDownLatch countDownLatch, Bundle bundle) {
            this.f57972a = countDownLatch;
            this.f57973b = bundle;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            String strValueOf = "";
            try {
                Bundle bundleCall = C0213f.m1377a().getContentResolver().call(Uri.parse(CloudBackupConstant.SAFEBOX_DATA_CONTENT_URI), "backUpCheckSBCompleteness", (String) null, (Bundle) null);
                if (bundleCall != null) {
                    strValueOf = String.valueOf(bundleCall.getBoolean("strongBoxBackUpComplete"));
                }
            } catch (Exception e10) {
                C11839m.m70687e("CloudBackupV3Utils", "querySafeBoxDataIntegrity e = " + e10.getMessage());
            }
            this.f57972a.countDown();
            this.f57973b.putString(CloudBackupConstant.DATA_INTEGRITY, strValueOf);
        }
    }

    /* renamed from: A */
    public static C11726g m75722A(boolean z10, boolean z11, List<String> list, C13026e c13026e) {
        long j10;
        long totalIncrease;
        List<BackupOptionItem> listM78397u = c13026e.m78397u();
        long j11 = 0;
        if (listM78397u == null || listM78397u.isEmpty()) {
            j10 = 0;
        } else {
            j10 = 0;
            long dataBytes = 0;
            for (BackupOptionItem backupOptionItem : listM78397u) {
                if (backupOptionItem.getBackupSwitch() && (!HNConstants.DataType.MEDIA.equals(backupOptionItem.getAppId()) || ICBUtil.isSupportGallery(C0213f.m1377a()))) {
                    if (!list.contains(backupOptionItem.getAppId())) {
                        dataBytes += backupOptionItem.getDataBytes();
                        if (z11) {
                            dataBytes += backupOptionItem.getCodeBytes();
                        }
                        if (z10) {
                            if (backupOptionItem.getTotalIncrease() > 0) {
                                totalIncrease = backupOptionItem.getTotalIncrease();
                                j10 += totalIncrease;
                            }
                        } else if (backupOptionItem.getCurrentIncrease() > 0) {
                            totalIncrease = backupOptionItem.getCurrentIncrease();
                            j10 += totalIncrease;
                        }
                    }
                }
            }
            j11 = dataBytes;
        }
        C11726g c11726g = new C11726g();
        c11726g.m69966d(j11);
        c11726g.m69965c(j10);
        return c11726g;
    }

    /* renamed from: A0 */
    public static long[] m75723A0(String str, String str2, int i10, CloudBackupAppDataUtil cloudBackupAppDataUtil, C13026e c13026e) {
        BackupOptionItem backupOptionItemM78401y = c13026e.m78401y(str);
        long[] sdcardAndAndroidDataInfo = {0, 0};
        if (backupOptionItemM78401y == null || C0241z.m1688f(backupOptionItemM78401y.getData3()) <= 0) {
            C11839m.m70688i("CloudBackupV3Utils", "getSdcardTotalCount optionItem is empty");
            try {
                sdcardAndAndroidDataInfo = new ScanAppDataUtil(str, i10, str2, cloudBackupAppDataUtil.getmCloudBackupInclude(), cloudBackupAppDataUtil.getmCloudBackupExclude()).getSdcardAndAndroidDataInfo(cloudBackupAppDataUtil);
                if (backupOptionItemM78401y != null) {
                    backupOptionItemM78401y.setData2(String.valueOf(sdcardAndAndroidDataInfo[1]));
                    backupOptionItemM78401y.setData3(String.valueOf(sdcardAndAndroidDataInfo[0]));
                    c13026e.m78382Q(backupOptionItemM78401y);
                }
            } catch (C9721b e10) {
                C11839m.m70688i("CloudBackupV3Utils", "getSdcardTotalCount getSdcardCountAndSize CException = " + e10.getMessage());
            }
        } else {
            sdcardAndAndroidDataInfo[0] = C0241z.m1688f(backupOptionItemM78401y.getData3());
            sdcardAndAndroidDataInfo[1] = C0241z.m1688f(backupOptionItemM78401y.getData2());
        }
        return sdcardAndAndroidDataInfo;
    }

    /* renamed from: A1 */
    public static boolean m75724A1(String str, int i10) {
        String strM81914C = C13617a.m81914C(str, i10);
        if (!C10278a.m63442h(strM81914C).exists()) {
            return false;
        }
        try {
            PmsMetaStatus pmsMetaStatusQuery = new PmsMetaStatusOperatorV3(strM81914C).query();
            if (pmsMetaStatusQuery != null) {
                if (pmsMetaStatusQuery.getStatus() == 5) {
                    return true;
                }
            }
        } catch (C9721b e10) {
            C11839m.m70687e("CloudBackupV3Utils", "isV3PmsBriefProcess: " + e10);
        }
        return false;
    }

    /* renamed from: A2 */
    public static void m75725A2(String str, LinkedHashMap<String, String> linkedHashMap) {
        try {
            CloudBackupReport cloudBackupReportM74421d = new C12372c().m74421d(str);
            if (cloudBackupReportM74421d != null) {
                linkedHashMap.put("increase", String.valueOf(cloudBackupReportM74421d.m29300N0()));
                linkedHashMap.put("estimateIncrease1", String.valueOf(cloudBackupReportM74421d.m29298L0()));
                linkedHashMap.put("estimateIncrease2", String.valueOf(cloudBackupReportM74421d.m29299M0()));
            }
        } catch (C9721b e10) {
            C11839m.m70689w("CloudBackupV3Utils", "reportIncrease error." + e10.getMessage());
        }
    }

    /* renamed from: B */
    public static void m75726B(String str, boolean z10, boolean z11, boolean z12) throws C9721b {
        int i10 = (z10 ? 1 : 0) + (z11 ? 1 : 0) + (z12 ? 1 : 0);
        if (i10 == 0) {
            throw new C9721b(2005, "cloneDataPrepare 3 apk all not exist " + str);
        }
        if (i10 <= 1) {
            return;
        }
        throw new C9721b(2005, "cloneDataPrepare 2 apk exist " + str);
    }

    /* renamed from: B0 */
    public static List<String> m75727B0() {
        try {
            List<String> listM62456d = C10046b.m62456d();
            C11839m.m70688i("CloudBackupV3Utils", "serviceBundleNames: " + listM62456d);
            return listM62456d;
        } catch (Exception e10) {
            C11839m.m70687e("CloudBackupV3Utils", "getServiceBundleNames error: " + e10);
            return new ArrayList();
        }
    }

    /* renamed from: B1 */
    public static boolean m75728B1(String str) {
        return "V4".equalsIgnoreCase(str);
    }

    /* renamed from: B2 */
    public static void m75729B2(String str, String str2, String str3, String str4, LinkedHashMap<String, String> linkedHashMap) {
        linkedHashMap.put("mergeDBFileHash", str2);
        linkedHashMap.put("oriFileHash", str3);
        linkedHashMap.put("traceId", str);
        linkedHashMap.put("filePath", str4);
        C11839m.m70686d("CloudBackupV3Utils", "reportMergeDBFileStatus event: " + linkedHashMap);
        C11060c c11060cM66626a = C11058a.m66626a(str, "merge_db_file_status", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("113_200");
        if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str2)) {
            linkedHashMap.put("isSuccess", String.valueOf(false));
        } else {
            boolean zContains = str3.contains(str2);
            linkedHashMap.put("isSuccess", String.valueOf(zContains));
            c11060cM66626a.m66638D("filePath = " + str4 + " hashEqual = " + zContains);
        }
        C13622a.m81971q(c11060cM66626a, linkedHashMap, false, true);
        C13225d.m79490f1().m79567R("cloudbackup_merge_db_file_status", linkedHashMap);
        UBAAnalyze.m29947H("CKC", "cloudbackup_merge_db_file_status", linkedHashMap);
    }

    /* renamed from: C */
    public static void m75730C(List<String> list) {
        if (list.contains("soundrecorder")) {
            list.add("callRecorder");
        }
        if (list.contains(NavigationUtils.SMS_SCHEMA_PREF)) {
            list.add("chatSms");
        }
    }

    /* renamed from: C0 */
    public static String m75731C0(Throwable th2) {
        StringBuilder sb2 = new StringBuilder();
        String strM75806V = m75806V(th2, 7, false);
        sb2.append(strM75806V);
        if (!strM75806V.contains("com.huawei.hicloud.cloudbackup") && !strM75806V.contains("com.huawei.android.hicloud.cloudbackup")) {
            sb2.append(m75806V(th2, 3, true));
        }
        String string = sb2.toString();
        return !TextUtils.isEmpty(string) ? string.replaceAll("com.huawei.hicloud.cloudbackup", "").replaceAll("com.huawei.android.hicloud.cloudbackup", "") : string;
    }

    /* renamed from: C1 */
    public static boolean m75732C1(C4879a c4879a, String str, PmsMetaV3 pmsMetaV3, Supplier<Double> supplier) {
        Double d10;
        if (!c4879a.m29648L0() || (d10 = supplier.get()) == null) {
            return false;
        }
        double dDoubleValue = d10.doubleValue();
        double dM29652N0 = C0241z.m1688f(str) > 0 ? c4879a.m29652N0() : c4879a.m29638G0();
        if (dDoubleValue >= 0.0d && dDoubleValue < dM29652N0) {
            C11839m.m70686d("CloudBackupV3Utils", "checkIsFileExistLastBackupRecord ratio: " + dDoubleValue + " ,tarRefRatio: " + dM29652N0 + " ,path: " + pmsMetaV3.getData());
            return true;
        }
        return false;
    }

    /* renamed from: C2 */
    public static void m75733C2(CloudBackupStatus cloudBackupStatus, Map<String, String> map, String str, String str2, boolean z10, boolean z11, C13026e c13026e) {
        if (map.isEmpty() || cloudBackupStatus == null) {
            return;
        }
        String strM29870d = cloudBackupStatus.m29870d();
        int iM29861N = cloudBackupStatus.m29861N();
        map.put("appId", strM29870d);
        map.put("uId", String.valueOf(iM29861N));
        map.put("backupId", str);
        map.put("endTime", String.valueOf(System.currentTimeMillis()));
        int iM29858I = cloudBackupStatus.m29858I();
        if (iM29858I == 3 && PmsUtils.isSupportPMSFastCopy() && ((!cloudBackupStatus.mo29370Q() && m75885o1(z10, z11)) || m75889p1(z10, z11))) {
            iM29858I = 4;
        }
        map.put("pmsScenceCode", String.valueOf(iM29858I));
        map.put("scanFileSize", String.valueOf(cloudBackupStatus.m29875i()));
        if (cloudBackupStatus.m29393b1().contains("isCitOpt")) {
            map.put("isCitOpt", String.valueOf(true));
        }
        map.put("isFileDiff", String.valueOf(cloudBackupStatus.m29393b1().contains("isDiff")));
        map.put("isDBDiff", String.valueOf(C9733f.m60705z().m60763v("backupDBDifferential")));
        map.put("isDBDiffCheck", String.valueOf(C9733f.m60705z().m60763v("backupDBDifferentialCheck")));
        if (cloudBackupStatus.m29863P()) {
            map.put("apkVersion", cloudBackupStatus.m29349G0());
            map.put("backupDataEnable", cloudBackupStatus.m29362M0());
        }
        if (cloudBackupStatus.mo29370Q()) {
            map.put("androidDataStrategy", cloudBackupStatus.m29345E0());
            map.put("uid", String.valueOf(cloudBackupStatus.m29861N()));
        }
        C11060c c11060cM66626a = C11058a.m66626a(str2, "backupTime", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("010_200");
        C13622a.m81971q(c11060cM66626a, map, false, true);
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>(map);
        linkedHashMap.put("traceId", str2);
        linkedHashMap.put("isSwitchOpen", String.valueOf(cloudBackupStatus.m29353I0()));
        linkedHashMap.put("status", String.valueOf(cloudBackupStatus.m29859L()));
        linkedHashMap.put("dataSize", String.valueOf(cloudBackupStatus.m29875i()));
        if (cloudBackupStatus.m29863P()) {
            linkedHashMap.put("apkSize", String.valueOf(cloudBackupStatus.m29874h()));
            BackupOptionItem backupOptionItemQueryItemByAppId = TransferedUtil.queryItemByAppId(strM29870d, c13026e);
            if (backupOptionItemQueryItemByAppId != null) {
                linkedHashMap.put("dataSize", String.valueOf(backupOptionItemQueryItemByAppId.getDataBytes()));
            }
        }
        m75725A2(strM29870d, linkedHashMap);
        C13225d.m79490f1().m79567R("cloudbackup_appdata_upload_status", linkedHashMap);
        UBAAnalyze.m29947H("CKC", "cloudbackup_appdata_upload_status", linkedHashMap);
    }

    /* renamed from: D */
    public static String m75734D(final BackupDataAcptErrPolicy.Policy policy, String str, List<PmsMeta> list, List<PmsMeta> list2) {
        if (policy == null || list == null) {
            return "";
        }
        List list3 = (List) list.stream().filter(new Predicate() { // from class: rm.b0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C12590s0.m75740E1(policy, (PmsMeta) obj);
            }
        }).collect(Collectors.toList());
        C11839m.m70688i("CloudBackupV3Utils", "checkBackupDataAcptErrPolicy: " + list3.size());
        if (AbstractC14026a.m84159a(list3)) {
            return "";
        }
        m75922x2(str, list3, list, list2, "key file changed");
        return "key file changed";
    }

    /* renamed from: D0 */
    public static About m75735D0() {
        try {
            About aboutM84095B = new C13998b0().m84095B("countLeftInInterim,disableInterimReason,freeUserInterimMaxTimes,interimExtraRetentionTime,interimExpirationDeleteTime", false, C11058a.m66627b("02102"), "", Integer.valueOf(C12600v1.f57995e));
            C11839m.m70688i("CloudBackupV3Utils", "countLeftInInterim: " + aboutM84095B.getCountLeftInInterim() + ", disableInterimReason: " + aboutM84095B.getDisableInterimReason() + ", freeUserInterimMaxTimes: " + aboutM84095B.getFreeUserInterimMaxTimes() + ", interimExtraRetentionTime: " + aboutM84095B.getInterimExtraRetentionTime() + ", interimExpirationDeleteTime: " + aboutM84095B.getInterimExpirationDeleteTime());
            C12600v1.m76050h(aboutM84095B.getInterimExpirationDeleteTime());
            C12600v1.m76051i(aboutM84095B.getInterimExtraRetentionTime());
            C12600v1.m76048f(aboutM84095B.getFreeUserInterimMaxTimes());
            return aboutM84095B;
        } catch (C9721b e10) {
            C11839m.m70689w("CloudBackupV3Utils", "getTempBackupTimes error: " + e10.getMessage());
            return null;
        }
    }

    /* renamed from: D1 */
    public static void m75736D1(Context context, String str, String str2) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent();
        C0209d.m1302r2(intent, context.getPackageName());
        intent.setFlags(805306368);
        intent.setAction(NotifyConstants.Action.HICLOUD_WEBVIEW_ACTION);
        intent.putExtra("url", str);
        intent.putExtra("title", str2);
        intent.putExtra("isEnableJs", true);
        intent.putExtra("is_support_orientation", true);
        intent.putExtra("is_support_dark_mode", true);
        intent.putExtra("is_orientation_unspecified", true);
        if (intent.resolveActivity(packageManager) == null) {
            C11839m.m70688i("CloudBackupV3Utils", "can not jump to findmyphone webview, jump to browser");
            intent = new HiCloudSafeIntent(new Intent());
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            if (intent.resolveActivity(packageManager) == null) {
                C11839m.m70688i("CloudBackupV3Utils", "can not jump to browser");
                return;
            }
        }
        try {
            context.startActivity(intent);
        } catch (Exception e10) {
            C11839m.m70687e("CloudBackupV3Utils", "startActivityForResult failed" + e10.toString());
        }
    }

    /* renamed from: D2 */
    public static void m75737D2(String str, Map<String, String> map) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>(map);
        C11839m.m70686d("CloudBackupV3Utils", "reportOneModuleDiffDBCheckStatus event: " + linkedHashMap);
        C11060c c11060cM66626a = C11058a.m66626a(str, "diff_db_check_status", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("113_200");
        C13622a.m81971q(c11060cM66626a, linkedHashMap, false, true);
        C13225d.m79490f1().m79567R("cloudbackup_file_diff_db_check_status", linkedHashMap);
        UBAAnalyze.m29947H("CKC", "cloudbackup_file_diff_db_check_status", linkedHashMap);
    }

    /* renamed from: E */
    public static void m75738E(final PmsMetaV3 pmsMetaV3, boolean z10, C4879a c4879a, String str, int i10, C9215i0 c9215i0, final String str2) throws C9721b {
        final C12161c c12161cM76018u;
        if (z10) {
            List<Bak> listM29646K0 = c4879a.m29646K0();
            boolean zM29705f1 = c4879a.m29705f1();
            if (m75732C1(c4879a, pmsMetaV3.getData4(), pmsMetaV3, new Supplier() { // from class: rm.m0
                @Override // java.util.function.Supplier
                public final Object get() {
                    return C12590s0.m75744F1(pmsMetaV3);
                }
            })) {
                return;
            }
            for (Bak bak : listM29646K0) {
                String backupVersion = bak.getBackupVersion();
                String id2 = bak.getId();
                if (m75925y1(backupVersion)) {
                    if (zM29705f1) {
                        continue;
                    } else {
                        try {
                            final SnapshotBackupMeta snapshotBackupMetaQueryLeafNodeByHash = SnapshotTreeManagementService.getInstance().queryLeafNodeByHash(str, id2, pmsMetaV3.getHash1(), pmsMetaV3.getData());
                            if (snapshotBackupMetaQueryLeafNodeByHash == null) {
                                continue;
                            } else {
                                C12814e c12814e = new C12814e();
                                C12813d c12813dM76919f = c12814e.m76919f(snapshotBackupMetaQueryLeafNodeByHash.getCloudPath());
                                if (c12813dM76919f == null) {
                                    if (m75732C1(c4879a, "", pmsMetaV3, new Supplier() { // from class: rm.n0
                                        @Override // java.util.function.Supplier
                                        public final Object get() {
                                            return C12590s0.m75748G1(str2, snapshotBackupMetaQueryLeafNodeByHash);
                                        }
                                    })) {
                                        return;
                                    }
                                    pmsMetaV3.setCloudPath(snapshotBackupMetaQueryLeafNodeByHash.getCloudPath());
                                    pmsMetaV3.setFlag(0);
                                    pmsMetaV3.setStatus(-2);
                                    pmsMetaV3.setType((int) snapshotBackupMetaQueryLeafNodeByHash.getType());
                                    m75789Q2(pmsMetaV3, c9215i0);
                                    return;
                                }
                                c12813dM76919f.m76913y(snapshotBackupMetaQueryLeafNodeByHash);
                                c12814e.m76921h(c12813dM76919f);
                            }
                        } catch (C9721b unused) {
                            continue;
                        }
                    }
                } else if (!m75921x1(backupVersion) && C13617a.m81938t(id2, str, 0, i10) && (c12161cM76018u = C12594t1.m75990o().m76018u(id2, str, pmsMetaV3.getCloudHash(), pmsMetaV3.getData(), i10)) != null) {
                    if (!TextUtils.isEmpty(c12161cM76018u.m72984h()) && !TextUtils.isEmpty(c12161cM76018u.m73009x())) {
                        C11839m.m70686d("CloudBackupV3Utils", "checkIsFileExistLastBackupRecord appId: " + str + " file: " + c12161cM76018u.m72991l() + " cloudpath and fileid all not empty");
                    } else if (c12161cM76018u.m73010y() == 0) {
                        if (zM29705f1) {
                            return;
                        }
                        C12814e c12814e2 = new C12814e();
                        C12813d c12813dM76919f2 = c12814e2.m76919f(c12161cM76018u.m72984h());
                        if (c12813dM76919f2 == null) {
                            if (m75732C1(c4879a, c12161cM76018u.m72999p(), pmsMetaV3, new Supplier() { // from class: rm.o0
                                @Override // java.util.function.Supplier
                                public final Object get() {
                                    return C12590s0.m75752H1(str2, c12161cM76018u);
                                }
                            })) {
                                return;
                            }
                            pmsMetaV3.setCloudPath(c12161cM76018u.m72984h());
                            pmsMetaV3.setFlag(0);
                            pmsMetaV3.setStatus(-2);
                            pmsMetaV3.setType((int) c12161cM76018u.m72953I());
                            m75789Q2(pmsMetaV3, c9215i0);
                            return;
                        }
                        c12813dM76919f2.m76911w(c12161cM76018u, i10);
                        c12814e2.m76921h(c12813dM76919f2);
                    } else if (TextUtils.isEmpty(c12161cM76018u.m73009x()) || TextUtils.isEmpty(c12161cM76018u.m72978e()) || TextUtils.isEmpty(c12161cM76018u.m72954J())) {
                        C11839m.m70686d("CloudBackupV3Utils", "checkIsFileExistLastBackupRecord dm file info lost appId: " + str + " file: " + c12161cM76018u.m72991l());
                    } else {
                        C12814e c12814e3 = new C12814e();
                        C12813d c12813dM76920g = c12814e3.m76920g(c12161cM76018u.m73009x());
                        if (c12813dM76920g == null) {
                            if (m75732C1(c4879a, c12161cM76018u.m72999p(), pmsMetaV3, new Supplier() { // from class: rm.p0
                                @Override // java.util.function.Supplier
                                public final Object get() {
                                    return C12590s0.m75756I1(str2, c12161cM76018u);
                                }
                            })) {
                                return;
                            }
                            pmsMetaV3.setFileId(c12161cM76018u.m73009x());
                            pmsMetaV3.setAssertId(c12161cM76018u.m72978e());
                            pmsMetaV3.setVersionId(c12161cM76018u.m72954J());
                            pmsMetaV3.setFlag(1);
                            pmsMetaV3.setStatus(-2);
                            pmsMetaV3.setType((int) c12161cM76018u.m72953I());
                            pmsMetaV3.setData4(c12161cM76018u.m72999p());
                            m75789Q2(pmsMetaV3, c9215i0);
                            return;
                        }
                        c12813dM76920g.m76911w(c12161cM76018u, i10);
                        c12814e3.m76921h(c12813dM76920g);
                    }
                }
            }
        }
    }

    /* renamed from: E0 */
    public static List<String> m75739E0(List<BackupOptionItem> list) {
        final HashSet hashSet = new HashSet();
        List<Integer> listM75535d = C12568l.m75535d();
        C11839m.m70688i("CloudBackupV3Utils", "getTwinAppNames: the uidList size is:" + listM75535d.size());
        for (Integer num : listM75535d) {
            for (String str : C12568l.m75534c(num.intValue())) {
                hashSet.add(str);
                BaseLogger.m28734i("CloudBackupV3Utils", "getTwinAppNames: the uid is: " + num, ", appId: " + str);
            }
        }
        C11839m.m70688i("CloudBackupV3Utils", "getTwinAppNames: the appTwinsSet size is:" + hashSet.size());
        if (AbstractC14026a.m84159a(list)) {
            C11839m.m70688i("CloudBackupV3Utils", "getTwinAppNames: the backupOptionItems is empty.");
            return new ArrayList(hashSet);
        }
        List list2 = (List) list.stream().filter(new Predicate() { // from class: rm.c0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C12590s0.m75796S1(hashSet, (BackupOptionItem) obj);
            }
        }).sorted(new C3765j1()).collect(Collectors.toList());
        ArrayList arrayList = new ArrayList();
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(((BackupOptionItem) it.next()).getAppId());
        }
        C11839m.m70688i("CloudBackupV3Utils", "getTwinAppNames: the twinAppIds size is:" + arrayList.size());
        return arrayList;
    }

    /* renamed from: E1 */
    public static /* synthetic */ boolean m75740E1(BackupDataAcptErrPolicy.Policy policy, PmsMeta pmsMeta) {
        return policy.getFileNames().contains(pmsMeta.getName());
    }

    /* renamed from: E2 */
    public static void m75741E2(String str, String str2, Map<String, String> map) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>(map);
        C11839m.m70686d("CloudBackupV3Utils", "reportOneModuleDiffDBStatus event: " + linkedHashMap);
        C11060c c11060cM66626a = C11058a.m66626a(str, "diff_db_status", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("113_200");
        if (map.containsKey("fileDiffTime")) {
            c11060cM66626a.m66642H(map.get("fileDiffTime"));
        }
        if (map.containsKey("originFileSize")) {
            c11060cM66626a.m66641G(map.get("originFileSize"));
        }
        c11060cM66626a.m66638D(str2);
        C13622a.m81971q(c11060cM66626a, linkedHashMap, false, true);
        C13225d.m79490f1().m79567R("cloudbackup_file_diff_db_status", linkedHashMap);
        UBAAnalyze.m29947H("CKC", "cloudbackup_file_diff_db_status", linkedHashMap);
    }

    /* renamed from: F */
    public static String m75742F(Activity activity, String str) {
        C11718b c11718b = new C11718b();
        String string = (!NavigationUtils.SMS_SCHEMA_PREF.equals(str) || m75746G(activity, str, c11718b)) ? "" : activity.getString(R$string.hicloud_permission_sms);
        if (HNConstants.DataType.CONTACT.equals(str) && !m75746G(activity, str, c11718b)) {
            string = activity.getString(R$string.hicloud_permission_contacts);
        }
        if ("calllog".equals(str) && !m75746G(activity, str, c11718b)) {
            string = activity.getString(R$string.hicloud_permission_call_log);
        }
        return (!"calendar".equals(str) || m75746G(activity, str, c11718b)) ? string : activity.getString(R$string.hicloud_permission_calendar);
    }

    /* renamed from: F0 */
    public static List<String> m75743F0(Context context, List<BackupOptionItem> list) {
        ArrayList arrayList = new ArrayList();
        for (String str : m75739E0(list)) {
            String strM75770M = m75770M(context, str);
            C11839m.m70688i("CloudBackupV3Utils", "getTwinAppNames: The appId is:" + str + ", appName is:" + strM75770M);
            if (!TextUtils.isEmpty(strM75770M)) {
                arrayList.add(context.getString(R$string.refurbish_twin_app, strM75770M));
            }
        }
        return arrayList;
    }

    /* renamed from: F1 */
    public static /* synthetic */ Double m75744F1(PmsMetaV3 pmsMetaV3) {
        return C0241z.m1683a(pmsMetaV3.getData5(), Double.valueOf(-1.0d));
    }

    /* renamed from: F2 */
    public static void m75745F2() {
        C13467g.m81086c().m81095j("refurbish_record_restore_info", "");
    }

    /* renamed from: G */
    public static boolean m75746G(Activity activity, String str, C11718b c11718b) {
        List<String> listM69903b;
        List<String> listM69911k = c11718b.m69911k("backup_" + str);
        if (listM69911k == null || listM69911k.size() <= 0 || (listM69903b = c11718b.m69903b(activity, listM69911k)) == null || listM69903b.size() <= 0) {
            return true;
        }
        C11839m.m70688i("CloudBackupV3Utils", "check permission end, module " + str + " has not permission.");
        return false;
    }

    /* renamed from: G0 */
    public static String m75747G0() {
        Context contextM1377a = C0213f.m1377a();
        boolean zM1309t1 = C0209d.m1309t1(contextM1377a);
        String strM75827a0 = m75827a0();
        String strM81079g = zM1309t1 ? C13466f.m81073d().m81079g("gradeCode", strM75827a0) : C13464d.m81030f(contextM1377a).m81039j("gradeCode", strM75827a0);
        C11839m.m70688i("CloudBackupV3Utils", "getUserGradeCode gradeCode: " + strM81079g);
        return strM81079g;
    }

    /* renamed from: G1 */
    public static /* synthetic */ Double m75748G1(String str, SnapshotBackupMeta snapshotBackupMeta) {
        return Double.valueOf(new PmsFullBriefFilesInfoOperatorV3(str).queryTarRefRatioByFileId(snapshotBackupMeta.getCloudPath()));
    }

    /* renamed from: G2 */
    public static void m75749G2() {
        C13467g.m81086c().m81095j("refurbish_record_restore_fail_info", "");
    }

    /* renamed from: H */
    public static void m75750H(C12164f c12164f, CloudBackupStatus cloudBackupStatus, C4879a c4879a) throws C9721b {
        if (!cloudBackupStatus.m29863P() || c12164f.m73082h0() <= 0) {
            return;
        }
        String strM29870d = cloudBackupStatus.m29870d();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(C12583q.m75680p(0));
        String str = File.separator;
        sb2.append(str);
        sb2.append(strM29870d);
        String strM75665a = C12583q.m75665a(C10279b.m63452a(C10278a.m63442h(sb2.toString() + str + strM29870d + ".txt")), 0, cloudBackupStatus.m29861N());
        String strM75648B = C12583q.m75648B(strM75665a);
        if (ICBUtil.hasEmojiCharacter(strM75665a)) {
            strM75665a = ICBUtil.getEncodedPath(strM75665a);
        }
        if (c12164f.m73063V(strM75665a.substring(strM75648B.length()), strM75648B) != null) {
            return;
        }
        new C9195d0(c4879a, cloudBackupStatus).m57757s("module_reset_from_app_txt_invalid");
        C11839m.m70688i("CloudBackupV3Utils", "checkTxtExist txtfile not exist in snapshot reset module " + strM29870d + ", uid: " + cloudBackupStatus.m29861N());
        throw new C9721b(FamilyShareConstants.StatusCode.SHARE_SPACE_NOT_ENOUGH, "v3 checkTxtExist error, txtFile not exist in snapshot appid: " + strM29870d + ", uid: " + cloudBackupStatus.m29861N());
    }

    /* renamed from: H0 */
    public static int m75751H0() {
        int iM81089d = C13467g.m81086c().m81089d("about_number_of_backup_record", CloudBackupConstant.UserPackageInfo.VIP_BACKUP_RECORDS.intValue());
        C11839m.m70688i("CloudBackupV3Utils", "getUserRecordNum aboutNums = " + iM81089d);
        return iM81089d;
    }

    /* renamed from: H1 */
    public static /* synthetic */ Double m75752H1(String str, C12161c c12161c) {
        return Double.valueOf(new PmsFullBriefFilesInfoOperatorV3(str).queryTarRefRatioByFileId(c12161c.m72984h()));
    }

    /* renamed from: H2 */
    public static void m75753H2(String str, CloudBackupAppDataUtil cloudBackupAppDataUtil, int i10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (cloudBackupAppDataUtil == null) {
            return;
        }
        AppInfoList appFileInfoList = cloudBackupAppDataUtil.getAppFileInfoList();
        if (appFileInfoList != null) {
            String wakeUpService = appFileInfoList.getCloudBackup().getWakeUpService();
            C11839m.m70686d("CloudBackupV3Utils", "mactch successfully on appId" + str + "with wakeUpService is" + wakeUpService);
            if (!TextUtils.isEmpty(wakeUpService)) {
                m75825Z2(str, wakeUpService, i10);
                return;
            }
        }
        if (C14333b.m85458N().containsKey(str)) {
            String str2 = C14333b.m85458N().get(str);
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            m75825Z2(str, str2, i10);
        }
    }

    /* renamed from: I */
    public static void m75754I(String str, int i10) {
        try {
            C11839m.m70686d("CloudBackupV3Utils", "clearFastCopyFileCache delete = " + C11835i.m70643g(C12583q.m75658L(str, i10)) + ", appId = " + str + ", uid = " + i10);
        } catch (Exception e10) {
            C11839m.m70686d("CloudBackupV3Utils", "clearFastCopyFileCache exception:" + e10);
        }
    }

    /* renamed from: I0 */
    public static void m75755I0(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            C11839m.m70687e("CloudBackupV3Utils", "handleClickLink host is null");
            return;
        }
        String string = context.getString(R$string.backup_read_support);
        C11839m.m70686d("CloudBackupV3Utils", "handleClickBackupLink requestUri: " + str);
        m75736D1(context, str, string);
        C13225d.m79490f1().m79585f0("mecloud_backupmain_click_supported_data", C13452e.m80781L().m80971t0());
        UBAAnalyze.m29954O("PVC", "mecloud_backupmain_click_supported_data", "1", "41");
    }

    /* renamed from: I1 */
    public static /* synthetic */ Double m75756I1(String str, C12161c c12161c) {
        return Double.valueOf(new PmsFullBriefFilesInfoOperatorV3(str).queryTarRefRatioByFileId(c12161c.m73009x()));
    }

    /* renamed from: I2 */
    public static int m75757I2(CloudRestoreItem cloudRestoreItem, CloudRestoreItem cloudRestoreItem2) {
        if ("sysdata".equals(cloudRestoreItem.getAppId())) {
            if (cloudRestoreItem.getType() == 2 || cloudRestoreItem.getType() == 0) {
                return -1;
            }
        } else if ("sysdata".equals(cloudRestoreItem2.getAppId()) && (cloudRestoreItem2.getType() == 2 || cloudRestoreItem2.getType() == 0)) {
            return 1;
        }
        if (cloudRestoreItem.getStatus() < cloudRestoreItem2.getStatus()) {
            return -1;
        }
        if (cloudRestoreItem.getStatus() > cloudRestoreItem2.getStatus()) {
            return 1;
        }
        if ((cloudRestoreItem.getStatus() == 1 && cloudRestoreItem2.getStatus() == 1) || cloudRestoreItem.getType() == cloudRestoreItem2.getType()) {
            return 0;
        }
        if (cloudRestoreItem.getType() == 2) {
            return -1;
        }
        return cloudRestoreItem2.getType() == 2 ? 1 : 0;
    }

    /* renamed from: J */
    public static String m75758J(C12161c c12161c, CloudRestoreStatusV3 cloudRestoreStatusV3, boolean z10, String str) throws C9721b {
        String strM75660N;
        String strM73011z = c12161c.m73011z();
        if (m75909u1(strM73011z)) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "download file local path is null.");
        }
        String appId = cloudRestoreStatusV3.getAppId();
        if (z10) {
            if (!"com.huawei.hmos.filemanager".equals(appId)) {
                String strM81946b = C13619c.m81946b(str, strM73011z, appId);
                C11839m.m70688i("CloudBackupV3Utils", "path destination: " + strM81946b + ", appId: " + appId);
                return strM81946b;
            }
            if (!strM73011z.startsWith("storage/Users/currentUser")) {
                String strM81946b2 = C13619c.m81946b(str, strM73011z, appId);
                C11839m.m70688i("CloudBackupV3Utils", "fileManager common destination: " + strM81946b2);
                return strM81946b2;
            }
            String strM75986s = C12593t0.m75986s(strM73011z, cloudRestoreStatusV3);
            C11839m.m70688i("CloudBackupV3Utils", "fileManager destination: " + strM75986s);
            m75842d2(strM75986s, false);
            return strM75986s;
        }
        if (c12161c.m72980f() == 1) {
            strM73011z = ICBUtil.getDecodedPath(strM73011z);
        }
        if (m75909u1(strM73011z)) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "download file local path is null.");
        }
        if (!cloudRestoreStatusV3.isTwinApp() || c12161c.m72950F().startsWith(ICBUtil.RELATIVE_SDATA_PATH)) {
            strM75660N = C12583q.m75660N(strM73011z, 1, appId, cloudRestoreStatusV3.getUid());
            if (cloudRestoreStatusV3.is3rdAppType()) {
                strM75660N = C12583q.m75664R(strM75660N, appId, cloudRestoreStatusV3.getUid());
            } else if ("safebox".equals(appId)) {
                strM75660N = ICBUtil.tranSpecialPath(strM75660N, appId);
            }
        } else {
            C11839m.m70686d("CloudBackupV3Utils", "prefix: /external/Android ,before destination: " + strM73011z);
            if (PmsCheckUtil.m12611e() && strM73011z.startsWith("/external/Android")) {
                String strM75678n = C12583q.m75678n(appId, cloudRestoreStatusV3.getUid());
                if (m75909u1(strM75678n)) {
                    throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "temp path androidDataCachePath is null.");
                }
                strM75660N = strM75678n + strM73011z.replaceFirst("/external/Android", "");
            } else {
                String strM75679o = C12583q.m75679o(appId, cloudRestoreStatusV3.getUid());
                if (m75909u1(strM75679o)) {
                    throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "twinAppRestoreTempPath temp path is null.");
                }
                strM75660N = strM75679o + strM73011z.replaceFirst("/external", "");
            }
            C11839m.m70686d("CloudBackupV3Utils", "prefix: /external/Android ,after destination: " + strM75660N);
        }
        if (m75909u1(strM75660N)) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "download file local path is null.");
        }
        m75842d2(strM75660N, true);
        return strM75660N;
    }

    /* renamed from: J0 */
    public static void m75759J0(CloudSpace cloudSpace, C13029h c13029h, Context context, boolean z10, long j10, boolean z11, String str) throws C9721b {
        StringBuilder sb2 = new StringBuilder("cloud space not enough. ");
        try {
            long total = cloudSpace.getTotal();
            long total2 = cloudSpace.getTotal() - cloudSpace.getUsed();
            long jM1688f = 0;
            if (total2 < 0) {
                total2 = 0;
            }
            long used = cloudSpace.getUsed();
            if (c13029h != null) {
                jM1688f = C0241z.m1688f(c13029h.m78482u());
            }
            if (c13029h != null) {
                c13029h.m78481t0(total);
                c13029h.m78485v0(used);
                c13029h.m78456V(String.valueOf(jM1688f));
                new C13030i().m78496g(c13029h);
            }
            LinkedHashMap<String, String> linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
            linkedHashMapM79499C.put("backupId", c13029h == null ? "" : c13029h.m78465h());
            linkedHashMapM79499C.put("deviceId", C13452e.m80781L().m80954p());
            linkedHashMapM79499C.put("available", String.valueOf(total2));
            linkedHashMapM79499C.put("totalsize", String.valueOf(jM1688f));
            C11839m.m70688i("CloudBackupV3Utils", "report space not enough");
            C13225d.m79490f1().m79603z0("cloudbackup_space_not_enough", linkedHashMapM79499C);
            new SettingOperator().replace(new Settings[]{new Settings("nextbackuptime", String.valueOf(86400000L), "2")});
            BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData = new BackupSpaceNotEnoughNeedData();
            backupSpaceNotEnoughNeedData.setTotalNeedSpace(used + jM1688f);
            backupSpaceNotEnoughNeedData.setBackupNeedSpace(jM1688f);
            backupSpaceNotEnoughNeedData.setNotUsedSpace(total2);
            backupSpaceNotEnoughNeedData.setTotalSpace(total);
            backupSpaceNotEnoughNeedData.setUsedSpace(used);
            backupSpaceNotEnoughNeedData.setGalleryNum(j10);
            if (z11) {
                UserSpaceUtil.sendSpaceNotEnough(z10, backupSpaceNotEnoughNeedData);
            }
            sb2.append("CloudTotalSpace = ");
            sb2.append(total);
            sb2.append(" CloudUsedSpace = ");
            sb2.append(used);
            sb2.append(" current backup size = ");
            sb2.append(jM1688f);
            C11839m.m70689w("CloudBackupV3Utils", sb2.toString());
            C0237v.m1661c();
        } catch (Throwable th2) {
            C11839m.m70689w("CloudBackupV3Utils", "<handleNoSpace> error: " + th2.getMessage());
            m75930z2(th2.getMessage());
        }
        throw new C9721b(str, SNSCode.Status.HWID_UNLOGIN, sb2.toString(), "prepare failed because no enough remaining space");
    }

    /* renamed from: J1 */
    public static /* synthetic */ boolean m75760J1(CloudBackupStatus cloudBackupStatus) {
        return "0".equals(cloudBackupStatus.m29381V0()) || TextUtils.isEmpty(cloudBackupStatus.m29381V0());
    }

    /* renamed from: J2 */
    public static void m75761J2(RefurbishRestoreFailInfo refurbishRestoreFailInfo) {
        try {
            C13467g.m81086c().m81095j("refurbish_record_restore_fail_info", new Gson().toJson(refurbishRestoreFailInfo));
        } catch (Exception e10) {
            C11839m.m70687e("CloudBackupV3Utils", "saveRefurbishRestoreFailInfo error: " + e10);
        }
    }

    /* renamed from: K */
    public static boolean m75762K(String str, List<PmsMeta> list, List<PmsMeta> list2, CloudBackupAppDataUtil cloudBackupAppDataUtil) {
        ArrayList<PmsMeta> arrayList;
        boolean zMatches;
        try {
            arrayList = new ArrayList();
            arrayList.addAll(list);
            arrayList.addAll(list2);
        } catch (Exception e10) {
            C11839m.m70689w("CloudBackupV3Utils", "isDiffFileName  ,appId = " + str + " e = " + e10.getMessage());
        }
        if (arrayList.isEmpty()) {
            C11839m.m70688i("CloudBackupV3Utils", "isDiffFileName , pmsMetaList.isEmpty()");
            return false;
        }
        if (cloudBackupAppDataUtil != null && !str.isEmpty()) {
            AppInfoList appFileInfoList = cloudBackupAppDataUtil.getAppFileInfoList();
            if (appFileInfoList == null) {
                C11839m.m70688i("CloudBackupV3Utils", "isDiffFileName , appInfo == null");
                return false;
            }
            CloudBackup cloudBackup = appFileInfoList.getCloudBackup();
            if (cloudBackup == null) {
                C11839m.m70688i("CloudBackupV3Utils", "isDiffFileName , cloudBackup == null");
                return false;
            }
            String dBDiffDBFileName = cloudBackup.getDBDiffDBFileName();
            if (TextUtils.isEmpty(dBDiffDBFileName)) {
                C11839m.m70688i("CloudBackupV3Utils", "isDiffFileName , dbDiffDBFileName == null or isEmpty");
                return false;
            }
            C12526j c12526j = new C12526j();
            for (PmsMeta pmsMeta : arrayList) {
                if (pmsMeta != null) {
                    String data = pmsMeta.getData();
                    if (data.startsWith("data/")) {
                        long size = pmsMeta.getSize();
                        if (size < c12526j.m75362T() * 1048576) {
                            C11839m.m70686d("CloudBackupV3Utils", "isDiffFileName , fileSize < DbIncrBack");
                        } else if (size > c12526j.m75352O() * 1048576) {
                            C11839m.m70686d("CloudBackupV3Utils", "isDiffFileName , fileSize > DBDiffMaxFileSize");
                        } else {
                            String name = pmsMeta.getName();
                            try {
                                zMatches = Pattern.matches(dBDiffDBFileName, name);
                            } catch (PatternSyntaxException e11) {
                                C11839m.m70687e("CloudBackupV3Utils", "isDiffFileName pattern syntax exception: " + e11.getMessage());
                                zMatches = false;
                            }
                            C11839m.m70688i("CloudBackupV3Utils", "isDiffFileName ,regexMatch = " + zMatches + " ,appId : " + str + ",fileName: " + name);
                            if (zMatches) {
                                return true;
                            }
                        }
                    } else {
                        C11839m.m70686d("CloudBackupV3Utils", "isDiffFileName , not match sdata , current = " + data);
                    }
                }
            }
            return false;
        }
        C11839m.m70688i("CloudBackupV3Utils", "isDiffFileName , appDataUtil == null || appid.isEmpty()");
        return false;
    }

    /* renamed from: K0 */
    public static void m75763K0(Map<String, CloudRestoreItem> map, CloudRestoreItem cloudRestoreItem, String str) {
        List<CloudRestoreItem> listM29202r = cloudRestoreItem.m29202r();
        if (listM29202r == null || listM29202r.size() == 0) {
            C11839m.m70686d("CloudBackupV3Utils", "child list is null return: " + str);
            return;
        }
        for (CloudRestoreItem cloudRestoreItem2 : listM29202r) {
            if (cloudRestoreItem2 != null) {
                map.put(cloudRestoreItem2.getAppId(), cloudRestoreItem2);
                C11839m.m70686d("CloudBackupV3Utils", "init last record appId: " + cloudRestoreItem2.getAppId() + " , size: " + cloudRestoreItem2.getSize() + ", count: " + cloudRestoreItem2.getCount());
            }
        }
    }

    /* renamed from: K1 */
    public static /* synthetic */ boolean m75764K1(CloudBackupStatus cloudBackupStatus) {
        return "2".equals(cloudBackupStatus.m29381V0());
    }

    /* renamed from: K2 */
    public static void m75765K2(RefurbishRestoreInfo refurbishRestoreInfo) {
        try {
            C13467g.m81086c().m81095j("refurbish_record_restore_info", new Gson().toJson(refurbishRestoreInfo));
        } catch (Exception e10) {
            C11839m.m70687e("CloudBackupV3Utils", "saveRefurbishRestoreInfo error: " + e10);
        }
    }

    /* renamed from: L */
    public static File m75766L(CloudBackupStatus cloudBackupStatus, String str) throws C9721b {
        String strMo29421n = cloudBackupStatus.mo29421n();
        String strM29870d = cloudBackupStatus.m29870d();
        int iM29861N = cloudBackupStatus.m29861N();
        File fileM63443i = C10278a.m63443i(str + File.separator + strM29870d, strM29870d + ".apk");
        m75870k2(strM29870d, iM29861N, strMo29421n, str, fileM63443i);
        boolean z10 = false;
        boolean z11 = fileM63443i.exists() && fileM63443i.length() > 0;
        String bundleBackupDirPath = ICBUtil.getBundleBackupDirPath(str, strM29870d);
        File[] fileArrM63440f = C10278a.m63440f(C10278a.m63442h(bundleBackupDirPath));
        boolean z12 = C10278a.m63443i(bundleBackupDirPath, "base.apk").exists() || (fileArrM63440f != null && fileArrM63440f.length > 0);
        String harmonyBackupDirPath = ICBUtil.getHarmonyBackupDirPath(str, strM29870d);
        File[] fileArrM63440f2 = C10278a.m63440f(C10278a.m63442h(harmonyBackupDirPath));
        if (fileArrM63440f2 != null && fileArrM63440f2.length > 0) {
            z10 = true;
        }
        m75726B(strM29870d, z11, z12, z10);
        return z12 ? m75793R2(cloudBackupStatus, bundleBackupDirPath, fileArrM63440f) : z10 ? m75793R2(cloudBackupStatus, harmonyBackupDirPath, fileArrM63440f2) : fileM63443i;
    }

    /* renamed from: L0 */
    public static boolean m75767L0(CloudBackupStatus cloudBackupStatus) {
        if (!cloudBackupStatus.m29863P() || cloudBackupStatus.m29351H0() != 0 || cloudBackupStatus.m29877l() > 0) {
            return true;
        }
        C11839m.m70688i("CloudBackupV3Utils", "appId: " + cloudBackupStatus.m29870d() + ", has snapshot: false, , dataFlag: " + cloudBackupStatus.m29351H0() + ", count: " + cloudBackupStatus.m29877l());
        return false;
    }

    /* renamed from: L1 */
    public static /* synthetic */ boolean m75768L1(CloudBackupStatus cloudBackupStatus) {
        return "1".equals(cloudBackupStatus.m29381V0());
    }

    /* renamed from: L2 */
    public static void m75769L2(String str, List<C11723d> list, Integer num) {
        C11723d c11723d = new C11723d();
        c11723d.m69948c(str);
        c11723d.m69949d(num);
        if (list.contains(c11723d)) {
            return;
        }
        list.add(c11723d);
    }

    /* renamed from: M */
    public static String m75770M(Context context, String str) {
        return m75774N(context, str, null);
    }

    /* renamed from: M0 */
    public static void m75771M0(String str) {
        C11839m.m70688i("CloudBackupV3Utils", str + ": start initBackupActiveTime");
        if (0 == C13466f.m81073d().m81078f("backup_key_active_time", 0L)) {
            boolean zM62388s = C10028c.m62182c0().m62388s("backup_key");
            C11839m.m70688i("CloudBackupV3Utils", str + ": initBackupActiveTime, The backup switch is:" + zM62388s);
            if (zM62388s) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                C11839m.m70688i("CloudBackupV3Utils", "initBackupActiveTime, the active time is:" + jCurrentTimeMillis);
                C13466f.m81073d().m81083k("backup_key_active_time", jCurrentTimeMillis);
            }
        }
    }

    /* renamed from: M1 */
    public static /* synthetic */ boolean m75772M1(List list, List list2, BackupOptionItem backupOptionItem) {
        return !backupOptionItem.getBackupSwitch() || list.contains(backupOptionItem.getAppId()) || list2.contains(backupOptionItem.getAppId());
    }

    /* renamed from: M2 */
    public static void m75773M2(long j10) {
        f57971d = j10;
    }

    /* renamed from: N */
    public static String m75774N(Context context, String str, String str2) {
        String strM16079E = C2783d.m16079E(context, str);
        if (!TextUtils.isEmpty(strM16079E)) {
            return strM16079E;
        }
        String strM25632b = NewHiSyncUtil.m25632b(str);
        if (!TextUtils.isEmpty(strM25632b)) {
            return strM25632b;
        }
        String virtualName = CloudBackupLanguageUtil.getVirtualName(str);
        return (!TextUtils.isEmpty(virtualName) || TextUtils.isEmpty(str2)) ? virtualName : str2;
    }

    /* renamed from: N0 */
    public static void m75775N0(CloudRecoveryItem cloudRecoveryItem, Map<String, CloudRestoreItem> map) {
        if (cloudRecoveryItem == null) {
            C11839m.m70688i("CloudBackupV3Utils", "last success record is null.");
            return;
        }
        List<CloudRestoreItem> itemList = cloudRecoveryItem.getItemList();
        if (itemList == null) {
            return;
        }
        m75821Y2("sysdata", itemList, map);
        m75821Y2("thirdAppData", itemList, map);
        for (CloudRestoreItem cloudRestoreItem : itemList) {
            if (cloudRestoreItem != null) {
                String appId = cloudRestoreItem.getAppId();
                if (NavigationUtils.SMS_SCHEMA_PREF.equals(appId) || "soundrecorder".equals(appId)) {
                    m75763K0(map, cloudRestoreItem, appId);
                } else if (!"sysdata".equals(appId) && !"thirdAppData".equals(appId)) {
                    map.put(appId, cloudRestoreItem);
                    C11839m.m70686d("CloudBackupV3Utils", "init last record appId: " + appId + " , size: " + cloudRestoreItem.getSize() + ", count: " + cloudRestoreItem.getCount());
                }
            }
        }
    }

    /* renamed from: N1 */
    public static /* synthetic */ boolean m75776N1(ICycleChecker iCycleChecker) {
        return !"1".equals(iCycleChecker.getType());
    }

    /* renamed from: N2 */
    public static void m75777N2(long j10) {
        f57970c = j10;
        C11839m.m70688i("CloudBackupV3Utils", "setNeedLocalSpace: " + j10);
    }

    /* renamed from: O */
    public static int m75778O(CloudBackupStatus cloudBackupStatus) {
        if (cloudBackupStatus == null) {
            return 0;
        }
        String strM29377T0 = cloudBackupStatus.m29377T0();
        if (TextUtils.isEmpty(strM29377T0)) {
            return 0;
        }
        return C0241z.m1686d(strM29377T0, 0);
    }

    /* renamed from: O0 */
    public static List<String> m75779O0() {
        SyncAppBackupPolicy syncAppBackupPolicy;
        Integer num;
        ArrayList arrayList = new ArrayList();
        if (!C9733f.m60705z().m60720O("cloudBackupSyncAppExclusive")) {
            C11839m.m70688i("CloudBackupV3Utils", "The sync app exclusive support is false");
            return arrayList;
        }
        Map<String, SyncAppBackupPolicy> mapM76029e = C12597u1.m76029e();
        Map<String, Integer> mapM76030f = C12597u1.m76030f();
        Iterator<BackupOptionItem> it = new BackupModuleInfoQueryLogic(false, BackupModuleInfoQueryLogic.BackupType.STANDARD, false, "CloudBackupV3Utils").getAppOptionInfo().getSystemItemList().iterator();
        while (it.hasNext()) {
            String appId = it.next().getAppId();
            if (mapM76029e.containsKey(appId) && (syncAppBackupPolicy = mapM76029e.get(appId)) != null) {
                String syncAppName = syncAppBackupPolicy.getSyncAppName();
                if (syncAppBackupPolicy.getPolicy() == 1 && (num = mapM76030f.get(syncAppName)) != null && 1 == num.intValue()) {
                    C11839m.m70688i("CloudBackupV3Utils", "skip appId: " + appId + ", syncAppName: " + syncAppName + " status is open");
                    arrayList.add(appId);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: O1 */
    public static /* synthetic */ boolean m75780O1(BackupOptionItem backupOptionItem) {
        return !backupOptionItem.getBackupSwitch();
    }

    /* renamed from: O2 */
    public static void m75781O2(PmsMetaV3 pmsMetaV3, File file) throws C9721b {
        Md5AndHash md5AndHashM68622d = C11476b.m68622d(file);
        String md5 = md5AndHashM68622d.getMD5();
        String hash = md5AndHashM68622d.getHash();
        pmsMetaV3.setHash1(md5);
        pmsMetaV3.setHash2(hash);
        pmsMetaV3.setCloudHash(hash);
    }

    /* renamed from: P */
    public static int m75782P(boolean z10) {
        if (!C13452e.m80781L().m80887a1() || z10) {
            return 0;
        }
        List<CloudBackupStatus> listM76930i = new C12815f().m76930i();
        if (listM76930i.stream().anyMatch(new Predicate() { // from class: rm.q0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C12590s0.m75760J1((CloudBackupStatus) obj);
            }
        })) {
            C11839m.m70688i("CloudBackupV3Utils", "getBackupBmType exist module is old bm type");
            return 0;
        }
        boolean zAnyMatch = listM76930i.stream().anyMatch(new Predicate() { // from class: rm.r0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C12590s0.m75764K1((CloudBackupStatus) obj);
            }
        });
        boolean zAnyMatch2 = listM76930i.stream().anyMatch(new Predicate() { // from class: rm.a0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C12590s0.m75768L1((CloudBackupStatus) obj);
            }
        });
        C11839m.m70688i("CloudBackupV3Utils", "getBackupBmType hasBaseData: " + zAnyMatch2 + " ,hasFullData: " + zAnyMatch);
        if (zAnyMatch && zAnyMatch2) {
            return 2;
        }
        return zAnyMatch ? 3 : 1;
    }

    /* renamed from: P0 */
    public static boolean m75783P0(Map<String, String> map) {
        if (map == null || map.isEmpty() || C0241z.m1688f(map.get("apksize")) <= 0) {
            return false;
        }
        return String.valueOf(1).equalsIgnoreCase(map.get("appwithdata"));
    }

    /* renamed from: P1 */
    public static /* synthetic */ boolean m75784P1(BackupOptionItem backupOptionItem, String str) {
        return TextUtils.equals(backupOptionItem.getAppId(), str);
    }

    /* renamed from: P2 */
    public static void m75785P2(PmsMetaV3 pmsMetaV3, FileInputStream fileInputStream) throws Throwable {
        Md5AndHash md5AndHashM68624f = C11476b.m68624f(fileInputStream, "");
        String md5 = md5AndHashM68624f.getMD5();
        String hash = md5AndHashM68624f.getHash();
        pmsMetaV3.setHash1(md5);
        pmsMetaV3.setHash2(hash);
        pmsMetaV3.setCloudHash(hash);
    }

    /* renamed from: Q */
    public static String m75786Q(C13029h c13029h) {
        if (c13029h == null || TextUtils.isEmpty(c13029h.m78488y())) {
            return "";
        }
        String strM78488y = c13029h.m78488y();
        return strM78488y.startsWith("V3_") ? strM78488y.replaceFirst("V3_", "") : strM78488y;
    }

    /* renamed from: Q0 */
    public static boolean m75787Q0(Map<String, String> map) {
        if (map == null || map.isEmpty() || C0241z.m1688f(map.get("apksize")) <= 0) {
            return false;
        }
        return String.valueOf(0).equalsIgnoreCase(map.getOrDefault("appwithdata", String.valueOf(0)));
    }

    /* renamed from: Q1 */
    public static /* synthetic */ boolean m75788Q1(List list, final BackupOptionItem backupOptionItem) {
        return list.stream().anyMatch(new Predicate() { // from class: rm.i0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C12590s0.m75784P1(backupOptionItem, (String) obj);
            }
        });
    }

    /* renamed from: Q2 */
    public static void m75789Q2(PmsMetaV3 pmsMetaV3, C9215i0 c9215i0) {
        if (c9215i0 == null || c9215i0.m57870T() == null || pmsMetaV3 == null) {
            return;
        }
        long jM1688f = C0241z.m1688f(c9215i0.m57870T().get("fileSizeExistInLastRecordByHash"));
        long jM1688f2 = C0241z.m1688f(c9215i0.m57870T().get("fileCountExistInLastRecordByHash"));
        c9215i0.m57870T().put("fileSizeExistInLastRecordByHash", String.valueOf(jM1688f + pmsMetaV3.getSize()));
        c9215i0.m57870T().put("fileCountExistInLastRecordByHash", String.valueOf(jM1688f2 + 1));
        C11839m.m70686d("CloudBackupV3Utils", "statisticFileExistLastBackupRecord:" + pmsMetaV3);
    }

    /* renamed from: R */
    public static String m75790R(String str) {
        String str2 = C14333b.f63651c.get(str);
        if (TextUtils.isEmpty(str2)) {
            C11839m.m70689w("CloudBackupV3Utils", "getBackupSystemVersion , appId " + str + " , pkgName is empty");
            str2 = str;
        }
        String strM1680b = C0240y.m1680b(C0213f.m1377a(), str2);
        C11839m.m70688i("CloudBackupV3Utils", "getBackupSystemVersion , appId " + str + " , pkgName = " + str2 + " , systemAppVerison = " + strM1680b);
        return strM1680b;
    }

    /* renamed from: R0 */
    public static boolean m75791R0() {
        if (!"2".equals(new SettingOperator().queryUploadTargetStrategy())) {
            C11839m.m70688i("CloudBackupV3Utils", "is3rdFullBackup uploadTargetStrategy not v3 return");
            return false;
        }
        List<AppInfoList> listM75302m = new C12519c().m75302m();
        if (listM75302m.size() <= 0) {
            C11839m.m70688i("CloudBackupV3Utils", "defaultInfoList is empty and is3rdFullBackup false");
            return false;
        }
        for (AppInfoList appInfoList : listM75302m) {
            if (appInfoList != null) {
                String osVersRegex = appInfoList.getCloudBackup().getOsVersRegex();
                int minClientVersion = appInfoList.getMinClientVersion();
                List<String> effectDevice = appInfoList.getCloudBackup().getEffectDevice();
                List<String> effectPackage = appInfoList.getCloudBackup().getEffectPackage();
                if (C12585q1.m75705o(osVersRegex) && C12585q1.m75700j(minClientVersion) && C12585q1.m75701k(effectDevice) && C12585q1.m75702l(effectPackage)) {
                    C11839m.m70688i("CloudBackupV3Utils", "is3rdFullBackup is3rdFullBackup true");
                    return true;
                }
            }
        }
        C11839m.m70688i("CloudBackupV3Utils", "is3rdFullBackup is3rdFullBackup false");
        return false;
    }

    /* renamed from: R1 */
    public static /* synthetic */ boolean m75792R1(BackupOptionItem backupOptionItem, String str) {
        return TextUtils.equals(backupOptionItem.getAppId(), str);
    }

    /* renamed from: R2 */
    public static File m75793R2(CloudBackupStatus cloudBackupStatus, String str, File[] fileArr) throws C9721b {
        String strM29870d = cloudBackupStatus.m29870d();
        HashSet hashSet = new HashSet();
        hashSet.add(str);
        File[] fileArrM75514h = C12559i.m75514h(fileArr, cloudBackupStatus, new Consumer() { // from class: rm.l0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                C12590s0.m75918w2((CloudBackupStatus) obj);
            }
        });
        TarFileUtil tarFileUtil = new TarFileUtil(hashSet, true);
        File fileM63442h = C10278a.m63442h(str + "/" + strM29870d + ".apk");
        ArrayList<File> arrayList = new ArrayList();
        try {
            for (File file : fileArrM75514h) {
                if (file != null && file.length() > 0) {
                    tarFileUtil.tarFile(fileM63442h, file);
                    arrayList.add(file);
                }
            }
            File fileEndCurrentTar = tarFileUtil.endCurrentTar(fileM63442h);
            tarFileUtil.closeTarStream();
            if (arrayList.isEmpty()) {
                throw new C9721b(2005, "tar apk error files size all zero. " + strM29870d);
            }
            boolean z10 = fileEndCurrentTar != null && fileEndCurrentTar.exists();
            if (!z10 || !fileEndCurrentTar.renameTo(fileM63442h)) {
                throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "tar apk error exists: " + z10 + " ,appId: " + strM29870d);
            }
            C11839m.m70688i("CloudBackupV3Utils", "tar end ");
            for (File file2 : arrayList) {
                if (!file2.delete()) {
                    throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "delete origin apk error: " + file2.getName() + " ,appId: " + strM29870d);
                }
            }
            C11839m.m70688i("CloudBackupV3Utils", "tarBundleApk delete origin apk end appId: " + strM29870d + " ,apk length: " + fileM63442h.length());
            return fileM63442h;
        } catch (Throwable th2) {
            tarFileUtil.closeTarStream();
            throw th2;
        }
    }

    /* renamed from: S */
    public static long m75794S() {
        if (BackupNewBmTypeUtil.isNewBmUserBackupOnlyBaseData()) {
            C11839m.m70688i("CloudBackupV3Utils", "getBakSizeExcludeSync only backup base data.");
            return m75927z(true, m75868k0()).m69963a();
        }
        if (m75853g1()) {
            C11839m.m70688i("CloudBackupV3Utils", "getBakSizeExcludeSync isNewBmPaidUserOnlyBackupFullData.");
            List<String> listM73271n = C12176c.m73271n(null);
            List<String> listM76026b = C12597u1.m76026b();
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(listM73271n);
            arrayList.addAll(listM76026b);
            return m75927z(true, arrayList).m69963a();
        }
        C11839m.m70688i("CloudBackupV3Utils", "getBakSizeExcludeSync backup not only base data.");
        C11726g c11726gM75923y = m75923y(true);
        List<String> listM75779O0 = m75779O0();
        C13026e c13026e = new C13026e();
        for (String str : listM75779O0) {
            BackupOptionItem backupOptionItemM78401y = c13026e.m78401y(str);
            if (backupOptionItemM78401y != null) {
                c11726gM75923y.m69965c(c11726gM75923y.m69963a() - backupOptionItemM78401y.getTotalIncrease());
                C11839m.m70688i("CloudBackupV3Utils", "skip sync exclusive app: " + str + ", size: " + backupOptionItemM78401y.getTotalIncrease());
            }
        }
        return c11726gM75923y.m69963a();
    }

    /* renamed from: S0 */
    public static boolean m75795S0() {
        return m75799T0(C13452e.m80781L().m80790C());
    }

    /* renamed from: S1 */
    public static /* synthetic */ boolean m75796S1(Set set, final BackupOptionItem backupOptionItem) {
        return set.stream().anyMatch(new Predicate() { // from class: rm.h0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C12590s0.m75792R1(backupOptionItem, (String) obj);
            }
        });
    }

    /* renamed from: S2 */
    public static String m75797S2(String str, String str2, int i10, String str3, String str4) {
        return m75917w1(str, i10, str3, str4) ? C12586r.m75716g(str, str2, i10, str3) : str3;
    }

    /* renamed from: T */
    public static int m75798T() {
        int iM81089d = C13467g.m81086c().m81089d("about_number_of_base_backup_record", CloudBackupConstant.UserPackageInfo.NORMAL_BACKUP_RECORDS.intValue());
        C11839m.m70688i("CloudBackupV3Utils", "getBaseRecordNum = " + iM81089d);
        return iM81089d;
    }

    /* renamed from: T0 */
    public static boolean m75799T0(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return CloudBackupConstant.UserPackageInfo.FULL_DATA_SERVICE_50GB.equalsIgnoreCase(str) || CloudBackupConstant.UserPackageInfo.SILVER_MEMBER.equalsIgnoreCase(str);
    }

    /* renamed from: T1 */
    public static /* synthetic */ Object m75800T1() throws Exception {
        return Long.valueOf(new C12526j().m75373Y0() * ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS);
    }

    /* renamed from: T2 */
    public static String m75801T2(String str, String str2, int i10, String str3, String str4) {
        return m75877m1(str2, i10, str3, str4) ? C12586r.m75715f(str, str2, i10, str4) : str4;
    }

    /* renamed from: U */
    public static String m75802U(Context context, int i10) {
        if (i10 == 3001) {
            return context.getString(R$string.cloud_space_insufficient);
        }
        if (C14339h.m85514m().contains(Integer.valueOf(i10))) {
            return context.getString(R$string.backup_failed_network_tip);
        }
        if (i10 == 1006) {
            return context.getString(R$string.auto_bright_screen_tips);
        }
        if (i10 == 1001 || i10 == 0) {
            return null;
        }
        return i10 == 1030 ? context.getString(R$string.backup_battery_temperature_high) : context.getString(R$string.backup_conditions_not_met);
    }

    /* renamed from: U0 */
    public static boolean m75803U0(String str, Context context) throws PackageManager.NameNotFoundException {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            C11839m.m70686d("CloudBackupV3Utils", "package version = " + context.getPackageManager().getPackageInfo(str, 16384).versionName + " appId = " + str);
            return true;
        } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
            return false;
        }
    }

    /* renamed from: U1 */
    public static /* synthetic */ Object m75804U1() throws Exception {
        return Long.valueOf(C12588r1.m75718c().m75721d());
    }

    /* renamed from: U2 */
    public static boolean m75805U2(String str, String str2) {
        try {
            return C11843q.m70898f(str, str2, 53687091200L, Integer.MAX_VALUE, true);
        } catch (C1413j e10) {
            C11839m.m70687e("CloudBackupV3Utils", "unzipFile: " + str + " error: " + e10.getMessage());
            return false;
        }
    }

    /* renamed from: V */
    public static String m75806V(Throwable th2, int i10, boolean z10) {
        StringBuilder sb2 = new StringBuilder();
        StackTraceElement[] stackTrace = th2.getStackTrace();
        if (stackTrace == null) {
            return "";
        }
        try {
            int i11 = 0;
            for (StackTraceElement stackTraceElement : stackTrace) {
                String methodName = stackTraceElement.getMethodName();
                String className = stackTraceElement.getClassName();
                int lineNumber = stackTraceElement.getLineNumber();
                if (className != null) {
                    if (!z10) {
                        sb2.append(className);
                        sb2.append(".");
                        sb2.append(methodName);
                        sb2.append(".");
                        sb2.append(lineNumber);
                        sb2.append("; ");
                        i11++;
                        if (i11 >= i10) {
                            break;
                        }
                    } else if (className.startsWith("com.huawei.hicloud.cloudbackup") || className.startsWith("com.huawei.android.hicloud.cloudbackup")) {
                        sb2.append(className.replaceFirst("com.huawei.hicloud.cloudbackup", "").replaceFirst("com.huawei.android.hicloud.cloudbackup", ""));
                        sb2.append(".");
                        sb2.append(methodName);
                        sb2.append(".");
                        sb2.append(lineNumber);
                        sb2.append("; ");
                        i11++;
                        if (i11 >= i10) {
                            break;
                        }
                    }
                }
            }
        } catch (Exception e10) {
            C11839m.m70687e("CloudBackupV3Utils", "getStackTrace error: " + th2.getMessage());
            sb2.append(" getStackTrace error:");
            sb2.append(e10.getMessage());
        }
        return sb2.toString();
    }

    /* renamed from: V0 */
    public static boolean m75807V0(String str) {
        if (TextUtils.isEmpty(str)) {
            C11839m.m70688i("CloudBackupV3Utils", "The deeplink is empty.");
            return false;
        }
        String strM75348M = new C12526j().m75348M("cloudBackupSpaceInsufficientSupportDeeplink");
        if (TextUtils.isEmpty(strM75348M) || C0241z.m1686d(strM75348M, 1) == 1) {
            return true;
        }
        C11839m.m70688i("CloudBackupV3Utils", "The support deeplink feature is close.");
        return false;
    }

    /* renamed from: V1 */
    public static /* synthetic */ boolean m75808V1(List list, List list2, BackupOptionItem backupOptionItem) {
        return !backupOptionItem.getBackupSwitch() || list.contains(backupOptionItem.getAppId()) || list2.contains(backupOptionItem.getAppId());
    }

    /* renamed from: V2 */
    public static void m75809V2(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        C11839m.m70688i("CloudBackupV3Utils", str + ":updateBackupActiveTime, the active time is:" + jCurrentTimeMillis);
        C13466f.m81073d().m81083k("backup_key_active_time", jCurrentTimeMillis);
    }

    /* renamed from: W */
    public static void m75810W(List<String> list) throws UnsupportedEncodingException {
        if (AbstractC14026a.m84159a(list)) {
            C11839m.m70689w("CloudBackupV3Utils", "getCloudPathStr is empty");
            return;
        }
        for (int i10 = 0; i10 < list.size(); i10++) {
            String strReplaceFirst = list.get(i10);
            if (strReplaceFirst != null) {
                if (strReplaceFirst.startsWith("/")) {
                    strReplaceFirst = strReplaceFirst.replaceFirst("/", "");
                }
                list.set(i10, "/" + URLEncoder.encode(strReplaceFirst, StandardCharsets.UTF_8.name()));
            }
        }
    }

    /* renamed from: W0 */
    public static boolean m75811W0(String str, Integer num) {
        if (!m75869k1(str) || m75857h1(num)) {
            return true;
        }
        C11839m.m70688i("CloudBackupV3Utils", "isBmTypeMatch not, userGradeCode: " + str + ", bakBmType: " + num);
        return false;
    }

    /* renamed from: W1 */
    public static void m75812W1(File file) throws C9721b {
        if (file == null || file.exists()) {
            return;
        }
        synchronized (f57968a) {
            try {
                if (file.exists() || file.mkdirs()) {
                    return;
                }
                String strM63452a = C10279b.m63452a(file);
                File parentFile = file.getParentFile();
                if (parentFile != null) {
                    if (parentFile.isFile()) {
                        C11839m.m70687e("CloudBackupV3Utils", "create dir error, parent dir is file, path = " + strM63452a);
                        return;
                    }
                    File parentFile2 = parentFile.getParentFile();
                    if (parentFile2 != null && parentFile2.isFile()) {
                        C11839m.m70687e("CloudBackupV3Utils", "create dir error, parent's parent dir is file, path = " + strM63452a);
                        return;
                    }
                }
                C11839m.m70687e("CloudBackupV3Utils", "create dir error, path = " + strM63452a);
                throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "create dir error, path = " + strM63452a);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: W2 */
    public static void m75813W2(CloudBackupStatus cloudBackupStatus, String str) {
        synchronized (f57969b) {
            try {
                if (cloudBackupStatus == null) {
                    C11839m.m70689w("CloudBackupV3Utils", "updateBackupStatusProperties cloudBackupStatus is empty");
                    return;
                }
                Map<String, String> mapM75858h2 = m75858h2(cloudBackupStatus.m29393b1());
                String str2 = mapM75858h2.get("isDiff");
                if ("1".equals(str2)) {
                    C11839m.m70686d("CloudBackupV3Utils", "updateBackupStatusProperties use pms flag");
                    return;
                }
                C11839m.m70686d("CloudBackupV3Utils", "updateBackupStatusProperties currentType: " + str2 + " diffType:" + str);
                if (!TextUtils.equals(str2, str)) {
                    mapM75858h2.remove("isDiff");
                    mapM75858h2.put("isDiff", str);
                    String strM75846e2 = m75846e2(mapM75858h2);
                    cloudBackupStatus.m29401e2(strM75846e2);
                    new C12815f().m76936o(cloudBackupStatus.m29870d(), cloudBackupStatus.m29861N(), strM75846e2);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: X */
    public static String m75814X() {
        String str = "";
        if (C9733f.m60705z().m60720O("cloudBackupDeviceNameManagement")) {
            List<UserBackupInfo.UserDeviceInfo> listM78568h = new C13036o().m78568h();
            if (listM78568h != null && !listM78568h.isEmpty() && !TextUtils.isEmpty(listM78568h.get(0).getDeviceName())) {
                String strM68633c = C11477c.m68633c(listM78568h.get(0).getDeviceName());
                if (!TextUtils.isEmpty(strM68633c)) {
                    str = strM68633c;
                }
            }
            if (TextUtils.isEmpty(str)) {
                String strM81088b = C13467g.m81086c().m81088b();
                if (!TextUtils.isEmpty(strM81088b)) {
                    String strM68633c2 = C11477c.m68633c(strM81088b);
                    if (!TextUtils.isEmpty(strM68633c2)) {
                        str = strM68633c2;
                    }
                }
            }
        }
        return TextUtils.isEmpty(str) ? C0209d.m1174H() : str;
    }

    /* renamed from: X0 */
    public static boolean m75815X0() {
        C13032k c13032kM78546d = new C13033l().m78546d(1);
        if (c13032kM78546d == null) {
            C11839m.m70688i("CloudBackupV3Utils", "cloudBackupState is null, return false.");
            return false;
        }
        if (!C14339h.m85517p().contains(Integer.valueOf(c13032kM78546d.m78530n()))) {
            return false;
        }
        C11839m.m70688i("CloudBackupV3Utils", "current backup state is space not enough, return true.");
        return true;
    }

    /* renamed from: X1 */
    public static void m75816X1(File file, boolean z10) throws C9721b {
        if (file == null || file.exists()) {
            return;
        }
        if (z10) {
            m75812W1(file);
            return;
        }
        synchronized (f57968a) {
            try {
                if (!file.mkdirs()) {
                    C11839m.m70687e("CloudBackupV3Utils", "create dir error, path = " + C10279b.m63452a(file));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: X2 */
    public static void m75817X2(CloudBackupStatus cloudBackupStatus, String str) {
        if (cloudBackupStatus == null) {
            C11839m.m70689w("CloudBackupV3Utils", "updateBackupStatusSignaturesProperties cloudBackupStatus is empty");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            C11839m.m70689w("CloudBackupV3Utils", "updateBackupStatusSignaturesProperties signatures is empty");
            return;
        }
        synchronized (f57969b) {
            Map<String, String> mapM75858h2 = m75858h2(cloudBackupStatus.m29393b1());
            mapM75858h2.put("signatures", str);
            cloudBackupStatus.m29401e2(m75846e2(mapM75858h2));
        }
    }

    /* renamed from: Y */
    public static int[] m75818Y(String str, C12526j c12526j) {
        CloudBackup cloudBackup;
        int[] iArr = {c12526j.m75354P(), c12526j.m75356Q()};
        List<AppInfoList> listM75300k = new C12519c().m75300k(str);
        if (listM75300k.isEmpty() || (cloudBackup = listM75300k.get(0).getCloudBackup()) == null) {
            return iArr;
        }
        int dataAcptErrNum = cloudBackup.getDataAcptErrNum();
        int dataAcptErrRate = cloudBackup.getDataAcptErrRate();
        if (dataAcptErrNum >= 0 && dataAcptErrRate >= 0) {
            iArr[0] = dataAcptErrNum;
            iArr[1] = dataAcptErrRate;
        }
        return iArr;
    }

    /* renamed from: Y0 */
    public static boolean m75819Y0(PmsMeta pmsMeta, int i10, String str, int i11, boolean z10, boolean z11) {
        if (!m75885o1(z10, z11) || i10 != 0 || pmsMeta == null || TextUtils.isEmpty(pmsMeta.getName()) || ((Long) C9731d.m60699d().m60702c("batchSize", new Callable() { // from class: rm.f0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return C12590s0.m75804U1();
            }
        }, 0L)).longValue() <= 0 || !PmsUtils.isSupportPMSFastCopy() || "music".equals(str) || i11 == 0 || 1 == pmsMeta.getIsdir()) {
            return false;
        }
        String name = pmsMeta.getName();
        if (name.endsWith(".dbsplite") || name.endsWith(".differencepacket") || name.endsWith(".dbhashfile")) {
            return false;
        }
        return pmsMeta.getSize() <= ((Long) C9731d.m60699d().m60702c("fileThreshold", new Callable() { // from class: rm.g0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return C12590s0.m75800T1();
            }
        }, 204800L)).longValue();
    }

    /* renamed from: Y1 */
    public static void m75820Y1(String str) throws C9721b {
        m75812W1(C10278a.m63442h(str));
    }

    /* renamed from: Y2 */
    public static void m75821Y2(String str, List<CloudRestoreItem> list, Map<String, CloudRestoreItem> map) {
        List<CloudRestoreItem> childList = RestoreProgress.getChildList(str, list);
        if (childList == null) {
            return;
        }
        for (CloudRestoreItem cloudRestoreItem : childList) {
            if (cloudRestoreItem != null) {
                map.put(cloudRestoreItem.getAppId(), cloudRestoreItem);
                C11839m.m70686d("CloudBackupV3Utils", "init last record appId: " + cloudRestoreItem.getAppId() + " uid : " + cloudRestoreItem.getUid() + " ,size: " + cloudRestoreItem.getSize() + ", count: " + cloudRestoreItem.getCount());
            }
        }
    }

    /* renamed from: Z */
    public static int m75822Z(long j10, long j11) {
        long j12 = j11 - j10;
        if (j12 <= 0) {
            return 0;
        }
        TimeUnit timeUnit = TimeUnit.DAYS;
        int iConvert = (int) timeUnit.convert(j12, TimeUnit.MILLISECONDS);
        return j12 > timeUnit.toMillis((long) iConvert) ? iConvert + 1 : iConvert;
    }

    /* renamed from: Z0 */
    public static boolean m75823Z0() {
        return m75828a1(C13452e.m80781L().m80790C());
    }

    /* renamed from: Z1 */
    public static void m75824Z1(String str, boolean z10) throws C9721b {
        m75816X1(C10278a.m63442h(str), z10);
    }

    /* renamed from: Z2 */
    public static void m75825Z2(String str, String str2, int i10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            ComponentName componentName = new ComponentName(str, str2);
            Intent intent = new Intent();
            intent.setComponent(componentName);
            C11839m.m70688i("CloudBackupV3Utils", "restart service: " + str2);
            C11839m.m70688i("CloudBackupV3Utils", "wakeUpIM appId = " + str + " , uid = " + i10);
            Class.forName("android.content.Context").getMethod("startServiceAsUser", Intent.class, UserHandle.class).invoke(C0213f.m1377a(), intent, AppDataSizeUtil.getUserHandle(i10));
        } catch (Exception e10) {
            C11839m.m70687e("CloudBackupV3Utils", "restart service: " + str2 + ", error: " + e10.getMessage());
        }
    }

    /* renamed from: a0 */
    public static String m75827a0() {
        return m75865j1() ? CloudBackupConstant.UserPackageInfo.BASE_DATA_SERVICE : "N";
    }

    /* renamed from: a1 */
    public static boolean m75828a1(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        return C13452e.m80781L().m80834N0(str);
    }

    /* renamed from: a2 */
    public static void m75829a2(File file) throws C9721b {
        m75812W1(C10278a.m63437c(file));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14, types: [java.util.zip.ZipOutputStream] */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.util.zip.ZipOutputStream] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* renamed from: a3 */
    public static void m75830a3(File file, String str) throws Throwable {
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        FileOutputStream fileOutputStream;
        ?? zipOutputStream;
        BufferedOutputStream bufferedOutputStream2;
        BufferedOutputStream bufferedOutputStream3;
        File fileM63442h = C10278a.m63442h(str);
        if (!file.exists() || file.isDirectory()) {
            C11839m.m70688i("CloudBackupV3Utils", "sourceFile not exists, fie: " + file);
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "sourceFile not exists, fie: " + file);
        }
        FileInputStream fileInputStream = null;
        try {
            if (fileM63442h.exists()) {
                C11839m.m70686d("CloudBackupV3Utils", "zip has exits");
                C11839m.m70686d("CloudBackupV3Utils", "deleteResult is = " + fileM63442h.delete());
            }
            C11839m.m70686d("CloudBackupV3Utils", "create new file  result = " + fileM63442h.createNewFile());
            fileOutputStream = new FileOutputStream(fileM63442h);
            try {
                BufferedOutputStream bufferedOutputStream4 = new BufferedOutputStream(fileOutputStream);
                try {
                    zipOutputStream = new ZipOutputStream(bufferedOutputStream4);
                    try {
                        byte[] bArr = new byte[10240];
                        zipOutputStream.putNextEntry(new ZipEntry(file.getName()));
                        FileInputStream fileInputStream2 = new FileInputStream(file);
                        try {
                            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(fileInputStream2, 10240);
                            while (true) {
                                try {
                                    int i10 = bufferedInputStream2.read(bArr, 0, 10240);
                                    if (i10 == -1) {
                                        fileInputStream2.close();
                                        bufferedInputStream2.close();
                                        m75874l2(fileInputStream2, bufferedInputStream2, fileOutputStream, zipOutputStream, bufferedOutputStream4);
                                        return;
                                    }
                                    zipOutputStream.write(bArr, 0, i10);
                                } catch (FileNotFoundException e10) {
                                    bufferedOutputStream = bufferedOutputStream4;
                                    bufferedInputStream = bufferedInputStream2;
                                    e = e10;
                                    fileInputStream = fileInputStream2;
                                    zipOutputStream = zipOutputStream;
                                    try {
                                        C11839m.m70688i("CloudBackupV3Utils", "fileToZip FileNotFoundException , e" + e);
                                        throw new C9721b(FamilyShareConstants.StatusCode.SHARE_SPACE_NOT_ENOUGH, "fileToZip FileNotFoundException");
                                    } catch (Throwable th2) {
                                        th = th2;
                                        m75874l2(fileInputStream, bufferedInputStream, fileOutputStream, zipOutputStream, bufferedOutputStream);
                                        throw th;
                                    }
                                } catch (IOException e11) {
                                    bufferedOutputStream3 = bufferedOutputStream4;
                                    bufferedInputStream = bufferedInputStream2;
                                    e = e11;
                                    fileInputStream = fileInputStream2;
                                    zipOutputStream = zipOutputStream;
                                    try {
                                        C11839m.m70688i("CloudBackupV3Utils", "fileToZip IOException, e " + e);
                                        throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "fileToZip IOException");
                                    } catch (Throwable th3) {
                                        th = th3;
                                        bufferedOutputStream = bufferedOutputStream3;
                                        m75874l2(fileInputStream, bufferedInputStream, fileOutputStream, zipOutputStream, bufferedOutputStream);
                                        throw th;
                                    }
                                } catch (Throwable th4) {
                                    bufferedOutputStream = bufferedOutputStream4;
                                    bufferedInputStream = bufferedInputStream2;
                                    th = th4;
                                    fileInputStream = fileInputStream2;
                                    m75874l2(fileInputStream, bufferedInputStream, fileOutputStream, zipOutputStream, bufferedOutputStream);
                                    throw th;
                                }
                            }
                        } catch (FileNotFoundException e12) {
                            e = e12;
                            bufferedOutputStream = bufferedOutputStream4;
                            bufferedInputStream = null;
                        } catch (IOException e13) {
                            e = e13;
                            bufferedOutputStream3 = bufferedOutputStream4;
                            bufferedInputStream = null;
                        } catch (Throwable th5) {
                            th = th5;
                            bufferedOutputStream = bufferedOutputStream4;
                            bufferedInputStream = null;
                        }
                    } catch (FileNotFoundException e14) {
                        e = e14;
                        bufferedOutputStream = bufferedOutputStream4;
                        bufferedInputStream = null;
                        zipOutputStream = zipOutputStream;
                    } catch (IOException e15) {
                        e = e15;
                        bufferedOutputStream3 = bufferedOutputStream4;
                        bufferedInputStream = null;
                        zipOutputStream = zipOutputStream;
                    } catch (Throwable th6) {
                        th = th6;
                        bufferedOutputStream = bufferedOutputStream4;
                        bufferedInputStream = null;
                    }
                } catch (FileNotFoundException e16) {
                    e = e16;
                    bufferedOutputStream = bufferedOutputStream4;
                    bufferedInputStream = null;
                    zipOutputStream = 0;
                } catch (IOException e17) {
                    e = e17;
                    bufferedOutputStream3 = bufferedOutputStream4;
                    bufferedInputStream = null;
                    zipOutputStream = 0;
                } catch (Throwable th7) {
                    th = th7;
                    bufferedOutputStream = bufferedOutputStream4;
                    bufferedInputStream = null;
                    zipOutputStream = 0;
                }
            } catch (FileNotFoundException e18) {
                e = e18;
                bufferedInputStream = null;
                bufferedOutputStream = null;
                zipOutputStream = 0;
            } catch (IOException e19) {
                e = e19;
                bufferedInputStream = null;
                bufferedOutputStream2 = null;
                bufferedOutputStream3 = bufferedOutputStream2;
                zipOutputStream = bufferedOutputStream2;
                C11839m.m70688i("CloudBackupV3Utils", "fileToZip IOException, e " + e);
                throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "fileToZip IOException");
            } catch (Throwable th8) {
                th = th8;
                bufferedInputStream = null;
                bufferedOutputStream = null;
                zipOutputStream = 0;
            }
        } catch (FileNotFoundException e20) {
            e = e20;
            bufferedInputStream = null;
            bufferedOutputStream = null;
            fileOutputStream = null;
            zipOutputStream = 0;
        } catch (IOException e21) {
            e = e21;
            bufferedInputStream = null;
            fileOutputStream = null;
            bufferedOutputStream2 = null;
        } catch (Throwable th9) {
            th = th9;
            bufferedInputStream = null;
            bufferedOutputStream = null;
            fileOutputStream = null;
            zipOutputStream = 0;
        }
    }

    /* renamed from: b0 */
    public static Intent m75832b0(String str, Intent intent, boolean z10) {
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(intent);
        C0209d.m1302r2(hiCloudSafeIntent, "com.huawei.hidisk");
        hiCloudSafeIntent.setAction("android.intent.action.VIEW");
        hiCloudSafeIntent.setData(Uri.parse(str));
        if (z10) {
            hiCloudSafeIntent.putExtra("action_bar_color_hm_os_bg", true);
            hiCloudSafeIntent.putExtra("is_support_dark_mode", true);
        }
        hiCloudSafeIntent.putExtra("gotoDeeplink", str);
        return hiCloudSafeIntent;
    }

    /* renamed from: b1 */
    public static boolean m75833b1(String str) {
        Iterator<String> it = C14333b.m85477l().iterator();
        while (it.hasNext()) {
            if (it.next().equals(str)) {
                return !C14333b.f63657i.contains(str);
            }
        }
        return false;
    }

    /* renamed from: b2 */
    public static void m75834b2(File file, boolean z10) throws C9721b {
        m75816X1(C10278a.m63437c(file), z10);
    }

    /* renamed from: c0 */
    public static int m75836c0(long j10) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (j10 > jCurrentTimeMillis) {
            jCurrentTimeMillis = j10;
        }
        long j11 = (jCurrentTimeMillis - j10) / 86400000;
        if (j11 == 0) {
            j11++;
        }
        return (int) j11;
    }

    /* renamed from: c1 */
    public static boolean m75837c1() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        C11839m.m70688i("CloudBackupV3Utils", "boot elapsedRealtime:" + jElapsedRealtime);
        return jElapsedRealtime < 600000;
    }

    /* renamed from: c2 */
    public static void m75838c2(String str) throws C9721b {
        m75829a2(C10278a.m63442h(str));
    }

    /* renamed from: d0 */
    public static int m75840d0(String str) throws IOException {
        try {
            LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(str));
            try {
                lineNumberReader.skip(Long.MAX_VALUE);
                int lineNumber = lineNumberReader.getLineNumber() + 1;
                lineNumberReader.close();
                return lineNumber;
            } finally {
            }
        } catch (Exception unused) {
            return 0;
        }
    }

    /* renamed from: d1 */
    public static boolean m75841d1(String str, boolean z10) {
        return z10 && C14333b.m85461Q(str) && !C9733f.m60705z().m60720O("disableSounderUseLocalUploadCache");
    }

    /* renamed from: d2 */
    public static void m75842d2(String str, boolean z10) throws C9721b {
        m75834b2(C10278a.m63442h(str), z10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [int] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11, types: [android.content.ContentResolver] */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16, types: [int] */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* renamed from: e0 */
    public static Pair<Integer, Long> m75844e0(boolean z10, boolean z11) throws Throwable {
        ?? contentResolver;
        Context contextM1377a = C0213f.m1377a();
        long j10 = 0;
        if (AbstractC14026a.m84159a(C1006a.m5936k().m5962h(contextM1377a))) {
            C11839m.m70687e("CloudBackupV3Utils", "scan gallery album is empty.");
            contentResolver = 0;
        } else {
            Uri contentUri = MediaStore.Files.getContentUri("external");
            String[] strArr = {"_data", "_size"};
            try {
                contentResolver = contextM1377a.getContentResolver();
                Cursor cursorQuery = contentResolver.query(contentUri, strArr, "media_type in (1, 3)", null, "_data asc");
                try {
                    if (cursorQuery != null) {
                        try {
                            int columnIndex = cursorQuery.getColumnIndex("_size");
                            contentResolver = 0;
                            while (cursorQuery.moveToNext()) {
                                try {
                                    j10 += cursorQuery.getLong(columnIndex);
                                    contentResolver++;
                                } catch (Throwable th2) {
                                    th = th2;
                                    try {
                                        cursorQuery.close();
                                    } catch (Throwable th3) {
                                        th.addSuppressed(th3);
                                    }
                                    throw th;
                                }
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            contentResolver = 0;
                        }
                    } else {
                        contentResolver = 0;
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                } catch (Exception e10) {
                    e = e10;
                    contentResolver = contentResolver;
                    C11839m.m70687e("CloudBackupV3Utils", "scan media database error. " + e.getMessage());
                    HiddenAlbumFileData hiddenAlbumFileDataM75491c = C12543c1.m75491c(z10, z11, 0);
                    C11839m.m70686d("CloudBackupV3Utils", "hide album count and size: " + hiddenAlbumFileDataM75491c);
                    return new Pair<>(Integer.valueOf(contentResolver + hiddenAlbumFileDataM75491c.getFileCount()), Long.valueOf(j10 + hiddenAlbumFileDataM75491c.getFileSize()));
                }
            } catch (Exception e11) {
                e = e11;
                contentResolver = 0;
            }
        }
        HiddenAlbumFileData hiddenAlbumFileDataM75491c2 = C12543c1.m75491c(z10, z11, 0);
        C11839m.m70686d("CloudBackupV3Utils", "hide album count and size: " + hiddenAlbumFileDataM75491c2);
        return new Pair<>(Integer.valueOf(contentResolver + hiddenAlbumFileDataM75491c2.getFileCount()), Long.valueOf(j10 + hiddenAlbumFileDataM75491c2.getFileSize()));
    }

    /* renamed from: e1 */
    public static void m75845e1(String str, long j10, String str2) throws C9721b {
        if (j10 <= 0 || m75909u1(str)) {
            return;
        }
        String strM1512v = C0221j.m1512v();
        String strM1514x = C0221j.m1514x();
        String strM1474B = C0221j.m1474B();
        if (m75909u1(strM1512v) || !str.startsWith(strM1512v)) {
            if (!m75909u1(strM1514x) && str.startsWith(strM1514x)) {
                strM1512v = strM1514x;
            } else if (!m75909u1(strM1474B) && str.startsWith(strM1474B)) {
                strM1512v = strM1474B;
            } else if (m75909u1(str2) || !str.startsWith(str2)) {
                strM1512v = null;
            }
        }
        if (m75909u1(strM1512v)) {
            return;
        }
        long jM5966m = C1006a.m5936k().m5966m(strM1512v);
        if (jM5966m <= 0) {
            jM5966m = m75896r0(strM1512v);
            C11839m.m70688i("CloudBackupV3Utils", "CloudAlbumCaller getPathAvailSize <=0 , use backup copy  pathAvailSize = " + jM5966m);
        }
        long jM75856h0 = m75856h0();
        long j11 = j10 + jM75856h0;
        if (j11 <= jM5966m) {
            return;
        }
        m75777N2(j11 - jM5966m);
        C11839m.m70688i("CloudBackupV3Utils", "checkFileSize pathAvailSize = " + jM5966m + " ,fileSize = " + j11 + " ,reservedSize: " + jM75856h0);
        throw new C9721b(1007, "download file " + str + " ,no space in device ,location left " + jM5966m + " ,file need " + j11);
    }

    /* renamed from: e2 */
    public static String m75846e2(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> next = it.next();
            String key = next.getKey();
            String value = next.getValue();
            sb2.append(key);
            sb2.append("=");
            sb2.append(value);
            if (it.hasNext()) {
                sb2.append("&");
            }
        }
        return sb2.toString();
    }

    /* renamed from: f0 */
    public static long m75848f0(BackupOptionItem backupOptionItem, C11725f c11725f, Map<String, CloudRestoreItem> map, boolean z10) {
        String strM69958b = c11725f.m69958b();
        if (map == null || map.isEmpty()) {
            C11724e c11724eM75878m2 = m75878m2(strM69958b, backupOptionItem.getAppId(), backupOptionItem.getUid(), c11725f.m69959c());
            long dataBytes = z10 ? backupOptionItem.getDataBytes() + backupOptionItem.getCodeBytes() : backupOptionItem.getDataBytes();
            if (c11724eM75878m2 != null) {
                dataBytes -= c11724eM75878m2.m69952c();
            }
            return dataBytes;
        }
        int uid = backupOptionItem.getUid();
        CloudRestoreItem cloudRestoreItem = map.get(backupOptionItem.getAppId());
        if (cloudRestoreItem == null || cloudRestoreItem.getSize() == 0 || m75833b1(backupOptionItem.getAppId())) {
            return backupOptionItem.getDataBytes();
        }
        C11839m.m70686d("CloudBackupV3Utils", "getIncrease1 itemAppId = " + backupOptionItem.getAppId() + " uid = " + uid + " dataBytes = " + backupOptionItem.getDataBytes() + " size = " + cloudRestoreItem.getSize());
        return backupOptionItem.getDataBytes() - cloudRestoreItem.getSize();
    }

    /* renamed from: f1 */
    public static boolean m75849f1(String str) {
        return (m75869k1(str) && m75828a1(str)) ? false : true;
    }

    /* renamed from: f2 */
    public static boolean m75850f2() {
        C13467g c13467gM81086c = C13467g.m81086c();
        Integer num = CloudBackupConstant.UserPackageInfo.VIP_BACKUP_RECORDS;
        return c13467gM81086c.m81089d("about_number_of_backup_record", num.intValue()) < num.intValue();
    }

    /* renamed from: g0 */
    public static String m75852g0() {
        Locale locale = Locale.getDefault();
        if (locale == null || locale.getLanguage() == null) {
            return "";
        }
        if ("zh".equals(locale.getLanguage())) {
            return locale.toLanguageTag();
        }
        return locale.getLanguage().toLowerCase(locale) + "-" + locale.getCountry().toLowerCase(locale);
    }

    /* renamed from: g1 */
    public static boolean m75853g1() {
        boolean z10 = false;
        if (!C13452e.m80781L().m80887a1()) {
            return false;
        }
        Context contextM1377a = C0213f.m1377a();
        boolean zM1309t1 = C0209d.m1309t1(contextM1377a);
        String strM80790C = C13452e.m80781L().m80790C();
        boolean zM62388s = C10028c.m62182c0().m62388s("backup_key");
        boolean zM62303a1 = C10028c.m62182c0().m62303a1();
        if (!zM1309t1) {
            strM80790C = C13464d.m81030f(contextM1377a).m81039j("CACHED_GRADE_CODE", "");
            zM62388s = C13464d.m81030f(contextM1377a).m81033c("backup_key");
            zM62303a1 = C13464d.m81030f(contextM1377a).m81033c("base_backup_new_key");
        }
        if (!m75828a1(strM80790C) && zM62388s && !zM62303a1) {
            z10 = true;
        }
        C11839m.m70688i("CloudBackupV3Utils", "isNewBmFullUserOnlyBackupBaseData:" + z10);
        return z10;
    }

    /* renamed from: g2 */
    public static boolean m75854g2(List<CloudRecoveryItem> list) {
        return !AbstractC14026a.m84159a(list) && list.size() == 1 && list.get(0).getBackupRecordLabel() == 3;
    }

    /* renamed from: h0 */
    public static long m75856h0() {
        return f57971d;
    }

    /* renamed from: h1 */
    public static boolean m75857h1(Integer num) {
        return (num == null || num.intValue() == 0) ? false : true;
    }

    /* renamed from: h2 */
    public static Map<String, String> m75858h2(String str) {
        HashMap map = new HashMap();
        String[] strArrSplit = str.split("&");
        if (strArrSplit != null) {
            for (String str2 : strArrSplit) {
                String[] strArrSplit2 = str2.split("=");
                if (strArrSplit2.length == 2) {
                    map.put(strArrSplit2[0], strArrSplit2[1]);
                }
            }
        }
        return map;
    }

    /* renamed from: i0 */
    public static long m75860i0() {
        return Math.max(m75864j0(), 100000000L);
    }

    /* renamed from: i1 */
    public static boolean m75861i1(String str) {
        C11839m.m70688i("CloudBackupV3Utils", "isNewBmUserOnlyBackupBaseData gradeCode:" + str);
        return C13452e.m80781L().m80887a1() && m75828a1(str) && C10028c.m62182c0().m62330g1(str);
    }

    /* renamed from: i2 */
    public static RefurbishRestoreFailInfo m75862i2() {
        try {
            String strM81090e = C13467g.m81086c().m81090e("refurbish_record_restore_fail_info", "");
            if (!TextUtils.isEmpty(strM81090e)) {
                return (RefurbishRestoreFailInfo) new Gson().fromJson(strM81090e, RefurbishRestoreFailInfo.class);
            }
        } catch (Exception e10) {
            C11839m.m70687e("CloudBackupV3Utils", "parseRefurbishRestoreFailInfo error: " + e10);
        }
        return new RefurbishRestoreFailInfo();
    }

    /* renamed from: j0 */
    public static long m75864j0() {
        return f57970c;
    }

    /* renamed from: j1 */
    public static boolean m75865j1() {
        return m75869k1(C13452e.m80781L().m80790C());
    }

    /* renamed from: j2 */
    public static RefurbishRestoreInfo m75866j2() {
        try {
            String strM81090e = C13467g.m81086c().m81090e("refurbish_record_restore_info", "");
            if (!TextUtils.isEmpty(strM81090e)) {
                return (RefurbishRestoreInfo) new Gson().fromJson(strM81090e, RefurbishRestoreInfo.class);
            }
        } catch (Exception e10) {
            C11839m.m70687e("CloudBackupV3Utils", "parseRefurbishRestoreInfo error: " + e10);
        }
        return new RefurbishRestoreInfo();
    }

    /* renamed from: k0 */
    public static List<String> m75868k0() {
        ArrayList arrayList = new ArrayList();
        if (!C13452e.m80781L().m80887a1()) {
            C11839m.m70688i("CloudBackupV3Utils", "getNewBmTypeBackupOptionsModules:not new BmType or is freeUser.");
            return arrayList;
        }
        List<BackupOptionItem> listM78397u = new C13026e().m78397u();
        if (AbstractC14026a.m84159a(listM78397u)) {
            C11839m.m70688i("CloudBackupV3Utils", "getNewBmTypeBackupOptionsModules:backup option applist is empty.");
            return arrayList;
        }
        final List<String> listM73271n = C12176c.m73271n(null);
        final List<String> listM76026b = C12597u1.m76026b();
        listM78397u.removeIf(new Predicate() { // from class: rm.d0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C12590s0.m75772M1(listM73271n, listM76026b, (BackupOptionItem) obj);
            }
        });
        if (AbstractC14026a.m84159a(listM78397u)) {
            return arrayList;
        }
        List<String> list = (List) listM78397u.stream().map(new C2575c0()).collect(Collectors.toList());
        C11839m.m70688i("CloudBackupV3Utils", "getNewBmTypeBackupOptionsModules :" + list);
        return list;
    }

    /* renamed from: k1 */
    public static boolean m75869k1(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return C13452e.m80781L().m80887a1();
    }

    /* renamed from: k2 */
    public static void m75870k2(String str, int i10, String str2, String str3, File file) throws C9721b {
        if (TextUtils.equals(str, str2)) {
            return;
        }
        String str4 = str3 + File.separator + str;
        String strM75686v = C12583q.m75686v(str3, i10, str2);
        File fileM63442h = C10278a.m63442h(str4);
        if (fileM63442h.exists() && !C11835i.m70642f(fileM63442h)) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "delete currentRealDir error: " + str4);
        }
        File fileM63442h2 = C10278a.m63442h(strM75686v);
        File fileM63441g = C10278a.m63441g(fileM63442h2, str2 + ".apk");
        if (!fileM63441g.renameTo(C10278a.m63441g(fileM63442h2, str + ".apk"))) {
            C11839m.m70688i("CloudBackupV3Utils", "originApkRenameResult failed: " + C10279b.m63452a(fileM63441g));
        }
        if (fileM63442h2.renameTo(fileM63442h)) {
            return;
        }
        throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "splitApkDir.renameTo(currentRealDir) failed: " + str4);
    }

    /* renamed from: l0 */
    public static long m75872l0() {
        ICycleChecker iCycleChecker = ICycleChecker.get(new Predicate() { // from class: rm.k0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C12590s0.m75776N1((ICycleChecker) obj);
            }
        });
        return Math.max(CloudBackupConditionsUtil.getTargetBackupTime(iCycleChecker.isCycleSatisfy(), iCycleChecker, CloudBackupConditionsUtil.isRetryIntervalSatisfy(), CloudBackupConditionsUtil.isNextBackupTimeSatisfy()), System.currentTimeMillis());
    }

    /* renamed from: l1 */
    public static boolean m75873l1(String str) {
        return (m75921x1(str) || m75925y1(str)) ? false : true;
    }

    /* renamed from: l2 */
    public static void m75874l2(FileInputStream fileInputStream, BufferedInputStream bufferedInputStream, FileOutputStream fileOutputStream, ZipOutputStream zipOutputStream, BufferedOutputStream bufferedOutputStream) throws IOException {
        if (bufferedInputStream != null) {
            try {
                bufferedInputStream.close();
            } catch (IOException e10) {
                C11839m.m70687e("CloudBackupV3Utils", "IOException bis occur, " + e10.getMessage());
            }
        }
        if (zipOutputStream != null) {
            try {
                zipOutputStream.close();
            } catch (IOException e11) {
                C11839m.m70687e("CloudBackupV3Utils", "IOException zos occur, " + e11.getMessage());
            }
        }
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (IOException e12) {
                C11839m.m70687e("CloudBackupV3Utils", "IOException fos occur, " + e12.getMessage());
            }
        }
        if (fileInputStream != null) {
            try {
                fileInputStream.close();
            } catch (IOException e13) {
                C11839m.m70687e("CloudBackupV3Utils", "IOException fis occur, " + e13.getMessage());
            }
        }
        if (bufferedOutputStream != null) {
            try {
                bufferedOutputStream.close();
            } catch (IOException e14) {
                C11839m.m70687e("CloudBackupV3Utils", "IOException bos occur, " + e14.getMessage());
            }
        }
    }

    /* renamed from: m0 */
    public static String m75876m0(long j10, Context context) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j10);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(System.currentTimeMillis());
        int i10 = calendar.get(6);
        int i11 = calendar2.get(6);
        return i10 == i11 ? context.getString(R$string.main_today) : i10 - i11 == 1 ? context.getString(R$string.tomorrow) : C11667a.m69661c(context, j10, 65556);
    }

    /* renamed from: m1 */
    public static boolean m75877m1(String str, int i10, String str2, String str3) {
        if ("1".equals(str2)) {
            String strM75670f = C12583q.m75670f(i10, ICBUtil.ANDROID_DATA, str);
            if (!TextUtils.isEmpty(strM75670f) && !TextUtils.isEmpty(str3) && str3.startsWith(strM75670f)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: m2 */
    public static C11724e m75878m2(String str, String str2, int i10, Map<String, String> map) {
        if (C4633d0.m28404a(str)) {
            return null;
        }
        if (CBSBaseReq.CURRENT_API_VERSION.equals(map.get(str))) {
            return m75914v2(str, str2, i10);
        }
        if (i10 == 0) {
            return m75910u2(str, str2);
        }
        C11839m.m70686d("CloudBackupV3Utils", "queryAppRecord v2 , current twinApp return null , appId" + str2 + " uid : " + i10);
        return null;
    }

    /* renamed from: n0 */
    public static List<String> m75880n0() {
        Integer num;
        Map<String, SyncAppBackupPolicy> mapM76029e = C12597u1.m76029e();
        Map<String, Integer> mapM76030f = C12597u1.m76030f();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, SyncAppBackupPolicy> entry : mapM76029e.entrySet()) {
            String key = entry.getKey();
            SyncAppBackupPolicy value = entry.getValue();
            if (value != null && value.getPolicy() == 1 && (num = mapM76030f.get(value.getSyncAppName())) != null && 1 == num.intValue()) {
                arrayList.add(key);
            }
        }
        return arrayList;
    }

    /* renamed from: n1 */
    public static boolean m75881n1(long j10) {
        return System.currentTimeMillis() - j10 >= 15552000000L;
    }

    /* renamed from: n2 */
    public static C13029h m75882n2() {
        C13029h c13029hM78495f;
        C13030i c13030i = new C13030i();
        try {
            c13029hM78495f = c13030i.m78495f(4);
            if (c13029hM78495f != null) {
                return c13029hM78495f;
            }
            try {
                C13029h c13029hM78495f2 = c13030i.m78495f(5);
                if (c13029hM78495f2 != null) {
                    return c13029hM78495f2;
                }
                C13029h c13029hM78495f3 = c13030i.m78495f(2);
                return c13029hM78495f3 == null ? c13030i.m78495f(1) : c13029hM78495f3;
            } catch (C9721b unused) {
                C11839m.m70689w("CloudBackupV3Utils", "");
                return c13029hM78495f;
            }
        } catch (C9721b unused2) {
            c13029hM78495f = null;
        }
    }

    /* renamed from: o0 */
    public static String m75884o0(BackupOptionItem backupOptionItem, C13026e c13026e, Context context) {
        String strM25632b = NewHiSyncUtil.m25632b(backupOptionItem.getOriBackupAppName());
        if (TextUtils.isEmpty(strM25632b)) {
            String appName = backupOptionItem.getAppName();
            return TextUtils.isEmpty(appName) ? backupOptionItem.getAppId() : appName;
        }
        String newAppName = SplitAppUtil.getNewAppName(backupOptionItem.getAppId(), strM25632b);
        backupOptionItem.setAppName(newAppName);
        c13026e.m78374I(newAppName, backupOptionItem.getAppId());
        return newAppName;
    }

    /* renamed from: o1 */
    public static boolean m75885o1(boolean z10, boolean z11) {
        return !z11 && C9731d.m60699d().m60703e(z10 ? "cloudBackupRefurbishTarCopy" : "cloudBackupTarCopy");
    }

    /* renamed from: o2 */
    public static C13029h m75886o2() {
        C13029h c13029hM78495f;
        C13030i c13030i = new C13030i();
        try {
            c13029hM78495f = c13030i.m78495f(2);
            if (c13029hM78495f != null) {
                return c13029hM78495f;
            }
            try {
                return c13030i.m78495f(1);
            } catch (C9721b e10) {
                e = e10;
                C11839m.m70689w("CloudBackupV3Utils", "queryBackupTagWithOutRefurbishment error: " + e.getMessage());
                return c13029hM78495f;
            }
        } catch (C9721b e11) {
            e = e11;
            c13029hM78495f = null;
        }
    }

    /* renamed from: p0 */
    public static String m75888p0(long j10, Context context, int i10) {
        return i10 == 3001 ? context.getString(R$string.cloud_space_insufficient) : C14339h.m85514m().contains(Integer.valueOf(i10)) ? context.getString(R$string.backup_failed_network_tip) : i10 == 1006 ? context.getString(R$string.auto_bright_screen_tips) : (i10 == 1001 || i10 == 0 || C14337f.f63677c.contains(Integer.valueOf(i10))) ? context.getString(R$string.backup_size, C13843a.m83086h(context, j10)) : i10 == 1030 ? context.getString(R$string.backup_battery_temperature_high) : context.getString(R$string.backup_conditions_not_met);
    }

    /* renamed from: p1 */
    public static boolean m75889p1(boolean z10, boolean z11) {
        return C9731d.m60699d().m60703e(z10 ? "cloudBackupRefurbishSoftLinkCopy" : z11 ? "cloudBackupTempSoftLinkCopy" : "cloudBackupSoftLinkCopy");
    }

    /* renamed from: p2 */
    public static C11725f m75890p2() {
        C11725f c11725f = new C11725f();
        HashMap map = new HashMap();
        String strQueryLastBackupId = new SettingOperator().queryLastBackupId();
        if (!C4633d0.m28404a(strQueryLastBackupId)) {
            if (C10278a.m63442h(C13617a.m81941w() + File.separator + strQueryLastBackupId).exists()) {
                map.put(strQueryLastBackupId, CBSBaseReq.CURRENT_API_VERSION);
                c11725f.m69961e(strQueryLastBackupId);
            } else if (C10278a.m63442h(C13617a.m81912A(strQueryLastBackupId)).exists()) {
                map.put(strQueryLastBackupId, "V2");
                c11725f.m69961e(strQueryLastBackupId);
            }
        }
        C11839m.m70686d("CloudBackupV3Utils", "version = " + map);
        c11725f.m69962f(map);
        return c11725f;
    }

    /* renamed from: q0 */
    public static int m75892q0() {
        C13467g c13467gM81086c = C13467g.m81086c();
        Integer num = CloudBackupConstant.UserPackageInfo.VIP_BACKUP_RECORDS;
        int iM81089d = c13467gM81086c.m81089d("about_number_of_backup_record", num.intValue());
        int iM81089d2 = C13467g.m81086c().m81089d("user_number_of_backup_record", -1);
        if (iM81089d2 > iM81089d) {
            iM81089d2 = iM81089d >= num.intValue() ? num.intValue() : CloudBackupConstant.UserPackageInfo.NORMAL_BACKUP_RECORDS.intValue();
            C13467g.m81086c().m81094i("user_number_of_backup_record", iM81089d2);
        }
        return iM81089d2 != -1 ? iM81089d2 : iM81089d >= num.intValue() ? num.intValue() : CloudBackupConstant.UserPackageInfo.NORMAL_BACKUP_RECORDS.intValue();
    }

    /* renamed from: q1 */
    public static boolean m75893q1() {
        if (!C13452e.m80781L().m80887a1() || m75823Z0()) {
            C11839m.m70688i("CloudBackupV3Utils", "isPaidUserAllBackupOptionSwitchClose:not new BmType or is freeUser.");
            return false;
        }
        List<BackupOptionItem> listM78397u = new C13026e().m78397u();
        if (AbstractC14026a.m84159a(listM78397u)) {
            C11839m.m70688i("CloudBackupV3Utils", "isPaidUserAllBackupOptionSwitchClose:backup option applist is empty.");
            return false;
        }
        final List<String> listM73271n = C12176c.m73271n(null);
        final List<String> listM76026b = C12597u1.m76026b();
        listM78397u.removeIf(new Predicate() { // from class: rm.e0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C12590s0.m75808V1(listM73271n, listM76026b, (BackupOptionItem) obj);
            }
        });
        boolean zM84159a = AbstractC14026a.m84159a(listM78397u);
        C11839m.m70688i("CloudBackupV3Utils", "isPaidUserAllBackupOptionSwitchClose :" + zM84159a);
        return zM84159a;
    }

    /* renamed from: q2 */
    public static C11725f m75894q2() {
        List<C13029h> listM78494e = new C13030i().m78494e();
        if (listM78494e == null || listM78494e.isEmpty()) {
            return new C11725f();
        }
        ArrayList arrayList = new ArrayList();
        for (C13029h c13029h : listM78494e) {
            if (c13029h.m78442H() != 3) {
                arrayList.add(c13029h);
            }
        }
        if (arrayList.isEmpty()) {
            return new C11725f();
        }
        Collections.sort(arrayList);
        C13029h c13029h2 = (C13029h) arrayList.get(0);
        String strM78488y = c13029h2.m78488y();
        String strM78465h = c13029h2.m78465h();
        return (C4633d0.m28404a(strM78488y) || C4633d0.m28404a(strM78465h)) ? new C11725f() : "empty_default_id".equals(strM78465h) ? m75890p2() : m75898r2(strM78488y, strM78465h, c13029h2.m78441G());
    }

    /* renamed from: r0 */
    public static long m75896r0(String str) {
        StatFs statFs = new StatFs(str);
        long blockSize = statFs.getBlockSize();
        long blockCount = statFs.getBlockCount();
        long availableBlocks = statFs.getAvailableBlocks();
        StringBuilder sb2 = new StringBuilder("getPathAvailSize block size: ");
        sb2.append(blockSize);
        sb2.append(", block num: ");
        sb2.append(blockCount);
        sb2.append(", total size: ");
        sb2.append((blockCount * blockSize) / ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS);
        sb2.append("KB");
        sb2.append(", available block num:");
        sb2.append(availableBlocks);
        sb2.append(", available size: ");
        long j10 = availableBlocks * blockSize;
        sb2.append(j10 / ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS);
        sb2.append("KB");
        C11839m.m70688i("CloudBackupV3Utils", sb2.toString());
        return j10;
    }

    /* renamed from: r1 */
    public static boolean m75897r1(String str, int i10) {
        String strM81914C = C13617a.m81914C(str, i10);
        if (!C10278a.m63442h(strM81914C).exists()) {
            return false;
        }
        try {
            PmsMetaStatus pmsMetaStatusQuery = new PmsMetaStatusOperator(strM81914C).query();
            if (pmsMetaStatusQuery != null) {
                if (pmsMetaStatusQuery.getStatus() == 5) {
                    return true;
                }
            }
        } catch (C9721b e10) {
            C11839m.m70687e("CloudBackupV3Utils", "isPmsBriefProcess: " + e10);
        }
        return false;
    }

    /* renamed from: r2 */
    public static C11725f m75898r2(String str, String str2, int i10) {
        C11725f c11725f = new C11725f();
        HashMap map = new HashMap();
        if (str.startsWith("V3_")) {
            map.put(str2, CBSBaseReq.CURRENT_API_VERSION);
        } else {
            map.put(str2, "V2");
        }
        if (4 == i10) {
            c11725f.m69961e(str2);
        } else {
            c11725f.m69960d(str2);
            if (str.startsWith("V3_")) {
                String strQueryLastBackupId = new SettingOperator().queryLastBackupId();
                if (!C4633d0.m28404a(strQueryLastBackupId)) {
                    if (C10278a.m63442h(C13617a.m81941w() + File.separator + strQueryLastBackupId).exists()) {
                        map.put(strQueryLastBackupId, CBSBaseReq.CURRENT_API_VERSION);
                        c11725f.m69961e(strQueryLastBackupId);
                    } else if (C10278a.m63442h(C13617a.m81912A(strQueryLastBackupId)).exists()) {
                        map.put(strQueryLastBackupId, "V2");
                        c11725f.m69961e(strQueryLastBackupId);
                    }
                }
            } else if (C10278a.m63442h(C13617a.m81912A(str2)).exists()) {
                try {
                    BackupRecordMeta backupRecordMetaQueryLastBackupRecordMeta = new SnapshotBackupMetaOperator(str2).queryLastBackupRecordMeta();
                    if (backupRecordMetaQueryLastBackupRecordMeta != null) {
                        String recordId = backupRecordMetaQueryLastBackupRecordMeta.getRecordId();
                        if (!C4633d0.m28404a(recordId)) {
                            c11725f.m69961e(recordId);
                            map.put(recordId, "V2");
                        }
                    }
                } catch (C9721b unused) {
                    C11839m.m70687e("CloudBackupV3Utils", "query local latest record id failed");
                }
            }
        }
        C11839m.m70686d("CloudBackupV3Utils", "version = " + map);
        c11725f.m69962f(map);
        return c11725f;
    }

    /* renamed from: s0 */
    public static String m75900s0(Context context, List<BackupOptionItem> list) {
        List<BackupOptionItem> listM75904t0 = m75904t0(context, list);
        if (AbstractC14026a.m84159a(listM75904t0)) {
            C11839m.m70688i("CloudBackupV3Utils", "getRefurbishImportantAppTips: the appIds is empty.");
            return null;
        }
        C11839m.m70688i("CloudBackupV3Utils", "getRefurbishImportantAppTips: the appIds size is " + listM75904t0.size());
        listM75904t0.sort(new C3765j1());
        ArrayList arrayList = new ArrayList();
        for (BackupOptionItem backupOptionItem : listM75904t0) {
            String strM75770M = m75770M(context, backupOptionItem.getAppId());
            C11839m.m70688i("CloudBackupV3Utils", "getRefurbishImportantAppTips: the appId is:" + backupOptionItem.getAppId() + ", appName is :" + strM75770M);
            if (!TextUtils.isEmpty(strM75770M)) {
                arrayList.add(context.getResources().getString(R$string.refurbish_double_quotation_marks, strM75770M));
            }
        }
        C11839m.m70688i("CloudBackupV3Utils", "getRefurbishImportantAppTips: the appNames size is " + arrayList.size());
        if (!AbstractC14026a.m84159a(arrayList)) {
            return context.getString(R$string.refurbish_import_app_notice_title, m75911v(arrayList, context));
        }
        C11839m.m70688i("CloudBackupV3Utils", "getRefurbishImportantAppTips: the appNames is empty.");
        return null;
    }

    /* renamed from: s1 */
    public static boolean m75901s1() throws IOException {
        Context contextM1378b = C0213f.m1378b();
        Context contextM1377a = C0213f.m1377a();
        if (contextM1378b != null && contextM1377a != null) {
            try {
                String canonicalPath = contextM1378b.getCacheDir().getCanonicalPath();
                String strM63452a = C10279b.m63452a(C10278a.m63441g(contextM1377a.getFilesDir(), "cloudbackup"));
                String str = strM63452a + File.separator + "com.huawei.hidisk.txt";
                int brief = new BackupRestoreUtil(contextM1378b, strM63452a).getBrief(CloudBackupConstant.Command.PMS_OPTION_DIR, canonicalPath, str);
                File fileM63442h = C10278a.m63442h(str);
                if (fileM63442h.exists() && !fileM63442h.delete()) {
                    C11839m.m70689w("CloudBackupV3Utils", "delete cache failed, " + str);
                }
                if (brief == -3) {
                    C11839m.m70688i("CloudBackupV3Utils", "PMS not support get biref cmd");
                    return false;
                }
                C11839m.m70688i("CloudBackupV3Utils", "PMS support get biref cmd");
                return true;
            } catch (IOException e10) {
                C11839m.m70687e("CloudBackupV3Utils", "isPmsSupportGetBriefCmd error: " + e10.getMessage());
            }
        }
        return false;
    }

    /* renamed from: s2 */
    public static C13029h m75902s2() {
        C13029h c13029hM78495f;
        try {
            c13029hM78495f = new C13030i().m78495f(1);
        } catch (C9721b e10) {
            C11839m.m70687e("CloudBackupV3Utils", "queryManualBackupTagsV3 error: " + e10.getMessage());
            c13029hM78495f = null;
        }
        if (m75929z1(c13029hM78495f)) {
            return c13029hM78495f;
        }
        return null;
    }

    /* renamed from: t */
    public static String m75903t(String str) {
        if (!C0234s.m1643u() || str == null || str.isEmpty()) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder(str);
        int length = sb2.length();
        if (sb2.length() < 1) {
            return str;
        }
        int i10 = length - 1;
        if (sb2.charAt(i10) == 3853) {
            if (length >= 3 && sb2.charAt(length - 2) == 3851 && sb2.charAt(length - 3) == 3908) {
                sb2.deleteCharAt(i10);
            } else {
                sb2.setCharAt(i10, (char) 3851);
            }
        } else if (sb2.charAt(i10) == 3904 || sb2.charAt(i10) == 3906) {
            sb2.append((char) 3851);
        }
        return sb2.toString();
    }

    /* renamed from: t0 */
    public static List<BackupOptionItem> m75904t0(Context context, List<BackupOptionItem> list) {
        if (list == null) {
            C11839m.m70688i("CloudBackupV3Utils", "getRefurbishImportantApps: backupOptionItems is null.");
            return null;
        }
        final List<String> listM75424v0 = new C12526j().m75424v0(context);
        if (!listM75424v0.isEmpty()) {
            return (List) ((List) list.stream().filter(new Predicate() { // from class: rm.z
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return C12590s0.m75780O1((BackupOptionItem) obj);
                }
            }).collect(Collectors.toList())).stream().filter(new Predicate() { // from class: rm.j0
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return C12590s0.m75788Q1(listM75424v0, (BackupOptionItem) obj);
                }
            }).collect(Collectors.toList());
        }
        C11839m.m70688i("CloudBackupV3Utils", "getRefurbishImportantApps: no config data.");
        return null;
    }

    /* renamed from: t1 */
    public static boolean m75905t1(PmsMeta pmsMeta, boolean z10, boolean z11, long j10) {
        if (!m75913v1(z10, z11) || pmsMeta == null || TextUtils.isEmpty(pmsMeta.getName()) || 1 == pmsMeta.getIsdir()) {
            return false;
        }
        String name = pmsMeta.getName();
        if (name.endsWith(".dbsplite") || name.endsWith(".differencepacket") || name.endsWith(".dbhashfile")) {
            return false;
        }
        C11839m.m70686d("CloudBackupV3Utils", "isSoftLinkUploadFile meta size:" + pmsMeta.getSize() + " left space:" + ICBUtil.getLocalLeftSpace() + " reservedSize:" + j10);
        return pmsMeta.getSize() >= ICBUtil.getLocalLeftSpace().longValue() - Math.max(j10, 314572800L);
    }

    /* renamed from: t2 */
    public static String m75906t2() {
        String str;
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Bundle bundle = new Bundle();
        C12515a.m75110o().m75172d(new a(countDownLatch, bundle));
        int i10 = 0;
        while (true) {
            if (i10 >= 20) {
                str = null;
                break;
            }
            try {
            } catch (InterruptedException e10) {
                C11839m.m70688i("CloudBackupV3Utils", "querySafeBoxDataIntegrity await error: " + e10);
            }
            if (countDownLatch.await(500L, TimeUnit.MILLISECONDS)) {
                str = (String) bundle.get(CloudBackupConstant.DATA_INTEGRITY);
                break;
            }
            continue;
            i10++;
        }
        if (countDownLatch.getCount() > 0) {
            C11839m.m70688i("CloudBackupV3Utils", "querySafeBoxDataIntegrity time out.");
            C12515a.m75110o().m75166b(a.class.getName());
        }
        if (str == null || str.isEmpty()) {
            str = FaqConstants.DISABLE_HA_REPORT;
        }
        C11839m.m70688i("CloudBackupV3Utils", "querySafeBoxDataIntegrity dataIntegrity = " + str);
        return str;
    }

    /* renamed from: u */
    public static List<HashMap<String, Integer>> m75907u(List<C11723d> list) {
        ArrayList arrayList = new ArrayList();
        for (C11723d c11723d : list) {
            HashMap map = new HashMap();
            map.put(c11723d.m69946a(), c11723d.m69947b());
            arrayList.add(map);
        }
        return arrayList;
    }

    /* renamed from: u0 */
    public static long m75908u0() {
        List<BackupOptionItem> listM78397u = new C13026e(true).m78397u();
        long j10 = 0;
        if (listM78397u != null && !listM78397u.isEmpty()) {
            for (BackupOptionItem backupOptionItem : listM78397u) {
                if (backupOptionItem.getBackupSwitch()) {
                    long dataBytes = backupOptionItem.getDataBytes();
                    C11839m.m70686d("CloudBackupV3Utils", "calculate module size, module: " + backupOptionItem.getAppId() + ", data size: " + dataBytes);
                    j10 += dataBytes;
                }
            }
        }
        return j10;
    }

    /* renamed from: u1 */
    public static boolean m75909u1(String str) {
        return str == null || str.isEmpty();
    }

    /* renamed from: u2 */
    public static C11724e m75910u2(String str, String str2) {
        SnapshotTreeManagementService snapshotTreeManagementService = SnapshotTreeManagementService.getInstance();
        if (!snapshotTreeManagementService.existSnapshotDataBase(str)) {
            return null;
        }
        try {
            SnapshotBackupMetaOperator snapshotBackupMetaOperator = new SnapshotBackupMetaOperator(str);
            SnapshotBackupMeta snapshotBackupMetaQueryRootNodeMeta = snapshotBackupMetaOperator.queryRootNodeMeta(str2);
            int status = snapshotBackupMetaQueryRootNodeMeta.getStatus();
            C11724e c11724e = new C11724e();
            c11724e.m69953d(str2);
            c11724e.m69955f(status);
            long j10 = 0;
            if (status == 4) {
                c11724e.m69954e(snapshotBackupMetaOperator.queryMkfileSizeByAppIdExcludeApk(snapshotBackupMetaQueryRootNodeMeta.getAppId()));
                if (snapshotBackupMetaQueryRootNodeMeta.is3rd()) {
                    long size = snapshotBackupMetaQueryRootNodeMeta.getSize() - snapshotTreeManagementService.queryAppApkFile(str2, str).getSize();
                    if (size >= 0) {
                        j10 = size;
                    }
                    snapshotBackupMetaQueryRootNodeMeta.setSize(j10);
                }
                c11724e.m69956g(snapshotBackupMetaQueryRootNodeMeta.getSize());
                return c11724e;
            }
            if (status != 5 && status != 6) {
                return null;
            }
            if (snapshotBackupMetaQueryRootNodeMeta.is3rd()) {
                long size2 = snapshotBackupMetaQueryRootNodeMeta.getSize() - snapshotTreeManagementService.queryAppApkFile(str2, str).getSize();
                if (size2 >= 0) {
                    j10 = size2;
                }
                snapshotBackupMetaQueryRootNodeMeta.setSize(j10);
            }
            c11724e.m69954e(snapshotBackupMetaQueryRootNodeMeta.getSize());
            c11724e.m69956g(snapshotBackupMetaQueryRootNodeMeta.getSize());
            return c11724e;
        } catch (C9721b e10) {
            C11839m.m70689w("CloudBackupV3Utils", "query record size error: " + e10.getMessage());
            return null;
        }
    }

    /* renamed from: v */
    public static String m75911v(Collection<String> collection, Context context) {
        if (collection.isEmpty()) {
            C11839m.m70688i("CloudBackupV3Utils", "appendSlightPauseMark: the orgData is empty.");
            return "";
        }
        int size = collection.size();
        C11839m.m70688i("CloudBackupV3Utils", "appendSlightPauseMark: the orgData size is :" + size);
        Object[] array = collection.toArray(new Object[0]);
        if (array.length == 1) {
            return array[0].toString();
        }
        return context.getResources().getString(size >= 7 ? Constant.m16241a().get(8).intValue() : Constant.m16241a().get(Integer.valueOf(size)).intValue(), array);
    }

    /* renamed from: v0 */
    public static String m75912v0(Context context, List<BackupOptionItem> list) {
        List<String> listM75743F0 = m75743F0(context, list);
        if (listM75743F0.isEmpty()) {
            C11839m.m70688i("CloudBackupV3Utils", "getRefurbishTwinAppTips: no twin apps.");
            return null;
        }
        return context.getResources().getString(R$string.refurbish_twin_app_notice_title, m75911v(listM75743F0, context));
    }

    /* renamed from: v1 */
    public static boolean m75913v1(boolean z10, boolean z11) {
        if (m75889p1(z10, z11)) {
            return PmsUtils.isSupportPMSFastCopy();
        }
        return false;
    }

    /* renamed from: v2 */
    public static C11724e m75914v2(String str, String str2, int i10) {
        if (!C13617a.m81938t(str, str2, 0, i10)) {
            return null;
        }
        C11724e c11724e = new C11724e();
        c11724e.m69953d(str2);
        c11724e.m69956g(C12594t1.m75990o().m76014q(str2, str, i10));
        c11724e.m69954e(C12594t1.m75990o().m76019v(str2, str, i10));
        if (c11724e.m69952c() > 0 && c11724e.m69952c() == c11724e.m69950a()) {
            c11724e.m69955f(6);
        } else if (c11724e.m69950a() > 0) {
            c11724e.m69955f(4);
        } else {
            c11724e.m69955f(0);
        }
        return c11724e;
    }

    /* renamed from: w */
    public static void m75915w(BackupOptionItem backupOptionItem, boolean z10, C11725f c11725f) {
        m75919x(backupOptionItem, z10, c11725f, null);
    }

    /* renamed from: w0 */
    public static String m75916w0(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            int length = str.length();
            StringBuilder sb2 = new StringBuilder();
            for (int i10 = 0; i10 < length / 2; i10++) {
                sb2.append("*");
            }
            return str.substring(0, length / 2) + ((Object) sb2);
        } catch (Exception e10) {
            C11839m.m70688i("CloudBackupV3Utils", "getReportMsg error: " + e10);
            return "";
        }
    }

    /* renamed from: w1 */
    public static boolean m75917w1(String str, int i10, String str2, String str3) {
        if ("1".equals(str3)) {
            String strM75714e = C12586r.m75714e(str, i10);
            if (!TextUtils.isEmpty(strM75714e) && !TextUtils.isEmpty(str2) && str2.startsWith(strM75714e)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: w2 */
    public static void m75918w2(CloudBackupStatus cloudBackupStatus) {
        if (cloudBackupStatus == null) {
            C11839m.m70689w("CloudBackupV3Utils", "reportBundleRenameOk backupStatus or statusLock is empty");
            return;
        }
        synchronized (f57969b) {
            Map<String, String> mapM75858h2 = m75858h2(cloudBackupStatus.m29393b1());
            mapM75858h2.put("isCitOpt", String.valueOf(true));
            cloudBackupStatus.m29401e2(m75846e2(mapM75858h2));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0035  */
    /* renamed from: x */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m75919x(com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem r6, boolean r7, p495nm.C11725f r8, java.util.Map<java.lang.String, com.huawei.hicloud.cloudbackup.model.CloudRestoreItem> r9) {
        /*
            r0 = 0
            if (r8 == 0) goto L37
            long r2 = m75848f0(r6, r8, r9, r7)
            java.lang.String r7 = r8.m69957a()
            java.lang.String r9 = r6.getAppId()
            int r4 = r6.getUid()
            java.util.Map r8 = r8.m69959c()
            nm.e r7 = m75878m2(r7, r9, r4, r8)
            if (r7 == 0) goto L35
            int r8 = r7.m69951b()
            r9 = 4
            if (r8 == r9) goto L2e
            r7 = 5
            if (r8 == r7) goto L2c
            r7 = 6
            if (r8 == r7) goto L2c
            goto L35
        L2c:
            r7 = r0
            goto L4e
        L2e:
            long r7 = r7.m69950a()
            long r7 = r2 - r7
            goto L4e
        L35:
            r7 = r2
            goto L4e
        L37:
            long r2 = r6.getDataBytes()
            long r8 = r6.getDataBytes()
            if (r7 == 0) goto L4d
            long r4 = r6.getCodeBytes()
            long r2 = r2 + r4
            long r4 = r6.getCodeBytes()
            long r7 = r8 + r4
            goto L4e
        L4d:
            r7 = r8
        L4e:
            int r9 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r9 >= 0) goto L53
            r2 = r0
        L53:
            int r9 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r9 >= 0) goto L58
            goto L59
        L58:
            r0 = r7
        L59:
            r6.setTotalIncrease(r2)
            r6.setCurrentIncrease(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p618rm.C12590s0.m75919x(com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem, boolean, nm.f, java.util.Map):void");
    }

    /* renamed from: x0 */
    public static String m75920x0(String str, String str2, String str3, boolean z10, CloudBackupAppDataUtil cloudBackupAppDataUtil, BackupDataAcptErrPolicy.Policy policy, String str4) throws C9721b {
        PmsFullBriefFilesInfoOperatorV3 pmsFullBriefFilesInfoOperatorV3 = new PmsFullBriefFilesInfoOperatorV3(str3);
        List<PmsMeta> listQueryMetasByIsvalid = pmsFullBriefFilesInfoOperatorV3.queryMetasByIsvalid(1);
        List<PmsMeta> listQueryMetasByIsvalid2 = pmsFullBriefFilesInfoOperatorV3.queryMetasByIsvalid(2);
        int size = listQueryMetasByIsvalid != null ? listQueryMetasByIsvalid.size() : 0;
        int size2 = listQueryMetasByIsvalid2 != null ? listQueryMetasByIsvalid2.size() : 0;
        long jQueryCount = pmsFullBriefFilesInfoOperatorV3.queryCount();
        int i10 = size + size2;
        float f10 = jQueryCount != 0 ? (i10 / jQueryCount) * 100.0f : 0.0f;
        C11839m.m70688i("CloudBackupV3Utils", "isNeedReprocessPmsBriefFileV3: prorate = " + f10);
        if (f10 <= 0.0f) {
            C11839m.m70688i("CloudBackupV3Utils", "isNeedReprocessPmsBriefFileV3: false, prorate = 0,");
            return "";
        }
        C12526j c12526j = new C12526j();
        int[] iArrM75818Y = m75818Y(str2, c12526j);
        int i11 = iArrM75818Y[0];
        int i12 = iArrM75818Y[1];
        List<String> listM75360S = c12526j.m75360S();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("isNeedReprocessPmsBriefFileV3 dataAcptErrNum: ");
        sb2.append(i11);
        sb2.append(", dataAcptErrRate: ");
        sb2.append(i12);
        float f11 = f10;
        sb2.append(", changeMetasCount: ");
        sb2.append(size);
        sb2.append(", deleteMetasCount: ");
        sb2.append(size2);
        C11839m.m70688i("CloudBackupV3Utils", sb2.toString());
        String strM75734D = m75734D(policy, str4, listQueryMetasByIsvalid, listQueryMetasByIsvalid2);
        if (!TextUtils.isEmpty(strM75734D)) {
            return strM75734D;
        }
        if (listM75360S == null || listM75360S.isEmpty()) {
            C11839m.m70688i("CloudBackupV3Utils", "isNeedReprocessPmsBriefFileV3 dataErrAppList is null");
        } else if (listM75360S.contains(str2) || listM75360S.contains("*")) {
            C11839m.m70688i("CloudBackupV3Utils", "isNeedReprocessPmsBriefFileV3 dataAcptErrNum: " + i11 + ", dataAcptErrRate: " + i12 + ", count: " + i10 + ", prorate: " + f11);
            if (i10 <= i11 && f11 <= i12) {
                if (z10 && m75762K(str, listQueryMetasByIsvalid, listQueryMetasByIsvalid2, cloudBackupAppDataUtil)) {
                    m75922x2(str4, null, listQueryMetasByIsvalid, listQueryMetasByIsvalid2, "diff file changed");
                    return "diff file changed";
                }
                C11839m.m70688i("CloudBackupV3Utils", "isNeedReprocessPmsBriefFileV3: false");
                return strM75734D;
            }
            C11839m.m70688i("CloudBackupV3Utils", "isNeedReprocessPmsBriefFileV3 prorate is illegal");
        } else {
            C11839m.m70688i("CloudBackupV3Utils", "isNeedReprocessPmsBriefFileV3: dataErrAppList not contains " + str + ", dataErrAppList: " + listM75360S);
        }
        String str5 = "file changed: " + size + " or delete: " + size2 + " all: " + jQueryCount;
        m75922x2(str4, null, listQueryMetasByIsvalid, listQueryMetasByIsvalid2, str5);
        C11839m.m70688i("CloudBackupV3Utils", "isNeedReprocessPmsBriefFileV3: true");
        return str5;
    }

    /* renamed from: x1 */
    public static boolean m75921x1(String str) {
        return TextUtils.isEmpty(str) || "V1".equalsIgnoreCase(str);
    }

    /* renamed from: x2 */
    public static void m75922x2(String str, List<PmsMeta> list, List<PmsMeta> list2, List<PmsMeta> list3, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            com.huawei.android.hicloud.cloudbackup.report.CloudBackupReport.reportBackupDataAcptErrInfo(list, list2, list3, str2, str);
        } catch (Exception e10) {
            C11839m.m70687e("CloudBackupV3Utils", "reportBackupDataAcptErrInfo error: " + e10.getMessage());
        }
    }

    /* renamed from: y */
    public static C11726g m75923y(boolean z10) {
        return m75927z(z10, new ArrayList());
    }

    /* renamed from: y0 */
    public static String m75924y0(C13029h c13029h) {
        if (c13029h == null || TextUtils.isEmpty(c13029h.m78488y()) || !c13029h.m78488y().contains("_V3_")) {
            return "";
        }
        C11839m.m70686d("CloudBackupV3Utils", "deviceId contains suffix v3");
        return c13029h.m78488y().split("_V3_")[1];
    }

    /* renamed from: y1 */
    public static boolean m75925y1(String str) {
        return "V2".equalsIgnoreCase(str);
    }

    /* renamed from: y2 */
    public static void m75926y2(String str, String str2, String str3) {
        String strM16147i = C2783d.m16147i(C0213f.m1377a(), C0212e0.m1360j(C0213f.m1377a(), "com.huawei.android.ds_spcace_detail_cache", "total_size", 0L));
        int iM75751H0 = m75751H0();
        C11060c c11060cM66626a = C11058a.m66626a(str, "reportGradeCodeRequest", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("010_200");
        String str4 = "reportGradeCodeRequest, gradeCode : " + str2 + " , scene : " + str3 + " , totalSize : " + strM16147i + " , times : " + iM75751H0 + " , traceId : " + str;
        c11060cM66626a.m66635A(str4);
        C13622a.m81968n(C0213f.m1377a(), c11060cM66626a);
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("param_request_gradecode_value", str2);
        linkedHashMapM79497A.put("param_request_gradecode_scene", str3);
        linkedHashMapM79497A.put("param_request_gradecode_totalSize", strM16147i);
        linkedHashMapM79497A.put("param_request_gradecode_times", String.valueOf(iM75751H0));
        linkedHashMapM79497A.put("param_request_gradecode_traceId", str);
        C13225d.m79490f1().m79567R("event_request_gradecode", linkedHashMapM79497A);
        UBAAnalyze.m29947H("CKC", "event_request_gradecode", linkedHashMapM79497A);
        C11839m.m70688i("CloudBackupV3Utils", str4);
    }

    /* renamed from: z */
    public static C11726g m75927z(boolean z10, List<String> list) {
        return m75722A(z10, false, list, new C13026e());
    }

    /* renamed from: z0 */
    public static String m75928z0(C13029h c13029h) {
        if (c13029h == null || TextUtils.isEmpty(c13029h.m78488y())) {
            return "";
        }
        String strM78488y = c13029h.m78488y();
        return strM78488y.contains("_V3_") ? strM78488y.split("_V3_")[0] : strM78488y;
    }

    /* renamed from: z1 */
    public static boolean m75929z1(C13029h c13029h) {
        if (c13029h == null || TextUtils.isEmpty(c13029h.m78488y())) {
            return false;
        }
        return c13029h.m78488y().startsWith("V3_");
    }

    /* renamed from: z2 */
    public static void m75930z2(String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(C2126b.ERROR_MESSAGE_INFO, str);
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("02314"), "error_during_handling_no_space", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("010_200");
        C13622a.m81969o(C0213f.m1377a(), c11060cM66626a, linkedHashMap);
        UBAAnalyze.m29947H("CKC", "error_during_handling_no_space", linkedHashMap);
    }
}
