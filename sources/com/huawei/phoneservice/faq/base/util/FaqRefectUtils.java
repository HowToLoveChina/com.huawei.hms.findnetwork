package com.huawei.phoneservice.faq.base.util;

import androidx.annotation.Keep;
import com.huawei.android.hicloud.sync.wifi.datamanager.ExtractOWiFiHelper;
import com.huawei.openalliance.p169ad.p171db.bean.TemplateStyleRecord;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;

/* loaded from: classes4.dex */
public class FaqRefectUtils {

    @Keep
    public enum ResType {
        RES_TYPE_ID("id"),
        RES_TYPE_LAYOUT("layout"),
        RES_TYPE_STRING(ExtractOWiFiHelper.STING_NODE),
        RES_TYPE_DRAWABLE("drawable"),
        RES_TYPE_XML("xml"),
        RES_TYPE_STYLEABLE("styleable"),
        RES_TYPE_STYLE(TemplateStyleRecord.STYLE),
        RES_TYPE_MENU("menu");

        private String type;

        ResType(String str) {
            this.type = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.type;
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.base.util.FaqRefectUtils$a */
    public class C8318a implements PrivilegedAction<Object> {

        /* renamed from: a */
        public final /* synthetic */ AccessibleObject f38707a;

        /* renamed from: b */
        public final /* synthetic */ boolean f38708b;

        public C8318a(AccessibleObject accessibleObject, boolean z10) {
            this.f38707a = accessibleObject;
            this.f38708b = z10;
        }

        @Override // java.security.PrivilegedAction
        public Object run() throws SecurityException {
            this.f38707a.setAccessible(this.f38708b);
            return null;
        }
    }

    /* renamed from: a */
    public static Object m51857a(Class cls, Object obj) throws Throwable {
        if (cls == null) {
            FaqLogger.m51840e("RefectUtilss", "getReflectConstructor is null");
            return null;
        }
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        declaredConstructors[0].setAccessible(true);
        try {
            return declaredConstructors[0].newInstance(obj);
        } catch (Throwable unused) {
            FaqLogger.m51840e("RefectUtilss", "getReflectConstructor exception");
            return null;
        }
    }

    /* renamed from: b */
    public static Object m51858b(Class<?> cls, Object obj, String str, Class<?>[] clsArr, Object[] objArr) throws Throwable {
        Method method;
        try {
            method = cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e10) {
            m51860d(e10, "RefectUtilss");
            method = null;
        }
        if (method != null) {
            try {
                return method.invoke(obj, objArr);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e11) {
                m51860d(e11, "RefectUtilss");
            }
        }
        return null;
    }

    /* renamed from: c */
    public static Object m51859c(String str, String str2, Object obj, Class<?>[] clsArr, Object[] objArr) throws Throwable {
        Class<?> cls;
        Object objM51857a;
        if (clsArr != null && objArr != null && clsArr.length == objArr.length) {
            try {
                cls = Class.forName(str);
            } catch (ClassNotFoundException e10) {
                m51860d(e10, "RefectUtilss");
                cls = null;
            }
            if (cls != null && (objM51857a = m51857a(cls, obj)) != null) {
                return m51858b(cls, objM51857a, str2, clsArr, objArr);
            }
        }
        return null;
    }

    /* renamed from: d */
    public static void m51860d(Exception exc, String str) throws Throwable {
        if (exc == null || exc.getMessage() == null) {
            return;
        }
        FaqLogger.m51840e(str, exc.getMessage());
    }

    @Keep
    public static void setAccessible(AccessibleObject accessibleObject, boolean z10) {
        if (accessibleObject != null) {
            AccessController.doPrivileged(new C8318a(accessibleObject, z10));
        }
    }

    @Keep
    public static void setIntFiled(Object obj, Class<?> cls, String str, int i10) throws Throwable {
        if (cls != null) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                setAccessible(declaredField, true);
                declaredField.set(obj, Integer.valueOf(i10));
            } catch (IllegalAccessException | NoSuchFieldException e10) {
                m51860d(e10, "RefectUtilss");
            }
        }
    }
}
