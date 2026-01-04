package p434kt;

import android.content.Context;
import java.io.File;
import p405jt.AbstractC10915a;

/* renamed from: kt.e */
/* loaded from: classes2.dex */
public abstract class AbstractC11151e {
    /* renamed from: a */
    public static String m67065a(Context context) {
        File cacheDir;
        return (context == null || (cacheDir = context.getCacheDir()) == null) ? "" : AbstractC11149c.m67062c(cacheDir);
    }

    /* renamed from: b */
    public static String m67066b(Context context) {
        File filesDir;
        return (context == null || (filesDir = context.getFilesDir()) == null) ? "" : AbstractC11149c.m67062c(filesDir);
    }

    /* renamed from: c */
    public static String m67067c(Context context) {
        if (context == null) {
            return "";
        }
        try {
            File externalCacheDir = context.getExternalCacheDir();
            if (externalCacheDir != null) {
                return AbstractC11149c.m67062c(externalCacheDir);
            }
        } catch (Exception unused) {
            AbstractC10915a.m65978j("StorageUtils", "getExternalFilesDir exception, use memory card folder.");
        }
        return "";
    }

    /* renamed from: d */
    public static String m67068d(Context context) {
        if (context == null) {
            return "";
        }
        try {
            File externalFilesDir = context.getExternalFilesDir(null);
            if (externalFilesDir != null) {
                return AbstractC11149c.m67062c(externalFilesDir);
            }
        } catch (Exception unused) {
            AbstractC10915a.m65978j("StorageUtils", "getExternalFilesDir exception, use memory card folder.");
        }
        return "";
    }
}
