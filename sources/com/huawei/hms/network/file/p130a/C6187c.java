package com.huawei.hms.network.file.p130a;

import com.huawei.hms.network.file.api.Request;
import com.huawei.hms.network.file.core.task.C6239j;
import com.huawei.hms.network.file.core.task.InterfaceC6232c;
import com.huawei.hms.network.file.download.api.GetRequest;
import java.util.List;

/* renamed from: com.huawei.hms.network.file.a.c */
/* loaded from: classes8.dex */
public class C6187c extends C6239j<GetRequest, C6188d> {
    public C6187c(InterfaceC6232c interfaceC6232c) {
        super(interfaceC6232c);
    }

    @Override // com.huawei.hms.network.file.core.task.C6239j, com.huawei.hms.network.file.core.task.InterfaceC6233d
    /* renamed from: a */
    public long mo36015a(List<C6188d> list) {
        long jMo36232b = mo36232b(list) - this.f29462f;
        long jMo36230a = mo36230a();
        if (jMo36230a == 0) {
            return 0L;
        }
        return (long) ((jMo36232b / jMo36230a) * 1000.0d);
    }

    @Override // com.huawei.hms.network.file.core.task.C6239j
    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo36016a(Request request, List list) {
        m36017a((GetRequest) request, (List<C6188d>) list);
    }

    /* renamed from: a */
    public void m36017a(GetRequest getRequest, List<C6188d> list) {
        super.mo36016a((C6187c) getRequest, (List) list);
        if (this.f29458b <= 0) {
            this.f29458b = m36311c(list);
        }
    }
}
