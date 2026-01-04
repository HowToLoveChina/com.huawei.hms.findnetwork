package p708vh;

import com.huawei.secure.android.common.util.SafeString;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import th.C13012a;

/* renamed from: vh.a */
/* loaded from: classes4.dex */
public abstract class AbstractC13445a {
    /* renamed from: a */
    public static Class m80774a(Field field) {
        int i10;
        if (Map.class.isAssignableFrom(field.getType())) {
            i10 = 1;
        } else {
            if (!List.class.isAssignableFrom(field.getType())) {
                return null;
            }
            i10 = 0;
        }
        return m80775b(field, i10);
    }

    /* renamed from: b */
    public static Class m80775b(Field field, int i10) {
        Type[] actualTypeArguments;
        Type type;
        Type genericType = field.getGenericType();
        if (!(genericType instanceof ParameterizedType) || (actualTypeArguments = ((ParameterizedType) genericType).getActualTypeArguments()) == null || actualTypeArguments.length <= i10 || (type = actualTypeArguments[i10]) == null) {
            return null;
        }
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
        try {
            return Class.forName(SafeString.substring(string, iIndexOf, iIndexOf2));
        } catch (ClassNotFoundException unused) {
            C13012a.m78317c("ReflectAPI", "CLASS for name error!");
            return null;
        }
    }

    /* renamed from: c */
    public static Field[] m80776c(Class cls) {
        Field[] fieldArrM80776c = cls.getSuperclass() != null ? m80776c(cls.getSuperclass()) : null;
        Field[] declaredFields = cls.getDeclaredFields();
        if (fieldArrM80776c == null || fieldArrM80776c.length <= 0) {
            return declaredFields;
        }
        Field[] fieldArr = new Field[declaredFields.length + fieldArrM80776c.length];
        System.arraycopy(fieldArrM80776c, 0, fieldArr, 0, fieldArrM80776c.length);
        System.arraycopy(declaredFields, 0, fieldArr, fieldArrM80776c.length, declaredFields.length);
        return fieldArr;
    }
}
