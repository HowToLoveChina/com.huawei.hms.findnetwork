package com.huawei.hianalytics.p101v2;

import android.content.Context;
import com.huawei.hianalytics.C4747d1;
import com.huawei.hianalytics.C4788k;
import com.huawei.hianalytics.RunnableC4753f1;
import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.framework.threadpool.TaskThread;
import com.huawei.hianalytics.process.HiAnalyticsConfig;
import com.huawei.hianalytics.process.HiAnalyticsManager;
import java.util.Map;

@Deprecated
/* loaded from: classes5.dex */
public class HiAnalyticsConf {

    public static class Builder {
        public static final String TAG = "HAConfBuilder";
        public String appid;
        public Context mContext;
        public HiAnalyticsConfig.Builder maintConfigBuilder;
        public HiAnalyticsConfig.Builder operConfigBuilder;

        public Builder(Context context) {
            if (context != null) {
                this.mContext = context.getApplicationContext();
            }
            this.maintConfigBuilder = new HiAnalyticsConfig.Builder();
            this.operConfigBuilder = new HiAnalyticsConfig.Builder();
        }

        public void create() {
            if (this.mContext == null) {
                HiLog.m28808e(TAG, "context is null, create failed");
                return;
            }
            HiAnalyticsConfig hiAnalyticsConfigBuild = this.maintConfigBuilder.build();
            HiAnalyticsConfig hiAnalyticsConfigBuild2 = this.operConfigBuilder.build();
            C4788k.m28953a().m28956a(this.mContext);
            C4747d1 c4747d1 = new C4747d1("_default_config_tag");
            if (c4747d1.f21702a == null) {
                HiLog.m28808e(TAG, "instance is null, create failed. tag: _default_config_tag");
                return;
            }
            c4747d1.m28825b(hiAnalyticsConfigBuild2);
            c4747d1.m28821a(hiAnalyticsConfigBuild);
            C4788k.m28953a().m28955a("_default_config_tag", c4747d1);
            TaskThread.getUpdateThread().addToQueue(new RunnableC4753f1(this.mContext, "_default_config_tag"));
            HiAnalyticsManager.setAppid(this.appid);
        }

        public void refresh(boolean z10) {
            HiAnalyticsConfig hiAnalyticsConfigBuild = this.maintConfigBuilder.build();
            HiAnalyticsConfig hiAnalyticsConfigBuild2 = this.operConfigBuilder.build();
            C4747d1 c4747d1M28954a = C4788k.m28953a().m28954a("_default_config_tag");
            if (c4747d1M28954a == null) {
                HiLog.m28811sw(TAG, "tag: _default_config_tag has no instance. ");
                return;
            }
            c4747d1M28954a.refresh(1, hiAnalyticsConfigBuild);
            c4747d1M28954a.refresh(0, hiAnalyticsConfigBuild2);
            if (z10) {
                C4788k c4788kM28953a = C4788k.m28953a();
                if (c4788kM28953a.f21841a == null) {
                    HiLog.m28811sw("HADM", "sdk not init. tag: _default_config_tag");
                } else {
                    c4788kM28953a.m28954a("_default_config_tag").f21702a.clearCacheDataByTag();
                }
            }
            HiAnalyticsManager.setAppid(this.appid);
        }

        public Builder setAndroidId(String str) {
            this.operConfigBuilder.setAndroidId(str);
            this.maintConfigBuilder.setAndroidId(str);
            return this;
        }

        @Deprecated
        public Builder setAppID(String str) {
            this.appid = str;
            return this;
        }

        @Deprecated
        public Builder setAutoReportThreshold(int i10) {
            return this;
        }

        @Deprecated
        public Builder setCacheExpireTime(int i10) {
            this.operConfigBuilder.setCacheExpireTime(i10);
            this.maintConfigBuilder.setCacheExpireTime(i10);
            return this;
        }

        @Deprecated
        public Builder setChannel(String str) {
            this.operConfigBuilder.setChannel(str);
            this.maintConfigBuilder.setChannel(str);
            return this;
        }

        @Deprecated
        public Builder setCollectURL(int i10, String str) {
            HiAnalyticsConfig.Builder builder;
            if (i10 == 0) {
                builder = this.operConfigBuilder;
            } else {
                if (i10 != 1) {
                    HiLog.m28812w(TAG, "invalid type");
                    return this;
                }
                builder = this.maintConfigBuilder;
            }
            builder.setCollectURL(str);
            return this;
        }

        @Deprecated
        public Builder setDecryptBatchPolicy(int i10, int i11, int i12) {
            this.operConfigBuilder.setDecryptBatchPolicy(i10, i11, i12);
            this.maintConfigBuilder.setDecryptBatchPolicy(i10, i11, i12);
            return this;
        }

        @Deprecated
        public Builder setEnableAndroidID(boolean z10) {
            this.maintConfigBuilder.setEnableAndroidID(z10);
            this.operConfigBuilder.setEnableAndroidID(z10);
            return this;
        }

        @Deprecated
        public Builder setEnableImei(boolean z10) {
            this.operConfigBuilder.setEnableImei(z10);
            this.maintConfigBuilder.setEnableImei(z10);
            return this;
        }

        @Deprecated
        public Builder setEnableMccMnc(boolean z10) {
            this.maintConfigBuilder.setEnableMccMnc(z10);
            this.operConfigBuilder.setEnableMccMnc(z10);
            return this;
        }

        @Deprecated
        public Builder setEnableSN(boolean z10) {
            this.maintConfigBuilder.setEnableSN(z10);
            this.operConfigBuilder.setEnableSN(z10);
            return this;
        }

        @Deprecated
        public Builder setEnableSession(boolean z10) {
            this.operConfigBuilder.setEnableSession(z10);
            return this;
        }

        @Deprecated
        public Builder setEnableUDID(boolean z10) {
            this.maintConfigBuilder.setEnableUDID(z10);
            this.operConfigBuilder.setEnableUDID(z10);
            return this;
        }

        @Deprecated
        public Builder setEnableUUID(boolean z10) {
            this.operConfigBuilder.setEnableUUID(z10);
            this.maintConfigBuilder.setEnableUUID(z10);
            return this;
        }

        @Deprecated
        public Builder setHttpHeader(Map<String, String> map) {
            this.operConfigBuilder.setHttpHeader(map);
            this.maintConfigBuilder.setHttpHeader(map);
            return this;
        }

        public Builder setIMEI(String str) {
            this.operConfigBuilder.setImei(str);
            this.maintConfigBuilder.setImei(str);
            return this;
        }

        public Builder setSN(String str) {
            this.operConfigBuilder.setSN(str);
            this.maintConfigBuilder.setSN(str);
            return this;
        }

        public Builder setUDID(String str) {
            this.operConfigBuilder.setUdid(str);
            this.maintConfigBuilder.setUdid(str);
            return this;
        }
    }
}
