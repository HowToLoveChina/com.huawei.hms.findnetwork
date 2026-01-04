package org.chromium.net.impl;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.huawei.hms.network.embedded.C5929g4;
import java.util.Locale;

/* loaded from: classes9.dex */
public final class UserAgent {
    private static final int VERSION_CODE_UNINITIALIZED = 0;
    private static final Object sLock = new Object();
    private static int sVersionCode;

    private UserAgent() {
    }

    private static void appendCronetVersion(StringBuilder sb2) {
        sb2.append(" Cronet/");
        sb2.append(ImplVersion.getCronetVersion());
    }

    public static String from(Context context) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(context.getPackageName());
        sb2.append(C5929g4.f26852n);
        sb2.append(versionFromContext(context));
        sb2.append(" (Linux; U; Android ");
        sb2.append(Build.VERSION.RELEASE);
        sb2.append("; ");
        sb2.append(Locale.getDefault().toString());
        String str = Build.MODEL;
        if (str.length() > 0) {
            sb2.append("; ");
            sb2.append(str);
        }
        String str2 = Build.ID;
        if (str2.length() > 0) {
            sb2.append("; Build/");
            sb2.append(str2);
        }
        sb2.append(";");
        appendCronetVersion(sb2);
        sb2.append(C5929g4.f26850l);
        return sb2.toString();
    }

    public static String getQuicUserAgentIdFrom(Context context) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(context.getPackageName());
        appendCronetVersion(sb2);
        return sb2.toString();
    }

    private static int versionFromContext(Context context) {
        int i10;
        synchronized (sLock) {
            if (sVersionCode == 0) {
                try {
                    sVersionCode = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
                } catch (PackageManager.NameNotFoundException unused) {
                    throw new IllegalStateException("Cannot determine package version");
                }
            }
            i10 = sVersionCode;
        }
        return i10;
    }
}
