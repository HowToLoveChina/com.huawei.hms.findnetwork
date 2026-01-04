package com.huawei.phoneservice.faq.base.util;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import androidx.annotation.Keep;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.huawei.android.hicloud.cloudbackup.process.util.BackupRestoreConstans;
import com.huawei.fastengine.fastview.NavigationUtils;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import mu.C11526c;

/* loaded from: classes4.dex */
public class FaqWebActivityUtil {

    @Keep
    public static final String ACTION_OF_BROWSER = "android.intent.action.VIEW";

    @Keep
    public static final String INTENT_TITLE = "title";

    @Keep
    public static final String INTENT_URL = "url";

    /* renamed from: com.huawei.phoneservice.faq.base.util.FaqWebActivityUtil$a */
    public class C8325a extends TypeToken<List<String>> {
    }

    @Keep
    public static void destroyWeb(WebView webView) {
        if (webView != null) {
            ViewParent parent = webView.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(webView);
            }
            webView.setDownloadListener(null);
            webView.setWebViewClient(null);
            webView.setWebChromeClient(null);
            webView.stopLoading();
            webView.clearHistory();
            webView.clearCache(true);
            webView.removeAllViews();
            webView.destroy();
        }
    }

    @Keep
    public static void goToBrowserWebUrl(Activity activity, String str, boolean z10) throws Throwable {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        try {
            activity.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            FaqLogger.m51840e("FaqWebActivityUtil", "startActivity Exception");
        }
        if (z10) {
            activity.finish();
        }
    }

    @Keep
    public static void initWebView(WebView webView) {
        if (webView != null) {
            FaqLogger.m51836d("initWebView", "");
            webView.getSettings().setAllowFileAccess(false);
            webView.getSettings().setAllowContentAccess(false);
            webView.getSettings().setGeolocationEnabled(false);
            webView.getSettings().setSavePassword(false);
        }
    }

    @Keep
    public static boolean isInWhiteList(String str, Context context) throws Throwable {
        String sdk = FaqSdk.getSdk().getSdk(FaqConstants.FAQ_URL_LOAD_WHITELIST);
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(sdk)) {
            return true;
        }
        String[] feedbackOpenTypeConfig = ModuleConfigUtils.getFeedbackOpenTypeConfig();
        if (feedbackOpenTypeConfig != null && feedbackOpenTypeConfig.length > 1) {
            String str2 = feedbackOpenTypeConfig[1];
            if (!TextUtils.isEmpty(str2)) {
                arrayList.add(str2);
            }
        }
        String string = FaqSharePrefUtil.getString(context, FaqSharePrefUtil.FAQ_IPCC_FILENAME, FaqSharePrefUtil.FAQ_IPCC_KEY, "");
        if (!TextUtils.isEmpty(string)) {
            arrayList.add(string);
        }
        try {
            if (TextUtils.isEmpty(sdk)) {
                return false;
            }
            arrayList.addAll((List) new Gson().fromJson(sdk, new C8325a().getType()));
            return C11526c.m68808e(str, (String[]) arrayList.toArray(new String[0]));
        } catch (Exception unused) {
            FaqLogger.m51840e("FaqWebActivityUtil", "fromJson error");
            return true;
        }
    }

    @Keep
    public static boolean isSafeImagePath(Context context, Uri uri) {
        if (context != null && uri != null && !TextUtils.isEmpty(uri.toString())) {
            String lowerCase = uri.toString().toLowerCase(Locale.ROOT);
            if ((lowerCase.startsWith("file://") || lowerCase.startsWith("content://")) && !lowerCase.contains("./") && !lowerCase.contains("..") && !lowerCase.contains(".\\.\\") && !lowerCase.contains("%00")) {
                String packageName = context.getPackageName();
                if (!lowerCase.contains(BackupRestoreConstans.DATA_PATH + packageName)) {
                    if (!lowerCase.contains(BackupRestoreConstans.DATA_OWNER_PATH + packageName)) {
                        if (!lowerCase.contains("/data/user_de/0/" + packageName)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Keep
    public static boolean isUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("((http|https)://)(([a-zA-Z0-9\\._-]+\\.[a-zA-Z]{2,6})|([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}))(:[0-9]{1,4})*(/[a-zA-Z0-9\\&%_\\./-~-]*)?", 2).matcher(str).find();
    }

    @Keep
    public static void onReceivedSslError(SslErrorHandler sslErrorHandler) {
    }

    @Keep
    public static boolean overrideUrlLoading(String str, Activity activity) throws Throwable {
        if (str == null) {
            return false;
        }
        if (str.startsWith(NavigationUtils.MAIL_SCHEMA_PREF)) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            try {
                activity.startActivity(intent);
            } catch (ActivityNotFoundException unused) {
                FaqLogger.m51840e("FaqWebActivityUtil", "can not open Activity");
            }
            return true;
        }
        if (str.startsWith("file:///")) {
            return false;
        }
        Intent intent2 = new Intent();
        intent2.setAction("android.intent.action.VIEW");
        intent2.setData(Uri.parse(str));
        try {
            activity.startActivity(intent2);
        } catch (ActivityNotFoundException unused2) {
            FaqLogger.m51840e("FaqWebActivityUtil", "can not open in browser");
        }
        return true;
    }

    @Keep
    public static void removeWebViewJavascriptInterface(WebView webView) {
        webView.removeJavascriptInterface("accessibility");
        webView.removeJavascriptInterface("accessibilityTraversal");
        webView.removeJavascriptInterface("searchBoxJavaBridge_");
    }

    @Keep
    public static void startSystemWeb(Context context, String str) throws Throwable {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            FaqLogger.m51840e("FaqWebActivityUtil", "startActivity Exception");
        }
    }
}
