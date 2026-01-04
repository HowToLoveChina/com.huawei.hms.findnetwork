package p381j1;

import com.huawei.hms.network.embedded.C6010m7;
import java.io.IOException;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import p244e1.C9378b;
import p323h1.C10077a;
import p323h1.InterfaceC10079c;
import p354i1.InterfaceC10408t;
import p481n1.C11603o;

/* renamed from: j1.s0 */
/* loaded from: classes.dex */
public class C10684s0 implements InterfaceC10686t0, InterfaceC10408t {

    /* renamed from: a */
    public static final C10684s0 f51323a = new C10684s0();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v1, types: [T, byte[]] */
    @Override // p354i1.InterfaceC10408t
    /* renamed from: b */
    public <T> T mo63891b(C10077a c10077a, Type type, Object obj) {
        Class<?> clsM69271P;
        Type type2;
        InterfaceC10079c interfaceC10079c = c10077a.f49153f;
        int iMo62768a0 = interfaceC10079c.mo62768a0();
        Type type3 = null;
        if (iMo62768a0 == 8) {
            interfaceC10079c.mo62756D(16);
            return null;
        }
        if (iMo62768a0 == 4 || iMo62768a0 == 26) {
            ?? r72 = (T) interfaceC10079c.mo62761H();
            interfaceC10079c.mo62756D(16);
            if (r72.length != 0 || type == byte[].class) {
                return r72;
            }
            return null;
        }
        if (type instanceof GenericArrayType) {
            Type genericComponentType = ((GenericArrayType) type).getGenericComponentType();
            if (genericComponentType instanceof TypeVariable) {
                TypeVariable typeVariable = (TypeVariable) genericComponentType;
                Type type4 = c10077a.m62739t().f49226e;
                if (type4 instanceof ParameterizedType) {
                    ParameterizedType parameterizedType = (ParameterizedType) type4;
                    Type rawType = parameterizedType.getRawType();
                    if (rawType instanceof Class) {
                        TypeVariable<Class<T>>[] typeParameters = ((Class) rawType).getTypeParameters();
                        for (int i10 = 0; i10 < typeParameters.length; i10++) {
                            if (typeParameters[i10].getName().equals(typeVariable.getName())) {
                                type3 = parameterizedType.getActualTypeArguments()[i10];
                            }
                        }
                    }
                    if (type3 instanceof Class) {
                        clsM69271P = (Class) type3;
                        type2 = genericComponentType;
                    } else {
                        clsM69271P = Object.class;
                        type2 = genericComponentType;
                    }
                } else {
                    clsM69271P = C11603o.m69271P(typeVariable.getBounds()[0]);
                    type2 = genericComponentType;
                }
            } else {
                clsM69271P = C11603o.m69271P(genericComponentType);
                type2 = genericComponentType;
            }
        } else {
            Class<?> componentType = ((Class) type).getComponentType();
            clsM69271P = componentType;
            type2 = componentType;
        }
        C9378b c9378b = new C9378b();
        c10077a.m62716V(type2, c9378b, obj);
        return (T) m65315f(c10077a, clsM69271P, c9378b);
    }

    @Override // p354i1.InterfaceC10408t
    /* renamed from: c */
    public int mo63892c() {
        return 14;
    }

    @Override // p381j1.InterfaceC10686t0
    /* renamed from: e */
    public final void mo63933e(C10664i0 c10664i0, Object obj, Object obj2, Type type, int i10) throws IOException {
        C10650d1 c10650d1 = c10664i0.f51258k;
        Object[] objArr = (Object[]) obj;
        if (obj == null) {
            c10650d1.m65226c0(EnumC10653e1.WriteNullListAsEmpty);
            return;
        }
        int length = objArr.length;
        int i11 = length - 1;
        if (i11 == -1) {
            c10650d1.append(C6010m7.f27500n);
            return;
        }
        C10696y0 c10696y0 = c10664i0.f51265r;
        c10664i0.m65259D(c10696y0, obj, obj2, 0);
        try {
            c10650d1.append('[');
            if (c10650d1.m65237w(EnumC10653e1.PrettyFormat)) {
                c10664i0.m65278z();
                c10664i0.m65258C();
                for (int i12 = 0; i12 < length; i12++) {
                    if (i12 != 0) {
                        c10650d1.write(44);
                        c10664i0.m65258C();
                    }
                    c10664i0.m65266K(objArr[i12], Integer.valueOf(i12));
                }
                c10664i0.m65271s();
                c10664i0.m65258C();
                c10650d1.write(93);
                c10664i0.f51265r = c10696y0;
                return;
            }
            Class<?> cls = null;
            InterfaceC10686t0 interfaceC10686t0M65276x = null;
            for (int i13 = 0; i13 < i11; i13++) {
                Object obj3 = objArr[i13];
                if (obj3 == null) {
                    c10650d1.append("null,");
                } else {
                    if (c10664i0.m65270r(obj3)) {
                        c10664i0.m65265J(obj3);
                    } else {
                        Class<?> cls2 = obj3.getClass();
                        if (cls2 == cls) {
                            interfaceC10686t0M65276x.mo63933e(c10664i0, obj3, Integer.valueOf(i13), null, 0);
                        } else {
                            interfaceC10686t0M65276x = c10664i0.m65276x(cls2);
                            interfaceC10686t0M65276x.mo63933e(c10664i0, obj3, Integer.valueOf(i13), null, 0);
                            cls = cls2;
                        }
                    }
                    c10650d1.append(',');
                }
            }
            Object obj4 = objArr[i11];
            if (obj4 == null) {
                c10650d1.append("null]");
            } else {
                if (c10664i0.m65270r(obj4)) {
                    c10664i0.m65265J(obj4);
                } else {
                    c10664i0.m65266K(obj4, Integer.valueOf(i11));
                }
                c10650d1.append(']');
            }
            c10664i0.f51265r = c10696y0;
        } catch (Throwable th2) {
            c10664i0.f51265r = c10696y0;
            throw th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0054  */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final <T> T m65315f(p323h1.C10077a r12, java.lang.Class<?> r13, p244e1.C9378b r14) throws java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException {
        /*
            r11 = this;
            r0 = 0
            if (r14 != 0) goto L4
            return r0
        L4:
            int r1 = r14.size()
            java.lang.Object r2 = java.lang.reflect.Array.newInstance(r13, r1)
            r3 = 0
            r4 = r3
        Le:
            if (r4 >= r1) goto L65
            java.lang.Object r5 = r14.get(r4)
            if (r5 != r14) goto L1a
            java.lang.reflect.Array.set(r2, r4, r2)
            goto L62
        L1a:
            boolean r6 = r13.isArray()
            if (r6 == 0) goto L31
            boolean r6 = r13.isInstance(r5)
            if (r6 == 0) goto L27
            goto L2d
        L27:
            e1.b r5 = (p244e1.C9378b) r5
            java.lang.Object r5 = r11.m65315f(r12, r13, r5)
        L2d:
            java.lang.reflect.Array.set(r2, r4, r5)
            goto L62
        L31:
            boolean r6 = r5 instanceof p244e1.C9378b
            if (r6 == 0) goto L54
            r6 = r5
            e1.b r6 = (p244e1.C9378b) r6
            int r7 = r6.size()
            r8 = r3
            r9 = r8
        L3e:
            if (r8 >= r7) goto L4d
            java.lang.Object r10 = r6.get(r8)
            if (r10 != r14) goto L4a
            r6.set(r4, r2)
            r9 = 1
        L4a:
            int r8 = r8 + 1
            goto L3e
        L4d:
            if (r9 == 0) goto L54
            java.lang.Object[] r6 = r6.toArray()
            goto L55
        L54:
            r6 = r0
        L55:
            if (r6 != 0) goto L5f
            h1.i r6 = r12.m62737s()
            java.lang.Object r6 = p481n1.C11603o.m69292f(r5, r13, r6)
        L5f:
            java.lang.reflect.Array.set(r2, r4, r6)
        L62:
            int r4 = r4 + 1
            goto Le
        L65:
            r14.m58785K(r2)
            r14.m58784J(r13)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p381j1.C10684s0.m65315f(h1.a, java.lang.Class, e1.b):java.lang.Object");
    }
}
