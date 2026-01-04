package p651t8;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import ck.C1443a;
import com.google.gson.Gson;
import com.huawei.cloud.pay.model.HiCloudNativeAd;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hms.network.embedded.C6148x2;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import com.huawei.openalliance.p169ad.download.app.AppStatus;
import com.huawei.openalliance.p169ad.inter.HiAd;
import com.huawei.openalliance.p169ad.inter.IAppDownloadManager;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.inter.listeners.AppDownloadListener;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import p015ak.C0213f;
import p015ak.C0234s;
import p020ap.C1007b;
import p429kk.C11058a;
import p514o9.C11839m;
import p684un.C13227f;
import p684un.C13230i;
import p709vj.C13452e;

/* renamed from: t8.e */
/* loaded from: classes2.dex */
public class C12997e {

    /* renamed from: a */
    public static Activity f59166a;

    /* renamed from: b */
    public static Handler f59167b;

    /* renamed from: c */
    public static String f59168c;

    /* renamed from: d */
    public static String f59169d;

    /* renamed from: e */
    public static String f59170e;

    /* renamed from: f */
    public static String f59171f;

    /* renamed from: g */
    public static String f59172g;

    /* renamed from: h */
    public static String f59173h;

    /* renamed from: i */
    public static String f59174i;

    /* renamed from: j */
    public static final AppDownloadListener f59175j = new a();

    /* renamed from: t8.e$b */
    public static /* synthetic */ class b {

        /* renamed from: a */
        public static final /* synthetic */ int[] f59176a;

        static {
            int[] iArr = new int[AppStatus.values().length];
            f59176a = iArr;
            try {
                iArr[AppStatus.PAUSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f59176a[AppStatus.RESUME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f59176a[AppStatus.INSTALL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f59176a[AppStatus.WAITING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f59176a[AppStatus.DOWNLOAD.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f59176a[AppStatus.INSTALLED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f59176a[AppStatus.DOWNLOADED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f59176a[AppStatus.INSTALLING.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f59176a[AppStatus.DOWNLOADING.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f59176a[AppStatus.DOWNLOADFAILED.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f59176a[AppStatus.WAITING_FOR_WIFI.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    /* renamed from: A */
    public static void m78007A(String str) {
        f59170e = str;
    }

    /* renamed from: f */
    public static void m78013f() {
        Message message = new Message();
        message.what = 101;
        Handler handler = f59167b;
        if (handler != null) {
            handler.sendMessage(message);
        }
    }

    /* renamed from: g */
    public static void m78014g(String str) {
        Message message = new Message();
        message.what = 100;
        Bundle bundle = new Bundle();
        bundle.putString("javascript", str);
        message.setData(bundle);
        Handler handler = f59167b;
        if (handler != null) {
            handler.sendMessage(message);
        }
    }

    /* renamed from: h */
    public static Activity m78015h() {
        return f59166a;
    }

    /* renamed from: i */
    public static IAppDownloadManager m78016i() {
        C11839m.m70686d("CampaignH5AdsManager", "setAppDownloadListener");
        HiAd.getInstance(C0213f.m1377a()).setAppDownloadListener(f59175j);
        return HiAd.getInstance(C0213f.m1377a()).getAppDownloadManager();
    }

    /* renamed from: j */
    public static String m78017j(AppStatus appStatus) {
        switch (b.f59176a[appStatus.ordinal()]) {
            case 1:
                return "PAUSE";
            case 2:
                return "RESUME";
            case 3:
                return "INSTALL";
            case 4:
                return "WAITING";
            case 5:
                return "DOWNLOAD";
            case 6:
                return "INSTALLED";
            case 7:
                return "DOWNLOADED";
            case 8:
                return "INSTALLING";
            case 9:
                return "DOWNLOADING";
            case 10:
                return "DOWNLOADFAILED";
            case 11:
                return "WAITING_FOR_WIFI";
            default:
                return "";
        }
    }

    /* renamed from: k */
    public static String m78018k() {
        return f59173h;
    }

    /* renamed from: l */
    public static Handler m78019l() {
        return f59167b;
    }

    /* renamed from: m */
    public static String m78020m(String str) {
        return '\"' + str + '\"';
    }

    /* renamed from: n */
    public static String m78021n() {
        return f59174i;
    }

    /* renamed from: o */
    public static String m78022o() {
        return f59168c;
    }

    /* renamed from: p */
    public static String m78023p() {
        return f59169d;
    }

    /* renamed from: q */
    public static String m78024q(String str) {
        HashMap map = new HashMap();
        map.put(CommonConstant.ReqAccessTokenParam.LANGUAGE_LABEL, C0234s.m1631i());
        map.put("Accept-Language", C0234s.m1631i());
        map.put("ClientVersion", C1443a.f6213a);
        map.put("Device", Build.MODEL);
        String strM80921h0 = C13452e.m80781L().m80921h0();
        String strM66627b = C11058a.m66627b(str);
        map.put("Country", strM80921h0);
        map.put("x-hw-trace-id", strM66627b);
        map.put("DeviceType", C13452e.m80781L().m80970t());
        map.put("DeviceID", C13452e.m80781L().m80954p());
        map.put("UserID", C13452e.m80781L().m80971t0());
        return new Gson().toJson(map);
    }

    /* renamed from: r */
    public static void m78025r(String str, LinkedHashMap<String, String> linkedHashMap) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put(C6148x2.DEVICE_ID, C13452e.m80781L().m80954p());
        if (linkedHashMap != null) {
            linkedHashMapM79497A.putAll(linkedHashMap);
        }
        C13227f.m79492i1().m79567R(str, linkedHashMapM79497A);
        UBAAnalyze.m29947H("CKC", str, linkedHashMapM79497A);
    }

    /* renamed from: s */
    public static void m78026s(Activity activity) {
        f59166a = activity;
    }

    /* renamed from: t */
    public static void m78027t(String str) {
        f59173h = str;
    }

    /* renamed from: u */
    public static void m78028u(Handler handler) {
        f59167b = handler;
    }

    /* renamed from: v */
    public static void m78029v(String str) {
        f59174i = str;
    }

    /* renamed from: w */
    public static void m78030w(String str) {
        f59172g = str;
    }

    /* renamed from: x */
    public static void m78031x(String str) {
        f59171f = str;
    }

    /* renamed from: y */
    public static void m78032y(String str) {
        f59168c = str;
    }

    /* renamed from: z */
    public static void m78033z(String str) {
        f59169d = str;
    }

    /* renamed from: t8.e$a */
    public class a implements AppDownloadListener {
        @Override // com.huawei.openalliance.p169ad.inter.listeners.AppDownloadListener
        public void onAppOpen(AppInfo appInfo) {
            C11839m.m70688i("CampaignH5AdsManager", "onAppOpen:" + appInfo.getAppName());
            if (TextUtils.isEmpty(C12997e.f59172g)) {
                return;
            }
            C12997e.m78014g(String.format(Locale.ENGLISH, "%s(%s);", C12997e.f59172g, C12997e.m78020m(appInfo.getPackageName())));
            Message message = new Message();
            message.what = 107;
            message.obj = appInfo.getPackageName();
            if (C12997e.f59167b != null) {
                C12997e.f59167b.sendMessage(message);
            }
            C1007b.m5980s().m6014e(appInfo.getPackageName());
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("task_type", "download_app");
            linkedHashMap.put("download_type", HiCloudNativeAd.CHANNEL_PPS);
            linkedHashMap.put(MapKeyNames.PACKAGE_NAME, appInfo.getPackageName());
            C12997e.m78025r("pps_open_event", linkedHashMap);
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.AppDownloadListener
        public void onDownloadProgress(AppInfo appInfo, int i10) {
            C11839m.m70688i("CampaignH5AdsManager", "onDownloadProgress:" + i10);
            if (TextUtils.isEmpty(C12997e.f59171f)) {
                return;
            }
            C12997e.m78014g(String.format(Locale.ENGLISH, "%s(%d,%s)", C12997e.f59171f, Integer.valueOf(i10), C12997e.m78020m(appInfo.getPackageName())));
            if (i10 == 100) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("task_type", "download_app");
                linkedHashMap.put("download_type", HiCloudNativeAd.CHANNEL_PPS);
                linkedHashMap.put(MapKeyNames.PACKAGE_NAME, appInfo.getPackageName());
                C12997e.m78025r("pps_download_finished_event", linkedHashMap);
            }
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.AppDownloadListener
        public void onStatusChanged(AppStatus appStatus, AppInfo appInfo) {
            C11839m.m70688i("CampaignH5AdsManager", "onStatusChanged:" + C12997e.m78017j(appStatus));
            if (TextUtils.isEmpty(C12997e.f59170e)) {
                return;
            }
            C12997e.m78014g(String.format(Locale.ENGLISH, "%s(%s,%s)", C12997e.f59170e, C12997e.m78020m(C12997e.m78017j(appStatus)), C12997e.m78020m(appInfo.getPackageName())));
            if (C12997e.m78017j(appStatus).equals("INSTALLED")) {
                Message message = new Message();
                message.what = 106;
                message.obj = appInfo.getPackageName();
                if (C12997e.f59167b != null) {
                    C12997e.f59167b.sendMessage(message);
                }
            }
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.AppDownloadListener
        public void onUserCancel(AppInfo appInfo) {
            if (appInfo != null) {
                C11839m.m70688i("CampaignH5AdsManager", "onUserCancel: " + appInfo.getPackageName());
            }
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.AppDownloadListener
        public void onAppOpen(String str) {
            C11839m.m70688i("CampaignH5AdsManager", "onAppOpen1:" + str);
        }
    }
}
