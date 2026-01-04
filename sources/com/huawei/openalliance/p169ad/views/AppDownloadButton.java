package com.huawei.openalliance.p169ad.views;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import com.huawei.hms.ads.inner.C5077a;
import com.huawei.hms.ads.uiengine.common.IProgressButton;
import com.huawei.openalliance.p169ad.AbstractC7026do;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.AbstractC7558os;
import com.huawei.openalliance.p169ad.AbstractC7687ti;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.C7072dp;
import com.huawei.openalliance.p169ad.C7073dq;
import com.huawei.openalliance.p169ad.C7490my;
import com.huawei.openalliance.p169ad.C7560ou;
import com.huawei.openalliance.p169ad.C7562ow;
import com.huawei.openalliance.p169ad.C7570pd;
import com.huawei.openalliance.p169ad.C7575pi;
import com.huawei.openalliance.p169ad.C7662sk;
import com.huawei.openalliance.p169ad.C7673sv;
import com.huawei.openalliance.p169ad.C7675sx;
import com.huawei.openalliance.p169ad.C7677sz;
import com.huawei.openalliance.p169ad.C7679ta;
import com.huawei.openalliance.p169ad.C7681tc;
import com.huawei.openalliance.p169ad.C7683te;
import com.huawei.openalliance.p169ad.C7686th;
import com.huawei.openalliance.p169ad.C7692tn;
import com.huawei.openalliance.p169ad.InterfaceC7342jp;
import com.huawei.openalliance.p169ad.activity.LandingDetailsActivity;
import com.huawei.openalliance.p169ad.activity.PPSActivity;
import com.huawei.openalliance.p169ad.activity.PPSInstallAuthorActivity;
import com.huawei.openalliance.p169ad.activity.PPSInterstitialAdActivity;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.beans.metadata.MetaData;
import com.huawei.openalliance.p169ad.beans.metadata.TextState;
import com.huawei.openalliance.p169ad.constant.ClickDestination;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.EventType;
import com.huawei.openalliance.p169ad.constant.PriorInstallWay;
import com.huawei.openalliance.p169ad.download.DownloadTask;
import com.huawei.openalliance.p169ad.download.EnumC7062e;
import com.huawei.openalliance.p169ad.download.InterfaceC7069l;
import com.huawei.openalliance.p169ad.download.app.AppDownloadTask;
import com.huawei.openalliance.p169ad.download.app.AppStatus;
import com.huawei.openalliance.p169ad.download.app.AppStatusV1;
import com.huawei.openalliance.p169ad.download.app.C7046e;
import com.huawei.openalliance.p169ad.download.app.C7049h;
import com.huawei.openalliance.p169ad.download.app.C7050i;
import com.huawei.openalliance.p169ad.download.app.C7055l;
import com.huawei.openalliance.p169ad.download.p172ag.C7037e;
import com.huawei.openalliance.p169ad.inter.data.AdLandingPageData;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.inter.data.C7302e;
import com.huawei.openalliance.p169ad.inter.data.C7304g;
import com.huawei.openalliance.p169ad.inter.data.INativeAd;
import com.huawei.openalliance.p169ad.inter.data.IPlacementAd;
import com.huawei.openalliance.p169ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.p169ad.inter.listeners.AppDownloadListenerV1;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.processor.eventbeans.C7587b;
import com.huawei.openalliance.p169ad.utils.AbstractC7731ae;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7807d;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import com.huawei.openalliance.p169ad.utils.C7739am;
import com.huawei.openalliance.p169ad.utils.C7753b;
import com.huawei.openalliance.p169ad.utils.C7755bb;
import com.huawei.openalliance.p169ad.utils.C7775bv;
import com.huawei.openalliance.p169ad.utils.C7830i;
import com.huawei.openalliance.p169ad.utils.C7831j;
import com.huawei.openalliance.p169ad.views.AppDownloadButtonStyle;
import com.huawei.openalliance.p169ad.views.interfaces.IAppDownloadButton;
import com.huawei.openalliance.p169ad.views.interfaces.IPPSLinkedView;
import com.huawei.openalliance.p169ad.views.interfaces.IPPSNativeView;
import com.huawei.openalliance.p169ad.views.interfaces.IPPSPlacementView;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8114g;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8131x;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import p208cq.InterfaceC8939g;

@OuterVisible
/* loaded from: classes2.dex */
public class AppDownloadButton extends AbstractViewOnClickListenerC8065a implements InterfaceC7069l, IAppDownloadButton {

    /* renamed from: A */
    private C7877d f36249A;

    /* renamed from: B */
    private boolean f36250B;

    /* renamed from: C */
    private boolean f36251C;

    /* renamed from: D */
    private boolean f36252D;

    /* renamed from: E */
    private String f36253E;

    /* renamed from: F */
    private boolean f36254F;

    /* renamed from: G */
    private int f36255G;

    /* renamed from: H */
    private C7879f f36256H;

    /* renamed from: I */
    private AppDownloadListenerV1 f36257I;

    /* renamed from: J */
    private MaterialClickInfo f36258J;

    /* renamed from: K */
    private boolean f36259K;

    /* renamed from: L */
    private InterfaceC7875b f36260L;

    /* renamed from: M */
    private boolean f36261M;

    /* renamed from: N */
    private Boolean f36262N;

    /* renamed from: O */
    private C7560ou f36263O;

    /* renamed from: P */
    private InterfaceC7342jp f36264P;

    /* renamed from: d */
    private C7302e f36265d;

    /* renamed from: e */
    private AppInfo f36266e;

    /* renamed from: f */
    private boolean f36267f;

    /* renamed from: g */
    private OnDownloadStatusChangedListener f36268g;

    /* renamed from: h */
    private OnNonWifiDownloadListener f36269h;

    /* renamed from: i */
    private InterfaceC7878e f36270i;

    /* renamed from: j */
    private AppStatus f36271j;

    /* renamed from: k */
    private AppStatus f36272k;

    /* renamed from: l */
    private int f36273l;

    /* renamed from: m */
    private ContentRecord f36274m;

    /* renamed from: n */
    private boolean f36275n;

    /* renamed from: o */
    private int f36276o;

    /* renamed from: p */
    private Integer f36277p;

    /* renamed from: q */
    private boolean f36278q;

    /* renamed from: r */
    private int f36279r;

    /* renamed from: s */
    private List<TextState> f36280s;

    /* renamed from: t */
    private IPPSNativeView f36281t;

    /* renamed from: u */
    private IPPSLinkedView f36282u;

    /* renamed from: v */
    private IPPSPlacementView f36283v;

    /* renamed from: w */
    private PPSAppDetailView f36284w;

    /* renamed from: x */
    private boolean f36285x;

    /* renamed from: y */
    private InterfaceC8131x f36286y;

    /* renamed from: z */
    private View.OnClickListener f36287z;

    /* renamed from: com.huawei.openalliance.ad.views.AppDownloadButton$1 */
    public class RunnableC78641 implements Runnable {
        public RunnableC78641() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AppDownloadButton.this.f36271j = AppStatus.DOWNLOAD;
            AppDownloadButton.this.m48668b(false);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.AppDownloadButton$10 */
    public class RunnableC786510 implements Runnable {
        public RunnableC786510() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AppDownloadButton.this.refreshStatus();
            if (AppDownloadButton.this.f36268g != null) {
                AppDownloadButton.this.f36268g.onStatusChanged(AppDownloadButton.this.f36271j);
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.AppDownloadButton$2 */
    public static /* synthetic */ class C78662 {

        /* renamed from: a */
        static final /* synthetic */ int[] f36290a;

        /* renamed from: b */
        static final /* synthetic */ int[] f36291b;

        static {
            int[] iArr = new int[AppStatus.values().length];
            f36291b = iArr;
            try {
                iArr[AppStatus.DOWNLOAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f36291b[AppStatus.WAITING_FOR_WIFI.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f36291b[AppStatus.PAUSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f36291b[AppStatus.DOWNLOADING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f36291b[AppStatus.INSTALLED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f36291b[AppStatus.INSTALL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f36291b[AppStatus.INSTALLING.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr2 = new int[EnumC7062e.values().length];
            f36290a = iArr2;
            try {
                iArr2[EnumC7062e.FAILED.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f36290a[EnumC7062e.WAITING_FOR_WIFI.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f36290a[EnumC7062e.WAITING.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f36290a[EnumC7062e.DOWNLOADING.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f36290a[EnumC7062e.DOWNLOADED.ordinal()] = 5;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f36290a[EnumC7062e.INSTALLING.ordinal()] = 6;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f36290a[EnumC7062e.INSTALLED.ordinal()] = 7;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f36290a[EnumC7062e.IDLE.ordinal()] = 8;
            } catch (NoSuchFieldError unused15) {
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.AppDownloadButton$3 */
    public class RunnableC78673 implements Runnable {
        public RunnableC78673() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AppDownloadButton.this.m48700z();
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.AppDownloadButton$4 */
    public class C78684 implements InterfaceC8114g {
        public C78684() {
        }

        @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8114g
        /* renamed from: a */
        public void mo42335a(AppDownloadTask appDownloadTask) {
            if (appDownloadTask != null) {
                AppDownloadButton.this.m48676f(appDownloadTask);
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.AppDownloadButton$5 */
    public class C78695 implements C7049h.a {
        public C78695() {
        }

        @Override // com.huawei.openalliance.p169ad.download.app.C7049h.a
        /* renamed from: a */
        public void mo42425a() {
            AppDownloadButton.this.setNeedShowConfirmDialog(false);
            AppDownloadButton.this.m48640D();
        }

        @Override // com.huawei.openalliance.p169ad.download.app.C7049h.a
        /* renamed from: a */
        public void mo42426a(int i10) {
            if (AppDownloadButton.this.f36257I != null) {
                AppDownloadButton.this.f36257I.onNewStatusChanged(AppStatusV1.PRE_CHECK_FAILED, i10, AppDownloadButton.this.f36266e);
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.AppDownloadButton$6 */
    public class C78706 implements AbstractC7026do.a {
        public C78706() {
        }

        @Override // com.huawei.openalliance.p169ad.AbstractC7026do.a
        /* renamed from: a */
        public void mo42028a(AppInfo appInfo) {
            AppDownloadButton.this.setAllowedNonWifiNetwork(true);
            AppDownloadButton.this.setNeedShowConfirmDialog(false);
            AppDownloadButton.this.m48706c();
        }

        @Override // com.huawei.openalliance.p169ad.AbstractC7026do.a
        /* renamed from: b */
        public void mo42029b(AppInfo appInfo) {
            if (AppDownloadButton.this.f36257I != null) {
                AppDownloadButton.this.f36257I.onNewStatusChanged(AppStatusV1.PRE_CHECK_FAILED, 1003, appInfo);
            }
        }

        @Override // com.huawei.openalliance.p169ad.AbstractC7026do.a
        /* renamed from: c */
        public void mo42030c(AppInfo appInfo) {
            AppDownloadButton.this.m48641E();
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.AppDownloadButton$7 */
    public class C78717 implements AbstractC7026do.a {
        public C78717() {
        }

        @Override // com.huawei.openalliance.p169ad.AbstractC7026do.a
        /* renamed from: a */
        public void mo42028a(AppInfo appInfo) {
            AppDownloadButton.this.setNeedShowConfirmDialog(false);
            AppDownloadButton.this.m48709e();
        }

        @Override // com.huawei.openalliance.p169ad.AbstractC7026do.a
        /* renamed from: b */
        public void mo42029b(AppInfo appInfo) {
            if (AppDownloadButton.this.f36257I != null) {
                AppDownloadButton.this.f36257I.onNewStatusChanged(AppStatusV1.PRE_CHECK_FAILED, 1002, appInfo);
            }
        }

        @Override // com.huawei.openalliance.p169ad.AbstractC7026do.a
        /* renamed from: c */
        public void mo42030c(AppInfo appInfo) {
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.AppDownloadButton$8 */
    public class RunnableC78728 implements Runnable {
        public RunnableC78728() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AppDownloadButton.this.refreshStatus();
            if (AppDownloadButton.this.f36268g == null || AppDownloadButton.this.f36272k == AppDownloadButton.this.getStatus()) {
                return;
            }
            AppDownloadButton.this.f36268g.onStatusChanged(AppDownloadButton.this.getStatus());
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.AppDownloadButton$9 */
    public class RunnableC78739 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f36298a;

        public RunnableC78739(int i10) {
            i = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            AppDownloadButton.this.f36255G = i;
            AppDownloadButton.this.refreshStatus();
        }
    }

    @OuterVisible
    public interface ButtonTextWatcher {
        CharSequence beforeTextChanged(CharSequence charSequence, AppStatus appStatus);
    }

    @OuterVisible
    public interface OnDownloadStatusChangedListener {
        void onStatusChanged(AppStatus appStatus);

        void onUserCancel(AppInfo appInfo);
    }

    @OuterVisible
    public interface OnNonWifiDownloadListener {
        boolean onNonWifiDownload(AppInfo appInfo, long j10);
    }

    @OuterVisible
    public interface OnResolutionRequiredListener {
        void onResolutionRequired(AppInfo appInfo, Bundle bundle);
    }

    @OuterVisible
    public interface OnStatusRefreshedListener {
        void onRefreshed(AppStatus appStatus);
    }

    /* renamed from: com.huawei.openalliance.ad.views.AppDownloadButton$a */
    public static class C7874a implements C7562ow.a {

        /* renamed from: a */
        WeakReference<AppDownloadButton> f36300a;

        /* renamed from: b */
        AppDownloadTask f36301b;

        /* renamed from: c */
        AppDownloadListenerV1 f36302c;

        /* renamed from: com.huawei.openalliance.ad.views.AppDownloadButton$a$1 */
        public class AnonymousClass1 implements Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C7874a.this.m48712c();
            }
        }

        public C7874a(AppDownloadButton appDownloadButton, AppDownloadTask appDownloadTask, AppDownloadListenerV1 appDownloadListenerV1) {
            this.f36300a = new WeakReference<>(appDownloadButton);
            this.f36301b = appDownloadTask;
            this.f36302c = appDownloadListenerV1;
        }

        /* renamed from: c */
        public void m48712c() {
            AppDownloadButton appDownloadButton = this.f36300a.get();
            if (appDownloadButton != null) {
                appDownloadButton.refreshStatus();
            }
        }

        /* renamed from: d */
        private void m48713d() {
            AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.AppDownloadButton.a.1
                public AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    C7874a.this.m48712c();
                }
            });
        }

        @Override // com.huawei.openalliance.p169ad.C7562ow.a
        /* renamed from: a */
        public void mo42336a() {
            AbstractC7185ho.m43820b("AppInsResCallback", "onSilentInstallStart");
            this.f36301b.m42054a(EnumC7062e.INSTALLING);
            m48713d();
        }

        @Override // com.huawei.openalliance.p169ad.C7562ow.a
        /* renamed from: b */
        public void mo42338b() {
            AbstractC7185ho.m43820b("AppInsResCallback", "onSystemInstallStart");
            this.f36301b.m42054a(EnumC7062e.DOWNLOADED);
            m48713d();
        }

        @Override // com.huawei.openalliance.p169ad.C7562ow.a
        /* renamed from: a */
        public void mo42337a(int i10) {
            AbstractC7185ho.m43823c("AppInsResCallback", "install app failed.");
            this.f36301b.m42054a(EnumC7062e.DOWNLOADED);
            m48713d();
            AppDownloadListenerV1 appDownloadListenerV1 = this.f36302c;
            if (appDownloadListenerV1 != null) {
                appDownloadListenerV1.onNewStatusChanged(AppStatusV1.INSTALL_FAILED, 1002, this.f36301b.m42222B());
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.AppDownloadButton$b */
    public interface InterfaceC7875b {
        /* renamed from: a */
        void mo30557a();
    }

    /* renamed from: com.huawei.openalliance.ad.views.AppDownloadButton$c */
    public static class ViewOnClickListenerC7876c implements View.OnClickListener {

        /* renamed from: a */
        private WeakReference<AppDownloadButton> f36304a;

        public ViewOnClickListenerC7876c(AppDownloadButton appDownloadButton) {
            this.f36304a = new WeakReference<>(appDownloadButton);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AppDownloadButton appDownloadButton = this.f36304a.get();
            if (appDownloadButton == null) {
                return;
            }
            AbstractC7185ho.m43820b(((AbstractViewOnClickListenerC8065a) appDownloadButton).f37452a, "on cancel btn click.");
            appDownloadButton.m48701a();
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.AppDownloadButton$d */
    public static class C7877d implements InterfaceC7069l {

        /* renamed from: a */
        WeakReference<InterfaceC7069l> f36305a;

        public C7877d(InterfaceC7069l interfaceC7069l) {
            this.f36305a = new WeakReference<>(interfaceC7069l);
        }

        @Override // com.huawei.openalliance.p169ad.download.InterfaceC7069l
        /* renamed from: a */
        public void mo42626a(AppDownloadTask appDownloadTask) {
            InterfaceC7069l interfaceC7069l = this.f36305a.get();
            if (interfaceC7069l != null) {
                interfaceC7069l.mo42626a(appDownloadTask);
            }
        }

        @Override // com.huawei.openalliance.p169ad.download.InterfaceC7069l
        /* renamed from: b */
        public void mo42628b(AppDownloadTask appDownloadTask) {
            InterfaceC7069l interfaceC7069l = this.f36305a.get();
            if (interfaceC7069l != null) {
                interfaceC7069l.mo42628b(appDownloadTask);
            }
        }

        @Override // com.huawei.openalliance.p169ad.download.InterfaceC7069l
        /* renamed from: c */
        public void mo42630c(String str) {
            InterfaceC7069l interfaceC7069l = this.f36305a.get();
            if (interfaceC7069l != null) {
                interfaceC7069l.mo42630c(str);
            }
        }

        @Override // com.huawei.openalliance.p169ad.download.InterfaceC7069l
        /* renamed from: a */
        public void mo42627a(String str) {
            InterfaceC7069l interfaceC7069l = this.f36305a.get();
            if (interfaceC7069l != null) {
                interfaceC7069l.mo42627a(str);
            }
        }

        @Override // com.huawei.openalliance.p169ad.download.InterfaceC7069l
        /* renamed from: b */
        public void mo42629b(String str) {
            InterfaceC7069l interfaceC7069l = this.f36305a.get();
            if (interfaceC7069l != null) {
                interfaceC7069l.mo42629b(str);
            }
        }

        @Override // com.huawei.openalliance.p169ad.download.InterfaceC7068k
        /* renamed from: a */
        public void mo38799a(String str, int i10) {
            InterfaceC7069l interfaceC7069l = this.f36305a.get();
            if (interfaceC7069l != null) {
                interfaceC7069l.mo38799a(str, i10);
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.AppDownloadButton$e */
    public interface InterfaceC7878e {
        /* renamed from: a */
        CharSequence mo30554a(CharSequence charSequence, AppStatus appStatus);
    }

    /* renamed from: com.huawei.openalliance.ad.views.AppDownloadButton$f */
    public static class C7879f implements OnResolutionRequiredListener {

        /* renamed from: a */
        OnResolutionRequiredListener f36306a;

        public C7879f(OnResolutionRequiredListener onResolutionRequiredListener) {
            this.f36306a = onResolutionRequiredListener;
        }

        @Override // com.huawei.openalliance.ad.views.AppDownloadButton.OnResolutionRequiredListener
        public void onResolutionRequired(AppInfo appInfo, Bundle bundle) {
            AbstractC7185ho.m43820b("ResReqListener", "onResolutionRequired");
            OnResolutionRequiredListener onResolutionRequiredListener = this.f36306a;
            if (onResolutionRequiredListener != null) {
                onResolutionRequiredListener.onResolutionRequired(appInfo, bundle);
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.AppDownloadButton$g */
    public static class RunnableC7880g implements Runnable {

        /* renamed from: a */
        private final OnStatusRefreshedListener f36307a;

        /* renamed from: b */
        private WeakReference<AppDownloadButton> f36308b;

        /* renamed from: com.huawei.openalliance.ad.views.AppDownloadButton$g$1 */
        public class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ AppDownloadButton f36309a;

            /* renamed from: b */
            final /* synthetic */ AppDownloadTask f36310b;

            public AnonymousClass1(AppDownloadButton appDownloadButton, AppDownloadTask appDownloadTask) {
                appDownloadButton = appDownloadButton;
                appDownloadTask = appDownloadTask;
            }

            @Override // java.lang.Runnable
            public void run() {
                appDownloadButton.m48669c(appDownloadTask);
                if (RunnableC7880g.this.f36307a != null) {
                    RunnableC7880g.this.f36307a.onRefreshed(appDownloadButton.f36271j);
                }
            }
        }

        public RunnableC7880g(AppDownloadButton appDownloadButton, OnStatusRefreshedListener onStatusRefreshedListener) {
            this.f36307a = onStatusRefreshedListener;
            this.f36308b = new WeakReference<>(appDownloadButton);
        }

        @Override // java.lang.Runnable
        public void run() {
            AppDownloadButton appDownloadButton = this.f36308b.get();
            if (appDownloadButton != null) {
                AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.AppDownloadButton.g.1

                    /* renamed from: a */
                    final /* synthetic */ AppDownloadButton f36309a;

                    /* renamed from: b */
                    final /* synthetic */ AppDownloadTask f36310b;

                    public AnonymousClass1(AppDownloadButton appDownloadButton2, AppDownloadTask appDownloadTask) {
                        appDownloadButton = appDownloadButton2;
                        appDownloadTask = appDownloadTask;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        appDownloadButton.m48669c(appDownloadTask);
                        if (RunnableC7880g.this.f36307a != null) {
                            RunnableC7880g.this.f36307a.onRefreshed(appDownloadButton.f36271j);
                        }
                    }
                });
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.AppDownloadButton$h */
    public static class C7881h implements InterfaceC8939g<Boolean> {

        /* renamed from: a */
        private final WeakReference<AppDownloadButton> f36312a;

        public C7881h(AppDownloadButton appDownloadButton) {
            this.f36312a = new WeakReference<>(appDownloadButton);
        }

        @Override // p208cq.InterfaceC8939g
        /* renamed from: a */
        public void onSuccess(Boolean bool) {
            AbstractC7185ho.m43821b("AppDownloadButton", "onSuccess ret: %s.", bool);
            AppDownloadButton appDownloadButton = this.f36312a.get();
            if (appDownloadButton == null) {
                AbstractC7185ho.m43823c("AppDownloadButton", "button is null");
            } else {
                AbstractC7185ho.m43820b("AppDownloadButton", "button doClick");
                appDownloadButton.m48689o();
            }
        }
    }

    @OuterVisible
    public AppDownloadButton(Context context) {
        super(context);
        this.f36271j = AppStatus.DOWNLOAD;
        this.f36273l = -1;
        this.f36275n = true;
        this.f36276o = 1;
        this.f36278q = false;
        this.f36279r = 2;
        this.f36285x = true;
        this.f36251C = true;
        this.f36252D = false;
        this.f36254F = false;
        this.f36255G = -1;
        this.f36259K = false;
        m48653a(context, (AttributeSet) null, -1, -1);
    }

    /* renamed from: A */
    private boolean m48637A() {
        if (this.f36276o == 1 || (getContext() instanceof LandingDetailsActivity) || this.f36274m.m41552f() == 7) {
            return true;
        }
        return this.f36274m.m41552f() == 12 && (getContext() instanceof PPSInterstitialAdActivity);
    }

    /* renamed from: B */
    private void m48638B() {
        IPPSNativeView iPPSNativeView = this.f36281t;
        if (iPPSNativeView != null) {
            iPPSNativeView.mo49347a(2);
        }
        IPPSLinkedView iPPSLinkedView = this.f36282u;
        if (iPPSLinkedView != null) {
            iPPSLinkedView.mo49291a(2);
        }
        PPSAppDetailView pPSAppDetailView = this.f36284w;
        if (pPSAppDetailView != null) {
            pPSAppDetailView.m48961a((Integer) 2);
        }
        IPPSPlacementView iPPSPlacementView = this.f36283v;
        if (iPPSPlacementView != null) {
            iPPSPlacementView.mo49458a(2);
        }
        if (getContext() instanceof LandingDetailsActivity) {
            new C7490my(getContext(), this.f36274m, this.f36258J).m45892a();
        }
    }

    /* renamed from: C */
    private void m48639C() {
        IPPSNativeView iPPSNativeView = this.f36281t;
        if (iPPSNativeView != null) {
            iPPSNativeView.mo49353f();
        }
    }

    /* renamed from: D */
    public void m48640D() {
        if (!C7775bv.m47831e(getContext())) {
            Toast.makeText(getContext(), C6849R.string.hiad_network_no_available, 0).show();
            return;
        }
        if (!C7775bv.m47829c(getContext())) {
            long leftSize = getLeftSize();
            OnNonWifiDownloadListener onNonWifiDownloadListener = this.f36269h;
            if (onNonWifiDownloadListener == null) {
                m48705b();
                return;
            } else if (!onNonWifiDownloadListener.onNonWifiDownload(this.f36266e, leftSize)) {
                return;
            }
        }
        m48706c();
    }

    /* renamed from: E */
    public void m48641E() {
        AbstractC7185ho.m43820b(((AbstractViewOnClickListenerC8065a) this).f37452a, "preWifiDownload");
        if (this.f36266e != null) {
            AppDownloadTask task = getTask();
            if (task == null) {
                task = m48642F();
                C7046e.m42377h().m42560b((C7046e) task);
            }
            if (task != null) {
                task.m42051a(DownloadTask.EnumC7029a.WAITING_WIFI_DOWNLOAD);
            }
            if (getStatus() == AppStatus.DOWNLOAD || getStatus() == AppStatus.WAITING_FOR_WIFI || getStatus() == AppStatus.PAUSE) {
                C7046e.m42377h().m42567e((C7046e) task);
            }
        }
    }

    /* renamed from: F */
    private AppDownloadTask m48642F() {
        C7560ou c7560ou;
        if (this.f36274m != null) {
            c7560ou = new C7560ou(getContext(), C7662sk.m47225a(getContext(), this.f36274m.m41552f()));
            c7560ou.mo46590a(this.f36274m);
        } else {
            c7560ou = null;
        }
        AppDownloadTask appDownloadTaskM42269a = new AppDownloadTask.C7040a().m42268a(this.f36267f).m42265a(this.f36266e).m42266a(c7560ou).m42267a(C7046e.m42377h().m42407e(this.f36266e)).m42270b(C7046e.m42377h().m42408f(this.f36266e)).m42269a();
        if (appDownloadTaskM42269a != null) {
            appDownloadTaskM42269a.m42245a(Integer.valueOf(this.f36276o));
            appDownloadTaskM42269a.m42253f(getAutoOpenInLandingPage());
            appDownloadTaskM42269a.m42247c(Integer.valueOf(this.f36279r));
            appDownloadTaskM42269a.m42256i(this.f36253E);
            ContentRecord contentRecord = this.f36274m;
            if (contentRecord != null) {
                appDownloadTaskM42269a.m42259l(contentRecord.m41433Z());
                appDownloadTaskM42269a.m42258k(this.f36274m.m41585m());
                appDownloadTaskM42269a.m42260m(this.f36274m.m41588n());
                appDownloadTaskM42269a.m42261n(this.f36274m.m41577k());
                appDownloadTaskM42269a.m42254g(this.f36274m.m41450aB());
                appDownloadTaskM42269a.m42255h(this.f36274m.m41451aC());
            }
        }
        return appDownloadTaskM42269a;
    }

    /* renamed from: G */
    private void m48643G() {
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.AppDownloadButton.8
            public RunnableC78728() {
            }

            @Override // java.lang.Runnable
            public void run() {
                AppDownloadButton.this.refreshStatus();
                if (AppDownloadButton.this.f36268g == null || AppDownloadButton.this.f36272k == AppDownloadButton.this.getStatus()) {
                    return;
                }
                AppDownloadButton.this.f36268g.onStatusChanged(AppDownloadButton.this.getStatus());
            }
        });
    }

    /* renamed from: H */
    private void m48644H() {
        InterfaceC8131x interfaceC8131x = this.f36286y;
        if (interfaceC8131x != null) {
            interfaceC8131x.mo30556b(this);
        }
        View.OnClickListener onClickListener = this.f36287z;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    /* renamed from: I */
    private void m48645I() {
        IPPSNativeView iPPSNativeView = this.f36281t;
        if (iPPSNativeView != null) {
            iPPSNativeView.mo49349c(this);
        }
    }

    /* renamed from: b */
    private AbstractC7687ti m48664b(Context context) {
        if (this.f36274m == null || context == null) {
            AbstractC7185ho.m43820b(((AbstractViewOnClickListenerC8065a) this).f37452a, "getClickAction, invalid param");
            return null;
        }
        HashMap map = new HashMap();
        MetaData metaDataM41568i = this.f36274m.m41568i();
        if (metaDataM41568i != null) {
            map.put("appId", metaDataM41568i.m40330n());
            map.put("thirdId", metaDataM41568i.m40328m());
        }
        return C7686th.m47245a(context, this.f36274m, map);
    }

    private String getAdTag() {
        IPPSNativeView iPPSNativeView = this.f36281t;
        if (iPPSNativeView != null) {
            return iPPSNativeView.getAdTag();
        }
        return null;
    }

    private long getLeftSize() {
        if (this.f36266e == null) {
            return 0L;
        }
        AppDownloadTask task = getTask();
        long fileSize = this.f36266e.getFileSize();
        if (task == null) {
            return fileSize;
        }
        long fileSize2 = this.f36266e.getFileSize() - task.m42075g();
        return fileSize2 <= 0 ? fileSize : fileSize2;
    }

    private AppDownloadTask getTask() {
        ContentRecord contentRecord;
        AppDownloadTask appDownloadTaskM42405d = C7046e.m42377h().m42405d(this.f36266e);
        if (appDownloadTaskM42405d != null && (contentRecord = this.f36274m) != null) {
            appDownloadTaskM42405d.m42258k(contentRecord.m41585m());
            appDownloadTaskM42405d.m42259l(this.f36274m.m41433Z());
            if (!appDownloadTaskM42405d.m42231K()) {
                appDownloadTaskM42405d.m42260m(this.f36274m.m41588n());
            }
            appDownloadTaskM42405d.m42261n(this.f36274m.m41577k());
            appDownloadTaskM42405d.m42250e(this.f36274m.m41464aP());
            appDownloadTaskM42405d.m42264q(this.f36274m.m41463aO());
            appDownloadTaskM42405d.m42255h(this.f36274m.m41451aC());
            appDownloadTaskM42405d.m42254g(this.f36274m.m41450aB());
            if (appDownloadTaskM42405d.m42223C() == null) {
                C7560ou c7560ou = new C7560ou(getContext(), C7662sk.m47225a(getContext(), this.f36274m.m41552f()));
                c7560ou.mo46590a(this.f36274m);
                appDownloadTaskM42405d.m42244a(c7560ou);
            } else {
                ContentRecord contentRecordMo46574a = appDownloadTaskM42405d.m42223C().mo46574a();
                if (contentRecordMo46574a != null) {
                    contentRecordMo46574a.m41396G(this.f36274m.m41450aB());
                    contentRecordMo46574a.m41398H(this.f36274m.m41451aC());
                    contentRecordMo46574a.m41536c(this.f36274m.m41577k());
                }
            }
        }
        return appDownloadTaskM42405d;
    }

    /* renamed from: k */
    private boolean m48685k() {
        String strM42402c = C7046e.m42377h().m42402c(this.f36266e);
        if (strM42402c != null) {
            this.f36266e.m44433v(strM42402c);
        }
        boolean zM42401b = C7046e.m42377h().m42401b(this.f36266e);
        refreshStatus();
        setOnNonWifiDownloadListener(null);
        setNeedShowConfirmDialog(true);
        setNeedShowConfirmDialog(true);
        return zM42401b;
    }

    /* renamed from: l */
    public AppDownloadTask m48686l() {
        AppDownloadTask appDownloadTask;
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43817a(((AbstractViewOnClickListenerC8065a) this).f37452a, "refresAppStatus, start.");
        }
        AppStatus appStatusM48647a = AppStatus.DOWNLOAD;
        AppInfo appInfo = this.f36266e;
        AppDownloadTask task = null;
        if (appInfo != null) {
            String packageName = appInfo.getPackageName();
            if (C7830i.m48427b(getContext(), this.f36266e.getPackageName()) != null) {
                appStatusM48647a = AppStatus.INSTALLED;
            } else {
                task = getTask();
                if (task != null) {
                    appStatusM48647a = m48647a(task, packageName, false);
                }
            }
            AppDownloadTask appDownloadTask2 = task;
            task = packageName;
            appDownloadTask = appDownloadTask2;
        } else {
            appDownloadTask = null;
        }
        this.f36272k = this.f36271j;
        this.f36271j = appStatusM48647a;
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a(((AbstractViewOnClickListenerC8065a) this).f37452a, "refresAppStatus, status:%s, packageName:%s", this.f36271j, task);
        }
        return appDownloadTask;
    }

    /* renamed from: m */
    private boolean m48687m() {
        AppInfo appInfo = this.f36266e;
        return appInfo != null && "11".equals(appInfo.getPriorInstallWay());
    }

    /* renamed from: n */
    private boolean m48688n() {
        AppInfo appInfo = this.f36266e;
        if (appInfo == null) {
            return false;
        }
        String strM44376b = appInfo.m44376b(Integer.valueOf(this.f36276o));
        return (TextUtils.isEmpty(strM44376b) || TextUtils.isEmpty(this.f36266e.getPackageName()) || !strM44376b.equals("6")) ? false : true;
    }

    /* renamed from: o */
    public void m48689o() {
        if (m48679g()) {
            return;
        }
        m48696v();
    }

    /* renamed from: p */
    private void m48690p() {
        Integer num = this.f36277p;
        if (num != null) {
            if (this.f36278q) {
                this.f36276o = num.intValue();
                this.f36277p = null;
            } else {
                this.f36278q = true;
            }
        }
        AbstractC7185ho.m43821b(((AbstractViewOnClickListenerC8065a) this).f37452a, "clickSource:%s", Integer.valueOf(this.f36276o));
    }

    /* renamed from: q */
    private boolean m48691q() {
        if (this.f36266e == null) {
            m48695u();
            AbstractC7185ho.m43820b(((AbstractViewOnClickListenerC8065a) this).f37452a, "appInfo is empty");
            return false;
        }
        if (this.f36271j == AppStatus.INSTALLED || m48687m() || this.f36266e.m44374a(Integer.valueOf(this.f36276o))) {
            return true;
        }
        String strM44376b = this.f36266e.m44376b(Integer.valueOf(this.f36276o));
        if (!TextUtils.isEmpty(strM44376b)) {
            if (strM44376b.equals("7") && !TextUtils.isEmpty(this.f36266e.m44428t())) {
                return true;
            }
            if (strM44376b.equals("9") && !TextUtils.isEmpty(this.f36266e.getPackageName()) && !TextUtils.isEmpty(this.f36266e.m44340A())) {
                return true;
            }
        }
        if (!TextUtils.isEmpty(this.f36266e.getDownloadUrl())) {
            return true;
        }
        m48695u();
        return false;
    }

    /* renamed from: r */
    private boolean m48692r() {
        String strM44376b = this.f36266e.m44376b(Integer.valueOf(this.f36276o));
        if (TextUtils.isEmpty(strM44376b) || TextUtils.isEmpty(this.f36266e.m44428t()) || !strM44376b.equals("7")) {
            return false;
        }
        if (new C7673sv(getContext(), this.f36274m).mo47233a()) {
            m48707d(ClickDestination.APPMARKET);
            return true;
        }
        m48695u();
        return false;
    }

    /* renamed from: s */
    private boolean m48693s() {
        if (!"9".equals(this.f36266e.m44376b(Integer.valueOf(this.f36276o))) || TextUtils.isEmpty(this.f36266e.getPackageName()) || TextUtils.isEmpty(this.f36266e.m44340A())) {
            return false;
        }
        C7679ta c7679ta = new C7679ta(getContext(), this.f36274m);
        if (c7679ta.mo47233a()) {
            m48707d(c7679ta.m47250c());
            return true;
        }
        m48695u();
        return false;
    }

    /* renamed from: t */
    private boolean m48694t() {
        if (!m48688n()) {
            return false;
        }
        C7683te c7683te = new C7683te(getContext(), this.f36274m, null);
        c7683te.m47240a(this.f36276o);
        c7683te.m47241a(Boolean.valueOf(getAutoOpenInLandingPage()));
        c7683te.m47242a(this.f36253E);
        c7683te.mo47233a();
        m48707d(ClickDestination.AGMINIMARKET);
        return true;
    }

    /* renamed from: u */
    private void m48695u() {
        InterfaceC8131x interfaceC8131x = this.f36286y;
        if (interfaceC8131x != null) {
            interfaceC8131x.mo30555a(this);
        }
    }

    /* renamed from: v */
    private void m48696v() {
        AppStatus status = getStatus();
        AbstractC7185ho.m43820b(((AbstractViewOnClickListenerC8065a) this).f37452a, "onClick, status:" + status);
        switch (C78662.f36291b[status.ordinal()]) {
            case 1:
                m48668b(this.f36285x);
                m48707d(m48687m() ? "restore" : "download");
                break;
            case 2:
            case 3:
                m48668b(false);
                break;
            case 4:
                AppDownloadTask task = getTask();
                if (task != null) {
                    C7046e.m42377h().m42398b(task);
                    break;
                }
                break;
            case 5:
                m48697w();
                break;
            case 6:
                AppDownloadTask task2 = getTask();
                if (task2 != null) {
                    m48675e(task2);
                    break;
                }
                break;
        }
    }

    /* renamed from: w */
    private void m48697w() {
        if (!m48699y() || this.f36255G == 1) {
            m48700z();
        } else {
            m48698x();
            AbstractC7817dj.m48364a(new Runnable() { // from class: com.huawei.openalliance.ad.views.AppDownloadButton.3
                public RunnableC78673() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    AppDownloadButton.this.m48700z();
                }
            }, 600L);
        }
    }

    /* renamed from: x */
    private void m48698x() {
        Context context = getContext();
        AppDownloadTask appDownloadTaskM48642F = m48642F();
        if (context == null || appDownloadTaskM48642F == null) {
            return;
        }
        C7037e.m42187a(context).m42196a(appDownloadTaskM48642F);
    }

    /* renamed from: y */
    private boolean m48699y() {
        return AbstractC7558os.m46458F(this.f36274m.m41427W()) && C7831j.m48458a(this.f36266e);
    }

    /* renamed from: z */
    public void m48700z() {
        if (this.f36274m == null) {
            return;
        }
        Context context = getContext();
        String packageName = this.f36266e.getPackageName();
        C7560ou c7560ou = new C7560ou(context, C7662sk.m47225a(context, this.f36274m.m41552f()));
        c7560ou.mo46590a(this.f36274m);
        if (C7739am.m47530b(context, packageName)) {
            m48654a(context, c7560ou);
        } else {
            m48657a(context, packageName, c7560ou);
        }
    }

    /* renamed from: c */
    public void m48706c() {
        Context context = getContext();
        if (!(context instanceof Activity) || getStatus() != AppStatus.DOWNLOAD || !this.f36250B || !this.f36251C) {
            m48709e();
            return;
        }
        C7072dp c7072dp = new C7072dp(context);
        c7072dp.m42023a(new AbstractC7026do.a() { // from class: com.huawei.openalliance.ad.views.AppDownloadButton.7
            public C78717() {
            }

            @Override // com.huawei.openalliance.p169ad.AbstractC7026do.a
            /* renamed from: a */
            public void mo42028a(AppInfo appInfo) {
                AppDownloadButton.this.setNeedShowConfirmDialog(false);
                AppDownloadButton.this.m48709e();
            }

            @Override // com.huawei.openalliance.p169ad.AbstractC7026do.a
            /* renamed from: b */
            public void mo42029b(AppInfo appInfo) {
                if (AppDownloadButton.this.f36257I != null) {
                    AppDownloadButton.this.f36257I.onNewStatusChanged(AppStatusV1.PRE_CHECK_FAILED, 1002, appInfo);
                }
            }

            @Override // com.huawei.openalliance.p169ad.AbstractC7026do.a
            /* renamed from: c */
            public void mo42030c(AppInfo appInfo) {
            }
        });
        this.f36252D = true;
        c7072dp.mo42025a(this.f36266e, this.f36274m, getLeftSize());
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.IAppDownloadButton
    @OuterVisible
    public void cancel() {
        m48685k();
    }

    @OuterVisible
    public void continueDownload() {
        if (m48679g()) {
            return;
        }
        m48709e();
    }

    /* renamed from: f */
    public void m48710f() {
        m48663a(true);
    }

    public AppInfo getAppInfo() {
        return this.f36266e;
    }

    public boolean getAutoOpenInLandingPage() {
        if (this.f36276o == 4) {
            this.f36262N = Boolean.FALSE;
        }
        if (this.f36262N == null) {
            Context context = getContext();
            this.f36262N = Boolean.valueOf((context instanceof LandingDetailsActivity) || (context instanceof PPSActivity));
        }
        return this.f36262N.booleanValue();
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public int getCancelBtnHeight(int i10) {
        return i10;
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public View getProgressBtn() {
        return this;
    }

    public int getRoundRadius() {
        return getStyle().m48720d();
    }

    public int getSource() {
        return this.f36276o;
    }

    @Override // com.huawei.openalliance.p169ad.views.AbstractViewOnClickListenerC8065a, com.huawei.hms.ads.uiengine.common.IProgressButton
    public AppStatus getStatus() {
        AppStatus appStatus = this.f36271j;
        return appStatus == null ? AppStatus.DOWNLOAD : appStatus;
    }

    public AppDownloadButtonStyle getStyle() {
        return ((AbstractViewOnClickListenerC8065a) this).f37453b;
    }

    @Override // android.view.ViewGroup, android.view.View
    @OuterVisible
    public void onAttachedToWindow() {
        String str;
        String str2;
        super.onAttachedToWindow();
        this.f36254F = true;
        if (this.f36274m != null) {
            super.m50516i();
        }
        try {
            if (AbstractC7185ho.m43819a()) {
                String str3 = ((AbstractViewOnClickListenerC8065a) this).f37452a;
                Object[] objArr = new Object[1];
                AppInfo appInfo = this.f36266e;
                objArr[0] = appInfo == null ? null : appInfo.getPackageName();
                AbstractC7185ho.m43818a(str3, "onAttachedToWindow, packageName:%s", objArr);
            } else {
                AbstractC7185ho.m43820b(((AbstractViewOnClickListenerC8065a) this).f37452a, "onAttachedToWindow appinfo is " + AbstractC7806cz.m48162b(this.f36266e));
            }
            C7046e.m42377h().m42388a(this.f36266e, this.f36249A);
            C7046e.m42377h().m42389a(this.f36266e, this.f36256H);
            refreshStatusAsync(null);
        } catch (RuntimeException unused) {
            str = ((AbstractViewOnClickListenerC8065a) this).f37452a;
            str2 = "onAttachedToWindow RuntimeException";
            AbstractC7185ho.m43823c(str, str2);
        } catch (Exception unused2) {
            str = ((AbstractViewOnClickListenerC8065a) this).f37452a;
            str2 = "onAttachedToWindow Exception";
            AbstractC7185ho.m43823c(str, str2);
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.AbstractViewOnClickListenerC8065a, android.view.View.OnClickListener
    @OuterVisible
    public void onClick(View view) {
        try {
            m48690p();
            InterfaceC7875b interfaceC7875b = this.f36260L;
            if (interfaceC7875b != null) {
                interfaceC7875b.mo30557a();
            }
            IPPSPlacementView iPPSPlacementView = this.f36283v;
            if (iPPSPlacementView != null) {
                updateContent(iPPSPlacementView.getShowId());
            }
            if (m48663a(false)) {
                return;
            }
            if (isFastClick()) {
                AbstractC7185ho.m43820b(((AbstractViewOnClickListenerC8065a) this).f37452a, "fast click, ignore");
                return;
            }
            IPPSNativeView iPPSNativeView = this.f36281t;
            if (iPPSNativeView != null) {
                iPPSNativeView.mo49355h();
            }
            if (!AbstractC7811dd.m48310b(getContext())) {
                m48689o();
            } else {
                AbstractC7185ho.m43820b("AppDownloadButton", "screenLocked onBtnClick");
                C5077a.m30321a(getContext(), new C7881h(this));
            }
        } catch (Throwable th2) {
            AbstractC7185ho.m43823c(((AbstractViewOnClickListenerC8065a) this).f37452a, "ApDownLoadBut click err: " + th2.getClass().getSimpleName());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    @OuterVisible
    public void onDetachedFromWindow() {
        String str;
        String str2;
        super.onDetachedFromWindow();
        this.f36254F = false;
        try {
            if (AbstractC7185ho.m43819a()) {
                String str3 = ((AbstractViewOnClickListenerC8065a) this).f37452a;
                Object[] objArr = new Object[1];
                AppInfo appInfo = this.f36266e;
                objArr[0] = appInfo == null ? null : appInfo.getPackageName();
                AbstractC7185ho.m43818a(str3, "onDetachedFromWindow, packageName:%s", objArr);
            } else {
                AbstractC7185ho.m43820b(((AbstractViewOnClickListenerC8065a) this).f37452a, "onDetachedFromWindow appinfo is " + AbstractC7806cz.m48162b(this.f36266e));
            }
            C7046e.m42377h().m42399b(this.f36266e, this.f36249A);
            C7046e.m42377h().m42400b(this.f36266e, this.f36256H);
        } catch (RuntimeException unused) {
            str = ((AbstractViewOnClickListenerC8065a) this).f37452a;
            str2 = "onDetachedFromWindow RuntimeException";
            AbstractC7185ho.m43823c(str, str2);
        } catch (Exception unused2) {
            str = ((AbstractViewOnClickListenerC8065a) this).f37452a;
            str2 = "onDetachedFromWindow Exception";
            AbstractC7185ho.m43823c(str, str2);
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i10) {
        if (AbstractC7185ho.m43819a()) {
            String str = ((AbstractViewOnClickListenerC8065a) this).f37452a;
            Object[] objArr = new Object[1];
            AppStatus appStatus = this.f36271j;
            objArr[0] = appStatus == null ? null : appStatus.toString();
            AbstractC7185ho.m43818a(str, "onVisibilityChanged, status:%s", objArr);
        }
        super.onVisibilityChanged(view, i10);
        this.f36261M = i10 == 0;
        if (this.f36254F) {
            refreshStatusAsync(null);
        } else {
            AbstractC7185ho.m43823c(((AbstractViewOnClickListenerC8065a) this).f37452a, "not attached to window, return.");
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.IAppDownloadButton
    @OuterVisible
    public AppStatus refreshStatus() {
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a(((AbstractViewOnClickListenerC8065a) this).f37452a, "refreshStatus starts:%d", Long.valueOf(AbstractC7741ao.m47566c()));
        }
        m48669c(m48686l());
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a(((AbstractViewOnClickListenerC8065a) this).f37452a, "refreshStatus ends:%d", Long.valueOf(AbstractC7741ao.m47566c()));
        }
        return this.f36271j;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.IAppDownloadButton
    @OuterVisible
    public void refreshStatusAsync(OnStatusRefreshedListener onStatusRefreshedListener) {
        m48669c((AppDownloadTask) null);
        AbstractC7834m.m48486f(new RunnableC7880g(this, onStatusRefreshedListener));
    }

    @OuterVisible
    public void removeResolutionRequiredListener() {
        C7046e.m42377h().m42400b(this.f36266e, this.f36256H);
        this.f36256H = null;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.IAppDownloadButton
    @OuterVisible
    public void setAdLandingPageData(AdLandingPageData adLandingPageData) {
        String str;
        String str2;
        try {
            if (adLandingPageData == null) {
                setAppInfo(null);
                this.f36274m = null;
                return;
            }
            ContentRecord contentRecordM44329y = adLandingPageData.m44329y();
            this.f36274m = contentRecordM44329y;
            super.setAdData(contentRecordM44329y);
            if (this.f36254F) {
                super.m50516i();
            }
            AppInfo appInfo = adLandingPageData.getAppInfo();
            if (appInfo != null) {
                setAppInfo(appInfo);
                setShowPermissionDialog(appInfo.isPermPromptForLanding());
            }
            updateContent(adLandingPageData.m44277c());
            updateStartShowTime(adLandingPageData.m44256E());
            this.f36276o = 2;
            this.f36262N = Boolean.valueOf(getAutoOpenInLandingPage());
            this.f36280s = adLandingPageData.m44293g();
            this.f36250B = AbstractC7558os.m46474m(this.f36274m.m41427W());
        } catch (IllegalArgumentException unused) {
            str = ((AbstractViewOnClickListenerC8065a) this).f37452a;
            str2 = "setAdLandingPageData IllegalArgumentException";
            AbstractC7185ho.m43823c(str, str2);
        } catch (Exception unused2) {
            str = ((AbstractViewOnClickListenerC8065a) this).f37452a;
            str2 = "setAdLandingPageData error";
            AbstractC7185ho.m43823c(str, str2);
        }
    }

    public void setAfDlBtnText(String str) {
        if (this.f36266e == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f36266e.m44437x(str);
    }

    @OuterVisible
    public void setAllowedNonWifiNetwork(boolean z10) {
        this.f36267f = z10;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.IAppDownloadButton
    public void setAppDetailView(PPSAppDetailView pPSAppDetailView) {
        this.f36284w = pPSAppDetailView;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.IAppDownloadButton
    @OuterVisible
    public void setAppDownloadButtonStyle(AppDownloadButtonStyle appDownloadButtonStyle) {
        ((AbstractViewOnClickListenerC8065a) this).f37453b = appDownloadButtonStyle;
        refreshStatusAsync(null);
    }

    @OuterVisible
    public void setAppInfo(AppInfo appInfo) {
        AbstractC7185ho.m43820b(((AbstractViewOnClickListenerC8065a) this).f37452a, "setAppInfo appInfo is " + AbstractC7806cz.m48162b(appInfo));
        this.f36266e = appInfo;
        if (appInfo != null) {
            C7046e.m42377h().m42388a(appInfo, this.f36249A);
        }
    }

    public void setBfDlBtnTxt(String str) {
        AppInfo appInfo = this.f36266e;
        if (appInfo != null) {
            appInfo.m44434w(str);
        }
    }

    @OuterVisible
    @Deprecated
    public void setButtonTextWatcher(ButtonTextWatcher buttonTextWatcher) {
    }

    public void setButtonTextWatcherInner(InterfaceC7878e interfaceC7878e) {
        this.f36270i = interfaceC7878e;
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public void setCancelBtnHeight(int i10) {
    }

    public void setClickActionListener(InterfaceC8131x interfaceC8131x) {
        this.f36286y = interfaceC8131x;
    }

    public void setCustMonitor(InterfaceC7342jp interfaceC7342jp) {
        this.f36264P = interfaceC7342jp;
    }

    public void setDlBtnText(String str) {
        if (this.f36266e == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f36266e.m44434w(str);
    }

    public void setLinkedCoverClickListener(View.OnClickListener onClickListener) {
        this.f36287z = onClickListener;
    }

    public void setMonitorEp(C7560ou c7560ou) {
        Object[] objArr = new Object[1];
        objArr[0] = c7560ou == null ? "null" : "not null";
        AbstractC7185ho.m43818a("AppDownloadButton", "eventprocessor is %s", objArr);
        this.f36263O = c7560ou;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.IAppDownloadButton
    public boolean setNativeAd(INativeAd iNativeAd) {
        String str;
        StringBuilder sb2;
        String str2;
        if (iNativeAd == null) {
            setAppInfo(null);
            this.f36274m = null;
            this.f36265d = null;
            return false;
        }
        if (iNativeAd instanceof C7302e) {
            this.f36265d = (C7302e) iNativeAd;
        }
        try {
            this.f36276o = 1;
            ContentRecord contentRecordM46698a = C7570pd.m46698a(this.f36265d);
            this.f36274m = contentRecordM46698a;
            super.setAdData(contentRecordM46698a);
            if (this.f36254F) {
                super.m50516i();
            }
            AppInfo appInfo = iNativeAd.getAppInfo();
            setAppInfo(appInfo);
            C7302e c7302e = this.f36265d;
            if (c7302e != null) {
                MetaData metaData = (MetaData) AbstractC7758be.m47739b(c7302e.m44775R(), MetaData.class, new Class[0]);
                if (metaData != null) {
                    this.f36280s = metaData.m40343w();
                }
                this.f36250B = AbstractC7558os.m46474m(this.f36265d.getCtrlSwitchs());
            }
            if (appInfo != null) {
                setShowPermissionDialog(appInfo.isPermPromptForCard());
                return true;
            }
        } catch (RuntimeException e10) {
            e = e10;
            str = ((AbstractViewOnClickListenerC8065a) this).f37452a;
            sb2 = new StringBuilder();
            str2 = "setNativeAd RuntimeException:";
            sb2.append(str2);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43826d(str, sb2.toString());
            return false;
        } catch (Exception e11) {
            e = e11;
            str = ((AbstractViewOnClickListenerC8065a) this).f37452a;
            sb2 = new StringBuilder();
            str2 = "setNativeAd Exception:";
            sb2.append(str2);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43826d(str, sb2.toString());
            return false;
        }
        return false;
    }

    public void setNeedAppendProgress(boolean z10) {
        this.f36259K = z10;
    }

    public void setNeedShowConfirmDialog(boolean z10) {
        this.f36251C = z10;
    }

    public void setNeedShowPermision(boolean z10) {
        this.f36285x = z10;
    }

    @OuterVisible
    public void setOnDownloadStatusChangedListener(OnDownloadStatusChangedListener onDownloadStatusChangedListener) {
        this.f36268g = onDownloadStatusChangedListener;
    }

    @OuterVisible
    public void setOnNonWifiDownloadListener(OnNonWifiDownloadListener onNonWifiDownloadListener) {
        this.f36269h = onNonWifiDownloadListener;
    }

    @OuterVisible
    public void setOnResolutionRequiredListener(OnResolutionRequiredListener onResolutionRequiredListener) {
        this.f36256H = new C7879f(onResolutionRequiredListener);
    }

    public void setOnceSource(int i10) {
        this.f36278q = false;
        this.f36277p = Integer.valueOf(this.f36276o);
        this.f36276o = i10;
    }

    @Override // android.view.View
    public void setPadding(int i10, int i11, int i12, int i13) {
        super.m49964a(i10, i11, i12, i13);
    }

    @Override // android.view.View
    public void setPaddingRelative(int i10, int i11, int i12, int i13) {
        super.m49967b(i10, i11, i12, i13);
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.IAppDownloadButton
    @OuterVisible
    public boolean setPlacementAd(IPlacementAd iPlacementAd) {
        if (iPlacementAd == null) {
            return false;
        }
        try {
            this.f36276o = 1;
            if (iPlacementAd instanceof C7304g) {
                ContentRecord contentRecordM46766a = C7575pi.m46766a((C7304g) iPlacementAd);
                this.f36274m = contentRecordM46766a;
                super.setAdData(contentRecordM46766a);
                if (this.f36254F) {
                    super.m50516i();
                }
            }
            if (this.f36274m != null) {
                AppInfo appInfo = iPlacementAd.getAppInfo();
                if (appInfo != null) {
                    setShowPermissionDialog(appInfo.isPermPromptForCard());
                }
                setAppInfo(appInfo);
                MetaData metaDataM41568i = this.f36274m.m41568i();
                if (metaDataM41568i != null) {
                    this.f36280s = metaDataM41568i.m40343w();
                }
                this.f36250B = AbstractC7558os.m46474m(this.f36274m.m41427W());
                return true;
            }
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c(((AbstractViewOnClickListenerC8065a) this).f37452a, "register placementAd ex: %s", th2.getClass().getSimpleName());
        }
        return false;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.IAppDownloadButton
    public void setPpsLinkedView(IPPSLinkedView iPPSLinkedView) {
        this.f36282u = iPPSLinkedView;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.IAppDownloadButton
    public void setPpsNativeView(IPPSNativeView iPPSNativeView) {
        this.f36281t = iPPSNativeView;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.IAppDownloadButton
    @OuterVisible
    public void setPpsPlacementView(IPPSPlacementView iPPSPlacementView) {
        this.f36283v = iPPSPlacementView;
    }

    public void setRemoteAfDlBtnText(String str) {
        AppInfo appInfo = this.f36266e;
        if (appInfo != null) {
            appInfo.m44441z(str);
        }
    }

    public void setRemoteBfDlBtnTxt(String str) {
        AppInfo appInfo = this.f36266e;
        if (appInfo != null) {
            appInfo.m44439y(str);
        }
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public void setResetListener(IProgressButton.ProgressButtonResetListener progressButtonResetListener) {
    }

    @Override // com.huawei.openalliance.p169ad.views.AbstractViewOnClickListenerC8065a, com.huawei.hms.ads.uiengine.common.IProgressButton
    @OuterVisible
    public void setResetWidth(boolean z10) {
        super.setResetWidth(z10);
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public void setShowCancelBtn(boolean z10) {
    }

    @OuterVisible
    public void setShowPermissionDialog(boolean z10) {
        this.f36275n = z10;
    }

    public void setSource(int i10) {
        this.f36276o = i10;
        AbstractC7185ho.m43821b(((AbstractViewOnClickListenerC8065a) this).f37452a, "setSource: %s", Integer.valueOf(i10));
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public void setTextInner(CharSequence charSequence, boolean z10) {
    }

    public void setVenusExt(String str) {
        this.f36253E = str;
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
        super.setVisibilityInner(i10);
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.IAppDownloadButton
    public void updateContent(String str) {
        ContentRecord contentRecord = this.f36274m;
        if (contentRecord != null) {
            contentRecord.m41536c(str);
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.IAppDownloadButton
    public void updateStartShowTime(long j10) {
        ContentRecord contentRecord = this.f36274m;
        if (contentRecord != null) {
            contentRecord.m41560g(j10);
        }
    }

    @OuterVisible
    public AppDownloadButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f36271j = AppStatus.DOWNLOAD;
        this.f36273l = -1;
        this.f36275n = true;
        this.f36276o = 1;
        this.f36278q = false;
        this.f36279r = 2;
        this.f36285x = true;
        this.f36251C = true;
        this.f36252D = false;
        this.f36254F = false;
        this.f36255G = -1;
        this.f36259K = false;
        m48653a(context, attributeSet, -1, -1);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0042, code lost:
    
        if (r6 <= 0) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0072, code lost:
    
        if (r6 > 0) goto L48;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.huawei.openalliance.p169ad.download.app.AppStatus m48647a(com.huawei.openalliance.p169ad.download.app.AppDownloadTask r6, java.lang.String r7, boolean r8) {
        /*
            r5 = this;
            com.huawei.openalliance.ad.download.e r0 = r6.m42077i()
            boolean r1 = com.huawei.openalliance.p169ad.AbstractC7185ho.m43819a()
            if (r1 == 0) goto L26
            java.lang.String r1 = r5.f37452a
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            if (r0 == 0) goto L16
            int r3 = r0.m42596a()
            goto L17
        L16:
            r3 = -1
        L17:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r4 = 0
            r2[r4] = r3
            r3 = 1
            r2[r3] = r7
            java.lang.String r7 = "refreshStatus, downloadStatus:%d, packageName:%s"
            com.huawei.openalliance.p169ad.AbstractC7185ho.m43818a(r1, r7, r2)
        L26:
            int[] r7 = com.huawei.openalliance.p169ad.views.AppDownloadButton.C78662.f36290a
            int r0 = r0.ordinal()
            r7 = r7[r0]
            switch(r7) {
                case 1: goto L6c;
                case 2: goto L69;
                case 3: goto L66;
                case 4: goto L66;
                case 5: goto L63;
                case 6: goto L59;
                case 7: goto L47;
                case 8: goto L34;
                default: goto L31;
            }
        L31:
            com.huawei.openalliance.ad.download.app.AppStatus r5 = com.huawei.openalliance.p169ad.download.app.AppStatus.DOWNLOAD
            goto L75
        L34:
            com.huawei.openalliance.ad.download.DownloadTask$c r7 = r6.m42084p()
            int r6 = r6.m42080l()
            r5.f36273l = r6
            com.huawei.openalliance.ad.download.DownloadTask$c r5 = com.huawei.openalliance.p169ad.download.DownloadTask.EnumC7031c.NONE
            if (r7 != r5) goto L44
            if (r6 <= 0) goto L31
        L44:
            com.huawei.openalliance.ad.download.app.AppStatus r5 = com.huawei.openalliance.p169ad.download.app.AppStatus.PAUSE
            goto L75
        L47:
            if (r8 != 0) goto L56
            com.huawei.openalliance.ad.download.app.AppStatus r6 = com.huawei.openalliance.p169ad.download.app.AppStatus.DOWNLOAD
            com.huawei.openalliance.ad.download.app.e r7 = com.huawei.openalliance.p169ad.download.app.C7046e.m42377h()
            com.huawei.openalliance.ad.inter.data.AppInfo r5 = r5.f36266e
            r7.m42396a(r5)
            r5 = r6
            goto L75
        L56:
            com.huawei.openalliance.ad.download.app.AppStatus r5 = com.huawei.openalliance.p169ad.download.app.AppStatus.INSTALLED
            goto L75
        L59:
            com.huawei.openalliance.ad.download.app.AppStatus r7 = com.huawei.openalliance.p169ad.download.app.AppStatus.INSTALLING
        L5b:
            int r6 = r6.m42080l()
            r5.f36273l = r6
            r5 = r7
            goto L75
        L63:
            com.huawei.openalliance.ad.download.app.AppStatus r5 = com.huawei.openalliance.p169ad.download.app.AppStatus.INSTALL
            goto L75
        L66:
            com.huawei.openalliance.ad.download.app.AppStatus r7 = com.huawei.openalliance.p169ad.download.app.AppStatus.DOWNLOADING
            goto L5b
        L69:
            com.huawei.openalliance.ad.download.app.AppStatus r7 = com.huawei.openalliance.p169ad.download.app.AppStatus.WAITING_FOR_WIFI
            goto L5b
        L6c:
            int r6 = r6.m42080l()
            r5.f36273l = r6
            if (r6 <= 0) goto L31
            goto L44
        L75:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.views.AppDownloadButton.m48647a(com.huawei.openalliance.ad.download.app.AppDownloadTask, java.lang.String, boolean):com.huawei.openalliance.ad.download.app.AppStatus");
    }

    /* renamed from: c */
    public void m48669c(AppDownloadTask appDownloadTask) {
        if (AbstractC7185ho.m43819a()) {
            String str = ((AbstractViewOnClickListenerC8065a) this).f37452a;
            Object[] objArr = new Object[3];
            objArr[0] = this.f36271j;
            objArr[1] = this.f36272k;
            AppInfo appInfo = this.f36266e;
            objArr[2] = appInfo == null ? null : appInfo.getPackageName();
            AbstractC7185ho.m43818a(str, "processStatus, status:%s, preStatus:%s, packageName:%s", objArr);
        }
        Context context = getContext();
        AppStatus appStatus = this.f36271j;
        if (appStatus == null) {
            appStatus = AppStatus.DOWNLOAD;
        }
        AppDownloadButtonStyle.Style styleM48717a = ((AbstractViewOnClickListenerC8065a) this).f37453b.m48717a(getContext(), appStatus, this.f36276o);
        setTextColor(styleM48717a.textColor);
        int i10 = this.f36273l;
        Drawable drawable = styleM48717a.background;
        if (i10 != -1) {
            setProgressDrawable(drawable, i10);
        } else {
            setProgressDrawable(drawable);
        }
        m49966a(appStatus);
        switch (C78662.f36291b[appStatus.ordinal()]) {
            case 1:
                m48652a(context, this.f36276o, AppStatus.DOWNLOAD);
                return;
            case 2:
            case 3:
                m48652a(context, this.f36276o, AppStatus.PAUSE);
                if (this.f36276o == 11) {
                    return;
                }
                break;
            case 4:
                m48652a(context, this.f36276o, AppStatus.DOWNLOADING);
                if (this.f36276o == 11) {
                    return;
                }
                break;
            case 5:
                m48651a(context);
                return;
            case 6:
                if (appDownloadTask != null) {
                    m48659a(appDownloadTask, context);
                    return;
                }
                return;
            case 7:
                if (appDownloadTask != null) {
                    m48665b(appDownloadTask, context);
                    return;
                }
                return;
            default:
                return;
        }
        setProgress(this.f36273l);
    }

    /* renamed from: d */
    private void m48672d(AppDownloadTask appDownloadTask) {
        if (!appDownloadTask.m42230J()) {
            appDownloadTask.m42054a(EnumC7062e.FAILED);
            m48643G();
        } else {
            AbstractC7185ho.m43817a(((AbstractViewOnClickListenerC8065a) this).f37452a, "switch to nextInstallWay");
            appDownloadTask.m42054a(EnumC7062e.IDLE);
            AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.AppDownloadButton.1
                public RunnableC78641() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    AppDownloadButton.this.f36271j = AppStatus.DOWNLOAD;
                    AppDownloadButton.this.m48668b(false);
                }
            });
        }
    }

    /* renamed from: e */
    private C7587b.a m48674e(String str) {
        C7587b.a aVar = new C7587b.a();
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a(((AbstractViewOnClickListenerC8065a) this).f37452a, "prepare click info, source: %s, clickInfo: %s", Integer.valueOf(this.f36276o), this.f36258J);
        }
        aVar.m46920b(str).m46915a(Integer.valueOf(this.f36276o)).m46914a(this.f36258J).m46923d(C7753b.m47699a(getContext())).m46924e(getAdTag());
        return aVar;
    }

    /* renamed from: f */
    public void m48676f(AppDownloadTask appDownloadTask) {
        String str;
        String str2;
        if (this.f36266e == null || this.f36274m == null) {
            str = ((AbstractViewOnClickListenerC8065a) this).f37452a;
            str2 = "installApk, appinfo or content record is null";
        } else {
            if (appDownloadTask != null) {
                if (appDownloadTask.m42231K()) {
                    C7046e.m42377h().mo42403c(appDownloadTask);
                    return;
                } else {
                    C7562ow.m46641a(getContext()).m46652a(this.f36266e, appDownloadTask, new C7874a(this, appDownloadTask, this.f36257I));
                    return;
                }
            }
            str = ((AbstractViewOnClickListenerC8065a) this).f37452a;
            str2 = "installApk, task is null";
        }
        AbstractC7185ho.m43823c(str, str2);
    }

    /* renamed from: g */
    private boolean m48679g() {
        String str;
        String str2;
        if (m48691q()) {
            m48644H();
            if (m48693s()) {
                str = ((AbstractViewOnClickListenerC8065a) this).f37452a;
                str2 = "open harmony service";
            } else {
                if (this.f36271j == AppStatus.INSTALLED) {
                    m48696v();
                    return true;
                }
                if (m48684j()) {
                    return m48681h();
                }
                if (m48692r()) {
                    str = ((AbstractViewOnClickListenerC8065a) this).f37452a;
                    str2 = "open Ag detail";
                } else {
                    if (!m48694t()) {
                        return false;
                    }
                    str = ((AbstractViewOnClickListenerC8065a) this).f37452a;
                    str2 = "open Ag mini detail";
                }
            }
        } else {
            str = ((AbstractViewOnClickListenerC8065a) this).f37452a;
            str2 = "click action invalid.";
        }
        AbstractC7185ho.m43820b(str, str2);
        return true;
    }

    /* renamed from: h */
    private boolean m48681h() {
        if (this.f36274m == null) {
            return false;
        }
        C7302e c7302e = this.f36265d;
        boolean zMo47233a = new C7681tc(getContext(), this.f36274m, true, c7302e != null ? c7302e.m44815ak() : null).mo47233a();
        if (zMo47233a) {
            AbstractC7185ho.m43820b(((AbstractViewOnClickListenerC8065a) this).f37452a, "list page btn openLandingPage");
            m48707d("web");
        }
        return zMo47233a;
    }

    /* renamed from: j */
    private boolean m48684j() {
        AppInfo appInfo;
        if (this.f36276o != 1 || (appInfo = this.f36266e) == null) {
            return false;
        }
        return PriorInstallWay.PRIOR_ACTION_LANDING_PAGE.equalsIgnoreCase(appInfo.m44366a());
    }

    /* renamed from: b */
    public void m48705b() {
        AppInfo appInfo = this.f36266e;
        if (appInfo != null && !appInfo.m44374a(Integer.valueOf(this.f36276o)) && !m48687m()) {
            AppDownloadTask task = getTask();
            if ((task == null || !task.m42083o()) && !this.f36267f) {
                C7073dq c7073dq = new C7073dq(getContext());
                c7073dq.m42023a(new AbstractC7026do.a() { // from class: com.huawei.openalliance.ad.views.AppDownloadButton.6
                    public C78706() {
                    }

                    @Override // com.huawei.openalliance.p169ad.AbstractC7026do.a
                    /* renamed from: a */
                    public void mo42028a(AppInfo appInfo2) {
                        AppDownloadButton.this.setAllowedNonWifiNetwork(true);
                        AppDownloadButton.this.setNeedShowConfirmDialog(false);
                        AppDownloadButton.this.m48706c();
                    }

                    @Override // com.huawei.openalliance.p169ad.AbstractC7026do.a
                    /* renamed from: b */
                    public void mo42029b(AppInfo appInfo2) {
                        if (AppDownloadButton.this.f36257I != null) {
                            AppDownloadButton.this.f36257I.onNewStatusChanged(AppStatusV1.PRE_CHECK_FAILED, 1003, appInfo2);
                        }
                    }

                    @Override // com.huawei.openalliance.p169ad.AbstractC7026do.a
                    /* renamed from: c */
                    public void mo42030c(AppInfo appInfo2) {
                        AppDownloadButton.this.m48641E();
                    }
                });
                c7073dq.mo42025a(this.f36266e, this.f36274m, getLeftSize());
                return;
            }
            setAllowedNonWifiNetwork(true);
        }
        m48706c();
    }

    @OuterVisible
    public AppDownloadButton(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f36271j = AppStatus.DOWNLOAD;
        this.f36273l = -1;
        this.f36275n = true;
        this.f36276o = 1;
        this.f36278q = false;
        this.f36279r = 2;
        this.f36285x = true;
        this.f36251C = true;
        this.f36252D = false;
        this.f36254F = false;
        this.f36255G = -1;
        this.f36259K = false;
        m48653a(context, attributeSet, i10, -1);
    }

    @Override // com.huawei.openalliance.p169ad.download.InterfaceC7069l
    /* renamed from: b */
    public void mo42628b(AppDownloadTask appDownloadTask) {
        if (AbstractC7185ho.m43819a()) {
            String str = ((AbstractViewOnClickListenerC8065a) this).f37452a;
            Object[] objArr = new Object[3];
            objArr[0] = appDownloadTask.mo42082n();
            AppInfo appInfo = this.f36266e;
            objArr[1] = appInfo == null ? null : appInfo.getPackageName();
            objArr[2] = appDownloadTask.m42077i();
            AbstractC7185ho.m43818a(str, "onStatusChanged, taskId:%s, packageName:%s, status:%s", objArr);
        }
        AppInfo appInfo2 = this.f36266e;
        if (appInfo2 == null || !appInfo2.getPackageName().equals(appDownloadTask.mo42082n())) {
            return;
        }
        if (!"11".equals(appDownloadTask.m42228H()) || appDownloadTask.m42077i() != EnumC7062e.WAITING) {
            m48643G();
        } else if (this.f36261M) {
            m48672d(appDownloadTask);
        } else {
            AbstractC7185ho.m43817a(((AbstractViewOnClickListenerC8065a) this).f37452a, "not visible");
        }
    }

    /* renamed from: d */
    public void m48707d(String str) {
        if (this.f36274m == null) {
            AbstractC7185ho.m43820b(((AbstractViewOnClickListenerC8065a) this).f37452a, "reportClickEvent, record is null.");
            return;
        }
        C7560ou c7560ou = new C7560ou(getContext(), C7662sk.m47225a(getContext(), this.f36274m.m41552f()));
        c7560ou.mo46590a(this.f36274m);
        m48638B();
        if (m48637A()) {
            AbstractC7185ho.m43820b(((AbstractViewOnClickListenerC8065a) this).f37452a, "reportClick event.");
            C7587b.a aVarM48674e = m48674e(str);
            c7560ou.mo46594a(aVarM48674e.m46918a());
            C7560ou c7560ou2 = this.f36263O;
            if (c7560ou2 != null) {
                c7560ou2.mo46594a(aVarM48674e.m46918a());
            }
            InterfaceC7342jp interfaceC7342jp = this.f36264P;
            if (interfaceC7342jp != null) {
                interfaceC7342jp.mo45351a();
            }
            m48645I();
            this.f36258J = null;
            m48639C();
        }
    }

    /* renamed from: e */
    public void m48709e() {
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a(((AbstractViewOnClickListenerC8065a) this).f37452a, "downloadApp, status:%s", getStatus());
        }
        if ((getStatus() == AppStatus.DOWNLOAD || getStatus() == AppStatus.PAUSE || getStatus() == AppStatus.WAITING_FOR_WIFI) && this.f36266e != null) {
            AppDownloadTask task = getTask();
            if (task == null) {
                AppDownloadTask appDownloadTaskM48642F = m48642F();
                if (appDownloadTaskM48642F != null) {
                    appDownloadTaskM48642F.m42057a(this.f36267f);
                }
                C7046e.m42377h().mo42403c(appDownloadTaskM48642F);
                return;
            }
            task.m42245a(Integer.valueOf(this.f36276o));
            task.m42247c(Integer.valueOf(this.f36279r));
            task.m42256i(this.f36253E);
            task.m42057a(this.f36267f);
            C7046e.m42377h().mo42393a(task, true);
        }
    }

    @OuterVisible
    public AppDownloadButton(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.f36271j = AppStatus.DOWNLOAD;
        this.f36273l = -1;
        this.f36275n = true;
        this.f36276o = 1;
        this.f36278q = false;
        this.f36279r = 2;
        this.f36285x = true;
        this.f36251C = true;
        this.f36252D = false;
        this.f36254F = false;
        this.f36255G = -1;
        this.f36259K = false;
        m48653a(context, attributeSet, i10, i11);
    }

    /* renamed from: a */
    private String m48649a(int i10, AppStatus appStatus) {
        String strM40468d = null;
        if (m48687m() || AbstractC7760bg.m47767a(this.f36280s)) {
            return null;
        }
        int i11 = i10 != 1 ? 1 : 2;
        int iM40459a = TextState.m40459a(appStatus);
        String strM48224c = AbstractC7807d.m48224c();
        Iterator<TextState> it = this.f36280s.iterator();
        String strM40468d2 = null;
        String strM40468d3 = null;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TextState next = it.next();
            AbstractC7185ho.m43818a(((AbstractViewOnClickListenerC8065a) this).f37452a, "state.getShowPosition() is %d", Integer.valueOf(next.m40460a()));
            if (i11 == next.m40460a()) {
                if (iM40459a == next.m40463b()) {
                    if (strM48224c.equalsIgnoreCase(new Locale(next.m40466c()).getLanguage())) {
                        strM40468d = next.m40468d();
                        break;
                    }
                    if (1 == next.m40469e()) {
                        strM40468d2 = next.m40468d();
                    }
                }
                if (next.m40463b() == 0) {
                    strM40468d3 = next.m40468d();
                }
            }
        }
        if (!TextUtils.isEmpty(strM40468d)) {
            strM40468d2 = strM40468d;
        }
        if (!TextUtils.isEmpty(strM40468d2)) {
            strM40468d3 = strM40468d2;
        }
        return AbstractC7806cz.m48168c(strM40468d3);
    }

    /* renamed from: b */
    private void m48665b(AppDownloadTask appDownloadTask, Context context) {
        if (appDownloadTask != null && (AbstractC7731ae.m47458b(appDownloadTask.m42068d()) || appDownloadTask.m42231K() || "11".equals(appDownloadTask.m42228H()))) {
            m48652a(context, this.f36276o, AppStatus.INSTALLING);
            return;
        }
        int i10 = this.f36276o;
        AppStatus appStatus = AppStatus.DOWNLOAD;
        m48652a(context, i10, appStatus);
        this.f36271j = appStatus;
        C7046e.m42377h().m42396a(this.f36266e);
    }

    /* renamed from: e */
    private void m48675e(AppDownloadTask appDownloadTask) {
        AbstractC7185ho.m43817a(((AbstractViewOnClickListenerC8065a) this).f37452a, "installApk");
        ContentRecord contentRecordMo46574a = appDownloadTask.m42223C().mo46574a();
        if (contentRecordMo46574a == null) {
            AbstractC7185ho.m43820b(((AbstractViewOnClickListenerC8065a) this).f37452a, "contentRecord is null! continue install.");
            m48676f(appDownloadTask);
            return;
        }
        if (C7755bb.m47705a(appDownloadTask, getContext())) {
            if (AbstractC7811dd.m48339o(getContext())) {
                AbstractC7185ho.m43820b(((AbstractViewOnClickListenerC8065a) this).f37452a, "start InstallAuthorActivity!");
                m48658a(contentRecordMo46574a);
                if (contentRecordMo46574a.m41484af().m44348E() == 1) {
                    appDownloadTask.m42054a(EnumC7062e.DOWNLOADED);
                    mo42628b(appDownloadTask);
                    return;
                }
            } else if (AbstractC7558os.m46456D(contentRecordMo46574a.m41427W())) {
                AbstractC7185ho.m43820b(((AbstractViewOnClickListenerC8065a) this).f37452a, "app is background, stop install!");
                appDownloadTask.m42054a(EnumC7062e.DOWNLOADED);
                mo42628b(appDownloadTask);
                return;
            }
        }
        m48676f(appDownloadTask);
    }

    @Override // com.huawei.openalliance.p169ad.download.InterfaceC7069l
    /* renamed from: c */
    public void mo42630c(String str) {
        if (AbstractC7185ho.m43819a()) {
            String str2 = ((AbstractViewOnClickListenerC8065a) this).f37452a;
            Object[] objArr = new Object[2];
            objArr[0] = str;
            AppInfo appInfo = this.f36266e;
            objArr[1] = appInfo == null ? null : appInfo.getPackageName();
            AbstractC7185ho.m43818a(str2, "onStatusChanged, packageName:%s, packageName:%s", objArr);
        }
        AppInfo appInfo2 = this.f36266e;
        if (appInfo2 == null || !appInfo2.getPackageName().equals(str)) {
            return;
        }
        m48643G();
    }

    /* renamed from: d */
    public boolean m48708d() {
        return this.f36252D;
    }

    @OuterVisible
    public AppDownloadButton(Context context, Boolean bool) {
        super(context, bool);
        this.f36271j = AppStatus.DOWNLOAD;
        this.f36273l = -1;
        this.f36275n = true;
        this.f36276o = 1;
        this.f36278q = false;
        this.f36279r = 2;
        this.f36285x = true;
        this.f36251C = true;
        this.f36252D = false;
        this.f36254F = false;
        this.f36255G = -1;
        this.f36259K = false;
        m48653a(context, (AttributeSet) null, -1, -1);
    }

    /* renamed from: a */
    private String m48650a(Context context, AppStatus appStatus) {
        int i10;
        if (context == null || appStatus == null || this.f36266e == null) {
            return "";
        }
        int i11 = C78662.f36291b[appStatus.ordinal()];
        if (i11 == 1) {
            AppInfo appInfo = this.f36266e;
            return C7831j.m48454a(context, appInfo, C7831j.m48459a(appInfo, Boolean.valueOf(getAutoOpenInLandingPage())));
        }
        if (i11 == 3) {
            i10 = C6849R.string.hiad_download_resume;
        } else if (i11 != 4) {
            if (i11 == 5) {
                return C7831j.m48452a(context, this.f36266e, this.f36255G);
            }
            if (i11 == 6) {
                i10 = C6849R.string.hiad_download_install;
            } else {
                if (i11 != 7) {
                    return null;
                }
                i10 = C6849R.string.hiad_download_installing;
            }
        } else {
            if (this.f36276o != 11) {
                return NumberFormat.getPercentInstance().format((this.f36273l * 1.0f) / 100.0f);
            }
            i10 = C6849R.string.hiad_download_downloading;
        }
        return context.getString(i10);
    }

    @OuterVisible
    public AppDownloadButton(Context context, Boolean bool, IProgressButton iProgressButton) {
        super(context, bool, iProgressButton);
        this.f36271j = AppStatus.DOWNLOAD;
        this.f36273l = -1;
        this.f36275n = true;
        this.f36276o = 1;
        this.f36278q = false;
        this.f36279r = 2;
        this.f36285x = true;
        this.f36251C = true;
        this.f36252D = false;
        this.f36254F = false;
        this.f36255G = -1;
        this.f36259K = false;
        m48653a(context, (AttributeSet) null, -1, -1);
    }

    /* renamed from: a */
    public void m48701a() {
        if (m48685k()) {
            C7055l.m42501b(getContext(), this.f36266e);
            OnDownloadStatusChangedListener onDownloadStatusChangedListener = this.f36268g;
            if (onDownloadStatusChangedListener != null) {
                onDownloadStatusChangedListener.onUserCancel(this.f36266e);
            }
        }
    }

    @OuterVisible
    public AppDownloadButton(Context context, Boolean bool, IProgressButton iProgressButton, ImageView imageView) {
        super(context, bool, iProgressButton, imageView);
        this.f36271j = AppStatus.DOWNLOAD;
        this.f36273l = -1;
        this.f36275n = true;
        this.f36276o = 1;
        this.f36278q = false;
        this.f36279r = 2;
        this.f36285x = true;
        this.f36251C = true;
        this.f36252D = false;
        this.f36254F = false;
        this.f36255G = -1;
        this.f36259K = false;
        m48653a(context, (AttributeSet) null, -1, -1);
    }

    /* renamed from: a */
    private void m48651a(Context context) {
        m48652a(context, this.f36276o, AppStatus.INSTALLED);
    }

    @Override // com.huawei.openalliance.p169ad.download.InterfaceC7069l
    /* renamed from: b */
    public void mo42629b(String str) {
        mo42627a(str);
    }

    /* renamed from: a */
    private void m48652a(Context context, int i10, AppStatus appStatus) {
        String strM48649a = m48649a(i10, appStatus);
        if (TextUtils.isEmpty(strM48649a)) {
            m48704a((CharSequence) m48650a(context, appStatus), true);
            return;
        }
        if (this.f36259K && i10 == 1 && appStatus == AppStatus.DOWNLOADING) {
            strM48649a = strM48649a + NumberFormat.getPercentInstance().format((this.f36273l * 1.0f) / 100.0f);
        }
        m48704a((CharSequence) strM48649a, false);
    }

    /* renamed from: b */
    public void m48668b(boolean z10) {
        if (!C7775bv.m47831e(getContext())) {
            Toast.makeText(getContext(), C6849R.string.hiad_network_no_available, 0).show();
            AppDownloadListenerV1 appDownloadListenerV1 = this.f36257I;
            if (appDownloadListenerV1 != null) {
                appDownloadListenerV1.onNewStatusChanged(AppStatusV1.PRE_CHECK_FAILED, 1004, this.f36266e);
                return;
            }
            return;
        }
        if (this.f36266e.m44435w() && this.f36275n && z10) {
            C7049h.m42420a(getContext(), this.f36266e, new C7049h.a() { // from class: com.huawei.openalliance.ad.views.AppDownloadButton.5
                public C78695() {
                }

                @Override // com.huawei.openalliance.p169ad.download.app.C7049h.a
                /* renamed from: a */
                public void mo42425a() {
                    AppDownloadButton.this.setNeedShowConfirmDialog(false);
                    AppDownloadButton.this.m48640D();
                }

                @Override // com.huawei.openalliance.p169ad.download.app.C7049h.a
                /* renamed from: a */
                public void mo42426a(int i10) {
                    if (AppDownloadButton.this.f36257I != null) {
                        AppDownloadButton.this.f36257I.onNewStatusChanged(AppStatusV1.PRE_CHECK_FAILED, i10, AppDownloadButton.this.f36266e);
                    }
                }
            });
        } else {
            m48640D();
        }
    }

    /* renamed from: a */
    private void m48653a(Context context, AttributeSet attributeSet, int i10, int i11) {
        try {
            super.setPadding(0, 0, 0, 0);
            ((AbstractViewOnClickListenerC8065a) this).f37453b = new AppDownloadButtonStyle(context);
            setOnClickListener(this);
            setCancelBtnClickListener(new ViewOnClickListenerC7876c(this));
            this.f36249A = new C7877d(this);
            C7046e.m42359a(context.getApplicationContext());
            C7050i.m42430a(context);
            this.f36257I = C7046e.m42377h().m42409i();
        } catch (Throwable unused) {
            AbstractC7185ho.m43823c(((AbstractViewOnClickListenerC8065a) this).f37452a, "AppDownloadButton init failed");
        }
    }

    /* renamed from: a */
    private void m48654a(Context context, C7560ou c7560ou) {
        AppInfo appInfo;
        if (this.f36274m != null && (appInfo = this.f36266e) != null && !TextUtils.isEmpty(appInfo.getUniqueId())) {
            this.f36274m.m41612v(this.f36266e.getUniqueId());
        }
        boolean zMo47233a = new C7677sz(context, this.f36274m).mo47233a();
        AbstractC7185ho.m43821b(((AbstractViewOnClickListenerC8065a) this).f37452a, "handle harmony click, ret: %s", Boolean.valueOf(zMo47233a));
        if (zMo47233a) {
            m48638B();
            C7587b.a aVarM48674e = m48674e(ClickDestination.HARMONY_APP);
            c7560ou.mo46594a(aVarM48674e.m46918a());
            C7560ou c7560ou2 = this.f36263O;
            if (c7560ou2 != null) {
                c7560ou2.mo46594a(aVarM48674e.m46918a());
            }
            InterfaceC7342jp interfaceC7342jp = this.f36264P;
            if (interfaceC7342jp != null) {
                interfaceC7342jp.mo45351a();
            }
            m48645I();
            this.f36258J = null;
            m48639C();
        }
    }

    /* renamed from: a */
    private void m48655a(Context context, C7560ou c7560ou, C7587b.a aVar) {
        m48656a(context, c7560ou, aVar, true);
    }

    /* renamed from: a */
    private void m48656a(Context context, C7560ou c7560ou, C7587b.a aVar, boolean z10) {
        C7055l.m42499a(context, this.f36266e);
        if (z10) {
            c7560ou.mo46588a(EventType.INTENTSUCCESS, Integer.valueOf(C7831j.m48462b(this.f36266e.getPackageName(), this.f36266e)), (Integer) null);
        }
        m48638B();
        c7560ou.mo46594a(aVar.m46918a());
        C7560ou c7560ou2 = this.f36263O;
        if (c7560ou2 != null) {
            c7560ou2.mo46594a(aVar.m46918a());
        }
        InterfaceC7342jp interfaceC7342jp = this.f36264P;
        if (interfaceC7342jp != null) {
            interfaceC7342jp.mo45351a();
        }
        m48645I();
        this.f36258J = null;
        m48639C();
    }

    /* renamed from: a */
    private void m48657a(Context context, String str, C7560ou c7560ou) {
        C7587b.a aVarM48674e = m48674e(C7831j.m48455a(str, this.f36266e));
        AbstractC7687ti abstractC7687tiM48664b = m48664b(context);
        if ((abstractC7687tiM48664b instanceof C7675sx) && abstractC7687tiM48664b.mo47233a()) {
            AbstractC7185ho.m43820b(((AbstractViewOnClickListenerC8065a) this).f37452a, "open fast app via sdk.");
            m48656a(context, c7560ou, aVarM48674e, false);
            return;
        }
        C7692tn.a aVar = new C7692tn.a();
        aVar.m47275a(this.f36266e).m47279c(str).m47274a(this.f36274m);
        boolean zM48421a = C7830i.m48421a(context, str, this.f36266e.getIntentUri(), aVar.m47277a());
        AbstractC7185ho.m43821b(((AbstractViewOnClickListenerC8065a) this).f37452a, "handle android click, ret: %s", Boolean.valueOf(zM48421a));
        if (zM48421a) {
            m48655a(context, c7560ou, aVarM48674e);
            return;
        }
        AbstractC7185ho.m43820b(((AbstractViewOnClickListenerC8065a) this).f37452a, "handleClick, openAppIntent failed");
        c7560ou.mo46588a(EventType.INTENTFAIL, Integer.valueOf(C7831j.m48462b(str, this.f36266e)), Integer.valueOf(C7830i.m48419a(context, str) ? 2 : 1));
        if (!C7830i.m48420a(context, str, aVar.m47277a())) {
            AbstractC7185ho.m43820b(((AbstractViewOnClickListenerC8065a) this).f37452a, "handleClick, openAppMainPage failed");
            return;
        }
        c7560ou.mo46595a(Integer.valueOf(this.f36276o));
        C7055l.m42499a(context, this.f36266e);
        m48638B();
        c7560ou.mo46594a(aVarM48674e.m46918a());
        C7560ou c7560ou2 = this.f36263O;
        if (c7560ou2 != null) {
            c7560ou2.mo46594a(aVarM48674e.m46918a());
        }
        InterfaceC7342jp interfaceC7342jp = this.f36264P;
        if (interfaceC7342jp != null) {
            interfaceC7342jp.mo45351a();
        }
        m48645I();
        this.f36258J = null;
        m48639C();
    }

    /* renamed from: a */
    private void m48658a(ContentRecord contentRecord) {
        AbstractC7185ho.m43820b(((AbstractViewOnClickListenerC8065a) this).f37452a, "startInstallAuthorActivity");
        Intent intent = new Intent(getContext(), (Class<?>) PPSInstallAuthorActivity.class);
        intent.setFlags(805306368);
        intent.putExtra(Constants.CONTENT_KEY, AbstractC7758be.m47742b(contentRecord));
        PPSInstallAuthorActivity.m38726a(new InterfaceC8114g() { // from class: com.huawei.openalliance.ad.views.AppDownloadButton.4
            public C78684() {
            }

            @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8114g
            /* renamed from: a */
            public void mo42335a(AppDownloadTask appDownloadTask) {
                if (appDownloadTask != null) {
                    AppDownloadButton.this.m48676f(appDownloadTask);
                }
            }
        });
        intent.setClipData(Constants.CLIP_DATA);
        getContext().startActivity(intent);
    }

    @Override // com.huawei.openalliance.p169ad.download.InterfaceC7069l
    /* renamed from: a */
    public void mo42626a(AppDownloadTask appDownloadTask) {
        if (AbstractC7185ho.m43819a()) {
            String str = ((AbstractViewOnClickListenerC8065a) this).f37452a;
            Object[] objArr = new Object[3];
            objArr[0] = appDownloadTask.mo42082n();
            AppInfo appInfo = this.f36266e;
            objArr[1] = appInfo == null ? null : appInfo.getPackageName();
            objArr[2] = Integer.valueOf(appDownloadTask.m42080l());
            AbstractC7185ho.m43818a(str, "onProgressChanged, taskId:%s, packageName:%s, progress:%s", objArr);
        }
        AppInfo appInfo2 = this.f36266e;
        if (appInfo2 == null || !appInfo2.getPackageName().equals(appDownloadTask.mo42082n())) {
            return;
        }
        m48643G();
    }

    /* renamed from: a */
    private void m48659a(AppDownloadTask appDownloadTask, Context context) {
        if (appDownloadTask != null && (AbstractC7731ae.m47458b(appDownloadTask.m42068d()) || appDownloadTask.m42231K())) {
            m48652a(context, this.f36276o, AppStatus.INSTALL);
            return;
        }
        int i10 = this.f36276o;
        AppStatus appStatus = AppStatus.DOWNLOAD;
        m48652a(context, i10, appStatus);
        this.f36271j = appStatus;
        C7046e.m42377h().m42396a(this.f36266e);
    }

    /* renamed from: a */
    public void m48702a(MaterialClickInfo materialClickInfo) {
        this.f36258J = materialClickInfo;
    }

    /* renamed from: a */
    public void m48703a(InterfaceC7875b interfaceC7875b) {
        this.f36260L = interfaceC7875b;
    }

    /* renamed from: a */
    public void m48704a(CharSequence charSequence, boolean z10) {
        InterfaceC7878e interfaceC7878e = this.f36270i;
        if (interfaceC7878e != null && z10) {
            charSequence = interfaceC7878e.mo30554a(charSequence, this.f36271j);
        }
        super.setText(charSequence);
    }

    @Override // com.huawei.openalliance.p169ad.download.InterfaceC7069l
    /* renamed from: a */
    public void mo42627a(String str) {
        AppInfo appInfo = this.f36266e;
        if (appInfo == null || str == null || !str.equals(appInfo.getPackageName())) {
            return;
        }
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.AppDownloadButton.10
            public RunnableC786510() {
            }

            @Override // java.lang.Runnable
            public void run() {
                AppDownloadButton.this.refreshStatus();
                if (AppDownloadButton.this.f36268g != null) {
                    AppDownloadButton.this.f36268g.onStatusChanged(AppDownloadButton.this.f36271j);
                }
            }
        });
    }

    @Override // com.huawei.openalliance.p169ad.download.InterfaceC7068k
    /* renamed from: a */
    public void mo38799a(String str, int i10) {
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a(((AbstractViewOnClickListenerC8065a) this).f37452a, "status %s, packageName:%s", Integer.valueOf(i10), str);
        }
        if (C7831j.m48458a(this.f36266e)) {
            AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.AppDownloadButton.9

                /* renamed from: a */
                final /* synthetic */ int f36298a;

                public RunnableC78739(int i102) {
                    i = i102;
                }

                @Override // java.lang.Runnable
                public void run() {
                    AppDownloadButton.this.f36255G = i;
                    AppDownloadButton.this.refreshStatus();
                }
            });
        }
    }

    /* renamed from: a */
    private boolean m48663a(boolean z10) {
        AppDownloadListenerV1 appDownloadListenerV1;
        if (getStatus() == AppStatus.DOWNLOAD && (appDownloadListenerV1 = this.f36257I) != null) {
            appDownloadListenerV1.onNewStatusChanged(AppStatusV1.FIRST_CLICK_BUTTON, 1000, this.f36266e);
        }
        AppInfo appInfo = this.f36266e;
        if (appInfo != null && !z10) {
            return false;
        }
        AppDownloadListenerV1 appDownloadListenerV12 = this.f36257I;
        if (appDownloadListenerV12 != null) {
            appDownloadListenerV12.onNewStatusChanged(AppStatusV1.PRE_CHECK_FAILED, 1002, appInfo);
        }
        AbstractC7185ho.m43820b(((AbstractViewOnClickListenerC8065a) this).f37452a, "cancel download");
        return true;
    }
}
