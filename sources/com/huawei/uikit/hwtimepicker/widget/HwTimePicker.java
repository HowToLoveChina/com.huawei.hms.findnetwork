package com.huawei.uikit.hwtimepicker.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.format.DateFormat;
import android.text.format.DateUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.huawei.android.hicloud.sync.service.aidl.SyncType;
import com.huawei.android.p069cg.request.callable.DownloadTaskBaseCallable;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.PriorInstallWay;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwFormatter;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwLanguageUtils;
import com.huawei.uikit.hwadvancednumberpicker.widget.HwAdvancedNumberPicker;
import com.huawei.uikit.hwadvancednumberpicker.widget.PickerHelper;
import com.huawei.uikit.hwresources.utils.AuxiliaryHelper;
import com.huawei.uikit.hwresources.utils.HwWidgetCompat;
import com.huawei.uikit.hwresources.utils.HwWidgetInstantiator;
import com.huawei.uikit.hwtimepicker.C8741R;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

/* loaded from: classes5.dex */
public class HwTimePicker extends FrameLayout {

    /* renamed from: C */
    private static final String f44414C = "HwTimePicker";

    /* renamed from: D */
    private static final int f44415D = 11;

    /* renamed from: E */
    private static final boolean f44416E = true;

    /* renamed from: F */
    private static final String[] f44417F = {"12", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"};

    /* renamed from: G */
    private static final String[] f44418G = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", DownloadTaskBaseCallable.DOWNLOAD_POOL_SHUTDOWN, "14", "15", "16", "17", "18", "19", "20", PriorInstallWay.PRIOR_ACTION_LANDING_PAGE, "22", "23"};

    /* renamed from: H */
    private static final String[] f44419H = {"00", HiAnalyticsConstant.KeyAndValue.NUMBER_01, "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", DownloadTaskBaseCallable.DOWNLOAD_POOL_SHUTDOWN, "14", "15", "16", "17", "18", "19", "20", PriorInstallWay.PRIOR_ACTION_LANDING_PAGE, "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"};

    /* renamed from: I */
    private static final String[] f44420I = {"00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"};

    /* renamed from: J */
    private static final String f44421J = "  ";

    /* renamed from: K */
    private static final String f44422K = ", ";

    /* renamed from: L */
    private static final int f44423L = 1;

    /* renamed from: M */
    private static final int f44424M = 5;

    /* renamed from: N */
    private static final float f44425N = 5.0f;

    /* renamed from: O */
    private static final int f44426O = 0;

    /* renamed from: P */
    private static final int f44427P = 59;

    /* renamed from: Q */
    private static final int f44428Q = 59;

    /* renamed from: R */
    private static final int f44429R = 11;

    /* renamed from: S */
    private static final int f44430S = 2;

    /* renamed from: T */
    private static final int f44431T = 4;

    /* renamed from: U */
    private static final int f44432U = 100;

    /* renamed from: V */
    private static final int f44433V = 23;

    /* renamed from: W */
    private static final int f44434W = 11;

    /* renamed from: a0 */
    private static final int f44435a0 = 2;

    /* renamed from: b0 */
    private static final int f44436b0 = 23;

    /* renamed from: c0 */
    private static final int f44437c0 = 11;

    /* renamed from: d0 */
    private static final int f44438d0 = 59;

    /* renamed from: e0 */
    private static final int f44439e0 = 2;

    /* renamed from: f0 */
    private static final int f44440f0 = 1;

    /* renamed from: g0 */
    private static final int f44441g0 = 12;

    /* renamed from: h0 */
    private static final int f44442h0 = 24;

    /* renamed from: i0 */
    private static final float f44443i0 = 35.0f;

    /* renamed from: j0 */
    private static final float f44444j0 = 48.0f;

    /* renamed from: k0 */
    private static final float f44445k0 = 28.0f;

    /* renamed from: l0 */
    private static final int f44446l0 = -1;

    /* renamed from: m0 */
    private static final int f44447m0 = 2;

    /* renamed from: A */
    private int f44448A;

    /* renamed from: B */
    private int f44449B;

    /* renamed from: a */
    private Locale f44450a;

    /* renamed from: b */
    private OnTimeChangedListener f44451b;

    /* renamed from: c */
    private GregorianCalendar f44452c;

    /* renamed from: d */
    private GregorianCalendar f44453d;

    /* renamed from: e */
    private LinearLayout f44454e;

    /* renamed from: f */
    private int f44455f;

    /* renamed from: g */
    private int f44456g;

    /* renamed from: h */
    private Drawable f44457h;

    /* renamed from: i */
    private boolean f44458i;

    /* renamed from: j */
    private final Context f44459j;

    /* renamed from: k */
    private final String[] f44460k;

    /* renamed from: l */
    private String[] f44461l;

    /* renamed from: m */
    private String[] f44462m;
    protected HwAdvancedNumberPicker mAmPmSpinner;
    protected int mDividerType;
    protected boolean mIs24HoursSystem;
    protected HwAdvancedNumberPicker mTimeHourSpinner;
    protected HwAdvancedNumberPicker mTimeMinuteSpinner;

    /* renamed from: n */
    private final List<HwAdvancedNumberPicker> f44463n;

    /* renamed from: o */
    private boolean f44464o;

    /* renamed from: p */
    private GestureDetector f44465p;

    /* renamed from: q */
    private HwAdvancedNumberPicker.OnValueChangeListener f44466q;

    /* renamed from: r */
    private HwAdvancedNumberPicker.OnColorChangeListener f44467r;

    /* renamed from: s */
    private float f44468s;

    /* renamed from: t */
    private float f44469t;

    /* renamed from: u */
    private boolean f44470u;

    /* renamed from: v */
    private boolean f44471v;

    /* renamed from: w */
    private Drawable f44472w;

    /* renamed from: x */
    private Drawable f44473x;

    /* renamed from: y */
    private Drawable f44474y;

    /* renamed from: z */
    private int f44475z;

    public interface OnTimeChangedListener {
        void onTimeChanged(HwTimePicker hwTimePicker, GregorianCalendar gregorianCalendar, String str);
    }

    public class aauaf implements HwAdvancedNumberPicker.OnColorChangeListener {
        public aauaf() {
        }

        @Override // com.huawei.uikit.hwadvancednumberpicker.widget.HwAdvancedNumberPicker.OnColorChangeListener
        public void onColorChange(HwAdvancedNumberPicker hwAdvancedNumberPicker) {
        }
    }

    public class akxao extends GestureDetector.SimpleOnGestureListener {
        private akxao() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (motionEvent == null || !HwTimePicker.this.isEnabled()) {
                return false;
            }
            int[] iArr = new int[2];
            HwTimePicker.this.mTimeMinuteSpinner.getLocationOnScreen(iArr);
            if (motionEvent.getRawX() > iArr[0] && motionEvent.getRawX() < r0 + HwTimePicker.this.mTimeMinuteSpinner.getWidth()) {
                float rawY = motionEvent.getRawY();
                int i10 = iArr[1];
                if (rawY > ((HwTimePicker.this.mTimeMinuteSpinner.getHeight() / 2) + i10) - HwTimePicker.this.f44468s && rawY < i10 + (HwTimePicker.this.mTimeMinuteSpinner.getHeight() / 2) + HwTimePicker.this.f44468s) {
                    HwTimePicker.this.f44464o = !r0.f44464o;
                    HwTimePicker.this.m55703q();
                    HwTimePicker.this.m55704r();
                }
            }
            return super.onDoubleTapEvent(motionEvent);
        }

        public /* synthetic */ akxao(HwTimePicker hwTimePicker, bzrwd bzrwdVar) {
            this();
        }
    }

    public static class bqmxo extends View.BaseSavedState {
        public static final Parcelable.Creator<bqmxo> CREATOR = new bzrwd();

        /* renamed from: a */
        private int f44478a;

        /* renamed from: b */
        private int f44479b;

        public class bzrwd implements Parcelable.Creator<bqmxo> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public bqmxo[] newArray(int i10) {
                return new bqmxo[i10];
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public bqmxo createFromParcel(Parcel parcel) {
                return new bqmxo(parcel, (bzrwd) null);
            }
        }

        public /* synthetic */ bqmxo(Parcel parcel, bzrwd bzrwdVar) {
            this(parcel);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            if (parcel != null) {
                parcel.writeInt(this.f44478a);
                parcel.writeInt(this.f44479b);
            }
        }

        public /* synthetic */ bqmxo(Parcelable parcelable, GregorianCalendar gregorianCalendar, bzrwd bzrwdVar) {
            this(parcelable, gregorianCalendar);
        }

        private bqmxo(Parcelable parcelable, GregorianCalendar gregorianCalendar) {
            super(parcelable);
            if (gregorianCalendar != null) {
                this.f44478a = gregorianCalendar.get(11);
                this.f44479b = gregorianCalendar.get(12);
            }
        }

        private bqmxo(Parcel parcel) {
            super(parcel);
            if (parcel != null) {
                this.f44478a = parcel.readInt();
                this.f44479b = parcel.readInt();
            }
        }
    }

    public class bzrwd implements HwAdvancedNumberPicker.OnValueChangeListener {
        public bzrwd() {
        }

        @Override // com.huawei.uikit.hwadvancednumberpicker.widget.HwAdvancedNumberPicker.OnValueChangeListener
        public void onValueChange(HwAdvancedNumberPicker hwAdvancedNumberPicker, int i10, int i11) {
            if (hwAdvancedNumberPicker == null || HwTimePicker.this.f44452c == null || HwTimePicker.this.f44453d == null) {
                return;
            }
            HwTimePicker hwTimePicker = HwTimePicker.this;
            hwTimePicker.f44449B = hwTimePicker.f44448A != 0 ? HwTimePicker.this.f44448A : HwTimePicker.this.f44452c.get(11);
            HwTimePicker.this.f44453d.clear();
            HwTimePicker.this.f44453d.setTimeInMillis(HwTimePicker.this.f44452c.getTimeInMillis());
            HwTimePicker hwTimePicker2 = HwTimePicker.this;
            if (hwAdvancedNumberPicker == hwTimePicker2.mTimeHourSpinner) {
                hwTimePicker2.f44448A = 0;
                String[] displayedValues = HwTimePicker.this.mTimeHourSpinner.getDisplayedValues();
                if (displayedValues != null && displayedValues.length != 0) {
                    HwTimePicker.this.m55662a(i10, i11, displayedValues.length - 1, 1, 11);
                }
            } else if (hwAdvancedNumberPicker == hwTimePicker2.mTimeMinuteSpinner) {
                if (hwTimePicker2.f44464o) {
                    HwTimePicker.this.m55661a(i10, i11, 11, 5);
                } else {
                    HwTimePicker.this.m55661a(i10, i11, 59, 1);
                }
            } else if (hwAdvancedNumberPicker != hwTimePicker2.mAmPmSpinner) {
                Log.w(HwTimePicker.f44414C, "onValueChange: IllegalArgumentException");
                return;
            } else {
                hwTimePicker2.f44453d.set(9, i11);
                HwTimePicker.this.m55675b();
            }
            int i12 = HwTimePicker.this.f44453d.get(11);
            if (!HwTimePicker.this.f44471v && Math.abs(i12 - HwTimePicker.this.f44449B) == 2) {
                HwTimePicker hwTimePicker3 = HwTimePicker.this;
                hwTimePicker3.f44448A = i12 > hwTimePicker3.f44449B ? HwTimePicker.this.f44449B + 1 : HwTimePicker.this.f44449B - 1;
                HwTimePicker.this.f44453d.set(11, HwTimePicker.this.f44449B);
            }
            HwTimePicker hwTimePicker4 = HwTimePicker.this;
            hwTimePicker4.m55676b(hwTimePicker4.f44453d.get(1), HwTimePicker.this.f44453d.get(2), HwTimePicker.this.f44453d.get(5), HwTimePicker.this.f44453d.get(11), HwTimePicker.this.f44453d.get(12));
            HwTimePicker.this.m55704r();
            HwTimePicker.this.m55698l();
        }
    }

    public HwTimePicker(Context context) {
        this(context, null);
    }

    public static long getCurrentMillis() {
        return new GregorianCalendar().getTimeInMillis();
    }

    public static HwTimePicker instantiate(Context context) throws ClassNotFoundException {
        Object objInstantiate = HwWidgetInstantiator.instantiate(context, HwWidgetInstantiator.getDeviceClassName(context, HwTimePicker.class, HwWidgetInstantiator.getCurrentType(context, 11, 1)), HwTimePicker.class);
        if (objInstantiate instanceof HwTimePicker) {
            return (HwTimePicker) objInstantiate;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m55698l() {
        OnTimeChangedListener onTimeChangedListener = this.f44451b;
        if (onTimeChangedListener == null) {
            return;
        }
        onTimeChangedListener.onTimeChanged(this, this.f44452c, null);
    }

    /* renamed from: m */
    private void m55699m() {
        this.f44454e.removeAllViews();
        if (HwLanguageUtils.isChineseLanguageAndRegion(this.f44459j) || Locale.getDefault().getLanguage().contains("bo")) {
            adjustSpinnerMargin(this.mAmPmSpinner, this.mTimeHourSpinner, this.mTimeMinuteSpinner);
            this.f44454e.addView(this.mAmPmSpinner);
            this.f44454e.addView(this.mTimeHourSpinner);
            this.f44454e.addView(this.mTimeMinuteSpinner);
            if (this.mDividerType == 1) {
                if (this.mIs24HoursSystem) {
                    this.mTimeHourSpinner.setSelectionRectDivider(this.f44472w);
                    this.mTimeMinuteSpinner.setSelectionRectDivider(this.f44474y);
                    return;
                } else {
                    this.mAmPmSpinner.setSelectionRectDivider(this.f44472w);
                    this.mTimeHourSpinner.setSelectionRectDivider(this.f44473x);
                    this.mTimeMinuteSpinner.setSelectionRectDivider(this.f44474y);
                    return;
                }
            }
            return;
        }
        adjustSpinnerMargin(this.mTimeHourSpinner, this.mTimeMinuteSpinner, this.mAmPmSpinner);
        this.f44454e.addView(this.mTimeHourSpinner);
        this.f44454e.addView(this.mTimeMinuteSpinner);
        this.f44454e.addView(this.mAmPmSpinner);
        if (this.mDividerType == 1) {
            if (this.mIs24HoursSystem) {
                this.mTimeHourSpinner.setSelectionRectDivider(this.f44472w);
                this.mTimeMinuteSpinner.setSelectionRectDivider(this.f44474y);
            } else {
                this.mTimeHourSpinner.setSelectionRectDivider(this.f44472w);
                this.mTimeMinuteSpinner.setSelectionRectDivider(this.f44473x);
                this.mAmPmSpinner.setSelectionRectDivider(this.f44474y);
            }
        }
    }

    /* renamed from: n */
    private void m55700n() {
        this.f44460k[0] = DateUtils.getAMPMString(0);
        this.f44460k[1] = DateUtils.getAMPMString(1);
    }

    /* renamed from: o */
    private void m55701o() {
        setPickersPercentage(0);
    }

    /* renamed from: p */
    private void m55702p() {
        String str = ",   " + DateUtils.formatDateTime(this.f44459j, this.f44452c.getTimeInMillis(), this.mIs24HoursSystem ? SyncType.WLAN_CHANGE : 65);
        this.mTimeHourSpinner.setAnnouncedSuffix(str);
        this.mTimeMinuteSpinner.setAnnouncedSuffix(str);
        this.mAmPmSpinner.setAnnouncedSuffix(str);
        this.mTimeHourSpinner.setAccessibilityOptimizationEnabled(true);
        this.mTimeMinuteSpinner.setAccessibilityOptimizationEnabled(true);
        this.mAmPmSpinner.setAccessibilityOptimizationEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q */
    public void m55703q() {
        if (m55694h()) {
            if (!this.f44464o) {
                this.mTimeMinuteSpinner.setDisplayedValues(null);
                this.f44462m = (String[]) f44419H.clone();
                this.mTimeMinuteSpinner.setMinValue(0);
                this.mTimeMinuteSpinner.setMaxValue(59);
                this.mTimeMinuteSpinner.setDisplayedValues(this.f44462m);
                this.mTimeMinuteSpinner.setValue(this.f44452c.get(12));
                return;
            }
            this.mTimeMinuteSpinner.setDisplayedValues(null);
            this.f44462m = (String[]) f44420I.clone();
            this.mTimeMinuteSpinner.setMinValue(0);
            this.mTimeMinuteSpinner.setMaxValue(11);
            this.mTimeMinuteSpinner.setDisplayedValues(this.f44462m);
            int iIntValue = new BigDecimal((this.f44452c.get(12) / 5.0f) + "").setScale(0, 4).intValue();
            this.mTimeMinuteSpinner.setValue(iIntValue);
            int i10 = iIntValue * 5;
            boolean z10 = i10 == 60;
            if (this.f44470u || !z10) {
                this.f44452c.set(12, i10);
            } else {
                this.f44452c.set(12, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public void m55704r() {
        if (m55694h()) {
            m55706t();
            this.mTimeHourSpinner.postInvalidate();
            this.mTimeMinuteSpinner.postInvalidate();
            this.mAmPmSpinner.postInvalidate();
        }
    }

    /* renamed from: s */
    private void m55705s() {
        List<Integer> listM55659a;
        if (this.mTimeHourSpinner == null || this.mAmPmSpinner == null || (listM55659a = m55659a(this.f44452c, this.mIs24HoursSystem)) == null || listM55659a.size() == 0) {
            return;
        }
        if (this.mIs24HoursSystem) {
            m55683c(listM55659a);
        } else {
            m55680b(listM55659a);
        }
        this.mTimeHourSpinner.setDisplayedValues(null);
        this.mTimeHourSpinner.setMinValue(0);
        this.mTimeHourSpinner.setDisplayedValues(this.f44461l);
        this.mAmPmSpinner.setValue(this.f44452c.get(9));
    }

    private void setCurrentLocale(Locale locale) {
        if (locale == null || locale.equals(this.f44450a)) {
            return;
        }
        this.f44450a = locale;
        this.f44453d = m55658a(this.f44453d, locale);
        this.f44452c = m55658a(this.f44452c, locale);
    }

    private void setSpinnersMiddleSelector(int i10) {
        HwAdvancedNumberPicker hwAdvancedNumberPicker = this.mAmPmSpinner;
        if (hwAdvancedNumberPicker != null) {
            hwAdvancedNumberPicker.setMiddleStateDrawable(i10);
        }
        HwAdvancedNumberPicker hwAdvancedNumberPicker2 = this.mTimeHourSpinner;
        if (hwAdvancedNumberPicker2 != null) {
            hwAdvancedNumberPicker2.setMiddleStateDrawable(i10);
        }
        HwAdvancedNumberPicker hwAdvancedNumberPicker3 = this.mTimeMinuteSpinner;
        if (hwAdvancedNumberPicker3 != null) {
            hwAdvancedNumberPicker3.setMiddleStateDrawable(i10);
        }
    }

    private void setSpinnersSelectionDividerHeight(int i10) {
        HwAdvancedNumberPicker hwAdvancedNumberPicker = this.mAmPmSpinner;
        if (hwAdvancedNumberPicker != null) {
            hwAdvancedNumberPicker.setSelectionDividerHeight(i10);
        }
        HwAdvancedNumberPicker hwAdvancedNumberPicker2 = this.mTimeHourSpinner;
        if (hwAdvancedNumberPicker2 != null) {
            hwAdvancedNumberPicker2.setSelectionDividerHeight(i10);
        }
        HwAdvancedNumberPicker hwAdvancedNumberPicker3 = this.mTimeMinuteSpinner;
        if (hwAdvancedNumberPicker3 != null) {
            hwAdvancedNumberPicker3.setSelectionDividerHeight(i10);
        }
    }

    /* renamed from: t */
    private void m55706t() {
        this.mTimeHourSpinner.setWrapSelectorWheel(true);
        this.mTimeMinuteSpinner.setWrapSelectorWheel(true);
        m55705s();
        if (this.f44464o) {
            String[] strArr = (String[]) f44420I.clone();
            this.f44462m = strArr;
            this.mTimeMinuteSpinner.setDisplayedValues(strArr);
            int iIntValue = new BigDecimal((this.f44452c.get(12) / 5.0f) + "").setScale(0, 4).intValue();
            this.mTimeMinuteSpinner.setValue(iIntValue);
            int i10 = iIntValue * 5;
            boolean z10 = i10 == 60;
            if (this.f44470u || !z10) {
                this.f44452c.set(12, i10);
            } else {
                this.f44452c.set(12, 0);
            }
        } else {
            String[] strArr2 = (String[]) f44419H.clone();
            this.f44462m = strArr2;
            this.mTimeMinuteSpinner.setDisplayedValues(strArr2);
            this.mTimeMinuteSpinner.setValue(this.f44452c.get(12));
        }
        this.mAmPmSpinner.setDisplayedValues(this.f44460k);
        m55702p();
    }

    public void adjustSpinnerMargin(View view, View view2, View view3) {
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent == null) {
            return true;
        }
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return true;
        }
        GestureDetector gestureDetector = this.f44465p;
        if (gestureDetector == null || !gestureDetector.onTouchEvent(motionEvent)) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    @Deprecated
    public int getDayOfMonth() {
        GregorianCalendar gregorianCalendar = this.f44452c;
        if (gregorianCalendar == null) {
            return 1;
        }
        return gregorianCalendar.get(5);
    }

    public int getHour() {
        int i10;
        if (!this.f44471v && (i10 = this.f44448A) != 0) {
            return i10;
        }
        GregorianCalendar gregorianCalendar = this.f44452c;
        if (gregorianCalendar == null) {
            return 0;
        }
        return gregorianCalendar.get(11);
    }

    public int getMinute() {
        GregorianCalendar gregorianCalendar = this.f44452c;
        if (gregorianCalendar == null) {
            return 0;
        }
        return gregorianCalendar.get(12);
    }

    @Deprecated
    public int getMonth() {
        GregorianCalendar gregorianCalendar = this.f44452c;
        if (gregorianCalendar == null) {
            return 1;
        }
        return gregorianCalendar.get(2);
    }

    public OnTimeChangedListener getOnTimeChangedListener() {
        return this.f44451b;
    }

    public Drawable getSpinnersSelectionDivider() {
        return this.f44457h;
    }

    public int getSpinnersSelectorPaintColor() {
        return this.f44455f;
    }

    public int getSpinnersUnselectedPaintColor() {
        return this.f44456g;
    }

    @Deprecated
    public int getYear() {
        GregorianCalendar gregorianCalendar = this.f44452c;
        if (gregorianCalendar == null) {
            return 1;
        }
        return gregorianCalendar.get(1);
    }

    public void handleConfigrationChange() {
        setDialogStyle();
        boolean z10 = getResources().getConfiguration().orientation == 2;
        this.mTimeHourSpinner.updateSelectorItemCount(z10);
        this.mTimeMinuteSpinner.updateSelectorItemCount(z10);
        this.mAmPmSpinner.updateSelectorItemCount(z10);
    }

    public final void init(GregorianCalendar gregorianCalendar, OnTimeChangedListener onTimeChangedListener) {
        if (gregorianCalendar != null) {
            m55676b(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5), gregorianCalendar.get(11), gregorianCalendar.get(12));
            m55704r();
        }
        if (onTimeChangedListener != null) {
            this.f44451b = onTimeChangedListener;
        }
    }

    public void initAttrs(Context context, AttributeSet attributeSet, int i10) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C8741R.styleable.HwTimePicker, i10, 0);
        try {
            try {
                setEnabled(typedArrayObtainStyledAttributes.getBoolean(C8741R.styleable.HwTimePicker_android_enabled, true));
                if (this.mDividerType == 1) {
                    this.f44472w = typedArrayObtainStyledAttributes.getDrawable(C8741R.styleable.HwTimePicker_hwSelectionDividerRectLeft);
                    this.f44473x = typedArrayObtainStyledAttributes.getDrawable(C8741R.styleable.HwTimePicker_hwSelectionDividerRectCenter);
                    this.f44474y = typedArrayObtainStyledAttributes.getDrawable(C8741R.styleable.HwTimePicker_hwSelectionDividerRectRight);
                } else {
                    setSpinnersSelectionDivider(typedArrayObtainStyledAttributes.getDrawable(C8741R.styleable.HwTimePicker_hwNumberPickerSelectionDivider));
                    setSpinnersSelectionDividerHeight(typedArrayObtainStyledAttributes.getDimensionPixelSize(C8741R.styleable.HwTimePicker_hwNumberPickerSelectionDividerHeight, 0));
                }
                typedArrayObtainStyledAttributes.recycle();
            } catch (Resources.NotFoundException unused) {
                Log.w(f44414C, "TypedArray get resource error");
                typedArrayObtainStyledAttributes.recycle();
            }
        } catch (Throwable th2) {
            typedArrayObtainStyledAttributes.recycle();
            throw th2;
        }
    }

    public void initSelectionDividerType() {
        this.mDividerType = 0;
    }

    public void invalidatePicker() {
        m55701o();
        m55660a();
        m55690f();
        m55706t();
    }

    @Override // android.view.View
    public boolean isEnabled() {
        return this.f44458i;
    }

    @Override // android.view.View
    public boolean isHapticFeedbackEnabled() {
        return super.isHapticFeedbackEnabled();
    }

    public boolean isLinkageScrollEnabled() {
        return this.f44470u;
    }

    public boolean isMinuteIntervalFiveMinute() {
        return this.f44464o;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f44465p = new GestureDetector(getContext().getApplicationContext(), new akxao(this, null));
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        if (configuration == null) {
            return;
        }
        super.onConfigurationChanged(configuration);
        setCurrentLocale(configuration.locale);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent == null) {
            return;
        }
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.getText().add(DateUtils.formatDateTime(this.f44459j, this.f44452c.getTimeInMillis(), 20));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof bqmxo) {
            bqmxo bqmxoVar = (bqmxo) parcelable;
            super.onRestoreInstanceState(bqmxoVar.getSuperState());
            m55676b(1, 0, 1, bqmxoVar.f44478a, bqmxoVar.f44479b);
            m55704r();
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        return new bqmxo(super.onSaveInstanceState(), this.f44452c, null);
    }

    public void setCurrentTime(int i10, int i11) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        updateDate(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5), i10, i11);
    }

    public void setDaylightHourEnabled(boolean z10) {
        this.f44471v = z10;
    }

    public void setDialogStyle() {
        if (this.f44459j == null) {
            return;
        }
        m55701o();
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        if (!m55694h() || this.f44458i == z10) {
            return;
        }
        this.mAmPmSpinner.setEnabled(z10);
        this.mTimeMinuteSpinner.setEnabled(z10);
        this.mTimeHourSpinner.setEnabled(z10);
        this.f44458i = z10;
    }

    public void setFocusTextColor(int i10) {
    }

    @Override // android.view.View
    public void setHapticFeedbackEnabled(boolean z10) {
        super.setHapticFeedbackEnabled(z10);
        HwAdvancedNumberPicker hwAdvancedNumberPicker = this.mAmPmSpinner;
        if (hwAdvancedNumberPicker == null || this.mTimeHourSpinner == null || this.mTimeMinuteSpinner == null) {
            return;
        }
        hwAdvancedNumberPicker.setHapticFeedbackEnabled(z10);
        this.mTimeHourSpinner.setHapticFeedbackEnabled(z10);
        this.mTimeMinuteSpinner.setHapticFeedbackEnabled(z10);
    }

    public void setIs24HoursSystem(boolean z10) {
        if (this.mIs24HoursSystem == z10) {
            return;
        }
        this.mIs24HoursSystem = z10;
        m55701o();
        m55660a();
        m55690f();
        m55706t();
    }

    public void setIsMinuteIntervalFiveMinute(boolean z10) {
        this.f44464o = z10;
        GregorianCalendar gregorianCalendar = this.f44452c;
        if (gregorianCalendar != null) {
            gregorianCalendar.setTimeInMillis(getCurrentMillis());
        } else {
            this.f44452c = new GregorianCalendar();
        }
        m55703q();
        m55704r();
    }

    public void setLinkageScrollEnabled(boolean z10) {
        this.f44470u = z10;
    }

    public void setOnTimeChangedListener(OnTimeChangedListener onTimeChangedListener) {
        this.f44451b = onTimeChangedListener;
    }

    public void setPickersPercentage(int i10) {
        if (m55694h()) {
            if (this.mIs24HoursSystem) {
                this.mAmPmSpinner.setVisibility(8);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
                layoutParams.weight = 1.0f;
                this.mTimeMinuteSpinner.setLayoutParams(layoutParams);
                this.mTimeHourSpinner.setLayoutParams(layoutParams);
                return;
            }
            this.mAmPmSpinner.setVisibility(0);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -1);
            layoutParams2.weight = 1.0f;
            this.mTimeMinuteSpinner.setLayoutParams(layoutParams2);
            this.mTimeHourSpinner.setLayoutParams(layoutParams2);
            this.mAmPmSpinner.setLayoutParams(layoutParams2);
        }
    }

    public void setSpinnersSelectionDivider(Drawable drawable) {
        Drawable drawable2 = this.f44457h;
        if (drawable2 == null || !drawable2.equals(drawable)) {
            this.f44457h = drawable;
            HwAdvancedNumberPicker hwAdvancedNumberPicker = this.mAmPmSpinner;
            if (hwAdvancedNumberPicker != null) {
                hwAdvancedNumberPicker.setSelectionDivider(drawable);
            }
            HwAdvancedNumberPicker hwAdvancedNumberPicker2 = this.mTimeHourSpinner;
            if (hwAdvancedNumberPicker2 != null) {
                hwAdvancedNumberPicker2.setSelectionDivider(drawable);
            }
            HwAdvancedNumberPicker hwAdvancedNumberPicker3 = this.mTimeMinuteSpinner;
            if (hwAdvancedNumberPicker3 != null) {
                hwAdvancedNumberPicker3.setSelectionDivider(drawable);
            }
        }
    }

    public void setSpinnersSelectorPaintColor(int i10) {
        if (this.f44455f == i10) {
            return;
        }
        this.f44455f = i10;
        HwAdvancedNumberPicker hwAdvancedNumberPicker = this.mAmPmSpinner;
        if (hwAdvancedNumberPicker != null) {
            hwAdvancedNumberPicker.setSelectorPaintColor(i10);
        }
        HwAdvancedNumberPicker hwAdvancedNumberPicker2 = this.mTimeHourSpinner;
        if (hwAdvancedNumberPicker2 != null) {
            hwAdvancedNumberPicker2.setSelectorPaintColor(i10);
        }
        HwAdvancedNumberPicker hwAdvancedNumberPicker3 = this.mTimeMinuteSpinner;
        if (hwAdvancedNumberPicker3 != null) {
            hwAdvancedNumberPicker3.setSelectorPaintColor(i10);
        }
    }

    public final void setSpinnersShown(boolean z10) {
        LinearLayout linearLayout = this.f44454e;
        if (linearLayout != null) {
            linearLayout.setVisibility(z10 ? 0 : 8);
        }
    }

    public void setSpinnersUnselectedPaintColor(int i10) {
        if (this.f44456g == i10) {
            return;
        }
        this.f44456g = i10;
        HwAdvancedNumberPicker hwAdvancedNumberPicker = this.mAmPmSpinner;
        if (hwAdvancedNumberPicker != null) {
            hwAdvancedNumberPicker.setSecondaryPaintColor(i10);
        }
        HwAdvancedNumberPicker hwAdvancedNumberPicker2 = this.mTimeHourSpinner;
        if (hwAdvancedNumberPicker2 != null) {
            hwAdvancedNumberPicker2.setSecondaryPaintColor(i10);
        }
        HwAdvancedNumberPicker hwAdvancedNumberPicker3 = this.mTimeMinuteSpinner;
        if (hwAdvancedNumberPicker3 != null) {
            hwAdvancedNumberPicker3.setSecondaryPaintColor(i10);
        }
    }

    public void updateDate(int i10, int i11, int i12, int i13, int i14) {
        if (m55671a(i13, i14)) {
            m55676b(i10, i11, i12, i13, i14);
            this.f44475z = -1;
            m55704r();
            m55698l();
        }
    }

    public HwTimePicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C8741R.attr.hwTimePickerStyle);
    }

    /* renamed from: c */
    private void m55681c() {
        this.f44452c.setTimeInMillis(getCurrentMillis());
    }

    /* renamed from: d */
    private void m55685d() {
        this.f44467r = new aauaf();
    }

    /* renamed from: e */
    private void m55687e() {
        this.f44466q = new bzrwd();
    }

    /* renamed from: f */
    private void m55690f() {
        this.f44454e = (LinearLayout) findViewById(C8741R.id.hwtimepicker_ll);
        HwAdvancedNumberPicker hwAdvancedNumberPicker = (HwAdvancedNumberPicker) findViewById(C8741R.id.hwtimepicker_ampm);
        this.mAmPmSpinner = hwAdvancedNumberPicker;
        hwAdvancedNumberPicker.setOnValueChangedListener(this.f44466q);
        this.mAmPmSpinner.setOnLongPressUpdateInterval(100L);
        this.mAmPmSpinner.setDisplayedValues(this.f44460k);
        this.mAmPmSpinner.setMaxValue(1);
        this.mAmPmSpinner.setMinValue(0);
        if (this.mIs24HoursSystem) {
            this.mAmPmSpinner.setVisibility(8);
        }
        HwAdvancedNumberPicker hwAdvancedNumberPicker2 = (HwAdvancedNumberPicker) findViewById(C8741R.id.hwtimepicker_hour);
        this.mTimeHourSpinner = hwAdvancedNumberPicker2;
        hwAdvancedNumberPicker2.setOnLongPressUpdateInterval(100L);
        this.mTimeHourSpinner.setOnValueChangedListener(this.f44466q);
        if (this.mIs24HoursSystem) {
            this.mTimeHourSpinner.setMaxValue(23);
            this.mTimeHourSpinner.setMinValue(0);
        } else {
            this.mTimeHourSpinner.setMaxValue(11);
            this.mTimeHourSpinner.setMinValue(0);
        }
        HwAdvancedNumberPicker hwAdvancedNumberPicker3 = this.mTimeHourSpinner;
        HwFormatter hwFormatter = PickerHelper.TWO_DIGIT_FORMATTER;
        hwAdvancedNumberPicker3.setFormatter(hwFormatter);
        HwAdvancedNumberPicker hwAdvancedNumberPicker4 = (HwAdvancedNumberPicker) findViewById(C8741R.id.hwtimepicker_minute);
        this.mTimeMinuteSpinner = hwAdvancedNumberPicker4;
        hwAdvancedNumberPicker4.setOnLongPressUpdateInterval(100L);
        this.mTimeMinuteSpinner.setOnValueChangedListener(this.f44466q);
        if (this.f44464o) {
            this.mTimeMinuteSpinner.setMaxValue(11);
        } else {
            this.mTimeMinuteSpinner.setMaxValue(59);
        }
        this.mTimeMinuteSpinner.setMinValue(0);
        this.mTimeMinuteSpinner.setFormatter(hwFormatter);
        this.mAmPmSpinner.setFlingAnnounceType(4);
        this.mTimeHourSpinner.setFlingAnnounceType(5);
        this.mTimeMinuteSpinner.setFlingAnnounceType(5);
        this.mAmPmSpinner.setIsSupportRichTap(false);
        setSpinnersShown(true);
    }

    /* renamed from: g */
    private boolean m55692g() {
        return HwWidgetInstantiator.getCurrentType(this.f44459j) != 1 || Float.compare(this.f44469t, 1.75f) < 0 || AuxiliaryHelper.isMultiWindowActivity(this.f44459j);
    }

    /* renamed from: h */
    private boolean m55694h() {
        return (this.mTimeMinuteSpinner == null || this.mTimeHourSpinner == null || this.mAmPmSpinner == null) ? false : true;
    }

    /* renamed from: i */
    public void m55707i() {
        if (m55692g()) {
            return;
        }
        for (HwAdvancedNumberPicker hwAdvancedNumberPicker : this.f44463n) {
            hwAdvancedNumberPicker.setUnselectedItemTextSize(f44445k0);
            hwAdvancedNumberPicker.setSelectedItemTextSize(f44443i0);
            hwAdvancedNumberPicker.setSelectedItemHeight(f44444j0);
        }
    }

    /* renamed from: j */
    public void m55708j() {
        if (m55692g()) {
            return;
        }
        this.mTimeHourSpinner.setVisibility(0);
        this.mTimeMinuteSpinner.setVisibility(0);
        this.mAmPmSpinner.setVisibility(8);
    }

    /* renamed from: k */
    public void m55709k() {
        if (m55692g()) {
            return;
        }
        if (this.mIs24HoursSystem) {
            this.mAmPmSpinner.setVisibility(8);
            this.mTimeHourSpinner.setVisibility(0);
            this.mTimeMinuteSpinner.setVisibility(0);
        } else {
            this.mAmPmSpinner.setVisibility(0);
            this.mTimeHourSpinner.setVisibility(8);
            this.mTimeMinuteSpinner.setVisibility(8);
        }
    }

    public HwTimePicker(Context context, AttributeSet attributeSet, int i10) {
        super(m55656a(context, i10), attributeSet, i10);
        this.f44458i = true;
        this.f44459j = getContext();
        this.f44460k = new String[2];
        this.f44463n = new ArrayList(4);
        this.f44464o = true;
        this.f44471v = true;
        this.f44475z = -1;
        Context context2 = super.getContext();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{C8741R.attr.hwTheme});
        if (typedArrayObtainStyledAttributes != null) {
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
            context2 = resourceId != 0 ? new ContextThemeWrapper(super.getContext(), resourceId) : context2;
            typedArrayObtainStyledAttributes.recycle();
        }
        m55666a(context2);
        m55677b(context2);
        m55667a(context2, attributeSet, i10);
        m55660a();
    }

    /* renamed from: c */
    private void m55683c(List<Integer> list) {
        int i10;
        if (list == null || list.size() == 0) {
            return;
        }
        int size = list.size();
        if (this.f44471v && size == 25) {
            m55686d(list);
            this.mTimeHourSpinner.setMaxValue(size - 1);
            this.mTimeHourSpinner.setValue(this.f44475z);
            return;
        }
        this.f44461l = (String[]) f44418G.clone();
        this.mTimeHourSpinner.setMaxValue(23);
        if (!this.f44471v && (i10 = this.f44448A) != 0) {
            this.mTimeHourSpinner.setValue(i10);
        } else {
            this.mTimeHourSpinner.setValue(this.f44452c.get(11));
        }
        if (size == 25) {
            m55670a(list);
        }
    }

    /* renamed from: d */
    private void m55686d(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        int size = list.size();
        this.f44461l = new String[size];
        for (int i10 = 0; i10 < size; i10++) {
            this.f44461l[i10] = this.mIs24HoursSystem ? f44418G[list.get(i10).intValue()] : f44417F[list.get(i10).intValue()];
        }
        m55670a(list);
    }

    /* renamed from: b */
    private void m55677b(Context context) {
        LayoutInflater layoutInflater = (LayoutInflater) this.f44459j.getSystemService("layout_inflater");
        if (layoutInflater != null) {
            layoutInflater.cloneInContext(context).inflate(C8741R.layout.hwtimepicker, (ViewGroup) this, true);
            m55687e();
            m55685d();
            m55681c();
            m55690f();
            init(this.f44452c, null);
        }
    }

    /* renamed from: a */
    private static Context m55656a(Context context, int i10) {
        return HwWidgetCompat.wrapContext(context, i10, C8741R.style.Theme_Emui_HwTimePicker);
    }

    /* renamed from: a */
    private void m55666a(Context context) {
        this.f44468s = getResources().getDimension(C8741R.dimen.hwadvancednumberpicker_min_height_half);
        this.mIs24HoursSystem = DateFormat.is24HourFormat(context);
        this.f44469t = AuxiliaryHelper.getFontSize(context);
        setCurrentLocale(Locale.getDefault());
        m55700n();
        initSelectionDividerType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m55675b() {
        List<Integer> listM55659a = m55659a(this.f44453d, this.mIs24HoursSystem);
        if (listM55659a == null || listM55659a.size() == 0) {
            return;
        }
        int i10 = this.f44453d.get(this.mIs24HoursSystem ? 11 : 10);
        if (i10 < 0 || i10 >= listM55659a.size()) {
            return;
        }
        if (listM55659a.get(i10).intValue() < i10) {
            i10++;
        }
        this.f44475z = i10;
    }

    /* renamed from: a */
    private void m55667a(Context context, AttributeSet attributeSet, int i10) {
        initAttrs(context, attributeSet, i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m55662a(int i10, int i11, int i12, int i13, int i14) {
        this.f44475z = i11;
        boolean z10 = this.f44470u;
        if (z10 && i11 == 0 && i10 == i12) {
            this.f44453d.add(i14, i13);
            return;
        }
        if (z10 && i10 == 0 && i11 == i12) {
            this.f44453d.add(i14, -i13);
            int iM55674b = m55674b(this.f44453d, this.mIs24HoursSystem);
            boolean z11 = this.f44453d.get(9) != 1 && iM55674b == 13;
            boolean z12 = iM55674b == 25;
            if (z11 || z12) {
                this.f44475z++;
                return;
            }
            return;
        }
        m55663a(i10, i11, i12, i13, m55659a(this.f44453d, this.mIs24HoursSystem));
    }

    /* renamed from: b */
    private int m55674b(GregorianCalendar gregorianCalendar, boolean z10) {
        List<Integer> listM55659a = m55659a(gregorianCalendar, z10);
        if (listM55659a != null) {
            return listM55659a.size();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m55676b(int i10, int i11, int i12, int i13, int i14) {
        GregorianCalendar gregorianCalendar = this.f44452c;
        if (gregorianCalendar != null) {
            gregorianCalendar.set(i10, i11, i12, i13, i14);
        }
    }

    /* renamed from: b */
    private void m55680b(List<Integer> list) {
        int i10;
        if (list == null || list.size() == 0) {
            return;
        }
        int size = list.size();
        if (this.f44452c.get(9) != 1) {
            if (this.f44471v && size == 13) {
                m55686d(list);
                this.mTimeHourSpinner.setMaxValue(size - 1);
                this.mTimeHourSpinner.setValue(this.f44475z);
                return;
            }
            this.f44461l = (String[]) f44417F.clone();
            this.mTimeHourSpinner.setMaxValue(11);
            if (!this.f44471v && (i10 = this.f44448A) != 0) {
                this.mTimeHourSpinner.setValue(i10);
            } else {
                this.mTimeHourSpinner.setValue(this.f44452c.get(10));
            }
            if (size == 13) {
                m55670a(list);
                return;
            }
            return;
        }
        this.f44461l = (String[]) f44417F.clone();
        this.mTimeHourSpinner.setMaxValue(11);
        this.mTimeHourSpinner.setValue(this.f44452c.get(10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m55661a(int i10, int i11, int i12, int i13) {
        if (!this.f44470u) {
            this.f44453d.set(12, i11 * i13);
            return;
        }
        List<Integer> listM55659a = m55659a(this.f44453d, this.mIs24HoursSystem);
        if (listM55659a == null || listM55659a.size() == 0) {
            return;
        }
        int size = listM55659a.size();
        boolean z10 = this.f44453d.get(9) != 1 && size == 13;
        if (i11 == 0 && i10 == i12) {
            this.f44448A = 0;
            m55665a(i13, listM55659a, size, z10);
        } else if (i10 == 0 && i11 == i12) {
            this.f44448A = 0;
            m55664a(i12, i13, listM55659a, size, z10);
        } else {
            this.f44453d.add(12, (i11 - i10) * i13);
        }
    }

    /* renamed from: a */
    private void m55665a(int i10, List<Integer> list, int i11, boolean z10) {
        int i12;
        int i13;
        if (list == null || list.size() == 0) {
            return;
        }
        if ((z10 || i11 == 25) && (i12 = this.f44475z) != i11 - 1) {
            if (i12 < i13) {
                this.f44475z = i12 + 1;
            }
            int i14 = this.f44475z;
            if (list.get(i14).intValue() != i14) {
                i14--;
            }
            this.f44453d.set(this.mIs24HoursSystem ? 11 : 10, i14);
            this.f44453d.set(12, 0);
            return;
        }
        this.f44453d.add(12, i10);
        this.f44475z = -1;
    }

    /* renamed from: a */
    private void m55664a(int i10, int i11, List<Integer> list, int i12, boolean z10) {
        int i13;
        if (list == null || list.size() == 0) {
            return;
        }
        if ((z10 || i12 == 25) && (i13 = this.f44475z) != 0) {
            if (i13 > 0) {
                this.f44475z = i13 - 1;
            }
            int i14 = this.f44475z;
            if (list.get(i14).intValue() != i14) {
                i14--;
            }
            this.f44453d.set(this.mIs24HoursSystem ? 11 : 10, i14);
            this.f44453d.set(12, i10 * i11);
            return;
        }
        this.f44453d.add(12, -i11);
        this.f44475z = -1;
    }

    /* renamed from: a */
    private void m55663a(int i10, int i11, int i12, int i13, List<Integer> list) {
        if (!this.mIs24HoursSystem && this.f44453d.get(9) == 1) {
            this.f44453d.set(11, (i11 * i13) + 12);
            return;
        }
        if (list == null || list.size() == 0) {
            return;
        }
        int size = list.size();
        if (size != 11) {
            if (size != 13) {
                if (size != 23) {
                    if (size != 25) {
                        if (!this.f44470u) {
                            this.f44453d.set(11, i11 * i13);
                            return;
                        } else {
                            this.f44453d.add(11, (i11 - i10) * i13);
                            return;
                        }
                    }
                }
            }
            if (this.f44471v) {
                this.f44453d.set(11, list.get(i11).intValue() == i11 ? i11 * i13 : i11 - i13);
                return;
            } else {
                this.f44453d.set(11, i11 * i13);
                return;
            }
        }
        if ((i11 == 0 && i10 == i12) || (i10 == 0 && i11 == i12)) {
            this.f44453d.set(11, i11 * i13);
        } else {
            this.f44453d.add(11, (i11 - i10) * i13);
        }
    }

    /* renamed from: a */
    private List<Integer> m55659a(GregorianCalendar gregorianCalendar, boolean z10) {
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar();
        ArrayList arrayList = new ArrayList();
        if (gregorianCalendar != null) {
            gregorianCalendar2.set(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5), 0, 0);
            int i10 = gregorianCalendar2.get(z10 ? 11 : 10);
            do {
                arrayList.add(Integer.valueOf(i10));
                gregorianCalendar2.add(z10 ? 11 : 10, 1);
                i10 = gregorianCalendar2.get(z10 ? 11 : 10);
            } while (i10 != 0);
        }
        return arrayList;
    }

    /* renamed from: a */
    private void m55660a() {
        this.f44463n.add(this.mTimeHourSpinner);
        this.f44463n.add(this.mTimeMinuteSpinner);
        this.f44463n.add(this.mAmPmSpinner);
        this.mTimeHourSpinner.setOnColorChangeListener(this.f44467r);
        this.mTimeMinuteSpinner.setOnColorChangeListener(this.f44467r);
        this.mAmPmSpinner.setOnColorChangeListener(this.f44467r);
        String language = Locale.getDefault().getLanguage();
        if (!language.contains(Constants.AR_CACHE) && !language.contains("fa") && !language.contains("iw")) {
            m55699m();
        }
        if (this.f44454e != null && HwLanguageUtils.isRtlLocale(this)) {
            this.f44454e.removeAllViews();
            adjustSpinnerMargin(this.mTimeMinuteSpinner, this.mTimeHourSpinner, this.mAmPmSpinner);
            this.f44454e.addView(this.mTimeMinuteSpinner);
            this.f44454e.addView(this.mTimeHourSpinner);
            this.f44454e.addView(this.mAmPmSpinner);
            if (this.mDividerType == 1) {
                if (this.mIs24HoursSystem) {
                    this.mTimeMinuteSpinner.setSelectionRectDivider(this.f44472w);
                    this.mTimeHourSpinner.setSelectionRectDivider(this.f44474y);
                } else {
                    this.mTimeMinuteSpinner.setSelectionRectDivider(this.f44472w);
                    this.mTimeHourSpinner.setSelectionRectDivider(this.f44473x);
                    this.mAmPmSpinner.setSelectionRectDivider(this.f44474y);
                }
            }
        }
        if (this.f44454e != null && (language.contains(Constants.URDU_LANG) || language.contains("ug"))) {
            this.f44454e.removeAllViews();
            adjustSpinnerMargin(this.mAmPmSpinner, this.mTimeMinuteSpinner, this.mTimeHourSpinner);
            this.f44454e.addView(this.mAmPmSpinner);
            this.f44454e.addView(this.mTimeMinuteSpinner);
            this.f44454e.addView(this.mTimeHourSpinner);
            if (this.mDividerType == 1) {
                if (this.mIs24HoursSystem) {
                    this.mTimeMinuteSpinner.setSelectionRectDivider(this.f44472w);
                    this.mTimeHourSpinner.setSelectionRectDivider(this.f44474y);
                } else {
                    this.mAmPmSpinner.setSelectionRectDivider(this.f44472w);
                    this.mTimeMinuteSpinner.setSelectionRectDivider(this.f44473x);
                    this.mTimeHourSpinner.setSelectionRectDivider(this.f44474y);
                }
            }
        }
        m55701o();
    }

    /* renamed from: a */
    private GregorianCalendar m55658a(GregorianCalendar gregorianCalendar, Locale locale) {
        if (gregorianCalendar == null && locale == null) {
            return new GregorianCalendar(Locale.ENGLISH);
        }
        if (gregorianCalendar == null) {
            return new GregorianCalendar(locale);
        }
        long timeInMillis = gregorianCalendar.getTimeInMillis();
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar(locale);
        gregorianCalendar2.setTimeInMillis(timeInMillis);
        return gregorianCalendar2;
    }

    /* renamed from: a */
    private boolean m55671a(int i10, int i11) {
        return (this.f44452c.get(11) == i10 && this.f44452c.get(12) == i11) ? false : true;
    }

    /* renamed from: a */
    private void m55670a(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        int i10 = this.f44452c.get(this.mIs24HoursSystem ? 11 : 10);
        if (list.get(i10).intValue() < i10) {
            i10++;
        }
        if (this.f44475z == -1) {
            this.f44475z = i10;
        }
    }
}
