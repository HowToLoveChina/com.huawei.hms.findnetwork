package com.huawei.hms.network.file.core.task;

import com.huawei.hms.network.file.api.Request;
import com.huawei.hms.network.file.api.Result;
import com.huawei.hms.network.file.core.C6227e;
import com.huawei.hms.network.file.core.task.AbstractC6240k;
import com.huawei.hms.network.file.core.task.InterfaceC6234e;
import com.huawei.hms.network.file.core.task.InterfaceC6236g;
import java.util.List;
import java.util.Set;

/* renamed from: com.huawei.hms.network.file.core.task.c */
/* loaded from: classes8.dex */
public interface InterfaceC6232c<R extends Request, T extends AbstractC6240k, P extends InterfaceC6236g> {
    /* renamed from: a */
    Result mo35984a(R r10);

    /* renamed from: a */
    ITaskResult mo35986a(R r10, List<T> list);

    /* renamed from: a */
    C6239j mo35989a();

    /* renamed from: a */
    List<T> mo35990a(R r10, List<T> list, long j10);

    /* renamed from: a */
    List<R> mo35992a(boolean z10);

    /* renamed from: a */
    Set<Long> mo35993a(int i10);

    /* renamed from: a */
    void mo35994a(long j10);

    /* renamed from: a */
    void mo35996a(long j10, boolean z10);

    /* renamed from: a */
    void mo35998a(R r10, InterfaceC6234e.a aVar);

    /* renamed from: a */
    boolean mo36000a(List<T> list);

    /* renamed from: b */
    P mo36001b();

    /* renamed from: b */
    List<T> mo36002b(long j10);

    /* renamed from: b */
    void mo36004b(R r10);

    /* renamed from: b */
    void mo36005b(R r10, InterfaceC6234e.a aVar);

    /* renamed from: b */
    void mo36007b(List<T> list);

    /* renamed from: c */
    C6227e<R> mo36008c(long j10);

    /* renamed from: c */
    List<T> mo36009c(R r10);

    /* renamed from: c */
    void mo36010c();
}
