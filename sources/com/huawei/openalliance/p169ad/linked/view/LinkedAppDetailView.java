package com.huawei.openalliance.p169ad.linked.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.C6982bz;
import com.huawei.openalliance.p169ad.C7019dh;
import com.huawei.openalliance.p169ad.C7022dk;
import com.huawei.openalliance.p169ad.C7124fh;
import com.huawei.openalliance.p169ad.C7650rz;
import com.huawei.openalliance.p169ad.C7653sb;
import com.huawei.openalliance.p169ad.C7654sc;
import com.huawei.openalliance.p169ad.C7694tp;
import com.huawei.openalliance.p169ad.InterfaceC7146gc;
import com.huawei.openalliance.p169ad.analysis.C6928i;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.download.app.AppStatus;
import com.huawei.openalliance.p169ad.inter.data.AdLandingPageData;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.p169ad.inter.listeners.INonwifiActionListener;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import com.huawei.openalliance.p169ad.utils.C7752az;
import com.huawei.openalliance.p169ad.views.AppDownloadButton;
import com.huawei.openalliance.p169ad.views.AppDownloadButtonStyle;
import com.huawei.openalliance.p169ad.views.ExtandAppDownloadButtonStyle;
import com.huawei.openalliance.p169ad.views.ExtandAppDownloadButtonStyleHm;
import com.huawei.openalliance.p169ad.views.interfaces.C8109b;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8110c;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8131x;

/* loaded from: classes2.dex */
public class LinkedAppDetailView extends RelativeLayout {

    /* renamed from: a */
    private Context f34311a;

    /* renamed from: b */
    private AppDownloadButton f34312b;

    /* renamed from: c */
    private TextView f34313c;

    /* renamed from: d */
    private ImageView f34314d;

    /* renamed from: e */
    private AppInfo f34315e;

    /* renamed from: f */
    private InterfaceC7146gc f34316f;

    /* renamed from: g */
    private ContentRecord f34317g;

    /* renamed from: h */
    private AdLandingPageData f34318h;

    /* renamed from: i */
    private View f34319i;

    /* renamed from: j */
    private C6928i f34320j;

    /* renamed from: k */
    private int f34321k;

    /* renamed from: l */
    private boolean f34322l;

    /* renamed from: m */
    private InterfaceC8110c f34323m;

    /* renamed from: n */
    private INonwifiActionListener f34324n;

    /* renamed from: o */
    private boolean f34325o;

    /* renamed from: p */
    private View.OnClickListener f34326p;

    /* renamed from: q */
    private C7022dk f34327q;

    /* renamed from: r */
    private MaterialClickInfo f34328r;

    /* renamed from: com.huawei.openalliance.ad.linked.view.LinkedAppDetailView$1 */
    public class C73901 implements InterfaceC8131x {
        public C73901() {
        }

        @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8131x
        /* renamed from: a */
        public void mo30555a(AppDownloadButton appDownloadButton) {
            if (LinkedAppDetailView.this.f34323m != null) {
                LinkedAppDetailView.this.f34323m.mo38703a(new C8109b(LinkedAppDetailView.this.f34322l, false, AppStatus.INSTALLED == appDownloadButton.getStatus() ? "app" : ""));
            }
        }

        @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8131x
        /* renamed from: b */
        public void mo30556b(AppDownloadButton appDownloadButton) {
            if (LinkedAppDetailView.this.f34323m != null) {
                String str = AppStatus.INSTALLED == appDownloadButton.getStatus() ? "app" : "";
                LinkedAppDetailView.this.f34320j.m39197a(0, 0, LinkedAppDetailView.this.f34317g);
                LinkedAppDetailView.this.f34323m.mo38703a(new C8109b(LinkedAppDetailView.this.f34322l, true, str));
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.linked.view.LinkedAppDetailView$2 */
    public class C73912 implements AppDownloadButton.OnDownloadStatusChangedListener {
        public C73912() {
        }

        @Override // com.huawei.openalliance.ad.views.AppDownloadButton.OnDownloadStatusChangedListener
        public void onStatusChanged(AppStatus appStatus) {
            LinkedAppDetailView.this.setCancelDownloadButtonVisibility(appStatus);
        }

        @Override // com.huawei.openalliance.ad.views.AppDownloadButton.OnDownloadStatusChangedListener
        public void onUserCancel(AppInfo appInfo) {
        }
    }

    /* renamed from: com.huawei.openalliance.ad.linked.view.LinkedAppDetailView$3 */
    public class C73923 implements AppDownloadButton.InterfaceC7878e {
        public C73923() {
        }

        @Override // com.huawei.openalliance.p169ad.views.AppDownloadButton.InterfaceC7878e
        /* renamed from: a */
        public CharSequence mo30554a(CharSequence charSequence, AppStatus appStatus) {
            return !LinkedAppDetailView.this.f34322l ? LinkedAppDetailView.this.f34311a.getString(C6849R.string.hiad_download_open) : charSequence;
        }
    }

    /* renamed from: com.huawei.openalliance.ad.linked.view.LinkedAppDetailView$4 */
    public class C73934 implements AppDownloadButton.OnNonWifiDownloadListener {
        public C73934() {
        }

        @Override // com.huawei.openalliance.ad.views.AppDownloadButton.OnNonWifiDownloadListener
        public boolean onNonWifiDownload(AppInfo appInfo, long j10) {
            if (LinkedAppDetailView.this.f34324n == null || !LinkedAppDetailView.this.f34324n.onAppDownload(appInfo, j10)) {
                LinkedAppDetailView.this.f34312b.m48705b();
                return false;
            }
            LinkedAppDetailView.this.f34312b.setAllowedNonWifiNetwork(true);
            return true;
        }
    }

    /* renamed from: com.huawei.openalliance.ad.linked.view.LinkedAppDetailView$5 */
    public class RunnableC73945 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f34333a;

        /* renamed from: b */
        final /* synthetic */ ImageView f34334b;

        /* renamed from: com.huawei.openalliance.ad.linked.view.LinkedAppDetailView$5$1 */
        public class AnonymousClass1 implements C7752az.a {

            /* renamed from: com.huawei.openalliance.ad.linked.view.LinkedAppDetailView$5$1$1 */
            public class RunnableC144671 implements Runnable {

                /* renamed from: a */
                final /* synthetic */ Drawable f34337a;

                public RunnableC144671(Drawable drawable) {
                    drawable = drawable;
                }

                @Override // java.lang.Runnable
                public void run() {
                    RunnableC73945.this.f34334b.setBackground(null);
                    RunnableC73945.this.f34334b.setImageDrawable(drawable);
                }
            }

            public AnonymousClass1() {
            }

            @Override // com.huawei.openalliance.p169ad.utils.C7752az.a
            /* renamed from: a */
            public void mo30231a() {
            }

            @Override // com.huawei.openalliance.p169ad.utils.C7752az.a
            /* renamed from: a */
            public void mo30232a(Drawable drawable) {
                if (drawable != null) {
                    AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.linked.view.LinkedAppDetailView.5.1.1

                        /* renamed from: a */
                        final /* synthetic */ Drawable f34337a;

                        public RunnableC144671(Drawable drawable2) {
                            drawable = drawable2;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            RunnableC73945.this.f34334b.setBackground(null);
                            RunnableC73945.this.f34334b.setImageDrawable(drawable);
                        }
                    });
                }
            }
        }

        public RunnableC73945(String str, ImageView imageView) {
            this.f34333a = str;
            this.f34334b = imageView;
        }

        @Override // java.lang.Runnable
        public void run() {
            C7653sb c7653sb = new C7653sb();
            c7653sb.m47181b(false);
            c7653sb.m47185c(true);
            c7653sb.m47180b("icon");
            c7653sb.m47187d(this.f34333a);
            if (!LinkedAppDetailView.this.f34322l) {
                c7653sb.m47183c(C7124fh.m43316b(LinkedAppDetailView.this.f34311a).mo43019e());
            }
            C7654sc c7654scM47158a = new C7650rz(LinkedAppDetailView.this.f34311a, c7653sb).m47158a();
            if (c7654scM47158a != null) {
                String strM47207a = c7654scM47158a.m47207a();
                if (TextUtils.isEmpty(strM47207a)) {
                    return;
                }
                String strM41968c = LinkedAppDetailView.this.f34327q.m41968c(strM47207a);
                if (TextUtils.isEmpty(strM41968c)) {
                    return;
                }
                C7752az.m47690a(LinkedAppDetailView.this.f34311a, strM41968c, new C7752az.a() { // from class: com.huawei.openalliance.ad.linked.view.LinkedAppDetailView.5.1

                    /* renamed from: com.huawei.openalliance.ad.linked.view.LinkedAppDetailView$5$1$1 */
                    public class RunnableC144671 implements Runnable {

                        /* renamed from: a */
                        final /* synthetic */ Drawable f34337a;

                        public RunnableC144671(Drawable drawable2) {
                            drawable = drawable2;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            RunnableC73945.this.f34334b.setBackground(null);
                            RunnableC73945.this.f34334b.setImageDrawable(drawable);
                        }
                    }

                    public AnonymousClass1() {
                    }

                    @Override // com.huawei.openalliance.p169ad.utils.C7752az.a
                    /* renamed from: a */
                    public void mo30231a() {
                    }

                    @Override // com.huawei.openalliance.p169ad.utils.C7752az.a
                    /* renamed from: a */
                    public void mo30232a(Drawable drawable2) {
                        if (drawable2 != null) {
                            AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.linked.view.LinkedAppDetailView.5.1.1

                                /* renamed from: a */
                                final /* synthetic */ Drawable f34337a;

                                public RunnableC144671(Drawable drawable22) {
                                    drawable = drawable22;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    RunnableC73945.this.f34334b.setBackground(null);
                                    RunnableC73945.this.f34334b.setImageDrawable(drawable);
                                }
                            });
                        }
                    }
                });
            }
        }
    }

    public LinkedAppDetailView(Context context) {
        super(context);
        this.f34322l = true;
        this.f34325o = false;
        m45487a(context);
    }

    /* renamed from: b */
    private void m45491b() {
        this.f34312b.setSource(11);
        this.f34312b.setLinkedCoverClickListener(this.f34326p);
        if (this.f34322l) {
            this.f34312b.setClickActionListener(new InterfaceC8131x() { // from class: com.huawei.openalliance.ad.linked.view.LinkedAppDetailView.1
                public C73901() {
                }

                @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8131x
                /* renamed from: a */
                public void mo30555a(AppDownloadButton appDownloadButton) {
                    if (LinkedAppDetailView.this.f34323m != null) {
                        LinkedAppDetailView.this.f34323m.mo38703a(new C8109b(LinkedAppDetailView.this.f34322l, false, AppStatus.INSTALLED == appDownloadButton.getStatus() ? "app" : ""));
                    }
                }

                @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8131x
                /* renamed from: b */
                public void mo30556b(AppDownloadButton appDownloadButton) {
                    if (LinkedAppDetailView.this.f34323m != null) {
                        String str = AppStatus.INSTALLED == appDownloadButton.getStatus() ? "app" : "";
                        LinkedAppDetailView.this.f34320j.m39197a(0, 0, LinkedAppDetailView.this.f34317g);
                        LinkedAppDetailView.this.f34323m.mo38703a(new C8109b(LinkedAppDetailView.this.f34322l, true, str));
                    }
                }
            });
        }
    }

    public void setCancelDownloadButtonVisibility(AppStatus appStatus) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            int iM47282a = C7694tp.m47282a(motionEvent);
            if (iM47282a == 0) {
                AbstractC7185ho.m43817a("LinkedPPSAppDetailView", "dispatchTouchEvent ACTION_DOWN");
                this.f34328r = C7694tp.m47283a(this, motionEvent);
            }
            if (1 == iM47282a) {
                AbstractC7185ho.m43817a("LinkedPPSAppDetailView", "dispatchTouchEvent ACTION_UP");
                C7694tp.m47284a(this, motionEvent, null, this.f34328r);
                this.f34312b.m48702a(this.f34328r);
            }
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("LinkedPPSAppDetailView", "dispatchTouchEvent exception : %s", th2.getClass().getSimpleName());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public AppDownloadButton getAppDownloadButton() {
        return this.f34312b;
    }

    public void setAdLandingPageData(AdLandingPageData adLandingPageData) {
        this.f34318h = adLandingPageData;
    }

    public void setAppDetailClickListener(InterfaceC8110c interfaceC8110c) {
        this.f34323m = interfaceC8110c;
    }

    public void setAppRelated(boolean z10) {
        this.f34322l = z10;
        m45500a();
    }

    public void setContentRecord(ContentRecord contentRecord) {
        String str;
        if (contentRecord == null) {
            return;
        }
        try {
            AbstractC7185ho.m43820b("LinkedPPSAppDetailView", "set ad landing data");
            this.f34317g = contentRecord;
            AppInfo appInfoM41484af = contentRecord.m41484af();
            this.f34315e = appInfoM41484af;
            if (appInfoM41484af == null) {
                AbstractC7185ho.m43817a("LinkedPPSAppDetailView", "appInfo is null, hide appDetailView");
                this.f34319i.setVisibility(8);
            } else {
                m45494c();
            }
        } catch (RuntimeException unused) {
            str = "setAdLandingPageData RuntimeException";
            AbstractC7185ho.m43823c("LinkedPPSAppDetailView", str);
        } catch (Exception unused2) {
            str = "setAdLandingPageData error";
            AbstractC7185ho.m43823c("LinkedPPSAppDetailView", str);
        }
    }

    public void setNeedPerBeforDownload(boolean z10) {
        this.f34325o = z10;
    }

    public void setOnNonWifiDownloadListener(INonwifiActionListener iNonwifiActionListener) {
        this.f34324n = iNonwifiActionListener;
    }

    public void setVideoCoverClickListener(View.OnClickListener onClickListener) {
        this.f34326p = onClickListener;
    }

    public LinkedAppDetailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f34322l = true;
        this.f34325o = false;
        m45487a(context);
    }

    /* renamed from: c */
    private void m45494c() {
        AppDownloadButton appDownloadButton;
        AppDownloadButtonStyle extandAppDownloadButtonStyle;
        m45489a(this.f34313c, this.f34315e.getAppName());
        m45488a(this.f34314d, this.f34315e.getIconUrl());
        this.f34312b.setAdLandingPageData(this.f34318h);
        m45491b();
        this.f34312b.setNeedShowPermision(this.f34325o);
        if (C6982bz.m41148a(this.f34311a).mo41178g()) {
            appDownloadButton = this.f34312b;
            extandAppDownloadButtonStyle = new ExtandAppDownloadButtonStyleHm(this.f34311a);
        } else {
            appDownloadButton = this.f34312b;
            extandAppDownloadButtonStyle = new ExtandAppDownloadButtonStyle(this.f34311a);
        }
        appDownloadButton.setAppDownloadButtonStyle(extandAppDownloadButtonStyle);
        this.f34312b.setOnDownloadStatusChangedListener(new AppDownloadButton.OnDownloadStatusChangedListener() { // from class: com.huawei.openalliance.ad.linked.view.LinkedAppDetailView.2
            public C73912() {
            }

            @Override // com.huawei.openalliance.ad.views.AppDownloadButton.OnDownloadStatusChangedListener
            public void onStatusChanged(AppStatus appStatus) {
                LinkedAppDetailView.this.setCancelDownloadButtonVisibility(appStatus);
            }

            @Override // com.huawei.openalliance.ad.views.AppDownloadButton.OnDownloadStatusChangedListener
            public void onUserCancel(AppInfo appInfo) {
            }
        });
        this.f34312b.setButtonTextWatcherInner(new AppDownloadButton.InterfaceC7878e() { // from class: com.huawei.openalliance.ad.linked.view.LinkedAppDetailView.3
            public C73923() {
            }

            @Override // com.huawei.openalliance.p169ad.views.AppDownloadButton.InterfaceC7878e
            /* renamed from: a */
            public CharSequence mo30554a(CharSequence charSequence, AppStatus appStatus) {
                return !LinkedAppDetailView.this.f34322l ? LinkedAppDetailView.this.f34311a.getString(C6849R.string.hiad_download_open) : charSequence;
            }
        });
        this.f34312b.setOnNonWifiDownloadListener(new AppDownloadButton.OnNonWifiDownloadListener() { // from class: com.huawei.openalliance.ad.linked.view.LinkedAppDetailView.4
            public C73934() {
            }

            @Override // com.huawei.openalliance.ad.views.AppDownloadButton.OnNonWifiDownloadListener
            public boolean onNonWifiDownload(AppInfo appInfo, long j10) {
                if (LinkedAppDetailView.this.f34324n == null || !LinkedAppDetailView.this.f34324n.onAppDownload(appInfo, j10)) {
                    LinkedAppDetailView.this.f34312b.m48705b();
                    return false;
                }
                LinkedAppDetailView.this.f34312b.setAllowedNonWifiNetwork(true);
                return true;
            }
        });
        this.f34312b.setSource(11);
        setCancelDownloadButtonVisibility(this.f34312b.refreshStatus());
    }

    /* renamed from: a */
    public void m45500a() {
        AppDownloadButton appDownloadButton = this.f34312b;
        if (appDownloadButton != null) {
            appDownloadButton.setClickable(false);
        }
    }

    public LinkedAppDetailView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f34322l = true;
        this.f34325o = false;
        m45487a(context);
    }

    /* renamed from: a */
    private void m45487a(Context context) {
        String str;
        try {
            this.f34311a = context;
            this.f34316f = C7124fh.m43316b(context);
            this.f34320j = new C6928i(context);
            this.f34321k = ViewConfiguration.get(context).getScaledTouchSlop();
            this.f34319i = View.inflate(context, C6849R.layout.hiad_linked_app_detail, this);
            this.f34313c = (TextView) findViewById(C6849R.id.linked_app_name);
            this.f34314d = (ImageView) findViewById(C6849R.id.linked_app_icon);
            this.f34312b = (AppDownloadButton) findViewById(C6849R.id.linked_app_download_btn);
            this.f34327q = C7019dh.m41937a(context, Constants.NORMAL_CACHE);
            if (AbstractC7741ao.m47592n(context)) {
                this.f34313c.setTextSize(1, 24.0f);
            }
        } catch (RuntimeException unused) {
            str = "init RuntimeException";
            AbstractC7185ho.m43823c("LinkedPPSAppDetailView", str);
        } catch (Exception unused2) {
            str = "init error";
            AbstractC7185ho.m43823c("LinkedPPSAppDetailView", str);
        }
    }

    /* renamed from: a */
    private void m45488a(ImageView imageView, String str) {
        if (TextUtils.isEmpty(str) || imageView == null) {
            return;
        }
        AbstractC7185ho.m43820b("LinkedPPSAppDetailView", "load app icon:" + AbstractC7806cz.m48174f(str));
        AbstractC7834m.m48484d(new RunnableC73945(str, imageView));
    }

    /* renamed from: a */
    private void m45489a(TextView textView, String str) {
        int i10;
        if (TextUtils.isEmpty(str)) {
            i10 = 8;
        } else {
            textView.setText(str);
            i10 = 0;
        }
        textView.setVisibility(i10);
    }

    /* renamed from: a */
    public void m45501a(String str) {
        ContentRecord contentRecord = this.f34317g;
        if (contentRecord != null) {
            contentRecord.m41536c(str);
        }
        AppDownloadButton appDownloadButton = this.f34312b;
        if (appDownloadButton != null) {
            appDownloadButton.updateContent(str);
        }
    }
}
