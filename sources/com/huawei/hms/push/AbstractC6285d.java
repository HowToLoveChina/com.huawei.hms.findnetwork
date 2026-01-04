package com.huawei.hms.push;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.support.log.HMSLog;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import org.json.JSONObject;
import p443l4.AbstractC11229a;

/* renamed from: com.huawei.hms.push.d */
/* loaded from: classes8.dex */
public abstract class AbstractC6285d {

    /* renamed from: a */
    private static final Object f29665a = new Object();

    /* renamed from: b */
    private static int f29666b = -1;

    /* renamed from: a */
    private static boolean m36509a(Context context) {
        HMSLog.m36983d("CommFun", "existFrameworkPush:" + f29666b);
        try {
            File file = new File("/system/framework/hwpush.jar");
            if (!m36508a() && !file.isFile()) {
                return false;
            }
            HMSLog.m36983d("CommFun", "push jarFile is exist");
            return true;
        } catch (Exception e10) {
            HMSLog.m36986e("CommFun", "get Apk version faild ,Exception e= " + e10.toString());
            return false;
        }
    }

    /* renamed from: b */
    public static long m36511b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.huawei.android.pushagent", 16384).versionCode;
        } catch (Exception unused) {
            HMSLog.m36986e("CommFun", "get nc versionCode error");
            return -1L;
        }
    }

    /* renamed from: c */
    public static boolean m36514c() {
        return HwBuildEx.VERSION.EMUI_SDK_INT < 19;
    }

    /* renamed from: d */
    public static boolean m36515d(Context context) {
        HMSLog.m36983d("CommFun", "existFrameworkPush:" + f29666b);
        synchronized (f29665a) {
            try {
                int i10 = f29666b;
                if (-1 != i10) {
                    return 1 == i10;
                }
                if (m36509a(context)) {
                    f29666b = 1;
                } else {
                    f29666b = 0;
                }
                return 1 == f29666b;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: c */
    public static String m36513c(Context context) {
        return AbstractC11229a.m67436d(context).mo66356b("client/project_id");
    }

    /* renamed from: b */
    public static boolean m36512b() {
        return HwBuildEx.VERSION.EMUI_SDK_INT >= 21;
    }

    /* renamed from: a */
    private static boolean m36508a() throws ClassNotFoundException {
        try {
            Class<?> cls = Class.forName("huawei.cust.HwCfgFilePolicy");
            Integer num = (Integer) cls.getDeclaredField("CUST_TYPE_CONFIG").get(cls);
            num.intValue();
            File file = (File) cls.getDeclaredMethod("getCfgFile", String.class, Integer.TYPE).invoke(cls, "jars/hwpush.jar", num);
            if (file != null && file.exists()) {
                HMSLog.m36983d("CommFun", "get push cust File path success.");
                return true;
            }
        } catch (ClassNotFoundException unused) {
            HMSLog.m36986e("CommFun", "HwCfgFilePolicy ClassNotFoundException");
        } catch (IllegalAccessException unused2) {
            HMSLog.m36986e("CommFun", "check cust exist push IllegalAccessException.");
        } catch (IllegalArgumentException unused3) {
            HMSLog.m36986e("CommFun", "check cust exist push IllegalArgumentException.");
        } catch (NoSuchFieldException unused4) {
            HMSLog.m36986e("CommFun", "check cust exist push NoSuchFieldException.");
        } catch (NoSuchMethodException unused5) {
            HMSLog.m36986e("CommFun", "check cust exist push NoSuchMethodException.");
        } catch (SecurityException unused6) {
            HMSLog.m36986e("CommFun", "check cust exist push SecurityException.");
        } catch (InvocationTargetException unused7) {
            HMSLog.m36986e("CommFun", "check cust exist push InvocationTargetException.");
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m36510a(JSONObject jSONObject, JSONObject jSONObject2, String str) {
        return jSONObject == null || (TextUtils.isEmpty(str) && jSONObject2 == null);
    }
}
