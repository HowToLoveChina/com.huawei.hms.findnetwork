package com.huawei.openalliance.p169ad.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.huawei.openalliance.p169ad.AbstractC7014dc;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.C6982bz;
import com.huawei.openalliance.p169ad.C7563ox;
import com.huawei.openalliance.p169ad.C7580pn;
import com.huawei.openalliance.p169ad.C7694tp;
import com.huawei.openalliance.p169ad.InterfaceC6998co;
import com.huawei.openalliance.p169ad.InterfaceC7542oj;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import com.huawei.openalliance.p169ad.inter.data.AdLandingPageData;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.inter.data.C7301d;
import com.huawei.openalliance.p169ad.inter.data.C7305h;
import com.huawei.openalliance.p169ad.inter.data.IAd;
import com.huawei.openalliance.p169ad.inter.data.INativeAd;
import com.huawei.openalliance.p169ad.inter.data.IPlacementAd;
import com.huawei.openalliance.p169ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.utils.C7746at;
import com.huawei.openalliance.p169ad.utils.C7818dk;
import com.huawei.openalliance.p169ad.utils.C7845x;
import com.huawei.openalliance.p169ad.views.AppDownloadButton;
import com.huawei.openalliance.p169ad.views.AppDownloadButtonStyle;
import com.huawei.openalliance.p169ad.views.ExtandAppDownloadButtonStyle;
import com.huawei.openalliance.p169ad.views.ExtandAppDownloadButtonStyleHm;
import com.huawei.openalliance.p169ad.views.PPSWebView;
import com.huawei.openalliance.p169ad.views.linkscroll.C8142e;
import java.io.Serializable;

/* loaded from: classes8.dex */
public class LandingDetailsActivity extends AbstractActivityC6905e {

    /* renamed from: a */
    private AppDownloadButton f31664a;

    /* renamed from: b */
    private RelativeLayout f31665b;

    /* renamed from: c */
    private PPSWebView f31666c;

    /* renamed from: d */
    private ImageView f31667d;

    /* renamed from: e */
    private InterfaceC6998co f31668e;

    /* renamed from: f */
    private IAd f31669f;

    /* renamed from: g */
    private AdLandingPageData f31670g;

    /* renamed from: h */
    private MaterialClickInfo f31671h;

    /* renamed from: i */
    private boolean f31672i;

    /* renamed from: j */
    private MaterialClickInfo f31673j;

    /* renamed from: b */
    private void m38626b() {
        this.f31664a.setSource(5);
    }

    /* renamed from: c */
    private boolean m38627c() {
        Serializable serializableExtra;
        try {
            SafeIntent safeIntent = new SafeIntent(getIntent());
            MaterialClickInfo materialClickInfo = (MaterialClickInfo) AbstractC7758be.m47739b(safeIntent.getStringExtra("click_info"), MaterialClickInfo.class, new Class[0]);
            if (materialClickInfo != null && AbstractC7806cz.m48187p(materialClickInfo.m44508c()) && materialClickInfo.m44501a() != null) {
                this.f31673j = materialClickInfo;
                AbstractC7185ho.m43818a("LandingDetailActivity", "orgClickInfo: %s", materialClickInfo.toString());
            }
            serializableExtra = safeIntent.getSerializableExtra(MapKeyNames.APP_DETAIL_DATA);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("LandingDetailActivity", "parse ad data ex: %s", th2.getClass().getSimpleName());
        }
        if (serializableExtra instanceof AdLandingPageData) {
            this.f31670g = (AdLandingPageData) serializableExtra;
            this.f31672i = true;
            return true;
        }
        if (serializableExtra instanceof IAd) {
            this.f31669f = (IAd) serializableExtra;
            this.f31672i = false;
            return true;
        }
        C7301d c7301dM41864a = AbstractC7014dc.m41864a();
        if (c7301dM41864a != null) {
            this.f31669f = c7301dM41864a;
            this.f31672i = false;
            return true;
        }
        AbstractC7185ho.m43823c("LandingDetailActivity", "start app detail activity, ad content is empty.");
        return false;
    }

    /* renamed from: d */
    private void m38628d() {
        this.f31812p = (ViewGroup) findViewById(C6849R.id.landing_activity_root);
        this.f31665b = (RelativeLayout) findViewById(C6849R.id.landing_detail_parent);
        this.f31666c = (PPSWebView) findViewById(C6849R.id.landing_details_webView);
        this.f31667d = (ImageView) findViewById(C6849R.id.landing_close_image_view);
        this.f31664a = (AppDownloadButton) findViewById(C6849R.id.app_download_btn_detail);
        m38629e();
        this.f31812p.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.activity.LandingDetailsActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LandingDetailsActivity.this.finish();
            }
        });
        this.f31667d.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.activity.LandingDetailsActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LandingDetailsActivity.this.finish();
            }
        });
    }

    /* renamed from: e */
    private void m38629e() {
        try {
            int iM48326f = AbstractC7811dd.m48326f(this);
            ViewGroup viewGroup = (ViewGroup) findViewById(C6849R.id.app_download_container);
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            layoutParams.height += iM48326f;
            viewGroup.setLayoutParams(layoutParams);
        } catch (Throwable th2) {
            AbstractC7185ho.m43821b("LandingDetailActivity", "match bar err: %s", th2.getClass().getSimpleName());
        }
    }

    /* renamed from: f */
    private void m38630f() throws Resources.NotFoundException {
        AppDownloadButton appDownloadButton;
        AppDownloadButtonStyle extandAppDownloadButtonStyle;
        if (this.f31664a == null) {
            AbstractC7185ho.m43820b("LandingDetailActivity", "appDownloadButton is null.");
            return;
        }
        InterfaceC6998co interfaceC6998coM41148a = C6982bz.m41148a(this);
        this.f31668e = interfaceC6998coM41148a;
        if (interfaceC6998coM41148a.mo41178g()) {
            appDownloadButton = this.f31664a;
            extandAppDownloadButtonStyle = new ExtandAppDownloadButtonStyleHm(this);
        } else {
            appDownloadButton = this.f31664a;
            extandAppDownloadButtonStyle = new ExtandAppDownloadButtonStyle(this);
        }
        appDownloadButton.setAppDownloadButtonStyle(extandAppDownloadButtonStyle);
        this.f31664a.setFixedWidth(false);
        m38631g();
    }

    /* renamed from: g */
    private void m38631g() throws Resources.NotFoundException {
        Resources resources;
        int i10;
        if (C7845x.m48587n(this)) {
            m38625a(0.72f, 0.74f, false);
            resources = getResources();
            i10 = C6849R.dimen.hiad_274_dp;
        } else if (C7845x.m48595q(this) && C7845x.m48599r(this)) {
            m38625a(0.72f, 0.74f, true);
            resources = getResources();
            i10 = C6849R.dimen.hiad_228_dp;
        } else {
            m38625a(1.0f, 0.84f, false);
            resources = getResources();
            i10 = C6849R.dimen.hiad_200_dp;
        }
        int dimensionPixelSize = resources.getDimensionPixelSize(i10);
        AppDownloadButton appDownloadButton = this.f31664a;
        if (appDownloadButton == null || dimensionPixelSize <= 0) {
            return;
        }
        appDownloadButton.setMinWidth(dimensionPixelSize);
        this.f31664a.setMaxWidth(dimensionPixelSize);
    }

    /* renamed from: h */
    private void m38632h() {
        this.f31666c.addJavascriptInterface(new C7746at(this, m38634j()), Constants.PPS_LANDING_DETAILS);
    }

    /* renamed from: i */
    private void m38633i() {
        PPSWebView pPSWebView = this.f31666c;
        if (pPSWebView == null) {
            AbstractC7185ho.m43820b("LandingDetailActivity", "set force dark ppsWebView is null.");
            return;
        }
        WebView webView = pPSWebView.getWebView();
        if (webView == null) {
            AbstractC7185ho.m43820b("LandingDetailActivity", "set force dark webView is null.");
            this.f31666c.setVisibility(8);
            findViewById(C6849R.id.landing_load_fail_view).setVisibility(0);
            return;
        }
        webView.setLayerType(1, null);
        webView.setBackgroundColor(getResources().getColor(C6849R.color.hiad_landing_details_btn_bg));
        webView.setVerticalScrollBarEnabled(false);
        this.f31666c.getSettings().setDomStorageEnabled(true);
        if (webView instanceof C8142e) {
            float fM47535a = AbstractC7741ao.m47535a(this, 24.0f);
            C8142e c8142e = (C8142e) webView;
            c8142e.setRadiusArray(new float[]{fM47535a, fM47535a, fM47535a, fM47535a, 0.0f, 0.0f, 0.0f, 0.0f});
            c8142e.setSupportWebViewRadius(true);
        }
        WebSettings settings = webView.getSettings();
        if (32 == (getResources().getConfiguration().uiMode & 48)) {
            settings.setForceDark(2);
        } else {
            settings.setForceDark(0);
        }
    }

    /* renamed from: j */
    private AppInfo m38634j() {
        AdLandingPageData adLandingPageData;
        if (this.f31672i && (adLandingPageData = this.f31670g) != null) {
            return adLandingPageData.getAppInfo();
        }
        IAd iAd = this.f31669f;
        if (iAd != null) {
            return iAd.getAppInfo();
        }
        return null;
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6905e
    /* renamed from: a */
    public void mo38587a() {
        setContentView(C7845x.m48587n(this) ? C6849R.layout.hiad_interstitial_landing_details : (C7845x.m48595q(this) && C7845x.m48599r(this)) ? C6849R.layout.hiad_interstitial_foldable_landing_details : C6849R.layout.hiad_activity_landing_details);
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        try {
            int iM47282a = C7694tp.m47282a(motionEvent);
            if (iM47282a == 0 && (viewGroup2 = this.f31812p) != null) {
                MaterialClickInfo materialClickInfoM47283a = C7694tp.m47283a(viewGroup2, motionEvent);
                this.f31671h = materialClickInfoM47283a;
                AppDownloadButton appDownloadButton = this.f31664a;
                if ((appDownloadButton != null && this.f31673j == null) || (appDownloadButton != null && (materialClickInfoM47283a = this.f31673j) != null)) {
                    appDownloadButton.m48702a(materialClickInfoM47283a);
                }
            }
            if (1 == iM47282a && (viewGroup = this.f31812p) != null) {
                C7694tp.m47284a(viewGroup, motionEvent, null, this.f31671h);
                AppDownloadButton appDownloadButton2 = this.f31664a;
                if (appDownloadButton2 != null && this.f31673j == null) {
                    appDownloadButton2.m48702a(this.f31671h);
                }
            }
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("LandingDetailActivity", "dispatchTouchEvent exception : %s", th2.getClass().getSimpleName());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity
    public void finish() {
        AbstractC7185ho.m43820b("LandingDetailActivity", "landing detail activity is finish.");
        ViewGroup viewGroup = this.f31812p;
        if (viewGroup != null) {
            viewGroup.setBackgroundColor(getResources().getColor(C6849R.color.hiad_0_percent_black));
        }
        super.finish();
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws Resources.NotFoundException {
        super.onConfigurationChanged(configuration);
        AbstractC7185ho.m43820b("LandingDetailActivity", "onConfigurationChanged.");
        m38631g();
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6905e, com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!m38627c()) {
            AbstractC7185ho.m43823c("LandingDetailActivity", "parse ad data ex, skip open app detail activity.");
            finish();
            return;
        }
        try {
            AbstractC7185ho.m43820b("LandingDetailActivity", "onCreate start.");
            m38628d();
            m38630f();
            AbstractC7811dd.m48274A(this);
            m38633i();
            m38632h();
            m38626b();
            if (this.f31672i) {
                this.f31664a.setAdLandingPageData(this.f31670g);
                this.f31666c.setAdLandingPageData(this.f31670g);
                InterfaceC7542oj webDetailPresenter = this.f31666c.getWebDetailPresenter();
                if (webDetailPresenter != null) {
                    webDetailPresenter.mo46248b(null);
                }
                this.f31666c.m49760a(this.f31670g.getAppInfo().getAppDetailUrl());
                return;
            }
            AbstractC7185ho.m43820b("LandingDetailActivity", "adLandingPageData is null.");
            IAd iAd = this.f31669f;
            if (iAd instanceof INativeAd) {
                this.f31664a.setNativeAd((INativeAd) iAd);
            }
            IAd iAd2 = this.f31669f;
            if (iAd2 instanceof IPlacementAd) {
                this.f31664a.setPlacementAd((IPlacementAd) iAd2);
            }
            IAd iAd3 = this.f31669f;
            if (iAd3 instanceof C7305h) {
                this.f31664a.setAdLandingPageData(new AdLandingPageData(C7580pn.m46793a((C7305h) iAd3), getApplicationContext(), true));
            }
            IAd iAd4 = this.f31669f;
            if (iAd4 instanceof C7301d) {
                this.f31664a.setAdLandingPageData(new AdLandingPageData(C7563ox.m46653a((C7301d) iAd4), getApplicationContext(), true));
            }
            AdLandingPageData adLandingPageData = new AdLandingPageData();
            this.f31670g = adLandingPageData;
            this.f31666c.setAdLandingPageData(adLandingPageData);
            InterfaceC7542oj webDetailPresenter2 = this.f31666c.getWebDetailPresenter();
            if (webDetailPresenter2 != null) {
                webDetailPresenter2.mo46248b(null);
            }
            this.f31666c.m49760a(this.f31669f.getAppInfo().getAppDetailUrl());
            m38635a(1);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("LandingDetailActivity", "onCreate ex: %s", th2.getClass().getSimpleName());
            finish();
        }
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f31670g = null;
        this.f31669f = null;
        AbstractC7014dc.m41870a((C7301d) null);
        PPSWebView pPSWebView = this.f31666c;
        if (pPSWebView != null) {
            pPSWebView.destroy();
        }
        m38635a(2);
    }

    /* renamed from: a */
    private void m38625a(float f10, float f11, boolean z10) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout relativeLayout = this.f31665b;
        if (relativeLayout == null || (layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams()) == null) {
            return;
        }
        int iM48373c = z10 ? C7818dk.m48373c(this) : C7818dk.m48373c(this) + AbstractC7741ao.m47583h(this);
        layoutParams.width = (int) (C7818dk.m48371b(this) * f10);
        layoutParams.height = (int) (iM48373c * f11);
        this.f31665b.setLayoutParams(layoutParams);
    }

    /* renamed from: a */
    public void m38635a(int i10) {
        SafeIntent safeIntent = new SafeIntent(new Intent("com.huawei.android.hms.LAND_DETAIL_STATE"));
        safeIntent.setPackage(getPackageName());
        safeIntent.putExtra("detail_state", i10);
        sendBroadcast(safeIntent);
    }
}
