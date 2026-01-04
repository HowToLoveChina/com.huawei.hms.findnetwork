package p238dv;

import android.util.Log;
import java.io.IOException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.util.Arrays;
import mv.C11530c;
import mv.C11532e;
import p267ev.InterfaceC9565d;
import p374iv.C10624c;
import p374iv.C10625d;
import p374iv.C10626e;
import p500nv.C11756a;
import p856zu.InterfaceC14386g;

/* renamed from: dv.d */
/* loaded from: classes9.dex */
public abstract class AbstractC9314d {

    /* renamed from: a */
    public KeyStore f46683a;

    /* renamed from: b */
    public final EnumC9315e f46684b;

    public AbstractC9314d(EnumC9315e enumC9315e) {
        this.f46684b = enumC9315e;
    }

    /* renamed from: a */
    public final void m58634a(String str) throws C10624c, KeyStoreException {
        if (m58639g(str)) {
            try {
                this.f46683a.deleteEntry(str);
                Log.i("KeyStoreKeyManager", "keyEntry: " + str + " removed");
            } catch (KeyStoreException e10) {
                throw new C10624c("delete key entry failed, " + e10.getMessage());
            }
        }
    }

    /* renamed from: b */
    public void m58635b(C9313c c9313c) throws C10624c, KeyStoreException {
        C11756a.m70079b(c9313c);
        mo58624k(c9313c);
        mo58622c(c9313c);
        try {
            mo58623j(c9313c);
        } catch (C10624c e10) {
            Log.i("KeyStoreKeyManager", "validate key failed, try to remove the key entry for alias:" + c9313c.m58626a());
            m58634a(c9313c.m58626a());
            throw e10;
        }
    }

    /* renamed from: c */
    public abstract void mo58622c(C9313c c9313c) throws C10624c;

    /* renamed from: d */
    public Certificate[] m58636d(String str) throws C10624c, NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException {
        m58640h();
        try {
            return this.f46683a.getCertificateChain(str);
        } catch (KeyStoreException e10) {
            throw new C10624c("keystore get certificate chain failed, " + e10.getMessage());
        }
    }

    /* renamed from: e */
    public Key m58637e(String str) throws C10624c, NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException {
        m58640h();
        try {
            return this.f46683a.getKey(str, null);
        } catch (KeyStoreException | NoSuchAlgorithmException | UnrecoverableKeyException e10) {
            throw new C10624c("keystore get key failed, " + e10.getMessage());
        }
    }

    /* renamed from: f */
    public EnumC9315e m58638f() {
        return this.f46684b;
    }

    /* renamed from: g */
    public boolean m58639g(String str) throws C10624c, NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException {
        m58640h();
        try {
            return this.f46683a.containsAlias(str);
        } catch (KeyStoreException e10) {
            throw new C10624c("keystore check alias failed, " + e10.getMessage());
        }
    }

    /* renamed from: h */
    public void m58640h() throws C10624c, NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException {
        if (this.f46683a != null) {
            return;
        }
        if (m58638f() == EnumC9315e.HUAWEI_KEYSTORE) {
            C11530c.m68818a();
        }
        try {
            KeyStore keyStore = KeyStore.getInstance(this.f46684b.m58643b());
            this.f46683a = keyStore;
            keyStore.load(null);
        } catch (IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException e10) {
            throw new C10624c("init keystore failed, " + e10.getMessage());
        }
    }

    /* renamed from: i */
    public void m58641i(InterfaceC14386g interfaceC14386g) throws C10624c {
        byte[] bArrM68822b = C11532e.m68822b(32);
        if (!Arrays.equals(bArrM68822b, interfaceC14386g.getDecryptHandler().from(interfaceC14386g.getEncryptHandler().from(bArrM68822b).mo56622to()).mo56620to())) {
            throw new C10625d("validate crypto key get bad result");
        }
    }

    /* renamed from: j */
    public abstract void mo58623j(C9313c c9313c) throws C10624c;

    /* renamed from: k */
    public abstract void mo58624k(C9313c c9313c) throws C10626e;

    /* renamed from: l */
    public void m58642l(InterfaceC9565d interfaceC9565d) throws C10624c {
        byte[] bArrM68822b = C11532e.m68822b(32);
        if (!interfaceC9565d.getVerifyHandler().fromData(bArrM68822b).verify(interfaceC9565d.getSignHandler().from(bArrM68822b).sign())) {
            throw new C10625d("validate sign key get bad result");
        }
    }

    public AbstractC9314d() {
        this(EnumC9315e.ANDROID_KEYSTORE);
    }
}
