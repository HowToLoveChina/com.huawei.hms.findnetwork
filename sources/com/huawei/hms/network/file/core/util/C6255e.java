package com.huawei.hms.network.file.core.util;

import android.os.Process;
import java.security.SecureRandom;

/* renamed from: com.huawei.hms.network.file.core.util.e */
/* loaded from: classes8.dex */
public class C6255e {

    /* renamed from: b */
    private static volatile C6255e f29514b;

    /* renamed from: c */
    private static final Object f29515c = new Object();

    /* renamed from: a */
    C6257g f29516a = new C6257g(Process.myPid(), new SecureRandom().nextInt(16));

    private C6255e() {
    }

    /* renamed from: b */
    public static C6255e m36368b() {
        if (f29514b != null) {
            return f29514b;
        }
        synchronized (f29515c) {
            try {
                if (f29514b == null) {
                    f29514b = new C6255e();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return f29514b;
    }

    /* renamed from: a */
    public long m36369a() {
        return this.f29516a.m36383a();
    }
}
