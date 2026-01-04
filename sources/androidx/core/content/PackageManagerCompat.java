package androidx.core.content;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.concurrent.Executors;
import p024b0.C1095k;
import p464m.C11385c;
import p600r3.InterfaceFutureC12460a;

/* loaded from: classes.dex */
public final class PackageManagerCompat {

    @SuppressLint({"ActionValue"})
    public static final String ACTION_PERMISSION_REVOCATION_SETTINGS = "android.intent.action.AUTO_REVOKE_PERMISSIONS";
    public static final String LOG_TAG = "PackageManagerCompat";

    public static class Api30Impl {
        private Api30Impl() {
        }

        public static boolean areUnusedAppRestrictionsEnabled(Context context) {
            return !context.getPackageManager().isAutoRevokeWhitelisted();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface UnusedAppRestrictionsStatus {
    }

    private PackageManagerCompat() {
    }

    public static boolean areUnusedAppRestrictionsAvailable(PackageManager packageManager) {
        int i10 = Build.VERSION.SDK_INT;
        return (i10 >= 30) || ((i10 < 30) && (getPermissionRevocationVerifierApp(packageManager) != null));
    }

    public static String getPermissionRevocationVerifierApp(PackageManager packageManager) {
        String str = null;
        Iterator<ResolveInfo> it = packageManager.queryIntentActivities(new Intent(ACTION_PERMISSION_REVOCATION_SETTINGS).setData(Uri.fromParts("package", "com.example", null)), 0).iterator();
        while (it.hasNext()) {
            String str2 = it.next().activityInfo.packageName;
            if (packageManager.checkPermission("android.permission.PACKAGE_VERIFICATION_AGENT", str2) == 0) {
                if (str != null) {
                    return str;
                }
                str = str2;
            }
        }
        return str;
    }

    public static InterfaceFutureC12460a<Integer> getUnusedAppRestrictionsStatus(Context context) {
        C11385c<Integer> c11385cM68274r = C11385c.m68274r();
        if (!C1095k.m6494a(context)) {
            c11385cM68274r.mo68264p(0);
            Log.e(LOG_TAG, "User is in locked direct boot mode");
            return c11385cM68274r;
        }
        if (!areUnusedAppRestrictionsAvailable(context.getPackageManager())) {
            c11385cM68274r.mo68264p(1);
            return c11385cM68274r;
        }
        int i10 = context.getApplicationInfo().targetSdkVersion;
        if (i10 < 30) {
            c11385cM68274r.mo68264p(0);
            Log.e(LOG_TAG, "Target SDK version below API 30");
            return c11385cM68274r;
        }
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 31) {
            if (Api30Impl.areUnusedAppRestrictionsEnabled(context)) {
                c11385cM68274r.mo68264p(Integer.valueOf(i10 >= 31 ? 5 : 4));
            } else {
                c11385cM68274r.mo68264p(2);
            }
            return c11385cM68274r;
        }
        if (i11 == 30) {
            c11385cM68274r.mo68264p(Integer.valueOf(Api30Impl.areUnusedAppRestrictionsEnabled(context) ? 4 : 2));
            return c11385cM68274r;
        }
        final UnusedAppRestrictionsBackportServiceConnection unusedAppRestrictionsBackportServiceConnection = new UnusedAppRestrictionsBackportServiceConnection(context);
        c11385cM68274r.m68256b(new Runnable() { // from class: androidx.core.content.w
            @Override // java.lang.Runnable
            public final void run() {
                unusedAppRestrictionsBackportServiceConnection.disconnectFromService();
            }
        }, Executors.newSingleThreadExecutor());
        unusedAppRestrictionsBackportServiceConnection.connectAndFetchResult(c11385cM68274r);
        return c11385cM68274r;
    }
}
