package com.huawei.openalliance.p169ad;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.tauth.DefaultUiListener;
import com.tencent.tauth.Tencent;

/* renamed from: com.huawei.openalliance.ad.tz */
/* loaded from: classes8.dex */
public class C7704tz implements InterfaceC7701tw {
    /* renamed from: a */
    private static Bundle m47337a(C7706ua c7706ua, C7708uc c7708uc) {
        Bundle bundle = new Bundle();
        if (c7706ua != null && c7708uc != null) {
            boolean zBooleanValue = c7708uc.m47357b().booleanValue();
            bundle.putString("title", C7709ud.m47363a(c7706ua.m47345b(), zBooleanValue ? 30 : 40));
            bundle.putString("summary", C7709ud.m47363a(c7706ua.m47346c(), c7708uc.m47357b().booleanValue() ? 200 : 600));
            bundle.putString("targetUrl", c7706ua.m47347d());
            String strM47341a = c7706ua.m47341a();
            bundle.putString(strM47341a.startsWith("http") ? "imageUrl" : "imageLocalUrl", strM47341a);
            bundle.putInt("req_type", 1);
            bundle.putInt("cflag", zBooleanValue ? 2 : 1);
        }
        return bundle;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7701tw
    /* renamed from: a */
    public void mo47333a(Activity activity, C7706ua c7706ua, C7708uc c7708uc) {
        AbstractC7185ho.m43820b("QQSharer", "start QQ share");
        Tencent.createInstance(c7708uc.m47353a(), activity).shareToQQ(activity, m47337a(c7706ua, c7708uc), new DefaultUiListener());
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7701tw
    /* renamed from: a */
    public boolean mo47334a() {
        return C7709ud.m47364a("com.tencent.tauth.Tencent");
    }
}
