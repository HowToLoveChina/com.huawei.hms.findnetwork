package com.huawei.phoneservice.feedbackcommon.network;

import android.content.Context;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.hms.framework.network.restclient.hwhttp.Callback;
import com.huawei.hms.framework.network.restclient.hwhttp.Submit;
import com.huawei.hms.network.httpclient.ResponseBody;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.phoneservice.faq.base.constants.TrackConstants$Opers;
import com.huawei.phoneservice.faq.base.network.FaqRestClient;
import com.huawei.phoneservice.faq.base.util.FaqUtil;
import com.huawei.phoneservice.feedbackcommon.entity.C8613b;
import com.huawei.phoneservice.feedbackcommon.entity.C8627m;
import com.huawei.phoneservice.feedbackcommon.entity.FeedBackRateRequest;
import com.huawei.phoneservice.feedbackcommon.entity.FeedBackRequest;
import com.huawei.phoneservice.feedbackcommon.utils.SdkProblemManager;
import java.io.File;
import p692uw.C13264g;
import p692uw.C13267j;

/* loaded from: classes5.dex */
public final class ProblemSuggestApi extends FaqRestClient {

    /* renamed from: b */
    public static final C8644a f40239b = new C8644a(null);

    /* renamed from: c */
    public static Context f40240c;

    /* renamed from: d */
    public static volatile ProblemSuggestApi f40241d;

    /* renamed from: a */
    public Context f40242a;

    /* renamed from: com.huawei.phoneservice.feedbackcommon.network.ProblemSuggestApi$a */
    public static final class C8644a {
        public C8644a() {
        }

        public /* synthetic */ C8644a(C13264g c13264g) {
            this();
        }

        /* renamed from: a */
        public final ProblemSuggestApi m53308a(Context context) {
            ProblemSuggestApi.f40240c = context != null ? context.getApplicationContext() : null;
            if (ProblemSuggestApi.f40241d == null) {
                ProblemSuggestApi.f40241d = new ProblemSuggestApi(ProblemSuggestApi.f40240c);
            }
            return ProblemSuggestApi.f40241d;
        }
    }

    public ProblemSuggestApi(Context context) {
        super(context);
        this.f40242a = context;
    }

    /* renamed from: a */
    public final Submit m53302a(FeedBackRateRequest feedBackRateRequest, Callback callback) {
        C13267j.m79677e(feedBackRateRequest, TrackConstants$Opers.REQUEST);
        C13267j.m79677e(callback, "callback");
        FaqRestClient faqRestClientInitRestClientAnno = FaqRestClient.Companion.initRestClientAnno(this.f40242a);
        C13267j.m79674b(faqRestClientInitRestClientAnno);
        Context context = f40240c;
        String url = FaqUtil.getUrl(FeedbackWebConstants.RATE_URL);
        C13267j.m79676d(url, "getUrl(FeedbackWebConstants.RATE_URL)");
        String json = getGson().toJson(feedBackRateRequest);
        C13267j.m79676d(json, "gson.toJson(request)");
        return faqRestClientInitRestClientAnno.asyncRequest(context, url, json, callback);
    }

    /* renamed from: b */
    public final Submit m53303b(FeedBackRequest feedBackRequest, Callback callback) {
        C13267j.m79677e(feedBackRequest, TrackConstants$Opers.REQUEST);
        C13267j.m79677e(callback, "callback");
        FaqRestClient faqRestClientInitRestClientAnno = FaqRestClient.Companion.initRestClientAnno(this.f40242a);
        C13267j.m79674b(faqRestClientInitRestClientAnno);
        Context context = f40240c;
        String url = FaqUtil.getUrl(FeedbackWebConstants.FEEDBACK_DETAIL_URL);
        C13267j.m79676d(url, "getUrl(FeedbackWebConstants.FEEDBACK_DETAIL_URL)");
        String json = getGson().toJson(feedBackRequest);
        C13267j.m79676d(json, "gson.toJson(request)");
        return faqRestClientInitRestClientAnno.asyncRequest(context, url, json, callback);
    }

    /* renamed from: c */
    public final Submit m53304c(C8613b c8613b, Callback callback) {
        C13267j.m79677e(c8613b, TrackConstants$Opers.REQUEST);
        C13267j.m79677e(callback, "callback");
        FaqRestClient faqRestClientInitRestClientAnno = FaqRestClient.Companion.initRestClientAnno(this.f40242a);
        C13267j.m79674b(faqRestClientInitRestClientAnno);
        Context context = f40240c;
        String url = FaqUtil.getUrl(FeedbackWebConstants.DELETE_HISTORY_URL);
        C13267j.m79676d(url, "getUrl(FeedbackWebConstants.DELETE_HISTORY_URL)");
        String json = getGson().toJson(c8613b);
        C13267j.m79676d(json, "gson.toJson(request)");
        return faqRestClientInitRestClientAnno.asyncRequest(context, url, json, callback);
    }

    /* renamed from: d */
    public final Submit m53305d(C8627m c8627m, Callback callback) {
        C13267j.m79677e(c8627m, TrackConstants$Opers.REQUEST);
        C13267j.m79677e(callback, "callback");
        FaqRestClient faqRestClientInitRestClientAnno = FaqRestClient.Companion.initRestClientAnno(this.f40242a);
        C13267j.m79674b(faqRestClientInitRestClientAnno);
        Context context = f40240c;
        String url = FaqUtil.getUrl(FeedbackWebConstants.QUERY_FEEDBACK_FORHD);
        C13267j.m79676d(url, "getUrl(FeedbackWebConstants.QUERY_FEEDBACK_FORHD)");
        String json = getGson().toJson(c8627m);
        C13267j.m79676d(json, "gson.toJson(request)");
        return faqRestClientInitRestClientAnno.asyncRequest(context, url, json, callback);
    }

    /* renamed from: e */
    public final com.huawei.hms.network.httpclient.Submit<ResponseBody> m53306e(File file, String str, String str2, com.huawei.hms.network.httpclient.Callback<ResponseBody> callback) {
        C13267j.m79677e(file, CloudBackupConstant.Command.PMS_OPTION_ONE_FILE);
        C13267j.m79677e(callback, "callback");
        String str3 = C13267j.m79673a("2", SdkProblemManager.getSdk().getSdk(FaqConstants.FAQ_UPLOAD_FLAG)) ? FeedbackWebConstants.PROBLEM_SUGGEST_FILES_URL : FeedbackWebConstants.PROBLEM_SUGGEST_FILES_URL_V2;
        FaqRestClient faqRestClientInitRestClientAnno = FaqRestClient.Companion.initRestClientAnno(this.f40242a);
        C13267j.m79674b(faqRestClientInitRestClientAnno);
        return faqRestClientInitRestClientAnno.uploadAttachs(f40240c, FaqUtil.getYunAddress() + str3, str2, str, file, callback);
    }

    /* renamed from: j */
    public final Submit m53307j(FeedBackRequest feedBackRequest, Callback callback) {
        C13267j.m79677e(feedBackRequest, "feedBackRequest");
        C13267j.m79677e(callback, "callback");
        FaqRestClient faqRestClientInitRestClientAnno = FaqRestClient.Companion.initRestClientAnno(this.f40242a);
        C13267j.m79674b(faqRestClientInitRestClientAnno);
        Context context = f40240c;
        String url = FaqUtil.getUrl(FeedbackWebConstants.HISTORY_FEEDBACK_URL);
        C13267j.m79676d(url, "getUrl(FeedbackWebConstants.HISTORY_FEEDBACK_URL)");
        String json = getGson().toJson(feedBackRequest);
        C13267j.m79676d(json, "gson.toJson(feedBackRequest)");
        return faqRestClientInitRestClientAnno.asyncRequest(context, url, json, callback);
    }
}
