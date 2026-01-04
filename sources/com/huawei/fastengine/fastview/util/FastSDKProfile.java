package com.huawei.fastengine.fastview.util;

import android.util.Log;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes5.dex */
public class FastSDKProfile {
    private static final String TAG = "FastProfile";
    private static Map<String, Long> recordMap = new ConcurrentHashMap();

    public static void begin(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        Log.i(TAG, "[begin] [sdk] [" + str + "] " + jCurrentTimeMillis);
        recordMap.put(str, Long.valueOf(jCurrentTimeMillis));
    }

    public static void end(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        Log.i(TAG, "[end] [sdk] [" + str + "] " + jCurrentTimeMillis);
        Long lRemove = recordMap.remove(str);
        if (lRemove != null) {
            Log.i(TAG, "[dur] [sdk] [" + str + "] " + (jCurrentTimeMillis - lRemove.longValue()));
        }
    }

    public static void log(String str) {
        Log.i(TAG, "[log] [sdk] [" + str + "] " + System.currentTimeMillis());
    }
}
