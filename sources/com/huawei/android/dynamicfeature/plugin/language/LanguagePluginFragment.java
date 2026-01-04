package com.huawei.android.dynamicfeature.plugin.language;

import android.app.Fragment;
import android.content.res.Configuration;
import android.util.DisplayMetrics;

/* loaded from: classes2.dex */
public class LanguagePluginFragment extends Fragment {
    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        getResources().updateConfiguration(configuration, displayMetrics);
    }
}
