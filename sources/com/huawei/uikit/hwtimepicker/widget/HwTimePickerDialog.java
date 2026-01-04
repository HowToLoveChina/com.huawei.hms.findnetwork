package com.huawei.uikit.hwtimepicker.widget;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Outline;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwDeviceUtils;
import com.huawei.uikit.hwresources.utils.AuxiliaryHelper;
import com.huawei.uikit.hwresources.utils.HwWidgetInstantiator;
import com.huawei.uikit.hwtextview.widget.HwTextView;
import com.huawei.uikit.hwtimepicker.C8741R;
import com.huawei.uikit.hwtimepicker.utils.HwTimePickerUtils;
import com.huawei.uikit.hwtimepicker.widget.HwTimePicker;
import java.util.GregorianCalendar;

/* loaded from: classes5.dex */
public class HwTimePickerDialog extends AlertDialog implements HwTimePicker.OnTimeChangedListener {

    /* renamed from: A */
    private static final float f44481A = 32.0f;

    /* renamed from: B */
    private static final float f44482B = 40.0f;

    /* renamed from: C */
    private static final float f44483C = 35.0f;

    /* renamed from: D */
    private static int f44484D = 0;

    /* renamed from: n */
    private static final String f44485n = "HwTimePickerDialog";

    /* renamed from: o */
    private static final int f44486o = 5;

    /* renamed from: p */
    private static final String f44487p = "year";

    /* renamed from: q */
    private static final String f44488q = "month";

    /* renamed from: r */
    private static final String f44489r = "day";

    /* renamed from: s */
    private static final String f44490s = "hour";

    /* renamed from: t */
    private static final String f44491t = "minute";

    /* renamed from: u */
    private static final int f44492u = 8;

    /* renamed from: v */
    private static final int f44493v = 2;

    /* renamed from: w */
    private static final int f44494w = 2;

    /* renamed from: x */
    private static final int f44495x = 13;

    /* renamed from: y */
    private static final int f44496y = 16;

    /* renamed from: z */
    private static final double f44497z = 0.65d;

    /* renamed from: a */
    private OnButtonClickCallback f44498a;

    /* renamed from: b */
    private Context f44499b;

    /* renamed from: c */
    private Activity f44500c;

    /* renamed from: d */
    private HwTextView f44501d;

    /* renamed from: e */
    private LinearLayout f44502e;

    /* renamed from: f */
    private LinearLayout f44503f;

    /* renamed from: g */
    private LinearLayout f44504g;

    /* renamed from: h */
    private LinearLayout f44505h;

    /* renamed from: i */
    private HwTimePicker f44506i;

    /* renamed from: j */
    private HwTextView f44507j;

    /* renamed from: k */
    private HwTextView f44508k;

    /* renamed from: l */
    private String f44509l;

    /* renamed from: m */
    private View f44510m;

    public interface OnButtonClickCallback {
        void onNegativeButtonClick(HwTimePicker hwTimePicker);

        void onPositiveButtonClick(HwTimePicker hwTimePicker);
    }

    public class aauaf implements View.OnLayoutChangeListener {

        /* renamed from: a */
        final /* synthetic */ Window f44511a;

        public aauaf(Window window) {
            this.f44511a = window;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            int unused = HwTimePickerDialog.f44484D = HwTimePickerDialog.this.f44499b.getResources().getConfiguration().orientation;
            DisplayMetrics displayMetrics = HwTimePickerDialog.this.f44499b.getResources().getDisplayMetrics();
            WindowManager.LayoutParams attributes = this.f44511a.getAttributes();
            if (HwDeviceUtils.isTablet() || HwDeviceUtils.isWideScreenPhone(HwTimePickerDialog.this.f44500c) || HwDeviceUtils.isTripleFoldDevice()) {
                HwTimePickerDialog.this.m55718a(attributes, displayMetrics);
            } else if (HwTimePickerUtils.isMultiWindowActivity(HwTimePickerDialog.this.f44500c)) {
                HwTimePickerDialog.this.m55726b(attributes, displayMetrics);
            } else if (HwTimePickerDialog.f44484D == 2) {
                HwTimePickerDialog.this.m55722a(true, attributes, displayMetrics);
            } else {
                HwTimePickerDialog.this.m55722a(false, attributes, displayMetrics);
            }
            this.f44511a.setAttributes(attributes);
        }
    }

    public class akxao implements View.OnClickListener {
        public akxao() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (HwTimePickerDialog.this.m55742j()) {
                HwTimePickerDialog.this.m55732e();
                return;
            }
            HwTimePickerDialog.this.f44506i.m55709k();
            HwTimePickerDialog.this.f44507j.setText(C8741R.string.dialog_button_next_step);
            HwTimePickerDialog.this.f44508k.setText(C8741R.string.discard_label);
            HwTimePickerDialog.this.m55731d();
        }
    }

    public class bqmxo implements View.OnClickListener {
        public bqmxo() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (HwTimePickerDialog.this.m55745k()) {
                HwTimePickerDialog.this.m55734f();
                return;
            }
            HwTimePickerDialog.this.f44506i.m55708j();
            HwTimePickerDialog.this.f44507j.setText(C8741R.string.dialog_button_done_new);
            HwTimePickerDialog.this.f44508k.setText(C8741R.string.dialog_button_last_step);
            HwTimePickerDialog.this.m55729c();
        }
    }

    public class bzrwd implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f44515a;

        /* renamed from: b */
        final /* synthetic */ TypedValue f44516b;

        /* renamed from: com.huawei.uikit.hwtimepicker.widget.HwTimePickerDialog$bzrwd$bzrwd, reason: collision with other inner class name */
        public class C14501bzrwd extends ViewOutlineProvider {
            public C14501bzrwd() {
            }

            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), bzrwd.this.f44515a);
                HwTimePickerDialog.this.f44499b.getTheme().resolveAttribute(C8741R.attr.hwBackgroundColor, bzrwd.this.f44516b, true);
                HwTimePickerDialog.this.f44510m.setBackgroundColor(bzrwd.this.f44516b.data);
            }
        }

        public bzrwd(int i10, TypedValue typedValue) {
            this.f44515a = i10;
            this.f44516b = typedValue;
        }

        @Override // java.lang.Runnable
        public void run() {
            HwTimePickerDialog.this.f44510m.setOutlineProvider(new C14501bzrwd());
            HwTimePickerDialog.this.f44510m.setClipToOutline(true);
        }
    }

    public HwTimePickerDialog(Activity activity, OnButtonClickCallback onButtonClickCallback) {
        this(activity, C8741R.style.Theme_Emui_HwTimePickerDialog, onButtonClickCallback);
    }

    public static HwTimePickerDialog instantiate(Activity activity, OnButtonClickCallback onButtonClickCallback) {
        return instantiate(activity, C8741R.style.Theme_Emui_HwTimePickerDialog, onButtonClickCallback);
    }

    /* renamed from: m */
    private void m55748m() {
        m55749n();
        this.f44506i.m55709k();
        this.f44506i.m55707i();
    }

    /* renamed from: n */
    private void m55749n() {
        if (HwWidgetInstantiator.getCurrentType(this.f44499b) == 1 && Float.compare(AuxiliaryHelper.getFontSize(this.f44499b), 1.75f) >= 0 && !AuxiliaryHelper.isMultiWindowActivity(this.f44499b)) {
            this.f44501d.setMaxLines(2);
            this.f44501d.setAutoTextSize(1, f44483C);
            if (Float.compare(AuxiliaryHelper.getFontSize(this.f44499b), 2.0f) >= 0) {
                this.f44501d.setAutoTextSize(1, f44482B);
            }
        }
    }

    public HwTimePicker getTimePicker() {
        return this.f44506i;
    }

    @Override // android.app.Dialog
    public void onRestoreInstanceState(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        super.onRestoreInstanceState(bundle);
        try {
            int i10 = bundle.getInt(f44490s);
            int i11 = bundle.getInt(f44491t);
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.set(11, i10);
            gregorianCalendar.set(12, i11);
            HwTimePicker hwTimePicker = this.f44506i;
            if (hwTimePicker != null) {
                hwTimePicker.init(gregorianCalendar, this);
            }
        } catch (BadParcelableException unused) {
            Log.e(f44485n, "onRestoreInstanceState: Bad parcel target.");
        }
    }

    @Override // android.app.Dialog
    public Bundle onSaveInstanceState() {
        Bundle bundleOnSaveInstanceState = super.onSaveInstanceState();
        HwTimePicker hwTimePicker = this.f44506i;
        int hour = hwTimePicker == null ? 1 : hwTimePicker.getHour();
        HwTimePicker hwTimePicker2 = this.f44506i;
        int minute = hwTimePicker2 != null ? hwTimePicker2.getMinute() : 1;
        try {
            bundleOnSaveInstanceState.putInt(f44490s, hour);
            bundleOnSaveInstanceState.putInt(f44491t, minute);
        } catch (BadParcelableException unused) {
            Log.e(f44485n, "onSaveInstanceState: Bad parcel target.");
        }
        return bundleOnSaveInstanceState;
    }

    @Override // android.app.Dialog
    public void onStart() {
        resizeTimePickerDialogWidth();
    }

    @Override // android.app.Dialog
    public void onStop() {
    }

    @Override // com.huawei.uikit.hwtimepicker.widget.HwTimePicker.OnTimeChangedListener
    public void onTimeChanged(HwTimePicker hwTimePicker, GregorianCalendar gregorianCalendar, String str) {
        if (hwTimePicker != null && gregorianCalendar != null) {
            hwTimePicker.init(gregorianCalendar, this);
        }
        if (str != null) {
            m55721a(str);
        }
    }

    public void refreshDialog() {
        m55738h();
    }

    public void resizeTimePickerDialogWidth() {
        Window window = getWindow();
        if (window == null || this.f44500c == null) {
            return;
        }
        window.getDecorView().addOnLayoutChangeListener(new aauaf(window));
    }

    public void setButtonColor(int i10) {
        HwTextView hwTextView = this.f44507j;
        if (hwTextView != null) {
            hwTextView.setTextColor(i10);
        }
        HwTextView hwTextView2 = this.f44508k;
        if (hwTextView2 != null) {
            hwTextView2.setTextColor(i10);
        }
    }

    public void setDaylightHourEnabled(boolean z10) {
        HwTimePicker hwTimePicker = this.f44506i;
        if (hwTimePicker != null) {
            hwTimePicker.setDaylightHourEnabled(z10);
            this.f44506i.invalidatePicker();
        }
    }

    public void setIsMinuteIntervalFiveMinute(boolean z10) {
        HwTimePicker hwTimePicker = this.f44506i;
        if (hwTimePicker != null) {
            hwTimePicker.setIsMinuteIntervalFiveMinute(z10);
        }
    }

    public void setSpinnersSelectorPaintColor(int i10) {
        HwTimePicker hwTimePicker = this.f44506i;
        if (hwTimePicker != null) {
            hwTimePicker.setSpinnersSelectorPaintColor(i10);
        }
    }

    public void setSpinnersUnselectedPaintColor(int i10) {
        HwTimePicker hwTimePicker = this.f44506i;
        if (hwTimePicker != null) {
            hwTimePicker.setSpinnersUnselectedPaintColor(i10);
        }
    }

    public void setTitle(String str) {
        this.f44509l = str;
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        View view = this.f44510m;
        if (view != null) {
            setContentView(view);
            m55721a(this.f44509l);
            m55738h();
        }
    }

    public void updateDate(int i10, int i11, int i12, int i13, int i14) {
        HwTimePicker hwTimePicker = this.f44506i;
        if (hwTimePicker != null) {
            hwTimePicker.updateDate(i10, i11, i12, i13, i14);
        }
    }

    public HwTimePickerDialog(Activity activity, int i10, OnButtonClickCallback onButtonClickCallback) throws Resources.NotFoundException {
        super(activity, i10);
        this.f44509l = "设置时间";
        this.f44498a = onButtonClickCallback;
        Context context = getContext();
        this.f44499b = context;
        this.f44500c = activity;
        f44484D = context.getResources().getConfiguration().orientation;
        m55741i();
        if (this.f44510m != null) {
            TypedValue typedValue = new TypedValue();
            this.f44510m.post(new bzrwd(getContext().getResources().getDimensionPixelSize(C8741R.dimen.emui_corner_radius_dialog), typedValue));
            m55736g();
            setIcon(0);
            m55721a(this.f44509l);
            this.f44506i.init(new GregorianCalendar(), this);
            m55748m();
            m55747l();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m55729c() {
        if (Float.compare(AuxiliaryHelper.getFontSize(this.f44499b), 2.0f) < 0) {
            return;
        }
        if (f44484D != 2 || HwDeviceUtils.isWideScreenPhone(this.f44500c) || HwDeviceUtils.isTablet()) {
            this.f44504g.removeView(this.f44507j);
            this.f44504g.addView(this.f44507j);
            m55717a(this.f44507j);
            m55717a(this.f44508k);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m55731d() {
        if (Float.compare(AuxiliaryHelper.getFontSize(this.f44499b), 2.0f) < 0) {
            return;
        }
        if (f44484D != 2 || HwDeviceUtils.isWideScreenPhone(this.f44500c) || HwDeviceUtils.isTablet()) {
            this.f44504g.removeView(this.f44508k);
            this.f44504g.addView(this.f44508k);
            m55717a(this.f44507j);
            m55717a(this.f44508k);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m55732e() {
        dismiss();
        HwTimePicker hwTimePicker = this.f44506i;
        if (hwTimePicker == null || this.f44498a == null) {
            return;
        }
        hwTimePicker.clearFocus();
        this.f44498a.onNegativeButtonClick(this.f44506i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m55734f() {
        dismiss();
        HwTimePicker hwTimePicker = this.f44506i;
        if (hwTimePicker == null || this.f44498a == null) {
            return;
        }
        hwTimePicker.clearFocus();
        this.f44498a.onPositiveButtonClick(this.f44506i);
    }

    /* renamed from: g */
    private void m55736g() {
        m55724b();
        this.f44507j.setOnClickListener(new bqmxo());
        this.f44508k.setOnClickListener(new akxao());
    }

    /* renamed from: h */
    private void m55738h() {
        Window window = getWindow();
        if (window == null || this.f44499b == null) {
            return;
        }
        window.setWindowAnimations(C8741R.style.Animation_Emui_HwTimePickerDialog);
        f44484D = this.f44499b.getResources().getConfiguration().orientation;
        if (this.f44500c == null) {
            return;
        }
        DisplayMetrics displayMetrics = this.f44499b.getResources().getDisplayMetrics();
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (HwDeviceUtils.isTablet() || HwDeviceUtils.isWideScreenPhone(this.f44500c) || HwDeviceUtils.isTripleFoldDevice()) {
            window.setGravity(17);
            m55718a(attributes, displayMetrics);
        } else if (HwTimePickerUtils.isMultiWindowActivity(this.f44500c)) {
            window.setGravity(17);
            m55726b(attributes, displayMetrics);
        } else if (f44484D == 2) {
            window.setGravity(17);
            m55722a(true, attributes, displayMetrics);
        } else {
            window.setGravity(80);
            m55722a(false, attributes, displayMetrics);
        }
        window.setAttributes(attributes);
        HwTimePicker hwTimePicker = this.f44506i;
        if (hwTimePicker != null) {
            hwTimePicker.handleConfigrationChange();
        }
    }

    /* renamed from: i */
    private void m55741i() {
        View viewInflate = View.inflate(this.f44499b, C8741R.layout.hwtimepicker_dialog, null);
        this.f44510m = viewInflate;
        this.f44503f = (LinearLayout) viewInflate.findViewById(C8741R.id.hwtimepicker_title_layout);
        this.f44505h = (LinearLayout) this.f44510m.findViewById(C8741R.id.hwtimepicker_dialog_content_layout);
        this.f44504g = (LinearLayout) this.f44510m.findViewById(C8741R.id.hwtimepicker_button_layout);
        this.f44501d = (HwTextView) this.f44510m.findViewById(C8741R.id.hwtimepicker_title);
        this.f44506i = (HwTimePicker) this.f44510m.findViewById(C8741R.id.hwtimepicker);
        this.f44507j = (HwTextView) this.f44510m.findViewById(C8741R.id.hwtimepicker_positive_btn);
        this.f44508k = (HwTextView) this.f44510m.findViewById(C8741R.id.hwtimepicker_negative_btn);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006d A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.huawei.uikit.hwtimepicker.widget.HwTimePickerDialog instantiate(android.app.Activity r8, int r9, com.huawei.uikit.hwtimepicker.widget.HwTimePickerDialog.OnButtonClickCallback r10) throws java.lang.IllegalAccessException, java.lang.InstantiationException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            r0 = 0
            if (r8 != 0) goto L4
            return r0
        L4:
            r1 = 5
            r2 = 1
            int r1 = com.huawei.uikit.hwresources.utils.HwWidgetInstantiator.getCurrentType(r8, r1, r2)
            java.lang.Class<com.huawei.uikit.hwtimepicker.widget.HwTimePickerDialog> r3 = com.huawei.uikit.hwtimepicker.widget.HwTimePickerDialog.class
            java.lang.String r1 = com.huawei.uikit.hwresources.utils.HwWidgetInstantiator.getDeviceClassName(r8, r3, r1)
            java.lang.ClassLoader r3 = r8.getClassLoader()     // Catch: java.lang.InstantiationException -> L3e java.lang.IllegalAccessException -> L46 java.lang.reflect.InvocationTargetException -> L4e java.lang.NoSuchMethodException -> L56 java.lang.ClassNotFoundException -> L5e
            java.lang.Class r1 = r3.loadClass(r1)     // Catch: java.lang.InstantiationException -> L3e java.lang.IllegalAccessException -> L46 java.lang.reflect.InvocationTargetException -> L4e java.lang.NoSuchMethodException -> L56 java.lang.ClassNotFoundException -> L5e
            r3 = 3
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch: java.lang.InstantiationException -> L3e java.lang.IllegalAccessException -> L46 java.lang.reflect.InvocationTargetException -> L4e java.lang.NoSuchMethodException -> L56 java.lang.ClassNotFoundException -> L5e
            java.lang.Class<android.app.Activity> r5 = android.app.Activity.class
            r6 = 0
            r4[r6] = r5     // Catch: java.lang.InstantiationException -> L3e java.lang.IllegalAccessException -> L46 java.lang.reflect.InvocationTargetException -> L4e java.lang.NoSuchMethodException -> L56 java.lang.ClassNotFoundException -> L5e
            java.lang.Class r5 = java.lang.Integer.TYPE     // Catch: java.lang.InstantiationException -> L3e java.lang.IllegalAccessException -> L46 java.lang.reflect.InvocationTargetException -> L4e java.lang.NoSuchMethodException -> L56 java.lang.ClassNotFoundException -> L5e
            r4[r2] = r5     // Catch: java.lang.InstantiationException -> L3e java.lang.IllegalAccessException -> L46 java.lang.reflect.InvocationTargetException -> L4e java.lang.NoSuchMethodException -> L56 java.lang.ClassNotFoundException -> L5e
            java.lang.Class<com.huawei.uikit.hwtimepicker.widget.HwTimePickerDialog$OnButtonClickCallback> r5 = com.huawei.uikit.hwtimepicker.widget.HwTimePickerDialog.OnButtonClickCallback.class
            r7 = 2
            r4[r7] = r5     // Catch: java.lang.InstantiationException -> L3e java.lang.IllegalAccessException -> L46 java.lang.reflect.InvocationTargetException -> L4e java.lang.NoSuchMethodException -> L56 java.lang.ClassNotFoundException -> L5e
            java.lang.reflect.Constructor r1 = r1.getDeclaredConstructor(r4)     // Catch: java.lang.InstantiationException -> L3e java.lang.IllegalAccessException -> L46 java.lang.reflect.InvocationTargetException -> L4e java.lang.NoSuchMethodException -> L56 java.lang.ClassNotFoundException -> L5e
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.InstantiationException -> L3e java.lang.IllegalAccessException -> L46 java.lang.reflect.InvocationTargetException -> L4e java.lang.NoSuchMethodException -> L56 java.lang.ClassNotFoundException -> L5e
            r3[r6] = r8     // Catch: java.lang.InstantiationException -> L3e java.lang.IllegalAccessException -> L46 java.lang.reflect.InvocationTargetException -> L4e java.lang.NoSuchMethodException -> L56 java.lang.ClassNotFoundException -> L5e
            java.lang.Integer r8 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.InstantiationException -> L3e java.lang.IllegalAccessException -> L46 java.lang.reflect.InvocationTargetException -> L4e java.lang.NoSuchMethodException -> L56 java.lang.ClassNotFoundException -> L5e
            r3[r2] = r8     // Catch: java.lang.InstantiationException -> L3e java.lang.IllegalAccessException -> L46 java.lang.reflect.InvocationTargetException -> L4e java.lang.NoSuchMethodException -> L56 java.lang.ClassNotFoundException -> L5e
            r3[r7] = r10     // Catch: java.lang.InstantiationException -> L3e java.lang.IllegalAccessException -> L46 java.lang.reflect.InvocationTargetException -> L4e java.lang.NoSuchMethodException -> L56 java.lang.ClassNotFoundException -> L5e
            java.lang.Object r8 = r1.newInstance(r3)     // Catch: java.lang.InstantiationException -> L3e java.lang.IllegalAccessException -> L46 java.lang.reflect.InvocationTargetException -> L4e java.lang.NoSuchMethodException -> L56 java.lang.ClassNotFoundException -> L5e
            goto L66
        L3e:
            java.lang.String r8 = com.huawei.uikit.hwtimepicker.widget.HwTimePickerDialog.f44485n
            java.lang.String r9 = "calling constructor caused an InstantiationException"
            android.util.Log.w(r8, r9)
            goto L65
        L46:
            java.lang.String r8 = com.huawei.uikit.hwtimepicker.widget.HwTimePickerDialog.f44485n
            java.lang.String r9 = "calling constructor caused an IllegalAccessException"
            android.util.Log.w(r8, r9)
            goto L65
        L4e:
            java.lang.String r8 = com.huawei.uikit.hwtimepicker.widget.HwTimePickerDialog.f44485n
            java.lang.String r9 = "calling constructor caused an InvocationTargetException"
            android.util.Log.w(r8, r9)
            goto L65
        L56:
            java.lang.String r8 = com.huawei.uikit.hwtimepicker.widget.HwTimePickerDialog.f44485n
            java.lang.String r9 = "could not find constructor"
            android.util.Log.w(r8, r9)
            goto L65
        L5e:
            java.lang.String r8 = com.huawei.uikit.hwtimepicker.widget.HwTimePickerDialog.f44485n
            java.lang.String r9 = "make sure class name exists, public, has an empty constructor that is public"
            android.util.Log.w(r8, r9)
        L65:
            r8 = r0
        L66:
            boolean r9 = r8 instanceof com.huawei.uikit.hwtimepicker.widget.HwTimePickerDialog
            if (r9 == 0) goto L6d
            com.huawei.uikit.hwtimepicker.widget.HwTimePickerDialog r8 = (com.huawei.uikit.hwtimepicker.widget.HwTimePickerDialog) r8
            return r8
        L6d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.uikit.hwtimepicker.widget.HwTimePickerDialog.instantiate(android.app.Activity, int, com.huawei.uikit.hwtimepicker.widget.HwTimePickerDialog$OnButtonClickCallback):com.huawei.uikit.hwtimepicker.widget.HwTimePickerDialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public boolean m55742j() {
        if (Float.compare(AuxiliaryHelper.getFontSize(this.f44499b), 1.75f) < 0) {
            return true;
        }
        return this.f44499b.getResources().getString(C8741R.string.discard_label).contentEquals(this.f44508k.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public boolean m55745k() {
        if (Float.compare(AuxiliaryHelper.getFontSize(this.f44499b), 1.75f) < 0) {
            return true;
        }
        return this.f44499b.getResources().getString(C8741R.string.dialog_button_done_new).contentEquals(this.f44507j.getText());
    }

    /* renamed from: l */
    private void m55747l() {
        if (AuxiliaryHelper.isAuxiliaryDevice(this.f44499b) && Float.compare(AuxiliaryHelper.getFontSize(this.f44499b), 1.75f) >= 0 && !AuxiliaryHelper.isMultiWindowActivity(this.f44499b)) {
            this.f44507j.setMaxLines(2);
            this.f44508k.setMaxLines(2);
            this.f44507j.setAutoTextInfo(13, 16, 2);
            this.f44508k.setAutoTextInfo(13, 16, 2);
            m55725b(this.f44507j);
            m55725b(this.f44508k);
            if ((f44484D != 2 || HwDeviceUtils.isWideScreenPhone(this.f44500c) || HwDeviceUtils.isTablet()) && Float.compare(AuxiliaryHelper.getFontSize(this.f44499b), 2.0f) >= 0) {
                this.f44504g.setOrientation(!DateFormat.is24HourFormat(this.f44499b) ? 1 : 0);
                this.f44510m.findViewById(C8741R.id.hwtimepicker_dialog_split_line).setVisibility(8);
                if (DateFormat.is24HourFormat(this.f44499b)) {
                    m55725b(this.f44507j);
                    m55725b(this.f44508k);
                } else {
                    this.f44504g.removeView(this.f44508k);
                    this.f44504g.addView(this.f44508k);
                    m55717a(this.f44507j);
                    m55717a(this.f44508k);
                }
                if (this.f44504g.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f44504g.getLayoutParams();
                    layoutParams.weight = 0.0f;
                    layoutParams.height = -2;
                    layoutParams.width = -1;
                    this.f44504g.setLayoutParams(layoutParams);
                }
            }
        }
    }

    /* renamed from: b */
    private void m55725b(View view) {
        if (view.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
            layoutParams.topMargin = (int) TypedValue.applyDimension(1, 8.0f, this.f44499b.getResources().getDisplayMetrics());
            layoutParams.bottomMargin = (int) TypedValue.applyDimension(1, 8.0f, this.f44499b.getResources().getDisplayMetrics());
            view.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: a */
    private void m55717a(View view) {
        if (view.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
            layoutParams.weight = 0.0f;
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
            layoutParams.topMargin = (int) TypedValue.applyDimension(1, 8.0f, this.f44499b.getResources().getDisplayMetrics());
            layoutParams.bottomMargin = 0;
            if (view == this.f44504g.getChildAt(2)) {
                layoutParams.bottomMargin = (int) TypedValue.applyDimension(1, 8.0f, this.f44499b.getResources().getDisplayMetrics());
            }
            layoutParams.height = -2;
            layoutParams.width = -1;
            view.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m55726b(WindowManager.LayoutParams layoutParams, DisplayMetrics displayMetrics) {
        if (layoutParams == null || displayMetrics == null) {
            return;
        }
        layoutParams.width = displayMetrics.widthPixels;
    }

    /* renamed from: b */
    private void m55724b() {
        if (AuxiliaryHelper.isAuxiliaryDevice(this.f44499b) && Float.compare(AuxiliaryHelper.getFontSize(this.f44499b), 1.75f) >= 0 && !AuxiliaryHelper.isMultiWindowActivity(this.f44499b) && !DateFormat.is24HourFormat(this.f44499b)) {
            this.f44507j.setText(C8741R.string.dialog_button_next_step);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m55718a(WindowManager.LayoutParams layoutParams, DisplayMetrics displayMetrics) {
        Activity activity = this.f44500c;
        if (activity == null || layoutParams == null || displayMetrics == null) {
            return;
        }
        layoutParams.width = Math.min((int) activity.getResources().getDimension(C8741R.dimen.hwtimepicker_alert_dialog_width_in_tablet), displayMetrics.widthPixels);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m55722a(boolean z10, WindowManager.LayoutParams layoutParams, DisplayMetrics displayMetrics) {
        if (layoutParams == null || displayMetrics == null) {
            return;
        }
        if (z10) {
            layoutParams.width = (int) (displayMetrics.widthPixels * f44497z);
        } else {
            layoutParams.width = displayMetrics.widthPixels;
        }
    }

    /* renamed from: a */
    private void m55721a(String str) {
        HwTextView hwTextView;
        if (str == null || (hwTextView = this.f44501d) == null) {
            return;
        }
        hwTextView.setText(str);
    }
}
