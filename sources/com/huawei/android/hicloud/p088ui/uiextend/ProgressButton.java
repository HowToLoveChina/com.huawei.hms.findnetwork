package com.huawei.android.hicloud.p088ui.uiextend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.uikit.hwtextview.widget.HwTextView;
import com.huawei.uikit.phone.hwprogressbar.widget.HwProgressBar;
import p514o9.C11842p;
import sk.C12809f;

/* loaded from: classes3.dex */
public class ProgressButton extends FrameLayout {
    private Context context;
    private FrameLayout flRoot;
    private HwProgressBar loading;
    private HwProgressBar progressBar;
    private HwTextView textView;

    public ProgressButton(Context context) {
        super(context, null);
        this.context = context;
        initView();
    }

    private void initView() {
        View viewInflate = View.inflate(this.context, R$layout.backup_progress_button, this);
        this.flRoot = (FrameLayout) C12809f.m76831d(viewInflate, R$id.fl_root);
        this.progressBar = (HwProgressBar) C12809f.m76831d(viewInflate, R$id.backup_progress);
        this.textView = (HwTextView) C12809f.m76831d(viewInflate, R$id.backup_textview);
        this.loading = (HwProgressBar) C12809f.m76831d(viewInflate, R$id.click_loading);
        this.textView.setTextColor(this.context.getColor(R$color.progress_text_color));
        if (C11842p.m70732H0(this.context)) {
            this.progressBar.setFlickerEnable(false);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.huawei.android.hicloud.ui.uiextend.ProgressButton.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    ProgressButton.this.setLayoutHeight();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLayoutHeight() {
        C11842p.m70727F1(this.progressBar, this.flRoot.getMeasuredHeight());
    }

    public void setFlickerEnable(boolean z10) {
        HwProgressBar hwProgressBar = this.progressBar;
        if (hwProgressBar != null) {
            hwProgressBar.setFlickerEnable(z10);
        }
    }

    public void setLoadingVisibility(int i10) {
        HwProgressBar hwProgressBar = this.loading;
        if (hwProgressBar != null) {
            hwProgressBar.setVisibility(i10);
        }
    }

    public void setProgress(int i10, boolean z10) {
        HwProgressBar hwProgressBar = this.progressBar;
        if (hwProgressBar == null || this.textView == null) {
            return;
        }
        hwProgressBar.setProgress(i10, z10);
    }

    public void setText(String str) {
        if (this.progressBar != null) {
            this.textView.setText(str);
        }
    }

    public ProgressButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.context = context;
        initView();
    }

    public ProgressButton(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10, 0);
        this.context = context;
        initView();
    }
}
