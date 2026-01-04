package com.huawei.hms.network.embedded;

import android.text.TextUtils;
import android.util.LruCache;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.network.base.common.Headers;
import com.huawei.hms.network.embedded.C5939h1;
import com.huawei.hms.network.httpclient.Interceptor;
import com.huawei.hms.network.httpclient.Request;
import com.huawei.hms.network.httpclient.Response;
import com.huawei.hms.network.httpclient.ResponseBody;
import java.net.URL;

/* renamed from: com.huawei.hms.network.embedded.h3 */
/* loaded from: classes8.dex */
public class C5941h3 extends Interceptor {

    /* renamed from: a */
    public static final String f26915a = "MultiHostChange";

    /* renamed from: b */
    public static final int f26916b = 256;

    /* renamed from: c */
    public static final LruCache<String, C5902e3> f26917c = new LruCache<>(256);

    /* renamed from: d */
    public static final String f26918d = "Multi-Cloud-Svc";

    /* renamed from: e */
    public static final String f26919e = "host";

    /* renamed from: f */
    public static final String f26920f = ";";

    /* renamed from: g */
    public static final String f26921g = "=";

    /* renamed from: h */
    public static final String f26922h = ":";

    /* renamed from: i */
    public static final int f26923i = -1;

    /* renamed from: a */
    private String m34344a(String str, String str2) {
        if (str != null && !str.isEmpty()) {
            for (String str3 : str.split(";")) {
                String[] strArrSplit = str3.split("=");
                if (strArrSplit.length == 2 && str2.equals(strArrSplit[0].trim())) {
                    return strArrSplit[1].trim();
                }
            }
        }
        return "";
    }

    @Override // com.huawei.hms.network.httpclient.Interceptor
    public Response<ResponseBody> intercept(Interceptor.Chain chain) throws Exception {
        Request request = chain.request();
        String url = request.getUrl();
        URL url2 = new URL(url);
        String host = url2.getHost();
        int port = url2.getPort();
        LruCache<String, C5902e3> lruCache = f26917c;
        C5902e3 c5902e3 = lruCache.get(host);
        boolean zIsHealthy = c5902e3 != null ? c5902e3.isHealthy(!request.getMethod().equals("GET")) : false;
        Logger.m32144v(f26915a, "whether the connection is OK ? %s", Boolean.valueOf(zIsHealthy));
        Logger.m32144v(f26915a, "Before the MultiHostChange,the request is = %s", request);
        if (zIsHealthy) {
            String host2 = c5902e3.getHost();
            if (host2 != null) {
                if (port != -1) {
                    host = host + ":" + port;
                }
                request = request.newBuilder().url(new C5888d3(url.replaceFirst(host, host2)).getUrl()).build();
            }
        } else {
            lruCache.remove(host);
        }
        Logger.m32144v(f26915a, "after the MultiHost,the request is = %s", request);
        try {
            Response<ResponseBody> responseProceed = chain.proceed(request);
            if (responseProceed != null) {
                String str = Headers.m33636of(responseProceed.getHeaders()).get(f26918d);
                Logger.m32144v(f26915a, "the headers that you need is : %s", str);
                String strM34344a = m34344a(str, "host");
                if (TextUtils.isEmpty(strM34344a) || !(chain instanceof C5939h1.b)) {
                    return responseProceed;
                }
                InterfaceC5886d1 requestTask = ((C5939h1.b) chain).getRequestTask();
                if (requestTask != null) {
                    C5902e3 connectionInfo = requestTask.getConnectionInfo();
                    if (connectionInfo != null) {
                        lruCache.put(strM34344a, connectionInfo);
                    } else {
                        Logger.m32145w(f26915a, "cacheMapFailed,because the message is null!");
                    }
                }
                Logger.m32144v(f26915a, "the cache size is %d \n %s", Integer.valueOf(lruCache.size()), lruCache.snapshot());
            }
            return responseProceed;
        } catch (Exception e10) {
            f26917c.remove(host);
            throw e10;
        }
    }
}
