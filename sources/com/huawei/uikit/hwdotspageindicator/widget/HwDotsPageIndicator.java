package com.huawei.uikit.hwdotspageindicator.widget;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.content.ContextCompat;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import com.huawei.uikit.hwcommon.utils.HwVibrateUtil;
import com.huawei.uikit.hwdotspageindicator.C8711R;
import com.huawei.uikit.hwdotspageindicator.widget.HwDotsPageIndicatorAnimation;
import com.huawei.uikit.hwdotspageindicator.widget.HwDotsPageIndicatorInteractor;
import com.huawei.uikit.hwdotspageindicator.widget.HwWatchDotsPageIndicatorAnimation;
import com.huawei.uikit.hwdotspageindicator.widget.bqmxo;
import com.huawei.uikit.hwdotspageindicator.widget.bzrwd;
import com.huawei.uikit.hwresources.utils.HwWidgetInstantiator;
import com.huawei.uikit.hwviewpager.widget.HwPagerAdapter;
import com.huawei.uikit.hwviewpager.widget.HwViewPager;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes7.dex */
public class HwDotsPageIndicator extends com.huawei.uikit.hwdotspageindicator.widget.bzrwd implements HwViewPager.OnPageChangeListener, View.OnClickListener, HwDotsPageIndicatorAnimation.AnimationUpdateListener {

    /* renamed from: R0 */
    private static final String f42280R0 = "HwDotsPageIndicator";

    /* renamed from: S0 */
    private static final boolean f42281S0 = false;

    /* renamed from: T0 */
    private static final int f42282T0 = 11;

    /* renamed from: U0 */
    private static final int f42283U0 = 5000;

    /* renamed from: V0 */
    private static final float f42284V0 = 2.0f;

    /* renamed from: W0 */
    private static final int f42285W0 = 2;

    /* renamed from: X0 */
    private static final int f42286X0 = 1;

    /* renamed from: Y0 */
    private static final int f42287Y0 = 3;

    /* renamed from: Z0 */
    private static final long f42288Z0 = 300;

    /* renamed from: a1 */
    private static final long f42289a1 = 100;

    /* renamed from: b1 */
    private static final float f42290b1 = 1.0f;

    /* renamed from: A */
    private boolean f42291A;

    /* renamed from: A0 */
    private Paint f42292A0;

    /* renamed from: B */
    private int f42293B;

    /* renamed from: B0 */
    private Paint f42294B0;

    /* renamed from: C */
    private boolean f42295C;

    /* renamed from: C0 */
    private Paint.FontMetrics f42296C0;

    /* renamed from: D */
    private boolean f42297D;

    /* renamed from: D0 */
    private bqmxo.bzrwd f42298D0;

    /* renamed from: E */
    private boolean f42299E;

    /* renamed from: E0 */
    private HwDotsPageIndicatorInteractor.OnClickListener f42300E0;

    /* renamed from: F */
    private int f42301F;

    /* renamed from: F0 */
    private HwDotsPageIndicatorInteractor.OnGestureListener f42302F0;

    /* renamed from: G */
    private float f42303G;

    /* renamed from: G0 */
    private HwDotsPageIndicatorInteractor.OnMouseOperationListener f42304G0;

    /* renamed from: H */
    private int f42305H;

    /* renamed from: H0 */
    private bfscp f42306H0;

    /* renamed from: I */
    private float f42307I;

    /* renamed from: I0 */
    private awsks f42308I0;

    /* renamed from: J */
    private int f42309J;

    /* renamed from: J0 */
    private bxac f42310J0;

    /* renamed from: K */
    private int f42311K;

    /* renamed from: K0 */
    private aayti f42312K0;

    /* renamed from: L */
    private int f42313L;

    /* renamed from: L0 */
    private RectF f42314L0;

    /* renamed from: M */
    private int f42315M;

    /* renamed from: M0 */
    private RectF f42316M0;

    /* renamed from: N */
    private int f42317N;

    /* renamed from: N0 */
    private RectF f42318N0;

    /* renamed from: O */
    private int f42319O;

    /* renamed from: O0 */
    private RectF f42320O0;

    /* renamed from: P */
    private int f42321P;

    /* renamed from: P0 */
    private RectF f42322P0;

    /* renamed from: Q */
    private int f42323Q;

    /* renamed from: Q0 */
    private final Runnable f42324Q0;

    /* renamed from: R */
    private float f42325R;

    /* renamed from: S */
    private int f42326S;

    /* renamed from: T */
    private int f42327T;

    /* renamed from: U */
    private int f42328U;

    /* renamed from: V */
    private float f42329V;

    /* renamed from: W */
    private int f42330W;

    /* renamed from: a0 */
    private int f42331a0;

    /* renamed from: b0 */
    private int f42332b0;

    /* renamed from: c0 */
    private int f42333c0;

    /* renamed from: d0 */
    private int f42334d0;

    /* renamed from: e0 */
    private int f42335e0;

    /* renamed from: f0 */
    private int f42336f0;

    /* renamed from: g0 */
    private float f42337g0;

    /* renamed from: h0 */
    private float f42338h0;

    /* renamed from: i0 */
    private float f42339i0;

    /* renamed from: j0 */
    private int f42340j0;

    /* renamed from: k0 */
    private int f42341k0;

    /* renamed from: l0 */
    private boolean f42342l0;

    /* renamed from: m0 */
    private String f42343m0;
    protected boolean mIsWatchType;
    protected HwViewPager mViewPager;

    /* renamed from: n0 */
    private boolean f42344n0;

    /* renamed from: o0 */
    private float f42345o0;

    /* renamed from: p0 */
    private long f42346p0;

    /* renamed from: q0 */
    private boolean f42347q0;

    /* renamed from: r0 */
    private boolean f42348r0;

    /* renamed from: s0 */
    private boolean f42349s0;

    /* renamed from: t */
    private int f42350t;

    /* renamed from: t0 */
    private boolean f42351t0;

    /* renamed from: u */
    private boolean f42352u;

    /* renamed from: u0 */
    private boolean f42353u0;

    /* renamed from: v */
    private boolean f42354v;

    /* renamed from: v0 */
    private boolean f42355v0;

    /* renamed from: w */
    private boolean f42356w;

    /* renamed from: w0 */
    private HwViewPager.OnPageChangeListener f42357w0;

    /* renamed from: x */
    private boolean f42358x;

    /* renamed from: x0 */
    private Handler f42359x0;

    /* renamed from: y */
    private boolean f42360y;

    /* renamed from: y0 */
    private Paint f42361y0;

    /* renamed from: z */
    private boolean f42362z;

    /* renamed from: z0 */
    private Paint f42363z0;

    public class aauaf extends DataSetObserver {
        public aauaf() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            HwDotsPageIndicator hwDotsPageIndicator = HwDotsPageIndicator.this;
            hwDotsPageIndicator.setPageCount(hwDotsPageIndicator.mViewPager.getAdapter().getCount());
        }
    }

    public class aayti implements Runnable {
        private aayti() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HwDotsPageIndicator.this.doHotZoneInVisibleAnimation(false);
        }

        public /* synthetic */ aayti(HwDotsPageIndicator hwDotsPageIndicator, bzrwd bzrwdVar) {
            this();
        }
    }

    public class akxao extends HwDotsPageIndicatorAnimation.AnimationStateListener {

        /* renamed from: a */
        final /* synthetic */ boolean f42366a;

        public akxao(boolean z10) {
            this.f42366a = z10;
        }

        @Override // com.huawei.uikit.hwdotspageindicator.widget.HwDotsPageIndicatorAnimation.AnimationStateListener
        /* renamed from: b */
        public void mo54434b() {
            if (this.f42366a) {
                HwDotsPageIndicator.this.m54401e();
            }
        }
    }

    public class avpbg extends HwDotsPageIndicatorAnimation.AnimationStateListener {

        /* renamed from: a */
        final /* synthetic */ float f42368a;

        /* renamed from: b */
        final /* synthetic */ boolean f42369b;

        /* renamed from: c */
        final /* synthetic */ int f42370c;

        /* renamed from: d */
        final /* synthetic */ float f42371d;

        /* renamed from: e */
        final /* synthetic */ HwDotsPageIndicatorAnimation.AnimationStateListener f42372e;

        public avpbg(float f10, boolean z10, int i10, float f11, HwDotsPageIndicatorAnimation.AnimationStateListener animationStateListener) {
            this.f42368a = f10;
            this.f42369b = z10;
            this.f42370c = i10;
            this.f42371d = f11;
            this.f42372e = animationStateListener;
        }

        @Override // com.huawei.uikit.hwdotspageindicator.widget.HwDotsPageIndicatorAnimation.AnimationStateListener
        /* renamed from: a */
        public void mo54435a(float f10) {
            if (f10 < this.f42368a || HwDotsPageIndicator.this.isSpringAnimationRunning()) {
                return;
            }
            HwDotsPageIndicator.this.mAnimator.m54478q();
            HwDotsPageIndicatorAnimation.Options optionsCreate = new HwDotsPageIndicatorAnimation.Options.Builder().setStartLoc(this.f42369b ? HwDotsPageIndicator.this.mOptions.m54568n() : HwDotsPageIndicator.this.mOptions.m54563l()).setTargetLoc(this.f42371d).setStiffness(HwDotsPageIndicator.this.mSpringStiffness).setDamping(com.huawei.uikit.hwdotspageindicator.widget.bqmxo.m54589a(HwDotsPageIndicator.this.mSpringDamping, this.f42370c)).setUpdateListener(HwDotsPageIndicator.this).setStateListener(this.f42372e).create();
            HwDotsPageIndicator hwDotsPageIndicator = HwDotsPageIndicator.this;
            hwDotsPageIndicator.mAnimator.m54455b(hwDotsPageIndicator.f42349s0, optionsCreate);
        }
    }

    public enum awsks {
        DEFAULT,
        TARGET,
        SLIDE
    }

    public enum bfscp {
        COMMON,
        VISIBLE,
        MOUSE_ON_DOT
    }

    public class blfhz extends HwDotsPageIndicatorAnimation.AnimationStateListener {
        public blfhz() {
        }

        @Override // com.huawei.uikit.hwdotspageindicator.widget.HwDotsPageIndicatorAnimation.AnimationStateListener
        /* renamed from: a */
        public void mo54435a(float f10) {
            if (HwDotsPageIndicator.this.f42304G0 != null) {
                HwDotsPageIndicator.this.f42304G0.onFocusAnimationProgress(f10);
            }
        }
    }

    public class bqmxo extends HwDotsPageIndicatorAnimation.AnimationStateListener {

        /* renamed from: a */
        final /* synthetic */ boolean f42383a;

        public bqmxo(boolean z10) {
            this.f42383a = z10;
        }

        @Override // com.huawei.uikit.hwdotspageindicator.widget.HwDotsPageIndicatorAnimation.AnimationStateListener
        /* renamed from: b */
        public void mo54434b() {
            HwDotsPageIndicator.this.f42298D0.m54612a(HwDotsPageIndicator.this.f42345o0);
            if (this.f42383a && HwDotsPageIndicator.this.f42302F0 != null) {
                HwDotsPageIndicator.this.f42302F0.onLongPress(2);
            }
            if (this.f42383a || HwDotsPageIndicator.this.f42304G0 == null) {
                return;
            }
            HwDotsPageIndicator.this.f42304G0.onMoveInHotZone(2);
        }
    }

    public class brnby extends HwDotsPageIndicatorAnimation.AnimationStateListener {

        /* renamed from: a */
        final /* synthetic */ float f42385a;

        /* renamed from: b */
        final /* synthetic */ boolean f42386b;

        /* renamed from: c */
        final /* synthetic */ float f42387c;

        /* renamed from: d */
        final /* synthetic */ float f42388d;

        public brnby(float f10, boolean z10, float f11, float f12) {
            this.f42385a = f10;
            this.f42386b = z10;
            this.f42387c = f11;
            this.f42388d = f12;
        }

        @Override // com.huawei.uikit.hwdotspageindicator.widget.HwDotsPageIndicatorAnimation.AnimationStateListener
        /* renamed from: a */
        public void mo54435a(float f10) {
            if (f10 <= this.f42385a || HwDotsPageIndicator.this.isSpringAnimationRunning()) {
                return;
            }
            HwDotsPageIndicator.this.mAnimator.m54478q();
            HwDotsPageIndicator hwDotsPageIndicator = HwDotsPageIndicator.this;
            boolean z10 = hwDotsPageIndicator.f42349s0;
            float fM54568n = this.f42386b ? HwDotsPageIndicator.this.mOptions.m54568n() : HwDotsPageIndicator.this.mOptions.m54563l();
            float f11 = this.f42386b ? this.f42387c : this.f42388d;
            HwDotsPageIndicator hwDotsPageIndicator2 = HwDotsPageIndicator.this;
            hwDotsPageIndicator.m54364a(z10, fM54568n, f11, hwDotsPageIndicator2.mSpringStiffness, hwDotsPageIndicator2.mSpringDamping);
        }
    }

    public class bxac implements Runnable {
        private bxac() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (HwDotsPageIndicator.this.f42302F0 != null && HwDotsPageIndicator.this.f42356w) {
                HwDotsPageIndicator.this.f42302F0.onLongPress(1);
            }
            HwDotsPageIndicator.this.doHotZoneVisibleAnimation(true);
        }

        public /* synthetic */ bxac(HwDotsPageIndicator hwDotsPageIndicator, bzrwd bzrwdVar) {
            this();
        }
    }

    public class bzrwd implements Runnable {
        public bzrwd() {
        }

        @Override // java.lang.Runnable
        public void run() throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
            HwViewPager hwViewPager = HwDotsPageIndicator.this.mViewPager;
            if (hwViewPager == null || hwViewPager.getAdapter() == null) {
                Log.w(HwDotsPageIndicator.f42280R0, "HwViewPager or adapter is illegal.");
                return;
            }
            HwPagerAdapter adapter = HwDotsPageIndicator.this.mViewPager.getAdapter();
            if (adapter.getCount() < 2) {
                Log.w(HwDotsPageIndicator.f42280R0, "Auto play but pager count is less than two.");
                return;
            }
            int currentItem = HwDotsPageIndicator.this.mViewPager.getCurrentItem();
            HwDotsPageIndicator.this.mViewPager.setCurrentItem((HwDotsPageIndicator.this.mViewPager.isSupportLoop() || currentItem < adapter.getCount() - 1) ? currentItem + 1 : 0, true);
            if (HwDotsPageIndicator.this.f42354v) {
                HwDotsPageIndicator.this.f42359x0.postDelayed(HwDotsPageIndicator.this.f42324Q0, HwDotsPageIndicator.this.f42350t);
            }
        }
    }

    public HwDotsPageIndicator(Context context) {
        this(context, null);
    }

    /* renamed from: A */
    private void m54348A() {
        Handler handler = this.f42359x0;
        if (handler != null) {
            handler.removeCallbacks(this.f42324Q0);
        }
        this.f42359x0 = null;
    }

    private int getDesiredWidth() {
        float f10 = this.f42334d0 * 2.0f;
        int i10 = this.f42309J;
        int i11 = this.f42340j0 - 1;
        return (int) (f10 + (i10 * i11) + (this.f42301F * i11) + this.f42321P);
    }

    private int getDistanceProper() {
        int i10;
        int i11;
        if (m54429v()) {
            i10 = this.f42309J;
            i11 = this.f42301F;
        } else {
            i10 = this.f42311K;
            i11 = this.f42305H;
        }
        return i10 + i11;
    }

    private int getScaledWidth() {
        float f10 = this.f42334d0 * 2.0f;
        int i10 = this.f42311K;
        int i11 = this.f42340j0 - 1;
        return (int) (f10 + (i10 * i11) + (this.f42305H * i11) + this.f42328U);
    }

    public static HwDotsPageIndicator instantiate(Context context) throws ClassNotFoundException {
        Object objInstantiate = HwWidgetInstantiator.instantiate(context, HwWidgetInstantiator.getDeviceClassName(context, HwDotsPageIndicator.class, HwWidgetInstantiator.getCurrentType(context, 11, 1)), HwDotsPageIndicator.class);
        if (objInstantiate instanceof HwDotsPageIndicator) {
            return (HwDotsPageIndicator) objInstantiate;
        }
        return null;
    }

    /* renamed from: l */
    private void m54419l() {
        this.f42359x0 = new Handler();
    }

    /* renamed from: m */
    private com.huawei.uikit.hwdotspageindicator.widget.aauaf m54420m() {
        com.huawei.uikit.hwdotspageindicator.widget.aauaf aauafVarM54533c = this.mOptions.m54533c();
        aauafVarM54533c.m54540d(this.f42303G);
        aauafVarM54533c.m54575q(this.f42327T);
        aauafVarM54533c.m54516a(this.mOptions.m54559j(this.f42341k0));
        aauafVarM54533c.m54534c(this.mOptions.m54537d());
        aauafVarM54533c.m54528b(this.f42320O0);
        aauafVarM54533c.m54554h(this.f42329V - this.f42303G);
        aauafVarM54533c.m54551g(this.mOptions.m54550g(this.f42341k0));
        aauafVarM54533c.m54547f(this.mOptions.m54542e(this.f42341k0));
        aauafVarM54533c.m54562k(this.f42329V + this.f42303G);
        return aauafVarM54533c;
    }

    /* renamed from: n */
    private void m54421n() {
        if (this.f42322P0 == null) {
            return;
        }
        if (this.f42316M0 == null) {
            this.f42316M0 = new RectF();
        }
        int i10 = this.f42341k0;
        if (i10 == this.f42340j0 - 1) {
            this.f42316M0 = new RectF();
            return;
        }
        this.f42316M0.left = this.f42299E ? this.f42322P0.left : this.mOptions.m54542e(i10) + (this.f42309J / 2.0f);
        RectF rectF = this.f42316M0;
        RectF rectF2 = this.f42322P0;
        rectF.top = rectF2.top;
        rectF.right = this.f42299E ? this.mOptions.m54542e(this.f42341k0) - (this.f42309J / 2.0f) : rectF2.right;
        this.f42316M0.bottom = this.f42322P0.bottom;
    }

    /* renamed from: o */
    private void m54422o() {
        this.mOptions.m54535c(this.f42299E);
        this.mOptions.m54554h(this.f42329V - this.f42303G);
        this.mOptions.m54562k(this.f42329V + this.f42303G);
        com.huawei.uikit.hwdotspageindicator.widget.aauaf aauafVar = this.mOptions;
        aauafVar.m54551g(aauafVar.m54550g(this.f42341k0));
        com.huawei.uikit.hwdotspageindicator.widget.aauaf aauafVar2 = this.mOptions;
        aauafVar2.m54547f(aauafVar2.m54542e(this.f42341k0));
        this.mOptions.m54540d(this.f42303G);
        this.mOptions.m54564l(this.f42303G);
        this.mOptions.m54575q(this.f42327T);
        this.mOptions.m54516a(this.mOptions.m54559j(this.f42341k0));
        this.mOptions.m54534c(this.f42329V);
        this.mOptions.m54528b(this.f42320O0);
    }

    /* renamed from: p */
    private void m54423p() {
        Paint paint = new Paint(1);
        this.f42361y0 = paint;
        paint.setColor(this.f42313L);
        Paint paint2 = new Paint(1);
        this.f42363z0 = paint2;
        paint2.setColor(this.f42315M);
        Paint paint3 = new Paint(1);
        this.f42294B0 = paint3;
        paint3.setColor(this.f42326S);
    }

    /* renamed from: q */
    private void m54424q() {
        if (this.f42322P0 == null) {
            return;
        }
        if (this.f42314L0 == null) {
            this.f42314L0 = new RectF();
        }
        int i10 = this.f42341k0;
        if (i10 == 0) {
            this.f42314L0 = new RectF();
            return;
        }
        this.f42314L0.left = this.f42299E ? this.mOptions.m54550g(i10) + (this.f42309J / 2.0f) : this.f42322P0.left;
        RectF rectF = this.f42314L0;
        RectF rectF2 = this.f42322P0;
        rectF.top = rectF2.top;
        rectF.right = this.f42299E ? rectF2.right : this.mOptions.m54550g(this.f42341k0) - (this.f42309J / 2.0f);
        this.f42314L0.bottom = this.f42322P0.bottom;
    }

    /* renamed from: r */
    private void m54425r() {
        float paddingLeft = getPaddingLeft() + (((getWidth() - getPaddingRight()) - getScaledWidth()) / 2.0f) + this.f42334d0;
        this.mOptions.m54525b(paddingLeft);
        float f10 = paddingLeft - this.f42334d0;
        this.f42318N0 = new RectF(f10, this.f42329V - (this.f42331a0 / 2.0f), getScaledWidth() + f10, this.f42329V + (this.f42331a0 / 2.0f));
    }

    /* renamed from: s */
    private com.huawei.uikit.hwdotspageindicator.widget.aauaf m54426s() {
        com.huawei.uikit.hwdotspageindicator.widget.aauaf aauafVarM54533c = this.mOptions.m54533c();
        aauafVarM54533c.m54540d(this.f42305H / 2.0f);
        aauafVarM54533c.m54575q(this.f42326S);
        aauafVarM54533c.m54516a(this.mOptions.m54565l(this.f42341k0));
        aauafVarM54533c.m54534c(this.mOptions.m54537d());
        aauafVarM54533c.m54528b(this.f42318N0);
        aauafVarM54533c.m54554h(this.f42329V - (this.f42305H / 2.0f));
        aauafVarM54533c.m54562k(this.f42329V + (this.f42305H / 2.0f));
        aauafVarM54533c.m54551g(this.mOptions.m54555i(this.f42341k0));
        aauafVarM54533c.m54547f(this.mOptions.m54553h(this.f42341k0));
        return aauafVarM54533c;
    }

    private void setCurrentItemIndirect(int i10) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        HwViewPager hwViewPager = this.mViewPager;
        if (hwViewPager == null || hwViewPager.getAdapter() == null || this.mViewPager.getAdapter().getCount() < 2 || i10 < 0 || i10 >= this.f42340j0) {
            return;
        }
        this.mViewPager.setCurrentItem(i10, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPageCount(int i10) {
        this.f42340j0 = i10;
        this.mOptions.m54579s(i10);
        this.mWatchOptions.setPageCount(this.f42340j0);
        if (this.mIsWatchType) {
            initWatchOptions();
            return;
        }
        m54385c();
        requestLayout();
        invalidate();
    }

    private void settleToTarget(int i10) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        this.f42298D0.m54612a(this.f42345o0);
        this.f42298D0.m54615b(this.f42345o0);
        this.f42298D0.m54613a(true);
        setCurrentItemIndirect(i10);
        if (isHapticFeedbackEnabled()) {
            HwVibrateUtil.vibrator(this, 7, 0);
        }
        m54351a(1.0f, 3, i10);
    }

    /* renamed from: t */
    private boolean m54427t() {
        return getLayoutDirection() == 1;
    }

    /* renamed from: u */
    private boolean m54428u() {
        return (!this.f42295C || this.f42356w || this.f42354v) ? false : true;
    }

    /* renamed from: v */
    private boolean m54429v() {
        return this.f42306H0 == bfscp.COMMON;
    }

    /* renamed from: w */
    private void m54430w() {
        if (this.f42310J0 == null) {
            bxac bxacVar = new bxac(this, null);
            this.f42310J0 = bxacVar;
            postDelayed(bxacVar, 300L);
        }
    }

    /* renamed from: x */
    private void m54431x() {
        aayti aaytiVar = this.f42312K0;
        if (aaytiVar != null) {
            removeCallbacks(aaytiVar);
        }
    }

    /* renamed from: y */
    private void m54432y() {
        com.huawei.uikit.hwdotspageindicator.widget.aauaf aauafVar = this.mOptions;
        aauafVar.m54551g(aauafVar.m54539d(m54429v(), this.f42341k0));
        com.huawei.uikit.hwdotspageindicator.widget.aauaf aauafVar2 = this.mOptions;
        aauafVar2.m54547f(aauafVar2.m54532c(m54429v(), this.f42341k0));
        this.mOptions.m54554h(this.f42329V - (this.f42305H / 2.0f));
        this.mOptions.m54562k(this.f42329V + (this.f42305H / 2.0f));
        this.mOptions.m54529b(false);
    }

    /* renamed from: z */
    private void m54433z() {
        String str;
        HwViewPager hwViewPager = this.mViewPager;
        boolean z10 = false;
        int currentItem = hwViewPager != null ? hwViewPager.getCurrentItem() : 0;
        this.f42341k0 = currentItem;
        this.mOptions.m54576r(currentItem);
        if (this.f42295C) {
            if (this.f42344n0 && isHwRtlLocale()) {
                z10 = true;
            }
            this.f42299E = z10;
            this.mOptions.m54535c(z10);
            return;
        }
        if (isHwRtlLocale()) {
            str = this.f42340j0 + "/" + (this.f42341k0 + 1);
        } else {
            str = (this.f42341k0 + 1) + "/" + this.f42340j0;
        }
        this.f42343m0 = str;
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.bzrwd
    public /* bridge */ /* synthetic */ void checkThread(String str) {
        super.checkThread(str);
    }

    public void doHotZoneInVisibleAnimation(boolean z10) {
        com.huawei.uikit.hwdotspageindicator.widget.aauaf aauafVarM54420m = m54420m();
        if (!this.f42356w) {
            this.mOptions = aauafVarM54420m;
            invalidate();
            this.f42306H0 = bfscp.COMMON;
            this.f42293B = 0;
            this.mOptions.m54583u(-1);
            this.mOptions.m54524b();
            return;
        }
        HwDotsPageIndicatorAnimation hwDotsPageIndicatorAnimation = this.mAnimator;
        if (hwDotsPageIndicatorAnimation == null || hwDotsPageIndicatorAnimation.m54475n()) {
            return;
        }
        this.mAnimator.m54485x();
        stopSpringAnimation();
        performHotZoneInVisibleAnimation(z10, aauafVarM54420m, this, this);
        this.f42306H0 = bfscp.COMMON;
        this.f42293B = 0;
    }

    public void doHotZoneVisibleAnimation(boolean z10) {
        HwDotsPageIndicatorInteractor.OnMouseOperationListener onMouseOperationListener;
        HwDotsPageIndicatorInteractor.OnMouseOperationListener onMouseOperationListener2;
        HwDotsPageIndicatorInteractor.OnGestureListener onGestureListener;
        com.huawei.uikit.hwdotspageindicator.widget.aauaf aauafVarM54426s = m54426s();
        if (!this.f42356w) {
            this.mOptions = aauafVarM54426s;
            invalidate();
            this.f42306H0 = bfscp.VISIBLE;
            this.f42298D0.m54612a(this.f42345o0);
            if (z10 && (onGestureListener = this.f42302F0) != null) {
                onGestureListener.onLongPress(2);
            }
            if (z10 || (onMouseOperationListener2 = this.f42304G0) == null) {
                return;
            }
            onMouseOperationListener2.onMoveInHotZone(2);
            return;
        }
        HwDotsPageIndicatorAnimation hwDotsPageIndicatorAnimation = this.mAnimator;
        if (hwDotsPageIndicatorAnimation == null || hwDotsPageIndicatorAnimation.m54477p()) {
            return;
        }
        this.mAnimator.m54483v();
        stopSpringAnimation();
        bqmxo bqmxoVar = new bqmxo(z10);
        if (!z10 && (onMouseOperationListener = this.f42304G0) != null) {
            onMouseOperationListener.onMoveInHotZone(1);
        }
        performHotZoneVisibleAnimation(aauafVarM54426s, z10, this, bqmxoVar);
        this.f42306H0 = bfscp.VISIBLE;
    }

    public void drawFocusBgBox(Canvas canvas, RectF rectF) {
        Paint paint = new Paint(1);
        paint.setStrokeWidth(this.f42325R);
        paint.setColor(this.f42323Q);
        paint.setStyle(Paint.Style.STROKE);
        RectF rectF2 = new RectF();
        if (!this.f42295C) {
            float fMeasureText = this.f42292A0.measureText(this.f42343m0);
            rectF2.left = ((getWidth() - fMeasureText) / 2.0f) - this.f42336f0;
            rectF2.top = this.f42325R / 2.0f;
            rectF2.right = ((getWidth() + fMeasureText) / 2.0f) + this.f42336f0;
            rectF2.bottom = getHeight() - (this.f42325R / 2.0f);
            float height = (getHeight() - this.f42325R) / 2.0f;
            canvas.drawRoundRect(rectF2, height, height, paint);
            return;
        }
        RectF rectF3 = this.f42322P0;
        if (rectF3 != null) {
            if (rectF == null) {
                rectF = rectF3;
            }
            float f10 = rectF.left;
            float f11 = this.f42325R;
            float f12 = f11 / 2.0f;
            rectF2.left = f10 + f12;
            rectF2.top = rectF.top + f12;
            rectF2.right = rectF.right - f12;
            rectF2.bottom = rectF.bottom - f12;
            float f13 = (this.f42331a0 - f11) / 2.0f;
            canvas.drawRoundRect(rectF2, f13, f13, paint);
        }
    }

    public void drawHotZone(Canvas canvas, int i10) {
        if (this.f42294B0 == null || this.mOptions.m54580t() == null) {
            return;
        }
        float f10 = (this.mOptions.m54580t().bottom - this.mOptions.m54580t().top) / 2.0f;
        this.f42294B0.setColor(i10);
        canvas.drawRoundRect(this.mOptions.m54580t(), f10, f10, this.f42294B0);
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.bzrwd
    public TimeInterpolator getAccelerateInterpolator() {
        return super.getAccelerateInterpolator();
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.bzrwd
    public TimeInterpolator getAlphaInterpolator() {
        return super.getAlphaInterpolator();
    }

    public int getBgFocusSelectedDotColor() {
        return this.f42319O;
    }

    public int getBgFocusUnSelectedDotColor() {
        return this.f42317N;
    }

    public int getCurrentBgColor() {
        return this.mOptions.m54585w();
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.bzrwd
    public TimeInterpolator getDecelerateInterpolator() {
        return super.getDecelerateInterpolator();
    }

    public int getDesiredHeight() {
        return this.f42331a0;
    }

    public int getDotColor() {
        return this.f42313L;
    }

    public int getFocusBoxColor() {
        return this.f42323Q;
    }

    public int getFocusDotColor() {
        return this.f42315M;
    }

    public RectF getHotZoneRectF() {
        return this.mOptions.m54580t();
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.bzrwd
    public /* bridge */ /* synthetic */ float getMaxDiffFraction() {
        return super.getMaxDiffFraction();
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.bzrwd
    public /* bridge */ /* synthetic */ TimeInterpolator getNavigationPointInterpolator() {
        return super.getNavigationPointInterpolator();
    }

    public int getNumTextColor() {
        return this.f42332b0;
    }

    public int getPressedStateColor() {
        return this.f42326S;
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.bzrwd
    public TimeInterpolator getScaleInterpolator() {
        return super.getScaleInterpolator();
    }

    public int getStartBgColor() {
        return this.f42327T;
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.bzrwd
    public /* bridge */ /* synthetic */ TimeInterpolator getWatchAccelerateInterpolator() {
        return super.getWatchAccelerateInterpolator();
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.bzrwd
    public /* bridge */ /* synthetic */ TimeInterpolator getWatchDecelerateInterpolator() {
        return super.getWatchDecelerateInterpolator();
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.bzrwd
    public /* bridge */ /* synthetic */ TimeInterpolator getWatchDotTouchAndSlideInterpolator() {
        return super.getWatchDotTouchAndSlideInterpolator();
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.bzrwd
    public /* bridge */ /* synthetic */ TimeInterpolator getWatchTouchFocusAccelerateInterpolator() {
        return super.getWatchTouchFocusAccelerateInterpolator();
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.bzrwd
    public /* bridge */ /* synthetic */ TimeInterpolator getWatchTouchFocusDecelerateInterpolator() {
        return super.getWatchTouchFocusDecelerateInterpolator();
    }

    public void initWatchOptions() {
        Log.i(f42280R0, "initWatchOptions");
    }

    public boolean isAnimationEnable() {
        return this.f42356w;
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.bzrwd
    public /* bridge */ /* synthetic */ boolean isFocusAccelerateAnimationRunning() {
        return super.isFocusAccelerateAnimationRunning();
    }

    public boolean isFocusConfirm() {
        return this.f42362z;
    }

    public boolean isGainFocused() {
        return this.f42360y;
    }

    public boolean isGestureEnable() {
        if (this.f42354v) {
            return false;
        }
        return this.f42358x;
    }

    public boolean isHwRtlLocale() {
        String language = Locale.getDefault().getLanguage();
        return (language.contains(Constants.AR_CACHE) || language.contains("fa") || language.contains("iw")) || (language.contains("ug") || language.contains(Constants.URDU_LANG)) || m54427t();
    }

    public boolean isRtl() {
        return this.f42299E;
    }

    public boolean isShowAsDot() {
        return this.f42295C;
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.bzrwd
    public /* bridge */ /* synthetic */ boolean isSpringAnimationRunning() {
        return super.isSpringAnimationRunning();
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.bzrwd
    public /* bridge */ /* synthetic */ boolean isWatchSpringAnimationRunning() {
        return super.isWatchSpringAnimationRunning();
    }

    public void nextPage() throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        int i10 = this.f42341k0;
        if (i10 == this.f42340j0 - 1) {
            if (this.mViewPager.isSupportLoop()) {
                m54378b(0, false);
                m54376b(this.f42341k0, 0);
                return;
            }
            return;
        }
        m54376b(i10, i10 + 1);
        if (this.f42295C && this.f42356w) {
            m54381b(true);
        } else {
            this.mViewPager.nextPage();
        }
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.HwDotsPageIndicatorAnimation.AnimationUpdateListener
    public void onAnimationUpdate(com.huawei.uikit.hwdotspageindicator.widget.aauaf aauafVar) {
        if (aauafVar == null) {
            return;
        }
        this.mOptions.m54528b(aauafVar.m54580t());
        this.mOptions.m54575q(aauafVar.m54585w());
        this.mOptions.m54516a(aauafVar.m54544e());
        this.mOptions.m54540d(aauafVar.m54549g());
        this.mOptions.m54515a(aauafVar.m54566m());
        invalidate();
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f42352u = true;
        this.f42342l0 = true;
        if (this.f42354v) {
            startAutoPlay(this.f42350t);
        }
        if (this.f42291A) {
            this.f42353u0 = hasFocus();
            boolean zHasWindowFocus = hasWindowFocus();
            this.f42355v0 = zHasWindowFocus;
            setIndicatorFocusChanged(this.f42353u0 && zHasWindowFocus);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (this.f42295C && !this.f42354v && this.f42358x) {
            if ((isFocusAccelerateAnimationRunning() && isSpringAnimationRunning()) || this.f42306H0 != bfscp.MOUSE_ON_DOT || this.mOptions.m54504B() == -1) {
                return;
            }
            HwDotsPageIndicatorInteractor.OnMouseOperationListener onMouseOperationListener = this.f42304G0;
            if (onMouseOperationListener != null) {
                onMouseOperationListener.onDotClick(this.f42341k0, this.mOptions.m54504B());
            }
            m54378b(this.mOptions.m54504B(), true);
            m54388c(this.mOptions.m54504B());
            this.mOptions.m54583u(-1);
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f42342l0 = false;
        if (this.f42354v) {
            m54348A();
        }
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.HwDotsPageIndicatorAnimation.AnimationUpdateListener
    public void onDotCenterChanged(float[] fArr) {
        this.mOptions.m54516a(fArr);
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (canvas == null || this.f42340j0 <= 0) {
            return;
        }
        if (!this.f42295C) {
            m54391c(canvas);
        } else {
            m54360a(canvas);
            m54380b(canvas);
        }
    }

    @Override // android.view.View
    public void onFocusChanged(boolean z10, int i10, Rect rect) {
        super.onFocusChanged(z10, i10, rect);
        if (this.f42291A) {
            if (!z10 || this.f42306H0 == bfscp.COMMON) {
                if (m54370a(z10, this.f42355v0)) {
                    setIndicatorFocusChanged(z10);
                }
                this.f42353u0 = z10;
                invalidate();
            }
        }
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.HwDotsPageIndicatorAnimation.AnimationUpdateListener
    public void onFocusDotChanged(boolean z10, float f10) {
        if (z10) {
            if (this.f42349s0) {
                this.mOptions.m54547f(f10);
            } else {
                this.mOptions.m54551g(f10);
            }
        } else if (this.f42349s0) {
            if (!isSpringAnimationRunning()) {
                this.mOptions.m54551g(f10);
            }
        } else if (!isSpringAnimationRunning()) {
            this.mOptions.m54547f(f10);
        }
        invalidate();
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.HwDotsPageIndicatorAnimation.AnimationUpdateListener
    public void onFocusSingleScaled(RectF rectF) {
        if (rectF == null) {
            return;
        }
        this.mOptions.m54551g(this.f42299E ? rectF.right : rectF.left);
        this.mOptions.m54547f(this.f42299E ? rectF.left : rectF.right);
        this.mOptions.m54554h(rectF.top);
        this.mOptions.m54562k(rectF.bottom);
        invalidate();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        if (!m54368a(motionEvent.getAction(), x10, y10)) {
            return super.onHoverEvent(motionEvent);
        }
        if (this.f42306H0 != bfscp.COMMON) {
            m54395d(x10, y10);
            return super.onHoverEvent(motionEvent);
        }
        if (this.f42347q0) {
            m54431x();
            doHotZoneVisibleAnimation(false);
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) throws Resources.NotFoundException {
        if (accessibilityNodeInfo != null) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClickable(false);
            accessibilityNodeInfo.removeAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_CLICK);
            Resources resources = getContext().getResources();
            int i10 = C8711R.plurals.page_progress;
            int i11 = this.f42341k0 + 1;
            String quantityString = resources.getQuantityString(i10, i11, Integer.valueOf(i11));
            Resources resources2 = getContext().getResources();
            int i12 = C8711R.plurals.total_page;
            int i13 = this.f42340j0;
            String quantityString2 = resources2.getQuantityString(i12, i13, Integer.valueOf(i13));
            accessibilityNodeInfo.setContentDescription(String.format(Locale.ROOT, getContext().getString(C8711R.string.page), quantityString, quantityString2));
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (keyEvent == null) {
            return false;
        }
        if (!this.f42358x && this.f42295C) {
            return false;
        }
        if (this.f42340j0 <= 1 || !this.f42360y || (i10 != 21 && i10 != 22)) {
            return super.onKeyDown(i10, keyEvent);
        }
        if (!(i10 == 21 && this.f42299E) && (i10 != 22 || this.f42299E)) {
            prePage();
        } else {
            nextPage();
        }
        return true;
    }

    @Override // android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        if (z10 || this.f42297D) {
            m54385c();
            this.f42297D = false;
        }
        this.f42352u = false;
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        Pair<Integer, Integer> pairM54594a = com.huawei.uikit.hwdotspageindicator.widget.bqmxo.m54594a(i10, i11, this.f42295C ? com.huawei.uikit.hwdotspageindicator.widget.bqmxo.m54591a(this.f42340j0, getScaledWidth()) : View.MeasureSpec.getSize(i10), getDesiredHeight());
        setMeasuredDimension(((Integer) pairM54594a.first).intValue(), ((Integer) pairM54594a.second).intValue());
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i10) {
        HwViewPager.OnPageChangeListener onPageChangeListener = this.f42357w0;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrollStateChanged(i10);
        }
        m54352a(i10);
        this.f42293B = i10;
        if (i10 == 1 && this.f42306H0 == bfscp.COMMON) {
            stopSpringAnimation();
            HwDotsPageIndicatorAnimation hwDotsPageIndicatorAnimation = this.mAnimator;
            if (hwDotsPageIndicatorAnimation != null && (hwDotsPageIndicatorAnimation.m54472k() || this.mAnimator.m54470i())) {
                this.mAnimator.m54480s();
                this.mAnimator.m54478q();
                this.f42308I0 = awsks.DEFAULT;
            }
        }
        if (this.f42293B != 0) {
            m54394d();
        }
        if (this.f42293B == 0) {
            HwDotsPageIndicatorAnimation hwDotsPageIndicatorAnimation2 = this.mAnimator;
            boolean z10 = hwDotsPageIndicatorAnimation2 != null && (hwDotsPageIndicatorAnimation2.m54477p() || this.mAnimator.m54475n());
            if (!isFocusAccelerateAnimationRunning() && !z10) {
                boolean zM54518a = true ^ this.mOptions.m54518a(m54429v(), this.f42341k0, this.mOptions.m54568n(), this.mOptions.m54563l());
                if (this.f42295C && zM54518a) {
                    stopSpringAnimation();
                    com.huawei.uikit.hwdotspageindicator.widget.aauaf aauafVar = this.mOptions;
                    aauafVar.m54551g(aauafVar.m54539d(m54429v(), this.f42341k0));
                    com.huawei.uikit.hwdotspageindicator.widget.aauaf aauafVar2 = this.mOptions;
                    aauafVar2.m54547f(aauafVar2.m54532c(m54429v(), this.f42341k0));
                    invalidate();
                }
            }
            this.f42308I0 = awsks.DEFAULT;
            this.mOptions.m54576r(this.f42341k0);
            if (!this.f42295C || z10) {
                return;
            }
            m54363a(m54429v());
        }
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwViewPager.OnPageChangeListener
    public void onPageScrolled(int i10, float f10, int i11) {
        HwViewPager.OnPageChangeListener onPageChangeListener = this.f42357w0;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrolled(i10, f10, i11);
        }
        if (this.f42293B == 1) {
            this.f42348r0 = i10 == this.f42341k0;
        }
        if (m54392c(i10, f10)) {
            m54374b(i10, f10);
        }
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwViewPager.OnPageChangeListener
    public void onPageSelected(int i10) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        HwViewPager.OnPageChangeListener onPageChangeListener = this.f42357w0;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageSelected(i10);
        }
        if (!this.f42342l0) {
            m54433z();
            return;
        }
        if (!this.f42295C || !this.f42356w) {
            setSelectedPage(i10);
            return;
        }
        com.huawei.uikit.hwdotspageindicator.widget.bqmxo.m54596a(this.f42308I0 == awsks.DEFAULT);
        if (com.huawei.uikit.hwdotspageindicator.widget.bqmxo.m54609k()) {
            stopSpringAnimation();
            setSelectedPage(i10);
            m54422o();
            invalidate();
            return;
        }
        if ((this.f42354v ? m54399d(i10) : m54403e(i10)) && !this.f42360y) {
            HwDotsPageIndicatorAnimation hwDotsPageIndicatorAnimation = this.mAnimator;
            if (hwDotsPageIndicatorAnimation != null) {
                hwDotsPageIndicatorAnimation.m54480s();
                this.mAnimator.m54478q();
                stopSpringAnimation();
            }
            m54378b(i10, false);
        }
        setSelectedPage(i10);
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.HwDotsPageIndicatorAnimation.AnimationUpdateListener
    public void onSingleScaled(boolean z10, int i10, float f10) {
        if (z10) {
            this.mOptions.m54564l(f10);
        }
        this.mOptions.m54514a(i10, f10);
        invalidate();
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        setMeasuredDimension(i10, i11);
        m54385c();
        if (i10 == i12 && i11 == i13) {
            return;
        }
        this.f42352u = true;
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.HwDotsPageIndicatorAnimation.AnimationUpdateListener
    public void onSpringAnimationUpdate(boolean z10, float f10) {
        if (this.f42293B == 1 || com.huawei.uikit.hwdotspageindicator.widget.bqmxo.m54609k()) {
            return;
        }
        if (z10) {
            this.mOptions.m54551g(f10);
        } else {
            this.mOptions.m54547f(f10);
        }
        invalidate();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (motionEvent == null) {
            return false;
        }
        if (!this.f42295C || this.f42340j0 == 0 || this.f42354v || !this.f42358x) {
            return super.onTouchEvent(motionEvent);
        }
        int actionIndex = motionEvent.getActionIndex();
        float x10 = motionEvent.getX(actionIndex);
        float y10 = motionEvent.getY(actionIndex);
        int action = motionEvent.getAction() & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA;
        if (this.f42306H0 == bfscp.MOUSE_ON_DOT) {
            m54431x();
            m54430w();
            return super.onTouchEvent(motionEvent);
        }
        if (action == 0 || action == 5) {
            m54412h();
            if (this.f42346p0 == 0) {
                this.f42346p0 = SystemClock.uptimeMillis();
            }
            this.f42345o0 = x10;
        } else if (action == 1 || action == 6) {
            if (SystemClock.uptimeMillis() - this.f42346p0 < 300) {
                m54387c(x10, y10);
            }
            m54416j();
        } else if (action == 2) {
            m54386c(x10);
            this.f42345o0 = x10;
        } else {
            if (action != 3) {
                return super.onTouchEvent(motionEvent);
            }
            m54416j();
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        if (this.f42291A) {
            if (m54370a(this.f42353u0, z10)) {
                setIndicatorFocusChanged(z10);
            }
            this.f42355v0 = z10;
            invalidate();
        }
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.bzrwd
    public /* bridge */ /* synthetic */ void perforWatchSpringAnimation(boolean z10, float f10, float f11, HwWatchDotsPageIndicatorAnimation.AnimationUpdateListener animationUpdateListener) {
        super.perforWatchSpringAnimation(z10, f10, f11, animationUpdateListener);
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.bzrwd
    public /* bridge */ /* synthetic */ void performDotCenterXsLayoutAnimation(float[] fArr, HwDotsPageIndicatorAnimation.AnimationUpdateListener animationUpdateListener) {
        super.performDotCenterXsLayoutAnimation(fArr, animationUpdateListener);
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.bzrwd
    public /* bridge */ /* synthetic */ void performFocusAccelerateAnimation(float f10, float f11, HwDotsPageIndicatorAnimation.AnimationUpdateListener animationUpdateListener) {
        super.performFocusAccelerateAnimation(f10, f11, animationUpdateListener);
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.bzrwd
    public /* bridge */ /* synthetic */ void performFocusSingleZoomInAnimation(RectF rectF, HwDotsPageIndicatorAnimation.AnimationUpdateListener animationUpdateListener) {
        super.performFocusSingleZoomInAnimation(rectF, animationUpdateListener);
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.bzrwd
    public /* bridge */ /* synthetic */ void performFocusSingleZoomOutAnimation(RectF rectF, HwDotsPageIndicatorAnimation.AnimationUpdateListener animationUpdateListener) {
        super.performFocusSingleZoomOutAnimation(rectF, animationUpdateListener);
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.bzrwd
    public /* bridge */ /* synthetic */ void performHotZoneInVisibleAnimation(boolean z10, com.huawei.uikit.hwdotspageindicator.widget.aauaf aauafVar, View view, HwDotsPageIndicatorAnimation.AnimationUpdateListener animationUpdateListener) {
        super.performHotZoneInVisibleAnimation(z10, aauafVar, view, animationUpdateListener);
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.bzrwd
    public /* bridge */ /* synthetic */ void performHotZoneVisibleAnimation(com.huawei.uikit.hwdotspageindicator.widget.aauaf aauafVar, boolean z10, HwDotsPageIndicatorAnimation.AnimationUpdateListener animationUpdateListener, HwDotsPageIndicatorAnimation.AnimationStateListener animationStateListener) {
        super.performHotZoneVisibleAnimation(aauafVar, z10, animationUpdateListener, animationStateListener);
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.bzrwd
    public /* bridge */ /* synthetic */ void performHotZoneVisibleAnimationForWatch(HwWatchDotsPageIndicatorOptions hwWatchDotsPageIndicatorOptions, HwWatchDotsPageIndicatorAnimation.AnimationUpdateListener animationUpdateListener) {
        super.performHotZoneVisibleAnimationForWatch(hwWatchDotsPageIndicatorOptions, animationUpdateListener);
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.bzrwd
    public /* bridge */ /* synthetic */ void performSingleDotZoomInAnimation(int i10, float f10, HwDotsPageIndicatorAnimation.AnimationUpdateListener animationUpdateListener) {
        super.performSingleDotZoomInAnimation(i10, f10, animationUpdateListener);
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.bzrwd
    public /* bridge */ /* synthetic */ void performSingleDotZoomOutAnimation(int i10, View view, HwDotsPageIndicatorAnimation.AnimationUpdateListener animationUpdateListener) {
        super.performSingleDotZoomOutAnimation(i10, view, animationUpdateListener);
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.bzrwd
    public /* bridge */ /* synthetic */ void performSpringAnimation(bzrwd.akxao akxaoVar, HwDotsPageIndicatorAnimation.AnimationUpdateListener animationUpdateListener) {
        super.performSpringAnimation(akxaoVar, animationUpdateListener);
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.bzrwd
    public /* bridge */ /* synthetic */ void performTargetAccelerateAnimation(float f10, float f11, HwDotsPageIndicatorAnimation.AnimationUpdateListener animationUpdateListener, HwDotsPageIndicatorAnimation.AnimationStateListener animationStateListener) {
        super.performTargetAccelerateAnimation(f10, f11, animationUpdateListener, animationStateListener);
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.bzrwd
    public /* bridge */ /* synthetic */ void performTargetDecelerateAnimation(float f10, float f11, HwDotsPageIndicatorAnimation.AnimationUpdateListener animationUpdateListener, HwDotsPageIndicatorAnimation.AnimationStateListener animationStateListener) {
        super.performTargetDecelerateAnimation(f10, f11, animationUpdateListener, animationStateListener);
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.bzrwd
    public /* bridge */ /* synthetic */ void performWatchHotZoneInVisibleAnimation(HwWatchDotsPageIndicatorOptions hwWatchDotsPageIndicatorOptions, HwWatchDotsPageIndicatorAnimation.AnimationUpdateListener animationUpdateListener) {
        super.performWatchHotZoneInVisibleAnimation(hwWatchDotsPageIndicatorOptions, animationUpdateListener);
    }

    public void prePage() throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        int i10 = this.f42341k0;
        if (i10 == 0) {
            if (this.mViewPager.isSupportLoop()) {
                m54378b(this.f42340j0 - 1, false);
                m54376b(this.f42341k0, this.f42340j0 - 1);
                return;
            }
            return;
        }
        m54376b(i10, i10 - 1);
        if (this.f42295C && this.f42356w) {
            m54381b(false);
        } else {
            this.mViewPager.prePage();
        }
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.bzrwd
    public void setAlphaInterpolator(TimeInterpolator timeInterpolator) {
        super.setAlphaInterpolator(timeInterpolator);
    }

    public void setAnimationEnable(boolean z10) {
        this.f42356w = z10;
        if (z10 && this.mAnimator == null) {
            this.mAnimator = new HwDotsPageIndicatorAnimation();
        }
    }

    public void setDotColor(int i10) {
        checkThread("setDotColor");
        if (this.f42313L != i10) {
            this.f42313L = i10;
            Paint paint = this.f42361y0;
            if (paint == null || !this.f42295C) {
                return;
            }
            paint.setColor(i10);
            invalidate();
        }
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.bzrwd
    public void setDragAccelerateInterpolator(TimeInterpolator timeInterpolator) {
        super.setDragAccelerateInterpolator(timeInterpolator);
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.bzrwd
    public void setDragDecelerateInterpolator(TimeInterpolator timeInterpolator) {
        super.setDragDecelerateInterpolator(timeInterpolator);
    }

    public void setFocusBoxColor(int i10) {
        this.f42323Q = i10;
    }

    public void setFocusConfirm(boolean z10) {
        this.f42362z = z10;
    }

    public void setFocusDotColor(int i10) {
        checkThread("setFocusDotColor");
        if (this.f42315M != i10) {
            this.f42315M = i10;
            Paint paint = this.f42363z0;
            if (paint == null || !this.f42295C) {
                return;
            }
            paint.setColor(i10);
            invalidate();
        }
    }

    public void setGestureEnable(boolean z10) {
        if (this.f42354v) {
            return;
        }
        this.f42358x = z10;
    }

    public void setIndicatorFocusChanged(boolean z10) {
        this.f42360y = z10;
    }

    public void setNumTextColor(int i10) {
        checkThread("setNumTextColor");
        if (this.f42332b0 != i10) {
            this.f42332b0 = i10;
            Paint paint = this.f42292A0;
            if (paint == null || this.f42295C) {
                return;
            }
            paint.setColor(i10);
            invalidate();
        }
    }

    public void setOnIndicatorClickListener(HwDotsPageIndicatorInteractor.OnClickListener onClickListener) {
        this.f42300E0 = onClickListener;
    }

    public void setOnIndicatorGestureListener(HwDotsPageIndicatorInteractor.OnGestureListener onGestureListener) {
        this.f42302F0 = onGestureListener;
    }

    public void setOnIndicatorMouseOperatorListener(HwDotsPageIndicatorInteractor.OnMouseOperationListener onMouseOperationListener) {
        this.f42304G0 = onMouseOperationListener;
    }

    public void setOnPageChangeListener(HwViewPager.OnPageChangeListener onPageChangeListener) {
        this.f42357w0 = onPageChangeListener;
    }

    public void setPressedStateColor(int i10) {
        checkThread("setPressedStateColor");
        this.f42326S = i10;
        if (m54429v() || !this.f42295C) {
            return;
        }
        this.mOptions.m54575q(this.f42326S);
        invalidate();
    }

    public void setRtlEnable(boolean z10) {
        this.f42344n0 = z10;
        invalidate();
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.bzrwd
    public void setScaleInterpolator(TimeInterpolator timeInterpolator) {
        super.setScaleInterpolator(timeInterpolator);
    }

    public void setSelectedPage(int i10) {
        if (i10 == this.f42341k0 || this.f42340j0 == 0) {
            return;
        }
        m54433z();
        if (m54428u()) {
            if (m54429v()) {
                m54422o();
            } else {
                this.mOptions.m54516a(this.mOptions.m54545e(false, this.f42341k0));
                com.huawei.uikit.hwdotspageindicator.widget.aauaf aauafVar = this.mOptions;
                aauafVar.m54551g(aauafVar.m54555i(this.f42341k0));
                com.huawei.uikit.hwdotspageindicator.widget.aauaf aauafVar2 = this.mOptions;
                aauafVar2.m54547f(aauafVar2.m54553h(this.f42341k0));
            }
        }
        invalidate();
    }

    public void setShowAsDot(boolean z10) {
        checkThread("setShowAsDot");
        if (this.f42295C == z10) {
            return;
        }
        this.f42295C = z10;
        this.f42297D = true;
        requestLayout();
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.bzrwd
    public void setSpringAnimationDamping(float f10) {
        super.setSpringAnimationDamping(f10);
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.bzrwd
    public void setSpringAnimationStiffness(float f10) {
        super.setSpringAnimationStiffness(f10);
    }

    public void setViewPager(HwViewPager hwViewPager) {
        if (hwViewPager == null || hwViewPager.getAdapter() == null) {
            return;
        }
        this.mViewPager = hwViewPager;
        setPageCount(hwViewPager.getAdapter().getCount());
        hwViewPager.getAdapter().registerDataSetObserver(new aauaf());
        hwViewPager.addOnPageChangeListener(this);
        m54433z();
    }

    public void startAutoPlay(int i10) {
        this.f42354v = true;
        this.f42358x = false;
        this.f42350t = i10;
        if (this.f42359x0 == null) {
            m54419l();
        }
        this.f42359x0.removeCallbacks(this.f42324Q0);
        this.f42359x0.postDelayed(this.f42324Q0, i10);
    }

    public void stopAutoPlay() {
        this.f42354v = false;
        m54348A();
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.bzrwd
    public /* bridge */ /* synthetic */ void stopSpringAnimation() {
        super.stopSpringAnimation();
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.bzrwd
    public /* bridge */ /* synthetic */ void stopWatchSpringAnimation() {
        super.stopWatchSpringAnimation();
    }

    public HwDotsPageIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C8711R.attr.hwDotsPageIndicatorStyle);
    }

    /* renamed from: b */
    private void m54379b(Context context, AttributeSet attributeSet, int i10) {
        m54359a(context, attributeSet, i10);
        boolean z10 = HwWidgetInstantiator.getCurrnetType(context) == 8;
        this.mIsWatchType = z10;
        if (this.f42354v) {
            this.f42358x = false;
        }
        if (!this.f42295C) {
            this.f42358x = false;
            this.f42356w = false;
        }
        if (this.f42356w) {
            if (z10) {
                this.mWatchAnimator = new HwWatchDotsPageIndicatorAnimation();
            } else {
                this.mAnimator = new HwDotsPageIndicatorAnimation();
            }
        }
        if (isInEditMode()) {
            this.f42340j0 = 3;
            this.mOptions.m54579s(3);
            this.mWatchOptions.setPageCount(this.f42340j0);
        }
        m54390c(context, attributeSet, i10);
        m54397d(context, attributeSet, i10);
        if (this.f42354v) {
            m54419l();
        }
        setOnClickListener(this);
    }

    /* renamed from: c */
    private void m54390c(Context context, AttributeSet attributeSet, int i10) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C8711R.styleable.HwDotsPageIndicator, i10, 0);
        this.f42305H = typedArrayObtainStyledAttributes.getDimensionPixelSize(C8711R.styleable.HwDotsPageIndicator_hwUnSelectedScaleDiameter, C8711R.dimen.hwdotspageindicator_unselected_zoom_in_diameter);
        this.f42307I = typedArrayObtainStyledAttributes.getDimensionPixelSize(C8711R.styleable.HwDotsPageIndicator_hwUnSelectedSecondScaleDiameter, C8711R.dimen.hwdotspageindicator_unselected_zoom_in_second_diameter);
        this.f42301F = typedArrayObtainStyledAttributes.getDimensionPixelSize(C8711R.styleable.HwDotsPageIndicator_hwUnSelectedDiameter, C8711R.dimen.hwdotspageindicator_unselected_diameter);
        this.f42309J = typedArrayObtainStyledAttributes.getDimensionPixelSize(C8711R.styleable.HwDotsPageIndicator_hwDotGap, C8711R.dimen.hwdotspageindicator_default_gap);
        this.f42311K = typedArrayObtainStyledAttributes.getDimensionPixelSize(C8711R.styleable.HwDotsPageIndicator_hwDotScaleGap, C8711R.dimen.hwdotspageindicator_zoom_in_gap);
        this.f42321P = typedArrayObtainStyledAttributes.getDimensionPixelSize(C8711R.styleable.HwDotsPageIndicator_hwSelectedLength, C8711R.dimen.hwdotspageindicator_selected_width);
        this.f42331a0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(C8711R.styleable.HwDotsPageIndicator_hwTotalHeight, C8711R.dimen.hwdotspageindicator_total_height);
        this.f42328U = typedArrayObtainStyledAttributes.getDimensionPixelSize(C8711R.styleable.HwDotsPageIndicator_hwSelectedScaleLength, C8711R.dimen.hwdotspageindicator_selected_zoom_in_length);
        this.f42325R = typedArrayObtainStyledAttributes.getDimensionPixelSize(C8711R.styleable.HwDotsPageIndicator_hwFocusBoxWidth, C8711R.dimen.hwdotspageindicator_focus_box_width);
        this.f42330W = typedArrayObtainStyledAttributes.getDimensionPixelSize(C8711R.styleable.HwDotsPageIndicator_hwHotZoneHeight, C8711R.dimen.hwdotspageindicator_default_zone_height);
        this.f42334d0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(C8711R.styleable.HwDotsPageIndicator_hwMarginStartAndEnd, C8711R.dimen.hwdotspageindicator_margin_start_end);
        this.f42335e0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(C8711R.styleable.HwDotsPageIndicator_hwHotZoneMarginStartAndEnd, C8711R.dimen.hwdotspageindicator_hot_zone_margin_start_end);
        typedArrayObtainStyledAttributes.recycle();
        Resources resources = getResources();
        float dimensionPixelSize = resources.getDimensionPixelSize(C8711R.dimen.hwdotspageindicator_touch_move_response_length);
        float dimensionPixelOffset = resources.getDimensionPixelOffset(C8711R.dimen.hwdotspageindicator_touch_move_valid_length);
        float dimensionPixelOffset2 = resources.getDimensionPixelOffset(C8711R.dimen.hwdotspageindicator_touch_bottom_max_scale_distance);
        this.f42298D0.m54619d(dimensionPixelSize);
        this.f42298D0.m54621e(dimensionPixelOffset);
        this.f42298D0.m54617c(dimensionPixelOffset2);
        this.mOptions.m54540d(this.f42301F / 2.0f);
        this.mOptions.m54569n(this.f42309J);
        this.mOptions.m54581t(this.f42311K);
        this.mOptions.m54556i(this.f42321P);
        this.mOptions.m54558j(this.f42328U);
        this.mOptions.m54543e(this.f42305H);
        this.f42303G = this.f42301F / 2.0f;
        m54423p();
    }

    /* renamed from: d */
    private void m54397d(Context context, AttributeSet attributeSet, int i10) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C8711R.styleable.HwDotsPageIndicator, i10, 0);
        this.f42339i0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(C8711R.styleable.HwDotsPageIndicator_hwTextFont, C8711R.dimen.emui_text_size_body2);
        this.f42336f0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(C8711R.styleable.HwDotsPageIndicator_hwHotZoneNumMargin, C8711R.dimen.hwdotspageindocator_hot_zone_num_margin);
        this.f42325R = typedArrayObtainStyledAttributes.getDimensionPixelSize(C8711R.styleable.HwDotsPageIndicator_hwFocusBoxWidth, C8711R.dimen.hwdotspageindicator_focus_box_width);
        typedArrayObtainStyledAttributes.recycle();
        Paint paint = new Paint(1);
        this.f42292A0 = paint;
        paint.setTextSize(this.f42339i0);
        this.f42292A0.setColor(this.f42332b0);
        this.f42292A0.setTextAlign(Paint.Align.CENTER);
        this.f42292A0.setTypeface(Typeface.create(getResources().getString(C8711R.string.emui_text_font_family_regular), 0));
        this.f42296C0 = this.f42292A0.getFontMetrics();
    }

    /* renamed from: e */
    private void m54402e(int i10, float f10, int i11) {
        if (this.f42348r0) {
            m54354a(i10, f10, i11);
            return;
        }
        float fM54532c = this.mOptions.m54532c(m54429v(), this.f42341k0);
        float f11 = 1.0f - f10;
        this.mOptions.m54547f(this.f42299E ? fM54532c + (m54400e(f11) * i11) : fM54532c - (m54400e(f11) * i11));
        float fM54568n = this.mOptions.m54568n();
        float fM54539d = this.mOptions.m54539d(m54429v(), i10 + 1);
        if (isSpringAnimationRunning()) {
            return;
        }
        this.f42349s0 = true;
        m54364a(true, fM54568n, fM54539d, this.mSpringStiffness, this.mSpringDamping);
    }

    /* renamed from: f */
    private void m54407f(int i10, float f10, int i11) {
        if (!this.f42348r0) {
            m54375b(i10, f10, i11);
            return;
        }
        float fM54539d = this.mOptions.m54539d(m54429v(), i10);
        this.mOptions.m54551g(this.f42299E ? fM54539d - (m54400e(f10) * i11) : fM54539d + (m54400e(f10) * i11));
        float fM54563l = this.mOptions.m54563l();
        float fM54532c = this.mOptions.m54532c(m54429v(), i10);
        if (isSpringAnimationRunning()) {
            return;
        }
        this.f42349s0 = false;
        m54364a(false, fM54563l, fM54532c, this.mSpringStiffness, this.mSpringDamping);
    }

    /* renamed from: g */
    private void m54410g() {
        if (!this.f42358x || this.mAnimator == null || !this.mOptions.m54506D() || this.mAnimator.m54477p() || this.mAnimator.m54474m()) {
            return;
        }
        this.mAnimator.m54481t();
        float fM54561k = this.f42305H - (this.mOptions.m54561k() - this.mOptions.m54570o());
        if (this.f42356w) {
            float f10 = fM54561k / 2.0f;
            performFocusSingleZoomOutAnimation(new RectF(this.mOptions.m54568n() - fM54561k, this.mOptions.m54570o() - f10, this.mOptions.m54563l() + fM54561k, this.mOptions.m54561k() + f10), this);
            this.f42306H0 = bfscp.VISIBLE;
            return;
        }
        com.huawei.uikit.hwdotspageindicator.widget.aauaf aauafVar = this.mOptions;
        float f11 = fM54561k / 2.0f;
        aauafVar.m54554h(aauafVar.m54570o() - f11);
        com.huawei.uikit.hwdotspageindicator.widget.aauaf aauafVar2 = this.mOptions;
        aauafVar2.m54562k(aauafVar2.m54561k() + f11);
        float fM54568n = this.mOptions.m54568n();
        float fM54563l = this.mOptions.m54563l();
        this.mOptions.m54551g(this.f42299E ? fM54568n + fM54561k : fM54568n - fM54561k);
        this.mOptions.m54547f(this.f42299E ? fM54563l - fM54561k : fM54563l + fM54561k);
        this.f42306H0 = bfscp.VISIBLE;
        this.mOptions.m54529b(false);
        invalidate();
    }

    /* renamed from: h */
    private void m54412h() {
        HwDotsPageIndicatorInteractor.OnGestureListener onGestureListener;
        if (!this.f42358x || (onGestureListener = this.f42302F0) == null || this.f42360y) {
            return;
        }
        onGestureListener.onLongPress(0);
        m54430w();
    }

    /* renamed from: i */
    private void m54414i() {
        if (!this.f42358x || this.f42302F0 == null) {
            return;
        }
        bxac bxacVar = this.f42310J0;
        if (bxacVar != null) {
            removeCallbacks(bxacVar);
            this.f42310J0 = null;
        }
        if (m54429v()) {
            return;
        }
        doHotZoneInVisibleAnimation(true);
        if (this.f42308I0 == awsks.SLIDE) {
            this.f42308I0 = awsks.DEFAULT;
        }
        this.f42298D0.m54612a(0.0f);
    }

    /* renamed from: j */
    private void m54416j() {
        this.f42346p0 = 0L;
        this.f42298D0.m54613a(true);
        m54414i();
    }

    /* renamed from: k */
    private void m54418k() {
        int paddingLeft = getPaddingLeft();
        int width = getWidth() - getPaddingRight();
        float desiredWidth = getDesiredWidth();
        float f10 = paddingLeft + ((width - desiredWidth) / 2.0f) + this.f42334d0;
        float f11 = this.f42331a0 / 2.0f;
        this.f42329V = f11;
        this.mOptions.m54534c(f11);
        this.mOptions.m54512a(f10);
        float f12 = f10 - this.f42334d0;
        float f13 = this.f42329V;
        float f14 = this.f42330W / 2.0f;
        float f15 = desiredWidth + f12;
        this.f42320O0 = new RectF(f12, f13 - f14, f15, f13 + f14);
        float f16 = this.f42335e0 - this.f42334d0;
        float f17 = this.f42329V;
        float f18 = this.f42331a0 / 2.0f;
        this.f42322P0 = new RectF(f12 - f16, f17 - f18, f15 + f16, f17 + f18);
    }

    public HwDotsPageIndicator(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f42350t = 5000;
        this.f42352u = true;
        this.f42293B = 0;
        this.f42299E = false;
        this.f42344n0 = true;
        this.f42346p0 = 0L;
        this.f42347q0 = false;
        this.f42348r0 = false;
        this.f42349s0 = true;
        this.f42351t0 = false;
        this.f42298D0 = new bqmxo.bzrwd();
        this.f42306H0 = bfscp.COMMON;
        this.f42308I0 = awsks.DEFAULT;
        this.f42324Q0 = new bzrwd();
        m54379b(super.getContext(), attributeSet, i10);
        setOnClickListener(this);
        setFocusable(true);
        setDefaultFocusHighlightEnabled(false);
    }

    /* renamed from: a */
    private void m54359a(Context context, AttributeSet attributeSet, int i10) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C8711R.styleable.HwDotsPageIndicator, i10, 0);
        this.f42354v = typedArrayObtainStyledAttributes.getBoolean(C8711R.styleable.HwDotsPageIndicator_hwIsAutoPlay, false);
        this.f42313L = typedArrayObtainStyledAttributes.getColor(C8711R.styleable.HwDotsPageIndicator_hwUnselectedDotColor, ContextCompat.getColor(getContext(), C8711R.color.emui_control_normal));
        int i11 = C8711R.styleable.HwDotsPageIndicator_hwSelectedDotColor;
        Context context2 = getContext();
        int i12 = C8711R.color.emui_control_focused;
        this.f42315M = typedArrayObtainStyledAttributes.getColor(i11, ContextCompat.getColor(context2, i12));
        int i13 = C8711R.styleable.HwDotsPageIndicator_hwBgEndColor;
        Context context3 = getContext();
        int i14 = C8711R.color.emui_clickeffic_default_color;
        this.f42326S = typedArrayObtainStyledAttributes.getColor(i13, ContextCompat.getColor(context3, i14));
        int color = typedArrayObtainStyledAttributes.getColor(C8711R.styleable.HwDotsPageIndicator_hwBgStartColor, ContextCompat.getColor(getContext(), i14));
        this.f42327T = color;
        this.mOptions.m54573p(color);
        this.mOptions.m54571o(this.f42326S);
        this.f42323Q = typedArrayObtainStyledAttributes.getColor(C8711R.styleable.HwDotsPageIndicator_hwFocusBoxColor, ContextCompat.getColor(getContext(), C8711R.color.emui_control_focused_outline));
        this.f42295C = typedArrayObtainStyledAttributes.getBoolean(C8711R.styleable.HwDotsPageIndicator_hwIsShowAsDot, true);
        this.f42356w = typedArrayObtainStyledAttributes.getBoolean(C8711R.styleable.HwDotsPageIndicator_hwHasAnimation, true);
        this.f42358x = typedArrayObtainStyledAttributes.getBoolean(C8711R.styleable.HwDotsPageIndicator_hwIsOperable, true);
        this.f42332b0 = typedArrayObtainStyledAttributes.getColor(C8711R.styleable.HwDotsPageIndicator_hwNumTextColor, ContextCompat.getColor(getContext(), C8711R.color.emui_selector_text_secondary));
        this.f42333c0 = typedArrayObtainStyledAttributes.getColor(C8711R.styleable.HwDotsPageIndicator_hwNumFocusTextColor, ContextCompat.getColor(getContext(), C8711R.color.emui_functional_blue));
        this.f42317N = typedArrayObtainStyledAttributes.getColor(C8711R.styleable.HwDotsPageIndicator_hwBgFocusUnSelectedDotColor, ContextCompat.getColor(getContext(), C8711R.color.hwdotspageindicator_unselected_focus_color));
        this.f42319O = typedArrayObtainStyledAttributes.getColor(C8711R.styleable.HwDotsPageIndicator_hwBgFocusSelectedDotColor, ContextCompat.getColor(getContext(), i12));
        this.f42291A = typedArrayObtainStyledAttributes.getBoolean(C8711R.styleable.HwDotsPageIndicator_hwBgFocusEnable, false);
        typedArrayObtainStyledAttributes.recycle();
    }

    public void startAutoPlay() {
        startAutoPlay(5000);
    }

    /* renamed from: e */
    private float m54400e(float f10) {
        return getDecelerateInterpolator().getInterpolation(f10);
    }

    /* renamed from: f */
    private void m54405f() {
        if (!this.f42358x || this.mAnimator == null || this.f42293B != 0 || this.mOptions.m54506D() || this.mAnimator.m54477p() || this.mAnimator.m54473l()) {
            return;
        }
        this.mAnimator.m54482u();
        float fM54561k = this.f42307I - (this.mOptions.m54561k() - this.mOptions.m54570o());
        if (!this.f42356w) {
            com.huawei.uikit.hwdotspageindicator.widget.aauaf aauafVar = this.mOptions;
            float f10 = fM54561k / 2.0f;
            aauafVar.m54554h(aauafVar.m54570o() - f10);
            com.huawei.uikit.hwdotspageindicator.widget.aauaf aauafVar2 = this.mOptions;
            aauafVar2.m54562k(aauafVar2.m54561k() + f10);
            float fM54563l = this.mOptions.m54563l();
            float fM54568n = this.mOptions.m54568n();
            this.mOptions.m54551g(this.f42299E ? fM54568n + fM54561k : fM54568n - fM54561k);
            this.mOptions.m54547f(this.f42299E ? fM54563l - fM54561k : fM54563l + fM54561k);
            this.mOptions.m54529b(true);
            invalidate();
            return;
        }
        float f11 = fM54561k / 2.0f;
        performFocusSingleZoomInAnimation(new RectF(this.mOptions.m54568n() - fM54561k, this.mOptions.m54570o() - f11, this.mOptions.m54563l() + fM54561k, this.mOptions.m54561k() + f11), this);
        this.f42306H0 = bfscp.MOUSE_ON_DOT;
    }

    /* renamed from: e */
    private boolean m54403e(int i10) {
        HwViewPager hwViewPager = this.mViewPager;
        return m54429v() && (hwViewPager != null && hwViewPager.isSupportLoop()) && m54399d(i10);
    }

    /* renamed from: d */
    private void m54396d(int i10, float f10, int i11) {
        boolean z10 = this.f42341k0 != i10;
        if (!this.f42351t0) {
            if (z10) {
                m54402e(i10, f10, i11);
                return;
            } else {
                m54407f(i10, f10, i11);
                return;
            }
        }
        if (com.huawei.uikit.hwdotspageindicator.widget.bqmxo.m54609k()) {
            return;
        }
        if (z10) {
            m54354a(i10, f10, i11);
        } else {
            m54375b(i10, f10, i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m54401e() {
        if (this.f42347q0) {
            return;
        }
        doHotZoneInVisibleAnimation(false);
    }

    /* renamed from: b */
    private void m54374b(int i10, float f10) {
        if (this.f42293B == 0 && Float.compare(f10, 0.0f) == 0) {
            this.f42341k0 = i10;
            onPageScrollStateChanged(this.f42293B);
            return;
        }
        int distanceProper = getDistanceProper();
        if (this.f42293B == 2) {
            m54396d(i10, f10, distanceProper);
        } else {
            m54389c(i10, f10, distanceProper);
        }
        m54353a(i10, f10);
    }

    /* renamed from: d */
    private float m54393d(float f10) {
        return getAccelerateInterpolator().getInterpolation(f10);
    }

    /* renamed from: d */
    private boolean m54399d(int i10) {
        return (i10 == 0 && this.f42341k0 == this.f42340j0 - 1 && (this.f42351t0 || this.f42348r0)) || ((i10 == this.f42340j0 - 1 && this.f42341k0 == 0 && (this.f42351t0 || !this.f42348r0)) && !this.f42352u);
    }

    /* renamed from: d */
    private void m54394d() {
        HwDotsPageIndicatorAnimation hwDotsPageIndicatorAnimation = this.mAnimator;
        if (hwDotsPageIndicatorAnimation != null && hwDotsPageIndicatorAnimation.m54473l()) {
            this.mAnimator.m54481t();
            m54432y();
        }
        if (this.mOptions.m54506D()) {
            m54432y();
        }
    }

    /* renamed from: b */
    private void m54375b(int i10, float f10, int i11) {
        float fM54393d;
        int i12 = i10 + 1;
        float fM54539d = this.mOptions.m54539d(m54429v(), i12);
        com.huawei.uikit.hwdotspageindicator.widget.aauaf aauafVar = this.mOptions;
        if (this.f42299E) {
            fM54393d = fM54539d + (m54393d(1.0f - f10) * i11);
        } else {
            fM54393d = fM54539d - (m54393d(1.0f - f10) * i11);
        }
        aauafVar.m54551g(fM54393d);
        float f11 = 1.0f - f10;
        if (f11 < getMaxDiffFraction()) {
            float fM54532c = this.mOptions.m54532c(m54429v(), i12);
            this.mOptions.m54547f(this.f42299E ? fM54532c + (m54400e(f11) * i11) : fM54532c - (m54400e(f11) * i11));
            return;
        }
        float fM54563l = this.mOptions.m54563l();
        float fM54532c2 = this.mOptions.m54532c(m54429v(), i10);
        if (isSpringAnimationRunning()) {
            return;
        }
        this.f42349s0 = false;
        m54364a(false, fM54563l, fM54532c2, this.mSpringStiffness, this.mSpringDamping);
    }

    /* renamed from: d */
    private void m54395d(float f10, float f11) {
        if (!this.f42347q0) {
            doHotZoneInVisibleAnimation(false);
            return;
        }
        if (com.huawei.uikit.hwdotspageindicator.widget.bqmxo.m54597a(this.mOptions, this.f42299E, f10, f11)) {
            m54405f();
            m54388c(this.mOptions.m54504B());
            this.mOptions.m54583u(-1);
            return;
        }
        m54410g();
        int iM54592a = com.huawei.uikit.hwdotspageindicator.widget.bqmxo.m54592a(this.mOptions, this.f42307I / 2.0f, (this.f42305H + this.f42311K) / 2.0f, f10, f11);
        if (iM54592a == this.f42341k0) {
            return;
        }
        if (iM54592a == -1) {
            if (this.mOptions.m54504B() != -1) {
                m54388c(this.mOptions.m54504B());
                this.mOptions.m54583u(-1);
                return;
            }
            return;
        }
        if (iM54592a == this.mOptions.m54504B()) {
            return;
        }
        m54388c(this.mOptions.m54504B());
        this.mOptions.m54583u(-1);
        if (m54383b(iM54592a)) {
            this.mOptions.m54583u(iM54592a);
        }
    }

    /* renamed from: f */
    private void m54406f(float f10) {
        stopSpringAnimation();
        if (this.f42340j0 - 1 <= 0 || this.f42298D0.m54618d() <= 0.0f || this.f42298D0.m54616c() <= 0.0f) {
            return;
        }
        float fM54611a = f10 - this.f42298D0.m54611a();
        boolean z10 = fM54611a > 0.0f && !this.f42299E;
        boolean z11 = fM54611a < 0.0f && this.f42299E;
        float fMin = Math.min(Math.abs(fM54611a), this.f42298D0.m54616c()) / this.f42298D0.m54616c();
        HwDotsPageIndicatorInteractor.OnGestureListener onGestureListener = this.f42302F0;
        if (onGestureListener != null) {
            onGestureListener.onOverDrag(fMin);
        }
        Pair<Float, Float> pairM54595a = com.huawei.uikit.hwdotspageindicator.widget.bqmxo.m54595a(getScaleInterpolator(), fMin, this.f42340j0, getScaledWidth(), this.f42331a0);
        float fFloatValue = ((Float) pairM54595a.first).floatValue();
        float fFloatValue2 = ((Float) pairM54595a.second).floatValue();
        RectF rectF = this.f42318N0;
        float f11 = (this.f42331a0 - fFloatValue2) / 2.0f;
        m54365a(z11, z10, fFloatValue, rectF.top + f11, rectF.bottom - f11);
    }

    /* renamed from: c */
    private boolean m54392c(int i10, float f10) {
        HwDotsPageIndicatorAnimation hwDotsPageIndicatorAnimation;
        return this.f42295C && this.f42356w && this.f42308I0 != awsks.TARGET && ((hwDotsPageIndicatorAnimation = this.mAnimator) == null || !(hwDotsPageIndicatorAnimation.m54477p() || this.mAnimator.m54475n())) && i10 + 1 <= this.f42340j0 - 1 && Float.compare(f10, 0.0f) >= 0;
    }

    /* renamed from: c */
    private void m54389c(int i10, float f10, int i11) {
        if (this.f42348r0) {
            float fM54539d = this.mOptions.m54539d(m54429v(), i10);
            float fM54532c = this.mOptions.m54532c(m54429v(), i10);
            this.mOptions.m54551g(this.f42299E ? fM54539d - (m54400e(f10) * i11) : fM54539d + (m54400e(f10) * i11));
            this.mOptions.m54547f(this.f42299E ? fM54532c - (m54393d(f10) * i11) : fM54532c + (m54393d(f10) * i11));
            return;
        }
        int i12 = i10 + 1;
        float fM54539d2 = this.mOptions.m54539d(m54429v(), i12);
        float fM54532c2 = this.mOptions.m54532c(m54429v(), i12);
        this.mOptions.m54551g(this.f42299E ? fM54539d2 + (m54393d(1.0f - f10) * i11) : fM54539d2 - (m54393d(1.0f - f10) * i11));
        float f11 = 1.0f - f10;
        this.mOptions.m54547f(this.f42299E ? fM54532c2 + (m54400e(f11) * i11) : fM54532c2 - (m54400e(f11) * i11));
    }

    /* renamed from: a */
    private void m54354a(int i10, float f10, int i11) {
        float fM54532c = this.mOptions.m54532c(m54429v(), i10);
        this.mOptions.m54547f(this.f42299E ? fM54532c - (m54393d(f10) * i11) : fM54532c + (m54393d(f10) * i11));
        if (!com.huawei.uikit.hwdotspageindicator.widget.bqmxo.m54610l() && f10 >= getMaxDiffFraction()) {
            float fM54568n = this.mOptions.m54568n();
            float fM54539d = this.mOptions.m54539d(m54429v(), i10 + 1);
            if (isSpringAnimationRunning()) {
                return;
            }
            this.f42349s0 = true;
            m54364a(true, fM54568n, fM54539d, this.mSpringStiffness, this.mSpringDamping);
            return;
        }
        float fM54539d2 = this.mOptions.m54539d(m54429v(), i10);
        this.mOptions.m54551g(this.f42299E ? fM54539d2 - (m54400e(f10) * i11) : fM54539d2 + (m54400e(f10) * i11));
    }

    /* renamed from: b */
    private void m54372b() {
        this.f42337g0 = getPaddingLeft() + (((getWidth() - getPaddingRight()) - r0) / 2.0f);
        float height = getHeight();
        Paint.FontMetrics fontMetrics = this.f42296C0;
        float f10 = fontMetrics.descent;
        float f11 = fontMetrics.ascent;
        this.f42338h0 = ((height - (f10 - f11)) / 2.0f) - f11;
        m54433z();
    }

    /* renamed from: b */
    private boolean m54383b(int i10) {
        HwDotsPageIndicatorAnimation hwDotsPageIndicatorAnimation;
        boolean z10 = false;
        if (this.f42358x && (hwDotsPageIndicatorAnimation = this.mAnimator) != null && !hwDotsPageIndicatorAnimation.m54477p() && !this.mAnimator.m54475n() && !this.mAnimator.m54452a(i10)) {
            if (this.mOptions.m54504B() == i10) {
                return false;
            }
            z10 = true;
            if (!this.f42356w) {
                this.mOptions.m54514a(i10, this.f42307I / 2.0f);
                this.f42306H0 = bfscp.MOUSE_ON_DOT;
                invalidate();
                return true;
            }
            performSingleDotZoomInAnimation(i10, this.f42307I / 2.0f, this);
            this.f42306H0 = bfscp.MOUSE_ON_DOT;
        }
        return z10;
    }

    /* renamed from: c */
    private void m54385c() {
        if (this.f42295C) {
            m54349a();
        } else {
            m54372b();
        }
    }

    /* renamed from: a */
    private void m54353a(int i10, float f10) {
        float fM54511a = this.mOptions.m54511a(m54429v());
        float fM54523b = this.mOptions.m54523b(m54429v(), i10);
        if (!this.f42299E) {
            this.mOptions.m54527b(i10, fM54523b - (fM54511a * f10));
            int i11 = i10 + 1;
            if (i11 < this.f42340j0) {
                com.huawei.uikit.hwdotspageindicator.widget.aauaf aauafVar = this.mOptions;
                aauafVar.m54527b(i11, aauafVar.m54523b(m54429v(), i11) + (fM54511a * (1.0f - f10)));
            }
        } else {
            this.mOptions.m54527b(i10, fM54523b + (fM54511a * f10));
            int i12 = i10 + 1;
            if (i12 < this.f42340j0) {
                com.huawei.uikit.hwdotspageindicator.widget.aauaf aauafVar2 = this.mOptions;
                aauafVar2.m54527b(i12, aauafVar2.m54523b(m54429v(), i12) - (fM54511a * (1.0f - f10)));
            }
        }
        invalidate();
    }

    /* renamed from: c */
    private void m54387c(float f10, float f11) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (this.f42300E0 == null || !isInTouchMode()) {
            return;
        }
        RectF rectF = this.f42316M0;
        if (rectF != null && rectF.contains(f10, f11)) {
            nextPage();
            return;
        }
        RectF rectF2 = this.f42314L0;
        if (rectF2 == null || !rectF2.contains(f10, f11)) {
            return;
        }
        prePage();
    }

    /* renamed from: b */
    private boolean m54382b(float f10) {
        HwDotsPageIndicatorAnimation hwDotsPageIndicatorAnimation;
        if (this.f42340j0 <= 1 || !this.f42358x || m54429v() || ((hwDotsPageIndicatorAnimation = this.mAnimator) != null && hwDotsPageIndicatorAnimation.m54477p())) {
            return false;
        }
        bqmxo.bzrwd bzrwdVar = this.f42298D0;
        boolean z10 = this.f42299E;
        int i10 = this.f42341k0;
        return com.huawei.uikit.hwdotspageindicator.widget.bqmxo.m54600b(bzrwdVar, f10, z10, i10 > 0, i10 < this.f42340j0 - 1);
    }

    /* renamed from: b */
    private void m54377b(int i10, int i11, float f10) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (Float.compare(f10, 1.0f) >= 0) {
            m54355a(i10, i11);
            return;
        }
        m54356a(i10, i11, f10);
        m54357a(i10, i11 > i10);
        this.f42293B = 1;
        invalidate();
    }

    /* renamed from: c */
    private void m54388c(int i10) {
        HwDotsPageIndicatorAnimation hwDotsPageIndicatorAnimation;
        if (!this.f42358x || (hwDotsPageIndicatorAnimation = this.mAnimator) == null || i10 == -1 || hwDotsPageIndicatorAnimation.m54456b(i10)) {
            return;
        }
        if (!this.f42356w) {
            this.mOptions.m54567m(i10);
            invalidate();
        } else {
            performSingleDotZoomOutAnimation(i10, this, this);
            this.f42306H0 = bfscp.VISIBLE;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x000f  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m54352a(int r3) {
        /*
            r2 = this;
            com.huawei.uikit.hwdotspageindicator.widget.HwDotsPageIndicator$awsks r0 = r2.f42308I0
            com.huawei.uikit.hwdotspageindicator.widget.HwDotsPageIndicator$awsks r1 = com.huawei.uikit.hwdotspageindicator.widget.HwDotsPageIndicator.awsks.DEFAULT
            if (r0 != r1) goto Lf
            int r0 = r2.f42293B
            r1 = 1
            if (r0 == r1) goto Lf
            r0 = 2
            if (r3 != r0) goto Lf
            goto L10
        Lf:
            r1 = 0
        L10:
            r2.f42351t0 = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.uikit.hwdotspageindicator.widget.HwDotsPageIndicator.m54352a(int):void");
    }

    /* renamed from: a */
    private void m54363a(boolean z10) {
        com.huawei.uikit.hwdotspageindicator.widget.aauaf aauafVar = this.mOptions;
        if (aauafVar.m54519a(z10, this.f42341k0, aauafVar.m54544e())) {
            return;
        }
        com.huawei.uikit.hwdotspageindicator.widget.aauaf aauafVar2 = this.mOptions;
        aauafVar2.m54516a(aauafVar2.m54520a(z10, this.f42341k0));
        invalidate();
    }

    /* renamed from: b */
    private void m54380b(Canvas canvas) {
        float fM54561k = (this.mOptions.m54561k() - this.mOptions.m54570o()) / 2.0f;
        canvas.drawRoundRect(this.mOptions.m54566m(), fM54561k, fM54561k, this.f42363z0);
        m54424q();
        m54421n();
    }

    /* renamed from: c */
    private void m54386c(float f10) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (!this.f42358x || this.f42302F0 == null || this.f42298D0.m54620e() <= 0.0f) {
            return;
        }
        if (m54367a(f10)) {
            m54406f(f10);
            return;
        }
        if (!m54382b(f10)) {
            this.f42298D0.m54613a(true);
            return;
        }
        if (this.f42298D0.m54622f()) {
            this.f42298D0.m54615b(this.f42345o0);
            this.f42298D0.m54613a(false);
        }
        float fM54614b = f10 - this.f42298D0.m54614b();
        float fAbs = Math.abs(fM54614b) / this.f42298D0.m54620e();
        int i10 = ((fM54614b <= 0.0f || this.f42299E) && (fM54614b >= 0.0f || !this.f42299E)) ? this.f42341k0 - 1 : this.f42341k0 + 1;
        this.f42308I0 = awsks.SLIDE;
        int i11 = this.f42341k0;
        if (this.f42356w) {
            m54377b(i11, i10, fAbs);
        } else if (Float.compare(fAbs, 1.0f) >= 0) {
            this.f42341k0 = i10;
            this.mOptions = m54426s();
            invalidate();
            settleToTarget(i10);
        }
    }

    /* renamed from: a */
    private void m54349a() {
        HwViewPager hwViewPager = this.mViewPager;
        this.f42341k0 = hwViewPager != null ? hwViewPager.getCurrentItem() : 0;
        if (this.f42340j0 < 1) {
            return;
        }
        m54418k();
        m54425r();
        m54422o();
        m54433z();
    }

    /* renamed from: b */
    private void m54378b(int i10, boolean z10) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        HwViewPager hwViewPager = this.mViewPager;
        if (hwViewPager == null || hwViewPager.getAdapter() == null || this.mViewPager.getAdapter().getCount() < 2 || i10 < 0 || i10 >= this.f42340j0 || i10 == this.f42341k0 || isFocusAccelerateAnimationRunning()) {
            return;
        }
        this.f42308I0 = awsks.TARGET;
        this.mOptions.m54576r(this.f42341k0);
        float[] fArrM54545e = this.mOptions.m54545e(m54429v(), i10);
        float fM54539d = this.mOptions.m54539d(m54429v(), i10);
        float fM54532c = this.mOptions.m54532c(m54429v(), i10);
        if (!this.f42356w) {
            this.mOptions.m54551g(fM54539d);
            this.mOptions.m54547f(fM54532c);
            m54366a(fArrM54545e);
            this.mViewPager.setCurrentItem(i10, false);
            HwDotsPageIndicatorInteractor.OnMouseOperationListener onMouseOperationListener = this.f42304G0;
            if (onMouseOperationListener != null) {
                onMouseOperationListener.onFocusAnimationProgress(1.0f);
                return;
            }
            return;
        }
        stopSpringAnimation();
        com.huawei.uikit.hwdotspageindicator.widget.aauaf aauafVarM54533c = this.mOptions.m54533c();
        aauafVarM54533c.m54576r(i10);
        aauafVarM54533c.m54551g(fM54539d);
        aauafVarM54533c.m54547f(fM54532c);
        boolean z11 = aauafVarM54533c.m54586x() > this.mOptions.m54586x();
        float fM54563l = z11 ? this.mOptions.m54563l() : this.mOptions.m54568n();
        float fM54563l2 = z11 ? aauafVarM54533c.m54563l() : aauafVarM54533c.m54568n();
        m54358a(i10, z11, z11 ? this.mOptions.m54568n() : this.mOptions.m54563l(), z11 ? aauafVarM54533c.m54568n() : aauafVarM54533c.m54563l(), z10);
        m54373b(fM54563l, fM54563l2);
        this.f42349s0 = aauafVarM54533c.m54586x() > this.mOptions.m54586x();
        m54366a(fArrM54545e);
        this.mViewPager.setCurrentItem(i10);
    }

    /* renamed from: a */
    private boolean m54370a(boolean z10, boolean z11) {
        boolean z12 = this.f42353u0 && this.f42355v0;
        boolean z13 = z10 && z11;
        return (z12 && !z13) || (!z12 && z13);
    }

    /* renamed from: a */
    private boolean m54368a(int i10, float f10, float f11) {
        if (this.f42354v || !this.f42358x || this.f42304G0 == null || this.f42360y || this.mOptions.m54580t() == null || !this.f42295C || this.f42340j0 == 0) {
            return false;
        }
        boolean zIsFocusAccelerateAnimationRunning = isFocusAccelerateAnimationRunning();
        if (i10 == 10 && !zIsFocusAccelerateAnimationRunning) {
            if (this.f42312K0 == null) {
                this.f42312K0 = new aayti(this, null);
            }
            postDelayed(this.f42312K0, f42289a1);
        }
        this.f42347q0 = this.mOptions.m54580t().contains(f10, f11);
        return !zIsFocusAccelerateAnimationRunning;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m54364a(boolean z10, float f10, float f11, float f12, float f13) {
        performSpringAnimation(new bzrwd.akxao(z10, f10, f11, f12, f13), this);
    }

    /* renamed from: a */
    private void m54366a(float[] fArr) {
        if (!this.f42356w) {
            this.mOptions.m54516a(fArr);
            invalidate();
        } else {
            performDotCenterXsLayoutAnimation(fArr, this);
        }
    }

    /* renamed from: c */
    private void m54391c(Canvas canvas) {
        if (this.f42343m0 == null || this.f42292A0 == null) {
            return;
        }
        if (isFocusConfirm() && this.f42360y) {
            this.f42292A0.setColor(this.f42333c0);
        } else {
            this.f42292A0.setColor(this.f42332b0);
        }
        canvas.drawText(this.f42343m0, this.f42337g0, this.f42338h0, this.f42292A0);
    }

    /* renamed from: a */
    private void m54350a(float f10, float f11) {
        performFocusAccelerateAnimation(f10, f11, this);
    }

    /* renamed from: a */
    private boolean m54367a(float f10) {
        HwDotsPageIndicatorAnimation hwDotsPageIndicatorAnimation;
        if (this.f42340j0 <= 1 || !this.f42358x || !this.f42356w || m54429v() || ((hwDotsPageIndicatorAnimation = this.mAnimator) != null && (hwDotsPageIndicatorAnimation.m54477p() || isFocusAccelerateAnimationRunning()))) {
            return false;
        }
        bqmxo.bzrwd bzrwdVar = this.f42298D0;
        boolean z10 = this.f42299E;
        int i10 = this.f42341k0;
        return com.huawei.uikit.hwdotspageindicator.widget.bqmxo.m54598a(bzrwdVar, f10, z10, i10 == 0, i10 == this.f42340j0 - 1);
    }

    /* renamed from: a */
    private void m54357a(int i10, boolean z10) {
        this.mOptions.m54527b(i10, z10 ? this.mOptions.m54531c(i10) : this.mOptions.m54521b(i10));
    }

    /* renamed from: a */
    private void m54356a(int i10, int i11, float f10) {
        if (i10 == i11 || i11 > this.f42340j0 - 1 || i11 < 0) {
            return;
        }
        boolean z10 = i11 > i10;
        m54351a(f10, 1, i10);
        float interpolation = getAccelerateInterpolator().getInterpolation(f10);
        float interpolation2 = getDecelerateInterpolator().getInterpolation(f10);
        stopSpringAnimation();
        float fM54532c = this.mOptions.m54532c(m54429v(), i10);
        float fM54532c2 = this.mOptions.m54532c(m54429v(), i11);
        float fM54539d = this.mOptions.m54539d(m54429v(), i10);
        float fM54539d2 = fM54539d + ((this.mOptions.m54539d(m54429v(), i11) - fM54539d) * (z10 ? interpolation2 : interpolation));
        float f11 = fM54532c2 - fM54532c;
        if (!z10) {
            interpolation = interpolation2;
        }
        this.mOptions.m54551g(fM54539d2);
        this.mOptions.m54547f(fM54532c + (f11 * interpolation));
    }

    /* renamed from: b */
    private void m54373b(float f10, float f11) {
        performTargetAccelerateAnimation(f10, f11, this, new blfhz());
    }

    /* renamed from: b */
    private void m54376b(int i10, int i11) {
        HwDotsPageIndicatorInteractor.OnClickListener onClickListener = this.f42300E0;
        if (onClickListener != null) {
            onClickListener.onClick(i10, i11);
        }
    }

    /* renamed from: b */
    private void m54381b(boolean z10) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (isFocusAccelerateAnimationRunning()) {
            return;
        }
        stopSpringAnimation();
        this.f42308I0 = awsks.TARGET;
        int i10 = z10 ? this.f42341k0 + 1 : this.f42341k0 - 1;
        float fM54539d = this.mOptions.m54539d(m54429v(), i10);
        float fM54532c = this.mOptions.m54532c(m54429v(), i10);
        com.huawei.uikit.hwdotspageindicator.widget.aauaf aauafVarM54533c = this.mOptions.m54533c();
        aauafVarM54533c.m54551g(fM54539d);
        aauafVarM54533c.m54547f(fM54532c);
        int iM54586x = this.mOptions.m54586x();
        aauafVarM54533c.m54576r(z10 ? iM54586x + 1 : iM54586x - 1);
        float maxDiffFraction = getMaxDiffFraction();
        this.f42349s0 = aauafVarM54533c.m54586x() > iM54586x;
        m54350a(z10 ? this.mOptions.m54563l() : this.mOptions.m54568n(), z10 ? aauafVarM54533c.m54563l() : aauafVarM54533c.m54568n());
        performTargetDecelerateAnimation(z10 ? this.mOptions.m54568n() : this.mOptions.m54563l(), z10 ? aauafVarM54533c.m54568n() : aauafVarM54533c.m54563l(), this, new brnby(maxDiffFraction, z10, fM54539d, fM54532c));
        this.f42341k0 = i10;
        m54366a(this.mOptions.m54545e(m54429v(), this.f42341k0));
        if (z10) {
            this.mViewPager.nextPage();
        } else {
            this.mViewPager.prePage();
        }
    }

    /* renamed from: a */
    private void m54355a(int i10, int i11) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        float fM54553h = this.mOptions.m54553h(i11);
        this.mOptions.m54551g(this.mOptions.m54555i(i11));
        this.mOptions.m54547f(fM54553h);
        boolean z10 = i11 > i10;
        float fM54531c = this.mOptions.m54531c(i10);
        float fM54521b = this.mOptions.m54521b(i10);
        float fM54509a = this.mOptions.m54509a(i11);
        if (!z10) {
            fM54531c = fM54521b;
        }
        this.mOptions.m54527b(i10, fM54531c);
        this.mOptions.m54527b(i11, fM54509a);
        invalidate();
        settleToTarget(i11);
    }

    /* renamed from: a */
    private void m54365a(boolean z10, boolean z11, float f10, float f11, float f12) {
        float f13;
        float f14;
        float f15;
        float f16;
        int i10;
        int i11 = this.f42305H;
        int i12 = this.f42340j0;
        int i13 = i12 - 1;
        float f17 = (((f10 - (this.f42334d0 * 2.0f)) - this.f42328U) - (i11 * i13)) / i13;
        float[] fArr = new float[i12];
        boolean z12 = this.f42299E;
        int i14 = 0;
        boolean z13 = z12 && z10;
        boolean z14 = z12 && !z10;
        boolean z15 = (z12 || z11) ? false : true;
        if (!z13 && !z15) {
            f15 = this.f42318N0.left;
            f14 = f15 + f10;
            while (true) {
                i10 = this.f42340j0;
                if (i14 >= i10) {
                    break;
                }
                int i15 = this.f42299E ? (i10 - 1) - i14 : i14;
                fArr[i15] = this.f42334d0 + f15 + (i14 * f17) + (this.f42305H / 2.0f) + (r11 * i14);
                i14++;
            }
            if (z14) {
                f16 = fArr[1] + (this.f42305H / 2.0f) + f17;
                f13 = this.f42328U + f16;
            } else {
                f13 = f17 + fArr[i10 - 2] + (this.f42305H / 2.0f);
                f16 = f13 + this.f42328U;
            }
        } else {
            float f18 = this.f42318N0.right;
            float f19 = f18 - f10;
            while (i13 >= 0) {
                int i16 = (this.f42340j0 - 1) - i13;
                int i17 = this.f42299E ? i16 : i13;
                fArr[i17] = (((f18 - this.f42334d0) - (i16 * f17)) - (this.f42305H / 2.0f)) - (i16 * r12);
                i13--;
            }
            if (z13) {
                float f20 = this.f42334d0 + f19;
                f14 = f18;
                f15 = f19;
                f16 = f20;
                f13 = this.f42328U + f20;
            } else {
                f13 = this.f42334d0 + f19;
                f14 = f18;
                f15 = f19;
                f16 = this.f42328U + f13;
            }
        }
        this.mOptions.m54526b(f15, f11, f14, f12);
        this.mOptions.m54516a(fArr);
        this.mOptions.m54551g(f13);
        this.mOptions.m54547f(f16);
        invalidate();
    }

    /* renamed from: a */
    private void m54360a(Canvas canvas) {
        Paint paint;
        ConcurrentHashMap<Integer, Float> concurrentHashMapM54505C = this.mOptions.m54505C();
        float[] fArrM54544e = this.mOptions.m54544e();
        for (int i10 = 0; i10 < this.f42340j0; i10++) {
            float fM54549g = this.mOptions.m54549g();
            if (concurrentHashMapM54505C != null && concurrentHashMapM54505C.get(Integer.valueOf(i10)) != null && i10 != this.f42341k0) {
                fM54549g = concurrentHashMapM54505C.get(Integer.valueOf(i10)).floatValue();
            }
            if (fArrM54544e != null && i10 < fArrM54544e.length && (paint = this.f42361y0) != null) {
                canvas.drawCircle(fArrM54544e[i10], this.f42329V, fM54549g, paint);
            }
        }
    }

    /* renamed from: a */
    private void m54358a(int i10, boolean z10, float f10, float f11, boolean z11) {
        performTargetDecelerateAnimation(f10, f11, this, new avpbg(getMaxDiffFraction(), z10, Math.abs(i10 - this.f42341k0), f11, new akxao(z11)));
    }

    /* renamed from: a */
    private void m54351a(float f10, int i10, int i11) {
        HwDotsPageIndicatorInteractor.OnGestureListener onGestureListener = this.f42302F0;
        if (onGestureListener != null) {
            onGestureListener.onDragging(f10, i10, i11);
        }
    }
}
