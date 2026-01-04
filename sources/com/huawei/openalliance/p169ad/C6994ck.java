package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.GrsClient;
import com.huawei.openalliance.p169ad.beans.inner.CountryCodeBean;
import com.huawei.openalliance.p169ad.constant.FlavorConstants;
import com.huawei.openalliance.p169ad.utils.C7800ct;
import java.util.Map;

/* renamed from: com.huawei.openalliance.ad.ck */
/* loaded from: classes8.dex */
public class C6994ck implements InterfaceC6999cp {

    /* renamed from: a */
    private GrsBaseInfo f32127a = new GrsBaseInfo();

    /* renamed from: b */
    private Context f32128b;

    public C6994ck(Context context) {
        this.f32128b = context.getApplicationContext();
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC6999cp
    /* renamed from: a */
    public String mo41217a() {
        String strM48118b = C7800ct.m48114a().m48118b();
        String strM48121c = C7800ct.m48114a().m48121c();
        boolean zEqualsIgnoreCase = "CN".equalsIgnoreCase(strM48118b);
        AbstractC7185ho.m43818a("HwGrsImpl", "init country code: %s ", strM48118b);
        AbstractC7185ho.m43818a("HwGrsImpl", "media country code: %s ", strM48121c);
        return (C6982bz.m41152b(this.f32128b) || !zEqualsIgnoreCase) ? !TextUtils.isEmpty(strM48121c) ? strM48121c : (TextUtils.isEmpty(strM48118b) || CountryCodeBean.OVERSEAS.equalsIgnoreCase(strM48118b)) ? new CountryCodeBean(this.f32128b).m39390a() : strM48118b : strM48118b;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC6999cp
    /* renamed from: b */
    public void mo41219b() {
        AbstractC7185ho.m43820b("HwGrsImpl", "forceExpire");
        try {
            new GrsClient(this.f32128b, this.f32127a).forceExpire();
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("HwGrsImpl", "GrsClient.forceExpire, exception: %s", th2.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC6999cp
    /* renamed from: c */
    public Map<String, String> mo41221c(String str) {
        return new GrsClient(this.f32128b, this.f32127a).synGetGrsUrls(FlavorConstants.HIAD_GRS_SERVICE_NAME);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC6999cp
    /* renamed from: a */
    public void mo41218a(String str) {
        this.f32127a.setAppName(str);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC6999cp
    /* renamed from: b */
    public void mo41220b(String str) {
        this.f32127a.setSerCountry(str);
    }
}
