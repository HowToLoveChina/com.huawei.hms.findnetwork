package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import p273f0.C9603h0;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
class GhostViewPort extends ViewGroup implements InterfaceC0939f {

    /* renamed from: a */
    public ViewGroup f4743a;

    /* renamed from: b */
    public View f4744b;

    /* renamed from: c */
    public final View f4745c;

    /* renamed from: d */
    public int f4746d;

    /* renamed from: e */
    public Matrix f4747e;

    /* renamed from: f */
    public final ViewTreeObserver.OnPreDrawListener f4748f;

    /* renamed from: androidx.transition.GhostViewPort$a */
    public class ViewTreeObserverOnPreDrawListenerC0908a implements ViewTreeObserver.OnPreDrawListener {
        public ViewTreeObserverOnPreDrawListenerC0908a() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            View view;
            C9603h0.m59884g0(GhostViewPort.this);
            GhostViewPort ghostViewPort = GhostViewPort.this;
            ViewGroup viewGroup = ghostViewPort.f4743a;
            if (viewGroup == null || (view = ghostViewPort.f4744b) == null) {
                return true;
            }
            viewGroup.endViewTransition(view);
            C9603h0.m59884g0(GhostViewPort.this.f4743a);
            GhostViewPort ghostViewPort2 = GhostViewPort.this;
            ghostViewPort2.f4743a = null;
            ghostViewPort2.f4744b = null;
            return true;
        }
    }

    public GhostViewPort(View view) {
        super(view.getContext());
        this.f4748f = new ViewTreeObserverOnPreDrawListenerC0908a();
        this.f4745c = view;
        setWillNotDraw(false);
        setLayerType(2, null);
    }

    /* renamed from: b */
    public static GhostViewPort m5686b(View view, ViewGroup viewGroup, Matrix matrix) {
        int i10;
        GhostViewHolder ghostViewHolder;
        if (!(view.getParent() instanceof ViewGroup)) {
            throw new IllegalArgumentException("Ghosted views must be parented by a ViewGroup");
        }
        GhostViewHolder ghostViewHolderM5679b = GhostViewHolder.m5679b(viewGroup);
        GhostViewPort ghostViewPortM5689e = m5689e(view);
        if (ghostViewPortM5689e == null || (ghostViewHolder = (GhostViewHolder) ghostViewPortM5689e.getParent()) == ghostViewHolderM5679b) {
            i10 = 0;
        } else {
            i10 = ghostViewPortM5689e.f4746d;
            ghostViewHolder.removeView(ghostViewPortM5689e);
            ghostViewPortM5689e = null;
        }
        if (ghostViewPortM5689e == null) {
            if (matrix == null) {
                matrix = new Matrix();
                m5687c(view, viewGroup, matrix);
            }
            ghostViewPortM5689e = new GhostViewPort(view);
            ghostViewPortM5689e.m5693h(matrix);
            if (ghostViewHolderM5679b == null) {
                ghostViewHolderM5679b = new GhostViewHolder(viewGroup);
            } else {
                ghostViewHolderM5679b.m5685g();
            }
            m5688d(viewGroup, ghostViewHolderM5679b);
            m5688d(viewGroup, ghostViewPortM5689e);
            ghostViewHolderM5679b.m5683a(ghostViewPortM5689e);
            ghostViewPortM5689e.f4746d = i10;
        } else if (matrix != null) {
            ghostViewPortM5689e.m5693h(matrix);
        }
        ghostViewPortM5689e.f4746d++;
        return ghostViewPortM5689e;
    }

    /* renamed from: c */
    public static void m5687c(View view, ViewGroup viewGroup, Matrix matrix) {
        ViewGroup viewGroup2 = (ViewGroup) view.getParent();
        matrix.reset();
        C0932b0.m5793j(viewGroup2, matrix);
        matrix.preTranslate(-viewGroup2.getScrollX(), -viewGroup2.getScrollY());
        C0932b0.m5794k(viewGroup, matrix);
    }

    /* renamed from: d */
    public static void m5688d(View view, View view2) {
        C0932b0.m5790g(view2, view2.getLeft(), view2.getTop(), view2.getLeft() + view.getWidth(), view2.getTop() + view.getHeight());
    }

    /* renamed from: e */
    public static GhostViewPort m5689e(View view) {
        return (GhostViewPort) view.getTag(R$id.ghost_view);
    }

    /* renamed from: f */
    public static void m5690f(View view) {
        GhostViewPort ghostViewPortM5689e = m5689e(view);
        if (ghostViewPortM5689e != null) {
            int i10 = ghostViewPortM5689e.f4746d - 1;
            ghostViewPortM5689e.f4746d = i10;
            if (i10 <= 0) {
                ((GhostViewHolder) ghostViewPortM5689e.getParent()).removeView(ghostViewPortM5689e);
            }
        }
    }

    /* renamed from: g */
    public static void m5691g(View view, GhostViewPort ghostViewPort) {
        view.setTag(R$id.ghost_view, ghostViewPort);
    }

    @Override // androidx.transition.InterfaceC0939f
    /* renamed from: a */
    public void mo5692a(ViewGroup viewGroup, View view) {
        this.f4743a = viewGroup;
        this.f4744b = view;
    }

    /* renamed from: h */
    public void m5693h(Matrix matrix) {
        this.f4747e = matrix;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m5691g(this.f4745c, this);
        this.f4745c.getViewTreeObserver().addOnPreDrawListener(this.f4748f);
        C0932b0.m5792i(this.f4745c, 4);
        if (this.f4745c.getParent() != null) {
            ((View) this.f4745c.getParent()).invalidate();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.f4745c.getViewTreeObserver().removeOnPreDrawListener(this.f4748f);
        C0932b0.m5792i(this.f4745c, 0);
        m5691g(this.f4745c, null);
        if (this.f4745c.getParent() != null) {
            ((View) this.f4745c.getParent()).invalidate();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        C0931b.m5783a(canvas, true);
        canvas.setMatrix(this.f4747e);
        C0932b0.m5792i(this.f4745c, 0);
        this.f4745c.invalidate();
        C0932b0.m5792i(this.f4745c, 4);
        drawChild(canvas, this.f4745c, getDrawingTime());
        C0931b.m5783a(canvas, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
    }

    @Override // android.view.View, androidx.transition.InterfaceC0939f
    public void setVisibility(int i10) {
        super.setVisibility(i10);
        if (m5689e(this.f4745c) == this) {
            C0932b0.m5792i(this.f4745c, i10 == 0 ? 4 : 0);
        }
    }
}
