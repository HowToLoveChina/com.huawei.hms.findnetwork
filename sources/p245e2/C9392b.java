package p245e2;

import com.bumptech.glide.load.model.C1591h;
import com.bumptech.glide.load.model.InterfaceC1589f;
import java.io.InputStream;
import java.net.URL;
import p214d2.C8988b;
import p214d2.InterfaceC8994h;
import p759x1.C13684i;

/* renamed from: e2.b */
/* loaded from: classes.dex */
public class C9392b implements InterfaceC1589f<URL, InputStream> {

    /* renamed from: a */
    public final InterfaceC1589f<C8988b, InputStream> f46917a;

    /* renamed from: e2.b$a */
    public static class a implements InterfaceC8994h<URL, InputStream> {
        @Override // p214d2.InterfaceC8994h
        /* renamed from: b */
        public InterfaceC1589f<URL, InputStream> mo9074b(C1591h c1591h) {
            return new C9392b(c1591h.m9105d(C8988b.class, InputStream.class));
        }
    }

    public C9392b(InterfaceC1589f<C8988b, InputStream> interfaceC1589f) {
        this.f46917a = interfaceC1589f;
    }

    @Override // com.bumptech.glide.load.model.InterfaceC1589f
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public InterfaceC1589f.a<InputStream> mo9071b(URL url, int i10, int i11, C13684i c13684i) {
        return this.f46917a.mo9071b(new C8988b(url), i10, i11, c13684i);
    }

    @Override // com.bumptech.glide.load.model.InterfaceC1589f
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean mo9070a(URL url) {
        return true;
    }
}
