package com.huawei.hms.network.file.p130a;

import com.huawei.hms.network.file.api.GlobalRequestConfig;
import com.huawei.hms.network.file.core.Constants;
import com.huawei.hms.network.file.core.task.AbstractC6240k;
import com.huawei.hms.network.file.core.task.C6241l;
import com.huawei.hms.network.file.core.task.InterfaceC6231b;
import com.huawei.hms.network.file.core.task.InterfaceC6235f;
import com.huawei.hms.network.file.core.task.InterfaceC6236g;
import com.huawei.hms.network.file.core.util.FLogger;
import com.huawei.hms.network.file.download.api.GetRequest;
import com.huawei.hms.network.httpclient.HttpClient;
import com.huawei.hms.network.httpclient.Response;

/* renamed from: com.huawei.hms.network.file.a.e */
/* loaded from: classes8.dex */
public class C6189e implements InterfaceC6236g<AbstractC6240k<GetRequest>, C6241l> {

    /* renamed from: a */
    InterfaceC6235f f29278a;

    /* renamed from: b */
    InterfaceC6231b f29279b;

    /* renamed from: c */
    GlobalRequestConfig f29280c;

    /* renamed from: d */
    HttpClient f29281d;

    public C6189e(GlobalRequestConfig globalRequestConfig, HttpClient httpClient) {
        this.f29280c = globalRequestConfig;
        this.f29281d = httpClient;
    }

    @Override // com.huawei.hms.network.file.core.task.InterfaceC6236g
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C6241l mo36033a(AbstractC6240k<GetRequest> abstractC6240k) {
        GlobalRequestConfig globalRequestConfigGenMergedRequestConfig = this.f29280c;
        if (((GetRequest) abstractC6240k.m36341p()).getConfig() != null) {
            globalRequestConfigGenMergedRequestConfig = globalRequestConfigGenMergedRequestConfig.genMergedRequestConfig(((GetRequest) abstractC6240k.m36341p()).getConfig());
        }
        this.f29279b = new C6185a(globalRequestConfigGenMergedRequestConfig, this.f29281d);
        FLogger.m36353i("Downloader", "process task:" + abstractC6240k, new Object[0]);
        Response response = (Response) this.f29279b.mo35975a(abstractC6240k, this.f29278a);
        C6241l c6241l = new C6241l(Constants.ErrorCode.SUCCESS);
        c6241l.setTask(abstractC6240k);
        abstractC6240k.m36323a(c6241l);
        c6241l.setRawResponse(response);
        abstractC6240k.m36332c(true);
        return c6241l;
    }

    @Override // com.huawei.hms.network.file.core.task.InterfaceC6236g
    /* renamed from: a */
    public void mo36035a(InterfaceC6235f interfaceC6235f) {
        this.f29278a = interfaceC6235f;
    }
}
