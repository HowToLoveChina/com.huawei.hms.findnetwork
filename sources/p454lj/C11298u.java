package p454lj;

import java.util.ArrayList;
import java.util.List;

/* renamed from: lj.u */
/* loaded from: classes5.dex */
public class C11298u extends InterpolatorC11300w {
    public C11298u(float f10, float f11, float f12, float f13) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new C11279b(0.0f, 0.0f));
        arrayList.add(new C11279b(f10, f11));
        arrayList.add(new C11279b(f12, f13));
        arrayList.add(new C11279b(1.0f, 1.0f));
        m67851e(arrayList);
    }

    @Override // p454lj.InterpolatorC11300w
    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo67847a() {
        super.mo67847a();
    }

    @Override // p454lj.InterpolatorC11300w
    /* renamed from: b */
    public /* bridge */ /* synthetic */ void mo67848b(float f10, float f11) {
        super.mo67848b(f10, f11);
    }

    @Override // p454lj.InterpolatorC11300w
    /* renamed from: c */
    public /* bridge */ /* synthetic */ void mo67849c(AbstractC11299v abstractC11299v) {
        super.mo67849c(abstractC11299v);
    }

    @Override // p454lj.InterpolatorC11300w
    /* renamed from: d */
    public /* bridge */ /* synthetic */ void mo67850d(AbstractC11301x abstractC11301x) {
        super.mo67850d(abstractC11301x);
    }

    /* renamed from: e */
    public final void m67851e(List<C11279b> list) {
        mo67849c(new C11297t(list));
        mo67850d(new C11302y());
        mo67847a();
    }

    @Override // p454lj.InterpolatorC11300w, android.animation.TimeInterpolator
    public /* bridge */ /* synthetic */ float getInterpolation(float f10) {
        return super.getInterpolation(f10);
    }
}
