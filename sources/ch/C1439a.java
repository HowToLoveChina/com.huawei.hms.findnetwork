package ch;

import android.content.Context;
import com.huawei.appgallery.agd.api.AgdApiClient;
import com.huawei.appgallery.agd.api.ConnectionResult;
import com.huawei.appgallery.agd.internal.support.log.AgdLog;
import com.huawei.appgallery.agd.internalapi.CrossClientApi;
import com.huawei.appgallery.coreservice.api.ApiClient;
import com.huawei.appgallery.coreservice.api.CoreServiceApi;
import com.huawei.appgallery.coreservice.api.IConnectionResult;
import java.util.Iterator;
import java.util.Set;

/* renamed from: ch.a */
/* loaded from: classes4.dex */
public class C1439a implements AgdApiClient {

    /* renamed from: a */
    public final ApiClient f6201a;

    /* renamed from: b */
    public final Context f6202b;

    /* renamed from: c */
    public final Set<AgdApiClient.ConnectionCallbacks> f6203c;

    /* renamed from: d */
    public boolean f6204d = false;

    /* renamed from: e */
    public boolean f6205e = false;

    /* renamed from: f */
    public boolean f6206f = false;

    /* renamed from: g */
    public Runnable f6207g;

    /* renamed from: ch.a$a */
    public class a implements ApiClient.ConnectionCallback {

        /* renamed from: a */
        public final /* synthetic */ Set f6208a;

        public a(Set set) {
            this.f6208a = set;
        }

        @Override // com.huawei.appgallery.coreservice.api.ApiClient.ConnectionCallback
        public void onConnected() {
            C1439a.this.m8282b(true);
            if (C1439a.this.f6204d) {
                return;
            }
            Iterator it = this.f6208a.iterator();
            while (it.hasNext()) {
                ((AgdApiClient.ConnectionCallbacks) it.next()).onConnected();
            }
        }

        @Override // com.huawei.appgallery.coreservice.api.ApiClient.ConnectionCallback
        public void onConnectionFailed(IConnectionResult iConnectionResult) {
            C1439a.this.m8282b(false);
            if (C1439a.this.f6204d) {
                return;
            }
            Iterator it = this.f6208a.iterator();
            while (it.hasNext()) {
                ((AgdApiClient.ConnectionCallbacks) it.next()).onConnectionFailed(new ConnectionResult(iConnectionResult));
            }
        }

        @Override // com.huawei.appgallery.coreservice.api.ApiClient.ConnectionCallback
        public void onConnectionSuspended(int i10) {
            C1439a.this.m8282b(false);
            if (C1439a.this.f6204d) {
                return;
            }
            Iterator it = this.f6208a.iterator();
            while (it.hasNext()) {
                ((AgdApiClient.ConnectionCallbacks) it.next()).onConnectionSuspended(i10);
            }
        }
    }

    public C1439a(ApiClient.Builder builder, Context context, Set<AgdApiClient.ConnectionCallbacks> set) {
        builder.addConnectionCallbacks(new a(set));
        this.f6201a = builder.build();
        this.f6202b = context;
        this.f6203c = set;
        if (CrossClientApi.needCrossClient(context)) {
            CrossClientApi.init(context);
        }
    }

    /* renamed from: b */
    public final void m8282b(boolean z10) {
        this.f6205e = z10;
        this.f6206f = false;
        Runnable runnable = this.f6207g;
        if (runnable == null || !z10) {
            return;
        }
        runnable.run();
        this.f6207g = null;
    }

    /* renamed from: c */
    public final boolean m8283c() {
        return CoreServiceApi.getAppGalleryPkg(this.f6202b) != null;
    }

    @Override // com.huawei.appgallery.agd.api.AgdApiClient, com.huawei.appgallery.coreservice.api.ApiClient
    public void connect() {
        if (!CrossClientApi.needCrossClient(this.f6202b)) {
            this.f6201a.connect();
            this.f6206f = true;
            return;
        }
        this.f6204d = true;
        Set<AgdApiClient.ConnectionCallbacks> set = this.f6203c;
        if (set != null) {
            Iterator<AgdApiClient.ConnectionCallbacks> it = set.iterator();
            while (it.hasNext()) {
                it.next().onConnected();
            }
        }
        AgdLog.LOG.m28031i("AgdApiClientImpl", "AG not exist, connect by cross client");
    }

    @Override // com.huawei.appgallery.agd.api.AgdApiClient, com.huawei.appgallery.coreservice.api.ApiClient
    public void disconnect() {
        if (this.f6204d) {
            Iterator<AgdApiClient.ConnectionCallbacks> it = this.f6203c.iterator();
            while (it.hasNext()) {
                it.next().onConnectionSuspended(0);
            }
        }
        this.f6204d = false;
        this.f6201a.disconnect();
        this.f6205e = false;
        this.f6206f = false;
    }

    @Override // com.huawei.appgallery.agd.api.AgdApiClient, com.huawei.appgallery.coreservice.api.ApiClient
    public Context getContext() {
        return this.f6202b;
    }

    @Override // com.huawei.appgallery.coreservice.api.ApiClient
    public ApiClient getDelegate() {
        return this.f6201a;
    }

    @Override // com.huawei.appgallery.agd.api.AgdApiClient, com.huawei.appgallery.coreservice.api.ApiClient
    public boolean isConnected() {
        return this.f6205e || this.f6204d;
    }

    @Override // com.huawei.appgallery.agd.api.AgdApiClient, com.huawei.appgallery.coreservice.api.ApiClient
    public boolean isConnecting() {
        return m8283c() && this.f6206f;
    }
}
