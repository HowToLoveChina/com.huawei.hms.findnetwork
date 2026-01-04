package p727w3;

import android.content.Context;
import android.util.Log;
import com.google.crypto.tink.shaded.protobuf.C1903c0;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.ProviderException;
import p631s3.C12679b;
import p631s3.C12684g;
import p631s3.C12686i;
import p631s3.C12687j;
import p631s3.InterfaceC12678a;
import p631s3.InterfaceC12688k;
import p631s3.InterfaceC12689l;
import p727w3.C13524c;

/* renamed from: w3.a */
/* loaded from: classes.dex */
public final class C13522a {

    /* renamed from: d */
    public static final String f60867d = "a";

    /* renamed from: a */
    public final InterfaceC12689l f60868a;

    /* renamed from: b */
    public final InterfaceC12678a f60869b;

    /* renamed from: c */
    public C12687j f60870c;

    /* renamed from: w3.a$b */
    public static final class b {

        /* renamed from: a */
        public InterfaceC12688k f60871a = null;

        /* renamed from: b */
        public InterfaceC12689l f60872b = null;

        /* renamed from: c */
        public String f60873c = null;

        /* renamed from: d */
        public InterfaceC12678a f60874d = null;

        /* renamed from: e */
        public boolean f60875e = true;

        /* renamed from: f */
        public C12684g f60876f = null;

        /* renamed from: g */
        public KeyStore f60877g = null;

        /* renamed from: h */
        public C12687j f60878h;

        /* renamed from: d */
        public synchronized C13522a m81383d() throws GeneralSecurityException, IOException {
            try {
                if (this.f60873c != null) {
                    this.f60874d = m81386g();
                }
                this.f60878h = m81385f();
            } catch (Throwable th2) {
                throw th2;
            }
            return new C13522a(this);
        }

        /* renamed from: e */
        public final C12687j m81384e() throws GeneralSecurityException, IOException {
            InterfaceC12678a interfaceC12678a = this.f60874d;
            if (interfaceC12678a != null) {
                try {
                    return C12687j.m76343j(C12686i.m76335j(this.f60871a, interfaceC12678a));
                } catch (C1903c0 | GeneralSecurityException e10) {
                    Log.w(C13522a.f60867d, "cannot decrypt keyset: ", e10);
                }
            }
            return C12687j.m76343j(C12679b.m76300a(this.f60871a));
        }

        /* renamed from: f */
        public final C12687j m81385f() throws GeneralSecurityException, IOException {
            try {
                return m81384e();
            } catch (FileNotFoundException e10) {
                Log.w(C13522a.f60867d, "keyset not found, will generate a new one", e10);
                if (this.f60876f == null) {
                    throw new GeneralSecurityException("cannot read or generate keyset");
                }
                C12687j c12687jM76344a = C12687j.m76342i().m76344a(this.f60876f);
                C12687j c12687jM76350h = c12687jM76344a.m76350h(c12687jM76344a.m76346c().m76337g().m84529R(0).m84542R());
                if (this.f60874d != null) {
                    c12687jM76350h.m76346c().m76340k(this.f60872b, this.f60874d);
                } else {
                    C12679b.m76301b(c12687jM76350h.m76346c(), this.f60872b);
                }
                return c12687jM76350h;
            }
        }

        /* renamed from: g */
        public final InterfaceC12678a m81386g() throws GeneralSecurityException {
            if (!C13522a.m81378d()) {
                Log.w(C13522a.f60867d, "Android Keystore requires at least Android M");
                return null;
            }
            C13524c c13524cM81398a = this.f60877g != null ? new C13524c.b().m81399b(this.f60877g).m81398a() : new C13524c();
            boolean zM81397e = c13524cM81398a.m81397e(this.f60873c);
            if (!zM81397e) {
                try {
                    C13524c.m81394d(this.f60873c);
                } catch (GeneralSecurityException | ProviderException e10) {
                    Log.w(C13522a.f60867d, "cannot use Android Keystore, it'll be disabled", e10);
                    return null;
                }
            }
            try {
                return c13524cM81398a.mo76355b(this.f60873c);
            } catch (GeneralSecurityException | ProviderException e11) {
                if (zM81397e) {
                    throw new KeyStoreException(String.format("the master key %s exists but is unusable", this.f60873c), e11);
                }
                Log.w(C13522a.f60867d, "cannot use Android Keystore, it'll be disabled", e11);
                return null;
            }
        }

        /* renamed from: h */
        public b m81387h(C12684g c12684g) {
            this.f60876f = c12684g;
            return this;
        }

        /* renamed from: i */
        public b m81388i(String str) {
            if (!str.startsWith("android-keystore://")) {
                throw new IllegalArgumentException("key URI must start with android-keystore://");
            }
            if (!this.f60875e) {
                throw new IllegalArgumentException("cannot call withMasterKeyUri() after calling doNotUseKeystore()");
            }
            this.f60873c = str;
            return this;
        }

        /* renamed from: j */
        public b m81389j(Context context, String str, String str2) throws IOException {
            if (context == null) {
                throw new IllegalArgumentException("need an Android context");
            }
            if (str == null) {
                throw new IllegalArgumentException("need a keyset name");
            }
            this.f60871a = new C13525d(context, str, str2);
            this.f60872b = new C13526e(context, str, str2);
            return this;
        }
    }

    /* renamed from: d */
    public static boolean m81378d() {
        return true;
    }

    /* renamed from: c */
    public synchronized C12686i m81379c() throws GeneralSecurityException {
        return this.f60870c.m76346c();
    }

    public C13522a(b bVar) throws GeneralSecurityException, IOException {
        this.f60868a = bVar.f60872b;
        this.f60869b = bVar.f60874d;
        this.f60870c = bVar.f60878h;
    }
}
