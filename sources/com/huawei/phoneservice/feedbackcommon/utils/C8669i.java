package com.huawei.phoneservice.feedbackcommon.utils;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.phoneservice.faq.base.network.FaqCallback;
import com.huawei.phoneservice.faq.base.network.FaqWebServiceException;
import com.huawei.phoneservice.faq.base.util.BaseSdkUpdateRequest;
import com.huawei.phoneservice.faq.base.util.FaqCommonUtils;
import com.huawei.phoneservice.faq.base.util.FaqSdk;
import com.huawei.phoneservice.feedbackcommon.entity.FeedBackRequest;
import com.huawei.phoneservice.feedbackcommon.entity.FeedBackResponse;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.huawei.phoneservice.feedbackcommon.utils.i */
/* loaded from: classes5.dex */
public final class C8669i {

    /* renamed from: a */
    public WeakReference<OnHistoryListener> f40371a;

    /* renamed from: b */
    public List<FeedBackResponse.ProblemEnity> f40372b = new ArrayList();

    /* renamed from: c */
    public Context f40373c;

    /* renamed from: d */
    public int f40374d;

    /* renamed from: e */
    public String f40375e;

    /* renamed from: f */
    public String f40376f;

    /* renamed from: g */
    public int f40377g;

    /* renamed from: com.huawei.phoneservice.feedbackcommon.utils.i$a */
    public class a extends FaqCallback<FeedBackResponse> {

        /* renamed from: d */
        public final /* synthetic */ String f40378d;

        /* renamed from: e */
        public final /* synthetic */ FeedBackRequest f40379e;

        /* renamed from: com.huawei.phoneservice.feedbackcommon.utils.i$a$a, reason: collision with other inner class name */
        public class C14495a extends BaseSdkUpdateRequest<FeedBackRequest> {
            public C14495a(FeedBackRequest feedBackRequest) {
                super(feedBackRequest);
            }

            @Override // com.huawei.phoneservice.faq.base.util.BaseSdkUpdateRequest
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public void onCallback(String str, String str2, String str3, FeedBackRequest feedBackRequest) {
                if ("accessToken".equals(str)) {
                    FaqSdk.getISdk().unregisterUpdateListener(this);
                    feedBackRequest.setAccessToken(str3);
                    a aVar = a.this;
                    C8669i.this.m53452g(feedBackRequest, aVar.f40378d);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Class cls, Activity activity, String str, FeedBackRequest feedBackRequest) {
            super(cls, activity);
            this.f40378d = str;
            this.f40379e = feedBackRequest;
        }

        @Override // com.huawei.phoneservice.faq.base.network.FaqCallback
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void onResult(Throwable th2, FeedBackResponse feedBackResponse) {
            if (th2 == null) {
                C8669i.this.m53453h(feedBackResponse, this.f40378d, this.f40379e);
            } else if ((th2 instanceof FaqWebServiceException) && ((FaqWebServiceException) th2).errorCode == 401 && FaqSdk.getISdk().haveSdkErr("accessToken")) {
                FaqSdk.getISdk().registerUpdateListener(new C14495a(this.f40379e));
                FaqSdk.getISdk().onSdkErr("accessToken", SdkProblemManager.getSdk().getSdk("accessToken"));
            } else {
                C8669i.this.m53455p(th2);
            }
            if (!FaqCommonUtils.isEmpty(C8669i.this.f40372b) || TextUtils.isEmpty(this.f40378d)) {
                return;
            }
            C8669i.this.f40372b.clear();
        }
    }

    /* renamed from: com.huawei.phoneservice.feedbackcommon.utils.i$b */
    public class b extends FaqCallback<FeedBackResponse> {

        /* renamed from: d */
        public final /* synthetic */ String f40382d;

        /* renamed from: e */
        public final /* synthetic */ FeedBackRequest f40383e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Class cls, Activity activity, String str, FeedBackRequest feedBackRequest) {
            super(cls, activity);
            this.f40382d = str;
            this.f40383e = feedBackRequest;
        }

        @Override // com.huawei.phoneservice.faq.base.network.FaqCallback
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void onResult(Throwable th2, FeedBackResponse feedBackResponse) {
            if (th2 != null) {
                C8669i.this.m53455p(th2);
                return;
            }
            List listM53449d = C8669i.this.m53449d(feedBackResponse.getDataList());
            if (!FaqCommonUtils.isEmpty(listM53449d)) {
                C8669i.this.m53456q(feedBackResponse.getDataList(), listM53449d);
            } else if (!TextUtils.isEmpty(this.f40382d)) {
                C8669i.this.m53450e(FaqConstants.FaqErrorCode.EMPTY_DATA_ERROR);
            } else {
                this.f40383e.setStartWith(C8669i.this.f40375e);
                C8669i.this.m53451f(this.f40383e);
            }
        }
    }

    public C8669i(Context context, String str, int i10, String str2, int i11) {
        this.f40373c = context;
        this.f40374d = i10;
        this.f40375e = str2;
        this.f40376f = str;
        this.f40377g = i11;
    }

    /* renamed from: a */
    public final OnHistoryListener m53448a() {
        WeakReference<OnHistoryListener> weakReference = this.f40371a;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    /* renamed from: d */
    public final List<FeedBackResponse.ProblemEnity> m53449d(List<FeedBackResponse.ProblemEnity> list) {
        ArrayList arrayList = new ArrayList();
        if (!FaqCommonUtils.isEmpty(list)) {
            this.f40375e = list.get(list.size() - 1).getProblemId();
            for (FeedBackResponse.ProblemEnity problemEnity : list) {
                if (TextUtils.isEmpty(problemEnity.getSrno())) {
                    arrayList.add(problemEnity);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: e */
    public final void m53450e(FaqConstants.FaqErrorCode faqErrorCode) {
        OnHistoryListener onHistoryListenerM53448a = m53448a();
        if (onHistoryListenerM53448a != null) {
            onHistoryListenerM53448a.setErrorView(faqErrorCode);
        }
    }

    /* renamed from: f */
    public final void m53451f(FeedBackRequest feedBackRequest) {
        String startWith = feedBackRequest.getStartWith();
        FeedbackCommonManager feedbackCommonManager = FeedbackCommonManager.INSTANCE;
        Context context = this.f40373c;
        feedbackCommonManager.getFeedBackList((Activity) context, feedBackRequest, new a(FeedBackResponse.class, (Activity) context, startWith, feedBackRequest));
    }

    /* renamed from: g */
    public final void m53452g(FeedBackRequest feedBackRequest, String str) {
        FeedbackCommonManager feedbackCommonManager = FeedbackCommonManager.INSTANCE;
        Context context = this.f40373c;
        feedbackCommonManager.getFeedBackList((Activity) context, feedBackRequest, new b(FeedBackResponse.class, (Activity) context, str, feedBackRequest));
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0065 A[PHI: r4
  0x0065: PHI (r4v2 java.util.ArrayList) = (r4v1 java.util.ArrayList), (r4v5 java.util.ArrayList) binds: [B:22:0x0063, B:15:0x0049] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m53453h(com.huawei.phoneservice.feedbackcommon.entity.FeedBackResponse r3, java.lang.String r4, com.huawei.phoneservice.feedbackcommon.entity.FeedBackRequest r5) {
        /*
            r2 = this;
            java.util.List r0 = r3.getDataList()
            java.util.List r0 = r2.m53449d(r0)
            boolean r1 = com.huawei.phoneservice.faq.base.util.FaqCommonUtils.isEmpty(r0)
            if (r1 != 0) goto L4c
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 == 0) goto L3e
            java.lang.String r4 = r2.f40375e
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L3e
            java.util.List r4 = r3.getDataList()
            int r4 = r4.size()
            r1 = 50
            if (r4 != r1) goto L3e
            int r4 = r0.size()
            int r1 = r2.f40374d
            if (r4 >= r1) goto L3e
            java.util.List<com.huawei.phoneservice.feedbackcommon.entity.FeedBackResponse$ProblemEnity> r3 = r2.f40372b
            r3.addAll(r0)
        L35:
            java.lang.String r3 = r2.f40375e
            r5.setStartWith(r3)
            r2.m53451f(r5)
            goto L89
        L3e:
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.List<com.huawei.phoneservice.feedbackcommon.entity.FeedBackResponse$ProblemEnity> r5 = r2.f40372b
            boolean r5 = com.huawei.phoneservice.faq.base.util.FaqCommonUtils.isEmpty(r5)
            if (r5 != 0) goto L6a
            goto L65
        L4c:
            boolean r1 = com.huawei.phoneservice.faq.base.util.FaqCommonUtils.isEmpty(r0)
            if (r1 == 0) goto L75
            boolean r1 = android.text.TextUtils.isEmpty(r4)
            if (r1 != 0) goto L75
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.List<com.huawei.phoneservice.feedbackcommon.entity.FeedBackResponse$ProblemEnity> r5 = r2.f40372b
            boolean r5 = com.huawei.phoneservice.faq.base.util.FaqCommonUtils.isEmpty(r5)
            if (r5 != 0) goto L6a
        L65:
            java.util.List<com.huawei.phoneservice.feedbackcommon.entity.FeedBackResponse$ProblemEnity> r5 = r2.f40372b
            r4.addAll(r5)
        L6a:
            r4.addAll(r0)
            java.util.List r3 = r3.getDataList()
            r2.m53456q(r3, r4)
            goto L89
        L75:
            boolean r3 = android.text.TextUtils.isEmpty(r4)
            if (r3 == 0) goto L84
            java.lang.String r3 = r2.f40375e
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L84
            goto L35
        L84:
            com.huawei.phoneservice.faq.base.constants.FaqConstants$FaqErrorCode r3 = com.huawei.phoneservice.faq.base.constants.FaqConstants.FaqErrorCode.EMPTY_DATA_ERROR
            r2.m53450e(r3)
        L89:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.phoneservice.feedbackcommon.utils.C8669i.m53453h(com.huawei.phoneservice.feedbackcommon.entity.FeedBackResponse, java.lang.String, com.huawei.phoneservice.feedbackcommon.entity.FeedBackRequest):void");
    }

    /* renamed from: i */
    public void m53454i(OnHistoryListener onHistoryListener) {
        if (onHistoryListener != null) {
            this.f40371a = new WeakReference<>(onHistoryListener);
        }
        FeedBackRequest feedBackRequest = new FeedBackRequest();
        feedBackRequest.setAccessToken(SdkProblemManager.getSdk().getSdk("accessToken"));
        feedBackRequest.setProblemId(this.f40376f);
        feedBackRequest.setStartWith(this.f40375e);
        feedBackRequest.setPageSize(this.f40374d);
        feedBackRequest.setProblemSourceCode(SdkProblemManager.getSdk().getSdk(FaqConstants.FAQ_CHANNEL));
        feedBackRequest.setOrderType(this.f40377g);
        m53451f(feedBackRequest);
    }

    /* renamed from: p */
    public final void m53455p(Throwable th2) {
        OnHistoryListener onHistoryListenerM53448a = m53448a();
        if (onHistoryListenerM53448a != null) {
            onHistoryListenerM53448a.setThrowableView(th2);
        }
    }

    /* renamed from: q */
    public final void m53456q(List<FeedBackResponse.ProblemEnity> list, List<FeedBackResponse.ProblemEnity> list2) {
        OnHistoryListener onHistoryListenerM53448a = m53448a();
        if (onHistoryListenerM53448a != null) {
            onHistoryListenerM53448a.showData(list, list2);
        }
    }
}
