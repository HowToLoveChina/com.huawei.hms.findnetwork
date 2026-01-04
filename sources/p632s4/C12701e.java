package p632s4;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import com.huawei.android.backup.filelogic.utils.C2111d;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import p566q4.C12283b;
import p647t4.C12936b;
import p699v4.C13334c;

/* renamed from: s4.e */
/* loaded from: classes.dex */
public class C12701e {

    /* renamed from: h */
    public static final Object f58240h = new Object();

    /* renamed from: c */
    public C12283b f58243c;

    /* renamed from: d */
    public SQLiteDatabase f58244d;

    /* renamed from: e */
    public String f58245e;

    /* renamed from: a */
    public Map<String, Long> f58241a = new LinkedHashMap();

    /* renamed from: b */
    public Map<String, C12936b> f58242b = new LinkedHashMap();

    /* renamed from: f */
    public long f58246f = 0;

    /* renamed from: g */
    public long f58247g = 0;

    public C12701e(Context context, String str, boolean z10) {
        synchronized (f58240h) {
            try {
                C2111d.m12654j("MediaCacheUtil", "new MediaCacheUtil moduleName", str, ";needClear = ", Boolean.valueOf(z10));
                if (z10) {
                    m76424d(context, str);
                }
                this.f58245e = str;
                C12283b c12283b = new C12283b(context, str);
                this.f58243c = c12283b;
                try {
                    this.f58244d = c12283b.getWritableDatabase();
                } catch (SQLException unused) {
                    C2111d.m12648d("MediaCacheUtil", "get db exception");
                } catch (Exception unused2) {
                    C2111d.m12648d("MediaCacheUtil", "MediaCacheUtil exception");
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: d */
    public static void m76424d(Context context, String str) {
        C2111d.m12654j("MediaCacheUtil", "clear moduleName = ", str);
        File file = new File(C12283b.m73808c(context), C12283b.m73807b(str));
        if (!file.exists() || file.delete()) {
            return;
        }
        C2111d.m12657m("MediaCacheUtil", "delete db file error: " + C13334c.m79991x(file));
    }

    /* renamed from: a */
    public synchronized void m76425a(List<String> list) {
        if (list == null) {
            return;
        }
        for (String str : list) {
            File file = new File(str);
            if (file.isFile() && file.length() >= 0) {
                m76432i(str, file.length());
            }
        }
    }

    /* renamed from: b */
    public synchronized void m76426b(List<String> list) {
        if (list == null) {
            return;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            m76433j(it.next());
        }
    }

    /* renamed from: c */
    public final void m76427c() {
        if (this.f58244d == null) {
            this.f58244d = this.f58243c.getWritableDatabase();
        }
    }

    /* renamed from: e */
    public void m76428e() {
        if (this.f58244d != null) {
            m76429f();
            m76430g();
            this.f58244d.close();
            this.f58244d = null;
        }
    }

    /* renamed from: f */
    public final synchronized void m76429f() {
        Map<String, Long> map;
        C2111d.m12654j("MediaCacheUtil", "commit new, fileMap size ", Integer.valueOf(this.f58241a.size()));
        if (this.f58241a.isEmpty()) {
            return;
        }
        m76427c();
        SQLiteDatabase sQLiteDatabase = this.f58244d;
        if (sQLiteDatabase == null) {
            C2111d.m12648d("MediaCacheUtil", "insertOneRowToNormal db is null");
            return;
        }
        try {
            try {
                try {
                    sQLiteDatabase.beginTransaction();
                    SQLiteStatement sQLiteStatementCompileStatement = this.f58244d.compileStatement("insert into normal_file (filepath, filesize) values (?,?);");
                    SQLiteStatement sQLiteStatementCompileStatement2 = this.f58244d.compileStatement("insert into small_file(filepath, filesize) VALUES (?,?);");
                    for (Map.Entry<String, Long> entry : this.f58241a.entrySet()) {
                        if (entry.getValue().longValue() >= 6291456) {
                            sQLiteStatementCompileStatement.bindString(1, entry.getKey());
                            sQLiteStatementCompileStatement.bindLong(2, entry.getValue().longValue());
                            sQLiteStatementCompileStatement.executeInsert();
                            sQLiteStatementCompileStatement.clearBindings();
                        } else {
                            sQLiteStatementCompileStatement2.bindString(1, entry.getKey());
                            sQLiteStatementCompileStatement2.bindLong(2, entry.getValue().longValue());
                            sQLiteStatementCompileStatement2.executeInsert();
                            sQLiteStatementCompileStatement2.clearBindings();
                        }
                    }
                    this.f58244d.setTransactionSuccessful();
                    try {
                        this.f58244d.endTransaction();
                    } catch (SQLiteException unused) {
                        C2111d.m12648d("MediaCacheUtil", "endTransaction error");
                    }
                    map = this.f58241a;
                } finally {
                }
            } catch (Exception unused2) {
                C2111d.m12648d("MediaCacheUtil", "commit Exception");
                try {
                    this.f58244d.endTransaction();
                } catch (SQLiteException unused3) {
                    C2111d.m12648d("MediaCacheUtil", "endTransaction error");
                }
                map = this.f58241a;
            }
        } catch (SQLException unused4) {
            C2111d.m12648d("MediaCacheUtil", "commit sql exception");
            try {
                this.f58244d.endTransaction();
            } catch (SQLiteException unused5) {
                C2111d.m12648d("MediaCacheUtil", "endTransaction error");
            }
            map = this.f58241a;
        }
        map.clear();
    }

    /* renamed from: g */
    public final synchronized void m76430g() {
        Map<String, C12936b> map;
        C2111d.m12654j("MediaCacheUtil", "commitMedia, fileMap size ", Integer.valueOf(this.f58242b.size()));
        if (this.f58242b.isEmpty()) {
            return;
        }
        m76427c();
        SQLiteDatabase sQLiteDatabase = this.f58244d;
        try {
            if (sQLiteDatabase == null) {
                C2111d.m12648d("MediaCacheUtil", "insertOneRowToNormal db is null");
                return;
            }
            try {
                try {
                    sQLiteDatabase.beginTransaction();
                    SQLiteStatement sQLiteStatementCompileStatement = this.f58244d.compileStatement("insert into normal_file (filepath, filesize, last_modified, duration, bucket_id) values (?,?,?,?,?);");
                    SQLiteStatement sQLiteStatementCompileStatement2 = this.f58244d.compileStatement("insert into small_file (filepath, filesize, last_modified, duration, bucket_id) values (?,?,?,?,?);");
                    Iterator<Map.Entry<String, C12936b>> it = this.f58242b.entrySet().iterator();
                    while (it.hasNext()) {
                        C12936b value = it.next().getValue();
                        if (value.m77667b() >= 6291456) {
                            m76431h(sQLiteStatementCompileStatement, value);
                        } else {
                            m76431h(sQLiteStatementCompileStatement2, value);
                        }
                    }
                    this.f58244d.setTransactionSuccessful();
                    try {
                        this.f58244d.endTransaction();
                    } catch (SQLiteException unused) {
                        C2111d.m12648d("MediaCacheUtil", "endTransaction error");
                    }
                    map = this.f58242b;
                } catch (Exception unused2) {
                    C2111d.m12648d("MediaCacheUtil", "commit media Exception");
                    try {
                        this.f58244d.endTransaction();
                    } catch (SQLiteException unused3) {
                        C2111d.m12648d("MediaCacheUtil", "endTransaction error");
                    }
                    map = this.f58242b;
                }
            } catch (SQLException unused4) {
                C2111d.m12648d("MediaCacheUtil", "commit sql exception");
                try {
                    this.f58244d.endTransaction();
                } catch (SQLiteException unused5) {
                    C2111d.m12648d("MediaCacheUtil", "endTransaction error");
                }
                map = this.f58242b;
            }
            map.clear();
            C2111d.m12653i("MediaCacheUtil", "commitMedia end");
        } finally {
        }
    }

    /* renamed from: h */
    public final void m76431h(SQLiteStatement sQLiteStatement, C12936b c12936b) {
        sQLiteStatement.bindString(1, c12936b.m77673p());
        sQLiteStatement.bindLong(2, c12936b.m77667b());
        sQLiteStatement.bindLong(3, c12936b.m77672k());
        sQLiteStatement.bindLong(4, c12936b.m77670h());
        sQLiteStatement.bindString(5, c12936b.m77669f());
        sQLiteStatement.executeInsert();
        sQLiteStatement.clearBindings();
    }

    /* renamed from: i */
    public synchronized void m76432i(String str, long j10) {
        m76427c();
        if (this.f58244d == null) {
            C2111d.m12648d("MediaCacheUtil", "Db is null");
            return;
        }
        if (!TextUtils.isEmpty(str) && j10 >= 0) {
            this.f58241a.put(str, Long.valueOf(j10));
            if (this.f58241a.size() > 1000) {
                m76429f();
            }
            return;
        }
        C2111d.m12648d("MediaCacheUtil", "insertOneFile fail");
    }

    /* renamed from: j */
    public synchronized void m76433j(String str) {
        m76432i(str, 6291456L);
    }
}
