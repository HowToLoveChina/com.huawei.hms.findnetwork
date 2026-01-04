package p015ak;

import android.content.ContentValues;
import android.database.SQLException;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.SnapshotDBManager;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import p399jk.AbstractC10896a;

/* renamed from: ak.i0 */
/* loaded from: classes6.dex */
public class C0220i0 extends AbstractC0218h0 {

    /* renamed from: f */
    public static final a[] f815f = {new a(String.class, " TEXT"), new a(Long.class, " INTEGER"), new a(Integer.class, " INTEGER"), new a(Short.class, " INTEGER"), new a(Byte.class, " INTEGER"), new a(Boolean.class, " INTEGER"), new a(Float.class, " REAL"), new a(Double.class, " REAL"), new a(byte[].class, " BLOB")};

    /* renamed from: c */
    public ContentValues f816c = null;

    /* renamed from: d */
    public SQLiteDatabase f817d = null;

    /* renamed from: e */
    public boolean f818e = false;

    /* renamed from: ak.i0$a */
    public static class a {

        /* renamed from: a */
        public Class<?> f819a;

        /* renamed from: b */
        public String f820b;

        public a(Class<?> cls, String str) {
            this.f819a = cls;
            this.f820b = str;
        }
    }

    public C0220i0() {
        this.f812b = SnapshotDBManager.SUFFIX_DATABASE_NAME;
    }

    @Override // p015ak.AbstractC0218h0
    /* renamed from: a */
    public synchronized void mo1452a() {
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("disable:db is null=");
            sb2.append(this.f817d == null);
            AbstractC10896a.m65885d("StoreHandlerSql", sb2.toString());
            SQLiteDatabase sQLiteDatabase = this.f817d;
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
                this.f817d = null;
            }
            if (this.f811a != null) {
                m1455d(this.f811a + "-journal");
            }
            ContentValues contentValues = this.f816c;
            if (contentValues != null) {
                contentValues.clear();
                this.f816c = null;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // p015ak.AbstractC0218h0
    /* renamed from: f */
    public synchronized boolean mo1457f(String str) {
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("enable:db is null=");
            sb2.append(this.f817d == null);
            AbstractC10896a.m65885d("StoreHandlerSql", sb2.toString());
            if (this.f817d != null) {
                AbstractC10896a.m65886e("StoreHandlerSql", "enable: db no null");
                this.f817d.close();
                this.f817d = null;
            }
            if (!str.toLowerCase(Locale.US).endsWith(this.f812b)) {
                str = str + this.f812b;
            }
            try {
                SQLiteDatabase sQLiteDatabaseOpenOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(str, (SQLiteDatabase.CursorFactory) null);
                this.f817d = sQLiteDatabaseOpenOrCreateDatabase;
                if (sQLiteDatabaseOpenOrCreateDatabase == null) {
                    return false;
                }
                this.f816c = new ContentValues();
                this.f811a = str;
                return true;
            } catch (Exception e10) {
                AbstractC10896a.m65886e("StoreHandlerSql", e10.toString());
                return false;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // p015ak.AbstractC0218h0
    /* renamed from: g */
    public synchronized ContentValues[] mo1458g(String str) {
        return m1471o(str, null, null, null, null);
    }

    @Override // p015ak.AbstractC0218h0
    /* renamed from: h */
    public synchronized ContentValues[] mo1459h(String str, String[] strArr, String str2, String[] strArr2, String str3) {
        return m1471o(str, strArr, str2, strArr2, str3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0074 A[Catch: all -> 0x0016, TRY_ENTER, TryCatch #4 {, blocks: (B:3:0x0001, B:5:0x000d, B:15:0x0030, B:28:0x004b, B:46:0x0074, B:47:0x0077, B:37:0x005f, B:42:0x006d), top: B:53:0x0001 }] */
    @Override // p015ak.AbstractC0218h0
    /* renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized java.util.HashSet<java.lang.String> mo1460i(java.lang.String r12) {
        /*
            r11 = this;
            monitor-enter(r11)
            java.util.HashSet r0 = new java.util.HashSet     // Catch: java.lang.Throwable -> L16
            r0.<init>()     // Catch: java.lang.Throwable -> L16
            java.lang.String r9 = "1"
            android.database.sqlite.SQLiteDatabase r1 = r11.f817d     // Catch: java.lang.Throwable -> L16
            r10 = 0
            if (r1 != 0) goto L18
            java.lang.String r12 = "StoreHandlerSql"
            java.lang.String r0 = "readArray is fail, db is null"
            p399jk.AbstractC10896a.m65886e(r12, r0)     // Catch: java.lang.Throwable -> L16
            monitor-exit(r11)
            return r10
        L16:
            r12 = move-exception
            goto L78
        L18:
            r7 = 0
            r8 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r2 = r12
            android.database.Cursor r12 = r1.query(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L52 java.lang.RuntimeException -> L54
            android.database.sqlite.SQLiteCursor r12 = (android.database.sqlite.SQLiteCursor) r12     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L52 java.lang.RuntimeException -> L54
            if (r12 != 0) goto L38
            java.lang.String r0 = "StoreHandlerSql"
            java.lang.String r1 = "cursor is null"
            p399jk.AbstractC10896a.m65886e(r0, r1)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L56 java.lang.RuntimeException -> L64
            if (r12 == 0) goto L33
            r12.close()     // Catch: java.lang.Throwable -> L16
        L33:
            monitor-exit(r11)
            return r10
        L35:
            r0 = move-exception
            r10 = r12
            goto L72
        L38:
            java.lang.String[] r1 = r12.getColumnNames()     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L56 java.lang.RuntimeException -> L64
            if (r1 == 0) goto L4a
            r2 = 0
        L3f:
            int r3 = r1.length     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L56 java.lang.RuntimeException -> L64
            if (r2 >= r3) goto L4b
            r3 = r1[r2]     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L56 java.lang.RuntimeException -> L64
            r0.add(r3)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L56 java.lang.RuntimeException -> L64
            int r2 = r2 + 1
            goto L3f
        L4a:
            r0 = r10
        L4b:
            r12.close()     // Catch: java.lang.Throwable -> L16
            monitor-exit(r11)
            return r0
        L50:
            r0 = move-exception
            goto L72
        L52:
            r12 = r10
            goto L56
        L54:
            r12 = r10
            goto L64
        L56:
            java.lang.String r0 = "StoreHandlerSql"
            java.lang.String r1 = "there is no table "
            p399jk.AbstractC10896a.m65886e(r0, r1)     // Catch: java.lang.Throwable -> L35
            if (r12 == 0) goto L62
            r12.close()     // Catch: java.lang.Throwable -> L16
        L62:
            monitor-exit(r11)
            return r10
        L64:
            java.lang.String r0 = "StoreHandlerSql"
            java.lang.String r1 = "RuntimeException ex."
            p399jk.AbstractC10896a.m65888w(r0, r1)     // Catch: java.lang.Throwable -> L35
            if (r12 == 0) goto L70
            r12.close()     // Catch: java.lang.Throwable -> L16
        L70:
            monitor-exit(r11)
            return r10
        L72:
            if (r10 == 0) goto L77
            r10.close()     // Catch: java.lang.Throwable -> L16
        L77:
            throw r0     // Catch: java.lang.Throwable -> L16
        L78:
            monitor-exit(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: p015ak.C0220i0.mo1460i(java.lang.String):java.util.HashSet");
    }

    @Override // p015ak.AbstractC0218h0
    /* renamed from: j */
    public synchronized int mo1461j(String str, ContentValues contentValues) {
        return m1472p(str, contentValues);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0034 A[Catch: all -> 0x0011, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0009, B:9:0x000d, B:16:0x0030, B:18:0x0034, B:22:0x003f, B:23:0x0042, B:25:0x0046, B:27:0x0051, B:14:0x0014, B:33:0x005e), top: B:38:0x0001, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x005a A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005c A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0046 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // p015ak.AbstractC0218h0
    /* renamed from: k */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized int mo1462k(java.lang.String r6, android.content.ContentValues[] r7) {
        /*
            r5 = this;
            monitor-enter(r5)
            android.database.sqlite.SQLiteDatabase r0 = r5.f817d     // Catch: java.lang.Throwable -> L11
            r1 = 2
            if (r0 == 0) goto L5e
            if (r7 != 0) goto L9
            goto L5e
        L9:
            boolean r2 = r5.f818e     // Catch: java.lang.Throwable -> L11
            if (r2 != 0) goto L2e
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L11 java.lang.Exception -> L13
            goto L2e
        L11:
            r6 = move-exception
            goto L67
        L13:
            r0 = move-exception
            java.lang.String r2 = "StoreHandlerSql"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L11
            r3.<init>()     // Catch: java.lang.Throwable -> L11
            java.lang.String r4 = "write error:"
            r3.append(r4)     // Catch: java.lang.Throwable -> L11
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L11
            r3.append(r0)     // Catch: java.lang.Throwable -> L11
            java.lang.String r0 = r3.toString()     // Catch: java.lang.Throwable -> L11
            p399jk.AbstractC10896a.m65886e(r2, r0)     // Catch: java.lang.Throwable -> L11
        L2e:
            r0 = 0
            r2 = r0
        L30:
            int r3 = r7.length     // Catch: java.lang.Throwable -> L11
            r4 = 1
            if (r0 >= r3) goto L42
            r3 = r7[r0]     // Catch: java.lang.Throwable -> L11
            int r3 = r5.m1472p(r6, r3)     // Catch: java.lang.Throwable -> L11
            if (r2 != 0) goto L3f
            if (r3 != r4) goto L3f
            r2 = r4
        L3f:
            int r0 = r0 + 1
            goto L30
        L42:
            boolean r6 = r5.f818e     // Catch: java.lang.Throwable -> L11
            if (r6 != 0) goto L58
            android.database.sqlite.SQLiteDatabase r6 = r5.f817d     // Catch: java.lang.Throwable -> L11 java.lang.Exception -> L51
            r6.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L11 java.lang.Exception -> L51
            android.database.sqlite.SQLiteDatabase r6 = r5.f817d     // Catch: java.lang.Throwable -> L11 java.lang.Exception -> L51
            r6.endTransaction()     // Catch: java.lang.Throwable -> L11 java.lang.Exception -> L51
            goto L58
        L51:
            java.lang.String r6 = "StoreHandlerSql"
            java.lang.String r7 = "endTransaction Exception"
            p399jk.AbstractC10896a.m65886e(r6, r7)     // Catch: java.lang.Throwable -> L11
        L58:
            if (r2 == 0) goto L5c
            monitor-exit(r5)
            return r4
        L5c:
            monitor-exit(r5)
            return r1
        L5e:
            java.lang.String r6 = "StoreHandlerSql"
            java.lang.String r7 = "write is fail, db is null"
            p399jk.AbstractC10896a.m65886e(r6, r7)     // Catch: java.lang.Throwable -> L11
            monitor-exit(r5)
            return r1
        L67:
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: p015ak.C0220i0.mo1462k(java.lang.String, android.content.ContentValues[]):int");
    }

    /* renamed from: l */
    public final void m1468l(String str, ContentValues contentValues) throws SQLException {
        if (contentValues == null) {
            AbstractC10896a.m65887i("StoreHandlerSql", "creat values is null");
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        AbstractC10896a.m65885d("StoreHandlerSql", "Prepare to create table:" + str);
        sb2.append("CREATE TABLE IF NOT EXISTS " + str + " (");
        Set<Map.Entry<String, Object>> setValueSet = contentValues.valueSet();
        int i10 = 0;
        for (Map.Entry<String, Object> entry : setValueSet) {
            i10++;
            sb2.append(entry.getKey());
            sb2.append(m1470n(entry.getValue()));
            if (i10 < setValueSet.size()) {
                sb2.append(", ");
            } else {
                sb2.append(" ");
            }
        }
        sb2.append(");");
        try {
            this.f817d.execSQL("DROP TABLE IF EXISTS " + str);
            this.f817d.execSQL(sb2.toString());
        } catch (Exception e10) {
            AbstractC10896a.m65886e("StoreHandlerSql", "execSQL error:" + e10.toString());
        }
    }

    /* renamed from: m */
    public final ContentValues m1469m(SQLiteCursor sQLiteCursor) {
        ContentValues contentValues = new ContentValues();
        int columnCount = sQLiteCursor.getColumnCount();
        for (int i10 = 0; i10 < columnCount; i10++) {
            String columnName = sQLiteCursor.getColumnName(i10);
            int type = sQLiteCursor.getType(i10);
            if (type == 0) {
                contentValues.putNull(columnName);
            } else if (type == 1) {
                contentValues.put(columnName, Long.valueOf(sQLiteCursor.getLong(i10)));
            } else if (type == 2) {
                contentValues.put(columnName, Float.valueOf(sQLiteCursor.getFloat(i10)));
            } else if (type == 3) {
                contentValues.put(columnName, sQLiteCursor.getString(i10));
            } else if (type == 4) {
                contentValues.put(columnName, sQLiteCursor.getBlob(i10));
            }
        }
        return contentValues;
    }

    /* renamed from: n */
    public final String m1470n(Object obj) {
        if (obj == null) {
            return " TEXT";
        }
        for (a aVar : f815f) {
            if (aVar.f819a.isInstance(obj)) {
                return aVar.f820b;
            }
        }
        return " TEXT";
    }

    /* renamed from: o */
    public final ContentValues[] m1471o(String str, String[] strArr, String str2, String[] strArr2, String str3) throws Throwable {
        if (this.f817d == null) {
            AbstractC10896a.m65886e("StoreHandlerSql", "readArray is fail, db is null");
            return new ContentValues[0];
        }
        if (TextUtils.isEmpty(str)) {
            AbstractC10896a.m65886e("StoreHandlerSql", "readArray is fail, tableName is null");
            return new ContentValues[0];
        }
        SQLiteCursor sQLiteCursor = null;
        try {
            try {
                SQLiteCursor sQLiteCursor2 = (SQLiteCursor) this.f817d.query(str, strArr, str2, strArr2, null, null, str3);
                if (sQLiteCursor2 != null) {
                    try {
                        if (sQLiteCursor2.moveToFirst()) {
                            ContentValues[] contentValuesArr = new ContentValues[sQLiteCursor2.getCount()];
                            int i10 = 0;
                            do {
                                contentValuesArr[i10] = m1469m(sQLiteCursor2);
                                i10++;
                            } while (sQLiteCursor2.moveToNext());
                            sQLiteCursor2.close();
                            return contentValuesArr;
                        }
                    } catch (RuntimeException unused) {
                        sQLiteCursor = sQLiteCursor2;
                        AbstractC10896a.m65888w("StoreHandlerSql", "readArrayRaw error");
                        ContentValues[] contentValuesArr2 = new ContentValues[0];
                        if (sQLiteCursor != null) {
                            sQLiteCursor.close();
                        }
                        return contentValuesArr2;
                    } catch (Exception e10) {
                        e = e10;
                        sQLiteCursor = sQLiteCursor2;
                        AbstractC10896a.m65886e("StoreHandlerSql", "readArrayRaw error: " + e.toString());
                        ContentValues[] contentValuesArr3 = new ContentValues[0];
                        if (sQLiteCursor != null) {
                            sQLiteCursor.close();
                        }
                        return contentValuesArr3;
                    } catch (Throwable th2) {
                        th = th2;
                        sQLiteCursor = sQLiteCursor2;
                        if (sQLiteCursor != null) {
                            sQLiteCursor.close();
                        }
                        throw th;
                    }
                }
                AbstractC10896a.m65886e("StoreHandlerSql", "cursor is null");
                ContentValues[] contentValuesArr4 = new ContentValues[0];
                if (sQLiteCursor2 != null) {
                    sQLiteCursor2.close();
                }
                return contentValuesArr4;
            } catch (RuntimeException unused2) {
            } catch (Exception e11) {
                e = e11;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* renamed from: p */
    public final int m1472p(String str, ContentValues contentValues) throws SQLException {
        if (this.f817d == null) {
            AbstractC10896a.m65886e("StoreHandlerSql", "write is fail, db is null");
            return 2;
        }
        if (TextUtils.isEmpty(str)) {
            AbstractC10896a.m65886e("StoreHandlerSql", "write is fail, tableName is null");
            return 2;
        }
        if (!this.f816c.containsKey(str)) {
            this.f816c.putNull(str);
            m1468l(str, contentValues);
        }
        try {
            this.f817d.insert(str, null, contentValues);
            return 1;
        } catch (Exception e10) {
            AbstractC10896a.m65886e("StoreHandlerSql", "db.insert error:" + e10.toString());
            return 2;
        }
    }
}
