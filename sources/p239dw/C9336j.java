package p239dw;

import android.content.Context;
import com.huawei.wisesecurity.ucs.credential.Credential;
import com.huawei.wisesecurity.ucs.credential.nativelib.UcsLib;
import p857zv.Exception_C14389c;

/* renamed from: dw.j */
/* loaded from: classes9.dex */
public class C9336j extends KekStore {
    @Override // p239dw.KekStore
    /* renamed from: b */
    public byte[] doDecrypt(Credential credential, Context context) throws Exception_C14389c {
        return UcsLib.decryptKek(credential.getKekBytes(), credential.getAlg());
    }
}
