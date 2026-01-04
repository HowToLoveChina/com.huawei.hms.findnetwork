package com.huawei.hms.drive;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import org.conscrypt.Conscrypt;

/* renamed from: com.huawei.hms.drive.dn */
/* loaded from: classes8.dex */
public class C5265dn extends C5269dr {
    private C5265dn() {
    }

    /* renamed from: c */
    private Provider m31675c() {
        return Conscrypt.newProviderBuilder().provideTrustManager().build();
    }

    @Override // com.huawei.hms.drive.C5269dr
    /* renamed from: a */
    public void mo31648a(SSLSocket sSLSocket, String str, List<EnumC5199bd> list) throws IOException {
        if (!Conscrypt.isConscrypt(sSLSocket)) {
            super.mo31648a(sSLSocket, str, list);
            return;
        }
        if (str != null) {
            Conscrypt.setUseSessionTickets(sSLSocket, true);
            Conscrypt.setHostname(sSLSocket, str);
        }
        Conscrypt.setApplicationProtocols(sSLSocket, (String[]) C5269dr.m31688a(list).toArray(new String[0]));
    }

    @Override // com.huawei.hms.drive.C5269dr
    /* renamed from: b */
    public SSLContext mo31660b() {
        try {
            return SSLContext.getInstance("TLSv1.3", m31675c());
        } catch (NoSuchAlgorithmException e10) {
            try {
                return SSLContext.getInstance("TLS", this.m31675c());
            } catch (NoSuchAlgorithmException unused) {
                throw new IllegalStateException("No TLS provider", e10);
            }
        }
    }

    @Override // com.huawei.hms.drive.C5269dr
    /* renamed from: a */
    public String mo31647a(SSLSocket sSLSocket) {
        if (Conscrypt.isConscrypt(sSLSocket)) {
            return Conscrypt.getApplicationProtocol(sSLSocket);
        }
        return super.mo31647a(sSLSocket);
    }

    /* renamed from: a */
    public static C5265dn m31674a() throws ClassNotFoundException {
        try {
            Class.forName("org.conscrypt.Conscrypt");
            if (Conscrypt.isAvailable()) {
                return new C5265dn();
            }
            return null;
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    @Override // com.huawei.hms.drive.C5269dr
    /* renamed from: a */
    public void mo31676a(SSLSocketFactory sSLSocketFactory) {
        if (Conscrypt.isConscrypt(sSLSocketFactory)) {
            Conscrypt.setUseEngineSocket(sSLSocketFactory, true);
        }
    }
}
