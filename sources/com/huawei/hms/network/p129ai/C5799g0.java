package com.huawei.hms.network.p129ai;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.huawei.hms.framework.common.IoUtils;
import com.huawei.hms.framework.common.Logger;
import java.util.AbstractMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.huawei.hms.network.ai.g0 */
/* loaded from: classes8.dex */
public class C5799g0 implements InterfaceC5798g {

    /* renamed from: d */
    public static final String f25864d = "g0";

    /* renamed from: e */
    public static final String f25865e = "table_ipsort";

    /* renamed from: f */
    public static final String f25866f = "table_record";

    /* renamed from: g */
    public static final String f25867g = "address";

    /* renamed from: h */
    public static final String f25868h = "score";

    /* renamed from: i */
    public static final String f25869i = "count";

    /* renamed from: j */
    public static final String f25870j = "domain";

    /* renamed from: k */
    public static final String f25871k = "ip";

    /* renamed from: l */
    public static final String f25872l = "count";

    /* renamed from: m */
    public static final String f25873m;

    /* renamed from: n */
    public static final String f25874n;

    /* renamed from: o */
    public static final int f25875o = 0;

    /* renamed from: p */
    public static final int f25876p = 1;

    /* renamed from: a */
    public ConcurrentHashMap<String, int[]> f25877a = new ConcurrentHashMap<>();

    /* renamed from: b */
    public Map<String, AbstractMap.SimpleEntry<String, Integer>> f25878b = new ConcurrentHashMap();

    /* renamed from: c */
    public ConcurrentHashMap<String, Integer> f25879c = new ConcurrentHashMap<>();

    static {
        Locale locale = Locale.ENGLISH;
        f25873m = String.format(locale, "create table if not exists %s(%s varchar(128), %s integer, %s integer, primary key (%s))", f25865e, f25867g, "score", "count", f25867g);
        f25874n = String.format(locale, "create table if not exists %s(%s varchar(128), %s integer, %s integer, primary key (%s))", f25866f, "domain", "ip", "count", "domain");
    }

    /* renamed from: h */
    private void m33333h() {
        Cursor cursor = null;
        try {
            Cursor cursorM33262a = C5790c.m33256f().m33262a(f25865e);
            if (cursorM33262a != null) {
                try {
                    int columnIndex = cursorM33262a.getColumnIndex(f25867g);
                    int columnIndex2 = cursorM33262a.getColumnIndex("score");
                    int columnIndex3 = cursorM33262a.getColumnIndex("count");
                    while (cursorM33262a.moveToNext()) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(f25867g, cursorM33262a.getString(columnIndex));
                        contentValues.put("score", Integer.valueOf(cursorM33262a.getInt(columnIndex2)));
                        contentValues.put("count", Integer.valueOf(cursorM33262a.getInt(columnIndex3)));
                        C5790c.m33256f().m33261a(f25865e, contentValues);
                    }
                    if (C5790c.m33256f().m33259a(C5790c.m33256f().m33269c(), f25865e, (String) null, (String[]) null) == 1) {
                        Logger.m32141i(f25864d, "InitModel checkTableIpsortData success");
                    }
                } catch (Throwable unused) {
                    cursor = cursorM33262a;
                    try {
                        Logger.m32138e(f25864d, "meet exception when checkTableIpsortData");
                        return;
                    } finally {
                        IoUtils.close(cursor);
                    }
                }
            }
            IoUtils.close(cursorM33262a);
        } catch (Throwable unused2) {
        }
    }

    @Override // com.huawei.hms.network.p129ai.InterfaceC5798g
    /* renamed from: a */
    public Object mo33237a() {
        return null;
    }

    @Override // com.huawei.hms.network.p129ai.InterfaceC5798g
    /* renamed from: b */
    public Object mo33245b() {
        Cursor cursorM33265a;
        try {
            cursorM33265a = C5790c.m33256f().m33265a(f25865e, null, null, null, null, null, null);
            try {
                int columnIndex = cursorM33265a.getColumnIndex(f25867g);
                int columnIndex2 = cursorM33265a.getColumnIndex("score");
                int columnIndex3 = cursorM33265a.getColumnIndex("count");
                Logger.m32141i(f25864d, "size " + cursorM33265a.getCount());
                while (cursorM33265a.moveToNext()) {
                    this.f25877a.put(cursorM33265a.getString(columnIndex), new int[]{cursorM33265a.getInt(columnIndex2), cursorM33265a.getInt(columnIndex3)});
                }
            } catch (Throwable unused) {
                try {
                    Logger.m32138e(f25864d, "meet exception when getting ip sort model train data");
                    return this.f25877a;
                } finally {
                    IoUtils.close(cursorM33265a);
                }
            }
        } catch (Throwable unused2) {
            cursorM33265a = null;
        }
        return this.f25877a;
    }

    @Override // com.huawei.hms.network.p129ai.InterfaceC5798g
    /* renamed from: c */
    public void mo33246c() {
        m33333h();
        m33337e();
    }

    @Override // com.huawei.hms.network.p129ai.InterfaceC5798g
    /* renamed from: d */
    public void mo33247d() {
    }

    /* renamed from: e */
    public void m33337e() {
        Cursor cursor = null;
        try {
            Cursor cursorM33262a = C5790c.m33256f().m33262a(f25866f);
            if (cursorM33262a != null) {
                try {
                    int columnIndex = cursorM33262a.getColumnIndex("domain");
                    int columnIndex2 = cursorM33262a.getColumnIndex("ip");
                    int columnIndex3 = cursorM33262a.getColumnIndex("count");
                    while (cursorM33262a.moveToNext()) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("domain", cursorM33262a.getString(columnIndex));
                        contentValues.put("ip", cursorM33262a.getString(columnIndex2));
                        contentValues.put("count", Integer.valueOf(cursorM33262a.getInt(columnIndex3)));
                        C5790c.m33256f().m33261a(f25866f, contentValues);
                    }
                    if (C5790c.m33256f().m33259a(C5790c.m33256f().m33269c(), f25866f, (String) null, (String[]) null) == 1) {
                        Logger.m32141i(f25864d, "InitModel checkTableRecordData success");
                    }
                } catch (Throwable unused) {
                    cursor = cursorM33262a;
                    try {
                        Logger.m32138e(f25864d, "meet exception when checkTableRecordData");
                        return;
                    } finally {
                        IoUtils.close(cursor);
                    }
                }
            }
            IoUtils.close(cursorM33262a);
        } catch (Throwable unused2) {
        }
    }

    /* renamed from: f */
    public Map<String, AbstractMap.SimpleEntry<String, Integer>> m33338f() {
        Cursor cursorM33265a;
        Map<String, AbstractMap.SimpleEntry<String, Integer>> map = this.f25878b;
        if (map != null && !map.isEmpty()) {
            return this.f25878b;
        }
        try {
            cursorM33265a = C5790c.m33256f().m33265a(f25866f, null, null, null, null, null, null);
            try {
                int columnIndex = cursorM33265a.getColumnIndex("domain");
                int columnIndex2 = cursorM33265a.getColumnIndex("ip");
                int columnIndex3 = cursorM33265a.getColumnIndex("count");
                Logger.m32141i(f25864d, "size " + cursorM33265a.getCount());
                while (cursorM33265a.moveToNext()) {
                    this.f25878b.put(cursorM33265a.getString(columnIndex), new AbstractMap.SimpleEntry<>(cursorM33265a.getString(columnIndex2), Integer.valueOf(cursorM33265a.getInt(columnIndex3))));
                }
            } catch (Throwable unused) {
                try {
                    Logger.m32138e(f25864d, "meet exception when getting init model train data");
                    return this.f25878b;
                } finally {
                    IoUtils.close(cursorM33265a);
                }
            }
        } catch (Throwable unused2) {
            cursorM33265a = null;
        }
        return this.f25878b;
    }

    /* renamed from: g */
    public ConcurrentHashMap<String, Integer> m33339g() {
        if (!this.f25879c.isEmpty()) {
            return this.f25879c;
        }
        Iterator<Map.Entry<String, AbstractMap.SimpleEntry<String, Integer>>> it = this.f25878b.entrySet().iterator();
        while (it.hasNext()) {
            AbstractMap.SimpleEntry<String, Integer> value = it.next().getValue();
            this.f25879c.put(value.getKey(), value.getValue());
        }
        return this.f25879c;
    }

    @Override // com.huawei.hms.network.p129ai.InterfaceC5798g
    /* renamed from: a */
    public void mo33239a(SQLiteDatabase sQLiteDatabase) throws SQLException {
        m33335b(sQLiteDatabase);
        m33336c(sQLiteDatabase);
    }

    /* renamed from: b */
    public void m33335b(SQLiteDatabase sQLiteDatabase) throws SQLException {
        try {
            Logger.m32141i(f25864d, "Ipsort Model create table");
            sQLiteDatabase.execSQL(f25873m);
        } catch (SQLException unused) {
            Logger.m32138e(f25864d, "execSQL fail on create ipsort model table");
        }
    }

    /* renamed from: c */
    public void m33336c(SQLiteDatabase sQLiteDatabase) throws SQLException {
        try {
            Logger.m32141i(f25864d, "Ipsort Record create table");
            sQLiteDatabase.execSQL(f25874n);
        } catch (SQLException unused) {
            Logger.m32138e(f25864d, "execSQL fail on create ipsort record table");
        }
    }

    @Override // com.huawei.hms.network.p129ai.InterfaceC5798g
    /* renamed from: a */
    public void mo33240a(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
    }

    @Override // com.huawei.hms.network.p129ai.InterfaceC5798g
    /* renamed from: a */
    public void mo33242a(Object obj) {
        SQLiteDatabase sQLiteDatabaseM33270d;
        Map map = obj instanceof Map ? (Map) obj : null;
        if (map == null || (sQLiteDatabaseM33270d = C5790c.m33256f().m33270d()) == null) {
            return;
        }
        try {
            try {
                sQLiteDatabaseM33270d.beginTransaction();
                Logger.m32141i(f25864d, "ipModel ipsort update count:" + map.size());
                C5790c.m33256f().m33260a(f25865e, null, null);
                for (Map.Entry entry : map.entrySet()) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(f25867g, (String) entry.getKey());
                    contentValues.put("score", Integer.valueOf(((int[]) entry.getValue())[0]));
                    contentValues.put("count", Integer.valueOf(((int[]) entry.getValue())[1]));
                    C5790c.m33256f().m33261a(f25865e, contentValues);
                }
                sQLiteDatabaseM33270d.setTransactionSuccessful();
            } finally {
                sQLiteDatabaseM33270d.endTransaction();
            }
        } catch (Throwable unused) {
            Logger.m32145w(f25864d, "Transaction will roll back in update ipModel trainData ");
        }
    }

    /* renamed from: a */
    public void m33334a(Map<String, AbstractMap.SimpleEntry<String, Integer>> map) {
        SQLiteDatabase sQLiteDatabaseM33270d;
        if (map == null || (sQLiteDatabaseM33270d = C5790c.m33256f().m33270d()) == null) {
            return;
        }
        try {
            try {
                sQLiteDatabaseM33270d.beginTransaction();
                Logger.m32141i(f25864d, "ipModel record update count:" + map.size());
                C5790c.m33256f().m33260a(f25866f, null, null);
                for (Map.Entry<String, AbstractMap.SimpleEntry<String, Integer>> entry : map.entrySet()) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("domain", entry.getKey());
                    contentValues.put("ip", entry.getValue().getKey());
                    contentValues.put("count", entry.getValue().getValue());
                    C5790c.m33256f().m33261a(f25866f, contentValues);
                }
                sQLiteDatabaseM33270d.setTransactionSuccessful();
            } catch (Throwable unused) {
                Logger.m32145w(f25864d, "Transaction will roll back in update iprecord trainData ");
            }
        } finally {
            sQLiteDatabaseM33270d.endTransaction();
        }
    }
}
