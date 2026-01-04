package com.huawei.hms.videokit.player;

/* loaded from: classes8.dex */
public class WisePlayerFactoryOptionsExt {
    private String deviceId;
    private boolean enableIPv6;
    private LogConfigInfo logConfigInfo;
    private String serveCountry;
    private boolean serveInForeground;

    public static class Builder {
        private String deviceId;
        private LogConfigInfo logConfigInfo;
        private String serveCountry;
        private boolean enableIPv6 = true;
        private boolean serveInForeground = false;

        public WisePlayerFactoryOptionsExt build() {
            return new WisePlayerFactoryOptionsExt(this);
        }

        public Builder setDeviceId(String str) {
            this.deviceId = str;
            return this;
        }

        public Builder setEnableIPV6(boolean z10) {
            this.enableIPv6 = z10;
            return this;
        }

        public Builder setLogConfigInfo(LogConfigInfo logConfigInfo) {
            this.logConfigInfo = logConfigInfo;
            return this;
        }

        public Builder setServeCountry(String str) {
            this.serveCountry = str;
            return this;
        }

        public Builder setServeInForeground(boolean z10) {
            this.serveInForeground = z10;
            return this;
        }
    }

    private WisePlayerFactoryOptionsExt(Builder builder) {
        this.enableIPv6 = true;
        this.serveInForeground = false;
        this.deviceId = builder.deviceId;
        this.serveCountry = builder.serveCountry;
        this.logConfigInfo = builder.logConfigInfo;
        this.enableIPv6 = builder.enableIPv6;
        this.serveInForeground = builder.serveInForeground;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public LogConfigInfo getLogConfigInfo() {
        return this.logConfigInfo;
    }

    public String getServeCountry() {
        return this.serveCountry;
    }

    public boolean isEnableIPv6() {
        return this.enableIPv6;
    }

    public boolean isServeInForeground() {
        return this.serveInForeground;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setEnableIPv6(boolean z10) {
        this.enableIPv6 = z10;
    }

    public void setLogConfigInfo(LogConfigInfo logConfigInfo) {
        this.logConfigInfo = logConfigInfo;
    }

    public void setServeCountry(String str) {
        this.serveCountry = str;
    }

    public void setServeInForeground(boolean z10) {
        this.serveInForeground = z10;
    }
}
