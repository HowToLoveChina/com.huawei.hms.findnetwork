package com.huawei.hianalytics.process;

import com.huawei.hianalytics.C4728a1;
import com.huawei.hianalytics.C4731b1;
import com.huawei.hianalytics.C4784i1;
import com.huawei.hianalytics.C4785j;
import com.huawei.hianalytics.C4818z0;
import com.huawei.hianalytics.core.log.HiLog;
import com.tencent.p204mm.opensdk.constants.ConstantsAPI;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes5.dex */
public class HiAnalyticsConfig {

    /* renamed from: a */
    public C4728a1 f21900a;

    public static class Builder {
        public static final String TAG = "HAConfig";
        public String aaidCustom;
        public String androidIdCustom;
        public String channel;
        public String collectURL;
        public Map<String, String> httpHeaders;
        public String imeiCustom;
        public boolean isAndroidIdEnabled;
        public Boolean isEncrypted;
        public boolean isImeiEnabled;
        public boolean isMccMncEnabled;
        public boolean isSNEnabled;
        public boolean isSessionEnabled;
        public boolean isUDIDEnabled;
        public Boolean localEncrypted;
        public String remoteServerUrl;
        public boolean shortLinkEnabled;
        public String snCustom;
        public String udidCustom;
        public Boolean uploadEncrypted;
        public int portLimitSize = 30;
        public int expiryTime = 7;
        public boolean isUUIDEnabled = false;
        public int metricPolicy = 1;
        public int decryptMaxBatchSize = 500;
        public int decryptBatchSize = 500;
        public int decryptBatchSleepTime = 0;

        public Builder() {
            HiLog.setLogAdapter(new C4818z0());
        }

        public HiAnalyticsConfig build() {
            return new HiAnalyticsConfig(this);
        }

        public Builder setAAID(String str) {
            if (!C4785j.m28925a("aaid_CustomSet", str, 4096)) {
                str = "";
            }
            this.aaidCustom = str;
            return this;
        }

        public Builder setAndroidId(String str) {
            if (!C4785j.m28925a("AndroidId_CustomSet", str, 4096)) {
                str = "";
            }
            this.androidIdCustom = str;
            return this;
        }

        public Builder setAutoReportThresholdSize(int i10) {
            this.portLimitSize = Math.min(Math.max(i10, 10), 100);
            return this;
        }

        public Builder setCacheExpireTime(int i10) {
            this.expiryTime = Math.min(Math.max(i10, 2), 7);
            return this;
        }

        public Builder setChannel(String str) {
            String str2 = "";
            if (str == null) {
                str = "";
            }
            if (str.length() > 256) {
                HiLog.m28809i(TAG, "unsupported channel, length() = " + str.length());
            } else {
                str2 = str;
            }
            this.channel = str2;
            return this;
        }

        public Builder setCollectURL(String str) {
            if (!C4784i1.m28894a(str)) {
                HiLog.m28809i(TAG, "setCollectURL: url check failed");
                str = "";
            }
            if (str.endsWith("/") || str.endsWith("\\")) {
                str = str.substring(0, str.length() - 1);
            }
            this.collectURL = str;
            return this;
        }

        @Deprecated
        public Builder setDecryptBatchPolicy(int i10, int i11, int i12) {
            HiLog.m28807d(TAG, "HiAnalyticsConfig.Builder.setDecryptBatchPolicy is executed.");
            this.decryptMaxBatchSize = i10;
            this.decryptBatchSize = i11;
            this.decryptBatchSleepTime = i12;
            return this;
        }

        @Deprecated
        public Builder setEnableAndroidID(boolean z10) {
            this.isAndroidIdEnabled = z10;
            return this;
        }

        @Deprecated
        public Builder setEnableImei(boolean z10) {
            this.isImeiEnabled = z10;
            return this;
        }

        public Builder setEnableMccMnc(boolean z10) {
            this.isMccMncEnabled = z10;
            return this;
        }

        @Deprecated
        public Builder setEnableSN(boolean z10) {
            this.isSNEnabled = z10;
            return this;
        }

        @Deprecated
        public Builder setEnableSession(boolean z10) {
            this.isSessionEnabled = z10;
            return this;
        }

        @Deprecated
        public Builder setEnableUDID(boolean z10) {
            this.isUDIDEnabled = z10;
            return this;
        }

        public Builder setEnableUUID(boolean z10) {
            this.isUUIDEnabled = z10;
            return this;
        }

        public Builder setEncrypted(boolean z10) {
            this.isEncrypted = Boolean.valueOf(z10);
            return this;
        }

        public Builder setHttpHeader(Map<String, String> map) {
            if (map == null) {
                map = new HashMap<>();
            }
            LinkedHashMap<String, String> linkedHashMapM28909a = C4785j.m28909a(map, 50, ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS, ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS, "x-hasdk");
            if (linkedHashMapM28909a != null && linkedHashMapM28909a.size() > 0) {
                this.httpHeaders = linkedHashMapM28909a;
            }
            return this;
        }

        public Builder setImei(String str) {
            if (!C4785j.m28925a("IMEI_CustomSet", str, 4096)) {
                str = "";
            }
            this.imeiCustom = str;
            return this;
        }

        public Builder setLocalEncrypted(boolean z10) {
            this.localEncrypted = Boolean.valueOf(z10);
            return this;
        }

        public Builder setMetricPolicy(int i10) {
            this.metricPolicy = i10;
            return this;
        }

        public Builder setRemoteServerUrl(String str) {
            this.remoteServerUrl = str;
            return this;
        }

        public Builder setSN(String str) {
            if (!C4785j.m28925a("SN_CustomSet", str, 4096)) {
                str = "";
            }
            this.snCustom = str;
            return this;
        }

        public Builder setShortLinkEnabled(boolean z10) {
            this.shortLinkEnabled = z10;
            return this;
        }

        public Builder setUdid(String str) {
            if (!C4785j.m28925a("Udid_CustomSet", str, 4096)) {
                str = "";
            }
            this.udidCustom = str;
            return this;
        }

        public Builder setUploadEncrypted(boolean z10) {
            this.uploadEncrypted = Boolean.valueOf(z10);
            return this;
        }
    }

    public HiAnalyticsConfig(Builder builder) {
        this.f21900a = new C4728a1();
        m28992a(builder);
        m28999b(builder.channel);
        m29003c(builder.collectURL);
        m28996a(builder.isMccMncEnabled);
        m29004c(builder.isSessionEnabled);
        m29008e(builder.portLimitSize);
        m28991a(builder.expiryTime);
        m29007d(builder.isUUIDEnabled);
        m28995a(builder.httpHeaders);
        m28994a(builder.aaidCustom);
        m28993a(builder.isEncrypted);
        m28998b(builder.localEncrypted);
        m29002c(builder.uploadEncrypted);
        m29009f(builder.metricPolicy);
        m29006d(builder.remoteServerUrl);
        m29005d(builder.decryptMaxBatchSize);
        m28997b(builder.decryptBatchSize);
        m29001c(builder.decryptBatchSleepTime);
        m29000b(builder.shortLinkEnabled);
    }

    /* renamed from: a */
    public final void m28994a(String str) {
        this.f21900a.f21640g = str;
    }

    /* renamed from: b */
    public final void m28999b(String str) {
        this.f21900a.f21627b = str;
    }

    /* renamed from: c */
    public final void m29003c(String str) {
        this.f21900a.f21631c = str;
    }

    /* renamed from: d */
    public final void m29005d(int i10) {
        this.f21900a.f21633d = i10;
    }

    /* renamed from: e */
    public final void m29008e(int i10) {
        this.f21900a.f21619a = i10;
    }

    /* renamed from: f */
    public final void m29009f(int i10) {
        this.f21900a.f21629c = i10;
    }

    public HiAnalyticsConfig(HiAnalyticsConfig hiAnalyticsConfig) {
        this.f21900a = new C4728a1(hiAnalyticsConfig.f21900a);
    }

    /* renamed from: a */
    public final void m28991a(int i10) {
        this.f21900a.f21625b = i10;
    }

    /* renamed from: b */
    public final void m28997b(int i10) {
        this.f21900a.f21636e = i10;
    }

    /* renamed from: c */
    public final void m29001c(int i10) {
        this.f21900a.f21638f = i10;
    }

    /* renamed from: d */
    public final void m29006d(String str) {
        this.f21900a.f21642i = str;
    }

    /* renamed from: a */
    public final void m28992a(Builder builder) {
        C4731b1 c4731b1M28744a = this.f21900a.m28744a();
        c4731b1M28744a.f21657a = builder.isImeiEnabled;
        c4731b1M28744a.f21656a = builder.imeiCustom;
        c4731b1M28744a.f21663d = builder.isAndroidIdEnabled;
        c4731b1M28744a.f21660c = builder.androidIdCustom;
        c4731b1M28744a.f21659b = builder.isSNEnabled;
        c4731b1M28744a.f21662d = builder.snCustom;
        c4731b1M28744a.f21661c = builder.isUDIDEnabled;
        c4731b1M28744a.f21658b = builder.udidCustom;
    }

    /* renamed from: b */
    public final void m28998b(Boolean bool) {
        this.f21900a.f21626b = bool;
    }

    /* renamed from: c */
    public final void m29004c(boolean z10) {
        this.f21900a.f21628b = z10;
    }

    /* renamed from: d */
    public void m29007d(boolean z10) {
        this.f21900a.f21632c = z10;
    }

    /* renamed from: b */
    public final void m29000b(boolean z10) {
        this.f21900a.f21635d = z10;
    }

    /* renamed from: c */
    public final void m29002c(Boolean bool) {
        this.f21900a.f21630c = bool;
    }

    /* renamed from: a */
    public final void m28993a(Boolean bool) {
        this.f21900a.f21621a = bool;
    }

    /* renamed from: a */
    public final void m28995a(Map<String, String> map) {
        this.f21900a.f21623a = map;
    }

    /* renamed from: a */
    public final void m28996a(boolean z10) {
        this.f21900a.f21624a = z10;
    }
}
