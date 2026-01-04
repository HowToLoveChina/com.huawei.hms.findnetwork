package p258ei;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Toast;
import ba.C1148b;
import ba.C1159m;
import ca.C1400c;
import com.huawei.android.hicloud.agd.ads.AdParametersExt;
import com.huawei.cloud.banner.manager.FrontAppDownloadManager;
import com.huawei.cloud.banner.receiver.FrontAppOpenReceiver;
import com.huawei.cloud.pay.R$string;
import com.huawei.cloud.pay.model.AcceptRightGiftResp;
import com.huawei.cloud.pay.model.ActivityEntry;
import com.huawei.cloud.pay.model.GetActivityEntryResp;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.receiver.CommonNotifyReceiver;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hms.feature.dynamic.InterfaceC5323b;
import com.huawei.hms.network.embedded.C6148x2;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.openalliance.p169ad.download.app.AppStatus;
import com.huawei.openalliance.p169ad.inter.HiAd;
import com.huawei.openalliance.p169ad.inter.IAppDownloadManager;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.inter.data.INativeAd;
import com.huawei.openalliance.p169ad.inter.listeners.AppDownloadListener;
import dj.C9158a;
import fi.C9710b;
import fi.C9711c;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import org.json.JSONException;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0216g0;
import p222da.C9058b;
import p258ei.C9494c;
import p329h7.C10121i;
import p336he.C10152c;
import p341hj.C10221d1;
import p422k9.C11019b;
import p454lj.C11289l;
import p454lj.C11296s;
import p514o9.C11839m;
import p616rk.C12515a;
import p684un.C13227f;
import p684un.C13230i;
import p709vj.C13452e;

/* renamed from: ei.c */
/* loaded from: classes.dex */
public class C9494c {

    /* renamed from: l */
    public static String f47280l;

    /* renamed from: m */
    public static String f47281m;

    /* renamed from: n */
    public static C9494c f47282n = new C9494c();

    /* renamed from: o */
    public static Handler f47283o = new a(Looper.getMainLooper());

    /* renamed from: p */
    public static AppDownloadListener f47284p = new b();

    /* renamed from: b */
    public boolean f47286b;

    /* renamed from: d */
    public String f47288d;

    /* renamed from: e */
    public String f47289e;

    /* renamed from: f */
    public ActivityEntry f47290f;

    /* renamed from: g */
    public C1159m f47291g;

    /* renamed from: i */
    public boolean f47293i;

    /* renamed from: j */
    public AppStatus f47294j;

    /* renamed from: k */
    public Toast f47295k;

    /* renamed from: a */
    public boolean f47285a = false;

    /* renamed from: c */
    public FrontAppOpenReceiver f47287c = new FrontAppOpenReceiver();

    /* renamed from: h */
    public boolean f47292h = true;

    /* renamed from: ei.c$a */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (7009 != i10) {
                if (7010 == i10) {
                    C11839m.m70688i("FrontAppManager", "accept right gift fail, msg: " + message.toString());
                    if (message.arg1 == 1010) {
                        C9494c.m59376I(message);
                        return;
                    }
                    return;
                }
                return;
            }
            Object obj = message.obj;
            if (!(obj instanceof AcceptRightGiftResp)) {
                C11839m.m70687e("FrontAppManager", "processAcceptRightGiftSuccess, msg obj is not AcceptRightGiftResp");
                return;
            }
            C11839m.m70688i("FrontAppManager", "accept right gift success, msg: " + message.toString());
            if (((AcceptRightGiftResp) obj).getResultCode() == 0) {
                C9494c.m59390r().m59406T();
                if (C9494c.m59390r().f47285a) {
                    C9494c.f47281m = C9494c.f47280l;
                }
            }
        }
    }

    /* renamed from: ei.c$b */
    public class b implements AppDownloadListener {
        @Override // com.huawei.openalliance.p169ad.inter.listeners.AppDownloadListener
        public void onAppOpen(String str) {
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.AppDownloadListener
        public void onDownloadProgress(AppInfo appInfo, int i10) {
            C11839m.m70688i("FrontAppManager", "onDownloadProgress: packageName: " + appInfo.getPackageName() + ", progress: " + i10);
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.AppDownloadListener
        public void onStatusChanged(AppStatus appStatus, AppInfo appInfo) {
            if (appInfo == null) {
                C11839m.m70688i("FrontAppManager", "onStatusChanged, appInfo is null");
                return;
            }
            String packageName = appInfo.getPackageName();
            C11839m.m70688i("FrontAppManager", "onStatusChanged: packageName: " + packageName + ", status: " + appStatus);
            if (!C9494c.m59390r().m59421p(packageName)) {
                C11839m.m70688i("FrontAppManager", "onStatusChanged, check package name fail");
                return;
            }
            C9494c.m59390r().m59409W(appStatus);
            int i10 = e.f47304a[appStatus.ordinal()];
            if (i10 == 1) {
                C9494c.m59390r().m59415b0(true);
                C9494c.m59390r().m59404R(appStatus);
            } else {
                if (i10 != 2) {
                    return;
                }
                C9494c.m59390r().m59399L(appStatus);
                if (C9494c.m59390r().f47285a) {
                    return;
                }
                C9494c.m59390r().m59407U();
            }
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.AppDownloadListener
        public void onUserCancel(AppInfo appInfo) {
            if (appInfo != null) {
                C11839m.m70688i("FrontAppManager", "onUserCancel: " + appInfo.getPackageName());
            }
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.AppDownloadListener
        public void onAppOpen(AppInfo appInfo) {
            if (appInfo == null) {
                C11839m.m70688i("FrontAppManager", "onAppOpen, appInfo is null");
                return;
            }
            String packageName = appInfo.getPackageName();
            C11839m.m70688i("FrontAppManager", "onAppOpen: packageName: " + packageName + " , isAppIntroductionSence = " + C9494c.m59390r().f47285a + " , tmpAppName = " + C9494c.f47280l + " , mPreviousAppName = " + C9494c.f47281m);
            if (C9494c.m59390r().m59421p(packageName)) {
                if (!C9494c.m59390r().f47285a) {
                    C11839m.m70688i("FrontAppManager", "onAppOpen is not AppIntroductionSence.");
                    C9494c.m59390r().m59414b(packageName);
                } else {
                    if (C9494c.m59374C(C9494c.f47281m, packageName)) {
                        C11839m.m70688i("FrontAppManager", "onAppOpen is PreviousAppName, not acceptRightGift.");
                        return;
                    }
                    C11839m.m70688i("FrontAppManager", "onAppOpen is not PreviousAppName.");
                    C9494c.f47280l = packageName;
                    C9494c.m59390r().m59414b(packageName);
                }
            }
        }
    }

    /* renamed from: ei.c$c */
    public class c extends Handler {

        /* renamed from: a */
        public final /* synthetic */ String f47296a;

        /* renamed from: b */
        public final /* synthetic */ C1159m f47297b;

        /* renamed from: c */
        public final /* synthetic */ String f47298c;

        /* renamed from: d */
        public final /* synthetic */ CountDownLatch f47299d;

        /* renamed from: e */
        public final /* synthetic */ AdParametersExt f47300e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Looper looper, String str, C1159m c1159m, String str2, CountDownLatch countDownLatch, AdParametersExt adParametersExt) {
            super(looper);
            this.f47296a = str;
            this.f47297b = c1159m;
            this.f47298c = str2;
            this.f47299d = countDownLatch;
            this.f47300e = adParametersExt;
        }

        /* renamed from: b */
        public static /* synthetic */ void m59432b(C1159m c1159m, CountDownLatch countDownLatch, List list) {
            c1159m.m7249n(C0209d.m1205R0(list) ? 7016 : 7018);
            countDownLatch.countDown();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws JSONException {
            int i10 = message.what;
            if (i10 != 7017) {
                if (i10 == 7018) {
                    this.f47297b.m7249n(7018);
                    this.f47299d.countDown();
                    return;
                }
                AdParametersExt adParametersExt = this.f47300e;
                if (adParametersExt == null || !adParametersExt.isRequestAgdResource(0, null)) {
                    this.f47297b.m7249n(7016);
                    this.f47299d.countDown();
                    return;
                } else {
                    final C1159m c1159m = this.f47297b;
                    final CountDownLatch countDownLatch = this.f47299d;
                    C12515a.m75110o().m75175e(new C10221d1(new Consumer() { // from class: ei.d
                        @Override // java.util.function.Consumer
                        public final void accept(Object obj) {
                            C9494c.c.m59432b(c1159m, countDownLatch, (List) obj);
                        }
                    }, this.f47300e.getAgdAdid()), false);
                    return;
                }
            }
            Object obj = message.obj;
            if (obj instanceof C1148b) {
                C1148b c1148b = (C1148b) obj;
                INativeAd iNativeAdM7215a = c1148b.m7215a();
                C1400c.m8061h(iNativeAdM7215a, this.f47296a);
                this.f47297b.m7245j(iNativeAdM7215a);
                this.f47297b.m7249n(7017);
                this.f47297b.m7248m(this.f47298c);
                this.f47297b.m7243h(c1148b.m7217c());
                String strM7219e = c1148b.m7219e();
                if (strM7219e == null) {
                    strM7219e = "";
                }
                this.f47297b.m7247l(strM7219e);
                INativeAd iNativeAdM7216b = c1148b.m7216b();
                C1400c.m8061h(iNativeAdM7216b, this.f47296a);
                this.f47297b.m7246k(iNativeAdM7216b);
                this.f47297b.m7244i(c1148b.m7218d());
                FrontAppDownloadManager.m28137j().m28144k(this.f47297b);
                C9494c.this.f47291g = this.f47297b;
                C9494c.this.m59413a0();
                C9494c.m59390r().m59408V(false);
            } else {
                this.f47297b.m7249n(7016);
            }
            this.f47299d.countDown();
        }
    }

    /* renamed from: ei.c$d */
    public class d implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Intent f47302a;

        public d(Intent intent) {
            this.f47302a = intent;
        }

        @Override // java.lang.Runnable
        public void run() {
            C12515a.m75110o().m75172d(new C9710b(C9494c.this.f47291g, this.f47302a));
        }
    }

    /* renamed from: ei.c$e */
    public static /* synthetic */ class e {

        /* renamed from: a */
        public static final /* synthetic */ int[] f47304a;

        static {
            int[] iArr = new int[AppStatus.values().length];
            f47304a = iArr;
            try {
                iArr[AppStatus.WAITING_FOR_WIFI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f47304a[AppStatus.INSTALLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* renamed from: C */
    public static boolean m59374C(String str, String str2) {
        if (TextUtils.isEmpty(str) || !str.equals(str2)) {
            return false;
        }
        C11839m.m70688i("FrontAppManager", "isPreviousAppName , appName = " + str2);
        return true;
    }

    /* renamed from: D */
    public static /* synthetic */ void m59375D(String str, int i10) {
        m59390r().m59416c(str, i10);
    }

    /* renamed from: I */
    public static void m59376I(Message message) {
        C11839m.m70688i("FrontAppManager", "processReportCampaignLaunchRetry");
        if (message == null) {
            C11839m.m70689w("FrontAppManager", "msg null");
            return;
        }
        Bundle data = message.getData();
        if (data == null) {
            C11839m.m70689w("FrontAppManager", "data null");
            return;
        }
        final String string = data.getString("adPackageName");
        int i10 = data.getInt("retryCount");
        if (string == null) {
            C11839m.m70689w("FrontAppManager", "appPackageName null");
            return;
        }
        if (i10 > 2) {
            C11839m.m70689w("FrontAppManager", "retry end");
            return;
        }
        long j10 = i10 == 1 ? 5000L : i10 == 2 ? 10000L : 0L;
        final int i11 = i10 + 1;
        Handler handler = f47283o;
        if (handler != null) {
            handler.postDelayed(new Runnable() { // from class: ei.b
                @Override // java.lang.Runnable
                public final void run() {
                    C9494c.m59375D(string, i11);
                }
            }, j10);
        }
    }

    /* renamed from: M */
    public static void m59377M(String str, LinkedHashMap<String, String> linkedHashMap) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put(C6148x2.DEVICE_ID, C13452e.m80781L().m80954p());
        if (linkedHashMap != null) {
            linkedHashMapM79497A.putAll(linkedHashMap);
        }
        C13227f.m79492i1().m79567R(str, linkedHashMapM79497A);
        UBAAnalyze.m29947H("PVC", str, linkedHashMapM79497A);
    }

    /* renamed from: r */
    public static C9494c m59390r() {
        return f47282n;
    }

    /* renamed from: A */
    public C1159m m59391A() {
        return this.f47291g;
    }

    /* renamed from: B */
    public final boolean m59392B() {
        return AppStatus.DOWNLOADING.equals(this.f47294j);
    }

    /* renamed from: E */
    public void m59393E() {
        C11839m.m70688i("FrontAppManager", "onDialogClose, mCurrentAppStatus = " + this.f47294j + ", mUsedChooseWaitWlan = " + this.f47293i + ", isAppIntroductionSence = " + this.f47285a);
        if (!m59392B() || this.f47293i || this.f47285a) {
            return;
        }
        m59418d0();
    }

    /* renamed from: F */
    public void m59394F() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70687e("FrontAppManager", "onDialogGotoOtherPage, context is null");
        } else if (m59392B()) {
            m59417c0(contextM1377a.getString(R$string.front_app_toast_background_download));
        }
    }

    /* renamed from: G */
    public void m59395G(AppStatus appStatus) {
        if (AppStatus.INSTALLED == appStatus) {
            C11839m.m70688i("FrontAppManager", "onDownloadButtonClick, open app, cancel notice");
            C10152c.m63217a();
        }
    }

    /* renamed from: H */
    public void m59396H(String str) {
        C1159m c1159m = this.f47291g;
        if (c1159m == null || c1159m.m7236a() == null) {
            C11839m.m70687e("FrontAppManager", "need open app, but matchResult or ad is null");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            C11839m.m70687e("FrontAppManager", "need open app, but packageName is null");
            return;
        }
        if (!str.equals(this.f47291g.m7238c())) {
            C11839m.m70687e("FrontAppManager", "need open app, but packageName not equal");
            return;
        }
        INativeAd iNativeAdM7236a = this.f47291g.m7236a();
        if (iNativeAdM7236a == null) {
            C11839m.m70687e("FrontAppManager", "need open app, but ad is null");
        } else {
            if (!C0209d.m1184K0(C0213f.m1377a(), str)) {
                C11839m.m70687e("FrontAppManager", "need open app, but app not installed");
                return;
            }
            m59411Y(iNativeAdM7236a);
            m59402P();
            m59422q().startDownload(C0213f.m1377a(), iNativeAdM7236a);
        }
    }

    /* renamed from: J */
    public void m59397J() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70687e("FrontAppManager", "context is null");
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.huawei.hicloud.intent.action.ACTION_FRONT_APP_OPEN");
        FrontAppOpenReceiver frontAppOpenReceiver = this.f47287c;
        if (frontAppOpenReceiver != null) {
            frontAppOpenReceiver.m29111a(contextM1377a, intentFilter);
        }
    }

    /* renamed from: K */
    public void m59398K() {
        if (this.f47291g == null) {
            C11839m.m70687e("FrontAppManager", "reportAcceptNotifyShow, match result is null");
            return;
        }
        try {
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
            linkedHashMap.put("app_package_name", this.f47291g.m7238c());
            m59420o(linkedHashMap);
            m59377M("accept_gift_notify_show", linkedHashMap);
        } catch (Exception e10) {
            C11839m.m70687e("FrontAppManager", "reportAcceptNotifyShow exception, e: " + e10.toString());
        }
    }

    /* renamed from: L */
    public void m59399L(AppStatus appStatus) {
        if (this.f47291g == null) {
            C11839m.m70687e("FrontAppManager", "reportAppInstalledStatus, match result is null");
            return;
        }
        try {
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
            linkedHashMap.put("app_status", String.valueOf(appStatus));
            linkedHashMap.put("app_package_name", this.f47291g.m7238c());
            m59420o(linkedHashMap);
            m59377M("app_installed_success", linkedHashMap);
        } catch (Exception e10) {
            C11839m.m70687e("FrontAppManager", "reportAppInstalledStatus exception, e: " + e10.toString());
        }
    }

    /* renamed from: N */
    public void m59400N(AppStatus appStatus) {
        if (this.f47291g == null) {
            C11839m.m70687e("FrontAppManager", "report download button click fail, match result is null");
            return;
        }
        try {
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
            linkedHashMap.put("app_status", String.valueOf(appStatus));
            linkedHashMap.put("app_package_name", this.f47291g.m7238c());
            m59420o(linkedHashMap);
            m59377M("click_download_button", linkedHashMap);
        } catch (Exception e10) {
            C11839m.m70687e("FrontAppManager", "report download button click exception, e: " + e10.toString());
        }
    }

    /* renamed from: O */
    public void m59401O() {
        try {
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
            m59420o(linkedHashMap);
            m59377M("front_entrance_click", linkedHashMap);
        } catch (Exception e10) {
            C11839m.m70687e("FrontAppManager", "reportFrontEntranceClick exception, e: " + e10.toString());
        }
    }

    /* renamed from: P */
    public void m59402P() {
        if (this.f47291g == null) {
            C11839m.m70687e("FrontAppManager", "reportOpenAppNotifyClick, match result is null");
            return;
        }
        try {
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
            linkedHashMap.put("app_package_name", this.f47291g.m7238c());
            m59420o(linkedHashMap);
            m59377M("app_installed_notify_click", linkedHashMap);
        } catch (Exception e10) {
            C11839m.m70687e("FrontAppManager", "reportOpenAppNotifyClick exception, e: " + e10.toString());
        }
    }

    /* renamed from: Q */
    public void m59403Q() {
        if (this.f47291g == null) {
            C11839m.m70687e("FrontAppManager", "reportOpenAppNotifyShow, match result is null");
            return;
        }
        try {
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
            linkedHashMap.put("app_package_name", this.f47291g.m7238c());
            m59420o(linkedHashMap);
            m59377M("app_installed_notify_show", linkedHashMap);
        } catch (Exception e10) {
            C11839m.m70687e("FrontAppManager", "reportOpenAppNotifyShow exception, e: " + e10.toString());
        }
    }

    /* renamed from: R */
    public void m59404R(AppStatus appStatus) {
        if (this.f47291g == null) {
            C11839m.m70687e("FrontAppManager", "reportWaitWlanStatus, match result is null");
            return;
        }
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("app_status", String.valueOf(appStatus));
            linkedHashMap.put("app_package_name", this.f47291g.m7238c());
            m59377M("click_wait_wlan", linkedHashMap);
        } catch (Exception e10) {
            C11839m.m70687e("FrontAppManager", "reportWaitWlanStatus exception, e: " + e10.toString());
        }
    }

    /* renamed from: S */
    public void m59405S(AppStatus appStatus) {
        if (this.f47291g == null) {
            C11839m.m70687e("FrontAppManager", "report wait wlan dialog show, match result is null");
            return;
        }
        try {
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
            linkedHashMap.put("app_status", String.valueOf(appStatus));
            linkedHashMap.put("app_package_name", this.f47291g.m7238c());
            m59420o(linkedHashMap);
            m59377M("wait_wlan_dialog_show", linkedHashMap);
        } catch (Exception e10) {
            C11839m.m70687e("FrontAppManager", "report wait wlan dialog show exception, e: " + e10.toString());
        }
    }

    /* renamed from: T */
    public final void m59406T() {
        if (this.f47291g == null) {
            C11839m.m70687e("FrontAppManager", "matchResult is null, not send accept notify");
            return;
        }
        Intent intent = new Intent();
        intent.setClass(C0213f.m1377a(), C11019b.m66371t().m66441r("CloudSpaceUpgradeActivity"));
        intent.putExtra("is_from_front_app_notify", true);
        if (this.f47286b) {
            intent.putExtra("is_v5_scene", true);
        }
        intent.putExtra("nav_source", 14);
        intent.putExtra(HNConstants.C4906BI.BI_NOTIFY_TYPE, "9");
        intent.putExtra("app_package_name", this.f47291g.m7238c());
        C0216g0.m1402e(C0213f.m1377a()).m1408F(intent, "SOURCE_ID_FRONT_APP_ACCEPT_GIFT_NOTIFY");
        f47283o.postDelayed(new d(intent), 5000L);
    }

    /* renamed from: U */
    public final void m59407U() {
        if (this.f47292h) {
            C11839m.m70687e("FrontAppManager", "mIsDialogExist is true, not send installed notify");
            return;
        }
        if (this.f47291g == null) {
            C11839m.m70687e("FrontAppManager", "matchResult is null, not send installed notify");
            return;
        }
        Intent intent = new Intent();
        intent.setClass(C0213f.m1377a(), CommonNotifyReceiver.class);
        intent.setAction(CommonNotifyReceiver.COMMON_ACTION);
        intent.putExtra("requestId", 10004);
        intent.putExtra("appPackageName", this.f47291g.m7238c());
        C12515a.m75110o().m75172d(new C9711c(this.f47291g, intent));
    }

    /* renamed from: V */
    public void m59408V(boolean z10) {
        this.f47285a = z10;
    }

    /* renamed from: W */
    public final void m59409W(AppStatus appStatus) {
        this.f47294j = appStatus;
    }

    /* renamed from: X */
    public void m59410X(boolean z10) {
        this.f47292h = z10;
    }

    /* renamed from: Y */
    public final void m59411Y(INativeAd iNativeAd) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        try {
            AppInfo appInfo = iNativeAd.getAppInfo();
            Field declaredField = AppInfo.class.getDeclaredField(JsbMapKeyNames.ALLOWED_NON_WIFI_NETWORK);
            declaredField.setAccessible(true);
            declaredField.setBoolean(appInfo, true);
        } catch (Exception e10) {
            C11839m.m70687e("FrontAppManager", "setNoWifiEnable exception: " + e10.toString());
        }
    }

    /* renamed from: Z */
    public void m59412Z(boolean z10) {
        this.f47286b = z10;
    }

    /* renamed from: a0 */
    public void m59413a0() {
        HiAd.getInstance(C0213f.m1377a()).setAppDownloadListener(f47284p);
    }

    /* renamed from: b */
    public final void m59414b(String str) {
        m59416c(str, 0);
    }

    /* renamed from: b0 */
    public final void m59415b0(boolean z10) {
        this.f47293i = z10;
    }

    /* renamed from: c */
    public final void m59416c(String str, int i10) {
        C11839m.m70688i("FrontAppManager", "acceptRightGift");
        HashMap map = new HashMap();
        map.put("cType", "dlApp");
        map.put(NotifyConstants.MarketingConstant.CID_KEY, this.f47288d);
        map.put("adId", this.f47289e);
        map.put("appId", str);
        map.put("version", String.valueOf(4));
        map.put("wildcard", String.valueOf(1));
        C9158a.m57503F().m57529a(f47283o, map, str, i10);
    }

    /* renamed from: c0 */
    public final void m59417c0(CharSequence charSequence) {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70687e("FrontAppManager", "show toast error, context is null, text: " + ((Object) charSequence));
            return;
        }
        C11839m.m70686d("FrontAppManager", "show toast, text: " + ((Object) charSequence));
        if (this.f47295k != null) {
            C11839m.m70686d("FrontAppManager", "mToast is not null, text: " + ((Object) charSequence));
            this.f47295k.cancel();
        }
        Toast toastMakeText = Toast.makeText(contextM1377a.getApplicationContext(), charSequence, 1);
        this.f47295k = toastMakeText;
        toastMakeText.show();
    }

    /* renamed from: d0 */
    public void m59418d0() {
        C1159m c1159m = this.f47291g;
        if (c1159m == null || c1159m.m7236a() == null) {
            C11839m.m70687e("FrontAppManager", "need stop download app, but matchResult or ad is null");
        } else {
            m59422q().pauseDownload(C0213f.m1377a(), this.f47291g.m7236a());
        }
    }

    /* renamed from: e0 */
    public void m59419e0() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70687e("FrontAppManager", "context is null");
            return;
        }
        FrontAppOpenReceiver frontAppOpenReceiver = this.f47287c;
        if (frontAppOpenReceiver != null) {
            frontAppOpenReceiver.m29112b(contextM1377a);
        }
    }

    /* renamed from: o */
    public void m59420o(LinkedHashMap<String, String> linkedHashMap) {
        if (!this.f47286b || linkedHashMap == null) {
            return;
        }
        linkedHashMap.put("v5_dialog_version_key", InterfaceC5323b.f24693t);
    }

    /* renamed from: p */
    public final boolean m59421p(String str) {
        if (this.f47291g == null) {
            C11839m.m70687e("FrontAppManager", "mMatchResult is null, checkPackageName fail");
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            C11839m.m70687e("FrontAppManager", "appPackageName is null, checkPackageName fail");
            return false;
        }
        if (str.equals(this.f47291g.m7238c())) {
            return true;
        }
        C11839m.m70687e("FrontAppManager", "appPackageName not equal, checkPackageName fail");
        return false;
    }

    /* renamed from: q */
    public IAppDownloadManager m59422q() {
        HiAd.getInstance(C0213f.m1377a()).setAppDownloadListener(f47284p);
        return HiAd.getInstance(C0213f.m1377a()).getAppDownloadManager();
    }

    /* renamed from: s */
    public ActivityEntry m59423s() {
        return this.f47290f;
    }

    /* renamed from: t */
    public INativeAd m59424t() {
        C1159m c1159m = this.f47291g;
        if (c1159m == null) {
            return null;
        }
        return c1159m.m7236a();
    }

    /* renamed from: u */
    public String m59425u() {
        C1159m c1159m = this.f47291g;
        if (c1159m == null) {
            return null;
        }
        return c1159m.m7238c();
    }

    /* renamed from: v */
    public INativeAd m59426v() {
        C1159m c1159m = this.f47291g;
        if (c1159m == null) {
            return null;
        }
        return c1159m.m7237b();
    }

    /* renamed from: w */
    public String m59427w() {
        C1159m c1159m = this.f47291g;
        if (c1159m == null) {
            return null;
        }
        return c1159m.m7239d();
    }

    /* renamed from: x */
    public C1159m m59428x(long j10) {
        C1159m c1159m = new C1159m();
        GetActivityEntryResp getActivityEntryRespM67733g = C11289l.m67733g(j10, NotifyConstants.MarketingConstant.CSOURCE_VALUE_BACKUP_FAIL_NOTIFICATION_POPUP);
        if (getActivityEntryRespM67733g == null) {
            C11839m.m70687e("FrontAppManager", "getMatchedAds error, getActivityEntry response is null");
            return c1159m;
        }
        ActivityEntry entry = getActivityEntryRespM67733g.getEntry();
        if (entry == null) {
            C11839m.m70687e("FrontAppManager", "getMatchedAds error, activityEntry is null");
            return c1159m;
        }
        String resource = entry.getResource();
        String str = entry.getcId();
        AdParametersExt adParametersExt = entry.getCampaignInfo().getAdParametersExt();
        if (adParametersExt == null) {
            C11839m.m70686d("FrontAppManager", "checkPpsAdsIsOk, but campaignInfo is null");
            return c1159m;
        }
        String preAppAdid = adParametersExt.getPreAppAdid();
        C10121i.m63036b(adParametersExt);
        if (TextUtils.isEmpty(resource) || TextUtils.isEmpty(preAppAdid) || TextUtils.isEmpty(str)) {
            C11839m.m70687e("FrontAppManager", "getMatchedAds error, resourceId or adId or cid is null");
            return c1159m;
        }
        this.f47288d = str;
        this.f47289e = preAppAdid;
        this.f47290f = entry;
        boolean zM67815g = C11296s.m67815g(entry);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        C12515a.m75110o().m75175e(new C9058b(resource, preAppAdid, new c(Looper.getMainLooper(), str, c1159m, resource, countDownLatch, adParametersExt), zM67815g), false);
        try {
            if (!countDownLatch.await(30L, TimeUnit.SECONDS)) {
                C11839m.m70686d("FrontAppManager", "wait not finish");
            }
        } catch (InterruptedException unused) {
            C11839m.m70689w("FrontAppManager", "syncLock wait catch InterruptedException.");
        }
        return c1159m;
    }

    /* renamed from: y */
    public List<INativeAd> m59429y(int i10) {
        ArrayList arrayList = new ArrayList();
        if (i10 <= 0) {
            return arrayList;
        }
        INativeAd iNativeAdM59424t = m59424t();
        String strM59425u = m59425u();
        if (iNativeAdM59424t != null && strM59425u != null && FrontAppDownloadManager.m28137j().m28141f(strM59425u)) {
            arrayList.add(iNativeAdM59424t);
        }
        INativeAd iNativeAdM59426v = m59426v();
        String strM59427w = m59427w();
        if (iNativeAdM59426v != null && strM59427w != null && FrontAppDownloadManager.m28137j().m28141f(strM59427w)) {
            arrayList.add(iNativeAdM59426v);
        }
        return arrayList.size() > i10 ? arrayList.subList(0, i10) : arrayList;
    }

    /* renamed from: z */
    public String m59430z() {
        return this.f47289e;
    }
}
