package com.huawei.hms.network.file.core;

import com.huawei.hms.network.file.core.util.FLogger;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.huawei.hms.network.file.core.a */
/* loaded from: classes8.dex */
public class C6223a {

    /* renamed from: b */
    private static final C6223a f29375b = new C6223a();

    /* renamed from: a */
    private HashMap<Long, Integer> f29376a = new HashMap<>();

    /* renamed from: a */
    public static C6223a m36172a() {
        return f29375b;
    }

    /* renamed from: b */
    public synchronized int m36175b(long j10) {
        int iIntValue;
        try {
            iIntValue = this.f29376a.containsKey(Long.valueOf(j10)) ? this.f29376a.get(Long.valueOf(j10)).intValue() : -1;
            FLogger.m36354v("ConcurrentStatisticsMan", "getConcurrentNum : " + j10 + " num is " + iIntValue);
        } catch (Throwable th2) {
            throw th2;
        }
        return iIntValue;
    }

    /* renamed from: c */
    public synchronized void m36176c(long j10) {
        FLogger.m36354v("ConcurrentStatisticsMan", "updateRecord : " + j10);
        if (this.f29376a.size() > 1000) {
            FLogger.m36355w("ConcurrentStatisticsMan", "record size attach threshold", new Object[0]);
            return;
        }
        if (!this.f29376a.containsKey(Long.valueOf(j10))) {
            m36173b();
            this.f29376a.put(Long.valueOf(j10), Integer.valueOf(this.f29376a.size() + 1));
        } else {
            FLogger.m36354v("ConcurrentStatisticsMan", "requestId exist : " + j10);
        }
    }

    /* renamed from: b */
    private void m36173b() {
        for (Map.Entry<Long, Integer> entry : this.f29376a.entrySet()) {
            entry.setValue(Integer.valueOf(entry.getValue().intValue() + 1));
        }
    }

    /* renamed from: a */
    public synchronized void m36174a(long j10) {
        FLogger.m36354v("ConcurrentStatisticsMan", "eraseRecord : " + j10);
        this.f29376a.remove(Long.valueOf(j10));
    }
}
