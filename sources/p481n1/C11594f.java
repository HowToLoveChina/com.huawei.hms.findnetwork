package p481n1;

import com.huawei.hms.network.embedded.C6010m7;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

/* renamed from: n1.f */
/* loaded from: classes.dex */
public class C11594f implements GenericArrayType {

    /* renamed from: a */
    public final Type f53790a;

    public C11594f(Type type) {
        this.f53790a = type;
    }

    public boolean equals(Object obj) {
        if (obj instanceof GenericArrayType) {
            return this.f53790a.equals(((GenericArrayType) obj).getGenericComponentType());
        }
        return false;
    }

    @Override // java.lang.reflect.GenericArrayType
    public Type getGenericComponentType() {
        return this.f53790a;
    }

    public int hashCode() {
        return this.f53790a.hashCode();
    }

    public String toString() {
        Type genericComponentType = getGenericComponentType();
        StringBuilder sb2 = new StringBuilder();
        if (genericComponentType instanceof Class) {
            sb2.append(((Class) genericComponentType).getName());
        } else {
            sb2.append(genericComponentType.toString());
        }
        sb2.append(C6010m7.f27500n);
        return sb2.toString();
    }
}
