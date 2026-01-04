package p239dw;

import android.content.Context;
import com.huawei.wisesecurity.ucs.credential.Credential;
import com.huawei.wisesecurity.ucs.credential.nativelib.UcsLib;
import p857zv.C14389c;

/* renamed from: dw.j */
/* loaded from: classes9.dex */
public class C9336j extends AbstractC9353u {
    @Override // p239dw.AbstractC9353u
    /* renamed from: b */
    public byte[] mo58648b(Credential credential, Context context) throws C14389c {
        return UcsLib.decryptKek(credential.getKekBytes(), credential.getAlg());
    }
}
