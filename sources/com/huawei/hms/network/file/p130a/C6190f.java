package com.huawei.hms.network.file.p130a;

import com.huawei.hms.network.file.api.Converter;
import com.huawei.hms.network.file.core.task.ITaskResult;
import com.huawei.hms.network.file.download.api.GetRequest;
import java.io.File;

/* renamed from: com.huawei.hms.network.file.a.f */
/* loaded from: classes8.dex */
public final class C6190f implements Converter<GetRequest, File> {
    @Override // com.huawei.hms.network.file.api.Converter
    /* renamed from: a */
    public File convertResponse(GetRequest getRequest, ITaskResult iTaskResult) {
        if (iTaskResult.getTask() instanceof C6188d) {
            return new File(((C6188d) iTaskResult.getTask()).m36032z());
        }
        return null;
    }
}
