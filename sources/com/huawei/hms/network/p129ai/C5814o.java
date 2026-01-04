package com.huawei.hms.network.p129ai;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.huawei.hms.framework.common.IoUtils;
import com.huawei.hms.framework.common.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* renamed from: com.huawei.hms.network.ai.o */
/* loaded from: classes8.dex */
public class C5814o implements InterfaceC5798g {

    /* renamed from: d */
    public static final String f26000d = "o";

    /* renamed from: f */
    public static final String f26002f = "domain";

    /* renamed from: h */
    public static final String f26004h = "score";

    /* renamed from: a */
    public Map<String, Map<String, Integer>> f26006a;

    /* renamed from: b */
    public Map<String, List<Map.Entry<String, Integer>>> f26007b;

    /* renamed from: c */
    public final Object f26008c = new Object();

    /* renamed from: e */
    public static final String f26001e = "table_domainrelation";

    /* renamed from: g */
    public static final String f26003g = "relationdomain";

    /* renamed from: i */
    public static final String f26005i = String.format(Locale.ENGLISH, "create table if not exists %s(%s varchar(128), %s varchar(128), %s integer)", f26001e, "domain", f26003g, "score");

    /* renamed from: com.huawei.hms.network.ai.o$a */
    public class a implements Comparator<Map.Entry<String, Integer>> {
        public a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Map.Entry<String, Integer> entry, Map.Entry<String, Integer> entry2) {
            return entry2.getValue().intValue() - entry.getValue().intValue();
        }
    }

    @Override // com.huawei.hms.network.p129ai.InterfaceC5798g
    /* renamed from: a */
    public Object mo33237a() {
        Map<String, List<Map.Entry<String, Integer>>> map;
        Map<String, List<Map.Entry<String, Integer>>> map2 = this.f26007b;
        if (map2 != null) {
            return map2;
        }
        if (this.f26006a == null) {
            return null;
        }
        synchronized (this.f26008c) {
            try {
                if (this.f26007b == null) {
                    this.f26007b = new HashMap();
                    for (String str : this.f26006a.keySet()) {
                        this.f26007b.put(str, m33467a(this.f26006a.get(str)));
                    }
                }
                map = this.f26007b;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return map;
    }

    @Override // com.huawei.hms.network.p129ai.InterfaceC5798g
    /* renamed from: b */
    public Object mo33245b() {
        Cursor cursorM33265a;
        Map<String, Map<String, Integer>> map = this.f26006a;
        if (map != null) {
            return map;
        }
        synchronized (this.f26008c) {
            if (this.f26006a == null) {
                this.f26006a = new LinkedHashMap();
                try {
                    cursorM33265a = C5790c.m33256f().m33265a(f26001e, null, null, null, null, null, null);
                    try {
                        int columnIndex = cursorM33265a.getColumnIndex("domain");
                        int columnIndex2 = cursorM33265a.getColumnIndex(f26003g);
                        int columnIndex3 = cursorM33265a.getColumnIndex("score");
                        Logger.m32143v(f26000d, "size " + cursorM33265a.getCount());
                        while (cursorM33265a.moveToNext()) {
                            String string = cursorM33265a.getString(columnIndex);
                            String string2 = cursorM33265a.getString(columnIndex2);
                            int i10 = cursorM33265a.getInt(columnIndex3);
                            if (!this.f26006a.containsKey(string)) {
                                this.f26006a.put(string, new LinkedHashMap());
                            }
                            this.f26006a.get(string).put(string2, Integer.valueOf(i10));
                        }
                    } catch (Throwable unused) {
                        try {
                            Logger.m32138e(f26000d, "meet exception when getting init model train data");
                            return this.f26006a;
                        } finally {
                            IoUtils.close(cursorM33265a);
                        }
                    }
                } catch (Throwable unused2) {
                    cursorM33265a = null;
                }
            }
        }
        return this.f26006a;
    }

    @Override // com.huawei.hms.network.p129ai.InterfaceC5798g
    /* renamed from: c */
    public void mo33246c() {
        m33468e();
    }

    @Override // com.huawei.hms.network.p129ai.InterfaceC5798g
    /* renamed from: d */
    public void mo33247d() {
        synchronized (this.f26008c) {
            this.f26006a = new HashMap();
            this.f26007b = new HashMap();
        }
    }

    /* renamed from: e */
    public void m33468e() {
        Cursor cursor = null;
        try {
            Cursor cursorM33262a = C5790c.m33256f().m33262a(f26001e);
            if (cursorM33262a != null) {
                try {
                    int columnIndex = cursorM33262a.getColumnIndex("domain");
                    int columnIndex2 = cursorM33262a.getColumnIndex(f26003g);
                    int columnIndex3 = cursorM33262a.getColumnIndex("score");
                    while (cursorM33262a.moveToNext()) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("domain", cursorM33262a.getString(columnIndex));
                        contentValues.put(f26003g, cursorM33262a.getString(columnIndex2));
                        contentValues.put("score", Integer.valueOf(cursorM33262a.getInt(columnIndex3)));
                        C5790c.m33256f().m33261a(f26001e, contentValues);
                    }
                    if (C5790c.m33256f().m33259a(C5790c.m33256f().m33269c(), f26001e, (String) null, (String[]) null) == 1) {
                        Logger.m32143v(f26000d, "DomainRelationModel checkTableDomainrelationData success");
                    }
                } catch (Throwable unused) {
                    cursor = cursorM33262a;
                    try {
                        Logger.m32138e(f26000d, "meet exception when checkTableDomainrelationData");
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

    /* renamed from: b */
    private void m33466b(SQLiteDatabase sQLiteDatabase) throws SQLException {
        try {
            sQLiteDatabase.execSQL(f26005i);
        } catch (SQLException unused) {
            Logger.m32138e(f26000d, "execSQL fail on create table");
        }
    }

    /* renamed from: a */
    public List<Map.Entry<String, Integer>> m33467a(Map<String, Integer> map) {
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        Collections.sort(arrayList, new a());
        return arrayList;
    }

    @Override // com.huawei.hms.network.p129ai.InterfaceC5798g
    /* renamed from: a */
    public void mo33239a(SQLiteDatabase sQLiteDatabase) throws SQLException {
        m33466b(sQLiteDatabase);
    }

    @Override // com.huawei.hms.network.p129ai.InterfaceC5798g
    /* renamed from: a */
    public void mo33240a(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
    }

    @Override // com.huawei.hms.network.p129ai.InterfaceC5798g
    /* renamed from: a */
    public void mo33242a(Object obj) {
        Map map = (Map) obj;
        SQLiteDatabase sQLiteDatabaseM33270d = C5790c.m33256f().m33270d();
        if (map == null || map.size() == 0 || sQLiteDatabaseM33270d == null) {
            return;
        }
        sQLiteDatabaseM33270d.beginTransaction();
        try {
            try {
                Logger.m32141i(f26000d, "domainRelationModel update count:" + map.size());
                for (C5810m c5810m : map.values()) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("score", Integer.valueOf(c5810m.m33430c()));
                    if (c5810m.m33431d() == 0) {
                        contentValues.put("domain", c5810m.m33424a());
                        contentValues.put(f26003g, c5810m.m33427b());
                        C5790c.m33256f().m33261a(f26001e, contentValues);
                    } else {
                        C5790c.m33256f().m33258a(f26001e, contentValues, "domain=? AND relationdomain=?", new String[]{c5810m.m33424a(), c5810m.m33427b()});
                    }
                }
                sQLiteDatabaseM33270d.setTransactionSuccessful();
            } catch (Throwable unused) {
                Logger.m32145w(f26000d, "Transaction will roll back in update relationModel trainData ");
            }
        } finally {
            sQLiteDatabaseM33270d.endTransaction();
        }
    }
}
