package com.huawei.uikit.hwdatepicker.widget;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Outline;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwDeviceUtils;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwLanguageUtils;
import com.huawei.uikit.hwdatepicker.C8710R;
import com.huawei.uikit.hwdatepicker.utils.HwDatePickerUtils;
import com.huawei.uikit.hwdatepicker.widget.HwDatePicker;
import com.huawei.uikit.hwlunar.utils.HwLunarUtils;
import com.huawei.uikit.hwresources.utils.AuxiliaryHelper;
import com.huawei.uikit.hwresources.utils.HwWidgetInstantiator;
import com.huawei.uikit.hwtextview.widget.HwTextView;
import java.util.GregorianCalendar;

/* loaded from: classes7.dex */
public class HwDatePickerDialog extends AlertDialog implements HwDatePicker.OnDateChangedListener {

    /* renamed from: A */
    private static final int f42232A = 2;

    /* renamed from: B */
    private static final int f42233B = 13;

    /* renamed from: C */
    private static final int f42234C = 16;

    /* renamed from: D */
    private static final double f42235D = 0.65d;

    /* renamed from: E */
    private static final float f42236E = 32.0f;

    /* renamed from: F */
    private static final float f42237F = 40.0f;

    /* renamed from: G */
    private static final float f42238G = 35.0f;

    /* renamed from: H */
    private static int f42239H = 0;

    /* renamed from: p */
    private static final String f42240p = "HwDatePickerDialog";

    /* renamed from: q */
    private static final int f42241q = 7;

    /* renamed from: r */
    private static final String f42242r = "year";

    /* renamed from: s */
    private static final String f42243s = "month";

    /* renamed from: t */
    private static final String f42244t = "day";

    /* renamed from: u */
    private static final String f42245u = "is_support_lunar_switch";

    /* renamed from: v */
    private static final String f42246v = "is_western";

    /* renamed from: w */
    private static final String f42247w = "is_show_all_years";

    /* renamed from: x */
    private static final String f42248x = "dialog_title";

    /* renamed from: y */
    private static final int f42249y = 8;

    /* renamed from: z */
    private static final int f42250z = 2;

    /* renamed from: a */
    private HwDatePicker f42251a;

    /* renamed from: b */
    private boolean f42252b;

    /* renamed from: c */
    private HwTextView f42253c;

    /* renamed from: d */
    private LinearLayout f42254d;

    /* renamed from: e */
    private LinearLayout f42255e;

    /* renamed from: f */
    private LinearLayout f42256f;

    /* renamed from: g */
    private LinearLayout f42257g;

    /* renamed from: h */
    private Activity f42258h;

    /* renamed from: i */
    private HwTextView f42259i;

    /* renamed from: j */
    private HwTextView f42260j;

    /* renamed from: k */
    private boolean f42261k;

    /* renamed from: l */
    private String f42262l;

    /* renamed from: m */
    private GregorianCalendar f42263m;
    protected OnButtonClickCallback mCallBack;
    protected Context mThemeContext;

    /* renamed from: n */
    private boolean f42264n;

    /* renamed from: o */
    private View f42265o;

    public interface OnButtonClickCallback {
        void onNegativeButtonClick(HwDatePicker hwDatePicker);

        void onPositiveButtonClick(HwDatePicker hwDatePicker);
    }

    public class aauaf implements View.OnClickListener {
        public aauaf() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (HwDatePickerDialog.this.m54339j()) {
                HwDatePickerDialog.this.m54331f();
                return;
            }
            HwDatePickerDialog.this.f42251a.m54302l();
            HwDatePickerDialog.this.f42259i.setText(C8710R.string.dialog_button_done_new);
            HwDatePickerDialog.this.f42260j.setText(C8710R.string.dialog_button_last_step);
            HwDatePickerDialog.this.m54325c();
        }
    }

    public class akxao implements View.OnLayoutChangeListener {

        /* renamed from: a */
        final /* synthetic */ Window f42267a;

        public akxao(Window window) {
            this.f42267a = window;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            int unused = HwDatePickerDialog.f42239H = HwDatePickerDialog.this.mThemeContext.getResources().getConfiguration().orientation;
            DisplayMetrics displayMetrics = HwDatePickerDialog.this.mThemeContext.getResources().getDisplayMetrics();
            WindowManager.LayoutParams attributes = this.f42267a.getAttributes();
            if (HwDeviceUtils.isTablet() || HwDeviceUtils.isWideScreenPhone(HwDatePickerDialog.this.f42258h) || HwDeviceUtils.isTripleFoldDevice()) {
                HwDatePickerDialog.this.m54321b(attributes, displayMetrics);
            } else if (HwDatePickerUtils.isMultiWindowActivity(HwDatePickerDialog.this.f42258h)) {
                HwDatePickerDialog.this.m54315a(attributes, displayMetrics);
            } else if (HwDatePickerDialog.f42239H == 2) {
                HwDatePickerDialog.this.m54318a(true, attributes, displayMetrics);
            } else {
                HwDatePickerDialog.this.m54318a(false, attributes, displayMetrics);
            }
            this.f42267a.setAttributes(attributes);
        }
    }

    public class bqmxo implements View.OnClickListener {
        public bqmxo() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (HwDatePickerDialog.this.m54336i()) {
                HwDatePickerDialog.this.m54329e();
                return;
            }
            HwDatePickerDialog.this.f42251a.m54303m();
            HwDatePickerDialog.this.f42259i.setText(C8710R.string.dialog_button_next_step);
            HwDatePickerDialog.this.f42260j.setText(C8710R.string.discard_label);
            HwDatePickerDialog.this.m54326d();
        }
    }

    public class bzrwd implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f42270a;

        /* renamed from: b */
        final /* synthetic */ TypedValue f42271b;

        /* renamed from: com.huawei.uikit.hwdatepicker.widget.HwDatePickerDialog$bzrwd$bzrwd, reason: collision with other inner class name */
        public class C14497bzrwd extends ViewOutlineProvider {
            public C14497bzrwd() {
            }

            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), bzrwd.this.f42270a);
                HwDatePickerDialog.this.mThemeContext.getTheme().resolveAttribute(C8710R.attr.hwBackgroundColor, bzrwd.this.f42271b, true);
                HwDatePickerDialog.this.f42265o.setBackgroundColor(bzrwd.this.f42271b.data);
            }
        }

        public bzrwd(int i10, TypedValue typedValue) {
            this.f42270a = i10;
            this.f42271b = typedValue;
        }

        @Override // java.lang.Runnable
        public void run() {
            HwDatePickerDialog.this.f42265o.setOutlineProvider(new C14497bzrwd());
            HwDatePickerDialog.this.f42265o.setClipToOutline(true);
        }
    }

    public HwDatePickerDialog(Activity activity, OnButtonClickCallback onButtonClickCallback) {
        this(activity, C8710R.style.Widget_Emui_HwDatePickerDialogStyle, onButtonClickCallback, null);
    }

    public static HwDatePickerDialog instantiate(Activity activity, OnButtonClickCallback onButtonClickCallback) {
        return instantiate(activity, C8710R.style.Widget_Emui_HwDatePickerDialogStyle, onButtonClickCallback, null);
    }

    /* renamed from: l */
    private void m54342l() {
        m54343m();
        this.f42251a.m54303m();
        this.f42251a.m54301k();
    }

    /* renamed from: m */
    private void m54343m() {
        if (HwWidgetInstantiator.getCurrentType(this.mThemeContext) == 1 && Float.compare(AuxiliaryHelper.getFontSize(this.mThemeContext), 1.75f) >= 0 && !AuxiliaryHelper.isMultiWindowActivity(this.mThemeContext)) {
            this.f42253c.setMaxLines(2);
            this.f42253c.setAutoTextSize(1, f42238G);
            if (Float.compare(AuxiliaryHelper.getFontSize(this.mThemeContext), 2.0f) >= 0) {
                this.f42253c.setAutoTextSize(1, f42237F);
            }
        }
    }

    public void displayTitle() {
        if (this.f42251a != null && "".equals(this.f42253c.getText().toString())) {
            setDialogTitle(m54313a(this.f42251a.getMonth(), this.f42251a.getDayOfMonth(), this.f42263m));
        }
    }

    public HwDatePicker getDatePicker() {
        return this.f42251a;
    }

    public boolean getmIsConstantTitle() {
        return this.f42261k;
    }

    public void handleConfigrationChange() {
        HwDatePicker hwDatePicker = this.f42251a;
        if (hwDatePicker == null) {
            return;
        }
        hwDatePicker.handleConfigrationChange();
    }

    public void initDialogStyle() {
        Window window = getWindow();
        f42239H = this.mThemeContext.getResources().getConfiguration().orientation;
        if (window != null && this.f42258h != null) {
            window.setWindowAnimations(C8710R.style.Widget_Emui_HwDatePickerDialogAnim);
            DisplayMetrics displayMetrics = this.mThemeContext.getResources().getDisplayMetrics();
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (HwDeviceUtils.isTablet() || HwDeviceUtils.isWideScreenPhone(this.f42258h) || HwDeviceUtils.isTripleFoldDevice()) {
                window.setGravity(17);
                m54321b(attributes, displayMetrics);
            } else if (HwDatePickerUtils.isMultiWindowActivity(this.f42258h)) {
                window.setGravity(17);
                m54315a(attributes, displayMetrics);
            } else if (f42239H == 2) {
                window.setGravity(17);
                m54318a(true, attributes, displayMetrics);
            } else {
                window.setGravity(80);
                m54318a(false, attributes, displayMetrics);
            }
            window.setAttributes(attributes);
        }
        HwDatePicker hwDatePicker = this.f42251a;
        if (hwDatePicker != null) {
            hwDatePicker.handleConfigrationChange();
        }
    }

    @Override // com.huawei.uikit.hwdatepicker.widget.HwDatePicker.OnDateChangedListener
    public void onDateChanged(HwDatePicker hwDatePicker, int i10, int i11, int i12, GregorianCalendar gregorianCalendar) {
        HwDatePicker hwDatePicker2 = this.f42251a;
        if (hwDatePicker2 == null) {
            return;
        }
        hwDatePicker2.init(i10, i11, i12, this);
        if (this.f42264n) {
            return;
        }
        setDialogTitle(m54313a(i11, i12, gregorianCalendar));
    }

    @Override // android.app.Dialog
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        if (bundle == null) {
            return;
        }
        try {
            int i10 = bundle.getInt(f42242r, 1);
            int i11 = bundle.getInt(f42243s, 0);
            int i12 = bundle.getInt(f42244t, 1);
            if (this.f42263m == null) {
                this.f42263m = new GregorianCalendar();
            }
            this.f42263m.set(i10, i11, i12);
            HwDatePicker hwDatePicker = this.f42251a;
            if (hwDatePicker != null) {
                hwDatePicker.init(i10, i11, i12, this);
                this.f42251a.setLunarOrWestern(this.f42252b);
            }
            boolean z10 = bundle.getBoolean(f42245u, false);
            boolean z11 = bundle.getBoolean(f42246v, true);
            boolean z12 = bundle.getBoolean(f42247w, true);
            HwDatePicker hwDatePicker2 = this.f42251a;
            if (hwDatePicker2 != null) {
                hwDatePicker2.setmIsSupportLunarSwitch(z10);
                this.f42251a.setmIsWestern(z11);
                this.f42251a.setIsShowAllYears(z12);
            }
            if (this.f42264n) {
                return;
            }
            String string = bundle.getString(f42248x, null);
            if (string == null) {
                string = m54313a(i11, i12, this.f42263m);
            }
            setDialogTitle(string);
        } catch (BadParcelableException unused) {
            Log.e(f42240p, "onRestoreInstanceState: Bad parcel target.");
        }
    }

    @Override // android.app.Dialog
    public Bundle onSaveInstanceState() {
        HwTextView hwTextView;
        Bundle bundleOnSaveInstanceState = super.onSaveInstanceState();
        try {
            HwDatePicker hwDatePicker = this.f42251a;
            boolean z10 = true;
            int year = hwDatePicker == null ? 1 : hwDatePicker.getYear();
            HwDatePicker hwDatePicker2 = this.f42251a;
            int month = hwDatePicker2 == null ? 1 : hwDatePicker2.getMonth();
            HwDatePicker hwDatePicker3 = this.f42251a;
            int dayOfMonth = hwDatePicker3 == null ? 1 : hwDatePicker3.getDayOfMonth();
            bundleOnSaveInstanceState.putInt(f42242r, year);
            bundleOnSaveInstanceState.putInt(f42243s, month);
            bundleOnSaveInstanceState.putInt(f42244t, dayOfMonth);
            HwDatePicker hwDatePicker4 = this.f42251a;
            boolean z11 = hwDatePicker4 != null && hwDatePicker4.isSupportLunarSwitch();
            HwDatePicker hwDatePicker5 = this.f42251a;
            boolean z12 = hwDatePicker5 != null && hwDatePicker5.isWestern();
            HwDatePicker hwDatePicker6 = this.f42251a;
            if (hwDatePicker6 == null || !hwDatePicker6.isShowAllYears()) {
                z10 = false;
            }
            bundleOnSaveInstanceState.putBoolean(f42245u, z11);
            bundleOnSaveInstanceState.putBoolean(f42246v, z12);
            bundleOnSaveInstanceState.putBoolean(f42247w, z10);
            if (!this.f42264n && (hwTextView = this.f42253c) != null) {
                bundleOnSaveInstanceState.putString(f42248x, hwTextView.getText().toString());
            }
        } catch (BadParcelableException unused) {
            Log.e(f42240p, "onSaveInstanceState: Bad parcel target.");
        }
        return bundleOnSaveInstanceState;
    }

    @Override // android.app.Dialog
    public void onStart() {
        resizeDatePickerDialogWidth();
    }

    @Override // android.app.Dialog
    public void onStop() {
    }

    public void refreshDialog() {
        initDialogStyle();
    }

    public void resizeDatePickerDialogWidth() {
        Window window = getWindow();
        if (window == null || this.f42258h == null) {
            return;
        }
        window.getDecorView().addOnLayoutChangeListener(new akxao(window));
    }

    public void setButtonColor(int i10) {
        HwTextView hwTextView = this.f42259i;
        if (hwTextView != null) {
            hwTextView.setTextColor(i10);
        }
        HwTextView hwTextView2 = this.f42260j;
        if (hwTextView2 != null) {
            hwTextView2.setTextColor(i10);
        }
    }

    public void setDateLimit(GregorianCalendar gregorianCalendar, GregorianCalendar gregorianCalendar2) {
        HwDatePicker hwDatePicker = this.f42251a;
        if (hwDatePicker == null) {
            return;
        }
        hwDatePicker.updateDateLimit(gregorianCalendar, gregorianCalendar2);
    }

    public void setDialogTitle(String str) {
        HwTextView hwTextView = this.f42253c;
        if (hwTextView != null) {
            hwTextView.setText(str);
            this.f42253c.requestLayout();
        }
    }

    public void setIsLunarTime(boolean z10) {
        this.f42252b = z10;
        HwDatePicker hwDatePicker = this.f42251a;
        if (hwDatePicker != null) {
            hwDatePicker.setLunarOrWestern(z10);
        }
    }

    public void setLunarSwitch(boolean z10) {
        HwDatePicker hwDatePicker = this.f42251a;
        if (hwDatePicker != null) {
            hwDatePicker.setmIsSupportLunarSwitch(z10);
        }
    }

    public void setModuleColor(int i10) {
        HwDatePicker hwDatePicker = this.f42251a;
        if (hwDatePicker != null) {
            hwDatePicker.setSpinnersSelectorPaintColor(i10);
        }
        setButtonColor(i10);
    }

    public void setOnButtonClickCallback(OnButtonClickCallback onButtonClickCallback) {
        this.mCallBack = onButtonClickCallback;
    }

    public void setShowAllYears(boolean z10) {
        HwDatePicker hwDatePicker = this.f42251a;
        if (hwDatePicker != null) {
            hwDatePicker.setIsShowAllYears(z10);
        }
    }

    public void setSpinnersUnselectedPaintColor(int i10) {
        HwDatePicker hwDatePicker = this.f42251a;
        if (hwDatePicker != null) {
            hwDatePicker.setSpinnersUnselectedPaintColor(i10);
        }
    }

    public void setTitleStyle(boolean z10, String str) {
        if (str == null) {
            this.f42261k = false;
        } else {
            this.f42261k = z10;
        }
        if (this.f42261k) {
            this.f42262l = str;
        }
    }

    public void setWestern(boolean z10) {
        HwDatePicker hwDatePicker = this.f42251a;
        if (hwDatePicker != null) {
            hwDatePicker.setmIsWestern(z10);
        }
    }

    public void setYearLimit(int i10, int i11) {
        HwDatePicker hwDatePicker = this.f42251a;
        if (hwDatePicker == null) {
            return;
        }
        hwDatePicker.updateYearLimit(i10, i11);
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        setContentView(this.f42265o);
        initDialogStyle();
        displayTitle();
    }

    public void updateDate(int i10, int i11, int i12) {
        HwDatePicker hwDatePicker = this.f42251a;
        if (hwDatePicker == null) {
            return;
        }
        hwDatePicker.updateDate(i10, i11, i12);
    }

    public HwDatePickerDialog(Activity activity, int i10, OnButtonClickCallback onButtonClickCallback, GregorianCalendar gregorianCalendar) {
        super(activity, i10);
        this.f42252b = false;
        this.f42261k = false;
        this.f42262l = null;
        this.mCallBack = onButtonClickCallback;
        Context context = getContext();
        this.mThemeContext = context;
        this.f42258h = activity;
        f42239H = context.getResources().getConfiguration().orientation;
        this.f42264n = this.mThemeContext.getResources().getInteger(C8710R.integer.emui_device_type) == 2;
        m54334h();
        this.f42265o.post(new bzrwd(getContext().getResources().getDimensionPixelSize(C8710R.dimen.emui_corner_radius_dialog), new TypedValue()));
        m54333g();
        setIcon(0);
        if (gregorianCalendar == null) {
            this.f42263m = new GregorianCalendar();
        } else {
            this.f42263m = gregorianCalendar;
        }
        this.f42251a.init(this.f42263m.get(1), this.f42263m.get(2), this.f42263m.get(5), this);
        m54342l();
        m54340k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m54325c() {
        if ((f42239H != 2 || HwDeviceUtils.isWideScreenPhone(this.f42258h) || HwDeviceUtils.isTablet()) && Float.compare(AuxiliaryHelper.getFontSize(this.mThemeContext), 2.0f) >= 0) {
            this.f42256f.removeView(this.f42259i);
            this.f42256f.addView(this.f42259i);
            m54314a(this.f42259i);
            m54314a(this.f42260j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m54326d() {
        if ((f42239H != 2 || HwDeviceUtils.isWideScreenPhone(this.f42258h) || HwDeviceUtils.isTablet()) && Float.compare(AuxiliaryHelper.getFontSize(this.mThemeContext), 2.0f) >= 0) {
            this.f42256f.removeView(this.f42260j);
            this.f42256f.addView(this.f42260j);
            m54314a(this.f42259i);
            m54314a(this.f42260j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m54329e() {
        dismiss();
        HwDatePicker hwDatePicker = this.f42251a;
        if (hwDatePicker == null || this.mCallBack == null) {
            return;
        }
        hwDatePicker.clearFocus();
        this.mCallBack.onNegativeButtonClick(this.f42251a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m54331f() {
        dismiss();
        HwDatePicker hwDatePicker = this.f42251a;
        if (hwDatePicker == null || this.mCallBack == null) {
            return;
        }
        hwDatePicker.clearFocus();
        this.mCallBack.onPositiveButtonClick(this.f42251a);
    }

    /* renamed from: g */
    private void m54333g() {
        if (this.f42264n) {
            return;
        }
        m54319b();
        this.f42259i.setOnClickListener(new aauaf());
        this.f42260j.setOnClickListener(new bqmxo());
    }

    /* renamed from: h */
    private void m54334h() {
        View viewInflate = View.inflate(this.mThemeContext, C8710R.layout.hwdatepicker_dialog, null);
        this.f42265o = viewInflate;
        this.f42254d = (LinearLayout) viewInflate.findViewById(C8710R.id.hwdatepicker_dialog_title_layout);
        this.f42257g = (LinearLayout) this.f42265o.findViewById(C8710R.id.hwdatepicker_dialog_content_layout);
        this.f42256f = (LinearLayout) this.f42265o.findViewById(C8710R.id.hwdatepicker_dialog_button_layout);
        this.f42253c = (HwTextView) this.f42265o.findViewById(C8710R.id.hwdatepicker_dialog_title);
        this.f42251a = (HwDatePicker) this.f42265o.findViewById(C8710R.id.hwdatepicker_dialog_date_picker);
        this.f42259i = (HwTextView) this.f42265o.findViewById(C8710R.id.hwdatepicker_dialog_positive_btn);
        this.f42260j = (HwTextView) this.f42265o.findViewById(C8710R.id.hwdatepicker_dialog_negative_btn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public boolean m54336i() {
        if (Float.compare(AuxiliaryHelper.getFontSize(this.mThemeContext), 1.75f) < 0) {
            return true;
        }
        return this.mThemeContext.getResources().getString(C8710R.string.discard_label).contentEquals(this.f42260j.getText());
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0074 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.huawei.uikit.hwdatepicker.widget.HwDatePickerDialog instantiate(android.app.Activity r9, int r10, com.huawei.uikit.hwdatepicker.widget.HwDatePickerDialog.OnButtonClickCallback r11, java.util.GregorianCalendar r12) throws java.lang.IllegalAccessException, java.lang.InstantiationException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            r0 = 0
            if (r9 != 0) goto L4
            return r0
        L4:
            r1 = 7
            r2 = 1
            int r1 = com.huawei.uikit.hwresources.utils.HwWidgetInstantiator.getCurrentType(r9, r1, r2)
            java.lang.Class<com.huawei.uikit.hwdatepicker.widget.HwDatePickerDialog> r3 = com.huawei.uikit.hwdatepicker.widget.HwDatePickerDialog.class
            java.lang.String r1 = com.huawei.uikit.hwresources.utils.HwWidgetInstantiator.getDeviceClassName(r9, r3, r1)
            java.lang.ClassLoader r3 = r9.getClassLoader()     // Catch: java.lang.InstantiationException -> L45 java.lang.IllegalAccessException -> L4d java.lang.reflect.InvocationTargetException -> L55 java.lang.NoSuchMethodException -> L5d java.lang.ClassNotFoundException -> L65
            java.lang.Class r1 = r3.loadClass(r1)     // Catch: java.lang.InstantiationException -> L45 java.lang.IllegalAccessException -> L4d java.lang.reflect.InvocationTargetException -> L55 java.lang.NoSuchMethodException -> L5d java.lang.ClassNotFoundException -> L65
            r3 = 4
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch: java.lang.InstantiationException -> L45 java.lang.IllegalAccessException -> L4d java.lang.reflect.InvocationTargetException -> L55 java.lang.NoSuchMethodException -> L5d java.lang.ClassNotFoundException -> L65
            java.lang.Class<android.app.Activity> r5 = android.app.Activity.class
            r6 = 0
            r4[r6] = r5     // Catch: java.lang.InstantiationException -> L45 java.lang.IllegalAccessException -> L4d java.lang.reflect.InvocationTargetException -> L55 java.lang.NoSuchMethodException -> L5d java.lang.ClassNotFoundException -> L65
            java.lang.Class r5 = java.lang.Integer.TYPE     // Catch: java.lang.InstantiationException -> L45 java.lang.IllegalAccessException -> L4d java.lang.reflect.InvocationTargetException -> L55 java.lang.NoSuchMethodException -> L5d java.lang.ClassNotFoundException -> L65
            r4[r2] = r5     // Catch: java.lang.InstantiationException -> L45 java.lang.IllegalAccessException -> L4d java.lang.reflect.InvocationTargetException -> L55 java.lang.NoSuchMethodException -> L5d java.lang.ClassNotFoundException -> L65
            java.lang.Class<com.huawei.uikit.hwdatepicker.widget.HwDatePickerDialog$OnButtonClickCallback> r5 = com.huawei.uikit.hwdatepicker.widget.HwDatePickerDialog.OnButtonClickCallback.class
            r7 = 2
            r4[r7] = r5     // Catch: java.lang.InstantiationException -> L45 java.lang.IllegalAccessException -> L4d java.lang.reflect.InvocationTargetException -> L55 java.lang.NoSuchMethodException -> L5d java.lang.ClassNotFoundException -> L65
            java.lang.Class<java.util.GregorianCalendar> r5 = java.util.GregorianCalendar.class
            r8 = 3
            r4[r8] = r5     // Catch: java.lang.InstantiationException -> L45 java.lang.IllegalAccessException -> L4d java.lang.reflect.InvocationTargetException -> L55 java.lang.NoSuchMethodException -> L5d java.lang.ClassNotFoundException -> L65
            java.lang.reflect.Constructor r1 = r1.getDeclaredConstructor(r4)     // Catch: java.lang.InstantiationException -> L45 java.lang.IllegalAccessException -> L4d java.lang.reflect.InvocationTargetException -> L55 java.lang.NoSuchMethodException -> L5d java.lang.ClassNotFoundException -> L65
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.InstantiationException -> L45 java.lang.IllegalAccessException -> L4d java.lang.reflect.InvocationTargetException -> L55 java.lang.NoSuchMethodException -> L5d java.lang.ClassNotFoundException -> L65
            r3[r6] = r9     // Catch: java.lang.InstantiationException -> L45 java.lang.IllegalAccessException -> L4d java.lang.reflect.InvocationTargetException -> L55 java.lang.NoSuchMethodException -> L5d java.lang.ClassNotFoundException -> L65
            java.lang.Integer r9 = java.lang.Integer.valueOf(r10)     // Catch: java.lang.InstantiationException -> L45 java.lang.IllegalAccessException -> L4d java.lang.reflect.InvocationTargetException -> L55 java.lang.NoSuchMethodException -> L5d java.lang.ClassNotFoundException -> L65
            r3[r2] = r9     // Catch: java.lang.InstantiationException -> L45 java.lang.IllegalAccessException -> L4d java.lang.reflect.InvocationTargetException -> L55 java.lang.NoSuchMethodException -> L5d java.lang.ClassNotFoundException -> L65
            r3[r7] = r11     // Catch: java.lang.InstantiationException -> L45 java.lang.IllegalAccessException -> L4d java.lang.reflect.InvocationTargetException -> L55 java.lang.NoSuchMethodException -> L5d java.lang.ClassNotFoundException -> L65
            r3[r8] = r12     // Catch: java.lang.InstantiationException -> L45 java.lang.IllegalAccessException -> L4d java.lang.reflect.InvocationTargetException -> L55 java.lang.NoSuchMethodException -> L5d java.lang.ClassNotFoundException -> L65
            java.lang.Object r9 = r1.newInstance(r3)     // Catch: java.lang.InstantiationException -> L45 java.lang.IllegalAccessException -> L4d java.lang.reflect.InvocationTargetException -> L55 java.lang.NoSuchMethodException -> L5d java.lang.ClassNotFoundException -> L65
            goto L6d
        L45:
            java.lang.String r9 = com.huawei.uikit.hwdatepicker.widget.HwDatePickerDialog.f42240p
            java.lang.String r10 = "calling constructor caused an InstantiationException"
            android.util.Log.w(r9, r10)
            goto L6c
        L4d:
            java.lang.String r9 = com.huawei.uikit.hwdatepicker.widget.HwDatePickerDialog.f42240p
            java.lang.String r10 = "calling constructor caused an IllegalAccessException"
            android.util.Log.w(r9, r10)
            goto L6c
        L55:
            java.lang.String r9 = com.huawei.uikit.hwdatepicker.widget.HwDatePickerDialog.f42240p
            java.lang.String r10 = "calling constructor caused an InvocationTargetException"
            android.util.Log.w(r9, r10)
            goto L6c
        L5d:
            java.lang.String r9 = com.huawei.uikit.hwdatepicker.widget.HwDatePickerDialog.f42240p
            java.lang.String r10 = "could not find constructor"
            android.util.Log.w(r9, r10)
            goto L6c
        L65:
            java.lang.String r9 = com.huawei.uikit.hwdatepicker.widget.HwDatePickerDialog.f42240p
            java.lang.String r10 = "make sure class name exists, public, has an empty constructor that is public"
            android.util.Log.w(r9, r10)
        L6c:
            r9 = r0
        L6d:
            boolean r10 = r9 instanceof com.huawei.uikit.hwdatepicker.widget.HwDatePickerDialog
            if (r10 == 0) goto L74
            com.huawei.uikit.hwdatepicker.widget.HwDatePickerDialog r9 = (com.huawei.uikit.hwdatepicker.widget.HwDatePickerDialog) r9
            return r9
        L74:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.uikit.hwdatepicker.widget.HwDatePickerDialog.instantiate(android.app.Activity, int, com.huawei.uikit.hwdatepicker.widget.HwDatePickerDialog$OnButtonClickCallback, java.util.GregorianCalendar):com.huawei.uikit.hwdatepicker.widget.HwDatePickerDialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public boolean m54339j() {
        if (Float.compare(AuxiliaryHelper.getFontSize(this.mThemeContext), 1.75f) < 0) {
            return true;
        }
        return this.mThemeContext.getResources().getString(C8710R.string.dialog_button_done_new).contentEquals(this.f42259i.getText());
    }

    /* renamed from: k */
    private void m54340k() {
        if (!AuxiliaryHelper.isAuxiliaryDevice(this.mThemeContext)) {
            Log.i(f42240p, "limitButtonLayout: !AuxiliaryHelper.isAuxiliaryDevice(mThemeContext)");
            return;
        }
        if (Float.compare(AuxiliaryHelper.getFontSize(this.mThemeContext), 1.75f) >= 0 && !AuxiliaryHelper.isMultiWindowActivity(this.mThemeContext)) {
            this.f42259i.setMaxLines(2);
            this.f42260j.setMaxLines(2);
            this.f42259i.setAutoTextInfo(13, 16, 2);
            this.f42260j.setAutoTextInfo(13, 16, 2);
            m54320b(this.f42259i);
            m54320b(this.f42260j);
            if ((f42239H != 2 || HwDeviceUtils.isWideScreenPhone(this.f42258h) || HwDeviceUtils.isTablet()) && Float.compare(AuxiliaryHelper.getFontSize(this.mThemeContext), 2.0f) >= 0) {
                this.f42256f.setOrientation(1);
                this.f42265o.findViewById(C8710R.id.hwdatepicker_dialog_split_line).setVisibility(8);
                this.f42256f.removeView(this.f42260j);
                this.f42256f.addView(this.f42260j);
                m54314a(this.f42259i);
                m54314a(this.f42260j);
                if (this.f42256f.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f42256f.getLayoutParams();
                    layoutParams.weight = 0.0f;
                    layoutParams.height = -2;
                    layoutParams.width = -1;
                    this.f42256f.setLayoutParams(layoutParams);
                }
            }
        }
    }

    /* renamed from: b */
    private void m54320b(View view) {
        if (view.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
            layoutParams.topMargin = (int) TypedValue.applyDimension(1, 8.0f, this.mThemeContext.getResources().getDisplayMetrics());
            layoutParams.bottomMargin = (int) TypedValue.applyDimension(1, 8.0f, this.mThemeContext.getResources().getDisplayMetrics());
            view.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: a */
    private void m54314a(View view) {
        if (view.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
            layoutParams.weight = 0.0f;
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
            layoutParams.topMargin = (int) TypedValue.applyDimension(1, 8.0f, this.mThemeContext.getResources().getDisplayMetrics());
            layoutParams.bottomMargin = 0;
            if (view == this.f42256f.getChildAt(2)) {
                layoutParams.bottomMargin = (int) TypedValue.applyDimension(1, 8.0f, this.mThemeContext.getResources().getDisplayMetrics());
            }
            layoutParams.height = -2;
            layoutParams.width = -1;
            view.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: b */
    private void m54319b() {
        if (Float.compare(AuxiliaryHelper.getFontSize(this.mThemeContext), 1.75f) >= 0 && AuxiliaryHelper.isAuxiliaryDevice(this.mThemeContext) && !AuxiliaryHelper.isMultiWindowActivity(this.mThemeContext)) {
            this.f42259i.setText(C8710R.string.dialog_button_next_step);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m54321b(WindowManager.LayoutParams layoutParams, DisplayMetrics displayMetrics) {
        Activity activity = this.f42258h;
        if (activity == null || layoutParams == null || displayMetrics == null) {
            return;
        }
        layoutParams.width = Math.min((int) activity.getResources().getDimension(C8710R.dimen.hwdatepicker_alert_dialog_width_in_tablet), displayMetrics.widthPixels);
    }

    /* renamed from: a */
    private int m54311a(Activity activity) {
        return HwLanguageUtils.isChineseLanguageAndRegion(activity) ? 65558 : 98326;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m54315a(WindowManager.LayoutParams layoutParams, DisplayMetrics displayMetrics) {
        if (layoutParams == null || displayMetrics == null) {
            return;
        }
        layoutParams.width = displayMetrics.widthPixels;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m54318a(boolean z10, WindowManager.LayoutParams layoutParams, DisplayMetrics displayMetrics) {
        if (layoutParams == null || displayMetrics == null) {
            return;
        }
        if (z10) {
            layoutParams.width = (int) (displayMetrics.widthPixels * f42235D);
        } else {
            layoutParams.width = displayMetrics.widthPixels;
        }
    }

    /* renamed from: a */
    private String m54313a(int i10, int i11, GregorianCalendar gregorianCalendar) {
        HwDatePicker hwDatePicker = this.f42251a;
        if (hwDatePicker == null) {
            return "";
        }
        if (!this.f42261k) {
            if (hwDatePicker.isSelectYear()) {
                if (!this.f42251a.isShowAllYears() && !this.f42251a.isWestern()) {
                    String displayedString = this.f42251a.getDisplayedString();
                    String[] strArr = HwDatePickerUtils.WEEK_DAYS;
                    int i12 = gregorianCalendar.get(7) - 1;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(displayedString);
                    if (i12 < 0) {
                        i12 = 0;
                    }
                    sb2.append(strArr[i12]);
                    return sb2.toString();
                }
                return DateUtils.formatDateTime(this.f42258h, gregorianCalendar.getTimeInMillis(), m54311a(this.f42258h));
            }
            if (this.f42251a.isWestern()) {
                String[] shortMonths = this.f42251a.getShortMonths();
                String[] shortMonthDays = this.f42251a.getShortMonthDays();
                return shortMonths[i10 % shortMonths.length] + shortMonthDays[(i11 - 1) % shortMonthDays.length];
            }
            String[] strArr2 = HwLunarUtils.LUNAR_MONTH;
            String[] strArr3 = HwLunarUtils.LUNAR_DAY;
            return strArr2[(i10 - 1) % strArr2.length] + strArr3[(i11 - 1) % strArr3.length];
        }
        return this.f42262l;
    }
}
