package p006a5;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.SnapshotDBManager;
import java.util.Map;
import java.util.Set;

/* renamed from: a5.d */
/* loaded from: classes.dex */
public class C0049d extends AbstractC0048c {

    /* renamed from: i */
    public static final a[] f119i = {new a(String.class, " TEXT"), new a(Long.class, " INTEGER"), new a(Integer.class, " INTEGER"), new a(Short.class, " INTEGER"), new a(Byte.class, " INTEGER"), new a(Boolean.class, " INTEGER"), new a(Float.class, " REAL"), new a(Double.class, " REAL"), new a(byte[].class, " BLOB")};

    /* renamed from: f */
    public ContentValues f120f = null;

    /* renamed from: g */
    public SQLiteDatabase f121g = null;

    /* renamed from: h */
    public boolean f122h = false;

    /* renamed from: a5.d$a */
    public static class a {

        /* renamed from: a */
        public Class<?> f123a;

        /* renamed from: b */
        public String f124b;

        public a(Class<?> cls, String str) {
            this.f123a = cls;
            this.f124b = str;
        }
    }

    public C0049d() {
        this.f115a = SnapshotDBManager.SUFFIX_DATABASE_NAME;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0056 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // p006a5.AbstractC0048c
    /* renamed from: B */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized int mo186B(java.lang.String r14, android.content.ContentValues[] r15, android.os.Handler.Callback r16, java.lang.Object r17) {
        /*
            r13 = this;
            r7 = r13
            r0 = r15
            monitor-enter(r13)
            android.database.sqlite.SQLiteDatabase r1 = r7.f121g     // Catch: java.lang.Throwable -> L11
            r8 = 2
            if (r1 != 0) goto L14
            java.lang.String r0 = "StoreHandlerSql"
            java.lang.String r1 = "write is failed, because db is null"
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r0, r1)     // Catch: java.lang.Throwable -> L11
            monitor-exit(r13)
            return r8
        L11:
            r0 = move-exception
            goto L72
        L14:
            boolean r2 = r7.f122h     // Catch: java.lang.Throwable -> L11
            if (r2 != 0) goto L2b
            r1.beginTransaction()     // Catch: java.lang.Throwable -> L11 java.lang.Exception -> L1c android.database.SQLException -> L24
            goto L2b
        L1c:
            java.lang.String r1 = "StoreHandlerSql"
            java.lang.String r2 = "beginTransaction Exception"
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r1, r2)     // Catch: java.lang.Throwable -> L11
            goto L2b
        L24:
            java.lang.String r1 = "StoreHandlerSql"
            java.lang.String r2 = "beginTransaction SQLException"
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r1, r2)     // Catch: java.lang.Throwable -> L11
        L2b:
            int r9 = r0.length     // Catch: java.lang.Throwable -> L11
            r10 = 0
            r1 = r10
        L2e:
            r2 = 1
            if (r1 >= r9) goto L52
            boolean r3 = p006a5.AbstractC0048c.m183q()     // Catch: java.lang.Throwable -> L11
            if (r3 == 0) goto L38
            goto L52
        L38:
            r3 = r0[r1]     // Catch: java.lang.Throwable -> L11
            r11 = r14
            int r3 = r13.mo187C(r14, r3)     // Catch: java.lang.Throwable -> L11
            if (r3 != r2) goto L43
            r2 = r10
            goto L44
        L43:
            r2 = r8
        L44:
            int r12 = r1 + 1
            int r4 = r0.length     // Catch: java.lang.Throwable -> L11
            r1 = r13
            r3 = r12
            r5 = r16
            r6 = r17
            r1.m204w(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L11
            r1 = r12
            goto L2e
        L52:
            boolean r0 = r7.f122h     // Catch: java.lang.Throwable -> L11
            if (r0 != 0) goto L70
            android.database.sqlite.SQLiteDatabase r0 = r7.f121g     // Catch: java.lang.Throwable -> L11 java.lang.Exception -> L61 android.database.SQLException -> L69
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L11 java.lang.Exception -> L61 android.database.SQLException -> L69
            android.database.sqlite.SQLiteDatabase r0 = r7.f121g     // Catch: java.lang.Throwable -> L11 java.lang.Exception -> L61 android.database.SQLException -> L69
            r0.endTransaction()     // Catch: java.lang.Throwable -> L11 java.lang.Exception -> L61 android.database.SQLException -> L69
            goto L70
        L61:
            java.lang.String r0 = "StoreHandlerSql"
            java.lang.String r1 = "endTransaction Exception"
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r0, r1)     // Catch: java.lang.Throwable -> L11
            goto L70
        L69:
            java.lang.String r0 = "StoreHandlerSql"
            java.lang.String r1 = "endTransaction SQLException"
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r0, r1)     // Catch: java.lang.Throwable -> L11
        L70:
            monitor-exit(r13)
            return r2
        L72:
            monitor-exit(r13)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p006a5.C0049d.mo186B(java.lang.String, android.content.ContentValues[], android.os.Handler$Callback, java.lang.Object):int");
    }

    @Override // p006a5.AbstractC0048c
    /* renamed from: C */
    public synchronized int mo187C(String str, ContentValues contentValues) {
        long jInsert;
        if (this.f121g == null) {
            C2111d.m12648d("StoreHandlerSql", "write is failed, because db is null");
            return 2;
        }
        if (!this.f120f.containsKey(str)) {
            if (contentValues == null) {
                C2111d.m12648d("StoreHandlerSql", "write is failed, values is null, can not create table");
                return 2;
            }
            this.f120f.putNull(str);
            if (m207D(str, contentValues) != 0) {
                return 2;
            }
        }
        try {
            jInsert = this.f121g.insert(str, null, contentValues);
        } catch (SQLiteException unused) {
            C2111d.m12648d("StoreHandlerSql", "db.insert Exception");
            jInsert = -1;
        }
        return jInsert != -1 ? 1 : 2;
    }

    /* renamed from: D */
    public final synchronized int m207D(String str, ContentValues contentValues) {
        try {
            int i10 = 2;
            if (!TextUtils.isEmpty(str) && contentValues != null && contentValues.size() != 0) {
                StringBuffer stringBuffer = new StringBuffer("CREATE TABLE IF NOT EXISTS ");
                stringBuffer.append(str);
                stringBuffer.append(" (");
                Set<Map.Entry<String, Object>> setValueSet = contentValues.valueSet();
                int size = setValueSet.size();
                for (Map.Entry<String, Object> entry : setValueSet) {
                    stringBuffer.append(entry.getKey());
                    stringBuffer.append(m209F(entry.getValue()));
                    size--;
                    if (size > 0) {
                        stringBuffer.append(", ");
                    } else {
                        stringBuffer.append(" ");
                    }
                }
                stringBuffer.append(");");
                try {
                    this.f121g.execSQL("DROP TABLE IF EXISTS " + str);
                    this.f121g.execSQL(stringBuffer.toString());
                    i10 = 0;
                } catch (SQLException unused) {
                    C2111d.m12648d("StoreHandlerSql", "execSQL Exception");
                }
                return i10;
            }
            return 2;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: E */
    public final ContentValues m208E(SQLiteCursor sQLiteCursor) {
        ContentValues contentValues = new ContentValues();
        int columnCount = sQLiteCursor.getColumnCount();
        for (int i10 = 0; i10 < columnCount; i10++) {
            String columnName = sQLiteCursor.getColumnName(i10);
            if (sQLiteCursor.isNull(i10)) {
                contentValues.putNull(columnName);
            } else if (sQLiteCursor.getType(i10) == 4) {
                contentValues.put(columnName, sQLiteCursor.getBlob(i10));
            } else if (sQLiteCursor.getType(i10) == 1) {
                contentValues.put(columnName, Long.valueOf(sQLiteCursor.getLong(i10)));
            } else if (sQLiteCursor.getType(i10) == 2) {
                contentValues.put(columnName, Float.valueOf(sQLiteCursor.getFloat(i10)));
            } else if (sQLiteCursor.getType(i10) == 3) {
                contentValues.put(columnName, sQLiteCursor.getString(i10));
            } else {
                C2111d.m12653i("StoreHandlerSql", "cursorToContentValues is else");
            }
        }
        return contentValues;
    }

    /* renamed from: F */
    public final String m209F(Object obj) {
        if (obj == null) {
            return " TEXT";
        }
        for (a aVar : f119i) {
            if (aVar.f123a.isInstance(obj)) {
                return aVar.f124b;
            }
        }
        return " TEXT";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0081 A[Catch: all -> 0x0016, TRY_ENTER, TryCatch #4 {, blocks: (B:3:0x0001, B:5:0x000d, B:15:0x0031, B:25:0x0048, B:49:0x0081, B:50:0x0084, B:35:0x005e, B:40:0x006c, B:45:0x007a), top: B:57:0x0001 }] */
    @Override // p006a5.AbstractC0048c
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized java.util.HashSet<java.lang.String> mo202u(java.lang.String r12) {
        /*
            r11 = this;
            monitor-enter(r11)
            java.util.HashSet r0 = new java.util.HashSet     // Catch: java.lang.Throwable -> L16
            r0.<init>()     // Catch: java.lang.Throwable -> L16
            java.lang.String r9 = "1"
            android.database.sqlite.SQLiteDatabase r1 = r11.f121g     // Catch: java.lang.Throwable -> L16
            r10 = 0
            if (r1 != 0) goto L19
            java.lang.String r12 = "StoreHandlerSql"
            java.lang.String r0 = "readColumnNames is failed, because db is null"
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r12, r0)     // Catch: java.lang.Throwable -> L16
            monitor-exit(r11)
            return r10
        L16:
            r12 = move-exception
            goto L85
        L19:
            r7 = 0
            r8 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r2 = r12
            android.database.Cursor r12 = r1.query(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f java.lang.IllegalArgumentException -> L51 android.database.SQLException -> L53
            android.database.sqlite.SQLiteCursor r12 = (android.database.sqlite.SQLiteCursor) r12     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f java.lang.IllegalArgumentException -> L51 android.database.SQLException -> L53
            if (r12 != 0) goto L39
            java.lang.String r0 = "StoreHandlerSql"
            java.lang.String r1 = "cursor is null"
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r0, r1)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L55 java.lang.IllegalArgumentException -> L63 android.database.SQLException -> L71
            if (r12 == 0) goto L34
            r12.close()     // Catch: java.lang.Throwable -> L16
        L34:
            monitor-exit(r11)
            return r10
        L36:
            r0 = move-exception
            r10 = r12
            goto L7f
        L39:
            java.lang.String[] r1 = r12.getColumnNames()     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L55 java.lang.IllegalArgumentException -> L63 android.database.SQLException -> L71
            if (r1 == 0) goto L47
            java.util.List r1 = java.util.Arrays.asList(r1)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L55 java.lang.IllegalArgumentException -> L63 android.database.SQLException -> L71
            r0.addAll(r1)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L55 java.lang.IllegalArgumentException -> L63 android.database.SQLException -> L71
            goto L48
        L47:
            r0 = r10
        L48:
            r12.close()     // Catch: java.lang.Throwable -> L16
            monitor-exit(r11)
            return r0
        L4d:
            r0 = move-exception
            goto L7f
        L4f:
            r12 = r10
            goto L55
        L51:
            r12 = r10
            goto L63
        L53:
            r12 = r10
            goto L71
        L55:
            java.lang.String r0 = "StoreHandlerSql"
            java.lang.String r1 = "queryBucketDataInternal Exception!"
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r0, r1)     // Catch: java.lang.Throwable -> L36
            if (r12 == 0) goto L61
            r12.close()     // Catch: java.lang.Throwable -> L16
        L61:
            monitor-exit(r11)
            return r10
        L63:
            java.lang.String r0 = "StoreHandlerSql"
            java.lang.String r1 = "queryBucketDataInternal IllegalArgument!"
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r0, r1)     // Catch: java.lang.Throwable -> L36
            if (r12 == 0) goto L6f
            r12.close()     // Catch: java.lang.Throwable -> L16
        L6f:
            monitor-exit(r11)
            return r10
        L71:
            java.lang.String r0 = "StoreHandlerSql"
            java.lang.String r1 = "there is no table"
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r0, r1)     // Catch: java.lang.Throwable -> L36
            if (r12 == 0) goto L7d
            r12.close()     // Catch: java.lang.Throwable -> L16
        L7d:
            monitor-exit(r11)
            return r10
        L7f:
            if (r10 == 0) goto L84
            r10.close()     // Catch: java.lang.Throwable -> L16
        L84:
            throw r0     // Catch: java.lang.Throwable -> L16
        L85:
            monitor-exit(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: p006a5.C0049d.mo202u(java.lang.String):java.util.HashSet");
    }

    @Override // p006a5.C0046a
    /* renamed from: a */
    public synchronized void mo169a() {
        SQLiteDatabase sQLiteDatabase = this.f121g;
        if (sQLiteDatabase == null) {
            return;
        }
        if (!this.f122h) {
            this.f122h = true;
            try {
                try {
                    sQLiteDatabase.beginTransaction();
                } catch (Exception unused) {
                    C2111d.m12648d("StoreHandlerSql", "beginTransaction Exception");
                }
            } catch (SQLException unused2) {
                C2111d.m12648d("StoreHandlerSql", "beginTransaction SQLException");
            }
        }
    }

    @Override // p006a5.C0046a
    /* renamed from: b */
    public synchronized void mo170b() {
        try {
            SQLiteDatabase sQLiteDatabase = this.f121g;
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
                this.f121g = null;
            }
            ContentValues contentValues = this.f120f;
            if (contentValues != null) {
                contentValues.clear();
                this.f120f = null;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // p006a5.C0046a
    /* renamed from: c */
    public synchronized void mo171c() {
        SQLiteDatabase sQLiteDatabase = this.f121g;
        if (sQLiteDatabase == null) {
            return;
        }
        if (this.f122h) {
            this.f122h = false;
            try {
                sQLiteDatabase.setTransactionSuccessful();
                this.f121g.endTransaction();
            } catch (SQLException unused) {
                C2111d.m12648d("StoreHandlerSql", "endTransaction SQLException");
            } catch (Exception unused2) {
                C2111d.m12648d("StoreHandlerSql", "endTransaction Exception");
            }
        }
    }

    @Override // p006a5.C0046a
    /* renamed from: d */
    public synchronized boolean mo172d(String str) {
        try {
            if (this.f121g != null) {
                C2111d.m12648d("StoreHandlerSql", "enable: db is not null");
                this.f121g.close();
                this.f121g = null;
            }
            if (!str.toLowerCase(this.f118d).endsWith(this.f115a)) {
                str = str + this.f115a;
            }
            try {
                try {
                    this.f121g = SQLiteDatabase.openDatabase(str, null, 268435472);
                } catch (Exception unused) {
                    C2111d.m12648d("StoreHandlerSql", "open database Exception");
                    return false;
                }
            } catch (SQLException unused2) {
                C2111d.m12648d("StoreHandlerSql", "open database SQLException");
            }
            if (this.f121g == null) {
                return false;
            }
            this.f120f = new ContentValues();
            this.f116b = str;
            return true;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // p006a5.AbstractC0048c
    /* renamed from: l */
    public synchronized Cursor mo194l(String str, String[] strArr, String str2, String[] strArr2, String str3) throws SQLiteException {
        return this.f121g.query(str, strArr, str2, strArr2, null, null, str3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a1 A[Catch: all -> 0x0015, TRY_ENTER, TRY_LEAVE, TryCatch #2 {, blocks: (B:5:0x0006, B:7:0x000c, B:32:0x0078, B:42:0x0093, B:47:0x00a1, B:66:0x00d2, B:67:0x00d5, B:52:0x00af, B:57:0x00bd, B:62:0x00cb), top: B:73:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00af A[Catch: all -> 0x0015, TRY_ENTER, TRY_LEAVE, TryCatch #2 {, blocks: (B:5:0x0006, B:7:0x000c, B:32:0x0078, B:42:0x0093, B:47:0x00a1, B:66:0x00d2, B:67:0x00d5, B:52:0x00af, B:57:0x00bd, B:62:0x00cb), top: B:73:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00bd A[Catch: all -> 0x0015, TRY_ENTER, TRY_LEAVE, TryCatch #2 {, blocks: (B:5:0x0006, B:7:0x000c, B:32:0x0078, B:42:0x0093, B:47:0x00a1, B:66:0x00d2, B:67:0x00d5, B:52:0x00af, B:57:0x00bd, B:62:0x00cb), top: B:73:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00cb A[Catch: all -> 0x0015, TRY_ENTER, TRY_LEAVE, TryCatch #2 {, blocks: (B:5:0x0006, B:7:0x000c, B:32:0x0078, B:42:0x0093, B:47:0x00a1, B:66:0x00d2, B:67:0x00d5, B:52:0x00af, B:57:0x00bd, B:62:0x00cb), top: B:73:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0065 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // p006a5.AbstractC0048c
    /* renamed from: t */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized android.content.ContentValues[] mo201t(java.lang.String r22, java.lang.String[] r23, java.lang.String r24, java.lang.String[] r25, java.lang.String r26) {
        /*
            Method dump skipped, instructions count: 216
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p006a5.C0049d.mo201t(java.lang.String, java.lang.String[], java.lang.String, java.lang.String[], java.lang.String):android.content.ContentValues[]");
    }

    @Override // p006a5.AbstractC0048c
    /* renamed from: v */
    public synchronized int mo203v(String str) {
        if (this.f121g == null) {
            C2111d.m12648d("StoreHandlerSql", "readTableCount is fail, db is null");
            return 0;
        }
        StringBuffer stringBuffer = new StringBuffer("SELECT COUNT(*) FROM ");
        stringBuffer.append(str);
        Cursor cursor = null;
        try {
            try {
                try {
                    Cursor cursorRawQuery = this.f121g.rawQuery(stringBuffer.toString(), null);
                    if (cursorRawQuery != null && cursorRawQuery.moveToFirst()) {
                        int i10 = cursorRawQuery.getInt(0);
                        cursorRawQuery.close();
                        return i10;
                    }
                    C2111d.m12648d("StoreHandlerSql", "cursor is null");
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    return 0;
                } catch (SQLException unused) {
                    C2111d.m12648d("StoreHandlerSql", "there is no table");
                    if (0 != 0) {
                        cursor.close();
                    }
                    return 0;
                } catch (Exception unused2) {
                    C2111d.m12648d("StoreHandlerSql", "queryBucketDataInternal Exception!");
                    if (0 != 0) {
                        cursor.close();
                    }
                    return 0;
                }
            } catch (IllegalArgumentException unused3) {
                C2111d.m12648d("StoreHandlerSql", "queryBucketDataInternal IllegalArgument!");
                if (0 != 0) {
                    cursor.close();
                }
                return 0;
            }
        } catch (Throwable th2) {
            if (0 != 0) {
                cursor.close();
            }
            throw th2;
        }
    }
}
