package com.huawei.openalliance.p169ad.activity;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.widget.PopupMenu;
import android.widget.Toast;
import com.huawei.openalliance.p169ad.AbstractC7014dc;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.AbstractC7558os;
import com.huawei.openalliance.p169ad.AbstractC7572pf;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.C6982bz;
import com.huawei.openalliance.p169ad.C6985cb;
import com.huawei.openalliance.p169ad.C7161gr;
import com.huawei.openalliance.p169ad.C7162gs;
import com.huawei.openalliance.p169ad.C7169gz;
import com.huawei.openalliance.p169ad.C7171ha;
import com.huawei.openalliance.p169ad.C7517nl;
import com.huawei.openalliance.p169ad.InterfaceC7146gc;
import com.huawei.openalliance.p169ad.InterfaceC7176hf;
import com.huawei.openalliance.p169ad.activity.AbstractActivityC6902b;
import com.huawei.openalliance.p169ad.analysis.C6928i;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import com.huawei.openalliance.p169ad.download.app.AppStatus;
import com.huawei.openalliance.p169ad.download.app.C7049h;
import com.huawei.openalliance.p169ad.inter.HiAd;
import com.huawei.openalliance.p169ad.inter.data.AdLandingPageData;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.inter.data.IAd;
import com.huawei.openalliance.p169ad.inter.data.LinkedSplashAd;
import com.huawei.openalliance.p169ad.linked.view.C7398c;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7810dc;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import com.huawei.openalliance.p169ad.utils.C7747au;
import com.huawei.openalliance.p169ad.utils.C7748av;
import com.huawei.openalliance.p169ad.utils.C7749aw;
import com.huawei.openalliance.p169ad.utils.C7818dk;
import com.huawei.openalliance.p169ad.views.AppDownloadButton;
import com.huawei.openalliance.p169ad.views.C8067ab;
import com.huawei.openalliance.p169ad.views.C8150t;
import com.huawei.openalliance.p169ad.views.PPSAppDetailView;
import com.huawei.openalliance.p169ad.views.PPSExpandButtonDetailView;
import com.huawei.openalliance.p169ad.views.PPSWebView;
import com.huawei.openalliance.p169ad.views.VideoView;
import com.huawei.openalliance.p169ad.views.ViewOnClickListenerC8081d;
import com.huawei.openalliance.p169ad.views.interfaces.C8109b;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8107aa;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8110c;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8133z;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.concurrent.Callable;

@OuterVisible
/* loaded from: classes8.dex */
public class PPSActivity extends AbstractActivityC6902b implements ViewOnClickListenerC8081d.a {

    /* renamed from: a */
    C7169gz f31677a;

    /* renamed from: b */
    private PPSWebView f31678b;

    /* renamed from: c */
    private C7161gr f31679c;

    /* renamed from: d */
    private ActionBar f31680d;

    /* renamed from: e */
    private AdLandingPageData f31681e;

    /* renamed from: f */
    private ClipboardManager f31682f;

    /* renamed from: g */
    private InterfaceC7146gc f31683g;

    /* renamed from: h */
    private Boolean f31684h;

    /* renamed from: i */
    private PopupMenu f31685i;

    /* renamed from: j */
    private PPSAppDetailView f31686j;

    /* renamed from: k */
    private Integer f31687k;

    /* renamed from: l */
    private PPSExpandButtonDetailView f31688l;

    /* renamed from: m */
    private AppInfo f31689m;

    /* renamed from: n */
    private AbstractActivityC6902b.a f31690n;

    /* renamed from: o */
    private Handler f31691o;

    /* renamed from: q */
    private C7748av f31692q;

    /* renamed from: r */
    private C8150t f31693r;

    /* renamed from: t */
    private AppDownloadButton f31695t;

    /* renamed from: u */
    private C7749aw f31696u;

    /* renamed from: v */
    private long f31697v;

    /* renamed from: y */
    private boolean f31700y;

    /* renamed from: z */
    private C7398c f31701z;

    /* renamed from: s */
    private boolean f31694s = false;

    /* renamed from: w */
    private InterfaceC8133z f31698w = new InterfaceC8133z() { // from class: com.huawei.openalliance.ad.activity.PPSActivity.1

        /* renamed from: com.huawei.openalliance.ad.activity.PPSActivity$1$1 */
        public class AnonymousClass1 implements Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PPSActivity.this.m38656a(true);
            }
        }

        /* renamed from: com.huawei.openalliance.ad.activity.PPSActivity$1$2 */
        public class AnonymousClass2 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ int f31704a;

            public AnonymousClass2(int i10) {
                i = i10;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (i == 100) {
                    PPSActivity.this.m38656a(false);
                }
            }
        }

        public C68691() {
        }

        @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8133z
        /* renamed from: a */
        public void mo38700a() {
            AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.activity.PPSActivity.1.1
                public AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    PPSActivity.this.m38656a(true);
                }
            });
        }

        @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8133z
        /* renamed from: a */
        public void mo38701a(int i10) {
            AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.activity.PPSActivity.1.2

                /* renamed from: a */
                final /* synthetic */ int f31704a;

                public AnonymousClass2(int i102) {
                    i = i102;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (i == 100) {
                        PPSActivity.this.m38656a(false);
                    }
                }
            });
        }
    };

    /* renamed from: x */
    private InterfaceC8110c f31699x = new InterfaceC8110c() { // from class: com.huawei.openalliance.ad.activity.PPSActivity.5

        /* renamed from: com.huawei.openalliance.ad.activity.PPSActivity$5$1 */
        public class AnonymousClass1 implements Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PPSActivity.this.m38656a(true);
            }
        }

        public C68765() {
        }

        @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8110c
        /* renamed from: a */
        public void mo38703a(C8109b c8109b) {
            if (c8109b == null || c8109b.m50306e() == null) {
                AbstractC7185ho.m43823c("PPSActivity", "click action invalid");
                return;
            }
            Integer numM50306e = c8109b.m50306e();
            int iIntValue = numM50306e.intValue();
            AbstractC7185ho.m43821b("PPSActivity", "click action: %d", numM50306e);
            if (iIntValue != 1) {
                return;
            }
            AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.activity.PPSActivity.5.1
                public AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    PPSActivity.this.m38656a(true);
                }
            });
        }
    };

    /* renamed from: com.huawei.openalliance.ad.activity.PPSActivity$1 */
    public class C68691 implements InterfaceC8133z {

        /* renamed from: com.huawei.openalliance.ad.activity.PPSActivity$1$1 */
        public class AnonymousClass1 implements Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PPSActivity.this.m38656a(true);
            }
        }

        /* renamed from: com.huawei.openalliance.ad.activity.PPSActivity$1$2 */
        public class AnonymousClass2 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ int f31704a;

            public AnonymousClass2(int i102) {
                i = i102;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (i == 100) {
                    PPSActivity.this.m38656a(false);
                }
            }
        }

        public C68691() {
        }

        @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8133z
        /* renamed from: a */
        public void mo38700a() {
            AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.activity.PPSActivity.1.1
                public AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    PPSActivity.this.m38656a(true);
                }
            });
        }

        @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8133z
        /* renamed from: a */
        public void mo38701a(int i102) {
            AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.activity.PPSActivity.1.2

                /* renamed from: a */
                final /* synthetic */ int f31704a;

                public AnonymousClass2(int i1022) {
                    i = i1022;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (i == 100) {
                        PPSActivity.this.m38656a(false);
                    }
                }
            });
        }
    }

    /* renamed from: com.huawei.openalliance.ad.activity.PPSActivity$10 */
    public class DialogInterfaceOnCancelListenerC687010 implements DialogInterface.OnCancelListener {
        public DialogInterfaceOnCancelListenerC687010() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            PPSActivity.this.f31694s = false;
            PPSActivity.this.f31693r = null;
            PPSActivity.this.m38663b("130");
        }
    }

    /* renamed from: com.huawei.openalliance.ad.activity.PPSActivity$11 */
    public class ViewOnScrollChangeListenerC687111 implements View.OnScrollChangeListener {
        public ViewOnScrollChangeListenerC687111() {
        }

        @Override // android.view.View.OnScrollChangeListener
        public void onScrollChange(View view, int i10, int i11, int i12, int i13) {
            if (PPSActivity.this.m38636A() || !PPSActivity.this.m38688q()) {
                return;
            }
            if (PPSActivity.this.f31688l != null && PPSActivity.this.m38675g()) {
                PPSActivity.this.f31688l.m48965c();
            }
            if (PPSActivity.this.f31686j == null || PPSActivity.this.m38675g()) {
                return;
            }
            PPSActivity.this.f31686j.m48965c();
        }
    }

    /* renamed from: com.huawei.openalliance.ad.activity.PPSActivity$12 */
    public class CallableC687212 implements Callable<Boolean> {
        public CallableC687212() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() {
            return Boolean.valueOf(PPSActivity.this.f31683g.mo43351aR());
        }
    }

    /* renamed from: com.huawei.openalliance.ad.activity.PPSActivity$2 */
    public class RunnableC68732 implements Runnable {
        public RunnableC68732() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC7185ho.m43820b("PPSActivity", "finishSelfDelayed");
            PPSActivity.this.finish();
        }
    }

    /* renamed from: com.huawei.openalliance.ad.activity.PPSActivity$3 */
    public class DialogInterfaceOnClickListenerC68743 implements DialogInterface.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ int f31710a;

        public DialogInterfaceOnClickListenerC68743(int i10) {
            i = i10;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            dialogInterface.dismiss();
            if (PPSActivity.this.f31692q != null) {
                int i11 = i;
                C7748av c7748av = PPSActivity.this.f31692q;
                if (i11 == 11) {
                    c7748av.m47645a(false, true);
                } else {
                    c7748av.m47647b(false, true);
                }
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.activity.PPSActivity$4 */
    public class DialogInterfaceOnClickListenerC68754 implements DialogInterface.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ int f31712a;

        public DialogInterfaceOnClickListenerC68754(int i10) {
            i = i10;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            PPSActivity.this.m38697z();
            dialogInterface.dismiss();
            if (PPSActivity.this.f31692q != null) {
                int i11 = i;
                C7748av c7748av = PPSActivity.this.f31692q;
                if (i11 == 11) {
                    c7748av.m47645a(false, false);
                } else {
                    c7748av.m47647b(false, false);
                }
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.activity.PPSActivity$5 */
    public class C68765 implements InterfaceC8110c {

        /* renamed from: com.huawei.openalliance.ad.activity.PPSActivity$5$1 */
        public class AnonymousClass1 implements Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PPSActivity.this.m38656a(true);
            }
        }

        public C68765() {
        }

        @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8110c
        /* renamed from: a */
        public void mo38703a(C8109b c8109b) {
            if (c8109b == null || c8109b.m50306e() == null) {
                AbstractC7185ho.m43823c("PPSActivity", "click action invalid");
                return;
            }
            Integer numM50306e = c8109b.m50306e();
            int iIntValue = numM50306e.intValue();
            AbstractC7185ho.m43821b("PPSActivity", "click action: %d", numM50306e);
            if (iIntValue != 1) {
                return;
            }
            AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.activity.PPSActivity.5.1
                public AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    PPSActivity.this.m38656a(true);
                }
            });
        }
    }

    /* renamed from: com.huawei.openalliance.ad.activity.PPSActivity$6 */
    public class ViewOnClickListenerC68776 implements View.OnClickListener {
        public ViewOnClickListenerC68776() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PPSActivity.this.mo38699c();
        }
    }

    /* renamed from: com.huawei.openalliance.ad.activity.PPSActivity$7 */
    public class C68787 implements PopupMenu.OnMenuItemClickListener {
        public C68787() {
        }

        @Override // android.widget.PopupMenu.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            return PPSActivity.this.m38658a(menuItem);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.activity.PPSActivity$8 */
    public class C68798 implements InterfaceC6882b {
        public C68798() {
        }

        @Override // com.huawei.openalliance.p169ad.activity.PPSActivity.InterfaceC6882b
        /* renamed from: a */
        public void mo38704a(boolean z10) {
        }
    }

    /* renamed from: com.huawei.openalliance.ad.activity.PPSActivity$9 */
    public class C68809 implements InterfaceC8107aa {
        public C68809() {
        }

        @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8107aa
        /* renamed from: a */
        public void mo38705a() {
            PPSActivity.this.m38663b("128");
            PPSActivity.this.f31695t.setSource(5);
            PPSActivity.this.f31695t.m48702a(PPSActivity.this.f31693r.getClickInfo());
            PPSActivity.this.f31695t.performClick();
            PPSActivity.this.f31693r.m50512b();
            PPSActivity.this.f31693r = null;
            PPSActivity.this.f31694s = false;
        }

        @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8107aa
        /* renamed from: b */
        public void mo38706b() {
            PPSActivity.this.m38663b("129");
            PPSActivity.this.f31695t.m48710f();
            PPSActivity.this.f31693r.m50512b();
            PPSActivity.this.f31693r = null;
            PPSActivity.this.f31694s = false;
        }

        @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8107aa
        /* renamed from: c */
        public void mo38707c() {
        }
    }

    /* renamed from: com.huawei.openalliance.ad.activity.PPSActivity$a */
    public static class RunnableC6881a implements Runnable {

        /* renamed from: a */
        private WeakReference<PPSActivity> f31720a;

        public RunnableC6881a(PPSActivity pPSActivity) {
            this.f31720a = new WeakReference<>(pPSActivity);
        }

        @Override // java.lang.Runnable
        public void run() {
            PPSActivity pPSActivity = this.f31720a.get();
            if (pPSActivity == null) {
                return;
            }
            pPSActivity.m38656a(false);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.activity.PPSActivity$b */
    public interface InterfaceC6882b {
        /* renamed from: a */
        void mo38704a(boolean z10);
    }

    /* renamed from: A */
    public boolean m38636A() {
        if (System.currentTimeMillis() - this.f31697v < 500) {
            return true;
        }
        this.f31697v = System.currentTimeMillis();
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0083  */
    /* renamed from: B */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m38637B() {
        /*
            r6 = this;
            java.lang.String r0 = "resetLinkedNativeVideoView start"
            java.lang.String r1 = "PPSActivity"
            com.huawei.openalliance.p169ad.AbstractC7185ho.m43820b(r1, r0)
            com.huawei.openalliance.ad.gz r0 = r6.f31677a
            if (r0 == 0) goto La7
            com.huawei.openalliance.ad.beans.metadata.VideoInfo r0 = r0.m43651a()
            if (r0 == 0) goto La7
            com.huawei.openalliance.ad.gz r0 = r6.f31677a
            com.huawei.openalliance.ad.beans.metadata.VideoInfo r0 = r0.m43651a()
            java.lang.Float r0 = r0.m40500m()
            if (r0 != 0) goto L1f
            goto La7
        L1f:
            com.huawei.openalliance.ad.gz r0 = r6.f31677a
            com.huawei.openalliance.ad.beans.metadata.VideoInfo r0 = r0.m43651a()
            java.lang.Float r0 = r0.m40500m()
            int r2 = com.huawei.openalliance.p169ad.utils.AbstractC7807d.m48215b(r6)
            float r3 = r0.floatValue()
            r4 = 1065353216(0x3f800000, float:1.0)
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 < 0) goto L43
            boolean r6 = com.huawei.openalliance.p169ad.AbstractC7185ho.m43819a()
            if (r6 == 0) goto L42
            java.lang.String r6 = "no need resetLinkedNativeVideoView"
            com.huawei.openalliance.p169ad.AbstractC7185ho.m43817a(r1, r6)
        L42:
            return
        L43:
            com.huawei.openalliance.ad.gr r3 = r6.f31679c
            com.huawei.openalliance.ad.jk r3 = r3.m43617d()
            boolean r4 = com.huawei.openalliance.p169ad.AbstractC7185ho.m43819a()
            if (r4 == 0) goto L60
            java.lang.Class r4 = r3.getClass()
            java.lang.String r4 = r4.getSimpleName()
            java.lang.Object[] r4 = new java.lang.Object[]{r4}
            java.lang.String r5 = "iView is %s"
            com.huawei.openalliance.p169ad.AbstractC7185ho.m43818a(r1, r5, r4)
        L60:
            boolean r4 = r3 instanceof com.huawei.openalliance.p169ad.linked.view.C7398c
            if (r4 == 0) goto L83
            r4 = r3
            com.huawei.openalliance.ad.linked.view.c r4 = (com.huawei.openalliance.p169ad.linked.view.C7398c) r4
            com.huawei.openalliance.ad.hf r5 = r4.getLinkedNativeVideoView()
            if (r5 == 0) goto L83
            com.huawei.openalliance.ad.hf r3 = r4.getLinkedNativeVideoView()
            com.huawei.openalliance.ad.views.VideoView r0 = r6.m38639a(r3, r0, r2)
            r3.setVideoView(r0)
            com.huawei.openalliance.ad.gr r6 = r6.f31679c
            r6.m43614a(r3)
            java.lang.String r6 = "reset LinkedLandView end"
        L7f:
            com.huawei.openalliance.p169ad.AbstractC7185ho.m43820b(r1, r6)
            goto La6
        L83:
            boolean r4 = r3 instanceof com.huawei.openalliance.p169ad.linked.view.C7397b
            if (r4 == 0) goto L9b
            r4 = r3
            com.huawei.openalliance.ad.linked.view.b r4 = (com.huawei.openalliance.p169ad.linked.view.C7397b) r4
            com.huawei.openalliance.ad.hf r3 = (com.huawei.openalliance.p169ad.InterfaceC7176hf) r3
            com.huawei.openalliance.ad.views.VideoView r0 = r6.m38639a(r3, r0, r2)
            r4.setVideoView(r0)
            com.huawei.openalliance.ad.gr r6 = r6.f31679c
            r6.m43614a(r4)
            java.lang.String r6 = "reset ILinkedNativeView end"
            goto L7f
        L9b:
            boolean r6 = com.huawei.openalliance.p169ad.AbstractC7185ho.m43819a()
            if (r6 == 0) goto La6
            java.lang.String r6 = "not resetLinkedNativeVideoView"
            com.huawei.openalliance.p169ad.AbstractC7185ho.m43817a(r1, r6)
        La6:
            return
        La7:
            java.lang.String r6 = "getVideoInfo is null"
            com.huawei.openalliance.p169ad.AbstractC7185ho.m43820b(r1, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.activity.PPSActivity.m38637B():void");
    }

    /* renamed from: d */
    private void m38668d() {
        if (!m38672f()) {
            AbstractC7185ho.m43820b("PPSActivity", "do not auto download app");
            return;
        }
        AbstractC7185ho.m43820b("PPSActivity", "auto download app");
        AppDownloadButton appDownloadButton = this.f31695t;
        if (appDownloadButton == null) {
            AbstractC7185ho.m43823c("PPSActivity", "there is no download button");
            return;
        }
        if (AppStatus.DOWNLOAD == appDownloadButton.getStatus()) {
            m38671e();
            this.f31695t.performClick();
        }
    }

    /* renamed from: f */
    private boolean m38672f() {
        AdLandingPageData adLandingPageData = this.f31681e;
        return adLandingPageData != null && this.f31689m != null && adLandingPageData.m44304l() && AbstractC7558os.m46469h(this.f31681e.m44290f());
    }

    /* renamed from: j */
    private String m38680j() {
        return !this.f31681e.isShowPageTitle() ? " " : AbstractC7741ao.m47552a(this.f31681e) ? AbstractC7806cz.m48168c(this.f31681e.getAppInfo().getAppName()) : getString(C6849R.string.hiad_detail);
    }

    /* renamed from: k */
    private boolean m38682k() {
        AdLandingPageData adLandingPageData = this.f31681e;
        return (adLandingPageData == null || this.f31689m == null || TextUtils.isEmpty(adLandingPageData.m44313q())) ? false : true;
    }

    /* renamed from: l */
    private void m38683l() {
        ClipData clipDataNewPlainText = ClipData.newPlainText("text", this.f31681e.getLandingUrl());
        ClipboardManager clipboardManager = this.f31682f;
        if (clipboardManager != null) {
            clipboardManager.setPrimaryClip(clipDataNewPlainText);
            Toast.makeText(getApplicationContext(), C6849R.string.hiad_link_already_copied, 1).show();
        }
    }

    /* renamed from: m */
    private void m38684m() {
        PPSWebView pPSWebView = this.f31678b;
        if (pPSWebView != null) {
            pPSWebView.loadPage();
        }
    }

    /* renamed from: n */
    private void m38685n() {
        try {
            this.f31701z = new C7398c(this);
            C7162gs c7162gs = new C7162gs(this, this.f31681e, this.f31677a);
            PPSWebView pPSWebView = new PPSWebView(this, this.f31680d, this.f31681e, this, m38694w(), c7162gs.mo43629k() && !AbstractC7811dd.m48300a((Activity) this));
            this.f31678b = pPSWebView;
            pPSWebView.setPPSWebEventCallback(C7517nl.m46150a());
            m38654a(this.f31678b);
            C7161gr c7161gr = new C7161gr(c7162gs, this.f31701z, this.f31678b);
            this.f31679c = c7161gr;
            c7161gr.m43613a(new InterfaceC6882b() { // from class: com.huawei.openalliance.ad.activity.PPSActivity.8
                public C68798() {
                }

                @Override // com.huawei.openalliance.p169ad.activity.PPSActivity.InterfaceC6882b
                /* renamed from: a */
                public void mo38704a(boolean z10) {
                }
            });
            ((ViewGroup) findViewById(C6849R.id.hiad_landing_webview_layout)).addView(this.f31679c.m43611a(this));
        } catch (Throwable th2) {
            AbstractC7185ho.m43823c("PPSActivity", "init webview failed " + th2.getClass().getSimpleName());
        }
        boolean zM38677h = m38677h();
        this.f31700y = zM38677h;
        this.f31686j = zM38677h ? this.f31678b.getTopDetailView() : (PPSAppDetailView) findViewById(C6849R.id.hiad_landing_app_detail);
        this.f31688l = (PPSExpandButtonDetailView) findViewById(C6849R.id.hiad_landing_expand_button_detail);
        AbstractC7185ho.m43820b("PPSActivity", "ctrlSwitchs:" + this.f31681e.m44290f());
        m38691t();
        Resources resources = getResources();
        if (resources != null) {
            if (resources.getConfiguration() != null) {
                this.f31687k = Integer.valueOf(resources.getConfiguration().screenWidthDp);
            }
            onConfigurationChanged(resources.getConfiguration());
        }
    }

    /* renamed from: o */
    private void m38686o() {
        if (AbstractC7558os.m46454B(this.f31681e.m44290f()) != 2) {
            AbstractC7185ho.m43818a("PPSActivity", "no need popup strategy %s.", Integer.valueOf(AbstractC7558os.m46454B(this.f31681e.m44290f())));
            return;
        }
        if (this.f31689m == null || this.f31681e.m44307n() == null) {
            AbstractC7185ho.m43817a("PPSActivity", "app or pageType para error.");
            return;
        }
        if (m38672f()) {
            AbstractC7185ho.m43817a("PPSActivity", "no need popup auto download.");
            return;
        }
        if (!"1".equals(this.f31681e.m44307n()) && !"2".equals(this.f31681e.m44307n())) {
            AbstractC7185ho.m43817a("PPSActivity", "landing type no need pop.");
            return;
        }
        long jM44346D = this.f31689m.m44346D();
        if (jM44346D < 0) {
            AbstractC7185ho.m43824c("PPSActivity", "delay time error:%s", Long.valueOf(jM44346D));
        } else {
            AbstractC7185ho.m43821b("PPSActivity", "show app download dialog start delayTime %s", Long.valueOf(jM44346D));
            AbstractC7817dj.m48364a(new RunnableC6881a(this), jM44346D);
        }
    }

    /* renamed from: p */
    private void m38687p() {
        if (this.f31693r == null) {
            C8150t c8150t = new C8150t(this, 0);
            this.f31693r = c8150t;
            c8150t.setPopUpClickListener(new InterfaceC8107aa() { // from class: com.huawei.openalliance.ad.activity.PPSActivity.9
                public C68809() {
                }

                @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8107aa
                /* renamed from: a */
                public void mo38705a() {
                    PPSActivity.this.m38663b("128");
                    PPSActivity.this.f31695t.setSource(5);
                    PPSActivity.this.f31695t.m48702a(PPSActivity.this.f31693r.getClickInfo());
                    PPSActivity.this.f31695t.performClick();
                    PPSActivity.this.f31693r.m50512b();
                    PPSActivity.this.f31693r = null;
                    PPSActivity.this.f31694s = false;
                }

                @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8107aa
                /* renamed from: b */
                public void mo38706b() {
                    PPSActivity.this.m38663b("129");
                    PPSActivity.this.f31695t.m48710f();
                    PPSActivity.this.f31693r.m50512b();
                    PPSActivity.this.f31693r = null;
                    PPSActivity.this.f31694s = false;
                }

                @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8107aa
                /* renamed from: c */
                public void mo38707c() {
                }
            });
            this.f31693r.getDialog().setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.huawei.openalliance.ad.activity.PPSActivity.10
                public DialogInterfaceOnCancelListenerC687010() {
                }

                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    PPSActivity.this.f31694s = false;
                    PPSActivity.this.f31693r = null;
                    PPSActivity.this.m38663b("130");
                }
            });
        }
    }

    /* renamed from: q */
    public boolean m38688q() {
        return m38690s() && !AbstractC7558os.m46484w(this.f31681e.m44290f());
    }

    /* renamed from: r */
    private boolean m38689r() {
        return m38690s() && AbstractC7558os.m46485x(this.f31681e.m44290f());
    }

    /* renamed from: s */
    private boolean m38690s() {
        AppDownloadButton appDownloadButton;
        if (this.f31681e == null || (appDownloadButton = this.f31695t) == null) {
            return false;
        }
        AppStatus status = appDownloadButton.getStatus();
        if (status == AppStatus.DOWNLOAD || status == AppStatus.INSTALLED) {
            return true;
        }
        AbstractC7185ho.m43817a("PPSActivity", "current app status not support scan animation.");
        return false;
    }

    /* renamed from: t */
    private void m38691t() {
        PPSAppDetailView pPSAppDetailView = (this.f31700y || !m38675g()) ? this.f31686j : this.f31688l;
        m38652a(pPSAppDetailView);
        m38662b(this.f31695t);
        if (this.f31700y) {
            m38652a((PPSAppDetailView) this.f31688l);
            this.f31688l.mo48958a(2);
            this.f31688l.setBtnSource(61);
            this.f31688l.setNonBtnSource(61);
            pPSAppDetailView.setBtnSource(59);
            pPSAppDetailView.setNonBtnSource(60);
        }
    }

    /* renamed from: u */
    private boolean m38692u() {
        AdLandingPageData adLandingPageData;
        if (isFinishing() || (adLandingPageData = this.f31681e) == null) {
            return false;
        }
        return AbstractC7558os.m46479r(adLandingPageData.m44290f());
    }

    /* renamed from: v */
    private boolean m38693v() {
        return !m38657a((Context) this);
    }

    /* renamed from: w */
    private boolean m38694w() {
        if (this.f31684h == null) {
            this.f31684h = (Boolean) AbstractC7810dc.m48269a(new Callable<Boolean>() { // from class: com.huawei.openalliance.ad.activity.PPSActivity.12
                public CallableC687212() {
                }

                @Override // java.util.concurrent.Callable
                /* renamed from: a */
                public Boolean call() {
                    return Boolean.valueOf(PPSActivity.this.f31683g.mo43351aR());
                }
            }, Boolean.FALSE);
        }
        return this.f31684h.booleanValue();
    }

    /* renamed from: x */
    private void m38695x() {
        PPSWebView pPSWebView = this.f31678b;
        if (pPSWebView != null) {
            pPSWebView.destroy();
        }
        PPSAppDetailView pPSAppDetailView = this.f31686j;
        if (pPSAppDetailView != null) {
            pPSAppDetailView.m48966d();
            this.f31686j = null;
        }
        PPSExpandButtonDetailView pPSExpandButtonDetailView = this.f31688l;
        if (pPSExpandButtonDetailView != null) {
            pPSExpandButtonDetailView.m48966d();
            this.f31688l = null;
        }
    }

    /* renamed from: y */
    private void m38696y() {
        C7161gr c7161gr = this.f31679c;
        if (c7161gr != null) {
            c7161gr.m43612a();
        }
    }

    /* renamed from: z */
    public void m38697z() {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", getPackageName(), null));
        startActivity(intent);
    }

    @Override // com.huawei.openalliance.p169ad.views.ViewOnClickListenerC8081d.a
    /* renamed from: c */
    public void mo38699c() {
        AbstractC7185ho.m43820b("PPSActivity", "onClose");
        finish();
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        if (configuration == null) {
            return;
        }
        super.onConfigurationChanged(configuration);
        int i10 = configuration.uiMode & 48;
        AbstractC7185ho.m43820b("PPSActivity", "currentNightMode=" + i10);
        m38641a(32 == i10 ? 2 : 0);
        m38645a(configuration);
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x004f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:113:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0046  */
    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6902b, com.huawei.openalliance.p169ad.activity.AbstractActivityC6905e, com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(android.os.Bundle r5) {
        /*
            Method dump skipped, instructions count: 253
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.activity.PPSActivity.onCreate(android.os.Bundle):void");
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater;
        int i10;
        MenuItem menuItemFindItem;
        MenuItem menuItemFindItem2;
        if (this.f31681e == null) {
            return false;
        }
        AppInfo appInfo = this.f31689m;
        if (appInfo == null || !appInfo.m44435w()) {
            menuInflater = getMenuInflater();
            i10 = C6849R.menu.hiad_land_page_menu;
        } else {
            menuInflater = getMenuInflater();
            i10 = C6849R.menu.hiad_land_page_expand_menu;
        }
        menuInflater.inflate(i10, menu);
        if (m38682k() && (menuItemFindItem2 = menu.findItem(C6849R.id.hiad_menu_item_privacy_policy)) != null) {
            menuItemFindItem2.setVisible(true);
        }
        if (!HiAd.m44014a(getApplicationContext()).mo44058k() && (menuItemFindItem = menu.findItem(C6849R.id.hiad_menu_item_open_in_browser)) != null) {
            menuItemFindItem.setVisible(false);
        }
        return m38694w() && !m38693v();
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity
    public void onDestroy() {
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43817a("PPSActivity", "onDestroy");
        }
        super.onDestroy();
        m38696y();
        m38695x();
        m38666c((Context) this);
        C7398c c7398c = this.f31701z;
        if (c7398c != null) {
            c7398c.m45591d();
            this.f31701z = null;
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.ViewOnClickListenerC8081d.a
    public void onMenuBtnClick(View view) {
        m38646a(view);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return m38658a(menuItem);
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity
    public void onPause() {
        C7169gz c7169gzM43672a;
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43817a("PPSActivity", "onPause");
        }
        super.onPause();
        IAd iAdM41881d = AbstractC7014dc.m41881d();
        if (iAdM41881d instanceof LinkedSplashAd) {
            LinkedSplashAd linkedSplashAd = (LinkedSplashAd) iAdM41881d;
            if (linkedSplashAd.getVideoInfo() != null && (c7169gzM43672a = C7171ha.m43672a()) != null) {
                linkedSplashAd.getVideoInfo().m44580e(c7169gzM43672a.m43664d());
                linkedSplashAd.getVideoInfo().m44579e(c7169gzM43672a.m43662c());
                C7171ha.m43673a((C7169gz) null);
            }
            if (linkedSplashAd.getListener() != null) {
                linkedSplashAd.getListener().onAdDetailClosed(linkedSplashAd);
            }
        }
        C7161gr c7161gr = this.f31679c;
        if (c7161gr != null) {
            c7161gr.m43615b();
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        AbstractC7185ho.m43818a("PPSActivity", "requestPermissions, requestCode=%d, result= %s", Integer.valueOf(i10), Arrays.toString(iArr));
        m38643a(i10, iArr);
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity
    public void onResume() {
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43817a("PPSActivity", "onResume");
        }
        super.onResume();
        PPSWebView pPSWebView = this.f31678b;
        if (pPSWebView != null) {
            pPSWebView.onResume();
        }
        C7161gr c7161gr = this.f31679c;
        if (c7161gr != null) {
            c7161gr.m43616c();
        }
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity
    public void onStop() {
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43817a("PPSActivity", "onStop");
        }
        super.onStop();
        PPSWebView pPSWebView = this.f31678b;
        if (pPSWebView != null) {
            pPSWebView.onStop();
        }
        if (m38692u()) {
            AbstractC7185ho.m43820b("PPSActivity", "checkFinish true");
            finish();
        }
    }

    /* renamed from: a */
    private VideoView m38639a(InterfaceC7176hf interfaceC7176hf, Float f10, int i10) {
        VideoView videoView = interfaceC7176hf.getVideoView();
        float f11 = i10 / 1.7777778f;
        float fFloatValue = f10.floatValue() * f11;
        ViewGroup.LayoutParams layoutParams = videoView.getLayoutParams();
        layoutParams.width = (int) fFloatValue;
        layoutParams.height = (int) f11;
        videoView.setLayoutParams(layoutParams);
        return videoView;
    }

    /* renamed from: c */
    private void m38666c(Context context) {
        AbstractActivityC6902b.a aVar = this.f31690n;
        if (aVar != null) {
            context.unregisterReceiver(aVar);
            this.f31690n = null;
        }
    }

    /* renamed from: e */
    private void m38671e() {
        m38653a(this.f31688l, 15);
        m38653a(this.f31686j, 15);
    }

    /* renamed from: g */
    public boolean m38675g() {
        return AbstractC7741ao.m47592n(this) || AbstractC7558os.m46467f(this.f31681e.m44290f()) == 2;
    }

    /* renamed from: h */
    private boolean m38677h() {
        return AbstractC7558os.m46467f(this.f31681e.m44290f()) == 3;
    }

    /* renamed from: i */
    private void m38679i() {
        ActionBar actionBar = this.f31680d;
        if (actionBar == null) {
            return;
        }
        actionBar.setTitle(m38680j());
        C6985cb.m41166a(this).mo41202a(this.f31680d, true, null, new View.OnClickListener() { // from class: com.huawei.openalliance.ad.activity.PPSActivity.6
            public ViewOnClickListenerC68776() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PPSActivity.this.mo38699c();
            }
        });
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6902b
    /* renamed from: b */
    public void mo38698b() {
        Handler handler = this.f31691o;
        if (handler != null) {
            handler.postDelayed(new Runnable() { // from class: com.huawei.openalliance.ad.activity.PPSActivity.2
                public RunnableC68732() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    AbstractC7185ho.m43820b("PPSActivity", "finishSelfDelayed");
                    PPSActivity.this.finish();
                }
            }, 300L);
        }
    }

    /* renamed from: b */
    private void m38661b(Context context) {
        if (Constants.HW_INTELLIEGNT_PACKAGE.equalsIgnoreCase(context.getPackageName())) {
            this.f31691o = new Handler(Looper.myLooper());
            this.f31690n = new AbstractActivityC6902b.a();
            AbstractC7741ao.m47537a(context, this.f31690n, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"), "android.permission.WRITE_SECURE_SETTINGS", null);
        }
    }

    /* renamed from: b */
    private void m38662b(AppDownloadButton appDownloadButton) {
        PPSWebView pPSWebView = this.f31678b;
        if (pPSWebView != null) {
            C7749aw c7749aw = new C7749aw(this, this.f31681e, appDownloadButton, pPSWebView, this.f31698w);
            this.f31696u = c7749aw;
            this.f31678b.addJavascriptInterface(c7749aw, Constants.PPS_JS_NAME);
            this.f31678b.addJavascriptInterface(new C7747au(this, AbstractC7572pf.m46743a(this.f31681e)), Constants.LANDING_JS_NAME);
            C7748av c7748av = new C7748av(this, AbstractC7572pf.m46743a(this.f31681e), this.f31678b);
            this.f31692q = c7748av;
            this.f31678b.addJavascriptInterface(c7748av, Constants.APPOINT_JS_NAME);
        }
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6905e
    /* renamed from: a */
    public void mo38587a() {
        setRequestedOrientation(1);
        setContentView(C6849R.layout.hiad_activity_landing_page);
        this.f31812p = (ViewGroup) findViewById(C6849R.id.hiad_landing_layout);
    }

    @TargetApi(29)
    /* renamed from: a */
    private void m38641a(int i10) {
        WebSettings settings;
        PPSWebView pPSWebView = this.f31678b;
        if (pPSWebView == null || (settings = pPSWebView.getSettings()) == null) {
            return;
        }
        settings.setForceDark(i10);
    }

    /* renamed from: b */
    public void m38663b(String str) {
        AbstractC7185ho.m43820b("PPSActivity", "report Type is " + str);
        new C6928i(this).m39202a(this.f31681e, str);
    }

    /* renamed from: a */
    private void m38642a(int i10, int i11) {
        new AlertDialog.Builder(this).setTitle(C6849R.string.hiad_calender_permission_dialog).setMessage(i11).setPositiveButton(C6849R.string.hiad_calender_set, new DialogInterface.OnClickListener() { // from class: com.huawei.openalliance.ad.activity.PPSActivity.4

            /* renamed from: a */
            final /* synthetic */ int f31712a;

            public DialogInterfaceOnClickListenerC68754(int i102) {
                i = i102;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i102) {
                PPSActivity.this.m38697z();
                dialogInterface.dismiss();
                if (PPSActivity.this.f31692q != null) {
                    int i112 = i;
                    C7748av c7748av = PPSActivity.this.f31692q;
                    if (i112 == 11) {
                        c7748av.m47645a(false, false);
                    } else {
                        c7748av.m47647b(false, false);
                    }
                }
            }
        }).setNegativeButton(C6849R.string.hiad_dialog_cancel, new DialogInterface.OnClickListener() { // from class: com.huawei.openalliance.ad.activity.PPSActivity.3

            /* renamed from: a */
            final /* synthetic */ int f31710a;

            public DialogInterfaceOnClickListenerC68743(int i102) {
                i = i102;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i102) {
                dialogInterface.dismiss();
                if (PPSActivity.this.f31692q != null) {
                    int i112 = i;
                    C7748av c7748av = PPSActivity.this.f31692q;
                    if (i112 == 11) {
                        c7748av.m47645a(false, true);
                    } else {
                        c7748av.m47647b(false, true);
                    }
                }
            }
        }).show();
    }

    /* renamed from: b */
    private void m38664b(boolean z10) {
        try {
            PPSAppDetailView pPSAppDetailView = this.f31686j;
            if (pPSAppDetailView != null && pPSAppDetailView.getVisibility() == 0) {
                View viewInflate = getLayoutInflater().inflate(C6849R.layout.hiad_landing_app_detail, (ViewGroup) null, false);
                if (viewInflate == null) {
                    return;
                }
                AbstractC7185ho.m43817a("PPSActivity", "start replace appDetailView");
                m38647a(this.f31686j, viewInflate);
                AppDownloadButton appDownloadButton = this.f31686j.getAppDownloadButton();
                if (appDownloadButton != null) {
                    m38651a(appDownloadButton, z10);
                    m38650a(appDownloadButton);
                }
                this.f31686j.setAdLandingData(this.f31681e);
            }
            PPSExpandButtonDetailView pPSExpandButtonDetailView = this.f31688l;
            if (pPSExpandButtonDetailView == null || pPSExpandButtonDetailView.getVisibility() != 0) {
                return;
            }
            PPSExpandButtonDetailView pPSExpandButtonDetailView2 = new PPSExpandButtonDetailView(this);
            if (this.f31700y) {
                pPSExpandButtonDetailView2.mo48958a(2);
            }
            AbstractC7185ho.m43817a("PPSActivity", "start replace expandButtonDetailView");
            m38647a(this.f31688l, pPSExpandButtonDetailView2);
            AppDownloadButton appDownloadButton2 = this.f31688l.getAppDownloadButton();
            if (appDownloadButton2 != null) {
                m38650a(appDownloadButton2);
            }
            this.f31688l.setAdLandingData(this.f31681e);
        } catch (Throwable unused) {
            AbstractC7185ho.m43823c("PPSActivity", "rebuild failed");
        }
    }

    /* renamed from: a */
    private void m38643a(int i10, int[] iArr) {
        if (i10 == 11 || i10 == 12) {
            if (iArr.length > 0 && iArr[0] == 0) {
                C7748av c7748av = this.f31692q;
                if (c7748av != null) {
                    if (i10 == 11) {
                        c7748av.m47645a(true, true);
                        return;
                    } else {
                        c7748av.m47647b(true, true);
                        return;
                    }
                }
                return;
            }
            if (!shouldShowRequestPermissionRationale("android.permission.WRITE_CALENDAR")) {
                m38642a(i10, i10 == 11 ? C6849R.string.hiad_calender_permission_appoint_message : C6849R.string.hiad_calender_permission_cancel_message);
                return;
            }
            C7748av c7748av2 = this.f31692q;
            if (c7748av2 != null) {
                if (i10 == 11) {
                    c7748av2.m47645a(false, true);
                } else {
                    c7748av2.m47647b(false, true);
                }
            }
        }
    }

    /* renamed from: a */
    private void m38644a(Intent intent) {
        if (intent == null) {
            return;
        }
        SafeIntent safeIntent = new SafeIntent(intent);
        AbstractC7185ho.m43820b("PPSActivity", "parseLinkedAdConfig");
        this.f31677a = new C7169gz();
        String stringExtra = safeIntent.getStringExtra(MapKeyNames.LINKED_AD_DATA);
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        this.f31677a = (C7169gz) AbstractC7758be.m47739b(stringExtra, C7169gz.class, new Class[0]);
    }

    /* renamed from: a */
    private void m38645a(Configuration configuration) {
        AbstractC7185ho.m43817a("PPSActivity", "onConfigurationChanged newConfig.screenWidthDp=" + configuration.screenWidthDp + ", this.screenWidthDp=" + this.f31687k);
        Integer num = this.f31687k;
        if (num == null || configuration.screenWidthDp == num.intValue()) {
            return;
        }
        AbstractC7185ho.m43817a("PPSActivity", "onConfigurationChanged rebuildDetailView()");
        m38664b(configuration.screenWidthDp < this.f31687k.intValue());
        this.f31687k = Integer.valueOf(configuration.screenWidthDp);
        m38637B();
    }

    /* renamed from: a */
    private void m38646a(View view) {
        MenuItem menuItemFindItem;
        MenuInflater menuInflater;
        int i10;
        if (this.f31685i == null) {
            this.f31685i = new PopupMenu(AbstractC7811dd.m48321d(this), view, 8388613);
            AppInfo appInfo = this.f31689m;
            if (appInfo == null || !appInfo.m44435w()) {
                menuInflater = this.f31685i.getMenuInflater();
                i10 = C6849R.menu.hiad_land_page_menu;
            } else {
                menuInflater = this.f31685i.getMenuInflater();
                i10 = C6849R.menu.hiad_land_page_expand_menu;
            }
            menuInflater.inflate(i10, this.f31685i.getMenu());
            this.f31685i.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.huawei.openalliance.ad.activity.PPSActivity.7
                public C68787() {
                }

                @Override // android.widget.PopupMenu.OnMenuItemClickListener
                public boolean onMenuItemClick(MenuItem menuItem) {
                    return PPSActivity.this.m38658a(menuItem);
                }
            });
        }
        if (m38682k() && (menuItemFindItem = this.f31685i.getMenu().findItem(C6849R.id.hiad_menu_item_privacy_policy)) != null) {
            menuItemFindItem.setVisible(true);
        }
        this.f31685i.show();
    }

    /* renamed from: a */
    private void m38647a(View view, View view2) {
        int i10 = C6849R.id.app_detail_root;
        C7818dk.m48370a(view.findViewById(i10), view2.findViewById(i10));
    }

    /* renamed from: a */
    private void m38650a(AppDownloadButton appDownloadButton) {
        ViewGroup.LayoutParams layoutParams = appDownloadButton.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        appDownloadButton.setLayoutParamsSkipSizeReset(layoutParams);
    }

    /* renamed from: a */
    private void m38651a(AppDownloadButton appDownloadButton, boolean z10) {
        int i10 = z10 ? C6849R.dimen.hiad_72_dp : C6849R.dimen.hiad_192_dp;
        Resources resources = getResources();
        if (resources == null) {
            return;
        }
        appDownloadButton.setMaxWidth(resources.getDimensionPixelSize(i10));
    }

    /* renamed from: a */
    private void m38652a(PPSAppDetailView pPSAppDetailView) {
        pPSAppDetailView.setVisibility(0);
        pPSAppDetailView.setNeedShowDspInfo(true);
        pPSAppDetailView.setNeedPerBeforDownload(true);
        pPSAppDetailView.setAdLandingData(this.f31681e);
        pPSAppDetailView.setDetailViewType(1);
        pPSAppDetailView.setAppDetailClickListener(this.f31699x);
        AppDownloadButton appDownloadButton = pPSAppDetailView.getAppDownloadButton();
        this.f31695t = appDownloadButton;
        if (appDownloadButton != null) {
            appDownloadButton.setSource(2);
        }
        if (this.f31695t == null || !m38689r()) {
            return;
        }
        this.f31695t.setAppDownloadButtonStyle(new C8067ab(this));
    }

    /* renamed from: a */
    private void m38653a(PPSAppDetailView pPSAppDetailView, int i10) {
        if (pPSAppDetailView != null) {
            pPSAppDetailView.setBtnSource(i10);
            pPSAppDetailView.setNonBtnSource(i10);
        }
    }

    /* renamed from: a */
    private void m38654a(PPSWebView pPSWebView) {
        if (pPSWebView == null) {
            return;
        }
        pPSWebView.setScrollListener(new View.OnScrollChangeListener() { // from class: com.huawei.openalliance.ad.activity.PPSActivity.11
            public ViewOnScrollChangeListenerC687111() {
            }

            @Override // android.view.View.OnScrollChangeListener
            public void onScrollChange(View view, int i10, int i11, int i12, int i13) {
                if (PPSActivity.this.m38636A() || !PPSActivity.this.m38688q()) {
                    return;
                }
                if (PPSActivity.this.f31688l != null && PPSActivity.this.m38675g()) {
                    PPSActivity.this.f31688l.m48965c();
                }
                if (PPSActivity.this.f31686j == null || PPSActivity.this.m38675g()) {
                    return;
                }
                PPSActivity.this.f31686j.m48965c();
            }
        });
    }

    /* renamed from: a */
    private void m38655a(String str) {
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(str + "#" + System.currentTimeMillis()));
            intent.setFlags(268468224);
            startActivity(intent);
        } catch (Throwable th2) {
            AbstractC7185ho.m43823c("PPSActivity", "openLinkInBrowser " + th2.getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    public void m38656a(boolean z10) {
        C7749aw c7749aw;
        if (z10 && !AbstractC7558os.m46483v(this.f31681e.m44290f())) {
            AbstractC7185ho.m43820b("PPSActivity", "not allow confirm");
            return;
        }
        AppDownloadButton appDownloadButton = this.f31695t;
        if (appDownloadButton == null || appDownloadButton.m48708d() || this.f31694s || this.f31695t.getStatus() != AppStatus.DOWNLOAD) {
            return;
        }
        this.f31694s = true;
        if (!z10 && (c7749aw = this.f31696u) != null) {
            if (c7749aw.m47671a()) {
                return;
            } else {
                this.f31696u.m47670a(true);
            }
        }
        m38687p();
        this.f31693r.setAdPopupData(this.f31681e);
        this.f31693r.m50511a();
        m38663b("127");
    }

    /* renamed from: a */
    private boolean m38657a(Context context) {
        return AbstractC7741ao.m47534a(context) >= 3 || C6982bz.m41155e(context);
    }

    /* renamed from: a */
    public boolean m38658a(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == C6849R.id.hiad_menu_item_refresh) {
            m38684m();
            return true;
        }
        if (itemId == C6849R.id.hiad_menu_item_copy_link) {
            m38683l();
            return true;
        }
        if (itemId == C6849R.id.hiad_menu_item_open_in_browser) {
            m38655a(this.f31681e.getLandingUrl());
            return true;
        }
        if (itemId == C6849R.id.hiad_menu_item_permission) {
            C7049h.m42419a(this, this.f31689m);
            return true;
        }
        if (itemId != C6849R.id.hiad_menu_item_privacy_policy) {
            return false;
        }
        m38655a(this.f31681e.m44313q());
        return false;
    }
}
