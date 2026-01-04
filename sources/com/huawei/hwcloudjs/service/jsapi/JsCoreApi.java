package com.huawei.hwcloudjs.service.jsapi;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.webkit.WebView;
import android.widget.Toast;
import com.huawei.hms.framework.network.restclient.dnkeeper.InterfaceC5483d;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import com.huawei.hwcloudjs.C6613R;
import com.huawei.hwcloudjs.JsClientApi;
import com.huawei.hwcloudjs.annotation.JSClassAttributes;
import com.huawei.hwcloudjs.annotation.JSField;
import com.huawei.hwcloudjs.annotation.JSMethod;
import com.huawei.hwcloudjs.annotation.JSNativeMsg;
import com.huawei.hwcloudjs.core.JSRequest;
import com.huawei.hwcloudjs.core.JsCallback;
import com.huawei.hwcloudjs.core.p153a.C6623b;
import com.huawei.hwcloudjs.p160e.p161a.C6651e;
import com.huawei.hwcloudjs.p164f.C6657b;
import com.huawei.hwcloudjs.p164f.C6659d;
import com.huawei.hwcloudjs.p164f.C6661f;
import com.huawei.hwcloudjs.p164f.C6663h;
import com.huawei.hwcloudjs.service.jsmsg.C6692a;
import com.huawei.hwcloudjs.service.jsmsg.NativeMsg;
import com.huawei.hwcloudjs.support.enables.NoProguard;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@JSClassAttributes
/* loaded from: classes8.dex */
public class JsCoreApi extends JSRequest {

    /* renamed from: b */
    private static final String f31019b = "JsCoreApi";

    @JSNativeMsg(isOpen = true, permission = JsClientApi.Permission.BASE, type = "channelMessage")
    @NoProguard
    public static final class ChannelMessageReq extends NativeMsg {

        @JSField("channelName")
        private String channelName;

        @JSField("data")
        private String data;

        @JSField("origin")
        private String origin;

        @JSField("source")
        private String source;

        public String getChannelName() {
            return this.channelName;
        }

        public String getData() {
            return this.data;
        }

        public String getOrigin() {
            return this.origin;
        }

        public String getSource() {
            return this.source;
        }

        public void setChannelName(String str) {
            this.channelName = str;
        }

        public void setData(String str) {
            this.data = str;
        }

        public void setOrigin(String str) {
            this.origin = str;
        }

        public void setSource(String str) {
            this.source = str;
        }
    }

    @NoProguard
    public static final class CheckAvailReq {
        private List<String> apiList;

        public List<String> getApiList() {
            return this.apiList;
        }

        public void setApiList(List<String> list) {
            this.apiList = list;
        }
    }

    @NoProguard
    public static final class DialogReq {
        private List<String> buttons;
        private String message;
        private String title;

        public List<String> getButtons() {
            return this.buttons;
        }

        public String getMessage() {
            return this.message;
        }

        public String getTitle() {
            return this.title;
        }

        public void setButtons(List<String> list) {
            this.buttons = list;
        }

        public void setMessage(String str) {
            this.message = str;
        }

        public void setTitle(String str) {
            this.title = str;
        }
    }

    @NoProguard
    public static final class PreloadReq {
        private int flag;
        private List<String> urlList;

        public int getFlag() {
            return this.flag;
        }

        public List<String> getUrlList() {
            return this.urlList;
        }

        public void setFlag(int i10) {
            this.flag = i10;
        }

        public void setUrlList(List<String> list) {
            this.urlList = list;
        }
    }

    @NoProguard
    public static final class ShareReq {
        private String desc;
        private String imgUrl;
        private String link;
        private String title;

        public String getDesc() {
            return this.desc;
        }

        public String getImgUrl() {
            return this.imgUrl;
        }

        public String getLink() {
            return this.link;
        }

        public String getTitle() {
            return this.title;
        }

        public void setDesc(String str) {
            this.desc = str;
        }

        public void setImgUrl(String str) {
            this.imgUrl = str;
        }

        public void setLink(String str) {
            this.link = str;
        }

        public void setTitle(String str) {
            this.title = str;
        }
    }

    @NoProguard
    public static final class ToastReq {
        private int duration = 0;
        private String title;

        public int getDuration() {
            return this.duration;
        }

        public String getTitle() {
            return this.title;
        }

        public void setDuration(int i10) {
            this.duration = i10;
        }

        public void setTitle(String str) {
            this.title = str;
        }
    }

    @NoProguard
    public static final class UrlDescription {
        private String title;
        private String url;

        public String getTitle() {
            return this.title;
        }

        public String getToUrl() {
            return this.url;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public void setToUrl(String str) {
            this.url = str;
        }
    }

    @JSMethod(isOpen = true)
    public void checkAvailability(CheckAvailReq checkAvailReq, JsCallback jsCallback) throws JSONException {
        C6659d.m37882c(f31019b, "checkAvailability begin", true);
        if (checkAvailReq == null || checkAvailReq.getApiList() == null) {
            jsCallback.failure();
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            List<String> apiList = checkAvailReq.getApiList();
            int size = apiList.size();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("apiList:");
            sb2.append(apiList);
            C6659d.m37882c(f31019b, sb2.toString(), false);
            for (int i10 = 0; i10 < size; i10++) {
                String str = apiList.get(i10);
                jSONObject.put(str, C6623b.m37765a().m37766a(str) != null);
            }
            jsCallback.success(jSONObject.toString());
        } catch (JSONException unused) {
            C6659d.m37881b(f31019b, "checkAvailability JSONException", true);
            jsCallback.failure();
        }
    }

    @JSMethod(isOpen = true, name = "close", permission = JsClientApi.Permission.BASE)
    public void close(JsCallback jsCallback) {
        C6659d.m37882c(f31019b, "close Webview", true);
        WebView webView = jsCallback.getWebView();
        if (webView == null) {
            C6659d.m37882c(f31019b, "close Webview null", true);
            jsCallback.failure();
            return;
        }
        Context context = webView.getContext();
        if (context instanceof Activity) {
            ((Activity) context).finish();
        } else {
            jsCallback.failure();
        }
    }

    @JSMethod(isOpen = true, name = "getAppInfo", permission = JsClientApi.Permission.BASE)
    public void getAppInfo(String str, JsCallback jsCallback) throws JSONException, PackageManager.NameNotFoundException {
        C6659d.m37882c(f31019b, "getAppInfo begin", true);
        WebView webView = jsCallback.getWebView();
        if (webView == null) {
            jsCallback.failure();
            return;
        }
        Context context = webView.getContext();
        if (!C6663h.m37903c(context, str)) {
            C6659d.m37881b(f31019b, "getAppInfo package not Installed", true);
            jsCallback.failure(11);
            return;
        }
        String strM37995a = C6691a.m37993a().m37995a(context, str);
        String strM37902b = C6663h.m37902b(context, str);
        int iM37900a = C6663h.m37900a(context, str);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(HwPayConstant.KEY_SIGN, strM37995a);
            jSONObject.put("versionName", strM37902b);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(iM37900a);
            sb2.append("");
            jSONObject.put("versionCode", sb2.toString());
            jsCallback.success(jSONObject.toString());
        } catch (JSONException unused) {
            C6659d.m37882c(f31019b, "getAppInfo JSONException", true);
            jsCallback.failure();
        }
    }

    @JSMethod(isOpen = true)
    public void getBrowserInfo(JsCallback jsCallback) {
        C6659d.m37882c(f31019b, "getBrowserInfo begin", true);
        WebView webView = jsCallback.getWebView();
        if (webView == null) {
            jsCallback.failure();
        } else {
            jsCallback.success(C6691a.m37993a().m37994a(webView.getContext()));
        }
    }

    @JSMethod(isOpen = true, name = "getNetworkType", permission = JsClientApi.Permission.BASE)
    public void getNetworkType(JsCallback jsCallback) throws JSONException {
        C6659d.m37882c(f31019b, "getNetworkType begin", true);
        String strM37887a = C6661f.m37887a();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("networkType", strM37887a);
            jsCallback.success(jSONObject.toString());
        } catch (JSONException unused) {
            jsCallback.failure();
        }
    }

    @JSMethod(isOpen = true, name = "getSystemInfo", permission = JsClientApi.Permission.BASE)
    public void getSystemInfo(JsCallback jsCallback) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(FaqConstants.FAQ_MODEL, C6657b.m37875c());
            jSONObject.put("region", C6657b.m37871a());
            jSONObject.put(FaqConstants.FAQ_EMUI_LANGUAGE, C6657b.m37873b());
            jsCallback.success(jSONObject.toString());
        } catch (JSONException unused) {
            jsCallback.failure();
        }
    }

    @JSMethod(isOpen = true, name = "postChannelMessage", permission = JsClientApi.Permission.BASE)
    public void postChannelMessage(ChannelMessageReq channelMessageReq, JsCallback jsCallback) throws JSONException {
        String string;
        C6659d.m37882c(f31019b, "postChannelMessage begin", true);
        if (channelMessageReq == null) {
            C6659d.m37881b(f31019b, "postChannelMessage JS_CONFIG_RET_CODE_PARSE_PARAM_ERROR", true);
            jsCallback.failure(13);
            return;
        }
        WebView webView = jsCallback.getWebView();
        if (webView == null) {
            jsCallback.failure();
            return;
        }
        String strM37872a = C6657b.m37872a(webView);
        String str = jsCallback.getwebviewId();
        try {
            URL url = new URL(strM37872a);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(url.getProtocol());
            sb2.append("://");
            sb2.append(url.getAuthority());
            string = sb2.toString();
        } catch (MalformedURLException unused) {
            C6659d.m37881b(f31019b, "postChannelMessage MalformedURLException", true);
            jsCallback.failure();
            string = null;
        }
        channelMessageReq.setOrigin(string);
        channelMessageReq.setSource(str);
        C6692a.m37996a().mo37869a((C6692a) channelMessageReq);
    }

    @JSMethod(isOpen = true, name = "preload", permission = JsClientApi.Permission.BASE)
    public void preload(PreloadReq preloadReq, JsCallback jsCallback) throws JSONException {
        C6659d.m37882c(f31019b, "preload begin", true);
        if (preloadReq == null || preloadReq.getUrlList() == null) {
            C6659d.m37881b(f31019b, "preload JS_RET_CODE_PARSE_PARAM_ERROR", true);
            jsCallback.failure(13);
            return;
        }
        WebView webView = jsCallback.getWebView();
        if (webView == null || webView.getContext() == null) {
            jsCallback.failure();
        } else {
            C6651e.m37867a((String[]) preloadReq.getUrlList().toArray(new String[0]), preloadReq.getFlag(), webView.getContext());
        }
    }

    @JSMethod(isOpen = true, name = "share", permission = JsClientApi.Permission.BASE)
    public void share(ShareReq shareReq, JsCallback jsCallback) throws JSONException {
        C6659d.m37882c(f31019b, "share begin", true);
        WebView webView = jsCallback.getWebView();
        if (webView == null) {
            jsCallback.failure();
            return;
        }
        if (shareReq == null) {
            jsCallback.failure(13);
            return;
        }
        String title = shareReq.getTitle();
        String desc = shareReq.getDesc();
        String link = shareReq.getLink();
        if (desc == null) {
            desc = "";
        }
        if (link == null) {
            link = "";
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", title + ":" + desc + " " + link);
        intent.setType(InterfaceC5483d.f25083i);
        try {
            webView.getContext().startActivity(Intent.createChooser(intent, webView.getContext().getString(C6613R.string.jssdk_share)));
        } catch (ActivityNotFoundException unused) {
            C6659d.m37881b(f31019b, "share ActivityNotFoundException", true);
            jsCallback.failure();
        }
    }

    @JSMethod(isOpen = true, name = "showDialog", permission = JsClientApi.Permission.BASE)
    public void showDialog(DialogReq dialogReq, JsCallback jsCallback) throws JSONException {
        if (dialogReq == null) {
            jsCallback.failure(13);
            return;
        }
        WebView webView = jsCallback.getWebView();
        if (webView == null || webView.getContext() == null) {
            jsCallback.failure();
            return;
        }
        List<String> buttons = dialogReq.getButtons();
        if (buttons == null || buttons.size() < 1 || buttons.size() > 2) {
            jsCallback.failure(13);
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(webView.getContext());
        builder.setTitle(dialogReq.getTitle());
        builder.setMessage(dialogReq.getMessage());
        AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.setCanceledOnTouchOutside(false);
        alertDialogCreate.show();
    }

    @JSMethod(isOpen = true, name = "showToast", permission = JsClientApi.Permission.BASE)
    public void showToast(ToastReq toastReq, JsCallback jsCallback) throws JSONException {
        C6659d.m37882c(f31019b, "showToast begin", true);
        if (toastReq == null) {
            C6659d.m37881b(f31019b, "showToast JS_RET_CODE_PARSE_PARAM_ERROR", true);
            jsCallback.failure(13);
            return;
        }
        WebView webView = jsCallback.getWebView();
        if (webView == null || webView.getContext() == null) {
            jsCallback.failure();
        } else {
            Toast.makeText(webView.getContext(), toastReq.getTitle(), toastReq.getDuration() != 1 ? 0 : 1).show();
        }
    }
}
