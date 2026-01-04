package com.huawei.phoneservice.faq.base.util;

import android.app.Activity;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.phoneservice.faq.base.entity.FaqSdkServiceUrlResponse;
import com.huawei.phoneservice.faq.base.entity.ModuleConfigResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public final class FaqUtil {
    /* renamed from: a */
    public static String m51889a() throws Throwable {
        String sdk = FaqSdk.getSdk().getSdk(FaqConstants.GRS_URL_CCPC);
        FaqLogger.m51836d("FaqSdk", "getInitCcpcUrl urls " + sdk);
        return sdk;
    }

    /* renamed from: b */
    public static Map<String, String> m51890b(Map<String, String> map) {
        HashMap map2 = new HashMap();
        map2.putAll(map);
        map2.remove(FaqConstants.SDK_URL_HA);
        map2.remove(FaqConstants.SDK_URL_MD);
        map2.remove(FaqConstants.SDK_URL_SGW);
        map2.remove(FaqConstants.SDK_URL_YUN);
        map2.remove(FaqConstants.GRS_URL_CCPC);
        map2.remove(FaqConstants.GRS_URL_SGW);
        map2.remove(FaqConstants.GRS_URL_LOGSERVICE);
        map2.remove(FaqConstants.GRS_URL_DMPA);
        return map2;
    }

    /* renamed from: c */
    public static void m51891c(FaqSdkServiceUrlResponse.ServiceUrl serviceUrl, Map<String, String> map) {
        if (!TextUtils.isEmpty(serviceUrl.m51754d())) {
            map.put(FaqConstants.SDK_URL_HA, serviceUrl.m51754d());
        }
        if (!TextUtils.isEmpty(serviceUrl.m51755e())) {
            map.put(FaqConstants.SDK_URL_MD, serviceUrl.m51755e());
        }
        if (!TextUtils.isEmpty(serviceUrl.m51756f())) {
            map.put(FaqConstants.SDK_URL_SGW, serviceUrl.m51756f());
        }
        if (!TextUtils.isEmpty(serviceUrl.m51757g())) {
            map.put(FaqConstants.SDK_URL_YUN, serviceUrl.m51757g());
        }
        FaqSdk.getSdk().apply();
    }

    /* renamed from: d */
    public static void m51892d(Map<String, String> map, Map<String, String> map2) {
        if (map == null || map2 == null) {
            return;
        }
        String str = map.get(FaqConstants.GRS_SERVICE_KEY_CCPC);
        if (!TextUtils.isEmpty(str)) {
            map2.put(FaqConstants.GRS_URL_CCPC, str);
        }
        String str2 = map.get(FaqConstants.GRS_SERVICE_KEY_SGW);
        if (!TextUtils.isEmpty(str2)) {
            map2.put(FaqConstants.GRS_URL_SGW, str2);
        }
        String str3 = map.get("ROOT");
        if (!TextUtils.isEmpty(str3)) {
            map2.put(FaqConstants.GRS_URL_LOGSERVICE, str3);
        }
        String str4 = map.get(FaqConstants.GRS_SERVICE_KEY_DMPA);
        if (!TextUtils.isEmpty(str4)) {
            map2.put(FaqConstants.GRS_URL_DMPA, str4);
        }
        FaqSdk.getSdk().apply();
    }

    /* renamed from: e */
    public static String m51893e() throws Throwable {
        String sdk = FaqSdk.getSdk().getSdk(FaqConstants.GRS_URL_SGW);
        FaqLogger.m51836d("FaqSdk", "getInitSgwUrl urls " + sdk);
        return sdk;
    }

    @Keep
    public static void genContactInfo(Activity activity, List<ModuleConfigResponse.ModuleListBean> list) {
        String openType;
        String linkAddress = "";
        if (FaqCommonUtils.isEmpty(list)) {
            openType = "";
        } else {
            openType = "";
            for (ModuleConfigResponse.ModuleListBean moduleListBean : list) {
                if ("2".equals(moduleListBean.getModuleCode())) {
                    linkAddress = moduleListBean.getLinkAddress();
                    openType = moduleListBean.getOpenType();
                }
            }
        }
        FaqSharePrefUtil.save(activity, FaqSharePrefUtil.FAQ_IPCC_FILENAME, FaqSharePrefUtil.FAQ_IPCC_KEY, linkAddress);
        FaqSharePrefUtil.save(activity, FaqSharePrefUtil.FAQ_IPCC_FILENAME, FaqSharePrefUtil.FAQ_IPCC_TYPE, openType);
    }

    @Keep
    public static String getBrand() {
        String sdk = FaqSdk.getSdk().getSdk(FaqConstants.FAQ_MODELTYPE);
        return FaqStringUtil.isEmpty(sdk) ? FaqDeviceUtils.getBrand() : sdk;
    }

    @Keep
    public static String getDmpaUrl() throws Throwable {
        String sdk = FaqSdk.getSdk().getSdk(FaqConstants.GRS_URL_DMPA);
        FaqLogger.m51836d("FaqSdk", "getDmpaUrl urls " + sdk);
        return sdk;
    }

    @Keep
    public static String getHaAddress() {
        return FaqSdk.getSdk().getSdk(FaqConstants.SDK_URL_HA);
    }

    @Keep
    public static String getLogserviceUrl() throws Throwable {
        String sdk = FaqSdk.getSdk().getSdk(FaqConstants.GRS_URL_LOGSERVICE);
        FaqLogger.m51836d("FaqSdk", "getLogServiceUrl urls " + sdk);
        return sdk;
    }

    @Keep
    public static String getMdAddress() {
        return FaqSdk.getSdk().getSdk(FaqConstants.SDK_URL_MD);
    }

    @Keep
    public static String getSgwAddress() {
        return FaqSdk.getSdk().getSdk(FaqConstants.SDK_URL_SGW);
    }

    @Keep
    public static String getUrl(String str) {
        StringBuilder sb2;
        String str2;
        if ("Y".equals(FaqSdk.getSdk().getSdk(FaqConstants.FAQ_USE_OLD_DOMAIN))) {
            sb2 = new StringBuilder();
            sb2.append(getMdAddress());
            str2 = "/secured/CCPC/EN/";
        } else {
            sb2 = new StringBuilder();
            sb2.append(getSgwAddress());
            str2 = "/forward/ccpc_gateway_sdk/";
        }
        sb2.append(str2);
        sb2.append(str);
        sb2.append("/1");
        return sb2.toString();
    }

    @Keep
    public static String getYunAddress() {
        return FaqSdk.getSdk().getSdk(FaqConstants.SDK_URL_YUN);
    }
}
