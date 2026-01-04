package p481n1;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

/* renamed from: n1.k */
/* loaded from: classes.dex */
public class C11599k implements ParameterizedType {

    /* renamed from: a */
    public final Type[] f53833a;

    /* renamed from: b */
    public final Type f53834b;

    /* renamed from: c */
    public final Type f53835c;

    public C11599k(Type[] typeArr, Type type, Type type2) {
        this.f53833a = typeArr;
        this.f53834b = type;
        this.f53835c = type2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C11599k c11599k = (C11599k) obj;
        if (!Arrays.equals(this.f53833a, c11599k.f53833a)) {
            return false;
        }
        Type type = this.f53834b;
        if (type == null ? c11599k.f53834b != null : !type.equals(c11599k.f53834b)) {
            return false;
        }
        Type type2 = this.f53835c;
        return type2 != null ? type2.equals(c11599k.f53835c) : c11599k.f53835c == null;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type[] getActualTypeArguments() {
        return this.f53833a;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getOwnerType() {
        return this.f53834b;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getRawType() {
        return this.f53835c;
    }

    public int hashCode() {
        Type[] typeArr = this.f53833a;
        int iHashCode = (typeArr != null ? Arrays.hashCode(typeArr) : 0) * 31;
        Type type = this.f53834b;
        int iHashCode2 = (iHashCode + (type != null ? type.hashCode() : 0)) * 31;
        Type type2 = this.f53835c;
        return iHashCode2 + (type2 != null ? type2.hashCode() : 0);
    }
}
