package p219d7;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import p031b7.C1120a;

/* renamed from: d7.b */
/* loaded from: classes2.dex */
public class C9046b {
    /* renamed from: a */
    public static Field m57019a(Object obj, String str) throws NoSuchFieldException, SecurityException {
        for (Class<?> superclass = obj.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
            try {
                Field declaredField = superclass.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException e10) {
                C1120a.m6676e("AlbumReflectUtil", "findField error: " + e10);
            }
        }
        throw new NoSuchFieldException("Field " + str + " not found in " + obj.getClass());
    }

    /* renamed from: b */
    public static Method m57020b(Object obj, String str, Class<?>... clsArr) throws NoSuchMethodException, SecurityException {
        for (Class<?> superclass = obj.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
            try {
                Method declaredMethod = superclass.getDeclaredMethod(str, clsArr);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                return declaredMethod;
            } catch (NoSuchMethodException e10) {
                C1120a.m6676e("AlbumReflectUtil", "findMethod error: " + e10);
            }
        }
        throw new NoSuchMethodException("Method " + str + " with parameters " + Arrays.asList(clsArr) + " not found in " + obj.getClass());
    }
}
