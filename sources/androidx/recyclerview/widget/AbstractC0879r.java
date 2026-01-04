package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: androidx.recyclerview.widget.r */
/* loaded from: classes.dex */
public abstract class AbstractC0879r extends RecyclerView.AbstractC0843m {
    private static final boolean DEBUG = false;
    private static final String TAG = "SimpleItemAnimator";
    boolean mSupportsChangeAnimations = true;

    public abstract boolean animateAdd(RecyclerView.AbstractC0833c0 abstractC0833c0);

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843m
    public boolean animateAppearance(RecyclerView.AbstractC0833c0 abstractC0833c0, RecyclerView.AbstractC0843m.c cVar, RecyclerView.AbstractC0843m.c cVar2) {
        int i10;
        int i11;
        return (cVar == null || ((i10 = cVar.f4357a) == (i11 = cVar2.f4357a) && cVar.f4358b == cVar2.f4358b)) ? animateAdd(abstractC0833c0) : animateMove(abstractC0833c0, i10, cVar.f4358b, i11, cVar2.f4358b);
    }

    public abstract boolean animateChange(RecyclerView.AbstractC0833c0 abstractC0833c0, RecyclerView.AbstractC0833c0 abstractC0833c02, int i10, int i11, int i12, int i13);

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843m
    public boolean animateChange(RecyclerView.AbstractC0833c0 abstractC0833c0, RecyclerView.AbstractC0833c0 abstractC0833c02, RecyclerView.AbstractC0843m.c cVar, RecyclerView.AbstractC0843m.c cVar2) {
        int i10;
        int i11;
        int i12 = cVar.f4357a;
        int i13 = cVar.f4358b;
        if (abstractC0833c02.m5150L()) {
            int i14 = cVar.f4357a;
            i11 = cVar.f4358b;
            i10 = i14;
        } else {
            i10 = cVar2.f4357a;
            i11 = cVar2.f4358b;
        }
        return animateChange(abstractC0833c0, abstractC0833c02, i12, i13, i10, i11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843m
    public boolean animateDisappearance(RecyclerView.AbstractC0833c0 abstractC0833c0, RecyclerView.AbstractC0843m.c cVar, RecyclerView.AbstractC0843m.c cVar2) {
        int i10 = cVar.f4357a;
        int i11 = cVar.f4358b;
        View view = abstractC0833c0.f4327a;
        int left = cVar2 == null ? view.getLeft() : cVar2.f4357a;
        int top = cVar2 == null ? view.getTop() : cVar2.f4358b;
        if (abstractC0833c0.m5177x() || (i10 == left && i11 == top)) {
            return animateRemove(abstractC0833c0);
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return animateMove(abstractC0833c0, i10, i11, left, top);
    }

    public abstract boolean animateMove(RecyclerView.AbstractC0833c0 abstractC0833c0, int i10, int i11, int i12, int i13);

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843m
    public boolean animatePersistence(RecyclerView.AbstractC0833c0 abstractC0833c0, RecyclerView.AbstractC0843m.c cVar, RecyclerView.AbstractC0843m.c cVar2) {
        int i10 = cVar.f4357a;
        int i11 = cVar2.f4357a;
        if (i10 != i11 || cVar.f4358b != cVar2.f4358b) {
            return animateMove(abstractC0833c0, i10, cVar.f4358b, i11, cVar2.f4358b);
        }
        dispatchMoveFinished(abstractC0833c0);
        return false;
    }

    public abstract boolean animateRemove(RecyclerView.AbstractC0833c0 abstractC0833c0);

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843m
    public boolean canReuseUpdatedViewHolder(RecyclerView.AbstractC0833c0 abstractC0833c0) {
        return !this.mSupportsChangeAnimations || abstractC0833c0.m5175v();
    }

    public final void dispatchAddFinished(RecyclerView.AbstractC0833c0 abstractC0833c0) {
        onAddFinished(abstractC0833c0);
        dispatchAnimationFinished(abstractC0833c0);
    }

    public final void dispatchAddStarting(RecyclerView.AbstractC0833c0 abstractC0833c0) {
        onAddStarting(abstractC0833c0);
    }

    public final void dispatchChangeFinished(RecyclerView.AbstractC0833c0 abstractC0833c0, boolean z10) {
        onChangeFinished(abstractC0833c0, z10);
        dispatchAnimationFinished(abstractC0833c0);
    }

    public final void dispatchChangeStarting(RecyclerView.AbstractC0833c0 abstractC0833c0, boolean z10) {
        onChangeStarting(abstractC0833c0, z10);
    }

    public final void dispatchMoveFinished(RecyclerView.AbstractC0833c0 abstractC0833c0) {
        onMoveFinished(abstractC0833c0);
        dispatchAnimationFinished(abstractC0833c0);
    }

    public final void dispatchMoveStarting(RecyclerView.AbstractC0833c0 abstractC0833c0) {
        onMoveStarting(abstractC0833c0);
    }

    public final void dispatchRemoveFinished(RecyclerView.AbstractC0833c0 abstractC0833c0) {
        onRemoveFinished(abstractC0833c0);
        dispatchAnimationFinished(abstractC0833c0);
    }

    public final void dispatchRemoveStarting(RecyclerView.AbstractC0833c0 abstractC0833c0) {
        onRemoveStarting(abstractC0833c0);
    }

    public boolean getSupportsChangeAnimations() {
        return this.mSupportsChangeAnimations;
    }

    public void onAddFinished(RecyclerView.AbstractC0833c0 abstractC0833c0) {
    }

    public void onAddStarting(RecyclerView.AbstractC0833c0 abstractC0833c0) {
    }

    public void onChangeFinished(RecyclerView.AbstractC0833c0 abstractC0833c0, boolean z10) {
    }

    public void onChangeStarting(RecyclerView.AbstractC0833c0 abstractC0833c0, boolean z10) {
    }

    public void onMoveFinished(RecyclerView.AbstractC0833c0 abstractC0833c0) {
    }

    public void onMoveStarting(RecyclerView.AbstractC0833c0 abstractC0833c0) {
    }

    public void onRemoveFinished(RecyclerView.AbstractC0833c0 abstractC0833c0) {
    }

    public void onRemoveStarting(RecyclerView.AbstractC0833c0 abstractC0833c0) {
    }

    public void setSupportsChangeAnimations(boolean z10) {
        this.mSupportsChangeAnimations = z10;
    }
}
