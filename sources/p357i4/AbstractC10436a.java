package p357i4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import p308g4.C9878b;
import p384j4.AbstractC10706e;
import p405jt.AbstractC10915a;

/* renamed from: i4.a */
/* loaded from: classes.dex */
public abstract class AbstractC10436a extends SQLiteOpenHelper {

    /* renamed from: b */
    public static final AtomicInteger f50382b = new AtomicInteger();

    /* renamed from: a */
    public SQLiteDatabase f50383a;

    public AbstractC10436a(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i10) {
        super(context, str, cursorFactory, i10);
        this.f50383a = null;
    }

    /* renamed from: A */
    public synchronized int m64169A(String str, String str2, String[] strArr) {
        int iDelete;
        iDelete = 0;
        try {
            iDelete = getWritableDatabase().delete(str, str2, strArr);
            mo56982H();
            Arrays.toString(strArr);
        } catch (Throwable th2) {
            AbstractC10915a.m65978j(mo56982H(), "delete " + th2.getClass().getSimpleName());
        }
        return iDelete;
    }

    /* renamed from: B */
    public synchronized void m64170B(String str, String str2, List<String> list) {
        SQLiteDatabase writableDatabase;
        if (list != null) {
            if (!list.isEmpty()) {
                try {
                    writableDatabase = getWritableDatabase();
                    try {
                        writableDatabase.beginTransaction();
                        Iterator<String> it = list.iterator();
                        while (it.hasNext()) {
                            writableDatabase.delete(str, str2, new String[]{it.next()});
                        }
                        writableDatabase.setTransactionSuccessful();
                        writableDatabase.endTransaction();
                        return;
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
        mo56982H();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0025  */
    /* renamed from: C */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m64171C(java.lang.String r6) throws p308g4.C9878b {
        /*
            r5 = this;
            boolean r0 = r5.m64182u(r6)
            if (r0 == 0) goto L48
            r0 = 1
            r1 = 0
            java.lang.String r2 = "select count(1) as c from sqlite_master where type ='table' and name = ?"
            android.database.sqlite.SQLiteDatabase r5 = r5.f50383a     // Catch: java.lang.Throwable -> L2a
            java.lang.String[] r3 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> L2a
            java.lang.String r4 = r6.trim()     // Catch: java.lang.Throwable -> L2a
            r3[r1] = r4     // Catch: java.lang.Throwable -> L2a
            android.database.Cursor r5 = r5.rawQuery(r2, r3)     // Catch: java.lang.Throwable -> L2a
            boolean r2 = r5.moveToNext()     // Catch: java.lang.Throwable -> L2b
            if (r2 == 0) goto L25
            int r6 = r5.getInt(r1)     // Catch: java.lang.Throwable -> L2b
            if (r6 <= 0) goto L25
            goto L26
        L25:
            r0 = r1
        L26:
            r5.close()
            return r0
        L2a:
            r5 = 0
        L2b:
            g4.b r2 = new g4.b     // Catch: java.lang.Throwable -> L41
            java.util.Locale r3 = java.util.Locale.ENGLISH     // Catch: java.lang.Throwable -> L41
            java.lang.String r4 = "query tableName: %s failed"
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L41
            java.lang.String r6 = r6.trim()     // Catch: java.lang.Throwable -> L41
            r0[r1] = r6     // Catch: java.lang.Throwable -> L41
            java.lang.String r6 = java.lang.String.format(r3, r4, r0)     // Catch: java.lang.Throwable -> L41
            r2.<init>(r6)     // Catch: java.lang.Throwable -> L41
            throw r2     // Catch: java.lang.Throwable -> L41
        L41:
            r6 = move-exception
            if (r5 == 0) goto L47
            r5.close()
        L47:
            throw r6
        L48:
            g4.b r5 = new g4.b
            java.util.Locale r0 = java.util.Locale.ENGLISH
            java.lang.String r6 = r6.trim()
            java.lang.Object[] r6 = new java.lang.Object[]{r6}
            java.lang.String r1 = "tableName: %s is invalid"
            java.lang.String r6 = java.lang.String.format(r0, r1, r6)
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: p357i4.AbstractC10436a.m64171C(java.lang.String):boolean");
    }

    /* renamed from: D */
    public void m64172D(String str) {
        try {
            this.f50383a.execSQL(str);
        } catch (Exception unused) {
            AbstractC10915a.m65978j(mo56982H(), "executeSQL error");
            throw new C9878b("execute sql failed");
        }
    }

    /* renamed from: E */
    public synchronized void m64173E(String str, Object[] objArr) {
        try {
            getWritableDatabase().execSQL(str, objArr);
        } catch (Throwable th2) {
            AbstractC10915a.m65979k(mo56982H(), "update %s", th2.getClass().getSimpleName());
        }
    }

    /* renamed from: F */
    public void m64174F(String str) {
        if (!m64182u(str)) {
            throw new C9878b(String.format(Locale.ENGLISH, "tableName: %s is invalid", str.trim()));
        }
        this.f50383a.execSQL(" ALTER TABLE " + str + " RENAME TO _temp_" + str);
    }

    /* renamed from: G */
    public abstract AbstractC10437b mo56981G();

    /* renamed from: H */
    public abstract String mo56982H();

    /* renamed from: I */
    public synchronized long m64175I(String str, ContentValues contentValues) {
        long jInsertOrThrow;
        try {
            jInsertOrThrow = getWritableDatabase().insertOrThrow(str, null, contentValues);
        } catch (Throwable th2) {
            mo56982H();
            th2.getMessage();
            AbstractC10915a.m65978j(mo56982H(), "insert ex " + th2.getClass().getSimpleName());
            AbstractC10915a.m65977i(3, th2);
            jInsertOrThrow = -1;
        }
        return jInsertOrThrow;
    }

    /* renamed from: J */
    public synchronized void m64176J(List<C10438c> list) {
        if (list != null) {
            if (!list.isEmpty()) {
                SQLiteDatabase sQLiteDatabase = null;
                try {
                    SQLiteDatabase writableDatabase = getWritableDatabase();
                    try {
                        writableDatabase.beginTransaction();
                        for (C10438c c10438c : list) {
                            if (writableDatabase.update(c10438c.m64197c(), c10438c.m64198d(), c10438c.m64200f(), c10438c.m64199e()) <= 0) {
                                writableDatabase.insertOrThrow(c10438c.m64197c(), null, c10438c.m64198d());
                            }
                        }
                        writableDatabase.setTransactionSuccessful();
                        writableDatabase.endTransaction();
                    } catch (Throwable th2) {
                        th = th2;
                        sQLiteDatabase = writableDatabase;
                        try {
                            AbstractC10915a.m65976h(5, mo56982H(), "insertOrUpdate ", th);
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

    /* renamed from: V */
    public abstract boolean mo56983V();

    /* renamed from: X */
    public synchronized Cursor m64177X(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4) {
        return getReadableDatabase().query(str, strArr, str2, strArr2, null, null, str3, str4);
    }

    /* renamed from: Y */
    public synchronized Cursor m64178Y(String str, String[] strArr) {
        return getReadableDatabase().rawQuery(str, strArr);
    }

    /* renamed from: Z */
    public synchronized int m64179Z(String str, ContentValues contentValues, String str2, String[] strArr) {
        int iUpdate;
        try {
            iUpdate = getWritableDatabase().update(str, contentValues, str2, strArr);
        } catch (Throwable th2) {
            AbstractC10915a.m65979k(mo56982H(), "update %s", th2.getClass().getSimpleName());
            mo56982H();
            th2.getMessage();
            iUpdate = 0;
        }
        return iUpdate;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
    public synchronized void close() {
        if (f50382b.decrementAndGet() <= 0) {
            super.close();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        AtomicInteger atomicInteger = f50382b;
        atomicInteger.incrementAndGet();
        this.f50383a = sQLiteDatabase;
        m64181t(false);
        atomicInteger.decrementAndGet();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        AtomicInteger atomicInteger = f50382b;
        atomicInteger.incrementAndGet();
        this.f50383a = sQLiteDatabase;
        m64181t(mo56983V());
        atomicInteger.decrementAndGet();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        AtomicInteger atomicInteger = f50382b;
        atomicInteger.incrementAndGet();
        this.f50383a = sQLiteDatabase;
        m64181t(mo56983V());
        atomicInteger.decrementAndGet();
    }

    /* renamed from: s */
    public synchronized void m64180s() {
        close();
    }

    /* renamed from: t */
    public final void m64181t(boolean z10) {
        try {
            try {
                AbstractC10437b abstractC10437bMo56981G = mo56981G();
                this.f50383a.beginTransaction();
                if (z10) {
                    abstractC10437bMo56981G.m64193f();
                } else {
                    abstractC10437bMo56981G.m64191d();
                }
                abstractC10437bMo56981G.m64194g();
                this.f50383a.setTransactionSuccessful();
            } catch (C9878b unused) {
                AbstractC10915a.m65978j(mo56982H(), "initTables error");
            }
            this.f50383a.endTransaction();
        } catch (Throwable th2) {
            this.f50383a.endTransaction();
            throw th2;
        }
    }

    /* renamed from: u */
    public final boolean m64182u(String str) {
        return mo56981G().m64192e(str);
    }

    /* renamed from: v */
    public void m64183v(String str) {
        if (!m64182u(str)) {
            AbstractC10915a.m65979k(mo56982H(), "tableName: %s is invalid", str);
            return;
        }
        try {
            this.f50383a.execSQL(" DROP TABLE " + str);
        } catch (Exception e10) {
            AbstractC10915a.m65979k(mo56982H(), "delete table: %s fail, exception: %s", str, e10.getClass().getSimpleName());
        }
    }

    /* renamed from: w */
    public synchronized void m64184w(String str, List<String[]> list) {
        SQLiteDatabase writableDatabase;
        if (TextUtils.isEmpty(str) || AbstractC10706e.m65374a(list)) {
            mo56982H();
            return;
        }
        try {
            writableDatabase = getWritableDatabase();
        } catch (Throwable th2) {
            th = th2;
            writableDatabase = null;
        }
        try {
            writableDatabase.beginTransaction();
            SQLiteStatement sQLiteStatementCompileStatement = writableDatabase.compileStatement(str);
            Iterator<String[]> it = list.iterator();
            while (it.hasNext()) {
                sQLiteStatementCompileStatement.bindAllArgsAsStrings(it.next());
                sQLiteStatementCompileStatement.execute();
            }
            writableDatabase.setTransactionSuccessful();
        } catch (Throwable th3) {
            th = th3;
            try {
                mo56982H();
                th.getMessage();
                AbstractC10915a.m65978j(mo56982H(), "execute ex " + th.getClass().getSimpleName());
                AbstractC10915a.m65977i(3, th);
                if (writableDatabase != null) {
                    writableDatabase.endTransaction();
                }
            } catch (Throwable th4) {
                if (writableDatabase != null) {
                    writableDatabase.endTransaction();
                }
                throw th4;
            }
        }
        writableDatabase.endTransaction();
    }

    /* renamed from: x */
    public void m64185x(String str) {
        if (!m64182u(str)) {
            AbstractC10915a.m65979k(mo56982H(), "tableName: %s is invalid", str);
            return;
        }
        try {
            this.f50383a.execSQL(" DROP TABLE _temp_" + str);
        } catch (Exception e10) {
            AbstractC10915a.m65979k(mo56982H(), "delete temp tableName: %s failed, exception: %s", str, e10.getClass().getSimpleName());
        }
    }

    /* renamed from: y */
    public void m64186y() {
        mo56981G().m64189b();
    }

    /* renamed from: z */
    public String[] m64187z(String str) {
        if (!m64182u(str)) {
            throw new C9878b(String.format(Locale.ENGLISH, "tableName: %s is invalid", str.trim()));
        }
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = this.f50383a.rawQuery(" select * from " + str + " order by _id asc LIMIT 1", null);
                cursorRawQuery.moveToNext();
                String[] columnNames = cursorRawQuery.getColumnNames();
                cursorRawQuery.close();
                return columnNames;
            } catch (Exception unused) {
                AbstractC10915a.m65978j(this.mo56982H(), "getColumnNames error");
                throw new C9878b(String.format(Locale.ENGLISH, "get new tableName: %s column names failed", str.trim()));
            }
        } catch (Throwable th2) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th2;
        }
    }
}
