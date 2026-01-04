package com.huawei.hms.ads.installreferrer.api;

import android.content.Context;
import android.os.RemoteException;
import androidx.annotation.Keep;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Keep
/* loaded from: classes8.dex */
public abstract class InstallReferrerClient {
    protected boolean isTest = false;

    @Keep
    public static final class Builder {
        private boolean isTest;
        private final Context mContext;

        private Builder(Context context) {
            this.isTest = false;
            this.mContext = context;
        }

        @Keep
        public InstallReferrerClient build() {
            Context context = this.mContext;
            if (context == null) {
                throw new IllegalArgumentException("context is null");
            }
            C5081a c5081a = new C5081a(context);
            c5081a.isTest = this.isTest;
            return c5081a;
        }

        @Keep
        public Builder setTest(boolean z10) {
            this.isTest = z10;
            return this;
        }

        public /* synthetic */ Builder(Context context, C50801 c50801) {
            this(context);
        }
    }

    @Keep
    @Retention(RetentionPolicy.SOURCE)
    public @interface InstallReferrerResponse {
        public static final int DEVELOPER_ERROR = 3;
        public static final int FEATURE_NOT_SUPPORTED = 2;

        /* renamed from: OK */
        public static final int f23216OK = 0;
        public static final int SERVICE_DISCONNECTED = -1;
        public static final int SERVICE_UNAVAILABLE = 1;
    }

    @Keep
    public static Builder newBuilder(Context context) {
        return new Builder(context);
    }

    @Keep
    public abstract void endConnection();

    @Keep
    public abstract ReferrerDetails getInstallReferrer() throws RemoteException, IOException;

    @Keep
    public abstract boolean isReady();

    @Keep
    public abstract int setInstallReferrer(String str, String str2, long j10, long j11) throws RemoteException, IOException;

    @Keep
    public abstract void startConnection(InstallReferrerStateListener installReferrerStateListener);
}
