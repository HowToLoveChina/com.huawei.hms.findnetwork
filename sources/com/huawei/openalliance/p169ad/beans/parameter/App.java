package com.huawei.openalliance.p169ad.beans.parameter;

import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import java.io.Serializable;

@OuterVisible
/* loaded from: classes8.dex */
public class App implements Serializable {
    private static final long serialVersionUID = 30421300;
    private Integer brand;
    private String hostPkgname;
    private String name;
    private String pkgname;
    private String version;

    @OuterVisible
    public static final class Builder {
        private Integer brand;
        private String hostPkgname;
        private String name;
        private String pkgname;
        private String version;

        @OuterVisible
        public App build() {
            return new App(this);
        }

        @OuterVisible
        public Builder setBrand(Integer num) {
            this.brand = num;
            return this;
        }

        @OuterVisible
        public Builder setHostPkgname(String str) {
            this.hostPkgname = str;
            return this;
        }

        @OuterVisible
        public Builder setName(String str) {
            this.name = str;
            return this;
        }

        @OuterVisible
        public Builder setPkgname(String str) {
            this.pkgname = str;
            return this;
        }

        @OuterVisible
        public Builder setVersion(String str) {
            this.version = str;
            return this;
        }
    }

    @OuterVisible
    public App() {
    }

    @OuterVisible
    public App(Builder builder) {
        this.version = builder.version;
        this.name = builder.name;
        this.pkgname = builder.pkgname;
        this.brand = builder.brand;
        this.hostPkgname = builder.hostPkgname;
    }

    @OuterVisible
    public Integer getBrand() {
        return this.brand;
    }

    @OuterVisible
    public String getHostPkgname() {
        return this.hostPkgname;
    }

    @OuterVisible
    public String getName() {
        return this.name;
    }

    @OuterVisible
    public String getPkgname() {
        return this.pkgname;
    }

    @OuterVisible
    public String getVersion() {
        return this.version;
    }

    @OuterVisible
    public void setBrand(Integer num) {
        this.brand = num;
    }

    @OuterVisible
    public void setHostPkgname(String str) {
        this.hostPkgname = str;
    }

    @OuterVisible
    public void setName(String str) {
        this.name = str;
    }

    @OuterVisible
    public void setPkgname(String str) {
        this.pkgname = str;
    }

    @OuterVisible
    public void setVersion(String str) {
        this.version = str;
    }

    @OuterVisible
    public App(String str, String str2, String str3) {
        this.name = str2;
        this.pkgname = str;
        this.version = str3;
    }

    @OuterVisible
    public App(String str, String str2, String str3, Integer num) {
        this.version = str;
        this.name = str2;
        this.pkgname = str3;
        this.brand = num;
    }

    @OuterVisible
    public App(String str, String str2, String str3, String str4) {
        this.name = str2;
        this.pkgname = str;
        this.version = str3;
        this.hostPkgname = str4;
    }
}
