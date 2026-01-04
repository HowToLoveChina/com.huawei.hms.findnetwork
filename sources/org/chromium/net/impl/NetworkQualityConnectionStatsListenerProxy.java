package org.chromium.net.impl;

import java.util.concurrent.Executor;
import org.chromium.net.NetworkQualityConnectionStatsListener;

/* loaded from: classes9.dex */
public class NetworkQualityConnectionStatsListenerProxy extends NetworkQualityConnectionStatsListener {
    private final NetworkQualityConnectionStatsListener mWrappedListener;

    public NetworkQualityConnectionStatsListenerProxy(NetworkQualityConnectionStatsListener networkQualityConnectionStatsListener) {
        super(networkQualityConnectionStatsListener.getExecutor());
        this.mWrappedListener = networkQualityConnectionStatsListener;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof NetworkQualityConnectionStatsListenerProxy)) {
            return false;
        }
        return this.mWrappedListener.equals(((NetworkQualityConnectionStatsListenerProxy) obj).mWrappedListener);
    }

    @Override // org.chromium.net.NetworkQualityConnectionStatsListener
    public Executor getExecutor() {
        return this.mWrappedListener.getExecutor();
    }

    public int hashCode() {
        return this.mWrappedListener.hashCode();
    }

    @Override // org.chromium.net.NetworkQualityConnectionStatsListener
    public void onQuicStatsObservation(String str, int i10) {
        this.mWrappedListener.onQuicStatsObservation(str, i10);
    }
}
