package com.huawei.hms.drive;

import com.huawei.hms.drive.InterfaceC5196ba;
import java.io.IOException;
import java.util.List;

/* renamed from: com.huawei.hms.drive.cp */
/* loaded from: classes8.dex */
public final class C5239cp implements InterfaceC5196ba.a {

    /* renamed from: a */
    private final List<InterfaceC5196ba> f24214a;

    /* renamed from: b */
    private final C5232ci f24215b;

    /* renamed from: c */
    private final C5224ca f24216c;

    /* renamed from: d */
    private final int f24217d;

    /* renamed from: e */
    private final C5201bf f24218e;

    /* renamed from: f */
    private final InterfaceC5177aj f24219f;

    /* renamed from: g */
    private final int f24220g;

    /* renamed from: h */
    private final int f24221h;

    /* renamed from: i */
    private final int f24222i;

    /* renamed from: j */
    private int f24223j;

    public C5239cp(List<InterfaceC5196ba> list, C5232ci c5232ci, C5224ca c5224ca, int i10, C5201bf c5201bf, InterfaceC5177aj interfaceC5177aj, int i11, int i12, int i13) {
        this.f24214a = list;
        this.f24215b = c5232ci;
        this.f24216c = c5224ca;
        this.f24217d = i10;
        this.f24218e = c5201bf;
        this.f24219f = interfaceC5177aj;
        this.f24220g = i11;
        this.f24221h = i12;
        this.f24222i = i13;
    }

    @Override // com.huawei.hms.drive.InterfaceC5196ba.a
    /* renamed from: a */
    public C5201bf mo31031a() {
        return this.f24218e;
    }

    @Override // com.huawei.hms.drive.InterfaceC5196ba.a
    /* renamed from: b */
    public int mo31033b() {
        return this.f24220g;
    }

    @Override // com.huawei.hms.drive.InterfaceC5196ba.a
    /* renamed from: c */
    public int mo31034c() {
        return this.f24221h;
    }

    @Override // com.huawei.hms.drive.InterfaceC5196ba.a
    /* renamed from: d */
    public int mo31035d() {
        return this.f24222i;
    }

    /* renamed from: e */
    public C5232ci m31422e() {
        return this.f24215b;
    }

    /* renamed from: f */
    public C5224ca m31423f() {
        C5224ca c5224ca = this.f24216c;
        if (c5224ca != null) {
            return c5224ca;
        }
        throw new IllegalStateException();
    }

    @Override // com.huawei.hms.drive.InterfaceC5196ba.a
    /* renamed from: a */
    public C5203bh mo31032a(C5201bf c5201bf) throws IOException {
        return m31421a(c5201bf, this.f24215b, this.f24216c);
    }

    /* renamed from: a */
    public C5203bh m31421a(C5201bf c5201bf, C5232ci c5232ci, C5224ca c5224ca) throws IOException {
        if (this.f24217d < this.f24214a.size()) {
            this.f24223j++;
            C5224ca c5224ca2 = this.f24216c;
            if (c5224ca2 != null && !c5224ca2.m31281a().m31324a(c5201bf.m31107a())) {
                throw new IllegalStateException("network interceptor " + this.f24214a.get(this.f24217d - 1) + " must retain the same host and port");
            }
            if (this.f24216c != null && this.f24223j > 1) {
                throw new IllegalStateException("network interceptor " + this.f24214a.get(this.f24217d - 1) + " must call proceed() exactly once");
            }
            C5239cp c5239cp = new C5239cp(this.f24214a, c5232ci, c5224ca, this.f24217d + 1, c5201bf, this.f24219f, this.f24220g, this.f24221h, this.f24222i);
            InterfaceC5196ba interfaceC5196ba = this.f24214a.get(this.f24217d);
            C5203bh c5203bhMo31030a = interfaceC5196ba.mo31030a(c5239cp);
            if (c5224ca != null && this.f24217d + 1 < this.f24214a.size() && c5239cp.f24223j != 1) {
                throw new IllegalStateException("network interceptor " + interfaceC5196ba + " must call proceed() exactly once");
            }
            if (c5203bhMo31030a == null) {
                throw new NullPointerException("interceptor " + interfaceC5196ba + " returned null");
            }
            if (c5203bhMo31030a.m31133f() != null || c5201bf.m31117j()) {
                return c5203bhMo31030a;
            }
            throw new IllegalStateException("interceptor " + interfaceC5196ba + " returned a response with no body");
        }
        throw new AssertionError();
    }
}
