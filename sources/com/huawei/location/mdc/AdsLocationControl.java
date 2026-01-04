package com.huawei.location.mdc;

import p588qr.C12390b;

/* loaded from: classes8.dex */
public class AdsLocationControl {
    private static final String CONFIG_ITEM_NAME = "gwi";

    public static boolean isMdcControlEnable() {
        AdsLocationConfig adsLocationConfig = (AdsLocationConfig) C12390b.m74456g().m74460d(CONFIG_ITEM_NAME, AdsLocationConfig.class);
        if (adsLocationConfig != null) {
            return adsLocationConfig.isMdcEnable();
        }
        return true;
    }
}
