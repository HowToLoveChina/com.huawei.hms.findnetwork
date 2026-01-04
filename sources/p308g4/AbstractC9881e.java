package p308g4;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import p405jt.AbstractC10915a;

/* renamed from: g4.e */
/* loaded from: classes.dex */
public abstract class AbstractC9881e {
    /* renamed from: a */
    public static Class m61329a(Field field) {
        int i10;
        if (Map.class.isAssignableFrom(field.getType())) {
            i10 = 1;
        } else {
            if (!List.class.isAssignableFrom(field.getType())) {
                return null;
            }
            i10 = 0;
        }
        return m61330b(field, i10);
    }

    /* renamed from: b */
    public static Class m61330b(Field field, int i10) {
        Type[] actualTypeArguments;
        String str;
        Type genericType = field.getGenericType();
        if ((genericType instanceof ParameterizedType) && (actualTypeArguments = ((ParameterizedType) genericType).getActualTypeArguments()) != null && actualTypeArguments.length > i10) {
            try {
                Type type = actualTypeArguments[i10];
                if (type instanceof Class) {
                    return (Class) type;
                }
                String string = type.toString();
                int iIndexOf = string.indexOf("class ");
                if (iIndexOf < 0) {
                    iIndexOf = 0;
                }
                int iIndexOf2 = string.indexOf("<");
                if (iIndexOf2 < 0) {
                    iIndexOf2 = string.length();
                }
                return Class.forName(string.substring(iIndexOf, iIndexOf2));
            } catch (ClassNotFoundException unused) {
                str = "getType ClassNotFoundException";
                AbstractC10915a.m65978j("ReflectAPI", str);
                return null;
            } catch (Exception unused2) {
                str = "getType Exception";
                AbstractC10915a.m65978j("ReflectAPI", str);
                return null;
            }
        }
        return null;
    }

    /* renamed from: c */
    public static Field m61331c(Field field, boolean z10) {
        field.setAccessible(z10);
        return field;
    }

    /* renamed from: d */
    public static Field[] m61332d(Class cls) {
        Field[] fieldArrM61332d = cls.getSuperclass() != null ? m61332d(cls.getSuperclass()) : null;
        Field[] declaredFields = cls.getDeclaredFields();
        if (fieldArrM61332d == null || fieldArrM61332d.length <= 0) {
            return declaredFields;
        }
        Field[] fieldArr = new Field[declaredFields.length + fieldArrM61332d.length];
        System.arraycopy(fieldArrM61332d, 0, fieldArr, 0, fieldArrM61332d.length);
        System.arraycopy(declaredFields, 0, fieldArr, fieldArrM61332d.length, declaredFields.length);
        return fieldArr;
    }
}
