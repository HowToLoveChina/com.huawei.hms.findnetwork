package com.huawei.android.remotecontrol.bluetooth.ancillarydevice;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.huawei.hms.network.embedded.C6148x2;
import java.util.ArrayList;
import java.util.List;
import p013ah.C0198c;
import p237du.C9310c;
import p809yg.C13981a;

/* loaded from: classes4.dex */
public class AncillaryDeviceDBHelper extends SQLiteOpenHelper {

    /* renamed from: a */
    public static volatile AncillaryDeviceDBHelper f19751a;

    /* renamed from: b */
    public static final Object f19752b = new Object();

    public AncillaryDeviceDBHelper(Context context) {
        super(context, "phonefinder_ancillary_device.db", (SQLiteDatabase.CursorFactory) null, 2);
    }

    /* renamed from: C */
    public static void m26044C(AncillaryDeviceDBHelper ancillaryDeviceDBHelper) {
        f19751a = ancillaryDeviceDBHelper;
    }

    /* renamed from: e */
    public static AncillaryDeviceDBHelper m26045e(Context context) {
        if (f19751a == null) {
            synchronized (f19752b) {
                try {
                    if (f19751a == null) {
                        f19751a = new AncillaryDeviceDBHelper(context.createDeviceProtectedStorageContext());
                    }
                } finally {
                }
            }
        }
        return f19751a;
    }

    /* renamed from: A */
    public List<String> m26046A(Context context, String str) {
        C13981a.m83989i("AncillaryDeviceDBHelper", "queryUpdateDeviceInfo");
        SQLiteDatabase sQLiteDatabaseM26052s = m26052s();
        Cursor cursorQuery = null;
        if (sQLiteDatabaseM26052s == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            try {
                cursorQuery = sQLiteDatabaseM26052s.query("ancillary_device", new String[]{"device_info"}, "update_flag = ?", new String[]{str}, null, null, "create_time");
                if (cursorQuery != null && cursorQuery.getCount() > 0) {
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(C0198c.m1097a(context, cursorQuery.getString(cursorQuery.getColumnIndex("device_info"))));
                    }
                }
            } catch (Exception e10) {
                C13981a.m83988e("AncillaryDeviceDBHelper", "queryUpdateDeviceInfo Exception:" + e10.getMessage());
                if (cursorQuery != null) {
                }
            }
            return arrayList;
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            sQLiteDatabaseM26052s.close();
        }
    }

    /* renamed from: B */
    public long m26047B(Context context, String str, String str2) {
        C13981a.m83989i("AncillaryDeviceDBHelper", "setDeviceActiveFlag");
        synchronized (this) {
            try {
                SQLiteDatabase sQLiteDatabaseM26054u = m26054u();
                if (sQLiteDatabaseM26054u == null) {
                    return -1L;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("report_flag", str2);
                contentValues.put("create_time", Long.valueOf(System.currentTimeMillis()));
                long jUpdate = sQLiteDatabaseM26054u.update("ancillary_device", contentValues, "device_id = ?", new String[]{C9310c.m58618b(str)});
                sQLiteDatabaseM26054u.close();
                return jUpdate;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: D */
    public long m26048D(Context context, String str, String str2, String str3, String str4) {
        C13981a.m83989i("AncillaryDeviceDBHelper", "updateDeviceInfo");
        SQLiteDatabase sQLiteDatabaseM26054u = m26054u();
        long jUpdate = -1;
        if (sQLiteDatabaseM26054u == null) {
            return -1L;
        }
        try {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("update_flag", str2);
                contentValues.put("create_time", Long.valueOf(System.currentTimeMillis()));
                if (!TextUtils.isEmpty(str3)) {
                    contentValues.put("device_info", C0198c.m1098b(context, str3));
                }
                if (!TextUtils.isEmpty(str4)) {
                    contentValues.put("sub_device_type", str4);
                }
                jUpdate = sQLiteDatabaseM26054u.update("ancillary_device", contentValues, "device_id = ?", new String[]{C9310c.m58618b(str)});
            } catch (Exception e10) {
                C13981a.m83988e("AncillaryDeviceDBHelper", "updateDeviceInfo, Exception: " + e10.getMessage());
            }
            sQLiteDatabaseM26054u.close();
            return jUpdate;
        } catch (Throwable th2) {
            sQLiteDatabaseM26054u.close();
            throw th2;
        }
    }

    /* renamed from: b */
    public boolean m26049b(Context context) throws SQLException {
        SQLiteDatabase sQLiteDatabaseM26054u = m26054u();
        if (sQLiteDatabaseM26054u == null) {
            return false;
        }
        sQLiteDatabaseM26054u.execSQL("DROP TABLE IF EXISTS ancillary_device");
        sQLiteDatabaseM26054u.close();
        m26044C(null);
        return context.createDeviceProtectedStorageContext().deleteDatabase("phonefinder_ancillary_device.db");
    }

    /* renamed from: c */
    public long m26050c(String str) {
        C13981a.m83989i("AncillaryDeviceDBHelper", "deleteAncDeviceInfo");
        SQLiteDatabase sQLiteDatabaseM26054u = m26054u();
        if (sQLiteDatabaseM26054u == null) {
            return -1L;
        }
        long jDelete = sQLiteDatabaseM26054u.delete("ancillary_device", "device_id = ?", new String[]{C9310c.m58618b(str)});
        sQLiteDatabaseM26054u.close();
        return jDelete;
    }

    /* renamed from: d */
    public final void m26051d(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ancillary_device");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS ancillary_device (_id INTEGER PRIMARY KEY,device_id TEXT, report_flag TEXT, device_info TEXT, update_flag TEXT, sub_device_type TEXT, create_time LONG,per_device_type TEXT  );");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) throws SQLException {
        m26051d(sQLiteDatabase);
        onCreate(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) throws SQLException {
        if (i10 < 2) {
            sQLiteDatabase.execSQL("Alter table ancillary_device add column per_device_type TEXT  default '1' ");
        }
    }

    /* renamed from: s */
    public final SQLiteDatabase m26052s() {
        if (f19751a == null) {
            return null;
        }
        try {
            return f19751a.getReadableDatabase();
        } catch (Exception unused) {
            C13981a.m83988e("AncillaryDeviceDBHelper", "getReadableDatabases Exception:");
            return null;
        }
    }

    /* renamed from: t */
    public String m26053t(String str) {
        C13981a.m83989i("AncillaryDeviceDBHelper", "getReportFlag");
        String string = "";
        synchronized (this) {
            SQLiteDatabase sQLiteDatabaseM26052s = m26052s();
            Cursor cursorQuery = null;
            if (sQLiteDatabaseM26052s == null) {
                return null;
            }
            try {
                try {
                    cursorQuery = sQLiteDatabaseM26052s.query("ancillary_device", new String[]{"report_flag"}, "device_id = ?", new String[]{C9310c.m58618b(str)}, null, null, "create_time");
                    if (cursorQuery != null && cursorQuery.getCount() > 0) {
                        while (cursorQuery.moveToNext()) {
                            string = cursorQuery.getString(cursorQuery.getColumnIndex("report_flag"));
                        }
                    }
                } finally {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    sQLiteDatabaseM26052s.close();
                }
            } catch (Exception e10) {
                C13981a.m83988e("AncillaryDeviceDBHelper", "getReportFlag Exception:" + e10.getMessage());
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
            return string;
        }
    }

    /* renamed from: u */
    public final SQLiteDatabase m26054u() {
        if (f19751a == null) {
            return null;
        }
        try {
            return f19751a.getWritableDatabase();
        } catch (Exception unused) {
            C13981a.m83988e("AncillaryDeviceDBHelper", "AncillaryDeviceDBHelper getWritableDatabases RuntimeException:");
            return null;
        }
    }

    /* renamed from: v */
    public long m26055v(Context context, String str, String str2, String str3, String str4, String str5) {
        C13981a.m83989i("AncillaryDeviceDBHelper", "insertAncDeviceInfo");
        synchronized (this) {
            try {
                SQLiteDatabase sQLiteDatabaseM26054u = m26054u();
                if (sQLiteDatabaseM26054u == null) {
                    return -1L;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put(C6148x2.DEVICE_ID, C9310c.m58618b(str));
                contentValues.put("per_device_type", str2);
                contentValues.put("report_flag", str3);
                contentValues.put("device_info", C0198c.m1098b(context, str4));
                contentValues.put("update_flag", (Integer) 1);
                contentValues.put("sub_device_type", str5);
                contentValues.put("create_time", Long.valueOf(System.currentTimeMillis()));
                long jInsert = sQLiteDatabaseM26054u.insert("ancillary_device", "", contentValues);
                sQLiteDatabaseM26054u.close();
                return jInsert;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: w */
    public List<String> m26056w(Context context, String str, String str2) {
        C13981a.m83989i("AncillaryDeviceDBHelper", "queryActiveDeviceInfo");
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            SQLiteDatabase sQLiteDatabaseM26052s = m26052s();
            Cursor cursorQuery = null;
            try {
                if (sQLiteDatabaseM26052s == null) {
                    return null;
                }
                try {
                    StringBuilder sb2 = new StringBuilder("report_flag = ?");
                    if (!str2.equals("0")) {
                        sb2.append(" AND per_device_type = ?");
                    }
                    cursorQuery = sQLiteDatabaseM26052s.query("ancillary_device", new String[]{"device_info"}, sb2.toString(), str2.equals("0") ? new String[]{str} : new String[]{str, str2}, null, null, "create_time");
                    if (cursorQuery != null && cursorQuery.getCount() > 0) {
                        while (cursorQuery.moveToNext()) {
                            arrayList.add(C0198c.m1097a(context, cursorQuery.getString(cursorQuery.getColumnIndex("device_info"))));
                        }
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                } catch (Exception e10) {
                    C13981a.m83988e("AncillaryDeviceDBHelper", "queryActiveDeviceInfo Exception:" + e10.getMessage());
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                }
                sQLiteDatabaseM26052s.close();
                return arrayList;
            } catch (Throwable th2) {
                if (0 != 0) {
                    cursorQuery.close();
                }
                sQLiteDatabaseM26052s.close();
                throw th2;
            }
        }
    }

    /* renamed from: x */
    public boolean m26057x(String str) {
        C13981a.m83989i("AncillaryDeviceDBHelper", "queryFinderDevice");
        synchronized (this) {
            SQLiteDatabase sQLiteDatabaseM26052s = m26052s();
            boolean z10 = false;
            if (sQLiteDatabaseM26052s == null) {
                return false;
            }
            Cursor cursorQuery = null;
            try {
                try {
                    cursorQuery = sQLiteDatabaseM26052s.query("ancillary_device", new String[]{"device_info"}, "device_id = ?", new String[]{C9310c.m58618b(str)}, null, null, "create_time");
                    if (cursorQuery != null) {
                        if (cursorQuery.getCount() > 0) {
                            z10 = true;
                        }
                    }
                } finally {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    sQLiteDatabaseM26052s.close();
                }
            } catch (Exception e10) {
                C13981a.m83988e("AncillaryDeviceDBHelper", "queryFinderDevice Exception:" + e10.getMessage());
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
            return z10;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* renamed from: y */
    public String m26058y(String str) {
        Cursor cursorQuery;
        C13981a.m83989i("AncillaryDeviceDBHelper", "queryFinderDevice");
        synchronized (this) {
            SQLiteDatabase sQLiteDatabaseM26052s = m26052s();
            String string = null;
            try {
                if (sQLiteDatabaseM26052s == null) {
                    return null;
                }
                try {
                    cursorQuery = sQLiteDatabaseM26052s.query("ancillary_device", new String[]{"device_info"}, "device_id = ?", new String[]{str}, null, null, "create_time");
                    if (cursorQuery != null) {
                        try {
                            if (cursorQuery.getCount() > 0 && cursorQuery.moveToFirst()) {
                                string = cursorQuery.getString(cursorQuery.getColumnIndex("device_info"));
                            }
                        } catch (Exception e10) {
                            e = e10;
                            C13981a.m83988e("AncillaryDeviceDBHelper", "queryFinderDevice Exception:" + e.getMessage());
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            sQLiteDatabaseM26052s.close();
                            return string;
                        }
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                } catch (Exception e11) {
                    e = e11;
                    cursorQuery = null;
                } catch (Throwable th2) {
                    th = th2;
                    str = 0;
                    if (str != 0) {
                        str.close();
                    }
                    sQLiteDatabaseM26052s.close();
                    throw th;
                }
                sQLiteDatabaseM26052s.close();
                return string;
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    /* renamed from: z */
    public String m26059z(String str) {
        C13981a.m83989i("AncillaryDeviceDBHelper", "querySubDeviceType");
        String string = "";
        synchronized (this) {
            SQLiteDatabase sQLiteDatabaseM26052s = m26052s();
            Cursor cursorQuery = null;
            if (sQLiteDatabaseM26052s == null) {
                return null;
            }
            try {
                try {
                    cursorQuery = sQLiteDatabaseM26052s.query("ancillary_device", new String[]{"sub_device_type"}, "device_id = ?", new String[]{C9310c.m58618b(str)}, null, null, "create_time");
                    if (cursorQuery != null && cursorQuery.getCount() > 0) {
                        while (cursorQuery.moveToNext()) {
                            string = cursorQuery.getString(cursorQuery.getColumnIndex("sub_device_type"));
                        }
                    }
                } finally {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    sQLiteDatabaseM26052s.close();
                }
            } catch (Exception e10) {
                C13981a.m83988e("AncillaryDeviceDBHelper", "querySubDeviceType Exception:" + e10.getMessage());
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
            return string;
        }
    }
}
