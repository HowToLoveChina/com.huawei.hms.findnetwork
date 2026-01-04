package pl;

import android.database.Cursor;
import android.database.SQLException;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.script.PmsMetaDBScript;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import fk.C9721b;
import ml.AbstractC11478a;
import p514o9.C11839m;
import p682ul.C13216j;
import p744wl.C13617a;

/* renamed from: pl.d */
/* loaded from: classes6.dex */
public class C12162d extends AbstractC11478a<C12170l> {

    /* renamed from: a */
    public String f56432a;

    /* renamed from: b */
    public String f56433b;

    public C12162d(String str, String str2, int i10, int i11) {
        super(C13216j.m79427l(C13216j.c.SNAPSHOT, C13617a.m81942x(str, str2, i10, i11)));
        this.f56432a = str;
        this.f56433b = str2;
    }

    /* renamed from: a */
    public void m73012a(String str) throws C9721b, SQLException {
        if (TextUtils.isEmpty(this.f56432a) || TextUtils.isEmpty(str)) {
            C11839m.m70687e("CloudBackupMetaDelOperator", "attachHistorySnapshotDB error, recordId or backupId is null.");
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "attachHistorySnapshotDB error, recordId is null.");
        }
        attach(str);
    }

    /* renamed from: b */
    public void m73013b() throws C9721b {
        execSQL("CREATE TABLE IF NOT EXISTS t_del (id INTEGER PRIMARY KEY AUTOINCREMENT,app_id TEXT NOT NULL,file_id TEXT,flag INTEGER default 0,size INTEGER default 0,data1 TEXT,data2 TEXT,data3 TEXT,data4 TEXT,data5 TEXT,data6 TEXT,UNIQUE(app_id, file_id));");
        execSQL("CREATE INDEX IF NOT EXISTS idx_fileid_t_del ON t_del(file_id);");
        execSQL("REPLACE INTO t_del(app_id,file_id,size,data1,data2,data3) SELECT app_id,file_id,size,type,data4,name FROM snapshot_data WHERE file_id is not null and trim(file_id) !='' and assert_id is not null and trim(assert_id) !='' and version_id is not null and trim(version_id) !='';");
        execSQL("DELETE FROM snapshot_data;");
    }

    /* renamed from: c */
    public void m73014c() throws C9721b {
        execSQL("DROP TABLE IF EXISTS t_del;");
    }

    /* renamed from: d */
    public void m73015d() throws C9721b {
        if (TextUtils.isEmpty(this.f56432a) || TextUtils.isEmpty(this.f56433b)) {
            C11839m.m70687e("CloudBackupMetaDelOperator", "findSameDmFileIdByLast error, recordId or appId is null.");
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "findSameDmFileIdByLast error, recordId or appId is null.");
        }
        execSQL("update t_del set flag = 1 where file_id in (select DISTINCT file_id from last.snapshot_data where last.snapshot_data.app_id = ?);", new String[]{this.f56433b});
    }

    /* renamed from: e */
    public void m73016e() throws C9721b {
        if (TextUtils.isEmpty(this.f56432a) || TextUtils.isEmpty(this.f56433b)) {
            C11839m.m70687e("CloudBackupMetaDelOperator", "findSameDmFileIdByLast error, recordId or appId is null.");
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "findSameDmFileIdByLast error, recordId or appId is null.");
        }
        execSQL("update t_del set flag = 1 where file_id in (select DISTINCT file_id from snapshot_data where snapshot_data.app_id = ?);", new String[]{this.f56433b});
    }

    @Override // ml.AbstractC11478a
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public String[] getColumns(C12170l c12170l) {
        String[] strArr = new String[10];
        strArr[0] = c12170l.m73221b();
        strArr[1] = c12170l.m73228j();
        strArr[2] = String.valueOf(c12170l.m73229k());
        strArr[3] = String.valueOf(c12170l.m73230l());
        strArr[4] = c12170l.m73222c();
        strArr[5] = c12170l.m73223d();
        strArr[6] = c12170l.m73224e();
        strArr[6] = c12170l.m73225f();
        strArr[8] = c12170l.m73226g();
        strArr[9] = c12170l.m73227h();
        return strArr;
    }

    @Override // ml.AbstractC11478a
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public C12170l getObject(Cursor cursor) {
        C12170l c12170l = new C12170l();
        c12170l.m73231m(cursor.getString(cursor.getColumnIndex("app_id")));
        c12170l.m73238t(cursor.getString(cursor.getColumnIndex("file_id")));
        c12170l.m73239u(cursor.getInt(cursor.getColumnIndex("flag")));
        c12170l.m73240v(cursor.getLong(cursor.getColumnIndex("size")));
        c12170l.m73232n(cursor.getString(cursor.getColumnIndex("data1")));
        c12170l.m73233o(cursor.getString(cursor.getColumnIndex("data2")));
        c12170l.m73234p(cursor.getString(cursor.getColumnIndex("data3")));
        c12170l.m73235q(cursor.getString(cursor.getColumnIndex("data4")));
        c12170l.m73236r(cursor.getString(cursor.getColumnIndex("data5")));
        c12170l.m73237s(cursor.getString(cursor.getColumnIndex("data6")));
        return c12170l;
    }

    /* renamed from: h */
    public boolean m73019h() {
        try {
            Cursor cursorRawQuery = rawQuery(PmsMetaDBScript.CHECK_TEMP_TABLE_EXIST, new String[]{"t_del"});
            if (cursorRawQuery != null) {
                try {
                    if (cursorRawQuery.moveToFirst()) {
                        if (cursorRawQuery.getInt(0) > 0) {
                            cursorRawQuery.close();
                            return true;
                        }
                    }
                } finally {
                }
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        } catch (C9721b e10) {
            C11839m.m70689w("CloudBackupMetaDelOperator", "check old db tag exists error." + e10.toString());
        }
        return false;
    }

    /* renamed from: i */
    public long m73020i() throws C9721b {
        Cursor cursorRawQuery = rawQuery("select count(distinct file_id) from t_del where app_id = ? and flag != 1;", new String[]{this.f56433b});
        if (cursorRawQuery != null) {
            try {
                if (cursorRawQuery.moveToFirst()) {
                    long j10 = (int) cursorRawQuery.getLong(0);
                    cursorRawQuery.close();
                    return j10;
                }
            } catch (Throwable th2) {
                try {
                    cursorRawQuery.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
        if (cursorRawQuery == null) {
            return 0L;
        }
        cursorRawQuery.close();
        return 0L;
    }

    /* renamed from: j */
    public long m73021j() throws C9721b {
        Cursor cursorRawQuery = rawQuery("select sum(size) from t_del where app_id = ? and flag != 1;", new String[]{this.f56433b});
        if (cursorRawQuery != null) {
            try {
                if (cursorRawQuery.moveToFirst()) {
                    long j10 = cursorRawQuery.getLong(0);
                    cursorRawQuery.close();
                    return j10;
                }
            } catch (Throwable th2) {
                try {
                    cursorRawQuery.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
        if (cursorRawQuery == null) {
            return 0L;
        }
        cursorRawQuery.close();
        return 0L;
    }
}
