package com.huawei.fastsdk;

/* loaded from: classes5.dex */
public class CardServerConfig {
    public static final int QUICK_SERVER_MODE_DEV = 2;
    public static final int QUICK_SERVER_MODE_ONLINE = 0;
    public static final int QUICK_SERVER_MODE_TEST = 1;
    private static int mode;
    private static volatile ICardServerUrl serverUrl;

    public static int getMode() {
        return mode;
    }

    public static String getUrl() {
        return serverUrl != null ? serverUrl.getUrl() : "";
    }

    public static void setMode(int i10) {
        mode = i10;
    }

    public static void setUrl(ICardServerUrl iCardServerUrl) {
        serverUrl = iCardServerUrl;
    }

    public static void setUrl(final String str) {
        setUrl(new ICardServerUrl() { // from class: com.huawei.fastsdk.CardServerConfig.1
            @Override // com.huawei.fastsdk.ICardServerUrl
            public String getUrl() {
                return str;
            }
        });
    }
}
