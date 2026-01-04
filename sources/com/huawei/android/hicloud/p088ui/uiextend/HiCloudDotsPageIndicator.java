package com.huawei.android.hicloud.p088ui.uiextend;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$dimen;
import com.huawei.android.p073ds.R$styleable;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.util.Locale;
import p514o9.C11839m;
import p514o9.C11842p;

/* loaded from: classes3.dex */
public class HiCloudDotsPageIndicator extends View implements ViewPager.InterfaceC0980i {
    private static final float ADJUST_FONT_HEIGHT = 0.5f;
    private static final int AUTO_PLAY_DELAYMILLIS = 5000;
    private static final float DIVIDER = 2.0f;
    private static final int MIN_COUNT = 2;
    private static final String TAG = "HiCloudDotsPageIndicator";
    private int dotSize;
    private Handler mAutoPlayHandler;
    private long mAutoPlayTime;
    private long mAutoPlayTimeForPageOne;
    private int mBottomMargin;
    private int mCurrentPage;
    private float[] mDotCenterX;
    private float mDotCenterY;
    private int mDotDiameter;
    private float mDotRadius;
    private float mFontHeight;
    private Paint.FontMetrics mFontMetrics;
    private int mGap;
    private boolean mIsAttached;
    private boolean mIsAutoPlay;
    private boolean mIsShowAsDot;
    private ViewPager.InterfaceC0980i mPageChangeListener;
    private int mPageCount;
    private Runnable mRunnable;
    private int mSelectedColour;
    private float mSelectedDotX;
    private Paint mSelectedPaint;
    private float mSelectedRadius;
    private float mTextBaseLineY;
    private float mTextCenterX;
    private String mTextNum;
    private Paint mTextPaint;
    private int mTopMargin;
    private int mUnselectedColour;
    private Paint mUnselectedPaint;
    private UpgradeIntroViewPager mViewPager;
    private int selectedDotWidth;

    public HiCloudDotsPageIndicator(Context context) {
        this(context, null);
    }

    private void calculateDotPositions() {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        float width = paddingLeft + ((((getWidth() - getPaddingRight()) - paddingLeft) - getDesiredWidth()) / 2.0f) + (this.dotSize / 2.0f);
        this.mDotCenterX = new float[this.mPageCount];
        for (int i10 = 0; i10 < this.mPageCount; i10++) {
            this.mDotCenterX[i10] = ((this.mDotDiameter + this.mGap) * i10) + width;
        }
        this.mDotCenterY = paddingTop + (((this.dotSize + this.mTopMargin) + this.mBottomMargin) / 2.0f);
        setCurrentPageImmediate();
    }

    private void calculateNumPosition() {
        this.mTextCenterX = getPaddingLeft() + (((getWidth() - getPaddingRight()) - r0) / 2.0f);
        float paddingTop = getPaddingTop();
        float f10 = this.mFontHeight;
        this.mTextBaseLineY = ((paddingTop + (((this.mTopMargin + f10) + this.mBottomMargin) / 2.0f)) + (f10 / 2.0f)) - this.mFontMetrics.bottom;
        setCurrentPageImmediate();
    }

    private void calculatePositions() {
        if (this.mIsShowAsDot) {
            calculateDotPositions();
        } else {
            calculateNumPosition();
        }
    }

    private void drawNumText(Canvas canvas) {
        if (canvas == null) {
            C11839m.m70689w(TAG, "drawNumText, the canvas is null.");
        } else {
            canvas.drawText(this.mTextNum, this.mTextCenterX, this.mTextBaseLineY, this.mTextPaint);
        }
    }

    private void drawSelected(Canvas canvas) {
        if (canvas == null) {
            C11839m.m70689w(TAG, "drawSelected, the canvas is null.");
            return;
        }
        int i10 = this.selectedDotWidth;
        if (i10 == 0) {
            canvas.drawCircle(this.mSelectedDotX, this.mDotCenterY, this.mSelectedRadius, this.mSelectedPaint);
            return;
        }
        float f10 = i10 / 2;
        float f11 = this.mSelectedDotX;
        float f12 = this.mDotCenterY;
        float f13 = this.mSelectedRadius;
        canvas.drawRoundRect(f11 - f10, f12 - f13, f11 + f10, f12 + f13, f13, f13, this.mSelectedPaint);
    }

    private void drawUnselected(Canvas canvas) {
        if (canvas == null) {
            C11839m.m70689w(TAG, "drawUnselected, the canvas is null.");
            return;
        }
        for (int i10 = 0; i10 < this.mPageCount; i10++) {
            canvas.drawCircle(this.mDotCenterX[i10], this.mDotCenterY, this.mDotRadius, this.mUnselectedPaint);
        }
    }

    private int getDesiredHeight() {
        return getPaddingTop() + this.mTopMargin + this.mBottomMargin + (this.mIsShowAsDot ? this.dotSize : (int) (this.mFontHeight + ADJUST_FONT_HEIGHT)) + getPaddingBottom();
    }

    private int getDesiredWidth() {
        int i10 = this.mPageCount;
        int i11 = this.mDotDiameter;
        return (i10 * i11) + (this.dotSize - i11) + ((i10 - 1) * this.mGap);
    }

    private void initData() throws Resources.NotFoundException {
        if (this.mIsShowAsDot) {
            initDotsParam();
        } else {
            initNumericParam();
        }
        if (this.mIsAutoPlay) {
            initHandle();
        }
        addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.huawei.android.hicloud.ui.uiextend.HiCloudDotsPageIndicator.2
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                HiCloudDotsPageIndicator.this.mIsAttached = true;
                if (HiCloudDotsPageIndicator.this.mIsAutoPlay) {
                    HiCloudDotsPageIndicator.this.startAutoPlayForPageOne();
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                HiCloudDotsPageIndicator.this.mIsAttached = false;
                if (HiCloudDotsPageIndicator.this.mIsAutoPlay) {
                    HiCloudDotsPageIndicator.this.stopAutoPlay();
                }
            }
        });
    }

    private void initDotsParam() {
        Resources resources = getResources();
        this.mDotDiameter = this.selectedDotWidth == 0 ? resources.getDimensionPixelSize(R$dimen.hiclouddotspageindicator_default_dot_size) : this.dotSize;
        int i10 = R$dimen.hiclouddotspageindicator_margin_m;
        this.mTopMargin = resources.getDimensionPixelSize(i10);
        this.mBottomMargin = resources.getDimensionPixelSize(i10);
        this.mDotRadius = this.mDotDiameter / 2.0f;
        Paint paint = new Paint(1);
        this.mUnselectedPaint = paint;
        paint.setColor(this.mUnselectedColour);
        Paint paint2 = new Paint(1);
        this.mSelectedPaint = paint2;
        paint2.setColor(this.mSelectedColour);
    }

    private void initHandle() {
        this.mAutoPlayHandler = new Handler();
    }

    private void initNumericParam() throws Resources.NotFoundException {
        Resources resources = getResources();
        int i10 = R$dimen.hiclouddotspageindicator_margin_l;
        this.mTopMargin = resources.getDimensionPixelSize(i10);
        this.mBottomMargin = resources.getDimensionPixelSize(i10);
        int dimensionPixelSize = resources.getDimensionPixelSize(R$dimen.hiclouddotspageindicator_emui_master_body_2_dp);
        int color = ContextCompat.getColor(getContext(), R$color.hiclouddotspageindicator_emui_gray_2);
        Paint paint = new Paint(1);
        this.mTextPaint = paint;
        paint.setTextSize(dimensionPixelSize);
        this.mTextPaint.setColor(color);
        this.mTextPaint.setTextAlign(Paint.Align.CENTER);
        Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
        this.mFontMetrics = fontMetrics;
        this.mFontHeight = fontMetrics.bottom - fontMetrics.top;
    }

    private boolean isHwLayoutRtl() {
        return getLayoutDirection() == 1;
    }

    private boolean isHwRtlLocale() {
        String language = Locale.getDefault().getLanguage();
        return (language.contains(Constants.AR_CACHE) || language.contains("fa") || language.contains("iw")) || (language.contains("ug") || language.contains(Constants.URDU_LANG)) || isHwLayoutRtl();
    }

    private void setCurrentPageImmediate() {
        UpgradeIntroViewPager upgradeIntroViewPager = this.mViewPager;
        int currentItem = upgradeIntroViewPager != null ? upgradeIntroViewPager.getCurrentItem() : 0;
        this.mCurrentPage = currentItem;
        if (this.mIsShowAsDot) {
            if (this.mPageCount > 0) {
                this.mSelectedDotX = this.mDotCenterX[currentItem];
            }
        } else {
            if (isHwRtlLocale()) {
                this.mTextNum = this.mPageCount + "/" + (this.mCurrentPage + 1);
                return;
            }
            this.mTextNum = (this.mCurrentPage + 1) + "/" + this.mPageCount;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPageCount(int i10) {
        this.mPageCount = i10;
        calculatePositions();
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.mPageCount > 0) {
            if (!this.mIsShowAsDot) {
                drawNumText(canvas);
            } else {
                drawUnselected(canvas);
                drawSelected(canvas);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        int size;
        int mode = View.MeasureSpec.getMode(i11);
        if (mode != Integer.MIN_VALUE) {
            size = mode != 1073741824 ? getDesiredHeight() : View.MeasureSpec.getSize(i11);
        } else {
            size = View.MeasureSpec.getSize(i11);
            int desiredHeight = getDesiredHeight();
            if (desiredHeight <= size) {
                size = desiredHeight;
            }
        }
        setMeasuredDimension(i10, size);
        calculatePositions();
    }

    @Override // androidx.viewpager.widget.ViewPager.InterfaceC0980i
    public void onPageScrollStateChanged(int i10) {
        ViewPager.InterfaceC0980i interfaceC0980i = this.mPageChangeListener;
        if (interfaceC0980i != null) {
            interfaceC0980i.onPageScrollStateChanged(i10);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.InterfaceC0980i
    public void onPageScrolled(int i10, float f10, int i11) {
        ViewPager.InterfaceC0980i interfaceC0980i = this.mPageChangeListener;
        if (interfaceC0980i != null) {
            interfaceC0980i.onPageScrolled(i10, f10, i11);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.InterfaceC0980i
    public void onPageSelected(int i10) {
        C11839m.m70689w(TAG, "currentPosition is " + i10);
        if (this.mIsAttached) {
            setSelectedPage(i10);
        } else {
            setCurrentPageImmediate();
        }
        ViewPager.InterfaceC0980i interfaceC0980i = this.mPageChangeListener;
        if (interfaceC0980i != null) {
            interfaceC0980i.onPageSelected(i10);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        setMeasuredDimension(i10, i11);
        calculatePositions();
    }

    public void setOnPageChangeListener(ViewPager.InterfaceC0980i interfaceC0980i) {
        this.mPageChangeListener = interfaceC0980i;
    }

    public void setRtlEnable(boolean z10) {
        invalidate();
    }

    public void setSelectedPage(int i10) {
        if (i10 != this.mCurrentPage && this.mPageCount != 0) {
            this.mCurrentPage = i10;
            setCurrentPageImmediate();
            invalidate();
            return;
        }
        C11839m.m70689w(TAG, "setSelectedPage : mCurrentPage = " + this.mCurrentPage + ", now = " + i10 + ", mPageCount = " + this.mPageCount);
    }

    public void setViewPager(UpgradeIntroViewPager upgradeIntroViewPager) {
        if (upgradeIntroViewPager == null || upgradeIntroViewPager.getAdapter() == null) {
            C11839m.m70689w(TAG, "setViewPage, viewPager = " + upgradeIntroViewPager);
            return;
        }
        this.mViewPager = upgradeIntroViewPager;
        setPageCount(upgradeIntroViewPager.getAdapter().getCount());
        upgradeIntroViewPager.getAdapter().registerDataSetObserver(new DataSetObserver() { // from class: com.huawei.android.hicloud.ui.uiextend.HiCloudDotsPageIndicator.3
            @Override // android.database.DataSetObserver
            public void onChanged() {
                HiCloudDotsPageIndicator hiCloudDotsPageIndicator = HiCloudDotsPageIndicator.this;
                hiCloudDotsPageIndicator.setPageCount(hiCloudDotsPageIndicator.mViewPager.getAdapter().getCount());
            }
        });
        upgradeIntroViewPager.addOnPageChangeListener(this);
        setCurrentPageImmediate();
    }

    public void setmAutoPlayTime(long j10) {
        this.mAutoPlayTime = j10;
    }

    public void startAutoPlay() {
        this.mIsAutoPlay = true;
        if (this.mAutoPlayHandler == null) {
            initHandle();
        }
        this.mAutoPlayHandler.removeCallbacks(this.mRunnable);
        this.mAutoPlayHandler.postDelayed(this.mRunnable, this.mAutoPlayTime);
    }

    public void startAutoPlayForPageOne() {
        this.mIsAutoPlay = true;
        if (this.mAutoPlayHandler == null) {
            initHandle();
        }
        this.mAutoPlayHandler.removeCallbacks(this.mRunnable);
        this.mAutoPlayHandler.postDelayed(this.mRunnable, this.mAutoPlayTimeForPageOne);
    }

    public void stopAutoPlay() {
        this.mIsAutoPlay = false;
        Handler handler = this.mAutoPlayHandler;
        if (handler != null) {
            handler.removeCallbacks(this.mRunnable);
        }
        this.mAutoPlayHandler = null;
    }

    public HiCloudDotsPageIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HiCloudDotsPageIndicator(Context context, AttributeSet attributeSet, int i10) throws Resources.NotFoundException {
        super(context, attributeSet, i10);
        this.mAutoPlayTime = 5000L;
        this.mAutoPlayTimeForPageOne = 3000L;
        this.mRunnable = new Runnable() { // from class: com.huawei.android.hicloud.ui.uiextend.HiCloudDotsPageIndicator.1
            @Override // java.lang.Runnable
            public void run() throws IllegalAccessException, NoSuchFieldException, Resources.NotFoundException, IllegalArgumentException {
                if (HiCloudDotsPageIndicator.this.mViewPager == null || HiCloudDotsPageIndicator.this.mViewPager.getAdapter() == null) {
                    C11839m.m70689w(HiCloudDotsPageIndicator.TAG, "Runnable, mViewPager=" + HiCloudDotsPageIndicator.this.mViewPager);
                    return;
                }
                if (2 > HiCloudDotsPageIndicator.this.mViewPager.getAdapter().getCount()) {
                    C11839m.m70689w(HiCloudDotsPageIndicator.TAG, "the page count is less than two");
                    return;
                }
                int currentItem = HiCloudDotsPageIndicator.this.mViewPager.getCurrentItem();
                if (C11842p.m70765S0()) {
                    if (currentItem == 0) {
                        int count = HiCloudDotsPageIndicator.this.mViewPager.getAdapter().getCount() - 1;
                        HiCloudDotsPageIndicator.this.mViewPager.setFixedSpeedScroller();
                        HiCloudDotsPageIndicator.this.mViewPager.setCurrentItem(count, false);
                    } else {
                        HiCloudDotsPageIndicator.this.mViewPager.setFixedSpeedScroller();
                        HiCloudDotsPageIndicator.this.mViewPager.setCurrentItem(currentItem - 1, true);
                    }
                } else if (currentItem == HiCloudDotsPageIndicator.this.mViewPager.getAdapter().getCount() - 1) {
                    HiCloudDotsPageIndicator.this.mViewPager.setFixedSpeedScroller();
                    HiCloudDotsPageIndicator.this.mViewPager.setCurrentItem(0, false);
                } else {
                    HiCloudDotsPageIndicator.this.mViewPager.setFixedSpeedScroller();
                    HiCloudDotsPageIndicator.this.mViewPager.setCurrentItem(currentItem + 1, true);
                }
                if (HiCloudDotsPageIndicator.this.mIsAutoPlay) {
                    HiCloudDotsPageIndicator.this.mAutoPlayHandler.postDelayed(HiCloudDotsPageIndicator.this.mRunnable, HiCloudDotsPageIndicator.this.mAutoPlayTime);
                }
            }
        };
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.HiCloudDotsPageIndicator, i10, 0);
        this.mIsAutoPlay = typedArrayObtainStyledAttributes.getBoolean(R$styleable.HiCloudDotsPageIndicator_isAutoPlay, false);
        this.mUnselectedColour = typedArrayObtainStyledAttributes.getColor(R$styleable.HiCloudDotsPageIndicator_unselectedDotColor, ContextCompat.getColor(getContext(), R$color.hiclouddotspageindicator_emui_gray_3));
        this.mSelectedColour = typedArrayObtainStyledAttributes.getColor(R$styleable.HiCloudDotsPageIndicator_selectedDotColor, ContextCompat.getColor(getContext(), R$color.emui_accent));
        this.mIsShowAsDot = typedArrayObtainStyledAttributes.getBoolean(R$styleable.HiCloudDotsPageIndicator_isShowAsDot, true);
        this.selectedDotWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.HiCloudDotsPageIndicator_selectedDotWidth, 0);
        this.mGap = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.HiCloudDotsPageIndicator_gap, getResources().getDimensionPixelSize(R$dimen.hiclouddotspageindicator_default_gap));
        int dimension = (int) typedArrayObtainStyledAttributes.getDimension(R$styleable.HiCloudDotsPageIndicator_dotSize, getResources().getDimensionPixelSize(R$dimen.hiclouddotspageindicator_default_selected_dot_size));
        this.dotSize = dimension;
        this.mSelectedRadius = dimension / 2.0f;
        typedArrayObtainStyledAttributes.recycle();
        initData();
    }
}
