package com.huawei.fastsdk;

import java.text.SimpleDateFormat;
import java.util.Locale;

/* loaded from: classes5.dex */
public class HASDKUtils {

    public interface EventID {
        public static final String BIND_DATA = "QC05";
        public static final String DOWNLOAD_CARD = "QC02";
        public static final String INITIALIZE = "QC01";
        public static final String PRELOAD_CARD = "QC03";
        public static final String RENDER_QUICK_CARD = "QC04";
    }

    public static String buildMSG(int i10) {
        switch (i10) {
            case -1:
                return "sdk not init";
            case 0:
                return "success";
            case 1:
                return "params error";
            case 2:
                return "sdk platform version not match";
            case 3:
                return "server platform higher";
            case 4:
                return "network error";
            case 5:
                return "server data parse error";
            case 6:
                return "server url not config";
            case 7:
                return "card not exist.";
            case 8:
                return "card content parse failed";
            case 9:
                return "app version not support";
            case 10:
                return "instance destroyed";
            case 11:
                return "instance create fail";
            case 12:
                return "data format error";
            case 13:
                return "bind data fail";
            default:
                return "error code is " + i10;
        }
    }

    public static String formatTime(long j10) {
        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'Z", Locale.getDefault()).format(Long.valueOf(j10));
    }
}
