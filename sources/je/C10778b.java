package je;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Toast;
import ck.C1443a;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.android.backup.service.logic.C2126b;
import com.huawei.android.hicloud.bean.aop.AppInfo;
import com.huawei.android.hicloud.bean.aop.AppParams;
import com.huawei.android.hicloud.bean.aop.ExtParams;
import com.huawei.android.hicloud.bean.aop.MaintEventReq;
import com.huawei.android.hicloud.bean.aop.PluginResult;
import com.huawei.android.hicloud.bean.aop.ReportArgsStr;
import com.huawei.android.hicloud.bean.aop.SyncPluginResult;
import com.huawei.android.hicloud.bean.aop.ToastArgsString;
import com.huawei.android.hicloud.bean.aop.UserTokenErrRsp;
import com.huawei.android.hicloud.bean.aop.UserTokenResp;
import com.huawei.android.hicloud.p088ui.activity.OperationWebViewActivity;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.CardNumConfirmActivity;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.CloudSpaceUpgradeForSpaceShareActivity;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.ExtendWebviewActivity;
import com.huawei.hicloud.notify.R$string;
import com.huawei.hms.identity.AddressConstants;
import com.huawei.secure.android.common.intent.SafeIntent;
import dj.C9158a;
import hu.C10344c;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import mu.C11524a;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0234s;
import p429kk.C11058a;
import p429kk.C11060c;
import p454lj.C11296s;
import p514o9.C11829c;
import p514o9.C11839m;
import p681uj.C13195l;
import p709vj.C13452e;
import p807yd.C13946b;
import uk.C13206d;

/* renamed from: je.b */
/* loaded from: classes3.dex */
public class C10778b extends C11524a {

    /* renamed from: j */
    public static final Gson f51514j = new Gson();

    /* renamed from: c */
    public Context f51515c;

    /* renamed from: d */
    public final String[] f51516d;

    /* renamed from: e */
    public final C10797k0 f51517e;

    /* renamed from: f */
    public final Handler f51518f;

    /* renamed from: g */
    public String f51519g;

    /* renamed from: h */
    public String f51520h;

    /* renamed from: i */
    public int f51521i;

    public C10778b(Context context, WebView webView, String[] strArr, Handler handler, String str, String str2, int i10) {
        super(webView);
        this.f51519g = "";
        this.f51520h = "";
        this.f51521i = -1;
        this.f51516d = strArr;
        this.f51517e = new C10797k0(C11058a.m66627b("07030"));
        this.f51518f = handler;
        this.f51515c = context;
        this.f51519g = str;
        this.f51520h = str2;
        this.f51521i = i10;
    }

    @JavascriptInterface
    public String checkLogin() throws InterruptedException {
        SyncPluginResult syncPluginResult = new SyncPluginResult();
        String strM68794b = m68794b();
        if (C11829c.m70583i(strM68794b, this.f51516d, "checkLogin")) {
            syncPluginResult.setStatus(1);
            syncPluginResult.setResult("");
            return m65621g(syncPluginResult);
        }
        C11839m.m70687e("AopJSInterface", "checkLogin, url is invalid");
        this.f51517e.m65707p(C11829c.m70560a0(strM68794b), Arrays.toString(this.f51516d));
        syncPluginResult.setStatus(0);
        return m65621g(syncPluginResult);
    }

    /* renamed from: e */
    public String m65619e() {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) C0213f.m1377a().getSystemService("connectivity");
        return (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) ? "" : activeNetworkInfo.getType() == 1 ? "WLAN" : activeNetworkInfo.getType() == 0 ? "MOBILE" : "";
    }

    /* renamed from: f */
    public final void m65620f(String str, String str2) {
        if (this.f51518f == null) {
            C11839m.m70687e("AopJSInterface", "jsCallBack, mHandler == null.");
            return;
        }
        C11839m.m70688i("AopJSInterface", "jsCallBack, sendMessage action = " + str);
        Message message = new Message();
        message.what = 100;
        Bundle bundle = new Bundle();
        bundle.putString("javascript", String.format(Locale.ENGLISH, "doCloudDriveCallback('%s','%s')", str, str2));
        message.setData(bundle);
        this.f51518f.sendMessage(message);
    }

    /* renamed from: g */
    public final String m65621g(Object obj) {
        try {
            return f51514j.toJson(obj);
        } catch (Exception e10) {
            C11839m.m70687e("AopJSInterface", "objectToString err: " + e10.getMessage());
            return "";
        }
    }

    @JavascriptInterface
    public String getAppInfo() throws InterruptedException {
        SyncPluginResult syncPluginResult = new SyncPluginResult();
        String strM68794b = m68794b();
        if (!C11829c.m70583i(strM68794b, this.f51516d, "getAppInfo")) {
            C11839m.m70687e("AopJSInterface", "getAppInfo, url is invalid");
            this.f51517e.m65707p(C11829c.m70560a0(strM68794b), Arrays.toString(this.f51516d));
            syncPluginResult.setStatus(0);
            return m65621g(syncPluginResult);
        }
        AppInfo appInfo = new AppInfo();
        appInfo.setBundleName("com.huawei.hidisk");
        appInfo.setAppVersionCode(C1443a.f6213a);
        appInfo.setAppVersionName("16.0.0.300");
        syncPluginResult.setStatus(1);
        syncPluginResult.setResult(appInfo);
        return m65621g(syncPluginResult);
    }

    @JavascriptInterface
    public String getExtParams() throws InterruptedException {
        SyncPluginResult syncPluginResult = new SyncPluginResult();
        String strM68794b = m68794b();
        if (!C11829c.m70583i(strM68794b, this.f51516d, "getExtParams")) {
            C11839m.m70687e("AopJSInterface", "getExtParams, url is invalid");
            this.f51517e.m65707p(C11829c.m70560a0(strM68794b), Arrays.toString(this.f51516d));
            syncPluginResult.setStatus(0);
            return m65621g(syncPluginResult);
        }
        ExtParams extParams = new ExtParams();
        extParams.setDeviceId(C13452e.m80781L().m80954p());
        extParams.setDeviceIdType(C13452e.m80781L().m80970t());
        extParams.setMinorModel(C13452e.m80781L().m80910f());
        syncPluginResult.setStatus(1);
        syncPluginResult.setResult(extParams);
        return m65621g(syncPluginResult);
    }

    @JavascriptInterface
    public String getParams() throws InterruptedException {
        C11839m.m70688i("AopJSInterface", "getParams start");
        SyncPluginResult syncPluginResult = new SyncPluginResult();
        String strM68794b = m68794b();
        if (!C11829c.m70583i(strM68794b, this.f51516d, "getParams")) {
            C11839m.m70687e("AopJSInterface", "getParams, url is invalid");
            this.f51517e.m65707p(C11829c.m70560a0(strM68794b), Arrays.toString(this.f51516d));
            syncPluginResult.setStatus(0);
            return m65621g(syncPluginResult);
        }
        try {
            AppParams appParams = new AppParams();
            appParams.setDeviceType(Integer.parseInt(C13452e.m80781L().m80970t()));
            appParams.setDeviceModel(Build.MODEL);
            appParams.setCountry(C13452e.m80781L().m80942m());
            appParams.setLang(C0234s.m1631i());
            appParams.setOsVersion(C0209d.m1149A0());
            appParams.setOsName("HarmonyOS");
            appParams.setRomVersion(C0209d.m1315v());
            appParams.setNetworkingMode(m65619e());
            syncPluginResult.setStatus(1);
            syncPluginResult.setResult(appParams);
        } catch (Exception e10) {
            C11839m.m70687e("AopJSInterface", "getParams err: " + e10.getMessage());
            syncPluginResult.setStatus(0);
        }
        return m65621g(syncPluginResult);
    }

    @JavascriptInterface
    public String getTraceId() throws InterruptedException {
        SyncPluginResult syncPluginResult = new SyncPluginResult();
        String strM68794b = m68794b();
        if (C11829c.m70583i(strM68794b, this.f51516d, "getTraceId")) {
            syncPluginResult.setStatus(1);
            syncPluginResult.setResult(C11058a.m66627b("aop"));
            return m65621g(syncPluginResult);
        }
        C11839m.m70687e("AopJSInterface", "getTraceId, url is invalid");
        this.f51517e.m65707p(C11829c.m70560a0(strM68794b), Arrays.toString(this.f51516d));
        syncPluginResult.setStatus(0);
        return m65621g(syncPluginResult);
    }

    @JavascriptInterface
    public String getUserId() throws InterruptedException {
        SyncPluginResult syncPluginResult = new SyncPluginResult();
        String strM68794b = m68794b();
        if (C11829c.m70583i(strM68794b, this.f51516d, "getUserId")) {
            syncPluginResult.setStatus(1);
            syncPluginResult.setResult(C13452e.m80781L().m80971t0());
            return m65621g(syncPluginResult);
        }
        C11839m.m70687e("AopJSInterface", "getUserId, url is invalid");
        this.f51517e.m65707p(C11829c.m70560a0(strM68794b), Arrays.toString(this.f51516d));
        syncPluginResult.setStatus(0);
        return m65621g(syncPluginResult);
    }

    @JavascriptInterface
    public void getUserToken(String str, String str2) throws InterruptedException {
        C11839m.m70688i("AopJSInterface", "getUserToken start.");
        String strM68794b = m68794b();
        if (!C11829c.m70583i(strM68794b, this.f51516d, "getUserToken")) {
            C11839m.m70687e("AopJSInterface", "getUserToken, url is invalid");
            this.f51517e.m65707p(C11829c.m70560a0(strM68794b), Arrays.toString(this.f51516d));
            UserTokenErrRsp userTokenErrRsp = new UserTokenErrRsp();
            userTokenErrRsp.setErrorCode(0);
            m65620f(str, m65621g(userTokenErrRsp));
            return;
        }
        try {
            String strM79344y = C13195l.m79272J().m79344y("Business", "aop");
            UserTokenResp userTokenResp = new UserTokenResp();
            userTokenResp.setUserToken(strM79344y);
            userTokenResp.setType(0);
            PluginResult pluginResult = new PluginResult();
            pluginResult.setCode(1);
            pluginResult.setMessage(userTokenResp);
            m65620f(str, m65621g(pluginResult));
        } catch (Exception e10) {
            C11839m.m70687e("AopJSInterface", "getUserToken err : " + e10.getMessage());
            UserTokenErrRsp userTokenErrRsp2 = new UserTokenErrRsp();
            userTokenErrRsp2.setErrorCode(0);
            m65620f(str, m65621g(userTokenErrRsp2));
        }
    }

    @JavascriptInterface
    public void openDeepLink(String str) throws InterruptedException {
        C11839m.m70688i("AopJSInterface", "openDeepLink start = " + str);
        String strM68794b = m68794b();
        if (!C11829c.m70583i(strM68794b, this.f51516d, "openLink")) {
            C11839m.m70687e("AopJSInterface", "openDeepLink, url is invalid");
            this.f51517e.m65707p(C11829c.m70560a0(strM68794b), Arrays.toString(this.f51516d));
            return;
        }
        Uri uri = Uri.parse(str);
        String strM63704b = C10344c.m63704b(uri, "enter");
        if (TextUtils.isEmpty(strM63704b) || !strM63704b.equals("HuaweiCard")) {
            Intent intent = new Intent();
            intent.setData(uri);
            C13946b.m83729e().m83752W(this.f51515c, new SafeIntent(intent));
            C11839m.m70688i("AopJSInterface", "openDeepLink end");
            return;
        }
        try {
            Intent intent2 = new Intent(this.f51515c, (Class<?>) CardNumConfirmActivity.class);
            intent2.putExtra("from_where", 4);
            ((Activity) this.f51515c).startActivityForResult(intent2, 10004);
        } catch (Exception e10) {
            C11839m.m70687e("AopJSInterface", "openDeepLink err : " + e10.getMessage());
        }
    }

    @JavascriptInterface
    public void openLink(String str) throws InterruptedException {
        C11839m.m70688i("AopJSInterface", "openLink start");
        String strM68794b = m68794b();
        if (!C11829c.m70583i(strM68794b, this.f51516d, "openLink")) {
            C11839m.m70687e("AopJSInterface", "openLink, url is invalid");
            this.f51517e.m65707p(C11829c.m70560a0(strM68794b), Arrays.toString(this.f51516d));
            return;
        }
        Context context = this.f51515c;
        if (context == null) {
            C11839m.m70687e("AopJSInterface", "openLink mContext is null");
            return;
        }
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent(this.f51515c, (Class<?>) ExtendWebviewActivity.class);
        intent.putExtra("channel_refer", "2");
        intent.putExtra("nav_source", 0);
        intent.putExtra("is_activity_need_back_to_main", false);
        intent.putExtra("url", C13206d.m79403c(str, "actionbar", String.valueOf(1)));
        intent.putExtra("is_support_orientation", true);
        intent.putExtra("isEnableJs", true);
        intent.putExtra("launch_web_type", 9);
        C0209d.m1302r2(intent, "com.huawei.hidisk");
        intent.putExtra("is_support_dark_mode", true);
        intent.putExtra("actionbar_background", false);
        intent.putExtra("title_priority", true);
        intent.putExtra("title", this.f51515c.getString(R$string.HiCloud_app_name));
        if (intent.resolveActivity(packageManager) != null) {
            C11839m.m70688i("AopJSInterface", "openLink success p");
            this.f51515c.startActivity(intent);
            return;
        }
        Intent intent2 = new Intent("android.intent.action.VIEW");
        intent2.setData(Uri.parse(strM68794b));
        if (intent2.resolveActivity(packageManager) == null) {
            C11839m.m70687e("AopJSInterface", "openLink open default err.");
        } else {
            C11839m.m70688i("AopJSInterface", "openLink success b");
            this.f51515c.startActivity(intent2);
        }
    }

    @JavascriptInterface
    public void reportEvent(String str, String str2) throws InterruptedException {
        String strM68794b = m68794b();
        if (!C11829c.m70583i(strM68794b, this.f51516d, "reportEvent")) {
            C11839m.m70687e("AopJSInterface", "reportEvent, url is invalid");
            this.f51517e.m65707p(C11829c.m70560a0(strM68794b), Arrays.toString(this.f51516d));
            return;
        }
        try {
            MaintEventReq eventReq = ((ReportArgsStr) new Gson().fromJson(str2, ReportArgsStr.class)).getEventReq();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("activityId", eventReq.getActivityId());
            linkedHashMap.put(AddressConstants.Extras.EXTRA_NAME_ERR_CODE, String.valueOf(eventReq.getErrorCode()));
            linkedHashMap.put(C2126b.ERROR_MESSAGE_INFO, eventReq.getErrorMsg());
            linkedHashMap.put("businessTraceId", eventReq.getBusinessTraceId());
            linkedHashMap.put("eventExt", eventReq.getEventExt());
            C11296s.m67806b0(eventReq.getEventId(), linkedHashMap, "06030");
        } catch (JsonSyntaxException e10) {
            C11839m.m70687e("AopJSInterface", "reportEvent err: " + e10.getMessage());
        }
    }

    @JavascriptInterface
    public String showToast(String str) throws InterruptedException {
        SyncPluginResult syncPluginResult = new SyncPluginResult();
        String strM68794b = m68794b();
        if (!C11829c.m70583i(strM68794b, this.f51516d, "showToast")) {
            C11839m.m70687e("AopJSInterface", "showToast, url is invalid");
            this.f51517e.m65707p(C11829c.m70560a0(strM68794b), Arrays.toString(this.f51516d));
            syncPluginResult.setStatus(0);
            syncPluginResult.setResult(" fail");
            return m65621g(syncPluginResult);
        }
        try {
            ToastArgsString toastArgsString = (ToastArgsString) new Gson().fromJson(str, ToastArgsString.class);
            Toast.makeText(C0213f.m1377a(), toastArgsString.getMessage(), toastArgsString.getDuration() > 2000 ? 1 : 0).show();
            syncPluginResult.setStatus(1);
            syncPluginResult.setResult("success");
        } catch (JsonSyntaxException e10) {
            C11839m.m70687e("AopJSInterface", "showToast err: " + e10.getMessage());
            syncPluginResult.setResult("fail");
            syncPluginResult.setStatus(0);
        }
        return m65621g(syncPluginResult);
    }

    @JavascriptInterface
    public void vipBeforePurchase(String str) throws InterruptedException {
        if (!C11296s.m67786J(this.f51515c)) {
            Toast.makeText(this.f51515c, com.huawei.android.p073ds.R$string.cloudpay_net_disconnect_alert, 1).show();
            return;
        }
        String strM68794b = m68794b();
        if (!C11829c.m70583i(strM68794b, this.f51516d, "vipPurchase")) {
            C11839m.m70687e("AopJSInterface", "vipPurchase, url is invalid");
            this.f51517e.m65707p(C11829c.m70560a0(strM68794b), Arrays.toString(this.f51516d));
            return;
        }
        Context context = this.f51515c;
        if (context instanceof OperationWebViewActivity) {
            ((OperationWebViewActivity) context).m21856v3(str);
        }
        C11060c c11060c = new C11060c();
        c11060c.m66636B("estimatePackage");
        c11060c.m66643I(C11058a.m66627b("estimatePackage"));
        c11060c.m66637C("com.huawei.hidisk\u0001_cloudspace");
        c11060c.m66670z("2.0");
        HashMap map = new HashMap();
        map.put("aopInfo", str);
        C9158a.m57503F().m57550o(this.f51518f, c11060c, true, map);
    }

    @JavascriptInterface
    public void vipPurchase(String str, String str2) throws InterruptedException {
        C11839m.m70688i("AopJSInterface", "vipPurchase action = " + str);
        if (!C11296s.m67786J(this.f51515c)) {
            Toast.makeText(this.f51515c, com.huawei.android.p073ds.R$string.cloudpay_net_disconnect_alert, 1).show();
            return;
        }
        String strM68794b = m68794b();
        if (!C11829c.m70583i(strM68794b, this.f51516d, "vipPurchase")) {
            C11839m.m70687e("AopJSInterface", "vipPurchase, url is invalid");
            this.f51517e.m65707p(C11829c.m70560a0(strM68794b), Arrays.toString(this.f51516d));
            UserTokenErrRsp userTokenErrRsp = new UserTokenErrRsp();
            userTokenErrRsp.setErrorCode(0);
            m65620f(str, m65621g(userTokenErrRsp));
            return;
        }
        try {
            Intent intent = new Intent();
            intent.setClass(this.f51515c, CloudSpaceUpgradeForSpaceShareActivity.class);
            intent.putExtra("from_where", 22);
            intent.putExtra("aop_info", str2);
            if (!TextUtils.isEmpty(this.f51519g)) {
                intent.putExtra("srcChannel", this.f51519g);
            }
            if (!TextUtils.isEmpty(this.f51520h)) {
                intent.putExtra("activityCode", this.f51520h);
            }
            intent.putExtra("aop_from_where", this.f51521i);
            ((Activity) this.f51515c).startActivityForResult(intent, 10018);
        } catch (Exception e10) {
            C11839m.m70687e("AopJSInterface", "vipPurchase err: " + e10.getMessage());
        }
    }
}
