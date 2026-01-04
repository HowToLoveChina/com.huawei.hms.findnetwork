package com.huawei.android.remotecontrol.track;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.google.gson.Gson;
import com.huawei.android.remotecontrol.controller.PhoneFinderEncryptData;
import p015ak.C0214f0;
import p521og.C11869b;
import p521og.C11881n;
import p809yg.C13981a;
import pg.AbstractC12139d;

/* loaded from: classes4.dex */
public class LocateTrackDbHelper extends SQLiteOpenHelper {

    /* renamed from: a */
    public static volatile LocateTrackDbHelper f20339a;

    /* renamed from: b */
    public static final Object f20340b = new Object();

    public LocateTrackDbHelper(Context context) {
        super(context, "phonefinder_track.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    /* renamed from: b */
    public static long m26897b(Context context, ContentValues contentValues, boolean z10) {
        SQLiteDatabase sQLiteDatabaseM26907t = m26903i(context).m26907t();
        if (sQLiteDatabaseM26907t == null) {
            return -1L;
        }
        if (!z10) {
            LocateTrackEvent locateTrackEventM27017m = C4450l.m27017m(context);
            if (locateTrackEventM27017m == null) {
                sQLiteDatabaseM26907t.close();
                return -1L;
            }
            sQLiteDatabaseM26907t.delete("locate_track", "track_utc_time >= ? ", new String[]{String.valueOf(locateTrackEventM27017m.getTrackUTC())});
        }
        long jInsert = sQLiteDatabaseM26907t.insert("locate_track", "", contentValues);
        sQLiteDatabaseM26907t.close();
        return jInsert;
    }

    /* renamed from: c */
    public static boolean m26898c(Context context) throws SQLException {
        SQLiteDatabase sQLiteDatabaseM26907t = m26903i(context).m26907t();
        if (sQLiteDatabaseM26907t == null) {
            return false;
        }
        sQLiteDatabaseM26907t.execSQL("DROP TABLE IF EXISTS locate_track");
        sQLiteDatabaseM26907t.close();
        f20339a = null;
        return context.createDeviceProtectedStorageContext().deleteDatabase("phonefinder_track.db");
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x019c  */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.ArrayList<org.json.JSONObject> m26899d(android.content.Context r17, long r18) {
        /*
            Method dump skipped, instructions count: 416
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.remotecontrol.track.LocateTrackDbHelper.m26899d(android.content.Context, long):java.util.ArrayList");
    }

    /* renamed from: e */
    public static void m26900e(Context context, long j10, long j11) {
        SQLiteDatabase sQLiteDatabaseM26907t = m26903i(context).m26907t();
        if (sQLiteDatabaseM26907t == null) {
            return;
        }
        C13981a.m83987d("LocateTrackDbHelper", "deleteEvents count = " + sQLiteDatabaseM26907t.delete("locate_track", "track_utc_time <= ? ", new String[]{String.valueOf(j11)}));
        sQLiteDatabaseM26907t.close();
    }

    /* renamed from: f */
    public static void m26901f(Context context, long j10) {
        SQLiteDatabase sQLiteDatabaseM26907t;
        long jM27024d = C4452n.m27024d() - j10;
        if (jM27024d > 0 && (sQLiteDatabaseM26907t = m26903i(context).m26907t()) != null) {
            C13981a.m83987d("LocateTrackDbHelper", "deleteOverdueEvents count = " + sQLiteDatabaseM26907t.delete("locate_track", "track_utc_time < ? ", new String[]{String.valueOf(jM27024d)}));
            sQLiteDatabaseM26907t.close();
        }
    }

    /* renamed from: h */
    public static String m26902h(String str, Context context) {
        PhoneFinderEncryptData phoneFinderEncryptDataM71144k = C11869b.m71144k(str, C11881n.m71352b(AbstractC12139d.m72766e(context).getUserKey()));
        return phoneFinderEncryptDataM71144k != null ? new Gson().toJson(phoneFinderEncryptDataM71144k) : str;
    }

    /* renamed from: i */
    public static LocateTrackDbHelper m26903i(Context context) {
        if (f20339a == null) {
            synchronized (f20340b) {
                try {
                    if (f20339a == null) {
                        m26904u(context);
                    }
                } finally {
                }
            }
        }
        return f20339a;
    }

    /* renamed from: u */
    public static void m26904u(Context context) {
        f20339a = new LocateTrackDbHelper(C0214f0.m1381a(context, "phonefinder_track.db"));
    }

    /* renamed from: g */
    public final void m26905g(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS locate_track");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS locate_track (_id INTEGER PRIMARY KEY,track_latitude TEXT, track_lontitude TEXT, track_latitudeWGS TEXT, track_lontitudeWGS TEXT, track_accuracy TEXT, track_map_type TEXT, track_capability_islockscreen TEXT, track_locate_type TEXT, track_locate_isupdate TEXT, track_utc_time LONG );");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) throws SQLException {
        m26908v(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
    }

    /* renamed from: s */
    public SQLiteDatabase m26906s() {
        if (f20339a == null) {
            return null;
        }
        try {
            return f20339a.getReadableDatabase();
        } catch (Exception unused) {
            C13981a.m83988e("LocateTrackDbHelper", "getReadableDatabases Exception:");
            return null;
        }
    }

    /* renamed from: t */
    public SQLiteDatabase m26907t() {
        if (f20339a == null) {
            return null;
        }
        try {
            return f20339a.getWritableDatabase();
        } catch (Exception unused) {
            C13981a.m83988e("LocateTrackDbHelper", "LocateTrackDbHelper getWritableDatabases RuntimeException:");
            return null;
        }
    }

    /* renamed from: v */
    public final void m26908v(SQLiteDatabase sQLiteDatabase) throws SQLException {
        m26905g(sQLiteDatabase);
        onCreate(sQLiteDatabase);
    }
}
