package com.huawei.android.hicloud.cloudbackup.process;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.SQLException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.os.UserHandle;
import android.text.TextUtils;
import androidx.core.content.p019pm.PackageInfoCompat;
import com.huawei.android.backup.filelogic.utils.PmsCheckUtil;
import com.huawei.android.hicloud.cloudbackup.bean.AbsThermalControl;
import com.huawei.android.hicloud.cloudbackup.bean.AppInfoList;
import com.huawei.android.hicloud.cloudbackup.bean.CloudBackup;
import com.huawei.android.hicloud.cloudbackup.callable.CBCallBack;
import com.huawei.android.hicloud.cloudbackup.jobscheduler.CloudBackupJobManager;
import com.huawei.android.hicloud.cloudbackup.manager.CloudBackupTaskManager;
import com.huawei.android.hicloud.cloudbackup.p076db.bean.Settings;
import com.huawei.android.hicloud.cloudbackup.p076db.operator.SettingOperator;
import com.huawei.android.hicloud.cloudbackup.p076db.temp.AlbumsTempDBManager;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator.PmsFullBriefFilesInfoOperator;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator.PmsMetaStatusOperator;
import com.huawei.android.hicloud.cloudbackup.process.MusicBackup;
import com.huawei.android.hicloud.cloudbackup.process.notification.CloudBackupSuccessNotifyTask;
import com.huawei.android.hicloud.cloudbackup.process.task.CloudBackupCreateCallback;
import com.huawei.android.hicloud.cloudbackup.process.task.CloudBackupCreateManager;
import com.huawei.android.hicloud.cloudbackup.process.task.CloudBackupCreateTask;
import com.huawei.android.hicloud.cloudbackup.process.task.CloudBackupOneModuleTask;
import com.huawei.android.hicloud.cloudbackup.process.task.DeleteRecordsTask;
import com.huawei.android.hicloud.cloudbackup.process.task.ICBTarTaskCallback;
import com.huawei.android.hicloud.cloudbackup.process.task.ICBTaskCallback;
import com.huawei.android.hicloud.cloudbackup.process.task.IOneModuleTaskCallback;
import com.huawei.android.hicloud.cloudbackup.process.task.TarFileUploadTask;
import com.huawei.android.hicloud.cloudbackup.process.task.UploadTask;
import com.huawei.android.hicloud.cloudbackup.process.util.AppDataSizeUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.BackupCacheRecord;
import com.huawei.android.hicloud.cloudbackup.process.util.CloudBackupAppDataUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.CloudBackupConditionsUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.ProgressCallback;
import com.huawei.android.hicloud.cloudbackup.process.util.ScanAppDataUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.ThermalChecker;
import com.huawei.android.hicloud.cloudbackup.snapshottree.QueryBackupMeta;
import com.huawei.android.hicloud.cloudbackup.snapshottree.QueryRetryUploadMeta;
import com.huawei.android.hicloud.cloudbackup.snapshottree.SnapshotTreeManagementService;
import com.huawei.android.hicloud.cloudbackup.snapshottree.SnapshotTreeUtil;
import com.huawei.android.hicloud.cloudbackup.snapshottree.bean.SnapshotNode;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.bean.BackupRecordMeta;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.bean.SnapshotBackupMeta;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.operator.SnapshotBackupMetaOperator;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackupLanguageUtil;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackupStateUtil;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackupUtil;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.android.hicloud.cloudbackup.util.TransferedUtil;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p081cs.bean.UploadReq;
import com.huawei.android.hicloud.p088ui.notification.BackupNotificationManager;
import com.huawei.android.hicloud.p088ui.uiutil.NewHiSyncUtil;
import com.huawei.android.hicloud.security.service.UserKeyUtils;
import com.huawei.android.hicloud.sync.protocol.SyncProtocol;
import com.huawei.android.hicloud.task.simple.C3017c;
import com.huawei.fastengine.fastview.NavigationUtils;
import com.huawei.feedback.mail.zip.p099sp.SharedPreferencesStorage;
import com.huawei.hicloud.base.bean.CloudSpace;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.bean.SyncConfigService;
import com.huawei.hicloud.cloudbackup.p104v3.model.BackupItem;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.About;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudBackupStatus;
import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.data.BackupSpaceNotEnoughNeedData;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.request.cbs.bean.CBSAppInfo;
import com.huawei.hicloud.request.cbs.bean.CBSBackupRecord;
import com.huawei.hicloud.request.cbs.bean.CBSCreateAppBackupRecordReq;
import com.huawei.hicloud.request.cbs.bean.CBSFileInfo;
import com.huawei.hicloud.request.cbs.bean.CBSFilterModule;
import com.huawei.hicloud.request.cbs.bean.CBSInitParam;
import com.huawei.hicloud.request.cbs.bean.CBSLockAndFlowControlReq;
import com.huawei.hicloud.request.cbs.bean.CBSbkFlowHead;
import com.huawei.hicloud.request.opengw.bean.Result;
import com.huawei.hms.support.api.entity.sns.SNSCode;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.openalliance.p169ad.constant.ParamConstants;
import com.huawei.openalliance.p169ad.constant.VastAttribute;
import com.huawei.secure.android.common.util.SafeString;
import com.tencent.p204mm.opensdk.constants.ConstantsAPI;
import fk.C9721b;
import hk.C10278a;
import hk.C10279b;
import hu.C10343b;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import je.C10782d;
import om.C11963c;
import om.C11965e;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0214f0;
import p015ak.C0224k0;
import p015ak.C0237v;
import p015ak.C0241z;
import p020ap.C1006a;
import p292fn.C9733f;
import p336he.C10152c;
import p400jl.C10897a;
import p429kk.C11058a;
import p429kk.C11060c;
import p458lo.C11322a;
import p495nm.C11725f;
import p495nm.C11726g;
import p514o9.C11835i;
import p514o9.C11839m;
import p529op.C11979a;
import p572qb.C12299b;
import p606r9.C12478a;
import p616rk.C12515a;
import p617rl.C12519c;
import p617rl.C12526j;
import p618rm.C12565k;
import p618rm.C12571m;
import p618rm.C12585q1;
import p618rm.C12586r;
import p618rm.C12590s0;
import p618rm.C12606x1;
import p652t9.EnumC12999a;
import p664u0.C13108a;
import p673u9.C13136a;
import p673u9.C13140e;
import p673u9.C13141f;
import p674ub.C13148e;
import p682ul.C13216j;
import p684un.C13225d;
import p684un.C13230i;
import p709vj.C13452e;
import p711vl.C13465e;
import p711vl.C13466f;
import p711vl.C13467g;
import p744wl.C13617a;
import p746wn.C13622a;
import p814yl.C13998b0;
import p847zk.C14317j;
import p848zl.C14333b;
import pm.C12176c;
import sl.C12815f;
import tl.C13026e;
import tl.C13027f;
import tl.C13028g;
import tl.C13029h;
import tl.C13030i;
import to.C13049a;

/* loaded from: classes2.dex */
public class CloudBackupTask extends ICBBaseTask {
    private static final Object APP_DATA_PREAPRE_LOCK = new Object();
    private static final int BACKUP_TYPE_AUTO = 1;
    private static final int BACKUP_TYPE_MANUL = 0;
    private static final int FILE_SIZE_MIN_APP_DATA = 4;
    private static final int INC_TYPE_FULLBACKUP = 1;
    private static final int INVALID_ACCESS_HTTP_STATUS = 999;
    private static final long ONE_HOUR_TIMEMILLIS = 3600000;
    private static final String TAG = "CloudBackupTask";
    private static final String TAR_DIR = "tar";
    private List<String> appBlackList;
    private boolean autoBackup;
    private int autoBackupUserPresentTimes;
    private Map<String, Bundle> backupCaches;
    private C12526j backupConfigOperator;
    private C13027f backupRecordInfoOperator;
    private long backupSize;
    private C11725f bakId;
    private long cacheDuration;
    private Map<String, SnapshotBackupMeta> currentAppMetas;
    private CloudBackupStatus currentBackupStatus;
    private long dataCacheDuration;
    private List<String> disableIds;
    private int fileNum;
    private long fileSize;
    private Map<String, String> filterModule;
    private int firstBackupType;
    private Map<String, SnapshotBackupMeta> foregroundAppModuleMap;
    private C13049a gwService;
    private CBSBackupRecord inBackupV2Record;
    private List<String> inBackupingRecrdIds;
    private long incrementSize;
    private int index;
    private boolean isAbortByTemperatureControl;
    private boolean isAppDataPreparing;
    private boolean isConvertAndroidData;
    private boolean isFullBackup;
    private boolean isPmsSupportGetBriefCmd;
    private boolean isSupportGallery;
    private boolean isSupportMusic;
    private boolean isUseCache;
    private C13026e itemOperator;
    private Map<String, SnapshotBackupMeta> lastAppMetas;
    private String lastSuccessBackupId;
    private C13028g mBackupRecordInfos;
    private MusicBackup mMusicBackup;
    private int mProgress;
    private long mkfileBackupSize;
    private int moduleAllFileCount;
    private List<CBSFilterModule> moduleBlacks;
    private boolean needDownloadInBackupingSnapshot;
    private long needUploadedSize;
    private LinkedHashMap<String, String> onModuleReport;
    private long oneModuleActualSize;
    private Queue<SnapshotBackupMeta> queue;
    private String recordExtend;
    private long repeatCount;
    private long repeatSize;
    private int sdcardAcptErrNum;
    private int sdcardAcptErrRate;
    private C11322a service;
    private SnapshotTreeManagementService snapshotTreeService;
    private int successNum;
    private boolean switch3rdDefault;
    private List<String> sysAppId;
    private volatile C13029h tags;
    private int thermalLevel;
    private List<String> thirdAppId;
    private CBLockAndFlowControlManager timer;
    private long totalBackupSize;
    private int uploadSize;
    private long uploadedFileSize;
    private List<String> virtualList;
    private Map<String, List<String>> whites;

    public CloudBackupTask(boolean z10, String str) {
        super(C13452e.m80781L().m80950o(), C13452e.m80781L().m80978v());
        this.sysAppId = new ArrayList();
        this.virtualList = new ArrayList();
        this.thirdAppId = new ArrayList();
        this.onModuleReport = new LinkedHashMap<>();
        this.whites = new HashMap();
        this.appBlackList = new ArrayList();
        this.moduleBlacks = new ArrayList();
        this.filterModule = new HashMap();
        this.lastAppMetas = new HashMap();
        this.currentAppMetas = new HashMap();
        this.foregroundAppModuleMap = new HashMap();
        this.queue = new ConcurrentLinkedDeque();
        this.backupCaches = new LinkedHashMap();
        this.inBackupingRecrdIds = new ArrayList();
        this.inBackupV2Record = null;
        this.disableIds = new ArrayList();
        this.needDownloadInBackupingSnapshot = false;
        this.isSupportGallery = true;
        this.isSupportMusic = true;
        this.repeatSize = 0L;
        this.repeatCount = 0L;
        this.index = 0;
        this.uploadSize = 0;
        this.moduleAllFileCount = 0;
        this.successNum = 0;
        this.totalBackupSize = 0L;
        this.backupSize = 0L;
        this.oneModuleActualSize = 0L;
        this.fileSize = 0L;
        this.fileNum = 0;
        this.uploadedFileSize = 0L;
        this.isAppDataPreparing = false;
        this.isAbortByTemperatureControl = false;
        this.thermalLevel = -1;
        this.firstBackupType = 0;
        this.mkfileBackupSize = 0L;
        this.needUploadedSize = 0L;
        this.incrementSize = 0L;
        this.isUseCache = false;
        this.switch3rdDefault = false;
        this.isPmsSupportGetBriefCmd = true;
        this.mBackupRecordInfos = new C13028g();
        this.backupRecordInfoOperator = new C13027f();
        this.isConvertAndroidData = false;
        this.autoBackupUserPresentTimes = 0;
        this.autoBackup = z10;
        this.backupType = z10 ? 1 : 0;
        this.traceID = str;
        this.service = new C11322a(str);
        this.gwService = new C13049a(EnumC12999a.CLOUD_BACKUP, str);
        SnapshotTreeManagementService snapshotTreeManagementService = SnapshotTreeManagementService.getInstance();
        this.snapshotTreeService = snapshotTreeManagementService;
        snapshotTreeManagementService.clear();
        this.itemOperator = new C13026e();
        this.backupConfigOperator = new C12526j();
        this.powerKitApplyType = BackupPowerKitKeepTimer.getInstance().getApplyType(z10);
    }

    private void aboutTimesRequest() throws C9721b {
        if (this.autoBackup) {
            C11839m.m70688i(TAG, "aboutTimesRequest auto backup return");
            return;
        }
        C11839m.m70688i(TAG, "start about request");
        About aboutM84094A = new C13998b0().m84094A("times,refEffeDays,refEffeDelayDays", this.traceID, CBSbkFlowHead.BKMODE_MANUAL);
        C12176c.m73260b(aboutM84094A, this.autoBackup);
        C12176c.m73269l(aboutM84094A);
    }

    public static /* synthetic */ int access$008(CloudBackupTask cloudBackupTask) {
        int i10 = cloudBackupTask.successNum;
        cloudBackupTask.successNum = i10 + 1;
        return i10;
    }

    public static /* synthetic */ int access$012(CloudBackupTask cloudBackupTask, int i10) {
        int i11 = cloudBackupTask.successNum + i10;
        cloudBackupTask.successNum = i11;
        return i11;
    }

    public static /* synthetic */ int access$110(CloudBackupTask cloudBackupTask) {
        int i10 = cloudBackupTask.uploadSize;
        cloudBackupTask.uploadSize = i10 - 1;
        return i10;
    }

    public static /* synthetic */ int access$120(CloudBackupTask cloudBackupTask, int i10) {
        int i11 = cloudBackupTask.uploadSize - i10;
        cloudBackupTask.uploadSize = i11;
        return i11;
    }

    public static /* synthetic */ long access$614(CloudBackupTask cloudBackupTask, long j10) {
        long j11 = cloudBackupTask.backupSize + j10;
        cloudBackupTask.backupSize = j11;
        return j11;
    }

    public static /* synthetic */ long access$714(CloudBackupTask cloudBackupTask, long j10) {
        long j11 = cloudBackupTask.oneModuleActualSize + j10;
        cloudBackupTask.oneModuleActualSize = j11;
        return j11;
    }

    private CloudBackupOneModuleTask buildBackupOneModuleTask(boolean z10, CloudBackupStatus cloudBackupStatus, SnapshotBackupMeta snapshotBackupMeta, CloudBackupAppDataUtil cloudBackupAppDataUtil) throws C9721b {
        CloudBackupOneModuleTask cloudBackupOneModuleTask = new CloudBackupOneModuleTask(snapshotBackupMeta, cloudBackupStatus, this.progressCallback, this.location, this.backupId, this.traceID, this.serverPath, cloudBackupAppDataUtil, z10, this.lastSuccessBackupId, this, this.autoBackup);
        setOneModuleTaskCallback(cloudBackupOneModuleTask);
        return cloudBackupOneModuleTask;
    }

    private CloudBackupAppDataUtil buildDataUtil(SnapshotBackupMeta snapshotBackupMeta) throws C9721b {
        CloudBackupAppDataUtil cloudBackupAppDataUtil;
        if (this.thirdAppId.contains(this.current)) {
            try {
                cloudBackupAppDataUtil = new CloudBackupAppDataUtil(this.current, this.location, initApkPackageInfo(), false, false);
            } catch (PackageManager.NameNotFoundException unused) {
                throw new C9721b(1998, "package name not found, appId =" + this.current);
            }
        } else {
            cloudBackupAppDataUtil = null;
        }
        if (!this.virtualList.contains(this.current)) {
            return cloudBackupAppDataUtil;
        }
        this.currentAppName = CloudBackupLanguageUtil.getVirtualName(this.current);
        CloudBackupAppDataUtil cloudBackupAppDataUtil2 = new CloudBackupAppDataUtil(this.current, this.location, 0L, false, false);
        snapshotBackupMeta.setExtend(SnapshotBackupMeta.KEY_STRING_APP_NAME + "=" + this.currentAppName + "&" + SnapshotBackupMeta.KEY_STRING_APP_EXTEND + "=1");
        return cloudBackupAppDataUtil2;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void checkAppDataSize(boolean r5, boolean r6, boolean r7, com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.bean.SnapshotBackupMeta r8, com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.bean.SnapshotBackupMeta r9) throws fk.C9721b {
        /*
            r4 = this;
            boolean r0 = r4.isNeedUpload(r9)
            if (r0 != 0) goto L7
            return
        L7:
            java.util.List<java.lang.String> r0 = r4.sysAppId
            java.lang.String r1 = r4.current
            boolean r0 = r0.contains(r1)
            r1 = 1
            if (r0 == 0) goto L1b
            long r6 = r8.getSize()
            long r8 = r8.getSize()
            goto L5b
        L1b:
            r2 = 0
            if (r6 == 0) goto L4d
            boolean r6 = r9.isOmConfigAble()
            if (r6 == 0) goto L59
            boolean r6 = r9.getAppSwitch()
            if (r6 == 0) goto L59
            boolean r6 = r4.isSupportPMS()
            if (r6 == 0) goto L59
            boolean r6 = r4.isPmsSupportGetBriefCmd
            r1 = r1 ^ r6
            long r6 = r4.getAppDataNeedSize()
            android.content.Context r8 = com.huawei.android.hicloud.cloudbackup.process.CacheTask.getContext()
            java.lang.String r9 = r4.current
            long r8 = p762x4.C13694a.m82323a(r8, r9)
            long r6 = r6 + r8
            int r8 = ck.C1444b.m8308n()
            long r8 = com.huawei.android.hicloud.cloudbackup.util.ICBUtil.getLocalTarNeedSize(r8)
            long r8 = r8 + r6
            goto L5b
        L4d:
            if (r7 == 0) goto L59
            int r6 = ck.C1444b.m8308n()
            long r8 = com.huawei.android.hicloud.cloudbackup.util.ICBUtil.getLocalTarNeedSize(r6)
            r6 = r2
            goto L5b
        L59:
            r6 = r2
            r8 = r6
        L5b:
            if (r5 != 0) goto L60
            long r5 = r8 - r6
            goto L61
        L60:
            r5 = r8
        L61:
            java.util.LinkedHashMap<java.lang.String, java.lang.String> r7 = r4.onModuleReport
            java.lang.String r0 = "moduleLocalSpace"
            java.lang.String r8 = java.lang.String.valueOf(r8)
            r7.put(r0, r8)
            r4.checkLocalSapceIsEnough(r5, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.cloudbackup.process.CloudBackupTask.checkAppDataSize(boolean, boolean, boolean, com.huawei.android.hicloud.cloudbackup.snapshottree.db.bean.SnapshotBackupMeta, com.huawei.android.hicloud.cloudbackup.snapshottree.db.bean.SnapshotBackupMeta):void");
    }

    private void checkInBackupRecordValid() throws Throwable {
        CBSBackupRecord cBSBackupRecord = this.inBackupV2Record;
        if (cBSBackupRecord == null) {
            C11839m.m70688i(TAG, "there is no in backuping record");
            return;
        }
        String backupId = cBSBackupRecord.getBackupId();
        C13030i c13030i = new C13030i();
        C13029h c13029hM78495f = c13030i.m78495f(2);
        if (c13029hM78495f == null) {
            c13029hM78495f = c13030i.m78495f(1);
        }
        if (c13029hM78495f == null || "empty_default_id".equals(c13029hM78495f.m78465h())) {
            if (TextUtils.isEmpty(this.inBackupV2Record.getSnapshot())) {
                C11839m.m70688i(TAG, "record do not upload snapshot, delete record from CBS");
                this.service.m68015V(backupId, this.deviceId, this.deviceType, this.backupType, 7, this.serverPath + this.snapshotTreeService.getDBName(backupId));
                this.service.m68032p(this.deviceId, this.deviceType, backupId);
                reportDeleteSingleRecord(backupId, true);
                return;
            }
            C11839m.m70688i(TAG, "tags is null, inBackuping record invalid, delete inBackuping record: " + backupId);
        } else {
            if (!this.needDownloadInBackupingSnapshot) {
                return;
            }
            C11839m.m70688i(TAG, "need download inBackuping snapshot, delete inBackuping record: " + backupId);
        }
        C11839m.m70688i(TAG, "delete inBackuping record");
        this.service.m68015V(backupId, this.deviceId, this.deviceType, this.backupType, 7, this.serverPath + this.snapshotTreeService.getDBName(backupId));
        boolean zM81075b = C13466f.m81073d().m81075b("isStartDeleteTask", false);
        if (!C12515a.m75110o().m75158X0(DeleteRecordsTask.class.getName())) {
            C13466f.m81073d().m81081i("isStartDeleteTask", true);
            executeDeleteRecordsTask(this.backupType, this.progressCallback, false);
        }
        waitForDeleteRecordTaskEnd();
        this.inBackupingRecrdIds.clear();
        if (zM81075b) {
            C11839m.m70688i(TAG, "reset delete oldest record flag");
            C13466f.m81073d().m81081i("isStartDeleteTask", true);
        }
    }

    private void checkLocalSapceIsEnough(long j10, boolean z10) throws C9721b {
        Long localLeftSpace = ICBUtil.getLocalLeftSpace();
        if (localLeftSpace == null) {
            C11839m.m70689w(TAG, "checkAppDataSize getLocalLeftSpace is null.");
            return;
        }
        long jM75856h0 = C12590s0.m75856h0();
        long j11 = j10 + jM75856h0;
        C11839m.m70689w(TAG, "checkLocalSapceIsEnough appId: " + this.current + ",needSize :" + j11 + " ,reservedSize: " + jM75856h0 + " ,localLeftSpace: " + localLeftSpace);
        if (j11 <= 0) {
            return;
        }
        long jLongValue = j11 - localLeftSpace.longValue();
        if (jLongValue <= 0 || !z10) {
            return;
        }
        C12590s0.m75777N2(jLongValue);
        throw new C9721b(1007, "checkAppDataSize current: " + this.current + " needMoreLocalSize:" + jLongValue);
    }

    private void checkSnapshotMidStatus(String str) throws C9721b, SQLException {
        if (!TextUtils.isEmpty(str)) {
            SnapshotTreeManagementService.getInstance().updateUploadMidStatusByAppId(str, this.backupId);
            SnapshotTreeManagementService.getInstance().deleteNotExistFileByAppId(str, this.backupId);
            return;
        }
        C11839m.m70688i(TAG, "checkDBdeleteFile need delete not exist " + this.current);
        SnapshotTreeManagementService.getInstance().clearNotExistFileFlag(this.backupId);
        SnapshotTreeManagementService.getInstance().updateUploadMidStatus(this.backupId);
    }

    private void clearBackupIncompleteTip() {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(CacheTask.getContext(), NotifyConstants.InterfaceC4909SP.USERINFO_SPFILE, 0);
        if (sharedPreferencesM1382b == null) {
            C11839m.m70689w(TAG, "clearBackupIncompleteTip sp is empty");
        } else {
            sharedPreferencesM1382b.edit().remove(NotifyConstants.BackupNotificationType.SP_BACKUP_NOT_COMPLETE_NOTIFY_FLAG).commit();
        }
    }

    private void clearSuccessData() throws SQLException {
        C11839m.m70688i(TAG, "clearSuccessData");
        C13136a c13136a = new C13136a();
        C13140e c13140e = new C13140e();
        C13141f c13141f = new C13141f();
        new C12815f().clear();
        try {
            EnumC12999a enumC12999a = EnumC12999a.CLOUD_BACKUP;
            c13136a.m79012g(enumC12999a.m78143b());
            c13140e.m79034g(enumC12999a.m78143b());
            c13141f.m79040g(enumC12999a.m78143b());
            C11839m.m70688i(TAG, "clearSuccessData Success");
        } catch (C9721b e10) {
            C11839m.m70687e(TAG, "clearSuccessData failed, reason: " + e10.toString());
        }
        deleteBackupCaheFiles();
    }

    private void compareGallery(long j10) {
        try {
            if (!TextUtils.isEmpty(this.lastSuccessBackupId)) {
                QueryBackupMeta queryBackupMeta = new QueryBackupMeta(HNConstants.DataType.MEDIA, this.lastSuccessBackupId);
                while (queryBackupMeta.hasNext()) {
                    for (SnapshotBackupMeta snapshotBackupMeta : queryBackupMeta.getNext()) {
                        File fileM63442h = C10278a.m63442h(ICBUtil.convertToAbsolutePath(snapshotBackupMeta.getRoot() + snapshotBackupMeta.getData(), this.location));
                        if (fileM63442h.exists()) {
                            this.repeatSize += fileM63442h.length();
                            this.repeatCount++;
                        }
                    }
                }
            }
        } catch (C9721b e10) {
            C11839m.m70687e(TAG, "get gallery meta error. " + e10.getMessage());
        }
        long j11 = this.repeatCount;
        if (j10 > j11) {
            this.repeatCount = j10 - j11;
        }
        C11839m.m70688i(TAG, "repeatCount = " + this.repeatCount);
    }

    private void compareMusic() {
        try {
            if (TextUtils.isEmpty(this.lastSuccessBackupId)) {
                return;
            }
            QueryBackupMeta queryBackupMeta = new QueryBackupMeta("music", this.lastSuccessBackupId);
            while (queryBackupMeta.hasNext()) {
                for (SnapshotBackupMeta snapshotBackupMeta : queryBackupMeta.getNext()) {
                    File fileM63442h = C10278a.m63442h(ICBUtil.convertToAbsolutePath(snapshotBackupMeta.getRoot() + snapshotBackupMeta.getData(), this.location));
                    if (fileM63442h.exists()) {
                        this.repeatSize += fileM63442h.length();
                    }
                }
            }
        } catch (C9721b e10) {
            C11839m.m70687e(TAG, "get music meta error. " + e10.getMessage());
        }
    }

    private void convertCBSBackupRecordToSnapshotMeta(List<CBSBackupRecord> list) throws InterruptedException, C9721b, SQLException {
        if (list.size() <= 0) {
            return;
        }
        C11839m.m70688i(TAG, "convertCBSBackupRecordToSnapshotMeta begin");
        for (CBSBackupRecord cBSBackupRecord : list) {
            isCancel();
            String backupId = cBSBackupRecord.getBackupId();
            if (this.snapshotTreeService.checkSuccessfulBackupRecordStatus(backupId)) {
                C11839m.m70688i(TAG, "old backupRecord Id = " + backupId + ", snapshot database already exist.");
            } else {
                isCancel();
                C11839m.m70688i(TAG, "convert old backup record Id = " + backupId);
                CBSBackupRecord cBSBackupRecordQueryBackupRecordDetail = queryBackupRecordDetail(this.deviceId, this.deviceType, cBSBackupRecord);
                if (cBSBackupRecordQueryBackupRecordDetail != null) {
                    reportQuerySingleRecord(backupId);
                    isCancel();
                    this.snapshotTreeService.createSnapshotBackupMetaTable(backupId);
                    this.snapshotTreeService.saveTree(SnapshotBackupMeta.DB_ROOT_NODE_APPID, this.snapshotTreeService.createDBRootNode(backupId), backupId);
                    List<CBSAppInfo> appIdInfos = cBSBackupRecordQueryBackupRecordDetail.getAppIdInfos();
                    if (appIdInfos != null) {
                        HashMap map = new HashMap();
                        ArrayList arrayList = new ArrayList();
                        for (CBSAppInfo cBSAppInfo : appIdInfos) {
                            isCancel();
                            String appId = cBSAppInfo.getAppId();
                            SnapshotBackupMeta snapshotBackupMeta = new SnapshotBackupMeta();
                            snapshotBackupMeta.setData(appId);
                            snapshotBackupMeta.setRoot("");
                            snapshotBackupMeta.setName(appId);
                            snapshotBackupMeta.setSize(cBSAppInfo.getSize());
                            map.put(appId, snapshotBackupMeta);
                            for (CBSFileInfo cBSFileInfo : cBSAppInfo.getFileInfos()) {
                                isCancel();
                                arrayList.add(this.serverPath + appId + File.separator + cBSFileInfo.getFileName());
                            }
                        }
                        Map<String, SnapshotBackupMeta> leafNodeBackupMetas = getLeafNodeBackupMetas(arrayList);
                        for (CBSAppInfo cBSAppInfo2 : appIdInfos) {
                            isCancel();
                            String appId2 = cBSAppInfo2.getAppId();
                            SnapshotNode snapshotNodeCreateTreeRootNode = this.snapshotTreeService.createTreeRootNode(appId2, (SnapshotBackupMeta) map.get(appId2), 0L, this.snapshotTreeService.getRootNode(SnapshotBackupMeta.DB_ROOT_NODE_APPID, backupId).getRight());
                            ArrayList arrayList2 = new ArrayList();
                            for (CBSFileInfo cBSFileInfo2 : cBSAppInfo2.getFileInfos()) {
                                isCancel();
                                arrayList2.add(leafNodeBackupMetas.get(appId2 + File.separator + cBSFileInfo2.getFileName()));
                            }
                            arrayList2.addAll(SnapshotTreeUtil.getAppinfoMetas(cBSAppInfo2));
                            long jBuildSnapshotTree = this.snapshotTreeService.buildSnapshotTree(appId2, snapshotNodeCreateTreeRootNode, arrayList2);
                            this.snapshotTreeService.saveTree(appId2, snapshotNodeCreateTreeRootNode, backupId);
                            this.snapshotTreeService.endTree(appId2, backupId);
                            C11839m.m70686d(TAG, "convertCBSBackupRecordToSnapshotMeta appid = " + appId2 + ", file size = " + jBuildSnapshotTree);
                        }
                        this.snapshotTreeService.updateBackupRecordMetaSuccessful(backupId);
                    } else {
                        if (cBSBackupRecord.getStatus() != 1) {
                            throw new C9721b(3107, "convert CBSBackupRecords appInfos is null.", "convertOldCBSBackupRecords");
                        }
                        C11839m.m70689w(TAG, "convert CBSBackupRecords appInfos is null");
                    }
                } else {
                    if (cBSBackupRecord.getStatus() != 1) {
                        throw new C9721b(3107, "convert CBSBackupRecords query backupRecordDetailReq return null.", "convertOldCBSBackupRecords");
                    }
                    C11839m.m70689w(TAG, "convert CBSBackupRecords query backupRecordDetailReq return null");
                }
            }
        }
        C11839m.m70688i(TAG, "convertCBSBackupRecordToSnapshotMeta end");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void countDown(int i10, CountDownLatch countDownLatch) {
        for (int i11 = 0; i11 < i10; i11++) {
            countDownLatch.countDown();
        }
    }

    private C13029h createTags(int i10) throws C9721b {
        if (TextUtils.isEmpty(this.backupId)) {
            deleteBackupCaheFiles();
            this.backupId = this.service.m68028l(this.deviceId, this.deviceType, this.recordExtend);
            C11839m.m70688i(TAG, "create new backupId = " + this.backupId);
        }
        C13029h c13029h = new C13029h(i10, C11058a.m66627b("02010"));
        c13029h.m78460Z(C13452e.m80781L().m80986x());
        c13029h.m78467i0(C13452e.m80781L().m80978v());
        long jCurrentTimeMillis = System.currentTimeMillis();
        c13029h.m78475q0(jCurrentTimeMillis);
        c13029h.m78447M(604800000 + jCurrentTimeMillis);
        c13029h.m78450P(jCurrentTimeMillis);
        c13029h.m78483u0(this.traceID);
        c13029h.m78453S(1);
        c13029h.m78448N(this.backupId);
        C11839m.m70688i(TAG, "current backupId = " + this.backupId);
        String str = this.autoBackup ? "AutoBBT" : "ManuBBT";
        C11060c c11060cM66626a = C11058a.m66626a(c13029h.m78436B(), str, C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("0");
        c11060cM66626a.m66635A("isSuccess");
        HashMap map = new HashMap();
        map.put("business_id", str);
        map.put("backupBeginTime", String.valueOf(c13029h.m78440F()));
        map.put("backupTransID", c13029h.m78444J());
        map.put("userType", C13452e.m80781L().m80987x0());
        map.put("gradeCode", C12590s0.m75747G0());
        C13622a.m81969o(CacheTask.getContext(), c11060cM66626a, map);
        reportRecordExpired();
        return c13029h;
    }

    private void dataPrepareEnd() throws InterruptedException, C9721b {
        setAppDataPreparing(false);
        isCancel();
        CBLockAndFlowControlManager cBLockAndFlowControlManager = this.timer;
        if (cBLockAndFlowControlManager == null) {
            C11839m.m70688i(TAG, "dataPrepareEnd timer is null");
        } else if (cBLockAndFlowControlManager.isNoNetWorkKeeplock()) {
            C11839m.m70688i(TAG, "dataPrepareEnd try keeplock");
            keepLock();
        }
    }

    private void defaultPmsMetaStatus(String str) {
        if (CloudBackupOneModuleTask.isPmsBriefProcess(str, this.dataLocation)) {
            String strM81914C = C13617a.m81914C(this.current, 0);
            PmsMetaStatusOperator pmsMetaStatusOperator = new PmsMetaStatusOperator(strM81914C);
            PmsFullBriefFilesInfoOperator pmsFullBriefFilesInfoOperator = new PmsFullBriefFilesInfoOperator(strM81914C);
            try {
                pmsMetaStatusOperator.updateStatus(0);
                pmsFullBriefFilesInfoOperator.clear();
                C11839m.m70686d(TAG, "defaultPmsMetaStatus: " + str);
            } catch (C9721b e10) {
                C11839m.m70687e(TAG, "defaultPmsMetaStatus: " + e10.toString());
            }
        }
    }

    private void defaultRootNodesStatus(List<SnapshotBackupMeta> list) throws SQLException {
        Iterator<SnapshotBackupMeta> it = list.iterator();
        while (it.hasNext()) {
            this.snapshotTreeService.defaultRootNodeStatus(it.next().getAppId(), this.backupId);
        }
    }

    private void deleteBackupCaheFiles() {
        BackupCacheRecord.clear(CacheTask.getContext());
        C11839m.m70686d(TAG, "delete path = " + this.location);
        C12571m.m75547i(this.location);
        C12571m.m75547i(C12586r.m75713d());
    }

    private void deleteModuleCache(String str) {
        String str2 = this.location + File.separator + str;
        String dataTempDir = getDataTempDir(str);
        String dataCacheTempDir = getDataCacheTempDir(str);
        String strM81914C = C13617a.m81914C(str, 0);
        if (C10278a.m63442h(strM81914C).exists()) {
            C13216j.m79422g(strM81914C);
        }
        C12571m.m75547i(str2);
        C12571m.m75547i(dataTempDir);
        C12571m.m75547i(dataCacheTempDir);
        BackupCacheRecord.delete(CacheTask.getContext(), str);
        C12571m.m75547i(C12586r.m75714e(this.current, 0));
    }

    private void deleteModuleCacheExcludeData(String str) {
        C12571m.m75547i(this.location + File.separator + str);
        BackupCacheRecord.delete(CacheTask.getContext(), str);
    }

    private void deleteOneModuleCache(boolean z10) {
        SnapshotBackupMeta rootNode;
        C12571m.m75547i(getTarTemp(this.current));
        if (z10) {
            deleteModuleCache(this.current);
            return;
        }
        try {
            rootNode = this.snapshotTreeService.getRootNode(this.current, this.backupId);
        } catch (C9721b e10) {
            C11839m.m70688i(TAG, "deleteOneModuleCache no rootnode appId:" + this.current + " ,e: " + e10.toString());
            rootNode = null;
        }
        if (rootNode == null) {
            C11839m.m70688i(TAG, "rootNode  null deleteModuleCache: " + this.current);
            deleteModuleCache(this.current);
            return;
        }
        if (isNeedPrepareData(rootNode)) {
            boolean zContains = this.thirdAppId.contains(this.current);
            boolean zIsPmsSupportIncrement = isPmsSupportIncrement();
            C11839m.m70688i(TAG, "deleteOneModuleTemp deleteModuleCache: " + this.current + "isPmsSupportIncrement :" + zIsPmsSupportIncrement);
            if (zContains && zIsPmsSupportIncrement) {
                deleteModuleCacheExcludeData(this.current);
            } else {
                deleteModuleCache(this.current);
            }
        }
    }

    private void deleteTheFile(File file) {
        if (!file.exists() || file.delete()) {
            return;
        }
        C11839m.m70686d(TAG, "delete deleteTheFile failed: " + C10279b.m63452a(file));
    }

    private void doFailReport(C11060c c11060c) {
        if (this.manualAbort) {
            c11060c.m66665u("001_1001");
            c11060c.m66635A("user canceled.");
            return;
        }
        if (!condition()) {
            c11060c.m66665u("001_1002");
            c11060c.m66635A("net disabled.");
            return;
        }
        C9721b c9721b = this.exception;
        if (c9721b != null) {
            c11060c.m66664t(c9721b.m60658b());
            c11060c.m66665u("001_" + this.exception.m60659c());
            c11060c.m66635A(this.exception.getMessage());
            return;
        }
        if (!isAbort()) {
            c11060c.m66665u("001_1008");
            c11060c.m66635A("unknow error.");
            return;
        }
        c11060c.m66665u("001_" + getErrCode());
        c11060c.m66635A("abort by backup condition. current model:" + this.current);
    }

    private void doForegroundModules() {
        if (!this.queue.isEmpty() || this.foregroundAppModuleMap.isEmpty()) {
            return;
        }
        Iterator<Map.Entry<String, SnapshotBackupMeta>> it = this.foregroundAppModuleMap.entrySet().iterator();
        while (it.hasNext()) {
            SnapshotBackupMeta value = it.next().getValue();
            if (value != null) {
                C11839m.m70688i(TAG, "process foreground app again, appid  = " + value.getAppId() + ", add result = " + this.queue.offer(value));
            }
        }
    }

    private void doOneModuleBackup(SnapshotBackupMeta snapshotBackupMeta) throws Throwable {
        boolean z10;
        boolean z11;
        this.current = snapshotBackupMeta.getData();
        C11965e.m71974f().m71986o(this.current, 0);
        boolean zContains = this.virtualList.contains(this.current);
        boolean zContains2 = this.thirdAppId.contains(this.current);
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.onModuleReport = new LinkedHashMap<>();
        SnapshotBackupMeta rootMeta = getRootMeta(snapshotBackupMeta);
        C12571m.m75547i(getTarTemp(this.current));
        CloudBackupAppDataUtil cloudBackupAppDataUtilBuildDataUtil = null;
        if (zContains2 || zContains) {
            try {
                setAppDataPreparing(true);
            } catch (C9721b e10) {
                e = e10;
                z10 = false;
                try {
                    C11839m.m70689w(TAG, "onOperate error, appId = " + this.current + " errCode = " + e.m60659c() + e.toString());
                    handleModuleBackupException(e);
                    C11965e.m71974f().m71985n(this.current, 0);
                    this.index++;
                    setAppDataPreparing(false);
                    reportOneModuleBackup(snapshotBackupMeta, this.onModuleReport, jCurrentTimeMillis, this.currentBackupStatus.m29861N());
                    deleteOneModuleCache(false);
                    restart3rdPerOM(z10, this.current, cloudBackupAppDataUtilBuildDataUtil, this.currentBackupStatus.m29861N());
                    return;
                } catch (Throwable th2) {
                    th = th2;
                    C11965e.m71974f().m71985n(this.current, 0);
                    this.index++;
                    setAppDataPreparing(false);
                    reportOneModuleBackup(snapshotBackupMeta, this.onModuleReport, jCurrentTimeMillis, this.currentBackupStatus.m29861N());
                    deleteOneModuleCache(false);
                    restart3rdPerOM(z10, this.current, cloudBackupAppDataUtilBuildDataUtil, this.currentBackupStatus.m29861N());
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                z10 = false;
                C11965e.m71974f().m71985n(this.current, 0);
                this.index++;
                setAppDataPreparing(false);
                reportOneModuleBackup(snapshotBackupMeta, this.onModuleReport, jCurrentTimeMillis, this.currentBackupStatus.m29861N());
                deleteOneModuleCache(false);
                restart3rdPerOM(z10, this.current, cloudBackupAppDataUtilBuildDataUtil, this.currentBackupStatus.m29861N());
                throw th;
            }
        }
        boolean zIsNeedPrepareData = isNeedPrepareData(rootMeta);
        checkAppDataSize(zIsNeedPrepareData, zContains2, zContains, snapshotBackupMeta, rootMeta);
        cloudBackupAppDataUtilBuildDataUtil = buildDataUtil(rootMeta);
        C12815f c12815f = new C12815f();
        this.currentBackupStatus = c12815f.m76928g(this.current);
        if (zIsNeedPrepareData) {
            if (zContains2) {
                try {
                    if (isSkipForegroundAppModule(this.current, snapshotBackupMeta, cloudBackupAppDataUtilBuildDataUtil)) {
                        this.index--;
                        C11965e.m71974f().m71985n(this.current, 0);
                        this.index++;
                        setAppDataPreparing(false);
                        reportOneModuleBackup(snapshotBackupMeta, this.onModuleReport, jCurrentTimeMillis, this.currentBackupStatus.m29861N());
                        deleteOneModuleCache(false);
                        restart3rdPerOM(false, this.current, cloudBackupAppDataUtilBuildDataUtil, this.currentBackupStatus.m29861N());
                        return;
                    }
                    z11 = true;
                } catch (C9721b e11) {
                    e = e11;
                    z10 = false;
                    C11839m.m70689w(TAG, "onOperate error, appId = " + this.current + " errCode = " + e.m60659c() + e.toString());
                    handleModuleBackupException(e);
                    C11965e.m71974f().m71985n(this.current, 0);
                    this.index++;
                    setAppDataPreparing(false);
                    reportOneModuleBackup(snapshotBackupMeta, this.onModuleReport, jCurrentTimeMillis, this.currentBackupStatus.m29861N());
                    deleteOneModuleCache(false);
                    restart3rdPerOM(z10, this.current, cloudBackupAppDataUtilBuildDataUtil, this.currentBackupStatus.m29861N());
                    return;
                } catch (Throwable th4) {
                    th = th4;
                    z10 = false;
                    C11965e.m71974f().m71985n(this.current, 0);
                    this.index++;
                    setAppDataPreparing(false);
                    reportOneModuleBackup(snapshotBackupMeta, this.onModuleReport, jCurrentTimeMillis, this.currentBackupStatus.m29861N());
                    deleteOneModuleCache(false);
                    restart3rdPerOM(z10, this.current, cloudBackupAppDataUtilBuildDataUtil, this.currentBackupStatus.m29861N());
                    throw th;
                }
            } else {
                z11 = false;
            }
            try {
                this.currentBackupStatus.mo29338z0(0).mo29289A0(1);
                c12815f.m76934m(this.currentBackupStatus);
                C11963c.m71970y(this.currentBackupStatus, "auto");
                doOneModulePrepare(this.currentBackupStatus, rootMeta, buildBackupOneModuleTask(zContains, this.currentBackupStatus, rootMeta, cloudBackupAppDataUtilBuildDataUtil));
                updateStatus(this.currentBackupStatus, 1, 2);
                restart3rdPerOM(z11, this.current, cloudBackupAppDataUtilBuildDataUtil, this.currentBackupStatus.m29861N());
                isCancel();
                this.foregroundAppModuleMap.remove(this.current);
            } catch (C9721b e12) {
                e = e12;
                z10 = z11;
                C11839m.m70689w(TAG, "onOperate error, appId = " + this.current + " errCode = " + e.m60659c() + e.toString());
                handleModuleBackupException(e);
                C11965e.m71974f().m71985n(this.current, 0);
                this.index++;
                setAppDataPreparing(false);
                reportOneModuleBackup(snapshotBackupMeta, this.onModuleReport, jCurrentTimeMillis, this.currentBackupStatus.m29861N());
                deleteOneModuleCache(false);
                restart3rdPerOM(z10, this.current, cloudBackupAppDataUtilBuildDataUtil, this.currentBackupStatus.m29861N());
                return;
            } catch (Throwable th5) {
                th = th5;
                z10 = z11;
                C11965e.m71974f().m71985n(this.current, 0);
                this.index++;
                setAppDataPreparing(false);
                reportOneModuleBackup(snapshotBackupMeta, this.onModuleReport, jCurrentTimeMillis, this.currentBackupStatus.m29861N());
                deleteOneModuleCache(false);
                restart3rdPerOM(z10, this.current, cloudBackupAppDataUtilBuildDataUtil, this.currentBackupStatus.m29861N());
                throw th;
            }
        }
        if (isNeedScanData(rootMeta)) {
            this.snapshotTreeService.setCurrentRootSnapshotMeta(rootMeta);
        }
        if (isNeedScanSdCard(rootMeta)) {
            CloudBackupOneModuleTask cloudBackupOneModuleTaskBuildBackupOneModuleTask = buildBackupOneModuleTask(zContains, this.currentBackupStatus, rootMeta, cloudBackupAppDataUtilBuildDataUtil);
            this.snapshotTreeService.setCurrentRootSnapshotMeta(rootMeta);
            doOneModuleMetadataBuild(rootMeta, cloudBackupOneModuleTaskBuildBackupOneModuleTask);
            this.currentBackupStatus.mo29327g0((int) rootMeta.getCount()).mo29308V(0L).mo29323e0(rootMeta.getSize());
            updateStatus(this.currentBackupStatus, 3, 4);
        }
        this.fileSize = this.snapshotTreeService.getOneModuleFileSize(this.current, this.backupId);
        if (isNeedUpload(rootMeta)) {
            doOneModuleMetadataUpdate(rootMeta);
            dataPrepareEnd();
            doOneModuleUpload(this.currentBackupStatus);
            C9721b c9721b = this.exception;
            if (c9721b != null) {
                throw c9721b;
            }
            updateSnapshot(rootMeta);
            this.currentBackupStatus.mo29327g0((int) rootMeta.getCount()).mo29323e0(rootMeta.getSize()).m29436s2(System.currentTimeMillis());
            updateStatus(this.currentBackupStatus, 5, 6);
        }
        C11965e.m71974f().m71985n(this.current, 0);
        this.index++;
        setAppDataPreparing(false);
        reportOneModuleBackup(snapshotBackupMeta, this.onModuleReport, jCurrentTimeMillis, this.currentBackupStatus.m29861N());
        deleteOneModuleCache(true);
        restart3rdPerOM(false, this.current, cloudBackupAppDataUtilBuildDataUtil, this.currentBackupStatus.m29861N());
    }

    private void doOneModuleMetadataBuild(SnapshotBackupMeta snapshotBackupMeta, CloudBackupOneModuleTask cloudBackupOneModuleTask) throws Throwable {
        C11839m.m70688i(TAG, "doOneModuleMetadataBuild, scan data begin, appId = " + this.current);
        long jCurrentTimeMillis = System.currentTimeMillis();
        isCancel();
        this.snapshotTreeService.deleteSdcardFromSnapshot(this.current, this.backupId);
        cloudBackupOneModuleTask.buildModuleSnapshotTree(snapshotBackupMeta, this.mMusicBackup);
        this.onModuleReport.put("scan", String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
        C11839m.m70688i(TAG, "doOneModuleMetadataBuild, scan data end, appId = " + this.current);
    }

    private void doOneModuleMetadataUpdate(SnapshotBackupMeta snapshotBackupMeta) throws InterruptedException, C9721b {
        C11839m.m70688i(TAG, "doOneModuleMetadataUpdate, update data begin, appId = " + this.current);
        long jCurrentTimeMillis = System.currentTimeMillis();
        updateSnapshotMetaCache(this.isFullBackup);
        if (snapshotBackupMeta.is3rd() && snapshotBackupMeta.isOmConfigAble() && snapshotBackupMeta.getAppSwitch()) {
            new C12606x1(this).m76060d(this.backupId, this.current, 0, this.location);
            updateSnapshotMetaCache(this.isFullBackup);
        }
        SnapshotBackupMetaOperator snapshotBackupMetaOperator = new SnapshotBackupMetaOperator(this.backupId);
        long jQueryMkfileBackupSize = snapshotBackupMetaOperator.queryMkfileBackupSize(this.current);
        long jQueryNeedUploadSize = snapshotBackupMetaOperator.queryNeedUploadSize(this.current);
        this.mkfileBackupSize += jQueryMkfileBackupSize;
        this.needUploadedSize += jQueryNeedUploadSize;
        this.onModuleReport.put(SyncProtocol.Constant.UPDATE, String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
        C11839m.m70688i(TAG, "doOneModuleMetadataUpdate, update data end, appId = " + this.current + " ,mkfSize: " + jQueryMkfileBackupSize + " ,nuSize: " + jQueryNeedUploadSize);
    }

    private void doOneModulePrepare(CloudBackupStatus cloudBackupStatus, SnapshotBackupMeta snapshotBackupMeta, CloudBackupOneModuleTask cloudBackupOneModuleTask) throws InterruptedException, C9721b {
        C11839m.m70688i(TAG, "doOneModulePrepare, prepare data begin, appId = " + this.current);
        BackupOptionItem backupOptionItem = (BackupOptionItem) C13465e.m81052f().m81059h(this.current, BackupOptionItem.class);
        if (backupOptionItem != null) {
            this.onModuleReport.put("estimateSize", String.valueOf(backupOptionItem.getDataBytes()));
        }
        C12571m.m75547i(C12586r.m75714e(this.current, 0));
        isCancel();
        sendProgress(0, 0, 0L);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!HNConstants.DataType.MEDIA.equals(this.current) && !"music".equals(this.current) && !this.virtualList.contains(this.current)) {
            isCancel();
            cloudBackupOneModuleTask.backupDataByClone(this.backupCaches.get(this.current));
            isCancel();
            this.isPmsSupportGetBriefCmd = cloudBackupOneModuleTask.backup3rdAppDataByPms(this.isPmsSupportGetBriefCmd, cloudBackupOneModuleTask.getCloudBackupAppDataUtil());
            snapshotBackupMeta.setStatus(1);
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            snapshotBackupMeta.setDateInvalid(jCurrentTimeMillis2);
            this.snapshotTreeService.updateRootNode(this.backupId, snapshotBackupMeta);
            if (!this.sysAppId.contains(this.current)) {
                BackupCacheRecord.setLastCacheTime(CacheTask.getContext(), this.current, jCurrentTimeMillis2);
            }
        }
        this.onModuleReport.put(ParamConstants.CallbackMethod.ON_PREPARE, String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
        C11839m.m70688i(TAG, "doOneModulePrepare, prepare data end, appId = " + this.current);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void doOneModuleUpload(com.huawei.hicloud.cloudbackup.store.database.status.CloudBackupStatus r24) throws fk.C9721b, android.database.SQLException {
        /*
            Method dump skipped, instructions count: 476
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.cloudbackup.process.CloudBackupTask.doOneModuleUpload(com.huawei.hicloud.cloudbackup.store.database.status.CloudBackupStatus):void");
    }

    private void doSuccessReport(C11060c c11060c) {
        if (this.tags != null) {
            c11060c.m66635A("backup success, totalTime: " + (System.currentTimeMillis() - this.tags.m78469k()) + " | totalSize: " + this.tags.m78439E());
            c11060c.m66664t("success");
            c11060c.m66665u("0");
            if (this.filterModule.isEmpty()) {
                return;
            }
            StringBuilder sb2 = new StringBuilder(c11060c.m66652h());
            sb2.append("filter modules [");
            for (Map.Entry<String, String> entry : this.filterModule.entrySet()) {
                sb2.append(entry.getKey());
                sb2.append("=");
                sb2.append(entry.getValue());
            }
            sb2.append("]");
            c11060c.m66635A(sb2.toString());
            c11060c.m66665u("00");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x01ba A[Catch: all -> 0x01cd, b -> 0x01d1, TryCatch #6 {b -> 0x01d1, all -> 0x01cd, blocks: (B:47:0x01b4, B:49:0x01ba, B:51:0x01c0, B:56:0x01d5), top: B:75:0x01b4 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x020b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void doUploadFile(com.huawei.android.hicloud.cloudbackup.snapshottree.QueryBackupMeta r43) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 634
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.cloudbackup.process.CloudBackupTask.doUploadFile(com.huawei.android.hicloud.cloudbackup.snapshottree.QueryBackupMeta):void");
    }

    private void downloadLastSuccessRecord(CBSBackupRecord cBSBackupRecord, List<CBSBackupRecord> list) throws Throwable {
        if (!cBSBackupRecord.isSupportSnapshot()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(cBSBackupRecord);
            convertCBSBackupRecordToSnapshotMeta(arrayList);
            return;
        }
        if (this.snapshotTreeService.checkSuccessfulBackupRecordStatus(cBSBackupRecord.getBackupId())) {
            return;
        }
        try {
            downloadSnapshotDb(cBSBackupRecord.getSnapshot(), this.snapshotTreeService.getDBName(cBSBackupRecord.getBackupId()));
        } catch (C9721b e10) {
            C11839m.m70688i(TAG, "download snapshot.db error: " + e10.getMessage());
            if (!ICBUtil.isSnapshotNotExist(e10)) {
                throw e10;
            }
            List<String> list2 = this.clientActionList;
            if (list2 == null || !list2.contains("2")) {
                list.remove(cBSBackupRecord);
                this.lastSuccessBackupId = "";
            } else {
                C11839m.m70688i(TAG, "clientActions contains delete record action");
                this.service.m68015V(cBSBackupRecord.getBackupId(), cBSBackupRecord.getDevice().getDeviceId(), cBSBackupRecord.getDevice().getDeviceType(), this.backupType, 7, cBSBackupRecord.getSnapshot());
                list.remove(cBSBackupRecord);
                this.lastSuccessBackupId = "";
            }
        }
    }

    private void exeBackUpSuccessNotify() {
        C12515a.m75110o().m75172d(new CloudBackupSuccessNotifyTask(this.autoBackup, this.totalBackupSize));
    }

    private boolean filteNoTarFile(File file, long j10) {
        return !(this.thirdAppId.contains(this.current) || this.virtualList.contains(this.current)) || file.length() > j10 || file.getName().endsWith(".dbsplite") || file.getName().endsWith(".differencepacket") || file.getName().endsWith(".dbhashfile") || ICBUtil.isApkFile(C10279b.m63452a(file), this.location, this.current) || ICBUtil.isIconFile(C10279b.m63452a(file), this.location, this.current) || ICBUtil.isInfoFile(C10279b.m63452a(file), this.location, this.current);
    }

    private BackupOptionItem generateModuleItem(String str, String str2, boolean z10) throws C9721b {
        BackupOptionItem backupOptionItem = new BackupOptionItem(str, str2);
        backupOptionItem.setBackupSwitch(z10);
        if ("thirdAppData".equals(str2)) {
            backupOptionItem.setBackupData(true);
        }
        this.itemOperator.m78370E(backupOptionItem);
        return backupOptionItem;
    }

    private List<CBSBackupRecord> getAllRecordsFromServer() throws C9721b {
        ArrayList arrayList = new ArrayList();
        for (CBSBackupRecord cBSBackupRecord : this.service.m67998E(false, false, false)) {
            String deviceId = cBSBackupRecord.getDevice().getDeviceId();
            if (deviceId != null && !deviceId.isEmpty() && this.deviceId.equals(deviceId)) {
                arrayList.add(cBSBackupRecord);
            }
        }
        return arrayList;
    }

    private long getAppDataNeedSize() {
        if (!this.isPmsSupportGetBriefCmd) {
            return ScanAppDataUtil.get3rdAppDataDirSize(this.current, 0);
        }
        long jQuerySumToCopySize = new PmsFullBriefFilesInfoOperator(C13617a.m81914C(this.current, 0)).querySumToCopySize();
        return jQuerySumToCopySize > 0 ? jQuerySumToCopySize : ScanAppDataUtil.get3rdAppDataDirSize(this.current, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String getAppVersionFromBackupMeta(java.lang.String r11) {
        /*
            r10 = this;
            java.lang.String r0 = "getAppVersionFromBackupMeta error, appId =  "
            java.lang.String r1 = "CloudBackupTask"
            java.lang.String r2 = ""
            com.huawei.android.hicloud.cloudbackup.snapshottree.SnapshotTreeManagementService r3 = r10.snapshotTreeService     // Catch: fk.C9721b -> L3a
            java.lang.String r10 = r10.backupId     // Catch: fk.C9721b -> L3a
            com.huawei.android.hicloud.cloudbackup.snapshottree.db.bean.SnapshotBackupMeta r10 = r3.queryAppApkFile(r11, r10)     // Catch: fk.C9721b -> L3a
            java.lang.String r3 = r10.getExtend()     // Catch: fk.C9721b -> L3a
            java.lang.String r4 = "&"
            java.lang.String[] r10 = r10.splitExtend(r3, r4)     // Catch: fk.C9721b -> L3a
            int r3 = r10.length     // Catch: fk.C9721b -> L3a
            r4 = 0
            r6 = r2
            r5 = r4
        L1c:
            if (r5 >= r3) goto L52
            r7 = r10[r5]     // Catch: fk.C9721b -> L3b
            java.lang.String r8 = "="
            java.lang.String[] r7 = r7.split(r8)     // Catch: fk.C9721b -> L3b
            int r8 = r7.length     // Catch: fk.C9721b -> L3b
            r9 = 2
            if (r8 != r9) goto L37
            java.lang.String r8 = "avername"
            r9 = r7[r4]     // Catch: fk.C9721b -> L3b
            boolean r8 = r8.equalsIgnoreCase(r9)     // Catch: fk.C9721b -> L3b
            if (r8 == 0) goto L37
            r8 = 1
            r6 = r7[r8]     // Catch: fk.C9721b -> L3b
        L37:
            int r5 = r5 + 1
            goto L1c
        L3a:
            r6 = r2
        L3b:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r0)
            r10.append(r11)
            java.lang.String r3 = " metas is empty."
            r10.append(r3)
            java.lang.String r10 = r10.toString()
            p514o9.C11839m.m70688i(r1, r10)
        L52:
            boolean r10 = android.text.TextUtils.isEmpty(r6)
            if (r10 == 0) goto L59
            goto L5a
        L59:
            r2 = r6
        L5a:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r0)
            r10.append(r11)
            java.lang.String r11 = " version = "
            r10.append(r11)
            r10.append(r2)
            java.lang.String r10 = r10.toString()
            p514o9.C11839m.m70688i(r1, r10)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.cloudbackup.process.CloudBackupTask.getAppVersionFromBackupMeta(java.lang.String):java.lang.String");
    }

    private void getAutoStrategyFromServer() {
        try {
            C11839m.m70688i(TAG, "getAutoStrategyFromServer");
            About aboutM84137z = new C13998b0().m84137z("uploadTargetStrategy,bakSourceStrategy", C11058a.m66627b("02101"));
            C12176c.m73270m(aboutM84137z);
            C12176c.m73261c(aboutM84137z);
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "getAutoStrategyFromServer Exception:" + e10.getMessage());
        }
    }

    private Map<String, SnapshotBackupMeta> getLeafNodeBackupMetas(List<String> list) throws InterruptedException, C9721b {
        int i10;
        int i11;
        CloudBackupTask cloudBackupTask = this;
        HashMap map = new HashMap();
        if (list.isEmpty()) {
            return map;
        }
        int size = list.size();
        int i12 = 0;
        int i13 = 0;
        while (i12 < size) {
            isCancel();
            int i14 = i13 * 200;
            int i15 = i14 + 200;
            if (i15 > size) {
                i15 = size;
            }
            List<String> listSubList = list.subList(i14, i15);
            Result resultM78709H = cloudBackupTask.gwService.m78709H((String[]) listSubList.toArray(new String[listSubList.size()]), new String[]{"name", "md5", "size", JsbMapKeyNames.H5_LOC, "encoded"});
            List<Map<String, Object>> successList = resultM78709H.getSuccessList();
            List<Result.ErrMsg> failList = resultM78709H.getFailList();
            if (!failList.isEmpty()) {
                cloudBackupTask.reportVFSGetattrFail(failList);
            }
            for (Map<String, Object> map2 : successList) {
                try {
                    SnapshotBackupMeta snapshotBackupMeta = new SnapshotBackupMeta();
                    String strSubstring = SafeString.substring((String) map2.get("name"), cloudBackupTask.serverPath.length());
                    String str = (String) map2.get(JsbMapKeyNames.H5_LOC);
                    String str2 = (String) map2.get("size");
                    String rootPath = ICBUtil.getRootPath(str);
                    i10 = size;
                    try {
                        String strSubstring2 = SafeString.substring(str, rootPath.length());
                        snapshotBackupMeta.setRoot(rootPath);
                        snapshotBackupMeta.setData(strSubstring2);
                        String str3 = File.separator;
                        int iLastIndexOf = strSubstring2.lastIndexOf(str3);
                        snapshotBackupMeta.setName(SafeString.substring(strSubstring2, iLastIndexOf <= 0 ? 0 : iLastIndexOf + 1));
                        int iIndexOf = strSubstring.indexOf(str3);
                        snapshotBackupMeta.setCloudPath(SafeString.substring(strSubstring, iIndexOf <= 0 ? 0 : iIndexOf + 1));
                        snapshotBackupMeta.setStatus(5);
                        i11 = i15;
                        try {
                            snapshotBackupMeta.setType(6L);
                            snapshotBackupMeta.setSize(C0241z.m1688f(str2));
                            if (CacheTask.isEncrypt()) {
                                int iLastIndexOf2 = strSubstring.lastIndexOf(95);
                                String strReplace = iLastIndexOf2 > 0 ? SafeString.substring(strSubstring, iLastIndexOf2).replace("_", "") : "";
                                snapshotBackupMeta.setHash2(strReplace);
                                snapshotBackupMeta.setCloudHash(strReplace);
                            } else {
                                snapshotBackupMeta.setHash1((String) map2.get("md5"));
                                snapshotBackupMeta.setCloudHash((String) map2.get("md5"));
                            }
                            String str4 = (String) map2.get("encoded");
                            snapshotBackupMeta.setCloudEncoded(TextUtils.isEmpty(str4) ? 0L : C0241z.m1688f(str4));
                            map.put(strSubstring, snapshotBackupMeta);
                        } catch (Exception unused) {
                            C11839m.m70689w(TAG, "getLeafNodeBackupMetas create backup meta error." + map2);
                            i15 = i11;
                            size = i10;
                            cloudBackupTask = this;
                        }
                    } catch (Exception unused2) {
                        i11 = i15;
                        C11839m.m70689w(TAG, "getLeafNodeBackupMetas create backup meta error." + map2);
                        i15 = i11;
                        size = i10;
                        cloudBackupTask = this;
                    }
                } catch (Exception unused3) {
                    i10 = size;
                }
                i15 = i11;
                size = i10;
                cloudBackupTask = this;
            }
            i13++;
            i12 = i15;
            cloudBackupTask = this;
        }
        return map;
    }

    private String getRealPath(SnapshotBackupMeta snapshotBackupMeta, String str) {
        return snapshotBackupMeta.getCloudEncoded() == 1 ? ICBUtil.convertToAbsolutePath(ICBUtil.getDecodedPath(str), this.location) : ICBUtil.convertToAbsolutePath(str, this.location);
    }

    private SnapshotBackupMeta getRootMeta(SnapshotBackupMeta snapshotBackupMeta) throws C9721b {
        SnapshotBackupMeta rootNode;
        try {
            rootNode = this.snapshotTreeService.getRootNode(this.current, this.backupId);
        } catch (C9721b unused) {
            rootNode = null;
        }
        if (rootNode == null) {
            String strM63452a = C10279b.m63452a(C10278a.m63442h(this.location));
            snapshotBackupMeta.setName(this.current);
            snapshotBackupMeta.setType(4L);
            snapshotBackupMeta.setRoot(strM63452a + File.separator);
            this.snapshotTreeService.updateRootNode(this.backupId, snapshotBackupMeta);
            rootNode = snapshotBackupMeta;
        }
        rootNode.setOmConfigAble(snapshotBackupMeta.isOmConfigAble());
        rootNode.setAppSwitch(snapshotBackupMeta.getAppSwitch());
        if (this.sysAppId.contains(this.current)) {
            rootNode.setCount(snapshotBackupMeta.getCount());
        }
        return rootNode;
    }

    private void getSdcardAcptErrValue(String str) {
        CloudBackup cloudBackup;
        this.sdcardAcptErrNum = this.backupConfigOperator.m75333E0();
        this.sdcardAcptErrRate = this.backupConfigOperator.m75335F0();
        List<AppInfoList> listM75300k = new C12519c().m75300k(str);
        if (listM75300k.isEmpty() || (cloudBackup = listM75300k.get(0).getCloudBackup()) == null) {
            return;
        }
        int sdcardAcptErrNum = cloudBackup.getSdcardAcptErrNum();
        int sdcardAcptErrRate = cloudBackup.getSdcardAcptErrRate();
        if (sdcardAcptErrNum < 0 || sdcardAcptErrRate < 0) {
            return;
        }
        this.sdcardAcptErrNum = sdcardAcptErrNum;
        this.sdcardAcptErrRate = sdcardAcptErrRate;
    }

    private void getSystemModuleInfo(String str, Bundle bundle) throws C9721b {
        int iM63686h;
        boolean z10;
        if (bundle == null) {
            C11839m.m70687e(TAG, "bundle is null, appId: " + str);
            return;
        }
        SnapshotBackupMeta snapshotBackupMeta = this.lastAppMetas.get(str);
        if (snapshotBackupMeta == null) {
            snapshotBackupMeta = new SnapshotBackupMeta();
            snapshotBackupMeta.setAppType(C0241z.m1688f("0"));
            snapshotBackupMeta.setData(str);
            snapshotBackupMeta.setAppId(str);
        }
        SnapshotBackupMeta snapshotBackupMeta2 = snapshotBackupMeta;
        Bundle bundle2 = new Bundle();
        C10343b c10343b = new C10343b(bundle);
        if (HNConstants.DataType.CONTACT.equals(str)) {
            Iterator<String> it = c10343b.m63697s().iterator();
            iM63686h = 0;
            while (it.hasNext()) {
                String next = it.next();
                Bundle bundleM63684f = c10343b.m63684f(next);
                if (bundleM63684f != null) {
                    C10343b c10343b2 = new C10343b(bundleM63684f);
                    Iterator<String> it2 = it;
                    if ("Phone".equals(c10343b2.m63694p("AccountName"))) {
                        int iM63686h2 = c10343b2.m63686h("ModuleCount");
                        snapshotBackupMeta2.setSize(bundleM63684f.getLong("ModuleSize"));
                        bundle2.putInt(CloneService.KEY_ACTION_FLAG, 10);
                        Bundle bundle3 = new Bundle();
                        bundle3.putBundle(next, bundleM63684f);
                        bundle2.putBundle(HNConstants.DataType.CONTACT, bundle3);
                        iM63686h = iM63686h2;
                    }
                    it = it2;
                }
            }
            z10 = false;
        } else {
            boolean zM63681c = c10343b.m63681c("isSupportClone");
            iM63686h = c10343b.m63686h("ModuleCount");
            snapshotBackupMeta2.setSize(c10343b.m63688j("ModuleSize"));
            bundle2.putInt(CloneService.KEY_ACTION_FLAG, 10);
            if (NavigationUtils.SMS_SCHEMA_PREF.equals(str)) {
                bundle2.putBoolean("isSupportPduFileOptimization", true);
            }
            z10 = zM63681c;
        }
        C11839m.m70686d(TAG, "appId = " + str + ", datasize = " + snapshotBackupMeta2.getSize() + " totalNum = " + iM63686h + " isSupportClone = " + z10);
        long j10 = (long) iM63686h;
        snapshotBackupMeta2.setCount(j10);
        snapshotBackupMeta2.setAppSwitch(ICBUtil.getSwitchFromOptionSp(str, false));
        updateModuleCache(str, snapshotBackupMeta2.getSize(), j10, snapshotBackupMeta2.getAppSwitch());
        if (iM63686h > 0 || z10) {
            if (("soundrecorder".equals(str) || "callRecorder".equals(str)) && iM63686h == 0) {
                C11839m.m70688i(TAG, "filter module, appId = " + str);
                return;
            }
            this.backupCaches.put(str, bundle2);
            this.currentAppMetas.put(str, snapshotBackupMeta2);
            this.sysAppId.add(str);
            initModuleStatus(str, 0);
        }
    }

    private String getTarTemp(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.location);
        String str2 = File.separator;
        sb2.append(str2);
        sb2.append(str);
        sb2.append(str2);
        sb2.append(TAR_DIR);
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleFileNotExist(CountDownLatch countDownLatch, SnapshotBackupMeta snapshotBackupMeta) throws InterruptedException, C9721b, SQLException {
        if (snapshotBackupMeta == null) {
            C11839m.m70687e(TAG, "handleFileNotExist backupMeta is null");
            throw new C9721b(FamilyShareConstants.StatusCode.SHARE_SPACE_NOT_ENOUGH, "handleFileNotExist sdcard file not found backupMeta is null");
        }
        String appId = snapshotBackupMeta.getAppId();
        isCancel();
        SnapshotBackupMetaOperator snapshotBackupMetaOperator = new SnapshotBackupMetaOperator(this.backupId);
        reportFileNotExist(snapshotBackupMeta);
        if (HNConstants.DataType.MEDIA.equals(appId) || "music".equals(appId)) {
            snapshotBackupMetaOperator.updateDeleteAndClearCloudPath(snapshotBackupMeta);
            this.uploadSize--;
            countDownLatch.countDown();
            return;
        }
        String localPath = SnapshotTreeUtil.getLocalPath(snapshotBackupMeta, this.location);
        C11839m.m70686d(TAG, "handleFileNotExist: " + localPath);
        if (localPath == null || localPath.startsWith(this.location)) {
            BackupCacheRecord.delete(CacheTask.getContext(), appId);
            snapshotBackupMetaOperator.updateRootNodeStatus(appId, 0L);
            defaultPmsMetaStatus(appId);
            throw new C9721b(FamilyShareConstants.StatusCode.SHARE_SPACE_NOT_ENOUGH, "handleFileNotExist file not found " + appId + ": " + localPath);
        }
        snapshotBackupMetaOperator.updateDeleteAndClearCloudPath(snapshotBackupMeta);
        int iQueryWaitDeleteFileCount = snapshotBackupMetaOperator.queryWaitDeleteFileCount(appId);
        SnapshotBackupMeta snapshotBackupMetaQueryRootNodeMeta = snapshotBackupMetaOperator.queryRootNodeMeta(appId);
        snapshotBackupMetaQueryRootNodeMeta.setData4(String.valueOf(iQueryWaitDeleteFileCount));
        snapshotBackupMetaOperator.batchReplace(Collections.singletonList(snapshotBackupMetaQueryRootNodeMeta));
        getSdcardAcptErrValue(appId);
        C11839m.m70686d(TAG, "handleFileNotExist moduleNotExistCount:" + iQueryWaitDeleteFileCount + " ,moduleAllFileCount: " + this.moduleAllFileCount + ", sdcardAcptErrNum: " + this.sdcardAcptErrNum + ", sdcardAcptErrRate: " + this.sdcardAcptErrRate);
        if (iQueryWaitDeleteFileCount > this.sdcardAcptErrNum) {
            snapshotBackupMetaOperator.updateRootNodeStatus(appId, 2L);
            throw new C9721b(FamilyShareConstants.StatusCode.SHARE_SPACE_NOT_ENOUGH, "handleFileNotExist sdcard file not found " + appId + " moduleNotExistCount: " + iQueryWaitDeleteFileCount);
        }
        int i10 = this.moduleAllFileCount;
        float f10 = i10 != 0 ? (iQueryWaitDeleteFileCount / i10) * 100.0f : 0.0f;
        if (f10 <= this.sdcardAcptErrRate) {
            countDownLatch.countDown();
            return;
        }
        snapshotBackupMetaOperator.updateRootNodeStatus(appId, 2L);
        throw new C9721b(FamilyShareConstants.StatusCode.SHARE_SPACE_NOT_ENOUGH, "handleFileNotExist sdcard file not found " + appId + " moduleNotExistCount: " + iQueryWaitDeleteFileCount + " ,prorate: " + f10);
    }

    private void handleModuleBackupException(C9721b c9721b) throws C9721b, SQLException {
        if (c9721b.m60659c() == 1998) {
            C11839m.m70689w(TAG, "module not backup. appId = " + this.current);
            this.snapshotTreeService.deleteRootNode(this.current, this.backupId);
            deleteModuleCache(this.current);
            return;
        }
        if ((c9721b.m60659c() != 2005 && c9721b.m60659c() != 2012 && c9721b.m60659c() != 2013) || !isFileterModule(this.current)) {
            throw c9721b;
        }
        this.filterModule.put(this.current, c9721b.getMessage());
    }

    private void init3rdAppModuleList() throws InterruptedException, C9721b {
        Bundle bundle;
        isCancel();
        Bundle backupModuleInfo = this.cloneService.getBackupModuleInfo("app", true);
        if (backupModuleInfo == null || (bundle = (Bundle) new C10343b(backupModuleInfo).m63680b("app")) == null) {
            return;
        }
        ArrayList<String> stringArrayList = bundle.getStringArrayList("AppPackageList");
        if (stringArrayList == null) {
            stringArrayList = new ArrayList<>();
        }
        stringArrayList.removeAll(this.appBlackList);
        stringArrayList.removeAll(this.disableIds);
        isCancel();
        if (stringArrayList.isEmpty()) {
            return;
        }
        for (String str : stringArrayList) {
            isCancel();
            SnapshotBackupMeta snapshotBackupMeta = this.lastAppMetas.get(str);
            if (snapshotBackupMeta == null) {
                snapshotBackupMeta = new SnapshotBackupMeta();
                snapshotBackupMeta.setAppId(str);
                snapshotBackupMeta.setData(str);
                snapshotBackupMeta.setAppType(C0241z.m1688f("3"));
            }
            Bundle bundle2 = new Bundle();
            bundle2.putInt(str, 1);
            Bundle bundle3 = new Bundle();
            bundle3.putInt(CloneService.KEY_ACTION_FLAG, 10);
            bundle3.putBundle("app", bundle2);
            snapshotBackupMeta.setAppSwitch(ICBUtil.getSwitchFromOptionSp(str, false));
            this.backupCaches.put(str, bundle3);
            this.currentAppMetas.put(str, snapshotBackupMeta);
            this.thirdAppId.add(str);
            initModuleStatus(str, 1);
        }
    }

    private void init3rdAppModuleSize(boolean z10) throws C9721b {
        BackupOptionItem backupOptionItemQueryItem;
        PackageManager packageManager = CacheTask.getContext().getPackageManager();
        boolean zM75353O0 = this.backupConfigOperator.m75353O0();
        Iterator<Map.Entry<String, SnapshotBackupMeta>> it = this.currentAppMetas.entrySet().iterator();
        while (it.hasNext()) {
            SnapshotBackupMeta value = it.next().getValue();
            String appId = value.getAppId();
            if (!isPresetModule(appId) && !this.virtualList.contains(appId)) {
                long j10 = 0;
                if (zM75353O0) {
                    CloudBackupAppDataUtil cloudBackupAppDataUtil = new CloudBackupAppDataUtil(appId, this.location, ICBUtil.getVersionCode(packageManager, appId), false, false);
                    value.setOmConfigAble(isSupportPMS() && cloudBackupAppDataUtil.isAppDataAble());
                    if (value.isOmConfigAble() && value.getAppSwitch()) {
                        long dataBytes = (!z10 || (backupOptionItemQueryItem = TransferedUtil.queryItem(value.getAppId(), false)) == null) ? new ScanAppDataUtil(appId, cloudBackupAppDataUtil.getmCloudBackupInclude(), cloudBackupAppDataUtil.getmCloudBackupExclude()).get3rdAppDataSize(cloudBackupAppDataUtil) : backupOptionItemQueryItem.getDataBytes();
                        j10 = dataBytes;
                        update3rdModuleCache(appId, j10);
                    }
                    value.setSize(j10);
                } else {
                    value.setOmConfigAble(false);
                    value.setSize(0L);
                }
            }
        }
    }

    private long initApkPackageInfo() throws PackageManager.NameNotFoundException {
        PackageManager packageManager = CacheTask.getContext().getPackageManager();
        long longVersionCode = 0;
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(this.current, 16384);
            if (packageInfo == null || packageInfo.applicationInfo == null) {
                return 0L;
            }
            longVersionCode = PackageInfoCompat.getLongVersionCode(packageInfo);
            this.currentAppName = packageManager.getApplicationLabel(packageInfo.applicationInfo).toString();
            C11839m.m70688i(TAG, "thirdAppId currentAppName " + this.currentAppName);
            return longVersionCode;
        } catch (RuntimeException e10) {
            C11839m.m70687e(TAG, "initApkPackageInfo e: " + e10.toString());
            return longVersionCode;
        }
    }

    private void initConfigs(CBSInitParam cBSInitParam) throws C9721b {
        Settings settings = new Settings("notifycycle", String.valueOf(cBSInitParam.getReminderCycle()), "1");
        int nextBackupTime = cBSInitParam.getNextBackupTime() * 60000;
        new SettingOperator().replace(new Settings[]{settings, new Settings("nextbackuptime", String.valueOf(nextBackupTime), "2"), new Settings("delayedstarttime", String.valueOf(cBSInitParam.getDelayedStartTime() * 60000), "2"), new Settings("breakedtime", String.valueOf(cBSInitParam.getBreakedTime() * 60000), "2")});
        if (nextBackupTime > 0 && this.autoBackup) {
            C11839m.m70688i(TAG, "cloudbackup serverPath busy, next backup time = " + nextBackupTime);
            throw new C9721b(SNSCode.Status.GET_FRIEND_LIST_FAIL, "CBS server busy, next backup time = " + nextBackupTime, "onPrepare");
        }
        List<String> appsBlackList = cBSInitParam.getAppsBlackList();
        this.appBlackList = appsBlackList;
        appsBlackList.addAll(C14333b.m85454J());
        this.moduleBlacks = cBSInitParam.getModuleBlackList();
        this.whites = cBSInitParam.getAppsWhiteList();
        if (this.isSupportGallery) {
            AlbumsTempDBManager.initDataBase(CacheTask.getContext().getApplicationContext(), this.galleryDB);
            ICBUtil.refreshLocalAlbumSettings(CacheTask.getContext(), false);
        }
        initMusicConfig(cBSInitParam);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0072 A[DONT_GENERATE, PHI: r2 r4 r12
  0x0072: PHI (r2v10 long) = (r2v6 long), (r2v14 long) binds: [B:25:0x008e, B:22:0x0070] A[DONT_GENERATE, DONT_INLINE]
  0x0072: PHI (r4v4 long) = (r4v2 long), (r4v6 long) binds: [B:25:0x008e, B:22:0x0070] A[DONT_GENERATE, DONT_INLINE]
  0x0072: PHI (r12v4 android.database.Cursor) = (r12v2 android.database.Cursor), (r12v5 android.database.Cursor) binds: [B:25:0x008e, B:22:0x0070] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void initGallerySize() throws fk.C9721b {
        /*
            r13 = this;
            boolean r0 = r13.isSupportGallery
            java.lang.String r1 = "CloudBackupTask"
            if (r0 != 0) goto Lc
            java.lang.String r13 = "unsupport gallery backup."
            p514o9.C11839m.m70688i(r1, r13)
            return
        Lc:
            java.lang.String r0 = "external"
            android.net.Uri r3 = android.provider.MediaStore.Files.getContentUri(r0)
            java.lang.String r0 = "_data"
            java.lang.String r8 = "_size"
            java.lang.String[] r4 = new java.lang.String[]{r0, r8}
            java.lang.String r7 = "_data asc"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "media_type"
            r0.<init>(r2)
            java.lang.String r2 = " in ("
            r0.append(r2)
            r9 = 1
            r0.append(r9)
            java.lang.String r2 = ", "
            r0.append(r2)
            r2 = 3
            r0.append(r2)
            java.lang.String r2 = ")"
            r0.append(r2)
            r10 = 0
            r12 = 0
            android.content.Context r2 = com.huawei.android.hicloud.cloudbackup.process.CacheTask.getContext()     // Catch: java.lang.Throwable -> L65 java.lang.Exception -> L6a
            android.content.ContentResolver r2 = r2.getContentResolver()     // Catch: java.lang.Throwable -> L65 java.lang.Exception -> L6a
            java.lang.String r5 = r0.toString()     // Catch: java.lang.Throwable -> L65 java.lang.Exception -> L6a
            r6 = 0
            android.database.Cursor r12 = r2.query(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L65 java.lang.Exception -> L6a
            if (r12 == 0) goto L6e
            int r0 = r12.getColumnIndex(r8)     // Catch: java.lang.Throwable -> L65 java.lang.Exception -> L6a
            r2 = r10
            r4 = r2
        L56:
            boolean r6 = r12.moveToNext()     // Catch: java.lang.Throwable -> L65 java.lang.Exception -> L68
            if (r6 == 0) goto L70
            long r6 = r12.getLong(r0)     // Catch: java.lang.Throwable -> L65 java.lang.Exception -> L68
            long r2 = r2 + r6
            r6 = 1
            long r4 = r4 + r6
            goto L56
        L65:
            r13 = move-exception
            goto Ld1
        L68:
            r0 = move-exception
            goto L76
        L6a:
            r0 = move-exception
            r2 = r10
            r4 = r2
            goto L76
        L6e:
            r2 = r10
            r4 = r2
        L70:
            if (r12 == 0) goto L91
        L72:
            r12.close()
            goto L91
        L76:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L65
            r6.<init>()     // Catch: java.lang.Throwable -> L65
            java.lang.String r7 = "scan media database error. "
            r6.append(r7)     // Catch: java.lang.Throwable -> L65
            java.lang.String r0 = r0.getMessage()     // Catch: java.lang.Throwable -> L65
            r6.append(r0)     // Catch: java.lang.Throwable -> L65
            java.lang.String r0 = r6.toString()     // Catch: java.lang.Throwable -> L65
            p514o9.C11839m.m70687e(r1, r0)     // Catch: java.lang.Throwable -> L65
            if (r12 == 0) goto L91
            goto L72
        L91:
            java.util.Map<java.lang.String, com.huawei.android.hicloud.cloudbackup.snapshottree.db.bean.SnapshotBackupMeta> r0 = r13.lastAppMetas
            java.lang.String r1 = "gallery"
            java.lang.Object r0 = r0.get(r1)
            com.huawei.android.hicloud.cloudbackup.snapshottree.db.bean.SnapshotBackupMeta r0 = (com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.bean.SnapshotBackupMeta) r0
            if (r0 != 0) goto La8
            com.huawei.android.hicloud.cloudbackup.snapshottree.db.bean.SnapshotBackupMeta r0 = new com.huawei.android.hicloud.cloudbackup.snapshottree.db.bean.SnapshotBackupMeta
            r0.<init>()
            r0.setData(r1)
            r0.setAppId(r1)
        La8:
            r0.setSize(r2)
            r0.setCount(r4)
            int r2 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r2 <= 0) goto Ld0
            r0.setAppSwitch(r9)
            java.util.Map<java.lang.String, com.huawei.android.hicloud.cloudbackup.snapshottree.db.bean.SnapshotBackupMeta> r2 = r13.currentAppMetas
            r2.put(r1, r0)
            long r8 = r0.getSize()
            long r10 = r0.getCount()
            r12 = 1
            java.lang.String r7 = "gallery"
            r6 = r13
            r6.updateModuleCache(r7, r8, r10, r12)
            r13.compareGallery(r4)
            r0 = 0
            r13.initModuleStatus(r1, r0)
        Ld0:
            return
        Ld1:
            if (r12 == 0) goto Ld6
            r12.close()
        Ld6:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.cloudbackup.process.CloudBackupTask.initGallerySize():void");
    }

    private void initModuleStatus(String str, int i10) throws C9721b {
        C12815f c12815f = new C12815f();
        CloudBackupStatus cloudBackupStatusM76928g = c12815f.m76928g(str);
        if (cloudBackupStatusM76928g == null) {
            cloudBackupStatusM76928g = new CloudBackupStatus();
            cloudBackupStatusM76928g.mo29313Y(str).mo29318b0(i10).mo29338z0(0).mo29289A0(0);
        }
        BackupOptionItem backupOptionItemM78401y = this.itemOperator.m78401y(str);
        if (i10 == 2 || i10 == 0) {
            cloudBackupStatusM76928g.m29339A1(true);
        } else {
            cloudBackupStatusM76928g.m29339A1(backupOptionItemM78401y != null && backupOptionItemM78401y.getBackupSwitch()).m29408h2(C12565k.m75518d(str));
        }
        if (cloudBackupStatusM76928g.m29859L() == 0) {
            cloudBackupStatusM76928g.m29436s2(0L);
            cloudBackupStatusM76928g.mo29327g0(backupOptionItemM78401y != null ? backupOptionItemM78401y.getItemTotal() : 0).mo29323e0(cloudBackupStatusM76928g.m29425o1() ? backupOptionItemM78401y != null ? backupOptionItemM78401y.getDataBytes() : 0L : 0L);
        }
        if (cloudBackupStatusM76928g.m29859L() > 3) {
            cloudBackupStatusM76928g.mo29289A0(6);
        }
        c12815f.m76934m(cloudBackupStatusM76928g);
    }

    private void initModuleSwitchInfo() throws C9721b {
        initMusicAndGallerySwitch();
        ArrayList arrayList = new ArrayList();
        boolean zEquals = "1".equals(new SettingOperator().queryUploadTargetStrategy());
        boolean zM1273k1 = C0209d.m1273k1();
        for (String str : this.defaultModules) {
            boolean z10 = (zEquals || zM1273k1) && C14333b.f63656h.contains(str);
            if (!ICBUtil.getSwitchFromOptionSp(str, false) || z10) {
                arrayList.add(str);
            }
        }
        this.defaultModules.removeAll(arrayList);
    }

    private void initMusicAndGallerySwitch() throws C9721b {
        if (!ICBUtil.getSwitchFromOptionSp("music", false)) {
            this.isSupportMusic = false;
        }
        this.isSupportGallery = ICBUtil.isSupportGallery(CacheTask.getContext());
        this.disableIds = new SettingOperator().queryblacklist();
        if (this.isSupportGallery) {
            if (!ICBUtil.getSwitchFromOptionSp(HNConstants.DataType.MEDIA, false)) {
                this.isSupportGallery = false;
            }
            if (this.disableIds.contains(HNConstants.DataType.MEDIA)) {
                this.isSupportGallery = false;
            }
        }
        C11839m.m70686d(TAG, "initModuleSwitchInfo isSupportGallery: " + this.isSupportGallery + " ,isSupportMusic = " + this.isSupportMusic);
    }

    private void initMusicConfig(CBSInitParam cBSInitParam) {
        MusicBackup musicBackup = new MusicBackup(this.location, CacheTask.getContext(), cBSInitParam);
        this.mMusicBackup = musicBackup;
        musicBackup.init();
    }

    private void initMusicSize(CBSInitParam cBSInitParam) throws C9721b {
        if (!this.isSupportMusic) {
            C11839m.m70688i(TAG, "initMusicSize unsupport music backup.");
            if (cBSInitParam == null) {
                return;
            }
            C11839m.m70688i(TAG, "save music black list");
            List<MusicBackup.MusicSetting> settingFromMediaList = MusicBackup.MusicSetting.getSettingFromMediaList(cBSInitParam.getMediaLibBackup());
            ArrayList arrayList = new ArrayList();
            Iterator<MusicBackup.MusicSetting> it = settingFromMediaList.iterator();
            while (it.hasNext()) {
                List<String> blackList = it.next().getBlackList();
                if (blackList != null) {
                    arrayList.addAll(blackList);
                }
            }
            C13465e.m81052f().m81066o("musicBlackList", arrayList);
            return;
        }
        SnapshotBackupMeta musicBackupMeta = this.mMusicBackup.getMusicBackupMeta();
        if (musicBackupMeta == null) {
            C11839m.m70688i(TAG, "initMusicSize backupStatus is null, do not backup music");
            return;
        }
        long count = musicBackupMeta.getCount();
        long size = musicBackupMeta.getSize();
        SnapshotBackupMeta snapshotBackupMeta = this.lastAppMetas.get("music");
        if (snapshotBackupMeta == null) {
            snapshotBackupMeta = new SnapshotBackupMeta();
        }
        snapshotBackupMeta.setSize(size);
        snapshotBackupMeta.setCount(count);
        compareMusic();
        snapshotBackupMeta.setData("music");
        snapshotBackupMeta.setAppId("music");
        snapshotBackupMeta.setAppSwitch(true);
        this.currentAppMetas.put("music", snapshotBackupMeta);
        updateModuleCache("music", snapshotBackupMeta.getSize(), snapshotBackupMeta.getCount(), true);
        initModuleStatus("music", 0);
    }

    private void initOmConfig() throws C9721b {
        C12585q1.m75709s();
        C12585q1.m75691a(TAG);
        C12526j c12526j = this.backupConfigOperator;
        if (c12526j == null) {
            return;
        }
        this.switch3rdDefault = c12526j.m75369W0();
        C11839m.m70688i(TAG, "switch3rdDefault: " + this.switch3rdDefault);
        this.dataCacheDuration = this.backupConfigOperator.m75408n0(this.autoBackup);
        this.cacheDuration = this.backupConfigOperator.m75406m0(this.autoBackup);
    }

    private CBSInitParam initParams() throws Throwable {
        try {
            CBSInitParam cBSInitParamM65890a = new C10897a(this.traceID).m65890a(this.autoBackup);
            if (!TextUtils.isEmpty(cBSInitParamM65890a.getGradeCode())) {
                C13466f.m81073d().m81084l("gradeCode", cBSInitParamM65890a.getGradeCode());
                C12590s0.m75926y2(this.traceID, cBSInitParamM65890a.getGradeCode(), "backupTask initParams");
                C11839m.m70688i(TAG, "backupTask initParams  , gradeCode = " + cBSInitParamM65890a.getGradeCode());
                int gradeMinFrequency = CloudBackupUtil.getGradeMinFrequency(cBSInitParamM65890a.getGradeCode());
                if (C13467g.m81086c().m81091f() < gradeMinFrequency) {
                    C11839m.m70688i(TAG, "user member expires or degrade, reset user frequency: " + gradeMinFrequency);
                    C13467g.m81086c().m81098m(gradeMinFrequency);
                    Message message = new Message();
                    message.what = 33016;
                    CBCallBack.getInstance().sendMessage(message);
                }
            }
            isCancel();
            initConfigs(cBSInitParamM65890a);
            return cBSInitParamM65890a;
        } catch (C9721b e10) {
            if (e10.m60659c() == 3113) {
                try {
                    JSONObject jSONObject = new JSONObject(e10.getMessage()).getJSONObject("params");
                    if (!jSONObject.isNull("gradeCode")) {
                        String string = jSONObject.getString("gradeCode");
                        C13466f.m81073d().m81084l("gradeCode", string);
                        C11839m.m70688i(TAG, "backupTask backup_frequency_errors  , gradeCode = " + string);
                        C12590s0.m75926y2(this.traceID, string, "backupTask backup_frequency_errors");
                        int gradeMinFrequency2 = CloudBackupUtil.getGradeMinFrequency(string);
                        if (C13467g.m81086c().m81091f() < gradeMinFrequency2) {
                            C11839m.m70688i(TAG, "user member expires or degrade, reset user frequency: " + gradeMinFrequency2);
                            C13467g.m81086c().m81098m(gradeMinFrequency2);
                            Message message2 = new Message();
                            message2.what = 33016;
                            CBCallBack.getInstance().sendMessage(message2);
                        }
                    }
                } catch (JSONException unused) {
                    throw new C9721b(3107, e10.getMessage(), "CBSService_initParamReq");
                }
            }
            throw e10;
        }
    }

    private void initSwitchs() {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(CacheTask.getContext(), SharedPreferencesStorage.BACKUPOPTION_SPFILE, 0);
        HashMap map = new HashMap();
        map.put("addressbook", Boolean.valueOf(sharedPreferencesM1382b.getBoolean("addressbook", false)));
        map.put("calendar", Boolean.valueOf(sharedPreferencesM1382b.getBoolean("calendar", false)));
        map.put("wlan", Boolean.valueOf(sharedPreferencesM1382b.getBoolean("wlan", false)));
        map.put("notepad", Boolean.valueOf(sharedPreferencesM1382b.getBoolean("notepad", false)));
        map.put("browser", Boolean.valueOf(sharedPreferencesM1382b.getBoolean("browser", false)));
        map.put("backup_key", Boolean.valueOf(sharedPreferencesM1382b.getBoolean("backup_key", false)));
        map.put("autosmslistkey", Boolean.valueOf(sharedPreferencesM1382b.getBoolean("autosmslistkey", false)));
        map.put("autocallloglistkey", Boolean.valueOf(sharedPreferencesM1382b.getBoolean("autocallloglistkey", false)));
        map.put("autorecordingkey", Boolean.valueOf(sharedPreferencesM1382b.getBoolean("autorecordingkey", false)));
        map.put("autophonemanagerkey", Boolean.valueOf(sharedPreferencesM1382b.getBoolean("autophonemanagerkey", false)));
        Iterator<SyncConfigService> it = NotifyUtil.getShownSyncServiceItems(CacheTask.getContext()).iterator();
        while (it.hasNext()) {
            String id2 = it.next().getId();
            if (!TextUtils.isEmpty(id2)) {
                boolean z10 = sharedPreferencesM1382b.getBoolean(id2, false);
                C11839m.m70686d(TAG, "initSwitchs " + id2 + " switch status: " + z10);
                map.put(id2, Boolean.valueOf(z10));
            }
        }
        C1006a.m5936k().m5947K(CacheTask.getContext(), map);
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry entry : map.entrySet()) {
            sb2.append((String) entry.getKey());
            sb2.append('=');
            sb2.append(entry.getValue());
            sb2.append('&');
        }
        this.recordExtend = SafeString.substring(sb2.toString(), 0, sb2.length() - 1);
        reportSwitch();
    }

    private void initSystemModuleSize() throws InterruptedException, C9721b {
        isCancel();
        this.defaultModules.remove("app");
        this.defaultModules.remove("virtual.sync.switch.status");
        for (String str : this.defaultModules) {
            Bundle backupModuleInfo = this.cloneService.getBackupModuleInfo(str, true);
            if (backupModuleInfo != null) {
                getSystemModuleInfo(str, new C10343b(backupModuleInfo).m63684f(str));
            }
        }
    }

    private void initVirtualModuleList(SnapshotBackupMeta snapshotBackupMeta) throws C9721b {
        String appId = snapshotBackupMeta.getAppId();
        long size = snapshotBackupMeta.getSize();
        if (!this.virtualList.contains(appId)) {
            if (size > 0) {
                this.currentAppMetas.put(appId, snapshotBackupMeta);
                initModuleStatus(appId, 2);
                this.virtualList.add(appId);
                return;
            }
            return;
        }
        this.currentAppMetas.remove(appId);
        if (size <= 0) {
            this.virtualList.remove(appId);
        } else {
            this.currentAppMetas.put(appId, snapshotBackupMeta);
            initModuleStatus(appId, 2);
        }
    }

    private void initVirtualModuleSize(boolean z10) throws C9721b {
        BackupOptionItem backupOptionItemQueryItem;
        long jScanAppDataSize;
        if (this.backupConfigOperator.m75353O0()) {
            for (String str : new C12519c().m75297h(1)) {
                if (!this.thirdAppId.contains(str) && !isPresetModule(str) && ((backupOptionItemQueryItem = TransferedUtil.queryItem(str, false)) == null || backupOptionItemQueryItem.getBackupSwitch())) {
                    SnapshotBackupMeta snapshotBackupMeta = this.lastAppMetas.get(str);
                    if (snapshotBackupMeta == null) {
                        snapshotBackupMeta = new SnapshotBackupMeta();
                        snapshotBackupMeta.setAppId(str);
                        snapshotBackupMeta.setData(str);
                        snapshotBackupMeta.setAppType(C0241z.m1688f("0"));
                    }
                    SnapshotBackupMeta snapshotBackupMeta2 = snapshotBackupMeta;
                    CloudBackupAppDataUtil cloudBackupAppDataUtil = new CloudBackupAppDataUtil(str, this.location, 0L, false, false);
                    boolean zIsAppDataAble = cloudBackupAppDataUtil.isAppDataAble();
                    snapshotBackupMeta2.setOmConfigAble(zIsAppDataAble);
                    long jScanAppDataSize2 = 0;
                    if (zIsAppDataAble) {
                        if (snapshotBackupMeta2.getStatus() == 4) {
                            jScanAppDataSize2 = snapshotBackupMeta2.getSize();
                        } else if (z10) {
                            BackupOptionItem backupOptionItemQueryItem2 = TransferedUtil.queryItem(snapshotBackupMeta2.getAppId(), false);
                            if (backupOptionItemQueryItem2 != null) {
                                long dataBytes = backupOptionItemQueryItem2.getDataBytes();
                                if (dataBytes == 0) {
                                    C11839m.m70686d(TAG, "initVirtualModuleSize dataSize = 0");
                                    jScanAppDataSize = scanAppDataSize(str, cloudBackupAppDataUtil);
                                } else {
                                    jScanAppDataSize2 = dataBytes;
                                }
                            } else {
                                jScanAppDataSize = scanAppDataSize(str, cloudBackupAppDataUtil);
                            }
                            jScanAppDataSize2 = jScanAppDataSize;
                        } else {
                            jScanAppDataSize2 = scanAppDataSize(str, cloudBackupAppDataUtil);
                        }
                    }
                    snapshotBackupMeta2.setSize(jScanAppDataSize2);
                    snapshotBackupMeta2.setAppSwitch(true);
                    initVirtualModuleList(snapshotBackupMeta2);
                }
            }
        }
    }

    private boolean isCharging() {
        CloudBackupConditionsUtil.ChargeAttr chargeAttr = CloudBackupConditionsUtil.getChargeAttr();
        boolean zIsCharging = chargeAttr.isCharging();
        C11839m.m70688i(TAG, "isCharging: " + zIsCharging);
        return zIsCharging || (CloudBackupConditionsUtil.isConfigureBatteryChanger() && CloudBackupConditionsUtil.isSmartCharging(chargeAttr));
    }

    private boolean isEndTar(QueryBackupMeta queryBackupMeta, File file, long j10, Iterator<SnapshotBackupMeta> it, int i10, long j11) {
        return (file.exists() && file.length() > j10) || !(it.hasNext() || queryBackupMeta.hasNext()) || ((long) i10) >= j11;
    }

    private boolean isFileterModule(String str) {
        if (this.moduleBlacks.isEmpty()) {
            return false;
        }
        for (CBSFilterModule cBSFilterModule : this.moduleBlacks) {
            if (cBSFilterModule.getModuleName() != null && !cBSFilterModule.getModuleName().isEmpty() && cBSFilterModule.getModuleName().equals(str)) {
                List<String> emuiVers = cBSFilterModule.getEmuiVers();
                List<String> moduleVers = cBSFilterModule.getModuleVers();
                if (emuiVers.isEmpty() && moduleVers.isEmpty()) {
                    return true;
                }
                if (!emuiVers.isEmpty() && emuiVers.contains(C0209d.m1186L())) {
                    return true;
                }
                String appVersionFromBackupMeta = getAppVersionFromBackupMeta(str);
                if (TextUtils.isEmpty(appVersionFromBackupMeta)) {
                    appVersionFromBackupMeta = "-1";
                }
                return !moduleVers.isEmpty() && moduleVers.contains(appVersionFromBackupMeta);
            }
        }
        return false;
    }

    private boolean isModuleDone(SnapshotBackupMeta snapshotBackupMeta) {
        if (snapshotBackupMeta.getStatus() != 5 && snapshotBackupMeta.getStatus() != 6) {
            return false;
        }
        C11839m.m70688i(TAG, snapshotBackupMeta.getAppId() + " current node status = " + snapshotBackupMeta.getStatus());
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean isNeedPrepareData(com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.bean.SnapshotBackupMeta r11) {
        /*
            r10 = this;
            int r0 = r11.getStatus()
            java.lang.String r1 = "CloudBackupTask"
            r2 = 0
            r4 = 0
            r5 = 1
            switch(r0) {
                case 1: goto L24;
                case 2: goto L24;
                case 3: goto L24;
                case 4: goto Le;
                case 5: goto L87;
                case 6: goto L87;
                default: goto Ld;
            }
        Ld:
            goto L22
        Le:
            long r6 = java.lang.System.currentTimeMillis()
            long r8 = r11.getDateCreate()
            long r6 = r6 - r8
            int r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r2 <= 0) goto L22
            long r2 = r10.cacheDuration
            int r10 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r10 >= 0) goto L22
            goto L87
        L22:
            r4 = r5
            goto L87
        L24:
            long r6 = java.lang.System.currentTimeMillis()
            long r8 = r11.getDateInvalid()
            long r6 = r6 - r8
            int r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r2 <= 0) goto L38
            long r2 = r10.dataCacheDuration
            int r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r2 >= 0) goto L38
            goto L39
        L38:
            r4 = r5
        L39:
            java.lang.String r2 = "gallery"
            java.lang.String r3 = r10.current
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L7c
            java.lang.String r2 = "music"
            java.lang.String r3 = r10.current
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L7c
            java.lang.String r2 = r10.location
            java.lang.String r3 = r10.current
            java.io.File r2 = hk.C10278a.m63443i(r2, r3)
            java.io.File[] r2 = r2.listFiles()
            if (r2 == 0) goto L5e
            int r2 = r2.length
            if (r2 > 0) goto L7c
        L5e:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "isNeedPrepareData appId: "
            r2.append(r3)
            java.lang.String r3 = r11.getAppId()
            r2.append(r3)
            java.lang.String r3 = " data dir is not exist"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            p514o9.C11839m.m70688i(r1, r2)
            r4 = r5
        L7c:
            java.util.List<java.lang.String> r2 = r10.sysAppId
            java.lang.String r10 = r10.current
            boolean r10 = r2.contains(r10)
            if (r10 == 0) goto L87
            goto L22
        L87:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r2 = "isNeedPrepareData: "
            r10.append(r2)
            r10.append(r4)
            java.lang.String r2 = " appId:"
            r10.append(r2)
            java.lang.String r2 = r11.getAppId()
            r10.append(r2)
            java.lang.String r2 = ",status:"
            r10.append(r2)
            r10.append(r0)
            java.lang.String r0 = " ,data: "
            r10.append(r0)
            long r2 = r11.getDateInvalid()
            r10.append(r2)
            java.lang.String r0 = " ,sd: "
            r10.append(r0)
            long r2 = r11.getDateModify()
            r10.append(r2)
            java.lang.String r0 = " ,module: "
            r10.append(r0)
            long r2 = r11.getDateCreate()
            r10.append(r2)
            java.lang.String r10 = r10.toString()
            p514o9.C11839m.m70688i(r1, r10)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.cloudbackup.process.CloudBackupTask.isNeedPrepareData(com.huawei.android.hicloud.cloudbackup.snapshottree.db.bean.SnapshotBackupMeta):boolean");
    }

    private boolean isNeedScanData(SnapshotBackupMeta snapshotBackupMeta) {
        int status = snapshotBackupMeta.getStatus();
        if (status == 2 || status == 3) {
            long jCurrentTimeMillis = System.currentTimeMillis() - snapshotBackupMeta.getDateInvalid();
            if (jCurrentTimeMillis > 0 && jCurrentTimeMillis < this.dataCacheDuration) {
                return false;
            }
        } else if (status == 4) {
            long jCurrentTimeMillis2 = System.currentTimeMillis() - snapshotBackupMeta.getDateCreate();
            if (jCurrentTimeMillis2 > 0 && jCurrentTimeMillis2 < this.cacheDuration) {
                return false;
            }
        } else if (status == 5 || status == 6) {
            return false;
        }
        return true;
    }

    private boolean isNeedScanSdCard(SnapshotBackupMeta snapshotBackupMeta) {
        int status = snapshotBackupMeta.getStatus();
        if (status == 3) {
            long jM75410o0 = this.backupConfigOperator.m75410o0(this.autoBackup);
            long jCurrentTimeMillis = System.currentTimeMillis() - snapshotBackupMeta.getDateModify();
            boolean z10 = jCurrentTimeMillis <= 0 || jCurrentTimeMillis >= jM75410o0;
            if (!HNConstants.DataType.MEDIA.equals(this.current) && !"music".equals(this.current)) {
                return z10;
            }
        } else if (status == 4) {
            long jCurrentTimeMillis2 = System.currentTimeMillis() - snapshotBackupMeta.getDateCreate();
            if (jCurrentTimeMillis2 > 0 && jCurrentTimeMillis2 < this.cacheDuration) {
                return false;
            }
        } else if (status == 5 || status == 6) {
            return false;
        }
        return true;
    }

    private boolean isPmsSupportIncrement() {
        try {
            String strM81914C = C13617a.m81914C(this.current, 0);
            if (!C10278a.m63442h(strM81914C).exists()) {
                return false;
            }
            PmsMetaStatusOperator pmsMetaStatusOperator = new PmsMetaStatusOperator(strM81914C);
            if (pmsMetaStatusOperator.isExistTable()) {
                return pmsMetaStatusOperator.query() != null;
            }
            return false;
        } catch (C9721b e10) {
            C11839m.m70688i(TAG, "pmsMetaStatus CException: " + e10.toString());
            return false;
        }
    }

    private boolean isPresetModule(String str) {
        return this.sysAppId.contains(str) || HNConstants.DataType.MEDIA.equals(str) || "music".equals(str);
    }

    private boolean isSkipForegroundAppModule(String str, SnapshotBackupMeta snapshotBackupMeta, CloudBackupAppDataUtil cloudBackupAppDataUtil) throws C9721b {
        if (!snapshotBackupMeta.isOmConfigAble() || !snapshotBackupMeta.getAppSwitch()) {
            C11839m.m70688i(TAG, "not support backup app data, no need skip foreground, appId : " + str);
            return false;
        }
        if (!ICBUtil.isForGroundProcess(str, CacheTask.getContext(), this.currentBackupStatus.m29861N(), null)) {
            reportIsSkip(this.current, "backGround");
            return false;
        }
        reportIsSkip(this.current, "foreGround");
        if (!this.foregroundAppModuleMap.containsKey(str) && !cloudBackupAppDataUtil.isDirectlyBackupForegroundApp()) {
            C11839m.m70688i(TAG, "is foreground process = " + str);
            this.foregroundAppModuleMap.put(str, snapshotBackupMeta);
            return true;
        }
        if (cloudBackupAppDataUtil.isBackupForegroundApp()) {
            return false;
        }
        C11839m.m70687e(TAG, "backup error, isForeGroundProcess = " + str);
        throw new C9721b(FamilyShareConstants.StatusCode.SHARE_UNUSED_SPACE_NOT_ENOUGH, "ForeGroundProcess is running: " + str);
    }

    private boolean isSupportPMS() {
        boolean zM12611e = PmsCheckUtil.m12611e();
        C11839m.m70686d(TAG, "isSupportPMS = " + zM12611e);
        return zM12611e;
    }

    private boolean isTimeExpired(long j10, long j11) {
        long jCurrentTimeMillis = System.currentTimeMillis() - j10;
        return j10 > 0 && jCurrentTimeMillis > 0 && jCurrentTimeMillis >= j11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$registerThermalCallback$1(int i10, int i11) {
        C11839m.m70688i(TAG, "thermal callback,resType is:" + i11 + ",leve is:" + i10);
        if (i11 == 1 || i11 == 17) {
            C11839m.m70688i(TAG, "ThermalCallback resType = " + i11);
            if (ThermalChecker.matchThermalControlDevice(false)) {
                C11839m.m70688i(TAG, "ThermalCallback matchThermalControlDevice");
                this.thermalLevel = i10;
                if (ThermalChecker.isThermalControlByMain(i10, true)) {
                    return;
                }
                abort(1030);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$registerUniScheduleCallback$0(int i10, int i11) {
        if (i11 == 16) {
            C11839m.m70688i(TAG, "uniSchedule callback,resType is:" + i11 + ",leve is:" + i10);
            if (ThermalChecker.isUniSchedulerControlByMain(i10)) {
                return;
            }
            C11839m.m70688i(TAG, "ThermalCallback  isUniSchedulerControlByMain");
            if (CloudBackupConditionsUtil.isScreenOn()) {
                C11839m.m70688i(TAG, "screenOn,high load doAbort");
                abort(1006, "high load doAbort");
            }
        }
    }

    private CBSBackupRecord prepareForInitBackup(List<CBSBackupRecord> list) throws InterruptedException, C9721b {
        ArrayList arrayList = new ArrayList();
        CBSBackupRecord cBSBackupRecord = null;
        int i10 = 0;
        int i11 = 0;
        CBSBackupRecord cBSBackupRecord2 = null;
        for (CBSBackupRecord cBSBackupRecord3 : list) {
            String deviceId = cBSBackupRecord3.getDevice().getDeviceId();
            if (deviceId != null && !deviceId.isEmpty()) {
                arrayList.add(cBSBackupRecord3.getBackupId());
                if (cBSBackupRecord3.getStatus() == 0) {
                    i10++;
                    if (cBSBackupRecord == null || cBSBackupRecord.getEndTime() < cBSBackupRecord3.getEndTime()) {
                        cBSBackupRecord = cBSBackupRecord3;
                    }
                } else if (1 == cBSBackupRecord3.getStatus()) {
                    if (cBSBackupRecord3.isSupportSnapshot()) {
                        C11839m.m70688i(TAG, "in backuping record: " + cBSBackupRecord3.getBackupId());
                        this.inBackupingRecrdIds.add(cBSBackupRecord3.getBackupId());
                        this.inBackupV2Record = cBSBackupRecord3;
                    } else {
                        C11839m.m70688i(TAG, "in_backup backupRecord: " + cBSBackupRecord3.getBackupId());
                        cBSBackupRecord2 = cBSBackupRecord3;
                    }
                } else if (7 == cBSBackupRecord3.getStatus()) {
                    C11839m.m70688i(TAG, "exsit invalid record, save tags, backupId: " + cBSBackupRecord3.getBackupId());
                    i11++;
                }
            }
        }
        saveLastSuccessTime(cBSBackupRecord);
        CBSBackupRecord cBSBackupRecord4 = this.inBackupV2Record;
        if (cBSBackupRecord4 != null) {
            boolean zExistSnapshotDataBase = this.snapshotTreeService.existSnapshotDataBase(cBSBackupRecord4.getBackupId());
            if (!TextUtils.isEmpty(this.inBackupV2Record.getSnapshot()) && !zExistSnapshotDataBase) {
                this.needDownloadInBackupingSnapshot = true;
            }
        }
        processInvalidBackupRecord(i11, i10);
        processInBackupV1Record(cBSBackupRecord2);
        if (i10 >= C12590s0.m75751H0()) {
            C13466f.m81073d().m81081i("isStartDeleteTask", true);
        }
        C13617a.m81930l(arrayList);
        return cBSBackupRecord;
    }

    private void processBackupSpaceNotEnough(long j10, long j11) throws C9721b {
        if (j10 > 0) {
            long j12 = j10 - j11;
            C11839m.m70688i(TAG, "processBackupSpaceNotEnough quota space total = " + j10 + " used = " + j11);
            if (j12 < 0 && this.incrementSize == 0) {
                C11839m.m70688i(TAG, "available size < 0 and incrementSize = 0");
                return;
            }
            if (j12 >= this.incrementSize) {
                new SettingOperator().replace(new Settings[]{new Settings("nextbackuptime", "0", "2")});
                return;
            }
            C11839m.m70689w(TAG, "cloud space start not enough. available = " + j12 + " backup data size = " + this.incrementSize);
            BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData = new BackupSpaceNotEnoughNeedData();
            backupSpaceNotEnoughNeedData.setTotalNeedSpace(this.incrementSize + j11);
            backupSpaceNotEnoughNeedData.setBackupNeedSpace(this.incrementSize);
            backupSpaceNotEnoughNeedData.setNotUsedSpace(j12);
            backupSpaceNotEnoughNeedData.setTotalSpace(j10);
            backupSpaceNotEnoughNeedData.setUsedSpace(j11);
            backupSpaceNotEnoughNeedData.setGalleryNum(this.repeatCount);
            UserSpaceUtil.sendSpaceNotEnough(this.autoBackup, backupSpaceNotEnoughNeedData);
            reportSpaceNotEnough(j12, this.incrementSize);
            new SettingOperator().replace(new Settings[]{new Settings("nextbackuptime", String.valueOf(86400000L), "2")});
            StringBuilder sb2 = new StringBuilder("cloud space not enough. ");
            sb2.append("CloudTotalSpace = ");
            sb2.append(j10);
            sb2.append(" CloudUsedSpace = ");
            sb2.append(j11);
            sb2.append(" current backup size = ");
            sb2.append(this.incrementSize);
            C11839m.m70689w(TAG, sb2.toString());
            C0237v.m1661c();
            throw new C9721b(SNSCode.Status.HWID_UNLOGIN, sb2.toString(), "ICBBackup_onStart");
        }
    }

    private void processInBackupV1Record(CBSBackupRecord cBSBackupRecord) throws C9721b {
        if (cBSBackupRecord == null || TextUtils.isEmpty(cBSBackupRecord.getBackupId()) || cBSBackupRecord.getDevice() == null || TextUtils.isEmpty(cBSBackupRecord.getDevice().getDeviceId())) {
            return;
        }
        this.service.m68032p(cBSBackupRecord.getDevice().getDeviceId(), cBSBackupRecord.getDevice().getDeviceType(), cBSBackupRecord.getBackupId());
        reportDeleteSingleRecord(cBSBackupRecord.getBackupId(), false);
        C11839m.m70688i(TAG, "delete in_backup V1 record: " + cBSBackupRecord.getBackupId());
    }

    private void processInvalidBackupRecord(int i10, int i11) throws InterruptedException, C9721b {
        int iM75751H0 = C12590s0.m75751H0();
        if (i10 != 0 || i11 > iM75751H0) {
            if (!C12515a.m75110o().m75158X0(DeleteRecordsTask.class.getName())) {
                C13466f.m81073d().m81081i("isStartDeleteTask", true);
                executeDeleteRecordsTask(this.backupType, this.progressCallback, false);
            }
            waitForDeleteRecordTaskEnd();
        }
    }

    private C13029h queryTags() throws C9721b {
        int i10 = this.autoBackup ? 2 : 1;
        C13030i c13030i = new C13030i();
        C13029h c13029hM78495f = c13030i.m78495f(2);
        if (c13029hM78495f == null) {
            c13029hM78495f = c13030i.m78495f(1);
        }
        if (c13029hM78495f == null || "empty_default_id".equals(c13029hM78495f.m78465h())) {
            c13029hM78495f = createTags(i10);
            this.firstBackupType = 0;
        } else {
            this.firstBackupType = 1;
            if (this.isFullBackup || !this.inBackupingRecrdIds.contains(c13029hM78495f.m78465h())) {
                if (c13029hM78495f.m78441G() != 4) {
                    reportBackupTag(c13029hM78495f, SyncProtocol.Constant.EXPIRED, true);
                }
                new C12815f().clear();
                c13030i.m78490a(c13029hM78495f.m78442H());
                c13029hM78495f = createTags(i10);
            } else {
                c13029hM78495f.m78453S(c13029hM78495f.m78476r() + 1);
                c13029hM78495f.m78483u0(this.traceID);
                c13029hM78495f.m78470m0(0);
                c13029hM78495f.m78450P(System.currentTimeMillis());
                c13029hM78495f.m78452R("");
                if (i10 != c13029hM78495f.m78442H()) {
                    c13030i.m78490a(c13029hM78495f.m78442H());
                    c13029hM78495f.m78479s0(i10);
                }
            }
        }
        c13030i.m78496g(c13029hM78495f);
        if (TextUtils.isEmpty(this.backupId)) {
            this.backupId = c13029hM78495f.m78465h();
        }
        return c13029hM78495f;
    }

    private void recordBackupStart() {
        C12590s0.m75777N2(0L);
        C12590s0.m75773M2(new C12526j().m75428x0());
        this.mBackupRecordInfos.m78426o(this.autoBackup ? 2 : 1);
        this.mBackupRecordInfos.m78432u(System.currentTimeMillis());
        this.backupRecordInfoOperator.m78411i(this.mBackupRecordInfos);
    }

    private void recordEndTime() {
        if (this.mBackupRecordInfos.m78421j() > 0) {
            this.mBackupRecordInfos.m78430s(System.currentTimeMillis());
            long jM78422k = this.mBackupRecordInfos.m78422k();
            long jM78423l = this.mBackupRecordInfos.m78423l();
            if (jM78422k > 0 && jM78423l > 0) {
                this.mBackupRecordInfos.m78431t(1);
                this.backupRecordInfoOperator.m78403a();
            }
            this.backupRecordInfoOperator.m78411i(this.mBackupRecordInfos);
            this.backupRecordInfoOperator.m78404b(System.currentTimeMillis() - 604800000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recordIsConvertAndroidData(boolean z10) {
        if (z10) {
            this.isConvertAndroidData = z10;
        }
    }

    private void regiestCacheCheckTimer() {
        if (this.dataCacheDuration > 0) {
            CloudBackupJobManager.getInstance().registerBackupCacheScheduler(this.dataCacheDuration, this.location, this.dataLocation);
        }
    }

    private void registerThermalCallback() {
        C11979a.m72102l().m72108n(1, 1, new C11979a.c() { // from class: com.huawei.android.hicloud.cloudbackup.process.b0
            @Override // p529op.C11979a.c
            /* renamed from: a */
            public final void mo471a(int i10, int i11) {
                this.f11686a.lambda$registerThermalCallback$1(i10, i11);
            }
        });
    }

    private void registerUniScheduleCallback() {
        C11979a.m72102l().m72108n(1, 2, new C11979a.c() { // from class: com.huawei.android.hicloud.cloudbackup.process.d0
            @Override // p529op.C11979a.c
            /* renamed from: a */
            public final void mo471a(int i10, int i11) {
                this.f11693a.lambda$registerUniScheduleCallback$0(i10, i11);
            }
        });
    }

    private void reportBackupTag(C13029h c13029h, String str, boolean z10) {
        if (c13029h != null && c13029h.m78435A() == 0) {
            String str2 = (this.autoBackup || z10) ? "AutoBET" : "ManuBET";
            C11060c c11060cM66626a = C11058a.m66626a(c13029h.m78436B(), str2, C13452e.m80781L().m80971t0());
            c11060cM66626a.m66665u(c13029h.m78474q());
            c11060cM66626a.m66635A(str);
            c11060cM66626a.m66668x("1");
            c13029h.m78468j0(1);
            HashMap map = new HashMap();
            map.put("business_id", str2);
            map.put("backupBeginTime", String.valueOf(c13029h.m78440F()));
            map.put("backupEndTime", String.valueOf(c13029h.m78464f()));
            map.put("sizeNeedBackup", String.valueOf(c13029h.m78439E()));
            map.put("backupTransID", c13029h.m78444J());
            map.put("backupCnt", String.valueOf(c13029h.m78476r()));
            map.put("userType", C13452e.m80781L().m80987x0());
            map.put("gradeCode", C12590s0.m75747G0());
            C13622a.m81969o(CacheTask.getContext(), c11060cM66626a, map);
            new C13030i().m78496g(c13029h);
        }
    }

    private void reportDeleteSingleRecord(String str, boolean z10) {
        String str2 = "delete single record success, backupid: " + str;
        String strM66627b = C11058a.m66627b("02007");
        C11060c c11060cM66626a = C11058a.m66626a(strM66627b, "deleteSingleRecord", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66635A(str2);
        c11060cM66626a.m66665u("0");
        c11060cM66626a.m66668x("1");
        c11060cM66626a.m66664t("success");
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("backupTraceID", this.traceID);
        linkedHashMap.put("isSnapshotNotExist", String.valueOf(z10));
        linkedHashMap.put("userType", C13452e.m80781L().m80987x0());
        linkedHashMap.put("gradeCode", C12590s0.m75747G0());
        C13622a.m81971q(c11060cM66626a, linkedHashMap, false, true);
        linkedHashMap.put(JsbMapKeyNames.H5_USER_ID, C13452e.m80781L().m80971t0());
        linkedHashMap.put("traceID", strM66627b);
        linkedHashMap.put("errorReason", str2);
        linkedHashMap.put("code", "0");
        C13225d.m79490f1().m79603z0("delete_single_record", linkedHashMap);
    }

    private void reportFileNotExist(SnapshotBackupMeta snapshotBackupMeta) {
        C11060c c11060cM66626a = C11058a.m66626a(this.traceID, "fileNotExist", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("010_1013");
        String str = "appId = " + snapshotBackupMeta.getAppId() + ", not exist file data = " + snapshotBackupMeta.getData();
        C11839m.m70686d(TAG, "report file not exist info: " + str);
        c11060cM66626a.m66635A(str);
        C13622a.m81968n(C0213f.m1377a(), c11060cM66626a);
    }

    private void reportIsSkip(String str, String str2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String strM66627b = C11058a.m66627b("02014");
        linkedHashMap.put("backupTransID", this.traceID);
        linkedHashMap.put("appId", str);
        linkedHashMap.put("status", str2);
        C11060c c11060cM66626a = C11058a.m66626a(strM66627b, str2, C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("010_200");
        C13622a.m81971q(c11060cM66626a, linkedHashMap, false, true);
    }

    private void reportMkFileDuration(long j10) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("mkFileDuration", String.valueOf(System.currentTimeMillis() - j10));
        C11060c c11060cM66626a = C11058a.m66626a(this.traceID, "MkFileDuration", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("010_200");
        linkedHashMap.put("userType", C13452e.m80781L().m80987x0());
        linkedHashMap.put("gradeCode", C12590s0.m75747G0());
        C13622a.m81971q(c11060cM66626a, linkedHashMap, false, true);
    }

    private void reportOneModuleBackup(SnapshotBackupMeta snapshotBackupMeta, LinkedHashMap<String, String> linkedHashMap, long j10, int i10) {
        if (linkedHashMap.isEmpty()) {
            return;
        }
        String appId = snapshotBackupMeta.getAppId();
        linkedHashMap.put("appId", appId);
        linkedHashMap.put("uId", String.valueOf(i10));
        linkedHashMap.put("backupId", this.backupId);
        linkedHashMap.put("startTime", String.valueOf(j10));
        linkedHashMap.put("endTime", String.valueOf(System.currentTimeMillis()));
        linkedHashMap.put("uploadTotal", String.valueOf(this.uploadSize));
        linkedHashMap.put("moduleUploadSize", String.valueOf(this.oneModuleActualSize));
        linkedHashMap.put("scanFileSize", String.valueOf(this.fileSize));
        linkedHashMap.put("scanFileNum", String.valueOf(this.fileNum));
        if (this.thirdAppId.contains(appId)) {
            linkedHashMap.put("apkVersion", getAppVersionFromBackupMeta(appId));
        }
        C11060c c11060cM66626a = C11058a.m66626a(this.traceID, "backupTime", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("010_200");
        linkedHashMap.put("userType", C13452e.m80781L().m80987x0());
        linkedHashMap.put("gradeCode", C12590s0.m75747G0());
        C13622a.m81971q(c11060cM66626a, linkedHashMap, false, true);
        LinkedHashMap<String, String> linkedHashMap2 = new LinkedHashMap<>();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put("traceId", this.traceID);
        linkedHashMap2.put("isSupportBackup", String.valueOf(snapshotBackupMeta.isOmConfigAble()));
        linkedHashMap2.put("isSwitchOpen", String.valueOf(snapshotBackupMeta.getAppSwitch()));
        linkedHashMap2.put("status", "0");
        try {
            SnapshotBackupMeta rootNode = this.snapshotTreeService.getRootNode(snapshotBackupMeta.getAppId(), this.backupId);
            linkedHashMap2.put("status", String.valueOf(rootNode.getStatus()));
            linkedHashMap2.put("dataSize", String.valueOf(rootNode.getSize()));
            if (this.thirdAppId.contains(appId)) {
                SnapshotBackupMeta snapshotBackupMetaQueryAppApkFile = this.snapshotTreeService.queryAppApkFile(snapshotBackupMeta.getAppId(), this.backupId);
                linkedHashMap2.put("apkSize", String.valueOf(snapshotBackupMetaQueryAppApkFile.getSize()));
                linkedHashMap2.put("dataSize", String.valueOf(rootNode.getSize() - snapshotBackupMetaQueryAppApkFile.getSize()));
            }
        } catch (C9721b e10) {
            C11839m.m70689w(TAG, "reportAppDataBackup error: " + e10.getMessage());
        }
        C13225d.m79490f1().m79567R("cloudbackup_appdata_upload_status", linkedHashMap2);
        UBAAnalyze.m29947H("CKC", "cloudbackup_appdata_upload_status", linkedHashMap2);
    }

    private void reportRecordExpired() {
        if (this.inBackupV2Record != null) {
            String strM66627b = C11058a.m66627b("02010");
            C11060c c11060cM66626a = C11058a.m66626a(strM66627b, "AutoBET", C13452e.m80781L().m80971t0());
            c11060cM66626a.m66665u("001_1001");
            c11060cM66626a.m66635A(SyncProtocol.Constant.EXPIRED);
            c11060cM66626a.m66668x("1");
            HashMap map = new HashMap();
            map.put("business_id", "AutoBET");
            map.put("backupBeginTime", String.valueOf(this.inBackupV2Record.getStartTime()));
            map.put("backupEndTime", String.valueOf(this.inBackupV2Record.getEndTime()));
            map.put("backupTransID", strM66627b);
            map.put("backupId", this.inBackupV2Record.getBackupId());
            map.put("userType", C13452e.m80781L().m80987x0());
            map.put("gradeCode", C12590s0.m75747G0());
            C13622a.m81971q(c11060cM66626a, map, false, true);
        }
    }

    private void reportSpaceNotEnough(long j10, long j11) {
        LinkedHashMap<String, String> linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
        linkedHashMapM79499C.put("backupId", this.backupId);
        linkedHashMapM79499C.put("deviceId", C13452e.m80781L().m80954p());
        linkedHashMapM79499C.put("available", String.valueOf(j10));
        linkedHashMapM79499C.put("totalsize", String.valueOf(j11));
        C11839m.m70688i(TAG, "report space not enough");
        C13225d.m79490f1().m79603z0("cloudbackup_space_not_enough", linkedHashMapM79499C);
    }

    private void reportSwitch() {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(CacheTask.getContext(), "backup_report_status_sp", 0);
        if (sharedPreferencesM1382b == null) {
            C11839m.m70688i(TAG, "backupReportStatus is null");
            return;
        }
        boolean z10 = sharedPreferencesM1382b.getBoolean("registerswitch", false);
        C11839m.m70686d(TAG, "registerswitch" + z10);
        if (z10) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("backup_key");
        C12515a.m75110o().m75172d(new C3017c((ArrayList<String>) arrayList));
    }

    private void reportTaskEnd(Map<String, String> map) {
        C11839m.m70686d(TAG, "report task end");
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("traceId", this.tags.m78444J());
        linkedHashMap.put("id", this.tags.m78436B());
        linkedHashMap.put("returnCode", this.tags.m78474q());
        linkedHashMap.put("isSuccess", String.valueOf(this.isSuccess));
        if (!C0209d.m1269j1() && !C9733f.m60705z().m60720O("disableDozeOptimization")) {
            linkedHashMap.put("doze", C0224k0.m1564s() ? "1" : "0");
        }
        linkedHashMap.put("autoBackupFrequency", String.valueOf(C13467g.m81086c().m81091f()));
        linkedHashMap.put("checkType", CloudBackupConditionsUtil.getBackUpCheckType());
        if (this.isSuccess) {
            linkedHashMap.put("is_system_retread", String.valueOf(CloudBackupStateUtil.isFromSystemRetreadTask(1, this.backupId)));
        }
        linkedHashMap.putAll(map);
        C13225d.m79490f1().m79603z0("cloudbackup_task_end", linkedHashMap);
    }

    private void resetAppFiles(SnapshotBackupMetaOperator snapshotBackupMetaOperator) throws C9721b, SQLException {
        if (this.thirdAppId.contains(this.current)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(ICBUtil.RELATIVE_SDATA_PATH);
            String str = File.separator;
            sb2.append(str);
            snapshotBackupMetaOperator.resetApkIconStatus(this.current, sb2.toString(), this.current + str + this.current + ".apk", this.current + str + this.current + ".icon", ICBUtil.getBundleDir(this.current) + str + this.current + ".apk", ICBUtil.getHarmonyDir(this.current) + str + this.current + ".apk");
        }
    }

    private void restart3rdPerOM(boolean z10, String str, CloudBackupAppDataUtil cloudBackupAppDataUtil, int i10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (z10 && cloudBackupAppDataUtil != null) {
            AppInfoList appFileInfoList = cloudBackupAppDataUtil.getAppFileInfoList();
            if (appFileInfoList != null) {
                String wakeUpService = appFileInfoList.getCloudBackup().getWakeUpService();
                C11839m.m70686d(TAG, "mactch successfully on appId" + this.current + "with wakeUpService is" + wakeUpService);
                if (!TextUtils.isEmpty(wakeUpService)) {
                    wakeUpIM(str, wakeUpService, i10);
                    return;
                }
            }
            if (C14333b.m85458N().containsKey(str)) {
                String str2 = C14333b.m85458N().get(str);
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                wakeUpIM(str, str2, i10);
            }
        }
    }

    private void retryUploadWaitDeleteFile() throws InterruptedException, C9721b {
        if (isPresetModule(this.current)) {
            return;
        }
        C9721b c9721b = this.exception;
        if (c9721b != null) {
            throw c9721b;
        }
        QueryRetryUploadMeta queryRetryUploadMeta = new QueryRetryUploadMeta(this.current, this.backupId);
        CountDownLatch countDownLatch = new CountDownLatch((int) queryRetryUploadMeta.getSize());
        while (queryRetryUploadMeta.hasNext()) {
            for (SnapshotBackupMeta snapshotBackupMeta : queryRetryUploadMeta.getNext()) {
                int status = snapshotBackupMeta.getStatus();
                if (status == -4 || status == 4 || status == 5 || status == 6) {
                    C11839m.m70686d(TAG, "retryUploadWaitDeleteFile success: " + status + " ,snapshotBackupMetas: " + snapshotBackupMeta.getData());
                    countDownLatch.countDown();
                } else {
                    String localPath = SnapshotTreeUtil.getLocalPath(snapshotBackupMeta, this.location);
                    File fileM63442h = C10278a.m63442h(localPath);
                    C11839m.m70686d(TAG, "retryUploadWaitDeleteFile localPath: " + localPath + " ,file.exists(): " + fileM63442h.exists());
                    if (C11835i.m70650n(fileM63442h)) {
                        uploadFile(countDownLatch, snapshotBackupMeta);
                    } else {
                        uploadFileSuccess(countDownLatch, snapshotBackupMeta);
                    }
                }
            }
        }
        waitForCountDownLatch(countDownLatch);
    }

    private void saveBackupModuleInfo() throws InterruptedException, C9721b, SQLException {
        isCancel();
        ArrayList arrayList = new ArrayList(this.currentAppMetas.keySet());
        ArrayList<String> arrayList2 = new ArrayList();
        Set<Map.Entry<String, SnapshotBackupMeta>> setEntrySet = this.lastAppMetas.entrySet();
        if (setEntrySet.size() <= 0) {
            return;
        }
        for (Map.Entry<String, SnapshotBackupMeta> entry : setEntrySet) {
            String key = entry.getKey();
            if (!isModuleDone(entry.getValue())) {
                arrayList2.add(key);
            }
        }
        arrayList2.removeAll(arrayList);
        if (arrayList2.size() <= 0) {
            return;
        }
        for (String str : arrayList2) {
            C11839m.m70688i(TAG, "saveBackupModuleInfo delete app: " + str);
            this.snapshotTreeService.deleteRootNode(str, this.backupId);
            deleteModuleCache(str);
        }
    }

    private void saveBackupTimeInfo() {
        String strValueOf = String.valueOf(System.currentTimeMillis());
        new SettingOperator().replace(new Settings[]{new Settings("lastsuccesstime", strValueOf, "2"), new Settings("lastnotifytime", strValueOf, "2"), new Settings("nextbackuptime", "0", "2")});
        ContentValues contentValues = new ContentValues();
        contentValues.put("autobackupblowouttime", (Integer) 0);
        contentValues.put("autobackupstarttime", (Integer) 0);
        C12299b.m73937s(contentValues);
        C11839m.m70688i(TAG, "save backup cache isSuccess.");
    }

    private void saveLastSuccessTime(CBSBackupRecord cBSBackupRecord) {
        if (cBSBackupRecord == null || TextUtils.isEmpty(cBSBackupRecord.getBackupId())) {
            return;
        }
        this.lastSuccessBackupId = cBSBackupRecord.getBackupId();
        C11839m.m70688i(TAG, "get latest backup id = " + cBSBackupRecord.getBackupId());
        new SettingOperator().replace(new Settings[]{new Settings("lastsuccesstime", String.valueOf(cBSBackupRecord.getEndTime()), "2")});
    }

    private long scanAppDataSize(String str, CloudBackupAppDataUtil cloudBackupAppDataUtil) throws C9721b {
        long sdcardFileSize = new ScanAppDataUtil(str, cloudBackupAppDataUtil.getmCloudBackupInclude(), cloudBackupAppDataUtil.getmCloudBackupExclude()).getSdcardFileSize(cloudBackupAppDataUtil);
        updateVirtualCache(str, sdcardFileSize);
        return sdcardFileSize;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendProgress(int i10, int i11, long j10) {
        if (this.thirdAppId.contains(this.current) || this.virtualList.contains(this.current)) {
            if (TextUtils.isEmpty(this.currentAppName)) {
                try {
                    initApkPackageInfo();
                } catch (PackageManager.NameNotFoundException e10) {
                    C11839m.m70687e(TAG, "initApkPackageInfo error: " + e10.getMessage());
                }
            }
            updateAppDataProgress(i11, j10);
        }
        updateProgress(this.currentBackupStatus, i10, i11, this.uploadedFileSize);
    }

    private void setAppDataPreparing(boolean z10) throws C9721b {
        synchronized (APP_DATA_PREAPRE_LOCK) {
            try {
                this.isAppDataPreparing = z10;
                if (!z10 && !isAbort() && isAutoBackup() && this.isAbortByTemperatureControl) {
                    if (!ThermalChecker.isThermalControlByMain(this.thermalLevel)) {
                        throw new C9721b(1030, "thermostat level beyond setting," + ThermalChecker.getThermalInfo(this.thermalLevel));
                    }
                    this.isAbortByTemperatureControl = false;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private void setOneModuleTaskCallback(CloudBackupOneModuleTask cloudBackupOneModuleTask) {
        cloudBackupOneModuleTask.setModuleTaskCallback(new IOneModuleTaskCallback() { // from class: com.huawei.android.hicloud.cloudbackup.process.CloudBackupTask.1
            @Override // com.huawei.android.hicloud.cloudbackup.process.task.IOneModuleTaskCallback
            public void isCancel() throws InterruptedException, C9721b {
                CloudBackupTask.this.isCancel();
            }
        });
    }

    private void startNewLock(long j10) throws C9721b {
        if (this.tags == null) {
            C11839m.m70689w(TAG, "startNewLock tags is null");
            return;
        }
        int iM1685c = C0241z.m1685c(this.tags.m78480t());
        long jM78439E = this.tags.m78439E();
        long jM78443I = this.tags.m78443I();
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jQuerylastsuccesstime = new SettingOperator().querylastsuccesstime();
        long jM78440F = this.tags.m78440F();
        long j11 = jM78440F > 0 ? (jCurrentTimeMillis - jM78440F) / 1000 : 0L;
        long j12 = jQuerylastsuccesstime > 0 ? (jCurrentTimeMillis - jQuerylastsuccesstime) / 1000 : 0L;
        CBSbkFlowHead cBSbkFlowHead = new CBSbkFlowHead();
        cBSbkFlowHead.setBkByte(String.valueOf((j10 / ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS) / ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS));
        cBSbkFlowHead.setPackageByte(String.valueOf((jM78443I / ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS) / ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS));
        cBSbkFlowHead.setBkNeedSpace(String.valueOf((jM78439E / ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS) / ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS));
        cBSbkFlowHead.setFlowControlCnt(String.valueOf(iM1685c));
        cBSbkFlowHead.setBkStartDays(String.valueOf(j11));
        cBSbkFlowHead.setLastbkCompleteDays(String.valueOf(j12));
        cBSbkFlowHead.setBkmode(isAutoBackup() ? "auto" : CBSbkFlowHead.BKMODE_MANUAL);
        cBSbkFlowHead.setFullBK(this.isFullBackup);
        cBSbkFlowHead.setBackupkTimes(this.tags.m78476r());
        cBSbkFlowHead.setChargeMode(CBLockAndFlowControlManager.getChargeMode());
        cBSbkFlowHead.setNetwork(C0209d.m1228Z(C0209d.m1225Y(C0213f.m1377a())));
        CBLockAndFlowControlManager cBLockAndFlowControlManager = new CBLockAndFlowControlManager(this.progressCallback, cBSbkFlowHead, new CBSLockAndFlowControlReq(this.deviceId, this.deviceType, this.backupId, this.backupType), this.service, this.tags);
        this.timer = cBLockAndFlowControlManager;
        cBLockAndFlowControlManager.setBackupId(this.backupId);
        keepLock();
        cancelOldLockTimer();
    }

    private void syncHandleFileNotExist(CountDownLatch countDownLatch, SnapshotBackupMeta snapshotBackupMeta, String str) throws C9721b {
        synchronized (ICBBaseTask.LOCK) {
            handleFileNotExist(countDownLatch, snapshotBackupMeta);
        }
    }

    private void syncLock(CountDownLatch countDownLatch) throws InterruptedException, C9721b {
        C11839m.m70688i(TAG, "syncLock start lock");
        while (countDownLatch.getCount() > 0 && this.exception == null) {
            isCancel();
            try {
                if (countDownLatch.await(400L, TimeUnit.MILLISECONDS)) {
                    break;
                }
            } catch (InterruptedException e10) {
                C11839m.m70689w(TAG, "downloadFilesMulti lock wait error." + e10);
                throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "downloadFilesMulti lock wait error.");
            }
        }
        C11839m.m70688i(TAG, "syncLock end lock");
        C9721b c9721b = this.exception;
        if (c9721b != null) {
            throw c9721b;
        }
    }

    private void unRegiestCacheCheckTimer() {
        CloudBackupJobManager.getInstance().unRegisterBackupCacheScheduler();
    }

    private void update3rdModuleCache(String str, long j10) throws C9721b {
        BackupOptionItem backupOptionItemQueryItem = TransferedUtil.queryItem(str, false);
        if (backupOptionItemQueryItem == null) {
            backupOptionItemQueryItem = generateModuleItem(str, "thirdAppData", this.switch3rdDefault);
        }
        String strM25632b = NewHiSyncUtil.m25632b(str);
        if (TextUtils.isEmpty(strM25632b)) {
            strM25632b = str;
        }
        backupOptionItemQueryItem.setAppName(strM25632b);
        backupOptionItemQueryItem.setDataBytes(j10);
        backupOptionItemQueryItem.setIsDataEnable(2);
        C12590s0.m75915w(backupOptionItemQueryItem, false, this.bakId);
        this.itemOperator.m78382Q(backupOptionItemQueryItem);
        initModuleStatus(str, 1);
    }

    private void updateAppDataProgress(int i10, long j10) {
        if (i10 < 4) {
            return;
        }
        this.uploadedFileSize += j10;
    }

    private void updateBackupRecordStatus(int i10, String str) throws Throwable {
        try {
            if (!this.isFullBackup) {
                this.service.m68015V(this.backupId, this.deviceId, this.deviceType, this.backupType, i10, str);
            } else {
                this.clientActionList.remove("2");
                this.service.m68016W(this.backupId, this.deviceId, this.deviceType, this.backupType, 1, this.clientActionList, i10, str);
            }
        } catch (C9721b e10) {
            int iM60659c = e10.m60659c();
            if (iM60659c == 3109) {
                this.snapshotTreeService.deleteSnapshotMetaCache(this.backupId);
                C11839m.m70688i(TAG, "updateBackupRecordStatus cbs not exists, clear snapshot cache.");
            } else if (iM60659c == 3110 && this.inBackupingRecrdIds.contains(this.backupId)) {
                this.service.m68015V(this.backupId, this.deviceId, this.deviceType, this.backupType, 7, str);
                C13466f.m81073d().m81081i("isStartDeleteTask", true);
            }
            throw e10;
        }
    }

    private void updateDirMetaType(List<SnapshotBackupMeta> list) throws C9721b {
        new SnapshotBackupMetaOperator(this.backupId).batchReplace(list);
    }

    private void updateModuleCache(String str, long j10, long j11, boolean z10) throws C9721b {
        BackupOptionItem backupOptionItemQueryItem = TransferedUtil.queryItem(str, false);
        if (backupOptionItemQueryItem == null) {
            backupOptionItemQueryItem = generateModuleItem(str, TransferedUtil.getItemParent(str), z10);
        }
        backupOptionItemQueryItem.setAppName(C2783d.m16079E(CacheTask.getContext(), str));
        backupOptionItemQueryItem.setDataBytes(j10);
        backupOptionItemQueryItem.setItemTotal((int) j11);
        backupOptionItemQueryItem.setIsDataEnable(2);
        C12590s0.m75915w(backupOptionItemQueryItem, false, this.bakId);
        this.itemOperator.m78382Q(backupOptionItemQueryItem);
    }

    private void updateProgress(CloudBackupStatus cloudBackupStatus, int i10, int i11, long j10) {
        cloudBackupStatus.mo29310W(i10).mo29325f0(i11);
        if (j10 > cloudBackupStatus.m29868a()) {
            cloudBackupStatus.mo29308V(j10);
        }
        C11963c.m71970y(cloudBackupStatus, "auto");
        try {
            new C12815f().m76934m(cloudBackupStatus);
        } catch (C9721b e10) {
            C11839m.m70689w(TAG, "updateProgress replace error: " + e10.getMessage());
        }
    }

    private void updateSnapshot(SnapshotBackupMeta snapshotBackupMeta) throws C9721b, SQLException {
        boolean zEquals = HNConstants.DataType.MEDIA.equals(this.current);
        SnapshotBackupMetaOperator snapshotBackupMetaOperator = new SnapshotBackupMetaOperator(this.backupId);
        long jQueryMetasSizeByAppId = snapshotBackupMetaOperator.queryMetasSizeByAppId(this.current);
        if (this.thirdAppId.contains(this.current) || "music".equals(this.current) || zEquals) {
            snapshotBackupMeta.setCount(jQueryMetasSizeByAppId);
        }
        if (zEquals) {
            snapshotBackupMeta.setCount(snapshotBackupMeta.getCount() - 1);
        }
        snapshotBackupMeta.setSize(snapshotBackupMetaOperator.queryAllSizeSumByAppId(this.current));
        if ((snapshotBackupMeta.getSize() > 0 && jQueryMetasSizeByAppId > 0) || !this.virtualList.contains(this.current)) {
            this.snapshotTreeService.updateModuleDateCreate(this.current, System.currentTimeMillis(), this.backupId);
            snapshotBackupMetaOperator.updateRootNodeCountAndSize(this.current, snapshotBackupMeta.getCount(), snapshotBackupMeta.getSize());
            this.snapshotTreeService.updateRootNodeStatus(this.current, 4L, this.backupId);
        } else {
            C11839m.m70688i(TAG, "updateSnapshot node no files delete app: " + this.current);
            this.snapshotTreeService.deleteRootNode(this.current, this.backupId);
        }
    }

    private void updateSnapshotMetaCache(boolean z10) throws C9721b {
        if (z10) {
            C11839m.m70688i(TAG, "updateSnapshotMetaCache is full backup, return.");
            return;
        }
        if (TextUtils.isEmpty(this.lastSuccessBackupId)) {
            return;
        }
        C11839m.m70688i(TAG, "update cache,cur backup id = " + this.backupId + ",last backupid =  " + this.lastSuccessBackupId);
        try {
            this.snapshotTreeService.updateCache(this.lastSuccessBackupId, this.backupId, this.current);
        } catch (C9721b e10) {
            C11839m.m70687e(TAG, "updateSnapshotMetaCache error: " + e10.toString());
        }
        C11839m.m70688i(TAG, "update leaf nodes end.");
    }

    private void updateStatus(CloudBackupStatus cloudBackupStatus, int i10, int i11) throws C9721b {
        cloudBackupStatus.mo29338z0(i10).mo29289A0(i11);
        new C12815f().m76934m(cloudBackupStatus);
        C11963c.m71970y(cloudBackupStatus, "auto");
    }

    private void updateVirtualCache(String str, long j10) throws C9721b {
        BackupOptionItem backupOptionItemQueryItem = TransferedUtil.queryItem(str, false);
        if (backupOptionItemQueryItem == null) {
            backupOptionItemQueryItem = generateModuleItem(str, "virtualApp", true);
        }
        backupOptionItemQueryItem.setAppName(CloudBackupLanguageUtil.getVirtualName(str));
        backupOptionItemQueryItem.setDataBytes(j10);
        backupOptionItemQueryItem.setIsDataEnable(2);
        C12590s0.m75915w(backupOptionItemQueryItem, false, this.bakId);
        this.itemOperator.m78382Q(backupOptionItemQueryItem);
    }

    private void uploadFile(final CountDownLatch countDownLatch, final SnapshotBackupMeta snapshotBackupMeta) throws InterruptedException, C9721b {
        UploadTask uploadTask = new UploadTask(new ICBTaskCallback() { // from class: com.huawei.android.hicloud.cloudbackup.process.CloudBackupTask.3
            @Override // com.huawei.android.hicloud.cloudbackup.process.task.ICBTaskCallback
            public void onReturnSize(boolean z10) {
                CloudBackupTask.access$614(CloudBackupTask.this, snapshotBackupMeta.getSize());
                CloudBackupTask.access$714(CloudBackupTask.this, snapshotBackupMeta.getSize());
                CloudBackupTask.this.recordIsConvertAndroidData(z10);
            }

            @Override // com.huawei.android.hicloud.cloudbackup.process.task.ICBTaskCallback
            public void onTaskAbort(Object obj) {
                synchronized (ICBBaseTask.LOCK) {
                    try {
                        C11839m.m70688i(CloudBackupTask.TAG, "onTaskAbort successNum = " + CloudBackupTask.this.successNum + ",size = " + CloudBackupTask.this.uploadSize + ". module = " + CloudBackupTask.this.current);
                        CloudBackupTask cloudBackupTask = CloudBackupTask.this;
                        cloudBackupTask.isSuccess = false;
                        if (cloudBackupTask.exception == null) {
                            cloudBackupTask.exception = (C9721b) obj;
                        }
                        countDownLatch.countDown();
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }

            @Override // com.huawei.android.hicloud.cloudbackup.process.task.ICBTaskCallback
            public void onTaskBegin(Object obj) {
                synchronized (ICBBaseTask.LOCK) {
                    try {
                        C11839m.m70686d(CloudBackupTask.TAG, "onBegin successNum = " + CloudBackupTask.this.successNum + ",size = " + CloudBackupTask.this.uploadSize + ". module = " + CloudBackupTask.this.current);
                        int i10 = HNConstants.DataType.MEDIA.equals(CloudBackupTask.this.current) ? CloudBackupTask.this.uploadSize - 1 : CloudBackupTask.this.uploadSize;
                        int i11 = CloudBackupTask.this.successNum > i10 ? i10 : CloudBackupTask.this.successNum;
                        if (!CloudBackupTask.this.virtualList.contains(CloudBackupTask.this.current) || i10 >= 0) {
                            CloudBackupTask.this.sendProgress(i11, i10, 0L);
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }

            @Override // com.huawei.android.hicloud.cloudbackup.process.task.ICBTaskCallback
            public void onTaskFail() {
                synchronized (ICBBaseTask.LOCK) {
                    try {
                        CloudBackupTask.this.handleFileNotExist(countDownLatch, snapshotBackupMeta);
                    } catch (C9721b e10) {
                        CloudBackupTask cloudBackupTask = CloudBackupTask.this;
                        cloudBackupTask.isSuccess = false;
                        if (cloudBackupTask.exception == null) {
                            cloudBackupTask.exception = e10;
                        }
                        countDownLatch.countDown();
                    }
                }
            }

            @Override // com.huawei.android.hicloud.cloudbackup.process.task.ICBTaskCallback
            public void onTaskSuccess() {
                synchronized (ICBBaseTask.LOCK) {
                    CloudBackupTask.this.uploadFileSuccess(countDownLatch, snapshotBackupMeta);
                }
            }
        }, snapshotBackupMeta, this.progressCallback, this.traceID, this.location, this.serverPath, this.current, this.backupId, this.lastSuccessBackupId, this.isFullBackup);
        CloudBackupTaskManager cloudBackupTaskManager = CloudBackupTaskManager.getInstance();
        ProgressCallback progressCallback = this.progressCallback;
        Objects.requireNonNull(progressCallback);
        cloudBackupTaskManager.await(new C2510a0(progressCallback));
        isCancel();
        CloudBackupTaskManager.getInstance().addFileTask(this.current, uploadTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadFileSuccess(CountDownLatch countDownLatch, SnapshotBackupMeta snapshotBackupMeta) {
        this.successNum++;
        C11839m.m70688i(TAG, "onTaskSuccess successNum = " + this.successNum + ",size = " + this.uploadSize + ". module = " + this.current + ", isSuccess = " + this.isSuccess);
        if (!HNConstants.DataType.MEDIA.equals(this.current) || this.uploadSize != 1) {
            int i10 = HNConstants.DataType.MEDIA.equals(this.current) ? this.uploadSize - 1 : this.uploadSize;
            int i11 = this.successNum;
            if (i11 > i10) {
                i11 = i10;
            }
            if (!this.virtualList.contains(this.current) || i10 >= 0) {
                sendProgress(i11, i10, snapshotBackupMeta.getSize());
            }
        }
        countDownLatch.countDown();
    }

    private String uploadSnapshotDatabase() throws InterruptedException, C9721b {
        this.snapshotTreeService.closeSnapshotDB(this.backupId);
        String dBName = this.snapshotTreeService.getDBName(this.backupId);
        File databasePath = C0213f.m1378b().getDatabasePath(dBName);
        File fileM63442h = C10278a.m63442h((this.location + File.separator) + dBName);
        if (!C11835i.m70640d(databasePath, fileM63442h)) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "uploadSnapshotDatabase copy snapshot database error.");
        }
        isCancel();
        C12478a c12478a = new C12478a(EnumC12999a.CLOUD_BACKUP, this.traceID);
        UploadReq uploadReq = new UploadReq();
        uploadReq.setFile(fileM63442h);
        uploadReq.setServer(this.serverPath + dBName);
        uploadReq.setCallback(this.progressCallback);
        c12478a.m74908d(uploadReq);
        C11839m.m70688i(TAG, "uploadSnapshotDatabase snapshot database file end.");
        return this.serverPath + dBName;
    }

    private void uploadTarFile(int i10, long j10, String str, File file, CountDownLatch countDownLatch) throws InterruptedException, C9721b {
        TarFileUploadTask tarFileUploadTask = new TarFileUploadTask(new ICBTarTaskCallback(i10, j10, countDownLatch, file) { // from class: com.huawei.android.hicloud.cloudbackup.process.CloudBackupTask.2
            private int mTarFileCount;
            private long mTarTotalFileSize;
            final /* synthetic */ CountDownLatch val$downLatch;
            final /* synthetic */ File val$tarFile;
            final /* synthetic */ int val$tarFileCount;
            final /* synthetic */ long val$tarTotalFileSize;

            {
                this.val$tarFileCount = i10;
                this.val$tarTotalFileSize = j10;
                this.val$downLatch = countDownLatch;
                this.val$tarFile = file;
                this.mTarFileCount = i10;
                this.mTarTotalFileSize = j10;
            }

            private void taskAbort(C9721b c9721b) {
                CloudBackupTask cloudBackupTask = CloudBackupTask.this;
                cloudBackupTask.isSuccess = false;
                if (cloudBackupTask.exception == null) {
                    cloudBackupTask.exception = c9721b;
                }
                int i11 = this.mTarFileCount;
                if (i11 <= 0) {
                    return;
                }
                cloudBackupTask.countDown(i11, this.val$downLatch);
            }

            @Override // com.huawei.android.hicloud.cloudbackup.process.task.ICBTarTaskCallback
            public void onOriginFileFail(SnapshotBackupMeta snapshotBackupMeta) throws C9721b {
                synchronized (ICBBaseTask.LOCK) {
                    CloudBackupTask.this.handleFileNotExist(this.val$downLatch, snapshotBackupMeta);
                    this.mTarFileCount--;
                    this.mTarTotalFileSize -= snapshotBackupMeta.getSize();
                }
            }

            @Override // com.huawei.android.hicloud.cloudbackup.process.task.ICBTaskCallback
            public void onReturnSize(boolean z10) {
                CloudBackupTask.access$614(CloudBackupTask.this, this.val$tarFile.length());
                CloudBackupTask.access$714(CloudBackupTask.this, this.val$tarFile.length());
            }

            @Override // com.huawei.android.hicloud.cloudbackup.process.task.ICBTaskCallback
            public void onTaskAbort(Object obj) {
                synchronized (ICBBaseTask.LOCK) {
                    C11839m.m70688i(CloudBackupTask.TAG, "onTaskAbort successNum = " + CloudBackupTask.this.successNum + ",size = " + CloudBackupTask.this.uploadSize + ". module = " + CloudBackupTask.this.current);
                    taskAbort((C9721b) obj);
                }
            }

            @Override // com.huawei.android.hicloud.cloudbackup.process.task.ICBTaskCallback
            public void onTaskBegin(Object obj) {
                synchronized (ICBBaseTask.LOCK) {
                    try {
                        C11839m.m70686d(CloudBackupTask.TAG, "onBegin successNum = " + CloudBackupTask.this.successNum + ",size = " + CloudBackupTask.this.uploadSize + ". module = " + CloudBackupTask.this.current);
                        int i11 = CloudBackupTask.this.uploadSize;
                        int i12 = CloudBackupTask.this.successNum > i11 ? i11 : CloudBackupTask.this.successNum;
                        if (!CloudBackupTask.this.virtualList.contains(CloudBackupTask.this.current) || i11 >= 0) {
                            CloudBackupTask.this.sendProgress(i12, i11, 0L);
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }

            @Override // com.huawei.android.hicloud.cloudbackup.process.task.ICBTaskCallback
            public void onTaskFail() {
                synchronized (ICBBaseTask.LOCK) {
                    try {
                        int i11 = this.mTarFileCount;
                        if (i11 <= 0) {
                            CloudBackupTask.access$110(CloudBackupTask.this);
                        } else {
                            CloudBackupTask.access$120(CloudBackupTask.this, i11);
                            CloudBackupTask.this.countDown(i11, this.val$downLatch);
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }

            @Override // com.huawei.android.hicloud.cloudbackup.process.task.ICBTaskCallback
            public void onTaskSuccess() {
                synchronized (ICBBaseTask.LOCK) {
                    try {
                        int i11 = this.mTarFileCount;
                        if (i11 <= 0) {
                            CloudBackupTask.access$008(CloudBackupTask.this);
                        } else {
                            CloudBackupTask.access$012(CloudBackupTask.this, i11);
                            CloudBackupTask.this.countDown(i11, this.val$downLatch);
                        }
                        C11839m.m70688i(CloudBackupTask.TAG, "onTaskSuccess successNum = " + CloudBackupTask.this.successNum + ",size = " + CloudBackupTask.this.uploadSize + ". module = " + CloudBackupTask.this.current + ", isSuccess = " + CloudBackupTask.this.isSuccess);
                        int i12 = CloudBackupTask.this.uploadSize;
                        int i13 = CloudBackupTask.this.successNum > i12 ? i12 : CloudBackupTask.this.successNum;
                        if (!CloudBackupTask.this.virtualList.contains(CloudBackupTask.this.current) || i12 >= 0) {
                            CloudBackupTask.this.sendProgress(i13, i12, this.mTarTotalFileSize);
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
        }, file, str, this.progressCallback, this.traceID, this.serverPath, this.current, this.backupId, this.location);
        CloudBackupTaskManager cloudBackupTaskManager = CloudBackupTaskManager.getInstance();
        ProgressCallback progressCallback = this.progressCallback;
        Objects.requireNonNull(progressCallback);
        cloudBackupTaskManager.await(new C2510a0(progressCallback));
        isCancel();
        CloudBackupTaskManager.getInstance().addFileTask(this.current, tarFileUploadTask);
    }

    private void verifySnapshotMetaCache() throws C9721b, SQLException {
        C11839m.m70688i(TAG, "verifySnapshotMetaCache begin.");
        String strCreateSnapshotBackupMetaTable = this.snapshotTreeService.createSnapshotBackupMetaTable(this.backupId);
        this.snapshotTreeService.setEmuiVersionForSnapshot(this.backupId, C0209d.m1186L());
        boolean z10 = true;
        if (TextUtils.isEmpty(this.lastSuccessBackupId)) {
            if (TextUtils.isEmpty(strCreateSnapshotBackupMetaTable)) {
                this.snapshotTreeService.deleteSnapshotDBWithId(this.backupId);
                C11839m.m70688i(TAG, "delete record except : " + this.backupId);
            } else {
                C11839m.m70688i(TAG, "there is no backuprecord.");
                this.snapshotTreeService.deleteSnapshotDB();
                deleteBackupCaheFiles();
                z10 = false;
            }
        } else if (!this.lastSuccessBackupId.equalsIgnoreCase(strCreateSnapshotBackupMetaTable)) {
            this.snapshotTreeService.deleteSnapshotMetaCache(this.backupId);
            deleteBackupCaheFiles();
            BackupRecordMeta backupRecordMeta = new BackupRecordMeta();
            backupRecordMeta.setCurrentRecordId(this.backupId);
            backupRecordMeta.setRecordId(this.lastSuccessBackupId);
            backupRecordMeta.setDate(System.currentTimeMillis());
            backupRecordMeta.setEmuiVersion(C0209d.m1186L());
            backupRecordMeta.setVersion(1L);
            this.snapshotTreeService.setLastSuccessBackupIdForSnapshot(this.backupId, backupRecordMeta);
            C11839m.m70688i(TAG, "save last successful backup record info , last record id = " + backupRecordMeta.getRecordId());
            z10 = false;
        }
        if (this.isFullBackup) {
            this.snapshotTreeService.deleteSnapshotMetaCache(this.backupId);
            deleteBackupCaheFiles();
            C11839m.m70688i(TAG, "verifySnapshotMetaCache is full backup, clear snapshot cache.");
        } else {
            if (!z10) {
                C11839m.m70688i(TAG, "verifySnapshotMetaCache is invalid, clear snapshot cache.");
                return;
            }
            try {
                for (SnapshotBackupMeta snapshotBackupMeta : this.snapshotTreeService.getRoots(this.backupId)) {
                    this.lastAppMetas.put(snapshotBackupMeta.getData(), snapshotBackupMeta);
                }
            } catch (C9721b unused) {
                C11839m.m70688i(TAG, "there is no snapshot cache.");
            }
            C11839m.m70688i(TAG, "verifySnapshotMetaCache end.");
        }
    }

    private void waitForDeleteRecordTaskEnd() throws InterruptedException, C9721b {
        isCancel();
        boolean z10 = this.exception != null;
        boolean zIsAbort = isAbort();
        while (C12515a.m75110o().m75158X0(DeleteRecordsTask.class.getName()) && !zIsAbort && !z10) {
            SystemClock.sleep(500L);
            zIsAbort = isAbort();
            z10 = this.exception != null;
        }
        isCancel();
    }

    private void wakeUpIM(String str, String str2, int i10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            ComponentName componentName = new ComponentName(str, str2);
            Intent intent = new Intent();
            intent.setComponent(componentName);
            C11839m.m70688i(TAG, "restart service: " + str2);
            C11839m.m70688i(TAG, "wakeUpIM appId = " + str + " , uid = " + i10);
            Class.forName("android.content.Context").getMethod("startServiceAsUser", Intent.class, UserHandle.class).invoke(C0213f.m1377a(), intent, AppDataSizeUtil.getUserHandle(i10));
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "restart service: " + str2 + ", error: " + e10.getMessage());
        }
    }

    @Override // com.huawei.android.hicloud.cloudbackup.process.CacheTask
    public boolean condition() {
        return this.autoBackup ? C0209d.m1254f2(CacheTask.getContext()) : C10782d.m65634a().m65642i(CacheTask.getContext());
    }

    @Override // com.huawei.android.hicloud.cloudbackup.process.CacheTask
    public boolean extraCondition() {
        return isAppDataPreparing();
    }

    public String getBackupId() {
        return this.backupId;
    }

    @Override // com.huawei.android.hicloud.cloudbackup.process.ICBBaseTask
    public String getLocation() {
        return C10279b.m63452a(C10278a.m63442h(CacheTask.getContext().getFilesDir() + "/cloudbackup"));
    }

    public boolean isAppDataPreparing() {
        boolean z10;
        synchronized (APP_DATA_PREAPRE_LOCK) {
            z10 = this.isAppDataPreparing;
        }
        return z10;
    }

    public boolean isAutoBackup() {
        return this.autoBackup;
    }

    public boolean isNeedUpload(SnapshotBackupMeta snapshotBackupMeta) {
        return ICBUtil.isNeedUpload(snapshotBackupMeta, this.cacheDuration);
    }

    public void keepLock() {
        CBLockAndFlowControlManager cBLockAndFlowControlManager = this.timer;
        if (cBLockAndFlowControlManager != null) {
            try {
                cBLockAndFlowControlManager.keepLock(0, this.powerKitApplyType);
            } catch (C9721b e10) {
                setException(e10);
            }
        }
    }

    @Override // com.huawei.android.hicloud.cloudbackup.process.ICBBaseTask
    public boolean noAbortCondition(int i10) {
        if (i10 == 1002) {
            return isAppDataPreparing();
        }
        if (i10 != 1030) {
            return false;
        }
        this.isAbortByTemperatureControl = true;
        return isAppDataPreparing();
    }

    @Override // com.huawei.android.hicloud.cloudbackup.process.ICBBaseTask
    public void onClose() throws SQLException {
        C11839m.m70688i(TAG, "onClose start.");
        if (!TextUtils.isEmpty(this.lastSuccessBackupId)) {
            this.snapshotTreeService.closeSnapshotDB(this.lastSuccessBackupId);
        }
        CloudBackupTaskManager.getInstance().shutdownFileExecutor();
        CloudBackupTaskManager.getInstance().shutdownPmsExecutor();
        this.mProgress = C11965e.m71974f().m71979h();
        C11965e.m71974f().m71987p();
        C13216j.m79421f();
        Message message = new Message();
        message.what = 32999;
        message.arg1 = 0;
        SettingOperator settingOperator = new SettingOperator();
        if (this.isSuccess) {
            this.mBackupRecordInfos.m78425n(1);
            C10152c.m63218b(CacheTask.getContext());
            clearSuccessData();
            regiestCacheCheckTimer();
            exeBackUpSuccessNotify();
            message.arg1 = 3;
            Bundle bundle = new Bundle();
            bundle.putLong("cloudbackup_total_size", this.totalBackupSize);
            bundle.putLong("cloudbackup_last_success_time", settingOperator.querylastsuccesstime());
            if (this.tags != null) {
                this.tags.m78473p0(this.totalBackupSize);
            }
            C14317j.m85300d().m85317r(this.totalBackupSize);
            message.obj = bundle;
            C13148e.m79057f(CacheTask.getContext());
        } else {
            if (this.manualAbort) {
                message.arg1 = 0;
            } else {
                if (!condition()) {
                    setErrCode(1002);
                }
                message.arg1 = 1;
                message.arg2 = getErrCode();
            }
            settingOperator.replace(new Settings[]{new Settings("lastfailedtime", String.valueOf(System.currentTimeMillis()), "2")});
            message.obj = Long.valueOf(settingOperator.querylastsuccesstime());
            ContentValues contentValues = new ContentValues();
            contentValues.put("backupFailedErrorCode", String.valueOf(getErrCode()));
            C12299b.m73929k(contentValues, "backupFailedErrorCode");
        }
        callback(message, 100L);
        recordEndTime();
        C12585q1.m75693c();
    }

    @Override // com.huawei.android.hicloud.cloudbackup.process.ICBBaseTask
    public void onOperate() throws Throwable {
        C14317j.m85300d().m85318s(1, "V2");
        C11965e.m71974f().m71981j(false, this.powerKitApplyType, new ConcurrentLinkedDeque(), "auto", new C13026e());
        C11839m.m70688i(TAG, "onOperate start.");
        checkSnapshotMidStatus(null);
        while (!this.queue.isEmpty()) {
            isCancel();
            SnapshotBackupMeta snapshotBackupMetaPoll = this.queue.poll();
            isCancel();
            doOneModuleBackup(snapshotBackupMetaPoll);
            isCancel();
            doForegroundModules();
        }
        this.moduleBlacks.clear();
        this.lastAppMetas.clear();
        C11839m.m70688i(TAG, "onOperate end.");
    }

    @Override // com.huawei.android.hicloud.cloudbackup.process.ICBBaseTask
    public void onPostFix() throws Throwable {
        C11839m.m70688i(TAG, "onPostFix start.");
        C14317j.m85300d().m85303b(1);
        isCancel();
        String strUploadSnapshotDatabase = uploadSnapshotDatabase();
        isCancel();
        updateBackupRecordStatus(1, strUploadSnapshotDatabase);
        long jCurrentTimeMillis = System.currentTimeMillis();
        C11839m.m70688i(TAG, "make files start.");
        isCancel();
        final ArrayList arrayList = new ArrayList();
        int iM75392g0 = this.backupConfigOperator.m75392g0();
        try {
            List<SnapshotBackupMeta> roots = this.snapshotTreeService.getRoots(this.backupId);
            final CountDownLatch countDownLatch = new CountDownLatch(roots.size());
            for (SnapshotBackupMeta snapshotBackupMeta : roots) {
                String data = snapshotBackupMeta.getData();
                if (this.filterModule.keySet().contains(data)) {
                    countDownLatch.countDown();
                } else if (new SnapshotBackupMetaOperator(this.backupId).queryMetasSizeByAppId(data) <= 0) {
                    C11839m.m70689w(TAG, "appId = " + data + " metas is empty.");
                    countDownLatch.countDown();
                } else {
                    long jQueryStatusMetaCount = this.snapshotTreeService.queryStatusMetaCount(data, 0, this.backupId);
                    if (jQueryStatusMetaCount > 0) {
                        String str = "not all data upload isSuccess. appId = " + data + " file count = " + jQueryStatusMetaCount;
                        this.snapshotTreeService.deleteRootNode(data, this.backupId);
                        countDownLatch.countDown();
                        throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, str, "initAppInfo");
                    }
                    int i10 = iM75392g0;
                    CloudBackupCreateTask cloudBackupCreateTask = new CloudBackupCreateTask(snapshotBackupMeta, this.backupId, this.traceID, iM75392g0, this.virtualList.contains(data), new CloudBackupCreateCallback() { // from class: com.huawei.android.hicloud.cloudbackup.process.CloudBackupTask.4
                        @Override // com.huawei.android.hicloud.cloudbackup.process.task.CloudBackupCreateCallback
                        public void onCreateEnd() {
                            countDownLatch.countDown();
                        }

                        @Override // com.huawei.android.hicloud.cloudbackup.process.task.CloudBackupCreateCallback
                        public void onCreateError(C9721b c9721b) {
                            CloudBackupTask cloudBackupTask = CloudBackupTask.this;
                            if (cloudBackupTask.exception == null) {
                                cloudBackupTask.exception = c9721b;
                                if (3001 == c9721b.m60659c()) {
                                    try {
                                        CloudBackupTask.this.tags.m78456V(String.valueOf(new SnapshotBackupMetaOperator(CloudBackupTask.this.backupId).queryNotMkfileSizeExcludeApk()));
                                        C0237v.m1661c();
                                    } catch (C9721b unused) {
                                        C11839m.m70687e(CloudBackupTask.TAG, "query not mkfile size error: " + c9721b.getMessage());
                                    }
                                }
                            }
                        }

                        @Override // com.huawei.android.hicloud.cloudbackup.process.task.CloudBackupCreateCallback
                        public void onCreateSuccess(CBSAppInfo cBSAppInfo) {
                            synchronized (arrayList) {
                                arrayList.add(cBSAppInfo);
                            }
                        }
                    });
                    CloudBackupTaskManager.getInstance().awaitTask(this);
                    C9721b c9721b = this.exception;
                    if (c9721b != null) {
                        throw c9721b;
                    }
                    isCancel();
                    CloudBackupTaskManager.getInstance().addCreateTask(data, cloudBackupCreateTask);
                    iM75392g0 = i10;
                }
            }
            syncLock(countDownLatch);
            CloudBackupTaskManager.getInstance().shutdownCreateExecutor();
            CloudBackupCreateManager.getInstance().shutdownExecutor();
            isCancel();
            reportMkFileDuration(jCurrentTimeMillis);
            C11839m.m70688i(TAG, "make files end.");
            List<SnapshotBackupMeta> listQueryUnsuccessfulNodes = this.snapshotTreeService.queryUnsuccessfulNodes(this.backupId);
            if (listQueryUnsuccessfulNodes.size() > 0) {
                defaultRootNodesStatus(listQueryUnsuccessfulNodes);
                throw new C9721b(1018, "make file not all success. appId = " + listQueryUnsuccessfulNodes.get(0).getAppId() + " ,size: " + listQueryUnsuccessfulNodes.size());
            }
            isCancel();
            this.snapshotTreeService.updateBackupRecordMetaSuccessful(this.backupId);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.totalBackupSize += ((CBSAppInfo) it.next()).getSize();
            }
            String strUploadSnapshotDatabase2 = uploadSnapshotDatabase();
            isCancel();
            CBSCreateAppBackupRecordReq cBSCreateAppBackupRecordReq = new CBSCreateAppBackupRecordReq(this.backupId, this.deviceId, this.deviceType);
            cBSCreateAppBackupRecordReq.setAppIdInfos(arrayList);
            this.service.m68027k(cBSCreateAppBackupRecordReq);
            C11839m.m70688i(TAG, "create app backup records end.");
            isCancel();
            updateBackupRecordStatus(0, strUploadSnapshotDatabase2);
            C11839m.m70688i(TAG, "update backup records end.");
            saveBackupTimeInfo();
            C11839m.m70688i(TAG, "onPostFix end.");
        } catch (Throwable th2) {
            CloudBackupTaskManager.getInstance().shutdownCreateExecutor();
            CloudBackupCreateManager.getInstance().shutdownExecutor();
            throw th2;
        }
    }

    @Override // com.huawei.android.hicloud.cloudbackup.process.ICBBaseTask
    public void onPrepare() throws Throwable {
        initOmConfig();
        recordBackupStart();
        clearBackupIncompleteTip();
        C11839m.m70688i(TAG, "onPrepare start");
        unRegiestCacheCheckTimer();
        CBLockAndFlowControlManager.cancelAlarm(CacheTask.getContext());
        if (!this.autoBackup) {
            openWakeLock();
        }
        isCancel();
        aboutTimesRequest();
        List<CBSBackupRecord> allRecordsFromServer = getAllRecordsFromServer();
        CBSBackupRecord cBSBackupRecordPrepareForInitBackup = prepareForInitBackup(allRecordsFromServer);
        checkInBackupRecordValid();
        isCancel();
        initModuleSwitchInfo();
        initSwitchs();
        lock();
        this.isFullBackup = getFullBackupInfo();
        C11839m.m70688i(TAG, "isFullBackup" + this.isFullBackup);
        this.tags = queryTags();
        C14317j.m85300d().m85312m(this.tags);
        this.mBackupRecordInfos.m78424m(this.backupId);
        if (this.isFullBackup) {
            this.firstBackupType = 0;
            this.lastSuccessBackupId = "";
            for (String str : this.inBackupingRecrdIds) {
                C11839m.m70688i(TAG, "isFullBackup, delete in backuping record: " + str);
                this.service.m68015V(str, this.deviceId, this.deviceType, this.backupType, 7, this.serverPath + this.snapshotTreeService.getDBName(str));
            }
            cBSBackupRecordPrepareForInitBackup = null;
            this.inBackupV2Record = null;
            this.inBackupingRecrdIds.clear();
        }
        if (cBSBackupRecordPrepareForInitBackup != null) {
            downloadLastSuccessRecord(cBSBackupRecordPrepareForInitBackup, allRecordsFromServer);
            SnapshotTreeManagementService.getInstance().databaseRepaired(this.lastSuccessBackupId);
        }
        SnapshotTreeManagementService.getInstance().databaseUpdate(this.backupId);
        CBSInitParam cBSInitParamInitParams = initParams();
        isCancel();
        verifySnapshotMetaCache();
        isCancel();
        this.defaultModules.removeAll(this.appBlackList);
        this.defaultModules.add("app");
        this.bakId = C12590s0.m75894q2();
        initSystemModuleSize();
        init3rdAppModuleList();
        boolean z10 = System.currentTimeMillis() - C13465e.m81052f().m81057e(false) <= ((long) this.backupConfigOperator.m75332E()) * 3600000;
        this.isUseCache = z10;
        init3rdAppModuleSize(z10);
        initVirtualModuleSize(this.isUseCache);
        initGallerySize();
        initMusicSize(cBSInitParamInitParams);
        saveBackupModuleInfo();
        this.whites.clear();
        this.appBlackList.clear();
        this.disableIds.clear();
        C11839m.m70688i(TAG, "onPrepare end");
    }

    @Override // com.huawei.android.hicloud.cloudbackup.process.ICBBaseTask
    public void onStart() throws InterruptedException, C9721b, SQLException {
        C11839m.m70688i(TAG, "onStart start.");
        this.snapshotTreeService.createSnapshotBackupMetaTable(this.backupId);
        this.snapshotTreeService.saveTree(SnapshotBackupMeta.DB_ROOT_NODE_APPID, this.snapshotTreeService.createDBRootNode(this.backupId), this.backupId);
        C11726g c11726gM75923y = C12590s0.m75923y(false);
        long jM69964b = c11726gM75923y.m69964b();
        this.incrementSize = c11726gM75923y.m69963a();
        C11839m.m70688i(TAG, "onStart appsize = " + this.currentAppMetas.size() + " incrementSize = " + this.incrementSize + ", totalSize: " + jM69964b);
        CloudSpace cloudSpaceM78754r = this.gwService.m78754r();
        isCancel();
        this.tags.m78481t0(cloudSpaceM78754r.getTotal());
        this.tags.m78485v0(cloudSpaceM78754r.getUsed());
        if (!this.isUseCache) {
            this.tags.m78473p0(jM69964b);
            this.tags.m78456V(String.valueOf(this.incrementSize));
            C13465e.m81052f().m81070s(false, System.currentTimeMillis());
            processBackupSpaceNotEnough(cloudSpaceM78754r.getTotal(), cloudSpaceM78754r.getUsed());
        } else if (cloudSpaceM78754r.getTotal() > 0) {
            long total = cloudSpaceM78754r.getTotal() - cloudSpaceM78754r.getUsed();
            C11839m.m70688i(TAG, "quota space total = " + cloudSpaceM78754r.getTotal() + " used = " + cloudSpaceM78754r.getUsed());
            if (total < this.incrementSize) {
                this.isUseCache = false;
                init3rdAppModuleSize(false);
                initVirtualModuleSize(false);
                C11726g c11726gM75923y2 = C12590s0.m75923y(false);
                long jM69964b2 = c11726gM75923y2.m69964b();
                this.incrementSize = c11726gM75923y2.m69963a();
                C11839m.m70688i(TAG, "onStart appsize = " + this.currentAppMetas.size() + " incrementSize = " + this.incrementSize + ", totalSize: " + jM69964b2);
                this.tags.m78473p0(jM69964b2);
                this.tags.m78456V(String.valueOf(this.incrementSize));
                C13465e.m81052f().m81070s(false, System.currentTimeMillis());
                processBackupSpaceNotEnough(cloudSpaceM78754r.getTotal(), cloudSpaceM78754r.getUsed());
            } else {
                this.tags.m78473p0(jM69964b);
                this.tags.m78456V(String.valueOf(this.incrementSize));
            }
        }
        C12815f c12815f = new C12815f();
        List<CloudBackupStatus> listM76931j = c12815f.m76931j();
        if (listM76931j.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.currentAppMetas.keySet());
        ArrayList arrayList2 = new ArrayList();
        for (CloudBackupStatus cloudBackupStatus : listM76931j) {
            String strM29870d = cloudBackupStatus.m29870d();
            if (isTimeExpired(cloudBackupStatus.m29404g1(), this.cacheDuration)) {
                C11839m.m70688i(TAG, "overdue appId = " + strM29870d + ", refresh app status");
                cloudBackupStatus.mo29338z0(0).mo29289A0(0).m29436s2(0L).mo29310W(0).mo29308V(0L);
                c12815f.m76934m(cloudBackupStatus);
                SnapshotBackupMeta snapshotBackupMeta = this.currentAppMetas.get(strM29870d);
                if (snapshotBackupMeta != null) {
                    snapshotBackupMeta.setStatus(0);
                    this.snapshotTreeService.updateRootNode(this.backupId, getRootMeta(snapshotBackupMeta));
                }
            }
            if (!arrayList.contains(strM29870d)) {
                arrayList2.add(cloudBackupStatus);
                c12815f.m76923b(strM29870d);
            }
        }
        listM76931j.removeAll(arrayList2);
        C11963c.m71951f("auto");
        C11963c.m71961p("auto");
        C14317j.m85300d().m85308i(1);
        List<BackupItem> listM71954i = C11963c.m71954i("auto");
        Collections.sort(listM71954i, new C2516c0());
        Iterator<BackupItem> it = listM71954i.iterator();
        while (it.hasNext()) {
            SnapshotBackupMeta snapshotBackupMeta2 = this.currentAppMetas.get(it.next().m29870d());
            if (snapshotBackupMeta2 != null) {
                C11839m.m70686d(TAG, "onStart queue.offer appId: " + snapshotBackupMeta2.getData() + ", isSuccess " + this.queue.offer(snapshotBackupMeta2));
            }
        }
        isCancel();
        startNewLock(this.incrementSize);
        C13108a.m78878b(CacheTask.getContext()).m78881d(new Intent("com.huawei.hicloud.intent.action.ACTION_START_SPACE_USING_TRACK_REPROT"));
        C11839m.m70688i(TAG, "onStart end.");
    }

    @Override // com.huawei.android.hicloud.cloudbackup.process.ICBBaseTask
    public void processBatteryNotEnough() {
        abort(1003);
    }

    @Override // com.huawei.android.hicloud.cloudbackup.process.ICBBaseTask
    public void processPowerDisconnect(HiCloudSafeIntent hiCloudSafeIntent) {
        C11839m.m70688i(TAG, "action power disconnected.");
        if (this.autoBackup && abortRequired()) {
            abort(1005);
        }
    }

    @Override // com.huawei.android.hicloud.cloudbackup.process.ICBBaseTask
    public void processScreenOff(Intent intent, Handler handler) {
        C11839m.m70688i(TAG, "process screen off：autoBackup = " + this.autoBackup);
        if (this.autoBackup && isCharging()) {
            handler.removeMessages(3204);
            C11839m.m70688i(TAG, "removeMessages ACTION_SCREEN_OFF");
        }
    }

    @Override // com.huawei.android.hicloud.cloudbackup.process.ICBBaseTask
    public void processUserPresent(Intent intent, Handler handler) {
        if (this.autoBackup) {
            C11839m.m70688i(TAG, "process userPresent");
            if (!isCharging()) {
                if (abortRequired()) {
                    abort(1006);
                    handler.removeMessages(3204);
                    C11839m.m70688i(TAG, "cloudBackup doAbort");
                    return;
                }
                return;
            }
            this.autoBackupUserPresentTimes++;
            Message message = new Message();
            message.what = 3204;
            message.arg1 = 1;
            long jM75338H = new C12526j().m75338H(new SettingOperator().querybreakedtime());
            handler.sendMessageDelayed(message, jM75338H);
            C11839m.m70688i(TAG, "sendMessageDelayed isUserPresent, isCharging,breakedtime = " + jM75338H);
        }
    }

    public CBSBackupRecord queryBackupRecordDetail(String str, int i10, CBSBackupRecord cBSBackupRecord) throws C9721b {
        try {
            return this.service.m68001H(str, i10, cBSBackupRecord.getBackupId(), true, false);
        } catch (C9721b e10) {
            if (cBSBackupRecord.getStatus() != 1) {
                throw e10;
            }
            C11839m.m70689w(TAG, "query old backupRecordDetailReq exception");
            return null;
        }
    }

    @Override // com.huawei.android.hicloud.cloudbackup.process.ICBBaseTask
    public void registThermalCallback() {
        if (!this.autoBackup) {
            C11839m.m70688i(TAG, "registThermalCallback autoBackup false return");
            return;
        }
        registerThermalCallback();
        if (C11979a.m72102l().m72107m()) {
            registerUniScheduleCallback();
        }
    }

    @Override // com.huawei.android.hicloud.cloudbackup.process.ICBBaseTask
    public void reportEachStageTime(long j10, long j11, String str) {
        if (this.tags != null) {
            C11839m.m70686d(TAG, "report each stage time");
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
            linkedHashMap.put("traceId", this.tags.m78444J());
            linkedHashMap.put("backupId", this.backupId);
            linkedHashMap.put("id", this.tags.m78436B());
            linkedHashMap.put("stage", str);
            linkedHashMap.put("time", String.valueOf(j11 - j10));
            linkedHashMap.put("backupVersion", "V2");
            C13225d.m79490f1().m79603z0("cloudbackup_each_stage_time", linkedHashMap);
        }
    }

    @Override // com.huawei.android.hicloud.cloudbackup.process.ICBBaseTask
    public void reportEvent() {
        C11060c c11060cM66626a = C11058a.m66626a(this.traceID, "success", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66668x("1");
        c11060cM66626a.m66665u("0");
        if (this.isSuccess) {
            doSuccessReport(c11060cM66626a);
            new BackupNotificationManager(CacheTask.getContext()).cancelNotification(24);
            clearBackupIncompleteTip();
        } else {
            doFailReport(c11060cM66626a);
        }
        this.errMsg = c11060cM66626a.m66652h();
        C14317j.m85300d().m85302a(1, c11060cM66626a.m66647c(), this.isSuccess);
        HashMap map = new HashMap();
        map.put("backupVersion", "V2");
        if (this.tags != null) {
            map.put("backupId", this.tags.m78465h());
            map.put("count", String.valueOf(this.tags.m78476r()));
            map.put("backupBeginTime", String.valueOf(this.tags.m78469k()));
            map.put("backupStartTime", String.valueOf(this.tags.m78440F()));
            map.put("backupEndTime", String.valueOf(System.currentTimeMillis()));
            map.put("totalSize", String.valueOf(this.tags.m78439E()));
            map.put("incrementSize", String.valueOf(this.incrementSize));
            map.put("backupTransID", this.tags.m78436B());
            map.put("backupTimes", String.valueOf(this.tags.m78476r()));
            map.put("firstBackupType", String.valueOf(this.firstBackupType));
            map.put("isFullBackup", String.valueOf(this.isFullBackup));
            map.put("lastUploadedSize", String.valueOf(this.mkfileBackupSize));
            map.put("backupSize", String.valueOf(this.backupSize));
            map.put("isWifiSleep", String.valueOf(C2783d.m16163n0(CacheTask.getContext())));
            map.put("isPowerSavingOn", String.valueOf(C2783d.m16124a0(CacheTask.getContext())));
            map.put("stayOnWhilePlugged", String.valueOf(C2783d.m16155k1(CacheTask.getContext())));
            map.put("powerSavingMode", String.valueOf(C2783d.m16152j1(CacheTask.getContext())));
            map.put("needUploadedSize", String.valueOf(this.needUploadedSize));
            int i10 = this.autoBackupUserPresentTimes;
            if (i10 > 0) {
                map.put("autoBackupUserPresentTimes", String.valueOf(i10));
            }
            if (this.isFullBackup) {
                map.put("clientAcitons", this.clientActionList.toString());
                map.put("fullBackupResult", String.valueOf(this.isSuccess));
            }
            this.tags.m78470m0(0);
            this.tags.m78452R(c11060cM66626a.m66647c());
            this.tags.m78446L(this.current);
            this.tags.m78451Q(c11060cM66626a.m66646b());
            if (this.isSuccess) {
                this.tags.m78447M(System.currentTimeMillis());
                this.tags.m78477r0(4);
                this.mProgress = 100;
            }
            map.put(VastAttribute.PROGRESS, String.valueOf(this.mProgress));
            new C13030i().m78496g(this.tags);
            ContentValues contentValues = new ContentValues();
            contentValues.put("backup_end_code", c11060cM66626a.m66647c());
            C12299b.m73929k(contentValues, "backupEndCodePath");
            if (!this.autoBackup) {
                reportBackupTag(this.tags, this.isSuccess ? "success" : NotifyConstants.CommonReportConstants.FAILED, false);
            } else if (this.isSuccess) {
                reportBackupTag(this.tags, "success", false);
                reportInterruptOrAuto(this.tags, "cloudbackup_auto_times");
            }
            reportEachTask(this.tags, "cloudbackup_each_period", null);
            reportEachTask(this.tags, "cloudbackup_each_backup_size", String.valueOf(this.backupSize));
            reportEachTask(this.tags, "cloudbackup_total_size", String.valueOf(this.totalBackupSize));
            reportTaskEnd(map);
        }
        map.put("userType", C13452e.m80781L().m80987x0());
        map.put("gradeCode", C12590s0.m75747G0());
        Long localLeftSpace = ICBUtil.getLocalLeftSpace();
        if (localLeftSpace != null && localLeftSpace.longValue() > 0) {
            map.put("localInfo", String.valueOf(localLeftSpace));
        }
        C13622a.m81971q(c11060cM66626a, map, false, true);
    }

    @Override // com.huawei.android.hicloud.cloudbackup.process.ICBBaseTask
    public void taskErrorEnd() throws SQLException {
        C9721b c9721b = this.exception;
        if (c9721b == null) {
            return;
        }
        int iM60659c = c9721b.m60659c();
        if (iM60659c == 1007) {
            this.snapshotTreeService.defaultNotSuccessModule(this.backupId);
            if (this.tags != null) {
                this.tags.m78471n0(C12590s0.m75860i0());
            }
            deleteBackupCaheFiles();
            return;
        }
        if (iM60659c == 1030) {
            SettingOperator settingOperator = new SettingOperator();
            AbsThermalControl thermalControl = ThermalChecker.getThermalControl(false);
            if (thermalControl == null) {
                C11839m.m70688i(TAG, "thermalControl is empty");
                return;
            } else if (thermalControl.checkIllegalArgument()) {
                C11839m.m70688i(TAG, "thermalControl IllegalArgument");
                return;
            } else {
                settingOperator.replace(new Settings[]{new Settings("nextbackuptime", String.valueOf(thermalControl.getThermalRetryInteval() * 60000), "2")});
                return;
            }
        }
        if (iM60659c == 3001) {
            C11839m.m70688i(TAG, "taskErrorEnd no space");
            new SettingOperator().replace(new Settings[]{new Settings("nextbackuptime", String.valueOf(86400000L), "2")});
            this.snapshotTreeService.defaultNotSuccessModule(this.backupId);
            deleteBackupCaheFiles();
            C0237v.m1661c();
            return;
        }
        if (iM60659c != 3107) {
            if (iM60659c != 3111) {
                return;
            }
            C11839m.m70688i(TAG, "taskErrorEnd catch error: userkey guid not match");
            UserKeyUtils.getInstance().clearUserKeyByBusinessType(1);
            return;
        }
        if (isAutoBackup() && this.exception.m60663g() == 999) {
            getAutoStrategyFromServer();
        }
    }

    @Override // com.huawei.android.hicloud.cloudbackup.process.ICBBaseTask
    public void unNewLock() {
        CBLockAndFlowControlManager cBLockAndFlowControlManager = this.timer;
        if (cBLockAndFlowControlManager == null) {
            C11839m.m70688i(TAG, "unNewLock timer is null");
        } else {
            cBLockAndFlowControlManager.cancel();
        }
    }

    @Override // com.huawei.android.hicloud.cloudbackup.process.ICBBaseTask
    public void unRegistThermalCallback() {
        C11979a.m72102l().m72111q(1);
    }
}
