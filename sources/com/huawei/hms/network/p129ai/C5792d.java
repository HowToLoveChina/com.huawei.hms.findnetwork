package com.huawei.hms.network.p129ai;

import android.database.sqlite.SQLiteDatabase;
import com.huawei.hms.framework.common.Logger;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.huawei.hms.network.ai.d */
/* loaded from: classes8.dex */
public class C5792d {

    /* renamed from: b */
    public static final String f25782b = "AIDataManager";

    /* renamed from: a */
    public Map<String, InterfaceC5798g> f25783a;

    /* renamed from: com.huawei.hms.network.ai.d$b */
    public static class b {

        /* renamed from: a */
        public static final C5792d f25784a = new C5792d();
    }

    public C5792d() {
        this.f25783a = new ConcurrentHashMap();
    }

    /* renamed from: c */
    public static C5792d m33287c() {
        return b.f25784a;
    }

    /* renamed from: a */
    public Object m33288a(String str) {
        return m33293b(str).mo33245b();
    }

    /* renamed from: b */
    public InterfaceC5798g m33293b(String str) {
        return this.f25783a.get(str);
    }

    public /* synthetic */ C5792d(a aVar) {
        this();
    }

    /* renamed from: a */
    public void m33289a() {
        Iterator<InterfaceC5798g> it = this.f25783a.values().iterator();
        while (it.hasNext()) {
            it.next().mo33246c();
        }
    }

    /* renamed from: b */
    public void m33294b() {
        Logger.m32141i(f25782b, "clear pre connect data");
        SQLiteDatabase sQLiteDatabaseM33270d = C5790c.m33256f().m33270d();
        if (sQLiteDatabaseM33270d != null) {
            try {
                try {
                    sQLiteDatabaseM33270d.beginTransaction();
                    C5790c.m33256f().m33260a(C5795e0.f25827f, null, null);
                    C5790c.m33256f().m33260a(C5814o.f26001e, null, null);
                    sQLiteDatabaseM33270d.setTransactionSuccessful();
                } catch (Throwable unused) {
                    Logger.m32145w(f25782b, "Transaction will roll back in clear data");
                }
                sQLiteDatabaseM33270d.endTransaction();
                Iterator<InterfaceC5798g> it = this.f25783a.values().iterator();
                while (it.hasNext()) {
                    it.next().mo33247d();
                }
                C5790c.m33256f().m33268b();
            } catch (Throwable th2) {
                sQLiteDatabaseM33270d.endTransaction();
                throw th2;
            }
        }
    }

    /* renamed from: a */
    public void m33290a(SQLiteDatabase sQLiteDatabase) {
        Iterator<InterfaceC5798g> it = this.f25783a.values().iterator();
        while (it.hasNext()) {
            it.next().mo33239a(sQLiteDatabase);
        }
    }

    /* renamed from: a */
    public void m33291a(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        Iterator<InterfaceC5798g> it = this.f25783a.values().iterator();
        while (it.hasNext()) {
            it.next().mo33240a(sQLiteDatabase, i10, i11);
        }
    }

    /* renamed from: a */
    public void m33292a(String str, InterfaceC5798g interfaceC5798g) {
        this.f25783a.put(str, interfaceC5798g);
    }
}
