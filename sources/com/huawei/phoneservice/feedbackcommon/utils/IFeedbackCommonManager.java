package com.huawei.phoneservice.feedbackcommon.utils;

import android.content.Context;
import com.huawei.hms.framework.network.restclient.hwhttp.Callback;
import com.huawei.hms.framework.network.restclient.hwhttp.Submit;
import com.huawei.hms.network.httpclient.ResponseBody;
import com.huawei.phoneservice.feedbackcommon.entity.C8613b;
import com.huawei.phoneservice.feedbackcommon.entity.C8614b0;
import com.huawei.phoneservice.feedbackcommon.entity.C8630p;
import com.huawei.phoneservice.feedbackcommon.entity.FeedBackRateRequest;
import com.huawei.phoneservice.feedbackcommon.entity.FeedBackRequest;
import java.io.File;
import java.util.Map;

/* loaded from: classes5.dex */
public interface IFeedbackCommonManager {
    Submit callFeedBackService(Context context, C8614b0 c8614b0, Callback callback);

    Submit callService(Context context, String str, String str2, String str3, String str4, Callback callback);

    Submit deleteHistory(Context context, C8613b c8613b, Callback callback);

    Submit downloadFile(Context context, String str, String str2, Callback callback);

    Submit feedbackNotifySuccess(Context context, Map<String, String> map, String str, Callback callback);

    Submit getDataFromDetail(Context context, FeedBackRequest feedBackRequest, Callback callback);

    Submit getFeedBackList(Context context, FeedBackRequest feedBackRequest, Callback callback);

    Submit getFeedbackNewUploadInfo(Context context, Map<String, String> map, String str, Callback callback);

    Submit getFeedbackUploadInfo(Context context, Map<String, String> map, String str, Callback callback);

    Submit getFileUploadToService(Context context, String str, Map<String, String> map, File file, String str2, String str3);

    Submit getNewUploadInfo(Context context, Map<String, String> map, String str, String str2, String str3);

    Submit getNotifyUploadSucc(Context context, Map<String, String> map, String str, String str2, String str3, Callback callback);

    Submit getServerDomain(Context context, Map<String, String> map, String str, String str2, Callback callback);

    Submit getUnread(Context context, C8630p c8630p, Callback callback);

    Submit getUploadInfo(Context context, Map<String, String> map, String str, String str2, String str3, Callback callback);

    Submit postRate(Context context, FeedBackRateRequest feedBackRateRequest, Callback callback);

    Submit queryForHD(Context context, long j10, String str, Callback callback);

    Submit queryIsoLanguage(Context context, String str, Callback callback);

    Submit queryNotice(Context context, String str, Callback callback);

    Submit setRead(Context context, String str, String str2, Callback callback);

    Submit updateFeedBackInfo(Context context, C8614b0 c8614b0, Callback callback);

    com.huawei.hms.network.httpclient.Submit<ResponseBody> uploadFile(Context context, File file, String str, String str2, com.huawei.hms.network.httpclient.Callback<ResponseBody> callback);
}
