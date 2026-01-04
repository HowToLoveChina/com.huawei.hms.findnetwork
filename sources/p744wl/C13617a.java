package p744wl;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.p076db.operator.AlbumOperator;
import com.huawei.android.hicloud.cloudbackup.p076db.operator.SettingOperator;
import com.huawei.android.hicloud.cloudbackup.process.CBAccess;
import com.huawei.android.hicloud.cloudbackup.snapshottree.SnapshotTreeManagementService;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.SnapshotDBManager;
import fk.C9721b;
import hk.C10278a;
import hk.C10279b;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p015ak.C0213f;
import p455ll.C11309b;
import p455ll.C11311d;
import p455ll.C11313f;
import p514o9.C11835i;
import p514o9.C11839m;
import p526ol.C11960a;
import p582ql.C12372c;
import p617rl.C12517a;
import p617rl.C12519c;
import p617rl.C12520d;
import p617rl.C12521e;
import p617rl.C12522f;
import p617rl.C12526j;
import p618rm.C12571m;
import p618rm.C12574n;
import p618rm.C12583q;
import p652t9.EnumC12999a;
import p673u9.C13136a;
import p673u9.C13140e;
import p673u9.C13141f;
import p682ul.C13216j;
import p840zd.C14229k2;
import pl.C12169k;
import sl.C12811b;
import sl.C12812c;
import sl.C12814e;
import sl.C12815f;
import sl.C12816g;
import tl.C13026e;
import tl.C13027f;
import tl.C13030i;
import tl.C13033l;
import tl.C13034m;
import tl.C13035n;
import tl.C13036o;

/* renamed from: wl.a */
/* loaded from: classes6.dex */
public class C13617a {
    /* renamed from: A */
    public static String m81912A(String str) {
        return C10279b.m63452a(C0213f.m1378b().getDatabasePath("snapshot_" + str + SnapshotDBManager.SUFFIX_DATABASE_NAME));
    }

    /* renamed from: B */
    public static String m81913B(String str) {
        return "snapshot_" + str + SnapshotDBManager.SUFFIX_DATABASE_NAME;
    }

    /* renamed from: C */
    public static String m81914C(String str, int i10) {
        return m81915D(str, i10, true);
    }

    /* renamed from: D */
    public static String m81915D(String str, int i10, boolean z10) {
        return C12583q.m75657K(str, i10, z10) + "/" + str + "_brief_file_info.db";
    }

    /* renamed from: E */
    public static String m81916E(String str) {
        return m81917F(str, true);
    }

    /* renamed from: F */
    public static String m81917F(String str, boolean z10) {
        File fileM63443i = C10278a.m63443i(C10279b.m63452a(C10278a.m63442h(C0213f.m1378b().getFilesDir() + "/cloudrestore")) + "/database", str);
        if (z10 && !fileM63443i.exists()) {
            C11839m.m70688i("CloudBackupDatabaseUtil", "mkdir result = " + fileM63443i.mkdirs());
        }
        return C10279b.m63452a(fileM63443i);
    }

    /* renamed from: G */
    public static boolean m81918G(String str) {
        try {
            SQLiteDatabase sQLiteDatabaseOpenDatabase = SQLiteDatabase.openDatabase(str, null, 1);
            if (sQLiteDatabaseOpenDatabase != null) {
                return sQLiteDatabaseOpenDatabase.isDatabaseIntegrityOk();
            }
            return false;
        } catch (Exception e10) {
            C11839m.m70687e("CloudBackupDatabaseUtil", "isDataBaseIntegrityOk exception " + e10.getMessage());
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m81919a(String str) {
        Context contextM1378b;
        File databasePath;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str) && (databasePath = (contextM1378b = C0213f.m1378b()).getDatabasePath(str)) != null && databasePath.exists()) {
            try {
                SQLiteDatabase sQLiteDatabaseOpenOrCreateDatabase = contextM1378b.openOrCreateDatabase(str, 0, null);
                if (sQLiteDatabaseOpenOrCreateDatabase == null) {
                    return true;
                }
                sQLiteDatabaseOpenOrCreateDatabase.close();
                return true;
            } catch (Exception unused) {
                C11839m.m70688i("CloudBackupDatabaseUtil", "checkDatabasesIsExists open database error.");
            }
        }
        return false;
    }

    /* renamed from: b */
    public static void m81920b(boolean z10, boolean z11) {
        C11839m.m70688i("CloudBackupDatabaseUtil", "deleteBackupDb");
        if (z10) {
            m81923e(z11);
        }
        m81924f(z10);
    }

    /* renamed from: c */
    public static void m81921c(Context context, boolean z10) {
        m81920b(z10, !CBAccess.inRestoreTask());
        C12574n.m75554g(context, z10);
        C12574n.m75554g(C0213f.m1378b(), z10);
    }

    /* renamed from: d */
    public static void m81922d(String str, Context context, boolean z10) {
        C11839m.m70688i("CloudBackupDatabaseUtil", "delete backup metas by bakId: " + str);
        C13216j.m79423h();
        m81936r(str);
        m81925g(z10);
        C12574n.m75554g(context, true);
        C12574n.m75554g(C0213f.m1378b(), true);
    }

    /* renamed from: e */
    public static void m81923e(boolean z10) throws SQLException {
        File[] fileArrListFiles;
        C13216j.m79424i(z10);
        File fileM63442h = C10278a.m63442h(m81941w());
        if (fileM63442h.exists() && (fileArrListFiles = fileM63442h.listFiles()) != null) {
            for (File file : fileArrListFiles) {
                if (file.isDirectory() && !C11835i.m70642f(file)) {
                    C11839m.m70688i("CloudBackupDatabaseUtil", "delete file fail, file = " + file.getName());
                }
            }
        }
        SnapshotTreeManagementService.getInstance().deleteSnapshotDB();
        try {
            new C13136a().m79012g(EnumC12999a.CLOUD_BACKUP.m78143b());
        } catch (C9721b e10) {
            C11839m.m70689w("CloudBackupDatabaseUtil", "clear backup meta failed, reason: " + e10.toString());
        }
        try {
            new C13140e().m79034g(EnumC12999a.CLOUD_BACKUP.m78143b());
        } catch (C9721b e11) {
            C11839m.m70689w("CloudBackupDatabaseUtil", "clear backup meta failed, reason: " + e11.toString());
        }
        try {
            new C13141f().m79040g(EnumC12999a.CLOUD_BACKUP.m78143b());
        } catch (C9721b e12) {
            C11839m.m70689w("CloudBackupDatabaseUtil", "clear backup meta failed, reason: " + e12.toString());
        }
    }

    /* renamed from: f */
    public static void m81924f(boolean z10) {
        C11839m.m70688i("CloudBackupDatabaseUtil", "deleteBackupStatusDb start: " + z10);
        new C12815f().clear();
        new C12815f("Refurbishment").clear();
        if (z10) {
            new C12815f("interim").clear();
            m81926h();
        }
        new C12814e().clear();
        C11839m.m70688i("CloudBackupDatabaseUtil", "deleteBackupStatusDb end");
    }

    /* renamed from: g */
    public static void m81925g(boolean z10) {
        C11839m.m70688i("CloudBackupDatabaseUtil", "deleteBackupStatusDbInBackup start: " + z10);
        new C12815f().clear();
        new C12815f("Refurbishment").clear();
        if (z10) {
            new C12815f("interim").clear();
        }
        m81926h();
        new C12814e().clear();
        C11839m.m70688i("CloudBackupDatabaseUtil", "deleteBackupStatusDbInBackup end");
    }

    /* renamed from: h */
    public static void m81926h() {
        new C12812c().clear();
        C13216j.c cVar = C13216j.c.STATUS;
        new C11309b(C13216j.m79427l(cVar, null)).clear();
        new C11311d(C13216j.m79427l(cVar, null)).clear();
        new C12372c().clear();
    }

    /* renamed from: i */
    public static void m81927i(boolean z10) {
        C13030i c13030i = new C13030i();
        c13030i.m78490a(1);
        c13030i.m78490a(2);
        new C13033l().m78543a(1);
        if (z10) {
            c13030i.m78490a(5);
            new C13034m().m78543a(1);
        }
    }

    /* renamed from: j */
    public static void m81928j() {
        m81934p();
        m81935q();
        m81931m();
        m81929k();
    }

    /* renamed from: k */
    public static void m81929k() {
        new AlbumOperator().clear();
    }

    /* renamed from: l */
    public static void m81930l(List<String> list) {
        File[] fileArrListFiles;
        File fileM63442h = C10278a.m63442h(m81941w());
        if (fileM63442h.exists() && (fileArrListFiles = fileM63442h.listFiles()) != null) {
            if (list == null) {
                list = new ArrayList<>();
            }
            for (File file : fileArrListFiles) {
                if (!file.isDirectory()) {
                    String name = file.getName();
                    if (name.startsWith("snapshot_")) {
                        Iterator<String> it = list.iterator();
                        boolean zContains = false;
                        while (it.hasNext() && !(zContains = name.contains(it.next()))) {
                        }
                        if (!zContains) {
                            String strReplace = name.replaceFirst("snapshot_", "").replace(SnapshotDBManager.SUFFIX_DATABASE_NAME, "");
                            C11839m.m70688i("CloudBackupDatabaseUtil", "deleteInvalidBackupMetasDb v2 backupId: " + strReplace);
                            SnapshotTreeManagementService.getInstance().deleteSnapshotDB(strReplace);
                            C12571m.m75547i(C10279b.m63452a(file));
                        }
                    }
                } else if (!list.contains(file.getName())) {
                    C12571m.m75547i(C10279b.m63452a(file));
                }
            }
        }
    }

    /* renamed from: m */
    public static void m81931m() {
        new C11960a().clear();
    }

    /* renamed from: n */
    public static void m81932n(boolean z10) {
        if (z10) {
            new C13035n().clear();
            new C12816g().clear();
        }
        new C12169k().clear();
        new C12811b().clear();
        new C11313f().clear();
    }

    /* renamed from: o */
    public static void m81933o() {
        new C13030i().m78490a(3);
        new C13033l().m78543a(2);
    }

    /* renamed from: p */
    public static void m81934p() {
        new C12517a().clear();
        new C12526j().clear();
        new C12520d().clear();
        new C12519c().clear();
        new C12521e().clear();
        new C12522f().clear();
        new SettingOperator().clear();
    }

    /* renamed from: q */
    public static void m81935q() {
        new C13026e().clear();
        new C13026e(true).clear();
        new C14229k2().clear();
        new C13030i().clear();
        new C13033l().clear();
        new C13034m().clear();
        new C13027f().clear();
        new C13036o().clear();
    }

    /* renamed from: r */
    public static void m81936r(String str) {
        C12571m.m75547i(m81939u(str));
        C11839m.m70686d("CloudBackupDatabaseUtil", "deleteV3LocalSnapshot: " + str);
    }

    /* renamed from: s */
    public static boolean m81937s(String str, String str2, int i10) {
        return m81938t(str, str2, i10, 0);
    }

    /* renamed from: t */
    public static boolean m81938t(String str, String str2, int i10, int i11) {
        Context contextM1378b;
        String strM81942x;
        File databasePath;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (databasePath = (contextM1378b = C0213f.m1378b()).getDatabasePath((strM81942x = m81942x(str, str2, i10, i11)))) != null && databasePath.exists()) {
            try {
                contextM1378b.openOrCreateDatabase(strM81942x, 0, null).close();
                return true;
            } catch (Exception unused) {
                C11839m.m70688i("CloudBackupDatabaseUtil", "existV3SnapshotDataBase  open database error.");
            }
        }
        return false;
    }

    /* renamed from: u */
    public static String m81939u(String str) {
        return m81940v(str, true);
    }

    /* renamed from: v */
    public static String m81940v(String str, boolean z10) {
        File fileM63443i = C10278a.m63443i(C0213f.m1378b().getDatabasePath("cloudbackup_tags.db").getParent(), str);
        if (z10 && !fileM63443i.exists()) {
            C11839m.m70688i("CloudBackupDatabaseUtil", "mkdir result = " + fileM63443i.mkdirs());
        }
        return C10279b.m63452a(fileM63443i);
    }

    /* renamed from: w */
    public static String m81941w() {
        return C10279b.m63452a(C10278a.m63442h(C0213f.m1378b().getDatabasePath("cloudbackup_tags.db").getParent()));
    }

    /* renamed from: x */
    public static String m81942x(String str, String str2, int i10, int i11) {
        return m81943y(str, str2, i10, i11, true);
    }

    /* renamed from: y */
    public static String m81943y(String str, String str2, int i10, int i11, boolean z10) {
        return m81944z(str, str2, i10, z10);
    }

    /* renamed from: z */
    public static String m81944z(String str, String str2, int i10, boolean z10) {
        if (i10 == 0) {
            return m81940v(str, z10) + "/" + str2 + SnapshotDBManager.SUFFIX_DATABASE_NAME;
        }
        return m81917F(str, z10) + "/" + str2 + SnapshotDBManager.SUFFIX_DATABASE_NAME;
    }
}
