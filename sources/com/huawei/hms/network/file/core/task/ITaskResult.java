package com.huawei.hms.network.file.core.task;

import com.huawei.hms.network.file.core.FileManagerException;
import com.huawei.hms.network.file.core.task.AbstractC6240k;
import java.io.Closeable;

/* loaded from: classes8.dex */
public interface ITaskResult<R extends AbstractC6240k> {
    int getErrorCode();

    String getErrorMessage();

    FileManagerException getException();

    Closeable getRawResponse();

    InterfaceC6234e getTask();

    void setException(FileManagerException fileManagerException);

    void setRawResponse(Closeable closeable);

    void setTask(R r10);
}
