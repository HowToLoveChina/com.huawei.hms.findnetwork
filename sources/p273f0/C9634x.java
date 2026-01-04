package p273f0;

import android.view.View;
import android.view.ViewParent;

/* renamed from: f0.x */
/* loaded from: classes.dex */
public class C9634x {

    /* renamed from: a */
    public ViewParent f47765a;

    /* renamed from: b */
    public ViewParent f47766b;

    /* renamed from: c */
    public final View f47767c;

    /* renamed from: d */
    public boolean f47768d;

    /* renamed from: e */
    public int[] f47769e;

    public C9634x(View view) {
        this.f47767c = view;
    }

    /* renamed from: a */
    public boolean m60232a(float f10, float f11, boolean z10) {
        ViewParent viewParentM60240i;
        if (!m60244m() || (viewParentM60240i = m60240i(0)) == null) {
            return false;
        }
        return C9611l0.m60085a(viewParentM60240i, this.f47767c, f10, f11, z10);
    }

    /* renamed from: b */
    public boolean m60233b(float f10, float f11) {
        ViewParent viewParentM60240i;
        if (!m60244m() || (viewParentM60240i = m60240i(0)) == null) {
            return false;
        }
        return C9611l0.m60086b(viewParentM60240i, this.f47767c, f10, f11);
    }

    /* renamed from: c */
    public boolean m60234c(int i10, int i11, int[] iArr, int[] iArr2) {
        return m60235d(i10, i11, iArr, iArr2, 0);
    }

    /* renamed from: d */
    public boolean m60235d(int i10, int i11, int[] iArr, int[] iArr2, int i12) {
        ViewParent viewParentM60240i;
        int i13;
        int i14;
        if (!m60244m() || (viewParentM60240i = m60240i(i12)) == null) {
            return false;
        }
        if (i10 == 0 && i11 == 0) {
            if (iArr2 == null) {
                return false;
            }
            iArr2[0] = 0;
            iArr2[1] = 0;
            return false;
        }
        if (iArr2 != null) {
            this.f47767c.getLocationInWindow(iArr2);
            i13 = iArr2[0];
            i14 = iArr2[1];
        } else {
            i13 = 0;
            i14 = 0;
        }
        if (iArr == null) {
            iArr = m60241j();
        }
        iArr[0] = 0;
        iArr[1] = 0;
        C9611l0.m60087c(viewParentM60240i, this.f47767c, i10, i11, iArr, i12);
        if (iArr2 != null) {
            this.f47767c.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i13;
            iArr2[1] = iArr2[1] - i14;
        }
        return (iArr[0] == 0 && iArr[1] == 0) ? false : true;
    }

    /* renamed from: e */
    public void m60236e(int i10, int i11, int i12, int i13, int[] iArr, int i14, int[] iArr2) {
        m60239h(i10, i11, i12, i13, iArr, i14, iArr2);
    }

    /* renamed from: f */
    public boolean m60237f(int i10, int i11, int i12, int i13, int[] iArr) {
        return m60239h(i10, i11, i12, i13, iArr, 0, null);
    }

    /* renamed from: g */
    public boolean m60238g(int i10, int i11, int i12, int i13, int[] iArr, int i14) {
        return m60239h(i10, i11, i12, i13, iArr, i14, null);
    }

    /* renamed from: h */
    public final boolean m60239h(int i10, int i11, int i12, int i13, int[] iArr, int i14, int[] iArr2) {
        ViewParent viewParentM60240i;
        int i15;
        int i16;
        int[] iArr3;
        if (!m60244m() || (viewParentM60240i = m60240i(i14)) == null) {
            return false;
        }
        if (i10 == 0 && i11 == 0 && i12 == 0 && i13 == 0) {
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
            }
            return false;
        }
        if (iArr != null) {
            this.f47767c.getLocationInWindow(iArr);
            i15 = iArr[0];
            i16 = iArr[1];
        } else {
            i15 = 0;
            i16 = 0;
        }
        if (iArr2 == null) {
            int[] iArrM60241j = m60241j();
            iArrM60241j[0] = 0;
            iArrM60241j[1] = 0;
            iArr3 = iArrM60241j;
        } else {
            iArr3 = iArr2;
        }
        C9611l0.m60088d(viewParentM60240i, this.f47767c, i10, i11, i12, i13, i14, iArr3);
        if (iArr != null) {
            this.f47767c.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i15;
            iArr[1] = iArr[1] - i16;
        }
        return true;
    }

    /* renamed from: i */
    public final ViewParent m60240i(int i10) {
        if (i10 == 0) {
            return this.f47765a;
        }
        if (i10 != 1) {
            return null;
        }
        return this.f47766b;
    }

    /* renamed from: j */
    public final int[] m60241j() {
        if (this.f47769e == null) {
            this.f47769e = new int[2];
        }
        return this.f47769e;
    }

    /* renamed from: k */
    public boolean m60242k() {
        return m60243l(0);
    }

    /* renamed from: l */
    public boolean m60243l(int i10) {
        return m60240i(i10) != null;
    }

    /* renamed from: m */
    public boolean m60244m() {
        return this.f47768d;
    }

    /* renamed from: n */
    public void m60245n(boolean z10) {
        if (this.f47768d) {
            C9603h0.m59857M0(this.f47767c);
        }
        this.f47768d = z10;
    }

    /* renamed from: o */
    public final void m60246o(int i10, ViewParent viewParent) {
        if (i10 == 0) {
            this.f47765a = viewParent;
        } else {
            if (i10 != 1) {
                return;
            }
            this.f47766b = viewParent;
        }
    }

    /* renamed from: p */
    public boolean m60247p(int i10) {
        return m60248q(i10, 0);
    }

    /* renamed from: q */
    public boolean m60248q(int i10, int i11) {
        if (m60243l(i11)) {
            return true;
        }
        if (!m60244m()) {
            return false;
        }
        View view = this.f47767c;
        for (ViewParent parent = this.f47767c.getParent(); parent != null; parent = parent.getParent()) {
            if (C9611l0.m60090f(parent, view, this.f47767c, i10, i11)) {
                m60246o(i11, parent);
                C9611l0.m60089e(parent, view, this.f47767c, i10, i11);
                return true;
            }
            if (parent instanceof View) {
                view = (View) parent;
            }
        }
        return false;
    }

    /* renamed from: r */
    public void m60249r() {
        m60250s(0);
    }

    /* renamed from: s */
    public void m60250s(int i10) {
        ViewParent viewParentM60240i = m60240i(i10);
        if (viewParentM60240i != null) {
            C9611l0.m60091g(viewParentM60240i, this.f47767c, i10);
            m60246o(i10, null);
        }
    }
}
