package p373iu;

import java.io.IOException;
import java.net.Socket;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import p435ku.C11157c;
import p435ku.C11160f;

/* renamed from: iu.d */
/* loaded from: classes5.dex */
public class C10616d extends SSLSocketFactory {

    /* renamed from: g */
    public static final X509HostnameVerifier f51031g = new BrowserCompatHostnameVerifier();

    /* renamed from: h */
    public static final X509HostnameVerifier f51032h = new StrictHostnameVerifier();

    /* renamed from: i */
    public static final String f51033i = C10616d.class.getSimpleName();

    /* renamed from: j */
    public static volatile C10616d f51034j = null;

    /* renamed from: a */
    public SSLContext f51035a;

    /* renamed from: b */
    public SSLSocket f51036b;

    /* renamed from: c */
    public String[] f51037c;

    /* renamed from: d */
    public String[] f51038d;

    /* renamed from: e */
    public String[] f51039e;

    /* renamed from: f */
    public String[] f51040f;

    /* renamed from: a */
    public final void m65070a(Socket socket) {
        boolean zM65066e;
        boolean zM65069h = false;
        if (C11157c.m67083a(this.f51040f)) {
            zM65066e = false;
        } else {
            C11160f.m67096e(f51033i, "set protocols");
            zM65066e = AbstractC10615c.m65066e((SSLSocket) socket, this.f51040f);
        }
        if (!C11157c.m67083a(this.f51039e) || !C11157c.m67083a(this.f51038d)) {
            C11160f.m67096e(f51033i, "set white cipher or black cipher");
            SSLSocket sSLSocket = (SSLSocket) socket;
            AbstractC10615c.m65065d(sSLSocket);
            zM65069h = !C11157c.m67083a(this.f51039e) ? AbstractC10615c.m65069h(sSLSocket, this.f51039e) : AbstractC10615c.m65063b(sSLSocket, this.f51038d);
        }
        if (!zM65066e) {
            C11160f.m67096e(f51033i, "set default protocols");
            AbstractC10615c.m65065d((SSLSocket) socket);
        }
        if (zM65069h) {
            return;
        }
        C11160f.m67096e(f51033i, "set default cipher suites");
        AbstractC10615c.m65064c((SSLSocket) socket);
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.LayeredSocketFactory
    public Socket createSocket(Socket socket, String str, int i10, boolean z10) throws IOException {
        C11160f.m67096e(f51033i, "createSocket: socket host port autoClose");
        Socket socketCreateSocket = this.f51035a.getSocketFactory().createSocket(socket, str, i10, z10);
        if (socketCreateSocket instanceof SSLSocket) {
            m65070a(socketCreateSocket);
            SSLSocket sSLSocket = (SSLSocket) socketCreateSocket;
            this.f51036b = sSLSocket;
            this.f51037c = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return socketCreateSocket;
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.SocketFactory
    public Socket createSocket() throws IOException {
        C11160f.m67096e(f51033i, "createSocket: ");
        Socket socketCreateSocket = this.f51035a.getSocketFactory().createSocket();
        if (socketCreateSocket instanceof SSLSocket) {
            m65070a(socketCreateSocket);
            SSLSocket sSLSocket = (SSLSocket) socketCreateSocket;
            this.f51036b = sSLSocket;
            this.f51037c = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return socketCreateSocket;
    }
}
