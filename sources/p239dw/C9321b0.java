package p239dw;

import android.annotation.SuppressLint;
import aw.C1029b;
import bv.C1290a;
import com.huawei.wisesecurity.ucs.credential.entity.UcsKeyStoreProvider;
import java.security.cert.Certificate;
import p238dv.C9313c;
import p238dv.C9317g;
import p238dv.EnumC9316f;
import p267ev.EnumC9566e;
import p347hv.C10345a;
import p374iv.Exception_C10624c;
import p856zu.enumEncryptAlgorithm;
import p857zv.C14390d;

/* renamed from: dw.b0 */
/* loaded from: classes9.dex */
public class C9321b0 implements InterfaceC9358z {

    /* renamed from: a */
    public static C9317g f46695a;

    /* renamed from: b */
    public static final C9321b0 f46696b = new C9321b0();

    /* renamed from: c */
    public static final Object f46697c = new Object();

    /* renamed from: a */
    public void m58652a(UcsKeyStoreProvider ucsKeyStoreProvider) {
        f46695a = new C9317g();
    }

    @SuppressLint({"NewApi"})
    /* renamed from: b */
    public void m58654b(String str) throws C14390d {
        try {
            if (f46695a.m58639g(str)) {
                C1029b.m6234e("KeyStoreManager", "the alias exists", new Object[0]);
                return;
            }
            try {
                f46695a.m58635b(new C9313c.a().m58630a(str).m58633d(EnumC9316f.PURPOSE_ALL).m58632c(3072).m58631b());
                C1029b.m6234e("KeyStoreManager", "generateKeyPair OK", new Object[0]);
            } catch (Exception_C10624c e10) {
                C1029b.m6231b("KeyStoreManager", C9352t.m58708a(e10, C9320b.m58651a("generateKeyPair failed, ")), new Object[0]);
                throw new C14390d(C9352t.m58708a(e10, C9320b.m58651a("generateKeyPair failed , exception ")));
            }
        } catch (Exception_C10624c e11) {
            C1029b.m6231b("KeyStoreManager", C9352t.m58708a(e11, C9320b.m58651a("containsAlias failed, ")), new Object[0]);
            throw new C14390d(C9352t.m58708a(e11, C9320b.m58651a("containsAlias failed , exception ")));
        }
    }

    /* renamed from: c */
    public byte[] m58655c(String str, byte[] bArr) throws C14390d {
        byte[] bArrMo56620to;
        synchronized (f46697c) {
            try {
                try {
                    bArrMo56620to = new C1290a.b(f46695a.m58638f()).m7648d(enumEncryptAlgorithm.RSA_OAEP).m84251b(str).mo7646a().getDecryptHandler().from(bArr).mo56620to();
                } catch (Exception_C10624c e10) {
                    C1029b.m6231b("KeyStoreManager", "doDecrypt failed, " + e10.getMessage(), new Object[0]);
                    throw new C14390d("doDecrypt failed , exception " + e10.getMessage());
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return bArrMo56620to;
    }

    /* renamed from: d */
    public Certificate[] m58656d(String str) throws C14390d {
        try {
            return f46695a.m58636d(str);
        } catch (Exception_C10624c e10) {
            C1029b.m6231b("KeyStoreManager", C9352t.m58708a(e10, C9320b.m58651a("getCertificateChain failed, ")), new Object[0]);
            throw new C14390d(C9352t.m58708a(e10, C9320b.m58651a("getCertificateChain failed , exception ")));
        }
    }

    @Override // p239dw.InterfaceC9358z
    /* renamed from: a */
    public byte[] mo58653a(String str, String str2) throws C14390d {
        byte[] bArrSign;
        synchronized (f46697c) {
            try {
                try {
                    bArrSign = new C10345a.b(f46695a.m58638f()).m59683c(EnumC9566e.RSA_SHA256_PSS).m84251b(str).mo7646a().getSignHandler().from(str2).sign();
                } catch (Exception_C10624c e10) {
                    C1029b.m6231b("KeyStoreManager", "doSign failed, " + e10.getMessage(), new Object[0]);
                    throw new C14390d("doSign failed , exception " + e10.getMessage());
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return bArrSign;
    }
}
