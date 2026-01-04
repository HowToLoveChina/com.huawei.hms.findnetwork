package com.huawei.openalliance.p169ad.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.huawei.hms.ads.uiengine.common.IProgressButton;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.download.app.AppStatus;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;

/* renamed from: com.huawei.openalliance.ad.views.a */
/* loaded from: classes2.dex */
public abstract class AbstractViewOnClickListenerC8065a extends AbstractC8151u implements View.OnClickListener, IProgressButton, IProgressButton.ProgressButtonResetListener {

    /* renamed from: a */
    protected final String f37452a;

    /* renamed from: b */
    protected AppDownloadButtonStyle f37453b;

    /* renamed from: c */
    protected boolean f37454c;

    /* renamed from: d */
    private IProgressButton f37455d;

    /* renamed from: e */
    private ImageView f37456e;

    /* renamed from: f */
    private RelativeLayout.LayoutParams f37457f;

    /* renamed from: g */
    private int f37458g;

    /* renamed from: h */
    private boolean f37459h;

    /* renamed from: i */
    private boolean f37460i;

    /* renamed from: j */
    private int f37461j;

    /* renamed from: k */
    private int f37462k;

    /* renamed from: l */
    private int f37463l;

    /* renamed from: m */
    private int f37464m;

    /* renamed from: n */
    private boolean f37465n;

    /* renamed from: o */
    private boolean f37466o;

    /* renamed from: com.huawei.openalliance.ad.views.a$1 */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC7185ho.m43817a(AbstractViewOnClickListenerC8065a.this.f37452a, "post run");
            AbstractViewOnClickListenerC8065a abstractViewOnClickListenerC8065a = AbstractViewOnClickListenerC8065a.this;
            abstractViewOnClickListenerC8065a.m49957a(abstractViewOnClickListenerC8065a.getMeasuredHeight());
        }
    }

    public AbstractViewOnClickListenerC8065a(Context context) throws Resources.NotFoundException {
        super(context);
        this.f37452a = "AppDownBtn_" + hashCode();
        this.f37459h = false;
        this.f37460i = true;
        this.f37465n = false;
        this.f37466o = false;
        m49959a(context, null, false, null, null);
    }

    /* renamed from: a */
    private void m49956a() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = this.f37464m;
            layoutParams.width = this.f37463l;
            setLayoutParams(layoutParams);
        }
        if (this.f37465n) {
            m49957a(this.f37464m);
        }
    }

    /* renamed from: b */
    private void m49962b(int i10) {
        if (this.f37460i || this.f37463l <= 0) {
            int i11 = this.f37461j;
            if ((i11 <= 0 || i10 <= i11) && ((i11 = this.f37462k) <= 0 || i10 >= i11)) {
                this.f37463l = i10;
            } else {
                this.f37463l = i11;
            }
        }
    }

    private Drawable getCancelBtnDrawable() {
        AppDownloadButtonStyle appDownloadButtonStyle = this.f37453b;
        return appDownloadButtonStyle == null ? getContext().getResources().getDrawable(C6849R.drawable.hiad_app_down_cancel_btn) : appDownloadButtonStyle.cancelBtnDrawable;
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public int getProgress() {
        return this.f37455d.getProgress();
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public Drawable getProgressDrawable() {
        return this.f37455d.getProgressDrawable();
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public Rect getPromptRect() {
        return this.f37455d.getPromptRect();
    }

    public abstract AppStatus getStatus();

    @Override // com.huawei.openalliance.p169ad.views.AbstractC8151u
    public String getTAG() {
        return this.f37452a;
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public CharSequence getText() {
        return this.f37455d.getText();
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public void incrementProgressBy(int i10) {
        this.f37455d.incrementProgressBy(i10);
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public boolean isFastClick() {
        return this.f37455d.isFastClick();
    }

    public void onClick(View view) {
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int i12;
        IProgressButton iProgressButton = this.f37455d;
        if (iProgressButton != null && this.f37459h) {
            ViewGroup.LayoutParams layoutParams = iProgressButton.getProgressBtn().getLayoutParams();
            layoutParams.height = View.MeasureSpec.getSize(i11);
            layoutParams.width = View.MeasureSpec.getSize(i10);
            int i13 = this.f37464m;
            if (i13 > 0) {
                layoutParams.height = i13;
            }
            if (this.f37460i && (i12 = this.f37463l) > 0) {
                layoutParams.width = i12;
            }
            int i14 = this.f37461j;
            if (i14 > 0 && layoutParams.width > i14) {
                layoutParams.width = i14;
            }
            int i15 = this.f37462k;
            if (i15 > 0 && layoutParams.width < i15) {
                layoutParams.width = i15;
            }
            if (layoutParams.width > 0 && layoutParams.height > 0) {
                this.f37455d.getProgressBtn().setLayoutParams(layoutParams);
            }
        }
        super.onMeasure(i10, i11);
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton.ProgressButtonResetListener
    public void onSizeReset(int i10, int i11) {
        AbstractC7185ho.m43818a(this.f37452a, "on size reset: %s, %s", Integer.valueOf(i10), Integer.valueOf(i11));
        if (i10 <= 0 || i11 <= 0) {
            return;
        }
        if (this.f37466o) {
            this.f37463l = i10;
            this.f37466o = false;
        } else {
            m49962b(i10);
        }
        this.f37464m = i11;
        m49956a();
    }

    public void setCancelBtnClickListener(View.OnClickListener onClickListener) {
        this.f37456e.setOnClickListener(onClickListener);
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public void setFixedWidth(boolean z10) {
        this.f37455d.setFixedWidth(z10);
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public void setFontFamily(String str) {
        this.f37455d.setFontFamily(str);
    }

    public void setLayoutParamsSkipSizeReset(ViewGroup.LayoutParams layoutParams) {
        this.f37466o = true;
        setLayoutParams(layoutParams);
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public void setMax(int i10) {
        this.f37455d.setMax(i10);
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public void setMaxWidth(int i10) {
        this.f37461j = i10;
        this.f37455d.setMaxWidth(i10);
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public void setMinWidth(int i10) {
        this.f37462k = i10;
        this.f37455d.setMinWidth(i10);
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public void setPaintTypeface(Typeface typeface) {
        this.f37455d.setPaintTypeface(typeface);
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public void setProgress(int i10) {
        this.f37455d.setProgress(i10);
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public void setProgressDrawable(Drawable drawable) {
        this.f37455d.setProgressDrawable(drawable);
    }

    public void setResetWidth(boolean z10) {
        this.f37460i = z10;
        this.f37455d.setResetWidth(z10);
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public void setText(CharSequence charSequence) {
        this.f37455d.setTextInner(charSequence, this.f37465n);
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public void setTextColor(int i10) {
        this.f37455d.setTextColor(i10);
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public void setTextSize(float f10) {
        this.f37455d.setTextSize(f10);
    }

    public void setVisibilityInner(int i10) {
        this.f37455d.getProgressBtn().setVisibility(i10);
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    @OuterVisible
    public void updateLayoutHeight() {
        this.f37455d.updateLayoutHeight();
    }

    public AbstractViewOnClickListenerC8065a(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        super(context, attributeSet);
        this.f37452a = "AppDownBtn_" + hashCode();
        this.f37459h = false;
        this.f37460i = true;
        this.f37465n = false;
        this.f37466o = false;
        m49959a(context, attributeSet, false, null, null);
    }

    /* renamed from: a */
    public void m49957a(int i10) {
        this.f37458g = i10 < AbstractC7741ao.m47535a(getContext(), 40.0f) ? AbstractC7741ao.m47535a(getContext(), 12.0f) : AbstractC7741ao.m47535a(getContext(), 16.0f);
        int cancelBtnHeight = this.f37455d.getCancelBtnHeight(i10);
        AbstractC7185ho.m43818a(this.f37452a, "btnHeight: %s, cancelBtnSize: %s, realBtnHeight: %s", Integer.valueOf(i10), Integer.valueOf(this.f37458g), Integer.valueOf(cancelBtnHeight));
        RelativeLayout.LayoutParams layoutParams = this.f37457f;
        layoutParams.height = cancelBtnHeight;
        layoutParams.width = cancelBtnHeight;
        int i11 = 0;
        layoutParams.setMarginEnd(0);
        int i12 = this.f37458g;
        int i13 = (cancelBtnHeight - i12) / 2;
        if (i13 <= 0) {
            RelativeLayout.LayoutParams layoutParams2 = this.f37457f;
            layoutParams2.height = i12;
            layoutParams2.width = i12;
            layoutParams2.setMarginEnd(AbstractC7741ao.m47535a(getContext(), 12.0f));
        } else {
            i11 = i13;
        }
        this.f37456e.setPaddingRelative(i11, i11, i11, i11);
        if (this.f37454c) {
            this.f37455d.setCancelBtnHeight(this.f37458g);
            this.f37456e.setBackground(this.f37453b.m48718b().getBackground());
        }
        try {
            if (this.f37456e.getParent() != this) {
                addView(this.f37456e, this.f37457f);
            }
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c(this.f37452a, "add cancel btn ex: %s", th2.getClass().getSimpleName());
        }
    }

    /* renamed from: b */
    public void m49967b(int i10, int i11, int i12, int i13) {
        this.f37455d.getProgressBtn().setPaddingRelative(i10, i11, i12, i13);
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public void setPaintTypeface(Typeface typeface, int i10) {
        this.f37455d.setPaintTypeface(typeface, i10);
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public void setProgressDrawable(Drawable drawable, int i10) {
        this.f37455d.setProgressDrawable(drawable, i10);
    }

    public AbstractViewOnClickListenerC8065a(Context context, AttributeSet attributeSet, int i10) throws Resources.NotFoundException {
        super(context, attributeSet, i10);
        this.f37452a = "AppDownBtn_" + hashCode();
        this.f37459h = false;
        this.f37460i = true;
        this.f37465n = false;
        this.f37466o = false;
        m49959a(context, attributeSet, false, null, null);
    }

    /* renamed from: b */
    private static boolean m49963b(AppStatus appStatus) {
        return AppStatus.PAUSE == appStatus || AppStatus.WAITING_FOR_WIFI == appStatus;
    }

    /* renamed from: a */
    public void m49964a(int i10, int i11, int i12, int i13) {
        this.f37455d.getProgressBtn().setPadding(i10, i11, i12, i13);
    }

    @SuppressLint({"NewApi"})
    public AbstractViewOnClickListenerC8065a(Context context, AttributeSet attributeSet, int i10, int i11) throws Resources.NotFoundException {
        super(context, attributeSet, i10, i11);
        this.f37452a = "AppDownBtn_" + hashCode();
        this.f37459h = false;
        this.f37460i = true;
        this.f37465n = false;
        this.f37466o = false;
        m49959a(context, attributeSet, false, null, null);
    }

    /* renamed from: a */
    private void m49958a(Context context, AttributeSet attributeSet) {
        if (context == null || attributeSet == null) {
            return;
        }
        this.f37459h = true;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C6849R.styleable.hiad_progress_button);
        try {
            this.f37460i = typedArrayObtainStyledAttributes.getBoolean(C6849R.styleable.hiad_progress_button_hiad_resetWidth, true);
            this.f37461j = typedArrayObtainStyledAttributes.getDimensionPixelSize(C6849R.styleable.hiad_progress_button_hiad_maxWidth, 0);
            this.f37462k = typedArrayObtainStyledAttributes.getDimensionPixelSize(C6849R.styleable.hiad_progress_button_hiad_minWidth, 0);
        } finally {
            try {
            } finally {
            }
        }
    }

    public AbstractViewOnClickListenerC8065a(Context context, Boolean bool) throws Resources.NotFoundException {
        super(context);
        this.f37452a = "AppDownBtn_" + hashCode();
        this.f37459h = false;
        this.f37460i = true;
        this.f37465n = false;
        this.f37466o = false;
        m49959a(context, null, (bool == null ? Boolean.TRUE : bool).booleanValue(), null, null);
    }

    /* renamed from: a */
    private void m49959a(Context context, AttributeSet attributeSet, boolean z10, IProgressButton iProgressButton, ImageView imageView) throws Resources.NotFoundException {
        m49958a(context, attributeSet);
        AbstractC7185ho.m43818a(this.f37452a, "init, create with attrs: %s", Boolean.valueOf(this.f37459h));
        if (iProgressButton == null || iProgressButton.getProgressBtn() == null) {
            iProgressButton = z10 ? new C8068ac(context, attributeSet) : new ProgressButton(context, attributeSet);
        } else {
            AbstractC7185ho.m43817a(this.f37452a, "init btn for uiengine");
        }
        this.f37455d = iProgressButton;
        AbstractC7185ho.m43821b(this.f37452a, "progressBtn: %s", Integer.valueOf(this.f37455d.hashCode()));
        this.f37455d.getProgressBtn().setId(C6849R.id.haid_down_btn_progress);
        setOnClickListener(this);
        this.f37455d.setResetListener(this);
        this.f37455d.getProgressBtn().setOnClickListener(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        addView(this.f37455d.getProgressBtn(), layoutParams);
        this.f37454c = z10;
        m49960a(context, imageView);
    }

    public AbstractViewOnClickListenerC8065a(Context context, Boolean bool, IProgressButton iProgressButton) throws Resources.NotFoundException {
        super(context);
        this.f37452a = "AppDownBtn_" + hashCode();
        this.f37459h = false;
        this.f37460i = true;
        this.f37465n = false;
        this.f37466o = false;
        m49959a(context, null, (bool == null ? Boolean.TRUE : bool).booleanValue(), iProgressButton, null);
    }

    /* renamed from: a */
    private void m49960a(Context context, ImageView imageView) throws Resources.NotFoundException {
        if (context == null) {
            return;
        }
        if (imageView != null) {
            AbstractC7185ho.m43817a(this.f37452a, "init cancelBtn for uiengine");
        } else {
            imageView = new ImageView(context);
        }
        this.f37456e = imageView;
        this.f37458g = AbstractC7741ao.m47535a(context, 16.0f);
        if (this.f37456e.getDrawable() == null) {
            this.f37456e.setImageDrawable(context.getResources().getDrawable(C6849R.drawable.hiad_app_down_cancel_btn));
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        this.f37457f = layoutParams;
        layoutParams.addRule(19, this.f37455d.getProgressBtn().getId());
        this.f37457f.addRule(15);
    }

    public AbstractViewOnClickListenerC8065a(Context context, Boolean bool, IProgressButton iProgressButton, ImageView imageView) throws Resources.NotFoundException {
        super(context);
        this.f37452a = "AppDownBtn_" + hashCode();
        this.f37459h = false;
        this.f37460i = true;
        this.f37465n = false;
        this.f37466o = false;
        m49959a(context, null, (bool == null ? Boolean.TRUE : bool).booleanValue(), iProgressButton, imageView);
    }

    /* renamed from: a */
    public void m49965a(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
        this.f37455d.getProgressBtn().setOnClickListener(onClickListener);
    }

    /* renamed from: a */
    public void m49966a(AppStatus appStatus) {
        if (appStatus == null) {
            return;
        }
        this.f37465n = m49963b(appStatus);
        AbstractC7185ho.m43818a(this.f37452a, "configCancelBtn, status: %s", appStatus);
        if (this.f37465n) {
            this.f37456e.setImageDrawable(getCancelBtnDrawable());
            this.f37455d.setShowCancelBtn(this.f37465n);
            int measuredHeight = getMeasuredHeight();
            if (measuredHeight <= 0) {
                post(new Runnable() { // from class: com.huawei.openalliance.ad.views.a.1
                    public AnonymousClass1() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        AbstractC7185ho.m43817a(AbstractViewOnClickListenerC8065a.this.f37452a, "post run");
                        AbstractViewOnClickListenerC8065a abstractViewOnClickListenerC8065a = AbstractViewOnClickListenerC8065a.this;
                        abstractViewOnClickListenerC8065a.m49957a(abstractViewOnClickListenerC8065a.getMeasuredHeight());
                    }
                });
                return;
            } else {
                m49957a(measuredHeight);
                return;
            }
        }
        try {
            if (this.f37456e.getParent() == this) {
                this.f37455d.setShowCancelBtn(this.f37465n);
                removeView(this.f37456e);
            }
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c(this.f37452a, "remove cancel btn ex: %s", th2.getClass().getSimpleName());
        }
    }
}
