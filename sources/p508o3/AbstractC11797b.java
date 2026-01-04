package p508o3;

import java.nio.charset.Charset;

/* renamed from: o3.b */
/* loaded from: classes.dex */
public abstract class AbstractC11797b implements InterfaceC11805j {
    @Override // p508o3.InterfaceC11805j
    /* renamed from: a */
    public <T> InterfaceC11805j mo70310a(T t10, InterfaceC11801f<? super T> interfaceC11801f) {
        interfaceC11801f.mo70341i(t10, this);
        return this;
    }

    /* renamed from: d */
    public InterfaceC11805j m70312d(byte[] bArr) {
        return mo70313e(bArr, 0, bArr.length);
    }

    /* renamed from: e */
    public abstract InterfaceC11805j mo70313e(byte[] bArr, int i10, int i11);

    @Override // p508o3.InterfaceC11812q
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public InterfaceC11805j mo70311b(CharSequence charSequence, Charset charset) {
        return m70312d(charSequence.toString().getBytes(charset));
    }
}
