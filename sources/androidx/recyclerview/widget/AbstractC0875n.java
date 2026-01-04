package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: androidx.recyclerview.widget.n */
/* loaded from: classes.dex */
public abstract class AbstractC0875n {

    /* renamed from: a */
    public final RecyclerView.AbstractC0846p f4623a;

    /* renamed from: b */
    public int f4624b;

    /* renamed from: c */
    public final Rect f4625c;

    /* renamed from: androidx.recyclerview.widget.n$a */
    public class a extends AbstractC0875n {
        public a(RecyclerView.AbstractC0846p abstractC0846p) {
            super(abstractC0846p, null);
        }

        @Override // androidx.recyclerview.widget.AbstractC0875n
        /* renamed from: d */
        public int mo5551d(View view) {
            return this.f4623a.getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).rightMargin;
        }

        @Override // androidx.recyclerview.widget.AbstractC0875n
        /* renamed from: e */
        public int mo5552e(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return this.f4623a.getDecoratedMeasuredWidth(view) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        }

        @Override // androidx.recyclerview.widget.AbstractC0875n
        /* renamed from: f */
        public int mo5553f(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return this.f4623a.getDecoratedMeasuredHeight(view) + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.AbstractC0875n
        /* renamed from: g */
        public int mo5554g(View view) {
            return this.f4623a.getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).leftMargin;
        }

        @Override // androidx.recyclerview.widget.AbstractC0875n
        /* renamed from: h */
        public int mo5555h() {
            return this.f4623a.getWidth();
        }

        @Override // androidx.recyclerview.widget.AbstractC0875n
        /* renamed from: i */
        public int mo5556i() {
            return this.f4623a.getWidth() - this.f4623a.getPaddingRight();
        }

        @Override // androidx.recyclerview.widget.AbstractC0875n
        /* renamed from: j */
        public int mo5557j() {
            return this.f4623a.getPaddingRight();
        }

        @Override // androidx.recyclerview.widget.AbstractC0875n
        /* renamed from: l */
        public int mo5559l() {
            return this.f4623a.getWidthMode();
        }

        @Override // androidx.recyclerview.widget.AbstractC0875n
        /* renamed from: m */
        public int mo5560m() {
            return this.f4623a.getHeightMode();
        }

        @Override // androidx.recyclerview.widget.AbstractC0875n
        /* renamed from: n */
        public int mo5561n() {
            return this.f4623a.getPaddingLeft();
        }

        @Override // androidx.recyclerview.widget.AbstractC0875n
        /* renamed from: o */
        public int mo5562o() {
            return (this.f4623a.getWidth() - this.f4623a.getPaddingLeft()) - this.f4623a.getPaddingRight();
        }

        @Override // androidx.recyclerview.widget.AbstractC0875n
        /* renamed from: q */
        public int mo5564q(View view) {
            this.f4623a.getTransformedBoundingBox(view, true, this.f4625c);
            return this.f4625c.right;
        }

        @Override // androidx.recyclerview.widget.AbstractC0875n
        /* renamed from: r */
        public int mo5565r(View view) {
            this.f4623a.getTransformedBoundingBox(view, true, this.f4625c);
            return this.f4625c.left;
        }

        @Override // androidx.recyclerview.widget.AbstractC0875n
        /* renamed from: s */
        public void mo5566s(int i10) {
            this.f4623a.offsetChildrenHorizontal(i10);
        }
    }

    /* renamed from: androidx.recyclerview.widget.n$b */
    public class b extends AbstractC0875n {
        public b(RecyclerView.AbstractC0846p abstractC0846p) {
            super(abstractC0846p, null);
        }

        @Override // androidx.recyclerview.widget.AbstractC0875n
        /* renamed from: d */
        public int mo5551d(View view) {
            return this.f4623a.getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.AbstractC0875n
        /* renamed from: e */
        public int mo5552e(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return this.f4623a.getDecoratedMeasuredHeight(view) + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.AbstractC0875n
        /* renamed from: f */
        public int mo5553f(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return this.f4623a.getDecoratedMeasuredWidth(view) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        }

        @Override // androidx.recyclerview.widget.AbstractC0875n
        /* renamed from: g */
        public int mo5554g(View view) {
            return this.f4623a.getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).topMargin;
        }

        @Override // androidx.recyclerview.widget.AbstractC0875n
        /* renamed from: h */
        public int mo5555h() {
            return this.f4623a.getHeight();
        }

        @Override // androidx.recyclerview.widget.AbstractC0875n
        /* renamed from: i */
        public int mo5556i() {
            return this.f4623a.getHeight() - this.f4623a.getPaddingBottom();
        }

        @Override // androidx.recyclerview.widget.AbstractC0875n
        /* renamed from: j */
        public int mo5557j() {
            return this.f4623a.getPaddingBottom();
        }

        @Override // androidx.recyclerview.widget.AbstractC0875n
        /* renamed from: l */
        public int mo5559l() {
            return this.f4623a.getHeightMode();
        }

        @Override // androidx.recyclerview.widget.AbstractC0875n
        /* renamed from: m */
        public int mo5560m() {
            return this.f4623a.getWidthMode();
        }

        @Override // androidx.recyclerview.widget.AbstractC0875n
        /* renamed from: n */
        public int mo5561n() {
            return this.f4623a.getPaddingTop();
        }

        @Override // androidx.recyclerview.widget.AbstractC0875n
        /* renamed from: o */
        public int mo5562o() {
            return (this.f4623a.getHeight() - this.f4623a.getPaddingTop()) - this.f4623a.getPaddingBottom();
        }

        @Override // androidx.recyclerview.widget.AbstractC0875n
        /* renamed from: q */
        public int mo5564q(View view) {
            this.f4623a.getTransformedBoundingBox(view, true, this.f4625c);
            return this.f4625c.bottom;
        }

        @Override // androidx.recyclerview.widget.AbstractC0875n
        /* renamed from: r */
        public int mo5565r(View view) {
            this.f4623a.getTransformedBoundingBox(view, true, this.f4625c);
            return this.f4625c.top;
        }

        @Override // androidx.recyclerview.widget.AbstractC0875n
        /* renamed from: s */
        public void mo5566s(int i10) {
            this.f4623a.offsetChildrenVertical(i10);
        }
    }

    public /* synthetic */ AbstractC0875n(RecyclerView.AbstractC0846p abstractC0846p, a aVar) {
        this(abstractC0846p);
    }

    /* renamed from: a */
    public static AbstractC0875n m5548a(RecyclerView.AbstractC0846p abstractC0846p) {
        return new a(abstractC0846p);
    }

    /* renamed from: b */
    public static AbstractC0875n m5549b(RecyclerView.AbstractC0846p abstractC0846p, int i10) {
        if (i10 == 0) {
            return m5548a(abstractC0846p);
        }
        if (i10 == 1) {
            return m5550c(abstractC0846p);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    /* renamed from: c */
    public static AbstractC0875n m5550c(RecyclerView.AbstractC0846p abstractC0846p) {
        return new b(abstractC0846p);
    }

    /* renamed from: d */
    public abstract int mo5551d(View view);

    /* renamed from: e */
    public abstract int mo5552e(View view);

    /* renamed from: f */
    public abstract int mo5553f(View view);

    /* renamed from: g */
    public abstract int mo5554g(View view);

    /* renamed from: h */
    public abstract int mo5555h();

    /* renamed from: i */
    public abstract int mo5556i();

    /* renamed from: j */
    public abstract int mo5557j();

    /* renamed from: k */
    public RecyclerView.AbstractC0846p m5558k() {
        return this.f4623a;
    }

    /* renamed from: l */
    public abstract int mo5559l();

    /* renamed from: m */
    public abstract int mo5560m();

    /* renamed from: n */
    public abstract int mo5561n();

    /* renamed from: o */
    public abstract int mo5562o();

    /* renamed from: p */
    public int m5563p() {
        if (Integer.MIN_VALUE == this.f4624b) {
            return 0;
        }
        return mo5562o() - this.f4624b;
    }

    /* renamed from: q */
    public abstract int mo5564q(View view);

    /* renamed from: r */
    public abstract int mo5565r(View view);

    /* renamed from: s */
    public abstract void mo5566s(int i10);

    /* renamed from: t */
    public void m5567t() {
        this.f4624b = mo5562o();
    }

    public AbstractC0875n(RecyclerView.AbstractC0846p abstractC0846p) {
        this.f4624b = Integer.MIN_VALUE;
        this.f4625c = new Rect();
        this.f4623a = abstractC0846p;
    }
}
