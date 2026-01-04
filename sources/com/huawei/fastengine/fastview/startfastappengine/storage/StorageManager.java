package com.huawei.fastengine.fastview.startfastappengine.storage;

import android.content.Context;
import com.huawei.fastengine.fastview.download.utils.StringUtils;
import com.huawei.fastengine.fastview.download.utils.log.FastViewLogUtils;
import com.huawei.fastengine.fastview.util.IOFileUtils;
import java.io.File;
import java.io.IOException;
import java.util.List;

/* loaded from: classes5.dex */
public class StorageManager {
    private static final String TAG = "StorageManager";

    private static void clearCacheStorage(String str, Context context) throws IOException {
        String cacheStoragePath = StorageUtils.getCacheStoragePath(context, str);
        if (!IOFileUtils.isExist(cacheStoragePath)) {
            FastViewLogUtils.m28724e(TAG, "clearCacheStorage| file do not exist.");
            return;
        }
        try {
            IOFileUtils.deleteDirectory(new File(cacheStoragePath));
        } catch (IOException e10) {
            FastViewLogUtils.m28724e(TAG, "clearCacheStorage | e:" + e10);
        }
    }

    private static void clearDatabaseStorage(String str, Context context) {
        String str2;
        String databasePath = StorageUtils.getDatabasePath(context, str);
        if (StringUtils.isEmpty(databasePath)) {
            str2 = "clearDatabaseStorage | dbFilePath is empty.";
        } else {
            if (IOFileUtils.isExist(databasePath)) {
                try {
                    IOFileUtils.forceDelete(new File(databasePath));
                    return;
                } catch (IOException e10) {
                    FastViewLogUtils.m28724e(TAG, "clearDatabaseStorage | e:" + e10);
                    return;
                }
            }
            str2 = "clearDatabaseStorage| file do not exist.";
        }
        FastViewLogUtils.m28724e(TAG, str2);
    }

    private static void clearFileStorage(String str, Context context) throws IOException {
        String fileStoragePath = StorageUtils.getFileStoragePath(context, str);
        if (!IOFileUtils.isExist(fileStoragePath)) {
            FastViewLogUtils.m28724e(TAG, "clearFileStorage| file do not exist.");
            return;
        }
        try {
            IOFileUtils.deleteDirectory(new File(fileStoragePath));
        } catch (IOException e10) {
            FastViewLogUtils.m28724e(TAG, "clearFileStorage | e:" + e10);
        }
    }

    private static void clearMassStorage(String str, Context context) throws IOException {
        String str2;
        String externalMassPath = StorageUtils.getExternalMassPath(context, str);
        if (StringUtils.isEmpty(externalMassPath)) {
            str2 = "clearMassStorage | massStorage is empty.";
        } else {
            if (IOFileUtils.isExist(externalMassPath)) {
                try {
                    IOFileUtils.deleteDirectory(new File(externalMassPath));
                    return;
                } catch (IOException e10) {
                    FastViewLogUtils.m28724e(TAG, "clearMassStorage | e:" + e10);
                    return;
                }
            }
            str2 = "clearMassStorage| file do not exist.";
        }
        FastViewLogUtils.m28724e(TAG, str2);
    }

    public static void clearStorage(Context context, String str, List<StorageType> list) throws IOException {
        String str2;
        if (context == null) {
            str2 = "clearStorage | context is null.";
        } else {
            if (!StringUtils.isEmpty(str) && list != null && list.size() != 0) {
                if (StringUtils.isEmpty(context.getPackageName())) {
                    return;
                }
                if (list.contains(StorageType.STORAGE_MASS)) {
                    clearMassStorage(str, context);
                }
                if (list.contains(StorageType.STORAGE_CACHE)) {
                    clearCacheStorage(str, context);
                }
                if (list.contains(StorageType.STORAGE_DATABASE)) {
                    clearDatabaseStorage(str, context);
                }
                if (list.contains(StorageType.STORAGE_FILE)) {
                    clearFileStorage(str, context);
                    return;
                }
                return;
            }
            str2 = "clearStorage | rpkName is null or storageTypeList is invalid.";
        }
        FastViewLogUtils.m28724e(TAG, str2);
    }
}
