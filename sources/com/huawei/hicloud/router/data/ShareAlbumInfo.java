package com.huawei.hicloud.router.data;

import java.io.Serializable;
import java.util.List;

/* loaded from: classes.dex */
public class ShareAlbumInfo implements Serializable {
    private static final long serialVersionUID = 3831639890682854063L;
    private String albumId;
    private String albumName;
    private int coverRotationId;
    private long endEditorTime;
    private String mediaId;
    private List<SmallPictureInfo> smallPicInfos;

    public String getAlbumId() {
        return this.albumId;
    }

    public String getAlbumName() {
        return this.albumName;
    }

    public int getCoverRotationId() {
        return this.coverRotationId;
    }

    public long getEndEditorTime() {
        return this.endEditorTime;
    }

    public String getMediaId() {
        return this.mediaId;
    }

    public List<SmallPictureInfo> getSmallPicInfos() {
        return this.smallPicInfos;
    }

    public void setAlbumId(String str) {
        this.albumId = str;
    }

    public void setAlbumName(String str) {
        this.albumName = str;
    }

    public void setCoverRotationId(int i10) {
        this.coverRotationId = i10;
    }

    public void setEndEditorTime(long j10) {
        this.endEditorTime = j10;
    }

    public void setMediaId(String str) {
        this.mediaId = str;
    }

    public void setSmallPicInfos(List<SmallPictureInfo> list) {
        this.smallPicInfos = list;
    }
}
