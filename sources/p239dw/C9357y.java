package p239dw;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.wisesecurity.ucs.credential.entity.EcKeyPair;
import com.huawei.wisesecurity.ucs.credential.nativelib.UcsLib;
import cw.C8957b;
import cw.C8958c;
import java.security.KeyStoreException;
import mv.C11532e;
import p238dv.C9311a;
import p856zu.enumEncryptAlgorithm;
import p857zv.Exception_C14389c;

/* renamed from: dw.y */
/* loaded from: classes9.dex */
public class C9357y {
    /* renamed from: a */
    public static EcKeyPair m58721a(Context context) throws Exception_C14389c, KeyStoreException {
        try {
            return m58723c(context);
        } catch (Exception_C14389c unused) {
            EcKeyPair ecKeyPairGenerateEcKeyPair = UcsLib.generateEcKeyPair(context);
            if (ecKeyPairGenerateEcKeyPair == null) {
                throw new Exception_C14389c(1022L, "key is null");
            }
            if (C9354v.f46761d == null) {
                C9354v.f46761d = new C9311a();
            }
            C9354v c9354v = (C9354v) C9354v.f46759b;
            c9354v.m58712a("ucs_aes_alias_rootKey");
            byte[] bArrM68822b = C11532e.m68822b(enumEncryptAlgorithm.AES_GCM.getAlgorithmSeed());
            c9354v.f46762a = bArrM68822b;
            C8957b.m56708g("ucs_ec_credential_enc_sp_key", C8958c.m56711c(bArrM68822b, 2) + ":" + C8958c.m56711c(c9354v.m58714c("ucs_aes_alias_rootKey", ecKeyPairGenerateEcKeyPair.getPublicKey()), 10) + ":" + C8958c.m56711c(c9354v.m58714c("ucs_aes_alias_rootKey", ecKeyPairGenerateEcKeyPair.getPrivateKey()), 10), context);
            return ecKeyPairGenerateEcKeyPair;
        }
    }

    /* renamed from: b */
    public static void m58722b(EcKeyPair ecKeyPair) {
        byte[] privateKey = ecKeyPair.getPrivateKey();
        if (privateKey == null) {
            return;
        }
        int length = privateKey.length;
        for (int i10 = 0; i10 < length; i10++) {
            privateKey[i10] = 0;
        }
    }

    /* renamed from: c */
    public static EcKeyPair m58723c(Context context) throws Exception_C14389c {
        EcKeyPair.Builder builderNewBuilder = EcKeyPair.newBuilder();
        String strM56705d = C8957b.m56705d("ucs_ec_credential_enc_sp_key", "", context);
        if (TextUtils.isEmpty(strM56705d)) {
            throw new Exception_C14389c(1022L, "no cache key");
        }
        String[] strArrSplit = strM56705d.split(":");
        if (strArrSplit.length != 3) {
            throw new Exception_C14389c(1022L, "invalid cache key");
        }
        if (C9354v.f46761d == null) {
            C9354v.f46761d = new C9311a();
        }
        C9354v c9354v = (C9354v) C9354v.f46759b;
        c9354v.m58712a("ucs_aes_alias_rootKey");
        c9354v.f46762a = C8958c.m56709a(strArrSplit[0], 2);
        byte[] bArrM58713b = c9354v.m58713b("ucs_aes_alias_rootKey", C8958c.m56709a(strArrSplit[1], 10));
        byte[] bArrM58713b2 = c9354v.m58713b("ucs_aes_alias_rootKey", C8958c.m56709a(strArrSplit[2], 10));
        builderNewBuilder.publicKey(bArrM58713b);
        builderNewBuilder.privateKey(bArrM58713b2);
        return builderNewBuilder.build();
    }
}
