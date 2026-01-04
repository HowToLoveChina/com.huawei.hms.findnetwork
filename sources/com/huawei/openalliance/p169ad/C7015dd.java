package com.huawei.openalliance.p169ad;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.huawei.openalliance.p169ad.analysis.C6922c;
import com.huawei.openalliance.p169ad.exception.C7109a;
import com.huawei.openalliance.p169ad.utils.AbstractC7731ae;
import com.huawei.openalliance.p169ad.utils.AbstractC7805cy;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.huawei.openalliance.ad.dd */
/* loaded from: classes8.dex */
public final class C7015dd extends SQLiteOpenHelper {

    /* renamed from: a */
    private static final String f32182a = "dd";

    /* renamed from: d */
    private static C7015dd f32184d;

    /* renamed from: c */
    private SQLiteDatabase f32187c;

    /* renamed from: g */
    private final Context f32188g;

    /* renamed from: b */
    private static AtomicInteger f32183b = new AtomicInteger();

    /* renamed from: e */
    private static final AtomicInteger f32185e = new AtomicInteger(3);

    /* renamed from: f */
    private static final byte[] f32186f = new byte[0];

    /* renamed from: com.huawei.openalliance.ad.dd$1 */
    public class AnonymousClass1 implements DatabaseErrorHandler {

        /* renamed from: a */
        final /* synthetic */ Context f32189a;

        public AnonymousClass1(Context context) {
            context = context;
        }

        @Override // android.database.DatabaseErrorHandler
        public void onCorruption(SQLiteDatabase sQLiteDatabase) {
            try {
                if (C7015dd.f32185e.decrementAndGet() < 0) {
                    AbstractC7185ho.m43817a(C7015dd.f32182a, "try time more three");
                    return;
                }
                AbstractC7185ho.m43818a(C7015dd.f32182a, "reset time %s", C7015dd.f32185e);
                AbstractC7731ae.m47466e(context.getDatabasePath("hiad.db"));
                AbstractC7185ho.m43817a(C7015dd.f32182a, "delete dababases");
                synchronized (C7015dd.f32186f) {
                    C7015dd unused = C7015dd.f32184d = new C7015dd(context);
                    AbstractC7185ho.m43817a(C7015dd.f32182a, "rebuilding databases");
                }
                new C6922c(context).mo39088a("hiad.db", 102, 102, 0, "2100012");
            } catch (Exception unused2) {
                AbstractC7185ho.m43823c(C7015dd.f32182a, "upgrade databases error");
            } finally {
                new C6922c(context).mo39088a("hiad.db", 102, 102, 1, "2100012");
            }
        }
    }

    private C7015dd(Context context) {
        super(context, "hiad.db", null, 102, new DatabaseErrorHandler() { // from class: com.huawei.openalliance.ad.dd.1

            /* renamed from: a */
            final /* synthetic */ Context f32189a;

            public AnonymousClass1(Context context2) {
                context = context2;
            }

            @Override // android.database.DatabaseErrorHandler
            public void onCorruption(SQLiteDatabase sQLiteDatabase) {
                try {
                    if (C7015dd.f32185e.decrementAndGet() < 0) {
                        AbstractC7185ho.m43817a(C7015dd.f32182a, "try time more three");
                        return;
                    }
                    AbstractC7185ho.m43818a(C7015dd.f32182a, "reset time %s", C7015dd.f32185e);
                    AbstractC7731ae.m47466e(context.getDatabasePath("hiad.db"));
                    AbstractC7185ho.m43817a(C7015dd.f32182a, "delete dababases");
                    synchronized (C7015dd.f32186f) {
                        C7015dd unused = C7015dd.f32184d = new C7015dd(context);
                        AbstractC7185ho.m43817a(C7015dd.f32182a, "rebuilding databases");
                    }
                    new C6922c(context).mo39088a("hiad.db", 102, 102, 0, "2100012");
                } catch (Exception unused2) {
                    AbstractC7185ho.m43823c(C7015dd.f32182a, "upgrade databases error");
                } finally {
                    new C6922c(context).mo39088a("hiad.db", 102, 102, 1, "2100012");
                }
            }
        });
        this.f32187c = null;
        this.f32188g = context2;
    }

    /* renamed from: h */
    private boolean m41902h(String str) {
        return C7018dg.m41933a(str);
    }

    /* renamed from: a */
    public synchronized int m41903a(String str, ContentValues contentValues, String str2, String[] strArr) {
        int iUpdate;
        try {
            iUpdate = getWritableDatabase().update(str, contentValues, str2, strArr);
        } catch (Throwable th2) {
            String str3 = f32182a;
            AbstractC7185ho.m43823c(str3, "update " + th2.getClass().getSimpleName());
            AbstractC7185ho.m43818a(str3, "update %s", th2.getMessage());
            iUpdate = 0;
        }
        return iUpdate;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
    public synchronized void close() {
        if (f32183b.decrementAndGet() <= 0) {
            super.close();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x002a  */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m41917e(java.lang.String r8) throws com.huawei.openalliance.p169ad.exception.C7109a {
        /*
            r7 = this;
            java.lang.String r0 = "query tableName: %s failed"
            boolean r1 = r7.m41902h(r8)
            if (r1 == 0) goto L85
            r1 = 1
            r2 = 0
            r3 = 0
            java.lang.String r4 = "select count(1) as c from sqlite_master where type ='table' and name = ?"
            android.database.sqlite.SQLiteDatabase r7 = r7.f32187c     // Catch: java.lang.Throwable -> L28 android.database.CursorIndexOutOfBoundsException -> L2f java.lang.IllegalArgumentException -> L43 android.database.StaleDataException -> L57 java.lang.IllegalStateException -> L6b
            java.lang.String[] r5 = new java.lang.String[r1]     // Catch: java.lang.Throwable -> L28 android.database.CursorIndexOutOfBoundsException -> L2f java.lang.IllegalArgumentException -> L43 android.database.StaleDataException -> L57 java.lang.IllegalStateException -> L6b
            java.lang.String r6 = r8.trim()     // Catch: java.lang.Throwable -> L28 android.database.CursorIndexOutOfBoundsException -> L2f java.lang.IllegalArgumentException -> L43 android.database.StaleDataException -> L57 java.lang.IllegalStateException -> L6b
            r5[r2] = r6     // Catch: java.lang.Throwable -> L28 android.database.CursorIndexOutOfBoundsException -> L2f java.lang.IllegalArgumentException -> L43 android.database.StaleDataException -> L57 java.lang.IllegalStateException -> L6b
            android.database.Cursor r3 = r7.rawQuery(r4, r5)     // Catch: java.lang.Throwable -> L28 android.database.CursorIndexOutOfBoundsException -> L2f java.lang.IllegalArgumentException -> L43 android.database.StaleDataException -> L57 java.lang.IllegalStateException -> L6b
            boolean r7 = r3.moveToNext()     // Catch: java.lang.Throwable -> L28 android.database.CursorIndexOutOfBoundsException -> L2f java.lang.IllegalArgumentException -> L43 android.database.StaleDataException -> L57 java.lang.IllegalStateException -> L6b
            if (r7 == 0) goto L2a
            int r7 = r3.getInt(r2)     // Catch: java.lang.Throwable -> L28 android.database.CursorIndexOutOfBoundsException -> L2f java.lang.IllegalArgumentException -> L43 android.database.StaleDataException -> L57 java.lang.IllegalStateException -> L6b
            if (r7 <= 0) goto L2a
            goto L2b
        L28:
            r7 = move-exception
            goto L7f
        L2a:
            r1 = r2
        L2b:
            r3.close()
            return r1
        L2f:
            com.huawei.openalliance.ad.exception.a r7 = new com.huawei.openalliance.ad.exception.a     // Catch: java.lang.Throwable -> L28
            java.util.Locale r4 = java.util.Locale.ENGLISH     // Catch: java.lang.Throwable -> L28
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L28
            java.lang.String r8 = r8.trim()     // Catch: java.lang.Throwable -> L28
            r1[r2] = r8     // Catch: java.lang.Throwable -> L28
            java.lang.String r8 = java.lang.String.format(r4, r0, r1)     // Catch: java.lang.Throwable -> L28
            r7.<init>(r8)     // Catch: java.lang.Throwable -> L28
            throw r7     // Catch: java.lang.Throwable -> L28
        L43:
            com.huawei.openalliance.ad.exception.a r7 = new com.huawei.openalliance.ad.exception.a     // Catch: java.lang.Throwable -> L28
            java.util.Locale r4 = java.util.Locale.ENGLISH     // Catch: java.lang.Throwable -> L28
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L28
            java.lang.String r8 = r8.trim()     // Catch: java.lang.Throwable -> L28
            r1[r2] = r8     // Catch: java.lang.Throwable -> L28
            java.lang.String r8 = java.lang.String.format(r4, r0, r1)     // Catch: java.lang.Throwable -> L28
            r7.<init>(r8)     // Catch: java.lang.Throwable -> L28
            throw r7     // Catch: java.lang.Throwable -> L28
        L57:
            com.huawei.openalliance.ad.exception.a r7 = new com.huawei.openalliance.ad.exception.a     // Catch: java.lang.Throwable -> L28
            java.util.Locale r4 = java.util.Locale.ENGLISH     // Catch: java.lang.Throwable -> L28
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L28
            java.lang.String r8 = r8.trim()     // Catch: java.lang.Throwable -> L28
            r1[r2] = r8     // Catch: java.lang.Throwable -> L28
            java.lang.String r8 = java.lang.String.format(r4, r0, r1)     // Catch: java.lang.Throwable -> L28
            r7.<init>(r8)     // Catch: java.lang.Throwable -> L28
            throw r7     // Catch: java.lang.Throwable -> L28
        L6b:
            com.huawei.openalliance.ad.exception.a r7 = new com.huawei.openalliance.ad.exception.a     // Catch: java.lang.Throwable -> L28
            java.util.Locale r4 = java.util.Locale.ENGLISH     // Catch: java.lang.Throwable -> L28
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L28
            java.lang.String r8 = r8.trim()     // Catch: java.lang.Throwable -> L28
            r1[r2] = r8     // Catch: java.lang.Throwable -> L28
            java.lang.String r8 = java.lang.String.format(r4, r0, r1)     // Catch: java.lang.Throwable -> L28
            r7.<init>(r8)     // Catch: java.lang.Throwable -> L28
            throw r7     // Catch: java.lang.Throwable -> L28
        L7f:
            if (r3 == 0) goto L84
            r3.close()
        L84:
            throw r7
        L85:
            com.huawei.openalliance.ad.exception.a r7 = new com.huawei.openalliance.ad.exception.a
            java.util.Locale r0 = java.util.Locale.ENGLISH
            java.lang.String r8 = r8.trim()
            java.lang.Object[] r8 = new java.lang.Object[]{r8}
            java.lang.String r1 = "tableName: %s is invalid"
            java.lang.String r8 = java.lang.String.format(r0, r1, r8)
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.C7015dd.m41917e(java.lang.String):boolean");
    }

    /* renamed from: f */
    public void m41918f(String str) throws C7109a, SQLException {
        if (!m41902h(str)) {
            throw new C7109a(String.format(Locale.ENGLISH, "tableName: %s is invalid", str.trim()));
        }
        try {
            this.f32187c.execSQL(" ALTER TABLE " + str + " RENAME TO _temp_" + str);
        } catch (SQLException unused) {
            AbstractC7185ho.m43823c(f32182a, "modifyTableName fail");
            throw new C7109a(String.format(Locale.ENGLISH, "modify tableName: %s name failed", str.trim()));
        } catch (IllegalStateException unused2) {
            AbstractC7185ho.m43823c(f32182a, "modifyTableName fail");
            throw new C7109a(String.format(Locale.ENGLISH, "modify tableName: %s name failed", str.trim()));
        }
    }

    /* renamed from: g */
    public synchronized long m41919g(String str) {
        if (!m41902h(str)) {
            AbstractC7185ho.m43823c(f32182a, "queryCnt fail, table name is not right");
            return 0L;
        }
        try {
            return getReadableDatabase().compileStatement("SELECT COUNT(*) FROM \"" + str + '\"').simpleQueryForLong();
        } catch (Exception unused) {
            AbstractC7185ho.m43823c(f32182a, "queryCnt fail");
            return 0L;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        f32183b.incrementAndGet();
        this.f32187c = sQLiteDatabase;
        m41896a(102, 102);
        f32183b.decrementAndGet();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        f32183b.incrementAndGet();
        this.f32187c = sQLiteDatabase;
        m41896a(i11, i10);
        f32183b.decrementAndGet();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        f32183b.incrementAndGet();
        this.f32187c = sQLiteDatabase;
        m41896a(i11, i10);
        f32183b.decrementAndGet();
    }

    public /* synthetic */ C7015dd(Context context, AnonymousClass1 anonymousClass1) {
        this(context);
    }

    /* renamed from: a */
    public synchronized int m41904a(String str, String str2, List<String> list) {
        SQLiteDatabase writableDatabase;
        int iDelete = 0;
        if (list != null) {
            if (!list.isEmpty()) {
                try {
                    writableDatabase = getWritableDatabase();
                    try {
                        writableDatabase.beginTransaction();
                        Iterator<String> it = list.iterator();
                        while (it.hasNext()) {
                            iDelete += writableDatabase.delete(str, str2, new String[]{it.next()});
                        }
                        writableDatabase.setTransactionSuccessful();
                        writableDatabase.endTransaction();
                        return iDelete;
                    } catch (Throwable th2) {
                        th = th2;
                        if (writableDatabase != null) {
                            writableDatabase.endTransaction();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    writableDatabase = null;
                }
            }
        }
        AbstractC7185ho.m43817a(f32182a, "noting delete, items is empty");
        return 0;
    }

    /* renamed from: b */
    public void m41914b(String str) throws SQLException {
        if (!m41902h(str)) {
            AbstractC7185ho.m43824c(f32182a, "tableName: %s is invalid", str);
            return;
        }
        try {
            this.f32187c.execSQL(" DROP TABLE " + str);
        } catch (Exception e10) {
            AbstractC7185ho.m43824c(f32182a, "delete table: %s fail, exception: %s", str, e10.getClass().getSimpleName());
        }
    }

    /* renamed from: c */
    public void m41915c(String str) throws C7109a, SQLException {
        try {
            this.f32187c.execSQL(str);
        } catch (Exception unused) {
            AbstractC7185ho.m43823c(f32182a, "executeSQL error");
            throw new C7109a("execute sql failed");
        }
    }

    /* renamed from: d */
    public String[] m41916d(String str) throws C7109a {
        if (!m41902h(str)) {
            throw new C7109a(String.format(Locale.ENGLISH, "tableName: %s is invalid", str.trim()));
        }
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = this.f32187c.rawQuery(" select * from " + str + " order by _id asc LIMIT 1", null);
                cursorRawQuery.moveToNext();
                String[] columnNames = cursorRawQuery.getColumnNames();
                cursorRawQuery.close();
                return columnNames;
            } catch (Exception unused) {
                AbstractC7185ho.m43823c(f32182a, "getColumnNames error");
                throw new C7109a(String.format(Locale.ENGLISH, "get new tableName: %s column names failed", str.trim()));
            }
        } catch (Throwable th2) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th2;
        }
    }

    /* renamed from: a */
    public synchronized int m41905a(String str, String str2, String[] strArr) {
        int iDelete;
        try {
            iDelete = getWritableDatabase().delete(str, str2, strArr);
        } catch (Exception e10) {
            String str3 = f32182a;
            AbstractC7185ho.m43823c(str3, "delete " + e10.getClass().getSimpleName());
            AbstractC7185ho.m43818a(str3, "delete %s", e10.getMessage());
            iDelete = 0;
        }
        return iDelete;
    }

    /* renamed from: a */
    public synchronized long m41906a(String str, ContentValues contentValues) {
        long jInsertOrThrow;
        try {
            jInsertOrThrow = getWritableDatabase().insertOrThrow(str, null, contentValues);
        } catch (Throwable th2) {
            String str2 = f32182a;
            AbstractC7185ho.m43823c(str2, "insert " + th2.getClass().getSimpleName());
            AbstractC7185ho.m43818a(str2, "insert %s", th2.getMessage());
            jInsertOrThrow = -1;
        }
        return jInsertOrThrow;
    }

    /* renamed from: a */
    public synchronized long m41907a(String str, List<ContentValues> list) {
        long jInsert;
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                try {
                    writableDatabase.beginTransaction();
                    Iterator<ContentValues> it = list.iterator();
                    jInsert = 0;
                    while (it.hasNext()) {
                        jInsert = writableDatabase.insert(str, null, it.next());
                    }
                    writableDatabase.setTransactionSuccessful();
                    writableDatabase.endTransaction();
                } catch (Exception e10) {
                    e = e10;
                    sQLiteDatabase = writableDatabase;
                    AbstractC7185ho.m43813a(3, f32182a, "batchInsert", e);
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.endTransaction();
                    }
                    jInsert = -1;
                    return jInsert;
                } catch (Throwable th2) {
                    th = th2;
                    sQLiteDatabase = writableDatabase;
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.endTransaction();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e11) {
            e = e11;
        }
        return jInsert;
    }

    /* renamed from: a */
    public synchronized Cursor m41908a(String str, String[] strArr) {
        return getReadableDatabase().rawQuery(str, strArr);
    }

    /* renamed from: a */
    public synchronized Cursor m41909a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4) {
        return getReadableDatabase().query(str, strArr, str2, strArr2, null, null, str3, str4);
    }

    /* renamed from: a */
    public static C7015dd m41894a(Context context) {
        C7015dd c7015dd;
        synchronized (f32186f) {
            try {
                if (f32184d == null) {
                    f32184d = new C7015dd(context.getApplicationContext());
                }
                f32183b.incrementAndGet();
                c7015dd = f32184d;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c7015dd;
    }

    /* renamed from: a */
    public synchronized void m41910a() {
        f32183b.decrementAndGet();
    }

    /* renamed from: a */
    private void m41896a(int i10, int i11) {
        try {
            C7018dg c7018dg = new C7018dg(this);
            this.f32187c.beginTransaction();
            if (m41897a(i11)) {
                c7018dg.m41935a();
            } else {
                c7018dg.m41936b();
            }
            this.f32187c.setTransactionSuccessful();
            this.f32187c.endTransaction();
            new C6922c(this.f32188g).mo39088a("hiad.db", i11, i10, 0, "2100011");
        } catch (Throwable unused) {
            try {
                AbstractC7185ho.m43823c(f32182a, "initTables error");
            } finally {
                this.f32187c.endTransaction();
                new C6922c(this.f32188g).mo39088a("hiad.db", i11, i10, 1, "2100011");
            }
        }
    }

    /* renamed from: a */
    public void m41911a(String str) throws SQLException {
        if (!m41902h(str)) {
            AbstractC7185ho.m43824c(f32182a, "tableName: %s is invalid", str);
            return;
        }
        try {
            this.f32187c.execSQL(" DROP TABLE _temp_" + str);
        } catch (Exception e10) {
            AbstractC7185ho.m43824c(f32182a, "delete temp tableName: %s failed, exception: %s", str, e10.getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    public synchronized void m41912a(String str, ContentValues contentValues, String str2, List<String> list) {
        SQLiteDatabase writableDatabase;
        if (list != null) {
            if (!list.isEmpty()) {
                try {
                    writableDatabase = getWritableDatabase();
                    try {
                        writableDatabase.beginTransaction();
                        Iterator<String> it = list.iterator();
                        while (it.hasNext()) {
                            writableDatabase.update(str, contentValues, str2, new String[]{it.next()});
                        }
                        writableDatabase.setTransactionSuccessful();
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            AbstractC7185ho.m43813a(5, f32182a, "update ", th);
                            if (writableDatabase != null) {
                                writableDatabase.endTransaction();
                            }
                            return;
                        } catch (Throwable th3) {
                            if (writableDatabase != null) {
                                writableDatabase.endTransaction();
                            }
                            throw th3;
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                    writableDatabase = null;
                }
                writableDatabase.endTransaction();
                return;
            }
        }
        AbstractC7185ho.m43817a(f32182a, "nothing update, items is empty");
    }

    /* renamed from: a */
    public synchronized void m41913a(List<C7016de> list) {
        if (list != null) {
            if (!list.isEmpty()) {
                SQLiteDatabase sQLiteDatabase = null;
                try {
                    SQLiteDatabase writableDatabase = getWritableDatabase();
                    try {
                        writableDatabase.beginTransaction();
                        for (C7016de c7016de : list) {
                            if (m41898a(writableDatabase, c7016de)) {
                                writableDatabase.update(c7016de.m41920a(), c7016de.m41930k(), c7016de.m41928i(), c7016de.m41929j());
                            } else {
                                writableDatabase.insertOrThrow(c7016de.m41920a(), null, c7016de.m41930k());
                            }
                        }
                        writableDatabase.setTransactionSuccessful();
                        writableDatabase.endTransaction();
                    } catch (Throwable th2) {
                        th = th2;
                        sQLiteDatabase = writableDatabase;
                        try {
                            AbstractC7185ho.m43813a(5, f32182a, "insertOrUpdate ", th);
                        } finally {
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.endTransaction();
                            }
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }
        }
    }

    /* renamed from: a */
    private boolean m41897a(int i10) {
        return i10 >= 93;
    }

    /* renamed from: a */
    private boolean m41898a(SQLiteDatabase sQLiteDatabase, C7016de c7016de) {
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = sQLiteDatabase.query(c7016de.m41920a(), c7016de.m41921b(), c7016de.m41922c(), c7016de.m41923d(), c7016de.m41924e(), c7016de.m41925f(), c7016de.m41926g(), c7016de.m41927h());
                if (cursorQuery != null) {
                    return cursorQuery.getCount() > 0;
                }
            } catch (Exception unused) {
                AbstractC7185ho.m43826d(f32182a, "query exception");
            }
            return false;
        } finally {
            AbstractC7805cy.m48142a(cursorQuery);
        }
    }
}
