package com.bumptech.glide.manager;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;

/* renamed from: com.bumptech.glide.manager.i */
/* loaded from: classes.dex */
public final class ComponentCallbacks2C1611i implements InterfaceC1613k, ComponentCallbacks2 {
    @Override // com.bumptech.glide.manager.InterfaceC1613k
    /* renamed from: a */
    public void mo9191a(Activity activity) {
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        onTrimMemory(20);
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i10) {
    }
}
