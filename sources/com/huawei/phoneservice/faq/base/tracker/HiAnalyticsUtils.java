package com.huawei.phoneservice.faq.base.tracker;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.huawei.hianalytics.process.HiAnalyticsConfig;
import com.huawei.hianalytics.process.HiAnalyticsInstance;
import com.huawei.hianalytics.process.HiAnalyticsManager;
import com.huawei.hianalytics.util.HiAnalyticTools;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hms.network.file.core.util.Utils;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.ParamConstants;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.phoneservice.faq.base.constants.TrackConstants$Events;
import com.huawei.phoneservice.faq.base.util.FaqLogger;
import com.huawei.phoneservice.faq.base.util.FaqSdk;
import com.huawei.phoneservice.faq.base.util.FaqStringUtil;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;

/* loaded from: classes4.dex */
public class HiAnalyticsUtils {

    /* renamed from: a */
    public static WeakReference<Context> f38682a;

    /* renamed from: b */
    public static boolean f38683b;

    /* renamed from: c */
    public static boolean f38684c;

    /* renamed from: d */
    public static String f38685d;

    @Keep
    public static class Builder {
        private LinkedHashMap<String, String> eventMap = new LinkedHashMap<>();

        public Builder add(String str, String str2) {
            if (!FaqStringUtil.isEmpty(str) && !FaqStringUtil.isEmpty(str2)) {
                this.eventMap.put(str, str2);
            }
            return this;
        }

        public LinkedHashMap<String, String> build() throws Throwable {
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>(this.eventMap);
            if (linkedHashMap.isEmpty()) {
                FaqLogger.m51840e("HiAnalyticsUtils", "map is null while building map");
            }
            return linkedHashMap;
        }

        public Builder setClassName(String str) {
            if (!FaqStringUtil.isEmpty(str)) {
                this.eventMap.put("className", str);
            }
            return this;
        }

        public Builder setErrCode(String str) {
            if (TextUtils.isDigitsOnly(str)) {
                this.eventMap.put(ParamConstants.Param.ERR_CODE, str);
            }
            return this;
        }

        public Builder setErrInfo(String str) {
            this.eventMap.put("errInfo", str);
            return this;
        }

        public Builder setNetType(String str) {
            this.eventMap.put("netType", str);
            return this;
        }

        public Builder setOperation(String str) {
            if (!FaqStringUtil.isEmpty(str)) {
                this.eventMap.put("operation", str);
            }
            return this;
        }

        public Builder setResultFailed() {
            this.eventMap.put("result", NotifyConstants.CommonReportConstants.FAILED);
            return this;
        }

        public Builder setResultSucceed() {
            this.eventMap.put("result", "succeed");
            return this;
        }

        public Builder setTitle(String str) {
            if (!FaqStringUtil.isEmpty(str)) {
                this.eventMap.put("title", str);
            }
            return this;
        }

        public Builder setTotalTime(long j10) throws Throwable {
            if (j10 <= 0) {
                FaqLogger.m51840e("HiAnalyticsUtils", "Wrong totalTime=" + j10);
            }
            this.eventMap.put(Utils.TOTAL_TIME, String.valueOf(j10));
            return this;
        }

        public Builder setType(String str) {
            this.eventMap.put("type", str);
            return this;
        }

        public Builder setUrl(String str) {
            if (!FaqStringUtil.isEmpty(str)) {
                this.eventMap.put("url", str);
            }
            return this;
        }

        public Builder setResultFailed(int i10) {
            this.eventMap.put("result", NotifyConstants.CommonReportConstants.FAILED);
            this.eventMap.put("returnCode", String.valueOf(i10));
            return this;
        }

        public Builder setResultSucceed(int i10) {
            this.eventMap.put("result", "succeed");
            this.eventMap.put("returnCode", String.valueOf(i10));
            return this;
        }
    }

    /* renamed from: a */
    public static void m51803a(Context context, String str, boolean z10, boolean z11) {
        if (m51805c()) {
            FaqLogger.m51840e("HiAnalyticsUtils", "FAQ_DISABLE_HA_REPORT is set to true. Do not init.");
            return;
        }
        f38684c = z10;
        f38683b = z11;
        if (!z10 || z11) {
            HiAnalyticTools.enableLog(context);
        }
        if (!TextUtils.isEmpty(str) && !m51806d()) {
            new HiAnalyticsInstance.Builder(context).setMaintConf(new HiAnalyticsConfig.Builder().setCollectURL(str).build()).create("hiCare");
        }
        FaqLogger.m51837d("HiAnalyticsUtils", "hiAnalyticUrl:%s", str);
        f38685d = context.getPackageName();
        f38682a = new WeakReference<>(context);
    }

    /* renamed from: b */
    public static void m51804b(String str, String str2, String str3) throws Throwable {
        trackEvent(TrackConstants$Events.SDK_GA_EVENT, new Builder().add(Constants.AUTOCONTENT_CATEGORY, str).add(Constants.CONTENT_SERVER_REALM, str2).add("label", str3).build());
    }

    /* renamed from: c */
    public static boolean m51805c() {
        return FaqConstants.DISABLE_HA_REPORT.equals(FaqSdk.getSdk().getSdk(FaqConstants.FAQ_DISABLE_HA_REPORT));
    }

    /* renamed from: d */
    public static boolean m51806d() {
        return HiAnalyticsManager.getInstanceByTag("hiCare") != null;
    }

    @Keep
    public static void trackEvent(String str, LinkedHashMap<String, String> linkedHashMap) throws Throwable {
        String str2;
        if (m51805c()) {
            str2 = "FAQ_DISABLE_HA_REPORT is set to true. Do not report.";
        } else {
            WeakReference<Context> weakReference = f38682a;
            if (weakReference == null || weakReference.get() == null) {
                str2 = "mContext is null, please init() before trackEvent()";
            } else if (linkedHashMap == null || linkedHashMap.isEmpty()) {
                str2 = "param:map is null";
            } else {
                if (!FaqStringUtil.isEmpty(str)) {
                    HiAnalyticsInstance instanceByTag = HiAnalyticsManager.getInstanceByTag("hiCare");
                    if (instanceByTag == null) {
                        return;
                    }
                    linkedHashMap.put("hostApk", f38685d);
                    instanceByTag.onStreamEvent(1, str, linkedHashMap);
                    if (!f38684c || f38683b) {
                        instanceByTag.onReport(1);
                        FaqLogger.m51836d("HiAnalyticsUtils", "onReport");
                        return;
                    }
                    return;
                }
                str2 = "Cannot get type";
            }
        }
        FaqLogger.m51840e("HiAnalyticsUtils", str2);
    }

    @Keep
    public static void trackSdkWebApi(String str, String str2, String str3) throws Throwable {
        trackEvent(TrackConstants$Events.SDK_API, new Builder().setType("sdk_webapi").add("resCode", str).add("reason", str2).setUrl(str3).build());
    }
}
