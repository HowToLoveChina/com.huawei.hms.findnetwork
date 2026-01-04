package com.huawei.openalliance.p169ad.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import java.io.File;

/* renamed from: com.huawei.openalliance.ad.utils.cw */
/* loaded from: classes2.dex */
public abstract class AbstractC7803cw {
    /* renamed from: a */
    public static String m48129a(Context context) {
        String strM48135e;
        return (!m48130a() || (strM48135e = m48135e(context)) == null) ? m48134d(context) : strM48135e;
    }

    /* renamed from: b */
    public static String m48131b(Context context) {
        m48130a();
        return m48134d(context);
    }

    /* renamed from: c */
    public static String m48133c(Context context) {
        m48130a();
        return m48136f(context);
    }

    /* renamed from: d */
    public static String m48134d(Context context) {
        File filesDir;
        return (context == null || (filesDir = context.getFilesDir()) == null) ? "" : AbstractC7731ae.m47469h(filesDir);
    }

    /* renamed from: e */
    public static String m48135e(Context context) {
        if (context == null) {
            return "";
        }
        try {
            File externalFilesDir = context.getExternalFilesDir(null);
            if (externalFilesDir != null) {
                return AbstractC7731ae.m47469h(externalFilesDir);
            }
        } catch (Exception unused) {
            AbstractC7185ho.m43823c("StorageUtils", "getExternalFilesDir exception, use memory card folder.");
        }
        return null;
    }

    /* renamed from: f */
    public static String m48136f(Context context) {
        File cacheDir;
        return (context == null || (cacheDir = context.getCacheDir()) == null) ? "" : AbstractC7731ae.m47469h(cacheDir);
    }

    /* renamed from: g */
    public static String m48137g(Context context) {
        if (context == null) {
            return "";
        }
        try {
            File externalCacheDir = context.getExternalCacheDir();
            if (externalCacheDir != null) {
                return AbstractC7731ae.m47469h(externalCacheDir);
            }
            return null;
        } catch (Exception unused) {
            AbstractC7185ho.m43823c("StorageUtils", "getExternalFilesDir exception, use memory card folder.");
            return null;
        }
    }

    /* renamed from: a */
    public static boolean m48130a() {
        return TextUtils.equals("mounted", Environment.getExternalStorageState()) || !m48132b();
    }

    @TargetApi(9)
    /* renamed from: b */
    public static boolean m48132b() {
        try {
            if (AbstractC7811dd.m48297a()) {
                return Environment.isExternalStorageRemovable();
            }
            return true;
        } catch (Throwable th2) {
            AbstractC7185ho.m43823c("StorageUtils", "isExternalStorageRemovable, " + th2.getClass().getSimpleName());
            return true;
        }
    }
}
