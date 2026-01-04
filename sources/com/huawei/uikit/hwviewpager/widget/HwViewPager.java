package com.huawei.uikit.hwviewpager.widget;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Pair;
import android.view.Display;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.annotation.Keep;
import androidx.core.content.ContextCompat;
import androidx.customview.view.AbsSavedState;
import com.huawei.dynamicanimation.AbstractC4672b;
import com.huawei.dynamicanimation.C4676f;
import com.huawei.dynamicanimation.C4680j;
import com.huawei.hms.network.embedded.C6051p9;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.uikit.hwcommon.utils.HwReflectUtil;
import com.huawei.uikit.hwresources.utils.HwWidgetCompat;
import com.huawei.uikit.hwresources.utils.HwWidgetInstantiator;
import com.huawei.uikit.hwunifiedinteract.widget.HwGenericEventDetector;
import com.huawei.uikit.hwviewpager.C8744R;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import p273f0.C9582a;
import p273f0.C9603h0;
import p273f0.C9625s0;
import p273f0.InterfaceC9586b0;
import p304g0.C9832l;
import p322h0.C10076a;
import p438l.C11207a;
import p493nj.C11716c;
import p524oj.C11906a;

/* loaded from: classes9.dex */
public class HwViewPager extends ViewGroup {

    /* renamed from: A1 */
    private static final int f44660A1 = 25;

    /* renamed from: B1 */
    private static final int f44661B1 = 16;

    /* renamed from: C1 */
    private static final int f44662C1 = 400;

    /* renamed from: D1 */
    private static final float f44663D1 = 1.0E-6f;

    /* renamed from: E1 */
    private static final int f44664E1 = -1;

    /* renamed from: F1 */
    private static final int f44665F1 = 1;

    /* renamed from: G1 */
    private static final int f44666G1 = 2;

    /* renamed from: H1 */
    private static final int f44667H1 = 0;

    /* renamed from: I1 */
    private static final int f44668I1 = 1;

    /* renamed from: J1 */
    private static final int f44669J1 = 2;

    /* renamed from: K1 */
    private static final int f44670K1 = 1000;

    /* renamed from: L1 */
    private static final long f44671L1 = 1000;

    /* renamed from: M1 */
    private static final int f44672M1 = 4;

    /* renamed from: N1 */
    private static final boolean f44673N1 = false;

    /* renamed from: O1 */
    private static final int f44674O1 = 2;

    /* renamed from: P1 */
    private static final int f44675P1 = -1;
    public static final int PAGE_SCROLL_HORIZONTAL = 0;
    public static final int PAGE_SCROLL_VERTICAL = 1;

    /* renamed from: Q1 */
    private static final float f44676Q1 = 1.4f;

    /* renamed from: R1 */
    private static final float f44677R1 = 1.4f;

    /* renamed from: S1 */
    private static final float f44678S1 = 1.0f;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;

    /* renamed from: T1 */
    private static final float f44679T1 = 0.3f;

    /* renamed from: U1 */
    private static final int f44680U1 = 2;

    /* renamed from: V1 */
    private static final int f44681V1 = 300;

    /* renamed from: W1 */
    private static final int f44682W1 = 255;

    /* renamed from: Y1 */
    private static final int f44684Y1 = 1;

    /* renamed from: Z1 */
    private static final int f44685Z1 = 2;

    /* renamed from: a2 */
    private static final long f44686a2 = 700;

    /* renamed from: b2 */
    private static final long f44687b2 = 300;

    /* renamed from: h1 */
    private static final String f44692h1 = "HwViewPager";

    /* renamed from: i1 */
    private static final int f44693i1 = 15;

    /* renamed from: j1 */
    private static final int f44694j1 = 2;

    /* renamed from: k1 */
    private static final int f44695k1 = 1;

    /* renamed from: l1 */
    private static final int f44696l1 = 10;

    /* renamed from: m1 */
    private static final int f44697m1 = 1200;

    /* renamed from: n1 */
    private static final float f44698n1 = 228.0f;

    /* renamed from: o1 */
    private static final float f44699o1 = 30.0f;

    /* renamed from: p1 */
    private static final float f44700p1 = 0.5f;

    /* renamed from: q1 */
    private static final float f44701q1 = 0.6f;

    /* renamed from: r1 */
    private static final int f44702r1 = 100;

    /* renamed from: s1 */
    private static final float f44703s1 = 0.3f;

    /* renamed from: t1 */
    private static final float f44704t1 = 2.0f;

    /* renamed from: u1 */
    private static final boolean f44705u1 = false;

    /* renamed from: v1 */
    private static final boolean f44706v1 = false;

    /* renamed from: w1 */
    private static final float f44707w1 = 0.5f;

    /* renamed from: x1 */
    private static final float f44708x1 = 0.9f;

    /* renamed from: y1 */
    private static final int f44709y1 = 2;

    /* renamed from: z1 */
    private static final int f44710z1 = 600;

    /* renamed from: A */
    private float f44711A;

    /* renamed from: A0 */
    private boolean f44712A0;

    /* renamed from: B */
    private int f44713B;

    /* renamed from: B0 */
    private boolean f44714B0;

    /* renamed from: C */
    private int f44715C;

    /* renamed from: C0 */
    private int f44716C0;

    /* renamed from: D */
    private boolean f44717D;

    /* renamed from: D0 */
    private ValueAnimator f44718D0;

    /* renamed from: E */
    private boolean f44719E;

    /* renamed from: E0 */
    private HwPagerAdapter f44720E0;

    /* renamed from: F */
    private boolean f44721F;

    /* renamed from: F0 */
    private HwPageTurningHelper f44722F0;

    /* renamed from: G */
    private boolean f44723G;

    /* renamed from: G0 */
    private boolean f44724G0;

    /* renamed from: H */
    private int f44725H;

    /* renamed from: H0 */
    private float f44726H0;

    /* renamed from: I */
    private boolean f44727I;

    /* renamed from: I0 */
    private float f44728I0;

    /* renamed from: J */
    private boolean f44729J;

    /* renamed from: J0 */
    private C4676f f44730J0;

    /* renamed from: K */
    private int f44731K;

    /* renamed from: K0 */
    private AbstractC4672b.p f44732K0;

    /* renamed from: L */
    private int f44733L;

    /* renamed from: L0 */
    private AbstractC4672b.r f44734L0;

    /* renamed from: M */
    private int f44735M;

    /* renamed from: M0 */
    private HwGenericEventDetector f44736M0;

    /* renamed from: N */
    private float f44737N;

    /* renamed from: N0 */
    private boolean f44738N0;

    /* renamed from: O */
    private float f44739O;

    /* renamed from: O0 */
    private boolean f44740O0;

    /* renamed from: P */
    private float f44741P;

    /* renamed from: P0 */
    private int f44742P0;

    /* renamed from: Q */
    private float f44743Q;

    /* renamed from: Q0 */
    private ViewGroupOverlay f44744Q0;

    /* renamed from: R */
    private float f44745R;

    /* renamed from: R0 */
    private Drawable f44746R0;

    /* renamed from: S */
    private int f44747S;

    /* renamed from: S0 */
    private int f44748S0;

    /* renamed from: T */
    private VelocityTracker f44749T;

    /* renamed from: T0 */
    private Interpolator f44750T0;

    /* renamed from: U */
    private int f44751U;

    /* renamed from: U0 */
    private int f44752U0;

    /* renamed from: V */
    private int f44753V;

    /* renamed from: V0 */
    private int f44754V0;

    /* renamed from: W */
    private int f44755W;

    /* renamed from: W0 */
    private int f44756W0;

    /* renamed from: X0 */
    private int f44757X0;

    /* renamed from: Y0 */
    private int f44758Y0;

    /* renamed from: Z0 */
    private int f44759Z0;

    /* renamed from: a */
    HwPagerAdapter f44760a;

    /* renamed from: a0 */
    private int f44761a0;

    /* renamed from: a1 */
    private boolean f44762a1;

    /* renamed from: b */
    int f44763b;

    /* renamed from: b0 */
    private boolean f44764b0;

    /* renamed from: b1 */
    private int f44765b1;

    /* renamed from: c */
    private int f44766c;

    /* renamed from: c0 */
    private long f44767c0;

    /* renamed from: c1 */
    private ItemInfo f44768c1;

    /* renamed from: d */
    private int f44769d;

    /* renamed from: d0 */
    private EdgeEffect f44770d0;

    /* renamed from: d1 */
    private float f44771d1;

    /* renamed from: e */
    private int f44772e;

    /* renamed from: e0 */
    private EdgeEffect f44773e0;

    /* renamed from: e1 */
    private int f44774e1;

    /* renamed from: f */
    private final ArrayList<ItemInfo> f44775f;

    /* renamed from: f0 */
    private boolean f44776f0;

    /* renamed from: f1 */
    private float f44777f1;

    /* renamed from: g */
    private final ItemInfo f44778g;

    /* renamed from: g0 */
    private boolean f44779g0;

    /* renamed from: h */
    private final Rect f44780h;

    /* renamed from: h0 */
    private boolean f44781h0;

    /* renamed from: i */
    private final Map<OnPageChangeListener, bfscp> f44782i;

    /* renamed from: i0 */
    private int f44783i0;

    /* renamed from: j */
    private final Runnable f44784j;

    /* renamed from: j0 */
    private List<OnPageChangeListener> f44785j0;

    /* renamed from: k */
    private int f44786k;

    /* renamed from: k0 */
    private OnPageChangeListener f44787k0;

    /* renamed from: l */
    private Parcelable f44788l;

    /* renamed from: l0 */
    private OnPageChangeListener f44789l0;

    /* renamed from: m */
    private ClassLoader f44790m;

    /* renamed from: m0 */
    private List<OnAdapterChangeListener> f44791m0;

    /* renamed from: n */
    private Scroller f44792n;

    /* renamed from: n0 */
    private PageTransformer f44793n0;

    /* renamed from: o */
    private boolean f44794o;

    /* renamed from: o0 */
    private int f44795o0;

    /* renamed from: p */
    private bxac f44796p;

    /* renamed from: p0 */
    private int f44797p0;

    /* renamed from: q */
    private int f44798q;

    /* renamed from: q0 */
    private ArrayList<View> f44799q0;

    /* renamed from: r */
    private Drawable f44800r;

    /* renamed from: r0 */
    private int f44801r0;

    /* renamed from: s */
    private int f44802s;

    /* renamed from: s0 */
    private boolean f44803s0;

    /* renamed from: t */
    private int f44804t;

    /* renamed from: t0 */
    private boolean f44805t0;

    /* renamed from: u */
    private int f44806u;

    /* renamed from: u0 */
    private boolean f44807u0;

    /* renamed from: v */
    private int f44808v;

    /* renamed from: v0 */
    private boolean f44809v0;

    /* renamed from: w */
    private float f44810w;

    /* renamed from: w0 */
    private float f44811w0;

    /* renamed from: x */
    private float f44812x;

    /* renamed from: x0 */
    private float f44813x0;

    /* renamed from: y */
    private float f44814y;

    /* renamed from: y0 */
    private boolean f44815y0;

    /* renamed from: z */
    private float f44816z;

    /* renamed from: z0 */
    private boolean f44817z0;

    /* renamed from: g1 */
    static final int[] f44691g1 = {R.attr.layout_gravity};

    /* renamed from: X1 */
    private static final int f44683X1 = C8744R.color.hwviewpager_shadow_color;

    /* renamed from: c2 */
    private static final aayti f44688c2 = new aayti();

    /* renamed from: d2 */
    private static final Comparator<ItemInfo> f44689d2 = new bzrwd();

    /* renamed from: e2 */
    private static final Interpolator f44690e2 = new aauaf();

    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    public @interface DecorView {
    }

    public static class ItemInfo {

        /* renamed from: a */
        Object f44818a;

        /* renamed from: b */
        int f44819b;

        /* renamed from: c */
        boolean f44820c;

        /* renamed from: d */
        float f44821d;

        /* renamed from: e */
        float f44822e;

        public float getOffset() {
            return this.f44822e;
        }

        public int getPosition() {
            return this.f44819b;
        }

        public float getWidthFactor() {
            return this.f44821d;
        }
    }

    public interface OnAdapterChangeListener {
        void onAdapterChanged(HwViewPager hwViewPager, HwPagerAdapter hwPagerAdapter, HwPagerAdapter hwPagerAdapter2);
    }

    public interface OnPageChangeListener {
        void onPageScrollStateChanged(int i10);

        void onPageScrolled(int i10, float f10, int i11);

        void onPageSelected(int i10);
    }

    public interface PageTransformer {
        void transformPage(View view, float f10);
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new bzrwd();

        /* renamed from: a */
        int f44830a;

        /* renamed from: b */
        Parcelable f44831b;

        /* renamed from: c */
        ClassLoader f44832c;

        public class bzrwd implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f44830a + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f44830a);
            parcel.writeParcelable(this.f44831b, i10);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.f44830a = parcel.readInt();
            this.f44831b = parcel.readParcelable(classLoader);
            this.f44832c = classLoader;
        }
    }

    public static class SimpleOnPageChangeListener implements OnPageChangeListener {
        @Override // com.huawei.uikit.hwviewpager.widget.HwViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i10) {
        }

        @Override // com.huawei.uikit.hwviewpager.widget.HwViewPager.OnPageChangeListener
        public void onPageScrolled(int i10, float f10, int i11) {
        }

        @Override // com.huawei.uikit.hwviewpager.widget.HwViewPager.OnPageChangeListener
        public void onPageSelected(int i10) {
        }
    }

    public class aauaf implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            float f11 = f10 - 1.0f;
            return (f11 * f11 * f11 * f11 * f11) + 1.0f;
        }
    }

    public static class aayti implements Comparator<View> {
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(View view, View view2) {
            if (!(view.getLayoutParams() instanceof LayoutParams) || !(view2.getLayoutParams() instanceof LayoutParams)) {
                Log.w(HwViewPager.f44692h1, "compare: view compare is not instance of layout params");
                return 0;
            }
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
            boolean z10 = layoutParams.isDecor;
            return z10 != layoutParams2.isDecor ? z10 ? 1 : -1 : layoutParams.f44825c - layoutParams2.f44825c;
        }
    }

    public class akxao implements InterfaceC9586b0 {

        /* renamed from: a */
        private final Rect f44833a = new Rect();

        public akxao() {
        }

        @Override // p273f0.InterfaceC9586b0
        public C9625s0 onApplyWindowInsets(View view, C9625s0 c9625s0) {
            C9625s0 c9625s0M59874b0 = C9603h0.m59874b0(view, c9625s0);
            if (c9625s0M59874b0.m60163p()) {
                return c9625s0M59874b0;
            }
            Rect rect = this.f44833a;
            rect.left = c9625s0M59874b0.m60158j();
            rect.top = c9625s0M59874b0.m60160l();
            rect.right = c9625s0M59874b0.m60159k();
            rect.bottom = c9625s0M59874b0.m60157i();
            int childCount = HwViewPager.this.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                C9625s0 c9625s0M59885h = C9603h0.m59885h(HwViewPager.this.getChildAt(i10), c9625s0M59874b0);
                rect.left = Math.min(c9625s0M59885h.m60158j(), rect.left);
                rect.top = Math.min(c9625s0M59885h.m60160l(), rect.top);
                rect.right = Math.min(c9625s0M59885h.m60159k(), rect.right);
                rect.bottom = Math.min(c9625s0M59885h.m60157i(), rect.bottom);
            }
            return c9625s0M59874b0.m60164q(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    public class avpbg implements ValueAnimator.AnimatorUpdateListener {
        public avpbg() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator == null) {
                return;
            }
            HwViewPager.this.f44746R0.setAlpha((int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f));
            HwViewPager.this.f44746R0.invalidateSelf();
        }
    }

    public class bfscp implements OnPageChangeListener {

        /* renamed from: g */
        private static final int f44836g = -1;

        /* renamed from: a */
        private final OnPageChangeListener f44837a;

        /* renamed from: b */
        private int f44838b;

        /* renamed from: c */
        private float f44839c;

        /* renamed from: d */
        private float f44840d;

        /* renamed from: e */
        private boolean f44841e;

        public /* synthetic */ bfscp(HwViewPager hwViewPager, OnPageChangeListener onPageChangeListener, bzrwd bzrwdVar) {
            this(onPageChangeListener);
        }

        /* renamed from: a */
        private boolean m55933a(float f10, int i10, int i11, int i12) {
            if (!HwViewPager.this.f44805t0) {
                return false;
            }
            if (i11 != i12 - 1) {
                this.f44837a.onPageScrolled(this.f44838b, f10, i10);
            } else {
                OnPageChangeListener onPageChangeListener = this.f44837a;
                int i13 = this.f44838b;
                if (f10 > 0.0f) {
                    f10 = 1.0f - f10;
                }
                onPageChangeListener.onPageScrolled(i13, f10, i10);
            }
            return true;
        }

        @Override // com.huawei.uikit.hwviewpager.widget.HwViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i10) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
            if (HwViewPager.this.f44803s0) {
                return;
            }
            HwPagerAdapter currentAdapter = HwViewPager.this.getCurrentAdapter();
            if (currentAdapter != null) {
                HwViewPager hwViewPager = HwViewPager.this;
                int i11 = hwViewPager.f44763b;
                int iM55944c = ((currentAdapter instanceof com.huawei.uikit.hwviewpager.widget.aauaf) && hwViewPager.f44805t0) ? ((com.huawei.uikit.hwviewpager.widget.aauaf) currentAdapter).m55944c(i11) : i11;
                if (HwViewPager.this.f44805t0 && i10 != 2 && (i11 <= HwViewPager.this.f44772e || i11 >= currentAdapter.getCount() - HwViewPager.this.f44769d)) {
                    HwViewPager.this.m55850b(iM55944c, false);
                }
            }
            this.f44837a.onPageScrollStateChanged(i10);
        }

        @Override // com.huawei.uikit.hwviewpager.widget.HwViewPager.OnPageChangeListener
        public void onPageScrolled(int i10, float f10, int i11) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
            int iM55944c;
            if (HwViewPager.this.f44803s0) {
                return;
            }
            HwPagerAdapter currentAdapter = HwViewPager.this.getCurrentAdapter();
            if (currentAdapter != null) {
                if ((currentAdapter instanceof com.huawei.uikit.hwviewpager.widget.aauaf) && HwViewPager.this.f44805t0) {
                    com.huawei.uikit.hwviewpager.widget.aauaf aauafVar = (com.huawei.uikit.hwviewpager.widget.aauaf) currentAdapter;
                    iM55944c = aauafVar.m55944c(i10);
                    aauafVar.m55943c();
                } else {
                    currentAdapter.getCount();
                    iM55944c = i10;
                }
                if (this.f44841e) {
                    return;
                }
                boolean z10 = Float.compare(f10, 0.0f) == 0 && Float.compare(this.f44839c, 0.0f) == 0;
                boolean z11 = i10 <= HwViewPager.this.f44772e || i10 >= currentAdapter.getCount() - HwViewPager.this.f44769d;
                if (HwViewPager.this.f44805t0 && z10 && z11) {
                    this.f44841e = true;
                    HwViewPager.this.m55850b(iM55944c, false);
                    this.f44841e = false;
                }
                i10 = iM55944c;
            }
            this.f44839c = f10;
            this.f44838b = i10;
            this.f44837a.onPageScrolled(i10, f10, i11);
        }

        @Override // com.huawei.uikit.hwviewpager.widget.HwViewPager.OnPageChangeListener
        public void onPageSelected(int i10) {
            if (HwViewPager.this.f44803s0) {
                return;
            }
            HwPagerAdapter currentAdapter = HwViewPager.this.getCurrentAdapter();
            if ((currentAdapter instanceof com.huawei.uikit.hwviewpager.widget.aauaf) && HwViewPager.this.f44805t0) {
                i10 = ((com.huawei.uikit.hwviewpager.widget.aauaf) currentAdapter).m55944c(i10);
            }
            float f10 = i10;
            if (this.f44840d != f10) {
                this.f44840d = f10;
                this.f44837a.onPageSelected(i10);
            }
        }

        private bfscp(OnPageChangeListener onPageChangeListener) {
            this.f44839c = -1.0f;
            this.f44840d = -1.0f;
            this.f44841e = false;
            this.f44837a = onPageChangeListener;
            this.f44838b = -1;
        }
    }

    public class blfhz implements ValueAnimator.AnimatorUpdateListener {
        public blfhz() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator == null) {
                return;
            }
            HwViewPager.this.f44746R0.setAlpha((int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f));
            HwViewPager.this.f44746R0.invalidateSelf();
        }
    }

    public class bqmxo implements Runnable {
        public bqmxo() {
        }

        @Override // java.lang.Runnable
        public void run() throws Resources.NotFoundException {
            HwViewPager.this.setScrollState(0);
            HwViewPager.this.m55925o();
        }
    }

    public class brnby extends C9582a {
        public brnby() {
        }

        /* renamed from: a */
        private boolean m55934a() {
            HwPagerAdapter hwPagerAdapter = HwViewPager.this.f44760a;
            return hwPagerAdapter != null && hwPagerAdapter.getCount() > 1;
        }

        @Override // p273f0.C9582a
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(HwViewPager.class.getName());
            accessibilityEvent.setScrollable(m55934a());
            if (accessibilityEvent.getEventType() == 4096) {
                HwViewPager hwViewPager = HwViewPager.this;
                if (hwViewPager.f44760a != null) {
                    accessibilityEvent.setItemCount(hwViewPager.getRealCount());
                    accessibilityEvent.setFromIndex(HwViewPager.this.getCurrentItem());
                    accessibilityEvent.setToIndex(HwViewPager.this.getCurrentItem());
                }
            }
        }

        @Override // p273f0.C9582a
        public void onInitializeAccessibilityNodeInfo(View view, C9832l c9832l) {
            super.onInitializeAccessibilityNodeInfo(view, c9832l);
            c9832l.m61065U(HwViewPager.class.getName());
            c9832l.m61102q0(m55934a());
            if ((HwViewPager.this.isPageScrollHorizontal() && HwViewPager.this.canScrollHorizontally(1)) || (!HwViewPager.this.isPageScrollHorizontal() && HwViewPager.this.canScrollVertically(1))) {
                c9832l.m61071a(4096);
            }
            if (!(HwViewPager.this.isPageScrollHorizontal() && HwViewPager.this.canScrollHorizontally(-1)) && (HwViewPager.this.isPageScrollHorizontal() || !HwViewPager.this.canScrollVertically(-1))) {
                return;
            }
            c9832l.m61071a(8192);
        }

        @Override // p273f0.C9582a
        public boolean performAccessibilityAction(View view, int i10, Bundle bundle) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
            if (super.performAccessibilityAction(view, i10, bundle)) {
                return true;
            }
            if (i10 == 4096) {
                if (!(HwViewPager.this.isPageScrollHorizontal() && HwViewPager.this.canScrollHorizontally(1)) && (HwViewPager.this.isPageScrollHorizontal() || !HwViewPager.this.canScrollVertically(1))) {
                    return false;
                }
                HwViewPager.this.f44740O0 = false;
                HwViewPager hwViewPager = HwViewPager.this;
                hwViewPager.setCurrentItem(hwViewPager.getCurrentItem() + 1);
                HwViewPager.this.f44740O0 = true;
                return true;
            }
            if (i10 != 8192) {
                return false;
            }
            if (!(HwViewPager.this.isPageScrollHorizontal() && HwViewPager.this.canScrollHorizontally(-1)) && (HwViewPager.this.isPageScrollHorizontal() || !HwViewPager.this.canScrollVertically(-1))) {
                return false;
            }
            HwViewPager.this.f44740O0 = false;
            HwViewPager hwViewPager2 = HwViewPager.this;
            hwViewPager2.setCurrentItem(hwViewPager2.getCurrentItem() - 1);
            HwViewPager.this.f44740O0 = true;
            return true;
        }
    }

    public class bxac extends DataSetObserver {
        public bxac() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
            HwViewPager.this.m55921g();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
            HwViewPager.this.m55921g();
        }
    }

    public class bzrwd implements Comparator<ItemInfo> {
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(ItemInfo itemInfo, ItemInfo itemInfo2) {
            return itemInfo.f44819b - itemInfo2.f44819b;
        }
    }

    public HwViewPager(Context context) {
        this(context, null);
    }

    public HwPagerAdapter getCurrentAdapter() {
        return this.f44760a;
    }

    private float getCurrentAnimationPosition() {
        C4676f c4676f = this.f44730J0;
        if (c4676f == null || !c4676f.m28634i()) {
            return 0.0f;
        }
        return this.f44730J0.m28683u().getPosition();
    }

    private float getEndAnimationPosition() {
        C4676f c4676f = this.f44730J0;
        if (c4676f == null || !c4676f.m28634i()) {
            return 0.0f;
        }
        return this.f44730J0.m28683u().getEndPosition();
    }

    private int getNewAnimationScrollX() {
        if (!isPageScrollHorizontal()) {
            return getScrollX();
        }
        if (this.f44809v0) {
            C4676f c4676f = this.f44730J0;
            if (c4676f == null || !c4676f.m28634i()) {
                return getScrollX();
            }
            int currentAnimationPosition = (int) getCurrentAnimationPosition();
            cancelAnimation();
            setScrollingCacheEnabled(false);
            return currentAnimationPosition;
        }
        Scroller scroller = this.f44792n;
        if (scroller == null || scroller.isFinished()) {
            return getScrollX();
        }
        int currX = this.f44794o ? this.f44792n.getCurrX() : this.f44792n.getStartX();
        this.f44792n.abortAnimation();
        setScrollingCacheEnabled(false);
        return currX;
    }

    private int getNewAnimationScrollY() {
        if (isPageScrollHorizontal()) {
            return getScrollY();
        }
        if (this.f44809v0) {
            C4676f c4676f = this.f44730J0;
            if (c4676f == null || !c4676f.m28634i()) {
                return getScrollY();
            }
            int currentAnimationPosition = (int) getCurrentAnimationPosition();
            cancelAnimation();
            setScrollingCacheEnabled(false);
            return currentAnimationPosition;
        }
        Scroller scroller = this.f44792n;
        if (scroller == null || scroller.isFinished()) {
            return getScrollY();
        }
        int currY = this.f44794o ? this.f44792n.getCurrY() : this.f44792n.getStartY();
        this.f44792n.abortAnimation();
        setScrollingCacheEnabled(false);
        return currY;
    }

    public int getRealCount() {
        HwPagerAdapter hwPagerAdapter = this.f44760a;
        return ((hwPagerAdapter instanceof com.huawei.uikit.hwviewpager.widget.aauaf) && this.f44805t0) ? ((com.huawei.uikit.hwviewpager.widget.aauaf) hwPagerAdapter).m55943c() : hwPagerAdapter.getCount();
    }

    public static HwViewPager instantiate(Context context) throws ClassNotFoundException {
        Object objInstantiate = HwWidgetInstantiator.instantiate(context, HwWidgetInstantiator.getDeviceClassName(context, HwViewPager.class, HwWidgetInstantiator.getCurrentType(context, 15, 1)), HwViewPager.class);
        if (objInstantiate instanceof HwViewPager) {
            return (HwViewPager) objInstantiate;
        }
        return null;
    }

    /* renamed from: l */
    public /* synthetic */ void m55901l() {
        this.f44712A0 = true;
    }

    /* renamed from: p */
    private void m55902p() {
        int currentItem = getCurrentItem();
        if (!isPageScrollHorizontal()) {
            this.f44792n.setFinalY(currentItem * getClientHeight());
            return;
        }
        if (isRtlLayout()) {
            currentItem = -currentItem;
        }
        this.f44792n.setFinalX(currentItem * getClientWidth());
    }

    /* renamed from: q */
    private void m55903q() {
        int velocity = (int) this.f44730J0.m28683u().getVelocity();
        int currentItem = getCurrentItem();
        if (!isPageScrollHorizontal()) {
            this.f44730J0.m28685w().m28686x(this, AbstractC4672b.f21509C, this.f44813x0, this.f44811w0, currentItem * getClientHeight(), velocity);
            return;
        }
        if (isRtlLayout()) {
            currentItem = -currentItem;
        }
        this.f44730J0.m28685w().m28686x(this, AbstractC4672b.f21508B, this.f44813x0, this.f44811w0, currentItem * getClientWidth(), velocity);
    }

    /* renamed from: r */
    private void m55904r() {
        int i10 = 0;
        while (i10 < getChildCount()) {
            if (!((LayoutParams) getChildAt(i10).getLayoutParams()).isDecor) {
                removeViewAt(i10);
                i10--;
            }
            i10++;
        }
    }

    /* renamed from: s */
    private void m55905s() {
        int iCeil;
        int iCeil2;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        float endAnimationPosition = getEndAnimationPosition() - getCurrentAnimationPosition();
        if (isPageScrollHorizontal()) {
            iCeil2 = ((int) Math.ceil(endAnimationPosition)) + scrollX;
            iCeil = scrollY;
        } else {
            iCeil = ((int) Math.ceil(endAnimationPosition)) + scrollY;
            iCeil2 = scrollX;
        }
        if (scrollX != iCeil2) {
            scrollTo(iCeil2, iCeil);
            pageScrolled(iCeil2);
        } else if (scrollY != iCeil) {
            scrollTo(iCeil2, iCeil);
            pageScrolled(iCeil);
        }
    }

    private void setAdapterInner(HwPagerAdapter hwPagerAdapter) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        HwPagerAdapter hwPagerAdapter2 = this.f44760a;
        if (hwPagerAdapter2 != null) {
            hwPagerAdapter2.mo55780a(null);
            this.f44760a.startUpdate(this);
            for (int i10 = 0; i10 < this.f44775f.size(); i10++) {
                ItemInfo itemInfo = this.f44775f.get(i10);
                this.f44760a.destroyItem(this, itemInfo.f44819b, itemInfo.f44818a);
            }
            this.f44760a.finishUpdate(this);
            this.f44775f.clear();
            m55904r();
            this.f44763b = 0;
            scrollTo(0, 0);
        }
        HwPagerAdapter hwPagerAdapter3 = this.f44760a;
        this.f44760a = hwPagerAdapter;
        this.f44766c = 0;
        if (hwPagerAdapter != null) {
            if (this.f44796p == null) {
                this.f44796p = new bxac();
            }
            this.f44760a.mo55780a(this.f44796p);
            this.f44723G = false;
            boolean z10 = this.f44776f0;
            this.f44776f0 = true;
            this.f44766c = this.f44760a.getCount();
            if (this.f44786k >= 0) {
                this.f44760a.restoreState(this.f44788l, this.f44790m);
                setCurrentItemInternal(this.f44786k, false, true);
                this.f44786k = -1;
                this.f44788l = null;
                this.f44790m = null;
            } else if (z10) {
                requestLayout();
            } else {
                m55925o();
            }
        }
        List<OnAdapterChangeListener> list = this.f44791m0;
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = this.f44791m0.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.f44791m0.get(i11).onAdapterChanged(this, hwPagerAdapter3, hwPagerAdapter);
        }
    }

    private void setChildCount(int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            ViewGroup.LayoutParams layoutParams = getChildAt(i11).getLayoutParams();
            if (layoutParams instanceof LayoutParams) {
                LayoutParams layoutParams2 = (LayoutParams) layoutParams;
                if (!layoutParams2.isDecor) {
                    layoutParams2.f44823a = 0.0f;
                }
            }
        }
    }

    private void setCurrentItemWithoutNotification(int i10) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        this.f44803s0 = true;
        m55818a(i10, false);
        this.f44803s0 = false;
    }

    private void setScrollingCacheEnabled(boolean z10) {
        if (this.f44721F != z10) {
            this.f44721F = z10;
        }
    }

    private void setSensitivityMode(int i10) {
        if (i10 == 0) {
            this.f44745R = 1.4f;
        } else if (i10 == 2) {
            this.f44745R = 1.0f;
        } else {
            this.f44745R = 1.4f;
        }
    }

    private void setValueFromPlume(Context context) {
        Method method = HwReflectUtil.getMethod("getBoolean", new Class[]{Context.class, View.class, String.class, Boolean.TYPE}, "huawei.android.widget.HwPlume");
        if (method == null) {
            return;
        }
        Object objInvokeMethod = HwReflectUtil.invokeMethod(null, method, new Object[]{context, this, "changePageEnabled", Boolean.TRUE});
        if (objInvokeMethod instanceof Boolean) {
            setExtendedChangePageEnabled(((Boolean) objInvokeMethod).booleanValue());
        }
    }

    /* renamed from: t */
    private void m55906t() {
        this.f44730J0.m28627b(this.f44732K0);
        this.f44730J0.m28628c(this.f44734L0);
    }

    /* renamed from: u */
    private boolean m55907u() {
        this.f44747S = -1;
        m55892h();
        this.f44770d0.onRelease();
        this.f44773e0.onRelease();
        return this.f44770d0.isFinished() || this.f44773e0.isFinished();
    }

    /* renamed from: v */
    private void m55908v() throws Resources.NotFoundException {
        if (this.f44809v0) {
            float fAbs = Math.abs(getCurrentAnimationPosition());
            float fAbs2 = Math.abs(getEndAnimationPosition());
            if (this.f44801r0 != 2 || Float.compare(Math.abs(fAbs - fAbs2), this.f44761a0) <= 0) {
                m55832a(false);
                this.f44727I = false;
                return;
            }
            this.f44792n.abortAnimation();
            cancelAnimation();
            this.f44723G = false;
            m55925o();
            this.f44727I = true;
            m55864c(true);
            setScrollState(1);
            return;
        }
        boolean z10 = !isPageScrollHorizontal() ? Math.abs(this.f44792n.getFinalY() - this.f44792n.getCurrY()) <= this.f44761a0 : Math.abs(this.f44792n.getFinalX() - this.f44792n.getCurrX()) <= this.f44761a0;
        boolean z11 = !isPageScrollHorizontal() ? Math.abs(this.f44792n.getFinalY() - getScrollY()) <= this.f44761a0 : Math.abs(this.f44792n.getFinalX() - getScrollX()) <= this.f44761a0;
        if (this.f44801r0 != 2 || (!z10 && !z11)) {
            m55832a(false);
            this.f44727I = false;
            return;
        }
        this.f44792n.abortAnimation();
        this.f44723G = false;
        m55925o();
        this.f44727I = true;
        m55864c(true);
        setScrollState(1);
    }

    /* renamed from: w */
    private void m55909w() {
        if (this.f44797p0 != 0) {
            ArrayList<View> arrayList = this.f44799q0;
            if (arrayList == null) {
                this.f44799q0 = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                this.f44799q0.add(getChildAt(i10));
            }
            Collections.sort(this.f44799q0, f44688c2);
        }
    }

    /* renamed from: x */
    private void m55910x() {
        this.f44718D0.setDuration(300L);
        this.f44718D0.addUpdateListener(new avpbg());
        this.f44718D0.setInterpolator(this.f44750T0);
        this.f44718D0.start();
    }

    /* renamed from: y */
    private void m55911y() {
        if (this.f44714B0 || this.f44746R0 == null) {
            return;
        }
        ValueAnimator valueAnimator = this.f44718D0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f44718D0.cancel();
        }
        this.f44718D0 = ValueAnimator.ofFloat(this.f44810w, this.f44812x);
        m55910x();
    }

    /* renamed from: z */
    private void m55912z() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.f44812x, this.f44810w);
        this.f44718D0 = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(300L);
        this.f44718D0.addUpdateListener(new blfhz());
        this.f44718D0.setInterpolator(this.f44750T0);
        this.f44718D0.start();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i10, int i11) {
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            m55831a(arrayList, i10, i11);
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if ((i11 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) {
                return;
            }
            arrayList.add(this);
        }
    }

    public void addOnAdapterChangeListener(OnAdapterChangeListener onAdapterChangeListener) {
        if (this.f44791m0 == null) {
            this.f44791m0 = new ArrayList();
        }
        this.f44791m0.add(onAdapterChangeListener);
    }

    public void addOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        if (this.f44805t0) {
            bfscp bfscpVar = new bfscp(this, onPageChangeListener, null);
            this.f44782i.put(onPageChangeListener, bfscpVar);
            onPageChangeListener = bfscpVar;
        }
        if (this.f44785j0 == null) {
            this.f44785j0 = new ArrayList();
        }
        this.f44785j0.add(onPageChangeListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        ItemInfo itemInfoM55918c;
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() == 0 && (itemInfoM55918c = m55918c(childAt)) != null && itemInfoM55918c.f44819b == this.f44763b) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        if (!(layoutParams instanceof LayoutParams)) {
            Log.e(f44692h1, "addView: LayoutParams lp is null or not layout params!");
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        boolean zM55876d = layoutParams2.isDecor | m55876d(view);
        layoutParams2.isDecor = zM55876d;
        if (!this.f44717D) {
            super.addView(view, i10, layoutParams);
        } else {
            if (zM55876d) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            layoutParams2.f44824b = true;
            addViewInLayout(view, i10, layoutParams);
        }
    }

    public boolean arrowScroll(int i10) {
        View viewFindFocus = findFocus();
        if (viewFindFocus == this) {
            viewFindFocus = null;
        } else if (viewFindFocus != null) {
            for (ViewParent parent = viewFindFocus.getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
                if (parent == this) {
                    break;
                }
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(viewFindFocus.getClass().getSimpleName());
            for (ViewParent parent2 = viewFindFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                sb2.append(" => ");
                sb2.append(parent2.getClass().getSimpleName());
            }
            Log.e(f44692h1, "arrowScroll tried to find focus based on non-child current focused view " + sb2.toString());
            viewFindFocus = null;
        }
        return m55858b(i10, viewFindFocus);
    }

    public boolean beginFakeDrag() {
        if (this.f44727I) {
            return false;
        }
        this.f44764b0 = true;
        setScrollState(1);
        if (isPageScrollHorizontal()) {
            this.f44741P = 0.0f;
            this.f44737N = 0.0f;
        } else {
            this.f44743Q = 0.0f;
            this.f44739O = 0.0f;
        }
        VelocityTracker velocityTracker = this.f44749T;
        if (velocityTracker == null) {
            this.f44749T = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 0, 0.0f, 0.0f, 0);
        this.f44749T.addMovement(motionEventObtain);
        motionEventObtain.recycle();
        this.f44767c0 = jUptimeMillis;
        return true;
    }

    public boolean canScroll(View view, boolean z10, int i10, int i11, int i12) {
        int i13;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i14 = i11 + scrollX;
                if (i14 >= childAt.getLeft() && i14 < childAt.getRight() && (i13 = i12 + scrollY) >= childAt.getTop() && i13 < childAt.getBottom() && canScroll(childAt, true, i10, i14 - childAt.getLeft(), i13 - childAt.getTop())) {
                    return true;
                }
            }
        }
        if (isPageScrollHorizontal()) {
            if (z10 && view.canScrollHorizontally(-i10)) {
                return true;
            }
        } else if (z10 && view.canScrollVertically(-i10)) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i10) {
        if (this.f44760a == null) {
            return false;
        }
        int currentItem = getCurrentItem();
        int count = this.f44760a.getCount();
        if (i10 < 0) {
            if (isRtlLayout()) {
                if (currentItem == count - 1) {
                    return false;
                }
            } else if (currentItem == 0) {
                return false;
            }
        } else {
            if (i10 <= 0) {
                return false;
            }
            if (isRtlLayout()) {
                if (currentItem == 0) {
                    return false;
                }
            } else if (currentItem == count - 1) {
                return false;
            }
        }
        return true;
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i10) {
        if (this.f44760a == null) {
            return false;
        }
        int clientHeight = getClientHeight();
        int scrollY = getScrollY();
        return i10 < 0 ? scrollY > ((int) (((float) clientHeight) * this.f44814y)) : i10 > 0 && scrollY < ((int) (((float) clientHeight) * this.f44816z));
    }

    public void cancelAnimation() {
        C4676f c4676f = this.f44730J0;
        if (c4676f == null || !c4676f.m28634i()) {
            return;
        }
        this.f44730J0.m28635j(this.f44732K0);
        this.f44730J0.m28636m(this.f44734L0);
        this.f44730J0.m28629d();
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public void clearOnPageChangeListeners() {
        if (isRtlLayout()) {
            this.f44782i.clear();
        }
        List<OnPageChangeListener> list = this.f44785j0;
        if (list != null) {
            list.clear();
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        this.f44794o = true;
        if (this.f44792n.isFinished() || !this.f44792n.computeScrollOffset()) {
            if (this.f44809v0) {
                return;
            }
            m55832a(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.f44792n.getCurrX();
        int currY = this.f44792n.getCurrY();
        if (scrollX != currX || scrollY != currY) {
            scrollTo(currX, currY);
            if (!pageScrolled(currX)) {
                this.f44792n.abortAnimation();
                scrollTo(0, currY);
            }
        }
        C9603h0.m59884g0(this);
    }

    public HwGenericEventDetector createGenericEventDetector() {
        return new HwGenericEventDetector(getContext());
    }

    public HwGenericEventDetector.OnChangePageListener createOnChangePageListener() {
        return new HwGenericEventDetector.OnChangePageListener() { // from class: com.huawei.uikit.hwviewpager.widget.d
            @Override // com.huawei.uikit.hwunifiedinteract.widget.HwGenericEventDetector.OnChangePageListener
            public final boolean onChangePage(float f10, MotionEvent motionEvent) {
                return this.f44874a.m55835a(f10, motionEvent);
            }
        };
    }

    public HwGenericEventDetector.OnScrollListener createOnScrollListener() {
        return null;
    }

    public int determineTargetPage(int i10, float f10, int i11, int i12) {
        int iM55799a = isPageScrollHorizontal() ? m55799a(i10, f10, i11, i12) : m55842b(i10, f10, i11, i12);
        if (this.f44775f.size() <= 0) {
            return iM55799a;
        }
        return Math.max(this.f44775f.get(0).f44819b, Math.min(iM55799a, this.f44775f.get(r1.size() - 1).f44819b));
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || executeKeyEvent(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        ItemInfo itemInfoM55918c;
        if (accessibilityEvent == null) {
            return false;
        }
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() == 0 && (itemInfoM55918c = m55918c(childAt)) != null && itemInfoM55918c.f44819b == this.f44763b && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean zDraw;
        HwPagerAdapter hwPagerAdapter;
        if (canvas == null) {
            return;
        }
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        if (overScrollMode != 0 && (overScrollMode != 1 || (hwPagerAdapter = this.f44760a) == null || hwPagerAdapter.getCount() <= 1)) {
            this.f44770d0.finish();
            this.f44773e0.finish();
            return;
        }
        if (this.f44770d0.isFinished()) {
            zDraw = false;
        } else {
            int iSave = canvas.save();
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int width = getWidth();
            canvas.rotate(270.0f);
            canvas.translate((-height) + getPaddingTop(), this.f44814y * width);
            this.f44770d0.setSize(height, width);
            zDraw = this.f44770d0.draw(canvas);
            canvas.restoreToCount(iSave);
        }
        if (!this.f44773e0.isFinished()) {
            int iSave2 = canvas.save();
            int width2 = getWidth();
            int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
            canvas.rotate(90.0f);
            canvas.translate(-getPaddingTop(), (-(this.f44816z + 1.0f)) * width2);
            this.f44773e0.setSize(height2, width2);
            zDraw |= this.f44773e0.draw(canvas);
            canvas.restoreToCount(iSave2);
        }
        if (zDraw) {
            C9603h0.m59884g0(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f44800r;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    public void endFakeDrag() throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (!this.f44764b0) {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        }
        if (this.f44760a != null && this.f44747S != -1) {
            VelocityTracker velocityTracker = this.f44749T;
            velocityTracker.computeCurrentVelocity(1000, this.f44753V);
            int xVelocity = (int) (isPageScrollHorizontal() ? velocityTracker.getXVelocity(this.f44747S) : velocityTracker.getYVelocity(this.f44747S));
            this.f44723G = true;
            if (isPageScrollHorizontal()) {
                m55862c(xVelocity);
            } else {
                m55871d(xVelocity);
            }
        }
        m55892h();
        this.f44764b0 = false;
    }

    public boolean executeKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 21) {
                return keyEvent.hasModifiers(2) ? m55923m() : arrowScroll(17);
            }
            if (keyCode == 22) {
                return keyEvent.hasModifiers(2) ? m55924n() : arrowScroll(66);
            }
            if (keyCode == 61) {
                if (keyEvent.hasNoModifiers()) {
                    return arrowScroll(2);
                }
                if (keyEvent.hasModifiers(1)) {
                    return arrowScroll(1);
                }
            }
        }
        return false;
    }

    public void fakeDragBy(float f10) {
        if (!this.f44764b0) {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        }
        if (this.f44760a == null || this.f44775f.size() <= 0) {
            return;
        }
        if (isPageScrollHorizontal()) {
            this.f44737N += f10;
        } else {
            this.f44739O += f10;
        }
        float fM55797a = m55797a((isPageScrollHorizontal() ? getScrollX() : getScrollY()) - f10, isPageScrollHorizontal() ? getClientWidth() : getClientHeight());
        if (isPageScrollHorizontal()) {
            int i10 = (int) fM55797a;
            this.f44737N += fM55797a - i10;
            scrollTo(i10, getScrollY());
        } else {
            int i11 = (int) fM55797a;
            this.f44739O += fM55797a - i11;
            scrollTo(getScrollX(), i11);
        }
        pageScrolled((int) fM55797a);
        long jUptimeMillis = SystemClock.uptimeMillis();
        MotionEvent motionEventObtain = isPageScrollHorizontal() ? MotionEvent.obtain(this.f44767c0, jUptimeMillis, 2, this.f44737N, 0.0f, 0) : MotionEvent.obtain(this.f44767c0, jUptimeMillis, 2, 0.0f, this.f44739O, 0);
        this.f44749T.addMovement(motionEventObtain);
        motionEventObtain.recycle();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public HwPagerAdapter getAdapter() {
        HwPagerAdapter hwPagerAdapter = this.f44760a;
        return hwPagerAdapter instanceof com.huawei.uikit.hwviewpager.widget.aauaf ? ((com.huawei.uikit.hwviewpager.widget.aauaf) hwPagerAdapter).m55942b() : hwPagerAdapter;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i10, int i11) {
        if (this.f44797p0 == 2) {
            i11 = (i10 - 1) - i11;
        }
        if (this.f44799q0.size() == 0) {
            return 0;
        }
        if (i11 < 0) {
            i11 = 0;
        } else if (i11 >= this.f44799q0.size()) {
            i11 = this.f44799q0.size() - 1;
        }
        ViewGroup.LayoutParams layoutParams = this.f44799q0.get(i11).getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            return ((LayoutParams) layoutParams).f44826d;
        }
        return 0;
    }

    public int getClientHeight() {
        return (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
    }

    public int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public int getCurrentItem() {
        int i10 = this.f44763b;
        HwPagerAdapter hwPagerAdapter = this.f44760a;
        return ((hwPagerAdapter instanceof com.huawei.uikit.hwviewpager.widget.aauaf) && this.f44805t0) ? ((com.huawei.uikit.hwviewpager.widget.aauaf) hwPagerAdapter).m55944c(i10) : i10;
    }

    public float getEndShadowAlpha() {
        return this.f44812x;
    }

    public float getHwSpringDamping() {
        return this.f44811w0;
    }

    public float getHwSpringStiffness() {
        return this.f44813x0;
    }

    public int getOffscreenPageLimit() {
        return this.f44725H;
    }

    public int getPageMargin() {
        return this.f44798q;
    }

    public int getPageScrollDirection() {
        return this.f44742P0;
    }

    public float getPageSwitchThreshold() {
        return this.f44809v0 ? 0.5f : 0.6f;
    }

    public boolean getReverseDrawingOrder() {
        return this.f44719E;
    }

    public float getRotaryVelocity() {
        HwGenericEventDetector hwGenericEventDetector = this.f44736M0;
        if (hwGenericEventDetector != null) {
            return hwGenericEventDetector.getVelocity();
        }
        return 0.0f;
    }

    public Scroller getScroller() {
        return this.f44792n;
    }

    public float getSensitivity() {
        HwGenericEventDetector hwGenericEventDetector = this.f44736M0;
        if (hwGenericEventDetector != null) {
            return hwGenericEventDetector.getSensitivity();
        }
        return 1.4f;
    }

    public int getShadowColor() {
        return this.f44748S0;
    }

    public boolean getShadowEnable() {
        return this.f44724G0;
    }

    public float getSpringInterpolatorEndPos() {
        return this.f44728I0;
    }

    public float getStartShadowAlpha() {
        return this.f44810w;
    }

    public float getVelocityRatio() {
        return this.f44726H0;
    }

    public ItemInfo infoForCurrentScrollPosition() {
        float scrollX;
        int i10;
        boolean z10 = isPageScrollHorizontal() && isRtlLayout();
        float clientWidth = isPageScrollHorizontal() ? getClientWidth() : getClientHeight();
        float f10 = 0.0f;
        if (clientWidth > 0.0f) {
            scrollX = (isPageScrollHorizontal() ? getScrollX() : getScrollY()) / clientWidth;
        } else {
            scrollX = 0.0f;
        }
        if (z10) {
            scrollX = -scrollX;
        }
        float f11 = clientWidth > 0.0f ? this.f44798q / clientWidth : 0.0f;
        int i11 = -1;
        int i12 = 0;
        boolean z11 = true;
        ItemInfo itemInfo = null;
        float f12 = 0.0f;
        while (i12 < this.f44775f.size()) {
            ItemInfo itemInfo2 = this.f44775f.get(i12);
            if (!z11 && itemInfo2.f44819b != (i10 = i11 + 1)) {
                itemInfo2 = this.f44778g;
                itemInfo2.f44822e = f10 + f12 + f11;
                itemInfo2.f44819b = i10;
                itemInfo2.f44821d = isPageScrollHorizontal() ? this.f44760a.getPageWidth(itemInfo2.f44819b) : this.f44760a.getPageHeight(itemInfo2.f44819b);
                i12--;
            }
            ItemInfo itemInfo3 = itemInfo2;
            f10 = itemInfo3.f44822e;
            float f13 = itemInfo3.f44821d + f10 + f11;
            if (!z11 && scrollX < f10) {
                return itemInfo;
            }
            if (scrollX < f13 || i12 == this.f44775f.size() - 1) {
                return itemInfo3;
            }
            i11 = itemInfo3.f44819b;
            i12++;
            z11 = false;
            itemInfo = itemInfo3;
            f12 = itemInfo3.f44821d;
        }
        return itemInfo;
    }

    public boolean isAutoRtlLayoutEnabled() {
        return this.f44817z0;
    }

    public boolean isDynamicSpringAnimaitionEnabled() {
        return this.f44809v0;
    }

    public boolean isExtendedChangePageEnabled() {
        return this.f44738N0;
    }

    public boolean isFakeDragging() {
        return this.f44764b0;
    }

    public boolean isPageScrollHorizontal() {
        return this.f44742P0 == 0;
    }

    public boolean isRtlLayout() {
        if (!this.f44817z0) {
            return false;
        }
        String language = Locale.getDefault().getLanguage();
        return (language.contains(Constants.AR_CACHE) || language.contains("fa") || language.contains("iw")) || (language.contains("ug") || language.contains(Constants.URDU_LANG));
    }

    public boolean isSpringInterpolatorEnable() {
        return this.f44815y0;
    }

    public boolean isSupportLoop() {
        return this.f44805t0;
    }

    public boolean isSupportRltLayout() {
        return isRtlLayout();
    }

    /* renamed from: m */
    public boolean m55923m() throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (this.f44712A0 && this.f44760a != null) {
            int i10 = this.f44763b;
            if (i10 > 0) {
                this.f44740O0 = false;
                if (isPageScrollHorizontal() && isRtlLayout()) {
                    HwPagerAdapter hwPagerAdapter = this.f44760a;
                    if (hwPagerAdapter != null && this.f44763b == hwPagerAdapter.getCount() - 1) {
                        return false;
                    }
                    m55844b();
                    setCurrentItem(this.f44763b + 1, true);
                } else {
                    m55807a();
                    setCurrentItem(this.f44763b - 1, true);
                }
                this.f44740O0 = true;
                return true;
            }
            if (i10 == 0 && isPageScrollHorizontal() && isRtlLayout()) {
                HwPagerAdapter hwPagerAdapter2 = this.f44760a;
                if (hwPagerAdapter2 != null && hwPagerAdapter2.getCount() == 1) {
                    return false;
                }
                setCurrentItem(this.f44763b + 1, true);
                return true;
            }
        }
        return false;
    }

    /* renamed from: n */
    public boolean m55924n() throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        HwPagerAdapter hwPagerAdapter;
        if (this.f44712A0 && (hwPagerAdapter = this.f44760a) != null) {
            if (this.f44763b < hwPagerAdapter.getCount() - 1) {
                this.f44740O0 = false;
                if (!isPageScrollHorizontal() || !isRtlLayout()) {
                    m55844b();
                    setCurrentItem(this.f44763b + 1, true);
                } else {
                    if (this.f44763b == 0) {
                        return false;
                    }
                    m55807a();
                    setCurrentItem(this.f44763b - 1, true);
                }
                this.f44740O0 = true;
                return true;
            }
            if (this.f44763b == this.f44760a.getCount() - 1 && isPageScrollHorizontal() && isRtlLayout()) {
                setCurrentItem(this.f44763b - 1, true);
                return true;
            }
        }
        return false;
    }

    public void nextPage() throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        nextPage(true);
    }

    /* renamed from: o */
    public void m55925o() throws Resources.NotFoundException {
        populate(this.f44763b);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f44776f0 = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.f44784j);
        Scroller scroller = this.f44792n;
        if (scroller != null && !scroller.isFinished()) {
            this.f44792n.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float f10;
        float f11;
        super.onDraw(canvas);
        if (this.f44798q <= 0 || this.f44800r == null || this.f44775f.size() <= 0 || this.f44760a == null) {
            return;
        }
        int scrollX = isPageScrollHorizontal() ? getScrollX() : getScrollY();
        int width = isPageScrollHorizontal() ? getWidth() : getHeight();
        float f12 = width <= 0 ? 0.0f : this.f44798q / width;
        ItemInfo itemInfo = this.f44775f.get(0);
        float f13 = itemInfo.f44822e;
        int size = this.f44775f.size();
        int i10 = itemInfo.f44819b;
        int i11 = this.f44775f.get(size - 1).f44819b;
        int i12 = i10;
        int i13 = 0;
        while (i12 < i11) {
            ItemInfo itemInfo2 = itemInfo;
            int i14 = i13;
            while (i12 > itemInfo2.f44819b && i14 < size) {
                i14++;
                itemInfo2 = this.f44775f.get(i14);
            }
            boolean z10 = isPageScrollHorizontal() && isRtlLayout();
            if (i12 == itemInfo2.f44819b) {
                float f14 = z10 ? -(itemInfo2.f44822e + itemInfo2.f44821d) : itemInfo2.f44822e + itemInfo2.f44821d;
                float f15 = width * f14;
                f10 = z10 ? f14 - f12 : f14 + f12;
                f11 = f15;
            } else {
                float pageWidth = isPageScrollHorizontal() ? this.f44760a.getPageWidth(i12) : this.f44760a.getPageHeight(i12);
                float f16 = (z10 ? f13 - pageWidth : f13 + pageWidth) * width;
                float f17 = pageWidth + f12;
                f10 = z10 ? f13 - f17 : f13 + f17;
                f11 = f16;
            }
            if (m55837a(canvas, scrollX, width, f11, z10)) {
                return;
            }
            i12++;
            itemInfo = itemInfo2;
            i13 = i14;
            f13 = f10;
        }
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        HwGenericEventDetector hwGenericEventDetector;
        if (!this.f44738N0 || (hwGenericEventDetector = this.f44736M0) == null) {
            return super.onGenericMotionEvent(motionEvent);
        }
        if (hwGenericEventDetector.onGenericMotionEvent(motionEvent)) {
            return true;
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            m55907u();
            return false;
        }
        if (action != 0) {
            if (this.f44727I) {
                return true;
            }
            if (this.f44729J) {
                return false;
            }
        }
        if (m55867c(motionEvent, action)) {
            return false;
        }
        if (this.f44749T == null) {
            this.f44749T = VelocityTracker.obtain();
        }
        this.f44749T.addMovement(motionEvent);
        return this.f44727I;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        int childCount = getChildCount();
        int i14 = i12 - i10;
        int i15 = i13 - i11;
        this.f44756W0 = getPaddingLeft();
        this.f44757X0 = getPaddingTop();
        this.f44758Y0 = getPaddingRight();
        this.f44759Z0 = getPaddingBottom();
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int i16 = 0;
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt = getChildAt(i17);
            if (childAt.getVisibility() != 8) {
                m55813a(i14, i15, scrollX, scrollY, childAt);
                i16++;
            }
        }
        int i18 = (i14 - this.f44756W0) - this.f44758Y0;
        int i19 = (i15 - this.f44757X0) - this.f44759Z0;
        Rect rect = new Rect(this.f44756W0, this.f44757X0, this.f44758Y0, this.f44759Z0);
        for (int i20 = 0; i20 < childCount; i20++) {
            if (isPageScrollHorizontal()) {
                m55814a(i20, i18, i15, rect);
            } else {
                m55849b(i20, i19, i14, rect);
            }
        }
        if (isPageScrollHorizontal()) {
            this.f44802s = this.f44757X0;
            this.f44804t = i15 - this.f44759Z0;
        } else {
            this.f44806u = this.f44756W0;
            this.f44808v = i14 - this.f44758Y0;
        }
        this.f44783i0 = i16;
        if (this.f44776f0) {
            m55819a(this.f44763b, false, 0, false);
        }
        this.f44776f0 = false;
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) throws Resources.NotFoundException {
        setMeasuredDimension(View.getDefaultSize(0, i10), View.getDefaultSize(0, i11));
        int measuredWidth = getMeasuredWidth();
        this.f44733L = Math.min(measuredWidth / 10, this.f44731K);
        this.f44752U0 = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        this.f44754V0 = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                m55822a(childAt, (LayoutParams) childAt.getLayoutParams());
            }
        }
        this.f44713B = View.MeasureSpec.makeMeasureSpec(this.f44752U0, 1073741824);
        this.f44715C = View.MeasureSpec.makeMeasureSpec(this.f44754V0, 1073741824);
        this.f44717D = true;
        m55925o();
        this.f44717D = false;
        int childCount2 = getChildCount();
        for (int i13 = 0; i13 < childCount2; i13++) {
            m55811a(this.f44752U0, this.f44754V0, i13);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x0052, code lost:
    
        r3 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onPageScrolled(int r5, float r6, int r7) {
        /*
            r4 = this;
            int r0 = r4.f44783i0
            if (r0 <= 0) goto L11
            boolean r0 = r4.isPageScrollHorizontal()
            if (r0 == 0) goto Le
            r4.m55877e()
            goto L11
        Le:
            r4.m55883f()
        L11:
            r4.m55810a(r5, r6, r7)
            com.huawei.uikit.hwviewpager.widget.HwViewPager$PageTransformer r5 = r4.f44793n0
            r6 = 1
            if (r5 == 0) goto L5b
            boolean r5 = r4.isPageScrollHorizontal()
            if (r5 == 0) goto L24
            int r5 = r4.getScrollX()
            goto L28
        L24:
            int r5 = r4.getScrollY()
        L28:
            int r7 = r4.getChildCount()
            r0 = 0
            r1 = r0
        L2e:
            if (r1 >= r7) goto L5b
            android.view.View r2 = r4.getChildAt(r1)
            android.view.ViewGroup$LayoutParams r3 = r2.getLayoutParams()
            com.huawei.uikit.hwviewpager.widget.HwViewPager$LayoutParams r3 = (com.huawei.uikit.hwviewpager.widget.HwViewPager.LayoutParams) r3
            boolean r3 = r3.isDecor
            if (r3 == 0) goto L3f
            goto L58
        L3f:
            boolean r3 = r4.isPageScrollHorizontal()
            if (r3 == 0) goto L4c
            int r3 = r4.getClientWidth()
            if (r3 <= 0) goto L54
            goto L52
        L4c:
            int r3 = r4.getClientHeight()
            if (r3 <= 0) goto L54
        L52:
            r3 = r6
            goto L55
        L54:
            r3 = r0
        L55:
            r4.m55817a(r5, r2, r3)
        L58:
            int r1 = r1 + 1
            goto L2e
        L5b:
            r4.f44781h0 = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.uikit.hwviewpager.widget.HwViewPager.onPageScrolled(int, float, int):void");
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i10, Rect rect) {
        int i11;
        int i12;
        int i13;
        int childCount = getChildCount();
        if ((i10 & 2) != 0) {
            i12 = childCount;
            i11 = 0;
            i13 = 1;
        } else {
            i11 = childCount - 1;
            i12 = -1;
            i13 = -1;
        }
        while (i11 != i12) {
            if (m55836a(i10, rect, i11)) {
                return true;
            }
            i11 += i13;
        }
        return false;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (parcelable instanceof RtlSavedState) {
            RtlSavedState rtlSavedState = (RtlSavedState) parcelable;
            Parcelable parcelable2 = rtlSavedState.f44827a;
            if (!(parcelable2 instanceof SavedState)) {
                super.onRestoreInstanceState(parcelable2);
                return;
            }
            SavedState savedState = (SavedState) parcelable2;
            super.onRestoreInstanceState(savedState.getSuperState());
            HwPagerAdapter hwPagerAdapter = this.f44760a;
            if (hwPagerAdapter != null) {
                hwPagerAdapter.restoreState(savedState.f44831b, savedState.f44832c);
                setCurrentItemInternal(savedState.f44830a, false, true);
            } else {
                this.f44786k = savedState.f44830a;
                this.f44788l = savedState.f44831b;
                this.f44790m = savedState.f44832c;
            }
            if (rtlSavedState.f44829c != isRtlLayout()) {
                this.f44740O0 = false;
                setCurrentItem(rtlSavedState.f44828b, false);
                this.f44740O0 = true;
            }
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f44830a = this.f44763b;
        HwPagerAdapter hwPagerAdapter = this.f44760a;
        if (hwPagerAdapter != null) {
            savedState.f44831b = hwPagerAdapter.saveState();
        }
        return new RtlSavedState(savedState, this.f44763b, isRtlLayout());
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        Drawable drawable = this.f44746R0;
        if (drawable != null && i11 != i13) {
            drawable.setBounds(0, 0, i10, i11);
        }
        if (i10 != i12 || i11 != i13) {
            this.f44776f0 = true;
        }
        if (isPageScrollHorizontal()) {
            if (i10 != i12) {
                m55863c(i10, i12);
            }
        } else if (i11 != i13) {
            m55863c(i11, i13);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        HwPagerAdapter hwPagerAdapter;
        if (motionEvent == null) {
            return false;
        }
        if (this.f44764b0) {
            return true;
        }
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (hwPagerAdapter = this.f44760a) == null || hwPagerAdapter.getCount() == 0) {
            return false;
        }
        if (this.f44749T == null) {
            this.f44749T = VelocityTracker.obtain();
        }
        this.f44749T.addMovement(motionEvent);
        int action = motionEvent.getAction();
        this.f44762a1 = false;
        int i10 = action & 255;
        if (i10 == 0) {
            m55887f(motionEvent);
        } else if (i10 == 1) {
            m55879e(motionEvent);
        } else if (i10 != 2) {
            if (i10 == 3) {
                m55838a(motionEvent);
            } else if (i10 == 5) {
                m55866c(motionEvent);
            } else if (i10 == 6) {
                m55873d(motionEvent);
            }
        } else {
            if (this.f44714B0) {
                setScrollState(1);
                return true;
            }
            m55852b(motionEvent);
        }
        if (this.f44762a1) {
            C9603h0.m59884g0(this);
        }
        return true;
    }

    public boolean pageScrolled(int i10) {
        if (this.f44775f.size() == 0) {
            if (this.f44776f0) {
                return false;
            }
            this.f44781h0 = false;
            onPageScrolled(0, 0.0f, 0);
            if (this.f44781h0) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        ItemInfo itemInfoInfoForCurrentScrollPosition = infoForCurrentScrollPosition();
        if (itemInfoInfoForCurrentScrollPosition == null) {
            Log.e(f44692h1, "pageScrolled: ItemInfo is null!");
            return false;
        }
        int clientWidth = isPageScrollHorizontal() ? getClientWidth() : getClientHeight();
        int i11 = this.f44798q;
        int i12 = clientWidth + i11;
        float f10 = clientWidth <= 0 ? 0.0f : i11 / clientWidth;
        int i13 = itemInfoInfoForCurrentScrollPosition.f44819b;
        boolean z10 = clientWidth > 0 && itemInfoInfoForCurrentScrollPosition.f44821d + f10 > 0.0f;
        if (isPageScrollHorizontal() && isRtlLayout()) {
            i10 = -i10;
        }
        float f11 = z10 ? ((i10 / clientWidth) - itemInfoInfoForCurrentScrollPosition.f44822e) / (itemInfoInfoForCurrentScrollPosition.f44821d + f10) : 0.0f;
        this.f44781h0 = false;
        onPageScrolled(i13, f11, (int) (i12 * f11));
        if (this.f44781h0) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    public boolean performDrag(float f10) {
        return isPageScrollHorizontal() ? m55874d(f10) : m55878e(f10);
    }

    public void populate(int i10) throws Resources.NotFoundException {
        ItemInfo itemInfoM55919e;
        int i11 = this.f44763b;
        if (i11 != i10) {
            itemInfoM55919e = m55919e(i11);
            this.f44763b = i10;
        } else {
            itemInfoM55919e = null;
        }
        if (this.f44760a == null) {
            m55909w();
            return;
        }
        if (this.f44723G) {
            m55909w();
            return;
        }
        if (getWindowToken() == null) {
            return;
        }
        this.f44760a.startUpdate(this);
        m55825a(itemInfoM55919e);
        this.f44760a.finishUpdate(this);
        m55860c();
        m55909w();
        if (hasFocus()) {
            View viewFindFocus = findFocus();
            ItemInfo itemInfoM55916b = viewFindFocus != null ? m55916b(viewFindFocus) : null;
            if (itemInfoM55916b == null || itemInfoM55916b.f44819b != this.f44763b) {
                m55870d();
            }
        }
    }

    public void prePage() throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        prePage(true);
    }

    public void removeOnAdapterChangeListener(OnAdapterChangeListener onAdapterChangeListener) {
        List<OnAdapterChangeListener> list = this.f44791m0;
        if (list != null) {
            list.remove(onAdapterChangeListener);
        }
    }

    public void removeOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        if (isRtlLayout()) {
            onPageChangeListener = this.f44782i.remove(onPageChangeListener);
        }
        List<OnPageChangeListener> list = this.f44785j0;
        if (list != null) {
            list.remove(onPageChangeListener);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.f44717D) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public void setAdapter(HwPagerAdapter hwPagerAdapter) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        this.f44720E0 = hwPagerAdapter;
        if (hwPagerAdapter != null) {
            boolean z10 = this.f44805t0;
            if (z10) {
                hwPagerAdapter = new com.huawei.uikit.hwviewpager.widget.aauaf(hwPagerAdapter, z10);
            }
            if (hwPagerAdapter instanceof com.huawei.uikit.hwviewpager.widget.aauaf) {
                ((com.huawei.uikit.hwviewpager.widget.aauaf) hwPagerAdapter).m55940a(this.f44807u0);
            }
        }
        setAdapterInner(hwPagerAdapter);
        if (this.f44805t0) {
            m55818a(0, false);
        }
    }

    public void setAutoRtlLayoutEnabled(boolean z10) {
        this.f44817z0 = z10;
    }

    public void setCurrentItem(int i10) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (getCurrentItem() != i10) {
            setCurrentItem(i10, true);
        }
    }

    @Keep
    public void setCurrentItemInternal(int i10, boolean z10, boolean z11) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        setCurrentItemInternal(i10, z10, z11, 0);
    }

    public void setCustomPageThreshold(float f10) {
        if (Float.compare(f10, 0.0f) < 0 || Float.compare(f10, 1.0f) > 0) {
            Log.w(f44692h1, "The minimum threshold must be between 0 and 1.");
        } else {
            this.f44711A = f10;
        }
    }

    public void setDynamicSpringAnimaitionEnabled(boolean z10) {
        this.f44809v0 = z10;
    }

    public void setEndShadowAlpha(float f10) {
        this.f44812x = f10;
    }

    public void setExtendedChangePageEnabled(boolean z10) {
        this.f44738N0 = z10;
    }

    public void setFlingDistance(int i10) {
        if (i10 < 0) {
            Log.w(f44692h1, "The minimum distance cannot be set to a negative value.");
        } else {
            this.f44755W = i10;
        }
    }

    public void setHwSpringDamping(float f10) {
        this.f44811w0 = f10;
    }

    public void setHwSpringStiffness(float f10) {
        this.f44813x0 = f10;
    }

    public void setLoopEndCache(int i10) {
        HwPagerAdapter hwPagerAdapter;
        if (!this.f44805t0 || (hwPagerAdapter = this.f44760a) == null || i10 <= 2) {
            return;
        }
        this.f44769d = i10;
        if (hwPagerAdapter instanceof com.huawei.uikit.hwviewpager.widget.aauaf) {
            com.huawei.uikit.hwviewpager.widget.aauaf aauafVar = (com.huawei.uikit.hwviewpager.widget.aauaf) hwPagerAdapter;
            aauafVar.m55939a(i10);
            aauafVar.notifyDataSetChanged();
        }
    }

    public void setMinimumVelocity(int i10) {
        if (i10 < 0) {
            Log.w(f44692h1, "The minimum speed cannot be set to a negative value.");
        } else {
            this.f44751U = i10;
        }
    }

    public void setOffscreenPageLimit(int i10) throws Resources.NotFoundException {
        if (i10 < this.f44772e) {
            Log.w(f44692h1, "Requested offscreen page limit " + i10 + " too small; defaulting to " + this.f44772e);
            i10 = this.f44772e;
        }
        if (i10 != this.f44725H) {
            this.f44725H = i10;
            m55925o();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        if (this.f44805t0) {
            onPageChangeListener = new bfscp(this, onPageChangeListener, null);
        }
        this.f44787k0 = onPageChangeListener;
    }

    public void setPageMargin(int i10) {
        this.f44798q = i10;
        int width = isPageScrollHorizontal() ? getWidth() : getHeight();
        m55863c(width, width);
        requestLayout();
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.f44800r = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageScrollDirection(int i10) {
        if ((i10 == 1 || i10 == 0) && this.f44742P0 != i10) {
            this.f44742P0 = i10;
            requestLayout();
        }
    }

    public void setPageTransformer(boolean z10, PageTransformer pageTransformer) throws Resources.NotFoundException {
        setPageTransformer(z10, pageTransformer, 2);
    }

    public void setPageTurningEnabled(boolean z10) {
        this.f44714B0 = z10;
        if (z10 && this.f44722F0 == null) {
            this.f44722F0 = new HwPageTurningHelper(this);
        }
    }

    public void setPageTurningThresholdRatioHorizontal(float f10) {
        if (Float.compare(f10, 0.0f) < 0 || Float.compare(f10, 1.0f) > 0) {
            Log.e(f44692h1, "Please ensure that the value of ratio is greater than 0.0f and less than 1.0f.");
            return;
        }
        HwPageTurningHelper hwPageTurningHelper = this.f44722F0;
        if (hwPageTurningHelper != null) {
            hwPageTurningHelper.m55778c(f10);
        }
    }

    public void setPageTurningThresholdRatioVertical(float f10) {
        if (Float.compare(f10, 0.0f) < 0 || Float.compare(f10, 1.0f) > 0) {
            Log.e(f44692h1, "Please ensure that the value of ratio is greater than 0.0f and less than 1.0f.");
            return;
        }
        HwPageTurningHelper hwPageTurningHelper = this.f44722F0;
        if (hwPageTurningHelper != null) {
            hwPageTurningHelper.m55779d(f10);
        }
    }

    public void setReverseDrawingOrder(boolean z10) {
        if (this.f44801r0 != 0) {
            return;
        }
        this.f44719E = z10;
        if (z10) {
            this.f44797p0 = 1;
        } else {
            this.f44797p0 = 2;
        }
    }

    public void setScrollState(int i10) {
        if (this.f44801r0 == i10) {
            return;
        }
        this.f44801r0 = i10;
        if (this.f44793n0 != null) {
            m55855b(i10 != 0);
        }
        m55847b(i10);
    }

    public void setScroller(Scroller scroller) {
        if (scroller != null) {
            this.f44792n = scroller;
        }
    }

    public void setSensitivity(float f10) {
        HwGenericEventDetector hwGenericEventDetector = this.f44736M0;
        if (hwGenericEventDetector != null) {
            hwGenericEventDetector.setSensitivity(f10);
        }
    }

    public void setShadowColor(int i10) {
        this.f44748S0 = i10;
    }

    public void setShadowEnable(boolean z10) {
        this.f44724G0 = z10;
    }

    public void setSpringInterpolatorEnable(boolean z10) {
        this.f44815y0 = z10;
        if (z10 && isDynamicSpringAnimaitionEnabled()) {
            Log.w(f44692h1, "Please call setDynamicSpringAnimaitionEnabled and set false.");
        }
        if (z10) {
            return;
        }
        this.f44792n = new Scroller(getContext(), f44690e2);
    }

    public void setSpringInterpolatorEndPos(float f10) {
        this.f44728I0 = f10;
    }

    public void setStartShadowAlpha(float f10) {
        this.f44810w = f10;
    }

    public void setSupportLoop(boolean z10) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (this.f44805t0 == z10) {
            return;
        }
        this.f44805t0 = z10;
        HwPagerAdapter hwPagerAdapter = this.f44720E0;
        if (hwPagerAdapter != null) {
            setAdapter(hwPagerAdapter);
        }
    }

    public void setVelocityRatio(float f10) {
        this.f44726H0 = f10;
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f44800r;
    }

    public static class LayoutParams extends ViewGroup.LayoutParams {

        /* renamed from: a */
        float f44823a;

        /* renamed from: b */
        boolean f44824b;

        /* renamed from: c */
        int f44825c;

        /* renamed from: d */
        int f44826d;
        public int gravity;
        public boolean isDecor;

        public LayoutParams() {
            super(-1, -1);
            this.f44823a = 0.0f;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f44823a = 0.0f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, HwViewPager.f44691g1);
            this.gravity = typedArrayObtainStyledAttributes.getInteger(0, 48);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public HwViewPager(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C8744R.attr.hwViewPagerStyle);
    }

    /* renamed from: b */
    private void m55851b(Context context, AttributeSet attributeSet, int i10) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C8744R.styleable.HwViewPager, i10, 0);
        this.f44805t0 = typedArrayObtainStyledAttributes.getBoolean(C8744R.styleable.HwViewPager_hwViewPagerSupportLoop, false);
        this.f44716C0 = typedArrayObtainStyledAttributes.getInt(C8744R.styleable.HwViewPager_hwSensitivityMode, 1);
        this.f44748S0 = typedArrayObtainStyledAttributes.getColor(C8744R.styleable.HwViewPager_hwShadowColor, getResources().getColor(f44683X1));
        this.f44742P0 = typedArrayObtainStyledAttributes.getInt(C8744R.styleable.HwViewPager_android_orientation, 0);
        this.f44714B0 = typedArrayObtainStyledAttributes.getBoolean(C8744R.styleable.HwViewPager_hwViewPagerPageTurningEnabled, false);
        float f10 = typedArrayObtainStyledAttributes.getFloat(C8744R.styleable.HwViewPager_hwViewPagerPageTurningThresholdRatioVertical, 0.125f);
        float f11 = typedArrayObtainStyledAttributes.getFloat(C8744R.styleable.HwViewPager_hwViewPagerPageTurningThresholdRatioHorizontal, 0.125f);
        typedArrayObtainStyledAttributes.recycle();
        if (this.f44714B0) {
            HwPageTurningHelper hwPageTurningHelper = new HwPageTurningHelper(this);
            this.f44722F0 = hwPageTurningHelper;
            hwPageTurningHelper.m55779d(f10);
            this.f44722F0.m55778c(f11);
        }
    }

    /* renamed from: c */
    private boolean m55865c(int i10, float f10, int i11) {
        float f11 = this.f44777f1;
        if (f11 >= f10 && i11 < i10) {
            ItemInfo itemInfo = this.f44768c1;
            if (itemInfo == null) {
                return true;
            }
            if (i11 != itemInfo.f44819b || itemInfo.f44820c) {
                return false;
            }
            this.f44775f.remove(this.f44765b1);
            this.f44760a.destroyItem(this, i11, this.f44768c1.f44818a);
            int i12 = this.f44765b1 - 1;
            this.f44765b1 = i12;
            this.f44774e1--;
            this.f44768c1 = i12 >= 0 ? this.f44775f.get(i12) : null;
            return false;
        }
        ItemInfo itemInfo2 = this.f44768c1;
        if (itemInfo2 != null && i11 == itemInfo2.f44819b) {
            this.f44777f1 = f11 + itemInfo2.f44821d;
            int i13 = this.f44765b1 - 1;
            this.f44765b1 = i13;
            this.f44768c1 = i13 >= 0 ? this.f44775f.get(i13) : null;
            return false;
        }
        ItemInfo itemInfoM55914a = m55914a(i11, this.f44765b1 + 1);
        this.f44768c1 = itemInfoM55914a;
        this.f44777f1 += itemInfoM55914a.f44821d;
        this.f44774e1++;
        int i14 = this.f44765b1;
        this.f44768c1 = i14 >= 0 ? this.f44775f.get(i14) : null;
        return false;
    }

    /* renamed from: d */
    private void m55870d() {
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            ItemInfo itemInfoM55918c = m55918c(childAt);
            if (itemInfoM55918c != null && itemInfoM55918c.f44819b == this.f44763b && childAt.requestFocus(2)) {
                return;
            }
        }
    }

    /* renamed from: f */
    private void m55884f(int i10) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (this.f44727I) {
            return;
        }
        try {
            Class<?> cls = Class.forName("android.view.SceneUtil");
            Class<?> cls2 = Integer.TYPE;
            cls.getMethod("notifyAnimationState", String.class, cls2, cls2, cls2).invoke(null, "HWVIEWPAGER_SLIDE", Integer.valueOf(i10), -1, Integer.valueOf(hashCode()));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            Log.w(f44692h1, "notifyPageScrollToUifwk class or method not found");
        } catch (IllegalAccessException unused2) {
            Log.w(f44692h1, "notifyPageScrollToUifwk illegal access");
        } catch (IllegalArgumentException unused3) {
            Log.w(f44692h1, "notifyPageScrollToUifwk illegal argument");
        } catch (SecurityException unused4) {
            Log.w(f44692h1, "notifyPageScrollToUifwk not secure");
        } catch (InvocationTargetException unused5) {
            Log.w(f44692h1, "notifyPageScrollToUifwk target error");
        }
        Log.d(f44692h1, "notifyPageScrollToUifwk " + i10 + " done");
    }

    /* renamed from: h */
    private int m55891h(int i10) {
        ItemInfo itemInfoM55919e = m55919e(i10);
        if (itemInfoM55919e != null) {
            return (int) ((isPageScrollHorizontal() ? getClientWidth() : getClientHeight()) * Math.max(this.f44814y, Math.min(itemInfoM55919e.f44822e, this.f44816z)));
        }
        return 0;
    }

    /* renamed from: i */
    private void m55895i() {
        C4676f c4676f = this.f44730J0;
        if (c4676f == null || !c4676f.m28634i()) {
            return;
        }
        m55905s();
        this.f44730J0.m28635j(this.f44732K0);
        this.f44730J0.m28636m(this.f44734L0);
        this.f44730J0.m28629d();
    }

    /* renamed from: k */
    public /* synthetic */ void m55899k() {
        this.f44712A0 = true;
    }

    /* renamed from: e */
    public void m55920e(int i10, int i11) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        m55917b(i10, i11, 0);
    }

    /* renamed from: g */
    public void m55921g() throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        int count = this.f44760a.getCount();
        this.f44766c = count;
        boolean z10 = this.f44775f.size() < (this.f44725H * 2) + 1 && this.f44775f.size() < count;
        int iMax = this.f44763b;
        int i10 = 0;
        boolean z11 = false;
        while (i10 < this.f44775f.size()) {
            ItemInfo itemInfo = this.f44775f.get(i10);
            int itemPosition = this.f44760a.getItemPosition(itemInfo.f44818a);
            if (itemPosition != -1) {
                if (itemPosition == -2) {
                    this.f44775f.remove(i10);
                    i10--;
                    if (!z11) {
                        this.f44760a.startUpdate(this);
                        z11 = true;
                    }
                    this.f44760a.destroyItem(this, itemInfo.f44819b, itemInfo.f44818a);
                    int i11 = this.f44763b;
                    if (i11 == itemInfo.f44819b) {
                        iMax = Math.max(0, Math.min(i11, count - 1));
                    }
                } else {
                    int i12 = itemInfo.f44819b;
                    if (i12 != itemPosition) {
                        if (i12 == this.f44763b) {
                            iMax = itemPosition;
                        }
                        itemInfo.f44819b = itemPosition;
                    }
                }
                z10 = true;
            }
            i10++;
        }
        if (z11) {
            this.f44760a.finishUpdate(this);
        }
        Collections.sort(this.f44775f, f44689d2);
        m55833a(z10, iMax);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* renamed from: j */
    public void m55922j() {
        setWillNotDraw(false);
        setDescendantFocusability(C6051p9.f27764p);
        setFocusable(true);
        Context context = getContext();
        this.f44792n = new Scroller(context, f44690e2);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f10 = context.getResources().getDisplayMetrics().density;
        this.f44735M = viewConfiguration.getScaledPagingTouchSlop();
        if (this.f44809v0) {
            this.f44751U = 1200;
        } else {
            this.f44751U = (int) (400.0f * f10);
        }
        this.f44753V = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f44770d0 = new EdgeEffect(context);
        this.f44773e0 = new EdgeEffect(context);
        this.f44755W = (int) (25.0f * f10);
        this.f44761a0 = (int) (2.0f * f10);
        this.f44731K = (int) (f10 * 16.0f);
        C9603h0.m59902p0(this, new brnby());
        if (C9603h0.m59919y(this) == 0) {
            C9603h0.m59833A0(this, 1);
        }
        C9603h0.m59837C0(this, new akxao());
    }

    public void nextPage(boolean z10) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        nextPage(z10, true);
    }

    public void prePage(boolean z10) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        prePage(z10, false);
    }

    public void setCurrentItemInternal(int i10, boolean z10, boolean z11, int i11) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        HwPagerAdapter hwPagerAdapter = this.f44760a;
        if (hwPagerAdapter == null || hwPagerAdapter.getCount() <= 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (!z11 && this.f44763b == i10 && this.f44775f.size() != 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (i10 < 0) {
            i10 = 0;
        } else if (i10 >= this.f44760a.getCount()) {
            i10 = this.f44760a.getCount() - 1;
        }
        int i12 = this.f44725H;
        int i13 = this.f44763b;
        if (i10 > i13 + i12 || i10 < i13 - i12) {
            for (int i14 = 0; i14 < this.f44775f.size(); i14++) {
                this.f44775f.get(i14).f44820c = true;
            }
        }
        boolean z12 = this.f44763b != i10;
        if (!this.f44776f0) {
            populate(i10);
            m55819a(i10, z10, i11, z12);
        } else {
            this.f44763b = i10;
            if (z12) {
                m55809a(i10);
            }
            requestLayout();
        }
    }

    public void setPageTransformer(boolean z10, PageTransformer pageTransformer, int i10) throws Resources.NotFoundException {
        boolean z11 = pageTransformer != null;
        boolean z12 = z11 != (this.f44793n0 != null);
        this.f44793n0 = pageTransformer;
        setChildrenDrawingOrderEnabled(z11);
        if (z11) {
            this.f44797p0 = z10 ? 2 : 1;
            this.f44719E = !z10;
            this.f44795o0 = i10;
        } else {
            this.f44797p0 = 0;
        }
        if (z12) {
            m55925o();
        }
    }

    public HwViewPager(Context context, AttributeSet attributeSet, int i10) {
        super(m55803a(context, i10), attributeSet, i10);
        this.f44769d = 2;
        this.f44772e = 1;
        this.f44775f = new ArrayList<>();
        this.f44778g = new ItemInfo();
        this.f44780h = new Rect();
        this.f44782i = new C11207a();
        this.f44784j = new bqmxo();
        this.f44786k = -1;
        this.f44788l = null;
        this.f44790m = null;
        this.f44810w = 0.0f;
        this.f44812x = 0.3f;
        this.f44814y = -3.4028235E38f;
        this.f44816z = Float.MAX_VALUE;
        this.f44711A = Float.MIN_VALUE;
        this.f44725H = 2;
        this.f44745R = 1.4f;
        this.f44747S = -1;
        this.f44776f0 = true;
        this.f44779g0 = false;
        this.f44801r0 = 0;
        this.f44805t0 = false;
        this.f44807u0 = false;
        this.f44809v0 = true;
        this.f44811w0 = 30.0f;
        this.f44813x0 = f44698n1;
        this.f44815y0 = false;
        this.f44817z0 = true;
        this.f44712A0 = true;
        this.f44714B0 = false;
        this.f44724G0 = false;
        this.f44726H0 = 1.0f;
        this.f44728I0 = -1.0f;
        this.f44730J0 = new C4676f(this, AbstractC4672b.f21508B, new C4680j(this.f44813x0, this.f44811w0));
        this.f44732K0 = new AbstractC4672b.p() { // from class: com.huawei.uikit.hwviewpager.widget.b
            @Override // com.huawei.dynamicanimation.AbstractC4672b.p
            /* renamed from: a */
            public final void mo28674a(AbstractC4672b abstractC4672b, boolean z10, float f10, float f11) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
                this.f44860a.m55824a(abstractC4672b, z10, f10, f11);
            }
        };
        this.f44734L0 = new AbstractC4672b.r() { // from class: com.huawei.uikit.hwviewpager.widget.c
            @Override // com.huawei.dynamicanimation.AbstractC4672b.r
            /* renamed from: a */
            public final void mo28676a(AbstractC4672b abstractC4672b, float f10, float f11) {
                this.f44873a.m55823a(abstractC4672b, f10, f11);
            }
        };
        this.f44738N0 = true;
        this.f44740O0 = true;
        this.f44742P0 = 0;
        this.f44750T0 = C10076a.m62701a(0.4f, 0.0f, 0.2f, 1.0f);
        m55820a(getContext(), attributeSet, i10);
    }

    /* renamed from: e */
    public ItemInfo m55919e(int i10) {
        for (int i11 = 0; i11 < this.f44775f.size(); i11++) {
            ItemInfo itemInfo = this.f44775f.get(i11);
            if (itemInfo.f44819b == i10) {
                return itemInfo;
            }
        }
        return null;
    }

    public void nextPage(boolean z10, boolean z11) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        int count;
        if (getAdapter() != null && (count = getAdapter().getCount()) >= 2) {
            int currentItem = getCurrentItem();
            if (currentItem != count - 1) {
                setCurrentItem(currentItem + 1, z10);
            } else if (z11) {
                setCurrentItem(0, false);
            }
        }
    }

    public void prePage(boolean z10, boolean z11) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        int count;
        if (getAdapter() != null && (count = getAdapter().getCount()) >= 2) {
            int currentItem = getCurrentItem();
            if (currentItem > 0) {
                setCurrentItem(currentItem - 1, z10);
            } else if (z11) {
                setCurrentItem(count - 1, false);
            }
        }
    }

    public void setCurrentItem(int i10, boolean z10) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (this.f44740O0) {
            i10 = m55801a(i10, this.f44760a);
        }
        this.f44723G = false;
        setCurrentItemInternal(i10, z10, false);
    }

    public static class RtlSavedState implements Parcelable {
        public static final Parcelable.ClassLoaderCreator<RtlSavedState> CREATOR = new bzrwd();

        /* renamed from: a */
        Parcelable f44827a;

        /* renamed from: b */
        int f44828b;

        /* renamed from: c */
        boolean f44829c;

        public class bzrwd implements Parcelable.ClassLoaderCreator<RtlSavedState> {
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: a */
            public RtlSavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new RtlSavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public RtlSavedState createFromParcel(Parcel parcel) {
                return new RtlSavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public RtlSavedState[] newArray(int i10) {
                return new RtlSavedState[i10];
            }
        }

        public RtlSavedState(Parcelable parcelable, int i10, boolean z10) {
            this.f44827a = parcelable;
            this.f44828b = i10;
            this.f44829c = z10;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            if (parcel == null) {
                return;
            }
            parcel.writeParcelable(this.f44827a, i10);
            parcel.writeInt(this.f44828b);
            parcel.writeByte(this.f44829c ? (byte) 1 : (byte) 0);
        }

        public RtlSavedState(Parcel parcel, ClassLoader classLoader) {
            this.f44827a = parcel.readParcelable(classLoader == null ? getClass().getClassLoader() : classLoader);
            this.f44828b = parcel.readInt();
            this.f44829c = parcel.readByte() != 0;
        }
    }

    /* renamed from: a */
    public /* synthetic */ void m55824a(AbstractC4672b abstractC4672b, boolean z10, float f10, float f11) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (!z10) {
            boolean zIsPageScrollHorizontal = isPageScrollHorizontal();
            if (Float.compare(zIsPageScrollHorizontal ? getScrollX() : getScrollY(), f10) != 0) {
                scrollTo(zIsPageScrollHorizontal ? (int) f10 : 0, zIsPageScrollHorizontal ? 0 : (int) f10);
            }
        }
        if (this.f44801r0 != 0) {
            m55832a(false);
        }
        m55884f(0);
    }

    /* renamed from: h */
    private boolean m55894h(MotionEvent motionEvent) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (this.f44747S == -1) {
            Log.w(f44692h1, "onTouchEvent: something wrong! we get invalid pointer!");
            return false;
        }
        VelocityTracker velocityTracker = this.f44749T;
        velocityTracker.computeCurrentVelocity(1000, this.f44753V);
        int yVelocity = (int) velocityTracker.getYVelocity(this.f44747S);
        this.f44723G = true;
        int clientHeight = getClientHeight();
        int scrollY = getScrollY();
        ItemInfo itemInfoInfoForCurrentScrollPosition = infoForCurrentScrollPosition();
        if (itemInfoInfoForCurrentScrollPosition != null) {
            float f10 = 0.0f;
            float f11 = clientHeight <= 0 ? 0.0f : this.f44798q / clientHeight;
            if (clientHeight > 0) {
                float f12 = itemInfoInfoForCurrentScrollPosition.f44821d;
                if (f12 + f11 > 0.0f) {
                    f10 = ((scrollY / clientHeight) - itemInfoInfoForCurrentScrollPosition.f44822e) / (f12 + f11);
                }
            }
            try {
                setCurrentItemInternal(determineTargetPage(itemInfoInfoForCurrentScrollPosition.f44819b, f10, yVelocity, (int) (motionEvent.getY(motionEvent.findPointerIndex(this.f44747S)) - this.f44743Q)), true, true, yVelocity);
                return true;
            } catch (IllegalArgumentException unused) {
                Log.e(f44692h1, "isActionUpVertical: pointer index out of range");
            }
        }
        return false;
    }

    public void setPageMarginDrawable(int i10) {
        setPageMarginDrawable(ContextCompat.getDrawable(getContext(), i10));
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x006c  */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m55877e() {
        /*
            r10 = this;
            int r0 = r10.getScrollX()
            int r1 = r10.getPaddingLeft()
            int r2 = r10.getPaddingRight()
            int r3 = r10.getWidth()
            int r4 = r10.getChildCount()
            r5 = 0
        L15:
            if (r5 >= r4) goto L73
            android.view.View r6 = r10.getChildAt(r5)
            if (r6 != 0) goto L1e
            goto L70
        L1e:
            android.view.ViewGroup$LayoutParams r7 = r6.getLayoutParams()
            boolean r7 = r7 instanceof com.huawei.uikit.hwviewpager.widget.HwViewPager.LayoutParams
            if (r7 != 0) goto L27
            goto L70
        L27:
            android.view.ViewGroup$LayoutParams r7 = r6.getLayoutParams()
            com.huawei.uikit.hwviewpager.widget.HwViewPager$LayoutParams r7 = (com.huawei.uikit.hwviewpager.widget.HwViewPager.LayoutParams) r7
            boolean r8 = r7.isDecor
            if (r8 != 0) goto L32
            goto L70
        L32:
            int r7 = r7.gravity
            r7 = r7 & 7
            r8 = 1
            if (r7 == r8) goto L57
            r8 = 3
            if (r7 == r8) goto L51
            r8 = 5
            if (r7 == r8) goto L41
            r7 = r1
            goto L64
        L41:
            int r7 = r3 - r2
            int r8 = r6.getMeasuredWidth()
            int r7 = r7 - r8
            int r8 = r6.getMeasuredWidth()
            int r2 = r2 + r8
        L4d:
            r9 = r7
            r7 = r1
            r1 = r9
            goto L64
        L51:
            int r7 = r6.getWidth()
            int r7 = r7 + r1
            goto L64
        L57:
            int r7 = r6.getMeasuredWidth()
            int r7 = r3 - r7
            int r7 = r7 / 2
            int r7 = java.lang.Math.max(r7, r1)
            goto L4d
        L64:
            int r1 = r1 + r0
            int r8 = r6.getLeft()
            int r1 = r1 - r8
            if (r1 == 0) goto L6f
            r6.offsetLeftAndRight(r1)
        L6f:
            r1 = r7
        L70:
            int r5 = r5 + 1
            goto L15
        L73:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.uikit.hwviewpager.widget.HwViewPager.m55877e():void");
    }

    /* renamed from: d */
    private static boolean m55876d(View view) {
        return view.getClass().getAnnotation(DecorView.class) != null;
    }

    /* renamed from: i */
    private void m55896i(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f44747S) {
            int i10 = actionIndex == 0 ? 1 : 0;
            m55886f(motionEvent, i10);
            this.f44747S = motionEvent.getPointerId(i10);
            VelocityTracker velocityTracker = this.f44749T;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    /* renamed from: d */
    private void m55872d(int i10, int i11) {
        if (isPageScrollHorizontal()) {
            int paddingLeft = (i10 - getPaddingLeft()) - getPaddingRight();
            int paddingLeft2 = (i11 - getPaddingLeft()) - getPaddingRight();
            scrollTo((int) ((paddingLeft2 > 0 ? getScrollX() / paddingLeft2 : 0.0f) * paddingLeft), getScrollY());
        } else {
            int paddingTop = (i10 - getPaddingTop()) - getPaddingBottom();
            int paddingTop2 = (i11 - getPaddingTop()) - getPaddingBottom();
            scrollTo(getScrollX(), (int) ((paddingTop2 > 0 ? getScrollY() / paddingTop2 : 0.0f) * paddingTop));
        }
    }

    /* renamed from: a */
    public /* synthetic */ void m55823a(AbstractC4672b abstractC4672b, float f10, float f11) {
        if (this.f44801r0 == 2) {
            invalidate();
            pageScrolled((int) f10);
        }
    }

    /* renamed from: f */
    private void m55885f(int i10, int i11) {
        this.f44730J0.m28685w().m28686x(this, isPageScrollHorizontal() ? AbstractC4672b.f21508B : AbstractC4672b.f21509C, this.f44813x0, this.f44811w0, i10, i11 * this.f44726H0);
        m55906t();
        this.f44794o = false;
        this.f44730J0.m28642s(m55802a((ViewGroup) this));
    }

    /* renamed from: a */
    private static Context m55803a(Context context, int i10) {
        return HwWidgetCompat.wrapContext(context, i10, C8744R.style.Theme_Emui_HwViewPager);
    }

    /* renamed from: a */
    private void m55820a(Context context, AttributeSet attributeSet, int i10) {
        m55851b(context, attributeSet, i10);
        m55922j();
        HwGenericEventDetector hwGenericEventDetectorCreateGenericEventDetector = createGenericEventDetector();
        this.f44736M0 = hwGenericEventDetectorCreateGenericEventDetector;
        if (hwGenericEventDetectorCreateGenericEventDetector != null) {
            setSensitivityMode(this.f44716C0);
            this.f44736M0.setSensitivity(this.f44745R);
            this.f44736M0.setOnScrollListener(this, createOnScrollListener());
            this.f44736M0.setOnChangePageListener(createOnChangePageListener());
        }
        setValueFromPlume(context);
    }

    /* renamed from: c */
    private void m55860c() {
        ItemInfo itemInfoM55918c;
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            LayoutParams layoutParams2 = layoutParams instanceof LayoutParams ? (LayoutParams) layoutParams : null;
            if (layoutParams2 != null) {
                layoutParams2.f44826d = i10;
                if (!layoutParams2.isDecor && layoutParams2.f44823a == 0.0f && (itemInfoM55918c = m55918c(childAt)) != null) {
                    layoutParams2.f44823a = itemInfoM55918c.f44821d;
                    layoutParams2.f44825c = itemInfoM55918c.f44819b;
                }
            }
        }
    }

    /* renamed from: d */
    private boolean m55875d(MotionEvent motionEvent, int i10) {
        int iFindPointerIndex = motionEvent.findPointerIndex(i10);
        try {
            float x10 = motionEvent.getX(iFindPointerIndex);
            float f10 = x10 - this.f44737N;
            float fAbs = Math.abs(f10);
            float y10 = motionEvent.getY(iFindPointerIndex);
            float fAbs2 = Math.abs(y10 - this.f44743Q);
            if (Float.compare(f10, 0.0f) != 0 && !m55856b(this.f44737N, f10) && canScroll(this, false, (int) f10, (int) x10, (int) y10)) {
                this.f44737N = x10;
                this.f44739O = y10;
                this.f44729J = true;
                return false;
            }
            m55808a(f10, fAbs, y10, fAbs2);
            if (this.f44727I && !this.f44714B0 && performDrag(this.f44737N - x10)) {
                C9603h0.m59884g0(this);
            }
            return true;
        } catch (IllegalArgumentException unused) {
            Log.e(f44692h1, "needInterceptMoveHorizontally: pointer index out of range");
            return true;
        }
    }

    /* renamed from: b */
    public void m55917b(int i10, int i11, int i12) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        int iAbs;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        int newAnimationScrollX = getNewAnimationScrollX();
        int newAnimationScrollY = getNewAnimationScrollY();
        int i13 = i10 - newAnimationScrollX;
        int i14 = i11 - newAnimationScrollY;
        if (i13 == 0 && i14 == 0) {
            m55832a(false);
            m55925o();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = isPageScrollHorizontal() ? getClientWidth() : getClientHeight();
        float f10 = clientWidth / 2;
        float fM55913a = f10 + (m55913a(clientWidth <= 0 ? 0.0f : Math.min(1.0f, (Math.abs(i13) * 1.0f) / clientWidth)) * f10);
        if (this.f44809v0) {
            if (!isPageScrollHorizontal()) {
                i10 = i11;
            }
            m55885f(i10, -i12);
            m55884f(1);
            return;
        }
        if (this.f44815y0) {
            m55815a(-i12, new Pair<>(Integer.valueOf(newAnimationScrollX), Integer.valueOf(newAnimationScrollY)), new Pair<>(Integer.valueOf(i13), Integer.valueOf(i14)));
            return;
        }
        int iAbs2 = Math.abs(i12);
        if (iAbs2 > 0) {
            iAbs = Math.round(Math.abs(fM55913a / iAbs2) * 1000.0f) * 4;
        } else {
            float pageWidth = clientWidth * (isPageScrollHorizontal() ? this.f44760a.getPageWidth(this.f44763b) : this.f44760a.getPageHeight(this.f44763b));
            iAbs = (int) (((Float.compare(((float) this.f44798q) + pageWidth, 0.0f) != 0 ? Math.abs(i13) / (pageWidth + this.f44798q) : 0.0f) + 1.0f) * 100.0f);
        }
        int iMin = Math.min(iAbs, 600);
        this.f44794o = false;
        this.f44792n.startScroll(newAnimationScrollX, newAnimationScrollY, i13, i14, iMin);
        C9603h0.m59884g0(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x006f  */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m55883f() {
        /*
            r10 = this;
            int r0 = r10.getScrollY()
            int r1 = r10.getPaddingTop()
            int r2 = r10.getPaddingBottom()
            int r3 = r10.getHeight()
            int r4 = r10.getChildCount()
            r5 = 0
        L15:
            if (r5 >= r4) goto L76
            android.view.View r6 = r10.getChildAt(r5)
            if (r6 != 0) goto L1e
            goto L73
        L1e:
            android.view.ViewGroup$LayoutParams r7 = r6.getLayoutParams()
            boolean r7 = r7 instanceof com.huawei.uikit.hwviewpager.widget.HwViewPager.LayoutParams
            if (r7 != 0) goto L27
            goto L73
        L27:
            android.view.ViewGroup$LayoutParams r7 = r6.getLayoutParams()
            com.huawei.uikit.hwviewpager.widget.HwViewPager$LayoutParams r7 = (com.huawei.uikit.hwviewpager.widget.HwViewPager.LayoutParams) r7
            boolean r8 = r7.isDecor
            if (r8 != 0) goto L32
            goto L73
        L32:
            int r7 = r7.gravity
            r7 = r7 & 112(0x70, float:1.57E-43)
            r8 = 16
            if (r7 == r8) goto L5a
            r8 = 48
            if (r7 == r8) goto L54
            r8 = 80
            if (r7 == r8) goto L44
            r7 = r1
            goto L67
        L44:
            int r7 = r3 - r2
            int r8 = r6.getMeasuredHeight()
            int r7 = r7 - r8
            int r8 = r6.getMeasuredHeight()
            int r2 = r2 + r8
        L50:
            r9 = r7
            r7 = r1
            r1 = r9
            goto L67
        L54:
            int r7 = r6.getHeight()
            int r7 = r7 + r1
            goto L67
        L5a:
            int r7 = r6.getMeasuredHeight()
            int r7 = r3 - r7
            int r7 = r7 / 2
            int r7 = java.lang.Math.max(r7, r1)
            goto L50
        L67:
            int r1 = r1 + r0
            int r8 = r6.getTop()
            int r1 = r1 - r8
            if (r1 == 0) goto L72
            r6.offsetTopAndBottom(r1)
        L72:
            r1 = r7
        L73:
            int r5 = r5 + 1
            goto L15
        L76:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.uikit.hwviewpager.widget.HwViewPager.m55883f():void");
    }

    /* renamed from: g */
    private void m55889g(int i10) {
        int paddingTop;
        int paddingBottom;
        ItemInfo itemInfoM55919e = m55919e(this.f44763b);
        float fMin = itemInfoM55919e != null ? Math.min(itemInfoM55919e.f44822e, this.f44816z) : 0.0f;
        if (isPageScrollHorizontal() && isRtlLayout()) {
            fMin = -fMin;
        }
        if (isPageScrollHorizontal()) {
            paddingTop = i10 - getPaddingLeft();
            paddingBottom = getPaddingRight();
        } else {
            paddingTop = i10 - getPaddingTop();
            paddingBottom = getPaddingBottom();
        }
        int i11 = (int) (fMin * (paddingTop - paddingBottom));
        if (isPageScrollHorizontal()) {
            if (i11 == getScrollX()) {
                return;
            }
        } else if (i11 == getScrollY()) {
            return;
        }
        m55832a(false);
        if (isPageScrollHorizontal()) {
            scrollTo(i11, getScrollY());
        } else {
            scrollTo(getScrollX(), i11);
        }
    }

    /* renamed from: e */
    private boolean m55880e(MotionEvent motionEvent, int i10) {
        int iFindPointerIndex = motionEvent.findPointerIndex(i10);
        try {
            float y10 = motionEvent.getY(iFindPointerIndex);
            float f10 = y10 - this.f44739O;
            float fAbs = Math.abs(f10);
            float x10 = motionEvent.getX(iFindPointerIndex);
            float fAbs2 = Math.abs(x10 - this.f44741P);
            if (Float.compare(f10, 0.0f) != 0 && !m55856b(this.f44739O, f10) && canScroll(this, false, (int) f10, (int) x10, (int) y10)) {
                this.f44737N = x10;
                this.f44739O = y10;
                this.f44729J = true;
                return false;
            }
            m55846b(f10, fAbs, x10, fAbs2);
            if (this.f44727I && !this.f44714B0 && performDrag(this.f44739O - y10)) {
                C9603h0.m59884g0(this);
            }
            return true;
        } catch (IllegalArgumentException unused) {
            Log.e(f44692h1, "needInterceptMoveVertically: pointer index out of range");
            return true;
        }
    }

    /* renamed from: a */
    public /* synthetic */ boolean m55835a(float f10, MotionEvent motionEvent) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (m55834a(f10, 0.0f) || this.f44801r0 != 0) {
            return false;
        }
        if (f10 > 0.0f) {
            m55924n();
            return true;
        }
        m55923m();
        return true;
    }

    /* renamed from: h */
    private void m55892h() {
        this.f44727I = false;
        this.f44729J = false;
        VelocityTracker velocityTracker = this.f44749T;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f44749T = null;
        }
    }

    /* renamed from: a */
    private boolean m55834a(float f10, float f11) {
        return Math.abs(f10 - f11) < f44663D1;
    }

    /* renamed from: c */
    public ItemInfo m55918c(View view) {
        for (int i10 = 0; i10 < this.f44775f.size(); i10++) {
            ItemInfo itemInfo = this.f44775f.get(i10);
            if (this.f44760a.isViewFromObject(view, itemInfo.f44818a)) {
                return itemInfo;
            }
        }
        return null;
    }

    /* renamed from: a */
    private void m55819a(int i10, boolean z10, int i11, boolean z11) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        int iM55891h = m55891h(i10);
        if (!this.f44714B0 && z10) {
            if (isPageScrollHorizontal()) {
                if (isRtlLayout()) {
                    iM55891h = -iM55891h;
                }
                m55917b(iM55891h, 0, i11);
            } else {
                m55917b(0, iM55891h, i11);
            }
            if (z11) {
                m55809a(i10);
                return;
            }
            return;
        }
        if (z11) {
            m55809a(i10);
        }
        m55832a(false);
        if (isPageScrollHorizontal()) {
            if (isRtlLayout()) {
                iM55891h = -iM55891h;
            }
            scrollTo(iM55891h, 0);
        } else {
            scrollTo(0, iM55891h);
        }
        pageScrolled(iM55891h);
    }

    /* renamed from: c */
    private void m55863c(int i10, int i11) {
        C4676f c4676f;
        if (i11 > 0 && !this.f44775f.isEmpty()) {
            if (this.f44809v0 && (c4676f = this.f44730J0) != null && c4676f.m28634i()) {
                m55903q();
                return;
            } else if (!this.f44792n.isFinished()) {
                m55902p();
                return;
            } else {
                m55872d(i10, i11);
                return;
            }
        }
        m55889g(i10);
    }

    /* renamed from: g */
    private boolean m55890g(MotionEvent motionEvent) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (this.f44747S == -1) {
            Log.w(f44692h1, "onTouchEvent: something wrong! we get invalid pointer!");
            return false;
        }
        VelocityTracker velocityTracker = this.f44749T;
        velocityTracker.computeCurrentVelocity(1000, this.f44753V);
        int xVelocity = (int) velocityTracker.getXVelocity(this.f44747S);
        this.f44723G = true;
        int clientWidth = getClientWidth();
        int scrollX = isRtlLayout() ? -getScrollX() : getScrollX();
        ItemInfo itemInfoInfoForCurrentScrollPosition = infoForCurrentScrollPosition();
        if (itemInfoInfoForCurrentScrollPosition != null) {
            float f10 = 0.0f;
            float f11 = clientWidth <= 0 ? 0.0f : this.f44798q / clientWidth;
            if (clientWidth > 0) {
                float f12 = itemInfoInfoForCurrentScrollPosition.f44821d;
                if (f12 + f11 > 0.0f) {
                    f10 = ((scrollX / clientWidth) - itemInfoInfoForCurrentScrollPosition.f44822e) / (f12 + f11);
                }
            }
            try {
                setCurrentItemInternal(determineTargetPage(itemInfoInfoForCurrentScrollPosition.f44819b, f10, xVelocity, (int) (motionEvent.getX(motionEvent.findPointerIndex(this.f44747S)) - this.f44741P)), true, true, xVelocity);
                return true;
            } catch (IllegalArgumentException unused) {
                Log.e(f44692h1, "onTouchEvent: pointer index out of range");
            }
        }
        return false;
    }

    /* renamed from: d */
    private void m55873d(MotionEvent motionEvent) {
        m55896i(motionEvent);
        if (this.f44747S == -1) {
            Log.w(f44692h1, "onTouchEvent: something wrong! we get invalid pointer!");
            return;
        }
        try {
            if (isPageScrollHorizontal()) {
                this.f44737N = motionEvent.getX(motionEvent.findPointerIndex(this.f44747S));
            } else {
                this.f44739O = motionEvent.getY(motionEvent.findPointerIndex(this.f44747S));
            }
        } catch (IllegalArgumentException unused) {
            Log.e(f44692h1, "actionPointerUp: pointer index out of range");
        }
    }

    /* renamed from: f */
    private boolean m55887f(MotionEvent motionEvent) throws Resources.NotFoundException {
        this.f44792n.abortAnimation();
        cancelAnimation();
        this.f44723G = false;
        m55925o();
        try {
            float x10 = motionEvent.getX();
            this.f44741P = x10;
            this.f44737N = x10;
            float y10 = motionEvent.getY();
            this.f44743Q = y10;
            this.f44739O = y10;
            this.f44747S = motionEvent.getPointerId(0);
            return false;
        } catch (IllegalArgumentException unused) {
            Log.e(f44692h1, "actonDown: pointer index out of range");
            return true;
        }
    }

    /* renamed from: c */
    private boolean m55867c(MotionEvent motionEvent, int i10) throws Resources.NotFoundException {
        if (i10 == 0) {
            if (this.f44714B0) {
                this.f44722F0.m55776a(motionEvent);
            }
            if (this.f44724G0) {
                m55911y();
            }
            try {
                float x10 = motionEvent.getX();
                this.f44741P = x10;
                this.f44737N = x10;
                float y10 = motionEvent.getY();
                this.f44743Q = y10;
                this.f44739O = y10;
                this.f44747S = motionEvent.getPointerId(0);
                this.f44729J = false;
                this.f44794o = true;
                this.f44792n.computeScrollOffset();
                m55908v();
            } catch (IllegalArgumentException unused) {
                Log.e(f44692h1, "eventActions: pointer index out of range");
                return false;
            }
        } else if (i10 == 2) {
            int i11 = this.f44747S;
            if (i11 != -1) {
                if (isPageScrollHorizontal()) {
                    if (!m55875d(motionEvent, i11)) {
                        return true;
                    }
                } else if (!m55880e(motionEvent, i11)) {
                    return true;
                }
            }
        } else if (i10 == 6) {
            m55896i(motionEvent);
        }
        return false;
    }

    /* renamed from: e */
    private boolean m55879e(MotionEvent motionEvent) {
        if (this.f44714B0) {
            this.f44722F0.m55777b(motionEvent);
            setScrollState(0);
            return true;
        }
        if (this.f44724G0 && this.f44718D0 != null) {
            m55912z();
        }
        this.f44762a1 = m55839a(motionEvent, this.f44762a1);
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:84:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00b5  */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean m55874d(float r14) {
        /*
            Method dump skipped, instructions count: 218
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.uikit.hwviewpager.widget.HwViewPager.m55874d(float):boolean");
    }

    /* renamed from: f */
    private void m55886f(MotionEvent motionEvent, int i10) {
        try {
            if (isPageScrollHorizontal()) {
                this.f44737N = motionEvent.getX(i10);
            } else {
                this.f44739O = motionEvent.getY(i10);
            }
        } catch (IllegalArgumentException unused) {
            Log.e(f44692h1, "updateLastMotion: pointer index out of range");
        }
    }

    /* renamed from: a */
    public OnPageChangeListener m55915a(OnPageChangeListener onPageChangeListener) {
        OnPageChangeListener onPageChangeListener2 = this.f44789l0;
        this.f44789l0 = onPageChangeListener;
        return onPageChangeListener2;
    }

    /* renamed from: e */
    private boolean m55878e(float f10) {
        boolean z10;
        boolean z11;
        float fM55798a;
        this.f44739O -= f10;
        float scrollY = getScrollY();
        float f11 = scrollY + f10;
        int clientHeight = getClientHeight();
        float f12 = clientHeight;
        float f13 = this.f44814y * f12;
        float f14 = this.f44816z * f12;
        boolean z12 = false;
        if (this.f44775f.size() <= 0) {
            return false;
        }
        ItemInfo itemInfo = this.f44775f.get(0);
        ArrayList<ItemInfo> arrayList = this.f44775f;
        ItemInfo itemInfo2 = arrayList.get(arrayList.size() - 1);
        if (itemInfo.f44819b != 0) {
            f13 = itemInfo.f44822e * f12;
            z10 = false;
        } else {
            z10 = true;
        }
        if (itemInfo2.f44819b != this.f44760a.getCount() - 1) {
            f14 = itemInfo2.f44822e * f12;
            z11 = false;
        } else {
            z11 = true;
        }
        if (f11 < f13) {
            if (z10) {
                this.f44770d0.onPull(clientHeight > 0 ? Math.abs(f13 - f11) / f12 : 0.0f);
                z12 = true;
            }
            if ((this.f44809v0 || this.f44815y0) && z10) {
                fM55798a = m55798a(clientHeight, f10, f11 - f13);
                f11 = scrollY + fM55798a;
            } else {
                f11 = f13;
            }
        } else if (f11 > f14) {
            if (z11) {
                this.f44773e0.onPull(clientHeight > 0 ? Math.abs(f11 - f14) / f12 : 0.0f);
                z12 = true;
            }
            if ((this.f44809v0 || this.f44815y0) && z11) {
                fM55798a = m55798a(clientHeight, f10, f11 - f14);
                f11 = scrollY + fM55798a;
            } else {
                f11 = f14;
            }
        }
        m55861c(f11);
        return z12;
    }

    /* renamed from: a */
    public float m55913a(float f10) {
        return (float) Math.sin((f10 - 0.5f) * 0.47123894f);
    }

    /* renamed from: a */
    private long m55802a(ViewGroup viewGroup) {
        Display display = viewGroup == null ? null : viewGroup.getDisplay();
        float refreshRate = display == null ? 0.0f : display.getRefreshRate();
        if (Float.compare(refreshRate, 0.0f) == 0) {
            return 0L;
        }
        return 1000 / ((long) refreshRate);
    }

    /* renamed from: a */
    private void m55815a(int i10, Pair<Integer, Integer> pair, Pair<Integer, Integer> pair2) {
        float fIntValue = ((Integer) (isPageScrollHorizontal() ? pair2.first : pair2.second)).intValue();
        if (Float.compare(this.f44728I0, 0.0f) > 0) {
            Log.d(f44692h1, "startDynamicAnimationWithSpringInterpolator: use fix endPos " + this.f44728I0);
            if (Math.abs(fIntValue) < this.f44728I0) {
                fIntValue = Math.signum(fIntValue) * this.f44728I0;
            }
        }
        C11716c c11716c = new C11716c(this.f44813x0, this.f44811w0, fIntValue, i10 * this.f44726H0);
        int iM69894b = (int) c11716c.m69894b();
        Scroller scroller = new Scroller(getContext(), c11716c);
        this.f44792n = scroller;
        this.f44794o = false;
        scroller.startScroll(((Integer) pair.first).intValue(), ((Integer) pair.second).intValue(), ((Integer) pair2.first).intValue(), ((Integer) pair2.second).intValue(), iM69894b);
        C9603h0.m59884g0(this);
    }

    /* renamed from: b */
    private boolean m55857b(int i10, float f10, int i11) {
        float f11 = this.f44771d1;
        if (f11 >= f10 && i11 > i10) {
            ItemInfo itemInfo = this.f44768c1;
            if (itemInfo == null) {
                return true;
            }
            if (i11 != itemInfo.f44819b || itemInfo.f44820c) {
                return false;
            }
            this.f44775f.remove(this.f44765b1);
            this.f44760a.destroyItem(this, i11, this.f44768c1.f44818a);
            this.f44768c1 = this.f44765b1 < this.f44775f.size() ? this.f44775f.get(this.f44765b1) : null;
            return false;
        }
        ItemInfo itemInfo2 = this.f44768c1;
        if (itemInfo2 != null && i11 == itemInfo2.f44819b) {
            this.f44771d1 = f11 + itemInfo2.f44821d;
            int i12 = this.f44765b1 + 1;
            this.f44765b1 = i12;
            this.f44768c1 = i12 < this.f44775f.size() ? this.f44775f.get(this.f44765b1) : null;
            return false;
        }
        ItemInfo itemInfoM55914a = m55914a(i11, this.f44765b1);
        this.f44768c1 = itemInfoM55914a;
        int i13 = this.f44765b1 + 1;
        this.f44765b1 = i13;
        this.f44771d1 += itemInfoM55914a.f44821d;
        this.f44768c1 = i13 < this.f44775f.size() ? this.f44775f.get(this.f44765b1) : null;
        return false;
    }

    /* renamed from: c */
    private boolean m55866c(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        try {
            if (isPageScrollHorizontal()) {
                this.f44737N = motionEvent.getX(actionIndex);
            } else {
                this.f44739O = motionEvent.getY(actionIndex);
            }
            this.f44747S = motionEvent.getPointerId(actionIndex);
            return false;
        } catch (IllegalArgumentException unused) {
            Log.e(f44692h1, "actionPointerDown: pointer index out of range");
            return true;
        }
    }

    /* renamed from: a */
    public ItemInfo m55914a(int i10, int i11) {
        ItemInfo itemInfo = new ItemInfo();
        itemInfo.f44819b = i10;
        itemInfo.f44818a = this.f44760a.instantiateItem(this, i10);
        itemInfo.f44821d = isPageScrollHorizontal() ? this.f44760a.getPageWidth(i10) : this.f44760a.getPageHeight(i10);
        if (i11 >= 0 && i11 < this.f44775f.size()) {
            this.f44775f.add(i11, itemInfo);
        } else {
            this.f44775f.add(itemInfo);
        }
        return itemInfo;
    }

    /* renamed from: b */
    private void m55854b(ItemInfo itemInfo, ItemInfo itemInfo2, float f10, int i10) {
        ItemInfo itemInfo3;
        float pageWidth = itemInfo2.f44822e + itemInfo2.f44821d + f10;
        int i11 = i10 + 1;
        int i12 = 0;
        while (i11 <= itemInfo.f44819b && i12 < this.f44775f.size()) {
            ItemInfo itemInfo4 = this.f44775f.get(i12);
            while (true) {
                itemInfo3 = itemInfo4;
                if (i11 <= itemInfo3.f44819b || i12 >= this.f44775f.size() - 1) {
                    break;
                }
                i12++;
                itemInfo4 = this.f44775f.get(i12);
            }
            while (i11 < itemInfo3.f44819b) {
                pageWidth += (isPageScrollHorizontal() ? this.f44760a.getPageWidth(i11) : this.f44760a.getPageHeight(i11)) + f10;
                i11++;
            }
            itemInfo3.f44822e = pageWidth;
            pageWidth += itemInfo3.f44821d + f10;
            i11++;
        }
    }

    /* renamed from: c */
    private void m55864c(boolean z10) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z10);
        }
    }

    /* renamed from: d */
    private void m55871d(int i10) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        int clientHeight = getClientHeight();
        int scrollY = getScrollY();
        ItemInfo itemInfoInfoForCurrentScrollPosition = infoForCurrentScrollPosition();
        if (itemInfoInfoForCurrentScrollPosition != null) {
            int i11 = itemInfoInfoForCurrentScrollPosition.f44819b;
            float f10 = 0.0f;
            if (clientHeight > 0) {
                float f11 = itemInfoInfoForCurrentScrollPosition.f44821d;
                if (f11 > 0.0f) {
                    f10 = ((scrollY / clientHeight) - itemInfoInfoForCurrentScrollPosition.f44822e) / f11;
                }
            }
            setCurrentItemInternal(determineTargetPage(i11, f10, i10, (int) (this.f44739O - this.f44743Q)), true, true, i10);
        }
    }

    /* renamed from: c */
    private void m55861c(float f10) {
        int i10 = (int) f10;
        this.f44739O += f10 - i10;
        scrollTo(getScrollX(), i10);
        pageScrolled(i10);
    }

    /* renamed from: a */
    private void m55833a(boolean z10, int i10) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (z10) {
            setChildCount(getChildCount());
            setCurrentItemInternal(i10, false, true);
            requestLayout();
        }
    }

    /* renamed from: c */
    private void m55862c(int i10) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        int clientWidth = getClientWidth();
        int scrollX = isRtlLayout() ? -getScrollX() : getScrollX();
        ItemInfo itemInfoInfoForCurrentScrollPosition = infoForCurrentScrollPosition();
        if (itemInfoInfoForCurrentScrollPosition != null) {
            int i11 = itemInfoInfoForCurrentScrollPosition.f44819b;
            float f10 = 0.0f;
            if (clientWidth > 0) {
                float f11 = itemInfoInfoForCurrentScrollPosition.f44821d;
                if (f11 > 0.0f) {
                    f10 = ((scrollX / clientWidth) - itemInfoInfoForCurrentScrollPosition.f44822e) / f11;
                }
            }
            setCurrentItemInternal(determineTargetPage(i11, f10, i10, (int) (this.f44737N - this.f44741P)), true, true, i10);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0031, code lost:
    
        r1 = null;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m55825a(com.huawei.uikit.hwviewpager.widget.HwViewPager.ItemInfo r8) throws android.content.res.Resources.NotFoundException {
        /*
            r7 = this;
            com.huawei.uikit.hwviewpager.widget.HwPagerAdapter r0 = r7.f44760a
            int r4 = r0.getCount()
            int r0 = r7.f44766c
            if (r4 != r0) goto L59
            r0 = 0
            r7.f44774e1 = r0
        Ld:
            int r1 = r7.f44774e1
            java.util.ArrayList<com.huawei.uikit.hwviewpager.widget.HwViewPager$ItemInfo> r2 = r7.f44775f
            int r2 = r2.size()
            if (r1 >= r2) goto L31
            java.util.ArrayList<com.huawei.uikit.hwviewpager.widget.HwViewPager$ItemInfo> r1 = r7.f44775f
            int r2 = r7.f44774e1
            java.lang.Object r1 = r1.get(r2)
            com.huawei.uikit.hwviewpager.widget.HwViewPager$ItemInfo r1 = (com.huawei.uikit.hwviewpager.widget.HwViewPager.ItemInfo) r1
            int r2 = r1.f44819b
            int r3 = r7.f44763b
            if (r2 < r3) goto L2a
            if (r2 != r3) goto L31
            goto L32
        L2a:
            int r1 = r7.f44774e1
            int r1 = r1 + 1
            r7.f44774e1 = r1
            goto Ld
        L31:
            r1 = 0
        L32:
            if (r1 != 0) goto L3e
            if (r4 <= 0) goto L3e
            int r1 = r7.f44763b
            int r2 = r7.f44774e1
            com.huawei.uikit.hwviewpager.widget.HwViewPager$ItemInfo r1 = r7.m55914a(r1, r2)
        L3e:
            r6 = r1
            int r1 = r7.f44725H
            int r2 = r7.f44763b
            int r2 = r2 - r1
            int r3 = java.lang.Math.max(r0, r2)
            int r0 = r4 + (-1)
            int r2 = r7.f44763b
            int r2 = r2 + r1
            int r5 = java.lang.Math.min(r0, r2)
            if (r6 == 0) goto L58
            r1 = r7
            r2 = r8
            r1.m55826a(r2, r3, r4, r5, r6)
        L58:
            return
        L59:
            android.content.res.Resources r8 = r7.getResources()     // Catch: android.content.res.Resources.NotFoundException -> L66
            int r0 = r7.getId()     // Catch: android.content.res.Resources.NotFoundException -> L66
            java.lang.String r8 = r8.getResourceName(r0)     // Catch: android.content.res.Resources.NotFoundException -> L66
            goto L6e
        L66:
            int r8 = r7.getId()
            java.lang.String r8 = java.lang.Integer.toHexString(r8)
        L6e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "The application's HwPagerAdapter changed the adapter's contents without calling HwPagerAdapter#notifyDataSetChanged! Expected adapter item count: "
            r1.append(r2)
            int r2 = r7.f44766c
            r1.append(r2)
            java.lang.String r2 = ", found: "
            r1.append(r2)
            r1.append(r4)
            java.lang.String r2 = " Pager id: "
            r1.append(r2)
            r1.append(r8)
            java.lang.String r8 = " Pager class: "
            r1.append(r8)
            java.lang.Class r8 = r7.getClass()
            r1.append(r8)
            java.lang.String r8 = " Problematic adapter: "
            r1.append(r8)
            com.huawei.uikit.hwviewpager.widget.HwPagerAdapter r7 = r7.f44760a
            java.lang.Class r7 = r7.getClass()
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            r0.<init>(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.uikit.hwviewpager.widget.HwViewPager.m55825a(com.huawei.uikit.hwviewpager.widget.HwViewPager$ItemInfo):void");
    }

    /* renamed from: b */
    public ItemInfo m55916b(View view) {
        while (true) {
            Object parent = view.getParent();
            if (parent != this) {
                if (parent == null || !(parent instanceof View)) {
                    return null;
                }
                view = (View) parent;
            } else {
                return m55918c(view);
            }
        }
    }

    /* renamed from: b */
    private void m55849b(int i10, int i11, int i12, Rect rect) {
        View childAt = getChildAt(i10);
        if (childAt == null) {
            return;
        }
        int i13 = rect.left;
        int i14 = rect.right;
        int i15 = rect.top;
        if (childAt.getVisibility() == 8 || !(childAt.getLayoutParams() instanceof LayoutParams)) {
            return;
        }
        LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
        ItemInfo itemInfoM55918c = m55918c(childAt);
        if (layoutParams.isDecor || itemInfoM55918c == null) {
            return;
        }
        float f10 = i11;
        int i16 = i15 + ((int) (itemInfoM55918c.f44822e * f10));
        if (layoutParams.f44824b) {
            layoutParams.f44824b = false;
            childAt.measure(View.MeasureSpec.makeMeasureSpec((i12 - i13) - i14, 1073741824), View.MeasureSpec.makeMeasureSpec((int) (f10 * layoutParams.f44823a), 1073741824));
        }
        childAt.layout(i13, i16, childAt.getMeasuredWidth() + i13, childAt.getMeasuredHeight() + i16);
    }

    /* renamed from: a */
    private void m55826a(ItemInfo itemInfo, int i10, int i11, int i12, ItemInfo itemInfo2) {
        float f10;
        int paddingTop;
        float f11;
        int paddingBottom;
        float f12 = 0.0f;
        this.f44777f1 = 0.0f;
        int i13 = this.f44774e1 - 1;
        this.f44765b1 = i13;
        this.f44768c1 = i13 >= 0 ? this.f44775f.get(i13) : null;
        int clientWidth = isPageScrollHorizontal() ? getClientWidth() : getClientHeight();
        if (clientWidth <= 0) {
            f11 = 0.0f;
        } else {
            if (isPageScrollHorizontal()) {
                f10 = 2.0f - itemInfo2.f44821d;
                paddingTop = getPaddingLeft();
            } else {
                f10 = 2.0f - itemInfo2.f44821d;
                paddingTop = getPaddingTop();
            }
            f11 = (f10 + paddingTop) / clientWidth;
        }
        for (int i14 = this.f44763b - 1; i14 >= 0 && !m55865c(i10, f11, i14); i14--) {
        }
        float f13 = itemInfo2.f44821d;
        this.f44771d1 = f13;
        int i15 = this.f44774e1 + 1;
        this.f44765b1 = i15;
        if (f13 < 2.0f) {
            this.f44768c1 = i15 < this.f44775f.size() ? this.f44775f.get(this.f44765b1) : null;
            if (clientWidth > 0) {
                if (isPageScrollHorizontal()) {
                    paddingBottom = getPaddingRight();
                } else {
                    paddingBottom = getPaddingBottom();
                }
                f12 = (paddingBottom / clientWidth) + 2.0f;
            }
            int i16 = this.f44763b;
            do {
                i16++;
                if (i16 >= i11) {
                    break;
                }
            } while (!m55857b(i12, f12, i16));
        }
        m55827a(itemInfo2, this.f44774e1, itemInfo);
        this.f44760a.setPrimaryItem(this, this.f44763b, itemInfo2.f44818a);
    }

    /* renamed from: b */
    private void m55848b(int i10, int i11) {
        if (this.f44746R0 == null) {
            ViewGroupOverlay viewGroupOverlayM55806a = m55806a((View) this);
            this.f44744Q0 = viewGroupOverlayM55806a;
            if (viewGroupOverlayM55806a == null) {
                return;
            }
            this.f44746R0 = new com.huawei.uikit.hwviewpager.widget.bzrwd(this.f44748S0, this);
            setLayerType(1, null);
            this.f44744Q0.add(this.f44746R0);
        }
        Drawable drawable = this.f44746R0;
        if (drawable instanceof com.huawei.uikit.hwviewpager.widget.bzrwd) {
            ((com.huawei.uikit.hwviewpager.widget.bzrwd) drawable).m55947a(i10, i11);
        }
    }

    /* renamed from: b */
    private void m55847b(int i10) {
        OnPageChangeListener onPageChangeListener = this.f44787k0;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrollStateChanged(i10);
        }
        List<OnPageChangeListener> list = this.f44785j0;
        if (list != null) {
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                OnPageChangeListener onPageChangeListener2 = this.f44785j0.get(i11);
                if (onPageChangeListener2 != null) {
                    onPageChangeListener2.onPageScrollStateChanged(i10);
                }
            }
        }
        OnPageChangeListener onPageChangeListener3 = this.f44789l0;
        if (onPageChangeListener3 != null) {
            onPageChangeListener3.onPageScrollStateChanged(i10);
        }
    }

    /* renamed from: a */
    private void m55827a(ItemInfo itemInfo, int i10, ItemInfo itemInfo2) {
        int i11;
        int i12;
        float pageHeight;
        int i13;
        int i14;
        float pageHeight2;
        int count = this.f44760a.getCount();
        int clientWidth = isPageScrollHorizontal() ? getClientWidth() : getClientHeight();
        float f10 = clientWidth > 0 ? this.f44798q / clientWidth : 0.0f;
        if (itemInfo2 != null) {
            int i15 = itemInfo2.f44819b;
            int i16 = itemInfo.f44819b;
            if (i15 < i16) {
                m55854b(itemInfo, itemInfo2, f10, i15);
            } else if (i15 > i16) {
                m55828a(itemInfo, itemInfo2, f10, i15);
            }
        }
        int size = this.f44775f.size();
        float f11 = itemInfo.f44822e;
        int i17 = itemInfo.f44819b;
        int i18 = i17 - 1;
        this.f44814y = i17 == 0 ? f11 : -3.4028235E38f;
        int i19 = count - 1;
        this.f44816z = i17 == i19 ? (itemInfo.f44821d + f11) - 1.0f : Float.MAX_VALUE;
        int i20 = i10 - 1;
        while (i20 >= 0) {
            ItemInfo itemInfo3 = this.f44775f.get(i20);
            while (true) {
                i13 = itemInfo3.f44819b;
                if (i18 <= i13) {
                    break;
                }
                if (isPageScrollHorizontal()) {
                    i14 = i18 - 1;
                    pageHeight2 = this.f44760a.getPageWidth(i18);
                } else {
                    i14 = i18 - 1;
                    pageHeight2 = this.f44760a.getPageHeight(i18);
                }
                f11 -= pageHeight2 + f10;
                i18 = i14;
            }
            f11 -= itemInfo3.f44821d + f10;
            itemInfo3.f44822e = f11;
            if (i13 == 0) {
                this.f44814y = f11;
            }
            i20--;
            i18--;
        }
        float f12 = itemInfo.f44822e + itemInfo.f44821d + f10;
        int i21 = itemInfo.f44819b + 1;
        int i22 = i10 + 1;
        while (i22 < size) {
            ItemInfo itemInfo4 = this.f44775f.get(i22);
            while (true) {
                i11 = itemInfo4.f44819b;
                if (i21 >= i11) {
                    break;
                }
                if (isPageScrollHorizontal()) {
                    i12 = i21 + 1;
                    pageHeight = this.f44760a.getPageWidth(i21);
                } else {
                    i12 = i21 + 1;
                    pageHeight = this.f44760a.getPageHeight(i21);
                }
                f12 += pageHeight + f10;
                i21 = i12;
            }
            if (i11 == i19) {
                this.f44816z = (itemInfo4.f44821d + f12) - 1.0f;
            }
            itemInfo4.f44822e = f12;
            f12 += itemInfo4.f44821d + f10;
            i22++;
            i21++;
        }
        this.f44779g0 = false;
    }

    /* renamed from: b */
    private boolean m55856b(float f10, float f11) {
        return isPageScrollHorizontal() ? (f10 < ((float) this.f44733L) && f11 > 0.0f) || (f10 > ((float) (getWidth() - this.f44733L)) && f11 < 0.0f) : (f10 < ((float) this.f44733L) && f11 > 0.0f) || (f10 > ((float) (getHeight() - this.f44733L)) && f11 < 0.0f);
    }

    /* renamed from: b */
    private void m55855b(boolean z10) {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            getChildAt(i10).setLayerType(z10 ? this.f44795o0 : 0, null);
        }
    }

    /* renamed from: b */
    private void m55846b(float f10, float f11, float f12, float f13) {
        if (Float.compare(f11, this.f44735M) <= 0 || Float.compare(f11 * 0.9f, f13) <= 0) {
            if (f13 > this.f44735M) {
                this.f44729J = true;
            }
        } else {
            this.f44727I = true;
            m55864c(true);
            setScrollState(1);
            this.f44737N = f12;
            this.f44739O = Float.compare(f10, 0.0f) > 0 ? this.f44743Q + this.f44735M : this.f44743Q - this.f44735M;
            setScrollingCacheEnabled(true);
        }
    }

    /* renamed from: b */
    private void m55852b(MotionEvent motionEvent) {
        if (!this.f44727I) {
            int i10 = this.f44747S;
            if (i10 == -1) {
                Log.w(f44692h1, "onTouchEvent: something wrong! we get invalid pointer!");
                this.f44762a1 = m55907u();
                return;
            }
            int iFindPointerIndex = motionEvent.findPointerIndex(i10);
            if (iFindPointerIndex == -1) {
                this.f44762a1 = m55907u();
                return;
            } else if (isPageScrollHorizontal()) {
                m55821a(motionEvent, iFindPointerIndex);
            } else {
                m55853b(motionEvent, iFindPointerIndex);
            }
        }
        if (this.f44727I) {
            int i11 = this.f44747S;
            if (i11 == -1) {
                Log.w(f44692h1, "onTouchEvent: something wrong! we get invalid pointer!");
                return;
            }
            try {
                int iFindPointerIndex2 = motionEvent.findPointerIndex(i11);
                float x10 = isPageScrollHorizontal() ? motionEvent.getX(iFindPointerIndex2) : motionEvent.getY(iFindPointerIndex2);
                this.f44762a1 = performDrag((isPageScrollHorizontal() ? this.f44737N : this.f44739O) - x10) | this.f44762a1;
            } catch (IllegalArgumentException unused) {
                Log.e(f44692h1, "actionMove: pointer index out of range");
            }
        }
    }

    /* renamed from: a */
    private void m55828a(ItemInfo itemInfo, ItemInfo itemInfo2, float f10, int i10) {
        ItemInfo itemInfo3;
        int size = this.f44775f.size() - 1;
        float pageWidth = itemInfo2.f44822e;
        while (true) {
            i10--;
            if (i10 < itemInfo.f44819b || size < 0) {
                return;
            }
            ItemInfo itemInfo4 = this.f44775f.get(size);
            while (true) {
                itemInfo3 = itemInfo4;
                if (i10 >= itemInfo3.f44819b || size <= 0) {
                    break;
                }
                size--;
                itemInfo4 = this.f44775f.get(size);
            }
            while (i10 > itemInfo3.f44819b) {
                pageWidth -= (isPageScrollHorizontal() ? this.f44760a.getPageWidth(i10) : this.f44760a.getPageHeight(i10)) + f10;
                i10--;
            }
            pageWidth -= itemInfo3.f44821d + f10;
            itemInfo3.f44822e = pageWidth;
        }
    }

    /* renamed from: b */
    private void m55853b(MotionEvent motionEvent, int i10) {
        try {
            float x10 = motionEvent.getX(i10);
            float fAbs = Math.abs(x10 - this.f44737N);
            float y10 = motionEvent.getY(i10);
            float fAbs2 = Math.abs(y10 - this.f44739O);
            if (fAbs2 <= this.f44735M || fAbs2 <= fAbs) {
                return;
            }
            this.f44727I = true;
            m55864c(true);
            this.f44737N = x10;
            float f10 = this.f44743Q;
            this.f44739O = y10 - f10 > 0.0f ? f10 + this.f44735M : f10 - this.f44735M;
            setScrollState(1);
            setScrollingCacheEnabled(true);
            ViewParent parent = getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        } catch (IllegalArgumentException unused) {
            Log.e(f44692h1, "actionMoveVertical: pointer index out of range");
        }
    }

    /* renamed from: a */
    private void m55822a(View view, LayoutParams layoutParams) {
        int i10;
        if (layoutParams == null || !layoutParams.isDecor) {
            return;
        }
        int i11 = layoutParams.gravity;
        int i12 = i11 & 7;
        int i13 = i11 & 112;
        boolean z10 = true;
        boolean z11 = i13 == 48 || i13 == 80;
        if (i12 != 3 && i12 != 5) {
            z10 = false;
        }
        int i14 = Integer.MIN_VALUE;
        int i15 = 1073741824;
        if (z11) {
            i10 = Integer.MIN_VALUE;
            i14 = 1073741824;
        } else if (z10) {
            i10 = 1073741824;
        } else {
            Log.d(f44692h1, "do nothing.");
            i10 = Integer.MIN_VALUE;
        }
        int i16 = this.f44752U0;
        int i17 = this.f44754V0;
        int i18 = ((ViewGroup.LayoutParams) layoutParams).width;
        if (i18 != -2) {
            i14 = 1073741824;
            if (i18 != -1) {
                i16 = i18;
            }
        }
        int i19 = ((ViewGroup.LayoutParams) layoutParams).height;
        if (i19 == -2) {
            i15 = i10;
        } else if (i19 != -1) {
            i17 = i19;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec(i16, i14), View.MeasureSpec.makeMeasureSpec(i17, i15));
        if (z11) {
            this.f44754V0 -= view.getMeasuredHeight();
        } else if (z10) {
            this.f44752U0 -= view.getMeasuredWidth();
        }
    }

    /* renamed from: a */
    private void m55811a(int i10, int i11, int i12) {
        View childAt = getChildAt(i12);
        if (childAt.getVisibility() != 8) {
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            LayoutParams layoutParams2 = layoutParams instanceof LayoutParams ? (LayoutParams) layoutParams : null;
            if (layoutParams2 == null || layoutParams2.isDecor) {
                return;
            }
            if (isPageScrollHorizontal()) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec((int) (i10 * layoutParams2.f44823a), 1073741824), this.f44715C);
            } else {
                childAt.measure(this.f44713B, View.MeasureSpec.makeMeasureSpec((int) (i11 * layoutParams2.f44823a), 1073741824));
            }
        }
    }

    /* renamed from: b */
    private boolean m55859b(boolean z10, float f10, int i10, float f11, boolean z11) {
        if (!z11) {
            return z10;
        }
        this.f44773e0.onPull(i10 <= 0 ? 0.0f : Math.abs(f10 - f11) / i10);
        return true;
    }

    /* renamed from: b */
    private void m55845b(float f10) {
        int i10 = (int) f10;
        this.f44737N += f10 - i10;
        scrollTo(i10, getScrollY());
        pageScrolled(i10);
    }

    /* renamed from: b */
    private int m55842b(int i10, float f10, int i11, int i12) {
        float f11;
        if (Math.abs(i12) > this.f44755W && Math.abs(i11) > this.f44751U) {
            return i11 > 0 ? i10 : i10 + 1;
        }
        if (Float.compare(this.f44711A, Float.MIN_VALUE) != 0) {
            int i13 = this.f44763b;
            f11 = this.f44711A;
            if (i10 < i13) {
                f11 = 1.0f - f11;
            }
        } else {
            f11 = (!this.f44809v0 ? i10 >= this.f44763b : i10 < this.f44763b) ? 0.6f : 0.39999998f;
        }
        return i10 + ((int) (f10 + f11));
    }

    /* renamed from: a */
    private void m55813a(int i10, int i11, int i12, int i13, View view) {
        int iMax;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        LayoutParams layoutParams2 = layoutParams instanceof LayoutParams ? (LayoutParams) layoutParams : null;
        if (layoutParams2 == null || !layoutParams2.isDecor) {
            return;
        }
        int i14 = layoutParams2.gravity & 7;
        if (i14 == 1) {
            iMax = Math.max((i10 - view.getMeasuredWidth()) / 2, this.f44756W0);
        } else if (i14 == 3) {
            iMax = isRtlLayout() ? (i10 - this.f44758Y0) - view.getMeasuredWidth() : this.f44756W0;
            this.f44758Y0 = isRtlLayout() ? this.f44758Y0 + view.getMeasuredWidth() : this.f44758Y0;
            this.f44756W0 = isRtlLayout() ? this.f44756W0 : this.f44756W0 + view.getMeasuredWidth();
        } else if (i14 != 5) {
            iMax = this.f44756W0;
        } else {
            iMax = isRtlLayout() ? this.f44756W0 : (i10 - this.f44758Y0) - view.getMeasuredWidth();
            this.f44758Y0 = isRtlLayout() ? this.f44758Y0 : this.f44758Y0 + view.getMeasuredWidth();
            this.f44756W0 = isRtlLayout() ? this.f44756W0 + view.getMeasuredWidth() : this.f44756W0;
        }
        int iM55800a = m55800a(i11, view, layoutParams2);
        if (isPageScrollHorizontal()) {
            iMax += i12;
        } else {
            iM55800a += i13;
        }
        view.layout(iMax, iM55800a, view.getMeasuredWidth() + iMax, view.getMeasuredHeight() + iM55800a);
    }

    /* renamed from: b */
    private boolean m55858b(int i10, View view) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        boolean zM55923m;
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i10);
        if (viewFindNextFocus == null || viewFindNextFocus == view) {
            if (i10 != 17 && i10 != 1) {
                zM55923m = (i10 == 66 || i10 == 2) ? m55924n() : false;
            } else {
                zM55923m = m55923m();
            }
        } else if (i10 == 17) {
            int i11 = m55804a(this.f44780h, viewFindNextFocus).left;
            int i12 = m55804a(this.f44780h, view).left;
            if (view != null && i11 >= i12) {
                zM55923m = m55923m();
            } else {
                zM55923m = viewFindNextFocus.requestFocus();
            }
        } else if (i10 == 66) {
            int i13 = m55804a(this.f44780h, viewFindNextFocus).left;
            int i14 = m55804a(this.f44780h, view).left;
            if (view != null && i13 <= i14) {
                zM55923m = m55924n();
            } else {
                zM55923m = viewFindNextFocus.requestFocus();
            }
        } else {
            Log.d(f44692h1, "do nothing.");
        }
        if (zM55923m) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i10));
        }
        return zM55923m;
    }

    /* renamed from: b */
    private void m55844b() {
        HwPagerAdapter hwPagerAdapter;
        if (this.f44805t0 && (hwPagerAdapter = this.f44760a) != null) {
            if (hwPagerAdapter instanceof com.huawei.uikit.hwviewpager.widget.aauaf) {
                int count = hwPagerAdapter.getCount() - ((com.huawei.uikit.hwviewpager.widget.aauaf) hwPagerAdapter).m55938a();
                int i10 = this.f44763b;
                if (i10 > count + 1 || i10 < count) {
                    return;
                }
                postDelayed(new Runnable() { // from class: com.huawei.uikit.hwviewpager.widget.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f44847a.m55901l();
                    }
                }, isDynamicSpringAnimaitionEnabled() ? f44686a2 : 300L);
                this.f44712A0 = false;
                return;
            }
            return;
        }
        this.f44712A0 = true;
    }

    /* renamed from: a */
    private int m55800a(int i10, View view, LayoutParams layoutParams) {
        int measuredHeight;
        int i11 = layoutParams.gravity & 112;
        if (i11 == 16) {
            return Math.max((i10 - view.getMeasuredHeight()) / 2, this.f44757X0);
        }
        if (i11 == 48) {
            measuredHeight = this.f44757X0;
            this.f44757X0 = view.getMeasuredHeight() + measuredHeight;
        } else {
            if (i11 != 80) {
                return this.f44757X0;
            }
            measuredHeight = (i10 - this.f44759Z0) - view.getMeasuredHeight();
            this.f44759Z0 += view.getMeasuredHeight();
        }
        return measuredHeight;
    }

    /* renamed from: b */
    public void m55850b(int i10, boolean z10) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        int iM55801a = m55801a(i10, this.f44760a);
        this.f44740O0 = false;
        setCurrentItem(iM55801a, z10);
        this.f44740O0 = true;
    }

    /* renamed from: a */
    private void m55814a(int i10, int i11, int i12, Rect rect) {
        View childAt = getChildAt(i10);
        if (childAt == null) {
            return;
        }
        int i13 = rect.top;
        int i14 = rect.bottom;
        int i15 = rect.left;
        if (childAt.getVisibility() == 8 || !(childAt.getLayoutParams() instanceof LayoutParams)) {
            return;
        }
        LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
        ItemInfo itemInfoM55918c = m55918c(childAt);
        if (layoutParams.isDecor || itemInfoM55918c == null) {
            return;
        }
        float f10 = i11;
        int i16 = (int) (itemInfoM55918c.f44822e * f10);
        int i17 = isRtlLayout() ? i15 - i16 : i15 + i16;
        if (layoutParams.f44824b) {
            layoutParams.f44824b = false;
            childAt.measure(View.MeasureSpec.makeMeasureSpec((int) (f10 * layoutParams.f44823a), 1073741824), View.MeasureSpec.makeMeasureSpec((i12 - i13) - i14, 1073741824));
        }
        childAt.layout(i17, i13, childAt.getMeasuredWidth() + i17, childAt.getMeasuredHeight() + i13);
    }

    /* renamed from: a */
    private void m55817a(int i10, View view, boolean z10) {
        HwPagerAdapter adapter;
        if (!z10 || (adapter = getAdapter()) == null) {
            return;
        }
        int count = adapter.getCount() - 1;
        if (isSupportLoop() && (!isSupportLoop() || i10 == getClientWidth() * count || i10 == (-(count * getClientWidth())))) {
            return;
        }
        m55816a(i10, view);
    }

    /* renamed from: a */
    private void m55816a(int i10, View view) {
        this.f44793n0.transformPage(view, isPageScrollHorizontal() ? (isRtlLayout() ? i10 - view.getLeft() : view.getLeft() - i10) / getClientWidth() : (view.getTop() - i10) / getClientHeight());
    }

    /* renamed from: a */
    private void m55810a(int i10, float f10, int i11) {
        if (this.f44724G0) {
            m55848b(i10, i11);
        }
        OnPageChangeListener onPageChangeListener = this.f44787k0;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrolled(i10, f10, i11);
        }
        List<OnPageChangeListener> list = this.f44785j0;
        if (list != null) {
            int size = list.size();
            for (int i12 = 0; i12 < size; i12++) {
                OnPageChangeListener onPageChangeListener2 = this.f44785j0.get(i12);
                if (onPageChangeListener2 != null) {
                    onPageChangeListener2.onPageScrolled(i10, f10, i11);
                }
            }
        }
        OnPageChangeListener onPageChangeListener3 = this.f44789l0;
        if (onPageChangeListener3 != null) {
            onPageChangeListener3.onPageScrolled(i10, f10, i11);
        }
    }

    /* renamed from: a */
    private void m55809a(int i10) {
        OnPageChangeListener onPageChangeListener = this.f44787k0;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageSelected(i10);
        }
        List<OnPageChangeListener> list = this.f44785j0;
        if (list != null) {
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                OnPageChangeListener onPageChangeListener2 = this.f44785j0.get(i11);
                if (onPageChangeListener2 != null) {
                    onPageChangeListener2.onPageSelected(i10);
                }
            }
        }
        OnPageChangeListener onPageChangeListener3 = this.f44789l0;
        if (onPageChangeListener3 != null) {
            onPageChangeListener3.onPageSelected(i10);
        }
    }

    /* renamed from: a */
    private void m55832a(boolean z10) {
        boolean z11 = this.f44801r0 == 2;
        if (z11) {
            setScrollingCacheEnabled(false);
            if (this.f44809v0) {
                m55895i();
            } else if (!this.f44792n.isFinished()) {
                this.f44792n.abortAnimation();
                m55812a(getScrollX(), getScrollY(), this.f44792n.getCurrX(), this.f44792n.getCurrY());
            }
        }
        this.f44723G = false;
        for (int i10 = 0; i10 < this.f44775f.size(); i10++) {
            ItemInfo itemInfo = this.f44775f.get(i10);
            if (itemInfo.f44820c) {
                itemInfo.f44820c = false;
                z11 = true;
            }
        }
        if (z11) {
            if (z10) {
                C9603h0.m59886h0(this, this.f44784j);
            } else {
                this.f44784j.run();
            }
        }
    }

    /* renamed from: a */
    private void m55812a(int i10, int i11, int i12, int i13) {
        if (i10 == i12 && i11 == i13) {
            return;
        }
        scrollTo(i12, i13);
        if (i12 != i10) {
            pageScrolled(i12);
        }
    }

    /* renamed from: a */
    private void m55808a(float f10, float f11, float f12, float f13) {
        if (Float.compare(f11, this.f44735M) <= 0 || Float.compare(f11 * 0.9f, f13) <= 0) {
            if (f13 > this.f44735M) {
                this.f44729J = true;
            }
        } else {
            this.f44727I = true;
            m55864c(true);
            setScrollState(1);
            this.f44737N = Float.compare(f10, 0.0f) > 0 ? this.f44741P + this.f44735M : this.f44741P - this.f44735M;
            this.f44739O = f12;
            setScrollingCacheEnabled(true);
        }
    }

    /* renamed from: a */
    private boolean m55838a(MotionEvent motionEvent) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (this.f44714B0) {
            this.f44722F0.m55777b(motionEvent);
            setScrollState(0);
            return true;
        }
        if (this.f44727I) {
            m55819a(this.f44763b, true, 0, false);
            this.f44762a1 = m55907u();
        }
        return false;
    }

    /* renamed from: a */
    private boolean m55839a(MotionEvent motionEvent, boolean z10) {
        return this.f44727I ? isPageScrollHorizontal() ? m55890g(motionEvent) ? m55907u() : z10 : m55894h(motionEvent) ? m55907u() : z10 : z10;
    }

    /* renamed from: a */
    private void m55821a(MotionEvent motionEvent, int i10) {
        try {
            float x10 = motionEvent.getX(i10);
            float fAbs = Math.abs(x10 - this.f44737N);
            float y10 = motionEvent.getY(i10);
            float fAbs2 = Math.abs(y10 - this.f44739O);
            if (fAbs <= this.f44735M || fAbs <= fAbs2) {
                return;
            }
            this.f44727I = true;
            m55864c(true);
            float f10 = this.f44741P;
            this.f44737N = x10 - f10 > 0.0f ? f10 + this.f44735M : f10 - this.f44735M;
            this.f44739O = y10;
            setScrollState(1);
            setScrollingCacheEnabled(true);
            ViewParent parent = getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        } catch (IllegalArgumentException unused) {
            Log.e(f44692h1, "actionMoveHorizontal: pointer index out of range");
        }
    }

    /* renamed from: a */
    private boolean m55841a(boolean z10, float f10, int i10, float f11, boolean z11) {
        if (!z11) {
            return z10;
        }
        this.f44770d0.onPull(i10 <= 0 ? 0.0f : Math.abs(f11 - f10) / i10);
        return true;
    }

    /* renamed from: a */
    private float m55798a(int i10, float f10, float f11) {
        return f10 * new C11906a(i10 * 0.5f).m71440a(Math.abs(f11));
    }

    /* renamed from: a */
    private int m55799a(int i10, float f10, int i11, int i12) {
        float f11;
        if (Math.abs(i12) > this.f44755W && Math.abs(i11) > this.f44751U) {
            if (isRtlLayout()) {
                if (i11 < 0) {
                    return i10;
                }
            } else if (i11 > 0) {
                return i10;
            }
            return i10 + 1;
        }
        if (Float.compare(this.f44711A, Float.MIN_VALUE) != 0) {
            f11 = i10 >= this.f44763b ? 1.0f - this.f44711A : this.f44711A;
        } else if (this.f44809v0) {
            f11 = 0.5f;
        } else {
            f11 = i10 >= this.f44763b ? 0.39999998f : 0.6f;
        }
        return i10 + ((int) (f10 + f11));
    }

    /* renamed from: a */
    private boolean m55837a(Canvas canvas, int i10, int i11, float f10, boolean z10) {
        if (z10) {
            float f11 = f10 - this.f44798q;
            if (f11 < i10) {
                float f12 = i11;
                this.f44800r.setBounds(Math.round(f11 + f12), this.f44802s, Math.round(f12 + f10), this.f44804t);
                this.f44800r.draw(canvas);
            }
            return f10 < ((float) (i10 - i11));
        }
        if (this.f44798q + f10 > i10) {
            if (isPageScrollHorizontal()) {
                this.f44800r.setBounds(Math.round(f10), this.f44802s, Math.round(this.f44798q + f10), this.f44804t);
            } else {
                this.f44800r.setBounds(this.f44806u, Math.round(f10), this.f44808v, Math.round(this.f44798q + f10));
            }
            this.f44800r.draw(canvas);
        }
        return f10 > ((float) (i10 + i11));
    }

    /* renamed from: a */
    private float m55797a(float f10, int i10) {
        float f11;
        float f12;
        float f13;
        float f14;
        if (isRtlLayout()) {
            f11 = -i10;
            f12 = this.f44816z;
        } else {
            f11 = i10;
            f12 = this.f44814y;
        }
        float f15 = f11 * f12;
        if (isRtlLayout()) {
            f13 = -i10;
            f14 = this.f44814y;
        } else {
            f13 = i10;
            f14 = this.f44816z;
        }
        float f16 = f13 * f14;
        ItemInfo itemInfo = this.f44775f.get(0);
        ItemInfo itemInfo2 = this.f44775f.get(r3.size() - 1);
        if (itemInfo.f44819b != 0) {
            if (isRtlLayout()) {
                f16 = (-itemInfo.f44822e) * i10;
            } else {
                f15 = itemInfo.f44822e * i10;
            }
        }
        if (itemInfo2.f44819b != this.f44760a.getCount() - 1) {
            if (isRtlLayout()) {
                f15 = (-itemInfo2.f44822e) * i10;
            } else {
                f16 = itemInfo2.f44822e * i10;
            }
        }
        return f10 < f15 ? f15 : f10 > f16 ? f16 : f10;
    }

    /* renamed from: a */
    private Rect m55804a(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }

    /* renamed from: a */
    private void m55807a() {
        if (!this.f44805t0) {
            this.f44712A0 = true;
            return;
        }
        HwPagerAdapter hwPagerAdapter = this.f44760a;
        if ((hwPagerAdapter instanceof com.huawei.uikit.hwviewpager.widget.aauaf) && this.f44763b < ((com.huawei.uikit.hwviewpager.widget.aauaf) hwPagerAdapter).m55938a()) {
            postDelayed(new Runnable() { // from class: com.huawei.uikit.hwviewpager.widget.e
                @Override // java.lang.Runnable
                public final void run() {
                    this.f44875a.m55899k();
                }
            }, isDynamicSpringAnimaitionEnabled() ? f44686a2 : 300L);
            this.f44712A0 = false;
        }
    }

    /* renamed from: a */
    private ViewGroupOverlay m55806a(View view) {
        ViewParent parent = view.getParent();
        if (parent == null) {
            Log.e(f44692h1, "getParentViewOverlay: viewParent is null");
            return null;
        }
        if (parent instanceof ViewGroup) {
            return ((ViewGroup) parent).getOverlay();
        }
        Log.e(f44692h1, "getParentViewOverlay: viewParent is not instance of ViewGroup");
        return null;
    }

    /* renamed from: a */
    private void m55831a(ArrayList<View> arrayList, int i10, int i11) {
        for (int i12 = 0; i12 < getChildCount(); i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() == 0) {
                ItemInfo itemInfoM55918c = m55918c(childAt);
                if (arrayList != null && itemInfoM55918c != null && itemInfoM55918c.f44819b == this.f44763b) {
                    childAt.addFocusables(arrayList, i10, i11);
                }
            }
        }
    }

    /* renamed from: a */
    private boolean m55836a(int i10, Rect rect, int i11) {
        ItemInfo itemInfoM55918c;
        View childAt = getChildAt(i11);
        return childAt.getVisibility() == 0 && (itemInfoM55918c = m55918c(childAt)) != null && itemInfoM55918c.f44819b == this.f44763b && childAt.requestFocus(i10, rect);
    }

    /* renamed from: a */
    private void m55818a(int i10, boolean z10) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        int iM55801a = m55801a(i10, this.f44760a);
        this.f44740O0 = false;
        setCurrentItem(iM55801a, z10);
        this.f44740O0 = true;
    }

    /* renamed from: a */
    private int m55801a(int i10, HwPagerAdapter hwPagerAdapter) {
        return ((hwPagerAdapter instanceof com.huawei.uikit.hwviewpager.widget.aauaf) && this.f44805t0) ? ((com.huawei.uikit.hwviewpager.widget.aauaf) hwPagerAdapter).m55941b(i10) : i10;
    }
}
