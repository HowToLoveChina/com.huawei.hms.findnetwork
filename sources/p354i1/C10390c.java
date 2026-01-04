package p354i1;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Map;
import p323h1.C10077a;
import p323h1.C10084h;
import p323h1.C10085i;
import p323h1.InterfaceC10079c;
import p481n1.C11592d;

/* renamed from: i1.c */
/* loaded from: classes.dex */
public class C10390c extends AbstractC10400l {

    /* renamed from: c */
    public final Type f50186c;

    /* renamed from: d */
    public int f50187d;

    /* renamed from: e */
    public InterfaceC10408t f50188e;

    public C10390c(C10085i c10085i, Class<?> cls, C11592d c11592d) {
        super(cls, c11592d);
        Type type = c11592d.f53773f;
        if (!(type instanceof ParameterizedType)) {
            this.f50186c = Object.class;
            return;
        }
        Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
        if (type2 instanceof WildcardType) {
            Type[] upperBounds = ((WildcardType) type2).getUpperBounds();
            if (upperBounds.length == 1) {
                type2 = upperBounds[0];
            }
        }
        this.f50186c = type2;
    }

    @Override // p354i1.AbstractC10400l
    /* renamed from: b */
    public int mo63896b() {
        return 14;
    }

    @Override // p354i1.AbstractC10400l
    /* renamed from: d */
    public void mo63897d(C10077a c10077a, Object obj, Type type, Map<String, Object> map) {
        InterfaceC10079c interfaceC10079c = c10077a.f49153f;
        int iMo62768a0 = interfaceC10079c.mo62768a0();
        if (iMo62768a0 == 8 || (iMo62768a0 == 4 && interfaceC10079c.mo62763J().length() == 0)) {
            if (obj == null) {
                map.put(this.f50198a.f53768a, null);
                return;
            } else {
                m63912i(obj, null);
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        C10084h c10084hM62739t = c10077a.m62739t();
        c10077a.m62735q0(c10084hM62739t, obj, this.f50198a.f53768a);
        m63898k(c10077a, type, arrayList);
        c10077a.m62738s0(c10084hM62739t);
        if (obj == null) {
            map.put(this.f50198a.f53768a, arrayList);
        } else {
            mo63911h(obj, arrayList);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ac  */
    /* renamed from: k */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m63898k(p323h1.C10077a r13, java.lang.reflect.Type r14, java.util.Collection r15) {
        /*
            Method dump skipped, instructions count: 401
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p354i1.C10390c.m63898k(h1.a, java.lang.reflect.Type, java.util.Collection):void");
    }
}
