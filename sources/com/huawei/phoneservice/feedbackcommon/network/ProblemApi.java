package com.huawei.phoneservice.feedbackcommon.network;

import android.content.Context;
import com.huawei.hms.framework.network.restclient.hwhttp.Callback;
import com.huawei.hms.framework.network.restclient.hwhttp.Submit;
import com.huawei.phoneservice.faq.base.constants.TrackConstants$Opers;
import com.huawei.phoneservice.faq.base.network.FaqRestClient;
import com.huawei.phoneservice.faq.base.util.FaqUtil;
import com.huawei.phoneservice.feedbackcommon.entity.C8630p;
import com.huawei.phoneservice.feedbackcommon.entity.C8640z;
import p692uw.C13264g;
import p692uw.C13267j;

/* loaded from: classes5.dex */
public final class ProblemApi extends FaqRestClient {

    /* renamed from: b */
    public static final C8643a f40235b = new C8643a(null);

    /* renamed from: c */
    public static Context f40236c;

    /* renamed from: d */
    public static volatile ProblemApi f40237d;

    /* renamed from: a */
    public Context f40238a;

    /* renamed from: com.huawei.phoneservice.feedbackcommon.network.ProblemApi$a */
    public static final class C8643a {
        public C8643a() {
        }

        public /* synthetic */ C8643a(C13264g c13264g) {
            this();
        }

        /* renamed from: a */
        public final ProblemApi m53297a(Context context) {
            ProblemApi.f40236c = context != null ? context.getApplicationContext() : null;
            if (ProblemApi.f40237d == null) {
                ProblemApi.f40237d = new ProblemApi(ProblemApi.f40236c);
            }
            return ProblemApi.f40237d;
        }
    }

    public ProblemApi(Context context) {
        super(context);
        this.f40238a = context;
    }

    /* renamed from: a */
    public final Submit m53295a(C8630p c8630p, Callback callback) {
        C13267j.m79677e(c8630p, TrackConstants$Opers.REQUEST);
        C13267j.m79677e(callback, "callback");
        FaqRestClient faqRestClientInitRestClientAnno = FaqRestClient.Companion.initRestClientAnno(this.f40238a);
        C13267j.m79674b(faqRestClientInitRestClientAnno);
        Context context = f40236c;
        String url = FaqUtil.getUrl(FeedbackWebConstants.HISTORY_FEEDBACK_URL);
        C13267j.m79676d(url, "getUrl(FeedbackWebConstants.HISTORY_FEEDBACK_URL)");
        String json = getGson().toJson(c8630p);
        C13267j.m79676d(json, "gson.toJson(request)");
        return faqRestClientInitRestClientAnno.asyncRequest(context, url, json, callback);
    }

    /* renamed from: b */
    public final Submit m53296b(C8640z c8640z, Callback callback) {
        C13267j.m79677e(c8640z, TrackConstants$Opers.REQUEST);
        C13267j.m79677e(callback, "callback");
        FaqRestClient faqRestClientInitRestClientAnno = FaqRestClient.Companion.initRestClientAnno(this.f40238a);
        C13267j.m79674b(faqRestClientInitRestClientAnno);
        Context context = f40236c;
        String url = FaqUtil.getUrl(FeedbackWebConstants.SET_READ_URL);
        C13267j.m79676d(url, "getUrl(FeedbackWebConstants.SET_READ_URL)");
        String json = getGson().toJson(c8640z);
        C13267j.m79676d(json, "gson.toJson(request)");
        return faqRestClientInitRestClientAnno.asyncRequest(context, url, json, callback);
    }
}
