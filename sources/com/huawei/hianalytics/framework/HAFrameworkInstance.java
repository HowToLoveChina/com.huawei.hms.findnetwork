package com.huawei.hianalytics.framework;

import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.core.storage.IStorageHandler;
import com.huawei.hianalytics.framework.config.ICallback;
import com.huawei.hianalytics.framework.config.ICollectorConfig;
import com.huawei.hianalytics.framework.config.IMandatoryParameters;
import com.huawei.hianalytics.framework.policy.IStoragePolicy;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public interface HAFrameworkInstance {
    public static final String TAG = "HAFrameworkInstance";

    public static final class Builder {
        public ICollectorConfig collectorConfig;
        public IMandatoryParameters parameters;
        public IStorageHandler storageHandler;
        public IStoragePolicy storagePolicy;

        public HAFrameworkInstance build(String str) {
            if (this.parameters == null && C4757d.f21744e.f21745a == null) {
                return null;
            }
            C4757d c4757d = C4757d.f21744e;
            if (c4757d.f21746b.containsKey(str)) {
                HiLog.m28811sw(HAFrameworkInstance.TAG, "serviceTag check failed, TAG: " + str);
                return null;
            }
            ICollectorConfig iCollectorConfig = this.collectorConfig;
            IMandatoryParameters iMandatoryParameters = this.parameters;
            IStorageHandler iStorageHandler = this.storageHandler;
            IStoragePolicy iStoragePolicy = this.storagePolicy;
            synchronized (c4757d) {
                c4757d.f21746b.put(str, iCollectorConfig);
                C4758e c4758e = new C4758e();
                c4758e.f21761a = iStorageHandler;
                c4757d.f21747c.put(str, c4758e);
                c4757d.f21748d.put(str, iStoragePolicy);
                if (c4757d.f21745a == null && iMandatoryParameters != null) {
                    c4757d.f21745a = iMandatoryParameters;
                }
            }
            return new C4754a(str);
        }

        public Builder setCollectorConfig(ICollectorConfig iCollectorConfig) {
            this.collectorConfig = iCollectorConfig;
            return this;
        }

        public Builder setMandatoryParameters(IMandatoryParameters iMandatoryParameters) {
            this.parameters = iMandatoryParameters;
            return this;
        }

        public Builder setStorageHandler(IStorageHandler iStorageHandler) {
            this.storageHandler = iStorageHandler;
            return this;
        }

        public Builder setStoragePolicy(IStoragePolicy iStoragePolicy) {
            this.storagePolicy = iStoragePolicy;
            return this;
        }
    }

    void clearCacheDataAll();

    void clearCacheDataByTag();

    void clearCacheDataByTagType(String str);

    void onEvent(String str, String str2, JSONObject jSONObject, ICallback iCallback);

    void onEvent(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, ICallback iCallback);

    void onEventSync(String str, String str2, JSONObject jSONObject);

    void onReport(String str);

    void onStreamEvent(String str, String str2, JSONObject jSONObject, ICallback iCallback);

    void onStreamEvent(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, ICallback iCallback);
}
