package com.huawei.android.hicloud.drive.clouddisk.expand.p085db;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.huawei.android.hicloud.drive.clouddisk.expand.MediaBase;
import com.huawei.android.hicloud.drive.clouddisk.model.DownloadBuilder;
import fk.C9721b;
import hk.C10278a;
import java.io.File;
import java.util.Iterator;
import p015ak.C0213f;
import p514o9.C11839m;

/* loaded from: classes3.dex */
public class DriveDBManager {
    private static final String TAG = "DriveDBManager";

    /* renamed from: db */
    private static volatile SQLiteDatabase f12204db;

    private DriveDBManager() {
    }

    public static void clear() throws SQLException {
        C11839m.m70688i(TAG, "clear db");
        DriveDatabaseHelper.getInstance(getContext()).clear(getDB());
        deleteFile(C10278a.m63441g(getContext().getExternalFilesDir(""), MediaBase.SERVICE_DIR));
        deleteFile(C10278a.m63441g(getContext().getFilesDir(), MediaBase.SERVICE_DIR));
    }

    public static void clearFileSliceCache(String str, String str2) throws SQLException {
        C11839m.m70688i(TAG, "clearFileCache:" + str);
        try {
            if (TextUtils.isEmpty(str2)) {
                C11839m.m70688i(TAG, "clearFileSliceCache filePath is null.");
                return;
            }
            DownloadBuilder path = new DownloadBuilder(str).setPath(str2);
            Iterator<DownloadBuilder> it = new StatusDownload(path).query(getDB()).iterator();
            while (it.hasNext()) {
                String uuid = it.next().getUuid();
                if (uuid != null && !uuid.isEmpty()) {
                    File fileM63441g = C10278a.m63441g(getContext().getFilesDir(), ".core_syncDrv/" + uuid);
                    if (fileM63441g.exists()) {
                        C11839m.m70686d(TAG, "finally cache file exits, delete = " + fileM63441g.delete());
                    }
                    File fileM63441g2 = C10278a.m63441g(getContext().getExternalFilesDir(""), ".core_syncDrv/" + uuid);
                    if (fileM63441g2.exists()) {
                        C11839m.m70686d(TAG, "finally cache fileExternal exits, delete = " + fileM63441g2.delete());
                    }
                }
            }
            new StatusDownload(path).delete(getDB());
        } catch (C9721b e10) {
            C11839m.m70688i(TAG, "clearFileCache" + e10.toString());
        }
    }

    private static boolean deleteFile(File file) {
        File[] fileArrM63440f;
        if (file == null || !file.exists()) {
            return true;
        }
        if (file.isDirectory() && (fileArrM63440f = C10278a.m63440f(file)) != null) {
            for (File file2 : fileArrM63440f) {
                deleteFile(file2);
            }
        }
        return file.delete();
    }

    private static Context getContext() {
        return C0213f.m1379c();
    }

    public static synchronized SQLiteDatabase getDB() {
        if (f12204db == null) {
            try {
                f12204db = DriveDatabaseHelper.getInstance(getContext()).getWritableDatabase();
            } catch (SQLiteException e10) {
                C11839m.m70687e(TAG, "getDB() error, " + e10.getMessage());
            }
        }
        return f12204db;
    }
}
