package p239dw;

import aw.C1029b;
import com.huawei.hms.network.NetworkKit;
import com.huawei.wisesecurity.ucs_credential.C8916i0;

/* renamed from: dw.o */
/* loaded from: classes9.dex */
public class C9346o extends NetworkKit.Callback {
    public C9346o(C8916i0 c8916i0) {
    }

    @Override // com.huawei.hms.network.NetworkKit.Callback
    public void onResult(boolean z10) {
        if (z10) {
            C1029b.m6231b("RemoteRestClient", "Networkkit init success", new Object[0]);
        } else {
            C1029b.m6231b("RemoteRestClient", " Networkkit init failed", new Object[0]);
        }
    }
}
