package com.huawei.openalliance.p169ad.constant;

/* loaded from: classes2.dex */
public enum VastVersion {
    VAST_20("2.0"),
    VAST_30("3.0");

    private String version;

    VastVersion(String str) {
        this.version = str;
    }

    public static VastVersion getVerFromStr(String str) {
        for (VastVersion vastVersion : values()) {
            if (vastVersion.getVersion().equals(str)) {
                return vastVersion;
            }
        }
        return VAST_30;
    }

    public String getVersion() {
        return this.version;
    }
}
