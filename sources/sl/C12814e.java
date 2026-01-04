package sl;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import fk.C9721b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ml.AbstractC11478a;
import p514o9.C11839m;
import p682ul.C13216j;

/* renamed from: sl.e */
/* loaded from: classes6.dex */
public class C12814e extends AbstractC11478a<C12813d> {
    /* JADX WARN: Illegal instructions before constructor call */
    public C12814e() throws SQLException {
        C13216j.c cVar = C13216j.c.STATUS;
        super(C13216j.m79427l(cVar, null));
        m76915b(C13216j.m79427l(cVar, null));
    }

    /* renamed from: a */
    public void m76914a() throws C9721b {
        execSQL("delete from t_backup_lost_file_meta");
    }

    /* renamed from: b */
    public final void m76915b(SQLiteDatabase sQLiteDatabase) throws SQLException {
        if (sQLiteDatabase != null) {
            sQLiteDatabase.execSQL("create table if not exists t_backup_lost_file_meta (id INTEGER PRIMARY KEY AUTOINCREMENT,app_id TEXT DEFAULT '',root TEXT DEFAULT '',data TEXT DEFAULT '',uid INTEGER DEFAULT 0,cloud_path TEXT DEFAULT '',file_id TEXT DEFAULT '',hash TEXT DEFAULT '',date_modify INTEGER DEFAULT 0,data1 TEXT DEFAULT '',data2 TEXT DEFAULT '',data3 TEXT DEFAULT '',UNIQUE(file_id, cloud_path));");
        }
    }

    public void batchReplace(List<C12813d> list) throws C9721b {
        if (list == null || list.isEmpty()) {
            C11839m.m70689w("CloudBackupLostFileOperator", "batchReplace fileList empty");
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<C12813d> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(getColumns(it.next()));
        }
        execute("replace into t_backup_lost_file_meta(app_id,root,data,uid,cloud_path,file_id,hash,date_modify,data1,data2,data3) VALUES(?,?,?,?,?,?,?,?,?,?,?);", arrayList);
    }

    @Override // ml.AbstractC11478a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public String[] getColumns(C12813d c12813d) {
        return new String[]{c12813d.m76889a(), c12813d.m76898j(), c12813d.m76891c(), String.valueOf(c12813d.m76899k()), c12813d.m76890b(), c12813d.m76896h(), c12813d.m76897i(), String.valueOf(c12813d.m76895g()), c12813d.m76892d(), c12813d.m76893e(), c12813d.m76894f()};
    }

    public void clear() {
        try {
            m76914a();
        } catch (C9721b e10) {
            C11839m.m70687e("CloudBackupLostFileOperator", "clear error: " + e10.getMessage());
        }
    }

    @Override // ml.AbstractC11478a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C12813d getObject(Cursor cursor) {
        C12813d c12813d = new C12813d();
        c12813d.m76900l(cursor.getString(0));
        c12813d.m76909u(cursor.getString(1));
        c12813d.m76902n(cursor.getString(2));
        c12813d.m76910v(cursor.getInt(3));
        c12813d.m76901m(cursor.getString(4));
        c12813d.m76907s(cursor.getString(5));
        c12813d.m76908t(cursor.getString(6));
        c12813d.m76906r(cursor.getLong(7));
        c12813d.m76903o(cursor.getString(8));
        c12813d.m76904p(cursor.getString(9));
        c12813d.m76905q(cursor.getString(10));
        return c12813d;
    }

    /* renamed from: e */
    public boolean m76918e(String str, String str2, String str3, String str4) {
        String[] strArr = {str, str2, str3, str4};
        boolean z10 = false;
        try {
            Cursor cursorRawQuery = rawQuery("select app_id,root,data,uid,cloud_path,file_id,hash,date_modify,data1,data2,data3 from t_backup_lost_file_meta where root = ? and data = ? and hash in(?,?);", strArr);
            if (cursorRawQuery != null) {
                try {
                    if (cursorRawQuery.moveToFirst()) {
                        if (cursorRawQuery.getCount() > 0) {
                            z10 = true;
                        }
                    }
                } finally {
                }
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        } catch (C9721b e10) {
            C11839m.m70687e("CloudBackupLostFileOperator", "hasResultQueryByModuleIdHash error: " + e10.getMessage());
        }
        C11839m.m70686d("CloudBackupLostFileOperator", "hasResultQueryByModuleIdHash path = " + str2 + " result: " + z10);
        return z10;
    }

    /* renamed from: f */
    public C12813d m76919f(String str) {
        try {
            List<C12813d> listQuery = query("select app_id,root,data,uid,cloud_path,file_id,hash,date_modify,data1,data2,data3 from t_backup_lost_file_meta where cloud_path = ?;", new String[]{str});
            if (listQuery.size() <= 0) {
                return null;
            }
            return listQuery.get(0);
        } catch (C9721b e10) {
            C11839m.m70687e("CloudBackupLostFileOperator", "queryByCloudPath error: " + e10.getMessage());
            return null;
        }
    }

    /* renamed from: g */
    public C12813d m76920g(String str) {
        try {
            List<C12813d> listQuery = query("select app_id,root,data,uid,cloud_path,file_id,hash,date_modify,data1,data2,data3 from t_backup_lost_file_meta where file_id = ?;", new String[]{str});
            if (listQuery.size() <= 0) {
                return null;
            }
            return listQuery.get(0);
        } catch (C9721b e10) {
            C11839m.m70687e("CloudBackupLostFileOperator", "queryByFileId error: " + e10.getMessage());
            return null;
        }
    }

    /* renamed from: h */
    public void m76921h(C12813d c12813d) throws C9721b {
        if (c12813d == null) {
            C11839m.m70689w("CloudBackupLostFileOperator", "null == lostFile");
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(getColumns(c12813d));
        execute("replace into t_backup_lost_file_meta(app_id,root,data,uid,cloud_path,file_id,hash,date_modify,data1,data2,data3) VALUES(?,?,?,?,?,?,?,?,?,?,?);", arrayList);
    }
}
