package com.huawei.android.hicloud.p088ui.uiextend;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.AbstractC0984a;
import androidx.viewpager.widget.ViewPager;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.extend.HiCloudRoundRectImageView;
import com.huawei.android.hicloud.p088ui.uilistener.Base64DecodeFailedListener;
import com.huawei.android.p073ds.R$dimen;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.hicloud.notification.constants.BannerPictureType;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.constants.RecommendCardConstants;
import com.huawei.hicloud.notification.manager.RecommendCardManager;
import com.huawei.hicloud.notification.p106db.bean.RecommendCard;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import p015ak.C0209d;
import p015ak.C0213f;
import p052cb.C1414k;
import p258ei.C9492a;
import p273f0.C9582a;
import p273f0.C9603h0;
import p304g0.C9832l;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11842p;
import p684un.C13223b;
import p684un.C13227f;
import p684un.C13230i;
import p709vj.C13452e;
import sk.C12809f;

/* loaded from: classes3.dex */
public class BannerViewPager extends FrameLayout implements ViewPager.InterfaceC0980i {
    private static final int AUTO_ROLL_TIME = 5000;
    private static final int DOT_MARGIN_RIGHT = 8;
    private static final int INITIAL_POSITION = 100;
    private static final int MAX_COUNT = 3000;
    private static final int MAX_NUM = 10;
    private static final float RADIUS_OFFSET_HEAD = 0.5f;
    public static final int SCROLL_END_MESSAGE = 0;
    public static final int SCROLL_STATE_IDLE = 0;
    private static final int START_ROLL_LIST_SIZE = 2;
    private static final String TAG = "BannerViewPager";
    private static C9582a accessibilityDelegateCompat = new C9582a() { // from class: com.huawei.android.hicloud.ui.uiextend.BannerViewPager.2
        @Override // p273f0.C9582a
        public void onInitializeAccessibilityNodeInfo(View view, C9832l c9832l) {
            super.onInitializeAccessibilityNodeInfo(view, c9832l);
            c9832l.m61065U(RelativeLayout.class.getName());
        }
    };
    private BannerViewClickListener bannerViewClickListener;
    public Base64DecodeFailedListener base64DecodeFailedListener;
    private CallBackBlur callListener;
    private boolean isBigToSmall;
    private boolean isPress;
    private boolean isScrolling;
    private boolean isSmallToBig;
    private boolean isUpdate;
    private BannerDataAdapter landscapeAdapter;
    private BannerDataAdapter mAdapter;
    private AutoRollRunnable mAutoRollRunnable;
    private CopyOnWriteArrayList<RecommendCard> mBannerAdList;
    private View mColorImage;
    private Context mContext;
    private List<ImageView> mDotList;
    private LinearLayout mDotLl;
    private GestureDetector mGestureDetector;
    private Handler mHandler;
    private int mScreenHeight;
    private int mScreenWidth;
    protected Handler mScrollEndHandler;
    private CustomViewPager mViewPager;
    private GestureDetector.OnGestureListener onGestureListener;
    private BannerDataAdapter portraitAdapter;
    private int prePosition;
    private Activity startActivity;

    public class AutoRollRunnable implements Runnable {
        boolean isRunning;

        private AutoRollRunnable() {
            this.isRunning = false;
        }

        public boolean isRunning() {
            return this.isRunning;
        }

        @Override // java.lang.Runnable
        public void run() throws Resources.NotFoundException {
            if (this.isRunning) {
                if (!C11842p.m70765S0()) {
                    BannerViewPager.this.mViewPager.setCurrentItem(BannerViewPager.this.mViewPager.getCurrentItem() + 1);
                } else if (BannerViewPager.this.mViewPager.getCurrentItem() == 0) {
                    BannerViewPager.this.mViewPager.setCurrentItem(99 - (100 % BannerViewPager.this.mBannerAdList.size()));
                } else {
                    BannerViewPager.this.mViewPager.setCurrentItem(BannerViewPager.this.mViewPager.getCurrentItem() - 1);
                }
                BannerViewPager.this.mHandler.postDelayed(this, 5000L);
            }
        }

        public void start() {
            if (this.isRunning) {
                return;
            }
            this.isRunning = true;
            BannerViewPager.this.mHandler.removeCallbacks(this);
            BannerViewPager.this.mHandler.postDelayed(this, 5000L);
            C11839m.m70686d(BannerViewPager.TAG, "Begin To AutoRoll");
        }

        public void stop() {
            if (this.isRunning) {
                BannerViewPager.this.mHandler.removeCallbacks(this);
                this.isRunning = false;
                C11839m.m70686d(BannerViewPager.TAG, "Stop To AutoRoll");
            }
        }
    }

    public class BannerDataAdapter extends AbstractC0984a {
        private View mCurrentView;

        private BannerDataAdapter() {
        }

        private void bindItemView(RecommendCard recommendCard, UpdateRecommendItemView updateRecommendItemView, Bitmap bitmap) {
            if (bitmap != null) {
                updateRecommendItemView.setBackground(bitmap, BannerPictureType.PHONE_PORTRAIT);
            }
            if (TextUtils.isEmpty(recommendCard.getRemark())) {
                updateRecommendItemView.setTitleVisible(false);
            } else {
                updateRecommendItemView.setTitle(recommendCard.getRemark());
                updateRecommendItemView.setTitleVisible(true);
            }
            if (TextUtils.isEmpty(recommendCard.getDescription())) {
                updateRecommendItemView.setSubTitleVisible(false);
            } else {
                updateRecommendItemView.setSubTitle(recommendCard.getDescription());
                updateRecommendItemView.setSubTitleVisible(true);
            }
            if (TextUtils.isEmpty(recommendCard.getButton())) {
                updateRecommendItemView.setButtonVisible(false);
            } else {
                updateRecommendItemView.setButton(recommendCard.getButton());
                updateRecommendItemView.setButtonVisible(true);
            }
        }

        @Override // androidx.viewpager.widget.AbstractC0984a
        public void destroyItem(ViewGroup viewGroup, int i10, Object obj) {
            if (obj instanceof UpdateRecommendItemView) {
                viewGroup.removeView((UpdateRecommendItemView) obj);
            }
        }

        @Override // androidx.viewpager.widget.AbstractC0984a
        public void finishUpdate(ViewGroup viewGroup) {
            if (BannerViewPager.this.mViewPager.getCurrentItem() == getCount() - 1) {
                Message messageObtain = Message.obtain();
                messageObtain.what = 0;
                BannerViewPager.this.mScrollEndHandler.sendMessageDelayed(messageObtain, 5000L);
            }
        }

        @Override // androidx.viewpager.widget.AbstractC0984a
        public int getCount() {
            return BannerViewPager.this.mBannerAdList == null ? 0 : 3000;
        }

        @Override // androidx.viewpager.widget.AbstractC0984a
        public float getPageWidth(int i10) {
            return super.getPageWidth(i10);
        }

        @Override // androidx.viewpager.widget.AbstractC0984a
        public Object instantiateItem(ViewGroup viewGroup, int i10) throws C1414k {
            RecommendCard recommendCard;
            Bitmap bitmapM70501B;
            if (BannerViewPager.this.mBannerAdList == null || BannerViewPager.this.mBannerAdList.size() == 0) {
                C11839m.m70686d(BannerViewPager.TAG, "mBannerAdList instantiateItem is null");
                return viewGroup;
            }
            int size = i10 % BannerViewPager.this.mBannerAdList.size();
            if (C11842p.m70765S0()) {
                size = (BannerViewPager.this.mBannerAdList.size() - 1) - size;
            }
            RecommendCard recommendCard2 = (RecommendCard) BannerViewPager.this.mBannerAdList.get(size);
            UpdateRecommendItemView updateRecommendItemView = new UpdateRecommendItemView(BannerViewPager.this.mContext, recommendCard2);
            try {
                recommendCard = (RecommendCard) BannerViewPager.this.mBannerAdList.get(size);
            } catch (Exception e10) {
                C11839m.m70687e(BannerViewPager.TAG, "decode banner failed:" + e10.toString());
                BannerViewPager.this.notifyDecodeFailed();
            }
            if (recommendCard == null) {
                throw new C1414k("configObject null");
            }
            String suitablePicturePath = RecommendCardManager.getInstance().getSuitablePicturePath(recommendCard.getLandscapePicturePath(), recommendCard.getPortraitPicturePath());
            if (!TextUtils.isEmpty(suitablePicturePath)) {
                bitmapM70501B = C11829c.m70501B(suitablePicturePath);
            } else {
                if (TextUtils.isEmpty(recommendCard.getAdvertId())) {
                    throw new C1414k("picture url null");
                }
                C11839m.m70688i(BannerViewPager.TAG, " enter RecommendPpsView");
                bitmapM70501B = null;
            }
            if (bitmapM70501B == null && TextUtils.isEmpty(recommendCard.getAdvertId())) {
                throw new C1414k("brand market picture path null");
            }
            if (TextUtils.isEmpty(recommendCard.getAdvertId())) {
                bindItemView(recommendCard2, updateRecommendItemView, bitmapM70501B);
                updateRecommendItemView.setImageViewTag(size);
                viewGroup.addView(updateRecommendItemView);
                return updateRecommendItemView;
            }
            C11839m.m70688i(BannerViewPager.TAG, " enter RecommendPpsView");
            RecommendPpsView recommendPpsView = new RecommendPpsView(BannerViewPager.this.mContext, RecommendCardConstants.Entrance.BUY, recommendCard2.getAd());
            viewGroup.addView(recommendPpsView);
            return recommendPpsView;
        }

        @Override // androidx.viewpager.widget.AbstractC0984a
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // androidx.viewpager.widget.AbstractC0984a
        public void setPrimaryItem(ViewGroup viewGroup, int i10, Object obj) {
            if (obj instanceof View) {
                this.mCurrentView = (View) obj;
            }
        }
    }

    public interface BannerViewClickListener {
        void bannerViewClick(int i10, RecommendCard recommendCard, String str, float f10);
    }

    public interface CallBackBlur {
        void blurView(View view);
    }

    public BannerViewPager(Context context) {
        this(context, null);
    }

    private void clearDotsView() {
        List<ImageView> list = this.mDotList;
        if (list != null) {
            list.clear();
        }
        LinearLayout linearLayout = this.mDotLl;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
    }

    private void initBannerAdapter() {
        this.portraitAdapter = new BannerDataAdapter();
        this.landscapeAdapter = new BannerDataAdapter();
    }

    private void initData() {
        this.mDotList = new ArrayList();
        this.mAutoRollRunnable = new AutoRollRunnable();
        this.mHandler = new Handler(Looper.getMainLooper());
        initBannerAdapter();
        refreshBannerViewData();
        this.mScreenWidth = C11842p.m70749N(getContext());
        this.mScreenHeight = C11842p.m70746M(getContext());
    }

    private void initListener() {
        this.mViewPager.setOnPageChangeListener(this);
        this.mGestureDetector = new GestureDetector(this.mContext, this.onGestureListener);
        this.mViewPager.setOnTouchListener(new View.OnTouchListener() { // from class: com.huawei.android.hicloud.ui.uiextend.BannerViewPager.3
            boolean canStop = true;

            /* JADX WARN: Removed duplicated region for block: B:13:0x0043  */
            @Override // android.view.View.OnTouchListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) throws android.content.res.Resources.NotFoundException {
                /*
                    r5 = this;
                    com.huawei.android.hicloud.ui.uiextend.BannerViewPager r6 = com.huawei.android.hicloud.p088ui.uiextend.BannerViewPager.this
                    android.view.GestureDetector r6 = com.huawei.android.hicloud.p088ui.uiextend.BannerViewPager.access$300(r6)
                    r6.onTouchEvent(r7)
                    int r6 = r7.getAction()
                    java.lang.String r7 = "BannerViewPager"
                    r0 = 0
                    r1 = 1
                    if (r6 == 0) goto La0
                    r2 = 2
                    if (r6 == r1) goto L43
                    if (r6 == r2) goto L1d
                    r3 = 3
                    if (r6 == r3) goto L43
                    goto Ld4
                L1d:
                    boolean r6 = r5.canStop
                    if (r6 == 0) goto Ld4
                    com.huawei.android.hicloud.ui.uiextend.BannerViewPager r6 = com.huawei.android.hicloud.p088ui.uiextend.BannerViewPager.this
                    com.huawei.android.hicloud.ui.uiextend.BannerViewPager$BannerDataAdapter r7 = com.huawei.android.hicloud.p088ui.uiextend.BannerViewPager.access$400(r6)
                    android.view.View r7 = com.huawei.android.hicloud.ui.uiextend.BannerViewPager.BannerDataAdapter.access$500(r7)
                    com.huawei.android.hicloud.ui.uiextend.BannerViewPager r1 = com.huawei.android.hicloud.p088ui.uiextend.BannerViewPager.this
                    android.content.res.Resources r1 = r1.getResources()
                    int r2 = com.huawei.android.p073ds.R$drawable.selected_foreground_hmos_pressed_rectangle
                    android.graphics.drawable.Drawable r1 = r1.getDrawable(r2)
                    com.huawei.android.hicloud.p088ui.uiextend.BannerViewPager.access$600(r6, r7, r1)
                    com.huawei.android.hicloud.ui.uiextend.BannerViewPager r6 = com.huawei.android.hicloud.p088ui.uiextend.BannerViewPager.this
                    r6.stopRoll()
                    r5.canStop = r0
                    goto Ld4
                L43:
                    com.huawei.android.hicloud.ui.uiextend.BannerViewPager r6 = com.huawei.android.hicloud.p088ui.uiextend.BannerViewPager.this
                    com.huawei.android.hicloud.ui.uiextend.BannerViewPager$BannerDataAdapter r3 = com.huawei.android.hicloud.p088ui.uiextend.BannerViewPager.access$400(r6)
                    android.view.View r3 = com.huawei.android.hicloud.ui.uiextend.BannerViewPager.BannerDataAdapter.access$500(r3)
                    r4 = 0
                    com.huawei.android.hicloud.p088ui.uiextend.BannerViewPager.access$600(r6, r3, r4)
                    r5.canStop = r1
                    com.huawei.android.hicloud.ui.uiextend.BannerViewPager r6 = com.huawei.android.hicloud.p088ui.uiextend.BannerViewPager.this
                    java.util.concurrent.CopyOnWriteArrayList r6 = com.huawei.android.hicloud.p088ui.uiextend.BannerViewPager.access$900(r6)
                    if (r6 == 0) goto L85
                    com.huawei.android.hicloud.ui.uiextend.BannerViewPager r6 = com.huawei.android.hicloud.p088ui.uiextend.BannerViewPager.this
                    java.util.concurrent.CopyOnWriteArrayList r6 = com.huawei.android.hicloud.p088ui.uiextend.BannerViewPager.access$900(r6)
                    int r6 = r6.size()
                    if (r6 < r2) goto L85
                    com.huawei.android.hicloud.ui.uiextend.BannerViewPager r6 = com.huawei.android.hicloud.p088ui.uiextend.BannerViewPager.this
                    com.huawei.android.hicloud.ui.uiextend.BannerViewPager$AutoRollRunnable r6 = com.huawei.android.hicloud.p088ui.uiextend.BannerViewPager.access$800(r6)
                    if (r6 == 0) goto L85
                    com.huawei.android.hicloud.ui.uiextend.BannerViewPager r6 = com.huawei.android.hicloud.p088ui.uiextend.BannerViewPager.this
                    boolean r6 = r6.isPageInForeground()
                    if (r6 == 0) goto L85
                    java.lang.String r6 = "auto run start with ACTION_CANCEL"
                    p514o9.C11839m.m70688i(r7, r6)
                    com.huawei.android.hicloud.ui.uiextend.BannerViewPager r6 = com.huawei.android.hicloud.p088ui.uiextend.BannerViewPager.this
                    com.huawei.android.hicloud.ui.uiextend.BannerViewPager$AutoRollRunnable r6 = com.huawei.android.hicloud.p088ui.uiextend.BannerViewPager.access$800(r6)
                    r6.start()
                L85:
                    com.huawei.android.hicloud.ui.uiextend.BannerViewPager r6 = com.huawei.android.hicloud.p088ui.uiextend.BannerViewPager.this
                    com.huawei.android.hicloud.p088ui.uiextend.BannerViewPager.access$702(r6, r0)
                    com.huawei.android.hicloud.ui.uiextend.BannerViewPager r6 = com.huawei.android.hicloud.p088ui.uiextend.BannerViewPager.this
                    boolean r6 = com.huawei.android.hicloud.p088ui.uiextend.BannerViewPager.access$1000(r6)
                    if (r6 != 0) goto Ld4
                    com.huawei.android.hicloud.ui.uiextend.BannerViewPager r6 = com.huawei.android.hicloud.p088ui.uiextend.BannerViewPager.this
                    boolean r6 = com.huawei.android.hicloud.p088ui.uiextend.BannerViewPager.access$1100(r6)
                    if (r6 != 0) goto Ld4
                    com.huawei.android.hicloud.ui.uiextend.BannerViewPager r5 = com.huawei.android.hicloud.p088ui.uiextend.BannerViewPager.this
                    com.huawei.android.hicloud.p088ui.uiextend.BannerViewPager.access$000(r5)
                    goto Ld4
                La0:
                    com.huawei.android.hicloud.ui.uiextend.BannerViewPager r6 = com.huawei.android.hicloud.p088ui.uiextend.BannerViewPager.this
                    com.huawei.android.hicloud.ui.uiextend.BannerViewPager$BannerDataAdapter r2 = com.huawei.android.hicloud.p088ui.uiextend.BannerViewPager.access$400(r6)
                    android.view.View r2 = com.huawei.android.hicloud.ui.uiextend.BannerViewPager.BannerDataAdapter.access$500(r2)
                    com.huawei.android.hicloud.ui.uiextend.BannerViewPager r3 = com.huawei.android.hicloud.p088ui.uiextend.BannerViewPager.this
                    android.content.res.Resources r3 = r3.getResources()
                    int r4 = com.huawei.android.p073ds.R$drawable.selected_foreground_hmos_pressed_rectangle
                    android.graphics.drawable.Drawable r3 = r3.getDrawable(r4)
                    com.huawei.android.hicloud.p088ui.uiextend.BannerViewPager.access$600(r6, r2, r3)
                    com.huawei.android.hicloud.ui.uiextend.BannerViewPager r6 = com.huawei.android.hicloud.p088ui.uiextend.BannerViewPager.this
                    com.huawei.android.hicloud.p088ui.uiextend.BannerViewPager.access$702(r6, r1)
                    com.huawei.android.hicloud.ui.uiextend.BannerViewPager r6 = com.huawei.android.hicloud.p088ui.uiextend.BannerViewPager.this
                    com.huawei.android.hicloud.ui.uiextend.BannerViewPager$AutoRollRunnable r6 = com.huawei.android.hicloud.p088ui.uiextend.BannerViewPager.access$800(r6)
                    if (r6 == 0) goto Ld4
                    java.lang.String r6 = "auto run stop with ACTION_DOWN"
                    p514o9.C11839m.m70688i(r7, r6)
                    com.huawei.android.hicloud.ui.uiextend.BannerViewPager r5 = com.huawei.android.hicloud.p088ui.uiextend.BannerViewPager.this
                    com.huawei.android.hicloud.ui.uiextend.BannerViewPager$AutoRollRunnable r5 = com.huawei.android.hicloud.p088ui.uiextend.BannerViewPager.access$800(r5)
                    r5.stop()
                Ld4:
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.p088ui.uiextend.BannerViewPager.ViewOnTouchListenerC41083.onTouch(android.view.View, android.view.MotionEvent):boolean");
            }
        });
    }

    private void initTalkbak(View view) {
        C9603h0.m59902p0(view, accessibilityDelegateCompat);
    }

    private void initView() {
        View.inflate(this.mContext, R$layout.banner_layout, this);
        this.mViewPager = (CustomViewPager) C12809f.m76831d(this, R$id.vp_banner);
        Resources resources = this.mContext.getResources();
        this.mViewPager.setPageMargin((int) (resources != null ? resources.getDimension(R$dimen.cloud_space_48_dp) : 0.0f));
        initTalkbak(this.mViewPager);
        this.mDotLl = (LinearLayout) C12809f.m76831d(this, R$id.ll_dot);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyDecodeFailed() {
        Base64DecodeFailedListener base64DecodeFailedListener = this.base64DecodeFailedListener;
        if (base64DecodeFailedListener != null) {
            base64DecodeFailedListener.mo24105a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportAction(String str, float f10) {
        C13223b.m79475c(C0213f.m1377a(), "banner_view_click", str, C13452e.m80781L().m80971t0(), "6");
        UBAAnalyze.m29959T("PVC", "banner_view_click", "1", "35", str, "6");
        LinkedHashMap linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
        linkedHashMapM79499C.put(NotifyConstants.CloudStorageConstants.AD_NAME_KEY, str);
        linkedHashMapM79499C.put(HNConstants.C4906BI.BI_PERCENTAGE, String.valueOf(f10));
        C13227f.m79492i1().m79591l0("mecloud_main_click_banner", linkedHashMapM79499C);
        UBAAnalyze.m29958S("PVC", "mecloud_main_click_banner", "1", "35", linkedHashMapM79499C);
    }

    private void setDotsImage(ImageView imageView, int i10) {
        if (C11842p.m70765S0()) {
            if (i10 == this.mBannerAdList.size() - 1) {
                imageView.setBackgroundResource(R$drawable.right_page_dot_select);
                return;
            } else {
                imageView.setBackgroundResource(R$drawable.ic_indicator_unactivated);
                return;
            }
        }
        if (i10 == 0) {
            imageView.setBackgroundResource(R$drawable.right_page_dot_select);
        } else {
            imageView.setBackgroundResource(R$drawable.ic_indicator_unactivated);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setForeground(View view, Drawable drawable) {
        HiCloudRoundRectImageView hiCloudRoundRectImageView;
        if (!(view instanceof ViewGroup) || (hiCloudRoundRectImageView = (HiCloudRoundRectImageView) ((ViewGroup) view).findViewById(R$id.recommend_item_bg)) == null) {
            return;
        }
        hiCloudRoundRectImageView.setForeground(drawable);
    }

    private void setIndiactorView(float f10, int i10) {
        if (f10 <= RADIUS_OFFSET_HEAD && !this.isSmallToBig) {
            this.mColorImage = this.mViewPager.findViewWithTag(Integer.valueOf(i10));
            this.isSmallToBig = true;
            this.isBigToSmall = false;
        } else {
            if (f10 <= RADIUS_OFFSET_HEAD || this.isBigToSmall) {
                return;
            }
            this.mColorImage = this.mViewPager.findViewWithTag(Integer.valueOf(i10 + 1));
            this.isBigToSmall = true;
            this.isSmallToBig = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBanner() throws Resources.NotFoundException {
        C11839m.m70688i(TAG, "updateBanner");
        if (this.mBannerAdList.isEmpty()) {
            C11839m.m70687e(TAG, "mBannerAdList is empty");
            return;
        }
        stopRoll();
        try {
            if (this.mBannerAdList.size() > 10) {
                C11839m.m70688i(TAG, "mBannerAdList size=" + this.mBannerAdList.size());
                int size = this.mBannerAdList.size() - 10;
                for (int i10 = 0; i10 < size; i10++) {
                    this.mBannerAdList.remove(10);
                }
            }
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "delete mBannerAdList error: " + e10.getMessage());
        }
        C11839m.m70688i(TAG, "mBannerAdList size after remove=" + this.mBannerAdList.size());
        clearDotsView();
        if (this.mBannerAdList.size() >= 2) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            for (int i11 = 0; i11 < this.mBannerAdList.size(); i11++) {
                ImageView imageView = new ImageView(this.mContext);
                setDotsImage(imageView, i11);
                layoutParams.setMargins(0, 0, C11842p.m70840n(this.mContext, 8), 0);
                layoutParams.gravity = 17;
                imageView.setLayoutParams(layoutParams);
                this.mDotLl.addView(imageView);
                this.mDotList.add(imageView);
            }
        }
        this.mViewPager.setScrollEnable();
        this.mViewPager.setAdapter(this.mAdapter);
        this.mAdapter.notifyDataSetChanged();
        if (C11842p.m70765S0()) {
            this.mViewPager.setCurrentItem(99 - (100 % this.mBannerAdList.size()));
        } else {
            this.mViewPager.setCurrentItem(100 - (100 % this.mBannerAdList.size()));
        }
        this.isUpdate = true;
        if (isPageInForeground()) {
            startRoll();
        }
    }

    public void clearBannerData() {
        this.mBannerAdList.clear();
        this.mAdapter.notifyDataSetChanged();
    }

    public String getBannerIds() {
        ArrayList arrayList = new ArrayList();
        CopyOnWriteArrayList<RecommendCard> copyOnWriteArrayList = this.mBannerAdList;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            Iterator<RecommendCard> it = this.mBannerAdList.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getActivityId());
            }
        }
        return arrayList.toString();
    }

    public String getBannerPercentages() {
        ArrayList arrayList = new ArrayList();
        CopyOnWriteArrayList<RecommendCard> copyOnWriteArrayList = this.mBannerAdList;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            for (int i10 = 0; i10 < this.mBannerAdList.size(); i10++) {
                arrayList.add(String.valueOf(-1));
            }
        }
        return arrayList.toString();
    }

    public boolean isPageInForeground() {
        Activity activity = this.startActivity;
        if (activity == null) {
            C11839m.m70687e(TAG, "activity is null");
            return false;
        }
        if (C0209d.m1181J0(activity)) {
            return true;
        }
        C11839m.m70687e(TAG, "activity not Foreground");
        return false;
    }

    public void notifyDataSetChanged() {
        this.mAdapter.notifyDataSetChanged();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopRoll();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.round((View.MeasureSpec.getSize(i10) - (this.mContext != null ? ((int) C11842p.m70844o(r3, 24)) * 2 : 0)) * C9492a.m59357h().m59364i()), 1073741824);
        setMeasuredDimension(i10, iMakeMeasureSpec);
        super.onMeasure(i10, iMakeMeasureSpec);
    }

    @Override // androidx.viewpager.widget.ViewPager.InterfaceC0980i
    public void onPageScrollStateChanged(int i10) throws Resources.NotFoundException {
        if (i10 != 0) {
            this.isScrolling = true;
            return;
        }
        this.isScrolling = false;
        if (this.isUpdate) {
            return;
        }
        updateBanner();
    }

    @Override // androidx.viewpager.widget.ViewPager.InterfaceC0980i
    public void onPageScrolled(int i10, float f10, int i11) {
        if (i11 != 0) {
            setIndiactorView(f10, i10);
        } else {
            this.mColorImage = this.mViewPager.findViewWithTag(Integer.valueOf(this.mViewPager.getCurrentItem()));
        }
        CallBackBlur callBackBlur = this.callListener;
        if (callBackBlur == null) {
            return;
        }
        callBackBlur.blurView(this.mColorImage);
    }

    @Override // androidx.viewpager.widget.ViewPager.InterfaceC0980i
    public void onPageSelected(int i10) {
        CopyOnWriteArrayList<RecommendCard> copyOnWriteArrayList;
        C11839m.m70686d(TAG, "onPageSelected");
        CopyOnWriteArrayList<RecommendCard> copyOnWriteArrayList2 = this.mBannerAdList;
        if (copyOnWriteArrayList2 != null && copyOnWriteArrayList2.isEmpty()) {
            C11839m.m70686d(TAG, "onPageSelected mUrlList is empty");
            return;
        }
        List<ImageView> list = this.mDotList;
        if (list == null || list.isEmpty() || this.prePosition < 0) {
            return;
        }
        int size = this.mDotList.size();
        if (this.prePosition >= size) {
            this.prePosition = size - 1;
        }
        this.mDotList.get(this.prePosition).setBackgroundResource(R$drawable.ic_indicator_unactivated);
        int i11 = i10 % size;
        this.mDotList.get(i11).setBackgroundResource(R$drawable.right_page_dot_select);
        this.prePosition = i11;
        if (this.mViewPager == null || (copyOnWriteArrayList = this.mBannerAdList) == null || copyOnWriteArrayList.isEmpty()) {
            return;
        }
        int currentItem = this.mViewPager.getCurrentItem() % this.mBannerAdList.size();
        if (C11842p.m70765S0()) {
            currentItem = (this.mBannerAdList.size() - 1) - currentItem;
        }
        if (currentItem < this.mBannerAdList.size()) {
            C2783d.m16096M0(this.mViewPager, this.mBannerAdList.get(currentItem), currentItem, C11842p.f.PERCENT_20);
        }
    }

    public void refreshAdapter() {
        if (this.mScreenWidth == C11842p.m70749N(getContext()) && this.mScreenHeight == C11842p.m70746M(getContext())) {
            return;
        }
        C11839m.m70688i(TAG, "screen size has changed.");
        this.mScreenWidth = C11842p.m70749N(getContext());
        this.mScreenHeight = C11842p.m70746M(getContext());
        initBannerAdapter();
    }

    public void refreshBannerViewData() {
        if (C11842p.m70753O0(this.mContext)) {
            this.mAdapter = this.landscapeAdapter;
        } else {
            this.mAdapter = this.portraitAdapter;
        }
    }

    public void reportCurrentPage(C11842p.f fVar) {
        CopyOnWriteArrayList<RecommendCard> copyOnWriteArrayList = this.mBannerAdList;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() >= 2) {
            int i10 = this.prePosition;
            if (i10 < 0 || i10 >= this.mBannerAdList.size()) {
                return;
            }
            C2783d.m16096M0(this.mViewPager, this.mBannerAdList.get(this.prePosition), this.prePosition, fVar);
            return;
        }
        C11839m.m70688i(TAG, "scrollDisableReport cards size is:" + this.mBannerAdList.size());
        for (int i11 = 0; i11 < this.mBannerAdList.size(); i11++) {
            C2783d.m16096M0(this.mViewPager, this.mBannerAdList.get(i11), i11, fVar);
        }
    }

    public void setBannerData(List<RecommendCard> list) throws Resources.NotFoundException {
        if (list == null) {
            C11839m.m70687e(TAG, "bannerAdList is null");
            return;
        }
        C11839m.m70688i(TAG, "setBannerData isScrolling:" + this.isScrolling + " isPress:" + this.isPress);
        CopyOnWriteArrayList<RecommendCard> copyOnWriteArrayList = this.mBannerAdList;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.equals(list)) {
            C11839m.m70688i(TAG, "bannerAdList not changed");
            return;
        }
        this.mBannerAdList.clear();
        this.mBannerAdList.addAll(list);
        if (this.isScrolling || this.isPress) {
            this.isUpdate = false;
        } else {
            this.isUpdate = true;
            updateBanner();
        }
    }

    public void setBase64DecodeFailedListener(Base64DecodeFailedListener base64DecodeFailedListener) {
        this.base64DecodeFailedListener = base64DecodeFailedListener;
    }

    public void setCallBack(CallBackBlur callBackBlur) {
        this.callListener = callBackBlur;
    }

    public void setOnBannerViewClickListener(BannerViewClickListener bannerViewClickListener) {
        this.bannerViewClickListener = bannerViewClickListener;
    }

    public void setStartActivity(Activity activity) {
        this.startActivity = activity;
    }

    public void startRoll() {
        AutoRollRunnable autoRollRunnable;
        C11839m.m70688i(TAG, "startRoll");
        CopyOnWriteArrayList<RecommendCard> copyOnWriteArrayList = this.mBannerAdList;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() < 2 || (autoRollRunnable = this.mAutoRollRunnable) == null) {
            return;
        }
        autoRollRunnable.start();
    }

    public void stopRoll() {
        C11839m.m70688i(TAG, "stopRoll");
        AutoRollRunnable autoRollRunnable = this.mAutoRollRunnable;
        if (autoRollRunnable != null) {
            autoRollRunnable.stop();
        }
    }

    public void updateCallBack(CallBackBlur callBackBlur) {
        setCallBack(callBackBlur);
    }

    public void updateOnBannerViewClickListener(BannerViewClickListener bannerViewClickListener) {
        setOnBannerViewClickListener(bannerViewClickListener);
    }

    public BannerViewPager(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BannerViewPager(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mBannerAdList = new CopyOnWriteArrayList<>();
        this.prePosition = 0;
        this.isSmallToBig = false;
        this.isBigToSmall = false;
        this.isScrolling = false;
        this.isUpdate = true;
        this.isPress = false;
        this.mScrollEndHandler = new Handler() { // from class: com.huawei.android.hicloud.ui.uiextend.BannerViewPager.1
            @Override // android.os.Handler
            public void handleMessage(Message message) throws Resources.NotFoundException {
                if (message.what != 0) {
                    C11839m.m70686d(BannerViewPager.TAG, "not end scroll");
                } else {
                    BannerViewPager.this.updateBanner();
                }
            }
        };
        this.onGestureListener = new GestureDetector.SimpleOnGestureListener() { // from class: com.huawei.android.hicloud.ui.uiextend.BannerViewPager.4
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                int currentItem = BannerViewPager.this.mViewPager.getCurrentItem();
                if (BannerViewPager.this.bannerViewClickListener != null && BannerViewPager.this.mBannerAdList != null && currentItem != 0) {
                    int size = currentItem % BannerViewPager.this.mBannerAdList.size();
                    if (C11842p.m70765S0()) {
                        size = (BannerViewPager.this.mBannerAdList.size() - 1) - size;
                    }
                    C11839m.m70686d(BannerViewPager.TAG, "i is " + size);
                    RecommendCard recommendCard = (RecommendCard) BannerViewPager.this.mBannerAdList.get(size);
                    String activityId = recommendCard.getActivityId();
                    String activityId2 = recommendCard.getActivityId();
                    if (TextUtils.equals(recommendCard.getNotifyTypeAndUriGoto().getNotifyType(), NotifyConstants.HICLOUD_PPS)) {
                        return super.onSingleTapUp(motionEvent);
                    }
                    C13223b.m79475c(C0213f.m1377a(), "banner_view_click", activityId, C13452e.m80781L().m80971t0(), "6");
                    UBAAnalyze.m29959T("PVC", "banner_view_click", "1", "35", activityId, "6");
                    if (!TextUtils.isEmpty(activityId2)) {
                        activityId = activityId2;
                    }
                    BannerViewPager.this.reportAction(activityId, -1.0f);
                    C2783d.m16092K0(recommendCard, false);
                    BannerViewPager.this.bannerViewClickListener.bannerViewClick(size, recommendCard, activityId, -1.0f);
                }
                return super.onSingleTapUp(motionEvent);
            }
        };
        this.mContext = context;
        initView();
        initData();
        initListener();
    }
}
