package com.huawei.hicloud.notification.manager;

import android.content.Context;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hms.ads.identifier.AdvertisingIdClient;
import com.huawei.openalliance.p169ad.beans.parameter.RequestOptions;
import java.util.LinkedHashMap;
import p015ak.C0212e0;
import p015ak.C0213f;
import p429kk.C11058a;
import p429kk.C11060c;
import p684un.C13227f;
import p709vj.C13452e;
import p746wn.C13622a;

/* loaded from: classes6.dex */
public class AdSwitchManager {
    private static final String ERROR_CODE = "1008";
    private static final String HUAWEI_AD_SWITCH = "huawei_ad_switch";
    private static final String PERSONALIZATION_AD_SWITCH = "personalization_ad_switch";
    private static final String SP_NAME = "ad_switch";
    private static final String TAG = "AdSwitchManager";
    private static final String THREE_AD_SWITCH = "three_ad_switch";
    private String oaid;
    private boolean settingAdSwitch;
    private boolean dialogSwitchStatus = true;
    private boolean tempdialogSwitchStatus = true;
    private boolean ifSwitchStatusHasBeenRead = false;
    private boolean haveReported = false;

    public static class Holder {
        private static AdSwitchManager instance = new AdSwitchManager();

        private Holder() {
        }
    }

    public static AdSwitchManager getInstance() {
        return Holder.instance;
    }

    private void reportGetAdSwitchFailed(String str, String str2) {
        if (NotifyConstants.CommonReportConstants.SRC_QUERY_AD_LIST.equals(str)) {
            C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("07045"), "07045", C13452e.m80781L().m80971t0());
            c11060cM66626a.m66665u(ERROR_CODE);
            c11060cM66626a.m66635A(str2);
            C13622a.m81968n(C0213f.m1377a(), c11060cM66626a);
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
            linkedHashMap.put("detail", str2);
            C13227f.m79492i1().m79567R("setting_ad_switch_fail", linkedHashMap);
            UBAAnalyze.m29958S("PVC", "setting_ad_switch_fail", "1", "4", linkedHashMap);
        }
    }

    public boolean canDisplayAd(String str) {
        if (!C13452e.m80781L().m80803F0().booleanValue()) {
            NotifyLogger.m29915i(TAG, "no need");
            return true;
        }
        if (C13452e.m80781L().m80795D0()) {
            NotifyLogger.m29916w(TAG, "child, can't display");
            return false;
        }
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            NotifyLogger.m29914e(TAG, "context is null");
            return false;
        }
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(contextM1377a);
            if (advertisingIdInfo == null) {
                NotifyLogger.m29914e(TAG, "info is null");
                return false;
            }
            this.oaid = advertisingIdInfo.getId();
            boolean zIsLimitAdTrackingEnabled = advertisingIdInfo.isLimitAdTrackingEnabled();
            this.settingAdSwitch = zIsLimitAdTrackingEnabled;
            boolean personalizationAdSwitch = getPersonalizationAdSwitch();
            boolean huaweiAdSwitch = getHuaweiAdSwitch();
            NotifyLogger.m29915i(TAG, "settingAd: " + zIsLimitAdTrackingEnabled + ", personalizationAd: " + personalizationAdSwitch + ", huaweiAd: " + huaweiAdSwitch);
            if (!this.haveReported) {
                this.haveReported = true;
                LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
                linkedHashMap.put("switch_status", String.valueOf(zIsLimitAdTrackingEnabled));
                linkedHashMap.put(PERSONALIZATION_AD_SWITCH, String.valueOf(personalizationAdSwitch));
                linkedHashMap.put(HUAWEI_AD_SWITCH, String.valueOf(huaweiAdSwitch));
                linkedHashMap.put("source", str);
                C13227f.m79492i1().m79567R("setting_ad_switch", linkedHashMap);
                UBAAnalyze.m29958S("PVC", "setting_ad_switch", "1", "4", linkedHashMap);
            }
            return !zIsLimitAdTrackingEnabled && personalizationAdSwitch && huaweiAdSwitch;
        } catch (Exception e10) {
            String str2 = str + " get ad info exception: " + e10.toString();
            NotifyLogger.m29914e(TAG, str2);
            reportGetAdSwitchFailed(str, str2);
            return false;
        }
    }

    public void clear() {
        C0212e0.m1353c(SP_NAME);
        this.dialogSwitchStatus = true;
        this.tempdialogSwitchStatus = true;
        this.ifSwitchStatusHasBeenRead = false;
        this.oaid = null;
        this.settingAdSwitch = false;
    }

    public boolean getDialogSwitchStatus() {
        if (!this.ifSwitchStatusHasBeenRead) {
            this.ifSwitchStatusHasBeenRead = true;
            this.dialogSwitchStatus = getPersonalizationAdSwitch();
        }
        return this.dialogSwitchStatus;
    }

    public boolean getHuaweiAdSwitch() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a != null) {
            return C0212e0.m1355e(contextM1377a, SP_NAME, HUAWEI_AD_SWITCH, true);
        }
        NotifyLogger.m29914e(TAG, "context is null");
        return false;
    }

    public String getOaid() {
        return this.oaid;
    }

    public boolean getPersonalizationAdSwitch() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a != null) {
            return C0212e0.m1355e(contextM1377a, SP_NAME, PERSONALIZATION_AD_SWITCH, true);
        }
        NotifyLogger.m29914e(TAG, "context is null");
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RequestOptions.Builder getPpsRequestOptionsBuilder() {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        NotifyLogger.m29915i(TAG, "enter getPpsRequestOptionsBuilder");
        RequestOptions.Builder builder = new RequestOptions.Builder();
        boolean personalizationAdSwitch = getPersonalizationAdSwitch();
        boolean huaweiAdSwitch = getHuaweiAdSwitch();
        boolean threeAdSwitch = getThreeAdSwitch();
        if (C13452e.m80781L().m80803F0().booleanValue()) {
            z13 = personalizationAdSwitch;
            z12 = huaweiAdSwitch;
            z11 = threeAdSwitch;
            if (C13452e.m80781L().m80795D0()) {
                NotifyLogger.m29916w(TAG, "children's account");
                z10 = false;
            }
            builder.setNonPersonalizedAd(Integer.valueOf(!z13));
            builder.setHwNonPersonalizedAd(Integer.valueOf(!z12));
            builder.setThirdNonPersonalizedAd(Integer.valueOf(!z11));
            NotifyLogger.m29915i(TAG, "personalizationAdSwitch: " + z13 + ", huaweiAdSwitch: " + z12 + ", threeAdSwitch: " + z11);
            return builder;
        }
        NotifyLogger.m29915i(TAG, "overseas Account");
        z10 = true;
        boolean z14 = z10 ? 1 : 0;
        z12 = z14 ? 1 : 0;
        z13 = z10;
        z11 = z14;
        builder.setNonPersonalizedAd(Integer.valueOf(!z13));
        builder.setHwNonPersonalizedAd(Integer.valueOf(!z12));
        builder.setThirdNonPersonalizedAd(Integer.valueOf(!z11));
        NotifyLogger.m29915i(TAG, "personalizationAdSwitch: " + z13 + ", huaweiAdSwitch: " + z12 + ", threeAdSwitch: " + z11);
        return builder;
    }

    public boolean getSettingAdSwitch() {
        return this.settingAdSwitch;
    }

    public boolean getTempdialogSwitchStatus() {
        return this.tempdialogSwitchStatus;
    }

    public boolean getThreeAdSwitch() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a != null) {
            return C0212e0.m1355e(contextM1377a, SP_NAME, THREE_AD_SWITCH, true);
        }
        NotifyLogger.m29914e(TAG, "context is null");
        return false;
    }

    public void saveAdSwitch() {
        boolean dialogSwitchStatus = getDialogSwitchStatus();
        NotifyLogger.m29915i(TAG, "agree privacy, set personalization switch: " + dialogSwitchStatus);
        setPersonalizationAdSwitch(dialogSwitchStatus);
        setHuaweiAdSwitch(dialogSwitchStatus);
        setThreeAdSwitch(dialogSwitchStatus);
    }

    public void setDialogSwitchStatus(boolean z10) {
        this.dialogSwitchStatus = z10;
    }

    public void setHuaweiAdSwitch(boolean z10) {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            NotifyLogger.m29914e(TAG, "context is null");
        } else {
            C0212e0.m1366p(contextM1377a, SP_NAME, HUAWEI_AD_SWITCH, z10);
        }
    }

    public void setPersonalizationAdSwitch(boolean z10) {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            NotifyLogger.m29914e(TAG, "context is null");
        } else {
            C0212e0.m1366p(contextM1377a, SP_NAME, PERSONALIZATION_AD_SWITCH, z10);
        }
    }

    public void setTempdialogSwitchStatus(boolean z10) {
        this.tempdialogSwitchStatus = z10;
    }

    public void setThreeAdSwitch(boolean z10) {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            NotifyLogger.m29914e(TAG, "context is null");
        } else {
            C0212e0.m1366p(contextM1377a, SP_NAME, THREE_AD_SWITCH, z10);
        }
    }
}
