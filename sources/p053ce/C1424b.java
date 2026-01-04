package p053ce;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import p015ak.C0213f;
import p514o9.C11839m;
import p514o9.C11842p;

/* renamed from: ce.b */
/* loaded from: classes3.dex */
public class C1424b extends RecyclerView.AbstractC0845o {

    /* renamed from: h0 */
    public int f6185h0;

    /* renamed from: i0 */
    public int f6186i0;

    /* renamed from: j0 */
    public int f6187j0;

    public C1424b(int i10) {
        this.f6186i0 = 2;
        this.f6185h0 = i10;
        this.f6187j0 = C11842p.m70840n(C0213f.m1377a(), 12);
    }

    /* renamed from: a */
    public void m8279a(int i10) {
        this.f6186i0 = i10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0845o
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.C0856z c0856z) {
        super.getItemOffsets(rect, view, recyclerView, c0856z);
        if (recyclerView == null || c0856z == null) {
            C11839m.m70689w("MainActivityItemDecoration", "parent or state is null.");
            return;
        }
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int i10 = this.f6186i0;
        int i11 = childAdapterPosition % i10;
        int i12 = this.f6185h0;
        rect.left = (i11 * i12) / i10;
        rect.right = i12 - (((i11 + 1) * i12) / i10);
        if (childAdapterPosition >= i10) {
            rect.top = this.f6187j0;
        }
    }

    public C1424b(int i10, int i11) {
        this.f6186i0 = 2;
        this.f6185h0 = i10;
        this.f6187j0 = C11842p.m70840n(C0213f.m1377a(), i11);
    }
}
