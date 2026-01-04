package com.huawei.phoneservice.faqcommon.webapi.webmanager;

import android.content.Context;
import com.huawei.hms.framework.network.restclient.hwhttp.Callback;
import com.huawei.hms.framework.network.restclient.hwhttp.Submit;
import com.huawei.phoneservice.faq.base.constants.TrackConstants$Opers;
import com.huawei.phoneservice.faq.base.network.FaqRestClient;
import com.huawei.phoneservice.faq.base.util.FaqUtil;
import com.huawei.phoneservice.faqcommon.webapi.request.C8436b;
import com.huawei.phoneservice.faqcommon.webapi.request.C8437c;
import com.huawei.phoneservice.faqcommon.webapi.request.C8438d;
import com.huawei.phoneservice.faqcommon.webapi.request.C8441g;
import p692uw.C13264g;
import p692uw.C13267j;

/* loaded from: classes4.dex */
public final class FaqEvaluateApi extends FaqRestClient {

    /* renamed from: b */
    public static final C8448a f39435b = new C8448a(null);

    /* renamed from: c */
    public static Context f39436c;

    /* renamed from: d */
    public static volatile FaqEvaluateApi f39437d;

    /* renamed from: a */
    public Context f39438a;

    /* renamed from: com.huawei.phoneservice.faqcommon.webapi.webmanager.FaqEvaluateApi$a */
    public static final class C8448a {
        public C8448a() {
        }

        public /* synthetic */ C8448a(C13264g c13264g) {
            this();
        }

        /* renamed from: a */
        public final FaqEvaluateApi m52551a(Context context) {
            FaqEvaluateApi.f39436c = context != null ? context.getApplicationContext() : null;
            if (FaqEvaluateApi.f39437d == null) {
                FaqEvaluateApi.f39437d = new FaqEvaluateApi(FaqEvaluateApi.f39436c);
            }
            return FaqEvaluateApi.f39437d;
        }
    }

    public FaqEvaluateApi(Context context) {
        super(context);
        this.f39438a = context;
    }

    /* renamed from: a */
    public final Submit m52547a(C8436b c8436b, Callback callback) {
        C13267j.m79677e(c8436b, TrackConstants$Opers.REQUEST);
        C13267j.m79677e(callback, "callback");
        FaqRestClient faqRestClientInitRestClientAnno = FaqRestClient.Companion.initRestClientAnno(this.f39438a);
        C13267j.m79674b(faqRestClientInitRestClientAnno);
        Context context = f39436c;
        String url = FaqUtil.getUrl(C8452a.f39451a.m52574d());
        C13267j.m79676d(url, "getUrl(FaqWebConstants.FAQ_EVALUATE_LIST_URL)");
        String json = getGson().toJson(c8436b);
        C13267j.m79676d(json, "gson.toJson(request)");
        return faqRestClientInitRestClientAnno.asyncRequest(context, url, json, callback);
    }

    /* renamed from: b */
    public final Submit m52548b(C8437c c8437c, Callback callback) {
        C13267j.m79677e(c8437c, TrackConstants$Opers.REQUEST);
        C13267j.m79677e(callback, "callback");
        FaqRestClient faqRestClientInitRestClientAnno = FaqRestClient.Companion.initRestClientAnno(this.f39438a);
        C13267j.m79674b(faqRestClientInitRestClientAnno);
        Context context = f39436c;
        String url = FaqUtil.getUrl(C8452a.f39451a.m52576f());
        C13267j.m79676d(url, "getUrl(FaqWebConstants.FAQ_EVALUTATE_URL)");
        String json = getGson().toJson(c8437c);
        C13267j.m79676d(json, "gson.toJson(request)");
        return faqRestClientInitRestClientAnno.asyncRequest(context, url, json, callback);
    }

    /* renamed from: c */
    public final Submit m52549c(C8438d c8438d, Callback callback) {
        C13267j.m79677e(c8438d, TrackConstants$Opers.REQUEST);
        C13267j.m79677e(callback, "callback");
        FaqRestClient faqRestClientInitRestClientAnno = FaqRestClient.Companion.initRestClientAnno(this.f39438a);
        C13267j.m79674b(faqRestClientInitRestClientAnno);
        Context context = f39436c;
        String url = FaqUtil.getUrl(C8452a.f39451a.m52575e());
        C13267j.m79676d(url, "getUrl(FaqWebConstants.FAQ_EVALUATE_SUBMIT_URL)");
        String json = getGson().toJson(c8438d);
        C13267j.m79676d(json, "gson.toJson(request)");
        return faqRestClientInitRestClientAnno.asyncRequest(context, url, json, callback);
    }

    /* renamed from: d */
    public final Submit m52550d(C8441g c8441g, Callback callback) {
        C13267j.m79677e(c8441g, TrackConstants$Opers.REQUEST);
        C13267j.m79677e(callback, "callback");
        FaqRestClient faqRestClientInitRestClientAnno = FaqRestClient.Companion.initRestClientAnno(this.f39438a);
        C13267j.m79674b(faqRestClientInitRestClientAnno);
        Context context = f39436c;
        String url = FaqUtil.getUrl(C8452a.f39451a.m52578h());
        C13267j.m79676d(url, "getUrl(FaqWebConstants.FAQ_SITE_CODE_URL)");
        String json = getGson().toJson(c8441g);
        C13267j.m79676d(json, "gson.toJson(request)");
        return faqRestClientInitRestClientAnno.asyncRequest(context, url, json, callback);
    }
}
