package com.huawei.hms.locationSdk;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.Api.ApiOptions;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.BaseHmsClient;
import com.huawei.hms.common.internal.ClientSettings;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.locationSdk.C5713f0;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.Util;
import com.huawei.location.router.RouterResponse;
import com.huawei.location.router.interfaces.IRouterCallback;
import java.util.ArrayList;
import p208cq.C8941i;
import p531or.C11991a;

/* renamed from: com.huawei.hms.locationSdk.w */
/* loaded from: classes8.dex */
class C5764w<TResult, TClient extends AnyClient, TOption extends Api.ApiOptions> implements IRouterCallback {

    /* renamed from: a */
    private TaskApiCall<TClient, TResult> f25589a;

    /* renamed from: b */
    private C8941i<TResult> f25590b;

    /* renamed from: c */
    private AbstractClientBuilder<TClient, TOption> f25591c;

    /* renamed from: d */
    private String f25592d;

    /* renamed from: com.huawei.hms.locationSdk.w$a */
    public class a implements BaseHmsClient.OnConnectionFailedListener {
        public a() {
        }

        @Override // com.huawei.hms.common.internal.BaseHmsClient.OnConnectionFailedListener
        public void onConnectionFailed(ConnectionResult connectionResult) {
        }
    }

    /* renamed from: com.huawei.hms.locationSdk.w$b */
    public class b implements BaseHmsClient.ConnectionCallbacks {
        public b() {
        }

        @Override // com.huawei.hms.common.internal.BaseHmsClient.ConnectionCallbacks
        public void onConnected() {
        }

        @Override // com.huawei.hms.common.internal.BaseHmsClient.ConnectionCallbacks
        public void onConnectionSuspended(int i10) {
        }
    }

    public C5764w(TaskApiCall<TClient, TResult> taskApiCall, C8941i<TResult> c8941i, AbstractClientBuilder<TClient, TOption> abstractClientBuilder) {
        this.f25589a = taskApiCall;
        this.f25590b = c8941i;
        this.f25591c = abstractClientBuilder;
    }

    /* renamed from: a */
    private ClientSettings m33188a() {
        Context contextM72145a = C11991a.m72145a();
        ClientSettings clientSettings = new ClientSettings(contextM72145a.getPackageName(), contextM72145a.getClass().getName(), new ArrayList(), Util.getAppId(C11991a.m72145a()), null);
        clientSettings.setCpID(Util.getCpId(contextM72145a));
        if (TextUtils.isEmpty(this.f25592d)) {
            this.f25592d = HMSPackageManager.getInstance(contextM72145a).getHMSPackageName();
            HMSLog.m36988i("LiteApiListener", "inner hms is empty,hms pkg name is " + this.f25592d);
        }
        clientSettings.setInnerHmsPkg(this.f25592d);
        return clientSettings;
    }

    /* renamed from: b */
    private TClient m33190b() {
        return (TClient) this.f25591c.buildClient(C11991a.m72145a(), m33188a(), new a(), new C5713f0.a(new b()));
    }

    @Override // com.huawei.location.router.interfaces.IRouterCallback
    public void doExecute(RouterResponse routerResponse) {
        m33189a(routerResponse);
    }

    @Override // com.huawei.location.router.interfaces.IRouterCallback
    public void onComplete(RouterResponse routerResponse) {
        m33189a(routerResponse);
    }

    /* renamed from: a */
    private void m33189a(RouterResponse routerResponse) {
        if (routerResponse == null || this.f25589a == null) {
            return;
        }
        this.f25589a.onResponse(m33190b(), new C5748q1(routerResponse.getStatusInfo(), routerResponse.getTransactionId()), routerResponse.getBody(), this.f25590b);
        HMSLog.m36983d("LiteApiListener", "doTaskExecute onResponse success");
    }
}
