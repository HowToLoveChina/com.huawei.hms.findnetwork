package com.huawei.hms.network.file.core.task;

import com.huawei.hms.network.file.api.Request;
import com.huawei.hms.network.httpclient.Submit;
import java.util.concurrent.Future;

/* renamed from: com.huawei.hms.network.file.core.task.e */
/* loaded from: classes8.dex */
public interface InterfaceC6234e<R extends Request> {

    /* renamed from: com.huawei.hms.network.file.core.task.e$a */
    public enum a {
        INIT,
        PROCESS,
        PAUSE,
        CANCEL,
        INVALID
    }

    /* renamed from: com.huawei.hms.network.file.core.task.e$b */
    public enum b {
        DOWNLOAD,
        UPLOAD
    }

    /* renamed from: a */
    long mo36022a();

    /* renamed from: a */
    void mo36233a(R r10);

    /* renamed from: a */
    void mo36234a(String str);

    /* renamed from: a */
    void mo36235a(Future<?> future);

    /* renamed from: a */
    void mo36236a(boolean z10);

    /* renamed from: b */
    void mo36237b(boolean z10);

    /* renamed from: b */
    boolean mo36238b();

    /* renamed from: c */
    long mo36239c();

    /* renamed from: d */
    b mo36026d();

    /* renamed from: e */
    Future<?> mo36240e();

    /* renamed from: f */
    long mo36241f();

    /* renamed from: g */
    Submit mo36242g();

    /* renamed from: h */
    boolean mo36243h();
}
