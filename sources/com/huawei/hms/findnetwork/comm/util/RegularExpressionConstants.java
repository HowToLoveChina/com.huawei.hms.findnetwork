package com.huawei.hms.findnetwork.comm.util;

/* loaded from: classes8.dex */
public interface RegularExpressionConstants {
    public static final String BIG_APK_VERSION_REGEX = "^(\\d{1,2}\\.){2}\\d{1,2}+$";
    public static final String HARMONY_VERSION_PATTERN = "\\d+\\.\\d+\\.\\d+";
    public static final String MAC_PATTERN = "^[A-F0-9]{2}(:[A-F0-9]{2}){5}$";
    public static final String SN_MASK = "(?<=.{4})\\w(?=.{6})";
    public static final String SN_PATTERN = "\\b[A-Za-z0-9]{4}-[A-Za-z0-9]{3}-\\d{6}-[A-Za-z0-9]{6}\\b";
    public static final String SPECIFIC_APK_VERSION_REGEX = "^(\\d{1,2}\\.){3}\\d{3}$";
    public static final String SRC_TRAN_ID_PATTERN = "^[-+]?[\\d]*$";
    public static final String TAG_VERSION_PATTERN = "[0-9]+(\\.[0-9]+){3}$";
}
