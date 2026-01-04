package dm;

import android.database.SQLException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.manager.CloudBackupModuleTask;
import com.huawei.android.hicloud.cloudbackup.p076db.operator.SettingOperator;
import com.huawei.android.hicloud.cloudbackup.process.task.CloudBackupCreateManager;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.SnapshotDBManager;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.android.hicloud.commonlib.util.DatabaseRepairUtil;
import com.huawei.hicloud.base.bean.CloudSpace;
import com.huawei.hicloud.cloudbackup.p104v3.core.C4879a;
import com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request;
import com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Server;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.IdTransfer;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.IdTransferRequest;
import com.huawei.hicloud.cloudbackup.p104v3.server.request.File;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudBackupStatus;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import dm.C9218j;
import fk.C9721b;
import gp.C10028c;
import hk.C10278a;
import hk.C10279b;
import hm.C10321z;
import im.AbstractC10554e;
import im.C10561k;
import im.InterfaceC10570t;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import mk.C11476b;
import mm.AbstractC11494p;
import mm.C11479a;
import mm.C11482d;
import mm.InterfaceC11493o;
import mm.InterfaceC11495q;
import om.C11963c;
import om.C11965e;
import p037bp.C1270a;
import p232dp.InterfaceC9284c;
import p262em.AbstractC9526z;
import p292fn.C9733f;
import p429kk.C11058a;
import p429kk.C11060c;
import p455ll.C11308a;
import p508o3.C11799d;
import p508o3.C11802g;
import p514o9.C11839m;
import p617rl.C12526j;
import p618rm.C12550f;
import p618rm.C12590s0;
import p618rm.C12594t1;
import p618rm.C12598v;
import p709vj.C13452e;
import p744wl.C13617a;
import p746wn.C13622a;
import p814yl.C14000c0;
import p848zl.C14337f;
import pl.C12161c;
import pl.C12164f;
import sl.C12810a;
import sl.C12812c;
import sl.C12815f;
import tl.C13029h;

/* renamed from: dm.z */
/* loaded from: classes6.dex */
public class C9276z extends CloudBackupModuleTask {

    /* renamed from: t */
    public static final Object f46579t = new Object();

    /* renamed from: u */
    public static final Object f46580u = new Object();

    /* renamed from: a */
    public final C4879a f46581a;

    /* renamed from: b */
    public final AbstractC9526z f46582b;

    /* renamed from: c */
    public final C13029h f46583c;

    /* renamed from: d */
    public final String f46584d;

    /* renamed from: e */
    public final String f46585e;

    /* renamed from: f */
    public final String f46586f;

    /* renamed from: g */
    public final String f46587g;

    /* renamed from: h */
    public final String f46588h;

    /* renamed from: i */
    public final CloudBackupStatus f46589i;

    /* renamed from: j */
    public long f46590j;

    /* renamed from: k */
    public final C12594t1 f46591k;

    /* renamed from: l */
    public final C12526j f46592l;

    /* renamed from: m */
    public C9721b f46593m;

    /* renamed from: n */
    public final String f46594n;

    /* renamed from: o */
    public final Map<String, String> f46595o;

    /* renamed from: p */
    public final Map<String, Long> f46596p;

    /* renamed from: q */
    public final Map<String, Long> f46597q;

    /* renamed from: r */
    public C10561k f46598r;

    /* renamed from: s */
    public final C10321z f46599s;

    public C9276z(C4879a c4879a, AbstractC9526z abstractC9526z, C13029h c13029h, CloudBackupStatus cloudBackupStatus, String str, Map<String, String> map) {
        super(cloudBackupStatus.m29870d());
        this.f46590j = 0L;
        this.f46591k = C12594t1.m75990o();
        this.f46592l = new C12526j();
        this.f46596p = new HashMap();
        this.f46597q = new HashMap();
        this.f46581a = c4879a;
        this.f46582b = abstractC9526z;
        this.f46583c = c13029h;
        this.f46589i = cloudBackupStatus;
        this.f46584d = C12590s0.m75786Q(c13029h);
        this.f46585e = c13029h.m78465h();
        String strM78444J = c13029h.m78444J();
        this.f46586f = strM78444J;
        this.f46587g = str;
        this.f46588h = cloudBackupStatus.m29398d1();
        this.f46595o = map;
        C10321z c10321z = new C10321z(c4879a.m29713i0(), c4879a.m29636F0(), c4879a.m29587j(), CloudBackupConstant.Command.PMS_CMD_BACKUP, strM78444J);
        this.f46599s = c10321z;
        c10321z.m63540D0(c4879a.m29761y0());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(!C10028c.m62182c0().m62420y1() ? "" : "/Backup");
        sb2.append("/CloudBackup/");
        sb2.append(C11476b.m68626h(C13452e.m80781L().m80950o()));
        sb2.append("/");
        this.f46594n = sb2.toString();
    }

    private String getLocation() {
        return this.f46581a.getLocation();
    }

    private void isCancel() throws InterruptedException, C9721b {
        if (this.abort) {
            throw new C9721b(1999, "module create task interrupted.");
        }
        if (m58314E() != null) {
            throw this.f46593m;
        }
        this.f46582b.m59511j();
    }

    /* renamed from: A */
    public final List<String[]> m58310A(Map<String, String> map) throws C9721b {
        ArrayList arrayList = new ArrayList();
        if (map == null) {
            return arrayList;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String[] strArrSplit = entry.getValue().split(",");
            if (strArrSplit.length < 3) {
                throw new C9721b(1009, "map value splite error");
            }
            arrayList.add(new String[]{strArrSplit[0], strArrSplit[1], strArrSplit[2], String.valueOf(1), m58315F(key)});
        }
        return arrayList;
    }

    /* renamed from: B */
    public final String m58311B() throws C9721b {
        String strSubstring = "";
        if (!C9733f.m60705z().m60720O("cloudBackupSnapshotBloomFilter")) {
            C11839m.m70689w("CloudBackupV3ModuleCreate", "getBloomFilterByAppId bloomFilterSwitch = false");
            return "";
        }
        int iM75427x = this.f46592l.m75427x();
        int iM75429y = this.f46592l.m75429y();
        if (iM75429y <= 0 || iM75427x <= 0 || iM75429y >= iM75427x) {
            C11839m.m70689w("CloudBackupV3ModuleCreate", "getBloomFilterByAppId get bloom filter threshold error, appId = " + this.appId + ", min = " + iM75429y + ", max = " + iM75427x);
            return "";
        }
        C12164f c12164f = new C12164f(this.f46585e, this.appId, 0, this.f46589i.m29861N());
        int iM73048M = c12164f.m73048M(this.appId);
        if (iM73048M == 0 || iM73048M > iM75427x) {
            C11839m.m70689w("CloudBackupV3ModuleCreate", "getBloomFilterByAppId invalid fileIdsCount = " + iM73048M + ", appId = " + this.appId);
            return "";
        }
        C11839m.m70688i("CloudBackupV3ModuleCreate", "getBloomFilterByAppId start, queryFileIdsCount appId = " + this.appId + ", fileNum = " + iM73048M);
        final StringBuilder sb2 = new StringBuilder();
        final C11799d c11799dM70326f = C11799d.m70326f(C11802g.m70342a(StandardCharsets.UTF_8), iM73048M, 1.0E-7d);
        final boolean z10 = iM73048M < iM75429y;
        new C11479a(this.appId, c12164f, 1).batchExecute(new InterfaceC11493o() { // from class: dm.w
            @Override // mm.InterfaceC11493o
            /* renamed from: a */
            public final void mo15310a(List list, int i10) throws C9721b {
                this.f46531a.m58322M(z10, sb2, c11799dM70326f, list, i10);
            }
        });
        if (z10) {
            if (!TextUtils.isEmpty(sb2.toString())) {
                strSubstring = "V1:" + sb2.toString();
            }
            if (strSubstring.endsWith(",")) {
                strSubstring = strSubstring.substring(0, strSubstring.length() - 1);
            }
        } else {
            String strM75504a = C12550f.m75504a(c11799dM70326f);
            if (!TextUtils.isEmpty(strM75504a)) {
                strSubstring = "V2:" + strM75504a;
            }
        }
        C11839m.m70686d("CloudBackupV3ModuleCreate", "getBloomFilterByAppId end, is V1 = " + z10 + ", appId = " + this.appId + ", boomFilter length = " + strSubstring.length());
        return strSubstring;
    }

    /* renamed from: C */
    public final void m58312C(StringBuilder sb2, List<C12161c> list) {
        Iterator<C12161c> it = list.iterator();
        while (it.hasNext()) {
            sb2.append(it.next().m73009x());
            sb2.append(",");
        }
    }

    /* renamed from: D */
    public final void m58313D(C11799d<String> c11799d, List<C12161c> list) {
        Iterator<C12161c> it = list.iterator();
        while (it.hasNext()) {
            c11799d.m70331l(it.next().m73009x());
        }
    }

    /* renamed from: E */
    public final C9721b m58314E() {
        C9721b c9721b;
        synchronized (f46580u) {
            c9721b = this.f46593m;
        }
        return c9721b;
    }

    /* renamed from: F */
    public final String m58315F(String str) {
        return str.replace(this.f46594n + this.appId + "/", "");
    }

    /* renamed from: G */
    public final Map<String, String> m58316G(List<String> list) throws C9721b {
        if (this.f46583c == null) {
            return null;
        }
        IdTransfer idTransferM58318I = m58318I(this.f46586f, this.f46584d, this.f46581a.m29728n0().mo8329d().getLockId(), list);
        return idTransferM58318I == null ? new HashMap() : idTransferM58318I.getCloudPathMap();
    }

    /* renamed from: H */
    public final boolean m58317H(CloudBackupStatus cloudBackupStatus) {
        if (cloudBackupStatus.m29866T()) {
            return true;
        }
        return !cloudBackupStatus.m29866T() && 1 == cloudBackupStatus.m29351H0();
    }

    /* renamed from: I */
    public IdTransfer m58318I(String str, final String str2, final String str3, List<String> list) throws C9721b {
        final IdTransferRequest idTransferRequest = new IdTransferRequest();
        idTransferRequest.setCloudPathList(list);
        return (IdTransfer) new C14000c0(new C14000c0.a() { // from class: dm.u
            @Override // p814yl.C14000c0.a
            /* renamed from: a */
            public final CloudBackupV3Request mo1697a(CloudBackupV3Server cloudBackupV3Server) {
                return this.f46520a.m58323N(idTransferRequest, str2, str3, cloudBackupV3Server);
            }
        }).m84139b("Backup.device.files.idTransfer", str);
    }

    /* renamed from: J */
    public final void m58319J(C12810a c12810a, C12810a c12810a2, C12810a c12810a3, C12810a c12810a4) {
        m58333k(c12810a, c12810a2, c12810a3, c12810a4);
        m58330U();
        C11839m.m70686d("CloudBackupV3ModuleCreate", "initAttachUploadProgress already: " + this.f46589i.m29868a() + " ,all: " + this.f46589i.m29873g());
    }

    /* renamed from: K */
    public final void m58320K(C12164f c12164f) throws C9721b {
        int iM73032E = c12164f.m73032E();
        int iM73038H = c12164f.m73038H();
        int i10 = iM73038H + iM73032E;
        C11839m.m70688i("CloudBackupV3ModuleCreate", "toMkfileNums: " + iM73032E + " alreadyMkNums: " + iM73038H);
        if (i10 > 0) {
            this.f46589i.mo29310W(iM73038H).mo29325f0(i10);
        }
    }

    /* renamed from: L */
    public final boolean m58321L() {
        return TextUtils.equals(new SettingOperator().queryFileSourceStrategy(), "2");
    }

    /* renamed from: M */
    public final /* synthetic */ void m58322M(boolean z10, StringBuilder sb2, C11799d c11799d, List list, int i10) throws C9721b {
        C11839m.m70686d("CloudBackupV3ModuleCreate", "getBloomFilterByAppId batchExecute appId = " + this.appId + ", listsize = " + list.size() + ", summary = " + i10);
        if (z10) {
            m58312C(sb2, list);
        } else {
            m58313D(c11799d, list);
        }
    }

    /* renamed from: N */
    public final /* synthetic */ CloudBackupV3Request m58323N(IdTransferRequest idTransferRequest, String str, String str2, CloudBackupV3Server cloudBackupV3Server) throws IOException {
        File.IdTransfer idTransfer = cloudBackupV3Server.backup().device().file().idTransfer(idTransferRequest);
        idTransfer.setBackupAction(this.f46587g).setBackupDeviceId(str).setLockId(str2).setXHwBackupPackageName(this.appId).setXHwBackupid(this.f46585e);
        return idTransfer;
    }

    /* renamed from: O */
    public final /* synthetic */ void m58324O(String str, AbstractC10554e abstractC10554e) {
        m58326Q(str, abstractC10554e.m64746y());
    }

    /* renamed from: P */
    public final void m58325P(String str, List<C12161c> list, boolean z10) throws InterruptedException, C9721b {
        int size = list.size();
        if (size > 0) {
            if (z10 || size >= this.f46590j) {
                CloudBackupCreateManager.getInstance().await(this);
                isCancel();
                if (m58314E() != null) {
                    throw this.f46593m;
                }
                CloudBackupCreateManager.getInstance().addTask(str, new C9218j(this.f46581a, this.f46583c, str, this.f46587g, new ArrayList(list), new C9218j.b() { // from class: dm.y
                    @Override // dm.C9218j.b
                    public final void onError(C9721b c9721b) {
                        this.f46574a.m58331V(c9721b);
                    }
                }, this.f46589i.m29861N()));
                list.clear();
                CloudBackupStatus cloudBackupStatus = this.f46589i;
                cloudBackupStatus.mo29310W(cloudBackupStatus.m29869c() + size);
                C11963c.m71970y(this.f46589i, this.f46587g);
            }
        }
    }

    /* renamed from: Q */
    public final void m58326Q(String str, long j10) {
        synchronized (f46579t) {
            try {
                this.f46596p.put(str, Long.valueOf(j10));
                Iterator<Long> it = this.f46596p.values().iterator();
                long jLongValue = 0;
                while (it.hasNext()) {
                    jLongValue += it.next().longValue();
                }
                long jM29873g = this.f46589i.m29873g();
                if ((jM29873g > 0 ? (int) Math.floor((jLongValue / jM29873g) * 100.0d) : 0) > (jM29873g > 0 ? (int) Math.floor((this.f46589i.m29868a() / jM29873g) * 100.0d) : 0)) {
                    this.f46589i.mo29308V(jLongValue);
                    C11963c.m71970y(this.f46589i, this.f46587g);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: R */
    public final void m58327R(long j10) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("mkFileDuration", String.valueOf(System.currentTimeMillis() - j10));
        C11060c c11060cM66626a = C11058a.m66626a(this.f46586f, "MkFileDuration", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("010_200");
        linkedHashMap.put("userType", C13452e.m80781L().m80987x0());
        linkedHashMap.put("gradeCode", C12590s0.m75747G0());
        C13622a.m81971q(c11060cM66626a, linkedHashMap, false, true);
    }

    /* renamed from: S */
    public void m58328S(CloudBackupStatus cloudBackupStatus, String str) throws InterruptedException, C9721b {
        this.f46581a.isCancel();
        new C9195d0(this.f46581a, cloudBackupStatus).m57757s(str);
    }

    /* renamed from: T */
    public void m58329T(CloudBackupStatus cloudBackupStatus, String str) throws InterruptedException, C9721b {
        this.f46581a.isCancel();
        new C9195d0(this.f46581a, cloudBackupStatus).m57760v(str);
    }

    /* renamed from: U */
    public final void m58330U() {
        Iterator<Long> it = this.f46597q.values().iterator();
        long jLongValue = 0;
        while (it.hasNext()) {
            jLongValue += it.next().longValue();
        }
        this.f46589i.mo29395c0(jLongValue);
        C11963c.m71970y(this.f46589i, this.f46587g);
    }

    /* renamed from: V */
    public final void m58331V(Throwable th2) {
        synchronized (f46580u) {
            try {
                if (this.f46593m == null) {
                    if (th2 instanceof C9721b) {
                        this.f46593m = (C9721b) th2;
                    } else {
                        this.f46593m = new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "unknown error." + th2.toString() + ",stackTrace: " + C12590s0.m75731C0(th2));
                    }
                    C11839m.m70687e("CloudBackupV3ModuleCreate", "task error. " + th2.toString() + ", exception" + this.f46593m.toString());
                    if (this.f46593m.m60659c() == 1013 || this.f46593m.m60659c() == 3931) {
                        try {
                            m58328S(this.f46589i, "module_reset_from_mkfile_file_has_not_exist_404");
                        } catch (C9721b e10) {
                            C11839m.m70689w("CloudBackupV3ModuleCreate", "reset module error, " + e10.toString());
                        }
                    }
                    this.f46582b.mo57894p(this.f46593m);
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    /* renamed from: W */
    public final C11308a m58332W(String str, final String str2, C12810a c12810a, int i10) throws Throwable {
        try {
            java.io.File fileM58342z = m58342z(this.f46589i, this.appId, str);
            if (fileM58342z.exists()) {
                C10561k c10561k = new C10561k(this.appId, this.f46586f, this.f46599s, this.f46581a.m29728n0(), fileM58342z, this.f46588h, str, null, this.f46589i.mo29357K());
                this.f46598r = c10561k;
                c10561k.m64771U(this.f46589i.m29861N()).m64769S(this.f46585e);
                this.f46598r.m64772V(i10 > 0);
                this.f46598r.m64770T(new InterfaceC10570t() { // from class: dm.x
                    @Override // im.InterfaceC10570t
                    /* renamed from: a */
                    public final void mo57738a(AbstractC10554e abstractC10554e) {
                        this.f46537a.m58324O(str2, abstractC10554e);
                    }
                });
                if ("apk".equals(str) || "icon".equals(str)) {
                    this.f46598r.m64781b0(this.appId).m64786g0(this.f46589i.m29407h1()).m64783d0("sha256").m64782c0(c12810a.m76853d()).m64785f0(c12810a.m76855f()).m64784e0(String.valueOf(c12810a.m76861l()));
                }
                return this.f46598r.m64763M(i10);
            }
            C11839m.m70689w("CloudBackupV3ModuleCreate", "attach not exist, appId: " + this.appId + ", file: " + fileM58342z.getName());
            m58328S(this.f46589i, "module_reset_from_upload_attach_not_exist");
            throw new C9721b(FamilyShareConstants.StatusCode.SHARE_SPACE_NOT_ENOUGH, "attach not exist, appId: " + this.appId + ", file: " + fileM58342z.getName());
        } catch (C9721b e10) {
            if (this.abort) {
                throw e10;
            }
            isCancel();
            int i11 = i10 + 1;
            if (i11 > 2 || C14337f.m85500c().contains(Integer.valueOf(e10.m60659c()))) {
                throw e10;
            }
            SystemClock.sleep(500L);
            isCancel();
            C11839m.m70688i("CloudBackupV3ModuleCreate", "upload appId = " + this.appId + "attach = " + str + ", retry = " + i11);
            return m58332W(str, str2, c12810a, i11);
        }
    }

    @Override // com.huawei.android.hicloud.cloudbackup.manager.CloudBackupBaseTask
    public void call() {
        m58341y();
    }

    @Override // com.huawei.android.hicloud.cloudbackup.manager.CloudBackupBaseTask
    public void cancel(boolean z10) {
        abort();
        C10561k c10561k = this.f46598r;
        if (c10561k != null) {
            c10561k.mo64711f();
        }
        super.cancel(z10);
    }

    @Override // com.huawei.android.hicloud.cloudbackup.manager.CloudBackupBaseTask
    public boolean isAbort() {
        return this.abort || this.f46581a.isAbort();
    }

    /* renamed from: k */
    public final void m58333k(C12810a... c12810aArr) {
        long jM76861l = 0;
        for (C12810a c12810a : c12810aArr) {
            if (c12810a != null) {
                this.f46597q.put(c12810a.m76864o(), Long.valueOf(c12810a.m76861l()));
                if (c12810a.m76862m() == 2 && c12810a.m76858i() == 0) {
                    this.f46596p.put(c12810a.m76864o(), Long.valueOf(c12810a.m76861l()));
                    jM76861l += c12810a.m76861l();
                }
                if (c12810a.m76862m() == 2 && c12810a.m76858i() == 1 && !SnapshotDBManager.PREFIX_DATABASE_NAME.equalsIgnoreCase(c12810a.m76864o())) {
                    this.f46596p.put(c12810a.m76864o(), Long.valueOf(c12810a.m76861l()));
                    jM76861l += c12810a.m76861l();
                }
            }
        }
        this.f46589i.mo29308V(jM76861l);
    }

    /* renamed from: p */
    public final void m58334p(C12810a c12810a, C12810a c12810a2, String str, String str2) throws InterruptedException, C9721b {
        if (c12810a == null) {
            C11839m.m70688i("CloudBackupV3ModuleCreate", "attach is null, appId: " + this.appId + ", usage: " + str);
            return;
        }
        if (c12810a.m76862m() == 2 && c12810a.m76858i() == 0) {
            C11839m.m70688i("CloudBackupV3ModuleCreate", "uploaded assert success,is vfs file, appId: " + this.appId + ", usage: " + str);
            return;
        }
        if (c12810a.m76862m() == 2 && c12810a.m76858i() == 1 && !SnapshotDBManager.PREFIX_DATABASE_NAME.equalsIgnoreCase(c12810a.m76864o())) {
            C11839m.m70688i("CloudBackupV3ModuleCreate", "uploaded assert success,is dm file, appId: " + this.appId + ", usage: " + str);
            return;
        }
        isCancel();
        try {
            C11308a c11308aM58332W = m58332W(str, str2, c12810a2, 0);
            c12810a.m76875z(c11308aM58332W.m67889g()).m76844A(c11308aM58332W.m67890h()).m76867r(c11308aM58332W.m67883a()).m76849F(c11308aM58332W.m67898p()).m76846C(2).m76874y(1);
            if (SnapshotDBManager.PREFIX_DATABASE_NAME.equalsIgnoreCase(c12810a.m76864o())) {
                c12810a.m76869t(C11476b.m68622d(C10278a.m63442h(C13617a.m81942x(this.f46585e, this.appId, 0, this.f46589i.m29861N()))).getHash());
            }
            new C12812c().m76888g(c12810a);
            if (SnapshotDBManager.PREFIX_DATABASE_NAME.equals(str)) {
                java.io.File fileM63442h = C10278a.m63442h(C10279b.m63452a(C10278a.m63437c(C10278a.m63442h(C13617a.m81942x(this.f46585e, this.appId, 0, this.f46589i.m29861N())))) + java.io.File.separator + this.appId + FeedbackWebConstants.SUFFIX);
                if (fileM63442h.exists()) {
                    c12810a.m76845B(fileM63442h.length());
                    new C12812c().m76888g(c12810a);
                    C11839m.m70688i("CloudBackupV3ModuleCreate", "delete snapshot zip file appId: " + this.appId + ", result = " + fileM63442h.delete());
                }
            }
        } catch (Throwable th2) {
            if (SnapshotDBManager.PREFIX_DATABASE_NAME.equals(str)) {
                java.io.File fileM63442h2 = C10278a.m63442h(C10279b.m63452a(C10278a.m63437c(C10278a.m63442h(C13617a.m81942x(this.f46585e, this.appId, 0, this.f46589i.m29861N())))) + java.io.File.separator + this.appId + FeedbackWebConstants.SUFFIX);
                if (fileM63442h2.exists()) {
                    c12810a.m76845B(fileM63442h2.length());
                    new C12812c().m76888g(c12810a);
                    C11839m.m70688i("CloudBackupV3ModuleCreate", "delete snapshot zip file appId: " + this.appId + ", result = " + fileM63442h2.delete());
                }
            }
            throw th2;
        }
    }

    /* renamed from: q */
    public final void m58335q(List<String> list) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            list.set(i10, this.f46594n + this.appId + "/" + list.get(i10));
        }
    }

    /* renamed from: r */
    public final void m58336r() throws InterruptedException, C9721b {
        if (!C9733f.m60705z().m60720O("cloudBackupSnapshotRecoverBackup")) {
            C11839m.m70686d("CloudBackupV3ModuleCreate", "isDbCheckEnable false");
            return;
        }
        new C12164f(this.f46585e, this.appId, 0, this.f46589i.m29861N()).close();
        java.io.File fileM63442h = C10278a.m63442h(C13617a.m81942x(this.f46585e, this.appId, 0, this.f46589i.m29861N()));
        if (DatabaseRepairUtil.m15913c(fileM63442h, C11058a.m66626a(this.f46581a.m29654O0(), "DatabaseRepairUtil", C13452e.m80781L().m80971t0()))) {
            return;
        }
        m58329T(this.f46589i, "module_delete_from_snapshot_corrupt");
        throw new C9721b(1203, "database corrupt file:" + C10279b.m63452a(fileM63442h), "uploadAsset");
    }

    /* renamed from: s */
    public final void m58337s() throws InterruptedException, C9721b {
        if (m58321L()) {
            C11839m.m70688i("CloudBackupV3ModuleCreate", "checkV2CloudPath start appId: " + this.appId);
            while (true) {
                isCancel();
                C12164f c12164f = new C12164f(this.f46585e, this.appId, 0, this.f46589i.m29861N());
                List<String> listM73040I = c12164f.m73040I(50);
                if (listM73040I.isEmpty()) {
                    C11839m.m70688i("CloudBackupV3ModuleCreate", "checkV2CloudPath end appId: " + this.appId);
                    return;
                }
                m58335q(listM73040I);
                Map<String, String> mapM58316G = m58316G(listM73040I);
                if (mapM58316G == null || mapM58316G.isEmpty()) {
                    break;
                } else {
                    c12164f.m73079g(m58310A(mapM58316G));
                }
            }
            C11839m.m70689w("CloudBackupV3ModuleCreate", "checkV2CloudPath responseMap is empty appId: " + this.appId);
        }
    }

    /* renamed from: t */
    public final void m58338t(CloudBackupStatus cloudBackupStatus) throws InterruptedException, C9721b {
        if (!m58317H(cloudBackupStatus)) {
            C11839m.m70688i("CloudBackupV3ModuleCreate", "make file skip, appId = " + this.appId + ", no backup metas ,uid: " + cloudBackupStatus.m29861N());
            return;
        }
        isCancel();
        C12164f c12164f = new C12164f(this.f46585e, this.appId, 0, cloudBackupStatus.m29861N());
        boolean zMo17121e0 = true;
        if (c12164f.m73026B() <= 0) {
            C11839m.m70689w("CloudBackupV3ModuleCreate", "appId = " + this.appId + " metas is empty,uid: " + cloudBackupStatus.m29861N());
            m58328S(cloudBackupStatus, "module_reset_from_mkfile_file_num_is_zero");
            if (!HNConstants.DataType.CONTACT.equalsIgnoreCase(this.appId)) {
                throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "appId = " + this.appId + " metas is empty, backupData:" + cloudBackupStatus.m29351H0() + ", isOmConfigAble:" + cloudBackupStatus.m29419m1() + ", isSwitchOpen:" + cloudBackupStatus.m29425o1(), "mkfile");
            }
            InterfaceC9284c interfaceC9284c = (InterfaceC9284c) C1270a.m7534b().m7535a(InterfaceC9284c.class);
            if (interfaceC9284c != null) {
                C11839m.m70689w("CloudBackupV3ModuleCreate", "cloudSyncRouter is null");
                zMo17121e0 = interfaceC9284c.mo17121e0();
            }
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "appId = " + this.appId + " metas is empty, backupData:" + cloudBackupStatus.m29351H0() + ", isOmConfigAble:" + cloudBackupStatus.m29419m1() + ", isSwitchOpen:" + cloudBackupStatus.m29425o1() + ", hasContactData: " + zMo17121e0, "mkfile");
        }
        isCancel();
        long jM73100q0 = c12164f.m73100q0();
        if (jM73100q0 > 0) {
            C11839m.m70689w("CloudBackupV3ModuleCreate", "not all data upload isSuccess. appId = " + this.appId + " file count = " + jM73100q0 + " ,uid: " + cloudBackupStatus.m29861N());
            String str = "not all data upload isSuccess. appId = " + this.appId + " file count = " + jM73100q0 + " ,uid: " + cloudBackupStatus.m29861N();
            m58328S(cloudBackupStatus, "module_reset_from_mkfile_file_has_error_file");
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, str, "mkfile");
        }
        this.f46581a.m29736p2(true);
        this.f46590j = Math.min(new SettingOperator().queryMaxBatchNumber(), this.f46592l.m75392g0());
        C11839m.m70688i("CloudBackupV3ModuleCreate", "make file begin, appId = " + this.appId + ", rowBatch: " + this.f46590j + " ,uid: " + cloudBackupStatus.m29861N());
        isCancel();
        long jCurrentTimeMillis = System.currentTimeMillis();
        new C11482d(this.appId, c12164f).execute(new InterfaceC11495q() { // from class: dm.v
            @Override // mm.InterfaceC11495q
            /* renamed from: a */
            public final void mo1695a(AbstractC11494p abstractC11494p, int i10) throws InterruptedException, C9721b {
                this.f46525a.m58339u(abstractC11494p, i10);
            }
        });
        m58327R(jCurrentTimeMillis);
        C11839m.m70688i("CloudBackupV3ModuleCreate", "make file end, appId = " + this.appId + " ,uid: " + cloudBackupStatus.m29861N());
    }

    /* renamed from: u */
    public final void m58339u(AbstractC11494p abstractC11494p, int i10) throws InterruptedException, C9721b {
        C11839m.m70688i("CloudBackupV3ModuleCreate", "make file start, appId: " + this.appId + ", size: " + i10 + " ,uid: " + this.f46589i.m29861N());
        if (i10 <= 0) {
            this.f46589i.mo29310W(1).mo29325f0(1);
        }
        C11963c.m71970y(this.f46589i, this.f46587g);
        ArrayList arrayList = new ArrayList();
        for (int i11 = 1; i11 <= i10; i11++) {
            C12161c c12161c = (C12161c) abstractC11494p.query(i11);
            if (c12161c != null) {
                C11839m.m70688i("CloudBackupV3ModuleCreate", "mkfile file type = " + c12161c.m72953I() + "path = " + (c12161c.m72950F() + c12161c.m72991l()));
                arrayList.add(c12161c);
                m58325P(this.appId, arrayList, false);
            }
        }
        m58325P(this.appId, arrayList, true);
        CloudBackupCreateManager.getInstance().syncLock(this.appId, this);
        if (m58314E() != null) {
            throw this.f46593m;
        }
        isCancel();
        long jM73074d0 = new C12164f(this.f46585e, this.appId, 0, this.f46589i.m29861N()).m73074d0();
        if (jM73074d0 <= 0) {
            C11839m.m70688i("CloudBackupV3ModuleCreate", "make file end, appId: " + this.appId + " ,uid: " + this.f46589i.m29861N());
            return;
        }
        C11839m.m70688i("CloudBackupV3ModuleCreate", "not all data make file isSuccess. appId = " + this.appId + " file count = " + jM73074d0 + " ,uid: " + this.f46589i.m29861N());
        String str = "not all data make file isSuccess. appId = " + this.appId + " file count = " + jM73074d0 + " ,uid: " + this.f46589i.m29861N();
        m58328S(this.f46589i, "module_reset_from_mkfile_file_has_error_file");
        throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, str, "mkfile");
    }

    /* renamed from: v */
    public void m58340v(CloudBackupStatus cloudBackupStatus) throws InterruptedException, SQLException {
        new C9195d0(this.f46581a, cloudBackupStatus).m57751m("file_delete_from_upload_snapshot");
        C12598v.m76036d(cloudBackupStatus.m29870d());
    }

    /* renamed from: y */
    public void m58341y() {
        String strM29870d;
        C12164f c12164f;
        long jM73107u0;
        C12810a c12810aM76886e;
        C12810a c12810aM76886e2;
        C12810a c12810aM76886e3;
        C12810a c12810aM76886e4;
        boolean z10;
        long j10;
        boolean z11;
        try {
            isCancel();
            strM29870d = this.f46589i.m29870d();
            this.f46591k.m75995E(strM29870d, this.f46585e, this.f46589i.m29861N());
            C11839m.m70688i("CloudBackupV3ModuleCreate", "do one module create start, appId = " + strM29870d + " uid: " + this.f46589i.m29861N());
            c12164f = new C12164f(this.f46585e, strM29870d, 0, this.f46589i.m29861N());
            c12164f.m73041I0();
            jM73107u0 = c12164f.m73107u0();
            m58320K(c12164f);
            long jCurrentTimeMillis = System.currentTimeMillis();
            C12812c c12812c = new C12812c();
            c12810aM76886e = c12812c.m76886e(strM29870d, "xml", this.f46589i.m29861N());
            c12810aM76886e2 = c12812c.m76886e(strM29870d, "apk", this.f46589i.m29861N());
            c12810aM76886e3 = c12812c.m76886e(strM29870d, "icon", this.f46589i.m29861N());
            c12810aM76886e4 = c12812c.m76886e(strM29870d, SnapshotDBManager.PREFIX_DATABASE_NAME, this.f46589i.m29861N());
            z10 = this.f46589i.m29863P() && (c12810aM76886e == null || c12810aM76886e2 == null);
            if (this.f46589i.m29866T() && c12810aM76886e4 == null) {
                j10 = jCurrentTimeMillis;
                z11 = true;
            } else {
                j10 = jCurrentTimeMillis;
                z11 = false;
            }
        } catch (Throwable th2) {
            try {
                m58331V(th2);
                C11839m.m70689w("CloudBackupV3ModuleCreate", "do one module mkfile error, appId = " + this.appId + ", " + th2.getMessage() + " ,uid: " + this.f46589i.m29861N());
                cancel(false);
            } catch (Throwable th3) {
                cancel(false);
                CloudBackupCreateManager.getInstance().removeTask(this.appId);
                C11965e.m71974f().m71985n(this.appId, this.f46589i.m29861N());
                throw th3;
            }
        }
        if (z10 || z11) {
            C11839m.m70688i("CloudBackupV3ModuleCreate", "attachment not exist, appId = " + strM29870d + ", uid = " + this.f46589i.m29861N());
            m58328S(this.f46589i, "module_reset_from_module_invalid");
            throw new C9721b(FamilyShareConstants.StatusCode.SHARE_SPACE_NOT_ENOUGH, "attachment not exist, appId = " + strM29870d + ", uid = " + this.f46589i.m29861N());
        }
        C12590s0.m75750H(c12164f, this.f46589i, this.f46581a);
        m58319J(c12810aM76886e, c12810aM76886e2, c12810aM76886e3, c12810aM76886e4);
        this.f46589i.m29365N1(m58311B());
        m58336r();
        m58334p(c12810aM76886e4, c12810aM76886e2, SnapshotDBManager.PREFIX_DATABASE_NAME, SnapshotDBManager.PREFIX_DATABASE_NAME);
        m58334p(c12810aM76886e, c12810aM76886e2, "xml", "xml");
        m58334p(c12810aM76886e2, c12810aM76886e2, "apk", "apk");
        m58334p(c12810aM76886e3, c12810aM76886e2, "icon", "icon");
        m58338t(this.f46589i);
        m58340v(this.f46589i);
        if (m58317H(this.f46589i)) {
            m58337s();
            C11839m.m70688i("CloudBackupV3ModuleCreate", "uploaded snapshot again, appId: " + strM29870d);
            m58336r();
            m58334p(c12810aM76886e4, c12810aM76886e2, SnapshotDBManager.PREFIX_DATABASE_NAME, "snapshot2");
        }
        long jM76861l = c12810aM76886e4 != null ? c12810aM76886e4.m76861l() : 0L;
        if (c12810aM76886e != null) {
            jM76861l += c12810aM76886e.m76861l();
        }
        long jM76861l2 = c12810aM76886e2 != null ? c12810aM76886e2.m76861l() : 0L;
        if (c12810aM76886e3 != null) {
            jM76861l2 += c12810aM76886e3.m76861l();
        }
        this.f46589i.mo29395c0(jM76861l);
        this.f46589i.mo29338z0(5).mo29289A0(6).mo29308V(0L).m29354I1(String.valueOf(jM76861l)).mo29321d0(jM76861l2);
        new C12815f(this.f46587g).m76934m(this.f46589i);
        C11963c.m71970y(this.f46589i, this.f46587g);
        this.f46595o.put("create", String.valueOf(System.currentTimeMillis() - j10));
        C11839m.m70688i("CloudBackupV3ModuleCreate", "do one module create end, appId = " + strM29870d + ", uid = " + this.f46589i.m29861N());
        CloudSpace cloudSpaceM29643I0 = this.f46581a.m29643I0();
        cloudSpaceM29643I0.setUsed(cloudSpaceM29643I0.getUsed() + jM73107u0);
        C11839m.m70688i("CloudBackupV3ModuleCreate", String.format(Locale.ENGLISH, "complete uploading files size is %s, space of user is %s bytes right now", Long.valueOf(jM73107u0), Long.valueOf(cloudSpaceM29643I0.getTotal() - cloudSpaceM29643I0.getUsed())));
        cancel(false);
        CloudBackupCreateManager.getInstance().removeTask(this.appId);
        C11965e.m71974f().m71985n(this.appId, this.f46589i.m29861N());
    }

    /* renamed from: z */
    public final java.io.File m58342z(CloudBackupStatus cloudBackupStatus, String str, String str2) throws Throwable {
        str2.hashCode();
        switch (str2) {
            case "apk":
                return C10278a.m63442h(ICBUtil.getLocationAPKFilePath(getLocation(), str, C12590s0.m75778O(cloudBackupStatus)));
            case "xml":
                return C10278a.m63442h(ICBUtil.getInfoXmlFilePath(getLocation(), str));
            case "icon":
                return C10278a.m63442h(ICBUtil.getLocationIconFilePath(getLocation(), str));
            case "snapshot":
                new C12164f(this.f46585e, str, 0, cloudBackupStatus.m29861N()).close();
                java.io.File fileM63442h = C10278a.m63442h(C13617a.m81942x(this.f46585e, str, 0, cloudBackupStatus.m29861N()));
                String strM63452a = C10279b.m63452a(C10278a.m63437c(fileM63442h));
                if (TextUtils.isEmpty(strM63452a)) {
                    throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "get snapshot parent path error, appId = " + str, "uploadAsset");
                }
                String str3 = strM63452a + java.io.File.separator + str + FeedbackWebConstants.SUFFIX;
                C12590s0.m75830a3(fileM63442h, str3);
                java.io.File fileM63442h2 = C10278a.m63442h(str3);
                this.f46597q.put(str2, Long.valueOf(fileM63442h2.length()));
                this.f46597q.put(str2 + "2", Long.valueOf(fileM63442h2.length()));
                m58330U();
                return fileM63442h2;
            default:
                throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "usage is illegal.");
        }
    }
}
