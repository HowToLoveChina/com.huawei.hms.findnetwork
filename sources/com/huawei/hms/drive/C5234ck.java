package com.huawei.hms.drive;

import com.huawei.hms.drive.C5203bh;
import com.huawei.hms.drive.InterfaceC5196ba;
import java.io.IOException;
import java.net.ProtocolException;
import p022ay.C1064n;
import p022ay.InterfaceC1055e;

/* renamed from: com.huawei.hms.drive.ck */
/* loaded from: classes8.dex */
public final class C5234ck implements InterfaceC5196ba {

    /* renamed from: a */
    private final boolean f24208a;

    public C5234ck(boolean z10) {
        this.f24208a = z10;
    }

    @Override // com.huawei.hms.drive.InterfaceC5196ba
    /* renamed from: a */
    public C5203bh mo31030a(InterfaceC5196ba.a aVar) throws IOException {
        boolean z10;
        C5239cp c5239cp = (C5239cp) aVar;
        C5224ca c5224caM31423f = c5239cp.m31423f();
        C5201bf c5201bfMo31031a = c5239cp.mo31031a();
        long jCurrentTimeMillis = System.currentTimeMillis();
        c5224caM31423f.m31283a(c5201bfMo31031a);
        C5203bh.a aVarM31280a = null;
        if (!C5238co.m31418c(c5201bfMo31031a.m31109b()) || c5201bfMo31031a.m31111d() == null) {
            c5224caM31423f.m31294i();
            z10 = false;
        } else {
            if ("100-continue".equalsIgnoreCase(c5201bfMo31031a.m31108a("Expect"))) {
                c5224caM31423f.m31288c();
                c5224caM31423f.m31290e();
                aVarM31280a = c5224caM31423f.m31280a(true);
                z10 = true;
            } else {
                z10 = false;
            }
            if (aVarM31280a != null) {
                c5224caM31423f.m31294i();
                if (!c5224caM31423f.m31281a().m31331g()) {
                    c5224caM31423f.m31291f();
                }
            } else if (c5201bfMo31031a.m31111d().isDuplex()) {
                c5224caM31423f.m31288c();
                c5201bfMo31031a.m31111d().writeTo(C1064n.m6402a(c5224caM31423f.m31279a(c5201bfMo31031a, true)));
            } else {
                InterfaceC1055e interfaceC1055eM6402a = C1064n.m6402a(c5224caM31423f.m31279a(c5201bfMo31031a, false));
                c5201bfMo31031a.m31111d().writeTo(interfaceC1055eM6402a);
                interfaceC1055eM6402a.close();
            }
        }
        if (c5201bfMo31031a.m31111d() == null || !c5201bfMo31031a.m31111d().isDuplex()) {
            c5224caM31423f.m31289d();
        }
        if (!z10) {
            c5224caM31423f.m31290e();
        }
        if (aVarM31280a == null) {
            aVarM31280a = c5224caM31423f.m31280a(false);
        }
        C5203bh c5203bhM31151a = aVarM31280a.m31146a(c5201bfMo31031a).m31143a(c5224caM31423f.m31281a().m31330f()).m31142a(jCurrentTimeMillis).m31153b(System.currentTimeMillis()).m31151a();
        int iM31129b = c5203bhM31151a.m31129b();
        if (iM31129b == 100) {
            c5203bhM31151a = c5224caM31423f.m31280a(false).m31146a(c5201bfMo31031a).m31143a(c5224caM31423f.m31281a().m31330f()).m31142a(jCurrentTimeMillis).m31153b(System.currentTimeMillis()).m31151a();
            iM31129b = c5203bhM31151a.m31129b();
        }
        c5224caM31423f.m31284a(c5203bhM31151a);
        C5203bh c5203bhM31151a2 = (this.f24208a && iM31129b == 101) ? c5203bhM31151a.m31134g().m31148a(C5210bo.f23991d).m31151a() : c5203bhM31151a.m31134g().m31148a(c5224caM31423f.m31286b(c5203bhM31151a)).m31151a();
        if ("close".equalsIgnoreCase(c5203bhM31151a2.m31126a().m31108a("Connection")) || "close".equalsIgnoreCase(c5203bhM31151a2.m31127a("Connection"))) {
            c5224caM31423f.m31291f();
        }
        if ((iM31129b != 204 && iM31129b != 205) || c5203bhM31151a2.m31133f().mo31159a() <= 0) {
            return c5203bhM31151a2;
        }
        throw new ProtocolException("HTTP " + iM31129b + " had non-zero Content-Length: " + c5203bhM31151a2.m31133f().mo31159a());
    }
}
