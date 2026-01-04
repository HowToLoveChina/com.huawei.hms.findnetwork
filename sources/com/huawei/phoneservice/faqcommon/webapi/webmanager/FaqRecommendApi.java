package com.huawei.phoneservice.faqcommon.webapi.webmanager;

import android.content.Context;
import com.huawei.hms.framework.network.restclient.hwhttp.Callback;
import com.huawei.hms.framework.network.restclient.hwhttp.Submit;
import com.huawei.phoneservice.faq.base.constants.TrackConstants$Opers;
import com.huawei.phoneservice.faq.base.network.FaqRestClient;
import com.huawei.phoneservice.faq.base.util.FaqUtil;
import com.huawei.phoneservice.faqcommon.webapi.request.FaqRecommendKnowledgeRequest;
import p692uw.C13264g;
import p692uw.C13267j;

/* loaded from: classes4.dex */
public final class FaqRecommendApi extends FaqRestClient {

    /* renamed from: b */
    public static final C8449a f39439b = new C8449a(null);

    /* renamed from: c */
    public static Context f39440c;

    /* renamed from: d */
    public static volatile FaqRecommendApi f39441d;

    /* renamed from: a */
    public Context f39442a;

    /* renamed from: com.huawei.phoneservice.faqcommon.webapi.webmanager.FaqRecommendApi$a */
    public static final class C8449a {
        public C8449a() {
        }

        public /* synthetic */ C8449a(C13264g c13264g) {
            this();
        }

        /* renamed from: a */
        public final FaqRecommendApi m52557a(Context context) {
            FaqRecommendApi.f39440c = context != null ? context.getApplicationContext() : null;
            if (FaqRecommendApi.f39441d == null) {
                FaqRecommendApi.f39441d = new FaqRecommendApi(FaqRecommendApi.f39440c);
            }
            return FaqRecommendApi.f39441d;
        }
    }

    public FaqRecommendApi(Context context) {
        super(context);
        this.f39442a = context;
    }

    /* renamed from: a */
    public final Submit m52556a(FaqRecommendKnowledgeRequest faqRecommendKnowledgeRequest, Callback callback) {
        C13267j.m79677e(faqRecommendKnowledgeRequest, TrackConstants$Opers.REQUEST);
        C13267j.m79677e(callback, "callback");
        FaqRestClient faqRestClientInitRestClientAnno = FaqRestClient.Companion.initRestClientAnno(this.f39442a);
        C13267j.m79674b(faqRestClientInitRestClientAnno);
        Context context = f39440c;
        String url = FaqUtil.getUrl(C8452a.f39451a.m52577g());
        C13267j.m79676d(url, "getUrl(FaqWebConstants.FAQ_RECOMMEND_URL)");
        String json = getGson().toJson(faqRecommendKnowledgeRequest);
        C13267j.m79676d(json, "gson.toJson(request)");
        return faqRestClientInitRestClientAnno.asyncRequest(context, url, json, callback);
    }
}
