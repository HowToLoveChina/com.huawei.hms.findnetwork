package com.huawei.openalliance.p169ad.views;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.C7019dh;
import com.huawei.openalliance.p169ad.C7650rz;
import com.huawei.openalliance.p169ad.C7653sb;
import com.huawei.openalliance.p169ad.C7654sc;
import com.huawei.openalliance.p169ad.C7694tp;
import com.huawei.openalliance.p169ad.analysis.C6928i;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.download.app.AppStatus;
import com.huawei.openalliance.p169ad.download.app.C7045d;
import com.huawei.openalliance.p169ad.inter.data.AdLandingPageData;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.p169ad.inter.listeners.AppDownloadListener;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import com.huawei.openalliance.p169ad.utils.AbstractC7846y;
import com.huawei.openalliance.p169ad.utils.C7752az;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8107aa;
import java.lang.ref.WeakReference;

/* renamed from: com.huawei.openalliance.ad.views.t */
/* loaded from: classes2.dex */
public class C8150t extends RelativeLayout {

    /* renamed from: a */
    private c f38122a;

    /* renamed from: b */
    private Context f38123b;

    /* renamed from: c */
    private AdLandingPageData f38124c;

    /* renamed from: d */
    private AppInfo f38125d;

    /* renamed from: e */
    private String f38126e;

    /* renamed from: f */
    private View f38127f;

    /* renamed from: g */
    private TextView f38128g;

    /* renamed from: h */
    private ImageView f38129h;

    /* renamed from: i */
    private SixElementsView f38130i;

    /* renamed from: j */
    private TextView f38131j;

    /* renamed from: k */
    private InterfaceC8107aa f38132k;

    /* renamed from: l */
    private AlertDialog f38133l;

    /* renamed from: m */
    private MaterialClickInfo f38134m;

    /* renamed from: n */
    private a f38135n;

    /* renamed from: com.huawei.openalliance.ad.views.t$1 */
    public class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (C8150t.this.f38132k != null) {
                C8150t.this.f38132k.mo38707c();
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.t$2 */
    public class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C8150t.this.f38132k.mo38705a();
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.t$3 */
    public class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C8150t.this.f38132k.mo38706b();
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.t$a */
    public interface a {
        /* renamed from: a */
        void mo47418a();
    }

    /* renamed from: com.huawei.openalliance.ad.views.t$b */
    public static class b implements Runnable {

        /* renamed from: a */
        String f38139a;

        /* renamed from: b */
        Context f38140b;

        /* renamed from: c */
        private ImageView f38141c;

        /* renamed from: com.huawei.openalliance.ad.views.t$b$1 */
        public class AnonymousClass1 implements C7752az.a {

            /* renamed from: com.huawei.openalliance.ad.views.t$b$1$1 */
            public class RunnableC144811 implements Runnable {

                /* renamed from: a */
                final /* synthetic */ Drawable f38143a;

                public RunnableC144811(Drawable drawable) {
                    drawable = drawable;
                }

                @Override // java.lang.Runnable
                public void run() {
                    b.this.f38141c.setImageDrawable(drawable);
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
                    AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.t.b.1.1

                        /* renamed from: a */
                        final /* synthetic */ Drawable f38143a;

                        public RunnableC144811(Drawable drawable2) {
                            drawable = drawable2;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.f38141c.setImageDrawable(drawable);
                        }
                    });
                }
            }
        }

        public b(Context context, ImageView imageView, String str) {
            this.f38140b = context == null ? null : context.getApplicationContext();
            this.f38141c = imageView;
            this.f38139a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f38140b == null) {
                AbstractC7185ho.m43823c("PPSRewardPopUpView", "para is null");
                return;
            }
            C7653sb c7653sb = new C7653sb();
            c7653sb.m47181b(false);
            c7653sb.m47185c(true);
            c7653sb.m47180b("icon");
            c7653sb.m47187d(this.f38139a);
            C7654sc c7654scM47158a = new C7650rz(this.f38140b, c7653sb).m47158a();
            if (c7654scM47158a != null) {
                String strM47207a = c7654scM47158a.m47207a();
                if (TextUtils.isEmpty(strM47207a)) {
                    return;
                }
                String strM41968c = C7019dh.m41937a(this.f38140b, Constants.NORMAL_CACHE).m41968c(strM47207a);
                if (TextUtils.isEmpty(strM41968c)) {
                    return;
                }
                C7752az.m47690a(this.f38140b, strM41968c, new C7752az.a() { // from class: com.huawei.openalliance.ad.views.t.b.1

                    /* renamed from: com.huawei.openalliance.ad.views.t$b$1$1 */
                    public class RunnableC144811 implements Runnable {

                        /* renamed from: a */
                        final /* synthetic */ Drawable f38143a;

                        public RunnableC144811(Drawable drawable2) {
                            drawable = drawable2;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.f38141c.setImageDrawable(drawable);
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
                            AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.t.b.1.1

                                /* renamed from: a */
                                final /* synthetic */ Drawable f38143a;

                                public RunnableC144811(Drawable drawable22) {
                                    drawable = drawable22;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    b.this.f38141c.setImageDrawable(drawable);
                                }
                            });
                        }
                    }
                });
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.t$c */
    public static class c implements AppDownloadListener {

        /* renamed from: a */
        private WeakReference<C8150t> f38145a;

        public c(C8150t c8150t) {
            this.f38145a = new WeakReference<>(c8150t);
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.AppDownloadListener
        public void onAppOpen(AppInfo appInfo) {
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.AppDownloadListener
        public void onDownloadProgress(AppInfo appInfo, int i10) {
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.AppDownloadListener
        public void onStatusChanged(AppStatus appStatus, AppInfo appInfo) {
            C8150t c8150t = this.f38145a.get();
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43818a("PopupStatusListener", "onStatusChange, status: %s", appStatus);
            }
            if (c8150t == null || c8150t.f38133l == null || appStatus == AppStatus.DOWNLOAD) {
                return;
            }
            AbstractC7185ho.m43820b("PopupStatusListener", "download start, dismissView");
            if (c8150t.f38133l.isShowing() && c8150t.f38135n != null) {
                AbstractC7185ho.m43820b("PopupStatusListener", "download trigger dismissView");
                c8150t.f38135n.mo47418a();
            }
            c8150t.m50512b();
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.AppDownloadListener
        public void onUserCancel(AppInfo appInfo) {
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.AppDownloadListener
        public void onAppOpen(String str) {
        }
    }

    public C8150t(Context context, int i10) {
        super(context);
        m50503a(context, i10);
    }

    /* renamed from: d */
    private boolean m50508d() {
        String str;
        Context context = this.f38123b;
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (!activity.isFinishing() && !activity.isDestroyed()) {
                return true;
            }
            str = "can't show dialog due to activity status!";
        } else {
            str = "context not activity";
        }
        AbstractC7185ho.m43820b("PPSRewardPopUpView", str);
        return false;
    }

    /* renamed from: e */
    private void m50509e() {
        AbstractC7185ho.m43820b("PPSRewardPopUpView", "refresh UI");
        this.f38130i.mo49855a(this.f38124c);
        this.f38126e = this.f38125d.getIconUrl();
        if (AbstractC7741ao.m47592n(this.f38123b)) {
            this.f38128g.setTextSize(1, 30.0f);
            this.f38131j.setTextSize(1, 30.0f);
        }
        this.f38128g.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.t.2
            public AnonymousClass2() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                C8150t.this.f38132k.mo38705a();
            }
        });
        this.f38131j.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.t.3
            public AnonymousClass3() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                C8150t.this.f38132k.mo38706b();
            }
        });
    }

    /* renamed from: f */
    private void m50510f() {
        AlertDialog alertDialogCreate = AbstractC7846y.m48617a(this.f38123b).create();
        this.f38133l = alertDialogCreate;
        alertDialogCreate.setView(this.f38127f);
        this.f38133l.setCanceledOnTouchOutside(false);
        this.f38133l.getWindow().setDimAmount(0.2f);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            int iM47282a = C7694tp.m47282a(motionEvent);
            if (iM47282a == 0) {
                this.f38134m = C7694tp.m47283a(this, motionEvent);
            }
            if (1 == iM47282a) {
                C7694tp.m47284a(this, motionEvent, null, this.f38134m);
                SixElementsView sixElementsView = this.f38130i;
                if (sixElementsView != null) {
                    sixElementsView.setOrgClickInfo(this.f38134m);
                }
            }
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("PPSRewardPopUpView", "dispatchTouchEvent exception : %s", th2.getClass().getSimpleName());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public MaterialClickInfo getClickInfo() {
        return this.f38134m;
    }

    public AlertDialog getDialog() {
        return this.f38133l;
    }

    public void setAdPopupData(AdLandingPageData adLandingPageData) {
        String str;
        if (adLandingPageData == null) {
            return;
        }
        try {
            AbstractC7185ho.m43820b("PPSRewardPopUpView", "set popup data");
            this.f38124c = adLandingPageData;
            AppInfo appInfo = adLandingPageData.getAppInfo();
            this.f38125d = appInfo;
            if (appInfo != null && "11".equals(appInfo.getPriorInstallWay()) && this.f38128g != null && this.f38131j != null) {
                this.f38128g.setText(this.f38125d.m44344C() == 1 ? C6849R.string.hiad_preinstall_restore_and_open : C6849R.string.hiad_download_install);
                this.f38131j.setText(C6849R.string.hiad_preinstall_cancel_restore);
            }
            m50509e();
        } catch (RuntimeException unused) {
            str = "setAdPopupData RuntimeException.";
            AbstractC7185ho.m43823c("PPSRewardPopUpView", str);
        } catch (Exception unused2) {
            str = "setAdPopupData error.";
            AbstractC7185ho.m43823c("PPSRewardPopUpView", str);
        }
    }

    public void setDismissListener(a aVar) {
        this.f38135n = aVar;
    }

    public void setPopUpClickListener(InterfaceC8107aa interfaceC8107aa) {
        this.f38132k = interfaceC8107aa;
    }

    /* renamed from: a */
    private void m50503a(Context context, int i10) {
        this.f38123b = context;
        View viewInflate = View.inflate(context, C6849R.layout.hiad_reward_popup, this);
        this.f38127f = viewInflate;
        viewInflate.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.t.1
            public AnonymousClass1() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (C8150t.this.f38132k != null) {
                    C8150t.this.f38132k.mo38707c();
                }
            }
        });
        this.f38129h = (ImageView) this.f38127f.findViewById(C6849R.id.popup_icon);
        this.f38130i = (SixElementsView) this.f38127f.findViewById(C6849R.id.popup_icon_six_elements);
        this.f38128g = (TextView) this.f38127f.findViewById(C6849R.id.popup_download_btn);
        TextView textView = (TextView) this.f38127f.findViewById(C6849R.id.abort_downlaod_btn);
        this.f38131j = textView;
        textView.setEllipsize(TextUtils.TruncateAt.END);
        m50510f();
        this.f38122a = new c(this);
        C7045d.m42344a().m42350b(this.f38122a);
    }

    /* renamed from: b */
    public void m50512b() {
        if (this.f38127f == null || this.f38133l == null) {
            return;
        }
        AbstractC7185ho.m43820b("PPSRewardPopUpView", "Dialog has been dismissed");
        if (this.f38133l.isShowing()) {
            this.f38133l.dismiss();
        }
        this.f38133l = null;
    }

    /* renamed from: c */
    public void m50513c() {
        C7045d.m42344a().m42352c(this.f38122a);
    }

    /* renamed from: a */
    public static void m50504a(Context context, String str, ContentRecord contentRecord) {
        AbstractC7185ho.m43820b("PPSRewardPopUpView", "report Type is " + str);
        new C6928i(context).m39219d(contentRecord, str);
    }

    /* renamed from: a */
    private void m50505a(ImageView imageView, String str) {
        if (TextUtils.isEmpty(str) || imageView == null) {
            return;
        }
        AbstractC7185ho.m43820b("PPSRewardPopUpView", "load app icon:" + AbstractC7806cz.m48174f(str));
        AbstractC7834m.m48484d(new b(this.f38123b, imageView, str));
    }

    /* renamed from: a */
    public boolean m50511a() {
        AlertDialog alertDialog;
        if (!m50508d()) {
            return false;
        }
        m50505a(this.f38129h, this.f38126e);
        if (this.f38127f == null || (alertDialog = this.f38133l) == null) {
            AbstractC7185ho.m43823c("PPSRewardPopUpView", "rootView or dialog is null");
            return false;
        }
        alertDialog.show();
        SixElementsView sixElementsView = this.f38130i;
        if (sixElementsView == null) {
            return true;
        }
        sixElementsView.m49942a(false);
        return true;
    }
}
