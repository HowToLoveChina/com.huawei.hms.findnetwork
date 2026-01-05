package p239dw;

import android.content.Context;
import aw.C1029b;
import com.huawei.wisesecurity.ucs.credential.Credential;
import p857zv.Exception_C14389c;

/* renamed from: dw.a */
/* loaded from: classes9.dex */
public class C9318a extends KekStore {
    @Override // p239dw.KekStore
    /* renamed from: b */
    public byte[] doDecrypt(Credential credential, Context context) throws Exception_C14389c {
        try {
            if (C9321b0.f46695a == null) {
                C9321b0.f46696b.m58652a(null);
            }
            byte[] bArrM58655c = C9321b0.f46696b.m58655c("ucs_alias_rootKey", credential.getKekBytes());
            if (bArrM58655c != null && bArrM58655c.length != 0) {
                return bArrM58655c;
            }
            C9326e.m58665c(context);
            C1029b.m6231b("KeyStoreParseHandler", "KeyStore doDecrypt failure.", new Object[0]);
            throw new Exception_C14389c(1020L, "KeyStore doDecrypt failure.");
        } catch (Throwable th2) {
            C9326e.m58665c(context);
            String str = "decrypt kek get exception : " + th2.getMessage();
            throw C9344n.m58700a("KeyStoreParseHandler", str, new Object[0], 1020L, str);
        }
    }
}
