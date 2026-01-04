package ml;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import fk.C9721b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import p514o9.C11839m;
import p618rm.C12590s0;
import p682ul.C13216j;

/* renamed from: ml.a */
/* loaded from: classes6.dex */
public abstract class AbstractC11478a<T> {
    private static final String ATTACH = "attach database ? as last";
    private static final String BATCH_QUERY_BY_IDS = "SELECT *  FROM %1$s  INNER JOIN index_%2$s ON %1$s.id = index_%2$s.idx  WHERE index_%2$s.id >= ?  AND index_%2$s.id <= ?;";
    private static final String CHECK_IS_HAVE_TABLE = "select sql from sqlite_master where name = ?";
    private static final String CREATE_CACL_TAR_RATIO_TABLE = "create table if not exists t_cacl_tar_refratio(id INTEGER PRIMARY KEY AUTOINCREMENT, tar_ref_ratio REAL NOT NULL, normal_file_sum_size INTEGER DEFAULT 0, zero_file_count INTEGER DEFAULT 0, origin_size INTEGER DEFAULT 0, file_id TEXT NOT NULL, is_new_tar INTEGER, is_cacl_end INTEGER DEFAULT 0);";
    private static final String CREATE_TABLE_IDX = "create table if not exists index_%1$s(id integer not null primary key autoincrement, idx integer not null);";
    private static final String DETACH = "detach database last";
    private static final String DROP_TABLE = "drop table if exists %1$s;";
    private static final String DROP_TABLE_IDX = "drop table if exists index_%1$s;";
    private static final String INSERT_TABLE_IDX = "insert into index_%1$s(idx) %2$s";
    public static final String PRAGMA_INTEGRITY_CHECK = "pragma integrity_check";
    private static final String QUERY_BY_ID = "select * from %1$s where id = (select idx from index_%2$s where id = ?);";
    private static final String QUERY_TABLE_IDX = "select count(*) from index_%1$s;";
    public static final String TABLE_NAME_CACL_TAR_RATIO_TABLE = "t_cacl_tar_refratio";
    private static final String TAG = "BaseOperator";
    private SQLiteDatabase database;

    public AbstractC11478a(SQLiteDatabase sQLiteDatabase) {
        this.database = sQLiteDatabase;
    }

    private List<Pair<String, String>> getAttachedDbs() {
        SQLiteDatabase sQLiteDatabase = this.database;
        if (sQLiteDatabase != null) {
            return sQLiteDatabase.getAttachedDbs();
        }
        C11839m.m70689w(TAG, "getAttachedDbs db is null.");
        return null;
    }

    private String getStackTrace(Exception exc) {
        return C12590s0.m75731C0(exc);
    }

    private boolean isContainsLast(List<Pair<String, String>> list) {
        for (Pair<String, String> pair : list) {
            if (pair != null) {
                C11839m.m70688i(TAG, "isContainsLast: " + ((String) pair.first));
                if ("last".equals(pair.first)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void attach(String str) throws C9721b, SQLException {
        List<Pair<String, String>> attachedDbs = getAttachedDbs();
        if (attachedDbs != null && attachedDbs.size() >= 2) {
            C11839m.m70688i(TAG, "pairs.size() more detach() dbPath = " + str);
            if (isContainsLast(attachedDbs)) {
                detach();
            }
        }
        SQLiteDatabase sQLiteDatabase = this.database;
        if (sQLiteDatabase == null) {
            C11839m.m70689w(TAG, "database is null.");
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "database is null.", "execSQL");
        }
        try {
            sQLiteDatabase.execSQL(ATTACH, new String[]{str});
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "exec sql error." + e10.getMessage());
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "exec sql error. " + e10.getMessage() + " stackTrace: " + getStackTrace(e10), "execSQL");
        }
    }

    public void batch(String str, List<T> list) throws C9721b {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(getColumns(it.next()));
        }
        execute(str, arrayList);
    }

    public List<T> batchQuery(String str, String str2, long j10, long j11) throws C9721b {
        return query(String.format(Locale.ENGLISH, BATCH_QUERY_BY_IDS, str, str2), new String[]{String.valueOf(j10), String.valueOf(j11)});
    }

    public void build(String str, String str2, String[] strArr) throws C9721b {
        Locale locale = Locale.ENGLISH;
        execSQL(String.format(locale, CREATE_TABLE_IDX, str));
        execSQL(String.format(locale, INSERT_TABLE_IDX, str, str2), strArr);
    }

    public void close() {
        C13216j.m79418c(this.database);
    }

    public void createCaclTarRefRatioTable() throws C9721b {
        execSQL(CREATE_CACL_TAR_RATIO_TABLE);
    }

    public void delete(String str, String str2, String[] strArr) throws C9721b {
        SQLiteDatabase sQLiteDatabase = this.database;
        if (sQLiteDatabase == null) {
            C11839m.m70689w(TAG, "database is null.");
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "database is null.", "execSQL");
        }
        try {
            sQLiteDatabase.delete(str, str2, strArr);
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "exec sql error." + e10.getMessage());
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "exec sql error. " + e10.getMessage() + " stackTrace: " + getStackTrace(e10), "delete");
        }
    }

    public void detach() throws C9721b, SQLException {
        SQLiteDatabase sQLiteDatabase = this.database;
        if (sQLiteDatabase == null) {
            C11839m.m70689w(TAG, "database is null.");
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "database is null.", "execSQL");
        }
        try {
            sQLiteDatabase.execSQL(DETACH);
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "exec sql error." + e10.getMessage());
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "exec sql error. " + e10.getMessage() + " stackTrace: " + getStackTrace(e10), "execSQL");
        }
    }

    public void drop(String str) throws C9721b {
        execSQL(String.format(Locale.ENGLISH, DROP_TABLE, str));
    }

    public void dropCaclTarRefRatioTable() throws C9721b {
        drop(TABLE_NAME_CACL_TAR_RATIO_TABLE);
    }

    public void dropIdx(String str) throws C9721b {
        execSQL(String.format(Locale.ENGLISH, DROP_TABLE_IDX, str));
    }

    public void execSQL(String str) throws C9721b {
        SQLiteDatabase sQLiteDatabase = this.database;
        if (sQLiteDatabase == null) {
            C11839m.m70689w(TAG, "database is null.");
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "database is null.", "execSQL");
        }
        try {
            sQLiteDatabase.execSQL(str);
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "exec sql error." + e10.getMessage());
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "exec sql error. " + e10.getMessage() + " stackTrace: " + getStackTrace(e10), "execSQL");
        }
    }

    public void execute(String str, List<String[]> list) throws C9721b {
        SQLiteDatabase sQLiteDatabase = this.database;
        if (sQLiteDatabase == null) {
            C11839m.m70689w(TAG, "database is null.");
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "database is null.", "doTransaction");
        }
        try {
            try {
                sQLiteDatabase.beginTransaction();
                SQLiteStatement sQLiteStatementCompileStatement = this.database.compileStatement(str);
                for (String[] strArr : list) {
                    sQLiteStatementCompileStatement.clearBindings();
                    sQLiteStatementCompileStatement.bindAllArgsAsStrings(strArr);
                    sQLiteStatementCompileStatement.execute();
                }
                this.database.setTransactionSuccessful();
                this.database.endTransaction();
            } catch (Exception e10) {
                C11839m.m70687e(TAG, "database transaction error. " + e10.getMessage());
                throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "database transaction error. " + e10.getMessage() + ", " + getStackTrace(e10), "execute");
            }
        } catch (Throwable th2) {
            this.database.endTransaction();
            throw th2;
        }
    }

    public abstract String[] getColumns(T t10);

    public abstract T getObject(Cursor cursor);

    public boolean integrityCheck() {
        return C13216j.m79430o(this.database);
    }

    public boolean isTableExist(String str) {
        String string = null;
        try {
            Cursor cursorRawQuery = rawQuery(CHECK_IS_HAVE_TABLE, new String[]{str});
            if (cursorRawQuery != null) {
                try {
                    if (cursorRawQuery.moveToFirst()) {
                        string = cursorRawQuery.getString(0);
                    }
                } finally {
                }
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        } catch (C9721b e10) {
            C11839m.m70689w(TAG, "checkAndCreateTable error." + e10.getMessage());
        }
        return !TextUtils.isEmpty(string);
    }

    public List<T> query(String str, String[] strArr) throws C9721b {
        if (this.database == null) {
            C11839m.m70689w(TAG, "rawQuery database is null.");
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "rawQuery database is null.", "rawQuery");
        }
        ArrayList arrayList = new ArrayList();
        Cursor cursorRawQuery = rawQuery(str, strArr);
        if (cursorRawQuery != null) {
            try {
                if (cursorRawQuery.moveToFirst()) {
                    do {
                        arrayList.add(getObject(cursorRawQuery));
                    } while (cursorRawQuery.moveToNext());
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
        if (cursorRawQuery != null) {
            cursorRawQuery.close();
        }
        return arrayList;
    }

    public long queryResult(String str, String[] strArr) throws C9721b {
        SQLiteDatabase sQLiteDatabase = this.database;
        long j10 = 0;
        if (sQLiteDatabase == null) {
            C11839m.m70689w(TAG, "queryResult4Vo db is null");
            return 0L;
        }
        if (str == null) {
            return 0L;
        }
        try {
            Cursor cursorRawQuery = sQLiteDatabase.rawQuery(str, strArr);
            if (cursorRawQuery != null) {
                try {
                    if (cursorRawQuery.moveToFirst()) {
                        j10 = cursorRawQuery.getLong(0);
                    }
                } finally {
                }
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            return j10;
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "catch exception when queryResult" + e10.getMessage());
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "execSQL error. " + e10.getMessage(), "queryResult");
        }
    }

    public List<String> queryResult4List(String str, String[] strArr) throws C9721b {
        if (this.database == null) {
            C11839m.m70689w(TAG, "rawQuery database is null.");
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "rawQuery database is null.", "rawQuery");
        }
        ArrayList arrayList = new ArrayList();
        Cursor cursorRawQuery = rawQuery(str, strArr);
        if (cursorRawQuery != null) {
            try {
                if (cursorRawQuery.moveToFirst()) {
                    do {
                        arrayList.add(cursorRawQuery.getString(0));
                    } while (cursorRawQuery.moveToNext());
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
        if (cursorRawQuery != null) {
            cursorRawQuery.close();
        }
        return arrayList;
    }

    public Cursor rawQuery(String str, String[] strArr) throws C9721b {
        SQLiteDatabase sQLiteDatabase = this.database;
        if (sQLiteDatabase == null) {
            C11839m.m70689w(TAG, "rawQuery database is null.");
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "rawQuery database is null.", "rawQuery");
        }
        try {
            return sQLiteDatabase.rawQuery(str, strArr);
        } catch (Exception e10) {
            C11839m.m70689w(TAG, "rawQuery error: " + e10.toString());
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "rawQuery error." + e10.getMessage() + " stackTrace: " + this.getStackTrace(e10), "rawQuery");
        }
    }

    public void setDatabase(SQLiteDatabase sQLiteDatabase) {
        this.database = sQLiteDatabase;
    }

    public int summary(String str) throws C9721b {
        Cursor cursorRawQuery = rawQuery(String.format(Locale.ENGLISH, QUERY_TABLE_IDX, str), null);
        if (cursorRawQuery != null) {
            try {
                if (cursorRawQuery.moveToFirst()) {
                    int i10 = cursorRawQuery.getInt(0);
                    cursorRawQuery.close();
                    return i10;
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
        if (cursorRawQuery != null) {
            cursorRawQuery.close();
        }
        return 0;
    }

    public void execSQL(String str, String[] strArr) throws C9721b {
        ArrayList arrayList = new ArrayList();
        arrayList.add(strArr);
        execute(str, arrayList);
    }

    public T query(String str, String str2, long j10) throws C9721b {
        List<T> listQuery = query(String.format(Locale.ENGLISH, QUERY_BY_ID, str, str2), new String[]{String.valueOf(j10)});
        if (listQuery.isEmpty()) {
            return null;
        }
        return listQuery.get(0);
    }
}
