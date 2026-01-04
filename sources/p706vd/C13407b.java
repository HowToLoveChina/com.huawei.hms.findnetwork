package p706vd;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import p514o9.C11842p;

/* renamed from: vd.b */
/* loaded from: classes3.dex */
public class C13407b extends RecyclerView.AbstractC0845o {

    /* renamed from: h0 */
    public int f60496h0;

    public C13407b(int i10) {
        this.f60496h0 = i10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0845o
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.C0856z c0856z) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (C11842p.m70765S0()) {
            if (childAdapterPosition == 0) {
                rect.right = 0;
                return;
            } else {
                rect.right = this.f60496h0;
                return;
            }
        }
        if (childAdapterPosition == 0) {
            rect.left = 0;
        } else {
            rect.left = this.f60496h0;
        }
    }
}
