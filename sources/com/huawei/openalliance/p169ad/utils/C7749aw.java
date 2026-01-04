package com.huawei.openalliance.p169ad.utils;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.AbstractC7558os;
import com.huawei.openalliance.p169ad.analysis.C6928i;
import com.huawei.openalliance.p169ad.beans.metadata.AppDownloadStatus;
import com.huawei.openalliance.p169ad.download.app.AbstractC7044c;
import com.huawei.openalliance.p169ad.download.app.AppDownloadTask;
import com.huawei.openalliance.p169ad.download.app.AppStatus;
import com.huawei.openalliance.p169ad.download.app.C7046e;
import com.huawei.openalliance.p169ad.inter.data.AdLandingPageData;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.p171db.bean.EncryptionField;
import com.huawei.openalliance.p169ad.utils.AbstractC7846y;
import com.huawei.openalliance.p169ad.views.AppDownloadButton;
import com.huawei.openalliance.p169ad.views.PPSWebView;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8133z;
import java.util.Arrays;

/* renamed from: com.huawei.openalliance.ad.utils.aw */
/* loaded from: classes2.dex */
public class C7749aw {

    /* renamed from: a */
    AppStatus f35874a;

    /* renamed from: b */
    AppDownloadTask f35875b;

    /* renamed from: c */
    private final AppDownloadButton f35876c;

    /* renamed from: d */
    private final Context f35877d;

    /* renamed from: e */
    private ContentRecord f35878e;

    /* renamed from: f */
    private AppInfo f35879f;

    /* renamed from: g */
    private final PPSWebView f35880g;

    /* renamed from: h */
    private String f35881h;

    /* renamed from: i */
    private InterfaceC8133z f35882i;

    /* renamed from: j */
    private String f35883j;

    /* renamed from: m */
    private String f35886m;

    /* renamed from: k */
    private boolean f35884k = false;

    /* renamed from: l */
    private int f35885l = 0;

    /* renamed from: n */
    private int f35887n = 0;

    /* renamed from: com.huawei.openalliance.ad.utils.aw$1 */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f35888a;

        public AnonymousClass1(Context context) {
            context = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            EncryptionField<String> encryptionFieldM41480ac = C7749aw.this.f35878e.m41480ac();
            if (encryptionFieldM41480ac != null) {
                C7749aw.this.f35881h = encryptionFieldM41480ac.m41652a(context);
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.aw$2 */
    public class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f35890a;

        /* renamed from: com.huawei.openalliance.ad.utils.aw$2$1 */
        public class AnonymousClass1 implements Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C7749aw c7749aw = C7749aw.this;
                c7749aw.f35874a = c7749aw.f35876c.getStatus();
                AppStatus appStatus = AppStatus.DOWNLOAD;
                AppStatus appStatus2 = C7749aw.this.f35874a;
                if (appStatus == appStatus2) {
                    AbstractC7185ho.m43820b("IPPSJs", "start download");
                    if (AbstractC7558os.m46468g(C7749aw.this.f35878e.m41427W())) {
                        C7749aw.this.f35884k = true;
                        if (C7775bv.m47829c(C7749aw.this.f35877d)) {
                            AbstractC7044c.m42341a(C7749aw.this.f35877d, new a(C7749aw.this.f35877d, false, C7749aw.this.f35876c, C7749aw.this.f35878e));
                            return;
                        } else {
                            AbstractC7044c.m42343b(C7749aw.this.f35877d, new a(C7749aw.this.f35877d, true, C7749aw.this.f35876c, C7749aw.this.f35878e));
                            return;
                        }
                    }
                    C7749aw.this.f35876c.setSource(4);
                    C7749aw.this.f35876c.setNeedShowPermision(false);
                } else if (AppStatus.PAUSE != appStatus2 && AppStatus.INSTALL != appStatus2 && AppStatus.WAITING_FOR_WIFI != appStatus2) {
                    return;
                } else {
                    AbstractC7185ho.m43820b("IPPSJs", "resume download");
                }
                C7749aw.this.m47664f();
            }
        }

        public AnonymousClass2(String str) {
            str = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!C7749aw.this.m47656b(true)) {
                AbstractC7185ho.m43823c("IPPSJs", "check permission fail");
                C7749aw.this.m47653b();
                return;
            }
            if (C7749aw.this.f35879f == null || C7830i.m48419a(C7749aw.this.f35877d, C7749aw.this.f35879f.getPackageName())) {
                AbstractC7185ho.m43823c("IPPSJs", "app info is null or app is installed");
                return;
            }
            if (C7749aw.this.f35876c == null) {
                AbstractC7185ho.m43823c("IPPSJs", "there is no download button");
                return;
            }
            C7749aw.this.f35876c.setVenusExt(str);
            if (!C7749aw.this.m47663e()) {
                AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.utils.aw.2.1
                    public AnonymousClass1() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        C7749aw c7749aw = C7749aw.this;
                        c7749aw.f35874a = c7749aw.f35876c.getStatus();
                        AppStatus appStatus = AppStatus.DOWNLOAD;
                        AppStatus appStatus2 = C7749aw.this.f35874a;
                        if (appStatus == appStatus2) {
                            AbstractC7185ho.m43820b("IPPSJs", "start download");
                            if (AbstractC7558os.m46468g(C7749aw.this.f35878e.m41427W())) {
                                C7749aw.this.f35884k = true;
                                if (C7775bv.m47829c(C7749aw.this.f35877d)) {
                                    AbstractC7044c.m42341a(C7749aw.this.f35877d, new a(C7749aw.this.f35877d, false, C7749aw.this.f35876c, C7749aw.this.f35878e));
                                    return;
                                } else {
                                    AbstractC7044c.m42343b(C7749aw.this.f35877d, new a(C7749aw.this.f35877d, true, C7749aw.this.f35876c, C7749aw.this.f35878e));
                                    return;
                                }
                            }
                            C7749aw.this.f35876c.setSource(4);
                            C7749aw.this.f35876c.setNeedShowPermision(false);
                        } else if (AppStatus.PAUSE != appStatus2 && AppStatus.INSTALL != appStatus2 && AppStatus.WAITING_FOR_WIFI != appStatus2) {
                            return;
                        } else {
                            AbstractC7185ho.m43820b("IPPSJs", "resume download");
                        }
                        C7749aw.this.m47664f();
                    }
                });
                return;
            }
            AbstractC7185ho.m43820b("IPPSJs", "mini download");
            C7749aw.this.f35876c.setSource(4);
            C7749aw.this.f35876c.setNeedShowPermision(false);
            C7749aw.this.m47664f();
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.aw$3 */
    public class AnonymousClass3 implements Runnable {
        public AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!C7749aw.this.m47656b(true)) {
                AbstractC7185ho.m43823c("IPPSJs", "check permission fail");
                return;
            }
            if (C7749aw.this.m47663e()) {
                AbstractC7185ho.m43820b("IPPSJs", "mini pause download");
                C7749aw.this.m47664f();
            } else if (C7749aw.this.f35876c != null) {
                C7749aw c7749aw = C7749aw.this;
                c7749aw.f35874a = c7749aw.f35876c.getStatus();
                AppStatus appStatus = AppStatus.DOWNLOADING;
                C7749aw c7749aw2 = C7749aw.this;
                if (appStatus == c7749aw2.f35874a) {
                    c7749aw2.m47664f();
                }
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.aw$4 */
    public class AnonymousClass4 implements Runnable {
        public AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!C7749aw.this.m47656b(true)) {
                AbstractC7185ho.m43823c("IPPSJs", "check permission fail");
                return;
            }
            if (C7749aw.this.f35879f == null || C7749aw.this.f35876c == null) {
                return;
            }
            C7749aw c7749aw = C7749aw.this;
            c7749aw.f35874a = c7749aw.f35876c.getStatus();
            AppStatus appStatus = AppStatus.INSTALLED;
            C7749aw c7749aw2 = C7749aw.this;
            if (appStatus == c7749aw2.f35874a) {
                c7749aw2.m47664f();
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.aw$5 */
    public class AnonymousClass5 implements Runnable {
        public AnonymousClass5() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C7749aw.this.f35876c.performClick();
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.aw$a */
    public static class a implements AbstractC7846y.a {

        /* renamed from: a */
        private boolean f35896a;

        /* renamed from: b */
        private final AppDownloadButton f35897b;

        /* renamed from: c */
        private final ContentRecord f35898c;

        /* renamed from: d */
        private final Context f35899d;

        /* renamed from: com.huawei.openalliance.ad.utils.aw$a$1 */
        public class AnonymousClass1 implements Runnable {

            /* renamed from: com.huawei.openalliance.ad.utils.aw$a$1$1 */
            public class C144751 implements AppDownloadButton.OnNonWifiDownloadListener {
                public C144751() {
                }

                @Override // com.huawei.openalliance.ad.views.AppDownloadButton.OnNonWifiDownloadListener
                public boolean onNonWifiDownload(AppInfo appInfo, long j10) {
                    a.this.f35897b.setAllowedNonWifiNetwork(true);
                    return true;
                }
            }

            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f35897b.setSource(4);
                a.this.f35897b.setNeedShowPermision(false);
                a.this.f35897b.setNeedShowConfirmDialog(false);
                if (a.this.f35896a) {
                    a.this.f35897b.setAllowedNonWifiNetwork(true);
                    a.this.f35897b.setOnNonWifiDownloadListener(new AppDownloadButton.OnNonWifiDownloadListener() { // from class: com.huawei.openalliance.ad.utils.aw.a.1.1
                        public C144751() {
                        }

                        @Override // com.huawei.openalliance.ad.views.AppDownloadButton.OnNonWifiDownloadListener
                        public boolean onNonWifiDownload(AppInfo appInfo, long j10) {
                            a.this.f35897b.setAllowedNonWifiNetwork(true);
                            return true;
                        }
                    });
                }
                a.this.f35897b.performClick();
            }
        }

        public a(Context context, boolean z10, AppDownloadButton appDownloadButton, ContentRecord contentRecord) {
            this.f35899d = context;
            this.f35896a = z10;
            this.f35897b = appDownloadButton;
            this.f35898c = contentRecord;
        }

        @Override // com.huawei.openalliance.p169ad.utils.AbstractC7846y.a
        /* renamed from: a */
        public void mo42634a() {
            if (this.f35897b != null) {
                AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.utils.aw.a.1

                    /* renamed from: com.huawei.openalliance.ad.utils.aw$a$1$1 */
                    public class C144751 implements AppDownloadButton.OnNonWifiDownloadListener {
                        public C144751() {
                        }

                        @Override // com.huawei.openalliance.ad.views.AppDownloadButton.OnNonWifiDownloadListener
                        public boolean onNonWifiDownload(AppInfo appInfo, long j10) {
                            a.this.f35897b.setAllowedNonWifiNetwork(true);
                            return true;
                        }
                    }

                    public AnonymousClass1() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.f35897b.setSource(4);
                        a.this.f35897b.setNeedShowPermision(false);
                        a.this.f35897b.setNeedShowConfirmDialog(false);
                        if (a.this.f35896a) {
                            a.this.f35897b.setAllowedNonWifiNetwork(true);
                            a.this.f35897b.setOnNonWifiDownloadListener(new AppDownloadButton.OnNonWifiDownloadListener() { // from class: com.huawei.openalliance.ad.utils.aw.a.1.1
                                public C144751() {
                                }

                                @Override // com.huawei.openalliance.ad.views.AppDownloadButton.OnNonWifiDownloadListener
                                public boolean onNonWifiDownload(AppInfo appInfo, long j10) {
                                    a.this.f35897b.setAllowedNonWifiNetwork(true);
                                    return true;
                                }
                            });
                        }
                        a.this.f35897b.performClick();
                    }
                });
            }
            new C6928i(this.f35899d).m39220e(this.f35898c);
        }

        @Override // com.huawei.openalliance.p169ad.utils.AbstractC7846y.a
        /* renamed from: a */
        public void mo42635a(boolean z10) {
            new C6928i(this.f35899d).m39218d(this.f35898c);
            AppDownloadButton appDownloadButton = this.f35897b;
            if (appDownloadButton != null) {
                appDownloadButton.m48710f();
            }
        }
    }

    public C7749aw(Context context, AdLandingPageData adLandingPageData, AppDownloadButton appDownloadButton, PPSWebView pPSWebView, InterfaceC8133z interfaceC8133z) {
        this.f35876c = appDownloadButton;
        this.f35877d = context;
        this.f35882i = interfaceC8133z;
        if (adLandingPageData != null) {
            this.f35878e = adLandingPageData.m44329y();
            this.f35879f = adLandingPageData.getAppInfo();
            this.f35883j = adLandingPageData.m44290f();
        }
        this.f35880g = pPSWebView;
        if (this.f35878e != null) {
            AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.utils.aw.1

                /* renamed from: a */
                final /* synthetic */ Context f35888a;

                public AnonymousClass1(Context context2) {
                    context = context2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    EncryptionField<String> encryptionFieldM41480ac = C7749aw.this.f35878e.m41480ac();
                    if (encryptionFieldM41480ac != null) {
                        C7749aw.this.f35881h = encryptionFieldM41480ac.m41652a(context);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    private AppDownloadStatus m47648a(AppStatus appStatus) {
        AppDownloadStatus appDownloadStatus = new AppDownloadStatus();
        if (appStatus != null) {
            AppDownloadTask appDownloadTaskM42405d = C7046e.m42377h().m42405d(this.f35879f);
            this.f35875b = appDownloadTaskM42405d;
            int iM42080l = appDownloadTaskM42405d == null ? 0 : appDownloadTaskM42405d.m42080l();
            appDownloadStatus.m39858a(appStatus);
            appDownloadStatus.m39857a(iM42080l);
        }
        return appDownloadStatus;
    }

    /* renamed from: b */
    public void m47653b() {
        InterfaceC8133z interfaceC8133z = this.f35882i;
        if (interfaceC8133z != null) {
            interfaceC8133z.mo38700a();
        }
    }

    /* renamed from: f */
    public void m47664f() {
        if (this.f35876c != null) {
            AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.utils.aw.5
                public AnonymousClass5() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    C7749aw.this.f35876c.performClick();
                }
            });
        }
    }

    /* renamed from: h */
    private boolean m47668h() {
        return "2".equals(this.f35878e.m41483ae()) || "1".equals(this.f35878e.m41483ae());
    }

    @JavascriptInterface
    public void download() {
        AbstractC7185ho.m43820b("IPPSJs", "call download from js");
        m47651a((String) null);
    }

    @JavascriptInterface
    public boolean isPreload() {
        AbstractC7185ho.m43820b("IPPSJs", "isPreload: false");
        return false;
    }

    @JavascriptInterface
    public void openApp() {
        AbstractC7185ho.m43820b("IPPSJs", "call openApp from js");
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.utils.aw.4
            public AnonymousClass4() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!C7749aw.this.m47656b(true)) {
                    AbstractC7185ho.m43823c("IPPSJs", "check permission fail");
                    return;
                }
                if (C7749aw.this.f35879f == null || C7749aw.this.f35876c == null) {
                    return;
                }
                C7749aw c7749aw = C7749aw.this;
                c7749aw.f35874a = c7749aw.f35876c.getStatus();
                AppStatus appStatus = AppStatus.INSTALLED;
                C7749aw c7749aw2 = C7749aw.this;
                if (appStatus == c7749aw2.f35874a) {
                    c7749aw2.m47664f();
                }
            }
        });
    }

    @JavascriptInterface
    public void pause() {
        AbstractC7185ho.m43820b("IPPSJs", "call pause from js");
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.utils.aw.3
            public AnonymousClass3() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!C7749aw.this.m47656b(true)) {
                    AbstractC7185ho.m43823c("IPPSJs", "check permission fail");
                    return;
                }
                if (C7749aw.this.m47663e()) {
                    AbstractC7185ho.m43820b("IPPSJs", "mini pause download");
                    C7749aw.this.m47664f();
                } else if (C7749aw.this.f35876c != null) {
                    C7749aw c7749aw = C7749aw.this;
                    c7749aw.f35874a = c7749aw.f35876c.getStatus();
                    AppStatus appStatus = AppStatus.DOWNLOADING;
                    C7749aw c7749aw2 = C7749aw.this;
                    if (appStatus == c7749aw2.f35874a) {
                        c7749aw2.m47664f();
                    }
                }
            }
        });
    }

    @JavascriptInterface
    public int privacyStyle() {
        return this.f35885l;
    }

    @JavascriptInterface
    public String queryDownloadStatus() {
        this.f35887n++;
        AppDownloadStatus appDownloadStatus = new AppDownloadStatus();
        if (!AbstractC7811dd.m48301a(this.f35877d)) {
            AbstractC7185ho.m43817a("IPPSJs", "isScreenInteractive off, don't queryDownloadStatus.");
            return AbstractC7758be.m47742b(m47648a(this.f35874a));
        }
        if (!m47656b(false)) {
            AbstractC7185ho.m43823c("IPPSJs", "check permission fail");
            return AbstractC7758be.m47742b(appDownloadStatus);
        }
        if (this.f35879f == null) {
            AbstractC7185ho.m43823c("IPPSJs", "app info is null");
            return AbstractC7758be.m47742b(appDownloadStatus);
        }
        AppDownloadButton appDownloadButton = this.f35876c;
        if (appDownloadButton != null) {
            AppStatus status = appDownloadButton.getStatus();
            this.f35874a = status;
            appDownloadStatus = m47648a(status);
            String strM39856a = appDownloadStatus.m39856a();
            if (!AbstractC7806cz.m48173e(this.f35886m, strM39856a)) {
                this.f35886m = strM39856a;
                AbstractC7185ho.m43821b("IPPSJs", "queryDownloadStatus from js status: %s, times:%s.", strM39856a, Integer.valueOf(this.f35887n));
            }
        }
        return AbstractC7758be.m47742b(appDownloadStatus);
    }

    @JavascriptInterface
    public String queryInteractionCfg() {
        ContentRecord contentRecord;
        AbstractC7185ho.m43823c("IPPSJs", "queryInteractionCfg");
        if (!m47668h() || (contentRecord = this.f35878e) == null) {
            return null;
        }
        return contentRecord.m41456aH();
    }

    /* renamed from: c */
    private boolean m47658c() {
        return m47668h() && !this.f35884k && AbstractC7558os.m46453A(this.f35883j) && m47661d();
    }

    /* renamed from: d */
    private boolean m47661d() {
        ContentRecord contentRecord = this.f35878e;
        return (contentRecord == null || contentRecord.m41484af() == null || this.f35880g.getWebHasShownTime() < this.f35878e.m41484af().m44346D()) ? false : true;
    }

    /* renamed from: e */
    public boolean m47663e() {
        AppInfo appInfo = this.f35879f;
        if (appInfo == null) {
            return false;
        }
        String strM44376b = appInfo.m44376b((Integer) 4);
        return (TextUtils.isEmpty(strM44376b) || TextUtils.isEmpty(this.f35879f.getPackageName()) || !strM44376b.equals("6")) ? false : true;
    }

    /* renamed from: g */
    private boolean m47667g() {
        ContentRecord contentRecord = this.f35878e;
        if (contentRecord == null) {
            return false;
        }
        return AbstractC7558os.m46466e(contentRecord.m41427W());
    }

    @JavascriptInterface
    public void download(String str) {
        AbstractC7185ho.m43820b("IPPSJs", "call download from js");
        m47651a(str);
    }

    /* renamed from: c */
    private boolean m47659c(boolean z10) {
        PPSWebView pPSWebView;
        String currentPageUrl;
        EncryptionField<String> encryptionFieldM41480ac;
        if (this.f35878e == null || (pPSWebView = this.f35880g) == null) {
            return false;
        }
        if (z10) {
            WebView webView = pPSWebView.getWebView();
            currentPageUrl = webView != null ? webView.getUrl() : null;
        } else {
            currentPageUrl = pPSWebView.getCurrentPageUrl();
        }
        if (TextUtils.isEmpty(this.f35881h) && (encryptionFieldM41480ac = this.f35878e.m41480ac()) != null) {
            this.f35881h = encryptionFieldM41480ac.m41652a(this.f35877d);
        }
        return AbstractC7806cz.m48171d(currentPageUrl, this.f35881h);
    }

    @JavascriptInterface
    public void download(String str, int i10) {
        AbstractC7185ho.m43820b("IPPSJs", "call download from js with area:" + i10);
        try {
            if (100 == i10) {
                if (!m47658c() || this.f35882i == null) {
                    return;
                }
                AbstractC7185ho.m43823c("IPPSJs", "allow area 100 download in pps landingPage");
                this.f35882i.mo38701a(100);
                return;
            }
            if (i10 != 0 && 1 != i10 && 2 != i10) {
                AbstractC7185ho.m43824c("IPPSJs", "area %s is invalid", Integer.valueOf(i10));
                return;
            }
            if (!m47668h() && 1 == i10) {
                AbstractC7185ho.m43823c("IPPSJs", "only allow area 1 download in pps landingPage");
                m47653b();
                return;
            }
            ContentRecord contentRecord = this.f35878e;
            if (contentRecord == null || AbstractC7806cz.m48165b(contentRecord.m41456aH())) {
                if (i10 != 0 && 1 != i10) {
                    AbstractC7185ho.m43824c("IPPSJs", "not allow area %s download", Integer.valueOf(i10));
                    m47653b();
                    return;
                }
            } else if (!Arrays.asList(this.f35878e.m41456aH().split("\\|")).contains(String.valueOf(i10))) {
                AbstractC7185ho.m43824c("IPPSJs", "not allow area %s download", Integer.valueOf(i10));
                m47653b();
                return;
            }
            m47651a(str);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("IPPSJs", "download for Area: %s err, %s", Integer.valueOf(i10), th2.getClass().getSimpleName());
        }
    }

    /* renamed from: b */
    public boolean m47656b(boolean z10) {
        String str;
        if (m47668h()) {
            return true;
        }
        if (!m47667g()) {
            str = "h5 download is not enable and is not pps landing page";
        } else {
            if (m47659c(z10)) {
                return true;
            }
            str = "page is not in white list";
        }
        AbstractC7185ho.m43823c("IPPSJs", str);
        return false;
    }

    /* renamed from: a */
    public void m47669a(int i10) {
        this.f35885l = i10;
    }

    /* renamed from: a */
    private void m47651a(String str) {
        if (!AbstractC7558os.m46482u(this.f35883j)) {
            AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.utils.aw.2

                /* renamed from: a */
                final /* synthetic */ String f35890a;

                /* renamed from: com.huawei.openalliance.ad.utils.aw$2$1 */
                public class AnonymousClass1 implements Runnable {
                    public AnonymousClass1() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        C7749aw c7749aw = C7749aw.this;
                        c7749aw.f35874a = c7749aw.f35876c.getStatus();
                        AppStatus appStatus = AppStatus.DOWNLOAD;
                        AppStatus appStatus2 = C7749aw.this.f35874a;
                        if (appStatus == appStatus2) {
                            AbstractC7185ho.m43820b("IPPSJs", "start download");
                            if (AbstractC7558os.m46468g(C7749aw.this.f35878e.m41427W())) {
                                C7749aw.this.f35884k = true;
                                if (C7775bv.m47829c(C7749aw.this.f35877d)) {
                                    AbstractC7044c.m42341a(C7749aw.this.f35877d, new a(C7749aw.this.f35877d, false, C7749aw.this.f35876c, C7749aw.this.f35878e));
                                    return;
                                } else {
                                    AbstractC7044c.m42343b(C7749aw.this.f35877d, new a(C7749aw.this.f35877d, true, C7749aw.this.f35876c, C7749aw.this.f35878e));
                                    return;
                                }
                            }
                            C7749aw.this.f35876c.setSource(4);
                            C7749aw.this.f35876c.setNeedShowPermision(false);
                        } else if (AppStatus.PAUSE != appStatus2 && AppStatus.INSTALL != appStatus2 && AppStatus.WAITING_FOR_WIFI != appStatus2) {
                            return;
                        } else {
                            AbstractC7185ho.m43820b("IPPSJs", "resume download");
                        }
                        C7749aw.this.m47664f();
                    }
                }

                public AnonymousClass2(String str2) {
                    str = str2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (!C7749aw.this.m47656b(true)) {
                        AbstractC7185ho.m43823c("IPPSJs", "check permission fail");
                        C7749aw.this.m47653b();
                        return;
                    }
                    if (C7749aw.this.f35879f == null || C7830i.m48419a(C7749aw.this.f35877d, C7749aw.this.f35879f.getPackageName())) {
                        AbstractC7185ho.m43823c("IPPSJs", "app info is null or app is installed");
                        return;
                    }
                    if (C7749aw.this.f35876c == null) {
                        AbstractC7185ho.m43823c("IPPSJs", "there is no download button");
                        return;
                    }
                    C7749aw.this.f35876c.setVenusExt(str);
                    if (!C7749aw.this.m47663e()) {
                        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.utils.aw.2.1
                            public AnonymousClass1() {
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                C7749aw c7749aw = C7749aw.this;
                                c7749aw.f35874a = c7749aw.f35876c.getStatus();
                                AppStatus appStatus = AppStatus.DOWNLOAD;
                                AppStatus appStatus2 = C7749aw.this.f35874a;
                                if (appStatus == appStatus2) {
                                    AbstractC7185ho.m43820b("IPPSJs", "start download");
                                    if (AbstractC7558os.m46468g(C7749aw.this.f35878e.m41427W())) {
                                        C7749aw.this.f35884k = true;
                                        if (C7775bv.m47829c(C7749aw.this.f35877d)) {
                                            AbstractC7044c.m42341a(C7749aw.this.f35877d, new a(C7749aw.this.f35877d, false, C7749aw.this.f35876c, C7749aw.this.f35878e));
                                            return;
                                        } else {
                                            AbstractC7044c.m42343b(C7749aw.this.f35877d, new a(C7749aw.this.f35877d, true, C7749aw.this.f35876c, C7749aw.this.f35878e));
                                            return;
                                        }
                                    }
                                    C7749aw.this.f35876c.setSource(4);
                                    C7749aw.this.f35876c.setNeedShowPermision(false);
                                } else if (AppStatus.PAUSE != appStatus2 && AppStatus.INSTALL != appStatus2 && AppStatus.WAITING_FOR_WIFI != appStatus2) {
                                    return;
                                } else {
                                    AbstractC7185ho.m43820b("IPPSJs", "resume download");
                                }
                                C7749aw.this.m47664f();
                            }
                        });
                        return;
                    }
                    AbstractC7185ho.m43820b("IPPSJs", "mini download");
                    C7749aw.this.f35876c.setSource(4);
                    C7749aw.this.f35876c.setNeedShowPermision(false);
                    C7749aw.this.m47664f();
                }
            });
        } else {
            AbstractC7185ho.m43820b("IPPSJs", "js download forbidden");
            m47653b();
        }
    }

    /* renamed from: a */
    public void m47670a(boolean z10) {
        this.f35884k = z10;
    }

    /* renamed from: a */
    public boolean m47671a() {
        return this.f35884k;
    }
}
