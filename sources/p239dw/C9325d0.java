package p239dw;

import android.content.Context;
import bw.AbstractC1291a;
import bw.EnumC1292b;
import com.huawei.wisesecurity.ucs.credential.outer.HACapability;
import p407jv.C10933b;
import p436kv.interfaceLinkHashMap;

/* renamed from: dw.d0 */
/* loaded from: classes9.dex */
public class C9325d0 extends AbstractC1291a implements HACapability {

    /* renamed from: c */
    public static C10933b f46701c;

    public C9325d0(InterfaceC9323c0 interfaceC9323c0, EnumC1292b enumC1292b) {
        super(interfaceC9323c0.mo58660b(), enumC1292b);
    }

    @Override // com.huawei.wisesecurity.ucs.credential.outer.HACapability
    public void onEvent(Context context, String str, interfaceLinkHashMap interfaceLinkHashMap) {
        synchronized (C9325d0.class) {
            try {
                if (f46701c == null) {
                    f46701c = m7649a(context, HACapability.UCS_CREDENTIAL_HA_SERVICE_TAG, "Credential");
                }
                C10933b c10933b = f46701c;
                if (c10933b != null) {
                    m7650b(c10933b);
                    f46701c.m66058b(context, interfaceLinkHashMap);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
