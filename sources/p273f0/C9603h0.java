package p273f0;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ContentInfo;
import android.view.Display;
import android.view.KeyEvent;
import android.view.OnReceiveContentListener;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.core.R$id;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import p273f0.C9582a;
import p273f0.C9603h0;
import p273f0.C9625s0;
import p304g0.C9832l;
import p304g0.InterfaceC9835o;
import p438l.C11213g;

@SuppressLint({"PrivateConstructorForUtilityClass"})
/* renamed from: f0.h0 */
/* loaded from: classes.dex */
public class C9603h0 {

    /* renamed from: a */
    public static final AtomicInteger f47705a = new AtomicInteger(1);

    /* renamed from: b */
    public static WeakHashMap<View, C9615n0> f47706b = null;

    /* renamed from: c */
    public static boolean f47707c = false;

    /* renamed from: d */
    public static final int[] f47708d = {R$id.accessibility_custom_action_0, R$id.accessibility_custom_action_1, R$id.accessibility_custom_action_2, R$id.accessibility_custom_action_3, R$id.accessibility_custom_action_4, R$id.accessibility_custom_action_5, R$id.accessibility_custom_action_6, R$id.accessibility_custom_action_7, R$id.accessibility_custom_action_8, R$id.accessibility_custom_action_9, R$id.accessibility_custom_action_10, R$id.accessibility_custom_action_11, R$id.accessibility_custom_action_12, R$id.accessibility_custom_action_13, R$id.accessibility_custom_action_14, R$id.accessibility_custom_action_15, R$id.accessibility_custom_action_16, R$id.accessibility_custom_action_17, R$id.accessibility_custom_action_18, R$id.accessibility_custom_action_19, R$id.accessibility_custom_action_20, R$id.accessibility_custom_action_21, R$id.accessibility_custom_action_22, R$id.accessibility_custom_action_23, R$id.accessibility_custom_action_24, R$id.accessibility_custom_action_25, R$id.accessibility_custom_action_26, R$id.accessibility_custom_action_27, R$id.accessibility_custom_action_28, R$id.accessibility_custom_action_29, R$id.accessibility_custom_action_30, R$id.accessibility_custom_action_31};

    /* renamed from: e */
    public static final InterfaceC9592d0 f47709e = new InterfaceC9592d0() { // from class: f0.g0
        @Override // p273f0.InterfaceC9592d0
        /* renamed from: a */
        public final C9588c mo2626a(C9588c c9588c) {
            return C9603h0.m59868X(c9588c);
        }
    };

    /* renamed from: f */
    public static final e f47710f = new e();

    /* renamed from: f0.h0$a */
    public class a extends f<Boolean> {
        public a(int i10, Class cls, int i11) {
            super(i10, cls, i11);
        }

        @Override // p273f0.C9603h0.f
        /* renamed from: i */
        public Boolean mo59923d(View view) {
            return Boolean.valueOf(q.m60045d(view));
        }

        @Override // p273f0.C9603h0.f
        /* renamed from: j */
        public void mo59924e(View view, Boolean bool) {
            q.m60050i(view, bool.booleanValue());
        }

        @Override // p273f0.C9603h0.f
        /* renamed from: k */
        public boolean mo59925h(Boolean bool, Boolean bool2) {
            return !m59942a(bool, bool2);
        }
    }

    /* renamed from: f0.h0$b */
    public class b extends f<CharSequence> {
        public b(int i10, Class cls, int i11, int i12) {
            super(i10, cls, i11, i12);
        }

        @Override // p273f0.C9603h0.f
        /* renamed from: i */
        public CharSequence mo59923d(View view) {
            return q.m60043b(view);
        }

        @Override // p273f0.C9603h0.f
        /* renamed from: j */
        public void mo59924e(View view, CharSequence charSequence) {
            q.m60049h(view, charSequence);
        }

        @Override // p273f0.C9603h0.f
        /* renamed from: k */
        public boolean mo59925h(CharSequence charSequence, CharSequence charSequence2) {
            return !TextUtils.equals(charSequence, charSequence2);
        }
    }

    /* renamed from: f0.h0$c */
    public class c extends f<CharSequence> {
        public c(int i10, Class cls, int i11, int i12) {
            super(i10, cls, i11, i12);
        }

        @Override // p273f0.C9603h0.f
        /* renamed from: i */
        public CharSequence mo59923d(View view) {
            return s.m60055a(view);
        }

        @Override // p273f0.C9603h0.f
        /* renamed from: j */
        public void mo59924e(View view, CharSequence charSequence) {
            s.m60056b(view, charSequence);
        }

        @Override // p273f0.C9603h0.f
        /* renamed from: k */
        public boolean mo59925h(CharSequence charSequence, CharSequence charSequence2) {
            return !TextUtils.equals(charSequence, charSequence2);
        }
    }

    /* renamed from: f0.h0$d */
    public class d extends f<Boolean> {
        public d(int i10, Class cls, int i11) {
            super(i10, cls, i11);
        }

        @Override // p273f0.C9603h0.f
        /* renamed from: i */
        public Boolean mo59923d(View view) {
            return Boolean.valueOf(q.m60044c(view));
        }

        @Override // p273f0.C9603h0.f
        /* renamed from: j */
        public void mo59924e(View view, Boolean bool) {
            q.m60048g(view, bool.booleanValue());
        }

        @Override // p273f0.C9603h0.f
        /* renamed from: k */
        public boolean mo59925h(Boolean bool, Boolean bool2) {
            return !m59942a(bool, bool2);
        }
    }

    /* renamed from: f0.h0$e */
    public static class e implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {

        /* renamed from: a */
        public final WeakHashMap<View, Boolean> f47711a = new WeakHashMap<>();

        /* renamed from: a */
        public void m59938a(View view) {
            this.f47711a.put(view, Boolean.valueOf(view.isShown() && view.getWindowVisibility() == 0));
            view.addOnAttachStateChangeListener(this);
            if (k.m59982b(view)) {
                m59939b(view);
            }
        }

        /* renamed from: b */
        public final void m59939b(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        /* renamed from: c */
        public void m59940c(View view) {
            this.f47711a.remove(view);
            view.removeOnAttachStateChangeListener(this);
            m59941d(view);
        }

        /* renamed from: d */
        public final void m59941d(View view) {
            h.m59962o(view.getViewTreeObserver(), this);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            m59939b(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    /* renamed from: f0.h0$g */
    public static class g {
        /* renamed from: a */
        public static boolean m59947a(View view) {
            return view.hasOnClickListeners();
        }
    }

    /* renamed from: f0.h0$h */
    public static class h {
        /* renamed from: a */
        public static AccessibilityNodeProvider m59948a(View view) {
            return view.getAccessibilityNodeProvider();
        }

        /* renamed from: b */
        public static boolean m59949b(View view) {
            return view.getFitsSystemWindows();
        }

        /* renamed from: c */
        public static int m59950c(View view) {
            return view.getImportantForAccessibility();
        }

        /* renamed from: d */
        public static int m59951d(View view) {
            return view.getMinimumHeight();
        }

        /* renamed from: e */
        public static int m59952e(View view) {
            return view.getMinimumWidth();
        }

        /* renamed from: f */
        public static ViewParent m59953f(View view) {
            return view.getParentForAccessibility();
        }

        /* renamed from: g */
        public static int m59954g(View view) {
            return view.getWindowSystemUiVisibility();
        }

        /* renamed from: h */
        public static boolean m59955h(View view) {
            return view.hasOverlappingRendering();
        }

        /* renamed from: i */
        public static boolean m59956i(View view) {
            return view.hasTransientState();
        }

        /* renamed from: j */
        public static boolean m59957j(View view, int i10, Bundle bundle) {
            return view.performAccessibilityAction(i10, bundle);
        }

        /* renamed from: k */
        public static void m59958k(View view) {
            view.postInvalidateOnAnimation();
        }

        /* renamed from: l */
        public static void m59959l(View view, int i10, int i11, int i12, int i13) {
            view.postInvalidateOnAnimation(i10, i11, i12, i13);
        }

        /* renamed from: m */
        public static void m59960m(View view, Runnable runnable) {
            view.postOnAnimation(runnable);
        }

        /* renamed from: n */
        public static void m59961n(View view, Runnable runnable, long j10) {
            view.postOnAnimationDelayed(runnable, j10);
        }

        /* renamed from: o */
        public static void m59962o(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
            viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }

        /* renamed from: p */
        public static void m59963p(View view) {
            view.requestFitSystemWindows();
        }

        /* renamed from: q */
        public static void m59964q(View view, Drawable drawable) {
            view.setBackground(drawable);
        }

        /* renamed from: r */
        public static void m59965r(View view, boolean z10) {
            view.setHasTransientState(z10);
        }

        /* renamed from: s */
        public static void m59966s(View view, int i10) {
            view.setImportantForAccessibility(i10);
        }
    }

    /* renamed from: f0.h0$i */
    public static class i {
        /* renamed from: a */
        public static int m59967a() {
            return View.generateViewId();
        }

        /* renamed from: b */
        public static Display m59968b(View view) {
            return view.getDisplay();
        }

        /* renamed from: c */
        public static int m59969c(View view) {
            return view.getLabelFor();
        }

        /* renamed from: d */
        public static int m59970d(View view) {
            return view.getLayoutDirection();
        }

        /* renamed from: e */
        public static int m59971e(View view) {
            return view.getPaddingEnd();
        }

        /* renamed from: f */
        public static int m59972f(View view) {
            return view.getPaddingStart();
        }

        /* renamed from: g */
        public static boolean m59973g(View view) {
            return view.isPaddingRelative();
        }

        /* renamed from: h */
        public static void m59974h(View view, int i10) {
            view.setLabelFor(i10);
        }

        /* renamed from: i */
        public static void m59975i(View view, Paint paint) {
            view.setLayerPaint(paint);
        }

        /* renamed from: j */
        public static void m59976j(View view, int i10) {
            view.setLayoutDirection(i10);
        }

        /* renamed from: k */
        public static void m59977k(View view, int i10, int i11, int i12, int i13) {
            view.setPaddingRelative(i10, i11, i12, i13);
        }
    }

    /* renamed from: f0.h0$j */
    public static class j {
        /* renamed from: a */
        public static Rect m59978a(View view) {
            return view.getClipBounds();
        }

        /* renamed from: b */
        public static boolean m59979b(View view) {
            return view.isInLayout();
        }

        /* renamed from: c */
        public static void m59980c(View view, Rect rect) {
            view.setClipBounds(rect);
        }
    }

    /* renamed from: f0.h0$k */
    public static class k {
        /* renamed from: a */
        public static int m59981a(View view) {
            return view.getAccessibilityLiveRegion();
        }

        /* renamed from: b */
        public static boolean m59982b(View view) {
            return view.isAttachedToWindow();
        }

        /* renamed from: c */
        public static boolean m59983c(View view) {
            return view.isLaidOut();
        }

        /* renamed from: d */
        public static boolean m59984d(View view) {
            return view.isLayoutDirectionResolved();
        }

        /* renamed from: e */
        public static void m59985e(ViewParent viewParent, View view, View view2, int i10) {
            viewParent.notifySubtreeAccessibilityStateChanged(view, view2, i10);
        }

        /* renamed from: f */
        public static void m59986f(View view, int i10) {
            view.setAccessibilityLiveRegion(i10);
        }

        /* renamed from: g */
        public static void m59987g(AccessibilityEvent accessibilityEvent, int i10) {
            accessibilityEvent.setContentChangeTypes(i10);
        }
    }

    /* renamed from: f0.h0$l */
    public static class l {
        /* renamed from: a */
        public static WindowInsets m59988a(View view, WindowInsets windowInsets) {
            return view.dispatchApplyWindowInsets(windowInsets);
        }

        /* renamed from: b */
        public static WindowInsets m59989b(View view, WindowInsets windowInsets) {
            return view.onApplyWindowInsets(windowInsets);
        }

        /* renamed from: c */
        public static void m59990c(View view) {
            view.requestApplyInsets();
        }
    }

    /* renamed from: f0.h0$m */
    public static class m {

        /* renamed from: f0.h0$m$a */
        public class a implements View.OnApplyWindowInsetsListener {

            /* renamed from: a */
            public C9625s0 f47716a = null;

            /* renamed from: b */
            public final /* synthetic */ View f47717b;

            /* renamed from: c */
            public final /* synthetic */ InterfaceC9586b0 f47718c;

            public a(View view, InterfaceC9586b0 interfaceC9586b0) {
                this.f47717b = view;
                this.f47718c = interfaceC9586b0;
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                C9625s0 c9625s0M60148w = C9625s0.m60148w(windowInsets, view);
                int i10 = Build.VERSION.SDK_INT;
                if (i10 < 30) {
                    m.m59991a(windowInsets, this.f47717b);
                    if (c9625s0M60148w.equals(this.f47716a)) {
                        return this.f47718c.onApplyWindowInsets(view, c9625s0M60148w).m60168u();
                    }
                }
                this.f47716a = c9625s0M60148w;
                C9625s0 c9625s0OnApplyWindowInsets = this.f47718c.onApplyWindowInsets(view, c9625s0M60148w);
                if (i10 >= 30) {
                    return c9625s0OnApplyWindowInsets.m60168u();
                }
                C9603h0.m59896m0(view);
                return c9625s0OnApplyWindowInsets.m60168u();
            }
        }

        /* renamed from: a */
        public static void m59991a(WindowInsets windowInsets, View view) {
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(R$id.tag_window_insets_animation_callback);
            if (onApplyWindowInsetsListener != null) {
                onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            }
        }

        /* renamed from: b */
        public static C9625s0 m59992b(View view, C9625s0 c9625s0, Rect rect) {
            WindowInsets windowInsetsM60168u = c9625s0.m60168u();
            if (windowInsetsM60168u != null) {
                return C9625s0.m60148w(view.computeSystemWindowInsets(windowInsetsM60168u, rect), view);
            }
            rect.setEmpty();
            return c9625s0;
        }

        /* renamed from: c */
        public static boolean m59993c(View view, float f10, float f11, boolean z10) {
            return view.dispatchNestedFling(f10, f11, z10);
        }

        /* renamed from: d */
        public static boolean m59994d(View view, float f10, float f11) {
            return view.dispatchNestedPreFling(f10, f11);
        }

        /* renamed from: e */
        public static boolean m59995e(View view, int i10, int i11, int[] iArr, int[] iArr2) {
            return view.dispatchNestedPreScroll(i10, i11, iArr, iArr2);
        }

        /* renamed from: f */
        public static boolean m59996f(View view, int i10, int i11, int i12, int i13, int[] iArr) {
            return view.dispatchNestedScroll(i10, i11, i12, i13, iArr);
        }

        /* renamed from: g */
        public static ColorStateList m59997g(View view) {
            return view.getBackgroundTintList();
        }

        /* renamed from: h */
        public static PorterDuff.Mode m59998h(View view) {
            return view.getBackgroundTintMode();
        }

        /* renamed from: i */
        public static float m59999i(View view) {
            return view.getElevation();
        }

        /* renamed from: j */
        public static C9625s0 m60000j(View view) {
            return C9625s0.a.m60169a(view);
        }

        /* renamed from: k */
        public static String m60001k(View view) {
            return view.getTransitionName();
        }

        /* renamed from: l */
        public static float m60002l(View view) {
            return view.getTranslationZ();
        }

        /* renamed from: m */
        public static float m60003m(View view) {
            return view.getZ();
        }

        /* renamed from: n */
        public static boolean m60004n(View view) {
            return view.hasNestedScrollingParent();
        }

        /* renamed from: o */
        public static boolean m60005o(View view) {
            return view.isImportantForAccessibility();
        }

        /* renamed from: p */
        public static boolean m60006p(View view) {
            return view.isNestedScrollingEnabled();
        }

        /* renamed from: q */
        public static void m60007q(View view, ColorStateList colorStateList) {
            view.setBackgroundTintList(colorStateList);
        }

        /* renamed from: r */
        public static void m60008r(View view, PorterDuff.Mode mode) {
            view.setBackgroundTintMode(mode);
        }

        /* renamed from: s */
        public static void m60009s(View view, float f10) {
            view.setElevation(f10);
        }

        /* renamed from: t */
        public static void m60010t(View view, boolean z10) {
            view.setNestedScrollingEnabled(z10);
        }

        /* renamed from: u */
        public static void m60011u(View view, InterfaceC9586b0 interfaceC9586b0) {
            if (Build.VERSION.SDK_INT < 30) {
                view.setTag(R$id.tag_on_apply_window_listener, interfaceC9586b0);
            }
            if (interfaceC9586b0 == null) {
                view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(R$id.tag_window_insets_animation_callback));
            } else {
                view.setOnApplyWindowInsetsListener(new a(view, interfaceC9586b0));
            }
        }

        /* renamed from: v */
        public static void m60012v(View view, String str) {
            view.setTransitionName(str);
        }

        /* renamed from: w */
        public static void m60013w(View view, float f10) {
            view.setTranslationZ(f10);
        }

        /* renamed from: x */
        public static void m60014x(View view, float f10) {
            view.setZ(f10);
        }

        /* renamed from: y */
        public static boolean m60015y(View view, int i10) {
            return view.startNestedScroll(i10);
        }

        /* renamed from: z */
        public static void m60016z(View view) {
            view.stopNestedScroll();
        }
    }

    /* renamed from: f0.h0$n */
    public static class n {
        /* renamed from: a */
        public static C9625s0 m60017a(View view) {
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            C9625s0 c9625s0M60147v = C9625s0.m60147v(rootWindowInsets);
            c9625s0M60147v.m60167t(c9625s0M60147v);
            c9625s0M60147v.m60152d(view.getRootView());
            return c9625s0M60147v;
        }

        /* renamed from: b */
        public static int m60018b(View view) {
            return view.getScrollIndicators();
        }

        /* renamed from: c */
        public static void m60019c(View view, int i10) {
            view.setScrollIndicators(i10);
        }

        /* renamed from: d */
        public static void m60020d(View view, int i10, int i11) {
            view.setScrollIndicators(i10, i11);
        }
    }

    /* renamed from: f0.h0$o */
    public static class o {
        /* renamed from: a */
        public static void m60021a(View view) {
            view.cancelDragAndDrop();
        }

        /* renamed from: b */
        public static void m60022b(View view) {
            view.dispatchFinishTemporaryDetach();
        }

        /* renamed from: c */
        public static void m60023c(View view) {
            view.dispatchStartTemporaryDetach();
        }

        /* renamed from: d */
        public static void m60024d(View view, PointerIcon pointerIcon) {
            view.setPointerIcon(pointerIcon);
        }

        /* renamed from: e */
        public static boolean m60025e(View view, ClipData clipData, View.DragShadowBuilder dragShadowBuilder, Object obj, int i10) {
            return view.startDragAndDrop(clipData, dragShadowBuilder, obj, i10);
        }

        /* renamed from: f */
        public static void m60026f(View view, View.DragShadowBuilder dragShadowBuilder) {
            view.updateDragShadow(dragShadowBuilder);
        }
    }

    /* renamed from: f0.h0$p */
    public static class p {
        /* renamed from: a */
        public static void m60027a(View view, Collection<View> collection, int i10) {
            view.addKeyboardNavigationClusters(collection, i10);
        }

        /* renamed from: b */
        public static int m60028b(View view) {
            return view.getImportantForAutofill();
        }

        /* renamed from: c */
        public static int m60029c(View view) {
            return view.getNextClusterForwardId();
        }

        /* renamed from: d */
        public static boolean m60030d(View view) {
            return view.hasExplicitFocusable();
        }

        /* renamed from: e */
        public static boolean m60031e(View view) {
            return view.isFocusedByDefault();
        }

        /* renamed from: f */
        public static boolean m60032f(View view) {
            return view.isImportantForAutofill();
        }

        /* renamed from: g */
        public static boolean m60033g(View view) {
            return view.isKeyboardNavigationCluster();
        }

        /* renamed from: h */
        public static View m60034h(View view, View view2, int i10) {
            return view.keyboardNavigationClusterSearch(view2, i10);
        }

        /* renamed from: i */
        public static boolean m60035i(View view) {
            return view.restoreDefaultFocus();
        }

        /* renamed from: j */
        public static void m60036j(View view, String... strArr) {
            view.setAutofillHints(strArr);
        }

        /* renamed from: k */
        public static void m60037k(View view, boolean z10) {
            view.setFocusedByDefault(z10);
        }

        /* renamed from: l */
        public static void m60038l(View view, int i10) {
            view.setImportantForAutofill(i10);
        }

        /* renamed from: m */
        public static void m60039m(View view, boolean z10) {
            view.setKeyboardNavigationCluster(z10);
        }

        /* renamed from: n */
        public static void m60040n(View view, int i10) {
            view.setNextClusterForwardId(i10);
        }

        /* renamed from: o */
        public static void m60041o(View view, CharSequence charSequence) {
            view.setTooltipText(charSequence);
        }
    }

    /* renamed from: f0.h0$q */
    public static class q {
        /* renamed from: a */
        public static void m60042a(View view, final v vVar) {
            int i10 = R$id.tag_unhandled_key_listeners;
            C11213g c11213g = (C11213g) view.getTag(i10);
            if (c11213g == null) {
                c11213g = new C11213g();
                view.setTag(i10, c11213g);
            }
            Objects.requireNonNull(vVar);
            View.OnUnhandledKeyEventListener onUnhandledKeyEventListener = new View.OnUnhandledKeyEventListener(vVar) { // from class: f0.i0

                /* renamed from: a */
                public final /* synthetic */ C9603h0.v f47720a;

                @Override // android.view.View.OnUnhandledKeyEventListener
                public final boolean onUnhandledKeyEvent(View view2, KeyEvent keyEvent) {
                    return this.f47720a.onUnhandledKeyEvent(view2, keyEvent);
                }
            };
            c11213g.put(vVar, onUnhandledKeyEventListener);
            view.addOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
        }

        /* renamed from: b */
        public static CharSequence m60043b(View view) {
            return view.getAccessibilityPaneTitle();
        }

        /* renamed from: c */
        public static boolean m60044c(View view) {
            return view.isAccessibilityHeading();
        }

        /* renamed from: d */
        public static boolean m60045d(View view) {
            return view.isScreenReaderFocusable();
        }

        /* renamed from: e */
        public static void m60046e(View view, v vVar) {
            View.OnUnhandledKeyEventListener onUnhandledKeyEventListener;
            C11213g c11213g = (C11213g) view.getTag(R$id.tag_unhandled_key_listeners);
            if (c11213g == null || (onUnhandledKeyEventListener = (View.OnUnhandledKeyEventListener) c11213g.get(vVar)) == null) {
                return;
            }
            view.removeOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
        }

        /* renamed from: f */
        public static <T> T m60047f(View view, int i10) {
            return (T) view.requireViewById(i10);
        }

        /* renamed from: g */
        public static void m60048g(View view, boolean z10) {
            view.setAccessibilityHeading(z10);
        }

        /* renamed from: h */
        public static void m60049h(View view, CharSequence charSequence) {
            view.setAccessibilityPaneTitle(charSequence);
        }

        /* renamed from: i */
        public static void m60050i(View view, boolean z10) {
            view.setScreenReaderFocusable(z10);
        }
    }

    /* renamed from: f0.h0$r */
    public static class r {
        /* renamed from: a */
        public static View.AccessibilityDelegate m60051a(View view) {
            return view.getAccessibilityDelegate();
        }

        /* renamed from: b */
        public static List<Rect> m60052b(View view) {
            return view.getSystemGestureExclusionRects();
        }

        /* renamed from: c */
        public static void m60053c(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i10, int i11) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i10, i11);
        }

        /* renamed from: d */
        public static void m60054d(View view, List<Rect> list) {
            view.setSystemGestureExclusionRects(list);
        }
    }

    /* renamed from: f0.h0$s */
    public static class s {
        /* renamed from: a */
        public static CharSequence m60055a(View view) {
            return view.getStateDescription();
        }

        /* renamed from: b */
        public static void m60056b(View view, CharSequence charSequence) {
            view.setStateDescription(charSequence);
        }
    }

    /* renamed from: f0.h0$t */
    public static final class t {
        /* renamed from: a */
        public static String[] m60057a(View view) {
            return view.getReceiveContentMimeTypes();
        }

        /* renamed from: b */
        public static C9588c m60058b(View view, C9588c c9588c) {
            ContentInfo contentInfoM59796f = c9588c.m59796f();
            ContentInfo contentInfoPerformReceiveContent = view.performReceiveContent(contentInfoM59796f);
            if (contentInfoPerformReceiveContent == null) {
                return null;
            }
            return contentInfoPerformReceiveContent == contentInfoM59796f ? c9588c : C9588c.m59792g(contentInfoPerformReceiveContent);
        }

        /* renamed from: c */
        public static void m60059c(View view, String[] strArr, InterfaceC9589c0 interfaceC9589c0) {
            if (interfaceC9589c0 == null) {
                view.setOnReceiveContentListener(strArr, null);
            } else {
                view.setOnReceiveContentListener(strArr, new u(interfaceC9589c0));
            }
        }
    }

    /* renamed from: f0.h0$u */
    public static final class u implements OnReceiveContentListener {

        /* renamed from: a */
        public final InterfaceC9589c0 f47719a;

        public u(InterfaceC9589c0 interfaceC9589c0) {
            this.f47719a = interfaceC9589c0;
        }

        public ContentInfo onReceiveContent(View view, ContentInfo contentInfo) {
            C9588c c9588cM59792g = C9588c.m59792g(contentInfo);
            C9588c c9588cMo4115a = this.f47719a.mo4115a(view, c9588cM59792g);
            if (c9588cMo4115a == null) {
                return null;
            }
            return c9588cMo4115a == c9588cM59792g ? contentInfo : c9588cMo4115a.m59796f();
        }
    }

    /* renamed from: f0.h0$v */
    public interface v {
        boolean onUnhandledKeyEvent(View view, KeyEvent keyEvent);
    }

    /* renamed from: A */
    public static int m59832A(View view) {
        return i.m59970d(view);
    }

    /* renamed from: A0 */
    public static void m59833A0(View view, int i10) {
        h.m59966s(view, i10);
    }

    /* renamed from: B */
    public static int m59834B(View view) {
        return h.m59951d(view);
    }

    /* renamed from: B0 */
    public static void m59835B0(View view, int i10) {
        p.m60038l(view, i10);
    }

    /* renamed from: C */
    public static int m59836C(View view) {
        return h.m59952e(view);
    }

    /* renamed from: C0 */
    public static void m59837C0(View view, InterfaceC9586b0 interfaceC9586b0) {
        m.m60011u(view, interfaceC9586b0);
    }

    /* renamed from: D */
    public static String[] m59838D(View view) {
        return Build.VERSION.SDK_INT >= 31 ? t.m60057a(view) : (String[]) view.getTag(R$id.tag_on_receive_content_mime_types);
    }

    /* renamed from: D0 */
    public static void m59839D0(View view, int i10, int i11, int i12, int i13) {
        i.m59977k(view, i10, i11, i12, i13);
    }

    /* renamed from: E */
    public static int m59840E(View view) {
        return i.m59971e(view);
    }

    /* renamed from: E0 */
    public static void m59841E0(View view, C9598f0 c9598f0) {
        o.m60024d(view, (PointerIcon) (c9598f0 != null ? c9598f0.m59825a() : null));
    }

    /* renamed from: F */
    public static int m59842F(View view) {
        return i.m59972f(view);
    }

    /* renamed from: F0 */
    public static void m59843F0(View view, int i10, int i11) {
        n.m60020d(view, i10, i11);
    }

    /* renamed from: G */
    public static ViewParent m59844G(View view) {
        return h.m59953f(view);
    }

    /* renamed from: G0 */
    public static void m59845G0(View view, CharSequence charSequence) {
        m59855L0().m59946g(view, charSequence);
    }

    /* renamed from: H */
    public static C9625s0 m59846H(View view) {
        return n.m60017a(view);
    }

    /* renamed from: H0 */
    public static void m59847H0(View view, String str) {
        m.m60012v(view, str);
    }

    /* renamed from: I */
    public static CharSequence m59848I(View view) {
        return m59855L0().m59945f(view);
    }

    /* renamed from: I0 */
    public static void m59849I0(View view, float f10) {
        m.m60013w(view, f10);
    }

    /* renamed from: J */
    public static String m59850J(View view) {
        return m.m60001k(view);
    }

    /* renamed from: J0 */
    public static void m59851J0(View view) {
        if (m59919y(view) == 0) {
            m59833A0(view, 1);
        }
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            if (m59919y((View) parent) == 4) {
                m59833A0(view, 2);
                return;
            }
        }
    }

    /* renamed from: K */
    public static float m59852K(View view) {
        return m.m60002l(view);
    }

    /* renamed from: K0 */
    public static void m59853K0(View view, float f10) {
        m.m60014x(view, f10);
    }

    @Deprecated
    /* renamed from: L */
    public static int m59854L(View view) {
        return h.m59954g(view);
    }

    /* renamed from: L0 */
    public static f<CharSequence> m59855L0() {
        return new c(R$id.tag_state_description, CharSequence.class, 64, 30);
    }

    /* renamed from: M */
    public static float m59856M(View view) {
        return m.m60003m(view);
    }

    /* renamed from: M0 */
    public static void m59857M0(View view) {
        m.m60016z(view);
    }

    /* renamed from: N */
    public static boolean m59858N(View view) {
        return m59895m(view) != null;
    }

    /* renamed from: O */
    public static boolean m59859O(View view) {
        return g.m59947a(view);
    }

    /* renamed from: P */
    public static boolean m59860P(View view) {
        return h.m59955h(view);
    }

    /* renamed from: Q */
    public static boolean m59861Q(View view) {
        return h.m59956i(view);
    }

    /* renamed from: R */
    public static boolean m59862R(View view) {
        Boolean boolM59945f = m59873b().m59945f(view);
        return boolM59945f != null && boolM59945f.booleanValue();
    }

    /* renamed from: S */
    public static boolean m59863S(View view) {
        return k.m59982b(view);
    }

    /* renamed from: T */
    public static boolean m59864T(View view) {
        return k.m59983c(view);
    }

    /* renamed from: U */
    public static boolean m59865U(View view) {
        return m.m60006p(view);
    }

    /* renamed from: V */
    public static boolean m59866V(View view) {
        return i.m59973g(view);
    }

    /* renamed from: W */
    public static boolean m59867W(View view) {
        Boolean boolM59945f = m59900o0().m59945f(view);
        return boolM59945f != null && boolM59945f.booleanValue();
    }

    /* renamed from: X */
    public static /* synthetic */ C9588c m59868X(C9588c c9588c) {
        return c9588c;
    }

    /* renamed from: Y */
    public static void m59869Y(View view, int i10) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z10 = m59899o(view) != null && view.isShown() && view.getWindowVisibility() == 0;
            if (m59897n(view) != 0 || z10) {
                AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                accessibilityEventObtain.setEventType(z10 ? 32 : 2048);
                k.m59987g(accessibilityEventObtain, i10);
                if (z10) {
                    accessibilityEventObtain.getText().add(m59899o(view));
                    m59851J0(view);
                }
                view.sendAccessibilityEventUnchecked(accessibilityEventObtain);
                return;
            }
            if (i10 == 32) {
                AccessibilityEvent accessibilityEventObtain2 = AccessibilityEvent.obtain();
                view.onInitializeAccessibilityEvent(accessibilityEventObtain2);
                accessibilityEventObtain2.setEventType(32);
                k.m59987g(accessibilityEventObtain2, i10);
                accessibilityEventObtain2.setSource(view);
                view.onPopulateAccessibilityEvent(accessibilityEventObtain2);
                accessibilityEventObtain2.getText().add(m59899o(view));
                accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain2);
                return;
            }
            if (view.getParent() != null) {
                try {
                    k.m59985e(view.getParent(), view, view, i10);
                } catch (AbstractMethodError e10) {
                    Log.e("ViewCompat", view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e10);
                }
            }
        }
    }

    /* renamed from: Z */
    public static void m59870Z(View view, int i10) {
        view.offsetLeftAndRight(i10);
    }

    /* renamed from: a0 */
    public static void m59872a0(View view, int i10) {
        view.offsetTopAndBottom(i10);
    }

    /* renamed from: b */
    public static f<Boolean> m59873b() {
        return new d(R$id.tag_accessibility_heading, Boolean.class, 28);
    }

    /* renamed from: b0 */
    public static C9625s0 m59874b0(View view, C9625s0 c9625s0) {
        WindowInsets windowInsetsM60168u = c9625s0.m60168u();
        if (windowInsetsM60168u != null) {
            WindowInsets windowInsetsM59989b = l.m59989b(view, windowInsetsM60168u);
            if (!windowInsetsM59989b.equals(windowInsetsM60168u)) {
                return C9625s0.m60148w(windowInsetsM59989b, view);
            }
        }
        return c9625s0;
    }

    /* renamed from: c */
    public static int m59875c(View view, CharSequence charSequence, InterfaceC9835o interfaceC9835o) {
        int iM59903q = m59903q(view, charSequence);
        if (iM59903q != -1) {
            m59877d(view, new C9832l.a(iM59903q, charSequence, interfaceC9835o));
        }
        return iM59903q;
    }

    /* renamed from: c0 */
    public static void m59876c0(View view, C9832l c9832l) {
        view.onInitializeAccessibilityNodeInfo(c9832l.m61120z0());
    }

    /* renamed from: d */
    public static void m59877d(View view, C9832l.a aVar) {
        m59889j(view);
        m59892k0(aVar.m61122b(), view);
        m59901p(view).add(aVar);
        m59869Y(view, 0);
    }

    /* renamed from: d0 */
    public static f<CharSequence> m59878d0() {
        return new b(R$id.tag_accessibility_pane_title, CharSequence.class, 8, 28);
    }

    /* renamed from: e */
    public static C9615n0 m59879e(View view) {
        if (f47706b == null) {
            f47706b = new WeakHashMap<>();
        }
        C9615n0 c9615n0 = f47706b.get(view);
        if (c9615n0 != null) {
            return c9615n0;
        }
        C9615n0 c9615n02 = new C9615n0(view);
        f47706b.put(view, c9615n02);
        return c9615n02;
    }

    /* renamed from: e0 */
    public static boolean m59880e0(View view, int i10, Bundle bundle) {
        return h.m59957j(view, i10, bundle);
    }

    @Deprecated
    /* renamed from: f */
    public static boolean m59881f(View view, int i10) {
        return view.canScrollVertically(i10);
    }

    /* renamed from: f0 */
    public static C9588c m59882f0(View view, C9588c c9588c) {
        if (Log.isLoggable("ViewCompat", 3)) {
            Log.d("ViewCompat", "performReceiveContent: " + c9588c + ", view=" + view.getClass().getSimpleName() + "[" + view.getId() + "]");
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return t.m60058b(view, c9588c);
        }
        InterfaceC9589c0 interfaceC9589c0 = (InterfaceC9589c0) view.getTag(R$id.tag_on_receive_content_listener);
        if (interfaceC9589c0 == null) {
            return m59915w(view).mo2626a(c9588c);
        }
        C9588c c9588cMo4115a = interfaceC9589c0.mo4115a(view, c9588c);
        if (c9588cMo4115a == null) {
            return null;
        }
        return m59915w(view).mo2626a(c9588cMo4115a);
    }

    /* renamed from: g */
    public static C9625s0 m59883g(View view, C9625s0 c9625s0, Rect rect) {
        return m.m59992b(view, c9625s0, rect);
    }

    /* renamed from: g0 */
    public static void m59884g0(View view) {
        h.m59958k(view);
    }

    /* renamed from: h */
    public static C9625s0 m59885h(View view, C9625s0 c9625s0) {
        WindowInsets windowInsetsM60168u = c9625s0.m60168u();
        if (windowInsetsM60168u != null) {
            WindowInsets windowInsetsM59988a = l.m59988a(view, windowInsetsM60168u);
            if (!windowInsetsM59988a.equals(windowInsetsM60168u)) {
                return C9625s0.m60148w(windowInsetsM59988a, view);
            }
        }
        return c9625s0;
    }

    /* renamed from: h0 */
    public static void m59886h0(View view, Runnable runnable) {
        h.m59960m(view, runnable);
    }

    /* renamed from: i */
    public static boolean m59887i(View view, KeyEvent keyEvent) {
        return false;
    }

    @SuppressLint({"LambdaLast"})
    /* renamed from: i0 */
    public static void m59888i0(View view, Runnable runnable, long j10) {
        h.m59961n(view, runnable, j10);
    }

    /* renamed from: j */
    public static void m59889j(View view) {
        C9582a c9582aM59893l = m59893l(view);
        if (c9582aM59893l == null) {
            c9582aM59893l = new C9582a();
        }
        m59902p0(view, c9582aM59893l);
    }

    /* renamed from: j0 */
    public static void m59890j0(View view, int i10) {
        m59892k0(i10, view);
        m59869Y(view, 0);
    }

    /* renamed from: k */
    public static int m59891k() {
        return i.m59967a();
    }

    /* renamed from: k0 */
    public static void m59892k0(int i10, View view) {
        List<C9832l.a> listM59901p = m59901p(view);
        for (int i11 = 0; i11 < listM59901p.size(); i11++) {
            if (listM59901p.get(i11).m61122b() == i10) {
                listM59901p.remove(i11);
                return;
            }
        }
    }

    /* renamed from: l */
    public static C9582a m59893l(View view) {
        View.AccessibilityDelegate accessibilityDelegateM59895m = m59895m(view);
        if (accessibilityDelegateM59895m == null) {
            return null;
        }
        return accessibilityDelegateM59895m instanceof C9582a.a ? ((C9582a.a) accessibilityDelegateM59895m).f47677a : new C9582a(accessibilityDelegateM59895m);
    }

    /* renamed from: l0 */
    public static void m59894l0(View view, C9832l.a aVar, CharSequence charSequence, InterfaceC9835o interfaceC9835o) {
        if (interfaceC9835o == null && charSequence == null) {
            m59890j0(view, aVar.m61122b());
        } else {
            m59877d(view, aVar.m61121a(charSequence, interfaceC9835o));
        }
    }

    /* renamed from: m */
    public static View.AccessibilityDelegate m59895m(View view) {
        return r.m60051a(view);
    }

    /* renamed from: m0 */
    public static void m59896m0(View view) {
        l.m59990c(view);
    }

    /* renamed from: n */
    public static int m59897n(View view) {
        return k.m59981a(view);
    }

    /* renamed from: n0 */
    public static void m59898n0(View view, @SuppressLint({"ContextFirst"}) Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i10, int i11) {
        r.m60053c(view, context, iArr, attributeSet, typedArray, i10, i11);
    }

    /* renamed from: o */
    public static CharSequence m59899o(View view) {
        return m59878d0().m59945f(view);
    }

    /* renamed from: o0 */
    public static f<Boolean> m59900o0() {
        return new a(R$id.tag_screen_reader_focusable, Boolean.class, 28);
    }

    /* renamed from: p */
    public static List<C9832l.a> m59901p(View view) {
        int i10 = R$id.tag_accessibility_actions;
        ArrayList arrayList = (ArrayList) view.getTag(i10);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(i10, arrayList2);
        return arrayList2;
    }

    /* renamed from: p0 */
    public static void m59902p0(View view, C9582a c9582a) {
        if (c9582a == null && (m59895m(view) instanceof C9582a.a)) {
            c9582a = new C9582a();
        }
        view.setAccessibilityDelegate(c9582a == null ? null : c9582a.getBridge());
    }

    /* renamed from: q */
    public static int m59903q(View view, CharSequence charSequence) {
        List<C9832l.a> listM59901p = m59901p(view);
        for (int i10 = 0; i10 < listM59901p.size(); i10++) {
            if (TextUtils.equals(charSequence, listM59901p.get(i10).m61123c())) {
                return listM59901p.get(i10).m61122b();
            }
        }
        int i11 = -1;
        int i12 = 0;
        while (true) {
            int[] iArr = f47708d;
            if (i12 >= iArr.length || i11 != -1) {
                break;
            }
            int i13 = iArr[i12];
            boolean z10 = true;
            for (int i14 = 0; i14 < listM59901p.size(); i14++) {
                z10 &= listM59901p.get(i14).m61122b() != i13;
            }
            if (z10) {
                i11 = i13;
            }
            i12++;
        }
        return i11;
    }

    /* renamed from: q0 */
    public static void m59904q0(View view, boolean z10) {
        m59873b().m59946g(view, Boolean.valueOf(z10));
    }

    /* renamed from: r */
    public static ColorStateList m59905r(View view) {
        return m.m59997g(view);
    }

    /* renamed from: r0 */
    public static void m59906r0(View view, int i10) {
        k.m59986f(view, i10);
    }

    /* renamed from: s */
    public static PorterDuff.Mode m59907s(View view) {
        return m.m59998h(view);
    }

    /* renamed from: s0 */
    public static void m59908s0(View view, CharSequence charSequence) {
        m59878d0().m59946g(view, charSequence);
        if (charSequence != null) {
            f47710f.m59938a(view);
        } else {
            f47710f.m59940c(view);
        }
    }

    /* renamed from: t */
    public static Rect m59909t(View view) {
        return j.m59978a(view);
    }

    /* renamed from: t0 */
    public static void m59910t0(View view, Drawable drawable) {
        h.m59964q(view, drawable);
    }

    /* renamed from: u */
    public static Display m59911u(View view) {
        return i.m59968b(view);
    }

    /* renamed from: u0 */
    public static void m59912u0(View view, ColorStateList colorStateList) {
        m.m60007q(view, colorStateList);
    }

    /* renamed from: v */
    public static float m59913v(View view) {
        return m.m59999i(view);
    }

    /* renamed from: v0 */
    public static void m59914v0(View view, PorterDuff.Mode mode) {
        m.m60008r(view, mode);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: w */
    public static InterfaceC9592d0 m59915w(View view) {
        return view instanceof InterfaceC9592d0 ? (InterfaceC9592d0) view : f47709e;
    }

    /* renamed from: w0 */
    public static void m59916w0(View view, Rect rect) {
        j.m59980c(view, rect);
    }

    /* renamed from: x */
    public static boolean m59917x(View view) {
        return h.m59949b(view);
    }

    /* renamed from: x0 */
    public static void m59918x0(View view, float f10) {
        m.m60009s(view, f10);
    }

    /* renamed from: y */
    public static int m59919y(View view) {
        return h.m59950c(view);
    }

    @Deprecated
    /* renamed from: y0 */
    public static void m59920y0(View view, boolean z10) {
        view.setFitsSystemWindows(z10);
    }

    @SuppressLint({"InlinedApi"})
    /* renamed from: z */
    public static int m59921z(View view) {
        return p.m60028b(view);
    }

    /* renamed from: z0 */
    public static void m59922z0(View view, boolean z10) {
        h.m59965r(view, z10);
    }

    /* renamed from: f0.h0$f */
    public static abstract class f<T> {

        /* renamed from: a */
        public final int f47712a;

        /* renamed from: b */
        public final Class<T> f47713b;

        /* renamed from: c */
        public final int f47714c;

        /* renamed from: d */
        public final int f47715d;

        public f(int i10, Class<T> cls, int i11) {
            this(i10, cls, 0, i11);
        }

        /* renamed from: a */
        public boolean m59942a(Boolean bool, Boolean bool2) {
            return (bool != null && bool.booleanValue()) == (bool2 != null && bool2.booleanValue());
        }

        /* renamed from: b */
        public final boolean m59943b() {
            return true;
        }

        /* renamed from: c */
        public final boolean m59944c() {
            return Build.VERSION.SDK_INT >= this.f47714c;
        }

        /* renamed from: d */
        public abstract T mo59923d(View view);

        /* renamed from: e */
        public abstract void mo59924e(View view, T t10);

        /* renamed from: f */
        public T m59945f(View view) {
            if (m59944c()) {
                return mo59923d(view);
            }
            if (!m59943b()) {
                return null;
            }
            T t10 = (T) view.getTag(this.f47712a);
            if (this.f47713b.isInstance(t10)) {
                return t10;
            }
            return null;
        }

        /* renamed from: g */
        public void m59946g(View view, T t10) {
            if (m59944c()) {
                mo59924e(view, t10);
            } else if (m59943b() && mo59925h(m59945f(view), t10)) {
                C9603h0.m59889j(view);
                view.setTag(this.f47712a, t10);
                C9603h0.m59869Y(view, this.f47715d);
            }
        }

        /* renamed from: h */
        public abstract boolean mo59925h(T t10, T t11);

        public f(int i10, Class<T> cls, int i11, int i12) {
            this.f47712a = i10;
            this.f47713b = cls;
            this.f47715d = i11;
            this.f47714c = i12;
        }
    }
}
