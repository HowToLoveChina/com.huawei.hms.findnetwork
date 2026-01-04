package p481n1;

import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.hms.network.embedded.C5929g4;
import com.huawei.openalliance.p169ad.beans.parameter.RequestOptions;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import p274f1.InterfaceC9641b;
import p305g1.C9837b;
import p305g1.C9846k;

/* renamed from: n1.b */
/* loaded from: classes.dex */
public class C11590b {

    /* renamed from: a */
    public static final String f53766a;

    /* renamed from: b */
    public static final boolean f53767b;

    static {
        String property = System.getProperty("java.vm.name");
        f53766a = property;
        f53767b = m69188e(property);
    }

    /* renamed from: a */
    public static boolean m69184a(String str) {
        for (int i10 = 0; i10 < str.length(); i10++) {
            char cCharAt = str.charAt(i10);
            if (cCharAt < 1 || cCharAt > 127 || cCharAt == '.') {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public static String m69185b(Class<?> cls) {
        if (cls.isPrimitive()) {
            return m69187d(cls);
        }
        if (cls.isArray()) {
            return "[" + m69185b(cls.getComponentType());
        }
        return "L" + m69190g(cls) + ";";
    }

    /* renamed from: c */
    public static String m69186c(Method method) {
        Class<?>[] parameterTypes = method.getParameterTypes();
        StringBuilder sb2 = new StringBuilder((parameterTypes.length + 1) << 4);
        sb2.append(C5929g4.f26849k);
        for (Class<?> cls : parameterTypes) {
            sb2.append(m69185b(cls));
        }
        sb2.append(C5929g4.f26850l);
        sb2.append(m69185b(method.getReturnType()));
        return sb2.toString();
    }

    /* renamed from: d */
    public static String m69187d(Class<?> cls) {
        if (Integer.TYPE == cls) {
            return "I";
        }
        if (Void.TYPE == cls) {
            return "V";
        }
        if (Boolean.TYPE == cls) {
            return "Z";
        }
        if (Character.TYPE == cls) {
            return "C";
        }
        if (Byte.TYPE == cls) {
            return CloudBackupConstant.UserPackageInfo.ONE_T_MEMBER;
        }
        if (Short.TYPE == cls) {
            return CloudBackupConstant.UserPackageInfo.SILVER_MEMBER;
        }
        if (Float.TYPE == cls) {
            return "F";
        }
        if (Long.TYPE == cls) {
            return RequestOptions.AD_CONTENT_CLASSIFICATION_J;
        }
        if (Double.TYPE == cls) {
            return "D";
        }
        throw new IllegalStateException("Type: " + cls.getCanonicalName() + " is not a primitive type");
    }

    /* renamed from: e */
    public static boolean m69188e(String str) {
        if (str == null) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        return lowerCase.contains("dalvik") || lowerCase.contains("lemur");
    }

    /* renamed from: f */
    public static String[] m69189f(AccessibleObject accessibleObject) throws IOException {
        Class<?>[] parameterTypes;
        Class<?> declaringClass;
        Annotation[][] annotationArrM69287c0;
        String name;
        String strName;
        if (f53767b) {
            return new String[0];
        }
        if (accessibleObject instanceof Method) {
            Method method = (Method) accessibleObject;
            parameterTypes = method.getParameterTypes();
            name = method.getName();
            declaringClass = method.getDeclaringClass();
            annotationArrM69287c0 = C11603o.m69289d0(method);
        } else {
            Constructor constructor = (Constructor) accessibleObject;
            parameterTypes = constructor.getParameterTypes();
            declaringClass = constructor.getDeclaringClass();
            annotationArrM69287c0 = C11603o.m69287c0(constructor);
            name = "<init>";
        }
        if (parameterTypes.length == 0) {
            return new String[0];
        }
        ClassLoader classLoader = declaringClass.getClassLoader();
        if (classLoader == null) {
            classLoader = ClassLoader.getSystemClassLoader();
        }
        InputStream resourceAsStream = classLoader.getResourceAsStream(declaringClass.getName().replace('.', C5929g4.f26852n) + ".class");
        if (resourceAsStream == null) {
            return new String[0];
        }
        try {
            C9837b c9837b = new C9837b(resourceAsStream, false);
            C9846k c9846k = new C9846k(name, parameterTypes);
            c9837b.m61152a(c9846k);
            String[] strArrM61204b = c9846k.m61204b();
            for (int i10 = 0; i10 < strArrM61204b.length; i10++) {
                Annotation[] annotationArr = annotationArrM69287c0[i10];
                if (annotationArr != null) {
                    for (Annotation annotation : annotationArr) {
                        if ((annotation instanceof InterfaceC9641b) && (strName = ((InterfaceC9641b) annotation).name()) != null && strName.length() > 0) {
                            strArrM61204b[i10] = strName;
                        }
                    }
                }
            }
            return strArrM61204b;
        } catch (IOException unused) {
            return new String[0];
        } finally {
            C11595g.m69206a(resourceAsStream);
        }
    }

    /* renamed from: g */
    public static String m69190g(Class<?> cls) {
        if (!cls.isArray()) {
            return !cls.isPrimitive() ? cls.getName().replace('.', C5929g4.f26852n) : m69187d(cls);
        }
        return "[" + m69185b(cls.getComponentType());
    }
}
