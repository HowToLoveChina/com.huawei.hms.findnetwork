package com.huawei.hms.ads.identifier;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import java.io.Closeable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.huawei.hms.ads.identifier.j */
/* loaded from: classes8.dex */
public abstract class AbstractC5076j {

    /* renamed from: a */
    public static final ThreadPoolExecutor f23213a = new ThreadPoolExecutor(0, 3, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(2048), new ThreadPoolExecutor.DiscardPolicy());

    /* renamed from: a */
    public static Context m30316a(Context context) {
        return m30318a() ? context.createDeviceProtectedStorageContext() : context;
    }

    /* renamed from: b */
    public static Integer m30320b(Context context) {
        Bundle bundle;
        Object obj;
        if (context == null) {
            return null;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(C5072f.m30263a(context), 128);
            if (applicationInfo != null && (bundle = applicationInfo.metaData) != null && (obj = bundle.get("ppskit_ver_code")) != null) {
                return Integer.valueOf(obj.toString());
            }
        } catch (Throwable th2) {
            Log.i("StmUt", "getPpsKitVerCode ex: " + th2.getClass().getSimpleName());
        }
        return null;
    }

    /* renamed from: a */
    public static void m30317a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th2) {
                Log.w("StmUt", "close " + th2.getClass().getSimpleName());
            }
        }
    }

    /* renamed from: a */
    private static boolean m30318a() {
        return true;
    }

    /* renamed from: a */
    public static boolean m30319a(Context context, Uri uri) {
        if (context == null || uri == null) {
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        ProviderInfo providerInfoResolveContentProvider = packageManager.resolveContentProvider(uri.getAuthority(), 0);
        if (providerInfoResolveContentProvider == null) {
            Log.e("StmUt", "verify provider invalid param");
            return false;
        }
        ApplicationInfo applicationInfo = providerInfoResolveContentProvider.applicationInfo;
        if (applicationInfo == null) {
            return false;
        }
        String str = applicationInfo.packageName;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return packageManager.checkSignatures(context.getPackageName(), str) == 0 || (applicationInfo.flags & 1) == 1;
    }
}
