package p257eh;

import android.content.Context;
import com.huawei.appgallery.coreservice.ServiceConnectionC4564e;
import com.huawei.appgallery.coreservice.api.ApiClient;
import com.huawei.appgallery.coreservice.api.ConnectConfig;
import java.util.HashSet;
import java.util.Set;

/* renamed from: eh.a */
/* loaded from: classes4.dex */
public class C9479a implements ApiClient {

    /* renamed from: a */
    public Context f47249a;

    /* renamed from: b */
    public final Set<ApiClient.ConnectionCallback> f47250b;

    /* renamed from: c */
    public ServiceConnectionC4564e f47251c;

    public C9479a(Context context, Set<ApiClient.ConnectionCallback> set, ConnectConfig connectConfig) {
        HashSet hashSet = new HashSet();
        this.f47250b = hashSet;
        this.f47249a = context.getApplicationContext();
        hashSet.addAll(set);
        ServiceConnectionC4564e serviceConnectionC4564e = new ServiceConnectionC4564e(context);
        this.f47251c = serviceConnectionC4564e;
        serviceConnectionC4564e.m28045e(connectConfig);
    }

    /* renamed from: a */
    public InterfaceC9481c m59330a() {
        return this.f47251c;
    }

    @Override // com.huawei.appgallery.coreservice.api.ApiClient
    public void connect() {
        this.f47251c.m28047g(this.f47250b);
    }

    @Override // com.huawei.appgallery.coreservice.api.ApiClient
    public void disconnect() {
        this.f47251c.m28044d();
    }

    @Override // com.huawei.appgallery.coreservice.api.ApiClient
    public Context getContext() {
        return this.f47249a;
    }

    @Override // com.huawei.appgallery.coreservice.api.ApiClient
    public ApiClient getDelegate() {
        return null;
    }

    @Override // com.huawei.appgallery.coreservice.api.ApiClient
    public boolean isConnected() {
        return this.f47251c.m28048i();
    }

    @Override // com.huawei.appgallery.coreservice.api.ApiClient
    public boolean isConnecting() {
        return this.f47251c.m28049m();
    }
}
