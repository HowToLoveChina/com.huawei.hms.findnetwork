package com.huawei.openalliance.p169ad.inter.data;

import com.huawei.openalliance.p169ad.annotations.OuterVisible;

@OuterVisible
/* loaded from: classes2.dex */
public class RewardVerifyConfig {

    /* renamed from: a */
    private String f33664a;

    /* renamed from: b */
    private String f33665b;

    @OuterVisible
    public static final class Builder {

        /* renamed from: a */
        private String f33666a;

        /* renamed from: b */
        private String f33667b;

        @OuterVisible
        public RewardVerifyConfig build() {
            return new RewardVerifyConfig(this);
        }

        @OuterVisible
        public Builder setData(String str) {
            this.f33666a = str;
            return this;
        }

        @OuterVisible
        public Builder setUserId(String str) {
            this.f33667b = str;
            return this;
        }
    }

    @OuterVisible
    private RewardVerifyConfig() {
    }

    @OuterVisible
    private RewardVerifyConfig(Builder builder) {
        if (builder != null) {
            this.f33664a = builder.f33666a;
            this.f33665b = builder.f33667b;
        }
    }

    @OuterVisible
    public String getData() {
        return this.f33664a;
    }

    @OuterVisible
    public String getUserId() {
        return this.f33665b;
    }
}
