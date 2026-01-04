package p627s;

import p504o.C11778k;
import p504o.C11781n;
import p504o.InterfaceC11780m;
import p642t.AbstractInterpolatorC12909n;

/* renamed from: s.b */
/* loaded from: classes.dex */
public class C12655b extends AbstractInterpolatorC12909n {

    /* renamed from: a */
    public C11781n f58124a;

    /* renamed from: b */
    public C11778k f58125b;

    /* renamed from: c */
    public InterfaceC11780m f58126c;

    public C12655b() {
        C11781n c11781n = new C11781n();
        this.f58124a = c11781n;
        this.f58126c = c11781n;
    }

    @Override // p642t.AbstractInterpolatorC12909n
    /* renamed from: a */
    public float mo3338a() {
        return this.f58126c.mo70158b();
    }

    /* renamed from: b */
    public void m76185b(float f10, float f11, float f12, float f13, float f14, float f15) {
        C11781n c11781n = this.f58124a;
        this.f58126c = c11781n;
        c11781n.m70163d(f10, f11, f12, f13, f14, f15);
    }

    /* renamed from: c */
    public boolean m76186c() {
        return this.f58126c.mo70157a();
    }

    /* renamed from: d */
    public void m76187d(float f10, float f11, float f12, float f13, float f14, float f15, float f16, int i10) {
        if (this.f58125b == null) {
            this.f58125b = new C11778k();
        }
        C11778k c11778k = this.f58125b;
        this.f58126c = c11778k;
        c11778k.m70160d(f10, f11, f12, f13, f14, f15, f16, i10);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f10) {
        return this.f58126c.getInterpolation(f10);
    }
}
