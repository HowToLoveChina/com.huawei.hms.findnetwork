package com.huawei.phoneservice.feedbackcommon.utils;

import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.phoneservice.feedbackcommon.entity.FeedBackResponse;
import java.util.List;

/* loaded from: classes5.dex */
public interface OnHistoryListener {
    void setErrorView(FaqConstants.FaqErrorCode faqErrorCode);

    void setThrowableView(Throwable th2);

    void showData(List<FeedBackResponse.ProblemEnity> list, List<FeedBackResponse.ProblemEnity> list2);
}
