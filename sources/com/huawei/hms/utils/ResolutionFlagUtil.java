package com.huawei.hms.utils;

import android.text.TextUtils;
import com.huawei.hms.support.log.HMSLog;
import java.sql.Timestamp;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes8.dex */
public class ResolutionFlagUtil {

    /* renamed from: a */
    private static volatile ResolutionFlagUtil f30209a;

    /* renamed from: b */
    private static final Map<String, Long> f30210b = new ConcurrentHashMap();

    /* renamed from: c */
    private static final Object f30211c = new Object();

    private ResolutionFlagUtil() {
    }

    /* renamed from: a */
    private void m37082a() {
        long time = new Timestamp(System.currentTimeMillis()).getTime() - 10800000;
        for (String str : f30210b.keySet()) {
            Map<String, Long> map = f30210b;
            Long l10 = map.get(str);
            if (l10 == null || l10.longValue() == 0) {
                map.remove(str);
                HMSLog.m36988i("ResolutionFlagUtil", "remove resolution flag because the data in this pair was abnormal: " + str);
            } else if (time >= l10.longValue()) {
                map.remove(str);
                HMSLog.m36988i("ResolutionFlagUtil", "remove resolution flag because aging time: " + str);
            }
        }
    }

    public static ResolutionFlagUtil getInstance() {
        if (f30209a != null) {
            return f30209a;
        }
        synchronized (f30211c) {
            try {
                if (f30209a == null) {
                    f30209a = new ResolutionFlagUtil();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return f30209a;
    }

    public long getResolutionFlag(String str) {
        if (str == null) {
            HMSLog.m36986e("ResolutionFlagUtil", "transactionId is null");
            return 0L;
        }
        Map<String, Long> map = f30210b;
        if (map.get(str) != null) {
            return map.get(str).longValue();
        }
        return 0L;
    }

    public void removeResolutionFlag(String str) {
        if (str == null) {
            HMSLog.m36986e("ResolutionFlagUtil", "transactionId is null");
        } else {
            f30210b.remove(str);
            HMSLog.m36988i("ResolutionFlagUtil", "remove resolution flag");
        }
    }

    public void saveResolutionFlag(String str, long j10) {
        if (!TextUtils.isEmpty(str) && j10 != 0) {
            m37083a(str, j10);
            return;
        }
        HMSLog.m36986e("ResolutionFlagUtil", "saveResolutionFlag error, transactionId: " + str + ", timestamp: " + j10);
    }

    /* renamed from: a */
    private void m37083a(String str, long j10) {
        Map<String, Long> map = f30210b;
        synchronized (map) {
            m37082a();
            map.put(str, Long.valueOf(j10));
            HMSLog.m36988i("ResolutionFlagUtil", "save resolution flag");
        }
    }
}
