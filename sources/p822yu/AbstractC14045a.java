package p822yu;

import java.io.IOException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.spec.AlgorithmParameterSpec;
import p238dv.enumKeyStore;
import p374iv.Exception_C10623b;
import p374iv.Exception_C10624c;

/* renamed from: yu.a */
/* loaded from: classes9.dex */
public abstract class AbstractC14045a<T> {

    /* renamed from: a */
    public PrivateKey f62830a;

    /* renamed from: b */
    public PublicKey f62831b;

    /* renamed from: c */
    public AlgorithmParameterSpec f62832c;

    /* renamed from: d */
    public final enumKeyStore f62833d;

    public AbstractC14045a(enumKeyStore enumKeyStore) {
        this.f62833d = enumKeyStore;
    }

    /* renamed from: a */
    public abstract T mo7646a() throws Exception_C10623b;

    /* renamed from: b */
    public AbstractC14045a<T> m84251b(String str) throws Exception_C10624c, NoSuchAlgorithmException, UnrecoverableKeyException, IOException, KeyStoreException, CertificateException {
        try {
            KeyStore keyStore = KeyStore.getInstance(this.f62833d.m58643b());
            keyStore.load(null);
            Key key = keyStore.getKey(str, null);
            if (!(key instanceof PrivateKey)) {
                throw new Exception_C10624c("bad private key type");
            }
            this.f62830a = (PrivateKey) key;
            this.f62831b = keyStore.getCertificate(str).getPublicKey();
            return this;
        } catch (IOException | KeyStoreException | NoSuchAlgorithmException | UnrecoverableKeyException | CertificateException e10) {
            throw new Exception_C10624c("keystore get key with alias failed, " + e10.getMessage());
        }
    }
}
