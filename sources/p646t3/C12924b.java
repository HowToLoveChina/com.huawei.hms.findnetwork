package p646t3;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.logging.Logger;
import p005a4.C0027g;
import p631s3.C12693p;
import p631s3.C12695r;
import p631s3.InterfaceC12678a;
import p631s3.InterfaceC12694q;

/* renamed from: t3.b */
/* loaded from: classes.dex */
public class C12924b implements InterfaceC12694q<InterfaceC12678a, InterfaceC12678a> {

    /* renamed from: a */
    public static final Logger f58954a = Logger.getLogger(C12924b.class.getName());

    /* renamed from: t3.b$b */
    public static class b implements InterfaceC12678a {

        /* renamed from: a */
        public final C12693p<InterfaceC12678a> f58955a;

        @Override // p631s3.InterfaceC12678a
        /* renamed from: a */
        public byte[] mo88a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            return C0027g.m111a(this.f58955a.m76359b().m76364a(), this.f58955a.m76359b().m76366c().mo88a(bArr, bArr2));
        }

        @Override // p631s3.InterfaceC12678a
        /* renamed from: b */
        public byte[] mo89b(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            if (bArr.length > 5) {
                byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 0, 5);
                byte[] bArrCopyOfRange2 = Arrays.copyOfRange(bArr, 5, bArr.length);
                Iterator<C12693p.b<InterfaceC12678a>> it = this.f58955a.m76360c(bArrCopyOfRange).iterator();
                while (it.hasNext()) {
                    try {
                        return it.next().m76366c().mo89b(bArrCopyOfRange2, bArr2);
                    } catch (GeneralSecurityException e10) {
                        C12924b.f58954a.info("ciphertext prefix matches a key, but cannot decrypt: " + e10.toString());
                    }
                }
            }
            Iterator<C12693p.b<InterfaceC12678a>> it2 = this.f58955a.m76362e().iterator();
            while (it2.hasNext()) {
                try {
                    return it2.next().m76366c().mo89b(bArr, bArr2);
                } catch (GeneralSecurityException unused) {
                }
            }
            throw new GeneralSecurityException("decryption failed");
        }

        public b(C12693p<InterfaceC12678a> c12693p) {
            this.f58955a = c12693p;
        }
    }

    /* renamed from: e */
    public static void m77587e() throws GeneralSecurityException {
        C12695r.m76389r(new C12924b());
    }

    @Override // p631s3.InterfaceC12694q
    /* renamed from: a */
    public Class<InterfaceC12678a> mo76369a() {
        return InterfaceC12678a.class;
    }

    @Override // p631s3.InterfaceC12694q
    /* renamed from: b */
    public Class<InterfaceC12678a> mo76370b() {
        return InterfaceC12678a.class;
    }

    @Override // p631s3.InterfaceC12694q
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public InterfaceC12678a mo76371c(C12693p<InterfaceC12678a> c12693p) throws GeneralSecurityException {
        return new b(c12693p);
    }
}
