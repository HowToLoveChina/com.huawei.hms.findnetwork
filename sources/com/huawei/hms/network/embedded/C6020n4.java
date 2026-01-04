package com.huawei.hms.network.embedded;

import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.network.inner.api.NetworkKitInnerImpl;
import com.huawei.hms.network.inner.api.NetworkService;
import com.huawei.hms.network.inner.api.PolicyNetworkService;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.network.embedded.n4 */
/* loaded from: classes8.dex */
public class C6020n4 {

    /* renamed from: c */
    public static final String f27573c = "ServicePolicyExecutor";

    /* renamed from: a */
    public JSONObject f27574a;

    /* renamed from: b */
    public PolicyNetworkService f27575b;

    public C6020n4(String str) {
        m34884c(str);
    }

    /* renamed from: c */
    private void m34884c(String str) {
        try {
            this.f27574a = TextUtils.isEmpty(str) ? new JSONObject() : new JSONObject(str);
        } catch (JSONException unused) {
            this.f27574a = new JSONObject();
            Logger.m32145w(f27573c, "call method NetworkServiceManager init set options occur JSONException");
        }
    }

    /* renamed from: a */
    public Boolean m34885a(String str) {
        try {
            if (this.f27574a.has(str)) {
                return Boolean.valueOf(this.f27574a.getBoolean(str));
            }
        } catch (JSONException unused) {
        }
        return null;
    }

    /* renamed from: b */
    public boolean m34887b(String str) {
        try {
            return this.f27574a.has(str) ? this.f27574a.getBoolean(str) : StringUtils.stringToBoolean(this.f27575b.getConfigValue(str), false);
        } catch (JSONException unused) {
            return StringUtils.stringToBoolean(this.f27575b.getConfigValue(str), false);
        }
    }

    /* renamed from: a */
    public void m34886a() {
        PolicyNetworkService policyNetworkService = NetworkKitInnerImpl.getInstance().getPolicyNetworkService(NetworkService.Constants.CONFIG_SERVICE);
        this.f27575b = policyNetworkService;
        if (policyNetworkService == null) {
            throw new IllegalStateException("configPolicyService is error");
        }
    }
}
