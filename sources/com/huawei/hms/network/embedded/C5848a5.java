package com.huawei.hms.network.embedded;

import com.huawei.hms.network.netdiag.info.SignalInfoMetrics;

/* renamed from: com.huawei.hms.network.embedded.a5 */
/* loaded from: classes8.dex */
public class C5848a5 extends AbstractC6176z4 {

    /* renamed from: a */
    public InterfaceC5930g5 f26340a = new C5917f5();

    /* renamed from: b */
    public AbstractC6137w4 f26341b = new C6124v4();

    /* renamed from: c */
    public SignalInfoMetrics f26342c;

    /* renamed from: d */
    public SignalInfoMetrics f26343d;

    /* renamed from: e */
    public InterfaceC5876c5 f26344e;

    /* renamed from: f */
    public int f26345f;

    /* renamed from: g */
    public int f26346g;

    /* renamed from: h */
    public int f26347h;

    public C5848a5() {
        C5904e5 c5904e5 = new C5904e5();
        this.f26342c = c5904e5;
        this.f26343d = c5904e5;
        this.f26344e = new C5862b5();
        this.f26345f = 0;
        this.f26346g = 0;
        this.f26347h = 0;
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6176z4
    /* renamed from: a */
    public int mo33780a() {
        return this.f26346g;
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6176z4
    /* renamed from: b */
    public AbstractC6137w4 mo33786b() {
        return this.f26341b;
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6176z4
    /* renamed from: c */
    public SignalInfoMetrics mo33789c() {
        return this.f26343d;
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6176z4
    /* renamed from: d */
    public int mo33791d() {
        return this.f26347h;
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6176z4
    /* renamed from: e */
    public InterfaceC5876c5 mo33792e() {
        return this.f26344e;
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6176z4
    /* renamed from: f */
    public SignalInfoMetrics mo33793f() {
        return this.f26342c;
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6176z4
    /* renamed from: g */
    public InterfaceC5930g5 mo33794g() {
        return this.f26340a;
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6176z4
    /* renamed from: h */
    public int mo33795h() {
        return this.f26345f;
    }

    public String toString() {
        return "NetDiagInfoImpl{systemControlInfo=" + this.f26340a + ", allDetectInfo=" + this.f26341b + ", signalInfo=" + this.f26342c + ", networkInfo=" + this.f26344e + '}';
    }

    /* renamed from: a */
    public void m33781a(int i10) {
        this.f26346g = i10;
    }

    /* renamed from: b */
    public void m33787b(int i10) {
        this.f26345f = i10;
    }

    /* renamed from: c */
    public void m33790c(int i10) {
        this.f26347h = i10;
    }

    /* renamed from: a */
    public void m33782a(InterfaceC5876c5 interfaceC5876c5) {
        this.f26344e = interfaceC5876c5;
    }

    /* renamed from: b */
    public void m33788b(SignalInfoMetrics signalInfoMetrics) {
        if (signalInfoMetrics != null) {
            this.f26342c = signalInfoMetrics;
        }
    }

    /* renamed from: a */
    public void m33783a(InterfaceC5930g5 interfaceC5930g5) {
        if (interfaceC5930g5 != null) {
            this.f26340a = interfaceC5930g5;
        }
    }

    /* renamed from: a */
    public void m33784a(AbstractC6137w4 abstractC6137w4) {
        if (abstractC6137w4 != null) {
            this.f26341b = abstractC6137w4;
        }
    }

    /* renamed from: a */
    public void m33785a(SignalInfoMetrics signalInfoMetrics) {
        this.f26343d = signalInfoMetrics;
    }
}
