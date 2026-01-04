package com.huawei.hms.drive;

import com.huawei.hms.drive.InterfaceC5196ba;
import java.io.IOException;

/* renamed from: com.huawei.hms.drive.by */
/* loaded from: classes8.dex */
public final class C5220by implements InterfaceC5196ba {

    /* renamed from: a */
    public final C5198bc f24087a;

    public C5220by(C5198bc c5198bc) {
        this.f24087a = c5198bc;
    }

    @Override // com.huawei.hms.drive.InterfaceC5196ba
    /* renamed from: a */
    public C5203bh mo31030a(InterfaceC5196ba.a aVar) throws IOException {
        C5239cp c5239cp = (C5239cp) aVar;
        C5201bf c5201bfMo31031a = c5239cp.mo31031a();
        C5232ci c5232ciM31422e = c5239cp.m31422e();
        return c5239cp.m31421a(c5201bfMo31031a, c5232ciM31422e, c5232ciM31422e.m31378a(aVar, !c5201bfMo31031a.m31109b().equals("GET")));
    }
}
