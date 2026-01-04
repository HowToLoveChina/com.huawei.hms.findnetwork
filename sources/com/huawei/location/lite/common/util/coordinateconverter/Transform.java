package com.huawei.location.lite.common.util.coordinateconverter;

import as.C1016d;

/* loaded from: classes8.dex */
public class Transform {
    static {
        String str;
        try {
            System.loadLibrary("Transform");
            C1016d.m6186f("Transform", "load Transform Library.");
        } catch (SecurityException unused) {
            str = "load Transform Library failed because of SecurityException.";
            C1016d.m6183c("Transform", str);
        } catch (Exception unused2) {
            str = "load Transform Library failed.";
            C1016d.m6183c("Transform", str);
        } catch (UnsatisfiedLinkError unused3) {
            str = "load Transform Library failed because of UnsatisfiedLinkError.";
            C1016d.m6183c("Transform", str);
        }
    }

    public static native double[] gcj02to84Native(double d10, double d11);

    public static native double[] wgs84to02Native(double d10, double d11);
}
