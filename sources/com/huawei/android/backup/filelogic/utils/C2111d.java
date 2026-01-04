package com.huawei.android.backup.filelogic.utils;

import android.util.Log;
import java.lang.reflect.Field;

/* renamed from: com.huawei.android.backup.filelogic.utils.d */
/* loaded from: classes.dex */
public final class C2111d {

    /* renamed from: c */
    public static boolean f9541c;

    /* renamed from: d */
    public static boolean f9542d;

    /* renamed from: a */
    public static final ThreadLocal<StringBuilder> f9539a = new a();

    /* renamed from: b */
    public static String f9540b = "PhoneClone";

    /* renamed from: e */
    public static String f9543e = "";

    /* renamed from: com.huawei.android.backup.filelogic.utils.d$a */
    public class a extends ThreadLocal<StringBuilder> {
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public StringBuilder initialValue() {
            return new StringBuilder();
        }
    }

    static {
        boolean z10 = false;
        f9541c = false;
        f9542d = true;
        try {
            Field field = Log.class.getField("HWLog");
            Field field2 = Log.class.getField("HWModuleLog");
            Field field3 = Log.class.getField("HWINFO");
            f9541c = field.getBoolean(null);
            f9542d = field3.getBoolean(null);
            boolean z11 = field2.getBoolean(null);
            f9541c = f9541c || (z11 && Log.isLoggable("LogUtil", 3));
            if (f9542d || (z11 && Log.isLoggable("LogUtil", 4))) {
                z10 = true;
            }
            f9542d = z10;
            m12653i("LogUtil", "HwDebug: " + f9541c + " HwModuleDebug: " + z11);
        } catch (IllegalAccessException e10) {
            m12648d("LogUtil", "error:getLogField--IllegalAccessException" + e10.getMessage());
        } catch (IllegalArgumentException e11) {
            m12648d("LogUtil", "error:getLogField--IllegalArgumentException" + e11.getMessage());
        } catch (NoSuchFieldException e12) {
            m12648d("LogUtil", "error:getLogField--NoSuchFieldException" + e12.getMessage());
        }
    }

    /* renamed from: a */
    public static String m12645a(Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return "NULL";
        }
        StringBuilder sbM12651g = m12651g();
        for (Object obj : objArr) {
            sbM12651g.append(obj);
        }
        return sbM12651g.toString().replaceAll("\t|\r|\n", "-");
    }

    /* renamed from: b */
    public static void m12646b(String str, String str2) {
        if (f9541c) {
            Log.d(f9540b, f9543e + str + " debug:" + str2);
        }
    }

    /* renamed from: c */
    public static void m12647c(String str, Object... objArr) {
        if (f9541c) {
            m12646b(str, m12645a(objArr));
        }
    }

    /* renamed from: d */
    public static void m12648d(String str, String str2) {
        Log.e(f9540b, f9543e + str + ": " + str2);
    }

    /* renamed from: e */
    public static void m12649e(String str, Object... objArr) {
        m12648d(str, m12645a(objArr));
    }

    /* renamed from: f */
    public static String m12650f(String str, String str2, String str3, String str4, String str5) {
        StringBuilder sb2 = new StringBuilder(str);
        sb2.append(";moduleName:app");
        sb2.append(";method:");
        sb2.append(str2);
        sb2.append(";errorInfo:");
        sb2.append(str3);
        sb2.append(";appName=");
        sb2.append(str4);
        if (str5 != null) {
            sb2.append(";appVersion=");
            sb2.append(str5);
        }
        return sb2.toString();
    }

    /* renamed from: g */
    public static StringBuilder m12651g() {
        StringBuilder sb2 = f9539a.get();
        sb2.setLength(0);
        return sb2;
    }

    /* renamed from: h */
    public static String m12652h(String str, String str2, String str3, String str4) {
        return str + ";moduleName:" + str2 + ";method:" + str3 + ";errorInfo:" + str4;
    }

    /* renamed from: i */
    public static void m12653i(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        Log.i(f9540b, f9543e + str + ": " + str2);
    }

    /* renamed from: j */
    public static void m12654j(String str, Object... objArr) {
        m12653i(str, m12645a(objArr));
    }

    /* renamed from: k */
    public static boolean m12655k() {
        return f9542d;
    }

    /* renamed from: l */
    public static void m12656l(String str) {
        f9543e = "Service_";
        m12653i("LogUtil", "mModuleTags: " + str);
    }

    /* renamed from: m */
    public static void m12657m(String str, String str2) {
        Log.w(f9540b, f9543e + str + ": " + str2);
    }

    /* renamed from: n */
    public static void m12658n(String str, Object... objArr) {
        m12657m(str, m12645a(objArr));
    }
}
