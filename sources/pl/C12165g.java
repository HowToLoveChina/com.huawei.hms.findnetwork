package pl;

import android.database.Cursor;
import android.database.SQLException;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.bean.SnapshotBackupMeta;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import fk.C9721b;
import ml.AbstractC11478a;
import p514o9.C11839m;
import p682ul.C13216j;
import p744wl.C13617a;

/* renamed from: pl.g */
/* loaded from: classes6.dex */
public class C12165g extends AbstractC11478a<C12171m> {

    /* renamed from: a */
    public String f56439a;

    /* renamed from: b */
    public String f56440b;

    public C12165g(String str, String str2, int i10, int i11) {
        super(C13216j.m79427l(C13216j.c.SNAPSHOT, C13617a.m81942x(str, str2, i10, i11)));
        this.f56439a = str;
        this.f56440b = str2;
    }

    /* renamed from: a */
    public void m73118a(String str) throws C9721b, SQLException {
        if (TextUtils.isEmpty(this.f56439a) || TextUtils.isEmpty(str)) {
            C11839m.m70687e("CloudBackupMetaDelOperator", "attachHistorySnapshotDB error, recordId or backupId is null.");
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "attachHistorySnapshotDB error, recordId is null.");
        }
        attach(str);
    }

    /* renamed from: b */
    public void m73119b() throws C9721b {
        execSQL("CREATE TABLE IF NOT EXISTS t_temp (id INTEGER PRIMARY KEY AUTOINCREMENT,data TEXT,root TEXT,name TEXT,app_id TEXT NOT NULL,file_id TEXT,type INTEGER,hash1 TEXT,status INTEGER,size INTEGER default 0,cloud_path TEXT,UNIQUE(data,root,app_id));");
        execSQL("CREATE INDEX IF NOT EXISTS idx_fileid_t_temp ON t_temp(file_id);");
        execSQL("REPLACE INTO t_temp(data,root,name,app_id,file_id,type,hash1,status,size,cloud_path) SELECT data,root,name,app_id,file_id,type,hash1,status,size,cloud_path FROM snapshot_data WHERE type in (6,7,8,9);");
    }

    /* renamed from: c */
    public void m73120c() throws C9721b {
        execSQL("CREATE TABLE IF NOT EXISTS t_temp2 (id INTEGER PRIMARY KEY AUTOINCREMENT,data TEXT,root TEXT,name TEXT,app_id TEXT NOT NULL,file_id TEXT,type INTEGER,hash1 TEXT,status INTEGER,size INTEGER default 0,cloud_path TEXT,UNIQUE(data,root,app_id));");
        execSQL("CREATE INDEX IF NOT EXISTS idx_fileid_t_temp ON t_temp2(file_id);");
    }

    /* renamed from: d */
    public void m73121d() throws C9721b {
        C11839m.m70688i("CloudBackupMetaDelOperator", "drop temp and temp2.");
        execSQL("DROP TABLE IF EXISTS t_temp;");
        execSQL("DROP TABLE IF EXISTS t_temp2;");
    }

    @Override // ml.AbstractC11478a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public String[] getColumns(C12171m c12171m) {
        return new String[]{c12171m.m73243d(), c12171m.m73246g(), c12171m.m73245f(), c12171m.m73241b(), c12171m.m73244e(), String.valueOf(c12171m.m73249k()), String.valueOf(c12171m.m73248j()), String.valueOf(c12171m.m73247h()), c12171m.m73242c()};
    }

    @Override // ml.AbstractC11478a
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public C12171m getObject(Cursor cursor) {
        C12171m c12171m = new C12171m();
        c12171m.m73250l(cursor.getString(cursor.getColumnIndex("data")));
        c12171m.m73250l(cursor.getString(cursor.getColumnIndex(SnapshotBackupMeta.DB_ROOT_NODE_APPID)));
        c12171m.m73250l(cursor.getString(cursor.getColumnIndex("name")));
        c12171m.m73250l(cursor.getString(cursor.getColumnIndex("app_id")));
        c12171m.m73252n(cursor.getString(cursor.getColumnIndex("file_id")));
        c12171m.m73255q(cursor.getLong(cursor.getColumnIndex("type")));
        c12171m.m73254p(cursor.getInt(cursor.getColumnIndex("status")));
        c12171m.m73253o(cursor.getLong(cursor.getColumnIndex("size")));
        c12171m.m73251m(cursor.getString(cursor.getColumnIndex("cloud_path")));
        return c12171m;
    }

    /* renamed from: g */
    public long m73124g() throws C9721b {
        Cursor cursorRawQuery = rawQuery("select count(*) from t_temp2 where app_id = ? and type in (6,7,8,9) and cloud_path !='' and cloud_path is not NULL;", new String[]{this.f56440b});
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

    /* renamed from: h */
    public long m73125h() throws C9721b {
        Cursor cursorRawQuery = rawQuery("select count(*) from t_temp where app_id = ? and type in (6,7,8,9) and cloud_path !='' and cloud_path is not NULL;", new String[]{this.f56440b});
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

    /* renamed from: i */
    public long m73126i() throws C9721b {
        Cursor cursorRawQuery = rawQuery("select sum(size) from t_temp where app_id = ? and type in (6,7,8,9) and cloud_path !='' and cloud_path is not NULL;", new String[]{this.f56440b});
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

    /* renamed from: j */
    public long m73127j() throws C9721b {
        Cursor cursorRawQuery = rawQuery("select sum(size) from t_temp2 where app_id = ? and type in (6,7,8,9) and cloud_path !='' and cloud_path is not NULL;", new String[]{this.f56440b});
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

    /* renamed from: k */
    public void m73128k() throws C9721b {
        if (TextUtils.isEmpty(this.f56439a) || TextUtils.isEmpty(this.f56440b)) {
            C11839m.m70687e("CloudBackupMetaDelOperator", "update t_temp2 input empty.");
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "updateV2TableTemp2MetaCache error, recordId or appId is null.");
        }
        execSQL("REPLACE INTO t_temp2(data,root,name,app_id,type,hash1,status,size,cloud_path) SELECT data,root,name,app_id,type,hash1,status,size,cloud_path FROM last.snapshot_data lb WHERE lb.app_id = ? and lb.type in (6,7,8,9);", new String[]{this.f56440b});
    }

    /* renamed from: l */
    public void m73129l() throws C9721b {
        if (TextUtils.isEmpty(this.f56439a) || TextUtils.isEmpty(this.f56440b)) {
            C11839m.m70687e("CloudBackupMetaDelOperator", "update t_temp input empty.");
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "updateV2TempSnapshotMetaCache error, recordId or appId is null.");
        }
        execSQL("update t_temp set (status,cloud_path,type) = (select 6, lb.cloud_path, lb.type from last.snapshot_data lb where (t_temp.data = lb.data) and (t_temp.hash1 = lb.hash1) and (t_temp.app_id = lb.app_id))where exists (select * from last.snapshot_data lb where (t_temp.data = lb.data) and (t_temp.hash1 = lb.hash1) and (t_temp.app_id = ?) and (t_temp.hash2 != '') and (t_temp.hash2 is not null) and (t_temp.app_id = lb.app_id) and (t_temp.status in (0,1,2,3)) and (t_temp.flag not in (1)) and (t_temp.type in (0,1,2,3,6,7,8,9)))", new String[]{this.f56440b});
    }
}
