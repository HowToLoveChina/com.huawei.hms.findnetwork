package com.huawei.hianalytics.process;

import android.content.Context;
import com.huawei.hianalytics.C4728a1;
import com.huawei.hianalytics.C4747d1;
import com.huawei.hianalytics.C4788k;
import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.framework.config.ICallback;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public interface HiAnalyticsInstance {

    public static final class Builder {
        public static final String TAG = "HABuilder";
        public Context mContext;
        public HiAnalyticsConfig maintConf = null;
        public HiAnalyticsConfig operConf = null;

        public Builder(Context context) {
            if (context != null) {
                this.mContext = context.getApplicationContext();
            }
        }

        private void setConf(C4747d1 c4747d1) {
            HiAnalyticsConfig hiAnalyticsConfig = this.operConf;
            if (hiAnalyticsConfig == null) {
                c4747d1.m28825b((HiAnalyticsConfig) null);
            } else {
                c4747d1.f21701a.f21711b = new C4728a1(hiAnalyticsConfig.f21900a);
            }
            HiAnalyticsConfig hiAnalyticsConfig2 = this.maintConf;
            if (hiAnalyticsConfig2 == null) {
                c4747d1.m28821a((HiAnalyticsConfig) null);
            } else {
                c4747d1.f21701a.f21709a = new C4728a1(hiAnalyticsConfig2.f21900a);
            }
        }

        public HiAnalyticsInstance create(String str) {
            return create(str, false);
        }

        public HiAnalyticsInstance refresh(String str) {
            C4747d1 c4747d1M28954a = C4788k.m28953a().m28954a(str);
            if (c4747d1M28954a != null) {
                c4747d1M28954a.refresh(1, this.maintConf);
                c4747d1M28954a.refresh(0, this.operConf);
                return c4747d1M28954a;
            }
            HiLog.m28812w(TAG, "refresh config failed, instance is null. tag: " + str);
            return create(str);
        }

        @Deprecated
        public Builder setDiffConf(HiAnalyticsConfig hiAnalyticsConfig) {
            return this;
        }

        public Builder setMaintConf(HiAnalyticsConfig hiAnalyticsConfig) {
            this.maintConf = hiAnalyticsConfig;
            return this;
        }

        public Builder setOperConf(HiAnalyticsConfig hiAnalyticsConfig) {
            this.operConf = hiAnalyticsConfig;
            return this;
        }

        @Deprecated
        public Builder setPreConfig(HiAnalyticsConfig hiAnalyticsConfig) {
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:207:0x01b7  */
        /* JADX WARN: Removed duplicated region for block: B:214:0x01e4  */
        /* JADX WARN: Removed duplicated region for block: B:217:0x01ff  */
        /* JADX WARN: Removed duplicated region for block: B:218:0x0206  */
        /* JADX WARN: Removed duplicated region for block: B:234:0x0293  */
        /* JADX WARN: Removed duplicated region for block: B:237:0x02a4  */
        /* JADX WARN: Removed duplicated region for block: B:243:0x02d4  */
        /* JADX WARN: Removed duplicated region for block: B:257:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.huawei.hianalytics.process.HiAnalyticsInstance create(java.lang.String r13, boolean r14) {
            /*
                Method dump skipped, instructions count: 726
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.hianalytics.process.HiAnalyticsInstance.Builder.create(java.lang.String, boolean):com.huawei.hianalytics.process.HiAnalyticsInstance");
        }
    }

    void clearData();

    void disableAutoReport();

    String getCollectUrl();

    String getOAID(int i10);

    String getUDID(int i10);

    String getUUID(int i10);

    void newInstanceUUID();

    @Deprecated
    void onBackground(long j10);

    void onEvent(int i10, String str, LinkedHashMap<String, String> linkedHashMap);

    void onEvent(int i10, String str, LinkedHashMap<String, String> linkedHashMap, LinkedHashMap<String, String> linkedHashMap2, LinkedHashMap<String, String> linkedHashMap3);

    void onEvent(int i10, String str, JSONObject jSONObject);

    void onEvent(int i10, List<HaEvent> list);

    @Deprecated
    void onEvent(Context context, String str, String str2);

    void onEvent(String str, LinkedHashMap<String, String> linkedHashMap);

    void onEventSync(int i10, String str, JSONObject jSONObject);

    @Deprecated
    void onForeground(long j10);

    @Deprecated
    void onPause(Context context);

    @Deprecated
    void onPause(Context context, LinkedHashMap<String, String> linkedHashMap);

    @Deprecated
    void onPause(String str, LinkedHashMap<String, String> linkedHashMap);

    void onReport(int i10);

    @Deprecated
    void onReport(Context context, int i10);

    @Deprecated
    void onResume(Context context);

    @Deprecated
    void onResume(Context context, LinkedHashMap<String, String> linkedHashMap);

    @Deprecated
    void onResume(String str, LinkedHashMap<String, String> linkedHashMap);

    void onStreamEvent(int i10, String str, LinkedHashMap<String, String> linkedHashMap);

    void onStreamEvent(int i10, String str, LinkedHashMap<String, String> linkedHashMap, LinkedHashMap<String, String> linkedHashMap2, LinkedHashMap<String, String> linkedHashMap3);

    void onStreamEvent(int i10, String str, JSONObject jSONObject);

    void refresh(int i10, HiAnalyticsConfig hiAnalyticsConfig);

    void setAccountBrandId(String str);

    void setAppBrandId(String str);

    void setAppid(String str);

    void setCallback(ICallback iCallback);

    void setCommonProp(int i10, Map<String, String> map);

    void setHandsetManufacturer(String str);

    void setHansetBrandId(String str);

    void setOAID(int i10, String str);

    void setOAIDTrackingFlag(int i10, boolean z10);

    void setUpid(int i10, String str);
}
