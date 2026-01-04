package com.huawei.hms.network.embedded;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* renamed from: com.huawei.hms.network.embedded.ka */
/* loaded from: classes8.dex */
public final class C5987ka extends C6013ma {

    /* renamed from: e */
    public final Method f27322e;

    /* renamed from: f */
    public final Method f27323f;

    public C5987ka(Method method, Method method2) {
        this.f27322e = method;
        this.f27323f = method2;
    }

    /* renamed from: i */
    public static C5987ka m34630i() {
        try {
            return new C5987ka(SSLParameters.class.getMethod("setApplicationProtocols", String[].class), SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    @Override // com.huawei.hms.network.embedded.C6013ma
    /* renamed from: a */
    public void mo34271a(SSLSocket sSLSocket, String str, List<EnumC6075r7> list) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            List<String> listM34858a = C6013ma.m34858a(list);
            this.f27322e.invoke(sSLParameters, listM34858a.toArray(new String[listM34858a.size()]));
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalAccessException | InvocationTargetException e10) {
            throw new AssertionError("failed to set SSL parameters", e10);
        }
    }

    @Override // com.huawei.hms.network.embedded.C6013ma
    /* renamed from: b */
    public String mo34272b(SSLSocket sSLSocket) {
        try {
            String str = (String) this.f27323f.invoke(sSLSocket, new Object[0]);
            if (str != null) {
                if (!str.equals("")) {
                    return str;
                }
            }
            return null;
        } catch (IllegalAccessException e10) {
            throw new AssertionError("failed to get ALPN selected protocol", e10);
        } catch (InvocationTargetException e11) {
            if (e11.getCause() instanceof UnsupportedOperationException) {
                return null;
            }
            throw new AssertionError("failed to get ALPN selected protocol", e11);
        }
    }

    @Override // com.huawei.hms.network.embedded.C6013ma
    /* renamed from: c */
    public X509TrustManager mo34337c(SSLSocketFactory sSLSocketFactory) {
        throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported on JDK 9+");
    }
}
