package com.huawei.hms.support.hianalytics;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.common.internal.ResponseHeader;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.utils.Util;
import java.util.Map;

/* loaded from: classes8.dex */
public class HiAnalyticsInnerClient extends HiAnalyticsBase {
    public static void reportEntryClient(Context context, String str, String appid, String transactionId, String version) {
        Map<String, String> mapForBi = HiAnalyticsBase.getMapForBi(context, str);
        mapForBi.put("appid", appid);
        if (TextUtils.isEmpty(transactionId)) {
            transactionId = TransactionIdCreater.getId(appid, str);
        }
        mapForBi.put("transId", transactionId);
        mapForBi.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, HiAnalyticsConstant.Direction.REQUEST);
        if (!TextUtils.isEmpty(version)) {
            mapForBi.put("version", HiAnalyticsUtil.versionCodeToName(version));
        }
        mapForBi.put(HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, Util.getSystemProperties("ro.logsystem.usertype", ""));
        HiAnalyticsUtil.getInstance().onNewEvent(context, HiAnalyticsConstant.HMS_SDK_BASE_API_CALLED, mapForBi);
    }

    public static void reportEntryExit(Context context, ResponseHeader responseHeader, String str) {
        HiAnalyticsUtil.getInstance();
        Map<String, String> mapFromRequestHeader = HiAnalyticsUtil.getMapFromRequestHeader(responseHeader);
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, HiAnalyticsConstant.Direction.RESPONSE);
        if (!TextUtils.isEmpty(str)) {
            mapFromRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(str));
        }
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, Util.getSystemProperties("ro.logsystem.usertype", ""));
        HiAnalyticsUtil.getInstance().onNewEvent(context, HiAnalyticsConstant.HMS_SDK_BASE_API_CALLED, mapFromRequestHeader);
    }
}
