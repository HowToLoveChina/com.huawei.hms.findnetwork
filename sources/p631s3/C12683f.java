package p631s3;

import com.google.crypto.tink.shaded.protobuf.AbstractC1920i;
import com.google.crypto.tink.shaded.protobuf.C1903c0;
import com.google.crypto.tink.shaded.protobuf.InterfaceC1951s0;
import java.security.GeneralSecurityException;
import p631s3.AbstractC12685h;
import p831z3.C14125y;

/* renamed from: s3.f */
/* loaded from: classes.dex */
public class C12683f<PrimitiveT, KeyProtoT extends InterfaceC1951s0> implements InterfaceC12682e<PrimitiveT> {

    /* renamed from: a */
    public final AbstractC12685h<KeyProtoT> f58194a;

    /* renamed from: b */
    public final Class<PrimitiveT> f58195b;

    /* renamed from: s3.f$a */
    public static class a<KeyFormatProtoT extends InterfaceC1951s0, KeyProtoT extends InterfaceC1951s0> {

        /* renamed from: a */
        public final AbstractC12685h.a<KeyFormatProtoT, KeyProtoT> f58196a;

        public a(AbstractC12685h.a<KeyFormatProtoT, KeyProtoT> aVar) {
            this.f58196a = aVar;
        }

        /* renamed from: a */
        public KeyProtoT m76310a(AbstractC1920i abstractC1920i) throws GeneralSecurityException, C1903c0 {
            return (KeyProtoT) m76311b(this.f58196a.mo76326c(abstractC1920i));
        }

        /* renamed from: b */
        public final KeyProtoT m76311b(KeyFormatProtoT keyformatprotot) throws GeneralSecurityException {
            this.f58196a.mo76327d(keyformatprotot);
            return this.f58196a.mo76324a(keyformatprotot);
        }
    }

    public C12683f(AbstractC12685h<KeyProtoT> abstractC12685h, Class<PrimitiveT> cls) {
        if (!abstractC12685h.m76322h().contains(cls) && !Void.class.equals(cls)) {
            throw new IllegalArgumentException(String.format("Given internalKeyMananger %s does not support primitive class %s", abstractC12685h.toString(), cls.getName()));
        }
        this.f58194a = abstractC12685h;
        this.f58195b = cls;
    }

    @Override // p631s3.InterfaceC12682e
    /* renamed from: a */
    public final boolean mo76303a(String str) {
        return str.equals(m76307e());
    }

    @Override // p631s3.InterfaceC12682e
    /* renamed from: b */
    public final InterfaceC1951s0 mo76304b(AbstractC1920i abstractC1920i) throws GeneralSecurityException {
        try {
            return m76308f().m76310a(abstractC1920i);
        } catch (C1903c0 e10) {
            throw new GeneralSecurityException("Failures parsing proto of type " + this.f58194a.mo76319e().m76325b().getName(), e10);
        }
    }

    @Override // p631s3.InterfaceC12682e
    /* renamed from: c */
    public final C14125y mo76305c(AbstractC1920i abstractC1920i) throws GeneralSecurityException {
        try {
            return C14125y.m84750U().m84758y(m76307e()).m84759z(m76308f().m76310a(abstractC1920i).mo11459g()).m84757x(this.f58194a.mo76320f()).build();
        } catch (C1903c0 e10) {
            throw new GeneralSecurityException("Unexpected proto", e10);
        }
    }

    @Override // p631s3.InterfaceC12682e
    /* renamed from: d */
    public final PrimitiveT mo76306d(AbstractC1920i abstractC1920i) throws GeneralSecurityException {
        try {
            return m76309g(this.f58194a.mo76321g(abstractC1920i));
        } catch (C1903c0 e10) {
            throw new GeneralSecurityException("Failures parsing proto of type " + this.f58194a.m76316b().getName(), e10);
        }
    }

    /* renamed from: e */
    public final String m76307e() {
        return this.f58194a.mo76317c();
    }

    /* renamed from: f */
    public final a<?, KeyProtoT> m76308f() {
        return new a<>(this.f58194a.mo76319e());
    }

    /* renamed from: g */
    public final PrimitiveT m76309g(KeyProtoT keyprotot) throws GeneralSecurityException {
        if (Void.class.equals(this.f58195b)) {
            throw new GeneralSecurityException("Cannot create a primitive for Void");
        }
        this.f58194a.mo76323i(keyprotot);
        return (PrimitiveT) this.f58194a.m76318d(keyprotot, this.f58195b);
    }
}
