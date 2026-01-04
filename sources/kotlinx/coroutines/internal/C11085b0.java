package kotlinx.coroutines.internal;

import mw.InterfaceC11539f;
import p040bx.InterfaceC1316h1;
import p692uw.C13267j;

/* renamed from: kotlinx.coroutines.internal.b0 */
/* loaded from: classes9.dex */
public final class C11085b0 {

    /* renamed from: a */
    public final InterfaceC11539f f52294a;

    /* renamed from: b */
    public final Object[] f52295b;

    /* renamed from: c */
    public final InterfaceC1316h1<Object>[] f52296c;

    /* renamed from: d */
    public int f52297d;

    public C11085b0(InterfaceC11539f interfaceC11539f, int i10) {
        this.f52294a = interfaceC11539f;
        this.f52295b = new Object[i10];
        this.f52296c = new InterfaceC1316h1[i10];
    }

    /* renamed from: a */
    public final void m66741a(InterfaceC1316h1<?> interfaceC1316h1, Object obj) {
        Object[] objArr = this.f52295b;
        int i10 = this.f52297d;
        objArr[i10] = obj;
        InterfaceC1316h1<Object>[] interfaceC1316h1Arr = this.f52296c;
        this.f52297d = i10 + 1;
        interfaceC1316h1Arr[i10] = interfaceC1316h1;
    }

    /* renamed from: b */
    public final void m66742b(InterfaceC11539f interfaceC11539f) {
        int length = this.f52296c.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i10 = length - 1;
            InterfaceC1316h1<Object> interfaceC1316h1 = this.f52296c[length];
            C13267j.m79674b(interfaceC1316h1);
            interfaceC1316h1.m7773j(interfaceC11539f, this.f52295b[length]);
            if (i10 < 0) {
                return;
            } else {
                length = i10;
            }
        }
    }
}
