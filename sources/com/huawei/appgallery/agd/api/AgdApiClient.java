package com.huawei.appgallery.agd.api;

import android.content.Context;
import ch.C1439a;
import com.huawei.appgallery.coreservice.api.ApiClient;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes4.dex */
public interface AgdApiClient extends ApiClient {

    public static class Builder {

        /* renamed from: a */
        public final Context f20951a;

        /* renamed from: b */
        public final Set<ConnectionCallbacks> f20952b = new HashSet();

        /* renamed from: c */
        public String f20953c;

        /* renamed from: d */
        public String f20954d;

        public Builder(Context context) {
            this.f20951a = context.getApplicationContext();
        }

        public Builder addConnectionCallbacks(ConnectionCallbacks connectionCallbacks) {
            this.f20952b.add(connectionCallbacks);
            return this;
        }

        public AgdApiClient build() {
            return new C1439a(new ApiClient.Builder(this.f20951a).setHomeCountry(this.f20953c).setGrsAppName(this.f20954d), this.f20951a, this.f20952b);
        }

        @Deprecated
        public Builder setGrsAppName(String str) {
            this.f20954d = str;
            return this;
        }

        public Builder setHomeCountry(String str) {
            this.f20953c = str;
            return this;
        }
    }

    public interface ConnectionCallbacks {
        void onConnected();

        void onConnectionFailed(ConnectionResult connectionResult);

        void onConnectionSuspended(int i10);
    }

    @Override // com.huawei.appgallery.coreservice.api.ApiClient
    void connect();

    @Override // com.huawei.appgallery.coreservice.api.ApiClient
    void disconnect();

    @Override // com.huawei.appgallery.coreservice.api.ApiClient
    Context getContext();

    @Override // com.huawei.appgallery.coreservice.api.ApiClient
    boolean isConnected();

    @Override // com.huawei.appgallery.coreservice.api.ApiClient
    boolean isConnecting();
}
