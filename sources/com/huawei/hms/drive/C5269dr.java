package com.huawei.hms.drive;

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
import p022ay.C1054d;

/* renamed from: com.huawei.hms.drive.dr */
/* loaded from: classes8.dex */
public class C5269dr {

    /* renamed from: a */
    private static final C5269dr f24491a = m31687a();

    /* renamed from: b */
    private static final Logger f24492b = Logger.getLogger(C5198bc.class.getName());

    /* renamed from: c */
    private static C5269dr m31690c() {
        C5265dn c5265dnM31674a;
        if (m31693f() && (c5265dnM31674a = C5265dn.m31674a()) != null) {
            return c5265dnM31674a;
        }
        C5267dp c5267dpM31679a = C5267dp.m31679a();
        if (c5267dpM31679a != null) {
            return c5267dpM31679a;
        }
        C5269dr c5269drM31677a = C5266do.m31677a();
        return c5269drM31677a != null ? c5269drM31677a : new C5269dr();
    }

    /* renamed from: d */
    private static C5269dr m31691d() {
        C5269dr c5269drM31644a = C5262dk.m31644a();
        if (c5269drM31644a != null) {
            return c5269drM31644a;
        }
        C5269dr c5269drM31649a = C5263dl.m31649a();
        if (c5269drM31649a != null) {
            return c5269drM31649a;
        }
        C5269dr c5269drM31669c = C5264dm.m31669c();
        if (c5269drM31669c != null) {
            return c5269drM31669c;
        }
        throw new NullPointerException("No platform found on Android");
    }

    /* renamed from: e */
    public static C5269dr m31692e() {
        return f24491a;
    }

    /* renamed from: f */
    public static boolean m31693f() {
        if ("conscrypt".equals(C5210bo.m31180a("okhttp.platform", (String) null))) {
            return true;
        }
        return "Conscrypt".equals(Security.getProviders()[0].getName());
    }

    /* renamed from: g */
    public static boolean m31694g() {
        return "Dalvik".equals(System.getProperty("java.vm.name"));
    }

    /* renamed from: a */
    public String mo31647a(SSLSocket sSLSocket) {
        return null;
    }

    /* renamed from: b */
    public void mo31678b(SSLSocket sSLSocket) {
    }

    public String toString() {
        return getClass().getSimpleName();
    }

    /* renamed from: a */
    public void mo31648a(SSLSocket sSLSocket, String str, List<EnumC5199bd> list) throws IOException {
    }

    /* renamed from: b */
    public boolean mo31661b(String str) {
        return true;
    }

    /* renamed from: b */
    public static byte[] m31689b(List<EnumC5199bd> list) {
        C1054d c1054d = new C1054d();
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            EnumC5199bd enumC5199bd = list.get(i10);
            if (enumC5199bd != EnumC5199bd.HTTP_1_0) {
                c1054d.writeByte(enumC5199bd.toString().length());
                c1054d.mo6329R(enumC5199bd.toString());
            }
        }
        return c1054d.m6311A();
    }

    /* renamed from: a */
    public void mo31676a(SSLSocketFactory sSLSocketFactory) {
    }

    /* renamed from: a */
    public void mo31658a(Socket socket, InetSocketAddress inetSocketAddress, int i10) throws IOException {
        socket.connect(inetSocketAddress, i10);
    }

    /* renamed from: a */
    public void mo31656a(int i10, String str, Throwable th2) {
        f24492b.log(i10 == 5 ? Level.WARNING : Level.INFO, str, C5209bn.m31168a(th2));
    }

    /* renamed from: a */
    public Object mo31655a(String str) {
        if (f24492b.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    /* renamed from: a */
    public void mo31657a(String str, Object obj) {
        if (obj == null) {
            str = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        mo31656a(5, str, (Throwable) obj);
    }

    /* renamed from: b */
    public SSLContext mo31660b() {
        try {
            return SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e10) {
            throw new IllegalStateException("No TLS provider", e10);
        }
    }

    /* renamed from: a */
    public static List<String> m31688a(List<EnumC5199bd> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            EnumC5199bd enumC5199bd = list.get(i10);
            if (enumC5199bd != EnumC5199bd.HTTP_1_0) {
                arrayList.add(enumC5199bd.toString());
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    public InterfaceC5276dy mo31659b(X509TrustManager x509TrustManager) {
        return new C5273dv(x509TrustManager.getAcceptedIssuers());
    }

    /* renamed from: a */
    public AbstractC5274dw mo31654a(X509TrustManager x509TrustManager) {
        return new C5272du(mo31659b(x509TrustManager));
    }

    /* renamed from: a */
    private static C5269dr m31687a() {
        if (m31694g()) {
            return m31691d();
        }
        return m31690c();
    }
}
