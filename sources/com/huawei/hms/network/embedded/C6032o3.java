package com.huawei.hms.network.embedded;

import com.huawei.hms.network.embedded.C5928g3;
import java.lang.ref.WeakReference;

/* renamed from: com.huawei.hms.network.embedded.o3 */
/* loaded from: classes8.dex */
public class C6032o3 extends C5928g3 {

    /* renamed from: l */
    public static final a f27606l = new a();

    /* renamed from: k */
    public C5993l3 f27607k;

    public static a getWebSocketEventFactory() {
        return f27606l;
    }

    @Override // com.huawei.hms.network.embedded.C5928g3, com.huawei.hms.network.embedded.AbstractC5932g7
    public void callEnd(InterfaceC6100t6 interfaceC6100t6) {
    }

    @Override // com.huawei.hms.network.embedded.C5928g3, com.huawei.hms.network.embedded.AbstractC5932g7
    public void callStart(InterfaceC6100t6 interfaceC6100t6) {
        super.callStart(interfaceC6100t6);
        this.f27607k = (C5993l3) getRequestFinishedInfo();
    }

    public C5993l3 getWebSocketRequestFinishedInfo() {
        return this.f27607k;
    }

    /* renamed from: com.huawei.hms.network.embedded.o3$a */
    public static class a extends C5928g3.a {
        @Override // com.huawei.hms.network.embedded.C5928g3.a, com.huawei.hms.network.embedded.AbstractC5932g7.b
        public C6032o3 create(InterfaceC6100t6 interfaceC6100t6) {
            C6032o3 c6032o3 = new C6032o3();
            synchronized (this.lock) {
                this.events.put(interfaceC6100t6, new WeakReference<>(c6032o3));
            }
            return c6032o3;
        }
    }
}
