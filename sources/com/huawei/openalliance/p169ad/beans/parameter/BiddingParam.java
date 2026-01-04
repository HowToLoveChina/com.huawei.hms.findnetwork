package com.huawei.openalliance.p169ad.beans.parameter;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6929a;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import java.util.List;

@DataKeep
@OuterVisible
/* loaded from: classes8.dex */
public class BiddingParam {
    private static final String TAG = "BiddingParam";

    @InterfaceC6929a
    private Float bidFloor;
    private String bidFloorCur;
    private List<String> bpkgName;

    @OuterVisible
    public static final class Builder {

        @InterfaceC6929a
        private Float bidFloor;
        private String bidFloorCur;
        private List<String> bpkgName;

        @OuterVisible
        public BiddingParam build() {
            return new BiddingParam(this);
        }

        @OuterVisible
        public Builder setBidFloor(Float f10) {
            this.bidFloor = f10;
            return this;
        }

        @OuterVisible
        public Builder setBidFloorCur(String str) {
            this.bidFloorCur = str;
            return this;
        }

        @OuterVisible
        public Builder setBpkgName(List<String> list) {
            this.bpkgName = list;
            return this;
        }
    }

    @OuterVisible
    public BiddingParam() {
    }

    @OuterVisible
    public BiddingParam(Builder builder) {
        if (builder != null) {
            this.bidFloor = builder.bidFloor;
            this.bidFloorCur = builder.bidFloorCur;
            this.bpkgName = builder.bpkgName;
        }
    }

    @OuterVisible
    public Float getBidFloor() {
        return this.bidFloor;
    }

    @OuterVisible
    public String getBidFloorCur() {
        return this.bidFloorCur;
    }

    @OuterVisible
    public List<String> getBpkgName() {
        return this.bpkgName;
    }

    public String toString() {
        return "BiddingParam{bidFloorCur = " + this.bidFloorCur + ", bpkgName = " + this.bpkgName + '}';
    }
}
