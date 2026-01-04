package com.huawei.openalliance.p169ad.activity;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.widget.RelativeLayout;
import com.huawei.openalliance.p169ad.AbstractC7014dc;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.inter.data.C7305h;
import com.huawei.openalliance.p169ad.inter.data.IRewardAd;
import com.huawei.openalliance.p169ad.inter.data.RewardEvent;
import com.huawei.openalliance.p169ad.inter.listeners.INonwifiActionListener;
import com.huawei.openalliance.p169ad.inter.listeners.IRewardAdStatusListener;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import com.huawei.openalliance.p169ad.utils.C7748av;
import com.huawei.openalliance.p169ad.views.AppDownloadButton;
import com.huawei.openalliance.p169ad.views.PPSRewardTemplateView;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8108ab;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8118k;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes8.dex */
public class PPSRewardActivity extends AbstractActivityC6905e {

    /* renamed from: a */
    private static final byte[] f31753a = new byte[0];

    /* renamed from: h */
    private static final ConcurrentHashMap<String, IRewardAdStatusListener> f31754h = new ConcurrentHashMap<>();

    /* renamed from: i */
    private static final ConcurrentHashMap<String, INonwifiActionListener> f31755i = new ConcurrentHashMap<>();

    /* renamed from: b */
    private InterfaceC8118k f31756b;

    /* renamed from: c */
    private Integer f31757c;

    /* renamed from: d */
    private C7305h f31758d;

    /* renamed from: e */
    private String f31759e;

    /* renamed from: f */
    private boolean f31760f = false;

    /* renamed from: g */
    private C7748av f31761g;

    /* renamed from: com.huawei.openalliance.ad.activity.PPSRewardActivity$1 */
    public class RunnableC68891 implements Runnable {
        public RunnableC68891() {
        }

        @Override // java.lang.Runnable
        public void run() {
            InterfaceC8118k interfaceC8118k = PPSRewardActivity.this.f31756b;
            if (interfaceC8118k != null) {
                interfaceC8118k.removeRewardAdStatusListener();
                interfaceC8118k.destroyView();
            }
            PPSRewardActivity.this.f31758d = null;
        }
    }

    /* renamed from: com.huawei.openalliance.ad.activity.PPSRewardActivity$2 */
    public class DialogInterfaceOnClickListenerC68902 implements DialogInterface.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ int f31763a;

        public DialogInterfaceOnClickListenerC68902(int i10) {
            i = i10;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            dialogInterface.dismiss();
            if (PPSRewardActivity.this.f31761g != null) {
                int i11 = i;
                C7748av c7748av = PPSRewardActivity.this.f31761g;
                if (i11 == 11) {
                    c7748av.m47645a(false, true);
                } else {
                    c7748av.m47647b(false, true);
                }
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.activity.PPSRewardActivity$3 */
    public class DialogInterfaceOnClickListenerC68913 implements DialogInterface.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ int f31765a;

        public DialogInterfaceOnClickListenerC68913(int i10) {
            i = i10;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", PPSRewardActivity.this.getPackageName(), null));
            PPSRewardActivity.this.startActivity(intent);
            dialogInterface.dismiss();
            if (PPSRewardActivity.this.f31761g != null) {
                int i11 = i;
                C7748av c7748av = PPSRewardActivity.this.f31761g;
                if (i11 == 11) {
                    c7748av.m47645a(false, false);
                } else {
                    c7748av.m47647b(false, false);
                }
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.activity.PPSRewardActivity$4 */
    public class RunnableC68924 implements Runnable {
        public RunnableC68924() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AppDownloadButton appDownloadButton;
            try {
                if (PPSRewardActivity.this.f31756b == null || !PPSRewardActivity.this.f31756b.mo49496h() || (appDownloadButton = PPSRewardActivity.this.f31756b.getAppDownloadButton()) == null) {
                    return;
                }
                AbstractC7185ho.m43817a("PPSRewardActivity", "reSetButtonWidth");
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) appDownloadButton.getLayoutParams();
                layoutParams.width = -1;
                appDownloadButton.setLayoutParamsSkipSizeReset(layoutParams);
            } catch (Throwable th2) {
                AbstractC7185ho.m43827d("PPSRewardActivity", "resetButtonWidth exception: %s", th2.getClass().getSimpleName());
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.activity.PPSRewardActivity$a */
    public class C6893a implements INonwifiActionListener {
        private C6893a() {
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.INonwifiActionListener
        public boolean onAppDownload(AppInfo appInfo, long j10) {
            INonwifiActionListener iNonwifiActionListener = (INonwifiActionListener) PPSRewardActivity.f31755i.get(PPSRewardActivity.this.f31759e);
            if (iNonwifiActionListener != null) {
                return iNonwifiActionListener.onAppDownload(appInfo, j10);
            }
            return false;
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.INonwifiActionListener
        public boolean onVideoPlay(long j10) {
            INonwifiActionListener iNonwifiActionListener = (INonwifiActionListener) PPSRewardActivity.f31755i.get(PPSRewardActivity.this.f31759e);
            if (iNonwifiActionListener != null) {
                return iNonwifiActionListener.onVideoPlay(j10);
            }
            return false;
        }

        public /* synthetic */ C6893a(PPSRewardActivity pPSRewardActivity, RunnableC68891 runnableC68891) {
            this();
        }
    }

    /* renamed from: com.huawei.openalliance.ad.activity.PPSRewardActivity$b */
    public class C6894b implements IRewardAdStatusListener {
        private C6894b() {
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.IRewardAdStatusListener
        public void onAdClicked() {
            IRewardAdStatusListener iRewardAdStatusListener = (IRewardAdStatusListener) PPSRewardActivity.f31754h.get(PPSRewardActivity.this.f31759e);
            if (iRewardAdStatusListener != null) {
                iRewardAdStatusListener.onAdClicked();
            }
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.IRewardAdStatusListener
        public void onAdClosed() {
            IRewardAdStatusListener iRewardAdStatusListener = (IRewardAdStatusListener) PPSRewardActivity.f31754h.get(PPSRewardActivity.this.f31759e);
            if (iRewardAdStatusListener != null) {
                iRewardAdStatusListener.onAdClosed();
            }
            PPSRewardActivity.this.finish();
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.IRewardAdStatusListener
        public void onAdCompleted() {
            PPSRewardActivity.this.f31760f = true;
            IRewardAdStatusListener iRewardAdStatusListener = (IRewardAdStatusListener) PPSRewardActivity.f31754h.get(PPSRewardActivity.this.f31759e);
            if (iRewardAdStatusListener != null) {
                iRewardAdStatusListener.onAdCompleted();
            }
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.IRewardAdStatusListener
        public void onAdError(int i10, int i11) {
            PPSRewardActivity.this.f31760f = true;
            IRewardAdStatusListener iRewardAdStatusListener = (IRewardAdStatusListener) PPSRewardActivity.f31754h.get(PPSRewardActivity.this.f31759e);
            if (iRewardAdStatusListener != null) {
                iRewardAdStatusListener.onAdError(i10, i11);
            }
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.IRewardAdStatusListener
        public void onAdShown() {
            IRewardAdStatusListener iRewardAdStatusListener = (IRewardAdStatusListener) PPSRewardActivity.f31754h.get(PPSRewardActivity.this.f31759e);
            if (iRewardAdStatusListener != null) {
                iRewardAdStatusListener.onAdShown();
            }
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.IRewardAdStatusListener
        public void onRewarded() {
            IRewardAdStatusListener iRewardAdStatusListener = (IRewardAdStatusListener) PPSRewardActivity.f31754h.get(PPSRewardActivity.this.f31759e);
            if (iRewardAdStatusListener != null) {
                iRewardAdStatusListener.onRewarded();
            }
        }

        public /* synthetic */ C6894b(PPSRewardActivity pPSRewardActivity, RunnableC68891 runnableC68891) {
            this();
        }
    }

    /* renamed from: com.huawei.openalliance.ad.activity.PPSRewardActivity$c */
    public class C6895c implements InterfaceC8108ab {
        private C6895c() {
        }

        @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8108ab
        /* renamed from: a */
        public void mo38754a(int i10) {
            AbstractC7185ho.m43824c("PPSRewardActivity", "template init error, extra: %s", Integer.valueOf(i10));
            IRewardAdStatusListener iRewardAdStatusListener = (IRewardAdStatusListener) PPSRewardActivity.f31754h.get(PPSRewardActivity.this.f31759e);
            if (iRewardAdStatusListener != null) {
                iRewardAdStatusListener.onAdError(-2, i10);
            }
            PPSRewardActivity.this.finish();
        }

        public /* synthetic */ C6895c(PPSRewardActivity pPSRewardActivity, RunnableC68891 runnableC68891) {
            this();
        }
    }

    /* renamed from: a */
    private View m38739a(Integer num) {
        AbstractC7185ho.m43821b("PPSRewardActivity", "apiVer: %s", num);
        View viewInflate = LayoutInflater.from(this).inflate((num == null || num.intValue() != 3) ? C6849R.layout.hiad_reward_view : C6849R.layout.hiad_reward_template_view, this.f31812p, false);
        this.f31812p.addView(viewInflate, new RelativeLayout.LayoutParams(-1, -1));
        return viewInflate;
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity
    public void onBackPressed() {
        if (!this.f31760f) {
            InterfaceC8118k interfaceC8118k = this.f31756b;
            if (interfaceC8118k != null) {
                interfaceC8118k.onEvent(RewardEvent.BACKPRESSED);
                return;
            }
            return;
        }
        InterfaceC8118k interfaceC8118k2 = this.f31756b;
        if (interfaceC8118k2 instanceof PPSRewardTemplateView) {
            interfaceC8118k2.onEvent(RewardEvent.BACKPRESSED);
            return;
        }
        IRewardAdStatusListener iRewardAdStatusListener = f31754h.get(this.f31759e);
        if (iRewardAdStatusListener != null) {
            iRewardAdStatusListener.onAdClosed();
        }
        super.onBackPressed();
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        if (configuration == null) {
            return;
        }
        super.onConfigurationChanged(configuration);
        int i10 = configuration.uiMode & 48;
        AbstractC7185ho.m43820b("PPSRewardActivity", "currentNightMode=" + i10);
        m38742a(32 == i10 ? 2 : 0);
        m38745a(configuration);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6905e, com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity
    public void onCreate(Bundle bundle) {
        AbstractC7811dd.m48331h(this);
        super.onCreate(bundle);
        try {
            AbstractC7185ho.m43820b("PPSRewardActivity", "onCreate");
            C7305h c7305hM41875b = AbstractC7014dc.m41875b();
            this.f31758d = c7305hM41875b;
            if (c7305hM41875b == null) {
                AbstractC7185ho.m43823c("PPSRewardActivity", "reward ad is null, finish, this should not happen");
                finish();
                return;
            }
            this.f31759e = c7305hM41875b.getUniqueId();
            int i10 = !"2".equals(this.f31758d.m44948ac()) ? 1 : 0;
            setRequestedOrientation(i10);
            AbstractC7811dd.m48290a(this, i10);
            InterfaceC8118k interfaceC8118k = (InterfaceC8118k) m38739a(this.f31758d.m44957al());
            this.f31756b = interfaceC8118k;
            interfaceC8118k.setVisibility(0);
            this.f31756b.setOrientation(i10);
            this.f31756b.addRewardAdStatusListener(new C6894b());
            this.f31756b.addNonwifiActionListener(new C6893a());
            this.f31756b.setTemplateErrorListener(new C6895c());
            this.f31756b.mo49479a((IRewardAd) this.f31758d, true);
            this.f31761g = this.f31756b.getAppointJs();
            Resources resources = getResources();
            if (resources != null) {
                if (resources.getConfiguration() != null) {
                    this.f31757c = Integer.valueOf(resources.getConfiguration().screenWidthDp);
                }
                onConfigurationChanged(resources.getConfiguration());
            }
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("PPSRewardActivity", "onCreateEx: %s", th2.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.activity.PPSRewardActivity.1
            public RunnableC68891() {
            }

            @Override // java.lang.Runnable
            public void run() {
                InterfaceC8118k interfaceC8118k = PPSRewardActivity.this.f31756b;
                if (interfaceC8118k != null) {
                    interfaceC8118k.removeRewardAdStatusListener();
                    interfaceC8118k.destroyView();
                }
                PPSRewardActivity.this.f31758d = null;
            }
        });
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity
    public void onPause() {
        AbstractC7185ho.m43817a("PPSRewardActivity", "onPause");
        InterfaceC8118k interfaceC8118k = this.f31756b;
        if (interfaceC8118k != null) {
            interfaceC8118k.mo49488b(false);
            this.f31756b.pauseView();
        }
        super.onPause();
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        AbstractC7185ho.m43818a("PPSRewardActivity", "requestPermissions, requestCode=%d, result= %s", Integer.valueOf(i10), Arrays.toString(iArr));
        m38744a(i10, iArr);
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity
    public void onResume() {
        InterfaceC8118k interfaceC8118k = this.f31756b;
        if (interfaceC8118k != null) {
            interfaceC8118k.mo49488b(true);
            this.f31756b.resumeView();
        }
        super.onResume();
        m38753b();
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity
    public void onStop() {
        super.onStop();
        InterfaceC8118k interfaceC8118k = this.f31756b;
        if (interfaceC8118k != null) {
            interfaceC8118k.mo49495g();
            this.f31756b.mo49488b(false);
        }
    }

    /* renamed from: b */
    public void m38753b() {
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.activity.PPSRewardActivity.4
            public RunnableC68924() {
            }

            @Override // java.lang.Runnable
            public void run() {
                AppDownloadButton appDownloadButton;
                try {
                    if (PPSRewardActivity.this.f31756b == null || !PPSRewardActivity.this.f31756b.mo49496h() || (appDownloadButton = PPSRewardActivity.this.f31756b.getAppDownloadButton()) == null) {
                        return;
                    }
                    AbstractC7185ho.m43817a("PPSRewardActivity", "reSetButtonWidth");
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) appDownloadButton.getLayoutParams();
                    layoutParams.width = -1;
                    appDownloadButton.setLayoutParamsSkipSizeReset(layoutParams);
                } catch (Throwable th2) {
                    AbstractC7185ho.m43827d("PPSRewardActivity", "resetButtonWidth exception: %s", th2.getClass().getSimpleName());
                }
            }
        });
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6905e
    /* renamed from: a */
    public void mo38587a() {
        setContentView(C6849R.layout.hiad_activity_reward);
        this.f31812p = (ViewGroup) findViewById(C6849R.id.hiad_reward_layout);
    }

    @TargetApi(29)
    /* renamed from: a */
    private void m38742a(int i10) {
        WebSettings webViewSettings;
        InterfaceC8118k interfaceC8118k = this.f31756b;
        if (interfaceC8118k == null || (webViewSettings = interfaceC8118k.getWebViewSettings()) == null) {
            return;
        }
        webViewSettings.setForceDark(i10);
    }

    /* renamed from: a */
    private void m38743a(int i10, int i11) {
        new AlertDialog.Builder(this).setTitle(C6849R.string.hiad_calender_permission_dialog).setMessage(i11).setPositiveButton(C6849R.string.hiad_calender_set, new DialogInterface.OnClickListener() { // from class: com.huawei.openalliance.ad.activity.PPSRewardActivity.3

            /* renamed from: a */
            final /* synthetic */ int f31765a;

            public DialogInterfaceOnClickListenerC68913(int i102) {
                i = i102;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i102) {
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", PPSRewardActivity.this.getPackageName(), null));
                PPSRewardActivity.this.startActivity(intent);
                dialogInterface.dismiss();
                if (PPSRewardActivity.this.f31761g != null) {
                    int i112 = i;
                    C7748av c7748av = PPSRewardActivity.this.f31761g;
                    if (i112 == 11) {
                        c7748av.m47645a(false, false);
                    } else {
                        c7748av.m47647b(false, false);
                    }
                }
            }
        }).setNegativeButton(C6849R.string.hiad_dialog_cancel, new DialogInterface.OnClickListener() { // from class: com.huawei.openalliance.ad.activity.PPSRewardActivity.2

            /* renamed from: a */
            final /* synthetic */ int f31763a;

            public DialogInterfaceOnClickListenerC68902(int i102) {
                i = i102;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i102) {
                dialogInterface.dismiss();
                if (PPSRewardActivity.this.f31761g != null) {
                    int i112 = i;
                    C7748av c7748av = PPSRewardActivity.this.f31761g;
                    if (i112 == 11) {
                        c7748av.m47645a(false, true);
                    } else {
                        c7748av.m47647b(false, true);
                    }
                }
            }
        }).show();
    }

    /* renamed from: a */
    private void m38744a(int i10, int[] iArr) {
        if (i10 == 11 || i10 == 12) {
            if (iArr.length > 0 && iArr[0] == 0) {
                C7748av c7748av = this.f31761g;
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
                m38743a(i10, i10 == 11 ? C6849R.string.hiad_calender_permission_appoint_message : C6849R.string.hiad_calender_permission_cancel_message);
                return;
            }
            C7748av c7748av2 = this.f31761g;
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
    private void m38745a(Configuration configuration) {
        AbstractC7185ho.m43817a("PPSRewardActivity", "onConfigurationChanged newConfig.screenWidthDp=" + configuration.screenWidthDp + ", this.screenWidthDp=" + this.f31757c);
        Integer num = this.f31757c;
        if (num == null || configuration.screenWidthDp != num.intValue()) {
            AbstractC7185ho.m43817a("PPSRewardActivity", "onConfigurationChanged resetButtonWidth()");
            this.f31757c = Integer.valueOf(configuration.screenWidthDp);
            m38753b();
        }
    }

    /* renamed from: a */
    public static void m38746a(String str, INonwifiActionListener iNonwifiActionListener) {
        String str2;
        String str3;
        if (TextUtils.isEmpty(str)) {
            str2 = "PPSRewardActivity";
            str3 = "registerNonwifiActionListener key is null";
        } else {
            if (iNonwifiActionListener != null) {
                synchronized (f31753a) {
                    f31755i.put(str, iNonwifiActionListener);
                }
                return;
            }
            str2 = "PPSRewardActivity";
            str3 = "registerNonwifiActionListener listener is null";
        }
        AbstractC7185ho.m43823c(str2, str3);
    }

    /* renamed from: a */
    public static void m38747a(String str, IRewardAdStatusListener iRewardAdStatusListener) {
        String str2;
        String str3;
        if (TextUtils.isEmpty(str)) {
            str2 = "PPSRewardActivity";
            str3 = "registerIRewardAdStatusListener key is null";
        } else {
            if (iRewardAdStatusListener != null) {
                synchronized (f31753a) {
                    f31754h.put(str, iRewardAdStatusListener);
                }
                return;
            }
            str2 = "PPSRewardActivity";
            str3 = "registerIRewardAdStatusListener listner is null";
        }
        AbstractC7185ho.m43823c(str2, str3);
    }
}
