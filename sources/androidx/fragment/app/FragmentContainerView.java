package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.fragment.R$styleable;
import com.huawei.openalliance.p169ad.constant.ParamConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p273f0.C9603h0;
import p273f0.C9625s0;
import p692uw.C13264g;
import p692uw.C13267j;

/* loaded from: classes.dex */
public final class FragmentContainerView extends FrameLayout {

    /* renamed from: a */
    public final List<View> f3783a;

    /* renamed from: b */
    public final List<View> f3784b;

    /* renamed from: c */
    public View.OnApplyWindowInsetsListener f3785c;

    /* renamed from: d */
    public boolean f3786d;

    /* renamed from: androidx.fragment.app.FragmentContainerView$a */
    public static final class C0714a {

        /* renamed from: a */
        public static final C0714a f3787a = new C0714a();

        /* renamed from: a */
        public final WindowInsets m4490a(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener, View view, WindowInsets windowInsets) {
            C13267j.m79677e(onApplyWindowInsetsListener, "onApplyWindowInsetsListener");
            C13267j.m79677e(view, "v");
            C13267j.m79677e(windowInsets, "insets");
            WindowInsets windowInsetsOnApplyWindowInsets = onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            C13267j.m79676d(windowInsetsOnApplyWindowInsets, "onApplyWindowInsetsListe…lyWindowInsets(v, insets)");
            return windowInsetsOnApplyWindowInsets;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FragmentContainerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        C13267j.m79677e(context, ParamConstants.Param.CONTEXT);
    }

    /* renamed from: a */
    public final void m4489a(View view) {
        if (this.f3784b.contains(view)) {
            this.f3783a.add(view);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        C13267j.m79677e(view, "child");
        if (FragmentManager.m4491C0(view) != null) {
            super.addView(view, i10, layoutParams);
            return;
        }
        throw new IllegalStateException(("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.").toString());
    }

    @Override // android.view.ViewGroup, android.view.View
    public WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        C9625s0 c9625s0M59874b0;
        C13267j.m79677e(windowInsets, "insets");
        C9625s0 c9625s0M60147v = C9625s0.m60147v(windowInsets);
        C13267j.m79676d(c9625s0M60147v, "toWindowInsetsCompat(insets)");
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.f3785c;
        if (onApplyWindowInsetsListener != null) {
            C0714a c0714a = C0714a.f3787a;
            C13267j.m79674b(onApplyWindowInsetsListener);
            c9625s0M59874b0 = C9625s0.m60147v(c0714a.m4490a(onApplyWindowInsetsListener, this, windowInsets));
        } else {
            c9625s0M59874b0 = C9603h0.m59874b0(this, c9625s0M60147v);
        }
        C13267j.m79676d(c9625s0M59874b0, "if (applyWindowInsetsLis…, insetsCompat)\n        }");
        if (!c9625s0M59874b0.m60163p()) {
            int childCount = getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                C9603h0.m59885h(getChildAt(i10), c9625s0M59874b0);
            }
        }
        return windowInsets;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        C13267j.m79677e(canvas, "canvas");
        if (this.f3786d) {
            Iterator<T> it = this.f3783a.iterator();
            while (it.hasNext()) {
                super.drawChild(canvas, (View) it.next(), getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j10) {
        C13267j.m79677e(canvas, "canvas");
        C13267j.m79677e(view, "child");
        if (this.f3786d && (!this.f3783a.isEmpty()) && this.f3783a.contains(view)) {
            return false;
        }
        return super.drawChild(canvas, view, j10);
    }

    @Override // android.view.ViewGroup
    public void endViewTransition(View view) {
        C13267j.m79677e(view, "view");
        this.f3784b.remove(view);
        if (this.f3783a.remove(view)) {
            this.f3786d = true;
        }
        super.endViewTransition(view);
    }

    public final <F extends Fragment> F getFragment() {
        return (F) FragmentManager.m4503k0(this).m4568h0(getId());
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        C13267j.m79677e(windowInsets, "insets");
        return windowInsets;
    }

    @Override // android.view.ViewGroup
    public void removeAllViewsInLayout() {
        int childCount = getChildCount();
        while (true) {
            childCount--;
            if (-1 >= childCount) {
                super.removeAllViewsInLayout();
                return;
            } else {
                View childAt = getChildAt(childCount);
                C13267j.m79676d(childAt, "view");
                m4489a(childAt);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        C13267j.m79677e(view, "view");
        m4489a(view);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i10) {
        View childAt = getChildAt(i10);
        C13267j.m79676d(childAt, "view");
        m4489a(childAt);
        super.removeViewAt(i10);
    }

    @Override // android.view.ViewGroup
    public void removeViewInLayout(View view) {
        C13267j.m79677e(view, "view");
        m4489a(view);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public void removeViews(int i10, int i11) {
        int i12 = i10 + i11;
        for (int i13 = i10; i13 < i12; i13++) {
            View childAt = getChildAt(i13);
            C13267j.m79676d(childAt, "view");
            m4489a(childAt);
        }
        super.removeViews(i10, i11);
    }

    @Override // android.view.ViewGroup
    public void removeViewsInLayout(int i10, int i11) {
        int i12 = i10 + i11;
        for (int i13 = i10; i13 < i12; i13++) {
            View childAt = getChildAt(i13);
            C13267j.m79676d(childAt, "view");
            m4489a(childAt);
        }
        super.removeViewsInLayout(i10, i11);
    }

    public final void setDrawDisappearingViewsLast(boolean z10) {
        this.f3786d = z10;
    }

    @Override // android.view.ViewGroup
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    @Override // android.view.View
    public void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        C13267j.m79677e(onApplyWindowInsetsListener, ParamConstants.Param.LISTENER);
        this.f3785c = onApplyWindowInsetsListener;
    }

    @Override // android.view.ViewGroup
    public void startViewTransition(View view) {
        C13267j.m79677e(view, "view");
        if (view.getParent() == this) {
            this.f3784b.add(view);
        }
        super.startViewTransition(view);
    }

    public /* synthetic */ FragmentContainerView(Context context, AttributeSet attributeSet, int i10, int i11, C13264g c13264g) {
        this(context, attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentContainerView(Context context) {
        super(context);
        C13267j.m79677e(context, ParamConstants.Param.CONTEXT);
        this.f3783a = new ArrayList();
        this.f3784b = new ArrayList();
        this.f3786d = true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentContainerView(Context context, AttributeSet attributeSet, int i10) {
        String str;
        super(context, attributeSet, i10);
        C13267j.m79677e(context, ParamConstants.Param.CONTEXT);
        this.f3783a = new ArrayList();
        this.f3784b = new ArrayList();
        this.f3786d = true;
        if (attributeSet != null) {
            String classAttribute = attributeSet.getClassAttribute();
            int[] iArr = R$styleable.FragmentContainerView;
            C13267j.m79676d(iArr, "FragmentContainerView");
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, 0, 0);
            if (classAttribute == null) {
                classAttribute = typedArrayObtainStyledAttributes.getString(R$styleable.FragmentContainerView_android_name);
                str = "android:name";
            } else {
                str = "class";
            }
            typedArrayObtainStyledAttributes.recycle();
            if (classAttribute == null || isInEditMode()) {
                return;
            }
            throw new UnsupportedOperationException("FragmentContainerView must be within a FragmentActivity to use " + str + "=\"" + classAttribute + '\"');
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentContainerView(Context context, AttributeSet attributeSet, FragmentManager fragmentManager) {
        String str;
        super(context, attributeSet);
        C13267j.m79677e(context, ParamConstants.Param.CONTEXT);
        C13267j.m79677e(attributeSet, "attrs");
        C13267j.m79677e(fragmentManager, "fm");
        this.f3783a = new ArrayList();
        this.f3784b = new ArrayList();
        this.f3786d = true;
        String classAttribute = attributeSet.getClassAttribute();
        int[] iArr = R$styleable.FragmentContainerView;
        C13267j.m79676d(iArr, "FragmentContainerView");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, 0, 0);
        classAttribute = classAttribute == null ? typedArrayObtainStyledAttributes.getString(R$styleable.FragmentContainerView_android_name) : classAttribute;
        String string = typedArrayObtainStyledAttributes.getString(R$styleable.FragmentContainerView_android_tag);
        typedArrayObtainStyledAttributes.recycle();
        int id2 = getId();
        Fragment fragmentM4568h0 = fragmentManager.m4568h0(id2);
        if (classAttribute != null && fragmentM4568h0 == null) {
            if (id2 == -1) {
                if (string != null) {
                    str = " with tag " + string;
                } else {
                    str = "";
                }
                throw new IllegalStateException("FragmentContainerView must have an android:id to add Fragment " + classAttribute + str);
            }
            Fragment fragmentMo4623a = fragmentManager.m4601t0().mo4623a(context.getClassLoader(), classAttribute);
            C13267j.m79676d(fragmentMo4623a, "fm.fragmentFactory.insta…ontext.classLoader, name)");
            fragmentMo4623a.m4451x0(context, attributeSet, null);
            fragmentManager.m4585o().m4671u(true).m4664d(this, fragmentMo4623a, string).mo4650k();
        }
        fragmentManager.m4550X0(this);
    }
}
