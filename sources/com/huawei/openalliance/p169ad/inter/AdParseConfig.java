package com.huawei.openalliance.p169ad.inter;

import com.huawei.openalliance.p169ad.annotations.OuterVisible;

@OuterVisible
/* loaded from: classes2.dex */
public class AdParseConfig {

    /* renamed from: a */
    private boolean f33265a;

    /* renamed from: b */
    private boolean f33266b;

    /* renamed from: c */
    private boolean f33267c;

    /* renamed from: d */
    private boolean f33268d;

    /* renamed from: e */
    private boolean f33269e;

    @OuterVisible
    public static final class Builder {

        /* renamed from: a */
        private boolean f33270a = false;

        /* renamed from: b */
        private boolean f33271b = false;

        /* renamed from: c */
        private boolean f33272c = false;

        /* renamed from: d */
        private boolean f33273d = false;

        /* renamed from: e */
        private boolean f33274e = false;

        @OuterVisible
        public AdParseConfig build() {
            return new AdParseConfig(this);
        }

        @OuterVisible
        public Builder setAccelerate(boolean z10) {
            this.f33270a = z10;
            return this;
        }

        @OuterVisible
        public Builder setEnableFullLog(boolean z10) {
            this.f33274e = z10;
            return this;
        }

        @OuterVisible
        public Builder setEncryptInContentRrd(boolean z10) {
            this.f33272c = z10;
            return this;
        }

        @OuterVisible
        public Builder setPreCheckNotifyEnable(boolean z10) {
            this.f33273d = z10;
            return this;
        }

        @OuterVisible
        public Builder setUpdateConfig(boolean z10) {
            this.f33271b = z10;
            return this;
        }
    }

    private AdParseConfig(Builder builder) {
        this.f33265a = builder.f33270a;
        this.f33266b = builder.f33271b;
        this.f33267c = builder.f33272c;
        this.f33268d = builder.f33273d;
        this.f33269e = builder.f33274e;
    }

    /* renamed from: a */
    public boolean m43998a() {
        return this.f33265a;
    }

    /* renamed from: b */
    public boolean m43999b() {
        return this.f33266b;
    }

    /* renamed from: c */
    public boolean m44000c() {
        return this.f33267c;
    }

    /* renamed from: d */
    public boolean m44001d() {
        return this.f33268d;
    }

    /* renamed from: e */
    public boolean m44002e() {
        return this.f33269e;
    }
}
