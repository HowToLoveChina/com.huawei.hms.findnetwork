package com.huawei.android.hicloud.commonlib.util;

import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.huawei.android.hicloud.commonlib.util.DatabaseRepairUtil;
import com.huawei.hms.network.embedded.C5929g4;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import hk.C10278a;
import hk.C10279b;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import p015ak.C0213f;
import p399jk.AbstractC10896a;
import p429kk.C11060c;
import p746wn.C13622a;

/* loaded from: classes3.dex */
public class DatabaseRepairUtil {

    /* renamed from: a */
    public static Map<Integer, CursorFunction<AbstractWindowedCursor, Integer, Object>> f12046a;

    @FunctionalInterface
    public interface CursorFunction<T, P, R> {
        R apply(T t10, P p10);
    }

    /* renamed from: com.huawei.android.hicloud.commonlib.util.DatabaseRepairUtil$b */
    public static class C2775b {

        /* renamed from: a */
        public int f12047a;

        /* renamed from: b */
        public int f12048b;

        /* renamed from: c */
        public Object[] f12049c;

        public C2775b() {
        }
    }

    static {
        HashMap map = new HashMap();
        f12046a = map;
        map.put(0, new CursorFunction() { // from class: o9.d
            @Override // com.huawei.android.hicloud.commonlib.util.DatabaseRepairUtil.CursorFunction
            public final Object apply(Object obj, Object obj2) {
                return DatabaseRepairUtil.m15921k((AbstractWindowedCursor) obj, (Integer) obj2);
            }
        });
        f12046a.put(1, new CursorFunction() { // from class: o9.e
            @Override // com.huawei.android.hicloud.commonlib.util.DatabaseRepairUtil.CursorFunction
            public final Object apply(Object obj, Object obj2) {
                return Integer.valueOf(((AbstractWindowedCursor) obj).getInt(((Integer) obj2).intValue()));
            }
        });
        f12046a.put(2, new CursorFunction() { // from class: o9.f
            @Override // com.huawei.android.hicloud.commonlib.util.DatabaseRepairUtil.CursorFunction
            public final Object apply(Object obj, Object obj2) {
                return Float.valueOf(((AbstractWindowedCursor) obj).getFloat(((Integer) obj2).intValue()));
            }
        });
        f12046a.put(3, new CursorFunction() { // from class: o9.g
            @Override // com.huawei.android.hicloud.commonlib.util.DatabaseRepairUtil.CursorFunction
            public final Object apply(Object obj, Object obj2) {
                return ((AbstractWindowedCursor) obj).getString(((Integer) obj2).intValue());
            }
        });
        f12046a.put(4, new CursorFunction() { // from class: o9.h
            @Override // com.huawei.android.hicloud.commonlib.util.DatabaseRepairUtil.CursorFunction
            public final Object apply(Object obj, Object obj2) {
                return ((AbstractWindowedCursor) obj).getBlob(((Integer) obj2).intValue());
            }
        });
    }

    /* renamed from: b */
    public static void m15912b(SQLiteStatement sQLiteStatement, Object[] objArr, int i10, int i11) {
        int i12 = 0;
        while (i12 < i11) {
            Object obj = objArr[(i10 * i11) + i12];
            i12++;
            if (obj == null) {
                sQLiteStatement.bindNull(i12);
            } else if (obj instanceof String) {
                sQLiteStatement.bindString(i12, (String) obj);
            } else if (obj instanceof Number) {
                if ((obj instanceof Double) || (obj instanceof Float) || (obj instanceof BigDecimal)) {
                    sQLiteStatement.bindDouble(i12, ((Number) obj).doubleValue());
                } else {
                    sQLiteStatement.bindLong(i12, ((Number) obj).longValue());
                }
            } else if (obj instanceof byte[]) {
                sQLiteStatement.bindBlob(i12, (byte[]) obj);
            } else {
                sQLiteStatement.bindString(i12, obj.toString());
            }
        }
    }

    /* renamed from: c */
    public static boolean m15913c(File file, C11060c c11060c) {
        if (file == null || !file.exists()) {
            return true;
        }
        try {
            try {
                SQLiteDatabase sQLiteDatabaseOpenDatabase = SQLiteDatabase.openDatabase(file.getCanonicalPath(), null, HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
                if (m15920j(sQLiteDatabaseOpenDatabase)) {
                    AbstractC10896a.m65885d("DatabaseRepairUtil", "databaseIntegrityCheck is ok, path = " + C10279b.m63452a(file));
                    m15924n(sQLiteDatabaseOpenDatabase);
                    return true;
                }
                String str = "databaseIntegrityCheck corrupt, path = " + C10279b.m63452a(file);
                AbstractC10896a.m65886e("DatabaseRepairUtil", str);
                if (c11060c != null) {
                    c11060c.m66665u("010_1203");
                    c11060c.m66635A(str);
                    C13622a.m81968n(C0213f.m1377a(), c11060c);
                }
                m15924n(sQLiteDatabaseOpenDatabase);
                return false;
            } catch (Exception e10) {
                AbstractC10896a.m65886e("DatabaseRepairUtil", "check exception: " + e10.getMessage());
                m15924n(null);
                return true;
            }
        } catch (Throwable th2) {
            m15924n(null);
            throw th2;
        }
    }

    /* renamed from: d */
    public static void m15914d(SQLiteDatabase sQLiteDatabase, SQLiteDatabase sQLiteDatabase2) {
        AbstractC10896a.m65885d("DatabaseRepairUtil", "copySrcDbToDesDb start");
        sQLiteDatabase.beginTransaction();
        try {
            try {
                List<String> listM15918h = m15918h(sQLiteDatabase, sQLiteDatabase2);
                StringBuilder sb2 = new StringBuilder(128);
                for (String str : listM15918h) {
                    AbstractC10896a.m65885d("DatabaseRepairUtil", "copySrcDbToDesDb start table = " + str);
                    sQLiteDatabase2.execSQL("DELETE FROM " + str);
                    m15915e(sQLiteDatabase, sQLiteDatabase2, str, sb2);
                }
            } catch (Exception e10) {
                AbstractC10896a.m65886e("DatabaseRepairUtil", "copySrcDbToDesDb error" + e10.getMessage());
            }
            AbstractC10896a.m65885d("DatabaseRepairUtil", "copySrcDbToDesDb end");
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    /* renamed from: e */
    public static void m15915e(SQLiteDatabase sQLiteDatabase, SQLiteDatabase sQLiteDatabase2, String str, StringBuilder sb2) throws SQLException {
        int iM15922l = m15922l(sQLiteDatabase, str);
        if (iM15922l <= 0) {
            AbstractC10896a.m65888w("DatabaseRepairUtil", "copyTable count = " + iM15922l + " table = " + str);
            return;
        }
        int i10 = 0;
        while (i10 < iM15922l) {
            C2775b c2775bM15917g = m15917g(sQLiteDatabase, String.format("select * from %1$s limit ? offset ?;", str), new String[]{String.valueOf(3000), String.valueOf(i10)});
            if (c2775bM15917g == null) {
                AbstractC10896a.m65888w("DatabaseRepairUtil", "getData tableData is null");
                return;
            }
            i10 += c2775bM15917g.f12047a;
            sb2.setLength(0);
            sb2.append("INSERT INTO ");
            sb2.append(str);
            sb2.append(" VALUES(");
            for (int i11 = 0; i11 < c2775bM15917g.f12048b; i11++) {
                sb2.append("?,");
            }
            sb2.setCharAt(sb2.length() - 1, C5929g4.f26850l);
            m15919i(sQLiteDatabase2, sb2.toString(), c2775bM15917g.f12049c, c2775bM15917g.f12047a, c2775bM15917g.f12048b);
            AbstractC10896a.m65885d("DatabaseRepairUtil", "copyTable count = " + iM15922l + " table = " + str + " current = " + i10);
        }
    }

    /* renamed from: f */
    public static void m15916f(SQLiteDatabase sQLiteDatabase, SQLiteDatabase sQLiteDatabase2, String str) {
        Cursor cursorRawQuery = sQLiteDatabase.rawQuery("SELECT sql FROM sqlite_master WHERE type='index' AND tbl_name = ? AND (sql != null or sql != '')", new String[]{str});
        while (cursorRawQuery.moveToNext()) {
            try {
                sQLiteDatabase2.execSQL(cursorRawQuery.getString(0));
            } catch (Throwable th2) {
                if (cursorRawQuery != null) {
                    try {
                        cursorRawQuery.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
        cursorRawQuery.close();
    }

    /* renamed from: g */
    public static C2775b m15917g(SQLiteDatabase sQLiteDatabase, String str, String[] strArr) {
        Cursor cursorRawQuery = sQLiteDatabase.rawQuery(str, strArr);
        try {
            int count = cursorRawQuery.getCount();
            if (count <= 0) {
                cursorRawQuery.close();
                return null;
            }
            int columnCount = cursorRawQuery.getColumnCount();
            C2775b c2775b = new C2775b();
            c2775b.f12047a = count;
            c2775b.f12048b = columnCount;
            c2775b.f12049c = new Object[count * columnCount];
            if (cursorRawQuery instanceof AbstractWindowedCursor) {
                AbstractWindowedCursor abstractWindowedCursor = (AbstractWindowedCursor) cursorRawQuery;
                int i10 = 0;
                while (abstractWindowedCursor.moveToNext()) {
                    for (int i11 = 0; i11 < columnCount; i11++) {
                        Object[] objArr = c2775b.f12049c;
                        CursorFunction<AbstractWindowedCursor, Integer, Object> cursorFunction = f12046a.get(Integer.valueOf(abstractWindowedCursor.getType(i11)));
                        Objects.requireNonNull(cursorFunction);
                        objArr[(i10 * columnCount) + i11] = cursorFunction.apply(abstractWindowedCursor, Integer.valueOf(i11));
                    }
                    i10++;
                }
            } else {
                int i12 = 0;
                while (cursorRawQuery.moveToNext()) {
                    for (int i13 = 0; i13 < columnCount; i13++) {
                        c2775b.f12049c[(i12 * columnCount) + i13] = cursorRawQuery.getString(i13);
                    }
                    i12++;
                }
            }
            cursorRawQuery.close();
            return c2775b;
        } catch (Throwable th2) {
            if (cursorRawQuery != null) {
                try {
                    cursorRawQuery.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
            }
            throw th2;
        }
    }

    /* renamed from: h */
    public static List<String> m15918h(SQLiteDatabase sQLiteDatabase, SQLiteDatabase sQLiteDatabase2) {
        Cursor cursorRawQuery = sQLiteDatabase.rawQuery("SELECT name,sql FROM sqlite_master WHERE type='table' AND name!='android_metadata' AND name!='sqlite_sequence'", null);
        try {
            ArrayList arrayList = new ArrayList(cursorRawQuery.getCount());
            while (cursorRawQuery.moveToNext()) {
                arrayList.add(cursorRawQuery.getString(0));
                sQLiteDatabase2.execSQL(cursorRawQuery.getString(1));
                m15916f(sQLiteDatabase, sQLiteDatabase2, cursorRawQuery.getString(0));
            }
            cursorRawQuery.close();
            return arrayList;
        } catch (Throwable th2) {
            if (cursorRawQuery != null) {
                try {
                    cursorRawQuery.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
            }
            throw th2;
        }
    }

    /* renamed from: i */
    public static void m15919i(SQLiteDatabase sQLiteDatabase, String str, Object[] objArr, int i10, int i11) throws SQLException {
        if (objArr == null || i11 <= 0 || i10 <= 0 || objArr.length < i10 * i11) {
            return;
        }
        SQLiteStatement sQLiteStatementCompileStatement = sQLiteDatabase.compileStatement(str);
        for (int i12 = 0; i12 < i10; i12++) {
            try {
                m15912b(sQLiteStatementCompileStatement, objArr, i12, i11);
                try {
                    sQLiteStatementCompileStatement.executeInsert();
                } catch (SQLiteConstraintException e10) {
                    String message = e10.getMessage();
                    Objects.requireNonNull(message);
                    AbstractC10896a.m65886e("DatabaseRepairUtil", message);
                }
                sQLiteStatementCompileStatement.clearBindings();
            } catch (Throwable th2) {
                if (sQLiteStatementCompileStatement != null) {
                    try {
                        sQLiteStatementCompileStatement.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
        if (sQLiteStatementCompileStatement != null) {
            sQLiteStatementCompileStatement.close();
        }
    }

    /* renamed from: j */
    public static boolean m15920j(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase.isOpen()) {
            return sQLiteDatabase.isDatabaseIntegrityOk();
        }
        return true;
    }

    /* renamed from: k */
    public static /* synthetic */ Object m15921k(AbstractWindowedCursor abstractWindowedCursor, Integer num) {
        return null;
    }

    /* renamed from: l */
    public static int m15922l(SQLiteDatabase sQLiteDatabase, String str) {
        try {
            Cursor cursorRawQuery = sQLiteDatabase.rawQuery(String.format("select count(*) from %1$s", str), null);
            if (cursorRawQuery != null) {
                try {
                    if (cursorRawQuery.moveToFirst()) {
                        int i10 = cursorRawQuery.getInt(0);
                        cursorRawQuery.close();
                        return i10;
                    }
                } finally {
                }
            }
            if (cursorRawQuery == null) {
                return -1;
            }
            cursorRawQuery.close();
            return -1;
        } catch (Exception e10) {
            AbstractC10896a.m65886e("DatabaseRepairUtil", "queryCount error " + e10.getMessage());
            return -1;
        }
    }

    /* renamed from: m */
    public static boolean m15923m(File file, C11060c c11060c) throws Throwable {
        SQLiteDatabase sQLiteDatabase;
        SQLiteDatabase sQLiteDatabaseOpenDatabase;
        if (file == null || !file.exists() || c11060c == null) {
            return true;
        }
        SQLiteDatabase sQLiteDatabaseOpenDatabase2 = null;
        try {
            sQLiteDatabaseOpenDatabase = SQLiteDatabase.openDatabase(file.getCanonicalPath(), null, HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
            try {
            } catch (Exception e10) {
                e = e10;
                sQLiteDatabase = null;
                sQLiteDatabaseOpenDatabase2 = sQLiteDatabaseOpenDatabase;
                try {
                    AbstractC10896a.m65886e("DatabaseRepairUtil", "repair exception: " + e.getMessage());
                    c11060c.m66665u("010_1203");
                    c11060c.m66635A(e.getMessage());
                    m15924n(sQLiteDatabaseOpenDatabase2);
                    m15924n(sQLiteDatabase);
                    C13622a.m81968n(C0213f.m1377a(), c11060c);
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    m15924n(sQLiteDatabaseOpenDatabase2);
                    m15924n(sQLiteDatabase);
                    C13622a.m81968n(C0213f.m1377a(), c11060c);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                sQLiteDatabase = null;
                sQLiteDatabaseOpenDatabase2 = sQLiteDatabaseOpenDatabase;
                m15924n(sQLiteDatabaseOpenDatabase2);
                m15924n(sQLiteDatabase);
                C13622a.m81968n(C0213f.m1377a(), c11060c);
                throw th;
            }
        } catch (Exception e11) {
            e = e11;
            sQLiteDatabase = null;
        } catch (Throwable th4) {
            th = th4;
            sQLiteDatabase = null;
        }
        if (m15920j(sQLiteDatabaseOpenDatabase)) {
            AbstractC10896a.m65885d("DatabaseRepairUtil", "databaseIntegrityCheck is ok, path = " + C10279b.m63452a(file));
            c11060c.m66665u("010_200");
            c11060c.m66635A("ok");
            m15924n(sQLiteDatabaseOpenDatabase);
            m15924n(null);
            C13622a.m81968n(C0213f.m1377a(), c11060c);
            return true;
        }
        String str = file.getParent() + File.separator + "temp.db";
        File fileM63442h = C10278a.m63442h(str);
        if (!fileM63442h.exists() || fileM63442h.delete()) {
            sQLiteDatabaseOpenDatabase2 = SQLiteDatabase.openDatabase(str, null, HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
            m15914d(sQLiteDatabaseOpenDatabase, sQLiteDatabaseOpenDatabase2);
            if (fileM63442h.renameTo(file)) {
                m15924n(sQLiteDatabaseOpenDatabase);
                m15924n(sQLiteDatabaseOpenDatabase2);
                C13622a.m81968n(C0213f.m1377a(), c11060c);
                return true;
            }
            c11060c.m66665u("010_1203");
            c11060c.m66635A("desDbFile renameTo srcDbFile error");
        } else {
            c11060c.m66665u("010_1203");
            c11060c.m66635A("delete desDbFile error");
        }
        m15924n(sQLiteDatabaseOpenDatabase);
        m15924n(sQLiteDatabaseOpenDatabase2);
        C13622a.m81968n(C0213f.m1377a(), c11060c);
        return false;
    }

    /* renamed from: n */
    public static void m15924n(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase == null) {
            return;
        }
        try {
            sQLiteDatabase.close();
        } catch (Exception e10) {
            AbstractC10896a.m65886e("DatabaseRepairUtil", "safeDbClose exception: " + e10.getMessage());
        }
    }
}
