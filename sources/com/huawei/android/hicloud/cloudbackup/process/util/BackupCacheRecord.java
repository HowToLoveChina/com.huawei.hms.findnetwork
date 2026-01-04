package com.huawei.android.hicloud.cloudbackup.process.util;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Map;
import p015ak.C0214f0;
import p514o9.C11839m;

/* loaded from: classes2.dex */
public class BackupCacheRecord {
    private static final String BACKUP_CACHE_TIME_RECORD = "backup_cache_time_record";
    public static final long DEFAULT_TIME = -1;
    private static final String TAG = "BackupCacheRecord";

    public static void clear(Context context) {
        SharedPreferences sp2 = getSp(context);
        if (sp2 == null) {
            C11839m.m70688i(TAG, "clear sp is null");
        } else {
            sp2.edit().clear().apply();
        }
    }

    public static void delete(Context context, String str) {
        SharedPreferences sp2 = getSp(context);
        if (sp2 == null) {
            C11839m.m70688i(TAG, "delete sp is null");
        } else {
            sp2.edit().remove(str).apply();
        }
    }

    public static Map<String, ?> getAll(Context context) {
        SharedPreferences sp2 = getSp(context);
        if (sp2 != null) {
            return sp2.getAll();
        }
        C11839m.m70688i(TAG, "getAll sp is null");
        return new HashMap();
    }

    private static SharedPreferences getSp(Context context) {
        return C0214f0.m1382b(context, BACKUP_CACHE_TIME_RECORD, 0);
    }

    public static void setLastCacheTime(Context context, String str, long j10) {
        getSp(context).edit().putLong(str, j10).apply();
    }
}
