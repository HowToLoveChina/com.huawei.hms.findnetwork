package com.huawei.hms.network.httpclient.okhttp;

import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.ReflectionUtils;
import com.huawei.hms.network.embedded.C5850a7;
import com.huawei.hms.network.embedded.C5920f8;
import com.huawei.hms.network.embedded.C5928g3;
import com.huawei.hms.network.embedded.C5984k7;
import com.huawei.hms.network.embedded.C6062q7;
import com.huawei.hms.network.embedded.C6167y8;
import com.huawei.hms.network.embedded.C6178z6;
import com.huawei.hms.network.embedded.C6180z8;
import com.huawei.hms.network.embedded.EnumC6075r7;
import com.huawei.hms.network.httpclient.util.PreConnectManager;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: classes8.dex */
public class OkHttpClientGlobal {
    public static final int INTERVAL = 500;

    /* renamed from: g */
    public static final String f29528g = "OkHttpClientGlobal";

    /* renamed from: h */
    public static OkHttpClientGlobal f29529h = null;

    /* renamed from: i */
    public static final int f29530i = 200;

    /* renamed from: j */
    public static final int f29531j = 32;

    /* renamed from: k */
    public static final int f29532k = 8;

    /* renamed from: l */
    public static final int f29533l = 5;

    /* renamed from: m */
    public static final TimeUnit f29534m = TimeUnit.MINUTES;

    /* renamed from: a */
    public int f29535a;

    /* renamed from: b */
    public long f29536b;

    /* renamed from: c */
    public TimeUnit f29537c;

    /* renamed from: d */
    public C6062q7 f29538d;

    /* renamed from: e */
    public Deque<C6167y8> f29539e;

    /* renamed from: f */
    public C6180z8 f29540f;

    public OkHttpClientGlobal() {
        this(8, 5L, f29534m);
    }

    /* renamed from: a */
    private synchronized void m36384a() {
        try {
            if (this.f29540f == null) {
                getConnectionPool();
            }
            C6180z8 c6180z8 = this.f29540f;
            if (c6180z8 != null) {
                Object fieldObj = ReflectionUtils.getFieldObj(c6180z8, "connections");
                if (fieldObj instanceof ArrayDeque) {
                    this.f29539e = ((ArrayDeque) fieldObj).clone();
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public static synchronized OkHttpClientGlobal getInstance() {
        try {
            if (f29529h == null) {
                f29529h = new OkHttpClientGlobal();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f29529h;
    }

    public static synchronized void init(int i10, long j10, TimeUnit timeUnit) {
        try {
            if (f29529h == null) {
                f29529h = new OkHttpClientGlobal(i10, j10, timeUnit);
            } else if (getInstance().getMaxIdleConnections() < i10 && getInstance().getConnectionTimeUnit().toMillis(getInstance().getConnectionKeepAliveDuration()) < timeUnit.toMillis(j10)) {
                getInstance().m36385a(i10, j10, timeUnit);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void evictAll() {
        try {
            if (this.f29538d != null) {
                Logger.m32141i(f29528g, "evictAll-start, count: " + this.f29538d.m35083g().m35909a() + ", idle: " + this.f29538d.m35083g().m35915c());
                this.f29538d.m35083g().m35912b();
                Logger.m32141i(f29528g, "evictAll-end, count: " + this.f29538d.m35083g().m35909a() + ", idle: " + this.f29538d.m35083g().m35915c());
            }
            PreConnectManager.getInstance().clearInfo();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized C6062q7 getClient() {
        try {
            if (this.f29538d == null) {
                C5984k7 c5984k7 = new C5984k7();
                c5984k7.mo33895b(200);
                c5984k7.m34608e(32);
                this.f29538d = new C6062q7.c().m35115a(new C6178z6(this.f29535a, this.f29536b, this.f29537c)).m35107a(c5984k7).m35130b(C5920f8.m34243a(EnumC6075r7.HTTP_2, EnumC6075r7.HTTP_1_1)).m35133c(500L, TimeUnit.MILLISECONDS).m35109a(C5928g3.getFactory()).m35119a(C5920f8.m34243a(C5850a7.f26358g, C5850a7.f26361j)).m35125a();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.f29538d;
    }

    public synchronized long getConnectionKeepAliveDuration() {
        return this.f29536b;
    }

    public synchronized void getConnectionPool() {
        Object fieldObj = ReflectionUtils.getFieldObj(getInstance().getClient().m35083g(), "delegate");
        if (fieldObj instanceof C6180z8) {
            this.f29540f = (C6180z8) fieldObj;
        }
    }

    public synchronized TimeUnit getConnectionTimeUnit() {
        return this.f29537c;
    }

    public synchronized List<String> getHostsInConnectionPool() {
        ArrayList arrayList;
        arrayList = new ArrayList(8);
        m36384a();
        if (this.f29539e != null) {
            Logger.m32141i(f29528g, "connection pool size is: " + this.f29539e.size());
            for (Object obj : this.f29539e.toArray()) {
                if (obj instanceof C6167y8) {
                    String strM34797h = ((C6167y8) obj).mo35837b().m35787a().m34990l().m34797h();
                    if (!arrayList.contains(strM34797h)) {
                        arrayList.add(strM34797h);
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized int getMaxIdleConnections() {
        return this.f29535a;
    }

    public C6178z6 newConnectionPool() {
        return new C6178z6(this.f29535a, this.f29536b, this.f29537c);
    }

    public OkHttpClientGlobal(int i10, long j10, TimeUnit timeUnit) {
        this.f29535a = 8;
        this.f29535a = i10 <= 0 ? 8 : i10;
        if (j10 <= 0) {
            this.f29536b = 5L;
            this.f29537c = f29534m;
        } else {
            this.f29536b = j10;
            this.f29537c = timeUnit;
        }
    }

    /* renamed from: a */
    private synchronized void m36385a(int i10, long j10, TimeUnit timeUnit) {
        try {
            if (this.f29540f == null) {
                getConnectionPool();
            }
            C6180z8 c6180z8 = this.f29540f;
            if (c6180z8 != null) {
                try {
                    ReflectionUtils.getField(c6180z8, "maxIdleConnections").set(this.f29540f, Integer.valueOf(i10));
                    this.f29535a = i10;
                } catch (IllegalAccessException unused) {
                    Logger.m32145w(f29528g, "maxIdleConnections set value failed !!!");
                }
                try {
                    ReflectionUtils.getField(this.f29540f, "keepAliveDurationNs").set(this.f29540f, Long.valueOf(timeUnit.toNanos(j10)));
                    this.f29536b = j10;
                    this.f29537c = timeUnit;
                } catch (IllegalAccessException unused2) {
                    Logger.m32145w(f29528g, "connectionTimeUnit and connectionKeepAliveDuration set value failed !!!");
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
