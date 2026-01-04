package com.huawei.hms.ads;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;

@DataKeep
@OuterVisible
/* loaded from: classes8.dex */
public class VideoConfiguration {
    int autoPlayNetwork;
    boolean isMute;

    @OuterVisible
    public static final class Builder {

        /* renamed from: a */
        int f23152a = 0;

        /* renamed from: b */
        boolean f23153b = true;

        @OuterVisible
        public VideoConfiguration build() {
            return new VideoConfiguration(this);
        }

        @OuterVisible
        public Builder setAutoPlayNetwork(int i10) {
            this.f23152a = i10;
            return this;
        }

        @OuterVisible
        public Builder setMute(boolean z10) {
            this.f23153b = z10;
            return this;
        }
    }

    public VideoConfiguration() {
        this.autoPlayNetwork = 0;
        this.isMute = true;
    }

    @OuterVisible
    public int getAutoPlayNetwork() {
        return this.autoPlayNetwork;
    }

    @OuterVisible
    public boolean isMute() {
        return this.isMute;
    }

    public VideoConfiguration(Builder builder) {
        this.autoPlayNetwork = 0;
        this.isMute = true;
        this.autoPlayNetwork = builder.f23152a;
        this.isMute = builder.f23153b;
    }
}
