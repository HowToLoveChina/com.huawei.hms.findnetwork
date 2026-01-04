package androidx.transition;

import android.view.View;

/* renamed from: androidx.transition.i0 */
/* loaded from: classes.dex */
public abstract class AbstractC0946i0 extends AbstractC0957r {

    /* renamed from: a */
    public static final String[] f4857a = {"android:visibilityPropagation:visibility", "android:visibilityPropagation:center"};

    /* renamed from: d */
    public static int m5817d(C0959t c0959t, int i10) {
        int[] iArr;
        if (c0959t == null || (iArr = (int[]) c0959t.f4888a.get("android:visibilityPropagation:center")) == null) {
            return -1;
        }
        return iArr[i10];
    }

    @Override // androidx.transition.AbstractC0957r
    /* renamed from: a */
    public void mo5818a(C0959t c0959t) {
        View view = c0959t.f4889b;
        Integer numValueOf = (Integer) c0959t.f4888a.get("android:visibility:visibility");
        if (numValueOf == null) {
            numValueOf = Integer.valueOf(view.getVisibility());
        }
        c0959t.f4888a.put("android:visibilityPropagation:visibility", numValueOf);
        int[] iArr = {iRound, 0};
        view.getLocationOnScreen(iArr);
        int iRound = iArr[0] + Math.round(view.getTranslationX());
        iArr[0] = iRound + (view.getWidth() / 2);
        int iRound2 = iArr[1] + Math.round(view.getTranslationY());
        iArr[1] = iRound2;
        iArr[1] = iRound2 + (view.getHeight() / 2);
        c0959t.f4888a.put("android:visibilityPropagation:center", iArr);
    }

    @Override // androidx.transition.AbstractC0957r
    /* renamed from: b */
    public String[] mo5819b() {
        return f4857a;
    }

    /* renamed from: e */
    public int m5820e(C0959t c0959t) {
        Integer num;
        if (c0959t == null || (num = (Integer) c0959t.f4888a.get("android:visibilityPropagation:visibility")) == null) {
            return 8;
        }
        return num.intValue();
    }

    /* renamed from: f */
    public int m5821f(C0959t c0959t) {
        return m5817d(c0959t, 0);
    }

    /* renamed from: g */
    public int m5822g(C0959t c0959t) {
        return m5817d(c0959t, 1);
    }
}
