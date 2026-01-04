package com.huawei.openalliance.p169ad;

import android.app.Activity;
import com.huawei.works.share.WeApi;
import com.huawei.works.share.modelmsg.WeCardObject;
import com.huawei.works.share.modelmsg.WeMediaMessage;

/* renamed from: com.huawei.openalliance.ad.ue */
/* loaded from: classes8.dex */
public class C7710ue implements InterfaceC7701tw {
    @Override // com.huawei.openalliance.p169ad.InterfaceC7701tw
    /* renamed from: a */
    public void mo47333a(Activity activity, C7706ua c7706ua, C7708uc c7708uc) {
        try {
            AbstractC7185ho.m43820b("WeLinkShare", "start WeLink share");
            WeCardObject weCardObject = new WeCardObject();
            weCardObject.title = c7706ua.m47345b();
            weCardObject.desc = c7706ua.m47346c();
            weCardObject.uri = c7706ua.m47341a();
            weCardObject.sourceURL = c7706ua.m47347d();
            weCardObject.shareType = "image-txt";
            weCardObject.isPCDisplay = c7708uc.m47358c().booleanValue() ? "1" : "0";
            WeApi.getInstance(activity).share(new WeMediaMessage(weCardObject));
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("WeLinkShare", "WeLink share occurs a exception, caused: %s", th2.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7701tw
    /* renamed from: a */
    public boolean mo47334a() {
        return C7709ud.m47364a("com.huawei.works.share.WeApi");
    }
}
