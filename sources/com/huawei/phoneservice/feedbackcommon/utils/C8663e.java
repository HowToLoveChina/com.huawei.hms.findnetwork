package com.huawei.phoneservice.feedbackcommon.utils;

import android.app.Activity;
import android.text.TextUtils;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.phoneservice.faq.base.network.FaqCallback;
import com.huawei.phoneservice.faq.base.network.FaqWebServiceException;
import com.huawei.phoneservice.faq.base.util.BaseSdkUpdateRequest;
import com.huawei.phoneservice.faq.base.util.FaqCommonUtils;
import com.huawei.phoneservice.faq.base.util.FaqLogger;
import com.huawei.phoneservice.faq.base.util.FaqSdk;
import com.huawei.phoneservice.feedbackcommon.entity.FeedBackRequest;
import com.huawei.phoneservice.feedbackcommon.entity.FeedBackResponse;
import java.lang.ref.WeakReference;
import java.net.ConnectException;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.huawei.phoneservice.feedbackcommon.utils.e */
/* loaded from: classes5.dex */
public final class C8663e {

    /* renamed from: a */
    public WeakReference<Activity> f40350a;

    /* renamed from: b */
    public WeakReference<SdkFeedBackCallback> f40351b;

    /* renamed from: c */
    public FeedBackRequest f40352c;

    /* renamed from: d */
    public List<FeedBackResponse.ProblemEnity> f40353d;

    /* renamed from: com.huawei.phoneservice.feedbackcommon.utils.e$a */
    public class a extends FaqCallback<FeedBackResponse> {

        /* renamed from: com.huawei.phoneservice.feedbackcommon.utils.e$a$a, reason: collision with other inner class name */
        public class C14494a extends BaseSdkUpdateRequest<FeedBackRequest> {
            public C14494a(FeedBackRequest feedBackRequest) {
                super(feedBackRequest);
            }

            @Override // com.huawei.phoneservice.faq.base.util.BaseSdkUpdateRequest
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public void onCallback(String str, String str2, String str3, FeedBackRequest feedBackRequest) {
                if ("accessToken".equals(str)) {
                    FaqSdk.getISdk().unregisterUpdateListener(this);
                    C8663e.this.f40352c.setAccessToken(str3);
                    Activity activityM53407a = C8663e.this.m53407a();
                    if (activityM53407a != null) {
                        C8663e.this.m53408c(activityM53407a);
                    }
                }
            }
        }

        public a(Class cls, Activity activity) {
            super(cls, activity);
        }

        @Override // com.huawei.phoneservice.faq.base.network.FaqCallback
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void onResult(Throwable th2, FeedBackResponse feedBackResponse) throws Throwable {
            if (th2 != null || feedBackResponse == null) {
                if (!(th2 instanceof FaqWebServiceException) || ((FaqWebServiceException) th2).errorCode != 401 || !FaqSdk.getISdk().haveSdkErr("accessToken")) {
                    C8663e.this.m53410h(th2);
                    return;
                } else {
                    FaqSdk.getISdk().registerUpdateListener(new C14494a(C8663e.this.f40352c));
                    FaqSdk.getISdk().onSdkErr("accessToken", SdkProblemManager.getSdk().getSdk("accessToken"));
                    return;
                }
            }
            C8663e.this.f40353d.addAll(feedBackResponse.getDataList());
            if (TextUtils.isEmpty(C8663e.this.f40352c.getStartWith()) && C8663e.this.f40353d.size() == 50) {
                C8663e.this.f40352c.setStartWith(((FeedBackResponse.ProblemEnity) C8663e.this.f40353d.get(C8663e.this.f40353d.size() - 1)).getUpdateTime());
                C8663e.this.m53413l();
            } else {
                C8663e c8663e = C8663e.this;
                c8663e.m53411i(c8663e.f40353d);
            }
        }
    }

    /* renamed from: com.huawei.phoneservice.feedbackcommon.utils.e$b */
    public class b extends FaqCallback<FeedBackResponse> {
        public b(Class cls, Activity activity) {
            super(cls, activity);
        }

        @Override // com.huawei.phoneservice.faq.base.network.FaqCallback
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void onResult(Throwable th2, FeedBackResponse feedBackResponse) throws Throwable {
            if (th2 != null || feedBackResponse == null) {
                C8663e.this.m53410h(th2);
                return;
            }
            C8663e.this.f40353d.addAll(feedBackResponse.getDataList());
            if (TextUtils.isEmpty(C8663e.this.f40352c.getStartWith()) && C8663e.this.f40353d.size() == 50) {
                C8663e.this.f40352c.setStartWith(((FeedBackResponse.ProblemEnity) C8663e.this.f40353d.get(C8663e.this.f40353d.size() - 1)).getUpdateTime());
                C8663e.this.m53413l();
            } else {
                C8663e c8663e = C8663e.this;
                c8663e.m53411i(c8663e.f40353d);
            }
        }
    }

    /* renamed from: com.huawei.phoneservice.feedbackcommon.utils.e$c */
    public static class c implements Runnable {

        /* renamed from: a */
        public final SdkFeedBackCallback f40357a;

        /* renamed from: b */
        public final List<FeedBackResponse.ProblemEnity> f40358b;

        public c(SdkFeedBackCallback sdkFeedBackCallback, List<FeedBackResponse.ProblemEnity> list) {
            this.f40357a = sdkFeedBackCallback;
            this.f40358b = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f40357a.setListView(this.f40358b);
        }
    }

    /* renamed from: com.huawei.phoneservice.feedbackcommon.utils.e$d */
    public static class d implements Runnable {

        /* renamed from: a */
        public final SdkFeedBackCallback f40359a;

        /* renamed from: b */
        public final Throwable f40360b;

        public d(SdkFeedBackCallback sdkFeedBackCallback, Throwable th2) {
            this.f40359a = sdkFeedBackCallback;
            this.f40360b = th2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f40359a.setThrowableView(this.f40360b);
        }
    }

    public C8663e(Activity activity) {
        if (activity != null) {
            this.f40350a = new WeakReference<>(activity);
        }
    }

    /* renamed from: a */
    public final Activity m53407a() {
        WeakReference<Activity> weakReference = this.f40350a;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    /* renamed from: c */
    public final void m53408c(Activity activity) {
        FeedbackCommonManager.INSTANCE.getFeedBackList(activity, this.f40352c, new b(FeedBackResponse.class, null));
    }

    /* renamed from: d */
    public void m53409d(SdkFeedBackCallback sdkFeedBackCallback) {
        if (sdkFeedBackCallback != null) {
            this.f40351b = new WeakReference<>(sdkFeedBackCallback);
        }
        FeedBackRequest feedBackRequest = new FeedBackRequest();
        this.f40352c = feedBackRequest;
        feedBackRequest.setAccessToken(SdkProblemManager.getSdk().getSdk("accessToken"));
        this.f40352c.setProblemSourceCode(SdkProblemManager.getSdk().getSdk(FaqConstants.FAQ_CHANNEL));
        this.f40352c.setPageSize(50);
        this.f40352c.setOrderType(2);
        this.f40352c.setStartWith("");
        this.f40353d = new ArrayList();
        m53413l();
    }

    /* renamed from: h */
    public final void m53410h(Throwable th2) throws Throwable {
        if (!FaqCommonUtils.isEmpty(this.f40353d)) {
            m53411i(this.f40353d);
            return;
        }
        SdkFeedBackCallback sdkFeedBackCallbackM53412k = m53412k();
        Activity activityM53407a = m53407a();
        if (sdkFeedBackCallbackM53412k == null || activityM53407a == null) {
            return;
        }
        try {
            activityM53407a.runOnUiThread(new d(sdkFeedBackCallbackM53412k, th2));
        } catch (Exception e10) {
            FaqLogger.m51840e("GetSrCodeDataTask", e10.getMessage());
        }
    }

    /* renamed from: i */
    public final void m53411i(List<FeedBackResponse.ProblemEnity> list) throws Throwable {
        for (int size = list.size() - 1; size >= 0; size--) {
            FeedBackResponse.ProblemEnity problemEnity = list.get(size);
            if (problemEnity == null || TextUtils.isEmpty(problemEnity.getSrno())) {
                list.remove(size);
            }
        }
        SdkFeedBackCallback sdkFeedBackCallbackM53412k = m53412k();
        Activity activityM53407a = m53407a();
        if (sdkFeedBackCallbackM53412k == null || activityM53407a == null) {
            return;
        }
        try {
            activityM53407a.runOnUiThread(new c(sdkFeedBackCallbackM53412k, list));
        } catch (Exception e10) {
            FaqLogger.m51840e("GetSrCodeDataTask", e10.getMessage());
        }
    }

    /* renamed from: k */
    public final SdkFeedBackCallback m53412k() {
        WeakReference<SdkFeedBackCallback> weakReference = this.f40351b;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    /* renamed from: l */
    public final void m53413l() throws Throwable {
        if (!FaqSdk.getISdk().hadAddress()) {
            m53410h(new ConnectException("Unable to connect to server"));
            return;
        }
        Activity activityM53407a = m53407a();
        if (activityM53407a != null) {
            FeedbackCommonManager.INSTANCE.getFeedBackList(activityM53407a, this.f40352c, new a(FeedBackResponse.class, null));
        }
    }
}
