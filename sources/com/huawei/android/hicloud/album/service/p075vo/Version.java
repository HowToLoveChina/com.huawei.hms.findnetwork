package com.huawei.android.hicloud.album.service.p075vo;

/* loaded from: classes2.dex */
public class Version {
    private static int aidlVersion;
    private static int galleryVersion;

    public static int getAidlVersion() {
        return aidlVersion;
    }

    public static int getGalleryVersion() {
        return galleryVersion;
    }

    public static boolean isAlbumUpdatedSupportExistAlbumId() {
        return aidlVersion >= 9;
    }

    public static boolean isDropDownloadFileInfo() {
        return aidlVersion >= 8 && galleryVersion >= 1;
    }

    public static boolean isSupportCheckHash() {
        return aidlVersion >= 10;
    }

    public static boolean isSupportClearCloudVersion() {
        return aidlVersion >= 9;
    }

    public static boolean isSupportClearVersionV2() {
        return aidlVersion >= 16;
    }

    public static boolean isSupportCopy() {
        return aidlVersion >= 2;
    }

    public static boolean isSupportDisableResume() {
        return aidlVersion >= 5;
    }

    public static boolean isSupportLowBatterySync() {
        return aidlVersion >= 15;
    }

    public static boolean isSupportMemoryOptimize() {
        return aidlVersion >= 11;
    }

    public static boolean isSupportMobileData() {
        return aidlVersion >= 10 && galleryVersion >= 2;
    }

    public static boolean isSupportPowerControl() {
        return aidlVersion >= 15;
    }

    public static boolean isSupportQueryDeviceInfoList() {
        return aidlVersion >= 13;
    }

    public static boolean isSupportRiskReport() {
        return false;
    }

    public static boolean isSupportShareAlbumQuery() {
        return aidlVersion >= 14;
    }

    public static boolean isSupportTimeStamp() {
        return aidlVersion >= 8;
    }

    public static boolean isSupportUniversalInterface() {
        return aidlVersion >= 8;
    }

    public static void setAidlVersion(int i10) {
        aidlVersion = i10;
    }

    public static void setGalleryVersion(int i10) {
        galleryVersion = i10;
    }
}
