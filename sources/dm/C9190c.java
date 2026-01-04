package dm;

import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.hicloud.cloudbackup.p104v3.core.C4879a;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudBackupStatus;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.manager.HicloudH5ConfigManager;
import com.huawei.hms.identity.AddressConstants;
import com.huawei.openalliance.p169ad.p171db.bean.ContentResource;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import fk.C9721b;
import hk.C10278a;
import hk.C10279b;
import hm.C10321z;
import im.AbstractC10548b;
import im.C10546a;
import im.C10560j;
import im.C10563m;
import im.InterfaceC10551c0;
import im.InterfaceC10570t;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;
import mk.C11476b;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0213f;
import p015ak.C0226l0;
import p015ak.C0227m;
import p455ll.C11308a;
import p495nm.C11730k;
import p514o9.C11835i;
import p514o9.C11839m;
import p618rm.C12571m;
import p618rm.C12583q;
import p618rm.C12590s0;
import p848zl.C14337f;
import pl.C12159a;
import pl.C12160b;
import pl.C12161c;
import pl.C12164f;

/* renamed from: dm.c */
/* loaded from: classes6.dex */
public class C9190c {

    /* renamed from: L */
    public static final ReentrantLock f46077L = new ReentrantLock(true);

    /* renamed from: C */
    public C11730k f46080C;

    /* renamed from: E */
    public long f46082E;

    /* renamed from: F */
    public final String f46083F;

    /* renamed from: G */
    public final long f46084G;

    /* renamed from: H */
    public final InterfaceC10570t f46085H;

    /* renamed from: I */
    public String f46086I;

    /* renamed from: J */
    public String f46087J;

    /* renamed from: K */
    public final b f46088K;

    /* renamed from: a */
    public final String f46089a;

    /* renamed from: b */
    public C12160b f46090b;

    /* renamed from: c */
    public C12160b f46091c;

    /* renamed from: d */
    public C12164f f46092d;

    /* renamed from: e */
    public C4879a f46093e;

    /* renamed from: f */
    public long f46094f;

    /* renamed from: g */
    public String f46095g;

    /* renamed from: h */
    public String f46096h;

    /* renamed from: i */
    public String f46097i;

    /* renamed from: j */
    public String f46098j;

    /* renamed from: k */
    public String f46099k;

    /* renamed from: l */
    public int f46100l;

    /* renamed from: m */
    public C10560j f46101m;

    /* renamed from: p */
    public InterfaceC9213h2 f46104p;

    /* renamed from: q */
    public File f46105q;

    /* renamed from: r */
    public File f46106r;

    /* renamed from: s */
    public File f46107s;

    /* renamed from: t */
    public final String f46108t;

    /* renamed from: u */
    public C10563m f46109u;

    /* renamed from: v */
    public AbstractC10548b f46110v;

    /* renamed from: w */
    public final int f46111w;

    /* renamed from: n */
    public boolean f46102n = false;

    /* renamed from: o */
    public boolean f46103o = false;

    /* renamed from: x */
    public List<C12159a> f46112x = new ArrayList();

    /* renamed from: y */
    public String f46113y = "";

    /* renamed from: z */
    public String f46114z = "";

    /* renamed from: A */
    public int f46078A = 0;

    /* renamed from: B */
    public int f46079B = 0;

    /* renamed from: D */
    public final Map<String, String> f46081D = new HashMap();

    /* renamed from: dm.c$b */
    public static class b {

        /* renamed from: a */
        public String f46115a;

        /* renamed from: b */
        public String f46116b;

        /* renamed from: c */
        public String f46117c;

        /* renamed from: d */
        public long f46118d;

        /* renamed from: e */
        public long f46119e;

        public b() {
            this.f46115a = "";
            this.f46116b = "";
            this.f46117c = "";
            this.f46118d = 0L;
            this.f46119e = 0L;
        }

        public String toString() {
            return "DifferenceDebug{divideHash='" + this.f46115a + "', beforeHash='" + this.f46116b + "', afterHash='" + this.f46117c + "', beforeModified=" + this.f46118d + ", afterModified=" + this.f46119e + '}';
        }
    }

    public C9190c(C4879a c4879a, String str, CloudBackupStatus cloudBackupStatus, String str2, InterfaceC9213h2 interfaceC9213h2, String str3, String str4, String str5, long j10, InterfaceC10570t interfaceC10570t, long j11) {
        String strM29870d = cloudBackupStatus.m29870d();
        int iM29861N = cloudBackupStatus.m29861N();
        this.f46099k = cloudBackupStatus.mo29421n();
        this.f46089a = cloudBackupStatus.m29345E0();
        this.f46093e = c4879a;
        this.f46087J = cloudBackupStatus.mo29357K();
        this.f46094f = j11;
        this.f46090b = new C12160b(str, strM29870d, 0, iM29861N, true);
        this.f46104p = interfaceC9213h2;
        this.f46108t = str3;
        this.f46096h = str2;
        this.f46095g = str;
        this.f46098j = strM29870d;
        this.f46100l = iM29861N;
        this.f46097i = str4;
        C11730k c11730kM29746t0 = c4879a.m29746t0();
        this.f46080C = c11730kM29746t0;
        this.f46111w = c11730kM29746t0.m69994e();
        this.f46083F = str5;
        this.f46084G = j10;
        if (!TextUtils.isEmpty(str2)) {
            this.f46091c = new C12160b(str2, strM29870d, 0, iM29861N);
            this.f46092d = new C12164f(str2, strM29870d, 0, iM29861N);
        }
        this.f46085H = interfaceC10570t;
        this.f46088K = new b();
    }

    /* renamed from: A */
    public void m57706A() {
        try {
            m57707B();
        } catch (Exception e10) {
            C11839m.m70687e("CloudBackupV3FileDifference", "reportDiffError: " + e10.getMessage());
        }
    }

    /* renamed from: B */
    public final void m57707B() {
        this.f46081D.put("traceId", this.f46097i);
        this.f46081D.put("appId", this.f46098j);
        this.f46081D.put("uid", String.valueOf(this.f46100l));
        this.f46081D.put(ContentResource.FILE_NAME, this.f46104p.getName());
        this.f46081D.put("fileDiffTime", String.valueOf(System.currentTimeMillis() - this.f46082E));
        this.f46081D.put("diffPackNum", String.valueOf(this.f46079B));
        this.f46081D.put("diffFrom", this.f46083F);
        this.f46081D.put("originFileHash", this.f46108t);
        this.f46081D.put("isDBDiffAbout", String.valueOf(this.f46093e.m29701e0()));
        this.f46081D.put("isSuccess", String.valueOf(this.f46102n));
        C12590s0.m75741E2(this.f46097i, this.f46086I, this.f46081D);
    }

    /* renamed from: C */
    public final C11308a m57708C(int i10, File file, String str, String str2) throws InterruptedException, C9721b {
        m57725s();
        String strM63452a = C10279b.m63452a(file);
        C11839m.m70688i("CloudBackupV3FileDifference", "upload file: " + strM63452a);
        if (!file.exists() || file.length() <= 0) {
            throw new C9721b(FamilyShareConstants.StatusCode.SHARE_SPACE_NOT_ENOUGH, "file not exist, file = " + strM63452a);
        }
        try {
            HashMap map = new HashMap();
            map.put("divideLayers", str2);
            String strM57724r = m57724r(this.f46104p);
            C10321z c10321z = new C10321z(this.f46093e.m29713i0(), this.f46093e.m29636F0(), this.f46093e.m29587j(), CloudBackupConstant.Command.PMS_CMD_BACKUP, this.f46097i);
            c10321z.m63540D0(this.f46093e.m29761y0());
            String str3 = this.f46098j;
            int i11 = this.f46100l;
            String str4 = this.f46097i;
            String strM29719k0 = this.f46093e.m29719k0();
            String str5 = this.f46095g;
            C4879a c4879a = this.f46093e;
            C10563m c10563m = new C10563m(str3, i11, str4, c10321z, strM29719k0, str5, c4879a, file, map, c4879a.m29699d1(), 1, this.f46093e.m29753v1(), str, this.f46112x, strM57724r, this.f46093e.m29713i0(), this.f46087J);
            this.f46109u = c10563m;
            c10563m.m64772V(i10 > 0);
            this.f46109u.m64770T(this.f46085H);
            return this.f46109u.m64763M(i10);
        } catch (C9721b e10) {
            m57725s();
            int i12 = i10 + 1;
            if (i12 > 2 || C14337f.m85500c().contains(Integer.valueOf(e10.m60659c()))) {
                throw e10;
            }
            SystemClock.sleep(500L);
            m57725s();
            C11839m.m70688i("CloudBackupV3FileDifference", "upload file = " + strM63452a + ", retry = " + i12);
            return m57708C(i12, file, str, str2);
        }
    }

    /* renamed from: c */
    public final com.huawei.hicloud.cloudbackup.p104v3.server.model.File m57709c(String str, String str2, String str3, int i10) throws C9721b {
        return new C10321z(this.f46093e.m29713i0(), this.f46093e.m29636F0(), this.f46093e.m29587j(), CloudBackupConstant.Command.PMS_CMD_BACKUP, this.f46097i).m63553P(this.f46093e.m29728n0(), str, str2, str3, i10, 0);
    }

    /* renamed from: d */
    public final String m57710d() {
        HashMap map = new HashMap();
        map.put(HicloudH5ConfigManager.KEY_HASH, this.f46108t);
        map.put("length", String.valueOf(this.f46104p.length()));
        return C12590s0.m75846e2(map);
    }

    /* renamed from: e */
    public final void m57711e(String str) throws JSONException, NumberFormatException {
        if (TextUtils.isEmpty(this.f46096h)) {
            this.f46081D.put("buildDiffPacketMetaMsg", "lastSuccessBakId not exist");
            C11839m.m70688i("CloudBackupV3FileDifference", "lastSuccessBakId not exist");
            return;
        }
        try {
            List<C12161c> arrayList = new ArrayList<>();
            C12164f c12164f = this.f46092d;
            if (c12164f != null) {
                arrayList = c12164f.m73067Z(this.f46104p.getName(), str);
            }
            if (arrayList.isEmpty()) {
                return;
            }
            C11839m.m70686d("CloudBackupV3FileDifference", "fileDifference , lastMetaOperator cloudBackupMetaList not empty");
            String str2 = C12590s0.m75858h2(arrayList.get(0).m73008w()).get("length");
            if (str2 == null) {
                this.f46081D.put("buildDiffPacketMetaMsg", "last length get null");
                C11839m.m70688i("CloudBackupV3FileDifference", "last length get null");
                return;
            }
            if (this.f46104p.length() < Long.parseLong(str2)) {
                this.f46081D.put("buildDiffPacketMetaMsg", "current size is smaller than last");
                C11839m.m70688i("CloudBackupV3FileDifference", "current size is smaller than last");
                return;
            }
            JSONObject jSONObject = new JSONObject();
            C12160b c12160b = this.f46091c;
            if (c12160b != null) {
                this.f46112x = c12160b.m72939j(str, String.valueOf(0));
            }
            for (C12159a c12159a : this.f46112x) {
                if (0 == c12159a.m72872H()) {
                    String strM72925v = c12159a.m72925v();
                    this.f46114z = strM72925v;
                    jSONObject.put("0", strM72925v);
                } else if (2 == c12159a.m72872H()) {
                    this.f46078A++;
                    jSONObject.put(String.valueOf(c12159a.m72929z() + 1), c12159a.m72925v());
                }
            }
            if (this.f46078A < this.f46111w) {
                this.f46113y = jSONObject.toString();
                return;
            }
            this.f46081D.put("buildDiffPacketMetaMsg", "fileDifference , diffPackIndex >= DffPacketNum, first backup");
            C11839m.m70688i("CloudBackupV3FileDifference", "fileDifference , diffPackIndex >= DffPacketNum, first backup");
            this.f46112x.clear();
            this.f46078A = 0;
        } catch (Exception e10) {
            C11839m.m70687e("CloudBackupV3FileDifference", "buildDiffPacketMetaList exception: " + e10.getMessage());
            this.f46081D.put("buildDiffPacketMetaError", e10.getMessage());
            this.f46112x.clear();
            this.f46078A = 0;
            this.f46113y = "";
        }
    }

    /* renamed from: f */
    public void m57712f() {
        C11839m.m70688i("CloudBackupV3FileDifference", "cancel");
        C10560j c10560j = this.f46101m;
        if (c10560j != null) {
            c10560j.mo64711f();
        }
        AbstractC10548b abstractC10548b = this.f46110v;
        if (abstractC10548b != null) {
            abstractC10548b.mo64711f();
        }
        C10563m c10563m = this.f46109u;
        if (c10563m != null) {
            c10563m.mo64711f();
        }
    }

    /* renamed from: g */
    public void m57713g() throws C9721b {
        try {
            C11839m.m70688i("CloudBackupV3FileDifference", "checkDiffPackets");
            for (C12159a c12159a : this.f46112x) {
                int fileStatus = m57709c(this.f46093e.m29719k0(), c12159a.m72925v(), "id,sha256,fileStatus", 1).getFileStatus();
                if (fileStatus == 2 || fileStatus == 3) {
                    throw new C9721b(3911, "checkDiffPackets lost file = " + c12159a.m72925v() + " fileStatus = " + fileStatus);
                }
            }
        } catch (C9721b e10) {
            C11839m.m70687e("CloudBackupV3FileDifference", "checkDiffPackets fail");
            this.f46081D.put("dBDiffErrorReason", e10.getMessage());
            this.f46081D.put(AddressConstants.Extras.EXTRA_NAME_ERR_CODE, String.valueOf(e10.m60659c()));
            this.f46112x.clear();
        }
    }

    /* renamed from: h */
    public final C12159a m57714h(InterfaceC9213h2 interfaceC9213h2, long j10) throws C9721b {
        C12159a c12159a = new C12159a();
        c12159a.m72874J(this.f46098j);
        c12159a.m72914m0(0);
        String strM75665a = C12583q.m75665a(C12590s0.m75797S2(this.f46098j, this.f46099k, this.f46100l, interfaceC9213h2.mo57844e0(), this.f46089a), 0, this.f46100l);
        String strM75648B = C12583q.m75648B(strM75665a);
        if (ICBUtil.hasEmojiCharacter(strM75665a)) {
            c12159a.m72877M(1L);
            strM75665a = ICBUtil.getEncodedPath(strM75665a);
        }
        c12159a.m72906i0(strM75648B);
        c12159a.m72880P(strM75665a.substring(strM75648B.length()));
        String strTrim = interfaceC9213h2.getName().trim();
        if (ICBUtil.hasEmojiCharacter(strTrim) || ICBUtil.checkFileName(strTrim)) {
            strTrim = C11476b.m68626h(strTrim);
        }
        c12159a.m72905h0(strTrim);
        c12159a.m72887W(System.currentTimeMillis());
        c12159a.m72916n0(j10);
        long length = interfaceC9213h2.length();
        c12159a.m72908j0(length);
        c12159a.m72879O(length);
        if (0 == j10) {
            c12159a.m72878N(this.f46108t);
            c12159a.m72889Y(this.f46084G);
            c12159a.m72891a0(m57710d());
        } else {
            c12159a.m72889Y(interfaceC9213h2.mo57847p0());
        }
        c12159a.m72910k0(m57724r(this.f46104p));
        c12159a.m72912l0(this.f46108t);
        c12159a.m72876L(this.f46095g);
        return c12159a;
    }

    /* renamed from: i */
    public final void m57715i(File file) {
        if (file == null) {
            C11839m.m70687e("CloudBackupV3FileDifference", "deleteDiffMetaByData file is null");
            return;
        }
        String strM75665a = C12583q.m75665a(C12590s0.m75797S2(this.f46098j, this.f46099k, this.f46100l, C10279b.m63452a(file), this.f46089a), 0, this.f46100l);
        String strM75648B = C12583q.m75648B(strM75665a);
        if (ICBUtil.hasEmojiCharacter(strM75665a)) {
            strM75665a = ICBUtil.getEncodedPath(strM75665a);
        }
        try {
            new C12160b(this.f46095g, this.f46098j, 0, this.f46100l).m72934e(strM75665a.substring(strM75648B.length()));
        } catch (C9721b unused) {
            C11839m.m70687e("CloudBackupV3FileDifference", "deleteMetasByData error");
        }
    }

    /* renamed from: j */
    public final void m57716j(C12159a c12159a, final String str, long j10) throws C9721b {
        C12590s0.m75845e1(str, j10, m57721o());
        try {
            if (1 == c12159a.m72926w()) {
                final String strM72896d = c12159a.m72896d();
                final String strM72925v = c12159a.m72925v();
                final String strM72873I = c12159a.m72873I();
                final String strM29713i0 = this.f46093e.m29713i0();
                C10546a.m64704a(new C10546a.a() { // from class: dm.b
                    @Override // im.C10546a.a
                    /* renamed from: a */
                    public final InterfaceC10551c0 mo1696a() {
                        return this.f46063a.m57726t(str, strM29713i0, strM72896d, strM72925v, strM72873I);
                    }
                }).m64705b();
            }
        } catch (C9721b e10) {
            C12590s0.m75845e1(str, j10, m57721o());
            throw e10;
        }
    }

    /* renamed from: k */
    public final File m57717k(C12159a c12159a, String str, String str2) throws C9721b {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(m57721o());
        String str3 = File.separator;
        sb2.append(str3);
        sb2.append(str2);
        String string = sb2.toString();
        File fileM63442h = C10278a.m63442h(string);
        if (fileM63442h.exists() && !fileM63442h.delete()) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "downloadV3DifferencePacketFiles, tempFile delete file error");
        }
        m57716j(c12159a, string, c12159a.m72868D());
        C11839m.m70688i("CloudBackupV3FileDifference", "downloadV3DifferencePacketFiles, file download success, name = " + str2);
        File fileM63442h2 = C10278a.m63442h(str + str3 + str2);
        if (fileM63442h2.exists() && !fileM63442h2.delete()) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "downloadV3DifferencePacketFiles, delete file error");
        }
        File fileM63442h3 = C10278a.m63442h(str);
        if (!fileM63442h3.exists() && !fileM63442h3.mkdirs()) {
            C11839m.m70689w("CloudBackupV3FileDifference", "mkdirs error, baseDir = " + str);
        }
        if (C11835i.m70654r(fileM63442h, fileM63442h2)) {
            return fileM63442h2;
        }
        throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "downloadV3DifferencePacketFiles, snapFile rename error");
    }

    /* renamed from: l */
    public boolean m57718l() {
        boolean z10 = true;
        while (true) {
            try {
                try {
                    ReentrantLock reentrantLock = f46077L;
                    if (reentrantLock.tryLock()) {
                        boolean zM57720n = m57720n();
                        reentrantLock.unlock();
                        return zM57720n;
                    }
                    m57725s();
                    C0226l0.m1581a(300L);
                    if (z10) {
                        C11839m.m70688i("CloudBackupV3FileDifference", "another fileDifference is running");
                        z10 = false;
                    }
                } catch (C9721b e10) {
                    C11839m.m70687e("CloudBackupV3FileDifference", e10.getMessage());
                    this.f46081D.put("dBDiffErrorReason", e10.getMessage());
                    this.f46081D.put(AddressConstants.Extras.EXTRA_NAME_ERR_CODE, String.valueOf(e10.m60659c()));
                    this.m57706A();
                    f46077L.unlock();
                    return false;
                }
            } catch (Throwable th2) {
                f46077L.unlock();
                throw th2;
            }
        }
    }

    /* renamed from: m */
    public final void m57719m() {
        try {
            m57707B();
            C10560j c10560j = this.f46101m;
            if (c10560j != null) {
                c10560j.mo64711f();
            }
            AbstractC10548b abstractC10548b = this.f46110v;
            if (abstractC10548b != null) {
                abstractC10548b.mo64711f();
            }
            C10563m c10563m = this.f46109u;
            if (c10563m != null) {
                c10563m.mo64711f();
            }
            File file = this.f46105q;
            if (file != null) {
                this.f46081D.put("printerHashFileSize", String.valueOf(file.length()));
                C12571m.m75547i(C10279b.m63452a(this.f46105q));
            }
            File file2 = this.f46106r;
            if (file2 != null) {
                C12571m.m75547i(C10279b.m63452a(file2));
            }
            File file3 = this.f46107s;
            if (file3 != null) {
                C12571m.m75547i(C10279b.m63452a(file3));
            }
        } catch (Exception e10) {
            C11839m.m70687e("CloudBackupV3FileDifference", "finally: " + e10.getMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0139 A[Catch: all -> 0x00b6, Exception -> 0x00ba, b -> 0x00be, TryCatch #7 {b -> 0x00be, Exception -> 0x00ba, blocks: (B:10:0x009e, B:17:0x00c2, B:19:0x011c, B:21:0x0120, B:23:0x012e, B:24:0x0135, B:26:0x0139, B:28:0x0140, B:30:0x0167, B:31:0x016a, B:33:0x0170, B:35:0x0174, B:37:0x017a, B:40:0x01a9, B:42:0x021e, B:44:0x0234, B:45:0x0279, B:47:0x027b, B:48:0x0281, B:38:0x017e, B:49:0x0282, B:50:0x02ac, B:27:0x013e), top: B:76:0x009e, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x013e A[Catch: all -> 0x00b6, Exception -> 0x00ba, b -> 0x00be, TryCatch #7 {b -> 0x00be, Exception -> 0x00ba, blocks: (B:10:0x009e, B:17:0x00c2, B:19:0x011c, B:21:0x0120, B:23:0x012e, B:24:0x0135, B:26:0x0139, B:28:0x0140, B:30:0x0167, B:31:0x016a, B:33:0x0170, B:35:0x0174, B:37:0x017a, B:40:0x01a9, B:42:0x021e, B:44:0x0234, B:45:0x0279, B:47:0x027b, B:48:0x0281, B:38:0x017e, B:49:0x0282, B:50:0x02ac, B:27:0x013e), top: B:76:0x009e, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0167 A[Catch: all -> 0x00b6, Exception -> 0x00ba, b -> 0x00be, TryCatch #7 {b -> 0x00be, Exception -> 0x00ba, blocks: (B:10:0x009e, B:17:0x00c2, B:19:0x011c, B:21:0x0120, B:23:0x012e, B:24:0x0135, B:26:0x0139, B:28:0x0140, B:30:0x0167, B:31:0x016a, B:33:0x0170, B:35:0x0174, B:37:0x017a, B:40:0x01a9, B:42:0x021e, B:44:0x0234, B:45:0x0279, B:47:0x027b, B:48:0x0281, B:38:0x017e, B:49:0x0282, B:50:0x02ac, B:27:0x013e), top: B:76:0x009e, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0170 A[Catch: all -> 0x00b6, Exception -> 0x00ba, b -> 0x00be, TryCatch #7 {b -> 0x00be, Exception -> 0x00ba, blocks: (B:10:0x009e, B:17:0x00c2, B:19:0x011c, B:21:0x0120, B:23:0x012e, B:24:0x0135, B:26:0x0139, B:28:0x0140, B:30:0x0167, B:31:0x016a, B:33:0x0170, B:35:0x0174, B:37:0x017a, B:40:0x01a9, B:42:0x021e, B:44:0x0234, B:45:0x0279, B:47:0x027b, B:48:0x0281, B:38:0x017e, B:49:0x0282, B:50:0x02ac, B:27:0x013e), top: B:76:0x009e, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0282 A[Catch: all -> 0x00b6, Exception -> 0x00ba, b -> 0x00be, TryCatch #7 {b -> 0x00be, Exception -> 0x00ba, blocks: (B:10:0x009e, B:17:0x00c2, B:19:0x011c, B:21:0x0120, B:23:0x012e, B:24:0x0135, B:26:0x0139, B:28:0x0140, B:30:0x0167, B:31:0x016a, B:33:0x0170, B:35:0x0174, B:37:0x017a, B:40:0x01a9, B:42:0x021e, B:44:0x0234, B:45:0x0279, B:47:0x027b, B:48:0x0281, B:38:0x017e, B:49:0x0282, B:50:0x02ac, B:27:0x013e), top: B:76:0x009e, outer: #2 }] */
    /* renamed from: n */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m57720n() {
        /*
            Method dump skipped, instructions count: 904
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: dm.C9190c.m57720n():boolean");
    }

    /* renamed from: o */
    public final String m57721o() {
        C4879a c4879a = this.f46093e;
        if (c4879a != null) {
            return c4879a.getLocation();
        }
        return C10279b.m63452a(C10278a.m63442h(C0213f.m1377a().getFilesDir() + "/cloudbackup"));
    }

    /* renamed from: p */
    public final File m57722p(List<C12159a> list) throws InterruptedException {
        C12159a next;
        File fileM57717k = null;
        try {
            Iterator<C12159a> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (next.m72872H() == 1) {
                    break;
                }
            }
            if (next == null) {
                return null;
            }
            m57725s();
            fileM57717k = m57717k(next, this.f46104p.getParent(), next.m72866B() + ".last");
            C11839m.m70688i("CloudBackupV3FileDifference", "get last hash file: " + C10279b.m63452a(fileM57717k));
            return fileM57717k;
        } catch (C9721b e10) {
            C11839m.m70689w("CloudBackupV3FileDifference", "getV3DbDifferencePackets download different pcket file error.");
            this.f46081D.put("lastHashFileError", e10.getMessage());
            return fileM57717k;
        }
    }

    /* renamed from: q */
    public final long m57723q(String str, String str2) throws C9721b {
        com.huawei.hicloud.cloudbackup.p104v3.server.model.File fileM57709c = m57709c(str, str2, "attachments(sliceSize)", 0);
        if (fileM57709c.getAttachments().size() > 0) {
            return fileM57709c.getAttachments().get(0).getSliceSize().longValue();
        }
        throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "no attachments return");
    }

    /* renamed from: r */
    public final String m57724r(InterfaceC9213h2 interfaceC9213h2) {
        String strM75665a = C12583q.m75665a(C12590s0.m75797S2(this.f46098j, this.f46099k, this.f46100l, interfaceC9213h2.mo57844e0(), this.f46089a), 0, this.f46100l);
        String strM75648B = C12583q.m75648B(strM75665a);
        if (ICBUtil.hasEmojiCharacter(strM75665a)) {
            strM75665a = ICBUtil.getEncodedPath(strM75665a);
        }
        return strM75665a.substring(strM75648B.length());
    }

    /* renamed from: s */
    public final void m57725s() throws InterruptedException, C9721b {
        C4879a c4879a = this.f46093e;
        if (c4879a != null) {
            c4879a.isDiffCancel();
        }
    }

    /* renamed from: t */
    public final /* synthetic */ InterfaceC10551c0 m57726t(String str, String str2, String str3, String str4, String str5) throws InterruptedException, C9721b {
        m57725s();
        C10560j c10560j = new C10560j(null, this.f46097i, this.f46093e.m29728n0(), str, str2, str3, str4, str5, "File");
        this.f46101m = c10560j;
        return c10560j;
    }

    /* renamed from: u */
    public final /* synthetic */ void m57727u(AbstractC10548b abstractC10548b) {
        this.f46110v = abstractC10548b;
    }

    /* renamed from: v */
    public final void m57728v(InterfaceC9213h2 interfaceC9213h2, int i10, InterfaceC10570t interfaceC10570t) throws InterruptedException, C9721b {
        if (interfaceC9213h2 == null || !interfaceC9213h2.mo57843d0()) {
            C11839m.m70689w("CloudBackupV3FileDifference", "recordDiffMeta file not exist");
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "recordDiffMeta file not exist");
        }
        C12159a c12159aM57714h = m57714h(interfaceC9213h2, i10);
        m57725s();
        C11308a c11308aMo57845h0 = interfaceC9213h2.mo57845h0(interfaceC10570t, this.f46098j, this.f46100l, this.f46097i, this.f46095g, this.f46093e, new Consumer() { // from class: dm.a
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f46035a.m57727u((AbstractC10548b) obj);
            }
        }, this.f46087J);
        m57725s();
        c12159aM57714h.m72893b0(c11308aMo57845h0.m67895m());
        c12159aM57714h.m72875K(c11308aMo57845h0.m67883a());
        c12159aM57714h.m72918o0(c11308aMo57845h0.m67898p());
        c12159aM57714h.m72897d0(c11308aMo57845h0.m67889g());
        c12159aM57714h.m72899e0(c11308aMo57845h0.m67890h());
        c12159aM57714h.m72914m0(4);
        c12159aM57714h.m72895c0(1);
        this.f46090b.m72943n(c12159aM57714h);
    }

    /* renamed from: w */
    public final boolean m57729w() throws InterruptedException, C9721b {
        try {
            long jM57723q = m57723q(this.f46093e.m29719k0(), this.f46114z);
            String strMo57846k0 = this.f46104p.mo57846k0(jM57723q);
            String strM1593f = C0227m.m1593f(strMo57846k0);
            this.f46088K.f46115a = strMo57846k0;
            this.f46088K.f46118d = this.f46104p.mo57847p0();
            long jCurrentTimeMillis = System.currentTimeMillis();
            m57730x(this.f46106r, strM1593f, this.f46113y, this.f46078A);
            this.f46081D.put("uploadDiffPackTime", String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
            this.f46081D.put("originSliceSize", String.valueOf(jM57723q));
            this.f46081D.put("originDivideSha256", strM1593f);
            return true;
        } catch (C9721b e10) {
            String str = "upload diffPack error: " + e10.getMessage();
            C11839m.m70687e("CloudBackupV3FileDifference", str);
            this.f46081D.put("dBDiffErrorReason", str);
            this.f46081D.put(AddressConstants.Extras.EXTRA_NAME_ERR_CODE, String.valueOf(e10.m60659c()));
            File file = this.f46106r;
            if (file != null) {
                m57715i(file);
            }
            if (e10.m60663g() != 51004919) {
                return false;
            }
            this.f46081D.put("fileCreateNoSupportDiff", FaqConstants.DISABLE_HA_REPORT);
            C11839m.m70687e("CloudBackupV3FileDifference", "diff files recordDiffPack CException = " + e10.getMessage() + " status = " + e10.m60663g());
            throw e10;
        }
    }

    /* renamed from: x */
    public final void m57730x(File file, String str, String str2, int i10) throws InterruptedException, C9721b {
        if (file == null || !file.exists()) {
            C11839m.m70689w("CloudBackupV3FileDifference", "recordDiffMeta file not extis");
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "recordDiffPackMeta file not exist");
        }
        C12159a c12159aM57714h = m57714h(new C9217i2(file), 2L);
        c12159aM57714h.m72879O(this.f46104p.length());
        c12159aM57714h.m72901f0(i10);
        m57725s();
        C11308a c11308aM57708C = m57708C(0, file, str, str2);
        m57725s();
        c12159aM57714h.m72879O(this.f46104p.length());
        c12159aM57714h.m72893b0(c11308aM57708C.m67895m());
        c12159aM57714h.m72875K(c11308aM57708C.m67883a());
        c12159aM57714h.m72918o0(c11308aM57708C.m67898p());
        c12159aM57714h.m72897d0(c11308aM57708C.m67889g());
        c12159aM57714h.m72899e0(c11308aM57708C.m67890h());
        c12159aM57714h.m72914m0(4);
        c12159aM57714h.m72895c0(1);
        this.f46090b.m72943n(c12159aM57714h);
        this.f46081D.put("diffPackSha256", c11308aM57708C.m67890h());
        this.f46081D.put("diffPackHash", c11308aM57708C.m67889g());
        this.f46081D.put("diffPackSize", String.valueOf(file.length()));
    }

    /* renamed from: y */
    public final void m57731y() throws InterruptedException, C9721b {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            m57728v(new C9217i2(this.f46105q), 1, null);
            this.f46081D.put("uploadFingerPrintTime", String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
        } catch (C9721b e10) {
            this.f46103o = false;
            File file = this.f46105q;
            if (file != null) {
                m57715i(file);
            }
            C11839m.m70687e("CloudBackupV3FileDifference", "recordFingerPrint fail, " + e10.getMessage());
            throw e10;
        }
    }

    /* renamed from: z */
    public final void m57732z() throws C9721b {
        for (C12159a c12159a : this.f46112x) {
            if (1 != c12159a.m72872H()) {
                c12159a.m72914m0(5);
                c12159a.m72912l0(this.f46108t);
                if (0 == c12159a.m72872H()) {
                    c12159a.m72891a0(m57710d());
                }
                this.f46090b.m72943n(c12159a);
            }
        }
    }
}
