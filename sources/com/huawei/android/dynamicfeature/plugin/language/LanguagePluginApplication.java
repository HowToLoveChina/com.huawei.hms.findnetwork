package com.huawei.android.dynamicfeature.plugin.language;

import android.app.Application;
import android.content.res.Resources;

/* loaded from: classes2.dex */
public class LanguagePluginApplication extends Application {

    /* renamed from: a */
    public Resources f11473a;

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (this.f11473a == null) {
            this.f11473a = new Resources(super.getResources().getAssets(), super.getResources().getDisplayMetrics(), super.getResources().getConfiguration());
        }
        return this.f11473a;
    }
}
