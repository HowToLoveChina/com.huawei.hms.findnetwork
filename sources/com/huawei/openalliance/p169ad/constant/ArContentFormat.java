package com.huawei.openalliance.p169ad.constant;

import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import java.util.Locale;

/* loaded from: classes2.dex */
public enum ArContentFormat {
    AR_GLB(".glb"),
    AR_GLTF(".gltf");

    private String format;

    ArContentFormat(String str) {
        this.format = str;
    }

    public static boolean isArFormatSupported(String str) {
        if (AbstractC7806cz.m48165b(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase(Locale.getDefault());
        return lowerCase.endsWith(AR_GLB.getFormat()) || lowerCase.endsWith(AR_GLTF.getFormat());
    }

    public String getFormat() {
        return this.format;
    }
}
