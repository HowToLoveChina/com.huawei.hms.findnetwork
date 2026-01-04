package com.huawei.hms.videokit.player.bean;

import com.huawei.hms.videokit.player.bean.content.PictureItem;

/* loaded from: classes8.dex */
public class PreviewPicture {
    private PictureItem[] previewPicture;

    public PreviewPicture(PictureItem[] pictureItemArr) {
        this.previewPicture = pictureItemArr;
    }

    public PictureItem[] getPreviewPicture() {
        return this.previewPicture;
    }

    public void setPreviewPicture(PictureItem[] pictureItemArr) {
        this.previewPicture = pictureItemArr;
    }
}
