package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R$animator;
import com.google.android.material.transformation.FabTransformationBehavior;
import java.util.HashMap;
import java.util.Map;
import p273f0.C9603h0;
import p666u2.C13117h;
import p666u2.C13119j;

@Deprecated
/* loaded from: classes.dex */
public class FabTransformationSheetBehavior extends FabTransformationBehavior {

    /* renamed from: i */
    public Map<View, Integer> f9080i;

    public FabTransformationSheetBehavior() {
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior, com.google.android.material.transformation.ExpandableBehavior
    /* renamed from: H */
    public boolean mo11429H(View view, View view2, boolean z10, boolean z11) {
        m11455g0(view2, z10);
        return super.mo11429H(view, view2, z10, z11);
    }

    @Override // com.google.android.material.transformation.FabTransformationBehavior
    /* renamed from: e0 */
    public FabTransformationBehavior.C1894e mo11452e0(Context context, boolean z10) {
        int i10 = z10 ? R$animator.mtrl_fab_transformation_sheet_expand_spec : R$animator.mtrl_fab_transformation_sheet_collapse_spec;
        FabTransformationBehavior.C1894e c1894e = new FabTransformationBehavior.C1894e();
        c1894e.f9073a = C13117h.m78898d(context, i10);
        c1894e.f9074b = new C13119j(17, 0.0f, 0.0f);
        return c1894e;
    }

    /* renamed from: g0 */
    public final void m11455g0(View view, boolean z10) {
        ViewParent parent = view.getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z10) {
                this.f9080i = new HashMap(childCount);
            }
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = coordinatorLayout.getChildAt(i10);
                boolean z11 = (childAt.getLayoutParams() instanceof CoordinatorLayout.C0594e) && (((CoordinatorLayout.C0594e) childAt.getLayoutParams()).m3761f() instanceof FabTransformationScrimBehavior);
                if (childAt != view && !z11) {
                    if (z10) {
                        this.f9080i.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        C9603h0.m59833A0(childAt, 4);
                    } else {
                        Map<View, Integer> map = this.f9080i;
                        if (map != null && map.containsKey(childAt)) {
                            C9603h0.m59833A0(childAt, this.f9080i.get(childAt).intValue());
                        }
                    }
                }
            }
            if (z10) {
                return;
            }
            this.f9080i = null;
        }
    }

    public FabTransformationSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
