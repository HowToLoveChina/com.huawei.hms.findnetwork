package com.huawei.hms.network.embedded;

import com.huawei.hms.network.embedded.InterfaceC5886d1;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

/* renamed from: com.huawei.hms.network.embedded.k3 */
/* loaded from: classes8.dex */
public class C5980k3 implements InterfaceC5886d1.a {

    /* renamed from: b */
    public static final String f27238b = "OkRequestTaskFactory";

    /* renamed from: a */
    public final C6062q7 f27239a;

    /* renamed from: com.huawei.hms.network.embedded.k3$a */
    public static class a implements InterfaceC5919f7 {

        /* renamed from: b */
        public InterfaceC6031o2 f27240b;

        public a(InterfaceC6031o2 interfaceC6031o2) {
            this.f27240b = interfaceC6031o2;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && this.f27240b.equals(((a) obj).f27240b);
        }

        public int hashCode() {
            return this.f27240b.hashCode();
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC5919f7
        public List<InetAddress> lookup(String str) throws UnknownHostException {
            return this.f27240b.lookup(str);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x005d, code lost:
    
        r1.m35115a(com.huawei.hms.network.httpclient.okhttp.OkHttpClientGlobal.getInstance().newConnectionPool()).m35120a(r8.getSocketFactory());
        com.huawei.hms.framework.common.Logger.m32141i(com.huawei.hms.network.embedded.C5980k3.f27238b, "bind network client = " + r8 + " " + r2);
     */
    @android.annotation.SuppressLint({"MissingPermission"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C5980k3(com.huawei.hms.network.embedded.C5844a1 r11) {
        /*
            Method dump skipped, instructions count: 343
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.network.embedded.C5980k3.<init>(com.huawei.hms.network.embedded.a1):void");
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5886d1.a
    public String getChannel() {
        return "type_okhttp";
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5886d1.a
    public boolean isAvailable() {
        return this.f27239a != null;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5886d1.a
    public InterfaceC5886d1 newTask() {
        return new C5967j3(this.f27239a);
    }
}
