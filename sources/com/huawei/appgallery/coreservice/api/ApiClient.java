package com.huawei.appgallery.coreservice.api;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;
import p257eh.C9479a;
import p257eh.C9486h;

/* loaded from: classes4.dex */
public interface ApiClient {

    public static class Builder {

        /* renamed from: a */
        public final Context f20961a;

        /* renamed from: b */
        public final Set<ConnectionCallback> f20962b = new HashSet();

        /* renamed from: c */
        public String f20963c;

        /* renamed from: d */
        public String f20964d;

        /* renamed from: e */
        public ConnectConfig f20965e;

        public Builder(Context context) {
            this.f20961a = context.getApplicationContext();
        }

        public Builder addConnectionCallbacks(ConnectionCallback connectionCallback) {
            this.f20962b.add(connectionCallback);
            return this;
        }

        public ApiClient build() {
            if (!TextUtils.isEmpty(this.f20964d)) {
                C9486h.m59338a().m59340c(this.f20961a, this.f20964d);
            }
            if (!TextUtils.isEmpty(this.f20963c)) {
                C9486h.m59338a().m59342e(this.f20961a, this.f20963c);
            }
            return new C9479a(this.f20961a, this.f20962b, this.f20965e);
        }

        @Deprecated
        public Builder setGrsAppName(String str) {
            this.f20964d = str;
            return this;
        }

        public Builder setHomeCountry(String str) {
            this.f20963c = str;
            return this;
        }

        public Builder setVendorConnectInfo(ConnectConfig connectConfig) {
            if (connectConfig != null && !TextUtils.isEmpty(connectConfig.getConnectServiceAction()) && !TextUtils.isEmpty(connectConfig.getConnectAppPkg()) && !TextUtils.isEmpty(connectConfig.getInstallAppName()) && !TextUtils.isEmpty(connectConfig.getAppSignCertchain()) && !TextUtils.isEmpty(connectConfig.getAppFingerprintSignature())) {
                this.f20965e = connectConfig.m85644clone();
            }
            return this;
        }
    }

    public interface ConnectionCallback {
        void onConnected();

        void onConnectionFailed(IConnectionResult iConnectionResult);

        void onConnectionSuspended(int i10);
    }

    void connect();

    void disconnect();

    Context getContext();

    ApiClient getDelegate();

    boolean isConnected();

    boolean isConnecting();
}
