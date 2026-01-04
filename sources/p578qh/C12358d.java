package p578qh;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import th.C13012a;

/* renamed from: qh.d */
/* loaded from: classes4.dex */
public class C12358d {
    /* renamed from: a */
    public static String m74384a(Context context) throws PackageManager.NameNotFoundException {
        String str;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            if (packageInfo != null) {
                return packageInfo.versionName;
            }
        } catch (PackageManager.NameNotFoundException unused) {
            str = "can not get client version NameNotFoundException.";
            C13012a.m78317c("PkgUtil", str);
            return "";
        } catch (Exception unused2) {
            str = "can not get client version Exception.";
            C13012a.m78317c("PkgUtil", str);
            return "";
        }
        return "";
    }
}
