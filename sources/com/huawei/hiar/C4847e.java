package com.huawei.hiar;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Log;
import java.io.Closeable;
import java.io.IOException;

/* renamed from: com.huawei.hiar.e */
/* loaded from: classes5.dex */
public class C4847e {

    /* renamed from: a */
    private static final String f22044a = "e";

    /* renamed from: a */
    public static void m29088a(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException unused) {
            Log.e(f22044a, "closeSilently close steam failed!");
        }
    }

    /* renamed from: a */
    public static boolean m29089a(Context context, String str) throws PackageManager.NameNotFoundException {
        Signature signatureM29084a = C4846d.m29084a(context, str);
        if (C4846d.m29085b(signatureM29084a, C4846d.m29087d(context, "arengine_conf_new"))) {
            return true;
        }
        return C4846d.m29085b(signatureM29084a, C4846d.m29087d(context, "arengine_conf_old"));
    }
}
