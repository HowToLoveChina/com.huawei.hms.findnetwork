package p347hv;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.AlgorithmParameterSpec;
import p238dv.enumKeyStore;
import p267ev.AbstractC9562a;
import p267ev.C9563b;
import p267ev.C9564c;
import p267ev.C9568g;
import p267ev.EnumC9566e;
import p267ev.InterfaceC9565d;
import p267ev.InterfaceC9567f;
import p267ev.InterfaceC9569h;
import p374iv.Exception_C10623b;

/* renamed from: hv.a */
/* loaded from: classes9.dex */
public class C10345a implements InterfaceC9565d {

    /* renamed from: a */
    public final EnumC9566e f50033a;

    /* renamed from: b */
    public final enumKeyStore f50034b;

    /* renamed from: c */
    public final PrivateKey f50035c;

    /* renamed from: d */
    public final PublicKey f50036d;

    /* renamed from: e */
    public final AlgorithmParameterSpec f50037e;

    /* renamed from: hv.a$b */
    public static class b extends AbstractC9562a<C10345a> {
        public b(enumKeyStore enumKeyStore) {
            super(enumKeyStore);
            m59683c(EnumC9566e.m59694b("RSA"));
        }

        @Override // p822yu.AbstractC14045a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public C10345a mo7646a() throws Exception_C10623b {
            return new C10345a(this.f62833d, this.f47476e, this.f62830a, this.f62831b, this.f62832c);
        }
    }

    @Override // p267ev.InterfaceC9565d
    public InterfaceC9567f getSignHandler() throws Exception_C10623b {
        C9568g c9568g = new C9568g();
        c9568g.m59699d(this.f50033a);
        PrivateKey privateKey = this.f50035c;
        if (privateKey != null) {
            return new C9563b(this.f50034b, privateKey, c9568g, this.f50037e);
        }
        throw new Exception_C10623b("privateKey is invalid.");
    }

    @Override // p267ev.InterfaceC9565d
    public InterfaceC9569h getVerifyHandler() throws Exception_C10623b {
        C9568g c9568g = new C9568g();
        c9568g.m59699d(this.f50033a);
        PublicKey publicKey = this.f50036d;
        if (publicKey != null) {
            return new C9564c(this.f50034b, publicKey, c9568g, this.f50037e);
        }
        throw new Exception_C10623b("publicKey is invalid.");
    }

    public C10345a(enumKeyStore enumKeyStore, EnumC9566e enumC9566e, PrivateKey privateKey, PublicKey publicKey, AlgorithmParameterSpec algorithmParameterSpec) {
        this.f50034b = enumKeyStore;
        this.f50033a = enumC9566e;
        this.f50035c = privateKey;
        this.f50036d = publicKey;
        this.f50037e = algorithmParameterSpec;
    }
}
