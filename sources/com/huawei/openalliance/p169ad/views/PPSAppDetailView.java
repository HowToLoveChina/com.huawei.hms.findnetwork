package com.huawei.openalliance.p169ad.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.AbstractC7558os;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.C6982bz;
import com.huawei.openalliance.p169ad.C7019dh;
import com.huawei.openalliance.p169ad.C7022dk;
import com.huawei.openalliance.p169ad.C7124fh;
import com.huawei.openalliance.p169ad.C7574ph;
import com.huawei.openalliance.p169ad.C7650rz;
import com.huawei.openalliance.p169ad.C7653sb;
import com.huawei.openalliance.p169ad.C7654sc;
import com.huawei.openalliance.p169ad.C7694tp;
import com.huawei.openalliance.p169ad.InterfaceC6998co;
import com.huawei.openalliance.p169ad.InterfaceC7146gc;
import com.huawei.openalliance.p169ad.analysis.C6928i;
import com.huawei.openalliance.p169ad.beans.metadata.AdSource;
import com.huawei.openalliance.p169ad.beans.metadata.MetaData;
import com.huawei.openalliance.p169ad.constant.ClickDestination;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.download.app.AppStatus;
import com.huawei.openalliance.p169ad.inter.data.AdLandingPageData;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.p169ad.inter.listeners.INonwifiActionListener;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7807d;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import com.huawei.openalliance.p169ad.utils.C7752az;
import com.huawei.openalliance.p169ad.utils.C7822do;
import com.huawei.openalliance.p169ad.utils.C7831j;
import com.huawei.openalliance.p169ad.views.AppDownloadButton;
import com.huawei.openalliance.p169ad.views.interfaces.C8109b;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8106a;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8110c;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8112e;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8131x;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public class PPSAppDetailView extends RelativeLayout {

    /* renamed from: A */
    private ScanningRelativeLayout f36498A;

    /* renamed from: B */
    private ParticleRelativeLayout f36499B;

    /* renamed from: C */
    private InterfaceC8106a f36500C;

    /* renamed from: D */
    private int f36501D;

    /* renamed from: E */
    private int f36502E;

    /* renamed from: F */
    private MaterialClickInfo f36503F;

    /* renamed from: G */
    private long f36504G;

    /* renamed from: H */
    private int f36505H;

    /* renamed from: I */
    private int f36506I;

    /* renamed from: J */
    private Handler f36507J;

    /* renamed from: K */
    private View.OnClickListener f36508K;

    /* renamed from: L */
    private View.OnTouchListener f36509L;

    /* renamed from: a */
    protected Context f36510a;

    /* renamed from: b */
    protected AppDownloadButton f36511b;

    /* renamed from: c */
    protected int f36512c;

    /* renamed from: d */
    protected SixElementsView f36513d;

    /* renamed from: e */
    private AdLandingPageData f36514e;

    /* renamed from: f */
    private ImageView f36515f;

    /* renamed from: g */
    private PPSLabelView f36516g;

    /* renamed from: h */
    private boolean f36517h;

    /* renamed from: i */
    private AppInfo f36518i;

    /* renamed from: j */
    private InterfaceC7146gc f36519j;

    /* renamed from: k */
    private ContentRecord f36520k;

    /* renamed from: l */
    private View f36521l;

    /* renamed from: m */
    private C6928i f36522m;

    /* renamed from: n */
    private int f36523n;

    /* renamed from: o */
    private int f36524o;

    /* renamed from: p */
    private int f36525p;

    /* renamed from: q */
    private boolean f36526q;

    /* renamed from: r */
    private boolean f36527r;

    /* renamed from: s */
    private InterfaceC8110c f36528s;

    /* renamed from: t */
    private INonwifiActionListener f36529t;

    /* renamed from: u */
    private boolean f36530u;

    /* renamed from: v */
    private String f36531v;

    /* renamed from: w */
    private InterfaceC6998co f36532w;

    /* renamed from: x */
    private boolean f36533x;

    /* renamed from: y */
    private InterfaceC8112e f36534y;

    /* renamed from: z */
    private RelativeLayout f36535z;

    /* renamed from: com.huawei.openalliance.ad.views.PPSAppDetailView$a */
    public static class RunnableC7921a implements Runnable {

        /* renamed from: a */
        private String f36543a;

        /* renamed from: b */
        private C7752az.a f36544b;

        /* renamed from: c */
        private boolean f36545c;

        /* renamed from: d */
        private C7022dk f36546d;

        /* renamed from: e */
        private Context f36547e;

        public RunnableC7921a(String str, C7752az.a aVar, boolean z10, Context context) {
            this.f36543a = str;
            this.f36544b = aVar;
            this.f36545c = z10;
            context = context != null ? context.getApplicationContext() : context;
            this.f36547e = context;
            this.f36546d = C7019dh.m41937a(context, Constants.NORMAL_CACHE);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f36547e == null) {
                return;
            }
            C7653sb c7653sb = new C7653sb();
            c7653sb.m47181b(false);
            c7653sb.m47185c(true);
            c7653sb.m47180b("icon");
            c7653sb.m47187d(this.f36543a);
            if (!this.f36545c) {
                c7653sb.m47183c(C7124fh.m43316b(this.f36547e).mo43019e());
            }
            C7654sc c7654scM47158a = new C7650rz(this.f36547e, c7653sb).m47158a();
            if (c7654scM47158a == null) {
                return;
            }
            String strM47207a = c7654scM47158a.m47207a();
            if (TextUtils.isEmpty(strM47207a)) {
                return;
            }
            String strM41968c = this.f36546d.m41968c(strM47207a);
            if (TextUtils.isEmpty(strM41968c)) {
                return;
            }
            C7752az.m47690a(this.f36547e, strM41968c, new C7752az.a() { // from class: com.huawei.openalliance.ad.views.PPSAppDetailView.a.1
                @Override // com.huawei.openalliance.p169ad.utils.C7752az.a
                /* renamed from: a */
                public void mo30231a() {
                }

                @Override // com.huawei.openalliance.p169ad.utils.C7752az.a
                /* renamed from: a */
                public void mo30232a(final Drawable drawable) {
                    if (drawable == null) {
                        return;
                    }
                    AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSAppDetailView.a.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            RunnableC7921a.this.f36544b.mo30232a(drawable);
                        }
                    });
                }
            });
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.PPSAppDetailView$b */
    public static class C7922b implements C7752az.a {

        /* renamed from: a */
        private WeakReference<ImageView> f36551a;

        public C7922b(ImageView imageView) {
            this.f36551a = new WeakReference<>(imageView);
        }

        @Override // com.huawei.openalliance.p169ad.utils.C7752az.a
        /* renamed from: a */
        public void mo30231a() {
        }

        @Override // com.huawei.openalliance.p169ad.utils.C7752az.a
        /* renamed from: a */
        public void mo30232a(final Drawable drawable) {
            if (drawable == null) {
                return;
            }
            AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSAppDetailView.b.1
                @Override // java.lang.Runnable
                public void run() {
                    ImageView imageView = (ImageView) C7922b.this.f36551a.get();
                    if (imageView == null) {
                        return;
                    }
                    imageView.setBackground(null);
                    imageView.setImageDrawable(drawable);
                }
            });
        }
    }

    public PPSAppDetailView(Context context) {
        super(context);
        this.f36517h = false;
        this.f36524o = 0;
        this.f36525p = 0;
        this.f36526q = true;
        this.f36527r = true;
        this.f36530u = false;
        this.f36512c = 0;
        this.f36533x = true;
        this.f36501D = 0;
        this.f36504G = -1L;
        this.f36505H = 5;
        this.f36506I = 5;
        this.f36507J = new Handler(Looper.myLooper(), new Handler.Callback() { // from class: com.huawei.openalliance.ad.views.PPSAppDetailView.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (!PPSAppDetailView.this.m48951k()) {
                    return true;
                }
                PPSAppDetailView.this.m48965c();
                return true;
            }
        });
        this.f36508K = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSAppDetailView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PPSAppDetailView.this.f36526q) {
                    PPSAppDetailView.this.f36511b.onClick(null);
                    if (PPSAppDetailView.this.f36528s != null) {
                        PPSAppDetailView.this.f36528s.mo38703a(new C8109b(PPSAppDetailView.this.f36526q, true, AppStatus.INSTALLED == PPSAppDetailView.this.f36511b.getStatus() ? "app" : ""));
                        return;
                    }
                    return;
                }
                if (PPSAppDetailView.this.f36528s != null) {
                    PPSAppDetailView.this.f36528s.mo38703a(new C8109b(false, false, PPSAppDetailView.this.getClickDestination()));
                } else {
                    AbstractC7185ho.m43820b("PPSAppDetailView", "onButtonClick, appDetailClickListener is null");
                }
            }
        };
        this.f36509L = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.PPSAppDetailView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                AbstractC7185ho.m43821b("PPSAppDetailView", "action: %s, viewId: %s", Integer.valueOf(motionEvent.getAction()), Integer.valueOf(view.getId()));
                if (PPSAppDetailView.this.f36511b != null) {
                    int action = motionEvent.getAction();
                    if (action == 0) {
                        PPSAppDetailView.this.f36524o = (int) motionEvent.getRawX();
                        PPSAppDetailView.this.f36525p = (int) motionEvent.getRawY();
                    } else if (action == 1) {
                        int rawX = (int) motionEvent.getRawX();
                        int rawY = (int) motionEvent.getRawY();
                        if (PPSAppDetailView.this.f36526q) {
                            PPSAppDetailView.this.f36511b.setClickActionListener(new InterfaceC8131x() { // from class: com.huawei.openalliance.ad.views.PPSAppDetailView.3.1
                                @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8131x
                                /* renamed from: a */
                                public void mo30555a(AppDownloadButton appDownloadButton) {
                                    if (PPSAppDetailView.this.f36528s != null) {
                                        PPSAppDetailView.this.f36528s.mo38703a(new C8109b(PPSAppDetailView.this.f36526q, false, AppStatus.INSTALLED == appDownloadButton.getStatus() ? "app" : ""));
                                    }
                                }

                                @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8131x
                                /* renamed from: b */
                                public void mo30556b(AppDownloadButton appDownloadButton) {
                                    if (PPSAppDetailView.this.f36528s != null) {
                                        PPSAppDetailView.this.f36528s.mo38703a(new C8109b(PPSAppDetailView.this.f36526q, true, AppStatus.INSTALLED == appDownloadButton.getStatus() ? "app" : ""));
                                    }
                                }
                            });
                        }
                        PPSAppDetailView pPSAppDetailView = PPSAppDetailView.this;
                        pPSAppDetailView.m48930a(pPSAppDetailView.f36526q);
                        if (!AbstractC7811dd.m48299a(PPSAppDetailView.this.f36524o, PPSAppDetailView.this.f36525p, rawX, rawY, PPSAppDetailView.this.f36523n)) {
                            if (AbstractC7185ho.m43819a()) {
                                AbstractC7185ho.m43818a("PPSAppDetailView", "touch up download area x=%d, y=%d", Integer.valueOf(rawX), Integer.valueOf(rawY));
                            }
                            PPSAppDetailView.this.f36522m.m39197a(rawX, rawY, PPSAppDetailView.this.f36520k);
                        }
                    }
                }
                return true;
            }
        };
        m48933b(context, (AttributeSet) null);
    }

    /* renamed from: c */
    private int m48935c(Context context) {
        if (C6849R.layout.hiad_landing_expand_button_detail_half == mo48921a(context)) {
            return AbstractC7741ao.m47535a(context, AbstractC7811dd.m48336l(context) ? Constants.INTERSTITIAL_WIDTH : Constants.INTERSTITIAL_LAND_WIDTH);
        }
        return AbstractC7807d.m48203a(context, AbstractC7811dd.m48335k(context));
    }

    private int getButtonRadius() {
        AppDownloadButton appDownloadButton = getAppDownloadButton();
        if (appDownloadButton == null) {
            return 0;
        }
        return appDownloadButton.getRoundRadius();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getClickDestination() {
        return this.f36502E == 9 ? ClickDestination.HARMONY_SERVICE : "web";
    }

    /* renamed from: m */
    private boolean m48954m() {
        return m48956n() && AbstractC7558os.m46485x(this.f36514e.m44290f());
    }

    /* renamed from: n */
    private boolean m48956n() {
        AppDownloadButton appDownloadButton;
        if (this.f36514e == null || this.f36534y == null || (appDownloadButton = this.f36511b) == null) {
            return false;
        }
        AppStatus appStatusRefreshStatus = appDownloadButton.refreshStatus();
        return appStatusRefreshStatus == AppStatus.DOWNLOAD || appStatusRefreshStatus == AppStatus.INSTALLED;
    }

    /* renamed from: o */
    private void m48957o() {
        AppDownloadButton appDownloadButton;
        AppDownloadButtonStyle extandAppDownloadButtonStyle;
        InterfaceC6998co interfaceC6998co = this.f36532w;
        if (interfaceC6998co == null || this.f36511b == null) {
            return;
        }
        if (interfaceC6998co.mo41178g()) {
            appDownloadButton = this.f36511b;
            extandAppDownloadButtonStyle = new ExtandAppDownloadButtonStyleHm(this.f36510a);
        } else {
            appDownloadButton = this.f36511b;
            extandAppDownloadButtonStyle = new ExtandAppDownloadButtonStyle(this.f36510a);
        }
        appDownloadButton.setAppDownloadButtonStyle(extandAppDownloadButtonStyle);
        this.f36511b.refreshStatus();
    }

    private void setCancelDownloadButtonVisibility(AppStatus appStatus) {
        AppInfo appInfo;
        if (appStatus == AppStatus.DOWNLOAD && (appInfo = this.f36514e.getAppInfo()) != null && appInfo.m44435w()) {
            m48927a(appInfo);
        }
    }

    /* renamed from: a */
    public int mo48921a(Context context) {
        return this.f36512c == 1 ? C6849R.layout.hiad_landing_app_detail_half : C6849R.layout.hiad_landing_app_detail;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            if (C7694tp.m47282a(motionEvent) == 0) {
                MaterialClickInfo materialClickInfoM47286b = C7694tp.m47286b(this, motionEvent);
                this.f36503F = materialClickInfoM47286b;
                AppDownloadButton appDownloadButton = this.f36511b;
                if (appDownloadButton != null) {
                    appDownloadButton.m48702a(materialClickInfoM47286b);
                }
            }
            if (1 == motionEvent.getAction()) {
                C7694tp.m47287b(this, motionEvent, null, this.f36503F);
                AppDownloadButton appDownloadButton2 = this.f36511b;
                if (appDownloadButton2 != null) {
                    appDownloadButton2.m48702a(this.f36503F);
                }
                SixElementsView sixElementsView = this.f36513d;
                if (sixElementsView != null) {
                    sixElementsView.setOrgClickInfo(this.f36503F);
                }
            }
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("PPSAppDetailView", "dispatchTouchEvent exception : %s", th2.getClass().getSimpleName());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public AppDownloadButton getAppDownloadButton() {
        return this.f36511b;
    }

    public AppInfo getAppInfo() {
        return this.f36518i;
    }

    public int getDetailStyle() {
        return 1;
    }

    public void setAdLandingData(AdLandingPageData adLandingPageData) {
        String str;
        if (adLandingPageData == null) {
            return;
        }
        try {
            AbstractC7185ho.m43820b("PPSAppDetailView", "set ad landing data");
            this.f36514e = adLandingPageData;
            this.f36520k = adLandingPageData.m44329y();
            this.f36518i = this.f36514e.getAppInfo();
            PPSLabelView pPSLabelView = this.f36516g;
            if (pPSLabelView != null) {
                pPSLabelView.setDataAndRefreshUi(this.f36520k);
            }
            if (this.f36518i == null) {
                m48925a(this.f36521l, 8);
            } else {
                mo48922a();
            }
            MetaData metaData = (MetaData) AbstractC7758be.m47739b(this.f36514e.m44319t(), MetaData.class, new Class[0]);
            if (metaData != null) {
                this.f36531v = AbstractC7806cz.m48168c(metaData.m40280a());
            }
            this.f36533x = adLandingPageData.m44252A();
        } catch (RuntimeException unused) {
            str = "setAdLandingPageData RuntimeException";
            AbstractC7185ho.m43823c("PPSAppDetailView", str);
        } catch (Exception unused2) {
            str = "setAdLandingPageData error";
            AbstractC7185ho.m43823c("PPSAppDetailView", str);
        }
    }

    public void setAppDetailClickListener(InterfaceC8110c interfaceC8110c) {
        this.f36528s = interfaceC8110c;
    }

    public void setAppIconImageDrawable(Drawable drawable) {
        ImageView imageView = this.f36515f;
        if (imageView == null || drawable == null) {
            return;
        }
        imageView.setBackground(null);
        this.f36515f.setImageDrawable(drawable);
    }

    public void setAppRelated(boolean z10) {
        this.f36526q = z10;
    }

    public void setBtnSource(int i10) {
        this.f36505H = i10;
        AppDownloadButton appDownloadButton = this.f36511b;
        if (appDownloadButton != null) {
            appDownloadButton.setSource(i10);
        }
    }

    public void setDetailViewType(int i10) {
        this.f36501D = i10;
    }

    public void setInterType(int i10) {
        this.f36502E = i10;
    }

    public void setInteractedListener(InterfaceC8106a interfaceC8106a) {
        this.f36500C = interfaceC8106a;
    }

    public void setLoadAppIconSelf(boolean z10) {
        this.f36527r = z10;
    }

    public void setNeedPerBeforDownload(boolean z10) {
        this.f36530u = z10;
    }

    public void setNeedShowDspInfo(boolean z10) {
        this.f36517h = z10;
    }

    public void setNonBtnSource(int i10) {
        this.f36506I = i10;
    }

    public void setOnNonWifiDownloadListener(INonwifiActionListener iNonwifiActionListener) {
        this.f36529t = iNonwifiActionListener;
    }

    public PPSAppDetailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f36517h = false;
        this.f36524o = 0;
        this.f36525p = 0;
        this.f36526q = true;
        this.f36527r = true;
        this.f36530u = false;
        this.f36512c = 0;
        this.f36533x = true;
        this.f36501D = 0;
        this.f36504G = -1L;
        this.f36505H = 5;
        this.f36506I = 5;
        this.f36507J = new Handler(Looper.myLooper(), new Handler.Callback() { // from class: com.huawei.openalliance.ad.views.PPSAppDetailView.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (!PPSAppDetailView.this.m48951k()) {
                    return true;
                }
                PPSAppDetailView.this.m48965c();
                return true;
            }
        });
        this.f36508K = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSAppDetailView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PPSAppDetailView.this.f36526q) {
                    PPSAppDetailView.this.f36511b.onClick(null);
                    if (PPSAppDetailView.this.f36528s != null) {
                        PPSAppDetailView.this.f36528s.mo38703a(new C8109b(PPSAppDetailView.this.f36526q, true, AppStatus.INSTALLED == PPSAppDetailView.this.f36511b.getStatus() ? "app" : ""));
                        return;
                    }
                    return;
                }
                if (PPSAppDetailView.this.f36528s != null) {
                    PPSAppDetailView.this.f36528s.mo38703a(new C8109b(false, false, PPSAppDetailView.this.getClickDestination()));
                } else {
                    AbstractC7185ho.m43820b("PPSAppDetailView", "onButtonClick, appDetailClickListener is null");
                }
            }
        };
        this.f36509L = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.PPSAppDetailView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                AbstractC7185ho.m43821b("PPSAppDetailView", "action: %s, viewId: %s", Integer.valueOf(motionEvent.getAction()), Integer.valueOf(view.getId()));
                if (PPSAppDetailView.this.f36511b != null) {
                    int action = motionEvent.getAction();
                    if (action == 0) {
                        PPSAppDetailView.this.f36524o = (int) motionEvent.getRawX();
                        PPSAppDetailView.this.f36525p = (int) motionEvent.getRawY();
                    } else if (action == 1) {
                        int rawX = (int) motionEvent.getRawX();
                        int rawY = (int) motionEvent.getRawY();
                        if (PPSAppDetailView.this.f36526q) {
                            PPSAppDetailView.this.f36511b.setClickActionListener(new InterfaceC8131x() { // from class: com.huawei.openalliance.ad.views.PPSAppDetailView.3.1
                                @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8131x
                                /* renamed from: a */
                                public void mo30555a(AppDownloadButton appDownloadButton) {
                                    if (PPSAppDetailView.this.f36528s != null) {
                                        PPSAppDetailView.this.f36528s.mo38703a(new C8109b(PPSAppDetailView.this.f36526q, false, AppStatus.INSTALLED == appDownloadButton.getStatus() ? "app" : ""));
                                    }
                                }

                                @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8131x
                                /* renamed from: b */
                                public void mo30556b(AppDownloadButton appDownloadButton) {
                                    if (PPSAppDetailView.this.f36528s != null) {
                                        PPSAppDetailView.this.f36528s.mo38703a(new C8109b(PPSAppDetailView.this.f36526q, true, AppStatus.INSTALLED == appDownloadButton.getStatus() ? "app" : ""));
                                    }
                                }
                            });
                        }
                        PPSAppDetailView pPSAppDetailView = PPSAppDetailView.this;
                        pPSAppDetailView.m48930a(pPSAppDetailView.f36526q);
                        if (!AbstractC7811dd.m48299a(PPSAppDetailView.this.f36524o, PPSAppDetailView.this.f36525p, rawX, rawY, PPSAppDetailView.this.f36523n)) {
                            if (AbstractC7185ho.m43819a()) {
                                AbstractC7185ho.m43818a("PPSAppDetailView", "touch up download area x=%d, y=%d", Integer.valueOf(rawX), Integer.valueOf(rawY));
                            }
                            PPSAppDetailView.this.f36522m.m39197a(rawX, rawY, PPSAppDetailView.this.f36520k);
                        }
                    }
                }
                return true;
            }
        };
        m48933b(context, attributeSet);
    }

    /* renamed from: e */
    private boolean m48939e() {
        AdLandingPageData adLandingPageData = this.f36514e;
        if (adLandingPageData != null) {
            return AbstractC7558os.m46476o(adLandingPageData.m44290f()) || (AbstractC7558os.m46478q(this.f36514e.m44290f()) && this.f36501D == 1);
        }
        return false;
    }

    /* renamed from: f */
    private boolean m48941f() {
        AdLandingPageData adLandingPageData = this.f36514e;
        if (adLandingPageData != null) {
            return AbstractC7558os.m46477p(adLandingPageData.m44290f());
        }
        return false;
    }

    /* renamed from: g */
    private boolean m48943g() {
        AdLandingPageData adLandingPageData = this.f36514e;
        return adLandingPageData != null && AbstractC7558os.m46478q(adLandingPageData.m44290f()) && this.f36501D == 0;
    }

    /* renamed from: h */
    private void m48945h() {
        ContentRecord contentRecord;
        MetaData metaDataM41568i;
        AdSource adSourceM39549b;
        if (!"zh".equalsIgnoreCase(AbstractC7807d.m48204a()) || (contentRecord = this.f36520k) == null || !this.f36517h || (metaDataM41568i = contentRecord.m41568i()) == null || (adSourceM39549b = AdSource.m39549b(metaDataM41568i.m40275L())) == null || this.f36516g == null) {
            return;
        }
        if (TextUtils.isEmpty(adSourceM39549b.m39551a()) && TextUtils.isEmpty(adSourceM39549b.m39554b())) {
            AbstractC7185ho.m43817a("PPSAppDetailView", "loadDspInfo error");
            this.f36516g.setVisibility(8);
        } else {
            AbstractC7185ho.m43817a("PPSAppDetailView", "loading dsp info");
            this.f36516g.setVisibility(8);
            this.f36516g.setTextForAppDetailView(adSourceM39549b);
        }
    }

    /* renamed from: i */
    private void m48947i() {
        InterfaceC8112e interfaceC8112e;
        InterfaceC8112e interfaceC8112e2;
        AppDownloadButton appDownloadButton = this.f36511b;
        if (appDownloadButton != null) {
            appDownloadButton.setAdLandingPageData(this.f36514e);
            this.f36511b.setNeedShowPermision(this.f36530u);
            AbstractC7185ho.m43821b("PPSAppDetailView", "enable btn scan: %s", Boolean.valueOf(AbstractC7558os.m46485x(this.f36514e.m44290f())));
            AbstractC7185ho.m43821b("PPSAppDetailView", "enable btn particle: %s", Boolean.valueOf(AbstractC7558os.m46486y(this.f36514e.m44290f())));
            if (!m48954m() || (interfaceC8112e2 = this.f36534y) == null || interfaceC8112e2.mo49785b()) {
                if (m48953l() && (interfaceC8112e = this.f36534y) != null && !interfaceC8112e.mo49785b()) {
                    AbstractC7185ho.m43820b("PPSAppDetailView", "show btn particle animation");
                }
                m48957o();
            } else {
                this.f36511b.setAppDownloadButtonStyle(new C8067ab(this.f36510a));
            }
            this.f36511b.setOnDownloadStatusChangedListener(new AppDownloadButton.OnDownloadStatusChangedListener() { // from class: com.huawei.openalliance.ad.views.PPSAppDetailView.4
                @Override // com.huawei.openalliance.ad.views.AppDownloadButton.OnDownloadStatusChangedListener
                public void onStatusChanged(AppStatus appStatus) {
                    PPSAppDetailView.this.m48926a(appStatus);
                }

                @Override // com.huawei.openalliance.ad.views.AppDownloadButton.OnDownloadStatusChangedListener
                public void onUserCancel(AppInfo appInfo) {
                }
            });
            this.f36511b.setButtonTextWatcherInner(new AppDownloadButton.InterfaceC7878e() { // from class: com.huawei.openalliance.ad.views.PPSAppDetailView.5
                @Override // com.huawei.openalliance.p169ad.views.AppDownloadButton.InterfaceC7878e
                /* renamed from: a */
                public CharSequence mo30554a(CharSequence charSequence, AppStatus appStatus) {
                    return !PPSAppDetailView.this.f36526q ? C7831j.m48456a(PPSAppDetailView.this.f36531v, PPSAppDetailView.this.f36510a.getString(C6849R.string.hiad_download_open)) : charSequence;
                }
            });
            this.f36511b.setOnNonWifiDownloadListener(new AppDownloadButton.OnNonWifiDownloadListener() { // from class: com.huawei.openalliance.ad.views.PPSAppDetailView.6
                @Override // com.huawei.openalliance.ad.views.AppDownloadButton.OnNonWifiDownloadListener
                public boolean onNonWifiDownload(AppInfo appInfo, long j10) {
                    if ((PPSAppDetailView.this.f36529t == null || !PPSAppDetailView.this.f36529t.onAppDownload(appInfo, j10)) && PPSAppDetailView.this.f36519j.mo43413bn() && PPSAppDetailView.this.f36533x) {
                        PPSAppDetailView.this.f36511b.m48705b();
                        return false;
                    }
                    PPSAppDetailView.this.f36511b.setAllowedNonWifiNetwork(true);
                    return true;
                }
            });
            this.f36511b.setSource(this.f36505H);
        }
    }

    /* renamed from: j */
    private void m48949j() {
        if (AbstractC7558os.m46485x(this.f36514e.m44290f())) {
            ScanningRelativeLayout scanningRelativeLayout = this.f36498A;
            this.f36534y = scanningRelativeLayout;
            this.f36535z = scanningRelativeLayout;
            C7822do.m48384a((View) scanningRelativeLayout, true);
        } else {
            if (AbstractC7558os.m46486y(this.f36514e.m44290f())) {
                ParticleRelativeLayout particleRelativeLayout = this.f36499B;
                this.f36534y = particleRelativeLayout;
                this.f36535z = particleRelativeLayout;
                C7822do.m48384a((View) this.f36498A, false);
                C7822do.m48384a((View) this.f36499B, true);
                return;
            }
            C7822do.m48384a((View) this.f36498A, false);
        }
        C7822do.m48384a((View) this.f36499B, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public boolean m48951k() {
        return m48956n() && !AbstractC7558os.m46484w(this.f36514e.m44290f());
    }

    /* renamed from: l */
    private boolean m48953l() {
        return m48956n() && AbstractC7558os.m46486y(this.f36514e.m44290f());
    }

    /* renamed from: b */
    public void m48963b() {
        AppDownloadButton appDownloadButton = this.f36511b;
        if (appDownloadButton != null) {
            m48925a(appDownloadButton, 8);
        }
    }

    /* renamed from: d */
    public void m48966d() {
        InterfaceC8112e interfaceC8112e = this.f36534y;
        if (interfaceC8112e == null || !interfaceC8112e.mo49785b()) {
            return;
        }
        AbstractC7185ho.m43820b("PPSAppDetailView", "stop animation.");
        C7822do.m48384a((View) this.f36535z, false);
        this.f36534y.mo49783a();
    }

    public PPSAppDetailView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f36517h = false;
        this.f36524o = 0;
        this.f36525p = 0;
        this.f36526q = true;
        this.f36527r = true;
        this.f36530u = false;
        this.f36512c = 0;
        this.f36533x = true;
        this.f36501D = 0;
        this.f36504G = -1L;
        this.f36505H = 5;
        this.f36506I = 5;
        this.f36507J = new Handler(Looper.myLooper(), new Handler.Callback() { // from class: com.huawei.openalliance.ad.views.PPSAppDetailView.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (!PPSAppDetailView.this.m48951k()) {
                    return true;
                }
                PPSAppDetailView.this.m48965c();
                return true;
            }
        });
        this.f36508K = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSAppDetailView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PPSAppDetailView.this.f36526q) {
                    PPSAppDetailView.this.f36511b.onClick(null);
                    if (PPSAppDetailView.this.f36528s != null) {
                        PPSAppDetailView.this.f36528s.mo38703a(new C8109b(PPSAppDetailView.this.f36526q, true, AppStatus.INSTALLED == PPSAppDetailView.this.f36511b.getStatus() ? "app" : ""));
                        return;
                    }
                    return;
                }
                if (PPSAppDetailView.this.f36528s != null) {
                    PPSAppDetailView.this.f36528s.mo38703a(new C8109b(false, false, PPSAppDetailView.this.getClickDestination()));
                } else {
                    AbstractC7185ho.m43820b("PPSAppDetailView", "onButtonClick, appDetailClickListener is null");
                }
            }
        };
        this.f36509L = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.PPSAppDetailView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                AbstractC7185ho.m43821b("PPSAppDetailView", "action: %s, viewId: %s", Integer.valueOf(motionEvent.getAction()), Integer.valueOf(view.getId()));
                if (PPSAppDetailView.this.f36511b != null) {
                    int action = motionEvent.getAction();
                    if (action == 0) {
                        PPSAppDetailView.this.f36524o = (int) motionEvent.getRawX();
                        PPSAppDetailView.this.f36525p = (int) motionEvent.getRawY();
                    } else if (action == 1) {
                        int rawX = (int) motionEvent.getRawX();
                        int rawY = (int) motionEvent.getRawY();
                        if (PPSAppDetailView.this.f36526q) {
                            PPSAppDetailView.this.f36511b.setClickActionListener(new InterfaceC8131x() { // from class: com.huawei.openalliance.ad.views.PPSAppDetailView.3.1
                                @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8131x
                                /* renamed from: a */
                                public void mo30555a(AppDownloadButton appDownloadButton) {
                                    if (PPSAppDetailView.this.f36528s != null) {
                                        PPSAppDetailView.this.f36528s.mo38703a(new C8109b(PPSAppDetailView.this.f36526q, false, AppStatus.INSTALLED == appDownloadButton.getStatus() ? "app" : ""));
                                    }
                                }

                                @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8131x
                                /* renamed from: b */
                                public void mo30556b(AppDownloadButton appDownloadButton) {
                                    if (PPSAppDetailView.this.f36528s != null) {
                                        PPSAppDetailView.this.f36528s.mo38703a(new C8109b(PPSAppDetailView.this.f36526q, true, AppStatus.INSTALLED == appDownloadButton.getStatus() ? "app" : ""));
                                    }
                                }
                            });
                        }
                        PPSAppDetailView pPSAppDetailView = PPSAppDetailView.this;
                        pPSAppDetailView.m48930a(pPSAppDetailView.f36526q);
                        if (!AbstractC7811dd.m48299a(PPSAppDetailView.this.f36524o, PPSAppDetailView.this.f36525p, rawX, rawY, PPSAppDetailView.this.f36523n)) {
                            if (AbstractC7185ho.m43819a()) {
                                AbstractC7185ho.m43818a("PPSAppDetailView", "touch up download area x=%d, y=%d", Integer.valueOf(rawX), Integer.valueOf(rawY));
                            }
                            PPSAppDetailView.this.f36522m.m39197a(rawX, rawY, PPSAppDetailView.this.f36520k);
                        }
                    }
                }
                return true;
            }
        };
        m48933b(context, attributeSet);
    }

    /* renamed from: a */
    public void mo48922a() {
        ImageView imageView;
        m48945h();
        SixElementsView sixElementsView = this.f36513d;
        if (sixElementsView != null) {
            sixElementsView.m49942a(false);
            this.f36513d.mo49855a(this.f36514e);
        }
        if (this.f36527r && (imageView = this.f36515f) != null) {
            m48960a(imageView, this.f36518i.getIconUrl(), new C7922b(this.f36515f));
        }
        this.f36521l.setOnTouchListener(this.f36509L);
        m48949j();
        m48947i();
        this.f36507J.sendEmptyMessageDelayed(1001, 1500L);
        AppDownloadButton appDownloadButton = this.f36511b;
        if (appDownloadButton != null) {
            setCancelDownloadButtonVisibility(appDownloadButton.refreshStatus());
        }
    }

    /* renamed from: b */
    public void mo48964b(Context context) {
        AppDownloadButton appDownloadButton = (AppDownloadButton) findViewById(C6849R.id.app_download_btn);
        this.f36511b = appDownloadButton;
        if (appDownloadButton == null) {
            return;
        }
        this.f36511b.setTextColor(context.getResources().getColor(C6849R.color.hiad_emui_8_btn_color));
    }

    /* renamed from: c */
    public void m48965c() {
        m48957o();
        InterfaceC8112e interfaceC8112e = this.f36534y;
        if (interfaceC8112e == null || interfaceC8112e.mo49785b()) {
            return;
        }
        this.f36534y.setAutoRepeat(true);
        AbstractC7185ho.m43820b("PPSAppDetailView", "start animation.");
        try {
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(C6849R.id.app_download_btn_rl);
            C7822do.m48384a((View) this.f36535z, true);
            this.f36534y.mo49784a(relativeLayout, this.f36514e);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("PPSAppDetailView", "start animation error: %s", th2.getClass().getSimpleName());
        }
    }

    /* renamed from: b */
    private void m48933b(Context context, AttributeSet attributeSet) {
        String str;
        try {
            mo48923a(context, attributeSet);
            this.f36510a = context;
            this.f36532w = C6982bz.m41148a(context);
            this.f36519j = C7124fh.m43316b(context);
            this.f36522m = new C6928i(context);
            this.f36523n = ViewConfiguration.get(context).getScaledTouchSlop();
            this.f36521l = View.inflate(context, mo48921a(context), this);
            this.f36498A = (ScanningRelativeLayout) findViewById(C6849R.id.hiad_detail_btn_scan);
            this.f36499B = (ParticleRelativeLayout) findViewById(C6849R.id.hiad_detail_btn_particle);
            this.f36515f = (ImageView) findViewById(C6849R.id.app_icon);
            this.f36513d = (SixElementsView) findViewById(C6849R.id.app_detail_six_elements);
            PPSLabelView pPSLabelView = (PPSLabelView) findViewById(C6849R.id.hiad_dsp_info);
            this.f36516g = pPSLabelView;
            if (pPSLabelView != null) {
                pPSLabelView.setVisibility(8);
            }
            mo48964b(context);
            AppDownloadButton appDownloadButton = this.f36511b;
            if (appDownloadButton != null) {
                appDownloadButton.m49965a(this.f36508K);
                this.f36511b.setAppDetailView(this);
            }
            int buttonRadius = getButtonRadius();
            if (this.f36498A != null && buttonRadius > 0) {
                AbstractC7185ho.m43821b("PPSAppDetailView", "got button radius: %s", Integer.valueOf(buttonRadius));
                this.f36498A.setRadius(buttonRadius);
            }
            int iM48935c = m48935c(context);
            AbstractC7185ho.m43821b("PPSAppDetailView", "screenWidth is %d", Integer.valueOf(iM48935c));
            if (this.f36516g == null || !"zh".equalsIgnoreCase(AbstractC7807d.m48204a())) {
                return;
            }
            this.f36516g.setMaxWidth((int) (iM48935c * 0.25d));
        } catch (RuntimeException unused) {
            str = "init RuntimeException";
            AbstractC7185ho.m43823c("PPSAppDetailView", str);
        } catch (Exception unused2) {
            str = "init error";
            AbstractC7185ho.m43823c("PPSAppDetailView", str);
        }
    }

    /* renamed from: a */
    public void mo48958a(int i10) {
    }

    /* renamed from: a */
    public void m48959a(long j10) {
        ContentRecord contentRecord = this.f36520k;
        if (contentRecord == null) {
            return;
        }
        contentRecord.m41560g(j10);
        AppDownloadButton appDownloadButton = this.f36511b;
        if (appDownloadButton != null) {
            appDownloadButton.updateStartShowTime(j10);
        }
    }

    /* renamed from: a */
    public void mo48923a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C6849R.styleable.ViewFullScreen);
            if (typedArrayObtainStyledAttributes != null) {
                try {
                    int integer = typedArrayObtainStyledAttributes.getInteger(C6849R.styleable.ViewFullScreen_fullScreen, 0);
                    this.f36512c = integer;
                    AbstractC7185ho.m43818a("PPSAppDetailView", "FullScreen %d", Integer.valueOf(integer));
                } finally {
                }
            }
            typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C6849R.styleable.PPSAppDetailView);
            if (typedArrayObtainStyledAttributes != null) {
                try {
                    int integer2 = typedArrayObtainStyledAttributes.getInteger(C6849R.styleable.PPSAppDetailView_hiad_detail_type, 0);
                    this.f36501D = integer2;
                    AbstractC7185ho.m43818a("PPSAppDetailView", "detailViewType %d", Integer.valueOf(integer2));
                } finally {
                }
            }
        }
    }

    /* renamed from: a */
    private void m48925a(View view, int i10) {
        if (view != null) {
            view.setVisibility(i10);
        }
    }

    /* renamed from: a */
    public void m48960a(ImageView imageView, String str, C7752az.a aVar) {
        if (TextUtils.isEmpty(str) || imageView == null || this.f36510a == null) {
            return;
        }
        AbstractC7185ho.m43820b("PPSAppDetailView", "load app icon:" + AbstractC7806cz.m48174f(str));
        AbstractC7834m.m48484d(new RunnableC7921a(str, aVar, this.f36526q, this.f36510a));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m48926a(AppStatus appStatus) {
        setCancelDownloadButtonVisibility(appStatus);
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("PPSAppDetailView", "onStatusChanged: %s", appStatus);
        }
        if ((appStatus == AppStatus.DOWNLOAD || appStatus == AppStatus.INSTALLED) && m48951k()) {
            m48965c();
        } else {
            m48966d();
        }
    }

    /* renamed from: a */
    private void m48927a(AppInfo appInfo) {
        new C7574ph(this.f36510a).m46765a(appInfo);
    }

    /* renamed from: a */
    public void m48961a(Integer num) {
        InterfaceC8106a interfaceC8106a = this.f36500C;
        if (interfaceC8106a != null) {
            interfaceC8106a.mo47419a(num.intValue());
        }
    }

    /* renamed from: a */
    public void m48962a(String str) {
        ContentRecord contentRecord = this.f36520k;
        if (contentRecord != null) {
            contentRecord.m41536c(str);
            AppDownloadButton appDownloadButton = this.f36511b;
            if (appDownloadButton != null) {
                appDownloadButton.updateContent(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m48930a(boolean z10) {
        int i10;
        if (this.f36504G > 0 && AbstractC7741ao.m47566c() - this.f36504G <= 500) {
            AbstractC7185ho.m43823c("PPSAppDetailView", "fast click");
            return;
        }
        this.f36504G = AbstractC7741ao.m47566c();
        if (!z10) {
            if (this.f36528s == null || m48939e()) {
                return;
            }
            this.f36528s.mo38703a(new C8109b(false, false, getClickDestination(), 28));
            return;
        }
        if (m48941f()) {
            this.f36511b.setSource(this.f36506I);
            this.f36511b.performClick();
        } else if (this.f36528s != null) {
            C8109b c8109b = new C8109b(true, false, getClickDestination(), 28);
            if (!m48943g()) {
                i10 = m48939e() ? 1 : 0;
                this.f36528s.mo38703a(c8109b);
            }
            c8109b.m50301a(i10);
            this.f36528s.mo38703a(c8109b);
        }
    }
}
