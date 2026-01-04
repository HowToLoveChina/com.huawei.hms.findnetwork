package com.huawei.hms.network.httpclient.excutor;

import android.content.Context;
import android.os.Bundle;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.network.embedded.C5898e;
import com.huawei.hms.network.inner.api.PolicyNetworkService;
import com.huawei.hms.network.inner.api.RequestContext;
import com.huawei.openalliance.p169ad.constant.ParamConstants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;

/* loaded from: classes8.dex */
public class ProcessPolicyNetworkService extends PolicyNetworkService {
    public static final String TAG = "PolicyService";
    public C5898e baseConfig = new C5898e("");

    @Override // com.huawei.hms.network.inner.api.PolicyNetworkService
    public void beginRequest(RequestContext requestContext) {
        Logger.m32143v(TAG, ParamConstants.Param.CONTEXT);
    }

    @Override // com.huawei.hms.network.inner.api.PolicyNetworkService
    public void endRequest(RequestContext requestContext) {
        Logger.m32143v(TAG, ParamConstants.Param.CONTEXT);
    }

    @Override // com.huawei.hms.network.inner.api.PolicyNetworkService
    public String getPolicyNetworkServiceParams() {
        return this.baseConfig.toString();
    }

    @Override // com.huawei.hms.network.inner.api.NetworkService
    public String getServiceName() {
        return ProcessPolicyNetworkService.class.getName();
    }

    @Override // com.huawei.hms.network.inner.api.PolicyNetworkService, com.huawei.hms.network.inner.api.NetworkService
    public String getServiceType() {
        return ProcessPolicyNetworkService.class.getName();
    }

    @Override // com.huawei.hms.network.inner.api.PolicyNetworkService
    public String getValue(String str, String str2) {
        return this.baseConfig.get(str2);
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
        Logger.m32143v(TAG, "onCreate");
    }

    @Override // com.huawei.hms.network.inner.api.NetworkService
    public void onDestroy(Context context) {
        Logger.m32143v(TAG, "onDestroy");
    }

    public void setValue(String str, Object obj) throws JSONException {
        this.baseConfig.setValue(str, obj);
    }

    public void setValues(String str) {
        Logger.m32141i(TAG, "options = " + str);
        this.baseConfig.setOption(str);
    }
}
