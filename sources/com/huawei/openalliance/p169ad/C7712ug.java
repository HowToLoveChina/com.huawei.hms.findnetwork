package com.huawei.openalliance.p169ad;

import android.app.Activity;
import com.huawei.hms.network.embedded.C5914f2;
import com.tencent.p204mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.p204mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p204mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.p204mm.opensdk.openapi.IWXAPI;
import com.tencent.p204mm.opensdk.openapi.WXAPIFactory;
import java.util.UUID;

/* renamed from: com.huawei.openalliance.ad.ug */
/* loaded from: classes8.dex */
public class C7712ug implements InterfaceC7701tw {
    /* renamed from: a */
    private static int m47373a(C7708uc c7708uc) {
        return !c7708uc.m47357b().booleanValue() ? 1 : 0;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7701tw
    /* renamed from: a */
    public void mo47333a(Activity activity, C7706ua c7706ua, C7708uc c7708uc) {
        AbstractC7185ho.m43820b("WeiXinShare", "start WeXin share");
        String strM47353a = c7708uc.m47353a();
        IWXAPI iwxapiCreateWXAPI = WXAPIFactory.createWXAPI(C7700tv.m47332a(activity), strM47353a, true);
        iwxapiCreateWXAPI.registerApp(strM47353a);
        WXWebpageObject wXWebpageObject = new WXWebpageObject();
        wXWebpageObject.webpageUrl = c7706ua.m47347d();
        WXMediaMessage wXMediaMessage = new WXMediaMessage(wXWebpageObject);
        wXMediaMessage.title = C7709ud.m47363a(c7706ua.m47345b(), 512);
        wXMediaMessage.description = C7709ud.m47363a(c7706ua.m47346c(), 1024);
        wXMediaMessage.thumbData = C7709ud.m47365a(activity, c7706ua, C5914f2.f26733f);
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = UUID.randomUUID().toString();
        req.message = wXMediaMessage;
        req.scene = m47373a(c7708uc);
        iwxapiCreateWXAPI.sendReq(req);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7701tw
    /* renamed from: a */
    public boolean mo47334a() {
        return C7709ud.m47364a("com.tencent.mm.opensdk.openapi.WXAPIFactory");
    }
}
