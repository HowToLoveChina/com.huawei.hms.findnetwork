package com.huawei.hms.network.embedded;

import android.annotation.SuppressLint;
import android.net.ssl.SSLSockets;
import com.android.org.conscrypt.OpenSSLSocketImpl;
import java.io.IOException;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

@SuppressLint({"NewApi"})
/* renamed from: com.huawei.hms.network.embedded.fa */
/* loaded from: classes8.dex */
public class C5922fa extends C5948ha {
    public C5922fa(Class<?> cls) {
        super(cls, null, null, null, null, null);
    }

    /* renamed from: a */
    private void m34268a(SSLSocket sSLSocket, String str) {
        try {
            if (sSLSocket instanceof OpenSSLSocketImpl) {
                ((OpenSSLSocketImpl) sSLSocket).setHostname(str);
            }
        } catch (Throwable unused) {
            C6013ma.m34863f().mo34331a(5, "Android10Platform sethostname error", (Throwable) null);
        }
    }

    /* renamed from: c */
    private void m34269c(SSLSocket sSLSocket) {
        if (SSLSockets.isSupportedSocket(sSLSocket)) {
            SSLSockets.setUseSessionTickets(sSLSocket, true);
        }
    }

    /* renamed from: i */
    public static C6013ma m34270i() {
        if (!C6013ma.m34864g()) {
            return null;
        }
        try {
            if (C5948ha.m34370j() >= 29) {
                return new C5922fa(Class.forName("com.android.org.conscrypt.SSLParametersImpl"));
            }
        } catch (ReflectiveOperationException unused) {
        }
        return null;
    }

    @Override // com.huawei.hms.network.embedded.C5948ha, com.huawei.hms.network.embedded.C6013ma
    @IgnoreJRERequirement
    /* renamed from: b */
    public String mo34272b(SSLSocket sSLSocket) {
        String applicationProtocol = sSLSocket.getApplicationProtocol();
        if (applicationProtocol == null || applicationProtocol.isEmpty()) {
            return null;
        }
        return applicationProtocol;
    }

    @Override // com.huawei.hms.network.embedded.C5948ha, com.huawei.hms.network.embedded.C6013ma
    @SuppressLint({"NewApi"})
    @IgnoreJRERequirement
    /* renamed from: a */
    public void mo34271a(SSLSocket sSLSocket, String str, List<EnumC6075r7> list) throws IOException {
        try {
            m34269c(sSLSocket);
            m34268a(sSLSocket, str);
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            sSLParameters.setApplicationProtocols((String[]) C6013ma.m34858a(list).toArray(new String[0]));
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalArgumentException e10) {
            throw new IOException("Android internal error", e10);
        }
    }
}
