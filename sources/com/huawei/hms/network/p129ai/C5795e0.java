package com.huawei.hms.network.p129ai;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.huawei.hms.framework.common.IoUtils;
import com.huawei.hms.framework.common.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* renamed from: com.huawei.hms.network.ai.e0 */
/* loaded from: classes8.dex */
public class C5795e0 implements InterfaceC5798g {

    /* renamed from: e */
    public static final String f25826e = "e0";

    /* renamed from: g */
    public static final String f25828g = "domain";

    /* renamed from: h */
    public static final String f25829h = "score";

    /* renamed from: a */
    public int f25832a = 20;

    /* renamed from: b */
    public ArrayList<String> f25833b = null;

    /* renamed from: c */
    public HashMap<String, int[]> f25834c = new HashMap<>();

    /* renamed from: d */
    public final Object f25835d = new Object();

    /* renamed from: f */
    public static final String f25827f = "table_init";

    /* renamed from: i */
    public static final String f25830i = "conticnt";

    /* renamed from: j */
    public static final String f25831j = String.format(Locale.ENGLISH, "create table if not exists %s(%s varchar(128), %s integer, %s integer, primary key (%s))", f25827f, "domain", "score", f25830i, "domain");

    @Override // com.huawei.hms.network.p129ai.InterfaceC5798g
    /* renamed from: a */
    public Object mo33237a() {
        Cursor cursorM33266a;
        ArrayList<String> arrayList = this.f25833b;
        if (arrayList != null) {
            return arrayList;
        }
        synchronized (this.f25835d) {
            if (this.f25833b == null) {
                this.f25833b = new ArrayList<>();
                try {
                    cursorM33266a = C5790c.m33256f().m33266a(f25827f, new String[]{"domain"}, (String) null, (String[]) null, (String) null, (String) null, "score DESC", Integer.toString(this.f25832a));
                    if (cursorM33266a != null) {
                        try {
                            int columnIndex = cursorM33266a.getColumnIndex("domain");
                            Logger.m32143v(f25826e, "size " + cursorM33266a.getCount());
                            while (cursorM33266a.moveToNext()) {
                                this.f25833b.add(cursorM33266a.getString(columnIndex));
                            }
                        } catch (Throwable unused) {
                            try {
                                Logger.m32138e(f25826e, "meet exception when getting init model execute data");
                                return this.f25833b;
                            } finally {
                                IoUtils.close(cursorM33266a);
                            }
                        }
                    }
                } catch (Throwable unused2) {
                    cursorM33266a = null;
                }
            }
        }
        return this.f25833b;
    }

    @Override // com.huawei.hms.network.p129ai.InterfaceC5798g
    /* renamed from: b */
    public Object mo33245b() {
        Cursor cursorM33265a;
        synchronized (this.f25835d) {
            try {
                cursorM33265a = C5790c.m33256f().m33265a(f25827f, null, null, null, null, null, null);
                try {
                    int columnIndex = cursorM33265a.getColumnIndex("domain");
                    int columnIndex2 = cursorM33265a.getColumnIndex("score");
                    int columnIndex3 = cursorM33265a.getColumnIndex(f25830i);
                    Logger.m32143v(f25826e, "size " + cursorM33265a.getCount());
                    while (cursorM33265a.moveToNext()) {
                        this.f25834c.put(cursorM33265a.getString(columnIndex), new int[]{cursorM33265a.getInt(columnIndex2), cursorM33265a.getInt(columnIndex3)});
                    }
                } catch (Throwable unused) {
                    try {
                        Logger.m32138e(f25826e, "meet exception when getting init model train data");
                        return this.f25834c;
                    } finally {
                        IoUtils.close(cursorM33265a);
                    }
                }
            } catch (Throwable unused2) {
                cursorM33265a = null;
            }
        }
        return this.f25834c;
    }

    @Override // com.huawei.hms.network.p129ai.InterfaceC5798g
    /* renamed from: c */
    public void mo33246c() {
        m33313e();
    }

    @Override // com.huawei.hms.network.p129ai.InterfaceC5798g
    /* renamed from: d */
    public void mo33247d() {
        synchronized (this.f25835d) {
            this.f25833b = new ArrayList<>();
            this.f25834c.clear();
        }
    }

    /* renamed from: e */
    public void m33313e() {
        Cursor cursor = null;
        try {
            Cursor cursorM33262a = C5790c.m33256f().m33262a(f25827f);
            if (cursorM33262a != null) {
                try {
                    int columnIndex = cursorM33262a.getColumnIndex("domain");
                    int columnIndex2 = cursorM33262a.getColumnIndex("score");
                    int columnIndex3 = cursorM33262a.getColumnIndex(f25830i);
                    while (cursorM33262a.moveToNext()) {
                        String string = cursorM33262a.getString(columnIndex);
                        int i10 = cursorM33262a.getInt(columnIndex2);
                        int i11 = cursorM33262a.getInt(columnIndex3);
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("domain", string);
                        contentValues.put("score", Integer.valueOf(i10));
                        contentValues.put(f25830i, Integer.valueOf(i11));
                        C5790c.m33256f().m33261a(f25827f, contentValues);
                    }
                    if (C5790c.m33256f().m33259a(C5790c.m33256f().m33269c(), f25827f, (String) null, (String[]) null) == 1) {
                        Logger.m32141i(f25826e, "InitModel checkTableInitData success");
                    }
                } catch (Throwable unused) {
                    cursor = cursorM33262a;
                    try {
                        Logger.m32138e(f25826e, "meet exception when checkTableInitData");
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
    public void mo33239a(SQLiteDatabase sQLiteDatabase) throws SQLException {
        try {
            Logger.m32141i(f25826e, "InitModel create table");
            sQLiteDatabase.execSQL(f25831j);
        } catch (SQLException unused) {
            Logger.m32138e(f25826e, "execSQL fail on create table");
        }
    }

    @Override // com.huawei.hms.network.p129ai.InterfaceC5798g
    /* renamed from: a */
    public void mo33240a(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
    }

    @Override // com.huawei.hms.network.p129ai.InterfaceC5798g
    /* renamed from: a */
    public void mo33242a(Object obj) {
        HashMap map = (HashMap) obj;
        ContentValues contentValues = new ContentValues();
        SQLiteDatabase sQLiteDatabaseM33270d = C5790c.m33256f().m33270d();
        if (sQLiteDatabaseM33270d != null) {
            try {
                try {
                    sQLiteDatabaseM33270d.beginTransaction();
                    Logger.m32141i(f25826e, "initModel update count:" + map.size());
                    C5790c.m33256f().m33260a(f25827f, null, null);
                    for (Map.Entry entry : map.entrySet()) {
                        int i10 = ((int[]) entry.getValue())[0];
                        int i11 = ((int[]) entry.getValue())[1];
                        contentValues.put("domain", (String) entry.getKey());
                        contentValues.put("score", Integer.valueOf(i10));
                        contentValues.put(f25830i, Integer.valueOf(i11));
                        C5790c.m33256f().m33261a(f25827f, contentValues);
                    }
                    sQLiteDatabaseM33270d.setTransactionSuccessful();
                } catch (Throwable unused) {
                    Logger.m32145w(f25826e, "Transaction will roll back in update initModel trainData ");
                }
            } finally {
                sQLiteDatabaseM33270d.endTransaction();
            }
        }
    }
}
