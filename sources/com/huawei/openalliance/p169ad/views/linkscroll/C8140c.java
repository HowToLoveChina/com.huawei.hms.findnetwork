package com.huawei.openalliance.p169ad.views.linkscroll;

import android.view.View;
import android.view.ViewParent;

/* renamed from: com.huawei.openalliance.ad.views.linkscroll.c */
/* loaded from: classes2.dex */
public class C8140c {

    /* renamed from: a */
    private final View f37950a;

    /* renamed from: b */
    private ViewParent f37951b;

    /* renamed from: c */
    private boolean f37952c;

    /* renamed from: d */
    private int[] f37953d;

    public C8140c(View view) {
        this.f37950a = view;
    }

    /* renamed from: a */
    public void m50353a(View view) {
        if (view instanceof InterfaceC8138a) {
            ((C8142e) view).m50376a();
        }
    }

    /* renamed from: b */
    public boolean m50360b() {
        return this.f37951b != null;
    }

    /* renamed from: c */
    public void m50361c() {
        ViewParent viewParent = this.f37951b;
        if (viewParent != null) {
            C8141d.m50362a(viewParent, this.f37950a);
            this.f37951b = null;
        }
    }

    /* renamed from: a */
    public void m50354a(boolean z10) {
        if (this.f37952c) {
            m50353a(this.f37950a);
        }
        this.f37952c = z10;
    }

    /* renamed from: a */
    public boolean m50355a() {
        return this.f37952c;
    }

    /* renamed from: a */
    public boolean m50356a(float f10, float f11) {
        ViewParent viewParent;
        if (!m50355a() || (viewParent = this.f37951b) == null) {
            return false;
        }
        return C8141d.m50365a(viewParent, this.f37950a, f10, f11);
    }

    /* renamed from: a */
    public boolean m50357a(int i10) {
        if (m50360b()) {
            return true;
        }
        if (!m50355a()) {
            return false;
        }
        View view = this.f37950a;
        for (ViewParent parent = this.f37950a.getParent(); parent != null; parent = parent.getParent()) {
            if (C8141d.m50366a(parent, view, this.f37950a, i10)) {
                this.f37951b = parent;
                C8141d.m50367b(parent, view, this.f37950a, i10);
                return true;
            }
            if (parent instanceof View) {
                view = (View) parent;
            }
        }
        return false;
    }

    /* renamed from: a */
    public boolean m50358a(int i10, int i11, int i12, int i13, int[] iArr) {
        int i14;
        int i15;
        if (m50355a() && this.f37951b != null) {
            if (i10 != 0 || i11 != 0 || i12 != 0 || i13 != 0) {
                if (iArr != null) {
                    this.f37950a.getLocationInWindow(iArr);
                    i14 = iArr[0];
                    i15 = iArr[1];
                } else {
                    i14 = 0;
                    i15 = 0;
                }
                C8141d.m50363a(this.f37951b, this.f37950a, i10, i11, i12, i13);
                if (iArr != null) {
                    this.f37950a.getLocationInWindow(iArr);
                    iArr[0] = iArr[0] - i14;
                    iArr[1] = iArr[1] - i15;
                }
                return true;
            }
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
            }
        }
        return false;
    }

    /* renamed from: a */
    public boolean m50359a(int i10, int i11, int[] iArr, int[] iArr2) {
        int i12;
        int i13;
        if (!m50355a() || this.f37951b == null) {
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
            this.f37950a.getLocationInWindow(iArr2);
            i12 = iArr2[0];
            i13 = iArr2[1];
        } else {
            i12 = 0;
            i13 = 0;
        }
        if (iArr == null) {
            if (this.f37953d == null) {
                this.f37953d = new int[2];
            }
            iArr = this.f37953d;
        }
        iArr[0] = 0;
        iArr[1] = 0;
        C8141d.m50364a(this.f37951b, this.f37950a, i10, i11, iArr);
        if (iArr2 != null) {
            this.f37950a.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i12;
            iArr2[1] = iArr2[1] - i13;
        }
        return (iArr[0] == 0 && iArr[1] == 0) ? false : true;
    }
}
