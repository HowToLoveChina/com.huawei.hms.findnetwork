package com.huawei.android.hicloud.p088ui.uiextend.cloudpay;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.uiadapter.cloudpay.RightGridAdapter;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.cloud.pay.model.GradeCardDisplayBean;
import com.huawei.cloud.pay.model.PackageGradeRight;
import com.huawei.cloud.pay.model.PackageGrades;
import com.huawei.cloud.pay.model.cardresourcebean.GradeCardBaseResourceBean;
import com.huawei.cloud.pay.model.cardresourcebean.GradeCardDefaultResourceBean;
import com.huawei.cloud.pay.model.cardresourcebean.GradeCardDiamondResourceBean;
import com.huawei.cloud.pay.model.cardresourcebean.GradeCardGoldResourceBean;
import com.huawei.cloud.pay.model.cardresourcebean.GradeCardNormalResourceBean;
import com.huawei.cloud.pay.model.cardresourcebean.GradeCardPlatinumResourceBean;
import com.huawei.cloud.pay.model.cardresourcebean.GradeCardSilverResourceBean;
import com.huawei.cloud.pay.model.cardresourcebean.GradeCardTryResourceBean;
import com.huawei.hicloud.base.p103ui.uiextend.ScrollDisableGridView;
import dk.EnumC9164e;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0223k;
import p054cj.C1442a;
import p398jj.ViewOnTouchListenerC10893b;
import p454lj.C11290m;
import p459lp.C11326d;
import p514o9.C11828b;
import p709vj.C13452e;
import sk.C12809f;

/* loaded from: classes3.dex */
public class GradeCardView extends RelativeLayout {
    private static final String TAG = "GradeCardView";
    protected TextView cardGradeName;
    protected TextView cardPackageInfo;
    protected TextView cardPrice;
    protected LinearLayout cardPriceLayout;
    protected TextView cardRightTitle;
    protected RelativeLayout cardTextLayout;
    protected View cloudWatermark;
    protected Context context;
    protected TextView cradOldPrice;
    protected int folderDownIconDrawable;
    protected ImageView folderIconImage;
    protected View folderLayout;
    protected int folderUpIconDrawable;
    protected RightGridAdapter gridAdapter;
    protected C11828b imageLoader;
    protected boolean isFolded;
    private boolean isShowPrice;
    protected boolean needShowRightDescText;
    private int oneRowRightSize;
    protected ScrollDisableGridView rightGridView;
    List<PackageGradeRight> rights;
    protected RelativeLayout rootLayout;
    private AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener;

    /* renamed from: com.huawei.android.hicloud.ui.uiextend.cloudpay.GradeCardView$3 */
    public static /* synthetic */ class C41503 {

        /* renamed from: $SwitchMap$com$huawei$hicloud$base$constant$UserGradeConstants$GradeCodeLevel */
        static final /* synthetic */ int[] f19195xad5204ea;

        static {
            int[] iArr = new int[EnumC9164e.values().length];
            f19195xad5204ea = iArr;
            try {
                iArr[EnumC9164e.LEVEL_0.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f19195xad5204ea[EnumC9164e.LEVEL_1.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f19195xad5204ea[EnumC9164e.LEVEL_2.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f19195xad5204ea[EnumC9164e.LEVEL_3.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public GradeCardView(Context context) {
        super(context);
        this.oneRowRightSize = 5;
        this.folderDownIconDrawable = R$drawable.grade_card_folder_down_diamond;
        this.folderUpIconDrawable = R$drawable.grade_card_folder_up_diamond;
        this.isFolded = true;
        this.isShowPrice = true;
        this.touchExplorationStateChangeListener = new AccessibilityManager.TouchExplorationStateChangeListener() { // from class: com.huawei.android.hicloud.ui.uiextend.cloudpay.GradeCardView.1
            @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
            public void onTouchExplorationStateChanged(boolean z10) {
                C1442a.m8288d(GradeCardView.TAG, "listener screen reading:" + z10);
                ScrollDisableGridView scrollDisableGridView = GradeCardView.this.rightGridView;
                if (scrollDisableGridView != null) {
                    scrollDisableGridView.setEnabled(z10);
                } else {
                    C1442a.m8289e(GradeCardView.TAG, "view is null");
                }
            }
        };
        initView(context);
    }

    private String fixedDuration(GradeCardDisplayBean gradeCardDisplayBean, NumberFormat numberFormat, int i10) throws Resources.NotFoundException {
        int durationUnit = gradeCardDisplayBean.getDurationUnit();
        if (durationUnit == 1) {
            return getResources().getString(R$string.cloudpay_package_urse_space_detail, C0223k.m1524g(this.context, gradeCardDisplayBean.getCapacity()), getResources().getString(R$string.cloudpay_parenthesis, getResources().getQuantityString(R$plurals.cloudpay_package_duration_time_unit_day, i10, numberFormat.format(i10))));
        }
        if (durationUnit == 2) {
            return getResources().getString(R$string.cloudpay_package_urse_space_detail, C0223k.m1524g(this.context, gradeCardDisplayBean.getCapacity()), getResources().getString(R$string.cloudpay_parenthesis, getResources().getQuantityString(R$plurals.cloudpay_package_duration_time_unit_month, i10, numberFormat.format(i10))));
        }
        if (durationUnit != 3) {
            return "";
        }
        return getResources().getString(R$string.cloudpay_package_urse_space_detail, C0223k.m1524g(this.context, gradeCardDisplayBean.getCapacity()), getResources().getString(R$string.cloudpay_parenthesis, getResources().getQuantityString(R$plurals.cloudpay_package_duration_time_unit_month, i10, numberFormat.format(i10))));
    }

    private List<PackageGradeRight> getActiveRights(List<PackageGradeRight> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (PackageGradeRight packageGradeRight : list) {
                if (packageGradeRight.getStatus() == 1) {
                    arrayList.add(packageGradeRight);
                }
            }
        }
        return arrayList;
    }

    private String getCardPackageStr(GradeCardDisplayBean gradeCardDisplayBean, int i10, int i11, boolean z10) {
        return i11 == -1 ? getDefaultStr(gradeCardDisplayBean) : i11 == 0 ? getHuweiCardStr(gradeCardDisplayBean, i10, z10) : i11 == 1 ? getCloudCardStr(gradeCardDisplayBean) : "";
    }

    private String getCloudCardStr(GradeCardDisplayBean gradeCardDisplayBean) throws Resources.NotFoundException {
        int durationMonth = gradeCardDisplayBean.getDurationMonth();
        int durationUnit = gradeCardDisplayBean.getDurationUnit();
        if (durationUnit == 1) {
            String quantityString = getResources().getQuantityString(R$plurals.cloudpay_cloud_card_day, durationMonth, Integer.valueOf(durationMonth));
            return getResources().getString(R$string.cloudpay_package_urse_space_detail, C0223k.m1524g(this.context, gradeCardDisplayBean.getCapacity()), getResources().getString(R$string.cloudpay_parenthesis, quantityString));
        }
        if (durationUnit == 2) {
            String quantityString2 = getResources().getQuantityString(R$plurals.cloudpay_cloud_card_month, durationMonth, Integer.valueOf(durationMonth));
            return getResources().getString(R$string.cloudpay_package_urse_space_detail, C0223k.m1524g(this.context, gradeCardDisplayBean.getCapacity()), getResources().getString(R$string.cloudpay_parenthesis, quantityString2));
        }
        if (durationUnit != 3) {
            return "";
        }
        String quantityString3 = getResources().getQuantityString(R$plurals.cloudpay_cloud_card_year, durationMonth, Integer.valueOf(durationMonth));
        return getResources().getString(R$string.cloudpay_package_urse_space_detail, C0223k.m1524g(this.context, gradeCardDisplayBean.getCapacity()), getResources().getString(R$string.cloudpay_parenthesis, quantityString3));
    }

    private String getDefaultStr(GradeCardDisplayBean gradeCardDisplayBean) throws Resources.NotFoundException {
        NumberFormat numberFormat = NumberFormat.getInstance();
        int durationMonth = gradeCardDisplayBean.getDurationMonth();
        return getResources().getString(R$string.cloudpay_package_urse_space_detail, C0223k.m1524g(this.context, gradeCardDisplayBean.getCapacity()), getResources().getString(R$string.cloudpay_parenthesis, getResources().getQuantityString(R$plurals.cloudpay_package_duration_time_unit_month, durationMonth, numberFormat.format(durationMonth))));
    }

    private String getHuweiCardStr(GradeCardDisplayBean gradeCardDisplayBean, int i10, boolean z10) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        int durationMonth = gradeCardDisplayBean.getDurationMonth();
        if (i10 == 0) {
            return fixedDuration(gradeCardDisplayBean, numberFormat, durationMonth);
        }
        if (i10 == 1) {
            int durationUnit = gradeCardDisplayBean.getDurationUnit();
            if (z10) {
                return fixedDuration(gradeCardDisplayBean, numberFormat, durationMonth);
            }
            if (durationUnit == 2) {
                if (durationMonth == 1) {
                    return getResources().getString(R$string.cloudpay_package_urse_space_detail, C0223k.m1524g(this.context, gradeCardDisplayBean.getCapacity()), getResources().getString(R$string.cloudpay_parenthesis, getResources().getString(R$string.cloudpay_renew_month)));
                }
                if (durationMonth == 12) {
                    return getResources().getString(R$string.cloudpay_package_urse_space_detail, C0223k.m1524g(this.context, gradeCardDisplayBean.getCapacity()), getResources().getString(R$string.cloudpay_parenthesis, getResources().getString(R$string.cloudpay_renew_year)));
                }
                return getResources().getString(R$string.cloudpay_package_urse_space_detail, C0223k.m1524g(this.context, gradeCardDisplayBean.getCapacity()), getResources().getString(R$string.cloudpay_parenthesis, getResources().getString(R$string.cloudpay_continuous_monthly_title_new)));
            }
        }
        return "";
    }

    private void setNotShowPriceWidth() {
        this.cardPriceLayout.setMinimumWidth(0);
        this.cardGradeName.setMaxWidth(Integer.MAX_VALUE);
        this.cardPackageInfo.setMaxWidth(Integer.MAX_VALUE);
        this.cardRightTitle.setMaxWidth(Integer.MAX_VALUE);
        C12809f.m76843p(this.cardPriceLayout, false);
    }

    private void showCurrentPrice(TextView textView, GradeCardDisplayBean gradeCardDisplayBean) {
        if (textView == null) {
            C1442a.m8289e(TAG, "showCurrentPrice currentPriceTV is null.");
            return;
        }
        BigDecimal spPrice = gradeCardDisplayBean.getSpPrice();
        BigDecimal price = gradeCardDisplayBean.getPrice();
        int productType = gradeCardDisplayBean.getProductType();
        String currency = gradeCardDisplayBean.getCurrency();
        String symbol = gradeCardDisplayBean.getSymbol();
        if (spPrice == null) {
            textView.setText(C11290m.m67749j(price, currency, symbol));
        } else {
            textView.setText((productType == 7 || productType == 8) ? C11290m.m67749j(spPrice, currency, symbol) : C11290m.m67749j(price, currency, symbol));
        }
    }

    private void showOldPrice(TextView textView, GradeCardDisplayBean gradeCardDisplayBean) {
        if (textView == null) {
            C1442a.m8289e(TAG, "showOldPrice oldPriceTV is null.");
            return;
        }
        if (gradeCardDisplayBean == null) {
            C1442a.m8289e(TAG, "data is null.");
            return;
        }
        if (gradeCardDisplayBean.getSpPrice() == null) {
            textView.setVisibility(8);
            return;
        }
        if ((gradeCardDisplayBean.getProductType() != 7 && gradeCardDisplayBean.getProductType() != 8) || gradeCardDisplayBean.getSpPrice().compareTo(gradeCardDisplayBean.getPrice()) != -1) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        textView.setText(C11290m.m67749j(gradeCardDisplayBean.getPrice(), gradeCardDisplayBean.getCurrency(), gradeCardDisplayBean.getSymbol()));
        textView.getPaint().setStrikeThruText(true);
    }

    public List<PackageGradeRight> getOneRowRights(List<PackageGradeRight> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            if (list.size() > this.oneRowRightSize) {
                for (int i10 = 0; i10 < this.oneRowRightSize; i10++) {
                    arrayList.add(list.get(i10));
                }
            } else {
                arrayList.addAll(list);
            }
        }
        return arrayList;
    }

    public RightGridAdapter getRightGridAdapter(Context context) {
        return new RightGridAdapter(context);
    }

    public void inflateLayout(Context context) {
        float fM1195O = C0209d.m1195O(context);
        if (fM1195O >= 3.2f) {
            View.inflate(context, R$layout.grade_card_layout_3dot2, this);
        } else if (fM1195O < 1.75f || fM1195O >= 3.2f) {
            View.inflate(context, R$layout.grade_card_layout, this);
        } else {
            View.inflate(context, R$layout.grade_card_layout_2, this);
        }
    }

    public void initView(Context context) {
        inflateLayout(context);
        this.rootLayout = (RelativeLayout) C12809f.m76831d(this, R$id.card_root_layout);
        this.cardGradeName = (TextView) C12809f.m76831d(this, R$id.card_grade_name);
        this.cardPackageInfo = (TextView) C12809f.m76831d(this, R$id.card_package_info);
        this.cardRightTitle = (TextView) C12809f.m76831d(this, R$id.card_right_title);
        this.cardPrice = (TextView) C12809f.m76831d(this, R$id.card_price);
        this.cradOldPrice = (TextView) C12809f.m76831d(this, R$id.card_old_price);
        this.cardPriceLayout = (LinearLayout) C12809f.m76831d(this, R$id.card_price_layout);
        this.cardTextLayout = (RelativeLayout) C12809f.m76831d(this, R$id.card_text_layout);
        ScrollDisableGridView scrollDisableGridView = (ScrollDisableGridView) C12809f.m76831d(this, R$id.card_right_grid);
        this.rightGridView = scrollDisableGridView;
        scrollDisableGridView.setEnabled(C2783d.m16103Q(context));
        this.rightGridView.setClickable(false);
        C2783d.m16129c(context, this.touchExplorationStateChangeListener);
        this.folderLayout = C12809f.m76831d(this, R$id.folder_layout);
        this.folderIconImage = (ImageView) C12809f.m76831d(this, R$id.folder_icon);
        this.folderLayout.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.android.hicloud.ui.uiextend.cloudpay.GradeCardView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GradeCardView gradeCardView = GradeCardView.this;
                if (gradeCardView.isFolded) {
                    gradeCardView.folderIconImage.setBackground(gradeCardView.getResources().getDrawable(GradeCardView.this.folderUpIconDrawable));
                    GradeCardView gradeCardView2 = GradeCardView.this;
                    gradeCardView2.isFolded = false;
                    gradeCardView2.setAdapterData(gradeCardView2.rights, gradeCardView2.imageLoader, gradeCardView2.needShowRightDescText);
                    return;
                }
                gradeCardView.folderIconImage.setBackground(gradeCardView.getResources().getDrawable(GradeCardView.this.folderDownIconDrawable));
                GradeCardView gradeCardView3 = GradeCardView.this;
                gradeCardView3.isFolded = true;
                List<PackageGradeRight> oneRowRights = gradeCardView3.getOneRowRights(gradeCardView3.rights);
                GradeCardView gradeCardView4 = GradeCardView.this;
                gradeCardView4.setAdapterData(oneRowRights, gradeCardView4.imageLoader, gradeCardView4.needShowRightDescText);
            }
        });
        this.cloudWatermark = C12809f.m76831d(this, R$id.card_cloud_watermark);
        this.folderLayout.setOnTouchListener(new ViewOnTouchListenerC10893b(context, this.folderIconImage, R$drawable.selected_foreground_rectangle));
        RightGridAdapter rightGridAdapter = getRightGridAdapter(context);
        this.gridAdapter = rightGridAdapter;
        this.rightGridView.setAdapter((ListAdapter) rightGridAdapter);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C2783d.m16126b(this.context, this.touchExplorationStateChangeListener);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        setTextLayoutWidth(getMeasuredWidth());
        super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    public void refreshViewByGradeCode(String str) {
        if (C13452e.m80781L().m80887a1()) {
            setCardResource(new GradeCardDefaultResourceBean(false));
            return;
        }
        if (TextUtils.equals(str, CloudBackupConstant.UserPackageInfo.TRIAL_MEMBER)) {
            setCardResource(new GradeCardTryResourceBean(false));
            return;
        }
        if (TextUtils.equals(str, CloudBackupConstant.UserPackageInfo.ONE_T_MEMBER)) {
            setCardResource(new GradeCardPlatinumResourceBean(false));
            return;
        }
        int i10 = C41503.f19195xad5204ea[C11326d.m68044f(str).ordinal()];
        if (i10 == 1) {
            setCardResource(new GradeCardNormalResourceBean(false));
            return;
        }
        if (i10 == 2) {
            setCardResource(new GradeCardSilverResourceBean(false));
            return;
        }
        if (i10 == 3) {
            setCardResource(new GradeCardGoldResourceBean(false));
        } else if (i10 != 4) {
            setCardResource(new GradeCardDefaultResourceBean(false));
        } else {
            setCardResource(new GradeCardDiamondResourceBean(false));
        }
    }

    public void setAdapterData(List<PackageGradeRight> list, C11828b c11828b, boolean z10) {
        this.gridAdapter.m25398g(list, c11828b, z10);
    }

    public void setCardResource(GradeCardBaseResourceBean gradeCardBaseResourceBean) {
        if (gradeCardBaseResourceBean == null) {
            C1442a.m8289e(TAG, "setCardResource failed resourceBean is null");
            return;
        }
        this.rootLayout.setBackground(this.context.getDrawable(gradeCardBaseResourceBean.getCardBgDrawable()));
        this.cardGradeName.setTextColor(this.context.getColor(gradeCardBaseResourceBean.getCardGradeTitleTextColor()));
        this.cardPrice.setTextColor(this.context.getColor(gradeCardBaseResourceBean.getCardPriceTextColor()));
        this.cradOldPrice.setTextColor(this.context.getColor(gradeCardBaseResourceBean.getOldPriceTextColor()));
        this.cardPackageInfo.setTextColor(this.context.getColor(gradeCardBaseResourceBean.getCardSpaceInfoTextColor()));
        this.cardRightTitle.setTextColor(this.context.getColor(gradeCardBaseResourceBean.getCardRightTitleColor()));
        this.gridAdapter.m25397f(gradeCardBaseResourceBean.getCardRightIconBgDrawable());
        this.folderDownIconDrawable = gradeCardBaseResourceBean.getCardFolderDownIconDrawable();
        this.folderUpIconDrawable = gradeCardBaseResourceBean.getCardFolderUpIconDrawable();
        this.cloudWatermark.setAlpha(gradeCardBaseResourceBean.getCloudCardWatermarkAlpha());
    }

    public void setData(GradeCardDisplayBean gradeCardDisplayBean, String str, C11828b c11828b, boolean z10) {
        setData(gradeCardDisplayBean, str, c11828b, z10, true, -1, -1, false);
    }

    public void setRightColumns(int i10) {
        ScrollDisableGridView scrollDisableGridView = this.rightGridView;
        if (scrollDisableGridView != null) {
            scrollDisableGridView.setNumColumns(i10);
            this.oneRowRightSize = i10;
            showFolderView(this.rights);
            setAdapterData(getOneRowRights(this.rights), this.imageLoader, this.needShowRightDescText);
        }
    }

    public void setTextLayoutWidth(int i10) {
        RelativeLayout relativeLayout;
        if (this.context == null || (relativeLayout = this.cardTextLayout) == null || i10 <= 0) {
            C1442a.m8291w(TAG, "setTextLayoutWidth context is null or cardTextLayout is null or measuredWidth is 0");
            return;
        }
        ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
        if (layoutParams == null) {
            C1442a.m8291w(TAG, "setTextLayoutWidth cardTextLayout params is null");
            return;
        }
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            int marginStart = layoutParams2.getMarginStart();
            int marginEnd = layoutParams2.getMarginEnd();
            if (!this.isShowPrice) {
                setNotShowPriceWidth();
                return;
            }
            TextView textView = this.cardGradeName;
            if (textView == null || this.cardPackageInfo == null || this.cardRightTitle == null || this.cardPriceLayout == null) {
                return;
            }
            int i11 = (i10 - marginStart) - marginEnd;
            int i12 = (i11 * 2) / 3;
            textView.setMaxWidth(i12);
            this.cardPackageInfo.setMaxWidth(i12);
            this.cardRightTitle.setMaxWidth(i12);
            this.cardPriceLayout.setMinimumWidth(i11 / 3);
        }
    }

    public void showFolderView(List<PackageGradeRight> list) {
        if (this.folderLayout == null || this.folderIconImage == null) {
            return;
        }
        if (list == null || list.size() <= this.oneRowRightSize) {
            this.folderLayout.setVisibility(4);
        } else {
            this.folderLayout.setVisibility(0);
            this.folderIconImage.setBackground(getResources().getDrawable(this.folderDownIconDrawable));
        }
    }

    public void setData(GradeCardDisplayBean gradeCardDisplayBean, String str, C11828b c11828b, boolean z10, boolean z11, int i10, int i11, boolean z12) {
        setData(gradeCardDisplayBean, str, c11828b, z10, z11, i10, i11, z12, false);
    }

    public void setData(GradeCardDisplayBean gradeCardDisplayBean, String str, C11828b c11828b, boolean z10, boolean z11, int i10, int i11, boolean z12, boolean z13) {
        this.needShowRightDescText = z10;
        this.imageLoader = c11828b;
        this.isShowPrice = z11;
        PackageGrades packageGrades = gradeCardDisplayBean.getPackageGrades();
        this.cardPackageInfo.setText(getCardPackageStr(gradeCardDisplayBean, i10, i11, z12));
        if (z11) {
            showCurrentPrice(this.cardPrice, gradeCardDisplayBean);
            showOldPrice(this.cradOldPrice, gradeCardDisplayBean);
        } else {
            setNotShowPriceWidth();
        }
        this.cardRightTitle.setText(str);
        if (packageGrades != null) {
            String gradeName = packageGrades.getGradeName();
            if (!CloudBackupConstant.UserPackageInfo.BASE_DATA_SERVICE.equals(packageGrades.getGradeCode()) && z13) {
                TextView textView = this.cardGradeName;
                Context context = this.context;
                textView.setText(context.getString(R$string.cloudpay_bm_current_plan_value, gradeName, C0223k.m1524g(context, gradeCardDisplayBean.getCapacity())));
            } else {
                this.cardGradeName.setText(gradeName);
            }
            if (z13) {
                refreshViewByGradeCode("D");
                int color = this.context.getColor(R$color.new_bm_pay_card_text_color);
                this.cardPackageInfo.setTextColor(color);
                this.cardRightTitle.setTextColor(color);
                this.cardGradeName.setTextColor(color);
            } else {
                refreshViewByGradeCode(packageGrades.getGradeCode());
            }
            List<PackageGradeRight> activeRights = getActiveRights(packageGrades.getRights());
            this.rights = activeRights;
            showFolderView(activeRights);
            setAdapterData(getOneRowRights(this.rights), c11828b, z10);
        }
    }

    public GradeCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oneRowRightSize = 5;
        this.folderDownIconDrawable = R$drawable.grade_card_folder_down_diamond;
        this.folderUpIconDrawable = R$drawable.grade_card_folder_up_diamond;
        this.isFolded = true;
        this.isShowPrice = true;
        this.touchExplorationStateChangeListener = new AccessibilityManager.TouchExplorationStateChangeListener() { // from class: com.huawei.android.hicloud.ui.uiextend.cloudpay.GradeCardView.1
            @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
            public void onTouchExplorationStateChanged(boolean z10) {
                C1442a.m8288d(GradeCardView.TAG, "listener screen reading:" + z10);
                ScrollDisableGridView scrollDisableGridView = GradeCardView.this.rightGridView;
                if (scrollDisableGridView != null) {
                    scrollDisableGridView.setEnabled(z10);
                } else {
                    C1442a.m8289e(GradeCardView.TAG, "view is null");
                }
            }
        };
        this.context = context;
        initView(context);
    }
}
