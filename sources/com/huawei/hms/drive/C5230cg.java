package com.huawei.hms.drive;

import java.io.IOException;

/* renamed from: com.huawei.hms.drive.cg */
/* loaded from: classes8.dex */
public final class C5230cg extends RuntimeException {

    /* renamed from: a */
    private IOException f24168a;

    /* renamed from: b */
    private IOException f24169b;

    public C5230cg(IOException iOException) {
        super(iOException);
        this.f24168a = iOException;
        this.f24169b = iOException;
    }

    /* renamed from: a */
    public IOException m31351a() {
        return this.f24168a;
    }

    /* renamed from: b */
    public IOException m31353b() {
        return this.f24169b;
    }

    /* renamed from: a */
    public void m31352a(IOException iOException) {
        C5210bo.m31192a(this.f24168a, iOException);
        this.f24169b = iOException;
    }
}
