package com.huawei.hms.ads.jsb.inner.data;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.inter.data.PlacementMediaFile;

@DataKeep
/* loaded from: classes8.dex */
class MediaFile {
    private long duration;
    private long fileSize;
    private int height;
    private String mime;
    private Float ratio;
    private String soundSwitch = "y";
    private String url;
    private int width;

    public MediaFile(PlacementMediaFile placementMediaFile) {
        this.width = 0;
        this.height = 0;
        this.mime = placementMediaFile.getMime();
        this.url = placementMediaFile.getUrl();
        this.fileSize = placementMediaFile.getFileSize();
        this.width = placementMediaFile.getWidth();
        this.height = placementMediaFile.getHeight();
        this.ratio = placementMediaFile.m44552d();
        this.duration = placementMediaFile.getDuration();
    }
}
