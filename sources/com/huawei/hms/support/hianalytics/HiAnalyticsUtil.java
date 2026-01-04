package com.huawei.hms.support.hianalytics;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.android.SystemUtils;
import com.huawei.hms.common.internal.RequestHeader;
import com.huawei.hms.common.internal.ResponseHeader;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Util;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;

/* loaded from: classes8.dex */
public class HiAnalyticsUtil {

    /* renamed from: a */
    private static final Object f29964a = new Object();

    /* renamed from: b */
    private static HiAnalyticsUtil f29965b;

    /* renamed from: c */
    private static HiAnalyticsUtils f29966c;

    /* renamed from: a */
    private String m36806a(Context context, String str) {
        return "01||" + context.getPackageName() + "|" + Util.getAppId(context) + "|61300303|" + str;
    }

    public static HiAnalyticsUtil getInstance() {
        HiAnalyticsUtil hiAnalyticsUtil;
        synchronized (f29964a) {
            try {
                if (f29965b == null) {
                    f29965b = new HiAnalyticsUtil();
                    f29966c = HiAnalyticsUtils.getInstance();
                }
                hiAnalyticsUtil = f29965b;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return hiAnalyticsUtil;
    }

    public static Map<String, String> getMapFromForegroundResponseHeader(ResponseHeader responseHeader) {
        HashMap map = new HashMap();
        if (responseHeader == null) {
            return map;
        }
        map.put("transId", responseHeader.getTransactionId());
        map.put("appid", responseHeader.getActualAppID());
        map.put("service", responseHeader.getSrvName());
        map.put("apiName", responseHeader.getApiName());
        map.put("package", responseHeader.getPkgName());
        map.put("statusCode", String.valueOf(responseHeader.getStatusCode()));
        map.put("result", String.valueOf(responseHeader.getErrorCode()));
        map.put("errorReason", responseHeader.getErrorReason());
        map.put("callTime", String.valueOf(System.currentTimeMillis()));
        map.put(HiAnalyticsConstant.HaKey.BI_KEY_BASE_VERSION, "6.13.0.303");
        return map;
    }

    public static Map<String, String> getMapFromRequestHeader(ResponseHeader responseHeader) {
        HashMap map = new HashMap();
        if (responseHeader == null) {
            return map;
        }
        map.put("transId", responseHeader.getTransactionId());
        map.put("appid", responseHeader.getActualAppID());
        map.put("service", responseHeader.getSrvName());
        String apiName = responseHeader.getApiName();
        if (!TextUtils.isEmpty(apiName)) {
            String[] strArrSplit = apiName.split("\\.");
            if (strArrSplit.length >= 2) {
                map.put("apiName", strArrSplit[1]);
            }
        }
        map.put("package", responseHeader.getPkgName());
        map.put("statusCode", String.valueOf(responseHeader.getStatusCode()));
        map.put("result", String.valueOf(responseHeader.getErrorCode()));
        map.put("errorReason", responseHeader.getErrorReason());
        map.put("callTime", String.valueOf(System.currentTimeMillis()));
        map.put(HiAnalyticsConstant.HaKey.BI_KEY_BASE_VERSION, "6.13.0.303");
        return map;
    }

    public static String versionCodeToName(String str) {
        return HiAnalyticsUtils.versionCodeToName(str);
    }

    @Deprecated
    public Map<String, String> getMapForBi(Context context, String str) {
        HashMap map = new HashMap();
        String[] strArrSplit = str.split("\\.");
        if (strArrSplit.length >= 2) {
            String str2 = strArrSplit[0];
            String str3 = strArrSplit[1];
            String appId = Util.getAppId(context);
            map.put("transId", TransactionIdCreater.getId(appId, str));
            map.put("appid", appId);
            map.put("service", str2);
            map.put("apiName", str3);
            if (context != null) {
                map.put("package", context.getPackageName());
            }
            map.put("version", "6.13.0.303");
            map.put("callTime", String.valueOf(System.currentTimeMillis()));
        }
        return map;
    }

    public Map<String, String> getMapFromForegroundRequestHeader(RequestHeader requestHeader) {
        HashMap map = new HashMap();
        if (requestHeader == null) {
            return map;
        }
        map.put("transId", requestHeader.getTransactionId());
        map.put("appid", requestHeader.getActualAppID());
        map.put("service", requestHeader.getSrvName());
        map.put("apiName", requestHeader.getApiName());
        map.put("package", requestHeader.getPkgName());
        map.put("callTime", String.valueOf(System.currentTimeMillis()));
        map.put(HiAnalyticsConstant.HaKey.BI_KEY_BASE_VERSION, "6.13.0.303");
        return map;
    }

    @Deprecated
    public boolean hasError() {
        if (SystemUtils.isChinaROM()) {
            return false;
        }
        HMSLog.m36988i("HiAnalyticsUtil", "not ChinaROM ");
        return true;
    }

    public void onBuoyEvent(Context context, String str, String str2) throws JSONException {
        f29966c.onBuoyEvent(context, str, str2);
    }

    public void onEvent(Context context, String str, Map<String, String> map) throws JSONException {
        f29966c.onEvent(context, str, map);
    }

    public void onEvent2(Context context, String str, String str2) throws JSONException {
        f29966c.onEvent2(context, str, str2);
    }

    public void onNewEvent(Context context, String str, Map map) {
        f29966c.onNewEvent(context, str, map);
    }

    public void onEvent(Context context, String str, String str2) throws JSONException {
        if (context != null) {
            onEvent2(context, str, m36806a(context, str2));
        }
    }

    public boolean hasError(Context context) {
        return f29966c.hasError(context);
    }

    public Map<String, String> getMapFromRequestHeader(RequestHeader requestHeader) {
        HashMap map = new HashMap();
        if (requestHeader == null) {
            return map;
        }
        map.put("transId", requestHeader.getTransactionId());
        map.put("appid", requestHeader.getActualAppID());
        map.put("service", requestHeader.getSrvName());
        String apiName = requestHeader.getApiName();
        if (!TextUtils.isEmpty(apiName)) {
            String[] strArrSplit = apiName.split("\\.");
            if (strArrSplit.length >= 2) {
                map.put("apiName", strArrSplit[1]);
            }
        }
        map.put("package", requestHeader.getPkgName());
        map.put("callTime", String.valueOf(System.currentTimeMillis()));
        map.put(HiAnalyticsConstant.HaKey.BI_KEY_BASE_VERSION, "6.13.0.303");
        return map;
    }
}
