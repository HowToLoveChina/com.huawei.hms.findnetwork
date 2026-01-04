package com.huawei.hms.network.conf.api;

import android.content.Context;
import android.os.Bundle;
import com.huawei.hms.network.embedded.C5976k;
import com.huawei.hms.network.inner.api.PolicyNetworkService;
import com.huawei.hms.network.inner.api.RequestContext;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public class DefaultConfigService extends PolicyNetworkService {
    @Override // com.huawei.hms.network.inner.api.PolicyNetworkService
    public void beginRequest(RequestContext requestContext) {
    }

    @Override // com.huawei.hms.network.inner.api.PolicyNetworkService
    public void endRequest(RequestContext requestContext) {
    }

    @Override // com.huawei.hms.network.inner.api.NetworkService
    public String getServiceName() {
        return DefaultConfigService.class.getName();
    }

    @Override // com.huawei.hms.network.inner.api.PolicyNetworkService, com.huawei.hms.network.inner.api.NetworkService
    public String getServiceType() {
        return DefaultConfigService.class.getName();
    }

    @Override // com.huawei.hms.network.inner.api.PolicyNetworkService
    public String getValue(String str, String str2) {
        Object objM34558a = C5976k.m34556b().m34558a(str2);
        if (objM34558a != null) {
            return String.valueOf(objM34558a);
        }
        return null;
    }

    @Override // com.huawei.hms.network.inner.api.PolicyNetworkService
    public Map<String, String> getValues(String str, String... strArr) {
        HashMap map = new HashMap();
        for (String str2 : strArr) {
            String value = getValue(str, str2);
            if (!value.isEmpty()) {
                map.put(str2, value);
            }
        }
        return map;
    }

    @Override // com.huawei.hms.network.inner.api.NetworkService
    public String getVersion() {
        return "8.0.1.309";
    }

    @Override // com.huawei.hms.network.inner.api.NetworkService
    public void onCreate(Context context, Bundle bundle) {
    }

    @Override // com.huawei.hms.network.inner.api.NetworkService
    public void onDestroy(Context context) {
    }
}
