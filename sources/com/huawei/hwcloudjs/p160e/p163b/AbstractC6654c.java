package com.huawei.hwcloudjs.p160e.p163b;

import com.huawei.hwcloudjs.p160e.p163b.AbstractC6655d;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.huawei.hwcloudjs.e.b.c */
/* loaded from: classes8.dex */
public abstract class AbstractC6654c<T extends AbstractC6655d> implements InterfaceC6652a<T> {

    /* renamed from: a */
    private final List<InterfaceC6653b<T>> f30873a = new ArrayList();

    @Override // com.huawei.hwcloudjs.p160e.p163b.InterfaceC6652a
    /* renamed from: a */
    public void mo37868a(InterfaceC6653b<T> interfaceC6653b) {
        synchronized (this.f30873a) {
            this.f30873a.remove(interfaceC6653b);
        }
    }

    @Override // com.huawei.hwcloudjs.p160e.p163b.InterfaceC6652a
    /* renamed from: b */
    public void mo37870b(InterfaceC6653b<T> interfaceC6653b) {
        synchronized (this.f30873a) {
            try {
                if (interfaceC6653b == null) {
                    return;
                }
                if (!this.f30873a.contains(interfaceC6653b)) {
                    this.f30873a.add(interfaceC6653b);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.hwcloudjs.p160e.p163b.InterfaceC6652a
    /* renamed from: a */
    public void mo37869a(T t10) {
        synchronized (this.f30873a) {
            try {
                ArrayList arrayList = new ArrayList();
                for (InterfaceC6653b<T> interfaceC6653b : this.f30873a) {
                    if (!interfaceC6653b.onReceive(t10)) {
                        arrayList.add(interfaceC6653b);
                    }
                }
                if (arrayList.size() > 0) {
                    this.f30873a.removeAll(arrayList);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
