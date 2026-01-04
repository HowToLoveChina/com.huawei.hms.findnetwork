package com.huawei.android.dynamicfeature.plugin.language;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Looper;
import android.webkit.WebView;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.WeakHashMap;
import p250e7.C9419a;
import p250e7.C9420b;

/* renamed from: com.huawei.android.dynamicfeature.plugin.language.l */
/* loaded from: classes2.dex */
public class C2404l {

    /* renamed from: a */
    public static final String f11490a = "l";

    /* renamed from: b */
    public static final WeakHashMap<AssetManager, Integer> f11491b = new WeakHashMap<>();

    /* renamed from: c */
    public static AssetManager f11492c = null;

    /* renamed from: d */
    public static ArrayList<String> f11493d = null;

    /* renamed from: e */
    public static ArrayList<Integer> f11494e = null;

    /* renamed from: a */
    public static boolean m15011a(Context context, File file) {
        if (context == null) {
            C9419a.m59077c(f11490a, "context is null");
            return false;
        }
        if (file != null) {
            return m15012b(context, file);
        }
        C9419a.m59077c(f11490a, "resFile is null");
        return false;
    }

    /* renamed from: b */
    public static boolean m15012b(Context context, File file) throws IOException {
        String canonicalPath;
        try {
            canonicalPath = file.getCanonicalPath();
        } catch (IOException e10) {
            C9419a.m59077c(f11490a, "addResourcesImpl get resource file IOException: " + e10.getMessage());
            canonicalPath = null;
        }
        if (!file.exists()) {
            C9419a.m59077c(f11490a, canonicalPath + " is not exists.");
            return false;
        }
        if (m15020j(context)) {
            m15021k(context);
        }
        try {
            if (C9420b.m59090d(context)) {
                int iM15017g = m15017g(context, canonicalPath);
                C9419a.m59080f(f11490a, "cookie " + iM15017g);
            } else {
                AssetManager assets = context.getResources().getAssets();
                Object objInvoke = m15013c("addAssetPath", String.class).invoke(assets, canonicalPath);
                C9419a.m59080f(f11490a, "addResources " + canonicalPath + ", result=" + objInvoke + ", assets=" + assets);
            }
            return true;
        } catch (Exception e11) {
            C9419a.m59078d(f11490a, "addResources failed", e11);
            return false;
        } catch (Throwable th2) {
            C9419a.m59078d(f11490a, "addResources failed", th2);
            return false;
        }
    }

    /* renamed from: c */
    public static Method m15013c(String str, Class<?>... clsArr) throws NoSuchMethodException, SecurityException {
        Method declaredMethod = AssetManager.class.getDeclaredMethod(str, clsArr);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    /* renamed from: d */
    public static Resources m15014d(Resources resources) throws NoSuchFieldException, SecurityException {
        if (resources == null) {
            return null;
        }
        try {
            Field declaredField = resources.getClass().getDeclaredField("mBase");
            declaredField.setAccessible(true);
            return (Resources) declaredField.get(resources);
        } catch (Exception unused) {
            C9419a.m59080f(f11490a, "getBaseResources false");
            return null;
        }
    }

    /* renamed from: e */
    public static Resources m15015e(Context context) throws SecurityException {
        if (context == null) {
            return null;
        }
        try {
            Field fieldM15016f = m15016f(context.getClass(), "mKitResources");
            if (fieldM15016f == null) {
                C9419a.m59080f(f11490a, "mKitResource null");
                return null;
            }
            fieldM15016f.setAccessible(true);
            return (Resources) fieldM15016f.get(context);
        } catch (Exception unused) {
            C9419a.m59080f(f11490a, "getKitResource false");
            return null;
        }
    }

    /* renamed from: f */
    public static Field m15016f(Class<?> cls, String str) {
        while (cls != null) {
            for (Field field : cls.getDeclaredFields()) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            cls = cls.getSuperclass();
        }
        return null;
    }

    /* renamed from: g */
    public static int m15017g(Context context, String str) throws NoSuchFieldException, NoSuchMethodException, SecurityException {
        int iM15018h = m15018h(context.getResources(), "addAssetPath", str);
        String str2 = f11490a;
        C9419a.m59080f(str2, "cookie " + iM15018h);
        Resources resourcesM15014d = m15014d(context.getResources());
        if (resourcesM15014d != null) {
            int iM15018h2 = m15018h(resourcesM15014d, "addAssetPath", str);
            C9419a.m59080f(str2, "mBase cookie " + iM15018h2);
            Resources resourcesM15014d2 = m15014d(resourcesM15014d);
            if (resourcesM15014d2 == null) {
                return iM15018h2;
            }
            int iM15018h3 = m15018h(resourcesM15014d2, "addAssetPath", str);
            C9419a.m59080f(str2, "mBase mBase cookie " + iM15018h3);
            return iM15018h3;
        }
        Resources resourcesM15015e = m15015e(context);
        int iM15018h4 = m15018h(resourcesM15015e, "addAssetPath", str);
        C9419a.m59080f(str2, "kitResource invokeAddAssetPath " + iM15018h4);
        if (iM15018h4 < 0) {
            return iM15018h4;
        }
        int iM15018h5 = m15018h(m15014d(resourcesM15015e), "addAssetPath", str);
        C9419a.m59080f(str2, "kitResource base invokeAddAssetPath " + iM15018h5);
        return iM15018h5;
    }

    /* renamed from: h */
    public static int m15018h(Resources resources, String str, String str2) throws NoSuchMethodException, SecurityException {
        if (resources == null) {
            return -1;
        }
        try {
            AssetManager assets = resources.getAssets();
            Method declaredMethod = assets.getClass().getDeclaredMethod(str, String.class);
            declaredMethod.setAccessible(true);
            int iIntValue = ((Integer) declaredMethod.invoke(assets, str2)).intValue();
            C9419a.m59080f(f11490a, "kitAssetCookie = " + iIntValue);
            return iIntValue;
        } catch (Exception unused) {
            C9419a.m59081g(f11490a, "invokeAddAssetPath false");
            return -1;
        }
    }

    /* renamed from: i */
    public static boolean m15019i() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    /* renamed from: j */
    public static boolean m15020j(Context context) {
        return !f11491b.containsKey(context.getAssets());
    }

    /* renamed from: k */
    public static void m15021k(Context context) {
        if (f11491b.containsKey(context.getAssets())) {
            return;
        }
        try {
            if (m15019i()) {
                new WebView(context).destroy();
            }
        } catch (Exception unused) {
            C9419a.m59077c(f11490a, "Failed to init WebView");
        }
        AssetManager assets = context.getAssets();
        C9419a.m59080f(f11490a, "the context resources changed");
        f11491b.put(assets, Integer.MAX_VALUE);
    }
}
