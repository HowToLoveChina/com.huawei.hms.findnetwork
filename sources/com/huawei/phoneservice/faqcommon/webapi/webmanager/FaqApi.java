package com.huawei.phoneservice.faqcommon.webapi.webmanager;

import android.content.Context;
import com.huawei.hms.framework.network.restclient.hwhttp.Callback;
import com.huawei.hms.framework.network.restclient.hwhttp.Submit;
import com.huawei.phoneservice.faq.base.constants.TrackConstants$Opers;
import com.huawei.phoneservice.faq.base.network.FaqRestClient;
import com.huawei.phoneservice.faq.base.util.FaqUtil;
import com.huawei.phoneservice.faqcommon.webapi.request.C8435a;
import com.huawei.phoneservice.faqcommon.webapi.request.C8439e;
import com.huawei.phoneservice.faqcommon.webapi.request.C8440f;
import com.huawei.phoneservice.faqcommon.webapi.request.FaqKnowledgeRequest;
import com.huawei.phoneservice.faqcommon.webapi.request.FaqSearchRequest;
import p692uw.C13264g;
import p692uw.C13267j;

/* loaded from: classes4.dex */
public final class FaqApi extends FaqRestClient {

    /* renamed from: b */
    public static final C8447a f39431b = new C8447a(null);

    /* renamed from: c */
    public static Context f39432c;

    /* renamed from: d */
    public static volatile FaqApi f39433d;

    /* renamed from: a */
    public Context f39434a;

    /* renamed from: com.huawei.phoneservice.faqcommon.webapi.webmanager.FaqApi$a */
    public static final class C8447a {
        public C8447a() {
        }

        public /* synthetic */ C8447a(C13264g c13264g) {
            this();
        }

        /* renamed from: a */
        public final FaqApi m52542a(Context context) {
            FaqApi.f39432c = context != null ? context.getApplicationContext() : null;
            if (FaqApi.f39433d == null) {
                FaqApi.f39433d = new FaqApi(FaqApi.f39432c);
            }
            return FaqApi.f39433d;
        }
    }

    public FaqApi(Context context) {
        super(context);
        this.f39434a = context;
    }

    /* renamed from: a */
    public final Submit m52537a(FaqKnowledgeRequest faqKnowledgeRequest, Callback callback) {
        C13267j.m79677e(faqKnowledgeRequest, TrackConstants$Opers.REQUEST);
        C13267j.m79677e(callback, "callback");
        FaqRestClient faqRestClientInitRestClientAnno = FaqRestClient.Companion.initRestClientAnno(this.f39434a);
        C13267j.m79674b(faqRestClientInitRestClientAnno);
        Context context = f39432c;
        String url = FaqUtil.getUrl(C8452a.f39451a.m52572b());
        C13267j.m79676d(url, "getUrl(FaqWebConstants.FAQTYPE_URL)");
        String json = getGson().toJson(faqKnowledgeRequest);
        C13267j.m79676d(json, "gson.toJson(request)");
        return faqRestClientInitRestClientAnno.asyncRequest(context, url, json, callback);
    }

    /* renamed from: b */
    public final Submit m52538b(FaqSearchRequest faqSearchRequest, Callback callback) {
        C13267j.m79677e(faqSearchRequest, TrackConstants$Opers.REQUEST);
        C13267j.m79677e(callback, "callback");
        FaqRestClient faqRestClientInitRestClientAnno = FaqRestClient.Companion.initRestClientAnno(this.f39434a);
        C13267j.m79674b(faqRestClientInitRestClientAnno);
        Context context = f39432c;
        String url = FaqUtil.getUrl(C8452a.f39451a.m52582l());
        C13267j.m79676d(url, "getUrl(FaqWebConstants.SEARCH_SEVER_URL)");
        String json = getGson().toJson(faqSearchRequest);
        C13267j.m79676d(json, "gson.toJson(request)");
        return faqRestClientInitRestClientAnno.asyncRequest(context, url, json, callback);
    }

    /* renamed from: c */
    public final Submit m52539c(C8435a c8435a, Callback callback) {
        C13267j.m79677e(c8435a, TrackConstants$Opers.REQUEST);
        C13267j.m79677e(callback, "callback");
        FaqRestClient faqRestClientInitRestClientAnno = FaqRestClient.Companion.initRestClientAnno(this.f39434a);
        C13267j.m79674b(faqRestClientInitRestClientAnno);
        Context context = f39432c;
        String url = FaqUtil.getUrl(C8452a.f39451a.m52571a());
        C13267j.m79676d(url, "getUrl(FaqWebConstants.FAQCLASSIFICATE_URL)");
        String json = getGson().toJson(c8435a);
        C13267j.m79676d(json, "gson.toJson(request)");
        return faqRestClientInitRestClientAnno.asyncRequest(context, url, json, callback);
    }

    /* renamed from: d */
    public final Submit m52540d(C8440f c8440f, Callback callback) {
        C13267j.m79677e(c8440f, TrackConstants$Opers.REQUEST);
        C13267j.m79677e(callback, "callback");
        FaqRestClient faqRestClientInitRestClientAnno = FaqRestClient.Companion.initRestClientAnno(this.f39434a);
        C13267j.m79674b(faqRestClientInitRestClientAnno);
        Context context = f39432c;
        String url = FaqUtil.getUrl(C8452a.f39451a.m52573c());
        C13267j.m79676d(url, "getUrl(FaqWebConstants.FAQ_DETAIL_URL)");
        String json = getGson().toJson(c8440f);
        C13267j.m79676d(json, "gson.toJson(request)");
        return faqRestClientInitRestClientAnno.asyncRequest(context, url, json, callback);
    }

    /* renamed from: e */
    public final Submit m52541e(String str, Callback callback) {
        C13267j.m79677e(callback, "callback");
        C8439e c8439e = new C8439e();
        c8439e.m52513a(str);
        FaqRestClient faqRestClientInitRestClientAnno = FaqRestClient.Companion.initRestClientAnno(this.f39434a);
        C13267j.m79674b(faqRestClientInitRestClientAnno);
        Context context = f39432c;
        String url = FaqUtil.getUrl(C8452a.f39451a.m52583m());
        C13267j.m79676d(url, "getUrl(FaqWebConstants.USER_AGREEMENT_URL)");
        String json = getGson().toJson(c8439e);
        C13267j.m79676d(json, "gson.toJson(params)");
        return faqRestClientInitRestClientAnno.asyncRequest(context, url, json, callback);
    }
}
