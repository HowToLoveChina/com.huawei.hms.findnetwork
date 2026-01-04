package com.huawei.android.hicloud.p088ui.uiextend.bean;

import android.graphics.Movie;
import com.huawei.android.hicloud.p088ui.uiextend.GifImageView;

/* loaded from: classes3.dex */
public class DecodeGifResult {
    public GifImageView gifImageView;
    public Movie movie;
    public int resourceId;

    public DecodeGifResult(Movie movie, GifImageView gifImageView, int i10) {
        this.movie = movie;
        this.gifImageView = gifImageView;
        this.resourceId = i10;
    }
}
