package com.huawei.hianalytics.framework;

import com.huawei.hianalytics.core.storage.IStorageHandler;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.huawei.hianalytics.framework.e */
/* loaded from: classes5.dex */
public class C4758e {

    /* renamed from: a */
    public IStorageHandler f21761a;

    /* renamed from: b */
    public final Map<String, Long> f21762b = new ConcurrentHashMap();

    /* renamed from: c */
    public final Map<String, Long> f21763c = new ConcurrentHashMap();

    /* renamed from: d */
    public final Map<String, Integer> f21764d = new ConcurrentHashMap();

    /* renamed from: e */
    public final Map<String, Integer> f21765e = new ConcurrentHashMap();

    /* renamed from: a */
    public void m28854a(String str) {
        Integer num = this.f21764d.get(str);
        int iIntValue = (num != null ? num.intValue() : 0) + 1;
        this.f21764d.put(str, Integer.valueOf(iIntValue));
        this.f21763c.put(str, Long.valueOf((iIntValue <= 0 || iIntValue > 4) ? 1800000L : iIntValue * 300000));
    }

    /* renamed from: b */
    public void m28855b(String str) {
        Integer num = this.f21764d.get(str);
        if (num == null || num.intValue() == 0) {
            return;
        }
        this.f21763c.put(str, 30000L);
        this.f21764d.put(str, 0);
    }
}
