package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.beans.metadata.App;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import com.huawei.openalliance.p169ad.utils.C7832k;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* renamed from: com.huawei.openalliance.ad.mx */
/* loaded from: classes8.dex */
public class C7489mx {

    /* renamed from: a */
    private static final C7489mx f34718a = new C7489mx();

    /* renamed from: b */
    private static final ReentrantReadWriteLock f34719b;

    /* renamed from: c */
    private static final ReentrantReadWriteLock.ReadLock f34720c;

    /* renamed from: d */
    private static final ReentrantReadWriteLock.WriteLock f34721d;

    /* renamed from: e */
    private volatile C7488mw f34722e;

    /* renamed from: f */
    private volatile long f34723f = -1;

    static {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        f34719b = reentrantReadWriteLock;
        f34720c = reentrantReadWriteLock.readLock();
        f34721d = reentrantReadWriteLock.writeLock();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m45890c(final Context context) {
        try {
            AbstractC7185ho.m43820b("UninstalledAppCacheManager", "asyncUpdateCache");
            final long jCurrentTimeMillis = System.currentTimeMillis();
            if (this.f34722e == null) {
                AbstractC7185ho.m43820b("UninstalledAppCacheManager", "cache is null");
                return;
            }
            this.f34723f = C7124fh.m43316b(context).mo43073g() * 60 * 1000;
            if (jCurrentTimeMillis - this.f34722e.m45881b() < this.f34723f) {
                AbstractC7185ho.m43820b("UninstalledAppCacheManager", "still in query interval");
            } else {
                AbstractC7834m.m48479a(new Runnable() { // from class: com.huawei.openalliance.ad.mx.2
                    @Override // java.lang.Runnable
                    public void run() {
                        C7489mx.this.m45885a(context, jCurrentTimeMillis);
                    }
                });
            }
        } catch (Throwable unused) {
            AbstractC7185ho.m43823c("UninstalledAppCacheManager", "sync update occurs exception");
        }
    }

    /* renamed from: b */
    private void m45889b(final Context context) {
        AbstractC7185ho.m43820b("UninstalledAppCacheManager", "getCacheFromSp");
        if (context == null) {
            AbstractC7185ho.m43823c("UninstalledAppCacheManager", "context is null");
        }
        AbstractC7834m.m48479a(new Runnable() { // from class: com.huawei.openalliance.ad.mx.1
            @Override // java.lang.Runnable
            public void run() {
                C7489mx.f34721d.lock();
                try {
                    try {
                        String strMo43438ci = C7124fh.m43316b(context).mo43438ci();
                        if (strMo43438ci != null) {
                            AbstractC7185ho.m43817a("UninstalledAppCacheManager", "convert json to cache");
                            C7489mx.this.f34722e = (C7488mw) AbstractC7758be.m47722a(strMo43438ci, C7488mw.class, new Class[0]);
                        }
                        if (C7489mx.this.f34722e == null) {
                            C7489mx.this.f34722e = new C7488mw();
                        }
                        C7489mx.this.m45890c(context);
                    } catch (Throwable unused) {
                        AbstractC7185ho.m43823c("UninstalledAppCacheManager", "get cache from sp failed");
                    }
                } finally {
                    C7489mx.f34721d.unlock();
                }
            }
        });
    }

    /* renamed from: a */
    public static C7489mx m45884a() {
        return f34718a;
    }

    /* renamed from: a */
    public List<App> m45891a(Context context) {
        AbstractC7185ho.m43820b("UninstalledAppCacheManager", "getUninstalledAppFromCache");
        if (context == null || !C7832k.m48465a().m48469a(context)) {
            return null;
        }
        ReentrantReadWriteLock.ReadLock readLock = f34720c;
        if (readLock.tryLock()) {
            AbstractC7185ho.m43817a("UninstalledAppCacheManager", "get lock");
            try {
                try {
                    if (this.f34722e != null) {
                        m45890c(context);
                        List<App> listM45878a = this.f34722e.m45878a();
                        readLock.unlock();
                        return listM45878a;
                    }
                    m45889b(context);
                    readLock.unlock();
                } catch (Throwable unused) {
                    AbstractC7185ho.m43823c("UninstalledAppCacheManager", "get cache failed");
                }
            } finally {
                f34720c.unlock();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m45885a(Context context, long j10) {
        AbstractC7185ho.m43820b("UninstalledAppCacheManager", "try to update cache");
        List<App> listM48470b = C7832k.m48465a().m48470b(context);
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(listM48470b == null ? 0 : listM48470b.size());
        AbstractC7185ho.m43818a("UninstalledAppCacheManager", "get result size:%s", objArr);
        ReentrantReadWriteLock.WriteLock writeLock = f34721d;
        writeLock.lock();
        try {
            try {
                this.f34722e.m45879a(j10);
                this.f34722e.m45880a(listM48470b);
                C7124fh.m43316b(context).mo43491y(AbstractC7758be.m47727a(this.f34722e));
                writeLock.unlock();
            } catch (Throwable unused) {
                AbstractC7185ho.m43823c("UninstalledAppCacheManager", "update cache failed");
            }
        } finally {
            f34721d.unlock();
        }
    }
}
