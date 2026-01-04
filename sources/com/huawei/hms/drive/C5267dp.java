package com.huawei.hms.drive;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

/* renamed from: com.huawei.hms.drive.dp */
/* loaded from: classes8.dex */
final class C5267dp extends C5269dr {

    /* renamed from: a */
    final Method f24486a;

    /* renamed from: b */
    final Method f24487b;

    public C5267dp(Method method, Method method2) {
        this.f24486a = method;
        this.f24487b = method2;
    }

    @Override // com.huawei.hms.drive.C5269dr
    /* renamed from: a */
    public void mo31648a(SSLSocket sSLSocket, String str, List<EnumC5199bd> list) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            List<String> listM31688a = C5269dr.m31688a(list);
            this.f24486a.invoke(sSLParameters, listM31688a.toArray(new String[listM31688a.size()]));
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalAccessException | InvocationTargetException e10) {
            throw new AssertionError("failed to set SSL parameters", e10);
        }
    }

    @Override // com.huawei.hms.drive.C5269dr
    /* renamed from: a */
    public String mo31647a(SSLSocket sSLSocket) {
        try {
            String str = (String) this.f24487b.invoke(sSLSocket, new Object[0]);
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

    /* renamed from: a */
    public static C5267dp m31679a() {
        try {
            return new C5267dp(SSLParameters.class.getMethod("setApplicationProtocols", String[].class), SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }
}
