package com.huawei.android.hicloud.p088ui.uiextend;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowInsets;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.huawei.android.hicloud.p088ui.extend.HiCloudListTipsLayout;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$styleable;
import p015ak.C0209d;
import p514o9.C11842p;
import sk.C12806c;
import sk.C12808e;
import sk.C12809f;
import sk.InterfaceC12805b;

/* loaded from: classes3.dex */
public class StorageManagerItemLayout extends LinearLayout implements InterfaceC12805b {
    private static final String DIVIDER_GONE = "none";
    private static final String DIVIDER_SHOW = "show";
    private static final String TAG = "StorageManagerItemLayout";
    protected ImageView mArrow;
    private Context mContext;
    protected String mDividerShow;
    protected LinearLayout mDividerView;
    protected ImageView mIconView;
    protected Drawable mImg;
    protected ProgressBar mLoadingView;
    protected String mNumber;
    protected HiCloudListTipsLayout mNumberView;
    protected String mSize;
    protected TextView mSizeView;
    protected String mTitle;
    protected TextView mTitleView;
    protected View mUnresolvedSign;

    public StorageManagerItemLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDividerShow = "show";
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.storage_manager_item_layout);
        this.mContext = context;
        initView(context);
        initData(typedArrayObtainStyledAttributes);
    }

    private void initData(TypedArray typedArray) {
        if (typedArray != null) {
            this.mImg = typedArray.getDrawable(R$styleable.storage_manager_item_layout_img);
            this.mTitle = typedArray.getString(R$styleable.storage_manager_item_layout_title);
            this.mNumber = typedArray.getString(R$styleable.storage_manager_item_layout_num);
            this.mSize = typedArray.getString(R$styleable.storage_manager_item_layout_size);
            this.mDividerShow = typedArray.getString(R$styleable.storage_manager_item_layout_manage_divider);
            this.mIconView.setImageDrawable(this.mImg);
            this.mTitleView.setText(this.mTitle);
            this.mNumberView.setText(this.mNumber);
            this.mSizeView.setText(this.mSize);
            String str = this.mDividerShow;
            if (str == null || !str.equals("none")) {
                this.mDividerView.setVisibility(0);
            } else {
                this.mDividerView.setVisibility(8);
            }
            typedArray.recycle();
        }
    }

    private void initView(Context context) {
        if (context == null) {
            return;
        }
        if (C0209d.m1195O(context) >= 1.75f) {
            View.inflate(context, R$layout.storage_manage_item_font_scale, this);
        } else {
            View.inflate(context, R$layout.storage_manage_item, this);
        }
        this.mIconView = (ImageView) C12809f.m76831d(this, R$id.manage_item_icon);
        this.mTitleView = (TextView) C12809f.m76831d(this, R$id.manage_item_name);
        this.mNumberView = (HiCloudListTipsLayout) C12809f.m76831d(this, R$id.manage_tips_layout);
        titleViewSetMaxWidth(context);
        this.mSizeView = (TextView) C12809f.m76831d(this, R$id.manage_size);
        this.mDividerView = (LinearLayout) C12809f.m76831d(this, R$id.manage_divider);
        this.mLoadingView = (ProgressBar) C12809f.m76831d(this, R$id.manage_value_loading_progress);
        this.mArrow = (ImageView) C12809f.m76831d(this, R$id.manage_right_arrow);
        this.mUnresolvedSign = C12809f.m76831d(this, R$id.manage_item_unresolved);
    }

    private void titleViewSetMaxWidth(Context context) {
        if ((context instanceof Activity) && C11842p.m70771U0() && C11842p.m70774V0((Activity) context)) {
            this.mTitleView.setMaxWidth(C11842p.m70861s0());
            if (C0209d.m1195O(context) < 1.75f) {
                this.mNumberView.m23998e(C11842p.m70861s0());
                return;
            }
            return;
        }
        if (C0209d.m1195O(context) < 1.75f) {
            this.mNumberView.m23998e(C11842p.m70817h0());
            this.mTitleView.setMaxWidth(C11842p.m70817h0());
        }
    }

    public void disable() {
        this.mTitleView.setAlpha(0.62f);
        this.mNumberView.setAlpha(0.62f);
        this.mSizeView.setAlpha(0.62f);
        this.mArrow.setAlpha(0.62f);
        this.mIconView.setAlpha(0.62f);
        setEnabled(false);
    }

    public void enable() {
        this.mTitleView.setAlpha(1.0f);
        this.mNumberView.setAlpha(1.0f);
        this.mSizeView.setAlpha(1.0f);
        this.mArrow.setAlpha(1.0f);
        this.mIconView.setAlpha(1.0f);
        setEnabled(true);
    }

    public void hideArrow() {
        ImageView imageView = this.mArrow;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    public void hideDivider() {
        this.mDividerView.setVisibility(8);
    }

    public void hideLoading() {
        this.mLoadingView.setVisibility(8);
        this.mArrow.setVisibility(0);
        this.mSizeView.setVisibility(0);
    }

    @Override // sk.InterfaceC12805b
    public void onRotation180(WindowInsets windowInsets) {
        setPadding(C12808e.m76823b(), 0, C12808e.m76823b(), 0);
    }

    @Override // sk.InterfaceC12805b
    public void onRotation270(WindowInsets windowInsets) {
        Context context = this.mContext;
        setPadding(0, 0, (context == null || !C12806c.m76818i(context)) ? 0 : C11842p.m70789a0(this.mContext), 0);
    }

    @Override // sk.InterfaceC12805b
    public void onRotation90(WindowInsets windowInsets) {
        Context context = this.mContext;
        setPadding(context != null ? C11842p.m70789a0(context) : 0, 0, 0, 0);
    }

    @Override // sk.InterfaceC12805b
    public void onRotationPortrait(WindowInsets windowInsets) {
        setPadding(C12808e.m76823b(), 0, C12808e.m76823b(), 0);
    }

    public void setImage(Drawable drawable) {
        this.mIconView.setImageDrawable(drawable);
    }

    public void setNoNumber() {
        this.mNumberView.m23995b();
    }

    public void setNumber(String str) {
        this.mNumberView.setText(str);
    }

    public void setSize(String str) {
        this.mSizeView.setText(str);
    }

    public void setTipsLayoutMaxWidth() {
        Context context = this.mContext;
        if (context == null || this.mTitleView == null || this.mNumberView == null) {
            return;
        }
        titleViewSetMaxWidth(context);
    }

    public void setTitle(String str) {
        this.mTitleView.setText(str);
    }

    public void showArrow() {
        ImageView imageView = this.mArrow;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    public void showDivider() {
        String str = this.mDividerShow;
        if (str != null && str.equals("none")) {
            this.mDividerView.setVisibility(8);
        }
        this.mDividerView.setVisibility(0);
    }

    public void showLoading() {
        this.mLoadingView.setVisibility(0);
        this.mArrow.setVisibility(8);
        this.mSizeView.setVisibility(8);
    }

    public void showUnResolveView(boolean z10) {
        this.mUnresolvedSign.setVisibility(z10 ? 0 : 8);
    }
}
