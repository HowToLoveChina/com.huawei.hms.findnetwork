package com.huawei.android.remotecontrol.bluetooth.locate;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;
import p013ah.C0198c;
import p237du.C9310c;
import p809yg.C13981a;

/* loaded from: classes4.dex */
public class LocateHistoryDbHelper extends SQLiteOpenHelper {

    /* renamed from: a */
    public static volatile LocateHistoryDbHelper f19775a;

    /* renamed from: b */
    public static final Object f19776b = new Object();

    public LocateHistoryDbHelper(Context context) {
        super(context, "phonefinder_locate_his.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    /* renamed from: e */
    public static LocateHistoryDbHelper m26135e(Context context) {
        if (f19775a == null) {
            synchronized (f19776b) {
                try {
                    if (f19775a == null) {
                        f19775a = new LocateHistoryDbHelper(context.createDeviceProtectedStorageContext());
                    }
                } finally {
                }
            }
        }
        return f19775a;
    }

    /* renamed from: v */
    public static void m26136v(LocateHistoryDbHelper locateHistoryDbHelper) {
        f19775a = locateHistoryDbHelper;
    }

    /* renamed from: b */
    public boolean m26137b(Context context) throws SQLException {
        SQLiteDatabase sQLiteDatabaseM26141t = m26141t();
        if (sQLiteDatabaseM26141t == null) {
            return false;
        }
        sQLiteDatabaseM26141t.execSQL("DROP TABLE IF EXISTS locate_his");
        sQLiteDatabaseM26141t.close();
        m26136v(null);
        return context.createDeviceProtectedStorageContext().deleteDatabase("phonefinder_locate_his.db");
    }

    /* renamed from: c */
    public long m26138c(String str, String str2) {
        C13981a.m83989i("LocateTrackDbHelper", "deleteCptLocateInfo");
        if (m26141t() == null) {
            return -1L;
        }
        return r2.delete("locate_his", "locate_device_id = ? and locate_cpt_type = ?", new String[]{C9310c.m58618b(str), str2});
    }

    /* renamed from: d */
    public final void m26139d(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS locate_his");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS locate_his (_id INTEGER PRIMARY KEY,locate_device_id TEXT, locate_cpt_type TEXT, locate_info TEXT, locate_time LONG );");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) throws SQLException {
        m26139d(sQLiteDatabase);
        onCreate(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
    }

    /* renamed from: s */
    public final SQLiteDatabase m26140s() {
        if (f19775a == null) {
            return null;
        }
        try {
            return f19775a.getReadableDatabase();
        } catch (Exception unused) {
            C13981a.m83988e("LocateTrackDbHelper", "getReadableDatabases Exception:");
            return null;
        }
    }

    /* renamed from: t */
    public final SQLiteDatabase m26141t() {
        if (f19775a == null) {
            return null;
        }
        try {
            return f19775a.getWritableDatabase();
        } catch (Exception unused) {
            C13981a.m83988e("LocateTrackDbHelper", "LocateTrackDbHelper getWritableDatabases RuntimeException:");
            return null;
        }
    }

    /* renamed from: u */
    public List<String> m26142u(Context context, String str, String str2) {
        C13981a.m83989i("LocateTrackDbHelper", "queryLocateInfo");
        SQLiteDatabase sQLiteDatabaseM26140s = m26140s();
        Cursor cursorQuery = null;
        if (sQLiteDatabaseM26140s == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            try {
                cursorQuery = sQLiteDatabaseM26140s.query("locate_his", new String[]{"locate_info"}, "locate_device_id = ? and locate_cpt_type = ?", new String[]{C9310c.m58618b(str), str2}, null, null, "locate_time");
                if (cursorQuery != null && cursorQuery.getCount() > 0) {
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(C0198c.m1097a(context, cursorQuery.getString(cursorQuery.getColumnIndex("locate_info"))));
                    }
                }
            } catch (Exception unused) {
                C13981a.m83988e("LocateTrackDbHelper", "queryLocateInfo Exception:");
                if (cursorQuery != null) {
                }
            }
            return arrayList;
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            sQLiteDatabaseM26140s.close();
        }
    }

    /* renamed from: w */
    public long m26143w(Context context, String str, String str2, String str3) {
        C13981a.m83989i("LocateTrackDbHelper", "updateCptLocateInfo");
        SQLiteDatabase sQLiteDatabaseM26141t = m26141t();
        if (sQLiteDatabaseM26141t == null) {
            return -1L;
        }
        List<String> listM26142u = m26142u(context, str, str2);
        if (listM26142u != null && listM26142u.size() > 0) {
            sQLiteDatabaseM26141t.delete("locate_his", "locate_device_id = ? and locate_cpt_type = ?", new String[]{C9310c.m58618b(str), str2});
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("locate_device_id", C9310c.m58618b(str));
        contentValues.put("locate_cpt_type", str2);
        contentValues.put("locate_info", C0198c.m1098b(context, str3));
        contentValues.put("locate_time", Long.valueOf(System.currentTimeMillis()));
        long jInsert = sQLiteDatabaseM26141t.insert("locate_his", "", contentValues);
        sQLiteDatabaseM26141t.close();
        return jInsert;
    }
}
