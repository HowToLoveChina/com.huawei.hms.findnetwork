package p791xx;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.EnumC11914c0;
import org.conscrypt.Conscrypt;

/* renamed from: xx.d */
/* loaded from: classes9.dex */
public class C13889d extends C13893h {
    /* renamed from: u */
    public static C13889d m83273u() throws ClassNotFoundException {
        try {
            Class.forName("org.conscrypt.Conscrypt");
            if (Conscrypt.isAvailable()) {
                return new C13889d();
            }
            return null;
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    @Override // p791xx.C13893h
    /* renamed from: f */
    public void mo83274f(SSLSocketFactory sSLSocketFactory) {
        if (Conscrypt.isConscrypt(sSLSocketFactory)) {
            Conscrypt.setUseEngineSocket(sSLSocketFactory, true);
        }
    }

    @Override // p791xx.C13893h
    /* renamed from: g */
    public void mo83244g(SSLSocket sSLSocket, String str, List<EnumC11914c0> list) throws IOException {
        if (!Conscrypt.isConscrypt(sSLSocket)) {
            super.mo83244g(sSLSocket, str, list);
            return;
        }
        if (str != null) {
            Conscrypt.setUseSessionTickets(sSLSocket, true);
            Conscrypt.setHostname(sSLSocket, str);
        }
        Conscrypt.setApplicationProtocols(sSLSocket, (String[]) C13893h.m83286b(list).toArray(new String[0]));
    }

    @Override // p791xx.C13893h
    /* renamed from: m */
    public SSLContext mo83254m() {
        try {
            return SSLContext.getInstance("TLSv1.3", m83275v());
        } catch (NoSuchAlgorithmException e10) {
            try {
                return SSLContext.getInstance("TLS", this.m83275v());
            } catch (NoSuchAlgorithmException unused) {
                throw new IllegalStateException("No TLS provider", e10);
            }
        }
    }

    @Override // p791xx.C13893h
    /* renamed from: n */
    public String mo83245n(SSLSocket sSLSocket) {
        return Conscrypt.isConscrypt(sSLSocket) ? Conscrypt.getApplicationProtocol(sSLSocket) : super.mo83245n(sSLSocket);
    }

    /* renamed from: v */
    public final Provider m83275v() {
        return Conscrypt.newProviderBuilder().provideTrustManager().build();
    }
}
