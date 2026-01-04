package com.huawei.phoneservice.feedback.mvp.contract;

import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.phoneservice.feedback.mvp.base.InterfaceC8498g;
import com.huawei.phoneservice.feedbackcommon.entity.FeedBackResponse;
import java.util.List;

/* renamed from: com.huawei.phoneservice.feedback.mvp.contract.e */
/* loaded from: classes5.dex */
public interface InterfaceC8503e extends InterfaceC8498g {
    void deleteLocalData();

    /* renamed from: n */
    void mo52778n(List<FeedBackResponse.ProblemEnity> list, List<FeedBackResponse.ProblemEnity> list2);

    void setErrorView(FaqConstants.FaqErrorCode faqErrorCode);

    void setThrowableView(Throwable th2);

    void showErrorToast();
}
