package p245e2;

import com.bumptech.glide.load.data.C1569j;
import com.bumptech.glide.load.model.C1591h;
import com.bumptech.glide.load.model.InterfaceC1589f;
import java.io.InputStream;
import p214d2.C8988b;
import p214d2.C8993g;
import p214d2.InterfaceC8994h;
import p759x1.C13683h;
import p759x1.C13684i;

/* renamed from: e2.a */
/* loaded from: classes.dex */
public class C9391a implements InterfaceC1589f<C8988b, InputStream> {

    /* renamed from: b */
    public static final C13683h<Integer> f46914b = C13683h.m82279f("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", 2500);

    /* renamed from: a */
    public final C8993g<C8988b, C8988b> f46915a;

    /* renamed from: e2.a$a */
    public static class a implements InterfaceC8994h<C8988b, InputStream> {

        /* renamed from: a */
        public final C8993g<C8988b, C8988b> f46916a = new C8993g<>(500);

        @Override // p214d2.InterfaceC8994h
        /* renamed from: b */
        public InterfaceC1589f<C8988b, InputStream> mo9074b(C1591h c1591h) {
            return new C9391a(this.f46916a);
        }
    }

    public C9391a(C8993g<C8988b, C8988b> c8993g) {
        this.f46915a = c8993g;
    }

    @Override // com.bumptech.glide.load.model.InterfaceC1589f
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public InterfaceC1589f.a<InputStream> mo9071b(C8988b c8988b, int i10, int i11, C13684i c13684i) {
        C8993g<C8988b, C8988b> c8993g = this.f46915a;
        if (c8993g != null) {
            C8988b c8988bM56837a = c8993g.m56837a(c8988b, 0, 0);
            if (c8988bM56837a == null) {
                this.f46915a.m56838b(c8988b, 0, 0, c8988b);
            } else {
                c8988b = c8988bM56837a;
            }
        }
        return new InterfaceC1589f.a<>(c8988b, new C1569j(c8988b, ((Integer) c13684i.m82284c(f46914b)).intValue()));
    }

    @Override // com.bumptech.glide.load.model.InterfaceC1589f
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean mo9070a(C8988b c8988b) {
        return true;
    }
}
