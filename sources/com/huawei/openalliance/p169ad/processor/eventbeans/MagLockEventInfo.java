package com.huawei.openalliance.p169ad.processor.eventbeans;

import com.huawei.openalliance.p169ad.annotations.OuterVisible;

@OuterVisible
/* loaded from: classes2.dex */
public class MagLockEventInfo {

    /* renamed from: a */
    private Integer f35387a;

    /* renamed from: b */
    private String f35388b;

    @OuterVisible
    public static final class Builder {

        /* renamed from: a */
        private Integer f35389a;

        /* renamed from: b */
        private String f35390b;

        @OuterVisible
        public MagLockEventInfo build() {
            return new MagLockEventInfo(this);
        }

        @OuterVisible
        public Builder setFailReason(Integer num) {
            this.f35389a = num;
            return this;
        }

        @OuterVisible
        public Builder setPosition(String str) {
            this.f35390b = str;
            return this;
        }
    }

    private MagLockEventInfo(Builder builder) {
        this.f35387a = builder.f35389a;
        this.f35388b = builder.f35390b;
    }

    /* renamed from: a */
    public Integer m46845a() {
        return this.f35387a;
    }

    /* renamed from: b */
    public String m46846b() {
        return this.f35388b;
    }
}
