package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.core.content.res.TypedArrayUtils;
import org.xmlpull.v1.XmlPullParser;
import p273f0.C9603h0;

/* loaded from: classes.dex */
public class Slide extends Visibility {

    /* renamed from: O */
    public static final TimeInterpolator f4753O = new DecelerateInterpolator();

    /* renamed from: P */
    public static final TimeInterpolator f4754P = new AccelerateInterpolator();

    /* renamed from: Q */
    public static final InterfaceC0915g f4755Q = new C0909a();

    /* renamed from: R */
    public static final InterfaceC0915g f4756R = new C0910b();

    /* renamed from: S */
    public static final InterfaceC0915g f4757S = new C0911c();

    /* renamed from: T */
    public static final InterfaceC0915g f4758T = new C0912d();

    /* renamed from: U */
    public static final InterfaceC0915g f4759U = new C0913e();

    /* renamed from: V */
    public static final InterfaceC0915g f4760V = new C0914f();

    /* renamed from: M */
    public InterfaceC0915g f4761M;

    /* renamed from: N */
    public int f4762N;

    /* renamed from: androidx.transition.Slide$a */
    public static class C0909a extends AbstractC0916h {
        public C0909a() {
            super(null);
        }

        @Override // androidx.transition.Slide.InterfaceC0915g
        /* renamed from: b */
        public float mo5698b(ViewGroup viewGroup, View view) {
            return view.getTranslationX() - viewGroup.getWidth();
        }
    }

    /* renamed from: androidx.transition.Slide$b */
    public static class C0910b extends AbstractC0916h {
        public C0910b() {
            super(null);
        }

        @Override // androidx.transition.Slide.InterfaceC0915g
        /* renamed from: b */
        public float mo5698b(ViewGroup viewGroup, View view) {
            return C9603h0.m59832A(viewGroup) == 1 ? view.getTranslationX() + viewGroup.getWidth() : view.getTranslationX() - viewGroup.getWidth();
        }
    }

    /* renamed from: androidx.transition.Slide$c */
    public static class C0911c extends AbstractC0917i {
        public C0911c() {
            super(null);
        }

        @Override // androidx.transition.Slide.InterfaceC0915g
        /* renamed from: a */
        public float mo5699a(ViewGroup viewGroup, View view) {
            return view.getTranslationY() - viewGroup.getHeight();
        }
    }

    /* renamed from: androidx.transition.Slide$d */
    public static class C0912d extends AbstractC0916h {
        public C0912d() {
            super(null);
        }

        @Override // androidx.transition.Slide.InterfaceC0915g
        /* renamed from: b */
        public float mo5698b(ViewGroup viewGroup, View view) {
            return view.getTranslationX() + viewGroup.getWidth();
        }
    }

    /* renamed from: androidx.transition.Slide$e */
    public static class C0913e extends AbstractC0916h {
        public C0913e() {
            super(null);
        }

        @Override // androidx.transition.Slide.InterfaceC0915g
        /* renamed from: b */
        public float mo5698b(ViewGroup viewGroup, View view) {
            return C9603h0.m59832A(viewGroup) == 1 ? view.getTranslationX() - viewGroup.getWidth() : view.getTranslationX() + viewGroup.getWidth();
        }
    }

    /* renamed from: androidx.transition.Slide$f */
    public static class C0914f extends AbstractC0917i {
        public C0914f() {
            super(null);
        }

        @Override // androidx.transition.Slide.InterfaceC0915g
        /* renamed from: a */
        public float mo5699a(ViewGroup viewGroup, View view) {
            return view.getTranslationY() + viewGroup.getHeight();
        }
    }

    /* renamed from: androidx.transition.Slide$g */
    public interface InterfaceC0915g {
        /* renamed from: a */
        float mo5699a(ViewGroup viewGroup, View view);

        /* renamed from: b */
        float mo5698b(ViewGroup viewGroup, View view);
    }

    /* renamed from: androidx.transition.Slide$h */
    public static abstract class AbstractC0916h implements InterfaceC0915g {
        public AbstractC0916h() {
        }

        @Override // androidx.transition.Slide.InterfaceC0915g
        /* renamed from: a */
        public float mo5699a(ViewGroup viewGroup, View view) {
            return view.getTranslationY();
        }

        public /* synthetic */ AbstractC0916h(C0909a c0909a) {
            this();
        }
    }

    /* renamed from: androidx.transition.Slide$i */
    public static abstract class AbstractC0917i implements InterfaceC0915g {
        public AbstractC0917i() {
        }

        @Override // androidx.transition.Slide.InterfaceC0915g
        /* renamed from: b */
        public float mo5698b(ViewGroup viewGroup, View view) {
            return view.getTranslationX();
        }

        public /* synthetic */ AbstractC0917i(C0909a c0909a) {
            this();
        }
    }

    public Slide() {
        this.f4761M = f4760V;
        this.f4762N = 80;
        m5697r0(80);
    }

    /* renamed from: j0 */
    private void m5696j0(C0959t c0959t) {
        int[] iArr = new int[2];
        c0959t.f4889b.getLocationOnScreen(iArr);
        c0959t.f4888a.put("android:slide:screenPosition", iArr);
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    /* renamed from: i */
    public void mo5618i(C0959t c0959t) {
        super.mo5618i(c0959t);
        m5696j0(c0959t);
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    /* renamed from: l */
    public void mo5621l(C0959t c0959t) {
        super.mo5621l(c0959t);
        m5696j0(c0959t);
    }

    @Override // androidx.transition.Visibility
    /* renamed from: m0 */
    public Animator mo5674m0(ViewGroup viewGroup, View view, C0959t c0959t, C0959t c0959t2) {
        if (c0959t2 == null) {
            return null;
        }
        int[] iArr = (int[]) c0959t2.f4888a.get("android:slide:screenPosition");
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        return C0961v.m5841a(view, c0959t2, iArr[0], iArr[1], this.f4761M.mo5698b(viewGroup, view), this.f4761M.mo5699a(viewGroup, view), translationX, translationY, f4753O, this);
    }

    @Override // androidx.transition.Visibility
    /* renamed from: o0 */
    public Animator mo5675o0(ViewGroup viewGroup, View view, C0959t c0959t, C0959t c0959t2) {
        if (c0959t == null) {
            return null;
        }
        int[] iArr = (int[]) c0959t.f4888a.get("android:slide:screenPosition");
        return C0961v.m5841a(view, c0959t, iArr[0], iArr[1], view.getTranslationX(), view.getTranslationY(), this.f4761M.mo5698b(viewGroup, view), this.f4761M.mo5699a(viewGroup, view), f4754P, this);
    }

    /* renamed from: r0 */
    public void m5697r0(int i10) {
        if (i10 == 3) {
            this.f4761M = f4755Q;
        } else if (i10 == 5) {
            this.f4761M = f4758T;
        } else if (i10 == 48) {
            this.f4761M = f4757S;
        } else if (i10 == 80) {
            this.f4761M = f4760V;
        } else if (i10 == 8388611) {
            this.f4761M = f4756R;
        } else {
            if (i10 != 8388613) {
                throw new IllegalArgumentException("Invalid slide direction");
            }
            this.f4761M = f4759U;
        }
        this.f4762N = i10;
        C0953n c0953n = new C0953n();
        c0953n.m5831j(i10);
        mo5734f0(c0953n);
    }

    @SuppressLint({"RestrictedApi"})
    public Slide(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4761M = f4760V;
        this.f4762N = 80;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0954o.f4871h);
        int namedInt = TypedArrayUtils.getNamedInt(typedArrayObtainStyledAttributes, (XmlPullParser) attributeSet, "slideEdge", 0, 80);
        typedArrayObtainStyledAttributes.recycle();
        m5697r0(namedInt);
    }
}
