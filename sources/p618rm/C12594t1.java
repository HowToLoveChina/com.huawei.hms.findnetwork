package p618rm;

import android.database.SQLException;
import android.os.Environment;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.operator.SnapshotBackupMetaOperator;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.hicloud.base.bean.Md5AndHash;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudBackupStatus;
import com.huawei.hicloud.notification.constants.HNConstants;
import fk.C9721b;
import hk.C10278a;
import hk.C10279b;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.List;
import mk.C11476b;
import p015ak.C0221j;
import p292fn.C9733f;
import p455ll.C11309b;
import p455ll.C11311d;
import p495nm.C11731l;
import p514o9.C11839m;
import p682ul.C13216j;
import p744wl.C13617a;
import p848zl.C14333b;
import pl.C12161c;
import pl.C12162d;
import pl.C12164f;
import pl.C12165g;
import sl.C12815f;

/* renamed from: rm.t1 */
/* loaded from: classes6.dex */
public class C12594t1 {

    /* renamed from: rm.t1$b */
    public static class b {

        /* renamed from: a */
        public static C12594t1 f57990a = new C12594t1();
    }

    public /* synthetic */ C12594t1(a aVar) {
        this();
    }

    /* renamed from: b */
    public static void m75987b(C12161c c12161c, String str) {
        String strM72984h = c12161c.m72984h();
        if (strM72984h.getBytes(StandardCharsets.UTF_8).length > 250) {
            strM72984h = str + "_" + str;
        }
        c12161c.m72961Q(strM72984h);
    }

    /* renamed from: m */
    public static String m75988m(String str, String str2, String str3, int i10) {
        return C12590s0.m75873l1(str2) ? C13617a.m81943y(str, str3, 0, i10, false) : C13617a.m81912A(str);
    }

    /* renamed from: n */
    public static Md5AndHash m75989n(File file, File file2, String str) throws C9721b {
        try {
            return C11476b.m68622d(file2);
        } catch (C9721b e10) {
            if (e10.m60659c() != 1011) {
                throw e10;
            }
            String strM63452a = C10279b.m63452a(file);
            String strM1513w = C0221j.m1513w();
            if (TextUtils.isEmpty(strM1513w) || !strM63452a.startsWith(strM1513w)) {
                throw e10;
            }
            if (!"mounted".equals(Environment.getExternalStorageState(C10278a.m63442h(strM1513w)))) {
                throw new C9721b(1034, e10.getMessage());
            }
            C9721b c9721b = new C9721b(1035, e10.getMessage());
            c9721b.m60664h(new C11731l(str, file.getName(), C10279b.m63452a(C10278a.m63437c(file))).toString());
            throw c9721b;
        }
    }

    /* renamed from: o */
    public static C12594t1 m75990o() {
        return b.f57990a;
    }

    /* renamed from: A */
    public void m75991A(File file, File file2, C12161c c12161c, String str, int i10) throws C9721b {
        Md5AndHash md5AndHashM75989n = m75989n(file, file2, c12161c.m72974c());
        String md5 = md5AndHashM75989n.getMD5();
        String hash = md5AndHashM75989n.getHash();
        c12161c.m72985h0(md5);
        c12161c.m72986i0(hash);
        c12161c.m72960P(hash);
    }

    /* renamed from: B */
    public void m75992B(String str, C12161c c12161c, int i10) throws C9721b {
        new C12164f(str, c12161c.m72974c(), 0, i10).m73117z0(c12161c);
    }

    /* renamed from: C */
    public void m75993C(String str, String str2, C12161c c12161c, int i10) throws C9721b {
        new C12164f(str2, str, 0, i10).m73029C0(c12161c);
    }

    /* renamed from: D */
    public void m75994D(int i10, String str, String str2, String str3, int i11) throws C9721b {
        new C12164f(str3, str2, 0, i11).m73035F0(str, i10);
    }

    /* renamed from: E */
    public void m75995E(String str, String str2, int i10) throws C9721b {
        C12164f c12164f = new C12164f(str2, str, 0, i10);
        c12164f.m73039H0(-4, 4);
        c12164f.m73039H0(-5, 5);
        c12164f.m73039H0(-6, 6);
    }

    /* renamed from: F */
    public void m75996F(String str, String str2, int i10, boolean z10) throws SQLException {
        try {
            new C12164f(str, str2, 0, i10).m73025A0(z10);
        } catch (C9721b e10) {
            C11839m.m70687e("SnapshotV3Service", "updateLostFileInfoBySnapshot error " + e10.getMessage());
        }
    }

    /* renamed from: G */
    public void m75997G(String str, String str2, String str3, String str4, int i10) throws C9721b, SQLException {
        C12165g c12165g = new C12165g(str3, str4, 0, i10);
        String strM75988m = m75988m(str, str2, str4, i10);
        if (C9733f.m60705z().m60720O("cloudBackupWithIntegrityCheck")) {
            if (!C13617a.m81918G(strM75988m)) {
                C11839m.m70687e("SnapshotV3Service", "db is Integrity not Ok! appId:" + str4 + " successBakId: " + str);
                return;
            }
            if (!new SnapshotBackupMetaOperator(str).checkTableExist()) {
                C11839m.m70688i("SnapshotV3Service", "updateV2Cache attach dbFilePath " + strM75988m + " snapshot_data table is not exist!!");
                return;
            }
        }
        c12165g.m73118a(strM75988m);
        try {
            try {
                c12165g.m73129l();
            } catch (C9721b e10) {
                C11839m.m70687e("SnapshotV3Service", "updateV2Cache error.");
                throw e10;
            }
        } finally {
            c12165g.detach();
        }
    }

    /* renamed from: H */
    public void m75998H(String str, String str2, String str3, String str4, int i10) throws C9721b, SQLException {
        C12165g c12165g = new C12165g(str3, str4, 0, i10);
        String strM75988m = m75988m(str, str2, str4, i10);
        if (C9733f.m60705z().m60720O("cloudBackupWithIntegrityCheck") && !C13617a.m81918G(strM75988m)) {
            C11839m.m70687e("SnapshotV3Service", "db is Integrity not Ok! appId:" + str4 + " successBakId: " + str);
            return;
        }
        c12165g.m73118a(strM75988m);
        try {
            try {
                c12165g.m73128k();
            } catch (C9721b e10) {
                C11839m.m70687e("SnapshotV3Service", "updateV2Cache error.");
                throw e10;
            }
        } finally {
            c12165g.detach();
        }
    }

    /* renamed from: I */
    public void m75999I(String str, String str2, C12161c c12161c, String str3, int i10) throws C9721b {
        new C12164f(str2, str, 0, i10).m73045K0(c12161c, str3);
    }

    /* renamed from: J */
    public void m76000J(String str, String str2, String str3, int i10) throws C9721b, SQLException {
        C12164f c12164f = new C12164f(str2, str3, 0, i10);
        String strM81912A = C13617a.m81912A(str);
        if (C9733f.m60705z().m60720O("cloudBackupWithIntegrityCheck")) {
            if (!C13617a.m81918G(strM81912A)) {
                C11839m.m70687e("SnapshotV3Service", "db is Integrity not Ok! appId:" + str3 + " successBakId: " + str);
                return;
            }
            if (!new SnapshotBackupMetaOperator(str).checkTableExist()) {
                C11839m.m70688i("SnapshotV3Service", "updateV2Cache attach dbFilePath " + strM81912A + " snapshot_data table is not exist!!");
                return;
            }
        }
        c12164f.m73069b(strM81912A);
        try {
            try {
                c12164f.m73051N0();
            } catch (C9721b e10) {
                C11839m.m70687e("SnapshotV3Service", "updateV2Cache error.");
                throw e10;
            }
        } finally {
            c12164f.detach();
        }
    }

    /* renamed from: K */
    public void m76001K(String str, String str2, String str3, int i10, boolean z10, boolean z11) throws C9721b, SQLException {
        C12164f c12164f = new C12164f(str2, str3, 0, i10);
        String strM81942x = C13617a.m81942x(str, str3, 0, i10);
        boolean zM60720O = C9733f.m60705z().m60720O("cloudBackupWithIntegrityCheck");
        C11839m.m70686d("SnapshotV3Service", "db is Integrity check: " + strM81942x);
        if (zM60720O) {
            if (!C13617a.m81918G(strM81942x)) {
                C11839m.m70689w("SnapshotV3Service", "db is Integrity not Ok! appId:" + str3 + " successBakId: " + str);
                return;
            }
            if (!new C12164f(str, str3, 0, i10).m73103s()) {
                C11839m.m70689w("SnapshotV3Service", "updateV3Cache has not snapshot_data table");
                return;
            }
        }
        C11839m.m70686d("SnapshotV3Service", "db is Integrity check ok");
        c12164f.m73069b(strM81942x);
        try {
            try {
                c12164f.m73059R0(z10);
                if (new C12164f(str, str3, 0, i10).m73097p()) {
                    c12164f.m73053O0();
                }
            } catch (C9721b e10) {
                C11839m.m70687e("SnapshotV3Service", "updateV3Cache error.");
                throw e10;
            }
        } finally {
            c12164f.detach();
        }
    }

    /* renamed from: a */
    public void m76002a(String str, String str2, List<C12161c> list, int i10) throws C9721b {
        new C12164f(str2, str, 0, i10).batchReplace(list);
    }

    /* renamed from: c */
    public void m76003c(String str, String str2, int i10) throws C9721b {
        new C12164f(str2, str, 0, i10).m73083i();
    }

    /* renamed from: d */
    public final void m76004d(File file, String str, String str2, C12161c c12161c, String str3) {
        String str4 = C11476b.m68626h(str) + '_' + str2;
        if (str.endsWith(str3 + "/gallery/gallery.db")) {
            str4 = file.getName() + '_' + str2;
        }
        File fileM63442h = C10278a.m63442h(str);
        if (c12161c.m72955K()) {
            fileM63442h = C10278a.m63442h(ICBUtil.getDecodedPath(str));
        }
        c12161c.m72961Q(C11476b.m68626h(fileM63442h.getParent()) + File.separator + str4);
    }

    /* renamed from: e */
    public void m76005e(String str) {
        try {
            new C12815f(str).m76922a();
        } catch (C9721b e10) {
            C11839m.m70689w("SnapshotV3Service", "defaultNotSuccessModule error: " + e10.getMessage());
        }
    }

    /* renamed from: f */
    public void m76006f(String str, String str2, int i10) {
        new C12164f(str, str2, 0, i10).close();
        String strM81942x = C13617a.m81942x(str, str2, 0, i10);
        File fileM63442h = C10278a.m63442h(strM81942x);
        if (fileM63442h.exists()) {
            C11839m.m70688i("SnapshotV3Service", "deleteAppBackupMetaDbFile, delete snapshot: " + fileM63442h.getName());
            if (!fileM63442h.delete()) {
                C11839m.m70689w("SnapshotV3Service", "deleteAppBackupMetaDbFile: " + str2 + " error");
            }
        }
        File fileM63442h2 = C10278a.m63442h(strM81942x + "-journal");
        if (!fileM63442h2.exists() || fileM63442h2.delete()) {
            return;
        }
        C11839m.m70689w("SnapshotV3Service", "deleteAppBackupMetaDbFile cache file: " + str2 + " error");
    }

    /* renamed from: g */
    public void m76007g(String str, String str2, int i10) throws C9721b {
        new C12164f(str2, str, 0, i10).m73089l(ICBUtil.RELATIVE_SDATA_PATH + File.separator);
    }

    /* renamed from: h */
    public void m76008h(String str, String str2, int i10) {
        m76009i(str, str2, i10, true);
    }

    /* renamed from: i */
    public void m76009i(String str, String str2, int i10, boolean z10) {
        new C12164f(str2, str, 0, i10).clear();
        if (z10) {
            String strM81942x = C13617a.m81942x(str2, str, 0, i10);
            C13216j.c cVar = C13216j.c.SNAPSHOT;
            C11309b c11309b = new C11309b(C13216j.m79427l(cVar, strM81942x));
            C11311d c11311d = new C11311d(C13216j.m79427l(cVar, strM81942x));
            c11309b.clear();
            c11311d.clear();
        }
    }

    /* renamed from: j */
    public void m76010j(String str, String str2, int i10) throws C9721b {
        new C12164f(str2, str, 0, i10).m73091m(str);
    }

    /* renamed from: k */
    public void m76011k(String str, String str2, int i10) throws C9721b {
        new C12164f(str2, str, 0, i10).m73093n();
    }

    /* renamed from: l */
    public void m76012l(String str, String str2, String str3, int i10) throws C9721b, SQLException {
        C12162d c12162d = new C12162d(str2, str3, 0, i10);
        c12162d.m73012a(C13617a.m81942x(str, str3, 0, i10));
        try {
            try {
                c12162d.m73015d();
            } catch (C9721b e10) {
                C11839m.m70687e("SnapshotV3Service", "updateV3Cache error.");
                throw e10;
            }
        } finally {
            c12162d.detach();
        }
    }

    /* renamed from: p */
    public String m76013p(C12161c c12161c, String str, int i10, String str2) {
        String str3 = c12161c.m72950F() + c12161c.m72991l();
        return C12590s0.m75801T2(c12161c.m72974c(), str, i10, str2, c12161c.m72980f() == 1 ? C12583q.m75659M(ICBUtil.getDecodedPath(str3), 0, i10) : C12583q.m75659M(str3, 0, i10));
    }

    /* renamed from: q */
    public long m76014q(String str, String str2, int i10) {
        try {
            return new C12164f(str2, str, 0, i10).m73070b0();
        } catch (C9721b e10) {
            C11839m.m70687e("SnapshotV3Service", "getOneModuleFileSize: " + str + " queryAllSizeSum error" + e10.toString());
            return 0L;
        }
    }

    /* renamed from: r */
    public final boolean m76015r(String str, String str2) {
        if (C14333b.m85477l().contains(str2)) {
            return false;
        }
        String str3 = str2 + ".apk";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str2);
        sb2.append(".icon");
        return (str.endsWith(str3) || str.endsWith(sb2.toString()) || str.endsWith("info.xml")) ? false : true;
    }

    /* renamed from: s */
    public List<CloudBackupStatus> m76016s(String str) throws C9721b {
        return new C12815f(str).m76932k();
    }

    /* renamed from: t */
    public CloudBackupStatus m76017t(String str, int i10, String str2) throws C9721b {
        return new C12815f(str2).m76929h(str, i10);
    }

    /* renamed from: u */
    public C12161c m76018u(String str, String str2, String str3, String str4, int i10) throws C9721b {
        return new C12164f(str, str2, 0, i10).m73064W(str3, str4);
    }

    /* renamed from: v */
    public long m76019v(String str, String str2, int i10) {
        try {
            return new C12164f(str2, str, 0, i10).m73072c0();
        } catch (C9721b e10) {
            C11839m.m70687e("SnapshotV3Service", "queryMkfiledFileSize error, " + e10.toString());
            return 0L;
        }
    }

    /* renamed from: w */
    public int m76020w(String str, String str2, int i10) {
        try {
            return (int) new C12164f(str2, str, 0, i10).m73086j0();
        } catch (C9721b e10) {
            C11839m.m70687e("SnapshotV3Service", "queryUploadedFilesNum error, " + e10.toString());
            return 0;
        }
    }

    /* renamed from: x */
    public int m76021x(String str, String str2, int i10) {
        try {
            return (int) new C12164f(str2, str, 0, i10).m73102r0();
        } catch (C9721b e10) {
            C11839m.m70687e("SnapshotV3Service", "queryUploadedFilesNum error, " + e10.toString());
            return 0;
        }
    }

    /* renamed from: y */
    public int m76022y(String str, String str2, int i10) throws C9721b {
        return new C12164f(str2, str, 0, i10).m73109v0();
    }

    /* renamed from: z */
    public void m76023z(File file, C12161c c12161c, String str, String str2) {
        String strM72982g = c12161c.m72982g();
        String strM72948D = c12161c.m72948D();
        String strM72974c = c12161c.m72974c();
        if (HNConstants.DataType.MEDIA.equals(strM72974c)) {
            m76004d(file, str, strM72982g, c12161c, str2);
        } else if (m76015r(str, strM72974c)) {
            c12161c.m72961Q(C11476b.m68626h(str) + '_' + strM72982g);
        } else if ("music".equals(strM72974c)) {
            c12161c.m72961Q(C11476b.m68626h(str) + '_' + strM72982g);
        } else {
            c12161c.m72961Q(strM72948D + '_' + strM72982g);
        }
        m75987b(c12161c, strM72982g);
    }

    public C12594t1() {
    }
}
