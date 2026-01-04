package gy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* renamed from: gy.g */
/* loaded from: classes9.dex */
public class C10068g {

    /* renamed from: a */
    public final boolean f49131a;

    /* renamed from: b */
    public final List<C10070i> f49132b;

    public C10068g(byte[] bArr) throws IOException {
        this.f49132b = new ArrayList(C10071j.m62688w(bArr, 0, 21));
        this.f49131a = C10071j.m62678m(bArr, 504);
    }

    /* renamed from: a */
    public List<C10070i> m62662a() {
        return this.f49132b;
    }

    /* renamed from: b */
    public boolean m62663b() {
        return this.f49131a;
    }
}
