package pl;

import android.database.Cursor;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.constants.HNConstants;
import fk.C9721b;
import java.util.List;
import ml.AbstractC11478a;
import p015ak.C0241z;
import p514o9.C11839m;
import p682ul.C13216j;

/* renamed from: pl.k */
/* loaded from: classes6.dex */
public class C12169k extends AbstractC11478a<C12168j> {
    public C12169k() {
        super(C13216j.m79427l(C13216j.c.METADATA, null));
    }

    /* renamed from: a */
    public void m73198a() throws C9721b {
        delete("app_restore_metainfo", null, null);
    }

    /* renamed from: b */
    public void m73199b(String str, String str2) throws C9721b {
        execSQL("delete from app_restore_metainfo where appId = ? and fpath = ?", new String[]{str2, str});
    }

    public void batchReplace(List<C12168j> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        try {
            batch("replace into app_restore_metainfo(appId,fpath,fname,fsize,fileType,hash1,hash2,hmac,status,ftime,tarFile,encoded,data1,data2,data3,data4,data5) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);", list);
        } catch (C9721b e10) {
            C11839m.m70689w("CloudRestoreMetaOperator", "replace restore metadata error." + e10.getMessage());
        }
    }

    @Override // ml.AbstractC11478a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public String[] getColumns(C12168j c12168j) {
        return new String[]{c12168j.m73172a(), c12168j.m73181j(), c12168j.m73180i(), String.valueOf(c12168j.m73182k()), c12168j.m73179h(), c12168j.m73184m(), c12168j.m73185n(), c12168j.m73186o(), String.valueOf(c12168j.m73187p()), c12168j.m73183l(), c12168j.m73188q(), c12168j.m73178g(), c12168j.m73173b(), c12168j.m73174c(), c12168j.m73175d(), c12168j.m73176e(), c12168j.m73177f()};
    }

    public void clear() {
        C11839m.m70688i("CloudRestoreMetaOperator", "clear restore metadata start");
        try {
            m73198a();
        } catch (C9721b e10) {
            C11839m.m70689w("CloudRestoreMetaOperator", "clear restore metadata error." + e10.getMessage());
        }
        C11839m.m70688i("CloudRestoreMetaOperator", "clear restore metadata end");
    }

    @Override // ml.AbstractC11478a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C12168j getObject(Cursor cursor) {
        C12168j c12168j = new C12168j();
        c12168j.m73189r(cursor.getString(0)).m73164A(cursor.getString(1)).m73197z(cursor.getString(2)).m73165B(C0241z.m1688f(cursor.getString(3))).m73196y(cursor.getString(4)).m73167D(cursor.getString(5)).m73168E(cursor.getString(6)).m73169F(cursor.getString(7)).m73170G(C0241z.m1685c(cursor.getString(8))).m73166C(cursor.getString(9)).m73171H(cursor.getString(10)).m73195x(cursor.getString(11)).m73190s(cursor.getString(12)).m73191t(cursor.getString(13)).m73192u(cursor.getString(14)).m73193v(cursor.getString(15)).m73194w(cursor.getString(16));
        return c12168j;
    }

    /* renamed from: e */
    public List<C12168j> m73202e(String str, String str2, String str3) throws C9721b {
        return query("select appId, fpath, fname, fsize, fileType, hash1, hash2, hmac, status, ftime, tarFile, encoded, data1, data2, data3, data4, data5 from app_restore_metainfo where appId = ? and fname = ? and fileType = ? and status in (0, 1);", new String[]{str, str2, str3});
    }

    /* renamed from: f */
    public List<C12168j> m73203f(String str, int i10) throws C9721b {
        return query("select appId, fpath, fname, fsize, fileType, hash1, hash2, hmac, status, ftime, tarFile, encoded, data1, data2, data3, data4, data5 from app_restore_metainfo where appId = ? and fileType = ?;", new String[]{str, String.valueOf(i10)});
    }

    /* renamed from: g */
    public int m73204g(String str) throws C9721b {
        Cursor cursorRawQuery = rawQuery("select count(*) from app_restore_metainfo where appId = ?;", new String[]{str});
        if (cursorRawQuery != null) {
            try {
                if (cursorRawQuery.moveToFirst()) {
                    int i10 = cursorRawQuery.getInt(0);
                    cursorRawQuery.close();
                    return i10;
                }
            } catch (Throwable th2) {
                if (cursorRawQuery != null) {
                    try {
                        cursorRawQuery.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
        throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "restore metadata count error.", "queryMetasSizeByAppId");
    }

    /* renamed from: h */
    public int m73205h(String str, int i10) throws C9721b {
        Cursor cursorRawQuery = rawQuery("select count(*) from app_restore_metainfo where appId = ? and fileType = ? and status in(0, 1);", new String[]{str, String.valueOf(i10)});
        if (cursorRawQuery != null) {
            try {
                if (cursorRawQuery.moveToFirst()) {
                    int i11 = cursorRawQuery.getInt(0);
                    cursorRawQuery.close();
                    return i11;
                }
            } catch (Throwable th2) {
                if (cursorRawQuery != null) {
                    try {
                        cursorRawQuery.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
        throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "restore metadata count error.", "queryMetasSizeByAppId");
    }

    /* renamed from: i */
    public int m73206i(String str, int i10) throws C9721b {
        Cursor cursorRawQuery = rawQuery("select count(*) from (select fname from app_restore_metainfo where appId = ? and fileType = ? and status in (0, 1) group by fname);", new String[]{str, String.valueOf(i10)});
        if (cursorRawQuery != null) {
            try {
                if (cursorRawQuery.moveToFirst()) {
                    int i11 = cursorRawQuery.getInt(0);
                    cursorRawQuery.close();
                    return i11;
                }
            } catch (Throwable th2) {
                if (cursorRawQuery != null) {
                    try {
                        cursorRawQuery.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
        throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "restore metadata count error.", "queryMetasSizeByAppId");
    }

    /* renamed from: j */
    public long[] m73207j(String str, int i10) throws C9721b {
        Cursor cursorRawQuery = rawQuery("select count(*), sum(fsize) from app_restore_metainfo where appId = ? and fileType = ? and status = 2;", new String[]{str, String.valueOf(i10)});
        if (cursorRawQuery != null) {
            try {
                if (cursorRawQuery.moveToFirst()) {
                    long[] jArr = {cursorRawQuery.getLong(0), cursorRawQuery.getLong(1)};
                    cursorRawQuery.close();
                    return jArr;
                }
            } catch (Throwable th2) {
                if (cursorRawQuery != null) {
                    try {
                        cursorRawQuery.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
        throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "restore metadata count error.", "queryMetasSizeByAppId");
    }

    /* renamed from: k */
    public C12168j m73208k() throws C9721b {
        List<C12168j> listQuery = query("select appId, fpath, fname, fsize, fileType, hash1, hash2, hmac, status, ftime, tarFile, encoded, data1, data2, data3, data4, data5 from app_restore_metainfo where appId = ? and fpath like '%gallery.db';", new String[]{HNConstants.DataType.MEDIA});
        if (listQuery.isEmpty()) {
            return null;
        }
        return listQuery.get(0);
    }

    /* renamed from: l */
    public List<C12168j> m73209l(String str, int i10, int i11, int i12) throws C9721b {
        return query("select appId, fpath, fname, fsize, fileType, hash1, hash2, hmac, status, ftime, tarFile, encoded, data1, data2, data3, data4, data5 from app_restore_metainfo where appId = ? and fileType = ? and status in (0, 1) order by fpath limit ? offset ?;", new String[]{str, String.valueOf(i10), String.valueOf(i11), String.valueOf(i12)});
    }

    /* renamed from: m */
    public List<C12168j> m73210m(String str, int i10, int i11, int i12) throws C9721b {
        return query("select appId, fpath, fname, fsize, fileType, hash1, hash2, hmac, status, ftime, tarFile, encoded, data1, data2, data3, data4, data5 from app_restore_metainfo where appId = ? and fileType = ? and status in (0, 1) group by fname order by fpath limit ? offset ?;", new String[]{str, String.valueOf(i10), String.valueOf(i11), String.valueOf(i12)});
    }

    /* renamed from: n */
    public long m73211n() {
        try {
            Cursor cursorRawQuery = rawQuery("SELECT count(fpath) AS result  FROM app_restore_metainfo  WHERE fname IS NOT NULL  AND fname != ''  AND fileType = ?  GROUP BY fname  ORDER BY result desc", new String[]{String.valueOf(7)});
            if (cursorRawQuery != null) {
                try {
                    if (cursorRawQuery.moveToFirst()) {
                        long j10 = cursorRawQuery.getLong(0);
                        cursorRawQuery.close();
                        return j10;
                    }
                } finally {
                }
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            return 0L;
        } catch (C9721b e10) {
            C11839m.m70687e("CloudRestoreMetaOperator", "queryMaxCloudpathTarFileCount" + e10.getMessage());
            return 0L;
        }
    }

    /* renamed from: o */
    public long m73212o(String str) throws C9721b {
        Cursor cursorRawQuery = rawQuery("select sum(fsize) from app_restore_metainfo where appId = ? and fpath like '/sdcard%'", new String[]{str});
        if (cursorRawQuery != null) {
            try {
                if (cursorRawQuery.moveToFirst()) {
                    long j10 = cursorRawQuery.getLong(0);
                    cursorRawQuery.close();
                    return j10;
                }
            } catch (Throwable th2) {
                if (cursorRawQuery != null) {
                    try {
                        cursorRawQuery.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
        throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "restore metadata count error.", "querySdcardSumSize");
    }

    /* renamed from: p */
    public long m73213p(String str) throws C9721b {
        Cursor cursorRawQuery = rawQuery("select sum(fsize) from app_restore_metainfo where appId = ? and fpath like '/usb%'", new String[]{str});
        if (cursorRawQuery != null) {
            try {
                if (cursorRawQuery.moveToFirst()) {
                    long j10 = cursorRawQuery.getLong(0);
                    cursorRawQuery.close();
                    return j10;
                }
            } catch (Throwable th2) {
                if (cursorRawQuery != null) {
                    try {
                        cursorRawQuery.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
        throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "restore metadata count error.", "queryUdiskSumSize");
    }

    /* renamed from: q */
    public void m73214q(C12168j c12168j) throws C9721b {
        execSQL("replace into app_restore_metainfo(appId,fpath,fname,fsize,fileType,hash1,hash2,hmac,status,ftime,tarFile,encoded,data1,data2,data3,data4,data5) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);", getColumns(c12168j));
    }

    /* renamed from: r */
    public void m73215r(List<String[]> list) {
        try {
            execute("update app_restore_metainfo set data1 = ? , data2 = ? where fname = ? and appId = ?;", list);
        } catch (C9721b e10) {
            C11839m.m70689w("CloudRestoreMetaOperator", "update app restore metadata error." + e10.getMessage());
        }
    }

    /* renamed from: s */
    public void m73216s(String str, int i10) throws C9721b {
        execSQL("update app_restore_metainfo set status = ? where appId = ?;", new String[]{String.valueOf(i10), str});
    }

    /* renamed from: t */
    public void m73217t(String str, String str2, int i10) throws C9721b {
        execSQL("update app_restore_metainfo set status = ? where appId = ? and fname = ?;", new String[]{String.valueOf(i10), str, str2});
    }

    /* renamed from: u */
    public void m73218u(String str, String str2, int i10) throws C9721b {
        execSQL("update app_restore_metainfo set status = ? where appId = ? and fpath = ?;", new String[]{String.valueOf(i10), str, str2});
    }

    /* renamed from: v */
    public void m73219v(String str, int i10, int i11) throws C9721b {
        execSQL("update app_restore_metainfo set status = ? where appId = ? and status = ?;", new String[]{String.valueOf(i11), str, String.valueOf(i10)});
    }

    /* renamed from: w */
    public void m73220w() throws C9721b {
        execSQL("update app_restore_metainfo set fileType = 6 where fileType = '';");
    }
}
