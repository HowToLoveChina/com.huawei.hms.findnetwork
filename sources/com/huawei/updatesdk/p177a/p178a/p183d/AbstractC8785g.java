package com.huawei.updatesdk.p177a.p178a.p183d;

import com.huawei.updatesdk.p177a.p178a.p180c.p181a.p182a.C8777a;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.updatesdk.a.a.d.g */
/* loaded from: classes9.dex */
public abstract class AbstractC8785g {

    /* renamed from: a */
    private static final String f45078a = "g";

    /* renamed from: a */
    public static Class m56060a(Field field) {
        int i10;
        if (Map.class.isAssignableFrom(field.getType())) {
            i10 = 1;
        } else {
            if (!List.class.isAssignableFrom(field.getType())) {
                return null;
            }
            i10 = 0;
        }
        return m56061a(field, i10);
    }

    /* renamed from: a */
    private static Class m56061a(Field field, int i10) {
        Type[] actualTypeArguments;
        Type genericType = field.getGenericType();
        if (!(genericType instanceof ParameterizedType) || (actualTypeArguments = ((ParameterizedType) genericType).getActualTypeArguments()) == null || actualTypeArguments.length <= i10) {
            return null;
        }
        return m56062a(actualTypeArguments, i10);
    }

    /* renamed from: a */
    private static Class m56062a(Type[] typeArr, int i10) {
        try {
            Type type = typeArr[i10];
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
        } catch (ClassNotFoundException e10) {
            C8777a.m56028b(f45078a, "getType exception!" + e10.getMessage());
            return null;
        }
    }

    /* renamed from: a */
    public static Field[] m56063a(Class cls) {
        Field[] fieldArrM56063a = cls.getSuperclass() != null ? m56063a(cls.getSuperclass()) : null;
        Field[] declaredFields = cls.getDeclaredFields();
        if (fieldArrM56063a != null && fieldArrM56063a.length > 0) {
            Field[] fieldArr = new Field[declaredFields.length + fieldArrM56063a.length];
            System.arraycopy(fieldArrM56063a, 0, fieldArr, 0, fieldArrM56063a.length);
            System.arraycopy(declaredFields, 0, fieldArr, fieldArrM56063a.length, declaredFields.length);
            declaredFields = fieldArr;
        }
        ArrayList arrayList = new ArrayList();
        for (Field field : declaredFields) {
            if (!field.getName().contains("$")) {
                arrayList.add(field);
            }
        }
        if (arrayList.size() == declaredFields.length) {
            return declaredFields;
        }
        Field[] fieldArr2 = new Field[arrayList.size()];
        arrayList.toArray(fieldArr2);
        return fieldArr2;
    }
}
