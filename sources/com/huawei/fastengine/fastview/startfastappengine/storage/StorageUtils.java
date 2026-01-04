package com.huawei.fastengine.fastview.startfastappengine.storage;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.SnapshotDBManager;
import com.huawei.fastengine.fastview.download.utils.log.FastViewLogUtils;
import java.io.File;
import java.io.IOException;

/* loaded from: classes5.dex */
public class StorageUtils {
    private static final String APP_ENGINE = "fastappEngine";
    private static final String TAG = "StorageUtils";

    public static String getCacheStoragePath(Context context, String str) throws IOException {
        String canonicalPath;
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                canonicalPath = context.getCacheDir().getCanonicalPath();
            } catch (IOException unused) {
                FastViewLogUtils.m28724e(TAG, "getCanonicalPath exception");
                canonicalPath = null;
            }
            if (canonicalPath != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(canonicalPath);
                String str2 = File.separator;
                sb2.append(str2);
                sb2.append(APP_ENGINE);
                sb2.append(str2);
                sb2.append(str);
                return sb2.toString();
            }
        }
        return null;
    }

    public static String getDatabasePath(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            File databasePath = context.getDatabasePath("app.card." + str + SnapshotDBManager.SUFFIX_DATABASE_NAME);
            if (databasePath != null && databasePath.exists()) {
                try {
                    return databasePath.getCanonicalPath();
                } catch (IOException unused) {
                    FastViewLogUtils.m28724e(TAG, "getCanonicalPath exception");
                }
            }
        }
        return null;
    }

    public static String getExternalMassPath(Context context, String str) throws IOException {
        String canonicalPath;
        if ("mounted".equals(Environment.getExternalStorageState()) && context != null && !TextUtils.isEmpty(str)) {
            try {
                canonicalPath = context.getExternalFilesDir(APP_ENGINE).getCanonicalPath();
            } catch (Exception unused) {
                FastViewLogUtils.m28724e(TAG, "getCanonicalPath exception");
                canonicalPath = null;
            }
            if (canonicalPath != null) {
                return canonicalPath + File.separator + str;
            }
        }
        return null;
    }

    public static String getFileStoragePath(Context context, String str) throws IOException {
        String canonicalPath;
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                canonicalPath = context.getFilesDir().getCanonicalPath();
            } catch (IOException unused) {
                FastViewLogUtils.m28724e(TAG, "getCanonicalPath exception");
                canonicalPath = null;
            }
            if (canonicalPath != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(canonicalPath);
                String str2 = File.separator;
                sb2.append(str2);
                sb2.append(APP_ENGINE);
                sb2.append(str2);
                sb2.append(str);
                return sb2.toString();
            }
        }
        return null;
    }
}
