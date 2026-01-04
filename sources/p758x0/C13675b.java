package p758x0;

import android.security.keystore.KeyGenParameterSpec;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.Arrays;
import javax.crypto.KeyGenerator;

/* renamed from: x0.b */
/* loaded from: classes.dex */
public final class C13675b {

    /* renamed from: a */
    public static final KeyGenParameterSpec f61594a = m82271a("_androidx_security_master_key_");

    /* renamed from: a */
    public static KeyGenParameterSpec m82271a(String str) {
        return new KeyGenParameterSpec.Builder(str, 3).setBlockModes("GCM").setEncryptionPaddings("NoPadding").setKeySize(256).build();
    }

    /* renamed from: b */
    public static void m82272b(KeyGenParameterSpec keyGenParameterSpec) throws GeneralSecurityException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", "AndroidKeyStore");
        keyGenerator.init(keyGenParameterSpec);
        keyGenerator.generateKey();
    }

    /* renamed from: c */
    public static String m82273c(KeyGenParameterSpec keyGenParameterSpec) throws GeneralSecurityException, IOException {
        m82275e(keyGenParameterSpec);
        if (!m82274d(keyGenParameterSpec.getKeystoreAlias())) {
            m82272b(keyGenParameterSpec);
        }
        return keyGenParameterSpec.getKeystoreAlias();
    }

    /* renamed from: d */
    public static boolean m82274d(String str) throws GeneralSecurityException, IOException {
        KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
        keyStore.load(null);
        return keyStore.containsAlias(str);
    }

    /* renamed from: e */
    public static void m82275e(KeyGenParameterSpec keyGenParameterSpec) {
        if (keyGenParameterSpec.getKeySize() != 256) {
            throw new IllegalArgumentException("invalid key size, want 256 bits got " + keyGenParameterSpec.getKeySize() + " bits");
        }
        if (!Arrays.equals(keyGenParameterSpec.getBlockModes(), new String[]{"GCM"})) {
            throw new IllegalArgumentException("invalid block mode, want GCM got " + Arrays.toString(keyGenParameterSpec.getBlockModes()));
        }
        if (keyGenParameterSpec.getPurposes() != 3) {
            throw new IllegalArgumentException("invalid purposes mode, want PURPOSE_ENCRYPT | PURPOSE_DECRYPT got " + keyGenParameterSpec.getPurposes());
        }
        if (Arrays.equals(keyGenParameterSpec.getEncryptionPaddings(), new String[]{"NoPadding"})) {
            if (keyGenParameterSpec.isUserAuthenticationRequired() && keyGenParameterSpec.getUserAuthenticationValidityDurationSeconds() < 1) {
                throw new IllegalArgumentException("per-operation authentication is not supported (UserAuthenticationValidityDurationSeconds must be >0)");
            }
        } else {
            throw new IllegalArgumentException("invalid padding mode, want NoPadding got " + Arrays.toString(keyGenParameterSpec.getEncryptionPaddings()));
        }
    }
}
