package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.text.TextUtils;
import com.hihonor.common.grs.HihonorGrsBaseInfo;
import com.hihonor.common.grs.HihonorGrsClient;
import com.huawei.openalliance.p169ad.beans.inner.CountryCodeBean;
import com.huawei.openalliance.p169ad.utils.C7800ct;
import java.util.Map;

/* renamed from: com.huawei.openalliance.ad.ci */
/* loaded from: classes8.dex */
public class C6992ci implements InterfaceC6999cp {

    /* renamed from: a */
    private Context f32123a;

    /* renamed from: b */
    private HihonorGrsBaseInfo f32124b = new HihonorGrsBaseInfo();

    public C6992ci(Context context) {
        this.f32123a = context.getApplicationContext();
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC6999cp
    /* renamed from: a */
    public String mo41217a() {
        String strM48118b = C7800ct.m48114a().m48118b();
        boolean zEqualsIgnoreCase = "CN".equalsIgnoreCase(strM48118b);
        AbstractC7185ho.m43818a("HwGrsImpl", "init country code: %s ", strM48118b);
        return (C6982bz.m41152b(this.f32123a) || !zEqualsIgnoreCase) ? (TextUtils.isEmpty(strM48118b) || CountryCodeBean.OVERSEAS.equalsIgnoreCase(strM48118b)) ? new CountryCodeBean(this.f32123a).m39390a() : strM48118b : strM48118b;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC6999cp
    /* renamed from: b */
    public void mo41219b() {
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC6999cp
    /* renamed from: c */
    public Map<String, String> mo41221c(String str) {
        return new HihonorGrsClient(this.f32123a, this.f32124b).synGetGrsUrls(str);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC6999cp
    /* renamed from: a */
    public void mo41218a(String str) {
        this.f32124b.setAppName(str);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC6999cp
    /* renamed from: b */
    public void mo41220b(String str) {
        this.f32124b.setSerCountry(str);
    }
}
