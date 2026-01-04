package p238dv;

import android.annotation.SuppressLint;
import android.security.keystore.KeyGenParameterSpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import javax.crypto.KeyGenerator;
import mv.C11532e;
import p021av.C1027a;
import p374iv.C10624c;
import p374iv.C10626e;
import p856zu.EnumC14380a;

/* renamed from: dv.a */
/* loaded from: classes9.dex */
public class C9311a extends AbstractC9314d {
    @Override // p238dv.AbstractC9314d
    @SuppressLint({"WrongConstant"})
    /* renamed from: c */
    public void mo58622c(C9313c c9313c) throws C10624c, NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", m58638f().m58644e());
            keyGenerator.init(new KeyGenParameterSpec.Builder(c9313c.m58626a(), c9313c.m58628c().m58646e()).setKeySize(c9313c.m58627b()).setAttestationChallenge(m58638f().m58643b().getBytes(StandardCharsets.UTF_8)).setRandomizedEncryptionRequired(false).setBlockModes("GCM", "CBC").setEncryptionPaddings("NoPadding", "PKCS7Padding").build());
            if (keyGenerator.generateKey() != null) {
            } else {
                throw new C10624c("generate aes key failed with bad key");
            }
        } catch (InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchProviderException e10) {
            throw new C10624c("generate aes key failed, " + e10.getMessage());
        }
    }

    @Override // p238dv.AbstractC9314d
    /* renamed from: j */
    public void mo58623j(C9313c c9313c) throws C10624c {
        EnumC14380a enumC14380a = EnumC14380a.AES_GCM;
        m58641i(new C1027a.b(m58638f()).m6222b(enumC14380a).m6225e(c9313c.m58626a()).m6223c(C11532e.m68822b(enumC14380a.m85606b())).m6221a());
    }

    @Override // p238dv.AbstractC9314d
    /* renamed from: k */
    public void mo58624k(C9313c c9313c) throws C10626e {
        if (m58625m(c9313c.m58627b())) {
            throw new C10626e("bad aes key len");
        }
        if (c9313c.m58628c() != EnumC9316f.PURPOSE_CRYPTO) {
            throw new C10626e("bad purpose for aes key, only crypto is supported");
        }
    }

    /* renamed from: m */
    public final boolean m58625m(int i10) {
        return (i10 == 128 || i10 == 192 || i10 == 256) ? false : true;
    }
}
