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
import android.view.WindowInsets;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.hicloud.p088ui.uiadapter.NoScrollLinearLayoutManager;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$styleable;
import com.huawei.uikit.phone.hwprogressbar.widget.HwProgressBar;
import java.util.List;
import p015ak.C0209d;
import p514o9.C11842p;
import sk.C12806c;
import sk.C12808e;
import sk.C12809f;
import sk.InterfaceC12805b;

/* loaded from: classes3.dex */
public class StorageManagerCardLayout extends LinearLayout implements InterfaceC12805b {
    private static final int HICLOUD_ITEM_ARROW_TEXT_WIDTH = 270;
    private static final int HICLOUD_ITEM_IMAGE_WIDTH = 20;
    private static final int HICLOUD_ITEM_RED_IMG_WIDTH = 8;
    private static final String TAG = "StorageManagerCardLayout";
    protected boolean cardEndTextSupportMinWidth;
    private int cardIconSize;
    protected Drawable cardImg;
    protected int cardMinHeight;
    protected String cardSubTitle;
    protected String cardTitle;
    private ImageView expiredBackupRecordsRedImg;
    private float fontScale;
    private int imgCount;
    private boolean isBelowListShow;
    private Context mContext;
    private CurrentOnTouchListener mCurrentOnTouchListener;
    private CurrentOnTouchListener mCurrentOnTouchListenerBelow;
    private C0128g2 mIconListAdapter;
    private boolean mIsDefaultLayout;
    private boolean mIsFamilyShare;
    protected boolean mIsFamilyShareItem;
    private int maxTitleViewWidth;
    private RecyclerView storageManageCardIconList;
    private RecyclerView storageManageCardIconListBelow;
    private RelativeLayout storageManageCardIconListFrame;
    private RelativeLayout storageManageCardIconListFrameBelow;
    private RelativeLayout storageManageCardItem;
    private RelativeLayout storageManageCardItemContent;
    private ImageView storageManageCardItemIcon;
    private HiCloudSpaceCleanEndTextLayout storageManageCardItemStatusFrame;
    private RelativeLayout storageManageCardItemTextFrame;
    private LinearLayout storageManageCardLl;
    private HwProgressBar storageManageCardLoadingProgress;
    private TextView storageManageCardNumber;
    private ImageView storageManageCardRedImg;
    private ImageView storageManageCardRightArrow;
    private TextView storageManageCardSize;
    private RelativeLayout storageManageCardSubRl;
    private TextView storageManageCardSubTitle;
    private TextView storageManageCardTitle;

    public StorageManagerCardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsFamilyShareItem = false;
        this.mIsDefaultLayout = false;
        this.mIsFamilyShare = true;
        this.isBelowListShow = false;
        this.imgCount = 0;
        this.cardIconSize = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.storage_manager_card_layout);
        this.mContext = context;
        this.fontScale = C0209d.m1195O(context);
        initView(this.mContext);
        initData(typedArrayObtainStyledAttributes);
        initRecyclerview();
    }

    private int getMaxTitleViewWidthHasTextRight() {
        return ((this.mContext instanceof Activity) && C11842p.m70771U0() && C11842p.m70774V0((Activity) this.mContext)) ? C11842p.m70845o0() : C11842p.m70865t0();
    }

    private int getMaxTitleViewWidthNoTextRight() {
        return ((this.mContext instanceof Activity) && C11842p.m70771U0() && C11842p.m70774V0((Activity) this.mContext)) ? C11842p.m70849p0() : C11842p.m70869u0();
    }

    private void initData(TypedArray typedArray) {
        if (typedArray != null) {
            this.cardImg = typedArray.getDrawable(R$styleable.storage_manager_card_layout_card_img);
            this.cardTitle = typedArray.getString(R$styleable.storage_manager_card_layout_card_title);
            this.cardSubTitle = typedArray.getString(R$styleable.storage_manager_card_layout_card_sub_title);
            this.cardMinHeight = typedArray.getDimensionPixelSize(R$styleable.storage_manager_card_layout_card_min_height, -2);
            this.cardEndTextSupportMinWidth = typedArray.getBoolean(R$styleable.storage_manager_card_layout_card_end_text_support_min_width, true);
            this.mIsFamilyShareItem = typedArray.getBoolean(R$styleable.storage_manager_card_layout_card_is_family_share_item, false);
            this.cardIconSize = typedArray.getDimensionPixelSize(R$styleable.storage_manager_card_layout_card_icon_size, 0);
            this.storageManageCardLl.setMinimumHeight(this.cardMinHeight);
            this.storageManageCardItemIcon.setImageDrawable(this.cardImg);
            this.storageManageCardTitle.setText(this.cardTitle);
            this.storageManageCardSubTitle.setText(this.cardSubTitle);
            hideRedImg();
            if (C0209d.m1195O(this.mContext) < 1.75f) {
                setTitleMaxWidth(this.cardEndTextSupportMinWidth);
            }
            if (this.cardIconSize != 0) {
                ViewGroup.LayoutParams layoutParams = this.storageManageCardItemIcon.getLayoutParams();
                int i10 = this.cardIconSize;
                layoutParams.height = i10;
                layoutParams.width = i10;
                this.storageManageCardItemIcon.setLayoutParams(layoutParams);
            }
            typedArray.recycle();
        }
    }

    private void initRecyclerview() {
        this.storageManageCardIconList.setLayoutManager(new NoScrollLinearLayoutManager(this.mContext, 0, false));
        C0128g2 c0128g2 = new C0128g2(this.mContext, this.mIsDefaultLayout, this.mIsFamilyShare);
        this.mIconListAdapter = c0128g2;
        this.storageManageCardIconList.setAdapter(c0128g2);
        this.storageManageCardIconList.setFocusable(false);
        this.storageManageCardIconListBelow.setLayoutManager(new NoScrollLinearLayoutManager(this.mContext, 0, false));
        this.storageManageCardIconListBelow.setAdapter(this.mIconListAdapter);
        this.storageManageCardIconListBelow.setFocusable(false);
    }

    private void initView(Context context) {
        if (context == null) {
            return;
        }
        if (this.fontScale >= 1.75f) {
            View.inflate(context, R$layout.storage_manage_card_layout_font_scale, this);
        } else {
            View.inflate(context, R$layout.storage_manage_card_layout, this);
        }
        this.storageManageCardLl = (LinearLayout) C12809f.m76831d(this, R$id.storage_manage_card_ll);
        this.storageManageCardItem = (RelativeLayout) C12809f.m76831d(this, R$id.storage_manage_card_item);
        this.storageManageCardItemIcon = (ImageView) C12809f.m76831d(this, R$id.storage_manage_card_item_icon);
        this.storageManageCardItemContent = (RelativeLayout) C12809f.m76831d(this, R$id.storage_manage_card_item_content);
        this.storageManageCardItemTextFrame = (RelativeLayout) C12809f.m76831d(this, R$id.storage_manage_card_item_text_frame);
        this.storageManageCardTitle = (TextView) C12809f.m76831d(this, R$id.storage_manage_card_title);
        this.storageManageCardSubTitle = (TextView) C12809f.m76831d(this, R$id.storage_manage_card_sub_title);
        this.storageManageCardSubRl = (RelativeLayout) C12809f.m76831d(this, R$id.storage_manage_card_sub_rl);
        this.storageManageCardNumber = (TextView) C12809f.m76831d(this, R$id.storage_manage_card_number);
        this.storageManageCardIconListFrame = (RelativeLayout) C12809f.m76831d(this, R$id.storage_manage_card_icon_list_frame);
        this.storageManageCardIconList = (RecyclerView) C12809f.m76831d(this, R$id.storage_manage_card_icon_list);
        this.storageManageCardIconListFrameBelow = (RelativeLayout) C12809f.m76831d(this, R$id.storage_manage_card_icon_list_frame_below);
        this.storageManageCardIconListBelow = (RecyclerView) C12809f.m76831d(this, R$id.storage_manage_card_icon_list_below);
        this.storageManageCardItemStatusFrame = (HiCloudSpaceCleanEndTextLayout) C12809f.m76831d(this, R$id.storage_manage_card_item_status_frame);
        this.storageManageCardRightArrow = (ImageView) C12809f.m76831d(this, R$id.storage_manage_card_right_arrow);
        this.storageManageCardRedImg = (ImageView) C12809f.m76831d(this, R$id.storage_manage_card_red_img);
        this.expiredBackupRecordsRedImg = (ImageView) C12809f.m76831d(this, R$id.expired_backup_records_red_img);
        this.storageManageCardLoadingProgress = (HwProgressBar) C12809f.m76831d(this, R$id.storage_manage_card_loading_progress);
        this.storageManageCardSize = (TextView) C12809f.m76831d(this, R$id.storage_manage_card_size);
    }

    private void setCardEndTextSupportMinWidth(boolean z10) {
        this.cardEndTextSupportMinWidth = z10;
    }

    public void disable() {
        this.storageManageCardItemIcon.setAlpha(0.62f);
        this.storageManageCardTitle.setAlpha(0.62f);
        this.storageManageCardSubTitle.setAlpha(0.62f);
        this.storageManageCardNumber.setAlpha(0.62f);
        this.storageManageCardRightArrow.setAlpha(0.62f);
        this.storageManageCardRedImg.setAlpha(0.62f);
        this.storageManageCardSize.setAlpha(0.62f);
        setEnabled(false);
    }

    public void enable() {
        this.storageManageCardItemIcon.setAlpha(1.0f);
        this.storageManageCardTitle.setAlpha(1.0f);
        this.storageManageCardSubTitle.setAlpha(1.0f);
        this.storageManageCardNumber.setAlpha(1.0f);
        this.storageManageCardRightArrow.setAlpha(1.0f);
        this.storageManageCardRedImg.setAlpha(1.0f);
        this.storageManageCardSize.setAlpha(1.0f);
        setEnabled(true);
    }

    public void hideExpiredBackupRecordsRedImg() {
        ImageView imageView = this.expiredBackupRecordsRedImg;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    public void hideLoading() {
        HwProgressBar hwProgressBar = this.storageManageCardLoadingProgress;
        if (hwProgressBar != null) {
            hwProgressBar.setVisibility(8);
        }
    }

    public void hideRedImg() {
        if (this.storageManageCardRedImg != null) {
            if (this.fontScale >= 1.75f && this.storageManageCardSize.getVisibility() == 8) {
                this.storageManageCardItemStatusFrame.setVisibility(8);
            }
            this.storageManageCardRedImg.setVisibility(8);
        }
    }

    public void hideRightArrowImg() {
        ImageView imageView = this.storageManageCardRightArrow;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    public void hideStorageManageCardSize() {
        if (this.storageManageCardSize != null) {
            if (this.fontScale >= 1.75f && this.storageManageCardRedImg.getVisibility() == 8) {
                this.storageManageCardItemStatusFrame.setVisibility(8);
            }
            this.storageManageCardSize.setVisibility(8);
        }
    }

    public void hideStorageManageCardSubTitle() {
        TextView textView = this.storageManageCardSubTitle;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    public void hideSubDataListView() {
        RelativeLayout relativeLayout = this.storageManageCardSubRl;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
    }

    public void onConfigurationChanged() {
        if (C0209d.m1195O(this.mContext) < 1.75f) {
            setTitleMaxWidth(this.cardEndTextSupportMinWidth);
            this.isBelowListShow = this.storageManageCardNumber.getPaint().measureText(this.storageManageCardNumber.getText().toString()) + (C11842p.m70844o(this.mContext, 20) * ((float) this.imgCount)) > ((float) this.maxTitleViewWidth);
        }
        setIconListFrame(true, this.isBelowListShow);
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

    public void parentClick(ViewGroup viewGroup) {
        CurrentOnTouchListener currentOnTouchListener = new CurrentOnTouchListener(viewGroup);
        this.mCurrentOnTouchListener = currentOnTouchListener;
        this.storageManageCardIconList.setOnTouchListener(currentOnTouchListener);
    }

    public void parentClickBelow(ViewGroup viewGroup) {
        CurrentOnTouchListener currentOnTouchListener = new CurrentOnTouchListener(viewGroup);
        this.mCurrentOnTouchListenerBelow = currentOnTouchListener;
        this.storageManageCardIconListBelow.setOnTouchListener(currentOnTouchListener);
    }

    public void setArrowText(String str) {
        if (this.storageManageCardSize == null || TextUtils.isEmpty(str)) {
            hideStorageManageCardSize();
            return;
        }
        this.storageManageCardSize.setText(str);
        this.storageManageCardItemStatusFrame.setVisibility(0);
        this.storageManageCardSize.setVisibility(0);
        setCardEndTextSupportMinWidth(!TextUtils.isEmpty(str));
        if (C0209d.m1195O(this.mContext) < 1.75f) {
            setTitleMaxWidth(this.cardEndTextSupportMinWidth);
        }
    }

    public void setIconBitmapList(List<Bitmap> list) {
        C0128g2 c0128g2 = this.mIconListAdapter;
        if (c0128g2 != null) {
            c0128g2.m810F(list);
            this.mIconListAdapter.m5213j();
        }
    }

    public void setIconListFrame(boolean z10, boolean z11) {
        RelativeLayout relativeLayout = this.storageManageCardIconListFrame;
        if (relativeLayout == null || this.storageManageCardIconListFrameBelow == null) {
            return;
        }
        if (!z10) {
            relativeLayout.setVisibility(8);
            this.storageManageCardIconListFrameBelow.setVisibility(8);
        } else if (z11) {
            relativeLayout.setVisibility(8);
            this.storageManageCardIconListFrameBelow.setVisibility(0);
        } else {
            relativeLayout.setVisibility(0);
            this.storageManageCardIconListFrameBelow.setVisibility(8);
        }
    }

    public void setStorageManageCardItemIcon(Drawable drawable) {
        this.storageManageCardItemIcon.setImageDrawable(drawable);
    }

    public void setStorageManageCardNumber(String str, int i10) {
        TextView textView = this.storageManageCardNumber;
        if (textView != null) {
            this.imgCount = i10;
            textView.setText(str);
            hideStorageManageCardSubTitle();
            showSubDataListView();
            this.storageManageCardNumber.setVisibility(0);
            if (C0209d.m1195O(this.mContext) < 1.75f) {
                this.isBelowListShow = this.storageManageCardNumber.getPaint().measureText(this.storageManageCardNumber.getText().toString()) + (C11842p.m70844o(this.mContext, 20) * ((float) i10)) > ((float) this.maxTitleViewWidth);
            }
            setIconListFrame(true, this.isBelowListShow);
        }
    }

    public void setSubTitleText(String str) {
        TextView textView = this.storageManageCardSubTitle;
        if (textView != null) {
            textView.setText(str);
            this.storageManageCardSubTitle.setVisibility(0);
            hideSubDataListView();
            if (C0209d.m1195O(this.mContext) < 1.75f) {
                setTitleMaxWidth(this.cardEndTextSupportMinWidth);
            }
        }
    }

    public void setTitleMaxWidth(boolean z10) {
        int iMin = Math.min((int) this.storageManageCardSize.getPaint().measureText(this.storageManageCardSize.getText().toString()), 270);
        this.storageManageCardItemStatusFrame.setSupportMinWidth(z10);
        this.storageManageCardItemStatusFrame.requestLayout();
        this.storageManageCardTitle.requestLayout();
        if (z10) {
            this.maxTitleViewWidth = this.mIsFamilyShareItem ? (getMaxTitleViewWidthHasTextRight() - iMin) + ((int) C11842p.m70844o(this.mContext, 8)) : getMaxTitleViewWidthHasTextRight() - iMin;
        } else {
            this.maxTitleViewWidth = getMaxTitleViewWidthNoTextRight();
        }
        this.storageManageCardTitle.setMaxWidth(this.maxTitleViewWidth);
        this.storageManageCardSubTitle.setMaxWidth(this.maxTitleViewWidth);
    }

    public void setTitleText(String str) {
        TextView textView = this.storageManageCardTitle;
        if (textView != null) {
            textView.setText(str);
            this.storageManageCardTitle.setVisibility(0);
        }
    }

    public void showExpiredBackupRecordsRedImg() {
        ImageView imageView = this.expiredBackupRecordsRedImg;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    public void showLoading() {
        HwProgressBar hwProgressBar = this.storageManageCardLoadingProgress;
        if (hwProgressBar != null) {
            hwProgressBar.setVisibility(0);
        }
    }

    public void showRedImg() {
        if (this.storageManageCardRedImg != null) {
            this.storageManageCardItemStatusFrame.setVisibility(0);
            this.storageManageCardRedImg.setVisibility(0);
        }
    }

    public void showRightArrowImg() {
        ImageView imageView = this.storageManageCardRightArrow;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    public void showSubDataListView() {
        RelativeLayout relativeLayout = this.storageManageCardSubRl;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
            if (C0209d.m1195O(this.mContext) < 1.75f) {
                setTitleMaxWidth(this.cardEndTextSupportMinWidth);
            }
        }
    }
}
