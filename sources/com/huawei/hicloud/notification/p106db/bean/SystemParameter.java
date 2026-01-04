package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class SystemParameter {

    @SerializedName("PowerKitAlbumDownloadMaxCount")
    private int powerKitAlbumDownloadMaxCount;

    @SerializedName("PowerKitAlbumSyncMaxCount")
    private int powerKitAlbumSyncMaxCount;

    @SerializedName("PowerKitDuration")
    private int powerKitDuration;

    @SerializedName("PowerKitMaxCount")
    private int powerKitMaxCount;

    public int getPowerKitAlbumDownloadMaxCount() {
        return this.powerKitAlbumDownloadMaxCount;
    }

    public int getPowerKitAlbumSyncMaxCount() {
        return this.powerKitAlbumSyncMaxCount;
    }

    public int getPowerKitDuration() {
        return this.powerKitDuration;
    }

    public int getPowerKitMaxCount() {
        return this.powerKitMaxCount;
    }

    public void setPowerKitAlbumDownloadMaxCount(int i10) {
        this.powerKitAlbumDownloadMaxCount = i10;
    }

    public void setPowerKitAlbumSyncMaxCount(int i10) {
        this.powerKitAlbumSyncMaxCount = i10;
    }

    public void setPowerKitDuration(int i10) {
        this.powerKitDuration = i10;
    }

    public void setPowerKitMaxCount(int i10) {
        this.powerKitMaxCount = i10;
    }
}
