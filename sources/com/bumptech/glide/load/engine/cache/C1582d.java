package com.bumptech.glide.load.engine.cache;

import android.util.Log;
import com.bumptech.glide.load.engine.cache.InterfaceC1579a;
import java.io.File;
import java.io.IOException;
import p026b2.C1099a;
import p026b2.C1102d;
import p696v1.C13325a;
import p759x1.InterfaceC13681f;

/* renamed from: com.bumptech.glide.load.engine.cache.d */
/* loaded from: classes.dex */
public class C1582d implements InterfaceC1579a {

    /* renamed from: b */
    public final File f6990b;

    /* renamed from: c */
    public final long f6991c;

    /* renamed from: e */
    public C13325a f6993e;

    /* renamed from: d */
    public final C1099a f6992d = new C1099a();

    /* renamed from: a */
    public final C1102d f6989a = new C1102d();

    @Deprecated
    public C1582d(File file, long j10) {
        this.f6990b = file;
        this.f6991c = j10;
    }

    /* renamed from: c */
    public static InterfaceC1579a m9068c(File file, long j10) {
        return new C1582d(file, j10);
    }

    @Override // com.bumptech.glide.load.engine.cache.InterfaceC1579a
    /* renamed from: a */
    public File mo9065a(InterfaceC13681f interfaceC13681f) {
        String strM6550b = this.f6989a.m6550b(interfaceC13681f);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            Log.v("DiskLruCacheWrapper", "Get: Obtained: " + strM6550b + " for for Key: " + interfaceC13681f);
        }
        try {
            C13325a.e eVarM79890A = m9069d().m79890A(strM6550b);
            if (eVarM79890A != null) {
                return eVarM79890A.m79924a(0);
            }
            return null;
        } catch (IOException e10) {
            if (!Log.isLoggable("DiskLruCacheWrapper", 5)) {
                return null;
            }
            Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", e10);
            return null;
        }
    }

    @Override // com.bumptech.glide.load.engine.cache.InterfaceC1579a
    /* renamed from: b */
    public void mo9066b(InterfaceC13681f interfaceC13681f, InterfaceC1579a.b bVar) {
        C13325a c13325aM9069d;
        String strM6550b = this.f6989a.m6550b(interfaceC13681f);
        this.f6992d.m6536a(strM6550b);
        try {
            if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                Log.v("DiskLruCacheWrapper", "Put: Obtained: " + strM6550b + " for for Key: " + interfaceC13681f);
            }
            try {
                c13325aM9069d = m9069d();
            } catch (IOException e10) {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", e10);
                }
            }
            if (c13325aM9069d.m79890A(strM6550b) != null) {
                return;
            }
            C13325a.c cVarM79901x = c13325aM9069d.m79901x(strM6550b);
            if (cVarM79901x == null) {
                throw new IllegalStateException("Had two simultaneous puts for: " + strM6550b);
            }
            try {
                if (bVar.mo9067a(cVarM79901x.m79909f(0))) {
                    cVarM79901x.m79908e();
                }
                cVarM79901x.m79907b();
            } catch (Throwable th2) {
                cVarM79901x.m79907b();
                throw th2;
            }
        } finally {
            this.f6992d.m6537b(strM6550b);
        }
    }

    /* renamed from: d */
    public final synchronized C13325a m9069d() throws IOException {
        try {
            if (this.f6993e == null) {
                this.f6993e = C13325a.m79877C(this.f6990b, 1, 1, this.f6991c);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.f6993e;
    }
}
