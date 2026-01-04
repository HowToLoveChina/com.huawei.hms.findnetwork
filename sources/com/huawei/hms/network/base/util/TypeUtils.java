package com.huawei.hms.network.base.util;

import com.huawei.hms.network.embedded.C6010m7;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.NoSuchElementException;

/* loaded from: classes8.dex */
public class TypeUtils {

    /* renamed from: a */
    static final Type[] f26236a = new Type[0];

    /* renamed from: b */
    private static final int f26237b = 1;

    public static final class GenericArrayTypeImpl implements GenericArrayType {

        /* renamed from: a */
        private final Type f26238a;

        public GenericArrayTypeImpl(Type type) {
            this.f26238a = type;
        }

        public boolean equals(Object obj) {
            return (obj instanceof GenericArrayType) && TypeUtils.m33667b(this, (GenericArrayType) obj);
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.f26238a;
        }

        public int hashCode() {
            return this.f26238a.hashCode();
        }

        public String toString() {
            return TypeUtils.m33671d(this.f26238a) + C6010m7.f27500n;
        }
    }

    public static final class ParameterizedTypeImpl implements ParameterizedType {

        /* renamed from: a */
        private final Type f26239a;

        /* renamed from: b */
        private final Type f26240b;

        /* renamed from: c */
        private final Type[] f26241c;

        public ParameterizedTypeImpl(Type type, Type type2, Type... typeArr) {
            if (type2 instanceof Class) {
                if ((((Class) type2).getEnclosingClass() == null) != (type == null)) {
                    throw new IllegalArgumentException();
                }
            }
            for (Type type3 : typeArr) {
                if (type3 == null) {
                    throw new NullPointerException("typeArgument == null");
                }
                TypeUtils.m33669c(type3);
            }
            this.f26239a = type2;
            this.f26240b = type;
            this.f26241c = (Type[]) typeArr.clone();
        }

        public boolean equals(Object obj) {
            return (obj instanceof ParameterizedType) && TypeUtils.m33667b(this, (ParameterizedType) obj);
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return (Type[]) this.f26241c.clone();
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return this.f26240b;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.f26239a;
        }

        public int hashCode() {
            int iHashCode = Arrays.hashCode(this.f26241c) ^ this.f26239a.hashCode();
            Type type = this.f26240b;
            return (type != null ? type.hashCode() : 0) ^ iHashCode;
        }

        public String toString() {
            Type[] typeArr = this.f26241c;
            if (typeArr.length == 0) {
                return TypeUtils.m33671d(this.f26239a);
            }
            StringBuffer stringBuffer = new StringBuffer((typeArr.length + 1) * 30);
            stringBuffer.append(TypeUtils.m33671d(this.f26239a));
            stringBuffer.append("<");
            stringBuffer.append(TypeUtils.m33671d(this.f26241c[0]));
            for (int i10 = 1; i10 < this.f26241c.length; i10++) {
                stringBuffer.append(", ");
                stringBuffer.append(TypeUtils.m33671d(this.f26241c[i10]));
            }
            stringBuffer.append(">");
            return stringBuffer.toString();
        }
    }

    public static final class WildcardTypeImpl implements WildcardType {

        /* renamed from: a */
        private final Type f26242a;

        /* renamed from: b */
        private final Type f26243b;

        public WildcardTypeImpl(Type[] typeArr, Type[] typeArr2) {
            if (typeArr2.length > 1 || typeArr.length != 1) {
                throw new IllegalArgumentException();
            }
            if (typeArr2.length != 1) {
                typeArr[0].getClass();
                TypeUtils.m33669c(typeArr[0]);
                this.f26243b = null;
                this.f26242a = typeArr[0];
                return;
            }
            typeArr2[0].getClass();
            TypeUtils.m33669c(typeArr2[0]);
            if (typeArr[0] != Object.class) {
                throw new IllegalArgumentException();
            }
            this.f26243b = typeArr2[0];
            this.f26242a = Object.class;
        }

        public boolean equals(Object obj) {
            return (obj instanceof WildcardType) && TypeUtils.m33667b(this, (WildcardType) obj);
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            Type type = this.f26243b;
            return type != null ? new Type[]{type} : TypeUtils.f26236a;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return new Type[]{this.f26242a};
        }

        public int hashCode() {
            Type type = this.f26243b;
            return (this.f26242a.hashCode() + 31) ^ (type != null ? type.hashCode() + 31 : 1);
        }

        public String toString() {
            StringBuilder sb2;
            Type type;
            if (this.f26243b != null) {
                sb2 = new StringBuilder();
                sb2.append("? super ");
                type = this.f26243b;
            } else {
                if (this.f26242a == Object.class) {
                    return Constants.QUESTION_STR;
                }
                sb2 = new StringBuilder();
                sb2.append("? extends ");
                type = this.f26242a;
            }
            sb2.append(TypeUtils.m33671d(type));
            return sb2.toString();
        }
    }

    /* renamed from: a */
    private static int m33659a(Object[] objArr, Object obj) {
        for (int i10 = 0; i10 < objArr.length; i10++) {
            if (obj.equals(objArr[i10])) {
                return i10;
            }
        }
        throw new NoSuchElementException();
    }

    public static Class<?> boxIfPrimitive(Class<?> cls) {
        return Boolean.TYPE == cls ? Boolean.class : Byte.TYPE == cls ? Byte.class : Character.TYPE == cls ? Character.class : Double.TYPE == cls ? Double.class : Float.TYPE == cls ? Float.class : Integer.TYPE == cls ? Integer.class : Long.TYPE == cls ? Long.class : Short.TYPE == cls ? Short.class : cls;
    }

    /* renamed from: c */
    private static Type m33668c(Type type, Class<?> cls, Type type2) {
        Type typeM33661a;
        WildcardType wildcardType = (WildcardType) type2;
        Type[] lowerBounds = wildcardType.getLowerBounds();
        Type[] upperBounds = wildcardType.getUpperBounds();
        if (lowerBounds.length == 1) {
            Type typeM33661a2 = m33661a(type, cls, lowerBounds[0]);
            if (lowerBounds[0] != typeM33661a2) {
                return new WildcardTypeImpl(new Type[]{Object.class}, new Type[]{typeM33661a2});
            }
        } else if (upperBounds.length == 1 && upperBounds[0] != (typeM33661a = m33661a(type, cls, upperBounds[0]))) {
            return new WildcardTypeImpl(new Type[]{typeM33661a}, f26236a);
        }
        return wildcardType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static String m33671d(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    public static Type getParameterUpperBound(int i10, ParameterizedType parameterizedType) {
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        if (i10 < actualTypeArguments.length && i10 >= 0) {
            Type type = actualTypeArguments[i10];
            return type instanceof WildcardType ? ((WildcardType) type).getUpperBounds()[0] : type;
        }
        throw new IllegalArgumentException("Index " + i10 + " not in range [0," + actualTypeArguments.length + ") for " + parameterizedType);
    }

    public static Class<?> getRawType(Type type) {
        if (type == null) {
            throw new NullPointerException("type == null");
        }
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            if (rawType instanceof Class) {
                return (Class) rawType;
            }
            throw new IllegalArgumentException();
        }
        if (type instanceof GenericArrayType) {
            return Array.newInstance(getRawType(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
        }
        if (type instanceof TypeVariable) {
            return Object.class;
        }
        if (type instanceof WildcardType) {
            return getRawType(((WildcardType) type).getUpperBounds()[0]);
        }
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + type.getClass().getName());
    }

    public static Type getSubmitResponseType(Type type) {
        if (type instanceof ParameterizedType) {
            return getParameterUpperBound(0, (ParameterizedType) type);
        }
        throw new IllegalArgumentException("Submit return type must be parameterized as Submit<Foo> or Submit<? extends Foo>");
    }

    public static Type getSupertype(Type type, Class<?> cls, Class<?> cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return m33661a(type, cls, m33660a(type, cls, cls2));
        }
        throw new IllegalArgumentException();
    }

    public static boolean hasUnresolvableType(Type type) {
        if (type instanceof Class) {
            return false;
        }
        if (type instanceof ParameterizedType) {
            for (Type type2 : ((ParameterizedType) type).getActualTypeArguments()) {
                if (hasUnresolvableType(type2)) {
                    return true;
                }
            }
            return false;
        }
        if (type instanceof GenericArrayType) {
            return hasUnresolvableType(((GenericArrayType) type).getGenericComponentType());
        }
        if ((type instanceof TypeVariable) || (type instanceof WildcardType)) {
            return true;
        }
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + (type == null ? "null" : type.getClass().getName()));
    }

    /* renamed from: a */
    public static Type m33660a(Type type, Class<?> cls, Class<?> cls2) {
        if (cls2 == cls) {
            return type;
        }
        if (cls2.isInterface()) {
            Class<?>[] interfaces = cls.getInterfaces();
            int length = interfaces.length;
            for (int i10 = 0; i10 < length; i10++) {
                Class<?> cls3 = interfaces[i10];
                if (cls3 == cls2) {
                    return cls.getGenericInterfaces()[i10];
                }
                if (cls2.isAssignableFrom(cls3)) {
                    return m33660a(cls.getGenericInterfaces()[i10], interfaces[i10], cls2);
                }
            }
        }
        if (!cls.isInterface()) {
            while (cls != Object.class) {
                Class<? super Object> superclass = cls.getSuperclass();
                if (superclass == cls2) {
                    return cls.getGenericSuperclass();
                }
                if (cls2.isAssignableFrom(superclass)) {
                    return m33660a(cls.getGenericSuperclass(), (Class<?>) superclass, cls2);
                }
                cls = superclass;
            }
        }
        return cls2;
    }

    /* renamed from: b */
    private static Type m33666b(Type type, Class<?> cls, Type type2) {
        ParameterizedType parameterizedType = (ParameterizedType) type2;
        Type ownerType = parameterizedType.getOwnerType();
        Type typeM33661a = m33661a(type, cls, ownerType);
        boolean z10 = typeM33661a != ownerType;
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        int length = actualTypeArguments.length;
        for (int i10 = 0; i10 < length; i10++) {
            Type typeM33661a2 = m33661a(type, cls, actualTypeArguments[i10]);
            if (typeM33661a2 != actualTypeArguments[i10]) {
                if (!z10) {
                    actualTypeArguments = (Type[]) actualTypeArguments.clone();
                    z10 = true;
                }
                actualTypeArguments[i10] = typeM33661a2;
            }
        }
        return z10 ? new ParameterizedTypeImpl(typeM33661a, parameterizedType.getRawType(), actualTypeArguments) : parameterizedType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static void m33669c(Type type) {
        if ((type instanceof Class) && ((Class) type).isPrimitive()) {
            throw new IllegalArgumentException();
        }
    }

    /* renamed from: a */
    private static Type m33661a(Type type, Class<?> cls, Type type2) {
        if (type2 instanceof TypeVariable) {
            TypeVariable typeVariable = (TypeVariable) type2;
            Type typeM33662a = m33662a(type, cls, (TypeVariable<?>) typeVariable);
            return typeM33662a == typeVariable ? type2 : m33661a(type, cls, typeM33662a);
        }
        if (type2 instanceof Class) {
            Class cls2 = (Class) type2;
            if (cls2.isArray()) {
                Class<?> componentType = cls2.getComponentType();
                if (componentType == null) {
                    return type2;
                }
                Type typeM33661a = m33661a(type, cls, (Type) componentType);
                return typeM33661a == componentType ? cls2 : new GenericArrayTypeImpl(typeM33661a);
            }
        }
        if (!(type2 instanceof GenericArrayType)) {
            return type2 instanceof ParameterizedType ? m33666b(type, cls, type2) : type2 instanceof WildcardType ? m33668c(type, cls, type2) : type2;
        }
        GenericArrayType genericArrayType = (GenericArrayType) type2;
        Type genericComponentType = genericArrayType.getGenericComponentType();
        Type typeM33661a2 = m33661a(type, cls, genericComponentType);
        return typeM33661a2 == genericComponentType ? genericArrayType : new GenericArrayTypeImpl(typeM33661a2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static boolean m33667b(Type type, Type type2) {
        if (type == type2) {
            return true;
        }
        return type instanceof Class ? type.equals(type2) : m33670c(type, type2);
    }

    /* renamed from: c */
    private static boolean m33670c(Type type, Type type2) {
        if (type instanceof ParameterizedType) {
            if (!(type2 instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            ParameterizedType parameterizedType2 = (ParameterizedType) type2;
            return m33667b(parameterizedType.getOwnerType(), parameterizedType2.getOwnerType()) && m33667b(parameterizedType.getRawType(), parameterizedType2.getRawType()) && Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments());
        }
        if (type instanceof GenericArrayType) {
            if (type2 instanceof GenericArrayType) {
                return m33667b(((GenericArrayType) type).getGenericComponentType(), ((GenericArrayType) type2).getGenericComponentType());
            }
            return false;
        }
        if (type instanceof WildcardType) {
            if (!(type2 instanceof WildcardType)) {
                return false;
            }
            WildcardType wildcardType = (WildcardType) type2;
            WildcardType wildcardType2 = (WildcardType) type;
            return Arrays.equals(wildcardType2.getUpperBounds(), wildcardType.getUpperBounds()) && Arrays.equals(wildcardType2.getLowerBounds(), wildcardType.getLowerBounds());
        }
        if (!(type instanceof TypeVariable) || !(type2 instanceof TypeVariable)) {
            return false;
        }
        TypeVariable typeVariable = (TypeVariable) type;
        TypeVariable typeVariable2 = (TypeVariable) type2;
        return typeVariable.getGenericDeclaration() == typeVariable2.getGenericDeclaration() && typeVariable.getName().equals(typeVariable2.getName());
    }

    /* renamed from: a */
    private static Type m33662a(Type type, Class<?> cls, TypeVariable<?> typeVariable) {
        GenericDeclaration genericDeclaration = typeVariable.getGenericDeclaration();
        Class cls2 = genericDeclaration instanceof Class ? (Class) genericDeclaration : null;
        if (cls2 == null) {
            return typeVariable;
        }
        Type typeM33660a = m33660a(type, cls, (Class<?>) cls2);
        if (typeM33660a instanceof ParameterizedType) {
            return ((ParameterizedType) typeM33660a).getActualTypeArguments()[m33659a(cls2.getTypeParameters(), typeVariable)];
        }
        return typeVariable;
    }
}
