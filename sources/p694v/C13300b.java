package p694v;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;

/* renamed from: v.b */
/* loaded from: classes.dex */
public final class C13300b {

    /* renamed from: v.b$a */
    public static class a {
        /* renamed from: a */
        public static <T> T m79762a(Context context, Class<T> cls) {
            return (T) context.getSystemService(cls);
        }

        /* renamed from: b */
        public static int m79763b(AppOpsManager appOpsManager, String str, String str2) {
            return appOpsManager.noteProxyOp(str, str2);
        }

        /* renamed from: c */
        public static int m79764c(AppOpsManager appOpsManager, String str, String str2) {
            return appOpsManager.noteProxyOpNoThrow(str, str2);
        }

        /* renamed from: d */
        public static String m79765d(String str) {
            return AppOpsManager.permissionToOp(str);
        }
    }

    /* renamed from: v.b$b */
    public static class b {
        /* renamed from: a */
        public static int m79766a(AppOpsManager appOpsManager, String str, int i10, String str2) {
            if (appOpsManager == null) {
                return 1;
            }
            return appOpsManager.checkOpNoThrow(str, i10, str2);
        }

        /* renamed from: b */
        public static String m79767b(Context context) {
            return context.getOpPackageName();
        }

        /* renamed from: c */
        public static AppOpsManager m79768c(Context context) {
            return (AppOpsManager) context.getSystemService(AppOpsManager.class);
        }
    }

    /* renamed from: a */
    public static int m79759a(Context context, int i10, String str, String str2) {
        AppOpsManager appOpsManagerM79768c = b.m79768c(context);
        int iM79766a = b.m79766a(appOpsManagerM79768c, str, Binder.getCallingUid(), str2);
        return iM79766a != 0 ? iM79766a : b.m79766a(appOpsManagerM79768c, str, i10, b.m79767b(context));
    }

    /* renamed from: b */
    public static int m79760b(Context context, String str, String str2) {
        return a.m79764c((AppOpsManager) a.m79762a(context, AppOpsManager.class), str, str2);
    }

    /* renamed from: c */
    public static String m79761c(String str) {
        return a.m79765d(str);
    }
}
