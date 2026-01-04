package com.huawei.hicloud.cloudbackup.p104v3.core;

import am.C0257c1;
import am.C0306w0;
import am.InterfaceC0260d1;
import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.core.content.p019pm.PackageInfoCompat;
import cm.C1457c;
import com.google.gson.Gson;
import com.huawei.android.backup.filelogic.utils.PmsCheckUtil;
import com.huawei.android.hicloud.cloudbackup.bean.AbsThermalControl;
import com.huawei.android.hicloud.cloudbackup.bean.AppInfoList;
import com.huawei.android.hicloud.cloudbackup.bean.BackupDataAcptErrPolicy;
import com.huawei.android.hicloud.cloudbackup.bean.CloudBackup;
import com.huawei.android.hicloud.cloudbackup.broadcast.ICBBroadcastManager;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.jobscheduler.CloudBackupJobManager;
import com.huawei.android.hicloud.cloudbackup.manager.CloudBackupTaskManager;
import com.huawei.android.hicloud.cloudbackup.p076db.bean.Settings;
import com.huawei.android.hicloud.cloudbackup.p076db.operator.SettingOperator;
import com.huawei.android.hicloud.cloudbackup.process.BackupPowerKitKeepTimer;
import com.huawei.android.hicloud.cloudbackup.process.CBAccess;
import com.huawei.android.hicloud.cloudbackup.process.CacheTask;
import com.huawei.android.hicloud.cloudbackup.process.CloneService;
import com.huawei.android.hicloud.cloudbackup.process.RestoreUtil;
import com.huawei.android.hicloud.cloudbackup.process.notification.CloudBackupSuccessNotifyTask;
import com.huawei.android.hicloud.cloudbackup.process.task.CloudBackupCreateManager;
import com.huawei.android.hicloud.cloudbackup.process.task.GetOptionsInfoFromCloneTask;
import com.huawei.android.hicloud.cloudbackup.process.util.BackupCacheRecord;
import com.huawei.android.hicloud.cloudbackup.process.util.BackupRestoreUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.CloudBackupConditionsUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.ICycleChecker;
import com.huawei.android.hicloud.cloudbackup.process.util.PmsUtils;
import com.huawei.android.hicloud.cloudbackup.process.util.ProgressCallback;
import com.huawei.android.hicloud.cloudbackup.process.util.ThermalChecker;
import com.huawei.android.hicloud.cloudbackup.report.CloudBackupReport;
import com.huawei.android.hicloud.cloudbackup.report.MobileTrafficReport;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.SnapshotDBManager;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackupStateUtil;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.notification.BackupNotification;
import com.huawei.android.hicloud.p088ui.notification.BackupNotificationManager;
import com.huawei.android.hicloud.security.service.UserKeyUtils;
import com.huawei.android.p073ds.R$string;
import com.huawei.android.remotecontrol.tag.p092ui.view.RippleView;
import com.huawei.cloud.base.util.C4644l;
import com.huawei.hicloud.base.bean.CloudSpace;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.base.drive.model.ErrorResp;
import com.huawei.hicloud.bean.FirstTimeOverview;
import com.huawei.hicloud.cloudbackup.obsever.CloudBackupBackgroundService;
import com.huawei.hicloud.cloudbackup.p104v3.core.C4879a;
import com.huawei.hicloud.cloudbackup.p104v3.core.ICBBaseV3Task;
import com.huawei.hicloud.cloudbackup.p104v3.omconfig.model.OMFilterModule;
import com.huawei.hicloud.cloudbackup.p104v3.omconfig.model.SyncSwitchBackupInfo;
import com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request;
import com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Server;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.About;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.App;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.AppList;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.BakRefresh;
import com.huawei.hicloud.cloudbackup.p104v3.server.request.Bak;
import com.huawei.hicloud.cloudbackup.p104v3.task.BackupLoadController;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudBackupStatus;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notificationv2.bean.C4972b;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.request.cbs.bean.CBSBaseReq;
import com.huawei.hicloud.request.cbs.bean.CBSbkFlowHead;
import com.huawei.openalliance.p169ad.constant.VastAttribute;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import fk.C9721b;
import gm.C10013v;
import gm.C10014w;
import gm.C9989d;
import gn.InterfaceC10020c;
import gp.C10028c;
import hk.C10278a;
import hk.C10279b;
import hm.C10321z;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.Consumer;
import java.util.function.Predicate;
import je.C10782d;
import mk.C11476b;
import om.C11963c;
import om.C11965e;
import org.json.JSONException;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0214f0;
import p015ak.C0219i;
import p015ak.C0224k0;
import p015ak.C0226l0;
import p015ak.C0241z;
import p292fn.C9733f;
import p336he.C10152c;
import p336he.C10153d;
import p384j4.AbstractC10705d;
import p429kk.C11058a;
import p429kk.C11060c;
import p456lm.C11315b;
import p495nm.C11723d;
import p495nm.C11726g;
import p495nm.C11730k;
import p514o9.C11839m;
import p523oi.C11903a;
import p529op.C11979a;
import p571q9.C12294a;
import p572qb.C12299b;
import p582ql.C12371b;
import p616rk.C12515a;
import p617rl.C12519c;
import p617rl.C12526j;
import p617rl.C12534r;
import p618rm.C12540b1;
import p618rm.C12571m;
import p618rm.C12574n;
import p618rm.C12583q;
import p618rm.C12585q1;
import p618rm.C12586r;
import p618rm.C12590s0;
import p618rm.C12591s1;
import p618rm.C12592t;
import p618rm.C12594t1;
import p618rm.C12600v1;
import p652t9.EnumC12999a;
import p664u0.C13108a;
import p674ub.C13148e;
import p682ul.C13216j;
import p684un.C13225d;
import p709vj.C13452e;
import p711vl.C13462b;
import p711vl.C13465e;
import p711vl.C13466f;
import p711vl.C13467g;
import p744wl.C13617a;
import p746wn.C13622a;
import p779xl.InterfaceC13828a;
import p814yl.C13998b0;
import p814yl.C14000c0;
import p840zd.C14189a2;
import p847zk.C14311d;
import p847zk.C14317j;
import p848zl.C14333b;
import p848zl.C14341j;
import pm.C12182i;
import pm.C12199z;
import pm.InterfaceC12198y;
import sl.C12814e;
import sl.C12815f;
import tl.C13027f;
import tl.C13028g;
import tl.C13029h;
import tl.C13030i;
import to.C13049a;

@InterfaceC13828a(controller = BackupLoadController.class)
/* renamed from: com.huawei.hicloud.cloudbackup.v3.core.a */
/* loaded from: classes6.dex */
public class C4879a extends ICBBaseV3Task {

    /* renamed from: B0 */
    public static final List<String> f22434B0 = Collections.unmodifiableList(Arrays.asList("28:No space left on device", "Sqlite code 13 SQLITE_FULL"));

    /* renamed from: C0 */
    public static final Object f22435C0 = new Object();

    /* renamed from: A */
    public boolean f22436A;

    /* renamed from: A0 */
    public int f22437A0;

    /* renamed from: B */
    public int f22438B;

    /* renamed from: C */
    public boolean f22439C;

    /* renamed from: D */
    public volatile int f22440D;

    /* renamed from: E */
    public List<Bak> f22441E;

    /* renamed from: F */
    public List<Bak> f22442F;

    /* renamed from: G */
    public final Map<String, List<App>> f22443G;

    /* renamed from: H */
    public C1457c f22444H;

    /* renamed from: I */
    public C9989d f22445I;

    /* renamed from: J */
    public C10013v f22446J;

    /* renamed from: K */
    public final String f22447K;

    /* renamed from: L */
    public final String f22448L;

    /* renamed from: M */
    public boolean f22449M;

    /* renamed from: N */
    public int f22450N;

    /* renamed from: O */
    public final C13028g f22451O;

    /* renamed from: P */
    public long f22452P;

    /* renamed from: Q */
    public CloudSpace f22453Q;

    /* renamed from: R */
    public final String f22454R;

    /* renamed from: S */
    public String f22455S;

    /* renamed from: T */
    public String f22456T;

    /* renamed from: U */
    public final int f22457U;

    /* renamed from: V */
    public Handler f22458V;

    /* renamed from: W */
    public C13029h f22459W;

    /* renamed from: X */
    public List<OMFilterModule> f22460X;

    /* renamed from: Y */
    public final Set<String> f22461Y;

    /* renamed from: Z */
    public final Map<CloudBackupStatus, String> f22462Z;

    /* renamed from: a0 */
    public final Map<CloudBackupStatus, C9721b> f22463a0;

    /* renamed from: b0 */
    public boolean f22464b0;

    /* renamed from: c0 */
    public int f22465c0;

    /* renamed from: d0 */
    public final ReadWriteLock f22466d0;

    /* renamed from: e0 */
    public C11730k f22467e0;

    /* renamed from: f0 */
    public double f22468f0;

    /* renamed from: g0 */
    public double f22469g0;

    /* renamed from: h0 */
    public boolean f22470h0;

    /* renamed from: i0 */
    public boolean f22471i0;

    /* renamed from: j0 */
    public boolean f22472j0;

    /* renamed from: k */
    public InterfaceC0260d1 f22473k;

    /* renamed from: k0 */
    public boolean f22474k0;

    /* renamed from: l */
    public Integer f22475l;

    /* renamed from: l0 */
    public long f22476l0;

    /* renamed from: m */
    public Integer f22477m;

    /* renamed from: m0 */
    public boolean f22478m0;

    /* renamed from: n */
    public Integer f22479n;

    /* renamed from: n0 */
    public Set<String> f22480n0;

    /* renamed from: o */
    public boolean f22481o;

    /* renamed from: o0 */
    public String f22482o0;

    /* renamed from: p */
    public final boolean f22483p;

    /* renamed from: p0 */
    public boolean f22484p0;

    /* renamed from: q */
    public long f22485q;

    /* renamed from: q0 */
    public boolean f22486q0;

    /* renamed from: r */
    public String f22487r;

    /* renamed from: r0 */
    public boolean f22488r0;

    /* renamed from: s */
    public boolean f22489s;

    /* renamed from: s0 */
    public List<String> f22490s0;

    /* renamed from: t */
    public boolean f22491t;

    /* renamed from: t0 */
    public int f22492t0;

    /* renamed from: u */
    public boolean f22493u;

    /* renamed from: u0 */
    public String f22494u0;

    /* renamed from: v */
    public boolean f22495v;

    /* renamed from: v0 */
    public BackupDataAcptErrPolicy f22496v0;

    /* renamed from: w */
    public boolean f22497w;

    /* renamed from: w0 */
    public List<C11723d> f22498w0;

    /* renamed from: x */
    public final String f22499x;

    /* renamed from: x0 */
    public C12534r f22500x0;

    /* renamed from: y */
    public boolean f22501y;

    /* renamed from: y0 */
    public boolean f22502y0;

    /* renamed from: z */
    public long f22503z;

    /* renamed from: z0 */
    public boolean f22504z0;

    public C4879a(boolean z10, String str, boolean z11) {
        this(z10, z10 ? "auto" : CBSbkFlowHead.BKMODE_MANUAL, str, null, z11);
    }

    /* renamed from: A1 */
    public static /* synthetic */ void m29603A1(Map map, App app) {
        map.put(app.getBackupAppName(), app);
    }

    /* renamed from: B1 */
    public static /* synthetic */ boolean m29604B1(Bak bak) {
        return bak.getBmDataType().intValue() == 1;
    }

    /* renamed from: E1 */
    public static /* synthetic */ void m29608E1(Map map, AppInfoList appInfoList) {
        CloudBackup cloudBackup = appInfoList.getCloudBackup();
        int minClientVersion = appInfoList.getMinClientVersion();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(minClientVersion);
        sb2.append(",");
        if (cloudBackup != null) {
            sb2.append(cloudBackup.getOsVersRegex());
            sb2.append(",");
            sb2.append(cloudBackup.getEffectDevice());
            sb2.append(",");
            sb2.append(cloudBackup.getEffectPackage());
            sb2.append(",");
        }
        map.put("refurbishSet", sb2.toString());
    }

    /* renamed from: F1 */
    public static /* synthetic */ void m29610F1(final Map map, List list) {
        list.stream().findFirst().ifPresent(new Consumer() { // from class: am.h
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                C4879a.m29608E1(map, (AppInfoList) obj);
            }
        });
    }

    /* renamed from: G2 */
    private void m29612G2(final int i10) {
        C0226l0.m1584d(new Runnable() { // from class: am.j
            @Override // java.lang.Runnable
            public final void run() {
                C4879a.m29617J1(i10);
            }
        });
    }

    /* renamed from: I1 */
    public static /* synthetic */ void m29615I1() throws JSONException {
        SystemClock.sleep(1000L);
        UBAAnalyze.m29942C();
    }

    /* renamed from: J1 */
    public static /* synthetic */ void m29617J1(int i10) {
        if (CacheTask.getContext() != null) {
            Toast.makeText(CacheTask.getContext(), i10, 1).show();
        } else {
            C11839m.m70688i("CloudBackupV3Task", "show toast tips, getContext is null");
        }
    }

    /* renamed from: y1 */
    public static /* synthetic */ boolean m29623y1(ICycleChecker iCycleChecker) {
        return !"1".equals(iCycleChecker.getType());
    }

    /* renamed from: A0 */
    public Map<String, App> m29624A0() {
        List<App> list;
        final HashMap map = new HashMap();
        if (C12590s0.m75873l1(m29631D0()) && (list = m29704f0().get(m29628C0())) != null) {
            list.forEach(new Consumer() { // from class: am.l
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    C4879a.m29603A1(map, (App) obj);
                }
            });
        }
        return map;
    }

    /* renamed from: A2 */
    public void m29625A2(boolean z10) {
        this.f22504z0 = z10;
    }

    /* renamed from: B0 */
    public Integer m29626B0() {
        Integer bmDataType = !m29645J0().isEmpty() ? m29645J0().get(0).getBmDataType() : null;
        C11839m.m70688i("CloudBackupV3Task", "get last success bak bmType: " + bmDataType);
        return bmDataType;
    }

    /* renamed from: B2 */
    public void m29627B2(boolean z10) {
        this.f22495v = z10;
    }

    /* renamed from: C0 */
    public String m29628C0() {
        if (m29699d1() || isRefurbishment()) {
            C11839m.m70688i("CloudBackupV3Task", "getLastSuccessBackupId isFullBK. get last success bak id null");
            return "";
        }
        String id2 = m29645J0().isEmpty() ? "" : m29645J0().get(0).getId();
        C11839m.m70688i("CloudBackupV3Task", "get last success bak id: " + id2);
        return id2;
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Bak$App$List] */
    /* renamed from: C1 */
    public final /* synthetic */ CloudBackupV3Request m29629C1(String str, String str2, String str3, String str4, CloudBackupV3Server cloudBackupV3Server) throws IOException {
        Bak.App.List list = cloudBackupV3Server.backup().device().bak().app().list();
        list.setFields(str).setHeader("x-hw-masking-apps-version", (Object) "V1").setHeader("x-hw-appduplicator", (Object) "1").setBackupAction(this.f22487r).setBackupDeviceId(this.f22455S).setBakId(str2).setLockId(str3).setCursor(str4).setXHwBackupid(str2).setPageSize(100).setUsage(SnapshotDBManager.PREFIX_DATABASE_NAME);
        return list;
    }

    /* renamed from: C2 */
    public void m29630C2(String str) {
        this.f22482o0 = str;
    }

    /* renamed from: D0 */
    public String m29631D0() {
        String backupVersion = !m29645J0().isEmpty() ? m29645J0().get(0).getBackupVersion() : "";
        C11839m.m70688i("CloudBackupV3Task", "get last success bak version: " + backupVersion);
        return backupVersion;
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Bak$App$List] */
    /* renamed from: D1 */
    public final /* synthetic */ CloudBackupV3Request m29632D1(String str, String str2, String str3, String str4, CloudBackupV3Server cloudBackupV3Server) throws IOException {
        Bak.App.List list = cloudBackupV3Server.backup().device().bak().app().list();
        list.setFields(str).setHeader("x-hw-masking-apps-version", (Object) "V1").setHeader("x-hw-appduplicator", (Object) "1").setHeader("x-hw-query-lost", (Object) Boolean.TRUE).setBackupAction(this.f22487r).setBackupDeviceId(this.f22455S).setBakId(str2).setLockId(str3).setCursor(str4).setXHwBackupid(str2).setPageSize(100).setUsage(SnapshotDBManager.PREFIX_DATABASE_NAME);
        return list;
    }

    /* renamed from: D2 */
    public final void m29633D2() {
        if (C0209d.m1269j1() || !C0219i.m1466d()) {
            C11839m.m70688i("CloudBackupV3Task", "startBackupBackgroundService rom is honor or os less then 4.0");
            return;
        }
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(new Intent());
        hiCloudSafeIntent.setClass(CacheTask.getContext(), CloudBackupBackgroundService.class);
        hiCloudSafeIntent.setAction("com.huawei.hicloud.cloudbackup.service.cloudbackupbackgroundservice");
        try {
            CacheTask.getContext().startService(hiCloudSafeIntent);
            C11839m.m70688i("CloudBackupV3Task", "startBackupBackGroundService");
        } catch (Throwable th2) {
            C11839m.m70688i("CloudBackupV3Task", "startBackupBackGroundService error: " + th2);
        }
    }

    /* renamed from: E0 */
    public final long m29634E0() {
        CloudSpace cloudSpace = this.f22453Q;
        if (cloudSpace == null) {
            return 0L;
        }
        return cloudSpace.getTotal() - this.f22453Q.getUsed();
    }

    /* renamed from: E2 */
    public void m29635E2(C13029h c13029h, String str, boolean z10) {
        String strM78465h;
        String strM75786Q;
        int iM78476r;
        long jCurrentTimeMillis;
        String strM62098a0 = this.f22446J.m62098a0();
        int iM1685c = 0;
        if (c13029h == null || "empty_default_id".equals(c13029h.m78465h())) {
            strM78465h = null;
            strM75786Q = str;
            iM78476r = 0;
            jCurrentTimeMillis = 0;
        } else {
            strM78465h = c13029h.m78465h();
            strM75786Q = C12590s0.m75786Q(c13029h);
            iM78476r = c13029h.m78476r() + 1;
            jCurrentTimeMillis = (System.currentTimeMillis() - c13029h.m78466i()) / 1000;
            if (!TextUtils.isEmpty(c13029h.m78480t())) {
                iM1685c = C0241z.m1685c(c13029h.m78480t());
            }
        }
        if (jCurrentTimeMillis < 0) {
            jCurrentTimeMillis = 0;
        }
        CBAccess.startDeleteTask(new C0306w0(this.f22454R, strM78465h, strM75786Q, iM78476r, jCurrentTimeMillis, this.f22487r, this.f22457U, this.f22483p ? 1 : 0, this.f22499x, z10, this.f22446J.m62096Z(), strM62098a0, String.valueOf(iM1685c)));
    }

    /* renamed from: F0 */
    public Integer m29636F0() {
        return this.f22475l;
    }

    /* renamed from: F2 */
    public final void m29637F2() {
        if (C0209d.m1269j1() || !C0219i.m1466d()) {
            C11839m.m70688i("CloudBackupV3Task", "stopBackupBackgroundService rom is honor or os less then 4.0");
            return;
        }
        try {
            CacheTask.getContext().stopService(new HiCloudSafeIntent(new Intent(CacheTask.getContext(), (Class<?>) CloudBackupBackgroundService.class)));
            C11839m.m70688i("CloudBackupV3Task", "stopBackupBackGroundService");
        } catch (Throwable th2) {
            C11839m.m70688i("CloudBackupV3Task", "stopBackupBackgroundService error: " + th2);
        }
    }

    /* renamed from: G0 */
    public double m29638G0() {
        return this.f22468f0;
    }

    /* renamed from: G1 */
    public final /* synthetic */ void m29639G1(int i10, int i11) {
        C11839m.m70688i("CloudBackupV3Task", "thermal callback,resType is:" + i11 + ",level is:" + i10);
        if ((i11 == 1 || i11 == 17) && ThermalChecker.matchThermalControlDevice(false)) {
            C11839m.m70688i("CloudBackupV3Task", "ThermalCallback matchThermalControlDevice");
            this.f22438B = i10;
            if (ThermalChecker.isThermalControlByMain(i10, true)) {
                return;
            }
            abort(1030);
        }
    }

    /* renamed from: H0 */
    public long m29640H0() {
        return this.f22485q;
    }

    /* renamed from: H1 */
    public final /* synthetic */ void m29641H1(int i10, int i11) {
        if (i11 == 16) {
            C11839m.m70688i("CloudBackupV3Task", "uniSchedule callback,resType is:" + i11 + ",level is:" + i10);
            if (ThermalChecker.isUniSchedulerControlByMain(i10)) {
                return;
            }
            C11839m.m70688i("CloudBackupV3Task", "ThermalCallback  isUniSchedulerControlByMain");
            if (CloudBackupConditionsUtil.isScreenOn()) {
                C11839m.m70688i("CloudBackupV3Task", "screenOn,high load doAbort");
                m29581c(1006, "high load doAbort", null);
            }
        }
    }

    /* renamed from: H2 */
    public void m29642H2(String str, long j10) {
        CloudSpace cloudSpace = this.f22453Q;
        if (cloudSpace == null) {
            C11839m.m70688i("CloudBackupV3Task", "update used size return, space is null.");
            return;
        }
        long used = cloudSpace.getUsed();
        if (used >= j10) {
            this.f22453Q.setUsed(used - j10);
            C11839m.m70688i("CloudBackupV3Task", "appId: " + str + ", used size: " + used + ", free size: " + j10);
        }
    }

    /* renamed from: I0 */
    public CloudSpace m29643I0() throws C9721b {
        CloudSpace cloudSpace;
        synchronized (f22435C0) {
            if (this.f22453Q == null) {
                try {
                    this.f22453Q = m29675V0();
                } catch (C9721b e10) {
                    C11839m.m70688i("CloudBackupV3Task", "autoBackup:" + this.f22483p + ",manualBypassOnFault:" + this.f22488r0);
                    if (this.f22483p || !this.f22488r0) {
                        throw e10;
                    }
                    C11839m.m70688i("CloudBackupV3Task", "return default space.");
                    this.f22453Q = new CloudSpace();
                }
            }
            cloudSpace = this.f22453Q;
        }
        return cloudSpace;
    }

    /* renamed from: I2 */
    public final void m29644I2() throws InterruptedException, C9721b {
        C11839m.m70688i("CloudBackupV3Task", "waitTempBackupOptionTask start");
        while (C12515a.m75110o().m75158X0(C14189a2.class.getName())) {
            isCancel();
            SystemClock.sleep(1000L);
        }
        C11839m.m70688i("CloudBackupV3Task", "waitTempBackupOptionTask end");
    }

    /* renamed from: J0 */
    public List<com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak> m29645J0() {
        return this.f22441E;
    }

    /* renamed from: K0 */
    public List<com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak> m29646K0() {
        return this.f22442F;
    }

    /* renamed from: K1 */
    public final AppList m29647K1(final String str, final String str2, final String str3) throws C9721b {
        final String str4 = "nextCursor,apps(id,backupAppName,apkType,runtimeType,oriBackupAppName,splitApkType,backupAppStatus,appTotalSize,fileCount,packageVersion,createTime,updateTime,endTime,properties,attachments(assetId,usage,state,hash,versionId,sha256),splitApkType)";
        return (AppList) new C14000c0(new C14000c0.a() { // from class: am.i
            @Override // p814yl.C14000c0.a
            /* renamed from: a */
            public final CloudBackupV3Request mo1697a(CloudBackupV3Server cloudBackupV3Server) {
                return this.f947a.m29629C1(str4, str, str3, str2, cloudBackupV3Server);
            }
        }).m84139b("Backup.device.bak.apps.list", this.f22499x);
    }

    /* renamed from: L0 */
    public boolean m29648L0() {
        return this.f22470h0;
    }

    /* renamed from: L1 */
    public List<App> m29649L1(String str, String str2) throws InterruptedException, C9721b {
        isCancel();
        AppList appListM29647K1 = m29647K1(str, null, str2);
        ArrayList arrayList = new ArrayList(appListM29647K1.getApps());
        String nextCursor = appListM29647K1.getNextCursor();
        while (nextCursor != null && !nextCursor.isEmpty()) {
            isCancel();
            AppList appListM29647K12 = m29647K1(str, nextCursor, str2);
            arrayList.addAll(appListM29647K12.getApps());
            nextCursor = appListM29647K12.getNextCursor();
        }
        return arrayList;
    }

    /* renamed from: M0 */
    public boolean m29650M0() {
        return this.f22471i0;
    }

    /* renamed from: M1 */
    public final AppList m29651M1(final String str, final String str2, final String str3) throws C9721b {
        final String str4 = "nextCursor,apps(id,backupAppName,apkType,runtimeType,backupAppStatus,appTotalSize,fileCount,packageVersion,createTime,updateTime,endTime,properties,attachments(assetId,usage,state,hash,versionId,sha256),splitApkType)";
        return (AppList) new C14000c0(new C14000c0.a() { // from class: am.m
            @Override // p814yl.C14000c0.a
            /* renamed from: a */
            public final CloudBackupV3Request mo1697a(CloudBackupV3Server cloudBackupV3Server) {
                return this.f961a.m29632D1(str4, str, str3, str2, cloudBackupV3Server);
            }
        }).m84139b("Backup.device.bak.apps.list", this.f22499x);
    }

    /* renamed from: N0 */
    public double m29652N0() {
        return this.f22469g0;
    }

    /* renamed from: N1 */
    public List<App> m29653N1(String str) throws InterruptedException, C9721b {
        isCancel();
        com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak bak = this.f22446J.f48960n;
        if (bak == null || !C12590s0.m75873l1(bak.getBackupVersion())) {
            return new ArrayList();
        }
        String id2 = this.f22446J.f48960n.getId();
        AppList appListM29651M1 = m29651M1(id2, null, str);
        ArrayList arrayList = new ArrayList(appListM29651M1.getApps());
        String nextCursor = appListM29651M1.getNextCursor();
        while (nextCursor != null && !nextCursor.isEmpty()) {
            isCancel();
            AppList appListM29651M12 = m29651M1(id2, nextCursor, str);
            arrayList.addAll(appListM29651M12.getApps());
            nextCursor = appListM29651M12.getNextCursor();
        }
        return arrayList;
    }

    /* renamed from: O0 */
    public String m29654O0() {
        return this.f22499x;
    }

    /* renamed from: O1 */
    public void m29655O1() {
        this.f22452P = 0L;
    }

    /* renamed from: P */
    public void m29656P(CloudBackupStatus cloudBackupStatus, C9721b c9721b) {
        this.f22463a0.put(cloudBackupStatus, c9721b);
    }

    /* renamed from: P0 */
    public String m29657P0() {
        return this.f22482o0;
    }

    /* renamed from: P1 */
    public final void m29658P1(Handler handler) {
        CloudBackupConditionsUtil.ChargeAttr chargeAttr = CloudBackupConditionsUtil.getChargeAttr();
        boolean zIsCharging = chargeAttr.isCharging();
        boolean z10 = CloudBackupConditionsUtil.isConfigureBatteryChanger() && CloudBackupConditionsUtil.isSmartCharging(chargeAttr);
        C11839m.m70688i("CloudBackupV3Task", "isCharging: " + zIsCharging + ", isSmartCharging: " + z10);
        if (zIsCharging || z10) {
            handler.removeMessages(3204);
            C11839m.m70688i("CloudBackupV3Task", "removeMessages ACTION_SCREEN_OFF");
            this.f22440D = 0;
        }
    }

    /* renamed from: Q */
    public void m29659Q(CloudBackupStatus cloudBackupStatus, String str) {
        this.f22462Z.put(cloudBackupStatus, str);
    }

    /* renamed from: Q0 */
    public final void m29660Q0() {
        if (!C9733f.m60705z().m60720O("backupDataAcptErrPolicy")) {
            C11839m.m70687e("CloudBackupV3Task", "initBackupDataAcptErrPolicy featureSwitchOpen close");
            return;
        }
        String strM60762u = C9733f.m60705z().m60762u("backupDataAcptErrPolicy");
        if (TextUtils.isEmpty(strM60762u)) {
            C11839m.m70687e("CloudBackupV3Task", "initBackupDataAcptErrPolicy parameters is empty");
            return;
        }
        try {
            BackupDataAcptErrPolicy backupDataAcptErrPolicy = (BackupDataAcptErrPolicy) new Gson().fromJson(strM60762u, BackupDataAcptErrPolicy.class);
            if (backupDataAcptErrPolicy == null) {
                C11839m.m70687e("CloudBackupV3Task", "backupDataAcptErrPolicy is null");
                return;
            }
            this.f22496v0 = backupDataAcptErrPolicy;
            C11839m.m70686d("CloudBackupV3Task", "initBackupDataAcptErrPolicy: " + this.f22496v0);
        } catch (Exception e10) {
            C11839m.m70687e("CloudBackupV3Task", "initBackupDataAcptErrPolicy error: " + e10.getMessage());
        }
    }

    /* renamed from: Q1 */
    public final void m29661Q1(Handler handler) {
        CloudBackupConditionsUtil.ChargeAttr chargeAttr = CloudBackupConditionsUtil.getChargeAttr();
        boolean zIsCharging = chargeAttr.isCharging();
        boolean z10 = CloudBackupConditionsUtil.isConfigureBatteryChanger() && CloudBackupConditionsUtil.isSmartCharging(chargeAttr);
        C11839m.m70688i("CloudBackupV3Task", "isCharging: " + zIsCharging + ", isSmartCharging: " + z10);
        if (!zIsCharging && !z10) {
            abort(1006);
            handler.removeMessages(3204);
            return;
        }
        this.f22465c0++;
        Message messageObtain = Message.obtain(handler, 3204, 1, 0);
        long jM75338H = new C12526j().m75338H(new SettingOperator().querybreakedtime());
        handler.sendMessageDelayed(messageObtain, jM75338H);
        C11839m.m70688i("CloudBackupV3Task", "sendMessageDelayed isUserPresent, isCharging, break time = " + jM75338H);
    }

    /* renamed from: R */
    public final void m29662R(final String str, final String str2) {
        executeAsyncTask(new CacheTask.AsyncTask(new CacheTask.IAsyncTask() { // from class: am.f
            @Override // com.huawei.android.hicloud.cloudbackup.process.CacheTask.IAsyncTask
            public final void run() {
                this.f934a.m29759x1(str, str2);
            }
        }));
    }

    /* renamed from: R0 */
    public void m29663R0() {
        try {
            this.f22453Q = new C13049a(EnumC12999a.CLOUD_BACKUP, this.f22499x).m78754r();
        } catch (C9721b e10) {
            C11839m.m70687e("CloudBackupV3Task", "init cloud space error: " + e10.toString());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.Closeable] */
    /* renamed from: R1 */
    public final boolean m29664R1() {
        FileOutputStream fileOutputStream;
        Context contextM1378b = C0213f.m1378b();
        ?? cacheDir = contextM1378b.getCacheDir();
        String strM63452a = C10279b.m63452a(cacheDir);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f22447K);
        String str = File.separator;
        sb2.append(str);
        sb2.append("filter.txt");
        String string = sb2.toString();
        File fileM63442h = C10278a.m63442h(string);
        File fileM63442h2 = C10278a.m63442h(this.f22447K);
        if (!fileM63442h2.exists() && !fileM63442h2.mkdirs()) {
            C11839m.m70689w("CloudBackupV3Task", "pmsSupportGetBriefCmd location init error, " + this.f22447K);
        }
        if (fileM63442h.exists() && !fileM63442h.delete()) {
            C11839m.m70687e("CloudBackupV3Task", "pmsSupportGetBriefCmd delete byfile error: " + fileM63442h.getName());
            return false;
        }
        try {
            try {
                try {
                    if (!fileM63442h.createNewFile()) {
                        C11839m.m70687e("CloudBackupV3Task", "pmsSupportGetBriefCmd byfile error");
                        C0209d.m1263i(null);
                        return false;
                    }
                    if (fileM63442h.exists()) {
                        C11839m.m70688i("CloudBackupV3Task", "pmsSupportGetBriefCmd byFile: " + C10279b.m63452a(cacheDir));
                    }
                    fileOutputStream = new FileOutputStream(fileM63442h);
                    try {
                        fileOutputStream.write(("[include]" + strM63452a + "\n").getBytes(StandardCharsets.UTF_8));
                        C0209d.m1263i(fileOutputStream);
                        String str2 = getLocation() + str + "com.huawei.hidisk.txt";
                        if (new BackupRestoreUtil(contextM1378b, new ProgressCallback(), getLocation()).getBrief(CloudBackupConstant.Command.PMS_OPTION_FILE, string, str2) == -3) {
                            C11839m.m70688i("CloudBackupV3Task", "PMS not support get biref cmd");
                            C12571m.m75547i(string);
                            if (TextUtils.isEmpty(str2)) {
                                C12571m.m75547i(str2);
                            }
                            return false;
                        }
                        C11839m.m70688i("CloudBackupV3Task", "PMS support get biref cmd");
                        C12571m.m75547i(string);
                        if (!TextUtils.isEmpty(str2)) {
                            return true;
                        }
                        C12571m.m75547i(str2);
                        return true;
                    } catch (FileNotFoundException e10) {
                        e = e10;
                        C11839m.m70687e("CloudBackupV3Task", "pmsSupportGetBriefCmd FileNotFoundException: " + e.getMessage());
                        C0209d.m1263i(fileOutputStream);
                        C12571m.m75547i(string);
                        if (TextUtils.isEmpty(null)) {
                            C12571m.m75547i(null);
                        }
                        return false;
                    } catch (IOException e11) {
                        e = e11;
                        C11839m.m70687e("CloudBackupV3Task", "pmsSupportGetBriefCmd IOException: " + e.getMessage());
                        C0209d.m1263i(fileOutputStream);
                        C12571m.m75547i(string);
                        if (TextUtils.isEmpty(null)) {
                            C12571m.m75547i(null);
                        }
                        return false;
                    }
                } catch (FileNotFoundException e12) {
                    e = e12;
                    fileOutputStream = null;
                } catch (IOException e13) {
                    e = e13;
                    fileOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    cacheDir = 0;
                    C0209d.m1263i(cacheDir);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                C0209d.m1263i(cacheDir);
                throw th;
            }
        } finally {
            C12571m.m75547i(string);
            if (TextUtils.isEmpty(null)) {
                C12571m.m75547i(null);
            }
        }
    }

    /* renamed from: S */
    public final void m29665S() {
        if (isAutoBackup()) {
            C11839m.m70688i("CloudBackupV3Task", "check auto backup contion");
            CloudBackupConditionsUtil.ChargeAttr chargeAttr = CloudBackupConditionsUtil.getChargeAttr();
            boolean zIsCharging = chargeAttr.isCharging();
            boolean z10 = CloudBackupConditionsUtil.isConfigureBatteryChanger() && CloudBackupConditionsUtil.isSmartCharging(chargeAttr);
            C11839m.m70688i("CloudBackupV3Task", "checkAutoBackupContion: isAttrCharging: " + zIsCharging + ", isSmartCharging: " + z10);
            boolean z11 = zIsCharging || z10;
            if (!z11) {
                C11839m.m70688i("CloudBackupV3Task", "checkAutoBackupContion: action power disconnect");
                abort(1005);
            }
            boolean zIsScreenOn = CloudBackupConditionsUtil.isScreenOn();
            if (zIsScreenOn) {
                if (zIsCharging || z10) {
                    Message messageObtain = Message.obtain(this.f22458V, 3204, 1, 0);
                    long jM75338H = new C12526j().m75338H(new SettingOperator().querybreakedtime());
                    C11839m.m70688i("CloudBackupV3Task", "checkAutoBackupContion: sendMessageDelayed isUserPresent, isCharging, break time = " + jM75338H);
                    Handler handler = this.f22458V;
                    if (handler == null) {
                        C11839m.m70688i("CloudBackupV3Task", "sendMessageDelayed isUserPresent, handler is null");
                        return;
                    }
                    handler.sendMessageDelayed(messageObtain, jM75338H);
                } else {
                    C11839m.m70688i("CloudBackupV3Task", "checkAutoBackupContion: abort CBError.AUTOBACKUP_USER_PRESENT_ABORT");
                    abort(1006);
                    Handler handler2 = this.f22458V;
                    if (handler2 != null) {
                        handler2.removeMessages(3204);
                    }
                }
            }
            if (!z11 || zIsScreenOn) {
                return;
            }
            C11839m.m70688i("CloudBackupV3Task", "checkAutoBackupContion: set abnormalAutobackupCondition false");
            this.f22440D = 0;
        }
    }

    /* renamed from: S0 */
    public final void m29666S0() {
        C12526j c12526j = new C12526j();
        C11730k c11730k = new C11730k();
        this.f22467e0 = c11730k;
        c11730k.m69999j(c12526j.m75352O());
        this.f22467e0.m70000k(c12526j.m75362T());
        this.f22467e0.m70001l(c12526j.m75364U());
        this.f22467e0.m70002m(c12526j.m75377a1());
        this.f22467e0.m70003n(c12526j.m75370X());
        this.f22467e0.m70004o(c12526j.m75376a0());
        this.f22467e0.m70005p(c12526j.m75378b0());
        this.f22467e0.m70006q(c12526j.m75381c0());
        this.f22467e0.m70007r(c12526j.m75373Y0());
    }

    /* renamed from: S1 */
    public final void m29667S1(final Map<String, String> map) {
        map.put("refurbishSwitch", String.valueOf(C9733f.m60705z().m60720O("backupRefurbish")));
        Optional.ofNullable(new C12519c().m75303n()).ifPresent(new Consumer() { // from class: am.p
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                C4879a.m29610F1(map, (List) obj);
            }
        });
    }

    /* renamed from: T */
    public final void m29668T() {
        m29686Z(this.f22494u0, "InterimBackup_cancel_delay");
        if (mo29591n()) {
            return;
        }
        boolean zM81075b = C13466f.m81073d().m81075b("isStartDeleteTask", false);
        C11839m.m70688i("CloudBackupV3Task", "checkBackupRecordDeleteStatus isStartDeleteTask: " + zM81075b);
        if (zM81075b) {
            if (isRefurbishment()) {
                CBAccess.startDeleteTask(new C0257c1(this.f22455S, this.f22456T, false, false, true));
            } else {
                m29635E2(this.f22459W, this.f22455S, true);
            }
        }
    }

    /* renamed from: T0 */
    public final void m29669T0(Integer num) {
        if (mo29591n()) {
            this.f22475l = num;
            this.f22427g = "3";
            m29672U0();
        } else if (isRefurbishment()) {
            this.f22427g = "2";
        }
        C11839m.m70688i("CloudBackupV3Task", "initOccupySpaceTypeAndBakCategory occ: " + this.f22475l + " ,bakCategory: " + this.f22427g);
    }

    /* renamed from: T1 */
    public void m29670T1(long j10) {
        this.f22452P += j10;
    }

    /* renamed from: U */
    public final void m29671U(boolean z10) {
        int iM75751H0 = C12590s0.m75751H0();
        if (!this.f22483p && m29711h1() && iM75751H0 == -1) {
            C11839m.m70689w("CloudBackupV3Task", "checkRecordCount:no need to delete record.");
            C13466f.m81073d().m81081i("isStartDeleteTask", false);
        } else {
            if (mo29591n() || !m29741r1(z10)) {
                return;
            }
            C13466f.m81073d().m81081i("isStartDeleteTask", true);
        }
    }

    /* renamed from: U0 */
    public final void m29672U0() {
        Integer numValueOf = Integer.valueOf(C12600v1.f57994d + C12600v1.f57996f);
        this.f22477m = numValueOf;
        if (numValueOf.intValue() <= 0) {
            C11839m.m70689w("CloudBackupV3Task", "interimBackupSaveDays set default 60: " + this.f22477m);
            this.f22477m = 60;
        }
        Integer numValueOf2 = Integer.valueOf(C12600v1.f57995e);
        this.f22479n = numValueOf2;
        if (C14341j.f63697a.contains(numValueOf2)) {
            return;
        }
        C11839m.m70689w("CloudBackupV3Task", "interimBackupChannel set default 0: " + this.f22479n);
        this.f22479n = 0;
    }

    /* renamed from: U1 */
    public void m29673U1(int i10) {
        this.f22475l = Integer.valueOf(i10);
        C11839m.m70688i("CloudBackupV3Task", "refreshOccupySpaceType occ: " + this.f22475l + " ,bakCategory: " + this.f22427g);
    }

    /* renamed from: V */
    public final void m29674V() {
        if (isRefurbishment() || mo29591n()) {
            return;
        }
        String strM73925g = C12299b.m73925g("cycle_check_type");
        String type = ICycleChecker.get(new Predicate() { // from class: am.q
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C4879a.m29623y1((ICycleChecker) obj);
            }
        }).getType();
        if (TextUtils.isEmpty(strM73925g) || strM73925g.contains(type)) {
            return;
        }
        C12299b.m73927i();
        C12299b.m73932n("cycle_check_type", "");
    }

    /* renamed from: V0 */
    public CloudSpace m29675V0() throws C9721b {
        return new C13049a(EnumC12999a.CLOUD_BACKUP, this.f22499x).m78754r();
    }

    /* renamed from: V1 */
    public final void m29676V1(String str, String str2) {
        C1457c c1457c;
        if (this.f22426f) {
            C11839m.m70686d("CloudBackupV3Task", "backup successfully, skip summary report");
            return;
        }
        if (this.f22459W == null || (c1457c = this.f22444H) == null || c1457c.mo8329d() == null) {
            C11839m.m70688i("CloudBackupV3Task", "tags or lock is null.");
            return;
        }
        String strM78465h = this.f22459W.m78465h();
        if ("empty_default_id".equals(strM78465h)) {
            C11839m.m70688i("CloudBackupV3Task", "tags bakId is default.");
            return;
        }
        try {
            String strReplace = str.replace("001_", "");
            BakRefresh.Summary summary = new BakRefresh.Summary();
            summary.setRetCode(Integer.valueOf(C0241z.m1685c(strReplace))).setMessage(str2).setRecDeviceDisplayName(BluetoothAdapter.getDefaultAdapter().getName()).setRecDeviceTerminal(Build.MODEL).setBeginTime(new C4644l(this.f22459W.m78469k())).setStartTime(new C4644l(this.f22459W.m78440F())).setEndTime(new C4644l(System.currentTimeMillis())).setTotalSize(Long.valueOf(C14317j.m85301e(this.f22487r).m85306g()));
            List<CloudBackupStatus> listM76931j = new C12815f(this.f22487r).m76931j();
            if (!listM76931j.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (CloudBackupStatus cloudBackupStatus : listM76931j) {
                    int iM29859L = cloudBackupStatus.m29859L();
                    if (iM29859L != 6 && iM29859L != 0) {
                        arrayList.add(cloudBackupStatus.m29871e() + "&" + cloudBackupStatus.m29870d() + "&" + cloudBackupStatus.m29859L() + "&0&0&" + ("switch=" + cloudBackupStatus.m29353I0() + "|count=" + cloudBackupStatus.m29877l() + "|size=" + cloudBackupStatus.m29875i()));
                        if (arrayList.size() >= 15) {
                            break;
                        }
                    }
                }
                summary.setAppList(arrayList);
            }
            BakRefresh bakRefresh = new BakRefresh();
            summary.setFactory(C11903a.m71435l());
            bakRefresh.setUpdateTime(new C4644l(System.currentTimeMillis())).setUnSuccessSummary(summary.toString());
            bakRefresh.setAppsUnbacked(AbstractC10705d.m65337C(C12590s0.m75907u(this.f22498w0)));
            new C10321z(this.f22487r, m29636F0(), m29587j(), CloudBackupConstant.Command.PMS_CMD_BACKUP, this.f22499x).m63535A0(this.f22444H, this.f22455S, strM78465h, bakRefresh, 0, null);
        } catch (Exception e10) {
            C11839m.m70689w("CloudBackupV3Task", "cloud backup refresh error, " + e10);
        }
    }

    @SuppressLint({"ApplySharedPref"})
    /* renamed from: W */
    public final void m29677W() {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(CacheTask.getContext(), NotifyConstants.InterfaceC4909SP.USERINFO_SPFILE, 0);
        if (sharedPreferencesM1382b == null) {
            C11839m.m70689w("CloudBackupV3Task", "clearBackupIncomplete sp is empty");
        } else {
            sharedPreferencesM1382b.edit().remove(NotifyConstants.BackupNotificationType.SP_BACKUP_NOT_COMPLETE_NOTIFY_FLAG).commit();
        }
    }

    /* renamed from: W0 */
    public void m29678W0(About about) {
        if (about.getEnableAppDuplicator().intValue() == 0) {
            C11839m.m70688i("CloudBackupV3Task", "about initSplitAppConfig not support backup split app");
        } else {
            this.f22500x0 = C12534r.m75443g();
        }
    }

    /* renamed from: W1 */
    public final void m29679W1(C13029h c13029h, String str) {
        if (c13029h == null) {
            C11839m.m70688i("CloudBackupV3Task", "reportBackupTag:tag == null");
            return;
        }
        if (c13029h.m78435A() == 0) {
            String str2 = this.f22483p ? "AutoBET" : "ManuBET";
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
            C13622a.m81969o(CacheTask.getContext(), c11060cM66626a, map);
            if (queryTags() != null) {
                C11839m.m70688i("CloudBackupV3Task", "reportBackupTag replaceTag start,tag is:" + c13029h.m78442H());
                new C13030i().m78496g(c13029h);
            }
        }
    }

    /* renamed from: X */
    public final void m29680X() {
        BackupCacheRecord.clear(CacheTask.getContext());
        C13216j.m79421f();
        C11839m.m70686d("CloudBackupV3Task", "delete path = " + this.f22447K);
        C12571m.m75542d(this.f22447K);
        C12571m.m75547i(C12586r.m75713d());
    }

    /* renamed from: X0 */
    public final void m29681X0() {
        C12526j c12526j = new C12526j();
        this.f22469g0 = c12526j.m75357Q0();
        this.f22468f0 = c12526j.m75418s0();
        this.f22470h0 = C9733f.m60705z().m60763v("cloudBackupTarIteration") == 1;
        this.f22471i0 = C9733f.m60705z().m60763v("cloudBackupTarIterationStatistics") == 1;
        C11839m.m70688i("CloudBackupV3Task", "initTarIterationConfig tarRefRatio: " + this.f22469g0 + " ,oldTarRefRation: " + this.f22468f0 + " ,backupTarIteration: " + this.f22470h0 + " ,backupTarIterationStatistics:" + this.f22471i0);
    }

    /* renamed from: X1 */
    public final void m29682X1(Map<String, String> map) {
        if (this.f22446J != null) {
            String strValueOf = String.valueOf(C9733f.m60705z().m60720O("cloudBackupSyncAppExclusive") ? 1 : 0);
            map.put("syncAppExclusive", strValueOf);
            StringBuilder sb2 = new StringBuilder();
            Map<String, SyncSwitchBackupInfo> mapM62107f0 = this.f22446J.m62107f0();
            Iterator<Map.Entry<String, SyncSwitchBackupInfo>> it = mapM62107f0.entrySet().iterator();
            while (it.hasNext()) {
                SyncSwitchBackupInfo value = it.next().getValue();
                sb2.append(value.getSyncAppName());
                sb2.append(":");
                sb2.append(value.getCode());
                sb2.append(",");
            }
            String string = sb2.toString();
            if (!mapM62107f0.isEmpty()) {
                map.put("syncSwitch", string);
            }
            C11839m.m70688i("CloudBackupV3Task", "report syncSwitchBackupInfo, syncAppExclusive: " + strValueOf + ", switchBackupInfo: " + string);
        }
    }

    /* renamed from: Y */
    public final void m29683Y() {
        C12571m.m75542d(C12583q.m75672h());
        C12571m.m75542d(C12583q.m75681q());
    }

    /* renamed from: Y0 */
    public boolean m29684Y0() {
        return 1005 == this.f22440D || 1006 == this.f22440D;
    }

    /* renamed from: Y1 */
    public final void m29685Y1(Map<String, String> map, C13029h c13029h) {
        C11839m.m70686d("CloudBackupV3Task", "report task end");
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        if (c13029h != null) {
            linkedHashMap.put("traceId", c13029h.m78444J());
            linkedHashMap.put("id", c13029h.m78436B());
            linkedHashMap.put("returnCode", c13029h.m78474q());
        }
        linkedHashMap.put("isSuccess", String.valueOf(this.f22426f));
        linkedHashMap.put("autoBackupFrequency", String.valueOf(C13467g.m81086c().m81091f()));
        linkedHashMap.put("isDBDiff", String.valueOf(C9733f.m60705z().m60763v("backupDBDifferential")));
        linkedHashMap.put("isDBDiffCheck", String.valueOf(C9733f.m60705z().m60763v("backupDBDifferentialCheck")));
        linkedHashMap.put("isDBDiffAbout", String.valueOf(m29701e0()));
        linkedHashMap.put("bmDataType", String.valueOf(C12590s0.m75782P(isRefurbishment() || mo29591n())));
        linkedHashMap.put("isFileDiff", String.valueOf(this.f22472j0));
        linkedHashMap.put("is_refurbish", String.valueOf(isRefurbishment()));
        if (this.f22426f) {
            linkedHashMap.put("is_system_retread", String.valueOf(CloudBackupStateUtil.isFromSystemRetreadTask(1, this.f22459W.m78465h())));
        }
        linkedHashMap.putAll(map);
        linkedHashMap.put("checkType", CloudBackupConditionsUtil.getBackUpCheckType());
        linkedHashMap.put("thermalLevel", String.valueOf(this.f22438B));
        if (!C0209d.m1269j1() && !C9733f.m60705z().m60720O("disableDozeOptimization")) {
            linkedHashMap.put("doze", C0224k0.m1564s() ? "1" : "0");
        }
        C13225d.m79490f1().m79603z0("cloudbackup_task_end", linkedHashMap);
    }

    /* renamed from: Z */
    public void m29686Z(String str, String str2) {
        C11839m.m70688i("CloudBackupV3Task", "deleteSingleBak bak: " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            new C13998b0().m84130a0("backupDeviceIdV1V2", str, CBSBaseReq.CURRENT_API_VERSION, C11058a.m66627b("02007"), str2);
        } catch (C9721b e10) {
            C11839m.m70689w("CloudBackupV3Task", "deleteSingleBak server error: " + e10);
        }
    }

    /* renamed from: Z0 */
    public boolean m29687Z0(CloudBackupStatus cloudBackupStatus) {
        return cloudBackupStatus.m29425o1() && !m29714i1();
    }

    /* renamed from: Z1 */
    public final void m29688Z1() {
        if (isRefurbishment() || !isAutoBackup()) {
            InterfaceC10020c.get().mo62163b(new C4972b(3, ""));
        } else {
            InterfaceC10020c.get().mo62163b(new C4972b(3, String.valueOf(getErrCode())));
        }
    }

    /* renamed from: a0 */
    public final void m29689a0(C9721b c9721b) {
        if ("Backup.Lock.vbackup.get".equals(c9721b.m60658b())) {
            ErrorResp.ErrorMsg errorMsg = (ErrorResp.ErrorMsg) C12540b1.m75483a(c9721b.getMessage(), ErrorResp.ErrorMsg.class);
            long jLongValue = (errorMsg == null || errorMsg.getDelayRequestTime() == null) ? 0L : errorMsg.getDelayRequestTime().longValue() * 1000;
            if (jLongValue <= 0) {
                jLongValue = new C12526j().m75331D0() * 60000;
            }
            new SettingOperator().replace(new Settings[]{new Settings("nextbackuptime", String.valueOf(jLongValue), "2")});
        }
    }

    /* renamed from: a1 */
    public boolean m29690a1() {
        return C10028c.m62182c0().m62330g1(m29657P0());
    }

    /* renamed from: a2 */
    public final void m29691a2(long j10) throws Resources.NotFoundException {
        if (mo29591n()) {
            BackupNotification.getInstance().sendBackupCompletedNotification(j10, mo29591n());
            return;
        }
        if (!m29694b2() && m29735p1()) {
            BackupNotification.getInstance().sendBackupCompletedNotification(j10, mo29591n());
        }
        m29698d0(j10);
    }

    /* renamed from: b0 */
    public final void m29692b0(C11060c c11060c, Map<String, String> map) {
        C9721b exception = getException();
        if (this.f22449M) {
            c11060c.m66665u("001_1001");
            c11060c.m66635A("user canceled.");
            return;
        }
        if (!condition()) {
            c11060c.m66665u("001_1002");
            c11060c.m66635A("net disabled.");
            return;
        }
        if (exception == null) {
            if (!isAbort()) {
                c11060c.m66665u("001_1008");
                c11060c.m66635A("unknow error.");
                return;
            }
            c11060c.m66665u("001_" + getErrCode());
            c11060c.m66635A("abort by backup condition. current model:" + getCurrent());
            return;
        }
        c11060c.m66664t(exception.m60658b());
        c11060c.m66665u("001_" + exception.m60659c());
        c11060c.m66635A(m29749u0(exception));
        if (!TextUtils.isEmpty(exception.m60660d())) {
            map.put("detailErrorCode", exception.m60660d());
        }
        if (!TextUtils.isEmpty(exception.getMessage())) {
            Iterator<String> it = f22434B0.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (exception.getMessage().contains(it.next())) {
                    c11060c.m66665u("001_1007");
                    break;
                }
            }
        }
        if (exception.m60659c() == 3001) {
            String strM62263Q0 = C10028c.m62183d0(CacheTask.getContext()).m62263Q0(NotifyConstants.NotificationReport.PARAM_BACKUP_FAIL_DIALOG_MUTED_SCENE, String.valueOf(false));
            if (String.valueOf(true).equalsIgnoreCase(strM62263Q0)) {
                map.put("dialog_muted", strM62263Q0);
                C10028c.m62183d0(C0213f.m1377a()).m62353l(NotifyConstants.NotificationReport.PARAM_BACKUP_FAIL_DIALOG_MUTED_SCENE);
            }
            if (TextUtils.isEmpty(C10028c.m62183d0(C0213f.m1377a()).m62398u())) {
                return;
            }
            map.put("dialog_muted_delay", String.valueOf(true));
        }
    }

    /* renamed from: b1 */
    public final boolean m29693b1(String str) {
        str.hashCode();
        return str.equals("sparse") && this.f22492t0 == 1;
    }

    /* renamed from: b2 */
    public final boolean m29694b2() {
        if (C13462b.m81015c().m81017b("hasSentBackupNotify", false)) {
            C11839m.m70689w("CloudBackupV3Task", "sendFirstBackupSuccessNotify: hasSent ");
            return false;
        }
        FirstTimeOverview subscribeNotifyOm = RestoreUtil.getSubscribeNotifyOm("showFirstBackupReport", "firstBackup");
        if (subscribeNotifyOm != null) {
            return BackupNotification.getInstance().sendFirstBackupCompletedNotification(subscribeNotifyOm.getTitleKey(), subscribeNotifyOm.getContentKey());
        }
        C11839m.m70689w("CloudBackupV3Task", "firstTimeOverview is null");
        return false;
    }

    /* renamed from: c0 */
    public final void m29695c0(C11060c c11060c, C13029h c13029h) {
        if (c13029h != null) {
            c11060c.m66635A("backup success, totalTime: " + (System.currentTimeMillis() - c13029h.m78469k()) + " | totalSize: " + c13029h.m78439E());
        }
        c11060c.m66664t("success");
        c11060c.m66665u("0");
        if (this.f22462Z.isEmpty()) {
            return;
        }
        StringBuilder sb2 = new StringBuilder(c11060c.m66652h());
        sb2.append("filter modules [");
        for (Map.Entry<CloudBackupStatus, String> entry : this.f22462Z.entrySet()) {
            sb2.append(entry.getKey().m29870d());
            sb2.append("=");
            sb2.append(entry.getValue());
        }
        sb2.append("]");
        c11060c.m66635A(sb2.toString());
        c11060c.m66665u("00");
    }

    /* renamed from: c1 */
    public boolean m29696c1(CloudBackupStatus cloudBackupStatus) {
        String strValueOf;
        String strM29870d = cloudBackupStatus.m29870d();
        String strMo29421n = cloudBackupStatus.mo29421n();
        if (this.f22460X.isEmpty()) {
            C11839m.m70686d("CloudBackupV3Task", "empty om skip app config, continue");
            return false;
        }
        if (C14333b.m85476k().contains(strM29870d)) {
            strValueOf = "v1";
        } else {
            try {
                strValueOf = String.valueOf(PackageInfoCompat.getLongVersionCode(CacheTask.getContext().getPackageManager().getPackageInfo(strMo29421n, 16384)));
                if (TextUtils.isEmpty(strValueOf)) {
                    strValueOf = "-1";
                }
            } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
                C11839m.m70689w("CloudBackupV3Task", "name not fount. appId = " + strM29870d);
                return false;
            }
        }
        for (OMFilterModule oMFilterModule : this.f22460X) {
            C11839m.m70686d("CloudBackupV3Task", "begin to match regex and app, version code is : " + strValueOf + ", regex info is " + C12540b1.m75485c(oMFilterModule));
            if (oMFilterModule.isFilterModule(strM29870d, strValueOf)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: c2 */
    public final void m29697c2() {
        if (mo29591n()) {
            C12515a.m75110o().m75172d(new C12199z(1));
        }
    }

    public final void clearSuccessData() {
        C11839m.m70688i("CloudBackupV3Task", "clearSuccessData");
        new C12814e().clear();
        C13466f.m81073d().m81081i("backup_status_clear_flag", true);
        C13617a.m81926h();
        C12574n.m75553f(CacheTask.getContext(), true);
        BackupCacheRecord.clear(CacheTask.getContext());
        m29722l0().mo1760e(this.f22456T);
        C11839m.m70688i("CloudBackupV3Task", "clearSuccessData Success");
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.core.ICBBaseV3Task, com.huawei.android.hicloud.cloudbackup.process.CacheTask
    public boolean condition() {
        if (System.currentTimeMillis() - this.f22476l0 < RippleView.SINGLE_RIPPLE_TIME) {
            return this.f22478m0;
        }
        if (isAutoBackup()) {
            this.f22478m0 = C0209d.m1254f2(CacheTask.getContext());
        } else {
            this.f22478m0 = C10782d.m65634a().m65642i(CacheTask.getContext());
        }
        this.f22476l0 = System.currentTimeMillis();
        return this.f22478m0;
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.core.ICBBaseV3Task
    /* renamed from: d */
    public boolean mo29582d(int i10) {
        if (i10 == 1001) {
            this.f22449M = true;
            return false;
        }
        if (i10 != 1002) {
            if (i10 == 1005 || i10 == 1006) {
                if (!this.f22439C) {
                    return false;
                }
                boolean zM75394h0 = new C12526j().m75394h0();
                if (zM75394h0) {
                    this.f22440D = i10;
                }
                return zM75394h0;
            }
            if (i10 == 1023) {
                if (!CBAccess.hasValidTempBackup()) {
                    return false;
                }
                C11839m.m70688i("CloudBackupV3Task", "manualAbort close switch not abort temp");
                return true;
            }
            if (i10 == 1030) {
                this.f22436A = true;
                return this.f22501y;
            }
            if (i10 != 3900) {
                return false;
            }
        }
        return this.f22501y;
    }

    /* renamed from: d0 */
    public final void m29698d0(long j10) {
        C12515a.m75110o().m75172d(new CloudBackupSuccessNotifyTask(this.f22483p, j10));
    }

    /* renamed from: d1 */
    public boolean m29699d1() {
        return this.f22489s;
    }

    /* renamed from: d2 */
    public void m29700d2(int i10) {
        this.f22437A0 = i10;
    }

    /* renamed from: e0 */
    public int m29701e0() {
        return this.f22437A0;
    }

    /* renamed from: e1 */
    public final boolean m29702e1() {
        if (!this.f22464b0) {
            try {
                List<CloudBackupStatus> listM76931j = new C12815f(this.f22487r).m76931j();
                if (!listM76931j.isEmpty()) {
                    for (int i10 = 0; i10 < listM76931j.size(); i10++) {
                        CloudBackupStatus cloudBackupStatus = listM76931j.get(i10);
                        int iM29859L = cloudBackupStatus.m29859L();
                        int iM29860M = cloudBackupStatus.m29860M();
                        if (iM29859L == 0 && iM29860M == 0) {
                        }
                        this.f22464b0 = true;
                    }
                }
            } catch (C9721b e10) {
                C11839m.m70689w("CloudBackupV3Task", "isHasPreBackupItems err = " + e10.getMessage());
            }
        }
        return this.f22464b0;
    }

    /* renamed from: e2 */
    public void m29703e2(List<String> list) {
        this.f22490s0 = list;
    }

    @Override // com.huawei.android.hicloud.cloudbackup.process.CacheTask
    public boolean extraCondition() {
        return m29729n1();
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.core.ICBBaseV3Task
    /* renamed from: f */
    public void mo29584f() throws Resources.NotFoundException {
        long jCurrentTimeMillis;
        Handler handler;
        C11839m.m70688i("CloudBackupV3Task", "close isSuccess: " + this.f22426f);
        CloudBackupTaskManager.getInstance().shutDown();
        CloudBackupCreateManager.getInstance().shutdownExecutor();
        C11315b.m67979c().m67986h();
        C12182i.m73283j().m73303w();
        CloneService.getInstance().unBindService();
        if (!CloneService.getInstance().getModuleInfoList().isEmpty()) {
            new C12371b(this.f22456T, getCurrent(), 0, m29588k()).clear();
            CloneService.getInstance().clearModuleInfoList();
        }
        C13216j.m79425j();
        C11965e.m71974f().m71987p();
        Message messageObtain = Message.obtain();
        messageObtain.what = 32999;
        messageObtain.arg1 = 0;
        SettingOperator settingOperator = new SettingOperator();
        if (this.f22426f) {
            this.f22451O.m78425n(1);
            clearSuccessData();
            C10152c.m63218b(CacheTask.getContext());
            messageObtain.arg1 = 3;
            Bundle bundle = new Bundle();
            jCurrentTimeMillis = 0;
            bundle.putLong("cloudbackup_total_size", 0L);
            bundle.putLong("cloudbackup_last_success_time", settingOperator.querylastsuccesstime());
            messageObtain.obj = bundle;
            m29691a2(C14317j.m85301e(this.f22487r).m85306g());
            m29697c2();
            C13148e.m79057f(CacheTask.getContext());
        } else {
            if (getErrCode() == 1001) {
                messageObtain.arg1 = 0;
            } else {
                if (!condition()) {
                    setErrCode(1002);
                }
                messageObtain.arg1 = 1;
                messageObtain.arg2 = getErrCode();
            }
            jCurrentTimeMillis = System.currentTimeMillis();
            messageObtain.obj = Long.valueOf(settingOperator.querylastsuccesstime());
            ContentValues contentValues = new ContentValues();
            contentValues.put("backupFailedErrorCode", String.valueOf(getErrCode()));
            C12299b.m73929k(contentValues, "backupFailedErrorCode");
            m29674V();
            boolean z10 = ICBBroadcastManager.getIsExitAccount().get();
            boolean zIsRefurbishment = isRefurbishment();
            C11839m.m70688i("CloudBackupV3Task", "check sendBackupFailedNotification, autoBackup = " + this.f22483p + ", existAccount = " + z10 + ", isRefurbishment = " + zIsRefurbishment);
            if (m29735p1() && (!z10 || !zIsRefurbishment)) {
                if (getErrCode() != 1003 || (handler = this.f22458V) == null) {
                    BackupNotification.getInstance().sendBackupFailedNotification(this.f22449M, m29702e1(), this.f22459W, mo29591n());
                } else {
                    handler.postDelayed(new Runnable() { // from class: am.o
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f972a.m29764z1();
                        }
                    }, 400L);
                }
            }
            m29688Z1();
        }
        m29683Y();
        settingOperator.replace(new Settings[]{new Settings("lastfailedtime", String.valueOf(jCurrentTimeMillis), "2")});
        m29637F2();
        callback(messageObtain, 100L);
        recordEndTime();
        C12585q1.m75693c();
        InterfaceC12198y interfaceC12198y = this.loadController;
        if (interfaceC12198y != null) {
            interfaceC12198y.onTaskFinish();
        }
    }

    /* renamed from: f0 */
    public Map<String, List<App>> m29704f0() {
        return this.f22443G;
    }

    /* renamed from: f1 */
    public boolean m29705f1() {
        return this.f22493u;
    }

    /* renamed from: f2 */
    public void m29706f2(List<C11723d> list) {
        this.f22498w0 = list;
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.core.ICBBaseV3Task
    /* renamed from: g */
    public void mo29585g(C9721b c9721b) {
        this.f22459W = queryTags();
        int iM60659c = c9721b.m60659c();
        if (iM60659c == 1007) {
            C12594t1.m75990o().m76005e(this.f22487r);
            C13029h c13029h = this.f22459W;
            if (c13029h != null) {
                c13029h.m78471n0(C12590s0.m75860i0());
                new C13030i().m78496g(this.f22459W);
            }
            m29680X();
            return;
        }
        if (iM60659c == 1030) {
            SettingOperator settingOperator = new SettingOperator();
            AbsThermalControl thermalControl = ThermalChecker.getThermalControl(false);
            if (thermalControl == null) {
                C11839m.m70688i("CloudBackupV3Task", "thermalControl is empty");
                return;
            } else if (thermalControl.checkIllegalArgument()) {
                C11839m.m70688i("CloudBackupV3Task", "thermalControl IllegalArgument");
                return;
            } else {
                settingOperator.replace(new Settings[]{new Settings("nextbackuptime", String.valueOf(thermalControl.getThermalRetryInteval() * 60000), "2")});
                return;
            }
        }
        if (iM60659c == 1035) {
            this.f22459W.m78457W(c9721b.m60661e());
            new C13030i().m78496g(this.f22459W);
            return;
        }
        if (iM60659c != 3111) {
            if (iM60659c != 3924) {
                if (iM60659c != 3926) {
                    if (iM60659c == 3928) {
                        C11839m.m70688i("CloudBackupV3Task", "second refurbish backup invalid");
                        m29612G2(R$string.cloudbackup_second_refurbish_fail_tip);
                        return;
                    }
                    if (iM60659c != 3930) {
                        if (iM60659c == 3934) {
                            int iM1685c = C0241z.m1685c(this.f22459W.m78480t()) + 1;
                            this.f22459W.m78455U(String.valueOf(iM1685c));
                            C11839m.m70686d("CloudBackupV3Task", "flow control count = " + iM1685c);
                            new C13030i().m78496g(this.f22459W);
                            m29689a0(c9721b);
                            return;
                        }
                        if (iM60659c == 3001) {
                            C11839m.m70688i("CloudBackupV3Task", "taskErrorEnd no space");
                            new SettingOperator().replace(new Settings[]{new Settings("nextbackuptime", String.valueOf(86400000L), "2")});
                            C12594t1.m75990o().m76005e(this.f22487r);
                            C13465e.m81052f().m81070s(isRefurbishment(), 0L);
                            m29680X();
                            return;
                        }
                        if (iM60659c != 3002) {
                            return;
                        }
                        int iM1685c2 = C0241z.m1685c(this.f22459W.m78480t()) + 1;
                        this.f22459W.m78455U(String.valueOf(iM1685c2));
                        C11839m.m70686d("CloudBackupV3Task", "flow control count = " + iM1685c2);
                        new C13030i().m78496g(this.f22459W);
                        m29689a0(c9721b);
                        return;
                    }
                }
            }
            C11839m.m70688i("CloudBackupV3Task", "taskErrorEnd catch error: source not match");
            C14311d.m85230g().m85236f(CacheTask.getContext(), !CBAccess.hasValidTempBackup());
            return;
        }
        C11839m.m70688i("CloudBackupV3Task", "taskErrorEnd catch error: userkey guid not match");
        UserKeyUtils.getInstance().clearUserKeyByBusinessType(1);
    }

    /* renamed from: g0 */
    public List<C11723d> m29707g0() {
        return this.f22498w0;
    }

    /* renamed from: g1 */
    public boolean m29708g1() {
        return this.f22486q0;
    }

    /* renamed from: g2 */
    public void m29709g2(int i10) {
        this.f22492t0 = i10;
    }

    public String getLocation() {
        return this.f22447K;
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.core.ICBBaseV3Task
    /* renamed from: h */
    public void mo29586h() throws InterruptedException, C9721b {
        isCancel();
        C14317j.m85301e(this.f22487r).m85303b(1);
        new C10014w(this, this.f22483p, this.f22489s, this.f22459W, this.f22498w0).m62161c();
    }

    /* renamed from: h0 */
    public int m29710h0() {
        return this.f22440D;
    }

    /* renamed from: h1 */
    public boolean m29711h1() {
        return this.f22488r0;
    }

    /* renamed from: h2 */
    public void m29712h2(String str) {
        this.f22455S = str;
    }

    /* renamed from: i0 */
    public String m29713i0() {
        return this.f22487r;
    }

    /* renamed from: i1 */
    public boolean m29714i1() {
        return (isRefurbishment() || mo29591n() || !C12590s0.m75861i1(m29657P0())) ? false : true;
    }

    /* renamed from: i2 */
    public void m29715i2(C1457c c1457c) {
        this.f22444H = c1457c;
    }

    public boolean isAutoBackup() {
        return this.f22483p;
    }

    public boolean isRefurbishment() {
        return "Refurbishment".equalsIgnoreCase(this.f22487r);
    }

    public boolean isSupportPMS() {
        boolean zM12611e = PmsCheckUtil.m12611e();
        C11839m.m70686d("CloudBackupV3Task", "isSupportPMS = " + zM12611e);
        return zM12611e;
    }

    public boolean isSupportSplitApp(String str) {
        C12534r c12534r = this.f22500x0;
        if (c12534r == null) {
            return false;
        }
        return c12534r.m75451m(str, this.f22427g);
    }

    /* renamed from: j0 */
    public BackupDataAcptErrPolicy m29716j0() {
        return this.f22496v0;
    }

    /* renamed from: j1 */
    public boolean m29717j1(Map<String, App> map, CloudBackupStatus cloudBackupStatus) {
        return m29744s1() && cloudBackupStatus.m29863P() && !cloudBackupStatus.m29862O() && Objects.nonNull(map.get(cloudBackupStatus.m29870d()));
    }

    /* renamed from: j2 */
    public void m29718j2(String str) {
        this.f22456T = str;
    }

    /* renamed from: k0 */
    public String m29719k0() {
        return this.f22455S;
    }

    /* renamed from: k1 */
    public boolean m29720k1() {
        return this.f22484p0;
    }

    /* renamed from: k2 */
    public void m29721k2(Set<String> set) {
        this.f22480n0 = set;
    }

    public void keepLock() {
        try {
            if (this.f22444H == null) {
                C11839m.m70688i("CloudBackupV3Task", "keepLock error, backupV3Lock == null");
            } else {
                isCancel();
                this.f22444H.m8328c();
            }
        } catch (C9721b e10) {
            setException(e10);
        }
    }

    /* renamed from: l0 */
    public InterfaceC0260d1 m29722l0() {
        return this.f22473k;
    }

    /* renamed from: l1 */
    public boolean m29723l1() {
        return C0209d.m1281m1() && this.f22474k0 && PmsUtils.isSupportNewRYFeature();
    }

    /* renamed from: l2 */
    public void m29724l2(String str) {
        C11839m.m70688i("CloudBackupV3Task", "setDeleteSingleBak: " + str);
        this.f22494u0 = str;
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.core.ICBBaseV3Task
    /* renamed from: m */
    public boolean mo29590m() {
        return isRefurbishment();
    }

    /* renamed from: m0 */
    public C13028g m29725m0() {
        return this.f22451O;
    }

    /* renamed from: m1 */
    public boolean m29726m1() {
        return this.f22474k0;
    }

    /* renamed from: m2 */
    public void m29727m2(About about) {
        Long fileIdListMaxLen = about.getFileIdListMaxLen();
        C11839m.m70688i("CloudBackupV3Task", "setFileIdListMaxLen: " + fileIdListMaxLen);
        if (fileIdListMaxLen != null) {
            this.f22503z = fileIdListMaxLen.longValue();
        }
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.core.ICBBaseV3Task
    /* renamed from: n */
    public boolean mo29591n() {
        return "interim".equalsIgnoreCase(this.f22487r);
    }

    /* renamed from: n0 */
    public C1457c m29728n0() {
        return this.f22444H;
    }

    /* renamed from: n1 */
    public boolean m29729n1() {
        this.f22466d0.readLock().lock();
        try {
            return this.f22501y;
        } finally {
            this.f22466d0.readLock().unlock();
        }
    }

    /* renamed from: n2 */
    public void m29730n2(int i10) {
        this.f22450N = i10;
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.core.ICBBaseV3Task
    /* renamed from: o */
    public void mo29592o(Context context, HiCloudSafeIntent hiCloudSafeIntent, Handler handler) {
        this.f22458V = handler;
        String action = hiCloudSafeIntent.getAction();
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            processNetworkChanged(context, handler);
            return;
        }
        if (!"android.intent.action.BATTERY_CHANGED".equals(action)) {
            if ("android.intent.action.SCREEN_OFF".equals(action)) {
                C11839m.m70688i("CloudBackupV3Task", "action screen off.");
                m29658P1(handler);
                return;
            } else if ("android.intent.action.USER_PRESENT".equals(action)) {
                C11839m.m70688i("CloudBackupV3Task", "action user present");
                m29661Q1(handler);
                return;
            } else {
                if ("android.intent.action.ACTION_POWER_DISCONNECTED".equals(action)) {
                    C11839m.m70688i("CloudBackupV3Task", "action power disconnect");
                    abort(1005);
                    return;
                }
                return;
            }
        }
        C11839m.m70688i("CloudBackupV3Task", "action battery change");
        int intExtra = hiCloudSafeIntent.getIntExtra(FaqConstants.FAQ_LEVEL, 0);
        C10153d.m63243g(intExtra);
        int intExtra2 = hiCloudSafeIntent.getIntExtra("status", 1);
        C11839m.m70688i("CloudBackupV3Task", "batteryStatus: " + intExtra2);
        if (intExtra2 == 2 || intExtra2 == 5 || intExtra >= 10) {
            return;
        }
        C11839m.m70689w("CloudBackupV3Task", "battery level lower than 10%");
        abort(1003);
    }

    /* renamed from: o0 */
    public C9989d m29731o0() {
        return this.f22445I;
    }

    /* renamed from: o1 */
    public boolean m29732o1(String str) {
        return this.f22490s0.contains(str);
    }

    /* renamed from: o2 */
    public void m29733o2(boolean z10) {
        this.f22493u = z10;
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.core.ICBBaseV3Task
    /* renamed from: p */
    public void mo29593p() throws C9721b {
        C9989d c9989d = this.f22445I;
        if (c9989d == null) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "operator is invalid", "operator");
        }
        c9989d.m61943u();
    }

    /* renamed from: p0 */
    public String m29734p0() {
        return this.f22456T;
    }

    /* renamed from: p1 */
    public boolean m29735p1() {
        return (isAutoBackup() || m29708g1()) ? false : true;
    }

    /* renamed from: p2 */
    public void m29736p2(boolean z10) {
        this.f22439C = z10;
        if (z10) {
            return;
        }
        m29665S();
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.core.ICBBaseV3Task
    /* renamed from: q */
    public void mo29594q() throws InterruptedException, C9721b {
        C13029h c13029hM78495f;
        if (isRefurbishment() && !C0209d.m1254f2(CacheTask.getContext())) {
            setState(CacheTask.State.CANCEL);
            throw new C9721b(1002, "net disable.", "isCancel");
        }
        if (!this.f22483p) {
            m29596s();
        }
        CloudBackupReport.reportBackupStart(this.f22499x, this.f22487r, this.f22475l, this.f22427g, this.f22477m, this.f22479n);
        BackupNotification.getInstance().cancelBackupNotification();
        new BackupNotificationManager(CacheTask.getContext()).cancelNotification(27);
        InterfaceC10020c.get().mo62163b(new C4972b(4, ""));
        if (m29735p1() && (!ICBBroadcastManager.getIsExitAccount().get() || !isRefurbishment())) {
            BackupNotification.getInstance().sendBackupPrepareNotification();
        }
        m29633D2();
        C12591s1.m75931a().m75947q(isRefurbishment());
        C12600v1.m76047c().m76056k(mo29591n());
        CloudBackupJobManager.getInstance().unRegisterBackupCacheScheduler();
        C12591s1.m75931a().m75946p(true);
        C12585q1.m75709s();
        if (!C12585q1.m75691a("CloudBackupV3Task")) {
            C11839m.m70687e("CloudBackupV3Task", "backup OM error.");
            throw new C9721b(1901, "backup OM error.");
        }
        this.f22474k0 = m29664R1();
        try {
            if (new C12815f(this.f22487r).m76931j().isEmpty()) {
                C11963c.m71951f(this.f22487r);
            }
        } catch (Exception e10) {
            C11839m.m70689w("CloudBackupV3Task", "prepare queryAllStatue err = " + e10.getMessage());
        }
        recordBackupStart();
        m29677W();
        if (!isRefurbishment() && (c13029hM78495f = new C13030i().m78495f(4)) != null && c13029hM78495f.m78441G() != 4) {
            this.f22487r = "Refurbishment";
        }
        if (isRefurbishment()) {
            GetOptionsInfoFromCloneTask.checkCacheInvalid(isRefurbishment());
        }
        C13466f.m81073d().m81081i("myHuawei_start_backup_task", isRefurbishment());
        C10013v c10013v = new C10013v(this, this.f22499x, this.f22454R, this.f22483p, this.f22487r);
        this.f22446J = c10013v;
        this.f22459W = c10013v.m62084P();
        if (!mo29591n()) {
            m29666S0();
        }
        m29681X0();
        m29660Q0();
        this.f22464b0 = true;
        this.f22456T = this.f22459W.m78465h();
        C14317j.m85301e(this.f22487r).m85312m(this.f22459W);
        this.f22489s = this.f22446J.m62068G0();
        this.f22491t = this.f22446J.m62065F0();
        if (this.f22489s) {
            this.f22450N = 0;
        }
        List<List<String>> listM62091V = this.f22446J.m62091V();
        C13108a.m78878b(CacheTask.getContext()).m78881d(new Intent("com.huawei.hicloud.intent.action.ACTION_START_SPACE_USING_TRACK_REPROT"));
        this.f22445I = new C9989d(this, listM62091V, this.f22446J.m62089T(), this.f22483p, this.f22489s, this.f22459W);
        if (mo29591n()) {
            m29644I2();
        } else {
            GetOptionsInfoFromCloneTask.checkCacheInvalid(isRefurbishment());
        }
        C12592t.m75950g().m75960k();
    }

    /* renamed from: q0 */
    public Set<String> m29737q0() {
        return this.f22480n0;
    }

    /* renamed from: q1 */
    public boolean m29738q1() {
        return this.f22497w;
    }

    /* renamed from: q2 */
    public void m29739q2(boolean z10) {
        this.f22488r0 = z10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x0048, code lost:
    
        r3 = r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public tl.C13029h queryTags() {
        /*
            r3 = this;
            tl.i r0 = new tl.i
            r0.<init>()
            r1 = 0
            boolean r2 = r3.isRefurbishment()     // Catch: fk.C9721b -> L12
            if (r2 == 0) goto L14
            r3 = 4
            tl.h r3 = r0.m78495f(r3)     // Catch: fk.C9721b -> L12
            goto L48
        L12:
            r3 = move-exception
            goto L2d
        L14:
            boolean r3 = r3.mo29591n()     // Catch: fk.C9721b -> L12
            if (r3 == 0) goto L20
            r3 = 5
            tl.h r3 = r0.m78495f(r3)     // Catch: fk.C9721b -> L12
            goto L48
        L20:
            r3 = 2
            tl.h r1 = r0.m78495f(r3)     // Catch: fk.C9721b -> L12
            if (r1 != 0) goto L47
            r3 = 1
            tl.h r3 = r0.m78495f(r3)     // Catch: fk.C9721b -> L12
            goto L48
        L2d:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "query backupTag error, "
            r0.append(r2)
            java.lang.String r3 = r3.toString()
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            java.lang.String r0 = "CloudBackupV3Task"
            p514o9.C11839m.m70689w(r0, r3)
        L47:
            r3 = r1
        L48:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hicloud.cloudbackup.p104v3.core.C4879a.queryTags():tl.h");
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.core.ICBBaseV3Task
    /* renamed from: r */
    public void mo29595r(ICBBaseV3Task.ICBBaseReceiver iCBBaseReceiver) {
        IntentFilter intentFilter = new IntentFilter();
        if (this.f22483p) {
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        }
        intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        CacheTask.getContext().registerReceiver(iCBBaseReceiver, intentFilter);
    }

    /* renamed from: r0 */
    public boolean m29740r0() {
        try {
            this.f22453Q = new C13049a(EnumC12999a.CLOUD_BACKUP, this.f22499x).m78756u();
            return false;
        } catch (C9721b e10) {
            C11839m.m70687e("CloudBackupV3Task", "getCloudSpaceFromServerError: " + e10.toString());
            return true;
        }
    }

    /* renamed from: r1 */
    public final boolean m29741r1(boolean z10) {
        C11839m.m70688i("CloudBackupV3Task", "enter into isSuccessBaksNumExceedsThreshold,isSuccess:" + z10);
        if (z10 && C12590s0.m75782P(isRefurbishment()) == 1) {
            int iIntValue = isRefurbishment() ? CloudBackupConstant.UserPackageInfo.NORMAL_BACKUP_RECORDS.intValue() : C12590s0.m75798T();
            if (iIntValue <= 0) {
                C11839m.m70687e("CloudBackupV3Task", "invalid maxBaseRecordNum:" + iIntValue);
                return false;
            }
            long jCount = this.f22441E.stream().filter(new Predicate() { // from class: am.g
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return C4879a.m29604B1((com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak) obj);
                }
            }).count() + 1;
            C11839m.m70688i("CloudBackupV3Task", "backup success,type is BASE_DATA,successBaseRecordNum is:" + jCount + ",maxBaseRecordNum is:" + iIntValue);
            return jCount > ((long) iIntValue);
        }
        int size = m29645J0().size();
        if (z10) {
            size++;
        }
        int iIntValue2 = isRefurbishment() ? CloudBackupConstant.UserPackageInfo.NORMAL_BACKUP_RECORDS.intValue() : C12590s0.m75751H0();
        if (iIntValue2 <= 0) {
            C11839m.m70687e("CloudBackupV3Task", "invalid maxRecordNum:" + iIntValue2);
            return false;
        }
        boolean z11 = size > iIntValue2;
        C11839m.m70688i("CloudBackupV3Task", "isSuccessBaksNumExceedsThreshold:" + z11 + ",successRecordSize:" + size + ", maxRecordNum:" + iIntValue2 + ",isSuccess:" + z10);
        return z11;
    }

    /* renamed from: r2 */
    public void m29742r2(List<OMFilterModule> list) {
        this.f22460X = list;
    }

    public final void recordBackupStart() {
        C12590s0.m75777N2(0L);
        C12590s0.m75773M2(new C12526j().m75428x0());
        this.f22451O.m78426o(this.f22483p ? 2 : 1);
        this.f22451O.m78432u(System.currentTimeMillis());
        new C13027f().m78411i(this.f22451O);
    }

    public final void recordEndTime() {
        if (this.f22451O.m78421j() > 0) {
            C13027f c13027f = new C13027f();
            this.f22451O.m78430s(System.currentTimeMillis());
            long jM78422k = this.f22451O.m78422k();
            long jM78423l = this.f22451O.m78423l();
            if (jM78422k > 0 && jM78423l > 0) {
                this.f22451O.m78431t(1);
                c13027f.m78403a();
            }
            c13027f.m78411i(this.f22451O);
            c13027f.m78404b(System.currentTimeMillis() - 604800000);
        }
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.core.ICBBaseV3Task
    public void registThermalCallback() {
        if (!this.f22483p) {
            C11839m.m70688i("CloudBackupV3Task", "registThermalCallback autoBackup false return");
            return;
        }
        if (CloudBackupConditionsUtil.isInterimBackupThermalControlDisable("interim".equals(this.f22487r))) {
            C11839m.m70688i("CloudBackupV3Task", "no need registThermalCallback,interimBackupThermalControlDisable:true");
            return;
        }
        registerThermalCallback();
        if (C11979a.m72102l().m72107m()) {
            registerUniScheduleCallback();
        }
    }

    public final void registerThermalCallback() {
        C11979a.m72102l().m72108n(1, 1, new C11979a.c() { // from class: am.e
            @Override // p529op.C11979a.c
            /* renamed from: a */
            public final void mo471a(int i10, int i11) {
                this.f932a.m29639G1(i10, i11);
            }
        });
    }

    public final void registerUniScheduleCallback() {
        C11979a.m72102l().m72108n(1, 2, new C11979a.c() { // from class: am.k
            @Override // p529op.C11979a.c
            /* renamed from: a */
            public final void mo471a(int i10, int i11) {
                this.f956a.m29641H1(i10, i11);
            }
        });
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.core.ICBBaseV3Task
    public void reportEvent() {
        long jM61894L;
        long jM61898P;
        this.f22459W = queryTags();
        C11060c c11060cM66626a = C11058a.m66626a(this.f22499x, "success", C13452e.m80781L().m80971t0());
        HashMap map = new HashMap();
        c11060cM66626a.m66668x("1");
        c11060cM66626a.m66665u("0");
        if (this.f22426f) {
            m29695c0(c11060cM66626a, this.f22459W);
            new BackupNotificationManager(CacheTask.getContext()).cancelNotification(24);
            m29677W();
        } else {
            m29692b0(c11060cM66626a, map);
        }
        String strM66652h = c11060cM66626a.m66652h();
        this.errMsg = strM66652h;
        map.put("errMsg", strM66652h);
        if (isRefurbishment()) {
            map.put("is_refurbish", String.valueOf(isRefurbishment()));
        }
        C9721b c9721b = this.exception;
        if (c9721b == null || c9721b.m60659c() != 1023) {
            C14317j.m85301e(this.f22487r).m85302a(1, c11060cM66626a.m66647c(), this.f22426f);
        }
        if (isRefurbishment()) {
            if (this.f22426f) {
                C13467g.m81086c().m81093h("refurbish_restore_notify" + C11476b.m68626h(C13452e.m80781L().m80971t0()), true);
            }
            C13029h c13029h = this.f22459W;
            ICBBroadcastManager.sendCloudBackupStateBroadcast(1, c13029h == null ? "" : c13029h.m78465h(), false);
        }
        m29662R(c11060cM66626a.m66647c(), c11060cM66626a.m66652h());
        map.put("backupVersion", CBSBaseReq.CURRENT_API_VERSION);
        C13029h c13029h2 = this.f22459W;
        if (c13029h2 != null) {
            if (!"empty_default_id".equals(c13029h2.m78465h())) {
                map.put("backupId", this.f22459W.m78465h());
            }
            map.put("count", String.valueOf(this.f22459W.m78476r()));
            map.put("backupBeginTime", String.valueOf(this.f22459W.m78469k()));
            map.put("backupStartTime", String.valueOf(this.f22459W.m78440F()));
            map.put("backupEndTime", String.valueOf(System.currentTimeMillis()));
            long jCurrentTimeMillis = System.currentTimeMillis() - this.f22459W.m78440F();
            if (jCurrentTimeMillis > 0) {
                map.put("backupTime", String.valueOf(jCurrentTimeMillis));
            }
            C11726g c11726gM75722A = C12590s0.m75722A(false, mo29591n(), new ArrayList(), m29722l0().mo1759d());
            map.put("totalSize", String.valueOf(c11726gM75722A.m69964b()));
            map.put("incrementSize", String.valueOf(c11726gM75722A.m69963a()));
            map.put("backupTransID", this.f22459W.m78436B());
            map.put("backupTimes", String.valueOf(this.f22459W.m78476r()));
            map.put("flowControlCnt", String.valueOf(this.f22459W.m78480t()));
            map.put("isFullBackup", String.valueOf(this.f22489s));
            map.put("isFirstBackup", String.valueOf(this.f22491t));
            map.put("firstBackupType", String.valueOf(m29758x0()));
            C9989d c9989d = this.f22445I;
            if (c9989d != null) {
                jM61894L = c9989d.m61894L();
                jM61898P = this.f22445I.m61898P();
                map.put("totalSucceedModuleSpaceSize", String.valueOf(this.f22445I.m61904V()));
                map.put("totalSucceedUploadSpaceSize", String.valueOf(this.f22445I.m61905W()));
            } else {
                jM61894L = 0;
                jM61898P = 0;
            }
            map.put("lastUploadedSize", String.valueOf(jM61894L));
            map.put("needUploadedSize", String.valueOf(jM61898P));
            map.put("isWifiSleep", String.valueOf(C2783d.m16163n0(CacheTask.getContext())));
            map.put("isPowerSavingOn", String.valueOf(C2783d.m16124a0(CacheTask.getContext())));
            map.put("stayOnWhilePlugged", String.valueOf(C2783d.m16155k1(CacheTask.getContext())));
            map.put("powerSavingMode", String.valueOf(C2783d.m16152j1(CacheTask.getContext())));
            long downLoadSize = MobileTrafficReport.getInstance().getDownLoadSize();
            if (downLoadSize > 0) {
                map.put("backupNetWorkSize", String.valueOf(downLoadSize));
            }
            if (c11726gM75722A.m69963a() >= jM61894L) {
                map.put("needUploadedSize", String.valueOf(c11726gM75722A.m69963a() - jM61894L));
            }
            if (this.f22489s) {
                C10013v c10013v = this.f22446J;
                map.put("clientAcitons", c10013v != null ? c10013v.m62093X() : "");
                map.put("fullBackupResult", String.valueOf(this.f22426f));
            }
            int i10 = this.f22465c0;
            if (i10 > 0) {
                map.put("autoBackupUserPresentTimes", String.valueOf(i10));
            }
            this.f22459W.m78470m0(0);
            this.f22459W.m78452R(c11060cM66626a.m66647c());
            this.f22459W.m78446L(getCurrent() + "_" + m29588k());
            this.f22459W.m78451Q(c11060cM66626a.m66646b());
            if (this.f22426f) {
                this.f22459W.m78447M(System.currentTimeMillis());
                this.f22459W.m78477r0(4);
            }
            map.put(VastAttribute.PROGRESS, String.valueOf(C11965e.m71974f().m71979h()));
            map.put("leftSpaceSize", String.valueOf(m29634E0()));
            map.put("totalIncrementSpaceSize", this.f22459W.m78482u());
            map.put("gradeCode", C12590s0.m75747G0());
            map.put("bakCategory", String.valueOf(m29587j()));
            if (m29636F0() != null) {
                map.put("occupySpaceType", String.valueOf(m29636F0()));
            }
            if (queryTags() != null) {
                new C13030i().m78496g(this.f22459W);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("reportEvent replaceTag queryTags = ");
                sb2.append(queryTags() != null);
                C11839m.m70688i("CloudBackupV3Task", sb2.toString());
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("backup_end_code", c11060cM66626a.m66647c());
            C12299b.m73929k(contentValues, "backupEndCodePath");
            if (!this.f22483p) {
                m29679W1(this.f22459W, this.f22426f ? "success" : NotifyConstants.CommonReportConstants.FAILED);
            } else if (this.f22426f) {
                m29679W1(this.f22459W, "success");
                reportInterruptOrAuto(this.f22459W, "cloudbackup_auto_times");
            }
            if (this.f22426f) {
                C12592t.m75950g().m75954d(this.f22499x, this.f22455S);
            }
            reportEachTask(this.f22459W, "cloudbackup_each_period", null);
            reportEachTask(this.f22459W, "cloudbackup_each_backup_size", String.valueOf(jM61894L));
            reportEachTask(this.f22459W, "cloudbackup_total_size", String.valueOf(C14317j.m85301e(this.f22487r).m85306g()));
            if (isRefurbishment()) {
                if (this.f22426f) {
                    C12590s0.m75745F2();
                }
                m29667S1(map);
            }
            m29682X1(map);
            m29685Y1(map, this.f22459W);
        }
        map.put("userType", C13452e.m80781L().m80987x0());
        map.put("thermalLevel", String.valueOf(this.f22438B));
        Long localLeftSpace = ICBUtil.getLocalLeftSpace();
        if (localLeftSpace != null && localLeftSpace.longValue() > 0) {
            map.put("localInfo", String.valueOf(localLeftSpace));
        }
        C13622a.m81971q(c11060cM66626a, map, false, true);
        CloudBackupReport.reportLostFileFix(this.f22499x, this.f22481o);
        if (this.f22426f) {
            if (isRefurbishment() || mo29591n()) {
                executeAsyncTask(new CacheTask.AsyncTask(new CacheTask.IAsyncTask() { // from class: am.n
                    @Override // com.huawei.android.hicloud.cloudbackup.process.CacheTask.IAsyncTask
                    public final void run() throws JSONException {
                        C4879a.m29615I1();
                    }
                }));
            }
        }
    }

    /* renamed from: s0 */
    public String m29743s0() {
        return this.f22448L;
    }

    /* renamed from: s1 */
    public boolean m29744s1() {
        return (!C12294a.f56945a || this.f22489s || isRefurbishment() || mo29591n() || !C12590s0.m75811W0(this.f22482o0, m29626B0())) ? false : true;
    }

    /* renamed from: s2 */
    public void m29745s2(boolean z10) {
        this.f22472j0 = z10;
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.core.ICBBaseV3Task
    /* renamed from: t */
    public void mo29597t() {
        C14317j.m85301e(this.f22487r).m85320u(false, this.f22426f ? 1 : 0);
    }

    /* renamed from: t0 */
    public C11730k m29746t0() {
        if (this.f22467e0 == null) {
            m29666S0();
        }
        return this.f22467e0;
    }

    /* renamed from: t1 */
    public boolean m29747t1(String str) {
        boolean zM29732o1 = m29732o1(str);
        boolean zM29693b1 = m29693b1(str);
        C11839m.m70688i("CloudBackupV3Task", "checkSupportCompressType:" + str + ",serverSupportEncoding:" + zM29732o1 + ",featureGrayOpen:" + zM29693b1);
        return zM29732o1 && zM29693b1;
    }

    /* renamed from: t2 */
    public void m29748t2(boolean z10) {
        this.f22484p0 = z10;
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.core.ICBBaseV3Task
    /* renamed from: u */
    public void mo29598u(long j10, String str) {
        C13029h c13029hQueryTags = queryTags();
        if (c13029hQueryTags != null) {
            C11839m.m70686d("CloudBackupV3Task", "report each stage time");
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
            linkedHashMap.put("traceId", c13029hQueryTags.m78444J());
            linkedHashMap.put("backupId", c13029hQueryTags.m78465h());
            linkedHashMap.put("id", c13029hQueryTags.m78436B());
            linkedHashMap.put("stage", str);
            linkedHashMap.put("time", String.valueOf(System.currentTimeMillis() - j10));
            linkedHashMap.put("backupVersion", CBSBaseReq.CURRENT_API_VERSION);
            C13225d.m79490f1().m79603z0("cloudbackup_each_stage_time", linkedHashMap);
        }
    }

    /* renamed from: u0 */
    public final String m29749u0(C9721b c9721b) {
        if (c9721b == null) {
            return "";
        }
        String message = c9721b.getMessage();
        if (c9721b.m60659c() != 1030) {
            return message;
        }
        return message + "," + ThermalChecker.getThermalInfo(this.f22438B);
    }

    /* renamed from: u1 */
    public boolean m29750u1() {
        return this.f22502y0;
    }

    /* renamed from: u2 */
    public void m29751u2(boolean z10, String str, int i10) throws C9721b {
        this.f22466d0.writeLock().lock();
        try {
            String str2 = str + i10;
            if (z10) {
                this.f22461Y.add(str2);
            } else {
                this.f22461Y.remove(str2);
            }
            boolean z11 = !this.f22461Y.isEmpty();
            this.f22501y = z11;
            if (z11) {
                this.f22466d0.writeLock().unlock();
                return;
            }
            if (!isAbort() && isAutoBackup() && this.f22436A) {
                if (!ThermalChecker.isThermalControlByMain(this.f22438B)) {
                    throw new C9721b(1030, "thermostat level beyond setting," + ThermalChecker.getThermalInfo(this.f22438B));
                }
                this.f22436A = false;
            }
            this.f22466d0.writeLock().unlock();
        } catch (Throwable th2) {
            this.f22466d0.writeLock().unlock();
            throw th2;
        }
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.core.ICBBaseV3Task
    public void unRegistThermalCallback() {
        C11979a.m72102l().m72111q(1);
    }

    /* renamed from: v0 */
    public Map<CloudBackupStatus, C9721b> m29752v0() {
        return this.f22463a0;
    }

    /* renamed from: v1 */
    public boolean m29753v1() {
        return this.f22504z0;
    }

    /* renamed from: v2 */
    public void m29754v2(long j10) {
        this.f22485q = j10;
    }

    /* renamed from: w0 */
    public long m29755w0() {
        return this.f22503z;
    }

    /* renamed from: w1 */
    public boolean m29756w1() {
        return this.f22495v;
    }

    /* renamed from: w2 */
    public void m29757w2(boolean z10) {
        this.f22497w = z10;
    }

    /* renamed from: x0 */
    public int m29758x0() {
        return this.f22450N;
    }

    /* renamed from: x1 */
    public final /* synthetic */ void m29759x1(String str, String str2) {
        m29671U(this.f22426f);
        m29676V1(str, str2);
        C1457c c1457c = this.f22444H;
        if (c1457c != null) {
            c1457c.m8336i();
        }
        m29668T();
    }

    /* renamed from: x2 */
    public void m29760x2(List<com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak> list) {
        this.f22441E = list;
    }

    /* renamed from: y0 */
    public Integer m29761y0() {
        return this.f22479n;
    }

    /* renamed from: y2 */
    public void m29762y2(List<com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak> list) {
        this.f22442F = list;
    }

    /* renamed from: z0 */
    public Integer m29763z0() {
        return this.f22477m;
    }

    /* renamed from: z1 */
    public final /* synthetic */ void m29764z1() {
        BackupNotification.getInstance().sendBackupFailedNotification(this.f22449M, m29702e1(), this.f22459W, mo29591n());
    }

    /* renamed from: z2 */
    public void m29765z2(boolean z10) {
        this.f22502y0 = z10;
    }

    public C4879a(boolean z10, String str, String str2, Integer num, boolean z11) {
        this.f22475l = null;
        this.f22481o = false;
        this.f22485q = 0L;
        this.f22495v = false;
        this.f22497w = false;
        this.f22503z = 1048576L;
        this.f22436A = false;
        this.f22438B = -1;
        this.f22441E = new ArrayList();
        this.f22442F = new ArrayList();
        this.f22443G = new HashMap();
        this.f22450N = 0;
        this.f22451O = new C13028g();
        this.f22452P = 0L;
        this.f22460X = new ArrayList();
        this.f22461Y = new HashSet();
        this.f22462Z = new ConcurrentHashMap();
        this.f22463a0 = new ConcurrentHashMap();
        this.f22465c0 = 0;
        this.f22466d0 = new ReentrantReadWriteLock();
        this.f22474k0 = true;
        this.f22478m0 = true;
        this.f22480n0 = new HashSet();
        this.f22484p0 = true;
        this.f22486q0 = false;
        this.f22488r0 = false;
        this.f22490s0 = new ArrayList();
        this.f22492t0 = 0;
        this.f22498w0 = new ArrayList();
        this.f22486q0 = z11;
        this.f22454R = C13452e.m80781L().m80950o();
        this.f22457U = C13452e.m80781L().m80978v();
        this.f22483p = z10;
        this.f22487r = str;
        this.f22499x = str2;
        String strM63452a = C10279b.m63452a(C10278a.m63441g(CacheTask.getContext().getFilesDir(), "cloudbackup"));
        this.f22447K = strM63452a;
        this.f22448L = strM63452a + "/data";
        m29669T0(num);
        this.f22429i = BackupPowerKitKeepTimer.getInstance().getApplyType(z10);
        this.f22473k = InterfaceC0260d1.m1755f(str);
    }

    public C4879a(boolean z10, String str, String str2, int i10) {
        this(z10, str, str2, Integer.valueOf(i10), false);
    }
}
