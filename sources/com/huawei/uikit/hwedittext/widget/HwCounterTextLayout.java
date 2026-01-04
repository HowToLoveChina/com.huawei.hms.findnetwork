package com.huawei.uikit.hwedittext.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.C0669j;
import com.huawei.uikit.hwedittext.C8712R;
import com.huawei.uikit.hwresources.utils.HwWidgetCompat;
import com.huawei.uikit.hwresources.utils.HwWidgetInstantiator;
import p304g0.C9832l;

/* loaded from: classes7.dex */
public class HwCounterTextLayout extends LinearLayout {

    /* renamed from: q */
    private static final String f42694q = "HwCounterTextLayout";

    /* renamed from: r */
    private static final int f42695r = 3;

    /* renamed from: s */
    private static final float f42696s = 0.9f;

    /* renamed from: t */
    private static final int f42697t = 50;

    /* renamed from: u */
    private static final int f42698u = -1;

    /* renamed from: a */
    private EditText f42699a;

    /* renamed from: b */
    private TextView f42700b;

    /* renamed from: c */
    private HwShapeMode f42701c;

    /* renamed from: d */
    private int f42702d;

    /* renamed from: e */
    private int f42703e;

    /* renamed from: f */
    private int f42704f;

    /* renamed from: g */
    private int f42705g;

    /* renamed from: h */
    private int f42706h;

    /* renamed from: i */
    private int f42707i;

    /* renamed from: j */
    private int f42708j;

    /* renamed from: k */
    private int f42709k;

    /* renamed from: l */
    private int f42710l;

    /* renamed from: m */
    private int f42711m;

    /* renamed from: n */
    private Animation f42712n;

    /* renamed from: o */
    private bqmxo f42713o;

    /* renamed from: p */
    private aauaf f42714p;

    public class aauaf implements Animation.AnimationListener {

        /* renamed from: a */
        private boolean f42715a;

        private aauaf() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            C0669j.m4080n(HwCounterTextLayout.this.f42700b, HwCounterTextLayout.this.f42702d);
            HwCounterTextLayout.this.setBackground(false);
            this.f42715a = false;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            HwCounterTextLayout.this.f42700b.setTextColor(HwCounterTextLayout.this.f42703e);
            HwCounterTextLayout.this.setBackground(this.f42715a);
        }

        public /* synthetic */ aauaf(HwCounterTextLayout hwCounterTextLayout, bzrwd bzrwdVar) {
            this();
        }
    }

    public class akxao extends View.AccessibilityDelegate {
        private akxao() {
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            if (view == null || accessibilityEvent == null) {
                return;
            }
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(HwCounterTextLayout.class.getSimpleName());
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            if (view == null || accessibilityNodeInfo == null) {
                return;
            }
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(HwCounterTextLayout.class.getSimpleName());
            if (HwCounterTextLayout.this.f42699a != null) {
                accessibilityNodeInfo.setLabelFor(HwCounterTextLayout.this.f42699a);
            }
            CharSequence error = HwCounterTextLayout.this.getError();
            if (TextUtils.isEmpty(error)) {
                return;
            }
            C9832l.m61043I().m61070Z(true);
            C9832l.m61043I().m61076c0(error);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        public /* synthetic */ akxao(HwCounterTextLayout hwCounterTextLayout, bzrwd bzrwdVar) {
            this();
        }
    }

    public class bqmxo implements TextWatcher {
        private bqmxo() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            HwCounterTextLayout.this.m54632a(charSequence);
        }

        public /* synthetic */ bqmxo(HwCounterTextLayout hwCounterTextLayout, bzrwd bzrwdVar) {
            this();
        }
    }

    public class bzrwd extends TextView {
        public bzrwd(Context context) {
            super(context);
        }

        @Override // android.widget.TextView, android.view.View
        public void onVisibilityChanged(View view, int i10) {
            super.onVisibilityChanged(view, i10);
            if (HwCounterTextLayout.this.f42701c == HwShapeMode.BUBBLE || HwCounterTextLayout.this.f42701c == HwShapeMode.WHITE) {
                HwCounterTextLayout.this.m54634b();
            }
        }
    }

    public HwCounterTextLayout(Context context) {
        this(context, null);
    }

    public static HwCounterTextLayout instantiate(Context context) throws ClassNotFoundException {
        Object objInstantiate = HwWidgetInstantiator.instantiate(context, HwWidgetInstantiator.getDeviceClassName(context, HwCounterTextLayout.class, HwWidgetInstantiator.getCurrentType(context, 3, 1)), HwCounterTextLayout.class);
        if (objInstantiate instanceof HwCounterTextLayout) {
            return (HwCounterTextLayout) objInstantiate;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBackground(boolean z10) {
        HwShapeMode hwShapeMode = this.f42701c;
        if (hwShapeMode == HwShapeMode.BUBBLE) {
            this.f42699a.setBackgroundResource(z10 ? this.f42705g : this.f42707i);
            m54634b();
        } else if (hwShapeMode == HwShapeMode.LINEAR) {
            this.f42699a.setBackgroundResource(z10 ? this.f42711m : this.f42709k);
        } else if (hwShapeMode != HwShapeMode.WHITE) {
            this.f42699a.setBackgroundResource(z10 ? this.f42711m : this.f42710l);
        } else {
            this.f42699a.setBackgroundResource(z10 ? this.f42706h : this.f42708j);
            m54634b();
        }
    }

    private void setEditText(EditText editText) {
        if (this.f42699a != null) {
            return;
        }
        this.f42699a = editText;
        this.f42699a.setImeOptions(editText.getImeOptions() | 33554432);
        HwShapeMode hwShapeMode = this.f42701c;
        if (hwShapeMode == HwShapeMode.BUBBLE) {
            this.f42699a.setBackgroundResource(this.f42707i);
            return;
        }
        if (hwShapeMode == HwShapeMode.LINEAR) {
            this.f42699a.setBackgroundResource(this.f42709k);
        } else if (hwShapeMode == HwShapeMode.WHITE) {
            this.f42699a.setBackgroundResource(this.f42708j);
        } else {
            this.f42699a.setBackgroundResource(this.f42710l);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) throws Resources.NotFoundException {
        if (!(view instanceof EditText) || layoutParams == null) {
            super.addView(view, i10, layoutParams);
            return;
        }
        setEditText((EditText) view);
        ViewGroup.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(layoutParams);
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.addView(view, 0, layoutParams2);
        super.addView(frameLayout, 0, layoutParams2);
        m54628a();
    }

    public EditText getEditText() {
        return this.f42699a;
    }

    public CharSequence getError() {
        TextView textView = this.f42700b;
        if (textView != null) {
            return textView.getText();
        }
        return null;
    }

    public CharSequence getHint() {
        EditText editText = this.f42699a;
        if (editText == null) {
            return null;
        }
        return editText.getHint();
    }

    public int getMaxLength() {
        return this.f42704f;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        EditText editText = this.f42699a;
        if (editText == null) {
            return;
        }
        HwShapeMode hwShapeMode = this.f42701c;
        if ((hwShapeMode == HwShapeMode.BUBBLE || hwShapeMode == HwShapeMode.WHITE) && (editText.getParent() instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) this.f42699a.getParent();
            this.f42699a.layout(0, 0, viewGroup.getWidth(), viewGroup.getHeight());
        }
        if (this.f42713o == null) {
            bqmxo bqmxoVar = new bqmxo(this, null);
            this.f42713o = bqmxoVar;
            this.f42699a.addTextChangedListener(bqmxoVar);
            EditText editText2 = this.f42699a;
            editText2.setText(editText2.getText());
        }
    }

    public void setError(CharSequence charSequence) {
        if (this.f42699a == null || this.f42700b == null) {
            return;
        }
        boolean z10 = !TextUtils.isEmpty(charSequence);
        this.f42700b.setText(charSequence);
        this.f42700b.setVisibility(z10 ? 0 : 8);
        this.f42700b.animate().setInterpolator(new LinearInterpolator()).setDuration(50L).alpha(z10 ? 1.0f : 0.0f).start();
        HwShapeMode hwShapeMode = this.f42701c;
        if (hwShapeMode == HwShapeMode.BUBBLE || hwShapeMode == HwShapeMode.WHITE) {
            m54634b();
        }
        sendAccessibilityEvent(2048);
    }

    public void setHint(CharSequence charSequence) {
        EditText editText = this.f42699a;
        if (editText == null) {
            return;
        }
        editText.setHint(charSequence);
        sendAccessibilityEvent(2048);
    }

    public void setMaxLength(int i10) {
        this.f42704f = i10;
    }

    public HwCounterTextLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C8712R.attr.hwCounterTextStyle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m54634b() {
        ViewGroup.LayoutParams layoutParams = this.f42700b.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            int height = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            if (this.f42700b.getVisibility() == 0) {
                height += this.f42700b.getHeight() + getResources().getDimensionPixelSize(C8712R.dimen.hwedittext_dimens_text_margin_fifth);
            }
            EditText editText = this.f42699a;
            editText.setPaddingRelative(editText.getPaddingStart(), this.f42699a.getPaddingTop(), this.f42699a.getPaddingEnd(), height);
        }
    }

    public HwCounterTextLayout(Context context, AttributeSet attributeSet, int i10) {
        super(m54626a(context, i10), attributeSet, i10);
        m54629a(super.getContext(), attributeSet, i10);
    }

    /* renamed from: a */
    private static Context m54626a(Context context, int i10) {
        return HwWidgetCompat.wrapContext(context, i10, C8712R.style.Theme_Emui_HwEditText);
    }

    /* renamed from: a */
    private void m54629a(Context context, AttributeSet attributeSet, int i10) {
        int color;
        setOrientation(1);
        try {
            color = ContextCompat.getColor(context, C8712R.color.hwedittext_color_error);
        } catch (Resources.NotFoundException unused) {
            Log.d(f42694q, "initCounterTextErrorColor: resource error color not found");
            color = 0;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C8712R.styleable.HwCounterTextLayout, i10, C8712R.style.Widget_Emui_HwCounterTextLayout);
        this.f42702d = typedArrayObtainStyledAttributes.getResourceId(C8712R.styleable.HwCounterTextLayout_hwCounterTextAppearance, 0);
        this.f42703e = typedArrayObtainStyledAttributes.getColor(C8712R.styleable.HwCounterTextLayout_hwCounterTextErrorColor, color);
        this.f42701c = HwShapeMode.values()[typedArrayObtainStyledAttributes.getInt(C8712R.styleable.HwCounterTextLayout_hwShapeMode, 0)];
        this.f42709k = typedArrayObtainStyledAttributes.getResourceId(C8712R.styleable.HwCounterTextLayout_hwLinearEditBg, 0);
        this.f42710l = typedArrayObtainStyledAttributes.getResourceId(C8712R.styleable.HwCounterTextLayout_hwSpaceEditBg, 0);
        this.f42705g = typedArrayObtainStyledAttributes.getResourceId(C8712R.styleable.HwCounterTextLayout_hwErrorResBg, 0);
        this.f42706h = typedArrayObtainStyledAttributes.getResourceId(C8712R.styleable.HwCounterTextLayout_hwErrorResBgWhite, 0);
        this.f42707i = typedArrayObtainStyledAttributes.getResourceId(C8712R.styleable.HwCounterTextLayout_hwEditTextBg, 0);
        this.f42708j = typedArrayObtainStyledAttributes.getResourceId(C8712R.styleable.HwCounterTextLayout_hwEditTextBgWhite, 0);
        this.f42704f = typedArrayObtainStyledAttributes.getInteger(C8712R.styleable.HwCounterTextLayout_hwMaxLength, -1);
        this.f42711m = typedArrayObtainStyledAttributes.getResourceId(C8712R.styleable.HwCounterTextLayout_hwErrorLinearEditBg, 0);
        typedArrayObtainStyledAttributes.recycle();
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
        setAccessibilityDelegate(new akxao(this, null));
        Resources resources = getResources();
        setPaddingRelative(resources.getDimensionPixelSize(C8712R.dimen.hwedittext_dimens_max_start), 0, resources.getDimensionPixelSize(C8712R.dimen.hwedittext_dimens_max_end), 0);
    }

    /* renamed from: a */
    private void m54628a() throws Resources.NotFoundException {
        bzrwd bzrwdVar = new bzrwd(getContext());
        this.f42700b = bzrwdVar;
        C0669j.m4080n(bzrwdVar, this.f42702d);
        this.f42700b.setGravity(17);
        this.f42700b.setTextDirection(5);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        HwShapeMode hwShapeMode = this.f42701c;
        if (hwShapeMode != HwShapeMode.BUBBLE && hwShapeMode != HwShapeMode.WHITE) {
            layoutParams.gravity = 8388693;
            this.f42700b.setPaddingRelative(0, getResources().getDimensionPixelSize(C8712R.dimen.hwedittext_dimens_text_margin_fifth), 0, 0);
            addView(this.f42700b, layoutParams);
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        layoutParams2.gravity = 8388693;
        layoutParams2.setMarginEnd(this.f42699a.getPaddingEnd());
        layoutParams2.bottomMargin = this.f42699a.getPaddingBottom();
        ViewParent parent = this.f42699a.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).addView(this.f42700b, layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m54632a(CharSequence charSequence) {
        bzrwd bzrwdVar = null;
        if (this.f42704f == -1) {
            setError(null);
            return;
        }
        if (charSequence instanceof Editable) {
            Editable editable = (Editable) charSequence;
            int length = editable.length();
            int i10 = this.f42704f;
            if (length <= i10) {
                if (length >= i10 * 0.9f) {
                    setError(getResources().getString(C8712R.string.hwedittext_count_msg, Integer.valueOf(length), Integer.valueOf(this.f42704f)));
                    return;
                } else {
                    setError(null);
                    return;
                }
            }
            int selectionEnd = this.f42699a.getSelectionEnd();
            editable.delete(this.f42704f, editable.length());
            EditText editText = this.f42699a;
            int i11 = this.f42704f;
            if (selectionEnd > i11) {
                selectionEnd = i11;
            }
            editText.setSelection(selectionEnd);
            if (this.f42712n == null) {
                this.f42712n = AnimationUtils.loadAnimation(getContext(), C8712R.anim.hwedittext_shake);
                aauaf aauafVar = new aauaf(this, bzrwdVar);
                this.f42714p = aauafVar;
                Animation animation = this.f42712n;
                if (animation != null) {
                    animation.setAnimationListener(aauafVar);
                }
            }
            this.f42714p.f42715a = true;
            this.f42699a.startAnimation(this.f42712n);
        }
    }
}
