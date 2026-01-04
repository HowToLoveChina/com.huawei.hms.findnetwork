package p005a4;

import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;
import p005a4.InterfaceC0034n;

/* renamed from: a4.m */
/* loaded from: classes.dex */
public final class C0033m<T_WRAPPER extends InterfaceC0034n<T_ENGINE>, T_ENGINE> {

    /* renamed from: d */
    public static final Logger f84d = Logger.getLogger(C0033m.class.getName());

    /* renamed from: e */
    public static final List<Provider> f85e;

    /* renamed from: f */
    public static final C0033m<InterfaceC0034n.a, Cipher> f86f;

    /* renamed from: g */
    public static final C0033m<InterfaceC0034n.e, Mac> f87g;

    /* renamed from: h */
    public static final C0033m<InterfaceC0034n.g, Signature> f88h;

    /* renamed from: i */
    public static final C0033m<InterfaceC0034n.f, MessageDigest> f89i;

    /* renamed from: j */
    public static final C0033m<InterfaceC0034n.b, KeyAgreement> f90j;

    /* renamed from: k */
    public static final C0033m<InterfaceC0034n.d, KeyPairGenerator> f91k;

    /* renamed from: l */
    public static final C0033m<InterfaceC0034n.c, KeyFactory> f92l;

    /* renamed from: a */
    public T_WRAPPER f93a;

    /* renamed from: b */
    public List<Provider> f94b = f85e;

    /* renamed from: c */
    public boolean f95c = true;

    static {
        if (C0042v.m164b()) {
            f85e = m133b("GmsCore_OpenSSL", "AndroidOpenSSL");
        } else {
            f85e = new ArrayList();
        }
        f86f = new C0033m<>(new InterfaceC0034n.a());
        f87g = new C0033m<>(new InterfaceC0034n.e());
        f88h = new C0033m<>(new InterfaceC0034n.g());
        f89i = new C0033m<>(new InterfaceC0034n.f());
        f90j = new C0033m<>(new InterfaceC0034n.b());
        f91k = new C0033m<>(new InterfaceC0034n.d());
        f92l = new C0033m<>(new InterfaceC0034n.c());
    }

    public C0033m(T_WRAPPER t_wrapper) {
        this.f93a = t_wrapper;
    }

    /* renamed from: b */
    public static List<Provider> m133b(String... strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            Provider provider = Security.getProvider(str);
            if (provider != null) {
                arrayList.add(provider);
            } else {
                f84d.info(String.format("Provider %s not available", str));
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public T_ENGINE m134a(String str) throws GeneralSecurityException {
        Iterator<Provider> it = this.f94b.iterator();
        Exception exc = null;
        while (it.hasNext()) {
            try {
                return (T_ENGINE) this.f93a.mo135a(str, it.next());
            } catch (Exception e10) {
                if (exc == null) {
                    exc = e10;
                }
            }
        }
        if (this.f95c) {
            return (T_ENGINE) this.f93a.mo135a(str, null);
        }
        throw new GeneralSecurityException("No good Provider found.", exc);
    }
}
