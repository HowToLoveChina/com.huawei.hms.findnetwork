package p354i1;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import p244e1.C9378b;
import p323h1.C10077a;
import p481n1.C11603o;

/* renamed from: i1.y */
/* loaded from: classes.dex */
public final class C10413y extends AbstractC10400l {

    /* renamed from: c */
    public final int f50237c;

    /* renamed from: d */
    public final List f50238d;

    /* renamed from: e */
    public final C10077a f50239e;

    /* renamed from: f */
    public final Object f50240f;

    /* renamed from: g */
    public final Map f50241g;

    /* renamed from: h */
    public final Collection f50242h;

    public C10413y(C10077a c10077a, List list, int i10) {
        super(null, null);
        this.f50239e = c10077a;
        this.f50237c = i10;
        this.f50238d = list;
        this.f50240f = null;
        this.f50241g = null;
        this.f50242h = null;
    }

    @Override // p354i1.AbstractC10400l
    /* renamed from: d */
    public void mo63897d(C10077a c10077a, Object obj, Type type, Map<String, Object> map) {
    }

    @Override // p354i1.AbstractC10400l
    /* renamed from: h */
    public void mo63911h(Object obj, Object obj2) throws ArrayIndexOutOfBoundsException, IllegalArgumentException {
        C9378b c9378b;
        Object objM58783H;
        Map map = this.f50241g;
        if (map != null) {
            map.put(this.f50240f, obj2);
            return;
        }
        Collection collection = this.f50242h;
        if (collection != null) {
            collection.add(obj2);
            return;
        }
        this.f50238d.set(this.f50237c, obj2);
        List list = this.f50238d;
        if (!(list instanceof C9378b) || (objM58783H = (c9378b = (C9378b) list).m58783H()) == null || Array.getLength(objM58783H) <= this.f50237c) {
            return;
        }
        if (c9378b.m58780E() != null) {
            obj2 = C11603o.m69296h(obj2, c9378b.m58780E(), this.f50239e.m62737s());
        }
        Array.set(objM58783H, this.f50237c, obj2);
    }

    public C10413y(Collection collection) {
        super(null, null);
        this.f50239e = null;
        this.f50237c = -1;
        this.f50238d = null;
        this.f50240f = null;
        this.f50241g = null;
        this.f50242h = collection;
    }

    public C10413y(Map map, Object obj) {
        super(null, null);
        this.f50239e = null;
        this.f50237c = -1;
        this.f50238d = null;
        this.f50240f = obj;
        this.f50241g = map;
        this.f50242h = null;
    }
}
