package com.huawei.android.hicloud.cloudbackup.process.task;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.huawei.android.hicloud.cloudbackup.bean.RestoreModuleReportInfo;
import com.huawei.android.hicloud.cloudbackup.broadcast.ICBBroadcastManager;
import com.huawei.android.hicloud.cloudbackup.manager.CloudBackupBaseTask;
import com.huawei.android.hicloud.cloudbackup.manager.CloudBackupModuleTask;
import com.huawei.android.hicloud.cloudbackup.process.CloudRestoreTask;
import com.huawei.android.hicloud.cloudbackup.process.RestoreUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.ProgressCallback;
import com.huawei.android.hicloud.cloudbackup.process.util.QueryOneModuleRestoreMetas;
import com.huawei.android.hicloud.cloudbackup.progress.RestoreProgress;
import com.huawei.android.hicloud.cloudbackup.progress.RestoreProgressManager;
import com.huawei.android.hicloud.cloudbackup.provider.QueryAppRestoreFromProvider;
import com.huawei.android.hicloud.cloudbackup.report.CloudBackupReport;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.android.hicloud.connect.progress.ICallback;
import com.huawei.hicloud.cloudbackup.store.database.tags.CloudRestoreStatus;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.request.notify.constant.NotifyErr;
import com.huawei.openalliance.p169ad.constant.Constants;
import fk.C9721b;
import gp.C10028c;
import hk.C10278a;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import je.C10782d;
import p015ak.C0213f;
import p015ak.C0221j;
import p037bp.C1270a;
import p232dp.InterfaceC9282a;
import p399jk.AbstractC10896a;
import p514o9.C11839m;
import p606r9.C12478a;
import p618rm.C12590s0;
import p652t9.EnumC12999a;
import pl.C12168j;
import pl.C12169k;
import pm.C12187n;
import pm.C12188o;
import tl.C13035n;

/* loaded from: classes2.dex */
public class CloudRestoreOneModuleTask extends CloudBackupModuleTask {
    private static final Object LOCK = new Object();
    private static final String TAG = "CloudRestoreOneModuleTask";
    private long alreadyDownloadSize;
    private ProgressCallback callback;
    private boolean cancel;
    private CloudRestoreTask client;
    private Set<String> compares;
    private boolean condition;
    private C9721b downloadException;
    private boolean isDownloadApk;
    private boolean isLauncherSupported;
    private int lastProgressForLauncher;
    private int lastProgressForTimer;
    private String localApkPath;
    private String location;
    private int metaListSize;
    private CloudRestoreOneModuleDownloadTask moduleDownload;
    private C13035n operator;
    private boolean pause;
    private RestoreModuleReportInfo restoreModuleReportInfo;
    private CloudRestoreStatus restoreStatus;
    private String serverPath;
    private String traceID;

    public CloudRestoreOneModuleTask(CloudRestoreTask cloudRestoreTask, CloudRestoreStatus cloudRestoreStatus, ProgressCallback progressCallback, String str, String str2, String str3, boolean z10, String str4, Set<String> set) {
        super(cloudRestoreStatus.getAppId());
        this.operator = new C13035n();
        this.condition = false;
        this.cancel = false;
        this.pause = false;
        this.metaListSize = 0;
        this.alreadyDownloadSize = 0L;
        this.isDownloadApk = false;
        this.client = cloudRestoreTask;
        this.restoreStatus = cloudRestoreStatus;
        this.callback = progressCallback;
        this.traceID = str;
        this.location = str2;
        this.serverPath = str3;
        this.isLauncherSupported = z10;
        this.localApkPath = str4;
        this.compares = set;
    }

    public static /* synthetic */ long access$314(CloudRestoreOneModuleTask cloudRestoreOneModuleTask, long j10) {
        long j11 = cloudRestoreOneModuleTask.alreadyDownloadSize + j10;
        cloudRestoreOneModuleTask.alreadyDownloadSize = j11;
        return j11;
    }

    private void createDirs() throws C9721b {
        QueryOneModuleRestoreMetas queryOneModuleRestoreMetas = new QueryOneModuleRestoreMetas(this.appId);
        int size = queryOneModuleRestoreMetas.getSize();
        this.metaListSize = size;
        if (size == 0) {
            C11839m.m70688i(TAG, "no file info in cloud. appId = " + this.appId);
            this.operator.m78557i(this.restoreStatus, 4, 1);
            return;
        }
        C11839m.m70688i(TAG, "restore files start, appId = " + this.appId + ", metas size = " + this.metaListSize);
        isCancel();
        restoreMetaDirectory(queryOneModuleRestoreMetas);
        this.restoreStatus.setSubStatus("prepareCreateDirs");
        RestoreProgress.updateStatus(this.restoreStatus);
    }

    private void dealError(int i10, C9721b c9721b) {
        C11839m.m70688i(TAG, "dealError code = " + i10);
        if (i10 == 1001 || i10 == 1007) {
            C13035n c13035n = this.operator;
            CloudRestoreStatus cloudRestoreStatus = this.restoreStatus;
            c13035n.m78557i(cloudRestoreStatus, cloudRestoreStatus.getStatus(), 2);
            this.client.setException(c9721b);
        }
        switch (i10) {
            case 1104:
            case 1105:
            case 1106:
            case NotifyErr.NET_DISABLE_HMS_ERROR /* 1107 */:
                this.operator.m78557i(this.restoreStatus, 0, 0);
                sendDownloadStatus(0);
                this.client.setException(c9721b);
                break;
            default:
                C13035n c13035n2 = this.operator;
                CloudRestoreStatus cloudRestoreStatus2 = this.restoreStatus;
                c13035n2.m78557i(cloudRestoreStatus2, cloudRestoreStatus2.getStatus(), 2);
                sendDownloadStatus(5);
                break;
        }
    }

    private String destination(C12168j c12168j) throws C9721b {
        String strM73181j = c12168j.m73181j();
        if ("1".equals(c12168j.m73178g())) {
            strM73181j = ICBUtil.getDecodedPath(strM73181j);
        }
        String strConvertToAbsolutePath = ICBUtil.convertToAbsolutePath(strM73181j, this.location, c12168j.m73172a());
        if (isStringNull(strConvertToAbsolutePath)) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "download file local path is null.");
        }
        return strConvertToAbsolutePath;
    }

    private void download() throws C9721b {
        CloudRestoreOneModuleDownloadTask cloudRestoreOneModuleDownloadTask = new CloudRestoreOneModuleDownloadTask(this.client, this.restoreStatus, this.callback, this.traceID, this.location, this.serverPath, this.isLauncherSupported, this.localApkPath, this.compares);
        this.moduleDownload = cloudRestoreOneModuleDownloadTask;
        cloudRestoreOneModuleDownloadTask.setExceptionConsumer(new Consumer() { // from class: com.huawei.android.hicloud.cloudbackup.process.task.l
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f11726a.lambda$download$0((C9721b) obj);
            }
        });
        this.moduleDownload.setDownloadApkConsumer(new Consumer() { // from class: com.huawei.android.hicloud.cloudbackup.process.task.m
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f11728a.lambda$download$1((Boolean) obj);
            }
        });
        this.moduleDownload.setReportInfoConsumer(new Consumer() { // from class: com.huawei.android.hicloud.cloudbackup.process.task.n
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f11730a.lambda$download$2((RestoreModuleReportInfo) obj);
            }
        });
        try {
            try {
                C12188o.m73320c().m73321a(this.moduleDownload, this.restoreStatus).get();
                if (this.downloadException == null) {
                    return;
                }
                C11839m.m70687e(TAG, "downloadException exist");
                throw this.downloadException;
            } catch (InterruptedException unused) {
                C11839m.m70688i(TAG, "download task InterruptedException");
                throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "download task InterruptedException, appId = " + this.appId);
            } catch (ExecutionException unused2) {
                C11839m.m70688i(TAG, "download task ExecutionException");
                throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "download task ExecutionException, appId = " + this.appId);
            }
        } finally {
            C12188o.m73320c().m73323d(this.restoreStatus);
        }
    }

    private void downloadOneFile(String str, String str2, long j10, boolean z10) throws C9721b {
        isLocalSpaceEnough(str2, j10);
        try {
            new C12478a(EnumC12999a.CLOUD_BACKUP, this.traceID).m74913i(str, str2, restoreCallback(z10));
        } catch (C9721b e10) {
            isLocalSpaceEnough(str2, j10);
            throw e10;
        }
    }

    private Context getContext() {
        return C0213f.m1377a();
    }

    private boolean isAPPExist() throws PackageManager.NameNotFoundException {
        try {
            AbstractC10896a.m65885d(TAG, "package version = " + getContext().getPackageManager().getPackageInfo(this.appId, 16384).versionName + " appId = " + this.appId);
            return true;
        } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
            return false;
        }
    }

    private void isCancel() throws C9721b {
        if (!C10782d.m65634a().m65642i(getContext())) {
            condition();
            throw new C9721b(1002, "net disable.", "isCancel");
        }
        if (this.callback.onStop()) {
            abort();
            C11839m.m70688i(TAG, "taskProgressCallback abort.");
            throw new C9721b(1001, "taskProgressCallback abort", "isCancel");
        }
        if (this.abort) {
            C11839m.m70688i(TAG, "process abort.");
            throw new C9721b(1001, "process abort", "isCancel");
        }
    }

    private boolean isEncrypt() {
        return !C10028c.m62182c0().m62420y1();
    }

    private void isLocalSpaceEnough(String str, long j10) throws C9721b {
        if (j10 <= 0 || isStringNull(str)) {
            return;
        }
        String strM1512v = C0221j.m1512v();
        String strM1514x = C0221j.m1514x();
        String strM1474B = C0221j.m1474B();
        if (isStringNull(strM1512v) || !str.startsWith(strM1512v)) {
            if (!isStringNull(strM1514x) && str.startsWith(strM1514x)) {
                strM1512v = strM1514x;
            } else if (!isStringNull(strM1474B) && str.startsWith(strM1474B)) {
                strM1512v = strM1474B;
            } else if (isStringNull(this.location) || !str.startsWith(this.location)) {
                strM1512v = null;
            }
        }
        if (isStringNull(strM1512v)) {
            return;
        }
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a == null) {
            C11839m.m70688i(TAG, "cloudAlbumRouterImpl is null");
            return;
        }
        long jMo58445o = interfaceC9282a.mo58445o(strM1512v);
        if (j10 <= jMo58445o) {
            return;
        }
        C11839m.m70688i(TAG, "checkFileSize pathAvailSize = " + jMo58445o + " ,fileSize = " + j10);
        throw new C9721b(1007, "download file " + str + " ,no space in device ,location left " + jMo58445o + " ,file need " + j10);
    }

    private boolean isNetDisconnect(C9721b c9721b) {
        C11839m.m70688i(TAG, c9721b.toString());
        int iM60659c = c9721b.m60659c();
        return 1104 == iM60659c || 1105 == iM60659c || 1106 == iM60659c || 1107 == iM60659c;
    }

    private boolean isStringNull(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isSuccess() {
        int type = this.restoreStatus.getType();
        if (!this.restoreStatus.is3rdAppType() || !this.restoreStatus.m29532S()) {
            return 1 == type;
        }
        int status = this.restoreStatus.getStatus();
        if (status != 5) {
            if (status != 6 || type == 2) {
                return false;
            }
        } else if (type != 1) {
            return false;
        }
        return true;
    }

    private void killBackgroundProcesses(CloudRestoreStatus cloudRestoreStatus) throws C9721b {
        if (cloudRestoreStatus.is3rdAppType() && cloudRestoreStatus.m29530Q() && cloudRestoreStatus.getAction() == 0) {
            String appId = cloudRestoreStatus.getAppId();
            AtomicInteger atomicInteger = new AtomicInteger(0);
            if (!ICBUtil.isForGroundProcess(this.appId, getContext(), cloudRestoreStatus.getUid(), atomicInteger)) {
                C11839m.m70688i(TAG, "killBackgroundProcesses, background localAppId = " + appId);
                return;
            }
            C11839m.m70688i(TAG, "killBackgroundProcesses, foreground localAppId = " + appId);
            this.operator.m78557i(cloudRestoreStatus, -2, 2);
            throw new C9721b(FamilyShareConstants.StatusCode.USER_HAS_JOINED_SHARE_SPACE, "app running foreground importance: " + atomicInteger.get(), "isCancel");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$download$0(C9721b c9721b) {
        this.downloadException = c9721b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$download$1(Boolean bool) {
        this.isDownloadApk = bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$download$2(RestoreModuleReportInfo restoreModuleReportInfo) {
        this.restoreModuleReportInfo.setAgdDownloadVersion(restoreModuleReportInfo.getAgdDownloadVersion());
        this.restoreModuleReportInfo.setAgdDownloadSuccess(restoreModuleReportInfo.isAgdDownloadSuccess());
        this.restoreModuleReportInfo.setPpsDownloadSuccess(restoreModuleReportInfo.isPpsDownloadSuccess());
        this.restoreModuleReportInfo.setPpsDownloadVersion(restoreModuleReportInfo.getPpsDownloadVersion());
    }

    private void makeDirectory(String str) throws C9721b {
        if (this.restoreStatus.is3rdAppType()) {
            str = ICBUtil.tranAndroidPath(str, this.appId);
        } else if ("safebox".equals(this.appId)) {
            str = ICBUtil.tranSpecialPath(str, this.appId);
        }
        C12590s0.m75820Y1(str);
    }

    private void restore3rdIcon(CloudRestoreStatus cloudRestoreStatus) throws C9721b {
        String str;
        String str2 = "";
        try {
            String str3 = this.location + "/restoreicon";
            File fileM63442h = C10278a.m63442h(str3);
            if (!fileM63442h.exists() && !fileM63442h.mkdirs()) {
                C11839m.m70687e(TAG, "3rd icon mkdirs failed.");
                return;
            }
            String appId = cloudRestoreStatus.getAppId();
            C11839m.m70686d(TAG, "download 3rd app icons start, appId = " + cloudRestoreStatus.getAppId());
            String str4 = str3 + "/" + cloudRestoreStatus.getAppId() + ".icon";
            if (isEncrypt() || cloudRestoreStatus.getAppType() != 1) {
                if (cloudRestoreStatus.m29524M().isEmpty()) {
                    C11839m.m70689w(TAG, "download 3rd app icons url is empty, appId = " + appId);
                    return;
                }
                String strM29524M = cloudRestoreStatus.m29524M();
                String strM29509A = cloudRestoreStatus.m29509A();
                if (strM29509A.endsWith(".icon")) {
                    String strReplace = strM29509A.replace(".icon", "");
                    if (!strReplace.equals(cloudRestoreStatus.m29538f())) {
                        str2 = strReplace;
                    }
                    str = str2;
                } else {
                    str = strM29509A;
                }
                C11839m.m70686d(TAG, "download standard apk icon, url = " + strM29524M + ",aid = " + cloudRestoreStatus.m29509A() + ",local path = " + str4);
                new C12478a(EnumC12999a.CLOUD_BACKUP, this.traceID).m74915k(strM29524M, str, str4, 0L, restoreCallback(false));
            } else {
                if (cloudRestoreStatus.m29522L().isEmpty()) {
                    C11839m.m70689w(TAG, "download 3rd app icons url is empty, appId = " + appId);
                    return;
                }
                String strM29522L = cloudRestoreStatus.m29522L();
                downloadOneFile(this.serverPath + appId + "/" + strM29522L.substring(strM29522L.lastIndexOf("/") + 1), str4, cloudRestoreStatus.getSize(), false);
            }
            this.operator.m78559k(cloudRestoreStatus.getAppId(), str4);
            C11839m.m70686d(TAG, "download 3rd app icons end, appId = " + cloudRestoreStatus.getAppId());
        } catch (C9721b e10) {
            C11839m.m70689w(TAG, "download 3rd app icons err, appId = " + cloudRestoreStatus.getAppId() + " " + e10.getMessage());
            int iM60659c = e10.m60659c();
            if (iM60659c != 1002) {
                switch (iM60659c) {
                    case 1104:
                    case 1105:
                    case 1106:
                    case NotifyErr.NET_DISABLE_HMS_ERROR /* 1107 */:
                        break;
                    default:
                        isCancel();
                        return;
                }
            }
            throw e10;
        }
    }

    private void restore3rdIconsBeforeLauncher() throws C9721b {
        if (this.isLauncherSupported && "HWlanucher".equals(this.appId)) {
            C11839m.m70688i(TAG, "download 3rd app icons start.");
            List<CloudRestoreStatus> listM78551c = this.operator.m78551c();
            for (CloudRestoreStatus cloudRestoreStatus : listM78551c) {
                isCancel();
                if (cloudRestoreStatus == null) {
                    C11839m.m70689w(TAG, "restore3rdIconsBeforeLauncher cloudRestoreStatus is null.");
                } else {
                    String appId = cloudRestoreStatus.getAppId();
                    int status = cloudRestoreStatus.getStatus();
                    if (status != -8 && status != -1) {
                        if (status == 8) {
                            C11839m.m70688i(TAG, "download 3rd app icon done, localAppId = " + appId);
                        } else if (status != -6 && status != -5 && status != -4 && status != -3) {
                            if (cloudRestoreStatus.m29532S()) {
                                restore3rdIcon(cloudRestoreStatus);
                            } else {
                                C11839m.m70688i(TAG, "download 3rd app icon version lower, localAppId = " + appId);
                                if (!isAPPExist()) {
                                    restore3rdIcon(cloudRestoreStatus);
                                }
                            }
                        }
                    }
                    C11839m.m70688i(TAG, "download 3rd app icon, skip localAppId = " + appId);
                }
            }
            listM78551c.clear();
            isCancel();
            List<CloudRestoreStatus> listM78551c2 = this.operator.m78551c();
            Iterator<CloudRestoreStatus> it = listM78551c2.iterator();
            boolean z10 = false;
            while (it.hasNext() && !(!it.next().m29520K().isEmpty())) {
            }
            listM78551c2.clear();
            if (z10) {
                C11839m.m70688i(TAG, " notify restore launcher start.");
                QueryAppRestoreFromProvider.notifyRestoreLauncherStart(getContext());
            }
            C11839m.m70688i(TAG, "download 3rd app icons end.");
        }
    }

    private void restoreBegin() throws C9721b {
        C11839m.m70688i(TAG, "restore one module start, appId = " + this.appId);
        this.operator.m78557i(this.restoreStatus, 4, 0);
        this.restoreStatus.setSubStatus("prepareDownloadBegin");
        RestoreProgress.updateStatus(this.restoreStatus);
        restore3rdIconsBeforeLauncher();
        killBackgroundProcesses(this.restoreStatus);
    }

    private ICallback restoreCallback(final boolean z10) {
        return new ICallback() { // from class: com.huawei.android.hicloud.cloudbackup.process.task.CloudRestoreOneModuleTask.1
            long lastPosition = 0;

            public boolean onPause() {
                return false;
            }

            @Override // com.huawei.android.hicloud.connect.progress.ICallback
            public void onProgress(long j10, long j11) {
                if (j11 == 0 || j10 > j11 || ((CloudBackupBaseTask) CloudRestoreOneModuleTask.this).abort || CloudRestoreOneModuleTask.this.callback.onStop()) {
                    return;
                }
                boolean zIs3rdAppType = CloudRestoreOneModuleTask.this.restoreStatus.is3rdAppType();
                long size = CloudRestoreOneModuleTask.this.restoreStatus.getSize();
                long asize = CloudRestoreOneModuleTask.this.restoreStatus.getAsize();
                long j12 = size + asize;
                long j13 = j10 - this.lastPosition;
                if (j13 < 0) {
                    C11839m.m70688i(CloudRestoreOneModuleTask.TAG, "send Progress, the increase is invalid. increase is:" + j13);
                    return;
                }
                CloudRestoreOneModuleTask.access$314(CloudRestoreOneModuleTask.this, j13);
                C11839m.m70686d(CloudRestoreOneModuleTask.TAG, "send Progress, value: " + j10 + " | size: " + size + "asize: " + asize + " | alreadyDownloadSize: " + CloudRestoreOneModuleTask.this.alreadyDownloadSize + " has3rdFiles: false | download3rdApp:" + z10 + " total:" + j11);
                if (CloudRestoreOneModuleTask.this.alreadyDownloadSize <= j12) {
                    RestoreProgressManager.getInstance().addBytesDownloaded(j13);
                } else {
                    j13 -= CloudRestoreOneModuleTask.this.alreadyDownloadSize - j12;
                    CloudRestoreOneModuleTask.this.alreadyDownloadSize = j12;
                }
                CloudRestoreOneModuleTask.this.restoreStatus.addBytesDownloaded(z10, j13);
                this.lastPosition = j10;
                if (zIs3rdAppType || CloudRestoreOneModuleTask.this.restoreStatus.isVirtual()) {
                    synchronized (CloudRestoreOneModuleTask.LOCK) {
                        boolean z11 = j10 == j11;
                        try {
                            if (z10) {
                                CloudRestoreOneModuleTask.this.update3rdProgress(Math.min((int) Math.floor((CloudRestoreOneModuleTask.this.alreadyDownloadSize / j11) * 100.0d), 100), z11, zIs3rdAppType);
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                }
            }

            @Override // com.huawei.android.hicloud.connect.progress.ICallback
            public boolean onStop() {
                return ((CloudBackupBaseTask) CloudRestoreOneModuleTask.this).abort || CloudRestoreOneModuleTask.this.callback.onStop();
            }
        };
    }

    private void restoreEnd(C9721b c9721b) {
        if (isSuccess()) {
            Boolean bool = Boolean.TRUE;
            boolean zEquals = bool.equals(this.restoreModuleReportInfo.isAgdDownloadSuccess());
            boolean zEquals2 = bool.equals(this.restoreModuleReportInfo.isPpsDownloadSuccess());
            C11839m.m70688i(TAG, "restoreEnd success, isAgd = " + zEquals + ", isPps = " + zEquals2);
            if (!zEquals && !zEquals2) {
                sendDownloadStatus(4);
                if (this.client.appRestoreOrderFromLauncher.contains(this.appId)) {
                    ICBBroadcastManager.sendInstallEventBroadcast(getContext(), this.appId, 0);
                }
            }
            C12187n.m73318o(this.client, this.restoreStatus);
        } else {
            if (!C10782d.m65634a().m65642i(getContext())) {
                c9721b = new C9721b(1104, "net disabled, appId = " + this.appId);
            }
            if (c9721b == null) {
                c9721b = new C9721b(1001, "download abort, appId =" + this.appId);
            }
            if (!this.abort) {
                dealError(c9721b.m60659c(), c9721b);
            } else if (this.condition || isNetDisconnect(c9721b)) {
                this.operator.m78557i(this.restoreStatus, 0, 0);
                sendDownloadStatus(0);
            } else if (this.cancel) {
                this.operator.m78557i(this.restoreStatus, 1, 0);
                sendDownloadStatus(3);
            } else if (this.pause) {
                this.operator.m78557i(this.restoreStatus, 2, 0);
                sendDownloadStatus(6);
            } else {
                C13035n c13035n = this.operator;
                CloudRestoreStatus cloudRestoreStatus = this.restoreStatus;
                c13035n.m78557i(cloudRestoreStatus, cloudRestoreStatus.getStatus(), 2);
                this.client.setException(c9721b);
            }
            this.client.checkException(c9721b);
            C12187n.m73308e(this.client, this.restoreStatus);
        }
        C11839m.m70688i(TAG, "restore one module end, appId = " + this.appId);
    }

    private void restoreMetaDirectory(QueryOneModuleRestoreMetas queryOneModuleRestoreMetas) throws C9721b {
        queryOneModuleRestoreMetas.init(5);
        if (queryOneModuleRestoreMetas.getCount() <= 0) {
            return;
        }
        C11839m.m70688i(TAG, "make directory start. appId = " + this.appId);
        C12169k c12169k = new C12169k();
        while (queryOneModuleRestoreMetas.hasNext()) {
            isCancel();
            for (C12168j c12168j : queryOneModuleRestoreMetas.next()) {
                makeDirectory(destination(c12168j));
                c12169k.m73218u(this.appId, c12168j.m73181j(), 1);
            }
        }
        this.metaListSize -= queryOneModuleRestoreMetas.getCount();
        C11839m.m70688i(TAG, "make directory end. appId = " + this.appId);
    }

    private void sendDownloadStatus(int i10) {
        if (this.restoreStatus.is3rdAppType() && this.isLauncherSupported && this.restoreStatus.m29528O()) {
            C11839m.m70688i(TAG, "sendDownloadStatus: appId = " + this.restoreStatus.getAppId() + ", status = " + i10);
            Bundle bundle = new Bundle();
            bundle.putString("packageName_", this.restoreStatus.getAppId());
            bundle.putString("name_", this.restoreStatus.getAppName());
            bundle.putInt("status_", i10);
            ICBBroadcastManager.sendDownloadEventBroadcast(getContext(), bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void update3rdProgress(int i10, boolean z10, boolean z11) {
        if (this.abort) {
            return;
        }
        if (i10 - this.lastProgressForTimer > 0 || z10) {
            this.lastProgressForTimer = i10;
            this.restoreStatus.setCurrent(i10).setCount(100);
            RestoreProgress.updateStatus(this.restoreStatus);
            if (z11 && this.restoreStatus.m29528O() && this.isLauncherSupported) {
                if (i10 - this.lastProgressForLauncher >= 10 || z10) {
                    C11839m.m70686d(TAG, "update3rd progress, appId = " + this.appId + " percent = " + i10);
                    this.lastProgressForLauncher = i10;
                    Bundle bundle = new Bundle();
                    bundle.putString("packageName_", this.appId);
                    bundle.putString("name_", this.restoreStatus.getAppName());
                    bundle.putInt("status_", 2);
                    bundle.putInt("progress_", i10);
                    ICBBroadcastManager.sendDownloadEventBroadcast(getContext(), bundle);
                }
            }
        }
    }

    @Override // com.huawei.android.hicloud.cloudbackup.manager.CloudBackupBaseTask
    public void call() {
        RestoreModuleReportInfo restoreModuleReportInfo = new RestoreModuleReportInfo();
        this.restoreModuleReportInfo = restoreModuleReportInfo;
        restoreModuleReportInfo.setAppId(this.appId);
        C9721b c9721b = null;
        try {
            try {
                this.client.moduleAwait(this.restoreStatus);
                isCancel();
                restoreBegin();
                RestoreUtil.pmsMoveCheckBeforeDownload(this.appId, this.restoreStatus.getUid());
                isCancel();
                createDirs();
                isCancel();
                download();
            } catch (Exception e10) {
                try {
                    isLocalSpaceEnough(this.location, Constants.WEB_VIEW_CACHE_TOTAL_MAX_SIZE);
                    if (e10 instanceof C9721b) {
                        e = (C9721b) e10;
                    } else {
                        e = new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "restore error. appId = " + this.appId + e10.getMessage());
                    }
                } catch (C9721b e11) {
                    e = e11;
                    C11839m.m70687e(TAG, "restore one module isLocalSpaceEnough error: " + e);
                }
                c9721b = e;
                C11839m.m70687e(TAG, "restore one module error: " + c9721b.toString());
                this.restoreModuleReportInfo.setErrorReason(c9721b.getMessage());
            }
        } finally {
            restoreEnd(c9721b);
            this.restoreModuleReportInfo.update(this.restoreStatus);
            CloudBackupReport.reportSingleModuleRestore(this.restoreModuleReportInfo, this.traceID, true, this.client.getEntryType(), this.client.getEntranceOfRestore(), this.isDownloadApk, "1");
        }
    }

    public void cancel() {
        this.cancel = true;
        this.abort = true;
        Optional.ofNullable(this.moduleDownload).ifPresent(new Consumer() { // from class: com.huawei.android.hicloud.cloudbackup.process.task.j
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((CloudRestoreOneModuleDownloadTask) obj).cancel();
            }
        });
    }

    public void condition() {
        this.condition = true;
        this.abort = true;
        Optional.ofNullable(this.moduleDownload).ifPresent(new Consumer() { // from class: com.huawei.android.hicloud.cloudbackup.process.task.o
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((CloudRestoreOneModuleDownloadTask) obj).condition();
            }
        });
    }

    public void pause() {
        this.pause = true;
        this.abort = true;
        Optional.ofNullable(this.moduleDownload).ifPresent(new Consumer() { // from class: com.huawei.android.hicloud.cloudbackup.process.task.k
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((CloudRestoreOneModuleDownloadTask) obj).pause();
            }
        });
    }

    @Override // com.huawei.android.hicloud.cloudbackup.manager.CloudBackupBaseTask
    public void cancel(boolean z10) {
        abort();
        if (!this.isRunning) {
            C12187n.m73308e(this.client, this.restoreStatus);
        }
        CloudRestoreOneModuleDownloadTask cloudRestoreOneModuleDownloadTask = this.moduleDownload;
        if (cloudRestoreOneModuleDownloadTask != null) {
            cloudRestoreOneModuleDownloadTask.cancel(z10);
        } else {
            super.cancel(z10);
        }
    }
}
