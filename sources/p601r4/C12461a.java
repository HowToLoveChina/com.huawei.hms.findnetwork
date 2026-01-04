package p601r4;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.service.utils.C2157a;
import p229di.C9142g;
import p699v4.C13345n;
import p699v4.C13349r;

/* renamed from: r4.a */
/* loaded from: classes.dex */
public class C12461a {

    /* renamed from: a */
    public static final String f57388a = "a";

    /* renamed from: b */
    public static boolean f57389b = false;

    /* renamed from: c */
    public static String f57390c = null;

    /* renamed from: d */
    public static boolean f57391d = true;

    static {
        try {
            if (C9142g.m57463b()) {
                Class.forName("com.hihonor.libcore.io.ExternalStorageFile");
            } else {
                Class.forName("com.huawei.libcore.io.ExternalStorageFile");
            }
            f57389b = true;
        } catch (ClassNotFoundException e10) {
            C2111d.m12648d(f57388a, "ExternalStorageFile not exist, " + e10.getMessage());
        } catch (SecurityException e11) {
            C2111d.m12648d(f57388a, "ExternalStorageFile SecurityException exception, " + e11.getMessage());
        }
    }

    /* renamed from: a */
    public static void m74714a(Context context) {
        String str = f57388a;
        C2111d.m12646b(str, "init ExternalStorageHelper");
        String strM80072k = C13345n.m80072k(context, 3);
        C2111d.m12647c(str, "ExternalStorageHelper sdCardRootPath is ", strM80072k);
        f57390c = strM80072k;
        f57391d = C2157a.m13177L(context);
    }

    /* renamed from: b */
    public static boolean m74715b(String str) {
        boolean z10 = f57389b && f57391d && C13349r.m80088d() && m74716c(str);
        C2111d.m12646b(f57388a, "isExternalStorageFileNeeded :" + z10);
        return z10;
    }

    /* renamed from: c */
    public static boolean m74716c(String str) {
        if (TextUtils.isEmpty(f57390c)) {
            return false;
        }
        if (!TextUtils.isEmpty(str)) {
            return str.startsWith(f57390c);
        }
        C2111d.m12648d(f57388a, "path is empty");
        return false;
    }
}
