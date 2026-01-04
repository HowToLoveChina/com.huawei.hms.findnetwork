package org.chromium.net.impl;

/* loaded from: classes9.dex */
public class ImplVersion {
    private static final int API_LEVEL = 17;
    private static final String CRONET_VERSION = "90.0.4430.82";
    private static final String HWHTTP_VERSION = "8.0.6.310";
    private static final String LAST_CHANGE = "3a0b27d9ba1b2fc9de96e8266d4f7de37f3a052c-refs/branch-heads/4430@{#1304}";

    private ImplVersion() {
    }

    public static int getApiLevel() {
        return 17;
    }

    public static String getCronetVersion() {
        return CRONET_VERSION;
    }

    public static String getCronetVersionWithLastChange() {
        return "90.0.4430.82@3a0b27d9";
    }

    public static String getHwhttpVersion() {
        return HWHTTP_VERSION;
    }

    public static String getLastChange() {
        return LAST_CHANGE;
    }
}
