package ca;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.cloud.pay.model.HiCloudNativeAd;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import com.huawei.openalliance.p169ad.download.app.AppStatus;
import com.huawei.openalliance.p169ad.inter.HiAd;
import com.huawei.openalliance.p169ad.inter.IAppDownloadManager;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.inter.listeners.AppDownloadListener;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.util.Locale;
import org.json.JSONObject;
import p015ak.C0213f;
import p514o9.C11839m;
import p651t8.C12997e;
import p664u0.C13108a;

/* renamed from: ca.a */
/* loaded from: classes3.dex */
public class C1398a {

    /* renamed from: a */
    public static String f5984a;

    /* renamed from: b */
    public static String f5985b;

    /* renamed from: c */
    public static String f5986c;

    /* renamed from: d */
    public static String f5987d;

    /* renamed from: e */
    public static String f5988e;

    /* renamed from: f */
    public static String f5989f;

    /* renamed from: g */
    public static String f5990g;

    /* renamed from: h */
    public static String f5991h;

    /* renamed from: i */
    public static String f5992i;

    /* renamed from: j */
    public static Activity f5993j;

    /* renamed from: k */
    public static Handler f5994k;

    /* renamed from: l */
    public static Handler f5995l;

    /* renamed from: m */
    public static boolean f5996m;

    /* renamed from: n */
    public static AppDownloadListener f5997n = new a();

    /* renamed from: A */
    public static void m8001A(String str) {
        f5985b = str;
    }

    /* renamed from: B */
    public static void m8002B(String str) {
        f5988e = str;
    }

    /* renamed from: C */
    public static void m8003C(String str) {
        f5984a = str;
    }

    /* renamed from: D */
    public static void m8004D(boolean z10) {
        C11839m.m70688i("H5AdsManager", "setRefreshCloudFlag:" + z10);
        f5996m = z10;
    }

    /* renamed from: E */
    public static void m8005E(Activity activity) {
        f5993j = activity;
    }

    /* renamed from: F */
    public static void m8006F(Handler handler) {
        f5994k = handler;
    }

    /* renamed from: G */
    public static void m8007G(Handler handler) {
        f5995l = handler;
    }

    /* renamed from: f */
    public static void m8013f() {
        Message message = new Message();
        message.what = 101;
        f5994k.sendMessage(message);
    }

    /* renamed from: g */
    public static void m8014g(String str) {
        Message message = new Message();
        message.what = 100;
        Bundle bundle = new Bundle();
        bundle.putString("javascript", str);
        message.setData(bundle);
        f5994k.sendMessage(message);
    }

    /* renamed from: h */
    public static void m8015h() {
        C11839m.m70688i("H5AdsManager", "finishGuideWebView");
        Message message = new Message();
        message.what = 103;
        Handler handler = f5995l;
        if (handler != null) {
            handler.sendMessage(message);
        }
    }

    /* renamed from: i */
    public static String m8016i() {
        return f5991h;
    }

    /* renamed from: j */
    public static IAppDownloadManager m8017j() {
        C11839m.m70686d("H5AdsManager", "setAppDownloadListener");
        HiAd.getInstance(C0213f.m1377a()).setAppDownloadListener(f5997n);
        return HiAd.getInstance(C0213f.m1377a()).getAppDownloadManager();
    }

    /* renamed from: k */
    public static String m8018k() {
        return f5992i;
    }

    /* renamed from: l */
    public static String m8019l() {
        return f5989f;
    }

    /* renamed from: m */
    public static String m8020m() {
        return f5990g;
    }

    /* renamed from: n */
    public static String m8021n() {
        return f5987d;
    }

    /* renamed from: o */
    public static String m8022o() {
        return f5988e;
    }

    /* renamed from: p */
    public static boolean m8023p() {
        return f5996m;
    }

    /* renamed from: q */
    public static String m8024q() {
        try {
            return new JSONObject(m8018k()).getString(NotifyConstants.MarketingConstant.CID_KEY);
        } catch (Exception e10) {
            C11839m.m70689w("H5AdsManager", "JSONException: " + e10.getMessage());
            return "";
        }
    }

    /* renamed from: r */
    public static Activity m8025r() {
        return f5993j;
    }

    /* renamed from: s */
    public static void m8026s(String str, Bundle bundle) {
        Message message = new Message();
        message.what = 102;
        bundle.putString("class_name", str);
        message.setData(bundle);
        f5994k.sendMessage(message);
    }

    /* renamed from: t */
    public static void m8027t(String str) {
        f5991h = str;
    }

    /* renamed from: u */
    public static void m8028u(String str) {
        C11839m.m70688i("H5AdsManager", "campaignInfo: " + str);
        f5992i = str;
    }

    /* renamed from: v */
    public static void m8029v(String str) {
        f5989f = str;
    }

    /* renamed from: w */
    public static void m8030w(boolean z10) {
        C11839m.m70688i("H5AdsManager", "setExitFlag" + z10);
        Message message = new Message();
        message.what = 104;
        Bundle bundle = new Bundle();
        bundle.putBoolean("exit_flag", z10);
        message.setData(bundle);
        f5994k.sendMessage(message);
    }

    /* renamed from: x */
    public static void m8031x(String str) {
        f5990g = str;
    }

    /* renamed from: y */
    public static void m8032y(String str) {
        f5986c = str;
    }

    /* renamed from: z */
    public static void m8033z(String str) {
        f5987d = str;
    }

    /* renamed from: ca.a$a */
    public class a implements AppDownloadListener {
        @Override // com.huawei.openalliance.p169ad.inter.listeners.AppDownloadListener
        public void onAppOpen(AppInfo appInfo) {
            C11839m.m70688i("H5AdsManager", "onAppOpen:" + appInfo.getAppName());
            if (TextUtils.isEmpty(C1398a.f5986c)) {
                return;
            }
            C1398a.m8014g(String.format(Locale.ENGLISH, "%s(%s);", C1398a.f5986c, C12997e.m78020m(appInfo.getPackageName())));
            Intent intent = new Intent("com.huawei.cloud.FRONT_APP_OPEN");
            intent.putExtra(MapKeyNames.PACKAGE_NAME, appInfo.getPackageName());
            intent.putExtra("unique_id", appInfo.getUniqueId());
            C13108a.m78878b(C0213f.m1377a()).m78881d(intent);
            Message message = new Message();
            message.what = 107;
            message.obj = appInfo.getPackageName();
            Bundle bundle = new Bundle();
            bundle.putString(FaqConstants.FAQ_CHANNEL, HiCloudNativeAd.CHANNEL_PPS);
            message.setData(bundle);
            C1398a.f5994k.sendMessage(message);
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.AppDownloadListener
        public void onDownloadProgress(AppInfo appInfo, int i10) {
            C11839m.m70688i("H5AdsManager", "onDownloadProgress:" + i10);
            if (TextUtils.isEmpty(C1398a.f5985b)) {
                return;
            }
            C1398a.m8014g(String.format(Locale.ENGLISH, "%s(%d,%s)", C1398a.f5985b, Integer.valueOf(i10), C12997e.m78020m(appInfo.getPackageName())));
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.AppDownloadListener
        public void onStatusChanged(AppStatus appStatus, AppInfo appInfo) {
            C11839m.m70688i("H5AdsManager", "onStatusChanged:" + C12997e.m78017j(appStatus));
            if (TextUtils.isEmpty(C1398a.f5984a)) {
                return;
            }
            C1398a.m8014g(String.format(Locale.ENGLISH, "%s(%s,%s)", C1398a.f5984a, C12997e.m78020m(C12997e.m78017j(appStatus)), C12997e.m78020m(appInfo.getPackageName())));
            if (C12997e.m78017j(appStatus).equals("INSTALLED")) {
                Intent intent = new Intent("com.huawei.cloud.FRONT_APP_DOWNLOAD_SUCCESS");
                intent.putExtra(MapKeyNames.PACKAGE_NAME, appInfo.getPackageName());
                intent.putExtra("unique_id", appInfo.getUniqueId());
                C13108a.m78878b(C0213f.m1377a()).m78881d(intent);
                Message message = new Message();
                message.what = 106;
                message.obj = appInfo.getPackageName();
                Bundle bundle = new Bundle();
                bundle.putString(FaqConstants.FAQ_CHANNEL, HiCloudNativeAd.CHANNEL_PPS);
                message.setData(bundle);
                C1398a.f5994k.sendMessage(message);
            }
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.AppDownloadListener
        public void onUserCancel(AppInfo appInfo) {
            if (appInfo != null) {
                C11839m.m70688i("H5AdsManager", "onUserCancel: " + appInfo.getPackageName());
            }
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.AppDownloadListener
        public void onAppOpen(String str) {
            C11839m.m70688i("H5AdsManager", "onAppOpen1:" + str);
        }
    }
}
