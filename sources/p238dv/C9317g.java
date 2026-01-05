package p238dv;

import android.annotation.SuppressLint;
import android.security.keystore.KeyGenParameterSpec;
import bv.C1290a;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import p267ev.EnumC9566e;
import p347hv.C10345a;
import p374iv.Exception_C10624c;
import p374iv.C10626e;
import p856zu.enumEncryptAlgorithm;

/* renamed from: dv.g */
/* loaded from: classes9.dex */
public class C9317g extends AbstractC9314d {
    @Override // p238dv.AbstractC9314d
    @SuppressLint({"WrongConstant"})
    /* renamed from: c */
    public void mo58622c(C9313c c9313c) throws Exception_C10624c, NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", m58638f().m58644e());
            keyPairGenerator.initialize(new KeyGenParameterSpec.Builder(c9313c.m58626a(), c9313c.m58628c().m58646e()).setAttestationChallenge(m58638f().m58643b().getBytes(StandardCharsets.UTF_8)).setSignaturePaddings("PKCS1", "PSS").setEncryptionPaddings("PKCS1Padding", "OAEPPadding").setDigests("SHA-256", "SHA-384", "SHA-512").setKeySize(c9313c.m58627b()).build());
            if (keyPairGenerator.generateKeyPair() != null) {
            } else {
                throw new Exception_C10624c("generate rsa key pair failed with bad key");
            }
        } catch (InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchProviderException e10) {
            throw new Exception_C10624c("generate rsa key pair failed, " + e10.getMessage());
        }
    }

    @Override // p238dv.AbstractC9314d
    /* renamed from: j */
    public void mo58623j(C9313c c9313c) throws Exception_C10624c {
        if (EnumC9316f.m58645b(c9313c.m58628c(), EnumC9316f.PURPOSE_CRYPTO)) {
            m58641i(new C1290a.b(m58638f()).m7648d(enumEncryptAlgorithm.RSA_OAEP).m84251b(c9313c.m58626a()).mo7646a());
        }
        if (EnumC9316f.m58645b(c9313c.m58628c(), EnumC9316f.PURPOSE_SIGN)) {
            m58642l(new C10345a.b(m58638f()).m59683c(EnumC9566e.RSA_SHA256).m84251b(c9313c.m58626a()).mo7646a());
        }
    }

    @Override // p238dv.AbstractC9314d
    /* renamed from: k */
    public void mo58624k(C9313c c9313c) throws C10626e {
        if (m58647m(c9313c.m58627b())) {
            throw new C10626e("bad rsa key len");
        }
    }

    /* renamed from: m */
    public final boolean m58647m(int i10) {
        return (i10 == 2048 || i10 == 3072 || i10 == 4096) ? false : true;
    }
}
