package com.huawei.phoneservice.feedback.mvp.presenter;

import android.content.Context;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.phoneservice.feedback.mvp.base.AbstractC8492a;
import com.huawei.phoneservice.feedback.mvp.contract.InterfaceC8502d;
import com.huawei.phoneservice.feedback.mvp.contract.InterfaceC8503e;
import com.huawei.phoneservice.feedbackcommon.entity.FeedBackRequest;
import com.huawei.phoneservice.feedbackcommon.entity.FeedBackResponse;
import com.huawei.phoneservice.feedbackcommon.utils.OnDeleteHistoryListener;
import com.huawei.phoneservice.feedbackcommon.utils.OnHistoryListener;
import com.huawei.phoneservice.feedbackcommon.utils.SdkProblemManager;
import java.util.List;

/* renamed from: com.huawei.phoneservice.feedback.mvp.presenter.c */
/* loaded from: classes5.dex */
public class C8507c extends AbstractC8492a<InterfaceC8503e> implements InterfaceC8502d {

    /* renamed from: b */
    public Context f39684b;

    /* renamed from: c */
    public OnHistoryListener f39685c;

    /* renamed from: d */
    public final OnDeleteHistoryListener f39686d;

    /* renamed from: com.huawei.phoneservice.feedback.mvp.presenter.c$a */
    public class a implements OnHistoryListener {
        public a() {
        }

        @Override // com.huawei.phoneservice.feedbackcommon.utils.OnHistoryListener
        public void setErrorView(FaqConstants.FaqErrorCode faqErrorCode) {
            ((InterfaceC8503e) C8507c.this.f39636a).setErrorView(faqErrorCode);
        }

        @Override // com.huawei.phoneservice.feedbackcommon.utils.OnHistoryListener
        public void setThrowableView(Throwable th2) {
            ((InterfaceC8503e) C8507c.this.f39636a).setThrowableView(th2);
        }

        @Override // com.huawei.phoneservice.feedbackcommon.utils.OnHistoryListener
        public void showData(List<FeedBackResponse.ProblemEnity> list, List<FeedBackResponse.ProblemEnity> list2) {
            ((InterfaceC8503e) C8507c.this.f39636a).mo52778n(list, list2);
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.mvp.presenter.c$b */
    public class b implements OnDeleteHistoryListener {
        public b() {
        }

        @Override // com.huawei.phoneservice.feedbackcommon.utils.OnDeleteHistoryListener
        public void deleteLocalData() {
            if (C8507c.this.f39636a == null) {
                return;
            }
            ((InterfaceC8503e) C8507c.this.f39636a).deleteLocalData();
        }

        @Override // com.huawei.phoneservice.feedbackcommon.utils.OnDeleteHistoryListener
        public void showErrorToast() {
            if (C8507c.this.f39636a == null) {
                return;
            }
            ((InterfaceC8503e) C8507c.this.f39636a).showErrorToast();
        }
    }

    public C8507c(InterfaceC8503e interfaceC8503e) {
        super(interfaceC8503e);
        this.f39685c = new a();
        this.f39686d = new b();
    }

    /* renamed from: b */
    public void m52851b(Context context) {
        this.f39684b = context;
    }

    /* renamed from: c */
    public void m52852c(FeedBackRequest feedBackRequest) {
        SdkProblemManager.getManager().getFeedBackList(this.f39684b, feedBackRequest.getProblemId(), feedBackRequest.getPageSize(), feedBackRequest.getStartWith(), feedBackRequest.getOrderType(), this.f39685c);
    }

    /* renamed from: d */
    public void m52853d(String str) {
        SdkProblemManager.getManager().deleteHistory(this.f39684b, str, this.f39686d);
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
