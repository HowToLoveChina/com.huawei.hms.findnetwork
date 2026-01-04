package p811yi;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.huawei.cloud.base.util.C4650r;
import java.io.File;

/* renamed from: yi.a */
/* loaded from: classes.dex */
public class C13986a {

    /* renamed from: a */
    public static final C4650r f62674a = C4650r.m28485f("AppInfo");

    /* renamed from: b */
    public static String f62675b;

    /* renamed from: c */
    public static String f62676c;

    /* renamed from: d */
    public static String f62677d;

    /* renamed from: e */
    public static File f62678e;

    /* renamed from: f */
    public static boolean f62679f;

    /* renamed from: a */
    public static synchronized void m84003a(Context context) {
        try {
            if (f62679f) {
                return;
            }
            try {
                f62678e = context.getCacheDir();
                f62676c = context.getPackageName();
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(f62676c, 128);
                f62677d = packageInfo.versionName;
                Object obj = packageInfo.applicationInfo.metaData.get("com.huawei.hms.client.appid");
                if ((obj instanceof Integer) || (obj instanceof Long)) {
                    f62675b = obj.toString();
                } else if (obj instanceof String) {
                    String string = obj.toString();
                    if (string.indexOf(61) == -1) {
                        f62675b = string;
                    } else {
                        String[] strArrSplit = string.split("=");
                        if (strArrSplit.length > 1) {
                            f62675b = strArrSplit[1];
                        }
                    }
                }
                f62679f = true;
            } catch (PackageManager.NameNotFoundException unused) {
                f62679f = false;
            } catch (Exception e10) {
                f62674a.m28489d("init error: " + e10.toString());
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
