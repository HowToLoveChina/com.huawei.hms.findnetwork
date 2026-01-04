package com.huawei.hms.support.hwid.common.cloudservice;

import android.os.Bundle;
import com.huawei.hwid.core.helper.handler.ErrorStatus;

/* loaded from: classes8.dex */
public interface CloudRequestHandler {
    void onError(ErrorStatus errorStatus);

    void onFinish(Bundle bundle);
}
