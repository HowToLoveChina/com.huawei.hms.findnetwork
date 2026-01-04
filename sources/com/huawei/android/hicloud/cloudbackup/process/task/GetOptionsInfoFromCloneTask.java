package com.huawei.android.hicloud.cloudbackup.process.task;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Pair;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.huawei.android.backup.filelogic.utils.PmsCheckUtil;
import com.huawei.android.backup.service.utils.C2157a;
import com.huawei.android.hicloud.cloudbackup.bean.BackupAppSwitchStatusBean;
import com.huawei.android.hicloud.cloudbackup.bean.CloudBackupUserInfo;
import com.huawei.android.hicloud.cloudbackup.callable.CBCallBack;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.model.VirtualAppFileData;
import com.huawei.android.hicloud.cloudbackup.p076db.bean.Settings;
import com.huawei.android.hicloud.cloudbackup.p076db.operator.SettingOperator;
import com.huawei.android.hicloud.cloudbackup.process.CBAccess;
import com.huawei.android.hicloud.cloudbackup.process.CloneService;
import com.huawei.android.hicloud.cloudbackup.process.task.GetOptionsInfoFromCloneTask;
import com.huawei.android.hicloud.cloudbackup.process.util.CloudBackupAppDataUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.ScanAppDataUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.SplitAppUtil;
import com.huawei.android.hicloud.cloudbackup.report.CloudBackupReport;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.bean.SnapshotBackupMeta;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackup3rdIconUtil;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackupLanguageUtil;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.android.hicloud.cloudbackup.util.TransferedUtil;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.task.simple.C3017c;
import com.huawei.fastengine.fastview.NavigationUtils;
import com.huawei.hicloud.cloudbackup.model.CloudRecoveryItem;
import com.huawei.hicloud.cloudbackup.model.CloudRestoreItem;
import com.huawei.hicloud.cloudbackup.p104v3.omconfig.model.BackupOptionSize;
import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.frequency.FrequencyManager;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.openalliance.p169ad.constant.VastAttribute;
import com.tencent.p204mm.opensdk.constants.ConstantsAPI;
import fk.C9721b;
import hk.C10278a;
import hk.C10279b;
import hu.C10343b;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0214f0;
import p015ak.C0221j;
import p015ak.C0241z;
import p429kk.C11058a;
import p495nm.C11725f;
import p495nm.C11727h;
import p510o5.C11818a;
import p514o9.C11829c;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;
import p617rl.C12519c;
import p617rl.C12526j;
import p617rl.C12534r;
import p618rm.C12565k;
import p618rm.C12582p1;
import p618rm.C12586r;
import p618rm.C12590s0;
import p682ul.C13219m;
import p684un.C13225d;
import p709vj.C13452e;
import p711vl.C13465e;
import p815ym.AbstractC14026a;
import p847zk.C14317j;
import p848zl.C14333b;
import pm.C12176c;
import tl.C13026e;
import tl.C13029h;
import tl.C13030i;

/* loaded from: classes2.dex */
public class GetOptionsInfoFromCloneTask extends AbstractC12367d {
    private static final int BATCH_REPORT = 50;
    private static final long ONE_DAY_MILLS = 86400000;
    private static final long ONE_HOUR_TIMEMILLIS = 3600000;
    public static final String TAG = "GetOptionsInfoFromCloneTask";
    public static volatile CloudBackupUserInfo cloudBackupUserInfo;
    private static volatile boolean isCloudBackupTaskRunning;
    private static volatile boolean optionTaskComplete;
    private static volatile boolean optionTaskInitAppDataEnd;
    private List<String> appBackupBlackList;
    private List<String> appBlackList;
    private final Set<String> appIds;
    private List<BackupOptionSize> backupOptionSizes;
    private C13465e backupOptionStatusSp;
    private C11725f bakId;
    private List<BackupAppSwitchStatusBean> beans;
    private final Map<String, Long> cache;
    private CloudRecoveryItem cbRecoveryItem;
    private CloneService cloneService;
    private long getDataFromCloneEnd;
    private long getDataFromCloneStart;
    private long getDataStartTime;
    private long getThirdAppDataEnd;
    private long getThirdAppDataStart;
    private boolean isForceRefresh;
    private boolean isRefurbish;
    private C13026e itemOperator;
    private Map<String, CloudRestoreItem> lastRecordModuleSize;
    private boolean needUpdateBackupIncreaseSize;
    private C12534r settingHelper;
    private CountDownLatch taskCountDownLatch;
    private String traceID;
    private CountDownLatch uiCountDownLatch;
    private String uploadTargetStrategy;

    public static class GetApkInfoTask extends AbstractC12367d {
        private final Map<String, Long> cache;
        private final Context context;
        private final C13026e itemOperator;

        public GetApkInfoTask(Context context, C13026e c13026e, Map<String, Long> map) {
            this.context = context;
            this.itemOperator = c13026e;
            this.cache = map;
        }

        private long getVersionCode(PackageManager packageManager, String str) {
            Long l10 = this.cache.get(str);
            long versionCode = l10 == null ? ICBUtil.getVersionCode(packageManager, str) : l10.longValue();
            if (l10 == null) {
                this.cache.put(str, Long.valueOf(versionCode));
            }
            return versionCode;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            try {
                PackageManager packageManager = this.context.getPackageManager();
                if (packageManager == null) {
                    return;
                }
                ArrayList<BackupOptionItem> arrayList = new ArrayList();
                arrayList.addAll(this.itemOperator.m78400x("thirdAppData"));
                arrayList.addAll(this.itemOperator.m78400x("thirdApp"));
                for (BackupOptionItem backupOptionItem : arrayList) {
                    try {
                        if (packageManager.getPackageInfo(backupOptionItem.getOriBackupAppName(), 16384) != null) {
                            long versionCode = getVersionCode(packageManager, backupOptionItem.getOriBackupAppName());
                            if (TextUtils.isEmpty(backupOptionItem.getData4()) || Long.parseLong(backupOptionItem.getData4()) != versionCode) {
                                CloudBackup3rdIconUtil.cache3rdDrawable(backupOptionItem.getAppId());
                                this.itemOperator.m78371F(versionCode, backupOptionItem.getAppId(), backupOptionItem.getUid());
                            }
                        }
                    } catch (Exception e10) {
                        C11839m.m70687e(GetOptionsInfoFromCloneTask.TAG, backupOptionItem.getAppId() + " Exception: " + e10.toString());
                    }
                }
            } catch (Exception e11) {
                C11839m.m70687e(GetOptionsInfoFromCloneTask.TAG, "getApkSizeAndIcon Exception: " + e11.toString());
            }
        }
    }

    public class GetAppDataSizeAndApkSizeTask extends AbstractC12367d {
        CountDownLatch uiCountDownLatch;

        public GetAppDataSizeAndApkSizeTask(CountDownLatch countDownLatch) {
            this.uiCountDownLatch = countDownLatch;
        }

        public static /* synthetic */ boolean lambda$call$0(List list, BackupOptionItem backupOptionItem) {
            return list.contains(backupOptionItem.getAppId());
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws IOException, NumberFormatException {
            C11839m.m70688i(GetOptionsInfoFromCloneTask.TAG, "begin get app data size task, countDownLatch: " + this.uiCountDownLatch.getCount());
            GetOptionsInfoFromCloneTask.this.getThirdAppDataStart = System.currentTimeMillis();
            List<BackupOptionItem> listM78399w = GetOptionsInfoFromCloneTask.this.itemOperator.m78399w("thirdAppData");
            if (listM78399w != null && !listM78399w.isEmpty()) {
                List<String> listM16188x = C2783d.m16188x(GetOptionsInfoFromCloneTask.this.getContext());
                PackageManager packageManager = GetOptionsInfoFromCloneTask.this.getContext().getPackageManager();
                boolean zM75901s1 = C12590s0.m75901s1();
                for (BackupOptionItem backupOptionItem : listM78399w) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (listM16188x.contains(backupOptionItem.getOriBackupAppName())) {
                        if (backupOptionItem.isBackupData()) {
                            GetOptionsInfoFromCloneTask.this.setAppDataSize(backupOptionItem, getVersionCode(packageManager, backupOptionItem.getOriBackupAppName()), zM75901s1);
                            backupOptionItem.setIsDataEnable(2);
                            C12590s0.m75919x(backupOptionItem, false, GetOptionsInfoFromCloneTask.this.bakId, GetOptionsInfoFromCloneTask.this.lastRecordModuleSize);
                            BackupOptionItem backupOptionItemQueryMergeTwinItem = TransferedUtil.queryMergeTwinItem(backupOptionItem.getAppId(), GetOptionsInfoFromCloneTask.this.isRefurbish);
                            if (backupOptionItemQueryMergeTwinItem != null) {
                                backupOptionItem.setBackupSwitch(backupOptionItemQueryMergeTwinItem.getBackupSwitch());
                                backupOptionItem.setOperateType(backupOptionItemQueryMergeTwinItem.getOperateType());
                                backupOptionItem.setOperateTime(backupOptionItemQueryMergeTwinItem.getOperateTime());
                            }
                            GetOptionsInfoFromCloneTask.this.itemOperator.m78382Q(backupOptionItem);
                            GetOptionsInfoFromCloneTask.this.sendMessageToUI(33005, backupOptionItem);
                            C11839m.m70688i(GetOptionsInfoFromCloneTask.TAG, "get third app dataSize, appId = " + backupOptionItem.getAppId() + ", time: " + (System.currentTimeMillis() - jCurrentTimeMillis) + ", values: " + new Gson().toJson(backupOptionItem));
                        }
                        GetOptionsInfoFromCloneTask.this.reportModuleStatus(backupOptionItem.getAppId(), backupOptionItem, jCurrentTimeMillis);
                    } else {
                        GetOptionsInfoFromCloneTask.this.itemOperator.m78386g(backupOptionItem.getAppId());
                    }
                }
            }
            GetOptionsInfoFromCloneTask.this.getThirdAppDataEnd = System.currentTimeMillis();
            C11839m.m70688i(GetOptionsInfoFromCloneTask.TAG, "end get app data size task: " + (GetOptionsInfoFromCloneTask.this.getThirdAppDataEnd - GetOptionsInfoFromCloneTask.this.getThirdAppDataStart));
            List<BackupOptionItem> listM78399w2 = GetOptionsInfoFromCloneTask.this.itemOperator.m78399w("thirdAppData");
            if (C13452e.m80781L().m80887a1()) {
                final List<String> listM73271n = C12176c.m73271n(null);
                listM78399w2.removeIf(new Predicate() { // from class: com.huawei.android.hicloud.cloudbackup.process.task.r0
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return GetOptionsInfoFromCloneTask.GetAppDataSizeAndApkSizeTask.lambda$call$0(listM73271n, (BackupOptionItem) obj);
                    }
                });
            }
            GetOptionsInfoFromCloneTask.this.sendMessageToUI(33021, listM78399w2);
            if (!GetOptionsInfoFromCloneTask.this.isRefurbish && GetOptionsInfoFromCloneTask.this.needUpdateBackupIncreaseSize) {
                GetOptionsInfoFromCloneTask.this.checkAndUpdateBackupIncreaseSize();
            }
            C11839m.m70686d(GetOptionsInfoFromCloneTask.TAG, String.format(Locale.ENGLISH, "complete scan third data size, apps are %s", new Gson().toJson(GetOptionsInfoFromCloneTask.this.itemOperator.m78397u())));
            new SettingOperator().replace(new Settings[]{new Settings("thirdAppInitTime", String.valueOf(System.currentTimeMillis()), "2")});
            this.uiCountDownLatch.countDown();
            C11839m.m70688i(GetOptionsInfoFromCloneTask.TAG, "complete scan third data size, countDownLatch: " + this.uiCountDownLatch.getCount());
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.OPTIONS_SIZE_TASK;
        }

        public long getVersionCode(PackageManager packageManager, String str) {
            Long l10 = (Long) GetOptionsInfoFromCloneTask.this.cache.get(str);
            long versionCode = l10 == null ? ICBUtil.getVersionCode(packageManager, str) : l10.longValue();
            if (l10 == null) {
                GetOptionsInfoFromCloneTask.this.cache.put(str, Long.valueOf(versionCode));
            }
            return versionCode;
        }
    }

    public static class ListTokenType extends TypeToken<List<String>> {
        private ListTokenType() {
        }

        public /* synthetic */ ListTokenType(C25691 c25691) {
            this();
        }
    }

    public GetOptionsInfoFromCloneTask(boolean z10) {
        this.isForceRefresh = false;
        this.appBlackList = new ArrayList();
        this.appBackupBlackList = new ArrayList();
        this.cloneService = CloneService.getInstance();
        this.getDataStartTime = 0L;
        this.getDataFromCloneStart = 0L;
        this.getDataFromCloneEnd = 0L;
        this.getThirdAppDataStart = 0L;
        this.getThirdAppDataEnd = 0L;
        this.cache = new ConcurrentHashMap();
        this.lastRecordModuleSize = new HashMap();
        this.backupOptionSizes = new ArrayList(100);
        this.appIds = new HashSet();
        this.needUpdateBackupIncreaseSize = false;
        this.uiCountDownLatch = null;
        this.taskCountDownLatch = null;
        this.beans = new ArrayList();
        this.traceID = C11058a.m66627b("02013");
        this.isRefurbish = z10;
        this.itemOperator = new C13026e(z10);
        this.backupOptionStatusSp = C13465e.m81052f();
        this.uploadTargetStrategy = new SettingOperator().queryUploadTargetStrategy();
        this.needUpdateBackupIncreaseSize = false;
    }

    private void calculate() {
        List<BackupOptionItem> listM78397u = this.itemOperator.m78397u();
        ArrayList arrayList = new ArrayList();
        if (listM78397u != null && !listM78397u.isEmpty()) {
            long j10 = 0;
            long j11 = 0;
            long j12 = 0;
            for (BackupOptionItem backupOptionItem : listM78397u) {
                if (backupOptionItem.is3rdAppTwin() && !backupOptionItem.isModuleSplitExist()) {
                    arrayList.add(backupOptionItem);
                } else if (backupOptionItem.getBackupSwitch() && (!HNConstants.DataType.MEDIA.equals(backupOptionItem.getAppId()) || ICBUtil.isSupportGallery(getContext()))) {
                    long totalIncrease = backupOptionItem.getTotalIncrease();
                    String parent = backupOptionItem.getParent();
                    if ("thirdAppData".equals(parent)) {
                        j11 += totalIncrease;
                    } else if ("virtualApp".equals(parent)) {
                        j12 += totalIncrease;
                    } else {
                        j10 += totalIncrease;
                    }
                }
            }
            C11839m.m70688i(TAG, "increaseSys = " + j10 + ", increase3rd = " + j11 + ", increaseVir = " + j12);
            reportGetDataTimeAndSize(j10, j11, j12);
        }
        if (arrayList.size() > 0) {
            this.itemOperator.m78388i(arrayList);
            arrayList.forEach(new Consumer() { // from class: com.huawei.android.hicloud.cloudbackup.process.task.p0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f11734a.lambda$calculate$5((BackupOptionItem) obj);
                }
            });
        }
        if (this.getThirdAppDataEnd > 0) {
            C11839m.m70688i(TAG, "update clientSizeCacheTime: " + System.currentTimeMillis() + " isRefurbish :" + this.isRefurbish);
            this.backupOptionStatusSp.m81070s(this.isRefurbish, System.currentTimeMillis());
        }
        this.backupOptionStatusSp.m81071t(this.isRefurbish, System.currentTimeMillis());
        sendMessageToUI(33034, null);
        reportSwitchStatus();
    }

    public void checkAndUpdateBackupIncreaseSize() throws NumberFormatException {
        if (C12590s0.m75815X0()) {
            C13029h c13029hM75882n2 = C12590s0.m75882n2();
            if (c13029hM75882n2 == null) {
                C11839m.m70688i(TAG, "checkAndUpdateBackupIncreaseSize backupTags is null.");
                return;
            }
            long jM69963a = C12590s0.m75923y(false).m69963a();
            long j10 = Long.parseLong(c13029hM75882n2.m78482u());
            C11839m.m70688i(TAG, "checkAndUpdateBackupIncreaseSize incAndTotal increase size: " + jM69963a + ", lastData3: " + j10);
            if (jM69963a > j10) {
                c13029hM75882n2.m78456V(String.valueOf(jM69963a));
                new C13030i().m78496g(c13029hM75882n2);
            }
        }
    }

    private void checkAndUpdateCbRecoveryItem() {
        if (cloudBackupUserInfo == null) {
            C11839m.m70688i(TAG, "cloud backup userInfo is null.");
            return;
        }
        this.cbRecoveryItem = cloudBackupUserInfo.getCurrentLatestBackupRecord();
        this.uploadTargetStrategy = cloudBackupUserInfo.getUploadTargetStrategy();
        if (this.cbRecoveryItem == null) {
            C11839m.m70688i(TAG, "cb recovery item is null.");
            return;
        }
        C11725f c11725f = new C11725f();
        this.bakId = c11725f;
        c11725f.m69961e(this.cbRecoveryItem.getBackupId());
        HashMap map = new HashMap();
        map.put(this.cbRecoveryItem.getBackupId(), this.cbRecoveryItem.getVersion());
        this.bakId.m69962f(map);
    }

    public static void checkCacheInvalid() {
        checkCacheInvalid(false);
    }

    private BackupOptionItem generateAppItem(String str, boolean z10) throws C9721b {
        BackupOptionItem backupOptionItemQueryItem = TransferedUtil.queryItem(str, this.isRefurbish);
        if (backupOptionItemQueryItem == null) {
            backupOptionItemQueryItem = new BackupOptionItem(str, "thirdAppData");
            if (this.isRefurbish) {
                z10 = true;
            }
            backupOptionItemQueryItem.setBackupSwitch(z10);
            this.itemOperator.m78370E(backupOptionItemQueryItem);
        } else if (backupOptionItemQueryItem.getOperateType() != 1) {
            backupOptionItemQueryItem.setBackupSwitch(z10);
        }
        return backupOptionItemQueryItem;
    }

    private BackupOptionItem generateSysItem(String str, String str2) throws C9721b {
        BackupOptionItem backupOptionItemQueryItem = TransferedUtil.queryItem(str2, this.isRefurbish);
        if (backupOptionItemQueryItem == null) {
            backupOptionItemQueryItem = new BackupOptionItem(str2, str);
            BackupOptionItem backupOptionItemQueryItem2 = TransferedUtil.queryItem(str, this.isRefurbish);
            if (backupOptionItemQueryItem2 != null) {
                backupOptionItemQueryItem.setBackupSwitch(backupOptionItemQueryItem2.getBackupSwitch());
                backupOptionItemQueryItem.setOperateType(backupOptionItemQueryItem2.getOperateType());
            } else {
                backupOptionItemQueryItem.setBackupSwitch(true);
            }
            this.itemOperator.m78370E(backupOptionItemQueryItem);
        }
        return backupOptionItemQueryItem;
    }

    private void getBackupModuleInfo() throws Throwable {
        C11839m.m70688i(TAG, "begin getBackupModuleInfo");
        this.getDataFromCloneStart = System.currentTimeMillis();
        if (this.bakId == null) {
            this.bakId = C12590s0.m75894q2();
        }
        boolean zEquals = "1".equals(this.uploadTargetStrategy);
        C12590s0.m75775N0(this.cbRecoveryItem, this.lastRecordModuleSize);
        List<String> listM73271n = C13452e.m80781L().m80887a1() ? C12176c.m73271n(null) : null;
        for (String str : C14333b.m85478m()) {
            if (zEquals && C14333b.f63656h.contains(str)) {
                C11839m.m70686d(TAG, "skip backup module: " + str);
            } else {
                List<String> childModuleList = getChildModuleList(str);
                if (!childModuleList.isEmpty()) {
                    getSysItemFromModuleInfo(str, childModuleList, listM73271n);
                }
                BackupOptionItem backupOptionItemQueryParentItem = ICBUtil.queryParentItem(str, this.isRefurbish);
                C11839m.m70688i(TAG, "parentItem: " + backupOptionItemQueryParentItem.getAppId() + ", data enable: " + backupOptionItemQueryParentItem.isDataEnable() + ", isRefurbish: " + this.isRefurbish);
                sendMessageToUI(33005, backupOptionItemQueryParentItem);
                this.appIds.addAll(childModuleList);
            }
        }
        this.getDataFromCloneEnd = System.currentTimeMillis();
        this.backupOptionStatusSp.m81069r(this.isRefurbish, System.currentTimeMillis());
        optionTaskInitAppDataEnd = true;
        C11839m.m70688i(TAG, "get backup module info from clone time: " + (this.getDataFromCloneEnd - this.getDataFromCloneStart));
        initMusicSize();
        sendMessageToUI(33005, ICBUtil.queryParentItem("music", this.isRefurbish));
        this.appIds.add("music");
        initGallerySize();
        sendMessageToUI(33005, ICBUtil.queryParentItem(HNConstants.DataType.MEDIA, this.isRefurbish));
        this.appIds.add(HNConstants.DataType.MEDIA);
        initVirtualAppData();
        reportBrowserAppIds(this.appIds);
        waitCountDownLatch(this.uiCountDownLatch);
        calculate();
        C11839m.m70688i(TAG, "GetOptionsInfoFromCloneTask end.");
    }

    private List<String> getChildModuleList(String str) throws C9721b, PackageManager.NameNotFoundException {
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
            arrayList.addAll((Collection) arrayList2.parallelStream().filter(new Predicate() { // from class: com.huawei.android.hicloud.cloudbackup.process.task.l0
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return this.f11727a.lambda$getChildModuleList$1((String) obj);
                }
            }).collect(Collectors.toList()));
        } else {
            arrayList.add(str);
        }
        C11839m.m70686d(TAG, " clone  getChildModuleList: " + arrayList.toString());
        return arrayList;
    }

    public Context getContext() {
        return C0213f.m1377a();
    }

    private long getDataSizeByEmpiricalValue(int i10, long j10, long j11, long j12) {
        if (i10 <= 0 || j11 <= 0) {
            return j10;
        }
        long j13 = j10 + (i10 * j11);
        return (j12 <= 0 || j13 <= j12) ? j13 : j12;
    }

    private long getSinglePathMediaSize(List<String> list) {
        File[] fileArrListFiles = new File(list.get(0)).listFiles();
        long jM1507q = 0;
        if (fileArrListFiles == null) {
            return 0L;
        }
        for (File file : fileArrListFiles) {
            jM1507q += C0221j.m1507q(file);
        }
        return jM1507q;
    }

    private void getSysItemFromModuleInfo(String str, List<String> list, List<String> list2) throws C9721b {
        boolean z10;
        C11839m.m70688i(TAG, "get system item list: " + list);
        for (String str2 : list) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (!this.isForceRefresh && CBAccess.hasTaskWorking() && (!(z10 = this.isRefurbish) || (z10 && !CBAccess.isBackupAbout()))) {
                C11839m.m70688i(TAG, "generate system module in backup or restore, return. appId: " + str + ", isRefurbish: " + this.isRefurbish);
                isCloudBackupTaskRunning = true;
                return;
            }
            Bundle backupModuleInfo = this.cloneService.getBackupModuleInfo(str2, false);
            if (backupModuleInfo == null) {
                C11839m.m70688i(TAG, "get backup module info from clone is time out, appId: " + str2);
                backupModuleInfo = new Bundle();
            }
            BackupOptionItem systemOptionsInfo = getSystemOptionsInfo(str, str2, new C10343b(backupModuleInfo).m63684f(str2));
            C12590s0.m75919x(systemOptionsInfo, false, this.bakId, this.lastRecordModuleSize);
            this.itemOperator.m78382Q(systemOptionsInfo);
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            reportModuleStatus(str2, systemOptionsInfo, jCurrentTimeMillis);
            if (list2 != null && !list2.contains(systemOptionsInfo.getAppId()) && !C14333b.m85478m().contains(systemOptionsInfo.getAppId())) {
                sendMessageToUI(33005, systemOptionsInfo);
            }
            C11839m.m70688i(TAG, "appId: " + str2 + ", get system item from module info time: " + (jCurrentTimeMillis2 - jCurrentTimeMillis));
        }
    }

    private BackupOptionItem getSystemOptionsInfo(String str, String str2, Bundle bundle) throws C9721b {
        boolean zM63681c;
        int iM63686h;
        long jM63688j;
        BackupOptionItem backupOptionItemGenerateSysItem = generateSysItem(str, str2);
        if (bundle == null && !str2.equals(HNConstants.DataType.CONTACT)) {
            C11839m.m70688i(TAG, "bundle is null, not support clone, appId: " + str2);
            if ("chatSms".equals(str2)) {
                backupOptionItemGenerateSysItem.setItemTotal(0);
                backupOptionItemGenerateSysItem.setDataBytes(0L);
            }
            backupOptionItemGenerateSysItem.setIsDataEnable(-1);
            return backupOptionItemGenerateSysItem;
        }
        C10343b c10343b = new C10343b(bundle);
        if (HNConstants.DataType.CONTACT.equals(str2)) {
            Iterator<String> it = c10343b.m63697s().iterator();
            jM63688j = 0;
            iM63686h = 0;
            while (it.hasNext()) {
                Bundle bundleM63684f = c10343b.m63684f(it.next());
                if (bundleM63684f != null) {
                    C10343b c10343b2 = new C10343b(bundleM63684f);
                    if ("Phone".equals(c10343b2.m63694p("AccountName"))) {
                        int iM63686h2 = c10343b2.m63686h("ModuleCount");
                        jM63688j = c10343b2.m63688j("ModuleSize");
                        iM63686h = iM63686h2;
                    }
                }
            }
            zM63681c = false;
        } else {
            zM63681c = c10343b.m63681c("isSupportClone");
            iM63686h = c10343b.m63686h("ModuleCount");
            jM63688j = c10343b.m63688j("ModuleSize");
        }
        C11839m.m70688i(TAG, "getSystemOptionsInfo, appId: " + str2 + " isSupportClone:" + zM63681c + ", count: " + iM63686h + ", data size: " + jM63688j + ", backupOptionSizes: " + this.backupOptionSizes.size());
        if (jM63688j > 0 && this.backupOptionSizes.size() > 0) {
            jM63688j = updateDataSizeByLastRecord(str2, jM63688j, iM63686h);
        }
        backupOptionItemGenerateSysItem.setParent(str);
        backupOptionItemGenerateSysItem.setItemTotal(iM63686h);
        backupOptionItemGenerateSysItem.setDataBytes(jM63688j);
        backupOptionItemGenerateSysItem.setIsDataEnable(2);
        C11839m.m70688i(TAG, "getSystemOptionsInfo" + new Gson().toJson(backupOptionItemGenerateSysItem));
        return backupOptionItemGenerateSysItem;
    }

    private void getThirdAppDataModule() throws C9721b, PackageManager.NameNotFoundException {
        if (!this.isForceRefresh && CBAccess.hasTaskWorking()) {
            C11839m.m70688i(TAG, "generate third app in backup or restore, return.");
            isCloudBackupTaskRunning = true;
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        Bundle backupModuleInfo = this.cloneService.getBackupModuleInfo("app", false);
        if (backupModuleInfo == null) {
            C11839m.m70688i(TAG, "third app return;");
            return;
        }
        Bundle bundle = (Bundle) new C10343b(backupModuleInfo).m63680b("app");
        if (bundle == null) {
            C11839m.m70688i(TAG, "value is null");
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
        arrayListM63696r.removeAll(this.appBlackList);
        final String str = this.isRefurbish ? "2" : "1";
        Map<String, C13219m<String, Integer, Integer>> mapInit3rdAppTwinsList = SplitAppUtil.init3rdAppTwinsList(hashSet, new Function() { // from class: com.huawei.android.hicloud.cloudbackup.process.task.n0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f11731a.lambda$getThirdAppDataModule$2(str, (String) obj);
            }
        });
        arrayListM63696r.addAll(mapInit3rdAppTwinsList.keySet());
        arrayListM63696r.removeAll(this.appBlackList);
        arrayListM63696r.removeAll(C12590s0.m75727B0());
        List<String> listM78398v = this.itemOperator.m78398v("thirdAppData");
        for (String str2 : listM78398v) {
            if (!arrayListM63696r.contains(str2)) {
                this.itemOperator.m78386g(str2);
            }
        }
        listM78398v.removeAll(arrayListM63696r);
        C11839m.m70688i(TAG, "waitDeleteAppids = " + listM78398v);
        if (listM78398v.size() > 0) {
            this.itemOperator.m78387h(listM78398v);
        }
        C11839m.m70688i(TAG, "get thirdAppDataModule time: " + (System.currentTimeMillis() - jCurrentTimeMillis));
        getThirdAppOptionsInfo(arrayListM63696r, mapInit3rdAppTwinsList);
        this.appIds.addAll(arrayListM63696r);
    }

    private void getThirdAppOptionsInfo(List<String> list, Map<String, C13219m<String, Integer, Integer>> map) throws C9721b, PackageManager.NameNotFoundException {
        String strValueOf;
        int iIntValue;
        String strM79449b;
        C11839m.m70688i(TAG, "begin getThirdAppOptionsInfo");
        if (list.isEmpty()) {
            C11839m.m70688i(TAG, "app modules from clone is empty.");
            return;
        }
        C11839m.m70688i(TAG, "third app module list from clone: " + new Gson().toJson(list));
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
                C11839m.m70688i(TAG, "wait QueryOmAppBackupScopeTask appId " + str);
            }
            long versionCode = ICBUtil.getVersionCode(packageManager, strM79449b);
            String appName = ICBUtil.getAppName(packageManager, strM79449b, strValueOf);
            CloudBackupAppDataUtil cloudBackupAppDataUtil = new CloudBackupAppDataUtil(strM79449b, C12586r.m75711b(), versionCode, this.isRefurbish, false);
            if (cloudBackupAppDataUtil.isAppDataAble() && PmsCheckUtil.m12611e()) {
                refreshThirdAppData("thirdAppData", str, iIntValue, strValueOf, strM79449b, appName, cloudBackupAppDataUtil.getDefaultSwitch(str, SplitAppUtil.isSplitApp(strValueOf), TAG));
            } else if (this.isRefurbish) {
                this.itemOperator.m78386g(str);
            } else {
                refreshThirdAppData("thirdApp", str, iIntValue, strValueOf, strM79449b, appName, false);
            }
        }
        List<BackupOptionItem> listM78399w = this.itemOperator.m78399w("thirdAppData");
        if (C13452e.m80781L().m80887a1()) {
            final List<String> listM73271n = C12176c.m73271n(null);
            listM78399w.removeIf(new Predicate() { // from class: com.huawei.android.hicloud.cloudbackup.process.task.q0
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return GetOptionsInfoFromCloneTask.lambda$getThirdAppOptionsInfo$4(listM73271n, (BackupOptionItem) obj);
                }
            });
        }
        sendMessageToUI(33021, listM78399w);
        C11839m.m70688i(TAG, "app data module load end. ");
        this.uiCountDownLatch = new CountDownLatch(1);
        C12515a.m75110o().m75175e(new GetAppDataSizeAndApkSizeTask(this.uiCountDownLatch), false);
        C12515a.m75110o().m75172d(new GetApkInfoTask(getContext(), this.itemOperator, this.cache));
    }

    private long getWholePathMediaSize(List<String> list) {
        Iterator<String> it = list.iterator();
        long jM1506p = 0;
        while (it.hasNext()) {
            jM1506p += C0221j.m1506p(new File(it.next()));
        }
        return jM1506p;
    }

    private void initConfig() {
        this.settingHelper = C12534r.m75443g();
    }

    private void initGallerySize() throws Throwable {
        if (!ICBUtil.isSupportGallery(getContext()) && !this.isRefurbish) {
            C11839m.m70688i(TAG, "unsupport gallery backup.");
            return;
        }
        C11839m.m70688i(TAG, "get GallerySize start.");
        long jCurrentTimeMillis = System.currentTimeMillis();
        Pair<Integer, Long> pairM75844e0 = C12590s0.m75844e0(this.isRefurbish, false);
        int iIntValue = ((Integer) pairM75844e0.first).intValue();
        long jLongValue = ((Long) pairM75844e0.second).longValue();
        BackupOptionItem backupOptionItemGenerateSysItem = generateSysItem(HNConstants.DataType.MEDIA, HNConstants.DataType.MEDIA);
        backupOptionItemGenerateSysItem.setParent(HNConstants.DataType.MEDIA);
        backupOptionItemGenerateSysItem.setDataBytes(jLongValue);
        backupOptionItemGenerateSysItem.setItemTotal(iIntValue);
        backupOptionItemGenerateSysItem.setIsDataEnable(2);
        C12590s0.m75919x(backupOptionItemGenerateSysItem, false, this.bakId, this.lastRecordModuleSize);
        this.itemOperator.m78382Q(backupOptionItemGenerateSysItem);
        reportModuleStatus(HNConstants.DataType.MEDIA, backupOptionItemGenerateSysItem, jCurrentTimeMillis);
        C11839m.m70688i(TAG, "get GallerySize end. gallery dataSize = " + backupOptionItemGenerateSysItem.getDataBytes() + "count = " + backupOptionItemGenerateSysItem.getItemTotal() + ", time: " + (System.currentTimeMillis() - jCurrentTimeMillis));
    }

    private void initMusicSize() throws Throwable {
        int count;
        long j10;
        long size;
        Throwable th2;
        int i10;
        C11839m.m70688i(TAG, "initMusicSize start.");
        long jCurrentTimeMillis = System.currentTimeMillis();
        if ("2".equalsIgnoreCase(this.uploadTargetStrategy)) {
            C11839m.m70688i(TAG, "compute music size in v3 procedure");
            SnapshotBackupMeta snapshotBackupMetaM75634r = new C12582p1(getLocation(), getContext()).m75634r();
            if (snapshotBackupMetaM75634r != null) {
                count = (int) snapshotBackupMetaM75634r.getCount();
                size = snapshotBackupMetaM75634r.getSize();
            } else {
                count = 0;
                size = 0;
            }
        } else {
            C11839m.m70688i(TAG, "compute music size in v2 procedure");
            List<String> blackPath = CloudBackupConstant.MusicFileFilterPath.getBlackPath();
            List list = (List) C13465e.m81052f().m81060i("musicBlackList", new ListTokenType().getType());
            if (list != null && !list.isEmpty()) {
                list.removeAll(blackPath);
                blackPath.addAll(list);
            }
            String location = getLocation();
            try {
                Cursor cursorQuery = getContext().getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, new String[]{"_data", "_size"}, null, null, null);
                if (cursorQuery != null) {
                    try {
                        int columnIndex = cursorQuery.getColumnIndex("_size");
                        i10 = 0;
                        j10 = 0;
                        while (cursorQuery.moveToNext()) {
                            try {
                                String string = cursorQuery.getString(cursorQuery.getColumnIndex("_data"));
                                File fileM63442h = C10278a.m63442h(string);
                                String strM63452a = C10279b.m63452a(fileM63442h);
                                if (fileM63442h.exists()) {
                                    boolean zIsBlackFile = isBlackFile(blackPath, strM63452a, location);
                                    C11839m.m70686d(TAG, "initMusicSize file isBlackFile: " + zIsBlackFile + ", file = " + string);
                                    if (!zIsBlackFile) {
                                        j10 += cursorQuery.getLong(columnIndex);
                                        i10++;
                                    }
                                } else {
                                    C11839m.m70689w(TAG, "initMusicSize file is not exists fpath = " + string);
                                }
                            } catch (Throwable th3) {
                                th2 = th3;
                                try {
                                    try {
                                        cursorQuery.close();
                                        throw th2;
                                    } catch (Exception e10) {
                                        e = e10;
                                        count = i10;
                                        C11839m.m70687e(TAG, "scanMediaFiles error = " + e.toString());
                                        size = j10;
                                        BackupOptionItem backupOptionItemGenerateSysItem = generateSysItem("music", "music");
                                        backupOptionItemGenerateSysItem.setParent("music");
                                        backupOptionItemGenerateSysItem.setDataBytes(size);
                                        backupOptionItemGenerateSysItem.setItemTotal(count);
                                        backupOptionItemGenerateSysItem.setIsDataEnable(2);
                                        C12590s0.m75919x(backupOptionItemGenerateSysItem, false, this.bakId, this.lastRecordModuleSize);
                                        this.itemOperator.m78382Q(backupOptionItemGenerateSysItem);
                                        reportModuleStatus("music", backupOptionItemGenerateSysItem, jCurrentTimeMillis);
                                        C11839m.m70688i(TAG, "initMusicSize end. music size = " + backupOptionItemGenerateSysItem.getDataBytes() + ", music count = " + backupOptionItemGenerateSysItem.getItemTotal() + ", time: " + (System.currentTimeMillis() - jCurrentTimeMillis));
                                    }
                                } catch (Throwable th4) {
                                    th2.addSuppressed(th4);
                                    throw th2;
                                }
                            }
                        }
                        count = i10;
                    } catch (Throwable th5) {
                        th2 = th5;
                        i10 = 0;
                        j10 = 0;
                    }
                } else {
                    count = 0;
                    j10 = 0;
                }
                if (cursorQuery != null) {
                    try {
                        cursorQuery.close();
                    } catch (Exception e11) {
                        e = e11;
                        C11839m.m70687e(TAG, "scanMediaFiles error = " + e.toString());
                        size = j10;
                        BackupOptionItem backupOptionItemGenerateSysItem2 = generateSysItem("music", "music");
                        backupOptionItemGenerateSysItem2.setParent("music");
                        backupOptionItemGenerateSysItem2.setDataBytes(size);
                        backupOptionItemGenerateSysItem2.setItemTotal(count);
                        backupOptionItemGenerateSysItem2.setIsDataEnable(2);
                        C12590s0.m75919x(backupOptionItemGenerateSysItem2, false, this.bakId, this.lastRecordModuleSize);
                        this.itemOperator.m78382Q(backupOptionItemGenerateSysItem2);
                        reportModuleStatus("music", backupOptionItemGenerateSysItem2, jCurrentTimeMillis);
                        C11839m.m70688i(TAG, "initMusicSize end. music size = " + backupOptionItemGenerateSysItem2.getDataBytes() + ", music count = " + backupOptionItemGenerateSysItem2.getItemTotal() + ", time: " + (System.currentTimeMillis() - jCurrentTimeMillis));
                    }
                }
            } catch (Exception e12) {
                e = e12;
                count = 0;
                j10 = 0;
            }
            size = j10;
        }
        BackupOptionItem backupOptionItemGenerateSysItem22 = generateSysItem("music", "music");
        backupOptionItemGenerateSysItem22.setParent("music");
        backupOptionItemGenerateSysItem22.setDataBytes(size);
        backupOptionItemGenerateSysItem22.setItemTotal(count);
        backupOptionItemGenerateSysItem22.setIsDataEnable(2);
        C12590s0.m75919x(backupOptionItemGenerateSysItem22, false, this.bakId, this.lastRecordModuleSize);
        this.itemOperator.m78382Q(backupOptionItemGenerateSysItem22);
        reportModuleStatus("music", backupOptionItemGenerateSysItem22, jCurrentTimeMillis);
        C11839m.m70688i(TAG, "initMusicSize end. music size = " + backupOptionItemGenerateSysItem22.getDataBytes() + ", music count = " + backupOptionItemGenerateSysItem22.getItemTotal() + ", time: " + (System.currentTimeMillis() - jCurrentTimeMillis));
    }

    private static void initSupportPmsMove() {
        C11839m.m70688i(TAG, "GetOptionsInfoFromCloneTask initPmsMoveOrderSupported start.");
        try {
            C12565k.m75529o();
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "GetOptionsInfoFromCloneTask initPmsMoveOrderSupported error: " + e10.toString());
        }
        C11839m.m70688i(TAG, "GetOptionsInfoFromCloneTask initPmsMoveOrderSupported end.");
    }

    private void initVirtualAppData() {
        C11839m.m70688i(TAG, "<initVirtualAppData> start.");
        try {
            C12519c c12519c = new C12519c();
            List<String> listM75297h = c12519c.m75297h(this.isRefurbish ? 2 : 1);
            List<String> listM78398v = this.itemOperator.m78398v("virtualApp");
            listM78398v.removeAll(listM75297h);
            this.itemOperator.m78387h(listM78398v);
            listM75297h.removeAll(C14333b.m85476k());
            this.appIds.addAll(listM75297h);
            C11839m.m70688i(TAG, "<initVirtualAppData> virtuals: " + listM75297h);
            for (String str : listM75297h) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                CloudBackupAppDataUtil cloudBackupAppDataUtil = new CloudBackupAppDataUtil(str, C12586r.m75711b(), 0L, this.isRefurbish, false);
                C11839m.m70688i(TAG, "<initVirtualAppData> isAppDataAble: " + cloudBackupAppDataUtil.isAppDataAble() + ", appId: " + str);
                if (cloudBackupAppDataUtil.isAppDataAble()) {
                    String virtualName = CloudBackupLanguageUtil.getVirtualName(str);
                    ScanAppDataUtil scanAppDataUtil = new ScanAppDataUtil(str, cloudBackupAppDataUtil.getmCloudBackupInclude(), cloudBackupAppDataUtil.getmCloudBackupExclude());
                    C11839m.m70688i(TAG, "<initVirtualAppData> scanAppDataUtil: " + new Gson().toJson(scanAppDataUtil));
                    AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                    VirtualAppFileData sdcardSize = scanAppDataUtil.getSdcardSize(cloudBackupAppDataUtil, atomicBoolean);
                    if (atomicBoolean.get()) {
                        C11839m.m70687e(TAG, "initVirtualAppData has exception, do skip。 appId:" + str);
                    } else {
                        BackupOptionItem backupOptionItemM78401y = this.itemOperator.m78401y(str);
                        if (backupOptionItemM78401y == null) {
                            backupOptionItemM78401y = new BackupOptionItem(str, "virtualApp");
                            backupOptionItemM78401y.setBackupSwitch(true);
                            backupOptionItemM78401y.setBackupData(true);
                            this.itemOperator.m78370E(backupOptionItemM78401y);
                        }
                        backupOptionItemM78401y.setParent("virtualApp");
                        backupOptionItemM78401y.setAppName(virtualName);
                        backupOptionItemM78401y.setDataBytes(sdcardSize.getFileSize());
                        backupOptionItemM78401y.setItemTotal(sdcardSize.getFileCount());
                        backupOptionItemM78401y.setIsDataEnable(2);
                        C12590s0.m75919x(backupOptionItemM78401y, false, this.bakId, this.lastRecordModuleSize);
                        this.itemOperator.m78382Q(backupOptionItemM78401y);
                        BackupOptionItem backupOptionItemM78401y2 = this.itemOperator.m78401y(str);
                        backupOptionItemM78401y2.setShowType(C0241z.m1685c(c12519c.m75305p(str)));
                        reportModuleStatus(str, backupOptionItemM78401y2, jCurrentTimeMillis);
                        C11839m.m70688i(TAG, "initVirtualAppData" + new Gson().toJson(backupOptionItemM78401y2));
                        sendMessageToUI(33005, backupOptionItemM78401y2);
                    }
                }
            }
            C11839m.m70688i(TAG, "<initVirtualAppData> end.");
        } catch (C9721b e10) {
            C11839m.m70687e(TAG, "query virtual app list error: " + e10.getMessage());
        }
    }

    private boolean isBlackFile(List<String> list, String str, String str2) {
        for (String str3 : list) {
            String strConvertToAbsolutePath = ICBUtil.convertToAbsolutePath(str3, str2);
            if (TextUtils.isEmpty(strConvertToAbsolutePath)) {
                C11839m.m70689w(TAG, "scanMediaFiles realPath is empty, blackPath = " + str3);
            } else if (str.startsWith(strConvertToAbsolutePath)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isOptionTaskInitAppDataEnd() {
        return optionTaskInitAppDataEnd;
    }

    public static boolean isOptionTaskNotComplete() {
        return !optionTaskComplete;
    }

    public /* synthetic */ void lambda$calculate$5(BackupOptionItem backupOptionItem) {
        sendMessageToUI(33005, TransferedUtil.queryMergeTwinItem(backupOptionItem.getAppId(), this.isRefurbish));
    }

    public /* synthetic */ boolean lambda$getChildModuleList$1(String str) {
        return !this.appBackupBlackList.contains(str);
    }

    public /* synthetic */ Boolean lambda$getThirdAppDataModule$2(String str, String str2) {
        return Boolean.valueOf(this.settingHelper.m75451m(str2, str));
    }

    public static /* synthetic */ boolean lambda$getThirdAppOptionsInfo$4(List list, BackupOptionItem backupOptionItem) {
        return list.contains(backupOptionItem.getAppId());
    }

    public static /* synthetic */ boolean lambda$updateDataSizeByLastRecord$3(String str, BackupOptionSize backupOptionSize) {
        return str.equals(backupOptionSize.getAppId());
    }

    public static /* synthetic */ void lambda$waitOptionTaskEnd$0(AtomicBoolean atomicBoolean, Supplier supplier) {
        atomicBoolean.set(((Boolean) supplier.get()).booleanValue());
    }

    private void recordTaskEndTime() {
        if (this.isRefurbish) {
            return;
        }
        new SettingOperator().replace(new Settings[]{new Settings("lastclonesuccesstime", String.valueOf(System.currentTimeMillis()), "2")});
        if (C13452e.m80781L().m80887a1()) {
            C14317j.m85300d().m85319t();
        }
    }

    private void refreshThirdAppData(String str, String str2, int i10, String str3, String str4, String str5, boolean z10) throws C9721b {
        if (SplitAppUtil.isSplitApp(str3)) {
            this.itemOperator.m78369D(str, str2, i10, str3, str4, str5, z10);
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
        this.itemOperator.m78382Q(backupOptionItemGenerateAppItem);
        C11839m.m70688i(TAG, "appId: " + backupOptionItemGenerateAppItem.getAppId() + " match om config, backup app data. ");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("getThirdAppOptionsInfo");
        sb2.append(new Gson().toJson(backupOptionItemGenerateAppItem));
        C11839m.m70688i(TAG, sb2.toString());
    }

    private void reportBrowserAppIds(Set<String> set) {
        String str;
        int i10;
        ArrayList arrayList = new ArrayList(set);
        int size = arrayList.size();
        int i11 = (size / 50) + (size % 50 == 0 ? 0 : 1);
        C11839m.m70686d(TAG, String.format(Locale.ENGLISH, "report appIds are： %s, total report batch times is: %s", new Gson().toJson(arrayList), Integer.valueOf(i11)));
        for (int i12 = 0; i12 < size; i12 += 50) {
            int i13 = (i12 / 50) + 1;
            if (i13 == 1 && i13 != i11) {
                i10 = i12 + 50;
                str = "start";
            } else if (i13 <= 1 || i13 >= i11) {
                str = "end";
                i10 = size;
            } else {
                i10 = i12 + 50;
                str = "ing";
            }
            reportOneStage(str, arrayList.subList(i12, i10));
        }
    }

    private void reportCloneTaskException(Exception exc) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("traceID", this.traceID);
        linkedHashMap.put(VastAttribute.ERROR, exc.getMessage());
        linkedHashMap.put("stack", C12590s0.m75731C0(exc));
        linkedHashMap.put("isRefurbish", String.valueOf(this.isRefurbish));
        C13225d.m79490f1().m79567R("cloudbackup_option_module_status_exception", linkedHashMap);
        UBAAnalyze.m29947H("CKC", "cloudbackup_option_module_status_exception", linkedHashMap);
    }

    private void reportGetDataTimeAndSize(long j10, long j11, long j12) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("traceID", this.traceID);
        linkedHashMap.put(FrequencyManager.H5DialogConstant.BEGIN_TIME, String.valueOf(this.getDataStartTime));
        linkedHashMap.put("endTime", String.valueOf(jCurrentTimeMillis));
        linkedHashMap.put("cloneBeginTime", String.valueOf(this.getDataFromCloneStart));
        linkedHashMap.put("cloneEndTime", String.valueOf(this.getDataFromCloneEnd));
        linkedHashMap.put("thirdBeginTime", String.valueOf(this.getThirdAppDataStart));
        linkedHashMap.put("thirdEndTime", String.valueOf(this.getThirdAppDataEnd));
        linkedHashMap.put("dataSize", String.valueOf(j10 + j11 + j12));
        linkedHashMap.put("sysDataSize", String.valueOf(j10));
        linkedHashMap.put("thirdDataSize", String.valueOf(j11));
        linkedHashMap.put("virtualDataSize", String.valueOf(j12));
        C13225d.m79490f1().m79567R("cloudbackup_option_get_data_period", linkedHashMap);
        UBAAnalyze.m29947H("CKC", "cloudbackup_option_get_data_period", linkedHashMap);
    }

    public void reportModuleStatus(String str, BackupOptionItem backupOptionItem, long j10) {
        CloudBackupReport.collectModuleInfo(this.beans, str, backupOptionItem, j10);
    }

    private void reportOneStage(String str, List<String> list) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("traceID", this.traceID);
        linkedHashMap.put("batchFlag", str);
        linkedHashMap.put("app", new Gson().toJson(list).replaceAll("[\\[\\]\"]", ""));
        C13225d.m79490f1().m79567R("backupTransactionPrepare", linkedHashMap);
        UBAAnalyze.m29947H("PVC", "backupTransactionPrepare", linkedHashMap);
    }

    private void reportSwitchStatus() {
        boolean zM81055c = this.backupOptionStatusSp.m81055c("isFirstInit", true);
        C11839m.m70688i(TAG, "isFirstInit " + zM81055c);
        if (zM81055c && !this.isRefurbish) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("backup_key");
            C12515a.m75110o().m75172d(new C3017c((ArrayList<String>) arrayList));
            this.backupOptionStatusSp.m81064m("isFirstInit", false);
        }
        if (!this.isRefurbish || this.backupOptionStatusSp.m81055c("isRefurbishSwitchStatusReported", false)) {
            return;
        }
        HashMap map = new HashMap();
        List<BackupOptionItem> listM78397u = this.itemOperator.m78397u();
        if (!AbstractC14026a.m84159a(listM78397u)) {
            for (BackupOptionItem backupOptionItem : listM78397u) {
                map.put(backupOptionItem.getAppId(), Boolean.valueOf(backupOptionItem.getBackupSwitch()));
            }
        }
        if (map.isEmpty()) {
            return;
        }
        C12515a.m75110o().m75175e(new C3017c(true, (Map<String, Boolean>) map), false);
        this.backupOptionStatusSp.m81064m("isRefurbishSwitchStatusReported", true);
    }

    public void sendMessageToUI(int i10, Object obj) {
        Message message = new Message();
        message.what = i10;
        if (obj != null) {
            message.obj = obj;
        }
        if (this.isRefurbish) {
            switch (i10) {
                case 33005:
                    message.what = 43005;
                    break;
                case 33006:
                    message.what = 43006;
                    break;
                case 33008:
                    message.what = 43008;
                    break;
                case 33010:
                    message.what = 43010;
                    break;
                case 33021:
                    message.what = 43021;
                    break;
            }
        }
        CBCallBack.getInstance().sendMessage(message);
    }

    public void setAppDataSize(BackupOptionItem backupOptionItem, long j10, boolean z10) {
        long j11;
        long j12;
        long j13 = 0;
        try {
            CloudBackupAppDataUtil cloudBackupAppDataUtil = new CloudBackupAppDataUtil(backupOptionItem.getOriBackupAppName(), C12586r.m75711b(), j10, this.isRefurbish, false);
            if (cloudBackupAppDataUtil.isAppDataAble() && PmsCheckUtil.m12611e()) {
                if (backupOptionItem.getUid() != 0) {
                    cloudBackupAppDataUtil.changeToSeparaSetting(backupOptionItem.getUid());
                }
                ScanAppDataUtil scanAppDataUtil = new ScanAppDataUtil(backupOptionItem.getAppId(), backupOptionItem.getUid(), backupOptionItem.getOriBackupAppName(), cloudBackupAppDataUtil.getmCloudBackupInclude(), cloudBackupAppDataUtil.getmCloudBackupExclude());
                long[] jArr = scanAppDataUtil.get3rdAppDataSizeInfo(cloudBackupAppDataUtil, z10, backupOptionItem, scanAppDataUtil);
                long j14 = jArr[0];
                try {
                    j12 = jArr[1];
                    try {
                        j13 = jArr[2];
                        backupOptionItem.setBackupData(true);
                        j13 = j14;
                        j11 = j13;
                    } catch (C9721b e10) {
                        e = e10;
                        long j15 = j13;
                        j13 = j14;
                        j11 = j15;
                        C11839m.m70687e(TAG, "getAppDataSize error, msg: " + e.getMessage());
                        backupOptionItem.setDataBytes(j13);
                        backupOptionItem.setData2(String.valueOf(j12));
                        backupOptionItem.setData3(String.valueOf(j11));
                    }
                } catch (C9721b e11) {
                    e = e11;
                    j12 = 0;
                    j13 = j14;
                    j11 = 0;
                }
            } else {
                backupOptionItem.setBackupData(false);
                j11 = 0;
                j12 = 0;
            }
            try {
                C11839m.m70688i(TAG, "getAppDataSize, appId: " + backupOptionItem.getAppId() + " uid: " + backupOptionItem.getUid() + ", dataSize = " + j13 + ", isBackupData: " + backupOptionItem.isBackupData());
            } catch (C9721b e12) {
                e = e12;
                C11839m.m70687e(TAG, "getAppDataSize error, msg: " + e.getMessage());
                backupOptionItem.setDataBytes(j13);
                backupOptionItem.setData2(String.valueOf(j12));
                backupOptionItem.setData3(String.valueOf(j11));
            }
        } catch (C9721b e13) {
            e = e13;
            j11 = 0;
            j12 = 0;
        }
        backupOptionItem.setDataBytes(j13);
        backupOptionItem.setData2(String.valueOf(j12));
        backupOptionItem.setData3(String.valueOf(j11));
    }

    public static void setOptionTaskComplete(boolean z10, boolean z11) {
        optionTaskComplete = z10;
        if (isCloudBackupTaskRunning || !z10 || z11) {
            return;
        }
        long jM81058g = C13465e.m81052f().m81058g("firstCloneTime", 0L);
        if (jM81058g == 0) {
            jM81058g = System.currentTimeMillis();
            C13465e.m81052f().m81065n("firstCloneTime", jM81058g);
        }
        C13465e.m81052f().m81064m("isFirstClone", jM81058g == 0);
    }

    private long updateDataSizeByLastRecord(final String str, long j10, int i10) {
        long singlePathMediaSize;
        int iCurrentTimeMillis;
        try {
            List list = (List) this.backupOptionSizes.stream().filter(new Predicate() { // from class: com.huawei.android.hicloud.cloudbackup.process.task.o0
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return GetOptionsInfoFromCloneTask.lambda$updateDataSizeByLastRecord$3(str, (BackupOptionSize) obj);
                }
            }).collect(Collectors.toList());
            if (list.size() == 0) {
                C11839m.m70686d(TAG, "not find appId from option sizes: " + str);
                return j10;
            }
            BackupOptionSize backupOptionSize = (BackupOptionSize) list.get(0);
            if (backupOptionSize != null && backupOptionSize.getSwitchState() != 0) {
                List<String> mediaPath = backupOptionSize.getMediaPath();
                long empirical = backupOptionSize.getEmpirical();
                long increase = backupOptionSize.getIncrease();
                long max = backupOptionSize.getMax();
                if (mediaPath == null || mediaPath.size() <= 0) {
                    singlePathMediaSize = 0;
                } else {
                    singlePathMediaSize = ("soundrecorder".equals(str) || "callRecorder".equals(str)) ? getSinglePathMediaSize(mediaPath) : getWholePathMediaSize(mediaPath);
                }
                C11839m.m70688i(TAG, "get om info, appId: " + str + ", empirical: " + (empirical / ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS) + " kb, increaseSize: " + (increase / ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS) + " kb, max: " + (max / ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS) + "kb, mediaSize: " + singlePathMediaSize);
                if (this.lastRecordModuleSize.size() != 0 && this.lastRecordModuleSize.containsKey(str)) {
                    CloudRestoreItem cloudRestoreItem = this.lastRecordModuleSize.get(str);
                    if (cloudRestoreItem != null && cloudRestoreItem.getSize() != 0) {
                        long size = cloudRestoreItem.getSize();
                        CloudRecoveryItem cloudRecoveryItem = this.cbRecoveryItem;
                        if (cloudRecoveryItem != null) {
                            long backupEndTime = cloudRecoveryItem.getBackupEndTime();
                            C11839m.m70686d(TAG, "get last backup time: " + backupEndTime);
                            iCurrentTimeMillis = (int) ((System.currentTimeMillis() - backupEndTime) / 86400000);
                        } else {
                            iCurrentTimeMillis = 0;
                        }
                        C11839m.m70686d(TAG, "get last record days: " + iCurrentTimeMillis + ", last size: " + (size / ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS) + " kb");
                        if (i10 <= 0 || size <= empirical) {
                            double dPow = 1.0d - Math.pow(0.999d, iCurrentTimeMillis);
                            long jLongValue = Double.valueOf(size * (1.0d + dPow)).longValue();
                            C11839m.m70688i(TAG, "get increase: " + dPow + ", size: " + (jLongValue / ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS) + " kb");
                            return jLongValue;
                        }
                        int count = cloudRestoreItem.getCount() > 0 ? cloudRestoreItem.getCount() : 1;
                        long j11 = empirical + ((i10 * (size - empirical)) / count);
                        C11839m.m70688i(TAG, "get size: " + (j11 / ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS) + " kb, count: " + i10 + ", last count: " + count);
                        return j11;
                    }
                    return getDataSizeByEmpiricalValue(i10, empirical, increase, max) + singlePathMediaSize;
                }
                return getDataSizeByEmpiricalValue(i10, empirical, increase, max) + singlePathMediaSize;
            }
            C11839m.m70686d(TAG, "switch is close, appId: " + str);
            return j10;
        } catch (Exception e10) {
            C11839m.m70688i(TAG, "update data size error: " + e10.toString());
            return j10;
        }
    }

    private void waitCountDownLatch(CountDownLatch countDownLatch) throws InterruptedException {
        if (countDownLatch == null) {
            return;
        }
        try {
            C11839m.m70688i(TAG, "await start, countDownLatch: " + countDownLatch.getCount());
            countDownLatch.await();
            C11839m.m70688i(TAG, "await end, countDownLatch: " + countDownLatch.getCount());
        } catch (InterruptedException e10) {
            C11839m.m70688i(TAG, "get backup module info downLatch await error: " + e10.toString());
        }
    }

    public static boolean waitOptionTaskEnd(Supplier<Boolean> supplier) {
        boolean zM75158X0 = C12515a.m75110o().m75158X0(GetOptionsInfoFromCloneTask.class.getName());
        while (zM75158X0) {
            SystemClock.sleep(400L);
            zM75158X0 = C12515a.m75110o().m75158X0(GetOptionsInfoFromCloneTask.class.getName());
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            Optional.ofNullable(supplier).ifPresent(new Consumer() { // from class: com.huawei.android.hicloud.cloudbackup.process.task.m0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    GetOptionsInfoFromCloneTask.lambda$waitOptionTaskEnd$0(atomicBoolean, (Supplier) obj);
                }
            });
            if (atomicBoolean.get()) {
                break;
            }
        }
        return zM75158X0;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        StringBuilder sb2;
        try {
            try {
                initConfig();
                optionTaskInitAppDataEnd = false;
                isCloudBackupTaskRunning = false;
                setOptionTaskComplete(false, this.isRefurbish);
                C11839m.m70688i(TAG, "GetOptionsInfoFromCloneTask start, option task complete: " + optionTaskComplete + " isRefurbish:" + this.isRefurbish);
                checkAndUpdateCbRecoveryItem();
                initSupportPmsMove();
                this.getDataStartTime = System.currentTimeMillis();
                C0221j.m1509s(getContext());
                C12526j c12526j = new C12526j();
                this.appBackupBlackList = c12526j.m75386e();
                C11839m.m70688i(TAG, "appBackupBlackList: " + this.appBackupBlackList);
                this.appBlackList.addAll(C2157a.m13200h());
                this.appBlackList.addAll(C14333b.m85454J());
                this.appBlackList.addAll(this.appBackupBlackList);
                if (this.isRefurbish) {
                    List<String> listM69970d = C11727h.m69967b().m69970d();
                    if (!listM69970d.isEmpty()) {
                        this.appBlackList.addAll(listM69970d);
                    }
                    List<String> listM69969c = C11727h.m69967b().m69969c();
                    if (!listM69969c.isEmpty()) {
                        this.appBlackList.addAll(listM69969c);
                    }
                    C11839m.m70688i(TAG, "unSafePackageName: " + listM69970d + "  unRecognizedPackageName " + listM69969c);
                }
                this.backupOptionSizes = c12526j.m75402k0();
                this.itemOperator.m78387h(this.appBackupBlackList);
                getBackupModuleInfo();
                this.itemOperator.m78387h(C12590s0.m75727B0());
                CloudBackupReport.reportSwitchBeans(this.beans, this.traceID, this.isRefurbish, false);
                recordTaskEndTime();
                sendMessageToUI(33010, null);
                setOptionTaskComplete(true, this.isRefurbish);
                CountDownLatch countDownLatch = this.taskCountDownLatch;
                if (countDownLatch != null) {
                    countDownLatch.countDown();
                }
                sb2 = new StringBuilder();
            } catch (C9721b e10) {
                C11839m.m70687e(TAG, "getOptionsInfoFromCloneTask run  error : " + e10.getMessage());
                reportCloneTaskException(e10);
                sendMessageToUI(33010, null);
                setOptionTaskComplete(true, this.isRefurbish);
                CountDownLatch countDownLatch2 = this.taskCountDownLatch;
                if (countDownLatch2 != null) {
                    countDownLatch2.countDown();
                }
                sb2 = new StringBuilder();
            } catch (Exception e11) {
                reportCloneTaskException(e11);
                sendMessageToUI(33010, null);
                setOptionTaskComplete(true, this.isRefurbish);
                CountDownLatch countDownLatch3 = this.taskCountDownLatch;
                if (countDownLatch3 != null) {
                    countDownLatch3.countDown();
                }
                sb2 = new StringBuilder();
            }
            sb2.append("GetOptionsInfoFromCloneTask end, option task complete: ");
            sb2.append(optionTaskComplete);
            C11839m.m70688i(TAG, sb2.toString());
        } catch (Throwable th2) {
            sendMessageToUI(33010, null);
            setOptionTaskComplete(true, this.isRefurbish);
            CountDownLatch countDownLatch4 = this.taskCountDownLatch;
            if (countDownLatch4 != null) {
                countDownLatch4.countDown();
            }
            C11839m.m70688i(TAG, "GetOptionsInfoFromCloneTask end, option task complete: " + optionTaskComplete);
            throw th2;
        }
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.OPTIONS_SIZE_TASK;
    }

    public String getLocation() {
        return C10279b.m63452a(getContext().getFilesDir());
    }

    public boolean isSupportSplitApp(String str) {
        C12534r c12534r = this.settingHelper;
        if (c12534r == null) {
            return false;
        }
        return c12534r.m75451m(str, this.isRefurbish ? "2" : "1");
    }

    public static void checkCacheInvalid(boolean z10) {
        long jM81057e = C13465e.m81052f().m81057e(z10);
        int iM75332E = new C12526j().m75332E();
        long jCurrentTimeMillis = System.currentTimeMillis() - jM81057e;
        boolean zM75158X0 = C12515a.m75110o().m75158X0(GetOptionsInfoFromCloneTask.class.getName());
        C11839m.m70686d(TAG, "checkCacheInvalid clientSizeCacheTime = " + jM81057e + " , millis: " + jCurrentTimeMillis + " currentTimeMillis = " + System.currentTimeMillis() + " isOptionTaskRunning = " + zM75158X0 + " clientSizeCache = " + iM75332E + " isRefurbish:" + z10);
        if (jCurrentTimeMillis > iM75332E * 3600000) {
            if (!zM75158X0) {
                C11839m.m70688i(TAG, "not use option cache, clientSizeCacheTime: " + jM81057e + " , millis: " + jCurrentTimeMillis);
                C12515a.m75110o().m75172d(new GetOptionsInfoFromCloneTask(z10, z10, cloudBackupUserInfo));
            }
            zM75158X0 = waitOptionTaskEnd(null);
        }
        if (z10) {
            while (zM75158X0) {
                SystemClock.sleep(400L);
                zM75158X0 = C12515a.m75110o().m75158X0(GetOptionsInfoFromCloneTask.class.getName());
            }
        }
        C11839m.m70686d(TAG, "checkCacheInvalid end");
    }

    public GetOptionsInfoFromCloneTask(boolean z10, boolean z11, CloudBackupUserInfo cloudBackupUserInfo2) {
        this(z10);
        if (!z10) {
            cloudBackupUserInfo = cloudBackupUserInfo2;
        }
        this.isForceRefresh = z11;
    }

    public GetOptionsInfoFromCloneTask(boolean z10, CloudBackupUserInfo cloudBackupUserInfo2) {
        this(z10);
        cloudBackupUserInfo = cloudBackupUserInfo2;
        this.needUpdateBackupIncreaseSize = true;
    }

    public GetOptionsInfoFromCloneTask(boolean z10, CloudBackupUserInfo cloudBackupUserInfo2, CountDownLatch countDownLatch) {
        this(z10, cloudBackupUserInfo2);
        this.taskCountDownLatch = countDownLatch;
    }
}
