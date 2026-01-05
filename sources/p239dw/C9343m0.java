package p239dw;

import android.content.Context;
import aw.C1029b;
import com.huawei.wisesecurity.ucs.credential.Credential;
import com.huawei.wisesecurity.ucs.credential.entity.EcKeyPair;
import com.huawei.wisesecurity.ucs.credential.nativelib.UcsLib;
import cw.C8957b;
import cw.C8958c;
import p857zv.Exception_C14389c;

/* renamed from: dw.m0 */
/* loaded from: classes9.dex */
public class KeyStoreECIESParseHandler extends KekStore {
    @Override // p239dw.KekStore
    /* renamed from: b */
    public byte[] doDecrypt(Credential credential, Context context) throws Exception_C14389c {
        try {
            String[] strArrSplit = credential.getKekString().split(":");
            if (strArrSplit.length < 3) {
                C1029b.m6231b("KeyStoreECIESParseHandler", "EC kek doDecrypt failure. kek string invalid", new Object[0]);
                throw new Exception_C14389c(1020L, "EC kek doDecrypt failure. kek string invalid");
            }
            byte[] bArrM56709a = C8958c.m56709a(strArrSplit[0], 0);
            byte[] bArrM56709a2 = C8958c.m56709a(strArrSplit[1], 0);
            byte[] bArrM56709a3 = C8958c.m56709a(strArrSplit[2], 0);
            EcKeyPair ecKeyPairM58723c = C9357y.m58723c(context);
            byte[] bArrDecryptKekWithEc = UcsLib.decryptKekWithEc(bArrM56709a3, 1, bArrM56709a, bArrM56709a2, ecKeyPairM58723c.getPrivateKey());
            if (bArrDecryptKekWithEc == null || bArrDecryptKekWithEc.length == 0) {
                C1029b.m6231b("KeyStoreECIESParseHandler", "KeyStore doDecrypt failure.", new Object[0]);
                throw new Exception_C14389c(1020L, "KeyStore doDecrypt failure.");
            }
            C9357y.m58722b(ecKeyPairM58723c);
            return bArrDecryptKekWithEc;
        } catch (Exception_C14389c e10) {
            if (credential.getKekVersion() == 6) {
                C9326e.m58663a(context);
            } else {
                C8957b.m56706e("ucs_ec_huks_sp_key_t", 0, context);
            }
            StringBuilder sbM58651a = C9320b.m58651a("decrypt kek get exception : ");
            sbM58651a.append(e10.getMessage());
            String string = sbM58651a.toString();
            throw C9344n.m58700a("KeyStoreECIESParseHandler", string, new Object[0], 1020L, string);
        }
    }
}
