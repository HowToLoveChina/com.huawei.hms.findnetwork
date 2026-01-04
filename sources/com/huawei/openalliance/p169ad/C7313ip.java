package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.C7821dn;

/* renamed from: com.huawei.openalliance.ad.ip */
/* loaded from: classes8.dex */
public class C7313ip {

    /* renamed from: a */
    private static final String f33985a = "ip";

    /* renamed from: b */
    private String f33986b;

    /* renamed from: c */
    private int f33987c;

    /* renamed from: d */
    private InterfaceC7207ia f33988d;

    /* renamed from: e */
    private Context f33989e;

    public C7313ip(Context context, String str, InterfaceC7207ia interfaceC7207ia, int i10) {
        this.f33986b = str;
        this.f33987c = i10;
        this.f33988d = interfaceC7207ia;
        this.f33989e = context.getApplicationContext();
    }

    /* renamed from: a */
    public boolean m45057a(String str, String str2) {
        if (1 == this.f33987c || AbstractC7806cz.m48165b(this.f33986b) || C7821dn.m48378a(this.f33989e, str2, this.f33986b)) {
            return true;
        }
        AbstractC7185ho.m43820b(f33985a, "check sha256 failed! file path is : " + str2);
        this.f33988d.mo43905b(str);
        return false;
    }
}
