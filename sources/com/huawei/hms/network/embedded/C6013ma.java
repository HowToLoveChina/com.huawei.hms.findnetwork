package com.huawei.hms.network.embedded;

import com.huawei.openalliance.p169ad.constant.ParamConstants;
import java.io.IOException;
import java.lang.reflect.Field;
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

/* renamed from: com.huawei.hms.network.embedded.ma */
/* loaded from: classes8.dex */
public class C6013ma {

    /* renamed from: b */
    public static final int f27528b = 4;

    /* renamed from: c */
    public static final int f27529c = 5;

    /* renamed from: a */
    public static final C6013ma f27527a = m34862e();

    /* renamed from: d */
    public static final Logger f27530d = Logger.getLogger(C6062q7.class.getName());

    /* renamed from: c */
    public static C6013ma m34860c() {
        C6013ma c6013maM34270i = C5922fa.m34270i();
        if (c6013maM34270i != null) {
            return c6013maM34270i;
        }
        C6013ma c6013maM34326i = C5935ga.m34326i();
        if (c6013maM34326i != null) {
            return c6013maM34326i;
        }
        C6013ma c6013maM34369i = C5948ha.m34369i();
        if (c6013maM34369i != null) {
            return c6013maM34369i;
        }
        throw new NullPointerException("No platform found on Android");
    }

    /* renamed from: d */
    public static C6013ma m34861d() {
        C5961ia c5961iaM34421i;
        if (m34865h() && (c5961iaM34421i = C5961ia.m34421i()) != null) {
            return c5961iaM34421i;
        }
        C5987ka c5987kaM34630i = C5987ka.m34630i();
        if (c5987kaM34630i != null) {
            return c5987kaM34630i;
        }
        C6013ma c6013maM34550i = C5974ja.m34550i();
        return c6013maM34550i != null ? c6013maM34550i : new C6013ma();
    }

    /* renamed from: e */
    public static C6013ma m34862e() {
        return m34864g() ? m34860c() : m34861d();
    }

    /* renamed from: f */
    public static C6013ma m34863f() {
        return f27527a;
    }

    /* renamed from: g */
    public static boolean m34864g() {
        return "Dalvik".equals(System.getProperty("java.vm.name"));
    }

    /* renamed from: h */
    public static boolean m34865h() {
        if ("conscrypt".equals(C5920f8.m34235a("okhttp.platform", (String) null))) {
            return true;
        }
        return "Conscrypt".equals(Security.getProviders()[0].getName());
    }

    /* renamed from: a */
    public AbstractC6065qa m34866a(SSLSocketFactory sSLSocketFactory) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        X509TrustManager x509TrustManagerMo34337c = mo34337c(sSLSocketFactory);
        if (x509TrustManagerMo34337c != null) {
            return mo34329a(x509TrustManagerMo34337c);
        }
        throw new IllegalStateException("Unable to extract the trust manager on " + m34863f() + ", sslSocketFactory is " + sSLSocketFactory.getClass());
    }

    /* renamed from: b */
    public InterfaceC6104ta mo34334b(X509TrustManager x509TrustManager) {
        return new C6052pa(x509TrustManager.getAcceptedIssuers());
    }

    public String toString() {
        return getClass().getSimpleName();
    }

    /* renamed from: a */
    public AbstractC6065qa mo34329a(X509TrustManager x509TrustManager) {
        return new C6039oa(mo34334b(x509TrustManager));
    }

    /* renamed from: b */
    public String mo34272b(SSLSocket sSLSocket) {
        return null;
    }

    /* renamed from: c */
    public X509TrustManager mo34337c(SSLSocketFactory sSLSocketFactory) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        try {
            Object objM34857a = m34857a(sSLSocketFactory, Class.forName("sun.security.ssl.SSLContextImpl"), ParamConstants.Param.CONTEXT);
            if (objM34857a == null) {
                return null;
            }
            return (X509TrustManager) m34857a(objM34857a, X509TrustManager.class, "trustManager");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static <T> T m34857a(Object obj, Class<T> cls, String str) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        Object objM34857a;
        for (Class<?> superclass = obj.getClass(); superclass != Object.class; superclass = superclass.getSuperclass()) {
            try {
                Field declaredField = superclass.getDeclaredField(str);
                declaredField.setAccessible(true);
                Object obj2 = declaredField.get(obj);
                if (cls.isInstance(obj2)) {
                    return cls.cast(obj2);
                }
                return null;
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            } catch (NoSuchFieldException unused2) {
            }
        }
        if (str.equals("delegate") || (objM34857a = m34857a(obj, (Class<Object>) Object.class, "delegate")) == null) {
            return null;
        }
        return (T) m34857a(objM34857a, cls, str);
    }

    /* renamed from: b */
    public SSLContext mo34335b() {
        try {
            return SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e10) {
            throw new IllegalStateException("No TLS provider", e10);
        }
    }

    /* renamed from: a */
    public Object mo34330a(String str) {
        if (f27530d.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    /* renamed from: b */
    public void mo34423b(SSLSocketFactory sSLSocketFactory) {
    }

    /* renamed from: a */
    public String m34867a() {
        return "OkHttp";
    }

    /* renamed from: b */
    public boolean mo34336b(String str) {
        return true;
    }

    /* renamed from: a */
    public static List<String> m34858a(List<EnumC6075r7> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            EnumC6075r7 enumC6075r7 = list.get(i10);
            if (enumC6075r7 != EnumC6075r7.HTTP_1_0) {
                arrayList.add(enumC6075r7.toString());
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    public static byte[] m34859b(List<EnumC6075r7> list) {
        C5868bb c5868bb = new C5868bb();
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            EnumC6075r7 enumC6075r7 = list.get(i10);
            if (enumC6075r7 != EnumC6075r7.HTTP_1_0) {
                c5868bb.writeByte(enumC6075r7.toString().length());
                c5868bb.mo33934a(enumC6075r7.toString());
            }
        }
        return c5868bb.mo33981q();
    }

    /* renamed from: a */
    public void mo34331a(int i10, String str, Throwable th2) {
        f27530d.log(i10 == 5 ? Level.WARNING : Level.INFO, str, C5907e8.m34132a(th2));
    }

    /* renamed from: a */
    public void mo34332a(String str, Object obj) {
        if (obj == null) {
            str = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        mo34331a(5, str, (Throwable) obj);
    }

    /* renamed from: a */
    public void mo34333a(Socket socket, InetSocketAddress inetSocketAddress, int i10) throws IOException {
        socket.connect(inetSocketAddress, i10);
    }

    /* renamed from: a */
    public void mo34551a(SSLSocket sSLSocket) {
    }

    /* renamed from: a */
    public void mo34271a(SSLSocket sSLSocket, String str, List<EnumC6075r7> list) throws IOException {
    }
}
