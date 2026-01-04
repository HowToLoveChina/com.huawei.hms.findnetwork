package com.huawei.hms.drive;

import android.annotation.SuppressLint;
import android.net.ssl.SSLSockets;
import com.android.org.conscrypt.OpenSSLSocketImpl;
import java.io.IOException;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

@SuppressLint({"NewApi"})
/* renamed from: com.huawei.hms.drive.dk */
/* loaded from: classes8.dex */
class C5262dk extends C5264dm {
    public C5262dk(Class<?> cls) {
        super(cls, null, null, null, null, null);
    }

    /* renamed from: c */
    private void m31646c(SSLSocket sSLSocket) {
        if (SSLSockets.isSupportedSocket(sSLSocket)) {
            SSLSockets.setUseSessionTickets(sSLSocket, true);
        }
    }

    @Override // com.huawei.hms.drive.C5264dm, com.huawei.hms.drive.C5269dr
    @SuppressLint({"NewApi"})
    @IgnoreJRERequirement
    /* renamed from: a */
    public void mo31648a(SSLSocket sSLSocket, String str, List<EnumC5199bd> list) throws IOException {
        try {
            m31646c(sSLSocket);
            m31645a(sSLSocket, str);
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            sSLParameters.setApplicationProtocols((String[]) C5269dr.m31688a(list).toArray(new String[0]));
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalArgumentException e10) {
            throw new IOException("Android internal error", e10);
        }
    }

    /* renamed from: a */
    private void m31645a(SSLSocket sSLSocket, String str) {
        try {
            if (sSLSocket instanceof OpenSSLSocketImpl) {
                ((OpenSSLSocketImpl) sSLSocket).setHostname(str);
            }
        } catch (Throwable unused) {
            C5269dr.m31692e().mo31656a(5, "Android10Platform sethostname error", (Throwable) null);
        }
    }

    @Override // com.huawei.hms.drive.C5264dm, com.huawei.hms.drive.C5269dr
    @IgnoreJRERequirement
    /* renamed from: a */
    public String mo31647a(SSLSocket sSLSocket) {
        String applicationProtocol = sSLSocket.getApplicationProtocol();
        if (applicationProtocol == null || applicationProtocol.isEmpty()) {
            return null;
        }
        return applicationProtocol;
    }

    /* renamed from: a */
    public static C5269dr m31644a() {
        if (!C5269dr.m31694g()) {
            return null;
        }
        try {
            if (C5264dm.m31670d() >= 29) {
                return new C5262dk(Class.forName("com.android.org.conscrypt.SSLParametersImpl"));
            }
        } catch (ReflectiveOperationException unused) {
        }
        return null;
    }
}
