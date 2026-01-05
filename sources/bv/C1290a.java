package bv;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import p238dv.enumKeyStore;
import p374iv.Exception_C10623b;
import p822yu.AbstractC14045a;
import p856zu.C14381b;
import p856zu.C14383d;
import p856zu.EnDecryptAlgorithm;
import p856zu.enumEncryptAlgorithm;
import p856zu.InterfaceC14382c;
import p856zu.interfaceEnDecryptKey;
import p856zu.interfaceEnDecrypt;

/* renamed from: bv.a */
/* loaded from: classes9.dex */
public class C1290a implements interfaceEnDecrypt {

    /* renamed from: a */
    public final enumEncryptAlgorithm f5758a;

    /* renamed from: b */
    public final enumKeyStore f5759b;

    /* renamed from: c */
    public final PrivateKey f5760c;

    /* renamed from: d */
    public final PublicKey f5761d;

    /* renamed from: e */
    public final AlgorithmParameterSpec f5762e;

    /* renamed from: bv.a$b */
    public static class b extends AbstractC14045a<C1290a> {

        /* renamed from: e */
        public enumEncryptAlgorithm f5763e;

        /* renamed from: f */
        public final AlgorithmParameterSpec f5764f;

        public b(enumKeyStore enumKeyStore) {
            super(enumKeyStore);
            this.f5763e = enumEncryptAlgorithm.getAlgorithm("RSA");
            this.f5764f = new OAEPParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA1, PSource.PSpecified.DEFAULT);
        }

        @Override // p822yu.AbstractC14045a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public C1290a mo7646a() throws Exception_C10623b {
            return new C1290a(this.f62833d, this.f5763e, this.f62830a, this.f62831b, this.f5764f);
        }

        /* renamed from: d */
        public b m7648d(enumEncryptAlgorithm enumEncryptAlgorithm) {
            this.f5763e = enumEncryptAlgorithm;
            return this;
        }
    }

    @Override // p856zu.interfaceEnDecrypt
    public InterfaceC14382c getDecryptHandler() throws Exception_C10623b {
        C14381b c14381b = new C14381b();
        c14381b.setAlgorithm(this.f5758a);
        PrivateKey privateKey = this.f5760c;
        if (privateKey != null) {
            return new C14383d(this.f5759b, privateKey, c14381b, this.f5762e);
        }
        throw new Exception_C10623b("privateKey is invalid.");
    }

    @Override // p856zu.interfaceEnDecrypt
    public interfaceEnDecryptKey getEncryptHandler() throws Exception_C10623b {
        C14381b c14381b = new C14381b();
        c14381b.setAlgorithm(this.f5758a);
        PublicKey publicKey = this.f5761d;
        if (publicKey != null) {
            return new EnDecryptAlgorithm(this.f5759b, publicKey, c14381b, this.f5762e);
        }
        throw new Exception_C10623b("publicKey is invalid.");
    }

    public C1290a(enumKeyStore enumKeyStore, enumEncryptAlgorithm enumEncryptAlgorithm, PrivateKey privateKey, PublicKey publicKey, AlgorithmParameterSpec algorithmParameterSpec) {
        this.f5759b = enumKeyStore;
        this.f5758a = enumEncryptAlgorithm;
        this.f5760c = privateKey;
        this.f5761d = publicKey;
        this.f5762e = algorithmParameterSpec;
    }
}
