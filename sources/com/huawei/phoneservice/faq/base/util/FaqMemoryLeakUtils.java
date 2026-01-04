package com.huawei.phoneservice.faq.base.util;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.Keep;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;

/* loaded from: classes4.dex */
public class FaqMemoryLeakUtils {

    /* renamed from: com.huawei.phoneservice.faq.base.util.FaqMemoryLeakUtils$a */
    public class C8311a implements PrivilegedAction<Object> {

        /* renamed from: a */
        public final /* synthetic */ Field f38700a;

        public C8311a(Field field) {
            this.f38700a = field;
        }

        @Override // java.security.PrivilegedAction
        public Object run() throws SecurityException {
            this.f38700a.setAccessible(true);
            return null;
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.base.util.FaqMemoryLeakUtils$b */
    public class C8312b implements PrivilegedAction<Object> {

        /* renamed from: a */
        public final /* synthetic */ Method f38701a;

        public C8312b(Method method) {
            this.f38701a = method;
        }

        @Override // java.security.PrivilegedAction
        public Object run() throws SecurityException {
            this.f38701a.setAccessible(true);
            return null;
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.base.util.FaqMemoryLeakUtils$c */
    public class C8313c implements PrivilegedAction<Object> {

        /* renamed from: a */
        public final /* synthetic */ Field f38702a;

        public C8313c(Field field) {
            this.f38702a = field;
        }

        @Override // java.security.PrivilegedAction
        public Object run() throws SecurityException {
            this.f38702a.setAccessible(true);
            return null;
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.base.util.FaqMemoryLeakUtils$d */
    public class C8314d implements PrivilegedAction<Object> {

        /* renamed from: a */
        public final /* synthetic */ Field f38703a;

        public C8314d(Field field) {
            this.f38703a = field;
        }

        @Override // java.security.PrivilegedAction
        public Object run() throws SecurityException {
            this.f38703a.setAccessible(true);
            return null;
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.base.util.FaqMemoryLeakUtils$e */
    public class C8315e implements PrivilegedAction<Object> {

        /* renamed from: a */
        public final /* synthetic */ Field f38704a;

        public C8315e(Field field) {
            this.f38704a = field;
        }

        @Override // java.security.PrivilegedAction
        public Object run() throws SecurityException {
            this.f38704a.setAccessible(true);
            return null;
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.base.util.FaqMemoryLeakUtils$f */
    public class C8316f implements PrivilegedAction<Object> {

        /* renamed from: a */
        public final /* synthetic */ Field f38705a;

        public C8316f(Field field) {
            this.f38705a = field;
        }

        @Override // java.security.PrivilegedAction
        public Object run() throws SecurityException {
            this.f38705a.setAccessible(true);
            return null;
        }
    }

    /* renamed from: a */
    public static void m51853a(Context context) throws Throwable {
        StringBuilder sb2;
        String str;
        try {
            Class<?> cls = Class.forName("android.rms.iaware.FastgrabConfigReader");
            Field declaredField = cls.getDeclaredField("mFastgrabConfigReader");
            AccessController.doPrivileged(new C8315e(declaredField));
            Object obj = declaredField.get(cls);
            Field declaredField2 = cls.getDeclaredField("mContext");
            AccessController.doPrivileged(new C8316f(declaredField2));
            if (context == declaredField2.get(obj)) {
                FaqLogger.m51836d("FaqMemoryLeakUtils", "Checked FastgrabConfigReaderLeak");
                declaredField2.set(obj, null);
            }
        } catch (Exception e10) {
            e = e10;
            sb2 = new StringBuilder();
            str = "Exception:";
            sb2.append(str);
            sb2.append(e.getMessage());
            FaqLogger.m51836d("FaqMemoryLeakUtils", sb2.toString());
        } catch (ExceptionInInitializerError e11) {
            e = e11;
            sb2 = new StringBuilder();
            str = "ExceptionInInitializerError:";
            sb2.append(str);
            sb2.append(e.getMessage());
            FaqLogger.m51836d("FaqMemoryLeakUtils", sb2.toString());
        } catch (ReflectiveOperationException e12) {
            e = e12;
            sb2 = new StringBuilder();
            str = "ReflectiveOperationException:";
            sb2.append(str);
            sb2.append(e.getMessage());
            FaqLogger.m51836d("FaqMemoryLeakUtils", sb2.toString());
        }
    }

    /* renamed from: b */
    public static void m51854b(InputMethodManager inputMethodManager) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Method method = inputMethodManager.getClass().getMethod("resetInTransitionState", new Class[0]);
        AccessController.doPrivileged(new C8312b(method));
        method.invoke(inputMethodManager, new Object[0]);
    }

    /* renamed from: c */
    public static void m51855c(Context context) throws Throwable {
        StringBuilder sb2;
        String str;
        try {
            Class<?> cls = Class.forName("android.gestureboost.GestureBoostManager");
            Field declaredField = cls.getDeclaredField("sGestureBoostManager");
            AccessController.doPrivileged(new C8313c(declaredField));
            Object obj = declaredField.get(cls);
            Field declaredField2 = cls.getDeclaredField("mContext");
            AccessController.doPrivileged(new C8314d(declaredField2));
            if (context == declaredField2.get(obj)) {
                FaqLogger.m51836d("FaqMemoryLeakUtils", "Checked GestureBoostManagerLeak");
                declaredField2.set(obj, null);
            }
        } catch (Exception e10) {
            e = e10;
            sb2 = new StringBuilder();
            str = "Exception";
            sb2.append(str);
            sb2.append(e.getMessage());
            FaqLogger.m51836d("FaqMemoryLeakUtils", sb2.toString());
        } catch (ExceptionInInitializerError e11) {
            e = e11;
            sb2 = new StringBuilder();
            str = "ExceptionInInitializerError";
            sb2.append(str);
            sb2.append(e.getMessage());
            FaqLogger.m51836d("FaqMemoryLeakUtils", sb2.toString());
        } catch (ReflectiveOperationException e12) {
            e = e12;
            sb2 = new StringBuilder();
            str = "ReflectiveOperationException";
            sb2.append(str);
            sb2.append(e.getMessage());
            FaqLogger.m51836d("FaqMemoryLeakUtils", sb2.toString());
        }
    }

    /* renamed from: d */
    public static void m51856d(Context context) throws Throwable {
        InputMethodManager inputMethodManager;
        StringBuilder sb2;
        String str;
        if (context == null || (inputMethodManager = (InputMethodManager) context.getSystemService("input_method")) == null) {
            return;
        }
        String[] strArr = {"mCurRootView", "mServedView", "mNextServedView"};
        for (int i10 = 0; i10 < 3; i10++) {
            try {
                Field declaredField = inputMethodManager.getClass().getDeclaredField(strArr[i10]);
                if (!declaredField.isAccessible()) {
                    AccessController.doPrivileged(new C8311a(declaredField));
                }
                Object obj = declaredField.get(inputMethodManager);
                if (obj != null && (obj instanceof View)) {
                    if (((View) obj).getContext() != context) {
                        break;
                    } else {
                        declaredField.set(inputMethodManager, null);
                    }
                }
            } catch (ExceptionInInitializerError e10) {
                e = e10;
                sb2 = new StringBuilder();
                str = "ExceptionInInitializerError";
                sb2.append(str);
                sb2.append(e.getMessage());
                FaqLogger.m51836d("FaqMemoryLeakUtils", sb2.toString());
                return;
            } catch (NoSuchMethodException e11) {
                e = e11;
                sb2 = new StringBuilder();
                str = "NoSuchMethodException:";
                sb2.append(str);
                sb2.append(e.getMessage());
                FaqLogger.m51836d("FaqMemoryLeakUtils", sb2.toString());
                return;
            } catch (ReflectiveOperationException e12) {
                e = e12;
                sb2 = new StringBuilder();
                str = "ReflectiveOperationException";
                sb2.append(str);
                sb2.append(e.getMessage());
                FaqLogger.m51836d("FaqMemoryLeakUtils", sb2.toString());
                return;
            } catch (Exception e13) {
                e = e13;
                sb2 = new StringBuilder();
                str = "Exception";
                sb2.append(str);
                sb2.append(e.getMessage());
                FaqLogger.m51836d("FaqMemoryLeakUtils", sb2.toString());
                return;
            }
        }
        m51854b(inputMethodManager);
    }

    @Keep
    public static void fixMemoryLeak(Context context) throws Throwable {
        m51856d(context);
        m51855c(context);
        m51853a(context);
    }
}
