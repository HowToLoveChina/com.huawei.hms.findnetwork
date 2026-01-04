package com.huawei.android.dynamicfeature.plugin.language;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import java.io.File;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import p250e7.C9419a;
import p250e7.C9421c;

/* renamed from: com.huawei.android.dynamicfeature.plugin.language.a */
/* loaded from: classes2.dex */
public abstract class AbstractC2393a {

    /* renamed from: com.huawei.android.dynamicfeature.plugin.language.a$a */
    public class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Application f11474a;

        public a(Application application) {
            this.f11474a = application;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            AbstractC2393a.this.mo14985g(this.f11474a);
        }
    }

    /* renamed from: com.huawei.android.dynamicfeature.plugin.language.a$b */
    public static class b implements Runnable {

        /* renamed from: a */
        public Application f11476a;

        public b(Application application) {
            this.f11476a = application;
        }

        @Override // java.lang.Runnable
        public void run() {
            C2398f.m14996d(this.f11476a, "hw").m14997a();
        }
    }

    /* renamed from: f */
    public static void m14979f(Context context) {
        try {
            Set<String> setM14966f = LanguageInstaller.m14966f(context);
            boolean zM14967g = LanguageInstaller.m14967g();
            Iterator<String> it = setM14966f.iterator();
            while (it.hasNext()) {
                if (!C9421c.m59093c(it.next(), zM14967g)) {
                    C2405m.m15023b(context);
                    return;
                }
            }
        } catch (Exception e10) {
            C9419a.m59077c("InstallLanguageStrategy", "get device language failed:" + e10.getMessage());
        }
    }

    /* renamed from: a */
    public abstract void mo14980a(Activity activity);

    /* renamed from: b */
    public void m14981b(Context context) throws Throwable {
        if (context == null) {
            C9419a.m59076b("InstallLanguageStrategy", "context is null in applySysPreferredLocaleToConfig()!");
            return;
        }
        Context applicationContext = context.getApplicationContext();
        Locale localeM15004c = C2400h.m15002b().m15004c();
        C9419a.m59080f("InstallLanguageStrategy", "applyKitConfig Set to preferred locale: " + localeM15004c);
        if (Build.VERSION.SDK_INT > 29) {
            m14983d(applicationContext, localeM15004c);
        }
        Configuration configuration = context.getResources().getConfiguration();
        configuration.setLocale(localeM15004c);
        applicationContext.getResources().updateConfiguration(configuration, context.getResources().getDisplayMetrics());
    }

    /* renamed from: c */
    public final void m14982c(Context context, String str) throws Throwable {
        C9419a.m59080f("InstallLanguageStrategy", "checkDeviceLanguageFile appContext is : " + context.getPackageName() + "language is: " + str);
        C2398f c2398fM14996d = C2398f.m14996d(context, "hw");
        if (new File(c2398fM14996d.m14999f(), "config.base-" + str + ".lpk").exists()) {
            C9419a.m59080f("InstallLanguageStrategy", "checkDeviceLanguageFile config.base-" + str + ".lpk  is installed");
            return;
        }
        if (!new File(c2398fM14996d.m14999f(), "config." + str + ".lpk").exists()) {
            new LanguageInstaller(context).m14973d(str);
            return;
        }
        C9419a.m59080f("InstallLanguageStrategy", "checkDeviceLanguageFile config." + str + ".lpk  is installed");
    }

    /* renamed from: d */
    public final void m14983d(Context context, Locale locale) throws Throwable {
        try {
            Set<String> setM14966f = LanguageInstaller.m14966f(context);
            boolean zM14967g = LanguageInstaller.m14967g();
            String strM14969i = LanguageInstaller.m14969i(locale, zM14967g);
            for (String str : setM14966f) {
                if (!C9421c.m59093c(str, zM14967g)) {
                    m14982c(context, str);
                    C9419a.m59080f("InstallLanguageStrategy", "language = " + str + "   systemLanguage = " + strM14969i);
                    if (!str.equals(strM14969i)) {
                        m14982c(context, strM14969i);
                    }
                }
            }
        } catch (Exception e10) {
            C9419a.m59077c("InstallLanguageStrategy", "get device language failed:" + e10.getMessage());
        }
    }

    /* renamed from: e */
    public void mo14984e(Activity activity) throws Throwable {
        try {
            m14981b(activity);
            C2396d.m14992c(activity);
        } catch (Exception e10) {
            C9419a.m59082h("InstallLanguageStrategy", "activity init failed", e10);
        }
        try {
            int i10 = activity.getPackageManager().getActivityInfo(activity.getComponentName(), 128).labelRes;
            if (i10 > 0) {
                activity.setTitle(i10);
            }
        } catch (Exception e11) {
            C9419a.m59082h("InstallLanguageStrategy", "get activity info failed", e11);
        }
    }

    /* renamed from: g */
    public void mo14985g(Context context) throws Throwable {
        try {
            C9419a.m59080f("InstallLanguageStrategy", "start try to decode package pressed by brotli");
            C2403k.m15007b(context);
            C9419a.m59080f("InstallLanguageStrategy", "start install language, app is " + context.getPackageName());
            new LanguageInstaller(context).m14978m();
            C9419a.m59076b("InstallLanguageStrategy", "after Languages Installer");
            C2396d.m14992c(context);
            C9419a.m59080f("InstallLanguageStrategy", "after Language Feature Compat");
        } catch (Exception e10) {
            C9419a.m59082h("InstallLanguageStrategy", "failed to install language feature at appOnCreate", e10);
        }
    }

    /* renamed from: h */
    public abstract void mo14986h(Application application);

    /* renamed from: i */
    public void m14987i(Application application, Boolean bool) throws Throwable {
        C9419a.m59080f("InstallLanguageStrategy", "start languageplugin. needAync=" + bool);
        if (bool.booleanValue()) {
            C2397e.m14993a().execute(new a(application));
        } else {
            mo14985g(application);
        }
        C2397e.m14993a().execute(new b(application));
        C9419a.m59080f("InstallLanguageStrategy", "onCreate install end");
    }
}
