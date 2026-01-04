package p306g2;

import android.graphics.Bitmap;
import java.io.IOException;
import java.io.InputStream;
import p003a2.InterfaceC0007b;
import p003a2.InterfaceC0009d;
import p306g2.C9862n;
import p630s2.C12669d;
import p630s2.C12674i;
import p759x1.C13684i;
import p759x1.InterfaceC13686k;
import p829z1.InterfaceC14083v;

/* renamed from: g2.z */
/* loaded from: classes.dex */
public class C9874z implements InterfaceC13686k<InputStream, Bitmap> {

    /* renamed from: a */
    public final C9862n f48492a;

    /* renamed from: b */
    public final InterfaceC0007b f48493b;

    /* renamed from: g2.z$a */
    public static class a implements C9862n.b {

        /* renamed from: a */
        public final C9872x f48494a;

        /* renamed from: b */
        public final C12669d f48495b;

        public a(C9872x c9872x, C12669d c12669d) {
            this.f48494a = c9872x;
            this.f48495b = c12669d;
        }

        @Override // p306g2.C9862n.b
        /* renamed from: a */
        public void mo61285a(InterfaceC0009d interfaceC0009d, Bitmap bitmap) throws IOException {
            IOException iOExceptionM76256s = this.f48495b.m76256s();
            if (iOExceptionM76256s != null) {
                if (bitmap == null) {
                    throw iOExceptionM76256s;
                }
                interfaceC0009d.mo15b(bitmap);
                throw iOExceptionM76256s;
            }
        }

        @Override // p306g2.C9862n.b
        /* renamed from: b */
        public void mo61286b() {
            this.f48494a.m61314s();
        }
    }

    public C9874z(C9862n c9862n, InterfaceC0007b interfaceC0007b) {
        this.f48492a = c9862n;
        this.f48493b = interfaceC0007b;
    }

    @Override // p759x1.InterfaceC13686k
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public InterfaceC14083v<Bitmap> mo9147b(InputStream inputStream, int i10, int i11, C13684i c13684i) throws IOException {
        boolean z10;
        C9872x c9872x;
        if (inputStream instanceof C9872x) {
            c9872x = (C9872x) inputStream;
            z10 = false;
        } else {
            z10 = true;
            c9872x = new C9872x(inputStream, this.f48493b);
        }
        C12669d c12669dM76255t = C12669d.m76255t(c9872x);
        try {
            return this.f48492a.m61278f(new C12674i(c12669dM76255t), i10, i11, c13684i, new a(c9872x, c12669dM76255t));
        } finally {
            c12669dM76255t.m76257u();
            if (z10) {
                c9872x.m61315t();
            }
        }
    }

    @Override // p759x1.InterfaceC13686k
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean mo9146a(InputStream inputStream, C13684i c13684i) {
        return this.f48492a.m61282p(inputStream);
    }
}
