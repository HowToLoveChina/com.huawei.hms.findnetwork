package com.huawei.hms.hquic;

import android.content.Context;
import java.lang.reflect.InvocationTargetException;
import org.chromium.net.CronetEngine;
import org.chromium.net.CronetProvider;
import org.chromium.net.ExperimentalCronetEngine;
import org.chromium.net.ICronetEngineBuilder;

/* loaded from: classes8.dex */
public class HQUICProvider extends CronetProvider {
    public static final String HQUIC_PROVIDER_NAME = "HQUICProvider";

    public HQUICProvider(Context context) {
        super(context);
    }

    @Override // org.chromium.net.CronetProvider
    public CronetEngine.Builder createBuilder() {
        try {
            return new ExperimentalCronetEngine.Builder((ICronetEngineBuilder) HQUICManager.m32854b().getClassLoader().loadClass("org.chromium.net.impl.NativeCronetEngineBuilderImpl").asSubclass(ICronetEngineBuilder.class).getConstructor(Context.class).newInstance(this.mContext));
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | NullPointerException | SecurityException | InvocationTargetException e10) {
            throw new IllegalStateException("fail to loadClass  org.chromium.net.impl.NativeCronetEngineBuilderImpl : " + e10.getMessage());
        }
    }

    public int getApiVersion() {
        return HQUICManager.getRemoteCronetApiVersion();
    }

    @Override // org.chromium.net.CronetProvider
    public String getName() {
        return HQUIC_PROVIDER_NAME;
    }

    @Override // org.chromium.net.CronetProvider
    public String getVersion() {
        return HQUICManager.getRemoteHwhttpVersion();
    }

    @Override // org.chromium.net.CronetProvider
    public boolean isEnabled() {
        return HQUICManager.isAvailable();
    }
}
