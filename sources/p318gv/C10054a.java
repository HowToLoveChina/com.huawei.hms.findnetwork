package p318gv;

import java.security.Key;
import javax.crypto.spec.SecretKeySpec;
import p238dv.EnumC9315e;
import p267ev.C9563b;
import p267ev.C9564c;
import p267ev.C9568g;
import p267ev.EnumC9566e;
import p267ev.InterfaceC9565d;
import p267ev.InterfaceC9567f;
import p267ev.InterfaceC9569h;
import p374iv.C10623b;

/* renamed from: gv.a */
/* loaded from: classes9.dex */
public class C10054a implements InterfaceC9565d {

    /* renamed from: a */
    public final EnumC9566e f49019a;

    /* renamed from: b */
    public final Key f49020b;

    /* renamed from: c */
    public final EnumC9315e f49021c;

    /* renamed from: gv.a$b */
    public static class b {

        /* renamed from: b */
        public Key f49023b;

        /* renamed from: a */
        public EnumC9566e f49022a = EnumC9566e.m59694b("HMAC");

        /* renamed from: c */
        public final EnumC9315e f49024c = EnumC9315e.ANDROID_KEYSTORE;

        /* renamed from: a */
        public C10054a m62493a() throws C10623b {
            Key key = this.f49023b;
            if (key != null) {
                return new C10054a(this.f49024c, this.f49022a, key);
            }
            throw new C10623b("key cannot be null");
        }

        /* renamed from: b */
        public b m62494b(EnumC9566e enumC9566e) {
            this.f49022a = enumC9566e;
            return this;
        }

        /* renamed from: c */
        public b m62495c(byte[] bArr) {
            this.f49023b = new SecretKeySpec(bArr, this.f49022a.m59695e());
            return this;
        }
    }

    @Override // p267ev.InterfaceC9565d
    public InterfaceC9567f getSignHandler() throws C10623b {
        C9568g c9568g = new C9568g();
        c9568g.m59699d(this.f49019a);
        return new C9563b(this.f49021c, this.f49020b, c9568g, null);
    }

    @Override // p267ev.InterfaceC9565d
    public InterfaceC9569h getVerifyHandler() throws C10623b {
        C9568g c9568g = new C9568g();
        c9568g.m59699d(this.f49019a);
        return new C9564c(this.f49021c, this.f49020b, c9568g, null);
    }

    public C10054a(EnumC9315e enumC9315e, EnumC9566e enumC9566e, Key key) {
        this.f49021c = enumC9315e;
        this.f49019a = enumC9566e;
        this.f49020b = key;
    }
}
