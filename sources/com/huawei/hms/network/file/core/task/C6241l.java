package com.huawei.hms.network.file.core.task;

import com.huawei.hms.network.file.core.Constants;
import com.huawei.hms.network.file.core.FileManagerException;
import com.huawei.hms.network.file.core.task.AbstractC6240k;
import java.io.Closeable;

/* renamed from: com.huawei.hms.network.file.core.task.l */
/* loaded from: classes8.dex */
public class C6241l<R extends AbstractC6240k> implements ITaskResult<R> {

    /* renamed from: a */
    int f29486a;

    /* renamed from: b */
    String f29487b;

    /* renamed from: c */
    FileManagerException f29488c;

    /* renamed from: d */
    Closeable f29489d;

    /* renamed from: e */
    R f29490e;

    public C6241l(Constants.ErrorCode errorCode) {
        this.f29486a = errorCode.getErrorCode();
        this.f29487b = errorCode.getErrorMessage();
    }

    /* renamed from: a */
    public void m36349a(String str) {
        this.f29487b = str;
    }

    @Override // com.huawei.hms.network.file.core.task.ITaskResult
    public int getErrorCode() {
        return this.f29486a;
    }

    @Override // com.huawei.hms.network.file.core.task.ITaskResult
    public String getErrorMessage() {
        return this.f29487b;
    }

    @Override // com.huawei.hms.network.file.core.task.ITaskResult
    public FileManagerException getException() {
        return this.f29488c;
    }

    @Override // com.huawei.hms.network.file.core.task.ITaskResult
    public Closeable getRawResponse() {
        return this.f29489d;
    }

    @Override // com.huawei.hms.network.file.core.task.ITaskResult
    public InterfaceC6234e getTask() {
        return this.f29490e;
    }

    @Override // com.huawei.hms.network.file.core.task.ITaskResult
    public void setException(FileManagerException fileManagerException) {
        this.f29488c = fileManagerException;
    }

    @Override // com.huawei.hms.network.file.core.task.ITaskResult
    public void setRawResponse(Closeable closeable) {
        this.f29489d = closeable;
    }

    @Override // com.huawei.hms.network.file.core.task.ITaskResult
    public void setTask(R r10) {
        this.f29490e = r10;
    }

    public String toString() {
        return "TaskResult{errorCode=" + this.f29486a + ", message='" + this.f29487b + "', rawResponse=" + this.f29489d + '}';
    }
}
