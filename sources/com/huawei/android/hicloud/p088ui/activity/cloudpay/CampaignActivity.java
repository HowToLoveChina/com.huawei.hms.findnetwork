package com.huawei.android.hicloud.p088ui.activity.cloudpay;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.MenuItem;
import android.webkit.DownloadListener;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;
import ca.C1400c;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.huawei.android.hicloud.cloudspace.campaign.bean.CalendarEventBean;
import com.huawei.android.hicloud.cloudspace.campaign.bean.H5TaskCacheBean;
import com.huawei.android.hicloud.manager.PPSDownloadingAdsManager;
import com.huawei.android.hicloud.p088ui.activity.BackupMainActivity;
import com.huawei.android.hicloud.p088ui.activity.HiCloudBaseWebViewActivity;
import com.huawei.android.hicloud.p088ui.activity.HisyncSpaceDetailActivity;
import com.huawei.android.hicloud.p088ui.activity.MainActivity;
import com.huawei.android.hicloud.p088ui.extend.AutoSizeButton;
import com.huawei.android.hicloud.p088ui.extend.NotchFitLinearLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout;
import com.huawei.android.hicloud.utils.C4308a;
import com.huawei.android.hicloud.utils.WebViewManager;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.bean.GetCampaignActivityEntryResp;
import com.huawei.hicloud.campaign.bean.CamJump;
import com.huawei.hicloud.campaign.bean.CampaignActivityConfig;
import com.huawei.hicloud.campaign.bean.CampaignActivityRoot;
import com.huawei.hicloud.campaign.bean.QuestAttributes;
import com.huawei.hicloud.campaign.bean.QuestBean;
import com.huawei.hicloud.campaign.bean.quest.CalendarNotifyAttr;
import com.huawei.hicloud.campaign.bean.quest.FutureSwitchAttr;
import com.huawei.hicloud.campaign.bean.quest.UploadFileAttr;
import com.huawei.hicloud.messagecenter.manager.MessageCenterManager;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.constants.RecommendCardConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.manager.AdSwitchManager;
import com.huawei.hicloud.notification.manager.HicloudH5ConfigManager;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.request.appmashup.bean.C4987f;
import com.huawei.hidisk.common.util.javautil.StringUtil;
import com.huawei.hms.ads.jsb.constant.Constant;
import com.huawei.hms.identity.AddressConstants;
import com.huawei.hms.network.embedded.C6010m7;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.huawei.openalliance.p169ad.inter.data.INativeAd;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.secure.android.common.intent.SafeBroadcastReceiver;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.secure.android.common.webview.SafeWebView;
import com.huawei.uikit.phone.hwcolumnlayout.widget.HwColumnLinearLayout;
import com.huawei.uikit.phone.hwprogressbar.widget.HwProgressBar;
import fj.C9718g;
import fk.C9721b;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import je.C10797k0;
import mu.C11524a;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0209d;
import p015ak.C0212e0;
import p015ak.C0213f;
import p037bp.C1270a;
import p054cj.C1442a;
import p232dp.InterfaceC9282a;
import p232dp.InterfaceC9287f;
import p292fn.C9733f;
import p329h7.C10120h;
import p336he.C10150a;
import p336he.C10151b;
import p341hj.C10219d;
import p341hj.C10270w;
import p373iu.C10620h;
import p393jd.C10775b;
import p429kk.C11058a;
import p454lj.C11280c;
import p494nk.C11718b;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11841o;
import p514o9.C11842p;
import p529op.C11983e;
import p572qb.C12331w;
import p616rk.C12515a;
import p618rm.C12540b1;
import p651t8.C12993a;
import p651t8.C12996d;
import p651t8.C12997e;
import p651t8.C12998f;
import p664u0.C13108a;
import p672u8.C13133c;
import p672u8.C13135e;
import p674ub.C13149f;
import p681uj.C13194k;
import p681uj.C13199p;
import p684un.C13222a;
import p684un.C13223b;
import p684un.C13227f;
import p684un.C13230i;
import p709vj.C13452e;
import p778xk.C13821b;
import p778xk.C13823d;
import p778xk.C13826g;
import p802y8.AbstractC13919c;
import p836z8.C14157f;
import sk.C12808e;
import sk.C12809f;
import sm.C12817a;

/* loaded from: classes3.dex */
public class CampaignActivity extends HiCloudBaseWebViewActivity {

    /* renamed from: a0 */
    public HandlerC3585b f16600a0;

    /* renamed from: b0 */
    public ActivityDispatchReceiver f16601b0;

    /* renamed from: c0 */
    public C10120h f16602c0;

    /* renamed from: d0 */
    public ValueCallback<Uri[]> f16603d0;

    /* renamed from: e0 */
    public String f16604e0;

    /* renamed from: f0 */
    public String f16605f0;

    /* renamed from: g0 */
    public boolean f16606g0 = true;

    /* renamed from: h0 */
    public boolean f16607h0 = false;

    /* renamed from: i0 */
    public boolean f16608i0 = false;

    /* renamed from: j0 */
    public String f16609j0;

    public static class ActivityDispatchReceiver extends SafeBroadcastReceiver {
        @Override // com.huawei.secure.android.common.intent.SafeBroadcastReceiver
        public void onReceiveMsg(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            String action = new SafeIntent(intent).getAction();
            if ("com.huawei.android.hicloud.ACTION_ACTIVITY_DISPATCH".equals(action)) {
                C11839m.m70688i("CampaignActivity", "ActivityDispatchReceiver:" + action);
            }
        }
    }

    public class CampaignTaskWebChromeClient extends WebChromeClient {
        public CampaignTaskWebChromeClient() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i10) {
            super.onProgressChanged(webView, i10);
            CampaignActivity.this.mo20613M1();
            C11839m.m70688i("CampaignActivity", "onProgressChanged,progress:" + i10);
            if (CampaignActivity.this.f14940s == null) {
                C11839m.m70689w("CampaignActivity", "onProgressChanged mTitleBar is null. Progress:" + i10);
                return;
            }
            if (i10 == 100) {
                CampaignActivity.this.f14940s.setVisibility(8);
            } else {
                CampaignActivity.this.f14940s.setVisibility(0);
                CampaignActivity.this.f14940s.setProgress(i10);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            C11839m.m70688i("CampaignActivity", "onShowFileChooser");
            try {
                CampaignActivity.this.f16603d0 = valueCallback;
                Intent intent = new Intent("android.intent.action.GET_CONTENT");
                intent.setType("image/*");
                intent.addCategory("android.intent.category.OPENABLE");
                CampaignActivity.this.startActivityForResult(intent, 1);
                return true;
            } catch (Exception e10) {
                C11839m.m70687e("CampaignActivity", "onShowFileChooser exception: " + e10.toString());
                return false;
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.CampaignActivity$a */
    public class C3584a extends AbstractC13919c {
        public C3584a() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            C9718g.m60602t().m60631k();
            C1400c.m8059f(C0213f.m1377a());
            CampaignActivity.this.m22966g3();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.CampaignActivity$b */
    public static class HandlerC3585b extends Handler {

        /* renamed from: a */
        public final WeakReference<CampaignActivity> f16611a;

        public HandlerC3585b(CampaignActivity campaignActivity) {
            super(Looper.getMainLooper());
            this.f16611a = new WeakReference<>(campaignActivity);
        }

        /* renamed from: a */
        public final void m22974a(CampaignActivity campaignActivity, Message message) {
            switch (message.what) {
                case 1001:
                    campaignActivity.m22952O2();
                    break;
                case 1002:
                    campaignActivity.m22951N2();
                    break;
                case 1003:
                case 1005:
                    campaignActivity.m22929c3(message.obj);
                    break;
                case 1004:
                    campaignActivity.m22963b3(message.obj);
                    break;
                case 1006:
                    campaignActivity.m22971m3();
                    break;
                case 1007:
                    campaignActivity.m22962a3();
                    break;
                case FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST /* 1008 */:
                    Object obj = message.obj;
                    if (obj instanceof Boolean) {
                        campaignActivity.m22969k3(((Boolean) obj).booleanValue());
                        break;
                    }
                    break;
                case 1009:
                    campaignActivity.m22955R2();
                    break;
                default:
                    m22975b(campaignActivity, message);
                    break;
            }
        }

        /* renamed from: b */
        public final void m22975b(CampaignActivity campaignActivity, Message message) {
            switch (message.what) {
                case 7005:
                case 7006:
                    campaignActivity.m22930e3(message.arg1);
                    break;
                case 7007:
                case 7008:
                    campaignActivity.m22965f3(message.arg1, "");
                    break;
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            CampaignActivity campaignActivity = this.f16611a.get();
            if (campaignActivity == null) {
                C11839m.m70689w("CampaignActivity", "activity null");
            }
            C11839m.m70688i("CampaignActivity", "handleMessage: " + message.what);
            switch (message.what) {
                case 100:
                    Bundle data = message.getData();
                    if (data != null) {
                        C4308a.m25905d(data.getString("javascript"), campaignActivity.f14938q);
                        break;
                    }
                    break;
                case 101:
                    campaignActivity.onBackPressed();
                    break;
                case 102:
                case 104:
                default:
                    m22974a(campaignActivity, message);
                    break;
                case 103:
                    campaignActivity.finish();
                    break;
                case 105:
                    campaignActivity.m22972n3(message);
                    break;
                case 106:
                    if (message.obj instanceof String) {
                        campaignActivity.m22930e3(0);
                        break;
                    }
                    break;
                case 107:
                    Object obj = message.obj;
                    if (obj instanceof String) {
                        campaignActivity.m22965f3(0, (String) obj);
                        break;
                    }
                    break;
                case 108:
                    C12998f.m78034R().m78114n();
                    break;
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.CampaignActivity$c */
    public static class C3586c extends C11524a {

        /* renamed from: i */
        public static final String[] f16612i = {"android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR"};

        /* renamed from: c */
        public final CampaignActivity f16613c;

        /* renamed from: d */
        public final String[] f16614d;

        /* renamed from: e */
        public final Handler f16615e;

        /* renamed from: f */
        public String f16616f;

        /* renamed from: g */
        public final String f16617g;

        /* renamed from: h */
        public final C10797k0 f16618h;

        /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.CampaignActivity$c$a */
        public class a extends TypeToken<List<String>> {
            public a() {
            }
        }

        public C3586c(CampaignActivity campaignActivity, SafeWebView safeWebView, String[] strArr, Handler handler, String str, String str2) {
            super(safeWebView);
            this.f16613c = campaignActivity;
            this.f16614d = strArr;
            this.f16615e = handler;
            this.f16616f = str;
            this.f16617g = str2;
            this.f16618h = new C10797k0(C11058a.m66627b("07030"), true);
        }

        @JavascriptInterface
        public void accepetCloudSpaceGift() {
            if (!C11829c.m70583i(m68794b(), this.f16614d, "accepetCloudSpaceGift")) {
                C11839m.m70687e("CampaignActivity", "accepetCloudSpaceGift, url is invalid");
                return;
            }
            Intent intent = new Intent("com.huawei.hicloud.intent.action.ACTION_TASK_CENTER_ACCEPT_CLOUD_SPACE_SUCCESS");
            C12331w c12331w = new C12331w(true, true, 30);
            C1442a.m8290i("CampaignActivity", "open gallery switch by reveive from task center");
            C12515a.m75110o().m75172d(c12331w);
            C13108a.m78878b(this.f16613c).m78881d(intent);
            C1442a.m8290i("CampaignActivity", "accepetCloudSpaceGift");
        }

        @JavascriptInterface
        public void cancelDownload(String str, String str2) {
            C11839m.m70688i("CampaignActivity", "cancelDownload, uniqueId:" + str2);
            if (C11829c.m70583i(m68794b(), this.f16614d, "cancelDownload")) {
                C12996d.m77971n().m77991d(str, str2);
            } else {
                C11839m.m70687e("CampaignActivity", "cancelDownload, url is invalid");
            }
        }

        @JavascriptInterface
        public void cancelToast() {
            C11839m.m70688i("CampaignActivity", "cancelToast");
            if (C11829c.m70583i(m68794b(), this.f16614d, "cancelToast")) {
                C12996d.m77971n().m77992e();
            } else {
                C11839m.m70687e("CampaignActivity", "cancelToast, url is invalid");
            }
        }

        @JavascriptInterface
        public boolean checkIsInstalled(String str) {
            C11839m.m70686d("CampaignActivity", "checkIsInstalled");
            if (!C11829c.m70583i(m68794b(), this.f16614d, "checkIsInstalled")) {
                C11839m.m70687e("CampaignActivity", "checkIsInstalled, url is invalid");
                return false;
            }
            if (TextUtils.isEmpty(str)) {
                C11839m.m70689w("CampaignActivity", "packageName is empty");
                return false;
            }
            if (!C0209d.m1187L0(C0213f.m1377a(), str)) {
                return false;
            }
            C11839m.m70686d("CampaignActivity", "App installed:" + str);
            return true;
        }

        @JavascriptInterface
        public boolean checkIsSupportSdk() {
            C11839m.m70686d("CampaignActivity", "checkIsSupportSdk");
            if (!C11829c.m70583i(m68794b(), this.f16614d, "checkIsSupportSdk")) {
                C11839m.m70687e("CampaignActivity", "checkIsSupportSdk, url is invalid");
            }
            return C11983e.m72121b().m72124d();
        }

        /* renamed from: e */
        public final String m22976e(List<C4987f> list) {
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

        /* renamed from: f */
        public final void m22977f(QuestBean questBean, String str, String str2, String str3) {
            C11839m.m70688i("CampaignActivity", "startBackupFutureSwitch");
            H5TaskCacheBean h5TaskCacheBeanM78061J = C12998f.m78034R().m78061J();
            if (h5TaskCacheBeanM78061J == null) {
                h5TaskCacheBeanM78061J = new H5TaskCacheBean();
            }
            Intent intent = new Intent(this.f16613c, (Class<?>) BackupMainActivity.class);
            intent.putExtra("channel_of_open_switch", "");
            intent.putExtra(RemoteMessageConst.FROM, "campaign_center");
            intent.putExtra("switch_name", str);
            this.f16613c.startActivityForResult(intent, 102);
            h5TaskCacheBeanM78061J.setActivityId(this.f16616f);
            h5TaskCacheBeanM78061J.setSessionId(str3);
            h5TaskCacheBeanM78061J.setQuestId(str2);
            h5TaskCacheBeanM78061J.setQuestType(questBean.getType());
            h5TaskCacheBeanM78061J.setTag(str);
            h5TaskCacheBeanM78061J.setStartTime(System.currentTimeMillis());
            C12998f.m78034R().m78062J0(C12540b1.m75485c(h5TaskCacheBeanM78061J));
        }

        @JavascriptInterface
        public void finishWebview() throws InterruptedException {
            String strM68794b = m68794b();
            if (!C11829c.m70583i(strM68794b, this.f16614d, "finishWebview")) {
                C11839m.m70687e("CampaignActivity", "finishWebview, url is invalid");
                this.f16618h.m65707p(C11829c.m70560a0(strM68794b), Arrays.toString(this.f16614d));
                return;
            }
            C11839m.m70688i("CampaignActivity", "finishWebView");
            Message message = new Message();
            message.what = 103;
            Handler handler = this.f16615e;
            if (handler != null) {
                handler.sendMessage(message);
            }
        }

        /* renamed from: g */
        public final void m22978g(QuestBean questBean, String str, String str2) {
            C11839m.m70688i("CampaignActivity", "startBusinessPay");
            H5TaskCacheBean h5TaskCacheBean = new H5TaskCacheBean();
            h5TaskCacheBean.setActivityId(this.f16616f);
            h5TaskCacheBean.setSessionId(str2);
            h5TaskCacheBean.setQuestId(str);
            h5TaskCacheBean.setQuestType(questBean.getType());
            h5TaskCacheBean.setStartTime(System.currentTimeMillis());
            C11280c.m67697d();
            C11280c.m67706m(str);
            C11280c.m67703j(C12540b1.m75485c(h5TaskCacheBean));
            Intent intent = new Intent(this.f16613c, (Class<?>) CloudSpaceUpgradeActivity.class);
            intent.putExtra("from_where", 5);
            this.f16613c.startActivityForResult(intent, 101);
        }

        @JavascriptInterface
        public String getActivityEnteryAndConfig() {
            C11839m.m70686d("CampaignActivity", "getActivityEnteryAndConfig");
            if (!C11829c.m70583i(m68794b(), this.f16614d, "getActivityEnteryList")) {
                C11839m.m70687e("CampaignActivity", "getActivityEnteryList, url is invalid");
                return "";
            }
            C12515a.m75110o().m75175e(new C10775b(this.f16613c, this.f16615e, this.f16616f, this.f16617g), false);
            if (!C9718g.m60602t().m60612J(this.f16613c)) {
                C11839m.m70688i("CampaignActivity", "getActivityEnteryList, report agree");
                C4308a.m25903b(true, null);
            }
            return "";
        }

        @JavascriptInterface
        public String getActivityEnteryList() {
            C11839m.m70686d("CampaignActivity", "getActivityEnteryList");
            if (!C11829c.m70583i(m68794b(), this.f16614d, "getActivityEnteryList")) {
                C11839m.m70687e("CampaignActivity", "getActivityEnteryList, url is invalid");
                return "";
            }
            C12515a.m75110o().m75175e(new C4308a.c(this.f16613c, this.f16615e, this.f16616f, this.f16617g), false);
            if (!C9718g.m60602t().m60612J(this.f16613c)) {
                C11839m.m70688i("CampaignActivity", "getActivityEnteryList, report agree");
                C4308a.m25903b(true, null);
            }
            return "";
        }

        @JavascriptInterface
        public String getActivityResources() {
            C11839m.m70686d("CampaignActivity", "getActivityResources");
            if (!C11829c.m70583i(m68794b(), this.f16614d, "getActivityResources")) {
                C11839m.m70687e("CampaignActivity", "getActivityResources, url is invalid");
                return "";
            }
            C12515a.m75110o().m75175e(new C3590g(this.f16615e, this.f16616f), false);
            return "";
        }

        @JavascriptInterface
        public String getAppStatus(String str, String str2) throws InterruptedException {
            C11839m.m70688i("CampaignActivity", "getAppStatus start:" + str2);
            if (!C11829c.m70583i(m68794b(), this.f16614d, "getAppStatus")) {
                C11839m.m70687e("CampaignActivity", "getAppStatus, url is invalid");
                return "";
            }
            String strM77996i = C12996d.m77971n().m77996i(str, str2);
            C11839m.m70688i("CampaignActivity", "getAppStatus end:" + strM77996i);
            return strM77996i;
        }

        @JavascriptInterface
        public int getDownloadProgress(String str, String str2) throws InterruptedException {
            C11839m.m70688i("CampaignActivity", "getDownloadProgress start:" + str2);
            if (!C11829c.m70583i(m68794b(), this.f16614d, "getDownloadProgress")) {
                C11839m.m70687e("CampaignActivity", "getDownloadProgress, url is invalid");
                return -1;
            }
            int iM77997k = C12996d.m77971n().m77997k(str, str2);
            C11839m.m70688i("CampaignActivity", "getDownloadProgress end:" + iM77997k);
            return iM77997k;
        }

        @JavascriptInterface
        public String getGrayFeatureSwitch(String str) {
            return C12540b1.m75485c(C9733f.m60705z().m60764w(str));
        }

        @JavascriptInterface
        public String getInstallingPackageNames() {
            C11839m.m70688i("CampaignActivity", "getInstallingPackageNames");
            if (C11829c.m70583i(m68794b(), this.f16614d, "getInstallingPackageNames")) {
                return new Gson().toJson(PPSDownloadingAdsManager.m16469e().m16473d(HicloudH5ConfigManager.TASK_CENTER).toArray());
            }
            C11839m.m70687e("CampaignActivity", "getInstallingPackageNames, url is invalid");
            return C6010m7.f27500n;
        }

        @JavascriptInterface
        public String getOperationResp(int i10, String str, String str2, String str3) {
            return this.f16618h.m65701j(m68794b(), this.f16614d, i10, str, str2, str3, null);
        }

        @JavascriptInterface
        public String getParams(String str) throws InterruptedException {
            String strM68794b = m68794b();
            if (C11829c.m70583i(strM68794b, this.f16614d, "getParams")) {
                return m22976e(C14157f.m84942g().m84949i((List) C12540b1.m75484b(str, new a().getType()), null, "Campaign"));
            }
            C11839m.m70687e("CampaignActivity", "setOnResumeListner, url is invalid");
            this.f16618h.m65707p(C11829c.m70560a0(strM68794b), Arrays.toString(this.f16614d));
            return "";
        }

        @JavascriptInterface
        public String getPersonalizedAdStatus(int i10) {
            C11839m.m70688i("CampaignActivity", "getPersonalizedAdStatus enter, type = " + i10);
            if (!C11829c.m70583i(m68794b(), this.f16614d, "getPersonalizedAdStatus")) {
                C11839m.m70687e("CampaignActivity", "getPersonalizedAdStatus, url is invalid");
                return "";
            }
            if ((i10 & 1) == 1 && !C13452e.m80781L().m80803F0().booleanValue()) {
                NotifyLogger.m29915i("CampaignActivity", "overseas Account");
                return WebViewManager.m25880t(true, true, true);
            }
            if ((i10 & 2) != 2 || !C13452e.m80781L().m80803F0().booleanValue() || !C13452e.m80781L().m80795D0()) {
                return WebViewManager.m25880t(AdSwitchManager.getInstance().getPersonalizationAdSwitch(), AdSwitchManager.getInstance().getHuaweiAdSwitch(), AdSwitchManager.getInstance().getThreeAdSwitch());
            }
            NotifyLogger.m29916w("CampaignActivity", "children's account");
            return WebViewManager.m25880t(false, false, false);
        }

        @JavascriptInterface
        public String getQuestResources(String[] strArr) {
            C11839m.m70686d("CampaignActivity", "getQuestResources");
            if (!C11829c.m70583i(m68794b(), this.f16614d, "getQuestResources")) {
                C11839m.m70687e("CampaignActivity", "getQuestResources, url is invalid");
                return "";
            }
            C12515a.m75110o().m75175e(new C4308a.d(this.f16615e, this.f16616f, strArr), false);
            return "";
        }

        @JavascriptInterface
        public String getQuestResourcesExtend(String[] strArr, String[] strArr2) {
            C11839m.m70686d("CampaignActivity", "getQuestResourcesExtend");
            if (!C11829c.m70583i(m68794b(), this.f16614d, "getQuestResourcesExtend")) {
                C11839m.m70687e("CampaignActivity", "getQuestResourcesExtend, url is invalid");
                return "";
            }
            C12515a.m75110o().m75175e(new C4308a.d(this.f16615e, this.f16616f, strArr, strArr2), false);
            return "";
        }

        @JavascriptInterface
        public String getQuestResourcesJSSDK(String[] strArr, String[] strArr2) {
            C11839m.m70686d("CampaignActivity", "getQuestResourcesJSSDK");
            if (!C11829c.m70583i(m68794b(), this.f16614d, "getQuestResourcesJSSDK")) {
                C11839m.m70687e("CampaignActivity", "getQuestResourcesJSSDK, url is invalid");
                return "";
            }
            C12515a.m75110o().m75175e(new C4308a.d(this.f16615e, this.f16616f, strArr, strArr2, true), false);
            return "";
        }

        @JavascriptInterface
        public String getRequestHeader(String str) {
            if (C11829c.m70583i(m68794b(), this.f16614d, "getRequestHeader")) {
                return C12997e.m78024q(str);
            }
            C11839m.m70687e("CampaignActivity", "getRequestHeader, url is invalid");
            return "";
        }

        @JavascriptInterface
        public int getStatusBarHeight() {
            if (!C11829c.m70583i(m68794b(), this.f16614d, "getStatusBarHeight")) {
                C11839m.m70687e("CampaignActivity", "getStatusBarHeight, url is invalid");
                return 0;
            }
            int iM70810f1 = C11842p.m70810f1(this.f16613c, C11842p.m70789a0(r3));
            C11839m.m70686d("CampaignActivity", "getStatusBarHeight:" + iM70810f1);
            return iM70810f1;
        }

        @JavascriptInterface
        public String getWebAt(boolean z10) throws C13199p, C13194k {
            C11839m.m70688i("CampaignActivity", "getWebAt forceUpdate=" + z10);
            if (!C11829c.m70583i(m68794b(), this.f16614d, "getWebAt")) {
                C11839m.m70687e("CampaignActivity", "getWebAt,  url is invalid");
                return "";
            }
            C12515a.m75110o().m75175e(new C3591h(this.f16615e, z10), false);
            return "";
        }

        /* renamed from: h */
        public final void m22979h(QuestBean questBean, String str, String str2) {
            C11839m.m70688i("CampaignActivity", "startBusinessSign");
            H5TaskCacheBean h5TaskCacheBean = new H5TaskCacheBean();
            h5TaskCacheBean.setActivityId(this.f16616f);
            h5TaskCacheBean.setSessionId(str2);
            h5TaskCacheBean.setQuestId(str);
            h5TaskCacheBean.setQuestType(questBean.getType());
            h5TaskCacheBean.setStartTime(System.currentTimeMillis());
            C11280c.m67697d();
            C11280c.m67706m(str);
            C11280c.m67704k(C12540b1.m75485c(h5TaskCacheBean));
            Intent intent = new Intent(this.f16613c, (Class<?>) CloudSpaceUpgradeActivity.class);
            intent.putExtra("from_where", 5);
            this.f16613c.startActivityForResult(intent, 101);
        }

        /* renamed from: i */
        public final void m22980i(QuestBean questBean, String str, String str2) {
            C11839m.m70688i("CampaignActivity", "startBusinessUpgrade");
            H5TaskCacheBean h5TaskCacheBean = new H5TaskCacheBean();
            h5TaskCacheBean.setActivityId(this.f16616f);
            h5TaskCacheBean.setSessionId(str2);
            h5TaskCacheBean.setQuestId(str);
            h5TaskCacheBean.setQuestType(questBean.getType());
            h5TaskCacheBean.setStartTime(System.currentTimeMillis());
            C11280c.m67697d();
            C11280c.m67706m(str);
            C11280c.m67705l(C12540b1.m75485c(h5TaskCacheBean));
            Intent intent = new Intent(this.f16613c, (Class<?>) CloudSpaceUpgradeActivity.class);
            intent.putExtra("from_where", 5);
            this.f16613c.startActivityForResult(intent, 101);
        }

        @JavascriptInterface
        public boolean isSupportCampaignConfig() {
            return true;
        }

        /* renamed from: j */
        public final void m22981j(QuestBean questBean, String str, String str2) throws IOException {
            CalendarNotifyAttr calendarNotify;
            C11839m.m70688i("CampaignActivity", "startCalendarNotify");
            C11718b c11718b = new C11718b();
            CampaignActivity campaignActivity = this.f16613c;
            String[] strArr = f16612i;
            List<String> listM69903b = c11718b.m69903b(campaignActivity, Arrays.asList(strArr));
            if (listM69903b != null && listM69903b.size() > 0) {
                C11839m.m70688i("CampaignActivity", "requestPermission");
                c11718b.m69914p(this.f16613c, strArr, 20017);
                return;
            }
            QuestAttributes attributes = questBean.getAttributes();
            if (attributes == null || (calendarNotify = attributes.getCalendarNotify()) == null) {
                return;
            }
            String remDetail = calendarNotify.getRemDetail();
            String strM82966q = C13826g.m82950l().m82966q(remDetail);
            CampaignActivityConfig campaignActivityConfigM82883j = C13821b.m82867w().m82883j(this.f16616f);
            String endTime = campaignActivityConfigM82883j != null ? campaignActivityConfigM82883j.getEndTime() : null;
            CalendarEventBean calendarEventBean = new CalendarEventBean();
            if (TextUtils.isEmpty(strM82966q)) {
                calendarEventBean.setTitle(remDetail);
            } else {
                calendarEventBean.setTitle(strM82966q);
            }
            calendarEventBean.setDescription("");
            calendarEventBean.setStartTime(C13133c.m78997h());
            calendarEventBean.setEndDate(C13133c.m78996g(endTime));
            calendarEventBean.setRepeatPeriod(calendarNotify.getRepeaPeriod());
            H5TaskCacheBean h5TaskCacheBeanM78059I = C12998f.m78034R().m78059I();
            if (h5TaskCacheBeanM78059I == null) {
                h5TaskCacheBeanM78059I = new H5TaskCacheBean();
            }
            h5TaskCacheBeanM78059I.setActivityId(this.f16616f);
            h5TaskCacheBeanM78059I.setSessionId(str2);
            h5TaskCacheBeanM78059I.setQuestId(str);
            h5TaskCacheBeanM78059I.setQuestType(questBean.getType());
            h5TaskCacheBeanM78059I.setStartTime(System.currentTimeMillis());
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("task_type", "calendar_notify");
            linkedHashMap.put("task_id", str);
            if (C13133c.m79000k(this.f16613c, calendarEventBean)) {
                C11839m.m70688i("CampaignActivity", "queryCalendarEvent find notice");
                C12998f.m78034R().m78060I0(C12540b1.m75485c(h5TaskCacheBeanM78059I));
                C12998f.m78034R().m78109k0(this.f16615e, h5TaskCacheBeanM78059I, null);
                C12997e.m78025r("calendar_notify_event", linkedHashMap);
                return;
            }
            if (!C13133c.m78993d(this.f16613c, calendarEventBean)) {
                C11839m.m70687e("CampaignActivity", "addCalendarEvent failed");
                C12996d.m77971n().m77988L(this.f16613c.getString(R$string.msg_create_calendar_fial));
            } else {
                C11839m.m70688i("CampaignActivity", "addCalendarEvent success");
                C12998f.m78034R().m78060I0(C12540b1.m75485c(h5TaskCacheBeanM78059I));
                C12998f.m78034R().m78109k0(this.f16615e, h5TaskCacheBeanM78059I, null);
                C12997e.m78025r("calendar_notify_event", linkedHashMap);
            }
        }

        @JavascriptInterface
        public void jumpToBrowser(String str) {
            C11839m.m70688i("CampaignActivity", "jumpToBrowser");
            if (C11829c.m70583i(m68794b(), this.f16614d, "jumpToBrowser")) {
                C11829c.m70552W0(this.f16613c, str);
            } else {
                C11839m.m70687e("CampaignActivity", "jumpToBrowser, url is invalid");
            }
        }

        @JavascriptInterface
        public int jumpToDownloadPage(String str, String str2, String str3, String str4) {
            C11839m.m70688i("CampaignActivity", "jumpToDownloadPage, uniqueId:" + str2);
            if (!C11829c.m70583i(m68794b(), this.f16614d, "jumpToDownloadPage")) {
                C11839m.m70687e("CampaignActivity", "jumpToDownloadPage, url is invalid");
                return -100;
            }
            H5TaskCacheBean h5TaskCacheBeanM78084V = C12998f.m78034R().m78084V();
            if (h5TaskCacheBeanM78084V == null) {
                h5TaskCacheBeanM78084V = new H5TaskCacheBean();
            }
            h5TaskCacheBeanM78084V.setActivityId(this.f16616f);
            h5TaskCacheBeanM78084V.setSessionId(str4);
            h5TaskCacheBeanM78084V.setQuestId(str3);
            h5TaskCacheBeanM78084V.setQuestType("download_app");
            h5TaskCacheBeanM78084V.setStartTime(System.currentTimeMillis());
            h5TaskCacheBeanM78084V.setApp("");
            C12998f.m78034R().m78044A0(h5TaskCacheBeanM78084V);
            return C12996d.m77971n().m78001r(str, str2);
        }

        @JavascriptInterface
        public int jumpToHalfDownloadPage(String str, String str2, String str3, String str4) {
            C11839m.m70688i("CampaignActivity", "jumpToHalfDownloadPage, uniqueId:" + str2);
            if (!C11829c.m70583i(m68794b(), this.f16614d, "jumpToHalfDownloadPage")) {
                C11839m.m70687e("CampaignActivity", "jumpToHalfDownloadPage, url is invalid");
                return -100;
            }
            H5TaskCacheBean h5TaskCacheBeanM78084V = C12998f.m78034R().m78084V();
            if (h5TaskCacheBeanM78084V == null) {
                h5TaskCacheBeanM78084V = new H5TaskCacheBean();
            }
            h5TaskCacheBeanM78084V.setActivityId(this.f16616f);
            h5TaskCacheBeanM78084V.setSessionId(str4);
            h5TaskCacheBeanM78084V.setQuestId(str3);
            h5TaskCacheBeanM78084V.setQuestType("download_app");
            h5TaskCacheBeanM78084V.setStartTime(System.currentTimeMillis());
            h5TaskCacheBeanM78084V.setApp("");
            C12998f.m78034R().m78044A0(h5TaskCacheBeanM78084V);
            return C12996d.m77971n().m78002s(str, str2);
        }

        @JavascriptInterface
        public void jumpToOperationWebView(String str, String str2) {
            C11839m.m70686d("CampaignActivity", "jumpToOperationWebView");
            if (C11829c.m70583i(m68794b(), this.f16614d, "jumpToOperationWebView")) {
                C11829c.m70548U0(this.f16613c, str2, str);
            } else {
                C11839m.m70687e("CampaignActivity", "jumpToOperationWebView, url is invalid");
            }
        }

        @JavascriptInterface
        public void jumpToStaticWebViewPage(String str, String str2) {
            C11839m.m70686d("CampaignActivity", "jumpToStaticWebViewPage");
            if (C11829c.m70583i(m68794b(), this.f16614d, "jumpToStaticWebViewPage")) {
                C11829c.m70554X0(this.f16613c, str, str2);
            } else {
                C11839m.m70687e("CampaignActivity", "jumpToOperationWebView, url is invalid");
            }
        }

        /* renamed from: k */
        public final void m22982k(QuestBean questBean, String str, String str2, String str3) {
            C11839m.m70688i("CampaignActivity", "startCampaignNotify");
            H5TaskCacheBean h5TaskCacheBean = new H5TaskCacheBean();
            h5TaskCacheBean.setActivityId(this.f16616f);
            h5TaskCacheBean.setSessionId(str3);
            h5TaskCacheBean.setQuestId(str2);
            h5TaskCacheBean.setQuestType(questBean.getType());
            h5TaskCacheBean.setTag(str);
            h5TaskCacheBean.setStartTime(System.currentTimeMillis());
            C12998f.m78034R().m78107j0(this.f16615e, h5TaskCacheBean);
        }

        /* renamed from: l */
        public final void m22983l(QuestBean questBean, String str, String str2) {
        }

        @JavascriptInterface
        public String loadAgd() {
            C11839m.m70686d("CampaignActivity", "loadAgd");
            if (!C11829c.m70583i(m68794b(), this.f16614d, "loadAgd")) {
                C11839m.m70687e("CampaignActivity", "loadAgd, url is invalid");
                return "";
            }
            String strM75485c = C12540b1.m75485c(C12993a.m77960d());
            C11839m.m70686d("CampaignActivity", "loadAgd: " + strM75485c);
            return strM75485c;
        }

        /* renamed from: m */
        public final void m22984m(QuestBean questBean, String str, String str2, int i10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            UploadFileAttr uploadFile;
            C11839m.m70688i("CampaignActivity", "startFileManagerTask");
            QuestAttributes attributes = questBean.getAttributes();
            int service = (attributes == null || questBean.getAttributes().getUploadFile() == null || (uploadFile = attributes.getUploadFile()) == null) ? 0 : uploadFile.getService();
            if (10781986 == service || i10 != 1) {
                C13135e.m79006f(this.f16613c, 9, i10);
                H5TaskCacheBean h5TaskCacheBean = new H5TaskCacheBean();
                h5TaskCacheBean.setActivityId(this.f16616f);
                h5TaskCacheBean.setSessionId(str2);
                h5TaskCacheBean.setQuestId(str);
                h5TaskCacheBean.setQuestType(questBean.getType());
                h5TaskCacheBean.setStartTime(System.currentTimeMillis());
                h5TaskCacheBean.setService(Integer.valueOf(service));
                if (i10 == 1) {
                    C12998f.m78034R().m78091Y0(C12540b1.m75485c(h5TaskCacheBean));
                    C12998f.m78034R().m78081T0(true);
                    C11839m.m70688i("CampaignActivity", "cache upload file");
                } else if (i10 == 2) {
                    C12998f.m78034R().m78068M0(C12540b1.m75485c(h5TaskCacheBean));
                    C12998f.m78034R().m78079S0(true);
                    C11839m.m70688i("CampaignActivity", "cache new folder");
                } else if (i10 == 4) {
                    C12998f.m78034R().m78066L0(C12540b1.m75485c(h5TaskCacheBean));
                    C11839m.m70688i("CampaignActivity", "cache new file");
                    C12998f.m78034R().m78077R0(true);
                }
            }
        }

        /* renamed from: n */
        public final void m22985n(QuestBean questBean, String str, String str2, String str3) {
            C11839m.m70688i("CampaignActivity", "startFindDevice");
            if (this.f16613c == null) {
                C11839m.m70687e("CampaignActivity", "activity null");
                return;
            }
            InterfaceC9287f interfaceC9287f = (InterfaceC9287f) C1270a.m7534b().m7535a(InterfaceC9287f.class);
            if (interfaceC9287f == null) {
                C11839m.m70687e("CampaignActivity", "phoneFinderRouter null");
                return;
            }
            H5TaskCacheBean h5TaskCacheBeanM78071O = C12998f.m78034R().m78071O();
            if (h5TaskCacheBeanM78071O == null) {
                h5TaskCacheBeanM78071O = new H5TaskCacheBean();
            }
            interfaceC9287f.mo58540C(this.f16613c, "campaign_center", str, 105);
            h5TaskCacheBeanM78071O.setActivityId(this.f16616f);
            h5TaskCacheBeanM78071O.setSessionId(str3);
            h5TaskCacheBeanM78071O.setQuestId(str2);
            h5TaskCacheBeanM78071O.setQuestType(questBean.getType());
            h5TaskCacheBeanM78071O.setTag(str);
            h5TaskCacheBeanM78071O.setStartTime(System.currentTimeMillis());
            C12998f.m78034R().m78070N0(C12540b1.m75485c(h5TaskCacheBeanM78071O));
        }

        /* renamed from: o */
        public final void m22986o(QuestBean questBean, String str, String str2) {
            C11839m.m70688i("CampaignActivity", "startFutureSwitch");
            QuestAttributes attributes = questBean.getAttributes();
            if (attributes == null) {
                C11839m.m70689w("CampaignActivity", "startFutureSwitch attributes null!");
            }
            FutureSwitchAttr futureSwitch = attributes.getFutureSwitch();
            if (futureSwitch == null) {
                C11839m.m70689w("CampaignActivity", "startFutureSwitch futureSwitch null!");
                return;
            }
            String futureTag = futureSwitch.getFutureTag();
            if (TextUtils.isEmpty(futureSwitch.getFutureTag())) {
                C11839m.m70689w("CampaignActivity", "startFutureSwitch, futureTag null");
                return;
            }
            futureTag.hashCode();
            switch (futureTag) {
                case "backup":
                    m22977f(questBean, futureTag, str, str2);
                    break;
                case "notify":
                    m22982k(questBean, futureTag, str, str2);
                    break;
                case "findDevice":
                    m22985n(questBean, futureTag, str, str2);
                    break;
                case "wlan":
                case "browser":
                case "contact":
                case "notepad":
                    m22987p(questBean, futureTag, str, str2);
                    break;
                case "photo":
                    m22988q(questBean, futureTag, str, str2);
                    break;
                default:
                    C11839m.m70689w("CampaignActivity", "switchFeatureTag, futureTag not match!");
                    break;
            }
        }

        @JavascriptInterface
        public void onBackItemClick() {
            C11839m.m70686d("CampaignActivity", "onBackItemClick");
            if (!C11829c.m70583i(m68794b(), this.f16614d, "onBackItemClick")) {
                C11839m.m70687e("CampaignActivity", "onBackItemClick, url is invalid");
            } else if (this.f16613c == null) {
                C11839m.m70686d("CampaignActivity", "onBackItemClick activity null");
            } else {
                C12997e.m78013f();
            }
        }

        @JavascriptInterface
        public void onQuestCallBack(String str) {
            C11839m.m70686d("CampaignActivity", "onQuestCallBack");
            if (C11829c.m70583i(m68794b(), this.f16614d, "onQuestCallBack")) {
                C12997e.m78032y(str);
            } else {
                C11839m.m70687e("CampaignActivity", "onQuestCallBack, url is invalid");
            }
        }

        @JavascriptInterface
        public void openAgdApp(String str, String str2, String str3, String str4) {
            C11839m.m70688i("CampaignActivity", "openAgdApp");
            if (!C11829c.m70583i(m68794b(), this.f16614d, "openAgdApp")) {
                C11839m.m70687e("CampaignActivity", "openAgdApp, url is invalid");
                return;
            }
            String strM78003v = C12996d.m77971n().m78003v(str, str2);
            C11839m.m70688i("CampaignActivity", "openAgdApp:" + strM78003v);
            if (TextUtils.isEmpty(strM78003v)) {
                return;
            }
            H5TaskCacheBean h5TaskCacheBeanM78084V = C12998f.m78034R().m78084V();
            if (h5TaskCacheBeanM78084V == null) {
                h5TaskCacheBeanM78084V = new H5TaskCacheBean();
            }
            h5TaskCacheBeanM78084V.setActivityId(this.f16616f);
            h5TaskCacheBeanM78084V.setSessionId(str4);
            h5TaskCacheBeanM78084V.setQuestId(str3);
            h5TaskCacheBeanM78084V.setQuestType("download_app");
            h5TaskCacheBeanM78084V.setStartTime(System.currentTimeMillis());
            h5TaskCacheBeanM78084V.setApp(strM78003v);
            C12998f.m78034R().m78044A0(h5TaskCacheBeanM78084V);
            C12998f.m78034R().m78132w(this.f16615e, strM78003v);
        }

        @JavascriptInterface
        public void openPPSApp(String str, String str2, String str3, String str4) {
            C11839m.m70688i("CampaignActivity", "openPPSApp");
            if (!C11829c.m70583i(m68794b(), this.f16614d, "openPPSApp")) {
                C11839m.m70687e("CampaignActivity", "openPPSApp, url is invalid");
                return;
            }
            INativeAd iNativeAdM77999m = C12996d.m77971n().m77999m(str, str2);
            String packageName = iNativeAdM77999m != null ? iNativeAdM77999m.getAppInfo().getPackageName() : null;
            if (!TextUtils.isEmpty(packageName)) {
                H5TaskCacheBean h5TaskCacheBeanM78084V = C12998f.m78034R().m78084V();
                if (h5TaskCacheBeanM78084V == null) {
                    h5TaskCacheBeanM78084V = new H5TaskCacheBean();
                }
                h5TaskCacheBeanM78084V.setActivityId(this.f16616f);
                h5TaskCacheBeanM78084V.setSessionId(str4);
                h5TaskCacheBeanM78084V.setQuestId(str3);
                h5TaskCacheBeanM78084V.setQuestType("download_app");
                h5TaskCacheBeanM78084V.setStartTime(System.currentTimeMillis());
                h5TaskCacheBeanM78084V.setApp(packageName);
                C12998f.m78034R().m78044A0(h5TaskCacheBeanM78084V);
            }
            C12996d.m77971n().m77989M(str, str2);
        }

        /* renamed from: p */
        public final void m22987p(QuestBean questBean, String str, String str2, String str3) {
            C11839m.m70688i("CampaignActivity", "startMainFutureSwitch");
            H5TaskCacheBean h5TaskCacheBeanM78063K = C12998f.m78034R().m78063K(str);
            if (h5TaskCacheBeanM78063K == null) {
                h5TaskCacheBeanM78063K = new H5TaskCacheBean();
            }
            Intent intent = new Intent(this.f16613c, (Class<?>) MainActivity.class);
            intent.putExtra(RemoteMessageConst.FROM, "campaign_center");
            intent.putExtra("switch_name", str);
            intent.putExtra("campaign_channel", "81");
            C4308a.m25918q(6, Constant.MAP_KEY_TOP);
            this.f16613c.startActivity(intent);
            h5TaskCacheBeanM78063K.setActivityId(this.f16616f);
            h5TaskCacheBeanM78063K.setSessionId(str3);
            h5TaskCacheBeanM78063K.setQuestId(str2);
            h5TaskCacheBeanM78063K.setQuestType(questBean.getType());
            h5TaskCacheBeanM78063K.setTag(str);
            h5TaskCacheBeanM78063K.setStartTime(System.currentTimeMillis());
            C12998f.m78034R().m78064K0(C12540b1.m75485c(h5TaskCacheBeanM78063K), str);
        }

        @JavascriptInterface
        public void pauseDownload(String str, String str2) {
            C11839m.m70688i("CampaignActivity", "pauseDownload, uniqueId:" + str2);
            if (C11829c.m70583i(m68794b(), this.f16614d, "pauseDownload")) {
                C12996d.m77971n().m78004w(str, str2);
            } else {
                C11839m.m70687e("CampaignActivity", "pauseDownload, url is invalid");
            }
        }

        /* renamed from: q */
        public final void m22988q(QuestBean questBean, String str, String str2, String str3) {
            C11839m.m70688i("CampaignActivity", "startPhotoFutureSwitch");
            InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
            if (interfaceC9282a == null) {
                C11839m.m70689w("CampaignActivity", "startPhotoFutureSwitch cloudAlbumRouter is null!");
                return;
            }
            H5TaskCacheBean h5TaskCacheBeanM78073P = C12998f.m78034R().m78073P();
            if (h5TaskCacheBeanM78073P == null) {
                h5TaskCacheBeanM78073P = new H5TaskCacheBean();
            }
            Bundle bundle = new Bundle();
            bundle.putString(RemoteMessageConst.FROM, "campaign_center");
            bundle.putString("switch_name", str);
            interfaceC9282a.mo58367F0(this.f16613c, bundle, 103);
            h5TaskCacheBeanM78073P.setActivityId(this.f16616f);
            h5TaskCacheBeanM78073P.setSessionId(str3);
            h5TaskCacheBeanM78073P.setQuestId(str2);
            h5TaskCacheBeanM78073P.setQuestType(questBean.getType());
            h5TaskCacheBeanM78073P.setTag(str);
            h5TaskCacheBeanM78073P.setStartTime(System.currentTimeMillis());
            C12998f.m78034R().m78072O0(C12540b1.m75485c(h5TaskCacheBeanM78073P));
        }

        /* renamed from: r */
        public final void m22989r(String str, String str2) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
            if (this.f16613c == null) {
                C11839m.m70687e("CampaignActivity", "startQuestEvent activity null!");
            }
            QuestBean questBeanM60632l = C9718g.m60602t().m60632l(str);
            if (questBeanM60632l == null) {
                C11839m.m70687e("CampaignActivity", "startQuestEvent questBean null!");
                return;
            }
            String type = questBeanM60632l.getType();
            type.hashCode();
            switch (type) {
                case "feature_switch":
                    m22986o(questBeanM60632l, str, str2);
                    break;
                case "business_upgrade":
                    m22980i(questBeanM60632l, str, str2);
                    break;
                case "business_pay":
                    m22978g(questBeanM60632l, str, str2);
                    break;
                case "create_drive_folder":
                    m22984m(questBeanM60632l, str, str2, 2);
                    break;
                case "use_space_optimization":
                    m22990s(questBeanM60632l, str, str2);
                    break;
                case "app_activation":
                case "motivating_video":
                case "download_app":
                    m22983l(questBeanM60632l, str, str2);
                    break;
                case "business_sign":
                    m22979h(questBeanM60632l, str, str2);
                    break;
                case "create_drive_file":
                    m22984m(questBeanM60632l, str, str2, 4);
                    break;
                case "calendar_notify":
                    m22981j(questBeanM60632l, str, str2);
                    break;
                case "upload_file":
                    m22984m(questBeanM60632l, str, str2, 1);
                    break;
                case "ka_activation":
                    C4308a.m25921t(this.f16613c, this.f16615e, questBeanM60632l, str, str2, this.f16616f, false);
                    break;
            }
        }

        @JavascriptInterface
        public boolean recordClickEvent(String str, String str2, String str3) {
            return this.f16618h.m65710s(m68794b(), this.f16614d, str, str2, str3);
        }

        @JavascriptInterface
        public boolean recordImpressionEvent(String str, String str2, String str3) {
            return this.f16618h.m65711t(m68794b(), this.f16614d, str, str2, str3);
        }

        @JavascriptInterface
        public boolean recordShowStartEvent(String str, String str2, String str3) {
            return this.f16618h.m65712u(m68794b(), this.f16614d, str, str2, str3);
        }

        @JavascriptInterface
        public void refreshCampaignActivity(String str) {
            C11839m.m70688i("CampaignActivity", "refreshCampaignActivity");
            if (!C11829c.m70583i(m68794b(), this.f16614d, "refreshCampaignActivity")) {
                C11839m.m70687e("CampaignActivity", "getActivityEnteryList, url is invalid");
                return;
            }
            C12998f.m78034R().m78138z();
            C12998f.m78034R().m78085V0("", "", 0, 0);
            C0212e0.m1353c("com.huawei.hidisk.campaign.config_quests");
            this.f16616f = str;
            CampaignActivity campaignActivity = this.f16613c;
            if (campaignActivity != null) {
                campaignActivity.f16604e0 = str;
            }
        }

        @JavascriptInterface
        public void reportBI(String str, String str2, String str3) {
            try {
                if (!C11829c.m70583i(m68794b(), this.f16614d, "reportBI")) {
                    C11839m.m70687e("CampaignActivity", "reportBI, url is invalid");
                    return;
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                if (TextUtils.isEmpty(str2)) {
                    C11839m.m70687e("CampaignActivity", "eventKey null");
                    return;
                }
                if (!TextUtils.equals("CKC", str) && !TextUtils.equals("PVC", str)) {
                    C11839m.m70687e("CampaignActivity", "eventType wrong");
                    return;
                }
                if (!TextUtils.isEmpty(str3)) {
                    JSONObject jSONObject = new JSONObject(str3);
                    Iterator<String> itKeys = jSONObject.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        linkedHashMap.put(next, jSONObject.getString(next));
                    }
                }
                C13227f.m79492i1().m79591l0(str2, linkedHashMap);
                UBAAnalyze.m29958S(str, str2, "3", "47", linkedHashMap);
            } catch (JSONException e10) {
                C11839m.m70687e("CampaignActivity", "reportBI exception " + e10.getMessage());
            }
        }

        @JavascriptInterface
        public void reportCampaignDownload(String str, String str2) {
            C11839m.m70686d("CampaignActivity", "reportCampaignDownload");
            if (C11829c.m70583i(m68794b(), this.f16614d, "reportCampaignDownload")) {
                return;
            }
            C11839m.m70687e("CampaignActivity", "reportCampaignDownload, url is invalid");
        }

        @JavascriptInterface
        public void reportCampaignLaunched(String str, String str2) {
            C11839m.m70686d("CampaignActivity", "reportCampaignLaunched");
            if (C11829c.m70583i(m68794b(), this.f16614d, "reportCampaignLaunched")) {
                return;
            }
            C11839m.m70687e("CampaignActivity", "reportCampaignLaunched, url is invalid");
        }

        @JavascriptInterface
        public void reportClickEvent(String str, String str2, String str3) {
            this.f16618h.m65713x(m68794b(), this.f16614d, str, str2, str3);
        }

        @JavascriptInterface
        public String reportDownloadAppQuestResult(String str, String str2, String str3, String str4) {
            C11839m.m70686d("CampaignActivity", "postActivityDispatch");
            if (C11829c.m70583i(m68794b(), this.f16614d, "reportDownloadAppQuestResult")) {
                C12998f.m78034R().m78135x0(this.f16615e, str, str2, str3, str4);
                return "";
            }
            C11839m.m70687e("CampaignActivity", "postActivityDispatch, url is invalid");
            return "";
        }

        @JavascriptInterface
        public int resumeDownload(String str, String str2) {
            C11839m.m70688i("CampaignActivity", "resumeDownload, uniqueId:" + str2);
            if (C11829c.m70583i(m68794b(), this.f16614d, "resumeDownload")) {
                return C12996d.m77971n().m77979C(str, str2);
            }
            C11839m.m70687e("CampaignActivity", "resumeDownload, url is invalid");
            return -1;
        }

        /* renamed from: s */
        public final void m22990s(QuestBean questBean, String str, String str2) {
            C11839m.m70688i("CampaignActivity", "startSpaceOptimization");
            if (this.f16613c == null) {
                C11839m.m70687e("CampaignActivity", "activity null");
                return;
            }
            H5TaskCacheBean h5TaskCacheBeanM78098c0 = C12998f.m78034R().m78098c0();
            if (h5TaskCacheBeanM78098c0 == null) {
                h5TaskCacheBeanM78098c0 = new H5TaskCacheBean();
            }
            Intent intent = new Intent(this.f16613c, (Class<?>) HisyncSpaceDetailActivity.class);
            intent.putExtra(RemoteMessageConst.FROM, "campaign_center");
            this.f16613c.startActivity(intent);
            h5TaskCacheBeanM78098c0.setActivityId(this.f16616f);
            h5TaskCacheBeanM78098c0.setSessionId(str2);
            h5TaskCacheBeanM78098c0.setQuestId(str);
            h5TaskCacheBeanM78098c0.setQuestType(questBean.getType());
            h5TaskCacheBeanM78098c0.setStartTime(System.currentTimeMillis());
            C12998f.m78034R().m78087W0(C12540b1.m75485c(h5TaskCacheBeanM78098c0));
        }

        @JavascriptInterface
        public void setAdsStatus(String str) {
            NotifyLogger.m29915i("CampaignActivity", "setAdsStatus enter");
            if (C11829c.m70583i(m68794b(), this.f16614d, "setAdsStatus")) {
                new C10219d(str).m63381g();
            } else {
                C11839m.m70687e("CampaignActivity", "setAdsStatus, url is invalid");
            }
        }

        @JavascriptInterface
        public void setAppInstallStatus(String str, boolean z10) {
            C11839m.m70688i("CampaignActivity", "setAppInstallStatus");
            if (!C11829c.m70583i(m68794b(), this.f16614d, "setAppInstallStatus")) {
                C11839m.m70687e("CampaignActivity", "setAppInstallStatus, url is invalid");
            } else if (z10) {
                PPSDownloadingAdsManager.m16469e().m16471b(HicloudH5ConfigManager.TASK_CENTER, str);
            } else {
                PPSDownloadingAdsManager.m16469e().m16475h(HicloudH5ConfigManager.TASK_CENTER, str);
            }
        }

        @JavascriptInterface
        public void setDownLoadReportListener(String str) {
            C11839m.m70686d("CampaignActivity", "setDownLoadReportListener");
            if (C11829c.m70583i(m68794b(), this.f16614d, "setDownLoadReportListener")) {
                C12997e.m78027t(str);
            } else {
                C11839m.m70687e("CampaignActivity", "setDownLoadReportListener, url is invalid");
            }
        }

        @JavascriptInterface
        public void setLaunchedReportListener(String str) {
            C11839m.m70686d("CampaignActivity", "setLaunchedReportListener");
            if (C11829c.m70583i(m68794b(), this.f16614d, "setLaunchedReportListener")) {
                C12997e.m78029v(str);
            } else {
                C11839m.m70687e("CampaignActivity", "setLaunchedReportListener, url is invalid");
            }
        }

        @JavascriptInterface
        public void setOnAppOpenListener(String str) {
            C11839m.m70686d("CampaignActivity", "setOnAppOpenListener");
            if (!C11829c.m70583i(m68794b(), this.f16614d, "setOnAppOpenListener")) {
                C11839m.m70687e("CampaignActivity", "setOnAppOpenListener, url is invalid");
            } else {
                C12997e.m78030w(str);
                C12996d.m77971n().m77985I(str);
            }
        }

        @JavascriptInterface
        public void setOnDownloadProgressListener(String str) {
            C11839m.m70686d("CampaignActivity", "setOnDownloadProgressListener");
            if (!C11829c.m70583i(m68794b(), this.f16614d, "setOnDownloadProgressListener")) {
                C11839m.m70687e("CampaignActivity", "setOnDownloadProgressListener, url is invalid");
            } else {
                C12997e.m78031x(str);
                C12996d.m77971n().m77986J(str);
            }
        }

        @JavascriptInterface
        public void setOnResumeListner(String str) {
            C11839m.m70686d("CampaignActivity", "setOnResumeListner");
            if (C11829c.m70583i(m68794b(), this.f16614d, "setOnResumeListner")) {
                C12997e.m78033z(str);
            } else {
                C11839m.m70687e("CampaignActivity", "setOnResumeListner, url is invalid");
            }
        }

        @JavascriptInterface
        public void setOnStatusChangedListener(String str) {
            C11839m.m70686d("CampaignActivity", "setOnStatusChangedListener");
            if (!C11829c.m70583i(m68794b(), this.f16614d, "setOnStatusChangedListener")) {
                C11839m.m70687e("CampaignActivity", "setOnStatusChangedListener, url is invalid");
            } else {
                C12997e.m78007A(str);
                C12996d.m77971n().m77987K(str);
            }
        }

        @JavascriptInterface
        public void setStatusBarColor(boolean z10) {
            if (!C11829c.m70583i(m68794b(), this.f16614d, "setStatusBarColor")) {
                C11839m.m70687e("CampaignActivity", "setStatusBarColor, url is invalid");
                return;
            }
            Handler handler = this.f16615e;
            if (handler != null) {
                if (z10) {
                    handler.obtainMessage(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, Boolean.TRUE).sendToTarget();
                } else {
                    handler.obtainMessage(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, Boolean.FALSE).sendToTarget();
                }
            }
        }

        @JavascriptInterface
        public void showToast(String str) {
            C11839m.m70688i("CampaignActivity", "showToast");
            if (C11829c.m70583i(m68794b(), this.f16614d, "showToast")) {
                C12996d.m77971n().m77988L(str);
            } else {
                C11839m.m70687e("CampaignActivity", "showToast, url is invalid");
            }
        }

        @JavascriptInterface
        public void startCouponCenter() {
            C11839m.m70688i("CampaignActivity", "startCouponCenter");
            if (C0209d.m1226Y0()) {
                C11839m.m70689w("CampaignActivity", "startCouponCenter fast click");
                return;
            }
            if (this.f16613c == null) {
                C11839m.m70688i("CampaignActivity", "startCouponCenter activity null");
            } else {
                if (!C11829c.m70583i(m68794b(), this.f16614d, "startCouponCenter")) {
                    C11839m.m70687e("CampaignActivity", "startCouponCenter, url is invalid");
                    return;
                }
                Intent intent = new Intent(this.f16613c, (Class<?>) CouponCenterActivity.class);
                intent.putExtra("page_from", "reward_detail");
                this.f16613c.startActivity(intent);
            }
        }

        @JavascriptInterface
        public int startDownload(String str, String str2, String str3) {
            C11839m.m70688i("CampaignActivity", "startDownload with questId, uniqueId:" + str2);
            if (!C11829c.m70583i(m68794b(), this.f16614d, "startDownload")) {
                C11839m.m70687e("CampaignActivity", "startDownload, url is invalid");
                return -1;
            }
            int iM77989M = C12996d.m77971n().m77989M(str, str2);
            C12996d.m77971n().m77981E(str, str2, str3);
            return iM77989M;
        }

        @JavascriptInterface
        public void startQuest(String str, String str2) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
            C11839m.m70686d("CampaignActivity", "startQuest questId: " + str + ",sessionId: " + str2);
            if (C0209d.m1226Y0()) {
                C11839m.m70689w("CampaignActivity", "startQuest fast click");
                return;
            }
            if (!C0209d.m1333z1(C0213f.m1377a())) {
                C11839m.m70689w("CampaignActivity", "startQuest network error");
            } else if (C11829c.m70583i(m68794b(), this.f16614d, "startQuest")) {
                m22989r(str, str2);
            } else {
                C11839m.m70687e("CampaignActivity", "startQuest, url is invalid");
            }
        }

        @JavascriptInterface
        public void triggerCallback() {
            if (!C11829c.m70583i(m68794b(), this.f16614d, "triggerCallback")) {
                C11839m.m70687e("CampaignActivity", "triggerCallback, url is invalid");
                return;
            }
            C11839m.m70686d("CampaignActivity", "triggerCallback");
            CampaignActivity campaignActivity = this.f16613c;
            if (campaignActivity != null) {
                campaignActivity.m22956S2();
            }
        }

        @JavascriptInterface
        public void triggerClick(String str, String str2, String str3) {
            this.f16618h.m65714y(m68794b(), this.f16614d, str, str2, str3);
        }

        @JavascriptInterface
        public boolean triggerReport() {
            C11839m.m70686d("CampaignActivity", "triggerReport");
            if (!C11829c.m70583i(m68794b(), this.f16614d, "triggerReport")) {
                C11839m.m70687e("CampaignActivity", "triggerReport, url is invalid");
                return false;
            }
            CampaignActivity campaignActivity = this.f16613c;
            if (campaignActivity == null) {
                return true;
            }
            campaignActivity.m22955R2();
            return true;
        }

        @JavascriptInterface
        public void updateMainActivity() {
            C11839m.m70686d("CampaignActivity", "updateMainActivity");
            if (C0209d.m1226Y0()) {
                C11839m.m70689w("CampaignActivity", "updateMainActivity fast click");
            } else if (C11829c.m70583i(m68794b(), this.f16614d, "updateMainActivity")) {
                C13823d.m82901N();
            } else {
                C11839m.m70687e("CampaignActivity", "updateMainActivity, url is invalid");
            }
        }

        @JavascriptInterface
        public String getOperationResp(int i10, String str, String str2, String str3, String str4) {
            return this.f16618h.m65701j(m68794b(), this.f16614d, i10, str, str2, str3, str4);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.CampaignActivity$e */
    public static class C3588e extends AbstractC13919c {

        /* renamed from: a */
        public final Handler f16622a;

        /* renamed from: b */
        public final boolean f16623b;

        public C3588e(Handler handler, boolean z10) {
            this.f16622a = handler;
            this.f16623b = z10;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            C11839m.m70688i("CampaignActivity", "check cache report");
            C12998f.m78034R().m78116o(this.f16622a, false, null);
            C12998f.m78034R().m78124s(this.f16622a, false, null);
            C12998f.m78034R().m78130v(this.f16622a, this.f16623b, C12998f.m78034R().f59186j, null);
            C12998f.m78034R().m78122r(this.f16622a, false, null);
            C12998f.m78034R().m78136y(this.f16622a, false, null);
            C12998f.m78034R().m78120q(this.f16622a, null);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.CampaignActivity$f */
    public static class C3589f extends AbstractC13919c {

        /* renamed from: a */
        public final Handler f16624a;

        public C3589f(Handler handler) {
            this.f16624a = handler;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws InterruptedException, C9721b {
            C11839m.m70688i("CampaignActivity", "check cache report");
            CountDownLatch countDownLatch = new CountDownLatch(4);
            C12998f.m78034R().m78116o(this.f16624a, false, countDownLatch);
            C12998f.m78034R().m78124s(this.f16624a, false, countDownLatch);
            C12998f.m78034R().m78130v(this.f16624a, false, C12998f.m78034R().f59186j, countDownLatch);
            C12998f.m78034R().m78122r(this.f16624a, false, countDownLatch);
            try {
                C11839m.m70686d("CampaignActivity", "countDownLatch await=" + countDownLatch.await(10L, TimeUnit.SECONDS));
            } catch (InterruptedException unused) {
                C11839m.m70689w("CampaignActivity", "countDownLatch exception");
            }
            C11839m.m70688i("CampaignActivity", "triggerReportListener");
            C12998f.m78034R().m78095a1(this.f16624a, "");
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.CampaignActivity$g */
    public static class C3590g extends AbstractC13919c {

        /* renamed from: a */
        public final Handler f16625a;

        /* renamed from: b */
        public final String f16626b;

        public C3590g(Handler handler, String str) {
            this.f16625a = handler;
            this.f16626b = str;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b, IOException {
            C12998f.m78034R().m78108k(this.f16625a, C12998f.m78034R().m78055G(this.f16626b, C13821b.m82867w().m82894u()));
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.CampaignActivity$h */
    public static class C3591h extends AbstractC13919c {

        /* renamed from: a */
        public final Handler f16627a;

        /* renamed from: b */
        public final boolean f16628b;

        public C3591h(Handler handler, boolean z10) {
            this.f16627a = handler;
            this.f16628b = z10;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            C12998f.m78034R().m78097b1(this.f16627a, C12998f.m78034R().m78101f0(this.f16628b));
        }
    }

    /* renamed from: T2 */
    public static void m22927T2(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            C11839m.m70687e("CampaignActivity", "goToBrowserDownload context or url is Empty");
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.BROWSABLE");
            intent.setData(Uri.parse(str));
            context.startActivity(intent);
        } catch (Exception e10) {
            C11839m.m70687e("CampaignActivity", "onDownloadStart Exception =" + e10.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: U2 */
    public void m22928U2() {
        C11839m.m70688i("CampaignActivity", "hideLoadingView");
        try {
            mo20597g2();
        } catch (Exception e10) {
            C11839m.m70688i("CampaignActivity", "hideLoadingView: " + e10.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c3 */
    public void m22929c3(Object obj) {
        C11839m.m70688i("CampaignActivity", "post activity dispatch success");
        if (obj instanceof Bundle) {
            Bundle bundle = (Bundle) obj;
            String string = bundle.getString("questId");
            String string2 = bundle.getString(CommonConstant.ReqAccessTokenParam.STATE_LABEL);
            int i10 = bundle.getInt("count");
            int i11 = bundle.getInt("taskAwards");
            if (C0209d.m1245d1(this, CampaignActivity.class.getName())) {
                C4308a.m25915n(string, string2, i10, i11, this.f14938q);
                C12998f.m78034R().m78085V0("", "", 0, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e3 */
    public void m22930e3(int i10) {
        C11839m.m70688i("CampaignActivity", "processReportCampaignDownload: " + i10);
        String strM78018k = C12997e.m78018k();
        if (TextUtils.isEmpty(strM78018k)) {
            return;
        }
        C4308a.m25905d(String.format(Locale.ENGLISH, "%s(%d)", strM78018k, Integer.valueOf(i10)), this.f14938q);
    }

    /* renamed from: i3 */
    private void m22932i3(String str) throws JSONException {
        JSONObject jSONObjectM79482j = C13223b.m79482j(C0213f.m1377a(), "enter_webview_base_info", "1", C13452e.m80781L().m80971t0(), "2");
        try {
            jSONObjectM79482j.put("enter_activity_entranChannel", this.f14915E);
            jSONObjectM79482j.put("enter_activity_salChannel", this.f14919I);
            jSONObjectM79482j.put("enter_activity_srcChannel", this.f14918H);
            jSONObjectM79482j.put("enter_activity_entran_activityCode", this.f14920J);
            jSONObjectM79482j.put("launch_webview_type", this.f14923M);
            if (!TextUtils.isEmpty(str)) {
                jSONObjectM79482j.put("webview_launched_url", str);
            }
            jSONObjectM79482j.put("enter_activity_entranChannel", this.f14915E);
        } catch (JSONException e10) {
            C11839m.m70687e("CampaignActivity", "reportEvent exception:" + e10.getMessage());
        }
        LinkedHashMap<String, String> linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
        linkedHashMapM79499C.put("enter_activity_entranChannel", this.f14915E);
        linkedHashMapM79499C.put("enter_activity_salChannel", this.f14919I);
        linkedHashMapM79499C.put("enter_activity_srcChannel", this.f14918H);
        linkedHashMapM79499C.put("enter_activity_entran_activityCode", this.f14920J);
        linkedHashMapM79499C.put("launch_webview_type", String.valueOf(this.f14923M));
        if (!TextUtils.isEmpty(str)) {
            linkedHashMapM79499C.put("webview_launched_url", str);
        }
        linkedHashMapM79499C.put("enter_activity_entranChannel", this.f14915E);
        C13227f.m79492i1().m79602z(jSONObjectM79482j);
        C13227f.m79492i1().m79567R("enter_webview_base_info", linkedHashMapM79499C);
        UBAAnalyze.m29963X("PVC", "enter_webview_base_info", "3", "47", jSONObjectM79482j);
    }

    /* renamed from: B1 */
    public void m22950B1() {
        ActionBar actionBar = getActionBar();
        if (actionBar == null) {
            C11839m.m70689w("CampaignActivity", "getActionBar is empty");
            return;
        }
        actionBar.setDisplayHomeAsUpEnabled(true);
        C10150a.m63212b(actionBar, new ColorDrawable(getColor(R$color.emui_color_bg)));
        C11839m.m70686d("CampaignActivity", "setActionBarExBackground white");
    }

    /* renamed from: N2 */
    public final void m22951N2() {
        C11839m.m70688i("CampaignActivity", "checkActivityEntryListFail");
        m20623c2();
    }

    /* renamed from: O2 */
    public final void m22952O2() {
        C11839m.m70688i("CampaignActivity", "checkActivityEntryListResult");
        C12515a.m75110o().m75172d(new C3584a());
    }

    /* renamed from: P2 */
    public final void m22953P2() {
        C11839m.m70688i("CampaignActivity", "checkCampaignConfig");
        if (TextUtils.isEmpty(this.f16604e0)) {
            C11839m.m70687e("CampaignActivity", "mTaskActivityId is empty");
            C11841o.m70708d(this, getString(R$string.already_received_tip), 1);
            finish();
        } else {
            m22954Q2();
            C10120h c10120h = this.f16602c0;
            if (c10120h != null) {
                c10120h.m63022G();
            }
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HiCloudBaseWebViewActivity
    /* renamed from: Q1 */
    public void mo20590Q1() {
        super.mo20590Q1();
        SafeIntent safeIntent = new SafeIntent(getIntent());
        m22968j3(safeIntent);
        this.f14918H = safeIntent.getStringExtra("srcChannel");
        this.f14920J = safeIntent.getStringExtra("activityCode");
        String stringExtra = safeIntent.getStringExtra("taskActivityId");
        this.f16604e0 = stringExtra;
        if (TextUtils.isEmpty(stringExtra)) {
            this.f16604e0 = C13823d.m82904y().m82922f(this);
        }
        this.f16605f0 = safeIntent.getStringExtra(NotifyConstants.Keys.NOTIFY_TYPE);
        this.f16607h0 = safeIntent.getBooleanExtra("campaign_need_show_toast", false);
        C11839m.m70686d("CampaignActivity", "srcChannel: " + this.f14918H + ", activityCode: " + this.f14920J + ", taskActivityId: " + this.f16604e0);
        C12998f.m78034R().m78102g0();
        this.f16602c0 = new C10120h(this);
        C12996d.m77971n().m77983G(this.f16602c0);
    }

    /* renamed from: Q2 */
    public final void m22954Q2() {
        this.f16608i0 = false;
        if (!StringUtil.isBlank(this.f16605f0)) {
            C11839m.m70688i("CampaignActivity", "mNotifyType=" + this.f16605f0);
            if (TextUtils.equals(this.f16605f0, "campaignNotify_8")) {
                this.f16608i0 = true;
            }
            HandlerC3585b handlerC3585b = this.f16600a0;
            if (handlerC3585b != null) {
                handlerC3585b.sendEmptyMessage(1001);
                return;
            }
            return;
        }
        if (!C9718g.m60602t().m60607E(this, false)) {
            C10270w c10270w = new C10270w(new Consumer() { // from class: com.huawei.android.hicloud.ui.activity.cloudpay.f
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f17542a.m22958W2((GetCampaignActivityEntryResp) obj);
                }
            }, 1);
            c10270w.m63434i("CampaignActivity");
            c10270w.m63381g();
            return;
        }
        C11839m.m70688i("CampaignActivity", "isCampaignValid=true");
        if (!TextUtils.equals(this.f16604e0, C9718g.m60602t().m60636p(this))) {
            C11839m.m70688i("CampaignActivity", "activityId has changed!");
            this.f16608i0 = true;
        }
        if (C13821b.m82867w().m82873F(this.f16604e0)) {
            C11839m.m70688i("CampaignActivity", "campaign has finish!");
            this.f16608i0 = true;
        }
        HandlerC3585b handlerC3585b2 = this.f16600a0;
        if (handlerC3585b2 != null) {
            handlerC3585b2.sendEmptyMessage(1001);
        }
    }

    /* renamed from: R2 */
    public final void m22955R2() {
        if (isFinishing() || isDestroyed()) {
            C11839m.m70687e("CampaignActivity", "checkTaskReport isFinishing()");
            return;
        }
        if (this.f16607h0) {
            C11839m.m70686d("CampaignActivity", "back from MainActivity");
        }
        C11839m.m70688i("CampaignActivity", "checkTaskReport");
        C12515a.m75110o().m75172d(new C3589f(this.f16600a0));
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HiCloudBaseWebViewActivity
    /* renamed from: S1 */
    public boolean mo20591S1() {
        try {
            setContentView(R$layout.campaign_webview_layout);
            this.f14939r = (NotchTopFitRelativeLayout) C12809f.m76829b(this, R$id.campaign_webview_main);
            this.f14941t = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.h5_operation_nonet);
            this.f14942u = (TextView) C12809f.m76829b(this, R$id.net_error_text);
            this.f14941t.setOnClickListener(this);
            AutoSizeButton autoSizeButton = (AutoSizeButton) C12809f.m76829b(this, R$id.h5_operation_no_net_btn);
            this.f14946y = autoSizeButton;
            autoSizeButton.setOnClickListener(this);
            this.f14943v = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.operation_error_url_layout);
            this.f14944w = (HwColumnLinearLayout) C12809f.m76829b(this, R$id.rl_loading);
            this.f14945x = (HwColumnLinearLayout) C12809f.m76829b(this, R$id.rl_error);
            this.f14940s = (HwProgressBar) C12809f.m76829b(this, R$id.external_webview_progress);
            SafeWebView safeWebView = (SafeWebView) C12809f.m76829b(this, R$id.campaign_webview);
            this.f14938q = safeWebView;
            if (safeWebView == null) {
                C11839m.m70687e("CampaignActivity", "initView is null");
                finish();
                return false;
            }
            C12808e.m76824c(this);
            C12808e.m76826e(this.f14939r);
            C11842p.m70874v1(this, this.f14946y);
            C11842p.m70760Q1(this, this.f14943v);
            return true;
        } catch (Exception e10) {
            C11839m.m70687e("CampaignActivity", "initView error: " + e10.getMessage());
            finish();
            return false;
        }
    }

    /* renamed from: S2 */
    public final void m22956S2() {
        HandlerC3585b handlerC3585b = this.f16600a0;
        if (handlerC3585b != null) {
            handlerC3585b.post(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.cloudpay.g
                @Override // java.lang.Runnable
                public final void run() {
                    this.f17544a.m22959X2();
                }
            });
        }
        C12515a.m75110o().m75172d(new C3588e(this.f16600a0, this.f16607h0));
    }

    /* renamed from: V2 */
    public void m22957V2() throws JSONException {
        mo20624d2();
        mo20590Q1();
        mo20594b2();
        m22950B1();
        if (C0209d.m1333z1(this)) {
            mo20598h2();
        } else {
            C11839m.m70688i("CampaignActivity", "initData showNetDisconnectView");
            mo20595e2();
        }
        new C10151b(this, R$id.bc_check_mark_view);
        m22932i3(this.f14913C);
    }

    /* renamed from: W2 */
    public final /* synthetic */ void m22958W2(GetCampaignActivityEntryResp getCampaignActivityEntryResp) {
        C9718g.m60602t().m60622Z(getCampaignActivityEntryResp);
        if (getCampaignActivityEntryResp != null) {
            if (getCampaignActivityEntryResp.getResultCode() == 0) {
                C11839m.m70688i("CampaignActivity", "doActivityEntryUpdate success");
                if (!TextUtils.equals(this.f16604e0, C9718g.m60602t().m60636p(this))) {
                    C11839m.m70688i("CampaignActivity", "checkCampaignEntryList finish dialog , due to ActivityId has changed!");
                    this.f16608i0 = true;
                }
            } else if ("31014003".equals(getCampaignActivityEntryResp.getErrorCode())) {
                C11839m.m70688i("CampaignActivity", "checkCampaignEntryList finish dialog , due to errorCode!");
                this.f16608i0 = true;
            }
        }
        HandlerC3585b handlerC3585b = this.f16600a0;
        if (handlerC3585b != null) {
            handlerC3585b.sendEmptyMessage(1001);
        }
        C13108a.m78878b(this).m78881d(new Intent(RecommendCardConstants.UPGRADE_BANNER_CONFIG_UPDATE));
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HiCloudBaseWebViewActivity
    /* renamed from: X1 */
    public String mo20620X1() throws IOException {
        CamJump camJump;
        C11839m.m70688i("CampaignActivity", "processLoadWebViewForRenew");
        CampaignActivityRoot campaignActivityRootM82894u = C13821b.m82867w().m82894u();
        if (campaignActivityRootM82894u == null || campaignActivityRootM82894u.getConfig() == null) {
            C11839m.m70687e("CampaignActivity", "configFromFile null");
            return "";
        }
        CampaignActivityConfig[] config = campaignActivityRootM82894u.getConfig();
        if (config == null) {
            C11839m.m70687e("CampaignActivity", "configs null");
            return "";
        }
        String strM60636p = C9718g.m60602t().m60636p(this);
        for (CampaignActivityConfig campaignActivityConfig : config) {
            if (campaignActivityConfig == null) {
                C11839m.m70687e("CampaignActivity", "activityConfig null");
            } else {
                String id2 = campaignActivityConfig.getId();
                if (TextUtils.isEmpty(id2)) {
                    C11839m.m70687e("CampaignActivity", "id null");
                } else if ((id2.equals(strM60636p) || id2.equals(this.f16604e0)) && (camJump = campaignActivityConfig.getCamJump()) != null) {
                    return camJump.getNotifyUri();
                }
            }
        }
        return "";
    }

    /* renamed from: X2 */
    public final /* synthetic */ void m22959X2() {
        C12998f.m78034R().m78089X0(true);
        C4308a.m25913l(this.f14938q);
        C12998f.m78034R().m78118p(this.f16600a0);
    }

    /* renamed from: Y2 */
    public final /* synthetic */ void m22960Y2(String str, String str2, String str3, String str4, long j10) {
        C11839m.m70688i("CampaignActivity", "onDownloadStart");
        m22927T2(this, str);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HiCloudBaseWebViewActivity
    /* renamed from: Z1 */
    public void mo20593Z1(SafeWebView safeWebView) {
        WebSettings settings = safeWebView.getSettings();
        if (settings == null) {
            C11839m.m70687e("CampaignActivity", "WebSettings is null.");
            return;
        }
        String userAgentString = settings.getUserAgentString();
        String str = "HiDiskCloudService/com.huawei.hidisk/16.0.0.300 (Linux; HarmonyOS " + Build.VERSION.RELEASE + "; " + Build.MODEL + "; " + C11829c.f54755a + ") HMS/2.6.3.306 (10055832)";
        safeWebView.getSettings().setUserAgentString(userAgentString + "; " + str);
    }

    /* renamed from: Z2 */
    public final /* synthetic */ void m22961Z2() {
        if (isFinishing() || isDestroyed()) {
            C11839m.m70688i("CampaignActivity", "showActivityError isFinishing");
        } else {
            C12998f.m78034R().m78093Z0(this, getString(R$string.msg_current_activity_end));
            finish();
        }
    }

    /* renamed from: a3 */
    public final void m22962a3() {
        C11839m.m70686d("CampaignActivity", "url: " + this.f14912B);
        if (StringUtil.isBlank(this.f14912B)) {
            C11839m.m70687e("CampaignActivity", "loadWebView url is invalid.");
            mo20596f2();
        } else {
            if (!C11829c.m70580h(this.f14912B, this.f14930T)) {
                C11839m.m70687e("CampaignActivity", "check url host invalid, return");
                mo20596f2();
                return;
            }
            m22970l3(this.f14938q);
            this.f14936Z = C11983e.m72121b().m72122a(this.f14938q);
            C11839m.m70688i("CampaignActivity", "loadUrl");
            this.f14938q.loadUrl(this.f14912B);
            m22967h3(this);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HiCloudBaseWebViewActivity
    /* renamed from: b2 */
    public void mo20594b2() {
        super.mo20594b2();
        mo20593Z1(this.f14938q);
        this.f14938q.m53596e(new C3587d(this), false);
        this.f14938q.setWebChromeClient(new CampaignTaskWebChromeClient());
        this.f14938q.addJavascriptInterface(new C3586c(this, this.f14938q, this.f14930T, this.f16600a0, this.f16604e0, this.f14918H), "hidiskOperation");
        this.f14938q.setDownloadListener(new DownloadListener() { // from class: com.huawei.android.hicloud.ui.activity.cloudpay.e
            @Override // android.webkit.DownloadListener
            public final void onDownloadStart(String str, String str2, String str3, String str4, long j10) {
                this.f17540a.m22960Y2(str, str2, str3, str4, j10);
            }
        });
    }

    /* renamed from: b3 */
    public final void m22963b3(Object obj) {
        C11839m.m70687e("CampaignActivity", "post activity dispatch failed");
        if (obj instanceof Bundle) {
            String string = ((Bundle) obj).getString(AddressConstants.Extras.EXTRA_NAME_ERR_CODE);
            this.f16609j0 = string;
            if (C0209d.m1245d1(this, CampaignActivity.class.getName())) {
                C12998f.m78034R().m78134x(this, this.f14938q, string);
            }
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HiCloudBaseWebViewActivity
    /* renamed from: d2 */
    public void mo20624d2() {
        C11839m.m70688i("CampaignActivity", "showLoadingView");
        HwColumnLinearLayout hwColumnLinearLayout = this.f14944w;
        if (hwColumnLinearLayout != null) {
            hwColumnLinearLayout.setVisibility(0);
        }
        HwColumnLinearLayout hwColumnLinearLayout2 = this.f14945x;
        if (hwColumnLinearLayout2 != null) {
            hwColumnLinearLayout2.setVisibility(8);
        }
        NotchFitLinearLayout notchFitLinearLayout = this.f14941t;
        if (notchFitLinearLayout != null) {
            notchFitLinearLayout.setVisibility(8);
        }
        SafeWebView safeWebView = this.f14938q;
        if (safeWebView != null) {
            safeWebView.setVisibility(8);
        }
        NotchFitLinearLayout notchFitLinearLayout2 = this.f14943v;
        if (notchFitLinearLayout2 != null) {
            notchFitLinearLayout2.setVisibility(8);
        }
    }

    /* renamed from: d3 */
    public final void m22964d3() {
        if ("501".equals(this.f14918H)) {
            C11839m.m70688i("CampaignActivity", "processPushChannelClick mSrcChannel=" + this.f14918H);
            MessageCenterManager.getInstance().cancelCampaignMsgNotification();
        }
    }

    /* renamed from: f3 */
    public final void m22965f3(int i10, String str) {
        C11839m.m70688i("CampaignActivity", "processReportCampaignLaunch: " + i10 + str);
        String strM78021n = C12997e.m78021n();
        if (TextUtils.isEmpty(strM78021n)) {
            return;
        }
        this.f16609j0 = String.valueOf(i10);
        C4308a.m25905d(String.format(Locale.ENGLISH, "%s(%d)", strM78021n, Integer.valueOf(i10)), this.f14938q);
    }

    /* renamed from: g3 */
    public final void m22966g3() {
        C11839m.m70688i("CampaignActivity", "processWebViewUrl");
        if (StringUtil.isBlank(this.f14947z)) {
            this.f14912B = mo20620X1();
        } else {
            this.f14912B = this.f14947z;
        }
        if (StringUtil.isBlank(this.f14912B)) {
            C11839m.m70688i("CampaignActivity", "activity url empty");
            HandlerC3585b handlerC3585b = this.f16600a0;
            if (handlerC3585b != null) {
                this.f16600a0.sendMessageDelayed(Message.obtain(handlerC3585b, 1006), 1000L);
                return;
            }
            return;
        }
        if (this.f16608i0) {
            Uri.Builder builderBuildUpon = Uri.parse(this.f14912B).buildUpon();
            builderBuildUpon.appendQueryParameter("endFlag", FaqConstants.DISABLE_HA_REPORT);
            this.f14912B = builderBuildUpon.toString();
            C11839m.m70686d("CampaignActivity", "append endFlag");
        }
        HandlerC3585b handlerC3585b2 = this.f16600a0;
        if (handlerC3585b2 != null) {
            handlerC3585b2.obtainMessage(1007).sendToTarget();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HiCloudBaseWebViewActivity
    /* renamed from: h2 */
    public void mo20598h2() {
        super.mo20598h2();
        m22953P2();
    }

    /* renamed from: h3 */
    public final void m22967h3(Context context) {
        if (this.f16601b0 == null) {
            this.f16601b0 = new ActivityDispatchReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.huawei.android.hicloud.ACTION_ACTIVITY_DISPATCH");
            C13108a.m78878b(context).m78880c(this.f16601b0, intentFilter);
        }
    }

    /* renamed from: j3 */
    public final void m22968j3(SafeIntent safeIntent) {
        String stringExtra = safeIntent.getStringExtra("entrance_from");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("entrance_from", stringExtra);
        C12997e.m78025r("enter_task_center_event", linkedHashMap);
    }

    /* renamed from: k3 */
    public final void m22969k3(boolean z10) {
        if (z10) {
            C11842p.m70717C0(this);
        } else {
            C11842p.m70720D0(this);
        }
    }

    /* renamed from: l3 */
    public void m22970l3(SafeWebView safeWebView) {
        if (safeWebView == null) {
            return;
        }
        String[] strArr = this.f14930T;
        if (strArr == null || strArr.length == 0) {
            safeWebView.setWhitelistWithPath(new String[]{this.f14912B});
        } else {
            safeWebView.setWhitelist(strArr);
        }
    }

    /* renamed from: m3 */
    public final void m22971m3() {
        C11839m.m70688i("CampaignActivity", "showActivityError");
        runOnUiThread(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.cloudpay.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f17538a.m22961Z2();
            }
        });
    }

    /* renamed from: n3 */
    public void m22972n3(Message message) {
        Bundle data = message.getData();
        if (data != null) {
            String string = data.getString("toast_content");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            C12998f.m78034R().m78093Z0(this, string);
        }
    }

    /* renamed from: o3 */
    public final void m22973o3(Context context) {
        if (this.f16601b0 != null) {
            C13108a.m78878b(context.getApplicationContext()).m78883f(this.f16601b0);
            this.f16601b0 = null;
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HMSTermsProcessBaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        C11839m.m70688i("CampaignActivity", "onActivityResult requestCode: " + i10 + ", resultCode: " + i11);
        if (i10 == 1) {
            Uri data = i11 != -1 ? null : new SafeIntent(intent).getData();
            if (this.f16603d0 != null) {
                if (data == null || !C11829c.m70544S0(data)) {
                    this.f16603d0.onReceiveValue(null);
                } else {
                    this.f16603d0.onReceiveValue(new Uri[]{data});
                }
                this.f16603d0 = null;
                return;
            }
            return;
        }
        if (101 == i10) {
            C12998f.m78034R().m78121q0(this.f16600a0);
            return;
        }
        if (102 == i10) {
            C12998f.m78034R().m78116o(this.f16600a0, true, null);
            return;
        }
        if (103 == i10) {
            C12998f.m78034R().m78124s(this.f16600a0, true, null);
            return;
        }
        if (104 == i10) {
            C12998f.m78034R().m78130v(this.f16600a0, true, C12998f.m78034R().f59186j, null);
            return;
        }
        if (105 == i10) {
            C12998f.m78034R().m78122r(this.f16600a0, true, null);
            return;
        }
        if (1000 == i10) {
            if (i11 == -1) {
                this.f16602c0.m63025m();
            }
        } else if (1002 == i10) {
            C11839m.m70688i("CampaignActivity", "reportCampaignLaunch");
            C12996d.m77971n().m77978B();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HiCloudBaseWebViewActivity, android.app.Activity
    public void onBackPressed() {
        SafeWebView safeWebView = this.f14938q;
        if (safeWebView == null || !safeWebView.canGoBack()) {
            super.onBackPressed();
            m22378l1();
        } else {
            C11839m.m70688i("CampaignActivity", "goBack");
            this.f14938q.goBack();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HiCloudBaseWebViewActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C11842p.m70874v1(this, this.f14946y);
        C11842p.m70760Q1(this, this.f14943v);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HiCloudBaseWebViewActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws JSONException {
        super.onCreate(bundle);
        C11839m.m70688i("CampaignActivity", "onCreate");
        this.f16600a0 = new HandlerC3585b(this);
        C12997e.m78026s(this);
        C12997e.m78028u(this.f16600a0);
        C12996d.m77971n().m77984H(this.f16600a0);
        C12998f.m78034R().m78074P0(this.f16600a0);
        C11842p.m70717C0(this);
        if (!mo20591S1()) {
            C11839m.m70687e("CampaignActivity", "isInit return");
            return;
        }
        m22957V2();
        C13227f.m79492i1().m79598v0(this, new SafeIntent(getIntent()), "CampaignActivity");
        m22964d3();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HiCloudBaseWebViewActivity, com.huawei.android.hicloud.p088ui.activity.BaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        C11839m.m70688i("CampaignActivity", "onDestroy");
        ValueCallback<Uri[]> valueCallback = this.f16603d0;
        if (valueCallback != null) {
            valueCallback.onReceiveValue(null);
            this.f16603d0 = null;
        }
        C10120h c10120h = this.f16602c0;
        if (c10120h != null) {
            c10120h.m63017B();
            this.f16602c0.m63026n();
        }
        m22973o3(this);
        C12996d.m77971n().m77993f();
        C12993a.m77958b();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HiCloudBaseWebViewActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onNewIntent(Intent intent) throws JSONException {
        super.onNewIntent(intent);
        C11839m.m70688i("CampaignActivity", "onNewIntent");
        if (9 == new SafeIntent(intent).getIntExtra("channels", 0)) {
            C11839m.m70688i("CampaignActivity", "back from float view");
            return;
        }
        setIntent(intent);
        m22957V2();
        C13227f.m79492i1().m79598v0(this, new SafeIntent(getIntent()), "CampaignActivity");
        new C13149f().m79065c(this, getIntent(), C13222a.m79465g(this));
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HiCloudBaseWebViewActivity, com.huawei.android.hicloud.p088ui.activity.BaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            if (this.f14941t.getVisibility() == 0 || this.f14944w.getVisibility() == 0) {
                this.f14944w.setVisibility(8);
                this.f14938q.setVisibility(8);
                finish();
                return true;
            }
            SafeWebView safeWebView = this.f14938q;
            if (safeWebView != null && safeWebView.canGoBack()) {
                this.f14938q.goBack();
                return true;
            }
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HiCloudBaseWebViewActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        C11839m.m70688i("CampaignActivity", "onResume");
        C4308a.m25912k(this.f14938q);
        if (!this.f16606g0) {
            C4308a.m25913l(this.f14938q);
            C12998f.m78034R().m78134x(this, this.f14938q, this.f16609j0);
            C12998f.m78034R().m78118p(this.f16600a0);
        }
        this.f16606g0 = false;
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.CampaignActivity$d */
    public class C3587d extends C12817a {

        /* renamed from: a */
        public CampaignActivity f16620a;

        public C3587d(CampaignActivity campaignActivity) {
            this.f16620a = campaignActivity;
        }

        /* renamed from: b */
        public final /* synthetic */ void m22992b() {
            this.f16620a.m22928U2();
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            C11839m.m70686d("CampaignActivity", "onPageFinished url: " + str);
            super.onPageFinished(webView, str);
            CampaignActivity campaignActivity = this.f16620a;
            if (campaignActivity != null) {
                campaignActivity.runOnUiThread(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.cloudpay.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f17545a.m22992b();
                    }
                });
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            C11839m.m70686d("CampaignActivity", "onPageStarted url: " + str);
            if (C11829c.m70580h(str, CampaignActivity.this.f14930T)) {
                super.onPageStarted(webView, str, bitmap);
            } else {
                C11839m.m70687e("CampaignActivity", "onPageStarted check url host invalid, return");
                CampaignActivity.this.mo20596f2();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i10, String str, String str2) {
            super.onReceivedError(webView, i10, str, str2);
            C11839m.m70688i("CampaignActivity", "onReceivedError, errorCode=" + i10);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            CampaignActivity campaignActivity;
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            int statusCode = webResourceResponse != null ? webResourceResponse.getStatusCode() : 0;
            C11839m.m70688i("CampaignActivity", "onReceivedHttpError errorCode is:" + statusCode);
            if (!webResourceRequest.isForMainFrame()) {
                C11839m.m70688i("CampaignActivity", "onReceivedHttpError !request.isForMainFrame()");
                return;
            }
            if ((statusCode == 403 || statusCode == 404 || statusCode == 500 || statusCode == 502) && (campaignActivity = this.f16620a) != null) {
                campaignActivity.m20623c2();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            C11839m.m70688i("CampaignActivity", "onReceivedSslError");
            try {
                C10620h.m65082a(sslErrorHandler, sslError, this.f16620a);
            } catch (Exception e10) {
                C11839m.m70687e("CampaignActivity", "MyWebViewClient onReceivedSslError exception : " + e10.getMessage());
                sslErrorHandler.cancel();
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (!C11829c.m70580h(CampaignActivity.this.f14912B, CampaignActivity.this.f14930T)) {
                C11839m.m70687e("CampaignActivity", "shouldOverrideUrlLoading check url host invalid, return");
                CampaignActivity.this.mo20596f2();
                return false;
            }
            if (StringUtil.isBlank(str)) {
                C11839m.m70687e("CampaignActivity", "shouldOverrideUrlLoading, url is empty");
                return false;
            }
            if (webView == null) {
                C11839m.m70687e("CampaignActivity", "shouldOverrideUrlLoading, view is null");
                return false;
            }
            if (str.startsWith("http") || str.startsWith("https")) {
                C11839m.m70687e("CampaignActivity", "shouldOverrideUrlLoading, url is illegal");
                return false;
            }
            C11839m.m70686d("CampaignActivity", "shouldOverrideUrlLoading url: " + str);
            C4308a.m25909h(this.f16620a, str, "");
            return true;
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            C11839m.m70688i("CampaignActivity", "onReceivedError, error=" + webResourceError.getErrorCode());
        }
    }
}
