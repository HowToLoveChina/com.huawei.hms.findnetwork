package p698v3;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.logging.Logger;
import p005a4.C0027g;
import p631s3.C12693p;
import p631s3.C12695r;
import p631s3.InterfaceC12681d;
import p631s3.InterfaceC12694q;

/* renamed from: v3.c */
/* loaded from: classes.dex */
public class C13331c implements InterfaceC12694q<InterfaceC12681d, InterfaceC12681d> {

    /* renamed from: a */
    public static final Logger f60147a = Logger.getLogger(C13331c.class.getName());

    /* renamed from: v3.c$a */
    public static class a implements InterfaceC12681d {

        /* renamed from: a */
        public C12693p<InterfaceC12681d> f60148a;

        public a(C12693p<InterfaceC12681d> c12693p) {
            this.f60148a = c12693p;
        }

        @Override // p631s3.InterfaceC12681d
        /* renamed from: a */
        public byte[] mo97a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            return C0027g.m111a(this.f60148a.m76359b().m76364a(), this.f60148a.m76359b().m76366c().mo97a(bArr, bArr2));
        }

        @Override // p631s3.InterfaceC12681d
        /* renamed from: b */
        public byte[] mo98b(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            if (bArr.length > 5) {
                byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 0, 5);
                byte[] bArrCopyOfRange2 = Arrays.copyOfRange(bArr, 5, bArr.length);
                Iterator<C12693p.b<InterfaceC12681d>> it = this.f60148a.m76360c(bArrCopyOfRange).iterator();
                while (it.hasNext()) {
                    try {
                        return it.next().m76366c().mo98b(bArrCopyOfRange2, bArr2);
                    } catch (GeneralSecurityException e10) {
                        C13331c.f60147a.info("ciphertext prefix matches a key, but cannot decrypt: " + e10.toString());
                    }
                }
            }
            Iterator<C12693p.b<InterfaceC12681d>> it2 = this.f60148a.m76362e().iterator();
            while (it2.hasNext()) {
                try {
                    return it2.next().m76366c().mo98b(bArr, bArr2);
                } catch (GeneralSecurityException unused) {
                }
            }
            throw new GeneralSecurityException("decryption failed");
        }
    }

    /* renamed from: e */
    public static void m79945e() throws GeneralSecurityException {
        C12695r.m76389r(new C13331c());
    }

    @Override // p631s3.InterfaceC12694q
    /* renamed from: a */
    public Class<InterfaceC12681d> mo76369a() {
        return InterfaceC12681d.class;
    }

    @Override // p631s3.InterfaceC12694q
    /* renamed from: b */
    public Class<InterfaceC12681d> mo76370b() {
        return InterfaceC12681d.class;
    }

    @Override // p631s3.InterfaceC12694q
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public InterfaceC12681d mo76371c(C12693p<InterfaceC12681d> c12693p) {
        return new a(c12693p);
    }
}
