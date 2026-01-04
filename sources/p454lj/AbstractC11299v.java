package p454lj;

import java.util.List;

/* renamed from: lj.v */
/* loaded from: classes5.dex */
public abstract class AbstractC11299v {

    /* renamed from: a */
    public C11279b[] f52950a;

    /* renamed from: b */
    public C11279b[] f52951b;

    public AbstractC11299v(List<C11279b> list) {
        m67852b(list);
    }

    /* renamed from: a */
    public abstract C11279b mo67846a(float f10);

    /* renamed from: b */
    public void m67852b(List<C11279b> list) {
        this.f52950a = new C11279b[list.size()];
        this.f52951b = new C11279b[list.size()];
        list.toArray(this.f52950a);
    }
}
