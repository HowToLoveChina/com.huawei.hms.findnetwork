package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.huawei.android.util.HwNotchSizeUtil;
import com.huawei.openalliance.p169ad.beans.inner.CountryCodeBean;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.utils.C7745as;
import com.huawei.openalliance.p169ad.utils.C7845x;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;

/* renamed from: com.huawei.openalliance.ad.cj */
/* loaded from: classes8.dex */
public class C6993cj extends AbstractC6987cd {

    /* renamed from: c */
    private static InterfaceC6998co f32125c;

    /* renamed from: d */
    private static final byte[] f32126d = new byte[0];

    private C6993cj(Context context) {
        super(context);
    }

    /* renamed from: b */
    public static InterfaceC6998co m41222b(Context context) {
        return m41223c(context);
    }

    /* renamed from: c */
    private static InterfaceC6998co m41223c(Context context) {
        InterfaceC6998co interfaceC6998co;
        synchronized (f32126d) {
            try {
                if (f32125c == null) {
                    f32125c = new C6993cj(context);
                }
                interfaceC6998co = f32125c;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return interfaceC6998co;
    }

    @Override // com.huawei.openalliance.p169ad.C6986cc, com.huawei.openalliance.p169ad.InterfaceC6998co
    /* renamed from: a */
    public int mo41169a(View view) {
        StringBuilder sb2;
        try {
            if (!HwNotchSizeUtil.hasNotchInScreen()) {
                return 0;
            }
            int[] notchSize = HwNotchSizeUtil.getNotchSize();
            if (notchSize.length >= 2) {
                return notchSize[1];
            }
            return 0;
        } catch (Exception e10) {
            e = e10;
            sb2 = new StringBuilder();
            sb2.append("getNotchHeight error:");
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("HwDeviceImpl", sb2.toString());
            return 0;
        } catch (Throwable th2) {
            e = th2;
            sb2 = new StringBuilder();
            sb2.append("getNotchHeight error:");
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("HwDeviceImpl", sb2.toString());
            return 0;
        }
    }

    @Override // com.huawei.openalliance.p169ad.C6986cc, com.huawei.openalliance.p169ad.InterfaceC6998co
    /* renamed from: h */
    public Integer mo41179h() {
        return Integer.valueOf(C7745as.a.f35839a);
    }

    @Override // com.huawei.openalliance.p169ad.C6986cc, com.huawei.openalliance.p169ad.InterfaceC6998co
    /* renamed from: l */
    public boolean mo41183l() {
        return C7845x.m48557e(this.f32106a);
    }

    @Override // com.huawei.openalliance.p169ad.C6986cc, com.huawei.openalliance.p169ad.InterfaceC6998co
    /* renamed from: m */
    public boolean mo41184m() {
        String strMo43382bI = C7124fh.m43316b(this.f32106a).mo43382bI();
        if (TextUtils.isEmpty(strMo43382bI)) {
            return false;
        }
        AbstractC7185ho.m43818a("HwDeviceImpl", "device in test mode, countryCode:%s", strMo43382bI);
        return true;
    }

    @Override // com.huawei.openalliance.p169ad.C6986cc, com.huawei.openalliance.p169ad.InterfaceC6998co
    /* renamed from: p */
    public String mo41187p() {
        return AbstractC7811dd.m48289a(CountryCodeBean.VENDOR_SYSTEMPROP);
    }

    @Override // com.huawei.openalliance.p169ad.C6986cc, com.huawei.openalliance.p169ad.InterfaceC6998co
    /* renamed from: q */
    public String mo41188q() {
        return AbstractC7811dd.m48289a(CountryCodeBean.VENDORCOUNTRY_SYSTEMPROP);
    }

    @Override // com.huawei.openalliance.p169ad.C6986cc, com.huawei.openalliance.p169ad.InterfaceC6998co
    /* renamed from: r */
    public boolean mo41189r() {
        return FaqConstants.DISABLE_HA_REPORT.equalsIgnoreCase(AbstractC7811dd.m48289a("hw_mc.pure_mode.enable"));
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC6987cd
    /* renamed from: s */
    public String mo41197s() {
        return "hw_sc.build.platform.version";
    }

    @Override // com.huawei.openalliance.p169ad.C6986cc, com.huawei.openalliance.p169ad.InterfaceC6998co
    /* renamed from: a */
    public boolean mo41170a() {
        return "156".equals(AbstractC7811dd.m48289a("ro.config.hw_optb"));
    }
}
