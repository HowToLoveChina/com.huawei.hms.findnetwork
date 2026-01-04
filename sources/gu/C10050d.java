package gu;

import android.annotation.SuppressLint;

/* renamed from: gu.d */
/* loaded from: classes5.dex */
public class C10050d {

    /* renamed from: b */
    public static final String f49017b = "RootKeyUtil";

    /* renamed from: a */
    public byte[] f49018a = null;

    /* renamed from: e */
    public static C10050d m62478e(String str, String str2, String str3, String str4) {
        C10050d c10050d = new C10050d();
        c10050d.m62479a(str, str2, str3, str4);
        return c10050d;
    }

    /* renamed from: a */
    public final void m62479a(String str, String str2, String str3, String str4) {
        m62480b(str, str2, str3, C10049c.m62477b(str4));
    }

    @SuppressLint({"NewApi"})
    /* renamed from: b */
    public final void m62480b(String str, String str2, String str3, byte[] bArr) {
        C10053g.m62492d(f49017b, "initRootKey: sha256");
        this.f49018a = C10047a.m62468j(str, str2, str3, bArr, true);
    }

    /* renamed from: c */
    public byte[] m62481c() {
        return (byte[]) this.f49018a.clone();
    }

    /* renamed from: d */
    public String m62482d() {
        return C10049c.m62476a(this.f49018a);
    }
}
