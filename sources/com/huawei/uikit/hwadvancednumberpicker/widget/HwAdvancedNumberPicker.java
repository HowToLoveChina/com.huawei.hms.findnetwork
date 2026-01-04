package com.huawei.uikit.hwadvancednumberpicker.widget;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.SoundPool;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.Scroller;
import android.widget.TextView;
import com.huawei.hiar.ARImageMetadata;
import com.huawei.uikit.hwadvancednumberpicker.C8692R;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwCommonHandler;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwFormatter;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwUtils;
import com.huawei.uikit.hwadvancednumberpicker.widget.PickerHelper;
import com.huawei.uikit.hwclickanimation.anim.HwSpringBackHelper;
import com.huawei.uikit.hwcommon.anim.HwCubicBezierInterpolator;
import com.huawei.uikit.hwcommon.utils.HwVibrateUtil;
import com.huawei.uikit.hwresources.utils.HwWidgetCompat;
import com.huawei.uikit.hwunifiedinteract.widget.HwGenericEventDetector;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p506o1.C11787b;

/* loaded from: classes7.dex */
public class HwAdvancedNumberPicker extends FrameLayout implements HwCommonHandler.MessageHandler {
    public static final int AM_TO_PM = 4;
    public static final int DATE_TO_DATE = 2;
    public static final int DATE_TO_NORMAL = 5;
    public static final float MAX_OFFSET = 20.0f;
    public static final float MIN_OFFSET = 10.0f;
    public static final int MONTH_TO_MONTH = 1;
    public static final int NORMAL_TO_DATE = 6;
    public static final int NORMAL_TO_NORMAL = 3;

    /* renamed from: O1 */
    private static final double f41059O1 = 156.0d;

    /* renamed from: P1 */
    private static final double f41060P1 = 0.15875d;

    /* renamed from: Q1 */
    private static final double f41061Q1 = 0.073892d;

    /* renamed from: R1 */
    private static final double f41062R1 = 77.982184d;

    /* renamed from: S1 */
    private static final double f41063S1 = 6.0E-4d;
    public static final int SEND_INTERVAL = 2;

    /* renamed from: T1 */
    private static final double f41064T1 = 0.6d;

    /* renamed from: U1 */
    private static final String f41065U1 = "accessibility_screenreader_enabled";

    /* renamed from: A */
    private final boolean f41066A;

    /* renamed from: A0 */
    private AccessibilityManager.AccessibilityStateChangeListener f41067A0;

    /* renamed from: A1 */
    private boolean f41068A1;

    /* renamed from: B */
    private String[] f41069B;

    /* renamed from: B0 */
    private int f41070B0;

    /* renamed from: B1 */
    private boolean f41071B1;

    /* renamed from: C */
    private OnValueChangeListener f41072C;

    /* renamed from: C0 */
    private Scroller f41073C0;

    /* renamed from: C1 */
    private long f41074C1;

    /* renamed from: D */
    private OnScrollListener f41075D;

    /* renamed from: D0 */
    private boolean f41076D0;

    /* renamed from: D1 */
    private long f41077D1;

    /* renamed from: E */
    private HwFormatter f41078E;

    /* renamed from: E0 */
    private boolean f41079E0;

    /* renamed from: E1 */
    private long f41080E1;

    /* renamed from: F */
    private long f41081F;

    /* renamed from: F0 */
    private boolean f41082F0;

    /* renamed from: F1 */
    private int f41083F1;

    /* renamed from: G */
    private final SparseArray<String> f41084G;

    /* renamed from: G0 */
    private boolean f41085G0;

    /* renamed from: G1 */
    private long f41086G1;

    /* renamed from: H */
    private Paint f41087H;

    /* renamed from: H0 */
    private String f41088H0;

    /* renamed from: H1 */
    private boolean f41089H1;

    /* renamed from: I */
    private Paint f41090I;

    /* renamed from: I0 */
    private String f41091I0;

    /* renamed from: I1 */
    private boolean f41092I1;

    /* renamed from: J */
    private final HwSpringBackHelper f41093J;

    /* renamed from: J0 */
    private String f41094J0;

    /* renamed from: J1 */
    private boolean f41095J1;

    /* renamed from: K */
    private final HwSpringBackHelper f41096K;

    /* renamed from: K0 */
    private String f41097K0;

    /* renamed from: K1 */
    private boolean f41098K1;

    /* renamed from: L */
    private int f41099L;

    /* renamed from: L0 */
    private int f41100L0;

    /* renamed from: L1 */
    private boolean f41101L1;

    /* renamed from: M */
    private avpbg f41102M;

    /* renamed from: M0 */
    private int f41103M0;

    /* renamed from: M1 */
    private boolean f41104M1;

    /* renamed from: N */
    private final AnimatorSet f41105N;

    /* renamed from: N0 */
    private int f41106N0;

    /* renamed from: N1 */
    private boolean f41107N1;

    /* renamed from: O */
    private float f41108O;

    /* renamed from: O0 */
    private double f41109O0;

    /* renamed from: P */
    private float f41110P;

    /* renamed from: P0 */
    private HwGenericEventDetector f41111P0;

    /* renamed from: Q */
    private boolean f41112Q;

    /* renamed from: Q0 */
    private boolean f41113Q0;

    /* renamed from: R */
    private boolean f41114R;

    /* renamed from: R0 */
    private ThreadPoolExecutor f41115R0;

    /* renamed from: S */
    private VelocityTracker f41116S;

    /* renamed from: S0 */
    private ThreadPoolExecutor f41117S0;

    /* renamed from: T */
    private boolean f41118T;

    /* renamed from: T0 */
    private boolean f41119T0;

    /* renamed from: U */
    private boolean f41120U;

    /* renamed from: U0 */
    private blfhz f41121U0;

    /* renamed from: V */
    private int f41122V;

    /* renamed from: V0 */
    private boolean f41123V0;

    /* renamed from: W */
    private int f41124W;

    /* renamed from: W0 */
    private View f41125W0;

    /* renamed from: X0 */
    private View f41126X0;

    /* renamed from: Y0 */
    private View f41127Y0;

    /* renamed from: Z0 */
    private String f41128Z0;

    /* renamed from: a */
    private int f41129a;

    /* renamed from: a0 */
    private int f41130a0;

    /* renamed from: a1 */
    private float f41131a1;

    /* renamed from: b */
    private final Object f41132b;

    /* renamed from: b0 */
    private boolean f41133b0;

    /* renamed from: b1 */
    private boolean f41134b1;

    /* renamed from: c */
    private long f41135c;

    /* renamed from: c0 */
    private int f41136c0;

    /* renamed from: c1 */
    private int f41137c1;

    /* renamed from: d */
    private long f41138d;

    /* renamed from: d0 */
    private float f41139d0;

    /* renamed from: d1 */
    private bxac f41140d1;

    /* renamed from: e */
    private float f41141e;

    /* renamed from: e0 */
    private boolean f41142e0;

    /* renamed from: e1 */
    private brnby f41143e1;

    /* renamed from: f */
    private float f41144f;

    /* renamed from: f0 */
    private int f41145f0;

    /* renamed from: f1 */
    private int f41146f1;

    /* renamed from: g */
    private float f41147g;

    /* renamed from: g0 */
    private boolean f41148g0;

    /* renamed from: g1 */
    private int f41149g1;

    /* renamed from: h */
    private float f41150h;

    /* renamed from: h0 */
    private boolean f41151h0;

    /* renamed from: h1 */
    private AccessibilityManager f41152h1;

    /* renamed from: i */
    private int f41153i;

    /* renamed from: i0 */
    private boolean f41154i0;

    /* renamed from: i1 */
    private float f41155i1;

    /* renamed from: j */
    private TextView f41156j;

    /* renamed from: j0 */
    private boolean f41157j0;

    /* renamed from: j1 */
    private boolean f41158j1;

    /* renamed from: k */
    private final int f41159k;

    /* renamed from: k0 */
    private boolean f41160k0;

    /* renamed from: k1 */
    private boolean f41161k1;

    /* renamed from: l */
    private int f41162l;

    /* renamed from: l0 */
    private boolean f41163l0;

    /* renamed from: l1 */
    private HashMap<Integer, String> f41164l1;

    /* renamed from: m */
    private final int f41165m;

    /* renamed from: m0 */
    private int f41166m0;

    /* renamed from: m1 */
    private float f41167m1;
    protected Context mContext;
    protected int mCurrentScrollOffset;
    protected int mInitialScrollOffset;
    protected boolean mIsSoundLoadFinished;
    protected int mMaximumFlingVelocity;
    protected int mMinimumFlingVelocity;
    protected int mPickerSelectedTextMinSize;
    protected int mPickerUnSelectedTextMinSize;
    protected int mSelectedFocusedTextColor;
    protected float mSelectedTextSize;
    protected int mSelectedUnfocusedTextColor;
    protected int mSelectorElementHeight;
    protected int mSelectorTextGapHeight;
    protected int mSoundId;
    protected float mTextSizeBlackEdge;
    protected float mTextSizeBlackSmall;
    protected float mUnselectedTextSize;

    /* renamed from: n */
    private int f41168n;

    /* renamed from: n0 */
    private Drawable f41169n0;

    /* renamed from: n1 */
    private akxao f41170n1;

    /* renamed from: o */
    private int f41171o;

    /* renamed from: o0 */
    private int f41172o0;

    /* renamed from: o1 */
    private HwPickerScrollListener f41173o1;

    /* renamed from: p */
    private int f41174p;

    /* renamed from: p0 */
    private int f41175p0;

    /* renamed from: p1 */
    private int f41176p1;

    /* renamed from: q */
    private int f41177q;

    /* renamed from: q0 */
    private int f41178q0;

    /* renamed from: q1 */
    private boolean f41179q1;

    /* renamed from: r */
    private int f41180r;

    /* renamed from: r0 */
    private int f41181r0;

    /* renamed from: r1 */
    private boolean f41182r1;

    /* renamed from: s */
    private int f41183s;

    /* renamed from: s0 */
    private float f41184s0;

    /* renamed from: s1 */
    private boolean f41185s1;

    /* renamed from: t */
    private int f41186t;

    /* renamed from: t0 */
    private int f41187t0;

    /* renamed from: t1 */
    private int f41188t1;

    /* renamed from: u */
    private int f41189u;

    /* renamed from: u0 */
    private int f41190u0;

    /* renamed from: u1 */
    private double f41191u1;

    /* renamed from: v */
    private int f41192v;

    /* renamed from: v0 */
    private int f41193v0;

    /* renamed from: v1 */
    private final String f41194v1;

    /* renamed from: w */
    private float f41195w;

    /* renamed from: w0 */
    private int[] f41196w0;

    /* renamed from: w1 */
    private ScheduledThreadPoolExecutor f41197w1;

    /* renamed from: x */
    private SoundPool f41198x;

    /* renamed from: x0 */
    private boolean f41199x0;

    /* renamed from: x1 */
    private ScheduledFuture<?> f41200x1;

    /* renamed from: y */
    private boolean f41201y;

    /* renamed from: y0 */
    private OnColorChangeListener f41202y0;

    /* renamed from: y1 */
    private boolean f41203y1;

    /* renamed from: z */
    private String f41204z;

    /* renamed from: z0 */
    private final Handler f41205z0;

    /* renamed from: z1 */
    private String f41206z1;

    public interface OnColorChangeListener {
        void onColorChange(HwAdvancedNumberPicker hwAdvancedNumberPicker);
    }

    public interface OnScrollListener {
        public static final int SCROLL_STATE_FLING = 2;
        public static final int SCROLL_STATE_IDLE = 0;
        public static final int SCROLL_STATE_TOUCH_SCROLL = 1;

        void onScrollStateChange(HwAdvancedNumberPicker hwAdvancedNumberPicker, int i10);
    }

    public interface OnValueChangeListener {
        void onValueChange(HwAdvancedNumberPicker hwAdvancedNumberPicker, int i10, int i11);
    }

    public class aauaf implements Runnable {
        public aauaf() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HwAdvancedNumberPicker hwAdvancedNumberPicker = HwAdvancedNumberPicker.this;
            hwAdvancedNumberPicker.m53844d(hwAdvancedNumberPicker.f41196w0);
            HwAdvancedNumberPicker hwAdvancedNumberPicker2 = HwAdvancedNumberPicker.this;
            hwAdvancedNumberPicker2.m53847e(hwAdvancedNumberPicker2.f41196w0);
            HwAdvancedNumberPicker.this.f41101L1 = false;
        }
    }

    public class akxao implements Runnable {

        /* renamed from: a */
        private int f41208a;

        public akxao(int i10) {
            this.f41208a = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!PickerHelper.isFinishedScroller(HwAdvancedNumberPicker.this.f41093J, HwAdvancedNumberPicker.this.f41096K, HwAdvancedNumberPicker.this.f41073C0)) {
                HwAdvancedNumberPicker.this.m53837c(100, this.f41208a);
            } else {
                if (this.f41208a == 1) {
                    HwAdvancedNumberPicker.this.m53823b();
                    return;
                }
                HwAdvancedNumberPicker hwAdvancedNumberPicker = HwAdvancedNumberPicker.this;
                hwAdvancedNumberPicker.mCurrentScrollOffset = hwAdvancedNumberPicker.mInitialScrollOffset;
                hwAdvancedNumberPicker.invalidate();
            }
        }
    }

    public class avpbg implements Runnable {
        public avpbg() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HwAdvancedNumberPicker.this.f41099L = 0;
            HwAdvancedNumberPicker hwAdvancedNumberPicker = HwAdvancedNumberPicker.this;
            int i10 = hwAdvancedNumberPicker.mInitialScrollOffset;
            int i11 = hwAdvancedNumberPicker.mCurrentScrollOffset;
            if (i10 == i11) {
                hwAdvancedNumberPicker.m53902G();
                HwAdvancedNumberPicker.this.invalidate();
                return;
            }
            int i12 = i10 - i11;
            if (Math.abs(i12) > HwAdvancedNumberPicker.this.f41129a) {
                i12 += i12 > 0 ? -HwAdvancedNumberPicker.this.mSelectorElementHeight : HwAdvancedNumberPicker.this.mSelectorElementHeight;
            }
            HwAdvancedNumberPicker.this.f41109O0 = 1.0d;
            PickerHelper.adjustClickAccuracy(HwAdvancedNumberPicker.this.f41096K, i12);
            HwAdvancedNumberPicker.this.invalidate();
        }
    }

    public class blfhz implements Runnable {

        /* renamed from: a */
        private boolean f41214a;

        public /* synthetic */ blfhz(HwAdvancedNumberPicker hwAdvancedNumberPicker, boolean z10, bzrwd bzrwdVar) {
            this(z10);
        }

        @Override // java.lang.Runnable
        public void run() {
            HwAdvancedNumberPicker hwAdvancedNumberPicker = HwAdvancedNumberPicker.this;
            PickerHelper.sendAccessibilityAnnounceEvent(hwAdvancedNumberPicker, hwAdvancedNumberPicker.f41152h1, HwAdvancedNumberPicker.this.f41142e0);
            if (this.f41214a) {
                HwAdvancedNumberPicker.this.postDelayed(this, 100L);
            } else {
                HwAdvancedNumberPicker.this.removeCallbacks(this);
            }
        }

        private blfhz(boolean z10) {
            this.f41214a = z10;
        }

        /* renamed from: a */
        public void m53910a(boolean z10) {
            this.f41214a = z10;
        }
    }

    public class bqmxo implements Runnable {
        public bqmxo() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (HwAdvancedNumberPicker.this.f41117S0 != null) {
                HwAdvancedNumberPicker.this.f41117S0.execute(HwAdvancedNumberPicker.this.f41143e1);
            }
        }
    }

    public class brnby implements Runnable {
        private brnby() {
        }

        @Override // java.lang.Runnable
        public void run() {
            long jRound = Math.round((HwAdvancedNumberPicker.this.f41191u1 * HwAdvancedNumberPicker.f41061Q1) + HwAdvancedNumberPicker.f41062R1);
            if (jRound > 100 && jRound < 2147483647L) {
                jRound = 100;
            }
            HwAdvancedNumberPicker hwAdvancedNumberPicker = HwAdvancedNumberPicker.this;
            hwAdvancedNumberPicker.vibrate(hwAdvancedNumberPicker, jRound);
            synchronized (HwAdvancedNumberPicker.this.f41132b) {
                HwAdvancedNumberPicker.this.m53889u();
            }
        }

        public /* synthetic */ brnby(HwAdvancedNumberPicker hwAdvancedNumberPicker, bzrwd bzrwdVar) {
            this();
        }
    }

    public class bxac implements Runnable {

        /* renamed from: a */
        private int f41218a;

        /* renamed from: b */
        private View f41219b;

        public /* synthetic */ bxac(HwAdvancedNumberPicker hwAdvancedNumberPicker, int i10, View view, bzrwd bzrwdVar) {
            this(i10, view);
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (HwAdvancedNumberPicker.this.f41132b) {
                HwAdvancedNumberPicker.this.m53889u();
            }
            HwAdvancedNumberPicker.this.vibrate(this.f41219b, this.f41218a);
        }

        private bxac(int i10, View view) {
            this.f41218a = i10;
            this.f41219b = view;
        }
    }

    public class bzrwd extends View.AccessibilityDelegate {
        public bzrwd() {
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            if (accessibilityNodeInfo == null) {
                return;
            }
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            PickerHelper.removeClickNodeInfo(accessibilityNodeInfo);
        }
    }

    public HwAdvancedNumberPicker(Context context) {
        this(context, null);
    }

    /* renamed from: A */
    private void m53788A() {
        blfhz blfhzVar = this.f41121U0;
        if (blfhzVar == null || this.f41145f0 == 1) {
            return;
        }
        blfhzVar.m53910a(false);
    }

    /* renamed from: B */
    private void m53789B() {
        this.f41119T0 = true;
        blfhz blfhzVar = this.f41121U0;
        if (blfhzVar == null) {
            this.f41121U0 = new blfhz(this, true, null);
        } else {
            blfhzVar.m53910a(false);
        }
    }

    /* renamed from: D */
    private void m53790D() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.f41197w1;
        if (scheduledThreadPoolExecutor == null || scheduledThreadPoolExecutor.isShutdown()) {
            return;
        }
        this.f41200x1 = this.f41197w1.scheduleAtFixedRate(new Runnable() { // from class: com.huawei.uikit.hwadvancednumberpicker.widget.g
            @Override // java.lang.Runnable
            public final void run() {
                this.f41260a.m53882q();
            }
        }, 0L, 2L, TimeUnit.MILLISECONDS);
    }

    /* renamed from: E */
    private boolean m53791E() {
        return m53840c((MotionEvent) null);
    }

    /* renamed from: F */
    private void m53792F() throws Resources.NotFoundException {
        this.mUnselectedTextSize = getResources().getDimension(C8692R.dimen.hwadvancednumberpicker_textSizeSubTitle2);
        this.mTextSizeBlackSmall = getResources().getDimension(C8692R.dimen.hwadvancednumberpicker_textSizeSubTitle3);
        this.mTextSizeBlackEdge = getResources().getDimension(C8692R.dimen.hwadvancednumberpicker_textSizeSubTitle4);
        this.mSelectedTextSize = getResources().getDimension(C8692R.dimen.hwadvancednumberpicker_textSizeHeadline8);
        int i10 = (int) (getResources().getConfiguration().fontScale * 100.0f);
        float dimension = getResources().getDimension(C8692R.dimen.hwadvancednumberpicker_padding_3dp);
        float dimension2 = getResources().getDimension(C8692R.dimen.hwadvancednumberpicker_padding_xs);
        if (i10 == 115) {
            m53801a(dimension2);
        }
        if (i10 == 130) {
            m53801a(dimension);
        }
        if (HwUtils.isLanguageInMy(this.mContext)) {
            m53801a(dimension);
            if (!DateFormat.is24HourFormat(this.mContext)) {
                m53801a(dimension2);
            }
        }
        this.f41131a1 = this.mSelectedTextSize;
    }

    public static HwAdvancedNumberPicker instantiate(Context context) {
        return PickerHelper.instantiateObject(context);
    }

    /* renamed from: s */
    private void m53885s() {
        if (this.f41116S == null) {
            this.f41116S = VelocityTracker.obtain();
        }
    }

    private void setSelectorWheelState(int i10) {
        this.f41180r = i10;
        AccessibilityManager accessibilityManager = this.f41152h1;
        if (accessibilityManager != null && this.f41142e0 && i10 == 2 && accessibilityManager.isEnabled()) {
            this.f41152h1.interrupt();
            this.f41156j.setContentDescription(this.f41128Z0);
            this.f41156j.sendAccessibilityEvent(16384);
            this.f41156j.setContentDescription(null);
        }
    }

    /* renamed from: C */
    public void m53901C() {
        avpbg avpbgVar = this.f41102M;
        if (avpbgVar != null) {
            removeCallbacks(avpbgVar);
        }
    }

    /* renamed from: G */
    public void m53902G() {
        int i10;
        String[] strArr = this.f41069B;
        if (strArr == null || strArr.length == 0 || ((i10 = this.f41177q) >= 0 && i10 < this.f41171o)) {
            this.f41156j.setText(PickerHelper.formatValue(this.f41177q, this.f41078E));
        } else {
            this.f41156j.setText(strArr[(i10 - this.f41171o) % strArr.length]);
        }
    }

    public void addEndDescription(String str, boolean z10) {
        this.f41204z = str;
        this.f41201y = z10;
    }

    public float adjustCoordinateY(int i10, float f10, float f11) {
        int i11 = this.mInitialScrollOffset;
        float f12 = f11 - i11;
        float f13 = i11 + (this.mSelectorElementHeight * i10);
        int i12 = this.f41153i;
        float f14 = 1.0f;
        float f15 = i10 < i12 ? -1.0f : 1.0f;
        if (this.f41186t == 5) {
            if (i10 == i12) {
                return f10;
            }
            return PickerHelper.getOffsetCoordinateY(f13, f15, f12, (i10 == 1 || i10 == 3) ? 10.0f : 5.0f, this.f41195w);
        }
        if (i10 == i12) {
            return f10;
        }
        if (i10 == 2 || i10 == 4) {
            f14 = 6.0f;
        } else if (i10 != 1 && i10 != 5) {
            f14 = -4.0f;
        }
        return PickerHelper.getOffsetCoordinateY(f13, f15, f12, f14, this.f41195w);
    }

    public void changeCurrent(int i10) {
        if (this.f41177q == i10) {
            return;
        }
        int iM53845e = m53845e(i10);
        int i11 = this.f41177q;
        setValue(iM53845e);
        m53826b(i11, iM53845e);
    }

    public void changeCurrentRichTap(int i10) {
        changeCurrent(i10);
        if (!this.f41098K1 && !this.f41071B1) {
            this.f41083F1++;
        }
        if (this.f41071B1) {
            m53852g();
        }
    }

    public HwGenericEventDetector createGenericEventDetector() {
        return new HwGenericEventDetector(getContext());
    }

    public HwGenericEventDetector.OnScrollListener createOnScrollListener() {
        return new HwGenericEventDetector.OnScrollListener() { // from class: com.huawei.uikit.hwadvancednumberpicker.widget.d
            @Override // com.huawei.uikit.hwunifiedinteract.widget.HwGenericEventDetector.OnScrollListener
            public final boolean onScrollBy(float f10, float f11, MotionEvent motionEvent) {
                return this.f41257a.m53818a(f10, f11, motionEvent);
            }
        };
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent == null) {
            Log.w(PickerHelper.TAG, "dispatchKeyEvent : event is null");
            return false;
        }
        if (!isPickerScrollCenter() && this.f41093J.isFinished() && this.f41096K.isFinished()) {
            m53823b();
        }
        if (!PickerHelper.dispatchKeyEvent(keyEvent, this, this.f41102M)) {
            return super.dispatchKeyEvent(keyEvent);
        }
        m53856h(100);
        return true;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return PickerHelper.populateAccessibilityEvent(this, accessibilityEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent == null) {
            Log.w(PickerHelper.TAG, "dispatchTouchEvent : event is null");
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1) {
            PickerHelper.removeAllCallbacks(this, this.f41102M);
        } else if (actionMasked != 2) {
            if (actionMasked == 3) {
                PickerHelper.removeAllCallbacks(this, this.f41102M);
                onCancel();
            } else if (actionMasked == 5) {
                requestDisallowInterceptTouchEvent(true);
            } else if (actionMasked == 6) {
                requestDisallowInterceptTouchEvent(false);
            }
        } else if (this.f41180r == 2) {
            PickerHelper.removeAllCallbacks(this, this.f41102M);
            forceCompleteChangeCurrentByOneViaScroll();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        if (motionEvent == null) {
            Log.w(PickerHelper.TAG, "dispatchTrackballEvent : event is null");
            return false;
        }
        PickerHelper.dispatchTrackballEvent(motionEvent, this);
        return super.dispatchTrackballEvent(motionEvent);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        PickerHelper.computeScroller(this);
        if (this.f41105N.isRunning() || this.f41180r != 2) {
            long drawingTime = getDrawingTime();
            int childCount = getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                if (getChildAt(i10).isShown()) {
                    drawChild(canvas, getChildAt(i10), drawingTime);
                }
            }
        }
    }

    public void fling(int i10) {
        int i11;
        this.f41176p1 = i10;
        this.f41120U = true;
        this.f41099L = 0;
        int i12 = this.mMaximumFlingVelocity;
        if (i10 > i12 || i10 < (i12 = -i12)) {
            i11 = i12;
        } else {
            if (Math.abs(i10) < this.mMinimumFlingVelocity) {
                postAdjustScrollerCommand(0);
                return;
            }
            i11 = i10;
        }
        if (i10 > 0) {
            this.f41093J.fling(this, 0, i11, 0, Integer.MAX_VALUE);
        } else {
            this.f41093J.fling(this, 0, i11, Integer.MIN_VALUE, 0);
        }
        int finalPositon = this.f41093J.getFinalPositon();
        if (finalPositon == 0 || this.mSelectorElementHeight == 0) {
            this.f41109O0 = 1.0d;
            return;
        }
        this.f41109O0 = PickerHelper.getDistanceRatio(this.f41129a, this.mInitialScrollOffset, this.mCurrentScrollOffset, i10, finalPositon);
        invalidate();
        m53856h(100);
    }

    public void forceCompleteChangeCurrentByOneViaScroll() {
        if (this.f41093J.isFinished()) {
            return;
        }
        this.f41093J.abortAnimation();
    }

    public String format(int i10) {
        return PickerHelper.formatDisplayedValue(i10);
    }

    @Override // android.view.View
    public float getBottomFadingEdgeStrength() {
        return 0.9f;
    }

    public String[] getDisplayedValues() {
        String[] strArr = this.f41069B;
        return strArr != null ? (String[]) strArr.clone() : PickerHelper.calculateDisplayedValues(this);
    }

    public int getGravity() {
        return this.f41146f1;
    }

    public int getMaxValue() {
        return this.f41174p;
    }

    public Drawable getMiddleStateDrawable() {
        View view = this.f41127Y0;
        if (view == null) {
            return null;
        }
        return view.getBackground();
    }

    public int getMinValue() {
        return this.f41171o;
    }

    public OnColorChangeListener getOnColorChangeListener() {
        return this.f41202y0;
    }

    public float getScrollFriction() {
        return this.f41167m1;
    }

    public int getSecondaryPaintColor() {
        return this.f41130a0;
    }

    public float getSelectedTextSize() {
        return this.mSelectedTextSize;
    }

    public Drawable getSelectionDivider() {
        return this.f41169n0;
    }

    public int getSelectionDividerHeight() {
        return this.f41172o0;
    }

    public int getSelectorPaintColor() {
        return this.f41124W;
    }

    public float getSensitivity() {
        HwGenericEventDetector hwGenericEventDetector = this.f41111P0;
        if (hwGenericEventDetector != null) {
            return hwGenericEventDetector.getSensitivity();
        }
        return 0.6f;
    }

    @Override // android.view.View
    public int getSolidColor() {
        return this.f41122V;
    }

    @Override // android.view.View
    public float getTopFadingEdgeStrength() {
        return 0.9f;
    }

    public float getUnselectedTextSize() {
        return this.mUnselectedTextSize;
    }

    public int getValue() {
        return this.f41177q;
    }

    public boolean getWrapSelectorWheel() {
        return this.f41118T;
    }

    @Override // com.huawei.uikit.hwadvancednumberpicker.utils.HwCommonHandler.MessageHandler
    public void handleMessage(Message message) {
        int i10 = message.what;
        if (i10 == 103) {
            m53886s(this);
        } else {
            if (i10 != 104) {
                return;
            }
            m53790D();
        }
    }

    public void initAcceFocusable(AccessibilityManager accessibilityManager) {
        this.f41154i0 = isFocusable();
        this.f41157j0 = isFocusableInTouchMode();
        if (accessibilityManager != null && accessibilityManager.isEnabled()) {
            setFocusableInTouchMode(false);
            setFocusable(false);
        }
    }

    public void initAcceItems() {
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.huawei.uikit.hwadvancednumberpicker.widget.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f41253a.m53812a(view);
            }
        };
        View viewFindViewById = findViewById(C8692R.id.hwadvancednumberpicker_increment);
        this.f41125W0 = viewFindViewById;
        viewFindViewById.setOnClickListener(onClickListener);
        View viewFindViewById2 = findViewById(C8692R.id.hwadvancednumberpicker_decrement);
        this.f41126X0 = viewFindViewById2;
        viewFindViewById2.setOnClickListener(onClickListener);
        View viewFindViewById3 = findViewById(C8692R.id.hwadvancednumberpicker_textview);
        this.f41127Y0 = viewFindViewById3;
        viewFindViewById3.setFocusable(true);
        setEnabled(this.f41133b0);
        setMiddleStateDrawable(this.f41136c0);
        this.f41127Y0.setAccessibilityDelegate(new bzrwd());
        View.AccessibilityDelegate focusedStatusMonitor = PickerHelper.getFocusedStatusMonitor(this.mContext, this, this.f41127Y0, this.f41164l1, this.f41153i);
        this.f41125W0.setAccessibilityDelegate(focusedStatusMonitor);
        this.f41126X0.setAccessibilityDelegate(focusedStatusMonitor);
        this.f41127Y0.setAccessibilityDelegate(focusedStatusMonitor);
    }

    public void initFlingVelocity(ViewConfiguration viewConfiguration) {
        this.mMinimumFlingVelocity = 400;
        this.mMaximumFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity() / 2;
    }

    public void initializeSelectorWheel() {
        initializeSelectorWheelIndices();
        if (Float.compare(this.f41196w0.length - 1, 0.0f) == 0) {
            return;
        }
        int top = ((this.f41156j.getTop() + this.f41156j.getBottom()) / 2) - (this.mSelectorElementHeight * this.f41153i);
        this.mInitialScrollOffset = top;
        this.mCurrentScrollOffset = top;
        m53902G();
    }

    public void initializeSelectorWheelIndices() {
        this.f41084G.clear();
        m53849f(getValue());
    }

    public boolean isAccessibilityOptimizationEnabled() {
        return this.f41123V0;
    }

    @Override // android.view.View
    public boolean isEnabled() {
        return this.f41133b0;
    }

    public boolean isExtendScrollEnabled() {
        return this.f41113Q0;
    }

    public boolean isPickerScrollCenter() {
        return Math.abs(this.mInitialScrollOffset - this.mCurrentScrollOffset) == 0;
    }

    public boolean isScrollCenterInThreshold() {
        return Math.abs(this.mInitialScrollOffset - this.mCurrentScrollOffset) <= 1;
    }

    public boolean isTextColorGradientEnabled() {
        return this.f41161k1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m53876n();
        m53873m();
        m53878o();
        m53864j();
    }

    public void onCancel() {
        this.f41160k0 = false;
        if (this.f41073C0.isFinished()) {
            PickerHelper.abortScrollAnimation(this.f41093J, this.f41096K);
            fling(0);
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        updateSelectorItemCount(!this.f41076D0 && configuration.orientation == 2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        PickerHelper.removeAllCallbacks(this, this.f41102M);
        m53897y();
        m53899z();
        m53895x();
        m53893w();
        ScheduledFuture<?> scheduledFuture = this.f41200x1;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            this.f41200x1 = null;
        }
        C11787b.m70255e().m70263m();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (canvas == null) {
            return;
        }
        super.onDraw(canvas);
        if (this.f41180r == 0) {
            return;
        }
        int iSave = canvas.save();
        if (this.f41180r == 1) {
            Rect clipBounds = canvas.getClipBounds();
            clipBounds.inset(0, this.mSelectorElementHeight);
            canvas.clipRect(clipBounds);
        }
        if (this.f41149g1 == 1) {
            m53828b(canvas);
        } else {
            m53809a(canvas);
        }
        m53838c(canvas);
        canvas.restoreToCount(iSave);
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (!isEnabled() || motionEvent == null) {
            return false;
        }
        this.f41134b1 = true;
        HwGenericEventDetector hwGenericEventDetector = this.f41111P0;
        if (hwGenericEventDetector != null && this.f41113Q0 && hwGenericEventDetector.onGenericMotionEvent(motionEvent)) {
            return true;
        }
        m53885s();
        this.f41116S.addMovement(motionEvent);
        if (motionEvent.getActionMasked() == 8) {
            long timeInMillis = Calendar.getInstance().getTimeInMillis();
            this.f41138d = timeInMillis;
            if (timeInMillis - this.f41135c > 5) {
                float axisValue = motionEvent.getAxisValue(9) * 960.0f;
                if (Math.abs(axisValue) > 4800.0f) {
                    axisValue = axisValue > 0.0f ? 4800.0f : -4800.0f;
                }
                if (!this.f41160k0 && this.f41073C0.isFinished() && PickerHelper.isNeedStartFling(this.f41093J, axisValue)) {
                    PickerHelper.getFocus(this, this.f41079E0);
                    m53811a(motionEvent, (int) axisValue);
                } else {
                    Log.w(PickerHelper.TAG, "action conflict, no need to scroll");
                }
                this.f41135c = this.f41138d;
            }
        }
        m53891v();
        return true;
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (!this.f41151h0) {
            return super.onHoverEvent(motionEvent);
        }
        PickerHelper.sendAccessibilityEvent(motionEvent, this);
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled() || !this.f41142e0 || motionEvent == null) {
            return false;
        }
        m53885s();
        this.f41116S.addMovement(motionEvent);
        this.f41116S.computeCurrentVelocity(1000, this.mMaximumFlingVelocity);
        this.f41103M0 = (int) this.f41116S.getYVelocity();
        this.f41120U = false;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f41092I1 = false;
            this.f41095J1 = false;
            m53789B();
            akxao akxaoVar = this.f41170n1;
            if (akxaoVar != null) {
                removeCallbacks(akxaoVar);
            }
            return m53819a(motionEvent);
        }
        if (actionMasked == 1) {
            this.f41092I1 = true;
            this.f41095J1 = true;
            m53840c(motionEvent);
            return false;
        }
        if (actionMasked == 2 && ((int) Math.abs(motionEvent.getY() - this.f41108O)) > this.f41183s) {
            this.f41112Q = false;
            m53853g(1);
            setSelectorWheelState(2);
            m53855h();
            if (motionEvent.getPointerCount() == 1) {
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        PickerHelper.layoutInputText(this.f41156j, this);
        if (!this.f41148g0) {
            this.f41148g0 = true;
            initializeSelectorWheel();
            int height = getHeight();
            int i14 = this.f41166m0;
            int i15 = this.f41172o0;
            int i16 = ((height - i14) / 2) - i15;
            this.f41190u0 = i16;
            this.f41181r0 = i16 + (i15 * 2) + i14;
            this.f41193v0 = (getHeight() - this.f41175p0) / 2;
        }
        m53833c();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(PickerHelper.makeMeasureSpec(i10, this.f41168n), PickerHelper.makeMeasureSpec(i11, this.f41162l));
        setMeasuredDimension(PickerHelper.resolveSizeAndStateRespectingMinSize(this.f41165m, getMeasuredWidth(), i10, this), PickerHelper.resolveSizeAndStateRespectingMinSize(this.f41159k, getMeasuredHeight(), i11, this));
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent == null) {
            return;
        }
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setContentDescription(null);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled() || motionEvent == null) {
            return false;
        }
        m53885s();
        this.f41116S.addMovement(motionEvent);
        this.f41116S.computeCurrentVelocity(1000, this.mMaximumFlingVelocity);
        this.f41103M0 = (int) this.f41116S.getYVelocity();
        this.f41120U = false;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            PickerHelper.getFocus(this, this.f41079E0);
            this.f41160k0 = true;
            this.f41205z0.sendEmptyMessage(103);
            m53789B();
        } else if (actionMasked == 1) {
            this.f41098K1 = true;
            this.f41092I1 = true;
            this.f41104M1 = true;
            this.f41101L1 = false;
            this.f41083F1 = 0;
            if (m53791E()) {
                return false;
            }
        } else {
            if (actionMasked == 2) {
                return m53831b(motionEvent);
            }
            if (actionMasked == 3) {
                this.f41098K1 = true;
                this.f41083F1 = 0;
                onCancel();
            }
        }
        return true;
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i10) {
        super.onWindowVisibilityChanged(i10);
        if (i10 == 0) {
            PickerHelper.invalidateSelectorWheel(this);
            if (this.f41137c1 != 0) {
                m53823b();
            }
        }
        this.f41137c1 = i10;
    }

    public void postAdjustScrollerCommand(int i10) {
        avpbg avpbgVar = this.f41102M;
        if (avpbgVar == null) {
            this.f41102M = new avpbg();
        } else {
            removeCallbacks(avpbgVar);
        }
        postDelayed(this.f41102M, i10);
    }

    @Override // android.view.View
    public void scrollBy(int i10, int i11) {
        this.f41074C1 = SystemClock.uptimeMillis();
        if (this.f41180r == 0 || !this.f41142e0) {
            return;
        }
        int[] iArr = this.f41196w0;
        int i12 = this.f41153i;
        if (i12 >= 0 && i12 < iArr.length) {
            boolean z10 = this.f41118T;
            if ((!z10 || this.f41199x0) && i11 > 0 && iArr[i12] <= this.f41171o) {
                this.mCurrentScrollOffset = this.mInitialScrollOffset;
                this.f41093J.abortAnimation();
                return;
            } else if (!z10 && i11 < 0 && iArr[i12] >= this.f41174p) {
                this.mCurrentScrollOffset = this.mInitialScrollOffset;
                this.f41093J.abortAnimation();
                return;
            }
        }
        this.mCurrentScrollOffset += i11;
        this.f41188t1 = Math.abs(this.f41120U ? this.f41106N0 : this.f41103M0);
        double dPx2dip = HwUtils.px2dip(this.mContext, r10) * f41060P1;
        this.f41191u1 = dPx2dip;
        this.f41203y1 = BigDecimal.valueOf(dPx2dip).compareTo(BigDecimal.valueOf(f41059O1)) < 0;
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        if (this.f41203y1 && this.f41179q1 && this.f41083F1 < 4 && this.f41191u1 > 50.0d) {
            Log.i(PickerHelper.TAG, "Made up for the " + this.f41083F1 + " vibration, velocity is " + this.f41191u1);
            this.f41203y1 = false;
            this.f41098K1 = false;
        }
        if (!this.f41203y1 && timeInMillis - this.f41080E1 < 40) {
            this.f41203y1 = true;
        }
        m53854g(iArr);
        this.f41134b1 = false;
    }

    public void setAccessibilityOptimizationEnabled(boolean z10) {
        this.f41123V0 = z10;
    }

    public void setAnnouncedSuffix(String str) {
        this.f41097K0 = str;
    }

    public void setDisplayedValues(String[] strArr) {
        if (Arrays.equals(this.f41069B, strArr)) {
            return;
        }
        if (strArr != null) {
            this.f41069B = (String[]) strArr.clone();
        } else {
            this.f41069B = null;
        }
        if (this.f41069B != null) {
            this.f41156j.setRawInputType(ARImageMetadata.LENS_FILTER_DENSITY);
        } else {
            this.f41156j.setRawInputType(2);
        }
        PickerHelper.updatePicker(this);
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        this.f41133b0 = z10;
        PickerHelper.setViewEnabled(this.f41127Y0, z10);
        PickerHelper.setViewEnabled(this.f41125W0, z10);
        PickerHelper.setViewEnabled(this.f41126X0, z10);
        PickerHelper.setPickerAlpha(this, z10, this.f41139d0);
    }

    public void setExtendScrollEnabled(boolean z10) {
        this.f41113Q0 = z10;
    }

    public void setFlingAble(boolean z10) {
        this.f41142e0 = z10;
    }

    public void setFlingAnnounceType(int i10) {
        this.f41100L0 = i10;
    }

    public void setFormatter(HwFormatter hwFormatter) {
        if (hwFormatter == this.f41078E) {
            return;
        }
        this.f41078E = hwFormatter;
        initializeSelectorWheelIndices();
        m53902G();
    }

    public void setGravity(int i10) {
        this.f41146f1 = i10;
    }

    public void setIsNeedStopDownScroll(boolean z10) {
        this.f41199x0 = z10;
    }

    public void setIsSupportRichTap(boolean z10) {
        this.f41182r1 = z10;
    }

    public void setMaxValue(int i10) {
        if (this.f41174p == i10) {
            return;
        }
        if (i10 < 0) {
            Log.e(PickerHelper.TAG, "maxValue must be >= 0");
            return;
        }
        this.f41174p = i10;
        if (i10 < this.f41177q) {
            this.f41177q = i10;
        }
        setWrapSelectorWheel(i10 - this.f41171o > this.f41196w0.length);
        PickerHelper.updatePicker(this);
    }

    public void setMiddleStateDrawable(int i10) {
        if (i10 != 0) {
            this.f41127Y0.setBackgroundResource(i10);
        }
    }

    public void setMinValue(int i10) {
        if (this.f41171o == i10) {
            return;
        }
        if (i10 < 0) {
            Log.e(PickerHelper.TAG, "minValue must be >= 0");
            return;
        }
        this.f41171o = i10;
        int i11 = this.f41177q;
        int i12 = this.f41165m;
        if (i11 <= i12) {
            i11 = i12;
        }
        this.f41177q = i11;
        setWrapSelectorWheel(this.f41174p - i10 > this.f41196w0.length);
        PickerHelper.updatePicker(this);
    }

    public void setOnColorChangeListener(OnColorChangeListener onColorChangeListener) {
        this.f41202y0 = onColorChangeListener;
    }

    public void setOnLongPressUpdateInterval(long j10) {
        this.f41081F = j10;
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.f41075D = onScrollListener;
    }

    public void setOnValueChangedListener(OnValueChangeListener onValueChangeListener) {
        this.f41072C = onValueChangeListener;
    }

    public void setScrollFriction(float f10) {
        this.f41167m1 = f10;
        this.f41093J.setFriction(f10);
    }

    @Deprecated
    public void setSecondPaintColor(int i10) {
        setSecondaryPaintColor(i10);
    }

    public void setSecondaryPaintColor(int i10) {
        this.f41130a0 = i10;
        this.f41090I.setColor(i10);
        invalidate();
    }

    public void setSelectedFocusedTextColor(int i10) {
        this.mSelectedFocusedTextColor = i10;
    }

    public void setSelectedItemHeight(float f10) {
        ViewGroup.LayoutParams layoutParams = this.f41127Y0.getLayoutParams();
        layoutParams.height = (int) TypedValue.applyDimension(1, f10, this.mContext.getResources().getDisplayMetrics());
        this.f41127Y0.setLayoutParams(layoutParams);
        invalidate();
    }

    public void setSelectedItemTextSize(float f10) {
        float fDp2px = PickerHelper.dp2px(this.mContext, f10);
        this.f41087H.setTextSize(fDp2px);
        this.mSelectedTextSize = fDp2px;
        this.f41131a1 = fDp2px;
        this.f41156j.setTextSize(1, f10 + 2.0f);
        ViewGroup.LayoutParams layoutParams = this.f41156j.getLayoutParams();
        layoutParams.height = -2;
        this.f41156j.setLayoutParams(layoutParams);
        invalidate();
    }

    public void setSelectedTextMinSize(float f10) {
        this.mPickerSelectedTextMinSize = (int) PickerHelper.sp2px(this.mContext, f10);
    }

    public void setSelectedTextSize(float f10) {
        m53824b(PickerHelper.sp2px(this.mContext, f10));
    }

    public void setSelectedTextSizeByDp(float f10) {
        m53824b(PickerHelper.dp2px(this.mContext, f10));
    }

    public void setSelectedUnfocusedTextColor(int i10) {
        this.mSelectedUnfocusedTextColor = i10;
    }

    public void setSelectionDivider(Drawable drawable) {
        this.f41169n0 = drawable;
        this.f41149g1 = 0;
    }

    public void setSelectionDividerHeight(int i10) {
        this.f41172o0 = i10;
    }

    public void setSelectionRectDivider(Drawable drawable) {
        this.f41169n0 = drawable;
        this.f41149g1 = 1;
    }

    public void setSelectorPaintColor(int i10) {
        this.f41124W = i10;
        this.f41087H.setColor(i10);
        invalidate();
    }

    public void setSelectorPaintColorInSingleMode(int i10) {
    }

    public void setSensitivity(float f10) {
        HwGenericEventDetector hwGenericEventDetector = this.f41111P0;
        if (hwGenericEventDetector != null) {
            hwGenericEventDetector.setSensitivity(f10);
        }
    }

    @Deprecated
    public void setSlaverPaintColor(int i10) {
        setSecondaryPaintColor(i10);
    }

    public void setStringUnit(String str) {
        if (this.f41069B != null) {
            Log.w(PickerHelper.TAG, "mDisplayedValues is not null, unit can not be set.");
        } else {
            if (str.isEmpty()) {
                return;
            }
            this.f41085G0 = true;
            this.f41088H0 = str;
        }
    }

    public void setTextColorGradientEnabled(boolean z10) {
        this.f41161k1 = z10;
    }

    public void setUnselectedItemTextSize(float f10) {
        float fDp2px = PickerHelper.dp2px(this.mContext, f10);
        this.f41090I.setTextSize(fDp2px);
        this.mUnselectedTextSize = fDp2px;
        invalidate();
    }

    public void setUnselectedItemsHeight(float f10) {
        ArrayList<View> arrayList = new ArrayList();
        arrayList.add(this.f41125W0);
        arrayList.add(this.f41126X0);
        for (View view : arrayList) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = (int) TypedValue.applyDimension(1, f10, this.mContext.getResources().getDisplayMetrics());
            view.setLayoutParams(layoutParams);
        }
        invalidate();
    }

    public void setUnselectedTextSize(float f10) {
        m53834c(PickerHelper.sp2px(this.mContext, f10));
    }

    public void setUnselectedTextSizeByDp(float f10) {
        m53834c(PickerHelper.dp2px(this.mContext, f10));
    }

    public void setValue(int i10) {
        if (this.f41177q == i10) {
            return;
        }
        int i11 = this.f41171o;
        if (i10 < i11) {
            i10 = this.f41118T ? this.f41174p : i11;
        }
        int i12 = this.f41174p;
        if (i10 <= i12) {
            i11 = i10;
        } else if (!this.f41118T) {
            i11 = i12;
        }
        this.f41177q = i11;
        initializeSelectorWheelIndices();
        m53902G();
        invalidate();
    }

    public void setWrapSelectorWheel(boolean z10) {
        if (z10 && this.f41174p - this.f41171o < this.f41196w0.length) {
            Log.e(PickerHelper.TAG, "Range less than selector items count.");
        } else if (z10 != this.f41118T) {
            this.f41118T = z10;
        }
    }

    public void stepDown() {
        if (!this.f41160k0 && this.f41073C0.isFinished() && this.f41093J.isFinished() && this.f41096K.isFinished()) {
            this.f41099L = 0;
            this.f41073C0.startScroll(0, 0, 0, this.f41129a * (-2), 150);
        }
        invalidate();
    }

    public void stepUp() {
        if (!this.f41160k0 && this.f41073C0.isFinished() && this.f41093J.isFinished() && this.f41096K.isFinished()) {
            this.f41099L = 0;
            this.f41073C0.startScroll(0, 0, 0, this.f41129a * 2, 150);
        }
        invalidate();
    }

    public void updateSelectorItemCount(boolean z10) {
        int i10 = this.f41082F0 ? 5 : 7;
        this.f41186t = i10;
        this.f41153i = i10 / 2;
        this.f41196w0 = new int[i10];
        m53887t();
        initializeSelectorWheel();
        requestLayout();
    }

    public void vibrate(View view, int i10) {
        PickerHelper.performVibrate(this, view, i10);
    }

    public HwAdvancedNumberPicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C8692R.attr.hwAdvancedNumberPickerStyle);
    }

    /* renamed from: c */
    private boolean m53840c(MotionEvent motionEvent) {
        m53885s();
        if (motionEvent != null) {
            this.f41116S.addMovement(motionEvent);
        }
        this.f41116S.computeCurrentVelocity(1000, this.mMaximumFlingVelocity);
        int yVelocity = (int) this.f41116S.getYVelocity();
        this.f41160k0 = false;
        m53891v();
        if (this.f41073C0.isFinished() && this.f41199x0 && yVelocity > 0) {
            postAdjustScrollerCommand(0);
            m53853g(0);
            return true;
        }
        if (this.f41073C0.isFinished()) {
            m53811a(motionEvent, yVelocity);
        }
        m53856h(100);
        return false;
    }

    /* renamed from: d */
    private void m53842d(float f10) {
        if (f10 > PickerHelper.getScreenWidthHeightMinValue(getContext()) || f10 < (-r0)) {
            Log.e(PickerHelper.TAG, "Illegal event locationY.");
            return;
        }
        if ((this.f41112Q || this.f41145f0 != 1) && ((int) Math.abs(f10 - this.f41108O)) > this.f41183s) {
            this.f41112Q = false;
            m53853g(1);
        }
        scrollBy(0, (int) (f10 - this.f41110P));
        invalidate();
        this.f41110P = f10;
    }

    /* renamed from: e */
    public void m53847e(int[] iArr) {
        int i10 = this.mCurrentScrollOffset - this.mInitialScrollOffset;
        boolean z10 = this.f41101L1;
        boolean z11 = z10 && !this.f41107N1;
        if (((i10 <= (-this.f41129a) || i10 == 0) && !z11) || !this.f41182r1) {
            while (this.mCurrentScrollOffset - this.mInitialScrollOffset < (-this.f41129a)) {
                m53839c(m53870k(iArr));
                this.f41107N1 = false;
            }
        } else {
            if (!z10) {
                iArr = m53870k(iArr);
            }
            m53817a(iArr);
        }
    }

    /* renamed from: f */
    private void m53850f(int[] iArr) {
        while (this.mCurrentScrollOffset - this.mInitialScrollOffset > this.f41129a) {
            int[] iArrM53858h = m53858h(iArr);
            int i10 = this.f41153i;
            if (i10 >= 0 && i10 < iArrM53858h.length) {
                if (!this.f41182r1) {
                    m53868k(iArrM53858h[i10]);
                    m53843d(iArrM53858h[this.f41153i]);
                }
                if (!this.f41118T && iArrM53858h[this.f41153i] <= this.f41171o) {
                    this.mCurrentScrollOffset = this.mInitialScrollOffset;
                }
            }
        }
    }

    /* renamed from: g */
    private void m53854g(int[] iArr) {
        if (this.f41203y1) {
            ScheduledFuture<?> scheduledFuture = this.f41200x1;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
            }
            m53850f(iArr);
            m53866j(iArr);
            this.f41179q1 = false;
            return;
        }
        if (!this.f41182r1) {
            m53850f(iArr);
            m53866j(iArr);
            return;
        }
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.f41197w1;
        if (scheduledThreadPoolExecutor != null && scheduledThreadPoolExecutor.isShutdown()) {
            m53873m();
        }
        if (this.f41179q1) {
            return;
        }
        this.f41179q1 = true;
        this.f41205z0.sendEmptyMessage(104);
    }

    /* renamed from: h */
    private int[] m53858h(int[] iArr) {
        int i10 = this.mCurrentScrollOffset;
        this.mCurrentScrollOffset = i10 - ((i10 - this.mInitialScrollOffset >= this.mSelectorElementHeight && PickerHelper.isFinishedScroller(this.f41093J, this.f41096K) && this.f41134b1) ? this.mSelectorElementHeight : this.f41129a * 2);
        System.arraycopy(iArr, 0, iArr, 1, iArr.length - 1);
        int i11 = iArr[1] - 1;
        if (this.f41118T && i11 < this.f41171o) {
            i11 = this.f41174p;
        }
        iArr[0] = i11;
        m53802a(i11);
        return iArr;
    }

    /* renamed from: i */
    private void m53860i() {
        AccessibilityManager accessibilityManager = this.f41152h1;
        this.f41151h0 = accessibilityManager != null && accessibilityManager.isEnabled() && this.f41152h1.isTouchExplorationEnabled();
        initAcceFocusable(this.f41152h1);
    }

    /* renamed from: j */
    private void m53866j(int[] iArr) {
        while (this.mCurrentScrollOffset - this.mInitialScrollOffset < (-this.f41129a)) {
            int[] iArrM53870k = m53870k(iArr);
            int i10 = this.f41153i;
            if (i10 >= 0 && i10 < iArrM53870k.length) {
                if (!this.f41182r1) {
                    m53868k(iArrM53870k[i10]);
                    m53843d(iArrM53870k[this.f41153i]);
                }
                if (!this.f41118T && iArrM53870k[this.f41153i] >= this.f41174p) {
                    this.mCurrentScrollOffset = this.mInitialScrollOffset;
                }
            }
        }
    }

    /* renamed from: k */
    private void m53867k() {
        View.inflate(getContext(), C8692R.layout.hwadvancednumberpicker, this);
        m53807a(getContext());
        m53871l();
        m53887t();
    }

    /* renamed from: l */
    private void m53871l() {
        this.f41087H = PickerHelper.getSelectorWheelPaint(this.mContext, this.f41124W, this.mSelectedTextSize);
        this.f41090I = PickerHelper.getSecondaryWheelPaint(this.mContext, this.f41130a0, this.mSelectedTextSize);
    }

    /* renamed from: m */
    private void m53873m() {
        if (this.f41197w1 == null) {
            this.f41197w1 = new ScheduledThreadPoolExecutor(8);
        }
    }

    /* renamed from: n */
    private void m53876n() {
        if (isInEditMode()) {
            return;
        }
        SoundPool soundPoolBuildSoundPool = PickerHelper.buildSoundPool();
        this.f41198x = soundPoolBuildSoundPool;
        if (soundPoolBuildSoundPool == null) {
            return;
        }
        soundPoolBuildSoundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() { // from class: com.huawei.uikit.hwadvancednumberpicker.widget.b
            @Override // android.media.SoundPool.OnLoadCompleteListener
            public final void onLoadComplete(SoundPool soundPool, int i10, int i11) {
                this.f41254a.m53810a(soundPool, i10, i11);
            }
        });
        this.mSoundId = this.f41198x.load(getContext(), C8692R.raw.hwadvancednumberpicker, 1);
    }

    /* renamed from: o */
    private void m53878o() {
        if (this.f41115R0 == null) {
            this.f41115R0 = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new com.huawei.uikit.hwadvancednumberpicker.widget.bzrwd());
        }
        if (this.f41117S0 == null) {
            this.f41117S0 = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new com.huawei.uikit.hwadvancednumberpicker.widget.bzrwd());
        }
    }

    /* renamed from: p */
    public /* synthetic */ void m53880p() {
        PickerHelper.setFadingEdge(this.mContext, this);
        invalidate();
    }

    /* renamed from: q */
    public /* synthetic */ void m53882q() {
        long jUptimeMillis = SystemClock.uptimeMillis() - this.f41077D1;
        boolean z10 = false;
        boolean z11 = BigDecimal.valueOf(this.f41191u1).compareTo(BigDecimal.ZERO) == 0;
        long jUptimeMillis2 = SystemClock.uptimeMillis() - this.f41074C1;
        boolean z12 = this.f41077D1 == -1 || jUptimeMillis > 38;
        if (jUptimeMillis2 > 20 && this.f41104M1) {
            this.f41101L1 = true;
            this.f41104M1 = false;
        }
        boolean z13 = this.f41101L1;
        if (z13) {
            z10 = z13;
        } else if (jUptimeMillis2 < 20) {
            z10 = true;
        }
        if (this.f41196w0.length <= 0 || z11 || !z10 || !z12) {
            return;
        }
        this.f41185s1 = true;
        Log.i(PickerHelper.TAG, "This time it's a 40 ms vibration, The time interval is : " + jUptimeMillis);
        this.f41077D1 = SystemClock.uptimeMillis();
        long jRound = Math.round((this.f41191u1 * f41061Q1) + f41062R1);
        if (jRound > 100 && jRound < 2147483647L) {
            jRound = 100;
        }
        try {
            vibrate(this, jRound);
            synchronized (this.f41132b) {
                m53889u();
            }
        } catch (Resources.NotFoundException unused) {
            Log.e(PickerHelper.TAG, "vibrate or playSound not found.");
        } catch (Exception unused2) {
            Log.e(PickerHelper.TAG, "vibrate or playSound error.");
        }
        post(new aauaf());
    }

    /* renamed from: r */
    public /* synthetic */ void m53883r() {
        PickerHelper.sendAccessibilityAnnounceEvent(this, this.f41152h1, this.f41142e0);
    }

    /* renamed from: t */
    private void m53887t() {
        try {
            this.f41162l = ((int) getResources().getDimension(C8692R.dimen.hwadvancednumberpicker_input_high)) * (this.f41196w0.length - 1);
        } catch (Resources.NotFoundException unused) {
            Log.w(PickerHelper.TAG, "resources not found");
        }
        if (this.f41142e0) {
            if (isInEditMode()) {
                setSelectorWheelState(1);
            } else {
                setSelectorWheelState(2);
                m53855h();
            }
        }
        m53902G();
        this.f41148g0 = false;
    }

    /* renamed from: u */
    public void m53889u() {
        if (this.f41198x == null || this.mSoundId == 0 || !this.mIsSoundLoadFinished) {
            Log.w(PickerHelper.TAG, "SoundPool is not initialized properly!");
            return;
        }
        float f10 = (float) ((this.f41191u1 * f41063S1) + 0.6d);
        Log.w(PickerHelper.TAG, "TimePicker volume level is: " + f10);
        this.f41198x.play(this.mSoundId, f10, f10, 0, 0, 1.0f);
    }

    /* renamed from: v */
    private void m53891v() {
        VelocityTracker velocityTracker = this.f41116S;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f41116S = null;
        }
    }

    /* renamed from: w */
    private void m53893w() {
        AccessibilityManager accessibilityManager;
        AccessibilityManager.AccessibilityStateChangeListener accessibilityStateChangeListener = this.f41067A0;
        if (accessibilityStateChangeListener != null && (accessibilityManager = this.f41152h1) != null) {
            accessibilityManager.removeAccessibilityStateChangeListener(accessibilityStateChangeListener);
        }
        this.f41067A0 = null;
    }

    /* renamed from: x */
    private void m53895x() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.f41197w1;
        if (scheduledThreadPoolExecutor != null) {
            scheduledThreadPoolExecutor.shutdownNow();
        }
        this.f41197w1 = null;
    }

    /* renamed from: y */
    private void m53897y() {
        synchronized (this.f41132b) {
            try {
                SoundPool soundPool = this.f41198x;
                if (soundPool != null) {
                    soundPool.release();
                    this.f41198x = null;
                    this.mSoundId = 0;
                    this.mIsSoundLoadFinished = false;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: z */
    private void m53899z() {
        ThreadPoolExecutor threadPoolExecutor = this.f41115R0;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.shutdownNow();
        }
        this.f41115R0 = null;
        ThreadPoolExecutor threadPoolExecutor2 = this.f41117S0;
        if (threadPoolExecutor2 != null) {
            threadPoolExecutor2.shutdownNow();
        }
        this.f41117S0 = null;
    }

    public void setOnScrollListener(HwPickerScrollListener hwPickerScrollListener) {
        this.f41173o1 = hwPickerScrollListener;
    }

    public void vibrate(HwAdvancedNumberPicker hwAdvancedNumberPicker, long j10) {
        Log.i(PickerHelper.TAG, "Vibration interval time is : " + (Calendar.getInstance().getTimeInMillis() - this.f41086G1));
        this.f41086G1 = Calendar.getInstance().getTimeInMillis();
        PickerHelper.performHapticVibrate(hwAdvancedNumberPicker, this.f41194v1, j10);
    }

    public class bfscp extends View.AccessibilityDelegate {

        /* renamed from: a */
        private String f41211a;

        /* renamed from: b */
        private String f41212b;

        private bfscp() {
            this.f41211a = "";
            this.f41212b = "";
        }

        /* renamed from: a */
        private void m53906a() {
            if (!HwAdvancedNumberPicker.this.f41123V0) {
                HwAdvancedNumberPicker.this.f41094J0 = HwAdvancedNumberPicker.this.f41091I0 + HwAdvancedNumberPicker.this.f41097K0;
                this.f41212b = HwAdvancedNumberPicker.this.f41091I0 + "";
                return;
            }
            if (HwAdvancedNumberPicker.this.f41145f0 == 0) {
                HwAdvancedNumberPicker.this.f41094J0 = HwAdvancedNumberPicker.this.f41091I0 + HwAdvancedNumberPicker.this.f41097K0;
            } else if (HwAdvancedNumberPicker.this.f41145f0 == 1) {
                HwAdvancedNumberPicker hwAdvancedNumberPicker = HwAdvancedNumberPicker.this;
                hwAdvancedNumberPicker.f41094J0 = hwAdvancedNumberPicker.f41091I0;
            } else if (HwAdvancedNumberPicker.this.f41145f0 == 2) {
                m53907b();
            }
            this.f41212b = HwAdvancedNumberPicker.this.f41091I0 + "";
        }

        /* renamed from: b */
        private void m53907b() {
            if (!HwAdvancedNumberPicker.this.f41093J.isFinished()) {
                HwAdvancedNumberPicker.this.f41094J0 = HwAdvancedNumberPicker.this.f41091I0 + "";
                return;
            }
            if (HwAdvancedNumberPicker.this.f41096K.isFinished()) {
                m53908c();
                return;
            }
            HwAdvancedNumberPicker.this.f41094J0 = HwAdvancedNumberPicker.this.f41091I0 + HwAdvancedNumberPicker.this.f41097K0;
        }

        /* renamed from: c */
        private void m53908c() {
            String str = this.f41212b;
            if (str == null || str.equals(HwAdvancedNumberPicker.this.f41091I0)) {
                HwAdvancedNumberPicker hwAdvancedNumberPicker = HwAdvancedNumberPicker.this;
                hwAdvancedNumberPicker.f41094J0 = hwAdvancedNumberPicker.f41097K0;
                return;
            }
            HwAdvancedNumberPicker.this.f41094J0 = HwAdvancedNumberPicker.this.f41091I0 + HwAdvancedNumberPicker.this.f41097K0;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            if (view == null || accessibilityEvent == null) {
                return;
            }
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            PickerHelper.setAccessibilityEventDescription(accessibilityEvent, HwAdvancedNumberPicker.this.f41073C0, HwAdvancedNumberPicker.this.f41094J0);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            if (view == null || accessibilityEvent == null) {
                return;
            }
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setContentDescription(null);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEvent(View view, int i10) {
            m53906a();
            if (HwAdvancedNumberPicker.this.f41094J0 == null || HwAdvancedNumberPicker.this.f41094J0.equals(this.f41211a)) {
                return;
            }
            this.f41211a = HwAdvancedNumberPicker.this.f41094J0;
            super.sendAccessibilityEvent(view, i10);
        }

        public /* synthetic */ bfscp(HwAdvancedNumberPicker hwAdvancedNumberPicker, bzrwd bzrwdVar) {
            this();
        }
    }

    public HwAdvancedNumberPicker(Context context, AttributeSet attributeSet, int i10) throws Resources.NotFoundException {
        super(m53796a(context, i10), attributeSet, i10);
        this.mInitialScrollOffset = Integer.MIN_VALUE;
        this.f41132b = new Object();
        this.f41135c = 0L;
        this.f41138d = 0L;
        this.f41186t = 0;
        this.f41189u = 15;
        this.f41192v = 11;
        this.f41081F = 300L;
        this.f41084G = new SparseArray<>();
        this.f41120U = false;
        this.f41145f0 = 0;
        this.f41151h0 = false;
        this.f41154i0 = false;
        this.f41157j0 = false;
        this.f41160k0 = false;
        this.f41163l0 = false;
        this.f41184s0 = 0.6f;
        this.f41199x0 = false;
        this.f41205z0 = new HwCommonHandler(this);
        this.f41085G0 = false;
        this.f41088H0 = "";
        this.f41091I0 = "";
        this.f41094J0 = "";
        this.f41097K0 = "";
        this.f41100L0 = 3;
        this.f41109O0 = 1.0d;
        this.f41113Q0 = false;
        this.f41119T0 = false;
        this.f41121U0 = new blfhz(this, true, null);
        this.f41123V0 = false;
        this.f41134b1 = false;
        this.f41137c1 = 0;
        this.f41158j1 = true;
        this.f41164l1 = new HashMap<>();
        this.f41077D1 = -1L;
        this.f41092I1 = false;
        this.f41095J1 = false;
        this.f41098K1 = true;
        this.f41101L1 = false;
        this.f41104M1 = true;
        this.f41107N1 = false;
        this.mContext = getContext();
        C11787b.m70255e().m70257g(context);
        this.f41182r1 = C11787b.m70255e().m70258h() && Settings.Secure.getInt(this.mContext.getContentResolver(), f41065U1, 0) == 0;
        this.f41194v1 = PickerHelper.readHeJson(context);
        this.f41159k = -1;
        this.f41165m = 96;
        this.f41168n = -1;
        this.f41066A = false;
        this.f41105N = new AnimatorSet();
        this.f41093J = new HwSpringBackHelper();
        this.f41096K = new HwSpringBackHelper();
        m53808a(this.mContext, attributeSet, i10);
        post(new Runnable() { // from class: com.huawei.uikit.hwadvancednumberpicker.widget.e
            @Override // java.lang.Runnable
            public final void run() {
                this.f41258a.m53880p();
            }
        });
    }

    /* renamed from: b */
    private void m53827b(Context context, AttributeSet attributeSet, int i10) {
        this.f41152h1 = (AccessibilityManager) this.mContext.getSystemService("accessibility");
        m53860i();
        int iApplyDimension = (((int) TypedValue.applyDimension(1, 2.0f, getResources().getDisplayMetrics())) - ((int) this.mContext.getResources().getDimension(C8692R.dimen.hwadvancednumberpicker_select_divider))) - 1;
        int dimension = (int) getResources().getDimension(C8692R.dimen.hwadvancednumberpicker_selection_divider_distance);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C8692R.styleable.HwAdvancedNumberPicker, i10, 0);
        try {
            try {
                this.f41122V = typedArrayObtainStyledAttributes.getColor(C8692R.styleable.HwAdvancedNumberPicker_hwSolidColor, 0);
                this.f41169n0 = typedArrayObtainStyledAttributes.getDrawable(C8692R.styleable.HwAdvancedNumberPicker_hwNumberPickerSelectionDivider);
                this.f41172o0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(C8692R.styleable.HwAdvancedNumberPicker_hwNumberPickerSelectionDividerHeight, iApplyDimension);
                this.f41166m0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(C8692R.styleable.HwAdvancedNumberPicker_hwNumberPickerSelectionDividerDistance, dimension);
                this.f41124W = typedArrayObtainStyledAttributes.getColor(C8692R.styleable.HwAdvancedNumberPicker_hwMasterTextColor, HwConstants.DEFAULT_SELECTOR_COLOR);
                this.f41130a0 = typedArrayObtainStyledAttributes.getColor(C8692R.styleable.HwAdvancedNumberPicker_hwSlaverTextColor, -452984832);
                this.f41187t0 = typedArrayObtainStyledAttributes.getInt(C8692R.styleable.HwAdvancedNumberPicker_hwSensitivityMode, 1);
                this.f41133b0 = typedArrayObtainStyledAttributes.getBoolean(C8692R.styleable.HwAdvancedNumberPicker_android_enabled, true);
                this.f41136c0 = typedArrayObtainStyledAttributes.getResourceId(C8692R.styleable.HwAdvancedNumberPicker_hwStateDrawable, 0);
                this.f41139d0 = typedArrayObtainStyledAttributes.getFloat(C8692R.styleable.HwAdvancedNumberPicker_hwDisabledAlpha, 0.0f);
            } catch (Resources.NotFoundException unused) {
                Log.w(PickerHelper.TAG, "TypedArray get resource error");
            }
            typedArrayObtainStyledAttributes.recycle();
            HwGenericEventDetector hwGenericEventDetectorCreateGenericEventDetector = createGenericEventDetector();
            this.f41111P0 = hwGenericEventDetectorCreateGenericEventDetector;
            if (hwGenericEventDetectorCreateGenericEventDetector != null) {
                hwGenericEventDetectorCreateGenericEventDetector.setOnScrollListener(this, createOnScrollListener());
                float sensitivityByMode = PickerHelper.getSensitivityByMode(this.f41187t0);
                this.f41184s0 = sensitivityByMode;
                this.f41111P0.setSensitivity(sensitivityByMode);
            }
        } catch (Throwable th2) {
            typedArrayObtainStyledAttributes.recycle();
            throw th2;
        }
    }

    /* renamed from: s */
    private void m53886s(HwAdvancedNumberPicker hwAdvancedNumberPicker) {
        OnColorChangeListener onColorChangeListener = this.f41202y0;
        if (onColorChangeListener != null) {
            onColorChangeListener.onColorChange(hwAdvancedNumberPicker);
        }
    }

    /* renamed from: i */
    private void m53862i(int[] iArr) {
        if (this.f41185s1) {
            if (this.f41182r1) {
                Log.i(PickerHelper.TAG, "The timeSpan when scroll : " + SystemClock.uptimeMillis());
                m53825b(iArr[this.f41153i]);
                return;
            }
            m53803a(iArr[this.f41153i], Math.abs(this.f41120U ? this.f41106N0 : this.f41103M0));
        }
    }

    /* renamed from: k */
    private int[] m53870k(int[] iArr) {
        int i10 = this.mCurrentScrollOffset;
        this.mCurrentScrollOffset = i10 + ((i10 - this.mInitialScrollOffset <= (-this.mSelectorElementHeight) && PickerHelper.isFinishedScroller(this.f41093J, this.f41096K) && this.f41134b1) ? this.mSelectorElementHeight : this.f41129a * 2);
        System.arraycopy(iArr, 1, iArr, 0, iArr.length - 1);
        int i11 = iArr[iArr.length - 2] + 1;
        if (this.f41118T && i11 > this.f41174p) {
            i11 = this.f41171o;
        }
        iArr[iArr.length - 1] = i11;
        m53802a(i11);
        return iArr;
    }

    @Deprecated
    public void changeCurrent(int i10, boolean z10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        changeCurrent(i10);
        if (z10) {
            m53889u();
            HwVibrateUtil.vibrator(HwVibrateUtil.HAPTIC_TIME_SCROLL_VIBRATOR);
        }
    }

    /* renamed from: a */
    private void m53808a(Context context, AttributeSet attributeSet, int i10) throws Resources.NotFoundException {
        this.f41128Z0 = this.mContext.getString(C8692R.string.hwadvancednumberpicker_increment_scroll_action);
        this.mSelectorTextGapHeight = PickerHelper.getDimenInt(this.mContext, C8692R.dimen.hwadvancednumberpicker_selector_text_gap_height);
        this.mSelectorElementHeight = PickerHelper.getDimenInt(this.mContext, C8692R.dimen.hwadvancednumberpicker_selector_element_height);
        this.f41129a = (int) (this.mSelectorTextGapHeight * 1.44d);
        this.f41175p0 = PickerHelper.getDimenInt(this.mContext, C8692R.dimen.hwadvancednumberpicker_divider_rect_height);
        this.f41178q0 = PickerHelper.getDimenInt(this.mContext, C8692R.dimen.hwadvancednumberpicker_selected_view_align_horizontal);
        Resources resources = getResources();
        int i11 = C8692R.integer.emui_device_type;
        this.f41076D0 = resources.getInteger(i11) == 2;
        this.f41079E0 = getResources().getInteger(i11) == 8;
        boolean z10 = getResources().getInteger(i11) == 4;
        this.f41082F0 = z10;
        int i12 = z10 ? 5 : 7;
        this.f41186t = i12;
        this.f41153i = i12 / 2;
        this.f41196w0 = new int[i12];
        m53827b(super.getContext(), attributeSet, i10);
        m53792F();
        this.f41142e0 = true;
        setWillNotDraw(false);
        setSelectorWheelState(0);
        this.f41195w = getResources().getDimension(C8692R.dimen.hwadvancednumberpicker_adjust_height);
        this.mPickerSelectedTextMinSize = PickerHelper.getDimenInt(this.mContext, C8692R.dimen.hwadvancednumberpicker_emui_primary_title_1_min);
        this.mPickerUnSelectedTextMinSize = PickerHelper.getDimenInt(this.mContext, C8692R.dimen.hwadvancednumberpicker_emui_primary_subtitle_min);
        this.f41070B0 = PickerHelper.getDimenInt(this.mContext, C8692R.dimen.hwadvancednumberpicker_text_step);
        m53867k();
        this.f41073C0 = new Scroller(this.mContext, new HwCubicBezierInterpolator(0.2f, 0.0f, 0.2f, 1.0f));
        m53873m();
        m53878o();
        this.f41143e1 = new brnby(this, null);
        setAccessibilityDelegate(new bfscp(this, null));
        PickerHelper.setValueFromPlume(context, this, this.f41163l0);
    }

    public void changeCurrent(int i10, int i11, boolean z10) {
        ThreadPoolExecutor threadPoolExecutor;
        changeCurrent(i10);
        if (!z10 || (threadPoolExecutor = this.f41115R0) == null) {
            return;
        }
        bxac bxacVar = this.f41140d1;
        if (bxacVar != null) {
            threadPoolExecutor.remove(bxacVar);
        }
        bxac bxacVar2 = new bxac(this, i11, this, null);
        this.f41140d1 = bxacVar2;
        this.f41115R0.execute(bxacVar2);
    }

    /* renamed from: j */
    private void m53865j(int i10) {
        if (this.f41182r1 && this.f41071B1) {
            m53861i(i10);
            m53835c(i10);
        }
    }

    /* renamed from: f */
    public void m53905f() {
        if (this.f41073C0.isFinished()) {
            return;
        }
        this.f41073C0.computeScrollOffset();
        m53804a(this.f41073C0.getCurrY(), this.f41073C0);
    }

    /* renamed from: h */
    private void m53855h() {
        this.f41105N.cancel();
        this.f41156j.setVisibility(4);
    }

    /* renamed from: i */
    private void m53861i(int i10) {
        if (this.f41120U) {
            return;
        }
        m53825b(i10);
    }

    /* renamed from: e */
    public void m53904e() {
        int iCalculateMaxTextWidth;
        if (this.f41066A && this.f41168n != (iCalculateMaxTextWidth = PickerHelper.calculateMaxTextWidth(this.f41087H, this.f41069B, this.f41174p) + this.f41156j.getPaddingLeft() + this.f41156j.getPaddingRight())) {
            int i10 = this.f41165m;
            if (iCalculateMaxTextWidth <= i10) {
                iCalculateMaxTextWidth = i10;
            }
            this.f41168n = iCalculateMaxTextWidth;
            invalidate();
        }
    }

    /* renamed from: d */
    public void m53844d(int[] iArr) {
        int i10 = this.mCurrentScrollOffset - this.mInitialScrollOffset;
        boolean z10 = this.f41101L1;
        boolean z11 = z10 && this.f41107N1;
        if (((i10 < this.f41129a && i10 != 0) || z11) && this.f41182r1) {
            if (!z10) {
                iArr = m53858h(iArr);
            }
            m53817a(iArr);
        } else {
            while (this.mCurrentScrollOffset - this.mInitialScrollOffset > this.f41129a) {
                m53830b(m53858h(iArr));
                this.f41107N1 = true;
            }
        }
    }

    /* renamed from: h */
    private void m53856h(int i10) {
        m53837c(i10, 0);
    }

    /* renamed from: j */
    private void m53864j() {
        if (this.f41067A0 == null && this.f41152h1 != null) {
            AccessibilityManager.AccessibilityStateChangeListener accessibilityStateChangeListener = new AccessibilityManager.AccessibilityStateChangeListener() { // from class: com.huawei.uikit.hwadvancednumberpicker.widget.c
                @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
                public final void onAccessibilityStateChanged(boolean z10) {
                    this.f41256a.m53815a(z10);
                }
            };
            this.f41067A0 = accessibilityStateChangeListener;
            this.f41152h1.addAccessibilityStateChangeListener(accessibilityStateChangeListener);
        }
    }

    /* renamed from: c */
    private void m53839c(int[] iArr) {
        int i10 = this.f41153i;
        if (i10 >= 0 && i10 < iArr.length) {
            m53862i(iArr);
            if (!this.f41118T && iArr[this.f41153i] >= this.f41174p) {
                this.mCurrentScrollOffset = this.mInitialScrollOffset;
            }
        }
        this.f41185s1 = false;
    }

    /* renamed from: f */
    private void m53849f(int i10) {
        for (int i11 = 0; i11 < this.f41196w0.length; i11++) {
            int iM53845e = m53845e((i10 + i11) - this.f41153i);
            this.f41196w0[i11] = iM53845e;
            m53802a(iM53845e);
        }
    }

    /* renamed from: k */
    private void m53868k(int i10) {
        if (this.f41120U) {
            return;
        }
        m53803a(i10, Math.abs(this.f41103M0));
    }

    /* renamed from: g */
    private void m53852g() {
        ThreadPoolExecutor threadPoolExecutor = this.f41117S0;
        if (threadPoolExecutor != null) {
            brnby brnbyVar = this.f41143e1;
            if (brnbyVar != null) {
                threadPoolExecutor.remove(brnbyVar);
            }
            long timeInMillis = Calendar.getInstance().getTimeInMillis() - this.f41086G1;
            if (timeInMillis < 40) {
                long j10 = 40 - timeInMillis;
                this.f41080E1 = Calendar.getInstance().getTimeInMillis() + j10;
                m53806a(j10);
            } else {
                this.f41080E1 = Calendar.getInstance().getTimeInMillis();
                this.f41117S0.execute(this.f41143e1);
            }
        }
    }

    /* renamed from: e */
    private int m53845e(int i10) {
        return this.f41118T ? PickerHelper.getWrappedSelectorIndex(i10, this.f41174p, this.f41171o) : i10;
    }

    /* renamed from: c */
    private void m53833c() {
        String longText;
        String[] strArr = this.f41069B;
        if (strArr == null) {
            String value = PickerHelper.formatValue(this.f41177q, this.f41078E);
            if (!this.f41201y || TextUtils.isEmpty(value) || value.endsWith(this.f41204z) || "-- --".equals(value)) {
                longText = null;
            } else {
                longText = value + this.f41204z;
            }
        } else {
            longText = PickerHelper.getLongText(strArr, this.f41087H);
        }
        if (TextUtils.isEmpty(longText)) {
            return;
        }
        PickerHelper.akxao akxaoVar = new PickerHelper.akxao();
        akxaoVar.f41245a = longText;
        akxaoVar.f41246b = (int) this.f41131a1;
        akxaoVar.f41247c = this.mPickerSelectedTextMinSize;
        akxaoVar.f41248d = this.f41070B0;
        this.mSelectedTextSize = PickerHelper.autoWidth(this, this.f41087H, akxaoVar, this.f41178q0) - this.f41070B0;
        m53871l();
    }

    /* renamed from: d */
    public void m53903d() {
        HwSpringBackHelper hwSpringBackHelper = this.f41093J;
        if (hwSpringBackHelper.isFinished()) {
            this.f41109O0 = 1.0d;
            hwSpringBackHelper = this.f41096K;
            if (hwSpringBackHelper.isFinished()) {
                return;
            }
        }
        hwSpringBackHelper.computeScrollOffset();
        this.f41106N0 = (int) hwSpringBackHelper.getCurrVelocity();
        int currentOffset = hwSpringBackHelper.getCurrentOffset();
        if (this.f41099L == 0) {
            this.f41099L = hwSpringBackHelper.getStartPosition();
        }
        m53805a((int) (currentOffset * this.f41109O0), hwSpringBackHelper);
    }

    /* renamed from: g */
    private void m53853g(int i10) {
        if (this.f41145f0 == i10) {
            return;
        }
        this.f41145f0 = i10;
        OnScrollListener onScrollListener = this.f41075D;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChange(this, i10);
        }
    }

    /* renamed from: b */
    private boolean m53831b(MotionEvent motionEvent) {
        float y10 = motionEvent.getY();
        if (this.f41199x0 && y10 - this.f41108O > 0.0f) {
            return false;
        }
        if (!this.f41073C0.isFinished()) {
            return true;
        }
        m53800a();
        m53842d(y10);
        return true;
    }

    /* renamed from: c */
    private void m53838c(Canvas canvas) {
        float wheelAverageX = PickerHelper.getWheelAverageX(this, this.f41146f1);
        float f10 = this.mCurrentScrollOffset;
        this.f41164l1.clear();
        float f11 = f10;
        int i10 = 0;
        while (true) {
            int[] iArr = this.f41196w0;
            if (i10 < iArr.length) {
                String str = this.f41084G.get(iArr[i10]);
                if (str != null) {
                    String scrollSelectorValue = PickerHelper.formatScrollSelectorValue(this.f41078E, str, str.startsWith("0"), this.f41201y, this.f41204z);
                    float fAdjustCoordinateY = adjustCoordinateY(i10, f11, this.mCurrentScrollOffset);
                    m53836c(i10, fAdjustCoordinateY);
                    String strEllipsizeSelectorValue = PickerHelper.ellipsizeSelectorValue(this, scrollSelectorValue, this.f41090I, this.f41076D0 || this.f41079E0);
                    if (i10 == this.f41153i) {
                        strEllipsizeSelectorValue = m53797a(canvas, wheelAverageX, i10, strEllipsizeSelectorValue, fAdjustCoordinateY);
                        if (strEllipsizeSelectorValue.equals("")) {
                            return;
                        }
                    } else {
                        float fM53794a = m53794a(i10, fAdjustCoordinateY);
                        if (Float.compare(fM53794a, 0.0f) == 0) {
                            return;
                        }
                        canvas.save();
                        Bitmap bitmapFromCache = PickerHelper.getBitmapFromCache(PickerHelper.SECONDARY_CACHES, strEllipsizeSelectorValue, this.f41090I);
                        canvas.scale(fM53794a, fM53794a, wheelAverageX, fAdjustCoordinateY);
                        canvas.drawBitmap(bitmapFromCache, PickerHelper.getWheelCanvasLeft(bitmapFromCache, this.f41146f1, wheelAverageX, this.f41178q0), fAdjustCoordinateY - (bitmapFromCache.getHeight() / 2.0f), this.f41090I);
                        canvas.restore();
                        PickerHelper.setButtonContentDescription(i10, strEllipsizeSelectorValue, this.f41126X0, this.f41125W0, this.f41153i);
                    }
                    f11 += this.mSelectorElementHeight;
                    this.f41164l1.put(Integer.valueOf(i10), strEllipsizeSelectorValue);
                }
                i10++;
            } else {
                PickerHelper.adjustAccessibilityFocus(this.f41164l1, this.f41125W0, this.f41126X0);
                return;
            }
        }
    }

    /* renamed from: d */
    private void m53843d(int i10) {
        if (this.f41120U) {
            m53803a(i10, Math.abs(this.f41106N0));
        }
    }

    /* renamed from: b */
    private void m53830b(int[] iArr) {
        int i10 = this.f41153i;
        if (i10 >= 0 && i10 < iArr.length) {
            m53862i(iArr);
            if (!this.f41118T && iArr[this.f41153i] <= this.f41171o) {
                this.mCurrentScrollOffset = this.mInitialScrollOffset;
            }
        }
        this.f41185s1 = false;
    }

    /* renamed from: a */
    public /* synthetic */ boolean m53818a(float f10, float f11, MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        int axisValue = (int) motionEvent.getAxisValue(9);
        if (!PickerHelper.isFinishedScroller(this.f41093J, this.f41096K)) {
            scrollBy(0, this.f41129a * 2 * axisValue);
        } else {
            scrollBy(0, this.mSelectorElementHeight * axisValue);
        }
        invalidate();
        return true;
    }

    /* renamed from: b */
    public void m53823b() {
        m53885s();
        this.f41116S.computeCurrentVelocity(1000, this.mMaximumFlingVelocity);
        this.f41103M0 = (int) this.f41116S.getYVelocity();
        this.f41120U = false;
        m53791E();
    }

    /* renamed from: a */
    private static Context m53796a(Context context, int i10) {
        return HwWidgetCompat.wrapContext(context, i10, C8692R.style.Theme_Emui_HwAdvancedNumberPicker);
    }

    /* renamed from: a */
    private void m53816a(boolean z10, AccessibilityManager accessibilityManager) {
        if (accessibilityManager == null) {
            return;
        }
        this.f41151h0 = accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled();
        if (z10) {
            this.f41154i0 = isFocusable();
            this.f41157j0 = isFocusableInTouchMode();
            setFocusableInTouchMode(false);
            setFocusable(false);
            return;
        }
        setFocusableInTouchMode(this.f41157j0);
        setFocusable(this.f41154i0);
    }

    /* renamed from: b */
    private float m53821b(int i10, float f10) {
        if (Float.compare(this.mSelectedTextSize, this.mTextSizeBlackEdge) <= 0) {
            return 1.0f;
        }
        float fAbs = Math.abs(f10 - ((this.f41153i * this.mSelectorElementHeight) + this.mInitialScrollOffset));
        if (fAbs >= 10.0f && fAbs <= 20.0f && !this.f41089H1) {
            this.f41089H1 = true;
            fAbs = 0.0f;
        } else if (fAbs <= 20.0f && this.f41089H1) {
            this.f41089H1 = false;
            fAbs = 20.0f;
        } else {
            this.f41089H1 = false;
        }
        if (fAbs < 10.0f) {
            boolean z10 = this.f41092I1;
            if (z10 && this.f41188t1 == 0 && this.f41095J1) {
                this.f41095J1 = false;
                this.f41068A1 = false;
            }
            if (z10 && this.f41188t1 == 0) {
                this.f41188t1 = 400;
                this.f41191u1 = HwUtils.px2dip(this.mContext, 400) * f41060P1;
            }
            if (this.f41203y1 && this.f41188t1 != 0 && this.f41068A1) {
                this.f41092I1 = false;
                this.f41071B1 = true;
                m53865j(this.f41196w0[this.f41153i]);
                this.f41068A1 = false;
            }
            HwPickerScrollListener hwPickerScrollListener = this.f41173o1;
            if (hwPickerScrollListener != null) {
                hwPickerScrollListener.onItemScrollCenter(this.f41176p1 > 0 ? 2 : 1);
            }
        }
        this.f41071B1 = false;
        float f11 = this.mSelectedTextSize;
        float f12 = f11 - this.mTextSizeBlackEdge;
        float f13 = this.f41153i * this.mSelectorElementHeight * f11;
        if (Float.compare(f13, 0.0f) == 0) {
            return 0.0f;
        }
        return 1.0f - ((f12 * fAbs) / f13);
    }

    /* renamed from: a */
    private void m53801a(float f10) {
        this.mSelectedTextSize -= f10;
        this.mUnselectedTextSize -= f10;
        this.mTextSizeBlackSmall -= f10;
        this.mTextSizeBlackEdge -= f10;
    }

    /* renamed from: a */
    private void m53807a(Context context) {
        this.f41156j = (TextView) findViewById(C8692R.id.hwadvancednumberpicker_input);
        this.f41183s = ViewConfiguration.getTapTimeout();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f41183s = viewConfiguration.getScaledTouchSlop();
        initFlingVelocity(viewConfiguration);
        float f10 = this.mMaximumFlingVelocity;
        this.f41141e = 0.1f * f10;
        this.f41144f = 0.25f * f10;
        this.f41147g = 0.55f * f10;
        this.f41150h = f10 * 0.8f;
        initAcceItems();
    }

    /* renamed from: c */
    private void m53836c(int i10, float f10) {
        if (this.f41161k1) {
            float fAbs = Math.abs(f10 - ((this.f41153i * this.mSelectorElementHeight) + this.mInitialScrollOffset));
            if (this.f41158j1 && i10 == 1) {
                this.f41155i1 = fAbs;
                this.f41158j1 = false;
            }
            float f11 = this.f41155i1;
            if (f11 == 0.0f) {
                return;
            }
            int iIntValue = ((Integer) new ArgbEvaluator().evaluate(Math.min(fAbs / f11, 1.0f), Integer.valueOf(this.f41124W), Integer.valueOf(this.f41130a0))).intValue();
            if (i10 == this.f41153i) {
                this.f41087H.setColor(iIntValue);
            } else {
                this.f41090I.setColor(iIntValue);
            }
        }
    }

    /* renamed from: a */
    public /* synthetic */ void m53812a(View view) {
        if (view != null && isEnabled()) {
            if (PickerHelper.handleUpDownEvent(this, view, this.f41164l1, this.f41153i)) {
                if (PickerHelper.isAccessibilityEnabled(this.mContext)) {
                    m53856h(100);
                    return;
                } else {
                    m53837c(100, 1);
                    return;
                }
            }
            return;
        }
        Log.w(PickerHelper.TAG, "null view.");
    }

    /* renamed from: b */
    private void m53828b(Canvas canvas) {
        Drawable drawable = this.f41169n0;
        if (drawable == null) {
            return;
        }
        int i10 = this.f41193v0;
        drawable.setBounds(0, i10, getWidth(), this.f41175p0 + i10);
        this.f41169n0.draw(canvas);
    }

    /* renamed from: a */
    private boolean m53819a(MotionEvent motionEvent) {
        float y10 = motionEvent.getY();
        this.f41108O = y10;
        this.f41110P = y10;
        PickerHelper.removeAllCallbacks(this, this.f41102M);
        this.f41105N.cancel();
        this.f41112Q = false;
        this.f41114R = true;
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        if (this.f41180r == 2) {
            this.f41112Q = PickerHelper.isFinishedScroller(this.f41093J, this.f41096K);
            this.f41114R = true;
            m53855h();
            return this.f41079E0;
        }
        this.f41114R = false;
        setSelectorWheelState(2);
        m53855h();
        return this.f41079E0;
    }

    /* renamed from: c */
    private void m53835c(int i10) {
        if (this.f41120U) {
            m53825b(i10);
        }
    }

    /* renamed from: c */
    private void m53834c(float f10) {
        this.mUnselectedTextSize = f10;
        float f11 = (f10 * 2.0f) - this.mSelectedTextSize;
        this.mTextSizeBlackSmall = f11;
        this.mTextSizeBlackEdge = f11;
        PickerHelper.layoutAndInvalidate(this);
    }

    /* renamed from: b */
    private void m53825b(int i10) {
        changeCurrentRichTap(i10);
    }

    /* renamed from: b */
    private void m53824b(float f10) {
        this.mSelectedTextSize = f10;
        this.f41131a1 = f10;
        this.f41087H.setTextSize(f10);
        this.f41090I.setTextSize(f10);
        float f11 = (this.mUnselectedTextSize * 2.0f) - this.mSelectedTextSize;
        this.mTextSizeBlackSmall = f11;
        this.mTextSizeBlackEdge = f11;
        PickerHelper.layoutAndInvalidate(this);
    }

    /* renamed from: c */
    public void m53837c(int i10, int i11) {
        akxao akxaoVar = this.f41170n1;
        if (akxaoVar == null) {
            this.f41170n1 = new akxao(i11);
        } else {
            removeCallbacks(akxaoVar);
        }
        postDelayed(this.f41170n1, i10);
    }

    /* renamed from: b */
    private void m53826b(int i10, int i11) {
        OnValueChangeListener onValueChangeListener = this.f41072C;
        if (onValueChangeListener != null) {
            onValueChangeListener.onValueChange(this, i10, this.f41177q);
        }
    }

    /* renamed from: a */
    private void m53800a() {
        if (this.f41119T0) {
            blfhz blfhzVar = this.f41121U0;
            if (blfhzVar != null) {
                removeCallbacks(blfhzVar);
                this.f41121U0.m53910a(true);
                postDelayed(this.f41121U0, 100L);
            }
            this.f41119T0 = false;
        }
    }

    /* renamed from: a */
    private void m53811a(MotionEvent motionEvent, int i10) {
        PickerHelper.abortScrollAnimation(this.f41093J, this.f41096K);
        if (Math.abs(i10) > this.mMinimumFlingVelocity) {
            fling(i10);
            m53853g(2);
        } else if (this.f41114R && PickerHelper.isFinishedScroller(this.f41093J, this.f41096K)) {
            PickerHelper.postAdjustScroller(this.mContext, this, motionEvent);
            m53853g(0);
        } else {
            postAdjustScrollerCommand(HwConstants.SHOW_INPUT_CONTROLS_DELAY_MILLIS);
        }
    }

    /* renamed from: a */
    private void m53817a(int[] iArr) {
        int i10 = this.f41153i;
        if (i10 >= 0 && i10 < iArr.length) {
            m53862i(iArr);
        }
        this.f41185s1 = false;
    }

    /* renamed from: a */
    private void m53804a(int i10, Scroller scroller) {
        scrollBy(0, i10 - this.f41099L);
        this.f41099L = i10;
        if (scroller.isFinished()) {
            postDelayed(new Runnable() { // from class: com.huawei.uikit.hwadvancednumberpicker.widget.f
                @Override // java.lang.Runnable
                public final void run() {
                    this.f41259a.m53883r();
                }
            }, 100L);
        } else {
            invalidate();
        }
    }

    /* renamed from: a */
    private void m53805a(int i10, HwSpringBackHelper hwSpringBackHelper) {
        scrollBy(0, i10 - this.f41099L);
        this.f41099L = i10;
        if (hwSpringBackHelper.isFinished()) {
            m53788A();
        } else {
            invalidate();
        }
    }

    /* renamed from: a */
    private String m53797a(Canvas canvas, float f10, int i10, String str, float f11) {
        if (canvas == null || TextUtils.isEmpty(str)) {
            return "";
        }
        if (this.f41085G0) {
            str = str + this.f41088H0;
        }
        if (!Objects.equals(this.f41206z1, str)) {
            this.f41206z1 = str;
            this.f41068A1 = true;
        }
        float fM53821b = m53821b(i10, f11);
        if (Float.compare(fM53821b, 0.0f) == 0) {
            return "";
        }
        canvas.save();
        Bitmap bitmapFromCache = PickerHelper.getBitmapFromCache(PickerHelper.SELECTOR_CACHES, str, this.f41087H);
        canvas.scale(fM53821b, fM53821b, f10, f11);
        canvas.drawBitmap(bitmapFromCache, PickerHelper.getWheelCanvasLeft(bitmapFromCache, this.f41146f1, f10, this.f41178q0), f11 - (bitmapFromCache.getHeight() / 2.0f), this.f41087H);
        canvas.restore();
        if (!this.f41076D0) {
            this.f41127Y0.setContentDescription(str);
        }
        this.f41091I0 = str;
        return str;
    }

    /* renamed from: a */
    private float m53794a(int i10, float f10) {
        if (Float.compare(this.mSelectedTextSize, this.mTextSizeBlackEdge) <= 0) {
            return 1.0f;
        }
        float f11 = this.mSelectedTextSize - this.mTextSizeBlackEdge;
        float fAbs = Math.abs(f10 - ((this.f41153i * this.mSelectorElementHeight) + this.mInitialScrollOffset));
        HwPickerScrollListener hwPickerScrollListener = this.f41173o1;
        if (hwPickerScrollListener != null && fAbs < 10.0f) {
            hwPickerScrollListener.onItemScrollCenter(this.f41176p1 > 0 ? 2 : 1);
        }
        float f12 = this.f41153i * this.mSelectorElementHeight * this.mSelectedTextSize;
        if (Float.compare(f12, 0.0f) == 0) {
            return 0.0f;
        }
        return 1.0f - ((f11 * fAbs) / f12);
    }

    /* renamed from: a */
    private void m53809a(Canvas canvas) {
        if (this.f41169n0 == null) {
            return;
        }
        this.f41189u = PickerHelper.getDimenInt(this.mContext, C8692R.dimen.hwadvancednumberpicker_select_top_offset);
        int dimenInt = PickerHelper.getDimenInt(this.mContext, C8692R.dimen.hwadvancednumberpicker_select_bottom_offset);
        this.f41192v = dimenInt;
        int i10 = this.f41190u0;
        int i11 = this.f41189u;
        int i12 = ((i10 - i11) - dimenInt) + (i11 - dimenInt);
        this.f41169n0.setBounds(0, i12, getRight() + 50, this.f41172o0 + i12);
        this.f41169n0.draw(canvas);
        int i13 = this.f41181r0;
        int i14 = this.f41192v;
        int i15 = (i13 + (i14 * 2)) - (this.f41189u - i14);
        this.f41169n0.setBounds(0, i15 - this.f41172o0, getRight() + 50, i15);
        this.f41169n0.draw(canvas);
    }

    /* renamed from: a */
    private void m53806a(long j10) {
        this.f41205z0.postDelayed(new bqmxo(), j10);
    }

    /* renamed from: a */
    private void m53803a(int i10, int i11) {
        float f10 = i11;
        float f11 = this.f41141e;
        if (f10 < f11) {
            changeCurrent(i10, 2, true);
            return;
        }
        if (f10 >= f11 && f10 < this.f41144f) {
            changeCurrent(i10, 3, true);
            return;
        }
        if (f10 >= this.f41144f && f10 < this.f41147g) {
            changeCurrent(i10, 4, true);
            return;
        }
        if (f10 >= this.f41147g && f10 < this.f41150h) {
            changeCurrent(i10, 5, true);
        } else if (f10 >= this.f41150h) {
            changeCurrent(i10, 6, true);
        }
    }

    /* renamed from: a */
    private void m53802a(int i10) {
        String value;
        int i11 = i10 - this.f41171o;
        if (this.f41084G.get(i10) != null) {
            return;
        }
        if (i10 >= this.f41171o && i10 <= this.f41174p) {
            String[] strArr = this.f41069B;
            if (strArr == null) {
                value = PickerHelper.formatValue(i10, this.f41078E);
            } else if (i11 >= 0 && i11 < strArr.length) {
                value = strArr[i11];
            } else {
                value = this.f41084G.get(i10);
            }
        } else {
            value = "";
        }
        this.f41084G.put(i10, value);
    }

    /* renamed from: a */
    public /* synthetic */ void m53815a(boolean z10) {
        m53816a(z10, this.f41152h1);
    }

    /* renamed from: a */
    public /* synthetic */ void m53810a(SoundPool soundPool, int i10, int i11) {
        if (i11 == 0) {
            this.mIsSoundLoadFinished = true;
        }
    }
}
