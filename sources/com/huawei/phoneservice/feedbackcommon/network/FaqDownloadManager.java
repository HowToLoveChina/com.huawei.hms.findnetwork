package com.huawei.phoneservice.feedbackcommon.network;

import android.content.Context;
import com.huawei.hms.framework.network.restclient.hwhttp.Callback;
import com.huawei.hms.framework.network.restclient.hwhttp.Submit;
import com.huawei.phoneservice.faq.base.network.FaqRestClient;
import p692uw.C13264g;
import p692uw.C13267j;

/* loaded from: classes5.dex */
public final class FaqDownloadManager extends FaqRestClient {

    /* renamed from: b */
    public static final C8641a f40227b = new C8641a(null);

    /* renamed from: c */
    public static Context f40228c;

    /* renamed from: d */
    public static volatile FaqDownloadManager f40229d;

    /* renamed from: a */
    public Context f40230a;

    /* renamed from: com.huawei.phoneservice.feedbackcommon.network.FaqDownloadManager$a */
    public static final class C8641a {
        public C8641a() {
        }

        public /* synthetic */ C8641a(C13264g c13264g) {
            this();
        }

        /* renamed from: a */
        public final FaqDownloadManager m53272a(Context context) {
            FaqDownloadManager.f40228c = context != null ? context.getApplicationContext() : null;
            if (FaqDownloadManager.f40229d == null) {
                FaqDownloadManager.f40229d = new FaqDownloadManager(FaqDownloadManager.f40228c);
            }
            return FaqDownloadManager.f40229d;
        }
    }

    public FaqDownloadManager(Context context) {
        super(context);
        this.f40230a = context;
    }

    /* renamed from: a */
    public final Submit m53271a(String str, String str2, Callback callback) {
        C13267j.m79677e(str, "url");
        C13267j.m79677e(str2, "token");
        C13267j.m79677e(callback, "callback");
        FaqRestClient faqRestClientInitRestClientAnno = FaqRestClient.Companion.initRestClientAnno(this.f40230a);
        C13267j.m79674b(faqRestClientInitRestClientAnno);
        return faqRestClientInitRestClientAnno.downloadFile(f40228c, str, str2, callback);
    }
}
