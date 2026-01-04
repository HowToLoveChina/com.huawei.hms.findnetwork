package dm;

import am.InterfaceC0275i1;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.SQLException;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.core.content.p019pm.PackageInfoCompat;
import com.google.gson.Gson;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.p076db.bean.Albums;
import com.huawei.android.hicloud.cloudbackup.p076db.operator.AlbumOperator;
import com.huawei.android.hicloud.cloudbackup.p076db.temp.AlbumsTempOperator;
import com.huawei.android.hicloud.cloudbackup.p076db.temp.AlbumsTempScript;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.BriefFileChangeSnapshot;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator.PmsFullBriefFilesInfoOperator;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator.PmsFullBriefFilesInfoOperatorV3;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator.PmsMetaStatusOperator;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator.PmsMetaStatusOperatorV3;
import com.huawei.android.hicloud.cloudbackup.process.CloneService;
import com.huawei.android.hicloud.cloudbackup.process.task.ScanMediaCallback;
import com.huawei.android.hicloud.cloudbackup.process.util.BackupCacheRecord;
import com.huawei.android.hicloud.cloudbackup.process.util.BackupRestoreUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.CloudBackupAppDataUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.ProgressCallback;
import com.huawei.android.hicloud.cloudbackup.process.util.ScanAppDataUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.SplitAppUtil;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.SnapshotDBManager;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackup3rdIconUtil;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.android.hicloud.cloudbackup.util.QueryAppMarketDataUtil;
import com.huawei.android.hicloud.cloudbackup.util.TransferedUtil;
import com.huawei.android.remotecontrol.tag.p092ui.view.RippleView;
import com.huawei.hicloud.base.bean.Md5AndHash;
import com.huawei.hicloud.cloudbackup.p104v3.core.C4879a;
import com.huawei.hicloud.cloudbackup.p104v3.omconfig.model.SyncSwitchStatus;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudBackupStatus;
import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.openalliance.p169ad.constant.Constants;
import fk.C9721b;
import hk.C10278a;
import hk.C10279b;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import mk.C11476b;
import om.C11963c;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0221j;
import p015ak.C0241z;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11839m;
import p582ql.C12370a;
import p582ql.C12371b;
import p617rl.C12526j;
import p618rm.C12535a;
import p618rm.C12543c1;
import p618rm.C12565k;
import p618rm.C12571m;
import p618rm.C12577o;
import p618rm.C12582p1;
import p618rm.C12583q;
import p618rm.C12590s0;
import p618rm.C12594t1;
import p618rm.C12597u1;
import p709vj.C13452e;
import p744wl.C13617a;
import p746wn.C13622a;
import p848zl.C14333b;
import pl.C12159a;
import pl.C12160b;
import pl.C12161c;
import pl.C12164f;
import sl.C12810a;
import sl.C12812c;
import sl.C12815f;

/* renamed from: dm.q0 */
/* loaded from: classes6.dex */
public class C9247q0 {

    /* renamed from: a */
    public C4879a f46384a;

    /* renamed from: b */
    public C9215i0 f46385b;

    /* renamed from: c */
    public String f46386c;

    /* renamed from: d */
    public String f46387d;

    /* renamed from: e */
    public CloudBackupStatus f46388e;

    /* renamed from: f */
    public CloudBackupAppDataUtil f46389f;

    /* renamed from: g */
    public ScanAppDataUtil f46390g;

    /* renamed from: h */
    public String f46391h;

    /* renamed from: i */
    public int f46392i = 0;

    /* renamed from: j */
    public long f46393j = 0;

    /* renamed from: k */
    public boolean f46394k = false;

    /* renamed from: l */
    public C12526j f46395l = new C12526j();

    /* renamed from: m */
    public C12594t1 f46396m = C12594t1.m75990o();

    /* renamed from: n */
    public C12577o f46397n;

    /* renamed from: o */
    public C12815f f46398o;

    /* renamed from: p */
    public C12164f f46399p;

    /* renamed from: q */
    public long f46400q;

    public C9247q0(C4879a c4879a, C9215i0 c9215i0, CloudBackupStatus cloudBackupStatus, CloudBackupAppDataUtil cloudBackupAppDataUtil, ScanAppDataUtil scanAppDataUtil) {
        this.f46384a = c4879a;
        this.f46385b = c9215i0;
        this.f46386c = c4879a.m29734p0();
        this.f46388e = cloudBackupStatus;
        this.f46387d = cloudBackupStatus.m29870d();
        this.f46389f = cloudBackupAppDataUtil;
        this.f46391h = c4879a.getLocation();
        this.f46397n = new C12577o(cloudBackupStatus.m29861N());
        this.f46398o = new C12815f(c4879a.m29713i0());
        this.f46390g = scanAppDataUtil;
    }

    /* renamed from: P */
    public static /* synthetic */ String m58029P(CloudBackupStatus cloudBackupStatus, String str) {
        return SplitAppUtil.splitAppDestAndroidDataPathToWritePath(str, cloudBackupStatus.m29861N());
    }

    /* renamed from: A */
    public int m58033A(final CloudBackupStatus cloudBackupStatus, List<String> list, String str) throws Throwable {
        m58084v(list, str);
        String str2 = C12583q.m75656J(str, cloudBackupStatus.m29861N()) + "/filter.txt";
        String str3 = C12583q.m75656J(str, cloudBackupStatus.m29861N()) + "/androiddata.txt";
        File fileM63442h = C10278a.m63442h(C12583q.m75656J(str, cloudBackupStatus.m29861N()));
        if (!fileM63442h.exists() && !fileM63442h.mkdirs()) {
            C11839m.m70687e("CloudBackupV3ModuleScan", "getAndroidDataBriefFile create desFile error: " + fileM63442h.getPath());
        }
        try {
            fileM63442h = C10278a.m63442h(str3);
            if (fileM63442h.exists() && !fileM63442h.delete()) {
                C11839m.m70688i("CloudBackupV3ModuleScan", "getAndroidDataBriefFile delete desFile error: " + fileM63442h.getName());
            }
            if (fileM63442h.createNewFile()) {
                BackupRestoreUtil backupRestoreUtil = new BackupRestoreUtil(m58034B(), this.f46384a, this.f46391h, new InterfaceC0275i1() { // from class: dm.p0
                    @Override // am.InterfaceC0275i1
                    /* renamed from: a */
                    public final void mo1767a(long j10) {
                        this.f46379a.m58047O(cloudBackupStatus, j10);
                    }
                });
                backupRestoreUtil.setPmsBriefFileSpeed(BackupRestoreUtil.PMS_DEFAULT_TXT_SPEED);
                return backupRestoreUtil.getBrief(CloudBackupConstant.Command.PMS_OPTION_FILE, str2, str3);
            }
            C11839m.m70687e("CloudBackupV3ModuleScan", "getAndroidDataBriefFile create desFile error: " + fileM63442h.getName());
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "getAndroidDataBriefFile create desFile error: " + fileM63442h.getName());
        } catch (Exception unused) {
            C11839m.m70687e("CloudBackupV3ModuleScan", "getAndroidDataBriefFile create desFile error: " + fileM63442h.getName());
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "getAndroidDataBriefFile create desFile error: " + fileM63442h.getName());
        }
    }

    /* renamed from: B */
    public final Context m58034B() {
        return C0213f.m1377a();
    }

    /* renamed from: C */
    public final String m58035C(String str) {
        return C12583q.m75680p(0) + File.separator + str;
    }

    /* renamed from: D */
    public final long[] m58036D(CloudBackupStatus cloudBackupStatus, File file, long j10, boolean z10, boolean z11) throws InterruptedException, C9721b, PackageManager.NameNotFoundException {
        boolean z12;
        ArrayList arrayList;
        String str;
        long j11;
        m58039G();
        long[] jArr = new long[2];
        long j12 = j10 + 1;
        if (!file.exists()) {
            return jArr;
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (!m58083u(file, arrayList2, arrayList3)) {
            return jArr;
        }
        String str2 = this.f46387d + ".apk";
        Iterator<File> it = arrayList2.iterator();
        long j13 = j12;
        long size = 0;
        long jM72951G = 0;
        while (true) {
            z12 = false;
            if (!it.hasNext()) {
                break;
            }
            File next = it.next();
            if (!z11 || !next.isHidden()) {
                String strM63452a = C10279b.m63452a(next);
                if (!m58080r(next, this.f46387d)) {
                    if (m58045M(next)) {
                        size += m58065f(next, j13).size();
                        j13 += r1 * 2;
                        if ("Memo".equalsIgnoreCase(this.f46387d)) {
                            cloudBackupStatus.m29361L1("clonePmsFlag");
                            C11839m.m70686d("CloudBackupV3ModuleScan", "memo pmsFile delete = " + next.delete());
                        }
                        arrayList = arrayList3;
                        str = str2;
                    } else {
                        if (strM63452a.endsWith(str2)) {
                            m58088z(cloudBackupStatus, strM63452a);
                        } else if (ICBUtil.isIconFile(strM63452a, this.f46391h, this.f46387d)) {
                            C11839m.m70686d("CloudBackupV3ModuleScan", "app icon attach exist");
                        } else if (m58041I(strM63452a, this.f46391h)) {
                            C11839m.m70686d("CloudBackupV3ModuleScan", "diff packet exist");
                        } else if (ICBUtil.isInfoFile(strM63452a, this.f46391h, this.f46387d)) {
                            arrayList = arrayList3;
                            str = str2;
                            j11 = j13;
                            m58063e(C10278a.m63442h(strM63452a), "", "xml", "", cloudBackupStatus.m29861N());
                            j13 = j11;
                        } else {
                            arrayList = arrayList3;
                            str = str2;
                            long j14 = j13;
                            C12161c c12161cM58082t = m58082t(next, j14, z10);
                            this.f46397n.m75562a(c12161cM58082t, this.f46386c, false, this.f46385b);
                            jM72951G += c12161cM58082t.m72951G();
                            size++;
                            j13 = j14 + 2;
                        }
                        arrayList = arrayList3;
                        str = str2;
                        j11 = j13;
                        j13 = j11;
                    }
                    str2 = str;
                    arrayList3 = arrayList;
                }
            }
        }
        ArrayList arrayList4 = arrayList3;
        long j15 = j13;
        arrayList2.clear();
        for (File file2 : arrayList4) {
            if (!z11 || !file2.isHidden()) {
                boolean z13 = z12;
                long[] jArrM58036D = m58036D(cloudBackupStatus, file2, j15, z10, z11);
                long j16 = jArrM58036D[z13 ? 1 : 0];
                long j17 = jArrM58036D[1];
                C12161c c12161cM58082t2 = m58082t(file2, j15, z10);
                size = size + 1 + j16;
                long jM72947C = c12161cM58082t2.m72947C() + (j16 * 2);
                c12161cM58082t2.m72992l0(jM72947C + 1);
                c12161cM58082t2.m72996n0(j17);
                jM72951G += j17;
                this.f46397n.m75562a(c12161cM58082t2, this.f46386c, z13, this.f46385b);
                j15 = jM72947C + 2;
                z12 = z13 ? 1 : 0;
            }
        }
        boolean z14 = z12;
        arrayList4.clear();
        this.f46397n.m75562a(null, this.f46386c, z14, this.f46385b);
        jArr[z14 ? 1 : 0] = size;
        jArr[1] = jM72951G;
        return jArr;
    }

    /* renamed from: E */
    public final String m58037E(File file, boolean z10, boolean z11) throws Throwable {
        String strM68620b;
        if (z10 || z11) {
            strM68620b = null;
        } else {
            try {
                strM68620b = C11476b.m68620b(file);
            } catch (C9721b e10) {
                C11839m.m70689w("CloudBackupV3ModuleScan", "get app manifest.mf hash failed. " + e10.toString());
                C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("02008"), "02008", C13452e.m80781L().m80971t0());
                c11060cM66626a.m66635A(e10.getMessage());
                c11060cM66626a.m66665u("001_" + e10.m60659c());
                c11060cM66626a.m66668x("1");
                C13622a.m81968n(this.m58034B(), c11060cM66626a);
            }
        }
        return (strM68620b == null || strM68620b.isEmpty()) ? C11476b.m68622d(file).getHash() : strM68620b;
    }

    /* renamed from: F */
    public final long m58038F(String str, String str2, int i10, CloudBackupAppDataUtil cloudBackupAppDataUtil) {
        return C12590s0.m75723A0(str, str2, i10, cloudBackupAppDataUtil, this.f46384a.m29722l0().mo1759d())[0];
    }

    /* renamed from: G */
    public final void m58039G() throws InterruptedException, C9721b {
        C9215i0 c9215i0 = this.f46385b;
        if (c9215i0 != null) {
            c9215i0.m59511j();
        }
    }

    /* renamed from: H */
    public final boolean m58040H(String str) {
        return str.endsWith(".dbsplite") || str.endsWith(".differencepacket") || str.endsWith(".dbhashfile") || str.contains("_diff_packet_index_");
    }

    /* renamed from: I */
    public final boolean m58041I(String str, String str2) {
        return this.f46388e.m29863P() && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str) && m58040H(str);
    }

    /* renamed from: J */
    public final boolean m58042J() {
        return this.f46388e.m29419m1() || C14333b.m85447C().contains(this.f46387d);
    }

    /* renamed from: K */
    public final boolean m58043K(CloudBackupStatus cloudBackupStatus) {
        int iM29859L = cloudBackupStatus.m29859L();
        if (iM29859L == 2 || iM29859L == 3) {
            long jM75408n0 = this.f46395l.m75408n0(this.f46384a.isAutoBackup());
            long jCurrentTimeMillis = System.currentTimeMillis() - cloudBackupStatus.m29385X0();
            if (jCurrentTimeMillis > 0 && jCurrentTimeMillis < jM75408n0) {
                return false;
            }
        } else if (iM29859L == 4 || iM29859L == 5 || iM29859L == 6) {
            long jM75406m0 = this.f46395l.m75406m0(this.f46384a.isAutoBackup());
            long jCurrentTimeMillis2 = System.currentTimeMillis() - cloudBackupStatus.m29404g1();
            if (jCurrentTimeMillis2 > 0 && jCurrentTimeMillis2 < jM75406m0) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: L */
    public final boolean m58044L(C12164f c12164f, CloudBackupStatus cloudBackupStatus) throws C9721b {
        if (!cloudBackupStatus.m29863P()) {
            return false;
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
        int iM73080g0 = c12164f.m73080g0(strM75665a.substring(strM75648B.length()));
        C11839m.m70688i("CloudBackupV3ModuleScan", "query not txt file count: " + iM73080g0 + ", appId: " + strM29870d);
        return iM73080g0 <= 0;
    }

    /* renamed from: M */
    public final boolean m58045M(File file) {
        return this.f46388e.m29866T() && this.f46387d.equals(file.getName().trim());
    }

    /* renamed from: N */
    public final boolean m58046N(File file) {
        boolean z10 = (TextUtils.equals("callRecorder", this.f46387d) && TextUtils.equals(file.getName(), ".nomedia")) ? false : true;
        if (!z10) {
            C11839m.m70686d("CloudBackupV3ModuleScan", "invalidFile: " + C10279b.m63452a(file));
        }
        return z10;
    }

    /* renamed from: O */
    public final /* synthetic */ void m58047O(CloudBackupStatus cloudBackupStatus, long j10) {
        cloudBackupStatus.mo29443v0(cloudBackupStatus.m29883s() + j10);
        C11963c.m71970y(cloudBackupStatus, this.f46384a.m29713i0());
    }

    /* renamed from: Q */
    public final /* synthetic */ void m58048Q(long j10, File file) throws InterruptedException, C9721b {
        m58039G();
        C11839m.m70688i("CloudBackupV3ModuleScan", " scanMedialibFile filePath " + C10279b.m63452a(file));
        this.f46397n.m75562a(m58082t(file, j10, false), this.f46386c, false, this.f46385b);
    }

    /* renamed from: R */
    public final void m58049R() {
        int i10 = this.f46392i;
        if (i10 >= 4 && i10 % 50 == 0) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - this.f46400q < RippleView.SINGLE_RIPPLE_TIME) {
                return;
            }
            this.f46400q = jCurrentTimeMillis;
            int iM29860M = this.f46388e.m29860M();
            if (iM29860M == 2) {
                this.f46388e.mo29437t0(this.f46392i);
                this.f46388e.mo29310W(this.f46392i).mo29308V(this.f46393j);
                C11963c.m71970y(this.f46388e, this.f46384a.m29713i0());
            } else if ((iM29860M == 3 || iM29860M == 4) && this.f46392i - this.f46388e.m29883s() > 0) {
                CloudBackupStatus cloudBackupStatus = this.f46388e;
                cloudBackupStatus.mo29443v0(this.f46392i - cloudBackupStatus.m29883s());
                if (this.f46388e.m29858I() != 3) {
                    this.f46388e.mo29310W(this.f46392i).mo29308V(this.f46393j);
                }
                C11963c.m71970y(this.f46388e, this.f46384a.m29713i0());
            }
        }
    }

    /* renamed from: S */
    public final void m58050S(Map<String, String> map, boolean z10) {
        map.put("has3rdData", String.valueOf(z10));
        if (z10 || !this.f46388e.m29425o1()) {
            return;
        }
        C12590s0.m75769L2(this.f46387d, this.f46384a.m29707g0(), 1);
    }

    /* renamed from: T */
    public final void m58051T(File[] fileArr, String str) {
        if ("com.tencent.mm".equals(this.f46387d) && !TextUtils.isEmpty(str) && str.contains(this.f46387d)) {
            for (File file : fileArr) {
                String name = file.getName();
                if ("MicroMsg".equalsIgnoreCase(name) && !"MicroMsg".equals(name)) {
                    this.f46385b.m57870T().put("lowerCasePath", C10279b.m63452a(file));
                    return;
                }
            }
        }
    }

    /* renamed from: U */
    public final void m58052U(String str) throws C9721b {
        new C9195d0(this.f46384a, this.f46388e).m57757s(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* renamed from: V */
    public void m58053V(Map<String, String> map) throws C9721b {
        this.f46384a.m29751u2(this.f46388e.m29863P() || this.f46388e.m29867U(), this.f46387d, this.f46388e.m29861N());
        try {
            if (this.f46388e.mo29370Q()) {
                this.f46389f.changeToSeparaSetting(this.f46388e.m29861N());
            }
            this.f46394k = this.f46388e.m29419m1() && this.f46388e.m29425o1();
            if (this.f46388e.m29863P()) {
                CloudBackupStatus cloudBackupStatus = this.f46388e;
                cloudBackupStatus.m29384W1(this.f46384a.m29687Z0(cloudBackupStatus));
            }
            m58039G();
            this.f46399p = new C12164f(this.f46386c, this.f46387d, 0, this.f46388e.m29861N());
            m58073k(this.f46388e, this.f46389f);
            long jM73070b0 = this.f46399p.m73070b0();
            int iM73026B = this.f46399p.m73026B();
            ?? r13 = (!m58042J() || !this.f46388e.m29425o1() || iM73026B <= 0 || m58044L(this.f46399p, this.f46388e)) ? 0 : 1;
            m58039G();
            C12590s0.m75750H(this.f46399p, this.f46388e, this.f46384a);
            m58039G();
            if (this.f46388e.m29866T() || !(this.f46388e.m29866T() || r13 == 0)) {
                C11839m.m70688i("CloudBackupV3ModuleScan", "has snapshot data, appId = " + this.f46387d + " uid: " + this.f46388e.m29861N());
                m58063e(C10278a.m63442h(C13617a.m81942x(this.f46386c, this.f46387d, 0, this.f46388e.m29861N())), "", SnapshotDBManager.PREFIX_DATABASE_NAME, "", this.f46388e.m29861N());
            } else {
                C11839m.m70688i("CloudBackupV3ModuleScan", "no snapshot data, appId = " + this.f46387d + " uid: " + this.f46388e.m29861N());
                this.f46396m.m76008h(this.f46387d, this.f46386c, this.f46388e.m29861N());
                C11963c.m71966u(this.f46387d, this.f46388e.m29861N(), this.f46384a.m29713i0());
            }
            if (!this.f46388e.m29866T() && map != null) {
                m58050S(map, r13);
            }
            int iM29877l = this.f46388e.m29866T() ? this.f46388e.m29877l() : iM73026B;
            if (HNConstants.DataType.MEDIA.equals(this.f46387d) || "music".equals(this.f46387d)) {
                iM29877l = HNConstants.DataType.MEDIA.equals(this.f46387d) ? iM73026B - 1 : iM73026B;
            } else {
                iM73026B = iM29877l;
            }
            long jM29875i = this.f46388e.m29875i();
            this.f46388e.mo29338z0(3).mo29310W(0).mo29325f0(iM73026B).mo29327g0(iM29877l).mo29323e0(jM73070b0).m29423n2(System.currentTimeMillis()).m29453y1(r13);
            if (this.f46388e.m29858I() != 3) {
                this.f46388e.mo29308V(0L);
            }
            this.f46398o.m76934m(this.f46388e);
            C11839m.m70686d("CloudBackupV3ModuleScan", "scan beforeDataByte: " + jM29875i + " dataBytes: " + jM73070b0);
            if (this.f46388e.m29863P() && jM29875i == 0 && jM73070b0 > 0 && r13 != 0) {
                C11963c.m71947b(this.f46388e, this.f46384a.m29713i0());
                BackupOptionItem backupOptionItemQueryItem = TransferedUtil.queryItem(this.f46387d, this.f46384a.m29722l0().mo1759d());
                if (backupOptionItemQueryItem != null) {
                    backupOptionItemQueryItem.setDataBytes(jM73070b0);
                    this.f46384a.m29722l0().mo1759d().m78382Q(backupOptionItemQueryItem);
                }
            }
            ArrayList<C12370a> moduleInfoList = CloneService.getInstance().getModuleInfoList();
            if (!moduleInfoList.isEmpty()) {
                new C12371b(this.f46386c, this.f46387d, 0, this.f46388e.m29861N()).m74417c(moduleInfoList);
            }
            this.f46384a.m29751u2(false, this.f46387d, this.f46388e.m29861N());
        } catch (Throwable th2) {
            this.f46384a.m29751u2(false, this.f46387d, this.f46388e.m29861N());
            throw th2;
        }
    }

    /* renamed from: W */
    public final void m58054W(List<String> list, final CloudBackupStatus cloudBackupStatus, String str, boolean z10) throws Throwable {
        if (list.isEmpty()) {
            C11839m.m70688i("CloudBackupV3ModuleScan", "scan android data includePath is empty");
            return;
        }
        int iM58033A = m58033A(cloudBackupStatus, (List) list.stream().map(new Function() { // from class: dm.o0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return C9247q0.m58029P(cloudBackupStatus, (String) obj);
            }
        }).collect(Collectors.toList()), str);
        if (iM58033A != 0) {
            throw new C9721b(2101, "pms get android data brief file failed, briefCode = " + iM58033A);
        }
        new BriefFileChangeSnapshot(new ProgressCallback(), cloudBackupStatus.mo29421n(), cloudBackupStatus).readBriefFileToSnapshot(C12583q.m75656J(str, cloudBackupStatus.m29861N()) + "/androiddata.txt", new C12164f(this.f46386c, cloudBackupStatus.m29870d(), 0, cloudBackupStatus.m29861N()), z10);
    }

    /* renamed from: X */
    public final long m58055X(String str, CloudBackupStatus cloudBackupStatus, long j10) throws InterruptedException, C9721b, PackageManager.NameNotFoundException {
        m58039G();
        C11839m.m70688i("CloudBackupV3ModuleScan", "scan3rdAppCloneFiles begin, " + str + ", uid: " + cloudBackupStatus.m29861N());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f46391h);
        sb2.append(File.separator);
        sb2.append(str);
        String string = sb2.toString();
        File fileM63442h = C10278a.m63442h(string);
        if (!fileM63442h.exists() && !fileM63442h.mkdirs()) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "scan3rdAppCloneFiles error path = " + string + " is not exist");
        }
        long[] jArrM58036D = m58036D(cloudBackupStatus, fileM63442h, j10, true, false);
        this.f46397n.m75562a(null, this.f46386c, true, this.f46385b);
        long j11 = jArrM58036D[0];
        C11839m.m70688i("CloudBackupV3ModuleScan", "scan3rdAppCloneFiles end, " + str + ", uid: " + cloudBackupStatus.m29861N());
        return (j11 * 2) + 1;
    }

    /* renamed from: Y */
    public final long m58056Y(List<String> list, CloudBackupStatus cloudBackupStatus, long j10, boolean z10) throws InterruptedException, C9721b, PackageManager.NameNotFoundException {
        Iterator<String> it;
        m58039G();
        C11839m.m70688i("CloudBackupV3ModuleScan", "scan3rdAppDataFiles begin, " + this.f46387d + ", uid: " + cloudBackupStatus.m29861N());
        Iterator<String> it2 = list.iterator();
        while (true) {
            long jM72949E = j10;
            while (it2.hasNext()) {
                String next = it2.next();
                File fileM63442h = C10278a.m63442h(next);
                if (!fileM63442h.exists()) {
                    m58070h0(cloudBackupStatus);
                    throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "scan3rdAppDataFiles error path = " + next + " is not exist");
                }
                if (!z10 || !fileM63442h.isHidden()) {
                    if (!fileM63442h.isDirectory()) {
                        it = it2;
                    } else if (!m58079q(C10278a.m63440f(fileM63442h))) {
                        C12161c c12161cM58082t = m58082t(fileM63442h, jM72949E, true);
                        long[] jArrM58036D = m58036D(cloudBackupStatus, fileM63442h, c12161cM58082t.m72947C(), true, z10);
                        int i10 = (int) jArrM58036D[0];
                        long j11 = jArrM58036D[1];
                        it = it2;
                        j10 = jM72949E;
                        c12161cM58082t.m72992l0(c12161cM58082t.m72947C() + (i10 * 2) + 1);
                        c12161cM58082t.m72996n0(j11);
                        if (i10 == 0) {
                            C11839m.m70686d("CloudBackupV3ModuleScan", "node child is empty path :" + next);
                            it2 = it;
                        } else {
                            jM72949E = c12161cM58082t.m72949E() + 1;
                        }
                    }
                    it2 = it;
                }
                it = it2;
                j10 = jM72949E;
                it2 = it;
            }
            m58039G();
            this.f46397n.m75562a(null, this.f46386c, true, this.f46385b);
            C11839m.m70688i("CloudBackupV3ModuleScan", "scan3rdAppDataFiles end, " + this.f46387d + ", uid: " + cloudBackupStatus.m29861N());
            return jM72949E;
        }
    }

    /* renamed from: Z */
    public final long m58057Z(List<String> list, String str, CloudBackupStatus cloudBackupStatus, long j10) throws InterruptedException, C9721b, SQLException {
        m58039G();
        if (list.isEmpty()) {
            C11839m.m70688i("CloudBackupV3ModuleScan", "scan3rdAppDataFilesByPmsBriefDb paths is empty");
            return j10;
        }
        C11839m.m70688i("CloudBackupV3ModuleScan", "scan3rdAppDataFilesByPmsBriefDb begin, " + str + ", uid: " + cloudBackupStatus.m29861N());
        File databasePath = C0213f.m1378b().getDatabasePath(C13617a.m81942x(this.f46386c, str, 0, cloudBackupStatus.m29861N()));
        if (databasePath == null || !databasePath.exists()) {
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "scan3rdAppDataFilesByPmsBriefDb error, backupId: " + this.f46386c + " snapshot db is not exist");
        }
        PmsFullBriefFilesInfoOperator pmsFullBriefFilesInfoOperator = new PmsFullBriefFilesInfoOperator(C13617a.m81914C(str, 0));
        long jQuerySum = pmsFullBriefFilesInfoOperator.querySum();
        int iQueryCount = pmsFullBriefFilesInfoOperator.queryCount();
        C11839m.m70688i("CloudBackupV3ModuleScan", "scan3rdAppDataFilesByPmsBriefDb pmsMetaSize: " + jQuerySum + ", count: " + iQueryCount);
        if (iQueryCount <= 0) {
            C11839m.m70688i("CloudBackupV3ModuleScan", "scan3rdAppDataFilesByPmsBriefDb no pms data");
            return j10;
        }
        pmsFullBriefFilesInfoOperator.attach(databasePath.getPath());
        try {
            try {
                pmsFullBriefFilesInfoOperator.pmsMetaToV3Snapshot(str, cloudBackupStatus.m29871e());
                pmsFullBriefFilesInfoOperator.detach();
                this.f46393j += jQuerySum;
                File fileM63442h = C10278a.m63442h(m58035C(str) + File.separator + str + ".txt");
                if (!fileM63442h.exists()) {
                    pmsFullBriefFilesInfoOperator.clear();
                    new PmsMetaStatusOperator(C13617a.m81914C(str, cloudBackupStatus.m29861N())).clear();
                    m58052U("module_reset_from_app_txt_invalid");
                    throw new C9721b(FamilyShareConstants.StatusCode.SHARE_SPACE_NOT_ENOUGH, "v3 scan3rdAppDataFilesByPmsBriefDb error, txtFile not exist or count is 0");
                }
                m58039G();
                this.f46397n.m75562a(m58082t(fileM63442h, j10, true), this.f46386c, true, this.f46385b);
                long j11 = ((iQueryCount + 1) * 2) + 1;
                C11839m.m70688i("CloudBackupV3ModuleScan", "scan3rdAppDataFilesByPmsBriefDb end, " + str + ", uid: " + cloudBackupStatus.m29861N());
                return j11;
            } catch (C9721b e10) {
                C11839m.m70687e("CloudBackupV3ModuleScan", "pmsMetaToSnapshot error: " + e10.toString());
                throw e10;
            }
        } catch (Throwable th2) {
            pmsFullBriefFilesInfoOperator.detach();
            throw th2;
        }
    }

    /* JADX WARN: Finally extract failed */
    /* renamed from: a0 */
    public final long m58058a0(List<String> list, String str, CloudBackupStatus cloudBackupStatus, long j10) throws InterruptedException, C9721b, SQLException {
        m58039G();
        if (list.isEmpty()) {
            C11839m.m70688i("CloudBackupV3ModuleScan", "scan3rdAppDataFilesByPmsBriefDbV3 paths is empty");
            return j10;
        }
        C11839m.m70688i("CloudBackupV3ModuleScan", "scan3rdAppDataFilesByPmsBriefDbV3 begin, " + str + ", uid: " + cloudBackupStatus.m29861N());
        File databasePath = C0213f.m1378b().getDatabasePath(C13617a.m81942x(this.f46386c, str, 0, cloudBackupStatus.m29861N()));
        if (databasePath == null || !databasePath.exists()) {
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "scan3rdAppDataFilesByPmsBriefDbV3 error, backupId: " + this.f46386c + " snapshot db is not exist");
        }
        String strM81914C = C13617a.m81914C(str, cloudBackupStatus.m29861N());
        PmsFullBriefFilesInfoOperatorV3 pmsFullBriefFilesInfoOperatorV3 = new PmsFullBriefFilesInfoOperatorV3(strM81914C);
        long jQuerySum = pmsFullBriefFilesInfoOperatorV3.querySum();
        int iQueryCount = pmsFullBriefFilesInfoOperatorV3.queryCount();
        C11839m.m70688i("CloudBackupV3ModuleScan", "scan3rdAppDataFilesByPmsBriefDbV3 pmsMetaSize: " + jQuerySum + ", count: " + iQueryCount);
        if (iQueryCount <= 0) {
            C11839m.m70688i("CloudBackupV3ModuleScan", "scan3rdAppDataFilesByPmsBriefDbV3 no pms data");
            return j10;
        }
        String path = databasePath.getPath();
        pmsFullBriefFilesInfoOperatorV3.attach(path);
        C11839m.m70688i("CloudBackupV3ModuleScan", "scan3rdAppDataFilesByPmsBriefDbV3 attach snapshotDbPath: " + path);
        try {
            try {
                pmsFullBriefFilesInfoOperatorV3.pmsMetaToSnapshot(str, cloudBackupStatus.m29871e());
                C12160b c12160b = new C12160b(this.f46386c, str, 0, cloudBackupStatus.m29861N());
                if (cloudBackupStatus.m29393b1().contains("isDiff")) {
                    List<C12159a> listM72938i = c12160b.m72938i();
                    Map<String, String> mapM75858h2 = C12590s0.m75858h2(cloudBackupStatus.m29393b1());
                    if (listM72938i == null || listM72938i.isEmpty()) {
                        if (Objects.equals(mapM75858h2.get("isDiff"), "1")) {
                            m58052U("module_reset_from_no_diff_info");
                            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "module scan checkdiffdb is empty");
                        }
                    } else {
                        HashSet hashSet = new HashSet();
                        for (C12159a c12159a : listM72938i) {
                            C11839m.m70688i("CloudBackupV3ModuleScan", "create diff packet meta, appId = " + str + ", file: " + c12159a.m72907j());
                            C12161c c12161cM72892b = c12159a.m72892b();
                            c12161cM72892b.m72957M(cloudBackupStatus.m29871e());
                            c12161cM72892b.m72983g0(1);
                            this.f46399p.m73111w0(c12161cM72892b);
                            if (c12161cM72892b.m72953I() == 8) {
                                hashSet.add(c12161cM72892b.m72991l());
                            }
                        }
                        Iterator it = hashSet.iterator();
                        while (it.hasNext()) {
                            pmsFullBriefFilesInfoOperatorV3.updateStatusByData((String) it.next(), 3);
                        }
                    }
                } else {
                    c12160b.m72932c(0);
                    C11839m.m70688i("CloudBackupV3ModuleScan", "IS_DIFF false, curDiffPacketMetaOperator clear");
                }
                pmsFullBriefFilesInfoOperatorV3.detach();
                C11839m.m70688i("CloudBackupV3ModuleScan", "scan3rdAppDataFilesByPmsBriefDbV3 detach ");
                this.f46393j += jQuerySum;
                File fileM63442h = C10278a.m63442h(m58035C(str) + File.separator + str + ".txt");
                if (!fileM63442h.exists()) {
                    pmsFullBriefFilesInfoOperatorV3.clear();
                    new PmsMetaStatusOperatorV3(strM81914C).clear();
                    m58052U("module_reset_from_app_txt_invalid");
                    throw new C9721b(FamilyShareConstants.StatusCode.SHARE_SPACE_NOT_ENOUGH, "scan3rdAppDataFilesByPmsBriefDbV3 error, txtFile not exist or count is 0");
                }
                m58039G();
                this.f46397n.m75562a(m58082t(fileM63442h, j10, true), this.f46386c, true, this.f46385b);
                long j11 = ((iQueryCount + 1) * 2) + 1;
                C11839m.m70688i("CloudBackupV3ModuleScan", "scan3rdAppDataFilesByPmsBriefDbV3 end, " + str + ", uid: " + cloudBackupStatus.m29861N());
                return j11;
            } catch (C9721b e10) {
                C11839m.m70687e("CloudBackupV3ModuleScan", "v3 pmsMetaToSnapshot error: " + e10.toString());
                throw e10;
            }
        } catch (Throwable th2) {
            pmsFullBriefFilesInfoOperatorV3.detach();
            C11839m.m70688i("CloudBackupV3ModuleScan", "scan3rdAppDataFilesByPmsBriefDbV3 detach ");
            throw th2;
        }
    }

    /* renamed from: b0 */
    public final void m58059b0(List<String> list, String str, boolean z10, CloudBackupStatus cloudBackupStatus, long j10) throws InterruptedException, C9721b, PackageManager.NameNotFoundException {
        m58039G();
        C11839m.m70688i("CloudBackupV3ModuleScan", "scan3rdAppSdcardFiles begin, " + str + ", uid: " + cloudBackupStatus.m29861N() + ", paths: " + list.toString());
        long jM72949E = j10;
        for (String strM75801T2 : list) {
            if (z10) {
                strM75801T2 = C12590s0.m75801T2(str, cloudBackupStatus.mo29421n(), cloudBackupStatus.m29861N(), cloudBackupStatus.m29345E0(), strM75801T2);
            }
            String str2 = strM75801T2;
            C11839m.m70688i("CloudBackupV3ModuleScan", "scan path: " + str2);
            File fileM63442h = C10278a.m63442h(str2);
            if (!fileM63442h.exists()) {
                if (!cloudBackupStatus.mo29370Q()) {
                    m58070h0(cloudBackupStatus);
                    throw new C9721b(FamilyShareConstants.StatusCode.SHARE_SPACE_NOT_ENOUGH, "scan3rdAppSdcardFiles error path = " + str2 + " is not exist");
                }
            } else if (fileM63442h.isDirectory()) {
                File[] fileArrM63440f = C10278a.m63440f(fileM63442h);
                if (!m58079q(fileArrM63440f)) {
                    m58051T(fileArrM63440f, str2);
                    C12161c c12161cM58082t = m58082t(fileM63442h, jM72949E, false);
                    long[] jArrM58036D = m58036D(cloudBackupStatus, fileM63442h, c12161cM58082t.m72947C(), z10, false);
                    long j11 = jArrM58036D[0];
                    long j12 = jArrM58036D[1];
                    c12161cM58082t.m72988j0(c12161cM58082t.m72947C() + (2 * j11) + 1);
                    c12161cM58082t.m72996n0(j12);
                    if (j11 == 0) {
                        C11839m.m70686d("CloudBackupV3ModuleScan", "scan3rdAppSdcardFiles node child is empty path :" + str2);
                    } else {
                        jM72949E = c12161cM58082t.m72949E() + 1;
                    }
                }
            }
        }
        m58039G();
        this.f46397n.m75562a(null, this.f46386c, true, this.f46385b);
        C11839m.m70688i("CloudBackupV3ModuleScan", "scan3rdAppSdcardFiles end, " + str + ", uid: " + cloudBackupStatus.m29861N());
    }

    /* renamed from: c0 */
    public final void m58060c0(CloudBackupStatus cloudBackupStatus, long j10, List<String> list) throws Throwable {
        if (cloudBackupStatus.mo29370Q()) {
            m58066f0(cloudBackupStatus, j10, list);
        } else {
            m58062d0(cloudBackupStatus, j10, list);
        }
    }

    /* renamed from: d */
    public final void m58061d(CloudBackupStatus cloudBackupStatus, CloudBackupAppDataUtil cloudBackupAppDataUtil) throws InterruptedException, C9721b, PackageManager.NameNotFoundException, SQLException {
        m58039G();
        long jM58067g = m58067g();
        m58039G();
        cloudBackupStatus.mo29446w0(m58038F(this.f46387d, cloudBackupStatus.mo29421n(), cloudBackupStatus.m29861N(), cloudBackupAppDataUtil)).mo29443v0(0L);
        m58075m(cloudBackupStatus, cloudBackupAppDataUtil, jM58067g);
        C11839m.m70688i("CloudBackupV3ModuleScan", "build3rdMetas , appId = " + this.f46387d + ", uid = " + cloudBackupStatus.m29861N());
        if (cloudBackupStatus.mo29370Q()) {
            SplitAppUtil.checkAppTwinStatus(cloudBackupStatus.mo29421n(), cloudBackupStatus.m29861N());
        }
    }

    /* renamed from: d0 */
    public final void m58062d0(CloudBackupStatus cloudBackupStatus, long j10, List<String> list) throws Throwable {
        if (this.f46384a.m29723l1()) {
            m58054W(list, cloudBackupStatus, this.f46387d, false);
        } else {
            m58059b0(list, this.f46387d, false, cloudBackupStatus, j10);
        }
    }

    /* renamed from: e */
    public final void m58063e(File file, String str, String str2, String str3, int i10) throws C9721b {
        Md5AndHash md5AndHashM68622d = C11476b.m68622d(file);
        C12810a c12810a = new C12810a();
        C12810a c12810aM76871v = c12810a.m76866q(this.f46387d).m76847D(i10).m76848E(str2).m76845B(file.length()).m76846C(0).m76874y(1).m76875z(md5AndHashM68622d.getMD5()).m76844A(md5AndHashM68622d.getHash()).m76871v(str);
        if (TextUtils.isEmpty(str3)) {
            str3 = md5AndHashM68622d.getHash();
        }
        c12810aM76871v.m76869t(str3);
        new C12812c().m76888g(c12810a);
    }

    /* renamed from: e0 */
    public final void m58064e0(final long j10) {
        new ScanAppDataUtil(this.f46387d, this.f46389f.getmCloudBackupInclude(), this.f46389f.getmCloudBackupExclude()).startScanMediaFile(new ScanMediaCallback() { // from class: dm.n0
            @Override // com.huawei.android.hicloud.cloudbackup.process.task.ScanMediaCallback
            public final void onScanEnd(File file) throws InterruptedException, C9721b {
                this.f46363a.m58048Q(j10, file);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:141:0x0131  */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<pl.C12161c> m58065f(java.io.File r19, long r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 363
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: dm.C9247q0.m58065f(java.io.File, long):java.util.List");
    }

    /* renamed from: f0 */
    public final void m58066f0(CloudBackupStatus cloudBackupStatus, long j10, List<String> list) throws Throwable {
        String strM29345E0 = this.f46388e.m29345E0();
        strM29345E0.hashCode();
        if (strM29345E0.equals("1")) {
            m58059b0(list, this.f46387d, true, cloudBackupStatus, j10);
        } else if (strM29345E0.equals("2")) {
            m58054W(list, cloudBackupStatus, this.f46387d, false);
        } else {
            m58059b0(list, this.f46387d, false, cloudBackupStatus, j10);
        }
    }

    /* renamed from: g */
    public long m58067g() throws InterruptedException, C9721b, PackageManager.NameNotFoundException, SQLException {
        long jM58056Y = 0;
        if (!this.f46394k || m58043K(this.f46388e)) {
            this.f46396m.m76007g(this.f46387d, this.f46386c, this.f46388e.m29861N());
            C12571m.m75547i(C12583q.m75662P(this.f46387d, this.f46388e.m29861N()));
            long jM58055X = m58055X(this.f46387d, this.f46388e, 0L);
            List<String> listM58086x = m58086x(this.f46387d);
            if (C12590s0.m75897r1(this.f46387d, this.f46388e.m29861N())) {
                jM58056Y = m58057Z(listM58086x, this.f46387d, this.f46388e, jM58055X);
                this.f46388e.mo29289A0(3);
            } else if (C12590s0.m75724A1(this.f46387d, this.f46388e.m29861N())) {
                jM58056Y = m58058a0(listM58086x, this.f46387d, this.f46388e, jM58055X);
                if (4 != this.f46388e.m29860M()) {
                    this.f46388e.mo29289A0(3);
                }
            } else {
                File fileM63442h = C10278a.m63442h(m58035C(this.f46387d));
                this.f46388e.mo29437t0(0L).mo29440u0(C12590s0.m75840d0(C10278a.m63441g(fileM63442h, this.f46387d + ".txt").getPath()));
                jM58056Y = m58056Y(listM58086x, this.f46388e, jM58055X, false);
                this.f46388e.mo29289A0(3);
            }
            this.f46388e.mo29338z0(2).m29374R1(System.currentTimeMillis());
            this.f46398o.m76934m(this.f46388e);
            C11963c.m71970y(this.f46388e, this.f46384a.m29713i0());
        } else {
            if (this.f46388e.m29860M() != 3) {
                this.f46388e.mo29289A0(3);
            }
            this.f46392i = this.f46399p.m73082h0();
            this.f46393j = this.f46399p.m73084i0();
            C11839m.m70688i("CloudBackupV3ModuleScan", "buildDataMetas no need scan data, query db  appid = " + this.f46387d + " , useid = " + this.f46388e.m29861N() + " , fileNum = " + this.f46392i + " , fileSize = " + this.f46393j);
            this.f46388e.mo29310W(this.f46392i).mo29308V(this.f46393j);
            C11963c.m71970y(this.f46388e, this.f46384a.m29713i0());
        }
        return jM58056Y;
    }

    /* renamed from: g0 */
    public final void m58068g0(long j10) {
        this.f46393j += j10;
        this.f46392i++;
        m58049R();
    }

    /* renamed from: h */
    public final void m58069h(String str, long j10) throws InterruptedException, C9721b, SQLException {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f46391h);
        String str2 = File.separator;
        sb2.append(str2);
        sb2.append(str);
        sb2.append(str2);
        sb2.append(AlbumsTempScript.DATABASE_NAME);
        File fileM63442h = C10278a.m63442h(sb2.toString());
        List<Albums> listQueryAllAlbums = new AlbumOperator().queryAllAlbums();
        AlbumsTempOperator albumsTempOperator = new AlbumsTempOperator();
        albumsTempOperator.clear();
        albumsTempOperator.replace((Albums[]) listQueryAllAlbums.toArray(new Albums[0]));
        albumsTempOperator.close();
        if (listQueryAllAlbums.isEmpty()) {
            C11839m.m70688i("CloudBackupV3ModuleScan", "empty albums!");
            return;
        }
        m58039G();
        this.f46397n.m75562a(m58082t(fileM63442h, j10, true), this.f46386c, false, this.f46385b);
    }

    /* renamed from: h0 */
    public final void m58070h0(CloudBackupStatus cloudBackupStatus) throws C9721b {
        cloudBackupStatus.mo29338z0(0).mo29289A0(-1).m29374R1(0L).m29342C1(0L).m29436s2(0L).m29423n2(0L).mo29310W(0).mo29308V(0L);
        this.f46398o.m76934m(cloudBackupStatus);
        C11963c.m71970y(cloudBackupStatus, this.f46384a.m29713i0());
    }

    /* JADX WARN: Finally extract failed */
    /* renamed from: i */
    public final void m58071i() throws InterruptedException, C9721b, SQLException {
        m58039G();
        this.f46396m.m76009i(this.f46387d, this.f46386c, this.f46388e.m29861N(), (this.f46384a.isRefurbishment() || this.f46384a.mo29591n()) ? false : true);
        List<String> listQueryBackupAlbumsPath = new AlbumOperator().queryBackupAlbumsPath();
        List listAsList = Arrays.asList(C0221j.m1512v(), C0221j.m1513w(), C0221j.m1473A());
        HashMap map = new HashMap();
        try {
            Cursor cursorQuery = m58034B().getContentResolver().query(MediaStore.Files.getContentUri("external"), new String[]{"_data", "datetaken"}, "media_type in (1, 3)", null, "_data asc");
            if (cursorQuery != null) {
                try {
                    int columnIndex = cursorQuery.getColumnIndex("_data");
                    while (cursorQuery.moveToNext()) {
                        m58039G();
                        String string = cursorQuery.getString(columnIndex);
                        if (!TextUtils.isEmpty(string)) {
                            File fileM63442h = C10278a.m63442h(string);
                            for (String str : listQueryBackupAlbumsPath) {
                                if (!File.separator.equals(str) || !listAsList.contains(fileM63442h.getParent())) {
                                    String parent = fileM63442h.getParent();
                                    Objects.requireNonNull(parent);
                                    if (parent.endsWith(str)) {
                                    }
                                }
                                map.put(string, cursorQuery.getString(cursorQuery.getColumnIndex("datetaken")));
                            }
                        }
                    }
                } catch (Throwable th2) {
                    try {
                        cursorQuery.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Exception e10) {
            C11839m.m70689w("CloudBackupV3ModuleScan", "buildGalleryMetas scan media database error. " + e10.getMessage());
        }
        long j10 = 0;
        this.f46388e.mo29437t0(0L).mo29440u0(map.size());
        for (Map.Entry entry : map.entrySet()) {
            m58039G();
            String str2 = (String) entry.getKey();
            String str3 = (String) entry.getValue();
            try {
                File fileM63442h2 = C10278a.m63442h(str2);
                if (m58078p(fileM63442h2)) {
                    C11839m.m70688i("CloudBackupV3ModuleScan", "path: " + str2 + " is not exists");
                } else {
                    C12161c c12161cM58082t = m58082t(fileM63442h2, j10, true);
                    c12161cM58082t.m72977d0(C0241z.m1688f(str3));
                    m58039G();
                    this.f46397n.m75562a(c12161cM58082t, this.f46386c, false, this.f46385b);
                    j10 += 2;
                }
            } catch (C9721b e11) {
                if (e11.m60659c() != 1011) {
                    throw e11;
                }
                C11839m.m70689w("CloudBackupV3ModuleScan", "no longer backup this file because get file hash error, file = " + str2);
            }
        }
        m58069h(this.f46387d, m58072j(j10));
        m58039G();
        this.f46397n.m75562a(null, this.f46386c, true, this.f46385b);
    }

    /* renamed from: j */
    public final long m58072j(long j10) throws InterruptedException, C9721b, PackageManager.NameNotFoundException {
        List<String> listM75490b = C12543c1.m75490b(this.f46384a.isRefurbishment(), this.f46384a.mo29591n(), this.f46388e.m29861N());
        if (listM75490b.isEmpty()) {
            C11839m.m70688i("CloudBackupV3ModuleScan", "hide album hiddenAlbumPath not exist");
            return j10;
        }
        long jM58056Y = m58056Y(listM75490b, this.f46388e, j10, true);
        C11839m.m70688i("CloudBackupV3ModuleScan", "hide album scan3rdAppDataFiles left = " + jM58056Y);
        return jM58056Y;
    }

    /* renamed from: k */
    public final void m58073k(CloudBackupStatus cloudBackupStatus, CloudBackupAppDataUtil cloudBackupAppDataUtil) throws Throwable {
        ICBUtil.checkDataLocalLimitSpace("build module snapshot v3 tree, left space: ");
        if (HNConstants.DataType.MEDIA.equals(this.f46387d)) {
            m58071i();
            return;
        }
        if ("music".equals(this.f46387d)) {
            m58074l();
            return;
        }
        if ("virtual.sync.switch.status".equals(this.f46387d)) {
            m58076n();
            return;
        }
        if (cloudBackupStatus.m29866T()) {
            m58077o(cloudBackupStatus);
            return;
        }
        if (!cloudBackupStatus.m29867U()) {
            m58061d(cloudBackupStatus, cloudBackupAppDataUtil);
            return;
        }
        this.f46396m.m76008h(this.f46387d, this.f46386c, cloudBackupStatus.m29861N());
        cloudBackupStatus.m29423n2(0L);
        cloudBackupStatus.mo29446w0(m58038F(this.f46387d, cloudBackupStatus.mo29421n(), cloudBackupStatus.m29861N(), cloudBackupAppDataUtil)).mo29443v0(0L);
        m58075m(cloudBackupStatus, cloudBackupAppDataUtil, 0L);
    }

    /* renamed from: l */
    public final void m58074l() throws InterruptedException, C9721b {
        m58039G();
        this.f46396m.m76009i(this.f46387d, this.f46386c, this.f46388e.m29861N(), (this.f46384a.isRefurbishment() || this.f46384a.mo29591n()) ? false : true);
        List<C12582p1.a> listM75632p = new C12582p1(this.f46391h, m58034B()).m75632p();
        if (listM75632p == null || listM75632p.isEmpty()) {
            C11839m.m70689w("CloudBackupV3ModuleScan", "buildMusicMetas: no music data need to backup.");
            return;
        }
        long j10 = 0;
        this.f46388e.mo29437t0(0L).mo29440u0(listM75632p.size());
        for (C12582p1.a aVar : listM75632p) {
            m58039G();
            String strM75644b = aVar.m75644b();
            try {
                C12161c c12161cM58082t = m58082t(C10278a.m63442h(strM75644b), j10, true);
                m58039G();
                this.f46397n.m75562a(c12161cM58082t, this.f46386c, false, this.f46385b);
                j10 += 2;
            } catch (C9721b unused) {
                C11839m.m70687e("CloudBackupV3ModuleScan", "getMusicSnapshotBackupMetas get file md5 and hash error fPath = " + strM75644b);
            }
        }
        m58039G();
        this.f46397n.m75562a(null, this.f46386c, true, this.f46385b);
    }

    /* renamed from: m */
    public void m58075m(CloudBackupStatus cloudBackupStatus, CloudBackupAppDataUtil cloudBackupAppDataUtil, long j10) throws C9721b {
        m58039G();
        this.f46394k = this.f46388e.m29419m1() && this.f46388e.m29425o1();
        if (System.currentTimeMillis() - cloudBackupStatus.m29402f1() >= this.f46395l.m75410o0(this.f46384a.isAutoBackup())) {
            this.f46396m.m76011k(this.f46387d, this.f46386c, this.f46388e.m29861N());
            List<String> listM58087y = m58087y(this.f46387d, cloudBackupAppDataUtil);
            m58064e0(j10);
            m58059b0(listM58087y, this.f46387d, false, cloudBackupStatus, j10);
            m58060c0(cloudBackupStatus, j10, m58085w(this.f46387d, cloudBackupAppDataUtil));
            this.f46388e.m29423n2(System.currentTimeMillis());
            this.f46398o.m76934m(this.f46388e);
            long jM29883s = this.f46392i - this.f46388e.m29883s();
            if (jM29883s < 0) {
                jM29883s = 0;
            }
            this.f46388e.mo29443v0(jM29883s);
            this.f46388e.mo29446w0(jM29883s);
            C11963c.m71970y(this.f46388e, this.f46384a.m29713i0());
        }
    }

    /* renamed from: n */
    public final void m58076n() throws Throwable {
        m58039G();
        this.f46396m.m76009i(this.f46387d, this.f46386c, this.f46388e.m29861N(), (this.f46384a.isRefurbishment() || this.f46384a.mo29591n()) ? false : true);
        C11839m.m70689w("CloudBackupV3ModuleScan", "buildSyncSwitchMetas start");
        Map<String, Integer> mapM76030f = C12597u1.m76030f();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, Integer> entry : mapM76030f.entrySet()) {
            arrayList.add(new SyncSwitchStatus(entry.getKey(), entry.getValue().intValue()));
        }
        try {
            String json = new Gson().toJson(arrayList);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f46391h);
            String str = File.separator;
            sb2.append(str);
            sb2.append(this.f46387d);
            sb2.append(str);
            sb2.append("syncswitchstatus.json");
            File fileM63442h = C10278a.m63442h(sb2.toString());
            File parentFile = fileM63442h.getParentFile();
            if (!parentFile.exists() && !parentFile.mkdirs()) {
                C11839m.m70689w("CloudBackupV3ModuleScan", "buildSyncSwitchMetas make parent dirs error");
            }
            if (fileM63442h.exists() && !fileM63442h.delete()) {
                C11839m.m70689w("CloudBackupV3ModuleScan", "buildSyncSwitchMetas switchStatusFile delete error: " + fileM63442h.getName());
                throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "buildSyncSwitchMetas switchStatusFile delete error" + fileM63442h.getName());
            }
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    if (!fileM63442h.createNewFile()) {
                        C11839m.m70687e("CloudBackupV3ModuleScan", "generate switchStatusFile error");
                        throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "generate switchStatusFile error");
                    }
                    FileOutputStream fileOutputStream2 = new FileOutputStream(fileM63442h);
                    try {
                        C11839m.m70688i("CloudBackupV3ModuleScan", "generate switchStatusFile: " + json);
                        fileOutputStream2.write(json.getBytes(Constants.UTF_8));
                        C0209d.m1263i(fileOutputStream2);
                        C12161c c12161cM58082t = m58082t(fileM63442h, 0L, true);
                        m58039G();
                        this.f46397n.m75562a(c12161cM58082t, this.f46386c, true, this.f46385b);
                        C11839m.m70689w("CloudBackupV3ModuleScan", "buildSyncSwitchMetas end");
                    } catch (FileNotFoundException e10) {
                        e = e10;
                        throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "buildSyncSwitchMetas FileNotFoundException" + e.getMessage());
                    } catch (IOException e11) {
                        e = e11;
                        throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "buildSyncSwitchMetas IOException: " + e.getMessage());
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream = fileOutputStream2;
                        C0209d.m1263i(fileOutputStream);
                        throw th;
                    }
                } catch (FileNotFoundException e12) {
                    e = e12;
                } catch (IOException e13) {
                    e = e13;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e14) {
            C11839m.m70687e("CloudBackupV3ModuleScan", "getSyncSwitchStatus err : " + e14.getMessage());
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "buildSyncSwitchMetas error" + e14.getMessage() + " stack: " + C12590s0.m75731C0(e14));
        }
    }

    /* renamed from: o */
    public final void m58077o(CloudBackupStatus cloudBackupStatus) throws InterruptedException, C9721b, PackageManager.NameNotFoundException {
        m58039G();
        this.f46396m.m76009i(this.f46387d, this.f46386c, cloudBackupStatus.m29861N(), !C12590s0.m75841d1(this.f46387d, this.f46384a.mo29591n()));
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f46391h);
        String str = File.separator;
        sb2.append(str);
        sb2.append(this.f46387d);
        String string = sb2.toString();
        File fileM63442h = C10278a.m63442h(C10279b.m63452a(m58034B().getDir("medaicache", 0)) + str + this.f46387d);
        if (fileM63442h.exists() && !fileM63442h.renameTo(C10278a.m63443i(string, this.f46387d))) {
            C11839m.m70689w("CloudBackupV3ModuleScan", "temp file rename fail!");
        }
        cloudBackupStatus.mo29437t0(0L).mo29440u0(cloudBackupStatus.m29881q());
        m58036D(cloudBackupStatus, C10278a.m63442h(string), 0L, true, false);
        m58039G();
        this.f46397n.m75562a(null, this.f46386c, true, this.f46385b);
    }

    /* renamed from: p */
    public final boolean m58078p(File file) {
        return file == null || !file.exists() || file.length() <= 0;
    }

    /* renamed from: q */
    public final boolean m58079q(File[] fileArr) {
        return fileArr == null || fileArr.length == 0;
    }

    /* renamed from: r */
    public final boolean m58080r(File file, String str) throws C9721b {
        if (this.f46388e.m29866T()) {
            return false;
        }
        String strM63452a = C10279b.m63452a(file);
        if (!TextUtils.isEmpty(file.getName())) {
            return false;
        }
        C11839m.m70686d("CloudBackupV3ModuleScan", "checkFname fname is empty: " + strM63452a);
        if (strM63452a == null || !strM63452a.startsWith(m58035C(str))) {
            return true;
        }
        throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "checkFname fname is emtpty: " + strM63452a);
    }

    /* renamed from: s */
    public final void m58081s(String str, String str2) throws C9721b {
        if (this.f46388e.m29863P() && m58040H(str) && str2 != null && str2.startsWith(ICBUtil.RELATIVE_SDATA_PATH)) {
            C12160b c12160b = new C12160b(this.f46386c, this.f46387d, 0, this.f46388e.m29861N());
            if (c12160b.m72937h()) {
                return;
            }
            c12160b.m72931b();
            m58052U("module_reset_from_has_old_diff_file");
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "checkOldDiffDbFile has old diffdb reset module");
        }
    }

    /* renamed from: t */
    public final C12161c m58082t(File file, long j10, boolean z10) throws C9721b {
        C12161c c12161c = new C12161c();
        c12161c.m72956L(this.f46387d);
        c12161c.m72957M(this.f46388e.m29871e());
        c12161c.m72998o0(0);
        String strM75797S2 = C12590s0.m75797S2(this.f46387d, this.f46388e.mo29421n(), this.f46388e.m29861N(), C10279b.m63452a(file), this.f46388e.m29345E0());
        String strM75665a = C12583q.m75665a(strM75797S2, 0, this.f46388e.m29861N());
        String strM75648B = C12583q.m75648B(strM75665a);
        if (ICBUtil.hasEmojiCharacter(strM75665a)) {
            c12161c.m72959O(1L);
            strM75665a = ICBUtil.getEncodedPath(strM75665a);
        }
        c12161c.m72994m0(strM75648B);
        c12161c.m72964T(strM75665a.substring(strM75648B.length()));
        String strTrim = file.getName().trim();
        if (TextUtils.isEmpty(strTrim)) {
            strTrim = file.getName();
        }
        if (ICBUtil.hasEmojiCharacter(strTrim) || ICBUtil.checkFileName(strTrim)) {
            strTrim = C11476b.m68626h(strTrim);
        }
        m58081s(strTrim, strM75648B);
        c12161c.m72990k0(strTrim);
        c12161c.m72975c0(file.lastModified());
        c12161c.m72971a0(System.currentTimeMillis());
        c12161c.m72988j0(j10);
        c12161c.m72992l0(j10 + 1);
        if (file.exists()) {
            if (file.isFile()) {
                m58068g0(file.length());
                c12161c.m73000p0(6L);
                c12161c.m72996n0(file.length());
                c12161c.m72962R(file.length());
                if (z10) {
                    this.f46396m.m75991A(C10278a.m63442h(strM75797S2), file, c12161c, this.f46391h, this.f46388e.m29861N());
                }
            } else {
                c12161c.m73000p0(5L);
            }
        }
        return c12161c;
    }

    /* renamed from: u */
    public final boolean m58083u(File file, List<File> list, List<File> list2) {
        File[] fileArrM63440f = C10278a.m63440f(file);
        if (m58079q(fileArrM63440f)) {
            return false;
        }
        for (File file2 : fileArrM63440f) {
            String strM75797S2 = C12590s0.m75797S2(this.f46387d, this.f46388e.mo29421n(), this.f46388e.m29861N(), C10279b.m63452a(file2), this.f46388e.m29345E0());
            CloudBackupAppDataUtil cloudBackupAppDataUtil = this.f46389f;
            if (cloudBackupAppDataUtil != null && cloudBackupAppDataUtil.isFilterFile(C10278a.m63442h(strM75797S2))) {
                C11839m.m70686d("CloudBackupV3ModuleScan", "filter file = " + strM75797S2);
            } else if (file2.exists()) {
                if (file2.isFile()) {
                    list.add(file2);
                } else {
                    list2.add(file2);
                }
            }
        }
        return true;
    }

    /* renamed from: v */
    public final void m58084v(List<String> list, String str) throws Throwable {
        File fileM63442h = C10278a.m63442h(C12583q.m75656J(str, this.f46388e.m29861N()) + "/filter.txt");
        if (fileM63442h.exists() && !fileM63442h.delete()) {
            C11839m.m70687e("CloudBackupV3ModuleScan", "generatePmsByFile delete android data byfile error: " + fileM63442h.getName());
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "delete android data cache brief file error");
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                if (!fileM63442h.createNewFile()) {
                    C11839m.m70687e("CloudBackupV3ModuleScan", "generate android data byfile error");
                    throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "generate android data byfile error");
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(fileM63442h);
                try {
                    for (String str2 : list) {
                        C11839m.m70688i("CloudBackupV3ModuleScan", "generatePmsByFile android data includePath: " + str2);
                        fileOutputStream2.write(("[include]" + str2 + "\n").getBytes(Constants.UTF_8));
                    }
                    ScanAppDataUtil scanAppDataUtil = this.f46390g;
                    if (scanAppDataUtil != null) {
                        Iterator<String> it = scanAppDataUtil.getExcludeAndroidDataPathWithoutRegex(str).iterator();
                        while (it.hasNext()) {
                            String strSplitAppDestAndroidDataPathToWritePath = SplitAppUtil.splitAppDestAndroidDataPathToWritePath(it.next(), this.f46388e.m29861N());
                            C11839m.m70688i("CloudBackupV3ModuleScan", "v3 generatePmsByFile excludePath: " + strSplitAppDestAndroidDataPathToWritePath);
                            fileOutputStream2.write(("[exclude]" + strSplitAppDestAndroidDataPathToWritePath + "\n").getBytes(Constants.UTF_8));
                        }
                    }
                    C0209d.m1263i(fileOutputStream2);
                } catch (FileNotFoundException unused) {
                    throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "generatePmsByFile FileNotFoundException");
                } catch (IOException e10) {
                    e = e10;
                    throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "generatePmsByFile IOException: " + e.getMessage());
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = fileOutputStream2;
                    C0209d.m1263i(fileOutputStream);
                    throw th;
                }
            } catch (FileNotFoundException unused2) {
            } catch (IOException e11) {
                e = e11;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* renamed from: w */
    public final List<String> m58085w(String str, CloudBackupAppDataUtil cloudBackupAppDataUtil) throws C9721b {
        ArrayList arrayList = new ArrayList();
        if (!this.f46394k) {
            return arrayList;
        }
        arrayList.addAll(new ScanAppDataUtil(str, this.f46388e.m29861N(), this.f46388e.mo29421n(), cloudBackupAppDataUtil.getmCloudBackupInclude(), cloudBackupAppDataUtil.getmCloudBackupExclude()).getAndroidDataPaths(this.f46388e.m29861N()));
        return arrayList;
    }

    /* renamed from: x */
    public final List<String> m58086x(String str) {
        ArrayList arrayList = new ArrayList();
        if (!this.f46394k) {
            return arrayList;
        }
        String strM58035C = m58035C(str);
        File fileM63442h = C10278a.m63442h(strM58035C);
        if (!fileM63442h.exists() && !fileM63442h.mkdirs()) {
            C11839m.m70688i("CloudBackupV3ModuleScan", "get3rdAppDataPaths mkdir error, path: " + fileM63442h);
        }
        arrayList.add(strM58035C);
        return arrayList;
    }

    /* renamed from: y */
    public final List<String> m58087y(String str, CloudBackupAppDataUtil cloudBackupAppDataUtil) throws C9721b {
        ArrayList arrayList = new ArrayList();
        if (!this.f46394k) {
            return arrayList;
        }
        arrayList.addAll(new ScanAppDataUtil(str, this.f46388e.m29861N(), this.f46388e.mo29421n(), cloudBackupAppDataUtil.getmCloudBackupInclude(), cloudBackupAppDataUtil.getmCloudBackupExclude()).getSdcardPaths(this.f46388e.m29861N()));
        return arrayList;
    }

    /* renamed from: z */
    public final void m58088z(CloudBackupStatus cloudBackupStatus, String str) throws C9721b, PackageManager.NameNotFoundException {
        if (str == null) {
            BackupCacheRecord.delete(m58034B(), this.f46387d);
            m58070h0(cloudBackupStatus);
            throw new C9721b(1009, "get package info path is null.");
        }
        String strMo29421n = cloudBackupStatus.mo29421n();
        C11839m.m70688i("CloudBackupV3ModuleScan", "get3rdExtend begin, appId = " + this.f46387d + ", uid: " + cloudBackupStatus.m29861N());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(ICBUtil.getBundleBackupDirPath(this.f46391h, this.f46387d));
        String str2 = File.separator;
        sb2.append(str2);
        String string = sb2.toString();
        String str3 = ICBUtil.getHarmonyBackupDirPath(this.f46391h, this.f46387d) + str2;
        boolean zStartsWith = str.startsWith(string);
        boolean zStartsWith2 = str.startsWith(str3);
        PackageManager packageManager = m58034B().getPackageManager();
        try {
            C11839m.m70688i("CloudBackupV3ModuleScan", "get packageInfo");
            PackageInfo packageInfo = packageManager.getPackageInfo(strMo29421n, 16384);
            String splitAppName = SplitAppUtil.getSplitAppName(packageInfo.applicationInfo.loadLabel(packageManager).toString(), cloudBackupStatus.mo29357K());
            String str4 = packageInfo.versionName;
            long longVersionCode = PackageInfoCompat.getLongVersionCode(packageInfo);
            cloudBackupStatus.mo29316a0(splitAppName).m29447w1(str4).m29439t2(String.valueOf(longVersionCode));
            cloudBackupStatus.m29363M1(String.valueOf(zStartsWith ? 1 : zStartsWith2 ? 2 : 0));
            String locationIconFilePath = ICBUtil.getLocationIconFilePath(this.f46391h, this.f46387d);
            C11839m.m70688i("CloudBackupV3ModuleScan", "get icon file from packageInfo");
            BackupOptionItem backupOptionItemM78401y = this.f46384a.m29722l0().mo1759d().m78401y(this.f46387d);
            ICBUtil.drawable2File((backupOptionItemM78401y == null || !String.valueOf(longVersionCode).equals(backupOptionItemM78401y.getData4())) ? packageInfo.applicationInfo.loadIcon(packageManager) : CloudBackup3rdIconUtil.get3rdDrawable2(strMo29421n), locationIconFilePath);
            File fileM63442h = C10278a.m63442h(str);
            String strM58037E = m58037E(fileM63442h, zStartsWith, zStartsWith2);
            String strM75458d = C12535a.m75458d(strMo29421n);
            C11839m.m70688i("CloudBackupV3ModuleScan", "build apk attach appId: " + strMo29421n + "version: " + longVersionCode + " ,metaHash: " + strM58037E + " ,appSSha2: " + strM75458d);
            m58063e(fileM63442h, strM75458d, "apk", strM58037E, cloudBackupStatus.m29861N());
            cloudBackupStatus.mo29321d0(fileM63442h.length());
            File fileM63442h2 = C10278a.m63442h(locationIconFilePath);
            if (fileM63442h2.exists()) {
                C11839m.m70688i("CloudBackupV3ModuleScan", "build icon attach");
                m58063e(fileM63442h2, "", "icon", strM58037E, cloudBackupStatus.m29861N());
            }
            this.f46398o.m76934m(cloudBackupStatus);
            HashMap map = new HashMap();
            if (C12590s0.m75778O(cloudBackupStatus) == 2 && C12565k.m75528n(strMo29421n)) {
                String strValueOf = String.valueOf(1);
                String strM75516b = C12565k.m75516b(strMo29421n, true);
                map.put("ohosArk", strValueOf);
                map.put("ohosArkVersion", strM75516b);
                C11839m.m70688i("CloudBackupV3ModuleScan", "get ohosFlag:" + strValueOf + ", arkVersion:" + strM75516b);
            }
            String installerPackageName = "";
            try {
                installerPackageName = packageManager.getInstallerPackageName(strMo29421n);
            } catch (IllegalArgumentException unused) {
                C11839m.m70687e("CloudBackupV3ModuleScan", "getInstallerPackageName IllegalArgumentException");
            }
            String pkgChannelId = QueryAppMarketDataUtil.getPkgChannelId(m58034B(), strMo29421n);
            C11839m.m70688i("CloudBackupV3ModuleScan", "get subSource: " + installerPackageName + ", pkgChannelId: " + pkgChannelId);
            map.put(CloudBackupConstant.ReportAppMarket.KEY_SUB_SOURCE, installerPackageName);
            map.put(CloudBackupConstant.ReportAppMarket.KEY_PKG_CHANNEL_ID, pkgChannelId);
            map.put("backupApkVersion", String.valueOf(longVersionCode));
            cloudBackupStatus.m29346E1(new Gson().toJson(map));
            C11839m.m70688i("CloudBackupV3ModuleScan", "get3rdExtend end, appId = " + this.f46387d + ", uid: " + cloudBackupStatus.m29861N());
        } catch (PackageManager.NameNotFoundException | RuntimeException unused2) {
            C11839m.m70689w("CloudBackupV3ModuleScan", "name not fount. appId = " + this.f46387d + ", uid: " + cloudBackupStatus.m29861N());
            throw new C9721b(1998, "package name not found, appId =" + this.f46387d + ", uid: " + cloudBackupStatus.m29861N(), "get3rdExtend");
        }
    }
}
