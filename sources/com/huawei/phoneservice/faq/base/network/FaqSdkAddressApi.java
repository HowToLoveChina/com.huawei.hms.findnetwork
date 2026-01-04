package com.huawei.phoneservice.faq.base.network;

import android.content.Context;
import com.huawei.hms.framework.network.restclient.hwhttp.Callback;
import com.huawei.hms.framework.network.restclient.hwhttp.Submit;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.phoneservice.faq.base.entity.C8297a;
import com.huawei.phoneservice.faq.base.entity.ModuleConfigRequest;
import com.huawei.phoneservice.faq.base.util.FaqSdk;
import com.huawei.phoneservice.faq.base.util.FaqUtil;
import p692uw.C13264g;
import p692uw.C13267j;

/* loaded from: classes4.dex */
public final class FaqSdkAddressApi extends FaqRestClient {

    /* renamed from: d */
    public static final C8299a f38650d = new C8299a(null);

    /* renamed from: e */
    public static Context f38651e;

    /* renamed from: f */
    public static volatile FaqSdkAddressApi f38652f;

    /* renamed from: a */
    public final String f38653a;

    /* renamed from: b */
    public final String f38654b;

    /* renamed from: c */
    public Context f38655c;

    /* renamed from: com.huawei.phoneservice.faq.base.network.FaqSdkAddressApi$a */
    public static final class C8299a {
        public C8299a() {
        }

        public /* synthetic */ C8299a(C13264g c13264g) {
            this();
        }

        /* renamed from: a */
        public final FaqSdkAddressApi m51788a(Context context) {
            FaqSdkAddressApi.f38651e = context != null ? context.getApplicationContext() : null;
            if (FaqSdkAddressApi.f38652f == null) {
                FaqSdkAddressApi.f38652f = new FaqSdkAddressApi(FaqSdkAddressApi.f38651e);
            }
            return FaqSdkAddressApi.f38652f;
        }
    }

    public FaqSdkAddressApi(Context context) {
        super(context);
        this.f38653a = "ccpc/queryRoutesInfo";
        this.f38654b = "ccpc/queryModuleList";
        this.f38655c = context;
    }

    /* renamed from: a */
    public final Submit m51785a(ModuleConfigRequest moduleConfigRequest, Callback callback) {
        C13267j.m79677e(moduleConfigRequest, "body");
        C13267j.m79677e(callback, "callback");
        FaqRestClient faqRestClientInitRestClientAnno = FaqRestClient.Companion.initRestClientAnno(this.f38655c);
        C13267j.m79674b(faqRestClientInitRestClientAnno);
        Context context = f38651e;
        String url = FaqUtil.getUrl(this.f38654b);
        C13267j.m79676d(url, "getUrl(queryModuleList)");
        String json = getGson().toJson(moduleConfigRequest);
        C13267j.m79676d(json, "gson.toJson(body)");
        return faqRestClientInitRestClientAnno.asyncRequest(context, url, json, callback);
    }

    /* renamed from: b */
    public final Submit m51786b(C8297a c8297a, Callback callback) {
        C13267j.m79677e(c8297a, "body");
        C13267j.m79677e(callback, "callback");
        FaqRestClient faqRestClientInitRestClientAnno = FaqRestClient.Companion.initRestClientAnno(this.f38655c);
        C13267j.m79674b(faqRestClientInitRestClientAnno);
        Context context = f38651e;
        String strM51787g = m51787g();
        String json = getGson().toJson(c8297a);
        C13267j.m79676d(json, "gson.toJson(body)");
        return faqRestClientInitRestClientAnno.asyncRequest(context, strM51787g, json, callback);
    }

    /* renamed from: g */
    public final String m51787g() {
        StringBuilder sb2;
        String str;
        if (C13267j.m79673a("Y", FaqSdk.getSdk().getSdk(FaqConstants.FAQ_USE_OLD_DOMAIN))) {
            sb2 = new StringBuilder();
            sb2.append(FaqUtil.m51889a());
            str = "/secured/CCPC/EN/";
        } else {
            sb2 = new StringBuilder();
            sb2.append(FaqUtil.m51893e());
            str = "/forward/ccpc_gateway_sdk/";
        }
        sb2.append(str);
        sb2.append(this.f38653a);
        sb2.append("/1");
        return sb2.toString();
    }
}
