package com.huawei.android.hicloud.cloudbackup.process.task;

import al.AbstractC0242a;
import al.AbstractC0243b;
import al.C0248g;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cl.InterfaceC1446a;
import cl.InterfaceC1447b;
import cl.InterfaceC1454i;
import com.huawei.android.hicloud.cloudbackup.bean.RestoreModuleReportInfo;
import com.huawei.android.hicloud.cloudbackup.broadcast.ICBBroadcastManager;
import com.huawei.android.hicloud.cloudbackup.manager.CloudBackupBaseTask;
import com.huawei.android.hicloud.cloudbackup.manager.CloudBackupModuleTask;
import com.huawei.android.hicloud.cloudbackup.manager.CloudBackupTaskManager;
import com.huawei.android.hicloud.cloudbackup.p076db.bean.Albums;
import com.huawei.android.hicloud.cloudbackup.p076db.temp.AlbumsTempOperator;
import com.huawei.android.hicloud.cloudbackup.p076db.temp.AlbumsTempScript;
import com.huawei.android.hicloud.cloudbackup.process.CloudRestoreTask;
import com.huawei.android.hicloud.cloudbackup.process.RestoreUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.ProgressCallback;
import com.huawei.android.hicloud.cloudbackup.process.util.QueryOneModuleRestoreMetas;
import com.huawei.android.hicloud.cloudbackup.process.util.SplitFileUtil;
import com.huawei.android.hicloud.cloudbackup.progress.RestoreProgress;
import com.huawei.android.hicloud.cloudbackup.progress.RestoreProgressManager;
import com.huawei.android.hicloud.cloudbackup.report.CloudBackupReport;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.android.hicloud.connect.progress.ICallback;
import com.huawei.hicloud.base.bean.Md5AndHash;
import com.huawei.hicloud.cloudbackup.store.database.tags.CloudRestoreStatus;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.request.notify.constant.NotifyErr;
import fk.C9721b;
import gp.C10028c;
import hk.C10278a;
import hk.C10279b;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import je.C10782d;
import mk.C11476b;
import p015ak.C0213f;
import p015ak.C0221j;
import p015ak.C0241z;
import p037bp.C1270a;
import p232dp.InterfaceC9282a;
import p429kk.C11058a;
import p429kk.C11060c;
import p458lo.C11322a;
import p514o9.C11839m;
import p606r9.C12478a;
import p617rl.C12526j;
import p618rm.C12590s0;
import p652t9.EnumC12999a;
import p709vj.C13452e;
import p746wn.C13622a;
import p848zl.C14333b;
import pl.C12168j;
import pl.C12169k;
import pm.C12187n;
import pm.C12188o;
import tl.C13035n;

/* loaded from: classes2.dex */
public class CloudRestoreOneModuleDownloadTask extends CloudBackupModuleTask {
    private static final Object LOCK = new Object();
    private static final String TAG = "CloudRestoreOneModuleDownloadTask";
    private long alreadyDownloadSize;
    private final InterfaceC1447b appRestoreCallback;
    private ProgressCallback callback;
    private boolean cancel;
    private CloudRestoreTask client;
    private Set<String> compares;
    private boolean condition;
    private int current;
    private Consumer<Boolean> downloadApkConsumer;
    private int downloadIndex;
    private C9721b exception;
    private Consumer<C9721b> exceptionConsumer;
    private boolean has3rdFiles;
    private final InterfaceC1454i helper;
    private boolean isAgdSuccess;
    private boolean isDownloadApk;
    private boolean isLauncherSupported;
    private boolean isMassiveTar;
    private int lastProgressForLauncher;
    private int lastProgressForTimer;
    private String localApkPath;
    private String location;
    private int metaListSize;
    private C13035n operator;
    private Map<String, Integer> outsideAlbumInfo;
    private boolean pause;
    private Consumer<RestoreModuleReportInfo> reportInfoConsumer;
    private RestoreModuleReportInfo restoreModuleReportInfo;
    private CloudRestoreStatus restoreStatus;
    private List<String> scanList;
    private boolean sdcardFileIgnore;
    private String serverPath;
    private int total;
    private String traceID;

    public CloudRestoreOneModuleDownloadTask(CloudRestoreTask cloudRestoreTask, CloudRestoreStatus cloudRestoreStatus, ProgressCallback progressCallback, String str, String str2, String str3, boolean z10, String str4, Set<String> set) {
        super(cloudRestoreStatus.getAppId());
        this.operator = new C13035n();
        this.exception = null;
        this.condition = false;
        this.cancel = false;
        this.pause = false;
        this.current = 0;
        this.downloadIndex = 0;
        this.total = 0;
        this.metaListSize = 0;
        this.alreadyDownloadSize = 0L;
        this.scanList = new ArrayList();
        this.outsideAlbumInfo = new HashMap();
        this.isMassiveTar = false;
        this.isDownloadApk = false;
        this.isAgdSuccess = false;
        this.helper = new AbstractC0243b() { // from class: com.huawei.android.hicloud.cloudbackup.process.task.CloudRestoreOneModuleDownloadTask.2
            @Override // al.AbstractC0243b
            public String getAppId() {
                return ((CloudBackupModuleTask) CloudRestoreOneModuleDownloadTask.this).appId;
            }

            @Override // al.AbstractC0243b
            public RestoreModuleReportInfo getReportInfo() {
                return CloudRestoreOneModuleDownloadTask.this.restoreModuleReportInfo;
            }

            @Override // al.AbstractC0243b
            public long getVersionCode() {
                return CloudRestoreOneModuleDownloadTask.this.restoreStatus.getVersionCode();
            }

            @Override // al.AbstractC0243b, cl.InterfaceC1454i
            public void isAbort() throws C9721b {
                CloudRestoreOneModuleDownloadTask.this.isCancel();
            }

            @Override // al.AbstractC0243b, cl.InterfaceC1454i
            public boolean isPause() {
                return CloudRestoreOneModuleDownloadTask.this.pause;
            }
        };
        this.appRestoreCallback = new AbstractC0242a() { // from class: com.huawei.android.hicloud.cloudbackup.process.task.CloudRestoreOneModuleDownloadTask.3
            private int lastPercent;

            @Override // al.AbstractC0242a
            public RestoreModuleReportInfo getReportInfo() {
                return CloudRestoreOneModuleDownloadTask.this.restoreModuleReportInfo;
            }

            @Override // al.AbstractC0242a
            public String getTAG() {
                return CloudRestoreOneModuleDownloadTask.TAG;
            }

            @Override // al.AbstractC0242a
            public void notifyLauncher(int i10) {
                if (CloudRestoreOneModuleDownloadTask.this.client.appRestoreOrderFromLauncher.contains(((CloudBackupModuleTask) CloudRestoreOneModuleDownloadTask.this).appId)) {
                    ICBBroadcastManager.sendInstallEventBroadcast(CloudRestoreOneModuleDownloadTask.this.getContext(), ((CloudBackupModuleTask) CloudRestoreOneModuleDownloadTask.this).appId, i10);
                }
            }

            @Override // al.AbstractC0242a
            public void onDownloadFinish() {
                CloudRestoreOneModuleDownloadTask.this.operator.m78557i(CloudRestoreOneModuleDownloadTask.this.restoreStatus, 5, 1);
                CloudRestoreOneModuleDownloadTask.this.isDownloadApk = true;
                CloudRestoreOneModuleDownloadTask.this.sendDownloadStatus(4);
                if (CloudRestoreOneModuleDownloadTask.this.restoreStatus.is3rdAppType()) {
                    CloudRestoreOneModuleDownloadTask.this.restoreStatus.setCurrent(100);
                }
                RestoreProgress.updateStatus(CloudRestoreOneModuleDownloadTask.this.restoreStatus);
                C11839m.m70688i(CloudRestoreOneModuleDownloadTask.TAG, "restore3rd app success, appId = " + ((CloudBackupModuleTask) CloudRestoreOneModuleDownloadTask.this).appId);
            }

            @Override // al.AbstractC0242a
            public void onInstallFail() {
                C11839m.m70688i(CloudRestoreOneModuleDownloadTask.TAG, "restore3rd INSTALL_FAILED  app success, appId = " + ((CloudBackupModuleTask) CloudRestoreOneModuleDownloadTask.this).appId);
                CloudRestoreOneModuleDownloadTask.this.operator.m78557i(CloudRestoreOneModuleDownloadTask.this.restoreStatus, 6, 2);
                RestoreProgress.updateStatus(CloudRestoreOneModuleDownloadTask.this.restoreStatus);
            }

            @Override // al.AbstractC0242a
            public void onInstallSuccess() {
                CloudRestoreOneModuleDownloadTask.this.restoreStatus.setDoneStatusAndType(1, CloudRestoreOneModuleDownloadTask.this.restoreStatus.getType());
                CloudRestoreOneModuleDownloadTask.this.operator.m78557i(CloudRestoreOneModuleDownloadTask.this.restoreStatus, 6, 1);
                RestoreProgress.updateStatus(CloudRestoreOneModuleDownloadTask.this.restoreStatus);
                CloudRestoreOneModuleDownloadTask.this.isAgdSuccess = true;
                CloudRestoreOneModuleDownloadTask.this.isDownloadApk = true;
            }

            @Override // al.AbstractC0242a
            public void onInstalling() {
                CloudRestoreOneModuleDownloadTask.this.restoreStatus.setStatus(6).setType(0);
                RestoreProgress.updateStatus(CloudRestoreOneModuleDownloadTask.this.restoreStatus);
            }

            @Override // al.AbstractC0242a
            public void update3rdProgress(int i10, boolean z11, boolean z12) {
                long asize = CloudRestoreOneModuleDownloadTask.this.restoreStatus.getAsize();
                int i11 = this.lastPercent;
                long j10 = i10 - i11 > 0 ? (i10 - i11) * asize : 0L;
                this.lastPercent = Math.max(i11, i10);
                CloudRestoreOneModuleDownloadTask.this.restoreStatus.addBytesDownloaded(true, j10 / 100);
                RestoreProgress.updateStatus(CloudRestoreOneModuleDownloadTask.this.restoreStatus);
                CloudRestoreOneModuleDownloadTask.this.update3rdProgress(i10, z11, z12);
                C11839m.m70686d(CloudRestoreOneModuleDownloadTask.TAG, "update3rd progress, appId = " + ((CloudBackupModuleTask) CloudRestoreOneModuleDownloadTask.this).appId + " percent = " + i10 + ",lastPercent =" + this.lastPercent + ", increase =" + j10 + ", aSize =" + asize);
            }
        };
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

    public static /* synthetic */ int access$1108(CloudRestoreOneModuleDownloadTask cloudRestoreOneModuleDownloadTask) {
        int i10 = cloudRestoreOneModuleDownloadTask.downloadIndex;
        cloudRestoreOneModuleDownloadTask.downloadIndex = i10 + 1;
        return i10;
    }

    public static /* synthetic */ long access$314(CloudRestoreOneModuleDownloadTask cloudRestoreOneModuleDownloadTask, long j10) {
        long j11 = cloudRestoreOneModuleDownloadTask.alreadyDownloadSize + j10;
        cloudRestoreOneModuleDownloadTask.alreadyDownloadSize = j11;
        return j11;
    }

    public static /* synthetic */ int access$904(CloudRestoreOneModuleDownloadTask cloudRestoreOneModuleDownloadTask) {
        int i10 = cloudRestoreOneModuleDownloadTask.current + 1;
        cloudRestoreOneModuleDownloadTask.current = i10;
        return i10;
    }

    private boolean businessRestoreStandardApk(List<InterfaceC1446a> list) throws C9721b {
        boolean z10 = false;
        if (list.isEmpty()) {
            return false;
        }
        isLocalSpaceEnough(this.localApkPath + "/" + this.appId + ".apk", this.restoreStatus.getAsize());
        isCancel();
        this.restoreStatus.m29553y0(String.valueOf(1));
        Iterator<InterfaceC1446a> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            if (it.next().mo7489a(this.appId, this.appRestoreCallback, this.helper)) {
                z10 = true;
                break;
            }
            isCancel();
        }
        C11839m.m70688i(TAG, "businessRestoreStandardApk result = " + z10);
        return z10;
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

    private boolean downloadApk() throws C9721b {
        this.restoreStatus.m29553y0(String.valueOf(0));
        if (isEncrypt() || this.restoreStatus.getAppType() != 1) {
            return downloadStandardApk();
        }
        String strM29539i = this.restoreStatus.m29539i();
        downloadOneFile(this.serverPath + this.appId + "/" + strM29539i.substring(strM29539i.lastIndexOf("/") + 1), this.localApkPath + "/" + this.appId + ".apk", this.restoreStatus.getAsize(), true);
        return true;
    }

    private void downloadFilesMulti(QueryOneModuleRestoreMetas queryOneModuleRestoreMetas) throws C9721b {
        int iMin;
        int iIndexOf;
        int count = queryOneModuleRestoreMetas.getCount();
        List<String> listM85459O = C14333b.m85459O();
        int size = listM85459O.size();
        boolean z10 = false;
        if (this.restoreStatus.is3rdAppType()) {
            iIndexOf = listM85459O.indexOf(this.appId);
            iMin = iIndexOf != -1 ? 0 : Math.min(count, size);
        } else {
            iMin = 0;
            iIndexOf = -1;
        }
        HashMap map = new HashMap();
        CountDownLatch countDownLatch = new CountDownLatch(count);
        while (queryOneModuleRestoreMetas.hasNext()) {
            try {
                isCancel();
                List<C12168j> next = queryOneModuleRestoreMetas.next();
                int iMin2 = iMin;
                for (C12168j c12168j : next) {
                    isCancel();
                    if (isGalleryDbFile(c12168j.m73180i())) {
                        long jM73182k = c12168j.m73182k();
                        this.alreadyDownloadSize += jM73182k;
                        RestoreProgressManager.getInstance().addBytesDownloaded(jM73182k);
                        this.restoreStatus.addBytesDownloaded(z10, jM73182k);
                        RestoreProgress.updateStatus(this.restoreStatus);
                        countDownLatch.countDown();
                    } else {
                        if (C0241z.m1685c(c12168j.m73179h()) == 7 && this.isMassiveTar) {
                            C11839m.m70686d(TAG, "type is tar setMaxfiletasksize: " + c12168j.m73180i());
                            CloudBackupTaskManager.getInstance().setMaxFileTaskSize(2);
                        }
                        CloudBackupTaskManager.getInstance().await(new CloudBackupTaskManager.Await() { // from class: com.huawei.android.hicloud.cloudbackup.process.task.f
                            @Override // com.huawei.android.hicloud.cloudbackup.manager.CloudBackupTaskManager.Await
                            public final boolean isAbort() {
                                return this.f11721a.isAbort();
                            }
                        });
                        isCancel();
                        int i10 = iMin2 + 1;
                        CloudBackupTaskManager.getInstance().addFileTask(this.appId, new CloudRestoreOneFileTask(iMin2, c12168j, new CloudRestoreOneFileCallback(countDownLatch, map), this.location, this.compares, this.sdcardFileIgnore, this.restoreStatus));
                        iMin2 = (!this.restoreStatus.is3rdAppType() || iIndexOf == -1) ? i10 : Math.min(i10, iIndexOf);
                        z10 = false;
                    }
                }
                next.clear();
                iMin = iMin2;
                z10 = false;
            } catch (C9721b e10) {
                throwErrors(map);
                throw e10;
            }
        }
        syncLock(countDownLatch);
        throwErrors(map);
    }

    private void downloadFilesMultiPrepare() throws C9721b {
        initDownloadTotalSize();
        if (this.restoreStatus.is3rdAppType()) {
            File fileM63442h = C10278a.m63442h(ICBUtil.getLocalTarPath(this.location, this.appId));
            if (!fileM63442h.exists() && !fileM63442h.mkdirs()) {
                throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "create tar temp dir error");
            }
            boolean z10 = this.restoreStatus.m29530Q() || this.total > 1;
            this.has3rdFiles = z10;
            if (z10) {
                sendDownloadStatus(2);
            }
            this.restoreStatus.setCurrent(0).setCount(100);
            RestoreProgress.updateStatus(this.restoreStatus);
        }
        if (this.restoreStatus.isVirtual()) {
            if (this.restoreStatus.isShowRestoreProgressTotal()) {
                this.restoreStatus.setCurrent(Math.min(this.current, this.total)).setCount(this.total);
                RestoreProgress.updateStatus(this.restoreStatus);
            } else {
                this.has3rdFiles = true;
                this.restoreStatus.setCurrent(0).setCount(100);
                RestoreProgress.updateStatus(this.restoreStatus);
            }
        }
        updateCurrent(0);
        long jM75389f0 = new C12526j().m75389f0();
        long jM73211n = new C12169k().m73211n();
        C11839m.m70686d(TAG, "downloadFilesMultiPrepare appId: " + this.appId + " ,mctCount: " + jM73211n + " ,maxTarCount: " + jM75389f0);
        this.isMassiveTar = jM73211n > jM75389f0;
    }

    private void downloadGalleryDB() throws C9721b {
        C12169k c12169k = new C12169k();
        C12168j c12168jM73208k = c12169k.m73208k();
        if (c12168jM73208k == null) {
            C11839m.m70689w(TAG, "downloadGalleryDB failed, dbMeta is null.");
            this.total = this.metaListSize;
            return;
        }
        this.total = this.metaListSize - 1;
        String strDestination = destination(c12168jM73208k);
        C12590s0.m75838c2(strDestination);
        File fileM63442h = C10278a.m63442h(strDestination);
        if (fileM63442h.exists()) {
            Md5AndHash md5AndHashM68622d = C11476b.m68622d(fileM63442h);
            String hash = isEncrypt() ? md5AndHashM68622d.getHash() : md5AndHashM68622d.getMD5();
            String strM73185n = isEncrypt() ? c12168jM73208k.m73185n() : c12168jM73208k.m73184m();
            if (isStringNull(hash) || !hash.equals(strM73185n)) {
                C11839m.m70686d(TAG, "downloadGalleryDB file.delete" + fileM63442h.delete());
                isCancel();
                downloadOneFile(c12168jM73208k.m73180i(), strDestination, c12168jM73208k.m73182k(), false);
                c12168jM73208k.m73170G(1);
                c12169k.m73214q(c12168jM73208k);
                C11839m.m70688i(TAG, "downloadGalleryDB successful. appId = " + this.appId);
            }
        } else {
            isCancel();
            downloadOneFile(c12168jM73208k.m73180i(), strDestination, c12168jM73208k.m73182k(), false);
            c12168jM73208k.m73170G(1);
            c12169k.m73214q(c12168jM73208k);
            C11839m.m70688i(TAG, "downloadGalleryDB successful. appId = " + this.appId);
        }
        isCancel();
        AlbumsTempOperator albumsTempOperator = new AlbumsTempOperator();
        this.outsideAlbumInfo = albumsTempOperator.getPathAndOutSide();
        albumsTempOperator.close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void downloadOneFile(String str, String str2, long j10, boolean z10) throws C9721b {
        isLocalSpaceEnough(str2, j10);
        try {
            new C12478a(EnumC12999a.CLOUD_BACKUP, this.traceID).m74913i(str, str2, restoreCallback(z10));
        } catch (C9721b e10) {
            isLocalSpaceEnough(str2, j10);
            throw e10;
        }
    }

    private boolean downloadStandardApk() throws C9721b {
        int i10 = 0;
        if (this.restoreStatus.m29540p().isEmpty()) {
            this.operator.m78557i(this.restoreStatus, -3, 2);
            return false;
        }
        String strM29540p = this.restoreStatus.m29540p();
        long asize = this.restoreStatus.getAsize();
        String str = this.localApkPath + "/" + this.appId + ".apk";
        String strM67999F = strM29540p;
        while (true) {
            try {
                isCancel();
                C11839m.m70686d(TAG, "download standard apk, url = " + strM67999F + ",aid = " + this.restoreStatus.m29538f() + ",local path = " + str + ", size = " + asize);
                isLocalSpaceEnough(str, asize);
                new C12478a(EnumC12999a.CLOUD_BACKUP, this.traceID).m74915k(strM67999F, this.restoreStatus.m29538f(), str, asize, restoreCallback(true));
                return true;
            } catch (C9721b e10) {
                if (e10.m60659c() == 1007) {
                    throw e10;
                }
                if (i10 >= 1 || isEncrypt()) {
                    C11839m.m70689w(TAG, "downloadFile apk failed. appId = " + this.appId + e10.getMessage());
                    isLocalSpaceEnough(str, asize);
                    throw e10;
                }
                isCancel();
                C11839m.m70689w(TAG, "download app by cdn error." + e10.toString());
                strM67999F = new C11322a(this.traceID).m67999F(this.restoreStatus.m29539i());
                i10++;
            }
        }
        C11839m.m70689w(TAG, "downloadFile apk failed. appId = " + this.appId + e10.getMessage());
        isLocalSpaceEnough(str, asize);
        throw e10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context getContext() {
        return C0213f.m1377a();
    }

    private void initDownloadTotalSize() throws C9721b {
        String str = this.appId;
        str.hashCode();
        switch (str) {
            case "callRecorder":
            case "soundrecorder":
                int count = this.restoreStatus.getCount();
                if (count <= 0) {
                    count = this.metaListSize;
                }
                this.total = count;
                break;
            case "gallery":
                downloadGalleryDB();
                break;
            case "music":
                this.total = this.metaListSize;
                break;
            default:
                if (this.restoreStatus.is3rdAppType()) {
                    this.total = this.metaListSize;
                }
                if (this.restoreStatus.isShowRestoreProgressTotal()) {
                    this.total = this.metaListSize;
                    break;
                }
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void isCancel() throws C9721b {
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

    private boolean isGalleryDbFile(String str) {
        return HNConstants.DataType.MEDIA.equals(this.appId) && !isStringNull(str) && str.contains(AlbumsTempScript.DATABASE_NAME);
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

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$call$0(Consumer consumer) {
        consumer.accept(this.exception);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$call$1(Consumer consumer) {
        consumer.accept(Boolean.valueOf(this.isDownloadApk));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$call$2(Consumer consumer) {
        consumer.accept(this.restoreModuleReportInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void makeDirectory(String str) throws C9721b {
        if (this.restoreStatus.is3rdAppType()) {
            str = ICBUtil.tranAndroidPath(str, this.appId);
        } else if ("safebox".equals(this.appId)) {
            str = ICBUtil.tranSpecialPath(str, this.appId);
        }
        C12590s0.m75820Y1(str);
    }

    private void mergeDbfile() throws Throwable {
        C12169k c12169k = new C12169k();
        List<C12168j> listM73203f = c12169k.m73203f(this.appId, 9);
        HashSet hashSet = new HashSet();
        for (C12168j c12168j : listM73203f) {
            if (c12168j.m73187p() == 0) {
                throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "split db file download failed, file = " + c12168j.m73181j());
            }
            String strDestination = destination(c12168j);
            C12590s0.m75838c2(strDestination);
            hashSet.add(strDestination);
        }
        listM73203f.clear();
        if (hashSet.isEmpty()) {
            return;
        }
        List<C12168j> listM73203f2 = c12169k.m73203f(this.appId, 8);
        if (listM73203f2.isEmpty()) {
            return;
        }
        C11839m.m70688i(TAG, "mergeDbfile start");
        for (C12168j c12168j2 : listM73203f2) {
            int iM73187p = c12168j2.m73187p();
            String strDestination2 = destination(c12168j2);
            C12590s0.m75838c2(strDestination2);
            if (iM73187p != 1 && iM73187p != 2) {
                throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "big db file download failed, file = " + c12168j2.m73181j());
            }
            SplitFileUtil.mergeDbfile(strDestination2, hashSet);
            SplitFileUtil.deleteDbSplitFile(strDestination2, hashSet);
        }
        hashSet.clear();
        C11839m.m70688i(TAG, "mergeDbfile end");
    }

    private void reportActualSize() {
        long asize = this.restoreStatus.getAsize() + this.restoreStatus.getSize();
        this.client.addRestoreSize(asize);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String strM66627b = C11058a.m66627b("02015");
        linkedHashMap.put("backupTransID", this.traceID);
        linkedHashMap.put("traceId", strM66627b);
        linkedHashMap.put("appId", this.appId);
        linkedHashMap.put("actualSize", String.valueOf(asize));
        C11060c c11060cM66626a = C11058a.m66626a(this.traceID, "actualSize", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("010_200");
        String strM80987x0 = C13452e.m80781L().m80987x0();
        if (!TextUtils.isEmpty(strM80987x0)) {
            linkedHashMap.put("userType", strM80987x0);
        }
        linkedHashMap.put("gradeCode", C12590s0.m75747G0());
        C13622a.m81971q(c11060cM66626a, linkedHashMap, false, true);
    }

    private void restore3rd() throws C9721b {
        if (this.restoreStatus.is3rdAppType()) {
            this.restoreStatus.setSubStatus("downloadApp");
            long versionCode = ICBUtil.getVersionCode(getContext().getPackageManager(), this.appId);
            boolean z10 = false;
            boolean z11 = versionCode > 0;
            List<InterfaceC1446a> listM1694e = C0248g.m1694e(this.appId, versionCode, this.client.isRefurbishment(), false);
            boolean z12 = listM1694e.size() == 0;
            if (!this.restoreStatus.m29532S()) {
                if (z11 && z12) {
                    C11839m.m70688i(TAG, "restore3rd apk version lower, appId = " + this.appId);
                    RestoreProgressManager.getInstance().addBytesDownloaded(this.restoreStatus.getAsize());
                    CloudRestoreStatus cloudRestoreStatus = this.restoreStatus;
                    cloudRestoreStatus.addBytesDownloaded(true, cloudRestoreStatus.getAsize());
                    RestoreProgress.updateStatus(this.restoreStatus);
                    return;
                }
                if (!z11) {
                    this.restoreStatus.m29523L0(0);
                }
            }
            if (this.restoreStatus.m29539i().isEmpty()) {
                C11839m.m70688i(TAG, "restore3rd exit for app path is empty, appId = " + this.appId);
                this.operator.m78557i(this.restoreStatus, 5, 2);
                throw new C9721b(1009, this.appId + " restore3rd exit for app path is empty");
            }
            if (this.restoreStatus.getStatus() == 4 && this.restoreStatus.getType() == 1) {
                File fileM63442h = C10278a.m63442h(this.localApkPath);
                if (!fileM63442h.exists() && !fileM63442h.mkdirs()) {
                    C11839m.m70689w(TAG, "restore3rd mkdirs failed.");
                    this.operator.m78557i(this.restoreStatus, 5, 2);
                    return;
                }
                this.operator.m78557i(this.restoreStatus, 5, 0);
                if (!this.has3rdFiles) {
                    sendDownloadStatus(2);
                }
                try {
                    isCancel();
                    C11839m.m70688i(TAG, "restore3rd app start, appId = " + this.appId);
                    boolean z13 = this.restoreStatus.getAppType() == 3 ? !z12 : false;
                    if (z13) {
                        boolean zBusinessRestoreStandardApk = businessRestoreStandardApk(listM1694e);
                        if (!zBusinessRestoreStandardApk) {
                            this.isDownloadApk = false;
                            this.operator.m78557i(this.restoreStatus, 5, 0);
                        }
                        z10 = zBusinessRestoreStandardApk;
                    }
                    C11839m.m70688i(TAG, "startTask cloudRestoreAgdApiClient , appId = " + this.appId + ", allowBusinessRestoreDownload = " + z13 + ", appType = " + this.restoreStatus.getAppType() + " businessRestoreResult: " + z10);
                    boolean zDownloadApk = (z13 && z10) ? true : downloadApk();
                    if (!z10 && zDownloadApk) {
                        this.operator.m78557i(this.restoreStatus, 5, 1);
                    }
                    this.isDownloadApk = true;
                    C11839m.m70688i(TAG, "restore3rd app success, appId = " + this.appId);
                } catch (C9721b e10) {
                    C11839m.m70689w(TAG, "restore3rd app failed, appId = " + this.appId);
                    this.operator.m78557i(this.restoreStatus, 5, 2);
                    throw e10;
                }
            }
        }
    }

    private ICallback restoreCallback(final boolean z10) {
        return new ICallback() { // from class: com.huawei.android.hicloud.cloudbackup.process.task.CloudRestoreOneModuleDownloadTask.1
            long lastPosition = 0;

            public boolean onPause() {
                return false;
            }

            @Override // com.huawei.android.hicloud.connect.progress.ICallback
            public void onProgress(long j10, long j11) {
                if (j11 == 0 || j10 > j11 || ((CloudBackupBaseTask) CloudRestoreOneModuleDownloadTask.this).abort || CloudRestoreOneModuleDownloadTask.this.callback.onStop()) {
                    return;
                }
                boolean zIs3rdAppType = CloudRestoreOneModuleDownloadTask.this.restoreStatus.is3rdAppType();
                long size = CloudRestoreOneModuleDownloadTask.this.restoreStatus.getSize();
                long asize = CloudRestoreOneModuleDownloadTask.this.restoreStatus.getAsize();
                long j12 = size + asize;
                long j13 = j10 - this.lastPosition;
                if (j13 < 0) {
                    C11839m.m70688i(CloudRestoreOneModuleDownloadTask.TAG, "send Progress, the increase is invalid. increase is:" + j13);
                    return;
                }
                CloudRestoreOneModuleDownloadTask.access$314(CloudRestoreOneModuleDownloadTask.this, j13);
                C11839m.m70686d(CloudRestoreOneModuleDownloadTask.TAG, "send Progress, value: " + j10 + " | size: " + size + "asize: " + asize + " | alreadyDownloadSize: " + CloudRestoreOneModuleDownloadTask.this.alreadyDownloadSize + " has3rdFiles:" + CloudRestoreOneModuleDownloadTask.this.has3rdFiles + " download3rdApp:" + z10 + " total:" + j11);
                if (CloudRestoreOneModuleDownloadTask.this.alreadyDownloadSize <= j12) {
                    RestoreProgressManager.getInstance().addBytesDownloaded(j13);
                } else {
                    j13 -= CloudRestoreOneModuleDownloadTask.this.alreadyDownloadSize - j12;
                    CloudRestoreOneModuleDownloadTask.this.alreadyDownloadSize = j12;
                }
                CloudRestoreOneModuleDownloadTask.this.restoreStatus.addBytesDownloaded(z10, j13);
                RestoreProgress.updateStatus(CloudRestoreOneModuleDownloadTask.this.restoreStatus);
                this.lastPosition = j10;
                if (zIs3rdAppType || CloudRestoreOneModuleDownloadTask.this.restoreStatus.isVirtual()) {
                    synchronized (CloudRestoreOneModuleDownloadTask.LOCK) {
                        try {
                            if (!CloudRestoreOneModuleDownloadTask.this.has3rdFiles) {
                                boolean z11 = j10 == j11;
                                if (z10) {
                                    CloudRestoreOneModuleDownloadTask.this.update3rdProgress(Math.min((int) Math.floor((CloudRestoreOneModuleDownloadTask.this.alreadyDownloadSize / j11) * 100.0d), 100), z11, zIs3rdAppType);
                                }
                            } else if (!CloudRestoreOneModuleDownloadTask.this.restoreStatus.isShowRestoreProgressTotal()) {
                                int iFloor = (int) Math.floor((CloudRestoreOneModuleDownloadTask.this.alreadyDownloadSize / j12) * 100.0d);
                                CloudRestoreOneModuleDownloadTask cloudRestoreOneModuleDownloadTask = CloudRestoreOneModuleDownloadTask.this;
                                cloudRestoreOneModuleDownloadTask.update3rdProgress(iFloor, cloudRestoreOneModuleDownloadTask.alreadyDownloadSize >= j11, zIs3rdAppType);
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                }
            }

            @Override // com.huawei.android.hicloud.connect.progress.ICallback
            public boolean onStop() {
                return ((CloudBackupBaseTask) CloudRestoreOneModuleDownloadTask.this).abort || CloudRestoreOneModuleDownloadTask.this.callback.onStop();
            }
        };
    }

    private void restoreEnd(C9721b c9721b) {
        if (!isSuccess()) {
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

    private void restoreFiles() throws Throwable {
        new C12169k().m73219v(this.appId, 1, 2);
        this.restoreStatus.setSubStatus("downloadFiles");
        QueryOneModuleRestoreMetas queryOneModuleRestoreMetas = new QueryOneModuleRestoreMetas(this.appId);
        int size = queryOneModuleRestoreMetas.getSize();
        this.metaListSize = size;
        if (size == 0) {
            C11839m.m70688i(TAG, "no file info in cloud. appId = " + this.appId);
            this.operator.m78557i(this.restoreStatus, 4, 1);
            RestoreProgress.updateStatus(this.restoreStatus);
            return;
        }
        C11839m.m70688i(TAG, "restore files start, appId = " + this.appId + ", metas size = " + this.metaListSize);
        isCancel();
        downloadFilesMultiPrepare();
        isCancel();
        int[] iArr = {6, 7, 8, 9};
        for (int i10 = 0; i10 < 4; i10++) {
            int i11 = iArr[i10];
            isCancel();
            restoreMetaFiles(queryOneModuleRestoreMetas, i11);
        }
        isCancel();
        mergeDbfile();
        restoreSafeboxFile();
        isCancel();
        this.operator.m78557i(this.restoreStatus, 4, 1);
        C11839m.m70688i(TAG, "restore files end, appId = " + this.appId);
    }

    private void restoreMetaFiles(QueryOneModuleRestoreMetas queryOneModuleRestoreMetas, int i10) throws C9721b {
        long[] jArrM73207j = new C12169k().m73207j(this.appId, i10);
        int i11 = (int) jArrM73207j[0];
        long j10 = jArrM73207j[1];
        if (i11 > 0) {
            this.alreadyDownloadSize += j10;
            RestoreProgressManager.getInstance().addBytesDownloaded(j10);
            this.restoreStatus.addBytesDownloaded(false, j10);
            RestoreProgress.updateStatus(this.restoreStatus);
            int i12 = this.current + i11;
            this.current = i12;
            updateCurrent(i12);
        }
        queryOneModuleRestoreMetas.init(i10);
        if (queryOneModuleRestoreMetas.getCount() <= 0) {
            return;
        }
        C11839m.m70688i(TAG, "restore meta files start. appId = " + this.appId + " fileType = " + i10);
        try {
            isCancel();
            downloadFilesMulti(queryOneModuleRestoreMetas);
            C11839m.m70688i(TAG, "restoreFiles removeFileTask ");
            CloudBackupTaskManager.getInstance().removeFileTask(this.appId);
            C11839m.m70688i(TAG, "restore meta files end. appId = " + this.appId + " fileType = " + i10);
        } catch (Throwable th2) {
            C11839m.m70688i(TAG, "restoreFiles removeFileTask ");
            CloudBackupTaskManager.getInstance().removeFileTask(this.appId);
            throw th2;
        }
    }

    private void restoreSafeboxFile() throws C9721b {
        if ("safebox".equals(this.appId)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            try {
                ICBUtil.moveSpecialFile(this.appId, linkedHashMap);
                CloudBackupReport.reportSafeBoxRestoreErrorMsg(linkedHashMap, this.traceID);
            } catch (IOException e10) {
                C11839m.m70687e(TAG, "restoreSafeboxFile error: " + e10.toString());
                throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, e10.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendDownloadStatus(int i10) {
        if (this.restoreStatus.is3rdAppType() && this.isLauncherSupported && this.restoreStatus.m29528O()) {
            C11839m.m70688i(TAG, "sendDownloadStatus: appId = " + this.restoreStatus.getAppId() + ", status = " + i10);
            Bundle bundle = new Bundle();
            bundle.putString("packageName_", this.restoreStatus.getAppId());
            bundle.putString("name_", this.restoreStatus.getAppName());
            bundle.putInt("status_", i10);
            ICBBroadcastManager.sendDownloadEventBroadcast(getContext(), bundle);
        }
    }

    private void syncLock(CountDownLatch countDownLatch) throws C9721b {
        C11839m.m70688i(TAG, "syncLock start lock");
        while (countDownLatch.getCount() > 0) {
            try {
                isCancel();
                try {
                    if (countDownLatch.await(400L, TimeUnit.MILLISECONDS)) {
                        break;
                    }
                } catch (InterruptedException e10) {
                    C11839m.m70689w(TAG, "downloadFilesMulti lock wait error." + e10);
                    throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "downloadFilesMulti lock wait error.");
                }
            } catch (C9721b e11) {
                C11839m.m70689w(TAG, "downloadFilesMulti syncLock error." + e11);
            }
        }
        C11839m.m70688i(TAG, "syncLock end lock");
    }

    private void throwErrors(Map<String, C9721b> map) throws C9721b {
        C9721b c9721b = map.get("abort_error");
        if (c9721b != null) {
            this.operator.m78557i(this.restoreStatus, 4, 2);
            throw c9721b;
        }
        C9721b c9721b2 = map.get("normal_error");
        if (c9721b2 == null) {
            return;
        }
        this.operator.m78557i(this.restoreStatus, 4, 2);
        throw c9721b2;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCurrent(int i10) {
        String str = this.appId;
        str.hashCode();
        switch (str) {
            case "callRecorder":
            case "gallery":
            case "music":
            case "soundrecorder":
                this.restoreStatus.setCurrent(Math.min(i10, this.total));
                RestoreProgress.updateStatus(this.restoreStatus);
                this.operator.m78560l(this.restoreStatus);
                break;
        }
    }

    @Override // com.huawei.android.hicloud.cloudbackup.manager.CloudBackupBaseTask
    public void call() {
        Optional optionalOfNullable;
        Consumer consumer;
        C11839m.m70688i(TAG, "start");
        RestoreModuleReportInfo restoreModuleReportInfo = new RestoreModuleReportInfo();
        this.restoreModuleReportInfo = restoreModuleReportInfo;
        restoreModuleReportInfo.setAppId(this.appId);
        try {
            try {
                this.sdcardFileIgnore = new C12526j().m75339H0();
                isCancel();
                restoreFiles();
                isCancel();
                restore3rd();
                isCancel();
                reportActualSize();
                restoreEnd(this.exception);
                Optional.ofNullable(this.exceptionConsumer).ifPresent(new Consumer() { // from class: com.huawei.android.hicloud.cloudbackup.process.task.g
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        this.f11722a.lambda$call$0((Consumer) obj);
                    }
                });
                Optional.ofNullable(this.downloadApkConsumer).ifPresent(new Consumer() { // from class: com.huawei.android.hicloud.cloudbackup.process.task.h
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        this.f11723a.lambda$call$1((Consumer) obj);
                    }
                });
                optionalOfNullable = Optional.ofNullable(this.reportInfoConsumer);
                consumer = new Consumer() { // from class: com.huawei.android.hicloud.cloudbackup.process.task.i
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        this.f11724a.lambda$call$2((Consumer) obj);
                    }
                };
            } catch (Exception e10) {
                if (e10 instanceof C9721b) {
                    this.exception = (C9721b) e10;
                } else {
                    this.exception = new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "restore error. appId = " + this.appId + e10.getMessage());
                }
                restoreEnd(this.exception);
                Optional.ofNullable(this.exceptionConsumer).ifPresent(new Consumer() { // from class: com.huawei.android.hicloud.cloudbackup.process.task.g
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        this.f11722a.lambda$call$0((Consumer) obj);
                    }
                });
                Optional.ofNullable(this.downloadApkConsumer).ifPresent(new Consumer() { // from class: com.huawei.android.hicloud.cloudbackup.process.task.h
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        this.f11723a.lambda$call$1((Consumer) obj);
                    }
                });
                optionalOfNullable = Optional.ofNullable(this.reportInfoConsumer);
                consumer = new Consumer() { // from class: com.huawei.android.hicloud.cloudbackup.process.task.i
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        this.f11724a.lambda$call$2((Consumer) obj);
                    }
                };
            }
            optionalOfNullable.ifPresent(consumer);
        } catch (Throwable th2) {
            restoreEnd(this.exception);
            Optional.ofNullable(this.exceptionConsumer).ifPresent(new Consumer() { // from class: com.huawei.android.hicloud.cloudbackup.process.task.g
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f11722a.lambda$call$0((Consumer) obj);
                }
            });
            Optional.ofNullable(this.downloadApkConsumer).ifPresent(new Consumer() { // from class: com.huawei.android.hicloud.cloudbackup.process.task.h
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f11723a.lambda$call$1((Consumer) obj);
                }
            });
            Optional.ofNullable(this.reportInfoConsumer).ifPresent(new Consumer() { // from class: com.huawei.android.hicloud.cloudbackup.process.task.i
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f11724a.lambda$call$2((Consumer) obj);
                }
            });
            throw th2;
        }
    }

    public void cancel() {
        this.cancel = true;
        this.abort = true;
    }

    public void condition() {
        this.condition = true;
        this.abort = true;
    }

    public void pause() {
        this.pause = true;
        this.abort = true;
    }

    @Override // com.huawei.android.hicloud.cloudbackup.manager.CloudBackupModuleTask, com.huawei.android.hicloud.cloudbackup.manager.CloudBackupBaseTask
    public void release() {
        C12188o.m73320c().m73323d(this.restoreStatus);
    }

    public void setDownloadApkConsumer(Consumer<Boolean> consumer) {
        this.downloadApkConsumer = consumer;
    }

    public void setExceptionConsumer(Consumer<C9721b> consumer) {
        this.exceptionConsumer = consumer;
    }

    public void setReportInfoConsumer(Consumer<RestoreModuleReportInfo> consumer) {
        this.reportInfoConsumer = consumer;
    }

    @Override // com.huawei.android.hicloud.cloudbackup.manager.CloudBackupBaseTask
    public void cancel(boolean z10) {
        abort();
        super.cancel(z10);
    }

    public class CloudRestoreOneFileCallback implements com.huawei.android.hicloud.cloudbackup.process.task.CloudRestoreOneFileCallback {
        private static final int MAX_SCAN_NUM = 10;
        private CountDownLatch downLatch;
        private Map<String, C9721b> multiException;

        public CloudRestoreOneFileCallback(CountDownLatch countDownLatch, Map<String, C9721b> map) {
            this.downLatch = countDownLatch;
            this.multiException = map;
        }

        private boolean isAbortCode(int i10) {
            return i10 == 1002 || i10 == 1104 || i10 == 1105 || i10 == 1106 || i10 == 1107 || i10 == 1007 || i10 == 4008 || i10 == 1102;
        }

        private boolean isAbortTask(C9721b c9721b) {
            int iM60659c = c9721b.m60659c();
            C11839m.m70686d(CloudRestoreOneModuleDownloadTask.TAG, "onRestoreFailed  code" + iM60659c + "appId  " + ((CloudBackupModuleTask) CloudRestoreOneModuleDownloadTask.this).appId + CloudRestoreOneModuleDownloadTask.this.restoreStatus.getStatus());
            if (!isAbortCode(iM60659c)) {
                String str = ((CloudBackupModuleTask) CloudRestoreOneModuleDownloadTask.this).appId;
                str.hashCode();
                if (str.equals(HNConstants.DataType.MEDIA) || str.equals("music")) {
                    return false;
                }
            }
            return true;
        }

        private void outsideAlbumsCreate(String str) throws IOException {
            C11839m.m70688i(CloudRestoreOneModuleDownloadTask.TAG, "start checkOutsideAlbums");
            if (CloudRestoreOneModuleDownloadTask.this.outsideAlbumInfo.isEmpty()) {
                C11839m.m70688i(CloudRestoreOneModuleDownloadTask.TAG, "checkOutsideAlbums exit, no need to check.");
                return;
            }
            String strM1512v = C0221j.m1512v();
            String parent = C10278a.m63442h(str).getParent();
            for (Map.Entry entry : CloudRestoreOneModuleDownloadTask.this.outsideAlbumInfo.entrySet()) {
                int iIntValue = ((Integer) entry.getValue()).intValue();
                if (str.contains((CharSequence) entry.getKey())) {
                    if (iIntValue == 1) {
                        outsideFileCreate(parent);
                        return;
                    }
                    boolean zContains = str.contains(strM1512v);
                    if (zContains && iIntValue == 3) {
                        outsideFileCreate(parent);
                        return;
                    } else if (!zContains && iIntValue == 2) {
                        outsideFileCreate(parent);
                        return;
                    }
                }
            }
        }

        private void outsideFileCreate(String str) throws IOException {
            C11839m.m70686d(CloudRestoreOneModuleDownloadTask.TAG, "outsideFileCreate path = " + str);
            File fileM63442h = C10278a.m63442h(str);
            File fileM63442h2 = C10278a.m63442h(str + File.separator + Albums.OUTSIDE_FILE_NAME);
            if (!fileM63442h.exists() && fileM63442h.mkdirs()) {
                C11839m.m70689w(CloudRestoreOneModuleDownloadTask.TAG, "create .outside dir file success");
            }
            if (fileM63442h2.exists()) {
                return;
            }
            try {
                boolean zCreateNewFile = fileM63442h2.createNewFile();
                C11839m.m70689w(CloudRestoreOneModuleDownloadTask.TAG, "create .outside file result  = " + zCreateNewFile);
                if (zCreateNewFile) {
                    RestoreUtil.scanFolder(C10279b.m63452a(fileM63442h2), CloudRestoreOneModuleDownloadTask.this.getContext());
                }
            } catch (IOException unused) {
                C11839m.m70687e(CloudRestoreOneModuleDownloadTask.TAG, "create .outside file failed");
            }
        }

        private void scanFileList(List<String> list) {
            CloudRestoreOneModuleDownloadTask.this.downloadIndex += list.size();
            CloudRestoreOneModuleDownloadTask.this.scanList.addAll(list);
            if (CloudRestoreOneModuleDownloadTask.this.downloadIndex == CloudRestoreOneModuleDownloadTask.this.metaListSize || CloudRestoreOneModuleDownloadTask.this.scanList.size() >= 10) {
                RestoreUtil.scanFileList(CloudRestoreOneModuleDownloadTask.this.scanList, CloudRestoreOneModuleDownloadTask.this.getContext());
                CloudRestoreOneModuleDownloadTask.this.scanList.clear();
            }
        }

        private void sendMedialibProgress(List<String> list) {
            if (CloudRestoreOneModuleDownloadTask.this.restoreStatus.isShowRestoreProgressTotal()) {
                scanFileList(list);
                int iMin = Math.min(CloudRestoreOneModuleDownloadTask.access$904(CloudRestoreOneModuleDownloadTask.this), CloudRestoreOneModuleDownloadTask.this.total);
                CloudRestoreOneModuleDownloadTask.this.restoreStatus.setCount(CloudRestoreOneModuleDownloadTask.this.total);
                CloudRestoreOneModuleDownloadTask.this.restoreStatus.setCurrent(iMin);
                RestoreProgress.updateStatus(CloudRestoreOneModuleDownloadTask.this.restoreStatus);
                CloudRestoreOneModuleDownloadTask.this.operator.m78560l(CloudRestoreOneModuleDownloadTask.this.restoreStatus);
            }
        }

        private void setMultiException(String str, C9721b c9721b) {
            this.multiException.putIfAbsent(str, c9721b);
        }

        @Override // com.huawei.android.hicloud.cloudbackup.process.task.CloudRestoreOneFileCallback
        public void onCreateDir(String str) throws C9721b {
            CloudRestoreOneModuleDownloadTask.this.makeDirectory(str);
        }

        @Override // com.huawei.android.hicloud.cloudbackup.process.task.CloudRestoreOneFileCallback
        public void onRestoreEnd() {
            this.downLatch.countDown();
        }

        @Override // com.huawei.android.hicloud.cloudbackup.process.task.CloudRestoreOneFileCallback
        public void onRestoreFailed(C9721b c9721b) {
            synchronized (CloudRestoreOneModuleDownloadTask.LOCK) {
                try {
                    if (isAbortTask(c9721b)) {
                        setMultiException("abort_error", c9721b);
                        CloudRestoreOneModuleDownloadTask.this.abort();
                    } else {
                        setMultiException("normal_error", c9721b);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // com.huawei.android.hicloud.cloudbackup.process.task.CloudRestoreOneFileCallback
        public void onRestoreOneFile(String str, String str2, long j10) throws C9721b {
            CloudRestoreOneModuleDownloadTask.this.downloadOneFile(str, str2, j10, false);
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0059  */
        @Override // com.huawei.android.hicloud.cloudbackup.process.task.CloudRestoreOneFileCallback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onRestoreSuccess(java.lang.String r4, long r5) {
            /*
                r3 = this;
                java.lang.Object r5 = com.huawei.android.hicloud.cloudbackup.process.task.CloudRestoreOneModuleDownloadTask.access$500()
                monitor-enter(r5)
                com.huawei.android.hicloud.cloudbackup.process.task.CloudRestoreOneModuleDownloadTask r6 = com.huawei.android.hicloud.cloudbackup.process.task.CloudRestoreOneModuleDownloadTask.this     // Catch: java.lang.Throwable -> L1e
                com.huawei.hicloud.cloudbackup.store.database.tags.CloudRestoreStatus r6 = com.huawei.android.hicloud.cloudbackup.process.task.CloudRestoreOneModuleDownloadTask.access$200(r6)     // Catch: java.lang.Throwable -> L1e
                boolean r6 = r6.isVirtual()     // Catch: java.lang.Throwable -> L1e
                if (r6 == 0) goto L21
                java.util.ArrayList r6 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L1e
                r6.<init>()     // Catch: java.lang.Throwable -> L1e
                r6.add(r4)     // Catch: java.lang.Throwable -> L1e
                r3.sendMedialibProgress(r6)     // Catch: java.lang.Throwable -> L1e
                monitor-exit(r5)     // Catch: java.lang.Throwable -> L1e
                return
            L1e:
                r3 = move-exception
                goto La2
            L21:
                com.huawei.android.hicloud.cloudbackup.process.task.CloudRestoreOneModuleDownloadTask r6 = com.huawei.android.hicloud.cloudbackup.process.task.CloudRestoreOneModuleDownloadTask.this     // Catch: java.lang.Throwable -> L1e
                int r0 = com.huawei.android.hicloud.cloudbackup.process.task.CloudRestoreOneModuleDownloadTask.access$904(r6)     // Catch: java.lang.Throwable -> L1e
                com.huawei.android.hicloud.cloudbackup.process.task.CloudRestoreOneModuleDownloadTask.access$1000(r6, r0)     // Catch: java.lang.Throwable -> L1e
                com.huawei.android.hicloud.cloudbackup.process.task.CloudRestoreOneModuleDownloadTask r6 = com.huawei.android.hicloud.cloudbackup.process.task.CloudRestoreOneModuleDownloadTask.this     // Catch: java.lang.Throwable -> L1e
                com.huawei.android.hicloud.cloudbackup.process.task.CloudRestoreOneModuleDownloadTask.access$1108(r6)     // Catch: java.lang.Throwable -> L1e
                com.huawei.android.hicloud.cloudbackup.process.task.CloudRestoreOneModuleDownloadTask r6 = com.huawei.android.hicloud.cloudbackup.process.task.CloudRestoreOneModuleDownloadTask.this     // Catch: java.lang.Throwable -> L1e
                java.lang.String r6 = com.huawei.android.hicloud.cloudbackup.process.task.CloudRestoreOneModuleDownloadTask.access$1200(r6)     // Catch: java.lang.Throwable -> L1e
                int r0 = r6.hashCode()     // Catch: java.lang.Throwable -> L1e
                r1 = -196315310(0xfffffffff44c7752, float:-6.479789E31)
                r2 = 1
                if (r0 == r1) goto L4f
                r1 = 104263205(0x636ee25, float:3.4405356E-35)
                if (r0 == r1) goto L45
                goto L59
            L45:
                java.lang.String r0 = "music"
                boolean r6 = r6.equals(r0)     // Catch: java.lang.Throwable -> L1e
                if (r6 == 0) goto L59
                r6 = 0
                goto L5a
            L4f:
                java.lang.String r0 = "gallery"
                boolean r6 = r6.equals(r0)     // Catch: java.lang.Throwable -> L1e
                if (r6 == 0) goto L59
                r6 = r2
                goto L5a
            L59:
                r6 = -1
            L5a:
                if (r6 == 0) goto L63
                if (r6 == r2) goto L5f
                goto La0
            L5f:
                r3.outsideAlbumsCreate(r4)     // Catch: java.lang.Throwable -> L1e
                goto La0
            L63:
                com.huawei.android.hicloud.cloudbackup.process.task.CloudRestoreOneModuleDownloadTask r6 = com.huawei.android.hicloud.cloudbackup.process.task.CloudRestoreOneModuleDownloadTask.this     // Catch: java.lang.Throwable -> L1e
                java.util.List r6 = com.huawei.android.hicloud.cloudbackup.process.task.CloudRestoreOneModuleDownloadTask.access$1300(r6)     // Catch: java.lang.Throwable -> L1e
                r6.add(r4)     // Catch: java.lang.Throwable -> L1e
                com.huawei.android.hicloud.cloudbackup.process.task.CloudRestoreOneModuleDownloadTask r4 = com.huawei.android.hicloud.cloudbackup.process.task.CloudRestoreOneModuleDownloadTask.this     // Catch: java.lang.Throwable -> L1e
                int r4 = com.huawei.android.hicloud.cloudbackup.process.task.CloudRestoreOneModuleDownloadTask.access$1100(r4)     // Catch: java.lang.Throwable -> L1e
                com.huawei.android.hicloud.cloudbackup.process.task.CloudRestoreOneModuleDownloadTask r6 = com.huawei.android.hicloud.cloudbackup.process.task.CloudRestoreOneModuleDownloadTask.this     // Catch: java.lang.Throwable -> L1e
                int r6 = com.huawei.android.hicloud.cloudbackup.process.task.CloudRestoreOneModuleDownloadTask.access$1400(r6)     // Catch: java.lang.Throwable -> L1e
                if (r4 == r6) goto L88
                com.huawei.android.hicloud.cloudbackup.process.task.CloudRestoreOneModuleDownloadTask r4 = com.huawei.android.hicloud.cloudbackup.process.task.CloudRestoreOneModuleDownloadTask.this     // Catch: java.lang.Throwable -> L1e
                java.util.List r4 = com.huawei.android.hicloud.cloudbackup.process.task.CloudRestoreOneModuleDownloadTask.access$1300(r4)     // Catch: java.lang.Throwable -> L1e
                int r4 = r4.size()     // Catch: java.lang.Throwable -> L1e
                r6 = 10
                if (r4 < r6) goto La0
            L88:
                com.huawei.android.hicloud.cloudbackup.process.task.CloudRestoreOneModuleDownloadTask r4 = com.huawei.android.hicloud.cloudbackup.process.task.CloudRestoreOneModuleDownloadTask.this     // Catch: java.lang.Throwable -> L1e
                java.util.List r4 = com.huawei.android.hicloud.cloudbackup.process.task.CloudRestoreOneModuleDownloadTask.access$1300(r4)     // Catch: java.lang.Throwable -> L1e
                com.huawei.android.hicloud.cloudbackup.process.task.CloudRestoreOneModuleDownloadTask r6 = com.huawei.android.hicloud.cloudbackup.process.task.CloudRestoreOneModuleDownloadTask.this     // Catch: java.lang.Throwable -> L1e
                android.content.Context r6 = com.huawei.android.hicloud.cloudbackup.process.task.CloudRestoreOneModuleDownloadTask.access$1500(r6)     // Catch: java.lang.Throwable -> L1e
                com.huawei.android.hicloud.cloudbackup.process.RestoreUtil.scanFileList(r4, r6)     // Catch: java.lang.Throwable -> L1e
                com.huawei.android.hicloud.cloudbackup.process.task.CloudRestoreOneModuleDownloadTask r3 = com.huawei.android.hicloud.cloudbackup.process.task.CloudRestoreOneModuleDownloadTask.this     // Catch: java.lang.Throwable -> L1e
                java.util.List r3 = com.huawei.android.hicloud.cloudbackup.process.task.CloudRestoreOneModuleDownloadTask.access$1300(r3)     // Catch: java.lang.Throwable -> L1e
                r3.clear()     // Catch: java.lang.Throwable -> L1e
            La0:
                monitor-exit(r5)     // Catch: java.lang.Throwable -> L1e
                return
            La2:
                monitor-exit(r5)     // Catch: java.lang.Throwable -> L1e
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.cloudbackup.process.task.CloudRestoreOneModuleDownloadTask.CloudRestoreOneFileCallback.onRestoreSuccess(java.lang.String, long):void");
        }

        @Override // com.huawei.android.hicloud.cloudbackup.process.task.CloudRestoreOneFileCallback
        public String tranAndroidPath(String str, String str2) {
            return CloudRestoreOneModuleDownloadTask.this.restoreStatus.is3rdAppType() ? ICBUtil.tranAndroidPath(str, str2) : "safebox".equals(str2) ? ICBUtil.tranSpecialPath(str, str2) : str;
        }

        @Override // com.huawei.android.hicloud.cloudbackup.process.task.CloudRestoreOneFileCallback
        public void onRestoreSuccess(List<String> list) {
            synchronized (CloudRestoreOneModuleDownloadTask.LOCK) {
                sendMedialibProgress(list);
            }
        }
    }
}
