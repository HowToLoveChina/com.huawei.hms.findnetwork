package com.huawei.phoneservice.feedback.mvp.contract;

import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.phoneservice.feedback.entity.C8472c;
import com.huawei.phoneservice.feedback.mvp.base.InterfaceC8498g;
import com.huawei.phoneservice.feedbackcommon.entity.FeedBackResponse;
import java.util.List;

/* renamed from: com.huawei.phoneservice.feedback.mvp.contract.c */
/* loaded from: classes5.dex */
public interface InterfaceC8501c extends InterfaceC8498g {
    /* renamed from: a */
    void mo52773a(FeedBackResponse.ProblemEnity problemEnity);

    /* renamed from: a */
    void mo52774a(List<FeedBackResponse.ProblemEnity> list);

    /* renamed from: d */
    void mo52775d();

    void setErrorView(FaqConstants.FaqErrorCode faqErrorCode);

    void setThrowableView(Throwable th2);

    /* renamed from: u */
    void mo52776u(C8472c c8472c);

    /* renamed from: x */
    void mo52777x(boolean z10, C8472c c8472c);
}
