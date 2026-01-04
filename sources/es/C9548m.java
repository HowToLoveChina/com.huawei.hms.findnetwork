package es;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.core.content.PermissionChecker;
import as.C1016d;
import com.huawei.location.base.activity.constant.ActivityErrorCode;
import java.util.List;
import p531or.C11991a;
import p622rr.C12619b;
import p622rr.C12620c;

/* renamed from: es.m */
/* loaded from: classes8.dex */
public class C9548m {

    /* renamed from: a */
    public static int f47454a;

    static {
        f47454a = C9552q.m59643a() == 200 ? ActivityErrorCode.PERMISSION_DENIED : 10803;
    }

    /* renamed from: a */
    public static int m59618a(Context context, String str, int i10, int i11, String str2) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (str2 == null) {
                String[] packagesForUid = packageManager.getPackagesForUid(i11);
                if (packagesForUid != null && packagesForUid.length > 0) {
                    str2 = packagesForUid[0];
                }
                C1016d.m6186f("PermissionUtil", "checkPermission get packageName fail ");
                return -1;
            }
            return C9536a.m59550j(str2) >= 23 ? packageManager.checkPermission(str, str2) : PermissionChecker.checkPermission(context, str, i10, i11, str2);
        } catch (Exception unused) {
            C1016d.m6183c("PermissionUtil", "checkPermission LocationServiceException");
            throw new C12619b(10000, C12620c.m76137a(10000));
        }
    }

    /* renamed from: b */
    public static boolean m59619b(Context context, String str) {
        String str2;
        if (context == null || TextUtils.isEmpty(str)) {
            str2 = "hasSelfPermission failed because of context or permission is null";
        } else {
            if (context.checkSelfPermission(str) == 0) {
                return true;
            }
            str2 = "do not hasSelfPermission " + str;
        }
        C1016d.m6183c("PermissionUtil", str2);
        return false;
    }

    /* renamed from: c */
    public static boolean m59620c(Context context, String str, int i10, int i11) {
        String str2;
        if (context == null) {
            str2 = "hasPermission Context is null";
        } else {
            int iM59618a = m59618a(context, str, i10, i11, null);
            if (iM59618a == 0) {
                return true;
            }
            if (-1 != iM59618a) {
                C1016d.m6183c("PermissionUtil", "hasPermission, result is " + iM59618a);
                int i12 = f47454a;
                throw new C12619b(i12, C12620c.m76137a(i12));
            }
            str2 = "hasPermission, result is " + iM59618a;
        }
        C1016d.m6183c("PermissionUtil", str2);
        return false;
    }

    /* renamed from: d */
    public static boolean m59621d(String str) {
        String str2;
        Object systemService = C11991a.m72146b().getSystemService("activity");
        if (systemService instanceof ActivityManager) {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) systemService).getRunningAppProcesses();
            if (runningAppProcesses != null) {
                boolean z10 = true;
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (m59622e(runningAppProcessInfo.importance)) {
                        String[] strArr = runningAppProcessInfo.pkgList;
                        int length = strArr.length;
                        int i10 = 0;
                        while (true) {
                            if (i10 >= length) {
                                break;
                            }
                            if (strArr[i10].equals(str)) {
                                z10 = false;
                                break;
                            }
                            i10++;
                        }
                    }
                }
                return z10;
            }
            str2 = "runningProcesses is null";
        } else {
            str2 = "managerResult is not a instance of ActivityManager";
        }
        C1016d.m6183c("PermissionUtil", str2);
        return false;
    }

    /* renamed from: e */
    public static boolean m59622e(int i10) {
        return i10 <= 125;
    }
}
