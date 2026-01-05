package p239dw;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import aw.C1029b;
import com.huawei.wisesecurity.ucs.credential.entity.UcsKeyStoreProvider;
import java.security.cert.Certificate;
import p238dv.AbstractC9314d;
import p238dv.C9312b;
import p238dv.C9313c;
import p238dv.enumKeyStore;
import p238dv.EnumC9316f;
import p267ev.EnumC9566e;
import p298fv.C9774a;
import p374iv.Exception_C10624c;
import p857zv.C14390d;

/* renamed from: dw.x */
/* loaded from: classes9.dex */
public class C9356x implements InterfaceC9358z {

    /* renamed from: a */
    public static AbstractC9314d f46763a;

    /* renamed from: b */
    public static final InterfaceC9358z f46764b = new C9356x();

    /* renamed from: c */
    public static final Object f46765c = new Object();

    /* JADX WARN: Removed duplicated region for block: B:9:0x001d  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static p239dw.InterfaceC9358z m58717a(com.huawei.wisesecurity.ucs.credential.entity.UcsKeyStoreProvider r4) throws p857zv.C14390d {
        /*
            dv.d r0 = p239dw.C9356x.f46763a
            if (r0 == 0) goto L1d
            dv.e r0 = r0.m58638f()
            java.lang.String r1 = r4.getName()
            dv.e r2 = p238dv.enumKeyStore.ANDROID_KEYSTORE
            java.lang.String r3 = r2.m58643b()
            boolean r1 = android.text.TextUtils.equals(r1, r3)
            if (r1 == 0) goto L19
            goto L1b
        L19:
            dv.e r2 = p238dv.enumKeyStore.HUAWEI_KEYSTORE
        L1b:
            if (r0 == r2) goto L24
        L1d:
            dw.z r0 = p239dw.C9356x.f46764b
            dw.x r0 = (p239dw.C9356x) r0
            r0.m58719c(r4)
        L24:
            dw.z r4 = p239dw.C9356x.f46764b
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: p239dw.C9356x.m58717a(com.huawei.wisesecurity.ucs.credential.entity.UcsKeyStoreProvider):dw.z");
    }

    @SuppressLint({"NewApi"})
    /* renamed from: b */
    public void m58718b(String str) throws C14390d {
        try {
            if (f46763a.m58639g(str)) {
                C1029b.m6234e("KeyStoreManager", "the alias exists", new Object[0]);
                return;
            }
            try {
                f46763a.m58635b(new C9313c.a().m58630a(str).m58633d(EnumC9316f.PURPOSE_SIGN).m58632c(256).m58631b());
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
    public void m58719c(UcsKeyStoreProvider ucsKeyStoreProvider) throws C14390d {
        String name = ucsKeyStoreProvider.getName();
        enumKeyStore enumKeyStore = enumKeyStore.ANDROID_KEYSTORE;
        if (!TextUtils.equals(name, enumKeyStore.m58643b())) {
            enumKeyStore = enumKeyStore.HUAWEI_KEYSTORE;
        }
        f46763a = new C9312b(enumKeyStore);
    }

    /* renamed from: d */
    public Certificate[] m58720d(String str) throws C14390d {
        try {
            return f46763a.m58636d(str);
        } catch (Exception_C10624c e10) {
            C1029b.m6231b("KeyStoreManager", C9352t.m58708a(e10, C9320b.m58651a("getCertificateChain failed, ")), new Object[0]);
            throw new C14390d(C9352t.m58708a(e10, C9320b.m58651a("getCertificateChain failed , exception ")));
        }
    }

    @Override // p239dw.InterfaceC9358z
    /* renamed from: a */
    public byte[] mo58653a(String str, String str2) throws C14390d {
        byte[] bArrSign;
        synchronized (f46765c) {
            try {
                try {
                    bArrSign = new C9774a.b(f46763a.m58638f()).m59683c(EnumC9566e.ECDSA).m84251b(str).mo7646a().getSignHandler().from(str2).sign();
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
