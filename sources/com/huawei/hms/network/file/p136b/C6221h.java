package com.huawei.hms.network.file.p136b;

import com.huawei.hms.network.file.api.GlobalRequestConfig;
import com.huawei.hms.network.file.core.Constants;
import com.huawei.hms.network.file.core.task.C6241l;
import com.huawei.hms.network.file.core.task.InterfaceC6231b;
import com.huawei.hms.network.file.core.task.InterfaceC6235f;
import com.huawei.hms.network.file.core.task.InterfaceC6236g;
import com.huawei.hms.network.file.core.util.FLogger;
import com.huawei.hms.network.file.upload.api.BodyRequest;
import com.huawei.hms.network.httpclient.HttpClient;
import java.io.Closeable;

/* renamed from: com.huawei.hms.network.file.b.h */
/* loaded from: classes8.dex */
public class C6221h implements InterfaceC6236g<C6219f, C6241l> {

    /* renamed from: a */
    InterfaceC6235f f29362a;

    /* renamed from: b */
    GlobalRequestConfig f29363b;

    /* renamed from: c */
    InterfaceC6231b f29364c;

    /* renamed from: d */
    HttpClient f29365d;

    public C6221h(GlobalRequestConfig globalRequestConfig, HttpClient httpClient) {
        this.f29363b = globalRequestConfig;
        this.f29365d = httpClient;
    }

    @Override // com.huawei.hms.network.file.core.task.InterfaceC6236g
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C6241l mo36033a(C6219f c6219f) {
        FLogger.m36353i("Uploader", "process task:" + c6219f, new Object[0]);
        GlobalRequestConfig globalRequestConfigGenMergedRequestConfig = this.f29363b;
        if (((BodyRequest) c6219f.m36341p()).getConfig() != null) {
            globalRequestConfigGenMergedRequestConfig = globalRequestConfigGenMergedRequestConfig.genMergedRequestConfig(((BodyRequest) c6219f.m36341p()).getConfig());
        }
        C6215b c6215b = new C6215b(globalRequestConfigGenMergedRequestConfig, this.f29365d);
        this.f29364c = c6215b;
        Closeable closeableMo35975a = c6215b.mo35975a((C6215b) c6219f, this.f29362a);
        C6241l c6241l = new C6241l(Constants.ErrorCode.SUCCESS);
        c6241l.setTask(c6219f);
        c6241l.setRawResponse(closeableMo35975a);
        c6219f.m36323a(c6241l);
        c6241l.m36349a(c6219f.mo36241f() + " finished success");
        c6219f.m36332c(true);
        return c6241l;
    }

    @Override // com.huawei.hms.network.file.core.task.InterfaceC6236g
    /* renamed from: a */
    public void mo36035a(InterfaceC6235f interfaceC6235f) {
        this.f29362a = interfaceC6235f;
    }
}
