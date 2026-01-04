package com.huawei.hms.network.embedded;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.NetworkKitSQLiteOpenHelper;
import com.huawei.hms.network.p129ai.C5799g0;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.network.embedded.c0 */
/* loaded from: classes8.dex */
public class C5871c0 {

    /* renamed from: a */
    public static final String f26536a = "FileCacheManager";

    /* renamed from: b */
    public static final String f26537b = "restclient_dns.db";

    /* renamed from: c */
    public static final String f26538c = "restclient_dynamic_dns.db";

    /* renamed from: d */
    public static String f26539d = "restclient_dns.db";

    /* renamed from: e */
    public static final String f26540e = "createTime";

    /* renamed from: f */
    public static final String f26541f = "dns_domain";

    /* renamed from: g */
    public static final String f26542g = "domain";

    /* renamed from: h */
    public static final String f26543h = "ip";

    /* renamed from: i */
    public static final String f26544i = "ttl";

    /* renamed from: j */
    public static final String f26545j = "source";

    /* renamed from: k */
    public static final String[] f26546k = {"domain", "ip", "ttl", "source", "createTime"};

    /* renamed from: l */
    public static volatile SQLiteDatabase f26547l;

    static {
        if (ContextHolder.getKitContext() != null) {
            f26539d = f26538c;
        }
    }

    /* renamed from: a */
    public static C5857b0 m34000a(String str, C6003m0 c6003m0) throws JSONException {
        JSONObject jSONObject;
        C5857b0 c5857b0;
        C5857b0 c5857b02 = null;
        if (C6158y.m35829b(c6003m0)) {
            return null;
        }
        try {
            jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it = c6003m0.m34749d().iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
            jSONObject.put(C5799g0.f25867g, jSONArray);
            c5857b0 = new C5857b0();
        } catch (JSONException unused) {
        }
        try {
            c5857b0.f26394c = c6003m0.m34753h();
            c5857b0.f26396e = c6003m0.m34751f();
            c5857b0.f26392a = str;
            c5857b0.f26393b = jSONObject.toString();
            c5857b0.f26395d = c6003m0.m34742b();
            return c5857b0;
        } catch (JSONException unused2) {
            c5857b02 = c5857b0;
            Logger.m32145w(f26536a, "ConvertAddress Failed:" + c6003m0.toString());
            return c5857b02;
        }
    }

    /* renamed from: b */
    public static HashMap<String, C6003m0> m34006b() {
        return m34003a(m34010d());
    }

    /* renamed from: c */
    public static HashMap<String, C6003m0> m34009c() {
        return m34003a(NetworkKitSQLiteOpenHelper.getInstance().getDbByName(f26539d));
    }

    /* renamed from: d */
    public static SQLiteDatabase m34010d() throws SQLiteException {
        if (C6093t.m35329m().m35344b() == null) {
            throw new SQLiteException("Can't acce ss database");
        }
        synchronized (C5871c0.class) {
            try {
                if (f26547l == null) {
                    f26547l = NetworkKitSQLiteOpenHelper.getInstance().getNetworkKitWritableDatabase();
                    if (f26547l != null) {
                        f26547l.execSQL("Create table if not exists dns_domain( _id INTEGER PRIMARY KEY AUTOINCREMENT, domain TEXT UNIQUE, ip TEXT, ttl TEXT, source INTEGER, createTime INTEGER);");
                        m34004a();
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (f26547l != null) {
            return f26547l;
        }
        throw new SQLiteException("Can't access database");
    }

    /* renamed from: e */
    public static boolean m34011e() throws SQLException {
        Logger.m32143v(f26536a, "file cache removeAll operation");
        try {
            m34010d().execSQL("delete from dns_domain");
            SQLiteDatabase networkkitUnusedDbDB = NetworkKitSQLiteOpenHelper.getInstance().getNetworkkitUnusedDbDB();
            if (networkkitUnusedDbDB != null) {
                networkkitUnusedDbDB.execSQL("delete from dns_domain");
            }
            return true;
        } catch (Exception e10) {
            Logger.m32141i(f26536a, "remove exception:" + e10.getClass().getSimpleName());
            return false;
        }
    }

    /* renamed from: a */
    public static C6003m0 m34001a(C5857b0 c5857b0) throws JSONException {
        C6003m0 c6003m0 = new C6003m0();
        try {
            JSONArray jSONArray = new JSONObject(c5857b0.f26393b).getJSONArray(C5799g0.f25867g);
            int length = jSONArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                c6003m0.m34739a(jSONArray.getString(i10));
            }
        } catch (JSONException unused) {
            Logger.m32145w(f26536a, "ConvertAddress Failed:" + c5857b0.toString());
        }
        c6003m0.m34744b(c5857b0.f26394c);
        c6003m0.m34738a(c5857b0.f26395d);
        c6003m0.m34743b(c5857b0.f26396e);
        c6003m0.m34737a(1);
        C6158y.m35830c(c6003m0);
        return c6003m0;
    }

    /* renamed from: b */
    public static boolean m34007b(String str) {
        if (TextUtils.isEmpty(str)) {
            Logger.m32145w(f26536a, "invalid parameter: domain is null");
            return false;
        }
        Logger.m32143v(f26536a, "file cache remove operation:" + str);
        try {
            return m34010d().delete(f26541f, "domain=?", new String[]{str}) >= 0;
        } catch (Exception e10) {
            Logger.m32141i(f26536a, "remove exception:" + e10.getClass().getSimpleName());
            return false;
        }
    }

    /* renamed from: a */
    public static C6003m0 m34002a(String str) throws JSONException {
        C6003m0 c6003m0 = new C6003m0();
        if (TextUtils.isEmpty(str)) {
            Logger.m32145w(f26536a, "invalid parameter: domain is null");
            return c6003m0;
        }
        ArrayList<C5857b0> arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = m34010d().query(f26541f, f26546k, "domain=?", new String[]{str}, null, null, null);
                if (cursorQuery.getCount() > 0) {
                    while (cursorQuery.moveToNext()) {
                        C5857b0 c5857b0 = new C5857b0();
                        c5857b0.f26392a = cursorQuery.getString(0);
                        c5857b0.f26393b = cursorQuery.getString(1);
                        c5857b0.f26394c = cursorQuery.getLong(2);
                        c5857b0.f26396e = cursorQuery.getInt(3);
                        c5857b0.f26395d = cursorQuery.getLong(4);
                        arrayList.add(c5857b0);
                    }
                }
            } catch (Exception e10) {
                Logger.m32145w(f26536a, "query exception:" + e10.getClass().getSimpleName());
                if (cursorQuery != null) {
                }
            }
            cursorQuery.close();
            for (C5857b0 c5857b02 : arrayList) {
                if (c5857b02.m33853a()) {
                    m34007b(str);
                } else {
                    c6003m0 = m34001a(c5857b02);
                }
            }
            return c6003m0;
        } catch (Throwable th2) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th2;
        }
    }

    /* renamed from: b */
    public static boolean m34008b(String str, C6003m0 c6003m0) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            Logger.m32145w(f26536a, "invalid parameter: domain is null");
            return false;
        }
        Logger.m32144v(f26536a, "insertOrUpdateAddress: %s", str);
        C5857b0 c5857b0M34000a = m34000a(str, c6003m0);
        if (c5857b0M34000a == null) {
            Logger.m32147w(f26536a, "convert address failed, domain:", str);
            return false;
        }
        try {
            SQLiteDatabase sQLiteDatabaseM34010d = m34010d();
            sQLiteDatabaseM34010d.delete(f26541f, "domain=?", new String[]{str});
            return m34005a(sQLiteDatabaseM34010d, c5857b0M34000a);
        } catch (Exception e10) {
            Logger.m32145w(f26536a, "insert exception:" + e10.getClass().getSimpleName());
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0090 A[PHI: r12
  0x0090: PHI (r12v4 android.database.Cursor) = (r12v5 android.database.Cursor), (r12v8 android.database.Cursor) binds: [B:29:0x008e, B:23:0x0084] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a1  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.HashMap<java.lang.String, com.huawei.hms.network.embedded.C6003m0> m34003a(android.database.sqlite.SQLiteDatabase r12) throws java.lang.Throwable {
        /*
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            java.lang.String r2 = "FileCacheManager"
            r3 = 0
            if (r12 == 0) goto L8d
            java.lang.String r5 = "dns_domain"
            java.lang.String[] r6 = com.huawei.hms.network.embedded.C5871c0.f26546k     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L66
            r10 = 0
            r11 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r4 = r12
            android.database.Cursor r12 = r4.query(r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L66
            int r4 = r12.getCount()     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L62
            if (r4 <= 0) goto L8e
        L23:
            boolean r4 = r12.moveToNext()     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L62
            if (r4 == 0) goto L8e
            com.huawei.hms.network.embedded.b0 r4 = new com.huawei.hms.network.embedded.b0     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L62
            r4.<init>()     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L62
            r5 = 0
            java.lang.String r5 = r12.getString(r5)     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L62
            r4.f26392a = r5     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L62
            r5 = 1
            java.lang.String r5 = r12.getString(r5)     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L62
            r4.f26393b = r5     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L62
            r5 = 2
            long r5 = r12.getLong(r5)     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L62
            r4.f26394c = r5     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L62
            r5 = 3
            int r5 = r12.getInt(r5)     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L62
            r4.f26396e = r5     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L62
            r5 = 4
            long r5 = r12.getLong(r5)     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L62
            r4.f26395d = r5     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L62
            java.lang.String r5 = r4.f26392a     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L62
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L62
            if (r5 != 0) goto L23
            java.lang.String r5 = r4.f26392a     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L62
            r0.put(r5, r4)     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L62
            goto L23
        L5f:
            r0 = move-exception
            r3 = r12
            goto L87
        L62:
            r4 = move-exception
            goto L68
        L64:
            r0 = move-exception
            goto L87
        L66:
            r4 = move-exception
            r12 = r3
        L68:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5f
            r5.<init>()     // Catch: java.lang.Throwable -> L5f
            java.lang.String r6 = "getAll exception:"
            r5.append(r6)     // Catch: java.lang.Throwable -> L5f
            java.lang.Class r4 = r4.getClass()     // Catch: java.lang.Throwable -> L5f
            java.lang.String r4 = r4.getSimpleName()     // Catch: java.lang.Throwable -> L5f
            r5.append(r4)     // Catch: java.lang.Throwable -> L5f
            java.lang.String r4 = r5.toString()     // Catch: java.lang.Throwable -> L5f
            com.huawei.hms.framework.common.Logger.m32145w(r2, r4)     // Catch: java.lang.Throwable -> L5f
            if (r12 == 0) goto L93
            goto L90
        L87:
            if (r3 == 0) goto L8c
            r3.close()
        L8c:
            throw r0
        L8d:
            r12 = r3
        L8e:
            if (r12 == 0) goto L93
        L90:
            r12.close()
        L93:
            java.util.Set r12 = r0.entrySet()
            java.util.Iterator r12 = r12.iterator()
        L9b:
            boolean r0 = r12.hasNext()
            if (r0 == 0) goto Ld9
            java.lang.Object r0 = r12.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r4 = r0.getValue()
            com.huawei.hms.network.embedded.b0 r4 = (com.huawei.hms.network.embedded.C5857b0) r4
            java.lang.Object[] r5 = new java.lang.Object[]{r4}
            java.lang.String r6 = "Address: %s"
            com.huawei.hms.framework.common.Logger.m32144v(r2, r6, r5)
            boolean r5 = r4.m33853a()
            if (r5 == 0) goto Lc7
            java.lang.Object r4 = r0.getKey()
            java.lang.String r4 = (java.lang.String) r4
            m34007b(r4)
            r4 = r3
            goto Lcb
        Lc7:
            com.huawei.hms.network.embedded.m0 r4 = m34001a(r4)
        Lcb:
            boolean r5 = com.huawei.hms.network.embedded.C6158y.m35829b(r4)
            if (r5 != 0) goto L9b
            java.lang.Object r0 = r0.getKey()
            r1.put(r0, r4)
            goto L9b
        Ld9:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.network.embedded.C5871c0.m34003a(android.database.sqlite.SQLiteDatabase):java.util.HashMap");
    }

    /* renamed from: a */
    public static void m34004a() throws JSONException {
        if (f26547l != null) {
            String strReplace = f26547l.getPath().replace(NetworkKitSQLiteOpenHelper.getInstance().getDbName(), f26539d);
            if (new File(strReplace).exists()) {
                HashMap<String, C6003m0> mapM34009c = m34009c();
                if (!mapM34009c.isEmpty()) {
                    for (Map.Entry<String, C6003m0> entry : mapM34009c.entrySet()) {
                        m34008b(entry.getKey(), entry.getValue());
                    }
                }
                NetworkKitSQLiteOpenHelper.getInstance().deleteDbByName(f26539d);
                NetworkKitSQLiteOpenHelper.getInstance().deleteDbFileByPath(strReplace);
                NetworkKitSQLiteOpenHelper.getInstance().deleteDbFileByPath(strReplace + NetworkKitSQLiteOpenHelper.getInstance().getDbNameSuffix());
            }
        }
    }

    /* renamed from: a */
    public static boolean m34005a(SQLiteDatabase sQLiteDatabase, C5857b0 c5857b0) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("domain", c5857b0.f26392a);
        contentValues.put("ip", c5857b0.f26393b);
        contentValues.put("ttl", Long.valueOf(c5857b0.f26394c));
        contentValues.put("source", Integer.valueOf(c5857b0.f26396e));
        contentValues.put("createTime", Long.valueOf(c5857b0.f26395d));
        return sQLiteDatabase.replace(f26541f, "", contentValues) > 0;
    }
}
