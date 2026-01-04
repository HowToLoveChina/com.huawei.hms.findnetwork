package p238dv;

import android.annotation.SuppressLint;
import android.security.keystore.KeyGenParameterSpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.ProviderException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.ECGenParameterSpec;
import p267ev.EnumC9566e;
import p298fv.C9774a;
import p374iv.C10624c;
import p374iv.C10626e;

/* renamed from: dv.b */
/* loaded from: classes9.dex */
public class C9312b extends AbstractC9314d {

    /* renamed from: c */
    public static final AlgorithmParameterSpec f46674c = new ECGenParameterSpec("secp256r1");

    public C9312b(EnumC9315e enumC9315e) {
        super(enumC9315e);
    }

    @Override // p238dv.AbstractC9314d
    @SuppressLint({"WrongConstant"})
    /* renamed from: c */
    public void mo58622c(C9313c c9313c) throws C10624c, NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EC", m58638f().m58644e());
            keyPairGenerator.initialize(new KeyGenParameterSpec.Builder(c9313c.m58626a(), c9313c.m58628c().m58646e()).setAttestationChallenge(c9313c.m58629d() ? m58638f().m58643b().getBytes(StandardCharsets.UTF_8) : null).setDigests("SHA-256", "SHA-384", "SHA-512").setAlgorithmParameterSpec(f46674c).setKeySize(c9313c.m58627b()).build());
            if (keyPairGenerator.generateKeyPair() != null) {
            } else {
                throw new C10624c("generate ec key pair failed with bad key");
            }
        } catch (InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchProviderException | ProviderException e10) {
            throw new C10624c("generate ec key pair failed, " + e10.getMessage());
        }
    }

    @Override // p238dv.AbstractC9314d
    /* renamed from: j */
    public void mo58623j(C9313c c9313c) throws C10624c {
        m58642l(new C9774a.b(m58638f()).m59683c(EnumC9566e.ECDSA).m84251b(c9313c.m58626a()).mo7646a());
    }

    @Override // p238dv.AbstractC9314d
    /* renamed from: k */
    public void mo58624k(C9313c c9313c) throws C10626e {
        if (c9313c.m58627b() != 256) {
            throw new C10626e("bad ec key len, only ec prime 256 is supported");
        }
        if (c9313c.m58628c() != EnumC9316f.PURPOSE_SIGN) {
            throw new C10626e("bad purpose for ec key, only sign is supported");
        }
    }
}
