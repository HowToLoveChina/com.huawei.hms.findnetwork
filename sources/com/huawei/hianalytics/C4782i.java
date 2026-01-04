package com.huawei.hianalytics;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.huawei.hianalytics.i */
/* loaded from: classes5.dex */
public final class C4782i {

    /* renamed from: a */
    public static C4782i f21829a;

    /* renamed from: a */
    public static Map<String, C4750e1> f21830a = new ConcurrentHashMap();

    /* renamed from: a */
    public C4790l f21831a = new C4790l();

    /* renamed from: a */
    public C4750e1 m28892a(String str) {
        return f21830a.get(str);
    }

    /* renamed from: a */
    public C4790l m28893a() {
        if (this.f21831a == null) {
            this.f21831a = new C4790l();
        }
        return this.f21831a;
    }

    /* renamed from: a */
    public static C4782i m28891a() {
        if (f21829a == null) {
            synchronized (C4782i.class) {
                if (f21829a == null) {
                    f21829a = new C4782i();
                }
            }
        }
        return f21829a;
    }
}
