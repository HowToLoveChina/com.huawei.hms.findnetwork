package p239dw;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.wisesecurity.ucs.credential.Credential;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import p857zv.C14389c;

/* renamed from: dw.u */
/* loaded from: classes9.dex */
public abstract class AbstractC9353u {
    /* renamed from: a */
    public static byte[] m58709a(Credential credential) throws C14389c {
        String kekString = credential.getKekString();
        Map<String, byte[]> map = C9335i0.f46737a;
        if (TextUtils.isEmpty(kekString)) {
            throw C9344n.m58700a("KekStore", "getKek param is null.", new Object[0], 1001L, "getKek param is null.");
        }
        if (((ConcurrentHashMap) C9335i0.f46737a).containsKey(kekString)) {
            return (byte[]) ((ConcurrentHashMap) C9335i0.f46737a).get(kekString);
        }
        throw new C14389c(2001L, "kek is empty");
    }

    /* renamed from: c */
    public static AbstractC9353u m58710c(Credential credential) throws C14389c {
        int kekVersion = credential.getKekVersion();
        return kekVersion == 3 ? new C9318a() : (kekVersion == 6 || kekVersion == 7) ? new C9343m0() : new C9336j();
    }

    /* renamed from: b */
    public abstract byte[] mo58648b(Credential credential, Context context) throws C14389c;

    /* renamed from: d */
    public void m58711d(Credential credential, Context context) throws C14389c {
        String kekString = credential.getKekString();
        if (((ConcurrentHashMap) C9335i0.f46737a).containsKey(kekString)) {
            return;
        }
        byte[] bArrMo58648b = mo58648b(credential, context);
        if (TextUtils.isEmpty(kekString) || bArrMo58648b == null) {
            throw C9344n.m58700a("KekStore", "putKek param is null.", new Object[0], 1001L, "putKek param is null.");
        }
        ((ConcurrentHashMap) C9335i0.f46737a).put(kekString, bArrMo58648b);
    }
}
