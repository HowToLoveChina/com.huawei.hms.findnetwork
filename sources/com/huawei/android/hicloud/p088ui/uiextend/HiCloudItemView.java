package com.huawei.android.hicloud.p088ui.uiextend;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowInsets;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.android.hicloud.p088ui.common.UnionSwitch;
import com.huawei.android.hicloud.p088ui.extend.HiCloudListTipsLayout;
import com.huawei.android.sync.R$dimen;
import com.huawei.android.sync.R$id;
import com.huawei.android.sync.R$layout;
import com.huawei.android.sync.R$styleable;
import p015ak.C0209d;
import p336he.C10155f;
import p514o9.C11842p;
import sk.C12806c;
import sk.C12808e;
import sk.C12809f;
import sk.InterfaceC12805b;

/* loaded from: classes3.dex */
public class HiCloudItemView extends LinearLayout implements InterfaceC12805b {
    public static final int DEFAULT_MIN_HEIGHT = 48;
    private static final String DIVIDER_GONE = "none";
    private static final String DIVIDER_SHOW = "show";
    private static final int HICLOUD_ITEM_END_TEXT_PADDING = 16;
    private static final int IMG_WIDTH = 40;
    private static final int RED_DOT_WIDTH = 10;
    private static final String TAG = "HiCloudItemView";
    protected View currentDivider;
    private View inflateView;
    private View innerView;
    protected boolean isShowSwitch;
    protected boolean isSubsuerDisable;
    protected ImageView mArrow;
    private Context mContext;
    protected String mDisableModuleName;
    protected String mDividerShow;
    protected View mDividerView;
    protected View mDividerViewNoIcon;
    protected HiCloudEndTextLayout mEndTextLayout;
    protected ImageView mIconView;
    protected Drawable mImg;
    private boolean mIsSupportMinWidth;
    protected int mMinHeight;
    protected String mStatus;
    protected TextView mStatusView;
    protected String mSubTitle;
    protected HiCloudListTipsLayout mSubTitleView;
    protected UnionSwitch mSwitchView;
    protected String mTitle;
    protected TextView mTitleView;
    private RelativeLayout mainLayout;
    protected boolean noNeedNotchFit;

    public HiCloudItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDividerShow = "show";
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.hicloud_item_attr);
        this.mContext = context;
        initView(context);
        initAttribute(typedArrayObtainStyledAttributes);
    }

    private int getMaxTitleViewWidthHasSwitch() {
        int iM70719D;
        float fM70844o;
        if ((this.mContext instanceof Activity) && C11842p.m70771U0() && C11842p.m70774V0((Activity) this.mContext)) {
            if (this.mImg != null) {
                return C11842p.m70773V();
            }
            iM70719D = C11842p.m70773V() + ((int) C11842p.m70844o(this.mContext, 40));
            fM70844o = C11842p.m70844o(this.mContext, 16);
        } else {
            if (this.mImg != null) {
                return C11842p.m70719D();
            }
            iM70719D = C11842p.m70719D() + ((int) C11842p.m70844o(this.mContext, 40));
            fM70844o = C11842p.m70844o(this.mContext, 16);
        }
        return iM70719D + ((int) fM70844o);
    }

    private int getMaxTitleViewWidthHasTextRight() {
        int iM70713B;
        float fM70844o;
        if ((this.mContext instanceof Activity) && C11842p.m70771U0() && C11842p.m70774V0((Activity) this.mContext)) {
            if (this.mImg != null) {
                return C11842p.m70770U(this.mContext);
            }
            iM70713B = C11842p.m70770U(this.mContext);
            fM70844o = C11842p.m70844o(this.mContext, 40);
        } else {
            if (this.mImg != null) {
                return C11842p.m70713B(this.mContext);
            }
            iM70713B = C11842p.m70713B(this.mContext);
            fM70844o = C11842p.m70844o(this.mContext, 40);
        }
        return iM70713B + ((int) fM70844o);
    }

    private int getMaxTitleViewWidthNoTextRight() {
        int iM70805e0;
        float fM70844o;
        if ((this.mContext instanceof Activity) && C11842p.m70771U0() && C11842p.m70774V0((Activity) this.mContext)) {
            if (this.mImg == null) {
                return C11842p.m70782Y();
            }
            iM70805e0 = C11842p.m70782Y();
            fM70844o = C11842p.m70844o(this.mContext, 40);
        } else {
            if (this.mImg == null) {
                return C11842p.m70805e0();
            }
            iM70805e0 = C11842p.m70805e0();
            fM70844o = C11842p.m70844o(this.mContext, 40);
        }
        return iM70805e0 - ((int) fM70844o);
    }

    private void initAttribute(TypedArray typedArray) {
        if (typedArray != null) {
            this.mTitle = typedArray.getString(R$styleable.hicloud_item_attr_item_title);
            this.mMinHeight = typedArray.getDimensionPixelSize(R$styleable.hicloud_item_attr_min_height, C11842p.m70840n(this.mContext, 48));
            this.mStatus = typedArray.getString(R$styleable.hicloud_item_attr_status_text);
            this.mDividerShow = typedArray.getString(R$styleable.hicloud_item_attr_item_divider);
            this.isSubsuerDisable = typedArray.getBoolean(R$styleable.hicloud_item_attr_sub_user_disable, false);
            this.mIsSupportMinWidth = typedArray.getBoolean(R$styleable.hicloud_item_attr_endtext_support_min_width, true);
            this.noNeedNotchFit = typedArray.getBoolean(R$styleable.hicloud_item_attr_no_need_notch_fit, false);
            this.innerView.setMinimumHeight(this.mMinHeight);
            this.mTitleView.setText(this.mTitle);
            this.mStatusView.setText(this.mStatus);
            if (this.isSubsuerDisable && !C0209d.m1166E1()) {
                disable();
            }
            initImage(typedArray);
            if (this.mImg == null) {
                this.currentDivider = this.mDividerViewNoIcon;
            } else {
                this.currentDivider = this.mDividerView;
            }
            String str = this.mDividerShow;
            if (str == null || !str.equals("none")) {
                this.currentDivider.setVisibility(0);
            } else {
                this.currentDivider.setVisibility(8);
            }
            initSubTitle(typedArray);
            initDisabledModule(typedArray);
            initEndTextLayout(typedArray);
            initSwitch(typedArray);
            typedArray.recycle();
        }
    }

    private void initView(Context context) {
        View viewInflate = View.inflate(context, R$layout.hicloud_item_sync, this);
        this.inflateView = viewInflate;
        this.innerView = viewInflate.findViewById(R$id.hicloud_item);
        this.mIconView = (ImageView) C12809f.m76831d(this, R$id.hicloud_item_icon);
        this.mTitleView = (TextView) C12809f.m76831d(this, R$id.hicloud_item_title);
        this.mSubTitleView = (HiCloudListTipsLayout) C12809f.m76831d(this, R$id.hicloud_sub_title);
        this.mStatusView = (TextView) C12809f.m76831d(this, R$id.hicloud_item_status);
        this.mDividerView = C12809f.m76831d(this, R$id.hicloud_item_divider);
        this.mDividerViewNoIcon = C12809f.m76831d(this, R$id.hicloud_item_divider_no_icon);
        this.mEndTextLayout = (HiCloudEndTextLayout) C12809f.m76831d(this, R$id.hicloud_item_status_frame);
        this.mArrow = (ImageView) C12809f.m76831d(this, R$id.hicloud_item_right_arrow);
        this.mSwitchView = (UnionSwitch) C12809f.m76831d(this, R$id.hicloud_item_switch);
        this.mainLayout = (RelativeLayout) C12809f.m76831d(this, R$id.main_layout);
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
            case "autorecordingkey":
                setViewGone(!C10155f.m63254G(this.mContext));
                break;
            case "autosmslistkey":
                setViewGone(!C10155f.m63255H(this.mContext));
                break;
            case "autophonemanagerkey":
                setViewGone(!C10155f.m63250C(this.mContext));
                break;
            case "autocallloglistkey":
                setViewGone(!C10155f.m63298v(this.mContext));
                break;
        }
    }

    public void disable() {
        this.mTitleView.setAlpha(0.62f);
        this.mSubTitleView.setAlpha(0.62f);
        this.mIconView.setAlpha(0.62f);
        this.mStatusView.setAlpha(0.62f);
        this.mArrow.setAlpha(0.62f);
        this.mSwitchView.setEnabled(false);
        setEnabled(false);
    }

    public void enable() {
        this.mTitleView.setAlpha(1.0f);
        this.mSubTitleView.setAlpha(1.0f);
        this.mStatusView.setAlpha(1.0f);
        this.mArrow.setAlpha(1.0f);
        this.mIconView.setAlpha(1.0f);
    }

    public void hideArrow() {
        this.mArrow.setVisibility(8);
    }

    public void hideDivider() {
        this.currentDivider.setVisibility(8);
    }

    public void hideIconView() {
        this.mIconView.setVisibility(8);
        Resources resources = getResources();
        if (resources != null) {
            this.mainLayout.setMinimumHeight(resources.getDimensionPixelSize(R$dimen.list_min_height));
        }
    }

    public void hideStatus() {
        this.mStatusView.setVisibility(8);
    }

    public void hideSubTitle() {
        this.mSubTitleView.m23994a();
    }

    public void hideSwitch() {
        this.mSwitchView.setVisibility(8);
    }

    public void hideTips() {
        this.mSubTitleView.m23994a();
    }

    public void initDisabledModule(TypedArray typedArray) {
        String string = typedArray.getString(R$styleable.hicloud_item_attr_module_disable_hide);
        this.mDisableModuleName = string;
        if (TextUtils.isEmpty(string)) {
            return;
        }
        setViewVisibility();
    }

    public void initEndTextLayout(TypedArray typedArray) {
        setTitleMaxWidth();
    }

    public void initImage(TypedArray typedArray) {
        Drawable drawable = typedArray.getDrawable(R$styleable.hicloud_item_attr_item_img);
        this.mImg = drawable;
        if (drawable == null) {
            this.mIconView.setVisibility(8);
            this.mainLayout.setMinimumHeight(getResources().getDimensionPixelSize(R$dimen.list_min_height));
        } else {
            this.mIconView.setImageDrawable(drawable);
            this.mainLayout.setMinimumHeight(getResources().getDimensionPixelSize(R$dimen.list_min_height_with_icon));
        }
    }

    public void initSubTitle(TypedArray typedArray) {
        String string = typedArray.getString(R$styleable.hicloud_item_attr_sub_title);
        this.mSubTitle = string;
        if (TextUtils.isEmpty(string)) {
            this.mSubTitleView.m23995b();
        } else {
            this.mSubTitleView.setText(this.mSubTitle);
        }
    }

    public void initSwitch(TypedArray typedArray) {
        boolean z10 = typedArray.getBoolean(R$styleable.hicloud_item_attr_show_switch, false);
        this.isShowSwitch = z10;
        if (z10) {
            showSwitch();
        } else {
            hideSwitch();
        }
    }

    public void invisibleArrow() {
        this.mArrow.setVisibility(4);
    }

    public boolean isChecked() {
        return this.mSwitchView.isChecked();
    }

    public void onConfigurationChanged() {
        int maxTitleViewWidthHasSwitch = this.mSwitchView.getVisibility() == 0 ? getMaxTitleViewWidthHasSwitch() : !this.mIsSupportMinWidth ? getMaxTitleViewWidthNoTextRight() : getMaxTitleViewWidthHasTextRight();
        this.mTitleView.setMaxWidth(maxTitleViewWidthHasSwitch - C11842p.m70840n(this.mContext, 10));
        this.mSubTitleView.m23998e(maxTitleViewWidthHasSwitch);
    }

    @Override // sk.InterfaceC12805b
    public void onRotation180(WindowInsets windowInsets) {
        if (this.noNeedNotchFit) {
            return;
        }
        setPadding(C12808e.m76823b(), 0, C12808e.m76823b(), 0);
    }

    @Override // sk.InterfaceC12805b
    public void onRotation270(WindowInsets windowInsets) {
        if (this.noNeedNotchFit) {
            return;
        }
        Context context = this.mContext;
        setPadding(0, 0, (context == null || !C12806c.m76818i(context)) ? 0 : C11842p.m70789a0(this.mContext), 0);
    }

    @Override // sk.InterfaceC12805b
    public void onRotation90(WindowInsets windowInsets) {
        if (this.noNeedNotchFit) {
            return;
        }
        Context context = this.mContext;
        setPadding(context != null ? C11842p.m70789a0(context) : 0, 0, 0, 0);
    }

    @Override // sk.InterfaceC12805b
    public void onRotationPortrait(WindowInsets windowInsets) {
        if (this.noNeedNotchFit) {
            return;
        }
        setPadding(C12808e.m76823b(), 0, C12808e.m76823b(), 0);
    }

    public void setChecked(boolean z10) {
        this.mSwitchView.setChecked(z10);
    }

    public void setDefaultSubTitle(String str) {
        this.mSubTitleView.setDefaultTips(str);
    }

    public void setImage(Drawable drawable) {
        this.mIconView.setImageDrawable(drawable);
        this.mIconView.setVisibility(0);
        this.mImg = drawable;
        setTitleMaxWidth();
    }

    public void setNoSubTitle() {
        this.mSubTitleView.m23995b();
    }

    public void setStatusText(String str) {
        this.mStatusView.setText(str);
    }

    public void setSubTitleLoadingText(String str) throws Resources.NotFoundException {
        this.mSubTitleView.setLoadingText(str);
    }

    public void setSubTitleText(String str) {
        this.mSubTitleView.setText(str);
    }

    public void setTitle(String str) {
        this.mTitleView.setText(str);
    }

    public void setTitleMaxWidth() {
        this.mEndTextLayout.setSupportMinWidth(this.mIsSupportMinWidth);
        this.mEndTextLayout.requestLayout();
        this.mTitleView.requestLayout();
        int maxTitleViewWidthNoTextRight = !this.mIsSupportMinWidth ? getMaxTitleViewWidthNoTextRight() : getMaxTitleViewWidthHasTextRight();
        this.mTitleView.setMaxWidth(maxTitleViewWidthNoTextRight - C11842p.m70840n(this.mContext, 10));
        this.mSubTitleView.m23998e(maxTitleViewWidthNoTextRight);
    }

    public void showArrow() {
        this.mArrow.setVisibility(0);
    }

    public void showStatus() {
        this.mStatusView.setVisibility(0);
    }

    public void showSubTitle() {
        this.mSubTitleView.m23997d();
    }

    public void showSwitch() {
        this.mSwitchView.setVisibility(0);
    }
}
