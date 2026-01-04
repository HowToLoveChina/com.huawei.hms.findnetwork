package com.huawei.openalliance.p169ad.inter;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.ads.VideoConfiguration;
import com.huawei.hms.ads.consent.inter.Consent;
import com.huawei.hms.pps.EnableServiceResult;
import com.huawei.hms.pps.HwPPS;
import com.huawei.openalliance.p169ad.AbstractC7014dc;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6982bz;
import com.huawei.openalliance.p169ad.C7019dh;
import com.huawei.openalliance.p169ad.C7076dt;
import com.huawei.openalliance.p169ad.C7084e;
import com.huawei.openalliance.p169ad.C7103es;
import com.huawei.openalliance.p169ad.C7108ex;
import com.huawei.openalliance.p169ad.C7118fb;
import com.huawei.openalliance.p169ad.C7119fc;
import com.huawei.openalliance.p169ad.C7120fd;
import com.huawei.openalliance.p169ad.C7122ff;
import com.huawei.openalliance.p169ad.C7124fh;
import com.huawei.openalliance.p169ad.C7128fl;
import com.huawei.openalliance.p169ad.C7130fn;
import com.huawei.openalliance.p169ad.C7217ik;
import com.huawei.openalliance.p169ad.C7350jx;
import com.huawei.openalliance.p169ad.C7484ms;
import com.huawei.openalliance.p169ad.C7517nl;
import com.huawei.openalliance.p169ad.C7561ov;
import com.huawei.openalliance.p169ad.EnumC7338jl;
import com.huawei.openalliance.p169ad.InterfaceC7140fx;
import com.huawei.openalliance.p169ad.InterfaceC7146gc;
import com.huawei.openalliance.p169ad.analysis.C6922c;
import com.huawei.openalliance.p169ad.analysis.C6926g;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.beans.parameter.RequestOptions;
import com.huawei.openalliance.p169ad.beans.server.AdPreReq;
import com.huawei.openalliance.p169ad.beans.server.AppConfigRsp;
import com.huawei.openalliance.p169ad.constant.ConfigMapKeys;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import com.huawei.openalliance.p169ad.constant.RTCMethods;
import com.huawei.openalliance.p169ad.constant.WhiteListPkgList;
import com.huawei.openalliance.p169ad.download.app.C7045d;
import com.huawei.openalliance.p169ad.download.app.C7046e;
import com.huawei.openalliance.p169ad.download.app.C7055l;
import com.huawei.openalliance.p169ad.download.app.interfaces.AutoOpenListener;
import com.huawei.openalliance.p169ad.download.p172ag.C7038f;
import com.huawei.openalliance.p169ad.dynamictemplate.C7082a;
import com.huawei.openalliance.p169ad.dynamictemplate.IImageLoader;
import com.huawei.openalliance.p169ad.inter.listeners.AppDownloadListener;
import com.huawei.openalliance.p169ad.inter.listeners.AppDownloadListenerV1;
import com.huawei.openalliance.p169ad.inter.listeners.ExtensionActionListener;
import com.huawei.openalliance.p169ad.inter.listeners.IAskForUnlockScreen;
import com.huawei.openalliance.p169ad.inter.listeners.IExSplashCallback;
import com.huawei.openalliance.p169ad.inter.listeners.IPPSWebEventCallback;
import com.huawei.openalliance.p169ad.inter.listeners.LandingPageAction;
import com.huawei.openalliance.p169ad.inter.listeners.LinkedAdListener;
import com.huawei.openalliance.p169ad.ipc.CallResult;
import com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.p169ad.magazine.inter.listener.IAdInvalidHandler;
import com.huawei.openalliance.p169ad.magazine.inter.listener.IPPSDownloadService;
import com.huawei.openalliance.p169ad.media.C7468a;
import com.huawei.openalliance.p169ad.media.IMultiMediaPlayingManager;
import com.huawei.openalliance.p169ad.net.http.HttpsConfig;
import com.huawei.openalliance.p169ad.p171db.bean.SdkCfgSha256Record;
import com.huawei.openalliance.p169ad.utils.AbstractC7731ae;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7759bf;
import com.huawei.openalliance.p169ad.utils.AbstractC7763bj;
import com.huawei.openalliance.p169ad.utils.AbstractC7803cw;
import com.huawei.openalliance.p169ad.utils.AbstractC7804cx;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7807d;
import com.huawei.openalliance.p169ad.utils.AbstractC7810dc;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import com.huawei.openalliance.p169ad.utils.C7735ai;
import com.huawei.openalliance.p169ad.utils.C7736aj;
import com.huawei.openalliance.p169ad.utils.C7765bl;
import com.huawei.openalliance.p169ad.utils.C7785ce;
import com.huawei.openalliance.p169ad.utils.C7787cg;
import com.huawei.openalliance.p169ad.utils.C7798cr;
import com.huawei.openalliance.p169ad.utils.C7800ct;
import com.huawei.openalliance.p169ad.utils.C7812de;
import com.huawei.openalliance.p169ad.utils.C7830i;
import com.huawei.openalliance.p169ad.utils.C7845x;
import com.huawei.openalliance.p169ad.utils.RunnableC7813df;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import org.json.JSONObject;
import p208cq.InterfaceC8937e;

@OuterVisible
/* loaded from: classes2.dex */
public final class HiAd implements IHiAd, InterfaceC7308f {

    /* renamed from: a */
    private static final String f33275a = "HiAd";

    /* renamed from: b */
    private static HiAd f33276b;

    /* renamed from: c */
    private static final byte[] f33277c = new byte[0];

    /* renamed from: D */
    private IPPSDownloadService f33281D;

    /* renamed from: E */
    private IAdInvalidHandler f33282E;

    /* renamed from: G */
    private IAskForUnlockScreen f33284G;

    /* renamed from: d */
    private Context f33286d;

    /* renamed from: e */
    private InterfaceC7146gc f33287e;

    /* renamed from: f */
    private InterfaceC7140fx f33288f;

    /* renamed from: g */
    private LandingPageAction f33289g;

    /* renamed from: h */
    private IMultiMediaPlayingManager f33290h;

    /* renamed from: j */
    private IAppDownloadManager f33292j;

    /* renamed from: k */
    private AppDownloadListener f33293k;

    /* renamed from: l */
    private AppDownloadListenerV1 f33294l;

    /* renamed from: m */
    private AutoOpenListener f33295m;

    /* renamed from: n */
    private IPPSWebEventCallback f33296n;

    /* renamed from: o */
    private IExSplashCallback f33297o;

    /* renamed from: p */
    private ExtensionActionListener f33298p;

    /* renamed from: q */
    private int f33299q;

    /* renamed from: r */
    private int f33300r;

    /* renamed from: s */
    private LinkedAdListener f33301s;

    /* renamed from: u */
    private RequestOptions f33303u;

    /* renamed from: v */
    private Integer f33304v;

    /* renamed from: z */
    private AppStatusQuery f33308z;

    /* renamed from: i */
    private Map<BroadcastReceiver, IntentFilter> f33291i = new HashMap();

    /* renamed from: t */
    private int f33302t = -1;

    /* renamed from: w */
    private boolean f33305w = true;

    /* renamed from: x */
    private boolean f33306x = true;

    /* renamed from: y */
    private int f33307y = 0;

    /* renamed from: A */
    private Map<Integer, Boolean> f33278A = new HashMap();

    /* renamed from: B */
    private Boolean f33279B = null;

    /* renamed from: C */
    private boolean f33280C = true;

    /* renamed from: F */
    private WeakReference<Activity> f33283F = null;

    /* renamed from: H */
    private BroadcastReceiver f33285H = new BroadcastReceiver() { // from class: com.huawei.openalliance.ad.inter.HiAd.3

        /* renamed from: com.huawei.openalliance.ad.inter.HiAd$3$1 */
        public class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Intent f33329a;

            /* renamed from: b */
            final /* synthetic */ Context f33330b;

            public AnonymousClass1(Intent intent, Context context) {
                intent = intent;
                context = context;
            }

            @Override // java.lang.Runnable
            public void run() {
                String action = intent.getAction();
                for (Map.Entry entry : HiAd.this.f33291i.entrySet()) {
                    BroadcastReceiver broadcastReceiver = (BroadcastReceiver) entry.getKey();
                    IntentFilter intentFilter = (IntentFilter) entry.getValue();
                    if (intentFilter != null && intentFilter.matchAction(action)) {
                        broadcastReceiver.onReceive(context, intent);
                    }
                }
            }
        }

        public C72413() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.inter.HiAd.3.1

                /* renamed from: a */
                final /* synthetic */ Intent f33329a;

                /* renamed from: b */
                final /* synthetic */ Context f33330b;

                public AnonymousClass1(Intent intent2, Context context2) {
                    intent = intent2;
                    context = context2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    String action = intent.getAction();
                    for (Map.Entry entry : HiAd.this.f33291i.entrySet()) {
                        BroadcastReceiver broadcastReceiver = (BroadcastReceiver) entry.getKey();
                        IntentFilter intentFilter = (IntentFilter) entry.getValue();
                        if (intentFilter != null && intentFilter.matchAction(action)) {
                            broadcastReceiver.onReceive(context, intent);
                        }
                    }
                }
            });
        }
    };

    /* renamed from: com.huawei.openalliance.ad.inter.HiAd$1 */
    public class RunnableC72301 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f33309a;

        public RunnableC72301(Context context) {
            context = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C6982bz.m41152b(context)) {
                IntentFilter intentFilter = new IntentFilter(Constants.ACTION_EXSPLASH_START_LINKED);
                Intent intentM47537a = AbstractC7741ao.m47537a(HiAd.this.f33286d, null, intentFilter, Constants.PERMISSION_PPS_DOWNLOAD, null);
                if (intentM47537a != null && intentM47537a.getAction() != null && intentM47537a.getAction().equals(Constants.ACTION_EXSPLASH_START_LINKED)) {
                    Log.d(HiAd.f33275a, "HiAd: getIntent");
                    new C7287b(HiAd.this.f33286d).onReceive(HiAd.this.f33286d, intentM47537a);
                }
                AbstractC7741ao.m47537a(HiAd.this.f33286d, new C7287b(HiAd.this.f33286d), intentFilter, Constants.PERMISSION_PPS_DOWNLOAD, null);
            }
            C7288c.m44224a(HiAd.this.f33286d).m44231b();
            C7798cr.m48109a(HiAd.this.f33286d);
            AbstractC7804cx.m48138a(HiAd.this.f33286d);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.inter.HiAd$10 */
    public class C723110 implements Application.ActivityLifecycleCallbacks {
        public C723110() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            if (activity != null) {
                AbstractC7185ho.m43818a(HiAd.f33275a, "cur activity is: %s", activity.getClass().getSimpleName());
                HiAd.this.setCurActivity(activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    /* renamed from: com.huawei.openalliance.ad.inter.HiAd$11 */
    public class C723211 implements RemoteCallResultCallback<String> {
        public C723211() {
        }

        @Override // com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback
        public void onRemoteCallResult(String str, CallResult<String> callResult) {
            if (callResult != null) {
                try {
                    if (callResult.getCode() == 200) {
                        if (AbstractC7185ho.m43819a()) {
                            AbstractC7185ho.m43817a(HiAd.f33275a, "query account info from hms success!");
                        }
                        String data = callResult.getData();
                        if (AbstractC7806cz.m48165b(data)) {
                            if (AbstractC7185ho.m43819a()) {
                                AbstractC7185ho.m43817a(HiAd.f33275a, "receiveData is null");
                                return;
                            }
                            return;
                        }
                        JSONObject jSONObject = new JSONObject(data);
                        boolean zOptBoolean = jSONObject.optBoolean(Constants.IS_COPPA);
                        boolean zOptBoolean2 = jSONObject.optBoolean(Constants.IS_TFUA);
                        if (AbstractC7185ho.m43819a()) {
                            AbstractC7185ho.m43818a(HiAd.f33275a, "account info get from hms, coppa is %s, tfua is %s", Boolean.valueOf(zOptBoolean), Boolean.valueOf(zOptBoolean2));
                        }
                        C7787cg.m47900a(HiAd.this.f33286d).m47994h(zOptBoolean);
                        C7787cg.m47900a(HiAd.this.f33286d).m47997i(zOptBoolean2);
                        return;
                    }
                } catch (Throwable th2) {
                    AbstractC7185ho.m43827d(HiAd.f33275a, "get account info from hms err : %s", th2.getClass().getSimpleName());
                    return;
                }
            }
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43817a(HiAd.f33275a, "failed to query account info from hms");
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.inter.HiAd$12 */
    public class RunnableC723312 implements Runnable {
        public RunnableC723312() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C7350jx.m45424a(HiAd.this.f33286d).m45432c();
            Log.i(HiAd.f33275a, "prerequest.");
            int iMo43048Z = HiAd.this.f33287e.mo43048Z();
            boolean zM48576j = C7845x.m48576j(HiAd.this.f33286d);
            AbstractC7185ho.m43821b(HiAd.f33275a, "preRequest, type: %s, isTv: %s", Integer.valueOf(iMo43048Z), Boolean.valueOf(zM48576j));
            if (iMo43048Z == 1 || zM48576j) {
                C7118fb.m43196a(HiAd.this.f33286d).mo43276a(new AdPreReq());
            } else if (iMo43048Z == 2) {
                new NativeAdLoader(HiAd.this.f33286d, new String[]{ConfigMapKeys.CLCT_PRE_REQ}).loadAds(4, true);
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.inter.HiAd$13 */
    public class RunnableC723413 implements Runnable {
        public RunnableC723413() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Consent.getInstance(HiAd.this.f33286d).getNpaAccordingToServerConsent();
        }
    }

    /* renamed from: com.huawei.openalliance.ad.inter.HiAd$14 */
    public class RunnableC723514 implements Runnable {
        public RunnableC723514() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C6926g.m39168a(HiAd.this.f33286d);
            C7084e.m42835a(HiAd.this.f33286d);
            AbstractC7807d.m48191B(HiAd.this.f33286d);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.inter.HiAd$15 */
    public class RunnableC723615 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ boolean f33316a;

        /* renamed from: b */
        final /* synthetic */ String f33317b;

        /* renamed from: c */
        final /* synthetic */ boolean f33318c;

        public RunnableC723615(boolean z10, String str, boolean z11) {
            z = z10;
            str = str;
            z = z11;
        }

        @Override // java.lang.Runnable
        public void run() {
            HiAd.this.m44020a(z, str, z);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.inter.HiAd$16 */
    public class RunnableC723716 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ boolean f33320a;

        /* renamed from: b */
        final /* synthetic */ String f33321b;

        /* renamed from: c */
        final /* synthetic */ boolean f33322c;

        public RunnableC723716(boolean z10, String str, boolean z11) {
            z = z10;
            str = str;
            z = z11;
        }

        @Override // java.lang.Runnable
        public void run() {
            HiAd.this.m44020a(z, str, z);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.inter.HiAd$17 */
    public class RunnableC723817 implements Runnable {
        public RunnableC723817() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C7103es.m43094a(HiAd.this.f33286d).mo42990e();
            C7108ex.m43156a(HiAd.this.f33286d).mo42990e();
            C7130fn.m43543a(HiAd.this.f33286d).mo42990e();
            C7119fc.m43281a(HiAd.this.f33286d).mo42990e();
            HiAd.this.m44041z();
        }
    }

    /* renamed from: com.huawei.openalliance.ad.inter.HiAd$18 */
    public class RunnableC723918 implements Runnable {
        public RunnableC723918() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HiAd.this.m44040y();
            HiAd.this.m44033r();
            EnumC7338jl.m45325a().m45333a(HiAd.this.f33286d);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.inter.HiAd$2 */
    public class RunnableC72402 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ boolean f33326a;

        public RunnableC72402(boolean z10) {
            z = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C7561ov.m46639a()) {
                HiAd.this.m44023b(z);
            } else {
                AbstractC7185ho.m43823c(HiAd.f33275a, "ppskit api is not included");
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.inter.HiAd$3 */
    public class C72413 extends BroadcastReceiver {

        /* renamed from: com.huawei.openalliance.ad.inter.HiAd$3$1 */
        public class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Intent f33329a;

            /* renamed from: b */
            final /* synthetic */ Context f33330b;

            public AnonymousClass1(Intent intent2, Context context2) {
                intent = intent2;
                context = context2;
            }

            @Override // java.lang.Runnable
            public void run() {
                String action = intent.getAction();
                for (Map.Entry entry : HiAd.this.f33291i.entrySet()) {
                    BroadcastReceiver broadcastReceiver = (BroadcastReceiver) entry.getKey();
                    IntentFilter intentFilter = (IntentFilter) entry.getValue();
                    if (intentFilter != null && intentFilter.matchAction(action)) {
                        broadcastReceiver.onReceive(context, intent);
                    }
                }
            }
        }

        public C72413() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context2, Intent intent2) {
            if (intent2 == null) {
                return;
            }
            AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.inter.HiAd.3.1

                /* renamed from: a */
                final /* synthetic */ Intent f33329a;

                /* renamed from: b */
                final /* synthetic */ Context f33330b;

                public AnonymousClass1(Intent intent22, Context context22) {
                    intent = intent22;
                    context = context22;
                }

                @Override // java.lang.Runnable
                public void run() {
                    String action = intent.getAction();
                    for (Map.Entry entry : HiAd.this.f33291i.entrySet()) {
                        BroadcastReceiver broadcastReceiver = (BroadcastReceiver) entry.getKey();
                        IntentFilter intentFilter = (IntentFilter) entry.getValue();
                        if (intentFilter != null && intentFilter.matchAction(action)) {
                            broadcastReceiver.onReceive(context, intent);
                        }
                    }
                }
            });
        }
    }

    /* renamed from: com.huawei.openalliance.ad.inter.HiAd$4 */
    public class RunnableC72424 implements Runnable {
        public RunnableC72424() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C7785ce.m47890a(HiAd.this.f33286d).m47891a();
            C7076dt.m42678h().m42687j();
            HiAd hiAd = HiAd.this;
            hiAd.m44024c(hiAd.f33286d);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.inter.HiAd$5 */
    public class RunnableC72435 implements Runnable {
        public RunnableC72435() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C7785ce.m47890a(HiAd.this.f33286d).m47895b();
            C7076dt.m42678h().m42686i();
        }
    }

    /* renamed from: com.huawei.openalliance.ad.inter.HiAd$6 */
    public class RunnableC72446 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f33334a;

        public RunnableC72446(String str) {
            str = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            C7484ms.m45854a(HiAd.this.f33286d).m45855a(RTCMethods.SET_TCF_CONSENT_STRING, str, null, null);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.inter.HiAd$7 */
    public class RunnableC72457 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f33336a;

        public RunnableC72457(String str) {
            str = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            HiAd.this.f33288f.mo43268a(str);
            AbstractC7185ho.m43818a(HiAd.f33275a, "placementAdPreCfgReq slotId is: %s", str);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.inter.HiAd$8 */
    public class RunnableC72468 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ VideoConfiguration f33338a;

        /* renamed from: b */
        final /* synthetic */ boolean f33339b;

        /* renamed from: c */
        final /* synthetic */ boolean f33340c;

        /* renamed from: d */
        final /* synthetic */ int f33341d;

        public RunnableC72468(VideoConfiguration videoConfiguration, boolean z10, boolean z11, int i10) {
            videoConfiguration = videoConfiguration;
            z = z10;
            z = z11;
            i = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            new C6922c(HiAd.this.f33286d).m39064a(videoConfiguration, z, z, i);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.inter.HiAd$9 */
    public class CallableC72479 implements Callable<Map<String, List<String>>> {

        /* renamed from: a */
        final /* synthetic */ List f33343a;

        public CallableC72479(List list) {
            list = list;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Map<String, List<String>> call() {
            return C7128fl.m43510a(HiAd.this.f33286d).mo43533d(list);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.inter.HiAd$a */
    public static class C7248a implements RemoteCallResultCallback<String> {
        private C7248a() {
        }

        public /* synthetic */ C7248a(RunnableC72301 runnableC72301) {
            this();
        }

        @Override // com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback
        public void onRemoteCallResult(String str, CallResult<String> callResult) {
            if (callResult.getCode() == 200) {
                AbstractC7185ho.m43818a(HiAd.f33275a, "success: set app installed notify in hms, %s", str);
            } else {
                AbstractC7185ho.m43824c(HiAd.f33275a, "error: set app installed notify in hms, %s", str);
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.inter.HiAd$b */
    public static class C7249b implements InterfaceC8937e<EnableServiceResult> {
        private C7249b() {
        }

        public /* synthetic */ C7249b(RunnableC72301 runnableC72301) {
            this();
        }

        @Override // p208cq.InterfaceC8937e
        public void onComplete(Task<EnableServiceResult> task) {
            EnableServiceResult result;
            if (task == null || (result = task.getResult()) == null) {
                AbstractC7185ho.m43820b(HiAd.f33275a, "service enable result: false");
                return;
            }
            AbstractC7185ho.m43820b(HiAd.f33275a, "service enable result: " + result.isResult());
        }
    }

    /* renamed from: com.huawei.openalliance.ad.inter.HiAd$c */
    public static class C7250c implements RemoteCallResultCallback<String> {
        private C7250c() {
        }

        public /* synthetic */ C7250c(RunnableC72301 runnableC72301) {
            this();
        }

        @Override // com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback
        public void onRemoteCallResult(String str, CallResult<String> callResult) {
            if (callResult.getCode() == 200) {
                AbstractC7185ho.m43820b(HiAd.f33275a, "set kit AutoOpenForbidden success");
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.inter.HiAd$d */
    public static class RunnableC7251d implements Runnable {

        /* renamed from: a */
        private Context f33345a;

        public RunnableC7251d(Context context) {
            this.f33345a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            C7217ik.m43940a(this.f33345a);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.inter.HiAd$e */
    public static class RunnableC7252e implements Runnable {

        /* renamed from: a */
        private final AutoOpenListener f33346a;

        public RunnableC7252e(AutoOpenListener autoOpenListener) {
            this.f33346a = autoOpenListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            C7045d.m42344a().m42346a(this.f33346a);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.inter.HiAd$f */
    public static class RunnableC7253f implements Runnable {

        /* renamed from: a */
        private final AppDownloadListenerV1 f33347a;

        public RunnableC7253f(AppDownloadListenerV1 appDownloadListenerV1) {
            this.f33347a = appDownloadListenerV1;
        }

        @Override // java.lang.Runnable
        public void run() {
            C7045d.m42344a().m42348a(this.f33347a);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.inter.HiAd$g */
    public static class RunnableC7254g implements Runnable {

        /* renamed from: a */
        private final AppDownloadListener f33348a;

        public RunnableC7254g(AppDownloadListener appDownloadListener) {
            this.f33348a = appDownloadListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            C7045d.m42344a().m42347a(this.f33348a);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.inter.HiAd$h */
    public static class RunnableC7255h implements Runnable {

        /* renamed from: a */
        private final IPPSWebEventCallback f33349a;

        public RunnableC7255h(IPPSWebEventCallback iPPSWebEventCallback) {
            this.f33349a = iPPSWebEventCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            C7517nl.m46150a().m46151a(this.f33349a);
        }
    }

    private HiAd(Context context) {
        this.f33286d = context.getApplicationContext();
        String str = f33275a;
        Log.i(str, "HiAd init");
        m44032q();
        InterfaceC7146gc interfaceC7146gcM43316b = C7124fh.m43316b(this.f33286d);
        this.f33287e = interfaceC7146gcM43316b;
        boolean zMo43345aL = interfaceC7146gcM43316b.mo43345aL();
        AbstractC7834m.m48479a(new Runnable() { // from class: com.huawei.openalliance.ad.inter.HiAd.1

            /* renamed from: a */
            final /* synthetic */ Context f33309a;

            public RunnableC72301(Context context2) {
                context = context2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (C6982bz.m41152b(context)) {
                    IntentFilter intentFilter = new IntentFilter(Constants.ACTION_EXSPLASH_START_LINKED);
                    Intent intentM47537a = AbstractC7741ao.m47537a(HiAd.this.f33286d, null, intentFilter, Constants.PERMISSION_PPS_DOWNLOAD, null);
                    if (intentM47537a != null && intentM47537a.getAction() != null && intentM47537a.getAction().equals(Constants.ACTION_EXSPLASH_START_LINKED)) {
                        Log.d(HiAd.f33275a, "HiAd: getIntent");
                        new C7287b(HiAd.this.f33286d).onReceive(HiAd.this.f33286d, intentM47537a);
                    }
                    AbstractC7741ao.m47537a(HiAd.this.f33286d, new C7287b(HiAd.this.f33286d), intentFilter, Constants.PERMISSION_PPS_DOWNLOAD, null);
                }
                C7288c.m44224a(HiAd.this.f33286d).m44231b();
                C7798cr.m48109a(HiAd.this.f33286d);
                AbstractC7804cx.m48138a(HiAd.this.f33286d);
            }
        });
        this.f33288f = C7118fb.m43196a(this.f33286d);
        RunnableC7813df.m48356a(new C6922c(context2));
        m44010C();
        if (zMo43345aL) {
            m44039x();
            AbstractC7759bf.m47762a(this.f33286d);
            m44034s();
            m44035t();
            if (!WhiteListPkgList.accInitPkgList(context2)) {
                AbstractC7834m.m48481b(new RunnableC7251d(context2));
            }
            C7735ai.m47489c(this.f33286d);
            C7812de.m48352a(context2);
        }
        if (!WhiteListPkgList.accInitPkgList(context2)) {
            m44036u();
        }
        m44011D();
        Log.i(str, "HiAd init end");
    }

    /* renamed from: A */
    private void m44008A() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(AbstractC7803cw.m48136f(this.f33286d));
        String str = File.separator;
        sb2.append(str);
        sb2.append(Constants.PPS_ROOT_PATH);
        sb2.append(str);
        String string = sb2.toString();
        if (!AbstractC7806cz.m48165b(string)) {
            AbstractC7731ae.m47444a(string);
        }
        C7019dh.m41938a();
    }

    /* renamed from: B */
    private void m44009B() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(AbstractC7803cw.m48137g(this.f33286d));
        String str = File.separator;
        sb2.append(str);
        sb2.append(Constants.PPS_ROOT_PATH);
        sb2.append(str);
        String string = sb2.toString();
        if (AbstractC7806cz.m48165b(string)) {
            return;
        }
        AbstractC7731ae.m47444a(string);
    }

    /* renamed from: C */
    private void m44010C() {
        C7046e.m42359a(this.f33286d);
        C7076dt.m42669a(this.f33286d);
    }

    /* renamed from: D */
    private void m44011D() {
        if (WhiteListPkgList.isHwBrowserPkgName(this.f33286d.getPackageName())) {
            ((Application) this.f33286d.getApplicationContext()).registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.huawei.openalliance.ad.inter.HiAd.10
                public C723110() {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityCreated(Activity activity, Bundle bundle) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPaused(Activity activity) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityResumed(Activity activity) {
                    if (activity != null) {
                        AbstractC7185ho.m43818a(HiAd.f33275a, "cur activity is: %s", activity.getClass().getSimpleName());
                        HiAd.this.setCurActivity(activity);
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStarted(Activity activity) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStopped(Activity activity) {
                }
            });
        }
    }

    @OuterVisible
    public static void disableUserInfo(Context context) {
        String str = f33275a;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("disableUserInfo, context ");
        sb2.append(context == null ? "is null" : "not null");
        Log.i(str, sb2.toString());
        if (context == null) {
            return;
        }
        C7124fh.m43316b(context).mo43373b(false);
        getInstance(context).enableUserInfo(false);
    }

    @OuterVisible
    public static IHiAd getInstance(Context context) {
        return m44022b(context);
    }

    @OuterVisible
    public static boolean isOaidAvaiable(Context context) {
        String strM48207a;
        try {
            strM48207a = AbstractC7807d.m48207a(context, C7830i.m48434e(context));
        } catch (Throwable th2) {
            Log.i(f33275a, "isOaidAvaiable error: " + th2.getClass().getSimpleName());
        }
        if (strM48207a == null) {
            return false;
        }
        return Integer.parseInt(strM48207a) >= 50005300;
    }

    /* renamed from: q */
    private void m44032q() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        AbstractC7741ao.m47536a(this.f33286d, this.f33285H, intentFilter);
    }

    /* renamed from: r */
    public void m44033r() {
        if (System.currentTimeMillis() - this.f33287e.mo43439cj() > 86400000) {
            C7484ms.m45854a(this.f33286d).m45855a(RTCMethods.QUERY_ACCOUNT_INFO, null, new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.inter.HiAd.11
                public C723211() {
                }

                @Override // com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback
                public void onRemoteCallResult(String str, CallResult<String> callResult) {
                    if (callResult != null) {
                        try {
                            if (callResult.getCode() == 200) {
                                if (AbstractC7185ho.m43819a()) {
                                    AbstractC7185ho.m43817a(HiAd.f33275a, "query account info from hms success!");
                                }
                                String data = callResult.getData();
                                if (AbstractC7806cz.m48165b(data)) {
                                    if (AbstractC7185ho.m43819a()) {
                                        AbstractC7185ho.m43817a(HiAd.f33275a, "receiveData is null");
                                        return;
                                    }
                                    return;
                                }
                                JSONObject jSONObject = new JSONObject(data);
                                boolean zOptBoolean = jSONObject.optBoolean(Constants.IS_COPPA);
                                boolean zOptBoolean2 = jSONObject.optBoolean(Constants.IS_TFUA);
                                if (AbstractC7185ho.m43819a()) {
                                    AbstractC7185ho.m43818a(HiAd.f33275a, "account info get from hms, coppa is %s, tfua is %s", Boolean.valueOf(zOptBoolean), Boolean.valueOf(zOptBoolean2));
                                }
                                C7787cg.m47900a(HiAd.this.f33286d).m47994h(zOptBoolean);
                                C7787cg.m47900a(HiAd.this.f33286d).m47997i(zOptBoolean2);
                                return;
                            }
                        } catch (Throwable th2) {
                            AbstractC7185ho.m43827d(HiAd.f33275a, "get account info from hms err : %s", th2.getClass().getSimpleName());
                            return;
                        }
                    }
                    if (AbstractC7185ho.m43819a()) {
                        AbstractC7185ho.m43817a(HiAd.f33275a, "failed to query account info from hms");
                    }
                }
            }, String.class);
            this.f33287e.mo43477n(System.currentTimeMillis());
        } else if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43817a(f33275a, "query account info frequently");
        }
    }

    /* renamed from: s */
    private void m44034s() {
        AbstractC7834m.m48481b(new Runnable() { // from class: com.huawei.openalliance.ad.inter.HiAd.12
            public RunnableC723312() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C7350jx.m45424a(HiAd.this.f33286d).m45432c();
                Log.i(HiAd.f33275a, "prerequest.");
                int iMo43048Z = HiAd.this.f33287e.mo43048Z();
                boolean zM48576j = C7845x.m48576j(HiAd.this.f33286d);
                AbstractC7185ho.m43821b(HiAd.f33275a, "preRequest, type: %s, isTv: %s", Integer.valueOf(iMo43048Z), Boolean.valueOf(zM48576j));
                if (iMo43048Z == 1 || zM48576j) {
                    C7118fb.m43196a(HiAd.this.f33286d).mo43276a(new AdPreReq());
                } else if (iMo43048Z == 2) {
                    new NativeAdLoader(HiAd.this.f33286d, new String[]{ConfigMapKeys.CLCT_PRE_REQ}).loadAds(4, true);
                }
            }
        });
    }

    /* renamed from: t */
    private void m44035t() {
        if (AbstractC7741ao.m47575e()) {
            AbstractC7834m.m48479a(new Runnable() { // from class: com.huawei.openalliance.ad.inter.HiAd.13
                public RunnableC723413() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    Consent.getInstance(HiAd.this.f33286d).getNpaAccordingToServerConsent();
                }
            });
        }
    }

    /* renamed from: u */
    private void m44036u() {
        AbstractC7834m.m48479a(new Runnable() { // from class: com.huawei.openalliance.ad.inter.HiAd.14
            public RunnableC723514() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C6926g.m39168a(HiAd.this.f33286d);
                C7084e.m42835a(HiAd.this.f33286d);
                AbstractC7807d.m48191B(HiAd.this.f33286d);
            }
        });
    }

    /* renamed from: v */
    private long m44037v() {
        int iM41891n;
        if (m44038w() && (iM41891n = AbstractC7014dc.m41891n()) <= 10) {
            AbstractC7014dc.m41865a(iM41891n + 1);
            return 0L;
        }
        int iMo43353aT = this.f33287e.mo43353aT();
        if (C6982bz.m41148a(this.f33286d).mo41184m()) {
            AbstractC7185ho.m43817a(f33275a, "testDeviceConfigRefreshInterval in use.");
            iMo43353aT = this.f33287e.mo43023A();
        }
        return iMo43353aT * 60000;
    }

    /* renamed from: w */
    private boolean m44038w() {
        if (!C6982bz.m41148a(this.f33286d).mo41185n()) {
            return false;
        }
        AbstractC7185ho.m43817a(f33275a, "device ready for refresh config");
        return true;
    }

    /* renamed from: x */
    private void m44039x() {
        AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.inter.HiAd.18
            public RunnableC723918() {
            }

            @Override // java.lang.Runnable
            public void run() {
                HiAd.this.m44040y();
                HiAd.this.m44033r();
                EnumC7338jl.m45325a().m45333a(HiAd.this.f33286d);
            }
        });
    }

    /* renamed from: y */
    public void m44040y() {
        C7787cg c7787cgM47900a = C7787cg.m47900a(this.f33286d);
        c7787cgM47900a.m47948a();
        if (TextUtils.isEmpty(c7787cgM47900a.m47998j())) {
            c7787cgM47900a.m47990g(C7845x.m48532a(this.f33286d));
        }
        C7019dh.m41937a(this.f33286d, Constants.NORMAL_CACHE);
        C7019dh.m41937a(this.f33286d, Constants.AR_CACHE);
    }

    /* renamed from: z */
    public void m44041z() {
        m44008A();
        m44009B();
    }

    @Override // com.huawei.openalliance.p169ad.inter.InterfaceC7308f
    /* renamed from: c */
    public IMultiMediaPlayingManager mo44049c() {
        IMultiMediaPlayingManager iMultiMediaPlayingManager = this.f33290h;
        return iMultiMediaPlayingManager != null ? iMultiMediaPlayingManager : C7468a.m45812a(this.f33286d);
    }

    @Override // com.huawei.openalliance.p169ad.inter.InterfaceC7308f
    /* renamed from: d */
    public Context mo44051d() {
        return this.f33286d;
    }

    @Override // com.huawei.openalliance.p169ad.inter.IHiAd
    public void enableSharePd(boolean z10) {
        if (AbstractC7741ao.m47562b(this.f33286d)) {
            this.f33287e.mo43429c(z10);
        }
    }

    @Override // com.huawei.openalliance.p169ad.inter.IHiAd
    public void enableUserInfo(boolean z10) {
        if (AbstractC7741ao.m47562b(this.f33286d)) {
            this.f33287e.mo43373b(z10);
            mo44046a(z10);
            if (z10) {
                m44039x();
            } else {
                AbstractC7834m.m48479a(new Runnable() { // from class: com.huawei.openalliance.ad.inter.HiAd.17
                    public RunnableC723817() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        C7103es.m43094a(HiAd.this.f33286d).mo42990e();
                        C7108ex.m43156a(HiAd.this.f33286d).mo42990e();
                        C7130fn.m43543a(HiAd.this.f33286d).mo42990e();
                        C7119fc.m43281a(HiAd.this.f33286d).mo42990e();
                        HiAd.this.m44041z();
                    }
                });
            }
            if (C7736aj.m47496a()) {
                C7800ct.m48114a().m48116a(this.f33286d, z10);
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.inter.IHiAd
    public void enableVideoCacheWhenPlay(int i10, boolean z10) {
        AbstractC7185ho.m43821b(f33275a, "enableVideoCacheWhenPlay, type: %s, enable: %s", Integer.valueOf(i10), Boolean.valueOf(z10));
        this.f33278A.put(Integer.valueOf(i10), Boolean.valueOf(z10));
    }

    @Override // com.huawei.openalliance.p169ad.inter.InterfaceC7308f
    /* renamed from: f */
    public IExSplashCallback mo44053f() {
        return this.f33297o;
    }

    @Override // com.huawei.openalliance.p169ad.inter.IHiAd
    public IAdInvalidHandler getAdInvalidHandler() {
        return this.f33282E;
    }

    @Override // com.huawei.openalliance.p169ad.inter.IHiAd
    public int getAppActivateStyle() {
        return this.f33307y;
    }

    @Override // com.huawei.openalliance.p169ad.inter.IHiAd
    public IAppDownloadManager getAppDownloadManager() {
        if (this.f33292j == null) {
            this.f33292j = new C7055l();
        }
        return this.f33292j;
    }

    @Override // com.huawei.openalliance.p169ad.inter.IHiAd
    public IAskForUnlockScreen getAskForUnlockScreen() {
        return this.f33284G;
    }

    @Override // com.huawei.openalliance.p169ad.inter.IHiAd
    public Activity getCurActivity() {
        WeakReference<Activity> weakReference = this.f33283F;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // com.huawei.openalliance.p169ad.inter.IHiAd
    public String getEngineVer() {
        String strM42836a = C7084e.m42836a();
        AbstractC7185ho.m43821b(f33275a, "engineVer: %s", strM42836a);
        return strM42836a;
    }

    @Override // com.huawei.openalliance.p169ad.inter.IHiAd
    public ExtensionActionListener getExtensionActionListener() {
        return this.f33298p;
    }

    @Override // com.huawei.openalliance.p169ad.inter.IHiAd
    public IPPSDownloadService getPPSDownloadService() {
        return this.f33281D;
    }

    @Override // com.huawei.openalliance.p169ad.inter.IHiAd
    public RequestOptions getRequestConfiguration() {
        if (this.f33303u == null) {
            this.f33303u = new RequestOptions.Builder().build();
        }
        return this.f33303u;
    }

    @Override // com.huawei.openalliance.p169ad.inter.IHiAd
    public Map<String, List<String>> getTemplates(List<String> list) {
        Map<String, List<String>> map = (Map) AbstractC7810dc.m48272b(new Callable<Map<String, List<String>>>() { // from class: com.huawei.openalliance.ad.inter.HiAd.9

            /* renamed from: a */
            final /* synthetic */ List f33343a;

            public CallableC72479(List list2) {
                list = list2;
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Map<String, List<String>> call() {
                return C7128fl.m43510a(HiAd.this.f33286d).mo43533d(list);
            }
        });
        if (!C7765bl.m47802a(map)) {
            return map;
        }
        AbstractC7185ho.m43820b(f33275a, "slotTemplates is empty.");
        return null;
    }

    @Override // com.huawei.openalliance.p169ad.inter.InterfaceC7308f
    /* renamed from: h */
    public int mo44055h() {
        return this.f33299q;
    }

    @Override // com.huawei.openalliance.p169ad.inter.InterfaceC7308f
    /* renamed from: i */
    public int mo44056i() {
        return this.f33300r;
    }

    @Override // com.huawei.openalliance.p169ad.inter.IHiAd
    public void informReady() {
        BinderC7289d.m44236a(this.f33286d).m44243b();
    }

    @Override // com.huawei.openalliance.p169ad.inter.IHiAd
    public void initGrs(String str) {
        C7800ct.m48114a().m48122c(str);
        if (C7736aj.m47496a()) {
            C7800ct.m48114a().m48115a(this.f33286d);
        }
    }

    @Override // com.huawei.openalliance.p169ad.inter.IHiAd
    public void initLog(boolean z10, int i10) {
        initLog(z10, i10, null);
    }

    @Override // com.huawei.openalliance.p169ad.inter.IHiAd
    public void initOptions(Context context) {
        AbstractC7834m.m48481b(new RunnableC7251d(context));
        m44036u();
    }

    @Override // com.huawei.openalliance.p169ad.inter.IHiAd
    public boolean isAppAutoOpenForbidden() {
        return this.f33287e.mo43397bX();
    }

    @Override // com.huawei.openalliance.p169ad.inter.IHiAd
    public boolean isAppInstalledNotify() {
        return this.f33306x;
    }

    @Override // com.huawei.openalliance.p169ad.inter.IHiAd
    public boolean isEnableUserInfo() {
        if (AbstractC7741ao.m47562b(this.f33286d)) {
            return this.f33287e.mo43345aL();
        }
        return false;
    }

    @Override // com.huawei.openalliance.p169ad.inter.IHiAd
    public boolean isVideoCacheWhenPlay(int i10) {
        if (this.f33278A.containsKey(Integer.valueOf(i10))) {
            return this.f33278A.get(Integer.valueOf(i10)).booleanValue();
        }
        return false;
    }

    @Override // com.huawei.openalliance.p169ad.inter.InterfaceC7308f
    /* renamed from: j */
    public Integer mo44057j() {
        return this.f33304v;
    }

    @Override // com.huawei.openalliance.p169ad.inter.InterfaceC7308f
    /* renamed from: k */
    public boolean mo44058k() {
        return this.f33305w;
    }

    @Override // com.huawei.openalliance.p169ad.inter.InterfaceC7308f
    /* renamed from: l */
    public AppStatusQuery mo44059l() {
        return this.f33308z;
    }

    @Override // com.huawei.openalliance.p169ad.inter.InterfaceC7308f
    /* renamed from: m */
    public boolean mo44060m() {
        return this.f33280C;
    }

    @Override // com.huawei.openalliance.p169ad.inter.InterfaceC7308f
    /* renamed from: n */
    public boolean mo44061n() {
        if (!C7845x.m48605t(this.f33286d)) {
            return false;
        }
        boolean zMo43062aj = C7124fh.m43316b(this.f33286d).mo43062aj();
        AbstractC7185ho.m43821b(f33275a, "isSetSurfaceFirst: %s", Boolean.valueOf(zMo43062aj));
        return zMo43062aj;
    }

    @Override // com.huawei.openalliance.p169ad.inter.IHiAd
    public void notifyUiModeChange(int i10) {
        try {
            AbstractC7185ho.m43821b(f33275a, "ui mode: %d", Integer.valueOf(i10));
            C7124fh.m43316b(this.f33286d).mo43474m(i10);
            Intent intent = new Intent(Constants.UI_CHANGE_ACTION);
            intent.setPackage(this.f33286d.getPackageName());
            this.f33286d.sendBroadcast(intent);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c(f33275a, "set ui mode err, %s", th2.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.p169ad.inter.InterfaceC7308f
    /* renamed from: o */
    public Boolean mo44062o() {
        return this.f33279B;
    }

    @Override // com.huawei.openalliance.p169ad.inter.IHiAd
    public void onBackground() {
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.inter.HiAd.5
            public RunnableC72435() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C7785ce.m47890a(HiAd.this.f33286d).m47895b();
                C7076dt.m42678h().m42686i();
            }
        });
    }

    @Override // com.huawei.openalliance.p169ad.inter.IHiAd
    public void onForeground() {
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.inter.HiAd.4
            public RunnableC72424() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C7785ce.m47890a(HiAd.this.f33286d).m47891a();
                C7076dt.m42678h().m42687j();
                HiAd hiAd = HiAd.this;
                hiAd.m44024c(hiAd.f33286d);
            }
        });
    }

    @Override // com.huawei.openalliance.p169ad.inter.IHiAd
    public void placementAdPreCfgReq() {
        AbstractC7834m.m48481b(new Runnable() { // from class: com.huawei.openalliance.ad.inter.HiAd.7

            /* renamed from: a */
            final /* synthetic */ String f33336a;

            public RunnableC72457(String str) {
                str = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                HiAd.this.f33288f.mo43268a(str);
                AbstractC7185ho.m43818a(HiAd.f33275a, "placementAdPreCfgReq slotId is: %s", str);
            }
        });
    }

    @Override // com.huawei.openalliance.p169ad.inter.IHiAd
    @Deprecated
    public void requestConfig(String str) {
    }

    @Override // com.huawei.openalliance.p169ad.inter.IHiAd
    public void setAdInvalidHandler(IAdInvalidHandler iAdInvalidHandler) {
        this.f33282E = iAdInvalidHandler;
    }

    @Override // com.huawei.openalliance.p169ad.inter.IHiAd
    public void setAppActivateStyle(int i10) {
        this.f33307y = i10;
        AbstractC7185ho.m43818a(f33275a, "set app activate style: %s", Integer.valueOf(i10));
        m44019a(this.f33306x, this.f33307y, MapKeyNames.ACTIVATE_NOTIFY_STYLE);
    }

    @Override // com.huawei.openalliance.p169ad.inter.IHiAd
    public void setAppAutoOpenForbidden(boolean z10) {
        AbstractC7185ho.m43820b(f33275a, "set app AutoOpenForbidden: " + z10);
        this.f33287e.mo43451e(z10);
        C7038f.m42206a(this.f33286d, z10, new C7250c(), String.class);
    }

    @Override // com.huawei.openalliance.p169ad.inter.IHiAd
    public void setAppDownloadListener(AppDownloadListener appDownloadListener) {
        this.f33293k = appDownloadListener;
        AbstractC7817dj.m48363a(new RunnableC7254g(appDownloadListener));
    }

    @Override // com.huawei.openalliance.p169ad.inter.IHiAd
    public void setAppInstalledNotify(boolean z10) {
        this.f33306x = z10;
        AbstractC7185ho.m43818a(f33275a, "set app installed notify: %s", Boolean.valueOf(z10));
        m44019a(this.f33306x, this.f33307y, MapKeyNames.FULL_SCREEN_NOTIFY);
    }

    @Override // com.huawei.openalliance.p169ad.inter.IHiAd
    public void setAppStatusQuery(AppStatusQuery appStatusQuery) {
        this.f33308z = appStatusQuery;
    }

    @Override // com.huawei.openalliance.p169ad.inter.IHiAd
    public void setAskForUnlockScreen(IAskForUnlockScreen iAskForUnlockScreen) {
        this.f33284G = iAskForUnlockScreen;
    }

    @Override // com.huawei.openalliance.p169ad.inter.IHiAd
    public void setAutoOpenListener(AutoOpenListener autoOpenListener) {
        this.f33295m = autoOpenListener;
        AbstractC7817dj.m48363a(new RunnableC7252e(autoOpenListener));
    }

    @Override // com.huawei.openalliance.p169ad.inter.IHiAd
    public void setBrand(int i10) {
        this.f33304v = Integer.valueOf(i10);
    }

    @Override // com.huawei.openalliance.p169ad.inter.IHiAd
    public void setBrowserAppDownloadListener(AppDownloadListenerV1 appDownloadListenerV1) {
        this.f33294l = appDownloadListenerV1;
        AbstractC7817dj.m48363a(new RunnableC7253f(appDownloadListenerV1));
    }

    @Override // com.huawei.openalliance.p169ad.inter.IHiAd
    public void setConsent(String str) {
        AbstractC7185ho.m43820b(f33275a, "set TCF consent string");
        AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.inter.HiAd.6

            /* renamed from: a */
            final /* synthetic */ String f33334a;

            public RunnableC72446(String str2) {
                str = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                C7484ms.m45854a(HiAd.this.f33286d).m45855a(RTCMethods.SET_TCF_CONSENT_STRING, str, null, null);
            }
        });
    }

    @Override // com.huawei.openalliance.p169ad.inter.IHiAd
    public void setCountryCode(String str) {
        this.f33287e.mo43478n(str);
    }

    @Override // com.huawei.openalliance.p169ad.inter.IHiAd
    public void setCurActivity(Activity activity) {
        if (activity != null) {
            this.f33283F = new WeakReference<>(activity);
        }
    }

    @Override // com.huawei.openalliance.p169ad.inter.IHiAd
    public void setCustomSSLSocketFactory(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager) {
        HttpsConfig.m45965a(sSLSocketFactory);
        HttpsConfig.m45966a(x509TrustManager);
    }

    @Override // com.huawei.openalliance.p169ad.inter.IHiAd
    public void setExLinkedAdListener(LinkedAdListener linkedAdListener) {
        this.f33301s = linkedAdListener;
    }

    @Override // com.huawei.openalliance.p169ad.inter.IHiAd
    public void setExSplashCallback(IExSplashCallback iExSplashCallback, int i10, int i11) {
        this.f33297o = iExSplashCallback;
        this.f33299q = i10;
        this.f33300r = i11;
    }

    @Override // com.huawei.openalliance.p169ad.inter.IHiAd
    public void setExtensionActionListener(ExtensionActionListener extensionActionListener) {
        this.f33298p = extensionActionListener;
    }

    @Override // com.huawei.openalliance.p169ad.inter.IHiAd
    public void setImageLoader(IImageLoader iImageLoader) {
        C7082a.m42807a().m42808a(iImageLoader);
    }

    @Override // com.huawei.openalliance.p169ad.inter.IHiAd
    public void setIsPreloadWebView(boolean z10) {
        this.f33280C = z10;
    }

    @Override // com.huawei.openalliance.p169ad.inter.IHiAd
    public void setLandingPageAction(LandingPageAction landingPageAction) {
        this.f33289g = landingPageAction;
    }

    @Override // com.huawei.openalliance.p169ad.inter.IHiAd
    public void setMultiMediaPlayingManager(IMultiMediaPlayingManager iMultiMediaPlayingManager) {
        this.f33290h = iMultiMediaPlayingManager;
    }

    @Override // com.huawei.openalliance.p169ad.inter.IHiAd
    public void setOpenLinkStatus(boolean z10) {
        this.f33305w = z10;
    }

    @Override // com.huawei.openalliance.p169ad.inter.IHiAd
    public void setOpenWebPageByBrowser(boolean z10) {
        this.f33279B = Boolean.valueOf(z10);
    }

    @Override // com.huawei.openalliance.p169ad.inter.IHiAd
    public void setPPSDownloadService(IPPSDownloadService iPPSDownloadService) {
        this.f33281D = iPPSDownloadService;
    }

    @Override // com.huawei.openalliance.p169ad.inter.IHiAd
    public void setPPSWebListener(IPPSWebEventCallback iPPSWebEventCallback) {
        this.f33296n = iPPSWebEventCallback;
        AbstractC7817dj.m48363a(new RunnableC7255h(iPPSWebEventCallback));
    }

    @Override // com.huawei.openalliance.p169ad.inter.IHiAd
    public void setRequestConfiguration(RequestOptions requestOptions) {
        this.f33303u = requestOptions;
    }

    @Override // com.huawei.openalliance.p169ad.inter.IHiAd
    public void setVideoAutoPlayNet(int i10) {
        try {
            AbstractC7185ho.m43821b(f33275a, "net type: %d", Integer.valueOf(i10));
            C7124fh.m43316b(this.f33286d).mo43472l(i10);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c(f33275a, "set net err, %s", th2.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.p169ad.inter.IHiAd
    public void syncMediaGrs(String str, String str2) {
        C7800ct.m48114a().m48120b(str2);
        initGrs(str);
    }

    /* renamed from: a */
    public static InterfaceC7308f m44013a() {
        return f33276b;
    }

    /* renamed from: b */
    private static HiAd m44022b(Context context) {
        HiAd hiAd;
        synchronized (f33277c) {
            try {
                if (f33276b == null) {
                    f33276b = new HiAd(context);
                }
                hiAd = f33276b;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return hiAd;
    }

    /* renamed from: c */
    public void m44024c(Context context) {
        boolean zM48346v = AbstractC7811dd.m48346v(context);
        AbstractC7185ho.m43818a(f33275a, "has install permission is: %s", Boolean.valueOf(zM48346v));
        C7038f.m42210b(context.getApplicationContext(), zM48346v, new C7248a(), String.class);
    }

    @Override // com.huawei.openalliance.p169ad.inter.InterfaceC7308f
    /* renamed from: e */
    public boolean mo44052e() {
        boolean z10 = this.f33302t != Process.myPid();
        if (z10) {
            this.f33302t = Process.myPid();
        }
        AbstractC7185ho.m43820b(f33275a, "isNewProcess:" + z10);
        return z10;
    }

    @Override // com.huawei.openalliance.p169ad.inter.InterfaceC7308f
    /* renamed from: g */
    public LinkedAdListener mo44054g() {
        return this.f33301s;
    }

    @Override // com.huawei.openalliance.p169ad.inter.IHiAd
    public void initGrs(String str, String str2) {
        if (!C6982bz.m41152b(this.f33286d)) {
            C7800ct.m48114a().m48117a(str2);
        }
        initGrs(str);
    }

    @Override // com.huawei.openalliance.p169ad.inter.IHiAd
    public void initLog(boolean z10, int i10, String str) {
        if (AbstractC7741ao.m47562b(this.f33286d) && z10) {
            AbstractC7763bj.m47799a(this.f33286d, i10, str);
        }
    }

    /* renamed from: a */
    public static InterfaceC7308f m44014a(Context context) {
        return m44022b(context);
    }

    /* renamed from: d */
    private void m44027d(String str) {
        int iMo43290a = C7120fd.m43288a(this.f33286d).mo43290a(str);
        if (iMo43290a == 2 || iMo43290a == 3) {
            AbstractC7185ho.m43820b(f33275a, "invoke kit req sdk config");
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("slotid", str);
                jSONObject.put("sdk_type", AbstractC7807d.m48190A(this.f33286d));
                jSONObject.put(MapKeyNames.UI_ENGINE_VERSION, C7084e.m42836a());
                C7484ms.m45854a(this.f33286d).m45855a(RTCMethods.REQUEST_SDK_CONFIG, jSONObject.toString(), null, String.class);
            } catch (Throwable th2) {
                AbstractC7185ho.m43824c(f33275a, "invoke kit req config failed: %s", th2.getClass().getSimpleName());
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.inter.InterfaceC7308f
    /* renamed from: b */
    public LandingPageAction mo44047b() {
        return this.f33289g;
    }

    @Override // com.huawei.openalliance.p169ad.inter.InterfaceC7308f
    /* renamed from: a */
    public void mo44042a(BroadcastReceiver broadcastReceiver) {
        if (broadcastReceiver == null) {
            return;
        }
        this.f33291i.remove(broadcastReceiver);
    }

    @Override // com.huawei.openalliance.p169ad.inter.InterfaceC7308f
    /* renamed from: b */
    public void mo44048b(String str) {
        m44018a(str, true, true, true);
    }

    @Override // com.huawei.openalliance.p169ad.inter.InterfaceC7308f
    /* renamed from: c */
    public void mo44050c(String str) {
        m44018a(str, false, false, true);
    }

    /* renamed from: b */
    public void m44023b(boolean z10) {
        AbstractC7185ho.m43820b(f33275a, "enable service: " + z10);
        HwPPS.getInstance(this.f33286d).confirmAgreement(z10).addOnCompleteListener(new C7249b());
    }

    @Override // com.huawei.openalliance.p169ad.inter.InterfaceC7308f
    /* renamed from: a */
    public void mo44043a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (broadcastReceiver == null) {
            return;
        }
        this.f33291i.put(broadcastReceiver, intentFilter);
    }

    @Override // com.huawei.openalliance.p169ad.inter.InterfaceC7308f
    /* renamed from: a */
    public void mo44044a(VideoConfiguration videoConfiguration, boolean z10, boolean z11, int i10) {
        AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.inter.HiAd.8

            /* renamed from: a */
            final /* synthetic */ VideoConfiguration f33338a;

            /* renamed from: b */
            final /* synthetic */ boolean f33339b;

            /* renamed from: c */
            final /* synthetic */ boolean f33340c;

            /* renamed from: d */
            final /* synthetic */ int f33341d;

            public RunnableC72468(VideoConfiguration videoConfiguration2, boolean z102, boolean z112, int i102) {
                videoConfiguration = videoConfiguration2;
                z = z102;
                z = z112;
                i = i102;
            }

            @Override // java.lang.Runnable
            public void run() {
                new C6922c(HiAd.this.f33286d).m39064a(videoConfiguration, z, z, i);
            }
        });
    }

    @Override // com.huawei.openalliance.p169ad.inter.InterfaceC7308f
    /* renamed from: a */
    public void mo44045a(String str) {
        m44018a(str, true, false, false);
    }

    /* renamed from: a */
    private void m44018a(String str, boolean z10, boolean z11, boolean z12) {
        if (AbstractC7741ao.m47562b(this.f33286d)) {
            if (AbstractC7806cz.m48165b(str)) {
                AbstractC7185ho.m43826d(f33275a, "adId is empty, please check it!");
            } else if (z12) {
                AbstractC7834m.m48483c(new Runnable() { // from class: com.huawei.openalliance.ad.inter.HiAd.15

                    /* renamed from: a */
                    final /* synthetic */ boolean f33316a;

                    /* renamed from: b */
                    final /* synthetic */ String f33317b;

                    /* renamed from: c */
                    final /* synthetic */ boolean f33318c;

                    public RunnableC723615(boolean z112, String str2, boolean z102) {
                        z = z112;
                        str = str2;
                        z = z102;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        HiAd.this.m44020a(z, str, z);
                    }
                });
            } else {
                AbstractC7834m.m48481b(new Runnable() { // from class: com.huawei.openalliance.ad.inter.HiAd.16

                    /* renamed from: a */
                    final /* synthetic */ boolean f33320a;

                    /* renamed from: b */
                    final /* synthetic */ String f33321b;

                    /* renamed from: c */
                    final /* synthetic */ boolean f33322c;

                    public RunnableC723716(boolean z112, String str2, boolean z102) {
                        z = z112;
                        str = str2;
                        z = z102;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        HiAd.this.m44020a(z, str, z);
                    }
                });
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.inter.InterfaceC7308f
    /* renamed from: a */
    public void mo44046a(boolean z10) {
        AbstractC7834m.m48479a(new Runnable() { // from class: com.huawei.openalliance.ad.inter.HiAd.2

            /* renamed from: a */
            final /* synthetic */ boolean f33326a;

            public RunnableC72402(boolean z102) {
                z = z102;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (C7561ov.m46639a()) {
                    HiAd.this.m44023b(z);
                } else {
                    AbstractC7185ho.m43823c(HiAd.f33275a, "ppskit api is not included");
                }
            }
        });
    }

    /* renamed from: a */
    private void m44019a(boolean z10, int i10, String str) {
        C7038f.m42205a(this.f33286d.getApplicationContext(), z10, i10, str, new C7248a(), String.class);
    }

    /* renamed from: a */
    public void m44020a(boolean z10, String str, boolean z11) {
        try {
            long jMo43471l = z10 ? this.f33287e.mo43471l(str) : this.f33287e.mo43354aU();
            long jM44037v = m44037v();
            if (!z11 || System.currentTimeMillis() - jMo43471l > jM44037v) {
                AppConfigRsp appConfigRspMo43268a = this.f33288f.mo43268a(str);
                if (appConfigRspMo43268a != null && appConfigRspMo43268a.responseCode == 0 && 200 == appConfigRspMo43268a.m40925k()) {
                    this.f33287e.mo43013a(str, appConfigRspMo43268a, z10);
                    SdkCfgSha256Record sdkCfgSha256Record = new SdkCfgSha256Record();
                    sdkCfgSha256Record.m41817a(this.f33286d.getPackageName());
                    sdkCfgSha256Record.m41819b(appConfigRspMo43268a.m40902Y());
                    C7122ff.m43303a(this.f33286d).m43307a(sdkCfgSha256Record);
                    AbstractC7185ho.m43818a(f33275a, "sha256 save to databases, sha256 is %s", appConfigRspMo43268a.m40902Y());
                    C7019dh.m41937a(this.f33286d, Constants.NORMAL_CACHE).m41966b(this.f33287e.mo43374bA().longValue());
                    C7019dh.m41937a(this.f33286d, Constants.AR_CACHE).m41966b(this.f33287e.mo43374bA().longValue());
                    m44027d(str);
                } else if (appConfigRspMo43268a != null && 206 == appConfigRspMo43268a.m40925k()) {
                    if (z10) {
                        this.f33287e.mo43012a(str, System.currentTimeMillis());
                    } else {
                        this.f33287e.mo43449e(System.currentTimeMillis());
                    }
                    AbstractC7185ho.m43820b(f33275a, "SDK get config is no change");
                }
            }
            if (C7736aj.m47496a()) {
                C7800ct.m48114a().m48115a(this.f33286d);
            }
        } catch (Throwable th2) {
            String str2 = f33275a;
            AbstractC7185ho.m43820b(str2, "RC get exception");
            AbstractC7185ho.m43814a(3, str2, th2);
        }
    }
}
