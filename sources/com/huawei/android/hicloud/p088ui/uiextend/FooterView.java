package com.huawei.android.hicloud.p088ui.uiextend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.android.hicloud.p088ui.uilistener.IFootViewListener;
import com.huawei.android.p073ds.R$dimen;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import sk.C12809f;

/* loaded from: classes3.dex */
public class FooterView extends LinearLayout {
    public static final int STATE_HIDE = 3;
    public static final int STATE_LOADING = 2;
    public static final int STATE_NORMAL = 0;
    private IFootViewListener iFootViewListener;
    public boolean isLoadingFailed;
    private int mBlankHeight;
    private View mBlankView;
    private View mFooter;
    private int mHeight;
    private View mLoadingBar;
    private View mLoadingLayout;
    private int mMinHeight;
    private TextView mPromptView;
    private int mState;

    public FooterView(Context context) {
        super(context);
        this.mFooter = null;
        this.mLoadingLayout = null;
        this.mPromptView = null;
        this.mLoadingBar = null;
        this.mBlankView = null;
        this.mState = 0;
        this.isLoadingFailed = false;
        initFooterView(context);
    }

    private void initFooterView(Context context) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 16;
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.applistitem_footer, (ViewGroup) null);
        this.mFooter = viewInflate;
        this.mLoadingLayout = C12809f.m76831d(viewInflate, R$id.loading_layout);
        this.mPromptView = (TextView) C12809f.m76831d(this.mFooter, R$id.prompt);
        this.mBlankView = C12809f.m76831d(this.mFooter, R$id.blank_view);
        this.mLoadingBar = C12809f.m76831d(this.mFooter, R$id.loadingBar);
        this.mMinHeight = context.getResources().getDimensionPixelSize(R$dimen.applist_footer_view_min_height);
        this.mHeight = context.getResources().getDimensionPixelSize(R$dimen.applist_footer_view_height);
        this.mBlankHeight = context.getResources().getDimensionPixelSize(R$dimen.applist_footer_blank_view_height);
        addView(this.mFooter, layoutParams);
        hide();
    }

    public void changeFooterState(int i10) {
        if (this.mState == i10) {
            return;
        }
        this.mPromptView.setText(getResources().getString(R$string.cloudbackup_loading));
        this.mPromptView.setClickable(false);
        this.mLoadingBar.setVisibility(0);
        this.isLoadingFailed = false;
        this.mState = i10;
    }

    public int getCurrentState() {
        return this.mState;
    }

    public View getmLoadingLayout() {
        return this.mLoadingLayout;
    }

    public void hide() {
        setFooterHeight(this.mMinHeight);
        this.mLoadingLayout.setVisibility(8);
        hideBlanView();
        this.mState = 3;
        IFootViewListener iFootViewListener = this.iFootViewListener;
        if (iFootViewListener != null) {
            iFootViewListener.m25629a();
        }
    }

    public void hideBlanView() {
        int i10 = this.mMinHeight;
        if (this.mLoadingLayout.getVisibility() == 0) {
            i10 += this.mHeight;
        }
        setFooterHeight(i10);
        this.mBlankView.setVisibility(8);
    }

    public void loadingFailed(String str, View.OnClickListener onClickListener) {
        if (this.mFooter != null) {
            this.isLoadingFailed = true;
            this.mPromptView.setText(str);
            this.mPromptView.setClickable(true);
            this.mLoadingBar.setVisibility(8);
            if (onClickListener != null) {
                this.mPromptView.setOnClickListener(onClickListener);
            }
        }
    }

    public void reset() {
        changeFooterState(0);
    }

    public void setFootViewListener(IFootViewListener iFootViewListener) {
        this.iFootViewListener = iFootViewListener;
    }

    public void setFooterHeight(int i10) {
        if (i10 <= 0) {
            i10 = 0;
        }
        ViewGroup.LayoutParams layoutParams = this.mFooter.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            if (layoutParams2.height != i10) {
                layoutParams2.height = i10;
                this.mFooter.setLayoutParams(layoutParams2);
                postDelayed(new Runnable() { // from class: com.huawei.android.hicloud.ui.uiextend.FooterView.1
                    @Override // java.lang.Runnable
                    public void run() {
                        FooterView.this.requestLayout();
                    }
                }, 10L);
            }
        }
    }

    public void setmLoadingLayout(View view) {
        this.mLoadingLayout = view;
    }

    public void show() {
        int i10 = this.mHeight;
        if (this.mBlankView.getVisibility() == 0) {
            i10 += this.mBlankHeight;
        }
        setFooterHeight(i10);
        this.mLoadingLayout.setVisibility(0);
        hideBlanView();
        if (this.mState == 3) {
            this.mState = 0;
        }
        IFootViewListener iFootViewListener = this.iFootViewListener;
        if (iFootViewListener != null) {
            iFootViewListener.m25630b();
        }
    }

    public void showBlanView() {
        int i10 = this.mBlankHeight;
        if (this.mLoadingLayout.getVisibility() == 0) {
            i10 += this.mHeight;
        }
        setFooterHeight(i10);
        this.mBlankView.setVisibility(0);
    }

    public FooterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mFooter = null;
        this.mLoadingLayout = null;
        this.mPromptView = null;
        this.mLoadingBar = null;
        this.mBlankView = null;
        this.mState = 0;
        this.isLoadingFailed = false;
        initFooterView(context);
    }
}
