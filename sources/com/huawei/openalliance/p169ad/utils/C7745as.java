package com.huawei.openalliance.p169ad.utils;

import com.huawei.openalliance.p169ad.AbstractC7185ho;
import java.lang.reflect.InvocationTargetException;

/* renamed from: com.huawei.openalliance.ad.utils.as */
/* loaded from: classes2.dex */
public class C7745as {

    /* renamed from: a */
    public static final String f35838a = m47604a("ro.build.version.emui", "");

    /* renamed from: com.huawei.openalliance.ad.utils.as$a */
    public static class a {

        /* renamed from: a */
        public static final int f35839a = C7745as.m47603a("ro.build.hw_emui_api_level", 0);

        /* renamed from: b */
        public static final int f35840b = C7745as.m47603a("ro.build.magic_api_level", 0);
    }

    /* renamed from: a */
    public static int m47603a(String str, int i10) {
        StringBuilder sb2;
        String str2;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            Object objInvoke = cls.getDeclaredMethod("getInt", String.class, Integer.TYPE).invoke(cls, str, Integer.valueOf(i10));
            if (objInvoke instanceof Integer) {
                return ((Integer) objInvoke).intValue();
            }
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException unused) {
            sb2 = new StringBuilder();
            str2 = "An exception occurred while reading SystemProperties: ";
            sb2.append(str2);
            sb2.append(str);
            AbstractC7185ho.m43826d("HwBuildEx", sb2.toString());
            return i10;
        } catch (Throwable unused2) {
            sb2 = new StringBuilder();
            str2 = "An Throwable occurred while reading SystemProperties: ";
            sb2.append(str2);
            sb2.append(str);
            AbstractC7185ho.m43826d("HwBuildEx", sb2.toString());
            return i10;
        }
        return i10;
    }

    /* renamed from: a */
    public static String m47604a(String str, String str2) {
        StringBuilder sb2;
        String str3;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            Object objInvoke = cls.getDeclaredMethod("get", String.class, String.class).invoke(cls, str, str2);
            if (objInvoke instanceof String) {
                return (String) objInvoke;
            }
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException unused) {
            sb2 = new StringBuilder();
            str3 = "An exception occurred while reading SystemProperties: ";
            sb2.append(str3);
            sb2.append(str);
            AbstractC7185ho.m43826d("HwBuildEx", sb2.toString());
            return str2;
        } catch (Throwable unused2) {
            sb2 = new StringBuilder();
            str3 = "An throwable occurred while reading SystemProperties: ";
            sb2.append(str3);
            sb2.append(str);
            AbstractC7185ho.m43826d("HwBuildEx", sb2.toString());
            return str2;
        }
        return str2;
    }
}
