package com.huawei.phoneservice.feedbackcommon.utils;

import android.content.Context;
import androidx.annotation.Keep;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.hms.framework.network.restclient.hwhttp.Callback;
import com.huawei.hms.framework.network.restclient.hwhttp.Submit;
import com.huawei.hms.network.httpclient.ResponseBody;
import com.huawei.openalliance.p169ad.constant.ParamConstants;
import com.huawei.phoneservice.faq.base.constants.TrackConstants$Opers;
import com.huawei.phoneservice.feedbackcommon.entity.C8613b;
import com.huawei.phoneservice.feedbackcommon.entity.C8614b0;
import com.huawei.phoneservice.feedbackcommon.entity.C8627m;
import com.huawei.phoneservice.feedbackcommon.entity.C8630p;
import com.huawei.phoneservice.feedbackcommon.entity.C8640z;
import com.huawei.phoneservice.feedbackcommon.entity.FeedBackRateRequest;
import com.huawei.phoneservice.feedbackcommon.entity.FeedBackRequest;
import com.huawei.phoneservice.feedbackcommon.network.FaqDownloadManager;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackUploadApi;
import com.huawei.phoneservice.feedbackcommon.network.ProblemApi;
import com.huawei.phoneservice.feedbackcommon.network.ProblemSuggestApi;
import java.io.File;
import java.util.Map;
import p692uw.C13267j;

@Keep
/* loaded from: classes5.dex */
public final class FeedbackCommonManager implements IFeedbackCommonManager {
    public static final FeedbackCommonManager INSTANCE = new FeedbackCommonManager();

    private FeedbackCommonManager() {
    }

    @Override // com.huawei.phoneservice.feedbackcommon.utils.IFeedbackCommonManager
    public Submit callFeedBackService(Context context, C8614b0 c8614b0, Callback callback) {
        C13267j.m79677e(context, ParamConstants.Param.CONTEXT);
        C13267j.m79677e(c8614b0, "info");
        C13267j.m79677e(callback, "callback");
        FeedbackUploadApi feedbackUploadApiM53290a = FeedbackUploadApi.f40231b.m53290a(context);
        C13267j.m79674b(feedbackUploadApiM53290a);
        return feedbackUploadApiM53290a.m53277a(c8614b0, callback);
    }

    @Override // com.huawei.phoneservice.feedbackcommon.utils.IFeedbackCommonManager
    public Submit callService(Context context, String str, String str2, String str3, String str4, Callback callback) {
        C13267j.m79677e(context, ParamConstants.Param.CONTEXT);
        C13267j.m79677e(callback, "callback");
        FeedbackUploadApi feedbackUploadApiM53290a = FeedbackUploadApi.f40231b.m53290a(context);
        C13267j.m79674b(feedbackUploadApiM53290a);
        return feedbackUploadApiM53290a.m53279c(str, str2, str3, str4, callback);
    }

    @Override // com.huawei.phoneservice.feedbackcommon.utils.IFeedbackCommonManager
    public Submit deleteHistory(Context context, C8613b c8613b, Callback callback) {
        C13267j.m79677e(context, ParamConstants.Param.CONTEXT);
        C13267j.m79677e(c8613b, TrackConstants$Opers.REQUEST);
        C13267j.m79677e(callback, "callback");
        ProblemSuggestApi problemSuggestApiM53308a = ProblemSuggestApi.f40239b.m53308a(context);
        C13267j.m79674b(problemSuggestApiM53308a);
        return problemSuggestApiM53308a.m53304c(c8613b, callback);
    }

    @Override // com.huawei.phoneservice.feedbackcommon.utils.IFeedbackCommonManager
    public Submit downloadFile(Context context, String str, String str2, Callback callback) {
        C13267j.m79677e(context, ParamConstants.Param.CONTEXT);
        C13267j.m79677e(str, "url");
        C13267j.m79677e(str2, "token");
        C13267j.m79677e(callback, "callback");
        FaqDownloadManager faqDownloadManagerM53272a = FaqDownloadManager.f40227b.m53272a(context);
        C13267j.m79674b(faqDownloadManagerM53272a);
        return faqDownloadManagerM53272a.m53271a(str, str2, callback);
    }

    @Override // com.huawei.phoneservice.feedbackcommon.utils.IFeedbackCommonManager
    public Submit feedbackNotifySuccess(Context context, Map<String, String> map, String str, Callback callback) {
        C13267j.m79677e(context, ParamConstants.Param.CONTEXT);
        C13267j.m79677e(map, "header");
        C13267j.m79677e(str, TrackConstants$Opers.REQUEST);
        C13267j.m79677e(callback, "callback");
        FeedbackUploadApi feedbackUploadApiM53290a = FeedbackUploadApi.f40231b.m53290a(context);
        C13267j.m79674b(feedbackUploadApiM53290a);
        return feedbackUploadApiM53290a.m53281e(map, str, callback);
    }

    @Override // com.huawei.phoneservice.feedbackcommon.utils.IFeedbackCommonManager
    public Submit getDataFromDetail(Context context, FeedBackRequest feedBackRequest, Callback callback) {
        C13267j.m79677e(context, ParamConstants.Param.CONTEXT);
        C13267j.m79677e(feedBackRequest, TrackConstants$Opers.REQUEST);
        C13267j.m79677e(callback, "callback");
        ProblemSuggestApi problemSuggestApiM53308a = ProblemSuggestApi.f40239b.m53308a(context);
        C13267j.m79674b(problemSuggestApiM53308a);
        return problemSuggestApiM53308a.m53303b(feedBackRequest, callback);
    }

    @Override // com.huawei.phoneservice.feedbackcommon.utils.IFeedbackCommonManager
    public Submit getFeedBackList(Context context, FeedBackRequest feedBackRequest, Callback callback) {
        C13267j.m79677e(context, ParamConstants.Param.CONTEXT);
        C13267j.m79677e(feedBackRequest, "feedBackRequest");
        C13267j.m79677e(callback, "callback");
        ProblemSuggestApi problemSuggestApiM53308a = ProblemSuggestApi.f40239b.m53308a(context);
        C13267j.m79674b(problemSuggestApiM53308a);
        return problemSuggestApiM53308a.m53307j(feedBackRequest, callback);
    }

    @Override // com.huawei.phoneservice.feedbackcommon.utils.IFeedbackCommonManager
    public Submit getFeedbackNewUploadInfo(Context context, Map<String, String> map, String str, Callback callback) {
        C13267j.m79677e(context, ParamConstants.Param.CONTEXT);
        C13267j.m79677e(map, "header");
        C13267j.m79677e(str, TrackConstants$Opers.REQUEST);
        C13267j.m79677e(callback, "callback");
        FeedbackUploadApi feedbackUploadApiM53290a = FeedbackUploadApi.f40231b.m53290a(context);
        C13267j.m79674b(feedbackUploadApiM53290a);
        return feedbackUploadApiM53290a.m53287o(map, str, callback);
    }

    @Override // com.huawei.phoneservice.feedbackcommon.utils.IFeedbackCommonManager
    public Submit getFeedbackUploadInfo(Context context, Map<String, String> map, String str, Callback callback) {
        C13267j.m79677e(context, ParamConstants.Param.CONTEXT);
        C13267j.m79677e(map, "header");
        C13267j.m79677e(str, TrackConstants$Opers.REQUEST);
        C13267j.m79677e(callback, "callback");
        FeedbackUploadApi feedbackUploadApiM53290a = FeedbackUploadApi.f40231b.m53290a(context);
        C13267j.m79674b(feedbackUploadApiM53290a);
        return feedbackUploadApiM53290a.m53289q(map, str, callback);
    }

    @Override // com.huawei.phoneservice.feedbackcommon.utils.IFeedbackCommonManager
    public Submit getFileUploadToService(Context context, String str, Map<String, String> map, File file, String str2, String str3) {
        C13267j.m79677e(context, ParamConstants.Param.CONTEXT);
        C13267j.m79677e(str, "mUrl");
        C13267j.m79677e(map, "upload");
        C13267j.m79677e(file, CloudBackupConstant.Command.PMS_OPTION_ONE_FILE);
        C13267j.m79677e(str2, "methodUpload");
        C13267j.m79677e(str3, "contentType");
        FeedbackUploadApi feedbackUploadApiM53290a = FeedbackUploadApi.f40231b.m53290a(context);
        C13267j.m79674b(feedbackUploadApiM53290a);
        return feedbackUploadApiM53290a.m53280d(str, map, file, str2, str3);
    }

    @Override // com.huawei.phoneservice.feedbackcommon.utils.IFeedbackCommonManager
    public Submit getNewUploadInfo(Context context, Map<String, String> map, String str, String str2, String str3) {
        C13267j.m79677e(context, ParamConstants.Param.CONTEXT);
        C13267j.m79677e(map, "map");
        C13267j.m79677e(str, "newUploadRequest");
        C13267j.m79677e(str2, "appId");
        C13267j.m79677e(str3, "serverDomain");
        FeedbackUploadApi feedbackUploadApiM53290a = FeedbackUploadApi.f40231b.m53290a(context);
        C13267j.m79674b(feedbackUploadApiM53290a);
        return feedbackUploadApiM53290a.m53283g(map, str, str2, str3);
    }

    @Override // com.huawei.phoneservice.feedbackcommon.utils.IFeedbackCommonManager
    public Submit getNotifyUploadSucc(Context context, Map<String, String> map, String str, String str2, String str3, Callback callback) {
        C13267j.m79677e(context, ParamConstants.Param.CONTEXT);
        C13267j.m79677e(map, "notifyUploadSuccMap");
        C13267j.m79677e(str2, "appId");
        C13267j.m79677e(str3, "serverDomain");
        C13267j.m79677e(callback, "callback");
        FeedbackUploadApi feedbackUploadApiM53290a = FeedbackUploadApi.f40231b.m53290a(context);
        C13267j.m79674b(feedbackUploadApiM53290a);
        return feedbackUploadApiM53290a.m53284h(map, str, str2, str3, callback);
    }

    @Override // com.huawei.phoneservice.feedbackcommon.utils.IFeedbackCommonManager
    public Submit getServerDomain(Context context, Map<String, String> map, String str, String str2, Callback callback) {
        C13267j.m79677e(context, ParamConstants.Param.CONTEXT);
        C13267j.m79677e(map, "domainMap");
        C13267j.m79677e(str, "domainRequest");
        C13267j.m79677e(str2, "appId");
        C13267j.m79677e(callback, "callback");
        FeedbackUploadApi feedbackUploadApiM53290a = FeedbackUploadApi.f40231b.m53290a(context);
        C13267j.m79674b(feedbackUploadApiM53290a);
        return feedbackUploadApiM53290a.m53282f(map, str, str2, callback);
    }

    @Override // com.huawei.phoneservice.feedbackcommon.utils.IFeedbackCommonManager
    public Submit getUnread(Context context, C8630p c8630p, Callback callback) {
        C13267j.m79677e(c8630p, TrackConstants$Opers.REQUEST);
        C13267j.m79677e(callback, "callback");
        ProblemApi problemApiM53297a = ProblemApi.f40235b.m53297a(context);
        C13267j.m79674b(problemApiM53297a);
        return problemApiM53297a.m53295a(c8630p, callback);
    }

    @Override // com.huawei.phoneservice.feedbackcommon.utils.IFeedbackCommonManager
    public Submit getUploadInfo(Context context, Map<String, String> map, String str, String str2, String str3, Callback callback) {
        C13267j.m79677e(context, ParamConstants.Param.CONTEXT);
        C13267j.m79677e(map, "uploadMap");
        C13267j.m79677e(str2, "appId");
        C13267j.m79677e(str3, "mServerDomain");
        C13267j.m79677e(callback, "callback");
        FeedbackUploadApi feedbackUploadApiM53290a = FeedbackUploadApi.f40231b.m53290a(context);
        C13267j.m79674b(feedbackUploadApiM53290a);
        return feedbackUploadApiM53290a.m53288p(map, str, str2, str3, callback);
    }

    @Override // com.huawei.phoneservice.feedbackcommon.utils.IFeedbackCommonManager
    public Submit postRate(Context context, FeedBackRateRequest feedBackRateRequest, Callback callback) {
        C13267j.m79677e(context, ParamConstants.Param.CONTEXT);
        C13267j.m79677e(feedBackRateRequest, TrackConstants$Opers.REQUEST);
        C13267j.m79677e(callback, "callback");
        ProblemSuggestApi problemSuggestApiM53308a = ProblemSuggestApi.f40239b.m53308a(context);
        C13267j.m79674b(problemSuggestApiM53308a);
        return problemSuggestApiM53308a.m53302a(feedBackRateRequest, callback);
    }

    @Override // com.huawei.phoneservice.feedbackcommon.utils.IFeedbackCommonManager
    public Submit queryForHD(Context context, long j10, String str, Callback callback) {
        C13267j.m79677e(context, ParamConstants.Param.CONTEXT);
        C13267j.m79677e(str, "uniqueCode");
        C13267j.m79677e(callback, "callback");
        C8627m c8627m = new C8627m();
        c8627m.m53240a(j10);
        c8627m.m53241b(str);
        ProblemSuggestApi problemSuggestApiM53308a = ProblemSuggestApi.f40239b.m53308a(context);
        C13267j.m79674b(problemSuggestApiM53308a);
        return problemSuggestApiM53308a.m53305d(c8627m, callback);
    }

    @Override // com.huawei.phoneservice.feedbackcommon.utils.IFeedbackCommonManager
    public Submit queryIsoLanguage(Context context, String str, Callback callback) {
        C13267j.m79677e(context, ParamConstants.Param.CONTEXT);
        C13267j.m79677e(callback, "callback");
        FeedbackUploadApi feedbackUploadApiM53290a = FeedbackUploadApi.f40231b.m53290a(context);
        C13267j.m79674b(feedbackUploadApiM53290a);
        return feedbackUploadApiM53290a.m53278b(str, callback);
    }

    @Override // com.huawei.phoneservice.feedbackcommon.utils.IFeedbackCommonManager
    public Submit queryNotice(Context context, String str, Callback callback) {
        C13267j.m79677e(context, ParamConstants.Param.CONTEXT);
        C13267j.m79677e(callback, "callback");
        FeedbackUploadApi feedbackUploadApiM53290a = FeedbackUploadApi.f40231b.m53290a(context);
        C13267j.m79674b(feedbackUploadApiM53290a);
        return feedbackUploadApiM53290a.m53286n(str, callback);
    }

    @Override // com.huawei.phoneservice.feedbackcommon.utils.IFeedbackCommonManager
    public Submit setRead(Context context, String str, String str2, Callback callback) {
        C13267j.m79677e(str, "accessToken");
        C13267j.m79677e(str2, "problemId");
        C13267j.m79677e(callback, "callback");
        C8640z c8640z = new C8640z(str, str2);
        ProblemApi problemApiM53297a = ProblemApi.f40235b.m53297a(context);
        C13267j.m79674b(problemApiM53297a);
        return problemApiM53297a.m53296b(c8640z, callback);
    }

    @Override // com.huawei.phoneservice.feedbackcommon.utils.IFeedbackCommonManager
    public Submit updateFeedBackInfo(Context context, C8614b0 c8614b0, Callback callback) {
        C13267j.m79677e(context, ParamConstants.Param.CONTEXT);
        C13267j.m79677e(c8614b0, "info");
        C13267j.m79677e(callback, "callback");
        FeedbackUploadApi feedbackUploadApiM53290a = FeedbackUploadApi.f40231b.m53290a(context);
        C13267j.m79674b(feedbackUploadApiM53290a);
        return feedbackUploadApiM53290a.m53285m(c8614b0, callback);
    }

    @Override // com.huawei.phoneservice.feedbackcommon.utils.IFeedbackCommonManager
    public com.huawei.hms.network.httpclient.Submit<ResponseBody> uploadFile(Context context, File file, String str, String str2, com.huawei.hms.network.httpclient.Callback<ResponseBody> callback) {
        C13267j.m79677e(context, ParamConstants.Param.CONTEXT);
        C13267j.m79677e(file, CloudBackupConstant.Command.PMS_OPTION_ONE_FILE);
        C13267j.m79677e(callback, "callback");
        ProblemSuggestApi problemSuggestApiM53308a = ProblemSuggestApi.f40239b.m53308a(context);
        C13267j.m79674b(problemSuggestApiM53308a);
        return problemSuggestApiM53308a.m53306e(file, str, str2, callback);
    }
}
