package com.huawei.hms.network.p129ai;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import com.huawei.hms.framework.common.IoUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.NetworkKitSQLiteOpenHelper;
import com.huawei.hms.network.inner.api.PolicyNetworkService;
import java.io.File;
import java.io.IOException;

/* renamed from: com.huawei.hms.network.ai.c */
/* loaded from: classes8.dex */
public class C5790c {

    /* renamed from: a */
    public static final String f25761a = "c";

    /* renamed from: b */
    public static final String f25762b = "restclient_dynamic_AI.db";

    /* renamed from: c */
    public static final String f25763c = "restclient_AI.db";

    /* renamed from: d */
    public static String f25764d = "restclient_AI.db";

    /* renamed from: e */
    public static String f25765e;

    /* renamed from: com.huawei.hms.network.ai.c$b */
    public static class b {

        /* renamed from: a */
        public static final C5790c f25766a = new C5790c();
    }

    public C5790c() {
        C5792d.m33287c().m33290a(NetworkKitSQLiteOpenHelper.getInstance().getNetworkKitWritableDatabase());
    }

    /* renamed from: e */
    private boolean m33255e() {
        SQLiteDatabase dbByName = NetworkKitSQLiteOpenHelper.getInstance().getDbByName(f25764d);
        if (dbByName == null) {
            return false;
        }
        String path = dbByName.getPath();
        NetworkKitSQLiteOpenHelper.getInstance().deleteDbByName(f25764d);
        NetworkKitSQLiteOpenHelper.getInstance().deleteDbFileByPath(path + NetworkKitSQLiteOpenHelper.getInstance().getDbNameSuffix());
        return NetworkKitSQLiteOpenHelper.getInstance().deleteDbFileByPath(path);
    }

    /* renamed from: f */
    public static C5790c m33256f() {
        return b.f25766a;
    }

    /* renamed from: g */
    private boolean m33257g() {
        SQLiteDatabase networkKitReadableDatabase = NetworkKitSQLiteOpenHelper.getInstance().getNetworkKitReadableDatabase();
        if (networkKitReadableDatabase != null) {
            return new File(networkKitReadableDatabase.getPath().replace(f25765e, f25764d)).exists();
        }
        return false;
    }

    /* renamed from: a */
    public int m33258a(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase sQLiteDatabaseM33270d = m33270d();
        if (sQLiteDatabaseM33270d != null) {
            return sQLiteDatabaseM33270d.update(str, contentValues, str2, strArr);
        }
        return -1;
    }

    /* renamed from: b */
    public void m33268b() {
        Logger.m32141i(f25761a, "clearUnusedDb");
        SQLiteDatabase networkkitUnusedDbDB = NetworkKitSQLiteOpenHelper.getInstance().getNetworkkitUnusedDbDB();
        if (networkkitUnusedDbDB != null) {
            try {
                try {
                    networkkitUnusedDbDB.beginTransaction();
                    networkkitUnusedDbDB.delete(C5795e0.f25827f, null, null);
                    networkkitUnusedDbDB.delete(C5814o.f26001e, null, null);
                    networkkitUnusedDbDB.setTransactionSuccessful();
                } finally {
                    networkkitUnusedDbDB.endTransaction();
                }
            } catch (Throwable unused) {
                Logger.m32145w(f25761a, "Transaction will roll back in clear unused db data");
            }
        }
    }

    /* renamed from: c */
    public String m33269c() {
        return f25764d;
    }

    /* renamed from: d */
    public SQLiteDatabase m33270d() {
        return NetworkKitSQLiteOpenHelper.getInstance().getNetworkKitWritableDatabase();
    }

    /* renamed from: a */
    public int m33259a(String str, String str2, String str3, String[] strArr) {
        SQLiteDatabase dbByName = NetworkKitSQLiteOpenHelper.getInstance().getDbByName(str);
        if (dbByName != null) {
            return dbByName.delete(str2, str3, strArr);
        }
        return -1;
    }

    /* renamed from: a */
    public int m33260a(String str, String str2, String[] strArr) {
        SQLiteDatabase sQLiteDatabaseM33270d = m33270d();
        if (sQLiteDatabaseM33270d != null) {
            return sQLiteDatabaseM33270d.delete(str, str2, strArr);
        }
        return -1;
    }

    /* renamed from: a */
    public long m33261a(String str, ContentValues contentValues) {
        SQLiteDatabase sQLiteDatabaseM33270d = m33270d();
        if (sQLiteDatabaseM33270d != null) {
            return sQLiteDatabaseM33270d.insert(str, null, contentValues);
        }
        return -1L;
    }

    /* renamed from: a */
    public Cursor m33262a(String str) {
        if (m33254a(f25764d, str)) {
            try {
                return m33256f().m33263a(m33256f().m33269c(), str, (String[]) null, (String) null, (String[]) null, (String) null, (String) null, (String) null);
            } catch (Throwable unused) {
                Logger.m32138e(f25761a, "meet exception when getCursorByTableName table:" + str);
            }
        }
        return null;
    }

    /* renamed from: a */
    public Cursor m33263a(String str, String str2, String[] strArr, String str3, String[] strArr2, String str4, String str5, String str6) {
        return m33264a(str, str2, strArr, str3, strArr2, str4, str5, str6, null);
    }

    /* renamed from: a */
    public Cursor m33264a(String str, String str2, String[] strArr, String str3, String[] strArr2, String str4, String str5, String str6, String str7) {
        Logger.m32143v(f25761a, "query form DB " + str);
        SQLiteDatabase dbByName = NetworkKitSQLiteOpenHelper.getInstance().getDbByName(str);
        if (dbByName != null) {
            return dbByName.query(str2, strArr, str3, strArr2, str4, str5, str6, str7);
        }
        return null;
    }

    /* renamed from: a */
    public Cursor m33265a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        return m33266a(str, strArr, str2, strArr2, str3, str4, str5, (String) null);
    }

    /* renamed from: a */
    public Cursor m33266a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        SQLiteDatabase networkKitReadableDatabase = NetworkKitSQLiteOpenHelper.getInstance().getNetworkKitReadableDatabase();
        if (networkKitReadableDatabase != null) {
            return networkKitReadableDatabase.query(str, strArr, str2, strArr2, str3, str4, str5, str6);
        }
        return null;
    }

    /* renamed from: a */
    public void m33267a() {
        if (!m33256f().m33257g()) {
            Logger.m32141i(f25761a, "checkDate, old db is not exists");
            return;
        }
        Logger.m32141i(f25761a, "checkDate, start deal old data");
        C5792d.m33287c().m33289a();
        m33255e();
    }

    /* renamed from: a */
    public static void m33253a(Bundle bundle) {
        f25765e = NetworkKitSQLiteOpenHelper.getInstance().getDbName();
        if (bundle.getBoolean(PolicyNetworkService.NetworkServiceConstants.IS_DYNAMIC)) {
            f25764d = f25762b;
        }
    }

    /* renamed from: a */
    private boolean m33254a(String str, String str2) throws IOException {
        SQLiteDatabase networkKitReadableDatabase;
        if (str2 != null && (networkKitReadableDatabase = NetworkKitSQLiteOpenHelper.getInstance().getNetworkKitReadableDatabase()) != null) {
            try {
                networkKitReadableDatabase = SQLiteDatabase.openDatabase(networkKitReadableDatabase.getPath().replace(NetworkKitSQLiteOpenHelper.getInstance().getDbName(), str), null, 0);
                IoUtils.close(networkKitReadableDatabase.rawQuery("select count(1) from " + str2, null));
                IoUtils.closeSecure(networkKitReadableDatabase);
                return true;
            } catch (Throwable unused) {
                IoUtils.close(null);
                IoUtils.closeSecure(networkKitReadableDatabase);
                return false;
            }
        }
        return false;
    }
}
