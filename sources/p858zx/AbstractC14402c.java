package p858zx;

import java.security.cert.Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;
import p791xx.C13893h;

/* renamed from: zx.c */
/* loaded from: classes9.dex */
public abstract class AbstractC14402c {
    /* renamed from: b */
    public static AbstractC14402c m85631b(X509TrustManager x509TrustManager) {
        return C13893h.m83291l().mo83251c(x509TrustManager);
    }

    /* renamed from: a */
    public abstract List<Certificate> mo83261a(List<Certificate> list, String str) throws SSLPeerUnverifiedException;
}
