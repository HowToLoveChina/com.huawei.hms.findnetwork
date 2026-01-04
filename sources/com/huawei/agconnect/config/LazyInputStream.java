package com.huawei.agconnect.config;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import p469m4.C11401b;

@Deprecated
/* loaded from: classes.dex */
public abstract class LazyInputStream {

    /* renamed from: a */
    public final Context f9508a;

    /* renamed from: b */
    public InputStream f9509b;

    public LazyInputStream(Context context) {
        this.f9508a = context;
    }

    /* renamed from: a */
    public final void m12572a() throws IOException {
        C11401b.m68318a(this.f9509b);
    }

    /* renamed from: b */
    public abstract InputStream m12573b(Context context);

    /* renamed from: c */
    public InputStream m12574c() {
        if (this.f9509b == null) {
            this.f9509b = m12573b(this.f9508a);
        }
        return this.f9509b;
    }
}
