package com.huawei.phoneservice.faqcommon.utils;

import android.content.Context;
import com.huawei.hms.framework.network.restclient.hwhttp.Callback;
import com.huawei.hms.framework.network.restclient.hwhttp.Submit;
import com.huawei.phoneservice.faqcommon.webapi.request.FaqKnowledgeRequest;
import com.huawei.phoneservice.faqcommon.webapi.request.FaqRecommendKnowledgeRequest;
import com.huawei.phoneservice.faqcommon.webapi.request.FaqSearchRequest;

/* loaded from: classes4.dex */
public interface IFaqCommonManager {
    Submit getFAQKnowledge(Context context, FaqKnowledgeRequest faqKnowledgeRequest, Callback callback);

    Submit getFAQRecommendKnowledge(Context context, FaqRecommendKnowledgeRequest faqRecommendKnowledgeRequest, Callback callback);

    Submit getFAQType(Context context, String str, String str2, String str3, String str4, String str5, String str6, Callback callback);

    Submit getFaqEvaluateKnowledge(Context context, String str, String str2, String str3, Callback callback);

    Submit getFaqStatisticsKnowledge(Context context, String str, String str2, String str3, Callback callback);

    Submit getLanguageCode(Context context, String str, Callback callback);

    Submit getRecommendDetails(Context context, String str, Callback callback);

    Submit getSearchData(Context context, FaqSearchRequest faqSearchRequest, Callback callback);

    Submit searchComplete(Context context, String str, String str2, String str3, String str4, Callback callback);

    Submit searchHotWord(Context context, String str, String str2, String str3, Callback callback);
}
