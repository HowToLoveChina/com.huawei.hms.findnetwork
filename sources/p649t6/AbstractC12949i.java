package p649t6;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import java.util.ArrayList;
import java.util.Iterator;
import p031b7.C1120a;
import p634s6.C12719a;

/* renamed from: t6.i */
/* loaded from: classes2.dex */
public abstract class AbstractC12949i<V> {

    /* renamed from: a */
    public SQLiteDatabase f58996a;

    public AbstractC12949i() {
        this.f58996a = C12719a.m76540a();
    }

    /* renamed from: a */
    public void m77847a(String str, String[] strArr) throws SQLException {
        try {
            if (strArr != null) {
                this.f58996a.execSQL(str, strArr);
            } else {
                this.f58996a.execSQL(str);
            }
        } catch (Exception e10) {
            C1120a.m6676e("Operator", "execSQL database error: " + e10);
        }
    }

    /* renamed from: b */
    public void m77848b(String str, ArrayList<String[]> arrayList) {
        StringBuilder sb2;
        if (str == null || arrayList == null) {
            return;
        }
        try {
            try {
                this.f58996a.beginTransaction();
                SQLiteStatement sQLiteStatementCompileStatement = this.f58996a.compileStatement(str);
                Iterator<String[]> it = arrayList.iterator();
                while (it.hasNext()) {
                    String[] next = it.next();
                    sQLiteStatementCompileStatement.clearBindings();
                    sQLiteStatementCompileStatement.bindAllArgsAsStrings(next);
                    sQLiteStatementCompileStatement.execute();
                }
                this.f58996a.setTransactionSuccessful();
                try {
                    this.f58996a.endTransaction();
                } catch (Exception e10) {
                    e = e10;
                    sb2 = new StringBuilder();
                    sb2.append("endTransaction error:");
                    sb2.append(e.toString());
                    C1120a.m6676e("Operator", sb2.toString());
                }
            } catch (Exception e11) {
                C1120a.m6676e("Operator", "execSQL4Batch database error: " + e11.toString());
                try {
                    this.f58996a.endTransaction();
                } catch (Exception e12) {
                    e = e12;
                    sb2 = new StringBuilder();
                    sb2.append("endTransaction error:");
                    sb2.append(e.toString());
                    C1120a.m6676e("Operator", sb2.toString());
                }
            }
        } catch (Throwable th2) {
            try {
                this.f58996a.endTransaction();
            } catch (Exception e13) {
                C1120a.m6676e("Operator", "endTransaction error:" + e13.toString());
            }
            throw th2;
        }
    }

    /* renamed from: c */
    public abstract V mo77732c(Cursor cursor);

    /* renamed from: d */
    public abstract V mo77733d(Cursor cursor);

    /* renamed from: e */
    public int m77849e(String str, String[] strArr) {
        int i10 = 0;
        if (str == null) {
            return 0;
        }
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = this.f58996a.rawQuery(str, strArr);
                if (cursorRawQuery != null && cursorRawQuery.moveToFirst()) {
                    i10 = cursorRawQuery.getInt(0);
                }
            } catch (Exception e10) {
                C1120a.m6676e("Operator", "queryCount database error: " + e10.toString());
                if (cursorRawQuery != null) {
                }
            }
            return i10;
        } finally {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.util.ArrayList<java.lang.String[]>] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* renamed from: f */
    public ArrayList<String[]> m77850f(String str, String[] strArr) throws Throwable {
        ArrayList arrayList;
        ?? r02 = 0;
        r02 = 0;
        r02 = 0;
        Cursor cursor = null;
        try {
            if (str == null) {
                return null;
            }
            try {
                Cursor cursorRawQuery = this.f58996a.rawQuery(str, strArr);
                if (cursorRawQuery != null) {
                    try {
                        try {
                            if (cursorRawQuery.moveToFirst()) {
                                arrayList = new ArrayList();
                                try {
                                    int columnCount = cursorRawQuery.getColumnCount();
                                    do {
                                        String[] strArr2 = new String[columnCount];
                                        for (int i10 = 0; i10 < columnCount; i10++) {
                                            strArr2[i10] = cursorRawQuery.getString(i10);
                                        }
                                        arrayList.add(strArr2);
                                    } while (cursorRawQuery.moveToNext());
                                    r02 = arrayList;
                                } catch (Exception e10) {
                                    e = e10;
                                    cursor = cursorRawQuery;
                                    C1120a.m6676e("Operator", "queryResult4Arr database error: " + e.toString());
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    r02 = arrayList;
                                    return r02;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            r02 = cursorRawQuery;
                            if (r02 != 0) {
                                r02.close();
                            }
                            throw th;
                        }
                    } catch (Exception e11) {
                        e = e11;
                        arrayList = null;
                    }
                }
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
            } catch (Exception e12) {
                e = e12;
                arrayList = null;
            }
            return r02;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [java.util.ArrayList<V>] */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* renamed from: g */
    public ArrayList<V> m77851g(String str, String[] strArr) throws Throwable {
        ArrayList<V> arrayList;
        Cursor cursor = (ArrayList<V>) null;
        if (str == null) {
            return null;
        }
        try {
            try {
                Cursor cursorRawQuery = this.f58996a.rawQuery(str, strArr);
                ?? r02 = cursor;
                if (cursorRawQuery != null) {
                    try {
                        try {
                            r02 = cursor;
                            if (cursorRawQuery.moveToFirst()) {
                                arrayList = new ArrayList<>();
                                do {
                                    try {
                                        arrayList.add(mo77732c(cursorRawQuery));
                                    } catch (Exception e10) {
                                        e = e10;
                                        cursor = (ArrayList<V>) cursorRawQuery;
                                        C1120a.m6676e("Operator", "queryResult4Vo database error: " + e.toString());
                                        if (cursor != null) {
                                            cursor.close();
                                        }
                                        return arrayList;
                                    }
                                } while (cursorRawQuery.moveToNext());
                                r02 = arrayList;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            cursor = cursorRawQuery;
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw th;
                        }
                    } catch (Exception e11) {
                        e = e11;
                        arrayList = null;
                    }
                }
                if (cursorRawQuery == null) {
                    return (ArrayList<V>) r02;
                }
                cursorRawQuery.close();
                return (ArrayList<V>) r02;
            } catch (Exception e12) {
                e = e12;
                arrayList = null;
                cursor = cursor;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.util.ArrayList<V>] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* renamed from: h */
    public ArrayList<V> m77852h(String str, String[] strArr) throws Throwable {
        ArrayList arrayList;
        Cursor cursor;
        V vMo77732c;
        ?? r02 = (ArrayList<V>) null;
        try {
            if (str == null) {
                return null;
            }
            try {
                Cursor cursorRawQuery = this.f58996a.rawQuery(str, strArr);
                r02 = r02;
                if (cursorRawQuery != null) {
                    try {
                        try {
                            r02 = r02;
                            if (cursorRawQuery.moveToFirst()) {
                                arrayList = new ArrayList();
                                int i10 = 0;
                                do {
                                    if (i10 < 10000) {
                                        try {
                                            vMo77732c = mo77732c(cursorRawQuery);
                                        } catch (Exception e10) {
                                            e = e10;
                                            cursor = (ArrayList<V>) cursorRawQuery;
                                            C1120a.m6676e("Operator", "queryResult4Vo database error: " + e.toString());
                                            if (cursor != null) {
                                                cursor.close();
                                            }
                                            r02 = (ArrayList<V>) arrayList;
                                            return (ArrayList<V>) r02;
                                        }
                                    } else {
                                        vMo77732c = mo77733d(cursorRawQuery);
                                    }
                                    i10++;
                                    arrayList.add(vMo77732c);
                                } while (cursorRawQuery.moveToNext());
                                r02 = (ArrayList<V>) arrayList;
                            }
                        } catch (Exception e11) {
                            e = e11;
                            arrayList = null;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        r02 = cursorRawQuery;
                        if (r02 != 0) {
                            r02.close();
                        }
                        throw th;
                    }
                }
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
            } catch (Exception e12) {
                e = e12;
                arrayList = null;
                cursor = r02;
            }
            return (ArrayList<V>) r02;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public AbstractC12949i(SQLiteDatabase sQLiteDatabase) {
        this.f58996a = sQLiteDatabase;
    }
}
