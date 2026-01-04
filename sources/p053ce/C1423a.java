package p053ce;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.TypedValue;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.p073ds.R$color;
import p514o9.C11839m;
import p514o9.C11842p;

/* renamed from: ce.a */
/* loaded from: classes3.dex */
public class C1423a extends RecyclerView.AbstractC0845o {

    /* renamed from: h0 */
    public Context f6180h0;

    /* renamed from: i0 */
    public int f6181i0 = 2;

    /* renamed from: k0 */
    public int f6183k0 = -1;

    /* renamed from: l0 */
    public int f6184l0 = -1;

    /* renamed from: j0 */
    public Paint f6182j0 = new Paint();

    public C1423a(Context context) {
        this.f6180h0 = context;
        this.f6182j0.setColor(context.getResources().getColor(R$color.backup_detail_item_divider, null));
    }

    /* renamed from: a */
    public static C1423a m8274a(Context context) {
        return new C1423a(context);
    }

    /* renamed from: b */
    public boolean m8275b(RecyclerView recyclerView) {
        RecyclerView.AbstractC0846p layoutManager = recyclerView.getLayoutManager();
        return (layoutManager instanceof LinearLayoutManager) && ((LinearLayoutManager) layoutManager).getOrientation() == 1;
    }

    /* renamed from: c */
    public C1423a m8276c(float f10) {
        float fApplyDimension = TypedValue.applyDimension(1, f10, this.f6180h0.getResources().getDisplayMetrics());
        int i10 = (int) fApplyDimension;
        this.f6181i0 = i10;
        if (i10 < 1) {
            this.f6181i0 = 1;
        }
        C11839m.m70689w("DetailRecyclerViewItemDecoration", "dividerHeight:" + this.f6181i0 + " px:" + fApplyDimension + " dividerHeight:" + f10);
        return this;
    }

    /* renamed from: d */
    public C1423a m8277d(int i10) {
        this.f6183k0 = (int) C11842p.m70844o(this.f6180h0, i10);
        return this;
    }

    /* renamed from: e */
    public C1423a m8278e(int i10) {
        this.f6184l0 = (int) C11842p.m70844o(this.f6180h0, i10);
        return this;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0845o
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.C0856z c0856z) {
        super.getItemOffsets(rect, view, recyclerView, c0856z);
        if (m8275b(recyclerView)) {
            rect.bottom = this.f6181i0;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0845o
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.C0856z c0856z) {
        super.onDraw(canvas, recyclerView, c0856z);
        if (m8275b(recyclerView)) {
            int childCount = recyclerView.getChildCount();
            if (this.f6183k0 == -1) {
                this.f6183k0 = recyclerView.getPaddingLeft();
            }
            if (this.f6184l0 == -1) {
                this.f6184l0 = recyclerView.getPaddingRight();
            }
            for (int i10 = 0; i10 < childCount - 1; i10++) {
                View childAt = recyclerView.getChildAt(i10);
                canvas.drawRect(this.f6183k0, childAt.getBottom(), recyclerView.getWidth() - this.f6184l0, childAt.getBottom() + this.f6181i0, this.f6182j0);
            }
        }
    }
}
