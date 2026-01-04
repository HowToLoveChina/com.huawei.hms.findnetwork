package com.huawei.uikit.hwbutton.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.TextView;
import com.huawei.uikit.animations.animator.HwHoverAnimationUtils;
import com.huawei.uikit.hwbutton.C8704R;
import com.huawei.uikit.hwprogressbar.widget.HwProgressBar;
import com.huawei.uikit.hwresources.utils.AuxiliaryHelper;
import com.huawei.uikit.hwresources.utils.HwWidgetCompat;
import com.huawei.uikit.hwresources.utils.HwWidgetInstantiator;
import com.huawei.uikit.hwtextview.widget.HwTextView;
import java.util.Locale;

/* loaded from: classes7.dex */
public class HwButton extends HwTextView {

    /* renamed from: C */
    private static final String f41625C = "HwButton";

    /* renamed from: D */
    private static final int f41626D = 15;

    /* renamed from: E */
    private static final int f41627E = 24;

    /* renamed from: F */
    private static final int f41628F = 8;

    /* renamed from: G */
    private static final int f41629G = 2;

    /* renamed from: H */
    private static final int f41630H = 2;

    /* renamed from: I */
    private static final int f41631I = 2;

    /* renamed from: J */
    private static final int f41632J = 0;

    /* renamed from: K */
    private static final int f41633K = 1;

    /* renamed from: L */
    private static final int f41634L = 2;

    /* renamed from: M */
    private static final int f41635M = 3;

    /* renamed from: N */
    private static final float f41636N = 1.0f;
    public static final int NORMAL_BUTTON = 0;

    /* renamed from: O */
    private static final int f41637O = 255;

    /* renamed from: P */
    private static final float f41638P = 1.0f;
    public static final int SMALL_BUTTON = 1;

    /* renamed from: A */
    private int[] f41639A;

    /* renamed from: B */
    private boolean f41640B;

    /* renamed from: a */
    private int f41641a;

    /* renamed from: b */
    private float f41642b;

    /* renamed from: c */
    private Drawable f41643c;

    /* renamed from: d */
    private int f41644d;

    /* renamed from: e */
    private HwProgressBar f41645e;

    /* renamed from: f */
    private int f41646f;

    /* renamed from: g */
    private int f41647g;

    /* renamed from: h */
    private int f41648h;

    /* renamed from: i */
    private int f41649i;

    /* renamed from: j */
    private String f41650j;

    /* renamed from: k */
    private float f41651k;

    /* renamed from: l */
    private String f41652l;

    /* renamed from: m */
    private boolean f41653m;

    /* renamed from: n */
    private boolean f41654n;

    /* renamed from: o */
    private int f41655o;

    /* renamed from: p */
    private int f41656p;

    /* renamed from: q */
    private int f41657q;

    /* renamed from: r */
    private int f41658r;

    /* renamed from: s */
    private Drawable f41659s;

    /* renamed from: t */
    private Drawable f41660t;

    /* renamed from: u */
    private Drawable f41661u;

    /* renamed from: v */
    private Drawable f41662v;

    /* renamed from: w */
    private ColorStateList f41663w;

    /* renamed from: x */
    private int f41664x;

    /* renamed from: y */
    private int f41665y;

    /* renamed from: z */
    private Rect f41666z;

    public HwButton(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    private void m54082a(Context context, AttributeSet attributeSet, int i10) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C8704R.styleable.HwButton, i10, 0);
        this.f41642b = typedArrayObtainStyledAttributes.getFloat(C8704R.styleable.HwButton_hwHoveredZoomScale, 1.0f);
        this.f41643c = typedArrayObtainStyledAttributes.getDrawable(C8704R.styleable.HwButton_hwFocusedDrawable);
        this.f41644d = typedArrayObtainStyledAttributes.getDimensionPixelSize(C8704R.styleable.HwButton_hwButtonfocusedPathWidth, 0);
        this.f41641a = typedArrayObtainStyledAttributes.getDimensionPixelSize(C8704R.styleable.HwButton_hwFocusedPathPadding, 0);
        this.f41657q = typedArrayObtainStyledAttributes.getColor(C8704R.styleable.HwButton_hwButtonWaitTextColor, 0);
        this.f41658r = typedArrayObtainStyledAttributes.getColor(C8704R.styleable.HwButton_hwButtonWaitIconColor, 0);
        this.f41646f = typedArrayObtainStyledAttributes.getDimensionPixelSize(C8704R.styleable.HwButton_hwButtonWaitIconSize, dipToPixel(24));
        this.f41649i = typedArrayObtainStyledAttributes.getDimensionPixelSize(C8704R.styleable.HwButton_hwButtonWaitIconPadding, dipToPixel(8));
        this.f41664x = typedArrayObtainStyledAttributes.getColor(C8704R.styleable.HwButton_hwFocusedPathColor, 0);
        boolean z10 = typedArrayObtainStyledAttributes.getBoolean(C8704R.styleable.HwButton_hwAuxiliaryEnable, true);
        if (AuxiliaryHelper.isAuxiliaryDevice(context) && z10 && Float.compare(AuxiliaryHelper.getFontSize(context), 1.75f) >= 0) {
            int i11 = typedArrayObtainStyledAttributes.getInt(C8704R.styleable.HwButton_hwButtonStyleType, 0);
            if (i11 == 0) {
                this.f41665y = getResources().getDimensionPixelSize(C8704R.dimen.hwbutton_big_padding_top_or_bottom);
            }
            if (i11 == 1) {
                this.f41665y = getResources().getDimensionPixelSize(C8704R.dimen.hwbutton_small_padding_top_or_bottom);
            }
            setMaxLines(2);
        }
        this.f41651k = getTextSize();
        typedArrayObtainStyledAttributes.recycle();
        setDefaultFocusHighlightEnabled(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008d  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m54084b() throws java.lang.ClassNotFoundException {
        /*
            r6 = this;
            boolean r0 = r6.f41653m
            if (r0 != 0) goto L5
            return
        L5:
            com.huawei.uikit.hwprogressbar.widget.HwProgressBar r0 = r6.f41645e
            java.lang.String r1 = "HwButton"
            if (r0 != 0) goto L1d
            android.content.Context r0 = r6.getContext()
            com.huawei.uikit.hwprogressbar.widget.HwProgressBar r0 = com.huawei.uikit.hwprogressbar.widget.HwProgressBar.instantiate(r0)
            r6.f41645e = r0
            if (r0 != 0) goto L1d
            java.lang.String r6 = "createProgressbar: HwProgressBar instantiate null!"
            android.util.Log.e(r1, r6)
            return
        L1d:
            r6.m54081a()
            android.view.ViewParent r0 = r6.getParent()
            boolean r2 = r0 instanceof android.view.ViewGroup
            if (r2 == 0) goto L2b
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            goto L2c
        L2b:
            r0 = 0
        L2c:
            if (r0 != 0) goto L34
            java.lang.String r6 = "HwButton::create progressbar fail"
            android.util.Log.w(r1, r6)
            return
        L34:
            r1 = 2
            int[] r2 = new int[r1]
            int[] r1 = new int[r1]
            r6.getLocationOnScreen(r2)
            r0.getLocationOnScreen(r1)
            int[] r3 = r6.f41639A
            r4 = 0
            r3 = r3[r4]
            r5 = r2[r4]
            if (r3 == r5) goto L57
            if (r3 != 0) goto L4e
            r3 = r1[r4]
            int r5 = r5 - r3
            goto L5a
        L4e:
            int r3 = java.lang.Math.min(r3, r5)
            r4 = r1[r4]
        L54:
            int r5 = r3 - r4
            goto L5a
        L57:
            r4 = r1[r4]
            goto L54
        L5a:
            boolean r3 = r6.f41640B
            r4 = 1
            if (r3 == 0) goto L67
            int[] r2 = r6.f41639A
            r2 = r2[r4]
            r1 = r1[r4]
        L65:
            int r2 = r2 - r1
            goto L6c
        L67:
            r2 = r2[r4]
            r1 = r1[r4]
            goto L65
        L6c:
            android.graphics.Rect r1 = r6.f41666z
            int r1 = r1.width()
            int r3 = r6.getLayoutDirection()
            if (r3 != r4) goto L79
            int r5 = r5 + r1
        L79:
            com.huawei.uikit.hwprogressbar.widget.HwProgressBar r1 = r6.f41645e
            r1.offsetLeftAndRight(r5)
            com.huawei.uikit.hwprogressbar.widget.HwProgressBar r1 = r6.f41645e
            r1.offsetTopAndBottom(r2)
            com.huawei.uikit.hwprogressbar.widget.HwProgressBar r1 = r6.f41645e
            android.graphics.drawable.Drawable r1 = r1.getIndeterminateDrawable()
            boolean r2 = r1 instanceof com.huawei.uikit.animations.drawable.HwSeekableGravitationalLoadingDrawable
            if (r2 == 0) goto Lb0
            int r2 = r6.f41658r
            int r2 = android.graphics.Color.alpha(r2)
            r3 = 1065353216(0x3f800000, float:1.0)
            if (r2 > 0) goto L98
            goto La4
        L98:
            int r2 = r6.f41658r
            int r2 = android.graphics.Color.alpha(r2)
            float r2 = (float) r2
            float r2 = r2 * r3
            r3 = 1132396544(0x437f0000, float:255.0)
            float r3 = r2 / r3
        La4:
            com.huawei.uikit.hwprogressbar.widget.HwProgressBar r2 = r6.f41645e
            r2.setAlpha(r3)
            com.huawei.uikit.animations.drawable.HwSeekableGravitationalLoadingDrawable r1 = (com.huawei.uikit.animations.drawable.HwSeekableGravitationalLoadingDrawable) r1
            int r2 = r6.f41658r
            r1.setColor(r2)
        Lb0:
            android.view.ViewGroupOverlay r0 = r0.getOverlay()
            com.huawei.uikit.hwprogressbar.widget.HwProgressBar r6 = r6.f41645e
            r0.add(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.uikit.hwbutton.widget.HwButton.m54084b():void");
    }

    /* renamed from: c */
    private void m54085c() {
        ViewGroup viewGroup;
        HwProgressBar hwProgressBar = this.f41645e;
        if (hwProgressBar != null) {
            ViewParent parent = hwProgressBar.getParent();
            if ((parent instanceof ViewGroup) && (viewGroup = (ViewGroup) parent) != null) {
                viewGroup.removeView(this.f41645e);
            }
            this.f41645e = null;
        }
    }

    /* renamed from: d */
    private void m54086d() {
        if (this.f41652l == null) {
            int i10 = this.f41655o;
            int i11 = this.f41665y;
            setPadding(i10, i11, this.f41656p, i11);
        } else {
            if (getLayoutDirection() == 1) {
                setPadding(this.f41655o, this.f41665y, this.f41656p + getIconSize() + getWaitingDrawablePadding(), this.f41665y);
                return;
            }
            int iconSize = this.f41655o + getIconSize() + getWaitingDrawablePadding();
            int i12 = this.f41665y;
            setPadding(iconSize, i12, this.f41656p, i12);
        }
    }

    public static int dipToPixel(int i10) {
        return (int) TypedValue.applyDimension(1, i10, Resources.getSystem().getDisplayMetrics());
    }

    public static HwButton instantiate(Context context) throws ClassNotFoundException {
        Object objInstantiate = HwWidgetInstantiator.instantiate(context, HwWidgetInstantiator.getDeviceClassName(context, HwButton.class, HwWidgetInstantiator.getCurrentType(context, 15, 1)), HwButton.class);
        if (objInstantiate instanceof HwButton) {
            return (HwButton) objInstantiate;
        }
        return null;
    }

    private void setOriDrawableVisible(boolean z10) {
        if (z10) {
            setCompoundDrawables(this.f41659s, this.f41661u, this.f41660t, this.f41662v);
            return;
        }
        Drawable[] compoundDrawables = getCompoundDrawables();
        if (compoundDrawables.length > 3) {
            this.f41659s = compoundDrawables[0];
            this.f41661u = compoundDrawables[1];
            this.f41660t = compoundDrawables[2];
            this.f41662v = compoundDrawables[3];
        }
        setCompoundDrawables(null, null, null, null);
    }

    private static Context wrapContext(Context context, int i10) {
        return HwWidgetCompat.wrapContext(context, i10, C8704R.style.Theme_Emui_HwButton);
    }

    public int getFocusPathColor() {
        return this.f41664x;
    }

    public Drawable getFocusedDrawable() {
        return this.f41643c;
    }

    public int getFocusedPathPadding() {
        return this.f41641a;
    }

    public int getFocusedPathWidth() {
        return this.f41644d;
    }

    public float getHoveredZoomScale() {
        return this.f41642b;
    }

    public int getIconSize() {
        return this.f41646f;
    }

    public int getIconStartLoc(int i10, int i11) {
        int i12;
        int iconSize;
        int width = getWidth();
        if (getLayoutDirection() != 1) {
            return i10 > width ? this.f41655o : (width / 2) - (i11 / 2);
        }
        if (i10 > width) {
            i12 = 0 - this.f41656p;
            iconSize = getIconSize();
        } else {
            i12 = 0 - ((width / 2) - (i11 / 2));
            iconSize = getIconSize();
        }
        return i12 - iconSize;
    }

    public int getWaitingDrawablePadding() {
        return this.f41649i;
    }

    public boolean isClickAnimationEnabled() {
        return false;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m54085c();
    }

    @Override // android.view.View
    public void onHoverChanged(boolean z10) {
        super.onHoverChanged(z10);
        if (this.f41642b == 1.0f) {
            return;
        }
        m54083a(z10);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return;
        }
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) throws ClassNotFoundException {
        super.onLayout(z10, i10, i11, i12, i13);
        if (this.f41653m) {
            m54086d();
            m54084b();
        }
    }

    public void onSetWaitingEnablePost(boolean z10, int i10, int i11) {
        if (z10) {
            setEnabled(false);
        } else {
            setEnabled(this.f41654n);
        }
    }

    public void setClickAnimationEnabled(boolean z10) {
    }

    public void setClickSelf(boolean z10) {
        this.f41640B = z10;
    }

    public void setFocusPathColor(int i10) {
        this.f41664x = i10;
    }

    public void setFocusedDrawable(Drawable drawable) {
        this.f41643c = drawable;
    }

    public void setFocusedPathPadding(int i10) {
        this.f41641a = i10;
    }

    public void setFocusedPathWidth(int i10) {
        this.f41644d = i10;
    }

    public void setHoveredZoomScale(float f10) {
        this.f41642b = f10;
    }

    public void setIconSize(int i10) {
        this.f41646f = i10;
    }

    public void setParentLocation(int[] iArr) {
        if (iArr == null) {
            return;
        }
        this.f41639A = iArr;
    }

    @Override // com.huawei.uikit.hwtextview.widget.HwTextView, android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(charSequence, bufferType);
        requestLayout();
        invalidate();
    }

    @Override // android.widget.TextView
    public void setTextSize(int i10, float f10) {
        if (getAutoSizeTextType() == 0) {
            this.f41651k = f10;
        }
        super.setTextSize(i10, f10);
    }

    public void setWaitingDrawablePadding(int i10) {
        this.f41649i = i10;
    }

    public void setWaitingEnable(boolean z10, String str) {
        if (!z10) {
            if (this.f41653m) {
                this.f41652l = null;
                m54085c();
                setOriDrawableVisible(true);
                setText(this.f41650j);
                ColorStateList colorStateList = this.f41663w;
                if (colorStateList != null) {
                    setTextColor(colorStateList);
                    this.f41663w = null;
                }
                int i10 = this.f41655o;
                int i11 = this.f41665y;
                setPadding(i10, i11, this.f41656p, i11);
                onSetWaitingEnablePost(false, this.f41647g, this.f41648h);
                this.f41653m = false;
                return;
            }
            return;
        }
        this.f41652l = str;
        if (!this.f41653m) {
            this.f41655o = getPaddingStart();
            this.f41656p = getPaddingEnd();
            this.f41663w = getTextColors();
            this.f41647g = getWidth();
            this.f41648h = getHeight();
            this.f41654n = isEnabled();
            this.f41650j = getText().toString();
            setOriDrawableVisible(false);
        }
        m54086d();
        setText(str);
        int i12 = this.f41657q;
        if (i12 != 0) {
            setTextColor(i12);
        }
        onSetWaitingEnablePost(true, this.f41647g, this.f41648h);
        this.f41653m = true;
    }

    public HwButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C8704R.attr.hwButtonStyle);
    }

    public HwButton(Context context, AttributeSet attributeSet, int i10) {
        super(wrapContext(context, i10), attributeSet, i10);
        this.f41663w = null;
        this.f41665y = 0;
        this.f41666z = new Rect();
        this.f41639A = new int[2];
        this.f41640B = false;
        m54082a(super.getContext(), attributeSet, i10);
    }

    /* renamed from: a */
    private void m54081a() {
        this.f41645e.measure(getWidth(), getHeight());
        int iM54080a = m54080a(this.f41652l);
        int i10 = this.f41655o + iM54080a + this.f41656p;
        getHitRect(this.f41666z);
        int iHeight = this.f41666z.height() / 2;
        int i11 = this.f41646f / 2;
        int iconStartLoc = getIconStartLoc(i10, iM54080a);
        int i12 = this.f41646f + iconStartLoc;
        this.f41645e.layout(iconStartLoc, iHeight - i11, i12, iHeight + i11);
    }

    /* renamed from: a */
    private int m54080a(String str) {
        int iMeasureText;
        if (str != null) {
            String string = getText().toString();
            if (isAllCaps()) {
                string = string.toUpperCase(Locale.ENGLISH);
            }
            iMeasureText = (int) getPaint().measureText(string);
            if (getTextSize() != 0.0f && this.f41651k != 0.0f) {
                iMeasureText = (int) ((iMeasureText / getTextSize()) * this.f41651k);
            } else {
                Log.w(f41625C, "getButtonContentWidth: wrong para!");
            }
        } else {
            iMeasureText = 0;
        }
        if (iMeasureText != 0) {
            return getIconSize() + getWaitingDrawablePadding() + iMeasureText;
        }
        return getIconSize();
    }

    /* renamed from: a */
    private void m54083a(boolean z10) {
        HwHoverAnimationUtils.getScaleAnimator(this, z10 ? this.f41642b : 1.0f).start();
    }
}
