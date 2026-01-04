package com.huawei.feedback;

/* loaded from: classes5.dex */
public class FeedbackHelper {
    public static final int FEEDBACK_EMAIL = 1;
    public static final int FEEDBACK_ERROR = 3;
    public static final int FEEDBACK_SDK = 2;
    private static int sFeedbackType = 3;

    public static int getFeedbackType() {
        return sFeedbackType;
    }

    public static void setFeedbackType(int i10) {
        sFeedbackType = i10;
    }
}
