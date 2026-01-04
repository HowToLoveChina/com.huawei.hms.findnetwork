package com.huawei.android.dynamicfeature.plugin.language;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;

/* loaded from: classes2.dex */
public class LanguagePluginActivity extends Activity {

    /* renamed from: a */
    public Resources f11472a;

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (this.f11472a == null) {
            this.f11472a = new Resources(super.getResources().getAssets(), super.getResources().getDisplayMetrics(), super.getResources().getConfiguration());
        }
        return this.f11472a;
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        getResources().updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        getApplicationContext().getResources().updateConfiguration(configuration, super.getResources().getDisplayMetrics());
    }
}
