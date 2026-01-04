package com.huawei.hms.videokit.player;

import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.huawei.hms.videokit.player.z */
/* loaded from: classes8.dex */
public final class C6611z extends C6544b0 {

    /* renamed from: b */
    C6609y f30717b;

    /* renamed from: c */
    private AtomicBoolean f30718c;

    /* renamed from: d */
    private String f30719d;

    /* renamed from: e */
    private int f30720e;

    /* renamed from: f */
    private int f30721f;

    public C6611z(Context context) {
        super(context);
        this.f30717b = C6609y.m37724b();
        this.f30718c = new AtomicBoolean(false);
        this.f30719d = "";
        this.f30720e = 0;
        this.f30721f = 0;
    }

    /* renamed from: g */
    private void m37729g() {
        if (this.f30717b == null) {
            this.f30717b = C6609y.m37724b();
        }
        if (this.f30718c.get()) {
            return;
        }
        C6592p c6592p = new C6592p();
        m37218a(c6592p);
        c6592p.m37591a("errorMessage", this.f30719d);
        c6592p.m37590a("errorScene", this.f30721f);
        c6592p.m37590a("errorType", this.f30720e);
        this.f30717b.m37725a(1, "VideoKitOM106", c6592p);
        this.f30718c.set(true);
    }

    /* renamed from: a */
    public void m37730a(int i10) {
        this.f30721f = i10;
    }

    /* renamed from: b */
    public void m37732b(int i10) {
        this.f30720e = i10;
    }

    /* renamed from: h */
    public void m37733h() {
        if (C6609y.m37724b().m37727c()) {
            m37729g();
        } else {
            C6550c1.m37256a("AbnormalDataReporter", "VideoPlayer reporting channel is off ");
        }
    }

    /* renamed from: i */
    public void m37734i() {
        this.f30720e = 0;
        this.f30721f = 0;
        this.f30719d = "";
    }

    /* renamed from: a */
    public void m37731a(String str) {
        if (str == null) {
            return;
        }
        this.f30719d = str;
    }
}
