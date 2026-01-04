package com.huawei.openalliance.p169ad.beans.inner;

import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import java.util.Map;

@OuterVisible
/* loaded from: classes8.dex */
public class ApiReqParam {
    private boolean supportTptAd;
    private Map<String, Integer> unsupportedTags;

    @OuterVisible
    public static class Builder {
        private boolean supportTptAd = false;
        private Map<String, Integer> unsupportedTags;

        @OuterVisible
        public Builder() {
        }

        @OuterVisible
        public ApiReqParam build() {
            return new ApiReqParam(this);
        }

        @OuterVisible
        public Builder setSupportTptAd(boolean z10) {
            this.supportTptAd = z10;
            return this;
        }

        @OuterVisible
        public Builder setUnsupportedTags(Map<String, Integer> map) {
            this.unsupportedTags = map;
            return this;
        }
    }

    public ApiReqParam() {
        this.supportTptAd = false;
    }

    /* renamed from: a */
    public boolean m39353a() {
        return this.supportTptAd;
    }

    /* renamed from: b */
    public Map<String, Integer> m39354b() {
        return this.unsupportedTags;
    }

    private ApiReqParam(Builder builder) {
        this.supportTptAd = false;
        this.supportTptAd = builder.supportTptAd;
        this.unsupportedTags = builder.unsupportedTags;
    }
}
