package com.huawei.uikit.hwprogressbutton.widget;

import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.core.content.ContextCompat;
import com.huawei.uikit.animations.animator.HwHoverAnimationUtils;
import com.huawei.uikit.animations.drawable.HwRoundRectEclipseClipDrawable;
import com.huawei.uikit.hwcommon.utils.HwReflectUtil;
import com.huawei.uikit.hwprogressbar.widget.HwProgressBar;
import com.huawei.uikit.hwprogressbutton.C8719R;
import com.huawei.uikit.hwresources.utils.AuxiliaryHelper;
import com.huawei.uikit.hwresources.utils.HwWidgetCompat;
import com.huawei.uikit.hwresources.utils.HwWidgetInstantiator;
import com.huawei.uikit.hwtextview.widget.HwTextView;
import java.lang.reflect.Method;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;
import p757x.C13669a;

/* loaded from: classes4.dex */
public class HwProgressButton extends FrameLayout {

    /* renamed from: A */
    private static final int f43162A = 0;

    /* renamed from: B */
    private static final int f43163B = 3;

    /* renamed from: C */
    private static final String f43164C = "hw_sc.platform.ux_level";

    /* renamed from: D */
    private static final String f43165D = "android.os.SystemProperties";

    /* renamed from: E */
    private static final int f43166E = reflectGetUxLevel();

    /* renamed from: F */
    private static final String f43167F = "getInt";

    /* renamed from: G */
    private static final int f43168G = 200;

    /* renamed from: H */
    private static final int f43169H = 200;

    /* renamed from: I */
    private static Method f43170I = null;
    public static final int STATE_IDLE = 0;
    public static final int STATE_PAUSE = 2;
    public static final int STATE_START = 1;

    /* renamed from: v */
    private static final float f43171v = 1.0f;

    /* renamed from: w */
    private static final float f43172w = 1.0f;

    /* renamed from: x */
    private static final float f43173x = 1.0f;

    /* renamed from: y */
    private static final String f43174y = "HwProgressButton";

    /* renamed from: z */
    private static final double f43175z = 100.0d;

    /* renamed from: a */
    private HwProgressBar f43176a;

    /* renamed from: b */
    private HwTextView f43177b;

    /* renamed from: c */
    private int f43178c;

    /* renamed from: d */
    private String f43179d;

    /* renamed from: e */
    private ColorStateList f43180e;

    /* renamed from: f */
    private Drawable f43181f;

    /* renamed from: g */
    private Drawable f43182g;

    /* renamed from: h */
    private ColorStateList f43183h;

    /* renamed from: i */
    private boolean f43184i;

    /* renamed from: j */
    private LayerDrawable f43185j;

    /* renamed from: k */
    private Locale f43186k;

    /* renamed from: l */
    private float f43187l;

    /* renamed from: m */
    private Drawable f43188m;

    /* renamed from: n */
    private float f43189n;

    /* renamed from: o */
    private float f43190o;

    /* renamed from: p */
    private int f43191p;

    /* renamed from: q */
    private float f43192q;

    /* renamed from: r */
    private float f43193r;

    /* renamed from: s */
    private ObjectAnimator f43194s;

    /* renamed from: t */
    private int f43195t;

    /* renamed from: u */
    private Context f43196u;

    public static class aauaf extends View.BaseSavedState {
        public static final Parcelable.Creator<aauaf> CREATOR = new bzrwd();

        /* renamed from: a */
        int f43197a;

        /* renamed from: b */
        int f43198b;

        public class bzrwd implements Parcelable.Creator<aauaf> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public aauaf createFromParcel(Parcel parcel) {
                return new aauaf(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public aauaf[] newArray(int i10) {
                return new aauaf[i10];
            }
        }

        public /* synthetic */ aauaf(Parcel parcel, bzrwd bzrwdVar) {
            this(parcel);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            if (parcel == null) {
                Log.w(HwProgressButton.f43174y, "writeToParcel, parcel is null");
                return;
            }
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f43197a);
            parcel.writeInt(this.f43198b);
        }

        public aauaf(Parcelable parcelable) {
            super(parcelable);
        }

        private aauaf(Parcel parcel) {
            super(parcel);
            this.f43197a = parcel.readInt();
            this.f43198b = parcel.readInt();
        }
    }

    public class bzrwd implements HwProgressBar.OnVisualProgressChangedListener {
        public bzrwd() {
        }

        @Override // com.huawei.uikit.hwprogressbar.widget.HwProgressBar.OnVisualProgressChangedListener
        public void onVisualProgressChanged(HwProgressBar hwProgressBar, float f10) {
            HwProgressButton.this.f43195t = (int) (f10 * HwProgressButton.f43175z);
            HwProgressButton hwProgressButton = HwProgressButton.this;
            hwProgressButton.setPercentage(hwProgressButton.f43195t);
        }
    }

    public HwProgressButton(Context context) {
        this(context, null);
    }

    /* renamed from: c */
    private void m54787c() throws NoSuchFieldException, SecurityException {
        Object object = HwReflectUtil.getObject(this.f43176a, "mVisualProgressUpdateAnimator", HwProgressBar.class);
        if (object instanceof ObjectAnimator) {
            this.f43194s = (ObjectAnimator) object;
        }
        int iFloatValue = HwReflectUtil.getObject(this.f43176a, "mVisualProgress", HwProgressBar.class) instanceof Float ? (int) (((Float) r0).floatValue() * f43175z) : 0;
        ObjectAnimator objectAnimator = this.f43194s;
        if (objectAnimator == null || !objectAnimator.isRunning()) {
            return;
        }
        this.f43194s.cancel();
        setPercentage(iFloatValue);
    }

    private int getCurSdkVersion() {
        return Build.VERSION.SDK_INT;
    }

    public static HwProgressButton instantiate(Context context) throws ClassNotFoundException {
        Object objInstantiate = HwWidgetInstantiator.instantiate(context, HwWidgetInstantiator.getDeviceClassName(context, HwProgressButton.class, HwWidgetInstantiator.getCurrentType(context, 3, 1)), HwProgressButton.class);
        if (objInstantiate instanceof HwProgressButton) {
            return (HwProgressButton) objInstantiate;
        }
        return null;
    }

    public static int reflectGetUxLevel() {
        if (f43170I == null) {
            f43170I = HwReflectUtil.getMethod(f43167F, new Class[]{String.class, Integer.TYPE}, f43165D);
        }
        Method method = f43170I;
        if (method == null) {
            return 200;
        }
        Object objInvokeMethod = HwReflectUtil.invokeMethod(null, method, new Object[]{f43164C, 200});
        if (objInvokeMethod instanceof Integer) {
            return ((Integer) objInvokeMethod).intValue();
        }
        return 200;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPercentage(int i10) {
        HwTextView hwTextView = this.f43177b;
        if (hwTextView == null) {
            Log.w(f43174y, "setPercentage, mPercentage is null");
            return;
        }
        if (this.f43178c == 2) {
            hwTextView.setText(this.f43179d);
            return;
        }
        if (this.f43194s != null) {
            i10 = this.f43195t;
        }
        m54779a();
        this.f43177b.setText(String.format(Locale.ROOT, "%2d", Integer.valueOf(i10)) + "%");
    }

    private void setPercentageTextColor(ColorStateList colorStateList) {
        HwTextView hwTextView = this.f43177b;
        if (hwTextView == null || colorStateList == null) {
            return;
        }
        hwTextView.setTextColor(colorStateList);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        m54783a(canvas);
    }

    public float getCornerRadius() {
        return this.f43192q;
    }

    public Drawable getFocusedDrawable() {
        return this.f43188m;
    }

    public int getFocusedPathColor() {
        return this.f43191p;
    }

    public float getFocusedPathPadding() {
        return this.f43190o;
    }

    public float getFocusedPathWidth() {
        return this.f43189n;
    }

    public HwTextView getPercentage() {
        return this.f43177b;
    }

    public int getProgress() {
        return this.f43176a.getProgress();
    }

    public ProgressBar getProgressBar() {
        return this.f43176a;
    }

    public Drawable getProgressBarBackgroundDrawable() {
        return this.f43182g;
    }

    public Drawable getProgressButtonBackgroundDrawable() {
        return this.f43181f;
    }

    public Drawable getProgressButtonDrawable(int i10) {
        Drawable drawable = ContextCompat.getDrawable(getContext(), i10);
        if (f43166E >= 200) {
            replaceClipDrawable(drawable);
        }
        return drawable;
    }

    public int getState() {
        return this.f43178c;
    }

    public void incrementProgressBy(int i10) {
        if (this.f43176a == null) {
            Log.w(f43174y, "incrementProgressBy, mProgressBar is null");
            return;
        }
        if (this.f43178c != 1) {
            setState(1);
            this.f43176a.setBackground(null);
            setIncrementProgressBackground();
            setPercentageTextColor(this.f43180e);
        }
        this.f43176a.incrementProgressBy(i10);
        setPercentage(this.f43176a.getProgress());
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m54779a();
    }

    public void onDrawFocusedDrawable(Canvas canvas) {
        Log.w(f43174y, "Do nothing.");
    }

    @Override // android.view.View
    public void onHoverChanged(boolean z10) {
        super.onHoverChanged(z10);
        if (this.f43187l == 1.0f) {
            return;
        }
        m54784a(z10);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), i11);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        HwProgressBar hwProgressBar;
        if (!(parcelable instanceof aauaf)) {
            Log.w(f43174y, "onRestoreInstanceState: state = " + parcelable);
            return;
        }
        aauaf aauafVar = (aauaf) parcelable;
        super.onRestoreInstanceState(aauafVar.getSuperState());
        setState(aauafVar.f43198b);
        if (this.f43178c != 0 && (hwProgressBar = this.f43176a) != null) {
            hwProgressBar.setProgressDrawable(getProgressButtonDrawable(C8719R.drawable.hwprogressbutton_progressbar_normal_layer));
            setProgress(aauafVar.f43197a);
            setPercentage(aauafVar.f43197a);
            setPercentageTextColor(this.f43180e);
            return;
        }
        Log.w(f43174y, "onRestoreInstanceState mState = " + this.f43178c + " , mProgressBar = " + this.f43176a);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        aauaf aauafVar = new aauaf(super.onSaveInstanceState());
        aauafVar.f43197a = this.f43176a.getProgress();
        aauafVar.f43198b = this.f43178c;
        return aauafVar;
    }

    public void replaceClipDrawable(Drawable drawable) {
        if (!AuxiliaryHelper.isAuxiliaryDevice(this.f43196u) || Float.compare(AuxiliaryHelper.getFontSize(this.f43196u), 1.75f) < 0) {
            if (!(drawable instanceof LayerDrawable)) {
                Log.e(f43174y, "drawable is not LayerDrawable");
                return;
            }
            Drawable drawableFindDrawableByLayerId = ((LayerDrawable) drawable).findDrawableByLayerId(R.id.progress);
            if (drawableFindDrawableByLayerId instanceof ClipDrawable) {
                HwRoundRectEclipseClipDrawable hwRoundRectEclipseClipDrawable = new HwRoundRectEclipseClipDrawable(drawableFindDrawableByLayerId, 0, 1);
                drawable.mutate();
                ((LayerDrawable) drawable).setDrawableByLayerId(R.id.progress, hwRoundRectEclipseClipDrawable);
            }
        }
    }

    public void resetUpdate() {
        this.f43176a.setBackground(null);
        if (this.f43184i) {
            if (this.f43185j == null) {
                m54780a(getContext());
            }
            this.f43176a.setProgressDrawable(this.f43185j);
        } else {
            Drawable drawable = this.f43181f;
            if (drawable == null || drawable.getConstantState() == null) {
                this.f43176a.setProgressDrawable(this.f43181f);
            } else {
                this.f43176a.setProgressDrawable(this.f43181f.getConstantState().newDrawable());
            }
        }
        setPercentageTextColor(this.f43183h);
        setState(0);
    }

    public void setCornerRadius(float f10) {
        this.f43192q = f10;
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        if (z10) {
            this.f43176a.setAlpha(1.0f);
            this.f43177b.setAlpha(1.0f);
        } else {
            this.f43176a.setAlpha(this.f43193r);
            this.f43177b.setAlpha(this.f43193r);
        }
    }

    public void setFocusedDrawable(Drawable drawable) {
        this.f43188m = drawable;
    }

    public void setFocusedPathColor(int i10) {
        this.f43191p = i10;
    }

    public void setFocusedPathPadding(float f10) {
        this.f43190o = f10;
    }

    public void setFocusedPathWidth(float f10) {
        this.f43189n = f10;
    }

    public void setHwProgressButtonTextColor(ColorStateList colorStateList) {
        Log.w(f43174y, "Do nothing.");
    }

    public void setIdleText(String str) {
        if (str == null) {
            Log.w(f43174y, "setIdleText, idleText is null");
            return;
        }
        if (this.f43178c == 0) {
            this.f43177b.setText(str);
            return;
        }
        Log.w(f43174y, "setIdleText, mState = " + this.f43178c);
    }

    public void setIncrementProgressBackground() {
        HwProgressBar hwProgressBar = this.f43176a;
        if (hwProgressBar == null) {
            Log.w(f43174y, "incrementProgressBy, mProgressBar is null");
        } else {
            hwProgressBar.setProgressDrawable(this.f43182g);
        }
    }

    public void setPauseText(String str) {
        if (str == null) {
            Log.w(f43174y, "setPauseText, pauseText is null");
        } else {
            this.f43179d = str;
        }
    }

    public void setProgress(int i10) {
        this.f43176a.setProgress(i10);
    }

    public void setProgressBarBackgroundDrawable(Drawable drawable) {
        this.f43182g = drawable;
        if (f43166E >= 200) {
            replaceClipDrawable(drawable);
        }
    }

    public void setProgressButtonBackgroundDrawable(Drawable drawable) {
        this.f43181f = drawable;
        HwProgressBar hwProgressBar = this.f43176a;
        if (hwProgressBar != null) {
            hwProgressBar.setProgressDrawable(drawable);
        }
    }

    public void setState(int i10) {
        if (this.f43178c == i10) {
            return;
        }
        if (i10 >= 0 && i10 <= 2) {
            this.f43178c = i10;
            return;
        }
        Log.w(f43174y, "setState: invalid state: " + i10);
    }

    public void stop() throws NoSuchFieldException, SecurityException {
        setState(2);
        setPercentage(this.f43176a.getProgress());
        m54787c();
    }

    public HwProgressButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C8719R.attr.hwProgressButtonStyle);
    }

    /* renamed from: b */
    private void m54785b() {
        if (isEnabled()) {
            return;
        }
        this.f43176a.setAlpha(this.f43193r);
        this.f43177b.setAlpha(this.f43193r);
    }

    public void setProgress(int i10, boolean z10) {
        if (this.f43176a == null) {
            Log.w(f43174y, "setProgress, mProgressBar is null");
            return;
        }
        if (this.f43178c != 1) {
            setState(1);
            this.f43176a.setBackground(null);
            this.f43176a.setProgressDrawable(this.f43182g);
            setPercentageTextColor(this.f43180e);
        }
        if (z10) {
            this.f43176a.setProgress(i10, true);
        } else {
            this.f43176a.setProgress(i10);
            setPercentage(this.f43176a.getProgress());
        }
    }

    public HwProgressButton(Context context, AttributeSet attributeSet, int i10) {
        super(m54778a(context, i10), attributeSet, i10);
        this.f43176a = null;
        this.f43177b = null;
        this.f43178c = 0;
        this.f43184i = true;
        this.f43187l = 1.0f;
        this.f43195t = 0;
        this.f43196u = context;
        m54782a(super.getContext(), attributeSet, C8719R.layout.hwprogressbutton_layout);
    }

    /* renamed from: a */
    private static Context m54778a(Context context, int i10) {
        return HwWidgetCompat.wrapContext(context, i10, C8719R.style.Theme_Emui_HwProgressButton);
    }

    /* renamed from: a */
    private void m54782a(Context context, AttributeSet attributeSet, int i10) {
        if (getCurSdkVersion() >= 26) {
            setDefaultFocusHighlightEnabled(false);
        }
        Object systemService = getContext().getSystemService("layout_inflater");
        if (systemService instanceof LayoutInflater) {
            ((LayoutInflater) systemService).inflate(i10, (ViewGroup) this, true);
        }
        this.f43176a = (HwProgressBar) findViewById(C8719R.id.hwprogressbutton_progress_bar);
        HwTextView hwTextView = (HwTextView) findViewById(C8719R.id.hwprogressbutton_percentage_text_view);
        this.f43177b = hwTextView;
        HwProgressBar hwProgressBar = this.f43176a;
        if (hwProgressBar != null && hwTextView != null) {
            hwProgressBar.setOnVisualProgressChangedListener(new bzrwd());
            this.f43179d = "";
            this.f43193r = m54775a(C8719R.dimen.emui_disabled_alpha);
            m54781a(context, attributeSet);
            m54785b();
            setFocusable(true);
            return;
        }
        Log.e(f43174y, "init: mProgressBar is " + this.f43176a + " mPercentage is " + this.f43177b + " layoutResId: " + i10);
    }

    /* renamed from: a */
    private void m54780a(Context context) {
        Drawable drawable = ContextCompat.getDrawable(context, C8719R.drawable.hwprogressbutton_selector_btn_normal_bg_tint);
        Drawable drawableMutate = C13669a.m82231l(ContextCompat.getDrawable(context, C8719R.drawable.hwprogressbutton_selector_btn_disable_bg_tint)).mutate();
        C13669a.m82227h(drawableMutate, ContextCompat.getColor(context, C8719R.color.hwprogressbutton_color));
        this.f43185j = new LayerDrawable(new Drawable[]{drawableMutate, drawable});
    }

    /* renamed from: a */
    private void m54781a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes;
        Resources.Theme theme = context.getTheme();
        if (theme == null || (typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, C8719R.styleable.HwProgressButton, C8719R.attr.hwProgressButtonStyle, C8719R.style.Widget_Emui_HwProgressButton_Normal_Translucent)) == null) {
            return;
        }
        this.f43181f = typedArrayObtainStyledAttributes.getDrawable(C8719R.styleable.HwProgressButton_hwProgressButtonBackground);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(C8719R.styleable.HwProgressButton_hwProgressButtonProgressBarBackground);
        this.f43182g = drawable;
        if (f43166E >= 200) {
            replaceClipDrawable(drawable);
        }
        this.f43176a.setProgressDrawable(this.f43181f);
        boolean z10 = typedArrayObtainStyledAttributes.getBoolean(C8719R.styleable.HwProgressButton_hwProgressButtonIsHighlight, true);
        this.f43184i = z10;
        if (z10) {
            m54780a(context);
            this.f43176a.setProgressDrawable(this.f43185j);
        }
        this.f43183h = typedArrayObtainStyledAttributes.getColorStateList(C8719R.styleable.HwProgressButton_hwProgressButtonStaticTextColor);
        this.f43180e = typedArrayObtainStyledAttributes.getColorStateList(C8719R.styleable.HwProgressButton_hwProgressButtonDynamicTextColor);
        setPercentageTextColor(this.f43183h);
        this.f43188m = typedArrayObtainStyledAttributes.getDrawable(C8719R.styleable.HwProgressButton_hwFocusedDrawable);
        this.f43187l = typedArrayObtainStyledAttributes.getFloat(C8719R.styleable.HwProgressButton_hwHoveredZoomScale, 1.0f);
        this.f43191p = typedArrayObtainStyledAttributes.getColor(C8719R.styleable.HwProgressButton_hwFocusedPathColor, 0);
        this.f43190o = typedArrayObtainStyledAttributes.getDimension(C8719R.styleable.HwProgressButton_hwFocusedPathPadding, 0.0f);
        this.f43189n = typedArrayObtainStyledAttributes.getDimension(C8719R.styleable.HwProgressButton_hwFocusedPathWidth, 0.0f);
        this.f43192q = typedArrayObtainStyledAttributes.getDimension(C8719R.styleable.HwProgressButton_hwProgressButtonCornerRadius, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    private float m54775a(int i10) throws Resources.NotFoundException {
        TypedValue typedValue = new TypedValue();
        getResources().getValue(i10, typedValue, true);
        return typedValue.getFloat();
    }

    /* renamed from: a */
    private void m54783a(Canvas canvas) {
        if (isFocusable() && hasWindowFocus() && hasFocus()) {
            onDrawFocusedDrawable(canvas);
        }
    }

    /* renamed from: a */
    private void m54784a(boolean z10) {
        HwHoverAnimationUtils.getScaleAnimator(this, z10 ? this.f43187l : 1.0f).start();
    }

    /* renamed from: a */
    private void m54779a() {
        NumberFormat percentInstance;
        Locale locale = this.f43186k;
        if (locale == null || !locale.equals(Locale.getDefault())) {
            Locale locale2 = Locale.getDefault();
            this.f43186k = locale2;
            if (locale2 != null) {
                percentInstance = NumberFormat.getPercentInstance(locale2);
            } else {
                percentInstance = NumberFormat.getPercentInstance();
            }
            if (percentInstance != null) {
                percentInstance.setRoundingMode(RoundingMode.DOWN);
                percentInstance.setMaximumFractionDigits(0);
            }
        }
    }
}
