package p761x3;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.logging.Logger;
import p005a4.C0027g;
import p631s3.C12693p;
import p631s3.C12695r;
import p631s3.InterfaceC12692o;
import p631s3.InterfaceC12694q;
import p831z3.EnumC14106i0;

/* renamed from: x3.d */
/* loaded from: classes.dex */
public class C13693d implements InterfaceC12694q<InterfaceC12692o, InterfaceC12692o> {

    /* renamed from: a */
    public static final Logger f61628a = Logger.getLogger(C13693d.class.getName());

    /* renamed from: x3.d$b */
    public static class b implements InterfaceC12692o {

        /* renamed from: a */
        public final C12693p<InterfaceC12692o> f61629a;

        /* renamed from: b */
        public final byte[] f61630b;

        @Override // p631s3.InterfaceC12692o
        /* renamed from: a */
        public void mo157a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            if (bArr.length <= 5) {
                throw new GeneralSecurityException("tag too short");
            }
            byte[] bArrCopyOf = Arrays.copyOf(bArr, 5);
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 5, bArr.length);
            for (C12693p.b<InterfaceC12692o> bVar : this.f61629a.m76360c(bArrCopyOf)) {
                try {
                    if (bVar.m76365b().equals(EnumC14106i0.LEGACY)) {
                        bVar.m76366c().mo157a(bArrCopyOfRange, C0027g.m111a(bArr2, this.f61630b));
                        return;
                    } else {
                        bVar.m76366c().mo157a(bArrCopyOfRange, bArr2);
                        return;
                    }
                } catch (GeneralSecurityException e10) {
                    C13693d.f61628a.info("tag prefix matches a key, but cannot verify: " + e10);
                }
            }
            Iterator<C12693p.b<InterfaceC12692o>> it = this.f61629a.m76362e().iterator();
            while (it.hasNext()) {
                try {
                    it.next().m76366c().mo157a(bArr, bArr2);
                    return;
                } catch (GeneralSecurityException unused) {
                }
            }
            throw new GeneralSecurityException("invalid MAC");
        }

        @Override // p631s3.InterfaceC12692o
        /* renamed from: b */
        public byte[] mo158b(byte[] bArr) throws GeneralSecurityException {
            return this.f61629a.m76359b().m76365b().equals(EnumC14106i0.LEGACY) ? C0027g.m111a(this.f61629a.m76359b().m76364a(), this.f61629a.m76359b().m76366c().mo158b(C0027g.m111a(bArr, this.f61630b))) : C0027g.m111a(this.f61629a.m76359b().m76364a(), this.f61629a.m76359b().m76366c().mo158b(bArr));
        }

        public b(C12693p<InterfaceC12692o> c12693p) {
            this.f61630b = new byte[]{0};
            this.f61629a = c12693p;
        }
    }

    /* renamed from: e */
    public static void m82321e() throws GeneralSecurityException {
        C12695r.m76389r(new C13693d());
    }

    @Override // p631s3.InterfaceC12694q
    /* renamed from: a */
    public Class<InterfaceC12692o> mo76369a() {
        return InterfaceC12692o.class;
    }

    @Override // p631s3.InterfaceC12694q
    /* renamed from: b */
    public Class<InterfaceC12692o> mo76370b() {
        return InterfaceC12692o.class;
    }

    @Override // p631s3.InterfaceC12694q
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public InterfaceC12692o mo76371c(C12693p<InterfaceC12692o> c12693p) throws GeneralSecurityException {
        return new b(c12693p);
    }
}
