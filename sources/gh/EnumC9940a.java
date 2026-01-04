package gh;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcelable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: gh.a */
/* loaded from: classes4.dex */
public enum EnumC9940a {
    PARCELABLE,
    BINDER,
    STRING_LIST,
    LIST,
    BUNDLE,
    PARCELABLE_ARRAY,
    STRING_ARRAY,
    BYTE_ARRAY,
    INTERFACE,
    INT_ARRAY,
    INTEGER,
    LONG,
    BOOLEAN,
    FLOAT,
    DOUBLE,
    STRING,
    HASH_MAP;

    /* renamed from: gh.a$a */
    public static class a extends RuntimeException {
        public a(String str) {
            super(str);
        }
    }

    /* renamed from: b */
    public static EnumC9940a m61603b(Class cls) {
        if (cls.isArray() && Parcelable.class.isAssignableFrom(cls.getComponentType())) {
            return PARCELABLE_ARRAY;
        }
        if (cls.isArray() && String.class.isAssignableFrom(cls.getComponentType())) {
            return STRING_ARRAY;
        }
        if (cls.isArray() && Byte.TYPE.isAssignableFrom(cls.getComponentType())) {
            return BYTE_ARRAY;
        }
        if (cls.isArray() && Integer.TYPE.isAssignableFrom(cls.getComponentType())) {
            return INT_ARRAY;
        }
        return null;
    }

    /* renamed from: e */
    public static EnumC9940a m61604e(Field field) {
        Class<?> type = field.getType();
        EnumC9940a enumC9940aM61606h = m61606h(type);
        if (enumC9940aM61606h != null) {
            return enumC9940aM61606h;
        }
        EnumC9940a enumC9940aM61603b = m61603b(type);
        if (enumC9940aM61603b != null) {
            return enumC9940aM61603b;
        }
        if (HashMap.class.isAssignableFrom(type)) {
            return HASH_MAP;
        }
        if (Bundle.class.isAssignableFrom(type)) {
            return BUNDLE;
        }
        if (Parcelable.class.isAssignableFrom(type)) {
            return PARCELABLE;
        }
        if (IBinder.class.isAssignableFrom(type)) {
            return BINDER;
        }
        if (IInterface.class.isAssignableFrom(type)) {
            return INTERFACE;
        }
        EnumC9940a enumC9940aM61605f = m61605f(field, type);
        if (enumC9940aM61605f != null) {
            return enumC9940aM61605f;
        }
        throw new a("Type is not yet usable with ParcelUtil: " + type);
    }

    /* renamed from: f */
    public static EnumC9940a m61605f(Field field, Class cls) {
        if (cls != List.class && cls != ArrayList.class) {
            return null;
        }
        Type genericType = field.getGenericType();
        if (genericType instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) genericType;
            if (parameterizedType.getActualTypeArguments().length == 1 && parameterizedType.getActualTypeArguments()[0] == String.class) {
                return STRING_LIST;
            }
        }
        return LIST;
    }

    /* renamed from: h */
    public static EnumC9940a m61606h(Class cls) {
        if (cls == Integer.TYPE || cls == Integer.class) {
            return INTEGER;
        }
        if (cls == Boolean.TYPE || cls == Boolean.class) {
            return BOOLEAN;
        }
        if (cls == Long.TYPE || cls == Long.class) {
            return LONG;
        }
        if (cls == Float.TYPE || cls == Float.class) {
            return FLOAT;
        }
        if (cls == Double.TYPE || cls == Double.class) {
            return DOUBLE;
        }
        if (cls == String.class) {
            return STRING;
        }
        return null;
    }
}
