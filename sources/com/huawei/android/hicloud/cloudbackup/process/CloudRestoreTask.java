package com.huawei.android.hicloud.cloudbackup.process;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import cl.InterfaceC1450e;
import cl.InterfaceC1452g;
import com.huawei.android.backup.filelogic.utils.PmsCheckUtil;
import com.huawei.android.backup.service.utils.C2157a;
import com.huawei.android.hicloud.cloudbackup.bean.RefurbishRestoreFailInfo;
import com.huawei.android.hicloud.cloudbackup.bean.RestoreModuleReportInfo;
import com.huawei.android.hicloud.cloudbackup.broadcast.ICBBroadcastManager;
import com.huawei.android.hicloud.cloudbackup.jobscheduler.CloudBackupJobManager;
import com.huawei.android.hicloud.cloudbackup.manager.CloudBackupTaskManager;
import com.huawei.android.hicloud.cloudbackup.model.RestoreCache;
import com.huawei.android.hicloud.cloudbackup.p076db.temp.AlbumsTempDBManager;
import com.huawei.android.hicloud.cloudbackup.p076db.temp.AlbumsTempOperator;
import com.huawei.android.hicloud.cloudbackup.process.CacheTask;
import com.huawei.android.hicloud.cloudbackup.process.CloneService;
import com.huawei.android.hicloud.cloudbackup.process.task.CloudRestoreOneModuleTask;
import com.huawei.android.hicloud.cloudbackup.process.util.BackupRestoreUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.ScanAppDataUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.TarFileUtil;
import com.huawei.android.hicloud.cloudbackup.progress.RestoreProgress;
import com.huawei.android.hicloud.cloudbackup.progress.RestoreProgressManager;
import com.huawei.android.hicloud.cloudbackup.provider.QueryAppRestoreFromProvider;
import com.huawei.android.hicloud.cloudbackup.report.CloudBackupReport;
import com.huawei.android.hicloud.cloudbackup.restore.CloudRestoreClient;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.bean.SnapshotBackupMeta;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.operator.SnapshotBackupMetaOperator;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackupStateUtil;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.android.hicloud.p088ui.notification.RestoreNotification;
import com.huawei.android.remotecontrol.tag.p092ui.view.RippleView;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.cloudbackup.model.RestoreStatus;
import com.huawei.hicloud.cloudbackup.store.database.tags.CloudRestoreStatus;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.request.cbs.bean.CBSAppInfo;
import com.huawei.hicloud.request.cbs.bean.CBSBackupRecord;
import com.huawei.hicloud.request.cbs.bean.CBSFileInfo;
import com.huawei.hicloud.request.opengw.bean.Result;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.openalliance.p169ad.constant.ParamConstants;
import fk.C9721b;
import hk.C10278a;
import hk.C10279b;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import je.C10782d;
import mk.C11477c;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0221j;
import p015ak.C0240y;
import p015ak.C0241z;
import p429kk.C11058a;
import p429kk.C11060c;
import p458lo.C11322a;
import p514o9.C11829c;
import p514o9.C11835i;
import p514o9.C11839m;
import p617rl.C12521e;
import p617rl.C12522f;
import p617rl.C12526j;
import p618rm.C12565k;
import p618rm.C12571m;
import p618rm.C12574n;
import p618rm.C12580p;
import p618rm.C12583q;
import p618rm.C12590s0;
import p652t9.EnumC12999a;
import p684un.C13225d;
import p709vj.C13452e;
import p711vl.C13465e;
import p711vl.C13466f;
import p744wl.C13617a;
import p746wn.C13622a;
import p771xd.C13757a;
import p847zk.C14317j;
import p848zl.C14333b;
import p851zp.InterfaceC14355b;
import pl.C12168j;
import pl.C12169k;
import pm.C12187n;
import pm.C12188o;
import tl.C13027f;
import tl.C13028g;
import tl.C13029h;
import tl.C13030i;
import tl.C13035n;
import to.C13049a;

/* loaded from: classes2.dex */
public class CloudRestoreTask extends ICBBaseTask {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String MYHUAWEI_TAG = "_myhuawei";
    public static final String REFURBISHMENT_TAG = "_refurbishment";
    private static final String TAG = "CloudRestoreTask";
    public List<String> appRestoreOrderFromLauncher;
    private C13027f backupRecordInfoOperator;
    private ConcurrentHashMap<String, CloudRestoreStatus> caches;
    private String entranceOfRestore;
    private int entryType;
    private Queue<CloudRestoreStatus> firstQueue;
    private CloudRestoreStatus galleryReports;
    private C13049a gwService;
    private List<String> installedApkList;
    private final boolean isAuto;
    private boolean isFirstStage;
    private boolean isLauncherLayoutOk;
    private boolean isLauncherRestore;
    private boolean isLauncherSupported;
    private volatile boolean isModuleIgnoreRetryErr;
    private boolean isPrepareError;
    private boolean isRefurbishment;
    protected boolean isRestoringThirdApp;
    private boolean isResumeRetry;
    private boolean isRetry;
    private Queue<CloudRestoreStatus> lastPreQueue;
    private Queue<CloudRestoreStatus> lastQueue;
    private Queue<CloudRestoreStatus> lastSufQueue;
    private long lastnotifytime;
    private CloudRestoreStatus launcherStatus;
    private long localLeftBytes;
    private CloudRestoreClient restoreClient;
    private C13028g restoreRecordInfos;
    private long restoreSize;
    protected List<String> restoreSystemModulesOne;
    protected List<String> restoreSystemModulesTwoFirst;
    private C11322a service;
    private C13035n statusOperator;
    private List<CloudRestoreStatus> successStatusList;
    private final Object syncLockForHwLauncher;
    private C13029h tags;
    private List<CloudRestoreStatus> thirdApplist;
    private long totalRestoreSize;
    private static final Object CHECK_CEXCEPTION = new Object();
    private static final Object WAIT_LOCK = new Object();

    /* renamed from: com.huawei.android.hicloud.cloudbackup.process.CloudRestoreTask$1 */
    public class C25031 implements CloneService.CloneCallback {
        final /* synthetic */ String val$appId;
        final /* synthetic */ CloudRestoreStatus val$status;

        public C25031(String str, CloudRestoreStatus cloudRestoreStatus) {
            str = str;
            cloudRestoreStatus = cloudRestoreStatus;
        }

        @Override // com.huawei.android.hicloud.cloudbackup.process.CloneService.CloneCallback
        public void onCallback(Message message, int i10) {
            CloudRestoreTask.this.cloneRestoreCallback(message, cloudRestoreStatus, i10);
        }

        @Override // com.huawei.android.hicloud.cloudbackup.process.CloneService.CloneCallback
        public void onError(int i10) {
            C11839m.m70688i(CloudRestoreTask.TAG, "onError appId" + str + " code = " + i10);
            CloudRestoreTask.this.cloneError(i10, cloudRestoreStatus);
        }
    }

    public static class GetLastSuccessTimeAsyncTask implements CacheTask.IAsyncTask {
        @Override // com.huawei.android.hicloud.cloudbackup.process.CacheTask.IAsyncTask
        public void run() {
            RestoreUtil.setLastSuccessTime();
        }
    }

    public CloudRestoreTask(String str, int i10, String str2, int i11, boolean z10, boolean z11, boolean z12) {
        super(str, i10);
        this.isLauncherLayoutOk = false;
        this.syncLockForHwLauncher = new Object();
        this.appRestoreOrderFromLauncher = new ArrayList();
        this.firstQueue = new ConcurrentLinkedDeque();
        this.lastPreQueue = new ConcurrentLinkedDeque();
        this.lastQueue = new ConcurrentLinkedDeque();
        this.lastSufQueue = new ConcurrentLinkedDeque();
        this.thirdApplist = new ArrayList();
        this.successStatusList = new ArrayList();
        this.isResumeRetry = false;
        this.isLauncherRestore = false;
        this.restoreSize = 0L;
        this.totalRestoreSize = 0L;
        this.isPrepareError = true;
        this.restoreClient = new CloudRestoreClient();
        this.statusOperator = new C13035n();
        this.isFirstStage = true;
        this.installedApkList = new ArrayList();
        this.restoreRecordInfos = new C13028g();
        this.backupRecordInfoOperator = new C13027f();
        this.isRefurbishment = false;
        this.isModuleIgnoreRetryErr = false;
        this.caches = new ConcurrentHashMap<>();
        this.restoreSystemModulesOne = new ArrayList();
        this.restoreSystemModulesTwoFirst = new ArrayList();
        this.backupId = str2;
        this.entryType = i11;
        this.isRetry = z10;
        this.traceID = C11058a.m66627b("02003");
        this.service = new C11322a(this.traceID);
        this.gwService = new C13049a(EnumC12999a.CLOUD_BACKUP, this.traceID);
        this.isResumeRetry = z11;
        this.isAuto = z12;
    }

    private void addDownloadTask(CloudRestoreStatus cloudRestoreStatus) {
        String appId = cloudRestoreStatus.getAppId();
        C11839m.m70688i(TAG, "addDownloadTask appId: " + appId);
        CloudBackupTaskManager.getInstance().addModuleTask(appId, new CloudRestoreOneModuleTask(this, cloudRestoreStatus, this.progressCallback, this.traceID, this.location, this.serverPath, this.isLauncherSupported, this.installAppPath, initCompares(appId)));
        this.modules.add(appId);
    }

    private void addFirstQueue(List<CloudRestoreStatus> list) {
        ArrayList arrayList = new ArrayList();
        long j10 = 0;
        long j11 = 0;
        for (CloudRestoreStatus cloudRestoreStatus : list) {
            if (cloudRestoreStatus == null) {
                C11839m.m70689w(TAG, "addFirstQueue status is null.");
            } else {
                long size = cloudRestoreStatus.getSize() + cloudRestoreStatus.getAsize();
                this.totalRestoreSize += size;
                String appId = cloudRestoreStatus.getAppId();
                if (cloudRestoreStatus.isUnSupport()) {
                    C11839m.m70688i(TAG, "skip unsupported appId: " + appId);
                } else {
                    int status = cloudRestoreStatus.getStatus();
                    if (status != 1 && status != 2 && status != 8) {
                        j10 += size;
                        if (this.restoreSystemModulesOne.contains(appId)) {
                            j11 += size;
                        }
                    }
                    if (this.restoreSystemModulesOne.contains(appId)) {
                        this.firstQueue.add(cloudRestoreStatus);
                        arrayList.add(appId);
                    }
                }
            }
        }
        RestoreProgressManager.getInstance().setContentLength(j10);
        RestoreProgressManager.getInstance().setFirstContentLength(j11);
        RestoreProgressManager.getInstance().setFirstCount(this.firstQueue.size());
        RestoreProgressManager.getInstance().setRestoreFirstData(arrayList);
    }

    private void addSecondQueue(List<CloudRestoreStatus> list) {
        List<String> list2 = this.restoreSystemModulesTwoFirst;
        List<String> listM85489x = C14333b.m85489x();
        for (CloudRestoreStatus cloudRestoreStatus : list) {
            if (!cloudRestoreStatus.isUnSupport()) {
                String appId = cloudRestoreStatus.getAppId();
                if (list2.contains(appId)) {
                    this.lastPreQueue.add(cloudRestoreStatus);
                }
                if ("HWlanucher".equals(appId)) {
                    this.launcherStatus = cloudRestoreStatus;
                } else {
                    if (listM85489x.contains(appId)) {
                        this.lastSufQueue.add(cloudRestoreStatus);
                    }
                    if (!this.defaultModules.contains(appId)) {
                        if (HNConstants.DataType.MEDIA.equals(appId)) {
                            this.galleryReports = cloudRestoreStatus;
                            this.lastPreQueue.add(cloudRestoreStatus);
                        } else if ("music".equals(appId)) {
                            this.lastPreQueue.add(cloudRestoreStatus);
                        } else if (cloudRestoreStatus.is3rdAppType()) {
                            this.lastQueue.add(cloudRestoreStatus);
                            this.thirdApplist.add(cloudRestoreStatus);
                        } else {
                            this.lastPreQueue.add(cloudRestoreStatus);
                        }
                    }
                }
            }
        }
        this.isLauncherSupported = this.launcherStatus != null && QueryAppRestoreFromProvider.checkPrioritRestoreIcon(CacheTask.getContext());
    }

    private void adjustThirdAppSequence() throws C9721b {
        try {
            List<String> listQueryRestoreAppsOrders = QueryAppRestoreFromProvider.queryRestoreAppsOrders(CacheTask.getContext());
            this.appRestoreOrderFromLauncher = listQueryRestoreAppsOrders;
            if (listQueryRestoreAppsOrders == null) {
                this.appRestoreOrderFromLauncher = new ArrayList();
            }
            if (this.appRestoreOrderFromLauncher.isEmpty()) {
                return;
            }
            List list = (List) this.thirdApplist.stream().filter(new Predicate() { // from class: com.huawei.android.hicloud.cloudbackup.process.l0
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return CloudRestoreTask.lambda$adjustThirdAppSequence$6((CloudRestoreStatus) obj);
                }
            }).collect(Collectors.toList());
            List list2 = (List) this.thirdApplist.stream().filter(new Predicate() { // from class: com.huawei.android.hicloud.cloudbackup.process.m0
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return CloudRestoreTask.lambda$adjustThirdAppSequence$7((CloudRestoreStatus) obj);
                }
            }).sorted(new Comparator() { // from class: com.huawei.android.hicloud.cloudbackup.process.n0
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return this.f11704a.lambda$adjustThirdAppSequence$8((CloudRestoreStatus) obj, (CloudRestoreStatus) obj2);
                }
            }).collect(Collectors.toList());
            this.thirdApplist.clear();
            this.thirdApplist.addAll(list2);
            this.thirdApplist.addAll(list);
            refresh3rdLauncherFlag();
        } catch (Exception unused) {
            C11839m.m70687e(TAG, "adjustThirdAppSequence queryRestoreAppsOrders failed.");
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "queryRestoreAppsOrders failed", "CloudRestore_threadRestoreProcess");
        }
    }

    private void checkAppRiskInfo(Bundle bundle) throws InterruptedException, C9721b {
        ArrayList<String> stringArrayList;
        isCancel();
        if (bundle == null || (stringArrayList = bundle.getStringArrayList("RiskAppPackageNameList")) == null) {
            return;
        }
        Iterator<String> it = stringArrayList.iterator();
        while (it.hasNext()) {
            this.statusOperator.m78558j(it.next(), -1, 0);
        }
    }

    private void checkBundleAppSupport(CloudRestoreStatus cloudRestoreStatus) {
        if (cloudRestoreStatus.is3rdAppType() && cloudRestoreStatus.m29529P()) {
            cloudRestoreStatus.m29532S();
        }
    }

    private void checkHarmonyAppSupport(CloudRestoreStatus cloudRestoreStatus) {
        if (cloudRestoreStatus.is3rdAppType() && cloudRestoreStatus.m29531R() && cloudRestoreStatus.m29532S()) {
            boolean zM13176K = C2157a.m13176K();
            C11839m.m70688i(TAG, "check harmony support: " + zM13176K + ", appId: " + cloudRestoreStatus.getAppId());
            if (zM13176K) {
                return;
            }
            cloudRestoreStatus.setStatus(-4);
        }
    }

    private void checkRetryCount() {
        C13029h c13029h;
        if (!this.isRetry || this.isResumeRetry || (c13029h = this.tags) == null) {
            C11839m.m70689w(TAG, "checkRetryCount !isRetry || isResumeRetry || tags == null");
            return;
        }
        if (c13029h.m78441G() == 4) {
            C11839m.m70688i(TAG, "checkRetryCount restore done");
            return;
        }
        if (isNeedCount()) {
            C13029h c13029h2 = this.tags;
            c13029h2.m78453S(c13029h2.m78476r() + 1);
            new C13030i().m78496g(this.tags);
        }
        new C12526j();
        if (ICBUtil.isRestoreRetryTimeExpires(this.tags.m78440F())) {
            updateTagsStatus(4);
        }
    }

    public void cloneError(int i10, CloudRestoreStatus cloudRestoreStatus) {
        if (i10 == 7) {
            cloudRestoreStatus.setStatus(-3);
            this.statusOperator.m78556h(cloudRestoreStatus);
            return;
        }
        if (i10 != 9 && i10 != 11 && i10 != 13 && i10 != 15) {
            if (i10 == 27) {
                cloudRestoreStatus.setStatus(-6);
                this.statusOperator.m78556h(cloudRestoreStatus);
                return;
            } else if (i10 != 36 && i10 != 1067) {
                return;
            }
        }
        if (cloudRestoreStatus.isUnSupport()) {
            return;
        }
        cloudRestoreStatus.setStatus(7).setType(2);
        this.statusOperator.m78556h(cloudRestoreStatus);
    }

    public void cloneRestoreCallback(Message message, CloudRestoreStatus cloudRestoreStatus, int i10) {
        int i11 = message.what;
        if (i11 == 1) {
            cloneRestoreSuccess(message, cloudRestoreStatus, i10);
            return;
        }
        if (i11 != 25) {
            return;
        }
        cloudRestoreStatus.setStatus(6).setType(1);
        this.statusOperator.m78556h(cloudRestoreStatus);
        ICBUtil.reportInstallEvent(cloudRestoreStatus.getAppId(), cloudRestoreStatus.getVersionCode(), cloudRestoreStatus.m29546t());
        this.installedApkList.add(cloudRestoreStatus.getAppId());
        sendOneModuleMessage(cloudRestoreStatus);
    }

    private void cloneRestoreSuccess(Message message, CloudRestoreStatus cloudRestoreStatus, int i10) {
        int i11 = message.arg1;
        int i12 = message.arg2;
        if (C14333b.m85490y().contains(cloudRestoreStatus.getAppId())) {
            i11++;
        }
        if (cloudRestoreStatus.is3rdAppType()) {
            return;
        }
        int iMin = Math.min(i12, cloudRestoreStatus.getCount());
        if (i10 > 0 && i10 <= i11) {
            i11 -= i10;
        }
        boolean z10 = i11 <= iMin && i11 >= cloudRestoreStatus.getCurrent();
        int i13 = iMin > 100 ? 50 : 10;
        if (z10) {
            if (i11 - cloudRestoreStatus.getCurrent() >= i13 || iMin < 10 || i11 == iMin) {
                if (cloudRestoreStatus.getType() != 2) {
                    cloudRestoreStatus.setType(1);
                }
                cloudRestoreStatus.setStatus(7).setCurrent(i11);
                this.statusOperator.m78560l(cloudRestoreStatus);
                sendOneModuleMessage(cloudRestoreStatus);
            }
        }
    }

    private void createBackupMetas(List<String> list) throws InterruptedException, C9721b {
        Iterator<Map<String, Object>> it;
        String str;
        String str2;
        C12168j c12168j;
        String str3;
        CloudRestoreTask cloudRestoreTask = this;
        if (list.isEmpty()) {
            return;
        }
        int size = list.size();
        long jM1688f = 0;
        long jM1688f2 = 0;
        int i10 = 0;
        int i11 = 0;
        while (i10 < size) {
            isCancel();
            int i12 = i11 * 200;
            int i13 = i12 + 200;
            if (i13 > size) {
                i13 = size;
            }
            ArrayList arrayList = new ArrayList();
            String str4 = "name";
            String str5 = "size";
            int i14 = size;
            int i15 = i13;
            long j10 = jM1688f;
            Result resultM78709H = cloudRestoreTask.gwService.m78709H((String[]) list.subList(i12, i13).toArray(new String[0]), new String[]{"name", "md5", "size", JsbMapKeyNames.H5_LOC, "encoded"});
            List<Map<String, Object>> successList = resultM78709H.getSuccessList();
            List<Result.ErrMsg> failList = resultM78709H.getFailList();
            if (!failList.isEmpty()) {
                cloudRestoreTask.recordFailList(failList);
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            Iterator<Map<String, Object>> it2 = successList.iterator();
            jM1688f = j10;
            while (it2.hasNext()) {
                Map<String, Object> next = it2.next();
                try {
                    c12168j = new C12168j();
                    str3 = (String) next.get(str4);
                    it = it2;
                } catch (Exception unused) {
                    it = it2;
                }
                try {
                    String strSubstring = str3.substring(cloudRestoreTask.serverPath.length());
                    String str6 = (String) next.get(JsbMapKeyNames.H5_LOC);
                    if (str6 == null || str6.isEmpty()) {
                        str = str4;
                        str2 = str5;
                    } else {
                        String str7 = (String) next.get(str5);
                        str = str4;
                        try {
                            str2 = str5;
                            try {
                                try {
                                    c12168j.m73189r(strSubstring.substring(0, strSubstring.indexOf("/")));
                                    c12168j.m73197z(str3);
                                    c12168j.m73164A(str6);
                                    c12168j.m73165B(C0241z.m1688f(str7));
                                    if (CacheTask.isEncrypt()) {
                                        int iLastIndexOf = strSubstring.lastIndexOf(95);
                                        c12168j.m73168E(iLastIndexOf > 0 ? strSubstring.substring(iLastIndexOf).replace("_", "") : "");
                                    } else {
                                        c12168j.m73167D((String) next.get("md5"));
                                    }
                                    c12168j.m73196y(String.valueOf(6));
                                } catch (Exception unused2) {
                                    C11839m.m70689w(TAG, "create backup meta error." + next);
                                    cloudRestoreTask = this;
                                    it2 = it;
                                    str4 = str;
                                    str5 = str2;
                                }
                            } catch (Exception unused3) {
                            }
                        } catch (Exception unused4) {
                            str2 = str5;
                            C11839m.m70689w(TAG, "create backup meta error." + next);
                            cloudRestoreTask = this;
                            it2 = it;
                            str4 = str;
                            str5 = str2;
                        }
                        try {
                            c12168j.m73170G(0);
                            String str8 = (String) next.get("encoded");
                            if (TextUtils.isEmpty(str8)) {
                                str8 = "0";
                            }
                            c12168j.m73195x(str8);
                            c12168j.m73166C(String.valueOf(jCurrentTimeMillis));
                            arrayList.add(c12168j);
                            if (str6.startsWith(ICBUtil.RELATIVE_SDCARD_PATH)) {
                                jM1688f += C0241z.m1688f(str7);
                            } else if (str6.startsWith(ICBUtil.RELATIVE_USB_PATH)) {
                                jM1688f2 += C0241z.m1688f(str7);
                            }
                        } catch (Exception unused5) {
                            C11839m.m70689w(TAG, "create backup meta error." + next);
                            cloudRestoreTask = this;
                            it2 = it;
                            str4 = str;
                            str5 = str2;
                        }
                    }
                } catch (Exception unused6) {
                    str = str4;
                    str2 = str5;
                    C11839m.m70689w(TAG, "create backup meta error." + next);
                    cloudRestoreTask = this;
                    it2 = it;
                    str4 = str;
                    str5 = str2;
                }
                cloudRestoreTask = this;
                it2 = it;
                str4 = str;
                str5 = str2;
            }
            new C12169k().batchReplace(arrayList);
            i11++;
            cloudRestoreTask = this;
            size = i14;
            i10 = i15;
        }
        C0221j.m1493c(jM1688f, jM1688f2, CacheTask.getContext());
    }

    private C13029h createTags() {
        C13029h c13029h = new C13029h(3, C11058a.m66627b("02010"));
        c13029h.m78460Z(C11477c.m68636f(this.deviceId));
        c13029h.m78467i0(this.deviceType);
        c13029h.m78448N(this.backupId);
        c13029h.m78477r0(0);
        String strValueOf = String.valueOf(this.entryType);
        if (5 == this.entryType) {
            strValueOf = strValueOf + MYHUAWEI_TAG;
        }
        if (this.isRefurbishment) {
            strValueOf = strValueOf + REFURBISHMENT_TAG;
        }
        c13029h.m78454T(strValueOf);
        long jCurrentTimeMillis = System.currentTimeMillis();
        c13029h.m78475q0(jCurrentTimeMillis);
        c13029h.m78447M(604800000 + jCurrentTimeMillis);
        c13029h.m78450P(jCurrentTimeMillis);
        c13029h.m78483u0(this.traceID);
        return c13029h;
    }

    private void deleteFile() {
        C11839m.m70688i(TAG, "delete cache file begin.");
        C13617a.m81932n(false);
        C12571m.m75547i(this.location);
        C12571m.m75547i(this.installAppPath);
        C12571m.m75547i(ICBUtil.getAndroidDataCacheRootPath());
        String[] list = C10278a.m63442h(this.location).list();
        if (list != null && list.length > 0) {
            C11839m.m70688i(TAG, "use pms move delete cache file.");
            ScanAppDataUtil.executePmsMoveProcess(this.location);
        }
        C11839m.m70688i(TAG, "delete cache file end.");
    }

    private void deleteOneModuleCache(String str) throws C9721b {
        new C12169k().m73216s(str, 0);
        C12571m.m75542d(this.location + "/" + str);
        C12571m.m75542d(this.location + ICBUtil.ANDROID_DATA + str);
        C12571m.m75542d(this.location + ICBUtil.TAR_LOCAL_DIR + str);
        C12571m.m75542d(this.installAppPath + "/" + str + ".apk");
        C12571m.m75542d(ICBUtil.getCurrentAndroidDataCachePath(str));
        C12571m.m75542d(ICBUtil.getSpecialPath(str));
    }

    private void doFailReport(C11060c c11060c) {
        if (this.manualAbort) {
            c11060c.m66635A("user canceled.");
            c11060c.m66665u("001_1001");
            return;
        }
        if (!condition()) {
            c11060c.m66665u("001_1002");
            c11060c.m66635A("net disabled.");
            return;
        }
        if (isAbort()) {
            c11060c.m66665u("001_" + getErrCode());
            c11060c.m66635A("abort by backup condition. current model:" + this.current);
            return;
        }
        C9721b c9721b = this.exception;
        if (c9721b != null) {
            c11060c.m66664t(c9721b.m60658b());
            c11060c.m66635A(this.exception.getMessage());
            c11060c.m66665u("001_" + this.exception.m60659c());
        }
    }

    private void doSuccessReport(C11060c c11060c) {
        if (this.tags != null) {
            String str = "restore success, totalTime: " + (System.currentTimeMillis() - this.tags.m78469k()) + " | totalSize: " + this.tags.m78439E();
            c11060c.m66665u("0");
            c11060c.m66635A(str);
        }
    }

    private boolean downloadSnapshot(String str) throws C9721b {
        CBSBackupRecord next;
        Iterator<CBSBackupRecord> it = this.service.m67997D(false, true).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (TextUtils.equals(next.getBackupId(), str)) {
                break;
            }
        }
        if (next == null || next.getStatus() != 0) {
            C11839m.m70689w(TAG, "downloadSnapshot backupRecord not exist");
            updateTagsStatus(4);
            throw new C9721b(3109, "query all backup records, current is invalid.", "downloadSnapshot");
        }
        String snapshot = next.getSnapshot();
        boolean zIsEmpty = true ^ TextUtils.isEmpty(snapshot);
        if (zIsEmpty) {
            try {
                if (this.snapshotTreeService.existSnapshotDataBase(str)) {
                    this.snapshotTreeService.getLastSuccessBackupId(str);
                    this.snapshotTreeService.deleteSnapshotDB(str);
                }
            } catch (C9721b unused) {
                C11839m.m70689w(TAG, "delete database exception.");
            }
            downloadSnapshotDb(snapshot, this.snapshotTreeService.getDBName(str));
            C11839m.m70688i(TAG, "downloadSnapshot success");
        }
        return zIsEmpty;
    }

    private Map<String, CloudRestoreStatus> getActions(boolean z10) throws C9721b {
        boolean z11;
        if (z10) {
            HashMap map = new HashMap();
            for (CloudRestoreStatus cloudRestoreStatus : this.statusOperator.m78552d()) {
                String appId = cloudRestoreStatus.getAppId();
                CloudRestoreStatus cloudRestoreStatus2 = new CloudRestoreStatus();
                cloudRestoreStatus2.setAppId(appId);
                cloudRestoreStatus2.update(cloudRestoreStatus);
                map.put(appId, cloudRestoreStatus2);
            }
            return map;
        }
        Map<String, CloudRestoreStatus> actionStatusListV2 = this.restoreClient.getActionStatusListV2(RestoreCache.getInstance().getRestoreItems());
        Iterator<Map.Entry<String, CloudRestoreStatus>> it = actionStatusListV2.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                z11 = true;
                break;
            }
            if (it.next().getValue().getAction() == 2) {
                z11 = false;
                break;
            }
        }
        RestoreCache.getInstance().clearRestoreItems();
        CloudBackupReport.reportRestoreLocalRecord(this.tags, z11, this.entryType, this.entranceOfRestore, this.deviceId);
        return actionStatusListV2;
    }

    private void getMetaServerPaths(List<String> list, CBSAppInfo cBSAppInfo, String str) {
        List<CBSFileInfo> fileInfos = cBSAppInfo.getFileInfos();
        if (fileInfos != null) {
            C11839m.m70688i(TAG, "appId = " + str + " file info size = " + fileInfos.size());
            Iterator<CBSFileInfo> it = fileInfos.iterator();
            while (it.hasNext()) {
                list.add(this.serverPath + str + "/" + it.next().getFileName());
            }
        }
    }

    private boolean has3rdPause() {
        return !this.statusOperator.m78555g(2).isEmpty();
    }

    private boolean hasDefault() {
        return !this.statusOperator.m78555g(0).isEmpty();
    }

    private void initRestoreDetails() throws Throwable {
        isCancel();
        C13029h c13029hQueryTags = queryTags();
        this.tags = c13029hQueryTags;
        int iM78441G = c13029hQueryTags.m78441G();
        C14317j.m85300d().m85312m(this.tags);
        if (iM78441G == 0) {
            initRestoreRecords(false);
        } else {
            if (iM78441G != 1 && iM78441G != 2 && iM78441G != 3) {
                throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "restore status illegal.", "onPrepare");
            }
            if (!this.isRetry) {
                C11839m.m70689w(TAG, "onPrepare not retry, status error");
                throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "restore status illegal.", "onPrepare");
            }
            C11839m.m70688i(TAG, "onPrepare prepare retry");
            prepareRetry();
        }
        InterfaceC1452g.get().forEach(new Consumer() { // from class: com.huawei.android.hicloud.cloudbackup.process.g0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f11698a.lambda$initRestoreDetails$0((InterfaceC1452g) obj);
            }
        });
    }

    private void initRestoreRecords(boolean z10) throws Throwable {
        Bundle bundle;
        int i10;
        ArrayList<String> arrayList;
        boolean z11;
        Bundle bundle2;
        deleteFile();
        initTempDirs();
        new C12169k().m73198a();
        boolean zDownloadSnapshot = downloadSnapshot(this.backupId);
        isCancel();
        CBSBackupRecord cBSBackupRecordQueryBackupRecordDetail = queryBackupRecordDetail(!zDownloadSnapshot);
        this.lastnotifytime = cBSBackupRecordQueryBackupRecordDetail.getLastNotifyTime();
        isCancel();
        Bundle newDeviceInfo = this.cloneService.getNewDeviceInfo();
        int i11 = newDeviceInfo.getInt("APPRiskFlag");
        ArrayList<String> stringArrayList = newDeviceInfo.getStringArrayList("SupprotedModule");
        if (stringArrayList == null) {
            stringArrayList = new ArrayList<>();
        }
        Bundle bundle3 = newDeviceInfo.getBundle("InstalledAPP");
        Bundle bundle4 = new Bundle();
        List<CBSAppInfo> appIdInfos = cBSBackupRecordQueryBackupRecordDetail.getAppIdInfos();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Map<String, CloudRestoreStatus> actions = getActions(z10);
        boolean zM1273k1 = C0209d.m1273k1();
        Iterator<CBSAppInfo> it = appIdInfos.iterator();
        CBSAppInfo cBSAppInfo = null;
        boolean z12 = true;
        while (it.hasNext()) {
            CBSAppInfo next = it.next();
            isCancel();
            String appId = next.getAppId();
            CloudRestoreStatus cloudRestoreStatus = actions.get(appId);
            Iterator<CBSAppInfo> it2 = it;
            if (isUnCheckedModule(appId, cloudRestoreStatus, actions.isEmpty())) {
                it = it2;
            } else {
                if (bundle3 == null || (bundle2 = bundle3.getBundle(appId)) == null) {
                    bundle = bundle3;
                    i10 = 0;
                } else {
                    bundle = bundle3;
                    i10 = bundle2.getInt("VersionCode");
                }
                Map<String, CloudRestoreStatus> map = actions;
                CloudRestoreStatus cloudRestoreStatusCreateStatus = this.restoreClient.createStatus(next, i10, this.isGoogleGmsInstalled);
                initUserAction(cloudRestoreStatus, cloudRestoreStatusCreateStatus);
                if (isUnSupportedModule(appId, stringArrayList)) {
                    cloudRestoreStatusCreateStatus.setStatus(-1);
                    if ("Memo".equalsIgnoreCase(appId) && !C0240y.m1682d(CacheTask.getContext(), "com.example.android.notepad")) {
                        cloudRestoreStatusCreateStatus.setStatus(-5);
                    }
                }
                if (zM1273k1 && C14333b.f63656h.contains(appId)) {
                    cloudRestoreStatusCreateStatus.setStatus(-1);
                }
                checkBundleAppSupport(cloudRestoreStatusCreateStatus);
                checkHarmonyAppSupport(cloudRestoreStatusCreateStatus);
                if (zDownloadSnapshot) {
                    arrayList = stringArrayList;
                    z11 = zM1273k1;
                    this.restoreClient.createSnapshotMetas(this.snapshotTreeService, this.backupId, cloudRestoreStatusCreateStatus, this.serverPath, this.deviceId);
                } else {
                    arrayList = stringArrayList;
                    z11 = zM1273k1;
                    getMetaServerPaths(arrayList3, next, appId);
                }
                if (HNConstants.DataType.MEDIA.equals(appId)) {
                    cBSAppInfo = next;
                }
                if (cloudRestoreStatusCreateStatus.is3rdAppType()) {
                    bundle4.putInt(appId, cloudRestoreStatusCreateStatus.getVersionCode());
                }
                if (cloudRestoreStatusCreateStatus.getBmAppDataType() == 0) {
                    z12 = false;
                }
                arrayList2.add(cloudRestoreStatusCreateStatus);
                it = it2;
                bundle3 = bundle;
                actions = map;
                stringArrayList = arrayList;
                zM1273k1 = z11;
            }
        }
        this.tags.m78458X(z12 ? "1" : "");
        this.statusOperator.clear();
        this.statusOperator.batchReplace(arrayList2);
        C12590s0.m75749G2();
        resetOldVersionFlag();
        createBackupMetas(arrayList3);
        updateGalleryModifiedTime(cBSAppInfo);
        if (i11 == 1 && !bundle4.isEmpty()) {
            checkAppRiskInfo(this.cloneService.checkAppRiskInfo(bundle4));
        }
        if (zDownloadSnapshot) {
            reportModuleSkipFileNum();
        }
        isCancel();
        updateTagsStatus(1);
    }

    private void initUserAction(RestoreStatus restoreStatus, CloudRestoreStatus cloudRestoreStatus) {
        if (restoreStatus == null || cloudRestoreStatus.getAction() != 0) {
            return;
        }
        cloudRestoreStatus.setAction(restoreStatus.getAction());
        if (restoreStatus.getAction() == 1) {
            cloudRestoreStatus.m29510A0(String.valueOf(0));
        }
    }

    private boolean isAllModulesSuccess(List<CloudRestoreStatus> list) {
        boolean z10 = false;
        if (list.isEmpty()) {
            return false;
        }
        Iterator<CloudRestoreStatus> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                z10 = true;
                break;
            }
            if (!it.next().isSuccess()) {
                break;
            }
        }
        if (z10) {
            updateTagsStatus(4);
            this.exception = null;
            this.isSuccess = true;
        }
        return z10;
    }

    private boolean isFirstStageFailed(List<CloudRestoreStatus> list) {
        boolean z10;
        boolean z11 = true;
        if (list.isEmpty()) {
            return true;
        }
        Iterator<CloudRestoreStatus> it = list.iterator();
        boolean z12 = false;
        while (true) {
            if (!it.hasNext()) {
                z10 = true;
                z11 = z12;
                break;
            }
            CloudRestoreStatus next = it.next();
            if (this.restoreSystemModulesOne.contains(next.getAppId())) {
                if (next.isSuccess()) {
                    z10 = false;
                    break;
                }
                z12 = true;
            }
        }
        if (z11) {
            return z10;
        }
        return false;
    }

    private boolean isFromOOBE() {
        return 1 == this.entryType;
    }

    private void isLocalSpaceEnough() throws C9721b {
        C9721b c9721b = this.exception;
        if (c9721b != null && c9721b.m60659c() == 1007) {
            throw this.exception;
        }
    }

    private boolean isNeedCount() {
        boolean zIsModuleIgnoreRetryErr = isModuleIgnoreRetryErr();
        boolean zIsIgnoreRetryErr = RestoreUtil.isIgnoreRetryErr(this.exception);
        C11839m.m70688i(TAG, "isNeedCount moduleIgnoreRetryErr: " + zIsModuleIgnoreRetryErr + " ,ignoreRetryErr: " + zIsIgnoreRetryErr);
        return (zIsModuleIgnoreRetryErr || zIsIgnoreRetryErr) ? false : true;
    }

    private void isNeedSaveRestoreFailInfo(List<CloudRestoreStatus> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (CloudRestoreStatus cloudRestoreStatus : list) {
            if (!cloudRestoreStatus.isSuccessWithoutUnSupport()) {
                C11839m.m70688i(TAG, "isSuccessWithoutUnSupport false  , appId = " + cloudRestoreStatus.getAppId() + " , status = " + cloudRestoreStatus.getStatus());
                arrayList.add(cloudRestoreStatus.getAppId());
            }
        }
        if (arrayList.isEmpty() || 5 != this.entryType) {
            return;
        }
        C12590s0.m75761J2(new RefurbishRestoreFailInfo(this.backupId, (String[]) arrayList.toArray(new String[0])));
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean isNetworkEnabled() {
        /*
            r4 = this;
            fk.b r0 = r4.exception
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L14
            int r0 = r0.m60659c()
            r3 = 1002(0x3ea, float:1.404E-42)
            if (r0 == r3) goto L12
            switch(r0) {
                case 1104: goto L12;
                case 1105: goto L12;
                case 1106: goto L12;
                case 1107: goto L12;
                default: goto L11;
            }
        L11:
            goto L14
        L12:
            r0 = r1
            goto L15
        L14:
            r0 = r2
        L15:
            boolean r4 = r4.condition()
            if (r4 == 0) goto L1e
            if (r0 == 0) goto L1e
            r1 = r2
        L1e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.cloudbackup.process.CloudRestoreTask.isNetworkEnabled():boolean");
    }

    private boolean isPrepareError() {
        if (this.isPrepareError && !this.isRetry) {
            updateTagsStatus(4);
        }
        return (this.tags == null || this.isPrepareError) && !this.isRetry;
    }

    private boolean isRestoreDone() {
        C13029h c13029h = this.tags;
        return c13029h != null && c13029h.m78441G() == 4;
    }

    private boolean isUnCheckedModule(String str, RestoreStatus restoreStatus, boolean z10) {
        if ("wifiConfig".equals(str)) {
            C11839m.m70688i(TAG, "user do not choose restore appId = " + str);
            return true;
        }
        if (restoreStatus != null && restoreStatus.getAction() == 2) {
            C11839m.m70688i(TAG, "user do not choose restore appId = " + str);
            return true;
        }
        if (restoreStatus != null || z10) {
            return false;
        }
        C11839m.m70688i(TAG, "user do not choose restore appId = " + str);
        return true;
    }

    private boolean isUnSupportedModule(String str, List<String> list) {
        return this.defaultModules.contains(str) && !list.contains(str);
    }

    private void jumpToHwLanucher(CloudRestoreStatus cloudRestoreStatus) {
        String appId = cloudRestoreStatus.getAppId();
        int status = cloudRestoreStatus.getStatus();
        int type = cloudRestoreStatus.getType();
        if ("HWlanucher".equals(appId)) {
            if (status != 4 && status != 7) {
                if (status == 8) {
                    C11839m.m70688i(TAG, "sendDoneMsgOrJumpToHwlauncherIfNeed launcher is restore done already, do not restore again");
                    this.isLauncherLayoutOk = true;
                    return;
                } else {
                    C11839m.m70688i(TAG, "sendDoneMsgOrJumpToHwlauncherIfNeed restore launcher failed, set isLauncherLayoutOk true.");
                    this.isLauncherLayoutOk = true;
                    this.isLauncherSupported = false;
                    return;
                }
            }
            if (type != 1) {
                C11839m.m70688i(TAG, "sendDoneMsgOrJumpToHwlauncherIfNeed restore launcher failed, set isLauncherLayoutOk true.");
                this.isLauncherLayoutOk = true;
                this.isLauncherSupported = false;
                return;
            }
            C11839m.m70688i(TAG, "wait jump");
            SystemClock.sleep(RippleView.ONE_PERIOD_TIME);
            if (isFromOOBE()) {
                return;
            }
            C11839m.m70688i(TAG, "jump to launcher");
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            intent.setFlags(270532608);
            if (C0209d.m1269j1()) {
                C0209d.m1302r2(intent, "com.hihonor.android.launcher");
            } else {
                C0209d.m1302r2(intent, "com.huawei.android.launcher");
            }
            CacheTask.getContext().startActivity(intent);
        }
    }

    public static /* synthetic */ boolean lambda$adjustThirdAppSequence$6(CloudRestoreStatus cloudRestoreStatus) {
        return cloudRestoreStatus.getStatus() < 0;
    }

    public static /* synthetic */ boolean lambda$adjustThirdAppSequence$7(CloudRestoreStatus cloudRestoreStatus) {
        return cloudRestoreStatus.getStatus() >= 0;
    }

    public /* synthetic */ int lambda$adjustThirdAppSequence$8(CloudRestoreStatus cloudRestoreStatus, CloudRestoreStatus cloudRestoreStatus2) {
        return C12580p.m75579m(cloudRestoreStatus, cloudRestoreStatus2, this.appRestoreOrderFromLauncher);
    }

    public /* synthetic */ void lambda$initRestoreDetails$0(InterfaceC1452g interfaceC1452g) {
        interfaceC1452g.mo7504l(this.traceID, false, false, 0);
    }

    public static /* synthetic */ void lambda$moduleAwait$9(AtomicLong atomicLong, String str, CloudRestoreStatus cloudRestoreStatus) {
        long size = cloudRestoreStatus.getSize() + cloudRestoreStatus.getAsize();
        atomicLong.addAndGet((((100 - cloudRestoreStatus.getProgress()) * size) / 100) + size);
    }

    public static /* synthetic */ boolean lambda$onStart$1(CloudRestoreStatus cloudRestoreStatus) {
        return cloudRestoreStatus.getStatus() < 0;
    }

    public static /* synthetic */ boolean lambda$onStart$2(CloudRestoreStatus cloudRestoreStatus) {
        return cloudRestoreStatus.getStatus() >= 0;
    }

    public /* synthetic */ int lambda$onStart$3(CloudRestoreStatus cloudRestoreStatus, CloudRestoreStatus cloudRestoreStatus2) {
        return C12580p.m75579m(cloudRestoreStatus, cloudRestoreStatus2, this.appRestoreOrderFromLauncher);
    }

    public static /* synthetic */ boolean lambda$updateDeleteModuleStatus$4(CloudRestoreStatus cloudRestoreStatus, CBSAppInfo cBSAppInfo) {
        return TextUtils.equals(cBSAppInfo.getAppId(), cloudRestoreStatus.getAppId());
    }

    public static /* synthetic */ boolean lambda$updateDeleteModuleStatus$5(List list, final CloudRestoreStatus cloudRestoreStatus) {
        return !list.stream().anyMatch(new Predicate() { // from class: com.huawei.android.hicloud.cloudbackup.process.e0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return CloudRestoreTask.lambda$updateDeleteModuleStatus$4(cloudRestoreStatus, (CBSAppInfo) obj);
            }
        });
    }

    private boolean needResetRestoreData() {
        C13029h c13029hM78495f;
        try {
            c13029hM78495f = new C13030i().m78495f(3);
        } catch (C9721b e10) {
            C11839m.m70687e(TAG, "resetOldVersionFlag e = " + e10.toString());
            c13029hM78495f = null;
        }
        if (c13029hM78495f == null) {
            return false;
        }
        String strM78482u = c13029hM78495f.m78482u();
        return !TextUtils.isEmpty(strM78482u) && TextUtils.equals(strM78482u, "db_updata");
    }

    private void prepareRetry() throws Throwable {
        if (needResetRestoreData()) {
            C11839m.m70688i(TAG, "prepareRetry needResetRestoreData");
            initRestoreRecords(true);
            return;
        }
        boolean z10 = !C0209d.m1206R1(CacheTask.getContext());
        if (z10) {
            this.entryType = 1;
        } else {
            int i10 = this.entryType;
            if (i10 == 0 || i10 == 1) {
                this.entryType = 2;
            }
        }
        C11839m.m70688i(TAG, "prepareRetry check isOOBE = " + z10 + " entryType " + this.entryType);
        C12590s0.m75749G2();
        if (this.isResumeRetry) {
            C11839m.m70688i(TAG, "prepareRetry isResumeRetry = true, return.");
        } else {
            this.restoreClient.updateStatusBeforeRetry();
        }
    }

    private CBSBackupRecord queryBackupRecordDetail(boolean z10) throws C9721b {
        CBSBackupRecord cBSBackupRecordM68001H;
        try {
            if (z10) {
                cBSBackupRecordM68001H = this.service.m68001H(this.deviceId, this.deviceType, this.backupId, true, true);
                reportQuerySingleRecord(this.backupId);
            } else {
                cBSBackupRecordM68001H = this.service.m68001H(this.deviceId, this.deviceType, this.backupId, false, true);
            }
            if (cBSBackupRecordM68001H == null) {
                throw new C9721b(3107, "query backupRecordDetailReq return null.", "initRestoreRecords");
            }
            if (cBSBackupRecordM68001H.getStatus() == 0) {
                return cBSBackupRecordM68001H;
            }
            throw new C9721b(3109, "query records invalid.", "initRestoreRecords");
        } catch (C9721b e10) {
            C11839m.m70688i(TAG, "queryBackupRecordDetail error." + e10.toString());
            if (3109 == e10.m60659c() || 3110 == e10.m60659c()) {
                C11839m.m70688i(TAG, "backupRecord not exist");
                updateTagsStatus(4);
            }
            throw e10;
        }
    }

    private C13029h queryTags() throws C9721b {
        C13030i c13030i = new C13030i();
        C13029h c13029hM78495f = c13030i.m78495f(3);
        if (c13029hM78495f == null) {
            C13029h c13029hCreateTags = createTags();
            c13030i.m78496g(c13029hCreateTags);
            return c13029hCreateTags;
        }
        if (this.isRetry) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            c13029hM78495f.m78483u0(this.traceID);
            c13029hM78495f.m78450P(jCurrentTimeMillis);
            return c13029hM78495f;
        }
        c13030i.m78490a(3);
        C13029h c13029hCreateTags2 = createTags();
        c13030i.m78496g(c13029hCreateTags2);
        return c13029hCreateTags2;
    }

    private void recordFailList(List<Result.ErrMsg> list) throws C9721b {
        C11839m.m70688i(TAG, "createBackupMetas exist fail file");
        int i10 = 0;
        for (Result.ErrMsg errMsg : list) {
            C11839m.m70689w(TAG, "createBackupMetas fail file err: " + errMsg.toString());
            if (errMsg.getErrCode() != 103) {
                throw new C9721b(3207, errMsg.getErrCode(), errMsg.getErrMsg());
            }
            i10++;
        }
        CloudBackupReport.reportRecordsIsExist(i10, this.entryType, this.entranceOfRestore);
    }

    private void recordRestoreStart() {
        this.restoreRecordInfos.m78424m(this.backupId);
        this.restoreRecordInfos.m78426o(3);
        this.restoreRecordInfos.m78432u(System.currentTimeMillis());
        this.backupRecordInfoOperator.m78411i(this.restoreRecordInfos);
        CloudBackupReport.reportRestoreStart(this.traceID, "1", this.backupId, this.isRetry, this.isResumeRetry, isFromOOBE(), this.isAuto);
    }

    private void refresh3rdLauncherFlag() throws C9721b {
        for (CloudRestoreStatus cloudRestoreStatus : this.thirdApplist) {
            Iterator<String> it = this.appRestoreOrderFromLauncher.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (cloudRestoreStatus.getAppId().equals(it.next())) {
                        cloudRestoreStatus.m29517H0(1);
                        break;
                    }
                }
            }
        }
        this.statusOperator.batchReplace(this.thirdApplist);
        this.lastQueue.clear();
        for (CloudRestoreStatus cloudRestoreStatus2 : this.thirdApplist) {
            if (cloudRestoreStatus2 == null) {
                C11839m.m70689w(TAG, "refresh3rdLauncherFlag status is null.");
            } else if (!cloudRestoreStatus2.isUnSupport()) {
                this.lastQueue.add(cloudRestoreStatus2);
            }
        }
    }

    private void refreshLocalBytes() {
        Long localLeftSpace = ICBUtil.getLocalLeftSpace();
        this.localLeftBytes = localLeftSpace == null ? 0L : localLeftSpace.longValue() - new C12526j().m75428x0();
    }

    private void refreshQueryTags() {
        try {
            this.tags = new C13030i().m78495f(3);
        } catch (C9721b e10) {
            C11839m.m70687e(TAG, "refreshQueryTags queryTag error " + e10.toString());
        }
    }

    private void refreshRecoedInfoEnd() {
        boolean z10 = C13452e.m80781L().m80916g0() == 3;
        if (this.manualAbort) {
            this.restoreRecordInfos.m78425n(3);
        } else if (z10) {
            this.restoreRecordInfos.m78425n(1);
        } else if (isNetworkEnabled()) {
            this.restoreRecordInfos.m78425n(2);
        } else {
            this.restoreRecordInfos.m78425n(4);
        }
        if (this.restoreRecordInfos.m78421j() > 0) {
            this.restoreRecordInfos.m78430s(System.currentTimeMillis());
            long jM78422k = this.restoreRecordInfos.m78422k();
            long jM78423l = this.restoreRecordInfos.m78423l();
            if (jM78422k > 0 && jM78423l > 0) {
                this.restoreRecordInfos.m78431t(1);
                this.backupRecordInfoOperator.m78403a();
            }
            this.backupRecordInfoOperator.m78411i(this.restoreRecordInfos);
            this.backupRecordInfoOperator.m78404b(System.currentTimeMillis() - 604800000);
        }
    }

    private void reportModuleSkipFileNum() throws Throwable {
        try {
            List<SnapshotBackupMeta> listQueryAllRootNodeMetas = new SnapshotBackupMetaOperator(this.backupId).queryAllRootNodeMetas();
            StringBuilder sb2 = new StringBuilder();
            for (SnapshotBackupMeta snapshotBackupMeta : listQueryAllRootNodeMetas) {
                if (!TextUtils.isEmpty(snapshotBackupMeta.getData4())) {
                    sb2.append("appId = ");
                    sb2.append(snapshotBackupMeta.getAppId());
                    sb2.append(", appName = ");
                    sb2.append(snapshotBackupMeta.getName());
                    sb2.append(", module skip file num = ");
                    sb2.append(snapshotBackupMeta.getData4());
                    sb2.append("|");
                }
            }
            String string = sb2.toString();
            C11839m.m70686d(TAG, "report skip info: " + string);
            if (TextUtils.isEmpty(string)) {
                return;
            }
            C11060c c11060cM66626a = C11058a.m66626a(this.traceID, "moduleSkipFile", C13452e.m80781L().m80971t0());
            c11060cM66626a.m66665u("010_1013");
            c11060cM66626a.m66635A(sb2.toString());
            C13622a.m81968n(C0213f.m1377a(), c11060cM66626a);
        } catch (C9721b e10) {
            C11839m.m70687e(TAG, "query all root node metas error: " + e10.toString());
        }
    }

    private void resetOldVersionFlag() {
        C13029h c13029hM78495f;
        C13030i c13030i = new C13030i();
        try {
            c13029hM78495f = c13030i.m78495f(3);
        } catch (C9721b e10) {
            C11839m.m70687e(TAG, "resetOldVersionFlag e = " + e10.toString());
            c13029hM78495f = null;
        }
        if (c13029hM78495f == null) {
            C11839m.m70689w(TAG, "resetOldVersionFlag backupTags is null");
            return;
        }
        String strM78482u = c13029hM78495f.m78482u();
        if (TextUtils.isEmpty(strM78482u) || !TextUtils.equals(strM78482u, "db_updata")) {
            return;
        }
        c13029hM78495f.m78456V("");
        c13030i.m78496g(c13029hM78495f);
        C11839m.m70688i(TAG, "resetOldVersionFlag not retry , reset data3");
    }

    private int restore3rdAndroidData(String str, String str2, String str3, BackupRestoreUtil backupRestoreUtil) throws C9721b, IOException {
        File[] fileArrListFiles;
        if (C0209d.m1179I1()) {
            File fileM63442h = C10278a.m63442h(str);
            if (fileM63442h.exists() && (fileArrListFiles = fileM63442h.listFiles()) != null && fileArrListFiles.length > 0) {
                File fileM63443i = C10278a.m63443i(str, str3 + ".txt");
                if (!fileM63443i.exists()) {
                    try {
                        C11839m.m70686d(TAG, "create pms txt file result = " + fileM63443i.createNewFile());
                    } catch (IOException e10) {
                        C11839m.m70687e(TAG, "create pms txt file error: " + e10.toString());
                    }
                }
                return backupRestoreUtil.pmsRestore(str, str2, 0);
            }
        } else {
            C11835i.m70653q(str + str3, str2);
        }
        return 0;
    }

    private CloneService.CloneErr restoreBundleApp(Bundle bundle, String str, CloneService.CloneCallback cloneCallback) throws C9721b {
        return restoreBundleOrHarmony(bundle, str, cloneCallback, this.installAppPath + "/" + str + "/apk/", this.installAppPath + "/" + str + ".apk");
    }

    private CloneService.CloneErr restoreBundleOrHarmony(Bundle bundle, String str, CloneService.CloneCallback cloneCallback, String str2, String str3) throws Throwable {
        CloneService.CloneErr cloneErr = new CloneService.CloneErr();
        cloneErr.isSuccess = false;
        cloneErr.isBundleAppRestore = true;
        File fileM63442h = C10278a.m63442h(str3);
        File fileM63442h2 = C10278a.m63442h(str2);
        if (!fileM63442h.exists()) {
            C11839m.m70689w(TAG, "restoreBundleApp apkOldFile not exist " + str);
            String[] list = fileM63442h2.list();
            cloneErr.retCode = FamilyShareConstants.StatusCode.SHARE_SPACE_NOT_ENOUGH;
            return (!fileM63442h2.exists() || list == null || list.length <= 0) ? cloneErr : this.cloneService.doRestoreOneModule(str, this.location, bundle, cloneCallback);
        }
        try {
            C12571m.m75547i(str2);
            TarFileUtil.unTarAll(fileM63442h, str2);
            C11839m.m70688i(TAG, "untar success " + str);
            if (!fileM63442h.delete()) {
                C11839m.m70687e(TAG, "apkFile delete failed");
            }
            return this.cloneService.doRestoreOneModule(str, this.location, bundle, cloneCallback);
        } catch (C9721b e10) {
            C11839m.m70687e(TAG, "untar error: " + e10.toString());
            cloneErr.retCode = e10.m60659c();
            return cloneErr;
        }
    }

    private void restoreEnd() throws SQLException {
        CloudBackupTaskManager.getInstance().shutDown();
        C12188o.m73320c().m73324e();
        RestoreProgressManager.getInstance().release();
        InterfaceC1450e.get().forEach(new C2543k0());
        if (this.galleryReports != null) {
            try {
                AlbumsTempOperator albumsTempOperator = new AlbumsTempOperator();
                albumsTempOperator.clear();
                albumsTempOperator.close();
            } catch (C9721b unused) {
                C11839m.m70689w(TAG, "onClose closeAlbumTempDb error.");
            }
        }
        if (this.isSuccess) {
            C13465e.m81052f().m81070s(false, 0L);
            C13465e.m81052f().m81070s(true, 0L);
        }
    }

    private void restoreEndClearLauncherIcon(int i10) {
        boolean z10 = (i10 == 2 || i10 == 4 || i10 == 6 || i10 == 7) ? false : true;
        C11839m.m70688i(TAG, "restoreEnd clear Launcher icon = " + z10);
        if (z10) {
            RestoreUtil.setRestoreStatus(CacheTask.getContext(), false);
            if ("HWlanucher".equals(this.current)) {
                ICBBroadcastManager.sendDelayCancelRestoreBroadcast(CacheTask.getContext(), 3);
            } else {
                ICBBroadcastManager.sendDelayCancelRestoreBroadcast(CacheTask.getContext(), 1);
            }
        }
    }

    private void restoreEndClearStatus() {
        boolean zIsNewBmRecord = RestoreUtil.isNewBmRecord();
        int iM80916g0 = C13452e.m80781L().m80916g0();
        C13029h c13029h = this.tags;
        if (c13029h != null && c13029h.m78441G() == 4) {
            C11839m.m70688i(TAG, "async clear cache task start.");
            new C12169k().clear();
            C12574n.m75558k(CacheTask.getContext());
        }
        this.restoreClient.sendClearCacheSuccessMessage();
        this.restoreClient.sendMessage(iM80916g0, getErrCode(), zIsNewBmRecord);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0012 A[PHI: r2
  0x0012: PHI (r2v3 int) = (r2v0 int), (r2v1 int), (r2v1 int), (r2v0 int) binds: [B:33:0x0010, B:47:0x0040, B:49:0x0043, B:37:0x001a] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void restoreEndNotifyUI(java.util.List<com.huawei.hicloud.cloudbackup.store.database.tags.CloudRestoreStatus> r5) {
        /*
            r4 = this;
            boolean r0 = com.huawei.android.hicloud.cloudbackup.process.RestoreUtil.isAllModulesRestoreFailed(r5)
            boolean r1 = r4.manualAbort
            if (r1 == 0) goto Lb
            r0 = 8
            goto L47
        Lb:
            boolean r1 = r4.isPrepareError()
            r2 = 5
            if (r1 == 0) goto L14
        L12:
            r0 = r2
            goto L47
        L14:
            boolean r1 = r4.isRestoreDone()
            if (r1 == 0) goto L1f
            if (r0 == 0) goto L1d
            goto L12
        L1d:
            r0 = 3
            goto L47
        L1f:
            boolean r1 = r4.isNetworkEnabled()
            if (r1 != 0) goto L27
            r0 = 6
            goto L47
        L27:
            boolean r1 = r4.has3rdPause()
            if (r1 == 0) goto L39
            vl.f r0 = p711vl.C13466f.m81073d()
            java.lang.String r1 = "has_moudles_restore_pause"
            r2 = 1
            r0.m81081i(r1, r2)
            r0 = 7
            goto L47
        L39:
            fk.b r1 = r4.exception
            boolean r1 = com.huawei.android.hicloud.cloudbackup.process.RestoreUtil.isShowRestoreFailedDialog(r1)
            r2 = 4
            if (r1 == 0) goto L43
            goto L12
        L43:
            if (r0 == 0) goto L46
            goto L12
        L46:
            r0 = 2
        L47:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "restoreEnd status = "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "CloudRestoreTask"
            p514o9.C11839m.m70688i(r2, r1)
            com.huawei.android.hicloud.cloudbackup.restore.CloudRestoreClient r1 = r4.restoreClient
            tl.n r2 = new tl.n
            r2.<init>()
            fk.b r3 = r4.exception
            r1.refreshStatus(r0, r5, r2, r3)
            boolean r5 = r4.isFromOOBE()
            com.huawei.android.hicloud.cloudbackup.process.RestoreUtil.saveRestoreInfoToSp(r0, r5)
            vj.e r5 = p709vj.C13452e.m80781L()
            r5.m80914f3(r0)
            r5 = 0
            r1 = 32998(0x80e6, float:4.624E-41)
            android.os.Message r5 = android.os.Message.obtain(r5, r1)
            r4.callback(r5)
            com.huawei.hicloud.cloudbackup.service.a r5 = com.huawei.hicloud.cloudbackup.service.C4877a.m29281i()
            r5.m29288o()
            r4.restoreEndClearLauncherIcon(r0)
            android.content.Context r4 = com.huawei.android.hicloud.cloudbackup.process.CacheTask.getContext()
            com.huawei.android.hicloud.cloudbackup.broadcast.ICBBroadcastManager.sendBackupRestoreEnd(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.cloudbackup.process.CloudRestoreTask.restoreEndNotifyUI(java.util.List):void");
    }

    private void restoreEndScheduler() {
        boolean zM70611r0 = C11829c.m70611r0();
        if (this.manualAbort) {
            unRegisterV2AutoRestore(zM70611r0);
            return;
        }
        C13029h c13029h = this.tags;
        if (c13029h != null) {
            int iM78441G = c13029h.m78441G();
            if (iM78441G != 0 && iM78441G != 1 && iM78441G != 2 && iM78441G != 3) {
                if (iM78441G != 4) {
                    return;
                }
                unRegisterV2AutoRestore(zM70611r0);
                return;
            }
            C11839m.m70688i(TAG, "restore in state: " + iM78441G + "the code is:" + getErrCode());
            if (!RestoreUtil.isRestoreNeedAutoRetry(getErrCode())) {
                unRegisterV2AutoRestore(zM70611r0);
            } else {
                C11839m.m70688i(TAG, "v2 restore in state registerAutoRestore: need load retry timer.");
                registerV2AutoRestore(zM70611r0, false);
            }
        }
    }

    private void restoreEndUpdateStatus(List<CloudRestoreStatus> list) {
        if (isFromOOBE() && this.isFirstStage && !this.isRetry && !this.manualAbort && isFirstStageFailed(list)) {
            C13452e.m80781L().m80890b();
            updateTagsStatus(4);
            RestoreNotification.getInstance().cancelNotification();
            sendFirstDoneMessage(false);
        }
        boolean zIsAllModulesSuccess = isAllModulesSuccess(list);
        isNeedSaveRestoreFailInfo(list);
        C13466f.m81073d().m81081i("all_moudles_restore_success", zIsAllModulesSuccess);
        if (zIsAllModulesSuccess || this.manualAbort) {
            updateTagsStatus(4);
        }
        checkRetryCount();
    }

    private void restoreFirst() throws InterruptedException, C9721b {
        C11839m.m70688i(TAG, "first stage start");
        try {
            restoreMulti(this.firstQueue);
            e = null;
        } catch (C9721b e10) {
            e = e10;
            setException(e);
        }
        sendOOBEFirstStageMsg(e);
        isCancel();
        updateTagsStatus(2);
        this.restoreClient.dealNotifySetting(this.lastnotifytime, this.deviceId, this.entryType, this.entranceOfRestore);
        C11839m.m70688i(TAG, "first stage end");
        this.isFirstStage = false;
    }

    private CloneService.CloneErr restoreHarmony(Bundle bundle, String str, CloneService.CloneCallback cloneCallback) throws C9721b {
        return restoreBundleOrHarmony(bundle, str, cloneCallback, this.location + "/" + str + "/hap/", this.installAppPath + "/" + str + ".apk");
    }

    private void restoreLauncher() throws InterruptedException, C9721b {
        if (this.isLauncherRestore) {
            return;
        }
        C11839m.m70688i(TAG, "restore launcher stage start");
        ConcurrentLinkedDeque concurrentLinkedDeque = new ConcurrentLinkedDeque();
        C11839m.m70686d(TAG, "restore launcher pollQueue.offer " + concurrentLinkedDeque.offer(this.launcherStatus));
        restoreMulti(concurrentLinkedDeque);
        this.isLauncherRestore = true;
        if (this.isLauncherSupported) {
            List<CloudRestoreStatus> listM78551c = this.statusOperator.m78551c();
            this.thirdApplist = listM78551c;
            if (listM78551c.isEmpty()) {
                return;
            }
            waitForHwLauncherNotification(this.isLauncherSupported);
            adjustThirdAppSequence();
        }
    }

    @SafeVarargs
    private final void restoreMulti(Queue<CloudRestoreStatus>... queueArr) throws InterruptedException, C9721b {
        if (queueArr == null) {
            C11839m.m70688i(TAG, "restoreMulti exit, queue.isEmpty.");
            return;
        }
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        int size = 0;
        for (Queue<CloudRestoreStatus> queue : queueArr) {
            if (queue != null && !queue.isEmpty()) {
                size += queue.size();
                arrayList.add(queue);
            }
        }
        C11839m.m70688i(TAG, "restoreMulti start.");
        while (i10 < size) {
            isCancel();
            int i11 = i10 + 1;
            Queue queue2 = (Queue) arrayList.get(i10 % arrayList.size());
            CloudRestoreStatus cloudRestoreStatus = (CloudRestoreStatus) queue2.poll();
            if (queue2.isEmpty()) {
                arrayList.remove(queue2);
            }
            if (cloudRestoreStatus == null) {
                C11839m.m70688i(TAG, "restoreMulti queue status is null.");
            } else if (cloudRestoreStatus.isSkipDownload(this.isResumeRetry)) {
                if ("HWlanucher".equals(cloudRestoreStatus.getAppId())) {
                    this.isLauncherLayoutOk = true;
                }
                C11839m.m70688i(TAG, "restoreMulti " + cloudRestoreStatus.getAppId() + ", no need to restore");
            } else {
                addDownloadTask(cloudRestoreStatus);
            }
            i10 = i11;
        }
        isCancel();
        modulesAwait();
        if (this.exception == null) {
            C11839m.m70688i(TAG, "restoreMulti end.");
            return;
        }
        C11839m.m70688i(TAG, "restoreMulti end，but seems error, throw exception." + this.exception);
        throw this.exception;
    }

    private int restoreOneModule3rdAndroidData(BackupRestoreUtil backupRestoreUtil, String str) throws C9721b, IOException {
        isRelease();
        int iRestore3rdAndroidData = restore3rdAndroidData(ICBUtil.getCurrentAndroidDataCachePath(str) + ICBUtil.ANDROID_DATA, ICBUtil.getTheAndroidDataCachePath(str), str, backupRestoreUtil);
        if (iRestore3rdAndroidData != 0) {
            return iRestore3rdAndroidData;
        }
        isRelease();
        int iRestore3rdAndroidData2 = restore3rdAndroidData(ICBUtil.getCurrentAndroidDataCachePath(str) + ICBUtil.ANDROID_MEDIA, ICBUtil.getTheAndroidMediaCachePath(str), str, backupRestoreUtil);
        if (iRestore3rdAndroidData2 != 0) {
            return iRestore3rdAndroidData2;
        }
        isRelease();
        int iRestore3rdAndroidData3 = restore3rdAndroidData(ICBUtil.getCurrentAndroidDataCachePath(str) + ICBUtil.ANDROID_OBB, ICBUtil.getTheAndroidObbCachePath(str), str, backupRestoreUtil);
        if (iRestore3rdAndroidData3 != 0) {
            return iRestore3rdAndroidData3;
        }
        isRelease();
        int iRestore3rdAndroidData4 = restore3rdAndroidData(ICBUtil.getCurrentAndroidDataCachePath(str) + ICBUtil.ANDROID_OBJ, ICBUtil.getTheAndroidObjCachePath(str), str, backupRestoreUtil);
        if (iRestore3rdAndroidData4 != 0) {
            return iRestore3rdAndroidData4;
        }
        isRelease();
        return restore3rdAndroidData(ICBUtil.getCurrentAndroidDataCachePath(str) + ICBUtil.ANDROID_SANDBOX, ICBUtil.getTheAndroidSandboxCachePath(str), str, backupRestoreUtil);
    }

    @SuppressLint({"MissingPermission"})
    private void restoreOneModule3rdData(CloudRestoreStatus cloudRestoreStatus) throws C9721b, IOException {
        if (cloudRestoreStatus.is3rdAppType()) {
            String appId = cloudRestoreStatus.getAppId();
            if (cloudRestoreStatus.getType() != 1) {
                C11839m.m70689w(TAG, "restoreOneModule3rdData apk restore error appId = " + appId);
                return;
            }
            isRelease();
            String dataTempDir = getDataTempDir(appId);
            File fileM63442h = C10278a.m63442h(dataTempDir);
            if (!fileM63442h.exists()) {
                C11839m.m70688i(TAG, "restoreOneModule3rdData " + appId + " no data restore");
                return;
            }
            isRelease();
            String[] list = fileM63442h.list();
            if (list == null || list.length <= 0) {
                C11839m.m70688i(TAG, "restoreOneModule3rdData " + appId + " no data restore");
                return;
            }
            if (cloudRestoreStatus.getAction() != 0) {
                C11839m.m70688i(TAG, "not support to restore app data");
                return;
            }
            int iPmsMove = 0;
            AtomicInteger atomicInteger = new AtomicInteger(0);
            if (ICBUtil.isForGroundProcess(appId, CacheTask.getContext(), cloudRestoreStatus.getUid(), atomicInteger)) {
                C11839m.m70688i(TAG, "killBackgroundProcesses, foreground appId = " + appId);
                this.statusOperator.m78557i(cloudRestoreStatus, -2, 2);
                CloudBackupReport.reportIsSkip(appId, "foreGround", this.traceID, atomicInteger.get());
                return;
            }
            C11839m.m70688i(TAG, "killBackgroundProcesses, background appId = " + appId);
            CloudBackupReport.reportIsSkip(appId, "backGround", this.traceID, 0);
            ((ActivityManager) CacheTask.getContext().getSystemService("activity")).killBackgroundProcesses(appId);
            isRelease();
            this.statusOperator.m78557i(cloudRestoreStatus, 7, 0);
            sendOneModuleMessage(cloudRestoreStatus);
            if (PmsCheckUtil.m12611e()) {
                isRelease();
                BackupRestoreUtil backupRestoreUtil = new BackupRestoreUtil(CacheTask.getContext(), this.progressCallback, dataTempDir);
                iPmsMove = C12565k.m75529o() ? backupRestoreUtil.pmsMove(appId) : backupRestoreUtil.pmsRestore(appId);
                if (iPmsMove == 0) {
                    iPmsMove = restoreOneModule3rdAndroidData(backupRestoreUtil, appId);
                } else {
                    C11060c c11060cM66626a = C11058a.m66626a(this.traceID, "pmsRestoreOneModuleError", C13452e.m80781L().m80971t0());
                    c11060cM66626a.m66665u("010_2102");
                    c11060cM66626a.m66635A("appId=" + appId + "&type=" + cloudRestoreStatus.getType() + "status=" + cloudRestoreStatus.getStatus() + "retCode=" + iPmsMove);
                    C13622a.m81968n(CacheTask.getContext(), c11060cM66626a);
                }
            }
            isRelease();
            cloudRestoreStatus.setStatus(7).setType(iPmsMove != 0 ? 2 : 1);
            this.statusOperator.m78556h(cloudRestoreStatus);
        }
    }

    private boolean restoreOneModuleBegin(CloudRestoreStatus cloudRestoreStatus) throws C9721b {
        int status;
        isRelease();
        String appId = cloudRestoreStatus.getAppId();
        if (HNConstants.DataType.MEDIA.equals(appId) || "music".equals(appId) || RestoreUtil.isSounderNotNeedCloneRestore(appId) || !(((status = cloudRestoreStatus.getStatus()) == 4 || status == 5) && cloudRestoreStatus.getType() == 1)) {
            return false;
        }
        isRelease();
        if (cloudRestoreStatus.is3rdAppType() && cloudRestoreStatus.m29532S()) {
            cloudRestoreStatus.setStatus(6).setType(0);
            if (this.isLauncherSupported && this.appRestoreOrderFromLauncher.contains(appId)) {
                ICBBroadcastManager.sendInstallEventBroadcast(CacheTask.getContext(), appId, 1);
            }
        }
        sendOneModuleMessage(cloudRestoreStatus);
        return true;
    }

    private void restoreOneModuleByClone(CloudRestoreStatus cloudRestoreStatus) throws C9721b {
        Bundle bundleRestoreCloneBundle = this.restoreClient.restoreCloneBundle(cloudRestoreStatus, this.location);
        if (bundleRestoreCloneBundle == null) {
            return;
        }
        isRelease();
        String appId = cloudRestoreStatus.getAppId();
        C25031 c25031 = new CloneService.CloneCallback() { // from class: com.huawei.android.hicloud.cloudbackup.process.CloudRestoreTask.1
            final /* synthetic */ String val$appId;
            final /* synthetic */ CloudRestoreStatus val$status;

            public C25031(String appId2, CloudRestoreStatus cloudRestoreStatus2) {
                str = appId2;
                cloudRestoreStatus = cloudRestoreStatus2;
            }

            @Override // com.huawei.android.hicloud.cloudbackup.process.CloneService.CloneCallback
            public void onCallback(Message message, int i10) {
                CloudRestoreTask.this.cloneRestoreCallback(message, cloudRestoreStatus, i10);
            }

            @Override // com.huawei.android.hicloud.cloudbackup.process.CloneService.CloneCallback
            public void onError(int i10) {
                C11839m.m70688i(CloudRestoreTask.TAG, "onError appId" + str + " code = " + i10);
                CloudRestoreTask.this.cloneError(i10, cloudRestoreStatus);
            }
        };
        CloneService.CloneErr cloneErrRestoreBundleApp = cloudRestoreStatus2.m29529P() ? restoreBundleApp(bundleRestoreCloneBundle, appId2, c25031) : cloudRestoreStatus2.m29531R() ? restoreHarmony(bundleRestoreCloneBundle, appId2, c25031) : this.cloneService.doRestoreOneModule(appId2, this.location, bundleRestoreCloneBundle, c25031);
        C11839m.m70688i(TAG, "clone restore " + appId2 + " result isSuccess = " + cloneErrRestoreBundleApp.isSuccess + ",retCode = " + cloneErrRestoreBundleApp.retCode);
        isRelease();
        if (cloneErrRestoreBundleApp.isSuccess) {
            cloudRestoreStatus2.setDoneStatusAndType(1, cloudRestoreStatus2.getType());
            return;
        }
        if (cloneErrRestoreBundleApp.retCode == 15) {
            throw new C9721b(1007, "CloneService return fail, retcode: " + cloneErrRestoreBundleApp.retCode + " | appid: " + appId2, "doRestoreOneModule");
        }
        C11060c c11060cM66626a = C11058a.m66626a(this.traceID, "restoreOneModuleError", C13452e.m80781L().m80971t0());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("appId=");
        sb2.append(appId2);
        sb2.append("&");
        sb2.append("type=");
        sb2.append(cloudRestoreStatus2.getType());
        sb2.append("status=");
        sb2.append(cloudRestoreStatus2.getStatus());
        sb2.append("retCode=");
        sb2.append(cloneErrRestoreBundleApp.retCode);
        sb2.append("entryType=");
        sb2.append(this.entryType);
        sb2.append("entranceOfRestore=");
        sb2.append(this.entranceOfRestore);
        sb2.append("isBundleApp=" + cloneErrRestoreBundleApp.isBundleAppRestore);
        c11060cM66626a.m66665u("010_2002");
        c11060cM66626a.m66635A(sb2.toString());
        C13622a.m81968n(CacheTask.getContext(), c11060cM66626a);
    }

    private synchronized void restoreOneModuleEnd(CloudRestoreStatus cloudRestoreStatus) throws C9721b {
        try {
            isLocalSpaceEnough();
            isRelease();
            sendDoneMsgOrJumpToHwlauncherIfNeed(cloudRestoreStatus, this.isLauncherSupported);
            isRelease();
            String appId = cloudRestoreStatus.getAppId();
            int status = cloudRestoreStatus.getStatus();
            int type = cloudRestoreStatus.getType();
            if (status != -8 && status != -1 && status != 1 && status != -6 && status != -5 && status != -4 && status != -3) {
                switch (status) {
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                        if (type == 1) {
                            this.successStatusList.add(cloudRestoreStatus);
                            deleteOneModuleCache(appId);
                        }
                        cloudRestoreStatus.setStatus(8);
                        break;
                }
            } else {
                this.successStatusList.add(cloudRestoreStatus);
                deleteOneModuleCache(appId);
            }
            this.statusOperator.m78556h(cloudRestoreStatus);
            C11839m.m70688i(TAG, "restore appId = " + appId + " | restore status = " + cloudRestoreStatus.getStatus() + " | restore type = " + cloudRestoreStatus.getType());
            if (status != 3) {
                sendOneModuleMessage(cloudRestoreStatus);
                return;
            }
            C11839m.m70688i(TAG, "restore appId = " + appId + " | restore is paused.");
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private void restoreSecond() throws InterruptedException, C9721b {
        C11839m.m70688i(TAG, "second stage start");
        isCancel();
        this.isRestoringThirdApp = true;
        restoreMulti(this.lastPreQueue, this.lastQueue);
        this.isRestoringThirdApp = false;
        if (!this.isLauncherSupported && this.launcherStatus != null) {
            restoreLauncher();
        }
        C11839m.m70688i(TAG, "second stage suffix start");
    }

    private void sendAbortMessage(boolean z10, Handler handler) {
        pause();
        if (z10) {
            handler.sendEmptyMessageDelayed(3202, 10000L);
        } else {
            handler.sendEmptyMessage(3202);
        }
    }

    private void sendDoneMsgOrJumpToHwlauncherIfNeed(CloudRestoreStatus cloudRestoreStatus, boolean z10) throws C9721b {
        if (z10) {
            isRelease();
            jumpToHwLanucher(cloudRestoreStatus);
            String appId = cloudRestoreStatus.getAppId();
            int status = cloudRestoreStatus.getStatus();
            int type = cloudRestoreStatus.getType();
            List<CloudRestoreStatus> list = this.thirdApplist;
            if (list == null || !list.contains(cloudRestoreStatus)) {
                return;
            }
            C11839m.m70688i(TAG, "sendDoneMsgOrJumpToHwlauncherIfNeed " + appId + ": status = " + status + "; type = " + type);
            if (status == 0 || status == 2 || status == 3) {
                return;
            }
            if (status != 6 && status != 7 && status != 8) {
                ICBBroadcastManager.sendInstallEventBroadcast(CacheTask.getContext(), appId, -1);
            } else if (type == 1) {
                ICBBroadcastManager.sendInstallEventBroadcast(CacheTask.getContext(), appId, 2);
            } else {
                ICBBroadcastManager.sendInstallEventBroadcast(CacheTask.getContext(), appId, -1);
            }
        }
    }

    private void sendFirstDoneMessage(boolean z10) {
        Message message = new Message();
        message.what = 32997;
        message.arg1 = condition() ? getErrCode() : 1002;
        message.obj = Boolean.valueOf(z10);
        callback(message);
    }

    private void sendOOBEFirstStageMsg(C9721b c9721b) throws C9721b {
        if (!isFromOOBE() || !this.isFirstStage || this.isRetry || this.manualAbort) {
            return;
        }
        if (isFirstStageFailed(this.statusOperator.m78553e())) {
            updateTagsStatus(4);
            sendFirstDoneMessage(false);
            RestoreNotification.getInstance().cancelNotification();
            if (c9721b != null) {
                throw c9721b;
            }
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "restore first stage not all done.", "onOperate");
        }
        updateTagsStatus(2);
        Collections.sort(this.successStatusList);
        ArrayList arrayList = new ArrayList();
        Iterator<CloudRestoreStatus> it = this.successStatusList.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getAppId());
        }
        callback(Message.obtain(null, 32321, arrayList));
        sendFirstDoneMessage(true);
        RestoreNotification.getInstance().notifyRestore();
    }

    private void sendOneModuleMessage(CloudRestoreStatus cloudRestoreStatus) {
        if (isAbort()) {
            return;
        }
        RestoreProgress.updateStatus(cloudRestoreStatus);
    }

    private void unRegisterV2AutoRestore(boolean z10) {
        if (z10) {
            CloudBackupJobManager.getInstance().unRegisterDsRestoreScheduler();
        } else {
            CloudBackupJobManager.getInstance().unRegisterRestoreScheduler();
        }
    }

    private void updateDeleteModuleStatus(CBSBackupRecord cBSBackupRecord) throws C9721b {
        List<CloudRestoreStatus> listM78552d = this.statusOperator.m78552d();
        final List<CBSAppInfo> appIdInfos = cBSBackupRecord.getAppIdInfos();
        for (CloudRestoreStatus cloudRestoreStatus : (List) listM78552d.stream().filter(new Predicate() { // from class: com.huawei.android.hicloud.cloudbackup.process.f0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return CloudRestoreTask.lambda$updateDeleteModuleStatus$5(appIdInfos, (CloudRestoreStatus) obj);
            }
        }).collect(Collectors.toList())) {
            if (!RestoreUtil.isModuleSuccess(cloudRestoreStatus)) {
                cloudRestoreStatus.setStatus(-8).setType(2).setCurrent(0).setSubStatus("done");
                C11839m.m70688i(TAG, "updateDeleteModuleStatus delete module, the appId is:" + cloudRestoreStatus.getAppId());
                this.statusOperator.m78556h(cloudRestoreStatus);
            }
        }
        for (CloudRestoreStatus cloudRestoreStatus2 : listM78552d) {
            Iterator<CBSAppInfo> it = appIdInfos.iterator();
            while (true) {
                if (it.hasNext()) {
                    CBSAppInfo next = it.next();
                    if (!RestoreUtil.isModuleSuccess(cloudRestoreStatus2) && cloudRestoreStatus2.is3rdAppType() && TextUtils.equals(next.getAppId(), cloudRestoreStatus2.getAppId()) && next.getSize() == 0 && cloudRestoreStatus2.getSize() != 0) {
                        C11839m.m70688i(TAG, "updateDeleteModuleStatus delete appSize, the appId is:" + cloudRestoreStatus2.getAppId());
                        cloudRestoreStatus2.setStatus(-8).setType(2).setCurrent(0).setSubStatus("done");
                        this.statusOperator.m78556h(cloudRestoreStatus2);
                        break;
                    }
                }
            }
        }
    }

    private void updateGalleryModifiedTime(CBSAppInfo cBSAppInfo) {
        if (cBSAppInfo == null) {
            return;
        }
        List<CBSFileInfo> fileInfos = cBSAppInfo.getFileInfos();
        if (fileInfos == null || fileInfos.isEmpty()) {
            C11839m.m70689w(TAG, "updateGalleryModifiedTime gallery file infos is empty");
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (CBSFileInfo cBSFileInfo : fileInfos) {
            String str = this.serverPath + HNConstants.DataType.MEDIA + "/" + cBSFileInfo.getFileName();
            Map<String, String> expandInfo = getExpandInfo(cBSFileInfo.getExpand());
            C11839m.m70686d(TAG, "serverName = " + str + "  ,hash = " + cBSFileInfo.getHash() + " ,expand = " + expandInfo);
            arrayList.add(cBSFileInfo.convert(expandInfo, str, HNConstants.DataType.MEDIA));
        }
        new C12169k().m73215r(arrayList);
    }

    private void updateTagsStatus(int i10) {
        C13029h c13029h = this.tags;
        if (c13029h != null) {
            c13029h.m78477r0(i10);
            new C13030i().m78496g(this.tags);
        }
    }

    private void waitForHwLauncherNotification(boolean z10) throws C9721b {
        boolean z11;
        if (z10) {
            Iterator<CloudRestoreStatus> it = this.thirdApplist.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z11 = false;
                    break;
                }
                CloudRestoreStatus next = it.next();
                if (next == null) {
                    C11839m.m70689w(TAG, "waitForHwLauncherNotification status is null.");
                } else if (next.getStatus() > 3 || next.getStatus() == 0) {
                    if (!next.m29520K().isEmpty()) {
                        z11 = true;
                        break;
                    }
                }
            }
            C11839m.m70688i(TAG, "waitForHwLauncherNotification need wait for launcher : " + z11);
            if (z11) {
                try {
                    C11839m.m70688i(TAG, "waitForHwLauncherNotification begin");
                    while (!this.isLauncherLayoutOk) {
                        isCancel();
                        synchronized (this.syncLockForHwLauncher) {
                            this.syncLockForHwLauncher.wait(5000L);
                        }
                    }
                    C11839m.m70688i(TAG, "waitForHwLauncherNotification end");
                } catch (InterruptedException unused) {
                    C11839m.m70688i(TAG, "waitForHwLauncherNotification catch InterruptedException.");
                }
            }
        }
    }

    @Override // com.huawei.android.hicloud.cloudbackup.process.ICBBaseTask
    public void addEntryType(LinkedHashMap<String, String> linkedHashMap) {
        super.addEntryType(linkedHashMap);
        if (linkedHashMap != null) {
            linkedHashMap.put("entryType", String.valueOf(this.entryType));
            if (isFromOOBE()) {
                return;
            }
            linkedHashMap.put("entranceOfRestore", this.entranceOfRestore);
        }
    }

    public void addRestoreSize(long j10) {
        synchronized (ICBBaseTask.LOCK) {
            this.restoreSize += j10;
        }
    }

    public void checkException(C9721b c9721b) {
        synchronized (CHECK_CEXCEPTION) {
            try {
                if (this.isModuleIgnoreRetryErr) {
                    return;
                }
                this.isModuleIgnoreRetryErr = RestoreUtil.isIgnoreRetryErr(c9721b);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.android.hicloud.cloudbackup.process.CacheTask
    public boolean condition() {
        return C10782d.m65634a().m65642i(CacheTask.getContext());
    }

    public String getBackupId() {
        return this.backupId;
    }

    public String getEntranceOfRestore() {
        return this.entranceOfRestore;
    }

    public int getEntryType() {
        return this.entryType;
    }

    @Override // com.huawei.android.hicloud.cloudbackup.process.ICBBaseTask
    public String getLocation() {
        return C10279b.m63452a(C10278a.m63442h(CacheTask.getContext().getFilesDir() + "/cloudrestore"));
    }

    @Override // com.huawei.android.hicloud.cloudbackup.process.ICBBaseTask
    public void init() throws Throwable {
        C14317j.m85300d().m85310k(2, false);
        super.init();
    }

    @Override // com.huawei.android.hicloud.cloudbackup.process.ICBBaseTask
    public void initTempDirs() throws C9721b {
        super.initTempDirs();
        File fileM63442h = C10278a.m63442h(C12583q.m75688x());
        C11839m.m70686d(TAG, "tempPmsMoveDir mkdir result: " + (!fileM63442h.exists() && fileM63442h.mkdirs()));
    }

    public boolean isModuleIgnoreRetryErr() {
        boolean z10;
        synchronized (CHECK_CEXCEPTION) {
            z10 = this.isModuleIgnoreRetryErr;
        }
        return z10;
    }

    public boolean isPaused(String str) {
        CloudRestoreStatus cloudRestoreStatusM78554f = this.statusOperator.m78554f(str);
        if (cloudRestoreStatusM78554f != null) {
            return cloudRestoreStatusM78554f.getStatus() == 2;
        }
        C11839m.m70689w(TAG, "isPaused status is null.");
        return false;
    }

    public boolean isRefurbishment() {
        return 5 == this.entryType || this.isRefurbishment;
    }

    public void moduleAwait(CloudRestoreStatus cloudRestoreStatus) throws C9721b {
        refreshLocalBytes();
        long size = cloudRestoreStatus.getSize() + cloudRestoreStatus.getAsize();
        synchronized (WAIT_LOCK) {
            while (moduleAwait(size)) {
                try {
                    WAIT_LOCK.wait();
                } catch (InterruptedException e10) {
                    C11839m.m70686d(TAG, "module sync await error, " + e10.toString());
                }
            }
            this.caches.put(cloudRestoreStatus.getAppId(), cloudRestoreStatus);
        }
    }

    public void moduleAwake(String str) {
        Object obj = WAIT_LOCK;
        synchronized (obj) {
            this.caches.remove(str);
            refreshLocalBytes();
            obj.notifyAll();
        }
    }

    @Override // com.huawei.android.hicloud.cloudbackup.process.ICBBaseTask
    public boolean noAbortCondition(int i10) {
        if (i10 == 1001 || i10 == 1004 || !C12187n.m73312i()) {
            return false;
        }
        setErrCode(i10);
        return true;
    }

    public void notifyToRestoreAppByLauncher() {
        this.isLauncherLayoutOk = true;
        synchronized (this.syncLockForHwLauncher) {
            this.syncLockForHwLauncher.notifyAll();
        }
        C11839m.m70688i(TAG, "notify to restore third app by HwLaucher end.");
    }

    @Override // com.huawei.android.hicloud.cloudbackup.process.ICBBaseTask
    public void onClose() throws SQLException {
        C11839m.m70688i(TAG, "onClose start.");
        restoreEnd();
        refreshQueryTags();
        List<CloudRestoreStatus> listM78553e = this.statusOperator.m78553e();
        restoreEndUpdateStatus(listM78553e);
        restoreEndNotifyUI(listM78553e);
        restoreEndClearStatus();
    }

    @Override // com.huawei.android.hicloud.cloudbackup.process.ICBBaseTask
    public void onOperate() throws InterruptedException, C9721b {
        C11839m.m70688i(TAG, "onOperate start");
        isCancel();
        C14317j.m85300d().m85318s(2, "V2");
        boolean z10 = !this.firstQueue.isEmpty();
        long jCurrentTimeMillis = System.currentTimeMillis();
        restoreFirst();
        if (z10) {
            reportEachStageTime(jCurrentTimeMillis, System.currentTimeMillis(), "First stage");
        }
        if (this.isLauncherSupported) {
            restoreLauncher();
        }
        C11839m.m70688i(TAG, "second stage prefix start");
        isCancel();
        restoreSecond();
        isCancel();
        boolean zHas3rdPause = has3rdPause();
        if (!zHas3rdPause) {
            restoreMulti(this.lastSufQueue);
        }
        isCancel();
        if (!hasDefault() && !zHas3rdPause) {
            updateTagsStatus(3);
        }
        C11839m.m70688i(TAG, "onOperate end");
    }

    @Override // com.huawei.android.hicloud.cloudbackup.process.ICBBaseTask
    public void onPostFix() {
        C11839m.m70688i(TAG, "onPostFix start");
        executeAsyncTask(new CacheTask.AsyncTask(new GetLastSuccessTimeAsyncTask()));
        C11839m.m70688i(TAG, "onPostFix end");
    }

    @Override // com.huawei.android.hicloud.cloudbackup.process.ICBBaseTask
    public void onPrepare() throws Throwable {
        C11839m.m70688i(TAG, "onPrepare start");
        C10782d.m65634a().m65640g(CacheTask.getContext());
        if (TextUtils.isEmpty(this.backupId) || TextUtils.isEmpty(this.deviceId)) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "deviceId and backupId is invalid.", "CloudRestoreTask_onPrepare");
        }
        recordRestoreStart();
        C13466f.m81073d().m81081i("all_moudles_restore_success", false);
        C13466f.m81073d().m81081i("has_moudles_restore_pause", false);
        CloudBackupStateUtil.recordBroadcastBackupId(2, this.backupId, isRefurbishment());
        C11839m.m70688i(TAG, "cloudRestoreTask onPrepare , entryType" + this.entryType);
        if (5 == this.entryType) {
            ICBBroadcastManager.unrestrictedCloudStateBroadcast();
            ICBBroadcastManager.sendCloudBackupStateBroadcast(2, this.backupId, false);
        }
        C12590s0.m75773M2(0L);
        C14333b.m85460P(C0241z.m1685c("1"));
        C13466f.m81073d().m81083k("restore_local_space_not_enough_size", 0L);
        RestoreUtil.setRestoreStatus(CacheTask.getContext(), true);
        this.entranceOfRestore = RestoreCache.getInstance().getEntranceOfRestore();
        new C13757a().m82647d();
        CloudBackupReport.initAppMarketVersionCode();
        CBAccess.clearDeleteTask();
        isCancel();
        lock();
        isCancel();
        openWakeLock();
        CBAccess.waitCacheClear(new InterfaceC14355b() { // from class: com.huawei.android.hicloud.cloudbackup.process.o0
            @Override // p851zp.InterfaceC14355b
            public final void execute() throws InterruptedException, C9721b {
                this.f11705a.isCancel();
            }
        });
        isCancel();
        initRestoreDetails();
        isCancel();
        C13452e.m80781L().m80909e3(0.0f);
        RestoreProgress.clearCache();
        RestoreProgress.initRestoreItems();
        CloneService.getInstance().doBindService(ParamConstants.CallbackMethod.ON_PREPARE);
        this.isPrepareError = false;
        C11839m.m70688i(TAG, "onPrepare end");
    }

    @Override // com.huawei.android.hicloud.cloudbackup.process.ICBBaseTask
    public void onStart() throws InterruptedException, C9721b {
        C11839m.m70688i(TAG, "onStart start");
        isCancel();
        C14317j.m85300d().m85324y();
        this.restoreClient.sendMessage(1, 0, RestoreUtil.isNewBmRecord());
        RestoreProgressManager.getInstance().init(isFromOOBE());
        ICBUtil.dealSystemModules(this.restoreSystemModulesOne, this.restoreSystemModulesTwoFirst, isFromOOBE());
        isCancel();
        updateDeleteModuleStatus(queryBackupRecordDetail(false));
        C14333b.m85464T(new C12521e().m75314c());
        C14333b.m85465U(new C12522f().m75318c());
        isCancel();
        ArrayList arrayList = new ArrayList();
        List<CloudRestoreStatus> listM78552d = this.statusOperator.m78552d();
        List list = (List) listM78552d.stream().filter(new Predicate() { // from class: com.huawei.android.hicloud.cloudbackup.process.h0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return CloudRestoreTask.lambda$onStart$1((CloudRestoreStatus) obj);
            }
        }).collect(Collectors.toList());
        arrayList.addAll((List) listM78552d.stream().filter(new Predicate() { // from class: com.huawei.android.hicloud.cloudbackup.process.i0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return CloudRestoreTask.lambda$onStart$2((CloudRestoreStatus) obj);
            }
        }).sorted(new Comparator() { // from class: com.huawei.android.hicloud.cloudbackup.process.j0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return this.f11701a.lambda$onStart$3((CloudRestoreStatus) obj, (CloudRestoreStatus) obj2);
            }
        }).collect(Collectors.toList()));
        arrayList.addAll(list);
        isCancel();
        addFirstQueue(arrayList);
        isCancel();
        addSecondQueue(arrayList);
        isCancel();
        if (this.galleryReports != null) {
            AlbumsTempDBManager.initDataBase(CacheTask.getContext().getApplicationContext(), this.galleryDB);
        }
        isCancel();
        C11839m.m70688i(TAG, "onStart end");
    }

    @Override // com.huawei.android.hicloud.cloudbackup.process.ICBBaseTask
    public void processBatteryNotEnough() {
        abort(1004);
    }

    @Override // com.huawei.android.hicloud.cloudbackup.process.ICBBaseTask
    public void processNetworkChanged(Context context, Handler handler) {
        C11839m.m70688i(TAG, "processNetworkChanged " + C0209d.m1333z1(context));
        if (!C0209d.m1333z1(context)) {
            C11839m.m70688i(TAG, "send abort delayed and do pause. network is not connected");
            sendAbortMessage(true, handler);
            return;
        }
        if (C0209d.m1254f2(context)) {
            C11839m.m70688i(TAG, "processNetworkChanged is wifi connected");
            C10782d.m65634a().m65651r(2);
            return;
        }
        if (!C10782d.m65634a().m65643j(context)) {
            C11839m.m70688i(TAG, "send  delayed and do pause CMD_TYPE_CBABORT_WIFI.");
            sendAbortMessage(true, handler);
            return;
        }
        int iM65636c = C10782d.m65634a().m65636c();
        int iM65637d = C10782d.m65634a().m65637d(context);
        C11839m.m70688i(TAG, "currentSlotId " + iM65637d + " slotId " + iM65636c);
        if (C10782d.m65634a().m65649p(context)) {
            if (iM65636c != 3) {
                C11839m.m70688i(TAG, "vsim send abort delayed and do pause.");
                sendAbortMessage(false, handler);
                return;
            }
            return;
        }
        if (iM65637d != iM65636c) {
            C11839m.m70688i(TAG, "send abort delayed and do pause.");
            sendAbortMessage(false, handler);
        }
    }

    @Override // com.huawei.android.hicloud.cloudbackup.process.ICBBaseTask
    public void processPowerDisconnect(HiCloudSafeIntent hiCloudSafeIntent) {
    }

    @Override // com.huawei.android.hicloud.cloudbackup.process.ICBBaseTask
    public void processScreenOff(Intent intent, Handler handler) {
    }

    @Override // com.huawei.android.hicloud.cloudbackup.process.ICBBaseTask
    public void processUserPresent(Intent intent, Handler handler) {
    }

    @Override // com.huawei.android.hicloud.cloudbackup.process.ICBBaseTask
    public void registerV2AutoRestore(boolean z10, boolean z11) {
        RestoreUtil.registerAutoRestore(z10, z11, this.tags);
    }

    @Override // com.huawei.android.hicloud.cloudbackup.process.ICBBaseTask
    public void reportEachStageTime(long j10, long j11, String str) {
        C11839m.m70686d(TAG, "report each stage time");
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("traceId", this.traceID);
        linkedHashMap.put("backupId", this.backupId);
        linkedHashMap.put("stage", str);
        linkedHashMap.put("time", String.valueOf(System.currentTimeMillis() - j10));
        linkedHashMap.put("backupVersion", "V2");
        C13225d.m79490f1().m79603z0("cloudrestore_each_stage_time", linkedHashMap);
    }

    @Override // com.huawei.android.hicloud.cloudbackup.process.ICBBaseTask
    public void reportEvent() {
        C11060c c11060cM66626a = C11058a.m66626a(this.traceID, "success", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66668x("1");
        if (this.isSuccess) {
            doSuccessReport(c11060cM66626a);
        } else {
            doFailReport(c11060cM66626a);
        }
        C14317j.m85300d().m85302a(2, c11060cM66626a.m66647c(), isRestoreDone() || this.manualAbort);
        boolean zIsFromSystemRetreadTask = CloudBackupStateUtil.isFromSystemRetreadTask(2, this.backupId);
        refreshRecoedInfoEnd();
        C11839m.m70688i(TAG, "cloudRestoreTask reportEvent , entryType" + this.entryType);
        if (5 == this.entryType) {
            ICBBroadcastManager.sendCloudBackupStateBroadcast(2, this.backupId, false);
        }
        HashMap map = new HashMap();
        C13029h c13029h = this.tags;
        if (c13029h != null) {
            boolean z10 = c13029h.m78441G() == 0 || this.tags.m78441G() == 2;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(z10 ? "[First]" : "[Last]");
            sb2.append(c11060cM66626a.m66652h());
            c11060cM66626a.m66635A(sb2.toString());
            map.put("backupBeginTime", String.valueOf(this.tags.m78469k()));
            map.put("backupEndTime", String.valueOf(System.currentTimeMillis()));
            map.put("sizeNeedBackup", String.valueOf(this.tags.m78439E()));
            map.put("restoreSize", String.valueOf(this.restoreSize));
            map.put("totalRestoreSize", String.valueOf(this.totalRestoreSize));
            map.put("backupTransID", this.tags.m78436B());
            map.put("backupId", this.backupId);
            map.put("entryType", String.valueOf(this.entryType));
            map.put("entranceOfRestore", this.entranceOfRestore);
            if (zIsFromSystemRetreadTask) {
                map.put("is_system_retread", String.valueOf(true));
            }
            this.tags.m78452R(c11060cM66626a.m66647c());
            this.tags.m78446L(this.current);
            this.tags.m78451Q(c11060cM66626a.m66646b());
            this.tags.m78447M(System.currentTimeMillis());
            updateTagsStatus(this.tags.m78441G());
            if (!this.isSuccess) {
                reportInterruptOrAuto(this.tags, "restore_interrupt_times");
                reportInterruptOrAuto(this.tags, "restore_interrupt_report");
            }
            reportEachTask(this.tags, "restore_each_period", null);
            reportEachTask(this.tags, "restore_each_size", String.valueOf(this.restoreSize));
            reportEachTask(this.tags, "restore_total_size", String.valueOf(this.totalRestoreSize));
        }
        map.put("userType", C13452e.m80781L().m80987x0());
        map.put("gradeCode", C12590s0.m75747G0());
        C13622a.m81971q(c11060cM66626a, map, false, true);
        restoreEndScheduler();
    }

    public void restoreOneModule(CloudRestoreStatus cloudRestoreStatus) {
        StringBuilder sb2;
        String appId = cloudRestoreStatus.getAppId();
        this.current = appId;
        C11839m.m70688i(TAG, "takeQueue restore one module start, appId = " + appId);
        RestoreModuleReportInfo restoreModuleReportInfo = new RestoreModuleReportInfo();
        restoreModuleReportInfo.setAppId(appId);
        try {
            try {
                if ("setting".equals(appId)) {
                    unLock();
                }
                if (restoreOneModuleBegin(cloudRestoreStatus)) {
                    new C12169k().m73216s(appId, 0);
                    restoreOneModuleByClone(cloudRestoreStatus);
                    restoreOneModule3rdData(cloudRestoreStatus);
                }
                restoreOneModuleEnd(cloudRestoreStatus);
                sb2 = new StringBuilder();
            } catch (C9721b e10) {
                setException(e10);
                checkException(e10);
                restoreModuleReportInfo.setErrorReason(e10.toString());
                sb2 = new StringBuilder();
            }
            sb2.append("takeQueue restore one module end, appId = ");
            sb2.append(appId);
            C11839m.m70688i(TAG, sb2.toString());
            restoreModuleReportInfo.update(cloudRestoreStatus);
            CloudBackupReport.reportSingleModuleRestore(restoreModuleReportInfo, this.traceID, false, this.entryType, this.entranceOfRestore, this.installedApkList.contains(appId), "1");
            moduleAwake(appId);
        } catch (Throwable th2) {
            C11839m.m70688i(TAG, "takeQueue restore one module end, appId = " + appId);
            restoreModuleReportInfo.update(cloudRestoreStatus);
            CloudBackupReport.reportSingleModuleRestore(restoreModuleReportInfo, this.traceID, false, this.entryType, this.entranceOfRestore, this.installedApkList.contains(appId), "1");
            moduleAwake(appId);
            throw th2;
        }
    }

    public List<CloudRestoreStatus> restoreStatusList() {
        return this.thirdApplist;
    }

    public synchronized void resume3rd(String str) throws C9721b {
        try {
            C11839m.m70688i(TAG, "resume3rd begin, appId = " + str);
            if (TextUtils.isEmpty(str)) {
                throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "appId is null.", "resume3rd error");
            }
            if (!this.isRestoringThirdApp) {
                throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "not allow to resume app to restore.", "resume3rd error");
            }
            CloudRestoreStatus cloudRestoreStatusM78554f = this.statusOperator.m78554f(str);
            if (cloudRestoreStatusM78554f != null) {
                addDownloadTask(cloudRestoreStatusM78554f);
                C11839m.m70688i(TAG, "resume3rd addDownloadTask success. appId = " + str);
            } else {
                C11839m.m70688i(TAG, "resume3rd status null error. appId = " + str);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public void setLauncherLayoutOk(boolean z10) {
        this.isLauncherLayoutOk = z10;
    }

    public void setTaskMyHuawei() {
        if (TextUtils.isEmpty(this.backupId) || CloudBackupStateUtil.checkBroadcastId(2, this.backupId)) {
            return;
        }
        CloudBackupStateUtil.recordBroadcastBackupId(2, this.backupId, true);
        ICBBroadcastManager.sendCloudBackupStateBroadcast(2, this.backupId, false);
    }

    @Override // com.huawei.android.hicloud.cloudbackup.process.ICBBaseTask
    public void taskErrorEnd() {
        C11839m.m70688i(TAG, "taskErrorEnd state = " + getState() + " manual abort = " + this.manualAbort + " retry = " + this.isRetry);
        if (CacheTask.State.PREPARE.equals(getState())) {
            this.isPrepareError = true;
        }
    }

    private boolean moduleAwait(long j10) throws InterruptedException, C9721b {
        isCancel();
        if (this.caches.isEmpty()) {
            return false;
        }
        final AtomicLong atomicLong = new AtomicLong();
        this.caches.forEach(new BiConsumer() { // from class: com.huawei.android.hicloud.cloudbackup.process.p0
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                CloudRestoreTask.lambda$moduleAwait$9(atomicLong, (String) obj, (CloudRestoreStatus) obj2);
            }
        });
        return j10 * 2 > this.localLeftBytes - atomicLong.get();
    }
}
