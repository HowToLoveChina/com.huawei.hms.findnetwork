package com.huawei.hicloud.bean;

import cn.C1461a;
import org.json.JSONException;
import org.json.JSONObject;
import p292fn.C9733f;

/* loaded from: classes6.dex */
public class HiCloudSysParamMapCache {
    private static final String TAG = "HiCloudSysParamMapCache";
    private static String firstTimeOverview;
    private static String iapUnsubscribeRetention;
    private static boolean isNpsDisplayPolicy;
    private static String newBusinessModelConfigCache;
    private static String syncFlowControlRetryPolicy;
    private static String syncSuppressionPolicy;

    public static String getFirstTimeOverview() {
        return firstTimeOverview;
    }

    public static String getIapUnsubscribeRetention() {
        return iapUnsubscribeRetention;
    }

    public static String getNewBusinessModelConfig() {
        return newBusinessModelConfigCache;
    }

    public static String getSyncFlowControlRetryPolicy() {
        return syncFlowControlRetryPolicy;
    }

    public static String getSyncSuppressionPolicy() {
        return syncSuppressionPolicy;
    }

    private static boolean isNpsDisplayPolicy(String str) throws JSONException {
        int i10;
        if (str != null) {
            try {
                i10 = new JSONObject(str).getInt("menuRedDot");
            } catch (Exception e10) {
                C1461a.m8358e(TAG, "Exception getPayTypePolicyList :" + e10.toString());
            }
        } else {
            i10 = 0;
        }
        C1461a.m8359i(TAG, "isNpsDisplayPolicy  :" + i10);
        return i10 == 1;
    }

    public static boolean isNpsMenuRedDot() {
        return isNpsDisplayPolicy;
    }

    public static void refreshSysParamMapCache() {
        HiCloudSysParamMap hiCloudSysParamMapM60758q = C9733f.m60705z().m60758q();
        if (hiCloudSysParamMapM60758q == null) {
            return;
        }
        refreshSysParamMapCache(hiCloudSysParamMapM60758q);
    }

    public static void refreshSysParamMapCache(HiCloudSysParamMap hiCloudSysParamMap) {
        if (hiCloudSysParamMap == null) {
            return;
        }
        newBusinessModelConfigCache = hiCloudSysParamMap.getNewBusinessModelConfig();
        syncSuppressionPolicy = hiCloudSysParamMap.getSyncSuppressionPolicy();
        syncFlowControlRetryPolicy = hiCloudSysParamMap.getSyncFlowControlRetryPolicy();
        isNpsDisplayPolicy = isNpsDisplayPolicy(hiCloudSysParamMap.getNpsDisplayPolicy());
        firstTimeOverview = hiCloudSysParamMap.getFirstTimeOverview();
        iapUnsubscribeRetention = hiCloudSysParamMap.getIapUnsubscribeRetention();
    }
}
