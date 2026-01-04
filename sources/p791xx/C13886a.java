package p791xx;

import android.annotation.SuppressLint;
import android.net.ssl.SSLSockets;
import com.android.org.conscrypt.OpenSSLSocketImpl;
import java.io.IOException;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import okhttp3.EnumC11914c0;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

@SuppressLint({"NewApi"})
/* renamed from: xx.a */
/* loaded from: classes9.dex */
public class C13886a extends C13888c {
    public C13886a(Class<?> cls) {
        super(cls, null, null, null, null, null);
    }

    /* renamed from: w */
    public static C13893h m83243w() {
        if (!C13893h.m83292p()) {
            return null;
        }
        try {
            if (C13888c.m83269x() >= 29) {
                return new C13886a(Class.forName("com.android.org.conscrypt.SSLParametersImpl"));
            }
        } catch (ReflectiveOperationException unused) {
        }
        return null;
    }

    @Override // p791xx.C13888c, p791xx.C13893h
    @SuppressLint({"NewApi"})
    @IgnoreJRERequirement
    /* renamed from: g */
    public void mo83244g(SSLSocket sSLSocket, String str, List<EnumC11914c0> list) throws IOException {
        try {
            m83246y(sSLSocket);
            m83247z(sSLSocket, str);
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            sSLParameters.setApplicationProtocols((String[]) C13893h.m83286b(list).toArray(new String[0]));
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalArgumentException e10) {
            throw new IOException("Android internal error", e10);
        }
    }

    @Override // p791xx.C13888c, p791xx.C13893h
    @IgnoreJRERequirement
    /* renamed from: n */
    public String mo83245n(SSLSocket sSLSocket) {
        String applicationProtocol = sSLSocket.getApplicationProtocol();
        if (applicationProtocol == null || applicationProtocol.isEmpty()) {
            return null;
        }
        return applicationProtocol;
    }

    /* renamed from: y */
    public final void m83246y(SSLSocket sSLSocket) {
        if (SSLSockets.isSupportedSocket(sSLSocket)) {
            SSLSockets.setUseSessionTickets(sSLSocket, true);
        }
    }

    /* renamed from: z */
    public final void m83247z(SSLSocket sSLSocket, String str) {
        try {
            if (sSLSocket instanceof OpenSSLSocketImpl) {
                ((OpenSSLSocketImpl) sSLSocket).setHostname(str);
            }
        } catch (Throwable unused) {
            C13893h.m83291l().mo83257s(5, "Android10Platform sethostname error", null);
        }
    }
}
