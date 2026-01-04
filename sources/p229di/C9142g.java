package p229di;

import android.os.Build;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* renamed from: di.g */
/* loaded from: classes4.dex */
public class C9142g {

    /* renamed from: di.g$a */
    public static class a {

        /* renamed from: a */
        public Class<?>[] f45940a;

        /* renamed from: b */
        public Class<?> f45941b;

        /* renamed from: c */
        public Object f45942c;

        public a(Class<?> cls) {
            this(cls, cls);
        }

        /* renamed from: a */
        public static <T extends AccessibleObject> T m57466a(T t10) throws SecurityException {
            if (t10 == null) {
                return null;
            }
            if (t10 instanceof Member) {
                Member member = (Member) t10;
                if (Modifier.isPublic(member.getModifiers()) && Modifier.isPublic(member.getDeclaringClass().getModifiers())) {
                    return t10;
                }
            }
            if (!t10.isAccessible()) {
                t10.setAccessible(true);
            }
            return t10;
        }

        /* renamed from: b */
        public static a m57467b(Object obj, Class<?>... clsArr) {
            a aVar = new a(obj.getClass(), obj);
            aVar.f45940a = clsArr;
            return aVar;
        }

        /* renamed from: c */
        public static a m57468c(String str, Class<?>... clsArr) throws ClassNotFoundException {
            a aVar = new a(m57469g(str));
            aVar.f45940a = clsArr;
            return aVar;
        }

        /* renamed from: g */
        public static Class<?> m57469g(String str) throws ClassNotFoundException {
            return Class.forName(str);
        }

        /* renamed from: d */
        public a m57470d(String str, Object... objArr) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            Method method = (Method) m57466a((Method) m57474i(str).m57472f());
            if (method.getReturnType() == Void.TYPE) {
                method.invoke(this.f45942c, objArr);
                return new a(this.f45941b, this.f45942c);
            }
            Object objInvoke = method.invoke(this.f45942c, objArr);
            return objInvoke == null ? new a(Object.class) : new a(objInvoke.getClass(), objInvoke);
        }

        /* renamed from: e */
        public a m57471e(Object... objArr) throws IllegalAccessException, NoSuchMethodException, InstantiationException, SecurityException, InvocationTargetException {
            Constructor<?> declaredConstructor = this.f45941b.getDeclaredConstructor(this.f45940a);
            return new a(declaredConstructor.getDeclaringClass(), ((Constructor) m57466a(declaredConstructor)).newInstance(objArr));
        }

        /* renamed from: f */
        public <T> T m57472f() {
            return (T) this.f45942c;
        }

        /* renamed from: h */
        public a m57473h(String str) throws IllegalAccessException, NoSuchFieldException {
            Field field = (Field) m57466a(this.f45941b.getDeclaredField(str));
            return new a(field.getClass(), field.get(this.f45942c));
        }

        /* renamed from: i */
        public a m57474i(String str) throws NoSuchMethodException, SecurityException {
            Method declaredMethod = this.f45941b.getDeclaredMethod(str, this.f45940a);
            return new a(declaredMethod.getClass(), declaredMethod);
        }

        public a(Class<?> cls, Object obj) {
            this.f45941b = cls;
            this.f45942c = obj;
        }
    }

    /* renamed from: di.g$b */
    public static class b {
        /* renamed from: a */
        public static String m57475a(String str, String str2) {
            try {
                return (String) a.m57468c("android.os.SystemProperties", String.class, String.class).m57470d("get", str, str2).m57472f();
            } catch (Exception unused) {
                return str2;
            }
        }
    }

    /* renamed from: a */
    public static String m57462a(String str) {
        return m57463b() ? str.contains("com.hihonor") ? str.replace("com.hihonor", "com.huawei") : str.contains("com.baidu.input_hihonor") ? str.replace("com.baidu.input_hihonor", "com.baidu.input_huawei") : str : str;
    }

    /* renamed from: b */
    public static boolean m57463b() {
        return Build.VERSION.SDK_INT >= 31 && "HONOR".equals(b.m57475a("ro.product.manufacturer", ""));
    }

    /* renamed from: c */
    public static boolean m57464c() {
        return "HONOR".equals(b.m57475a("ro.product.manufacturer", "")) && Build.VERSION.SDK_INT >= 33;
    }

    /* renamed from: d */
    public static String m57465d(String str) {
        return m57463b() ? str.contains("com.huawei") ? str.replace("com.huawei", "com.hihonor") : str.contains("com.baidu.input_huawei") ? str.replace("com.baidu.input_huawei", "com.baidu.input_hihonor") : str : str;
    }
}
