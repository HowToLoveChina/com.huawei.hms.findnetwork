package com.huawei.android.hicloud.p088ui.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Scroller;
import android.widget.Toast;
import androidx.viewpager.widget.AbstractC0984a;
import androidx.viewpager.widget.ViewPager;
import com.huawei.android.hicloud.agd.ads.AdParametersExt;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.manager.IconManager;
import com.huawei.android.hicloud.p088ui.uiextend.CustomViewPager;
import com.huawei.android.hicloud.p088ui.uiextend.RecommendItemView;
import com.huawei.android.hicloud.p088ui.uiextend.RecommendPpsView;
import com.huawei.android.hicloud.p088ui.uilistener.RecommendTextLinkTouchListener;
import com.huawei.android.p073ds.R$dimen;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import com.huawei.hicloud.notification.constants.BannerPictureType;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.constants.RecommendCardConstants;
import com.huawei.hicloud.notification.manager.RecommendCardManager;
import com.huawei.hicloud.notification.p106db.bean.NotifyTypeAndUriGoto;
import com.huawei.hicloud.notification.p106db.bean.RecommendCard;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hms.network.embedded.C5914f2;
import com.huawei.openalliance.p169ad.constant.MimeType;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import fj.C9718g;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0213f;
import p273f0.C9582a;
import p273f0.C9603h0;
import p292fn.C9733f;
import p304g0.C9832l;
import p329h7.C10121i;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11841o;
import p514o9.C11842p;
import p562q0.C12269b;
import p684un.C13227f;
import p709vj.C13452e;
import p742wj.C13612b;
import p778xk.C13823d;
import p805yb.C13933c;
import sk.C12809f;

/* loaded from: classes3.dex */
public class RecommendFragment extends Fragment implements ViewPager.InterfaceC0980i, View.OnClickListener, RecommendTextLinkTouchListener {

    /* renamed from: s */
    public static C9582a f18115s = new C3962b();

    /* renamed from: a */
    public Context f18116a;

    /* renamed from: b */
    public RelativeLayout f18117b;

    /* renamed from: c */
    public CustomViewPager f18118c;

    /* renamed from: e */
    public RunnableC3965e f18120e;

    /* renamed from: g */
    public List<ImageView> f18122g;

    /* renamed from: h */
    public LinearLayout f18123h;

    /* renamed from: i */
    public Handler f18124i;

    /* renamed from: j */
    public GestureDetector f18125j;

    /* renamed from: n */
    public View f18129n;

    /* renamed from: p */
    public int f18131p;

    /* renamed from: d */
    public List<RecommendItemView> f18119d = new ArrayList();

    /* renamed from: f */
    public int f18121f = 8;

    /* renamed from: k */
    public ArrayList<RecommendCard> f18126k = new ArrayList<>();

    /* renamed from: l */
    public ArrayList<Bitmap> f18127l = new ArrayList<>();

    /* renamed from: m */
    public int f18128m = 0;

    /* renamed from: o */
    public boolean f18130o = false;

    /* renamed from: q */
    public ViewTreeObserver.OnScrollChangedListener f18132q = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.huawei.android.hicloud.ui.fragment.e
        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public final void onScrollChanged() {
            this.f18331a.m24162G();
        }
    };

    /* renamed from: r */
    public GestureDetector.OnGestureListener f18133r = new C3964d();

    public static class RecommendScroller extends Scroller {
        public RecommendScroller(Context context) {
            super(context);
        }

        @Override // android.widget.Scroller
        public void startScroll(int i10, int i11, int i12, int i13, int i14) {
            super.startScroll(i10, i11, i12, i13, 300);
        }

        public RecommendScroller(Context context, Interpolator interpolator) {
            super(context, interpolator);
        }

        @Override // android.widget.Scroller
        public void startScroll(int i10, int i11, int i12, int i13) {
            super.startScroll(i10, i11, i12, i13, 300);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.fragment.RecommendFragment$a */
    public class ViewOnTouchListenerC3961a implements View.OnTouchListener {
        public ViewOnTouchListenerC3961a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (RecommendFragment.this.f18118c.getCurrentItem() == 0 && RecommendFragment.this.f18118c.getChildCount() == 0) {
                return false;
            }
            return RecommendFragment.this.f18118c.dispatchTouchEvent(motionEvent);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.fragment.RecommendFragment$b */
    public class C3962b extends C9582a {
        @Override // p273f0.C9582a
        public void onInitializeAccessibilityNodeInfo(View view, C9832l c9832l) {
            super.onInitializeAccessibilityNodeInfo(view, c9832l);
            c9832l.m61065U(RelativeLayout.class.getName());
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.fragment.RecommendFragment$c */
    public class ViewOnTouchListenerC3963c implements View.OnTouchListener {

        /* renamed from: a */
        public boolean f18135a = true;

        public ViewOnTouchListenerC3963c() {
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0040  */
        @Override // android.view.View.OnTouchListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean onTouch(android.view.View r4, android.view.MotionEvent r5) {
            /*
                r3 = this;
                com.huawei.android.hicloud.ui.fragment.RecommendFragment r4 = com.huawei.android.hicloud.p088ui.fragment.RecommendFragment.this
                android.view.GestureDetector r4 = com.huawei.android.hicloud.p088ui.fragment.RecommendFragment.m24172k(r4)
                r4.onTouchEvent(r5)
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.String r0 = "mViewPager setOnTouchListener onTouch: "
                r4.append(r0)
                int r0 = r5.getAction()
                r4.append(r0)
                java.lang.String r4 = r4.toString()
                java.lang.String r0 = "RecommendFragment"
                p514o9.C11839m.m70686d(r0, r4)
                int r4 = r5.getAction()
                r5 = 0
                if (r4 == 0) goto L64
                r0 = 2
                r1 = 1
                if (r4 == r1) goto L40
                if (r4 == r0) goto L34
                r2 = 3
                if (r4 == r2) goto L40
                goto L69
            L34:
                boolean r4 = r3.f18135a
                if (r4 == 0) goto L69
                com.huawei.android.hicloud.ui.fragment.RecommendFragment r4 = com.huawei.android.hicloud.p088ui.fragment.RecommendFragment.this
                r4.m24191N()
                r3.f18135a = r5
                goto L69
            L40:
                r3.f18135a = r1
                com.huawei.android.hicloud.ui.fragment.RecommendFragment r4 = com.huawei.android.hicloud.p088ui.fragment.RecommendFragment.this
                java.util.List r4 = com.huawei.android.hicloud.p088ui.fragment.RecommendFragment.m24173l(r4)
                if (r4 == 0) goto L69
                com.huawei.android.hicloud.ui.fragment.RecommendFragment r4 = com.huawei.android.hicloud.p088ui.fragment.RecommendFragment.this
                java.util.List r4 = com.huawei.android.hicloud.p088ui.fragment.RecommendFragment.m24173l(r4)
                int r4 = r4.size()
                if (r4 < r0) goto L69
                com.huawei.android.hicloud.ui.fragment.RecommendFragment r4 = com.huawei.android.hicloud.p088ui.fragment.RecommendFragment.this
                com.huawei.android.hicloud.ui.fragment.RecommendFragment$e r4 = com.huawei.android.hicloud.p088ui.fragment.RecommendFragment.m24174m(r4)
                if (r4 == 0) goto L69
                com.huawei.android.hicloud.ui.fragment.RecommendFragment r3 = com.huawei.android.hicloud.p088ui.fragment.RecommendFragment.this
                r3.m24190M()
                goto L69
            L64:
                com.huawei.android.hicloud.ui.fragment.RecommendFragment r3 = com.huawei.android.hicloud.p088ui.fragment.RecommendFragment.this
                r3.m24191N()
            L69:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.p088ui.fragment.RecommendFragment.ViewOnTouchListenerC3963c.onTouch(android.view.View, android.view.MotionEvent):boolean");
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.fragment.RecommendFragment$d */
    public class C3964d extends GestureDetector.SimpleOnGestureListener {
        public C3964d() {
        }

        /* renamed from: b */
        public final boolean m24201b(final Intent intent, String str) {
            if (!NotifyConstants.FM_CLEAR.equals(str)) {
                return true;
            }
            IconManager iconManager = new IconManager(RecommendFragment.this.f18116a);
            if (iconManager.m16463w(iconManager.m16456p())) {
                return true;
            }
            C13227f.m79492i1().m79567R("mecloud_filemanager_icon_is_not_exist", new LinkedHashMap<>());
            UBAAnalyze.m29943D("CKC", "mecloud_filemanager_icon_is_not_exist");
            if (iconManager.m16434A("filemanagerLastTime")) {
                iconManager.m16450R(new IconManager.CallBack() { // from class: com.huawei.android.hicloud.ui.fragment.f
                    @Override // com.huawei.android.hicloud.manager.IconManager.CallBack
                    /* renamed from: a */
                    public final void mo16466a() {
                        this.f18332a.m24203d(intent);
                    }
                });
                return false;
            }
            RecommendFragment.this.startActivity(intent);
            return false;
        }

        /* renamed from: c */
        public final boolean m24202c(RecommendCard recommendCard) {
            if (!RecommendCardConstants.ActivityType.CAMPAIGN_ACTIVITY_CENTER.equals(recommendCard.getActivityType()) || C9718g.m60602t().m60612J(RecommendFragment.this.f18116a)) {
                return true;
            }
            Toast.makeText(RecommendFragment.this.f18116a, R$string.campaign_close_toast, 0).show();
            return false;
        }

        /* renamed from: d */
        public final /* synthetic */ void m24203d(Intent intent) {
            RecommendFragment.this.startActivity(intent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            Activity activity = RecommendFragment.this.getActivity();
            if (activity == null) {
                C11839m.m70687e("RecommendFragment", "activity is null");
                return super.onSingleTapUp(motionEvent);
            }
            if (C13612b.m81829B().m81886t(activity)) {
                C11839m.m70687e("RecommendFragment", "ST is invalid, click banner disable");
                return super.onSingleTapUp(motionEvent);
            }
            if (RecommendFragment.this.f18119d == null || RecommendFragment.this.f18119d.size() == 0) {
                C11839m.m70687e("RecommendFragment", "recommendItemViewList size intvalid");
                return super.onSingleTapUp(motionEvent);
            }
            int currentItem = RecommendFragment.this.f18118c.getCurrentItem();
            if (RecommendFragment.this.f18119d.size() >= 2 && RecommendFragment.this.f18131p != 0 && motionEvent.getX() > RecommendFragment.this.f18131p) {
                C11839m.m70688i("RecommendFragment", "click right card");
                currentItem++;
            }
            int size = currentItem % RecommendFragment.this.f18119d.size();
            if (C11842p.m70765S0()) {
                size = (RecommendFragment.this.f18119d.size() - 1) - size;
            }
            C11839m.m70688i("RecommendFragment", "i is " + size);
            if (size >= RecommendFragment.this.f18126k.size()) {
                return super.onSingleTapUp(motionEvent);
            }
            RecommendCard recommendCard = (RecommendCard) RecommendFragment.this.f18126k.get(size);
            if (recommendCard != null) {
                NotifyTypeAndUriGoto notifyTypeAndUriGoto = recommendCard.getNotifyTypeAndUriGoto();
                if (notifyTypeAndUriGoto != null) {
                    String notifyType = notifyTypeAndUriGoto.getNotifyType();
                    String notifyUri = notifyTypeAndUriGoto.getNotifyUri();
                    C11839m.m70688i("RecommendFragment", "notifyType: " + notifyType + ", notifyUri: " + notifyUri);
                    if (TextUtils.equals(notifyType, "nps")) {
                        RecommendFragment.this.m24180z();
                        return super.onSingleTapUp(motionEvent);
                    }
                    if (TextUtils.equals(notifyType, NotifyConstants.HICLOUD_KA)) {
                        RecommendFragment.this.m24179y(notifyUri, recommendCard);
                        return super.onSingleTapUp(motionEvent);
                    }
                    if (!TextUtils.equals(notifyType, NotifyConstants.HICLOUD_PPS) && m24202c(recommendCard)) {
                        Intent intentM70543S = C11829c.m70543S(notifyType, notifyUri, false, recommendCard);
                        if (intentM70543S != null) {
                            try {
                                intentM70543S.putExtra("recommend_card_activity_id", recommendCard.getActivityId());
                                intentM70543S.putExtra("recommend_card_activity_type", recommendCard.getActivityType());
                                intentM70543S.putExtra("recommend_card_entrance", recommendCard.getEntrance());
                                RecommendFragment.this.m24195t(intentM70543S, notifyType, C10121i.m63035a());
                                if (m24201b(intentM70543S, notifyUri)) {
                                    RecommendFragment.this.startActivity(intentM70543S);
                                }
                                C2783d.m16092K0(recommendCard, false);
                            } catch (Exception e10) {
                                C11839m.m70687e("RecommendFragment", "startActivity exception: " + e10.getMessage());
                                C11842p.m70808f(RecommendFragment.this.getActivity(), notifyType, notifyUri, R$string.upgrade_filemanager_tip);
                            }
                        } else {
                            C11839m.m70687e("RecommendFragment", "intent is null");
                        }
                    }
                    return super.onSingleTapUp(motionEvent);
                }
                C11839m.m70687e("RecommendFragment", "uriGoto is null");
            }
            return super.onSingleTapUp(motionEvent);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.fragment.RecommendFragment$f */
    public class C3966f extends AbstractC0984a {
        public C3966f() {
        }

        @Override // androidx.viewpager.widget.AbstractC0984a
        public void destroyItem(ViewGroup viewGroup, int i10, Object obj) {
            if (obj instanceof View) {
                viewGroup.removeView((View) obj);
            }
        }

        @Override // androidx.viewpager.widget.AbstractC0984a
        public void finishUpdate(ViewGroup viewGroup) {
        }

        @Override // androidx.viewpager.widget.AbstractC0984a
        public int getCount() {
            if (RecommendFragment.this.f18119d == null) {
                return 0;
            }
            return RecommendFragment.this.f18119d.size() == 1 ? 1 : 3000;
        }

        @Override // androidx.viewpager.widget.AbstractC0984a
        public int getItemPosition(Object obj) {
            return super.getItemPosition(obj);
        }

        @Override // androidx.viewpager.widget.AbstractC0984a
        public float getPageWidth(int i10) {
            return super.getPageWidth(i10);
        }

        @Override // androidx.viewpager.widget.AbstractC0984a
        public Object instantiateItem(ViewGroup viewGroup, int i10) {
            if (RecommendFragment.this.f18119d == null || RecommendFragment.this.f18119d.size() == 0) {
                C11839m.m70686d("RecommendFragment", "mBannerAdList instantiateItem is null");
                return viewGroup;
            }
            int size = i10 % RecommendFragment.this.f18119d.size();
            if (RecommendFragment.this.f18121f != 0) {
                size %= RecommendFragment.this.f18121f;
            }
            if (C11842p.m70765S0()) {
                size = (RecommendFragment.this.f18119d.size() - 1) - size;
            }
            if (size >= RecommendFragment.this.f18126k.size()) {
                C11839m.m70687e("RecommendFragment", "mResultPosition:" + size);
                return viewGroup;
            }
            RecommendCard recommendCard = (RecommendCard) RecommendFragment.this.f18126k.get(size);
            Bitmap bitmap = (Bitmap) RecommendFragment.this.f18127l.get(size);
            if (!TextUtils.isEmpty(recommendCard.getAdvertId())) {
                View recommendPpsView = new RecommendPpsView(RecommendFragment.this.f18116a, RecommendCardConstants.Entrance.HOMEPAGE, recommendCard.getAd());
                viewGroup.addView(recommendPpsView);
                return recommendPpsView;
            }
            RecommendItemView recommendItemView = new RecommendItemView(RecommendFragment.this.f18116a, recommendCard, RecommendFragment.this.f18119d.size(), RecommendFragment.this.f18131p != 0);
            recommendItemView.setImageViewTag(size);
            RecommendFragment.this.m24194s(recommendCard, recommendItemView, bitmap);
            viewGroup.addView(recommendItemView);
            return recommendItemView;
        }

        @Override // androidx.viewpager.widget.AbstractC0984a
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        public /* synthetic */ C3966f(RecommendFragment recommendFragment, ViewOnTouchListenerC3961a viewOnTouchListenerC3961a) {
            this();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.fragment.RecommendFragment$g */
    public static class C3967g implements PrivilegedAction {

        /* renamed from: a */
        public Field f18141a;

        public C3967g(Field field) {
            this.f18141a = field;
        }

        @Override // java.security.PrivilegedAction
        public Object run() throws SecurityException {
            this.f18141a.setAccessible(true);
            return null;
        }
    }

    /* renamed from: D */
    private void m24160D() {
        this.f18118c.setOnPageChangeListener(this);
        this.f18125j = new GestureDetector(this.f18116a, this.f18133r);
        this.f18118c.setOnTouchListener(new ViewOnTouchListenerC3963c());
    }

    /* renamed from: F */
    private void m24161F() {
        this.f18117b = (RelativeLayout) C12809f.m76831d(this.f18129n, R$id.rl_banner);
        this.f18118c = (CustomViewPager) C12809f.m76831d(this.f18129n, R$id.vp_banner);
        this.f18124i = new Handler(Looper.getMainLooper());
        Activity activity = getActivity();
        this.f18116a = activity;
        Resources resources = activity.getResources();
        this.f18118c.setPageMargin((int) (resources != null ? resources.getDimension(R$dimen.cloud_space_8_dp) : 0.0f));
        m24184E(this.f18118c);
        this.f18123h = (LinearLayout) C12809f.m76831d(this.f18129n, R$id.ll_dot);
        this.f18122g = new ArrayList();
        this.f18117b.setOnTouchListener(new ViewOnTouchListenerC3961a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G */
    public /* synthetic */ void m24162G() {
        if (!C11842p.f.PERCENT_80.m70892b(this.f18118c)) {
            m24191N();
            this.f18130o = false;
        } else {
            if (this.f18130o) {
                return;
            }
            C11839m.m70686d("RecommendFragment", "UIUtil.isVisibleToUser");
            m24190M();
            m24186I(C11842p.f.PERCENT_0);
            this.f18130o = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y */
    public void m24179y(String str, RecommendCard recommendCard) {
        Uri uri = Uri.parse(str);
        Intent intent = new Intent("android.intent.action.VIEW", uri);
        intent.setData(uri);
        intent.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        intent.addFlags(C5914f2.f26733f);
        try {
            startActivity(intent);
            C2783d.m16086H0(recommendCard, false);
            C11841o.m70708d(this.f18116a, getString(R$string.main_jump_third_party), 0);
        } catch (Exception e10) {
            C11839m.m70687e("RecommendFragment", "startActivity ka exception: " + e10.getMessage());
            C2783d.m16084G0(recommendCard, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z */
    public void m24180z() {
        try {
            C13227f.m79492i1().m79585f0("nps_banner_click", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "nps_banner_click", "1", "66");
            RecommendCardManager.getInstance().removeNpsRecommandCard(RecommendCardConstants.Entrance.HOMEPAGE, false);
            startActivity(C13933c.m83668n().m83684q());
        } catch (Exception e10) {
            C11839m.m70687e("RecommendFragment", "gotoNpsWebView exception: " + e10.toString());
        }
    }

    /* renamed from: A */
    public void m24181A(ArrayList<RecommendCard> arrayList) {
        m24182B(arrayList, false);
    }

    /* renamed from: B */
    public void m24182B(ArrayList<RecommendCard> arrayList, boolean z10) throws IllegalAccessException, NoSuchFieldException, Resources.NotFoundException, IllegalArgumentException {
        C11839m.m70688i("RecommendFragment", "recommendCards initData configChanged:" + z10);
        if (arrayList == null) {
            C11839m.m70687e("RecommendFragment", "recommendCards is null!");
            return;
        }
        if (z10 || !arrayList.equals(this.f18126k)) {
            C11839m.m70686d("RecommendFragment", "recommendCards data changed!");
            this.f18126k = arrayList;
            this.f18131p = m24197v();
            m24199x(arrayList);
            m24183C();
            C3966f c3966f = new C3966f(this, null);
            if (this.f18118c == null) {
                C11839m.m70687e("RecommendFragment", "mViewPager null");
                return;
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            Context context = this.f18116a;
            layoutParams.height = C11842p.m70840n(context, C0209d.m1195O(context) >= 1.75f ? RecommendCardConstants.Num.BANNER_HEIGHT_FONT_SCALE : RecommendCardConstants.Num.PICTURE_SECOND_HEIGHT);
            layoutParams.rightMargin = this.f18131p;
            this.f18118c.setLayoutParams(layoutParams);
            if ((this.f18119d.size() <= 2 || this.f18131p == 0) && this.f18131p != 0) {
                this.f18118c.setScrollDisable();
                this.f18118c.setMainRecommendTwoCards(true);
            } else {
                this.f18118c.setScrollEnable();
                this.f18118c.setMainRecommendTwoCards(false);
            }
            this.f18118c.setAdapter(c3966f);
            this.f18118c.setOffscreenPageLimit(3);
            if (this.f18119d.size() > 0) {
                int size = 100 % this.f18119d.size();
                int i10 = 100 - size;
                if (C11842p.m70765S0()) {
                    i10 = 99 - size;
                    if (this.f18119d.size() >= 2 && this.f18131p != 0) {
                        i10 = 98 - size;
                    }
                }
                m24189L();
                this.f18118c.setCurrentItem(i10);
            }
            c3966f.notifyDataSetChanged();
            m24190M();
        }
    }

    /* renamed from: C */
    public final void m24183C() {
        m24196u();
        if (this.f18119d.size() < 2 || this.f18131p != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        for (int i10 = 0; i10 < this.f18119d.size(); i10++) {
            ImageView imageView = new ImageView(this.f18116a);
            if (C11842p.m70765S0()) {
                if (i10 == this.f18119d.size() - 1) {
                    imageView.setBackgroundResource(R$drawable.recommend_page_dot_select);
                } else {
                    imageView.setBackgroundResource(R$drawable.recommend_page_dot_unselect);
                }
            } else if (i10 == 0) {
                imageView.setBackgroundResource(R$drawable.recommend_page_dot_select);
            } else {
                imageView.setBackgroundResource(R$drawable.recommend_page_dot_unselect);
            }
            layoutParams.setMargins(0, 0, C11842p.m70840n(this.f18116a, 8), 0);
            layoutParams.gravity = 17;
            imageView.setLayoutParams(layoutParams);
            LinearLayout linearLayout = this.f18123h;
            if (linearLayout != null) {
                linearLayout.addView(imageView);
            }
            if (this.f18122g == null) {
                this.f18122g = new ArrayList();
            }
            this.f18122g.add(imageView);
        }
    }

    /* renamed from: E */
    public final void m24184E(View view) {
        C9603h0.m59902p0(view, f18115s);
    }

    /* renamed from: H */
    public final void m24185H() {
        if (this.f18118c == null) {
            C11839m.m70689w("RecommendFragment", "removeOnScrollChangedListener mViewPager is null");
            return;
        }
        C11839m.m70686d("RecommendFragment", "removeOnScrollChangedListener");
        ViewTreeObserver viewTreeObserver = this.f18118c.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            C11839m.m70686d("RecommendFragment", "removeOnScrollChangedListener isAlive");
            viewTreeObserver.removeOnScrollChangedListener(this.f18132q);
        }
    }

    /* renamed from: I */
    public void m24186I(C11842p.f fVar) {
        ArrayList<RecommendCard> arrayList = this.f18126k;
        if (arrayList == null || arrayList.isEmpty()) {
            C11839m.m70687e("RecommendFragment", "scrollDisableReport recommendCards is null");
            return;
        }
        if (this.f18126k.size() >= 2 && (this.f18126k.size() != 2 || this.f18131p == 0)) {
            int i10 = this.f18128m;
            if (i10 < 0 || i10 >= this.f18126k.size()) {
                return;
            }
            C11839m.m70686d("RecommendFragment", "report currentPage");
            C2783d.m16096M0(this.f18118c, this.f18126k.get(this.f18128m), this.f18128m, fVar);
            return;
        }
        C11839m.m70688i("RecommendFragment", "scrollDisableReport cards size is: " + this.f18126k.size());
        for (int i11 = 0; i11 < this.f18126k.size(); i11++) {
            C2783d.m16096M0(this.f18118c, this.f18126k.get(i11), i11, fVar);
        }
    }

    /* renamed from: J */
    public final void m24187J(RecommendCard recommendCard, RecommendItemView recommendItemView, Bitmap bitmap) {
        if (bitmap == null) {
            C11839m.m70688i("RecommendFragment", "id: " + recommendCard.getActivityId() + " bitmap null");
            bitmap = RecommendCardManager.getInstance().getPictureBitmapUserCache(recommendCard.getPictureSecondPath());
        }
        if (bitmap != null) {
            recommendItemView.setBackground(bitmap, BannerPictureType.PICTURE_SECOND);
        }
        if (RecommendCardConstants.ActivityType.CAMPAIGN_ACTIVITY_CENTER.equals(recommendCard.getActivityType())) {
            m24188K(recommendItemView, recommendCard);
        }
    }

    /* renamed from: K */
    public final void m24188K(RecommendItemView recommendItemView, RecommendCard recommendCard) {
        String pictureSecondPath = recommendCard.getPictureSecondPath();
        Drawable drawableM82907C = C13823d.m82904y().m82907C(pictureSecondPath);
        if (drawableM82907C == null || recommendItemView == null) {
            C11839m.m70687e("RecommendFragment", "setRecommendCardGif drawable or itemView is null ");
            return;
        }
        C11839m.m70686d("RecommendFragment", "setRecommendCardGif type " + C13823d.m82904y().m82933q(pictureSecondPath));
        if (MimeType.GIF.equals(C13823d.m82904y().m82933q(pictureSecondPath))) {
            if (drawableM82907C instanceof AnimatedImageDrawable) {
                ((AnimatedImageDrawable) drawableM82907C).start();
            }
            recommendItemView.setBackground(drawableM82907C);
        }
    }

    /* renamed from: L */
    public final void m24189L() throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            AccessController.doPrivileged(new C3967g(declaredField));
            declaredField.set(this.f18118c, new RecommendScroller(C0213f.m1377a(), new C12269b()));
        } catch (Exception e10) {
            C11839m.m70687e("RecommendFragment", "setRecommendScroller exception:" + e10.toString());
        }
    }

    /* renamed from: M */
    public void m24190M() {
        RunnableC3965e runnableC3965e;
        Activity activity = getActivity();
        if (activity == null) {
            C11839m.m70687e("RecommendFragment", "activity null");
            return;
        }
        if (!C0209d.m1181J0(activity)) {
            C11839m.m70687e("RecommendFragment", "not Foreground");
            return;
        }
        RunnableC3965e runnableC3965e2 = this.f18120e;
        if (runnableC3965e2 != null && runnableC3965e2.f18138a) {
            C11839m.m70688i("RecommendFragment", "already rolling");
            return;
        }
        List<RecommendItemView> list = this.f18119d;
        if (list != null && list.size() == 2 && this.f18131p != 0) {
            C11839m.m70688i("RecommendFragment", "two cards and not phone portrait, not roll");
            return;
        }
        C11839m.m70688i("RecommendFragment", "startRoll");
        List<RecommendItemView> list2 = this.f18119d;
        if (list2 == null || list2.size() < 2 || (runnableC3965e = this.f18120e) == null) {
            return;
        }
        runnableC3965e.m24204a();
    }

    /* renamed from: N */
    public void m24191N() {
        C11839m.m70688i("RecommendFragment", "stopRoll");
        RunnableC3965e runnableC3965e = this.f18120e;
        if (runnableC3965e != null) {
            runnableC3965e.m24205c();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.uilistener.RecommendTextLinkTouchListener
    /* renamed from: a */
    public void mo24192a(MotionEvent motionEvent) {
        C11839m.m70688i("RecommendFragment", "onTextLinkTouched");
        if (motionEvent != null && motionEvent.getAction() == 0) {
            m24191N();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C11839m.m70688i("RecommendFragment", "onClick");
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws IllegalAccessException, NoSuchFieldException, Resources.NotFoundException, IllegalArgumentException {
        super.onConfigurationChanged(configuration);
        C11839m.m70688i("RecommendFragment", "onConfigurationChanged");
        m24191N();
        m24182B(this.f18126k, true);
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C11839m.m70688i("RecommendFragment", "onCreateView");
        if (C0209d.m1195O(getContext()) >= 1.75f) {
            this.f18129n = layoutInflater.inflate(R$layout.recommend_fragment_layout_font_scale, viewGroup, false);
        } else {
            this.f18129n = layoutInflater.inflate(R$layout.recommend_fragment_layout, viewGroup, false);
        }
        Activity activity = getActivity();
        this.f18116a = activity;
        HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
        if (hiCloudSysParamMapM60757p != null) {
            int homepageBannerNum = hiCloudSysParamMapM60757p.getHomepageBannerNum();
            C11839m.m70688i("RecommendFragment", "homepageBannerNum: " + homepageBannerNum);
            if (homepageBannerNum > 0 && homepageBannerNum <= 10) {
                this.f18121f = homepageBannerNum + 1;
            } else if (homepageBannerNum > 10) {
                this.f18121f = 11;
            }
        }
        if (activity == null || activity.isFinishing()) {
            C11839m.m70687e("RecommendFragment", "hostActivity isfinishing");
        } else {
            getFragmentManager().beginTransaction().show(this).commitAllowingStateLoss();
        }
        this.f18120e = new RunnableC3965e(this, null);
        m24161F();
        m24160D();
        return this.f18129n;
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        C11839m.m70686d("RecommendFragment", "onDestroy");
        m24191N();
        this.f18120e = null;
        List<RecommendItemView> list = this.f18119d;
        if (list != null) {
            list.clear();
        }
        ArrayList<RecommendCard> arrayList = this.f18126k;
        if (arrayList != null) {
            arrayList.clear();
        }
        ArrayList<Bitmap> arrayList2 = this.f18127l;
        if (arrayList2 != null) {
            arrayList2.clear();
        }
        List<ImageView> list2 = this.f18122g;
        if (list2 != null) {
            list2.clear();
        }
        m24185H();
    }

    @Override // androidx.viewpager.widget.ViewPager.InterfaceC0980i
    public void onPageScrollStateChanged(int i10) {
        if (1 == i10) {
            C13227f.m79492i1().m79585f0("recommend_card_manual_slide", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "recommend_card_manual_slide", "1", "66");
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.InterfaceC0980i
    public void onPageScrolled(int i10, float f10, int i11) {
    }

    @Override // androidx.viewpager.widget.ViewPager.InterfaceC0980i
    public void onPageSelected(int i10) {
        C11839m.m70686d("RecommendFragment", "onPageSelected");
        List<RecommendItemView> list = this.f18119d;
        if (list != null && list.isEmpty()) {
            C11839m.m70686d("RecommendFragment", "onPageSelected mUrlList is empty");
            return;
        }
        List<ImageView> list2 = this.f18122g;
        if (list2 != null && !list2.isEmpty() && this.f18128m >= 0) {
            int size = this.f18122g.size();
            if (this.f18128m >= size) {
                this.f18128m = size - 1;
            }
            this.f18122g.get(this.f18128m).setBackgroundResource(R$drawable.recommend_page_dot_unselect);
            int i11 = i10 % size;
            this.f18122g.get(i11).setBackgroundResource(R$drawable.recommend_page_dot_select);
            this.f18128m = i11;
        }
        CustomViewPager customViewPager = this.f18118c;
        if (customViewPager == null || this.f18119d == null) {
            return;
        }
        int currentItem = customViewPager.getCurrentItem() % this.f18119d.size();
        if (C11842p.m70765S0()) {
            currentItem = (this.f18119d.size() - 1) - currentItem;
        }
        ArrayList<RecommendCard> arrayList = this.f18126k;
        if (arrayList == null || currentItem >= arrayList.size()) {
            return;
        }
        C2783d.m16096M0(this.f18118c, this.f18126k.get(currentItem), currentItem, C11842p.f.PERCENT_80);
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        m24191N();
        m24185H();
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        C11839m.m70686d("RecommendFragment", "onResume()");
        m24190M();
        m24186I(C11842p.f.PERCENT_0);
        m24193r();
    }

    /* renamed from: r */
    public final void m24193r() {
        C11839m.m70686d("RecommendFragment", "addOnScrollChangedListener");
        CustomViewPager customViewPager = this.f18118c;
        if (customViewPager == null) {
            C11839m.m70689w("RecommendFragment", "amViewPager is null");
            return;
        }
        ViewTreeObserver viewTreeObserver = customViewPager.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            C11839m.m70686d("RecommendFragment", "addOnScrollChangedListener isAlive");
            viewTreeObserver.addOnScrollChangedListener(this.f18132q);
        }
    }

    /* renamed from: s */
    public final void m24194s(RecommendCard recommendCard, RecommendItemView recommendItemView, Bitmap bitmap) {
        if (TextUtils.isEmpty(recommendCard.getAdvertId())) {
            m24187J(recommendCard, recommendItemView, bitmap);
            if (TextUtils.isEmpty(recommendCard.getRemark())) {
                recommendItemView.setTitleVisible(false);
            } else {
                recommendItemView.setTitle(recommendCard.getRemark());
                recommendItemView.setTitleVisible(true);
            }
            if (TextUtils.isEmpty(recommendCard.getDescription())) {
                recommendItemView.setSubTitleVisible(false);
            } else {
                recommendItemView.setSubTitle(recommendCard.getDescription(), recommendCard.getDescriptionEndLink(), recommendCard);
            }
            if (TextUtils.isEmpty(recommendCard.getButton())) {
                recommendItemView.setButtonVisible(false);
            } else {
                recommendItemView.setButton(recommendCard.getButton());
                recommendItemView.setButtonVisible(true);
            }
            recommendItemView.resetContentView();
            recommendItemView.setTextLinkTouchListener(this);
        }
    }

    /* renamed from: t */
    public final void m24195t(Intent intent, String str, AdParametersExt adParametersExt) {
        if (!NotifyConstants.HICLOUD_DLAPP.equals(str)) {
            C11839m.m70688i("RecommendFragment", "not dlApp type");
        } else {
            if (adParametersExt == null) {
                C11839m.m70688i("RecommendFragment", "adParameters is null");
                return;
            }
            intent.putExtra("agd_resource_enable", adParametersExt.getEnabled());
            intent.putExtra("agd_resource_slot_id", adParametersExt.getAgdAdid());
            intent.putExtra("pps_threshold", adParametersExt.getThreshold());
        }
    }

    /* renamed from: u */
    public final void m24196u() {
        List<ImageView> list = this.f18122g;
        if (list != null) {
            list.clear();
        }
        LinearLayout linearLayout = this.f18123h;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
    }

    /* renamed from: v */
    public final int m24197v() {
        ArrayList<RecommendCard> arrayList = this.f18126k;
        if (arrayList != null && arrayList.size() >= 2) {
            Context context = this.f18116a;
            if ((context instanceof Activity) && C11842p.m70806e1((Activity) context)) {
                return m24198w();
            }
        }
        return 0;
    }

    /* renamed from: w */
    public final int m24198w() {
        return C11842p.m70840n(this.f18116a, (getResources().getConfiguration().screenWidthDp / 2) + 4) - getResources().getDimensionPixelOffset(R$dimen.main_recommend_card_margin);
    }

    /* renamed from: x */
    public final void m24199x(ArrayList<RecommendCard> arrayList) {
        this.f18119d.clear();
        this.f18127l.clear();
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        int i10 = 0;
        boolean z10 = this.f18131p != 0;
        Iterator<RecommendCard> it = arrayList.iterator();
        while (it.hasNext()) {
            RecommendCard next = it.next();
            if (i10 >= this.f18121f) {
                return;
            }
            RecommendItemView recommendItemView = new RecommendItemView(this.f18116a, next, size, z10);
            recommendItemView.setImageViewTag(i10);
            if (TextUtils.isEmpty(next.getAdvertId())) {
                String pictureSecondPath = next.getPictureSecondPath();
                if (!TextUtils.isEmpty(pictureSecondPath)) {
                    this.f18127l.add(RecommendCardManager.getInstance().getPictureBitmapUserCache(pictureSecondPath));
                }
            } else {
                String ppsPicturePathFromSp = RecommendCardManager.getInstance().getPpsPicturePathFromSp(C11842p.m70812g(this.f18116a, next.getAd().getImageInfos()), RecommendCardConstants.Entrance.HOMEPAGE);
                if (!TextUtils.isEmpty(ppsPicturePathFromSp)) {
                    this.f18127l.add(RecommendCardManager.getInstance().getPictureBitmapUserCache(ppsPicturePathFromSp));
                }
            }
            if (i10 < this.f18127l.size()) {
                m24194s(next, recommendItemView, this.f18127l.get(i10));
                this.f18119d.add(recommendItemView);
            }
            i10++;
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.fragment.RecommendFragment$e */
    public class RunnableC3965e implements Runnable {

        /* renamed from: a */
        public boolean f18138a;

        public RunnableC3965e() {
            this.f18138a = false;
        }

        /* renamed from: a */
        public void m24204a() {
            if (this.f18138a) {
                return;
            }
            this.f18138a = true;
            RecommendFragment.this.f18124i.removeCallbacks(this);
            RecommendFragment.this.f18124i.postDelayed(this, 5000L);
            C11839m.m70686d("RecommendFragment", "Begin To AutoRoll");
        }

        /* renamed from: c */
        public void m24205c() {
            if (this.f18138a) {
                RecommendFragment.this.f18124i.removeCallbacks(this);
                this.f18138a = false;
                C11839m.m70686d("RecommendFragment", "Stop To AutoRoll");
            }
        }

        @Override // java.lang.Runnable
        public void run() throws IllegalAccessException, NoSuchFieldException, Resources.NotFoundException, IllegalArgumentException {
            if (this.f18138a) {
                if (!C11842p.m70765S0()) {
                    RecommendFragment.this.m24189L();
                    RecommendFragment.this.f18118c.setCurrentItem(RecommendFragment.this.f18118c.getCurrentItem() + 1);
                } else if (RecommendFragment.this.f18118c.getCurrentItem() == 0) {
                    RecommendFragment.this.m24189L();
                    if (RecommendFragment.this.f18119d != null && RecommendFragment.this.f18119d.size() > 0) {
                        RecommendFragment.this.f18118c.setCurrentItem(99 - (100 % RecommendFragment.this.f18119d.size()));
                    }
                } else {
                    RecommendFragment.this.m24189L();
                    RecommendFragment.this.f18118c.setCurrentItem(RecommendFragment.this.f18118c.getCurrentItem() - 1);
                }
                C11839m.m70686d("RecommendFragment", "getCurrentItem:" + RecommendFragment.this.f18118c.getCurrentItem());
                RecommendFragment.this.f18124i.postDelayed(this, 5000L);
            }
        }

        public /* synthetic */ RunnableC3965e(RecommendFragment recommendFragment, ViewOnTouchListenerC3961a viewOnTouchListenerC3961a) {
            this();
        }
    }
}
