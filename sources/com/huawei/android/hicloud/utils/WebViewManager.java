package com.huawei.android.hicloud.utils;

import android.app.ActionBar;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.UserManager;
import android.system.Os;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Toast;
import ca.C1398a;
import ca.C1403f;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.hihonor.android.systemmanager.notificationmanager.HwNotificationManagerImpl;
import com.huawei.android.content.pm.UserInfoEx;
import com.huawei.android.hicloud.agd.ads.AdParametersExt;
import com.huawei.android.hicloud.cloudbackup.util.PackageParamUtil;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.manager.PPSDownloadingAdsManager;
import com.huawei.android.hicloud.p088ui.activity.OperationWebViewActivity;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.CloudSpaceUpgradeGiftSignActivity;
import com.huawei.android.hicloud.p088ui.uiextend.cloudpay.LearnMorePayClickListener;
import com.huawei.android.hicloud.task.simple.C3019c1;
import com.huawei.android.hicloud.task.simple.C3027e1;
import com.huawei.android.hicloud.task.simple.C3051k1;
import com.huawei.android.hicloud.task.simple.GetUserAvatarTask;
import com.huawei.android.hicloud.utils.C4308a;
import com.huawei.android.hicloud.utils.WebViewManager;
import com.huawei.android.os.UserHandleEx;
import com.huawei.android.os.UserManagerEx;
import com.huawei.android.p073ds.R$string;
import com.huawei.cloud.base.util.C4633d0;
import com.huawei.cloud.pay.model.CampaignInfo;
import com.huawei.cloud.pay.model.CloudPackage;
import com.huawei.cloud.pay.model.GetClientUIConfigResp;
import com.huawei.cloud.pay.model.HiCloudNativeAd;
import com.huawei.cloud.pay.model.HicloudAdRespone;
import com.huawei.cloud.pay.model.MemGradeRights;
import com.huawei.cloud.pay.model.UserPackage;
import com.huawei.cloud.pay.p098ui.broadcast.AcceptGiftSuccessBroadcastReceiver;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.base.p103ui.NewDialogUtil;
import com.huawei.hicloud.bean.GetCampaignActivityEntryResp;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.manager.AdSwitchManager;
import com.huawei.hicloud.notification.manager.GuideH5ReportUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.request.appmashup.bean.C4987f;
import com.huawei.hicloud.request.basic.bean.CloudValuableAppDataBean;
import com.huawei.hicloud.request.basic.bean.UserDataStateInfo;
import com.huawei.hms.framework.network.restclient.dnkeeper.InterfaceC5483d;
import com.huawei.hms.identity.Address;
import com.huawei.hms.identity.entity.GetUserAddressResult;
import com.huawei.hms.identity.entity.UserAddressRequest;
import com.huawei.hms.network.embedded.C6010m7;
import com.huawei.hms.support.api.client.Status;
import com.huawei.openalliance.p169ad.inter.data.INativeAd;
import com.huawei.secure.android.common.util.SafeBase64;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import dj.C9158a;
import fj.C9718g;
import fk.C9721b;
import gp.C10028c;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import je.C10776a;
import je.C10797k0;
import je.C10805s;
import mu.C11524a;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0219i;
import p015ak.C0223k;
import p015ak.C0224k0;
import p015ak.C0226l0;
import p020ap.C1006a;
import p020ap.C1008c;
import p037bp.C1270a;
import p208cq.InterfaceC8938f;
import p208cq.InterfaceC8939g;
import p232dp.InterfaceC9282a;
import p232dp.InterfaceC9284c;
import p232dp.InterfaceC9285d;
import p252e9.C9436m;
import p258ei.C9494c;
import p315gj.C9948a;
import p329h7.C10121i;
import p341hj.C10219d;
import p341hj.C10270w;
import p429kk.C11058a;
import p429kk.C11060c;
import p431ko.C11079e;
import p431ko.C11081g;
import p450le.C11273b;
import p454lj.C11296s;
import p514o9.C11827a;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11841o;
import p514o9.C11842p;
import p529op.C11983e;
import p572qb.C12331w;
import p616rk.C12515a;
import p618rm.C12540b1;
import p618rm.C12597u1;
import p651t8.C12997e;
import p664u0.C13108a;
import p681uj.C13194k;
import p681uj.C13196m;
import p681uj.C13199p;
import p684un.C13223b;
import p684un.C13227f;
import p684un.C13230i;
import p694v.C13306h;
import p709vj.C13448a;
import p709vj.C13452e;
import p711vl.C13462b;
import p778xk.C13823d;
import p780xm.C13834f;
import p783xp.C13843a;
import p836z8.C14157f;
import p847zk.C14315h;
import pm.C12196w;
import sk.C12806c;
import sk.C12808e;

/* loaded from: classes3.dex */
public class WebViewManager extends C11524a {

    /* renamed from: c */
    public final Activity f19613c;

    /* renamed from: d */
    public final String[] f19614d;

    /* renamed from: e */
    public String f19615e;

    /* renamed from: f */
    public String f19616f;

    /* renamed from: g */
    public final int f19617g;

    /* renamed from: h */
    public final String f19618h;

    /* renamed from: i */
    public final Handler f19619i;

    /* renamed from: j */
    public final Handler f19620j;

    /* renamed from: k */
    public final C10797k0 f19621k;

    /* renamed from: l */
    public WebViewManagerCallback f19622l;

    /* renamed from: m */
    public GetClientUIConfigResp f19623m;

    /* renamed from: n */
    public NewDialogUtil f19624n;

    /* renamed from: o */
    public Handler f19625o;

    public interface WebViewManagerCallback {
        /* renamed from: i */
        void mo20599i(boolean z10);
    }

    /* renamed from: com.huawei.android.hicloud.utils.WebViewManager$a */
    public class RunnableC4298a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ boolean f19626a;

        /* renamed from: b */
        public final /* synthetic */ ActionBar f19627b;

        public RunnableC4298a(boolean z10, ActionBar actionBar) {
            this.f19626a = z10;
            this.f19627b = actionBar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f19626a) {
                this.f19627b.setDisplayShowTitleEnabled(false);
                this.f19627b.setDisplayHomeAsUpEnabled(false);
            } else {
                this.f19627b.setDisplayShowTitleEnabled(true);
                this.f19627b.setDisplayHomeAsUpEnabled(true);
                this.f19627b.show();
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.utils.WebViewManager$b */
    public class HandlerC4299b extends Handler {
        public HandlerC4299b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2002) {
                WebViewManager.this.m25889J((GetClientUIConfigResp) message.obj);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.utils.WebViewManager$c */
    public class C4300c implements NewDialogUtil.InterfaceC4854c {

        /* renamed from: a */
        public final /* synthetic */ InterfaceC9282a f19630a;

        /* renamed from: b */
        public final /* synthetic */ Context f19631b;

        /* renamed from: c */
        public final /* synthetic */ boolean f19632c;

        /* renamed from: d */
        public final /* synthetic */ boolean f19633d;

        public C4300c(InterfaceC9282a interfaceC9282a, Context context, boolean z10, boolean z11) {
            this.f19630a = interfaceC9282a;
            this.f19631b = context;
            this.f19632c = z10;
            this.f19633d = z11;
        }

        @Override // com.huawei.hicloud.base.p103ui.NewDialogUtil.InterfaceC4854c
        /* renamed from: a */
        public void mo22508a() {
            WebViewManager.this.m25892o(this.f19630a, this.f19631b, this.f19632c, this.f19633d);
        }

        @Override // com.huawei.hicloud.base.p103ui.NewDialogUtil.InterfaceC4854c
        /* renamed from: b */
        public void mo22509b() {
        }
    }

    /* renamed from: com.huawei.android.hicloud.utils.WebViewManager$d */
    public class C4301d extends TypeToken<List<String>> {
        public C4301d() {
        }
    }

    /* renamed from: com.huawei.android.hicloud.utils.WebViewManager$e */
    public class C4302e extends TypeToken<List<String>> {
        public C4302e() {
        }
    }

    /* renamed from: com.huawei.android.hicloud.utils.WebViewManager$f */
    public class C4303f extends TypeToken<List<String>> {
        public C4303f() {
        }
    }

    /* renamed from: com.huawei.android.hicloud.utils.WebViewManager$g */
    public class C4304g extends TypeToken<List<String>> {
        public C4304g() {
        }
    }

    /* renamed from: com.huawei.android.hicloud.utils.WebViewManager$h */
    public class C4305h extends TypeToken<List<String>> {
        public C4305h() {
        }
    }

    /* renamed from: com.huawei.android.hicloud.utils.WebViewManager$i */
    public class C4306i implements InterfaceC8938f {
        public C4306i() {
        }

        @Override // p208cq.InterfaceC8938f
        public void onFailure(Exception exc) {
            C11839m.m70688i("WebViewManager", "IdentityKit on Failed result code:" + exc.getMessage());
            if (WebViewManager.this.f19613c instanceof OperationWebViewActivity) {
                ((OperationWebViewActivity) WebViewManager.this.f19613c).m21852r3();
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.utils.WebViewManager$j */
    public class C4307j implements InterfaceC8939g<GetUserAddressResult> {
        public C4307j() {
        }

        @Override // p208cq.InterfaceC8939g
        /* renamed from: a */
        public void onSuccess(GetUserAddressResult getUserAddressResult) {
            C11839m.m70688i("WebViewManager", "IdentityKit on Success result code:" + getUserAddressResult.getReturnCode());
            try {
                WebViewManager.this.m25890K(getUserAddressResult);
            } catch (IntentSender.SendIntentException e10) {
                C11839m.m70687e("WebViewManager", "request identify kit failed: " + e10.getMessage());
            }
        }
    }

    public WebViewManager(WebView webView, String[] strArr, Activity activity, String str, Handler handler, Handler handler2, int i10, WebViewManagerCallback webViewManagerCallback) {
        super(webView);
        this.f19615e = "";
        this.f19625o = new HandlerC4299b();
        C11839m.m70686d("WebViewManager", "WebViewManager, notifyUri = " + str);
        this.f19614d = strArr;
        this.f19613c = activity;
        this.f19618h = str;
        this.f19619i = handler;
        this.f19617g = i10;
        this.f19620j = handler2;
        this.f19622l = webViewManagerCallback;
        this.f19621k = new C10797k0(C11058a.m66627b("07030"));
        C11060c c11060c = new C11060c();
        c11060c.m66636B("06008");
        c11060c.m66643I(C11058a.m66627b("06008"));
        c11060c.m66637C("com.huawei.hidisk\u0001_cloudspace");
        c11060c.m66670z("2.0");
        C9158a.m57503F().m57505B(this.f19625o, c11060c, false);
    }

    /* renamed from: B */
    public static /* synthetic */ void m25868B(Map map, String str, Gson gson, CountDownLatch countDownLatch, CloudValuableAppDataBean cloudValuableAppDataBean) {
        if (cloudValuableAppDataBean != null) {
            map.put(str, gson.toJson(cloudValuableAppDataBean));
        }
        countDownLatch.countDown();
    }

    /* renamed from: C */
    public static /* synthetic */ void m25869C(Map map, String str, int i10, CountDownLatch countDownLatch, Bitmap bitmap) {
        if (bitmap != null) {
            map.put(str, "data:image/png;base64," + SafeBase64.encodeToString(C13843a.m83081d(bitmap, i10, Bitmap.CompressFormat.PNG), 0));
        } else {
            map.put(str, "");
        }
        countDownLatch.countDown();
    }

    /* renamed from: E */
    public static /* synthetic */ void m25870E(UserDataStateInfo userDataStateInfo) {
        UserPackage userPackageM61644M;
        MemGradeRights gradeRights;
        try {
            C11060c c11060c = new C11060c();
            c11060c.m66664t("06008");
            c11060c.m66643I(C11058a.m66627b("06008"));
            userPackageM61644M = C9948a.m61631C().m61644M(c11060c, "newBusinessChangeSuccess");
        } catch (C9721b e10) {
            C11839m.m70688i("WebViewManager", "getUserPackage error: " + e10);
        }
        if (userPackageM61644M == null || (gradeRights = userPackageM61644M.getGradeRights()) == null) {
            return;
        }
        C13452e.m80781L().m80816I1(userPackageM61644M.isPackagesAutoPay());
        C13452e.m80781L().m80817I2(userPackageM61644M.getServerTime());
        C13452e.m80781L().m80898c2(gradeRights.getGradeType());
        long memberRemainDays = userPackageM61644M.getMemberRemainDays();
        long memberCountDownsVisible = userPackageM61644M.getMemberCountDownsVisible();
        if (memberRemainDays < 0 || memberCountDownsVisible < 0 || memberRemainDays > memberCountDownsVisible) {
            C13452e.m80781L().m80961q2(-1L);
        } else {
            C13452e.m80781L().m80961q2(memberRemainDays);
        }
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (userDataStateInfo == null || userDataStateInfo.getBmType() == -1) {
            return;
        }
        C13452e.m80781L().m80985w2(userDataStateInfo.getBmType() == 1);
        if (!TextUtils.isEmpty(userDataStateInfo.getBsGrade())) {
            C11839m.m70688i("WebViewManager", "bs grade:" + userDataStateInfo.getBsGrade());
            C13452e.m80781L().m80940l1(userDataStateInfo.getBsGrade());
            if (C13452e.m80781L().m80907e1()) {
                C12515a.m75110o().m75172d(new C12331w(true, true, 28));
            }
            HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(new Intent());
            hiCloudSafeIntent.setAction("newBusinessChangeSuccess");
            hiCloudSafeIntent.setPackage("com.huawei.hidisk");
            C13108a.m78878b(C0213f.m1377a()).m78881d(hiCloudSafeIntent);
        }
        if (interfaceC9282a != null) {
            C11839m.m70688i("WebViewManager", "bm grade state and period: " + userDataStateInfo.getBmGradeState() + ", " + userDataStateInfo.getDataPeriod());
            interfaceC9282a.mo58410a1(userDataStateInfo.getBmGradeState(), userDataStateInfo.getDataPeriod());
            interfaceC9282a.mo58399V0(System.currentTimeMillis());
        }
    }

    /* renamed from: t */
    public static String m25880t(boolean z10, boolean z11, boolean z12) {
        Bundle bundle = new Bundle();
        bundle.putInt("personalizedAd", z10 ? 1 : 0);
        bundle.putInt("hwPersonalizedAd", z11 ? 1 : 0);
        bundle.putInt("thirdPersonalizedAd", z12 ? 1 : 0);
        String json = new Gson().toJson(bundle);
        C11839m.m70688i("WebViewManager", "getPersonalizedAdStatus: " + json);
        return json;
    }

    /* renamed from: u */
    private String m25881u(List<C4987f> list) {
        HashMap map = new HashMap();
        if (list != null && !list.isEmpty()) {
            for (C4987f c4987f : list) {
                map.put(c4987f.m30026b(), c4987f.m30027c());
            }
        }
        try {
            return new GsonBuilder().disableHtmlEscaping().create().toJson(map);
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: w */
    public static void m25882w(final Map<String, String> map, final int i10, final String str) throws InterruptedException {
        String strM80806G = C13452e.m80781L().m80806G();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        C12515a.m75110o().m75175e(new GetUserAvatarTask(new GetUserAvatarTask.CallBack() { // from class: je.j0
            @Override // com.huawei.android.hicloud.task.simple.GetUserAvatarTask.CallBack
            /* renamed from: a */
            public final void mo18099a(Bitmap bitmap) {
                WebViewManager.m25869C(map, str, i10, countDownLatch, bitmap);
            }
        }, strM80806G, false), false);
        try {
            countDownLatch.await(10L, TimeUnit.SECONDS);
        } catch (InterruptedException unused) {
            C11839m.m70687e("WebViewManager", "getUserIcon from server time out");
        }
    }

    /* renamed from: A */
    public final /* synthetic */ Object m25883A(String str, String str2) throws Exception {
        C11839m.m70688i("WebViewManager", "getParamsAsync, supplyAsync  start.");
        String strM25881u = m25881u(C14157f.m84942g().m84949i((List) C12540b1.m75484b(str, new C4304g().getType()), null, "WebViewAsync"));
        C11839m.m70688i("WebViewManager", "getParamsAsync, getData finish.");
        if (this.f19619i != null) {
            Message message = new Message();
            message.what = 100;
            Bundle bundle = new Bundle();
            bundle.putString("javascript", String.format(Locale.ENGLISH, "%s(%s)", str2, strM25881u));
            message.setData(bundle);
            this.f19619i.sendMessage(message);
            C11839m.m70688i("WebViewManager", "getParamsAsync, sendMessage.");
        } else {
            C11839m.m70687e("WebViewManager", "getParamsAsync, mHandler == null.");
        }
        return null;
    }

    /* renamed from: D */
    public final /* synthetic */ void m25884D(Context context, CountDownLatch countDownLatch, GetCampaignActivityEntryResp getCampaignActivityEntryResp) {
        if (getCampaignActivityEntryResp == null || getCampaignActivityEntryResp.getResultCode() != 0) {
            C11839m.m70687e("WebViewManager", "initActivityId rsp is null");
            return;
        }
        C9718g.m60602t().m60620V(context, getCampaignActivityEntryResp);
        this.f19616f = getCampaignActivityEntryResp.getActivityId();
        countDownLatch.countDown();
        C11839m.m70688i("WebViewManager", "get activityId: " + this.f19616f);
    }

    /* renamed from: F */
    public final String m25885F(int i10, String str) throws InterruptedException {
        C11839m.m70688i("WebViewManager", "loadAdsBySrc loadAgAds src: " + str);
        if (i10 <= 0) {
            C11839m.m70689w("WebViewManager", "loadAdsBySrc adNum <= 0");
            return "";
        }
        AdParametersExt adParametersExtM63035a = C10121i.m63035a();
        if (adParametersExtM63035a == null) {
            C11839m.m70689w("WebViewManager", "loadAdsBySrc adParametersExt null");
            return "";
        }
        String agdAdid = HiCloudNativeAd.CHANNEL_AGD.equals(str) ? adParametersExtM63035a.getAgdAdid() : HiCloudNativeAd.CHANNEL_AGG.equals(str) ? adParametersExtM63035a.getAggAdid() : null;
        if (TextUtils.isEmpty(agdAdid)) {
            C11839m.m70689w("WebViewManager", "loadAdsBySrc adId is null");
            return "";
        }
        C3027e1 c3027e1 = new C3027e1(agdAdid, i10, str);
        boolean zAwait = false;
        C12515a.m75110o().m75175e(c3027e1, false);
        try {
            zAwait = c3027e1.m18303f().await(60000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e10) {
            C11839m.m70687e("WebViewManager", "loadAdsBySrc loadAgAdsTask exception:" + e10.getMessage());
        }
        C11839m.m70688i("WebViewManager", "loadAdsBySrc loadAgAds Result:" + zAwait);
        return c3027e1.m18304g();
    }

    /* renamed from: G */
    public final String m25886G(int i10, String str) throws JSONException, InterruptedException {
        String string;
        C11839m.m70688i("WebViewManager", "loadAdsBySrc loadPpsAds src: PPS");
        AdParametersExt adParametersExtM63035a = C10121i.m63035a();
        if (adParametersExtM63035a == null) {
            C11839m.m70689w("WebViewManager", "loadAdsBySrc adParametersExt null");
            return "";
        }
        String ppsAdid = adParametersExtM63035a.getPpsAdid();
        if (TextUtils.isEmpty(ppsAdid)) {
            C11839m.m70689w("WebViewManager", "loadAdsBySrc ppsAdId null");
            return "";
        }
        if (TextUtils.isEmpty(str)) {
            string = null;
        } else {
            try {
                string = new JSONObject(str).getString("adType");
            } catch (JSONException e10) {
                C11839m.m70687e("WebViewManager", "loadAdsBySrc JSONException: " + e10.getMessage());
            }
        }
        if (TextUtils.isEmpty(string)) {
            string = "9";
        }
        C3051k1 c3051k1 = new C3051k1(i10, new String[]{ppsAdid}, Integer.parseInt(string));
        CountDownLatch countDownLatchM18357j = c3051k1.m18357j();
        boolean zAwait = false;
        C12515a.m75110o().m75175e(c3051k1, false);
        try {
            zAwait = countDownLatchM18357j.await(30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e11) {
            C11839m.m70687e("WebViewManager", "loadAdsBySrc loadPpsAdsTask exception:" + e11.toString());
        }
        C11839m.m70688i("WebViewManager", "loadAdsBySrc loadPpsAds Result:" + zAwait);
        return c3051k1.m18358k();
    }

    /* renamed from: H */
    public final String m25887H(int i10) {
        C11839m.m70688i("WebViewManager", "loadAdsBySrc loadPreAppAds src: PREAPP");
        String strM59430z = C9494c.m59390r().m59430z();
        List<INativeAd> listM59429y = C9494c.m59390r().m59429y(i10);
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("07054"), "07054", C13452e.m80781L().m80971t0());
        if (listM59429y.isEmpty()) {
            C11839m.m70689w("WebViewManager", "preAdList is null.");
            c11060cM66626a.m66665u(String.valueOf(-1));
            c11060cM66626a.m66635A("preAdList is null.");
            C10776a.m65612h(c11060cM66626a, i10, HiCloudNativeAd.CHANNEL_PRE);
            return "";
        }
        HashMap map = new HashMap();
        map.put(strM59430z, listM59429y);
        C1403f.m8066n().m8078L(map);
        ArrayList arrayList = new ArrayList();
        Iterator<INativeAd> it = listM59429y.iterator();
        while (it.hasNext()) {
            HiCloudNativeAd hiCloudNativeAdM65607c = C10776a.m65607c(it.next(), HiCloudNativeAd.CHANNEL_PRE);
            if (hiCloudNativeAdM65607c != null) {
                arrayList.add(hiCloudNativeAdM65607c);
            }
        }
        C11839m.m70688i("WebViewManager", "loadAdsBySrc ads PREAPP size: " + arrayList.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(strM59430z, arrayList);
        HicloudAdRespone hicloudAdRespone = new HicloudAdRespone();
        hicloudAdRespone.setResultCode(0);
        hicloudAdRespone.setResponseMessage(new Gson().toJson(linkedHashMap));
        c11060cM66626a.m66665u(String.valueOf(0));
        c11060cM66626a.m66635A("");
        C10776a.m65613i(c11060cM66626a, i10, arrayList.size(), HiCloudNativeAd.CHANNEL_PRE);
        return new Gson().toJson(hicloudAdRespone);
    }

    /* renamed from: I */
    public void m25888I(InterfaceC9282a interfaceC9282a, Context context, boolean z10, boolean z11) throws IllegalAccessException, IllegalArgumentException {
        NewDialogUtil newDialogUtil = new NewDialogUtil(context);
        this.f19624n = newDialogUtil;
        newDialogUtil.m29117b(context, context.getResources().getString(R$string.download_now_popup_title), context.getResources().getString(C2783d.m16179s1(R$string.download_now_popup_content, R$string.download_now_popup_content_wifi)), context.getResources().getString(R$string.download_now_popup_confirm), context.getResources().getString(R$string.phonefinder_verify_later), new C4300c(interfaceC9282a, context, z10, z11));
    }

    /* renamed from: J */
    public void m25889J(GetClientUIConfigResp getClientUIConfigResp) {
        this.f19623m = getClientUIConfigResp;
    }

    /* renamed from: K */
    public final void m25890K(GetUserAddressResult getUserAddressResult) throws IntentSender.SendIntentException {
        Status status = getUserAddressResult.getStatus();
        if (getUserAddressResult.getReturnCode() == 0 && status.hasResolution()) {
            C11839m.m70688i("WebViewManager", "IdentityKit the result had resolution.");
            status.startResolutionForResult(this.f19613c, 2);
            return;
        }
        C11839m.m70688i("WebViewManager", "IdentityKit the result hasn't resolution.");
        Activity activity = this.f19613c;
        if (activity instanceof OperationWebViewActivity) {
            ((OperationWebViewActivity) activity).m21852r3();
        }
    }

    @JavascriptInterface
    public void agreeJoinCampaign(String str) {
        C11839m.m70688i("WebViewManager", "agreeJoinCampaign");
        C9718g.m60596X(C0213f.m1377a(), str);
        C9718g.m60595W(C0213f.m1377a(), 1);
        if (C11829c.m70583i(m68794b(), this.f19614d, "agreeJoinCampaign")) {
            C4308a.m25903b(false, this.f19619i);
        } else {
            C11839m.m70687e("WebViewManager", "startQuest, url is invalid");
        }
    }

    @JavascriptInterface
    public void cancelDownload(String str, String str2) throws InterruptedException {
        C11839m.m70688i("WebViewManager", "cancelDownload, uniqueId:" + str2);
        String strM68794b = m68794b();
        if (C11829c.m70583i(strM68794b, this.f19614d, "cancelDownload")) {
            C1403f.m8066n().m8087d(str, str2);
        } else {
            C11839m.m70687e("WebViewManager", "cancelDownload, url is invalid");
            this.f19621k.m65707p(C11829c.m70560a0(strM68794b), Arrays.toString(this.f19614d));
        }
    }

    @JavascriptInterface
    public int checkIsChinaAccount() throws InterruptedException {
        String strM68794b = m68794b();
        if (!C11829c.m70583i(strM68794b, this.f19614d, "checkIsChinaAccount")) {
            C11839m.m70687e("WebViewManager", "setOnResumeListner, url is invalid");
            this.f19621k.m65707p(C11829c.m70560a0(strM68794b), Arrays.toString(this.f19614d));
            return -1;
        }
        C11839m.m70688i("WebViewManager", "checkIsChinaAccount start");
        String strM80942m = C13452e.m80781L().m80942m();
        if (TextUtils.isEmpty(strM80942m)) {
            return -1;
        }
        return "CN".equalsIgnoreCase(strM80942m) ? 1 : 0;
    }

    @JavascriptInterface
    public boolean checkIsInstalled(String str) {
        C11839m.m70686d("WebViewManager", "checkIsInstalled");
        if (!C11829c.m70583i(m68794b(), this.f19614d, "checkIsInstalled")) {
            C11839m.m70687e("WebViewManager", "checkIsInstalled, url is invalid");
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            C11839m.m70689w("WebViewManager", "packageName is empty");
            return false;
        }
        if (!C0209d.m1187L0(C0213f.m1377a(), str)) {
            return false;
        }
        C11839m.m70686d("WebViewManager", "App has been installed:" + str);
        return true;
    }

    @JavascriptInterface
    public boolean checkIsSupportSdk() {
        C11839m.m70686d("WebViewManager", "checkIsSupportSdk");
        if (!C11829c.m70583i(m68794b(), this.f19614d, "checkIsSupportSdk")) {
            C11839m.m70687e("WebViewManager", "checkIsSupportSdk, url is invalid");
        }
        return C11983e.m72121b().m72124d();
    }

    @JavascriptInterface
    public void clearServiceChangeData() throws InterruptedException {
        String strM68794b = m68794b();
        if (C11829c.m70583i(strM68794b, this.f19614d, "clearServiceChangeData")) {
            C9436m.m59180d().m59182b();
        } else {
            C11839m.m70687e("WebViewManager", "clearServiceChangeData, url is invalid");
            this.f19621k.m65707p(C11829c.m70560a0(strM68794b), Arrays.toString(this.f19614d));
        }
    }

    @JavascriptInterface
    public void clickExit() throws InterruptedException {
        String strM68794b = m68794b();
        if (C11829c.m70583i(strM68794b, this.f19614d, "clickExit")) {
            C1398a.m8013f();
        } else {
            C11839m.m70687e("WebViewManager", "clickExit, url is invalid");
            this.f19621k.m65707p(C11829c.m70560a0(strM68794b), Arrays.toString(this.f19614d));
        }
    }

    @JavascriptInterface
    public boolean copyShareText(String str) throws InterruptedException {
        String strM68794b = m68794b();
        if (!C11829c.m70583i(strM68794b, this.f19614d, "copyShareText")) {
            C11839m.m70687e("WebViewManager", "setOnResumeListner, url is invalid");
            this.f19621k.m65707p(C11829c.m70560a0(strM68794b), Arrays.toString(this.f19614d));
            return false;
        }
        C11839m.m70688i("WebViewManager", "copyShareText start");
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null || TextUtils.isEmpty(str)) {
            return false;
        }
        ClipboardManager clipboardManager = (ClipboardManager) contextM1377a.getSystemService("clipboard");
        clipboardManager.setText(str.trim());
        clipboardManager.setPrimaryClip(ClipData.newPlainText(null, str));
        showToast(contextM1377a.getResources().getString(R$string.copy_text_success));
        return true;
    }

    @JavascriptInterface
    public int downloadAllAlbums() {
        return m25891n(true);
    }

    @JavascriptInterface
    public void finishWebview() throws InterruptedException {
        C11839m.m70688i("WebViewManager", "finishWebView");
        String strM68794b = m68794b();
        if (!C11829c.m70583i(strM68794b, this.f19614d, "finishWebview")) {
            C11839m.m70687e("WebViewManager", "finishWebview, url is invalid");
            this.f19621k.m65707p(C11829c.m70560a0(strM68794b), Arrays.toString(this.f19614d));
            return;
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = 103;
        Handler handler = this.f19619i;
        if (handler != null) {
            handler.sendMessage(messageObtain);
        }
        C1398a.m8015h();
    }

    @JavascriptInterface
    public int getActionBarHeight() {
        C11839m.m70688i("WebViewManager", "getActionBarHeight");
        if (!C11829c.m70583i(m68794b(), this.f19614d, "getActionBarHeight")) {
            C11839m.m70687e("WebViewManager", "getActionBarHeight, url is invalid");
            return 0;
        }
        int iM70810f1 = C11842p.m70810f1(this.f19613c, C11842p.m70852q(r1));
        C11839m.m70686d("WebViewManager", "getActionBarHeight:" + iM70810f1);
        if (C12806c.m76810a(this.f19613c) && !C11842p.m70771U0()) {
            return iM70810f1;
        }
        int iM70810f12 = C11842p.m70810f1(this.f19613c, C11842p.m70789a0(r4));
        int i10 = iM70810f1 + iM70810f12;
        C11839m.m70686d("WebViewManager", "getStatusBarHeight:" + iM70810f12);
        return i10;
    }

    @JavascriptInterface
    public String getActivityEnteryList() throws InterruptedException {
        C11839m.m70686d("WebViewManager", "getActivityEnteryList");
        if (!C11829c.m70583i(m68794b(), this.f19614d, "getActivityEnteryList")) {
            C11839m.m70687e("WebViewManager", "getActivityEnteryList, url is invalid");
            return "";
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        try {
            m25898x(countDownLatch);
            C11839m.m70688i("WebViewManager", "countDownLatch wait:" + countDownLatch.await(1000L, TimeUnit.MILLISECONDS));
        } catch (InterruptedException unused) {
            C11839m.m70687e("WebViewManager", "initActivityId is Exception");
        }
        C12515a.m75110o().m75175e(new C4308a.c(this.f19613c, this.f19619i, this.f19616f, "500"), false);
        return "";
    }

    @JavascriptInterface
    public String getAppStatus(String str, String str2) throws InterruptedException {
        C11839m.m70688i("WebViewManager", "getAppStatus start:" + str2);
        String strM68794b = m68794b();
        if (!C11829c.m70583i(strM68794b, this.f19614d, "getAppStatus")) {
            C11839m.m70687e("WebViewManager", "getAppStatus, url is invalid");
            this.f19621k.m65707p(C11829c.m70560a0(strM68794b), Arrays.toString(this.f19614d));
            return "";
        }
        String strM8093j = C1403f.m8066n().m8093j(str, str2);
        C11839m.m70688i("WebViewManager", "getAppStatus end:" + strM8093j);
        return strM8093j;
    }

    @JavascriptInterface
    public void getClientUiConfig(final String str) throws InterruptedException {
        C11839m.m70688i("WebViewManager", "getClientUiConfig, callbackFunction = " + str);
        String strM68794b = m68794b();
        if (C11829c.m70583i(strM68794b, this.f19614d, "getClientUiConfig")) {
            C13834f.m82974k(new Callable() { // from class: je.f0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f51532a.m25899y(str);
                }
            }, null);
        } else {
            C11839m.m70687e("WebViewManager", "getClientUiConfig, url is invalid");
            this.f19621k.m65707p(C11829c.m70560a0(strM68794b), Arrays.toString(this.f19614d));
        }
    }

    @JavascriptInterface
    public String getCloudVersion() throws InterruptedException {
        String strM68794b = m68794b();
        if (C11829c.m70583i(strM68794b, this.f19614d, "getCloudVersion")) {
            C11839m.m70688i("WebViewManager", "getCloudVersion start");
            return "16.0.0.300";
        }
        C11839m.m70687e("WebViewManager", "setOnResumeListner, url is invalid");
        this.f19621k.m65707p(C11829c.m70560a0(strM68794b), Arrays.toString(this.f19614d));
        return "";
    }

    @JavascriptInterface
    public int getDeviceMode() throws InterruptedException {
        String strM68794b = m68794b();
        if (C11829c.m70583i(strM68794b, this.f19614d, "getDeviceMode")) {
            if (C11842p.m70762R0()) {
                return 1;
            }
            return C11842p.m70747M0(C0213f.m1377a()) ? 2 : 0;
        }
        C11839m.m70687e("WebViewManager", "getDeviceMode, url is invalid");
        this.f19621k.m65707p(C11829c.m70560a0(strM68794b), Arrays.toString(this.f19614d));
        return -1;
    }

    @JavascriptInterface
    public int getDownloadProgress(String str, String str2) throws InterruptedException {
        C11839m.m70688i("WebViewManager", "getDownloadProgress start:" + str2);
        String strM68794b = m68794b();
        if (!C11829c.m70583i(strM68794b, this.f19614d, "getDownloadProgress")) {
            C11839m.m70687e("WebViewManager", "getDownloadProgress, url is invalid");
            this.f19621k.m65707p(C11829c.m70560a0(strM68794b), Arrays.toString(this.f19614d));
            return -100;
        }
        int iM8095l = C1403f.m8066n().m8095l(str, str2);
        C11839m.m70688i("WebViewManager", "getDownloadProgress end:" + iM8095l);
        return iM8095l;
    }

    @JavascriptInterface
    public int getHMSVersion() throws InterruptedException {
        String strM68794b = m68794b();
        if (!C11829c.m70583i(strM68794b, this.f19614d, "getHMSVersion")) {
            C11839m.m70687e("WebViewManager", "getHMSVersion, url is invalid");
            this.f19621k.m65707p(C11829c.m70560a0(strM68794b), Arrays.toString(this.f19614d));
            return -1;
        }
        int iM67834r = C11296s.m67834r();
        C11839m.m70688i("WebViewManager", "getHMSVersion, hmsVer: " + iM67834r);
        return iM67834r;
    }

    @JavascriptInterface
    public String getInstallingPackageNames() {
        C11839m.m70688i("WebViewManager", "getInstallingPackageNames");
        if (C11829c.m70583i(m68794b(), this.f19614d, "getInstallingPackageNames")) {
            return new Gson().toJson(PPSDownloadingAdsManager.m16469e().m16473d("downloadApp").toArray());
        }
        C11839m.m70687e("WebViewManager", "getInstallingPackageNames, url is invalid");
        return C6010m7.f27500n;
    }

    @JavascriptInterface
    public void getLocalParamsAsync(final String str, final String str2) throws InterruptedException {
        C11839m.m70688i("WebViewManager", "getLocalParamsAsync, callbackFunction = " + str2);
        String strM68794b = m68794b();
        if (C11829c.m70583i(strM68794b, this.f19614d, "getLocalParamsAsync")) {
            C13834f.m82974k(new Callable() { // from class: je.d0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f51526a.m25900z(str, str2);
                }
            }, null);
        } else {
            C11839m.m70687e("WebViewManager", "setOnResumeListner, url is invalid");
            this.f19621k.m65707p(C11829c.m70560a0(strM68794b), Arrays.toString(this.f19614d));
        }
    }

    @JavascriptInterface
    public String getOperationResp(int i10, String str, String str2, String str3) {
        return this.f19621k.m65701j(m68794b(), this.f19614d, i10, str, str2, str3, null);
    }

    @JavascriptInterface
    public String getOtherMarketActivityUrl() throws InterruptedException {
        String strM68794b = m68794b();
        if (C11829c.m70583i(strM68794b, this.f19614d, "getOtherMarketActivityUrl")) {
            return this.f19618h;
        }
        C11839m.m70687e("WebViewManager", "setOnResumeListner, url is invalid");
        this.f19621k.m65707p(C11829c.m70560a0(strM68794b), Arrays.toString(this.f19614d));
        return "";
    }

    @JavascriptInterface
    public String getParams(String str) throws InterruptedException {
        String strM68794b = m68794b();
        if (C11829c.m70583i(strM68794b, this.f19614d, "getParams")) {
            return m25881u(C14157f.m84942g().m84949i((List) C12540b1.m75484b(str, new C4301d().getType()), null, "WebView"));
        }
        C11839m.m70687e("WebViewManager", "setOnResumeListner, url is invalid");
        this.f19621k.m65707p(C11829c.m70560a0(strM68794b), Arrays.toString(this.f19614d));
        return "";
    }

    @JavascriptInterface
    public void getParamsAsync(final String str, final String str2) throws InterruptedException {
        C11839m.m70688i("WebViewManager", "getParamsAsync, callbackFunction = " + str2);
        String strM68794b = m68794b();
        if (C11829c.m70583i(strM68794b, this.f19614d, "getParamsAsync")) {
            C13834f.m82974k(new Callable() { // from class: je.e0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f51529a.m25883A(str, str2);
                }
            }, null);
        } else {
            C11839m.m70687e("WebViewManager", "setOnResumeListner, url is invalid");
            this.f19621k.m65707p(C11829c.m70560a0(strM68794b), Arrays.toString(this.f19614d));
        }
    }

    @JavascriptInterface
    public String getParamsByLocalAndServer(String str, String str2) throws InterruptedException {
        String strM68794b = m68794b();
        if (C11829c.m70583i(strM68794b, this.f19614d, "getParams")) {
            return m25881u(C14157f.m84942g().m84949i(!C4633d0.m28404a(str) ? (List) C12540b1.m75484b(str, new C4302e().getType()) : null, C4633d0.m28404a(str2) ? null : (List) C12540b1.m75484b(str2, new C4303f().getType()), "WebView"));
        }
        C11839m.m70687e("WebViewManager", "getParamsByLocalAndServer, url is invalid");
        this.f19621k.m65707p(C11829c.m70560a0(strM68794b), Arrays.toString(this.f19614d));
        return "";
    }

    @JavascriptInterface
    public String getPersonalizedAdStatus(int i10) throws InterruptedException {
        C11839m.m70688i("WebViewManager", "getPersonalizedAdStatus enter, type = " + i10);
        String strM68794b = m68794b();
        if (!C11829c.m70583i(strM68794b, this.f19614d, "getPersonalizedAdStatus")) {
            C11839m.m70687e("WebViewManager", "getPersonalizedAdStatus, url is invalid");
            this.f19621k.m65707p(C11829c.m70560a0(strM68794b), Arrays.toString(this.f19614d));
            return "";
        }
        if ((i10 & 1) == 1 && !C13452e.m80781L().m80803F0().booleanValue()) {
            NotifyLogger.m29915i("WebViewManager", "overseas Account");
            return m25880t(true, true, true);
        }
        if ((i10 & 2) != 2 || !C13452e.m80781L().m80803F0().booleanValue() || !C13452e.m80781L().m80795D0()) {
            return m25880t(AdSwitchManager.getInstance().getPersonalizationAdSwitch(), AdSwitchManager.getInstance().getHuaweiAdSwitch(), AdSwitchManager.getInstance().getThreeAdSwitch());
        }
        NotifyLogger.m29916w("WebViewManager", "children's account");
        return m25880t(false, false, false);
    }

    @JavascriptInterface
    public String getPreferences(String str) {
        String strM80779b = C13448a.m80777c().m80779b(str);
        C11839m.m70688i("WebViewManager", "H5 get key: " + str + "; value: " + strM80779b);
        return strM80779b;
    }

    @JavascriptInterface
    public String getPrivacyStatementAddress() {
        return C11827a.m70481f();
    }

    @JavascriptInterface
    public String getProductName(String str) {
        String string;
        if (!C11829c.m70583i(m68794b(), this.f19614d, "getProductName")) {
            C11839m.m70687e("WebViewManager", "getProductName, url not in whitelist");
            return "";
        }
        CloudPackage cloudPackage = (CloudPackage) C12540b1.m75483a(str, CloudPackage.class);
        String productName = cloudPackage.getProductName();
        try {
            if (cloudPackage.getProductType() == 12) {
                string = this.f19613c.getString(R$string.payment_renewal_package_size, productName, PackageParamUtil.procWorryFreeDurationText(this.f19613c, cloudPackage));
            } else {
                long capacity = cloudPackage.getCapacity();
                productName = PackageParamUtil.getProductName(cloudPackage, this.f19623m);
                string = this.f19613c.getString(R$string.payment_renewal_package_size, C0223k.m1524g(this.f19613c, capacity), productName);
            }
            return string;
        } catch (Exception e10) {
            C11839m.m70687e("WebViewManager", "getProductName Exception : " + e10.toString());
            return productName;
        }
    }

    @JavascriptInterface
    public String getQuestResources(String[] strArr) {
        C11839m.m70686d("WebViewManager", "getQuestResources, questIds:" + Arrays.toString(strArr));
        if (!C11829c.m70583i(m68794b(), this.f19614d, "getQuestResources")) {
            C11839m.m70687e("WebViewManager", "getQuestResources, url is invalid");
            return "";
        }
        C12515a.m75110o().m75175e(new C4308a.d(this.f19619i, this.f19616f, strArr), false);
        return "";
    }

    @JavascriptInterface
    public String getRemarkString(int i10) {
        if (!C11829c.m70583i(m68794b(), this.f19614d, "getRemarkString")) {
            C11839m.m70687e("WebViewManager", "getRemarkString, url not in whitelist");
            return "";
        }
        String recommendBasicPackageRemarak = C11273b.m67647b().getRecommendBasicPackageRemarak(i10);
        C11839m.m70688i("WebViewManager", "getRemarkString, remark: " + recommendBasicPackageRemarak);
        return recommendBasicPackageRemarak;
    }

    @JavascriptInterface
    public String getRequestHeader(String str) throws InterruptedException {
        String strM68794b = m68794b();
        if (C11829c.m70583i(strM68794b, this.f19614d, "getRequestHeader")) {
            return C12997e.m78024q(str);
        }
        C11839m.m70687e("WebViewManager", "getRequestHeader, url is invalid");
        this.f19621k.m65707p(C11829c.m70560a0(strM68794b), Arrays.toString(this.f19614d));
        return "";
    }

    @JavascriptInterface
    public int getStatusBarHeight() {
        C11839m.m70688i("WebViewManager", "getStatusBarHeight");
        if (!C11829c.m70583i(m68794b(), this.f19614d, "getStatusBarHeight")) {
            C11839m.m70687e("WebViewManager", "getStatusBarHeight, url is invalid");
            return 0;
        }
        int iM70810f1 = C11842p.m70810f1(this.f19613c, C11842p.m70789a0(r4));
        C11839m.m70686d("WebViewManager", "getStatusBarHeight:" + iM70810f1);
        return iM70810f1;
    }

    @JavascriptInterface
    public String getUserAgreementAddress() {
        return C11827a.m70484i();
    }

    @JavascriptInterface
    public int getUserMode() {
        if (!C11829c.m70583i(m68794b(), this.f19614d, "getUserMode")) {
            C11839m.m70687e("WebViewManager", "getUserMode, url not in whitelist");
            return -1;
        }
        UserInfoEx userInfoEx = UserManagerEx.getUserInfoEx((UserManager) C0213f.m1377a().getSystemService(UserManager.class), UserHandleEx.getUserId(Os.getuid()));
        if (userInfoEx == null) {
            return -1;
        }
        if (userInfoEx.isGuest()) {
            return 1;
        }
        return C0209d.m1166E1() ? 0 : 2;
    }

    @JavascriptInterface
    public String getVisibleRect() throws InterruptedException {
        Context contextM1377a = C0213f.m1377a();
        String strM68794b = m68794b();
        if (!C11829c.m70583i(strM68794b, this.f19614d, "getVisibleRect")) {
            C11839m.m70687e("WebViewManager", "getVisibleRect, url is invalid");
            this.f19621k.m65707p(C11829c.m70560a0(strM68794b), Arrays.toString(this.f19614d));
            return "";
        }
        if (contextM1377a == null) {
            C11839m.m70687e("WebViewManager", "context is null");
            return "";
        }
        Configuration configuration = contextM1377a.getResources().getConfiguration();
        int iM70810f1 = configuration.screenWidthDp;
        if (C0219i.m1463a() >= 21) {
            iM70810f1 = C11842p.m70810f1(contextM1377a, C11842p.m70840n(contextM1377a, iM70810f1) - (C12808e.m76823b() * 2));
        }
        String str = configuration.screenHeightDp + "&" + iM70810f1;
        C11839m.m70686d("WebViewManager", "getVisibleRect height = " + configuration.screenHeightDp + ", width = " + iM70810f1);
        return str;
    }

    @JavascriptInterface
    public String getWebAt(boolean z10) throws C13199p, C13194k, InterruptedException {
        C11839m.m70688i("WebViewManager", "getWebAt forceUpdate=" + z10);
        String strM68794b = m68794b();
        if (!C11829c.m70583i(strM68794b, this.f19614d, "getWebAt")) {
            C11839m.m70687e("WebViewManager", "getWebAt, url is invalid");
            this.f19621k.m65707p(C11829c.m70560a0(strM68794b), Arrays.toString(this.f19614d));
            return "";
        }
        if (z10) {
            C13196m.m79363o().m79375t(this.f19615e);
        }
        String strM79367k = C13196m.m79363o().m79367k();
        this.f19615e = strM79367k;
        return strM79367k;
    }

    @JavascriptInterface
    public void gotoAppIntent(String str, String str2) throws InterruptedException {
        String strM68794b = m68794b();
        if (!C11829c.m70583i(strM68794b, this.f19614d, "gotoAppIntent")) {
            C11839m.m70687e("WebViewManager", "gotoAppIntent, url is invalid");
            this.f19621k.m65707p(C11829c.m70560a0(strM68794b), Arrays.toString(this.f19614d));
            return;
        }
        Intent intent = new Intent();
        if ("application".equals(str)) {
            Class<?> cls = NotifyConstants.getGotoAppMapping().get(str2);
            if (cls == null) {
                NotifyLogger.m29914e("WebViewManager", "no uri match, return");
                GuideH5ReportUtil.reportH5GuideDialogOperaitonResult(NotifyConstants.H5GuideDialog.GUIDE_WEBVIEW_JS, "cls_is_null_uriType: " + str);
                return;
            }
            Activity activity = this.f19613c;
            if (activity == null) {
                C11839m.m70687e("WebViewManager", "webViewActivity is null");
                GuideH5ReportUtil.reportH5GuideDialogOperaitonResult(NotifyConstants.H5GuideDialog.GUIDE_WEBVIEW_JS, "webViewActivity_is_null_uriType: " + str);
                return;
            }
            intent.setClass(activity, cls);
            if ("manage".equals(str2) || NotifyConstants.CLOUD_STORAGE.equals(str2)) {
                intent.putExtra(NotifyConstants.IS_FROM_SPACE_NOTIFY, true);
            } else if (NotifyConstants.BUY_MORE.equals(str2)) {
                intent.putExtra(NotifyConstants.BackupNotificationType.FIELD, 8);
            }
            try {
                this.f19613c.startActivity(intent);
            } catch (Exception e10) {
                C11839m.m70687e("WebViewManager", "gotoAppIntent error " + e10.getMessage());
                GuideH5ReportUtil.reportH5GuideDialogOperaitonResult(NotifyConstants.H5GuideDialog.GUIDE_WEBVIEW_JS, " gotoAppIntent_error: " + e10.getMessage());
            }
        }
    }

    @JavascriptInterface
    public int gotoCloudDisk(String str) {
        C11839m.m70686d("WebViewManager", "gotoCloudDisk params " + str);
        InterfaceC9285d interfaceC9285d = (InterfaceC9285d) C1270a.m7534b().m7535a(InterfaceC9285d.class);
        if (interfaceC9285d != null) {
            return interfaceC9285d.mo17164A(this.f19613c, 0, str);
        }
        return -1;
    }

    @JavascriptInterface
    public int gotoGallery(String str) {
        return m25891n(false);
    }

    @JavascriptInterface
    public void gotoSyncApp(String str) {
        if (TextUtils.isEmpty(str)) {
            C11839m.m70688i("WebViewManager", "gotoSyncApp syncType is null");
            return;
        }
        String str2 = C12597u1.m76028d().get(str);
        if (TextUtils.isEmpty(str2)) {
            C11839m.m70688i("WebViewManager", "gotoSyncApp pkg is null");
            return;
        }
        Context contextM1377a = this.f19613c;
        if (contextM1377a == null) {
            contextM1377a = C0213f.m1377a();
        }
        InterfaceC9284c interfaceC9284c = (InterfaceC9284c) C1270a.m7534b().m7535a(InterfaceC9284c.class);
        if (interfaceC9284c != null) {
            interfaceC9284c.mo17137m0(contextM1377a, str, str2);
        }
    }

    @JavascriptInterface
    public void initImmersive(boolean z10) {
        C11839m.m70688i("WebViewManager", "initImmersive");
        if (!C11829c.m70583i(m68794b(), this.f19614d, "initImmersive")) {
            C11839m.m70687e("WebViewManager", "initImmersive, url not in whitelist");
            return;
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = 110;
        messageObtain.obj = Boolean.valueOf(z10);
        Handler handler = this.f19619i;
        if (handler != null) {
            handler.sendMessage(messageObtain);
        }
    }

    @JavascriptInterface
    public void initImmersiveActionBar(boolean z10) {
        C11839m.m70688i("WebViewManager", "initImmersiveActionBar");
        if (!C11829c.m70583i(m68794b(), this.f19614d, "initImmersive")) {
            C11839m.m70687e("WebViewManager", "initImmersive, url not in whitelist");
            return;
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = 111;
        messageObtain.obj = Boolean.valueOf(z10);
        Handler handler = this.f19619i;
        if (handler != null) {
            handler.sendMessage(messageObtain);
        }
    }

    @JavascriptInterface
    public boolean isDarkMode() {
        boolean zM70732H0 = C11842p.m70732H0(C0213f.m1377a());
        C11839m.m70688i("WebViewManager", "isDarkMode, isDark = " + zM70732H0);
        return zM70732H0;
    }

    @JavascriptInterface
    public boolean isHonorProduct() {
        return C0209d.m1269j1();
    }

    @JavascriptInterface
    public boolean isThirdAppSupportShare(String str) throws InterruptedException {
        String strM68794b = m68794b();
        if (C11829c.m70583i(strM68794b, this.f19614d, "isThirdAppSupportShare")) {
            C11839m.m70688i("WebViewManager", "isThirdAppSupportShare start");
            return !ThirdAppShareUtil.m25858d().getOrDefault(str, "").equals("");
        }
        C11839m.m70687e("WebViewManager", "setOnResumeListner, url is invalid");
        this.f19621k.m65707p(C11829c.m70560a0(strM68794b), Arrays.toString(this.f19614d));
        return false;
    }

    @JavascriptInterface
    public boolean isWebViewManagerDarkMode() {
        boolean zM70732H0 = C11842p.m70732H0(C0213f.m1377a());
        C11839m.m70688i("WebViewManager", "isWebViewManagerDarkMode, isDark = " + zM70732H0);
        return zM70732H0;
    }

    @JavascriptInterface
    public void jumpCampaignCentre() {
        C11839m.m70688i("WebViewManager", "jumpCampaignCentre");
        if (C11829c.m70583i(m68794b(), this.f19614d, "jumpCampaignCentre")) {
            C4308a.m25907f(this.f19613c, this.f19616f);
        } else {
            C11839m.m70687e("WebViewManager", "startQuest, url is invalid");
        }
    }

    @JavascriptInterface
    public void jumpCloudNotifySettingPage() throws InterruptedException {
        String strM68794b = m68794b();
        if (!C11829c.m70583i(strM68794b, this.f19614d, "jumpCloudNotifySettingPage")) {
            C11839m.m70687e("WebViewManager", "jumpCloudNotifySettingPage, url is invalid");
            this.f19621k.m65707p(C11829c.m70560a0(strM68794b), Arrays.toString(this.f19614d));
        } else {
            Intent intent = new Intent("android.settings.APP_NOTIFICATION_SETTINGS");
            intent.putExtra("android.provider.extra.APP_PACKAGE", "com.huawei.hidisk");
            intent.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
            C0224k0.m1542L(m68795c().getContext(), intent);
        }
    }

    @JavascriptInterface
    public void jumpToBrowser(String str) {
        C11839m.m70688i("WebViewManager", "jumpToBrowser");
        if (C11829c.m70583i(m68794b(), this.f19614d, "jumpToBrowser")) {
            C11829c.m70552W0(this.f19613c, str);
        } else {
            C11839m.m70687e("WebViewManager", "jumpToBrowser, url is invalid");
        }
    }

    @JavascriptInterface
    public int jumpToDownloadPage(String str, String str2) throws InterruptedException {
        C11839m.m70688i("WebViewManager", "jumpToDownloadPage, uniqueId:" + str2);
        String strM68794b = m68794b();
        if (C11829c.m70583i(strM68794b, this.f19614d, "jumpToDownloadPage")) {
            return C1403f.m8066n().m8106x(str, str2);
        }
        C11839m.m70687e("WebViewManager", "url is invalid");
        this.f19621k.m65707p(C11829c.m70560a0(strM68794b), Arrays.toString(this.f19614d));
        return -100;
    }

    @JavascriptInterface
    public int jumpToHalfDownloadPage(String str, String str2) {
        C11839m.m70688i("WebViewManager", "jumpToHalfDownloadPage, uniqueId:" + str2);
        if (C11829c.m70583i(m68794b(), this.f19614d, "jumpToHalfDownloadPage")) {
            return C1403f.m8066n().m8107y(str, str2);
        }
        C11839m.m70687e("WebViewManager", "jumpToHalfDownloadPage, url is invalid");
        return -100;
    }

    @JavascriptInterface
    public void jumpToStaticWebViewPage(String str, String str2) {
        C11839m.m70686d("WebViewManager", "jumpToStaticWebViewPage");
        if (C11829c.m70583i(m68794b(), this.f19614d, "jumpToStaticWebViewPage")) {
            C11829c.m70554X0(this.f19613c, str, str2);
        } else {
            C11839m.m70687e("WebViewManager", "jumpToOperationWebView, url is invalid");
        }
    }

    @JavascriptInterface
    public String loadAds(boolean z10, String str, String[] strArr, int i10, List<String> list) {
        C11839m.m70688i("WebViewManager", "loadAds");
        return loadAdsWithExtend(z10, str, strArr, i10, list, null);
    }

    @JavascriptInterface
    public String loadAdsBySrc(String str, int i10, String str2) throws InterruptedException {
        C11839m.m70688i("WebViewManager", "loadAdsBySrc src: " + str + " adNum: " + i10);
        String strM68794b = m68794b();
        if (C11829c.m70583i(strM68794b, this.f19614d, "loadAdsBySrc")) {
            return HiCloudNativeAd.CHANNEL_PRE.equals(str) ? m25887H(i10) : HiCloudNativeAd.CHANNEL_PPS.equals(str) ? m25886G(i10, str2) : (HiCloudNativeAd.CHANNEL_AGD.equals(str) || HiCloudNativeAd.CHANNEL_AGG.equals(str)) ? m25885F(i10, str) : "";
        }
        C11839m.m70687e("WebViewManager", "loadAdsBySrc url is invalid");
        this.f19621k.m65707p(C11829c.m70560a0(strM68794b), Arrays.toString(this.f19614d));
        return "";
    }

    @JavascriptInterface
    public String loadAdsWithExtend(boolean z10, String str, String[] strArr, int i10, List<String> list, String str2) throws InterruptedException {
        C11839m.m70688i("WebViewManager", "loadAdsWithExtend");
        int iM25895r = m25895r(m25893p(str2));
        C11839m.m70688i("WebViewManager", "loadAdsWithExtend maxAdsNum:" + iM25895r);
        String strM68794b = m68794b();
        if (!C11829c.m70583i(strM68794b, this.f19614d, "loadAdsWithExtend")) {
            C11839m.m70687e("WebViewManager", "loadAds, url is invalid");
            this.f19621k.m65707p(C11829c.m70560a0(strM68794b), Arrays.toString(this.f19614d));
            return "";
        }
        C3019c1 c3019c1 = new C3019c1(z10, str, strArr, i10, list, iM25895r);
        CountDownLatch countDownLatchM18227q = c3019c1.m18227q();
        boolean zAwait = false;
        C12515a.m75110o().m75175e(c3019c1, false);
        try {
            zAwait = countDownLatchM18227q.await(30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e10) {
            C11839m.m70687e("WebViewManager", "loadAdsTask exception:" + e10.toString());
        }
        C11839m.m70688i("WebViewManager", "loadAdsTask Result:" + zAwait);
        C11839m.m70688i("WebViewManager", "loadAdsTask result return:" + c3019c1.m18228r());
        return c3019c1.m18228r();
    }

    /* renamed from: n */
    public int m25891n(boolean z10) throws IllegalAccessException, IllegalArgumentException {
        Activity activity = this.f19613c;
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a == null) {
            C11839m.m70688i("WebViewManager", "cloudAlbumRouterImpl is null");
            return 1;
        }
        interfaceC9282a.mo58391R0();
        if (!C0209d.m1333z1(activity)) {
            C11839m.m70688i("WebViewManager", "network is unavailable.");
            Toast.makeText(activity, activity.getResources().getString(R$string.no_network_available), 0).show();
            return 1;
        }
        if (interfaceC9282a.mo58456t0(activity)) {
            C11841o.m70706b(this.f19613c, activity.getResources().getString(R$string.gallery_shelve_battery_low, C2783d.m16144h(10)), 0);
            return 1;
        }
        boolean zM1254f2 = C0209d.m1254f2(activity);
        C11839m.m70688i("WebViewManager", "wifi is connected:" + zM1254f2);
        if (zM1254f2) {
            m25892o(interfaceC9282a, activity, z10, false);
        } else {
            m25888I(interfaceC9282a, activity, z10, true);
        }
        return 0;
    }

    @JavascriptInterface
    public void navToSpecPage(String str, String str2) throws InterruptedException {
        String strM68794b = m68794b();
        if (C11829c.m70583i(strM68794b, this.f19614d, "navToSpecPage")) {
            C1398a.m8026s(str, this.f19621k.m65699g(str2));
        } else {
            C11839m.m70687e("WebViewManager", "navToSpecPage, url is invalid");
            this.f19621k.m65707p(C11829c.m70560a0(strM68794b), Arrays.toString(this.f19614d));
        }
    }

    @JavascriptInterface
    public void newBusinessChangeSuccess() {
        C11839m.m70688i("WebViewManager", "startLoadWebView newBusinessChangeSuccess.");
        C13452e.m80781L().m80985w2(true);
        ArrayList arrayList = new ArrayList();
        arrayList.add("bs.bm.type");
        arrayList.add("bs.bm.usergrade.info");
        C12515a.m75110o().m75175e(new C11079e(new C11079e.a() { // from class: je.h0
            @Override // p431ko.C11079e.a
            /* renamed from: a */
            public final void mo14511a(UserDataStateInfo userDataStateInfo) {
                WebViewManager.m25870E(userDataStateInfo);
            }
        }, false, arrayList, "BusinessChange"), false);
    }

    /* renamed from: o */
    public void m25892o(InterfaceC9282a interfaceC9282a, Context context, boolean z10, boolean z11) {
        boolean zM5975v = C1006a.m5936k().m5975v(context);
        C11839m.m70688i("WebViewManager", "album switch is :" + zM5975v);
        if (!zM5975v) {
            interfaceC9282a.mo58414c(C0213f.m1377a(), 23);
        }
        if (z11) {
            interfaceC9282a.mo58455t(context, true);
        }
        if (z10) {
            C11839m.m70688i("WebViewManager", "is new huawei gallery.");
            Intent intent = new Intent("com.huawei.gallery.action.VIEW_DOWNLOAD_LIST");
            intent.putExtra("autoDownloadAll", true);
            C0209d.m1302r2(intent, C13843a.m83054F(context));
            C0224k0.m1542L(context, intent);
            interfaceC9282a.mo58382N(context, z11);
            return;
        }
        C11839m.m70688i("WebViewManager", "is not new huawei gallery.");
        PackageManager packageManager = context.getPackageManager();
        String strM83054F = C13843a.m83054F(context);
        Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(strM83054F);
        launchIntentForPackage.setFlags(337641472);
        C0209d.m1302r2(launchIntentForPackage, strM83054F);
        C0224k0.m1542L(context, launchIntentForPackage);
    }

    @JavascriptInterface
    public void onAdClose(String str, String str2, List<String> list) throws InterruptedException {
        String strM68794b = m68794b();
        if (!C11829c.m70583i(strM68794b, this.f19614d, "onAdClose")) {
            C11839m.m70687e("WebViewManager", "onAdClose, url is invalid");
            this.f19621k.m65707p(C11829c.m70560a0(strM68794b), Arrays.toString(this.f19614d));
        } else {
            INativeAd iNativeAdM8098p = C1403f.m8066n().m8098p(str, str2);
            if (iNativeAdM8098p == null) {
                return;
            }
            iNativeAdM8098p.onAdClose(C0213f.m1377a(), list);
        }
    }

    @JavascriptInterface
    public void onQuestCallBack(String str) {
        C11839m.m70686d("WebViewManager", "onQuestCallBack");
        if (C11829c.m70583i(m68794b(), this.f19614d, "onQuestCallBack")) {
            C12997e.m78032y(str);
        } else {
            C11839m.m70687e("WebViewManager", "onQuestCallBack, url is invalid");
        }
    }

    @JavascriptInterface
    public void openAgdApp(String str, String str2) throws InterruptedException {
        String strM68794b = m68794b();
        if (C11829c.m70583i(strM68794b, this.f19614d, "openAgdApp")) {
            C1403f.m8066n().m8068B(str, str2);
        } else {
            C11839m.m70687e("WebViewManager", "openAgdApp, url is invalid");
            this.f19621k.m65707p(C11829c.m70560a0(strM68794b), Arrays.toString(this.f19614d));
        }
    }

    @JavascriptInterface
    public void openPayAgreement() throws InterruptedException {
        C11839m.m70688i("WebViewManager", "openPayAgreement");
        String strM68794b = m68794b();
        if (C11829c.m70583i(strM68794b, this.f19614d, "openPayAgreement")) {
            new LearnMorePayClickListener(this.f19613c, "/payagreement?lang=").onClick();
        } else {
            C11839m.m70687e("WebViewManager", "pauseDownload, url is invalid");
            this.f19621k.m65707p(C11829c.m70560a0(strM68794b), Arrays.toString(this.f19614d));
        }
    }

    @JavascriptInterface
    public void operationBiReport(String str, String str2) throws JSONException, InterruptedException {
        C11839m.m70686d("WebViewManager", "operationBiReport");
        try {
            String strM68794b = m68794b();
            if (!C11829c.m70583i(strM68794b, this.f19614d, "operationBiReport")) {
                C11839m.m70687e("WebViewManager", "operationBiReport, url is invalid");
                this.f19621k.m65707p(C11829c.m70560a0(strM68794b), Arrays.toString(this.f19614d));
                return;
            }
            JSONObject jSONObjectM79482j = C13223b.m79482j(C0213f.m1377a(), str, "1", C13452e.m80781L().m80971t0(), "2");
            LinkedHashMap linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
            if (!TextUtils.isEmpty(str2)) {
                JSONObject jSONObject = new JSONObject(str2);
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    String string = jSONObject.getString(next);
                    jSONObjectM79482j.put(next, string);
                    linkedHashMapM79499C.put(next, string);
                }
            }
            C13227f.m79492i1().m79602z(jSONObjectM79482j);
            UBAAnalyze.m29963X("PVC", str, "3", "47", jSONObjectM79482j);
            C13227f.m79492i1().m79591l0(str, linkedHashMapM79499C);
            UBAAnalyze.m29958S("PVC", str, "3", "47", linkedHashMapM79499C);
        } catch (JSONException e10) {
            C11839m.m70687e("WebViewManager", "operationReport exception " + e10.getMessage());
        }
    }

    /* renamed from: p */
    public final JSONObject m25893p(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return new JSONObject(str);
            } catch (JSONException e10) {
                C11839m.m70688i("WebViewManager", "getExtendParams, json error: " + e10.toString());
            }
        }
        return null;
    }

    @JavascriptInterface
    public void pauseDownload(String str, String str2) throws InterruptedException {
        C11839m.m70688i("WebViewManager", "pauseDownload, uniqueId:" + str2);
        String strM68794b = m68794b();
        if (C11829c.m70583i(strM68794b, this.f19614d, "pauseDownload")) {
            C1403f.m8066n().m8069C(str, str2);
        } else {
            C11839m.m70687e("WebViewManager", "pauseDownload, url is invalid");
            this.f19621k.m65707p(C11829c.m70560a0(strM68794b), Arrays.toString(this.f19614d));
        }
    }

    /* renamed from: q */
    public final String m25894q(List<String> list) {
        HashMap map = new HashMap();
        Gson gson = new Gson();
        try {
            for (String str : list) {
                C11839m.m70687e("WebViewManager", "getLocalParams, key = " + str);
                if (str.equals("cnt.user.name")) {
                    map.put(str, C13452e.m80781L().m80841P());
                } else if (str.equals("cnt.user.icon")) {
                    m25882w(map, 64, str);
                } else if (str.equals("cnt.syncbak.app.list")) {
                    m25897v(map, gson, str);
                } else if (TextUtils.equals(str, "cnt.first.restore.list")) {
                    m25896s(map, str);
                }
            }
            return gson.toJson(map);
        } catch (Exception e10) {
            C11839m.m70687e("WebViewManager", "getLocalParams, err " + e10.getMessage());
            return "";
        }
    }

    @JavascriptInterface
    public String queryShowTaskCon(String str) {
        C11839m.m70688i("WebViewManager", "queryShowTaskCon, incentiveActivityId: " + str);
        if (!C11829c.m70583i(m68794b(), this.f19614d, "queryShowTaskCon")) {
            C11839m.m70687e("WebViewManager", "startQuest, url is invalid");
            return null;
        }
        if (C0209d.m1293p1()) {
            return null;
        }
        return C4308a.m25914m(str);
    }

    /* renamed from: r */
    public final int m25895r(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.has("maxAdsNum")) {
            try {
                return jSONObject.getInt("maxAdsNum");
            } catch (JSONException e10) {
                C11839m.m70688i("WebViewManager", "getMaxAdsNum, json error: " + e10.toString());
            }
        }
        return 10;
    }

    @JavascriptInterface
    public boolean recordClickEvent(String str, String str2, String str3) {
        return this.f19621k.m65710s(m68794b(), this.f19614d, str, str2, str3);
    }

    @JavascriptInterface
    public boolean recordImpressionEvent(String str, String str2, String str3) {
        return this.f19621k.m65711t(m68794b(), this.f19614d, str, str2, str3);
    }

    @JavascriptInterface
    public boolean recordShowStartEvent(String str, String str2, String str3) {
        return this.f19621k.m65712u(m68794b(), this.f19614d, str, str2, str3);
    }

    @JavascriptInterface
    public void reportBI(String str, String str2, String str3) throws InterruptedException {
        try {
            String strM68794b = m68794b();
            if (!C11829c.m70583i(strM68794b, this.f19614d, "reportBI")) {
                C11839m.m70687e("WebViewManager", "reportBI, url is invalid");
                this.f19621k.m65707p(C11829c.m70560a0(strM68794b), Arrays.toString(this.f19614d));
                return;
            }
            LinkedHashMap linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
            linkedHashMapM79499C.put("phone_type", Build.MODEL);
            if (TextUtils.isEmpty(str2)) {
                C11839m.m70687e("WebViewManager", "eventKey null");
                return;
            }
            if (!TextUtils.equals("CKC", str) && !TextUtils.equals("PVC", str)) {
                C11839m.m70687e("WebViewManager", "eventType wrong");
                return;
            }
            if (!TextUtils.isEmpty(str3)) {
                JSONObject jSONObject = new JSONObject(str3);
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    linkedHashMapM79499C.put(next, jSONObject.getString(next));
                }
            }
            C13227f.m79492i1().m79591l0(str2, linkedHashMapM79499C);
            UBAAnalyze.m29958S(str, str2, "3", "47", linkedHashMapM79499C);
        } catch (JSONException e10) {
            C11839m.m70687e("WebViewManager", "reportBI exception " + e10.getMessage());
        }
    }

    @JavascriptInterface
    public void reportCampaignDownload(String str, String str2) {
        C11839m.m70688i("WebViewManager", "reportCampaignDownload");
        if (C11829c.m70583i(m68794b(), this.f19614d, "reportCampaignDownload")) {
            C10797k0.m65696v(this.f19620j, str, str2);
        } else {
            C11839m.m70687e("WebViewManager", "reportCampaignDownload, url is invalid");
        }
    }

    @JavascriptInterface
    public void reportCampaignLaunched(String str, String str2) {
        C11839m.m70688i("WebViewManager", "reportCampaignLaunched");
        if (C11829c.m70583i(m68794b(), this.f19614d, "reportCampaignLaunched")) {
            C10797k0.m65697w(this.f19620j, str, str2);
        } else {
            C11839m.m70687e("WebViewManager", "reportCampaignLaunched, url is invalid");
        }
    }

    @JavascriptInterface
    public void reportClickEvent(String str, String str2, String str3) {
        this.f19621k.m65713x(m68794b(), this.f19614d, str, str2, str3);
    }

    @JavascriptInterface
    public void requestOpenIdentifyKit() throws InterruptedException {
        String strM68794b = m68794b();
        if (C11829c.m70583i(strM68794b, this.f19614d, "requestOpenIdentifyKit")) {
            Address.getAddressClient(this.f19613c).getUserAddress(new UserAddressRequest()).addOnSuccessListener(new C4307j()).addOnFailureListener(new C4306i());
        } else {
            C11839m.m70687e("WebViewManager", "pauseDownload, url is invalid");
            this.f19621k.m65707p(C11829c.m70560a0(strM68794b), Arrays.toString(this.f19614d));
        }
    }

    @JavascriptInterface
    public int resumeDownload(String str, String str2) throws InterruptedException {
        C11839m.m70688i("WebViewManager", "resumeDownload, uniqueId:" + str2);
        String strM68794b = m68794b();
        if (C11829c.m70583i(strM68794b, this.f19614d, "resumeDownload")) {
            return C1403f.m8066n().m8074H(str, str2);
        }
        C11839m.m70687e("WebViewManager", "resumeDownload, url is invalid");
        this.f19621k.m65707p(C11829c.m70560a0(strM68794b), Arrays.toString(this.f19614d));
        return -100;
    }

    /* renamed from: s */
    public final void m25896s(Map<String, String> map, String str) {
        map.put(str, C13462b.m81015c().m81018d("restoreDataDictionary", ""));
    }

    @JavascriptInterface
    public boolean saveSharePicture(String str) throws InterruptedException, IOException {
        String strM68794b = m68794b();
        if (!C11829c.m70583i(strM68794b, this.f19614d, "saveSharePicture")) {
            C11839m.m70687e("WebViewManager", "setOnResumeListner, url is invalid");
            this.f19621k.m65707p(C11829c.m70560a0(strM68794b), Arrays.toString(this.f19614d));
            return false;
        }
        C11839m.m70688i("WebViewManager", "saveSharePicture start");
        String str2 = Environment.getExternalStorageDirectory() + "/Pictures/Huawei Cloud/";
        String str3 = "cloud-share-" + System.currentTimeMillis() + ".png";
        if (str == null) {
            return false;
        }
        try {
            File file = new File(str2 + str3);
            if (!file.getParentFile().exists() && !file.getParentFile().mkdirs()) {
                C11839m.m70687e("WebViewManager", "failed to mkdirs");
                return false;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                try {
                    byte[] bArrDecode = SafeBase64.decode(str, 0);
                    for (int i10 = 0; i10 < bArrDecode.length; i10++) {
                        byte b10 = bArrDecode[i10];
                        if (b10 < 0) {
                            bArrDecode[i10] = (byte) (b10 + 256);
                        }
                    }
                    fileOutputStream.write(bArrDecode);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    Context contextM1377a = C0213f.m1377a();
                    if (contextM1377a != null) {
                        C10805s.m65772c(contextM1377a, str2 + str3, true);
                        showToast(contextM1377a.getResources().getString(R$string.save_picture_success));
                    }
                    fileOutputStream.close();
                    return true;
                } catch (Throwable th2) {
                    fileOutputStream.close();
                    throw th2;
                }
            } catch (Exception e10) {
                C11839m.m70687e("WebViewManager", e10.getMessage());
                fileOutputStream.close();
                return false;
            }
        } catch (Exception e11) {
            C11839m.m70687e("WebViewManager", e11.getMessage());
            return false;
        }
    }

    @JavascriptInterface
    public void scrollByCard(int i10, String str) {
        C11839m.m70688i("WebViewManager", "scrollByCard, card: " + i10 + ", direction: " + str);
        if (!C11829c.m70583i(m68794b(), this.f19614d, "scrollByCard")) {
            C11839m.m70687e("WebViewManager", "startQuest, url is invalid");
        } else {
            if (str == null) {
                return;
            }
            C4308a.m25918q(i10, str);
        }
    }

    @JavascriptInterface
    public void setActionBarBackground() {
        if (!C11829c.m70583i(m68794b(), this.f19614d, "initImmersive")) {
            C11839m.m70687e("WebViewManager", "setActionBarBackground, url not in whitelist");
            return;
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = 112;
        Handler handler = this.f19619i;
        if (handler != null) {
            handler.sendMessage(messageObtain);
        }
    }

    @JavascriptInterface
    public void setActionBarVisible(boolean z10) {
        C11839m.m70688i("WebViewManager", "setActionBarVisible: " + z10);
        Activity activity = this.f19613c;
        if (activity == null) {
            C11839m.m70687e("WebViewManager", "setActionBarVisible webViewActivity is null.");
            return;
        }
        ActionBar actionBar = activity.getActionBar();
        if (actionBar != null) {
            C0226l0.m1584d(new RunnableC4298a(z10, actionBar));
        }
    }

    @JavascriptInterface
    public void setAddressReportListener(String str) throws InterruptedException {
        String strM68794b = m68794b();
        if (C11829c.m70583i(strM68794b, this.f19614d, "setAddressReportListener")) {
            C1398a.m8027t(str);
        } else {
            C11839m.m70687e("WebViewManager", "pauseDownload, url is invalid");
            this.f19621k.m65707p(C11829c.m70560a0(strM68794b), Arrays.toString(this.f19614d));
        }
    }

    @JavascriptInterface
    public void setAdsStatus(String str) {
        C11839m.m70688i("WebViewManager", "setAdsStatus history: " + str);
        if (C11829c.m70583i(m68794b(), this.f19614d, "setAdsStatus")) {
            new C10219d(str).m63381g();
        } else {
            C11839m.m70687e("WebViewManager", "setAdsStatus, url not in whitelist");
        }
    }

    @JavascriptInterface
    public void setAppInstallStatus(String str, boolean z10) {
        C11839m.m70688i("WebViewManager", "setAppInstallStatus");
        if (!C11829c.m70583i(m68794b(), this.f19614d, "setAppInstallStatus")) {
            C11839m.m70687e("WebViewManager", "setAppInstallStatus, url is invalid");
        } else if (z10) {
            PPSDownloadingAdsManager.m16469e().m16471b("downloadApp", str);
        } else {
            PPSDownloadingAdsManager.m16469e().m16475h("downloadApp", str);
        }
    }

    @JavascriptInterface
    public void setCampaignInfo(String str) throws InterruptedException {
        String strM68794b = m68794b();
        if (C11829c.m70583i(strM68794b, this.f19614d, "setCampaignInfo")) {
            C1398a.m8028u(str);
        } else {
            C11839m.m70687e("WebViewManager", "pauseDownload, url is invalid");
            this.f19621k.m65707p(C11829c.m70560a0(strM68794b), Arrays.toString(this.f19614d));
        }
    }

    @JavascriptInterface
    public void setDownLoadReportListener(String str) throws InterruptedException {
        String strM68794b = m68794b();
        if (C11829c.m70583i(strM68794b, this.f19614d, "setDownLoadReportListener")) {
            C1398a.m8029v(str);
        } else {
            C11839m.m70687e("WebViewManager", "pauseDownload, url is invalid");
            this.f19621k.m65707p(C11829c.m70560a0(strM68794b), Arrays.toString(this.f19614d));
        }
    }

    @JavascriptInterface
    public void setExitFlag(boolean z10) throws InterruptedException {
        String strM68794b = m68794b();
        if (!C11829c.m70583i(strM68794b, this.f19614d, "setExitFlag")) {
            C11839m.m70687e("WebViewManager", "setExitFlag, url is invalid");
            this.f19621k.m65707p(C11829c.m70560a0(strM68794b), Arrays.toString(this.f19614d));
            return;
        }
        WebViewManagerCallback webViewManagerCallback = this.f19622l;
        if (webViewManagerCallback != null) {
            webViewManagerCallback.mo20599i(z10);
        } else {
            C1398a.m8030w(z10);
        }
    }

    @JavascriptInterface
    public void setLaunchedReportListener(String str) throws InterruptedException {
        String strM68794b = m68794b();
        if (C11829c.m70583i(strM68794b, this.f19614d, "setLaunchedReportListener")) {
            C1398a.m8031x(str);
        } else {
            C11839m.m70687e("WebViewManager", "pauseDownload, url is invalid");
            this.f19621k.m65707p(C11829c.m70560a0(strM68794b), Arrays.toString(this.f19614d));
        }
    }

    @JavascriptInterface
    public void setOnAppOpenListener(String str) throws InterruptedException {
        String strM68794b = m68794b();
        if (C11829c.m70583i(strM68794b, this.f19614d, "setOnAppOpenListener")) {
            C1398a.m8032y(str);
            C1403f.m8066n().m8081O(str);
        } else {
            C11839m.m70687e("WebViewManager", "setOnAppOpenListener, url is invalid");
            this.f19621k.m65707p(C11829c.m70560a0(strM68794b), Arrays.toString(this.f19614d));
        }
    }

    @JavascriptInterface
    public void setOnBackListner(String str) throws InterruptedException {
        String strM68794b = m68794b();
        if (C11829c.m70583i(strM68794b, this.f19614d, "setOnBackListner")) {
            C1398a.m8033z(str);
        } else {
            C11839m.m70687e("WebViewManager", "setOnBackListner, url is invalid");
            this.f19621k.m65707p(C11829c.m70560a0(strM68794b), Arrays.toString(this.f19614d));
        }
    }

    @JavascriptInterface
    public void setOnDownloadProgressListener(String str) throws InterruptedException {
        String strM68794b = m68794b();
        if (C11829c.m70583i(strM68794b, this.f19614d, "setOnDownloadProgressListener")) {
            C1398a.m8001A(str);
            C1403f.m8066n().m8082P(str);
        } else {
            C11839m.m70687e("WebViewManager", "setOnDownloadProgressListener, url is invalid");
            this.f19621k.m65707p(C11829c.m70560a0(strM68794b), Arrays.toString(this.f19614d));
        }
    }

    @JavascriptInterface
    public void setOnResumeListner(String str) throws InterruptedException {
        C11839m.m70688i("WebViewManager", "setOnResumeListner");
        String strM68794b = m68794b();
        if (C11829c.m70583i(strM68794b, this.f19614d, "setOnResumeListner")) {
            C1398a.m8002B(str);
        } else {
            C11839m.m70687e("WebViewManager", "setOnResumeListner, url is invalid");
            this.f19621k.m65707p(C11829c.m70560a0(strM68794b), Arrays.toString(this.f19614d));
        }
    }

    @JavascriptInterface
    public void setOnStatusChangedListener(String str) throws InterruptedException {
        String strM68794b = m68794b();
        if (C11829c.m70583i(strM68794b, this.f19614d, "setOnStatusChangedListener")) {
            C1398a.m8003C(str);
            C1403f.m8066n().m8083Q(str);
        } else {
            C11839m.m70687e("WebViewManager", "setOnStatusChangedListener, url is invalid");
            this.f19621k.m65707p(C11829c.m70560a0(strM68794b), Arrays.toString(this.f19614d));
        }
    }

    @JavascriptInterface
    public void setPreferences(String str, String str2) {
        C11839m.m70688i("WebViewManager", "H5 set key: " + str + "; value: " + str2);
        C13448a.m80777c().m80780d(str, str2);
    }

    @JavascriptInterface
    public void setRefreshCloudFlag(boolean z10) throws InterruptedException {
        String strM68794b = m68794b();
        if (!C11829c.m70583i(strM68794b, this.f19614d, "setRefreshCloudFlag")) {
            C11839m.m70687e("WebViewManager", "setRefreshCloudFlag, url is invalid");
            this.f19621k.m65707p(C11829c.m70560a0(strM68794b), Arrays.toString(this.f19614d));
        } else {
            C1398a.m8004D(z10);
            C12331w c12331w = new C12331w(true, true, 29);
            C11839m.m70688i("WebViewManager", "open gallery switch by incentive download");
            C12515a.m75110o().m75172d(c12331w);
        }
    }

    @JavascriptInterface
    public int setSwitchStatus(int i10, String str, int i11) {
        C11839m.m70688i("WebViewManager", "setSwitchStatus serviceType: " + i10 + ", syncType:" + str + ", status:" + i11);
        if (!C11829c.m70583i(m68794b(), this.f19614d, "setSwitchStatus")) {
            C11839m.m70687e("WebViewManager", "setSwitchStatus, url not in whitelist");
            return -1;
        }
        boolean z10 = i11 == 1;
        if (i10 == 1) {
            C1008c.m6035v().m6063a0(C0213f.m1377a(), str, i11);
            return C12597u1.m76032h(str, i11);
        }
        if (i10 != 2) {
            if (i10 == 3) {
                return !C14315h.m85262p().m85272K(z10) ? 1 : 0;
            }
            return -1;
        }
        if (z10) {
            C1008c.m6035v().m6081j0(C0213f.m1377a());
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("GeneralAblum", z10);
        bundle.putBoolean("ShareAlbum", z10);
        C1006a.m5936k().m5951O(z10, C0213f.m1377a());
        C1006a.m5936k().m5943G(C0213f.m1377a(), bundle, 19);
        return 0;
    }

    @JavascriptInterface
    public void showToast(String str) throws InterruptedException {
        String strM68794b = m68794b();
        if (C11829c.m70583i(strM68794b, this.f19614d, "showToast")) {
            C1403f.m8066n().m8084R(str);
        } else {
            C11839m.m70687e("WebViewManager", "showToast, url is invalid");
            this.f19621k.m65707p(C11829c.m70560a0(strM68794b), Arrays.toString(this.f19614d));
        }
    }

    @JavascriptInterface
    public int startDownload(String str, String str2) throws InterruptedException {
        C11839m.m70688i("WebViewManager", "startDownload, uniqueId:" + str2);
        String strM68794b = m68794b();
        if (C11829c.m70583i(strM68794b, this.f19614d, "startDownload")) {
            return C1403f.m8066n().m8085S(str, str2);
        }
        C11839m.m70687e("WebViewManager", "url is invalid");
        this.f19621k.m65707p(C11829c.m70560a0(strM68794b), Arrays.toString(this.f19614d));
        return -100;
    }

    @JavascriptInterface
    public void startPayForSignGift(String str, String str2, String str3, String str4) throws JSONException, InterruptedException {
        C11839m.m70688i("WebViewManager", "startPayForSignGift");
        String strM68794b = m68794b();
        if (!C11829c.m70583i(strM68794b, this.f19614d, "startPayForSignGift")) {
            C11839m.m70687e("WebViewManager", "pauseDownload, url is invalid");
            this.f19621k.m65707p(C11829c.m70560a0(strM68794b), Arrays.toString(this.f19614d));
            return;
        }
        CampaignInfo campaignInfo = new CampaignInfo();
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString(NotifyConstants.MarketingConstant.CID_KEY);
            String string2 = jSONObject.getString("cType");
            String string3 = jSONObject.getString("adId");
            String string4 = jSONObject.getString("tid");
            campaignInfo.setcId(string);
            campaignInfo.setcType(string2);
            campaignInfo.setAdId(string3);
            campaignInfo.setTid(string4);
        } catch (Exception e10) {
            C11839m.m70688i("WebViewManager", "startPayForSignGift JSONException: " + e10.getMessage());
        }
        if (this.f19613c == null) {
            C11839m.m70687e("WebViewManager", "startPayForSignGift webViewActivity is null.");
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.huawei.hicloud.intent.action.accept.gift.success");
        C13108a.m78878b(this.f19613c).m78880c(new AcceptGiftSuccessBroadcastReceiver(this.f19613c), intentFilter);
        Intent intent = new Intent();
        intent.setClass(C0213f.m1377a(), CloudSpaceUpgradeGiftSignActivity.class);
        intent.putExtra("from_where", 4);
        intent.putExtra("accept_sign_campaign_info", campaignInfo);
        intent.putExtra("srcChannel", str2);
        intent.putExtra("salChannel", str3);
        intent.putExtra("activityCode", str4);
        this.f19613c.startActivity(intent);
    }

    @JavascriptInterface
    public void startQuest(String str, String str2) {
        C11839m.m70686d("WebViewManager", "startQuest questId: " + str + ",sessionId: " + str2);
        if (C0209d.m1226Y0()) {
            C11839m.m70689w("WebViewManager", "fast click");
        } else if (C11829c.m70583i(m68794b(), this.f19614d, "startQuest")) {
            C4308a.m25922u(this.f19613c, this.f19619i, str, str2, this.f19616f);
        } else {
            C11839m.m70687e("WebViewManager", "startQuest, url is invalid");
        }
    }

    @JavascriptInterface
    public boolean startShareTextToThirdApp(String str, String str2) throws InterruptedException {
        String strM68794b = m68794b();
        if (!C11829c.m70583i(strM68794b, this.f19614d, "startShareTextToThirdApp")) {
            C11839m.m70687e("WebViewManager", "setOnResumeListner, url is invalid");
            this.f19621k.m65707p(C11829c.m70560a0(strM68794b), Arrays.toString(this.f19614d));
            return false;
        }
        Context contextM1377a = C0213f.m1377a();
        C11839m.m70688i("WebViewManager", "startShareTextToThirdApp start");
        if (!isThirdAppSupportShare(str)) {
            showToast(contextM1377a.getResources().getString(R$string.unsupported_sharing_app));
            return false;
        }
        boolean zM25860f = ThirdAppShareUtil.m25860f(contextM1377a, str, str2, InterfaceC5483d.f25083i);
        if (zM25860f) {
            this.f19621k.m65706o(str);
        } else {
            showToast(contextM1377a.getResources().getString(R$string.app_not_install));
        }
        return zM25860f;
    }

    @JavascriptInterface
    public boolean startShareUrlCardToThirdApp(String str, String str2, String str3, String str4, String str5) throws InterruptedException {
        String strM68794b = m68794b();
        if (!C11829c.m70583i(strM68794b, this.f19614d, "startShareUrlCardToThirdApp")) {
            C11839m.m70687e("WebViewManager", "setOnResumeListner, url is invalid");
            this.f19621k.m65707p(C11829c.m70560a0(strM68794b), Arrays.toString(this.f19614d));
            return false;
        }
        Context contextM1377a = C0213f.m1377a();
        C11839m.m70688i("WebViewManager", "startShareUrlCardToThirdApp start");
        if (!str.equals("wechat_friend") && !str.equals("wechat_moments")) {
            showToast(contextM1377a.getResources().getString(R$string.unsupported_sharing_app));
            return false;
        }
        boolean zM25861g = ThirdAppShareUtil.m25861g(contextM1377a, str, str2, str3, str4, str5);
        if (zM25861g) {
            this.f19621k.m65706o(str);
        } else {
            showToast(contextM1377a.getResources().getString(R$string.app_not_install));
        }
        return zM25861g;
    }

    @JavascriptInterface
    public void triggerClick(String str, String str2, String str3) {
        this.f19621k.m65714y(m68794b(), this.f19614d, str, str2, str3);
    }

    @JavascriptInterface
    public boolean turnOnNotificationSwitch() throws IllegalAccessException, InterruptedException, PackageManager.NameNotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        String strM68794b = m68794b();
        if (!C11829c.m70583i(strM68794b, this.f19614d, "turnOnNotificationSwitch")) {
            C11839m.m70687e("WebViewManager", "turnOnNotificationSwitch, url is invalid");
            this.f19621k.m65707p(C11829c.m70560a0(strM68794b), Arrays.toString(this.f19614d));
            return false;
        }
        C10028c.m62182c0().m62382q3(false);
        boolean zM79784a = C13306h.m79781d(C0213f.m1377a()).m79784a();
        C11839m.m70688i("WebViewManager", "turnOnNotificationSwitch, areNotificationsEnabled: " + zM79784a);
        if (zM79784a) {
            return true;
        }
        try {
            ApplicationInfo applicationInfo = C0213f.m1377a().getPackageManager().getApplicationInfo("com.huawei.hidisk", 0);
            if (C0209d.m1277l1()) {
                HwNotificationManagerImpl.getInstance().setNotificationsEnabledForPackage("com.huawei.hidisk", applicationInfo.uid, true);
            } else {
                Class<?> cls = Class.forName("com.huawei.systemmanager.notificationmanager.HwNotificationManagerImpl");
                cls.getMethod("setNotificationsEnabledForPackage", String.class, Integer.TYPE, Boolean.TYPE).invoke(cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]), "com.huawei.hidisk", Integer.valueOf(applicationInfo.uid), Boolean.TRUE);
            }
        } catch (Exception e10) {
            C11839m.m70688i("WebViewManager", "turnOnNotificationSwitch exception " + e10.getMessage());
        }
        boolean zM79784a2 = C13306h.m79781d(C0213f.m1377a()).m79784a();
        C11839m.m70688i("WebViewManager", "turnOnNotificationSwitch, notificationsEnabled: " + zM79784a2);
        return zM79784a2;
    }

    @JavascriptInterface
    public void userActionReportBasic(String str, String str2) {
        C11839m.m70688i("WebViewManager", "userActionReportBasic");
        C12515a.m75110o().m75172d(new C11081g(str2, str));
    }

    /* renamed from: v */
    public final void m25897v(final Map<String, String> map, final Gson gson, final String str) throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        C12515a.m75110o().m75175e(new C12196w(this.f19613c, new C12196w.c() { // from class: je.i0
            @Override // pm.C12196w.c
            /* renamed from: a */
            public final void mo65673a(CloudValuableAppDataBean cloudValuableAppDataBean) {
                WebViewManager.m25868B(map, str, gson, countDownLatch, cloudValuableAppDataBean);
            }
        }, 3), true);
        try {
            countDownLatch.await(10L, TimeUnit.SECONDS);
        } catch (InterruptedException unused) {
            C11839m.m70687e("WebViewManager", "getLocalParams from server time out");
        }
    }

    /* renamed from: x */
    public final void m25898x(final CountDownLatch countDownLatch) {
        C11839m.m70688i("WebViewManager", "initActivityId");
        final Context contextM1377a = C0213f.m1377a();
        if (!C9718g.m60602t().m60607E(contextM1377a, false)) {
            C10270w c10270w = new C10270w(new Consumer() { // from class: je.g0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f51535a.m25884D(contextM1377a, countDownLatch, (GetCampaignActivityEntryResp) obj);
                }
            }, this.f19617g);
            c10270w.m63434i("WebViewManager");
            c10270w.m63381g();
        } else {
            this.f19616f = C13823d.m82904y().m82922f(contextM1377a);
            countDownLatch.countDown();
            C11839m.m70688i("WebViewManager", "initActivityId: " + this.f19616f);
        }
    }

    /* renamed from: y */
    public final /* synthetic */ Object m25899y(String str) throws Exception {
        C11839m.m70688i("WebViewManager", "getClientUiConfig, supplyAsync  start.");
        C11060c c11060c = new C11060c();
        c11060c.m66636B("06008");
        c11060c.m66643I(C11058a.m66627b("06008"));
        c11060c.m66637C("com.huawei.hidisk\u0001_cloudspace");
        c11060c.m66670z("2.0");
        String json = new Gson().toJson(C9948a.m61631C().m61703z(c11060c));
        C11839m.m70688i("WebViewManager", "getClientUiConfig, getData finish.");
        if (this.f19619i == null) {
            C11839m.m70687e("WebViewManager", "getClientUiConfig, mHandler == null.");
            return null;
        }
        Message message = new Message();
        message.what = 100;
        Bundle bundle = new Bundle();
        bundle.putString("javascript", String.format(Locale.ENGLISH, "%s(%s)", str, json));
        message.setData(bundle);
        this.f19619i.sendMessage(message);
        C11839m.m70688i("WebViewManager", "getClientUiConfig, sendMessage.");
        return null;
    }

    /* renamed from: z */
    public final /* synthetic */ Object m25900z(String str, String str2) throws Exception {
        List<String> arrayList = new ArrayList<>();
        try {
            arrayList = (List) C12540b1.m75484b(str, new C4305h().getType());
        } catch (JsonSyntaxException e10) {
            C11839m.m70688i("WebViewManager", "getLocalParamsAsync, JsonSyntaxException  e:" + e10.getMessage());
        }
        C11839m.m70688i("WebViewManager", "getLocalParamsAsync, supplyAsync  start.");
        String strM25894q = m25894q(arrayList);
        C11839m.m70688i("WebViewManager", "getLocalParamsAsync, getData finish.");
        if (this.f19619i == null) {
            C11839m.m70687e("WebViewManager", "getLocalParamsAsync, mHandler == null.");
            return null;
        }
        Message message = new Message();
        message.what = 100;
        Bundle bundle = new Bundle();
        bundle.putString("javascript", String.format(Locale.ENGLISH, "%s(%s)", str2, strM25894q));
        message.setData(bundle);
        this.f19619i.sendMessage(message);
        C11839m.m70688i("WebViewManager", "getLocalParamsAsync, sendMessage.");
        return null;
    }

    @JavascriptInterface
    public String getOperationResp(int i10, String str, String str2, String str3, String str4) {
        return this.f19621k.m65701j(m68794b(), this.f19614d, i10, str, str2, str3, str4);
    }

    @JavascriptInterface
    public int gotoCloudDisk() {
        return gotoCloudDisk(null);
    }

    @JavascriptInterface
    public void userActionReportBasic(String str, String str2, int i10) {
        C11839m.m70688i("WebViewManager", "userActionReportBasic dataStatus " + i10);
        C12515a.m75110o().m75172d(new C11081g(str2, str, i10 != 0 ? i10 != 1 ? i10 != 2 ? 0 : 14 : 13 : 12));
    }
}
