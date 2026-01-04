package com.huawei.phoneservice.faqcommon.webapi.webmanager;

import android.content.Context;
import com.huawei.hms.framework.network.restclient.hwhttp.Callback;
import com.huawei.hms.framework.network.restclient.hwhttp.Submit;
import com.huawei.phoneservice.faq.base.constants.TrackConstants$Opers;
import com.huawei.phoneservice.faq.base.network.FaqRestClient;
import com.huawei.phoneservice.faq.base.util.FaqUtil;
import com.huawei.phoneservice.faqcommon.webapi.request.C8442h;
import p692uw.C13264g;
import p692uw.C13267j;

/* loaded from: classes4.dex */
public final class FaqStatisticsApi extends FaqRestClient {

    /* renamed from: b */
    public static final C8450a f39443b = new C8450a(null);

    /* renamed from: c */
    public static Context f39444c;

    /* renamed from: d */
    public static volatile FaqStatisticsApi f39445d;

    /* renamed from: a */
    public Context f39446a;

    /* renamed from: com.huawei.phoneservice.faqcommon.webapi.webmanager.FaqStatisticsApi$a */
    public static final class C8450a {
        public C8450a() {
        }

        public /* synthetic */ C8450a(C13264g c13264g) {
            this();
        }

        /* renamed from: a */
        public final FaqStatisticsApi m52563a(Context context) {
            FaqStatisticsApi.f39444c = context != null ? context.getApplicationContext() : null;
            if (FaqStatisticsApi.f39445d == null) {
                FaqStatisticsApi.f39445d = new FaqStatisticsApi(FaqStatisticsApi.f39444c);
            }
            return FaqStatisticsApi.f39445d;
        }
    }

    public FaqStatisticsApi(Context context) {
        super(context);
        this.f39446a = context;
    }

    /* renamed from: a */
    public final Submit m52562a(C8442h c8442h, Callback callback) {
        C13267j.m79677e(c8442h, TrackConstants$Opers.REQUEST);
        C13267j.m79677e(callback, "callback");
        FaqRestClient faqRestClientInitRestClientAnno = FaqRestClient.Companion.initRestClientAnno(this.f39446a);
        C13267j.m79674b(faqRestClientInitRestClientAnno);
        Context context = f39444c;
        String url = FaqUtil.getUrl(C8452a.f39451a.m52579i());
        C13267j.m79676d(url, "getUrl(FaqWebConstants.FAQ_STATISTICS_URL)");
        String json = getGson().toJson(c8442h);
        C13267j.m79676d(json, "gson.toJson(request)");
        return faqRestClientInitRestClientAnno.asyncRequest(context, url, json, callback);
    }
}
