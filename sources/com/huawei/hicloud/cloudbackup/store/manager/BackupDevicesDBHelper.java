package com.huawei.hicloud.cloudbackup.store.manager;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.huawei.hicloud.request.cbs.bean.CBSDevice;
import com.huawei.hms.network.embedded.C6148x2;
import java.util.List;
import mk.C11477c;
import p514o9.C11839m;

/* loaded from: classes6.dex */
public class BackupDevicesDBHelper extends SQLiteOpenHelper {

    /* renamed from: a */
    public static final Object f22411a = new Object();

    /* renamed from: b */
    public static volatile BackupDevicesDBHelper f22412b;

    public BackupDevicesDBHelper(Context context) {
        super(context, "cloudbackup_device_remove.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    /* renamed from: w */
    public static BackupDevicesDBHelper m29555w(Context context) {
        if (f22412b == null) {
            synchronized (f22411a) {
                try {
                    if (f22412b == null) {
                        f22412b = new BackupDevicesDBHelper(context.createDeviceProtectedStorageContext());
                    }
                } finally {
                }
            }
        }
        return f22412b;
    }

    /* renamed from: b */
    public boolean m29556b(Context context) throws SQLException {
        C11839m.m70688i("BackupDevicesDBHelper", "clearDB");
        SQLiteDatabase sQLiteDatabaseM29561x = m29561x();
        if (sQLiteDatabaseM29561x == null) {
            C11839m.m70689w("BackupDevicesDBHelper", "db null");
            return false;
        }
        sQLiteDatabaseM29561x.execSQL("DROP TABLE IF EXISTS backup_device");
        sQLiteDatabaseM29561x.close();
        f22412b = null;
        return context.createDeviceProtectedStorageContext().deleteDatabase("cloudbackup_device_remove.db");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        C11839m.m70686d("BackupDevicesDBHelper", "onCreate");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS backup_device (_id INTEGER PRIMARY KEY,device_id TEXT,device_type TEXT,dev_display_name TEXT,device_category TEXT,device_space TEXT,bak_update_time TEXT,backup_device_id TEXT,app_version TEXT);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) throws SQLException {
        C11839m.m70686d("BackupDevicesDBHelper", "onDowngrade");
        m29559u(sQLiteDatabase);
        onCreate(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        C11839m.m70686d("BackupDevicesDBHelper", "onUpgrade");
    }

    /* renamed from: s */
    public void m29557s() throws SQLException {
        SQLiteDatabase sQLiteDatabaseM29561x = m29561x();
        if (sQLiteDatabaseM29561x == null) {
            C11839m.m70689w("BackupDevicesDBHelper", "db null");
        } else {
            sQLiteDatabaseM29561x.execSQL("CREATE TABLE IF NOT EXISTS backup_device (_id INTEGER PRIMARY KEY,device_id TEXT,device_type TEXT,dev_display_name TEXT,device_category TEXT,device_space TEXT,bak_update_time TEXT,backup_device_id TEXT,app_version TEXT);");
            sQLiteDatabaseM29561x.close();
        }
    }

    /* renamed from: t */
    public long m29558t(String str) {
        C11839m.m70688i("BackupDevicesDBHelper", "deleteDevice");
        SQLiteDatabase sQLiteDatabaseM29561x = m29561x();
        if (sQLiteDatabaseM29561x == null) {
            C11839m.m70689w("BackupDevicesDBHelper", "db null");
            return -1L;
        }
        long jDelete = sQLiteDatabaseM29561x.delete("backup_device", "device_id = ?", new String[]{C11477c.m68636f(str)});
        sQLiteDatabaseM29561x.close();
        return jDelete;
    }

    /* renamed from: u */
    public final void m29559u(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS backup_device");
    }

    /* renamed from: v */
    public void m29560v() throws SQLException {
        SQLiteDatabase sQLiteDatabaseM29561x = m29561x();
        if (sQLiteDatabaseM29561x == null) {
            C11839m.m70689w("BackupDevicesDBHelper", "db null");
        } else {
            sQLiteDatabaseM29561x.execSQL("DROP TABLE IF EXISTS backup_device");
            sQLiteDatabaseM29561x.close();
        }
    }

    /* renamed from: x */
    public final SQLiteDatabase m29561x() {
        if (f22412b == null) {
            C11839m.m70689w("BackupDevicesDBHelper", "sDbHelper null");
            return null;
        }
        try {
            return f22412b.getWritableDatabase();
        } catch (Exception unused) {
            C11839m.m70687e("BackupDevicesDBHelper", "getWritableDatabases RuntimeException");
            return null;
        }
    }

    /* renamed from: y */
    public void m29562y(List<CBSDevice> list) {
        C11839m.m70688i("BackupDevicesDBHelper", "insertDeviceList");
        if (list == null) {
            C11839m.m70689w("BackupDevicesDBHelper", "list null");
            return;
        }
        synchronized (this) {
            try {
                SQLiteDatabase sQLiteDatabaseM29561x = m29561x();
                if (sQLiteDatabaseM29561x == null) {
                    C11839m.m70689w("BackupDevicesDBHelper", "db null");
                    return;
                }
                for (int i10 = 0; i10 < list.size(); i10++) {
                    CBSDevice cBSDevice = list.get(i10);
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(C6148x2.DEVICE_ID, C11477c.m68636f(cBSDevice.getDeviceId()));
                    contentValues.put("device_type", Integer.valueOf(cBSDevice.getDeviceType()));
                    contentValues.put("dev_display_name", cBSDevice.getDevDisplayName());
                    contentValues.put("device_category", cBSDevice.getDeviceCategory());
                    contentValues.put("device_space", cBSDevice.getDeviceSpace());
                    contentValues.put("bak_update_time", cBSDevice.getBakUpdateTime());
                    contentValues.put("backup_device_id", C11477c.m68636f(cBSDevice.getBackupDeviceId()));
                    contentValues.put("app_version", cBSDevice.getAppVersion());
                    C11839m.m70686d("BackupDevicesDBHelper", "insert result:" + sQLiteDatabaseM29561x.insert("backup_device", "", contentValues));
                }
                sQLiteDatabaseM29561x.close();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
