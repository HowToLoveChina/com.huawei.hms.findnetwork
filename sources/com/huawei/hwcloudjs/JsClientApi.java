package com.huawei.hwcloudjs;

import android.content.Context;
import android.content.Intent;
import android.webkit.WebView;
import com.huawei.hwcloudjs.api.IAccessToken;
import com.huawei.hwcloudjs.api.ILocDialog;
import com.huawei.hwcloudjs.api.ValidateWhiteListListener;
import com.huawei.hwcloudjs.api.WebviewDownloadListenner;
import com.huawei.hwcloudjs.api.WebviewFileChooserListenner;
import com.huawei.hwcloudjs.core.C6626d;
import com.huawei.hwcloudjs.core.InterfaceC6625c;
import com.huawei.hwcloudjs.core.JSRequest;
import com.huawei.hwcloudjs.core.extkit.C6627a;
import com.huawei.hwcloudjs.core.extkit.InterfaceC6628b;
import com.huawei.hwcloudjs.core.p153a.C6623b;
import com.huawei.hwcloudjs.p151b.C6617a;
import com.huawei.hwcloudjs.p154d.p155a.C6632c;
import com.huawei.hwcloudjs.p154d.p158c.C6642a;
import com.huawei.hwcloudjs.p154d.p158c.p159a.C6643a;
import com.huawei.hwcloudjs.p160e.p161a.C6649c;
import com.huawei.hwcloudjs.p160e.p161a.C6651e;
import com.huawei.hwcloudjs.service.debugtool.SetUrl;
import com.huawei.hwcloudjs.service.hms.C6668a;
import com.huawei.hwcloudjs.service.hms.HmsLiteCoreApi;
import com.huawei.hwcloudjs.service.jsapi.JsCoreApi;
import com.huawei.hwcloudjs.service.jsmsg.C6692a;
import com.huawei.hwcloudjs.service.jsmsg.NativeMsg;
import com.huawei.hwcloudjs.support.enables.INoProguard;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes8.dex */
public class JsClientApi {

    /* renamed from: a */
    private static final Map<String, HWCloudJSBridge> f30727a = new HashMap();

    /* renamed from: b */
    private static Class f30728b;

    /* renamed from: c */
    private static IAccessToken f30729c;

    /* renamed from: d */
    private static Class f30730d;

    /* renamed from: e */
    private static HashMap<String, Class> f30731e;

    /* renamed from: f */
    private static WebviewFileChooserListenner f30732f;

    /* renamed from: g */
    private static WebviewDownloadListenner f30733g;

    /* renamed from: h */
    private static String f30734h;

    /* renamed from: i */
    private static boolean f30735i;

    /* renamed from: j */
    private static int f30736j;

    public interface Permission extends INoProguard {
        public static final String BASE = "com.huawei.javascript.base";
    }

    public static final class SdkOpt {

        /* renamed from: a */
        private boolean f30737a = true;

        public static final class Builder {

            /* renamed from: a */
            private boolean f30738a = true;

            public SdkOpt build() {
                SdkOpt sdkOpt = new SdkOpt();
                sdkOpt.f30737a = this.f30738a;
                return sdkOpt;
            }

            public Builder setShowAuthDlg(boolean z10) {
                this.f30738a = z10;
                return this;
            }
        }
    }

    static {
        registerJsApi(JsCoreApi.class);
    }

    public static void clearUserPermissionSet() {
        C6643a.m37830b().m37831a();
    }

    public static String createApi(WebView webView) {
        C6617a.m37754a(webView.getContext());
        HWCloudJSBridge hWCloudJSBridge = new HWCloudJSBridge();
        hWCloudJSBridge.attach(webView);
        String bridgeId = hWCloudJSBridge.getBridgeId();
        Map<String, HWCloudJSBridge> map = f30727a;
        synchronized (map) {
            map.put(bridgeId, hWCloudJSBridge);
        }
        return bridgeId;
    }

    public static void destroyApi(String str) {
        Map<String, HWCloudJSBridge> map = f30727a;
        synchronized (map) {
            try {
                HWCloudJSBridge hWCloudJSBridgeRemove = map.remove(str);
                if (hWCloudJSBridgeRemove != null) {
                    hWCloudJSBridgeRemove.detach();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        C6626d.m37771a().m37774a(str);
    }

    public static IAccessToken getIAccessTokenClass() {
        return f30729c;
    }

    public static Class getjsActionbarClass() {
        return f30728b;
    }

    public static HashMap<String, Class> getjsInterfacemap() {
        return f30731e;
    }

    public static Class getjsWebviewClass() {
        return f30730d;
    }

    public static void handleActivityPermissionResult(int i10, String[] strArr, int[] iArr) {
        C6642a.a aVar = new C6642a.a();
        aVar.m37826a(i10);
        aVar.m37827a(iArr);
        C6642a.m37825a().mo37869a((C6642a) aVar);
    }

    public static void handleActivityResult(int i10, int i11, Intent intent) {
        C6668a.b bVar = new C6668a.b();
        bVar.m37951a(intent);
        bVar.m37950a(i10);
        bVar.m37953b(i11);
        C6668a.m37944a().mo37869a((C6668a) bVar);
    }

    public static boolean isUrlWhileList(String str) {
        return C6632c.m37786a().m37796a(str);
    }

    public static boolean isneedoriginalUserAgent() {
        return f30735i;
    }

    public static void notifyNativeMsg(NativeMsg nativeMsg) {
        if (nativeMsg != null) {
            C6692a.m37996a().mo37869a((C6692a) nativeMsg);
        }
    }

    public static void notifyNativeMsgToBridge(String str, NativeMsg nativeMsg) {
        if (nativeMsg != null) {
            Map<String, HWCloudJSBridge> map = f30727a;
            synchronized (map) {
                try {
                    HWCloudJSBridge hWCloudJSBridge = map.get(str);
                    if (hWCloudJSBridge != null) {
                        hWCloudJSBridge.onReceive(nativeMsg);
                    }
                } finally {
                }
            }
        }
    }

    public static void preload(String[] strArr, int i10, Context context) {
        C6651e.m37867a(strArr, i10, context);
    }

    public static void registerActionbarClass(Class cls) {
        f30728b = cls;
    }

    public static void registerExtKit(Class<? extends ILocDialog> cls) {
        C6627a.m37776b(InterfaceC6628b.f30812a, cls);
    }

    public static void registerIAccessTokenClass(IAccessToken iAccessToken) {
        f30729c = iAccessToken;
    }

    public static void registerJsApi(Class<? extends JSRequest> cls) throws SecurityException {
        C6623b.m37765a().m37767a(cls);
        if (InterfaceC6625c.class.isAssignableFrom(cls)) {
            C6626d.m37771a().m37773a((Class<? extends InterfaceC6625c>) cls);
        }
    }

    public static void registerUrlWhiteList(List<String> list) {
        if (list != null) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                C6632c.m37786a().m37799b(it.next());
            }
        }
    }

    public static void registerValidateWhiteListListener(ValidateWhiteListListener validateWhiteListListener) {
        C6632c.m37786a();
        C6632c.m37787a(validateWhiteListListener);
    }

    public static void registerWebSettingsMixmode(int i10) {
        f30736j = i10;
    }

    public static void registerWebviewClass(Class cls) {
        f30730d = cls;
    }

    public static void registerWebviewFileChooserListenner(WebviewFileChooserListenner webviewFileChooserListenner) {
        f30732f = webviewFileChooserListenner;
    }

    public static void registerjsInterface(HashMap<String, Class> map) {
        f30731e = map;
    }

    public static void registerwebViewDownLoadListener(WebviewDownloadListenner webviewDownloadListenner) {
        f30733g = webviewDownloadListenner;
    }

    public static void registerwebViewUserAgentString(String str, boolean z10) {
        f30734h = str;
        f30735i = z10;
    }

    public static void setGrsAppName(String str) {
        HmsLiteCoreApi.mGrsAppName = str;
    }

    public static void setJSOption(SdkOpt sdkOpt) {
        if (sdkOpt != null) {
            C6617a.m37755a(sdkOpt.f30737a);
        }
    }

    public static void setJsUrl(String str) {
        C6643a.m37830b().m37834b(str);
    }

    public static void setMaxCacheSize(long j10) {
        C6649c.m37855d().m37857a(j10);
    }

    public static void setUrlToWebView(SetUrl.GetUrlCallBack getUrlCallBack) {
        SetUrl.m37916a().m37917a(getUrlCallBack);
    }

    public static void unRegisterJsApi(String str) {
        C6623b.m37765a().m37768b(str);
    }

    public static int webSettingsMixmode() {
        return f30736j;
    }

    public static WebviewDownloadListenner webViewDownLoadListener() {
        return f30733g;
    }

    public static String webViewUserAgentString() {
        return f30734h;
    }

    public static WebviewFileChooserListenner webviewFileChooserListenner() {
        return f30732f;
    }

    public static String createApi(WebView webView, SdkOpt sdkOpt) {
        if (sdkOpt != null) {
            C6617a.m37755a(sdkOpt.f30737a);
        }
        return createApi(webView);
    }
}
