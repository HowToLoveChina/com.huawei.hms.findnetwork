package com.huawei.phoneservice.faq.base.network;

import android.app.Application;
import com.huawei.hms.framework.network.restclient.hwhttp.HttpClientGlobalInstance;
import com.huawei.phoneservice.faq.base.tracker.FaqTrack;
import com.huawei.phoneservice.faq.base.util.FaqLogger;
import p692uw.C13264g;

/* loaded from: classes4.dex */
public final class SdkAppInfo {
    public static final C8300a Companion = new C8300a(null);
    private static volatile SdkAppInfo INSTANCE;

    /* renamed from: com.huawei.phoneservice.faq.base.network.SdkAppInfo$a */
    public static final class C8300a {
        public C8300a() {
        }

        public /* synthetic */ C8300a(C13264g c13264g) {
            this();
        }

        /* renamed from: a */
        public final SdkAppInfo m51789a(Application application) {
            if (SdkAppInfo.INSTANCE == null) {
                SdkAppInfo.INSTANCE = new SdkAppInfo(application, null);
                FaqLogger.m51844g(application);
            }
            return SdkAppInfo.INSTANCE;
        }
    }

    private SdkAppInfo(Application application) {
        HttpClientGlobalInstance.getInstance().init(application);
        FaqTrack.m51801b(application, false);
    }

    public static final SdkAppInfo initAppInfo(Application application) {
        return Companion.m51789a(application);
    }

    public /* synthetic */ SdkAppInfo(Application application, C13264g c13264g) {
        this(application);
    }
}
