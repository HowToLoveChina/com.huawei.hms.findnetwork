package com.huawei.hms.network.embedded;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.CheckParamUtils;
import com.huawei.hms.framework.common.ReflectionUtils;
import com.huawei.hms.framework.network.restclient.dnkeeper.DNKeeperManager;
import com.huawei.hms.framework.network.restclient.dnkeeper.RequestHost;
import com.huawei.hms.framework.network.restclient.hwhttp.dns.DnsResult;

/* renamed from: com.huawei.hms.network.embedded.v */
/* loaded from: classes8.dex */
public class C6119v implements InterfaceC5990l0 {

    /* renamed from: a */
    public static final String f28606a = "DefaultDNKeeper";

    /* renamed from: b */
    @SuppressLint({"StaticFieldLeak"})
    public static volatile C6119v f28607b;

    public C6119v(Context context) {
        DNKeeperManager.getInstance().init(context.getApplicationContext());
    }

    /* renamed from: a */
    private C6003m0 m35550a(DnsResult dnsResult) {
        C6003m0 c6003m0 = new C6003m0();
        if (dnsResult != null && !dnsResult.isEmpty()) {
            c6003m0.m34748c(dnsResult.getType());
            c6003m0.m34738a(dnsResult.getCreateTime());
            c6003m0.m34737a(dnsResult.getCache());
            c6003m0.m34746b(dnsResult.getIpList());
        }
        return c6003m0;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5990l0
    /* renamed from: a */
    public C6003m0 mo34635a(String str, String str2, int i10) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        RequestHost requestHost = new RequestHost(str);
        requestHost.setFailIP(str2);
        requestHost.setDnsFailType("" + i10);
        requestHost.enableAccelerate(true);
        return m35550a(DNKeeperManager.getInstance().queryIpsSync(requestHost));
    }

    /* renamed from: a */
    public static C6119v m35551a(Context context) {
        if (!ReflectionUtils.checkCompatible("com.huawei.hms.framework.network.restclient.dnkeeper.DNKeeperManager")) {
            return null;
        }
        CheckParamUtils.checkNotNull(context, "context == null");
        if (f28607b == null) {
            f28607b = new C6119v(context);
        }
        return f28607b;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5990l0
    /* renamed from: a */
    public String mo34636a() {
        return DNKeeperManager.getInstance().getDomainName();
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5990l0
    /* renamed from: a */
    public void mo34637a(int i10) {
        DNKeeperManager.getInstance().setRequestIntervalFailed(i10);
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5990l0
    /* renamed from: a */
    public boolean mo34638a(String str) {
        return DNKeeperManager.getInstance().removeCache(str);
    }
}
