package com.huawei.hms.network.embedded;

import java.io.IOException;

/* renamed from: com.huawei.hms.network.embedded.b9 */
/* loaded from: classes8.dex */
public final class C5866b9 extends RuntimeException {

    /* renamed from: a */
    public IOException f26518a;

    /* renamed from: b */
    public IOException f26519b;

    public C5866b9(IOException iOException) {
        super(iOException);
        this.f26518a = iOException;
        this.f26519b = iOException;
    }

    /* renamed from: a */
    public IOException m33901a() {
        return this.f26518a;
    }

    /* renamed from: b */
    public IOException m33903b() {
        return this.f26519b;
    }

    /* renamed from: a */
    public void m33902a(IOException iOException) {
        C5920f8.m34249a(this.f26518a, iOException);
        this.f26519b = iOException;
    }
}
