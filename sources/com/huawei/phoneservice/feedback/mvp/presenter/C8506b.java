package com.huawei.phoneservice.feedback.mvp.presenter;

import android.app.Activity;
import android.content.Context;
import com.google.gson.Gson;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.phoneservice.faq.base.network.FaqCallback;
import com.huawei.phoneservice.faq.base.network.FaqWebServiceException;
import com.huawei.phoneservice.faq.base.util.BaseSdkUpdateRequest;
import com.huawei.phoneservice.faq.base.util.FaqCommonUtils;
import com.huawei.phoneservice.faq.base.util.FaqSdk;
import com.huawei.phoneservice.faq.base.util.FaqStringUtil;
import com.huawei.phoneservice.faq.base.util.VideoCallBack;
import com.huawei.phoneservice.feedback.entity.C8470a;
import com.huawei.phoneservice.feedback.entity.C8472c;
import com.huawei.phoneservice.feedback.mvp.base.AbstractC8492a;
import com.huawei.phoneservice.feedback.mvp.base.InterfaceC8498g;
import com.huawei.phoneservice.feedback.mvp.contract.InterfaceC8500b;
import com.huawei.phoneservice.feedback.mvp.contract.InterfaceC8501c;
import com.huawei.phoneservice.feedbackcommon.entity.FeedBackRateRequest;
import com.huawei.phoneservice.feedbackcommon.entity.FeedBackRequest;
import com.huawei.phoneservice.feedbackcommon.entity.FeedBackResponse;
import com.huawei.phoneservice.feedbackcommon.utils.FeedbackCommonManager;
import com.huawei.phoneservice.feedbackcommon.utils.SdkProblemManager;

/* renamed from: com.huawei.phoneservice.feedback.mvp.presenter.b */
/* loaded from: classes5.dex */
public class C8506b extends AbstractC8492a<InterfaceC8501c> implements InterfaceC8500b {

    /* renamed from: b */
    public Gson f39668b;

    /* renamed from: c */
    public Context f39669c;

    /* renamed from: com.huawei.phoneservice.feedback.mvp.presenter.b$a */
    public class a extends FaqCallback<FeedBackResponse.ProblemEnity> {

        /* renamed from: d */
        public final /* synthetic */ FeedBackRequest f39670d;

        /* renamed from: com.huawei.phoneservice.feedback.mvp.presenter.b$a$a */
        public class C14487a extends BaseSdkUpdateRequest<FeedBackRequest> {

            /* renamed from: com.huawei.phoneservice.feedback.mvp.presenter.b$a$a$a */
            public class C14488a extends FaqCallback<FeedBackResponse.ProblemEnity> {
                public C14488a(Class cls, Activity activity) {
                    super(cls, activity);
                }

                @Override // com.huawei.phoneservice.faq.base.network.FaqCallback
                /* renamed from: h */
                public void onResult(Throwable th2, FeedBackResponse.ProblemEnity problemEnity) {
                    C8506b c8506b = C8506b.this;
                    if (th2 != null) {
                        ((InterfaceC8501c) c8506b.f39636a).setThrowableView(th2);
                    } else if (problemEnity == null) {
                        ((InterfaceC8501c) c8506b.f39636a).setErrorView(FaqConstants.FaqErrorCode.EMPTY_DATA_ERROR);
                    } else {
                        ((InterfaceC8501c) c8506b.f39636a).mo52773a(problemEnity);
                    }
                }
            }

            public C14487a(FeedBackRequest feedBackRequest) {
                super(feedBackRequest);
            }

            @Override // com.huawei.phoneservice.faq.base.util.BaseSdkUpdateRequest
            /* renamed from: c */
            public void onCallback(String str, String str2, String str3, FeedBackRequest feedBackRequest) {
                if ("accessToken".equals(str)) {
                    FaqSdk.getISdk().unregisterUpdateListener(this);
                    feedBackRequest.setAccessToken(str3);
                    FeedbackCommonManager.INSTANCE.getDataFromDetail(C8506b.this.f39669c, feedBackRequest, new C14488a(FeedBackResponse.ProblemEnity.class, (Activity) C8506b.this.f39669c));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Class cls, Activity activity, FeedBackRequest feedBackRequest) {
            super(cls, activity);
            this.f39670d = feedBackRequest;
        }

        @Override // com.huawei.phoneservice.faq.base.network.FaqCallback
        /* renamed from: h */
        public void onResult(Throwable th2, FeedBackResponse.ProblemEnity problemEnity) {
            if (th2 == null) {
                if (problemEnity == null || FaqStringUtil.isEmpty(problemEnity.getProblemId())) {
                    ((InterfaceC8501c) C8506b.this.f39636a).setErrorView(FaqConstants.FaqErrorCode.EMPTY_DATA_ERROR);
                    return;
                } else {
                    ((InterfaceC8501c) C8506b.this.f39636a).mo52773a(problemEnity);
                    return;
                }
            }
            if (!(th2 instanceof FaqWebServiceException) || ((FaqWebServiceException) th2).errorCode != 401 || !FaqSdk.getISdk().haveSdkErr("accessToken")) {
                ((InterfaceC8501c) C8506b.this.f39636a).setThrowableView(th2);
            } else {
                FaqSdk.getISdk().registerUpdateListener(new C14487a(this.f39670d));
                FaqSdk.getISdk().onSdkErr("accessToken", SdkProblemManager.getSdk().getSdk("accessToken"));
            }
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.mvp.presenter.b$b */
    public class b extends FaqCallback<FeedBackResponse> {

        /* renamed from: d */
        public final /* synthetic */ FeedBackRequest f39674d;

        /* renamed from: com.huawei.phoneservice.feedback.mvp.presenter.b$b$a */
        public class a extends BaseSdkUpdateRequest<FeedBackRequest> {

            /* renamed from: com.huawei.phoneservice.feedback.mvp.presenter.b$b$a$a */
            public class C14489a extends FaqCallback<FeedBackResponse> {
                public C14489a(Class cls, Activity activity) {
                    super(cls, activity);
                }

                @Override // com.huawei.phoneservice.faq.base.network.FaqCallback
                /* renamed from: h */
                public void onResult(Throwable th2, FeedBackResponse feedBackResponse) {
                    if (th2 != null || feedBackResponse == null) {
                        ((InterfaceC8501c) C8506b.this.f39636a).mo52775d();
                    } else {
                        ((InterfaceC8501c) C8506b.this.f39636a).mo52774a(feedBackResponse.getDataList());
                    }
                }
            }

            public a(FeedBackRequest feedBackRequest) {
                super(feedBackRequest);
            }

            @Override // com.huawei.phoneservice.faq.base.util.BaseSdkUpdateRequest
            /* renamed from: c */
            public void onCallback(String str, String str2, String str3, FeedBackRequest feedBackRequest) {
                if ("accessToken".equals(str)) {
                    FaqSdk.getISdk().unregisterUpdateListener(this);
                    feedBackRequest.setAccessToken(str3);
                    FeedbackCommonManager.INSTANCE.getFeedBackList(C8506b.this.f39669c, feedBackRequest, new C14489a(FeedBackResponse.class, (Activity) C8506b.this.f39669c));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Class cls, Activity activity, FeedBackRequest feedBackRequest) {
            super(cls, activity);
            this.f39674d = feedBackRequest;
        }

        @Override // com.huawei.phoneservice.faq.base.network.FaqCallback
        /* renamed from: h */
        public void onResult(Throwable th2, FeedBackResponse feedBackResponse) {
            InterfaceC8498g interfaceC8498g;
            if (th2 == null) {
                boolean zIsEmpty = FaqCommonUtils.isEmpty(feedBackResponse.getDataList());
                C8506b c8506b = C8506b.this;
                if (!zIsEmpty) {
                    ((InterfaceC8501c) c8506b.f39636a).mo52774a(feedBackResponse.getDataList());
                    return;
                }
                interfaceC8498g = c8506b.f39636a;
            } else {
                if ((th2 instanceof FaqWebServiceException) && ((FaqWebServiceException) th2).errorCode == 401 && FaqSdk.getISdk().haveSdkErr("accessToken")) {
                    FaqSdk.getISdk().registerUpdateListener(new a(this.f39674d));
                    FaqSdk.getISdk().onSdkErr("accessToken", SdkProblemManager.getSdk().getSdk("accessToken"));
                    return;
                }
                interfaceC8498g = C8506b.this.f39636a;
            }
            ((InterfaceC8501c) interfaceC8498g).mo52775d();
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.mvp.presenter.b$c */
    public class c extends FaqCallback<C8470a> {

        /* renamed from: d */
        public final /* synthetic */ boolean f39678d;

        /* renamed from: e */
        public final /* synthetic */ C8472c f39679e;

        /* renamed from: f */
        public final /* synthetic */ FeedBackRateRequest f39680f;

        /* renamed from: com.huawei.phoneservice.feedback.mvp.presenter.b$c$a */
        public class a extends BaseSdkUpdateRequest<FeedBackRateRequest> {

            /* renamed from: com.huawei.phoneservice.feedback.mvp.presenter.b$c$a$a */
            public class C14490a extends FaqCallback<C8470a> {
                public C14490a(Class cls, Activity activity) {
                    super(cls, activity);
                }

                @Override // com.huawei.phoneservice.faq.base.network.FaqCallback
                /* renamed from: h */
                public void onResult(Throwable th2, C8470a c8470a) {
                    if (th2 != null) {
                        ((InterfaceC8501c) C8506b.this.f39636a).mo52776u(c.this.f39679e);
                        return;
                    }
                    InterfaceC8501c interfaceC8501c = (InterfaceC8501c) C8506b.this.f39636a;
                    c cVar = c.this;
                    interfaceC8501c.mo52777x(cVar.f39678d, cVar.f39679e);
                }
            }

            public a(FeedBackRateRequest feedBackRateRequest) {
                super(feedBackRateRequest);
            }

            @Override // com.huawei.phoneservice.faq.base.util.BaseSdkUpdateRequest
            /* renamed from: c */
            public void onCallback(String str, String str2, String str3, FeedBackRateRequest feedBackRateRequest) {
                if ("accessToken".equals(str)) {
                    FaqSdk.getISdk().unregisterUpdateListener(this);
                    feedBackRateRequest.setAccessToken(str3);
                    FeedbackCommonManager.INSTANCE.postRate(C8506b.this.f39669c, feedBackRateRequest, new C14490a(C8470a.class, (Activity) C8506b.this.f39669c));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Class cls, Activity activity, boolean z10, C8472c c8472c, FeedBackRateRequest feedBackRateRequest) {
            super(cls, activity);
            this.f39678d = z10;
            this.f39679e = c8472c;
            this.f39680f = feedBackRateRequest;
        }

        @Override // com.huawei.phoneservice.faq.base.network.FaqCallback
        /* renamed from: h */
        public void onResult(Throwable th2, C8470a c8470a) {
            if (th2 == null) {
                ((InterfaceC8501c) C8506b.this.f39636a).mo52777x(this.f39678d, this.f39679e);
                return;
            }
            if (!(th2 instanceof FaqWebServiceException) || ((FaqWebServiceException) th2).errorCode != 401 || !FaqSdk.getISdk().haveSdkErr("accessToken")) {
                ((InterfaceC8501c) C8506b.this.f39636a).mo52776u(this.f39679e);
            } else {
                FaqSdk.getISdk().registerUpdateListener(new a(this.f39680f));
                FaqSdk.getISdk().onSdkErr("accessToken", SdkProblemManager.getSdk().getSdk("accessToken"));
            }
        }
    }

    public C8506b(InterfaceC8501c interfaceC8501c) {
        super(interfaceC8501c);
        this.f39668b = new Gson();
    }

    /* renamed from: b */
    public void m52830b(Context context) {
        this.f39669c = context;
    }

    /* renamed from: c */
    public void m52831c(FeedBackRateRequest feedBackRateRequest, boolean z10, C8472c c8472c) {
        FeedbackCommonManager feedbackCommonManager = FeedbackCommonManager.INSTANCE;
        Context context = this.f39669c;
        feedbackCommonManager.postRate(context, feedBackRateRequest, new c(C8470a.class, (Activity) context, z10, c8472c, feedBackRateRequest));
    }

    /* renamed from: d */
    public void m52832d(FeedBackRequest feedBackRequest) {
        SdkProblemManager.getManager().setRead(this.f39669c, feedBackRequest.getProblemId(), null);
        FeedbackCommonManager feedbackCommonManager = FeedbackCommonManager.INSTANCE;
        Context context = this.f39669c;
        feedbackCommonManager.getFeedBackList(context, feedBackRequest, new b(FeedBackResponse.class, (Activity) context, feedBackRequest));
    }

    /* renamed from: e */
    public void m52833e(String str, VideoCallBack videoCallBack, String str2, String str3) {
        SdkProblemManager.getManager().downLoadFile((Activity) this.f39669c, str, videoCallBack, str2);
    }

    /* renamed from: g */
    public void m52834g(FeedBackRequest feedBackRequest) {
        FeedbackCommonManager feedbackCommonManager = FeedbackCommonManager.INSTANCE;
        Context context = this.f39669c;
        feedbackCommonManager.getDataFromDetail(context, feedBackRequest, new a(FeedBackResponse.ProblemEnity.class, (Activity) context, feedBackRequest));
    }

    @Override // com.huawei.phoneservice.feedback.mvp.base.InterfaceC8497f
    /* renamed from: a */
    public void mo52765a() {
    }

    @Override // com.huawei.phoneservice.feedback.mvp.base.InterfaceC8497f
    /* renamed from: b */
    public void mo52766b() {
    }
}
