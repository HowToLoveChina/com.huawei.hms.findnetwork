package com.huawei.hms.drive;

import com.huawei.hms.drive.C5203bh;
import com.huawei.hms.drive.InterfaceC5196ba;
import java.io.IOException;

/* renamed from: com.huawei.hms.drive.cc */
/* loaded from: classes8.dex */
public final class C5226cc implements InterfaceC5196ba {

    /* renamed from: a */
    public final C5198bc f24132a;

    public C5226cc(C5198bc c5198bc) {
        this.f24132a = c5198bc;
    }

    @Override // com.huawei.hms.drive.InterfaceC5196ba
    /* renamed from: a */
    public C5203bh mo31030a(InterfaceC5196ba.a aVar) throws IOException {
        C5239cp c5239cp = (C5239cp) aVar;
        C5201bf c5201bfMo31031a = c5239cp.mo31031a();
        c5239cp.m31422e().m31382a(c5201bfMo31031a);
        c5239cp.m31422e().m31393k().m31302a(this.f24132a, c5201bfMo31031a);
        return new C5203bh.a().m31145a(EnumC5199bd.HTTP_2).m31149a("").m31148a(new C5240cq("", 1L, null)).m31141a(200).m31146a(c5201bfMo31031a).m31151a();
    }
}
