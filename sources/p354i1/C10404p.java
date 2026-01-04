package p354i1;

import java.io.Closeable;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import p323h1.C10077a;
import p481n1.C11603o;

/* renamed from: i1.p */
/* loaded from: classes.dex */
public class C10404p implements InterfaceC10408t {

    /* renamed from: a */
    public static final C10404p f50211a = new C10404p();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p354i1.InterfaceC10408t
    /* renamed from: b */
    public <T> T mo63891b(C10077a c10077a, Type type, Object obj) {
        if (!(type instanceof GenericArrayType)) {
            return (!(type instanceof Class) || type == Object.class || type == Serializable.class || type == Cloneable.class || type == Closeable.class || type == Comparable.class) ? (T) c10077a.m62714I(obj) : (T) c10077a.m62722c0(type);
        }
        Type genericComponentType = ((GenericArrayType) type).getGenericComponentType();
        if (genericComponentType instanceof TypeVariable) {
            genericComponentType = ((TypeVariable) genericComponentType).getBounds()[0];
        }
        ArrayList arrayList = new ArrayList();
        c10077a.m62715J(genericComponentType, arrayList);
        T t10 = (T) ((Object[]) Array.newInstance(C11603o.m69297h0(genericComponentType), arrayList.size()));
        arrayList.toArray((Object[]) t10);
        return t10;
    }

    @Override // p354i1.InterfaceC10408t
    /* renamed from: c */
    public int mo63892c() {
        return 12;
    }
}
