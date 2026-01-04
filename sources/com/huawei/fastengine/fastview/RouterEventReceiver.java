package com.huawei.fastengine.fastview;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.fastengine.fastview.download.utils.log.FastViewLogUtils;
import com.huawei.fastengine.fastview.startfastappengine.bean.Options;
import com.huawei.fastengine.fastview.startfastappengine.bean.RpkPageInfo;
import com.huawei.fastengine.fastview.util.PackageUtil;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class RouterEventReceiver extends BroadcastReceiver {
    public static final String ACTION_ROUTER_EVENT_PUSH_FOR_WIDGET = "ACTION_ROUTER_EVENT_PUSH_FOR_WIDGET";
    private static final String[] BROWSER_PACKAGE_LIST = {Constants.HW_BROWSER_PACKAGE, "com.android.browser", "com.hihonor.browser"};
    public static final String KEY_PACKAGE_NAME = "keyPackageName";
    public static final String KEY_PARAMS = "keyParams";
    public static final String KEY_URI = "keyUri";
    private static final String SETTINGS_HOST = "settings";
    private static final String SETTING_LOCATION_SOURCE_MANAGER = "/location_source_manager";
    private static final String SETTING_PERMISSION_MGR = "/permission_manager";
    public static final String TAG = "RouterEventReceiver";

    private boolean excludedDeeplinkCase(Uri uri) {
        if (uri == null || !"hapjs.org".equals(uri.getHost())) {
            return false;
        }
        String path = uri.getPath();
        return !TextUtils.isEmpty(path) && path.startsWith("/app");
    }

    private String getDefaultBrowserPackage(Context context) {
        for (String str : BROWSER_PACKAGE_LIST) {
            if (PackageUtil.isAppInstalled(context, str)) {
                return str;
            }
        }
        return "";
    }

    private static String getPackageNameFromUri(Uri uri) {
        String host = uri.getHost();
        if (TextUtils.isEmpty(host) || !host.equals("app")) {
            FastViewLogUtils.m28724e(TAG, "getPackageNameFromUri host is wrong!");
            return "";
        }
        String path = uri.getPath();
        if (path == null || path.length() < 2) {
            return "";
        }
        String strSubstring = path.substring(1);
        int iIndexOf = strSubstring.indexOf("/");
        return iIndexOf == -1 ? strSubstring : strSubstring.substring(0, iIndexOf);
    }

    private static String getPageUrlFromUri(Uri uri) {
        String strSubstring;
        int iIndexOf;
        String host = uri.getHost();
        if (TextUtils.isEmpty(host) || !host.equals("app")) {
            FastViewLogUtils.m28724e(TAG, "getPageUrlFromUri host is wrong!");
            return "";
        }
        String path = uri.getPath();
        return (path == null || path.length() < 2 || (iIndexOf = (strSubstring = path.substring(1)).indexOf("/")) == -1) ? "" : strSubstring.substring(iIndexOf);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Object] */
    private static String getQueryParameter(Uri uri) throws JSONException {
        try {
            Set<String> queryParameterNames = uri.getQueryParameterNames();
            if (queryParameterNames == null || queryParameterNames.size() <= 0) {
                return "";
            }
            JSONObject jSONObject = new JSONObject();
            for (String str : queryParameterNames) {
                Object queryParameters = uri.getQueryParameters(str);
                if (queryParameters.size() <= 1) {
                    if (queryParameters.size() > 0) {
                        queryParameters = queryParameters.get(0);
                    } else {
                        FastViewLogUtils.m28726i(TAG, "getQueryParameter Other cases.");
                    }
                }
                jSONObject.put(str, queryParameters);
            }
            return jSONObject.toString();
        } catch (UnsupportedOperationException | JSONException unused) {
            Log.e(TAG, "UnsupportedOperationException.");
            return "";
        }
    }

    private boolean openWebPageByDefault(Context context, Uri uri, String str) {
        String str2;
        if ("http".equals(str) || "https".equals(str)) {
            if (excludedDeeplinkCase(uri)) {
                str2 = "current link type is quick app";
            } else {
                String defaultBrowserPackage = getDefaultBrowserPackage(context);
                if (TextUtils.isEmpty(defaultBrowserPackage)) {
                    str2 = "huawei browser is not be installed";
                } else {
                    Intent intent = new Intent();
                    if (!(context instanceof Activity)) {
                        intent.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
                    }
                    intent.setAction("android.intent.action.VIEW");
                    intent.addFlags(1);
                    intent.setData(uri);
                    intent.setPackage(defaultBrowserPackage);
                    try {
                        context.startActivity(intent);
                        return true;
                    } catch (ActivityNotFoundException unused) {
                        FastViewLogUtils.m28724e(TAG, "open web page by huawei browser failed with activity not founded");
                    }
                }
            }
            FastViewLogUtils.m28722d(TAG, str2);
            return false;
        }
        return false;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) throws JSONException {
        FastViewLogUtils.m28726i(TAG, "RouterEventReceiver onReceive");
        if (ACTION_ROUTER_EVENT_PUSH_FOR_WIDGET.equals(intent.getAction())) {
            Options jumpOptions = FastSDKInnerInterface.getJumpOptions(context);
            String stringExtra = intent.getStringExtra(KEY_PACKAGE_NAME);
            String stringExtra2 = intent.getStringExtra(KEY_URI);
            String stringExtra3 = intent.getStringExtra(KEY_PARAMS);
            FastViewLogUtils.m28722d(TAG, "RouterEventReceiver onReceive uri " + stringExtra2);
            if (!TextUtils.isEmpty(stringExtra2)) {
                if (stringExtra2.startsWith(NavigationUtils.TEL_SCHEMA_PREF)) {
                    NavigationUtils.jumpToTel(context, stringExtra2);
                    return;
                }
                if (stringExtra2.startsWith(NavigationUtils.MAIL_SCHEMA_PREF)) {
                    NavigationUtils.jumpToMail(context, stringExtra2);
                    return;
                }
                if (stringExtra2.startsWith(NavigationUtils.SMS_SCHEMA_PREF)) {
                    NavigationUtils.jumpToSms(context, stringExtra2);
                    return;
                }
                Uri uri = Uri.parse(stringExtra2);
                String scheme = uri.getScheme();
                if ("hap".equalsIgnoreCase(scheme) && (Config.getPackageName().equals(Constants.FAST_APP_PKG) || Config.getPackageName().equals("com.hihonor.fastapp"))) {
                    String path = uri.getPath();
                    if (SETTINGS_HOST.equalsIgnoreCase(uri.getHost()) && SETTING_LOCATION_SOURCE_MANAGER.equalsIgnoreCase(path)) {
                        Intent intent2 = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
                        intent2.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
                        try {
                            context.startActivity(intent2);
                            return;
                        } catch (ActivityNotFoundException unused) {
                            FastViewLogUtils.m28724e(TAG, "ActivityNotFoundException");
                            return;
                        }
                    }
                    stringExtra2 = getPageUrlFromUri(uri);
                    stringExtra = getPackageNameFromUri(uri);
                    stringExtra3 = getQueryParameter(uri);
                } else if (openWebPageByDefault(context, uri, scheme) || NavigationUtils.jumpBySchema(context, stringExtra2, jumpOptions)) {
                    return;
                } else {
                    FastViewLogUtils.m28726i(TAG, "Other cases.");
                }
            }
            if (TextUtils.isEmpty(stringExtra)) {
                FastViewLogUtils.m28724e(TAG, "RouterEventReceiver, packagename is empty!");
                return;
            }
            FastViewLogUtils.m28726i(TAG, "packageName : " + stringExtra);
            FastViewLogUtils.m28722d(TAG, "uri : " + stringExtra2);
            FastViewLogUtils.m28722d(TAG, "params : " + stringExtra3);
            RpkPageInfo rpkPageInfo = new RpkPageInfo();
            rpkPageInfo.setPackageName(stringExtra);
            if (!TextUtils.isEmpty(stringExtra2)) {
                rpkPageInfo.setPageUri(stringExtra2);
            }
            if (!TextUtils.isEmpty(stringExtra3)) {
                rpkPageInfo.setPageParam(stringExtra3);
            }
            rpkPageInfo.setLatestNeed(true);
            rpkPageInfo.setCreateShortCut(FastSDKEngine.getCardShortcutPolicy(context));
            rpkPageInfo.setOptions(jumpOptions);
            OpenFastAppEngine.getInstance().openFastApp(context, rpkPageInfo, false);
        }
    }
}
