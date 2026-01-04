package com.huawei.openalliance.p169ad;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.IBinder;

/* renamed from: com.huawei.openalliance.ad.gk */
/* loaded from: classes8.dex */
public class C7154gk {

    /* renamed from: a */
    private final Bundle f32931a;

    public C7154gk() {
        this(new Bundle());
    }

    /* renamed from: a */
    public int m43575a(String str, int i10) {
        try {
            return this.f32931a.getInt(str, i10);
        } catch (Throwable unused) {
            AbstractC7185ho.m43826d("SafeBundle", "getInt exception ex.");
            return i10;
        }
    }

    /* renamed from: b */
    public int m43582b(String str) {
        return m43575a(str, 0);
    }

    /* renamed from: c */
    public long m43587c(String str) {
        return m43576a(str, 0L);
    }

    /* renamed from: d */
    public String m43588d(String str) {
        try {
            return this.f32931a.getString(str);
        } catch (Throwable unused) {
            AbstractC7185ho.m43826d("SafeBundle", "getString exception ex.");
            return "";
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: e */
    public IBinder m43589e(String str) {
        try {
            return this.f32931a.getBinder(str);
        } catch (Throwable unused) {
            AbstractC7185ho.m43826d("SafeBundle", "getBinder exception ex.");
            return null;
        }
    }

    public String toString() {
        try {
            return this.f32931a.toString();
        } catch (Throwable unused) {
            AbstractC7185ho.m43826d("SafeBundle", "toString exception.");
            return null;
        }
    }

    public C7154gk(Bundle bundle) {
        this.f32931a = bundle == null ? new Bundle() : bundle;
    }

    /* renamed from: a */
    public long m43576a(String str, long j10) {
        try {
            return this.f32931a.getLong(str, j10);
        } catch (Throwable unused) {
            AbstractC7185ho.m43826d("SafeBundle", "getLong exception ex.");
            return j10;
        }
    }

    /* renamed from: b */
    public C7154gk m43583b(String str, int i10) {
        try {
            this.f32931a.putInt(str, i10);
        } catch (Throwable unused) {
            AbstractC7185ho.m43826d("SafeBundle", "putInt exception ex.");
        }
        return this;
    }

    /* renamed from: a */
    public Bundle m43577a() {
        return this.f32931a;
    }

    /* renamed from: b */
    public C7154gk m43584b(String str, long j10) {
        try {
            this.f32931a.putLong(str, j10);
        } catch (Throwable unused) {
            AbstractC7185ho.m43826d("SafeBundle", "putLong exception ex.");
        }
        return this;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public C7154gk m43578a(String str, IBinder iBinder) {
        try {
            this.f32931a.putBinder(str, iBinder);
        } catch (Throwable unused) {
            AbstractC7185ho.m43826d("SafeBundle", "putBundle exception ex.");
        }
        return this;
    }

    /* renamed from: b */
    public C7154gk m43585b(String str, String str2) {
        try {
            this.f32931a.putString(str, str2);
        } catch (Throwable unused) {
            AbstractC7185ho.m43826d("SafeBundle", "putString exception ex.");
        }
        return this;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public String m43579a(String str, String str2) {
        try {
            return this.f32931a.getString(str, str2);
        } catch (Throwable unused) {
            AbstractC7185ho.m43826d("SafeBundle", "getString exception ex.");
            return str2;
        }
    }

    /* renamed from: b */
    public C7154gk m43586b(String str, boolean z10) {
        try {
            this.f32931a.putBoolean(str, z10);
        } catch (Throwable unused) {
            AbstractC7185ho.m43826d("SafeBundle", "putBoolean exception ex.");
        }
        return this;
    }

    /* renamed from: a */
    public boolean m43580a(String str) {
        return m43581a(str, false);
    }

    /* renamed from: a */
    public boolean m43581a(String str, boolean z10) {
        try {
            return this.f32931a.getBoolean(str, z10);
        } catch (Throwable unused) {
            AbstractC7185ho.m43826d("SafeBundle", "getBoolean exception  ex.");
            return z10;
        }
    }
}
