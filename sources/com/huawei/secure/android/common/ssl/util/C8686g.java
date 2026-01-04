package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import p435ku.AbstractC11159e;
import p435ku.C11160f;

/* renamed from: com.huawei.secure.android.common.ssl.util.g */
/* loaded from: classes5.dex */
public class C8686g {

    /* renamed from: a */
    public Context f40671a;

    public C8686g(Context context) {
        this.f40671a = context;
    }

    /* renamed from: a */
    public X509Certificate m53589a() {
        return m53590b("hmsincas.bks", "huawei cbg application integration ca");
    }

    /* renamed from: b */
    public X509Certificate m53590b(String str, String str2) throws Throwable {
        InputStream inputStreamOpen;
        KeyStore keyStore;
        InputStream inputStream = null;
        X509Certificate x509Certificate = null;
        try {
            keyStore = KeyStore.getInstance("bks");
            inputStreamOpen = this.f40671a.getAssets().open(str);
        } catch (IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException e10) {
            e = e10;
            inputStreamOpen = null;
        } catch (Throwable th2) {
            th = th2;
            AbstractC11159e.m67091b(inputStream);
            throw th;
        }
        try {
            try {
                inputStreamOpen.reset();
                keyStore.load(inputStreamOpen, "".toCharArray());
                x509Certificate = (X509Certificate) keyStore.getCertificate(str2);
            } catch (Throwable th3) {
                th = th3;
                inputStream = inputStreamOpen;
                AbstractC11159e.m67091b(inputStream);
                throw th;
            }
        } catch (IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException e11) {
            e = e11;
            C11160f.m67095d("X509CertificateUtil", "loadBksCA: exception : " + e.getMessage());
            AbstractC11159e.m67091b(inputStreamOpen);
            return x509Certificate;
        }
        AbstractC11159e.m67091b(inputStreamOpen);
        return x509Certificate;
    }

    /* renamed from: c */
    public X509Certificate m53591c() {
        return m53590b("hmsrootcas.bks", "052root");
    }
}
