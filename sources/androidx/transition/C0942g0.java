package androidx.transition;

import android.graphics.Matrix;
import android.view.View;

/* renamed from: androidx.transition.g0 */
/* loaded from: classes.dex */
public class C0942g0 extends C0940f0 {
    @Override // androidx.transition.C0944h0
    /* renamed from: b */
    public float mo5808b(View view) {
        return view.getTransitionAlpha();
    }

    @Override // androidx.transition.C0944h0
    /* renamed from: d */
    public void mo5809d(View view, Matrix matrix) {
        view.setAnimationMatrix(matrix);
    }

    @Override // androidx.transition.C0944h0
    /* renamed from: e */
    public void mo5810e(View view, int i10, int i11, int i12, int i13) {
        view.setLeftTopRightBottom(i10, i11, i12, i13);
    }

    @Override // androidx.transition.C0944h0
    /* renamed from: f */
    public void mo5811f(View view, float f10) {
        view.setTransitionAlpha(f10);
    }

    @Override // androidx.transition.C0944h0
    /* renamed from: g */
    public void mo5812g(View view, int i10) {
        view.setTransitionVisibility(i10);
    }

    @Override // androidx.transition.C0944h0
    /* renamed from: h */
    public void mo5813h(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    @Override // androidx.transition.C0944h0
    /* renamed from: i */
    public void mo5814i(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }
}
