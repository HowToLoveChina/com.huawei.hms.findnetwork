package org.chromium.net;

import java.util.concurrent.Executor;

/* loaded from: classes9.dex */
public abstract class NetworkQualityConnectionStatsListener {
    private final Executor mExecutor;

    public NetworkQualityConnectionStatsListener(Executor executor) {
        if (executor == null) {
            throw new IllegalStateException("Executor must not be null");
        }
        this.mExecutor = executor;
    }

    public Executor getExecutor() {
        return this.mExecutor;
    }

    public abstract void onQuicStatsObservation(String str, int i10);
}
