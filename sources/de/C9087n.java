package de;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import p783xp.C13843a;

/* renamed from: de.n */
/* loaded from: classes3.dex */
public class C9087n extends RecyclerView.AbstractC0845o {

    /* renamed from: h0 */
    public final Context f45843h0;

    /* renamed from: i0 */
    public final int f45844i0;

    /* renamed from: j0 */
    public final int f45845j0;

    public C9087n(Context context, int i10, int i11) {
        this.f45843h0 = context;
        this.f45844i0 = i10;
        this.f45845j0 = i11;
    }

    /* renamed from: a */
    public final int m57286a(RecyclerView recyclerView) {
        RecyclerView.AbstractC0846p layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            return ((GridLayoutManager) layoutManager).getSpanCount();
        }
        return -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0845o
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.C0856z c0856z) {
        int childLayoutPosition = recyclerView.getChildLayoutPosition(view);
        int iM57286a = m57286a(recyclerView);
        int i10 = this.f45844i0;
        int i11 = ((iM57286a - 1) * i10) / iM57286a;
        int i12 = (childLayoutPosition % iM57286a) * (i10 - i11);
        int i13 = i11 - i12;
        if (C13843a.m83070V(this.f45843h0)) {
            rect.right = i12;
            rect.left = i13;
        } else {
            rect.right = i13;
            rect.left = i12;
        }
        if (childLayoutPosition >= 4) {
            rect.top = this.f45845j0;
        }
    }
}
