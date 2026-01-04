package com.huawei.hms.videokit.player.bean.content;

/* loaded from: classes8.dex */
public class Picture {

    /* renamed from: a */
    private PictureItem[] f30325a;

    /* renamed from: b */
    private PictureItem[] f30326b;

    public PictureItem[] getHorizontalPoster() {
        return this.f30326b;
    }

    public PictureItem[] getVerticalPoster() {
        return this.f30325a;
    }

    public void setHorizontalPoster(PictureItem[] pictureItemArr) {
        this.f30326b = pictureItemArr;
    }

    public void setVerticalPoster(PictureItem[] pictureItemArr) {
        this.f30325a = pictureItemArr;
    }
}
