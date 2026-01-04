package com.huawei.android.hicloud.p088ui.uiextend;

import ae.C0128g2;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.hicloud.p088ui.uiadapter.NoScrollLinearLayoutManager;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$styleable;
import huawei.android.widget.HwTextView;
import java.util.List;
import p015ak.C0209d;
import p514o9.C11842p;
import sk.C12809f;

/* loaded from: classes3.dex */
public class StorageManagerCardViewLayout extends LinearLayout {
    private static final String DIVIDER_SHOW = "show";
    private static final String TAG = "StorageManagerCardViewLayout";
    protected ImageView mArrow;
    private Context mContext;
    private CurrentOnTouchListener mCurrentOnTouchListener;
    protected String mDividerShow;
    protected LinearLayout mDividerView;
    protected RecyclerView mIconList;
    private C0128g2 mIconListAdapter;
    protected RelativeLayout mIconListFrame;
    protected ImageView mIconView;
    protected Drawable mImg;
    private boolean mIsDefaultLayout;
    private boolean mIsFamilyShareItem;
    protected TextView mItemNumberView;
    protected ProgressBar mLoadingView;
    protected LinearLayout mMainLayout;
    protected int mMinHeight;
    protected RelativeLayout mNumberFrameView;
    protected String mSize;
    protected TextView mSizeView;
    protected String mTitle;
    protected TextView mTitleView;
    protected HwTextView numView;

    public StorageManagerCardViewLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDividerShow = "show";
        this.mIsFamilyShareItem = false;
        this.mIsDefaultLayout = true;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.storage_manager_cardview_layout);
        isFamilyShareItem(typedArrayObtainStyledAttributes);
        this.mContext = context;
        initView(context);
        initData(typedArrayObtainStyledAttributes);
        initRecycleview();
    }

    private void initData(TypedArray typedArray) {
        if (typedArray != null) {
            this.mTitle = typedArray.getString(R$styleable.storage_manager_cardview_layout_cardview_title);
            this.mImg = typedArray.getDrawable(R$styleable.storage_manager_cardview_layout_cardview_img);
            this.mDividerShow = typedArray.getString(R$styleable.storage_manager_cardview_layout_cardview_manage_divider);
            this.mSize = typedArray.getString(R$styleable.storage_manager_cardview_layout_cardview_size);
            this.mMinHeight = typedArray.getDimensionPixelSize(R$styleable.storage_manager_cardview_layout_cardview_min_height, -2);
            this.mIsDefaultLayout = typedArray.getBoolean(R$styleable.storage_manager_cardview_layout_cardview_bg_default, true);
            this.mMainLayout.setMinimumHeight(this.mMinHeight);
            this.mIconView.setImageDrawable(this.mImg);
            this.mTitleView.setText(this.mTitle);
            this.mSizeView.setText(this.mSize);
            String str = this.mDividerShow;
            if (str == null || !str.equals("show")) {
                this.mDividerView.setVisibility(8);
            } else {
                this.mDividerView.setVisibility(0);
            }
            typedArray.recycle();
        }
    }

    private void initRecycleview() {
        this.mIconList.setLayoutManager(new NoScrollLinearLayoutManager(this.mContext, 0, false));
        C0128g2 c0128g2 = new C0128g2(this.mContext, this.mIsDefaultLayout, false);
        this.mIconListAdapter = c0128g2;
        this.mIconList.setAdapter(c0128g2);
        this.mIconList.setFocusable(false);
    }

    private void initView(Context context) {
        if (context == null) {
            return;
        }
        float fM1195O = C0209d.m1195O(context);
        if ((!this.mIsFamilyShareItem || fM1195O < 1.75f) && fM1195O < 3.2f) {
            View.inflate(context, R$layout.storage_manage_cardview_item, this);
        } else {
            View.inflate(context, R$layout.storage_manage_cardview_item_font_scale, this);
        }
        this.mMainLayout = (LinearLayout) C12809f.m76831d(this, R$id.main_layout);
        this.mIconView = (ImageView) C12809f.m76831d(this, R$id.manage_item_icon);
        this.mTitleView = (TextView) C12809f.m76831d(this, R$id.manage_item_name);
        this.mNumberFrameView = (RelativeLayout) C12809f.m76831d(this, R$id.item_number_frame);
        this.mItemNumberView = (TextView) C12809f.m76831d(this, R$id.item_number);
        this.mIconList = (RecyclerView) C12809f.m76831d(this, R$id.icon_list);
        titleViewSetMaxWidth(context);
        this.mSizeView = (TextView) C12809f.m76831d(this, R$id.manage_size);
        this.mDividerView = (LinearLayout) C12809f.m76831d(this, R$id.manage_divider_match_parent);
        this.mLoadingView = (ProgressBar) C12809f.m76831d(this, R$id.manage_value_loading_progress);
        this.mArrow = (ImageView) C12809f.m76831d(this, R$id.manage_right_arrow);
        this.mIconListFrame = (RelativeLayout) C12809f.m76831d(this, R$id.icon_list_frame);
        this.numView = C12809f.m76831d(this, R$id.size_view);
        setArrowShow();
    }

    private void isFamilyShareItem(TypedArray typedArray) {
        if (typedArray != null) {
            this.mIsFamilyShareItem = typedArray.getBoolean(R$styleable.storage_manager_cardview_layout_is_family_share_item, false);
        }
    }

    public void disable() {
        this.mTitleView.setAlpha(0.62f);
        this.mNumberFrameView.setAlpha(0.62f);
        this.mSizeView.setAlpha(0.62f);
        this.mArrow.setAlpha(0.62f);
        this.mIconView.setAlpha(0.62f);
        setEnabled(false);
    }

    public void enable() {
        this.mTitleView.setAlpha(1.0f);
        this.mNumberFrameView.setAlpha(1.0f);
        this.mSizeView.setAlpha(1.0f);
        this.mArrow.setAlpha(1.0f);
        this.mIconView.setAlpha(1.0f);
        setEnabled(true);
    }

    public void hideDivider() {
        this.mDividerView.setVisibility(8);
    }

    public void hideLoading() {
        this.mLoadingView.setVisibility(8);
        this.mArrow.setVisibility(0);
        this.mSizeView.setVisibility(0);
    }

    public void hideNumberFrame() {
        this.mNumberFrameView.setVisibility(8);
    }

    public void onConfigurationChanged() {
        titleViewSetMaxWidth(this.mContext);
    }

    public void parentClick(ViewGroup viewGroup) {
        CurrentOnTouchListener currentOnTouchListener = new CurrentOnTouchListener(viewGroup);
        this.mCurrentOnTouchListener = currentOnTouchListener;
        this.mIconList.setOnTouchListener(currentOnTouchListener);
    }

    public void setArrowShow() {
        this.mArrow.setVisibility(0);
    }

    public void setIconBitmapList(List<Bitmap> list) {
        C0128g2 c0128g2 = this.mIconListAdapter;
        if (c0128g2 != null) {
            c0128g2.m810F(list);
            this.mIconListAdapter.m5213j();
        }
    }

    public void setIconList(List<Drawable> list) {
        C0128g2 c0128g2 = this.mIconListAdapter;
        if (c0128g2 != null) {
            c0128g2.m811G(list);
            this.mIconListAdapter.m5213j();
        }
    }

    public void setIconListFrame(boolean z10) {
        if (z10) {
            this.mIconListFrame.setVisibility(0);
        } else {
            this.mIconListFrame.setVisibility(8);
        }
    }

    public void setImage(Drawable drawable) {
        this.mIconView.setImageDrawable(drawable);
    }

    public void setItemNumber(String str) {
        this.mNumberFrameView.setVisibility(0);
        this.mItemNumberView.setText(str);
    }

    public void setNoItemNumber() {
        this.mNumberFrameView.setVisibility(8);
        this.mItemNumberView.setText("");
    }

    public void setSize(String str) {
        this.numView.setVisibility(8);
        this.mSizeView.setText(str);
        this.mSizeView.setVisibility(TextUtils.isEmpty(str) ? 8 : 0);
    }

    public void setTitle(String str) {
        this.mTitleView.setText(str);
    }

    public void setUsageSize(String str) {
        this.mSizeView.setVisibility(8);
        this.numView.setVisibility(0);
        this.numView.setText(str);
    }

    public void showDivider() {
        this.mDividerView.setVisibility(0);
    }

    public void showLoading() {
        this.mLoadingView.setVisibility(0);
        this.mArrow.setVisibility(8);
        this.mSizeView.setVisibility(8);
    }

    public void showNumberFrame() {
        this.mNumberFrameView.setVisibility(0);
    }

    public void titleViewSetMaxWidth(Context context) {
        if ((context instanceof Activity) && C11842p.m70771U0() && C11842p.m70774V0((Activity) context)) {
            this.mTitleView.setMaxWidth(C11842p.m70853q0());
        } else {
            this.mTitleView.setMaxWidth(C11842p.m70873v0());
        }
    }
}
