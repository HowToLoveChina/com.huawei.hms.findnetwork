package com.huawei.hms.network.embedded;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.hms.network.embedded.v4 */
/* loaded from: classes8.dex */
public class C6124v4 extends AbstractC6137w4 {

    /* renamed from: b */
    public static final String f28640b = "AllDetectImpl";

    /* renamed from: a */
    public Map<Integer, List<InterfaceC6163y4>> f28641a = new HashMap();

    @Override // com.huawei.hms.network.embedded.AbstractC6137w4
    /* renamed from: a */
    public List<InterfaceC6163y4> mo35553a(int i10) {
        return this.f28641a.get(Integer.valueOf(i10));
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6137w4
    /* renamed from: b */
    public long mo35556b() {
        if (this.f28641a.isEmpty()) {
            return 0L;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        Iterator<Integer> it = this.f28641a.keySet().iterator();
        while (it.hasNext()) {
            InterfaceC6163y4 interfaceC6163y4Mo35557b = mo35557b(it.next().intValue());
            if (interfaceC6163y4Mo35557b != null && interfaceC6163y4Mo35557b.mo35776b() > 0) {
                jCurrentTimeMillis = Math.min(jCurrentTimeMillis, interfaceC6163y4Mo35557b.mo35776b());
            }
        }
        return jCurrentTimeMillis;
    }

    public String toString() {
        return "AllDetectImpl{allDetectMap=" + this.f28641a + '}';
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6137w4
    /* renamed from: a */
    public Map<Integer, List<InterfaceC6163y4>> mo35554a() {
        return this.f28641a;
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6137w4
    /* renamed from: b */
    public InterfaceC6163y4 mo35557b(int i10) {
        List<InterfaceC6163y4> list = this.f28641a.get(Integer.valueOf(i10));
        return (list == null || list.isEmpty()) ? new C6150x4() : list.get(list.size() - 1);
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6137w4
    /* renamed from: a */
    public synchronized void mo35555a(InterfaceC6163y4 interfaceC6163y4) {
        try {
            int iMo35779d = interfaceC6163y4.mo35779d();
            if (this.f28641a.get(Integer.valueOf(iMo35779d)) == null) {
                this.f28641a.put(Integer.valueOf(iMo35779d), new ArrayList());
            }
            this.f28641a.get(Integer.valueOf(iMo35779d)).add(interfaceC6163y4);
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
