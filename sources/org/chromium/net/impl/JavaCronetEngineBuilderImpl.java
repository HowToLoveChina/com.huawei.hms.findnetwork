package org.chromium.net.impl;

import android.content.Context;
import java.util.Date;
import java.util.Set;
import org.chromium.net.CronetEngine;
import org.chromium.net.ExperimentalCronetEngine;
import org.chromium.net.ICronetEngineBuilder;

/* loaded from: classes9.dex */
public class JavaCronetEngineBuilderImpl extends CronetEngineBuilderImpl {
    public JavaCronetEngineBuilderImpl(Context context) {
        super(context);
    }

    @Override // org.chromium.net.impl.CronetEngineBuilderImpl, org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder addPublicKeyPins(String str, Set set, boolean z10, Date date) {
        return super.addPublicKeyPins(str, (Set<byte[]>) set, z10, date);
    }

    @Override // org.chromium.net.impl.CronetEngineBuilderImpl, org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder addQuicHint(String str, int i10, int i11) {
        return super.addQuicHint(str, i10, i11);
    }

    @Override // org.chromium.net.ICronetEngineBuilder
    public ExperimentalCronetEngine build() {
        if (getUserAgent() == null) {
            setUserAgent(getDefaultUserAgent());
        }
        return new JavaCronetEngine(this);
    }

    @Override // org.chromium.net.impl.CronetEngineBuilderImpl, org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder enableBrotli(boolean z10) {
        return super.enableBrotli(z10);
    }

    @Override // org.chromium.net.impl.CronetEngineBuilderImpl, org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder enableHttp2(boolean z10) {
        return super.enableHttp2(z10);
    }

    @Override // org.chromium.net.impl.CronetEngineBuilderImpl, org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder enableHttpCache(int i10, long j10) {
        return super.enableHttpCache(i10, j10);
    }

    @Override // org.chromium.net.impl.CronetEngineBuilderImpl, org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder enableNetworkQualityEstimator(boolean z10) {
        return super.enableNetworkQualityEstimator(z10);
    }

    @Override // org.chromium.net.impl.CronetEngineBuilderImpl, org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder enablePublicKeyPinningBypassForLocalTrustAnchors(boolean z10) {
        return super.enablePublicKeyPinningBypassForLocalTrustAnchors(z10);
    }

    @Override // org.chromium.net.impl.CronetEngineBuilderImpl, org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder enableQuic(boolean z10) {
        return super.enableQuic(z10);
    }

    @Override // org.chromium.net.impl.CronetEngineBuilderImpl, org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder enableSdch(boolean z10) {
        return super.enableSdch(z10);
    }

    @Override // org.chromium.net.impl.CronetEngineBuilderImpl, org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder enableTextTransmission(boolean z10) {
        return super.enableTextTransmission(z10);
    }

    @Override // org.chromium.net.impl.CronetEngineBuilderImpl, org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setExperimentalOptions(String str) {
        return super.setExperimentalOptions(str);
    }

    @Override // org.chromium.net.impl.CronetEngineBuilderImpl, org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setLibraryLoader(CronetEngine.Builder.LibraryLoader libraryLoader) {
        return super.setLibraryLoader(libraryLoader);
    }

    @Override // org.chromium.net.impl.CronetEngineBuilderImpl, org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setStoragePath(String str) {
        return super.setStoragePath(str);
    }

    @Override // org.chromium.net.impl.CronetEngineBuilderImpl, org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setThreadPriority(int i10) {
        return super.setThreadPriority(i10);
    }

    @Override // org.chromium.net.impl.CronetEngineBuilderImpl, org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setUserAgent(String str) {
        return super.setUserAgent(str);
    }
}
