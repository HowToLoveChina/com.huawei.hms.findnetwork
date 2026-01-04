package com.huawei.appgallery.coreservice.api;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.huawei.appgallery.coreservice.ServiceConnectionC4564e;
import p257eh.C9486h;
import p257eh.C9490l;

/* loaded from: classes4.dex */
public abstract class CoreServiceApi {
    public static AppGalleryInfo getAppGalleryInfo(Context context) throws PackageManager.NameNotFoundException {
        String strM28037h = ServiceConnectionC4564e.m28037h(context);
        if (TextUtils.isEmpty(strM28037h)) {
            return null;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(strM28037h, 128);
            if (packageInfo != null) {
                return new AppGalleryInfo(packageInfo.versionName, packageInfo.versionCode);
            }
        } catch (PackageManager.NameNotFoundException unused) {
            C9490l.m59349a("CoreServiceApi", "NameNotFoundException ");
        } catch (RuntimeException unused2) {
            C9490l.m59351c("CoreServiceApi", "getPackageInfo RuntimeException");
        }
        return null;
    }

    public static String getAppGalleryPkg(Context context) {
        return ServiceConnectionC4564e.m28037h(context);
    }

    public static IConnectionResult getGuideInstallPendingIntent(Context context) {
        return ServiceConnectionC4564e.m28039k(context);
    }

    @Deprecated
    public static void setAppName(Context context, String str) {
        C9486h.m59338a().m59340c(context, str);
    }

    public static void setHomeCountry(Context context, String str) {
        C9486h.m59338a().m59342e(context, str);
    }
}
