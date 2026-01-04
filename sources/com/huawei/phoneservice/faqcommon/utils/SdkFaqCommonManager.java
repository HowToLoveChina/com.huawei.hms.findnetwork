package com.huawei.phoneservice.faqcommon.utils;

import android.content.Context;
import androidx.annotation.Keep;
import ax.C1046p;
import com.huawei.feedback.constant.FeedbackConst;
import com.huawei.hms.framework.network.restclient.hwhttp.Callback;
import com.huawei.hms.framework.network.restclient.hwhttp.Submit;
import com.huawei.openalliance.p169ad.constant.ParamConstants;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.phoneservice.faq.base.constants.TrackConstants$Opers;
import com.huawei.phoneservice.faq.base.util.FaqSdk;
import com.huawei.phoneservice.faqcommon.webapi.request.C8435a;
import com.huawei.phoneservice.faqcommon.webapi.request.C8436b;
import com.huawei.phoneservice.faqcommon.webapi.request.C8437c;
import com.huawei.phoneservice.faqcommon.webapi.request.C8438d;
import com.huawei.phoneservice.faqcommon.webapi.request.C8440f;
import com.huawei.phoneservice.faqcommon.webapi.request.C8441g;
import com.huawei.phoneservice.faqcommon.webapi.request.C8442h;
import com.huawei.phoneservice.faqcommon.webapi.request.C8443i;
import com.huawei.phoneservice.faqcommon.webapi.request.C8444j;
import com.huawei.phoneservice.faqcommon.webapi.request.FaqKnowledgeRequest;
import com.huawei.phoneservice.faqcommon.webapi.request.FaqRecommendKnowledgeRequest;
import com.huawei.phoneservice.faqcommon.webapi.request.FaqSearchRequest;
import com.huawei.phoneservice.faqcommon.webapi.webmanager.FaqApi;
import com.huawei.phoneservice.faqcommon.webapi.webmanager.FaqEvaluateApi;
import com.huawei.phoneservice.faqcommon.webapi.webmanager.FaqRecommendApi;
import com.huawei.phoneservice.faqcommon.webapi.webmanager.FaqStatisticsApi;
import com.huawei.phoneservice.faqcommon.webapi.webmanager.SearchApi;
import java.util.List;
import p692uw.C13267j;

@Keep
/* loaded from: classes4.dex */
public final class SdkFaqCommonManager implements IFaqCommonManager {
    public static final SdkFaqCommonManager INSTANCE = new SdkFaqCommonManager();

    private SdkFaqCommonManager() {
    }

    public final Submit faqEvaluateSubmit(Context context, String str, String str2, String str3, Callback callback) {
        C13267j.m79677e(context, ParamConstants.Param.CONTEXT);
        C13267j.m79677e(callback, "callback");
        C8438d c8438d = new C8438d();
        c8438d.m52508a("10003");
        c8438d.m52509b(FaqSdk.getSdk().getSdk("country"));
        c8438d.m52510c(str);
        c8438d.m52511d(str2);
        c8438d.m52512e(str3);
        FaqEvaluateApi faqEvaluateApiM52551a = FaqEvaluateApi.f39435b.m52551a(context);
        C13267j.m79674b(faqEvaluateApiM52551a);
        return faqEvaluateApiM52551a.m52549c(c8438d, callback);
    }

    @Override // com.huawei.phoneservice.faqcommon.utils.IFaqCommonManager
    public Submit getFAQKnowledge(Context context, FaqKnowledgeRequest faqKnowledgeRequest, Callback callback) {
        C13267j.m79677e(context, ParamConstants.Param.CONTEXT);
        C13267j.m79677e(faqKnowledgeRequest, TrackConstants$Opers.REQUEST);
        C13267j.m79677e(callback, "callback");
        FaqApi faqApiM52542a = FaqApi.f39431b.m52542a(context);
        C13267j.m79674b(faqApiM52542a);
        return faqApiM52542a.m52537a(faqKnowledgeRequest, callback);
    }

    @Override // com.huawei.phoneservice.faqcommon.utils.IFaqCommonManager
    public Submit getFAQRecommendKnowledge(Context context, FaqRecommendKnowledgeRequest faqRecommendKnowledgeRequest, Callback callback) {
        C13267j.m79677e(context, ParamConstants.Param.CONTEXT);
        C13267j.m79677e(faqRecommendKnowledgeRequest, TrackConstants$Opers.REQUEST);
        C13267j.m79677e(callback, "callback");
        FaqRecommendApi faqRecommendApiM52557a = FaqRecommendApi.f39439b.m52557a(context);
        C13267j.m79674b(faqRecommendApiM52557a);
        return faqRecommendApiM52557a.m52556a(faqRecommendKnowledgeRequest, callback);
    }

    @Override // com.huawei.phoneservice.faqcommon.utils.IFaqCommonManager
    public Submit getFAQType(Context context, String str, String str2, String str3, String str4, String str5, String str6, Callback callback) {
        C13267j.m79677e(context, ParamConstants.Param.CONTEXT);
        C13267j.m79677e(callback, "callback");
        C8435a c8435a = new C8435a();
        c8435a.m52499b(str);
        c8435a.m52502e(str2);
        c8435a.m52498a(str3);
        c8435a.m52503f(str4);
        c8435a.m52500c(str5);
        c8435a.m52501d(str6);
        FaqApi faqApiM52542a = FaqApi.f39431b.m52542a(context);
        C13267j.m79674b(faqApiM52542a);
        return faqApiM52542a.m52539c(c8435a, callback);
    }

    @Override // com.huawei.phoneservice.faqcommon.utils.IFaqCommonManager
    public Submit getFaqEvaluateKnowledge(Context context, String str, String str2, String str3, Callback callback) {
        C13267j.m79677e(context, ParamConstants.Param.CONTEXT);
        C13267j.m79677e(callback, "callback");
        C8437c c8437c = new C8437c();
        c8437c.m52505a(str3);
        c8437c.m52506b(str);
        c8437c.m52507c(str2);
        FaqEvaluateApi faqEvaluateApiM52551a = FaqEvaluateApi.f39435b.m52551a(context);
        C13267j.m79674b(faqEvaluateApiM52551a);
        return faqEvaluateApiM52551a.m52548b(c8437c, callback);
    }

    public final Submit getFaqEvaluateList(Context context, String str, Callback callback) {
        C13267j.m79677e(context, ParamConstants.Param.CONTEXT);
        C13267j.m79677e(callback, "callback");
        C8436b c8436b = new C8436b();
        c8436b.m52504a(str);
        FaqEvaluateApi faqEvaluateApiM52551a = FaqEvaluateApi.f39435b.m52551a(context);
        C13267j.m79674b(faqEvaluateApiM52551a);
        return faqEvaluateApiM52551a.m52547a(c8436b, callback);
    }

    public final Submit getFaqSiteCode(Context context, Callback callback) {
        String str;
        List listM6266C;
        C13267j.m79677e(context, ParamConstants.Param.CONTEXT);
        C13267j.m79677e(callback, "callback");
        C8441g c8441g = new C8441g();
        String sdk = FaqSdk.getSdk().getSdk("country");
        c8441g.m52515a(sdk);
        if (C13267j.m79673a("CN", sdk)) {
            str = FeedbackConst.SDK.EMUI_LANGUAGE;
        } else {
            if (!C13267j.m79673a("HK", sdk) && !C13267j.m79673a("TW", sdk)) {
                String sdk2 = FaqSdk.getSdk().getSdk(FaqConstants.FAQ_EMUI_LANGUAGE);
                if (sdk2 != null) {
                    if (C1046p.m6272k(sdk2, "-", false, 2, null)) {
                        listM6266C = C1046p.m6266C(sdk2, new String[]{"-"}, false, 0, 6, null);
                    } else {
                        if (C1046p.m6272k(sdk2, "_", false, 2, null)) {
                            listM6266C = C1046p.m6266C(sdk2, new String[]{"_"}, false, 0, 6, null);
                        }
                        c8441g.m52516b(sdk2);
                    }
                    sdk2 = (String) listM6266C.get(0);
                    c8441g.m52516b(sdk2);
                }
                FaqEvaluateApi faqEvaluateApiM52551a = FaqEvaluateApi.f39435b.m52551a(context);
                C13267j.m79674b(faqEvaluateApiM52551a);
                return faqEvaluateApiM52551a.m52550d(c8441g, callback);
            }
            str = "zh-tw";
        }
        c8441g.m52516b(str);
        FaqEvaluateApi faqEvaluateApiM52551a2 = FaqEvaluateApi.f39435b.m52551a(context);
        C13267j.m79674b(faqEvaluateApiM52551a2);
        return faqEvaluateApiM52551a2.m52550d(c8441g, callback);
    }

    @Override // com.huawei.phoneservice.faqcommon.utils.IFaqCommonManager
    public Submit getFaqStatisticsKnowledge(Context context, String str, String str2, String str3, Callback callback) {
        C13267j.m79677e(context, ParamConstants.Param.CONTEXT);
        C13267j.m79677e(callback, "callback");
        C8442h c8442h = new C8442h();
        c8442h.m52518b(str);
        c8442h.m52517a(str3);
        c8442h.m52519c(str2);
        FaqStatisticsApi faqStatisticsApiM52563a = FaqStatisticsApi.f39443b.m52563a(context);
        C13267j.m79674b(faqStatisticsApiM52563a);
        return faqStatisticsApiM52563a.m52562a(c8442h, callback);
    }

    @Override // com.huawei.phoneservice.faqcommon.utils.IFaqCommonManager
    public Submit getLanguageCode(Context context, String str, Callback callback) {
        C13267j.m79677e(context, ParamConstants.Param.CONTEXT);
        C13267j.m79677e(callback, "callback");
        FaqApi faqApiM52542a = FaqApi.f39431b.m52542a(context);
        C13267j.m79674b(faqApiM52542a);
        return faqApiM52542a.m52541e(str, callback);
    }

    @Override // com.huawei.phoneservice.faqcommon.utils.IFaqCommonManager
    public Submit getRecommendDetails(Context context, String str, Callback callback) {
        C13267j.m79677e(context, ParamConstants.Param.CONTEXT);
        C13267j.m79677e(callback, "callback");
        C8440f c8440f = new C8440f();
        c8440f.m52514a(str);
        FaqApi faqApiM52542a = FaqApi.f39431b.m52542a(context);
        C13267j.m79674b(faqApiM52542a);
        return faqApiM52542a.m52540d(c8440f, callback);
    }

    @Override // com.huawei.phoneservice.faqcommon.utils.IFaqCommonManager
    public Submit getSearchData(Context context, FaqSearchRequest faqSearchRequest, Callback callback) {
        C13267j.m79677e(context, ParamConstants.Param.CONTEXT);
        C13267j.m79677e(faqSearchRequest, TrackConstants$Opers.REQUEST);
        C13267j.m79677e(callback, "callback");
        FaqApi faqApiM52542a = FaqApi.f39431b.m52542a(context);
        C13267j.m79674b(faqApiM52542a);
        return faqApiM52542a.m52538b(faqSearchRequest, callback);
    }

    @Override // com.huawei.phoneservice.faqcommon.utils.IFaqCommonManager
    public Submit searchComplete(Context context, String str, String str2, String str3, String str4, Callback callback) {
        C13267j.m79677e(callback, "callback");
        C8444j c8444j = new C8444j();
        c8444j.m52525c(str);
        c8444j.m52526d(str2);
        c8444j.m52523a(str3);
        c8444j.m52524b(str4);
        SearchApi searchApiM52570a = SearchApi.f39447b.m52570a(context);
        C13267j.m79674b(searchApiM52570a);
        return searchApiM52570a.m52569b(c8444j, callback);
    }

    @Override // com.huawei.phoneservice.faqcommon.utils.IFaqCommonManager
    public Submit searchHotWord(Context context, String str, String str2, String str3, Callback callback) {
        C13267j.m79677e(context, ParamConstants.Param.CONTEXT);
        C13267j.m79677e(callback, "callback");
        C8443i c8443i = new C8443i();
        c8443i.m52522c(str);
        c8443i.m52520a(str2);
        c8443i.m52521b(str3);
        SearchApi searchApiM52570a = SearchApi.f39447b.m52570a(context);
        C13267j.m79674b(searchApiM52570a);
        return searchApiM52570a.m52568a(c8443i, callback);
    }
}
