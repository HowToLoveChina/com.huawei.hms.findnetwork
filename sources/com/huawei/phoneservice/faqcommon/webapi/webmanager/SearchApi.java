package com.huawei.phoneservice.faqcommon.webapi.webmanager;

import android.content.Context;
import com.huawei.hms.framework.network.restclient.hwhttp.Callback;
import com.huawei.hms.framework.network.restclient.hwhttp.Submit;
import com.huawei.phoneservice.faq.base.network.FaqRestClient;
import com.huawei.phoneservice.faq.base.util.FaqUtil;
import com.huawei.phoneservice.faqcommon.webapi.request.C8443i;
import com.huawei.phoneservice.faqcommon.webapi.request.C8444j;
import p692uw.C13264g;
import p692uw.C13267j;

/* loaded from: classes4.dex */
public final class SearchApi extends FaqRestClient {

    /* renamed from: b */
    public static final C8451a f39447b = new C8451a(null);

    /* renamed from: c */
    public static Context f39448c;

    /* renamed from: d */
    public static volatile SearchApi f39449d;

    /* renamed from: a */
    public Context f39450a;

    /* renamed from: com.huawei.phoneservice.faqcommon.webapi.webmanager.SearchApi$a */
    public static final class C8451a {
        public C8451a() {
        }

        public /* synthetic */ C8451a(C13264g c13264g) {
            this();
        }

        /* renamed from: a */
        public final SearchApi m52570a(Context context) {
            SearchApi.f39448c = context != null ? context.getApplicationContext() : null;
            if (SearchApi.f39449d == null) {
                SearchApi.f39449d = new SearchApi(SearchApi.f39448c);
            }
            return SearchApi.f39449d;
        }
    }

    public SearchApi(Context context) {
        super(context);
        this.f39450a = context;
    }

    /* renamed from: a */
    public final Submit m52568a(C8443i c8443i, Callback callback) {
        C13267j.m79677e(c8443i, "hotWordRequest");
        C13267j.m79677e(callback, "callback");
        FaqRestClient faqRestClientInitRestClientAnno = FaqRestClient.Companion.initRestClientAnno(this.f39450a);
        C13267j.m79674b(faqRestClientInitRestClientAnno);
        Context context = f39448c;
        String url = FaqUtil.getUrl(C8452a.f39451a.m52580j());
        C13267j.m79676d(url, "getUrl(FaqWebConstants.HOTWORD)");
        String json = getGson().toJson(c8443i);
        C13267j.m79676d(json, "gson.toJson(hotWordRequest)");
        return faqRestClientInitRestClientAnno.asyncRequest(context, url, json, callback);
    }

    /* renamed from: b */
    public final Submit m52569b(C8444j c8444j, Callback callback) {
        C13267j.m79677e(c8444j, "searchCompleteRequest");
        C13267j.m79677e(callback, "callback");
        FaqRestClient faqRestClientInitRestClientAnno = FaqRestClient.Companion.initRestClientAnno(this.f39450a);
        C13267j.m79674b(faqRestClientInitRestClientAnno);
        Context context = f39448c;
        String url = FaqUtil.getUrl(C8452a.f39451a.m52581k());
        C13267j.m79676d(url, "getUrl(FaqWebConstants.SEARCHCOMPLETE)");
        String json = getGson().toJson(c8444j);
        C13267j.m79676d(json, "gson.toJson(searchCompleteRequest)");
        return faqRestClientInitRestClientAnno.asyncRequest(context, url, json, callback);
    }
}
