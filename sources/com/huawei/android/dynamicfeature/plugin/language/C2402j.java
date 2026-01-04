package com.huawei.android.dynamicfeature.plugin.language;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebView;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import p250e7.C9419a;

/* renamed from: com.huawei.android.dynamicfeature.plugin.language.j */
/* loaded from: classes2.dex */
public class C2402j extends AbstractC2393a {
    @Override // com.huawei.android.dynamicfeature.plugin.language.AbstractC2393a
    /* renamed from: a */
    public void mo14980a(Activity activity) throws Throwable {
        try {
            AbstractC2393a.m14979f(activity);
        } catch (Error e10) {
            C9419a.m59082h("RawApkInstallLanguage", "failed to init webview because of system error", e10);
        } catch (Exception unused) {
            C9419a.m59077c("RawApkInstallLanguage", "failed to init webview");
        }
        mo14984e(activity);
    }

    @Override // com.huawei.android.dynamicfeature.plugin.language.AbstractC2393a
    /* renamed from: h */
    public void mo14986h(Application application) throws Throwable {
        String strM15005j = m15005j(application);
        if (!TextUtils.isEmpty(strM15005j) && !application.getPackageName().equals(strM15005j)) {
            WebView.setDataDirectorySuffix(strM15005j);
        }
        String strM14990a = C2396d.m14990a(application);
        m14987i(application, Boolean.valueOf(strM14990a.equals("zh") || strM14990a.equals(FaqConstants.DEFAULT_ISO_LANGUAGE)));
    }

    /* renamed from: j */
    public final String m15005j(Context context) {
        if (context == null) {
            return null;
        }
        String processName = Application.getProcessName();
        C9419a.m59076b("RawApkInstallLanguage", "Process = " + processName);
        return processName;
    }
}
