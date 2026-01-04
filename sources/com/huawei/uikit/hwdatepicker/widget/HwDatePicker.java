package com.huawei.uikit.hwdatepicker.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.text.format.DateUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwLanguageUtils;
import com.huawei.uikit.hwadvancednumberpicker.widget.HwAdvancedNumberPicker;
import com.huawei.uikit.hwcheckbox.widget.HwCheckBox;
import com.huawei.uikit.hwdatepicker.C8710R;
import com.huawei.uikit.hwdatepicker.utils.HwConstants;
import com.huawei.uikit.hwdatepicker.utils.HwDatePickerUtils;
import com.huawei.uikit.hwdatepicker.utils.HwICU;
import com.huawei.uikit.hwlunar.utils.HwLunarCalendar;
import com.huawei.uikit.hwlunar.utils.HwLunarDataOperate;
import com.huawei.uikit.hwlunar.utils.HwLunarUtils;
import com.huawei.uikit.hwresources.utils.AuxiliaryHelper;
import com.huawei.uikit.hwresources.utils.HwWidgetCompat;
import com.huawei.uikit.hwresources.utils.HwWidgetInstantiator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes7.dex */
public class HwDatePicker extends LinearLayout {

    /* renamed from: e0 */
    private static final String f42159e0 = "HwDatePicker";

    /* renamed from: f0 */
    private static final String f42160f0 = ", ";

    /* renamed from: g0 */
    private static final String f42161g0 = "  ";

    /* renamed from: h0 */
    private static final int f42162h0 = 3;

    /* renamed from: i0 */
    private static final int f42163i0 = -1;

    /* renamed from: j0 */
    private static final int f42164j0 = 0;

    /* renamed from: k0 */
    private static final int f42165k0 = 1;

    /* renamed from: l0 */
    private static final int f42166l0 = 2;

    /* renamed from: m0 */
    private static final float f42167m0 = 35.0f;

    /* renamed from: n0 */
    private static final float f42168n0 = 48.0f;

    /* renamed from: o0 */
    private static final float f42169o0 = 28.0f;

    /* renamed from: p0 */
    private static final float f42170p0 = 32.0f;

    /* renamed from: q0 */
    private static final float f42171q0 = 16.0f;

    /* renamed from: A */
    private String f42172A;

    /* renamed from: B */
    private String f42173B;

    /* renamed from: C */
    private String f42174C;

    /* renamed from: D */
    private HwLunarDataOperate f42175D;

    /* renamed from: E */
    private String[] f42176E;

    /* renamed from: F */
    private String[] f42177F;

    /* renamed from: G */
    private String[] f42178G;

    /* renamed from: H */
    private String[] f42179H;

    /* renamed from: I */
    private String[] f42180I;

    /* renamed from: J */
    private String[] f42181J;

    /* renamed from: K */
    private String[] f42182K;

    /* renamed from: L */
    private String[] f42183L;

    /* renamed from: M */
    private String[] f42184M;

    /* renamed from: N */
    private String[] f42185N;

    /* renamed from: O */
    private String f42186O;

    /* renamed from: P */
    private String f42187P;

    /* renamed from: Q */
    private String[] f42188Q;

    /* renamed from: R */
    private Context f42189R;

    /* renamed from: S */
    private List<HwAdvancedNumberPicker> f42190S;

    /* renamed from: T */
    private int f42191T;

    /* renamed from: U */
    private int f42192U;

    /* renamed from: V */
    private boolean f42193V;

    /* renamed from: W */
    private float f42194W;

    /* renamed from: a */
    private LinearLayout f42195a;

    /* renamed from: a0 */
    private boolean f42196a0;

    /* renamed from: b */
    private LinearLayout f42197b;

    /* renamed from: b0 */
    private Drawable f42198b0;

    /* renamed from: c */
    private LinearLayout f42199c;

    /* renamed from: c0 */
    private Drawable f42200c0;

    /* renamed from: d */
    private LinearLayout f42201d;

    /* renamed from: d0 */
    private Drawable f42202d0;

    /* renamed from: e */
    private HwCheckBox f42203e;

    /* renamed from: f */
    private Locale f42204f;

    /* renamed from: g */
    private OnDateChangedListener f42205g;

    /* renamed from: h */
    private String[] f42206h;

    /* renamed from: i */
    private String[] f42207i;

    /* renamed from: j */
    private int f42208j;

    /* renamed from: k */
    private GregorianCalendar f42209k;

    /* renamed from: l */
    private GregorianCalendar f42210l;

    /* renamed from: m */
    private GregorianCalendar f42211m;
    protected HwAdvancedNumberPicker mDaySpinner;
    protected int mDividerType;
    protected HwAdvancedNumberPicker mMonthSpinner;
    protected HwAdvancedNumberPicker mYearSpinner;

    /* renamed from: n */
    private GregorianCalendar f42212n;

    /* renamed from: o */
    private int f42213o;

    /* renamed from: p */
    private int f42214p;

    /* renamed from: q */
    private int f42215q;

    /* renamed from: r */
    private int f42216r;

    /* renamed from: s */
    private Drawable f42217s;

    /* renamed from: t */
    private boolean f42218t;

    /* renamed from: u */
    private boolean f42219u;

    /* renamed from: v */
    private boolean f42220v;

    /* renamed from: w */
    private boolean f42221w;

    /* renamed from: x */
    private boolean f42222x;

    /* renamed from: y */
    private boolean f42223y;

    /* renamed from: z */
    private HwLunarCalendar f42224z;

    public interface OnDateChangedListener {
        void onDateChanged(HwDatePicker hwDatePicker, int i10, int i11, int i12, GregorianCalendar gregorianCalendar);
    }

    public class aauaf implements HwAdvancedNumberPicker.OnValueChangeListener {
        public aauaf() {
        }

        @Override // com.huawei.uikit.hwadvancednumberpicker.widget.HwAdvancedNumberPicker.OnValueChangeListener
        public void onValueChange(HwAdvancedNumberPicker hwAdvancedNumberPicker, int i10, int i11) {
            HwDatePicker.this.m54256b(hwAdvancedNumberPicker, i10, i11);
            HwDatePicker hwDatePicker = HwDatePicker.this;
            hwDatePicker.m54265c(hwDatePicker.f42209k.get(1), HwDatePicker.this.f42209k.get(2), HwDatePicker.this.f42209k.get(5));
            HwDatePicker.this.m54296v();
            HwDatePicker.this.m54288n();
        }
    }

    public class akxao implements CompoundButton.OnCheckedChangeListener {
        public akxao() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
            HwDatePicker.this.f42220v = !z10;
            if (HwLanguageUtils.isChineseLanguageAndRegion(HwDatePicker.this.f42189R)) {
                HwDatePicker.this.m54278f();
            }
            HwDatePicker.this.m54296v();
            HwDatePicker.this.m54288n();
        }
    }

    public static class avpbg extends View.BaseSavedState {
        public static final Parcelable.Creator<avpbg> CREATOR = new bzrwd();

        /* renamed from: a */
        private final int f42227a;

        /* renamed from: b */
        private final int f42228b;

        /* renamed from: c */
        private final int f42229c;

        public class bzrwd implements Parcelable.Creator<avpbg> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public avpbg createFromParcel(Parcel parcel) {
                return new avpbg(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public avpbg[] newArray(int i10) {
                return new avpbg[i10];
            }
        }

        public /* synthetic */ avpbg(Parcel parcel, bzrwd bzrwdVar) {
            this(parcel);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            if (parcel != null) {
                super.writeToParcel(parcel, i10);
                parcel.writeInt(this.f42227a);
                parcel.writeInt(this.f42228b);
                parcel.writeInt(this.f42229c);
            }
        }

        public /* synthetic */ avpbg(Parcelable parcelable, int i10, int i11, int i12, bzrwd bzrwdVar) {
            this(parcelable, i10, i11, i12);
        }

        private avpbg(Parcelable parcelable, int i10, int i11, int i12) {
            super(parcelable);
            this.f42227a = i10;
            this.f42228b = i11;
            this.f42229c = i12;
        }

        private avpbg(Parcel parcel) {
            super(parcel);
            this.f42227a = parcel.readInt();
            this.f42228b = parcel.readInt();
            this.f42229c = parcel.readInt();
        }
    }

    public class bqmxo implements View.OnClickListener {
        public bqmxo() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            HwDatePicker.this.f42203e.setChecked(!HwDatePicker.this.f42203e.isChecked());
        }
    }

    public class bzrwd implements HwAdvancedNumberPicker.OnColorChangeListener {
        public bzrwd() {
        }

        @Override // com.huawei.uikit.hwadvancednumberpicker.widget.HwAdvancedNumberPicker.OnColorChangeListener
        public void onColorChange(HwAdvancedNumberPicker hwAdvancedNumberPicker) {
        }
    }

    public HwDatePicker(Context context) {
        this(context, null);
    }

    /* renamed from: A */
    private void m54224A() {
        if (this.f42221w) {
            m54225B();
        } else {
            m54226C();
        }
    }

    /* renamed from: B */
    private void m54225B() {
        m54294t();
        this.mYearSpinner.setDisplayedValues(null);
        this.mYearSpinner.setMinValue(this.f42210l.get(1));
        this.mYearSpinner.setMaxValue(this.f42211m.get(1));
        this.mYearSpinner.setWrapSelectorWheel(false);
        this.mYearSpinner.setValue(this.f42212n.get(1));
        this.mMonthSpinner.setValue(this.f42212n.get(2));
        this.mDaySpinner.setValue(this.f42212n.get(5));
    }

    /* renamed from: C */
    private void m54226C() {
        if (this.f42222x) {
            m54228E();
        } else {
            m54227D();
        }
    }

    /* renamed from: D */
    private void m54227D() {
        this.mYearSpinner.setDisplayedValues(null);
        this.mYearSpinner.setMinValue(this.f42210l.get(1));
        this.mYearSpinner.setMaxValue(this.f42214p);
        String[] displayedValues = this.mYearSpinner.getDisplayedValues();
        displayedValues[displayedValues.length - 1] = "-- --";
        this.mYearSpinner.setDisplayedValues(displayedValues);
        this.mYearSpinner.setWrapSelectorWheel(false);
        this.mMonthSpinner.setDisplayedValues(null);
        this.mMonthSpinner.setDisplayedValues((String[]) Arrays.copyOfRange(this.f42206h, this.mMonthSpinner.getMinValue(), this.mMonthSpinner.getMaxValue() + 1));
        this.mDaySpinner.setDisplayedValues(null);
        int[] iArr = HwDatePickerUtils.DAYS_OF_MONTH_WESTERN;
        int i10 = iArr[this.f42191T % iArr.length];
        String[] strArr = new String[i10];
        System.arraycopy(this.f42207i, 0, strArr, 0, i10);
        this.mDaySpinner.setMinValue(1);
        this.mDaySpinner.setMaxValue(i10);
        this.mDaySpinner.setDisplayedValues(strArr);
        this.mYearSpinner.setValue(this.f42214p);
        this.mMonthSpinner.setValue(this.f42191T);
        this.mDaySpinner.setValue(this.f42192U);
    }

    /* renamed from: E */
    private void m54228E() {
        m54294t();
        this.mYearSpinner.setDisplayedValues(null);
        this.mYearSpinner.setMinValue(this.f42210l.get(1));
        this.mYearSpinner.setMaxValue(this.f42214p);
        String[] displayedValues = this.mYearSpinner.getDisplayedValues();
        displayedValues[displayedValues.length - 1] = "-- --";
        this.mYearSpinner.setDisplayedValues(displayedValues);
        this.mYearSpinner.setWrapSelectorWheel(false);
        this.mYearSpinner.setValue(this.f42212n.get(1));
        this.mMonthSpinner.setValue(this.f42212n.get(2));
        this.mDaySpinner.setValue(this.f42212n.get(5));
    }

    /* renamed from: F */
    private void m54229F() {
        this.mDaySpinner.setDisplayedValues(null);
        this.mDaySpinner.setMinValue(1);
        this.mDaySpinner.setMaxValue(this.f42212n.getActualMaximum(5));
        this.mDaySpinner.setWrapSelectorWheel(true);
        this.mMonthSpinner.setDisplayedValues(null);
        this.mMonthSpinner.setMinValue(0);
        this.mMonthSpinner.setMaxValue(11);
        this.mMonthSpinner.setWrapSelectorWheel(true);
    }

    /* renamed from: b */
    private boolean m54258b(int i10, int i11, int i12) {
        return i10 == i12 && i11 == 0;
    }

    /* renamed from: e */
    private boolean m54276e(int i10, int i11, int i12) {
        return i10 == 0 && i11 == i12;
    }

    /* renamed from: g */
    private void m54281g() {
        this.f42199c = (LinearLayout) findViewById(C8710R.id.hwdatepicker_lunar_or_western);
        HwCheckBox hwCheckBox = (HwCheckBox) findViewById(C8710R.id.hwdatepicker_checkbox);
        this.f42203e = hwCheckBox;
        if (hwCheckBox != null) {
            hwCheckBox.setChecked(false);
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(C8710R.id.hwdatepicker_switch_button);
        this.f42201d = linearLayout;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new bqmxo());
        }
        akxao akxaoVar = new akxao();
        HwCheckBox hwCheckBox2 = this.f42203e;
        if (hwCheckBox2 != null) {
            hwCheckBox2.setOnCheckedChangeListener(akxaoVar);
        }
    }

    private String getShowString() {
        if (this.f42220v) {
            return DateUtils.formatDateTime(this.f42189R, this.f42212n.getTimeInMillis(), this.f42222x ? 20 : 24);
        }
        if (this.f42222x) {
            return getWholeLunarStrings();
        }
        return this.f42173B + this.f42174C;
    }

    private String getWholeLunarStrings() {
        String str = this.f42172A;
        if (str == null) {
            return "";
        }
        String[] strArrSplit = str.split("年");
        if (strArrSplit.length != 2) {
            return "";
        }
        return strArrSplit[1] + "年" + this.f42173B + this.f42174C;
    }

    /* renamed from: h */
    private void m54282h() {
        this.f42197b = (LinearLayout) findViewById(C8710R.id.hwdatepicker_pickers_Layout);
        this.f42195a = (LinearLayout) findViewById(C8710R.id.hwdatepicker_pickers);
        HwAdvancedNumberPicker hwAdvancedNumberPicker = (HwAdvancedNumberPicker) findViewById(C8710R.id.hwdatepicker_day);
        this.mDaySpinner = hwAdvancedNumberPicker;
        hwAdvancedNumberPicker.setOnLongPressUpdateInterval(100L);
        HwAdvancedNumberPicker hwAdvancedNumberPicker2 = (HwAdvancedNumberPicker) findViewById(C8710R.id.hwdatepicker_month);
        this.mMonthSpinner = hwAdvancedNumberPicker2;
        hwAdvancedNumberPicker2.setMinValue(0);
        this.mMonthSpinner.setMaxValue(this.f42208j - 1);
        this.mMonthSpinner.setDisplayedValues(this.f42206h);
        this.mMonthSpinner.setOnLongPressUpdateInterval(100L);
        HwAdvancedNumberPicker hwAdvancedNumberPicker3 = (HwAdvancedNumberPicker) findViewById(C8710R.id.hwdatepicker_year);
        this.mYearSpinner = hwAdvancedNumberPicker3;
        hwAdvancedNumberPicker3.setOnLongPressUpdateInterval(100L);
        this.mYearSpinner.setFlingAnnounceType(3);
        this.mMonthSpinner.setFlingAnnounceType(1);
        this.mDaySpinner.setFlingAnnounceType(3);
        this.mYearSpinner.setIsSupportRichTap(false);
        this.mMonthSpinner.setIsSupportRichTap(false);
        this.mDaySpinner.setIsSupportRichTap(false);
        initSelectionDividerType();
    }

    /* renamed from: i */
    private boolean m54285i() {
        return HwWidgetInstantiator.getCurrentType(this.f42189R) != 1 || Float.compare(this.f42194W, 1.75f) < 0;
    }

    public static HwDatePicker instantiate(Context context) throws ClassNotFoundException {
        Object objInstantiate = HwWidgetInstantiator.instantiate(context, HwWidgetInstantiator.getDeviceClassName(context, HwDatePicker.class, HwWidgetInstantiator.getCurrentType(context, 3, 1)), HwDatePicker.class);
        if (objInstantiate instanceof HwDatePicker) {
            return (HwDatePicker) objInstantiate;
        }
        return null;
    }

    /* renamed from: j */
    private boolean m54287j() {
        return (this.mDaySpinner == null || this.mMonthSpinner == null || this.mYearSpinner == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public void m54288n() {
        String str = ",   " + getShowString();
        this.mYearSpinner.setAnnouncedSuffix(str);
        this.mMonthSpinner.setAnnouncedSuffix(str);
        this.mDaySpinner.setAnnouncedSuffix(str);
        this.mYearSpinner.setAccessibilityOptimizationEnabled(true);
        this.mMonthSpinner.setAccessibilityOptimizationEnabled(true);
        this.mDaySpinner.setAccessibilityOptimizationEnabled(true);
        OnDateChangedListener onDateChangedListener = this.f42205g;
        if (onDateChangedListener != null) {
            onDateChangedListener.onDateChanged(this, getYear(), getMonth(), getDayOfMonth(), this.f42212n);
        }
    }

    /* renamed from: o */
    private void m54289o() {
        this.f42195a.removeAllViews();
        char[] dateFormatOrder = HwICU.getDateFormatOrder(DateFormat.getBestDateTimePattern(Locale.getDefault(), "yyyyMMMdd"));
        int length = dateFormatOrder.length;
        for (int i10 = 0; i10 < length; i10++) {
            char c10 = dateFormatOrder[i10];
            if (c10 == 'M') {
                this.f42195a.addView(this.mMonthSpinner);
                m54237a(i10, this.mMonthSpinner);
            } else if (c10 == 'd') {
                this.f42195a.addView(this.mDaySpinner);
                m54237a(i10, this.mDaySpinner);
            } else if (c10 != 'y') {
                Log.e(f42159e0, "reorderSpinners: ");
                return;
            } else {
                this.f42195a.addView(this.mYearSpinner);
                m54237a(i10, this.mYearSpinner);
            }
        }
        adjustSpinnerMargin(this.f42195a.getChildAt(0), this.f42195a.getChildAt(1), this.f42195a.getChildAt(length - 1));
    }

    /* renamed from: p */
    private void m54290p() {
        bzrwd bzrwdVar = new bzrwd();
        this.mDaySpinner.setOnColorChangeListener(bzrwdVar);
        this.mMonthSpinner.setOnColorChangeListener(bzrwdVar);
        this.mYearSpinner.setOnColorChangeListener(bzrwdVar);
    }

    /* renamed from: q */
    private void m54291q() {
        aauaf aauafVar = new aauaf();
        this.mDaySpinner.setOnValueChangedListener(aauafVar);
        this.mMonthSpinner.setOnValueChangedListener(aauafVar);
        this.mYearSpinner.setOnValueChangedListener(aauafVar);
    }

    /* renamed from: r */
    private void m54292r() {
        if (!this.f42222x) {
            Log.w(f42159e0, "no need to reset LunarYearMonthDay.");
            return;
        }
        this.f42224z.setLunarDate(this.f42212n.get(1), this.f42212n.get(2) + 1, this.f42212n.get(5));
        this.f42172A = this.f42224z.getChineseYearJian();
        this.f42173B = this.f42224z.getChineseMonthJian();
        this.f42174C = this.f42224z.getChineseDay();
    }

    /* renamed from: s */
    private void m54293s() {
        if (HwLanguageUtils.isChineseLanguageAndRegion(this.f42189R) && this.f42219u) {
            this.f42199c.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.f42199c.setVisibility(0);
        } else {
            this.f42199c.setVisibility(8);
        }
        if (!this.f42193V) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
            layoutParams.weight = 3.0f;
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -1);
            layoutParams2.weight = 2.0f;
            this.mYearSpinner.setLayoutParams(layoutParams);
            this.mMonthSpinner.setLayoutParams(layoutParams2);
            this.mDaySpinner.setLayoutParams(layoutParams2);
        }
        m54296v();
    }

    private void setCurrentLocale(Locale locale) {
        if (locale.equals(this.f42204f)) {
            return;
        }
        this.f42204f = locale;
        this.f42209k = m54234a(this.f42209k, locale);
        this.f42210l = m54234a(this.f42210l, locale);
        this.f42211m = m54234a(this.f42211m, locale);
        this.f42212n = m54234a(this.f42212n, locale);
        int actualMaximum = this.f42209k.getActualMaximum(2) + 1;
        this.f42208j = actualMaximum;
        this.f42206h = new String[actualMaximum];
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(5, 1);
        int i10 = 0;
        for (int i11 = 0; i11 < this.f42208j; i11++) {
            gregorianCalendar.set(2, i11);
            this.f42206h[i11] = DateUtils.formatDateTime(this.f42189R, gregorianCalendar.getTimeInMillis(), 65592);
        }
        this.f42207i = new String[31];
        String bestDateTimePattern = DateFormat.getBestDateTimePattern(locale, "d");
        Object objClone = this.f42209k.clone();
        if (objClone instanceof GregorianCalendar) {
            GregorianCalendar gregorianCalendar2 = (GregorianCalendar) objClone;
            gregorianCalendar2.set(2, 0);
            while (i10 < 31) {
                int i12 = i10 + 1;
                gregorianCalendar2.set(5, i12);
                this.f42207i[i10] = DateFormat.format(bestDateTimePattern, gregorianCalendar2).toString();
                i10 = i12;
            }
        }
    }

    private void setMaxDate(long j10) {
        this.f42209k.setTimeInMillis(j10);
        this.f42211m.setTimeInMillis(j10);
        m54235a();
        m54296v();
    }

    private void setMinDate(long j10) {
        this.f42209k.setTimeInMillis(j10);
        this.f42210l.setTimeInMillis(j10);
        m54235a();
        m54296v();
    }

    private void setSpinnersMiddleDrawable(int i10) {
        HwAdvancedNumberPicker hwAdvancedNumberPicker = this.mYearSpinner;
        if (hwAdvancedNumberPicker != null) {
            hwAdvancedNumberPicker.setMiddleStateDrawable(i10);
        }
        HwAdvancedNumberPicker hwAdvancedNumberPicker2 = this.mMonthSpinner;
        if (hwAdvancedNumberPicker2 != null) {
            hwAdvancedNumberPicker2.setMiddleStateDrawable(i10);
        }
        HwAdvancedNumberPicker hwAdvancedNumberPicker3 = this.mDaySpinner;
        if (hwAdvancedNumberPicker3 != null) {
            hwAdvancedNumberPicker3.setMiddleStateDrawable(i10);
        }
    }

    private void setSpinnersSelectionDividerHeight(int i10) {
        HwAdvancedNumberPicker hwAdvancedNumberPicker = this.mYearSpinner;
        if (hwAdvancedNumberPicker != null) {
            hwAdvancedNumberPicker.setSelectionDividerHeight(i10);
        }
        HwAdvancedNumberPicker hwAdvancedNumberPicker2 = this.mMonthSpinner;
        if (hwAdvancedNumberPicker2 != null) {
            hwAdvancedNumberPicker2.setSelectionDividerHeight(i10);
        }
        HwAdvancedNumberPicker hwAdvancedNumberPicker3 = this.mDaySpinner;
        if (hwAdvancedNumberPicker3 != null) {
            hwAdvancedNumberPicker3.setSelectionDividerHeight(i10);
        }
    }

    /* renamed from: t */
    private void m54294t() {
        int i10 = this.f42212n.get(1);
        int i11 = this.f42212n.get(2);
        int i12 = this.f42212n.get(5);
        if (i10 == this.f42210l.get(1) && i11 == this.f42210l.get(2)) {
            m54286j(i12);
        } else if (i10 == this.f42211m.get(1) && i11 == this.f42211m.get(2)) {
            m54284i(i12);
        } else {
            m54229F();
        }
        this.mMonthSpinner.setDisplayedValues((String[]) Arrays.copyOfRange(this.f42206h, this.mMonthSpinner.getMinValue(), this.mMonthSpinner.getMaxValue() + 1));
        this.mDaySpinner.setDisplayedValues((String[]) Arrays.copyOfRange(this.f42207i, this.mDaySpinner.getMinValue() - 1, this.mDaySpinner.getMaxValue()));
    }

    /* renamed from: u */
    private void m54295u() {
        int i10;
        this.f42209k.clear();
        this.f42209k.set(1, 0, 1);
        setMinDate(this.f42209k.getTimeInMillis());
        if (this.f42221w) {
            i10 = 5000;
        } else {
            i10 = this.f42213o + 1;
            this.f42214p = i10;
        }
        this.f42209k.clear();
        this.f42209k.set(i10, 11, 31);
        setMaxDate(this.f42209k.getTimeInMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v */
    public void m54296v() {
        if (m54287j()) {
            if (this.f42220v) {
                m54224A();
            } else {
                if (!this.f42223y) {
                    this.f42175D = HwLunarDataOperate.getInstance(this.f42189R);
                    this.f42224z = new HwLunarCalendar(this.f42189R);
                    this.f42223y = true;
                }
                m54297w();
            }
            this.mYearSpinner.postInvalidate();
            this.mMonthSpinner.postInvalidate();
            this.mDaySpinner.postInvalidate();
        }
    }

    /* renamed from: w */
    private void m54297w() {
        if (this.f42221w) {
            m54298x();
        } else {
            m54299y();
        }
    }

    /* renamed from: x */
    private void m54298x() {
        GregorianCalendar minWesternDate = HwLunarDataOperate.getMinWesternDate();
        GregorianCalendar maxWesternDate = HwLunarDataOperate.getMaxWesternDate();
        boolean zM54259b = m54259b(minWesternDate);
        boolean zM54249a = m54249a(maxWesternDate);
        m54292r();
        String string = this.f42189R.getString(C8710R.string.la_yue);
        String string2 = this.f42189R.getString(C8710R.string.la_yue1);
        if (string.equals(this.f42173B)) {
            this.f42173B = string2;
        }
        String string3 = this.f42189R.getString(C8710R.string.run_yue);
        String string4 = this.f42189R.getString(C8710R.string.run_yue1);
        if (this.f42173B.length() == 3 && string3.equals(this.f42173B.substring(0, 1))) {
            this.f42173B = this.f42173B.replace(string3, string4);
        }
        int iIntValue = this.f42175D.getAllLunarYearWesternYear().get(this.f42172A).intValue();
        String str = this.f42186O;
        if (str == null || !str.equals(this.f42172A)) {
            this.f42175D.loadData(iIntValue);
        }
        Map<String, Integer> allLunarYearIndex = this.f42175D.getAllLunarYearIndex();
        int iIntValue2 = allLunarYearIndex != null ? allLunarYearIndex.get(this.f42172A).intValue() : 0;
        m54236a(iIntValue);
        int iFindIndex = HwLunarUtils.findIndex(this.f42173B, this.f42178G);
        this.f42181J = HwDatePickerUtils.getDisplayStrings(iFindIndex, this.f42178G, this.f42179H, this.f42180I);
        m54255b();
        int iFindIndex2 = HwLunarUtils.findIndex(this.f42174C, this.f42182K);
        this.f42185N = HwDatePickerUtils.getDisplayStrings(iFindIndex2, this.f42182K, this.f42183L, this.f42184M);
        int iM54261c = m54261c(iIntValue2, zM54259b, zM54249a);
        int iM54252b = m54252b(iFindIndex, zM54259b, zM54249a);
        int iM54230a = m54230a(iFindIndex2, zM54259b, zM54249a);
        String[] strArr = (String[]) this.f42177F.clone();
        m54238a(iM54261c, strArr);
        m54243a(this.mYearSpinner, iM54261c, strArr, true);
        String[] strArrM54251a = m54251a(string, string2, string3, string4);
        this.mMonthSpinner.setValue(iM54252b);
        m54243a(this.mDaySpinner, iM54230a, strArrM54251a, true);
        this.f42186O = this.f42172A;
        this.f42187P = this.f42172A + this.f42173B;
    }

    /* renamed from: y */
    private void m54299y() {
        m54292r();
        String string = this.f42189R.getString(C8710R.string.la_yue);
        String string2 = this.f42189R.getString(C8710R.string.la_yue1);
        if (string.equals(this.f42173B)) {
            this.f42173B = string2;
        }
        String string3 = this.f42189R.getString(C8710R.string.run_yue);
        String string4 = this.f42189R.getString(C8710R.string.run_yue1);
        if (this.f42173B.length() == 3 && string3.equals(this.f42173B.substring(0, 1))) {
            this.f42173B = this.f42173B.replace(string3, string4);
        }
        int iIntValue = this.f42175D.getAllLunarYearWesternYear().get(this.f42172A).intValue();
        if (this.f42222x) {
            m54283h(iIntValue);
        } else {
            m54300z();
        }
        this.f42186O = this.f42172A;
        this.f42187P = this.f42172A + this.f42173B;
    }

    /* renamed from: z */
    private void m54300z() {
        int i10;
        this.f42177F = this.f42175D.getAllLunarNumberYearStrings();
        int i11 = this.f42214p;
        String[] strArr = new String[i11 - 1899];
        int i12 = 0;
        int i13 = 0;
        while (true) {
            i10 = i11 - 1900;
            if (i13 >= i10) {
                break;
            }
            strArr[i13] = this.f42177F[i13 + 2];
            i13++;
        }
        strArr[i10] = "-- --";
        this.f42178G = HwLunarUtils.LUNAR_MONTH;
        String[] strArr2 = HwLunarUtils.LUNAR_DAY;
        this.f42182K = strArr2;
        this.f42185N = strArr2;
        this.mYearSpinner.setDisplayedValues(null);
        this.mYearSpinner.setMinValue(HwConstants.LUNAR_YEAR_MIN);
        this.mYearSpinner.setMaxValue(this.f42214p);
        this.mYearSpinner.setDisplayedValues(strArr);
        this.mYearSpinner.setValue(i11 + 1);
        this.mYearSpinner.setWrapSelectorWheel(false);
        String str = this.f42173B;
        int i14 = 0;
        while (true) {
            String[] strArr3 = this.f42178G;
            if (i14 >= strArr3.length || str.equals(strArr3[i14])) {
                break;
            } else {
                i14++;
            }
        }
        this.f42191T = i14 + 1;
        this.mMonthSpinner.setDisplayedValues(null);
        this.mMonthSpinner.setMinValue(1);
        this.mMonthSpinner.setMaxValue(this.f42178G.length);
        this.mMonthSpinner.setValue(this.f42191T);
        this.mMonthSpinner.setDisplayedValues(this.f42178G);
        this.mMonthSpinner.setWrapSelectorWheel(true);
        String str2 = this.f42174C;
        while (true) {
            String[] strArr4 = this.f42182K;
            if (i12 >= strArr4.length || str2.equals(strArr4[i12])) {
                break;
            } else {
                i12++;
            }
        }
        this.f42192U = i12 + 1;
        this.mDaySpinner.setDisplayedValues(null);
        this.mDaySpinner.setMinValue(1);
        this.mDaySpinner.setMaxValue(this.f42182K.length);
        this.mDaySpinner.setValue(this.f42192U);
        this.mDaySpinner.setDisplayedValues(this.f42182K);
        this.mDaySpinner.setWrapSelectorWheel(true);
    }

    public void adjustSpinnerMargin(View view, View view2, View view3) {
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    public int getDayOfMonth() {
        return this.f42222x ? this.f42212n.get(5) : this.f42192U;
    }

    public String getDisplayedString() {
        return !this.f42220v ? getWholeLunarStrings() : "";
    }

    public int getMonth() {
        return this.f42222x ? this.f42212n.get(2) : this.f42191T;
    }

    public String[] getShortMonthDays() {
        return this.f42207i;
    }

    public String[] getShortMonths() {
        return this.f42206h;
    }

    public Drawable getSpinnersSelectionDivider() {
        return this.f42217s;
    }

    public int getSpinnersSelectorPaintColor() {
        return this.f42215q;
    }

    public boolean getSpinnersShown() {
        return this.f42195a.isShown();
    }

    public int getSpinnersUnselectedPaintColor() {
        return this.f42216r;
    }

    public int getYear() {
        return this.f42212n.get(1);
    }

    public void handleConfigrationChange() {
        m54293s();
        boolean z10 = !this.f42193V && getResources().getConfiguration().orientation == 2;
        this.mDaySpinner.updateSelectorItemCount(z10);
        this.mMonthSpinner.updateSelectorItemCount(z10);
        this.mYearSpinner.updateSelectorItemCount(z10);
    }

    public final void init(int i10, int i11, int i12, OnDateChangedListener onDateChangedListener) {
        m54265c(i10, i11, i12);
        m54296v();
        this.f42205g = onDateChangedListener;
    }

    public void initAttrs(Context context, AttributeSet attributeSet, int i10) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C8710R.styleable.HwDatePicker, i10, 0);
        try {
            try {
                setEnabled(typedArrayObtainStyledAttributes.getBoolean(C8710R.styleable.HwDatePicker_android_enabled, true));
                if (this.mDividerType == 1) {
                    this.f42198b0 = typedArrayObtainStyledAttributes.getDrawable(C8710R.styleable.HwDatePicker_hwSelectionDividerRectLeft);
                    this.f42200c0 = typedArrayObtainStyledAttributes.getDrawable(C8710R.styleable.HwDatePicker_hwSelectionDividerRectCenter);
                    this.f42202d0 = typedArrayObtainStyledAttributes.getDrawable(C8710R.styleable.HwDatePicker_hwSelectionDividerRectRight);
                } else {
                    setSpinnersSelectionDivider(typedArrayObtainStyledAttributes.getDrawable(C8710R.styleable.HwDatePicker_hwNumberPickerSelectionDivider));
                    setSpinnersSelectionDividerHeight(typedArrayObtainStyledAttributes.getDimensionPixelSize(C8710R.styleable.HwDatePicker_hwNumberPickerSelectionDividerHeight, 0));
                }
                typedArrayObtainStyledAttributes.recycle();
            } catch (Resources.NotFoundException unused) {
                Log.w(f42159e0, "TypedArray get resource error");
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

    @Override // android.view.View
    public boolean isEnabled() {
        return this.f42218t;
    }

    @Override // android.view.View
    public boolean isHapticFeedbackEnabled() {
        return super.isHapticFeedbackEnabled();
    }

    public boolean isLinkageScrollEnabled() {
        return this.f42196a0;
    }

    public boolean isLunarChecked() {
        return this.f42203e.isChecked();
    }

    public boolean isLunarSwitchVisible() {
        return this.f42219u && HwLanguageUtils.isChineseLanguageAndRegion(this.f42189R);
    }

    public boolean isSelectYear() {
        return this.f42222x;
    }

    public boolean isShowAllYears() {
        return this.f42221w;
    }

    public boolean isSupportLunarSwitch() {
        return this.f42219u;
    }

    public boolean isWestern() {
        return this.f42220v;
    }

    /* renamed from: k */
    public void m54301k() {
        if (m54285i()) {
            return;
        }
        if (AuxiliaryHelper.isMultiWindowActivity(this.f42189R)) {
            this.f42203e.setTextSize(1, f42171q0);
            return;
        }
        for (HwAdvancedNumberPicker hwAdvancedNumberPicker : this.f42190S) {
            hwAdvancedNumberPicker.setUnselectedItemTextSize(f42169o0);
            hwAdvancedNumberPicker.setSelectedItemTextSize(f42167m0);
            hwAdvancedNumberPicker.setSelectedItemHeight(f42168n0);
        }
        if (Float.compare(this.f42194W, 2.0f) >= 0) {
            this.f42203e.setTextSize(1, f42170p0);
        }
    }

    /* renamed from: l */
    public void m54302l() {
        if (m54285i() || AuxiliaryHelper.isMultiWindowActivity(this.f42189R)) {
            return;
        }
        this.mYearSpinner.setVisibility(8);
        this.mMonthSpinner.setVisibility(0);
        this.mDaySpinner.setVisibility(0);
    }

    /* renamed from: m */
    public void m54303m() {
        if (m54285i() || AuxiliaryHelper.isMultiWindowActivity(this.f42189R)) {
            return;
        }
        this.mYearSpinner.setVisibility(0);
        this.mMonthSpinner.setVisibility(8);
        this.mDaySpinner.setVisibility(8);
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setCurrentLocale(configuration.locale);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent == null) {
            return;
        }
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.getText().add(DateUtils.formatDateTime(this.f42189R, this.f42212n.getTimeInMillis(), 20));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof avpbg) {
            avpbg avpbgVar = (avpbg) parcelable;
            super.onRestoreInstanceState(avpbgVar.getSuperState());
            m54265c(avpbgVar.f42227a, avpbgVar.f42228b, avpbgVar.f42229c);
            m54296v();
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        return new avpbg(super.onSaveInstanceState(), getYear(), getMonth(), getDayOfMonth(), null);
    }

    public void setDayDisplayValueIndex(int i10) {
        this.f42192U = i10;
    }

    public void setDialogStyle() {
        m54293s();
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        if (!m54287j() || this.f42218t == z10) {
            return;
        }
        this.f42218t = z10;
        this.mDaySpinner.setEnabled(z10);
        this.mMonthSpinner.setEnabled(z10);
        this.mYearSpinner.setEnabled(z10);
    }

    @Override // android.view.View
    public void setHapticFeedbackEnabled(boolean z10) {
        super.setHapticFeedbackEnabled(z10);
        HwAdvancedNumberPicker hwAdvancedNumberPicker = this.mDaySpinner;
        if (hwAdvancedNumberPicker == null || this.mMonthSpinner == null || this.mYearSpinner == null) {
            return;
        }
        hwAdvancedNumberPicker.setHapticFeedbackEnabled(z10);
        this.mMonthSpinner.setHapticFeedbackEnabled(z10);
        this.mYearSpinner.setHapticFeedbackEnabled(z10);
    }

    public void setIsShowAllYears(boolean z10) {
        this.f42221w = z10;
        if (z10) {
            return;
        }
        this.f42214p = this.f42213o + 1;
    }

    public void setLinkageScrollEnabled(boolean z10) {
        this.f42196a0 = z10;
    }

    public void setLunarOrWestern(boolean z10) {
        this.f42203e.setChecked(z10);
    }

    public void setMonthDisplayValueIndex(int i10) {
        this.f42191T = i10;
    }

    public void setSelectYear(boolean z10) {
        this.f42222x = z10;
    }

    public void setSpinnersSelectionDivider(Drawable drawable) {
        Drawable drawable2 = this.f42217s;
        if (drawable2 == null || !drawable2.equals(drawable)) {
            this.f42217s = drawable;
            HwAdvancedNumberPicker hwAdvancedNumberPicker = this.mYearSpinner;
            if (hwAdvancedNumberPicker != null) {
                hwAdvancedNumberPicker.setSelectionDivider(drawable);
            }
            HwAdvancedNumberPicker hwAdvancedNumberPicker2 = this.mMonthSpinner;
            if (hwAdvancedNumberPicker2 != null) {
                hwAdvancedNumberPicker2.setSelectionDivider(drawable);
            }
            HwAdvancedNumberPicker hwAdvancedNumberPicker3 = this.mDaySpinner;
            if (hwAdvancedNumberPicker3 != null) {
                hwAdvancedNumberPicker3.setSelectionDivider(drawable);
            }
        }
    }

    public void setSpinnersSelectorPaintColor(int i10) {
        if (this.f42215q == i10) {
            return;
        }
        this.f42215q = i10;
        HwAdvancedNumberPicker hwAdvancedNumberPicker = this.mYearSpinner;
        if (hwAdvancedNumberPicker != null) {
            hwAdvancedNumberPicker.setSelectorPaintColor(i10);
        }
        HwAdvancedNumberPicker hwAdvancedNumberPicker2 = this.mMonthSpinner;
        if (hwAdvancedNumberPicker2 != null) {
            hwAdvancedNumberPicker2.setSelectorPaintColor(i10);
        }
        HwAdvancedNumberPicker hwAdvancedNumberPicker3 = this.mDaySpinner;
        if (hwAdvancedNumberPicker3 != null) {
            hwAdvancedNumberPicker3.setSelectorPaintColor(i10);
        }
    }

    public final void setSpinnersShown() {
        this.f42195a.setVisibility(0);
    }

    public void setSpinnersUnselectedPaintColor(int i10) {
        if (this.f42216r == i10) {
            return;
        }
        this.f42216r = i10;
        HwAdvancedNumberPicker hwAdvancedNumberPicker = this.mYearSpinner;
        if (hwAdvancedNumberPicker != null) {
            hwAdvancedNumberPicker.setSecondaryPaintColor(i10);
        }
        HwAdvancedNumberPicker hwAdvancedNumberPicker2 = this.mMonthSpinner;
        if (hwAdvancedNumberPicker2 != null) {
            hwAdvancedNumberPicker2.setSecondaryPaintColor(i10);
        }
        HwAdvancedNumberPicker hwAdvancedNumberPicker3 = this.mDaySpinner;
        if (hwAdvancedNumberPicker3 != null) {
            hwAdvancedNumberPicker3.setSecondaryPaintColor(i10);
        }
    }

    public void setmIsSupportLunarSwitch(boolean z10) {
        HwCheckBox hwCheckBox;
        this.f42219u = z10;
        if (!z10 && (hwCheckBox = this.f42203e) != null) {
            hwCheckBox.setChecked(false);
        }
        setDialogStyle();
    }

    public void setmIsWestern(boolean z10) {
        if (!HwLanguageUtils.isChineseLanguageAndRegion(this.f42189R)) {
            this.f42220v = true;
            return;
        }
        this.f42220v = z10;
        if (this.f42219u) {
            setLunarOrWestern(!z10);
        }
        m54278f();
    }

    public void updateDate(int i10, int i11, int i12) {
        if (m54247a(i10, i11, i12)) {
            m54265c(i10, i11, i12);
            m54296v();
            m54288n();
        }
    }

    public void updateDateLimit(GregorianCalendar gregorianCalendar, GregorianCalendar gregorianCalendar2) {
        if (gregorianCalendar != null) {
            int i10 = gregorianCalendar.get(1);
            int i11 = gregorianCalendar.get(2);
            int i12 = gregorianCalendar.get(5);
            if (i10 < 1) {
                i10 = 1;
            }
            this.f42209k.clear();
            this.f42209k.set(i10, i11, i12);
            setMinDate(this.f42209k.getTimeInMillis());
        }
        if (gregorianCalendar2 != null) {
            int i13 = gregorianCalendar2.get(1);
            int i14 = gregorianCalendar2.get(2);
            int i15 = gregorianCalendar2.get(5);
            int i16 = i13 >= 1 ? i13 : 1;
            this.f42209k.clear();
            this.f42209k.set(i16, i14, i15);
            setMaxDate(this.f42209k.getTimeInMillis());
        }
    }

    public void updateYearLimit(int i10, int i11) {
        if (i10 < 1) {
            i10 = 1;
        }
        this.f42209k.clear();
        this.f42209k.set(i10, 0, 1);
        setMinDate(this.f42209k.getTimeInMillis());
        if (i11 > 5000) {
            i11 = 5000;
        }
        this.f42209k.clear();
        this.f42209k.set(i11, 11, 31);
        setMaxDate(this.f42209k.getTimeInMillis());
    }

    public HwDatePicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C8710R.attr.hwDatePickerStyle);
    }

    /* renamed from: c */
    private void m54264c(int i10, int i11) {
        int i12 = this.f42214p;
        if (i11 == i12) {
            this.f42222x = false;
            this.f42191T = this.f42212n.get(2);
            this.f42192U = this.f42212n.get(5);
        } else {
            if (i11 != i12 - 1 || i10 != i12) {
                Log.w(f42159e0, "mIsSelectYear status not change.");
                return;
            }
            this.f42222x = true;
            this.f42209k.set(2, this.f42191T);
            this.f42209k.set(5, this.f42192U);
        }
    }

    /* renamed from: d */
    private void m54271d(int i10, int i11, int i12) {
        if (i10 == i12 && i11 == 1) {
            this.f42209k.add(5, this.f42221w ? 1 : 1 - i12);
        } else if (i10 == 1 && i11 == i12) {
            this.f42209k.add(5, this.f42221w ? -1 : i12 - 1);
        } else {
            this.f42209k.add(5, i11 - i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m54278f() {
        if (this.f42220v) {
            this.mDaySpinner.addEndDescription(getResources().getString(C8710R.string.day_view), true);
        } else {
            this.mDaySpinner.addEndDescription("", false);
        }
    }

    /* renamed from: j */
    private void m54286j(int i10) {
        this.mDaySpinner.setDisplayedValues(null);
        if (i10 == this.f42210l.get(5)) {
            this.mDaySpinner.setMinValue(this.f42210l.get(5));
            this.mDaySpinner.setMaxValue(this.f42212n.getActualMaximum(5));
            this.mDaySpinner.setWrapSelectorWheel(false);
        } else {
            this.mDaySpinner.setMinValue(this.f42212n.getActualMinimum(5));
            this.mDaySpinner.setMaxValue(this.f42212n.getActualMaximum(5));
            this.mDaySpinner.setWrapSelectorWheel(true);
        }
        this.mMonthSpinner.setDisplayedValues(null);
        this.mMonthSpinner.setMinValue(this.f42212n.get(2));
        this.mMonthSpinner.setMaxValue(this.f42212n.getActualMaximum(2));
        this.mMonthSpinner.setWrapSelectorWheel(false);
    }

    public HwDatePicker(Context context, AttributeSet attributeSet, int i10) {
        super(m54231a(context, i10), attributeSet, i10);
        this.f42214p = HwConstants.LUNAR_YEAR_MAX;
        this.f42218t = true;
        this.f42219u = true;
        this.f42220v = true;
        this.f42221w = true;
        this.f42222x = true;
        this.f42223y = false;
        this.f42189R = getContext();
        this.f42190S = new ArrayList(10);
        this.f42191T = 0;
        this.f42192U = 0;
        Context context2 = super.getContext();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{C8710R.attr.hwTheme});
        if (typedArrayObtainStyledAttributes != null) {
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
            context2 = resourceId != 0 ? new ContextThemeWrapper(super.getContext(), resourceId) : context2;
            typedArrayObtainStyledAttributes.recycle();
        }
        this.f42193V = this.f42189R.getResources().getInteger(C8710R.integer.emui_device_type) == 2;
        setCurrentLocale(Locale.getDefault());
        m54239a(context2);
        m54282h();
        m54291q();
        m54281g();
        if (HwLanguageUtils.isChineseLanguage(this.f42189R)) {
            this.mYearSpinner.addEndDescription(getResources().getString(C8710R.string.year_view), true);
        }
        if (HwLanguageUtils.isChineseLanguageAndRegion(this.f42189R)) {
            m54278f();
            if (!this.f42219u) {
                this.f42199c.setVisibility(8);
            }
        }
        setSpinnersShown();
        m54240a(context2, attributeSet, i10);
        m54274e();
        this.f42190S.add(this.mDaySpinner);
        this.f42190S.add(this.mMonthSpinner);
        this.f42190S.add(this.mYearSpinner);
        m54290p();
        try {
            if (!Locale.getDefault().getLanguage().contains(Constants.AR_CACHE) && !Locale.getDefault().getLanguage().contains("fa") && !Locale.getDefault().getLanguage().contains("iw")) {
                m54289o();
            }
        } catch (IllegalArgumentException unused) {
            Log.e(f42159e0, "Exception catched");
        }
        m54293s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m54256b(HwAdvancedNumberPicker hwAdvancedNumberPicker, int i10, int i11) {
        if (this.f42220v) {
            this.f42209k.setTimeInMillis(this.f42212n.getTimeInMillis());
            if (hwAdvancedNumberPicker == this.mDaySpinner) {
                this.f42192U = this.f42221w ? this.f42192U : i11;
                if (!this.f42196a0) {
                    this.f42209k.set(5, i11);
                    return;
                } else {
                    m54271d(i10, i11, this.f42209k.getActualMaximum(5));
                    return;
                }
            }
            if (hwAdvancedNumberPicker == this.mMonthSpinner) {
                this.f42191T = this.f42221w ? this.f42191T : i11;
                if (!this.f42196a0) {
                    m54275e(i10, i11);
                    return;
                } else {
                    m54270d(i10, i11);
                    return;
                }
            }
            if (hwAdvancedNumberPicker == this.mYearSpinner) {
                if (!this.f42221w) {
                    m54264c(i10, i11);
                }
                this.f42209k.add(1, i11 - i10);
                return;
            }
            Log.e(f42159e0, "invalid picker");
            return;
        }
        if (this.f42221w) {
            m54242a(hwAdvancedNumberPicker, i10, i11);
        } else {
            m54241a(hwAdvancedNumberPicker, i11);
        }
    }

    /* renamed from: e */
    private void m54274e() {
        this.f42212n.setTimeInMillis(Calendar.getInstance().getTimeInMillis());
        this.f42213o = this.f42212n.get(1);
        m54295u();
        init(this.f42212n.get(1), this.f42212n.get(2), this.f42212n.get(5), null);
    }

    /* renamed from: i */
    private void m54284i(int i10) {
        if (this.f42221w) {
            this.mDaySpinner.setDisplayedValues(null);
            this.mDaySpinner.setMinValue(this.f42212n.getActualMinimum(5));
            if (i10 == this.f42211m.get(5)) {
                this.mDaySpinner.setMaxValue(this.f42211m.get(5));
                this.mDaySpinner.setWrapSelectorWheel(false);
            } else {
                this.mDaySpinner.setMaxValue(this.f42212n.getActualMaximum(5));
                this.mDaySpinner.setWrapSelectorWheel(true);
            }
            this.mMonthSpinner.setDisplayedValues(null);
            this.mMonthSpinner.setMinValue(this.f42212n.getActualMinimum(2));
            this.mMonthSpinner.setMaxValue(this.f42212n.get(2));
            this.mMonthSpinner.setWrapSelectorWheel(false);
            return;
        }
        this.mDaySpinner.setDisplayedValues(null);
        this.mDaySpinner.setMinValue(this.f42212n.getActualMinimum(5));
        this.mDaySpinner.setMaxValue(this.f42212n.getActualMaximum(5));
        this.mDaySpinner.setWrapSelectorWheel(true);
        this.mMonthSpinner.setDisplayedValues(null);
        this.mMonthSpinner.setMinValue(this.f42212n.getActualMinimum(2));
        this.mMonthSpinner.setMaxValue(this.f42212n.get(2));
        this.mMonthSpinner.setWrapSelectorWheel(true);
    }

    /* renamed from: a */
    private void m54240a(Context context, AttributeSet attributeSet, int i10) {
        initAttrs(context, attributeSet, i10);
    }

    /* renamed from: f */
    private GregorianCalendar m54277f(int i10) {
        int i11 = this.f42214p;
        boolean z10 = false;
        if (i10 == i11) {
            this.f42222x = false;
        } else if (i10 == i11 - 1) {
            this.f42222x = true;
        } else {
            Log.w(f42159e0, "mIsSelectYear status not change.");
        }
        if (i10 < 1898) {
            return null;
        }
        int i12 = i10 - HwConstants.LUNAR_YEAR_TABLE_MIN;
        String[] strArr = this.f42176E;
        if (i12 > strArr.length) {
            return null;
        }
        GregorianCalendar gregorianCalendarLunarChangeWestern = this.f42175D.lunarChangeWestern(strArr[i12], this.f42173B, this.f42174C, 0, true);
        boolean z11 = gregorianCalendarLunarChangeWestern == null && this.f42174C.equals(HwConstants.LUNAR_DAY_THIRTY);
        if (this.f42222x && z11) {
            gregorianCalendarLunarChangeWestern = this.f42175D.lunarChangeWestern(this.f42176E[i12], this.f42173B, HwConstants.LUNAR_DAY_TWEENTY_NINE, 1, true);
        }
        boolean z12 = gregorianCalendarLunarChangeWestern == null && this.f42173B.contains(HwConstants.LUNAR_RUN);
        if (this.f42222x && z12) {
            gregorianCalendarLunarChangeWestern = this.f42175D.lunarChangeWestern(this.f42176E[i12], this.f42173B.replace(HwConstants.LUNAR_RUN, ""), this.f42174C, 1, true);
        }
        if (gregorianCalendarLunarChangeWestern == null && this.f42173B.contains(HwConstants.LUNAR_RUN) && this.f42174C.equals(HwConstants.LUNAR_DAY_THIRTY)) {
            z10 = true;
        }
        if (this.f42222x && z10) {
            return this.f42175D.lunarChangeWestern(this.f42176E[i12], this.f42173B.replace(HwConstants.LUNAR_RUN, ""), HwConstants.LUNAR_DAY_TWEENTY_NINE, 1, true);
        }
        return gregorianCalendarLunarChangeWestern;
    }

    /* renamed from: a */
    private static Context m54231a(Context context, int i10) {
        return HwWidgetCompat.wrapContext(context, i10, C8710R.style.Theme_Emui_HwDatePicker);
    }

    /* renamed from: a */
    private void m54239a(Context context) {
        this.f42188Q = HwLunarUtils.LUNAR_MONTH;
        this.f42194W = AuxiliaryHelper.getFontSize(context);
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        if (layoutInflater != null) {
            layoutInflater.cloneInContext(context).inflate(C8710R.layout.hwdatepicker, (ViewGroup) this, true);
        }
    }

    /* renamed from: d */
    private void m54270d(int i10, int i11) {
        if (m54258b(i10, i11, 11)) {
            this.f42209k.add(2, this.f42221w ? 1 : -11);
        } else if (i10 == 0 && i11 == 11) {
            this.f42209k.add(2, this.f42221w ? -1 : 11);
        } else {
            this.f42209k.add(2, i11 - i10);
        }
    }

    /* renamed from: e */
    private void m54275e(int i10, int i11) {
        if (i10 == 0 && i11 == 11) {
            this.f42209k.add(2, 11);
        } else if (i10 == 11 && i11 == 0) {
            this.f42209k.add(2, -11);
        } else {
            this.f42209k.add(2, i11 - i10);
        }
    }

    /* renamed from: g */
    private GregorianCalendar m54280g(int i10) {
        if (i10 >= 0) {
            String[] strArr = this.f42176E;
            if (i10 < strArr.length) {
                GregorianCalendar gregorianCalendarLunarChangeWestern = this.f42175D.lunarChangeWestern(strArr[i10], this.f42173B, this.f42174C, 0, true);
                if (gregorianCalendarLunarChangeWestern == null && this.f42174C.equals(HwConstants.LUNAR_DAY_THIRTY)) {
                    this.f42174C = HwConstants.LUNAR_DAY_TWEENTY_NINE;
                    gregorianCalendarLunarChangeWestern = this.f42175D.lunarChangeWestern(this.f42176E[i10], this.f42173B, HwConstants.LUNAR_DAY_TWEENTY_NINE, 1, true);
                }
                if (gregorianCalendarLunarChangeWestern != null || !this.f42173B.contains(HwConstants.LUNAR_RUN)) {
                    return gregorianCalendarLunarChangeWestern;
                }
                return this.f42175D.lunarChangeWestern(this.f42176E[i10], this.f42173B.replace(HwConstants.LUNAR_RUN, ""), this.f42174C, 1, true);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m54265c(int i10, int i11, int i12) {
        this.f42212n.set(i10, i11, i12);
        m54235a();
    }

    /* renamed from: a */
    private void m54237a(int i10, HwAdvancedNumberPicker hwAdvancedNumberPicker) {
        if (this.mDividerType == 1) {
            if (i10 == 0) {
                hwAdvancedNumberPicker.setSelectionRectDivider(this.f42198b0);
                return;
            }
            if (i10 == 1) {
                hwAdvancedNumberPicker.setSelectionRectDivider(this.f42200c0);
            } else if (i10 == 2) {
                hwAdvancedNumberPicker.setSelectionRectDivider(this.f42202d0);
            } else {
                Log.i(f42159e0, "Invalid index.");
            }
        }
    }

    /* renamed from: c */
    private void m54263c() {
        String[] strArrListChangeGroup;
        Map<String, List<String>> lunarYearMonthToDays = this.f42175D.getLunarYearMonthToDays();
        Map<Integer, String> allIndexLunarYearMonth = this.f42175D.getAllIndexLunarYearMonth();
        Map<String, Integer> allLunarYearMonthIndex = this.f42175D.getAllLunarYearMonthIndex();
        if (lunarYearMonthToDays != null && allIndexLunarYearMonth != null && allLunarYearMonthIndex != null) {
            if (this.f42222x) {
                strArrListChangeGroup = HwLunarUtils.listChangeGroup(lunarYearMonthToDays.get(this.f42172A + this.f42173B));
            } else {
                strArrListChangeGroup = HwLunarUtils.LUNAR_DAY;
            }
            this.f42182K = strArrListChangeGroup;
            return;
        }
        Log.e(f42159e0, "yearMonthToDays || indexYearMonth || yearMonthIndex is null");
    }

    /* renamed from: e */
    private GregorianCalendar m54273e(int i10) {
        String str;
        String[] strArr = this.f42181J;
        if (strArr.length == 0) {
            return null;
        }
        int i11 = i10 - 1;
        String str2 = strArr[i11 % strArr.length];
        GregorianCalendar gregorianCalendarLunarChangeWestern = this.f42175D.lunarChangeWestern(this.f42172A, str2, this.f42174C, 1, true);
        if (this.f42222x && gregorianCalendarLunarChangeWestern == null && this.f42174C.equals(HwConstants.LUNAR_DAY_THIRTY)) {
            this.f42174C = HwConstants.LUNAR_DAY_TWEENTY_NINE;
            gregorianCalendarLunarChangeWestern = this.f42175D.lunarChangeWestern(this.f42172A, str2, HwConstants.LUNAR_DAY_TWEENTY_NINE, 1, true);
        }
        if (this.f42222x) {
            str = this.f42173B;
        } else {
            String[] strArr2 = this.f42181J;
            str = strArr2[i11 % strArr2.length];
        }
        this.f42173B = str;
        return gregorianCalendarLunarChangeWestern;
    }

    /* renamed from: d */
    private void m54269d() {
        this.f42176E = this.f42175D.getAllYearStrings();
        this.f42177F = this.f42175D.getAllLunarNumberYearStrings();
        this.f42178G = this.f42222x ? HwLunarUtils.listChangeGroup(this.f42175D.getAllLunarYearToMonths().get(this.f42172A)) : HwLunarUtils.LUNAR_MONTH;
    }

    /* renamed from: a */
    private GregorianCalendar m54234a(GregorianCalendar gregorianCalendar, Locale locale) {
        if (gregorianCalendar == null) {
            return new GregorianCalendar(locale);
        }
        long timeInMillis = gregorianCalendar.getTimeInMillis();
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar(locale);
        gregorianCalendar2.setTimeInMillis(timeInMillis);
        return gregorianCalendar2;
    }

    /* renamed from: c */
    private int m54261c(int i10, boolean z10, boolean z11) {
        if (z10) {
            String[] strArrM54260b = m54260b(i10, this.f42176E, this.f42177F);
            this.f42176E = strArrM54260b;
            int iFindIndex = HwLunarUtils.findIndex(this.f42172A, strArrM54260b);
            this.mYearSpinner.setDisplayedValues(null);
            this.mYearSpinner.setMinValue(0);
            this.mYearSpinner.setMaxValue(this.f42176E.length - 1);
            this.mYearSpinner.setWrapSelectorWheel(false);
            return iFindIndex;
        }
        if (z11) {
            String[] strArrM54250a = m54250a(i10, this.f42176E, this.f42177F);
            this.f42176E = strArrM54250a;
            int iFindIndex2 = HwLunarUtils.findIndex(this.f42172A, strArrM54250a);
            this.mYearSpinner.setDisplayedValues(null);
            this.mYearSpinner.setMinValue(0);
            this.mYearSpinner.setMaxValue(this.f42176E.length - 1);
            this.mYearSpinner.setWrapSelectorWheel(false);
            return iFindIndex2;
        }
        this.mYearSpinner.setDisplayedValues(null);
        this.mYearSpinner.setMinValue(0);
        this.mYearSpinner.setMaxValue(this.f42176E.length - 1);
        this.mYearSpinner.setWrapSelectorWheel(false);
        return i10;
    }

    /* renamed from: d */
    private GregorianCalendar m54268d(int i10) {
        GregorianCalendar gregorianCalendarLunarChangeWestern = this.f42175D.lunarChangeWestern(this.f42172A, this.f42181J[i10], this.f42174C, 1, true);
        if (!this.f42222x || gregorianCalendarLunarChangeWestern != null || !this.f42174C.equals(HwConstants.LUNAR_DAY_THIRTY)) {
            return gregorianCalendarLunarChangeWestern;
        }
        this.f42174C = HwConstants.LUNAR_DAY_TWEENTY_NINE;
        return this.f42175D.lunarChangeWestern(this.f42172A, this.f42181J[i10], HwConstants.LUNAR_DAY_TWEENTY_NINE, 1, true);
    }

    /* renamed from: h */
    private void m54283h(int i10) {
        int i11;
        String str = this.f42186O;
        if (str == null || !str.equals(this.f42172A)) {
            this.f42175D.loadData(i10);
        }
        m54269d();
        this.f42181J = this.f42178G;
        m54263c();
        this.f42185N = this.f42182K;
        int i12 = this.f42214p;
        String[] strArr = new String[i12 - 1899];
        int i13 = 0;
        int i14 = 0;
        while (true) {
            i11 = i12 - 1900;
            if (i14 >= i11) {
                break;
            }
            strArr[i14] = this.f42177F[i14 + 2];
            i14++;
        }
        strArr[i11] = "-- --";
        this.mYearSpinner.setDisplayedValues(null);
        this.mYearSpinner.setMinValue(HwConstants.LUNAR_YEAR_MIN);
        this.mYearSpinner.setMaxValue(this.f42214p);
        this.mYearSpinner.setValue(i10);
        this.mYearSpinner.setDisplayedValues(strArr);
        this.mYearSpinner.setWrapSelectorWheel(false);
        String str2 = this.f42173B;
        int i15 = 0;
        while (true) {
            String[] strArr2 = this.f42178G;
            if (i15 >= strArr2.length || str2.equals(strArr2[i15])) {
                break;
            } else {
                i15++;
            }
        }
        this.mMonthSpinner.setDisplayedValues(null);
        this.mMonthSpinner.setMinValue(1);
        this.mMonthSpinner.setMaxValue(this.f42178G.length);
        this.mMonthSpinner.setValue(i15 + 1);
        this.mMonthSpinner.setDisplayedValues(this.f42178G);
        this.mMonthSpinner.setWrapSelectorWheel(true);
        String str3 = this.f42174C;
        while (true) {
            String[] strArr3 = this.f42182K;
            if (i13 >= strArr3.length || str3.equals(strArr3[i13])) {
                break;
            } else {
                i13++;
            }
        }
        this.mDaySpinner.setDisplayedValues(null);
        this.mDaySpinner.setMinValue(1);
        this.mDaySpinner.setMaxValue(this.f42182K.length);
        this.mDaySpinner.setValue(i13 + 1);
        this.mDaySpinner.setDisplayedValues(this.f42182K);
        this.mDaySpinner.setWrapSelectorWheel(true);
    }

    /* renamed from: a */
    private boolean m54247a(int i10, int i11, int i12) {
        return (this.f42212n.get(1) != i10) || (this.f42212n.get(2) != i12) || (this.f42212n.get(5) != i11);
    }

    /* renamed from: a */
    private void m54235a() {
        if (this.f42212n.before(this.f42210l)) {
            this.f42212n.setTimeInMillis(this.f42210l.getTimeInMillis());
        } else if (this.f42212n.after(this.f42211m)) {
            this.f42212n.setTimeInMillis(this.f42211m.getTimeInMillis());
        } else {
            Log.w(f42159e0, "normal date");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x007b  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m54255b() {
        /*
            r8 = this;
            com.huawei.uikit.hwlunar.utils.HwLunarDataOperate r0 = r8.f42175D
            java.util.Map r0 = r0.getAllLunarYearMonthIndex()
            com.huawei.uikit.hwlunar.utils.HwLunarDataOperate r1 = r8.f42175D
            java.util.Map r1 = r1.getLunarYearMonthToDays()
            com.huawei.uikit.hwlunar.utils.HwLunarDataOperate r2 = r8.f42175D
            java.util.Map r2 = r2.getAllIndexLunarYearMonth()
            java.lang.String r3 = "HwDatePicker"
            if (r1 == 0) goto Ld1
            if (r2 == 0) goto Ld1
            if (r0 != 0) goto L1c
            goto Ld1
        L1c:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = r8.f42172A
            r4.append(r5)
            java.lang.String r5 = "_"
            r4.append(r5)
            java.lang.String r5 = r8.f42173B
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.Object r0 = r0.get(r4)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            int r4 = r0 + (-1)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.lang.Object r4 = r2.get(r4)
            java.lang.String r4 = (java.lang.String) r4
            java.lang.String r4 = com.huawei.uikit.hwlunar.utils.HwLunarUtils.changeLunarYearMonth(r4)
            r5 = 1
            int r0 = r0 + r5
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.Object r0 = r2.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r0 = com.huawei.uikit.hwlunar.utils.HwLunarUtils.changeLunarYearMonth(r0)
            java.lang.String r2 = r8.f42187P
            if (r2 == 0) goto L7b
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = r8.f42172A
            r6.append(r7)
            java.lang.String r7 = r8.f42173B
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            boolean r2 = r2.equals(r6)
            if (r2 != 0) goto Lb2
        L7b:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r6 = r8.f42172A
            r2.append(r6)
            java.lang.String r6 = r8.f42173B
            r2.append(r6)
            java.lang.String r2 = r2.toString()
            java.lang.Object r2 = r1.get(r2)
            java.util.List r2 = (java.util.List) r2
            java.lang.String[] r2 = com.huawei.uikit.hwlunar.utils.HwLunarUtils.listChangeGroup(r2)
            r8.f42182K = r2
            java.lang.Object r2 = r1.get(r4)
            java.util.List r2 = (java.util.List) r2
            java.lang.String[] r2 = com.huawei.uikit.hwlunar.utils.HwLunarUtils.listChangeGroup(r2)
            r8.f42183L = r2
            java.lang.Object r0 = r1.get(r0)
            java.util.List r0 = (java.util.List) r0
            java.lang.String[] r0 = com.huawei.uikit.hwlunar.utils.HwLunarUtils.listChangeGroup(r0)
            r8.f42184M = r0
        Lb2:
            java.lang.String[] r0 = r8.f42182K
            int r0 = r0.length
            if (r0 == 0) goto Lc1
            java.lang.String[] r0 = r8.f42183L
            int r0 = r0.length
            if (r0 == 0) goto Lc1
            java.lang.String[] r0 = r8.f42184M
            int r0 = r0.length
            if (r0 != 0) goto Ld0
        Lc1:
            java.lang.String r0 = "mCurrentMonthDays maybe not found "
            android.util.Log.w(r3, r0)
            r8.f42220v = r5
            com.huawei.uikit.hwcheckbox.widget.HwCheckBox r8 = r8.f42203e
            if (r8 == 0) goto Ld0
            r0 = 0
            r8.setChecked(r0)
        Ld0:
            return
        Ld1:
            java.lang.String r8 = "yearMonthToDays or indexYearMonth or yearMonthIndex is null."
            android.util.Log.e(r3, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.uikit.hwdatepicker.widget.HwDatePicker.m54255b():void");
    }

    /* renamed from: a */
    private void m54243a(HwAdvancedNumberPicker hwAdvancedNumberPicker, int i10, String[] strArr, boolean z10) {
        hwAdvancedNumberPicker.setDisplayedValues(strArr);
        hwAdvancedNumberPicker.setValue(i10);
        hwAdvancedNumberPicker.setEnabled(z10);
    }

    /* renamed from: a */
    private void m54236a(int i10) {
        this.f42176E = this.f42175D.getAllYearStrings();
        this.f42177F = this.f42175D.getAllLunarNumberYearStrings();
        SparseArray<String> allWesternYearlunarYear = this.f42175D.getAllWesternYearlunarYear();
        String str = allWesternYearlunarYear.get(i10 - 1);
        String str2 = allWesternYearlunarYear.get(i10 + 1);
        Map<String, List<String>> allLunarYearToMonths = this.f42175D.getAllLunarYearToMonths();
        String str3 = this.f42186O;
        if (str3 == null || !str3.equals(this.f42172A)) {
            this.f42178G = HwLunarUtils.listChangeGroup(allLunarYearToMonths.get(this.f42172A));
            this.f42179H = HwLunarUtils.listChangeGroup(allLunarYearToMonths.get(str));
            this.f42180I = HwLunarUtils.listChangeGroup(allLunarYearToMonths.get(str2));
        }
        if (this.f42178G.length == 0 || this.f42179H.length == 0 || this.f42180I.length == 0) {
            Log.w(f42159e0, "mCurrentYearMonths maybe not found ");
            this.f42220v = true;
            HwCheckBox hwCheckBox = this.f42203e;
            if (hwCheckBox != null) {
                hwCheckBox.setChecked(false);
            }
        }
    }

    /* renamed from: c */
    private GregorianCalendar m54262c(int i10) {
        String str;
        String[] strArr = this.f42185N;
        if (strArr.length == 0) {
            return null;
        }
        int i11 = i10 - 1;
        GregorianCalendar gregorianCalendarLunarChangeWestern = this.f42175D.lunarChangeWestern(this.f42172A, this.f42173B, strArr[i11 % strArr.length], true);
        if (this.f42222x) {
            str = this.f42174C;
        } else {
            String[] strArr2 = this.f42185N;
            str = strArr2[i11 % strArr2.length];
        }
        this.f42174C = str;
        return gregorianCalendarLunarChangeWestern;
    }

    /* renamed from: b */
    private int m54252b(int i10, boolean z10, boolean z11) {
        if (z10) {
            String[] minDisplayStrings = HwLunarUtils.getMinDisplayStrings(i10, this.f42181J);
            this.f42181J = minDisplayStrings;
            int iFindIndex = HwLunarUtils.findIndex(this.f42173B, minDisplayStrings);
            this.mMonthSpinner.setDisplayedValues(null);
            this.mMonthSpinner.setMinValue(0);
            this.mMonthSpinner.setMaxValue(this.f42181J.length - 1);
            this.mMonthSpinner.setWrapSelectorWheel(false);
            return iFindIndex;
        }
        if (z11) {
            String[] maxDisplayStrings = HwLunarUtils.getMaxDisplayStrings(i10, this.f42181J);
            this.f42181J = maxDisplayStrings;
            int iFindIndex2 = HwLunarUtils.findIndex(this.f42173B, maxDisplayStrings);
            this.mMonthSpinner.setDisplayedValues(null);
            this.mMonthSpinner.setMinValue(0);
            this.mMonthSpinner.setMaxValue(this.f42181J.length - 1);
            this.mMonthSpinner.setWrapSelectorWheel(false);
            return iFindIndex2;
        }
        this.mMonthSpinner.setDisplayedValues(null);
        this.mMonthSpinner.setMinValue(0);
        this.mMonthSpinner.setMaxValue(this.f42181J.length - 1);
        this.mMonthSpinner.setWrapSelectorWheel(true);
        return i10;
    }

    /* renamed from: a */
    private String[] m54251a(String str, String str2, String str3, String str4) {
        String country = Locale.getDefault().getCountry();
        String[] strArr = (String[]) this.f42185N.clone();
        String[] strArr2 = (String[]) this.f42181J.clone();
        m54246a(strArr, strArr2);
        boolean z10 = "hk".equals(country) || "HK".equals(country);
        boolean z11 = "tw".equals(country) || "TW".equals(country);
        boolean z12 = TextUtils.equals("MO", country) || TextUtils.equals("mo", country);
        if (!z10 && !z11 && !z12) {
            this.mMonthSpinner.setDisplayedValues(strArr2);
        } else {
            String[] strArr3 = (String[]) strArr2.clone();
            int length = strArr2.length;
            for (int i10 = 0; i10 < length; i10++) {
                if (strArr3[i10].equals(str2)) {
                    strArr3[i10] = str;
                } else if (strArr3[i10].length() == 3 && str4.equals(strArr3[i10].substring(0, 1))) {
                    strArr3[i10] = strArr3[i10].replace(str4, str3);
                }
            }
            this.mMonthSpinner.setDisplayedValues(strArr3);
        }
        return (String[]) strArr.clone();
    }

    /* renamed from: b */
    private boolean m54259b(GregorianCalendar gregorianCalendar) {
        if (!this.f42212n.before(gregorianCalendar)) {
            return false;
        }
        this.f42212n.set(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5));
        return true;
    }

    /* renamed from: b */
    private GregorianCalendar m54254b(int i10, int i11) {
        int length = this.f42181J.length - 1;
        String str = "";
        if (m54258b(i10, i11, length)) {
            String str2 = this.f42175D.getAllWesternYearlunarYear().get(this.f42175D.getAllLunarYearWesternYear().get(this.f42172A).intValue() + 1);
            if (i11 >= 0) {
                String[] strArr = this.f42181J;
                if (i11 < strArr.length) {
                    str = strArr[i11];
                }
            }
            GregorianCalendar gregorianCalendarLunarChangeWestern = this.f42175D.lunarChangeWestern(str2, str, this.f42174C, 1, true);
            if (!this.f42222x || gregorianCalendarLunarChangeWestern != null || !this.f42174C.equals(HwConstants.LUNAR_DAY_THIRTY)) {
                return gregorianCalendarLunarChangeWestern;
            }
            this.f42174C = HwConstants.LUNAR_DAY_TWEENTY_NINE;
            return this.f42175D.lunarChangeWestern(str2, str, HwConstants.LUNAR_DAY_TWEENTY_NINE, 1, true);
        }
        if (i10 == 0 && i11 == length) {
            String str3 = this.f42175D.getAllWesternYearlunarYear().get(this.f42175D.getAllLunarYearWesternYear().get(this.f42172A).intValue() - 1);
            if (i11 >= 0) {
                String[] strArr2 = this.f42181J;
                if (i11 < strArr2.length) {
                    str = strArr2[i11];
                }
            }
            GregorianCalendar gregorianCalendarLunarChangeWestern2 = this.f42175D.lunarChangeWestern(str3, str, this.f42174C, 1, true);
            if (!this.f42222x || gregorianCalendarLunarChangeWestern2 != null || !this.f42174C.equals(HwConstants.LUNAR_DAY_THIRTY)) {
                return gregorianCalendarLunarChangeWestern2;
            }
            this.f42174C = HwConstants.LUNAR_DAY_TWEENTY_NINE;
            return this.f42175D.lunarChangeWestern(str3, str, HwConstants.LUNAR_DAY_TWEENTY_NINE, 1, true);
        }
        if (i11 >= 0) {
            String[] strArr3 = this.f42181J;
            if (i11 < strArr3.length) {
                str = strArr3[i11];
            }
        }
        GregorianCalendar gregorianCalendarLunarChangeWestern3 = this.f42175D.lunarChangeWestern(this.f42172A, str, this.f42174C, 1, true);
        if (!this.f42222x || gregorianCalendarLunarChangeWestern3 != null || !this.f42174C.equals(HwConstants.LUNAR_DAY_THIRTY)) {
            return gregorianCalendarLunarChangeWestern3;
        }
        this.f42174C = HwConstants.LUNAR_DAY_TWEENTY_NINE;
        return this.f42175D.lunarChangeWestern(this.f42172A, str, HwConstants.LUNAR_DAY_TWEENTY_NINE, 1, true);
    }

    /* renamed from: a */
    private int m54230a(int i10, boolean z10, boolean z11) {
        if (z10) {
            String[] minDisplayStrings = HwLunarUtils.getMinDisplayStrings(i10, this.f42185N);
            this.f42185N = minDisplayStrings;
            int iFindIndex = HwLunarUtils.findIndex(this.f42174C, minDisplayStrings);
            this.mDaySpinner.setDisplayedValues(null);
            this.mDaySpinner.setMinValue(0);
            this.mDaySpinner.setMaxValue(this.f42185N.length - 1);
            this.mDaySpinner.setWrapSelectorWheel(false);
            return iFindIndex;
        }
        if (z11) {
            String[] maxDisplayStrings = HwLunarUtils.getMaxDisplayStrings(i10, this.f42185N);
            this.f42185N = maxDisplayStrings;
            int iFindIndex2 = HwLunarUtils.findIndex(this.f42174C, maxDisplayStrings);
            this.mDaySpinner.setDisplayedValues(null);
            this.mDaySpinner.setMinValue(0);
            this.mDaySpinner.setMaxValue(this.f42185N.length - 1);
            this.mDaySpinner.setWrapSelectorWheel(false);
            return iFindIndex2;
        }
        this.mDaySpinner.setDisplayedValues(null);
        this.mDaySpinner.setMinValue(0);
        this.mDaySpinner.setMaxValue(this.f42185N.length - 1);
        this.mDaySpinner.setWrapSelectorWheel(true);
        return i10;
    }

    /* renamed from: a */
    private boolean m54249a(GregorianCalendar gregorianCalendar) {
        if (!this.f42212n.after(gregorianCalendar)) {
            return false;
        }
        this.f42212n.set(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5) + 1);
        return true;
    }

    /* renamed from: a */
    private void m54238a(int i10, String[] strArr) {
        if (this.f42224z.getLunarYearNum() == 1900 && i10 == 2) {
            strArr[0] = "";
            strArr[1] = "";
        } else if (this.f42224z.getLunarYearNum() == 1901 && i10 == 3) {
            strArr[1] = "";
        } else {
            Log.w(f42159e0, "no need to hide year.");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x000a  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.GregorianCalendar m54253b(int r5) {
        /*
            r4 = this;
            if (r5 < 0) goto La
            java.lang.String[] r0 = r4.f42185N
            int r1 = r0.length
            if (r5 >= r1) goto La
            r5 = r0[r5]
            goto Lc
        La:
            java.lang.String r5 = ""
        Lc:
            com.huawei.uikit.hwlunar.utils.HwLunarDataOperate r0 = r4.f42175D
            java.lang.String r1 = r4.f42172A
            java.lang.String r2 = r4.f42173B
            r3 = 0
            java.util.GregorianCalendar r5 = r0.lunarChangeWestern(r1, r2, r5, r3)
            boolean r0 = r4.f42222x
            if (r0 == 0) goto L46
            if (r5 != 0) goto L46
            java.lang.String r0 = r4.f42174C
            java.lang.String r1 = "初一"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L46
            java.lang.String r5 = "三十"
            r4.f42174C = r5
            com.huawei.uikit.hwlunar.utils.HwLunarDataOperate r0 = r4.f42175D
            java.lang.String r1 = r4.f42172A
            java.lang.String r2 = r4.f42173B
            java.util.GregorianCalendar r5 = r0.lunarChangeWestern(r1, r2, r5, r3)
            if (r5 != 0) goto L46
            java.lang.String r5 = "廿九"
            r4.f42174C = r5
            com.huawei.uikit.hwlunar.utils.HwLunarDataOperate r0 = r4.f42175D
            java.lang.String r1 = r4.f42172A
            java.lang.String r4 = r4.f42173B
            r2 = 1
            java.util.GregorianCalendar r5 = r0.lunarChangeWestern(r1, r4, r5, r2)
        L46:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.uikit.hwdatepicker.widget.HwDatePicker.m54253b(int):java.util.GregorianCalendar");
    }

    /* renamed from: a */
    private void m54246a(String[] strArr, String[] strArr2) {
        if (this.f42224z.getLunarYearNum() == 1900) {
            if (this.f42224z.getLunarMonthNum() == 1 && this.f42224z.getLunarDayNum() == 2 && strArr.length > 28) {
                strArr[28] = "";
            }
            if ((this.f42224z.getLunarMonthNum() == 1 || this.f42224z.getLunarMonthNum() == 2) && strArr2.length > 12) {
                strArr2[11] = "";
                strArr2[12] = "";
            }
        }
    }

    /* renamed from: b */
    private String[] m54260b(int i10, String[] strArr, String[] strArr2) {
        ArrayList arrayList = new ArrayList(10);
        ArrayList arrayList2 = new ArrayList(10);
        HwLunarUtils.getTwoMinList(i10, strArr, strArr2, arrayList, arrayList2);
        String[] strArr3 = new String[arrayList.size()];
        String[] strArr4 = new String[arrayList.size()];
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            strArr3[i11] = (String) arrayList.get(i11);
            strArr4[i11] = (String) arrayList2.get(i11);
        }
        this.f42177F = strArr4;
        return strArr3;
    }

    /* renamed from: a */
    private void m54242a(HwAdvancedNumberPicker hwAdvancedNumberPicker, int i10, int i11) {
        GregorianCalendar gregorianCalendarM54232a;
        GregorianCalendar gregorianCalendar;
        GregorianCalendar gregorianCalendar2 = this.f42209k;
        if (gregorianCalendar2 != null && (gregorianCalendar = this.f42212n) != null) {
            gregorianCalendar2.setTimeInMillis(gregorianCalendar.getTimeInMillis());
        }
        if (hwAdvancedNumberPicker == this.mYearSpinner && this.f42176E != null) {
            gregorianCalendarM54232a = m54280g(i11);
        } else if (hwAdvancedNumberPicker == this.mMonthSpinner && this.f42181J != null) {
            if (!this.f42196a0) {
                gregorianCalendarM54232a = m54268d(i11);
            } else {
                gregorianCalendarM54232a = m54254b(i10, i11);
            }
        } else if (hwAdvancedNumberPicker == this.mDaySpinner && this.f42185N != null) {
            if (!this.f42196a0) {
                gregorianCalendarM54232a = m54253b(i11);
            } else {
                gregorianCalendarM54232a = m54232a(i10, i11);
            }
        } else {
            Log.w(f42159e0, "error spinner value change");
            gregorianCalendarM54232a = null;
        }
        GregorianCalendar gregorianCalendar3 = this.f42209k;
        if (gregorianCalendar3 != null && gregorianCalendarM54232a != null) {
            gregorianCalendar3.setTimeInMillis(gregorianCalendarM54232a.getTimeInMillis());
        } else {
            Log.w(f42159e0, "error date");
        }
    }

    /* renamed from: a */
    private void m54241a(HwAdvancedNumberPicker hwAdvancedNumberPicker, int i10) {
        GregorianCalendar gregorianCalendarM54262c;
        GregorianCalendar gregorianCalendar;
        GregorianCalendar gregorianCalendar2 = this.f42209k;
        if (gregorianCalendar2 != null && (gregorianCalendar = this.f42212n) != null) {
            gregorianCalendar2.setTimeInMillis(gregorianCalendar.getTimeInMillis());
        }
        if (hwAdvancedNumberPicker == this.mYearSpinner && this.f42176E != null) {
            gregorianCalendarM54262c = m54277f(i10);
        } else if (hwAdvancedNumberPicker == this.mMonthSpinner && this.f42181J != null) {
            gregorianCalendarM54262c = m54273e(i10);
        } else if (hwAdvancedNumberPicker == this.mDaySpinner && this.f42185N != null) {
            gregorianCalendarM54262c = m54262c(i10);
        } else {
            Log.w(f42159e0, "error spinner value change");
            gregorianCalendarM54262c = null;
        }
        GregorianCalendar gregorianCalendar3 = this.f42209k;
        if (gregorianCalendar3 == null || gregorianCalendarM54262c == null) {
            return;
        }
        gregorianCalendar3.setTimeInMillis(gregorianCalendarM54262c.getTimeInMillis());
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00cd  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.GregorianCalendar m54232a(int r6, int r7) {
        /*
            r5 = this;
            java.lang.String[] r0 = r5.f42185N
            int r0 = r0.length
            r1 = 1
            int r0 = r0 - r1
            boolean r2 = r5.m54258b(r6, r7, r0)
            r3 = 0
            java.lang.String r4 = "_"
            if (r2 == 0) goto L64
            com.huawei.uikit.hwlunar.utils.HwLunarDataOperate r6 = r5.f42175D
            java.util.Map r6 = r6.getAllLunarYearMonthIndex()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = r5.f42172A
            r0.append(r2)
            r0.append(r4)
            java.lang.String r2 = r5.f42173B
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.Object r6 = r6.get(r0)
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            boolean r0 = r5.f42221w
            if (r0 == 0) goto L3a
            int r6 = r6 + 1
        L3a:
            com.huawei.uikit.hwlunar.utils.HwLunarDataOperate r0 = r5.f42175D
            java.util.Map r0 = r0.getAllIndexLunarYearMonth()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.Object r6 = r0.get(r6)
            java.lang.String r6 = (java.lang.String) r6
            java.lang.String[] r6 = r6.split(r4)
            int r0 = r6.length
            if (r0 <= r1) goto Lc1
            java.lang.String[] r0 = r5.f42185N
            int r2 = r0.length
            if (r2 <= r7) goto Lc1
            com.huawei.uikit.hwlunar.utils.HwLunarDataOperate r5 = r5.f42175D
            r2 = r6[r3]
            r6 = r6[r1]
            r7 = r0[r7]
            java.util.GregorianCalendar r5 = r5.lunarChangeWestern(r2, r6, r7, r1)
            goto Ld9
        L64:
            boolean r6 = r5.m54276e(r6, r7, r0)
            if (r6 == 0) goto Lc3
            com.huawei.uikit.hwlunar.utils.HwLunarDataOperate r6 = r5.f42175D
            java.util.Map r6 = r6.getAllLunarYearMonthIndex()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = r5.f42172A
            r0.append(r2)
            r0.append(r4)
            java.lang.String r2 = r5.f42173B
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.Object r6 = r6.get(r0)
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            boolean r0 = r5.f42221w
            if (r0 == 0) goto L96
            int r6 = r6 + (-1)
        L96:
            com.huawei.uikit.hwlunar.utils.HwLunarDataOperate r0 = r5.f42175D
            java.util.Map r0 = r0.getAllIndexLunarYearMonth()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.Object r6 = r0.get(r6)
            java.lang.String r6 = (java.lang.String) r6
            java.lang.String[] r6 = r6.split(r4)
            int r0 = r6.length
            if (r0 <= r1) goto Lc1
            java.lang.String[] r0 = r5.f42185N
            int r2 = r0.length
            if (r2 <= r7) goto Lc1
            if (r7 < 0) goto Lc1
            com.huawei.uikit.hwlunar.utils.HwLunarDataOperate r5 = r5.f42175D
            r2 = r6[r3]
            r6 = r6[r1]
            r7 = r0[r7]
            java.util.GregorianCalendar r5 = r5.lunarChangeWestern(r2, r6, r7, r1)
            goto Ld9
        Lc1:
            r5 = 0
            goto Ld9
        Lc3:
            if (r7 < 0) goto Lcd
            java.lang.String[] r6 = r5.f42185N
            int r0 = r6.length
            if (r7 >= r0) goto Lcd
            r6 = r6[r7]
            goto Lcf
        Lcd:
            java.lang.String r6 = ""
        Lcf:
            com.huawei.uikit.hwlunar.utils.HwLunarDataOperate r7 = r5.f42175D
            java.lang.String r0 = r5.f42172A
            java.lang.String r5 = r5.f42173B
            java.util.GregorianCalendar r5 = r7.lunarChangeWestern(r0, r5, r6, r1)
        Ld9:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.uikit.hwdatepicker.widget.HwDatePicker.m54232a(int, int):java.util.GregorianCalendar");
    }

    /* renamed from: a */
    private String[] m54250a(int i10, String[] strArr, String[] strArr2) {
        ArrayList arrayList = new ArrayList(10);
        ArrayList arrayList2 = new ArrayList(10);
        HwLunarUtils.getTwoMaxList(i10, strArr, strArr2, arrayList, arrayList2);
        String[] strArr3 = new String[arrayList.size()];
        String[] strArr4 = new String[arrayList.size()];
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            strArr3[i11] = (String) arrayList.get(i11);
            strArr4[i11] = (String) arrayList2.get(i11);
        }
        this.f42177F = strArr4;
        return strArr3;
    }
}
