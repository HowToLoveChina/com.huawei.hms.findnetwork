package p454lj;

import android.view.animation.Interpolator;
import p054cj.C1442a;

/* renamed from: lj.w */
/* loaded from: classes5.dex */
public class InterpolatorC11300w implements Interpolator {

    /* renamed from: a */
    public AbstractC11299v f52952a;

    /* renamed from: b */
    public AbstractC11301x f52953b;

    /* renamed from: c */
    public float f52954c;

    /* renamed from: a */
    public void mo67847a() {
        if (this.f52952a == null) {
            C1442a.m8289e("VoucherCurveInterpolator", "mCurve = null");
            return;
        }
        if (this.f52953b == null) {
            this.f52953b = new C11302y();
        }
        this.f52953b.m67856a(this.f52952a);
    }

    /* renamed from: b */
    public void mo67848b(float f10, float f11) {
    }

    /* renamed from: c */
    public void mo67849c(AbstractC11299v abstractC11299v) {
        this.f52952a = abstractC11299v;
    }

    /* renamed from: d */
    public void mo67850d(AbstractC11301x abstractC11301x) {
        this.f52953b = abstractC11301x;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f10) {
        this.f52954c = f10;
        AbstractC11301x abstractC11301x = this.f52953b;
        float fMo67858c = abstractC11301x == null ? f10 : abstractC11301x.mo67858c(f10);
        mo67848b(f10, fMo67858c);
        return fMo67858c;
    }
}
