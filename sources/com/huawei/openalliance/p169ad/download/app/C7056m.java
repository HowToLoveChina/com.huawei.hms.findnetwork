package com.huawei.openalliance.p169ad.download.app;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.huawei.openalliance.p169ad.AbstractC7026do;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.C7073dq;
import com.huawei.openalliance.p169ad.C7103es;
import com.huawei.openalliance.p169ad.C7560ou;
import com.huawei.openalliance.p169ad.C7570pd;
import com.huawei.openalliance.p169ad.C7575pi;
import com.huawei.openalliance.p169ad.C7662sk;
import com.huawei.openalliance.p169ad.C7681tc;
import com.huawei.openalliance.p169ad.C7692tn;
import com.huawei.openalliance.p169ad.InterfaceC7337jk;
import com.huawei.openalliance.p169ad.InterfaceC7615qq;
import com.huawei.openalliance.p169ad.analysis.C6922c;
import com.huawei.openalliance.p169ad.constant.ClickDestination;
import com.huawei.openalliance.p169ad.constant.EventType;
import com.huawei.openalliance.p169ad.constant.PriorInstallWay;
import com.huawei.openalliance.p169ad.download.DownloadTask;
import com.huawei.openalliance.p169ad.download.EnumC7062e;
import com.huawei.openalliance.p169ad.download.app.AppDownloadTask;
import com.huawei.openalliance.p169ad.download.app.C7049h;
import com.huawei.openalliance.p169ad.download.app.C7050i;
import com.huawei.openalliance.p169ad.download.app.interfaces.InterfaceC7051a;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.inter.data.C7302e;
import com.huawei.openalliance.p169ad.inter.data.C7304g;
import com.huawei.openalliance.p169ad.inter.data.C7306i;
import com.huawei.openalliance.p169ad.inter.data.IAd;
import com.huawei.openalliance.p169ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.p169ad.inter.data.RewardVerifyConfig;
import com.huawei.openalliance.p169ad.inter.listeners.AppDownloadListenerV1;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.processor.eventbeans.C7586a;
import com.huawei.openalliance.p169ad.processor.eventbeans.C7587b;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import com.huawei.openalliance.p169ad.utils.C7753b;
import com.huawei.openalliance.p169ad.utils.C7775bv;
import com.huawei.openalliance.p169ad.utils.C7830i;
import com.huawei.openalliance.p169ad.utils.C7831j;
import com.huawei.openalliance.p169ad.views.AppDownloadButton;
import com.huawei.openalliance.p169ad.views.PPSNativeView;
import com.huawei.openalliance.p169ad.views.PPSPlacementView;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8113f;

/* renamed from: com.huawei.openalliance.ad.download.app.m */
/* loaded from: classes2.dex */
public class C7056m implements InterfaceC7051a {

    /* renamed from: a */
    private final C7046e f32470a;

    /* renamed from: d */
    private String f32473d;

    /* renamed from: e */
    private AppDownloadListenerV1 f32474e;

    /* renamed from: b */
    private int f32471b = 2;

    /* renamed from: c */
    private Integer f32472c = 6;

    /* renamed from: f */
    private final C7053j f32475f = new C7053j();

    public C7056m() {
        C7046e c7046eM42377h = C7046e.m42377h();
        this.f32470a = c7046eM42377h;
        this.f32474e = c7046eM42377h.m42409i();
    }

    /* renamed from: d */
    private int m42529d(final Context context, final InterfaceC7337jk interfaceC7337jk, final IAd iAd) {
        if (!m42535i(context, iAd)) {
            return m42530e(context, interfaceC7337jk, iAd);
        }
        C7049h.m42420a(context, iAd.getAppInfo(), new C7049h.a() { // from class: com.huawei.openalliance.ad.download.app.m.2
            @Override // com.huawei.openalliance.p169ad.download.app.C7049h.a
            /* renamed from: a */
            public void mo42425a() {
                C7056m.this.m42530e(context, interfaceC7337jk, iAd);
            }

            @Override // com.huawei.openalliance.p169ad.download.app.C7049h.a
            /* renamed from: a */
            public void mo42426a(int i10) {
            }
        });
        return -3;
    }

    /* renamed from: f */
    private int m42531f(Context context, InterfaceC7337jk interfaceC7337jk, IAd iAd) {
        AppInfo appInfo = iAd.getAppInfo();
        AppDownloadTask appDownloadTaskM42405d = this.f32470a.m42405d(appInfo);
        m42522b(context, iAd, appDownloadTaskM42405d);
        if (appDownloadTaskM42405d != null) {
            appDownloadTaskM42405d.m42057a(appInfo.isAllowedNonWifiNetwork());
            m42513a(iAd, appDownloadTaskM42405d);
            m42509a(context, iAd, appDownloadTaskM42405d);
            return this.f32470a.mo42393a(appDownloadTaskM42405d, true) ? 0 : -1;
        }
        C7560ou c7560ouM42538l = m42538l(context, iAd);
        if (c7560ouM42538l == null) {
            return -1;
        }
        AppDownloadTask appDownloadTaskM42507a = m42507a(iAd, c7560ouM42538l);
        if (appDownloadTaskM42507a == null) {
            AbstractC7185ho.m43820b("PPSAppDownloadManager", "failed when create task");
            return -1;
        }
        appDownloadTaskM42507a.m42057a(appInfo.isAllowedNonWifiNetwork());
        m42513a(iAd, appDownloadTaskM42507a);
        if (!m42527c()) {
            m42532g(context, interfaceC7337jk, iAd);
            m42510a(context, c7560ouM42538l, appInfo);
        }
        return this.f32470a.mo42403c(appDownloadTaskM42507a) ? 0 : -1;
    }

    /* renamed from: g */
    private void m42532g(Context context, InterfaceC7337jk interfaceC7337jk, IAd iAd) {
        if (interfaceC7337jk != null) {
            if (interfaceC7337jk instanceof PPSNativeView) {
                ((PPSNativeView) interfaceC7337jk).mo49347a((Integer) 6);
            }
            if (interfaceC7337jk instanceof PPSPlacementView) {
                ((PPSPlacementView) interfaceC7337jk).mo49458a((Integer) 6);
                return;
            }
            return;
        }
        if (iAd != null) {
            String showId = iAd instanceof C7306i ? ((C7306i) iAd).getShowId() : null;
            if (showId == null || !showId.equals(this.f32473d)) {
                this.f32473d = showId;
                ContentRecord contentRecordM42519b = m42519b(iAd);
                C7560ou c7560ou = new C7560ou(context, C7662sk.m47225a(context, contentRecordM42519b.m41552f()));
                contentRecordM42519b.m41536c(iAd.getShowId());
                c7560ou.mo46590a(contentRecordM42519b);
                C7586a.a aVar = new C7586a.a();
                aVar.m46874a(Long.valueOf(iAd.getMinEffectiveShowTime())).m46873a(Integer.valueOf(iAd.getMinEffectiveShowRatio())).m46878b((Integer) 6).m46875a(C7753b.m47699a(context));
                c7560ou.mo46593a(aVar.m46877a());
            }
        }
    }

    /* renamed from: h */
    private boolean m42534h(Context context, IAd iAd) {
        String str;
        if (context == null || iAd == null) {
            return false;
        }
        boolean z10 = iAd instanceof C7306i;
        if (!(iAd instanceof C7302e) && !(iAd instanceof C7304g) && !z10) {
            str = "ad is not native or placement ad when start download";
        } else {
            if (iAd.isAdIdInWhiteList() || z10) {
                return true;
            }
            str = "download has not permission, please add white list";
        }
        AbstractC7185ho.m43820b("PPSAppDownloadManager", str);
        return false;
    }

    /* renamed from: i */
    private boolean m42535i(Context context, IAd iAd) {
        AppInfo appInfo = iAd.getAppInfo();
        if (appInfo != null) {
            return appInfo.m44435w() && appInfo.isPermPromptForCard() && mo42477f(context, iAd) == AppStatus.DOWNLOAD;
        }
        AbstractC7185ho.m43823c("PPSAppDownloadManager", "appInfo is null.");
        return false;
    }

    /* renamed from: j */
    private int m42536j(Context context, IAd iAd) {
        AppDownloadTask appDownloadTaskM42405d = this.f32470a.m42405d(iAd.getAppInfo());
        if (AbstractC7185ho.m43819a()) {
            Object[] objArr = new Object[1];
            objArr[0] = (appDownloadTaskM42405d == null || appDownloadTaskM42405d.m42222B() == null) ? null : appDownloadTaskM42405d.m42222B().getUniqueId();
            AbstractC7185ho.m43818a("PPSAppDownloadManager", "resumeDownload, taskAppInfoId: %s", objArr);
            AbstractC7185ho.m43818a("PPSAppDownloadManager", "resumeDownload, adUniqueId: %s", iAd.getUniqueId());
        }
        m42522b(context, iAd, appDownloadTaskM42405d);
        if (appDownloadTaskM42405d == null) {
            AbstractC7185ho.m43820b("PPSAppDownloadManager", "app download info is empty, must first invoke startDownload method");
            return -1;
        }
        m42509a(context, iAd, appDownloadTaskM42405d);
        appDownloadTaskM42405d.m42057a(iAd.getAppInfo().isAllowedNonWifiNetwork());
        m42513a(iAd, appDownloadTaskM42405d);
        return this.f32470a.mo42393a(appDownloadTaskM42405d, true) ? 0 : -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public int m42537k(Context context, IAd iAd) {
        if (m42540n(context, iAd)) {
            AbstractC7185ho.m43820b("PPSAppDownloadManager", "app is installed, open it.");
            return 0;
        }
        AbstractC7185ho.m43820b("PPSAppDownloadManager", "preWifiDownload");
        AppDownloadTask appDownloadTaskM42520b = m42520b(context, m42519b(iAd), iAd.getAppInfo());
        m42522b(context, iAd, appDownloadTaskM42520b);
        if (appDownloadTaskM42520b == null) {
            appDownloadTaskM42520b = m42507a(iAd, m42538l(context, iAd));
            this.f32470a.m42560b((C7046e) appDownloadTaskM42520b);
        }
        if (appDownloadTaskM42520b != null) {
            appDownloadTaskM42520b.m42051a(DownloadTask.EnumC7029a.WAITING_WIFI_DOWNLOAD);
        }
        AppStatus appStatusMo42477f = mo42477f(context, iAd);
        if (appStatusMo42477f != AppStatus.DOWNLOAD && appStatusMo42477f != AppStatus.WAITING_FOR_WIFI && appStatusMo42477f != AppStatus.PAUSE) {
            return -1;
        }
        this.f32470a.m42567e((C7046e) appDownloadTaskM42520b);
        return 0;
    }

    /* renamed from: l */
    private C7560ou m42538l(Context context, IAd iAd) {
        ContentRecord contentRecordM42519b = m42519b(iAd);
        if (contentRecordM42519b == null) {
            AbstractC7185ho.m43820b("PPSAppDownloadManager", "contentRecord is empty when convert from nativeAd");
            return null;
        }
        C7560ou c7560ou = new C7560ou(context, C7662sk.m47225a(context, contentRecordM42519b.m41552f()));
        c7560ou.mo46590a(contentRecordM42519b);
        return c7560ou;
    }

    /* renamed from: m */
    private boolean m42539m(Context context, IAd iAd) {
        if (context != null && iAd != null) {
            AppInfo appInfo = iAd.getAppInfo();
            if (appInfo == null) {
                AbstractC7185ho.m43820b("PPSAppDownloadManager", "failed to get app info when open landing page");
                return false;
            }
            if (PriorInstallWay.PRIOR_ACTION_LANDING_PAGE.equals(appInfo.m44366a())) {
                return new C7681tc(context, m42519b(iAd), true, iAd instanceof C7302e ? ((C7302e) iAd).m44815ak() : null).mo47233a();
            }
        }
        return false;
    }

    /* renamed from: n */
    private boolean m42540n(Context context, IAd iAd) {
        String str;
        if (iAd == null || iAd.getAppInfo() == null) {
            str = "param is empty";
        } else {
            C7560ou c7560ouM42538l = m42538l(context, iAd);
            if (c7560ouM42538l == null) {
                str = "event processor failed when open app";
            } else {
                AppInfo appInfo = iAd.getAppInfo();
                if (iAd instanceof C7306i) {
                    C7306i c7306i = (C7306i) iAd;
                    if (!TextUtils.isEmpty(c7306i.m44980b())) {
                        appInfo.m44433v(c7306i.m44980b());
                    }
                }
                if (C7830i.m48419a(context, appInfo.getPackageName())) {
                    C7692tn.a aVar = new C7692tn.a();
                    aVar.m47276a(iAd.getContentId()).m47278b(iAd.getTaskId()).m47275a(appInfo);
                    boolean zM48421a = C7830i.m48421a(context, appInfo.getPackageName(), appInfo.getIntentUri(), aVar.m47277a());
                    MaterialClickInfo materialClickInfo = new MaterialClickInfo();
                    materialClickInfo.m44515f(1);
                    C7587b.a aVar2 = new C7587b.a();
                    aVar2.m46920b("app").m46915a((Integer) 6).m46914a(materialClickInfo).m46923d(C7753b.m47699a(context));
                    if (zM48421a) {
                        m42508a(context, appInfo);
                        c7560ouM42538l.mo46588a(EventType.INTENTSUCCESS, (Integer) 1, (Integer) null);
                        if (!m42527c()) {
                            c7560ouM42538l.mo46594a(aVar2.m46918a());
                            m42532g(context, null, iAd);
                        }
                        return true;
                    }
                    AbstractC7185ho.m43820b("PPSAppDownloadManager", "handleClick, openAppIntent failed");
                    c7560ouM42538l.mo46588a(EventType.INTENTFAIL, (Integer) 1, (Integer) 2);
                    if (C7830i.m48420a(context, appInfo.getPackageName(), aVar.m47277a())) {
                        c7560ouM42538l.mo46595a((Integer) 6);
                        m42508a(context, appInfo);
                        if (!m42527c()) {
                            c7560ouM42538l.mo46594a(aVar2.m46918a());
                            m42532g(context, null, iAd);
                        }
                        return true;
                    }
                    str = "handleClick, openAppMainPage failed";
                } else {
                    str = "app not installed, need download";
                }
            }
        }
        AbstractC7185ho.m43820b("PPSAppDownloadManager", str);
        return false;
    }

    @Override // com.huawei.openalliance.p169ad.download.app.interfaces.InterfaceC7051a
    /* renamed from: a */
    public int mo42464a(Context context, IAd iAd) {
        if (m42540n(context, iAd)) {
            AbstractC7185ho.m43820b("PPSAppDownloadManager", "app is installed, open it.");
            return 0;
        }
        if (m42539m(context, iAd)) {
            AbstractC7185ho.m43820b("PPSAppDownloadManager", "open landing page action");
            return -4;
        }
        int iM42516b = m42516b(context, iAd, m42515a(iAd));
        if (iM42516b == 0) {
            return m42529d(context, null, iAd);
        }
        if (iAd != null) {
            m42511a(AppStatusV1.PRE_CHECK_FAILED, -1000, iAd.getAppInfo());
        }
        return iM42516b;
    }

    @Override // com.huawei.openalliance.p169ad.download.app.interfaces.InterfaceC7051a
    /* renamed from: b */
    public int mo42472b(Context context, IAd iAd) {
        if (m42539m(context, iAd)) {
            AbstractC7185ho.m43820b("PPSAppDownloadManager", "open landing page action");
            return -4;
        }
        int iM42516b = m42516b(context, iAd, false);
        return iM42516b != 0 ? iM42516b : m42502a(context, (InterfaceC7337jk) null, iAd, true);
    }

    @Override // com.huawei.openalliance.p169ad.download.app.interfaces.InterfaceC7051a
    /* renamed from: c */
    public int mo42474c(Context context, IAd iAd) {
        if (!m42533g(context, iAd)) {
            return -1;
        }
        if (m42539m(context, iAd)) {
            AbstractC7185ho.m43820b("PPSAppDownloadManager", "open landing page action");
            return -4;
        }
        if (!this.f32475f.m42489a(context, iAd, false)) {
            AbstractC7185ho.m43820b("PPSAppDownloadManager", "pauseDownload has not permission");
            return -2;
        }
        AppInfo appInfo = iAd.getAppInfo();
        if (appInfo == null) {
            AbstractC7185ho.m43823c("PPSAppDownloadManager", "appInfo is null.");
            return -1;
        }
        AppDownloadTask appDownloadTaskMo42385a = this.f32470a.mo42385a(appInfo.getPackageName());
        if (AbstractC7185ho.m43819a()) {
            Object[] objArr = new Object[1];
            objArr[0] = (appDownloadTaskMo42385a == null || appDownloadTaskMo42385a.m42222B() == null) ? null : appDownloadTaskMo42385a.m42222B().getUniqueId();
            AbstractC7185ho.m43818a("PPSAppDownloadManager", "pauseDownload, taskAppInfoId: %s", objArr);
            AbstractC7185ho.m43818a("PPSAppDownloadManager", "pauseDownload, adUniqueId: %s", iAd.getUniqueId());
        }
        m42522b(context, iAd, appDownloadTaskMo42385a);
        if (appDownloadTaskMo42385a != null) {
            m42509a(context, iAd, appDownloadTaskMo42385a);
            m42513a(iAd, appDownloadTaskMo42385a);
            this.f32470a.m42398b(appDownloadTaskMo42385a);
        }
        return 1;
    }

    @Override // com.huawei.openalliance.p169ad.download.app.interfaces.InterfaceC7051a
    /* renamed from: e */
    public int mo42476e(Context context, IAd iAd) {
        if (!m42533g(context, iAd)) {
            return 0;
        }
        AppDownloadTask appDownloadTaskM42405d = this.f32470a.m42405d(iAd.getAppInfo());
        if (appDownloadTaskM42405d != null) {
            return appDownloadTaskM42405d.m42080l();
        }
        AbstractC7185ho.m43820b("PPSAppDownloadManager", "task is not exist.");
        return 0;
    }

    /* renamed from: b */
    private int m42516b(final Context context, IAd iAd, boolean z10) {
        if (!z10 && !C7775bv.m47831e(context)) {
            AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.download.app.m.1
                @Override // java.lang.Runnable
                public void run() {
                    Toast.makeText(context, C6849R.string.hiad_network_no_available, 0).show();
                }
            });
            return -1;
        }
        if (context == null || iAd == null) {
            return -1;
        }
        boolean z11 = iAd instanceof C7306i;
        if (!(iAd instanceof C7302e) && !(iAd instanceof C7304g) && !z11) {
            AbstractC7185ho.m43820b("PPSAppDownloadManager", "ad is not native or placement ad when start download");
            return -1;
        }
        if (this.f32475f.m42489a(context, iAd, true)) {
            return !m42523b(iAd.getAppInfo()) ? -1 : 0;
        }
        AbstractC7185ho.m43820b("PPSAppDownloadManager", "download has not permission, please add white list");
        return -2;
    }

    /* renamed from: c */
    private int m42524c(Context context, InterfaceC7337jk interfaceC7337jk, IAd iAd) {
        String str;
        if (context == null || iAd == null || interfaceC7337jk == null || !(interfaceC7337jk instanceof InterfaceC8113f)) {
            return -1;
        }
        InterfaceC8113f interfaceC8113f = (InterfaceC8113f) interfaceC7337jk;
        if (interfaceC8113f.getAd() == null || interfaceC8113f.getAd() != iAd) {
            str = "make sure the registered ad of view is same";
        } else {
            if (interfaceC8113f.mo49351d()) {
                return m42516b(context, iAd, m42515a(iAd));
            }
            str = "make sure ad view is visibility";
        }
        AbstractC7185ho.m43820b("PPSAppDownloadManager", str);
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public int m42530e(Context context, InterfaceC7337jk interfaceC7337jk, IAd iAd) {
        return m42515a(iAd) ? m42541b(context, interfaceC7337jk, iAd) : m42502a(context, interfaceC7337jk, iAd, false);
    }

    /* renamed from: g */
    private boolean m42533g(Context context, IAd iAd) {
        return m42534h(context, iAd) && m42523b(iAd.getAppInfo());
    }

    @Override // com.huawei.openalliance.p169ad.download.app.interfaces.InterfaceC7051a
    /* renamed from: a */
    public int mo42465a(Context context, InterfaceC7337jk interfaceC7337jk, IAd iAd) {
        if (m42540n(context, iAd)) {
            AbstractC7185ho.m43820b("PPSAppDownloadManager", "app is installed, open it.");
            return 0;
        }
        int iM42524c = m42524c(context, interfaceC7337jk, iAd);
        if (iM42524c == 0) {
            return m42529d(context, interfaceC7337jk, iAd);
        }
        if (iAd != null) {
            m42511a(AppStatusV1.PRE_CHECK_FAILED, -1000, iAd.getAppInfo());
        }
        return iM42524c;
    }

    @Override // com.huawei.openalliance.p169ad.download.app.interfaces.InterfaceC7051a
    /* renamed from: d */
    public void mo42475d(Context context, IAd iAd) {
        Integer num;
        if (m42533g(context, iAd)) {
            if (!this.f32475f.m42489a(context, iAd, false)) {
                AbstractC7185ho.m43820b("PPSAppDownloadManager", "cancelDownload has not permission");
                return;
            }
            AppInfo appInfo = iAd.getAppInfo();
            if (appInfo == null) {
                AbstractC7185ho.m43823c("PPSAppDownloadManager", "appInfo is null.");
                return;
            }
            AppDownloadTask appDownloadTaskMo42385a = this.f32470a.mo42385a(appInfo.getPackageName());
            if (appDownloadTaskMo42385a == null || appDownloadTaskMo42385a.m42077i() == EnumC7062e.INSTALLING) {
                return;
            }
            m42509a(context, iAd, appDownloadTaskMo42385a);
            m42513a(iAd, appDownloadTaskMo42385a);
            if (this.f32470a.m42401b(appInfo) && (num = this.f32472c) != null) {
                if (num.intValue() == 14 || this.f32472c.intValue() == 10005) {
                    m42521b(context, appInfo);
                }
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.download.app.interfaces.InterfaceC7051a
    /* renamed from: f */
    public AppStatus mo42477f(Context context, IAd iAd) {
        if (!m42534h(context, iAd)) {
            return AppStatus.DOWNLOAD;
        }
        AppInfo appInfo = iAd.getAppInfo();
        if (appInfo == null) {
            AbstractC7185ho.m43823c("PPSAppDownloadManager", "appInfo is null.");
            return AppStatus.DOWNLOAD;
        }
        if (C7830i.m48419a(context, appInfo.getPackageName())) {
            AbstractC7185ho.m43820b("PPSAppDownloadManager", "app installed");
            return AppStatus.INSTALLED;
        }
        if (!m42523b(appInfo)) {
            return AppStatus.DOWNLOAD;
        }
        AppDownloadTask appDownloadTaskM42405d = this.f32470a.m42405d(appInfo);
        m42522b(context, iAd, appDownloadTaskM42405d);
        if (appDownloadTaskM42405d == null) {
            return AppStatus.DOWNLOAD;
        }
        appDownloadTaskM42405d.m42260m(iAd.getContentId());
        return C7831j.m48451a(appDownloadTaskM42405d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public int m42502a(Context context, InterfaceC7337jk interfaceC7337jk, IAd iAd, boolean z10) {
        return !C7775bv.m47829c(context) ? m42517b(context, interfaceC7337jk, iAd, z10) : m42525c(context, interfaceC7337jk, iAd, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public int m42525c(Context context, InterfaceC7337jk interfaceC7337jk, IAd iAd, boolean z10) {
        if (!m42540n(context, iAd)) {
            return z10 ? m42536j(context, iAd) : m42531f(context, interfaceC7337jk, iAd);
        }
        AbstractC7185ho.m43820b("PPSAppDownloadManager", "app is installed, open it.");
        return 0;
    }

    /* renamed from: b */
    public int m42541b(final Context context, InterfaceC7337jk interfaceC7337jk, final IAd iAd) {
        AppInfo appInfo = iAd.getAppInfo();
        this.f32470a.m42396a(appInfo);
        C7560ou c7560ouM42538l = m42538l(context, iAd);
        if (c7560ouM42538l == null) {
            return -1;
        }
        AppDownloadTask appDownloadTaskM42507a = m42507a(iAd, c7560ouM42538l);
        if (appDownloadTaskM42507a == null) {
            AbstractC7185ho.m43820b("PPSAppDownloadManager", "failed when create task");
            return -1;
        }
        m42513a(iAd, appDownloadTaskM42507a);
        if (!m42527c()) {
            m42532g(context, interfaceC7337jk, iAd);
            m42510a(context, c7560ouM42538l, appInfo);
        }
        this.f32470a.m42560b((C7046e) appDownloadTaskM42507a);
        C7050i.m42430a(context);
        C7050i.m42427a().m42445a(appDownloadTaskM42507a, new C7050i.b() { // from class: com.huawei.openalliance.ad.download.app.m.5
            @Override // com.huawei.openalliance.p169ad.download.app.C7050i.b
            /* renamed from: a */
            public void mo42463a(AppDownloadTask appDownloadTask) {
                if (appDownloadTask == null || appDownloadTask.m42077i() == EnumC7062e.INSTALLED || !appDownloadTask.m42230J()) {
                    return;
                }
                C7056m.this.m42502a(context, (InterfaceC7337jk) null, iAd, false);
            }
        });
        return 0;
    }

    /* renamed from: b */
    private int m42517b(final Context context, final InterfaceC7337jk interfaceC7337jk, final IAd iAd, final boolean z10) {
        AppInfo appInfo = iAd.getAppInfo();
        int iM48436f = C7830i.m48436f(context, "com.huawei.appmarket");
        if (m42528c(appInfo) && iM48436f >= 100300300) {
            return m42525c(context, interfaceC7337jk, iAd, z10);
        }
        ContentRecord contentRecordM42519b = m42519b(iAd);
        AppDownloadTask appDownloadTaskM42520b = m42520b(context, contentRecordM42519b, appInfo);
        m42522b(context, iAd, appDownloadTaskM42520b);
        if ((appDownloadTaskM42520b != null && appDownloadTaskM42520b.m42083o()) || appInfo.isAllowedNonWifiNetwork()) {
            appInfo.setAllowedNonWifiNetwork(true);
            return m42525c(context, interfaceC7337jk, iAd, z10);
        }
        C7073dq c7073dq = new C7073dq(context);
        c7073dq.m42023a(new AbstractC7026do.a() { // from class: com.huawei.openalliance.ad.download.app.m.3
            @Override // com.huawei.openalliance.p169ad.AbstractC7026do.a
            /* renamed from: a */
            public void mo42028a(AppInfo appInfo2) {
                appInfo2.setAllowedNonWifiNetwork(true);
                C7056m.this.m42525c(context, interfaceC7337jk, iAd, z10);
            }

            @Override // com.huawei.openalliance.p169ad.AbstractC7026do.a
            /* renamed from: b */
            public void mo42029b(AppInfo appInfo2) {
                C7056m.this.m42511a(AppStatusV1.PRE_CHECK_FAILED, 1003, appInfo2);
            }

            @Override // com.huawei.openalliance.p169ad.AbstractC7026do.a
            /* renamed from: c */
            public void mo42030c(AppInfo appInfo2) {
                C7056m.this.m42537k(context, iAd);
            }
        });
        c7073dq.mo42025a(appInfo, contentRecordM42519b, m42506a(context, contentRecordM42519b, appInfo));
        return -3;
    }

    /* renamed from: c */
    private int m42526c(IAd iAd) {
        if (iAd instanceof C7302e) {
            return 3;
        }
        return iAd instanceof C7304g ? 60 : -1;
    }

    /* renamed from: c */
    private boolean m42527c() {
        return this.f32472c.intValue() == 14 || this.f32472c.intValue() == 10005;
    }

    /* renamed from: b */
    private ContentRecord m42519b(IAd iAd) {
        if (iAd instanceof C7306i) {
            return ((C7306i) iAd).m44977a();
        }
        int iM42526c = m42526c(iAd);
        return iM42526c != 3 ? iM42526c != 60 ? new ContentRecord() : C7575pi.m46766a((C7304g) iAd) : C7570pd.m46698a((C7302e) iAd);
    }

    /* renamed from: c */
    private boolean m42528c(AppInfo appInfo) {
        if (appInfo == null) {
            return false;
        }
        return appInfo.m44374a(this.f32472c);
    }

    /* renamed from: a */
    private long m42506a(Context context, ContentRecord contentRecord, AppInfo appInfo) {
        if (appInfo == null) {
            return 0L;
        }
        AppDownloadTask appDownloadTaskM42520b = m42520b(context, contentRecord, appInfo);
        long fileSize = appInfo.getFileSize();
        if (appDownloadTaskM42520b == null) {
            return fileSize;
        }
        long fileSize2 = appInfo.getFileSize() - appDownloadTaskM42520b.m42075g();
        return fileSize2 <= 0 ? fileSize : fileSize2;
    }

    /* renamed from: b */
    private AppDownloadTask m42520b(Context context, ContentRecord contentRecord, AppInfo appInfo) {
        AppDownloadTask appDownloadTaskM42405d = this.f32470a.m42405d(appInfo);
        if (appDownloadTaskM42405d != null) {
            if (contentRecord != null) {
                appDownloadTaskM42405d.m42258k(contentRecord.m41585m());
                appDownloadTaskM42405d.m42259l(contentRecord.m41433Z());
                appDownloadTaskM42405d.m42260m(contentRecord.m41588n());
                appDownloadTaskM42405d.m42261n(contentRecord.m41577k());
            }
            if (appDownloadTaskM42405d.m42223C() == null && contentRecord != null) {
                C7560ou c7560ou = new C7560ou(context, C7662sk.m47225a(context, contentRecord.m41552f()));
                c7560ou.mo46590a(contentRecord);
                appDownloadTaskM42405d.m42244a(c7560ou);
            }
        }
        return appDownloadTaskM42405d;
    }

    /* renamed from: a */
    private AppDownloadTask m42507a(IAd iAd, C7560ou c7560ou) {
        AppInfo appInfo = iAd.getAppInfo();
        AppDownloadTask appDownloadTaskM42269a = new AppDownloadTask.C7040a().m42268a(true).m42265a(appInfo).m42267a(this.f32470a.m42407e(appInfo)).m42270b(this.f32470a.m42408f(appInfo)).m42266a(c7560ou).m42269a();
        if (appDownloadTaskM42269a != null) {
            appDownloadTaskM42269a.m42245a(this.f32472c);
            appDownloadTaskM42269a.m42247c(Integer.valueOf(this.f32471b));
            ContentRecord contentRecordMo46574a = c7560ou.mo46574a();
            appDownloadTaskM42269a.m42260m(iAd.getContentId());
            if (contentRecordMo46574a != null) {
                appDownloadTaskM42269a.m42259l(contentRecordMo46574a.m41433Z());
                appDownloadTaskM42269a.m42258k(contentRecordMo46574a.m41585m());
                appDownloadTaskM42269a.m42261n(iAd.getShowId());
            }
        }
        return appDownloadTaskM42269a;
    }

    @Override // com.huawei.openalliance.p169ad.download.app.interfaces.InterfaceC7051a
    /* renamed from: b */
    public void mo42473b() {
        this.f32470a.m42411k();
    }

    /* renamed from: b */
    public static void m42521b(Context context, final AppInfo appInfo) {
        if (appInfo == null) {
            AbstractC7185ho.m43820b("PPSAppDownloadManager", "appInfo is empty.");
        } else {
            AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.download.app.m.7
                @Override // java.lang.Runnable
                public void run() {
                    C7045d c7045dM42344a = C7045d.m42344a();
                    if (c7045dM42344a != null) {
                        c7045dM42344a.onUserCancel(appInfo);
                    }
                }
            });
        }
    }

    @Override // com.huawei.openalliance.p169ad.download.app.interfaces.InterfaceC7051a
    /* renamed from: a */
    public void mo42466a() {
        this.f32470a.m42410j();
    }

    /* renamed from: b */
    private void m42522b(final Context context, IAd iAd, AppDownloadTask appDownloadTask) {
        if (context == null || appDownloadTask == null || appDownloadTask.m42222B() == null || !(iAd instanceof C7306i)) {
            return;
        }
        final C7306i c7306i = (C7306i) iAd;
        String uniqueId = appDownloadTask.m42222B().getUniqueId();
        if (TextUtils.equals(uniqueId, c7306i.m44980b())) {
            return;
        }
        c7306i.m44979a(uniqueId);
        AbstractC7185ho.m43820b("PPSAppDownloadManager", "update uniqueId according to appInfo.");
        AbstractC7834m.m48479a(new Runnable() { // from class: com.huawei.openalliance.ad.download.app.m.4
            @Override // java.lang.Runnable
            public void run() {
                C7103es.m43094a(context).mo43116b(c7306i.m44977a());
            }
        });
    }

    @Override // com.huawei.openalliance.p169ad.download.app.interfaces.InterfaceC7051a
    /* renamed from: a */
    public void mo42467a(int i10) {
        this.f32471b = i10;
    }

    /* renamed from: a */
    public static void m42508a(Context context, final AppInfo appInfo) {
        if (appInfo == null) {
            AbstractC7185ho.m43820b("PPSAppDownloadManager", "appInfo is empty.");
        } else {
            AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.download.app.m.6
                @Override // java.lang.Runnable
                public void run() {
                    C7045d c7045dM42344a = C7045d.m42344a();
                    if (c7045dM42344a != null) {
                        c7045dM42344a.onAppOpen(appInfo);
                    }
                }
            });
        }
    }

    /* renamed from: b */
    private boolean m42523b(AppInfo appInfo) {
        String str;
        if (C7831j.m48460a(appInfo, this.f32472c)) {
            str = "appInfo is invalid";
        } else {
            if (this.f32470a != null) {
                return true;
            }
            str = "download manager is not init";
        }
        AbstractC7185ho.m43820b("PPSAppDownloadManager", str);
        return false;
    }

    @Override // com.huawei.openalliance.p169ad.download.app.interfaces.InterfaceC7051a
    /* renamed from: a */
    public void mo42468a(final Context context, final IAd iAd, final int i10) {
        if (context == null || iAd == null) {
            AbstractC7185ho.m43823c("PPSAppDownloadManager", "param err");
        } else {
            AbstractC7834m.m48488h(new Runnable() { // from class: com.huawei.openalliance.ad.download.app.m.8
                @Override // java.lang.Runnable
                public void run() {
                    new C6922c(context).m39061a(context, iAd, i10);
                }
            });
        }
    }

    /* renamed from: a */
    private void m42509a(Context context, IAd iAd, AppDownloadTask appDownloadTask) {
        if (context == null || appDownloadTask == null || iAd == null) {
            return;
        }
        InterfaceC7615qq interfaceC7615qqM42223C = appDownloadTask.m42223C();
        if (interfaceC7615qqM42223C != null) {
            ContentRecord contentRecordMo46574a = interfaceC7615qqM42223C.mo46574a();
            if (contentRecordMo46574a != null) {
                contentRecordMo46574a.m41536c(iAd.getShowId());
            }
        } else {
            appDownloadTask.m42244a(m42538l(context, iAd));
        }
        appDownloadTask.m42261n(iAd.getShowId());
    }

    /* renamed from: a */
    private void m42510a(Context context, InterfaceC7615qq interfaceC7615qq, AppInfo appInfo) {
        if (interfaceC7615qq == null || appInfo == null) {
            return;
        }
        String str = m42514a(appInfo) ? ClickDestination.AGMINIMARKET : "download";
        if ("11".equals(appInfo.m44440z())) {
            str = "restore";
        }
        MaterialClickInfo materialClickInfo = new MaterialClickInfo();
        materialClickInfo.m44515f(1);
        C7587b.a aVar = new C7587b.a();
        aVar.m46920b(str).m46915a((Integer) 6).m46914a(materialClickInfo).m46923d(C7753b.m47699a(context));
        interfaceC7615qq.mo46594a(aVar.m46918a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m42511a(AppStatusV1 appStatusV1, int i10, AppInfo appInfo) {
        if (this.f32474e != null) {
            AbstractC7185ho.m43820b("PPSAppDownloadManager", "task status:" + appStatusV1 + ", code:" + i10);
            this.f32474e.onNewStatusChanged(appStatusV1, i10, appInfo);
        }
    }

    /* renamed from: a */
    private void m42513a(IAd iAd, AppDownloadTask appDownloadTask) {
        RewardVerifyConfig rewardVerifyConfig = iAd.getRewardVerifyConfig();
        if (rewardVerifyConfig != null) {
            appDownloadTask.m42254g(rewardVerifyConfig.getData());
            appDownloadTask.m42255h(rewardVerifyConfig.getUserId());
            ContentRecord contentRecordM42239S = appDownloadTask.m42239S();
            if (contentRecordM42239S != null) {
                contentRecordM42239S.m41396G(rewardVerifyConfig.getData());
                contentRecordM42239S.m41398H(rewardVerifyConfig.getUserId());
            }
        }
        appDownloadTask.m42245a(this.f32472c);
        appDownloadTask.m42246b(this.f32472c);
        appDownloadTask.m42247c(Integer.valueOf(this.f32471b));
        appDownloadTask.m42260m(iAd.getContentId());
    }

    @Override // com.huawei.openalliance.p169ad.download.app.interfaces.InterfaceC7051a
    /* renamed from: a */
    public void mo42469a(AppDownloadButton.OnResolutionRequiredListener onResolutionRequiredListener) {
        if (onResolutionRequiredListener == null) {
            return;
        }
        this.f32470a.m42392a(onResolutionRequiredListener);
    }

    @Override // com.huawei.openalliance.p169ad.download.app.interfaces.InterfaceC7051a
    /* renamed from: a */
    public void mo42470a(Integer num) {
        this.f32472c = num;
    }

    @Override // com.huawei.openalliance.p169ad.download.app.interfaces.InterfaceC7051a
    /* renamed from: a */
    public boolean mo42471a(Context context, IAd iAd, boolean z10) {
        return z10 ? m42533g(context, iAd) && m42540n(context, iAd) : m42540n(context, iAd);
    }

    /* renamed from: a */
    private boolean m42514a(AppInfo appInfo) {
        if (appInfo == null) {
            return false;
        }
        String strM44376b = appInfo.m44376b(this.f32472c);
        return (TextUtils.isEmpty(strM44376b) || TextUtils.isEmpty(appInfo.getPackageName()) || !strM44376b.equals("6")) ? false : true;
    }

    /* renamed from: a */
    private boolean m42515a(IAd iAd) {
        return (iAd == null || iAd.getAppInfo() == null || !"11".equals(iAd.getAppInfo().m44440z())) ? false : true;
    }
}
