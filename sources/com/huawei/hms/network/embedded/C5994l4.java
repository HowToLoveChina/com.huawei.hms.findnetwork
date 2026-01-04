package com.huawei.hms.network.embedded;

import com.huawei.hms.network.inner.api.NetworkReceiver;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.huawei.hms.network.embedded.l4 */
/* loaded from: classes8.dex */
public final class C5994l4 {

    /* renamed from: b */
    public static final C5994l4 f27374b = new C5994l4();

    /* renamed from: a */
    public List<NetworkReceiver> f27375a = new CopyOnWriteArrayList();

    /* renamed from: b */
    public static C5994l4 m34650b() {
        return f27374b;
    }

    /* renamed from: a */
    public List<NetworkReceiver> m34651a() {
        return this.f27375a;
    }

    /* renamed from: a */
    public void m34652a(NetworkReceiver networkReceiver) {
        if (networkReceiver != null) {
            this.f27375a.add(networkReceiver);
        }
    }

    /* renamed from: b */
    public void m34653b(NetworkReceiver networkReceiver) {
        if (networkReceiver != null) {
            this.f27375a.remove(networkReceiver);
        }
    }
}
