package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Locale;

/* renamed from: androidx.viewpager2.widget.e */
/* loaded from: classes.dex */
public final class C1004e extends RecyclerView.AbstractC0850t {

    /* renamed from: c0 */
    public ViewPager2.AbstractC0995i f5015c0;

    /* renamed from: d0 */
    public final ViewPager2 f5016d0;

    /* renamed from: e0 */
    public final RecyclerView f5017e0;

    /* renamed from: f0 */
    public final LinearLayoutManager f5018f0;

    /* renamed from: g0 */
    public int f5019g0;

    /* renamed from: h0 */
    public int f5020h0;

    /* renamed from: i0 */
    public a f5021i0;

    /* renamed from: j0 */
    public int f5022j0;

    /* renamed from: k0 */
    public int f5023k0;

    /* renamed from: l0 */
    public boolean f5024l0;

    /* renamed from: m0 */
    public boolean f5025m0;

    /* renamed from: n0 */
    public boolean f5026n0;

    /* renamed from: o0 */
    public boolean f5027o0;

    /* renamed from: androidx.viewpager2.widget.e$a */
    public static final class a {

        /* renamed from: a */
        public int f5028a;

        /* renamed from: b */
        public float f5029b;

        /* renamed from: c */
        public int f5030c;

        /* renamed from: a */
        public void m5930a() {
            this.f5028a = -1;
            this.f5029b = 0.0f;
            this.f5030c = 0;
        }
    }

    public C1004e(ViewPager2 viewPager2) {
        this.f5016d0 = viewPager2;
        RecyclerView recyclerView = viewPager2.f4975j;
        this.f5017e0 = recyclerView;
        this.f5018f0 = (LinearLayoutManager) recyclerView.getLayoutManager();
        this.f5021i0 = new a();
        m5926s();
    }

    /* renamed from: b */
    public final void m5915b(int i10, float f10, int i11) {
        ViewPager2.AbstractC0995i abstractC0995i = this.f5015c0;
        if (abstractC0995i != null) {
            abstractC0995i.mo5900b(i10, f10, i11);
        }
    }

    /* renamed from: f */
    public final void m5916f(int i10) {
        ViewPager2.AbstractC0995i abstractC0995i = this.f5015c0;
        if (abstractC0995i != null) {
            abstractC0995i.mo5880c(i10);
        }
    }

    /* renamed from: g */
    public final void m5917g(int i10) {
        if ((this.f5019g0 == 3 && this.f5020h0 == 0) || this.f5020h0 == i10) {
            return;
        }
        this.f5020h0 = i10;
        ViewPager2.AbstractC0995i abstractC0995i = this.f5015c0;
        if (abstractC0995i != null) {
            abstractC0995i.mo5879a(i10);
        }
    }

    /* renamed from: k */
    public final int m5918k() {
        return this.f5018f0.findFirstVisibleItemPosition();
    }

    /* renamed from: l */
    public double m5919l() {
        m5929v();
        a aVar = this.f5021i0;
        return aVar.f5028a + aVar.f5029b;
    }

    /* renamed from: m */
    public int m5920m() {
        return this.f5020h0;
    }

    /* renamed from: n */
    public boolean m5921n() {
        return this.f5027o0;
    }

    /* renamed from: o */
    public boolean m5922o() {
        return this.f5020h0 == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0850t
    public void onScrollStateChanged(RecyclerView recyclerView, int i10) {
        if (!(this.f5019g0 == 1 && this.f5020h0 == 1) && i10 == 1) {
            m5928u(false);
            return;
        }
        if (m5923p() && i10 == 2) {
            if (this.f5025m0) {
                m5917g(2);
                this.f5024l0 = true;
                return;
            }
            return;
        }
        if (m5923p() && i10 == 0) {
            m5929v();
            if (this.f5025m0) {
                a aVar = this.f5021i0;
                if (aVar.f5030c == 0) {
                    int i11 = this.f5022j0;
                    int i12 = aVar.f5028a;
                    if (i11 != i12) {
                        m5916f(i12);
                    }
                }
            } else {
                int i13 = this.f5021i0.f5028a;
                if (i13 != -1) {
                    m5915b(i13, 0.0f, 0);
                }
            }
            m5917g(0);
            m5926s();
        }
        if (this.f5019g0 == 2 && i10 == 0 && this.f5026n0) {
            m5929v();
            a aVar2 = this.f5021i0;
            if (aVar2.f5030c == 0) {
                int i14 = this.f5023k0;
                int i15 = aVar2.f5028a;
                if (i14 != i15) {
                    if (i15 == -1) {
                        i15 = 0;
                    }
                    m5916f(i15);
                }
                m5917g(0);
                m5926s();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0033  */
    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0850t
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onScrolled(androidx.recyclerview.widget.RecyclerView r4, int r5, int r6) {
        /*
            r3 = this;
            r4 = 1
            r3.f5025m0 = r4
            r3.m5929v()
            boolean r0 = r3.f5024l0
            r1 = -1
            r2 = 0
            if (r0 == 0) goto L37
            r3.f5024l0 = r2
            if (r6 > 0) goto L1f
            if (r6 != 0) goto L29
            if (r5 >= 0) goto L16
            r5 = r4
            goto L17
        L16:
            r5 = r2
        L17:
            androidx.viewpager2.widget.ViewPager2 r6 = r3.f5016d0
            boolean r6 = r6.m5865d()
            if (r5 != r6) goto L29
        L1f:
            androidx.viewpager2.widget.e$a r5 = r3.f5021i0
            int r6 = r5.f5030c
            if (r6 == 0) goto L29
            int r5 = r5.f5028a
            int r5 = r5 + r4
            goto L2d
        L29:
            androidx.viewpager2.widget.e$a r5 = r3.f5021i0
            int r5 = r5.f5028a
        L2d:
            r3.f5023k0 = r5
            int r6 = r3.f5022j0
            if (r6 == r5) goto L45
            r3.m5916f(r5)
            goto L45
        L37:
            int r5 = r3.f5019g0
            if (r5 != 0) goto L45
            androidx.viewpager2.widget.e$a r5 = r3.f5021i0
            int r5 = r5.f5028a
            if (r5 != r1) goto L42
            r5 = r2
        L42:
            r3.m5916f(r5)
        L45:
            androidx.viewpager2.widget.e$a r5 = r3.f5021i0
            int r6 = r5.f5028a
            if (r6 != r1) goto L4c
            r6 = r2
        L4c:
            float r0 = r5.f5029b
            int r5 = r5.f5030c
            r3.m5915b(r6, r0, r5)
            androidx.viewpager2.widget.e$a r5 = r3.f5021i0
            int r6 = r5.f5028a
            int r0 = r3.f5023k0
            if (r6 == r0) goto L5d
            if (r0 != r1) goto L6b
        L5d:
            int r5 = r5.f5030c
            if (r5 != 0) goto L6b
            int r5 = r3.f5020h0
            if (r5 == r4) goto L6b
            r3.m5917g(r2)
            r3.m5926s()
        L6b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager2.widget.C1004e.onScrolled(androidx.recyclerview.widget.RecyclerView, int, int):void");
    }

    /* renamed from: p */
    public final boolean m5923p() {
        int i10 = this.f5019g0;
        return i10 == 1 || i10 == 4;
    }

    /* renamed from: q */
    public void m5924q() {
        this.f5026n0 = true;
    }

    /* renamed from: r */
    public void m5925r(int i10, boolean z10) {
        this.f5019g0 = z10 ? 2 : 3;
        this.f5027o0 = false;
        boolean z11 = this.f5023k0 != i10;
        this.f5023k0 = i10;
        m5917g(2);
        if (z11) {
            m5916f(i10);
        }
    }

    /* renamed from: s */
    public final void m5926s() {
        this.f5019g0 = 0;
        this.f5020h0 = 0;
        this.f5021i0.m5930a();
        this.f5022j0 = -1;
        this.f5023k0 = -1;
        this.f5024l0 = false;
        this.f5025m0 = false;
        this.f5027o0 = false;
        this.f5026n0 = false;
    }

    /* renamed from: t */
    public void m5927t(ViewPager2.AbstractC0995i abstractC0995i) {
        this.f5015c0 = abstractC0995i;
    }

    /* renamed from: u */
    public final void m5928u(boolean z10) {
        this.f5027o0 = z10;
        this.f5019g0 = z10 ? 4 : 1;
        int i10 = this.f5023k0;
        if (i10 != -1) {
            this.f5022j0 = i10;
            this.f5023k0 = -1;
        } else if (this.f5022j0 == -1) {
            this.f5022j0 = m5918k();
        }
        m5917g(1);
    }

    /* renamed from: v */
    public final void m5929v() {
        int top;
        a aVar = this.f5021i0;
        int iFindFirstVisibleItemPosition = this.f5018f0.findFirstVisibleItemPosition();
        aVar.f5028a = iFindFirstVisibleItemPosition;
        if (iFindFirstVisibleItemPosition == -1) {
            aVar.m5930a();
            return;
        }
        View viewFindViewByPosition = this.f5018f0.findViewByPosition(iFindFirstVisibleItemPosition);
        if (viewFindViewByPosition == null) {
            aVar.m5930a();
            return;
        }
        int leftDecorationWidth = this.f5018f0.getLeftDecorationWidth(viewFindViewByPosition);
        int rightDecorationWidth = this.f5018f0.getRightDecorationWidth(viewFindViewByPosition);
        int topDecorationHeight = this.f5018f0.getTopDecorationHeight(viewFindViewByPosition);
        int bottomDecorationHeight = this.f5018f0.getBottomDecorationHeight(viewFindViewByPosition);
        ViewGroup.LayoutParams layoutParams = viewFindViewByPosition.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            leftDecorationWidth += marginLayoutParams.leftMargin;
            rightDecorationWidth += marginLayoutParams.rightMargin;
            topDecorationHeight += marginLayoutParams.topMargin;
            bottomDecorationHeight += marginLayoutParams.bottomMargin;
        }
        int height = viewFindViewByPosition.getHeight() + topDecorationHeight + bottomDecorationHeight;
        int width = viewFindViewByPosition.getWidth() + leftDecorationWidth + rightDecorationWidth;
        if (this.f5018f0.getOrientation() == 0) {
            top = (viewFindViewByPosition.getLeft() - leftDecorationWidth) - this.f5017e0.getPaddingLeft();
            if (this.f5016d0.m5865d()) {
                top = -top;
            }
            height = width;
        } else {
            top = (viewFindViewByPosition.getTop() - topDecorationHeight) - this.f5017e0.getPaddingTop();
        }
        int i10 = -top;
        aVar.f5030c = i10;
        if (i10 >= 0) {
            aVar.f5029b = height == 0 ? 0.0f : i10 / height;
        } else {
            if (!new C1000a(this.f5018f0).m5908d()) {
                throw new IllegalStateException(String.format(Locale.US, "Page can only be offset by a positive amount, not by %d", Integer.valueOf(aVar.f5030c)));
            }
            throw new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
        }
    }
}
