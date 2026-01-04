package com.huawei.phoneservice.feedbackcommon.network;

import android.content.Context;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.hms.framework.network.restclient.Headers;
import com.huawei.hms.framework.network.restclient.hwhttp.Callback;
import com.huawei.hms.framework.network.restclient.hwhttp.Submit;
import com.huawei.phoneservice.faq.base.constants.TrackConstants$Opers;
import com.huawei.phoneservice.faq.base.network.FaqRestClient;
import com.huawei.phoneservice.faq.base.util.FaqLogger;
import com.huawei.phoneservice.faq.base.util.FaqSdk;
import com.huawei.phoneservice.faq.base.util.FaqUtil;
import com.huawei.phoneservice.feedbackcommon.entity.C8614b0;
import com.huawei.phoneservice.feedbackcommon.entity.C8637w;
import com.huawei.phoneservice.feedbackcommon.entity.C8638x;
import com.huawei.phoneservice.feedbackcommon.entity.C8639y;
import java.io.File;
import java.util.Map;
import p692uw.C13264g;
import p692uw.C13267j;

/* loaded from: classes5.dex */
public final class FeedbackUploadApi extends FaqRestClient {

    /* renamed from: b */
    public static final C8642a f40231b = new C8642a(null);

    /* renamed from: c */
    public static Context f40232c;

    /* renamed from: d */
    public static volatile FeedbackUploadApi f40233d;

    /* renamed from: a */
    public Context f40234a;

    /* renamed from: com.huawei.phoneservice.feedbackcommon.network.FeedbackUploadApi$a */
    public static final class C8642a {
        public C8642a() {
        }

        public /* synthetic */ C8642a(C13264g c13264g) {
            this();
        }

        /* renamed from: a */
        public final FeedbackUploadApi m53290a(Context context) {
            FeedbackUploadApi.f40232c = context != null ? context.getApplicationContext() : null;
            if (FeedbackUploadApi.f40233d == null) {
                FeedbackUploadApi.f40233d = new FeedbackUploadApi(FeedbackUploadApi.f40232c);
            }
            return FeedbackUploadApi.f40233d;
        }
    }

    public FeedbackUploadApi(Context context) {
        super(context);
        this.f40234a = context;
    }

    /* renamed from: a */
    public final Submit m53277a(C8614b0 c8614b0, Callback callback) {
        C13267j.m79677e(c8614b0, "info");
        C13267j.m79677e(callback, "callback");
        FaqRestClient faqRestClientInitRestClientAnno = FaqRestClient.Companion.initRestClientAnno(this.f40234a);
        C13267j.m79674b(faqRestClientInitRestClientAnno);
        Context context = f40232c;
        String url = FaqUtil.getUrl(FeedbackWebConstants.QUESTION_FEEDBACK_SUBMIT);
        C13267j.m79676d(url, "getUrl(FeedbackWebConsta…QUESTION_FEEDBACK_SUBMIT)");
        String json = getGson().toJson(c8614b0);
        C13267j.m79676d(json, "gson.toJson(info)");
        return faqRestClientInitRestClientAnno.asyncRequest(context, url, json, callback);
    }

    /* renamed from: b */
    public final Submit m53278b(String str, Callback callback) {
        C13267j.m79677e(callback, "callback");
        C8637w c8637w = new C8637w(str);
        FaqRestClient faqRestClientInitRestClientAnno = FaqRestClient.Companion.initRestClientAnno(this.f40234a);
        C13267j.m79674b(faqRestClientInitRestClientAnno);
        Context context = f40232c;
        String url = FaqUtil.getUrl(FeedbackWebConstants.REQUEST_ISO_LANGUAGE_URL);
        C13267j.m79676d(url, "getUrl(FeedbackWebConsta…REQUEST_ISO_LANGUAGE_URL)");
        String json = getGson().toJson(c8637w);
        C13267j.m79676d(json, "gson.toJson(queryIsoLanguageRequest)");
        return faqRestClientInitRestClientAnno.asyncRequest(context, url, json, callback);
    }

    /* renamed from: c */
    public final Submit m53279c(String str, String str2, String str3, String str4, Callback callback) {
        C13267j.m79677e(callback, "callback");
        C8639y c8639y = new C8639y(str4, str, str2, str3);
        FaqRestClient faqRestClientInitRestClientAnno = FaqRestClient.Companion.initRestClientAnno(this.f40234a);
        C13267j.m79674b(faqRestClientInitRestClientAnno);
        Context context = f40232c;
        String url = FaqUtil.getUrl(FeedbackWebConstants.REQUEST_QUESTION_TYPE_URL);
        C13267j.m79676d(url, "getUrl(FeedbackWebConsta…EQUEST_QUESTION_TYPE_URL)");
        String json = getGson().toJson(c8639y);
        C13267j.m79676d(json, "gson.toJson(questTypeRequest)");
        return faqRestClientInitRestClientAnno.asyncRequest(context, url, json, callback);
    }

    /* renamed from: d */
    public final Submit m53280d(String str, Map<String, String> map, File file, String str2, String str3) throws Throwable {
        C13267j.m79677e(str, "mUrl");
        C13267j.m79677e(map, "upload");
        C13267j.m79677e(file, CloudBackupConstant.Command.PMS_OPTION_ONE_FILE);
        C13267j.m79677e(str2, "methodUpload");
        C13267j.m79677e(str3, "contentType");
        FaqLogger.m51837d("XCallback", "getFileUploadToService header is : " + map, new Object[0]);
        FaqRestClient faqRestClientInitRestClientAnno = FaqRestClient.Companion.initRestClientAnno(this.f40234a);
        C13267j.m79674b(faqRestClientInitRestClientAnno);
        return faqRestClientInitRestClientAnno.uploadZipFileToService(f40232c, str, map, str3, file, str2);
    }

    /* renamed from: e */
    public final Submit m53281e(Map<String, String> map, String str, Callback callback) throws Throwable {
        C13267j.m79677e(map, "headerMap");
        C13267j.m79677e(str, TrackConstants$Opers.REQUEST);
        C13267j.m79677e(callback, "callback");
        FaqLogger.m51837d("XCallback", "feedbackNotifySuccess header is : " + map, new Object[0]);
        FaqRestClient faqRestClientInitRestClientAnno = FaqRestClient.Companion.initRestClientAnno(this.f40234a);
        C13267j.m79674b(faqRestClientInitRestClientAnno);
        Context context = f40232c;
        String str2 = FaqUtil.getYunAddress() + FeedbackWebConstants.FEEDBACK_NOTIFY_SUCCESS;
        Headers headersM32363of = Headers.m32363of(map);
        C13267j.m79676d(headersM32363of, "of(headerMap)");
        return faqRestClientInitRestClientAnno.asyncRequestWithJson(context, str2, str, headersM32363of, callback);
    }

    /* renamed from: f */
    public final Submit m53282f(Map<String, String> map, String str, String str2, Callback callback) throws Throwable {
        C13267j.m79677e(map, "domainMap");
        C13267j.m79677e(str, "domainRequest");
        C13267j.m79677e(str2, "appId");
        C13267j.m79677e(callback, "callback");
        FaqLogger.m51837d("XCallback", "getServerDomain header is : " + map, new Object[0]);
        FaqRestClient faqRestClientInitRestClientAnno = FaqRestClient.Companion.initRestClientAnno(this.f40234a);
        C13267j.m79674b(faqRestClientInitRestClientAnno);
        Context context = f40232c;
        String str3 = FaqUtil.getLogserviceUrl() + FeedbackWebConstants.SERVER_DOMAIN + str2;
        Headers headersM32363of = Headers.m32363of(map);
        C13267j.m79676d(headersM32363of, "of(domainMap)");
        return faqRestClientInitRestClientAnno.asyncRequestWitHead(context, str3, headersM32363of, str, callback);
    }

    /* renamed from: g */
    public final Submit m53283g(Map<String, String> map, String str, String str2, String str3) throws Throwable {
        C13267j.m79677e(map, "map");
        C13267j.m79677e(str, "newUploadRequest");
        C13267j.m79677e(str2, "appId");
        C13267j.m79677e(str3, "serverDomain");
        FaqLogger.m51837d("XCallback", "getNewUploadInfo header is : " + map, new Object[0]);
        FaqRestClient faqRestClientInitRestClientAnno = FaqRestClient.Companion.initRestClientAnno(this.f40234a);
        C13267j.m79674b(faqRestClientInitRestClientAnno);
        return faqRestClientInitRestClientAnno.uploadZipFile(f40232c, str3 + FeedbackWebConstants.NEW_UPLOAD_INFO + str2, map, null, null, str);
    }

    /* renamed from: h */
    public final Submit m53284h(Map<String, String> map, String str, String str2, String str3, Callback callback) throws Throwable {
        C13267j.m79677e(map, "notifyUploadSuccMap");
        C13267j.m79677e(str2, "appId");
        C13267j.m79677e(str3, "serverDomain");
        C13267j.m79677e(callback, "callback");
        FaqLogger.m51837d("XCallback", "getNotifyUploadSucc header is : " + map, new Object[0]);
        FaqRestClient faqRestClientInitRestClientAnno = FaqRestClient.Companion.initRestClientAnno(this.f40234a);
        C13267j.m79674b(faqRestClientInitRestClientAnno);
        Context context = f40232c;
        String str4 = str3 + FeedbackWebConstants.NOTIFY_UPLOAD_SUCC + str2;
        Headers headersM32363of = Headers.m32363of(map);
        C13267j.m79676d(headersM32363of, "of(notifyUploadSuccMap)");
        return faqRestClientInitRestClientAnno.asyncRequestWitHead(context, str4, headersM32363of, str, callback);
    }

    /* renamed from: m */
    public final Submit m53285m(C8614b0 c8614b0, Callback callback) {
        C13267j.m79677e(c8614b0, "info");
        C13267j.m79677e(callback, "callback");
        FaqRestClient faqRestClientInitRestClientAnno = FaqRestClient.Companion.initRestClientAnno(this.f40234a);
        C13267j.m79674b(faqRestClientInitRestClientAnno);
        Context context = f40232c;
        String url = FaqUtil.getUrl(FeedbackWebConstants.QUESTION_FEEDBACK_SUBMIT_FORHD);
        C13267j.m79676d(url, "getUrl(FeedbackWebConsta…ON_FEEDBACK_SUBMIT_FORHD)");
        String json = getGson().toJson(c8614b0);
        C13267j.m79676d(json, "gson.toJson(info)");
        return faqRestClientInitRestClientAnno.asyncRequest(context, url, json, callback);
    }

    /* renamed from: n */
    public final Submit m53286n(String str, Callback callback) {
        C13267j.m79677e(callback, "callback");
        C8638x c8638x = new C8638x(FaqSdk.getSdk().getSdk("country"), str);
        FaqRestClient faqRestClientInitRestClientAnno = FaqRestClient.Companion.initRestClientAnno(this.f40234a);
        C13267j.m79674b(faqRestClientInitRestClientAnno);
        Context context = f40232c;
        String url = FaqUtil.getUrl(FeedbackWebConstants.REQUEST_PRIVACY_NOTICE_URL);
        C13267j.m79676d(url, "getUrl(FeedbackWebConsta…QUEST_PRIVACY_NOTICE_URL)");
        String json = getGson().toJson(c8638x);
        C13267j.m79676d(json, "gson.toJson(queryNoticeRequest)");
        return faqRestClientInitRestClientAnno.asyncRequest(context, url, json, callback);
    }

    /* renamed from: o */
    public final Submit m53287o(Map<String, String> map, String str, Callback callback) throws Throwable {
        C13267j.m79677e(map, "headerMap");
        C13267j.m79677e(str, TrackConstants$Opers.REQUEST);
        C13267j.m79677e(callback, "callback");
        FaqLogger.m51837d("XCallback", "getFeedbackNewUploadInfo header is : " + map, new Object[0]);
        FaqRestClient faqRestClientInitRestClientAnno = FaqRestClient.Companion.initRestClientAnno(this.f40234a);
        C13267j.m79674b(faqRestClientInitRestClientAnno);
        Context context = f40232c;
        String str2 = FaqUtil.getYunAddress() + FeedbackWebConstants.FEEDBACK_NEW_UPLOAD_INFO;
        Headers headersM32363of = Headers.m32363of(map);
        C13267j.m79676d(headersM32363of, "of(headerMap)");
        return faqRestClientInitRestClientAnno.asyncRequestWithJson(context, str2, str, headersM32363of, callback);
    }

    /* renamed from: p */
    public final Submit m53288p(Map<String, String> map, String str, String str2, String str3, Callback callback) throws Throwable {
        C13267j.m79677e(map, "uploadMap");
        C13267j.m79677e(str2, "appId");
        C13267j.m79677e(str3, "mServerDomain");
        C13267j.m79677e(callback, "callback");
        FaqLogger.m51837d("XCallback", "getUploadInfo header is : " + map, new Object[0]);
        FaqRestClient faqRestClientInitRestClientAnno = FaqRestClient.Companion.initRestClientAnno(this.f40234a);
        C13267j.m79674b(faqRestClientInitRestClientAnno);
        Context context = f40232c;
        String str4 = str3 + FeedbackWebConstants.UPLOAD_INFO + str2;
        Headers headersM32363of = Headers.m32363of(map);
        C13267j.m79676d(headersM32363of, "of(uploadMap)");
        return faqRestClientInitRestClientAnno.asyncRequestWitHead(context, str4, headersM32363of, str, callback);
    }

    /* renamed from: q */
    public final Submit m53289q(Map<String, String> map, String str, Callback callback) throws Throwable {
        C13267j.m79677e(map, "headerMap");
        C13267j.m79677e(str, TrackConstants$Opers.REQUEST);
        C13267j.m79677e(callback, "callback");
        FaqLogger.m51837d("XCallback", "getFeedbackUploadInfo header is : " + map, new Object[0]);
        FaqRestClient faqRestClientInitRestClientAnno = FaqRestClient.Companion.initRestClientAnno(this.f40234a);
        C13267j.m79674b(faqRestClientInitRestClientAnno);
        Context context = f40232c;
        String str2 = FaqUtil.getYunAddress() + FeedbackWebConstants.FEEDBACK_UPLOAD_INFO;
        Headers headersM32363of = Headers.m32363of(map);
        C13267j.m79676d(headersM32363of, "of(headerMap)");
        return faqRestClientInitRestClientAnno.asyncRequestWithJson(context, str2, str, headersM32363of, callback);
    }
}
