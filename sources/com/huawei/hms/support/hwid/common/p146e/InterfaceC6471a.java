package com.huawei.hms.support.hwid.common.p146e;

import com.huawei.hms.framework.network.restclient.Submit;
import com.huawei.hms.framework.network.restclient.annotate.Body;
import com.huawei.hms.framework.network.restclient.annotate.POST;
import com.huawei.hms.framework.network.restclient.annotate.Url;
import com.huawei.hms.framework.network.restclient.hwhttp.RequestBody;
import com.huawei.hms.framework.network.restclient.hwhttp.ResponseBody;

/* renamed from: com.huawei.hms.support.hwid.common.e.a */
/* loaded from: classes8.dex */
public interface InterfaceC6471a {
    @POST
    /* renamed from: a */
    Submit<ResponseBody> m36868a(@Url String str, @Body RequestBody requestBody);
}
