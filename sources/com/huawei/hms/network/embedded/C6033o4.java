package com.huawei.hms.network.embedded;

import com.huawei.hms.network.embedded.C5939h1;
import com.huawei.hms.network.httpclient.Interceptor;
import com.huawei.hms.network.httpclient.Response;
import com.huawei.hms.network.httpclient.ResponseBody;
import java.io.IOException;

/* renamed from: com.huawei.hms.network.embedded.o4 */
/* loaded from: classes8.dex */
public class C6033o4 extends Interceptor {
    @Override // com.huawei.hms.network.httpclient.Interceptor
    public Response<ResponseBody> intercept(Interceptor.Chain chain) throws IOException {
        Response<ResponseBody> responseProceed;
        C5939h1.d dVar = (C5939h1.d) chain.request();
        AbstractC6174z2 rCEventListener = ((C5939h1.b) chain).getRCEventListener();
        rCEventListener.cpNetworkInterceptorReqEnd();
        if (dVar.getNetConfig().enableInnerConnectEmptyBody()) {
            responseProceed = chain.proceed(chain.request());
        } else {
            AbstractC6046p4.m34963f().mo34976d();
            try {
                responseProceed = chain.proceed(chain.request());
                AbstractC6046p4.m34963f().mo34975c(true);
            } catch (Throwable th2) {
                AbstractC6046p4.m34963f().mo34975c(false);
                AbstractC6046p4.m34963f().mo34969a(chain);
                throw th2;
            }
        }
        AbstractC6046p4.m34963f().mo34969a(chain);
        rCEventListener.cpNetworkInterceptorResStart();
        return responseProceed;
    }
}
