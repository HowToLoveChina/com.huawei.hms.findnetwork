package p679uh;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import p578qh.C12355a;
import th.C13012a;

/* renamed from: uh.d */
/* loaded from: classes4.dex */
public class C13176d {

    /* renamed from: a */
    public static String f59700a = "";

    /* renamed from: b */
    public static final Object f59701b = new Object();

    /* renamed from: a */
    public static String m79223a() {
        String strM74362b = C12355a.m74362b();
        return TextUtils.isEmpty(strM74362b) ? "other" : strM74362b;
    }

    /* renamed from: b */
    public static String m79224b(Context context) {
        String str;
        String str2;
        String str3;
        synchronized (f59701b) {
            if (TextUtils.isEmpty(f59700a)) {
                String str4 = ("InstallSDK##11.5.1.300##" + m79223a()) + "##" + C12355a.m74369i();
                try {
                    String packageName = context.getPackageName();
                    str4 = str4 + "##" + packageName;
                    str3 = str4 + "##" + context.getPackageManager().getPackageInfo(packageName, 0).versionName;
                } catch (PackageManager.NameNotFoundException e10) {
                    e = e10;
                    str = "UserAgentUtils";
                    str2 = "get package error";
                    C13012a.m78316b(str, str2, e);
                    str3 = str4;
                    f59700a = str3;
                    return f59700a;
                } catch (Exception e11) {
                    e = e11;
                    str = "UserAgentUtils";
                    str2 = "get package Exception";
                    C13012a.m78316b(str, str2, e);
                    str3 = str4;
                    f59700a = str3;
                    return f59700a;
                }
                f59700a = str3;
            }
        }
        return f59700a;
    }
}
