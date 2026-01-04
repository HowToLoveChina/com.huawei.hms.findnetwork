package p026b2;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import p243e0.InterfaceC9370e;
import p630s2.C12673h;
import p630s2.C12676k;
import p630s2.C12677l;
import p645t2.AbstractC12922c;
import p645t2.C12920a;
import p759x1.InterfaceC13681f;

/* renamed from: b2.d */
/* loaded from: classes.dex */
public class C1102d {

    /* renamed from: a */
    public final C12673h<InterfaceC13681f, String> f5230a = new C12673h<>(1000);

    /* renamed from: b */
    public final InterfaceC9370e<b> f5231b = C12920a.m77569d(10, new a());

    /* renamed from: b2.d$a */
    public class a implements C12920a.d<b> {
        public a() {
        }

        @Override // p645t2.C12920a.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public b mo6551a() {
            try {
                return new b(MessageDigest.getInstance("SHA-256"));
            } catch (NoSuchAlgorithmException e10) {
                throw new RuntimeException(e10);
            }
        }
    }

    /* renamed from: b2.d$b */
    public static final class b implements C12920a.f {

        /* renamed from: a */
        public final MessageDigest f5233a;

        /* renamed from: b */
        public final AbstractC12922c f5234b = AbstractC12922c.m77581a();

        public b(MessageDigest messageDigest) {
            this.f5233a = messageDigest;
        }

        @Override // p645t2.C12920a.f
        /* renamed from: i */
        public AbstractC12922c mo6553i() {
            return this.f5234b;
        }
    }

    /* renamed from: a */
    public final String m6549a(InterfaceC13681f interfaceC13681f) {
        b bVar = (b) C12676k.m76276d(this.f5231b.mo58738b());
        try {
            interfaceC13681f.mo56817a(bVar.f5233a);
            return C12677l.m76299v(bVar.f5233a.digest());
        } finally {
            this.f5231b.mo58737a(bVar);
        }
    }

    /* renamed from: b */
    public String m6550b(InterfaceC13681f interfaceC13681f) {
        String strM76265f;
        synchronized (this.f5230a) {
            strM76265f = this.f5230a.m76265f(interfaceC13681f);
        }
        if (strM76265f == null) {
            strM76265f = m6549a(interfaceC13681f);
        }
        synchronized (this.f5230a) {
            this.f5230a.m76267j(interfaceC13681f, strM76265f);
        }
        return strM76265f;
    }
}
