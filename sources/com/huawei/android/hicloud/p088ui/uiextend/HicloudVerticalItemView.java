package com.huawei.android.hicloud.p088ui.uiextend;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.android.p073ds.R$styleable;
import p015ak.C0209d;
import p336he.C10155f;
import p514o9.C11839m;
import p514o9.C11842p;
import sk.C12809f;

/* loaded from: classes3.dex */
public class HicloudVerticalItemView extends LinearLayout {
    public static final int DEFAULT_MIN_HEIGHT = 103;
    private static final int IMAGE_ALPHA_VALUE = 92;
    private static final String TAG = "HicloudVertivcalItemView";
    private static final float TEXT_ALPHA_VALUE = 0.38f;
    private View inflateView;
    private View innerView;
    protected boolean isLoading;
    protected boolean isSubsuerDisable;
    private Context mContext;
    protected String mDisableModuleName;
    protected ImageView mImageView;
    protected Drawable mImg;
    private boolean mIsSingleRow;
    protected ProgressBar mLoadingView;
    protected int mMinHeight;
    protected ImageView mRedDotView;
    protected String mStatus;
    protected TextView mStatusView;
    protected String mSubTitle;
    protected TextView mSubTitleView;
    protected String mTitle;
    protected TextView mTitleView;

    public HicloudVerticalItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsSingleRow = false;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.hicloud_vertical_item_attr);
        this.mContext = context;
        initView(context);
        initAttribute(typedArrayObtainStyledAttributes);
    }

    private void initAttribute(TypedArray typedArray) {
        if (typedArray != null) {
            this.mTitle = typedArray.getString(R$styleable.hicloud_vertical_item_attr_vertical_item_title);
            this.mMinHeight = typedArray.getDimensionPixelSize(R$styleable.hicloud_vertical_item_attr_vertical_min_height, C11842p.m70840n(this.mContext, 103));
            this.mStatus = typedArray.getString(R$styleable.hicloud_vertical_item_attr_vertical_status_text);
            this.mImg = typedArray.getDrawable(R$styleable.hicloud_vertical_item_attr_vertical_item_img);
            this.isLoading = typedArray.getBoolean(R$styleable.hicloud_vertical_item_attr_vertical_loading, false);
            this.isSubsuerDisable = typedArray.getBoolean(R$styleable.hicloud_vertical_item_attr_vertical_sub_user_disable, false);
            this.innerView.setMinimumHeight(this.mMinHeight);
            this.mTitleView.setText(this.mTitle);
            this.mStatusView.setText(this.mStatus);
            this.mImageView.setImageDrawable(this.mImg);
            if (this.isLoading) {
                showLoading();
            } else {
                hideLoading();
            }
            if (this.isSubsuerDisable && !C0209d.m1166E1()) {
                disable();
            }
            initSubTitle(typedArray);
            initDisabledModule(typedArray);
            initSingleRow();
            setTitleViewMaxWidth();
            typedArray.recycle();
        }
    }

    private void initSingleRow() {
        this.mIsSingleRow = C10155f.m63301y() != C10155f.m63253F();
    }

    private void initView(Context context) {
        View viewInflate = View.inflate(context, R$layout.hicloud_vertical_item, this);
        this.inflateView = viewInflate;
        this.innerView = viewInflate.findViewById(R$id.hicloud_item);
        this.mTitleView = (TextView) C12809f.m76831d(this, R$id.hicloud_item_title);
        this.mImageView = (ImageView) C12809f.m76831d(this, R$id.hicloud_vertical_item_image);
        this.mSubTitleView = (TextView) C12809f.m76831d(this, R$id.hicloud_sub_title);
        this.mStatusView = (TextView) C12809f.m76831d(this, R$id.hicloud_item_status);
        this.mLoadingView = (ProgressBar) C12809f.m76831d(this, R$id.hicloud_item_loading_progress);
        this.mRedDotView = (ImageView) C12809f.m76831d(this, R$id.backup_redDot_icon);
    }

    private void setTitleViewMaxWidth() {
        if (this.mIsSingleRow) {
            setSingleRowTitleViewMaxWidth();
        } else {
            setDoubleRowTitleViewMaxWidth();
        }
    }

    private void setViewGone(boolean z10) {
        if (z10) {
            setVisibility(8);
        }
    }

    private void setViewVisibility() {
        String str = this.mDisableModuleName;
        str.hashCode();
        switch (str) {
            case "funcfg_huawei_drive":
                setViewGone(!C10155f.m63248A());
                break;
            case "funcfg_find_my_phone_globe":
                setViewGone(!C10155f.m63253F());
                break;
            case "funcfg_cloud_backup":
                setViewGone(!C10155f.m63301y());
                break;
        }
    }

    public void disable() {
        this.mStatusView.setVisibility(4);
        this.mTitleView.setAlpha(0.62f);
        this.mSubTitleView.setAlpha(0.62f);
        this.mImageView.setImageAlpha(92);
        setEnabled(false);
    }

    public void enable() {
        this.mTitleView.setAlpha(1.0f);
        this.mSubTitleView.setAlpha(1.0f);
        this.mStatusView.setAlpha(1.0f);
    }

    public void hideLoading() {
        this.mLoadingView.setVisibility(8);
        this.mStatusView.setVisibility(0);
        this.mImageView.setVisibility(0);
    }

    public void hideRedDot() {
        this.mRedDotView.setVisibility(8);
    }

    public void hideStatus() {
        this.mStatusView.setVisibility(8);
    }

    public void hideSubTitle() {
        this.mSubTitleView.setVisibility(8);
    }

    public void hideTips() {
        this.mSubTitleView.setVisibility(8);
    }

    public void initDisabledModule(TypedArray typedArray) {
        String string = typedArray.getString(R$styleable.hicloud_vertical_item_attr_vertical_module_disable_hide);
        this.mDisableModuleName = string;
        if (TextUtils.isEmpty(string)) {
            return;
        }
        setViewVisibility();
    }

    public void initSubTitle(TypedArray typedArray) {
        String string = typedArray.getString(R$styleable.hicloud_vertical_item_attr_vertical_sub_title);
        this.mSubTitle = string;
        if (TextUtils.isEmpty(string)) {
            this.mSubTitleView.setVisibility(0);
        } else {
            this.mSubTitleView.setText(this.mSubTitle);
        }
    }

    public void onConfigurationChanged() {
        setTitleViewMaxWidth();
    }

    public void setDefaultSubTitle(String str) {
        this.mSubTitleView.setVisibility(0);
        this.mSubTitleView.setText(str);
    }

    public void setDoubleRowTitleViewMaxWidth() {
        this.mTitleView.setMaxWidth(C11842p.m70884y());
    }

    public void setNoSubTitle() {
        this.mSubTitleView.setVisibility(8);
    }

    public void setSingleRow(boolean z10) {
        this.mIsSingleRow = z10;
    }

    public void setSingleRowTitleViewMaxWidth() {
        this.mTitleView.setMaxWidth(C11842p.m70761R());
    }

    public void setStatusText(String str) {
        this.mStatusView.setText(str);
    }

    public void setStatusTextBackground(Drawable drawable) {
        this.mStatusView.setBackground(drawable);
    }

    public void setSubTitleLoadingText(String str) throws Resources.NotFoundException {
        C11839m.m70686d(TAG, "setLoadingText : " + str);
        Resources resources = getResources();
        if (resources != null) {
            str = resources.getString(R$string.general_append_handling2, str);
        }
        this.mSubTitleView.setVisibility(0);
        this.mSubTitleView.setText(str);
    }

    public void setSubTitleText(String str) {
        this.mSubTitleView.setText(str);
    }

    public void setTitle(String str) {
        this.mTitleView.setText(str);
    }

    public void setTitleColor(int i10) {
        Resources resources = getResources();
        if (resources != null) {
            this.mTitleView.setTextColor(resources.getColor(i10));
        }
    }

    public void setmSubTitleText(String str) {
        this.mSubTitleView.setText(str);
    }

    public void showLoading() {
        this.mLoadingView.setVisibility(0);
        this.mStatusView.setVisibility(4);
        this.mImageView.setVisibility(8);
    }

    public void showRedDot() {
        this.mRedDotView.setVisibility(8);
    }

    public void showStatus() {
        this.mStatusView.setVisibility(0);
    }

    public void showSubTitle() {
        this.mSubTitleView.setVisibility(0);
    }
}
