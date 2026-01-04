package org.chromium.net.impl;

import android.content.Context;
import java.util.Arrays;
import org.chromium.net.CronetEngine;
import org.chromium.net.CronetProvider;
import org.chromium.net.ExperimentalCronetEngine;

/* loaded from: classes9.dex */
public class JavaCronetProvider extends CronetProvider {
    public JavaCronetProvider(Context context) {
        super(context);
    }

    @Override // org.chromium.net.CronetProvider
    public CronetEngine.Builder createBuilder() {
        return new ExperimentalCronetEngine.Builder(new JavaCronetEngineBuilderImpl(this.mContext));
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof JavaCronetProvider) && this.mContext.equals(((JavaCronetProvider) obj).mContext));
    }

    @Override // org.chromium.net.CronetProvider
    public String getName() {
        return CronetProvider.PROVIDER_NAME_FALLBACK;
    }

    @Override // org.chromium.net.CronetProvider
    public String getVersion() {
        return ImplVersion.getCronetVersion();
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{JavaCronetProvider.class, this.mContext});
    }

    @Override // org.chromium.net.CronetProvider
    public boolean isEnabled() {
        return true;
    }
}
