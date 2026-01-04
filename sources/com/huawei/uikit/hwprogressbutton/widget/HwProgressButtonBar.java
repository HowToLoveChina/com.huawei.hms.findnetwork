package com.huawei.uikit.hwprogressbutton.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.huawei.uikit.hwbutton.widget.HwButton;
import com.huawei.uikit.hwprogressbutton.C8719R;
import com.huawei.uikit.hwresources.utils.AuxiliaryHelper;
import com.huawei.uikit.hwresources.utils.HwWidgetCompat;
import com.huawei.uikit.hwresources.utils.HwWidgetInstantiator;
import com.huawei.uikit.hwtextview.widget.HwTextView;
import p757x.C13669a;

/* loaded from: classes4.dex */
public class HwProgressButtonBar extends LinearLayout {
    public static final int PROGRESS_STYLE = 0;
    public static final int TWO_BUTTONS_STYLE = 1;

    /* renamed from: q */
    private static final String f43200q = "HwProgressButtonBar";

    /* renamed from: r */
    private static final int f43201r = 1;

    /* renamed from: s */
    private static final int f43202s = 3;

    /* renamed from: a */
    private HwProgressButton f43203a;

    /* renamed from: b */
    private HwTextView f43204b;

    /* renamed from: c */
    private HwTextView f43205c;

    /* renamed from: d */
    private HwButton f43206d;

    /* renamed from: e */
    private HwButton f43207e;

    /* renamed from: f */
    private LinearLayout f43208f;

    /* renamed from: g */
    private LinearLayout f43209g;

    /* renamed from: h */
    private LinearLayout f43210h;

    /* renamed from: i */
    private int f43211i;

    /* renamed from: j */
    private int f43212j;

    /* renamed from: k */
    private int f43213k;

    /* renamed from: l */
    private int f43214l;

    /* renamed from: m */
    private ColorStateList f43215m;

    /* renamed from: n */
    private ColorStateList f43216n;

    /* renamed from: o */
    private ColorStateList f43217o;

    /* renamed from: p */
    private ColorStateList f43218p;

    public class bzrwd implements Runnable {

        /* renamed from: com.huawei.uikit.hwprogressbutton.widget.HwProgressButtonBar$bzrwd$bzrwd, reason: collision with other inner class name */
        public class ViewTreeObserverOnPreDrawListenerC14499bzrwd implements ViewTreeObserver.OnPreDrawListener {

            /* renamed from: a */
            final /* synthetic */ HwTextView f43220a;

            /* renamed from: b */
            final /* synthetic */ HwProgressButton f43221b;

            /* renamed from: c */
            final /* synthetic */ String f43222c;

            /* renamed from: d */
            final /* synthetic */ HwButton f43223d;

            /* renamed from: e */
            final /* synthetic */ HwButton f43224e;

            public ViewTreeObserverOnPreDrawListenerC14499bzrwd(HwTextView hwTextView, HwProgressButton hwProgressButton, String str, HwButton hwButton, HwButton hwButton2) {
                this.f43220a = hwTextView;
                this.f43221b = hwProgressButton;
                this.f43222c = str;
                this.f43223d = hwButton;
                this.f43224e = hwButton2;
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (!"".equals(this.f43220a.getText().toString())) {
                    return false;
                }
                this.f43221b.getViewTreeObserver().removeOnPreDrawListener(this);
                int measuredHeight = this.f43221b.getMeasuredHeight();
                this.f43221b.setIdleText(this.f43222c);
                this.f43223d.setMinHeight(measuredHeight);
                this.f43224e.setMinHeight(measuredHeight);
                this.f43223d.setMaxLines(1);
                this.f43224e.setMaxLines(1);
                this.f43220a.setMinHeight(measuredHeight);
                ViewGroup startContainer = HwProgressButtonBar.this.getStartContainer();
                ViewGroup endContainer = HwProgressButtonBar.this.getEndContainer();
                if (startContainer != null && endContainer != null) {
                    int i10 = measuredHeight + HwProgressButtonBar.this.f43213k;
                    startContainer.setMinimumWidth(i10);
                    startContainer.setMinimumHeight(i10);
                    endContainer.setMinimumWidth(i10);
                    endContainer.setMinimumHeight(i10);
                }
                return true;
            }
        }

        public bzrwd() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HwTextView percentage;
            HwProgressButton hwProgressButton = HwProgressButtonBar.this.getHwProgressButton();
            HwButton applyButton = HwProgressButtonBar.this.getApplyButton();
            HwButton updateButton = HwProgressButtonBar.this.getUpdateButton();
            if (hwProgressButton == null || applyButton == null || updateButton == null || (percentage = hwProgressButton.getPercentage()) == null) {
                return;
            }
            String string = percentage.getText().toString();
            hwProgressButton.setIdleText("");
            hwProgressButton.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserverOnPreDrawListenerC14499bzrwd(percentage, hwProgressButton, string, applyButton, updateButton));
        }
    }

    public HwProgressButtonBar(Context context) {
        this(context, null);
    }

    private ColorStateList getSmartIconColor() {
        return this.f43217o;
    }

    private ColorStateList getSmartTitleColor() {
        return this.f43218p;
    }

    public static HwProgressButtonBar instantiate(Context context) throws ClassNotFoundException {
        Object objInstantiate = HwWidgetInstantiator.instantiate(context, HwWidgetInstantiator.getDeviceClassName(context, HwProgressButtonBar.class, HwWidgetInstantiator.getCurrentType(context, 3, 1)), HwProgressButtonBar.class);
        if (objInstantiate instanceof HwProgressButtonBar) {
            return (HwProgressButtonBar) objInstantiate;
        }
        return null;
    }

    private void setIconBounds(Drawable drawable) {
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i10 = this.f43212j;
            if (intrinsicWidth > i10) {
                if (intrinsicWidth != 0) {
                    intrinsicHeight = (int) (intrinsicHeight * (i10 / intrinsicWidth));
                }
                intrinsicWidth = i10;
            }
            if (intrinsicHeight <= i10) {
                i10 = intrinsicHeight;
            } else if (intrinsicHeight != 0) {
                intrinsicWidth = (int) (intrinsicWidth * (i10 / intrinsicHeight));
            }
            drawable.setBounds(0, 0, intrinsicWidth, i10);
        }
    }

    public HwButton getApplyButton() {
        return this.f43206d;
    }

    public int getApplyButtonId() {
        return C8719R.id.hwprogressbutton_bar_apply_button;
    }

    public ViewGroup getEndContainer() {
        return this.f43210h;
    }

    public int getEndItemId() {
        return C8719R.id.hwprogressbutton_bar_end_container;
    }

    public HwProgressButton getHwProgressButton() {
        return this.f43203a;
    }

    public int getHwProgressButtonId() {
        return C8719R.id.hwprogressbutton_bar_progressbutton;
    }

    public ViewGroup getStartContainer() {
        return this.f43209g;
    }

    public int getStartItemId() {
        return C8719R.id.hwprogressbutton_bar_start_container;
    }

    public int getStyleMode() {
        return this.f43211i;
    }

    public HwButton getUpdateButton() {
        return this.f43207e;
    }

    public int getUpdateButtonId() {
        return C8719R.id.hwprogressbutton_bar_update_button;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        HwTextView hwTextView = this.f43204b;
        int lineCount = hwTextView != null ? hwTextView.getLineCount() : 0;
        HwTextView hwTextView2 = this.f43205c;
        int lineCount2 = hwTextView2 != null ? hwTextView2.getLineCount() : 0;
        if (this.f43205c != null && this.f43204b != null) {
            if (lineCount > 1 || lineCount2 > 1) {
                int i12 = this.f43214l;
                setPadding(0, i12, 0, i12);
                this.f43209g.setGravity(49);
                this.f43210h.setGravity(49);
            } else {
                setPadding(0, 0, 0, 0);
                this.f43209g.setGravity(17);
                this.f43210h.setGravity(17);
            }
        }
        super.onMeasure(i10, i11);
    }

    public void setApplyButtonClickListener(View.OnClickListener onClickListener) {
        HwButton hwButton = this.f43206d;
        if (hwButton == null) {
            Log.w(f43200q, "primary button is null ");
        } else {
            hwButton.setOnClickListener(onClickListener);
        }
    }

    public void setButtonsText(CharSequence charSequence, CharSequence charSequence2) {
        m54795a(charSequence, this.f43206d);
        m54795a(charSequence2, this.f43207e);
    }

    public void setEndItem(Drawable drawable, CharSequence charSequence) {
        m54794a(this.f43210h, this.f43205c, drawable, charSequence);
    }

    public void setEndItemClickListener(View.OnClickListener onClickListener) {
        LinearLayout linearLayout = this.f43210h;
        if (linearLayout == null) {
            Log.w(f43200q, "endItem is null");
        } else {
            linearLayout.setOnClickListener(onClickListener);
        }
    }

    public void setSmartIconColor(ColorStateList colorStateList) {
        this.f43217o = colorStateList;
    }

    public void setSmartTitleColor(ColorStateList colorStateList) {
        this.f43218p = colorStateList;
    }

    public void setStartAndEndItem(Drawable drawable, CharSequence charSequence, Drawable drawable2, CharSequence charSequence2) {
        m54794a(this.f43209g, this.f43204b, drawable, charSequence);
        m54794a(this.f43210h, this.f43205c, drawable2, charSequence2);
    }

    public void setStartItem(Drawable drawable, CharSequence charSequence) {
        m54794a(this.f43209g, this.f43204b, drawable, charSequence);
    }

    public void setStartItemClickListener(View.OnClickListener onClickListener) {
        LinearLayout linearLayout = this.f43209g;
        if (linearLayout == null) {
            Log.w(f43200q, "startItem is null");
        } else {
            linearLayout.setOnClickListener(onClickListener);
        }
    }

    public void setStyleMode(int i10) {
        this.f43211i = i10;
        if (i10 == 0) {
            this.f43208f.setVisibility(8);
            this.f43203a.setVisibility(0);
        } else {
            if (i10 != 1) {
                return;
            }
            this.f43208f.setVisibility(0);
            this.f43203a.setVisibility(8);
        }
    }

    public void setUpdateButtonClickListener(View.OnClickListener onClickListener) {
        HwButton hwButton = this.f43207e;
        if (hwButton == null) {
            Log.w(f43200q, "primary button is null ");
        } else {
            hwButton.setOnClickListener(onClickListener);
        }
    }

    public HwProgressButtonBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C8719R.attr.hwProgressButtonBarStyle);
    }

    /* renamed from: a */
    private static Context m54791a(Context context, int i10) {
        return HwWidgetCompat.wrapContext(context, i10, C8719R.style.Theme_Emui_HwProgressButton);
    }

    public void setEndItem(int i10, int i11) {
        m54794a(this.f43210h, this.f43205c, ContextCompat.getDrawable(getContext(), i10), getContext().getResources().getText(i11));
    }

    public void setStartItem(int i10, int i11) {
        m54794a(this.f43209g, this.f43204b, ContextCompat.getDrawable(getContext(), i10), getContext().getResources().getText(i11));
    }

    public HwProgressButtonBar(Context context, AttributeSet attributeSet, int i10) {
        super(m54791a(context, i10), attributeSet, i10);
        m54793a(context, attributeSet, C8719R.layout.hwprogressbuttonbar_layout);
    }

    /* renamed from: a */
    private void m54793a(Context context, AttributeSet attributeSet, int i10) {
        TypedArray typedArrayObtainStyledAttributes;
        LayoutInflater.from(getContext()).inflate(i10, (ViewGroup) this, true);
        this.f43204b = (HwTextView) findViewById(C8719R.id.hwprogressbutton_bar_start_text_view);
        this.f43205c = (HwTextView) findViewById(C8719R.id.hwprogressbutton_bar_end_text_view);
        this.f43206d = (HwButton) findViewById(C8719R.id.hwprogressbutton_bar_apply_button);
        this.f43207e = (HwButton) findViewById(C8719R.id.hwprogressbutton_bar_update_button);
        this.f43203a = (HwProgressButton) findViewById(C8719R.id.hwprogressbutton_bar_progressbutton);
        this.f43208f = (LinearLayout) findViewById(C8719R.id.hwprogressbutton_bar_button_layout);
        this.f43209g = (LinearLayout) findViewById(C8719R.id.hwprogressbutton_bar_start_container);
        this.f43210h = (LinearLayout) findViewById(C8719R.id.hwprogressbutton_bar_end_container);
        try {
            this.f43214l = getResources().getDimensionPixelSize(C8719R.dimen.hwprogressbutton_bar_padding);
            this.f43212j = getResources().getDimensionPixelSize(C8719R.dimen.hwprogressbutton_bar_item_icon_size);
            this.f43213k = (int) context.getResources().getDimension(C8719R.dimen.hwprogressbutton_bar_height_margin);
        } catch (Resources.NotFoundException unused) {
            Log.e(f43200q, "resource not found");
        }
        int i11 = C8719R.drawable.hwprogressbutton_selector_btn_normal_bg_tint;
        Drawable drawable = ContextCompat.getDrawable(context, i11);
        int i12 = C8719R.drawable.hwprogressbutton_selector_btn_disable_bg_tint;
        Drawable drawable2 = ContextCompat.getDrawable(context, i12);
        Drawable drawable3 = ContextCompat.getDrawable(context, i12);
        Drawable drawable4 = ContextCompat.getDrawable(context, i11);
        Drawable drawableMutate = C13669a.m82231l(drawable2).mutate();
        Drawable drawableMutate2 = C13669a.m82231l(drawable3).mutate();
        int i13 = C8719R.color.emui_accent;
        C13669a.m82227h(drawableMutate, ContextCompat.getColor(context, i13));
        C13669a.m82227h(drawableMutate2, ContextCompat.getColor(context, i13));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{drawableMutate, drawable});
        LayerDrawable layerDrawable2 = new LayerDrawable(new Drawable[]{drawableMutate2, drawable4});
        this.f43206d.setBackground(layerDrawable);
        this.f43207e.setBackground(layerDrawable2);
        Resources.Theme theme = context.getTheme();
        if (theme != null && (typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, C8719R.styleable.HwProgressButton, C8719R.attr.hwProgressButtonBarMenuStyle, C8719R.style.Widget_Emui_HwProgressButtonBar_Button_Small)) != null) {
            this.f43216n = typedArrayObtainStyledAttributes.getColorStateList(C8719R.styleable.HwProgressButton_hwProgressButtonBarMenuTextColor);
            this.f43215m = typedArrayObtainStyledAttributes.getColorStateList(C8719R.styleable.HwProgressButton_hwProgressButtonBarMenuIconColor);
            typedArrayObtainStyledAttributes.recycle();
        }
        setStyleMode(0);
        m54792a(getContext());
    }

    public void setButtonsText(int i10, int i11) {
        m54795a(getContext().getResources().getText(i10), this.f43206d);
        m54795a(getContext().getResources().getText(i11), this.f43207e);
    }

    public void setStartAndEndItem(int i10, int i11, int i12, int i13) {
        Resources resources = getContext().getResources();
        m54794a(this.f43209g, this.f43204b, ContextCompat.getDrawable(getContext(), i10), resources.getText(i11));
        m54794a(this.f43210h, this.f43205c, ContextCompat.getDrawable(getContext(), i12), resources.getText(i13));
    }

    /* renamed from: a */
    private void m54792a(Context context) {
        if (!AuxiliaryHelper.isAuxiliaryDevice(context) || Float.compare(AuxiliaryHelper.getFontSize(context), 1.75f) < 0) {
            return;
        }
        post(new bzrwd());
    }

    /* renamed from: a */
    private void m54794a(LinearLayout linearLayout, HwTextView hwTextView, Drawable drawable, CharSequence charSequence) {
        if (hwTextView != null && linearLayout != null) {
            hwTextView.setText(charSequence);
            if (drawable == null && !m54796a(hwTextView)) {
                linearLayout.setVisibility(8);
                return;
            }
            setIconBounds(drawable);
            if (m54796a(hwTextView)) {
                hwTextView.setBackground(null);
                hwTextView.setCompoundDrawables(null, drawable, null, null);
            } else {
                hwTextView.setCompoundDrawables(null, null, null, null);
                hwTextView.setBackground(drawable);
            }
            ColorStateList smartIconColor = getSmartIconColor();
            ColorStateList smartTitleColor = getSmartTitleColor();
            Drawable drawableMutate = drawable != null ? C13669a.m82231l(drawable).mutate() : null;
            if (smartIconColor != null && smartTitleColor != null) {
                if (drawableMutate != null) {
                    C13669a.m82228i(drawableMutate, smartIconColor);
                }
                hwTextView.setTextColor(smartTitleColor);
                return;
            }
            ColorStateList colorStateList = this.f43215m;
            if (colorStateList != null && drawableMutate != null) {
                C13669a.m82228i(drawableMutate, colorStateList);
            }
            ColorStateList colorStateList2 = this.f43216n;
            if (colorStateList2 != null) {
                hwTextView.setTextColor(colorStateList2);
                return;
            }
            return;
        }
        Log.w(f43200q, "item layout initialization failed");
    }

    /* renamed from: a */
    private boolean m54796a(HwTextView hwTextView) {
        return !TextUtils.isEmpty(hwTextView.getText());
    }

    /* renamed from: a */
    private void m54795a(CharSequence charSequence, HwButton hwButton) {
        if (hwButton == null) {
            Log.w(f43200q, "button layout initialization failed");
        } else {
            hwButton.setText(charSequence);
        }
    }
}
