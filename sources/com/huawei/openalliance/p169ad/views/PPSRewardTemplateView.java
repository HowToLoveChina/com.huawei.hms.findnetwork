package com.huawei.openalliance.p169ad.views;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.widget.Toast;
import com.huawei.hms.ads.uiengine.IRemoteCreator;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.AbstractC7558os;
import com.huawei.openalliance.p169ad.AbstractC7572pf;
import com.huawei.openalliance.p169ad.BinderC6978bv;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.C7084e;
import com.huawei.openalliance.p169ad.C7124fh;
import com.huawei.openalliance.p169ad.C7154gk;
import com.huawei.openalliance.p169ad.C7331je;
import com.huawei.openalliance.p169ad.C7517nl;
import com.huawei.openalliance.p169ad.C7521np;
import com.huawei.openalliance.p169ad.C7580pn;
import com.huawei.openalliance.p169ad.C7723ur;
import com.huawei.openalliance.p169ad.C7724us;
import com.huawei.openalliance.p169ad.C7849uv;
import com.huawei.openalliance.p169ad.C8188vj;
import com.huawei.openalliance.p169ad.DialogInterfaceOnCancelListenerC7721up;
import com.huawei.openalliance.p169ad.DialogInterfaceOnCancelListenerC7850uw;
import com.huawei.openalliance.p169ad.InterfaceC7537oe;
import com.huawei.openalliance.p169ad.RunnableC7857vc;
import com.huawei.openalliance.p169ad.activity.PPSRewardActivity;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.RewardKeys;
import com.huawei.openalliance.p169ad.constant.RewardMethods;
import com.huawei.openalliance.p169ad.inter.data.AdLandingPageData;
import com.huawei.openalliance.p169ad.inter.data.C7305h;
import com.huawei.openalliance.p169ad.inter.data.IRewardAd;
import com.huawei.openalliance.p169ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.p169ad.inter.data.RewardEvent;
import com.huawei.openalliance.p169ad.inter.data.RewardItem;
import com.huawei.openalliance.p169ad.inter.listeners.INonwifiActionListener;
import com.huawei.openalliance.p169ad.inter.listeners.IRewardAdStatusListener;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import com.huawei.openalliance.p169ad.utils.AbstractC7846y;
import com.huawei.openalliance.p169ad.utils.C7747au;
import com.huawei.openalliance.p169ad.utils.C7748av;
import com.huawei.openalliance.p169ad.utils.C7749aw;
import com.huawei.openalliance.p169ad.utils.C7756bc;
import com.huawei.openalliance.p169ad.utils.C7780c;
import com.huawei.openalliance.p169ad.views.interfaces.IViewLifeCycle;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8108ab;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8117j;

/* loaded from: classes2.dex */
public class PPSRewardTemplateView extends AutoScaleSizeRelativeLayout implements C7331je.a, IViewLifeCycle, InterfaceC8117j {

    /* renamed from: a */
    private C7331je f36960a;

    /* renamed from: b */
    private Context f36961b;

    /* renamed from: c */
    private ViewGroup f36962c;

    /* renamed from: d */
    private C7305h f36963d;

    /* renamed from: e */
    private InterfaceC7537oe f36964e;

    /* renamed from: f */
    private ContentRecord f36965f;

    /* renamed from: g */
    private AdLandingPageData f36966g;

    /* renamed from: h */
    private PPSWebView f36967h;

    /* renamed from: i */
    private int f36968i;

    /* renamed from: j */
    private C8150t f36969j;

    /* renamed from: k */
    private Dialog f36970k;

    /* renamed from: l */
    private Dialog f36971l;

    /* renamed from: m */
    private Dialog f36972m;

    /* renamed from: n */
    private IRewardAdStatusListener f36973n;

    /* renamed from: o */
    private InterfaceC8108ab f36974o;

    /* renamed from: p */
    private C7748av f36975p;

    /* renamed from: q */
    private C7749aw f36976q;

    /* renamed from: r */
    private IRemoteCreator f36977r;

    /* renamed from: s */
    private BinderC6978bv f36978s;

    /* renamed from: t */
    private int f36979t;

    /* renamed from: u */
    private int f36980u;

    /* renamed from: v */
    private boolean f36981v;

    /* renamed from: w */
    private boolean f36982w;

    /* renamed from: x */
    private boolean f36983x;

    /* renamed from: y */
    private boolean f36984y;

    public PPSRewardTemplateView(Context context) {
        super(context);
        this.f36968i = 1;
        this.f36981v = true;
        this.f36982w = false;
        this.f36983x = true;
        this.f36984y = false;
        m49466a(context);
    }

    /* renamed from: n */
    private void m49470n() {
        if (C7521np.m46174a(this.f36965f)) {
            this.f36983x = false;
            this.f36967h.setWebViewBackgroundColor(getResources().getColor(C6849R.color.hiad_black));
            this.f36967h.m49765d();
        }
        if ("4".equals(this.f36965f.m41483ae())) {
            this.f36983x = false;
        }
        m49472q();
        m49471o();
        C7331je c7331je = this.f36960a;
        if (c7331je != null) {
            c7331je.m45276b(this.f36963d.getMinEffectiveShowTime(), this.f36963d.getMinEffectiveShowRatio());
        }
    }

    /* renamed from: o */
    private void m49471o() {
        AbstractC7185ho.m43820b("PPSRewardTView", "init pop-up");
        if (C7756bc.m47711f(this.f36963d.m44904D()) || this.f36963d.getAppInfo() == null) {
            AbstractC7185ho.m43820b("PPSRewardTView", "appInfo is null or web, skip init popup");
            return;
        }
        boolean zMo43043U = C7124fh.m43316b(this.f36961b).mo43043U();
        this.f36969j = new C8150t(getContext(), this.f36968i);
        getPopUpView().setAdPopupData(this.f36966g);
        getPopUpView().setPopUpClickListener(new C7724us(this, zMo43043U));
        getPopUpView().setDismissListener(new C7723ur(this));
    }

    /* renamed from: q */
    private void m49472q() {
        PPSWebView pPSWebView = this.f36967h;
        if (pPSWebView != null) {
            pPSWebView.setVisibility(8);
            this.f36967h.setAdLandingPageData(this.f36966g);
            m49473r();
            if (this.f36964e.mo46193b(this.f36963d) && this.f36983x) {
                this.f36967h.loadPage();
                this.f36982w = true;
            }
        }
    }

    /* renamed from: r */
    private void m49473r() {
        Context context = this.f36961b;
        C7749aw c7749aw = new C7749aw(context, this.f36966g, new AppDownloadButton(context), this.f36967h, new C8188vj(this));
        this.f36976q = c7749aw;
        c7749aw.m47669a(1);
        this.f36967h.addJavascriptInterface(this.f36976q, Constants.PPS_JS_NAME);
        this.f36967h.addJavascriptInterface(new C7747au(getContext(), AbstractC7572pf.m46743a(this.f36966g)), Constants.LANDING_JS_NAME);
        C7748av c7748av = new C7748av(getContext(), AbstractC7572pf.m46743a(this.f36966g), this.f36967h);
        this.f36975p = c7748av;
        this.f36967h.addJavascriptInterface(c7748av, Constants.APPOINT_JS_NAME);
    }

    /* renamed from: s */
    private boolean m49474s() {
        if (this.f36963d != null) {
            return false;
        }
        AbstractC7185ho.m43820b("PPSRewardTView", "ad is null! please register first");
        return true;
    }

    /* renamed from: t */
    private void m49475t() {
        long jM47566c = AbstractC7741ao.m47566c();
        String strValueOf = String.valueOf(jM47566c);
        AbstractC7185ho.m43821b("PPSRewardTView", "updateShowId: %s", strValueOf);
        C7305h c7305h = this.f36963d;
        if (c7305h != null) {
            c7305h.m44968g(false);
            this.f36963d.m44612a(false);
            this.f36963d.m44642h(strValueOf);
            this.f36963d.m44622c(jM47566c);
        }
        InterfaceC7537oe interfaceC7537oe = this.f36964e;
        if (interfaceC7537oe != null) {
            interfaceC7537oe.m46272a(strValueOf);
        }
        BinderC6978bv binderC6978bv = this.f36978s;
        if (binderC6978bv != null) {
            binderC6978bv.m41123a(jM47566c);
            Bundle bundle = new Bundle();
            bundle.putLong(RewardKeys.SHOW_TIME, jM47566c);
            this.f36978s.m41126f(RewardMethods.VIEW_PHY_START, bundle);
        }
        AdLandingPageData adLandingPageData = this.f36966g;
        if (adLandingPageData == null || this.f36967h == null) {
            return;
        }
        adLandingPageData.m44280c(strValueOf);
        this.f36966g.m44264a(jM47566c);
        this.f36967h.setAdLandingPageData(this.f36966g);
    }

    /* renamed from: u */
    private void m49476u() {
        BinderC6978bv binderC6978bv = this.f36978s;
        if (binderC6978bv != null) {
            binderC6978bv.m41126f("handleClose", null);
        }
    }

    @Override // com.huawei.openalliance.p169ad.C7331je.a
    /* renamed from: a */
    public void mo45279a() {
        BinderC6978bv binderC6978bv;
        if (m49474s() || (binderC6978bv = this.f36978s) == null) {
            return;
        }
        binderC6978bv.m41126f(RewardMethods.VIEW_START_RECORD, null);
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8118k
    public void addNonwifiActionListener(INonwifiActionListener iNonwifiActionListener) {
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8118k
    public void addRewardAdStatusListener(IRewardAdStatusListener iRewardAdStatusListener) {
        if (iRewardAdStatusListener == null) {
            return;
        }
        this.f36973n = iRewardAdStatusListener;
    }

    @Override // com.huawei.openalliance.p169ad.C7331je.a
    /* renamed from: b */
    public void mo45281b() {
        AbstractC7185ho.m43820b("PPSRewardTView", "onViewPhyShowStart.");
        if (m49474s()) {
            return;
        }
        m49475t();
        if (this.f36967h != null && this.f36964e.mo46193b(this.f36963d) && this.f36982w) {
            this.f36967h.onResume();
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8118k
    /* renamed from: c */
    public void mo49489c() {
        BinderC6978bv binderC6978bv = this.f36978s;
        if (binderC6978bv != null) {
            binderC6978bv.m41126f(RewardMethods.SHOW_CLOSE, null);
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8117j
    /* renamed from: d */
    public void mo49492d() {
        BinderC6978bv binderC6978bv = this.f36978s;
        if (binderC6978bv != null) {
            binderC6978bv.m41126f(RewardMethods.PERFORM_DOWNLOAD, null);
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.IViewLifeCycle
    public void destroyView() {
        m49469d(RewardMethods.DESTROY_VIEW);
        PPSWebView pPSWebView = this.f36967h;
        if (pPSWebView != null) {
            pPSWebView.destroy();
        }
        Dialog dialog = this.f36970k;
        if (dialog != null) {
            dialog.dismiss();
            this.f36970k = null;
        }
        BinderC6978bv binderC6978bv = this.f36978s;
        if (binderC6978bv != null) {
            binderC6978bv.m41125b();
            this.f36978s = null;
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8118k
    /* renamed from: e */
    public void mo49493e() {
        setNonwifiDialog(null);
        this.f36981v = false;
        mo49487b("showNonWifiPlay");
        resumeView();
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8118k
    /* renamed from: f */
    public void mo49494f() {
        setNonwifiDialog(null);
        m49476u();
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8118k
    /* renamed from: g */
    public void mo49495g() {
        if (this.f36967h != null && C7756bc.m47710e(this.f36963d.m44904D()) && this.f36982w) {
            this.f36967h.onStop();
        }
        m49469d(RewardMethods.STOP_VIEW);
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8118k
    public AppDownloadButton getAppDownloadButton() {
        return null;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8118k
    public C7748av getAppointJs() {
        return null;
    }

    public Dialog getDownloadDialog() {
        return this.f36972m;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8118k
    public Dialog getNonwifiDialog() {
        return this.f36971l;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8118k
    public C8150t getPopUpView() {
        return this.f36969j;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8118k
    public WebSettings getWebViewSettings() {
        PPSWebView pPSWebView = this.f36967h;
        if (pPSWebView != null) {
            return pPSWebView.getSettings();
        }
        return null;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8118k
    /* renamed from: h */
    public boolean mo49496h() {
        return false;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8117j
    /* renamed from: i */
    public void mo49497i() {
        AbstractC7817dj.m48363a(new RunnableC7857vc(this));
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8117j
    /* renamed from: j */
    public void mo49498j() {
        if (this.f36967h == null) {
            AbstractC7185ho.m43820b("PPSRewardTView", "webview is null");
            return;
        }
        AbstractC7185ho.m43820b("PPSRewardTView", "showWebView");
        if (!this.f36982w) {
            this.f36967h.loadPage();
        }
        this.f36982w = true;
        this.f36967h.onResume();
        this.f36967h.setVisibility(0);
        this.f36967h.bringToFront();
        this.f36967h.setRealOpenTime(AbstractC7741ao.m47566c());
        if ("1".equals(this.f36963d.m44949ad())) {
            AbstractC7558os.m46470i(this.f36963d.getCtrlSwitchs());
        }
        if (C7521np.m46174a(this.f36965f)) {
            ((PPSRewardActivity) getContext()).setRequestedOrientation(1);
        }
        if (this.f36984y) {
            this.f36984y = false;
            Toast.makeText(getContext(), C6849R.string.hiad_third_party_page_hint, 0).show();
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8117j
    /* renamed from: k */
    public void mo49499k() {
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8118k
    /* renamed from: l */
    public void mo49500l() {
        this.f36970k = null;
        m49476u();
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8118k
    /* renamed from: m */
    public void mo49501m() {
        this.f36970k = null;
        mo49487b(RewardMethods.SHOW_CLOSE_CONFIRM);
        resumeView();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        AbstractC7185ho.m43820b("PPSRewardTView", "onAttach");
        C7331je c7331je = this.f36960a;
        if (c7331je != null) {
            c7331je.m45301h();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        AbstractC7185ho.m43820b("PPSRewardTView", "onDetach");
        C7331je c7331je = this.f36960a;
        if (c7331je != null) {
            c7331je.m45302i();
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8118k
    public void onEvent(RewardEvent rewardEvent) {
        m49480a(rewardEvent, false);
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i10) {
        super.onVisibilityChanged(view, i10);
        C7331je c7331je = this.f36960a;
        if (c7331je != null) {
            c7331je.m45303j();
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.IViewLifeCycle
    public void pauseView() {
        m49469d(RewardMethods.PAUSE_VIEW);
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8118k
    public void removeRewardAdStatusListener() {
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.IViewLifeCycle
    public void resumeView() {
        m49469d(RewardMethods.RESUME_VIEW);
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8118k
    public void setContentRecord(ContentRecord contentRecord) {
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8117j
    public void setDownloadDialog(Dialog dialog) {
        this.f36972m = dialog;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8118k
    public void setNonwifiDialog(Dialog dialog) {
        this.f36971l = dialog;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8118k
    public void setOrientation(int i10) {
        this.f36968i = i10;
    }

    public void setPopUpView(C8150t c8150t) {
        this.f36969j = c8150t;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8118k
    public void setTemplateErrorListener(InterfaceC8108ab interfaceC8108ab) {
        this.f36974o = interfaceC8108ab;
    }

    public PPSRewardTemplateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f36968i = 1;
        this.f36981v = true;
        this.f36982w = false;
        this.f36983x = true;
        this.f36984y = false;
        m49466a(context);
    }

    /* renamed from: d */
    private void m49469d(String str) {
        BinderC6978bv binderC6978bv = this.f36978s;
        if (binderC6978bv != null) {
            binderC6978bv.m41126f(str, null);
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8117j
    /* renamed from: a */
    public void mo49477a(int i10) throws Resources.NotFoundException {
        if (this.f36970k == null) {
            if (i10 == -1) {
                i10 = this.f36980u;
            }
            Dialog dialogM48620a = AbstractC7846y.m48620a(getContext(), (String) null, getResources().getQuantityString(C6849R.plurals.hiad_reward_close_dialog_message, i10, Integer.valueOf(i10)), getResources().getString(C6849R.string.hiad_reward_close_dialog_continue), getResources().getString(C6849R.string.hiad_reward_close_dialog_close), new C7849uv(this));
            this.f36970k = dialogM48620a;
            dialogM48620a.setOnCancelListener(new DialogInterfaceOnCancelListenerC7850uw(this));
            pauseView();
        }
    }

    @Override // com.huawei.openalliance.p169ad.C7331je.a
    /* renamed from: b */
    public void mo45282b(long j10, int i10) {
        AbstractC7185ho.m43821b("PPSRewardTView", "onViewPhysicalShowEnd, duration: %s", Long.valueOf(j10));
        if (m49474s() || this.f36978s == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putLong("show_duration", j10);
        bundle.putInt("show_ratio", i10);
        this.f36978s.m41126f(RewardMethods.VIEW_PHY_END, bundle);
    }

    /* renamed from: c */
    public void m49490c(String str) {
        InterfaceC7537oe interfaceC7537oe = this.f36964e;
        if (interfaceC7537oe != null) {
            interfaceC7537oe.mo46182a(str, this.f36965f);
        }
    }

    public PPSRewardTemplateView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f36968i = 1;
        this.f36981v = true;
        this.f36982w = false;
        this.f36983x = true;
        this.f36984y = false;
        m49466a(context);
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8117j
    /* renamed from: a */
    public void mo49478a(int i10, Bundle bundle) {
        int iM43575a;
        if (this.f36973n == null) {
            AbstractC7185ho.m43823c("PPSRewardTView", "onStatusChange listener empty");
            return;
        }
        AbstractC7185ho.m43821b("PPSRewardTView", "onStatus change: %s", Integer.valueOf(i10));
        if (i10 == 1) {
            this.f36973n.onAdShown();
            return;
        }
        if (i10 == 2) {
            this.f36973n.onAdClicked();
            return;
        }
        if (i10 == 3) {
            this.f36973n.onAdCompleted();
            return;
        }
        if (i10 == 4) {
            this.f36973n.onAdClosed();
            return;
        }
        if (i10 != 6) {
            AbstractC7185ho.m43820b("PPSRewardTView", "on status change, fall to default.");
            return;
        }
        int i11 = -1;
        if (bundle != null) {
            C7154gk c7154gk = new C7154gk(bundle);
            int iM43575a2 = c7154gk.m43575a("error_code", -1);
            iM43575a = c7154gk.m43575a("error_extra", -1);
            i11 = iM43575a2;
        } else {
            iM43575a = -1;
        }
        this.f36973n.onAdError(i11, iM43575a);
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8117j
    /* renamed from: b */
    public void mo49487b(String str) {
        m49468a(str, (String) null);
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8118k
    /* renamed from: c */
    public boolean mo49491c(boolean z10) {
        String str;
        if (getDownloadDialog() != null) {
            AbstractC7185ho.m43820b("PPSRewardTView", "download dialog is displaying.");
            return true;
        }
        if (this.f36969j == null) {
            str = "show download dialog, popupView is null.";
        } else {
            if (!this.f36963d.m44947ab()) {
                AbstractC7185ho.m43820b("PPSRewardTView", "show download confirm dialog.");
                boolean zM50511a = this.f36969j.m50511a();
                if (zM50511a) {
                    pauseView();
                    AlertDialog dialog = this.f36969j.getDialog();
                    this.f36972m = dialog;
                    if (dialog != null) {
                        dialog.setOnCancelListener(new DialogInterfaceOnCancelListenerC7721up(this));
                    }
                    m49490c("127");
                }
                return zM50511a;
            }
            str = "show download dialog, hasRewarded.";
        }
        AbstractC7185ho.m43823c("PPSRewardTView", str);
        return false;
    }

    public PPSRewardTemplateView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.f36968i = 1;
        this.f36981v = true;
        this.f36982w = false;
        this.f36983x = true;
        this.f36984y = false;
        m49466a(context);
    }

    @Override // com.huawei.openalliance.p169ad.C7331je.a
    /* renamed from: a */
    public void mo45280a(long j10, int i10) {
        BinderC6978bv binderC6978bv;
        if (m49474s() || (binderC6978bv = this.f36978s) == null) {
            return;
        }
        binderC6978bv.m41126f(RewardMethods.VIEW_END_RECORD, null);
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8118k
    /* renamed from: b */
    public void mo49488b(boolean z10) {
        if (this.f36978s != null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(RewardKeys.IS_FOREGROUND, z10);
            this.f36978s.m41126f(RewardMethods.ACTIVITY_SWITCH, bundle);
        }
    }

    /* renamed from: a */
    private void m49466a(Context context) {
        this.f36961b = context;
        this.f36964e = new C7521np(context, this);
        this.f36960a = new C7331je(this, this);
        View.inflate(context, C6849R.layout.hiad_reward_v3_container_layout, this);
        PPSWebView pPSWebView = (PPSWebView) findViewById(C6849R.id.reward_webview);
        this.f36967h = pPSWebView;
        pPSWebView.setPPSWebEventCallback(C7517nl.m46150a());
        this.f36962c = (ViewGroup) findViewById(C6849R.id.reward_layout);
        this.f36977r = C7084e.m42835a(context.getApplicationContext());
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8118k
    /* renamed from: a */
    public void mo49479a(IRewardAd iRewardAd, boolean z10) {
        if (iRewardAd instanceof C7305h) {
            if (this.f36977r == null) {
                AbstractC7185ho.m43823c("PPSRewardTView", "remote creator is null");
                InterfaceC8108ab interfaceC8108ab = this.f36974o;
                if (interfaceC8108ab != null) {
                    interfaceC8108ab.mo38754a(-4);
                    return;
                }
                return;
            }
            C7305h c7305h = (C7305h) iRewardAd;
            this.f36963d = c7305h;
            ContentRecord contentRecordM46793a = C7580pn.m46793a(c7305h);
            this.f36965f = contentRecordM46793a;
            this.f36966g = new AdLandingPageData(contentRecordM46793a, this.f36961b, true);
            this.f36964e.mo46194c(this.f36963d);
            BinderC6978bv binderC6978bv = new BinderC6978bv(this.f36961b, c7305h, this);
            this.f36978s = binderC6978bv;
            View viewMo46178a = this.f36964e.mo46178a(this.f36977r, binderC6978bv, this.f36965f, this.f36963d);
            if (viewMo46178a != null) {
                addView(viewMo46178a);
                AbstractC7811dd.m48293a(this.f36961b, this.f36968i, this.f36962c);
                m49467a(c7305h);
                m49470n();
                return;
            }
            AbstractC7185ho.m43823c("PPSRewardTView", "remote view is null.");
            InterfaceC8108ab interfaceC8108ab2 = this.f36974o;
            if (interfaceC8108ab2 != null) {
                interfaceC8108ab2.mo38754a(-3);
            }
        }
    }

    /* renamed from: a */
    public void m49480a(RewardEvent rewardEvent, boolean z10) {
        if (this.f36978s != null) {
            Bundle bundle = new Bundle();
            bundle.putString(RewardKeys.EVENT_TYPE, rewardEvent.m44553a());
            bundle.putBoolean(RewardKeys.CLOSE_BTN_CLICKED, z10);
            this.f36978s.m41126f(RewardMethods.ON_EVENT, bundle);
        }
    }

    /* renamed from: a */
    private void m49467a(C7305h c7305h) {
        int iM44950ae = (int) c7305h.m44950ae();
        this.f36979t = iM44950ae;
        this.f36980u = C7521np.m46171a(this.f36961b, iM44950ae);
        this.f36983x = C7124fh.m43316b(this.f36961b).mo43047Y();
        this.f36984y = this.f36964e.mo46195c();
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8118k
    /* renamed from: a */
    public void mo49481a(Integer num) {
        C7305h c7305h;
        if (num == null || (c7305h = this.f36963d) == null || this.f36964e == null) {
            return;
        }
        int minEffectiveShowRatio = c7305h.getMinEffectiveShowRatio();
        long minEffectiveShowTime = this.f36963d.getMinEffectiveShowTime();
        boolean zM47867a = C7780c.m47867a(this.f36963d.m44627d(), num);
        if (!this.f36963d.m44933S() || (zM47867a && !this.f36963d.m44619b())) {
            AbstractC7185ho.m43821b("PPSRewardTView", "reportAdShowEvent, source: %s", num);
            InterfaceC7537oe interfaceC7537oe = this.f36964e;
            if (interfaceC7537oe != null) {
                interfaceC7537oe.mo46181a(minEffectiveShowTime, minEffectiveShowRatio, num);
            }
            if (zM47867a) {
                this.f36963d.m44612a(true);
            }
            if (this.f36963d.m44933S()) {
                return;
            }
            this.f36963d.m44968g(true);
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8118k
    /* renamed from: a */
    public void mo49482a(String str) {
        if (this.f36963d == null || this.f36961b == null || getPopUpView() == null || TextUtils.isEmpty(str)) {
            AbstractC7185ho.m43823c("PPSRewardTView", "invalid parameter");
            return;
        }
        setContentRecord(C7580pn.m46793a(this.f36963d));
        getPopUpView();
        C8150t.m50504a(this.f36961b, str, this.f36965f);
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8117j
    /* renamed from: a */
    public void mo49483a(String str, RewardItem rewardItem) {
        if (this.f36964e == null) {
            AbstractC7185ho.m43823c("PPSRewardTView", "notify reward, rewardPresenter is null");
            return;
        }
        C7305h c7305h = this.f36963d;
        if (c7305h != null && rewardItem != null) {
            c7305h.m44943a(rewardItem);
        }
        this.f36964e.mo46191b(str, this.f36963d, this.f36973n);
    }

    /* renamed from: a */
    private void m49468a(String str, String str2) {
        BinderC6978bv binderC6978bv = this.f36978s;
        if (binderC6978bv != null) {
            binderC6978bv.m41124a(str, false, str2);
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8118k
    /* renamed from: a */
    public void mo49484a(boolean z10) {
        if (this.f36978s == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean(RewardKeys.IS_WIFI, z10);
        bundle.putBoolean(RewardKeys.AD_SHOW_MOBILE_ALERT, this.f36963d.m44951af());
        bundle.putBoolean(RewardKeys.NEED_REMIND_DATA, this.f36981v);
        this.f36978s.m41126f(RewardMethods.NET_CHANGE, bundle);
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8118k
    /* renamed from: a */
    public void mo49485a(boolean z10, String str) {
        if (getDownloadDialog() != null) {
            getDownloadDialog().dismiss();
            m49468a(RewardMethods.SHOW_DOWNLOAD_CONFIRM, str);
            if (z10) {
                resumeView();
            }
            setDownloadDialog(null);
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8117j
    /* renamed from: a */
    public boolean mo49486a(int i10, MaterialClickInfo materialClickInfo) {
        InterfaceC7537oe interfaceC7537oe = this.f36964e;
        if (interfaceC7537oe != null) {
            return interfaceC7537oe.mo46186a(i10, materialClickInfo);
        }
        return false;
    }
}
