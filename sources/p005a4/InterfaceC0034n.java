package p005a4;

import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;

/* renamed from: a4.n */
/* loaded from: classes.dex */
public interface InterfaceC0034n<T> {

    /* renamed from: a4.n$a */
    public static class a implements InterfaceC0034n<Cipher> {
        @Override // p005a4.InterfaceC0034n
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Cipher mo135a(String str, Provider provider) throws GeneralSecurityException {
            return provider == null ? Cipher.getInstance(str) : Cipher.getInstance(str, provider);
        }
    }

    /* renamed from: a4.n$b */
    public static class b implements InterfaceC0034n<KeyAgreement> {
        @Override // p005a4.InterfaceC0034n
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public KeyAgreement mo135a(String str, Provider provider) throws GeneralSecurityException {
            return provider == null ? KeyAgreement.getInstance(str) : KeyAgreement.getInstance(str, provider);
        }
    }

    /* renamed from: a4.n$c */
    public static class c implements InterfaceC0034n<KeyFactory> {
        @Override // p005a4.InterfaceC0034n
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public KeyFactory mo135a(String str, Provider provider) throws GeneralSecurityException {
            return provider == null ? KeyFactory.getInstance(str) : KeyFactory.getInstance(str, provider);
        }
    }

    /* renamed from: a4.n$d */
    public static class d implements InterfaceC0034n<KeyPairGenerator> {
        @Override // p005a4.InterfaceC0034n
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public KeyPairGenerator mo135a(String str, Provider provider) throws GeneralSecurityException {
            return provider == null ? KeyPairGenerator.getInstance(str) : KeyPairGenerator.getInstance(str, provider);
        }
    }

    /* renamed from: a4.n$e */
    public static class e implements InterfaceC0034n<Mac> {
        @Override // p005a4.InterfaceC0034n
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Mac mo135a(String str, Provider provider) throws GeneralSecurityException {
            return provider == null ? Mac.getInstance(str) : Mac.getInstance(str, provider);
        }
    }

    /* renamed from: a4.n$f */
    public static class f implements InterfaceC0034n<MessageDigest> {
        @Override // p005a4.InterfaceC0034n
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public MessageDigest mo135a(String str, Provider provider) throws GeneralSecurityException {
            return provider == null ? MessageDigest.getInstance(str) : MessageDigest.getInstance(str, provider);
        }
    }

    /* renamed from: a4.n$g */
    public static class g implements InterfaceC0034n<Signature> {
        @Override // p005a4.InterfaceC0034n
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Signature mo135a(String str, Provider provider) throws GeneralSecurityException {
            return provider == null ? Signature.getInstance(str) : Signature.getInstance(str, provider);
        }
    }

    /* renamed from: a */
    T mo135a(String str, Provider provider) throws GeneralSecurityException;
}
