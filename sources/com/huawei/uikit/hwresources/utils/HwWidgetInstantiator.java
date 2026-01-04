package com.huawei.uikit.hwresources.utils;

import android.app.UiModeManager;
import android.content.Context;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/* loaded from: classes4.dex */
public class HwWidgetInstantiator {
    public static final int TYPE_CAR = 4;
    public static final int TYPE_MASK = 15;
    public static final int TYPE_NORMAL = 1;
    public static final int TYPE_TELEVISION = 2;
    public static final int TYPE_WATCH = 8;

    /* renamed from: a */
    private static final String f43990a = "HwWidgetInstantiator";

    /* renamed from: b */
    private static final String f43991b = "com.huawei.uikit";

    /* renamed from: c */
    private static final String f43992c = "com.huawei.uikit.phone";

    /* renamed from: d */
    private static final String f43993d = "com.huawei.uikit.tv";

    /* renamed from: e */
    private static final String f43994e = "com.huawei.uikit.car";

    /* renamed from: f */
    private static final String f43995f = "com.huawei.uikit.watch";

    /* renamed from: g */
    private static final Map<String, Class<?>> f43996g = new ArrayMap();

    private HwWidgetInstantiator() {
    }

    public static int getCurrentType(Context context, int i10, int i11) {
        int currentType = getCurrentType(context);
        return ((i10 & 15) & currentType) == 0 ? i11 : currentType;
    }

    public static int getCurrnetType(Context context) {
        return getCurrentType(context);
    }

    public static String getDeviceClassName(Context context, Class<?> cls) {
        return getDeviceClassName(context, cls, getCurrnetType(context));
    }

    public static int getSystemUiModeType(Context context) {
        Object systemService = context.getSystemService("uimode");
        if (systemService instanceof UiModeManager) {
            return ((UiModeManager) systemService).getCurrentModeType();
        }
        return 0;
    }

    public static Object instantiate(Context context, String str, Class<?> cls) throws ClassNotFoundException {
        if (context == null || TextUtils.isEmpty(str) || cls == null) {
            Log.i(f43990a, "instantiate: return is null.");
            return null;
        }
        try {
            Map<String, Class<?>> map = f43996g;
            Class<?> clsLoadClass = map.get(str);
            if (clsLoadClass == null) {
                clsLoadClass = context.getClassLoader().loadClass(str);
                if (!cls.isAssignableFrom(clsLoadClass)) {
                    Log.w(f43990a, "Trying to instantiate the class that is not " + cls.getName());
                    return null;
                }
                map.put(str, clsLoadClass);
            }
            return clsLoadClass.getDeclaredConstructor(Context.class).newInstance(context);
        } catch (ClassNotFoundException unused) {
            Log.w(f43990a, str + ": make sure class name exists, is public, and has an empty constructor that is public");
            return null;
        } catch (IllegalAccessException unused2) {
            Log.w(f43990a, str + ": calling constructor caused an IllegalAccessException");
            return null;
        } catch (InstantiationException unused3) {
            Log.w(f43990a, str + ": calling constructor caused an InstantiationException");
            return null;
        } catch (NoSuchMethodException unused4) {
            Log.w(f43990a, str + ": could not find constructor");
            return null;
        } catch (InvocationTargetException unused5) {
            Log.w(f43990a, str + ": calling constructor caused an InvocationTargetException");
            return null;
        }
    }

    public static int getCurrentType(Context context) {
        int i10 = context.getResources().getConfiguration().uiMode & 15;
        int i11 = i10 != 3 ? i10 != 4 ? 1 : 2 : 4;
        if (i10 == 6) {
            return 8;
        }
        return i11;
    }

    public static String getDeviceClassName(Context context, Class<?> cls, int i10) {
        return cls.getName().replace(f43991b, i10 != 2 ? i10 != 4 ? i10 != 8 ? f43992c : f43995f : f43994e : f43993d);
    }
}
