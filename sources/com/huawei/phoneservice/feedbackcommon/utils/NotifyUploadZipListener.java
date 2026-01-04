package com.huawei.phoneservice.feedbackcommon.utils;

import com.huawei.phoneservice.feedbackcommon.entity.FeedbackZipBean;
import java.util.List;

/* loaded from: classes5.dex */
public interface NotifyUploadZipListener {
    void notifyUpload(List<FeedbackZipBean> list, boolean z10);

    void notifyUploadAgain(long j10);
}
