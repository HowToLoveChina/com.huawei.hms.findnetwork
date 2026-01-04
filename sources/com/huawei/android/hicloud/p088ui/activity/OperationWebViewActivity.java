package com.huawei.android.hicloud.p088ui.activity;

import android.R;
import android.app.ActionBar;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.Window;
import android.webkit.DownloadListener;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.Toast;
import ca.C1398a;
import ca.C1403f;
import com.google.gson.Gson;
import com.huawei.android.hicloud.bean.aop.SyncPluginResult;
import com.huawei.android.hicloud.cloudbackup.process.RestoreUtil;
import com.huawei.android.hicloud.hisync.model.H5UserAddress;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.CouponCenterActivity;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.PaymentManagerAndOrderActivity;
import com.huawei.android.hicloud.p088ui.uiextend.cloudpay.dialog.ConfirmBuyPackageDialog;
import com.huawei.android.hicloud.p088ui.uiextend.cloudpay.dialog.PayResultErrorDialog;
import com.huawei.android.hicloud.utils.WebViewManager;
import com.huawei.android.p073ds.R$color;
import com.huawei.cloud.pay.R$string;
import com.huawei.cloud.pay.model.ChannelInfo;
import com.huawei.cloud.pay.model.EstimateResp;
import com.huawei.cloud.pay.model.GetClientUIConfigResp;
import com.huawei.cloud.pay.model.HiCloudNativeAd;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.constants.RecommendCardConstants;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hidisk.common.util.javautil.StringUtil;
import com.huawei.hms.identity.entity.UserAddress;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.secure.android.common.webview.SafeWebView;
import com.huawei.uikit.phone.hwprogressbar.widget.HwProgressBar;
import dj.C9158a;
import fj.C9712a;
import hu.C10344c;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Objects;
import je.C10778b;
import je.C10797k0;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0234s;
import p015ak.C0241z;
import p037bp.C1270a;
import p054cj.C1442a;
import p232dp.InterfaceC9282a;
import p329h7.C10120h;
import p336he.C10150a;
import p336he.C10151b;
import p373iu.C10620h;
import p399jk.AbstractC10896a;
import p429kk.C11058a;
import p429kk.C11060c;
import p431ko.C11081g;
import p450le.C11272a;
import p450le.C11273b;
import p454lj.C11296s;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11842p;
import p529op.C11983e;
import p616rk.C12515a;
import p651t8.C12997e;
import p651t8.C12998f;
import p664u0.C13108a;
import p674ub.C13149f;
import p684un.C13222a;
import p684un.C13223b;
import p684un.C13227f;
import p684un.C13230i;
import p709vj.C13452e;
import p746wn.C13622a;
import p836z8.C14157f;
import sk.C12806c;
import sk.C12809f;
import sm.C12817a;
import uk.C13206d;

/* loaded from: classes3.dex */
public class OperationWebViewActivity extends HiCloudBaseWebViewActivity implements WebViewManager.WebViewManagerCallback {

    /* renamed from: t0 */
    public static String f15689t0 = "";

    /* renamed from: u0 */
    public static String f15690u0 = "";

    /* renamed from: v0 */
    public static String f15691v0 = "";

    /* renamed from: a0 */
    public ValueCallback<Uri[]> f15692a0;

    /* renamed from: b0 */
    public C10120h f15693b0;

    /* renamed from: c0 */
    public String f15694c0;

    /* renamed from: d0 */
    public String f15695d0;

    /* renamed from: e0 */
    public String f15696e0;

    /* renamed from: h0 */
    public boolean f15699h0;

    /* renamed from: j0 */
    public boolean f15701j0;

    /* renamed from: k0 */
    public ConfirmBuyPackageDialog f15702k0;

    /* renamed from: l0 */
    public EstimateResp f15703l0;

    /* renamed from: m0 */
    public PayResultErrorDialog f15704m0;

    /* renamed from: n0 */
    public Toast f15705n0;

    /* renamed from: p0 */
    public String f15707p0;

    /* renamed from: f0 */
    public boolean f15697f0 = false;

    /* renamed from: g0 */
    public boolean f15698g0 = false;

    /* renamed from: i0 */
    public boolean f15700i0 = true;

    /* renamed from: o0 */
    public long f15706o0 = 0;

    /* renamed from: q0 */
    public final Runnable f15708q0 = new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.s7
        @Override // java.lang.Runnable
        public final void run() {
            this.f17731a.m21833Y2();
        }
    };

    /* renamed from: r0 */
    public Handler f15709r0 = new HandlerC3429a(Looper.getMainLooper());

    /* renamed from: s0 */
    public Handler f15710s0 = new HandlerC3430b();

    /* renamed from: com.huawei.android.hicloud.ui.activity.OperationWebViewActivity$a */
    public class HandlerC3429a extends Handler {
        public HandlerC3429a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
            C11839m.m70688i(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "H5Msg.What: " + message.what);
            int i10 = message.what;
            if (i10 == 2002) {
                OperationWebViewActivity.this.f15702k0 = new ConfirmBuyPackageDialog(OperationWebViewActivity.this);
                OperationWebViewActivity operationWebViewActivity = OperationWebViewActivity.this;
                operationWebViewActivity.m21817A3(operationWebViewActivity.f15702k0, OperationWebViewActivity.this.f15703l0, (GetClientUIConfigResp) message.obj);
            }
            if (i10 == 2134) {
                OperationWebViewActivity.this.m21824P2(message.obj);
                return;
            }
            if (i10 == 2135) {
                OperationWebViewActivity.this.m21825Q2(message.arg1);
                return;
            }
            String str = HiCloudNativeAd.CHANNEL_UNKONWN;
            switch (i10) {
                case 100:
                    Bundle data = message.getData();
                    if (data != null) {
                        OperationWebViewActivity.this.m20614N1(data.getString("javascript"));
                        break;
                    }
                    break;
                case 101:
                    OperationWebViewActivity.this.onBackPressed();
                    break;
                case 102:
                    OperationWebViewActivity.this.m21836b3(message.getData());
                    break;
                case 103:
                    OperationWebViewActivity.this.m21850p3();
                    OperationWebViewActivity.this.finish();
                    break;
                case 104:
                    Bundle data2 = message.getData();
                    if (data2 != null) {
                        OperationWebViewActivity.this.f14928R = data2.getBoolean("exit_flag", false);
                        break;
                    }
                    break;
                case 105:
                    OperationWebViewActivity.this.m21814y3(message);
                    break;
                case 106:
                    Object obj = message.obj;
                    if (obj instanceof String) {
                        Bundle data3 = message.getData();
                        if (data3 != null) {
                            String string = data3.getString(FaqConstants.FAQ_CHANNEL);
                            if (!TextUtils.isEmpty(string)) {
                                str = string;
                            }
                        }
                        C10797k0.m65696v(OperationWebViewActivity.this.f15710s0, (String) obj, str);
                        break;
                    }
                    break;
                case 107:
                    Object obj2 = message.obj;
                    if (obj2 instanceof String) {
                        Bundle data4 = message.getData();
                        if (data4 != null) {
                            String string2 = data4.getString(FaqConstants.FAQ_CHANNEL);
                            if (!TextUtils.isEmpty(string2)) {
                                str = string2;
                            }
                        }
                        C10797k0.m65697w(OperationWebViewActivity.this.f15710s0, (String) obj2, str);
                        break;
                    }
                    break;
                default:
                    switch (i10) {
                        case 110:
                            OperationWebViewActivity.this.m21828T2(((Boolean) message.obj).booleanValue());
                            break;
                        case 111:
                            C11842p.m70710A0(OperationWebViewActivity.this, ((Boolean) message.obj).booleanValue());
                            OperationWebViewActivity operationWebViewActivity2 = OperationWebViewActivity.this;
                            if (operationWebViewActivity2.f14940s != null && !operationWebViewActivity2.f15698g0) {
                                int iM70852q = C11842p.m70852q(OperationWebViewActivity.this);
                                if (!C12806c.m76810a(OperationWebViewActivity.this) || C11842p.m70771U0()) {
                                    iM70852q += C11842p.m70789a0(OperationWebViewActivity.this);
                                }
                                C11842p.m70736I1(OperationWebViewActivity.this.f14940s, iM70852q);
                                break;
                            }
                            break;
                        case 112:
                            OperationWebViewActivity.this.m21854t3();
                            break;
                    }
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.OperationWebViewActivity$b */
    public class HandlerC3430b extends Handler {
        public HandlerC3430b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 7007) {
                OperationWebViewActivity.this.m21840f3(0);
                return;
            }
            if (i10 == 7008) {
                OperationWebViewActivity.this.m21840f3(message.arg1);
            } else if (i10 == 7005) {
                OperationWebViewActivity.this.m21839e3(0);
            } else if (i10 == 7006) {
                OperationWebViewActivity.this.m21839e3(message.arg1);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.OperationWebViewActivity$c */
    public class RunnableC3431c implements Runnable {
        public RunnableC3431c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C11839m.m70688i(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "refreshUpdate");
            Intent intent = new Intent();
            intent.setAction("com.huawei.hicloud.intent.action.ACTION_AOP_PAY_SUCCESS");
            C13108a.m78878b(C0213f.m1377a()).m78881d(intent);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.OperationWebViewActivity$d */
    public class C3432d {
        public C3432d() {
        }

        @JavascriptInterface
        public void agreementCheckMore() {
            Intent intent = new Intent();
            if (TextUtils.equals("HUAWEI", C0209d.m1160D())) {
                intent.setClassName("com.huawei.systemmanager", "com.huawei.dataprivacycenter.MainActivity");
            }
            try {
                OperationWebViewActivity.this.startActivity(intent);
            } catch (Exception e10) {
                C11839m.m70687e(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "check more error: " + e10);
            }
        }

        @JavascriptInterface
        public boolean needDisplay() {
            return TextUtils.equals("HUAWEI", C0209d.m1160D());
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.OperationWebViewActivity$e */
    public class C3433e {
        public C3433e() {
        }

        @JavascriptInterface
        public String getMediaApps(int i10, int i11) {
            C11839m.m70688i(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "getMediaApps, begin = " + i10 + " , end = " + i11);
            return C9712a.m60564a().m60565b(i10, i11);
        }

        @JavascriptInterface
        public boolean isDarkMode() {
            boolean zM70732H0 = C11842p.m70732H0(C0213f.m1377a());
            C11839m.m70688i(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "isDarkMode, isDark = " + zM70732H0);
            return zM70732H0;
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.OperationWebViewActivity$f */
    public class C3434f extends C12817a {
        public C3434f() {
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x003f  */
        @Override // android.webkit.WebViewClient
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onPageFinished(android.webkit.WebView r3, java.lang.String r4) {
            /*
                r2 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "onPageFinished: "
                r0.append(r1)
                r0.append(r4)
                java.lang.String r0 = r0.toString()
                java.lang.String r1 = "OperationWebViewActivity"
                p514o9.C11839m.m70686d(r1, r0)
                super.onPageFinished(r3, r4)
                java.lang.String r3 = r3.getTitle()
                boolean r0 = android.text.TextUtils.isEmpty(r3)
                if (r0 != 0) goto L3f
                boolean r0 = android.webkit.URLUtil.isNetworkUrl(r3)
                if (r0 != 0) goto L3f
                com.huawei.android.hicloud.ui.activity.OperationWebViewActivity r0 = com.huawei.android.hicloud.p088ui.activity.OperationWebViewActivity.this
                boolean r4 = com.huawei.android.hicloud.p088ui.activity.OperationWebViewActivity.m21803o2(r0, r4)
                if (r4 != 0) goto L3f
                com.huawei.android.hicloud.ui.activity.OperationWebViewActivity r4 = com.huawei.android.hicloud.p088ui.activity.OperationWebViewActivity.this
                boolean r0 = r4.f14931U
                if (r0 != 0) goto L3f
                boolean r0 = r4.f14925O
                if (r0 != 0) goto L3f
                r4.m21855u3(r3)
                goto L46
            L3f:
                com.huawei.android.hicloud.ui.activity.OperationWebViewActivity r3 = com.huawei.android.hicloud.p088ui.activity.OperationWebViewActivity.this
                java.lang.String r4 = r3.f14924N
                r3.m21855u3(r4)
            L46:
                com.huawei.android.hicloud.ui.activity.OperationWebViewActivity r2 = com.huawei.android.hicloud.p088ui.activity.OperationWebViewActivity.this
                com.huawei.android.hicloud.p088ui.activity.OperationWebViewActivity.m21813y2(r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.p088ui.activity.OperationWebViewActivity.C3434f.onPageFinished(android.webkit.WebView, java.lang.String):void");
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            C11839m.m70686d(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "onPageStarted: " + str + ",mIsUseMargin," + OperationWebViewActivity.this.f14911A);
            if (!C11829c.m70580h(str, OperationWebViewActivity.this.f14930T) && !OperationWebViewActivity.this.f14931U) {
                C11839m.m70687e(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "onPageStarted check url host invalid, return");
                OperationWebViewActivity operationWebViewActivity = OperationWebViewActivity.this;
                operationWebViewActivity.mo20592U1(C11829c.m70560a0(operationWebViewActivity.f14947z), Arrays.toString(OperationWebViewActivity.this.f14930T));
                OperationWebViewActivity.this.mo20596f2();
                return;
            }
            OperationWebViewActivity operationWebViewActivity2 = OperationWebViewActivity.this;
            if (operationWebViewActivity2.m20617T1(operationWebViewActivity2.f14947z) || OperationWebViewActivity.this.f14938q == null) {
                super.onPageStarted(webView, str, bitmap);
            } else {
                C11839m.m70687e(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "onPageStarted url is invalid");
                OperationWebViewActivity.this.f14938q.m53595d(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i10, String str, String str2) {
            super.onReceivedError(webView, i10, str, str2);
            C11839m.m70688i(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "onReceivedError, errorCode=" + i10);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            C11839m.m70688i(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "onReceivedHttpError");
            if (!webResourceRequest.isForMainFrame()) {
                C11839m.m70688i(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "onReceivedHttpError !request.isForMainFrame()");
                return;
            }
            if (webResourceResponse != null) {
                int statusCode = webResourceResponse.getStatusCode();
                C11839m.m70688i(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "onReceivedHttpError errorCode is:" + statusCode);
                if (statusCode == 403 || statusCode == 404 || statusCode == 500 || statusCode == 502) {
                    OperationWebViewActivity.this.f15701j0 = true;
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            C11839m.m70688i(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "onReceivedSslError");
            try {
                C10620h.m65082a(sslErrorHandler, sslError, OperationWebViewActivity.this);
            } catch (Exception e10) {
                C11839m.m70687e(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "MyWebViewClient onReceivedSslError exception : " + e10.getMessage());
                sslErrorHandler.cancel();
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            C11839m.m70686d(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "shouldOverrideUrlLoading, url: " + str);
            OperationWebViewActivity operationWebViewActivity = OperationWebViewActivity.this;
            if (!C11829c.m70580h(operationWebViewActivity.f14947z, operationWebViewActivity.f14930T)) {
                C11839m.m70687e(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "shouldOverrideUrlLoading check url host invalid, return");
                OperationWebViewActivity operationWebViewActivity2 = OperationWebViewActivity.this;
                operationWebViewActivity2.mo20592U1(C11829c.m70560a0(operationWebViewActivity2.f14947z), Arrays.toString(OperationWebViewActivity.this.f14930T));
                OperationWebViewActivity.this.mo20596f2();
                return false;
            }
            OperationWebViewActivity operationWebViewActivity3 = OperationWebViewActivity.this;
            if (operationWebViewActivity3.f14927Q && !C11829c.m70580h(str, operationWebViewActivity3.f14930T)) {
                try {
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    intent.setData(Uri.parse(str));
                    OperationWebViewActivity.this.startActivity(intent);
                } catch (Exception e10) {
                    C11839m.m70687e(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "use browser exception: " + e10.toString());
                }
                return true;
            }
            if (TextUtils.isEmpty(str)) {
                C11839m.m70687e(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "shouldOverrideUrlLoading, url is empty");
                return false;
            }
            if (webView == null) {
                C11839m.m70687e(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "shouldOverrideUrlLoading, view is null");
                return false;
            }
            if (str.startsWith("https") || str.startsWith("http")) {
                C11839m.m70687e(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "shouldOverrideUrlLoading, url is illegal");
                return false;
            }
            OperationWebViewActivity operationWebViewActivity4 = OperationWebViewActivity.this;
            OperationWebViewActivity.m21796W2(operationWebViewActivity4, str, operationWebViewActivity4.f15695d0);
            return true;
        }

        public /* synthetic */ C3434f(OperationWebViewActivity operationWebViewActivity, HandlerC3429a handlerC3429a) {
            this();
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            C11839m.m70688i(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "onReceivedError, error=" + webResourceError.getErrorCode());
        }
    }

    /* renamed from: O2 */
    public static void m21795O2(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            C11839m.m70687e(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "goToBrowserDownload context or url is Empty");
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.BROWSABLE");
            intent.setData(Uri.parse(str));
            context.startActivity(intent);
        } catch (Exception e10) {
            C11839m.m70687e(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "onDownloadStart Exception =" + e10.getMessage());
        }
    }

    /* renamed from: W2 */
    public static void m21796W2(Activity activity, String str, String str2) {
        if (activity == null || str == null) {
            return;
        }
        if (!TextUtils.isEmpty(str2)) {
            Uri.Builder builderBuildUpon = Uri.parse(str).buildUpon();
            builderBuildUpon.appendQueryParameter("sceneCode", str2);
            str = builderBuildUpon.toString();
        }
        C11839m.m70688i(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "jump to third app");
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addCategory("android.intent.category.BROWSABLE");
            intent.putExtra(RecommendCardConstants.IS_FROM_RECOMMEND_CARD, true);
            intent.setComponent(null);
            intent.setSelector(null);
            activity.startActivityIfNeeded(intent, -1);
        } catch (ActivityNotFoundException unused) {
            AbstractC10896a.m65886e(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "ActivityNotFoundException:" + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y3 */
    public void m21814y3(Message message) {
        Bundle data = message.getData();
        if (data != null) {
            String string = data.getString("toast_content");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            m21816z3(string);
        }
    }

    /* renamed from: z3 */
    private void m21816z3(CharSequence charSequence) {
        C11839m.m70686d(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "show toast, text: " + ((Object) charSequence));
        if (this.f15705n0 != null) {
            C11839m.m70686d(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "mToast is not null, text: " + ((Object) charSequence));
            this.f15705n0.cancel();
        }
        Toast toastMakeText = Toast.makeText(C0213f.m1377a(), charSequence, 1);
        this.f15705n0 = toastMakeText;
        toastMakeText.show();
    }

    /* renamed from: A3 */
    public final void m21817A3(ConfirmBuyPackageDialog confirmBuyPackageDialog, EstimateResp estimateResp, GetClientUIConfigResp getClientUIConfigResp) {
        if (estimateResp == null || confirmBuyPackageDialog == null || confirmBuyPackageDialog.isShowing()) {
            C1442a.m8291w(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "cloudSpace or dialog is null");
        } else {
            confirmBuyPackageDialog.showConvertDialog(estimateResp, getClientUIConfigResp, new ChannelInfo());
        }
    }

    /* renamed from: B1 */
    public void m21818B1() throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        ActionBar actionBar = getActionBar();
        if (actionBar == null) {
            C11839m.m70687e(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "getActionBar is empty");
            return;
        }
        actionBar.setDisplayHomeAsUpEnabled(true);
        if (this.f15698g0) {
            C11842p.m70710A0(this, C11842p.m70732H0(this));
            return;
        }
        if (this.f15697f0) {
            C11829c.m70627w1(getApplicationContext(), getWindow());
            C10150a.m63212b(actionBar, new ColorDrawable(getColor(R$color.pay_activity_harmony_bg)));
        } else {
            C10150a.m63212b(actionBar, new ColorDrawable(getColor(R$color.emui_color_bg)));
        }
        if (!TextUtils.isEmpty(this.f14935Y)) {
            m20621Y1(actionBar);
        }
        C11839m.m70686d(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "setActionBarExBackground white");
    }

    /* renamed from: J2 */
    public final void m21819J2(String str) {
        this.f14912B = C0234s.m1623a(this.f14912B, str, C0234s.m1644v(this.f14947z, str, new HiCloudSafeIntent(getIntent()).getBooleanExtra("is_check_lang_case", false)));
    }

    /* renamed from: K2 */
    public final void m21820K2(LinkedHashMap<String, String> linkedHashMap) {
        if (linkedHashMap != null) {
            if (!TextUtils.isEmpty(this.f14918H)) {
                linkedHashMap.put("srcChannel", this.f14918H);
            }
            if (!TextUtils.isEmpty(this.f14920J)) {
                linkedHashMap.put("activityCode", this.f14920J);
            }
            linkedHashMap.put("aop_from_where", String.valueOf(this.f14921K));
        }
    }

    /* renamed from: L2 */
    public final Bundle m21821L2(String str, int i10) {
        Bundle bundle = new Bundle();
        SyncPluginResult syncPluginResult = new SyncPluginResult();
        syncPluginResult.setStatus(i10);
        bundle.putString("javascript", String.format(Locale.ENGLISH, str, new Gson().toJson(syncPluginResult)));
        return bundle;
    }

    /* renamed from: M2 */
    public void m21822M2() {
        C11839m.m70688i(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "clickConvertPositiveBtn");
        Message message = new Message();
        message.what = 100;
        message.setData(m21821L2("afterVipBeforePurchase(%s)", 1));
        this.f15709r0.sendMessage(message);
        m21842h3();
        m21848n3();
    }

    /* renamed from: N2 */
    public void m21823N2() {
        C11839m.m70688i(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "clickNegativeBtn");
        Message message = new Message();
        message.what = 100;
        message.setData(m21821L2("afterVipBeforePurchase(%s)", 0));
        this.f15709r0.sendMessage(message);
        m21847m3();
    }

    /* renamed from: P2 */
    public void m21824P2(Object obj) {
        C1442a.m8290i(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "handleAopEstimate");
        if (obj instanceof EstimateResp) {
            EstimateResp estimateResp = (EstimateResp) obj;
            this.f15703l0 = estimateResp;
            if (estimateResp.getConvertInfo() == null) {
                C1442a.m8289e(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "handleAopEstimate, convertInfo is null.");
                Message message = new Message();
                message.what = 100;
                message.setData(m21821L2("afterVipBeforePurchase(%s)", 1));
                this.f15709r0.sendMessage(message);
                m21842h3();
                return;
            }
            C11060c c11060c = new C11060c();
            c11060c.m66636B("getClientUIConfig");
            c11060c.m66643I(C11058a.m66627b("getClientUIConfig"));
            c11060c.m66637C("com.huawei.hidisk\u0001_cloudspace");
            c11060c.m66670z("2.0");
            C9158a.m57503F().m57505B(this.f15709r0, c11060c, true);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HiCloudBaseWebViewActivity
    /* renamed from: Q1 */
    public void mo20590Q1() {
        super.mo20590Q1();
        C11839m.m70688i(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "initParam:mIsUseMargin," + this.f14911A);
        if (this.f14911A) {
            ((LinearLayout.LayoutParams) this.f14938q.getLayoutParams()).setMargins(100, 10, 100, 0);
        }
        m21826R2();
        m21851q3();
        SafeIntent safeIntent = new SafeIntent(getIntent());
        this.f15697f0 = safeIntent.getBooleanExtra("action_bar_color_hm_os_bg", false);
        this.f15698g0 = safeIntent.getBooleanExtra("actionbar_background", false);
        this.f15694c0 = safeIntent.getStringExtra(RemoteMessageConst.FROM);
        this.f15695d0 = safeIntent.getStringExtra("sceneCode");
        this.f15696e0 = safeIntent.getStringExtra("page_source_type");
        f15689t0 = safeIntent.getStringExtra("user_operation_text");
        f15690u0 = safeIntent.getStringExtra("user_operation_type");
        f15691v0 = safeIntent.getStringExtra("action_type");
        this.f15693b0 = new C10120h(this);
        C1403f.m8066n().m8079M(this.f15693b0);
    }

    /* renamed from: Q2 */
    public void m21825Q2(int i10) {
        if (i10 == 6) {
            C1442a.m8289e(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "handleEstimateCode st is invalid.");
            return;
        }
        if (i10 != 10) {
            if (i10 == 109) {
                Toast.makeText(this, R$string.not_satisfied_rule_tip, 0).show();
                return;
            }
            if (i10 == 123) {
                Toast.makeText(this, getString(R$string.cloudpay_invalid_deduct_amount), 0).show();
                return;
            }
            if (i10 == 1020) {
                C1442a.m8290i(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "handleEstimateCode , server not support demo device");
                Toast.makeText(this, getString(com.huawei.android.p073ds.R$string.cloudpay_demo_device_pay_toast_show), 0).show();
                return;
            } else if (i10 != 16 && i10 != 17) {
                m21857w3(i10);
                return;
            }
        }
        C1442a.m8290i(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "handleEstimateCode release errCode : " + i10);
        Toast.makeText(this, getString(R$string.cloudpay_package_released), 0).show();
    }

    /* renamed from: R2 */
    public final void m21826R2() {
        try {
            String queryParameter = Uri.parse(this.f14947z.toLowerCase(Locale.ENGLISH)).getQueryParameter("darkmode");
            Objects.requireNonNull(queryParameter);
            this.f14934X = Integer.parseInt(queryParameter) != 0;
        } catch (Exception unused) {
            C11839m.m70687e(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "darkMode url not find, set is isSupportDarkMode is true.");
            this.f14934X = true;
        }
    }

    /* renamed from: S2 */
    public void m21827S2() throws IllegalAccessException, JSONException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        mo20590Q1();
        if (!C11829c.m70580h(this.f14947z, this.f14930T) && !this.f14931U) {
            C11839m.m70687e(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "check url host invalid, return");
            super.mo20592U1(C11829c.m70560a0(this.f14947z), Arrays.toString(this.f14930T));
            mo20596f2();
            return;
        }
        m21844j3();
        m21829U2();
        mo20594b2();
        if (this.f14925O) {
            m21855u3(this.f14924N);
        }
        m21818B1();
        if (C0209d.m1154B1(this)) {
            mo20624d2();
            mo20598h2();
        } else {
            mo20595e2();
        }
        new C10151b(this, R.id.content);
        m21845k3(this.f14913C);
    }

    /* renamed from: T2 */
    public void m21828T2(boolean z10) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        C11839m.m70688i(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "initImmersive");
        C11842p.m70710A0(this, z10);
        this.f14939r.m23999a();
        this.f14939r.postDelayed(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.u7
            @Override // java.lang.Runnable
            public final void run() {
                this.f17763a.m21831X2();
            }
        }, 200L);
    }

    /* renamed from: U2 */
    public final void m21829U2() {
        int i10 = this.f14923M;
        if (i10 != 0) {
            if (i10 == 1) {
                this.f14924N = getString(com.huawei.android.p073ds.R$string.cloudpay_renew_success_notify);
                this.f14912B = mo20620X1();
                return;
            }
            if (i10 != 2) {
                if (i10 == 4) {
                    if (TextUtils.isEmpty(this.f14924N)) {
                        this.f14924N = getString(com.huawei.android.p073ds.R$string.backup_notification_title);
                    }
                    this.f14913C = this.f14947z;
                    this.f14912B = mo20620X1();
                    return;
                }
                if (i10 != 5) {
                    if (TextUtils.isEmpty(this.f14924N)) {
                        this.f14924N = getString(com.huawei.android.p073ds.R$string.app_name);
                    }
                    this.f14912B = mo20620X1();
                    return;
                } else {
                    if (TextUtils.isEmpty(this.f14924N)) {
                        this.f14924N = getString(com.huawei.android.p073ds.R$string.app_name);
                    }
                    this.f14913C = this.f14947z;
                    this.f14912B = m20618V1();
                    return;
                }
            }
        }
        if (TextUtils.isEmpty(this.f14924N)) {
            this.f14924N = getString(com.huawei.android.p073ds.R$string.app_name);
        }
        this.f14913C = this.f14947z;
        this.f14912B = m20619W1();
    }

    /* renamed from: V2 */
    public final boolean m21830V2(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains("findDeviceInfo");
    }

    /* renamed from: X2 */
    public final /* synthetic */ void m21831X2() {
        ActionBar actionBar = getActionBar();
        if (actionBar == null || !actionBar.isShowing()) {
            return;
        }
        actionBar.hide();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: Y0 */
    public boolean mo21832Y0() {
        return false;
    }

    /* renamed from: Z2 */
    public final /* synthetic */ void m21834Z2(String str, String str2, String str3, String str4, long j10) {
        C11839m.m70688i(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "onDownloadStart");
        m21795O2(this, str);
    }

    /* renamed from: a3 */
    public final /* synthetic */ void m21835a3() {
        this.f14938q.loadUrl(this.f14912B);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HiCloudBaseWebViewActivity
    /* renamed from: b2 */
    public void mo20594b2() {
        super.mo20594b2();
        mo20593Z1(this.f14938q);
        String[] strArr = this.f14930T;
        if (strArr == null || strArr.length == 0) {
            this.f14938q.setWhitelistWithPath(new String[]{this.f14912B});
        } else {
            this.f14938q.setWhitelist(strArr);
        }
        SafeWebView safeWebView = this.f14938q;
        safeWebView.addJavascriptInterface(new WebViewManager(safeWebView, this.f14930T, this, null, this.f15709r0, this.f15710s0, 4, this), "hidiskOperation");
        this.f14938q.addJavascriptInterface(new C3433e(), "HiOpenObject");
        this.f14938q.addJavascriptInterface(new C3432d(), "checkMore");
        this.f14938q.addJavascriptInterface(new C10778b(this, this.f14938q, this.f14930T, this.f15709r0, this.f14918H, this.f14920J, this.f14921K), "cloudDriveJsInterface");
        this.f14938q.setDownloadListener(new DownloadListener() { // from class: com.huawei.android.hicloud.ui.activity.r7
            @Override // android.webkit.DownloadListener
            public final void onDownloadStart(String str, String str2, String str3, String str4, long j10) {
                this.f17720a.m21834Z2(str, str2, str3, str4, j10);
            }
        });
        this.f14938q.setWebChromeClient(new WebChromeClient() { // from class: com.huawei.android.hicloud.ui.activity.OperationWebViewActivity.3
            private long loadStartTime = 0;

            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i10) {
                super.onProgressChanged(webView, i10);
                if (OperationWebViewActivity.this.mo20613M1()) {
                    C11839m.m70688i(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "onProgressChanged network not ok");
                    this.loadStartTime = 0L;
                    OperationWebViewActivity.this.f15709r0.removeCallbacks(OperationWebViewActivity.this.f15708q0);
                    OperationWebViewActivity.this.f15700i0 = false;
                    C12809f.m76843p(OperationWebViewActivity.this.f14940s, false);
                    OperationWebViewActivity.this.f14938q.clearHistory();
                    return;
                }
                C11839m.m70688i(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "onProgressChanged,progress:" + i10);
                if (i10 != 100) {
                    if (this.loadStartTime == 0) {
                        this.loadStartTime = System.currentTimeMillis();
                        OperationWebViewActivity.this.f15709r0.postDelayed(OperationWebViewActivity.this.f15708q0, OperationWebViewActivity.this.f14917G);
                    }
                    C12809f.m76843p(OperationWebViewActivity.this.f14940s, true);
                    HwProgressBar hwProgressBar = OperationWebViewActivity.this.f14940s;
                    if (hwProgressBar != null) {
                        hwProgressBar.setProgress(i10);
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(OperationWebViewActivity.f15689t0)) {
                    C11839m.m70688i(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "onProgressChanged userOperationText report action :" + OperationWebViewActivity.f15691v0);
                    if (TextUtils.isEmpty(OperationWebViewActivity.f15691v0)) {
                        C12515a.m75110o().m75172d(new C11081g(OperationWebViewActivity.f15689t0, OperationWebViewActivity.f15690u0));
                    } else {
                        C12515a.m75110o().m75172d(new C11081g(OperationWebViewActivity.f15689t0, OperationWebViewActivity.f15690u0, Integer.parseInt(OperationWebViewActivity.f15691v0)));
                    }
                    String unused = OperationWebViewActivity.f15689t0 = "";
                    String unused2 = OperationWebViewActivity.f15690u0 = "";
                }
                this.loadStartTime = 0L;
                OperationWebViewActivity.this.f15709r0.removeCallbacks(OperationWebViewActivity.this.f15708q0);
                OperationWebViewActivity.this.f15700i0 = false;
                C12809f.m76843p(OperationWebViewActivity.this.f14940s, false);
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedTitle(WebView webView, String str) {
                super.onReceivedTitle(webView, str);
                String url = webView.getUrl();
                if (!TextUtils.isEmpty(str) && !URLUtil.isNetworkUrl(str) && !OperationWebViewActivity.this.m21830V2(url)) {
                    OperationWebViewActivity operationWebViewActivity = OperationWebViewActivity.this;
                    if (!operationWebViewActivity.f14925O) {
                        operationWebViewActivity.m21855u3(str);
                        return;
                    }
                }
                OperationWebViewActivity operationWebViewActivity2 = OperationWebViewActivity.this;
                operationWebViewActivity2.m21855u3(operationWebViewActivity2.f14924N);
            }

            @Override // android.webkit.WebChromeClient
            public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
                C11839m.m70688i(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "onShowFileChooser");
                try {
                    OperationWebViewActivity.this.f15692a0 = valueCallback;
                    Intent intent = new Intent("android.intent.action.GET_CONTENT");
                    intent.setType("image/*");
                    intent.addCategory("android.intent.category.OPENABLE");
                    OperationWebViewActivity.this.startActivityForResult(intent, 1);
                    return true;
                } catch (Exception e10) {
                    C11839m.m70687e(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "onShowFileChooser exception: " + e10.toString());
                    return false;
                }
            }
        });
        this.f14938q.m53596e(new C3434f(this, null), false);
        this.f14936Z = C11983e.m72121b().m72122a(this.f14938q);
    }

    /* renamed from: b3 */
    public final void m21836b3(Bundle bundle) {
        if (bundle == null) {
            C11839m.m70688i(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "Bundle data null");
            return;
        }
        String string = bundle.getString("class_name");
        C11839m.m70688i(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "class_name: " + PaymentManagerAndOrderActivity.class.getName());
        if (TextUtils.equals(string, PaymentManagerAndOrderActivity.class.getName()) && (!C11296s.m67787K() || !C11296s.m67789M(this))) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("nav_source", 6);
            bundle2.putString("channel_refer", "2");
            C11272a.m67645e(this, bundle2);
            return;
        }
        bundle.remove("class_name");
        if (string.equals(PaymentManagerAndOrderActivity.class.getName())) {
            string = CouponCenterActivity.class.getName();
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.huawei.hidisk", string));
        String string2 = bundle.getString("nav_source");
        C11839m.m70688i(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "nav_source: " + string2);
        intent.putExtra("nav_source", C0241z.m1685c(string2));
        try {
            startActivity(intent);
        } catch (Exception e10) {
            C11839m.m70688i(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "navToPage Exception:" + e10.getMessage());
        }
    }

    /* renamed from: c3 */
    public void m21837c3() {
        String strM8022o = C1398a.m8022o();
        if (TextUtils.isEmpty(strM8022o)) {
            return;
        }
        if (isFinishing() || isDestroyed() || !C0209d.m1245d1(this, OperationWebViewActivity.class.getName())) {
            C11839m.m70687e(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "isFinishing()");
        } else {
            m20614N1(String.format(Locale.ENGLISH, "%s()", strM8022o));
        }
    }

    /* renamed from: d3 */
    public final void m21838d3() {
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a != null) {
            interfaceC9282a.mo58414c(C0213f.m1377a(), 38);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HiCloudBaseWebViewActivity
    /* renamed from: e2 */
    public void mo20595e2() {
        super.mo20595e2();
        m21846l3();
    }

    /* renamed from: e3 */
    public final void m21839e3(int i10) {
        C11839m.m70688i(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "processReportCampaignDownload: " + i10);
        String strM8019l = C1398a.m8019l();
        if (TextUtils.isEmpty(strM8019l)) {
            return;
        }
        m20614N1(String.format(Locale.ENGLISH, "%s(%d)", strM8019l, Integer.valueOf(i10)));
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HiCloudBaseWebViewActivity
    /* renamed from: f2 */
    public void mo20596f2() {
        super.mo20596f2();
        m21846l3();
    }

    /* renamed from: f3 */
    public final void m21840f3(int i10) {
        if (i10 == 1010) {
            C10797k0.m65694e();
        }
        C11839m.m70688i(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "processReportCampaignLaunch: " + i10);
        String strM8020m = C1398a.m8020m();
        if (TextUtils.isEmpty(strM8020m)) {
            return;
        }
        m20614N1(String.format(Locale.ENGLISH, "%s(%d)", strM8020m, Integer.valueOf(i10)));
    }

    /* renamed from: g3 */
    public void m21841g3() {
        SafeIntent safeIntent = new SafeIntent(getIntent());
        if (safeIntent.getBooleanExtra("refresh_param", false)) {
            ArrayList<String> stringArrayListExtra = safeIntent.getStringArrayListExtra("refresh_param_list");
            ArrayList<String> stringArrayListExtra2 = safeIntent.getStringArrayListExtra("refresh_realtime_param_list");
            if (stringArrayListExtra == null && stringArrayListExtra2 == null) {
                return;
            }
            C11839m.m70688i(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "refresh param before start webview");
            C14157f.m84942g().m84949i(stringArrayListExtra, stringArrayListExtra2, "RefreshParamH5");
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HiCloudBaseWebViewActivity
    /* renamed from: h2 */
    public void mo20598h2() {
        super.mo20598h2();
        if (!C0209d.m1154B1(this)) {
            C11839m.m70687e(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "startLoadWebView network is invalid");
            mo20595e2();
            return;
        }
        if (StringUtil.isBlank(this.f14912B)) {
            C11839m.m70687e(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "startLoadWebView url is invalid.");
            mo20596f2();
            return;
        }
        mo20597g2();
        this.f15701j0 = false;
        this.f14912B = C13206d.m79403c(this.f14912B, "isDarkMode", String.valueOf(C11842p.m70732H0(this)));
        SafeIntent safeIntent = new SafeIntent(getIntent());
        String stringExtra = safeIntent.getStringExtra("userLabel");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.f14912B = C13206d.m79403c(this.f14912B, "userLabel", stringExtra);
        }
        String stringExtra2 = safeIntent.getStringExtra("sceneId");
        if (!TextUtils.isEmpty(stringExtra2)) {
            this.f14912B = C13206d.m79403c(this.f14912B, "sceneId", stringExtra2);
        }
        if (safeIntent.getBooleanExtra("isFormMainPage", false)) {
            this.f14912B = C13206d.m79403c(this.f14912B, "isFormMainPage", String.valueOf(true));
        }
        m21819J2(CommonConstant.ReqAccessTokenParam.LANGUAGE_LABEL);
        m21819J2(FaqConstants.FAQ_EMUI_LANGUAGE);
        this.f15706o0 = System.currentTimeMillis();
        new Handler().postDelayed(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.t7
            @Override // java.lang.Runnable
            public final void run() {
                this.f17743a.m21835a3();
            }
        }, 50L);
        C11839m.m70686d(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "startLoadWebView mUrl = " + this.f14912B);
    }

    /* renamed from: h3 */
    public void m21842h3() {
        Handler handler = this.f15709r0;
        if (handler != null) {
            handler.postDelayed(new RunnableC3431c(), 1000L);
        }
    }

    @Override // com.huawei.android.hicloud.utils.WebViewManager.WebViewManagerCallback
    /* renamed from: i */
    public void mo20599i(boolean z10) {
        C11839m.m70688i(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "setExitFlag = " + z10);
        this.f14928R = z10;
    }

    /* renamed from: i3 */
    public void m21843i3() {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        C11296s.m67807c(this.f15707p0, linkedHashMapM79497A);
        m21820K2(linkedHashMapM79497A);
        C11296s.m67806b0("UNIFORM_CLOUDPAY_ESTIMATE_AOP_DIALOG", linkedHashMapM79497A, "06030");
    }

    /* renamed from: j3 */
    public final void m21844j3() {
        if (this.f14923M == 4) {
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
            linkedHashMap.put("uid", C13452e.m80781L().m80971t0());
            C13227f.m79492i1().m79567R("backup_success_notify_click_record", linkedHashMap);
            UBAAnalyze.m29947H("CKC", "backup_success_notify_click_record", linkedHashMap);
        }
    }

    /* renamed from: k3 */
    public void m21845k3(String str) throws JSONException {
        JSONObject jSONObjectM79482j = C13223b.m79482j(C0213f.m1377a(), "enter_webview_base_info", "1", C13452e.m80781L().m80971t0(), "2");
        try {
            jSONObjectM79482j.put("enter_activity_entranChannel", this.f14915E);
            jSONObjectM79482j.put("enter_activity_salChannel", this.f14919I);
            jSONObjectM79482j.put("enter_activity_srcChannel", this.f14918H);
            jSONObjectM79482j.put("enter_activity_entran_activityCode", this.f14920J);
            jSONObjectM79482j.put("launch_webview_type", this.f14923M);
            jSONObjectM79482j.put("webview_load_url", this.f14912B);
            if (!TextUtils.isEmpty(str)) {
                jSONObjectM79482j.put("webview_launched_url", str);
            }
            jSONObjectM79482j.put("enter_activity_entranChannel", this.f14915E);
        } catch (JSONException e10) {
            C11839m.m70687e(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "reportEvent exception:" + e10.getMessage());
        }
        LinkedHashMap<String, String> linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
        linkedHashMapM79499C.put("enter_activity_entranChannel", this.f14915E);
        linkedHashMapM79499C.put("enter_activity_salChannel", this.f14919I);
        linkedHashMapM79499C.put("enter_activity_srcChannel", this.f14918H);
        linkedHashMapM79499C.put("enter_activity_entran_activityCode", this.f14920J);
        linkedHashMapM79499C.put("launch_webview_type", String.valueOf(this.f14923M));
        linkedHashMapM79499C.put("webview_load_url", this.f14912B);
        if (!TextUtils.isEmpty(str)) {
            linkedHashMapM79499C.put("webview_launched_url", str);
        }
        linkedHashMapM79499C.put("enter_activity_entranChannel", this.f14915E);
        C13227f.m79492i1().m79602z(jSONObjectM79482j);
        C13227f.m79492i1().m79567R("enter_webview_base_info", linkedHashMapM79499C);
        UBAAnalyze.m29963X("PVC", "enter_webview_base_info", "3", "47", jSONObjectM79482j);
        C11839m.m70688i(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "reportBiEvent, locale language is:" + Locale.getDefault().getLanguage() + ", local script : " + Locale.getDefault().getScript() + ", local country : " + Locale.getDefault().getCountry());
        C11273b.m67661p(this, "enter_webview_base_info", linkedHashMapM79499C);
    }

    /* renamed from: l3 */
    public final void m21846l3() {
        if (!"campaign_center".equals(this.f15694c0)) {
            C11839m.m70686d(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "not from campaign");
            return;
        }
        if (this.f15699h0) {
            C11839m.m70688i(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "has report");
            return;
        }
        if (this.f15701j0) {
            C11839m.m70688i(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "load url error");
            return;
        }
        if (C12809f.m76836i(this.f14941t) || C12809f.m76836i(this.f14943v) || C12809f.m76836i(this.f14945x)) {
            C11839m.m70688i(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "load error");
            C12998f.m78034R().m78128u(C12997e.m78019l(), null, true);
            return;
        }
        this.f15699h0 = true;
        C12998f.m78034R().m78126t(C12997e.m78019l(), null, false);
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        C13227f.m79492i1().m79567R("ENTER_CLOUD_ST0RAGE_MANAGEMENT", linkedHashMapM79497A);
        UBAAnalyze.m29947H("CKC", "ENTER_CLOUD_ST0RAGE_MANAGEMENT", linkedHashMapM79497A);
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b(""), NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("010_200");
        C13622a.m81969o(this, c11060cM66626a, linkedHashMapM79497A);
    }

    /* renamed from: m3 */
    public void m21847m3() {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        C11296s.m67807c(this.f15707p0, linkedHashMapM79497A);
        m21820K2(linkedHashMapM79497A);
        C11296s.m67806b0("UNIFORM_CLOUDPAY_UPGRADE_CLICK_ESTIMAE_NAGATIVE_BTN", linkedHashMapM79497A, "06030");
    }

    /* renamed from: n3 */
    public void m21848n3() {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        C11296s.m67807c(this.f15707p0, linkedHashMapM79497A);
        m21820K2(linkedHashMapM79497A);
        C11296s.m67806b0("UNIFORM_CLOUDPAY_UPGRADE_CLICK_ESTIMAE_POSITIVE_BTN", linkedHashMapM79497A, "06030");
    }

    /* renamed from: o3 */
    public final void m21849o3() {
        RestoreUtil.reportSourceFromNotification(getIntent(), "78");
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HMSTermsProcessBaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        C11839m.m70688i(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "onActivityResult resultCode: " + i11);
        try {
            if (i10 == 1) {
                Uri data = (intent == null || i11 != -1) ? null : intent.getData();
                if (this.f15692a0 != null) {
                    if (data == null || !C11829c.m70544S0(data)) {
                        this.f15692a0.onReceiveValue(null);
                    } else {
                        this.f15692a0.onReceiveValue(new Uri[]{data});
                    }
                    this.f15692a0 = null;
                    return;
                }
                return;
            }
            if (i10 == 2) {
                if (intent != null && i11 == -1) {
                    C11839m.m70688i(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "address kit resultCode is equals OK");
                    m21853s3(new Gson().toJson(new H5UserAddress(UserAddress.parseIntent(intent))));
                    return;
                } else if (intent == null && i11 == -1) {
                    C11839m.m70688i(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "address kit data is null");
                    m21852r3();
                    return;
                } else {
                    C11839m.m70688i(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "address kit resultCode is not equals OK");
                    m21853s3(String.valueOf(i11));
                    return;
                }
            }
            if (1000 == i10) {
                if (i11 == -1) {
                    this.f15693b0.m63025m();
                    return;
                }
                return;
            }
            if (1002 == i10) {
                C1403f.m8066n().m8073G();
                return;
            }
            if (10018 == i10) {
                Message message = new Message();
                message.what = 100;
                String stringExtra = new HiCloudSafeIntent(intent).getStringExtra("renew_call_back_scene");
                if (TextUtils.isEmpty(stringExtra)) {
                    C11839m.m70687e(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "callDataScene is empty");
                    return;
                }
                C11839m.m70688i(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "onActivityResult callDataScene = " + stringExtra + ", requestCode =" + i10 + ", resultCode = " + i11);
                if ("conversion".equals(stringExtra)) {
                    if (i11 == -1) {
                        message.setData(m21821L2("afterVipBeforePurchase(%s)", 1));
                    } else {
                        message.setData(m21821L2("afterVipBeforePurchase(%s)", 0));
                    }
                    this.f15709r0.sendMessage(message);
                    return;
                }
                if (!"pay_result".equals(stringExtra)) {
                    C11839m.m70687e(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "invalid callDataScene");
                    return;
                }
                if (i11 == -1) {
                    message.setData(m21821L2("afterVipPurchase(%s)", 1));
                } else {
                    message.setData(m21821L2("afterVipPurchase(%s)", 0));
                }
                this.f15709r0.sendMessage(message);
                m21842h3();
            }
        } catch (Exception e10) {
            C11839m.m70688i(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "onActivityResult exception" + e10);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HiCloudBaseWebViewActivity, android.app.Activity
    public void onBackPressed() {
        C11839m.m70688i(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "onBackPressed exitFlag = " + this.f14928R);
        if (this.f14928R) {
            m20615O1();
        } else {
            m21850p3();
            super.onBackPressed();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HiCloudBaseWebViewActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.onConfigurationChanged(configuration);
        C11842p.m70874v1(this, this.f14946y);
        C11842p.m70760Q1(this, this.f14943v);
        if (this.f15698g0) {
            m21854t3();
            C11842p.m70710A0(this, C11842p.m70732H0(this));
        }
        m21851q3();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HiCloudBaseWebViewActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, JSONException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        m29138V0();
        super.onCreate(bundle);
        C11839m.m70688i(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "onCreate");
        boolean zMo20591S1 = mo20591S1();
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(R$color.emui_color_bg);
        }
        SafeWebView safeWebView = this.f14938q;
        if (safeWebView != null) {
            safeWebView.setBackgroundColor(getResources().getColor(R$color.transparent));
        }
        m21841g3();
        C1398a.m8005E(this);
        C1398a.m8006F(this.f15709r0);
        C1403f.m8066n().m8080N(this.f15709r0);
        if (zMo20591S1) {
            m21827S2();
            if ("33".equals(new HiCloudSafeIntent(new SafeIntent(getIntent())).getStringExtra("sceneCode")) && !C13452e.m80781L().m80791C0()) {
                m21838d3();
            }
            C13227f.m79492i1().m79598v0(this, new SafeIntent(getIntent()), NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY);
            m21849o3();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HiCloudBaseWebViewActivity, com.huawei.android.hicloud.p088ui.activity.BaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ValueCallback<Uri[]> valueCallback = this.f15692a0;
        if (valueCallback != null) {
            valueCallback.onReceiveValue(null);
            this.f15692a0 = null;
        }
        C10120h c10120h = this.f15693b0;
        if (c10120h != null) {
            c10120h.m63017B();
            this.f15693b0.m63026n();
        }
        C1403f.m8066n().m8088e();
        ConfirmBuyPackageDialog confirmBuyPackageDialog = this.f15702k0;
        if (confirmBuyPackageDialog != null) {
            confirmBuyPackageDialog.dismiss();
            this.f15702k0 = null;
        }
        PayResultErrorDialog payResultErrorDialog = this.f15704m0;
        if (payResultErrorDialog != null) {
            payResultErrorDialog.dismiss();
            this.f15704m0 = null;
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HiCloudBaseWebViewActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onNewIntent(Intent intent) throws IllegalAccessException, JSONException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.onNewIntent(intent);
        C11839m.m70688i(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "onNewIntent");
        setIntent(intent);
        this.f14928R = false;
        m21827S2();
        if (!this.f15698g0) {
            C11842p.m70736I1(this.f14940s, 0);
            getWindow().clearFlags(1024);
            getWindow().getDecorView().setSystemUiVisibility(9232);
        }
        C13227f.m79492i1().m79598v0(this, new SafeIntent(getIntent()), NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY);
        new C13149f().m79065c(this, getIntent(), C13222a.m79465g(this));
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HiCloudBaseWebViewActivity, com.huawei.android.hicloud.p088ui.activity.BaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            m21850p3();
            if (this.f14928R) {
                m20615O1();
                return true;
            }
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
        m21837c3();
        super.onResume();
    }

    /* renamed from: p3 */
    public final void m21850p3() {
        if (this.f15706o0 == 0) {
            C11839m.m70688i(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "startTime null");
            return;
        }
        if (TextUtils.isEmpty(this.f14912B)) {
            C11839m.m70688i(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "mUrl null ");
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - this.f15706o0;
        String strM63704b = C10344c.m63704b(Uri.parse(this.f14912B), "fromH5");
        C11839m.m70688i(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "getQueryParameter: " + strM63704b);
        if (TextUtils.equals(strM63704b, FaqConstants.DISABLE_HA_REPORT)) {
            LinkedHashMap linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
            linkedHashMapM79499C.put("page_time", Long.valueOf(jCurrentTimeMillis));
            linkedHashMapM79499C.put("page_url", this.f14912B);
            C13227f.m79492i1().m79591l0("h5_page_time", linkedHashMapM79499C);
            UBAAnalyze.m29958S("PVC", "h5_page_time", "3", "47", linkedHashMapM79499C);
        }
    }

    /* renamed from: q3 */
    public final void m21851q3() {
        if (isInMultiWindowMode()) {
            C11842p.m70736I1(this.f14939r, C11842p.m70852q(this));
            return;
        }
        if (C11842p.m70771U0() || !C11842p.m70753O0(this)) {
            getWindow().clearFlags(1024);
            C11842p.m70736I1(this.f14939r, C11842p.m70789a0(this) + C11842p.m70852q(this));
        } else {
            getWindow().addFlags(1024);
            C11842p.m70736I1(this.f14939r, C11842p.m70852q(this));
        }
    }

    /* renamed from: r3 */
    public void m21852r3() {
        m21853s3(null);
    }

    /* renamed from: s3 */
    public final void m21853s3(String str) {
        String strM8016i = C1398a.m8016i();
        if (TextUtils.isEmpty(strM8016i)) {
            C11839m.m70687e(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "address callback is null");
        } else {
            m20614N1(String.format(Locale.ENGLISH, "%s(%s)", strM8016i, str));
        }
    }

    /* renamed from: t3 */
    public void m21854t3() throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (getActionBar() != null) {
            Window window = getWindow();
            if (window != null) {
                window.setStatusBarColor(getColor(com.huawei.hicloud.sync.R$color.pay_activity_harmony_bg));
            }
            ActionBar actionBar = getActionBar();
            int i10 = R$color.pay_activity_harmony_bg;
            C11842p.m70842n1(actionBar, new ColorDrawable(getColor(i10)));
            getActionBar().setBackgroundDrawable(new ColorDrawable(getColor(i10)));
        }
    }

    /* renamed from: u3 */
    public void m21855u3(String str) {
        ActionBar actionBar = getActionBar();
        if (actionBar == null) {
            C11839m.m70687e(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "getActionBar is empty");
            return;
        }
        if (TextUtils.isEmpty(str) || this.f14912B.contains(str)) {
            str = getString(com.huawei.android.p073ds.R$string.app_name);
        }
        if (!TextUtils.isEmpty(this.f14935Y)) {
            m20621Y1(actionBar);
        }
        actionBar.setTitle(str);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: v1 */
    public boolean mo13429v1(int i10, KeyEvent keyEvent) {
        setResult(-1);
        return super.mo13429v1(i10, keyEvent);
    }

    /* renamed from: v3 */
    public void m21856v3(String str) {
        this.f15707p0 = str;
    }

    /* renamed from: w3 */
    public final void m21857w3(int i10) {
        if (isFinishing()) {
            C1442a.m8291w(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "showErrDialog , Activity is Finishing.");
            return;
        }
        PayResultErrorDialog payResultErrorDialog = this.f15704m0;
        if (payResultErrorDialog != null && payResultErrorDialog.isShowing()) {
            this.f15704m0.dismiss();
        }
        this.f15704m0 = null;
        PayResultErrorDialog payResultErrorDialog2 = new PayResultErrorDialog(this, true);
        this.f15704m0 = payResultErrorDialog2;
        payResultErrorDialog2.show(i10);
    }

    /* renamed from: x3, reason: merged with bridge method [inline-methods] */
    public final void m21833Y2() {
        C11839m.m70689w(NotifyConstants.ActivityName.OPERATION_WEBVIEW_ACTIVITY, "onProgressChanged timeout!");
        this.f14938q.stopLoading();
        mo20595e2();
        this.f14942u.setText(getString(com.huawei.android.p073ds.R$string.net_not_avaliable_retry));
    }
}
