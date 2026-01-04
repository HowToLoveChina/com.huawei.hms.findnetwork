package com.google.android.material.badge;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.badge.BadgeState;
import com.google.android.material.internal.C1781l;
import com.google.android.material.internal.C1784o;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;
import p273f0.C9603h0;
import p276f3.C9650d;
import p356i3.C10427h;

/* renamed from: com.google.android.material.badge.a */
/* loaded from: classes.dex */
public class C1652a extends Drawable implements C1781l.b {

    /* renamed from: n */
    public static final int f7479n = R$style.Widget_MaterialComponents_Badge;

    /* renamed from: o */
    public static final int f7480o = R$attr.badgeStyle;

    /* renamed from: a */
    public final WeakReference<Context> f7481a;

    /* renamed from: b */
    public final C10427h f7482b;

    /* renamed from: c */
    public final C1781l f7483c;

    /* renamed from: d */
    public final Rect f7484d;

    /* renamed from: e */
    public final BadgeState f7485e;

    /* renamed from: f */
    public float f7486f;

    /* renamed from: g */
    public float f7487g;

    /* renamed from: h */
    public int f7488h;

    /* renamed from: i */
    public float f7489i;

    /* renamed from: j */
    public float f7490j;

    /* renamed from: k */
    public float f7491k;

    /* renamed from: l */
    public WeakReference<View> f7492l;

    /* renamed from: m */
    public WeakReference<FrameLayout> f7493m;

    /* renamed from: com.google.android.material.badge.a$a */
    public class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ View f7494a;

        /* renamed from: b */
        public final /* synthetic */ FrameLayout f7495b;

        public a(View view, FrameLayout frameLayout) {
            this.f7494a = view;
            this.f7495b = frameLayout;
        }

        @Override // java.lang.Runnable
        public void run() throws Resources.NotFoundException {
            C1652a.this.m9675B(this.f7494a, this.f7495b);
        }
    }

    public C1652a(Context context, int i10, int i11, int i12, BadgeState.State state) throws Resources.NotFoundException {
        this.f7481a = new WeakReference<>(context);
        C1784o.m10765c(context);
        this.f7484d = new Rect();
        this.f7482b = new C10427h();
        C1781l c1781l = new C1781l(this);
        this.f7483c = c1781l;
        c1781l.m10756e().setTextAlign(Paint.Align.CENTER);
        m9674y(R$style.TextAppearance_MaterialComponents_Badge);
        this.f7485e = new BadgeState(context, i10, i11, i12, state);
        m9697w();
    }

    /* renamed from: A */
    public static void m9669A(View view) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        viewGroup.setClipChildren(false);
        viewGroup.setClipToPadding(false);
    }

    /* renamed from: c */
    public static C1652a m9670c(Context context) {
        return new C1652a(context, 0, f7480o, f7479n, null);
    }

    /* renamed from: d */
    public static C1652a m9671d(Context context, BadgeState.State state) {
        return new C1652a(context, 0, f7480o, f7479n, state);
    }

    /* renamed from: e */
    private void m9672e(Canvas canvas) {
        Rect rect = new Rect();
        String strM9680f = m9680f();
        this.f7483c.m10756e().getTextBounds(strM9680f, 0, strM9680f.length(), rect);
        canvas.drawText(strM9680f, this.f7486f, this.f7487g + (rect.height() / 2), this.f7483c.m10756e());
    }

    /* renamed from: x */
    private void m9673x(C9650d c9650d) throws Resources.NotFoundException {
        Context context;
        if (this.f7483c.m10755d() == c9650d || (context = this.f7481a.get()) == null) {
            return;
        }
        this.f7483c.m10759h(c9650d, context);
        m9676C();
    }

    /* renamed from: y */
    private void m9674y(int i10) throws Resources.NotFoundException {
        Context context = this.f7481a.get();
        if (context == null) {
            return;
        }
        m9673x(new C9650d(context, i10));
    }

    /* renamed from: B */
    public void m9675B(View view, FrameLayout frameLayout) throws Resources.NotFoundException {
        this.f7492l = new WeakReference<>(view);
        boolean z10 = C1653b.f7497a;
        if (z10 && frameLayout == null) {
            m9698z(view);
        } else {
            this.f7493m = new WeakReference<>(frameLayout);
        }
        if (!z10) {
            m9669A(view);
        }
        m9676C();
        invalidateSelf();
    }

    /* renamed from: C */
    public final void m9676C() throws Resources.NotFoundException {
        Context context = this.f7481a.get();
        WeakReference<View> weakReference = this.f7492l;
        View view = weakReference != null ? weakReference.get() : null;
        if (context == null || view == null) {
            return;
        }
        Rect rect = new Rect();
        rect.set(this.f7484d);
        Rect rect2 = new Rect();
        view.getDrawingRect(rect2);
        WeakReference<FrameLayout> weakReference2 = this.f7493m;
        FrameLayout frameLayout = weakReference2 != null ? weakReference2.get() : null;
        if (frameLayout != null || C1653b.f7497a) {
            if (frameLayout == null) {
                frameLayout = (ViewGroup) view.getParent();
            }
            frameLayout.offsetDescendantRectToMyCoords(view, rect2);
        }
        m9679b(context, rect2, view);
        C1653b.m9704f(this.f7484d, this.f7486f, this.f7487g, this.f7490j, this.f7491k);
        this.f7482b.m63999Y(this.f7489i);
        if (rect.equals(this.f7484d)) {
            return;
        }
        this.f7482b.setBounds(this.f7484d);
    }

    /* renamed from: D */
    public final void m9677D() {
        this.f7488h = ((int) Math.pow(10.0d, m9684j() - 1.0d)) - 1;
    }

    @Override // com.google.android.material.internal.C1781l.b
    /* renamed from: a */
    public void mo9678a() {
        invalidateSelf();
    }

    /* renamed from: b */
    public final void m9679b(Context context, Rect rect, View view) throws Resources.NotFoundException {
        int iM9688n = m9688n();
        int iM9615f = this.f7485e.m9615f();
        if (iM9615f == 8388691 || iM9615f == 8388693) {
            this.f7487g = rect.bottom - iM9688n;
        } else {
            this.f7487g = rect.top + iM9688n;
        }
        if (m9685k() <= 9) {
            float f10 = !m9689o() ? this.f7485e.f7458c : this.f7485e.f7459d;
            this.f7489i = f10;
            this.f7491k = f10;
            this.f7490j = f10;
        } else {
            float f11 = this.f7485e.f7459d;
            this.f7489i = f11;
            this.f7491k = f11;
            this.f7490j = (this.f7483c.m10757f(m9680f()) / 2.0f) + this.f7485e.f7460e;
        }
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(m9689o() ? R$dimen.mtrl_badge_text_horizontal_edge_offset : R$dimen.mtrl_badge_horizontal_edge_offset);
        int iM9687m = m9687m();
        int iM9615f2 = this.f7485e.m9615f();
        if (iM9615f2 == 8388659 || iM9615f2 == 8388691) {
            this.f7486f = C9603h0.m59832A(view) == 0 ? (rect.left - this.f7490j) + dimensionPixelSize + iM9687m : ((rect.right + this.f7490j) - dimensionPixelSize) - iM9687m;
        } else {
            this.f7486f = C9603h0.m59832A(view) == 0 ? ((rect.right + this.f7490j) - dimensionPixelSize) - iM9687m : (rect.left - this.f7490j) + dimensionPixelSize + iM9687m;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (getBounds().isEmpty() || getAlpha() == 0 || !isVisible()) {
            return;
        }
        this.f7482b.draw(canvas);
        if (m9689o()) {
            m9672e(canvas);
        }
    }

    /* renamed from: f */
    public final String m9680f() {
        if (m9685k() <= this.f7488h) {
            return NumberFormat.getInstance(this.f7485e.m9624o()).format(m9685k());
        }
        Context context = this.f7481a.get();
        return context == null ? "" : String.format(this.f7485e.m9624o(), context.getString(R$string.mtrl_exceed_max_badge_number_suffix), Integer.valueOf(this.f7488h), "+");
    }

    /* renamed from: g */
    public CharSequence m9681g() {
        Context context;
        if (!isVisible()) {
            return null;
        }
        if (!m9689o()) {
            return this.f7485e.m9618i();
        }
        if (this.f7485e.m9619j() == 0 || (context = this.f7481a.get()) == null) {
            return null;
        }
        return m9685k() <= this.f7488h ? context.getResources().getQuantityString(this.f7485e.m9619j(), m9685k(), Integer.valueOf(m9685k())) : context.getString(this.f7485e.m9617h(), Integer.valueOf(this.f7488h));
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f7485e.m9613d();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f7484d.height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f7484d.width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    /* renamed from: h */
    public FrameLayout m9682h() {
        WeakReference<FrameLayout> weakReference = this.f7493m;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    /* renamed from: i */
    public int m9683i() {
        return this.f7485e.m9621l();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return false;
    }

    /* renamed from: j */
    public int m9684j() {
        return this.f7485e.m9622m();
    }

    /* renamed from: k */
    public int m9685k() {
        if (m9689o()) {
            return this.f7485e.m9623n();
        }
        return 0;
    }

    /* renamed from: l */
    public BadgeState.State m9686l() {
        return this.f7485e.m9625p();
    }

    /* renamed from: m */
    public final int m9687m() {
        return (m9689o() ? this.f7485e.m9620k() : this.f7485e.m9621l()) + this.f7485e.m9611b();
    }

    /* renamed from: n */
    public final int m9688n() {
        return (m9689o() ? this.f7485e.m9626q() : this.f7485e.m9627r()) + this.f7485e.m9612c();
    }

    /* renamed from: o */
    public boolean m9689o() {
        return this.f7485e.m9628s();
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.C1781l.b
    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    /* renamed from: p */
    public final void m9690p() {
        this.f7483c.m10756e().setAlpha(getAlpha());
        invalidateSelf();
    }

    /* renamed from: q */
    public final void m9691q() {
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(this.f7485e.m9614e());
        if (this.f7482b.m64033x() != colorStateListValueOf) {
            this.f7482b.m64002b0(colorStateListValueOf);
            invalidateSelf();
        }
    }

    /* renamed from: r */
    public final void m9692r() throws Resources.NotFoundException {
        WeakReference<View> weakReference = this.f7492l;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        View view = this.f7492l.get();
        WeakReference<FrameLayout> weakReference2 = this.f7493m;
        m9675B(view, weakReference2 != null ? weakReference2.get() : null);
    }

    /* renamed from: s */
    public final void m9693s() {
        this.f7483c.m10756e().setColor(this.f7485e.m9616g());
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f7485e.m9630v(i10);
        m9690p();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    /* renamed from: t */
    public final void m9694t() throws Resources.NotFoundException {
        m9677D();
        this.f7483c.m10760i(true);
        m9676C();
        invalidateSelf();
    }

    /* renamed from: u */
    public final void m9695u() throws Resources.NotFoundException {
        this.f7483c.m10760i(true);
        m9676C();
        invalidateSelf();
    }

    /* renamed from: v */
    public final void m9696v() {
        boolean zM9629t = this.f7485e.m9629t();
        setVisible(zM9629t, false);
        if (!C1653b.f7497a || m9682h() == null || zM9629t) {
            return;
        }
        ((ViewGroup) m9682h().getParent()).invalidate();
    }

    /* renamed from: w */
    public final void m9697w() throws Resources.NotFoundException {
        m9694t();
        m9695u();
        m9690p();
        m9691q();
        m9693s();
        m9692r();
        m9676C();
        m9696v();
    }

    /* renamed from: z */
    public final void m9698z(View view) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup == null || viewGroup.getId() != R$id.mtrl_anchor_parent) {
            WeakReference<FrameLayout> weakReference = this.f7493m;
            if (weakReference == null || weakReference.get() != viewGroup) {
                m9669A(view);
                FrameLayout frameLayout = new FrameLayout(view.getContext());
                frameLayout.setId(R$id.mtrl_anchor_parent);
                frameLayout.setClipChildren(false);
                frameLayout.setClipToPadding(false);
                frameLayout.setLayoutParams(view.getLayoutParams());
                frameLayout.setMinimumWidth(view.getWidth());
                frameLayout.setMinimumHeight(view.getHeight());
                int iIndexOfChild = viewGroup.indexOfChild(view);
                viewGroup.removeViewAt(iIndexOfChild);
                view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                frameLayout.addView(view);
                viewGroup.addView(frameLayout, iIndexOfChild);
                this.f7493m = new WeakReference<>(frameLayout);
                frameLayout.post(new a(view, frameLayout));
            }
        }
    }
}
