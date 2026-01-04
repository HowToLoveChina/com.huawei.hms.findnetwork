package com.huawei.uikit.hwedittext.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.huawei.android.hicloud.sync.service.aidl.SyncType;
import com.huawei.uikit.hwedittext.C8712R;
import com.huawei.uikit.hwresources.utils.HwWidgetCompat;
import com.huawei.uikit.hwresources.utils.HwWidgetInstantiator;
import p211d.C8968a;
import p757x.C13669a;

/* loaded from: classes7.dex */
public class HwIconTextLayout extends LinearLayout {

    /* renamed from: q */
    private static final int f42755q = 3;

    /* renamed from: a */
    private HwWidgetStyle f42756a;

    /* renamed from: b */
    private EditText f42757b;

    /* renamed from: c */
    private AppCompatImageView f42758c;

    /* renamed from: d */
    private View.OnClickListener f42759d;

    /* renamed from: e */
    private boolean f42760e;

    /* renamed from: f */
    private OnPasswordVisibleChangedListener f42761f;

    /* renamed from: g */
    private Drawable f42762g;

    /* renamed from: h */
    private View f42763h;

    /* renamed from: i */
    private CharSequence f42764i;

    /* renamed from: j */
    private CharSequence f42765j;

    /* renamed from: k */
    private int f42766k;

    /* renamed from: l */
    private int f42767l;

    /* renamed from: m */
    private int f42768m;
    protected HwShapeMode mHwShapMode;

    /* renamed from: n */
    private Drawable f42769n;

    /* renamed from: o */
    private Drawable f42770o;

    /* renamed from: p */
    private boolean f42771p;

    public interface OnPasswordVisibleChangedListener {
        void onPasswordVisibleChanged(ImageView imageView, boolean z10);
    }

    public class bzrwd implements View.OnClickListener {
        public bzrwd() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (HwIconTextLayout.this.f42760e) {
                HwIconTextLayout.this.m54665e();
                if (HwIconTextLayout.this.f42761f != null) {
                    HwIconTextLayout.this.f42761f.onPasswordVisibleChanged(HwIconTextLayout.this.f42758c, HwIconTextLayout.this.m54660b());
                }
            }
            if (HwIconTextLayout.this.f42759d != null) {
                HwIconTextLayout.this.f42759d.onClick(HwIconTextLayout.this.f42758c);
            }
        }
    }

    public HwIconTextLayout(Context context) {
        this(context, null);
    }

    private void getEyeId() {
        HwWidgetStyle hwWidgetStyle = this.f42756a;
        if (hwWidgetStyle == HwWidgetStyle.LIGHT) {
            this.f42767l = C8712R.drawable.hwedittext_ic_visibility_password;
            this.f42768m = C8712R.drawable.hwedittext_ic_visibility_off_password;
        } else if (hwWidgetStyle == HwWidgetStyle.DARK) {
            this.f42767l = C8712R.drawable.hwedittext_ic_visibility_password_dark;
            this.f42768m = C8712R.drawable.hwedittext_ic_visibility_off_password_dark;
        } else {
            this.f42767l = C8712R.drawable.hwedittext_ic_visibility_password_translucent;
            this.f42768m = C8712R.drawable.hwedittext_ic_visibility_off_password_translucent;
        }
    }

    public static HwIconTextLayout instantiate(Context context) throws ClassNotFoundException {
        Object objInstantiate = HwWidgetInstantiator.instantiate(context, HwWidgetInstantiator.getDeviceClassName(context, HwIconTextLayout.class, HwWidgetInstantiator.getCurrentType(context, 3, 1)), HwIconTextLayout.class);
        if (objInstantiate instanceof HwIconTextLayout) {
            return (HwIconTextLayout) objInstantiate;
        }
        return null;
    }

    public EditText getEditText() {
        return this.f42757b;
    }

    public CharSequence getHint() {
        return this.f42757b.getHint();
    }

    public Drawable getIcon() {
        return this.f42758c.getDrawable();
    }

    public Drawable getIconBackground() {
        return this.f42763h.getBackground();
    }

    public AppCompatImageView getImageView() {
        return this.f42758c;
    }

    public View.OnClickListener getOnIconClickListener() {
        return this.f42759d;
    }

    public OnPasswordVisibleChangedListener getOnPasswordVisibleChangedListener() {
        return this.f42761f;
    }

    public CharSequence getText() {
        return this.f42757b.getText();
    }

    public boolean isPasswordType() {
        return this.f42760e;
    }

    public boolean isSafeEditText() {
        return this.f42771p;
    }

    public void setHint(CharSequence charSequence) {
        this.f42757b.setHint(charSequence);
    }

    public void setIcon(Drawable drawable) {
        this.f42758c.setImageDrawable(drawable);
    }

    public void setIconBackground(Drawable drawable) {
        this.f42763h.setBackground(drawable);
        this.f42762g = drawable;
    }

    public void setOnIconClickListener(View.OnClickListener onClickListener) {
        this.f42759d = onClickListener;
    }

    public void setOnPasswordVisibleChangedListener(OnPasswordVisibleChangedListener onPasswordVisibleChangedListener) {
        this.f42761f = onPasswordVisibleChangedListener;
        boolean z10 = onPasswordVisibleChangedListener != null;
        if (this.f42760e != z10) {
            this.f42760e = z10;
            m54664d();
        }
    }

    public void setPasswordType(boolean z10) {
        if (this.f42760e != z10) {
            this.f42760e = z10;
            m54664d();
        }
    }

    public void setSafeEditText(boolean z10) {
        this.f42771p = z10;
    }

    public void setText(CharSequence charSequence) {
        this.f42757b.setText(charSequence);
    }

    public HwIconTextLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C8712R.attr.hwIconTextStyle);
    }

    /* renamed from: a */
    private static Context m54652a(Context context, int i10) {
        return HwWidgetCompat.wrapContext(context, i10, C8712R.style.Theme_Emui_HwEditText);
    }

    /* renamed from: b */
    private void m54658b(int i10) {
        View.inflate(getContext(), i10, this);
        EditText editText = (EditText) findViewById(C8712R.id.hwedittext_edit);
        this.f42757b = editText;
        if (editText != null) {
            editText.setHint(this.f42764i);
            this.f42757b.setText(this.f42765j);
        }
        AppCompatImageView appCompatImageView = (AppCompatImageView) findViewById(C8712R.id.hwedittext_icon);
        this.f42758c = appCompatImageView;
        if (appCompatImageView != null) {
            if (appCompatImageView.getParent() instanceof View) {
                this.f42763h = (View) this.f42758c.getParent();
            }
            if (this.f42763h == null) {
                return;
            }
            int i11 = this.f42766k;
            if (i11 > 0) {
                this.f42758c.setImageDrawable(m54653a(i11));
            }
            HwShapeMode hwShapeMode = this.mHwShapMode;
            setIconBackground((hwShapeMode == HwShapeMode.BUBBLE || hwShapeMode == HwShapeMode.WHITE) ? this.f42769n : this.f42770o);
            m54664d();
            this.f42763h.setOnClickListener(new bzrwd());
        }
    }

    /* renamed from: c */
    private void m54662c() {
        this.f42757b.setAutofillHints("password");
    }

    /* renamed from: d */
    private void m54664d() {
        if (!this.f42760e) {
            this.f42763h.setBackground(this.f42762g);
            return;
        }
        this.f42757b.setTextDirection(5);
        this.f42757b.setTextAlignment(5);
        this.f42763h.setBackground(this.f42762g);
        m54665e();
        m54662c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m54665e() {
        EditText editText = this.f42757b;
        if (editText instanceof HwEditText) {
            if (this.f42771p) {
                ((HwEditText) editText).setSafeEditText(true);
            } else {
                ((HwEditText) editText).setSafeEditText(false);
            }
        }
        int selectionStart = this.f42757b.getSelectionStart();
        if (m54660b() || !m54656a()) {
            this.f42757b.setInputType(SyncType.WLAN_CHANGE);
            this.f42758c.setImageDrawable(C8968a.m56743b(getContext(), this.f42768m));
        } else {
            this.f42757b.setInputType(145);
            this.f42758c.setImageDrawable(C8968a.m56743b(getContext(), this.f42767l));
        }
        this.f42757b.setSelection(selectionStart);
    }

    public HwIconTextLayout(Context context, AttributeSet attributeSet, int i10) {
        super(m54652a(context, i10), attributeSet, i10);
        this.f42766k = 0;
        this.f42767l = 0;
        this.f42768m = 0;
        this.f42771p = false;
        m54655a(super.getContext(), attributeSet, i10);
        HwShapeMode hwShapeMode = this.mHwShapMode;
        if (hwShapeMode == HwShapeMode.BUBBLE) {
            m54654a(C8712R.layout.hwedittext_icon_text_layout_bubble, C8712R.layout.hwedittext_icon_text_layout_bubble_dark, C8712R.layout.hwedittext_icon_text_layout_bubble_translucent);
            return;
        }
        if (hwShapeMode == HwShapeMode.LINEAR) {
            m54654a(C8712R.layout.hwedittext_icon_text_layout_linear, C8712R.layout.hwedittext_icon_text_layout_linear_dark, C8712R.layout.hwedittext_icon_text_layout_linear_translucent);
        } else if (hwShapeMode == HwShapeMode.WHITE) {
            m54654a(C8712R.layout.hwedittext_icon_text_layout_bubble_white, C8712R.layout.hwedittext_icon_text_layout_bubble_white_dark, C8712R.layout.hwedittext_icon_text_layout_bubble_white_translucent);
        } else {
            m54654a(C8712R.layout.hwedittext_icon_text_layout_space, C8712R.layout.hwedittext_icon_text_layout_space_dark, C8712R.layout.hwedittext_icon_text_layout_space_translucent);
        }
    }

    /* renamed from: a */
    private void m54655a(Context context, AttributeSet attributeSet, int i10) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C8712R.styleable.HwIconTextLayout, i10, C8712R.style.Widget_Emui_HwIconTextLayout);
        int i11 = typedArrayObtainStyledAttributes.getInt(C8712R.styleable.HwIconTextLayout_hwShapeMode, 0);
        if (i11 >= 0 && i11 < HwShapeMode.values().length) {
            this.mHwShapMode = HwShapeMode.values()[i11];
        }
        this.f42756a = HwWidgetStyle.values()[typedArrayObtainStyledAttributes.getInt(C8712R.styleable.HwIconTextLayout_hwWidgetStyle, 0)];
        this.f42764i = typedArrayObtainStyledAttributes.getString(C8712R.styleable.HwIconTextLayout_hwHint);
        this.f42765j = typedArrayObtainStyledAttributes.getString(C8712R.styleable.HwIconTextLayout_hwText);
        this.f42760e = typedArrayObtainStyledAttributes.getBoolean(C8712R.styleable.HwIconTextLayout_hwIsPassword, false);
        int i12 = C8712R.styleable.HwIconTextLayout_hwIcon;
        if (typedArrayObtainStyledAttributes.hasValue(i12)) {
            this.f42766k = typedArrayObtainStyledAttributes.getResourceId(i12, 0);
        }
        this.f42770o = typedArrayObtainStyledAttributes.getDrawable(C8712R.styleable.HwIconTextLayout_hwLinearIconBackground);
        this.f42769n = typedArrayObtainStyledAttributes.getDrawable(C8712R.styleable.HwIconTextLayout_hwBubbleIconBackground);
        typedArrayObtainStyledAttributes.recycle();
        getEyeId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public boolean m54660b() {
        return (this.f42757b.getInputType() & 4095) == 145;
    }

    /* renamed from: a */
    private void m54654a(int i10, int i11, int i12) {
        HwWidgetStyle hwWidgetStyle = this.f42756a;
        if (hwWidgetStyle == HwWidgetStyle.LIGHT) {
            m54658b(i10);
        } else if (hwWidgetStyle == HwWidgetStyle.DARK) {
            m54658b(i11);
        } else {
            m54658b(i12);
        }
    }

    /* renamed from: a */
    private boolean m54656a() {
        int inputType = this.f42757b.getInputType() & 4095;
        return (inputType == 129) | (inputType == 225) | (inputType == 18);
    }

    /* renamed from: a */
    private Drawable m54653a(int i10) {
        Drawable drawableM56743b = C8968a.m56743b(getContext(), i10);
        if (drawableM56743b != null) {
            C13669a.m82223d(drawableM56743b, true);
        }
        return drawableM56743b;
    }
}
