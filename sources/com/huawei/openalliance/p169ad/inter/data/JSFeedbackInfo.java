package com.huawei.openalliance.p169ad.inter.data;

import com.huawei.openalliance.p169ad.annotations.DataKeep;

@DataKeep
/* loaded from: classes2.dex */
public class JSFeedbackInfo extends FeedbackInfo {
    private String idStr;

    public JSFeedbackInfo(FeedbackInfo feedbackInfo) {
        if (feedbackInfo != null) {
            m44466a(feedbackInfo.m44464a());
            m44465a(feedbackInfo.getType());
            m44467a(feedbackInfo.getLabel());
            this.idStr = String.valueOf(feedbackInfo.m44464a());
        }
    }
}
