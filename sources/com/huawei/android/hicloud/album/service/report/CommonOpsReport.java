package com.huawei.android.hicloud.album.service.report;

import android.content.Context;
import com.huawei.android.hicloud.album.service.report.ExtraData;
import p031b7.C1122c;

/* loaded from: classes2.dex */
public class CommonOpsReport extends OpsReport {
    public CommonOpsReport(Context context) {
        super(context);
    }

    /* renamed from: A */
    public void m15207A(String str, String str2, int i10, String str3, boolean z10) {
        m15267o(i10, "");
        m15272t(str3);
        m15214H(str, str2, z10);
    }

    /* renamed from: B */
    public void m15208B(String str, String str2) {
        m15271s("04006");
        ExtraData extraData = new ExtraData(this.f11631a);
        extraData.m15226e(str2);
        extraData.m15242u(str);
        m15270r(extraData);
        super.m15266n();
    }

    /* renamed from: C */
    public void m15209C(String str, String str2, int i10, String str3) {
        m15274v(i10, false);
        m15269q(str3);
        m15214H(str, str2, false);
    }

    /* renamed from: D */
    public void m15210D(String str, String str2, int i10, String str3, int i11, String str4, long j10) {
        m15273u(i11);
        m15269q(str4);
        ExtraData extraData = new ExtraData(this.f11631a, ExtraData.EnumC2434b.COMMON);
        extraData.m15241t(String.valueOf(j10));
        m15267o(i10, str3);
        m15271s(m15265e(str));
        m15276x(C1122c.m6728Q0(m15264c()));
        extraData.m15226e(str2);
        extraData.m15242u(str);
        m15270r(extraData);
        super.m15266n();
    }

    /* renamed from: E */
    public void m15211E(String str, String str2, int i10, String str3, int i11, String str4, boolean z10) {
        m15273u(i11);
        m15269q(str4);
        m15212F(str, str2, i10, str3, z10);
    }

    /* renamed from: F */
    public void m15212F(String str, String str2, int i10, String str3, boolean z10) {
        m15267o(i10, str3);
        m15214H(str, str2, z10);
    }

    /* renamed from: G */
    public void m15213G(String str, String str2, String str3, String str4) {
        m15275w(str3);
        m15269q(str4);
        m15214H(str, str2, false);
    }

    /* renamed from: H */
    public final void m15214H(String str, String str2, boolean z10) {
        m15271s(m15265e(str));
        m15276x(C1122c.m6728Q0(m15264c()));
        ExtraData extraData = new ExtraData(this.f11631a);
        extraData.m15226e(str2);
        extraData.m15242u(str);
        if (z10) {
            extraData.m15229h("1");
        }
        m15270r(extraData);
        super.m15266n();
    }
}
