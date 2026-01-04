package org.chromium.net;

import android.net.TrafficStats;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes9.dex */
public class ThreadStatsUid {
    private static final Method sClearThreadStatsUid;
    private static final Method sSetThreadStatsUid;

    static {
        try {
            sSetThreadStatsUid = TrafficStats.class.getMethod("setThreadStatsUid", Integer.TYPE);
            sClearThreadStatsUid = TrafficStats.class.getMethod("clearThreadStatsUid", new Class[0]);
        } catch (NoSuchMethodException | SecurityException e10) {
            throw new RuntimeException("Unable to get TrafficStats methods", e10);
        }
    }

    public static void clear() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            sClearThreadStatsUid.invoke(null, new Object[0]);
        } catch (IllegalAccessException e10) {
            throw new RuntimeException("TrafficStats.clearThreadStatsUid failed", e10);
        } catch (InvocationTargetException e11) {
            throw new RuntimeException("TrafficStats.clearThreadStatsUid failed", e11);
        }
    }

    public static void set(int i10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            sSetThreadStatsUid.invoke(null, Integer.valueOf(i10));
        } catch (IllegalAccessException e10) {
            throw new RuntimeException("TrafficStats.setThreadStatsUid failed", e10);
        } catch (InvocationTargetException e11) {
            throw new RuntimeException("TrafficStats.setThreadStatsUid failed", e11);
        }
    }
}
