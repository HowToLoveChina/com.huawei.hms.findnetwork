package com.huawei.hms.network.file.api;

import com.huawei.hms.network.file.api.Request;
import com.huawei.hms.network.file.core.task.ITaskResult;

/* loaded from: classes8.dex */
public interface Converter<R extends Request, T> {
    T convertResponse(R r10, ITaskResult iTaskResult);
}
