package gm;

import am.C0257c1;
import am.C0306w0;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import cm.C1457c;
import com.huawei.android.backup.filelogic.utils.PmsCheckUtil;
import com.huawei.android.backup.service.logic.C2153l;
import com.huawei.android.hicloud.cloudbackup.bean.BackupModuleList;
import com.huawei.android.hicloud.cloudbackup.broadcast.ICBBroadcastManager;
import com.huawei.android.hicloud.cloudbackup.callable.CBCallBack;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.p076db.bean.Settings;
import com.huawei.android.hicloud.cloudbackup.p076db.operator.SettingOperator;
import com.huawei.android.hicloud.cloudbackup.p076db.temp.AlbumsTempDBManager;
import com.huawei.android.hicloud.cloudbackup.process.BackupPowerKitKeepTimer;
import com.huawei.android.hicloud.cloudbackup.process.CBAccess;
import com.huawei.android.hicloud.cloudbackup.process.CloneService;
import com.huawei.android.hicloud.cloudbackup.process.util.CloudBackupAppDataUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.ScanAppDataUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.SplitAppUtil;
import com.huawei.android.hicloud.cloudbackup.report.CloudBackupReport;
import com.huawei.android.hicloud.cloudbackup.service.CloudBackupService;
import com.huawei.android.hicloud.cloudbackup.snapshottree.QueryBackupMeta;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.SnapshotDBManager;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.bean.SnapshotBackupMeta;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackupLanguageUtil;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackupStateUtil;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackupUtil;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.android.hicloud.cloudbackup.util.TransferedUtil;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.uiutil.NewHiSyncUtil;
import com.huawei.android.hicloud.sync.protocol.SyncProtocol;
import com.huawei.cloud.base.util.C4644l;
import com.huawei.fastengine.fastview.NavigationUtils;
import com.huawei.feedback.constant.FeedbackConst;
import com.huawei.hicloud.base.bean.CloudSpace;
import com.huawei.hicloud.cloudbackup.p104v3.core.C4879a;
import com.huawei.hicloud.cloudbackup.p104v3.omconfig.model.SyncAppBackupPolicy;
import com.huawei.hicloud.cloudbackup.p104v3.omconfig.model.SyncSwitchBackupInfo;
import com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request;
import com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Server;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.About;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.App;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.AppRefresh;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Attachment;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.BakCreate;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.BakList;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Device;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.DeviceCreate;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Lock;
import com.huawei.hicloud.cloudbackup.p104v3.server.request.Backup;
import com.huawei.hicloud.cloudbackup.p104v3.server.request.Bak;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudBackupStatus;
import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.request.cbs.bean.CBSBackupRecord;
import com.huawei.hicloud.request.cbs.bean.CBSBaseReq;
import com.huawei.hidisk.common.util.javautil.StringUtil;
import com.huawei.hms.network.embedded.C5863b6;
import com.huawei.openalliance.p169ad.constant.AiCoreSdkConstant;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import dm.C9195d0;
import fk.C9721b;
import hk.C10278a;
import hk.C10279b;
import hm.C10321z;
import hu.C10343b;
import il.C10537j;
import im.C10546a;
import im.C10560j;
import im.InterfaceC10551c0;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import mk.C11476b;
import om.C11963c;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0241z;
import p292fn.C9733f;
import p429kk.C11058a;
import p429kk.C11060c;
import p458lo.C11322a;
import p495nm.C11722c;
import p495nm.C11723d;
import p495nm.C11725f;
import p495nm.C11726g;
import p495nm.C11727h;
import p514o9.C11835i;
import p514o9.C11839m;
import p572qb.C12299b;
import p616rk.C12515a;
import p617rl.C12519c;
import p617rl.C12526j;
import p618rm.C12565k;
import p618rm.C12571m;
import p618rm.C12582p1;
import p618rm.C12583q;
import p618rm.C12590s0;
import p618rm.C12592t;
import p618rm.C12594t1;
import p618rm.C12597u1;
import p618rm.C12598v;
import p618rm.C12605x0;
import p618rm.C12610z0;
import p682ul.C13216j;
import p682ul.C13219m;
import p684un.C13225d;
import p709vj.C13452e;
import p711vl.C13465e;
import p711vl.C13466f;
import p711vl.C13467g;
import p744wl.C13617a;
import p746wn.C13622a;
import p814yl.C13998b0;
import p814yl.C14000c0;
import p815ym.AbstractC14026a;
import p847zk.C14315h;
import p847zk.C14317j;
import p848zl.C14333b;
import pl.C12161c;
import pl.C12164f;
import pm.C12176c;
import sl.C12815f;
import tl.C13026e;
import tl.C13029h;
import tl.C13030i;
import tl.C13033l;

/* renamed from: gm.v */
/* loaded from: classes6.dex */
public class C10013v {

    /* renamed from: a */
    public final C4879a f48947a;

    /* renamed from: b */
    public final boolean f48948b;

    /* renamed from: e */
    public final String f48951e;

    /* renamed from: f */
    public String f48952f;

    /* renamed from: g */
    public final String f48953g;

    /* renamed from: h */
    public final String f48954h;

    /* renamed from: m */
    public Bak f48959m;

    /* renamed from: n */
    public Bak f48960n;

    /* renamed from: q */
    public C11725f f48963q;

    /* renamed from: r */
    public boolean f48964r;

    /* renamed from: u */
    public String f48967u;

    /* renamed from: w */
    public boolean f48969w;

    /* renamed from: c */
    public boolean f48949c = false;

    /* renamed from: d */
    public int f48950d = 0;

    /* renamed from: i */
    public final List<String> f48955i = new ArrayList();

    /* renamed from: j */
    public final Map<String, Bundle> f48956j = new LinkedHashMap();

    /* renamed from: k */
    public final List<List<String>> f48957k = new ArrayList();

    /* renamed from: l */
    public final List<String> f48958l = new ArrayList();

    /* renamed from: s */
    public long f48965s = 0;

    /* renamed from: t */
    public boolean f48966t = false;

    /* renamed from: v */
    public final Map<String, C13219m<String, Integer, Integer>> f48968v = new HashMap();

    /* renamed from: x */
    public boolean f48970x = true;

    /* renamed from: y */
    public final Map<String, SyncSwitchBackupInfo> f48971y = new HashMap();

    /* renamed from: z */
    public final List<C11723d> f48972z = new ArrayList();

    /* renamed from: A */
    public int f48944A = 0;

    /* renamed from: B */
    public boolean f48945B = false;

    /* renamed from: C */
    public final List<String> f48946C = new ArrayList();

    /* renamed from: o */
    public final Context f48961o = C0213f.m1377a();

    /* renamed from: p */
    public final C12526j f48962p = new C12526j();

    public C10013v(C4879a c4879a, String str, String str2, boolean z10, String str3) {
        this.f48947a = c4879a;
        this.f48948b = z10;
        this.f48951e = str3;
        this.f48954h = str2;
        this.f48953g = str;
    }

    /* renamed from: H0 */
    public static boolean m62019H0(boolean z10, CloudBackupStatus cloudBackupStatus) {
        if (!z10 || cloudBackupStatus.m29859L() == 0 || cloudBackupStatus.m29860M() == -1) {
            return false;
        }
        return TextUtils.isEmpty(cloudBackupStatus.m29381V0()) || TextUtils.equals(cloudBackupStatus.m29381V0(), "0");
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Backup$Device$Create] */
    /* renamed from: L0 */
    public static /* synthetic */ CloudBackupV3Request m62020L0(DeviceCreate deviceCreate, String str, String str2, String str3, Integer num, CloudBackupV3Server cloudBackupV3Server) throws IOException {
        Backup.Device.Create create = cloudBackupV3Server.backup().device().create(deviceCreate);
        create.setFields(str).setBackupAction(str2).setBakCategory(str3).setOccupySpaceType(num);
        return create;
    }

    /* renamed from: M0 */
    public static /* synthetic */ boolean m62021M0(List list, CloudBackupStatus cloudBackupStatus) {
        return cloudBackupStatus.m29860M() == -1 && !list.contains(cloudBackupStatus.m29870d());
    }

    /* renamed from: N0 */
    public static /* synthetic */ boolean m62022N0(Bak bak) {
        return bak.getBackupStatus().intValue() != 0;
    }

    /* renamed from: O0 */
    public static /* synthetic */ boolean m62023O0(Bak bak) {
        return bak.getBackupStatus().intValue() != 1;
    }

    /* renamed from: P0 */
    public static /* synthetic */ boolean m62024P0(Bak bak) {
        return Objects.equals(bak.getOccupySpaceType(), 1);
    }

    /* renamed from: Q0 */
    public static /* synthetic */ boolean m62025Q0(Bak bak) {
        return bak.getBackupStatus().intValue() != 0;
    }

    /* renamed from: S0 */
    public static /* synthetic */ boolean m62026S0(BackupOptionItem backupOptionItem) {
        return !backupOptionItem.getBackupSwitch();
    }

    /* renamed from: T0 */
    public static /* synthetic */ boolean m62027T0(BackupOptionItem backupOptionItem) {
        return C14333b.f63654f.contains(backupOptionItem.getAppId());
    }

    /* renamed from: U0 */
    public static /* synthetic */ void m62028U0(C13026e c13026e, BackupOptionItem backupOptionItem) {
        c13026e.m78376K(true, backupOptionItem.getAppId());
        C11839m.m70688i("CloudBackupV3Prepare", "fixBackupSwitch appId: " + backupOptionItem.getAppId() + " switch open");
    }

    /* renamed from: W */
    public static long m62029W(Bak bak) {
        C4644l expirationTime = bak.getExpirationTime();
        if (expirationTime == null) {
            long jM28458c = bak.getStartTime().m28458c() + 259200000;
            C11839m.m70688i("CloudBackupV3Prepare", "getBakExpireTime from local, bak: " + bak.getId() + " ,expireTime: " + jM28458c);
            return jM28458c;
        }
        long jM28458c2 = expirationTime.m28458c();
        C11839m.m70688i("CloudBackupV3Prepare", "getBakExpireTime from server, bak: " + bak.getId() + " ,expireTime: " + jM28458c2);
        return jM28458c2;
    }

    /* renamed from: W0 */
    public static /* synthetic */ boolean m62030W0(Bak bak) {
        return bak.getBmDataType().intValue() == 1;
    }

    /* renamed from: Y */
    public static Bak m62031Y() {
        Bak bak = new Bak();
        bak.setId("empty_default_id");
        bak.setExpirationTime(new C4644l(new Date(System.currentTimeMillis() + 259200000)));
        return bak;
    }

    /* renamed from: d1 */
    public static Bundle m62036d1(Bundle bundle, boolean z10, boolean z11) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("is_notepad_support_tar", FaqConstants.DISABLE_HA_REPORT);
        Bundle bundle3 = new Bundle();
        bundle3.putBundle("Memo", bundle2);
        bundle.putBundle("AllModulesAbility", bundle3);
        bundle.putBoolean("isMemoUsePmsTar", z10);
        bundle.putBoolean("isSupportTar", true);
        bundle.putBoolean("isNewPhonePmsSupportDecompressTarByPath", z11);
        return bundle;
    }

    /* renamed from: s0 */
    public static void m62047s0(About about) {
        if (Objects.equals(about.getBmType(), 1)) {
            C13452e.m80781L().m80985w2(true);
        }
    }

    /* renamed from: u1 */
    public static void m62048u1(C12815f c12815f, CloudBackupStatus cloudBackupStatus) throws C9721b {
        try {
            c12815f.m76934m(cloudBackupStatus);
        } catch (C9721b e10) {
            if (C13617a.m81919a("cloudbackup_status.db") && c12815f.integrityCheck()) {
                throw e10;
            }
            C11839m.m70688i("CloudBackupV3Prepare", "status databases not exists");
            C13216j.m79419d();
            throw new C9721b(3930, e10.getMessage());
        }
    }

    /* renamed from: A */
    public final void m62049A(long j10) {
        String strM29628C0 = this.f48947a.m29628C0();
        String strM29631D0 = this.f48947a.m29631D0();
        try {
            if (!TextUtils.isEmpty(strM29628C0)) {
                if (C12590s0.m75921x1(strM29631D0) || C12590s0.m75925y1(strM29631D0)) {
                    QueryBackupMeta queryBackupMeta = new QueryBackupMeta(HNConstants.DataType.MEDIA, strM29628C0);
                    while (queryBackupMeta.hasNext()) {
                        for (SnapshotBackupMeta snapshotBackupMeta : queryBackupMeta.getNext()) {
                            if (C10278a.m63442h(ICBUtil.convertToAbsolutePath(snapshotBackupMeta.getRoot() + snapshotBackupMeta.getData(), this.f48947a.getLocation())).exists()) {
                                this.f48965s++;
                            }
                        }
                    }
                } else {
                    for (C12161c c12161c : new C12164f(strM29628C0, HNConstants.DataType.MEDIA, 0, 0).m73066Y(1000L, 0L)) {
                        if (C10278a.m63442h(ICBUtil.convertToAbsolutePath(c12161c.m72950F() + c12161c.m72991l(), this.f48947a.getLocation())).exists()) {
                            this.f48965s++;
                        }
                    }
                }
            }
        } catch (C9721b e10) {
            C11839m.m70687e("CloudBackupV3Prepare", "get gallery meta error. " + e10.getMessage());
        }
        long j11 = this.f48965s;
        if (j10 > j11) {
            this.f48965s = j10 - j11;
        }
        this.f48947a.m29754v2(this.f48965s);
        C11839m.m70688i("CloudBackupV3Prepare", "repeatCount = " + this.f48965s);
    }

    /* renamed from: A0 */
    public final void m62050A0(String str, C10343b c10343b, List<String> list) throws C9721b {
        int iM63686h;
        long jM63688j;
        boolean zM63681c;
        Bundle bundle;
        boolean z10;
        Bundle bundle2 = new Bundle();
        if (HNConstants.DataType.CONTACT.equals(str)) {
            iM63686h = 0;
            long j10 = 0;
            for (String str2 : c10343b.m63697s()) {
                Bundle bundleM63684f = c10343b.m63684f(str2);
                if (bundleM63684f != null) {
                    C10343b c10343b2 = new C10343b(bundleM63684f);
                    if ("Phone".equals(c10343b2.m63694p("AccountName"))) {
                        int iM63686h2 = c10343b2.m63686h("ModuleCount");
                        long j11 = bundleM63684f.getLong("ModuleSize");
                        bundle2.putInt(CloneService.KEY_ACTION_FLAG, 10);
                        Bundle bundle3 = new Bundle();
                        bundle3.putBundle(str2, bundleM63684f);
                        bundle2.putBundle(HNConstants.DataType.CONTACT, bundle3);
                        j10 = j11;
                        iM63686h = iM63686h2;
                    }
                }
            }
            bundle = bundle2;
            jM63688j = j10;
            zM63681c = false;
        } else {
            iM63686h = c10343b.m63686h("ModuleCount");
            jM63688j = c10343b.m63688j("ModuleSize");
            zM63681c = c10343b.m63681c("isSupportClone");
            bundle2.putInt(CloneService.KEY_ACTION_FLAG, 10);
            if (NavigationUtils.SMS_SCHEMA_PREF.equals(str)) {
                bundle2.putBoolean("isSupportPduFileOptimization", true);
            }
            if ("HiCreate".equals(str)) {
                bundle2.putBoolean("isSupportDataDataPmsTar", PmsCheckUtil.m12614h());
            }
            if ("Memo".equalsIgnoreCase(str)) {
                bundle2 = m62036d1(bundle2, PmsCheckUtil.m12614h(), C2153l.m13045g0());
            }
            bundle = bundle2;
        }
        bundle.putLong("ModuleSize", jM63688j);
        C11839m.m70688i("CloudBackupV3Prepare", "appId = " + str + ", datasize = " + jM63688j + " totalNum = " + iM63686h + " isSupportClone = " + zM63681c);
        if (jM63688j != 0) {
            z10 = true;
        } else if (this.f48947a.mo29591n() && this.f48946C.contains(str)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(" temp system app is ");
            sb2.append(str);
            sb2.append(" , reason: ");
            z10 = true;
            sb2.append(1);
            C11839m.m70688i("CloudBackupV3Prepare", sb2.toString());
            C12590s0.m75769L2(str, this.f48972z, 1);
        } else {
            z10 = true;
            C12590s0.m75769L2(str, this.f48972z, 1);
        }
        boolean z11 = (("soundrecorder".equals(str) || "callRecorder".equals(str)) && iM63686h == 0) ? z10 : false;
        if (zM63681c && z11) {
            C11839m.m70688i("CloudBackupV3Prepare", "filter module, appId = " + str);
        }
        if (iM63686h > 0 || (zM63681c && !z11)) {
            m62063E1(str, jM63688j, iM63686h);
            this.f48956j.put(str, bundle);
            list.add(str);
            m62145v0(str, 0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00e1 A[PHI: r2 r8
  0x00e1: PHI (r2v6 com.huawei.hicloud.base.bean.CloudSpace) = (r2v5 com.huawei.hicloud.base.bean.CloudSpace), (r2v17 com.huawei.hicloud.base.bean.CloudSpace) binds: [B:22:0x00c2, B:24:0x00dd] A[DONT_GENERATE, DONT_INLINE]
  0x00e1: PHI (r8v6 long) = (r8v5 long), (r8v9 long) binds: [B:22:0x00c2, B:24:0x00dd] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: A1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m62051A1(tl.C13029h r15, int r16) throws fk.C9721b {
        /*
            Method dump skipped, instructions count: 291
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: gm.C10013v.m62051A1(tl.h, int):void");
    }

    /* renamed from: B */
    public final Device m62052B(final String str, String str2, final String str3, final Integer num) throws C9721b {
        final DeviceCreate deviceCreate = new DeviceCreate();
        deviceCreate.setDevicePathName(str2).setCreateTime(new C4644l(System.currentTimeMillis()));
        final String str4 = "id,createTime,updateTime";
        return (Device) new C14000c0(new C14000c0.a() { // from class: gm.u
            @Override // p814yl.C14000c0.a
            /* renamed from: a */
            public final CloudBackupV3Request mo1697a(CloudBackupV3Server cloudBackupV3Server) {
                return C10013v.m62020L0(deviceCreate, str4, str, str3, num, cloudBackupV3Server);
            }
        }).m84139b("Backup.device.create", this.f48953g);
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01c8 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* renamed from: B0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m62053B0(java.util.List<java.lang.String> r17, java.util.List<java.lang.String> r18) throws java.lang.InterruptedException, fk.C9721b {
        /*
            Method dump skipped, instructions count: 509
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: gm.C10013v.m62053B0(java.util.List, java.util.List):void");
    }

    /* renamed from: B1 */
    public final Bak m62054B1(final String str, final String str2) throws C9721b {
        C11839m.m70688i("CloudBackupV3Prepare", "Backup.device.bak.start backupDeviceId = " + C12590s0.m75916w0(C11476b.m68626h(str)));
        final BakCreate bakCreate = new BakCreate();
        bakCreate.setBackupDeviceId(str).setBackupVersion(CBSBaseReq.CURRENT_API_VERSION).setExpireInDay(this.f48947a.m29763z0()).setIncType(Integer.valueOf((m62068G0() || this.f48969w) ? 0 : 1)).setFrequency(Integer.valueOf(C13467g.m81086c().m81091f())).setStartTime(new C4644l(System.currentTimeMillis()));
        if (C13452e.m80781L().m80887a1() && !this.f48947a.isRefurbishment() && !this.f48947a.mo29591n()) {
            bakCreate.setBmDataType(C12590s0.m75828a1(m62096Z()) ? 1 : 2);
        }
        final String str3 = "id,device,backupStatus,backupVersion,startTime,updateTime,endTime,expirationTime";
        return (Bak) new C14000c0(new C14000c0.a() { // from class: gm.s
            @Override // p814yl.C14000c0.a
            /* renamed from: a */
            public final CloudBackupV3Request mo1697a(CloudBackupV3Server cloudBackupV3Server) {
                return this.f48928a.m62095Y0(bakCreate, str3, str, str2, cloudBackupV3Server);
            }
        }).m84139b("Backup.device.bak.start", this.f48953g);
    }

    /* renamed from: C */
    public final void m62055C(C13029h c13029h) throws C9721b {
        String strM78488y = c13029h.m78488y();
        this.f48952f = strM78488y;
        if (strM78488y.startsWith("V3_")) {
            this.f48952f = this.f48952f.replaceFirst("V3_", "");
        } else {
            this.f48952f = "";
        }
        if (this.f48952f.isEmpty() || "empty_default_id".equals(c13029h.m78465h())) {
            C11839m.m70688i("CloudBackupV3Prepare", "create backup device");
            this.f48952f = m62052B(this.f48951e, C11476b.m68626h(this.f48954h), this.f48947a.m29587j(), this.f48947a.m29636F0()).getId();
        }
        c13029h.m78460Z("V3_" + this.f48952f);
        this.f48947a.m29712h2(this.f48952f);
        C13466f.m81073d().m81084l(CloudBackupConstant.BACKUP_DEVICE_ID, this.f48952f);
    }

    /* renamed from: C0 */
    public final void m62056C0() {
        if (this.f48947a.mo29591n()) {
            List<String> listM75384d0 = this.f48962p.m75384d0();
            if (!AbstractC14026a.m84159a(listM75384d0)) {
                this.f48946C.addAll(listM75384d0);
            }
            List<String> listM75387e0 = this.f48962p.m75387e0();
            if (!AbstractC14026a.m84159a(listM75387e0)) {
                this.f48946C.addAll(listM75387e0);
            }
            C11839m.m70688i("CloudBackupV3Prepare", "initTempBackupDefaultApp module: " + listM75384d0);
        }
    }

    /* renamed from: C1 */
    public final void m62057C1(CloudBackupStatus cloudBackupStatus, long j10) throws C9721b {
        String strM29870d = cloudBackupStatus.m29870d();
        int iM29861N = cloudBackupStatus.m29861N();
        BackupOptionItem backupOptionItemQueryItem = TransferedUtil.queryItem(strM29870d, this.f48947a.m29722l0().mo1759d());
        if (backupOptionItemQueryItem == null) {
            backupOptionItemQueryItem = m62086R(strM29870d, cloudBackupStatus.mo29421n(), cloudBackupStatus.m29861N(), cloudBackupStatus.mo29357K(), "thirdAppData");
            backupOptionItemQueryItem.setUid(cloudBackupStatus.m29861N());
        }
        C13026e c13026eMo1759d = this.f48947a.m29722l0().mo1759d();
        String strM25632b = NewHiSyncUtil.m25632b(strM29870d);
        if (TextUtils.isEmpty(strM25632b)) {
            strM25632b = strM29870d;
        }
        backupOptionItemQueryItem.setAppName(strM25632b);
        backupOptionItemQueryItem.setDataBytes(j10);
        backupOptionItemQueryItem.setIsDataEnable(2);
        C12590s0.m75915w(backupOptionItemQueryItem, this.f48947a.mo29591n(), this.f48963q);
        c13026eMo1759d.m78382Q(backupOptionItemQueryItem);
        m62148w0(strM29870d, 1, iM29861N);
    }

    /* renamed from: D */
    public final C13029h m62058D(String str, int i10, long j10) {
        C13029h c13029h = new C13029h(m62109g0(), C11058a.m66627b("02010"));
        c13029h.m78448N(str);
        String str2 = this.f48952f;
        if (str2 == null) {
            str2 = "";
        }
        this.f48952f = str2;
        c13029h.m78460Z("V3_" + this.f48952f);
        c13029h.m78467i0(C13452e.m80781L().m80978v());
        long jCurrentTimeMillis = System.currentTimeMillis();
        c13029h.m78475q0(jCurrentTimeMillis);
        c13029h.m78447M(604800000 + jCurrentTimeMillis);
        c13029h.m78450P(jCurrentTimeMillis);
        c13029h.m78483u0(this.f48953g);
        c13029h.m78453S(i10);
        if (j10 == 0) {
            j10 = jCurrentTimeMillis;
        }
        c13029h.m78449O(j10);
        new C13030i().m78496g(c13029h);
        String str3 = this.f48948b ? "AutoBBT" : "ManuBBT";
        C11060c c11060cM66626a = C11058a.m66626a(c13029h.m78436B(), str3, C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("0");
        c11060cM66626a.m66635A("isSuccess");
        HashMap map = new HashMap();
        map.put("business_id", str3);
        map.put("backupBeginTime", String.valueOf(c13029h.m78440F()));
        map.put("backupTransID", c13029h.m78444J());
        C13622a.m81969o(this.f48961o, c11060cM66626a, map);
        return c13029h;
    }

    /* renamed from: D0 */
    public final C13029h m62059D0() throws InterruptedException, C9721b {
        C13030i c13030i = new C13030i();
        C13029h c13029hM78495f = c13030i.m78495f(4);
        if (c13029hM78495f != null) {
            C13617a.m81922d(c13029hM78495f.m78465h(), this.f48961o, this.f48947a.mo29591n());
            c13030i.m78490a(4);
        }
        C13029h c13029hM78495f2 = c13030i.m78495f(2);
        if (c13029hM78495f2 == null) {
            c13029hM78495f2 = c13030i.m78495f(1);
        }
        if (c13029hM78495f2 != null) {
            C13617a.m81922d("empty_default_id", this.f48961o, this.f48947a.mo29591n());
            c13030i.m78490a(c13029hM78495f2.m78442H());
        }
        C11839m.m70688i("CloudBackupV3Prepare", "wait DeleteRefurbishV3Task start");
        while (C12515a.m75110o().m75158X0(C0257c1.class.getName())) {
            SystemClock.sleep(500L);
            this.f48947a.isCancel();
        }
        C11839m.m70688i("CloudBackupV3Prepare", "wait DeleteRefurbishV3Task end");
        C13029h c13029hM78495f3 = c13030i.m78495f(5);
        if (c13029hM78495f3 == null) {
            C13617a.m81922d("empty_default_id", this.f48961o, this.f48947a.mo29591n());
            C13029h c13029hM62058D = m62058D("empty_default_id", 0, 0L);
            c13030i.m78496g(c13029hM62058D);
            m62110g1(c13029hM62058D, m62031Y());
            return c13029hM62058D;
        }
        if (c13029hM78495f3.m78441G() != 4) {
            return c13029hM78495f3;
        }
        C13617a.m81925g(this.f48947a.mo29591n());
        c13030i.m78490a(c13029hM78495f3.m78442H());
        C13029h c13029hM62058D2 = m62058D("empty_default_id", 0, 0L);
        c13030i.m78496g(c13029hM62058D2);
        m62110g1(c13029hM62058D2, m62031Y());
        return c13029hM62058D2;
    }

    /* renamed from: D1 */
    public final C13029h m62060D1(C13029h c13029h) throws C9721b {
        String strM78465h = c13029h.m78465h();
        if ("empty_default_id".equals(strM78465h)) {
            if (!this.f48958l.isEmpty()) {
                c13029h.m78448N(this.f48959m.getId());
                c13029h = m62124n1(c13029h);
            }
        } else if (this.f48958l.contains(strM78465h)) {
            c13029h = m62124n1(c13029h);
        } else {
            m62133q1(c13029h, "terminated", true);
            C13617a.m81922d(strM78465h, this.f48961o, this.f48947a.mo29591n());
            new C13030i().m78490a(c13029h.m78442H());
            Bak bak = this.f48959m;
            if (bak != null) {
                c13029h.m78448N(bak.getId());
                c13029h = m62124n1(c13029h);
            } else {
                c13029h = m62058D("empty_default_id", 0, 0L);
                m62055C(c13029h);
            }
        }
        if (!TextUtils.isEmpty(c13029h.m78465h()) && !"empty_default_id".equals(c13029h.m78465h())) {
            this.f48947a.m29725m0().m78424m(c13029h.m78465h());
            this.f48947a.m29718j2(c13029h.m78465h());
        }
        return c13029h;
    }

    /* renamed from: E */
    public final C13029h m62061E(C13029h c13029h, Lock lock) throws C9721b {
        Bak bakM62054B1;
        String strM78465h = c13029h.m78465h();
        if (strM78465h.isEmpty()) {
            Bak bakM62054B12 = m62054B1(this.f48952f, lock.getLockId());
            bakM62054B1 = bakM62054B12;
            c13029h = m62058D(bakM62054B12.getId(), 0, 0L);
        } else if ("empty_default_id".equals(strM78465h)) {
            bakM62054B1 = m62054B1(this.f48952f, lock.getLockId());
            c13029h.m78448N(bakM62054B1.getId());
            c13029h = m62124n1(c13029h);
            this.f48947a.m29730n2(0);
        } else {
            bakM62054B1 = null;
        }
        m62110g1(c13029h, bakM62054B1);
        String strM78465h2 = c13029h.m78465h();
        this.f48947a.m29725m0().m78424m(strM78465h2);
        this.f48947a.m29718j2(strM78465h2);
        return c13029h;
    }

    /* renamed from: E0 */
    public final void m62062E0(List<String> list) throws C9721b {
        if (this.f48962p.m75353O0()) {
            for (String str : new C12519c().m75297h((this.f48947a.isRefurbishment() || this.f48947a.mo29591n()) ? 2 : 1)) {
                BackupOptionItem backupOptionItemQueryItemByAppId = TransferedUtil.queryItemByAppId(str, this.f48947a.m29722l0().mo1759d());
                boolean zM62102c0 = m62102c0(str, "virtualApp");
                if (backupOptionItemQueryItemByAppId != null) {
                    zM62102c0 = backupOptionItemQueryItemByAppId.getBackupSwitch();
                }
                if (!zM62102c0) {
                    C11839m.m70688i("CloudBackupV3Prepare", " virtual app is " + str + " , reason: 0");
                    C12590s0.m75769L2(str, this.f48972z, 0);
                } else if (m62134r(str)) {
                    Iterator<List<String>> it = this.f48957k.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (m62073I0(str, it.next())) {
                                break;
                            }
                        } else {
                            m62077J1(list, str);
                            break;
                        }
                    }
                }
            }
        }
    }

    /* renamed from: E1 */
    public final void m62063E1(String str, long j10, long j11) throws C9721b {
        BackupOptionItem backupOptionItemQueryItemByAppId = TransferedUtil.queryItemByAppId(str, this.f48947a.m29722l0().mo1759d());
        if (backupOptionItemQueryItemByAppId == null) {
            backupOptionItemQueryItemByAppId = m62086R(str, str, 0, "0", TransferedUtil.getItemParent(str));
        }
        backupOptionItemQueryItemByAppId.setAppName(C2783d.m16079E(this.f48961o, str));
        backupOptionItemQueryItemByAppId.setDataBytes(j10);
        backupOptionItemQueryItemByAppId.setItemTotal((int) j11);
        backupOptionItemQueryItemByAppId.setIsDataEnable(2);
        C12590s0.m75915w(backupOptionItemQueryItemByAppId, this.f48947a.mo29591n(), this.f48963q);
        this.f48947a.m29722l0().mo1759d().m78382Q(backupOptionItemQueryItemByAppId);
    }

    /* renamed from: F */
    public final void m62064F(List<CloudBackupStatus> list) throws C9721b {
        final List list2;
        List<CloudBackupStatus> listM76016s;
        C9721b c9721b = null;
        try {
            list2 = (List) list.stream().map(new Function() { // from class: gm.q
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return ((CloudBackupStatus) obj).m29870d();
                }
            }).collect(Collectors.toList());
            listM76016s = C12594t1.m75990o().m76016s(this.f48951e);
        } catch (Exception unused) {
            C11839m.m70689w("CloudBackupV3Prepare", "delModuleInvalidMkfiles error.");
        }
        if (AbstractC14026a.m84159a(listM76016s)) {
            return;
        }
        Iterator it = ((List) listM76016s.stream().filter(new Predicate() { // from class: gm.r
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C10013v.m62021M0(list2, (CloudBackupStatus) obj);
            }
        }).collect(Collectors.toList())).iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            CloudBackupStatus cloudBackupStatus = (CloudBackupStatus) it.next();
            C11839m.m70688i("CloudBackupV3Prepare", "delete appId: " + cloudBackupStatus.m29870d() + " invalid mkfiles");
            try {
                new C9195d0(this.f48947a, cloudBackupStatus).m57757s("module_reset_from_module_delete_invalid");
            } catch (C9721b e10) {
                if (3924 == e10.m60659c()) {
                    c9721b = e10;
                    break;
                }
                C11839m.m70689w("CloudBackupV3Prepare", "delModuleInvalidMkfiles reset error.");
            }
        }
        if (c9721b != null) {
            throw c9721b;
        }
    }

    /* renamed from: F0 */
    public boolean m62065F0() {
        return this.f48969w;
    }

    /* renamed from: F1 */
    public final List<CloudBackupStatus> m62066F1() throws InterruptedException, C9721b {
        boolean z10;
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        List<CloudBackupStatus> listM76931j = new C12815f(this.f48951e).m76931j();
        if (listM76931j.isEmpty()) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<List<String>> it = this.f48957k.iterator();
        while (it.hasNext()) {
            arrayList2.addAll(it.next());
        }
        boolean z11 = (!C13452e.m80781L().m80887a1() || this.f48947a.isRefurbishment() || this.f48947a.mo29591n()) ? false : true;
        for (CloudBackupStatus cloudBackupStatus : listM76931j) {
            String strM29870d = cloudBackupStatus.m29870d();
            if (!this.f48947a.m29714i1()) {
                z10 = true;
            } else if (!cloudBackupStatus.m29863P()) {
                if (!this.f48947a.m29737q0().contains(strM29870d)) {
                    C11839m.m70688i("CloudBackupV3Prepare", "free user not support backup, delete appId： " + strM29870d);
                    z10 = false;
                }
                z10 = true;
            } else if (1 == this.f48944A) {
                C11839m.m70688i("CloudBackupV3Prepare", "free user not support backup, delete 3rd appId： " + strM29870d);
                z10 = false;
            } else {
                if (1 == cloudBackupStatus.m29351H0()) {
                    C11839m.m70688i("CloudBackupV3Prepare", "free user not support backup third data, reset 3rd appId: " + strM29870d);
                    hashSet.add(cloudBackupStatus);
                }
                z10 = true;
            }
            if (!arrayList2.contains(strM29870d) || !z10) {
                arrayList.add(cloudBackupStatus);
            } else if (m62019H0(z11, cloudBackupStatus)) {
                C11839m.m70688i("CloudBackupV3Prepare", "module no data8, reset appId: " + strM29870d);
                hashSet.add(cloudBackupStatus);
            } else {
                m62138s1(hashSet, cloudBackupStatus);
            }
        }
        m62078K(arrayList, "module_delete_from_prepare_app_not_backup");
        m62141t1(hashSet);
        return arrayList;
    }

    /* renamed from: G */
    public void m62067G(C13029h c13029h) throws InterruptedException, C9721b {
        if (!C13466f.m81073d().m81075b("isStartDeleteTask", false) || this.f48947a.isRefurbishment() || this.f48947a.mo29591n()) {
            return;
        }
        this.f48947a.m29635E2(c13029h, this.f48952f, false);
        AtomicInteger atomicInteger = new AtomicInteger(0);
        while (C12515a.m75110o().m75158X0(C0306w0.class.getName())) {
            SystemClock.sleep(500L);
            this.f48947a.isCancel();
            m62144v(atomicInteger.getAndIncrement());
        }
    }

    /* renamed from: G0 */
    public boolean m62068G0() {
        return this.f48949c;
    }

    /* renamed from: G1 */
    public final C13029h m62069G1(C13029h c13029h) throws C9721b {
        return this.f48947a.mo29591n() ? m62071H1(c13029h) : m62060D1(c13029h);
    }

    /* renamed from: H */
    public final void m62070H(String str) throws InterruptedException, C9721b {
        if (this.f48966t) {
            CBAccess.startDeleteTask(new C0257c1(this.f48952f, str, false, false, this.f48947a.isRefurbishment()));
            while (C12515a.m75110o().m75158X0(C0257c1.class.getName())) {
                SystemClock.sleep(500L);
                this.f48947a.isCancel();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0076  */
    /* renamed from: H1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final tl.C13029h m62071H1(tl.C13029h r8) throws fk.C9721b {
        /*
            r7 = this;
            java.lang.String r0 = r8.m78465h()
            com.huawei.hicloud.cloudbackup.v3.server.model.Bak r1 = r7.f48959m
            r2 = 0
            java.lang.String r3 = "empty_default_id"
            if (r1 == 0) goto L76
            java.lang.String r1 = r1.getGradeCode()
            boolean r4 = r3.equals(r0)
            if (r4 != 0) goto L39
            java.lang.String r4 = r7.m62096Z()
            boolean r4 = p618rm.C12590s0.m75828a1(r4)
            if (r4 == 0) goto L25
            boolean r4 = p618rm.C12590s0.m75828a1(r1)
            if (r4 == 0) goto L39
        L25:
            com.huawei.hicloud.cloudbackup.v3.core.a r4 = r7.f48947a
            java.lang.Integer r4 = r4.m29636F0()
            com.huawei.hicloud.cloudbackup.v3.server.model.Bak r5 = r7.f48959m
            java.lang.Integer r5 = r5.getOccupySpaceType()
            boolean r4 = java.util.Objects.equals(r4, r5)
            if (r4 == 0) goto L39
            r4 = r2
            goto L3a
        L39:
            r4 = 1
        L3a:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "updateTempTags isNeedNewCreateTags: "
            r5.append(r6)
            r5.append(r4)
            java.lang.String r6 = " ,inBackingBak.getGradeCode(): "
            r5.append(r6)
            r5.append(r1)
            java.lang.String r1 = r5.toString()
            java.lang.String r5 = "CloudBackupV3Prepare"
            p514o9.C11839m.m70688i(r5, r1)
            if (r4 == 0) goto L5b
            goto L76
        L5b:
            com.huawei.hicloud.cloudbackup.v3.server.model.Bak r0 = r7.f48959m
            java.lang.String r0 = r0.getId()
            r8.m78448N(r0)
            com.huawei.hicloud.cloudbackup.v3.server.model.Bak r0 = r7.f48959m
            long r0 = m62029W(r0)
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r8.m78458X(r0)
            tl.h r8 = r7.m62124n1(r8)
            goto La4
        L76:
            com.huawei.hicloud.cloudbackup.v3.server.model.Bak r1 = r7.f48959m
            java.lang.String r4 = "InterimBackup_updateTags"
            r7.m62080L(r1, r4)
            android.content.Context r1 = r7.f48961o
            com.huawei.hicloud.cloudbackup.v3.core.a r4 = r7.f48947a
            boolean r4 = r4.mo29591n()
            p744wl.C13617a.m81922d(r0, r1, r4)
            tl.i r0 = new tl.i
            r0.<init>()
            int r8 = r8.m78442H()
            r0.m78490a(r8)
            r0 = 0
            tl.h r8 = r7.m62058D(r3, r2, r0)
            com.huawei.hicloud.cloudbackup.v3.server.model.Bak r0 = m62031Y()
            r7.m62110g1(r8, r0)
            r7.m62055C(r8)
        La4:
            java.lang.String r0 = r8.m78465h()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto Lce
            java.lang.String r0 = r8.m78465h()
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto Lce
            com.huawei.hicloud.cloudbackup.v3.core.a r0 = r7.f48947a
            tl.g r0 = r0.m29725m0()
            java.lang.String r1 = r8.m78465h()
            r0.m78424m(r1)
            com.huawei.hicloud.cloudbackup.v3.core.a r7 = r7.f48947a
            java.lang.String r0 = r8.m78465h()
            r7.m29718j2(r0)
        Lce:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: gm.C10013v.m62071H1(tl.h):tl.h");
    }

    /* renamed from: I */
    public final void m62072I(List<Bak> list) {
        this.f48945B = list.stream().filter(new C10537j()).filter(new Predicate() { // from class: gm.m
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C10013v.m62022N0((Bak) obj);
            }
        }).anyMatch(new Predicate() { // from class: gm.n
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C10013v.m62023O0((Bak) obj);
            }
        });
        C11839m.m70688i("CloudBackupV3Prepare", "deleteInvalidTempBackup " + this.f48945B);
        if (this.f48947a.mo29591n()) {
            return;
        }
        Iterator it = ((List) list.stream().filter(new C10537j()).filter(new Predicate() { // from class: gm.o
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C10013v.m62024P0((Bak) obj);
            }
        }).filter(new Predicate() { // from class: gm.p
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C10013v.m62025Q0((Bak) obj);
            }
        }).collect(Collectors.toList())).iterator();
        while (it.hasNext()) {
            m62080L((Bak) it.next(), "InterimBackup_deleteInvalidTempBackup");
        }
    }

    /* renamed from: I0 */
    public final boolean m62073I0(String str, List<String> list) {
        return list.contains(str) || HNConstants.DataType.MEDIA.equals(str) || "music".equals(str);
    }

    /* renamed from: I1 */
    public final void m62074I1(String str, long j10) throws C9721b {
        BackupOptionItem backupOptionItemQueryItemByAppId = TransferedUtil.queryItemByAppId(str, this.f48947a.m29722l0().mo1759d());
        if (backupOptionItemQueryItemByAppId == null) {
            backupOptionItemQueryItemByAppId = m62086R(str, str, 0, "0", "virtualApp");
        }
        backupOptionItemQueryItemByAppId.setAppName(CloudBackupLanguageUtil.getVirtualName(str));
        backupOptionItemQueryItemByAppId.setDataBytes(j10);
        backupOptionItemQueryItemByAppId.setIsDataEnable(2);
        C12590s0.m75915w(backupOptionItemQueryItemByAppId, this.f48947a.mo29591n(), this.f48963q);
        this.f48947a.m29722l0().mo1759d().m78382Q(backupOptionItemQueryItemByAppId);
    }

    /* renamed from: J */
    public void m62075J() {
        C11839m.m70688i("CloudBackupV3Prepare", "deleteInvalidDMFiles start");
        try {
            for (CloudBackupStatus cloudBackupStatus : C12594t1.m75990o().m76016s(this.f48951e)) {
                if (TextUtils.isEmpty(this.f48947a.m29734p0())) {
                    break;
                } else if (C10278a.m63442h(C13617a.m81942x(this.f48947a.m29734p0(), cloudBackupStatus.m29870d(), 0, cloudBackupStatus.m29861N())).exists()) {
                    this.f48947a.isCancel();
                    new C9195d0(this.f48947a, cloudBackupStatus).m57751m("file_delete_from_space_not_enough_prepare");
                }
            }
        } catch (Throwable th2) {
            C11839m.m70688i("CloudBackupV3Prepare", "deleteInvalidDMFiles error, " + th2);
        }
        C11839m.m70688i("CloudBackupV3Prepare", "deleteInvalidDMFiles end");
    }

    /* renamed from: J0 */
    public final boolean m62076J0(List<Bak> list) {
        if (AbstractC14026a.m84159a(list)) {
            C11839m.m70688i("CloudBackupV3Prepare", "isSuccessBaksNumExceedsThreshold:successBaks is empty.");
            return false;
        }
        if (!C12605x0.m76072f(list)) {
            int iIntValue = this.f48947a.isRefurbishment() ? CloudBackupConstant.UserPackageInfo.NORMAL_BACKUP_RECORDS.intValue() : C12590s0.m75751H0();
            if (iIntValue <= 0) {
                C11839m.m70687e("CloudBackupV3Prepare", "invalid maxRecordNum:" + iIntValue);
                return false;
            }
            C11839m.m70688i("CloudBackupV3Prepare", "validSuccessBaks size is:" + list.size() + ",maxRecordNum is:" + iIntValue);
            return list.size() > iIntValue;
        }
        int iIntValue2 = this.f48947a.isRefurbishment() ? CloudBackupConstant.UserPackageInfo.NORMAL_BACKUP_RECORDS.intValue() : C12590s0.m75798T();
        if (iIntValue2 <= 0) {
            C11839m.m70687e("CloudBackupV3Prepare", "invalid maxBaseRecordNum:" + iIntValue2);
            return false;
        }
        long jCount = list.stream().filter(new Predicate() { // from class: gm.k
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C10013v.m62030W0((Bak) obj);
            }
        }).count();
        C11839m.m70688i("CloudBackupV3Prepare", "latest backup record was BASE_DATA,baseRecordNum is:" + jCount + ",maxBaseRecordNum is:" + iIntValue2);
        return jCount > ((long) iIntValue2);
    }

    /* renamed from: J1 */
    public final void m62077J1(List<String> list, String str) throws C9721b {
        long jM62149w1;
        BackupOptionItem backupOptionItemQueryItemByAppId;
        CloudBackupAppDataUtil cloudBackupAppDataUtil = new CloudBackupAppDataUtil(str, this.f48947a.getLocation(), 0L, this.f48947a.isRefurbishment(), this.f48947a.mo29591n());
        if (cloudBackupAppDataUtil.isAppDataAble()) {
            if (!this.f48964r || (backupOptionItemQueryItemByAppId = TransferedUtil.queryItemByAppId(str, this.f48947a.m29722l0().mo1759d())) == null) {
                jM62149w1 = m62149w1(str, cloudBackupAppDataUtil);
            } else {
                jM62149w1 = backupOptionItemQueryItemByAppId.getDataBytes();
                if (jM62149w1 == 0) {
                    C11839m.m70686d("CloudBackupV3Prepare", "updateVirtualModuleCache dataSize = 0");
                    jM62149w1 = m62149w1(str, cloudBackupAppDataUtil);
                } else {
                    m62074I1(str, jM62149w1);
                }
            }
            C11839m.m70686d("CloudBackupV3Prepare", "updateVirtualModuleCache appId = " + str + " isUseCache = " + this.f48964r + " dataSize = " + jM62149w1);
            if (jM62149w1 > 0) {
                list.add(str);
                m62145v0(str, 2);
                return;
            }
            C11839m.m70688i("CloudBackupV3Prepare", " virtual app is " + str + " , reason: 1");
            C12590s0.m75769L2(str, this.f48972z, 1);
        }
    }

    /* renamed from: K */
    public final void m62078K(List<CloudBackupStatus> list, String str) throws InterruptedException, C9721b {
        if (!TextUtils.isEmpty(this.f48947a.m29719k0()) && !TextUtils.isEmpty(this.f48947a.m29734p0())) {
            for (CloudBackupStatus cloudBackupStatus : list) {
                this.f48947a.isCancel();
                new C9195d0(this.f48947a, cloudBackupStatus).m57745g(str);
            }
            return;
        }
        C11839m.m70688i("CloudBackupV3Prepare", "deleteModules return bakid or DeviceId is empty");
        C12815f c12815f = new C12815f(this.f48951e);
        for (CloudBackupStatus cloudBackupStatus2 : list) {
            c12815f.m76924c(cloudBackupStatus2.m29870d(), cloudBackupStatus2.m29861N());
            C11839m.m70688i("CloudBackupV3Prepare", "deleteModules: " + cloudBackupStatus2.m29870d());
        }
    }

    /* renamed from: K0 */
    public final boolean m62079K0(long j10, long j11) {
        long jCurrentTimeMillis = System.currentTimeMillis() - j10;
        return j10 > 0 && jCurrentTimeMillis > 0 && jCurrentTimeMillis >= j11;
    }

    /* renamed from: L */
    public final void m62080L(Bak bak, String str) {
        if (bak == null) {
            C11839m.m70689w("CloudBackupV3Prepare", "deleteSingleBak bak is null");
        } else {
            this.f48945B = true;
            this.f48947a.m29686Z(bak.getId(), str);
        }
    }

    /* renamed from: M */
    public final void m62081M() throws InterruptedException, C9721b {
        C11839m.m70688i("CloudBackupV3Prepare", "wait DeleteRefurbishV3Task start");
        while (C12515a.m75110o().m75158X0(C0257c1.class.getName())) {
            this.f48947a.isCancel();
            SystemClock.sleep(1000L);
        }
        C11839m.m70688i("CloudBackupV3Prepare", "wait DeleteRefurbishV3Task end");
        while (C12515a.m75110o().m75158X0(C0306w0.class.getName())) {
            this.f48947a.isCancel();
            SystemClock.sleep(1000L);
        }
        if (this.f48945B) {
            C12526j c12526j = new C12526j();
            long jM75413q = c12526j.m75413q();
            int iM75415r = c12526j.m75415r();
            C11839m.m70688i("CloudBackupV3Prepare", "wait single delete start interval: " + jM75413q + " ,retryTimes: " + iM75415r);
            for (int i10 = 0; i10 < iM75415r; i10++) {
                this.f48947a.isCancel();
                Integer cloudOperationType = new C13998b0().m84137z("cloudOperationType", this.f48953g).getCloudOperationType();
                C11839m.m70688i("CloudBackupV3Prepare", "wait temp backup cloudOperationType: " + cloudOperationType);
                if (cloudOperationType.intValue() == 0) {
                    break;
                }
                for (int i11 = 0; i11 < jM75413q; i11++) {
                    this.f48947a.isCancel();
                    SystemClock.sleep(1000L);
                }
            }
            CBAccess.clearDeleteTask();
            C11839m.m70688i("CloudBackupV3Prepare", "wait single delete end");
        }
    }

    /* renamed from: N */
    public final void m62082N(CloudBackupStatus cloudBackupStatus, int i10, App app) throws C9721b {
        List<Attachment> attachments = app.getAttachments();
        if (attachments == null || attachments.isEmpty()) {
            return;
        }
        for (Attachment attachment : attachments) {
            if (attachment.getState().intValue() == 0 && SnapshotDBManager.PREFIX_DATABASE_NAME.equalsIgnoreCase(attachment.getUsage())) {
                m62083O(this.f48959m.getId(), app.getBackupAppName(), cloudBackupStatus.m29861N(), attachment.getAssetId(), app.getId(), attachment.getVersionId());
                if (i10 != 0) {
                    cloudBackupStatus.mo29338z0(0).mo29289A0(-1);
                }
            }
        }
    }

    /* renamed from: O */
    public final void m62083O(final String str, String str2, int i10, final String str3, final String str4, final String str5) throws C9721b {
        C11839m.m70688i("CloudBackupV3Prepare", "download snapshot begin, appid:" + str2 + ", assetId:" + str3 + ", , recordId:" + str4 + ", versionId:" + str5);
        String strM63452a = C10279b.m63452a(C10278a.m63437c(C10278a.m63442h(C13617a.m81942x(str, str2, 0, i10))));
        if (TextUtils.isEmpty(strM63452a)) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "get db parent path error, appId = " + str2, "downloadAttachment");
        }
        final String str6 = strM63452a + File.separator + str2 + FeedbackWebConstants.SUFFIX;
        C10546a.m64704a(new C10546a.a() { // from class: gm.t
            @Override // im.C10546a.a
            /* renamed from: a */
            public final InterfaceC10551c0 mo1696a() {
                return this.f48933a.m62087R0(str, str6, str3, str4, str5);
            }
        }).m64705b();
        boolean zM75805U2 = C12590s0.m75805U2(str6, strM63452a);
        if (!C11835i.m70643g(str6)) {
            C11839m.m70688i("CloudBackupV3Prepare", "delete snapshot tar file error: " + str6 + ", appid: " + str2);
        }
        if (!zM75805U2) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "unzip file: " + str6 + ", appid: " + str2 + ", errordownloadAttachment");
        }
        C11839m.m70688i("CloudBackupV3Prepare", "download snapshot end, appid:" + str2 + ", assetId:" + str3 + ", , recordId:" + str4 + ", versionId:" + str5);
    }

    /* renamed from: P */
    public C13029h m62084P() throws Throwable {
        C13029h c13029hM62132q0;
        m62137s();
        C4879a c4879a = this.f48947a;
        Objects.requireNonNull(c4879a);
        C13216j.m79431p(new C9991e(c4879a));
        if (this.f48947a.isRefurbishment()) {
            c13029hM62132q0 = m62157z0();
        } else if (this.f48947a.mo29591n()) {
            c13029hM62132q0 = m62059D0();
        } else {
            CBCallBack.getInstance().sendMessage(Message.obtain((Handler) null, 33032));
            c13029hM62132q0 = m62132q0();
        }
        C12299b.m73932n("backupAction", this.f48951e);
        this.f48947a.m29722l0().mo1758c();
        C4879a c4879a2 = this.f48947a;
        c4879a2.m29625A2(!c4879a2.mo29591n() && C9733f.m60705z().m60713H());
        this.f48947a.isCancel();
        m62126o0();
        this.f48947a.isCancel();
        m62125o();
        m62090U();
        m62085Q();
        this.f48947a.isCancel();
        m62055C(c13029hM62132q0);
        this.f48947a.isCancel();
        m62122m1();
        C14315h.m85262p().m85281r(C13452e.m80781L().m80887a1(), C13452e.m80781L().m80790C());
        this.f48947a.isCancel();
        m62099a1();
        m62070H(c13029hM62132q0.m78465h());
        this.f48947a.isCancel();
        C13029h c13029hM62069G1 = m62069G1(c13029hM62132q0);
        this.f48947a.isCancel();
        m62067G(c13029hM62069G1);
        m62081M();
        this.f48947a.isCancel();
        Lock lockM62103c1 = m62103c1(c13029hM62069G1);
        this.f48947a.isCancel();
        m62116j1(lockM62103c1);
        this.f48947a.isCancel();
        m62151x0();
        this.f48947a.isCancel();
        List<CloudBackupStatus> listM62066F1 = m62066F1();
        C11963c.m71951f(this.f48951e);
        C11963c.m71961p(this.f48951e);
        m62112h1();
        C14317j.m85301e(this.f48951e).m85308i(1);
        m62064F(listM62066F1);
        this.f48947a.isCancel();
        m62051A1(c13029hM62069G1, 0);
        this.f48947a.isCancel();
        C13029h c13029hM62061E = m62061E(c13029hM62069G1, lockM62103c1);
        CloudBackupStateUtil.recordBroadcastBackupId(1, c13029hM62061E.m78465h(), this.f48947a.isRefurbishment());
        C14317j.m85301e(this.f48951e).m85312m(c13029hM62061E);
        if (this.f48947a.isRefurbishment()) {
            ICBBroadcastManager.sendCloudBackupStateBroadcast(1, c13029hM62061E.m78465h(), true);
            ICBBroadcastManager.sendCloudBackupStateBroadcast(1, c13029hM62061E.m78465h(), false);
        }
        C11722c c11722c = new C11722c();
        c11722c.m69939p(c13029hM62061E.m78482u());
        this.f48947a.m29728n0().m8347v(c11722c);
        m62153y();
        this.f48947a.m29706f2(this.f48972z);
        return c13029hM62061E;
    }

    /* renamed from: Q */
    public final void m62085Q() {
        if (this.f48947a.isRefurbishment() || this.f48947a.mo29591n()) {
            return;
        }
        final C13026e c13026eMo1759d = this.f48947a.m29722l0().mo1759d();
        List<BackupOptionItem> listM78397u = c13026eMo1759d.m78397u();
        if (AbstractC14026a.m84159a(listM78397u)) {
            C11839m.m70689w("CloudBackupV3Prepare", "fixBackupSwitch allBackupItems isEmpty()");
            return;
        }
        ((List) listM78397u.stream().filter(new Predicate() { // from class: gm.f
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C10013v.m62026S0((BackupOptionItem) obj);
            }
        }).filter(new Predicate() { // from class: gm.g
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C10013v.m62027T0((BackupOptionItem) obj);
            }
        }).collect(Collectors.toList())).forEach(new Consumer() { // from class: gm.h
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                C10013v.m62028U0(c13026eMo1759d, (BackupOptionItem) obj);
            }
        });
        BackupOptionItem backupOptionItemM78401y = c13026eMo1759d.m78401y("soundrecorder");
        BackupOptionItem backupOptionItemM78401y2 = c13026eMo1759d.m78401y("callRecorder");
        if (backupOptionItemM78401y != null && backupOptionItemM78401y2 != null && backupOptionItemM78401y.getBackupSwitch() != backupOptionItemM78401y2.getBackupSwitch()) {
            c13026eMo1759d.m78376K(backupOptionItemM78401y.getBackupSwitch(), "callRecorder");
            C11839m.m70688i("CloudBackupV3Prepare", "fixBackupSwitch sounderrecord");
        }
        BackupOptionItem backupOptionItemM78401y3 = c13026eMo1759d.m78401y(NavigationUtils.SMS_SCHEMA_PREF);
        BackupOptionItem backupOptionItemM78401y4 = c13026eMo1759d.m78401y("chatSms");
        if (backupOptionItemM78401y3 == null || backupOptionItemM78401y4 == null || backupOptionItemM78401y3.getBackupSwitch() == backupOptionItemM78401y4.getBackupSwitch()) {
            return;
        }
        c13026eMo1759d.m78376K(backupOptionItemM78401y4.getBackupSwitch(), "chatSms");
        C11839m.m70688i("CloudBackupV3Prepare", "fixBackupSwitch sms");
    }

    /* renamed from: R */
    public final BackupOptionItem m62086R(String str, String str2, int i10, String str3, String str4) throws C9721b {
        C13026e c13026eMo1759d = this.f48947a.m29722l0().mo1759d();
        BackupOptionItem backupOptionItem = new BackupOptionItem(str, str4);
        boolean zM62102c0 = m62102c0(str, str4);
        backupOptionItem.setBackupSwitch(zM62102c0);
        backupOptionItem.setOriBackupAppName(str2);
        backupOptionItem.setSplitApkType(str3);
        backupOptionItem.setUid(i10);
        if ("thirdAppData".equals(str4)) {
            if (this.f48947a.mo29591n()) {
                backupOptionItem.setBackupData(zM62102c0);
            } else {
                backupOptionItem.setBackupSwitch(new CloudBackupAppDataUtil(str2, this.f48947a.getLocation(), ICBUtil.getVersionCode(this.f48961o.getPackageManager(), str2), "Refurbishment".equals(this.f48951e), this.f48947a.mo29591n()).getDefaultSwitch(str, !TextUtils.equals(str, str2), "CloudBackupV3Prepare"));
                backupOptionItem.setBackupData(true);
            }
        }
        c13026eMo1759d.m78370E(backupOptionItem);
        return backupOptionItem;
    }

    /* renamed from: R0 */
    public final /* synthetic */ InterfaceC10551c0 m62087R0(String str, String str2, String str3, String str4, String str5) throws C9721b {
        return new C10560j(str, this.f48953g, this.f48947a.m29728n0(), str2, this.f48951e, str3, str4, str5);
    }

    /* renamed from: S */
    public final String m62088S() {
        return this.f48948b ? "gradeCode,fileSourceStrategy,grayFlowStrategy,divideStrategy,enableAppDuplicator,baseAppid,bmType,applistStrategy,fileIdListMaxLen,acceptEncoding" : "gradeCode,fileSourceStrategy,times,baseBakNumber,refEffeDays,enableAppDuplicator,refEffeDelayDays,grayFlowStrategy,divideStrategy,baseAppid,bmType,applistStrategy,manualBypassOnFault,fileIdListMaxLen,acceptEncoding";
    }

    /* renamed from: T */
    public Map<String, Bundle> m62089T() {
        return this.f48956j;
    }

    /* renamed from: U */
    public final void m62090U() {
        this.f48947a.m29709g2(C9733f.m60705z().m60763v("backupCompressionSparse"));
    }

    /* renamed from: V */
    public List<List<String>> m62091V() {
        return this.f48957k;
    }

    /* renamed from: V0 */
    public final /* synthetic */ boolean m62092V0(String str) {
        return this.f48947a.m29737q0().contains(str);
    }

    /* renamed from: X */
    public String m62093X() {
        return this.f48955i.toString();
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Bak$List] */
    /* renamed from: X0 */
    public final /* synthetic */ CloudBackupV3Request m62094X0(String str, CloudBackupV3Server cloudBackupV3Server) throws IOException {
        Bak.List list = cloudBackupV3Server.backup().device().bak().list();
        list.setFields(str).setBackupAction(this.f48951e).setBackupDeviceId(this.f48952f).setBakCategory(this.f48947a.m29587j()).setOccupySpaceType(this.f48947a.m29636F0()).setContainInterim(true).setHeader("x-hw-contain-refurbishment", Boolean.TRUE);
        return list;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Bak$Start] */
    /* renamed from: Y0 */
    public final /* synthetic */ CloudBackupV3Request m62095Y0(BakCreate bakCreate, String str, String str2, String str3, CloudBackupV3Server cloudBackupV3Server) throws IOException {
        Bak.Start start = cloudBackupV3Server.backup().device().bak().start(bakCreate);
        start.setFields(str).setBackupAction(this.f48951e).setInterimChannel(this.f48947a.m29761y0()).setBackupDeviceId(str2).setLockId(str3).setOccupySpaceType(this.f48947a.m29636F0()).setBakCategory(this.f48947a.m29587j()).setGradeCode(C12590s0.m75747G0());
        return start;
    }

    /* renamed from: Z */
    public String m62096Z() {
        return this.f48967u;
    }

    /* renamed from: Z0 */
    public final BakList m62097Z0() throws C9721b {
        final String str = "baks(id,backupVersion,bakCategory,occupySpaceType,backupStatus,startTime,updateTime,expirationTime,endTime,isRefurbishment,gradeCode,incType,bmDataType,properties)";
        return (BakList) new C14000c0(new C14000c0.a() { // from class: gm.i
            @Override // p814yl.C14000c0.a
            /* renamed from: a */
            public final CloudBackupV3Request mo1697a(CloudBackupV3Server cloudBackupV3Server) {
                return this.f48907a.m62094X0(str, cloudBackupV3Server);
            }
        }).m84139b("Backup.device.baks.list", this.f48953g);
    }

    /* renamed from: a0 */
    public String m62098a0() {
        com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak bak = this.f48960n;
        if (bak == null || bak.getEndTime() == null) {
            return "0";
        }
        return String.valueOf((System.currentTimeMillis() - this.f48960n.getEndTime().m28458c()) / 1000);
    }

    /* renamed from: a1 */
    public final void m62099a1() throws Throwable {
        List<com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak> arrayList = new ArrayList<>();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (!"1".equalsIgnoreCase(new SettingOperator().queryBakSourceStrategy()) || this.f48947a.isRefurbishment() || this.f48947a.mo29591n()) {
            arrayList = m62097Z0().getBaks();
        } else {
            m62101b1(arrayList);
        }
        if (arrayList == null || arrayList.isEmpty()) {
            C11839m.m70688i("CloudBackupV3Prepare", "list backup records is empty");
            C13617a.m81920b(true, true);
            this.f48969w = true;
            return;
        }
        ArrayList arrayList4 = new ArrayList();
        this.f48947a.isCancel();
        m62072I(arrayList);
        for (com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak bak : arrayList) {
            if (bak == null) {
                C11839m.m70689w("CloudBackupV3Prepare", "listBackupRecords bak is null");
            } else if (C12590s0.m75728B1(bak.getBackupVersion())) {
                C11839m.m70689w("CloudBackupV3Prepare", "current bak is V4,bakVersion is:" + bak.getBackupVersion() + ",backupId is:" + bak.getId());
            } else {
                m62150x(bak);
                if ((this.f48947a.isRefurbishment() && !bak.isRefurbishment()) || (!this.f48947a.isRefurbishment() && bak.isRefurbishment())) {
                    C11839m.m70688i("CloudBackupV3Prepare", "skip record id : " + bak.getId() + ", isRefurbishment: " + this.f48947a.isRefurbishment() + ", bak.isRefurbishment: " + bak.isRefurbishment());
                } else if (this.f48947a.mo29591n() || !bak.isTempBackup()) {
                    int iIntValue = bak.getBackupStatus().intValue();
                    arrayList4.add(bak.getId());
                    if (iIntValue == 0) {
                        arrayList2.add(bak);
                    } else if (iIntValue == 1) {
                        m62106e1(bak, arrayList3);
                    } else if (iIntValue == 6 || iIntValue == 7) {
                        arrayList3.add(bak.getId());
                    }
                } else {
                    C11839m.m70688i("CloudBackupV3Prepare", "skip record id : " + bak.getId() + ", isTempBackup: " + this.f48947a.mo29591n() + ", bak.isTempBackup: " + bak.isTempBackup());
                }
            }
        }
        m62108f1(arrayList2);
        m62147w(arrayList2, arrayList3);
        C13617a.m81930l(arrayList4);
    }

    /* renamed from: b0 */
    public final String m62100b0(App app, CloudBackupStatus cloudBackupStatus) {
        String str = app.getProperties().get("bmAppDataType");
        if (TextUtils.isEmpty(str)) {
            str = "";
        } else if (cloudBackupStatus.m29863P() && 1 != cloudBackupStatus.m29351H0()) {
            str = this.f48947a.m29737q0().contains("applistStrategy") ? "1" : "2";
        }
        C11839m.m70688i("CloudBackupV3Prepare", "getModuleDataBmTypeFromPro appId: " + cloudBackupStatus.m29870d() + " ,bmType: " + str);
        return str;
    }

    /* renamed from: b1 */
    public final void m62101b1(List<com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak> list) throws Throwable {
        C11322a c11322a = new C11322a(this.f48953g);
        for (CBSBackupRecord cBSBackupRecord : c11322a.m67998E(false, true, false)) {
            String deviceId = cBSBackupRecord.getDevice().getDeviceId();
            if (deviceId != null && !deviceId.isEmpty() && this.f48954h.equals(deviceId)) {
                String version = cBSBackupRecord.getVersion();
                if (1 == cBSBackupRecord.getStatus() && (C12590s0.m75921x1(version) || C12590s0.m75925y1(version))) {
                    C11839m.m70688i("CloudBackupV3Prepare", "delete v2 in backup recoed id : " + cBSBackupRecord.getBackupId());
                    c11322a.m68015V(cBSBackupRecord.getBackupId(), deviceId, cBSBackupRecord.getDevice().getDeviceType(), this.f48948b ? 1 : 0, 7, TextUtils.isEmpty(cBSBackupRecord.getSnapshot()) ? "" : cBSBackupRecord.getSnapshot());
                    cBSBackupRecord.setStatus(7);
                    C11839m.m70688i("CloudBackupV3Prepare", "delete v2 in backup end, recoed id : " + cBSBackupRecord.getBackupId());
                    C13466f.m81073d().m81081i("isStartDeleteTask", true);
                }
                com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak bak = new com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak();
                bak.setId(cBSBackupRecord.getBackupId());
                bak.setBackupDeviceId(cBSBackupRecord.getBackupDeviceId());
                bak.setBackupStatus(Integer.valueOf(cBSBackupRecord.getStatus()));
                bak.setBackupVersion(version);
                bak.setOccupySpaceType(cBSBackupRecord.getOccupySpaceType());
                bak.setBakCategory(cBSBackupRecord.getBakCategory());
                bak.setStartTime(new C4644l(cBSBackupRecord.getStartTime()));
                bak.setRefurbishment(cBSBackupRecord.isRefurbishment());
                bak.setGradeCode(cBSBackupRecord.getGradeCode());
                bak.setBmDataType(Integer.valueOf(cBSBackupRecord.getBmDataType()));
                bak.setEndTime(new C4644l(cBSBackupRecord.getEndTime()));
                if (cBSBackupRecord.getStatus() == 0) {
                    if (C12590s0.m75921x1(version) || C12590s0.m75925y1(version)) {
                        Map<String, String> map = new HashMap<>();
                        map.put(SnapshotDBManager.PREFIX_DATABASE_NAME, cBSBackupRecord.getSnapshot());
                        bak.setProperties(map);
                    }
                    if (C12590s0.m75921x1(version)) {
                        bak.put("CBSBackupRecord", (Object) cBSBackupRecord);
                    }
                }
                list.add(bak);
            }
        }
    }

    /* renamed from: c0 */
    public final boolean m62102c0(String str, String str2) {
        if ("baseData".equals(str2) || !this.f48947a.mo29591n()) {
            return true;
        }
        return this.f48946C.contains(str);
    }

    /* renamed from: c1 */
    public final Lock m62103c1(C13029h c13029h) throws C9721b {
        long jCurrentTimeMillis;
        String str;
        int i10;
        int iM1685c;
        String strM62098a0 = m62098a0();
        if (c13029h == null || "empty_default_id".equals(c13029h.m78465h())) {
            jCurrentTimeMillis = 0;
            str = null;
            i10 = 0;
            iM1685c = 0;
        } else {
            int iM78476r = c13029h.m78476r() + 1;
            jCurrentTimeMillis = (System.currentTimeMillis() - c13029h.m78466i()) / 1000;
            String strM78465h = c13029h.m78465h();
            iM1685c = !TextUtils.isEmpty(c13029h.m78480t()) ? C0241z.m1685c(c13029h.m78480t()) : 0;
            this.f48950d = 1;
            str = strM78465h;
            i10 = iM78476r;
        }
        C1457c c1457c = new C1457c(new C10321z(this.f48951e, this.f48947a.m29636F0(), this.f48947a.m29587j(), CloudBackupConstant.Command.PMS_CMD_BACKUP, this.f48953g), this.f48952f, str, this.f48967u, i10, jCurrentTimeMillis < 0 ? 0L : jCurrentTimeMillis, m62068G0(), false, strM62098a0, String.valueOf(iM1685c));
        c1457c.m8342q(this.f48969w);
        c1457c.m8345t(this.f48947a.isAutoBackup());
        m62131q(c1457c);
        this.f48947a.m29715i2(c1457c);
        C4879a c4879a = this.f48947a;
        Objects.requireNonNull(c4879a);
        Lock lockM8337j = c1457c.m8337j(new C9991e(c4879a));
        List<String> cloudControlAction = lockM8337j.getCloudControlAction();
        if (cloudControlAction != null && !cloudControlAction.isEmpty()) {
            this.f48955i.addAll(cloudControlAction);
            if (this.f48955i.contains("1")) {
                C11839m.m70688i("CloudBackupV3Prepare", "get full backup info is true");
                m62158z1();
                this.f48950d = 0;
                c1457c.m8343r(m62068G0());
            }
        }
        c1457c.m8328c();
        return lockM8337j;
    }

    /* renamed from: d0 */
    public final boolean m62104d0(String str) {
        Boolean boolMo1756a = this.f48947a.m29722l0().mo1756a(str);
        if (boolMo1756a == null) {
            boolMo1756a = Boolean.valueOf(m62102c0(str, TransferedUtil.getItemParent(str)));
        }
        return boolMo1756a.booleanValue();
    }

    /* renamed from: e0 */
    public final String m62105e0(String str) {
        C13219m<String, Integer, Integer> c13219m = this.f48968v.get(str);
        return c13219m != null ? c13219m.m79449b() : str;
    }

    /* renamed from: e1 */
    public final void m62106e1(com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak bak, List<String> list) {
        if (this.f48947a.mo29591n()) {
            if (bak.isTempBackup()) {
                this.f48958l.add(bak.getId());
                this.f48959m = bak;
                C11839m.m70688i("CloudBackupV3Prepare", "temp backup reuse record id : " + bak.getId());
                return;
            }
            return;
        }
        if (this.f48947a.isRefurbishment() || !C12590s0.m75869k1(m62096Z()) || C12590s0.m75857h1(bak.getBmDataType())) {
            this.f48958l.add(bak.getId());
            this.f48959m = bak;
            C11839m.m70688i("CloudBackupV3Prepare", "reuse record id : " + bak.getId() + ", firstBackupFlag = " + this.f48950d);
            return;
        }
        C11839m.m70688i("CloudBackupV3Prepare", "invalid record id : " + bak.getId());
        if (C12590s0.m75873l1(bak.getBackupVersion())) {
            C13617a.m81922d(bak.getId(), this.f48961o, this.f48947a.mo29591n());
            C11839m.m70688i("CloudBackupV3Prepare", "delete inBacking cache, invalid record id : " + bak.getId());
        }
        list.add(bak.getId());
    }

    /* renamed from: f0 */
    public Map<String, SyncSwitchBackupInfo> m62107f0() {
        return this.f48971y;
    }

    /* renamed from: f1 */
    public final void m62108f1(List<com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak> list) throws C9721b {
        if (this.f48947a.mo29591n()) {
            this.f48969w = list.isEmpty();
            return;
        }
        Collections.sort(list);
        ArrayList arrayList = new ArrayList();
        int iIntValue = this.f48947a.isRefurbishment() ? CloudBackupConstant.UserPackageInfo.NORMAL_BACKUP_RECORDS.intValue() : C12590s0.m75751H0();
        Iterator<com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak next = it.next();
            if (!this.f48947a.isRefurbishment() && !C12590s0.m75857h1(next.getBmDataType())) {
                this.f48947a.m29748t2(false);
            }
            arrayList.add(next);
            if (next.getIncType() == 0) {
                C11839m.m70688i("CloudBackupV3Prepare", "bakckuprecord is full bak id: " + next.getId());
                break;
            }
            if (arrayList.size() >= iIntValue) {
                C11839m.m70688i("CloudBackupV3Prepare", "setSuccessBaksforupdate max baks is " + arrayList.size());
                break;
            }
        }
        this.f48947a.m29760x2(list);
        this.f48947a.m29762y2(arrayList);
        if (list.isEmpty()) {
            this.f48969w = true;
            return;
        }
        this.f48960n = list.get(0);
        if (this.f48947a.isRefurbishment()) {
            return;
        }
        m62146v1(list.get(0));
        m62156z(list.get(0));
    }

    /* renamed from: g0 */
    public final int m62109g0() {
        if (this.f48947a.mo29591n()) {
            return 5;
        }
        if (this.f48947a.isRefurbishment()) {
            return 4;
        }
        return this.f48948b ? 2 : 1;
    }

    /* renamed from: g1 */
    public final void m62110g1(C13029h c13029h, com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak bak) {
        if (bak == null || !this.f48947a.mo29591n()) {
            return;
        }
        long jM62029W = m62029W(bak);
        c13029h.m78458X(String.valueOf(jM62029W));
        new C13030i().m78496g(c13029h);
        ContentValues contentValues = new ContentValues();
        contentValues.put("expired_time", Long.valueOf(jM62029W));
        C12299b.m73937s(contentValues);
    }

    /* renamed from: h0 */
    public final void m62111h0(C13029h c13029h, int i10, C11726g c11726g, CloudSpace cloudSpace, long j10) throws C9721b {
        if (j10 >= c11726g.m69963a()) {
            new SettingOperator().replace(new Settings[]{new Settings("nextbackuptime", "0", "2")});
            return;
        }
        if (!this.f48964r || i10 >= 1) {
            C11839m.m70687e("CloudBackupV3Prepare", "backup failed to pass space pre-check, task will be canceled");
            C12590s0.m75759J0(cloudSpace, c13029h, this.f48961o, this.f48948b, this.f48965s, true, "1");
        } else {
            this.f48964r = false;
            m62062E0(new ArrayList());
            m62117k0();
            m62051A1(c13029h, i10 + 1);
        }
    }

    /* renamed from: h1 */
    public final void m62112h1() {
        C12526j c12526j = this.f48962p;
        if (c12526j == null) {
            return;
        }
        long jM75406m0 = c12526j.m75406m0(this.f48947a.isAutoBackup());
        try {
            List<CloudBackupStatus> listM76931j = new C12815f(this.f48951e).m76931j();
            if (listM76931j == null || listM76931j.isEmpty()) {
                return;
            }
            for (CloudBackupStatus cloudBackupStatus : listM76931j) {
                if (cloudBackupStatus.m29859L() == 6 && cloudBackupStatus.m29863P() && cloudBackupStatus.m29351H0() == 1) {
                    if (m62079K0(cloudBackupStatus.m29404g1() > 0 ? cloudBackupStatus.m29404g1() : cloudBackupStatus.m29385X0(), jM75406m0)) {
                        cloudBackupStatus.mo29406h0(-1);
                        C11963c.m71970y(cloudBackupStatus, this.f48951e);
                    }
                }
            }
        } catch (C9721b e10) {
            C11839m.m70686d("CloudBackupV3Prepare", "recordOverDuration3rdApp  CException" + e10.getMessage());
        }
    }

    /* renamed from: i0 */
    public final void m62113i0(C13029h c13029h, long j10, CloudSpace cloudSpace, long j11) throws C9721b {
        if (j11 >= (j10 << 20)) {
            new SettingOperator().replace(new Settings[]{new Settings("nextbackuptime", "0", "2")});
        } else {
            C11839m.m70687e("CloudBackupV3Prepare", "backup failed to pass space pre-check, task will be canceled");
            C12590s0.m75759J0(cloudSpace, c13029h, this.f48961o, this.f48948b, this.f48965s, true, "1");
        }
    }

    /* renamed from: i1 */
    public final void m62114i1(String str) {
        Map<String, SyncAppBackupPolicy> mapM76029e = C12597u1.m76029e();
        Map<String, Integer> mapM76030f = C12597u1.m76030f();
        if (mapM76029e.containsKey(str)) {
            String syncAppName = mapM76029e.get(str).getSyncAppName();
            int policy = mapM76029e.get(str).getPolicy();
            int iIntValue = mapM76030f.getOrDefault(syncAppName, 0).intValue();
            SyncSwitchBackupInfo syncSwitchBackupInfo = new SyncSwitchBackupInfo();
            syncSwitchBackupInfo.setSyncAppExclusiveSupport(C9733f.m60705z().m60720O("cloudBackupSyncSwitchBackup"));
            syncSwitchBackupInfo.setSyncAppName(syncAppName);
            syncSwitchBackupInfo.setBackupAppName(str);
            syncSwitchBackupInfo.setSyncSwitchOpen(1 == iIntValue);
            syncSwitchBackupInfo.setPolicy(policy);
            syncSwitchBackupInfo.setBackupSwitchOpen(false);
            this.f48971y.put(str, syncSwitchBackupInfo);
        }
    }

    /* renamed from: j0 */
    public final void m62115j0(List<String> list, List<String> list2) throws InterruptedException, C9721b {
        this.f48947a.isCancel();
        Bundle backupModuleInfo = CloneService.getInstance().getBackupModuleInfo("app", true);
        C13026e c13026eMo1759d = this.f48947a.m29722l0().mo1759d();
        Bundle bundle = (Bundle) new C10343b(backupModuleInfo).m63680b("app");
        if (bundle == null) {
            return;
        }
        ArrayList<String> stringArrayList = bundle.getStringArrayList("AppPackageList");
        List<String> listM78398v = c13026eMo1759d.m78398v("thirdAppData");
        if (stringArrayList == null) {
            stringArrayList = new ArrayList<>();
        }
        stringArrayList.removeAll(list2);
        Map<String, C13219m<String, Integer, Integer>> map = this.f48968v;
        final C4879a c4879a = this.f48947a;
        Objects.requireNonNull(c4879a);
        map.putAll(m62119l0(stringArrayList, new Function() { // from class: gm.l
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Boolean.valueOf(c4879a.isSupportSplitApp((String) obj));
            }
        }));
        stringArrayList.addAll(this.f48968v.keySet());
        stringArrayList.removeAll(list2);
        stringArrayList.removeAll(C12590s0.m75727B0());
        listM78398v.removeAll(stringArrayList);
        if (listM78398v.size() > 0) {
            c13026eMo1759d.m78387h(listM78398v);
        }
        if (stringArrayList.isEmpty()) {
            return;
        }
        list.addAll(stringArrayList);
        for (String str : stringArrayList) {
            this.f48947a.isCancel();
            if (1 != this.f48944A) {
                Bundle bundle2 = new Bundle();
                bundle2.putInt(m62105e0(str), 1);
                Bundle bundle3 = new Bundle();
                bundle3.putInt(CloneService.KEY_ACTION_FLAG, 10);
                bundle3.putBundle("app", bundle2);
                this.f48956j.put(str, bundle3);
                m62121m0(str);
            } else {
                C11839m.m70688i("CloudBackupV3Prepare", "not support backup 3rd appId: " + str);
            }
        }
    }

    /* renamed from: j1 */
    public final void m62116j1(Lock lock) throws InterruptedException, C9721b {
        if (this.f48959m != null) {
            m62140t0(lock);
            m62139t(this.f48959m.getId());
        }
        if (this.f48947a.m29645J0().isEmpty()) {
            return;
        }
        com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak bak = this.f48947a.m29645J0().get(0);
        new C12610z0(this.f48947a, this.f48951e, this.f48953g, bak.getId(), bak.getBackupVersion(), bak.getProperties()).m76087d();
    }

    /* renamed from: k0 */
    public final void m62117k0() throws C9721b {
        long dataBytes;
        PackageManager packageManager = this.f48961o.getPackageManager();
        boolean zM75353O0 = this.f48962p.m75353O0();
        boolean z10 = true;
        if (this.f48957k.size() > 1) {
            for (String str : this.f48957k.get(1)) {
                for (CloudBackupStatus cloudBackupStatus : new C12815f(this.f48951e).m76933l(str)) {
                    BackupOptionItem backupOptionItemQueryItem = TransferedUtil.queryItem(str, this.f48947a.m29722l0().mo1759d());
                    if (zM75353O0) {
                        String strMo29421n = cloudBackupStatus.mo29421n();
                        CloudBackupAppDataUtil cloudBackupAppDataUtil = new CloudBackupAppDataUtil(strMo29421n, this.f48947a.getLocation(), ICBUtil.getVersionCode(packageManager, strMo29421n), this.f48947a.isRefurbishment(), this.f48947a.mo29591n());
                        boolean z11 = (this.f48947a.isSupportPMS() && cloudBackupAppDataUtil.isAppDataAble()) ? z10 : false;
                        if ((backupOptionItemQueryItem != null && backupOptionItemQueryItem.isOmConfigAble() && backupOptionItemQueryItem.getBackupSwitch()) || z11) {
                            if (cloudBackupStatus.m29861N() != 0) {
                                cloudBackupAppDataUtil.changeToSeparaSetting(cloudBackupStatus.m29861N());
                            }
                            if (!this.f48964r) {
                                ScanAppDataUtil scanAppDataUtil = new ScanAppDataUtil(str, cloudBackupStatus.m29861N(), cloudBackupStatus.mo29421n(), cloudBackupAppDataUtil.getmCloudBackupInclude(), cloudBackupAppDataUtil.getmCloudBackupExclude());
                                dataBytes = scanAppDataUtil.get3rdAppDataSizeInfo(cloudBackupAppDataUtil, this.f48947a.m29726m1(), backupOptionItemQueryItem, scanAppDataUtil)[0];
                            } else if (backupOptionItemQueryItem == null || backupOptionItemQueryItem.getDataBytes() <= 0) {
                                ScanAppDataUtil scanAppDataUtil2 = new ScanAppDataUtil(str, cloudBackupStatus.m29861N(), cloudBackupStatus.mo29421n(), cloudBackupAppDataUtil.getmCloudBackupInclude(), cloudBackupAppDataUtil.getmCloudBackupExclude());
                                dataBytes = scanAppDataUtil2.get3rdAppDataSizeInfo(cloudBackupAppDataUtil, this.f48947a.m29726m1(), backupOptionItemQueryItem, scanAppDataUtil2)[0];
                            } else {
                                dataBytes = backupOptionItemQueryItem.getDataBytes();
                            }
                            m62057C1(cloudBackupStatus, dataBytes);
                        }
                    }
                    z10 = true;
                }
            }
        }
        if (this.f48964r) {
            return;
        }
        this.f48947a.m29722l0().mo1762h();
    }

    /* renamed from: k1 */
    public final void m62118k1(CloudBackupStatus cloudBackupStatus, BackupOptionItem backupOptionItem) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("appId = ");
        sb2.append(cloudBackupStatus.m29870d());
        sb2.append(", count = ");
        sb2.append(backupOptionItem != null ? Integer.valueOf(backupOptionItem.getItemTotal()) : null);
        C11839m.m70686d("CloudBackupV3Prepare", sb2.toString());
        if (cloudBackupStatus.m29859L() == 0) {
            cloudBackupStatus.m29436s2(0L);
            long dataBytes = backupOptionItem != null ? backupOptionItem.getDataBytes() : 0L;
            CloudBackupStatus cloudBackupStatusMo29327g0 = cloudBackupStatus.mo29327g0(backupOptionItem != null ? backupOptionItem.getItemTotal() : 0);
            if (!cloudBackupStatus.m29863P() || !cloudBackupStatus.m29425o1()) {
                dataBytes = 0;
            }
            cloudBackupStatusMo29327g0.mo29323e0(dataBytes);
        } else if (cloudBackupStatus.m29859L() != 5 && cloudBackupStatus.m29859L() != 6) {
            m62155y1(cloudBackupStatus, backupOptionItem != null ? backupOptionItem.getDataBytes() : 0L);
        } else if (cloudBackupStatus.m29859L() == 6) {
            cloudBackupStatus.mo29289A0(7);
        }
        if (!cloudBackupStatus.m29866T() || cloudBackupStatus.m29859L() >= 4) {
            return;
        }
        cloudBackupStatus.mo29327g0(backupOptionItem != null ? backupOptionItem.getItemTotal() : 0).mo29323e0(backupOptionItem != null ? backupOptionItem.getDataBytes() : 0L);
    }

    /* renamed from: l0 */
    public final Map<String, C13219m<String, Integer, Integer>> m62119l0(List<String> list, Function<String, Boolean> function) {
        return SplitAppUtil.init3rdAppTwinsList(list, function);
    }

    /* renamed from: l1 */
    public final void m62120l1() {
        if (this.f48947a.mo29591n() && C12590s0.m75828a1(m62096Z()) && Objects.equals(this.f48947a.m29636F0(), 1)) {
            this.f48947a.m29673U1(0);
            C11839m.m70688i("CloudBackupV3Prepare", "refreshOccupySpaceType to free");
        }
    }

    /* renamed from: m0 */
    public final void m62121m0(String str) throws InterruptedException, C9721b {
        C13219m<String, Integer, Integer> c13219m = this.f48968v.get(str);
        if (c13219m != null) {
            m62123n0(str, c13219m);
        } else {
            m62148w0(str, 1, 0);
        }
    }

    /* renamed from: m1 */
    public final void m62122m1() throws C9721b {
        C9721b c9721bRefreshSwitchStatusSync;
        if (this.f48947a.isRefurbishment() || this.f48947a.mo29591n() || (c9721bRefreshSwitchStatusSync = CloudBackupService.getInstance().refreshSwitchStatusSync(true, this.f48953g)) == null) {
            return;
        }
        int iM60659c = c9721bRefreshSwitchStatusSync.m60659c();
        int iM60663g = c9721bRefreshSwitchStatusSync.m60663g();
        if (iM60659c == 3911 && String.valueOf(iM60663g).endsWith(String.valueOf(4948))) {
            throw c9721bRefreshSwitchStatusSync;
        }
    }

    /* renamed from: n0 */
    public final void m62123n0(String str, C13219m<String, Integer, Integer> c13219m) throws InterruptedException, C9721b {
        C12815f c12815f;
        int i10;
        CloudBackupAppDataUtil cloudBackupAppDataUtil;
        BackupOptionItem backupOptionItem;
        String str2;
        if (c13219m == null) {
            return;
        }
        String strM79449b = c13219m.m79449b();
        String strValueOf = String.valueOf(c13219m.m79450c());
        int iIntValue = c13219m.m79451d().intValue();
        C12815f c12815f2 = new C12815f(this.f48951e);
        m62142u(iIntValue, str, c12815f2);
        this.f48947a.isCancel();
        CloudBackupStatus cloudBackupStatusM76928g = c12815f2.m76928g(str);
        if (cloudBackupStatusM76928g == null) {
            cloudBackupStatusM76928g = new CloudBackupStatus();
            cloudBackupStatusM76928g.mo29313Y(str).mo29413k0(strM79449b).mo29318b0(1).mo29338z0(0).mo29289A0(0).mo29452y0(strValueOf).mo29310W(0).mo29308V(0L);
        }
        CloudBackupStatus cloudBackupStatus = cloudBackupStatusM76928g;
        C13026e c13026eMo1759d = this.f48947a.m29722l0().mo1759d();
        BackupOptionItem backupOptionItemM78401y = c13026eMo1759d.m78401y(str);
        if (backupOptionItemM78401y == null) {
            backupOptionItemM78401y = m62086R(str, strM79449b, iIntValue, strValueOf, "thirdAppData");
        }
        BackupOptionItem backupOptionItem2 = backupOptionItemM78401y;
        CloudBackupAppDataUtil cloudBackupAppDataUtil2 = new CloudBackupAppDataUtil(strM79449b, this.f48947a.getLocation(), ICBUtil.getVersionCode(this.f48961o.getPackageManager(), strM79449b), this.f48947a.isRefurbishment(), this.f48947a.mo29591n());
        cloudBackupAppDataUtil2.changeToSeparaSetting(iIntValue);
        if (backupOptionItem2.getDataBytes() <= 0) {
            c12815f = c12815f2;
            i10 = iIntValue;
            cloudBackupAppDataUtil = cloudBackupAppDataUtil2;
            backupOptionItem = backupOptionItem2;
            long j10 = new ScanAppDataUtil(str, iIntValue, strM79449b, cloudBackupAppDataUtil2.getmCloudBackupInclude(), cloudBackupAppDataUtil2.getmCloudBackupExclude()).get3rdAppDataSize(cloudBackupAppDataUtil);
            backupOptionItem.setDataBytes(j10);
            backupOptionItem.setIsDataEnable(2);
            C12590s0.m75915w(backupOptionItem, this.f48947a.mo29591n(), this.f48963q);
            c13026eMo1759d.m78382Q(backupOptionItem);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("initAppTwinStatus get3rdAppDataSize appId: ");
            str2 = str;
            sb2.append(str2);
            sb2.append(" , uid: ");
            sb2.append(i10);
            sb2.append(" , dataSize: ");
            sb2.append(j10);
            C11839m.m70688i("CloudBackupV3Prepare", sb2.toString());
        } else {
            c12815f = c12815f2;
            i10 = iIntValue;
            cloudBackupAppDataUtil = cloudBackupAppDataUtil2;
            backupOptionItem = backupOptionItem2;
            str2 = str;
        }
        boolean backupSwitch = backupOptionItem.getBackupSwitch();
        if (backupSwitch && this.f48947a.isSupportPMS() && cloudBackupAppDataUtil.isAppDataAble()) {
            m62152x1(str2, backupOptionItem);
        }
        cloudBackupStatus.mo29340B0(i10).m29339A1(backupSwitch).m29408h2(C12565k.m75518d(strM79449b));
        m62118k1(cloudBackupStatus, backupOptionItem);
        m62048u1(c12815f, cloudBackupStatus);
    }

    /* renamed from: n1 */
    public final C13029h m62124n1(C13029h c13029h) {
        C13030i c13030i = new C13030i();
        if (System.currentTimeMillis() - c13029h.m78440F() > 604800000) {
            m62133q1(c13029h, SyncProtocol.Constant.EXPIRED, false);
            c13030i.m78490a(c13029h.m78442H());
            String strM78486w = c13029h.m78486w();
            c13029h = m62058D(c13029h.m78465h(), c13029h.m78476r(), c13029h.m78466i());
            c13029h.m78458X(strM78486w);
        }
        c13029h.m78453S(c13029h.m78476r() + 1);
        c13029h.m78483u0(this.f48953g);
        c13029h.m78470m0(0);
        c13029h.m78450P(System.currentTimeMillis());
        c13029h.m78452R("");
        if (c13029h.m78466i() == 0) {
            c13029h.m78449O(c13029h.m78440F());
        }
        int iM62109g0 = m62109g0();
        if (iM62109g0 != c13029h.m78442H()) {
            c13030i.m78490a(c13029h.m78442H());
            c13029h.m78479s0(iM62109g0);
        }
        c13030i.m78496g(c13029h);
        this.f48947a.m29730n2(1);
        return c13029h;
    }

    /* renamed from: o */
    public final void m62125o() throws C9721b {
        C11839m.m70688i("CloudBackupV3Prepare", "start about request");
        About aboutM84094A = new C13998b0().m84094A(m62088S(), this.f48953g, this.f48951e);
        C12176c.m73263e(aboutM84094A);
        this.f48967u = C12176c.m73265g(aboutM84094A, this.f48953g);
        this.f48947a.m29678W0(aboutM84094A);
        this.f48947a.m29727m2(aboutM84094A);
        this.f48947a.m29630C2(this.f48967u);
        this.f48947a.m29739q2(aboutM84094A.isManualBypassOnFault());
        if (!StringUtil.isBlank(aboutM84094A.getAcceptEncoding())) {
            this.f48947a.m29703e2(Arrays.asList(aboutM84094A.getAcceptEncoding().split(",")));
        }
        C12176c.m73260b(aboutM84094A, this.f48948b);
        C12176c.m73269l(aboutM84094A);
        m62047s0(aboutM84094A);
        m62120l1();
        m62135r0(aboutM84094A);
        List<Integer> grayFlowStrategy = aboutM84094A.getGrayFlowStrategy();
        if (grayFlowStrategy != null) {
            Iterator<Integer> it = grayFlowStrategy.iterator();
            while (it.hasNext()) {
                int iIntValue = it.next().intValue();
                if (iIntValue == 1) {
                    this.f48947a.m29627B2(true);
                } else if (iIntValue == 2) {
                    this.f48947a.m29733o2(true);
                } else if (iIntValue == 3) {
                    m62158z1();
                } else if (iIntValue == 4) {
                    this.f48947a.m29757w2(true);
                }
            }
        }
        Integer divideStrategy = aboutM84094A.getDivideStrategy();
        if (divideStrategy != null) {
            this.f48947a.m29700d2(divideStrategy.intValue());
        }
        if (this.f48947a.isRefurbishment() || this.f48947a.mo29591n()) {
            this.f48947a.m29765z2(false);
            C11839m.m70688i("CloudBackupV3Prepare", "aboutRequest, isSupportDiff REFURBISHMENT  false");
        } else {
            if (!C9733f.m60705z().m60714I()) {
                this.f48947a.m29765z2(false);
                C11839m.m70688i("CloudBackupV3Prepare", "aboutRequest, isSupportDiff FeatureSwitchOpen  false");
                return;
            }
            boolean z10 = this.f48947a.m29701e0() == 1;
            this.f48947a.m29765z2(z10);
            C11839m.m70688i("CloudBackupV3Prepare", "aboutRequest, isSupportDiff getDivideStrategy  = " + z10);
        }
    }

    /* renamed from: o0 */
    public final void m62126o0() throws C9721b {
        File fileM63442h = C10278a.m63442h(this.f48947a.getLocation());
        if (!fileM63442h.exists() && !fileM63442h.mkdirs()) {
            C11839m.m70687e("CloudBackupV3Prepare", "process backup location init error.");
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "process backup location init error.");
        }
        String strM75672h = C12583q.m75672h();
        C12571m.m75547i(strM75672h);
        File fileM63442h2 = C10278a.m63442h(strM75672h);
        if (!fileM63442h2.exists() && !fileM63442h2.mkdirs()) {
            C11839m.m70687e("CloudBackupV3Prepare", "androidTempCacheDir init error.");
        }
        String strM75681q = C12583q.m75681q();
        C12571m.m75547i(strM75681q);
        File fileM63442h3 = C10278a.m63442h(strM75681q);
        if (!fileM63442h3.exists() && !fileM63442h3.mkdirs()) {
            C11839m.m70687e("CloudBackupV3Prepare", "dataWaitDeleteDir init error.");
        }
        C12571m.m75543e(this.f48947a.getLocation());
        File fileM63442h4 = C10278a.m63442h(this.f48947a.m29743s0());
        if (fileM63442h4.exists() || fileM63442h4.mkdirs()) {
            return;
        }
        C11839m.m70687e("CloudBackupV3Prepare", "process dataPathDir init error.");
        throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "process dataPathDir init error.");
    }

    /* renamed from: o1 */
    public final boolean m62127o1(BackupOptionItem backupOptionItem, String str) {
        if (this.f48947a.isRefurbishment()) {
            if (backupOptionItem == null || backupOptionItem.getBackupSwitch() || backupOptionItem.getOperateTime() <= 0) {
                return true;
            }
        } else if (m62134r(str) && backupOptionItem != null && backupOptionItem.getBackupSwitch()) {
            return true;
        }
        return false;
    }

    /* renamed from: p */
    public final void m62128p(String str, CloudBackupStatus cloudBackupStatus) throws C9721b {
        HashMap map = new HashMap();
        map.put("snapshotvalidflag", FeedbackConst.SDK.INVALID_ACCESS_TOKEN);
        AppRefresh appRefresh = new AppRefresh();
        appRefresh.setUpdateTime(new C4644l(System.currentTimeMillis())).setBackupAppStatus(1).setProperties(map);
        if (1 == new C10321z(this.f48951e, this.f48947a.m29636F0(), this.f48947a.m29587j(), CloudBackupConstant.Command.PMS_CMD_BACKUP, this.f48953g).m63582x0(this.f48947a.m29728n0(), this.f48952f, str, cloudBackupStatus.m29398d1(), cloudBackupStatus.m29870d(), cloudBackupStatus.m29861N(), appRefresh, 0).getBackupAppStatus().intValue()) {
            return;
        }
        throw new C9721b(3911, "Backup.device.bak.app.refresh error. app recordId = " + cloudBackupStatus.m29398d1(), "Backup.device.bak.app.refresh");
    }

    /* renamed from: p0 */
    public void m62129p0(List<String> list, List<String> list2) throws Throwable {
        boolean zM29714i1 = this.f48947a.m29714i1();
        C11839m.m70688i("CloudBackupV3Prepare", "initBackupModules: isNewBmUserOnlyBackupBaseData " + zM29714i1);
        if (zM29714i1) {
            list = (List) list.stream().filter(new Predicate() { // from class: gm.j
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return this.f48925a.m62092V0((String) obj);
                }
            }).collect(Collectors.toList());
            C11839m.m70688i("CloudBackupV3Prepare", "new business model free user backup modules: " + list);
        }
        ArrayList arrayList = new ArrayList();
        m62053B0(list, arrayList);
        this.f48957k.add(arrayList);
        ArrayList arrayList2 = new ArrayList();
        m62115j0(arrayList2, list2);
        this.f48957k.add(arrayList2);
        ArrayList arrayList3 = new ArrayList();
        m62062E0(arrayList3);
        this.f48957k.add(arrayList3);
        ArrayList arrayList4 = new ArrayList();
        m62154y0(arrayList4);
        m62143u0(arrayList4);
        this.f48957k.add(arrayList4);
        if (-1 == this.f48962p.m75347L0()) {
            m62117k0();
        }
        m62130p1();
    }

    /* renamed from: p1 */
    public final void m62130p1() throws C9721b {
        if (!C13452e.m80781L().m80887a1() || this.f48947a.m29690a1() || this.f48947a.isRefurbishment() || this.f48947a.mo29591n()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (this.f48957k.size() > 1) {
            List<String> list = this.f48957k.get(1);
            for (String str : list) {
                for (CloudBackupStatus cloudBackupStatus : new C12815f(this.f48951e).m76933l(str)) {
                    if (cloudBackupStatus.m29863P()) {
                        if (cloudBackupStatus.m29425o1()) {
                            C4879a c4879a = this.f48947a;
                            if (c4879a.m29717j1(c4879a.m29624A0(), cloudBackupStatus)) {
                            }
                        }
                        arrayList.add(str);
                    }
                }
            }
            C11839m.m70688i("CloudBackupV3Prepare", "not backup notBackup3rdApps: " + arrayList);
            list.removeAll(arrayList);
        }
    }

    /* renamed from: q */
    public final void m62131q(C1457c c1457c) {
        if (c1457c == null) {
            C11839m.m70689w("CloudBackupV3Prepare", "backupV3Lock is null");
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (!this.f48947a.mo29591n()) {
            if (C13452e.m80781L().m80887a1()) {
                arrayList.addAll(this.f48947a.m29737q0());
                C11839m.m70688i("CloudBackupV3Prepare", "is new business model, skip filterList: " + arrayList);
            }
            arrayList.addAll(C12590s0.m75880n0());
        }
        long jM69963a = C12590s0.m75722A(false, this.f48947a.mo29591n(), arrayList, this.f48947a.m29722l0().mo1759d()).m69963a();
        try {
            CloudSpace cloudSpaceM29643I0 = this.f48947a.m29643I0();
            long total = cloudSpaceM29643I0.getTotal() - cloudSpaceM29643I0.getUsed();
            long jM81078f = C13466f.m81073d().m81078f("vfsRefTotalSize", -1L);
            C11839m.m70688i("CloudBackupV3Prepare", "get vfsRefTotalSize:" + jM81078f);
            c1457c.m8346u(jM69963a, total, this.f48947a.m29705f1(), jM81078f);
        } catch (C9721b unused) {
            C11839m.m70688i("CloudBackupV3Prepare", "buildVfsRefParams getSpace error.");
        }
    }

    /* renamed from: q0 */
    public C13029h m62132q0() throws C9721b {
        C13030i c13030i = new C13030i();
        C13029h c13029hM78495f = c13030i.m78495f(4);
        if (c13029hM78495f != null) {
            C13617a.m81922d(c13029hM78495f.m78465h(), this.f48961o, this.f48947a.mo29591n());
            c13030i.m78490a(4);
        }
        C13029h c13029hM78495f2 = c13030i.m78495f(5);
        if (c13029hM78495f2 != null) {
            C13617a.m81922d(c13029hM78495f2.m78465h(), this.f48961o, this.f48947a.mo29591n());
            c13030i.m78490a(5);
        }
        C13029h c13029hM78495f3 = c13030i.m78495f(2);
        if (c13029hM78495f3 == null) {
            c13029hM78495f3 = c13030i.m78495f(1);
        }
        if (c13029hM78495f3 == null) {
            C13617a.m81922d("empty_default_id", this.f48961o, this.f48947a.mo29591n());
            return m62058D("empty_default_id", 0, 0L);
        }
        if (c13029hM78495f3.m78441G() == 4) {
            new SettingOperator().replace(new Settings[]{new Settings("lastsuccessbackupid", c13029hM78495f3.m78465h(), "2")});
            C13617a.m81925g(this.f48947a.mo29591n());
            c13030i.m78490a(c13029hM78495f3.m78442H());
            return m62058D("empty_default_id", 0, 0L);
        }
        if (!(!c13029hM78495f3.m78488y().startsWith("V3_")) && !c13029hM78495f3.m78465h().isEmpty() && !"empty_default_id".equals(c13029hM78495f3.m78465h())) {
            return c13029hM78495f3;
        }
        C13617a.m81925g(this.f48947a.mo29591n());
        c13030i.m78490a(c13029hM78495f3.m78442H());
        return m62058D("empty_default_id", 0, 0L);
    }

    /* renamed from: q1 */
    public final void m62133q1(C13029h c13029h, String str, boolean z10) {
        if (c13029h != null && c13029h.m78435A() == 0) {
            String str2 = (this.f48948b || z10) ? "AutoBET" : "ManuBET";
            C11060c c11060cM66626a = C11058a.m66626a(c13029h.m78436B(), str2, C13452e.m80781L().m80971t0());
            c11060cM66626a.m66665u(c13029h.m78474q());
            c11060cM66626a.m66635A(str);
            c11060cM66626a.m66668x("1");
            HashMap map = new HashMap();
            map.put("business_id", str2);
            map.put("backupBeginTime", String.valueOf(c13029h.m78440F()));
            map.put("backupEndTime", String.valueOf(c13029h.m78464f()));
            map.put("sizeNeedBackup", String.valueOf(c13029h.m78439E()));
            map.put("backupTransID", c13029h.m78444J());
            map.put("backupCnt", String.valueOf(c13029h.m78476r()));
            C13622a.m81969o(this.f48961o, c11060cM66626a, map);
            c13029h.m78468j0(1);
            new C13030i().m78496g(c13029h);
        }
    }

    /* renamed from: r */
    public final boolean m62134r(String str) {
        boolean z10 = true;
        if (C13452e.m80781L().m80887a1() && !this.f48947a.isRefurbishment() && !this.f48947a.mo29591n()) {
            boolean zContains = this.f48947a.m29737q0().contains(str);
            if (!zContains && C12590s0.m75828a1(m62096Z())) {
                z10 = false;
            }
            C11839m.m70688i("CloudBackupV3Prepare", "canModuleBeBackedUp appId: " + str + " ,isBaseModule: " + zContains + " ,beBackedUp: " + z10);
        }
        return z10;
    }

    /* renamed from: r0 */
    public final void m62135r0(About about) throws C9721b {
        List<String> listM73267j = C12176c.m73267j(about);
        if (!C13452e.m80781L().m80887a1() || this.f48947a.isRefurbishment() || this.f48947a.mo29591n()) {
            return;
        }
        if (listM73267j.isEmpty()) {
            C11839m.m70687e("CloudBackupV3Prepare", "initBaseServiceAppInfo error, base service app list is empty");
            throw new C9721b(3936, "base service app list is empty");
        }
        HashSet hashSet = new HashSet(listM73267j);
        C11839m.m70688i("CloudBackupV3Prepare", "set base service app list: " + hashSet);
        this.f48947a.m29721k2(hashSet);
        this.f48944A = C12176c.m73266i(about);
        C11839m.m70688i("CloudBackupV3Prepare", "get applistStrategy: " + this.f48944A);
    }

    /* renamed from: r1 */
    public void m62136r1(List<String> list, List<String> list2, boolean z10) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (list != null && list.size() > 0) {
            linkedHashMap.put("riskapps", list.toString());
        }
        if (list2 != null && list2.size() > 0) {
            linkedHashMap.put("unRecognizedPackageName", list2.toString());
        }
        linkedHashMap.put("is_refurbish", Boolean.valueOf(z10));
        C13225d.m79490f1().m79591l0("mecloud_backupmain_option_high_risk_apps", linkedHashMap);
        UBAAnalyze.m29947H("CKC", "mecloud_backupmain_option_high_risk_apps", linkedHashMap);
    }

    /* renamed from: s */
    public final void m62137s() {
        if (C13466f.m81073d().m81075b("backup_status_clear_flag", false)) {
            C11839m.m70688i("CloudBackupV3Prepare", "checkBackupStatusClear clear backup status db");
            C13617a.m81925g(this.f48947a.mo29591n());
            C12592t.m75950g().m75952b();
            C13466f.m81073d().m81081i("backup_status_clear_flag", false);
        }
        if (this.f48947a.mo29591n()) {
            new C13033l().m78543a(1);
        }
    }

    /* renamed from: s1 */
    public final void m62138s1(Set<CloudBackupStatus> set, CloudBackupStatus cloudBackupStatus) {
        if (TextUtils.isEmpty(cloudBackupStatus.m29362M0()) || !cloudBackupStatus.m29863P()) {
            return;
        }
        boolean zM29687Z0 = this.f48947a.m29687Z0(cloudBackupStatus);
        String strM29870d = cloudBackupStatus.m29870d();
        if (cloudBackupStatus.m29417l1() != zM29687Z0) {
            BackupOptionItem backupOptionItemM78401y = this.f48947a.m29722l0().mo1759d().m78401y(strM29870d);
            long dataBytes = (backupOptionItemM78401y == null || !cloudBackupStatus.m29425o1()) ? 0L : backupOptionItemM78401y.getDataBytes();
            C11839m.m70688i("CloudBackupV3Prepare", "app not match last status, do reset, appId: " + strM29870d + " ,dataByte: " + dataBytes);
            cloudBackupStatus.mo29323e0(dataBytes);
            set.add(cloudBackupStatus);
        }
    }

    /* renamed from: t */
    public final void m62139t(String str) throws C9721b {
        C12815f c12815f = new C12815f(this.f48951e);
        if (!c12815f.integrityCheck()) {
            throw new C9721b(3930, "checkCloudBackupStatus SQLiteDatabaseCorruptException");
        }
        long jM75406m0 = this.f48962p.m75406m0(this.f48947a.isAutoBackup());
        for (CloudBackupStatus cloudBackupStatus : c12815f.m76931j()) {
            boolean zM62079K0 = m62068G0() && !cloudBackupStatus.m29414k1();
            if (!zM62079K0) {
                zM62079K0 = m62079K0(cloudBackupStatus.m29404g1() > 0 ? cloudBackupStatus.m29404g1() : cloudBackupStatus.m29385X0(), jM75406m0);
                if (!zM62079K0 || cloudBackupStatus.m29859L() != 6 || !cloudBackupStatus.m29863P() || cloudBackupStatus.m29351H0() != 1) {
                }
            }
            if (cloudBackupStatus.m29860M() == -1) {
                cloudBackupStatus.m29399d2(0);
                c12815f.m76934m(cloudBackupStatus);
            }
            if (zM62079K0) {
                C11839m.m70688i("CloudBackupV3Prepare", "overdue appId = " + cloudBackupStatus.m29870d() + ", refresh app status");
                cloudBackupStatus.mo29338z0(0).mo29289A0(-1).m29436s2(0L).m29374R1(0L).m29342C1(0L).m29423n2(0L).mo29310W(0).mo29308V(0L).m29399d2(0);
                c12815f.m76934m(cloudBackupStatus);
                if (TextUtils.isEmpty(cloudBackupStatus.m29398d1())) {
                    C11839m.m70687e("CloudBackupV3Prepare", "overdue appId = " + cloudBackupStatus.m29870d() + ", refresh app status error: recordId is empty");
                } else {
                    try {
                        m62128p(str, cloudBackupStatus);
                    } catch (C9721b e10) {
                        if (e10.m60659c() != 3922) {
                            throw e10;
                        }
                        C9195d0.m57742e(cloudBackupStatus.m29398d1());
                        cloudBackupStatus.m29405g2("");
                        cloudBackupStatus.m29350G1("");
                        c12815f.m76934m(cloudBackupStatus);
                        C11839m.m70687e("CloudBackupV3Prepare", "reset recordId overdue appId = " + cloudBackupStatus.m29870d() + ", refresh app status error " + e10.getMessage());
                    }
                }
            } else {
                continue;
            }
        }
    }

    /* renamed from: t0 */
    public final void m62140t0(Lock lock) throws InterruptedException, C9721b {
        if (this.f48947a.mo29591n()) {
            return;
        }
        C12815f c12815f = new C12815f(this.f48951e);
        List<CloudBackupStatus> listM76931j = c12815f.m76931j();
        if (listM76931j.isEmpty()) {
            String id2 = this.f48959m.getId();
            List<App> listM29649L1 = this.f48947a.m29649L1(id2, lock.getLockId());
            if (listM29649L1.isEmpty()) {
                return;
            }
            for (App app : listM29649L1) {
                CloudBackupStatus cloudBackupStatus = new CloudBackupStatus();
                cloudBackupStatus.mo29313Y(app.getBackupAppName());
                cloudBackupStatus.m29405g2(app.getId());
                int iIntValue = app.getBackupAppStatus().intValue();
                boolean z10 = iIntValue == 0 && !this.f48947a.isRefurbishment();
                if (7 == C0241z.m1685c(app.getProperties().get("modulestatus"))) {
                    CloudBackupReport.reportAppModuleReset(true, cloudBackupStatus.m29870d(), this.f48953g, id2, this.f48951e, "check reset form server", "module_reset_from_app_reset_by_server");
                    cloudBackupStatus.mo29338z0(0).mo29289A0(-1);
                } else {
                    cloudBackupStatus.mo29338z0(z10 ? 6 : 0);
                    cloudBackupStatus.mo29289A0(z10 ? 7 : 0);
                }
                cloudBackupStatus.mo29318b0(app.getApkType().intValue());
                cloudBackupStatus.m29408h2(app.getRuntimeType().intValue());
                cloudBackupStatus.m29339A1(m62104d0(app.getBackupAppName()));
                int iM1685c = C0241z.m1685c(app.getProperties().get("splitappuid"));
                cloudBackupStatus.mo29340B0(iM1685c);
                if (cloudBackupStatus.m29859L() == 6) {
                    cloudBackupStatus.m29436s2(app.getUpdateTime().m28458c());
                    cloudBackupStatus.mo29327g0(app.getFileCount().intValue());
                    cloudBackupStatus.mo29323e0(app.getAppTotalSize().longValue());
                    cloudBackupStatus.m29348F1(app.getProperties().getOrDefault("lastBackupDataEnable", ""));
                    if (C12590s0.m75783P0(app.getProperties())) {
                        cloudBackupStatus.m29453y1(1);
                    }
                }
                cloudBackupStatus.mo29413k0(app.getOriBackupAppName());
                cloudBackupStatus.mo29452y0(app.getSplitApkType());
                cloudBackupStatus.m29447w1(app.getPackageVersion());
                cloudBackupStatus.m29367O1(m62100b0(app, cloudBackupStatus));
                C11839m.m70688i("CloudBackupV3Prepare", "refresh reuse app record: " + cloudBackupStatus.m29870d() + ", status: " + iIntValue + ", uid: " + iM1685c);
                m62082N(cloudBackupStatus, iIntValue, app);
                listM76931j.add(cloudBackupStatus);
            }
            c12815f.batchReplace(listM76931j);
        }
    }

    /* renamed from: t1 */
    public final void m62141t1(Set<CloudBackupStatus> set) throws InterruptedException, C9721b {
        if (TextUtils.isEmpty(this.f48947a.m29719k0()) || TextUtils.isEmpty(this.f48947a.m29734p0())) {
            C11839m.m70688i("CloudBackupV3Prepare", "resetModules return bakid or DeviceId is empty");
            return;
        }
        for (CloudBackupStatus cloudBackupStatus : set) {
            this.f48947a.isCancel();
            new C9195d0(this.f48947a, cloudBackupStatus).m57757s("module_reset_from_module_new_bm_type_check");
        }
    }

    /* renamed from: u */
    public final void m62142u(int i10, String str, C12815f c12815f) throws InterruptedException, C9721b {
        CloudBackupStatus cloudBackupStatusM76928g = c12815f.m76928g(str);
        if (cloudBackupStatusM76928g == null || i10 == cloudBackupStatusM76928g.m29861N()) {
            return;
        }
        m62078K(Collections.singletonList(cloudBackupStatusM76928g), "module_delete_from_split_uid_not_match");
    }

    /* renamed from: u0 */
    public final void m62143u0(List<String> list) throws Throwable {
        boolean zIsRefurbishment = this.f48947a.isRefurbishment();
        boolean zMo29591n = this.f48947a.mo29591n();
        boolean z10 = true;
        boolean z11 = zIsRefurbishment || zMo29591n || ICBUtil.isSupportGallery(this.f48961o);
        if (z11) {
            if (!m62104d0(HNConstants.DataType.MEDIA) || !m62134r(HNConstants.DataType.MEDIA)) {
                z11 = false;
            }
            if (!m62104d0(HNConstants.DataType.MEDIA)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(" gallery switch is ");
                sb2.append(!m62104d0(HNConstants.DataType.MEDIA));
                sb2.append(" , reason: ");
                sb2.append(0);
                C11839m.m70688i("CloudBackupV3Prepare", sb2.toString());
                C12590s0.m75769L2(HNConstants.DataType.MEDIA, this.f48972z, 0);
            }
        }
        if (!z11) {
            C11839m.m70688i("CloudBackupV3Prepare", "unsupported gallery backup.");
            if (!m62104d0(HNConstants.DataType.MEDIA) || zIsRefurbishment || zMo29591n) {
                return;
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append(" gallery switch is ");
            sb3.append(!m62104d0(HNConstants.DataType.MEDIA));
            sb3.append(" , reason: ");
            sb3.append(3);
            C11839m.m70688i("CloudBackupV3Prepare", sb3.toString());
            C12590s0.m75769L2(HNConstants.DataType.MEDIA, this.f48972z, 3);
            return;
        }
        Pair<Integer, Long> pairM75844e0 = C12590s0.m75844e0(zIsRefurbishment, zMo29591n);
        int iIntValue = ((Integer) pairM75844e0.first).intValue();
        long jLongValue = ((Long) pairM75844e0.second).longValue();
        C11839m.m70688i("CloudBackupV3Prepare", "initGallery count: " + iIntValue + " ,dataSize: " + jLongValue);
        if (iIntValue <= 0) {
            C12590s0.m75769L2(HNConstants.DataType.MEDIA, this.f48972z, 1);
            return;
        }
        String str = this.f48947a.getLocation() + "/gallery/gallery.db";
        File fileM63442h = C10278a.m63442h(str);
        File fileM63437c = C10278a.m63437c(fileM63442h);
        if (!fileM63437c.exists() && !fileM63437c.mkdirs()) {
            z10 = false;
        }
        AlbumsTempDBManager.initDataBase(this.f48961o.getApplicationContext(), str);
        ICBUtil.refreshLocalAlbumSettings(this.f48961o, false);
        C11839m.m70688i("CloudBackupV3Prepare", "initGallery mkdirs " + z10 + " ,dbfile isExist: " + fileM63442h.exists());
        long j10 = (long) iIntValue;
        m62063E1(HNConstants.DataType.MEDIA, jLongValue, j10);
        m62049A(j10);
        long j11 = this.f48965s;
        if (j10 > j11) {
            this.f48965s = j10 - j11;
        }
        list.add(HNConstants.DataType.MEDIA);
        m62145v0(HNConstants.DataType.MEDIA, 0);
    }

    /* renamed from: v */
    public final void m62144v(int i10) {
        if (i10 % 10 != 0) {
            return;
        }
        BackupPowerKitKeepTimer.getInstance().keepAlive(this.f48947a.m29589l());
    }

    /* renamed from: v0 */
    public final void m62145v0(String str, int i10) throws C9721b {
        m62148w0(str, i10, C0209d.m1222X());
    }

    /* renamed from: v1 */
    public final void m62146v1(com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak bak) {
        if (bak == null || TextUtils.isEmpty(bak.getId())) {
            return;
        }
        String id2 = bak.getId();
        C11839m.m70688i("CloudBackupV3Prepare", "get latest backup id = " + id2);
        long jM28458c = bak.getEndTime().m28458c();
        Settings settings = new Settings("lastsuccesstime", String.valueOf(jM28458c), "2");
        Settings settings2 = new Settings("lastsuccessbackupid", id2, "2");
        SettingOperator settingOperator = new SettingOperator();
        this.f48970x = settingOperator.querylastsuccesstime() == jM28458c;
        settingOperator.replace(new Settings[]{settings, settings2});
    }

    /* renamed from: w */
    public final void m62147w(List<com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak> list, List<String> list2) {
        if (this.f48947a.mo29591n()) {
            return;
        }
        int iM75751H0 = C12590s0.m75751H0();
        if (!this.f48948b && this.f48947a.m29711h1() && iM75751H0 == -1) {
            C11839m.m70688i("CloudBackupV3Prepare", "manual backup and manualByPassOnFault is true and QGW error,no need delete record.");
            C13466f.m81073d().m81081i("isStartDeleteTask", false);
        } else {
            if (list2.isEmpty() && !m62076J0(list)) {
                C13466f.m81073d().m81081i("isStartDeleteTask", false);
                return;
            }
            if (this.f48947a.isRefurbishment()) {
                this.f48966t = true;
            }
            C13466f.m81073d().m81081i("isStartDeleteTask", true);
        }
    }

    /* renamed from: w0 */
    public final void m62148w0(String str, int i10, int i11) throws C9721b {
        C12815f c12815f = new C12815f(this.f48951e);
        CloudBackupStatus cloudBackupStatusM76928g = c12815f.m76928g(str);
        if (cloudBackupStatusM76928g == null) {
            cloudBackupStatusM76928g = new CloudBackupStatus();
            cloudBackupStatusM76928g.mo29313Y(str).mo29318b0(i10).mo29338z0(0).mo29289A0(0).mo29310W(0).mo29308V(0L);
        }
        BackupOptionItem backupOptionItemM78401y = this.f48947a.m29722l0().mo1759d().m78401y(str);
        if (i10 == 2 || i10 == 0) {
            cloudBackupStatusM76928g.m29339A1(true);
        } else {
            boolean zM62127o1 = m62127o1(backupOptionItemM78401y, str);
            boolean z10 = this.f48947a.isSupportPMS() && new CloudBackupAppDataUtil(cloudBackupStatusM76928g.mo29421n(), this.f48947a.m29743s0(), ICBUtil.getVersionCode(this.f48961o.getPackageManager(), str), this.f48947a.isRefurbishment(), this.f48947a.mo29591n()).isAppDataAble();
            if (zM62127o1 || backupOptionItemM78401y == null) {
                if (zM62127o1 && z10 && backupOptionItemM78401y != null) {
                    m62152x1(str, backupOptionItemM78401y);
                }
            } else if (this.f48947a.mo29591n()) {
                if (this.f48946C.contains(str)) {
                    C11839m.m70688i("CloudBackupV3Prepare", "third appId temp " + str + " , reason: 0");
                    C12590s0.m75769L2(str, this.f48972z, 0);
                }
            } else if (z10) {
                C11839m.m70688i("CloudBackupV3Prepare", "third appId is " + str + " , reason: 0");
                C12590s0.m75769L2(str, this.f48972z, 0);
            }
            cloudBackupStatusM76928g.m29339A1(zM62127o1).m29408h2(C12565k.m75518d(str));
        }
        cloudBackupStatusM76928g.mo29340B0(i11);
        m62118k1(cloudBackupStatusM76928g, backupOptionItemM78401y);
        m62048u1(c12815f, cloudBackupStatusM76928g);
    }

    /* renamed from: w1 */
    public final long m62149w1(String str, CloudBackupAppDataUtil cloudBackupAppDataUtil) throws C9721b {
        long sdcardFileSize = new ScanAppDataUtil(str, cloudBackupAppDataUtil.getmCloudBackupInclude(), cloudBackupAppDataUtil.getmCloudBackupExclude()).getSdcardFileSize(cloudBackupAppDataUtil);
        m62074I1(str, sdcardFileSize);
        return sdcardFileSize;
    }

    /* renamed from: x */
    public final void m62150x(com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak bak) {
        if (!this.f48947a.mo29591n() && bak.isRefurbishment()) {
            if (!this.f48947a.isRefurbishment() && bak.getBackupStatus().intValue() == 1) {
                this.f48966t = true;
            }
            if (bak.getBackupStatus().intValue() == 7) {
                this.f48966t = true;
            }
        }
    }

    /* renamed from: x0 */
    public final void m62151x0() throws Throwable {
        this.f48963q = this.f48947a.m29722l0().mo1757b();
        List<String> arrayList = new ArrayList<>();
        arrayList.addAll(C14333b.m85487v());
        arrayList.addAll(C14333b.m85488w());
        arrayList.addAll(C14333b.m85489x());
        this.f48947a.m29722l0().mo1763i(arrayList);
        m62056C0();
        ArrayList arrayList2 = new ArrayList();
        boolean zM1273k1 = C0209d.m1273k1();
        Iterator<String> it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            if (!m62104d0(next) || (zM1273k1 && C14333b.f63656h.contains(next))) {
                if (this.f48947a.mo29591n()) {
                    C11839m.m70688i("CloudBackupV3Prepare", "temp system app back up " + next + " , reason: 0");
                    C12590s0.m75769L2(next, this.f48972z, 0);
                } else {
                    C11839m.m70688i("CloudBackupV3Prepare", "module is " + next + " , reason: 0");
                    C12590s0.m75769L2(next, this.f48972z, 0);
                }
                arrayList2.add(next);
                m62114i1(next);
            }
        }
        arrayList.removeAll(arrayList2);
        List<String> arrayList3 = new ArrayList<>(this.f48962p.m75386e());
        arrayList3.addAll(C14333b.m85454J());
        if (this.f48947a.isRefurbishment()) {
            List<String> listM69970d = C11727h.m69967b().m69970d();
            if (!listM69970d.isEmpty()) {
                arrayList3.addAll(listM69970d);
            }
            List<String> listM69969c = C11727h.m69967b().m69969c();
            if (!listM69969c.isEmpty()) {
                arrayList3.addAll(listM69969c);
            }
            m62136r1(listM69970d, listM69969c, this.f48947a.isRefurbishment());
            C11839m.m70688i("CloudBackupV3Prepare", "unSafePackageName: " + listM69970d + "  unRecognizedPackageName " + listM69969c);
        }
        arrayList.removeAll(arrayList3);
        long jMo1761g = this.f48947a.m29722l0().mo1761g();
        int iM75332E = this.f48962p.m75332E();
        this.f48964r = System.currentTimeMillis() - jMo1761g <= ((long) iM75332E) * C5863b6.g.f26453g;
        C11839m.m70688i("CloudBackupV3Prepare", "clientSizeCache: " + iM75332E + ", isUseCache: " + this.f48964r + ", modules: " + arrayList + ", appBlackList: " + arrayList3);
        m62129p0(arrayList, arrayList3);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("backup modules = ");
        sb2.append(this.f48957k);
        C11839m.m70688i("CloudBackupV3Prepare", sb2.toString());
    }

    /* renamed from: x1 */
    public final void m62152x1(String str, BackupOptionItem backupOptionItem) {
        if (backupOptionItem.getDataBytes() != 0) {
            return;
        }
        if (this.f48947a.mo29591n()) {
            if (this.f48946C.contains(str)) {
                C12590s0.m75769L2(str, this.f48972z, 1);
            }
        } else {
            if (this.f48947a.isRefurbishment()) {
                return;
            }
            C12590s0.m75769L2(str, this.f48972z, 1);
        }
    }

    /* renamed from: y */
    public final void m62153y() {
        BackupModuleList backupModuleListM76038f = C12598v.m76038f();
        if (backupModuleListM76038f == null) {
            C11839m.m70686d("CloudBackupV3Prepare", "savedTimeExpiredModule empty");
            return;
        }
        if (AbstractC14026a.m84159a(backupModuleListM76038f.getBackupModuleList())) {
            C11839m.m70688i("CloudBackupV3Prepare", "There's no expired modules in sp.");
            return;
        }
        String backupId = backupModuleListM76038f.getBackupId();
        if (this.f48947a.m29734p0().contains(backupId)) {
            return;
        }
        C11839m.m70688i("CloudBackupV3Prepare", "current task backupId not contains backupIdInSp,current task backupId:" + this.f48947a.m29734p0() + ",saved backupId in sp is:" + backupId);
        C12598v.m76035c();
    }

    /* renamed from: y0 */
    public final void m62154y0(List<String> list) throws C9721b {
        boolean z10 = m62104d0("music") && m62134r("music");
        C12582p1 c12582p1 = new C12582p1(this.f48947a.getLocation(), this.f48961o);
        if (!m62104d0("music")) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(" music switch is ");
            sb2.append(!m62104d0("music"));
            sb2.append(" , reason: ");
            sb2.append(0);
            C11839m.m70688i("CloudBackupV3Prepare", sb2.toString());
            C12590s0.m75769L2("music", this.f48972z, 0);
        }
        if (!z10) {
            if (c12582p1.m75633q().isEmpty()) {
                return;
            }
            C13465e.m81052f().m81066o("musicBlackList", c12582p1.m75633q());
            return;
        }
        CloudBackupStatus cloudBackupStatusM75635s = c12582p1.m75635s();
        if (cloudBackupStatusM75635s == null || cloudBackupStatusM75635s.m29875i() <= 0) {
            C11839m.m70688i("CloudBackupV3Prepare", "initMusicSize backupStatus is null, do not backup music");
            C12590s0.m75769L2("music", this.f48972z, 1);
        } else {
            list.add("music");
            m62063E1("music", cloudBackupStatusM75635s.m29875i(), cloudBackupStatusM75635s.m29877l());
            m62145v0("music", 0);
        }
    }

    /* renamed from: y1 */
    public final void m62155y1(CloudBackupStatus cloudBackupStatus, long j10) {
        long jM29875i = cloudBackupStatus.m29875i();
        if (jM29875i <= 0 && cloudBackupStatus.m29863P() && cloudBackupStatus.m29425o1()) {
            cloudBackupStatus.mo29323e0(j10);
            cloudBackupStatus.mo29338z0(0).mo29289A0(-1);
        }
        if (jM29875i <= 0 || !cloudBackupStatus.m29863P() || cloudBackupStatus.m29425o1()) {
            return;
        }
        cloudBackupStatus.mo29323e0(0L);
        cloudBackupStatus.mo29338z0(0).mo29289A0(-1);
    }

    /* renamed from: z */
    public final void m62156z(com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak bak) throws C9721b {
        int iQueryFinalBackupCycle = new SettingOperator().queryFinalBackupCycle();
        int iM73923e = C12299b.m73923e();
        if (!this.f48948b || TextUtils.isEmpty(this.f48967u)) {
            return;
        }
        int gradeMinFrequency = CloudBackupUtil.getGradeMinFrequency(this.f48967u);
        long jM28458c = bak.getEndTime().m28458c();
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jM73924f = C12299b.m73924f("lastsuccesstime");
        long jM73924f2 = C12299b.m73924f("timeAdvanced");
        C11839m.m70686d("CloudBackupV3Prepare", "checkoutBackupFrequency curTime =" + jCurrentTimeMillis + " lastTime =" + jM28458c + " userFrequency =" + iQueryFinalBackupCycle + " minFrequency =" + gradeMinFrequency + "dsUserFrequency = " + iM73923e);
        if ((jCurrentTimeMillis - jM28458c) + AiCoreSdkConstant.CHECK_SUPPORT_INTERVAL < gradeMinFrequency * 86400000) {
            if (iM73923e < iQueryFinalBackupCycle) {
                C13467g.m81086c().m81098m(Math.max(iQueryFinalBackupCycle, gradeMinFrequency));
            }
            throw new C9721b(3113, 703, "auto backup fast userFrequency " + iQueryFinalBackupCycle + " min " + gradeMinFrequency + ", ds " + iM73923e + ", has time = " + this.f48970x + ", curTime= " + jCurrentTimeMillis + ", lastTime= " + jM28458c + ", lastDsTime= " + jM73924f + ", timeAdvanced= " + jM73924f2, "checkoutBackupFrequency");
        }
    }

    /* renamed from: z0 */
    public C13029h m62157z0() throws C9721b {
        C13030i c13030i = new C13030i();
        C13029h c13029hM78495f = c13030i.m78495f(2);
        if (c13029hM78495f == null) {
            c13029hM78495f = c13030i.m78495f(1);
        }
        if (c13029hM78495f != null) {
            C13617a.m81922d("empty_default_id", this.f48961o, this.f48947a.mo29591n());
            c13030i.m78490a(c13029hM78495f.m78442H());
        }
        C13029h c13029hM78495f2 = c13030i.m78495f(5);
        if (c13029hM78495f2 != null) {
            C13617a.m81922d(c13029hM78495f2.m78465h(), this.f48961o, this.f48947a.mo29591n());
            c13030i.m78490a(5);
        }
        C13029h c13029hM78495f3 = c13030i.m78495f(4);
        if (c13029hM78495f3 == null) {
            C13617a.m81922d("empty_default_id", this.f48961o, this.f48947a.mo29591n());
            C13029h c13029hM62058D = m62058D("empty_default_id", 0, 0L);
            c13030i.m78496g(c13029hM62058D);
            return c13029hM62058D;
        }
        if (c13029hM78495f3.m78441G() != 4) {
            return c13029hM78495f3;
        }
        C13617a.m81925g(this.f48947a.mo29591n());
        c13030i.m78490a(c13029hM78495f3.m78442H());
        C13029h c13029hM62058D2 = m62058D("empty_default_id", 0, 0L);
        c13030i.m78496g(c13029hM62058D2);
        return c13029hM62058D2;
    }

    /* renamed from: z1 */
    public final void m62158z1() {
        if (this.f48947a.mo29591n() || this.f48947a.isRefurbishment()) {
            C11839m.m70688i("CloudBackupV3Prepare", "setFullBackup tempbackup or refurbishment");
        } else {
            this.f48949c = true;
        }
    }
}
