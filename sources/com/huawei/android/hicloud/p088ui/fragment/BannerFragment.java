package com.huawei.android.hicloud.p088ui.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Toast;
import ca.C1400c;
import com.huawei.android.hicloud.agd.ads.AdParametersExt;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.uiextend.BannerViewPager;
import com.huawei.android.hicloud.p088ui.uilistener.BannerShowRegionListener;
import com.huawei.android.hicloud.p088ui.uilistener.Base64DecodeFailedListener;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.constants.RecommendCardConstants;
import com.huawei.hicloud.notification.manager.RecommendCardManager;
import com.huawei.hicloud.notification.p106db.bean.NotifyTypeAndUriGoto;
import com.huawei.hicloud.notification.p106db.bean.RecommendCard;
import com.huawei.hicloud.notification.util.HiCloudLink;
import com.huawei.hms.network.embedded.C5914f2;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import fj.C9718g;
import java.util.List;
import p015ak.C0209d;
import p054cj.C1442a;
import p258ei.C9492a;
import p292fn.C9733f;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11841o;
import p514o9.C11842p;
import sk.C12809f;

/* loaded from: classes3.dex */
public class BannerFragment extends Fragment implements Base64DecodeFailedListener {

    /* renamed from: a */
    public View f18067a;

    /* renamed from: b */
    public BannerViewPager f18068b;

    /* renamed from: c */
    public C9492a f18069c;

    /* renamed from: d */
    public C3956b f18070d;

    /* renamed from: e */
    public AdParametersExt f18071e;

    /* renamed from: f */
    public BannerShowRegionListener f18072f = null;

    /* renamed from: g */
    public Handler f18073g = new HandlerC3955a();

    /* renamed from: h */
    public boolean f18074h = false;

    /* renamed from: i */
    public ViewTreeObserver.OnScrollChangedListener f18075i = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.huawei.android.hicloud.ui.fragment.b
        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public final void onScrollChanged() {
            this.f18318a.m24111j();
        }
    };

    /* renamed from: com.huawei.android.hicloud.ui.fragment.BannerFragment$a */
    public class HandlerC3955a extends Handler {
        public HandlerC3955a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 1) {
                C11839m.m70688i("BannerFragment", "UI_REFRESH_BANNER");
                return;
            }
            if (i10 == 3) {
                C11839m.m70688i("BannerFragment", "UI_INIT_REFRESH_BANNER");
                return;
            }
            if (i10 == 2) {
                C11839m.m70688i("BannerFragment", "banner config not exist");
                BannerFragment.this.m24107f();
            } else if (i10 == 4) {
                C11839m.m70688i("BannerFragment", "PREPARE_BANNER_DATA_TASK_FINISH");
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.fragment.BannerFragment$b */
    public class C3956b implements BannerViewPager.BannerViewClickListener {

        /* renamed from: a */
        public HiCloudLink f18077a;

        /* renamed from: b */
        public Context f18078b;

        /* renamed from: c */
        public Handler f18079c;

        public C3956b(Context context) {
            this.f18078b = context;
            this.f18077a = new HiCloudLink(context);
        }

        /* renamed from: a */
        public final void m24123a(String str, RecommendCard recommendCard) {
            Uri uri = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            intent.setData(uri);
            intent.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
            intent.addFlags(C5914f2.f26733f);
            try {
                this.f18078b.startActivity(intent);
                C2783d.m16086H0(recommendCard, false);
                Context context = this.f18078b;
                C11841o.m70708d(context, context.getString(R$string.main_jump_third_party), 0);
            } catch (Exception e10) {
                C11839m.m70687e("BannerViewClickListenerImp", "startActivity ka exception: " + e10.getMessage());
                C2783d.m16084G0(recommendCard, false);
            }
        }

        /* renamed from: b */
        public final boolean m24124b(RecommendCard recommendCard) {
            if (!RecommendCardConstants.ActivityType.CAMPAIGN_ACTIVITY_CENTER.equals(recommendCard.getActivityType()) || C9718g.m60602t().m60612J(this.f18078b)) {
                return true;
            }
            Toast.makeText(this.f18078b, R$string.campaign_close_toast, 0).show();
            return false;
        }

        @Override // com.huawei.android.hicloud.ui.uiextend.BannerViewPager.BannerViewClickListener
        public void bannerViewClick(int i10, RecommendCard recommendCard, String str, float f10) {
            if (recommendCard == null) {
                C11839m.m70687e("BannerViewClickListenerImp", "card is null");
                return;
            }
            NotifyTypeAndUriGoto notifyTypeAndUriGoto = recommendCard.getNotifyTypeAndUriGoto();
            if (notifyTypeAndUriGoto == null) {
                C11839m.m70687e("BannerViewClickListenerImp", "gotoObj is null");
                return;
            }
            String notifyType = notifyTypeAndUriGoto.getNotifyType();
            String notifyUri = notifyTypeAndUriGoto.getNotifyUri();
            C11839m.m70686d("BannerViewClickListenerImp", "gotoType: " + notifyType + ", gotoUri: " + notifyUri);
            if (TextUtils.equals(notifyType, NotifyConstants.HICLOUD_KA)) {
                m24123a(notifyUri, recommendCard);
                return;
            }
            if (NotifyConstants.TYPE_EXTRA_BANNER.equals(notifyType)) {
                C1400c.m8060g("UPGRADE_PAGE_BANNER_CLICK", null);
            }
            if (m24124b(recommendCard)) {
                if (this.f18079c != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("banner_name", str);
                    bundle.putString("banner_goto_type", notifyType);
                    bundle.putString("banner_goto_uri", notifyUri);
                    bundle.putFloat(HNConstants.C4906BI.BI_PERCENTAGE, f10);
                    Message message = new Message();
                    message.what = 7012;
                    message.setData(bundle);
                    this.f18079c.sendMessage(message);
                }
                try {
                    Intent intentM70543S = C11829c.m70543S(notifyType, notifyUri, false, recommendCard);
                    BannerFragment.this.m24108g(intentM70543S, notifyType);
                    if ("web".equals(notifyType)) {
                        intentM70543S.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
                    }
                    intentM70543S.putExtra("recommend_card_activity_id", recommendCard.getActivityId());
                    intentM70543S.putExtra("recommend_card_activity_type", recommendCard.getActivityType());
                    intentM70543S.putExtra("recommend_card_entrance", recommendCard.getEntrance());
                    this.f18078b.startActivity(intentM70543S);
                } catch (Exception e10) {
                    C11839m.m70687e("BannerViewClickListenerImp", "bannerViewClick ActivityNotFoundException : " + e10.toString());
                    C11842p.m70808f(this.f18078b, notifyType, notifyUri, R$string.upgrade_filemanager_tip);
                }
            }
        }

        /* renamed from: c */
        public void m24125c(int i10) {
            HiCloudLink hiCloudLink = this.f18077a;
            if (hiCloudLink != null) {
                hiCloudLink.setBackupFreq(i10);
            }
        }

        /* renamed from: d */
        public void m24126d(Handler handler) {
            this.f18079c = handler;
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.uilistener.Base64DecodeFailedListener
    /* renamed from: a */
    public void mo24105a() {
        if (this.f18068b == null) {
            C11839m.m70687e("BannerFragment", "mBanner is null");
            return;
        }
        m24107f();
        this.f18068b.clearBannerData();
        C9492a.m59356d();
        C9492a.m59357h().m59363g();
    }

    /* renamed from: e */
    public final void m24106e() {
        C11839m.m70686d("BannerFragment", "addOnScrollChangedListener");
        BannerViewPager bannerViewPager = this.f18068b;
        if (bannerViewPager == null) {
            C11839m.m70689w("BannerFragment", "addOnScrollChangedListener mBanner is null");
            return;
        }
        ViewTreeObserver viewTreeObserver = bannerViewPager.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            C11839m.m70686d("BannerFragment", "addOnScrollChangedListener isAlive");
            viewTreeObserver.addOnScrollChangedListener(this.f18075i);
        }
    }

    /* renamed from: f */
    public final void m24107f() {
        if (isAdded()) {
            C11839m.m70687e("BannerFragment", "bannerNoData");
            getFragmentManager().beginTransaction().hide(this).commitAllowingStateLoss();
            m24121t(false);
        }
    }

    /* renamed from: g */
    public final void m24108g(Intent intent, String str) {
        if (!NotifyConstants.HICLOUD_DLAPP.equals(str)) {
            C1442a.m8290i("BannerFragment", "not dlApp type");
            return;
        }
        AdParametersExt adParametersExt = this.f18071e;
        if (adParametersExt == null) {
            C1442a.m8290i("BannerFragment", "adParameters is null");
            return;
        }
        intent.putExtra("agd_resource_enable", adParametersExt.getEnabled());
        intent.putExtra("agd_resource_slot_id", this.f18071e.getAgdAdid());
        intent.putExtra("pps_threshold", this.f18071e.getThreshold());
    }

    /* renamed from: h */
    public String m24109h() {
        BannerViewPager bannerViewPager = this.f18068b;
        return bannerViewPager == null ? "" : bannerViewPager.getBannerIds();
    }

    /* renamed from: i */
    public String m24110i() {
        BannerViewPager bannerViewPager = this.f18068b;
        return bannerViewPager == null ? "" : bannerViewPager.getBannerPercentages();
    }

    /* renamed from: j */
    public final /* synthetic */ void m24111j() {
        C11842p.f fVar = C11842p.f.PERCENT_20;
        if (!fVar.m70892b(this.f18068b)) {
            m24113l();
            this.f18074h = false;
        } else {
            if (this.f18074h) {
                return;
            }
            m24122u();
            BannerViewPager bannerViewPager = this.f18068b;
            if (bannerViewPager != null) {
                bannerViewPager.reportCurrentPage(fVar);
            }
            this.f18074h = true;
        }
    }

    /* renamed from: k */
    public final void m24112k(List<RecommendCard> list) throws Resources.NotFoundException {
        HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
        int cloudSpaceBannerV2Limit = hiCloudSysParamMapM60757p != null ? hiCloudSysParamMapM60757p.getCloudSpaceBannerV2Limit() : 0;
        if (cloudSpaceBannerV2Limit <= 0) {
            C11839m.m70688i("BannerFragment", "get bannerAdList size error, use default value.");
            cloudSpaceBannerV2Limit = 7;
        }
        if (list.size() > cloudSpaceBannerV2Limit) {
            list = list.subList(0, cloudSpaceBannerV2Limit);
        }
        C11839m.m70688i("BannerFragment", "bannerAdList size " + list.size());
        if (list.size() <= 0) {
            C11839m.m70687e("BannerFragment", "banner ad list empty");
            m24107f();
            return;
        }
        BannerViewPager bannerViewPager = this.f18068b;
        if (bannerViewPager == null) {
            C11839m.m70687e("BannerFragment", "loadData mBanner is null.");
            m24107f();
            return;
        }
        bannerViewPager.refreshBannerViewData();
        this.f18068b.setBannerData(list);
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager == null) {
            C11839m.m70687e("BannerFragment", "loadData fm is null.");
        } else {
            fragmentManager.beginTransaction().show(this).commitAllowingStateLoss();
            m24121t(true);
        }
    }

    /* renamed from: l */
    public void m24113l() {
        BannerViewPager bannerViewPager = this.f18068b;
        if (bannerViewPager == null) {
            C11839m.m70687e("BannerFragment", "startRoll mBanner is null");
        } else {
            bannerViewPager.stopRoll();
        }
    }

    /* renamed from: m */
    public void m24114m() {
        if (!isAdded() || this.f18068b == null) {
            m24107f();
        } else {
            m24112k(RecommendCardManager.getInstance().getRecommendCardsFromCache(RecommendCardConstants.Entrance.BUY));
        }
    }

    /* renamed from: n */
    public void m24115n() {
        C9492a c9492a = this.f18069c;
        if (c9492a == null) {
            C11839m.m70687e("BannerFragment", "mBannerManager is null");
            return;
        }
        c9492a.m59365k();
        BannerViewPager bannerViewPager = this.f18068b;
        if (bannerViewPager == null) {
            C11839m.m70687e("BannerFragment", "mBanner is null");
            return;
        }
        bannerViewPager.clearBannerData();
        this.f18068b.refreshAdapter();
        m24114m();
    }

    /* renamed from: o */
    public final void m24116o() {
        if (this.f18068b == null) {
            C11839m.m70689w("BannerFragment", "removeOnScrollChangedListener mBanner is null");
            return;
        }
        C11839m.m70686d("BannerFragment", "removeOnScrollChangedListener");
        ViewTreeObserver viewTreeObserver = this.f18068b.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            C11839m.m70686d("BannerFragment", "removeOnScrollChangedListener isAlive");
            viewTreeObserver.removeOnScrollChangedListener(this.f18075i);
        }
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        m24116o();
        super.onConfigurationChanged(configuration);
        m24106e();
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2;
        C11839m.m70686d("BannerFragment", "superview = " + super.onCreateView(layoutInflater, viewGroup, bundle));
        View view = this.f18067a;
        if (view != null && (viewGroup2 = (ViewGroup) view.getParent()) != null) {
            viewGroup2.removeView(this.f18067a);
        }
        View viewInflate = layoutInflater.inflate(R$layout.banner_fragment_layout, viewGroup, false);
        this.f18067a = viewInflate;
        this.f18068b = (BannerViewPager) C12809f.m76831d(viewInflate, R$id.banner_view_pager);
        m24106e();
        C3956b c3956b = new C3956b(getContext());
        this.f18070d = c3956b;
        this.f18068b.setOnBannerViewClickListener(c3956b);
        this.f18068b.setBase64DecodeFailedListener(this);
        Activity activity = getActivity();
        if (activity == null || activity.isFinishing()) {
            C11839m.m70687e("BannerFragment", "hostActivity isfinishing");
        } else {
            this.f18068b.setStartActivity(activity);
            getFragmentManager().beginTransaction().hide(this).commitAllowingStateLoss();
            m24121t(false);
        }
        if (C0209d.m1166E1()) {
            C9492a c9492aM59357h = C9492a.m59357h();
            this.f18069c = c9492aM59357h;
            c9492aM59357h.m59367m(this.f18073g);
            this.f18069c.m59365k();
        }
        return this.f18067a;
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        BannerViewPager bannerViewPager = this.f18068b;
        if (bannerViewPager != null) {
            bannerViewPager.stopRoll();
        }
        C9492a.m59356d();
        m24116o();
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        BannerViewPager bannerViewPager = this.f18068b;
        if (bannerViewPager != null) {
            bannerViewPager.stopRoll();
            m24116o();
        }
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        m24122u();
        BannerViewPager bannerViewPager = this.f18068b;
        if (bannerViewPager != null) {
            bannerViewPager.reportCurrentPage(C11842p.f.PERCENT_20);
        }
        m24106e();
    }

    /* renamed from: p */
    public void m24117p(AdParametersExt adParametersExt) {
        this.f18071e = adParametersExt;
    }

    /* renamed from: q */
    public void m24118q(int i10) {
        C3956b c3956b = this.f18070d;
        if (c3956b != null) {
            c3956b.m24125c(i10);
        }
    }

    /* renamed from: r */
    public void m24119r(BannerShowRegionListener bannerShowRegionListener) {
        this.f18072f = bannerShowRegionListener;
    }

    /* renamed from: s */
    public void m24120s(Handler handler) {
        C3956b c3956b = this.f18070d;
        if (c3956b != null) {
            c3956b.m24126d(handler);
        }
    }

    /* renamed from: t */
    public final void m24121t(boolean z10) {
        BannerShowRegionListener bannerShowRegionListener = this.f18072f;
        if (bannerShowRegionListener != null) {
            bannerShowRegionListener.mo23347I(z10);
        }
    }

    /* renamed from: u */
    public void m24122u() {
        BannerViewPager bannerViewPager = this.f18068b;
        if (bannerViewPager == null) {
            C11839m.m70687e("BannerFragment", "startRoll mBanner is null");
        } else {
            bannerViewPager.startRoll();
        }
    }
}
