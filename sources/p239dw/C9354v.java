package p239dw;

import android.annotation.SuppressLint;
import aw.C1029b;
import java.security.KeyStoreException;
import p021av.C1027a;
import p238dv.C9311a;
import p238dv.C9313c;
import p238dv.EnumC9316f;
import p374iv.Exception_C10624c;
import p856zu.enumEncryptAlgorithm;
import p857zv.C14390d;

/* renamed from: dw.v */
/* loaded from: classes9.dex */
public class C9354v implements InterfaceC9358z {

    /* renamed from: b */
    public static final InterfaceC9358z f46759b = new C9354v();

    /* renamed from: c */
    public static final Object f46760c = new Object();

    /* renamed from: d */
    public static C9311a f46761d;

    /* renamed from: a */
    public byte[] f46762a;

    @Override // p239dw.InterfaceC9358z
    /* renamed from: a */
    public byte[] mo58653a(String str, String str2) throws C14390d {
        return new byte[0];
    }

    /* renamed from: b */
    public byte[] m58713b(String str, byte[] bArr) throws C14390d {
        byte[] bArrMo56620to;
        synchronized (f46760c) {
            try {
                byte[] bArr2 = this.f46762a;
                if (bArr2 == null || bArr2.length <= 0) {
                    throw new C14390d("iv must be set before AES decrypt");
                }
                try {
                    bArrMo56620to = new C1027a.b(f46761d.m58638f()).m6222b(enumEncryptAlgorithm.AES_GCM).setKey(f46761d.m58637e(str)).m6223c(this.f46762a).m6221a().getDecryptHandler().from(bArr).mo56620to();
                } catch (Exception_C10624c e10) {
                    C1029b.m6231b("KeyStoreManager", "AES doDecrypt failed, " + e10.getMessage(), new Object[0]);
                    throw new C14390d("AES doDecrypt failed , exception " + e10.getMessage());
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return bArrMo56620to;
    }

    /* renamed from: c */
    public byte[] m58714c(String str, byte[] bArr) throws C14390d {
        byte[] bArrMo56622to;
        synchronized (f46760c) {
            try {
                byte[] bArr2 = this.f46762a;
                if (bArr2 == null || bArr2.length <= 0) {
                    throw new C14390d("iv must be set before AES encrypt");
                }
                try {
                    bArrMo56622to = new C1027a.b(f46761d.m58638f()).m6222b(enumEncryptAlgorithm.AES_GCM).setKey(f46761d.m58637e(str)).m6223c(this.f46762a).m6221a().getEncryptHandler().from(bArr).toEnDecryptKeyBytes();
                } catch (Exception_C10624c e10) {
                    C1029b.m6231b("KeyStoreManager", "AES doEncrypt failed, " + e10.getMessage(), new Object[0]);
                    throw new C14390d("AES doEncrypt failed , exception " + e10.getMessage());
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return bArrMo56622to;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public void m58712a(String str) throws KeyStoreException, C14390d {
        try {
            if (f46761d.m58639g(str)) {
                C1029b.m6234e("KeyStoreManager", "the alias exists", new Object[0]);
                return;
            }
            try {
                f46761d.m58635b(new C9313c(str, 256, EnumC9316f.PURPOSE_CRYPTO));
            } catch (Exception_C10624c e10) {
                C1029b.m6231b("KeyStoreManager", C9352t.m58708a(e10, C9320b.m58651a("generateKeyPair failed, ")), new Object[0]);
                throw new C14390d(C9352t.m58708a(e10, C9320b.m58651a("generateKeyPair failed , exception ")));
            }
        } catch (Exception_C10624c e11) {
            C1029b.m6231b("KeyStoreManager", C9352t.m58708a(e11, C9320b.m58651a("containsAlias failed, ")), new Object[0]);
            throw new C14390d(C9352t.m58708a(e11, C9320b.m58651a("containsAlias failed , exception ")));
        }
    }
}
