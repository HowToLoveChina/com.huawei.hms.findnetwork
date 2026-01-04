package com.huawei.android.dynamicfeature.plugin.language;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import p250e7.C9419a;

/* renamed from: com.huawei.android.dynamicfeature.plugin.language.c */
/* loaded from: classes2.dex */
public class C2395c extends AbstractC2393a {
    /* renamed from: j */
    public static boolean m14989j(Context context) {
        new LanguageInstaller(context).m14977l();
        return true;
    }

    @Override // com.huawei.android.dynamicfeature.plugin.language.AbstractC2393a
    /* renamed from: a */
    public void mo14980a(Activity activity) throws Throwable {
        mo14984e(activity);
    }

    @Override // com.huawei.android.dynamicfeature.plugin.language.AbstractC2393a
    /* renamed from: e */
    public void mo14984e(Activity activity) throws Throwable {
        try {
            m14981b(activity);
            m14989j(activity);
        } catch (Exception e10) {
            C9419a.m59082h("KitInstallLanguage", "activity init failed", e10);
        }
        try {
            int i10 = activity.getPackageManager().getActivityInfo(activity.getComponentName(), 128).labelRes;
            if (i10 > 0) {
                activity.setTitle(i10);
            }
        } catch (Exception e11) {
            C9419a.m59082h("KitInstallLanguage", "get activity info failed", e11);
        }
    }

    @Override // com.huawei.android.dynamicfeature.plugin.language.AbstractC2393a
    /* renamed from: g */
    public void mo14985g(Context context) throws Throwable {
        try {
            C9419a.m59080f("KitInstallLanguage", "start try to decode package pressed by brotli");
            C2403k.m15007b(context);
            C9419a.m59080f("KitInstallLanguage", "start install language, kit is " + context.getPackageName());
            new LanguageInstaller(context).m14978m();
            C9419a.m59076b("KitInstallLanguage", "after Languages Installer");
            m14989j(context);
            C9419a.m59080f("KitInstallLanguage", "after Language Feature Compat");
        } catch (Exception e10) {
            C9419a.m59082h("KitInstallLanguage", "failed to install language feature at appOnCreate", e10);
        }
    }

    @Override // com.huawei.android.dynamicfeature.plugin.language.AbstractC2393a
    /* renamed from: h */
    public void mo14986h(Application application) throws Throwable {
        String strM14990a = C2396d.m14990a(application.getApplicationContext());
        m14987i(application, Boolean.valueOf(strM14990a.equals("zh") || strM14990a.equals(FaqConstants.DEFAULT_ISO_LANGUAGE)));
    }
}
