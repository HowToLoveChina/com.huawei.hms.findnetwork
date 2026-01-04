package com.huawei.android.hicloud.drive.cloudphoto.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.List;
import ni.C11707b;

/* loaded from: classes3.dex */
public class MediaBatchUpdateResponse extends C11707b {

    @InterfaceC4648p
    private List<SingleErrorMessage> failedMedia;

    @InterfaceC4648p
    private List<Media> media;

    public List<SingleErrorMessage> getFailedMedia() {
        return this.failedMedia;
    }

    public List<Media> getMedia() {
        return this.media;
    }

    public void setFailedMedia(List<SingleErrorMessage> list) {
        this.failedMedia = list;
    }

    public void setMedia(List<Media> list) {
        this.media = list;
    }
}
