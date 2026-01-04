package com.huawei.phoneservice.faq.base.network;

import android.content.Context;
import com.google.gson.Gson;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hms.framework.network.restclient.Headers;
import com.huawei.hms.framework.network.restclient.dnkeeper.InterfaceC5483d;
import com.huawei.hms.framework.network.restclient.hwhttp.Callback;
import com.huawei.hms.framework.network.restclient.hwhttp.HttpClient;
import com.huawei.hms.framework.network.restclient.hwhttp.HttpClientGlobalInstance;
import com.huawei.hms.framework.network.restclient.hwhttp.MediaType;
import com.huawei.hms.framework.network.restclient.hwhttp.Request;
import com.huawei.hms.framework.network.restclient.hwhttp.RequestBody;
import com.huawei.hms.framework.network.restclient.hwhttp.Submit;
import com.huawei.hms.framework.network.util.HttpUtils;
import com.huawei.hms.network.base.common.MultipartBody;
import com.huawei.hms.network.base.common.RequestBodyProviders;
import com.huawei.hms.network.httpclient.HttpClient;
import com.huawei.hms.network.httpclient.Interceptor;
import com.huawei.hms.network.httpclient.Request;
import com.huawei.hms.network.httpclient.ResponseBody;
import com.huawei.openalliance.p169ad.constant.ParamConstants;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.phoneservice.faq.base.constants.TrackConstants$Opers;
import com.huawei.phoneservice.faq.base.network.C8305e;
import com.huawei.phoneservice.faq.base.network.C8306f;
import com.huawei.phoneservice.faq.base.util.FaqCommonUtils;
import com.huawei.phoneservice.faq.base.util.FaqSdk;
import com.huawei.phoneservice.faq.base.util.FaqStringUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import p692uw.C13264g;
import p692uw.C13267j;

/* loaded from: classes4.dex */
public class FaqRestClient {
    public static final Companion Companion = new Companion(null);
    private static volatile FaqRestClient instance;
    private HttpClient attachClient;
    private com.huawei.hms.framework.network.restclient.hwhttp.HttpClient restClient;
    private final Gson gson = new Gson();
    private final Map<String, List<Submit>> submitMap = new ConcurrentHashMap();
    private final Map<String, List<com.huawei.hms.network.httpclient.Submit<ResponseBody>>> attachSubmitMap = new ConcurrentHashMap();
    private final int CONNECT_TIME_OUT = 8000;
    private final int UPLOAD_ZIP_TIME_OUT = 30000;
    private final int UPLOAD_ZIP_RETRY_TIME = 3;
    private final String HEAD_CHANNEL_KEY = "channelId";
    private final String HEAD_VERSION_KEY = ParamConstants.Param.SDK_VERSION;
    private final String HEAD_SWG_KEY = "SGW-APP-ID";
    private final String SGW_APP_ID = "26C7C8265E4924A6757A52FD571E03F4";

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(C13264g c13264g) {
            this();
        }

        public final FaqRestClient initRestClientAnno(Context context) {
            if (FaqRestClient.instance == null) {
                FaqRestClient.instance = new FaqRestClient(context);
            }
            return FaqRestClient.instance;
        }
    }

    public FaqRestClient(Context context) throws JSONException {
        HttpClientGlobalInstance.getInstance().init(context);
        HttpClient.Builder builderIsReportable = new HttpClient.Builder().callTimeout(151000).readTimeout(151000).retryTimeOnConnectionFailure(2).addInterceptor(new C8306f().m51796c(C8306f.a.BODY)).isReportable(true);
        HttpClient.Builder builderAddInterceptor = new HttpClient.Builder().callTimeout(151000).readTimeout(151000).retryTimeOnConnectionFailure(2).addInterceptor((Interceptor) new C8305e().m51790a(C8305e.a.BODY));
        this.restClient = builderIsReportable.build();
        this.attachClient = builderAddInterceptor.build();
    }

    private final void canceledAttachSubmit(String str) {
        List<com.huawei.hms.network.httpclient.Submit<ResponseBody>> list = this.attachSubmitMap.get(str);
        if (FaqCommonUtils.isEmpty(list)) {
            return;
        }
        C13267j.m79674b(list);
        for (com.huawei.hms.network.httpclient.Submit<ResponseBody> submit : list) {
            if (!submit.isCanceled()) {
                submit.cancel();
            }
        }
    }

    public static final FaqRestClient initRestClientAnno(Context context) {
        return Companion.initRestClientAnno(context);
    }

    private final void putAttachSubmit(Context context, com.huawei.hms.network.httpclient.Submit<ResponseBody> submit) {
        String name = context != null ? context.getClass().getName() : null;
        if (name == null) {
            return;
        }
        List<com.huawei.hms.network.httpclient.Submit<ResponseBody>> arrayList = this.attachSubmitMap.get(name);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.attachSubmitMap.put(name, arrayList);
        }
        arrayList.add(submit);
    }

    private final void putSubmit(Context context, Submit submit) {
        String name = context != null ? context.getClass().getName() : null;
        if (name == null) {
            return;
        }
        List<Submit> arrayList = this.submitMap.get(name);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.submitMap.put(name, arrayList);
        }
        arrayList.add(submit);
    }

    public Submit asyncRequest(Context context, String str, String str2, Callback callback) {
        C13267j.m79677e(str, "url");
        C13267j.m79677e(str2, TrackConstants$Opers.REQUEST);
        C13267j.m79677e(callback, "callback");
        if (!HttpUtils.isHttpOrGrsUrl(str)) {
            return null;
        }
        Request requestBuild = new Request.Builder().headers(new Headers.Builder().add(this.HEAD_CHANNEL_KEY, FaqSdk.getSdk().getSdk(FaqConstants.FAQ_CHANNEL)).add(this.HEAD_VERSION_KEY, FaqSdk.getSdk().getSdkVersion()).add(this.HEAD_SWG_KEY, this.SGW_APP_ID).build().newBuilder()).method("POST").requestBody(RequestBody.create(str2)).url(str).build();
        com.huawei.hms.framework.network.restclient.hwhttp.HttpClient httpClient = this.restClient;
        C13267j.m79674b(httpClient);
        Submit submitNewSubmit = httpClient.newSubmit(requestBuild);
        submitNewSubmit.enqueue(callback);
        return submitNewSubmit;
    }

    public Submit asyncRequestWitHead(Context context, String str, Headers headers, String str2, Callback callback) {
        C13267j.m79677e(str, "url");
        C13267j.m79677e(headers, "headers");
        C13267j.m79677e(callback, "callback");
        if (!HttpUtils.isHttpOrGrsUrl(str)) {
            return null;
        }
        Request requestBuild = new Request.Builder().method("POST").headers(headers.newBuilder()).requestBody(RequestBody.create(str2)).url(str).callTimeout(this.CONNECT_TIME_OUT).build();
        com.huawei.hms.framework.network.restclient.hwhttp.HttpClient httpClient = this.restClient;
        C13267j.m79674b(httpClient);
        Submit submitNewSubmit = httpClient.newSubmit(requestBuild);
        submitNewSubmit.enqueue(callback);
        C13267j.m79676d(submitNewSubmit, "submit");
        putSubmit(context, submitNewSubmit);
        return submitNewSubmit;
    }

    public Submit asyncRequestWithJson(Context context, String str, String str2, Headers headers, Callback callback) {
        C13267j.m79677e(str, "url");
        C13267j.m79677e(str2, TrackConstants$Opers.REQUEST);
        C13267j.m79677e(headers, "headers");
        C13267j.m79677e(callback, "callback");
        if (!HttpUtils.isHttpOrGrsUrl(str)) {
            return null;
        }
        Request requestBuild = new Request.Builder().headers(headers.newBuilder()).method("POST").requestBody(RequestBody.create(MediaType.parse(InterfaceC5483d.f25084j), str2)).url(str).build();
        com.huawei.hms.framework.network.restclient.hwhttp.HttpClient httpClient = this.restClient;
        C13267j.m79674b(httpClient);
        Submit submitNewSubmit = httpClient.newSubmit(requestBuild);
        submitNewSubmit.enqueue(callback);
        return submitNewSubmit;
    }

    public void canceledSubmit(Context context) {
        String name = context != null ? context.getClass().getName() : null;
        if (name == null) {
            return;
        }
        List<Submit> list = this.submitMap.get(name);
        if (!FaqCommonUtils.isEmpty(list)) {
            C13267j.m79674b(list);
            for (Submit submit : list) {
                if (!submit.isCanceled()) {
                    submit.cancel();
                }
            }
        }
        canceledAttachSubmit(name);
    }

    public final Submit downloadFile(Context context, String str, String str2, Callback callback) {
        C13267j.m79677e(str, "url");
        C13267j.m79677e(str2, "token");
        C13267j.m79677e(callback, "callback");
        if (!HttpUtils.isHttpOrGrsUrl(str)) {
            return null;
        }
        Request requestBuild = new Request.Builder().url(str).addHeader("accessToken", str2).build();
        com.huawei.hms.framework.network.restclient.hwhttp.HttpClient httpClient = this.restClient;
        C13267j.m79674b(httpClient);
        Submit submitNewSubmit = httpClient.newSubmit(requestBuild);
        submitNewSubmit.enqueue(callback);
        C13267j.m79676d(submitNewSubmit, "submit");
        putSubmit(context, submitNewSubmit);
        return submitNewSubmit;
    }

    public final com.huawei.hms.network.httpclient.HttpClient getAttachClient() {
        return this.attachClient;
    }

    public final Gson getGson() {
        return this.gson;
    }

    public final com.huawei.hms.framework.network.restclient.hwhttp.HttpClient getRestClient() {
        return this.restClient;
    }

    public final void setAttachClient(com.huawei.hms.network.httpclient.HttpClient httpClient) {
        this.attachClient = httpClient;
    }

    public final void setRestClient(com.huawei.hms.framework.network.restclient.hwhttp.HttpClient httpClient) {
        this.restClient = httpClient;
    }

    public com.huawei.hms.network.httpclient.Submit<ResponseBody> uploadAttachs(Context context, String str, String str2, String str3, File file, com.huawei.hms.network.httpclient.Callback<ResponseBody> callback) {
        C13267j.m79677e(str, "url");
        C13267j.m79677e(file, CloudBackupConstant.Command.PMS_OPTION_ONE_FILE);
        C13267j.m79677e(callback, "callback");
        if (!HttpUtils.isHttpOrGrsUrl(str)) {
            return null;
        }
        com.huawei.hms.network.httpclient.HttpClient httpClient = this.attachClient;
        C13267j.m79674b(httpClient);
        Request.Builder builderMethod = httpClient.newRequest().url(str).method("POST");
        MultipartBody multipartBodyBuild = new MultipartBody.Builder().setType(MultipartBody.FORM).addFormDataPart(CloudBackupConstant.Command.PMS_OPTION_ONE_FILE, file.getName(), RequestBodyProviders.create(com.huawei.hms.network.base.common.MediaType.parse(str3), file)).build();
        if (!FaqStringUtil.isEmpty(str2)) {
            builderMethod.addHeader("accessToken", str2);
        }
        builderMethod.requestBody(multipartBodyBuild);
        com.huawei.hms.network.httpclient.Request requestBuild = builderMethod.build();
        C13267j.m79676d(requestBuild, "builder.build()");
        com.huawei.hms.network.httpclient.HttpClient httpClient2 = this.attachClient;
        C13267j.m79674b(httpClient2);
        com.huawei.hms.network.httpclient.Submit<ResponseBody> submitNewSubmit = httpClient2.newSubmit(requestBuild);
        C13267j.m79676d(submitNewSubmit, "attachClient!!.newSubmit(request)");
        submitNewSubmit.enqueue(callback);
        putAttachSubmit(context, submitNewSubmit);
        return submitNewSubmit;
    }

    public Submit uploadZipFile(Context context, String str, Map<String, String> map, String str2, File file, String str3) {
        C13267j.m79677e(str, "url");
        C13267j.m79677e(map, "headerMap");
        C13267j.m79677e(str3, NotifyConstants.NotificationReport.PARAM_WISEMARKETING_REQUEST_BODY);
        if (!HttpUtils.isHttpOrGrsUrl(str)) {
            return null;
        }
        com.huawei.hms.framework.network.restclient.hwhttp.Request requestBuild = new Request.Builder().method("POST").headers(Headers.m32363of(map).newBuilder()).url(str).requestBody(RequestBody.create(str3)).build();
        com.huawei.hms.framework.network.restclient.hwhttp.HttpClient httpClient = this.restClient;
        C13267j.m79674b(httpClient);
        Submit submitNewSubmit = httpClient.newSubmit(requestBuild);
        C13267j.m79676d(submitNewSubmit, "submit");
        putSubmit(context, submitNewSubmit);
        return submitNewSubmit;
    }

    public Submit uploadZipFileToService(Context context, String str, Map<String, String> map, String str2, File file, String str3) {
        C13267j.m79677e(str, "url");
        C13267j.m79677e(map, "headerMap");
        C13267j.m79677e(str2, "contentType");
        C13267j.m79677e(file, CloudBackupConstant.Command.PMS_OPTION_ONE_FILE);
        if (!HttpUtils.isHttpOrGrsUrl(str)) {
            return null;
        }
        com.huawei.hms.framework.network.restclient.hwhttp.Request requestBuild = new Request.Builder().method(str3).headers(Headers.m32363of(map).newBuilder()).url(str).connectTimeout(this.UPLOAD_ZIP_TIME_OUT).readTimeout(this.UPLOAD_ZIP_TIME_OUT).writeTimeout(this.UPLOAD_ZIP_TIME_OUT).retryTimeOnConnectionFailure(this.UPLOAD_ZIP_RETRY_TIME).requestBody(RequestBody.create(MediaType.parse(str2), file)).build();
        com.huawei.hms.framework.network.restclient.hwhttp.HttpClient httpClient = this.restClient;
        C13267j.m79674b(httpClient);
        Submit submitNewSubmit = httpClient.newSubmit(requestBuild);
        C13267j.m79676d(submitNewSubmit, "submit");
        putSubmit(context, submitNewSubmit);
        return submitNewSubmit;
    }
}
