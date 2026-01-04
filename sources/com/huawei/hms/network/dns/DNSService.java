package com.huawei.hms.network.dns;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.framework.common.CheckParamUtils;
import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.NetworkUtil;
import com.huawei.hms.network.embedded.C6093t;
import com.huawei.hms.network.embedded.C6119v;
import com.huawei.hms.network.embedded.C6132w;
import com.huawei.hms.network.embedded.C6158y;
import com.huawei.hms.network.httpclient.Response;
import com.huawei.hms.network.httpclient.ResponseBody;
import com.huawei.hms.network.inner.api.DnsNetworkService;
import com.huawei.hms.network.inner.api.PolicyNetworkService;
import com.huawei.hms.network.inner.api.RequestContext;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: classes8.dex */
public class DNSService extends DnsNetworkService {
    public static final String TAG = "DNSService";
    public String falseStr = "false";

    /* renamed from: com.huawei.hms.network.dns.DNSService$b */
    public static final class RunnableC5841b implements Runnable {
        public RunnableC5841b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C6093t.m35329m().m35334a();
        }
    }

    private void printDnsIps(List<InetAddress> list) {
        ArrayList arrayList = new ArrayList();
        try {
            Iterator<InetAddress> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getHostAddress());
            }
        } catch (NullPointerException e10) {
            Logger.m32145w(TAG, e10);
        }
        Logger.m32143v(TAG, "dns ips:" + Arrays.toString(arrayList.toArray()));
    }

    @Override // com.huawei.hms.network.inner.api.DnsNetworkService
    public void beginEachRequest(RequestContext requestContext) {
        C6093t.m35329m().m35363g(NetworkUtil.getHost(requestContext.request().getUrl()));
    }

    @Override // com.huawei.hms.network.inner.api.NetworkService
    public void clear() {
        try {
            C6158y.m35827b().execute(new RunnableC5841b());
        } catch (RejectedExecutionException e10) {
            Logger.m32146w(TAG, "Execute clear error", e10);
        }
    }

    @Override // com.huawei.hms.network.inner.api.DnsNetworkService
    public void dnsPrefetch(String str) {
        C6093t.m35325i(str);
    }

    @Override // com.huawei.hms.network.inner.api.DnsNetworkService
    public void endEachRequest(RequestContext requestContext) {
        Response<ResponseBody> response = requestContext.response();
        Throwable thThrowable = requestContext.throwable();
        if (response != null) {
            C6093t.m35329m().m35342a(NetworkUtil.getHost(requestContext.request().getUrl()), (String) Integer.valueOf(response.getCode()));
        } else {
            if (requestContext.isCancel()) {
                return;
            }
            C6093t.m35329m().m35342a(NetworkUtil.getHost(requestContext.request().getUrl()), (String) thThrowable);
        }
    }

    @Override // com.huawei.hms.network.inner.api.DnsNetworkService
    public int getDnsCache() {
        return C6093t.m35329m().m35359f();
    }

    @Override // com.huawei.hms.network.inner.api.DnsNetworkService
    public int getDnsStatus() {
        return C6093t.m35329m().m35362g();
    }

    @Override // com.huawei.hms.network.inner.api.DnsNetworkService
    public long getDnsTtl() {
        return C6093t.m35329m().m35364h();
    }

    @Override // com.huawei.hms.network.inner.api.DnsNetworkService
    public String getDnsType() {
        return C6093t.m35329m().m35333a(C6093t.m35329m().m35365i());
    }

    @Override // com.huawei.hms.network.inner.api.NetworkService
    public String getServiceName() {
        return "dns";
    }

    @Override // com.huawei.hms.network.inner.api.NetworkService
    public String getServiceType() {
        return null;
    }

    @Override // com.huawei.hms.network.inner.api.NetworkService
    public String getVersion() {
        return "8.0.1.309";
    }

    @Override // com.huawei.hms.network.inner.api.DnsNetworkService
    public List<InetAddress> lookup(String str) throws UnknownHostException {
        List<InetAddress> listM35350c;
        try {
            listM35350c = C6093t.m35329m().m35350c(str);
        } catch (UnknownHostException e10) {
            throw e10;
        } catch (Throwable th2) {
            Logger.m32139e(TAG, "may be error", th2);
            listM35350c = null;
        }
        if (listM35350c == null || listM35350c.isEmpty()) {
            return C6158y.m35826b(str);
        }
        if (getDnsType().equals(C6132w.f28815k) && getDnsCache() != 1) {
            Logger.m32143v(TAG, "localDns server use default ip list");
            return listM35350c;
        }
        if (!NetworkUtil.isSupportIpv6Net()) {
            Iterator<InetAddress> it = listM35350c.iterator();
            while (it.hasNext()) {
                InetAddress next = it.next();
                if (CheckParamUtils.isIpV6(next.getHostAddress())) {
                    Logger.m32143v(TAG, "remove ipv6 address:" + next.getHostAddress());
                    it.remove();
                }
            }
        }
        return listM35350c;
    }

    @Override // com.huawei.hms.network.inner.api.NetworkService
    public void onCreate(Context context, Bundle bundle) {
        C6093t.m35329m().m35336a(ContextHolder.getAppContext(), C6119v.m35551a(context));
    }

    @Override // com.huawei.hms.network.inner.api.NetworkService
    public void onDestroy(Context context) {
    }

    @Override // com.huawei.hms.network.inner.api.NetworkService
    public void serviceOptions(Map<String, String> map) {
        C6093t c6093tM35329m;
        boolean z10;
        C6093t.m35329m().m35343a(Boolean.parseBoolean(map.get(PolicyNetworkService.GlobalConstants.ENABLE_HTTPDNS)));
        C6093t.m35329m().m35346b(Integer.parseInt(map.get(PolicyNetworkService.GlobalConstants.DNS_RESULT_TTL)));
        if (TextUtils.equals(this.falseStr, map.get("core_enable_ipv6_preferred"))) {
            c6093tM35329m = C6093t.m35329m();
            z10 = false;
        } else {
            c6093tM35329m = C6093t.m35329m();
            z10 = true;
        }
        c6093tM35329m.m35348b(z10);
        try {
            C6093t.m35329m().m35352c(Boolean.parseBoolean(map.get("core_enable_site_detect")));
        } catch (NumberFormatException unused) {
            Logger.m32145w(TAG, "Parse enable_site_detect error");
        }
        try {
            C6093t.m35329m().m35335a(Long.parseLong(map.get(PolicyNetworkService.GlobalConstants.SITE_DETECT_THRESHOLD)));
        } catch (NumberFormatException unused2) {
            Logger.m32145w(TAG, "Parse site_detect_threshold error");
        }
    }
}
