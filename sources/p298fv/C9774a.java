package p298fv;

import java.security.PrivateKey;
import java.security.PublicKey;
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

/* renamed from: fv.a */
/* loaded from: classes9.dex */
public class C9774a implements InterfaceC9565d {

    /* renamed from: a */
    public final EnumC9566e f48059a;

    /* renamed from: b */
    public final PrivateKey f48060b;

    /* renamed from: c */
    public final PublicKey f48061c;

    /* renamed from: d */
    public final enumKeyStore f48062d;

    /* renamed from: fv.a$b */
    public static class b extends AbstractC9562a<C9774a> {
        public b(enumKeyStore enumKeyStore) {
            super(enumKeyStore);
            m59683c(EnumC9566e.m59694b("EC"));
        }

        @Override // p822yu.AbstractC14045a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public C9774a mo7646a() throws Exception_C10623b {
            return new C9774a(this.f62833d, this.f47476e, this.f62830a, this.f62831b);
        }
    }

    @Override // p267ev.InterfaceC9565d
    public InterfaceC9567f getSignHandler() throws Exception_C10623b {
        C9568g c9568g = new C9568g();
        c9568g.m59699d(this.f48059a);
        PrivateKey privateKey = this.f48060b;
        if (privateKey != null) {
            return new C9563b(this.f48062d, privateKey, c9568g, null);
        }
        throw new Exception_C10623b("privateKey is invalid.");
    }

    @Override // p267ev.InterfaceC9565d
    public InterfaceC9569h getVerifyHandler() throws Exception_C10623b {
        C9568g c9568g = new C9568g();
        c9568g.m59699d(this.f48059a);
        PublicKey publicKey = this.f48061c;
        if (publicKey != null) {
            return new C9564c(this.f48062d, publicKey, c9568g, null);
        }
        throw new Exception_C10623b("publicKey is invalid.");
    }

    public C9774a(enumKeyStore enumKeyStore, EnumC9566e enumC9566e, PrivateKey privateKey, PublicKey publicKey) {
        this.f48062d = enumKeyStore;
        this.f48059a = enumC9566e;
        this.f48060b = privateKey;
        this.f48061c = publicKey;
    }
}
