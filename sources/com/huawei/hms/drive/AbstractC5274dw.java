package com.huawei.hms.drive;

import java.security.cert.Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;

/* renamed from: com.huawei.hms.drive.dw */
/* loaded from: classes8.dex */
public abstract class AbstractC5274dw {
    /* renamed from: a */
    public static AbstractC5274dw m31702a(X509TrustManager x509TrustManager) {
        return C5269dr.m31692e().mo31654a(x509TrustManager);
    }

    /* renamed from: a */
    public abstract List<Certificate> mo31662a(List<Certificate> list, String str) throws SSLPeerUnverifiedException;
}
