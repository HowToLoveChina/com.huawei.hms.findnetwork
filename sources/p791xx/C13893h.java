package p791xx;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.C11912b0;
import okhttp3.EnumC11914c0;
import p022ay.C1054d;
import p858zx.AbstractC14402c;
import p858zx.C14400a;
import p858zx.C14401b;
import p858zx.InterfaceC14404e;
import sx.C12873c;
import sx.C12875e;

/* renamed from: xx.h */
/* loaded from: classes9.dex */
public class C13893h {

    /* renamed from: a */
    public static final C13893h f62230a = m83290k();

    /* renamed from: b */
    public static final Logger f62231b = Logger.getLogger(C11912b0.class.getName());

    /* renamed from: b */
    public static List<String> m83286b(List<EnumC11914c0> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            EnumC11914c0 enumC11914c0 = list.get(i10);
            if (enumC11914c0 != EnumC11914c0.HTTP_1_0) {
                arrayList.add(enumC11914c0.toString());
            }
        }
        return arrayList;
    }

    /* renamed from: e */
    public static byte[] m83287e(List<EnumC11914c0> list) {
        C1054d c1054d = new C1054d();
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            EnumC11914c0 enumC11914c0 = list.get(i10);
            if (enumC11914c0 != EnumC11914c0.HTTP_1_0) {
                c1054d.writeByte(enumC11914c0.toString().length());
                c1054d.mo6329R(enumC11914c0.toString());
            }
        }
        return c1054d.m6311A();
    }

    /* renamed from: i */
    public static C13893h m83288i() {
        C13893h c13893hM83243w = C13886a.m83243w();
        if (c13893hM83243w != null) {
            return c13893hM83243w;
        }
        C13893h c13893hM83248w = C13887b.m83248w();
        if (c13893hM83248w != null) {
            return c13893hM83248w;
        }
        C13893h c13893hM83268w = C13888c.m83268w();
        if (c13893hM83268w != null) {
            return c13893hM83268w;
        }
        throw new NullPointerException("No platform found on Android");
    }

    /* renamed from: j */
    public static C13893h m83289j() {
        C13889d c13889dM83273u;
        if (m83293r() && (c13889dM83273u = C13889d.m83273u()) != null) {
            return c13889dM83273u;
        }
        C13891f c13891fM83278u = C13891f.m83278u();
        if (c13891fM83278u != null) {
            return c13891fM83278u;
        }
        C13893h c13893hM83276u = C13890e.m83276u();
        return c13893hM83276u != null ? c13893hM83276u : new C13893h();
    }

    /* renamed from: k */
    public static C13893h m83290k() {
        return m83292p() ? m83288i() : m83289j();
    }

    /* renamed from: l */
    public static C13893h m83291l() {
        return f62230a;
    }

    /* renamed from: p */
    public static boolean m83292p() {
        return "Dalvik".equals(System.getProperty("java.vm.name"));
    }

    /* renamed from: r */
    public static boolean m83293r() {
        if ("conscrypt".equals(C12875e.m77261r("okhttp.platform", null))) {
            return true;
        }
        return "Conscrypt".equals(Security.getProviders()[0].getName());
    }

    /* renamed from: a */
    public void mo83277a(SSLSocket sSLSocket) {
    }

    /* renamed from: c */
    public AbstractC14402c mo83251c(X509TrustManager x509TrustManager) {
        return new C14400a(mo83252d(x509TrustManager));
    }

    /* renamed from: d */
    public InterfaceC14404e mo83252d(X509TrustManager x509TrustManager) {
        return new C14401b(x509TrustManager.getAcceptedIssuers());
    }

    /* renamed from: f */
    public void mo83274f(SSLSocketFactory sSLSocketFactory) {
    }

    /* renamed from: g */
    public void mo83244g(SSLSocket sSLSocket, String str, List<EnumC11914c0> list) throws IOException {
    }

    /* renamed from: h */
    public void mo83253h(Socket socket, InetSocketAddress inetSocketAddress, int i10) throws IOException {
        socket.connect(inetSocketAddress, i10);
    }

    /* renamed from: m */
    public SSLContext mo83254m() {
        try {
            return SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e10) {
            throw new IllegalStateException("No TLS provider", e10);
        }
    }

    /* renamed from: n */
    public String mo83245n(SSLSocket sSLSocket) {
        return null;
    }

    /* renamed from: o */
    public Object mo83255o(String str) {
        if (f62231b.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    /* renamed from: q */
    public boolean mo83256q(String str) {
        return true;
    }

    /* renamed from: s */
    public void mo83257s(int i10, String str, Throwable th2) {
        f62231b.log(i10 == 5 ? Level.WARNING : Level.INFO, str, C12873c.m77226c(th2));
    }

    /* renamed from: t */
    public void mo83258t(String str, Object obj) {
        if (obj == null) {
            str = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        mo83257s(5, str, (Throwable) obj);
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}
