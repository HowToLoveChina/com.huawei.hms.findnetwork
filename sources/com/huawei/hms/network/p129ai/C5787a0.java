package com.huawei.hms.network.p129ai;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.huawei.hms.framework.common.IoUtils;
import com.huawei.hms.framework.common.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.huawei.hms.network.ai.a0 */
/* loaded from: classes8.dex */
public class C5787a0 implements InterfaceC5798g {

    /* renamed from: d */
    public static final String f25696d = "WebSocketPingModel";

    /* renamed from: e */
    public static final long f25697e = 604800000;

    /* renamed from: f */
    public static final long f25698f = 1800000;

    /* renamed from: h */
    public static final String f25700h = "mnc";

    /* renamed from: i */
    public static final String f25701i = "networkType";

    /* renamed from: j */
    public static final String f25702j = "domain";

    /* renamed from: k */
    public static final String f25703k = "ping";

    /* renamed from: l */
    public static final String f25704l = "pingStatus";

    /* renamed from: m */
    public static final String f25705m = "updateTime";

    /* renamed from: n */
    public static final String f25706n = "-";

    /* renamed from: a */
    public Map<String, C5823w> f25708a = new ConcurrentHashMap();

    /* renamed from: b */
    public Map<String, List<C5825y>> f25709b = new ConcurrentHashMap();

    /* renamed from: c */
    public final Object f25710c = new Object();

    /* renamed from: g */
    public static final String f25699g = "table_ping";

    /* renamed from: o */
    public static final String f25707o = String.format(Locale.ENGLISH, "create table if not exists %s(%s varchar(128), %s integer, %s varchar(128), %s integer, %s integer, %s long)", f25699g, "mnc", "networkType", "domain", "ping", "pingStatus", "updateTime");

    /* renamed from: f */
    private List<C5823w> m33235f() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            Cursor cursorM33262a = C5790c.m33256f().m33262a(f25699g);
            if (cursorM33262a != null) {
                try {
                    int columnIndex = cursorM33262a.getColumnIndex("mnc");
                    int columnIndex2 = cursorM33262a.getColumnIndex("domain");
                    int columnIndex3 = cursorM33262a.getColumnIndex("networkType");
                    int columnIndex4 = cursorM33262a.getColumnIndex("ping");
                    int columnIndex5 = cursorM33262a.getColumnIndex("updateTime");
                    int columnIndex6 = cursorM33262a.getColumnIndex("pingStatus");
                    while (cursorM33262a.moveToNext()) {
                        C5823w c5823w = new C5823w();
                        c5823w.m33558b(cursorM33262a.getString(columnIndex));
                        c5823w.m33553a(cursorM33262a.getInt(columnIndex3));
                        c5823w.m33555a(cursorM33262a.getString(columnIndex2));
                        c5823w.m33557b(cursorM33262a.getInt(columnIndex4));
                        c5823w.m33560c(cursorM33262a.getInt(columnIndex6));
                        c5823w.m33554a(cursorM33262a.getLong(columnIndex5));
                        arrayList.add(c5823w);
                    }
                    if (C5790c.m33256f().m33259a(C5790c.m33256f().m33269c(), f25699g, (String) null, (String[]) null) == 1) {
                        Logger.m32141i("WebSocketPingModel", "InitModel getModuleTrainDataFormDB success");
                    }
                } catch (Throwable unused) {
                    cursor = cursorM33262a;
                    try {
                        Logger.m32138e("WebSocketPingModel", "meet exception when getModuleTrainDataFormDB");
                        return arrayList;
                    } finally {
                        IoUtils.close(cursor);
                    }
                }
            }
            IoUtils.close(cursorM33262a);
        } catch (Throwable unused2) {
        }
        return arrayList;
    }

    /* renamed from: a */
    public int m33236a(String str, int i10, String str2) {
        String strM33233b = m33233b(str, i10, str2);
        if (this.f25708a.containsKey(strM33233b)) {
            return this.f25708a.get(strM33233b).m33561d();
        }
        return 0;
    }

    /* renamed from: b */
    public float m33244b(C5824x c5824x) {
        synchronized (this.f25710c) {
            try {
                List<C5825y> list = this.f25709b.get(m33231a(c5824x.m33583h(), c5824x.m33589k()));
                if (list == null) {
                    return 0.0f;
                }
                Iterator<C5825y> it = list.iterator();
                while (it.hasNext()) {
                    if (!m33232a(it.next())) {
                        it.remove();
                    }
                }
                if (list.size() < 2) {
                    return 0.0f;
                }
                double dPow = 0.0d;
                double dM33598a = 0.0d;
                for (int i10 = 0; i10 < list.size(); i10++) {
                    dM33598a += list.get(i10).m33598a();
                }
                double size = dM33598a / list.size();
                for (int i11 = 0; i11 < list.size(); i11++) {
                    dPow += Math.pow(list.get(i11).m33598a() - size, 2.0d);
                }
                float size2 = (float) (dPow / (list.size() - 1));
                Logger.m32143v("WebSocketPingModel", "movingSpeed is " + size2);
                return size2;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.hms.network.p129ai.InterfaceC5798g
    /* renamed from: c */
    public void mo33246c() {
        m33248e();
    }

    @Override // com.huawei.hms.network.p129ai.InterfaceC5798g
    /* renamed from: d */
    public void mo33247d() {
    }

    /* renamed from: e */
    public void m33248e() {
        List<C5823w> listM33235f = m33235f();
        if (listM33235f.isEmpty()) {
            return;
        }
        for (C5823w c5823w : listM33235f) {
            m33243a(c5823w.m33556b(), c5823w.m33559c(), c5823w.m33552a(), c5823w.m33561d(), c5823w.m33562e());
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
            cursorM33265a = C5790c.m33256f().m33265a(f25699g, null, null, null, null, null, null);
            try {
                int columnIndex = cursorM33265a.getColumnIndex("mnc");
                int columnIndex2 = cursorM33265a.getColumnIndex("networkType");
                int columnIndex3 = cursorM33265a.getColumnIndex("domain");
                int columnIndex4 = cursorM33265a.getColumnIndex("ping");
                int columnIndex5 = cursorM33265a.getColumnIndex("pingStatus");
                int columnIndex6 = cursorM33265a.getColumnIndex("updateTime");
                Logger.m32141i("WebSocketPingModel", "size " + cursorM33265a.getCount());
                while (cursorM33265a.moveToNext()) {
                    C5823w c5823w = new C5823w();
                    c5823w.m33558b(cursorM33265a.getString(columnIndex));
                    c5823w.m33553a(cursorM33265a.getInt(columnIndex2));
                    c5823w.m33555a(cursorM33265a.getString(columnIndex3));
                    c5823w.m33557b(cursorM33265a.getInt(columnIndex4));
                    c5823w.m33560c(cursorM33265a.getInt(columnIndex5));
                    c5823w.m33554a(cursorM33265a.getLong(columnIndex6));
                    this.f25708a.put(m33233b(c5823w.m33556b(), c5823w.m33559c(), c5823w.m33552a()), c5823w);
                }
            } catch (Throwable unused) {
                try {
                    Logger.m32138e("WebSocketPingModel", "meet exception when getting ping model train data");
                    return this.f25708a;
                } finally {
                    IoUtils.close(cursorM33265a);
                }
            }
        } catch (Throwable unused2) {
            cursorM33265a = null;
        }
        return this.f25708a;
    }

    /* renamed from: a */
    private String m33231a(String str, int i10) {
        return str + "-" + i10;
    }

    /* renamed from: b */
    private String m33233b(String str, int i10, String str2) {
        return str + "-" + i10 + "-" + str2;
    }

    /* renamed from: b */
    private void m33234b(SQLiteDatabase sQLiteDatabase) throws SQLException {
        Logger.m32141i("WebSocketPingModel", "ping modle create status table");
        try {
            sQLiteDatabase.execSQL(f25707o);
        } catch (SQLException unused) {
            Logger.m32138e("WebSocketPingModel", "execSQL fail on create ping table");
        }
    }

    /* renamed from: a */
    public Map<String, Integer> m33238a(int i10, String str, int i11, String str2) {
        int iM33562e;
        HashMap map = new HashMap();
        C5823w c5823w = this.f25708a.get(m33233b(str, i11, str2));
        if (c5823w == null || System.currentTimeMillis() - c5823w.m33563f() >= 604800000) {
            map.put("ping", Integer.valueOf(i10));
            iM33562e = 1;
        } else {
            map.put("ping", Integer.valueOf(c5823w.m33561d()));
            iM33562e = c5823w.m33562e();
        }
        map.put("pingStatus", Integer.valueOf(iM33562e));
        return map;
    }

    @Override // com.huawei.hms.network.p129ai.InterfaceC5798g
    /* renamed from: a */
    public void mo33239a(SQLiteDatabase sQLiteDatabase) throws SQLException {
        m33234b(sQLiteDatabase);
    }

    @Override // com.huawei.hms.network.p129ai.InterfaceC5798g
    /* renamed from: a */
    public void mo33240a(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
    }

    /* renamed from: a */
    public void m33241a(C5824x c5824x) {
        if (c5824x.m33589k() == 0 || c5824x.m33589k() == -1) {
            return;
        }
        synchronized (this.f25710c) {
            try {
                List<C5825y> arrayList = this.f25709b.get(m33231a(c5824x.m33583h(), c5824x.m33589k()));
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(new C5825y(c5824x.m33589k() == 1 ? c5824x.m33595o() : c5824x.m33585i(), System.currentTimeMillis()));
                this.f25709b.put(m33231a(c5824x.m33583h(), c5824x.m33589k()), arrayList);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.hms.network.p129ai.InterfaceC5798g
    /* renamed from: a */
    public void mo33242a(Object obj) {
    }

    /* renamed from: a */
    public void m33243a(String str, int i10, String str2, int i11, int i12) {
        Logger.m32143v("WebSocketPingModel", "updateDbData, mnc:" + str + ", networkType:" + i10 + ", domain:" + str2 + ", ping:" + i11 + ", pingStatus:" + i12);
        SQLiteDatabase sQLiteDatabaseM33270d = C5790c.m33256f().m33270d();
        if (sQLiteDatabaseM33270d != null) {
            try {
                try {
                    sQLiteDatabaseM33270d.beginTransaction();
                    ContentValues contentValues = new ContentValues();
                    if (this.f25708a.containsKey(m33233b(str, i10, str2))) {
                        contentValues.put("ping", Integer.valueOf(i11));
                        contentValues.put("pingStatus", Integer.valueOf(i12));
                        contentValues.put("updateTime", Long.valueOf(System.currentTimeMillis()));
                        C5790c.m33256f().m33258a(f25699g, contentValues, "mnc=? AND networkType=? AND domain=?", new String[]{str, i10 + "", str2});
                    } else {
                        contentValues.put("mnc", str);
                        contentValues.put("networkType", Integer.valueOf(i10));
                        contentValues.put("domain", str2);
                        contentValues.put("ping", Integer.valueOf(i11));
                        contentValues.put("pingStatus", Integer.valueOf(i12));
                        contentValues.put("updateTime", Long.valueOf(System.currentTimeMillis()));
                        C5790c.m33256f().m33261a(f25699g, contentValues);
                    }
                    sQLiteDatabaseM33270d.setTransactionSuccessful();
                } catch (Throwable th2) {
                    sQLiteDatabaseM33270d.endTransaction();
                    throw th2;
                }
            } catch (Throwable unused) {
                Logger.m32145w("WebSocketPingModel", "Transaction will roll back in update ping mode data");
            }
            sQLiteDatabaseM33270d.endTransaction();
            this.f25708a.put(m33233b(str, i10, str2), new C5823w(str, i10, str2, i11, i12, System.currentTimeMillis()));
        }
    }

    /* renamed from: a */
    private boolean m33232a(C5825y c5825y) {
        return System.currentTimeMillis() - c5825y.m33601b() < 1800000;
    }
}
