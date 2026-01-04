package com.huawei.phoneservice.faq.base;

/* renamed from: com.huawei.phoneservice.faq.base.b */
/* loaded from: classes4.dex */
public enum EnumC8290b {
    INIT_FAIL(-1, "NO INITIALIZED"),
    PARAMETER_ERROR(1, "PARAMETER EMPTY "),
    NO_ADDRESS(2, "NO ADDRESS "),
    NO_MODULE(3, "NO MODULE"),
    NO_GRS_ADDRESS(4, "NO GRS ADDRESS"),
    NO_ADDRESS_SERVICE(5, "NO ADDRESS BY SERVICE ERROR"),
    NO_MODULE_SERVICE(6, "NO MODULE BY SERVICE ERROR"),
    INIT_AGAIN(7, "INIT_AGAIN"),
    INIT_SUCCESS(0, "INIT SUCCESS");


    /* renamed from: a */
    public int f38620a;

    /* renamed from: b */
    public String f38621b;

    EnumC8290b(int i10, String str) {
        this.f38620a = i10;
        this.f38621b = str;
    }

    /* renamed from: b */
    public int m51749b() {
        return this.f38620a;
    }

    /* renamed from: e */
    public String m51750e() {
        return this.f38621b;
    }

    /* renamed from: f */
    public boolean m51751f() {
        int i10 = this.f38620a;
        return i10 == 0 || i10 == 3;
    }
}
