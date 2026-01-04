package com.huawei.hms.drive;

import com.huawei.hms.network.embedded.C6090s9;
import p022ay.C1057g;

/* renamed from: com.huawei.hms.drive.cx */
/* loaded from: classes8.dex */
public final class C5247cx {

    /* renamed from: a */
    public static final C1057g f24268a = C1057g.m6364k(":");

    /* renamed from: b */
    public static final C1057g f24269b = C1057g.m6364k(C6090s9.f28233e);

    /* renamed from: c */
    public static final C1057g f24270c = C1057g.m6364k(C6090s9.f28234f);

    /* renamed from: d */
    public static final C1057g f24271d = C1057g.m6364k(C6090s9.f28235g);

    /* renamed from: e */
    public static final C1057g f24272e = C1057g.m6364k(C6090s9.f28236h);

    /* renamed from: f */
    public static final C1057g f24273f = C1057g.m6364k(C6090s9.f28237i);

    /* renamed from: g */
    public final C1057g f24274g;

    /* renamed from: h */
    public final C1057g f24275h;

    /* renamed from: i */
    final int f24276i;

    public C5247cx(String str, String str2) {
        this(C1057g.m6364k(str), C1057g.m6364k(str2));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C5247cx)) {
            return false;
        }
        C5247cx c5247cx = (C5247cx) obj;
        return this.f24274g.equals(c5247cx.f24274g) && this.f24275h.equals(c5247cx.f24275h);
    }

    public int hashCode() {
        return ((527 + this.f24274g.hashCode()) * 31) + this.f24275h.hashCode();
    }

    public String toString() {
        return C5210bo.m31181a("%s: %s", this.f24274g.m6374I(), this.f24275h.m6374I());
    }

    public C5247cx(C1057g c1057g, String str) {
        this(c1057g, C1057g.m6364k(str));
    }

    public C5247cx(C1057g c1057g, C1057g c1057g2) {
        this.f24274g = c1057g;
        this.f24275h = c1057g2;
        this.f24276i = c1057g.m6370E() + 32 + c1057g2.m6370E();
    }
}
